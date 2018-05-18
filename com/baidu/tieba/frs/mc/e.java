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
import com.baidu.tieba.frs.n;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class e {
    private j cZH;
    private CustomMessageListener doQ = new CustomMessageListener(2921324) { // from class: com.baidu.tieba.frs.mc.e.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.i(customResponsedMessage);
        }
    };
    private CustomMessageListener doR = new CustomMessageListener(2016488) { // from class: com.baidu.tieba.frs.mc.e.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.h(customResponsedMessage);
        }
    };
    private CustomMessageListener doS = new CustomMessageListener(2016553) { // from class: com.baidu.tieba.frs.mc.e.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.mo(e.this.g(customResponsedMessage));
            e.this.cZH.apm().aqs().notifyDataSetChanged();
        }
    };
    private CustomMessageListener doT = new CustomMessageListener(2016331) { // from class: com.baidu.tieba.frs.mc.e.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && e.this.cZH != null && e.this.cZH.apg() != null && e.this.cZH.apg().atI() != null) {
                String str = (String) customResponsedMessage.getData();
                e.this.f(str, e.this.cZH.apg().atI().aVq().getBannerListData().getAllAdvertList());
                e.this.g(str, e.this.cZH.apm().getListView().getData());
                e.this.g(str, e.this.cZH.aph().aua().getDataList());
                e.this.cZH.apg().mn(str);
                if (e.this.cZH.apm() != null && e.this.cZH.apm().aqs() != null) {
                    e.this.cZH.apm().aqs().notifyDataSetChanged();
                }
            }
        }
    };

    public e(j jVar, BdUniqueId bdUniqueId) {
        this.cZH = jVar;
        this.doR.setTag(bdUniqueId);
        this.doT.setTag(bdUniqueId);
        this.doQ.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.doQ);
        MessageManager.getInstance().registerListener(this.doR);
        MessageManager.getInstance().registerListener(this.doT);
        this.doS.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.doS);
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
        if (this.cZH != null && this.cZH.apg() != null && this.cZH.apg().atI() != null) {
            final String g = g(customResponsedMessage);
            if (!StringUtils.isNull(g) && this.cZH.apm() != null && this.cZH.apm().aqs() != null) {
                final View childAt = this.cZH.apm().getListView().getChildAt(a(g, this.cZH.apm().getListView()));
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
                            if (e.this.cZH != null && e.this.cZH.apm() != null && e.this.cZH.apm().getListView() != null && e.this.cZH.apm().aqs() != null) {
                                e.this.cZH.apm().getListView().removeView(childAt);
                                e.this.mo(g);
                                e.this.cZH.apm().aqs().notifyDataSetChanged();
                            }
                        }
                    });
                    return;
                }
                mo(g);
                this.cZH.apm().aqs().notifyDataSetChanged();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.cZH != null && this.cZH.apg() != null && this.cZH.apg().atI() != null) {
            JSONObject jSONObject = (JSONObject) customResponsedMessage.getData();
            final String optString = jSONObject.optString("type");
            if (!StringUtils.isNull(optString)) {
                final String optString2 = jSONObject.optString("tid");
                if (this.cZH.apm() != null && this.cZH.apm().aqs() != null) {
                    final View childAt = this.cZH.apm().getListView().getChildAt(a(optString, optString2, this.cZH.apm().getListView()));
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
                                if (e.this.cZH.apm() != null && e.this.cZH.apm().aqs() != null) {
                                    e.this.cZH.apm().aqs().notifyDataSetChanged();
                                }
                            }
                        });
                        return;
                    }
                    aW(optString, optString2);
                    this.cZH.apm().aqs().notifyDataSetChanged();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aW(String str, String str2) {
        ArrayList<com.baidu.adp.widget.ListView.h> threadList = this.cZH.apg().atI().getThreadList();
        a(str, str2, threadList);
        a(str, str2, this.cZH.apm().getListView().getData());
        if (str.equals("ala_frs_stage_live_feed_back_type")) {
            this.cZH.apg().ml(str2);
        } else if (str.equals("ala_frs_demo_hell_live_feed_back_type")) {
            this.cZH.apg().mm(str2);
        }
        if (threadList != null && threadList.size() < 5) {
            this.cZH.Pl();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mo(String str) {
        if (!StringUtils.isNull(str)) {
            ArrayList<com.baidu.adp.widget.ListView.h> threadList = this.cZH.apg().atI().getThreadList();
            e(str, threadList);
            e(str, this.cZH.apm().getListView().getData());
            e(str, this.cZH.aph().getDataList());
            this.cZH.apg().mm(str);
            if (threadList != null && threadList.size() < 5) {
                this.cZH.Pl();
            }
        }
    }

    private void a(String str, String str2, List<com.baidu.adp.widget.ListView.h> list) {
        if (v.v(list) != 0) {
            ArrayList arrayList = new ArrayList();
            for (com.baidu.adp.widget.ListView.h hVar : list) {
                if (str.equals("ala_frs_stage_live_feed_back_type")) {
                    if (hVar instanceof com.baidu.tieba.tbadkCore.f) {
                        arrayList.add((com.baidu.tieba.tbadkCore.f) hVar);
                    }
                } else if (str.equals("ala_frs_demo_hell_live_feed_back_type") && (hVar instanceof bd)) {
                    bd bdVar = (bd) hVar;
                    if (bdVar.getTid() != null && bdVar.getTid().equals(str2)) {
                        arrayList.add(bdVar);
                    }
                }
            }
            list.removeAll(arrayList);
            com.baidu.adp.widget.ListView.h hVar2 = (com.baidu.adp.widget.ListView.h) v.c(list, 0);
            if (hVar2 instanceof n) {
                list.remove(hVar2);
            }
        }
    }

    private void e(String str, List<com.baidu.adp.widget.ListView.h> list) {
        if (v.v(list) != 0) {
            ArrayList arrayList = new ArrayList();
            for (com.baidu.adp.widget.ListView.h hVar : list) {
                if (hVar instanceof bd) {
                    bd bdVar = (bd) hVar;
                    if (bdVar.getTid() != null && bdVar.getTid().equals(str)) {
                        arrayList.add(bdVar);
                    }
                }
            }
            list.removeAll(arrayList);
            com.baidu.adp.widget.ListView.h hVar2 = (com.baidu.adp.widget.ListView.h) v.c(list, 0);
            if (hVar2 instanceof n) {
                list.remove(hVar2);
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
                com.baidu.adp.widget.ListView.h item = bdTypeRecyclerView.getItem(i4);
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
            com.baidu.adp.widget.ListView.h item = bdTypeRecyclerView.getItem(i2);
            if (item instanceof bd) {
                bd bdVar = (bd) item;
                if (bdVar.getTid() != null && bdVar.getTid().equals(str)) {
                    i = i2;
                }
            }
        }
        return (i + headerViewsCount) - firstVisiblePosition;
    }

    private void a(final View view2, Animation.AnimationListener animationListener) {
        final int measuredHeight = view2.getMeasuredHeight();
        Animation animation = new Animation() { // from class: com.baidu.tieba.frs.mc.e.6
            @Override // android.view.animation.Animation
            protected void applyTransformation(float f, Transformation transformation) {
                view2.getLayoutParams().height = measuredHeight - ((int) (measuredHeight * f));
                view2.requestLayout();
            }

            @Override // android.view.animation.Animation
            public boolean willChangeBounds() {
                return true;
            }
        };
        animation.setAnimationListener(animationListener);
        animation.setDuration(300L);
        view2.startAnimation(animation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(String str, List<AdvertAppInfo> list) {
        if (list != null && list.size() > 0 && !TextUtils.isEmpty(str)) {
            Iterator<AdvertAppInfo> it = list.iterator();
            while (it.hasNext()) {
                AdvertAppInfo next = it.next();
                if (next != null && str.equals(next.VL)) {
                    it.remove();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(String str, List<com.baidu.adp.widget.ListView.h> list) {
        if (list != null && list.size() > 0 && !TextUtils.isEmpty(str)) {
            Iterator<com.baidu.adp.widget.ListView.h> it = list.iterator();
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.h next = it.next();
                if (next instanceof com.baidu.tieba.InjectPlugin.a) {
                    Object KJ = ((com.baidu.tieba.InjectPlugin.a) next).KJ();
                    if ((KJ instanceof AdvertAppInfo) && str.equals(((AdvertAppInfo) KJ).VL)) {
                        it.remove();
                    }
                }
            }
        }
    }
}
