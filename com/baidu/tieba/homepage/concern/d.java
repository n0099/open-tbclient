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
    private View.OnTouchListener feS;
    private aa fti;
    private boolean hasMore;
    private final BdTypeRecyclerView iHt;
    private com.baidu.tieba.f.a jcY;
    private BigdaySwipeRefreshLayout jpF;
    private DataRes.Builder jpN;
    private DataRes.Builder jpO;
    private DataRes.Builder jpP;
    private final com.baidu.tieba.homepage.concern.a jpS;
    private final com.baidu.tieba.homepage.concern.b.a jpT;
    private int jpU;
    private String pageTag;
    private a jpL = null;
    private final LinkedList<q> jpM = new LinkedList<>();
    private boolean mIsLoading = false;
    private boolean jpQ = false;
    private boolean jpR = false;
    private boolean mIsBackground = false;
    private CustomMessageListener eHG = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.homepage.concern.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (data.eYM == null) {
                    if (!data.isSucc) {
                        BdToast.a(TbadkCoreApplication.getInst().getContext(), updateAttentionMessage.getData().errorString, R.drawable.icon_pure_toast_mistake40_svg, 3000, true).bmI();
                    } else if (!data.isAttention) {
                        Iterator it = d.this.jpM.iterator();
                        while (it.hasNext()) {
                            Object next = it.next();
                            if ((next instanceof com.baidu.tieba.card.data.c) && ay.h(((com.baidu.tieba.card.data.c) next).bhz(), data.toUid)) {
                                it.remove();
                            }
                        }
                        if (d.this.jpM.size() < 9) {
                            d.this.bhq();
                            return;
                        }
                        d.this.setList(d.this.jpM);
                        d.this.jpS.notifyDataSetChanged();
                        if (d.this.jpL != null) {
                            d.this.jpL.af(false, false);
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener jpV = new CustomMessageListener(0) { // from class: com.baidu.tieba.homepage.concern.d.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long) && d.this.jpN != null && d.this.jpN.hot_recomforum != null && !y.isEmpty(d.this.jpN.hot_recomforum.tab_list)) {
                long longValue = ((Long) customResponsedMessage.getData()).longValue();
                DiscoverHotForum.Builder builder = new DiscoverHotForum.Builder(d.this.jpN.hot_recomforum);
                if (c.a(builder, longValue, customResponsedMessage.getCmd() == 2001335)) {
                    d.this.jpN.hot_recomforum = builder.build(true);
                    d.this.a(new DataRes.Builder(d.this.jpN.build(true)));
                }
            }
        }
    };
    RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.concern.d.6
        private int jpZ = 0;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (d.this.fti != null && !d.this.mIsBackground) {
                d.this.fti.m(recyclerView, i);
            }
            if (i == 0) {
                t.clQ().bJQ();
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
            if (d.this.fti != null && !d.this.mIsBackground) {
                d.this.fti.onScroll(this.jpZ, i);
            }
            this.jpZ = i;
        }
    };
    private View.OnTouchListener ftj = new View.OnTouchListener() { // from class: com.baidu.tieba.homepage.concern.d.7
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (d.this.feS != null) {
                d.this.feS.onTouch(view, motionEvent);
            }
            if (d.this.jcY != null) {
                d.this.jcY.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private CustomMessageListener jpW = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.homepage.concern.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.this.g(customResponsedMessage);
        }
    };
    private CustomMessageListener ike = new CustomMessageListener(CmdConfigCustom.CMD_THREAD_NOT_EXIST_WHEN_ENTER_PB) { // from class: com.baidu.tieba.homepage.concern.d.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.this.g(customResponsedMessage);
        }
    };
    private CustomMessageListener jpX = new CustomMessageListener(2921425) { // from class: com.baidu.tieba.homepage.concern.d.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.this.cGn();
        }
    };

    /* loaded from: classes22.dex */
    public interface a {
        void Lj(String str);

        void af(boolean z, boolean z2);

        void cGh();

        void cGi();

        void onError(int i, String str);
    }

    public void setTabInForeBackgroundState(boolean z) {
        this.mIsBackground = z;
    }

    public void pw(boolean z) {
        this.mIsBackground = z;
    }

    public d(e<?> eVar, BdTypeRecyclerView bdTypeRecyclerView, com.baidu.tieba.homepage.concern.a aVar, BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout) {
        this.iHt = bdTypeRecyclerView;
        this.iHt.setOnTouchListener(this.ftj);
        this.jcY = new com.baidu.tieba.f.a();
        this.jpT = new com.baidu.tieba.homepage.concern.b.a();
        this.jpS = aVar;
        bdTypeRecyclerView.setOnScrollListener(this.mOnScrollListener);
        this.jpF = bigdaySwipeRefreshLayout;
        qE(false);
    }

    public void s(BdUniqueId bdUniqueId) {
        this.jpW.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.jpW);
        this.ike.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.ike);
        this.jpX.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.jpX);
        this.eHG.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.eHG);
        this.jpV.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_LIKE_FORUM, this.jpV);
        MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_UNLIKE_FORUM, this.jpV);
    }

    public void setRecommendFrsNavigationAnimDispatcher(ab abVar) {
        if (abVar != null) {
            this.fti = abVar.bBt();
            this.feS = abVar.bBu();
        }
    }

    public void update() {
        if (cGo() && !this.jpQ) {
            bhr();
        } else {
            bhq();
        }
    }

    public void cGj() {
        this.jpO = new DataRes.Builder(this.jpN.build(true));
    }

    public void cGk() {
        this.jpN = new DataRes.Builder(this.jpO.build(true));
    }

    public void cGl() {
        bhq();
    }

    public void bMi() {
        if (!isLoading() && this.hasMore && this.jpL != null) {
            setIsLoading(true);
            this.jpL.Lj(this.pageTag);
        }
    }

    public void a(boolean z, DataRes dataRes, int i, String str) {
        setIsLoading(false);
        if (i != 0 || dataRes == null || !a(true, z, dataRes)) {
            if (i == 0 && y.getCount(this.jpM) == 0 && this.jpL != null) {
                this.jpL.cGi();
                if (this.jpF != null) {
                    this.jpF.setRefreshing(false);
                    return;
                }
                return;
            } else if (this.jpM.size() > 0) {
                if (this.jpL != null) {
                    this.jpL.onError(1, str);
                }
            } else if (this.jpL != null) {
                this.jpL.onError(2, str);
            }
        } else {
            if (this.jpL != null) {
                this.jpL.af(z, false);
            }
            if (z) {
                coY();
            }
        }
        if (this.jpF != null) {
            this.jpF.setRefreshing(false);
        }
    }

    public void qD(boolean z) {
        if (z) {
            this.jpS.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bhq() {
        if (this.jpL != null) {
            this.jpL.cGh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(DataRes dataRes) {
        this.jpQ = true;
        qE(true);
        if (dataRes != null) {
            if (a(false, true, dataRes)) {
                if (this.jpL != null) {
                    this.jpL.af(false, true);
                    return;
                }
                return;
            }
            bhq();
            return;
        }
        bhq();
    }

    private List<q> a(boolean z, DataRes.Builder builder, boolean z2) {
        if (this.jpN == null) {
            this.jpN = new DataRes.Builder();
        }
        if (builder == null) {
            builder = new DataRes.Builder();
        }
        com.baidu.tieba.homepage.personalize.model.c a2 = this.jpT.a(z, this.jpN, builder, z2 ? 0 : 1);
        if (a2 == null) {
            return null;
        }
        return a2.fIa;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setList(List<q> list) {
        this.jpS.ck(list);
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
        this.jpP = new DataRes.Builder(dataRes);
        if (cGo()) {
            Ll(this.pageTag);
        }
        LinkedList linkedList = new LinkedList();
        DataRes.Builder builder = new DataRes.Builder(dataRes);
        this.jpU = builder.user_tips_type.intValue();
        if (dataRes.req_unix != null) {
            com.baidu.tbadk.core.sharedPref.b.bnH().putLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(SharedPrefConfig.CONCERN_DATA_RES_REQUEST_TIME), dataRes.req_unix.longValue());
        }
        List<q> a2 = a(z, builder, z2);
        this.jpR = false;
        if (a2 != null && TbadkCoreApplication.isLogin()) {
            if (3 == this.jpU) {
                if (y.isEmpty(a2)) {
                    a2.add(new com.baidu.tieba.homepage.concern.a.a());
                    this.jpR = true;
                } else if (y.getCount(a2) == 1 && (y.getItem(a2, 0) instanceof com.baidu.tieba.homepage.concern.a.b)) {
                    a2.add(new com.baidu.tieba.homepage.concern.a.a());
                    this.jpR = true;
                }
            }
            linkedList.addAll(a2);
        }
        if (!at.isEmpty(builder.user_tips) && 2 == this.jpU) {
            com.baidu.tieba.homepage.concern.a.c cVar = new com.baidu.tieba.homepage.concern.a.c();
            cVar.jqY = builder.user_tips_type.intValue();
            cVar.tipString = builder.user_tips;
            if (builder.user_tips_type.intValue() == 4) {
                cVar.jqZ = true;
            } else {
                cVar.jra = true;
            }
            if (cGo() && (cVar.jqY == 2 || cVar.jqY == 3)) {
                if (linkedList.size() > 0) {
                    cVar.jqY = 0;
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
            if (this.jpM.isEmpty()) {
                return false;
            }
            Iterator<q> it = this.jpM.iterator();
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
                this.jpM.remove(qVar);
            }
            this.jpS.ck(this.jpM);
            return false;
        }
        this.jpM.clear();
        this.jpM.addAll(linkedList);
        if (z2) {
            this.jpN.page_tag = dataRes.page_tag;
            this.jpN.has_more = dataRes.has_more;
            this.jpN.user_list = dataRes.user_list;
            this.jpN.user_tips_type = dataRes.user_tips_type;
            this.jpN.user_tips = dataRes.user_tips;
            this.jpN.last_tips = dataRes.last_tips;
        }
        this.jpN.banner_user_story = dataRes.banner_user_story;
        this.jpN.banner_follow_live = dataRes.banner_follow_live;
        this.jpN.hot_recomforum = dataRes.hot_recomforum;
        this.jpN.top_tips = dataRes.top_tips;
        this.jpN.top_user_info = dataRes.top_user_info;
        if (this.jpU == 2 || this.jpU == 3) {
            this.jpN.user_tips_type = dataRes.user_tips_type;
            this.jpN.user_tips = dataRes.user_tips;
        }
        this.jpS.ck(this.jpM);
        return true;
    }

    private void bhr() {
        long currentTimeMillis = System.currentTimeMillis();
        long cGr = cGr();
        long j = currentTimeMillis - cGr;
        if (cGr == 0 || j > 86400000) {
            ae.a(new ad<DataRes>() { // from class: com.baidu.tieba.homepage.concern.d.8
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.ad
                /* renamed from: cGt */
                public DataRes doInBackground() {
                    com.baidu.tbadk.core.c.a.bmx().clearByteCacheWithSapce("tb.concern_page_all", TbadkCoreApplication.getCurrentAccount());
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
                /* renamed from: cGt */
                public DataRes doInBackground() {
                    l<byte[]> dH = com.baidu.tbadk.core.c.a.bmx().dH("tb.concern_page_all", TbadkCoreApplication.getCurrentAccount());
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

    private void coY() {
        if (this.jpP != null) {
            a(this.jpP);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final DataRes.Builder builder) {
        if (cGo()) {
            ae.a(new ad<Object>() { // from class: com.baidu.tieba.homepage.concern.d.12
                @Override // com.baidu.tbadk.util.ad
                public Object doInBackground() {
                    DataRes.Builder builder2 = new DataRes.Builder(builder.build(true));
                    l<byte[]> dH = com.baidu.tbadk.core.c.a.bmx().dH("tb.concern_page_all", TbadkCoreApplication.getCurrentAccount());
                    try {
                        DataRes build = builder2.build(true);
                        if (build != null && !y.isEmpty(build.thread_info)) {
                            dH.setForever("0", build.toByteArray());
                            d.Lm(d.this.pageTag);
                            d.ft(System.currentTimeMillis());
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
        this.jpL = aVar;
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

    public boolean cGm() {
        return this.jpR;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(CustomResponsedMessage<?> customResponsedMessage) {
        ThreadInfo threadInfo;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.jpN != null && y.getCount(this.jpN.thread_info) != 0 && y.getCount(this.jpM) != 0) {
            String optString = ((JSONObject) customResponsedMessage.getData()).optString("tid");
            if (!StringUtils.isNull(optString)) {
                Iterator<q> it = this.jpM.iterator();
                boolean z = false;
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    q next = it.next();
                    if (next instanceof com.baidu.tieba.card.data.c) {
                        com.baidu.tieba.card.data.c cVar = (com.baidu.tieba.card.data.c) next;
                        if (cVar.bhz() != null && cVar.bhz().getTid() != null) {
                            if (cVar.bhz().getTid().equals(optString)) {
                                z = true;
                                it.remove();
                            } else if (z) {
                                if (this.jpS != null) {
                                    this.jpS.ck(this.jpM);
                                }
                            }
                        }
                    }
                    z = z;
                }
                long j = com.baidu.adp.lib.f.b.toLong(optString, 0L);
                for (int i = 0; i < this.jpN.thread_info.size(); i++) {
                    ConcernData concernData = this.jpN.thread_info.get(i);
                    if (concernData != null && (threadInfo = concernData.thread_list) != null && threadInfo.tid != null && threadInfo.tid.longValue() == j) {
                        this.jpN.thread_info.remove(i);
                        coY();
                        return;
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cGn() {
        if (this.jpN != null && y.getCount(this.jpN.thread_info) != 0 && y.getCount(this.jpM) != 0) {
            int i = 0;
            while (true) {
                if (i >= this.jpM.size()) {
                    break;
                } else if (!(this.jpM.get(i) instanceof com.baidu.tieba.homepage.concern.a.b)) {
                    i++;
                } else {
                    this.jpM.remove(i);
                    if (this.jpS != null) {
                        this.jpS.ck(this.jpM);
                    }
                }
            }
            for (int i2 = 0; i2 < this.jpN.thread_info.size(); i2++) {
                if (com.baidu.tieba.homepage.concern.a.b.a(this.jpN.thread_info.get(i2))) {
                    this.jpN.thread_info.remove(i2);
                    coY();
                    return;
                }
            }
        }
    }

    public static boolean cGo() {
        return com.baidu.tbadk.a.d.bfD() && com.baidu.tbadk.core.sharedPref.b.bnH().getInt("key_home_concern_all_status", 0) == 0;
    }

    public static void Ll(String str) {
        com.baidu.tbadk.core.sharedPref.b.bnH().putString(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("key_home_concern_all_status_cache_nextpage_key"), str);
    }

    public static String cGp() {
        return com.baidu.tbadk.core.sharedPref.b.bnH().getString(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("key_home_concern_all_status_cache_nextpage_key"), "");
    }

    public static void Lm(String str) {
        com.baidu.tbadk.core.sharedPref.b.bnH().putString(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("key_home_concern_all_status_cache_nextpage_update_key"), str);
    }

    public static String cGq() {
        return com.baidu.tbadk.core.sharedPref.b.bnH().getString(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("key_home_concern_all_status_cache_nextpage_update_key"), "");
    }

    public static void ft(long j) {
        com.baidu.tbadk.core.sharedPref.b.bnH().putLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("key_home_concern_all_status_cache_time"), j);
    }

    public static long cGr() {
        return com.baidu.tbadk.core.sharedPref.b.bnH().getLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("key_home_concern_all_status_cache_time"), 0L);
    }

    public static boolean cGs() {
        return com.baidu.tbadk.core.sharedPref.b.bnH().getBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("key_home_concern_all_status_cache_loaded"), false);
    }

    public static void qE(boolean z) {
        com.baidu.tbadk.core.sharedPref.b.bnH().putBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("key_home_concern_all_status_cache_loaded"), z);
    }
}
