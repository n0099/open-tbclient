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
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.bf;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.frs.p;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class e {
    private l faE;
    private CustomMessageListener frG = new CustomMessageListener(2921324) { // from class: com.baidu.tieba.frs.mc.e.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.i(customResponsedMessage);
        }
    };
    private CustomMessageListener frH = new CustomMessageListener(2016488) { // from class: com.baidu.tieba.frs.mc.e.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.h(customResponsedMessage);
        }
    };
    private CustomMessageListener frI = new CustomMessageListener(2016553) { // from class: com.baidu.tieba.frs.mc.e.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.vA(e.this.g(customResponsedMessage));
            e.this.faE.bcu().bdK().notifyDataSetChanged();
        }
    };
    private CustomMessageListener frJ = new CustomMessageListener(2016331) { // from class: com.baidu.tieba.frs.mc.e.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && e.this.faE != null && e.this.faE.bcp() != null && e.this.faE.bcp().bho() != null) {
                String str = (String) customResponsedMessage.getData();
                e.this.i(str, e.this.faE.bcp().bho().getForum().getBannerListData().getAllAdvertList());
                e.this.j(str, e.this.faE.bcu().getListView().getData());
                e.this.j(str, e.this.faE.bcq().bhE().getDataList());
                e.this.faE.bcp().vz(str);
                if (e.this.faE.bcu() != null && e.this.faE.bcu().bdK() != null) {
                    e.this.faE.bcu().bdK().notifyDataSetChanged();
                }
            }
        }
    };

    public e(l lVar, BdUniqueId bdUniqueId) {
        this.faE = lVar;
        this.frH.setTag(bdUniqueId);
        this.frJ.setTag(bdUniqueId);
        this.frG.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.frG);
        MessageManager.getInstance().registerListener(this.frH);
        MessageManager.getInstance().registerListener(this.frJ);
        this.frI.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.frI);
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
        if (this.faE != null && this.faE.bcp() != null && this.faE.bcp().bho() != null) {
            final String g = g(customResponsedMessage);
            if (!StringUtils.isNull(g) && this.faE.bcu() != null && this.faE.bcu().bdK() != null) {
                final View childAt = this.faE.bcu().getListView().getChildAt(a(g, this.faE.bcu().getListView()));
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
                            if (e.this.faE != null && e.this.faE.bcu() != null && e.this.faE.bcu().getListView() != null && e.this.faE.bcu().bdK() != null) {
                                e.this.faE.bcu().getListView().removeView(childAt);
                                e.this.vA(g);
                                e.this.faE.bcu().bdK().notifyDataSetChanged();
                            }
                        }
                    });
                    return;
                }
                vA(g);
                this.faE.bcu().bdK().notifyDataSetChanged();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.faE != null && this.faE.bcp() != null && this.faE.bcp().bho() != null) {
            JSONObject jSONObject = (JSONObject) customResponsedMessage.getData();
            final String optString = jSONObject.optString("type");
            if (!StringUtils.isNull(optString)) {
                final String optString2 = jSONObject.optString("tid");
                if (this.faE.bcu() != null && this.faE.bcu().bdK() != null) {
                    final View childAt = this.faE.bcu().getListView().getChildAt(a(optString, optString2, this.faE.bcu().getListView()));
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
                                e.this.cL(optString, optString2);
                                childAt.setVisibility(8);
                                if (e.this.faE.bcu() != null && e.this.faE.bcu().bdK() != null) {
                                    e.this.faE.bcu().bdK().notifyDataSetChanged();
                                }
                            }
                        });
                        return;
                    }
                    cL(optString, optString2);
                    this.faE.bcu().bdK().notifyDataSetChanged();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cL(String str, String str2) {
        ArrayList<m> threadList = this.faE.bcp().bho().getThreadList();
        b(str, str2, threadList);
        b(str, str2, this.faE.bcu().getListView().getData());
        if (str.equals("ala_frs_stage_live_feed_back_type")) {
            this.faE.bcp().vx(str2);
        } else if (str.equals("ala_frs_demo_hell_live_feed_back_type")) {
            this.faE.bcp().vy(str2);
        }
        if (threadList != null && threadList.size() < 5) {
            this.faE.aBc();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vA(String str) {
        if (!StringUtils.isNull(str)) {
            ArrayList<m> threadList = this.faE.bcp().bho().getThreadList();
            h(str, threadList);
            h(str, this.faE.bcu().getListView().getData());
            h(str, this.faE.bcq().getDataList());
            this.faE.bcp().vy(str);
            if (threadList != null && threadList.size() < 5) {
                this.faE.aBc();
            }
        }
    }

    private void b(String str, String str2, List<m> list) {
        if (v.S(list) != 0) {
            ArrayList arrayList = new ArrayList();
            for (m mVar : list) {
                if (str.equals("ala_frs_stage_live_feed_back_type")) {
                    if (mVar instanceof com.baidu.tieba.tbadkCore.g) {
                        arrayList.add((com.baidu.tieba.tbadkCore.g) mVar);
                    }
                } else if (str.equals("ala_frs_demo_hell_live_feed_back_type") && (mVar instanceof bf)) {
                    bg bgVar = ((bf) mVar).threadData;
                    if (bgVar.getTid() != null && bgVar.getTid().equals(str2)) {
                        arrayList.add(bgVar);
                    }
                }
            }
            list.removeAll(arrayList);
            m mVar2 = (m) v.c(list, 0);
            if (mVar2 instanceof p) {
                list.remove(mVar2);
            }
        }
    }

    private void h(String str, List<m> list) {
        if (v.S(list) != 0) {
            ArrayList arrayList = new ArrayList();
            for (m mVar : list) {
                if (mVar instanceof bf) {
                    bg bgVar = ((bf) mVar).threadData;
                    if (bgVar.getTid() != null && bgVar.getTid().equals(str)) {
                        arrayList.add(mVar);
                    }
                }
            }
            list.removeAll(arrayList);
            m mVar2 = (m) v.c(list, 0);
            if (mVar2 instanceof p) {
                list.remove(mVar2);
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
                if (bdTypeRecyclerView.getItem(i2) instanceof com.baidu.tieba.tbadkCore.g) {
                    i = i2;
                }
            }
        } else if (str.equals("ala_frs_demo_hell_live_feed_back_type")) {
            int i3 = 0;
            for (int i4 = 0; i4 < bdTypeRecyclerView.getAdapter().getItemCount(); i4++) {
                m item = bdTypeRecyclerView.getItem(i4);
                if (item instanceof bf) {
                    bg bgVar = ((bf) item).threadData;
                    if (bgVar.getTid() != null && bgVar.getTid().equals(str2)) {
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
            m item = bdTypeRecyclerView.getItem(i2);
            if (item instanceof bf) {
                bg bgVar = ((bf) item).threadData;
                if (bgVar.getTid() != null && bgVar.getTid().equals(str)) {
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
    public void i(String str, List<AdvertAppInfo> list) {
        if (list != null && list.size() > 0 && !TextUtils.isEmpty(str)) {
            Iterator<AdvertAppInfo> it = list.iterator();
            while (it.hasNext()) {
                AdvertAppInfo next = it.next();
                if (next != null && str.equals(next.bwD)) {
                    it.remove();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(String str, List<m> list) {
        if (list != null && list.size() > 0 && !TextUtils.isEmpty(str)) {
            Iterator<m> it = list.iterator();
            while (it.hasNext()) {
                m next = it.next();
                if (next instanceof com.baidu.tieba.InjectPlugin.a) {
                    Object aug = ((com.baidu.tieba.InjectPlugin.a) next).aug();
                    if ((aug instanceof AdvertAppInfo) && str.equals(((AdvertAppInfo) aug).bwD)) {
                        it.remove();
                    }
                }
            }
        }
    }
}
