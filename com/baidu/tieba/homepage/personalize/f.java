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
import com.baidu.adp.widget.ListView.i;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.ac;
import com.baidu.tbadk.core.data.be;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tbadk.util.h;
import com.baidu.tbadk.util.r;
import com.baidu.tbadk.util.u;
import com.baidu.tieba.ala.LiveRoomClosedQueryMessage;
import com.baidu.tieba.card.s;
import com.baidu.tieba.d;
import com.baidu.tieba.e.a;
import com.baidu.tieba.frs.au;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import com.baidu.tieba.homepage.personalize.a.k;
import com.baidu.tieba.play.m;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.squareup.wire.Wire;
import com.xiaomi.mipush.sdk.Constants;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
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
/* loaded from: classes2.dex */
public class f {
    private r bBb;
    private View.OnTouchListener bmR;
    private com.baidu.tieba.e.a dNs;
    private boolean dYu;
    private com.baidu.tieba.tbadkCore.data.e dwD;
    private m dyw;
    private ScrollFragmentTabHost ecL;
    private int ecO;
    private final k ecY;
    private int edB;
    private Runnable edJ;
    private final long edp;
    private final c edq;
    private DataRes.Builder eds;
    private au edw;
    private final com.baidu.tieba.homepage.personalize.model.a edx;
    private final BdTypeListView mListView;
    private final com.baidu.adp.base.e<?> mPageContext;
    private a edr = null;
    private final List<i> mDataList = new LinkedList();
    private int mPn = 1;
    private boolean mIsLoading = false;
    private boolean eag = false;
    private long edt = 0;
    private int edu = 1;
    private int edv = 0;
    private TextView aQI = null;
    private int dzL = 2000;
    private com.baidu.tbadk.k.f edy = null;
    private boolean dyo = false;
    private int dxP = 0;
    private int bXk = 0;
    private boolean mIsBackground = false;
    private boolean edz = true;
    private boolean edA = false;
    private boolean edC = false;
    private boolean edD = true;
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.f.12
        private int eal = -1;
        private int eam = 0;
        private boolean ean = false;

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (f.this.edy == null) {
                f.this.edy = new com.baidu.tbadk.k.f();
                f.this.edy.iq(1005);
                f.this.edy.pageType = 1;
            }
            if (f.this.bBb != null && !f.this.mIsBackground) {
                f.this.bBb.onScrollStateChanged(absListView, i);
            }
            f.this.edy.NH();
            if (i == 0) {
                s.ajC().df(true);
                if (this.ean) {
                    f.this.aBr();
                }
                this.ean = false;
                if (f.this.dyw != null && f.this.edz) {
                    f.this.dyw.a(f.this.dxP, f.this.bXk, f.this.dyo, 1);
                }
            } else if (i == 1 && f.this.edw != null) {
                f.this.edw.hideTip();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (this.eam > i) {
                this.ean = true;
            }
            if (f.this.bBb != null && !f.this.mIsBackground) {
                f.this.bBb.a(absListView, this.eam, i, i2, i3);
            }
            this.eam = i;
            int i4 = (i + i2) - 1;
            if (!this.ean && this.eal != i4) {
                this.eal = i4;
                f.this.oS(this.eal);
            }
            if (this.ean && this.eal != i) {
                this.eal = i;
                f.this.oS(this.eal);
            }
            f.this.edI = i;
            f.this.dxP = i;
            f.this.bXk = (i + i2) - 1;
        }
    };
    private View.OnTouchListener bBc = new View.OnTouchListener() { // from class: com.baidu.tieba.homepage.personalize.f.16
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (f.this.bmR != null) {
                f.this.bmR.onTouch(view, motionEvent);
            }
            if (f.this.dNs != null) {
                f.this.dNs.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private a.InterfaceC0109a ckE = new a.InterfaceC0109a() { // from class: com.baidu.tieba.homepage.personalize.f.17
        @Override // com.baidu.tieba.e.a.InterfaceC0109a
        public void aY(int i, int i2) {
            f.this.dyo = true;
        }

        @Override // com.baidu.tieba.e.a.InterfaceC0109a
        public void aZ(int i, int i2) {
            f.this.dyo = false;
        }

        @Override // com.baidu.tieba.e.a.InterfaceC0109a
        public void ba(int i, int i2) {
        }
    };
    private View.OnClickListener edE = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.f.18
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (f.this.edw != null) {
                f.this.edw.hideTip();
            }
            if (f.this.edu == 1 && f.this.mListView != null) {
                f.this.mListView.setSelection(0);
                f.this.mListView.startPullRefresh();
            }
        }
    };
    private final CustomMessageListener edF = new CustomMessageListener(CmdConfigCustom.CMD_RELOAD_HP_PERSONALIZED) { // from class: com.baidu.tieba.homepage.personalize.f.19
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (f.this.mListView != null) {
                f.this.dyw.aCw();
                f.this.edz = false;
                f.this.mListView.completePullRefreshPostDelayed(2000L);
                f.this.mListView.startPullRefresh();
            }
        }
    };
    private CustomMessageListener bbX = new CustomMessageListener(CmdConfigCustom.PB_ACTION_PRAISE) { // from class: com.baidu.tieba.homepage.personalize.f.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            be beVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof be) && f.this.eds != null && v.F(f.this.eds.thread_list) != 0 && (beVar = (be) customResponsedMessage.getData()) != null && beVar.yM() != null && beVar.getId() != null && v.F(f.this.eds.thread_list) != 0) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < f.this.eds.thread_list.size()) {
                        ThreadInfo threadInfo = f.this.eds.thread_list.get(i2);
                        if (threadInfo == null || threadInfo.id.longValue() != com.baidu.adp.lib.g.b.c(beVar.getId(), -1L)) {
                            i = i2 + 1;
                        } else {
                            ThreadInfo.Builder builder = new ThreadInfo.Builder(threadInfo);
                            Zan.Builder builder2 = new Zan.Builder(builder.zan);
                            builder2.num = Integer.valueOf((int) beVar.yM().getNum());
                            builder.zan = builder2.build(true);
                            f.this.eds.thread_list.set(i2, builder.build(true));
                            return;
                        }
                    } else {
                        return;
                    }
                }
            }
        }
    };
    private CustomMessageListener edG = new CustomMessageListener(CmdConfigCustom.CMD_LIVE_VIDEO_CLOSED_QUERY_RESPONSED) { // from class: com.baidu.tieba.homepage.personalize.f.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            be beVar;
            if (customResponsedMessage.getOrginalMessage() instanceof LiveRoomClosedQueryMessage) {
                List<Long> ids = ((LiveRoomClosedQueryMessage) customResponsedMessage.getOrginalMessage()).getIds();
                List<Object> originData = ((LiveRoomClosedQueryMessage) customResponsedMessage.getOrginalMessage()).getOriginData();
                if (!v.G(f.this.mDataList) && !v.G(ids) && !v.G(originData)) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= originData.size()) {
                            break;
                        }
                        if ((originData.get(i2) instanceof be) && (beVar = (be) originData.get(i2)) != null && beVar.zq() != null && ids.contains(Long.valueOf(beVar.zq().live_id))) {
                            f.this.mDataList.remove(beVar);
                        }
                        i = i2 + 1;
                    }
                    if (f.this.ecY != null) {
                        f.this.ecY.ao(new ArrayList(f.this.mDataList));
                    }
                }
            }
        }
    };
    private CustomMessageListener mAttentionListener = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.homepage.personalize.f.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int intValue;
            if ((customResponsedMessage instanceof UpdateAttentionMessage) && f.this.eds != null && !v.G(f.this.eds.thread_list)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid)) {
                    for (int i = 0; i < f.this.eds.thread_list.size(); i++) {
                        ThreadInfo threadInfo = f.this.eds.thread_list.get(i);
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
                            f.this.eds.thread_list.set(i, builder.build(true));
                            return;
                        }
                    }
                }
            }
        }
    };
    private String edH = "lastReadReadPositionKey";
    private int edI = 0;
    private e edK = new e() { // from class: com.baidu.tieba.homepage.personalize.f.7
        @Override // com.baidu.tieba.homepage.personalize.e
        public void oF(final int i) {
            if (f.this.edJ == null) {
                f.this.edJ = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.f.7.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (f.this.mListView.getHandler() != null) {
                            f.this.mListView.requestFocusFromTouch();
                            if (i <= f.this.mListView.getCount() - 1) {
                                f.this.mListView.setSelection(i);
                            }
                        }
                    }
                };
            }
            f.this.mListView.removeCallbacks(f.this.edJ);
            f.this.mListView.post(f.this.edJ);
        }
    };
    private CustomMessageListener dLx = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.homepage.personalize.f.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            f.this.d(customResponsedMessage);
        }
    };
    private CustomMessageListener dLy = new CustomMessageListener(CmdConfigCustom.CMD_THREAD_NOT_EXIST_WHEN_ENTER_PB) { // from class: com.baidu.tieba.homepage.personalize.f.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            f.this.d(customResponsedMessage);
        }
    };
    private CustomMessageListener dLz = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.homepage.personalize.f.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && f.this.eds != null && v.F(f.this.eds.thread_list) != 0) {
                String str = (String) customResponsedMessage.getData();
                f.this.e(str, f.this.mDataList);
                f.this.mi(str);
                if (f.this.ecY != null) {
                    f.this.ecY.ao(new ArrayList(f.this.mDataList));
                }
            }
        }
    };

    /* loaded from: classes2.dex */
    public interface a {
        void N(int i, int i2, int i3);

        void bO(int i, int i2);

        void onError(int i, String str);

        void onSuccess();
    }

    public void gy(boolean z) {
        this.edD = z;
        if (this.edw != null && !z) {
            this.edw.hideTip();
        }
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.ecL = scrollFragmentTabHost;
        if (this.ecL != null) {
            this.ecL.setOnTabSelectedListener(new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.personalize.f.1
                @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
                public void oQ(int i) {
                    if (f.this.ecL.oP(i) != 1 && f.this.edw != null) {
                        f.this.edw.hideTip();
                    }
                }
            });
        }
    }

    public void setTabInForeBackgroundState(boolean z) {
        this.mIsBackground = z;
    }

    public void fD(boolean z) {
        this.mIsBackground = z;
        if (this.dyw != null) {
            this.dyw.ii(!z);
            if (z) {
                this.dyw.aCw();
            } else if (this.edz) {
                this.dyw.c(this.dxP, this.bXk, this.dyo, true);
            }
        }
    }

    public f(com.baidu.adp.base.e<?> eVar, BdTypeListView bdTypeListView, k kVar) {
        this.mPageContext = eVar;
        this.mListView = bdTypeListView;
        this.mListView.setOnTouchListener(this.bBc);
        this.dNs = new com.baidu.tieba.e.a();
        this.dNs.a(this.ckE);
        this.ecY = kVar;
        this.edx = new com.baidu.tieba.homepage.personalize.model.a();
        this.edp = com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("recommend_frs_cache_time", 43200L) * 1000;
        bdTypeListView.setOnScrollListener(this.mOnScrollListener);
        this.edw = new au();
        aBs();
        this.dyw = new m(this.mPageContext, this.mListView);
        this.edq = new c(this.mDataList, this.ecY);
    }

    private boolean aBk() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean(aBm(), true);
    }

    private void aBl() {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean(aBm(), false);
    }

    private String aBm() {
        return "key_rec_pfirst_load_" + TbadkCoreApplication.getCurrentAccount() + "_" + TbConfig.getVersion();
    }

    public void setHeaderViewHeight(int i) {
        this.ecO = i;
    }

    public void setRecommendFrsNavigationAnimDispatcher(com.baidu.tbadk.util.s sVar) {
        if (sVar != null) {
            this.bBb = sVar.OQ();
            this.bmR = sVar.OR();
        }
    }

    public void showFloatingView() {
        if (this.bBb != null) {
            this.bBb.cD(true);
        }
    }

    public void update() {
        if (com.baidu.tieba.homepage.framework.a.aAS().oE(1) == -1) {
            com.baidu.tieba.homepage.framework.a.aAS().h(System.currentTimeMillis(), 1);
        }
        this.mPn = 1;
        this.edC = true;
        if (this.mDataList.size() == 0 && !this.eag && !aBk()) {
            aAM();
        } else {
            aAK();
        }
    }

    public void bP(int i, int i2) {
        be beVar;
        if (!v.G(this.mDataList) && this.mDataList.size() > i) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            while (i < this.mDataList.size() && i <= i2) {
                if (this.mDataList.get(i).getType().getId() == be.aNg.getId() && (beVar = (be) this.mDataList.get(i)) != null && beVar.zq() != null) {
                    arrayList.add(Long.valueOf(beVar.zq().live_id));
                    arrayList2.add(beVar);
                }
                i++;
            }
            if (!v.G(arrayList)) {
                MessageManager.getInstance().sendMessage(new LiveRoomClosedQueryMessage(arrayList, arrayList2));
            }
        }
    }

    public void aBn() {
        if (this.dyw != null && !this.mIsBackground && this.edz) {
            this.dyw.c(this.dxP, this.bXk, this.dyo, true);
        }
        if (this.edA) {
            if (this.dYu) {
                if (gz(false)) {
                    bQ(3, this.edv);
                } else if (this.edB > 0) {
                    bQ(2, this.edv);
                }
            } else if (!this.dYu && this.edv == 0) {
                bQ(2, 0);
            }
            com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("recommend_frs_refresh_time", System.currentTimeMillis());
            this.edA = false;
            this.dYu = false;
            this.edB = 0;
            if (this.edC) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
            }
            this.edC = false;
        }
    }

    public void Wh() {
        if (!DY() && this.edr != null) {
            aBp();
            this.mPn++;
            setIsLoading(true);
            this.edr.N(this.mPn, (this.eds == null || this.eds.thread_list == null) ? 0 : this.eds.thread_list.size(), 0);
        }
    }

    public void a(boolean z, boolean z2, DataRes dataRes, int i, String str) {
        setIsLoading(false);
        this.mListView.completePullRefreshPostDelayed(2000L);
        if (z) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("recommend_frs_guide_time", System.currentTimeMillis());
        }
        int size = (this.eds == null || this.eds.thread_list == null) ? 0 : this.eds.thread_list.size();
        if (i != 0 || dataRes == null || !a(true, z, z2, dataRes)) {
            this.edA = false;
            if (this.mDataList.size() > 0) {
                if (this.edr != null) {
                    this.edr.onError(1, str);
                    return;
                }
                return;
            } else if (this.edr != null) {
                this.edr.onError(2, str);
                return;
            } else {
                return;
            }
        }
        aBl();
        if (this.edr != null) {
            this.edr.onSuccess();
        }
        this.edA = true;
        this.dYu = z;
        this.edB = size;
        aAN();
    }

    public void gt(boolean z) {
        if (z) {
            this.ecY.notifyDataSetChanged();
        }
        if (!aBo()) {
            aBr();
        }
    }

    public void onDestroy() {
        if (this.dyw != null) {
            this.dyw.destroy();
        }
        if (this.edy != null) {
            this.edy.onDestroy();
        }
        if (this.edw != null) {
            this.edw.onDestroy();
        }
        if (this.edq != null) {
            this.edq.onDestroy();
        }
        if (this.mListView != null) {
            this.mListView.removeCallbacks(this.edJ);
        }
    }

    public void onPause() {
        oT(this.edI);
        oR(CmdConfigCustom.CMD_VIEW_PAGER_END_AUTO_SCROLL);
    }

    public void onResume() {
        oR(CmdConfigCustom.CMD_VIEW_PAGER_START_AUTO_SCROLL);
    }

    private void oR(final int i) {
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(i);
        final BdUniqueId uniqueId = this.mPageContext.getUniqueId();
        customResponsedMessage.setOrginalMessage(new CustomMessage<Object>(i, uniqueId) { // from class: com.baidu.tieba.homepage.personalize.PersonalizedUpdateController$7
        });
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
    }

    public boolean aBo() {
        if (gz(false)) {
            if (this.mListView != null) {
                this.mListView.setSelection(0);
                this.mListView.startPullRefresh();
            }
            return true;
        }
        return false;
    }

    private void aAK() {
        if (this.edr != null) {
            this.edr.bO((this.eds == null || this.eds.thread_list == null || aBq()) ? 0 : this.eds.thread_list.size(), 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(DataRes dataRes) {
        this.eag = true;
        if (dataRes != null) {
            if (a(false, true, true, dataRes) && !aBq()) {
                if (this.edr != null) {
                    this.edr.onSuccess();
                }
                aBr();
                return;
            }
            aAK();
            return;
        }
        aAK();
    }

    private void bR(List<i> list) {
        if (!v.G(list)) {
            for (i iVar : list) {
                if (iVar instanceof com.baidu.tieba.card.data.d) {
                    com.baidu.tieba.card.data.d dVar = (com.baidu.tieba.card.data.d) iVar;
                    if (dVar.ajQ() != null) {
                        dVar.ajQ().advertAppContext = new com.baidu.tbadk.core.data.b();
                        dVar.ajQ().advertAppContext.aIO = "NEWINDEX";
                        dVar.ajQ().advertAppContext.pn = 1;
                        dVar.ajQ().advertAppContext.extensionInfo = dVar.ajQ().extensionInfo;
                        dVar.ajQ().advertAppContext.aIT = false;
                    }
                }
            }
        }
    }

    private boolean a(boolean z, boolean z2, boolean z3, DataRes dataRes) {
        List<i> list;
        boolean z4;
        if (dataRes == null) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        this.edt = dataRes.sug_seconds.intValue() * 1000;
        if (z2 && aBq()) {
            this.eds = null;
        }
        int size = z2 ? 0 : this.mDataList.size();
        DataRes.Builder builder = new DataRes.Builder(dataRes);
        this.mDataList.clear();
        com.baidu.tieba.homepage.personalize.model.c a2 = this.edx.a(z, this.eds, builder, z2 ? 0 : 1);
        if (a2 == null) {
            list = null;
        } else {
            List<i> list2 = a2.bLw;
            this.edv = a2.eeL;
            list = list2;
        }
        if (list != null) {
            this.mDataList.addAll(list);
            bR(list);
            a(z2 ? 0 : 1, list, size);
            if (this.edC) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
            }
        }
        if (this.eds == null) {
            this.eds = builder;
            this.edq.bP(this.eds.thread_list);
        }
        if (this.mDataList.size() == 0) {
            z4 = false;
        } else {
            LinkedList linkedList = new LinkedList(this.mDataList);
            this.ecY.setFromCDN(dataRes.is_new_url.intValue() == 1);
            this.ecY.ao(linkedList);
            z4 = true;
            if (this.dyw != null && this.edz) {
                this.dyw.c(this.dxP, this.bXk, this.dyo, true);
            }
        }
        com.baidu.tieba.homepage.framework.a.aAS().f(System.currentTimeMillis() - currentTimeMillis, 1);
        long oE = com.baidu.tieba.homepage.framework.a.aAS().oE(1);
        if (oE > 0) {
            com.baidu.tieba.homepage.framework.a.aAS().g(System.currentTimeMillis() - oE, 1);
            com.baidu.tieba.homepage.framework.a.aAS().h(0L, 1);
        }
        if (dataRes != null && dataRes.anti != null && dataRes.anti.block_pop_info != null) {
            com.baidu.tieba.p.a.d(dataRes.anti.block_pop_info);
            return z4;
        }
        return z4;
    }

    private void aBp() {
        if (v.F(this.mDataList) >= this.edx.aBA() - 40) {
            com.baidu.tieba.homepage.personalize.model.c a2 = this.edx.a(true, this.eds, (DataRes.Builder) null, 1);
            List<i> list = a2 != null ? a2.bLw : null;
            if (list != null) {
                this.mDataList.clear();
                this.mDataList.addAll(list);
                this.ecY.ao(new LinkedList(this.mDataList));
            }
        }
    }

    private void aAM() {
        com.baidu.tbadk.util.v.a(new u<DataRes>() { // from class: com.baidu.tieba.homepage.personalize.f.20
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.u
            /* renamed from: aBv */
            public DataRes doInBackground() {
                l<byte[]> L = com.baidu.tbadk.core.c.a.AE().L("tb.rec_frs_update", TbadkCoreApplication.getCurrentAccount());
                if (L == null) {
                    return null;
                }
                byte[] bArr = L.get("0");
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
        }, new h<DataRes>() { // from class: com.baidu.tieba.homepage.personalize.f.21
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.h
            /* renamed from: b */
            public void onReturnDataInUI(DataRes dataRes) {
                f.this.a(dataRes);
            }
        });
    }

    private void aAN() {
        if (this.eds != null) {
            DataRes.Builder builder = new DataRes.Builder(this.eds.build(true));
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
                        int h = com.baidu.adp.lib.g.b.h(next.pos_name, -1);
                        if (h < 0) {
                            it.remove();
                        } else if (h < i + i2 + 1) {
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
    public void mi(String str) {
        if (!TextUtils.isEmpty(str) && this.eds != null && this.eds.banner_list != null && this.eds.banner_list.app != null && this.eds.banner_list.app.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (App app : this.eds.banner_list.app) {
                if (app != null && str.equals(app.id)) {
                    arrayList.add(app);
                }
            }
            BannerList.Builder builder = new BannerList.Builder(this.eds.banner_list);
            if (builder.app != null) {
                builder.app.removeAll(arrayList);
            }
            this.eds.banner_list = builder.build(false);
            DataRes.Builder builder2 = new DataRes.Builder(this.eds.build(true));
            builder2.banner_list = builder.build(true);
            a(builder2);
        }
    }

    private void a(final DataRes.Builder builder) {
        com.baidu.tbadk.util.v.a(new u<Object>() { // from class: com.baidu.tieba.homepage.personalize.f.2
            @Override // com.baidu.tbadk.util.u
            public Object doInBackground() {
                DataRes.Builder builder2 = new DataRes.Builder(builder.build(true));
                f.this.edq.bQ(builder2.thread_list);
                try {
                    com.baidu.tbadk.core.c.a.AE().L("tb.rec_frs_update", TbadkCoreApplication.getCurrentAccount()).e("0", builder2.build(true).toByteArray());
                    return null;
                } catch (Exception e) {
                    BdLog.e(e);
                    return null;
                }
            }
        }, null);
    }

    private boolean aBq() {
        return gz(true);
    }

    private boolean gz(boolean z) {
        long j = com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("recommend_frs_refresh_time", 0L);
        return j == 0 ? z : Math.abs(System.currentTimeMillis() - j) > this.edp;
    }

    public void a(a aVar) {
        this.edr = aVar;
    }

    private boolean DY() {
        return this.mIsLoading;
    }

    private void setIsLoading(boolean z) {
        this.mIsLoading = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBr() {
        long j = com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("recommend_frs_guide_time", 0L);
        if (this.edt != 0) {
            if (j == 0 || Math.abs(System.currentTimeMillis() - j) > this.edt) {
                bQ(1, 0);
            }
        }
    }

    public void aBi() {
        boolean z = true;
        com.baidu.tbadk.coreExtra.data.a activityPrizeData = TbadkCoreApplication.getInst().getActivityPrizeData();
        if (activityPrizeData.EU() && !StringUtils.isNull(activityPrizeData.Fc())) {
            String currentDay = UtilHelper.getCurrentDay();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            String str = "";
            if (!StringUtils.isNull(currentAccount)) {
                String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("activity_prize_feed_text_time", "");
                if (!StringUtils.isNull(string)) {
                    String[] split = string.split("@");
                    if (split != null && split.length == 2) {
                        String str2 = split[0];
                        String[] split2 = split[1].split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                        if (!StringUtils.isNull(str2) && split2.length != 0) {
                            if (str2.equals(currentDay)) {
                                List<String> asList = Arrays.asList(split2);
                                if (asList.contains(currentAccount)) {
                                    z = false;
                                } else {
                                    StringBuilder sb = new StringBuilder();
                                    sb.append(currentDay).append("@");
                                    for (String str3 : asList) {
                                        sb.append(str3).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                                    }
                                    str = sb.append(currentAccount).toString();
                                }
                            } else {
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append(currentDay).append("@");
                                sb2.append(currentAccount);
                                str = sb2.toString();
                            }
                        } else {
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append(currentDay).append("@");
                            sb3.append(currentAccount);
                            str = sb3.toString();
                        }
                    } else {
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append(currentDay).append("@");
                        sb4.append(currentAccount);
                        str = sb4.toString();
                    }
                } else {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(currentDay).append("@");
                    sb5.append(currentAccount);
                    str = sb5.toString();
                }
                if (z) {
                    bQ(4, 0);
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putString("activity_prize_feed_text_time", str);
                }
            }
        }
    }

    private void bQ(int i, int i2) {
        FrameLayout.LayoutParams layoutParams;
        if (this.ecL != null) {
            this.edw.auq();
        }
        if (this.ecL != null && this.ecL.getCurrentTabType() != 1) {
            this.edw.hideTip();
        } else if (!this.edD) {
            this.edw.hideTip();
        } else {
            this.edu = i;
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
            } else if (i == 4) {
                str = TbadkCoreApplication.getInst().getActivityPrizeData().Fc();
            }
            if (!TextUtils.isEmpty(str)) {
                if (this.aQI == null) {
                    this.aQI = new TextView(this.mPageContext.getPageActivity());
                    this.aQI.setGravity(17);
                    this.aQI.setOnClickListener(this.edE);
                }
                this.edw.auq();
                FrameLayout frameLayout = this.ecL.getFrameLayout();
                if (frameLayout != null && this.aQI.getParent() == null) {
                    if (i == 1) {
                        if (j.oI()) {
                            int dimensionPixelSize = this.mPageContext.getResources().getDimensionPixelSize(d.e.ds20);
                            int dimensionPixelSize2 = this.mPageContext.getResources().getDimensionPixelSize(d.e.ds40);
                            this.aQI.setPadding(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
                            this.aQI.setTextSize(0, this.mPageContext.getResources().getDimensionPixelSize(d.e.fontsize28));
                            com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("recommend_frs_guide_time", System.currentTimeMillis());
                            aj.s(this.aQI, d.f.bg_home_float);
                            aj.r(this.aQI, d.C0108d.cp_link_tip_a);
                            layoutParams = new FrameLayout.LayoutParams(-2, -2);
                            layoutParams.gravity = 49;
                            layoutParams.topMargin = this.ecO;
                        } else {
                            return;
                        }
                    } else {
                        this.aQI.setPadding(0, 0, 0, 0);
                        this.aQI.setTextSize(0, this.mPageContext.getResources().getDimensionPixelSize(d.e.fontsize24));
                        aj.s(this.aQI, d.C0108d.common_color_10260);
                        aj.r(this.aQI, d.C0108d.cp_cont_g);
                        layoutParams = new FrameLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.s(TbadkCoreApplication.getInst(), d.e.ds56));
                        layoutParams.gravity = 49;
                        layoutParams.topMargin = this.ecO;
                    }
                    this.aQI.setText(str);
                    if (i == 1) {
                        this.dzL = 4000;
                    } else if (i == 4) {
                        this.dzL = PushConstants.WORK_RECEIVER_EVENTCORE_ERROR;
                    } else {
                        this.dzL = 2000;
                    }
                    this.edw.a(this.aQI, frameLayout, layoutParams, this.dzL);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(Long l) {
        if (this.eds != null && this.eds.thread_list != null) {
            List<ThreadInfo> list = this.eds.thread_list;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                ThreadInfo threadInfo = list.get(i);
                if (threadInfo.tid.equals(l) && threadInfo.top_agree_post != null) {
                    ThreadInfo.Builder builder = new ThreadInfo.Builder(threadInfo);
                    builder.top_agree_post = null;
                    list.set(i, builder.build(true));
                    aAN();
                    a(false, true, false, this.eds.build(true));
                    return;
                }
            }
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            if (this.bbX != null) {
                this.bbX.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.bbX);
            }
            if (this.edF != null) {
                this.edF.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.edF);
            }
            this.mAttentionListener.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.mAttentionListener);
            this.edG.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.edG);
            this.dLx.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.dLx);
            this.dLy.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.dLy);
            this.dLz.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.dLz);
            if (this.dyw != null) {
                this.dyw.setUniqueId(bdUniqueId);
            }
            this.edq.h(bdUniqueId);
        }
    }

    public void aBs() {
        this.dwD = new com.baidu.tieba.tbadkCore.data.e("new_index", null);
        this.dwD.bBM();
    }

    public void a(int i, List<i> list, int i2) {
        int i3;
        int i4;
        if (this.dwD != null) {
            if (i == 0) {
                this.dwD.bBM();
            }
            if (list != null && !list.isEmpty()) {
                int[] iArr = com.baidu.tieba.tbadkCore.data.e.hih;
                int i5 = 0;
                int i6 = 0;
                int i7 = 0;
                while (i7 < list.size() && i6 < iArr.length && (i3 = iArr[i6]) >= 0) {
                    if (list.get(i7) instanceof com.baidu.tieba.card.data.c) {
                        i4 = i5 + 1;
                        if (i4 == i3 - 1) {
                            if (i2 < i7 + 1) {
                                this.dwD.cS(i3, i7 + 1);
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

    public void oS(int i) {
        if ((this.dwD != null ? this.dwD.xg(i) : -1) >= 0 && this.mListView != null && this.mListView.getData() != null && this.mListView.getData().size() > i) {
            this.dwD.xh(i);
        }
    }

    public m atw() {
        return this.dyw;
    }

    public void gA(boolean z) {
        this.edz = z;
    }

    public void oT(final int i) {
        com.baidu.tbadk.util.v.a(new u<Object>() { // from class: com.baidu.tieba.homepage.personalize.f.6
            @Override // com.baidu.tbadk.util.u
            public Object doInBackground() {
                l<String> M = com.baidu.tbadk.core.c.a.AE().M(f.this.edH, TbadkCoreApplication.getCurrentAccount());
                if (M != null) {
                    M.a(f.this.edH, Integer.toString(i), 43200000L);
                    return null;
                }
                return null;
            }
        }, null);
    }

    public void a(final e eVar) {
        com.baidu.tbadk.util.v.a(new u<String>() { // from class: com.baidu.tieba.homepage.personalize.f.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.u
            /* renamed from: aBu */
            public String doInBackground() {
                l<String> M = com.baidu.tbadk.core.c.a.AE().M(f.this.edH, TbadkCoreApplication.getCurrentAccount());
                if (M != null) {
                    return M.get(f.this.edH);
                }
                return null;
            }
        }, new h<String>() { // from class: com.baidu.tieba.homepage.personalize.f.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.h
            /* renamed from: mj */
            public void onReturnDataInUI(String str) {
                if (eVar != null) {
                    eVar.oF(com.baidu.adp.lib.g.b.h(str, 0));
                }
            }
        });
    }

    public void aBt() {
        a(this.edK);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(CustomResponsedMessage<?> customResponsedMessage) {
        String str;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.eds != null && v.F(this.eds.thread_list) != 0 && v.F(this.mDataList) != 0) {
            JSONObject jSONObject = (JSONObject) customResponsedMessage.getData();
            String optString = jSONObject.optString("tid");
            if (StringUtils.isNull(optString)) {
                String optString2 = jSONObject.optString("liveid");
                if (this.mListView != null && this.mListView.getAdapter() != null && !TextUtils.isEmpty(optString2)) {
                    int i = 0;
                    while (true) {
                        if (i >= this.mListView.getAdapter().getCount()) {
                            str = optString;
                            break;
                        }
                        i item = this.mListView.getItem(i);
                        if (item instanceof com.baidu.tieba.card.data.k) {
                            com.baidu.tieba.card.data.k kVar = (com.baidu.tieba.card.data.k) item;
                            if (kVar.VW() != null && kVar.VW().zq() != null && optString2.equals(String.valueOf(kVar.VW().zq().live_id))) {
                                str = kVar.VW().getTid();
                                break;
                            }
                        }
                        i++;
                    }
                    if (StringUtils.isNull(str)) {
                        return;
                    }
                    optString = str;
                } else {
                    return;
                }
            }
            if (this.mListView != null && this.mListView.getAdapter() != null) {
                int a2 = a(optString, this.mListView);
                if (a2 != -1) {
                    View childAt = this.mListView.getChildAt(a(a2, this.mListView));
                    if (childAt != null) {
                        bT(childAt);
                    } else if (this.ecY != null) {
                        this.ecY.ao(new ArrayList(this.mDataList));
                    }
                } else {
                    return;
                }
            }
            Iterator<i> it = this.mDataList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                i next = it.next();
                if (next instanceof com.baidu.tieba.card.data.c) {
                    com.baidu.tieba.card.data.c cVar = (com.baidu.tieba.card.data.c) next;
                    if (cVar.VW() != null && cVar.VW().getTid() != null && cVar.VW().getTid().equals(optString)) {
                        it.remove();
                        com.baidu.tieba.homepage.personalize.model.b.bT(this.mDataList);
                        break;
                    }
                }
            }
            if (this.eds != null && this.eds.thread_list != null) {
                long c = com.baidu.adp.lib.g.b.c(optString, 0L);
                for (int i2 = 0; i2 < this.eds.thread_list.size(); i2++) {
                    ThreadInfo threadInfo = this.eds.thread_list.get(i2);
                    if (threadInfo != null && threadInfo.tid != null && threadInfo.tid.longValue() == c) {
                        this.eds.thread_list.remove(i2);
                        aAN();
                        com.baidu.tieba.homepage.personalize.b.d.a(threadInfo.tid.longValue(), i2, this.eds.thread_list, this.mDataList);
                        return;
                    }
                }
            }
        }
    }

    private int a(String str, BdTypeListView bdTypeListView) {
        int i = 0;
        int i2 = -1;
        while (true) {
            int i3 = i;
            if (i3 < bdTypeListView.getAdapter().getCount()) {
                i item = bdTypeListView.getItem(i3);
                if (item instanceof com.baidu.tieba.card.data.c) {
                    com.baidu.tieba.card.data.c cVar = (com.baidu.tieba.card.data.c) item;
                    if (cVar.VW() != null && cVar.VW().getTid().equals(str)) {
                        i2 = i3;
                    }
                }
                i = i3 + 1;
            } else {
                return i2;
            }
        }
    }

    private int a(int i, BdTypeListView bdTypeListView) {
        return (bdTypeListView.getHeaderViewsCount() + i) - bdTypeListView.getFirstVisiblePosition();
    }

    private void bT(final View view) {
        final int measuredHeight = view.getMeasuredHeight();
        Animation animation = new Animation() { // from class: com.baidu.tieba.homepage.personalize.f.13
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
        animation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.homepage.personalize.f.14
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation2) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation2) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation2) {
                view.setVisibility(8);
                if (f.this.ecY != null) {
                    f.this.ecY.ao(new ArrayList(f.this.mDataList));
                }
            }
        });
        animation.setDuration(300L);
        view.startAnimation(animation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(String str, List<i> list) {
        AdvertAppInfo advertAppInfo;
        if (list != null && list.size() > 0 && !TextUtils.isEmpty(str)) {
            Iterator<i> it = list.iterator();
            AdvertAppInfo advertAppInfo2 = null;
            while (it.hasNext()) {
                i next = it.next();
                if (next instanceof com.baidu.tieba.homepage.personalize.data.a) {
                    advertAppInfo = ((com.baidu.tieba.homepage.personalize.data.a) next).ajQ();
                } else {
                    if (next instanceof ac) {
                        ac acVar = (ac) next;
                        if (acVar.xD() instanceof AdvertAppInfo.ILegoAdvert) {
                            advertAppInfo = ((AdvertAppInfo.ILegoAdvert) acVar.xD()).getAdvertAppInfo();
                        }
                    }
                    advertAppInfo = advertAppInfo2;
                }
                if (advertAppInfo != null && str.equals(advertAppInfo.aJl)) {
                    it.remove();
                    advertAppInfo = null;
                }
                advertAppInfo2 = advertAppInfo;
            }
        }
    }
}
