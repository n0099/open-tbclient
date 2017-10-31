package com.baidu.tieba.homepage.personalize;

import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.af;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tbadk.util.h;
import com.baidu.tbadk.util.r;
import com.baidu.tbadk.util.s;
import com.baidu.tieba.ala.LiveRoomClosedQueryMessage;
import com.baidu.tieba.card.u;
import com.baidu.tieba.d;
import com.baidu.tieba.e.a;
import com.baidu.tieba.frs.as;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import com.baidu.tieba.homepage.personalize.a.l;
import com.baidu.tieba.play.m;
import com.squareup.wire.Wire;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;
import tbclient.App;
import tbclient.BannerList;
import tbclient.GodInfo;
import tbclient.Personalized.DataRes;
import tbclient.ThreadInfo;
import tbclient.User;
import tbclient.Zan;
/* loaded from: classes.dex */
public class e {
    private r aMz;
    private View.OnTouchListener axV;
    private com.baidu.tieba.e.a cRm;
    private com.baidu.tieba.tbadkCore.data.e cxx;
    private m czn;
    private boolean dcb;
    private final l dgB;
    private final long dgQ;
    private final b dgR;
    private DataRes.Builder dgT;
    private as dgX;
    private final com.baidu.tieba.homepage.personalize.model.a dgY;
    private ScrollFragmentTabHost dha;
    private int dhd;
    private int dhf;
    private Runnable dhl;
    private final BdTypeListView mListView;
    private final com.baidu.adp.base.e<?> mPageContext;
    private a dgS = null;
    private final List<com.baidu.adp.widget.ListView.f> mDataList = new LinkedList();
    private int mPn = 1;
    private boolean mIsLoading = false;
    private boolean ddO = false;
    private long dgU = 0;
    private int dgV = 1;
    private int dgW = 0;
    private TextView acd = null;
    private int cAV = 2000;
    private com.baidu.tbadk.l.f dgZ = null;
    private boolean czg = false;
    private int cyI = 0;
    private int bfl = 0;
    private boolean mIsBackground = false;
    private boolean dhb = true;
    private boolean dhc = false;
    private boolean dhe = false;
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.e.12
        private int ddT = -1;
        private int ddU = 0;
        private boolean ddV = false;

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (e.this.dgZ == null) {
                e.this.dgZ = new com.baidu.tbadk.l.f();
                e.this.dgZ.ft(1005);
                e.this.dgZ.pageType = 1;
            }
            if (e.this.aMz != null && !e.this.mIsBackground) {
                e.this.aMz.onScrollStateChanged(absListView, i);
            }
            e.this.dgZ.FP();
            if (i == 0) {
                u.ZX().cv(true);
                if (this.ddV) {
                    e.this.arW();
                }
                this.ddV = false;
                if (e.this.czn != null && e.this.dhb) {
                    e.this.czn.a(e.this.cyI, e.this.bfl, e.this.czg, 1);
                }
            } else if (i == 1 && e.this.dgX != null) {
                e.this.dgX.hideTip();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (this.ddU > i) {
                this.ddV = true;
            }
            if (e.this.aMz != null && !e.this.mIsBackground) {
                e.this.aMz.a(absListView, this.ddU, i, i2, i3);
            }
            this.ddU = i;
            int i4 = (i + i2) - 1;
            if (!this.ddV && this.ddT != i4) {
                this.ddT = i4;
                e.this.lv(this.ddT);
            }
            if (this.ddV && this.ddT != i) {
                this.ddT = i;
                e.this.lv(this.ddT);
            }
            e.this.dhk = i;
            e.this.cyI = i;
            e.this.bfl = (i + i2) - 1;
        }
    };
    private View.OnTouchListener aMA = new View.OnTouchListener() { // from class: com.baidu.tieba.homepage.personalize.e.16
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (e.this.axV != null) {
                e.this.axV.onTouch(view, motionEvent);
            }
            if (e.this.cRm != null) {
                e.this.cRm.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private a.InterfaceC0081a bzA = new a.InterfaceC0081a() { // from class: com.baidu.tieba.homepage.personalize.e.17
        @Override // com.baidu.tieba.e.a.InterfaceC0081a
        public void ag(int i, int i2) {
            e.this.czg = true;
        }

        @Override // com.baidu.tieba.e.a.InterfaceC0081a
        public void ah(int i, int i2) {
            e.this.czg = false;
        }

        @Override // com.baidu.tieba.e.a.InterfaceC0081a
        public void ai(int i, int i2) {
        }
    };
    private View.OnClickListener dhg = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.e.18
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (e.this.dgX != null) {
                e.this.dgX.hideTip();
            }
            if (e.this.dgV == 1 && e.this.mListView != null) {
                e.this.mListView.setSelection(0);
                e.this.mListView.startPullRefresh();
            }
        }
    };
    private final CustomMessageListener dhh = new CustomMessageListener(CmdConfigCustom.CMD_RELOAD_HP_PERSONALIZED) { // from class: com.baidu.tieba.homepage.personalize.e.19
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (e.this.mListView != null) {
                e.this.czn.atu();
                e.this.dhb = false;
                e.this.mListView.completePullRefreshPostDelayed(2000L);
                e.this.mListView.startPullRefresh();
            }
        }
    };
    private CustomMessageListener anI = new CustomMessageListener(CmdConfigCustom.PB_ACTION_PRAISE) { // from class: com.baidu.tieba.homepage.personalize.e.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            bh bhVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bh) && e.this.dgT != null && v.u(e.this.dgT.thread_list) != 0 && (bhVar = (bh) customResponsedMessage.getData()) != null && bhVar.ri() != null && bhVar.getId() != null && v.u(e.this.dgT.thread_list) != 0) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < e.this.dgT.thread_list.size()) {
                        ThreadInfo threadInfo = e.this.dgT.thread_list.get(i2);
                        if (threadInfo == null || threadInfo.id.longValue() != com.baidu.adp.lib.g.b.c(bhVar.getId(), -1L)) {
                            i = i2 + 1;
                        } else {
                            ThreadInfo.Builder builder = new ThreadInfo.Builder(threadInfo);
                            Zan.Builder builder2 = new Zan.Builder(builder.zan);
                            builder2.num = Integer.valueOf((int) bhVar.ri().getNum());
                            builder.zan = builder2.build(true);
                            e.this.dgT.thread_list.set(i2, builder.build(true));
                            return;
                        }
                    } else {
                        return;
                    }
                }
            }
        }
    };
    private CustomMessageListener dhi = new CustomMessageListener(CmdConfigCustom.CMD_LIVE_VIDEO_CLOSED_QUERY_RESPONSED) { // from class: com.baidu.tieba.homepage.personalize.e.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            bh bhVar;
            if (customResponsedMessage.getOrginalMessage() instanceof LiveRoomClosedQueryMessage) {
                List<Long> ids = ((LiveRoomClosedQueryMessage) customResponsedMessage.getOrginalMessage()).getIds();
                List<Object> originData = ((LiveRoomClosedQueryMessage) customResponsedMessage.getOrginalMessage()).getOriginData();
                if (!v.v(e.this.mDataList) && !v.v(ids) && !v.v(originData)) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= originData.size()) {
                            break;
                        }
                        if ((originData.get(i2) instanceof bh) && (bhVar = (bh) originData.get(i2)) != null && bhVar.rM() != null && ids.contains(Long.valueOf(bhVar.rM().live_id))) {
                            e.this.mDataList.remove(bhVar);
                        }
                        i = i2 + 1;
                    }
                    if (e.this.dgB != null) {
                        e.this.dgB.br(new ArrayList(e.this.mDataList));
                    }
                }
            }
        }
    };
    private CustomMessageListener mAttentionListener = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.homepage.personalize.e.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int intValue;
            if ((customResponsedMessage instanceof UpdateAttentionMessage) && e.this.dgT != null && !v.v(e.this.dgT.thread_list)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid)) {
                    for (int i = 0; i < e.this.dgT.thread_list.size(); i++) {
                        ThreadInfo threadInfo = e.this.dgT.thread_list.get(i);
                        if (threadInfo != null && threadInfo.author != null && threadInfo.author.id.longValue() == com.baidu.adp.lib.g.b.c(updateAttentionMessage.getData().toUid, -1L)) {
                            ThreadInfo.Builder builder = new ThreadInfo.Builder(threadInfo);
                            User.Builder builder2 = new User.Builder(builder.author);
                            GodInfo.Builder builder3 = new GodInfo.Builder(builder2.god_data);
                            if (updateAttentionMessage.getData().isAttention) {
                                intValue = builder2.fans_num.intValue() + 1;
                                builder3.followed = 1;
                            } else {
                                intValue = builder2.fans_num.intValue() - 1;
                                builder3.followed = 0;
                            }
                            builder2.fans_num = Integer.valueOf(intValue);
                            builder2.god_data = builder3.build(true);
                            builder.author = builder2.build(true);
                            e.this.dgT.thread_list.set(i, builder.build(true));
                            return;
                        }
                    }
                }
            }
        }
    };
    private String dhj = "lastReadReadPositionKey";
    private int dhk = 0;
    private d dhm = new d() { // from class: com.baidu.tieba.homepage.personalize.e.7
        @Override // com.baidu.tieba.homepage.personalize.d
        public void lj(final int i) {
            if (e.this.dhl == null) {
                e.this.dhl = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.e.7.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (e.this.mListView.getHandler() != null) {
                            e.this.mListView.requestFocusFromTouch();
                            if (i <= e.this.mListView.getCount() - 1) {
                                e.this.mListView.setSelection(i);
                            }
                        }
                    }
                };
            }
            e.this.mListView.removeCallbacks(e.this.dhl);
            e.this.mListView.post(e.this.dhl);
        }
    };
    private CustomMessageListener cOv = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.homepage.personalize.e.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.d(customResponsedMessage);
        }
    };
    private CustomMessageListener cOw = new CustomMessageListener(CmdConfigCustom.CMD_THREAD_NOT_EXIST_WHEN_ENTER_PB) { // from class: com.baidu.tieba.homepage.personalize.e.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.d(customResponsedMessage);
        }
    };
    private CustomMessageListener cOx = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.homepage.personalize.e.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && e.this.dgT != null && v.u(e.this.dgT.thread_list) != 0) {
                String str = (String) customResponsedMessage.getData();
                e.this.g(str, e.this.mDataList);
                e.this.lO(str);
                if (e.this.dgB != null) {
                    e.this.dgB.br(new ArrayList(e.this.mDataList));
                }
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void D(int i, int i2, int i3);

        void aP(int i, int i2);

        void onError(int i, String str);

        void onSuccess();
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.dha = scrollFragmentTabHost;
        if (this.dha != null) {
            this.dha.setOnTabSelectedListener(new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.personalize.e.1
                @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
                public void lu(int i) {
                    if (e.this.dha.lt(i) != 1 && e.this.dgX != null) {
                        e.this.dgX.hideTip();
                    }
                }
            });
        }
    }

    public void setTabInForeBackgroundState(boolean z) {
        this.mIsBackground = z;
    }

    public void eA(boolean z) {
        this.mIsBackground = z;
        if (this.czn != null) {
            this.czn.ho(!z);
            if (z) {
                this.czn.atu();
            } else if (this.dhb) {
                this.czn.a(this.cyI, this.bfl, this.czg, true);
            }
        }
    }

    public e(com.baidu.adp.base.e<?> eVar, BdTypeListView bdTypeListView, l lVar) {
        this.mPageContext = eVar;
        this.mListView = bdTypeListView;
        this.mListView.setOnTouchListener(this.aMA);
        this.cRm = new com.baidu.tieba.e.a();
        this.cRm.a(this.bzA);
        this.dgB = lVar;
        this.dgY = new com.baidu.tieba.homepage.personalize.model.a();
        this.dgQ = com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("recommend_frs_cache_time", 43200L) * 1000;
        bdTypeListView.setOnScrollListener(this.mOnScrollListener);
        this.dgX = new as();
        arX();
        this.czn = new m(this.mPageContext, this.mListView);
        this.dgR = new b(this.mDataList, this.dgB);
    }

    private boolean arP() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean(arR(), true);
    }

    private void arQ() {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean(arR(), false);
    }

    private String arR() {
        return "key_rec_pfirst_load_" + TbadkCoreApplication.getCurrentAccount() + "_" + TbConfig.getVersion();
    }

    public void setHeaderViewHeight(int i) {
        this.dhf = i;
    }

    public void setRecommendFrsNavigationAnimDispatcher(s sVar) {
        if (sVar != null) {
            this.aMz = sVar.GY();
            this.axV = sVar.GZ();
        }
    }

    public void showFloatingView() {
        if (this.aMz != null) {
            this.aMz.bZ(true);
        }
    }

    public void update() {
        if (com.baidu.tieba.homepage.framework.a.arx().li(1) == -1) {
            com.baidu.tieba.homepage.framework.a.arx().h(System.currentTimeMillis(), 1);
        }
        this.mPn = 1;
        this.dhe = true;
        if (this.mDataList.size() == 0 && !this.ddO && !arP()) {
            arq();
        } else {
            arn();
        }
    }

    public void aQ(int i, int i2) {
        bh bhVar;
        if (!v.v(this.mDataList) && this.mDataList.size() > i) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            while (i < this.mDataList.size() && i <= i2) {
                if (this.mDataList.get(i).getType().getId() == bh.Ys.getId() && (bhVar = (bh) this.mDataList.get(i)) != null && bhVar.rM() != null) {
                    arrayList.add(Long.valueOf(bhVar.rM().live_id));
                    arrayList2.add(bhVar);
                }
                i++;
            }
            if (!v.v(arrayList)) {
                MessageManager.getInstance().sendMessage(new LiveRoomClosedQueryMessage(arrayList, arrayList2));
            }
        }
    }

    public void arS() {
        if (this.czn != null && !this.mIsBackground && this.dhb) {
            this.czn.a(this.cyI, this.bfl, this.czg, true);
        }
        if (this.dhc) {
            if (this.dcb) {
                if (fz(false)) {
                    aR(3, this.dgW);
                } else if (this.dhd > 0) {
                    aR(2, this.dgW);
                }
            } else if (!this.dcb && this.dgW == 0) {
                aR(2, 0);
            }
            com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("recommend_frs_refresh_time", System.currentTimeMillis());
            this.dhc = false;
            this.dcb = false;
            this.dhd = 0;
            if (this.dhe) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
            }
            this.dhe = false;
        }
    }

    public void NF() {
        if (!wz() && this.dgS != null) {
            arU();
            this.mPn++;
            setIsLoading(true);
            this.dgS.D(this.mPn, (this.dgT == null || this.dgT.thread_list == null) ? 0 : this.dgT.thread_list.size(), 0);
        }
    }

    public void a(boolean z, boolean z2, DataRes dataRes, int i, String str) {
        setIsLoading(false);
        this.mListView.completePullRefreshPostDelayed(2000L);
        if (z) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("recommend_frs_guide_time", System.currentTimeMillis());
        }
        int size = (this.dgT == null || this.dgT.thread_list == null) ? 0 : this.dgT.thread_list.size();
        if (i != 0 || dataRes == null || !a(true, z, z2, dataRes)) {
            this.dhc = false;
            if (this.mDataList.size() > 0) {
                if (this.dgS != null) {
                    this.dgS.onError(1, str);
                    return;
                }
                return;
            } else if (this.dgS != null) {
                this.dgS.onError(2, str);
                return;
            } else {
                return;
            }
        }
        arQ();
        if (this.dgS != null) {
            this.dgS.onSuccess();
        }
        this.dhc = true;
        this.dcb = z;
        this.dhd = size;
        arr();
    }

    public void fw(boolean z) {
        if (z) {
            this.dgB.notifyDataSetChanged();
        }
        if (!arT()) {
            arW();
        }
    }

    public void onDestroy() {
        if (this.czn != null) {
            this.czn.destroy();
        }
        if (this.dgZ != null) {
            this.dgZ.onDestroy();
        }
        if (this.dgX != null) {
            this.dgX.onDestroy();
        }
        if (this.dgR != null) {
            this.dgR.onDestroy();
        }
        if (this.mListView != null) {
            this.mListView.removeCallbacks(this.dhl);
        }
    }

    public void onPause() {
        lw(this.dhk);
        gz(CmdConfigCustom.CMD_VIEW_PAGER_END_AUTO_SCROLL);
    }

    public void onResume() {
        gz(CmdConfigCustom.CMD_VIEW_PAGER_START_AUTO_SCROLL);
    }

    private void gz(final int i) {
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(i);
        final BdUniqueId uniqueId = this.mPageContext.getUniqueId();
        customResponsedMessage.setOrginalMessage(new CustomMessage<Object>(i, uniqueId) { // from class: com.baidu.tieba.homepage.personalize.PersonalizedUpdateController$7
        });
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
    }

    public boolean arT() {
        if (fz(false)) {
            if (this.mListView != null) {
                this.mListView.setSelection(0);
                this.mListView.startPullRefresh();
            }
            return true;
        }
        return false;
    }

    private void arn() {
        if (this.dgS != null) {
            this.dgS.aP((this.dgT == null || this.dgT.thread_list == null || arV()) ? 0 : this.dgT.thread_list.size(), 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(DataRes dataRes) {
        this.ddO = true;
        if (dataRes != null) {
            if (a(false, true, true, dataRes) && !arV()) {
                if (this.dgS != null) {
                    this.dgS.onSuccess();
                }
                arW();
                return;
            }
            arn();
            return;
        }
        arn();
    }

    private void bu(List<com.baidu.adp.widget.ListView.f> list) {
        if (!v.v(list)) {
            for (com.baidu.adp.widget.ListView.f fVar : list) {
                if (fVar instanceof com.baidu.tieba.card.data.d) {
                    com.baidu.tieba.card.data.d dVar = (com.baidu.tieba.card.data.d) fVar;
                    if (dVar.aag() != null) {
                        dVar.aag().advertAppContext = new com.baidu.tbadk.core.data.b();
                        dVar.aag().advertAppContext.TL = "NEWINDEX";
                        dVar.aag().advertAppContext.pn = 1;
                        dVar.aag().advertAppContext.extensionInfo = dVar.aag().extensionInfo;
                        dVar.aag().advertAppContext.TR = false;
                    }
                }
            }
        }
    }

    private boolean a(boolean z, boolean z2, boolean z3, DataRes dataRes) {
        List<com.baidu.adp.widget.ListView.f> list;
        boolean z4;
        if (dataRes == null) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        this.dgU = dataRes.sug_seconds.intValue() * 1000;
        if (z2 && arV()) {
            this.dgT = null;
        }
        int size = z2 ? 0 : this.mDataList.size();
        DataRes.Builder builder = new DataRes.Builder(dataRes);
        this.mDataList.clear();
        com.baidu.tieba.homepage.personalize.model.c a2 = this.dgY.a(z, this.dgT, builder, z2 ? 0 : 1);
        if (a2 == null) {
            list = null;
        } else {
            List<com.baidu.adp.widget.ListView.f> list2 = a2.aUt;
            this.dgW = a2.dig;
            list = list2;
        }
        if (list != null) {
            this.mDataList.addAll(list);
            bu(list);
            a(z2 ? 0 : 1, list, size);
            if (this.dhe) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
            }
        }
        if (this.dgT == null) {
            this.dgT = builder;
            this.dgR.bs(this.dgT.thread_list);
        }
        if (this.mDataList.size() == 0) {
            z4 = false;
        } else {
            LinkedList linkedList = new LinkedList(this.mDataList);
            this.dgB.setFromCDN(dataRes.is_new_url.intValue() == 1);
            this.dgB.br(linkedList);
            z4 = true;
            if (this.czn != null && this.dhb) {
                this.czn.a(this.cyI, this.bfl, this.czg, true);
            }
        }
        com.baidu.tieba.homepage.framework.a.arx().f(System.currentTimeMillis() - currentTimeMillis, 1);
        long li = com.baidu.tieba.homepage.framework.a.arx().li(1);
        if (li > 0) {
            com.baidu.tieba.homepage.framework.a.arx().g(System.currentTimeMillis() - li, 1);
            com.baidu.tieba.homepage.framework.a.arx().h(0L, 1);
            return z4;
        }
        return z4;
    }

    private void arU() {
        if (v.u(this.mDataList) >= this.dgY.asd() - 40) {
            com.baidu.tieba.homepage.personalize.model.c a2 = this.dgY.a(true, this.dgT, (DataRes.Builder) null, 1);
            List<com.baidu.adp.widget.ListView.f> list = a2 != null ? a2.aUt : null;
            if (list != null) {
                this.mDataList.clear();
                this.mDataList.addAll(list);
                this.dgB.br(new LinkedList(this.mDataList));
            }
        }
    }

    private void arq() {
        com.baidu.tbadk.util.v.a(new com.baidu.tbadk.util.u<DataRes>() { // from class: com.baidu.tieba.homepage.personalize.e.20
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.u
            /* renamed from: asa */
            public DataRes doInBackground() {
                com.baidu.adp.lib.cache.l<byte[]> M = com.baidu.tbadk.core.c.a.td().M("tb.rec_frs_update", TbadkCoreApplication.getCurrentAccount());
                if (M == null) {
                    return null;
                }
                byte[] bArr = M.get("0");
                if (bArr == null || bArr.length == 0) {
                    return null;
                }
                try {
                    return (DataRes) new Wire(new Class[0]).parseFrom(bArr, DataRes.class);
                } catch (IOException e) {
                    BdLog.e(e);
                    return null;
                }
            }
        }, new h<DataRes>() { // from class: com.baidu.tieba.homepage.personalize.e.21
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.h
            /* renamed from: b */
            public void onReturnDataInUI(DataRes dataRes) {
                e.this.a(dataRes);
            }
        });
    }

    private void arr() {
        if (this.dgT != null) {
            DataRes.Builder builder = new DataRes.Builder(this.dgT.build(true));
            if (builder.thread_list != null && builder.thread_list.size() > 30) {
                builder.thread_list = builder.thread_list.subList(0, 30);
            }
            a(builder, builder.thread_list != null ? builder.thread_list.size() : 0);
            a(builder);
        }
    }

    private void a(DataRes.Builder builder, int i) {
        if (builder != null && builder.banner_list != null && builder.banner_list.app != null) {
            BannerList.Builder builder2 = new BannerList.Builder(builder.banner_list);
            if (builder2.app != null) {
                Iterator<App> it = builder2.app.iterator();
                int i2 = 0;
                while (it.hasNext()) {
                    App next = it.next();
                    if (next != null) {
                        int g = com.baidu.adp.lib.g.b.g(next.pos_name, -1);
                        if (g < 0) {
                            it.remove();
                        } else if (g < i + i2 + 1) {
                            i2++;
                        } else {
                            it.remove();
                        }
                    } else {
                        it.remove();
                    }
                    i2 = i2;
                }
                builder.banner_list = builder2.build(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lO(String str) {
        if (!TextUtils.isEmpty(str) && this.dgT != null && this.dgT.banner_list != null && this.dgT.banner_list.app != null && this.dgT.banner_list.app.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (App app : this.dgT.banner_list.app) {
                if (app != null && str.equals(app.id)) {
                    arrayList.add(app);
                }
            }
            BannerList.Builder builder = new BannerList.Builder(this.dgT.banner_list);
            if (builder.app != null) {
                builder.app.removeAll(arrayList);
            }
            this.dgT.banner_list = builder.build(false);
            DataRes.Builder builder2 = new DataRes.Builder(this.dgT.build(true));
            builder2.banner_list = builder.build(true);
            a(builder2);
        }
    }

    private void a(final DataRes.Builder builder) {
        com.baidu.tbadk.util.v.a(new com.baidu.tbadk.util.u<Object>() { // from class: com.baidu.tieba.homepage.personalize.e.2
            @Override // com.baidu.tbadk.util.u
            public Object doInBackground() {
                DataRes.Builder builder2 = new DataRes.Builder(builder.build(true));
                e.this.dgR.bt(builder2.thread_list);
                try {
                    com.baidu.tbadk.core.c.a.td().M("tb.rec_frs_update", TbadkCoreApplication.getCurrentAccount()).e("0", builder2.build(true).toByteArray());
                    return null;
                } catch (Exception e) {
                    BdLog.e(e);
                    return null;
                }
            }
        }, null);
    }

    private boolean arV() {
        return fz(true);
    }

    private boolean fz(boolean z) {
        long j = com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("recommend_frs_refresh_time", 0L);
        return j == 0 ? z : Math.abs(System.currentTimeMillis() - j) > this.dgQ;
    }

    public void a(a aVar) {
        this.dgS = aVar;
    }

    private boolean wz() {
        return this.mIsLoading;
    }

    private void setIsLoading(boolean z) {
        this.mIsLoading = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void arW() {
        long j = com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("recommend_frs_guide_time", 0L);
        if (this.dgU != 0) {
            if (j == 0 || Math.abs(System.currentTimeMillis() - j) > this.dgU) {
                aR(1, 0);
            }
        }
    }

    private void aR(int i, int i2) {
        FrameLayout.LayoutParams layoutParams;
        if (this.dha != null) {
            this.dgX.akq();
        }
        if (this.dha != null && this.dha.getCurrentTabType() != 1) {
            this.dgX.hideTip();
            return;
        }
        this.dgV = i;
        String str = null;
        if (i == 1) {
            str = TbadkCoreApplication.getInst().getString(d.j.recommend_frs_refresh_guide);
        } else if (i == 2) {
            if (i2 > 0) {
                str = String.format(TbadkCoreApplication.getInst().getString(d.j.recommend_frs_refresh_return), Integer.valueOf(i2));
            } else {
                str = TbadkCoreApplication.getInst().getString(d.j.recommend_frs_refresh_nodata);
            }
        } else if (i == 3) {
            str = TbadkCoreApplication.getInst().getString(d.j.recommend_frs_refresh_cache_invalid);
        }
        if (!TextUtils.isEmpty(str)) {
            if (this.acd == null) {
                this.acd = new TextView(this.mPageContext.getPageActivity());
                this.acd.setGravity(17);
                this.acd.setOnClickListener(this.dhg);
            }
            this.dgX.akq();
            FrameLayout frameLayout = this.dha.getFrameLayout();
            if (frameLayout != null && this.acd.getParent() == null) {
                if (i == 1) {
                    if (j.hh()) {
                        int dimensionPixelSize = this.mPageContext.getResources().getDimensionPixelSize(d.e.ds20);
                        int dimensionPixelSize2 = this.mPageContext.getResources().getDimensionPixelSize(d.e.ds40);
                        this.acd.setPadding(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
                        this.acd.setTextSize(0, this.mPageContext.getResources().getDimensionPixelSize(d.e.fontsize28));
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("recommend_frs_guide_time", System.currentTimeMillis());
                        aj.j(this.acd, d.f.bg_home_float);
                        aj.i(this.acd, d.C0080d.cp_link_tip_a);
                        layoutParams = new FrameLayout.LayoutParams(-2, -2);
                        layoutParams.gravity = 49;
                        layoutParams.topMargin = this.dhf;
                    } else {
                        return;
                    }
                } else {
                    this.acd.setPadding(0, 0, 0, 0);
                    this.acd.setTextSize(0, this.mPageContext.getResources().getDimensionPixelSize(d.e.fontsize24));
                    aj.j(this.acd, d.C0080d.common_color_10260);
                    aj.i(this.acd, d.C0080d.cp_cont_g);
                    layoutParams = new FrameLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.f(TbadkCoreApplication.getInst(), d.e.ds56));
                    layoutParams.gravity = 49;
                    layoutParams.topMargin = this.dhf;
                }
                this.acd.setText(str);
                if (i == 1) {
                    this.cAV = 4000;
                } else {
                    this.cAV = 2000;
                }
                this.dgX.a(this.acd, frameLayout, layoutParams, this.cAV);
            }
        }
    }

    public void k(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            if (this.anI != null) {
                this.anI.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.anI);
            }
            if (this.dhh != null) {
                this.dhh.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.dhh);
            }
            this.mAttentionListener.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.mAttentionListener);
            this.dhi.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.dhi);
            this.cOv.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.cOv);
            this.cOw.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.cOw);
            this.cOx.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.cOx);
            if (this.czn != null) {
                this.czn.setUniqueId(bdUniqueId);
            }
            this.dgR.h(bdUniqueId);
        }
    }

    public void arX() {
        this.cxx = new com.baidu.tieba.tbadkCore.data.e("new_index", null);
        this.cxx.btW();
    }

    public void a(int i, List<com.baidu.adp.widget.ListView.f> list, int i2) {
        int i3;
        int i4;
        if (this.cxx != null) {
            if (i == 0) {
                this.cxx.btW();
            }
            if (list != null && !list.isEmpty()) {
                int[] iArr = com.baidu.tieba.tbadkCore.data.e.goL;
                int i5 = 0;
                int i6 = 0;
                int i7 = 0;
                while (i7 < list.size() && i6 < iArr.length && (i3 = iArr[i6]) >= 0) {
                    if (list.get(i7) instanceof com.baidu.tieba.card.data.c) {
                        i4 = i5 + 1;
                        if (i4 == i3 - 1) {
                            if (i2 < i7 + 1) {
                                this.cxx.bU(i3, i7 + 1);
                            }
                            i6++;
                        }
                    } else {
                        i4 = i5;
                    }
                    i7++;
                    i6 = i6;
                    i5 = i4;
                }
            }
        }
    }

    public void lv(int i) {
        if ((this.cxx != null ? this.cxx.tO(i) : -1) >= 0 && this.mListView != null && this.mListView.getData() != null && this.mListView.getData().size() > i) {
            this.cxx.tP(i);
        }
    }

    public m ajv() {
        return this.czn;
    }

    public void fA(boolean z) {
        this.dhb = z;
    }

    public void lw(final int i) {
        com.baidu.tbadk.util.v.a(new com.baidu.tbadk.util.u<Object>() { // from class: com.baidu.tieba.homepage.personalize.e.6
            @Override // com.baidu.tbadk.util.u
            public Object doInBackground() {
                com.baidu.adp.lib.cache.l<String> N = com.baidu.tbadk.core.c.a.td().N(e.this.dhj, TbadkCoreApplication.getCurrentAccount());
                if (N != null) {
                    N.a(e.this.dhj, Integer.toString(i), 43200000L);
                    return null;
                }
                return null;
            }
        }, null);
    }

    public void a(final d dVar) {
        com.baidu.tbadk.util.v.a(new com.baidu.tbadk.util.u<String>() { // from class: com.baidu.tieba.homepage.personalize.e.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.u
            /* renamed from: arZ */
            public String doInBackground() {
                com.baidu.adp.lib.cache.l<String> N = com.baidu.tbadk.core.c.a.td().N(e.this.dhj, TbadkCoreApplication.getCurrentAccount());
                if (N != null) {
                    return N.get(e.this.dhj);
                }
                return null;
            }
        }, new h<String>() { // from class: com.baidu.tieba.homepage.personalize.e.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.h
            /* renamed from: lP */
            public void onReturnDataInUI(String str) {
                if (dVar != null) {
                    dVar.lj(com.baidu.adp.lib.g.b.g(str, 0));
                }
            }
        });
    }

    public void arY() {
        a(this.dhm);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.dgT != null && v.u(this.dgT.thread_list) != 0 && v.u(this.mDataList) != 0) {
            String optString = ((JSONObject) customResponsedMessage.getData()).optString("tid");
            if (!StringUtils.isNull(optString)) {
                if (this.mListView != null && this.mListView.getAdapter() != null) {
                    View childAt = this.mListView.getChildAt(a(optString, this.mListView));
                    if (childAt != null) {
                        aC(childAt);
                    } else if (this.dgB != null) {
                        this.dgB.br(new ArrayList(this.mDataList));
                    }
                }
                Iterator<com.baidu.adp.widget.ListView.f> it = this.mDataList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    com.baidu.adp.widget.ListView.f next = it.next();
                    if (next instanceof com.baidu.tieba.card.data.c) {
                        com.baidu.tieba.card.data.c cVar = (com.baidu.tieba.card.data.c) next;
                        if (cVar.Np() != null && cVar.Np().getTid() != null && cVar.Np().getTid().equals(optString)) {
                            it.remove();
                            com.baidu.tieba.homepage.personalize.model.b.bw(this.mDataList);
                            break;
                        }
                    }
                }
                if (this.dgT != null && this.dgT.thread_list != null) {
                    long c = com.baidu.adp.lib.g.b.c(optString, 0L);
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < this.dgT.thread_list.size()) {
                            ThreadInfo threadInfo = this.dgT.thread_list.get(i2);
                            if (threadInfo == null || threadInfo.tid == null || threadInfo.tid.longValue() != c) {
                                i = i2 + 1;
                            } else {
                                this.dgT.thread_list.remove(i2);
                                arr();
                                com.baidu.tieba.homepage.personalize.b.d.a(threadInfo.tid.longValue(), i2, this.dgT.thread_list, this.mDataList);
                                return;
                            }
                        } else {
                            return;
                        }
                    }
                }
            }
        }
    }

    private int a(String str, BdTypeListView bdTypeListView) {
        int headerViewsCount = bdTypeListView.getHeaderViewsCount();
        int firstVisiblePosition = bdTypeListView.getFirstVisiblePosition();
        int i = 0;
        for (int i2 = 0; i2 < bdTypeListView.getAdapter().getCount(); i2++) {
            com.baidu.adp.widget.ListView.f item = bdTypeListView.getItem(i2);
            if (item instanceof com.baidu.tieba.card.data.c) {
                com.baidu.tieba.card.data.c cVar = (com.baidu.tieba.card.data.c) item;
                if (cVar.Np() != null && cVar.Np().getTid().equals(str)) {
                    i = i2;
                }
            }
        }
        return (i + headerViewsCount) - firstVisiblePosition;
    }

    private void aC(final View view) {
        final int measuredHeight = view.getMeasuredHeight();
        Animation animation = new Animation() { // from class: com.baidu.tieba.homepage.personalize.e.13
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
        animation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.homepage.personalize.e.14
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation2) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation2) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation2) {
                view.setVisibility(8);
                if (e.this.dgB != null) {
                    e.this.dgB.br(new ArrayList(e.this.mDataList));
                }
            }
        });
        animation.setDuration(300L);
        view.startAnimation(animation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(String str, List<com.baidu.adp.widget.ListView.f> list) {
        AdvertAppInfo advertAppInfo;
        if (list != null && list.size() > 0 && !TextUtils.isEmpty(str)) {
            Iterator<com.baidu.adp.widget.ListView.f> it = list.iterator();
            AdvertAppInfo advertAppInfo2 = null;
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.f next = it.next();
                if (next instanceof com.baidu.tieba.homepage.personalize.data.a) {
                    advertAppInfo = ((com.baidu.tieba.homepage.personalize.data.a) next).aag();
                } else {
                    if (next instanceof af) {
                        af afVar = (af) next;
                        if (afVar.pZ() instanceof AdvertAppInfo.ILegoAdvert) {
                            advertAppInfo = ((AdvertAppInfo.ILegoAdvert) afVar.pZ()).getAdvertAppInfo();
                        }
                    }
                    advertAppInfo = advertAppInfo2;
                }
                if (advertAppInfo != null && str.equals(advertAppInfo.Ug)) {
                    it.remove();
                    advertAppInfo = null;
                }
                advertAppInfo2 = advertAppInfo;
            }
        }
    }
}
