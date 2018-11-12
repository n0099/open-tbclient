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
    private j dDd;
    private CustomMessageListener dTY = new CustomMessageListener(2921324) { // from class: com.baidu.tieba.frs.mc.e.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.i(customResponsedMessage);
        }
    };
    private CustomMessageListener dTZ = new CustomMessageListener(2016488) { // from class: com.baidu.tieba.frs.mc.e.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.h(customResponsedMessage);
        }
    };
    private CustomMessageListener dUa = new CustomMessageListener(2016553) { // from class: com.baidu.tieba.frs.mc.e.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.od(e.this.g(customResponsedMessage));
            e.this.dDd.ayY().aAf().notifyDataSetChanged();
        }
    };
    private CustomMessageListener dUb = new CustomMessageListener(2016331) { // from class: com.baidu.tieba.frs.mc.e.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && e.this.dDd != null && e.this.dDd.ayT() != null && e.this.dDd.ayT().aEa() != null) {
                String str = (String) customResponsedMessage.getData();
                e.this.g(str, e.this.dDd.ayT().aEa().ber().getBannerListData().getAllAdvertList());
                e.this.h(str, e.this.dDd.ayY().getListView().getData());
                e.this.h(str, e.this.dDd.ayU().aEu().getDataList());
                e.this.dDd.ayT().oc(str);
                if (e.this.dDd.ayY() != null && e.this.dDd.ayY().aAf() != null) {
                    e.this.dDd.ayY().aAf().notifyDataSetChanged();
                }
            }
        }
    };

    public e(j jVar, BdUniqueId bdUniqueId) {
        this.dDd = jVar;
        this.dTZ.setTag(bdUniqueId);
        this.dUb.setTag(bdUniqueId);
        this.dTY.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.dTY);
        MessageManager.getInstance().registerListener(this.dTZ);
        MessageManager.getInstance().registerListener(this.dUb);
        this.dUa.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.dUa);
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
        if (this.dDd != null && this.dDd.ayT() != null && this.dDd.ayT().aEa() != null) {
            final String g = g(customResponsedMessage);
            if (!StringUtils.isNull(g) && this.dDd.ayY() != null && this.dDd.ayY().aAf() != null) {
                final View childAt = this.dDd.ayY().getListView().getChildAt(a(g, this.dDd.ayY().getListView()));
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
                            if (e.this.dDd != null && e.this.dDd.ayY() != null && e.this.dDd.ayY().getListView() != null && e.this.dDd.ayY().aAf() != null) {
                                e.this.dDd.ayY().getListView().removeView(childAt);
                                e.this.od(g);
                                e.this.dDd.ayY().aAf().notifyDataSetChanged();
                            }
                        }
                    });
                    return;
                }
                od(g);
                this.dDd.ayY().aAf().notifyDataSetChanged();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.dDd != null && this.dDd.ayT() != null && this.dDd.ayT().aEa() != null) {
            JSONObject jSONObject = (JSONObject) customResponsedMessage.getData();
            final String optString = jSONObject.optString("type");
            if (!StringUtils.isNull(optString)) {
                final String optString2 = jSONObject.optString("tid");
                if (this.dDd.ayY() != null && this.dDd.ayY().aAf() != null) {
                    final View childAt = this.dDd.ayY().getListView().getChildAt(a(optString, optString2, this.dDd.ayY().getListView()));
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
                                e.this.bA(optString, optString2);
                                childAt.setVisibility(8);
                                if (e.this.dDd.ayY() != null && e.this.dDd.ayY().aAf() != null) {
                                    e.this.dDd.ayY().aAf().notifyDataSetChanged();
                                }
                            }
                        });
                        return;
                    }
                    bA(optString, optString2);
                    this.dDd.ayY().aAf().notifyDataSetChanged();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bA(String str, String str2) {
        ArrayList<com.baidu.adp.widget.ListView.h> threadList = this.dDd.ayT().aEa().getThreadList();
        b(str, str2, threadList);
        b(str, str2, this.dDd.ayY().getListView().getData());
        if (str.equals("ala_frs_stage_live_feed_back_type")) {
            this.dDd.ayT().oa(str2);
        } else if (str.equals("ala_frs_demo_hell_live_feed_back_type")) {
            this.dDd.ayT().ob(str2);
        }
        if (threadList != null && threadList.size() < 5) {
            this.dDd.YV();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void od(String str) {
        if (!StringUtils.isNull(str)) {
            ArrayList<com.baidu.adp.widget.ListView.h> threadList = this.dDd.ayT().aEa().getThreadList();
            f(str, threadList);
            f(str, this.dDd.ayY().getListView().getData());
            f(str, this.dDd.ayU().getDataList());
            this.dDd.ayT().ob(str);
            if (threadList != null && threadList.size() < 5) {
                this.dDd.YV();
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
                if (next != null && str.equals(next.alP)) {
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
                    Object SD = ((com.baidu.tieba.InjectPlugin.a) next).SD();
                    if ((SD instanceof AdvertAppInfo) && str.equals(((AdvertAppInfo) SD).alP)) {
                        it.remove();
                    }
                }
            }
        }
    }
}
