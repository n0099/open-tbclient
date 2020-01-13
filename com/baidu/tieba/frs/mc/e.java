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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.tieba.frs.q;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class e {
    private bj gFw;
    private l gnU;
    private CustomMessageListener gFx = new CustomMessageListener(CmdConfigCustom.CMD_BUSINESS_NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.frs.mc.e.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.i(customResponsedMessage);
        }
    };
    private CustomMessageListener gFy = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.frs.mc.e.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.h(customResponsedMessage);
        }
    };
    private CustomMessageListener gFz = new CustomMessageListener(CmdConfigCustom.CMD_THREAD_NOT_EXIST_WHEN_ENTER_PB) { // from class: com.baidu.tieba.frs.mc.e.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.Bq(e.this.g(customResponsedMessage));
            e.this.gnU.bCk().bDA().notifyDataSetChanged();
        }
    };
    private CustomMessageListener gDA = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.frs.mc.e.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && e.this.gnU != null && e.this.gnU.bCf() != null && e.this.gnU.bCf().bHj() != null) {
                String str = (String) customResponsedMessage.getData();
                e.this.g(str, e.this.gnU.bCf().bHj().getForum().getBannerListData().getAllAdvertList());
                e.this.h(str, e.this.gnU.bCk().getListView().getData());
                e.this.h(str, e.this.gnU.bCg().bHz().getDataList());
                e.this.gnU.bCf().Bp(str);
                if (e.this.gnU.bCk() != null && e.this.gnU.bCk().bDA() != null) {
                    e.this.gnU.bCk().bDA().notifyDataSetChanged();
                }
            }
        }
    };

    public e(l lVar, BdUniqueId bdUniqueId) {
        this.gnU = lVar;
        this.gFy.setTag(bdUniqueId);
        this.gDA.setTag(bdUniqueId);
        this.gFx.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.gFx);
        MessageManager.getInstance().registerListener(this.gFy);
        MessageManager.getInstance().registerListener(this.gDA);
        this.gFz.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.gFz);
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
        if (this.gnU != null && this.gnU.bCf() != null && this.gnU.bCf().bHj() != null) {
            final String g = g(customResponsedMessage);
            if (!StringUtils.isNull(g) && this.gnU.bCk() != null && this.gnU.bCk().bDA() != null) {
                final View childAt = this.gnU.bCk().getListView().getChildAt(a(g, this.gnU.bCk().getListView()));
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
                            if (e.this.gnU != null && e.this.gnU.bCk() != null && e.this.gnU.bCk().getListView() != null && e.this.gnU.bCk().bDA() != null) {
                                e.this.gnU.bCk().getListView().removeView(childAt);
                                e.this.Bq(g);
                                e.this.gnU.bCk().bDA().notifyDataSetChanged();
                            }
                        }
                    });
                } else {
                    Bq(g);
                    this.gnU.bCk().bDA().notifyDataSetChanged();
                }
                bHR();
            }
        }
    }

    private void bHR() {
        if (this.gFw != null && this.gFw.cQj) {
            TbPageTag tbPageTag = null;
            if (this.gnU != null && this.gnU.bCk() != null) {
                tbPageTag = com.baidu.tbadk.pageInfo.c.ea(this.gnU.bCk().getContext());
            }
            com.baidu.tieba.frs.d.a.a(this.gFw, tbPageTag);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.gnU != null && this.gnU.bCf() != null && this.gnU.bCf().bHj() != null) {
            JSONObject jSONObject = (JSONObject) customResponsedMessage.getData();
            final String optString = jSONObject.optString("type");
            if (!StringUtils.isNull(optString)) {
                final String optString2 = jSONObject.optString("tid");
                if (this.gnU.bCk() != null && this.gnU.bCk().bDA() != null) {
                    final View childAt = this.gnU.bCk().getListView().getChildAt(a(optString, optString2, this.gnU.bCk().getListView()));
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
                                e.this.di(optString, optString2);
                                childAt.setVisibility(8);
                                if (e.this.gnU.bCk() != null && e.this.gnU.bCk().bDA() != null) {
                                    e.this.gnU.bCk().bDA().notifyDataSetChanged();
                                }
                            }
                        });
                        return;
                    }
                    di(optString, optString2);
                    this.gnU.bCk().bDA().notifyDataSetChanged();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void di(String str, String str2) {
        ArrayList<m> threadList = this.gnU.bCf().bHj().getThreadList();
        b(str, str2, threadList);
        b(str, str2, this.gnU.bCk().getListView().getData());
        if (str.equals("ala_frs_stage_live_feed_back_type")) {
            this.gnU.bCf().Bn(str2);
        } else if (str.equals("ala_frs_demo_hell_live_feed_back_type")) {
            this.gnU.bCf().Bo(str2);
        }
        if (threadList != null && threadList.size() < 5) {
            this.gnU.aZN();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bq(String str) {
        if (!StringUtils.isNull(str)) {
            ArrayList<m> threadList = this.gnU.bCf().bHj().getThreadList();
            f(str, threadList);
            f(str, this.gnU.bCk().getListView().getData());
            f(str, this.gnU.bCg().getDataList());
            this.gnU.bCf().Bo(str);
            if (threadList != null && threadList.size() < 5) {
                this.gnU.aZN();
            }
        }
    }

    private void b(String str, String str2, List<m> list) {
        if (v.getCount(list) != 0) {
            ArrayList arrayList = new ArrayList();
            for (m mVar : list) {
                if (str.equals("ala_frs_stage_live_feed_back_type")) {
                    if (mVar instanceof com.baidu.tieba.tbadkCore.g) {
                        arrayList.add((com.baidu.tieba.tbadkCore.g) mVar);
                    }
                } else if (str.equals("ala_frs_demo_hell_live_feed_back_type") && (mVar instanceof bi)) {
                    bj bjVar = ((bi) mVar).cNb;
                    if (bjVar.getTid() != null && bjVar.getTid().equals(str2)) {
                        arrayList.add(bjVar);
                    }
                }
            }
            list.removeAll(arrayList);
            m mVar2 = (m) v.getItem(list, 0);
            if (mVar2 instanceof q) {
                list.remove(mVar2);
            }
        }
    }

    private void f(String str, List<m> list) {
        if (v.getCount(list) != 0) {
            ArrayList arrayList = new ArrayList();
            for (m mVar : list) {
                if (mVar instanceof bi) {
                    bj bjVar = ((bi) mVar).cNb;
                    if (bjVar.getTid() != null && bjVar.getTid().equals(str)) {
                        arrayList.add(mVar);
                    }
                }
            }
            list.removeAll(arrayList);
            m mVar2 = (m) v.getItem(list, 0);
            if (mVar2 instanceof q) {
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
                if (item instanceof bi) {
                    bj bjVar = ((bi) item).cNb;
                    if (bjVar.getTid() != null && bjVar.getTid().equals(str2)) {
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
            if (item instanceof bi) {
                bj bjVar = ((bi) item).cNb;
                if (bjVar.getTid() != null && bjVar.getTid().equals(str)) {
                    this.gFw = bjVar;
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
                if (next != null && str.equals(next.cIS)) {
                    it.remove();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(String str, List<m> list) {
        if (list != null && list.size() > 0 && !TextUtils.isEmpty(str)) {
            Iterator<m> it = list.iterator();
            while (it.hasNext()) {
                m next = it.next();
                if (next instanceof com.baidu.tieba.InjectPlugin.a) {
                    Object aTd = ((com.baidu.tieba.InjectPlugin.a) next).aTd();
                    if ((aTd instanceof AdvertAppInfo) && str.equals(((AdvertAppInfo) aTd).cIS)) {
                        it.remove();
                    }
                }
            }
        }
    }
}
