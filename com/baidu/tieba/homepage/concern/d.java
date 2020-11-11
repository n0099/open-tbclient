package com.baidu.tieba.homepage.concern;

import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.e;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tbadk.util.aa;
import com.baidu.tbadk.util.ab;
import com.baidu.tbadk.util.ad;
import com.baidu.tbadk.util.ae;
import com.baidu.tbadk.util.m;
import com.baidu.tieba.R;
import com.baidu.tieba.card.t;
import com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout;
import com.squareup.wire.Wire;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;
import tbclient.DiscoverHotForum;
import tbclient.ThreadInfo;
import tbclient.Userlike.ConcernData;
import tbclient.Userlike.DataRes;
/* loaded from: classes22.dex */
public class d {
    private View.OnTouchListener fkL;
    private aa fza;
    private boolean hasMore;
    private final BdTypeRecyclerView iNq;
    private com.baidu.tieba.f.a jiW;
    private BigdaySwipeRefreshLayout jvC;
    private DataRes.Builder jvK;
    private DataRes.Builder jvL;
    private DataRes.Builder jvM;
    private final com.baidu.tieba.homepage.concern.a jvP;
    private final com.baidu.tieba.homepage.concern.b.a jvQ;
    private int jvR;
    private String pageTag;
    private a jvI = null;
    private final LinkedList<q> jvJ = new LinkedList<>();
    private boolean mIsLoading = false;
    private boolean jvN = false;
    private boolean jvO = false;
    private boolean mIsBackground = false;
    private CustomMessageListener eNv = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.homepage.concern.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (data.feD == null) {
                    if (!data.isSucc) {
                        BdToast.a(TbadkCoreApplication.getInst().getContext(), updateAttentionMessage.getData().errorString, R.drawable.icon_pure_toast_mistake40_svg, 3000, true).bpi();
                    } else if (!data.isAttention) {
                        Iterator it = d.this.jvJ.iterator();
                        while (it.hasNext()) {
                            Object next = it.next();
                            if ((next instanceof com.baidu.tieba.card.data.c) && ay.h(((com.baidu.tieba.card.data.c) next).bjZ(), data.toUid)) {
                                it.remove();
                            }
                        }
                        if (d.this.jvJ.size() < 9) {
                            d.this.bjQ();
                            return;
                        }
                        d.this.setList(d.this.jvJ);
                        d.this.jvP.notifyDataSetChanged();
                        if (d.this.jvI != null) {
                            d.this.jvI.af(false, false);
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener jvS = new CustomMessageListener(0) { // from class: com.baidu.tieba.homepage.concern.d.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long) && d.this.jvK != null && d.this.jvK.hot_recomforum != null && !y.isEmpty(d.this.jvK.hot_recomforum.tab_list)) {
                long longValue = ((Long) customResponsedMessage.getData()).longValue();
                DiscoverHotForum.Builder builder = new DiscoverHotForum.Builder(d.this.jvK.hot_recomforum);
                if (c.a(builder, longValue, customResponsedMessage.getCmd() == 2001335)) {
                    d.this.jvK.hot_recomforum = builder.build(true);
                    d.this.a(new DataRes.Builder(d.this.jvK.build(true)));
                }
            }
        }
    };
    RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.concern.d.6
        private int jvW = 0;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (d.this.fza != null && !d.this.mIsBackground) {
                d.this.fza.m(recyclerView, i);
            }
            if (i == 0) {
                t.cor().bMp();
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            int i3;
            int i4 = 0;
            if (recyclerView == null || !(recyclerView instanceof BdRecyclerView)) {
                i3 = 0;
            } else {
                i3 = ((BdRecyclerView) recyclerView).getFirstVisiblePosition();
                i4 = ((BdRecyclerView) recyclerView).getLastVisiblePosition();
            }
            onScroll(i3, (i4 - i3) + 1);
        }

        public void onScroll(int i, int i2) {
            if (d.this.fza != null && !d.this.mIsBackground) {
                d.this.fza.onScroll(this.jvW, i);
            }
            this.jvW = i;
        }
    };
    private View.OnTouchListener fzb = new View.OnTouchListener() { // from class: com.baidu.tieba.homepage.concern.d.7
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (d.this.fkL != null) {
                d.this.fkL.onTouch(view, motionEvent);
            }
            if (d.this.jiW != null) {
                d.this.jiW.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private CustomMessageListener jvT = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.homepage.concern.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.this.g(customResponsedMessage);
        }
    };
    private CustomMessageListener iqd = new CustomMessageListener(CmdConfigCustom.CMD_THREAD_NOT_EXIST_WHEN_ENTER_PB) { // from class: com.baidu.tieba.homepage.concern.d.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.this.g(customResponsedMessage);
        }
    };
    private CustomMessageListener jvU = new CustomMessageListener(2921425) { // from class: com.baidu.tieba.homepage.concern.d.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.this.cIO();
        }
    };

    /* loaded from: classes22.dex */
    public interface a {
        void LA(String str);

        void af(boolean z, boolean z2);

        void cII();

        void cIJ();

        void onError(int i, String str);
    }

    public void setTabInForeBackgroundState(boolean z) {
        this.mIsBackground = z;
    }

    public void pF(boolean z) {
        this.mIsBackground = z;
    }

    public d(e<?> eVar, BdTypeRecyclerView bdTypeRecyclerView, com.baidu.tieba.homepage.concern.a aVar, BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout) {
        this.iNq = bdTypeRecyclerView;
        this.iNq.setOnTouchListener(this.fzb);
        this.jiW = new com.baidu.tieba.f.a();
        this.jvQ = new com.baidu.tieba.homepage.concern.b.a();
        this.jvP = aVar;
        bdTypeRecyclerView.setOnScrollListener(this.mOnScrollListener);
        this.jvC = bigdaySwipeRefreshLayout;
        qN(false);
    }

    public void s(BdUniqueId bdUniqueId) {
        this.jvT.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.jvT);
        this.iqd.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.iqd);
        this.jvU.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.jvU);
        this.eNv.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.eNv);
        this.jvS.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_LIKE_FORUM, this.jvS);
        MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_UNLIKE_FORUM, this.jvS);
    }

    public void setRecommendFrsNavigationAnimDispatcher(ab abVar) {
        if (abVar != null) {
            this.fza = abVar.bDS();
            this.fkL = abVar.bDT();
        }
    }

    public void update() {
        if (cIP() && !this.jvN) {
            bjR();
        } else {
            bjQ();
        }
    }

    public void cIK() {
        this.jvL = new DataRes.Builder(this.jvK.build(true));
    }

    public void cIL() {
        this.jvK = new DataRes.Builder(this.jvL.build(true));
    }

    public void cIM() {
        bjQ();
    }

    public void bOI() {
        if (!isLoading() && this.hasMore && this.jvI != null) {
            setIsLoading(true);
            this.jvI.LA(this.pageTag);
        }
    }

    public void a(boolean z, DataRes dataRes, int i, String str) {
        setIsLoading(false);
        if (i != 0 || dataRes == null || !a(true, z, dataRes)) {
            if (i == 0 && y.getCount(this.jvJ) == 0 && this.jvI != null) {
                this.jvI.cIJ();
                if (this.jvC != null) {
                    this.jvC.setRefreshing(false);
                    return;
                }
                return;
            } else if (this.jvJ.size() > 0) {
                if (this.jvI != null) {
                    this.jvI.onError(1, str);
                }
            } else if (this.jvI != null) {
                this.jvI.onError(2, str);
            }
        } else {
            if (this.jvI != null) {
                this.jvI.af(z, false);
            }
            if (z) {
                crz();
            }
        }
        if (this.jvC != null) {
            this.jvC.setRefreshing(false);
        }
    }

    public void qM(boolean z) {
        if (z) {
            this.jvP.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bjQ() {
        if (this.jvI != null) {
            this.jvI.cII();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(DataRes dataRes) {
        this.jvN = true;
        qN(true);
        if (dataRes != null) {
            if (a(false, true, dataRes)) {
                if (this.jvI != null) {
                    this.jvI.af(false, true);
                    return;
                }
                return;
            }
            bjQ();
            return;
        }
        bjQ();
    }

    private List<q> a(boolean z, DataRes.Builder builder, boolean z2) {
        if (this.jvK == null) {
            this.jvK = new DataRes.Builder();
        }
        if (builder == null) {
            builder = new DataRes.Builder();
        }
        com.baidu.tieba.homepage.personalize.model.c a2 = this.jvQ.a(z, this.jvK, builder, z2 ? 0 : 1);
        if (a2 == null) {
            return null;
        }
        return a2.fNQ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setList(List<q> list) {
        this.jvP.cr(list);
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x00ad  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean a(boolean z, boolean z2, DataRes dataRes) {
        q qVar;
        boolean z3;
        if (dataRes == null) {
            return false;
        }
        this.pageTag = dataRes.page_tag;
        this.jvM = new DataRes.Builder(dataRes);
        if (cIP()) {
            LC(this.pageTag);
        }
        LinkedList linkedList = new LinkedList();
        DataRes.Builder builder = new DataRes.Builder(dataRes);
        this.jvR = builder.user_tips_type.intValue();
        if (dataRes.req_unix != null) {
            com.baidu.tbadk.core.sharedPref.b.bqh().putLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(SharedPrefConfig.CONCERN_DATA_RES_REQUEST_TIME), dataRes.req_unix.longValue());
        }
        List<q> a2 = a(z, builder, z2);
        this.jvO = false;
        if (a2 != null && TbadkCoreApplication.isLogin()) {
            if (3 == this.jvR) {
                if (y.isEmpty(a2)) {
                    a2.add(new com.baidu.tieba.homepage.concern.a.a());
                    this.jvO = true;
                } else if (y.getCount(a2) == 1 && (y.getItem(a2, 0) instanceof com.baidu.tieba.homepage.concern.a.b)) {
                    a2.add(new com.baidu.tieba.homepage.concern.a.a());
                    this.jvO = true;
                }
            }
            linkedList.addAll(a2);
        }
        if (!at.isEmpty(builder.user_tips) && 2 == this.jvR) {
            com.baidu.tieba.homepage.concern.a.c cVar = new com.baidu.tieba.homepage.concern.a.c();
            cVar.jwV = builder.user_tips_type.intValue();
            cVar.tipString = builder.user_tips;
            if (builder.user_tips_type.intValue() == 4) {
                cVar.jwW = true;
            } else {
                cVar.jwX = true;
            }
            if (cIP() && (cVar.jwV == 2 || cVar.jwV == 3)) {
                if (linkedList.size() > 0) {
                    cVar.jwV = 0;
                    z3 = false;
                    if (z3) {
                        linkedList.add(cVar);
                    }
                } else {
                    cVar.tipString = TbadkCoreApplication.getInst().getString(R.string.concern_no_data_title);
                }
            }
            z3 = true;
            if (z3) {
            }
        }
        this.hasMore = builder.has_more.intValue() == 1;
        if (y.isEmpty(linkedList)) {
            if (this.jvJ.isEmpty()) {
                return false;
            }
            Iterator<q> it = this.jvJ.iterator();
            while (true) {
                if (!it.hasNext()) {
                    qVar = null;
                    break;
                }
                qVar = it.next();
                if (qVar instanceof com.baidu.tbadk.data.a) {
                    break;
                }
            }
            if (qVar != null) {
                this.jvJ.remove(qVar);
            }
            this.jvP.cr(this.jvJ);
            return false;
        }
        this.jvJ.clear();
        this.jvJ.addAll(linkedList);
        if (z2) {
            this.jvK.page_tag = dataRes.page_tag;
            this.jvK.has_more = dataRes.has_more;
            this.jvK.user_list = dataRes.user_list;
            this.jvK.user_tips_type = dataRes.user_tips_type;
            this.jvK.user_tips = dataRes.user_tips;
            this.jvK.last_tips = dataRes.last_tips;
        }
        this.jvK.banner_user_story = dataRes.banner_user_story;
        this.jvK.banner_follow_live = dataRes.banner_follow_live;
        this.jvK.hot_recomforum = dataRes.hot_recomforum;
        this.jvK.top_tips = dataRes.top_tips;
        this.jvK.top_user_info = dataRes.top_user_info;
        if (this.jvR == 2 || this.jvR == 3) {
            this.jvK.user_tips_type = dataRes.user_tips_type;
            this.jvK.user_tips = dataRes.user_tips;
        }
        this.jvP.cr(this.jvJ);
        return true;
    }

    private void bjR() {
        long currentTimeMillis = System.currentTimeMillis();
        long cIS = cIS();
        long j = currentTimeMillis - cIS;
        if (cIS == 0 || j > 86400000) {
            ae.a(new ad<DataRes>() { // from class: com.baidu.tieba.homepage.concern.d.8
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.ad
                /* renamed from: cIU */
                public DataRes doInBackground() {
                    com.baidu.tbadk.core.c.a.boX().clearByteCacheWithSapce("tb.concern_page_all", TbadkCoreApplication.getCurrentAccount());
                    return null;
                }
            }, new m<DataRes>() { // from class: com.baidu.tieba.homepage.concern.d.9
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.m
                /* renamed from: b */
                public void onReturnDataInUI(DataRes dataRes) {
                    d.this.a((DataRes) null);
                }
            });
        } else {
            ae.a(new ad<DataRes>() { // from class: com.baidu.tieba.homepage.concern.d.10
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.ad
                /* renamed from: cIU */
                public DataRes doInBackground() {
                    l<byte[]> dH = com.baidu.tbadk.core.c.a.boX().dH("tb.concern_page_all", TbadkCoreApplication.getCurrentAccount());
                    if (dH == null) {
                        return null;
                    }
                    byte[] bArr = dH.get("0");
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
            }, new m<DataRes>() { // from class: com.baidu.tieba.homepage.concern.d.11
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.m
                /* renamed from: b */
                public void onReturnDataInUI(DataRes dataRes) {
                    d.this.a(dataRes);
                }
            });
        }
    }

    private void crz() {
        if (this.jvM != null) {
            a(this.jvM);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final DataRes.Builder builder) {
        if (cIP()) {
            ae.a(new ad<Object>() { // from class: com.baidu.tieba.homepage.concern.d.12
                @Override // com.baidu.tbadk.util.ad
                public Object doInBackground() {
                    DataRes.Builder builder2 = new DataRes.Builder(builder.build(true));
                    l<byte[]> dH = com.baidu.tbadk.core.c.a.boX().dH("tb.concern_page_all", TbadkCoreApplication.getCurrentAccount());
                    try {
                        DataRes build = builder2.build(true);
                        if (build != null && !y.isEmpty(build.thread_info)) {
                            dH.setForever("0", build.toByteArray());
                            d.LD(d.this.pageTag);
                            d.fP(System.currentTimeMillis());
                        }
                    } catch (Exception e) {
                        BdLog.e(e);
                    }
                    return null;
                }
            }, null);
        }
    }

    public void a(a aVar) {
        this.jvI = aVar;
    }

    private boolean isLoading() {
        return this.mIsLoading;
    }

    private void setIsLoading(boolean z) {
        this.mIsLoading = z;
    }

    public boolean hasMore() {
        return this.hasMore;
    }

    public boolean cIN() {
        return this.jvO;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(CustomResponsedMessage<?> customResponsedMessage) {
        ThreadInfo threadInfo;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.jvK != null && y.getCount(this.jvK.thread_info) != 0 && y.getCount(this.jvJ) != 0) {
            String optString = ((JSONObject) customResponsedMessage.getData()).optString("tid");
            if (!StringUtils.isNull(optString)) {
                Iterator<q> it = this.jvJ.iterator();
                boolean z = false;
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    q next = it.next();
                    if (next instanceof com.baidu.tieba.card.data.c) {
                        com.baidu.tieba.card.data.c cVar = (com.baidu.tieba.card.data.c) next;
                        if (cVar.bjZ() != null && cVar.bjZ().getTid() != null) {
                            if (cVar.bjZ().getTid().equals(optString)) {
                                z = true;
                                it.remove();
                            } else if (z) {
                                if (this.jvP != null) {
                                    this.jvP.cr(this.jvJ);
                                }
                            }
                        }
                    }
                    z = z;
                }
                long j = com.baidu.adp.lib.f.b.toLong(optString, 0L);
                for (int i = 0; i < this.jvK.thread_info.size(); i++) {
                    ConcernData concernData = this.jvK.thread_info.get(i);
                    if (concernData != null && (threadInfo = concernData.thread_list) != null && threadInfo.tid != null && threadInfo.tid.longValue() == j) {
                        this.jvK.thread_info.remove(i);
                        crz();
                        return;
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cIO() {
        if (this.jvK != null && y.getCount(this.jvK.thread_info) != 0 && y.getCount(this.jvJ) != 0) {
            int i = 0;
            while (true) {
                if (i >= this.jvJ.size()) {
                    break;
                } else if (!(this.jvJ.get(i) instanceof com.baidu.tieba.homepage.concern.a.b)) {
                    i++;
                } else {
                    this.jvJ.remove(i);
                    if (this.jvP != null) {
                        this.jvP.cr(this.jvJ);
                    }
                }
            }
            for (int i2 = 0; i2 < this.jvK.thread_info.size(); i2++) {
                if (com.baidu.tieba.homepage.concern.a.b.a(this.jvK.thread_info.get(i2))) {
                    this.jvK.thread_info.remove(i2);
                    crz();
                    return;
                }
            }
        }
    }

    public static boolean cIP() {
        return com.baidu.tbadk.a.d.bid() && com.baidu.tbadk.core.sharedPref.b.bqh().getInt("key_home_concern_all_status", 0) == 0;
    }

    public static void LC(String str) {
        com.baidu.tbadk.core.sharedPref.b.bqh().putString(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("key_home_concern_all_status_cache_nextpage_key"), str);
    }

    public static String cIQ() {
        return com.baidu.tbadk.core.sharedPref.b.bqh().getString(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("key_home_concern_all_status_cache_nextpage_key"), "");
    }

    public static void LD(String str) {
        com.baidu.tbadk.core.sharedPref.b.bqh().putString(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("key_home_concern_all_status_cache_nextpage_update_key"), str);
    }

    public static String cIR() {
        return com.baidu.tbadk.core.sharedPref.b.bqh().getString(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("key_home_concern_all_status_cache_nextpage_update_key"), "");
    }

    public static void fP(long j) {
        com.baidu.tbadk.core.sharedPref.b.bqh().putLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("key_home_concern_all_status_cache_time"), j);
    }

    public static long cIS() {
        return com.baidu.tbadk.core.sharedPref.b.bqh().getLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("key_home_concern_all_status_cache_time"), 0L);
    }

    public static boolean cIT() {
        return com.baidu.tbadk.core.sharedPref.b.bqh().getBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("key_home_concern_all_status_cache_loaded"), false);
    }

    public static void qN(boolean z) {
        com.baidu.tbadk.core.sharedPref.b.bqh().putBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("key_home_concern_all_status_cache_loaded"), z);
    }
}
