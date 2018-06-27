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
import com.baidu.tbadk.core.data.bc;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.frs.p;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class e {
    private CustomMessageListener dBw = new CustomMessageListener(2921324) { // from class: com.baidu.tieba.frs.mc.e.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.i(customResponsedMessage);
        }
    };
    private CustomMessageListener dBx = new CustomMessageListener(2016488) { // from class: com.baidu.tieba.frs.mc.e.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.h(customResponsedMessage);
        }
    };
    private CustomMessageListener dBy = new CustomMessageListener(2016553) { // from class: com.baidu.tieba.frs.mc.e.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.mW(e.this.g(customResponsedMessage));
            e.this.dkY.atI().auQ().notifyDataSetChanged();
        }
    };
    private CustomMessageListener dBz = new CustomMessageListener(2016331) { // from class: com.baidu.tieba.frs.mc.e.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && e.this.dkY != null && e.this.dkY.atD() != null && e.this.dkY.atD().ayA() != null) {
                String str = (String) customResponsedMessage.getData();
                e.this.f(str, e.this.dkY.atD().ayA().baT().getBannerListData().getAllAdvertList());
                e.this.g(str, e.this.dkY.atI().getListView().getData());
                e.this.g(str, e.this.dkY.atE().ayT().getDataList());
                e.this.dkY.atD().mV(str);
                if (e.this.dkY.atI() != null && e.this.dkY.atI().auQ() != null) {
                    e.this.dkY.atI().auQ().notifyDataSetChanged();
                }
            }
        }
    };
    private j dkY;

    public e(j jVar, BdUniqueId bdUniqueId) {
        this.dkY = jVar;
        this.dBx.setTag(bdUniqueId);
        this.dBz.setTag(bdUniqueId);
        this.dBw.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.dBw);
        MessageManager.getInstance().registerListener(this.dBx);
        MessageManager.getInstance().registerListener(this.dBz);
        this.dBy.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.dBy);
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
        if (this.dkY != null && this.dkY.atD() != null && this.dkY.atD().ayA() != null) {
            final String g = g(customResponsedMessage);
            if (!StringUtils.isNull(g) && this.dkY.atI() != null && this.dkY.atI().auQ() != null) {
                final View childAt = this.dkY.atI().getListView().getChildAt(a(g, this.dkY.atI().getListView()));
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
                            if (e.this.dkY != null && e.this.dkY.atI() != null && e.this.dkY.atI().getListView() != null && e.this.dkY.atI().auQ() != null) {
                                e.this.dkY.atI().getListView().removeView(childAt);
                                e.this.mW(g);
                                e.this.dkY.atI().auQ().notifyDataSetChanged();
                            }
                        }
                    });
                    return;
                }
                mW(g);
                this.dkY.atI().auQ().notifyDataSetChanged();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.dkY != null && this.dkY.atD() != null && this.dkY.atD().ayA() != null) {
            JSONObject jSONObject = (JSONObject) customResponsedMessage.getData();
            final String optString = jSONObject.optString("type");
            if (!StringUtils.isNull(optString)) {
                final String optString2 = jSONObject.optString("tid");
                if (this.dkY.atI() != null && this.dkY.atI().auQ() != null) {
                    final View childAt = this.dkY.atI().getListView().getChildAt(a(optString, optString2, this.dkY.atI().getListView()));
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
                                e.this.bi(optString, optString2);
                                childAt.setVisibility(8);
                                if (e.this.dkY.atI() != null && e.this.dkY.atI().auQ() != null) {
                                    e.this.dkY.atI().auQ().notifyDataSetChanged();
                                }
                            }
                        });
                        return;
                    }
                    bi(optString, optString2);
                    this.dkY.atI().auQ().notifyDataSetChanged();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bi(String str, String str2) {
        ArrayList<com.baidu.adp.widget.ListView.h> threadList = this.dkY.atD().ayA().getThreadList();
        b(str, str2, threadList);
        b(str, str2, this.dkY.atI().getListView().getData());
        if (str.equals("ala_frs_stage_live_feed_back_type")) {
            this.dkY.atD().mT(str2);
        } else if (str.equals("ala_frs_demo_hell_live_feed_back_type")) {
            this.dkY.atD().mU(str2);
        }
        if (threadList != null && threadList.size() < 5) {
            this.dkY.Tf();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mW(String str) {
        if (!StringUtils.isNull(str)) {
            ArrayList<com.baidu.adp.widget.ListView.h> threadList = this.dkY.atD().ayA().getThreadList();
            e(str, threadList);
            e(str, this.dkY.atI().getListView().getData());
            e(str, this.dkY.atE().getDataList());
            this.dkY.atD().mU(str);
            if (threadList != null && threadList.size() < 5) {
                this.dkY.Tf();
            }
        }
    }

    private void b(String str, String str2, List<com.baidu.adp.widget.ListView.h> list) {
        if (w.z(list) != 0) {
            ArrayList arrayList = new ArrayList();
            for (com.baidu.adp.widget.ListView.h hVar : list) {
                if (str.equals("ala_frs_stage_live_feed_back_type")) {
                    if (hVar instanceof com.baidu.tieba.tbadkCore.f) {
                        arrayList.add((com.baidu.tieba.tbadkCore.f) hVar);
                    }
                } else if (str.equals("ala_frs_demo_hell_live_feed_back_type") && (hVar instanceof bc)) {
                    bc bcVar = (bc) hVar;
                    if (bcVar.getTid() != null && bcVar.getTid().equals(str2)) {
                        arrayList.add(bcVar);
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
        if (w.z(list) != 0) {
            ArrayList arrayList = new ArrayList();
            for (com.baidu.adp.widget.ListView.h hVar : list) {
                if (hVar instanceof bc) {
                    bc bcVar = (bc) hVar;
                    if (bcVar.getTid() != null && bcVar.getTid().equals(str)) {
                        arrayList.add(bcVar);
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
                if (item instanceof bc) {
                    bc bcVar = (bc) item;
                    if (bcVar.getTid() != null && bcVar.getTid().equals(str2)) {
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
            if (item instanceof bc) {
                bc bcVar = (bc) item;
                if (bcVar.getTid() != null && bcVar.getTid().equals(str)) {
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
                if (next != null && str.equals(next.aea)) {
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
                    Object OB = ((com.baidu.tieba.InjectPlugin.a) next).OB();
                    if ((OB instanceof AdvertAppInfo) && str.equals(((AdvertAppInfo) OB).aea)) {
                        it.remove();
                    }
                }
            }
        }
    }
}
