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
import com.baidu.adp.widget.ListView.i;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.ab;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tbadk.util.h;
import com.baidu.tbadk.util.r;
import com.baidu.tbadk.util.s;
import com.baidu.tbadk.util.u;
import com.baidu.tieba.ala.LiveRoomClosedQueryMessage;
import com.baidu.tieba.d;
import com.baidu.tieba.e.a;
import com.baidu.tieba.frs.au;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import com.baidu.tieba.homepage.personalize.a.l;
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
public class f {
    private r bDj;
    private View.OnTouchListener bpk;
    private com.baidu.tieba.tbadkCore.data.e dEh;
    private m dGd;
    private com.baidu.tieba.e.a dVp;
    private boolean eea;
    private final l eiE;
    private final long eiW;
    private final c eiX;
    private DataRes.Builder eiZ;
    private ScrollFragmentTabHost eir;
    private int eiu;
    private au ejd;
    private final com.baidu.tieba.homepage.personalize.model.a eje;
    private int eji;
    private com.baidu.tieba.homepage.personalize.data.g ejk;
    private Runnable ejs;
    private final BdTypeListView mListView;
    private final com.baidu.adp.base.e<?> mPageContext;
    private a eiY = null;
    private final List<i> mDataList = new LinkedList();
    private int mPn = 1;
    private boolean mIsLoading = false;
    private boolean efL = false;
    private long eja = 0;
    private int ejb = 1;
    private int ejc = 0;
    private TextView aRY = null;
    private int dHz = 2000;
    private com.baidu.tbadk.k.f ejf = null;
    private boolean dFV = false;
    private int dFw = 0;
    private int bZw = 0;
    private boolean mIsBackground = false;
    private boolean ejg = true;
    private boolean ejh = false;
    private boolean ejj = false;
    private boolean ejl = true;
    private FloatInfo ejm = null;
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.f.12
        private int efQ = -1;
        private int efR = 0;
        private boolean efS = false;

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (f.this.ejf == null) {
                f.this.ejf = new com.baidu.tbadk.k.f();
                f.this.ejf.ij(1005);
                f.this.ejf.pageType = 1;
            }
            if (f.this.bDj != null && !f.this.mIsBackground) {
                f.this.bDj.onScrollStateChanged(absListView, i);
            }
            f.this.ejf.Oc();
            if (i == 0) {
                com.baidu.tieba.card.r.als().dk(true);
                if (this.efS) {
                    f.this.aCT();
                }
                this.efS = false;
                if (f.this.dGd != null && f.this.ejg) {
                    f.this.dGd.a(f.this.dFw, f.this.bZw, f.this.dFV, 1);
                }
            } else if (i == 1 && f.this.ejd != null) {
                f.this.ejd.hideTip();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (this.efR > i) {
                this.efS = true;
            }
            if (f.this.bDj != null && !f.this.mIsBackground) {
                f.this.bDj.a(absListView, this.efR, i, i2, i3);
            }
            this.efR = i;
            int i4 = (i + i2) - 1;
            if (!this.efS && this.efQ != i4) {
                this.efQ = i4;
                f.this.oM(this.efQ);
            }
            if (this.efS && this.efQ != i) {
                this.efQ = i;
                f.this.oM(this.efQ);
            }
            f.this.ejr = i;
            f.this.dFw = i;
            f.this.bZw = (i + i2) - 1;
        }
    };
    private View.OnTouchListener bDk = new View.OnTouchListener() { // from class: com.baidu.tieba.homepage.personalize.f.16
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (f.this.bpk != null) {
                f.this.bpk.onTouch(view, motionEvent);
            }
            if (f.this.dVp != null) {
                f.this.dVp.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private a.InterfaceC0143a cod = new a.InterfaceC0143a() { // from class: com.baidu.tieba.homepage.personalize.f.17
        @Override // com.baidu.tieba.e.a.InterfaceC0143a
        public void aY(int i, int i2) {
            f.this.dFV = true;
        }

        @Override // com.baidu.tieba.e.a.InterfaceC0143a
        public void aZ(int i, int i2) {
            f.this.dFV = false;
        }

        @Override // com.baidu.tieba.e.a.InterfaceC0143a
        public void ba(int i, int i2) {
        }
    };
    private View.OnClickListener ejn = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.f.18
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (f.this.ejd != null) {
                f.this.ejd.hideTip();
            }
            if (f.this.ejb == 1 && f.this.mListView != null) {
                f.this.mListView.setSelection(0);
                f.this.mListView.startPullRefresh();
            }
        }
    };
    private final CustomMessageListener ejo = new CustomMessageListener(2001399) { // from class: com.baidu.tieba.homepage.personalize.f.19
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (f.this.mListView != null) {
                f.this.dGd.aDZ();
                f.this.ejg = false;
                f.this.mListView.completePullRefreshPostDelayed(2000L);
                f.this.mListView.startPullRefresh();
            }
        }
    };
    private CustomMessageListener bdJ = new CustomMessageListener(2004004) { // from class: com.baidu.tieba.homepage.personalize.f.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            bd bdVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bd) && f.this.eiZ != null && v.D(f.this.eiZ.thread_list) != 0 && (bdVar = (bd) customResponsedMessage.getData()) != null && bdVar.zc() != null && bdVar.getId() != null && v.D(f.this.eiZ.thread_list) != 0) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < f.this.eiZ.thread_list.size()) {
                        ThreadInfo threadInfo = f.this.eiZ.thread_list.get(i2);
                        if (threadInfo == null || threadInfo.id.longValue() != com.baidu.adp.lib.g.b.c(bdVar.getId(), -1L)) {
                            i = i2 + 1;
                        } else {
                            ThreadInfo.Builder builder = new ThreadInfo.Builder(threadInfo);
                            Zan.Builder builder2 = new Zan.Builder(builder.zan);
                            builder2.num = Integer.valueOf((int) bdVar.zc().getNum());
                            builder.zan = builder2.build(true);
                            f.this.eiZ.thread_list.set(i2, builder.build(true));
                            return;
                        }
                    } else {
                        return;
                    }
                }
            }
        }
    };
    private CustomMessageListener ejp = new CustomMessageListener(2921026) { // from class: com.baidu.tieba.homepage.personalize.f.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            bd bdVar;
            if (customResponsedMessage.getOrginalMessage() instanceof LiveRoomClosedQueryMessage) {
                List<Long> ids = ((LiveRoomClosedQueryMessage) customResponsedMessage.getOrginalMessage()).getIds();
                List<Object> originData = ((LiveRoomClosedQueryMessage) customResponsedMessage.getOrginalMessage()).getOriginData();
                if (!v.E(f.this.mDataList) && !v.E(ids) && !v.E(originData)) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= originData.size()) {
                            break;
                        }
                        if ((originData.get(i2) instanceof bd) && (bdVar = (bd) originData.get(i2)) != null && bdVar.zG() != null && ids.contains(Long.valueOf(bdVar.zG().live_id))) {
                            f.this.mDataList.remove(bdVar);
                        }
                        i = i2 + 1;
                    }
                    if (f.this.eiE != null) {
                        f.this.eiE.ao(new ArrayList(f.this.mDataList));
                    }
                }
            }
        }
    };
    private CustomMessageListener mAttentionListener = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.homepage.personalize.f.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int intValue;
            if ((customResponsedMessage instanceof UpdateAttentionMessage) && f.this.eiZ != null && !v.E(f.this.eiZ.thread_list)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid)) {
                    for (int i = 0; i < f.this.eiZ.thread_list.size(); i++) {
                        ThreadInfo threadInfo = f.this.eiZ.thread_list.get(i);
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
                            f.this.eiZ.thread_list.set(i, builder.build(true));
                            return;
                        }
                    }
                }
            }
        }
    };
    private String ejq = "lastReadReadPositionKey";
    private int ejr = 0;
    private e ejt = new e() { // from class: com.baidu.tieba.homepage.personalize.f.7
        @Override // com.baidu.tieba.homepage.personalize.e
        public void oz(final int i) {
            if (f.this.ejs == null) {
                f.this.ejs = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.f.7.1
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
            f.this.mListView.removeCallbacks(f.this.ejs);
            f.this.mListView.post(f.this.ejs);
        }
    };
    private CustomMessageListener dTt = new CustomMessageListener(2016488) { // from class: com.baidu.tieba.homepage.personalize.f.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            f.this.h(customResponsedMessage);
        }
    };
    private CustomMessageListener dTu = new CustomMessageListener(2016553) { // from class: com.baidu.tieba.homepage.personalize.f.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            f.this.h(customResponsedMessage);
        }
    };
    private CustomMessageListener dTv = new CustomMessageListener(2016331) { // from class: com.baidu.tieba.homepage.personalize.f.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && f.this.eiZ != null && v.D(f.this.eiZ.thread_list) != 0) {
                String str = (String) customResponsedMessage.getData();
                f.this.f(str, f.this.mDataList);
                f.this.mE(str);
                if (f.this.eiE != null) {
                    f.this.eiE.ao(new ArrayList(f.this.mDataList));
                }
            }
        }
    };

    /* loaded from: classes2.dex */
    public interface a {
        void O(int i, int i2, int i3);

        void bM(int i, int i2);

        void onError(int i, String str);

        void onSuccess();
    }

    public void gO(boolean z) {
        this.ejl = z;
        if (this.ejd != null && !z) {
            this.ejd.hideTip();
        }
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.eir = scrollFragmentTabHost;
        if (this.eir != null) {
            this.eir.setOnTabSelectedListener(new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.personalize.f.1
                @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
                public void oK(int i) {
                    if (f.this.eir.oJ(i) != 1 && f.this.ejd != null) {
                        f.this.ejd.hideTip();
                    }
                }
            });
        }
    }

    public void setTabInForeBackgroundState(boolean z) {
        this.mIsBackground = z;
    }

    public void fS(boolean z) {
        this.mIsBackground = z;
        if (this.dGd != null) {
            this.dGd.iz(!z);
            if (z) {
                this.dGd.aDZ();
            } else if (this.ejg) {
                this.dGd.d(this.dFw, this.bZw, this.dFV, true);
            }
        }
    }

    public f(com.baidu.adp.base.e<?> eVar, BdTypeListView bdTypeListView, l lVar) {
        this.mPageContext = eVar;
        this.mListView = bdTypeListView;
        this.mListView.setOnTouchListener(this.bDk);
        this.dVp = new com.baidu.tieba.e.a();
        this.dVp.a(this.cod);
        this.eiE = lVar;
        this.eje = new com.baidu.tieba.homepage.personalize.model.a();
        this.eiW = com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("recommend_frs_cache_time", 43200L) * 1000;
        bdTypeListView.setOnScrollListener(this.mOnScrollListener);
        this.ejd = new au();
        aCU();
        this.dGd = new m(this.mPageContext, this.mListView);
        this.eiX = new c(this.mDataList, this.eiE);
    }

    private boolean aCM() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean(aCO(), true);
    }

    private void aCN() {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean(aCO(), false);
    }

    private String aCO() {
        return "key_rec_pfirst_load_" + TbadkCoreApplication.getCurrentAccount() + "_" + TbConfig.getVersion();
    }

    public void setHeaderViewHeight(int i) {
        this.eiu = i;
    }

    public void setRecommendFrsNavigationAnimDispatcher(s sVar) {
        if (sVar != null) {
            this.bDj = sVar.Pk();
            this.bpk = sVar.Pl();
        }
    }

    public void showFloatingView() {
        if (this.bDj != null) {
            this.bDj.cG(true);
        }
    }

    public void update() {
        if (com.baidu.tieba.homepage.framework.a.aCs().oy(1) == -1) {
            com.baidu.tieba.homepage.framework.a.aCs().h(System.currentTimeMillis(), 1);
        }
        this.mPn = 1;
        this.ejj = true;
        if (this.mDataList.size() == 0 && !this.efL && !aCM()) {
            aCm();
        } else {
            aCk();
        }
    }

    public void bN(int i, int i2) {
        bd bdVar;
        if (!v.E(this.mDataList) && this.mDataList.size() > i) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            while (i < this.mDataList.size() && i <= i2) {
                if (this.mDataList.get(i).getType().getId() == bd.aOn.getId() && (bdVar = (bd) this.mDataList.get(i)) != null && bdVar.zG() != null) {
                    arrayList.add(Long.valueOf(bdVar.zG().live_id));
                    arrayList2.add(bdVar);
                }
                i++;
            }
            if (!v.E(arrayList)) {
                MessageManager.getInstance().sendMessage(new LiveRoomClosedQueryMessage(arrayList, arrayList2));
            }
        }
    }

    public void aCP() {
        if (this.dGd != null && !this.mIsBackground && this.ejg) {
            this.dGd.d(this.dFw, this.bZw, this.dFV, true);
        }
        if (this.ejh) {
            if (this.eea) {
                if (gP(false)) {
                    bO(3, this.ejc);
                } else if (this.eji > 0) {
                    bO(2, this.ejc);
                }
            } else if (!this.eea && this.ejc == 0) {
                bO(2, 0);
            }
            com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("recommend_frs_refresh_time", System.currentTimeMillis());
            this.ejh = false;
            this.eea = false;
            this.eji = 0;
            if (this.ejj) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
            }
            this.ejj = false;
        }
    }

    public void WN() {
        if (!Ek() && this.eiY != null) {
            aCR();
            this.mPn++;
            setIsLoading(true);
            this.eiY.O(this.mPn, (this.eiZ == null || this.eiZ.thread_list == null) ? 0 : this.eiZ.thread_list.size(), 0);
        }
    }

    public void a(boolean z, boolean z2, DataRes dataRes, int i, String str) {
        setIsLoading(false);
        this.mListView.completePullRefreshPostDelayed(2000L);
        if (z) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("recommend_frs_guide_time", System.currentTimeMillis());
        }
        int size = (this.eiZ == null || this.eiZ.thread_list == null) ? 0 : this.eiZ.thread_list.size();
        if (i != 0 || dataRes == null || !a(true, z, z2, dataRes)) {
            this.ejh = false;
            if (this.mDataList.size() > 0) {
                if (this.eiY != null) {
                    this.eiY.onError(1, str);
                    return;
                }
                return;
            } else if (this.eiY != null) {
                this.eiY.onError(2, str);
                return;
            } else {
                return;
            }
        }
        aCN();
        if (this.eiY != null) {
            this.eiY.onSuccess();
        }
        this.ejh = true;
        this.eea = z;
        this.eji = size;
        aCn();
    }

    public void gJ(boolean z) {
        if (z) {
            this.eiE.notifyDataSetChanged();
        }
        if (!aCQ()) {
            aCT();
        }
    }

    public void onDestroy() {
        if (this.dGd != null) {
            this.dGd.destroy();
        }
        if (this.ejf != null) {
            this.ejf.onDestroy();
        }
        if (this.ejd != null) {
            this.ejd.onDestroy();
        }
        if (this.eiX != null) {
            this.eiX.onDestroy();
        }
        if (this.mListView != null) {
            this.mListView.removeCallbacks(this.ejs);
        }
    }

    public void onPause() {
        oN(this.ejr);
        oL(2016319);
    }

    public void onResume() {
        oL(2016318);
    }

    private void oL(final int i) {
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(i);
        final BdUniqueId uniqueId = this.mPageContext.getUniqueId();
        customResponsedMessage.setOrginalMessage(new CustomMessage<Object>(i, uniqueId) { // from class: com.baidu.tieba.homepage.personalize.PersonalizedUpdateController$7
        });
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
    }

    public boolean aCQ() {
        if (gP(false)) {
            if (this.mListView != null) {
                this.mListView.setSelection(0);
                this.mListView.startPullRefresh();
            }
            return true;
        }
        return false;
    }

    private void aCk() {
        if (this.eiY != null) {
            this.eiY.bM((this.eiZ == null || this.eiZ.thread_list == null || aCS()) ? 0 : this.eiZ.thread_list.size(), 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(DataRes dataRes) {
        this.efL = true;
        if (dataRes != null) {
            if (a(false, true, true, dataRes) && !aCS()) {
                if (this.eiY != null) {
                    this.eiY.onSuccess();
                }
                aCT();
                return;
            }
            aCk();
            return;
        }
        aCk();
    }

    private void bM(List<i> list) {
        if (!v.E(list)) {
            for (i iVar : list) {
                if (iVar instanceof com.baidu.tieba.card.data.d) {
                    com.baidu.tieba.card.data.d dVar = (com.baidu.tieba.card.data.d) iVar;
                    if (dVar.alG() != null) {
                        dVar.alG().advertAppContext = new com.baidu.tbadk.core.data.b();
                        dVar.alG().advertAppContext.aJX = "NEWINDEX";
                        dVar.alG().advertAppContext.pn = 1;
                        dVar.alG().advertAppContext.extensionInfo = dVar.alG().extensionInfo;
                        dVar.alG().advertAppContext.aKc = false;
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
        this.eja = dataRes.sug_seconds.intValue() * 1000;
        if (z2 && aCS()) {
            this.eiZ = null;
        }
        int size = z2 ? 0 : this.mDataList.size();
        DataRes.Builder builder = new DataRes.Builder(dataRes);
        this.mDataList.clear();
        com.baidu.tieba.homepage.personalize.model.c a2 = this.eje.a(z, this.eiZ, builder, z2 ? 0 : 1);
        if (a2 == null) {
            list = null;
        } else {
            List<i> list2 = a2.bND;
            this.ejc = a2.ekx;
            list = list2;
        }
        if (list != null) {
            this.mDataList.addAll(list);
            bM(list);
            a(z2 ? 0 : 1, list, size);
            if (this.ejj) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
            }
        }
        if (this.eiZ == null) {
            this.eiZ = builder;
            this.eiX.bK(this.eiZ.thread_list);
        }
        if (this.mDataList.size() == 0) {
            z4 = false;
        } else {
            if (z2) {
                if (dataRes.live_answer != null) {
                    this.ejk = new com.baidu.tieba.homepage.personalize.data.g();
                    this.ejk.a(dataRes.live_answer);
                    this.eiZ.live_answer = dataRes.live_answer;
                } else if (z) {
                    this.ejk = null;
                    this.eiZ.live_answer = null;
                }
                this.ejm = dataRes.float_info;
                this.eiZ.float_info = dataRes.float_info;
            }
            if (this.ejk != null) {
                this.mDataList.add(0, this.ejk);
            }
            LinkedList linkedList = new LinkedList(this.mDataList);
            this.eiE.setFromCDN(dataRes.is_new_url.intValue() == 1);
            this.eiE.ao(linkedList);
            z4 = true;
            if (this.dGd != null && this.ejg) {
                this.dGd.d(this.dFw, this.bZw, this.dFV, true);
            }
        }
        com.baidu.tieba.homepage.framework.a.aCs().f(System.currentTimeMillis() - currentTimeMillis, 1);
        long oy = com.baidu.tieba.homepage.framework.a.aCs().oy(1);
        if (oy > 0) {
            com.baidu.tieba.homepage.framework.a.aCs().g(System.currentTimeMillis() - oy, 1);
            com.baidu.tieba.homepage.framework.a.aCs().h(0L, 1);
        }
        if (dataRes != null && dataRes.anti != null && dataRes.anti.block_pop_info != null) {
            com.baidu.tieba.p.a.d(dataRes.anti.block_pop_info);
            return z4;
        }
        return z4;
    }

    private void aCR() {
        if (v.D(this.mDataList) >= this.eje.aDd() - 40) {
            com.baidu.tieba.homepage.personalize.model.c a2 = this.eje.a(true, this.eiZ, (DataRes.Builder) null, 1);
            List<i> list = a2 != null ? a2.bND : null;
            if (list != null) {
                this.mDataList.clear();
                this.mDataList.addAll(list);
                this.eiE.ao(new LinkedList(this.mDataList));
            }
        }
    }

    private void aCm() {
        com.baidu.tbadk.util.v.a(new u<DataRes>() { // from class: com.baidu.tieba.homepage.personalize.f.20
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.u
            /* renamed from: aCY */
            public DataRes doInBackground() {
                com.baidu.adp.lib.cache.l<byte[]> M = com.baidu.tbadk.core.c.a.AQ().M("tb.rec_frs_update", TbadkCoreApplication.getCurrentAccount());
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
        }, new h<DataRes>() { // from class: com.baidu.tieba.homepage.personalize.f.21
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.h
            /* renamed from: b */
            public void onReturnDataInUI(DataRes dataRes) {
                f.this.a(dataRes);
            }
        });
    }

    private void aCn() {
        if (this.eiZ != null) {
            DataRes.Builder builder = new DataRes.Builder(this.eiZ.build(true));
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
    public void mE(String str) {
        if (!TextUtils.isEmpty(str) && this.eiZ != null && this.eiZ.banner_list != null && this.eiZ.banner_list.app != null && this.eiZ.banner_list.app.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (App app : this.eiZ.banner_list.app) {
                if (app != null && str.equals(app.id)) {
                    arrayList.add(app);
                }
            }
            BannerList.Builder builder = new BannerList.Builder(this.eiZ.banner_list);
            if (builder.app != null) {
                builder.app.removeAll(arrayList);
            }
            this.eiZ.banner_list = builder.build(false);
            DataRes.Builder builder2 = new DataRes.Builder(this.eiZ.build(true));
            builder2.banner_list = builder.build(true);
            a(builder2);
        }
    }

    private void a(final DataRes.Builder builder) {
        com.baidu.tbadk.util.v.a(new u<Object>() { // from class: com.baidu.tieba.homepage.personalize.f.2
            @Override // com.baidu.tbadk.util.u
            public Object doInBackground() {
                DataRes.Builder builder2 = new DataRes.Builder(builder.build(true));
                f.this.eiX.bL(builder2.thread_list);
                try {
                    com.baidu.tbadk.core.c.a.AQ().M("tb.rec_frs_update", TbadkCoreApplication.getCurrentAccount()).e("0", builder2.build(true).toByteArray());
                    return null;
                } catch (Exception e) {
                    BdLog.e(e);
                    return null;
                }
            }
        }, null);
    }

    private boolean aCS() {
        return gP(true);
    }

    private boolean gP(boolean z) {
        long j = com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("recommend_frs_refresh_time", 0L);
        return j == 0 ? z : Math.abs(System.currentTimeMillis() - j) > this.eiW;
    }

    public void a(a aVar) {
        this.eiY = aVar;
    }

    private boolean Ek() {
        return this.mIsLoading;
    }

    private void setIsLoading(boolean z) {
        this.mIsLoading = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aCT() {
        long j = com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("recommend_frs_guide_time", 0L);
        if (this.eja != 0) {
            if (j == 0 || Math.abs(System.currentTimeMillis() - j) > this.eja) {
                bO(1, 0);
            }
        }
    }

    public void aCI() {
        boolean z = true;
        com.baidu.tbadk.coreExtra.data.a activityPrizeData = TbadkCoreApplication.getInst().getActivityPrizeData();
        if (activityPrizeData.Fh() && !StringUtils.isNull(activityPrizeData.Fp())) {
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
                    bO(4, 0);
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putString("activity_prize_feed_text_time", str);
                }
            }
        }
    }

    private void bO(int i, int i2) {
        FrameLayout.LayoutParams layoutParams;
        if (this.eir != null) {
            this.ejd.awu();
        }
        if (this.eir != null && this.eir.getCurrentTabType() != 1) {
            this.ejd.hideTip();
        } else if (!this.ejl) {
            this.ejd.hideTip();
        } else {
            this.ejb = i;
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
                str = TbadkCoreApplication.getInst().getActivityPrizeData().Fp();
            }
            if (!TextUtils.isEmpty(str)) {
                if (this.aRY == null) {
                    this.aRY = new TextView(this.mPageContext.getPageActivity());
                    this.aRY.setGravity(17);
                    this.aRY.setOnClickListener(this.ejn);
                }
                this.ejd.awu();
                FrameLayout frameLayout = this.eir.getFrameLayout();
                if (frameLayout != null && this.aRY.getParent() == null) {
                    if (i == 1) {
                        if (j.oJ()) {
                            int dimensionPixelSize = this.mPageContext.getResources().getDimensionPixelSize(d.e.ds20);
                            int dimensionPixelSize2 = this.mPageContext.getResources().getDimensionPixelSize(d.e.ds40);
                            this.aRY.setPadding(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
                            this.aRY.setTextSize(0, this.mPageContext.getResources().getDimensionPixelSize(d.e.fontsize28));
                            com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("recommend_frs_guide_time", System.currentTimeMillis());
                            aj.s(this.aRY, d.f.bg_home_float);
                            aj.r(this.aRY, d.C0141d.cp_link_tip_a);
                            layoutParams = new FrameLayout.LayoutParams(-2, -2);
                            layoutParams.gravity = 49;
                            layoutParams.topMargin = this.eiu;
                        } else {
                            return;
                        }
                    } else {
                        this.aRY.setPadding(0, 0, 0, 0);
                        this.aRY.setTextSize(0, this.mPageContext.getResources().getDimensionPixelSize(d.e.fontsize24));
                        aj.s(this.aRY, d.C0141d.common_color_10260);
                        aj.r(this.aRY, d.C0141d.cp_cont_g);
                        layoutParams = new FrameLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.t(TbadkCoreApplication.getInst(), d.e.ds56));
                        layoutParams.gravity = 49;
                        layoutParams.topMargin = this.eiu;
                    }
                    this.aRY.setText(str);
                    if (i == 1) {
                        this.dHz = 4000;
                    } else if (i == 4) {
                        this.dHz = PushConstants.WORK_RECEIVER_EVENTCORE_ERROR;
                    } else {
                        this.dHz = 2000;
                    }
                    this.ejd.a(this.aRY, frameLayout, layoutParams, this.dHz);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(Long l) {
        if (this.eiZ != null && this.eiZ.thread_list != null) {
            List<ThreadInfo> list = this.eiZ.thread_list;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                ThreadInfo threadInfo = list.get(i);
                if (threadInfo.tid.equals(l) && threadInfo.top_agree_post != null) {
                    ThreadInfo.Builder builder = new ThreadInfo.Builder(threadInfo);
                    builder.top_agree_post = null;
                    list.set(i, builder.build(true));
                    aCn();
                    a(false, true, false, this.eiZ.build(true));
                    return;
                }
            }
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            if (this.bdJ != null) {
                this.bdJ.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.bdJ);
            }
            if (this.ejo != null) {
                this.ejo.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.ejo);
            }
            this.mAttentionListener.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.mAttentionListener);
            this.ejp.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.ejp);
            this.dTt.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.dTt);
            this.dTu.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.dTu);
            this.dTv.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.dTv);
            if (this.dGd != null) {
                this.dGd.setUniqueId(bdUniqueId);
            }
            this.eiX.h(bdUniqueId);
        }
    }

    public void aCU() {
        this.dEh = new com.baidu.tieba.tbadkCore.data.e("new_index", null);
        this.dEh.bwv();
    }

    public void a(int i, List<i> list, int i2) {
        int i3;
        int i4;
        if (this.dEh != null) {
            if (i == 0) {
                this.dEh.bwv();
            }
            if (list != null && !list.isEmpty()) {
                int[] iArr = com.baidu.tieba.tbadkCore.data.e.hac;
                int i5 = 0;
                int i6 = 0;
                int i7 = 0;
                while (i7 < list.size() && i6 < iArr.length && (i3 = iArr[i6]) >= 0) {
                    if (list.get(i7) instanceof com.baidu.tieba.card.data.c) {
                        i4 = i5 + 1;
                        if (i4 == i3 - 1) {
                            if (i2 < i7 + 1) {
                                this.dEh.cG(i3, i7 + 1);
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

    public void oM(int i) {
        if ((this.dEh != null ? this.dEh.vJ(i) : -1) >= 0 && this.mListView != null && this.mListView.getData() != null && this.mListView.getData().size() > i) {
            this.dEh.vK(i);
        }
    }

    public m avD() {
        return this.dGd;
    }

    public void gQ(boolean z) {
        this.ejg = z;
    }

    public void oN(final int i) {
        com.baidu.tbadk.util.v.a(new u<Object>() { // from class: com.baidu.tieba.homepage.personalize.f.6
            @Override // com.baidu.tbadk.util.u
            public Object doInBackground() {
                com.baidu.adp.lib.cache.l<String> N = com.baidu.tbadk.core.c.a.AQ().N(f.this.ejq, TbadkCoreApplication.getCurrentAccount());
                if (N != null) {
                    N.a(f.this.ejq, Integer.toString(i), 43200000L);
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
            /* renamed from: aCX */
            public String doInBackground() {
                com.baidu.adp.lib.cache.l<String> N = com.baidu.tbadk.core.c.a.AQ().N(f.this.ejq, TbadkCoreApplication.getCurrentAccount());
                if (N != null) {
                    return N.get(f.this.ejq);
                }
                return null;
            }
        }, new h<String>() { // from class: com.baidu.tieba.homepage.personalize.f.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.h
            /* renamed from: mF */
            public void onReturnDataInUI(String str) {
                if (eVar != null) {
                    eVar.oz(com.baidu.adp.lib.g.b.h(str, 0));
                }
            }
        });
    }

    public void aCV() {
        a(this.ejt);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(CustomResponsedMessage<?> customResponsedMessage) {
        String str;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.eiZ != null && v.D(this.eiZ.thread_list) != 0 && v.D(this.mDataList) != 0) {
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
                        if (item instanceof com.baidu.tieba.card.data.j) {
                            com.baidu.tieba.card.data.j jVar = (com.baidu.tieba.card.data.j) item;
                            if (jVar.WD() != null && jVar.WD().zG() != null && optString2.equals(String.valueOf(jVar.WD().zG().live_id))) {
                                str = jVar.WD().getTid();
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
                        bV(childAt);
                    } else if (this.eiE != null) {
                        this.eiE.ao(new ArrayList(this.mDataList));
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
                    if (cVar.WD() != null && cVar.WD().getTid() != null && cVar.WD().getTid().equals(optString)) {
                        it.remove();
                        com.baidu.tieba.homepage.personalize.model.b.bO(this.mDataList);
                        break;
                    }
                }
            }
            if (this.eiZ != null && this.eiZ.thread_list != null) {
                long c = com.baidu.adp.lib.g.b.c(optString, 0L);
                for (int i2 = 0; i2 < this.eiZ.thread_list.size(); i2++) {
                    ThreadInfo threadInfo = this.eiZ.thread_list.get(i2);
                    if (threadInfo != null && threadInfo.tid != null && threadInfo.tid.longValue() == c) {
                        this.eiZ.thread_list.remove(i2);
                        aCn();
                        com.baidu.tieba.homepage.personalize.b.d.a(threadInfo.tid.longValue(), i2, this.eiZ.thread_list, this.mDataList);
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
                    if (cVar.WD() != null && cVar.WD().getTid().equals(str)) {
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

    private void bV(final View view) {
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
                if (f.this.eiE != null) {
                    f.this.eiE.ao(new ArrayList(f.this.mDataList));
                }
            }
        });
        animation.setDuration(300L);
        view.startAnimation(animation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(String str, List<i> list) {
        AdvertAppInfo advertAppInfo;
        if (list != null && list.size() > 0 && !TextUtils.isEmpty(str)) {
            Iterator<i> it = list.iterator();
            AdvertAppInfo advertAppInfo2 = null;
            while (it.hasNext()) {
                i next = it.next();
                if (next instanceof com.baidu.tieba.homepage.personalize.data.a) {
                    advertAppInfo = ((com.baidu.tieba.homepage.personalize.data.a) next).alG();
                } else {
                    if (next instanceof ab) {
                        ab abVar = (ab) next;
                        if (abVar.yh() instanceof AdvertAppInfo.ILegoAdvert) {
                            advertAppInfo = ((AdvertAppInfo.ILegoAdvert) abVar.yh()).getAdvertAppInfo();
                        }
                    }
                    advertAppInfo = advertAppInfo2;
                }
                if (advertAppInfo != null && str.equals(advertAppInfo.aKu)) {
                    it.remove();
                    advertAppInfo = null;
                }
                advertAppInfo2 = advertAppInfo;
            }
        }
    }

    public FloatInfo aCW() {
        return this.ejm;
    }
}
