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
import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.ac;
import com.baidu.tbadk.core.data.at;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tbadk.k.f;
import com.baidu.tbadk.util.r;
import com.baidu.tbadk.util.s;
import com.baidu.tbadk.util.u;
import com.baidu.tieba.ala.LiveRoomClosedQueryMessage;
import com.baidu.tieba.card.v;
import com.baidu.tieba.d;
import com.baidu.tieba.f.a;
import com.baidu.tieba.frs.aq;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import com.baidu.tieba.homepage.personalize.a.l;
import com.baidu.tieba.homepage.personalize.data.g;
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
import tbclient.Personalized.FloatInfo;
import tbclient.ThreadInfo;
import tbclient.User;
import tbclient.Zan;
/* loaded from: classes2.dex */
public class d {
    private r aNK;
    private View.OnTouchListener azN;
    private com.baidu.tieba.tbadkCore.data.e cYk;
    private boolean dAa;
    private final l dED;
    private final long dEV;
    private final b dEW;
    private DataRes.Builder dEY;
    private ScrollFragmentTabHost dEq;
    private int dEt;
    private aq dFc;
    private final com.baidu.tieba.homepage.personalize.model.a dFd;
    private int dFh;
    private g dFj;
    private Runnable dFr;
    private m daj;
    private com.baidu.tieba.f.a drz;
    private final BdTypeListView mListView;
    private final TbPageContext<?> mPageContext;
    private a dEX = null;
    private final List<h> mDataList = new LinkedList();
    private int mPn = 1;
    private boolean mIsLoading = false;
    private boolean dBL = false;
    private long dEZ = 0;
    private int dFa = 1;
    private int dFb = 0;
    private TextView adw = null;
    private int dbD = 2000;
    private f dFe = null;
    private boolean dab = false;
    private int cZz = 0;
    private int bjP = 0;
    private boolean mIsBackground = false;
    private boolean dFf = true;
    private boolean dFg = false;
    private boolean dFi = false;
    private boolean dFk = true;
    private FloatInfo dFl = null;
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.d.12
        private int dBQ = -1;
        private int dBR = 0;
        private boolean dBS = false;

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (d.this.dFe == null) {
                d.this.dFe = new f();
                d.this.dFe.fj(1005);
                d.this.dFe.pageType = 1;
            }
            if (d.this.aNK != null && !d.this.mIsBackground) {
                d.this.aNK.onScrollStateChanged(absListView, i);
            }
            d.this.dFe.GD();
            if (i == 0) {
                v.afy().cB(true);
                if (this.dBS) {
                    d.this.axQ();
                }
                this.dBS = false;
                if (d.this.daj != null && d.this.dFf) {
                    d.this.daj.a(d.this.cZz, d.this.bjP, d.this.dab, 1);
                }
            } else if (i == 1 && d.this.dFc != null) {
                d.this.dFc.hideTip();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (this.dBR > i) {
                this.dBS = true;
            }
            if (d.this.aNK != null && !d.this.mIsBackground) {
                d.this.aNK.a(absListView, this.dBR, i, i2, i3);
            }
            this.dBR = i;
            int i4 = (i + i2) - 1;
            if (!this.dBS && this.dBQ != i4) {
                this.dBQ = i4;
                d.this.mk(this.dBQ);
            }
            if (this.dBS && this.dBQ != i) {
                this.dBQ = i;
                d.this.mk(this.dBQ);
            }
            d.this.dFq = i;
            d.this.cZz = i;
            d.this.bjP = (i + i2) - 1;
        }
    };
    private View.OnTouchListener aNL = new View.OnTouchListener() { // from class: com.baidu.tieba.homepage.personalize.d.16
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            if (d.this.azN != null) {
                d.this.azN.onTouch(view2, motionEvent);
            }
            if (d.this.drz != null) {
                d.this.drz.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private a.InterfaceC0131a bzs = new a.InterfaceC0131a() { // from class: com.baidu.tieba.homepage.personalize.d.17
        @Override // com.baidu.tieba.f.a.InterfaceC0131a
        public void W(int i, int i2) {
            d.this.dab = true;
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0131a
        public void X(int i, int i2) {
            d.this.dab = false;
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0131a
        public void Y(int i, int i2) {
        }
    };
    private View.OnClickListener dFm = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.d.18
        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            if (d.this.dFc != null) {
                d.this.dFc.hideTip();
            }
            if (d.this.dFa == 1 && d.this.mListView != null) {
                d.this.mListView.setSelection(0);
                d.this.mListView.startPullRefresh();
            }
        }
    };
    private final CustomMessageListener dFn = new CustomMessageListener(2001399) { // from class: com.baidu.tieba.homepage.personalize.d.19
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (d.this.mListView != null) {
                d.this.daj.ayY();
                d.this.dFf = false;
                d.this.mListView.completePullRefreshPostDelayed(2000L);
                d.this.mListView.startPullRefresh();
            }
        }
    };
    private CustomMessageListener apd = new CustomMessageListener(2004004) { // from class: com.baidu.tieba.homepage.personalize.d.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            bd bdVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bd) && d.this.dEY != null && com.baidu.tbadk.core.util.v.v(d.this.dEY.thread_list) != 0 && (bdVar = (bd) customResponsedMessage.getData()) != null && bdVar.rE() != null && bdVar.getId() != null && com.baidu.tbadk.core.util.v.v(d.this.dEY.thread_list) != 0) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < d.this.dEY.thread_list.size()) {
                        ThreadInfo threadInfo = d.this.dEY.thread_list.get(i2);
                        if (threadInfo == null || threadInfo.id.longValue() != com.baidu.adp.lib.g.b.c(bdVar.getId(), -1L)) {
                            i = i2 + 1;
                        } else {
                            ThreadInfo.Builder builder = new ThreadInfo.Builder(threadInfo);
                            Zan.Builder builder2 = new Zan.Builder(builder.zan);
                            builder2.num = Integer.valueOf((int) bdVar.rE().getNum());
                            builder.zan = builder2.build(true);
                            d.this.dEY.thread_list.set(i2, builder.build(true));
                            return;
                        }
                    } else {
                        return;
                    }
                }
            }
        }
    };
    private CustomMessageListener dFo = new CustomMessageListener(2921026) { // from class: com.baidu.tieba.homepage.personalize.d.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            bd bdVar;
            if (customResponsedMessage.getOrginalMessage() instanceof LiveRoomClosedQueryMessage) {
                List<Long> ids = ((LiveRoomClosedQueryMessage) customResponsedMessage.getOrginalMessage()).getIds();
                List<Object> originData = ((LiveRoomClosedQueryMessage) customResponsedMessage.getOrginalMessage()).getOriginData();
                if (!com.baidu.tbadk.core.util.v.w(d.this.mDataList) && !com.baidu.tbadk.core.util.v.w(ids) && !com.baidu.tbadk.core.util.v.w(originData)) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= originData.size()) {
                            break;
                        }
                        if ((originData.get(i2) instanceof bd) && (bdVar = (bd) originData.get(i2)) != null && bdVar.sh() != null && ids.contains(Long.valueOf(bdVar.sh().live_id))) {
                            d.this.mDataList.remove(bdVar);
                        }
                        i = i2 + 1;
                    }
                    if (d.this.dED != null) {
                        d.this.dED.af(new ArrayList(d.this.mDataList));
                    }
                }
            }
        }
    };
    private CustomMessageListener mAttentionListener = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.homepage.personalize.d.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int intValue;
            if ((customResponsedMessage instanceof UpdateAttentionMessage) && d.this.dEY != null && !com.baidu.tbadk.core.util.v.w(d.this.dEY.thread_list)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid)) {
                    for (int i = 0; i < d.this.dEY.thread_list.size(); i++) {
                        ThreadInfo threadInfo = d.this.dEY.thread_list.get(i);
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
                            d.this.dEY.thread_list.set(i, builder.build(true));
                            return;
                        }
                    }
                }
            }
        }
    };
    private String dFp = "lastReadReadPositionKey";
    private int dFq = 0;
    private c dFs = new c() { // from class: com.baidu.tieba.homepage.personalize.d.7
        @Override // com.baidu.tieba.homepage.personalize.c
        public void lY(final int i) {
            if (d.this.dFr == null) {
                d.this.dFr = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.d.7.1
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
            d.this.mListView.removeCallbacks(d.this.dFr);
            d.this.mListView.post(d.this.dFr);
        }
    };
    private CustomMessageListener doR = new CustomMessageListener(2016488) { // from class: com.baidu.tieba.homepage.personalize.d.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.this.h(customResponsedMessage);
        }
    };
    private CustomMessageListener doS = new CustomMessageListener(2016553) { // from class: com.baidu.tieba.homepage.personalize.d.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.this.h(customResponsedMessage);
        }
    };
    private CustomMessageListener doT = new CustomMessageListener(2016331) { // from class: com.baidu.tieba.homepage.personalize.d.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && d.this.dEY != null && com.baidu.tbadk.core.util.v.v(d.this.dEY.thread_list) != 0) {
                String str = (String) customResponsedMessage.getData();
                d.this.f(str, d.this.mDataList);
                d.this.mK(str);
                if (d.this.dED != null) {
                    d.this.dED.af(new ArrayList(d.this.mDataList));
                }
            }
        }
    };

    /* loaded from: classes2.dex */
    public interface a {
        void C(int i, int i2, int i3);

        void aN(int i, int i2);

        void onError(int i, String str);

        void onSuccess();
    }

    public void gu(boolean z) {
        this.dFk = z;
        if (this.dFc != null && !z) {
            this.dFc.hideTip();
        }
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.dEq = scrollFragmentTabHost;
        if (this.dEq != null) {
            this.dEq.setOnTabSelectedListener(new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.personalize.d.1
                @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
                public void mi(int i) {
                    if (d.this.dEq.mh(i) != 1 && d.this.dFc != null) {
                        d.this.dFc.hideTip();
                    }
                }
            });
        }
    }

    public void setTabInForeBackgroundState(boolean z) {
        this.mIsBackground = z;
    }

    public void fy(boolean z) {
        this.mIsBackground = z;
        if (this.daj != null) {
            this.daj.id(!z);
            if (z) {
                this.daj.ayY();
            } else if (this.dFf) {
                this.daj.b(this.cZz, this.bjP, this.dab, true);
            }
        }
    }

    public d(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView, l lVar) {
        this.mPageContext = tbPageContext;
        this.mListView = bdTypeListView;
        this.mListView.setOnTouchListener(this.aNL);
        this.drz = new com.baidu.tieba.f.a();
        this.drz.a(this.bzs);
        this.dED = lVar;
        this.dFd = new com.baidu.tieba.homepage.personalize.model.a();
        this.dEV = com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("recommend_frs_cache_time", 43200L) * 1000;
        bdTypeListView.setOnScrollListener(this.mOnScrollListener);
        this.dFc = new aq();
        axR();
        this.daj = new m(this.mPageContext, this.mListView);
        this.dEW = new b(this.mDataList, this.dED);
    }

    private boolean axJ() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean(axL(), true);
    }

    private void axK() {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean(axL(), false);
    }

    private String axL() {
        return "key_rec_pfirst_load_" + TbadkCoreApplication.getCurrentAccount() + "_" + TbConfig.getVersion();
    }

    public void setHeaderViewHeight(int i) {
        this.dEt = i;
    }

    public void setRecommendFrsNavigationAnimDispatcher(s sVar) {
        if (sVar != null) {
            this.aNK = sVar.HL();
            this.azN = sVar.HM();
        }
    }

    public void showFloatingView() {
        if (this.aNK != null) {
            this.aNK.bY(true);
        }
    }

    public void update() {
        com.baidu.tieba.homepage.framework.a.axp().h(System.currentTimeMillis(), 1);
        this.mPn = 1;
        this.dFi = true;
        if (this.mDataList.size() == 0 && !this.dBL && !axJ()) {
            axk();
        } else {
            axi();
        }
    }

    public void aO(int i, int i2) {
        bd bdVar;
        if (!com.baidu.tbadk.core.util.v.w(this.mDataList) && this.mDataList.size() > i) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            while (i < this.mDataList.size() && i <= i2) {
                if (this.mDataList.get(i).getType().getId() == bd.ZL.getId() && (bdVar = (bd) this.mDataList.get(i)) != null && bdVar.sh() != null) {
                    arrayList.add(Long.valueOf(bdVar.sh().live_id));
                    arrayList2.add(bdVar);
                }
                i++;
            }
            if (!com.baidu.tbadk.core.util.v.w(arrayList)) {
                MessageManager.getInstance().sendMessage(new LiveRoomClosedQueryMessage(arrayList, arrayList2));
            }
        }
    }

    public void axM() {
        if (this.daj != null && !this.mIsBackground && this.dFf) {
            this.daj.b(this.cZz, this.bjP, this.dab, true);
        }
        if (this.dFg) {
            if (this.dAa) {
                if (gv(false)) {
                    aP(3, this.dFb);
                } else if (this.dFh > 0) {
                    aP(2, this.dFb);
                }
            } else if (!this.dAa && this.dFb == 0) {
                aP(2, 0);
            }
            com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("recommend_frs_refresh_time", System.currentTimeMillis());
            this.dFg = false;
            this.dAa = false;
            this.dFh = 0;
            if (this.dFi) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
            }
            this.dFi = false;
        }
    }

    public void Pl() {
        if (wW()) {
            com.baidu.tieba.homepage.framework.a.axp().h(0L, 1);
        } else if (this.dEX != null) {
            axO();
            this.mPn++;
            setIsLoading(true);
            this.dEX.C(this.mPn, (this.dEY == null || this.dEY.thread_list == null) ? 0 : this.dEY.thread_list.size(), 0);
        }
    }

    public void a(boolean z, boolean z2, DataRes dataRes, int i, String str) {
        if (z) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("recommend_frs_guide_time", System.currentTimeMillis());
        }
        int size = (this.dEY == null || this.dEY.thread_list == null) ? 0 : this.dEY.thread_list.size();
        if (i != 0 || dataRes == null || !a(true, z, z2, dataRes)) {
            this.dFg = false;
            if (this.mDataList.size() > 0) {
                if (this.dEX != null) {
                    this.dEX.onError(1, str);
                }
            } else if (this.dEX != null) {
                this.dEX.onError(2, str);
            }
        } else {
            axK();
            if (this.dEX != null) {
                this.dEX.onSuccess();
            }
            this.dFg = true;
            this.dAa = z;
            this.dFh = size;
            akU();
        }
        setIsLoading(false);
        if (this.mListView != null) {
            this.mListView.completePullRefreshPostDelayed(2000L);
        }
    }

    public void gp(boolean z) {
        if (z) {
            this.dED.notifyDataSetChanged();
        }
        if (!axN()) {
            axQ();
        }
    }

    public void onDestroy() {
        if (this.daj != null) {
            this.daj.destroy();
        }
        if (this.dFe != null) {
            this.dFe.onDestroy();
        }
        if (this.dFc != null) {
            this.dFc.onDestroy();
        }
        if (this.dEW != null) {
            this.dEW.onDestroy();
        }
        if (this.mListView != null) {
            this.mListView.removeCallbacks(this.dFr);
        }
    }

    public void onPause() {
        ml(this.dFq);
        mj(2016319);
    }

    public void onResume() {
        mj(2016318);
    }

    private void mj(final int i) {
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(i);
        final BdUniqueId uniqueId = this.mPageContext.getUniqueId();
        customResponsedMessage.setOrginalMessage(new CustomMessage<Object>(i, uniqueId) { // from class: com.baidu.tieba.homepage.personalize.PersonalizedUpdateController$7
        });
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
    }

    public boolean axN() {
        if (gv(false)) {
            if (this.mListView != null) {
                this.mListView.setSelection(0);
                this.mListView.startPullRefresh();
            }
            return true;
        }
        return false;
    }

    private void axi() {
        if (this.dEX != null) {
            this.dEX.aN((this.dEY == null || this.dEY.thread_list == null || axP()) ? 0 : this.dEY.thread_list.size(), 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(DataRes dataRes) {
        this.dBL = true;
        if (dataRes != null) {
            if (a(false, true, true, dataRes) && !axP()) {
                if (this.dEX != null) {
                    this.dEX.onSuccess();
                }
                axQ();
                return;
            }
            axi();
            return;
        }
        axi();
    }

    private void bJ(List<h> list) {
        if (!com.baidu.tbadk.core.util.v.w(list)) {
            for (h hVar : list) {
                if (hVar instanceof com.baidu.tieba.card.data.d) {
                    com.baidu.tieba.card.data.d dVar = (com.baidu.tieba.card.data.d) hVar;
                    if (dVar.afP() != null) {
                        dVar.afP().advertAppContext = new com.baidu.tbadk.core.data.b();
                        dVar.afP().advertAppContext.Vp = "NEWINDEX";
                        dVar.afP().advertAppContext.pn = 1;
                        dVar.afP().advertAppContext.extensionInfo = dVar.afP().extensionInfo;
                        dVar.afP().advertAppContext.IM = false;
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
        this.dEZ = dataRes.sug_seconds.intValue() * 1000;
        if (z2 && axP()) {
            this.dEY = null;
        }
        int size = z2 ? 0 : this.mDataList.size();
        DataRes.Builder builder = new DataRes.Builder(dataRes);
        this.mDataList.clear();
        com.baidu.tieba.homepage.personalize.model.c a2 = this.dFd.a(z, this.dEY, builder, z2 ? 0 : 1);
        if (a2 == null) {
            list = null;
        } else {
            List<h> list2 = a2.aXF;
            this.dFb = a2.dGv;
            list = list2;
        }
        if (list != null) {
            this.mDataList.addAll(list);
            bJ(list);
            a(z2 ? 0 : 1, list, size);
            if (this.dFi) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
            }
        }
        if (this.dEY == null) {
            this.dEY = builder;
            this.dEW.bH(this.dEY.thread_list);
        }
        if (this.mDataList.size() == 0) {
            z4 = false;
        } else {
            if (z2) {
                if (dataRes.live_answer != null) {
                    this.dFj = new g();
                    this.dFj.a(dataRes.live_answer);
                    this.dEY.live_answer = dataRes.live_answer;
                } else if (z) {
                    this.dFj = null;
                    this.dEY.live_answer = null;
                }
                this.dFl = dataRes.float_info;
                this.dEY.float_info = dataRes.float_info;
            }
            if (this.dFj != null) {
                this.mDataList.add(0, this.dFj);
            }
            LinkedList linkedList = new LinkedList(this.mDataList);
            this.dED.setFromCDN(dataRes.is_new_url.intValue() == 1);
            this.dED.af(linkedList);
            z4 = true;
            if (this.daj != null && this.dFf) {
                this.daj.b(this.cZz, this.bjP, this.dab, true);
            }
        }
        com.baidu.tieba.homepage.framework.a.axp().f(System.currentTimeMillis() - currentTimeMillis, 1);
        long lX = com.baidu.tieba.homepage.framework.a.axp().lX(1);
        if (lX > 0) {
            com.baidu.tieba.homepage.framework.a.axp().g(System.currentTimeMillis() - lX, 1);
            com.baidu.tieba.homepage.framework.a.axp().h(0L, 1);
        }
        if (dataRes != null && dataRes.anti != null && dataRes.anti.block_pop_info != null) {
            com.baidu.tieba.q.a.d(dataRes.anti.block_pop_info);
        }
        if (dataRes != null) {
            at atVar = new at();
            atVar.a(dataRes.recom_post_topic);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921333, atVar));
            return z4;
        }
        return z4;
    }

    private void axO() {
        if (com.baidu.tbadk.core.util.v.v(this.mDataList) >= this.dFd.aya() - 40) {
            com.baidu.tieba.homepage.personalize.model.c a2 = this.dFd.a(true, this.dEY, (DataRes.Builder) null, 1);
            List<h> list = a2 != null ? a2.aXF : null;
            if (list != null) {
                this.mDataList.clear();
                this.mDataList.addAll(list);
                this.dED.af(new LinkedList(this.mDataList));
            }
        }
    }

    private void axk() {
        com.baidu.tbadk.util.v.a(new u<DataRes>() { // from class: com.baidu.tieba.homepage.personalize.d.20
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.u
            /* renamed from: axV */
            public DataRes doInBackground() {
                com.baidu.adp.lib.cache.l<byte[]> N = com.baidu.tbadk.core.c.a.ty().N("tb.rec_frs_update", TbadkCoreApplication.getCurrentAccount());
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
        }, new com.baidu.tbadk.util.h<DataRes>() { // from class: com.baidu.tieba.homepage.personalize.d.21
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.h
            /* renamed from: b */
            public void onReturnDataInUI(DataRes dataRes) {
                d.this.a(dataRes);
            }
        });
    }

    private void akU() {
        if (this.dEY != null) {
            DataRes.Builder builder = new DataRes.Builder(this.dEY.build(true));
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
    public void mK(String str) {
        if (!TextUtils.isEmpty(str) && this.dEY != null && this.dEY.banner_list != null && this.dEY.banner_list.app != null && this.dEY.banner_list.app.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (App app : this.dEY.banner_list.app) {
                if (app != null && str.equals(app.id)) {
                    arrayList.add(app);
                }
            }
            BannerList.Builder builder = new BannerList.Builder(this.dEY.banner_list);
            if (builder.app != null) {
                builder.app.removeAll(arrayList);
            }
            this.dEY.banner_list = builder.build(false);
            DataRes.Builder builder2 = new DataRes.Builder(this.dEY.build(true));
            builder2.banner_list = builder.build(true);
            a(builder2);
        }
    }

    private void a(final DataRes.Builder builder) {
        com.baidu.tbadk.util.v.a(new u<Object>() { // from class: com.baidu.tieba.homepage.personalize.d.2
            @Override // com.baidu.tbadk.util.u
            public Object doInBackground() {
                DataRes.Builder builder2 = new DataRes.Builder(builder.build(true));
                d.this.dEW.bI(builder2.thread_list);
                try {
                    com.baidu.tbadk.core.c.a.ty().N("tb.rec_frs_update", TbadkCoreApplication.getCurrentAccount()).e("0", builder2.build(true).toByteArray());
                    return null;
                } catch (Exception e) {
                    BdLog.e(e);
                    return null;
                }
            }
        }, null);
    }

    private boolean axP() {
        return gv(true);
    }

    private boolean gv(boolean z) {
        long j = com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("recommend_frs_refresh_time", 0L);
        return j == 0 ? z : Math.abs(System.currentTimeMillis() - j) > this.dEV;
    }

    public void a(a aVar) {
        this.dEX = aVar;
    }

    private boolean wW() {
        return this.mIsLoading;
    }

    private void setIsLoading(boolean z) {
        this.mIsLoading = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void axQ() {
        long j = com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("recommend_frs_guide_time", 0L);
        if (this.dEZ != 0) {
            if (j == 0 || Math.abs(System.currentTimeMillis() - j) > this.dEZ) {
                aP(1, 0);
            }
        }
    }

    public void axF() {
        boolean z = true;
        com.baidu.tbadk.coreExtra.data.a activityPrizeData = TbadkCoreApplication.getInst().getActivityPrizeData();
        if (activityPrizeData.xU() && !StringUtils.isNull(activityPrizeData.yc())) {
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
                    aP(4, 0);
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putString("activity_prize_feed_text_time", str);
                }
            }
        }
    }

    private void aP(int i, int i2) {
        FrameLayout.LayoutParams layoutParams;
        if (this.dEq != null) {
            this.dFc.aqO();
        }
        if (this.dEq != null && this.dEq.getCurrentTabType() != 1) {
            this.dFc.hideTip();
        } else if (!this.dFk) {
            this.dFc.hideTip();
        } else {
            this.dFa = i;
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
                str = TbadkCoreApplication.getInst().getActivityPrizeData().yc();
            }
            if (!TextUtils.isEmpty(str)) {
                if (this.adw == null) {
                    this.adw = new TextView(this.mPageContext.getPageActivity());
                    this.adw.setGravity(17);
                    this.adw.setOnClickListener(this.dFm);
                }
                this.dFc.aqO();
                FrameLayout frameLayout = this.dEq.getFrameLayout();
                if (frameLayout != null && this.adw.getParent() == null) {
                    if (i == 1) {
                        if (j.gP()) {
                            int dimensionPixelSize = this.mPageContext.getResources().getDimensionPixelSize(d.e.ds20);
                            int dimensionPixelSize2 = this.mPageContext.getResources().getDimensionPixelSize(d.e.ds40);
                            this.adw.setPadding(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
                            this.adw.setTextSize(0, this.mPageContext.getResources().getDimensionPixelSize(d.e.fontsize28));
                            com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("recommend_frs_guide_time", System.currentTimeMillis());
                            ak.i(this.adw, d.f.bg_home_float);
                            ak.h(this.adw, d.C0126d.cp_link_tip_a);
                            layoutParams = new FrameLayout.LayoutParams(-2, -2);
                            layoutParams.gravity = 49;
                            layoutParams.topMargin = this.dEt;
                        } else {
                            return;
                        }
                    } else {
                        this.adw.setPadding(0, 0, 0, 0);
                        this.adw.setTextSize(0, this.mPageContext.getResources().getDimensionPixelSize(d.e.fontsize24));
                        ak.i(this.adw, d.C0126d.common_color_10260);
                        ak.h(this.adw, d.C0126d.cp_cont_g);
                        layoutParams = new FrameLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.e(TbadkCoreApplication.getInst(), d.e.ds56));
                        layoutParams.gravity = 49;
                        layoutParams.topMargin = this.dEt;
                    }
                    this.adw.setText(str);
                    if (i == 1) {
                        this.dbD = 4000;
                    } else if (i == 4) {
                        this.dbD = PushConstants.WORK_RECEIVER_EVENTCORE_ERROR;
                    } else {
                        this.dbD = 2000;
                    }
                    this.dFc.a(this.adw, frameLayout, layoutParams, this.dbD);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(Long l) {
        if (this.dEY != null && this.dEY.thread_list != null) {
            List<ThreadInfo> list = this.dEY.thread_list;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                ThreadInfo threadInfo = list.get(i);
                if (threadInfo.tid.equals(l) && threadInfo.top_agree_post != null) {
                    ThreadInfo.Builder builder = new ThreadInfo.Builder(threadInfo);
                    builder.top_agree_post = null;
                    list.set(i, builder.build(true));
                    akU();
                    a(false, true, false, this.dEY.build(true));
                    return;
                }
            }
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            if (this.apd != null) {
                this.apd.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.apd);
            }
            if (this.dFn != null) {
                this.dFn.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.dFn);
            }
            this.mAttentionListener.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.mAttentionListener);
            this.dFo.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.dFo);
            this.doR.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.doR);
            this.doS.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.doS);
            this.doT.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.doT);
            if (this.daj != null) {
                this.daj.setUniqueId(bdUniqueId);
            }
            this.dEW.h(bdUniqueId);
        }
    }

    public void axR() {
        this.cYk = new com.baidu.tieba.tbadkCore.data.e("new_index", null);
        this.cYk.brA();
    }

    public void a(int i, List<h> list, int i2) {
        int i3;
        int i4;
        if (this.cYk != null) {
            if (i == 0) {
                this.cYk.brA();
            }
            if (list != null && !list.isEmpty()) {
                int[] iArr = com.baidu.tieba.tbadkCore.data.e.gwX;
                int i5 = 0;
                int i6 = 0;
                int i7 = 0;
                while (i7 < list.size() && i6 < iArr.length && (i3 = iArr[i6]) >= 0) {
                    if (list.get(i7) instanceof com.baidu.tieba.card.data.c) {
                        i4 = i5 + 1;
                        if (i4 == i3 - 1) {
                            if (i2 < i7 + 1) {
                                this.cYk.bH(i3, i7 + 1);
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

    public void mk(int i) {
        if ((this.cYk != null ? this.cYk.tk(i) : -1) >= 0 && this.mListView != null && this.mListView.getData() != null && this.mListView.getData().size() > i) {
            this.cYk.tl(i);
        }
    }

    public m aqb() {
        return this.daj;
    }

    public void gw(boolean z) {
        this.dFf = z;
    }

    public void ml(final int i) {
        com.baidu.tbadk.util.v.a(new u<Object>() { // from class: com.baidu.tieba.homepage.personalize.d.6
            @Override // com.baidu.tbadk.util.u
            public Object doInBackground() {
                com.baidu.adp.lib.cache.l<String> O = com.baidu.tbadk.core.c.a.ty().O(d.this.dFp, TbadkCoreApplication.getCurrentAccount());
                if (O != null) {
                    O.a(d.this.dFp, Integer.toString(i), 43200000L);
                    return null;
                }
                return null;
            }
        }, null);
    }

    public void a(final c cVar) {
        com.baidu.tbadk.util.v.a(new u<String>() { // from class: com.baidu.tieba.homepage.personalize.d.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.u
            /* renamed from: axU */
            public String doInBackground() {
                com.baidu.adp.lib.cache.l<String> O = com.baidu.tbadk.core.c.a.ty().O(d.this.dFp, TbadkCoreApplication.getCurrentAccount());
                if (O != null) {
                    return O.get(d.this.dFp);
                }
                return null;
            }
        }, new com.baidu.tbadk.util.h<String>() { // from class: com.baidu.tieba.homepage.personalize.d.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.h
            /* renamed from: mL */
            public void onReturnDataInUI(String str) {
                if (cVar != null) {
                    cVar.lY(com.baidu.adp.lib.g.b.g(str, 0));
                }
            }
        });
    }

    public void axS() {
        a(this.dFs);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(CustomResponsedMessage<?> customResponsedMessage) {
        String str;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.dEY != null && com.baidu.tbadk.core.util.v.v(this.dEY.thread_list) != 0 && com.baidu.tbadk.core.util.v.v(this.mDataList) != 0) {
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
                            if (jVar.Pb() != null && jVar.Pb().sh() != null && optString2.equals(String.valueOf(jVar.Pb().sh().live_id))) {
                                str = jVar.Pb().getTid();
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
                        aB(childAt);
                    } else if (this.dED != null) {
                        this.dED.af(new ArrayList(this.mDataList));
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
                    if (cVar.Pb() != null && cVar.Pb().getTid() != null && cVar.Pb().getTid().equals(optString)) {
                        it.remove();
                        com.baidu.tieba.homepage.personalize.model.b.bL(this.mDataList);
                        break;
                    }
                }
            }
            if (this.dEY != null && this.dEY.thread_list != null) {
                long c = com.baidu.adp.lib.g.b.c(optString, 0L);
                for (int i2 = 0; i2 < this.dEY.thread_list.size(); i2++) {
                    ThreadInfo threadInfo = this.dEY.thread_list.get(i2);
                    if (threadInfo != null && threadInfo.tid != null && threadInfo.tid.longValue() == c) {
                        this.dEY.thread_list.remove(i2);
                        akU();
                        com.baidu.tieba.homepage.personalize.b.d.a(threadInfo.tid.longValue(), i2, this.dEY.thread_list, this.mDataList);
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
                    if (cVar.Pb() != null && cVar.Pb().getTid().equals(str)) {
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

    private void aB(final View view2) {
        final int measuredHeight = view2.getMeasuredHeight();
        Animation animation = new Animation() { // from class: com.baidu.tieba.homepage.personalize.d.13
            @Override // android.view.animation.Animation
            protected void applyTransformation(float f, Transformation transformation) {
                view2.getLayoutParams().height = measuredHeight - ((int) (measuredHeight * f));
                view2.requestLayout();
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
                view2.setVisibility(8);
                if (d.this.dED != null) {
                    d.this.dED.af(new ArrayList(d.this.mDataList));
                }
            }
        });
        animation.setDuration(300L);
        view2.startAnimation(animation);
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
                    advertAppInfo = ((com.baidu.tieba.homepage.personalize.data.a) next).afP();
                } else {
                    if (next instanceof ac) {
                        ac acVar = (ac) next;
                        if (acVar.qM() instanceof AdvertAppInfo.ILegoAdvert) {
                            advertAppInfo = ((AdvertAppInfo.ILegoAdvert) acVar.qM()).getAdvertAppInfo();
                        }
                    }
                    advertAppInfo = advertAppInfo2;
                }
                if (advertAppInfo != null && str.equals(advertAppInfo.VL)) {
                    it.remove();
                    advertAppInfo = null;
                }
                advertAppInfo2 = advertAppInfo;
            }
        }
    }

    public FloatInfo axT() {
        return this.dFl;
    }
}
