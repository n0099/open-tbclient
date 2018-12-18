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
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.frs.p;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class e {
    private j dJC;
    private CustomMessageListener eaB = new CustomMessageListener(2921324) { // from class: com.baidu.tieba.frs.mc.e.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.i(customResponsedMessage);
        }
    };
    private CustomMessageListener eaC = new CustomMessageListener(2016488) { // from class: com.baidu.tieba.frs.mc.e.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.h(customResponsedMessage);
        }
    };
    private CustomMessageListener eaD = new CustomMessageListener(2016553) { // from class: com.baidu.tieba.frs.mc.e.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.oE(e.this.g(customResponsedMessage));
            e.this.dJC.aAI().aBP().notifyDataSetChanged();
        }
    };
    private CustomMessageListener eaE = new CustomMessageListener(2016331) { // from class: com.baidu.tieba.frs.mc.e.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && e.this.dJC != null && e.this.dJC.aAD() != null && e.this.dJC.aAD().aFM() != null) {
                String str = (String) customResponsedMessage.getData();
                e.this.g(str, e.this.dJC.aAD().aFM().bgh().getBannerListData().getAllAdvertList());
                e.this.h(str, e.this.dJC.aAI().getListView().getData());
                e.this.h(str, e.this.dJC.aAE().aGg().getDataList());
                e.this.dJC.aAD().oD(str);
                if (e.this.dJC.aAI() != null && e.this.dJC.aAI().aBP() != null) {
                    e.this.dJC.aAI().aBP().notifyDataSetChanged();
                }
            }
        }
    };

    public e(j jVar, BdUniqueId bdUniqueId) {
        this.dJC = jVar;
        this.eaC.setTag(bdUniqueId);
        this.eaE.setTag(bdUniqueId);
        this.eaB.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.eaB);
        MessageManager.getInstance().registerListener(this.eaC);
        MessageManager.getInstance().registerListener(this.eaE);
        this.eaD.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.eaD);
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
        if (this.dJC != null && this.dJC.aAD() != null && this.dJC.aAD().aFM() != null) {
            final String g = g(customResponsedMessage);
            if (!StringUtils.isNull(g) && this.dJC.aAI() != null && this.dJC.aAI().aBP() != null) {
                final View childAt = this.dJC.aAI().getListView().getChildAt(a(g, this.dJC.aAI().getListView()));
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
                            if (e.this.dJC != null && e.this.dJC.aAI() != null && e.this.dJC.aAI().getListView() != null && e.this.dJC.aAI().aBP() != null) {
                                e.this.dJC.aAI().getListView().removeView(childAt);
                                e.this.oE(g);
                                e.this.dJC.aAI().aBP().notifyDataSetChanged();
                            }
                        }
                    });
                    return;
                }
                oE(g);
                this.dJC.aAI().aBP().notifyDataSetChanged();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.dJC != null && this.dJC.aAD() != null && this.dJC.aAD().aFM() != null) {
            JSONObject jSONObject = (JSONObject) customResponsedMessage.getData();
            final String optString = jSONObject.optString("type");
            if (!StringUtils.isNull(optString)) {
                final String optString2 = jSONObject.optString("tid");
                if (this.dJC.aAI() != null && this.dJC.aAI().aBP() != null) {
                    final View childAt = this.dJC.aAI().getListView().getChildAt(a(optString, optString2, this.dJC.aAI().getListView()));
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
                                e.this.bF(optString, optString2);
                                childAt.setVisibility(8);
                                if (e.this.dJC.aAI() != null && e.this.dJC.aAI().aBP() != null) {
                                    e.this.dJC.aAI().aBP().notifyDataSetChanged();
                                }
                            }
                        });
                        return;
                    }
                    bF(optString, optString2);
                    this.dJC.aAI().aBP().notifyDataSetChanged();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bF(String str, String str2) {
        ArrayList<com.baidu.adp.widget.ListView.h> threadList = this.dJC.aAD().aFM().getThreadList();
        b(str, str2, threadList);
        b(str, str2, this.dJC.aAI().getListView().getData());
        if (str.equals("ala_frs_stage_live_feed_back_type")) {
            this.dJC.aAD().oB(str2);
        } else if (str.equals("ala_frs_demo_hell_live_feed_back_type")) {
            this.dJC.aAD().oC(str2);
        }
        if (threadList != null && threadList.size() < 5) {
            this.dJC.aab();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oE(String str) {
        if (!StringUtils.isNull(str)) {
            ArrayList<com.baidu.adp.widget.ListView.h> threadList = this.dJC.aAD().aFM().getThreadList();
            f(str, threadList);
            f(str, this.dJC.aAI().getListView().getData());
            f(str, this.dJC.aAE().getDataList());
            this.dJC.aAD().oC(str);
            if (threadList != null && threadList.size() < 5) {
                this.dJC.aab();
            }
        }
    }

    private void b(String str, String str2, List<com.baidu.adp.widget.ListView.h> list) {
        if (v.H(list) != 0) {
            ArrayList arrayList = new ArrayList();
            for (com.baidu.adp.widget.ListView.h hVar : list) {
                if (str.equals("ala_frs_stage_live_feed_back_type")) {
                    if (hVar instanceof com.baidu.tieba.tbadkCore.f) {
                        arrayList.add((com.baidu.tieba.tbadkCore.f) hVar);
                    }
                } else if (str.equals("ala_frs_demo_hell_live_feed_back_type") && (hVar instanceof bb)) {
                    bb bbVar = (bb) hVar;
                    if (bbVar.getTid() != null && bbVar.getTid().equals(str2)) {
                        arrayList.add(bbVar);
                    }
                }
            }
            list.removeAll(arrayList);
            com.baidu.adp.widget.ListView.h hVar2 = (com.baidu.adp.widget.ListView.h) v.d(list, 0);
            if (hVar2 instanceof p) {
                list.remove(hVar2);
            }
        }
    }

    private void f(String str, List<com.baidu.adp.widget.ListView.h> list) {
        if (v.H(list) != 0) {
            ArrayList arrayList = new ArrayList();
            for (com.baidu.adp.widget.ListView.h hVar : list) {
                if (hVar instanceof bb) {
                    bb bbVar = (bb) hVar;
                    if (bbVar.getTid() != null && bbVar.getTid().equals(str)) {
                        arrayList.add(bbVar);
                    }
                }
            }
            list.removeAll(arrayList);
            com.baidu.adp.widget.ListView.h hVar2 = (com.baidu.adp.widget.ListView.h) v.d(list, 0);
            if (hVar2 instanceof p) {
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
                if (item instanceof bb) {
                    bb bbVar = (bb) item;
                    if (bbVar.getTid() != null && bbVar.getTid().equals(str2)) {
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
            if (item instanceof bb) {
                bb bbVar = (bb) item;
                if (bbVar.getTid() != null && bbVar.getTid().equals(str)) {
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
    public void g(String str, List<AdvertAppInfo> list) {
        if (list != null && list.size() > 0 && !TextUtils.isEmpty(str)) {
            Iterator<AdvertAppInfo> it = list.iterator();
            while (it.hasNext()) {
                AdvertAppInfo next = it.next();
                if (next != null && str.equals(next.apq)) {
                    it.remove();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(String str, List<com.baidu.adp.widget.ListView.h> list) {
        if (list != null && list.size() > 0 && !TextUtils.isEmpty(str)) {
            Iterator<com.baidu.adp.widget.ListView.h> it = list.iterator();
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.h next = it.next();
                if (next instanceof com.baidu.tieba.InjectPlugin.a) {
                    Object TJ = ((com.baidu.tieba.InjectPlugin.a) next).TJ();
                    if ((TJ instanceof AdvertAppInfo) && str.equals(((AdvertAppInfo) TJ).apq)) {
                        it.remove();
                    }
                }
            }
        }
    }
}
