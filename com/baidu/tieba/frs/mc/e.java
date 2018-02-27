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
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.frs.r;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class e {
    private j dFB;
    private CustomMessageListener dTs = new CustomMessageListener(2921324) { // from class: com.baidu.tieba.frs.mc.e.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.i(customResponsedMessage);
        }
    };
    private CustomMessageListener dTt = new CustomMessageListener(2016488) { // from class: com.baidu.tieba.frs.mc.e.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.h(customResponsedMessage);
        }
    };
    private CustomMessageListener dTu = new CustomMessageListener(2016553) { // from class: com.baidu.tieba.frs.mc.e.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.mj(e.this.g(customResponsedMessage));
            e.this.dFB.auS().avV().notifyDataSetChanged();
        }
    };
    private CustomMessageListener dTv = new CustomMessageListener(2016331) { // from class: com.baidu.tieba.frs.mc.e.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && e.this.dFB != null && e.this.dFB.auN() != null && e.this.dFB.auN().ayU() != null) {
                String str = (String) customResponsedMessage.getData();
                e.this.f(str, e.this.dFB.auN().ayU().bar().getBannerListData().getAllAdvertList());
                e.this.g(str, e.this.dFB.auS().getListView().getData());
                e.this.g(str, e.this.dFB.auO().azk().getDataList());
                e.this.dFB.auN().mi(str);
                if (e.this.dFB.auS() != null && e.this.dFB.auS().avV() != null) {
                    e.this.dFB.auS().avV().notifyDataSetChanged();
                }
            }
        }
    };

    public e(j jVar, BdUniqueId bdUniqueId) {
        this.dFB = jVar;
        this.dTt.setTag(bdUniqueId);
        this.dTv.setTag(bdUniqueId);
        this.dTs.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.dTs);
        MessageManager.getInstance().registerListener(this.dTt);
        MessageManager.getInstance().registerListener(this.dTv);
        this.dTu.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.dTu);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String g(CustomResponsedMessage customResponsedMessage) {
        if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof JSONObject)) {
            return null;
        }
        return ((JSONObject) customResponsedMessage.getData()).optString("tid");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(CustomResponsedMessage<?> customResponsedMessage) {
        if (this.dFB != null && this.dFB.auN() != null && this.dFB.auN().ayU() != null) {
            final String g = g(customResponsedMessage);
            if (!StringUtils.isNull(g) && this.dFB.auS() != null && this.dFB.auS().avV() != null) {
                final View childAt = this.dFB.auS().getListView().getChildAt(a(g, this.dFB.auS().getListView()));
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
                            if (e.this.dFB != null && e.this.dFB.auS() != null && e.this.dFB.auS().getListView() != null && e.this.dFB.auS().avV() != null) {
                                e.this.dFB.auS().getListView().removeView(childAt);
                                e.this.mj(g);
                                e.this.dFB.auS().avV().notifyDataSetChanged();
                            }
                        }
                    });
                    return;
                }
                mj(g);
                this.dFB.auS().avV().notifyDataSetChanged();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.dFB != null && this.dFB.auN() != null && this.dFB.auN().ayU() != null) {
            JSONObject jSONObject = (JSONObject) customResponsedMessage.getData();
            final String optString = jSONObject.optString("type");
            if (!StringUtils.isNull(optString)) {
                final String optString2 = jSONObject.optString("tid");
                if (this.dFB.auS() != null && this.dFB.auS().avV() != null) {
                    final View childAt = this.dFB.auS().getListView().getChildAt(a(optString, optString2, this.dFB.auS().getListView()));
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
                                if (e.this.dFB.auS() != null && e.this.dFB.auS().avV() != null) {
                                    e.this.dFB.auS().avV().notifyDataSetChanged();
                                }
                            }
                        });
                        return;
                    }
                    aW(optString, optString2);
                    this.dFB.auS().avV().notifyDataSetChanged();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aW(String str, String str2) {
        ArrayList<com.baidu.adp.widget.ListView.i> threadList = this.dFB.auN().ayU().getThreadList();
        a(str, str2, threadList);
        a(str, str2, this.dFB.auS().getListView().getData());
        if (str.equals("ala_frs_stage_live_feed_back_type")) {
            this.dFB.auN().mg(str2);
        } else if (str.equals("ala_frs_demo_hell_live_feed_back_type")) {
            this.dFB.auN().mh(str2);
        }
        if (threadList != null && threadList.size() < 5) {
            this.dFB.WN();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mj(String str) {
        if (!StringUtils.isNull(str)) {
            ArrayList<com.baidu.adp.widget.ListView.i> threadList = this.dFB.auN().ayU().getThreadList();
            e(str, threadList);
            e(str, this.dFB.auS().getListView().getData());
            this.dFB.auN().mh(str);
            if (threadList != null && threadList.size() < 5) {
                this.dFB.WN();
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

    private void e(String str, List<com.baidu.adp.widget.ListView.i> list) {
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
    public void f(String str, List<AdvertAppInfo> list) {
        if (list != null && list.size() > 0 && !TextUtils.isEmpty(str)) {
            Iterator<AdvertAppInfo> it = list.iterator();
            while (it.hasNext()) {
                AdvertAppInfo next = it.next();
                if (next != null && str.equals(next.aKu)) {
                    it.remove();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(String str, List<com.baidu.adp.widget.ListView.i> list) {
        if (list != null && list.size() > 0 && !TextUtils.isEmpty(str)) {
            Iterator<com.baidu.adp.widget.ListView.i> it = list.iterator();
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.i next = it.next();
                if (next instanceof com.baidu.tieba.InjectPlugin.a) {
                    Object Sm = ((com.baidu.tieba.InjectPlugin.a) next).Sm();
                    if ((Sm instanceof AdvertAppInfo) && str.equals(((AdvertAppInfo) Sm).aKu)) {
                        it.remove();
                    }
                }
            }
        }
    }
}
