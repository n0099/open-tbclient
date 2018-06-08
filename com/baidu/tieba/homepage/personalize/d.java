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
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.ac;
import com.baidu.tbadk.core.data.at;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tbadk.util.s;
import com.baidu.tbadk.util.t;
import com.baidu.tieba.ala.LiveRoomClosedQueryMessage;
import com.baidu.tieba.card.v;
import com.baidu.tieba.d;
import com.baidu.tieba.f.a;
import com.baidu.tieba.frs.aq;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import com.baidu.tieba.homepage.personalize.a.l;
import com.baidu.tieba.homepage.personalize.data.g;
import com.baidu.tieba.play.m;
import com.squareup.wire.Wire;
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
import tbclient.Personalized.FloatInfo;
import tbclient.ThreadInfo;
import tbclient.User;
import tbclient.Zan;
/* loaded from: classes2.dex */
public class d {
    private View.OnTouchListener aIi;
    private s aVH;
    private com.baidu.tieba.f.a dAM;
    private boolean dLk;
    private ScrollFragmentTabHost dPB;
    private int dPE;
    private final l dPO;
    private Runnable dQC;
    private final long dQg;
    private final b dQh;
    private DataRes.Builder dQj;
    private aq dQn;
    private final com.baidu.tieba.homepage.personalize.model.a dQo;
    private int dQs;
    private g dQu;
    private com.baidu.tieba.tbadkCore.data.e dhy;
    private m djB;
    private final BdTypeListView mListView;
    private final TbPageContext<?> mPageContext;
    private a dQi = null;
    private final List<h> mDataList = new LinkedList();
    private int mPn = 1;
    private boolean mIsLoading = false;
    private boolean dMV = false;
    private long dQk = 0;
    private int dQl = 1;
    private int dQm = 0;
    private TextView alu = null;
    private int dkT = 2000;
    private com.baidu.tbadk.k.c dQp = null;
    private boolean djt = false;
    private int diQ = 0;
    private int brT = 0;
    private boolean mIsBackground = false;
    private boolean dQq = true;
    private boolean dQr = false;
    private boolean dQt = false;
    private boolean dQv = true;
    private FloatInfo dQw = null;
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.d.12
        private int dQI = -1;
        private int dNa = 0;
        private boolean dQJ = false;

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (d.this.dQp == null) {
                d.this.dQp = new com.baidu.tbadk.k.c();
                d.this.dQp.fk(1005);
                d.this.dQp.pageType = 1;
            }
            if (d.this.aVH != null && !d.this.mIsBackground) {
                d.this.aVH.onScrollStateChanged(absListView, i);
            }
            if (i == 0) {
                d.this.dQp.Kj();
                v.ajh().cG(true);
                if (this.dQJ) {
                    d.this.aCL();
                }
                this.dQJ = false;
                if (d.this.djB != null && d.this.dQq) {
                    d.this.djB.a(d.this.diQ, d.this.brT, d.this.djt, 1);
                    return;
                }
                return;
            }
            d.this.dQp.Ki();
            if (i == 1 && d.this.dQn != null) {
                d.this.dQn.hideTip();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (this.dNa > i) {
                this.dQJ = true;
            }
            if (d.this.aVH != null && !d.this.mIsBackground) {
                d.this.aVH.a(absListView, this.dNa, i, i2, i3);
            }
            this.dNa = i;
            int i4 = (i + i2) - 1;
            if (!this.dQJ && this.dQI != i4) {
                this.dQI = i4;
                d.this.mw(this.dQI);
            }
            if (this.dQJ && this.dQI != i) {
                this.dQI = i;
                d.this.mw(this.dQI);
            }
            d.this.dQB = i;
            d.this.diQ = i;
            d.this.brT = (i + i2) - 1;
        }
    };
    private View.OnTouchListener aVI = new View.OnTouchListener() { // from class: com.baidu.tieba.homepage.personalize.d.16
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (d.this.aIi != null) {
                d.this.aIi.onTouch(view, motionEvent);
            }
            if (d.this.dAM != null) {
                d.this.dAM.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private a.InterfaceC0146a bHv = new a.InterfaceC0146a() { // from class: com.baidu.tieba.homepage.personalize.d.17
        @Override // com.baidu.tieba.f.a.InterfaceC0146a
        public void X(int i, int i2) {
            d.this.djt = true;
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0146a
        public void Y(int i, int i2) {
            d.this.djt = false;
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0146a
        public void Z(int i, int i2) {
        }
    };
    private View.OnClickListener dQx = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.d.18
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (d.this.dQn != null) {
                d.this.dQn.hideTip();
            }
            if (d.this.dQl == 1 && d.this.mListView != null) {
                d.this.mListView.setSelection(0);
                d.this.mListView.startPullRefresh();
            }
        }
    };
    private final CustomMessageListener dQy = new CustomMessageListener(2001399) { // from class: com.baidu.tieba.homepage.personalize.d.19
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (d.this.mListView != null) {
                d.this.djB.aDT();
                d.this.dQq = false;
                d.this.mListView.completePullRefreshPostDelayed(2000L);
                d.this.mListView.startPullRefresh();
            }
        }
    };
    private CustomMessageListener axl = new CustomMessageListener(2004004) { // from class: com.baidu.tieba.homepage.personalize.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            bd bdVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bd) && d.this.dQj != null && w.y(d.this.dQj.thread_list) != 0 && (bdVar = (bd) customResponsedMessage.getData()) != null && bdVar.va() != null && bdVar.getId() != null && w.y(d.this.dQj.thread_list) != 0) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < d.this.dQj.thread_list.size()) {
                        ThreadInfo threadInfo = d.this.dQj.thread_list.get(i2);
                        if (threadInfo == null || threadInfo.id.longValue() != com.baidu.adp.lib.g.b.c(bdVar.getId(), -1L)) {
                            i = i2 + 1;
                        } else {
                            ThreadInfo.Builder builder = new ThreadInfo.Builder(threadInfo);
                            Zan.Builder builder2 = new Zan.Builder(builder.zan);
                            builder2.num = Integer.valueOf((int) bdVar.va().getNum());
                            builder.zan = builder2.build(true);
                            d.this.dQj.thread_list.set(i2, builder.build(true));
                            return;
                        }
                    } else {
                        return;
                    }
                }
            }
        }
    };
    private CustomMessageListener dQz = new CustomMessageListener(2921026) { // from class: com.baidu.tieba.homepage.personalize.d.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            bd bdVar;
            if (customResponsedMessage.getOrginalMessage() instanceof LiveRoomClosedQueryMessage) {
                List<Long> ids = ((LiveRoomClosedQueryMessage) customResponsedMessage.getOrginalMessage()).getIds();
                List<Object> originData = ((LiveRoomClosedQueryMessage) customResponsedMessage.getOrginalMessage()).getOriginData();
                if (!w.z(d.this.mDataList) && !w.z(ids) && !w.z(originData)) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= originData.size()) {
                            break;
                        }
                        if ((originData.get(i2) instanceof bd) && (bdVar = (bd) originData.get(i2)) != null && bdVar.vE() != null && ids.contains(Long.valueOf(bdVar.vE().live_id))) {
                            d.this.mDataList.remove(bdVar);
                        }
                        i = i2 + 1;
                    }
                    if (d.this.dPO != null) {
                        d.this.dPO.ai(new ArrayList(d.this.mDataList));
                    }
                }
            }
        }
    };
    private CustomMessageListener mAttentionListener = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.homepage.personalize.d.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int intValue;
            if ((customResponsedMessage instanceof UpdateAttentionMessage) && d.this.dQj != null && !w.z(d.this.dQj.thread_list)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid)) {
                    for (int i = 0; i < d.this.dQj.thread_list.size(); i++) {
                        ThreadInfo threadInfo = d.this.dQj.thread_list.get(i);
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
                            d.this.dQj.thread_list.set(i, builder.build(true));
                            return;
                        }
                    }
                }
            }
        }
    };
    private String dQA = "lastReadReadPositionKey";
    private int dQB = 0;
    private c dQD = new c() { // from class: com.baidu.tieba.homepage.personalize.d.6
        @Override // com.baidu.tieba.homepage.personalize.c
        public void mk(final int i) {
            if (d.this.dQC == null) {
                d.this.dQC = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.d.6.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (d.this.mListView.getHandler() != null) {
                            d.this.mListView.requestFocusFromTouch();
                            if (i <= d.this.mListView.getCount() - 1) {
                                d.this.mListView.setSelection(i);
                            }
                        }
                    }
                };
            }
            d.this.mListView.removeCallbacks(d.this.dQC);
            d.this.mListView.post(d.this.dQC);
        }
    };
    private CustomMessageListener dQE = new CustomMessageListener(2016569) { // from class: com.baidu.tieba.homepage.personalize.d.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && d.this.dQu != null) {
                d.this.mDataList.remove(d.this.dQu);
                d.this.dPO.ai(new ArrayList(d.this.mDataList));
                com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("key_maintab_banner_close_time", System.currentTimeMillis());
            }
        }
    };
    private CustomMessageListener dyi = new CustomMessageListener(2016488) { // from class: com.baidu.tieba.homepage.personalize.d.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.this.h(customResponsedMessage);
        }
    };
    private CustomMessageListener dyj = new CustomMessageListener(2016553) { // from class: com.baidu.tieba.homepage.personalize.d.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.this.h(customResponsedMessage);
        }
    };
    private CustomMessageListener dyk = new CustomMessageListener(2016331) { // from class: com.baidu.tieba.homepage.personalize.d.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && d.this.dQj != null && w.y(d.this.dQj.thread_list) != 0) {
                String str = (String) customResponsedMessage.getData();
                d.this.f(str, d.this.mDataList);
                d.this.nv(str);
                if (d.this.dPO != null) {
                    d.this.dPO.ai(new ArrayList(d.this.mDataList));
                }
            }
        }
    };

    /* loaded from: classes2.dex */
    public interface a {
        void C(int i, int i2, int i3);

        void aP(int i, int i2);

        void onError(int i, String str);

        void onSuccess();
    }

    public void gA(boolean z) {
        this.dQv = z;
        if (this.dQn != null && !z) {
            this.dQn.hideTip();
        }
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.dPB = scrollFragmentTabHost;
        if (this.dPB != null) {
            this.dPB.setOnTabSelectedListener(new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.personalize.d.1
                @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
                public void mv(int i) {
                    if (d.this.dPB.mu(i) != 1 && d.this.dQn != null) {
                        d.this.dQn.hideTip();
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
        if (this.djB != null) {
            this.djB.ij(!z);
            if (z) {
                this.djB.aDT();
            } else if (this.dQq) {
                this.djB.b(this.diQ, this.brT, this.djt, true);
            }
        }
    }

    public d(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView, l lVar) {
        this.mPageContext = tbPageContext;
        this.mListView = bdTypeListView;
        this.mListView.setOnTouchListener(this.aVI);
        this.dAM = new com.baidu.tieba.f.a();
        this.dAM.a(this.bHv);
        this.dPO = lVar;
        this.dQo = new com.baidu.tieba.homepage.personalize.model.a();
        this.dQg = com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("recommend_frs_cache_time", 43200L) * 1000;
        bdTypeListView.setOnScrollListener(this.mOnScrollListener);
        this.dQn = new aq();
        aCM();
        this.djB = new m(this.mPageContext, this.mListView);
        this.dQh = new b(this.mDataList, this.dPO);
    }

    private boolean aCE() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean(aCG(), true);
    }

    private void aCF() {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean(aCG(), false);
    }

    private String aCG() {
        return "key_rec_pfirst_load_" + TbadkCoreApplication.getCurrentAccount() + "_" + TbConfig.getVersion();
    }

    public void setHeaderViewHeight(int i) {
        this.dPE = i;
    }

    public void setRecommendFrsNavigationAnimDispatcher(t tVar) {
        if (tVar != null) {
            this.aVH = tVar.Lh();
            this.aIi = tVar.Li();
        }
    }

    public void showFloatingView() {
        if (this.aVH != null) {
            this.aVH.cd(true);
        }
    }

    public void update() {
        com.baidu.tieba.homepage.framework.a.aCk().h(System.currentTimeMillis(), 1);
        this.mPn = 1;
        this.dQt = true;
        if (this.mDataList.size() == 0 && !aCE()) {
            if (!this.dMV) {
                aCd();
                return;
            }
            return;
        }
        aCb();
    }

    public void aQ(int i, int i2) {
        bd bdVar;
        if (!w.z(this.mDataList) && this.mDataList.size() > i) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            while (i < this.mDataList.size() && i <= i2) {
                if (this.mDataList.get(i).getType().getId() == bd.ahN.getId() && (bdVar = (bd) this.mDataList.get(i)) != null && bdVar.vE() != null) {
                    arrayList.add(Long.valueOf(bdVar.vE().live_id));
                    arrayList2.add(bdVar);
                }
                i++;
            }
            if (!w.z(arrayList)) {
                MessageManager.getInstance().sendMessage(new LiveRoomClosedQueryMessage(arrayList, arrayList2));
            }
        }
    }

    public void aCH() {
        if (this.djB != null && !this.mIsBackground && this.dQq) {
            this.djB.b(this.diQ, this.brT, this.djt, true);
        }
        if (this.dQr) {
            if (this.dLk) {
                if (gB(false)) {
                    aR(3, this.dQm);
                } else if (this.dQs > 0) {
                    aR(2, this.dQm);
                }
            } else if (!this.dLk && this.dQm == 0) {
                aR(2, 0);
            }
            com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("recommend_frs_refresh_time", System.currentTimeMillis());
            this.dQr = false;
            this.dLk = false;
            this.dQs = 0;
            if (this.dQt) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
            }
            this.dQt = false;
        }
    }

    public void SJ() {
        if (Ax()) {
            com.baidu.tieba.homepage.framework.a.aCk().h(0L, 1);
        } else if (this.dQi != null) {
            aCJ();
            this.mPn++;
            setIsLoading(true);
            this.dQi.C(this.mPn, (this.dQj == null || this.dQj.thread_list == null) ? 0 : this.dQj.thread_list.size(), 0);
        }
    }

    public void a(boolean z, boolean z2, DataRes dataRes, int i, String str) {
        if (z) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("recommend_frs_guide_time", System.currentTimeMillis());
        }
        int size = (this.dQj == null || this.dQj.thread_list == null) ? 0 : this.dQj.thread_list.size();
        if (i != 0 || dataRes == null || !a(true, z, z2, dataRes)) {
            this.dQr = false;
            if (this.mDataList.size() > 0) {
                if (this.dQi != null) {
                    this.dQi.onError(1, str);
                }
            } else if (this.dQi != null) {
                this.dQi.onError(2, str);
            }
        } else {
            aCF();
            if (this.dQi != null) {
                this.dQi.onSuccess();
            }
            this.dQr = true;
            this.dLk = z;
            this.dQs = size;
            apa();
        }
        setIsLoading(false);
        if (this.mListView != null) {
            this.mListView.completePullRefreshPostDelayed(2000L);
        }
    }

    public void gv(boolean z) {
        if (z) {
            this.dPO.notifyDataSetChanged();
        }
        if (!aCI()) {
            aCL();
        }
    }

    public void onDestroy() {
        if (this.djB != null) {
            this.djB.destroy();
        }
        if (this.dQn != null) {
            this.dQn.onDestroy();
        }
        if (this.dQh != null) {
            this.dQh.onDestroy();
        }
        if (this.mListView != null) {
            this.mListView.removeCallbacks(this.dQC);
        }
    }

    public void onPause() {
        mx(this.dQB);
        if (this.dQp != null) {
            this.dQp.Kk();
        }
    }

    public boolean aCI() {
        if (gB(false)) {
            if (this.mListView != null && this.mListView.isRefreshDone()) {
                this.mListView.setSelection(0);
                this.mListView.startPullRefresh();
            }
            return true;
        }
        return false;
    }

    private void aCb() {
        if (this.dQi != null) {
            this.dQi.aP((this.dQj == null || this.dQj.thread_list == null || aCK()) ? 0 : this.dQj.thread_list.size(), 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(DataRes dataRes) {
        this.dMV = true;
        if (dataRes != null) {
            if (a(false, true, true, dataRes) && !aCK()) {
                if (this.dQi != null) {
                    this.dQi.onSuccess();
                }
                aCL();
                return;
            }
            aCb();
            return;
        }
        aCb();
    }

    private void bO(List<h> list) {
        if (!w.z(list)) {
            for (h hVar : list) {
                if (hVar instanceof com.baidu.tieba.card.data.d) {
                    com.baidu.tieba.card.data.d dVar = (com.baidu.tieba.card.data.d) hVar;
                    if (dVar.ajx() != null) {
                        dVar.ajx().advertAppContext = new com.baidu.tbadk.core.data.b();
                        dVar.ajx().advertAppContext.adp = "NEWINDEX";
                        dVar.ajx().advertAppContext.pn = 1;
                        dVar.ajx().advertAppContext.extensionInfo = dVar.ajx().extensionInfo;
                        dVar.ajx().advertAppContext.OZ = false;
                    }
                }
            }
        }
    }

    private boolean a(boolean z, boolean z2, boolean z3, DataRes dataRes) {
        List<h> list;
        boolean z4;
        if (dataRes == null) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        this.dQk = dataRes.sug_seconds.intValue() * 1000;
        if (z2 && aCK()) {
            this.dQj = null;
        }
        int size = z2 ? 0 : this.mDataList.size();
        DataRes.Builder builder = new DataRes.Builder(dataRes);
        this.mDataList.clear();
        com.baidu.tieba.homepage.personalize.model.c a2 = this.dQo.a(z, this.dQj, builder, z2 ? 0 : 1);
        if (a2 == null) {
            list = null;
        } else {
            List<h> list2 = a2.bfM;
            this.dQm = a2.dRL;
            list = list2;
        }
        if (list != null) {
            this.mDataList.addAll(list);
            bO(list);
            a(z2 ? 0 : 1, list, size);
            if (this.dQt) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
            }
        }
        if (this.dQj == null) {
            this.dQj = builder;
            this.dQh.bM(this.dQj.thread_list);
        }
        if (this.mDataList.size() == 0) {
            z4 = false;
        } else {
            if (z2) {
                if (dataRes.live_answer != null) {
                    this.dQu = new g();
                    this.dQu.a(dataRes.live_answer);
                    this.dQj.live_answer = dataRes.live_answer;
                } else if (z) {
                    this.dQu = null;
                    this.dQj.live_answer = null;
                }
                this.dQw = dataRes.float_info;
                this.dQj.float_info = dataRes.float_info;
            }
            long j = com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("key_maintab_banner_close_time", 0L);
            if (this.dQu != null && !ao.R(j)) {
                this.mDataList.add(0, this.dQu);
            }
            LinkedList linkedList = new LinkedList(this.mDataList);
            this.dPO.setFromCDN(dataRes.is_new_url.intValue() == 1);
            this.dPO.ai(linkedList);
            z4 = true;
            if (this.djB != null && this.dQq) {
                this.djB.b(this.diQ, this.brT, this.djt, true);
            }
        }
        com.baidu.tieba.homepage.framework.a.aCk().f(System.currentTimeMillis() - currentTimeMillis, 1);
        long mj = com.baidu.tieba.homepage.framework.a.aCk().mj(1);
        if (mj > 0) {
            com.baidu.tieba.homepage.framework.a.aCk().g(System.currentTimeMillis() - mj, 1);
            com.baidu.tieba.homepage.framework.a.aCk().h(0L, 1);
        }
        if (dataRes.anti != null && dataRes.anti.block_pop_info != null) {
            com.baidu.tieba.s.b.d(dataRes.anti.block_pop_info);
        }
        at atVar = new at();
        atVar.a(dataRes.recom_post_topic);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921333, atVar));
        return z4;
    }

    private void aCJ() {
        if (w.y(this.mDataList) >= this.dQo.aCV() - 40) {
            com.baidu.tieba.homepage.personalize.model.c a2 = this.dQo.a(true, this.dQj, (DataRes.Builder) null, 1);
            List<h> list = a2 != null ? a2.bfM : null;
            if (list != null) {
                this.mDataList.clear();
                this.mDataList.addAll(list);
                this.dPO.ai(new LinkedList(this.mDataList));
            }
        }
    }

    private void aCd() {
        this.dMV = true;
        com.baidu.tbadk.util.w.a(new com.baidu.tbadk.util.v<DataRes>() { // from class: com.baidu.tieba.homepage.personalize.d.20
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.v
            /* renamed from: aCQ */
            public DataRes doInBackground() {
                com.baidu.adp.lib.cache.l<byte[]> Q = com.baidu.tbadk.core.c.a.wW().Q("tb.rec_frs_update", TbadkCoreApplication.getCurrentAccount());
                if (Q == null) {
                    return null;
                }
                byte[] bArr = Q.get("0");
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
        }, new com.baidu.tbadk.util.h<DataRes>() { // from class: com.baidu.tieba.homepage.personalize.d.21
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.h
            /* renamed from: b */
            public void onReturnDataInUI(DataRes dataRes) {
                d.this.a(dataRes);
            }
        });
    }

    private void apa() {
        if (this.dQj != null) {
            DataRes.Builder builder = new DataRes.Builder(this.dQj.build(true));
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
    public void nv(String str) {
        if (!TextUtils.isEmpty(str) && this.dQj != null && this.dQj.banner_list != null && this.dQj.banner_list.app != null && this.dQj.banner_list.app.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (App app : this.dQj.banner_list.app) {
                if (app != null && str.equals(app.id)) {
                    arrayList.add(app);
                }
            }
            BannerList.Builder builder = new BannerList.Builder(this.dQj.banner_list);
            if (builder.app != null) {
                builder.app.removeAll(arrayList);
            }
            this.dQj.banner_list = builder.build(false);
            DataRes.Builder builder2 = new DataRes.Builder(this.dQj.build(true));
            builder2.banner_list = builder.build(true);
            a(builder2);
        }
    }

    private void a(final DataRes.Builder builder) {
        com.baidu.tbadk.util.w.a(new com.baidu.tbadk.util.v<Object>() { // from class: com.baidu.tieba.homepage.personalize.d.22
            @Override // com.baidu.tbadk.util.v
            public Object doInBackground() {
                DataRes.Builder builder2 = new DataRes.Builder(builder.build(true));
                d.this.dQh.bN(builder2.thread_list);
                try {
                    com.baidu.tbadk.core.c.a.wW().Q("tb.rec_frs_update", TbadkCoreApplication.getCurrentAccount()).e("0", builder2.build(true).toByteArray());
                    return null;
                } catch (Exception e) {
                    BdLog.e(e);
                    return null;
                }
            }
        }, null);
    }

    private boolean aCK() {
        return gB(true);
    }

    private boolean gB(boolean z) {
        long j = com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("recommend_frs_refresh_time", 0L);
        return j == 0 ? z : Math.abs(System.currentTimeMillis() - j) > this.dQg;
    }

    public void a(a aVar) {
        this.dQi = aVar;
    }

    private boolean Ax() {
        return this.mIsLoading;
    }

    private void setIsLoading(boolean z) {
        this.mIsLoading = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aCL() {
        long j = com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("recommend_frs_guide_time", 0L);
        if (this.dQk != 0) {
            if (j == 0 || Math.abs(System.currentTimeMillis() - j) > this.dQk) {
                aR(1, 0);
            }
        }
    }

    public void aCC() {
        boolean z = true;
        com.baidu.tbadk.coreExtra.data.a activityPrizeData = TbadkCoreApplication.getInst().getActivityPrizeData();
        if (activityPrizeData.Bu() && !StringUtils.isNull(activityPrizeData.BC())) {
            String currentDay = UtilHelper.getCurrentDay();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            String str = "";
            if (!StringUtils.isNull(currentAccount)) {
                String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("activity_prize_feed_text_time", "");
                if (!StringUtils.isNull(string)) {
                    String[] split = string.split("@");
                    if (split != null && split.length == 2) {
                        String str2 = split[0];
                        String[] split2 = split[1].split(",");
                        if (!StringUtils.isNull(str2) && split2.length != 0) {
                            if (str2.equals(currentDay)) {
                                List<String> asList = Arrays.asList(split2);
                                if (asList.contains(currentAccount)) {
                                    z = false;
                                } else {
                                    StringBuilder sb = new StringBuilder();
                                    sb.append(currentDay).append("@");
                                    for (String str3 : asList) {
                                        sb.append(str3).append(",");
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
                    aR(4, 0);
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putString("activity_prize_feed_text_time", str);
                }
            }
        }
    }

    private void aR(int i, int i2) {
        FrameLayout.LayoutParams layoutParams;
        if (this.dPB != null) {
            this.dQn.auT();
        }
        if (this.dPB != null && this.dPB.getCurrentTabType() != 1) {
            this.dQn.hideTip();
        } else if (!this.dQv) {
            this.dQn.hideTip();
        } else {
            this.dQl = i;
            String str = null;
            if (i == 1) {
                str = TbadkCoreApplication.getInst().getString(d.k.recommend_frs_refresh_guide);
            } else if (i == 2) {
                if (i2 > 0) {
                    str = String.format(TbadkCoreApplication.getInst().getString(d.k.recommend_frs_refresh_return), Integer.valueOf(i2));
                } else {
                    str = TbadkCoreApplication.getInst().getString(d.k.recommend_frs_refresh_nodata);
                }
            } else if (i == 3) {
                str = TbadkCoreApplication.getInst().getString(d.k.recommend_frs_refresh_cache_invalid);
            } else if (i == 4) {
                str = TbadkCoreApplication.getInst().getActivityPrizeData().BC();
            }
            if (!TextUtils.isEmpty(str)) {
                if (this.alu == null) {
                    this.alu = new TextView(this.mPageContext.getPageActivity());
                    this.alu.setGravity(17);
                    this.alu.setOnClickListener(this.dQx);
                }
                this.dQn.auT();
                FrameLayout frameLayout = this.dPB.getFrameLayout();
                if (frameLayout != null && this.alu.getParent() == null) {
                    if (i == 1) {
                        if (j.jD()) {
                            int dimensionPixelSize = this.mPageContext.getResources().getDimensionPixelSize(d.e.ds20);
                            int dimensionPixelSize2 = this.mPageContext.getResources().getDimensionPixelSize(d.e.ds40);
                            this.alu.setPadding(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
                            this.alu.setTextSize(0, this.mPageContext.getResources().getDimensionPixelSize(d.e.fontsize28));
                            com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("recommend_frs_guide_time", System.currentTimeMillis());
                            al.i(this.alu, d.f.bg_home_float);
                            al.h(this.alu, d.C0141d.cp_link_tip_a);
                            layoutParams = new FrameLayout.LayoutParams(-2, -2);
                            layoutParams.gravity = 49;
                            layoutParams.topMargin = this.dPE;
                        } else {
                            return;
                        }
                    } else {
                        this.alu.setPadding(0, 0, 0, 0);
                        this.alu.setTextSize(0, this.mPageContext.getResources().getDimensionPixelSize(d.e.fontsize24));
                        al.i(this.alu, d.C0141d.common_color_10260);
                        al.h(this.alu, d.C0141d.cp_cont_g);
                        layoutParams = new FrameLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.e(TbadkCoreApplication.getInst(), d.e.ds56));
                        layoutParams.gravity = 49;
                        layoutParams.topMargin = this.dPE;
                    }
                    this.alu.setText(str);
                    if (i == 1) {
                        this.dkT = 4000;
                    } else if (i == 4) {
                        this.dkT = 3000;
                    } else {
                        this.dkT = 2000;
                    }
                    this.dQn.a(this.alu, frameLayout, layoutParams, this.dkT);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(Long l) {
        if (this.dQj != null && this.dQj.thread_list != null) {
            List<ThreadInfo> list = this.dQj.thread_list;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                ThreadInfo threadInfo = list.get(i);
                if (threadInfo.tid.equals(l) && threadInfo.top_agree_post != null) {
                    ThreadInfo.Builder builder = new ThreadInfo.Builder(threadInfo);
                    builder.top_agree_post = null;
                    list.set(i, builder.build(true));
                    apa();
                    a(false, true, false, this.dQj.build(true));
                    return;
                }
            }
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            if (this.axl != null) {
                this.axl.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.axl);
            }
            if (this.dQy != null) {
                this.dQy.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.dQy);
            }
            this.mAttentionListener.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.mAttentionListener);
            this.dQz.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.dQz);
            this.dyi.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.dyi);
            this.dyj.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.dyj);
            this.dyk.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.dyk);
            if (this.djB != null) {
                this.djB.setUniqueId(bdUniqueId);
            }
            this.dQh.h(bdUniqueId);
            this.dQE.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.dQE);
        }
    }

    public void aCM() {
        this.dhy = new com.baidu.tieba.tbadkCore.data.e("new_index", null);
        this.dhy.bwC();
    }

    public void a(int i, List<h> list, int i2) {
        int i3;
        int i4;
        if (this.dhy != null) {
            if (i == 0) {
                this.dhy.bwC();
            }
            if (list != null && !list.isEmpty()) {
                int[] iArr = com.baidu.tieba.tbadkCore.data.e.gIw;
                int i5 = 0;
                int i6 = 0;
                int i7 = 0;
                while (i7 < list.size() && i6 < iArr.length && (i3 = iArr[i6]) >= 0) {
                    if (list.get(i7) instanceof com.baidu.tieba.card.data.c) {
                        i4 = i5 + 1;
                        if (i4 == i3 - 1) {
                            if (i2 < i7 + 1) {
                                this.dhy.bJ(i3, i7 + 1);
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

    public void mw(int i) {
        if ((this.dhy != null ? this.dhy.tw(i) : -1) >= 0 && this.mListView != null && this.mListView.getData() != null && this.mListView.getData().size() > i) {
            this.dhy.tx(i);
        }
    }

    public m aug() {
        return this.djB;
    }

    public void gC(boolean z) {
        this.dQq = z;
    }

    public void mx(final int i) {
        com.baidu.tbadk.util.w.a(new com.baidu.tbadk.util.v<Object>() { // from class: com.baidu.tieba.homepage.personalize.d.5
            @Override // com.baidu.tbadk.util.v
            public Object doInBackground() {
                com.baidu.adp.lib.cache.l<String> R = com.baidu.tbadk.core.c.a.wW().R(d.this.dQA, TbadkCoreApplication.getCurrentAccount());
                if (R != null) {
                    R.a(d.this.dQA, Integer.toString(i), 43200000L);
                    return null;
                }
                return null;
            }
        }, null);
    }

    public void a(final c cVar) {
        com.baidu.tbadk.util.w.a(new com.baidu.tbadk.util.v<String>() { // from class: com.baidu.tieba.homepage.personalize.d.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.v
            /* renamed from: aCP */
            public String doInBackground() {
                com.baidu.adp.lib.cache.l<String> R = com.baidu.tbadk.core.c.a.wW().R(d.this.dQA, TbadkCoreApplication.getCurrentAccount());
                if (R != null) {
                    return R.get(d.this.dQA);
                }
                return null;
            }
        }, new com.baidu.tbadk.util.h<String>() { // from class: com.baidu.tieba.homepage.personalize.d.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.h
            /* renamed from: nw */
            public void onReturnDataInUI(String str) {
                if (cVar != null) {
                    cVar.mk(com.baidu.adp.lib.g.b.g(str, 0));
                }
            }
        });
    }

    public void aCN() {
        a(this.dQD);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(CustomResponsedMessage<?> customResponsedMessage) {
        String str;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.dQj != null && w.y(this.dQj.thread_list) != 0 && w.y(this.mDataList) != 0) {
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
                        h item = this.mListView.getItem(i);
                        if (item instanceof com.baidu.tieba.card.data.j) {
                            com.baidu.tieba.card.data.j jVar = (com.baidu.tieba.card.data.j) item;
                            if (jVar.Sz() != null && jVar.Sz().vE() != null && optString2.equals(String.valueOf(jVar.Sz().vE().live_id))) {
                                str = jVar.Sz().getTid();
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
                        aE(childAt);
                    } else if (this.dPO != null) {
                        this.dPO.ai(new ArrayList(this.mDataList));
                    }
                } else {
                    return;
                }
            }
            Iterator<h> it = this.mDataList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                h next = it.next();
                if (next instanceof com.baidu.tieba.card.data.c) {
                    com.baidu.tieba.card.data.c cVar = (com.baidu.tieba.card.data.c) next;
                    if (cVar.Sz() != null && cVar.Sz().getTid() != null && cVar.Sz().getTid().equals(optString)) {
                        it.remove();
                        com.baidu.tieba.homepage.personalize.model.b.bQ(this.mDataList);
                        break;
                    }
                }
            }
            if (this.dQj != null && this.dQj.thread_list != null) {
                long c = com.baidu.adp.lib.g.b.c(optString, 0L);
                for (int i2 = 0; i2 < this.dQj.thread_list.size(); i2++) {
                    ThreadInfo threadInfo = this.dQj.thread_list.get(i2);
                    if (threadInfo != null && threadInfo.tid != null && threadInfo.tid.longValue() == c) {
                        this.dQj.thread_list.remove(i2);
                        apa();
                        com.baidu.tieba.homepage.personalize.b.d.a(threadInfo.tid.longValue(), i2, this.dQj.thread_list, this.mDataList);
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
                h item = bdTypeListView.getItem(i3);
                if (item instanceof com.baidu.tieba.card.data.c) {
                    com.baidu.tieba.card.data.c cVar = (com.baidu.tieba.card.data.c) item;
                    if (cVar.Sz() != null && cVar.Sz().getTid().equals(str)) {
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

    private void aE(final View view) {
        final int measuredHeight = view.getMeasuredHeight();
        Animation animation = new Animation() { // from class: com.baidu.tieba.homepage.personalize.d.13
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
        animation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.homepage.personalize.d.14
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation2) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation2) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation2) {
                view.setVisibility(8);
                if (d.this.dPO != null) {
                    d.this.dPO.ai(new ArrayList(d.this.mDataList));
                }
            }
        });
        animation.setDuration(300L);
        view.startAnimation(animation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(String str, List<h> list) {
        AdvertAppInfo advertAppInfo;
        if (list != null && list.size() > 0 && !TextUtils.isEmpty(str)) {
            Iterator<h> it = list.iterator();
            AdvertAppInfo advertAppInfo2 = null;
            while (it.hasNext()) {
                h next = it.next();
                if (next instanceof com.baidu.tieba.homepage.personalize.data.a) {
                    advertAppInfo = ((com.baidu.tieba.homepage.personalize.data.a) next).ajx();
                } else {
                    if (next instanceof ac) {
                        ac acVar = (ac) next;
                        if (acVar.ui() instanceof AdvertAppInfo.ILegoAdvert) {
                            advertAppInfo = ((AdvertAppInfo.ILegoAdvert) acVar.ui()).getAdvertAppInfo();
                        }
                    }
                    advertAppInfo = advertAppInfo2;
                }
                if (advertAppInfo != null && str.equals(advertAppInfo.adL)) {
                    it.remove();
                    advertAppInfo = null;
                }
                advertAppInfo2 = advertAppInfo;
            }
        }
    }

    public FloatInfo aCO() {
        return this.dQw;
    }
}
