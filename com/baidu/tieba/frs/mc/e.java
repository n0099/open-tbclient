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
    private j dCQ;
    private CustomMessageListener dQt = new CustomMessageListener(CmdConfigCustom.CMD_BUSINESS_NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.frs.mc.e.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.e(customResponsedMessage);
        }
    };
    private CustomMessageListener dQu = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.frs.mc.e.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.d(customResponsedMessage);
        }
    };
    private CustomMessageListener dQv = new CustomMessageListener(CmdConfigCustom.CMD_THREAD_NOT_EXIST_WHEN_ENTER_PB) { // from class: com.baidu.tieba.frs.mc.e.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.lY(e.this.c(customResponsedMessage));
            e.this.dCQ.aud().auU().notifyDataSetChanged();
        }
    };
    private CustomMessageListener dQw = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.frs.mc.e.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && e.this.dCQ != null && e.this.dCQ.atY() != null && e.this.dCQ.atY().axV() != null) {
                String str = (String) customResponsedMessage.getData();
                e.this.e(str, e.this.dCQ.atY().axV().aYJ().getBannerListData().getAllAdvertList());
                e.this.f(str, e.this.dCQ.aud().getListView().getData());
                e.this.f(str, e.this.dCQ.atZ().ayj().getDataList());
                e.this.dCQ.atY().lX(str);
                if (e.this.dCQ.aud() != null && e.this.dCQ.aud().auU() != null) {
                    e.this.dCQ.aud().auU().notifyDataSetChanged();
                }
            }
        }
    };

    public e(j jVar, BdUniqueId bdUniqueId) {
        this.dCQ = jVar;
        this.dQu.setTag(bdUniqueId);
        this.dQw.setTag(bdUniqueId);
        this.dQt.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.dQt);
        MessageManager.getInstance().registerListener(this.dQu);
        MessageManager.getInstance().registerListener(this.dQw);
        this.dQv.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.dQv);
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
        if (this.dCQ != null && this.dCQ.atY() != null && this.dCQ.atY().axV() != null) {
            final String c = c(customResponsedMessage);
            if (!StringUtils.isNull(c) && this.dCQ.aud() != null && this.dCQ.aud().auU() != null) {
                final View childAt = this.dCQ.aud().getListView().getChildAt(a(c, this.dCQ.aud().getListView()));
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
                            if (e.this.dCQ != null && e.this.dCQ.aud() != null && e.this.dCQ.aud().getListView() != null && e.this.dCQ.aud().auU() != null) {
                                e.this.dCQ.aud().getListView().removeView(childAt);
                                e.this.lY(c);
                                e.this.dCQ.aud().auU().notifyDataSetChanged();
                            }
                        }
                    });
                    return;
                }
                lY(c);
                this.dCQ.aud().auU().notifyDataSetChanged();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.dCQ != null && this.dCQ.atY() != null && this.dCQ.atY().axV() != null) {
            JSONObject jSONObject = (JSONObject) customResponsedMessage.getData();
            final String optString = jSONObject.optString("type");
            if (!StringUtils.isNull(optString)) {
                final String optString2 = jSONObject.optString("tid");
                if (this.dCQ.aud() != null && this.dCQ.aud().auU() != null) {
                    final View childAt = this.dCQ.aud().getListView().getChildAt(a(optString, optString2, this.dCQ.aud().getListView()));
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
                                e.this.aV(optString, optString2);
                                childAt.setVisibility(8);
                                if (e.this.dCQ.aud() != null && e.this.dCQ.aud().auU() != null) {
                                    e.this.dCQ.aud().auU().notifyDataSetChanged();
                                }
                            }
                        });
                        return;
                    }
                    aV(optString, optString2);
                    this.dCQ.aud().auU().notifyDataSetChanged();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aV(String str, String str2) {
        ArrayList<com.baidu.adp.widget.ListView.i> threadList = this.dCQ.atY().axV().getThreadList();
        a(str, str2, threadList);
        a(str, str2, this.dCQ.aud().getListView().getData());
        if (str.equals("ala_frs_stage_live_feed_back_type")) {
            this.dCQ.atY().lV(str2);
        } else if (str.equals("ala_frs_demo_hell_live_feed_back_type")) {
            this.dCQ.atY().lW(str2);
        }
        if (threadList != null && threadList.size() < 5) {
            this.dCQ.VX();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lY(String str) {
        if (!StringUtils.isNull(str)) {
            ArrayList<com.baidu.adp.widget.ListView.i> threadList = this.dCQ.atY().axV().getThreadList();
            d(str, threadList);
            d(str, this.dCQ.aud().getListView().getData());
            this.dCQ.atY().lW(str);
            if (threadList != null && threadList.size() < 5) {
                this.dCQ.VX();
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
                if (next != null && str.equals(next.aJm)) {
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
                    Object RJ = ((com.baidu.tieba.InjectPlugin.a) next).RJ();
                    if ((RJ instanceof AdvertAppInfo) && str.equals(((AdvertAppInfo) RJ).aJm)) {
                        it.remove();
                    }
                }
            }
        }
    }
}
