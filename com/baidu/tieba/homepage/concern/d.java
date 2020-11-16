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
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tbadk.util.ac;
import com.baidu.tbadk.util.ad;
import com.baidu.tbadk.util.m;
import com.baidu.tbadk.util.y;
import com.baidu.tbadk.util.z;
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
/* loaded from: classes21.dex */
public class d {
    private View.OnTouchListener fjT;
    private y fyn;
    private boolean hasMore;
    private final BdTypeRecyclerView iOd;
    private com.baidu.tieba.g.a jjH;
    private final com.baidu.tieba.homepage.concern.a jwB;
    private final com.baidu.tieba.homepage.concern.b.a jwC;
    private int jwD;
    private BigdaySwipeRefreshLayout jwo;
    private DataRes.Builder jww;
    private DataRes.Builder jwx;
    private DataRes.Builder jwy;
    private String pageTag;
    private a jwu = null;
    private final LinkedList<q> jwv = new LinkedList<>();
    private boolean mIsLoading = false;
    private boolean jwz = false;
    private boolean jwA = false;
    private boolean mIsBackground = false;
    private CustomMessageListener eMu = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.homepage.concern.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (data.fdL == null) {
                    if (!data.isSucc) {
                        BdToast.a(TbadkCoreApplication.getInst().getContext(), updateAttentionMessage.getData().errorString, R.drawable.icon_pure_toast_mistake40_svg, 3000, true).bom();
                    } else if (!data.isAttention) {
                        Iterator it = d.this.jwv.iterator();
                        while (it.hasNext()) {
                            Object next = it.next();
                            if ((next instanceof com.baidu.tieba.card.data.b) && az.h(((com.baidu.tieba.card.data.b) next).bjd(), data.toUid)) {
                                it.remove();
                            }
                        }
                        if (d.this.jwv.size() < 9) {
                            d.this.biU();
                            return;
                        }
                        d.this.setList(d.this.jwv);
                        d.this.jwB.notifyDataSetChanged();
                        if (d.this.jwu != null) {
                            d.this.jwu.af(false, false);
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener jwE = new CustomMessageListener(0) { // from class: com.baidu.tieba.homepage.concern.d.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long) && d.this.jww != null && d.this.jww.hot_recomforum != null && !com.baidu.tbadk.core.util.y.isEmpty(d.this.jww.hot_recomforum.tab_list)) {
                long longValue = ((Long) customResponsedMessage.getData()).longValue();
                DiscoverHotForum.Builder builder = new DiscoverHotForum.Builder(d.this.jww.hot_recomforum);
                if (c.a(builder, longValue, customResponsedMessage.getCmd() == 2001335)) {
                    d.this.jww.hot_recomforum = builder.build(true);
                    d.this.a(new DataRes.Builder(d.this.jww.build(true)));
                }
            }
        }
    };
    RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.concern.d.6
        private int jwI = 0;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (d.this.fyn != null && !d.this.mIsBackground) {
                d.this.fyn.m(recyclerView, i);
            }
            if (i == 0) {
                t.cnT().bLI();
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
            if (d.this.fyn != null && !d.this.mIsBackground) {
                d.this.fyn.onScroll(this.jwI, i);
            }
            this.jwI = i;
        }
    };
    private View.OnTouchListener fyo = new View.OnTouchListener() { // from class: com.baidu.tieba.homepage.concern.d.7
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (d.this.fjT != null) {
                d.this.fjT.onTouch(view, motionEvent);
            }
            if (d.this.jjH != null) {
                d.this.jjH.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private CustomMessageListener jwF = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.homepage.concern.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.this.g(customResponsedMessage);
        }
    };
    private CustomMessageListener iqR = new CustomMessageListener(CmdConfigCustom.CMD_THREAD_NOT_EXIST_WHEN_ENTER_PB) { // from class: com.baidu.tieba.homepage.concern.d.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.this.g(customResponsedMessage);
        }
    };
    private CustomMessageListener jwG = new CustomMessageListener(2921425) { // from class: com.baidu.tieba.homepage.concern.d.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.this.cIt();
        }
    };

    /* loaded from: classes21.dex */
    public interface a {
        void Lb(String str);

        void af(boolean z, boolean z2);

        void cIn();

        void cIo();

        void onError(int i, String str);
    }

    public void setTabInForeBackgroundState(boolean z) {
        this.mIsBackground = z;
    }

    public void pI(boolean z) {
        this.mIsBackground = z;
    }

    public d(e<?> eVar, BdTypeRecyclerView bdTypeRecyclerView, com.baidu.tieba.homepage.concern.a aVar, BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout) {
        this.iOd = bdTypeRecyclerView;
        this.iOd.setOnTouchListener(this.fyo);
        this.jjH = new com.baidu.tieba.g.a();
        this.jwC = new com.baidu.tieba.homepage.concern.b.a();
        this.jwB = aVar;
        bdTypeRecyclerView.setOnScrollListener(this.mOnScrollListener);
        this.jwo = bigdaySwipeRefreshLayout;
        qQ(false);
    }

    public void s(BdUniqueId bdUniqueId) {
        this.jwF.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.jwF);
        this.iqR.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.iqR);
        this.jwG.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.jwG);
        this.eMu.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.eMu);
        this.jwE.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_LIKE_FORUM, this.jwE);
        MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_UNLIKE_FORUM, this.jwE);
    }

    public void setRecommendFrsNavigationAnimDispatcher(z zVar) {
        if (zVar != null) {
            this.fyn = zVar.bDj();
            this.fjT = zVar.bDk();
        }
    }

    public void update() {
        if (cIu() && !this.jwz) {
            biV();
        } else {
            biU();
        }
    }

    public void cIp() {
        this.jwx = new DataRes.Builder(this.jww.build(true));
    }

    public void cIq() {
        this.jww = new DataRes.Builder(this.jwx.build(true));
    }

    public void cIr() {
        biU();
    }

    public void bOb() {
        if (!isLoading() && this.hasMore && this.jwu != null) {
            setIsLoading(true);
            this.jwu.Lb(this.pageTag);
        }
    }

    public void a(boolean z, DataRes dataRes, int i, String str) {
        setIsLoading(false);
        if (i != 0 || dataRes == null || !a(true, z, dataRes)) {
            if (i == 0 && com.baidu.tbadk.core.util.y.getCount(this.jwv) == 0 && this.jwu != null) {
                this.jwu.cIo();
                if (this.jwo != null) {
                    this.jwo.setRefreshing(false);
                    return;
                }
                return;
            } else if (this.jwv.size() > 0) {
                if (this.jwu != null) {
                    this.jwu.onError(1, str);
                }
            } else if (this.jwu != null) {
                this.jwu.onError(2, str);
            }
        } else {
            if (this.jwu != null) {
                this.jwu.af(z, false);
            }
            if (z) {
                crc();
            }
        }
        if (this.jwo != null) {
            this.jwo.setRefreshing(false);
        }
    }

    public void qP(boolean z) {
        if (z) {
            this.jwB.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void biU() {
        if (this.jwu != null) {
            this.jwu.cIn();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(DataRes dataRes) {
        this.jwz = true;
        qQ(true);
        if (dataRes != null) {
            if (a(false, true, dataRes)) {
                if (this.jwu != null) {
                    this.jwu.af(false, true);
                    return;
                }
                return;
            }
            biU();
            return;
        }
        biU();
    }

    private List<q> a(boolean z, DataRes.Builder builder, boolean z2) {
        if (this.jww == null) {
            this.jww = new DataRes.Builder();
        }
        if (builder == null) {
            builder = new DataRes.Builder();
        }
        com.baidu.tieba.homepage.personalize.model.c a2 = this.jwC.a(z, this.jww, builder, z2 ? 0 : 1);
        if (a2 == null) {
            return null;
        }
        return a2.fNt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setList(List<q> list) {
        this.jwB.cr(list);
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00c1  */
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
        this.jwy = new DataRes.Builder(dataRes);
        if (cIu()) {
            Ld(this.pageTag);
        }
        LinkedList linkedList = new LinkedList();
        DataRes.Builder builder = new DataRes.Builder(dataRes);
        this.jwD = builder.user_tips_type.intValue();
        if (dataRes.req_unix != null) {
            com.baidu.tbadk.core.sharedPref.b.bpu().putLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(SharedPrefConfig.CONCERN_DATA_RES_REQUEST_TIME), dataRes.req_unix.longValue());
        }
        List<q> a2 = a(z, builder, z2);
        this.jwA = false;
        if (a2 != null && TbadkCoreApplication.isLogin()) {
            if (com.baidu.tbadk.core.util.y.isEmpty(a2) || (com.baidu.tbadk.core.util.y.getCount(a2) == 1 && (com.baidu.tbadk.core.util.y.getItem(a2, 0) instanceof com.baidu.tieba.homepage.concern.a.a))) {
                if (3 == this.jwD) {
                    com.baidu.tieba.homepage.concern.a.b bVar = new com.baidu.tieba.homepage.concern.a.b();
                    bVar.jxO = com.baidu.tieba.homepage.concern.a.b.jxJ;
                    bVar.jxL = 3;
                    a2.add(bVar);
                    this.jwA = true;
                } else if (2 == this.jwD) {
                    com.baidu.tieba.homepage.concern.a.b bVar2 = new com.baidu.tieba.homepage.concern.a.b();
                    bVar2.jxO = com.baidu.tieba.homepage.concern.a.b.jxJ;
                    bVar2.jxL = 2;
                    a2.add(bVar2);
                    this.jwA = true;
                }
            }
            linkedList.addAll(a2);
        }
        if (!au.isEmpty(builder.user_tips) && 2 == this.jwD) {
            com.baidu.tieba.homepage.concern.a.b bVar3 = new com.baidu.tieba.homepage.concern.a.b();
            bVar3.jxL = builder.user_tips_type.intValue();
            bVar3.tipString = builder.user_tips;
            if (builder.user_tips_type.intValue() == 4) {
                bVar3.jxM = true;
            } else {
                bVar3.jxN = true;
            }
            if (cIu() && (bVar3.jxL == 2 || bVar3.jxL == 3)) {
                if (linkedList.size() > 0) {
                    bVar3.jxL = 0;
                    z3 = false;
                    if (z3) {
                        linkedList.add(bVar3);
                    }
                } else {
                    bVar3.tipString = TbadkCoreApplication.getInst().getString(R.string.concern_no_data_title);
                }
            }
            z3 = true;
            if (z3) {
            }
        }
        this.hasMore = builder.has_more.intValue() == 1;
        if (com.baidu.tbadk.core.util.y.isEmpty(linkedList)) {
            if (this.jwv.isEmpty()) {
                return false;
            }
            Iterator<q> it = this.jwv.iterator();
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
                this.jwv.remove(qVar);
            }
            this.jwB.cr(this.jwv);
            return false;
        }
        this.jwv.clear();
        this.jwv.addAll(linkedList);
        if (z2) {
            this.jww.page_tag = dataRes.page_tag;
            this.jww.has_more = dataRes.has_more;
            this.jww.user_list = dataRes.user_list;
            this.jww.user_tips_type = dataRes.user_tips_type;
            this.jww.user_tips = dataRes.user_tips;
            this.jww.last_tips = dataRes.last_tips;
        }
        this.jww.banner_user_story = dataRes.banner_user_story;
        this.jww.banner_follow_live = dataRes.banner_follow_live;
        this.jww.hot_recomforum = dataRes.hot_recomforum;
        this.jww.top_tips = dataRes.top_tips;
        this.jww.top_user_info = dataRes.top_user_info;
        if (this.jwD == 2 || this.jwD == 3) {
            this.jww.user_tips_type = dataRes.user_tips_type;
            this.jww.user_tips = dataRes.user_tips;
        }
        this.jwB.cr(this.jwv);
        return true;
    }

    private void biV() {
        long currentTimeMillis = System.currentTimeMillis();
        long cIx = cIx();
        long j = currentTimeMillis - cIx;
        if (cIx == 0 || j > 86400000) {
            ad.a(new ac<DataRes>() { // from class: com.baidu.tieba.homepage.concern.d.8
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.ac
                /* renamed from: cIz */
                public DataRes doInBackground() {
                    com.baidu.tbadk.core.c.a.bob().clearByteCacheWithSapce("tb.concern_page_all", TbadkCoreApplication.getCurrentAccount());
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
            ad.a(new ac<DataRes>() { // from class: com.baidu.tieba.homepage.concern.d.10
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.ac
                /* renamed from: cIz */
                public DataRes doInBackground() {
                    l<byte[]> dF = com.baidu.tbadk.core.c.a.bob().dF("tb.concern_page_all", TbadkCoreApplication.getCurrentAccount());
                    if (dF == null) {
                        return null;
                    }
                    byte[] bArr = dF.get("0");
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

    private void crc() {
        if (this.jwy != null) {
            a(this.jwy);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final DataRes.Builder builder) {
        if (cIu()) {
            ad.a(new ac<Object>() { // from class: com.baidu.tieba.homepage.concern.d.12
                @Override // com.baidu.tbadk.util.ac
                public Object doInBackground() {
                    DataRes.Builder builder2 = new DataRes.Builder(builder.build(true));
                    l<byte[]> dF = com.baidu.tbadk.core.c.a.bob().dF("tb.concern_page_all", TbadkCoreApplication.getCurrentAccount());
                    try {
                        DataRes build = builder2.build(true);
                        if (build != null && !com.baidu.tbadk.core.util.y.isEmpty(build.thread_info)) {
                            dF.setForever("0", build.toByteArray());
                            d.Le(d.this.pageTag);
                            d.fS(System.currentTimeMillis());
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
        this.jwu = aVar;
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

    public boolean cIs() {
        return this.jwA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(CustomResponsedMessage<?> customResponsedMessage) {
        ThreadInfo threadInfo;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.jww != null && com.baidu.tbadk.core.util.y.getCount(this.jww.thread_info) != 0 && com.baidu.tbadk.core.util.y.getCount(this.jwv) != 0) {
            String optString = ((JSONObject) customResponsedMessage.getData()).optString("tid");
            if (!StringUtils.isNull(optString)) {
                Iterator<q> it = this.jwv.iterator();
                boolean z = false;
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    q next = it.next();
                    if (next instanceof com.baidu.tieba.card.data.b) {
                        com.baidu.tieba.card.data.b bVar = (com.baidu.tieba.card.data.b) next;
                        if (bVar.bjd() != null && bVar.bjd().getTid() != null) {
                            if (bVar.bjd().getTid().equals(optString)) {
                                z = true;
                                it.remove();
                            } else if (z) {
                                if (this.jwB != null) {
                                    this.jwB.cr(this.jwv);
                                }
                            }
                        }
                    }
                    z = z;
                }
                long j = com.baidu.adp.lib.f.b.toLong(optString, 0L);
                for (int i = 0; i < this.jww.thread_info.size(); i++) {
                    ConcernData concernData = this.jww.thread_info.get(i);
                    if (concernData != null && (threadInfo = concernData.thread_list) != null && threadInfo.tid != null && threadInfo.tid.longValue() == j) {
                        this.jww.thread_info.remove(i);
                        crc();
                        return;
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cIt() {
        if (this.jww != null && com.baidu.tbadk.core.util.y.getCount(this.jww.thread_info) != 0 && com.baidu.tbadk.core.util.y.getCount(this.jwv) != 0) {
            int i = 0;
            while (true) {
                if (i >= this.jwv.size()) {
                    break;
                } else if (!(this.jwv.get(i) instanceof com.baidu.tieba.homepage.concern.a.a)) {
                    i++;
                } else {
                    this.jwv.remove(i);
                    if (this.jwB != null) {
                        this.jwB.cr(this.jwv);
                    }
                }
            }
            for (int i2 = 0; i2 < this.jww.thread_info.size(); i2++) {
                if (com.baidu.tieba.homepage.concern.a.a.a(this.jww.thread_info.get(i2))) {
                    this.jww.thread_info.remove(i2);
                    crc();
                    return;
                }
            }
        }
    }

    public static boolean cIu() {
        return com.baidu.tbadk.a.d.bhv() && com.baidu.tbadk.core.sharedPref.b.bpu().getInt("key_home_concern_all_status", 0) == 0;
    }

    public static void Ld(String str) {
        com.baidu.tbadk.core.sharedPref.b.bpu().putString(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("key_home_concern_all_status_cache_nextpage_key"), str);
    }

    public static String cIv() {
        return com.baidu.tbadk.core.sharedPref.b.bpu().getString(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("key_home_concern_all_status_cache_nextpage_key"), "");
    }

    public static void Le(String str) {
        com.baidu.tbadk.core.sharedPref.b.bpu().putString(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("key_home_concern_all_status_cache_nextpage_update_key"), str);
    }

    public static String cIw() {
        return com.baidu.tbadk.core.sharedPref.b.bpu().getString(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("key_home_concern_all_status_cache_nextpage_update_key"), "");
    }

    public static void fS(long j) {
        com.baidu.tbadk.core.sharedPref.b.bpu().putLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("key_home_concern_all_status_cache_time"), j);
    }

    public static long cIx() {
        return com.baidu.tbadk.core.sharedPref.b.bpu().getLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("key_home_concern_all_status_cache_time"), 0L);
    }

    public static boolean cIy() {
        return com.baidu.tbadk.core.sharedPref.b.bpu().getBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("key_home_concern_all_status_cache_loaded"), false);
    }

    public static void qQ(boolean z) {
        com.baidu.tbadk.core.sharedPref.b.bpu().putBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("key_home_concern_all_status_cache_loaded"), z);
    }
}
