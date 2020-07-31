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
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.tieba.frs.v;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes16.dex */
public class e {
    private l hHT;
    private bv iaQ;
    private CustomMessageListener iaR = new CustomMessageListener(CmdConfigCustom.CMD_BUSINESS_NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.frs.mc.e.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.i(customResponsedMessage);
        }
    };
    private CustomMessageListener hoJ = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.frs.mc.e.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.g(customResponsedMessage);
        }
    };
    private CustomMessageListener hoK = new CustomMessageListener(CmdConfigCustom.CMD_THREAD_NOT_EXIST_WHEN_ENTER_PB) { // from class: com.baidu.tieba.frs.mc.e.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.Gq(e.this.h(customResponsedMessage));
            e.this.hHT.cbw().ccU().notifyDataSetChanged();
        }
    };
    private CustomMessageListener hYX = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.frs.mc.e.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && e.this.hHT != null && e.this.hHT.cbr() != null && e.this.hHT.cbr().cgN() != null) {
                String str = (String) customResponsedMessage.getData();
                e.this.i(str, e.this.hHT.cbr().cgN().getForum().getBannerListData().getAllAdvertList());
                e.this.j(str, e.this.hHT.cbw().getListView().getData());
                e.this.j(str, e.this.hHT.cbs().che().getDataList());
                e.this.hHT.cbr().Gp(str);
                if (e.this.hHT.cbw() != null && e.this.hHT.cbw().ccU() != null) {
                    e.this.hHT.cbw().ccU().notifyDataSetChanged();
                }
            }
        }
    };

    public e(l lVar, BdUniqueId bdUniqueId) {
        this.hHT = lVar;
        this.hoJ.setTag(bdUniqueId);
        this.hYX.setTag(bdUniqueId);
        this.iaR.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.iaR);
        MessageManager.getInstance().registerListener(this.hoJ);
        MessageManager.getInstance().registerListener(this.hYX);
        this.hoK.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.hoK);
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
        if (this.hHT != null && this.hHT.cbr() != null && this.hHT.cbr().cgN() != null) {
            final String h = h(customResponsedMessage);
            if (!StringUtils.isNull(h) && this.hHT.cbw() != null && this.hHT.cbw().ccU() != null) {
                final View childAt = this.hHT.cbw().getListView().getChildAt(a(h, this.hHT.cbw().getListView()));
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
                            if (e.this.hHT != null && e.this.hHT.cbw() != null && e.this.hHT.cbw().getListView() != null && e.this.hHT.cbw().ccU() != null) {
                                e.this.hHT.cbw().getListView().removeView(childAt);
                                e.this.Gq(h);
                                e.this.hHT.cbw().ccU().notifyDataSetChanged();
                            }
                        }
                    });
                } else {
                    Gq(h);
                    this.hHT.cbw().ccU().notifyDataSetChanged();
                }
                chy();
            }
        }
    }

    private void chy() {
        if (this.iaQ != null && this.iaQ.dUF) {
            TbPageTag tbPageTag = null;
            if (this.hHT != null && this.hHT.cbw() != null) {
                tbPageTag = com.baidu.tbadk.pageInfo.c.eb(this.hHT.cbw().getContext());
            }
            com.baidu.tieba.frs.d.a.a(this.iaQ, tbPageTag);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.hHT != null && this.hHT.cbr() != null && this.hHT.cbr().cgN() != null) {
            JSONObject jSONObject = (JSONObject) customResponsedMessage.getData();
            final String optString = jSONObject.optString("type");
            if (!StringUtils.isNull(optString)) {
                final String optString2 = jSONObject.optString("tid");
                if (this.hHT.cbw() != null && this.hHT.cbw().ccU() != null) {
                    final View childAt = this.hHT.cbw().getListView().getChildAt(a(optString, optString2, this.hHT.cbw().getListView()));
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
                                e.this.en(optString, optString2);
                                childAt.setVisibility(8);
                                if (e.this.hHT.cbw() != null && e.this.hHT.cbw().ccU() != null) {
                                    e.this.hHT.cbw().ccU().notifyDataSetChanged();
                                }
                            }
                        });
                        return;
                    }
                    en(optString, optString2);
                    this.hHT.cbw().ccU().notifyDataSetChanged();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void en(String str, String str2) {
        ArrayList<q> threadList = this.hHT.cbr().cgN().getThreadList();
        c(str, str2, threadList);
        c(str, str2, this.hHT.cbw().getListView().getData());
        if (str.equals("ala_frs_stage_live_feed_back_type")) {
            this.hHT.cbr().Gn(str2);
        } else if (str.equals("ala_frs_demo_hell_live_feed_back_type")) {
            this.hHT.cbr().Go(str2);
        }
        if (threadList != null && threadList.size() < 5) {
            this.hHT.bwE();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Gq(String str) {
        if (!StringUtils.isNull(str)) {
            ArrayList<q> threadList = this.hHT.cbr().cgN().getThreadList();
            h(str, threadList);
            h(str, this.hHT.cbw().getListView().getData());
            h(str, this.hHT.cbs().getDataList());
            this.hHT.cbr().Go(str);
            if (threadList != null && threadList.size() < 5) {
                this.hHT.bwE();
            }
        }
    }

    private void c(String str, String str2, List<q> list) {
        if (x.getCount(list) != 0) {
            ArrayList arrayList = new ArrayList();
            for (q qVar : list) {
                if (str.equals("ala_frs_stage_live_feed_back_type")) {
                    if (qVar instanceof com.baidu.tieba.tbadkCore.h) {
                        arrayList.add((com.baidu.tieba.tbadkCore.h) qVar);
                    }
                } else if (str.equals("ala_frs_demo_hell_live_feed_back_type") && (qVar instanceof bu)) {
                    bv bvVar = ((bu) qVar).dLK;
                    if (bvVar.getTid() != null && bvVar.getTid().equals(str2)) {
                        arrayList.add(bvVar);
                    }
                }
            }
            list.removeAll(arrayList);
            q qVar2 = (q) x.getItem(list, 0);
            if (qVar2 instanceof v) {
                list.remove(qVar2);
            }
        }
    }

    private void h(String str, List<q> list) {
        if (x.getCount(list) != 0) {
            ArrayList arrayList = new ArrayList();
            for (q qVar : list) {
                if (qVar instanceof bu) {
                    bv bvVar = ((bu) qVar).dLK;
                    if (bvVar.getTid() != null && bvVar.getTid().equals(str)) {
                        arrayList.add(qVar);
                    }
                }
            }
            list.removeAll(arrayList);
            q qVar2 = (q) x.getItem(list, 0);
            if (qVar2 instanceof v) {
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
                if (item instanceof bu) {
                    bv bvVar = ((bu) item).dLK;
                    if (bvVar.getTid() != null && bvVar.getTid().equals(str2)) {
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
            if (item instanceof bu) {
                bv bvVar = ((bu) item).dLK;
                if (bvVar.getTid() != null && bvVar.getTid().equals(str)) {
                    this.iaQ = bvVar;
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
                if (next != null && str.equals(next.dMW)) {
                    it.remove();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(String str, List<q> list) {
        if (list != null && list.size() > 0 && !TextUtils.isEmpty(str)) {
            Iterator<q> it = list.iterator();
            while (it.hasNext()) {
                q next = it.next();
                if (next instanceof com.baidu.tieba.InjectPlugin.a) {
                    Object bqq = ((com.baidu.tieba.InjectPlugin.a) next).bqq();
                    if ((bqq instanceof AdvertAppInfo) && str.equals(((AdvertAppInfo) bqq).dMW)) {
                        it.remove();
                    }
                }
            }
        }
    }
}
