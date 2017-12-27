package com.baidu.tieba.frs.mc;

import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.be;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.frs.r;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class e {
    private CustomMessageListener dLw = new CustomMessageListener(CmdConfigCustom.CMD_BUSINESS_NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.frs.mc.e.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.e(customResponsedMessage);
        }
    };
    private CustomMessageListener dLx = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.frs.mc.e.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.d(customResponsedMessage);
        }
    };
    private CustomMessageListener dLy = new CustomMessageListener(CmdConfigCustom.CMD_THREAD_NOT_EXIST_WHEN_ENTER_PB) { // from class: com.baidu.tieba.frs.mc.e.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.lI(e.this.c(customResponsedMessage));
            e.this.dxU.asV().atM().notifyDataSetChanged();
        }
    };
    private CustomMessageListener dLz = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.frs.mc.e.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && e.this.dxU != null && e.this.dxU.asQ() != null && e.this.dxU.asQ().awN() != null) {
                String str = (String) customResponsedMessage.getData();
                e.this.e(str, e.this.dxU.asQ().awN().aYy().getBannerListData().getAllAdvertList());
                e.this.f(str, e.this.dxU.asV().getListView().getData());
                e.this.f(str, e.this.dxU.asR().axb().getDataList());
                e.this.dxU.asQ().lH(str);
                if (e.this.dxU.asV() != null && e.this.dxU.asV().atM() != null) {
                    e.this.dxU.asV().atM().notifyDataSetChanged();
                }
            }
        }
    };
    private j dxU;

    public e(j jVar, BdUniqueId bdUniqueId) {
        this.dxU = jVar;
        this.dLx.setTag(bdUniqueId);
        this.dLz.setTag(bdUniqueId);
        this.dLw.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.dLw);
        MessageManager.getInstance().registerListener(this.dLx);
        MessageManager.getInstance().registerListener(this.dLz);
        this.dLy.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.dLy);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String c(CustomResponsedMessage customResponsedMessage) {
        if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof JSONObject)) {
            return null;
        }
        return ((JSONObject) customResponsedMessage.getData()).optString("tid");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(CustomResponsedMessage<?> customResponsedMessage) {
        if (this.dxU != null && this.dxU.asQ() != null && this.dxU.asQ().awN() != null) {
            final String c = c(customResponsedMessage);
            if (!StringUtils.isNull(c) && this.dxU.asV() != null && this.dxU.asV().atM() != null) {
                final View childAt = this.dxU.asV().getListView().getChildAt(a(c, this.dxU.asV().getListView()));
                if (childAt != null) {
                    a(childAt, new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.mc.e.1
                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationStart(Animation animation) {
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationRepeat(Animation animation) {
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationEnd(Animation animation) {
                            if (e.this.dxU != null && e.this.dxU.asV() != null && e.this.dxU.asV().getListView() != null && e.this.dxU.asV().atM() != null) {
                                e.this.dxU.asV().getListView().removeView(childAt);
                                e.this.lI(c);
                                e.this.dxU.asV().atM().notifyDataSetChanged();
                            }
                        }
                    });
                    return;
                }
                lI(c);
                this.dxU.asV().atM().notifyDataSetChanged();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.dxU != null && this.dxU.asQ() != null && this.dxU.asQ().awN() != null) {
            JSONObject jSONObject = (JSONObject) customResponsedMessage.getData();
            final String optString = jSONObject.optString("type");
            if (!StringUtils.isNull(optString)) {
                final String optString2 = jSONObject.optString("tid");
                if (this.dxU.asV() != null && this.dxU.asV().atM() != null) {
                    final View childAt = this.dxU.asV().getListView().getChildAt(a(optString, optString2, this.dxU.asV().getListView()));
                    if (childAt != null) {
                        a(childAt, new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.mc.e.2
                            @Override // android.view.animation.Animation.AnimationListener
                            public void onAnimationStart(Animation animation) {
                            }

                            @Override // android.view.animation.Animation.AnimationListener
                            public void onAnimationRepeat(Animation animation) {
                            }

                            @Override // android.view.animation.Animation.AnimationListener
                            public void onAnimationEnd(Animation animation) {
                                e.this.aW(optString, optString2);
                                childAt.setVisibility(8);
                                if (e.this.dxU.asV() != null && e.this.dxU.asV().atM() != null) {
                                    e.this.dxU.asV().atM().notifyDataSetChanged();
                                }
                            }
                        });
                        return;
                    }
                    aW(optString, optString2);
                    this.dxU.asV().atM().notifyDataSetChanged();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aW(String str, String str2) {
        ArrayList<com.baidu.adp.widget.ListView.i> threadList = this.dxU.asQ().awN().getThreadList();
        a(str, str2, threadList);
        a(str, str2, this.dxU.asV().getListView().getData());
        if (str.equals("ala_frs_stage_live_feed_back_type")) {
            this.dxU.asQ().lF(str2);
        } else if (str.equals("ala_frs_demo_hell_live_feed_back_type")) {
            this.dxU.asQ().lG(str2);
        }
        if (threadList != null && threadList.size() < 5) {
            this.dxU.Wh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lI(String str) {
        if (!StringUtils.isNull(str)) {
            ArrayList<com.baidu.adp.widget.ListView.i> threadList = this.dxU.asQ().awN().getThreadList();
            d(str, threadList);
            d(str, this.dxU.asV().getListView().getData());
            this.dxU.asQ().lG(str);
            if (threadList != null && threadList.size() < 5) {
                this.dxU.Wh();
            }
        }
    }

    private void a(String str, String str2, List<com.baidu.adp.widget.ListView.i> list) {
        if (v.F(list) != 0) {
            ArrayList arrayList = new ArrayList();
            for (com.baidu.adp.widget.ListView.i iVar : list) {
                if (str.equals("ala_frs_stage_live_feed_back_type")) {
                    if (iVar instanceof com.baidu.tieba.tbadkCore.f) {
                        arrayList.add((com.baidu.tieba.tbadkCore.f) iVar);
                    }
                } else if (str.equals("ala_frs_demo_hell_live_feed_back_type") && (iVar instanceof be)) {
                    be beVar = (be) iVar;
                    if (beVar.getTid() != null && beVar.getTid().equals(str2)) {
                        arrayList.add(beVar);
                    }
                }
            }
            list.removeAll(arrayList);
            com.baidu.adp.widget.ListView.i iVar2 = (com.baidu.adp.widget.ListView.i) v.f(list, 0);
            if (iVar2 instanceof r) {
                list.remove(iVar2);
            }
        }
    }

    private void d(String str, List<com.baidu.adp.widget.ListView.i> list) {
        if (v.F(list) != 0) {
            ArrayList arrayList = new ArrayList();
            for (com.baidu.adp.widget.ListView.i iVar : list) {
                if (iVar instanceof be) {
                    be beVar = (be) iVar;
                    if (beVar.getTid() != null && beVar.getTid().equals(str)) {
                        arrayList.add(beVar);
                    }
                }
            }
            list.removeAll(arrayList);
            com.baidu.adp.widget.ListView.i iVar2 = (com.baidu.adp.widget.ListView.i) v.f(list, 0);
            if (iVar2 instanceof r) {
                list.remove(iVar2);
            }
        }
    }

    private int a(String str, String str2, BdTypeRecyclerView bdTypeRecyclerView) {
        int i;
        int headerViewsCount = bdTypeRecyclerView.getHeaderViewsCount();
        int firstVisiblePosition = bdTypeRecyclerView.getFirstVisiblePosition();
        if (str.equals("ala_frs_stage_live_feed_back_type")) {
            i = 0;
            for (int i2 = 0; i2 < bdTypeRecyclerView.getAdapter().getItemCount(); i2++) {
                if (bdTypeRecyclerView.getItem(i2) instanceof com.baidu.tieba.tbadkCore.f) {
                    i = i2;
                }
            }
        } else if (str.equals("ala_frs_demo_hell_live_feed_back_type")) {
            int i3 = 0;
            for (int i4 = 0; i4 < bdTypeRecyclerView.getAdapter().getItemCount(); i4++) {
                com.baidu.adp.widget.ListView.i item = bdTypeRecyclerView.getItem(i4);
                if (item instanceof be) {
                    be beVar = (be) item;
                    if (beVar.getTid() != null && beVar.getTid().equals(str2)) {
                        i3 = i4;
                    }
                }
            }
            i = i3;
        } else {
            i = 0;
        }
        return (i + headerViewsCount) - firstVisiblePosition;
    }

    private int a(String str, BdTypeRecyclerView bdTypeRecyclerView) {
        int headerViewsCount = bdTypeRecyclerView.getHeaderViewsCount();
        int firstVisiblePosition = bdTypeRecyclerView.getFirstVisiblePosition();
        int i = 0;
        for (int i2 = 0; i2 < bdTypeRecyclerView.getAdapter().getItemCount(); i2++) {
            com.baidu.adp.widget.ListView.i item = bdTypeRecyclerView.getItem(i2);
            if (item instanceof be) {
                be beVar = (be) item;
                if (beVar.getTid() != null && beVar.getTid().equals(str)) {
                    i = i2;
                }
            }
        }
        return (i + headerViewsCount) - firstVisiblePosition;
    }

    private void a(final View view, Animation.AnimationListener animationListener) {
        final int measuredHeight = view.getMeasuredHeight();
        Animation animation = new Animation() { // from class: com.baidu.tieba.frs.mc.e.6
            @Override // android.view.animation.Animation
            protected void applyTransformation(float f, Transformation transformation) {
                view.getLayoutParams().height = measuredHeight - ((int) (measuredHeight * f));
                view.requestLayout();
            }

            @Override // android.view.animation.Animation
            public boolean willChangeBounds() {
                return true;
            }
        };
        animation.setAnimationListener(animationListener);
        animation.setDuration(300L);
        view.startAnimation(animation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(String str, List<AdvertAppInfo> list) {
        if (list != null && list.size() > 0 && !TextUtils.isEmpty(str)) {
            Iterator<AdvertAppInfo> it = list.iterator();
            while (it.hasNext()) {
                AdvertAppInfo next = it.next();
                if (next != null && str.equals(next.aJl)) {
                    it.remove();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(String str, List<com.baidu.adp.widget.ListView.i> list) {
        if (list != null && list.size() > 0 && !TextUtils.isEmpty(str)) {
            Iterator<com.baidu.adp.widget.ListView.i> it = list.iterator();
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.i next = it.next();
                if (next instanceof com.baidu.tieba.InjectPlugin.a) {
                    Object RT = ((com.baidu.tieba.InjectPlugin.a) next).RT();
                    if ((RT instanceof AdvertAppInfo) && str.equals(((AdvertAppInfo) RT).aJl)) {
                        it.remove();
                    }
                }
            }
        }
    }
}
