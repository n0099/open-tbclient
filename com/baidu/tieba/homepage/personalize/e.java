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
import com.baidu.adp.lib.cache.l;
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
import com.baidu.tbadk.util.p;
import com.baidu.tbadk.util.q;
import com.baidu.tbadk.util.s;
import com.baidu.tbadk.util.t;
import com.baidu.tieba.ala.LiveRoomClosedQueryMessage;
import com.baidu.tieba.card.u;
import com.baidu.tieba.d;
import com.baidu.tieba.e.a;
import com.baidu.tieba.frs.as;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import com.baidu.tieba.homepage.personalize.a.o;
import com.baidu.tieba.homepage.personalize.data.g;
import com.baidu.tieba.homepage.personalize.data.h;
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
import tbclient.Personalized.AgeSexModule;
import tbclient.Personalized.DataRes;
import tbclient.Personalized.TagStruct;
import tbclient.ThreadInfo;
import tbclient.User;
import tbclient.Zan;
/* loaded from: classes.dex */
public class e {
    private p aLY;
    private View.OnTouchListener axx;
    private com.baidu.tieba.e.a cIn;
    private boolean cTw;
    private final long cYK;
    private final b cYL;
    private DataRes.Builder cYN;
    private as cYQ;
    private final com.baidu.tieba.homepage.personalize.model.a cYR;
    private ScrollFragmentTabHost cYT;
    private int cYW;
    private int cYY;
    private final o cYv;
    private Runnable cZi;
    private com.baidu.tieba.tbadkCore.data.e cqp;
    private m csf;
    private final BdTypeListView mListView;
    private final com.baidu.adp.base.e<?> mPageContext;
    private a cYM = null;
    private final List<com.baidu.adp.widget.ListView.f> mDataList = new LinkedList();
    private int mPn = 1;
    private boolean mIsLoading = false;
    private boolean cVH = false;
    private long cYO = 0;
    private int cYP = 1;
    private int cVK = 0;
    private TextView abQ = null;
    private int ctM = 2000;
    private com.baidu.tbadk.k.f cYS = null;
    private boolean crY = false;
    private int crz = 0;
    private int beI = 0;
    private boolean mIsBackground = false;
    private boolean cYU = true;
    private boolean cYV = false;
    private boolean cYX = false;
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.e.11
        private int cVN = -1;
        private int cVO = 0;
        private boolean cVP = false;

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (e.this.cYS == null) {
                e.this.cYS = new com.baidu.tbadk.k.f();
                e.this.cYS.ft(1005);
                e.this.cYS.pageType = 1;
            }
            if (e.this.aLY != null && !e.this.mIsBackground) {
                e.this.aLY.onScrollStateChanged(absListView, i);
            }
            e.this.cYS.FJ();
            if (i == 0) {
                u.XR().cB(true);
                if (this.cVP) {
                    e.this.apC();
                }
                this.cVP = false;
                if (e.this.csf != null && e.this.cYU) {
                    e.this.csf.a(e.this.crz, e.this.beI, e.this.crY, 1);
                }
            } else if (i == 1 && e.this.cYQ != null) {
                e.this.cYQ.hideTip();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (this.cVO > i) {
                this.cVP = true;
            }
            if (e.this.aLY != null && !e.this.mIsBackground) {
                e.this.aLY.a(absListView, this.cVO, i, i2, i3);
            }
            this.cVO = i;
            int i4 = (i + i2) - 1;
            if (!this.cVP && this.cVN != i4) {
                this.cVN = i4;
                e.this.le(this.cVN);
            }
            if (this.cVP && this.cVN != i) {
                this.cVN = i;
                e.this.le(this.cVN);
            }
            e.this.cZh = i;
            e.this.crz = i;
            e.this.beI = (i + i2) - 1;
        }
    };
    private View.OnTouchListener aLZ = new View.OnTouchListener() { // from class: com.baidu.tieba.homepage.personalize.e.19
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (e.this.axx != null) {
                e.this.axx.onTouch(view, motionEvent);
            }
            if (e.this.cIn != null) {
                e.this.cIn.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private a.InterfaceC0081a caG = new a.InterfaceC0081a() { // from class: com.baidu.tieba.homepage.personalize.e.20
        @Override // com.baidu.tieba.e.a.InterfaceC0081a
        public void ao(int i, int i2) {
            e.this.crY = true;
        }

        @Override // com.baidu.tieba.e.a.InterfaceC0081a
        public void ap(int i, int i2) {
            e.this.crY = false;
        }

        @Override // com.baidu.tieba.e.a.InterfaceC0081a
        public void aq(int i, int i2) {
        }
    };
    private View.OnClickListener cYZ = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.e.21
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (e.this.cYQ != null) {
                e.this.cYQ.hideTip();
            }
            if (e.this.cYP == 1 && e.this.mListView != null) {
                e.this.mListView.setSelection(0);
                e.this.mListView.startPullRefresh();
            }
        }
    };
    private final CustomMessageListener cZa = new CustomMessageListener(CmdConfigCustom.CMD_CLOSE_NEW_USER_GUIDE) { // from class: com.baidu.tieba.homepage.personalize.e.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.fE(true);
        }
    };
    private final CustomMessageListener cZb = new CustomMessageListener(CmdConfigCustom.CMD_CLOSE_INTEREST_GUIDE) { // from class: com.baidu.tieba.homepage.personalize.e.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.apD();
        }
    };
    private final CustomMessageListener cZc = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.homepage.personalize.e.24
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.fE(false);
        }
    };
    private final CustomMessageListener cZd = new CustomMessageListener(CmdConfigCustom.CMD_RELOAD_HP_PERSONALIZED) { // from class: com.baidu.tieba.homepage.personalize.e.25
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (e.this.mListView != null) {
                e.this.csf.ard();
                e.this.cYU = false;
                e.this.mListView.completePullRefreshPostDelayed(2000L);
                e.this.mListView.startPullRefresh();
            }
        }
    };
    private final CustomMessageListener cZe = new CustomMessageListener(CmdConfigCustom.CMD_GUIDE_SET_CACHE) { // from class: com.baidu.tieba.homepage.personalize.e.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (e.this.mDataList.size() > 0) {
                if (e.this.mDataList.get(0) instanceof h) {
                    h hVar = (h) e.this.mDataList.get(0);
                    LinkedList linkedList = new LinkedList();
                    LinkedList linkedList2 = new LinkedList();
                    if (hVar.daA != null) {
                        for (g gVar : hVar.daA) {
                            if (gVar != null) {
                                TagStruct.Builder builder = new TagStruct.Builder();
                                builder.tag_name = gVar.tagName;
                                builder.selected = Integer.valueOf(gVar.isSelect ? 1 : 0);
                                linkedList.add(builder.build(false));
                            }
                        }
                    }
                    if (hVar.daB != null) {
                        for (g gVar2 : hVar.daB) {
                            if (gVar2 != null) {
                                TagStruct.Builder builder2 = new TagStruct.Builder();
                                builder2.tag_name = gVar2.tagName;
                                builder2.selected = Integer.valueOf(gVar2.isSelect ? 1 : 0);
                                linkedList2.add(builder2.build(false));
                            }
                        }
                    }
                    if (e.this.cYN != null) {
                        AgeSexModule.Builder builder3 = new AgeSexModule.Builder();
                        builder3.sex_tag = linkedList;
                        builder3.age_tag = linkedList2;
                        e.this.cYN.age_sex = builder3.build(false);
                    }
                } else if (e.this.mDataList.get(0) instanceof com.baidu.tieba.homepage.personalize.data.f) {
                    com.baidu.tieba.homepage.personalize.data.f fVar = (com.baidu.tieba.homepage.personalize.data.f) e.this.mDataList.get(0);
                    if (fVar.daw != null) {
                        LinkedList linkedList3 = new LinkedList();
                        for (g gVar3 : fVar.daw) {
                            if (gVar3 != null) {
                                TagStruct.Builder builder4 = new TagStruct.Builder();
                                builder4.tag_name = gVar3.tagName;
                                builder4.selected = Integer.valueOf(gVar3.isSelect ? 1 : 0);
                                linkedList3.add(builder4.build(false));
                            }
                        }
                        e.this.cYN.interestion = linkedList3;
                    }
                }
                e.this.aoX();
            }
        }
    };
    private CustomMessageListener anz = new CustomMessageListener(CmdConfigCustom.PB_ACTION_PRAISE) { // from class: com.baidu.tieba.homepage.personalize.e.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            bh bhVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bh) && e.this.cYN != null && v.t(e.this.cYN.thread_list) != 0 && (bhVar = (bh) customResponsedMessage.getData()) != null && bhVar.rl() != null && bhVar.getId() != null && v.t(e.this.cYN.thread_list) != 0) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < e.this.cYN.thread_list.size()) {
                        ThreadInfo threadInfo = e.this.cYN.thread_list.get(i2);
                        if (threadInfo == null || threadInfo.id.longValue() != com.baidu.adp.lib.g.b.c(bhVar.getId(), -1L)) {
                            i = i2 + 1;
                        } else {
                            ThreadInfo.Builder builder = new ThreadInfo.Builder(threadInfo);
                            Zan.Builder builder2 = new Zan.Builder(builder.zan);
                            builder2.num = Integer.valueOf((int) bhVar.rl().getNum());
                            builder.zan = builder2.build(true);
                            e.this.cYN.thread_list.set(i2, builder.build(true));
                            return;
                        }
                    } else {
                        return;
                    }
                }
            }
        }
    };
    private CustomMessageListener cZf = new CustomMessageListener(CmdConfigCustom.CMD_LIVE_VIDEO_CLOSED_QUERY_RESPONSED) { // from class: com.baidu.tieba.homepage.personalize.e.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            bh bhVar;
            if (customResponsedMessage.getOrginalMessage() instanceof LiveRoomClosedQueryMessage) {
                List<Long> ids = ((LiveRoomClosedQueryMessage) customResponsedMessage.getOrginalMessage()).getIds();
                List<Object> originData = ((LiveRoomClosedQueryMessage) customResponsedMessage.getOrginalMessage()).getOriginData();
                if (!v.u(e.this.mDataList) && !v.u(ids) && !v.u(originData)) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= originData.size()) {
                            break;
                        }
                        if ((originData.get(i2) instanceof bh) && (bhVar = (bh) originData.get(i2)) != null && bhVar.rN() != null && ids.contains(Long.valueOf(bhVar.rN().live_id))) {
                            e.this.mDataList.remove(bhVar);
                        }
                        i = i2 + 1;
                    }
                    if (e.this.cYv != null) {
                        e.this.cYv.br(new ArrayList(e.this.mDataList));
                    }
                }
            }
        }
    };
    private CustomMessageListener aoT = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.homepage.personalize.e.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int intValue;
            if ((customResponsedMessage instanceof UpdateAttentionMessage) && e.this.cYN != null && !v.u(e.this.cYN.thread_list)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid)) {
                    for (int i = 0; i < e.this.cYN.thread_list.size(); i++) {
                        ThreadInfo threadInfo = e.this.cYN.thread_list.get(i);
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
                            e.this.cYN.thread_list.set(i, builder.build(true));
                            return;
                        }
                    }
                }
            }
        }
    };
    private String cZg = "lastReadReadPositionKey";
    private int cZh = 0;
    private d cZj = new d() { // from class: com.baidu.tieba.homepage.personalize.e.10
        @Override // com.baidu.tieba.homepage.personalize.d
        public void kS(final int i) {
            if (e.this.cZi == null) {
                e.this.cZi = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.e.10.1
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
            e.this.mListView.removeCallbacks(e.this.cZi);
            e.this.mListView.post(e.this.cZi);
        }
    };
    private CustomMessageListener cFu = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.homepage.personalize.e.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.d(customResponsedMessage);
        }
    };
    private CustomMessageListener cFv = new CustomMessageListener(CmdConfigCustom.CMD_THREAD_NOT_EXIST_WHEN_ENTER_PB) { // from class: com.baidu.tieba.homepage.personalize.e.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.d(customResponsedMessage);
        }
    };
    private CustomMessageListener cFw = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.homepage.personalize.e.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && e.this.cYN != null && v.t(e.this.cYN.thread_list) != 0) {
                String str = (String) customResponsedMessage.getData();
                e.this.g(str, e.this.mDataList);
                e.this.lr(str);
                if (e.this.cYv != null) {
                    e.this.cYv.br(new ArrayList(e.this.mDataList));
                }
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void A(int i, int i2, int i3);

        void aO(int i, int i2);

        void onError(int i, String str);

        void onSuccess();
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.cYT = scrollFragmentTabHost;
        if (this.cYT != null) {
            this.cYT.setOnTabSelectedListener(new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.personalize.e.1
                @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
                public void ld(int i) {
                    if (e.this.cYT.lc(i) != 1 && e.this.cYQ != null) {
                        e.this.cYQ.hideTip();
                    }
                }
            });
        }
    }

    public void setTabInForeBackgroundState(boolean z) {
        this.mIsBackground = z;
    }

    public void eF(boolean z) {
        this.mIsBackground = z;
        if (this.csf != null) {
            this.csf.ht(!z);
            if (z) {
                this.csf.ard();
            } else if (this.cYU) {
                this.csf.a(this.crz, this.beI, this.crY, true);
            }
        }
    }

    public e(com.baidu.adp.base.e<?> eVar, BdTypeListView bdTypeListView, o oVar) {
        this.mPageContext = eVar;
        this.mListView = bdTypeListView;
        this.mListView.setOnTouchListener(this.aLZ);
        this.cIn = new com.baidu.tieba.e.a();
        this.cIn.a(this.caG);
        this.cYv = oVar;
        this.cYR = new com.baidu.tieba.homepage.personalize.model.a();
        this.cYK = com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("recommend_frs_cache_time", 43200L) * 1000;
        bdTypeListView.setOnScrollListener(this.mOnScrollListener);
        this.cYQ = new as();
        apE();
        this.csf = new m(this.mPageContext, this.mListView);
        this.cYL = new b(this.mDataList, this.cYv);
    }

    private boolean apv() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean(apx(), true);
    }

    private void apw() {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean(apx(), false);
    }

    private String apx() {
        return "key_rec_pfirst_load_" + TbadkCoreApplication.getCurrentAccount() + "_" + TbConfig.getVersion();
    }

    public void setHeaderViewHeight(int i) {
        this.cYY = i;
    }

    public void setRecommendFrsNavigationAnimDispatcher(q qVar) {
        if (qVar != null) {
            this.aLY = qVar.GS();
            this.axx = qVar.GT();
        }
    }

    public void showFloatingView() {
        if (this.aLY != null) {
            this.aLY.cf(true);
        }
    }

    public void update() {
        if (com.baidu.tieba.homepage.framework.a.apd().kR(1) == -1) {
            com.baidu.tieba.homepage.framework.a.apd().f(System.currentTimeMillis(), 1);
        }
        this.mPn = 1;
        this.cYX = true;
        if (this.mDataList.size() == 0 && !this.cVH && !apv()) {
            aoW();
        } else {
            aoT();
        }
    }

    public void aP(int i, int i2) {
        bh bhVar;
        if (!v.u(this.mDataList) && this.mDataList.size() > i) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            while (i < this.mDataList.size() && i <= i2) {
                if (this.mDataList.get(i).getType().getId() == bh.Ym.getId() && (bhVar = (bh) this.mDataList.get(i)) != null && bhVar.rN() != null) {
                    arrayList.add(Long.valueOf(bhVar.rN().live_id));
                    arrayList2.add(bhVar);
                }
                i++;
            }
            if (!v.u(arrayList)) {
                MessageManager.getInstance().sendMessage(new LiveRoomClosedQueryMessage(arrayList, arrayList2));
            }
        }
    }

    public void apy() {
        if (this.csf != null && !this.mIsBackground && this.cYU) {
            this.csf.a(this.crz, this.beI, this.crY, true);
        }
        if (this.cYV) {
            if (this.cTw) {
                if (fD(false)) {
                    aQ(3, this.cVK);
                } else if (this.cYW > 0) {
                    aQ(2, this.cVK);
                }
            } else if (!this.cTw && this.cVK == 0) {
                aQ(2, 0);
            }
            com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("recommend_frs_refresh_time", System.currentTimeMillis());
            this.cYV = false;
            this.cTw = false;
            this.cYW = 0;
            if (this.cYX) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
            }
            this.cYX = false;
        }
    }

    public void Ny() {
        if (!wz() && this.cYM != null) {
            apA();
            this.mPn++;
            setIsLoading(true);
            this.cYM.A(this.mPn, (this.cYN == null || this.cYN.thread_list == null) ? 0 : this.cYN.thread_list.size(), 0);
        }
    }

    public void a(boolean z, boolean z2, DataRes dataRes, int i, String str) {
        setIsLoading(false);
        this.mListView.completePullRefreshPostDelayed(2000L);
        if (z) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("recommend_frs_guide_time", System.currentTimeMillis());
        }
        int size = (this.cYN == null || this.cYN.thread_list == null) ? 0 : this.cYN.thread_list.size();
        if (i != 0 || dataRes == null || !a(true, z, z2, dataRes)) {
            this.cYV = false;
            if (this.mDataList.size() > 0) {
                if (this.cYM != null) {
                    this.cYM.onError(1, str);
                    return;
                }
                return;
            } else if (this.cYM != null) {
                this.cYM.onError(2, str);
                return;
            } else {
                return;
            }
        }
        apw();
        if (this.cYM != null) {
            this.cYM.onSuccess();
        }
        this.cYV = true;
        this.cTw = z;
        this.cYW = size;
        aoX();
    }

    public void fA(boolean z) {
        if (z) {
            this.cYv.notifyDataSetChanged();
        }
        if (!apz()) {
            apC();
        }
    }

    public void onDestroy() {
        if (this.csf != null) {
            this.csf.destroy();
        }
        if (this.cYS != null) {
            this.cYS.onDestroy();
        }
        if (this.cYQ != null) {
            this.cYQ.onDestroy();
        }
        if (this.cYL != null) {
            this.cYL.onDestroy();
        }
        if (this.mListView != null) {
            this.mListView.removeCallbacks(this.cZi);
        }
    }

    public void onPause() {
        lf(this.cZh);
        gu(CmdConfigCustom.CMD_VIEW_PAGER_END_AUTO_SCROLL);
    }

    public void onResume() {
        gu(CmdConfigCustom.CMD_VIEW_PAGER_START_AUTO_SCROLL);
    }

    private void gu(final int i) {
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(i);
        final BdUniqueId uniqueId = this.mPageContext.getUniqueId();
        customResponsedMessage.setOrginalMessage(new CustomMessage<Object>(i, uniqueId) { // from class: com.baidu.tieba.homepage.personalize.PersonalizedUpdateController$11
        });
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
    }

    public boolean apz() {
        if (fD(false)) {
            if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("close_new_user_guide_tip", false)) {
                fE(true);
            }
            apD();
            if (this.mListView != null) {
                this.mListView.setSelection(0);
                this.mListView.startPullRefresh();
                return true;
            }
            return true;
        }
        return false;
    }

    private void aoT() {
        if (this.cYM != null) {
            this.cYM.aO((this.cYN == null || this.cYN.thread_list == null || apB()) ? 0 : this.cYN.thread_list.size(), 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(DataRes dataRes) {
        this.cVH = true;
        if (dataRes != null) {
            if (a(false, true, true, dataRes) && !apB()) {
                if (this.cYM != null) {
                    this.cYM.onSuccess();
                }
                apC();
                return;
            }
            aoT();
            return;
        }
        aoT();
    }

    private void bu(List<com.baidu.adp.widget.ListView.f> list) {
        if (!v.u(list)) {
            for (com.baidu.adp.widget.ListView.f fVar : list) {
                if (fVar instanceof com.baidu.tieba.card.data.d) {
                    com.baidu.tieba.card.data.d dVar = (com.baidu.tieba.card.data.d) fVar;
                    if (dVar.Ya() != null) {
                        dVar.Ya().advertAppContext = new com.baidu.tbadk.core.data.b();
                        dVar.Ya().advertAppContext.TF = "NEWINDEX";
                        dVar.Ya().advertAppContext.pn = 1;
                        dVar.Ya().advertAppContext.extensionInfo = dVar.Ya().extensionInfo;
                        dVar.Ya().advertAppContext.TK = false;
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
        this.cYO = dataRes.sug_seconds.intValue() * 1000;
        if (z2 && apB()) {
            this.cYN = null;
        }
        int size = z2 ? 0 : this.mDataList.size();
        DataRes.Builder builder = new DataRes.Builder(dataRes);
        this.mDataList.clear();
        com.baidu.tieba.homepage.personalize.model.c a2 = this.cYR.a(z, this.cYN, builder, z2 ? 0 : 1);
        if (a2 == null) {
            list = null;
        } else {
            List<com.baidu.adp.widget.ListView.f> list2 = a2.aUB;
            this.cVK = a2.daE;
            list = list2;
        }
        if (list != null) {
            this.mDataList.addAll(list);
            bu(list);
            a(z2 ? 0 : 1, list, size);
            if (this.cYX) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
            }
        }
        if (this.cYN == null) {
            this.cYN = builder;
            this.cYL.bs(this.cYN.thread_list);
        }
        if (this.mDataList.size() == 0) {
            z4 = false;
        } else {
            LinkedList linkedList = new LinkedList(this.mDataList);
            this.cYv.setFromCDN(dataRes.is_new_url.intValue() == 1);
            this.cYv.br(linkedList);
            z4 = true;
            if (this.csf != null && this.cYU) {
                this.csf.a(this.crz, this.beI, this.crY, true);
            }
        }
        com.baidu.tieba.homepage.framework.a.apd().d(System.currentTimeMillis() - currentTimeMillis, 1);
        long kR = com.baidu.tieba.homepage.framework.a.apd().kR(1);
        if (kR > 0) {
            com.baidu.tieba.homepage.framework.a.apd().e(System.currentTimeMillis() - kR, 1);
            com.baidu.tieba.homepage.framework.a.apd().f(0L, 1);
            return z4;
        }
        return z4;
    }

    private void apA() {
        if (v.t(this.mDataList) >= this.cYR.apM() - 40) {
            com.baidu.tieba.homepage.personalize.model.c a2 = this.cYR.a(true, this.cYN, (DataRes.Builder) null, 1);
            List<com.baidu.adp.widget.ListView.f> list = a2 != null ? a2.aUB : null;
            if (list != null) {
                this.mDataList.clear();
                this.mDataList.addAll(list);
                this.cYv.br(new LinkedList(this.mDataList));
            }
        }
    }

    private void aoW() {
        t.a(new s<DataRes>() { // from class: com.baidu.tieba.homepage.personalize.e.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.s
            /* renamed from: apG */
            public DataRes doInBackground() {
                l<byte[]> N = com.baidu.tbadk.core.c.a.te().N("tb.rec_frs_update", TbadkCoreApplication.getCurrentAccount());
                if (N == null) {
                    return null;
                }
                byte[] bArr = N.get("0");
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
        }, new com.baidu.tbadk.util.g<DataRes>() { // from class: com.baidu.tieba.homepage.personalize.e.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.g
            /* renamed from: b */
            public void onReturnDataInUI(DataRes dataRes) {
                e.this.a(dataRes);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aoX() {
        if (this.cYN != null) {
            DataRes.Builder builder = new DataRes.Builder(this.cYN.build(true));
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
    public void lr(String str) {
        if (!TextUtils.isEmpty(str) && this.cYN != null && this.cYN.banner_list != null && this.cYN.banner_list.app != null && this.cYN.banner_list.app.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (App app : this.cYN.banner_list.app) {
                if (app != null && str.equals(app.id)) {
                    arrayList.add(app);
                }
            }
            BannerList.Builder builder = new BannerList.Builder(this.cYN.banner_list);
            if (builder.app != null) {
                builder.app.removeAll(arrayList);
            }
            this.cYN.banner_list = builder.build(false);
            DataRes.Builder builder2 = new DataRes.Builder(this.cYN.build(true));
            builder2.banner_list = builder.build(true);
            a(builder2);
        }
    }

    private void a(final DataRes.Builder builder) {
        t.a(new s<Object>() { // from class: com.baidu.tieba.homepage.personalize.e.5
            @Override // com.baidu.tbadk.util.s
            public Object doInBackground() {
                DataRes.Builder builder2 = new DataRes.Builder(builder.build(true));
                e.this.cYL.bt(builder2.thread_list);
                try {
                    com.baidu.tbadk.core.c.a.te().N("tb.rec_frs_update", TbadkCoreApplication.getCurrentAccount()).e("0", builder2.build(true).toByteArray());
                    return null;
                } catch (Exception e) {
                    BdLog.e(e);
                    return null;
                }
            }
        }, null);
    }

    private boolean apB() {
        return fD(true);
    }

    private boolean fD(boolean z) {
        long j = com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("recommend_frs_refresh_time", 0L);
        return j == 0 ? z : Math.abs(System.currentTimeMillis() - j) > this.cYK;
    }

    public void a(a aVar) {
        this.cYM = aVar;
    }

    private boolean wz() {
        return this.mIsLoading;
    }

    private void setIsLoading(boolean z) {
        this.mIsLoading = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void apC() {
        long j = com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("recommend_frs_guide_time", 0L);
        if (this.cYO != 0) {
            if (j == 0 || Math.abs(System.currentTimeMillis() - j) > this.cYO) {
                aQ(1, 0);
            }
        }
    }

    private void aQ(int i, int i2) {
        FrameLayout.LayoutParams layoutParams;
        if (this.cYT != null) {
            this.cYQ.ain();
        }
        if (this.cYT != null && this.cYT.getCurrentTabType() != 1) {
            this.cYQ.hideTip();
            return;
        }
        this.cYP = i;
        String str = null;
        if (i == 1) {
            str = TbadkCoreApplication.getInst().getString(d.l.recommend_frs_refresh_guide);
        } else if (i == 2) {
            if (i2 > 0) {
                str = String.format(TbadkCoreApplication.getInst().getString(d.l.recommend_frs_refresh_return), Integer.valueOf(i2));
            } else {
                str = TbadkCoreApplication.getInst().getString(d.l.recommend_frs_refresh_nodata);
            }
        } else if (i == 3) {
            str = TbadkCoreApplication.getInst().getString(d.l.recommend_frs_refresh_cache_invalid);
        }
        if (!TextUtils.isEmpty(str)) {
            if (this.abQ == null) {
                this.abQ = new TextView(this.mPageContext.getPageActivity());
                this.abQ.setGravity(17);
                this.abQ.setOnClickListener(this.cYZ);
            }
            this.cYQ.ain();
            FrameLayout frameLayout = this.cYT.getFrameLayout();
            if (frameLayout != null && this.abQ.getParent() == null) {
                if (i == 1) {
                    if (j.hh()) {
                        int dimensionPixelSize = this.mPageContext.getResources().getDimensionPixelSize(d.f.ds20);
                        int dimensionPixelSize2 = this.mPageContext.getResources().getDimensionPixelSize(d.f.ds40);
                        this.abQ.setPadding(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
                        this.abQ.setTextSize(0, this.mPageContext.getResources().getDimensionPixelSize(d.f.fontsize28));
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("recommend_frs_guide_time", System.currentTimeMillis());
                        aj.j(this.abQ, d.g.bg_home_float);
                        aj.i(this.abQ, d.e.cp_link_tip_a);
                        layoutParams = new FrameLayout.LayoutParams(-2, -2);
                        layoutParams.gravity = 49;
                        layoutParams.topMargin = this.cYY;
                    } else {
                        return;
                    }
                } else {
                    this.abQ.setPadding(0, 0, 0, 0);
                    this.abQ.setTextSize(0, this.mPageContext.getResources().getDimensionPixelSize(d.f.fontsize24));
                    aj.j(this.abQ, d.e.common_color_10260);
                    aj.i(this.abQ, d.e.cp_cont_g);
                    layoutParams = new FrameLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.f(TbadkCoreApplication.getInst(), d.f.ds56));
                    layoutParams.gravity = 49;
                    layoutParams.topMargin = this.cYY;
                }
                this.abQ.setText(str);
                if (i == 1) {
                    this.ctM = 4000;
                } else {
                    this.ctM = 2000;
                }
                this.cYQ.a(this.abQ, frameLayout, layoutParams, this.ctM);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fE(boolean z) {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("close_new_user_guide_tip", true);
        if (this.cYN != null && this.cYN.age_sex != null) {
            this.cYN.age_sex = null;
            if (z) {
                aoX();
            }
        }
        if (this.mDataList != null && this.mDataList.size() > 0 && (this.mDataList.get(0) instanceof h)) {
            this.mDataList.remove(0);
        }
        if (this.mDataList != null) {
            this.cYv.br(new ArrayList(this.mDataList));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void apD() {
        if (this.cYN != null && this.cYN.interestion != null) {
            this.cYN.interestion = null;
            aoX();
        }
        if (this.mDataList != null && this.mDataList.size() > 0 && (this.mDataList.get(0) instanceof com.baidu.tieba.homepage.personalize.data.f)) {
            this.mDataList.remove(0);
        }
        if (this.mDataList != null) {
            this.cYv.br(new ArrayList(this.mDataList));
        }
    }

    public void k(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            if (this.anz != null) {
                this.anz.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.anz);
            }
            if (this.cZa != null) {
                this.cZa.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.cZa);
            }
            if (this.cZb != null) {
                this.cZb.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.cZb);
            }
            if (this.cZc != null) {
                this.cZc.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.cZc);
            }
            if (this.cZd != null) {
                this.cZd.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.cZd);
            }
            this.cZe.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.cZe);
            this.aoT.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.aoT);
            this.cZf.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.cZf);
            this.cFu.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.cFu);
            this.cFv.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.cFv);
            this.cFw.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.cFw);
            if (this.csf != null) {
                this.csf.setUniqueId(bdUniqueId);
            }
            this.cYL.h(bdUniqueId);
        }
    }

    public void apE() {
        this.cqp = new com.baidu.tieba.tbadkCore.data.e("new_index", null);
        this.cqp.bqX();
    }

    public void a(int i, List<com.baidu.adp.widget.ListView.f> list, int i2) {
        int i3;
        int i4;
        if (this.cqp != null) {
            if (i == 0) {
                this.cqp.bqX();
            }
            if (list != null && !list.isEmpty()) {
                int[] iArr = com.baidu.tieba.tbadkCore.data.e.ggj;
                int i5 = 0;
                int i6 = 0;
                int i7 = 0;
                while (i7 < list.size() && i6 < iArr.length && (i3 = iArr[i6]) >= 0) {
                    if (list.get(i7) instanceof com.baidu.tieba.card.data.c) {
                        i4 = i5 + 1;
                        if (i4 == i3 - 1) {
                            if (i2 < i7 + 1) {
                                this.cqp.bS(i3, i7 + 1);
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

    public void le(int i) {
        if ((this.cqp != null ? this.cqp.ty(i) : -1) >= 0 && this.mListView != null && this.mListView.getData() != null && this.mListView.getData().size() > i) {
            this.cqp.tz(i);
        }
    }

    public m ahs() {
        return this.csf;
    }

    public void fF(boolean z) {
        this.cYU = z;
    }

    public void lf(final int i) {
        t.a(new s<Object>() { // from class: com.baidu.tieba.homepage.personalize.e.9
            @Override // com.baidu.tbadk.util.s
            public Object doInBackground() {
                l<String> O = com.baidu.tbadk.core.c.a.te().O(e.this.cZg, TbadkCoreApplication.getCurrentAccount());
                if (O != null) {
                    O.a(e.this.cZg, Integer.toString(i), 43200000L);
                    return null;
                }
                return null;
            }
        }, null);
    }

    public void a(final d dVar) {
        t.a(new s<String>() { // from class: com.baidu.tieba.homepage.personalize.e.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.s
            /* renamed from: apH */
            public String doInBackground() {
                l<String> O = com.baidu.tbadk.core.c.a.te().O(e.this.cZg, TbadkCoreApplication.getCurrentAccount());
                if (O != null) {
                    return O.get(e.this.cZg);
                }
                return null;
            }
        }, new com.baidu.tbadk.util.g<String>() { // from class: com.baidu.tieba.homepage.personalize.e.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.g
            /* renamed from: ls */
            public void onReturnDataInUI(String str) {
                if (dVar != null) {
                    dVar.kS(com.baidu.adp.lib.g.b.g(str, 0));
                }
            }
        });
    }

    public void apF() {
        a(this.cZj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.cYN != null && v.t(this.cYN.thread_list) != 0 && v.t(this.mDataList) != 0) {
            String optString = ((JSONObject) customResponsedMessage.getData()).optString("tid");
            if (!StringUtils.isNull(optString)) {
                if (this.mListView != null && this.mListView.getAdapter() != null) {
                    View childAt = this.mListView.getChildAt(a(optString, this.mListView));
                    if (childAt != null) {
                        ay(childAt);
                    } else if (this.cYv != null) {
                        this.cYv.br(new ArrayList(this.mDataList));
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
                        if (cVar.Nj() != null && cVar.Nj().getTid() != null && cVar.Nj().getTid().equals(optString)) {
                            it.remove();
                            com.baidu.tieba.homepage.personalize.model.b.bw(this.mDataList);
                            break;
                        }
                    }
                }
                if (this.cYN != null && this.cYN.thread_list != null) {
                    long c = com.baidu.adp.lib.g.b.c(optString, 0L);
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < this.cYN.thread_list.size()) {
                            ThreadInfo threadInfo = this.cYN.thread_list.get(i2);
                            if (threadInfo == null || threadInfo.tid == null || threadInfo.tid.longValue() != c) {
                                i = i2 + 1;
                            } else {
                                this.cYN.thread_list.remove(i2);
                                aoX();
                                com.baidu.tieba.homepage.personalize.b.d.a(threadInfo.tid.longValue(), i2, this.cYN.thread_list, this.mDataList);
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
                if (cVar.Nj() != null && cVar.Nj().getTid().equals(str)) {
                    i = i2;
                }
            }
        }
        return (i + headerViewsCount) - firstVisiblePosition;
    }

    private void ay(final View view) {
        final int measuredHeight = view.getMeasuredHeight();
        Animation animation = new Animation() { // from class: com.baidu.tieba.homepage.personalize.e.16
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
        animation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.homepage.personalize.e.17
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation2) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation2) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation2) {
                view.setVisibility(8);
                if (e.this.cYv != null) {
                    e.this.cYv.br(new ArrayList(e.this.mDataList));
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
                    advertAppInfo = ((com.baidu.tieba.homepage.personalize.data.a) next).Ya();
                } else {
                    if (next instanceof af) {
                        af afVar = (af) next;
                        if (afVar.qb() instanceof AdvertAppInfo.ILegoAdvert) {
                            advertAppInfo = ((AdvertAppInfo.ILegoAdvert) afVar.qb()).getAdvertAppInfo();
                        }
                    }
                    advertAppInfo = advertAppInfo2;
                }
                if (advertAppInfo != null && str.equals(advertAppInfo.Ua)) {
                    it.remove();
                    advertAppInfo = null;
                }
                advertAppInfo2 = advertAppInfo;
            }
        }
    }
}
