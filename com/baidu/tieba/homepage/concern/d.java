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
import com.baidu.tieba.card.s;
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
    private View.OnTouchListener eWw;
    private aa fkJ;
    private boolean hasMore;
    private com.baidu.tieba.f.a iQC;
    private final BdTypeRecyclerView iuX;
    private BigdaySwipeRefreshLayout jdj;
    private DataRes.Builder jdr;
    private DataRes.Builder jds;
    private DataRes.Builder jdt;
    private final com.baidu.tieba.homepage.concern.a jdw;
    private final com.baidu.tieba.homepage.concern.b.a jdx;
    private int jdy;
    private String pageTag;
    private a jdp = null;
    private final LinkedList<q> jdq = new LinkedList<>();
    private boolean mIsLoading = false;
    private boolean jdu = false;
    private boolean jdv = false;
    private boolean mIsBackground = false;
    private CustomMessageListener ezk = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.homepage.concern.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (data.eQq == null) {
                    if (!data.isSucc) {
                        BdToast.a(TbadkCoreApplication.getInst().getContext(), updateAttentionMessage.getData().errorString, R.drawable.icon_pure_toast_mistake40_svg, 3000, true).bkP();
                    } else if (!data.isAttention) {
                        Iterator it = d.this.jdq.iterator();
                        while (it.hasNext()) {
                            Object next = it.next();
                            if ((next instanceof com.baidu.tieba.card.data.c) && ay.h(((com.baidu.tieba.card.data.c) next).bfG(), data.toUid)) {
                                it.remove();
                            }
                        }
                        if (d.this.jdq.size() < 9) {
                            d.this.bfx();
                            return;
                        }
                        d.this.setList(d.this.jdq);
                        d.this.jdw.notifyDataSetChanged();
                        if (d.this.jdp != null) {
                            d.this.jdp.ac(false, false);
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener jdz = new CustomMessageListener(0) { // from class: com.baidu.tieba.homepage.concern.d.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long) && d.this.jdr != null && d.this.jdr.hot_recomforum != null && !y.isEmpty(d.this.jdr.hot_recomforum.tab_list)) {
                long longValue = ((Long) customResponsedMessage.getData()).longValue();
                DiscoverHotForum.Builder builder = new DiscoverHotForum.Builder(d.this.jdr.hot_recomforum);
                if (c.a(builder, longValue, customResponsedMessage.getCmd() == 2001335)) {
                    d.this.jdr.hot_recomforum = builder.build(true);
                    d.this.a(new DataRes.Builder(d.this.jdr.build(true)));
                }
            }
        }
    };
    RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.concern.d.6
        private int jdD = 0;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (d.this.fkJ != null && !d.this.mIsBackground) {
                d.this.fkJ.m(recyclerView, i);
            }
            if (i == 0) {
                s.ciJ().bHY();
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
            if (d.this.fkJ != null && !d.this.mIsBackground) {
                d.this.fkJ.onScroll(this.jdD, i);
            }
            this.jdD = i;
        }
    };
    private View.OnTouchListener fkK = new View.OnTouchListener() { // from class: com.baidu.tieba.homepage.concern.d.7
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (d.this.eWw != null) {
                d.this.eWw.onTouch(view, motionEvent);
            }
            if (d.this.iQC != null) {
                d.this.iQC.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private CustomMessageListener jdA = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.homepage.concern.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.this.g(customResponsedMessage);
        }
    };
    private CustomMessageListener hXE = new CustomMessageListener(CmdConfigCustom.CMD_THREAD_NOT_EXIST_WHEN_ENTER_PB) { // from class: com.baidu.tieba.homepage.concern.d.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.this.g(customResponsedMessage);
        }
    };
    private CustomMessageListener jdB = new CustomMessageListener(2921425) { // from class: com.baidu.tieba.homepage.concern.d.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.this.cDg();
        }
    };

    /* loaded from: classes22.dex */
    public interface a {
        void KL(String str);

        void ac(boolean z, boolean z2);

        void cDa();

        void cDb();

        void onError(int i, String str);
    }

    public void setTabInForeBackgroundState(boolean z) {
        this.mIsBackground = z;
    }

    public void pe(boolean z) {
        this.mIsBackground = z;
    }

    public d(e<?> eVar, BdTypeRecyclerView bdTypeRecyclerView, com.baidu.tieba.homepage.concern.a aVar, BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout) {
        this.iuX = bdTypeRecyclerView;
        this.iuX.setOnTouchListener(this.fkK);
        this.iQC = new com.baidu.tieba.f.a();
        this.jdx = new com.baidu.tieba.homepage.concern.b.a();
        this.jdw = aVar;
        bdTypeRecyclerView.setOnScrollListener(this.mOnScrollListener);
        this.jdj = bigdaySwipeRefreshLayout;
        qm(false);
    }

    public void s(BdUniqueId bdUniqueId) {
        this.jdA.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.jdA);
        this.hXE.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.hXE);
        this.jdB.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.jdB);
        this.ezk.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.ezk);
        this.jdz.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_LIKE_FORUM, this.jdz);
        MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_UNLIKE_FORUM, this.jdz);
    }

    public void setRecommendFrsNavigationAnimDispatcher(ab abVar) {
        if (abVar != null) {
            this.fkJ = abVar.bzA();
            this.eWw = abVar.bzB();
        }
    }

    public void update() {
        if (cDh() && !this.jdu) {
            bfy();
        } else {
            bfx();
        }
    }

    public void cDc() {
        this.jds = new DataRes.Builder(this.jdr.build(true));
    }

    public void cDd() {
        this.jdr = new DataRes.Builder(this.jds.build(true));
    }

    public void cDe() {
        bfx();
    }

    public void bJG() {
        if (!isLoading() && this.hasMore && this.jdp != null) {
            setIsLoading(true);
            this.jdp.KL(this.pageTag);
        }
    }

    public void a(boolean z, DataRes dataRes, int i, String str) {
        setIsLoading(false);
        if (i != 0 || dataRes == null || !a(true, z, dataRes)) {
            if (i == 0 && y.getCount(this.jdq) == 0 && this.jdp != null) {
                this.jdp.cDb();
                if (this.jdj != null) {
                    this.jdj.setRefreshing(false);
                    return;
                }
                return;
            } else if (this.jdq.size() > 0) {
                if (this.jdp != null) {
                    this.jdp.onError(1, str);
                }
            } else if (this.jdp != null) {
                this.jdp.onError(2, str);
            }
        } else {
            if (this.jdp != null) {
                this.jdp.ac(z, false);
            }
            if (z) {
                clR();
            }
        }
        if (this.jdj != null) {
            this.jdj.setRefreshing(false);
        }
    }

    public void ql(boolean z) {
        if (z) {
            this.jdw.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bfx() {
        if (this.jdp != null) {
            this.jdp.cDa();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(DataRes dataRes) {
        this.jdu = true;
        qm(true);
        if (dataRes != null) {
            if (a(false, true, dataRes)) {
                if (this.jdp != null) {
                    this.jdp.ac(false, true);
                    return;
                }
                return;
            }
            bfx();
            return;
        }
        bfx();
    }

    private List<q> a(boolean z, DataRes.Builder builder, boolean z2) {
        if (this.jdr == null) {
            this.jdr = new DataRes.Builder();
        }
        if (builder == null) {
            builder = new DataRes.Builder();
        }
        com.baidu.tieba.homepage.personalize.model.c a2 = this.jdx.a(z, this.jdr, builder, z2 ? 0 : 1);
        if (a2 == null) {
            return null;
        }
        return a2.fzF;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setList(List<q> list) {
        this.jdw.ca(list);
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
        this.jdt = new DataRes.Builder(dataRes);
        if (cDh()) {
            KN(this.pageTag);
        }
        LinkedList linkedList = new LinkedList();
        DataRes.Builder builder = new DataRes.Builder(dataRes);
        this.jdy = builder.user_tips_type.intValue();
        if (dataRes.req_unix != null) {
            com.baidu.tbadk.core.sharedPref.b.blO().putLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(SharedPrefConfig.CONCERN_DATA_RES_REQUEST_TIME), dataRes.req_unix.longValue());
        }
        List<q> a2 = a(z, builder, z2);
        this.jdv = false;
        if (a2 != null && TbadkCoreApplication.isLogin()) {
            if (3 == this.jdy) {
                if (y.isEmpty(a2)) {
                    a2.add(new com.baidu.tieba.homepage.concern.a.a());
                    this.jdv = true;
                } else if (y.getCount(a2) == 1 && (y.getItem(a2, 0) instanceof com.baidu.tieba.homepage.concern.a.b)) {
                    a2.add(new com.baidu.tieba.homepage.concern.a.a());
                    this.jdv = true;
                }
            }
            linkedList.addAll(a2);
        }
        if (!at.isEmpty(builder.user_tips) && 2 == this.jdy) {
            com.baidu.tieba.homepage.concern.a.c cVar = new com.baidu.tieba.homepage.concern.a.c();
            cVar.jeA = builder.user_tips_type.intValue();
            cVar.tipString = builder.user_tips;
            if (builder.user_tips_type.intValue() == 4) {
                cVar.jeB = true;
            } else {
                cVar.jeC = true;
            }
            if (cDh() && (cVar.jeA == 2 || cVar.jeA == 3)) {
                if (linkedList.size() > 0) {
                    cVar.jeA = 0;
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
            if (this.jdq.isEmpty()) {
                return false;
            }
            Iterator<q> it = this.jdq.iterator();
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
                this.jdq.remove(qVar);
            }
            this.jdw.ca(this.jdq);
            return false;
        }
        this.jdq.clear();
        this.jdq.addAll(linkedList);
        if (z2) {
            this.jdr.page_tag = dataRes.page_tag;
            this.jdr.has_more = dataRes.has_more;
            this.jdr.user_list = dataRes.user_list;
            this.jdr.user_tips_type = dataRes.user_tips_type;
            this.jdr.user_tips = dataRes.user_tips;
            this.jdr.last_tips = dataRes.last_tips;
        }
        this.jdr.banner_user_story = dataRes.banner_user_story;
        this.jdr.banner_follow_live = dataRes.banner_follow_live;
        this.jdr.hot_recomforum = dataRes.hot_recomforum;
        this.jdr.top_tips = dataRes.top_tips;
        this.jdr.top_user_info = dataRes.top_user_info;
        if (this.jdy == 2 || this.jdy == 3) {
            this.jdr.user_tips_type = dataRes.user_tips_type;
            this.jdr.user_tips = dataRes.user_tips;
        }
        this.jdw.ca(this.jdq);
        return true;
    }

    private void bfy() {
        long currentTimeMillis = System.currentTimeMillis();
        long cDk = cDk();
        long j = currentTimeMillis - cDk;
        if (cDk == 0 || j > 86400000) {
            ae.a(new ad<DataRes>() { // from class: com.baidu.tieba.homepage.concern.d.8
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.ad
                /* renamed from: cDm */
                public DataRes doInBackground() {
                    com.baidu.tbadk.core.c.a.bkE().clearByteCacheWithSapce("tb.concern_page_all", TbadkCoreApplication.getCurrentAccount());
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
                /* renamed from: cDm */
                public DataRes doInBackground() {
                    l<byte[]> dA = com.baidu.tbadk.core.c.a.bkE().dA("tb.concern_page_all", TbadkCoreApplication.getCurrentAccount());
                    if (dA == null) {
                        return null;
                    }
                    byte[] bArr = dA.get("0");
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

    private void clR() {
        if (this.jdt != null) {
            a(this.jdt);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final DataRes.Builder builder) {
        if (cDh()) {
            ae.a(new ad<Object>() { // from class: com.baidu.tieba.homepage.concern.d.12
                @Override // com.baidu.tbadk.util.ad
                public Object doInBackground() {
                    DataRes.Builder builder2 = new DataRes.Builder(builder.build(true));
                    l<byte[]> dA = com.baidu.tbadk.core.c.a.bkE().dA("tb.concern_page_all", TbadkCoreApplication.getCurrentAccount());
                    try {
                        DataRes build = builder2.build(true);
                        if (build != null && !y.isEmpty(build.thread_info)) {
                            dA.setForever("0", build.toByteArray());
                            d.KO(d.this.pageTag);
                            d.fs(System.currentTimeMillis());
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
        this.jdp = aVar;
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

    public boolean cDf() {
        return this.jdv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(CustomResponsedMessage<?> customResponsedMessage) {
        ThreadInfo threadInfo;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.jdr != null && y.getCount(this.jdr.thread_info) != 0 && y.getCount(this.jdq) != 0) {
            String optString = ((JSONObject) customResponsedMessage.getData()).optString("tid");
            if (!StringUtils.isNull(optString)) {
                Iterator<q> it = this.jdq.iterator();
                boolean z = false;
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    q next = it.next();
                    if (next instanceof com.baidu.tieba.card.data.c) {
                        com.baidu.tieba.card.data.c cVar = (com.baidu.tieba.card.data.c) next;
                        if (cVar.bfG() != null && cVar.bfG().getTid() != null) {
                            if (cVar.bfG().getTid().equals(optString)) {
                                z = true;
                                it.remove();
                            } else if (z) {
                                if (this.jdw != null) {
                                    this.jdw.ca(this.jdq);
                                }
                            }
                        }
                    }
                    z = z;
                }
                long j = com.baidu.adp.lib.f.b.toLong(optString, 0L);
                for (int i = 0; i < this.jdr.thread_info.size(); i++) {
                    ConcernData concernData = this.jdr.thread_info.get(i);
                    if (concernData != null && (threadInfo = concernData.thread_list) != null && threadInfo.tid != null && threadInfo.tid.longValue() == j) {
                        this.jdr.thread_info.remove(i);
                        clR();
                        return;
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cDg() {
        if (this.jdr != null && y.getCount(this.jdr.thread_info) != 0 && y.getCount(this.jdq) != 0) {
            int i = 0;
            while (true) {
                if (i >= this.jdq.size()) {
                    break;
                } else if (!(this.jdq.get(i) instanceof com.baidu.tieba.homepage.concern.a.b)) {
                    i++;
                } else {
                    this.jdq.remove(i);
                    if (this.jdw != null) {
                        this.jdw.ca(this.jdq);
                    }
                }
            }
            for (int i2 = 0; i2 < this.jdr.thread_info.size(); i2++) {
                if (com.baidu.tieba.homepage.concern.a.b.a(this.jdr.thread_info.get(i2))) {
                    this.jdr.thread_info.remove(i2);
                    clR();
                    return;
                }
            }
        }
    }

    public static boolean cDh() {
        return com.baidu.tbadk.a.d.bdK() && com.baidu.tbadk.core.sharedPref.b.blO().getInt("key_home_concern_all_status", 0) == 0;
    }

    public static void KN(String str) {
        com.baidu.tbadk.core.sharedPref.b.blO().putString(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("key_home_concern_all_status_cache_nextpage_key"), str);
    }

    public static String cDi() {
        return com.baidu.tbadk.core.sharedPref.b.blO().getString(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("key_home_concern_all_status_cache_nextpage_key"), "");
    }

    public static void KO(String str) {
        com.baidu.tbadk.core.sharedPref.b.blO().putString(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("key_home_concern_all_status_cache_nextpage_update_key"), str);
    }

    public static String cDj() {
        return com.baidu.tbadk.core.sharedPref.b.blO().getString(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("key_home_concern_all_status_cache_nextpage_update_key"), "");
    }

    public static void fs(long j) {
        com.baidu.tbadk.core.sharedPref.b.blO().putLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("key_home_concern_all_status_cache_time"), j);
    }

    public static long cDk() {
        return com.baidu.tbadk.core.sharedPref.b.blO().getLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("key_home_concern_all_status_cache_time"), 0L);
    }

    public static boolean cDl() {
        return com.baidu.tbadk.core.sharedPref.b.blO().getBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("key_home_concern_all_status_cache_loaded"), false);
    }

    public static void qm(boolean z) {
        com.baidu.tbadk.core.sharedPref.b.blO().putBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("key_home_concern_all_status_cache_loaded"), z);
    }
}
