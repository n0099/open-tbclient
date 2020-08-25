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
import com.baidu.adp.widget.ListView.q;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.tieba.frs.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes16.dex */
public class e {
    private l hVj;
    private bw ipa;
    private CustomMessageListener ipb = new CustomMessageListener(CmdConfigCustom.CMD_BUSINESS_NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.frs.mc.e.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.i(customResponsedMessage);
        }
    };
    private CustomMessageListener hBA = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.frs.mc.e.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.g(customResponsedMessage);
        }
    };
    private CustomMessageListener hBB = new CustomMessageListener(CmdConfigCustom.CMD_THREAD_NOT_EXIST_WHEN_ENTER_PB) { // from class: com.baidu.tieba.frs.mc.e.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.IS(e.this.h(customResponsedMessage));
            e.this.hVj.clS().cnr().notifyDataSetChanged();
        }
    };
    private CustomMessageListener inh = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.frs.mc.e.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && e.this.hVj != null && e.this.hVj.clN() != null && e.this.hVj.clN().crs() != null) {
                String str = (String) customResponsedMessage.getData();
                e.this.h(str, e.this.hVj.clN().crs().getForum().getBannerListData().getAllAdvertList());
                e.this.i(str, e.this.hVj.clS().getListView().getData());
                e.this.i(str, e.this.hVj.clO().crJ().getDataList());
                e.this.hVj.clN().IR(str);
                if (e.this.hVj.clS() != null && e.this.hVj.clS().cnr() != null) {
                    e.this.hVj.clS().cnr().notifyDataSetChanged();
                }
            }
        }
    };

    public e(l lVar, BdUniqueId bdUniqueId) {
        this.hVj = lVar;
        this.hBA.setTag(bdUniqueId);
        this.inh.setTag(bdUniqueId);
        this.ipb.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.ipb);
        MessageManager.getInstance().registerListener(this.hBA);
        MessageManager.getInstance().registerListener(this.inh);
        this.hBB.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.hBB);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String h(CustomResponsedMessage customResponsedMessage) {
        if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof JSONObject)) {
            return null;
        }
        return ((JSONObject) customResponsedMessage.getData()).optString("tid");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(CustomResponsedMessage<?> customResponsedMessage) {
        if (this.hVj != null && this.hVj.clN() != null && this.hVj.clN().crs() != null) {
            final String h = h(customResponsedMessage);
            if (!StringUtils.isNull(h) && this.hVj.clS() != null && this.hVj.clS().cnr() != null) {
                final View childAt = this.hVj.clS().getListView().getChildAt(a(h, this.hVj.clS().getListView()));
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
                            if (e.this.hVj != null && e.this.hVj.clS() != null && e.this.hVj.clS().getListView() != null && e.this.hVj.clS().cnr() != null) {
                                e.this.hVj.clS().getListView().removeView(childAt);
                                e.this.IS(h);
                                e.this.hVj.clS().cnr().notifyDataSetChanged();
                            }
                        }
                    });
                } else {
                    IS(h);
                    this.hVj.clS().cnr().notifyDataSetChanged();
                }
                csd();
            }
        }
    }

    private void csd() {
        if (this.ipa != null && this.ipa.eeb) {
            TbPageTag tbPageTag = null;
            if (this.hVj != null && this.hVj.clS() != null) {
                tbPageTag = com.baidu.tbadk.pageInfo.c.ek(this.hVj.clS().getContext());
            }
            com.baidu.tieba.frs.d.a.a(this.ipa, tbPageTag);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.hVj != null && this.hVj.clN() != null && this.hVj.clN().crs() != null) {
            JSONObject jSONObject = (JSONObject) customResponsedMessage.getData();
            final String optString = jSONObject.optString("type");
            if (!StringUtils.isNull(optString)) {
                final String optString2 = jSONObject.optString("tid");
                if (this.hVj.clS() != null && this.hVj.clS().cnr() != null) {
                    final View childAt = this.hVj.clS().getListView().getChildAt(a(optString, optString2, this.hVj.clS().getListView()));
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
                                e.this.eE(optString, optString2);
                                childAt.setVisibility(8);
                                if (e.this.hVj.clS() != null && e.this.hVj.clS().cnr() != null) {
                                    e.this.hVj.clS().cnr().notifyDataSetChanged();
                                }
                            }
                        });
                        return;
                    }
                    eE(optString, optString2);
                    this.hVj.clS().cnr().notifyDataSetChanged();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eE(String str, String str2) {
        ArrayList<q> threadList = this.hVj.clN().crs().getThreadList();
        c(str, str2, threadList);
        c(str, str2, this.hVj.clS().getListView().getData());
        if (str.equals("ala_frs_stage_live_feed_back_type")) {
            this.hVj.clN().IP(str2);
        } else if (str.equals("ala_frs_demo_hell_live_feed_back_type")) {
            this.hVj.clN().IQ(str2);
        }
        if (threadList != null && threadList.size() < 5) {
            this.hVj.bFD();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IS(String str) {
        if (!StringUtils.isNull(str)) {
            ArrayList<q> threadList = this.hVj.clN().crs().getThreadList();
            g(str, threadList);
            g(str, this.hVj.clS().getListView().getData());
            g(str, this.hVj.clO().getDataList());
            this.hVj.clN().IQ(str);
            if (threadList != null && threadList.size() < 5) {
                this.hVj.bFD();
            }
        }
    }

    private void c(String str, String str2, List<q> list) {
        if (y.getCount(list) != 0) {
            ArrayList arrayList = new ArrayList();
            for (q qVar : list) {
                if (str.equals("ala_frs_stage_live_feed_back_type")) {
                    if (qVar instanceof com.baidu.tieba.tbadkCore.h) {
                        arrayList.add((com.baidu.tieba.tbadkCore.h) qVar);
                    }
                } else if (str.equals("ala_frs_demo_hell_live_feed_back_type") && (qVar instanceof bv)) {
                    bw bwVar = ((bv) qVar).dUS;
                    if (bwVar.getTid() != null && bwVar.getTid().equals(str2)) {
                        arrayList.add(bwVar);
                    }
                }
            }
            list.removeAll(arrayList);
            q qVar2 = (q) y.getItem(list, 0);
            if (qVar2 instanceof w) {
                list.remove(qVar2);
            }
        }
    }

    private void g(String str, List<q> list) {
        if (y.getCount(list) != 0) {
            ArrayList arrayList = new ArrayList();
            for (q qVar : list) {
                if (qVar instanceof bv) {
                    bw bwVar = ((bv) qVar).dUS;
                    if (bwVar.getTid() != null && bwVar.getTid().equals(str)) {
                        arrayList.add(qVar);
                    }
                }
            }
            list.removeAll(arrayList);
            q qVar2 = (q) y.getItem(list, 0);
            if (qVar2 instanceof w) {
                list.remove(qVar2);
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
                if (bdTypeRecyclerView.getItem(i2) instanceof com.baidu.tieba.tbadkCore.h) {
                    i = i2;
                }
            }
        } else if (str.equals("ala_frs_demo_hell_live_feed_back_type")) {
            int i3 = 0;
            for (int i4 = 0; i4 < bdTypeRecyclerView.getAdapter().getItemCount(); i4++) {
                q item = bdTypeRecyclerView.getItem(i4);
                if (item instanceof bv) {
                    bw bwVar = ((bv) item).dUS;
                    if (bwVar.getTid() != null && bwVar.getTid().equals(str2)) {
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
            q item = bdTypeRecyclerView.getItem(i2);
            if (item instanceof bv) {
                bw bwVar = ((bv) item).dUS;
                if (bwVar.getTid() != null && bwVar.getTid().equals(str)) {
                    this.ipa = bwVar;
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
    public void h(String str, List<AdvertAppInfo> list) {
        if (list != null && list.size() > 0 && !TextUtils.isEmpty(str)) {
            Iterator<AdvertAppInfo> it = list.iterator();
            while (it.hasNext()) {
                AdvertAppInfo next = it.next();
                if (next != null && str.equals(next.dWf)) {
                    it.remove();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(String str, List<q> list) {
        if (list != null && list.size() > 0 && !TextUtils.isEmpty(str)) {
            Iterator<q> it = list.iterator();
            while (it.hasNext()) {
                q next = it.next();
                if (next instanceof com.baidu.tieba.InjectPlugin.a) {
                    Object bzo = ((com.baidu.tieba.InjectPlugin.a) next).bzo();
                    if ((bzo instanceof AdvertAppInfo) && str.equals(((AdvertAppInfo) bzo).dWf)) {
                        it.remove();
                    }
                }
            }
        }
    }
}
