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
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.frs.p;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class e {
    private CustomMessageListener dEi = new CustomMessageListener(2921324) { // from class: com.baidu.tieba.frs.mc.e.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.i(customResponsedMessage);
        }
    };
    private CustomMessageListener dEj = new CustomMessageListener(2016488) { // from class: com.baidu.tieba.frs.mc.e.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.h(customResponsedMessage);
        }
    };
    private CustomMessageListener dEk = new CustomMessageListener(2016553) { // from class: com.baidu.tieba.frs.mc.e.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.mV(e.this.g(customResponsedMessage));
            e.this.dnP.aum().avu().notifyDataSetChanged();
        }
    };
    private CustomMessageListener dEl = new CustomMessageListener(2016331) { // from class: com.baidu.tieba.frs.mc.e.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && e.this.dnP != null && e.this.dnP.auh() != null && e.this.dnP.auh().azf() != null) {
                String str = (String) customResponsedMessage.getData();
                e.this.f(str, e.this.dnP.auh().azf().aZl().getBannerListData().getAllAdvertList());
                e.this.g(str, e.this.dnP.aum().getListView().getData());
                e.this.g(str, e.this.dnP.aui().azz().getDataList());
                e.this.dnP.auh().mU(str);
                if (e.this.dnP.aum() != null && e.this.dnP.aum().avu() != null) {
                    e.this.dnP.aum().avu().notifyDataSetChanged();
                }
            }
        }
    };
    private j dnP;

    public e(j jVar, BdUniqueId bdUniqueId) {
        this.dnP = jVar;
        this.dEj.setTag(bdUniqueId);
        this.dEl.setTag(bdUniqueId);
        this.dEi.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.dEi);
        MessageManager.getInstance().registerListener(this.dEj);
        MessageManager.getInstance().registerListener(this.dEl);
        this.dEk.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.dEk);
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
        if (this.dnP != null && this.dnP.auh() != null && this.dnP.auh().azf() != null) {
            final String g = g(customResponsedMessage);
            if (!StringUtils.isNull(g) && this.dnP.aum() != null && this.dnP.aum().avu() != null) {
                final View childAt = this.dnP.aum().getListView().getChildAt(a(g, this.dnP.aum().getListView()));
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
                            if (e.this.dnP != null && e.this.dnP.aum() != null && e.this.dnP.aum().getListView() != null && e.this.dnP.aum().avu() != null) {
                                e.this.dnP.aum().getListView().removeView(childAt);
                                e.this.mV(g);
                                e.this.dnP.aum().avu().notifyDataSetChanged();
                            }
                        }
                    });
                    return;
                }
                mV(g);
                this.dnP.aum().avu().notifyDataSetChanged();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.dnP != null && this.dnP.auh() != null && this.dnP.auh().azf() != null) {
            JSONObject jSONObject = (JSONObject) customResponsedMessage.getData();
            final String optString = jSONObject.optString("type");
            if (!StringUtils.isNull(optString)) {
                final String optString2 = jSONObject.optString("tid");
                if (this.dnP.aum() != null && this.dnP.aum().avu() != null) {
                    final View childAt = this.dnP.aum().getListView().getChildAt(a(optString, optString2, this.dnP.aum().getListView()));
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
                                e.this.bg(optString, optString2);
                                childAt.setVisibility(8);
                                if (e.this.dnP.aum() != null && e.this.dnP.aum().avu() != null) {
                                    e.this.dnP.aum().avu().notifyDataSetChanged();
                                }
                            }
                        });
                        return;
                    }
                    bg(optString, optString2);
                    this.dnP.aum().avu().notifyDataSetChanged();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bg(String str, String str2) {
        ArrayList<com.baidu.adp.widget.ListView.h> threadList = this.dnP.auh().azf().getThreadList();
        b(str, str2, threadList);
        b(str, str2, this.dnP.aum().getListView().getData());
        if (str.equals("ala_frs_stage_live_feed_back_type")) {
            this.dnP.auh().mS(str2);
        } else if (str.equals("ala_frs_demo_hell_live_feed_back_type")) {
            this.dnP.auh().mT(str2);
        }
        if (threadList != null && threadList.size() < 5) {
            this.dnP.Tn();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mV(String str) {
        if (!StringUtils.isNull(str)) {
            ArrayList<com.baidu.adp.widget.ListView.h> threadList = this.dnP.auh().azf().getThreadList();
            e(str, threadList);
            e(str, this.dnP.aum().getListView().getData());
            e(str, this.dnP.aui().getDataList());
            this.dnP.auh().mT(str);
            if (threadList != null && threadList.size() < 5) {
                this.dnP.Tn();
            }
        }
    }

    private void b(String str, String str2, List<com.baidu.adp.widget.ListView.h> list) {
        if (w.y(list) != 0) {
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
            com.baidu.adp.widget.ListView.h hVar2 = (com.baidu.adp.widget.ListView.h) w.d(list, 0);
            if (hVar2 instanceof p) {
                list.remove(hVar2);
            }
        }
    }

    private void e(String str, List<com.baidu.adp.widget.ListView.h> list) {
        if (w.y(list) != 0) {
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
            com.baidu.adp.widget.ListView.h hVar2 = (com.baidu.adp.widget.ListView.h) w.d(list, 0);
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
    public void f(String str, List<AdvertAppInfo> list) {
        if (list != null && list.size() > 0 && !TextUtils.isEmpty(str)) {
            Iterator<AdvertAppInfo> it = list.iterator();
            while (it.hasNext()) {
                AdvertAppInfo next = it.next();
                if (next != null && str.equals(next.adE)) {
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
                    Object OH = ((com.baidu.tieba.InjectPlugin.a) next).OH();
                    if ((OH instanceof AdvertAppInfo) && str.equals(((AdvertAppInfo) OH).adE)) {
                        it.remove();
                    }
                }
            }
        }
    }
}
