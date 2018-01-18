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
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.frs.r;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class e {
    private j dCv;
    private CustomMessageListener dPY = new CustomMessageListener(CmdConfigCustom.CMD_BUSINESS_NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.frs.mc.e.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.e(customResponsedMessage);
        }
    };
    private CustomMessageListener dPZ = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.frs.mc.e.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.d(customResponsedMessage);
        }
    };
    private CustomMessageListener dQa = new CustomMessageListener(CmdConfigCustom.CMD_THREAD_NOT_EXIST_WHEN_ENTER_PB) { // from class: com.baidu.tieba.frs.mc.e.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.lQ(e.this.c(customResponsedMessage));
            e.this.dCv.atY().auP().notifyDataSetChanged();
        }
    };
    private CustomMessageListener dQb = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.frs.mc.e.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && e.this.dCv != null && e.this.dCv.atT() != null && e.this.dCv.atT().axQ() != null) {
                String str = (String) customResponsedMessage.getData();
                e.this.e(str, e.this.dCv.atT().axQ().aYE().getBannerListData().getAllAdvertList());
                e.this.f(str, e.this.dCv.atY().getListView().getData());
                e.this.f(str, e.this.dCv.atU().aye().getDataList());
                e.this.dCv.atT().lP(str);
                if (e.this.dCv.atY() != null && e.this.dCv.atY().auP() != null) {
                    e.this.dCv.atY().auP().notifyDataSetChanged();
                }
            }
        }
    };

    public e(j jVar, BdUniqueId bdUniqueId) {
        this.dCv = jVar;
        this.dPZ.setTag(bdUniqueId);
        this.dQb.setTag(bdUniqueId);
        this.dPY.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.dPY);
        MessageManager.getInstance().registerListener(this.dPZ);
        MessageManager.getInstance().registerListener(this.dQb);
        this.dQa.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.dQa);
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
        if (this.dCv != null && this.dCv.atT() != null && this.dCv.atT().axQ() != null) {
            final String c = c(customResponsedMessage);
            if (!StringUtils.isNull(c) && this.dCv.atY() != null && this.dCv.atY().auP() != null) {
                final View childAt = this.dCv.atY().getListView().getChildAt(a(c, this.dCv.atY().getListView()));
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
                            if (e.this.dCv != null && e.this.dCv.atY() != null && e.this.dCv.atY().getListView() != null && e.this.dCv.atY().auP() != null) {
                                e.this.dCv.atY().getListView().removeView(childAt);
                                e.this.lQ(c);
                                e.this.dCv.atY().auP().notifyDataSetChanged();
                            }
                        }
                    });
                    return;
                }
                lQ(c);
                this.dCv.atY().auP().notifyDataSetChanged();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.dCv != null && this.dCv.atT() != null && this.dCv.atT().axQ() != null) {
            JSONObject jSONObject = (JSONObject) customResponsedMessage.getData();
            final String optString = jSONObject.optString("type");
            if (!StringUtils.isNull(optString)) {
                final String optString2 = jSONObject.optString("tid");
                if (this.dCv.atY() != null && this.dCv.atY().auP() != null) {
                    final View childAt = this.dCv.atY().getListView().getChildAt(a(optString, optString2, this.dCv.atY().getListView()));
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
                                if (e.this.dCv.atY() != null && e.this.dCv.atY().auP() != null) {
                                    e.this.dCv.atY().auP().notifyDataSetChanged();
                                }
                            }
                        });
                        return;
                    }
                    aW(optString, optString2);
                    this.dCv.atY().auP().notifyDataSetChanged();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aW(String str, String str2) {
        ArrayList<com.baidu.adp.widget.ListView.i> threadList = this.dCv.atT().axQ().getThreadList();
        a(str, str2, threadList);
        a(str, str2, this.dCv.atY().getListView().getData());
        if (str.equals("ala_frs_stage_live_feed_back_type")) {
            this.dCv.atT().lN(str2);
        } else if (str.equals("ala_frs_demo_hell_live_feed_back_type")) {
            this.dCv.atT().lO(str2);
        }
        if (threadList != null && threadList.size() < 5) {
            this.dCv.VV();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lQ(String str) {
        if (!StringUtils.isNull(str)) {
            ArrayList<com.baidu.adp.widget.ListView.i> threadList = this.dCv.atT().axQ().getThreadList();
            d(str, threadList);
            d(str, this.dCv.atY().getListView().getData());
            this.dCv.atT().lO(str);
            if (threadList != null && threadList.size() < 5) {
                this.dCv.VV();
            }
        }
    }

    private void a(String str, String str2, List<com.baidu.adp.widget.ListView.i> list) {
        if (v.D(list) != 0) {
            ArrayList arrayList = new ArrayList();
            for (com.baidu.adp.widget.ListView.i iVar : list) {
                if (str.equals("ala_frs_stage_live_feed_back_type")) {
                    if (iVar instanceof com.baidu.tieba.tbadkCore.f) {
                        arrayList.add((com.baidu.tieba.tbadkCore.f) iVar);
                    }
                } else if (str.equals("ala_frs_demo_hell_live_feed_back_type") && (iVar instanceof bd)) {
                    bd bdVar = (bd) iVar;
                    if (bdVar.getTid() != null && bdVar.getTid().equals(str2)) {
                        arrayList.add(bdVar);
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
        if (v.D(list) != 0) {
            ArrayList arrayList = new ArrayList();
            for (com.baidu.adp.widget.ListView.i iVar : list) {
                if (iVar instanceof bd) {
                    bd bdVar = (bd) iVar;
                    if (bdVar.getTid() != null && bdVar.getTid().equals(str)) {
                        arrayList.add(bdVar);
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
                if (item instanceof bd) {
                    bd bdVar = (bd) item;
                    if (bdVar.getTid() != null && bdVar.getTid().equals(str2)) {
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
            if (item instanceof bd) {
                bd bdVar = (bd) item;
                if (bdVar.getTid() != null && bdVar.getTid().equals(str)) {
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
                if (next != null && str.equals(next.aJj)) {
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
                    Object RH = ((com.baidu.tieba.InjectPlugin.a) next).RH();
                    if ((RH instanceof AdvertAppInfo) && str.equals(((AdvertAppInfo) RH).aJj)) {
                        it.remove();
                    }
                }
            }
        }
    }
}
