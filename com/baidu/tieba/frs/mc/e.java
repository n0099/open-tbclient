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
    private j dMq;
    private CustomMessageListener eds = new CustomMessageListener(2921324) { // from class: com.baidu.tieba.frs.mc.e.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.i(customResponsedMessage);
        }
    };
    private CustomMessageListener edt = new CustomMessageListener(2016488) { // from class: com.baidu.tieba.frs.mc.e.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.h(customResponsedMessage);
        }
    };
    private CustomMessageListener edu = new CustomMessageListener(2016553) { // from class: com.baidu.tieba.frs.mc.e.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.oH(e.this.g(customResponsedMessage));
            e.this.dMq.aBx().aCE().notifyDataSetChanged();
        }
    };
    private CustomMessageListener edv = new CustomMessageListener(2016331) { // from class: com.baidu.tieba.frs.mc.e.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && e.this.dMq != null && e.this.dMq.aBs() != null && e.this.dMq.aBs().aGB() != null) {
                String str = (String) customResponsedMessage.getData();
                e.this.g(str, e.this.dMq.aBs().aGB().bgT().getBannerListData().getAllAdvertList());
                e.this.h(str, e.this.dMq.aBx().getListView().getData());
                e.this.h(str, e.this.dMq.aBt().aGV().getDataList());
                e.this.dMq.aBs().oG(str);
                if (e.this.dMq.aBx() != null && e.this.dMq.aBx().aCE() != null) {
                    e.this.dMq.aBx().aCE().notifyDataSetChanged();
                }
            }
        }
    };

    public e(j jVar, BdUniqueId bdUniqueId) {
        this.dMq = jVar;
        this.edt.setTag(bdUniqueId);
        this.edv.setTag(bdUniqueId);
        this.eds.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.eds);
        MessageManager.getInstance().registerListener(this.edt);
        MessageManager.getInstance().registerListener(this.edv);
        this.edu.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.edu);
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
        if (this.dMq != null && this.dMq.aBs() != null && this.dMq.aBs().aGB() != null) {
            final String g = g(customResponsedMessage);
            if (!StringUtils.isNull(g) && this.dMq.aBx() != null && this.dMq.aBx().aCE() != null) {
                final View childAt = this.dMq.aBx().getListView().getChildAt(a(g, this.dMq.aBx().getListView()));
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
                            if (e.this.dMq != null && e.this.dMq.aBx() != null && e.this.dMq.aBx().getListView() != null && e.this.dMq.aBx().aCE() != null) {
                                e.this.dMq.aBx().getListView().removeView(childAt);
                                e.this.oH(g);
                                e.this.dMq.aBx().aCE().notifyDataSetChanged();
                            }
                        }
                    });
                    return;
                }
                oH(g);
                this.dMq.aBx().aCE().notifyDataSetChanged();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.dMq != null && this.dMq.aBs() != null && this.dMq.aBs().aGB() != null) {
            JSONObject jSONObject = (JSONObject) customResponsedMessage.getData();
            final String optString = jSONObject.optString("type");
            if (!StringUtils.isNull(optString)) {
                final String optString2 = jSONObject.optString("tid");
                if (this.dMq.aBx() != null && this.dMq.aBx().aCE() != null) {
                    final View childAt = this.dMq.aBx().getListView().getChildAt(a(optString, optString2, this.dMq.aBx().getListView()));
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
                                if (e.this.dMq.aBx() != null && e.this.dMq.aBx().aCE() != null) {
                                    e.this.dMq.aBx().aCE().notifyDataSetChanged();
                                }
                            }
                        });
                        return;
                    }
                    bF(optString, optString2);
                    this.dMq.aBx().aCE().notifyDataSetChanged();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bF(String str, String str2) {
        ArrayList<com.baidu.adp.widget.ListView.h> threadList = this.dMq.aBs().aGB().getThreadList();
        b(str, str2, threadList);
        b(str, str2, this.dMq.aBx().getListView().getData());
        if (str.equals("ala_frs_stage_live_feed_back_type")) {
            this.dMq.aBs().oE(str2);
        } else if (str.equals("ala_frs_demo_hell_live_feed_back_type")) {
            this.dMq.aBs().oF(str2);
        }
        if (threadList != null && threadList.size() < 5) {
            this.dMq.aad();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oH(String str) {
        if (!StringUtils.isNull(str)) {
            ArrayList<com.baidu.adp.widget.ListView.h> threadList = this.dMq.aBs().aGB().getThreadList();
            f(str, threadList);
            f(str, this.dMq.aBx().getListView().getData());
            f(str, this.dMq.aBt().getDataList());
            this.dMq.aBs().oF(str);
            if (threadList != null && threadList.size() < 5) {
                this.dMq.aad();
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
                    Object TL = ((com.baidu.tieba.InjectPlugin.a) next).TL();
                    if ((TL instanceof AdvertAppInfo) && str.equals(((AdvertAppInfo) TL).apq)) {
                        it.remove();
                    }
                }
            }
        }
    }
}
