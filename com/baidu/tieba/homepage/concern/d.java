package com.baidu.tieba.homepage.concern;

import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
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
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.al;
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
import java.util.ArrayList;
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
    private y fGc;
    private View.OnTouchListener frt;
    private boolean hasMore;
    private final BdTypeRecyclerView iYU;
    private BigdaySwipeRefreshLayout jJP;
    private DataRes.Builder jJX;
    private DataRes.Builder jJY;
    private DataRes.Builder jJZ;
    private final com.baidu.tieba.homepage.concern.a jKc;
    private final com.baidu.tieba.homepage.concern.b.a jKd;
    private int jKe;
    private com.baidu.tieba.g.a jxj;
    private String pageTag;
    private a jJV = null;
    private final LinkedList<q> jJW = new LinkedList<>();
    private boolean mIsLoading = false;
    private boolean jKa = false;
    private boolean jKb = false;
    private boolean mIsBackground = false;
    private int mPn = 0;
    private List<al> jKf = new ArrayList();
    private CustomMessageListener eTG = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.homepage.concern.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (data.flk == null) {
                    if (!data.isSucc) {
                        BdToast.a(TbadkCoreApplication.getInst().getContext(), updateAttentionMessage.getData().errorString, R.drawable.icon_pure_toast_mistake40_svg, 3000, true).brB();
                    } else if (!data.isAttention) {
                        Iterator it = d.this.jJW.iterator();
                        while (it.hasNext()) {
                            Object next = it.next();
                            if ((next instanceof com.baidu.tieba.card.data.b) && az.h(((com.baidu.tieba.card.data.b) next).bmn(), data.toUid)) {
                                it.remove();
                            }
                        }
                        com.baidu.tieba.recapp.a.fN(d.this.jJW);
                        d.this.jKf.clear();
                        if (d.this.jJW.size() < 9) {
                            d.this.bme();
                        } else {
                            d.this.setList(d.this.jJW);
                            d.this.jKc.notifyDataSetChanged();
                            if (d.this.jJV != null) {
                                d.this.jJV.af(false, false);
                            }
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921517, Boolean.valueOf(d.this.mIsBackground)));
                    }
                }
            }
        }
    };
    private CustomMessageListener jKg = new CustomMessageListener(0) { // from class: com.baidu.tieba.homepage.concern.d.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long) && d.this.jJX != null && d.this.jJX.hot_recomforum != null && !com.baidu.tbadk.core.util.y.isEmpty(d.this.jJX.hot_recomforum.tab_list)) {
                long longValue = ((Long) customResponsedMessage.getData()).longValue();
                DiscoverHotForum.Builder builder = new DiscoverHotForum.Builder(d.this.jJX.hot_recomforum);
                if (c.a(builder, longValue, customResponsedMessage.getCmd() == 2001335)) {
                    d.this.jJX.hot_recomforum = builder.build(true);
                    d.this.a(new DataRes.Builder(d.this.jJX.build(true)));
                }
            }
        }
    };
    RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.concern.d.7
        private int jKl = 0;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (d.this.fGc != null && !d.this.mIsBackground) {
                d.this.fGc.m(recyclerView, i);
            }
            if (i == 0) {
                t.csg().bPr();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921517, Boolean.valueOf(d.this.mIsBackground)));
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
            if (d.this.fGc != null && !d.this.mIsBackground) {
                d.this.fGc.onScroll(this.jKl, i);
            }
            this.jKl = i;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921517, Boolean.valueOf(d.this.mIsBackground)));
        }
    };
    private CustomMessageListener jqg = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.homepage.concern.d.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && d.this.jJX != null && !com.baidu.tieba.lego.card.d.a.isEmpty(d.this.jJW)) {
                String str = (String) customResponsedMessage.getData();
                if (!TextUtils.isEmpty(str)) {
                    com.baidu.tieba.recapp.a.i(str, d.this.jJW);
                    com.baidu.tieba.recapp.a.i(str, d.this.jJX.app_list);
                    com.baidu.tieba.recapp.a.i(str, d.this.jKf);
                    com.baidu.tieba.recapp.a.fM(d.this.jJW);
                    if (d.this.jKc != null) {
                        d.this.jKc.cv(new ArrayList(d.this.jJW));
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921517, Boolean.valueOf(d.this.mIsBackground)));
                }
            }
        }
    };
    private View.OnTouchListener fGd = new View.OnTouchListener() { // from class: com.baidu.tieba.homepage.concern.d.9
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (d.this.frt != null) {
                d.this.frt.onTouch(view, motionEvent);
            }
            if (d.this.jxj != null) {
                d.this.jxj.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private CustomMessageListener jKh = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.homepage.concern.d.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.this.g(customResponsedMessage);
        }
    };
    private CustomMessageListener iBJ = new CustomMessageListener(CmdConfigCustom.CMD_THREAD_NOT_EXIST_WHEN_ENTER_PB) { // from class: com.baidu.tieba.homepage.concern.d.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.this.g(customResponsedMessage);
        }
    };
    private CustomMessageListener jKi = new CustomMessageListener(2921425) { // from class: com.baidu.tieba.homepage.concern.d.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.this.cNI();
        }
    };

    /* loaded from: classes22.dex */
    public interface a {
        void Mi(String str);

        void af(boolean z, boolean z2);

        void cNC();

        void cND();

        void onError(int i, String str);
    }

    public void setTabInForeBackgroundState(boolean z) {
        this.mIsBackground = z;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921517, Boolean.valueOf(this.mIsBackground)));
    }

    public void qf(boolean z) {
        this.mIsBackground = z;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921517, Boolean.valueOf(this.mIsBackground)));
    }

    public d(e<?> eVar, BdTypeRecyclerView bdTypeRecyclerView, com.baidu.tieba.homepage.concern.a aVar, BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout) {
        this.iYU = bdTypeRecyclerView;
        this.iYU.setOnTouchListener(this.fGd);
        this.jxj = new com.baidu.tieba.g.a();
        this.jKd = new com.baidu.tieba.homepage.concern.b.a();
        this.jKc = aVar;
        bdTypeRecyclerView.setOnScrollListener(this.mOnScrollListener);
        this.jJP = bigdaySwipeRefreshLayout;
        rr(false);
    }

    public void s(BdUniqueId bdUniqueId) {
        this.jKh.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.jKh);
        this.iBJ.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.iBJ);
        this.jKi.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.jKi);
        this.eTG.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.eTG);
        this.jKg.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_LIKE_FORUM, this.jKg);
        MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_UNLIKE_FORUM, this.jKg);
        this.jqg.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.jqg);
    }

    public void setRecommendFrsNavigationAnimDispatcher(z zVar) {
        if (zVar != null) {
            this.fGc = zVar.bGK();
            this.frt = zVar.bGL();
        }
    }

    public void update() {
        if (cNJ() && !this.jKa) {
            bmf();
        } else {
            bme();
        }
    }

    public void cNE() {
        this.jJY = new DataRes.Builder(this.jJX.build(true));
    }

    public void cNF() {
        this.jJX = new DataRes.Builder(this.jJY.build(true));
    }

    public void cNG() {
        bme();
    }

    public void bRM() {
        if (!isLoading() && this.hasMore && this.jJV != null) {
            setIsLoading(true);
            this.jJV.Mi(this.pageTag);
        }
    }

    public void a(boolean z, DataRes dataRes, int i, String str) {
        setIsLoading(false);
        if (i != 0 || dataRes == null || !a(true, z, dataRes)) {
            if (i == 0 && com.baidu.tbadk.core.util.y.getCount(this.jJW) == 0 && this.jJV != null) {
                this.jJV.cND();
                if (this.jJP != null) {
                    this.jJP.setRefreshing(false);
                    return;
                }
                return;
            } else if (this.jJW.size() > 0) {
                if (this.jJV != null) {
                    this.jJV.onError(1, str);
                }
            } else if (this.jJV != null) {
                this.jJV.onError(2, str);
            }
        } else {
            if (this.jJV != null) {
                this.jJV.af(z, false);
            }
            if (z) {
                cvq();
            }
        }
        if (this.jJP != null) {
            this.jJP.setRefreshing(false);
        }
    }

    public void rq(boolean z) {
        if (z) {
            this.jKc.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bme() {
        if (this.jJV != null) {
            this.jJV.cNC();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(DataRes dataRes) {
        this.jKa = true;
        rr(true);
        if (dataRes != null) {
            if (a(false, true, dataRes)) {
                if (this.jJV != null) {
                    this.jJV.af(false, true);
                    return;
                }
                return;
            }
            bme();
            return;
        }
        bme();
    }

    private List<q> a(boolean z, DataRes.Builder builder, boolean z2) {
        if (this.jJX == null) {
            this.jJX = new DataRes.Builder();
        }
        if (builder == null) {
            builder = new DataRes.Builder();
        }
        com.baidu.tieba.homepage.personalize.model.c a2 = this.jKd.a(z, this.jJX, builder, z2 ? 0 : 1);
        if (a2 == null) {
            return null;
        }
        return a2.fVe;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setList(List<q> list) {
        this.jKc.cv(list);
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x00ce  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean a(boolean z, boolean z2, DataRes dataRes) {
        q qVar;
        boolean z3;
        if (dataRes == null) {
            return false;
        }
        this.mPn = z2 ? 1 : this.mPn + 1;
        int eN = this.mPn == 1 ? 0 : com.baidu.tieba.lego.card.d.a.eN(this.jJX.thread_info);
        this.pageTag = dataRes.page_tag;
        this.jJZ = new DataRes.Builder(dataRes);
        if (cNJ()) {
            Mk(this.pageTag);
        }
        LinkedList linkedList = new LinkedList();
        DataRes.Builder builder = new DataRes.Builder(dataRes);
        this.jKe = builder.user_tips_type.intValue();
        if (dataRes.req_unix != null) {
            com.baidu.tbadk.core.sharedPref.b.bsO().putLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(SharedPrefConfig.CONCERN_DATA_RES_REQUEST_TIME), dataRes.req_unix.longValue());
        }
        List<q> a2 = a(z, builder, z2);
        a(a2, builder, eN);
        this.jKb = false;
        if (a2 != null && TbadkCoreApplication.isLogin()) {
            if (com.baidu.tbadk.core.util.y.isEmpty(a2) || (com.baidu.tbadk.core.util.y.getCount(a2) == 1 && (com.baidu.tbadk.core.util.y.getItem(a2, 0) instanceof com.baidu.tieba.homepage.concern.a.a))) {
                if (3 == this.jKe) {
                    com.baidu.tieba.homepage.concern.a.b bVar = new com.baidu.tieba.homepage.concern.a.b();
                    bVar.jLq = com.baidu.tieba.homepage.concern.a.b.jLl;
                    bVar.jLn = 3;
                    a2.add(bVar);
                    this.jKb = true;
                } else if (2 == this.jKe) {
                    com.baidu.tieba.homepage.concern.a.b bVar2 = new com.baidu.tieba.homepage.concern.a.b();
                    bVar2.jLq = com.baidu.tieba.homepage.concern.a.b.jLl;
                    bVar2.jLn = 2;
                    a2.add(bVar2);
                    this.jKb = true;
                }
            }
            linkedList.addAll(a2);
        }
        if (!au.isEmpty(builder.user_tips) && 2 == this.jKe) {
            com.baidu.tieba.homepage.concern.a.b bVar3 = new com.baidu.tieba.homepage.concern.a.b();
            bVar3.jLn = builder.user_tips_type.intValue();
            bVar3.tipString = builder.user_tips;
            if (builder.user_tips_type.intValue() == 4) {
                bVar3.jLo = true;
            } else {
                bVar3.jLp = true;
            }
            if (cNJ() && (bVar3.jLn == 2 || bVar3.jLn == 3)) {
                if (linkedList.size() > 0) {
                    bVar3.jLn = 0;
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
            if (this.jJW.isEmpty()) {
                return false;
            }
            Iterator<q> it = this.jJW.iterator();
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
                this.jJW.remove(qVar);
            }
            this.jKc.cv(this.jJW);
            return false;
        }
        this.jJW.clear();
        this.jJW.addAll(linkedList);
        if (z2) {
            this.jJX.page_tag = dataRes.page_tag;
            this.jJX.has_more = dataRes.has_more;
            this.jJX.user_list = dataRes.user_list;
            this.jJX.user_tips_type = dataRes.user_tips_type;
            this.jJX.user_tips = dataRes.user_tips;
            this.jJX.last_tips = dataRes.last_tips;
        }
        this.jJX.banner_user_story = dataRes.banner_user_story;
        this.jJX.banner_follow_live = dataRes.banner_follow_live;
        this.jJX.hot_recomforum = dataRes.hot_recomforum;
        this.jJX.top_tips = dataRes.top_tips;
        this.jJX.top_user_info = dataRes.top_user_info;
        if (this.jKe == 2 || this.jKe == 3) {
            this.jJX.user_tips_type = dataRes.user_tips_type;
            this.jJX.user_tips = dataRes.user_tips;
        }
        this.jKc.cv(this.jJW);
        return true;
    }

    private void a(List<q> list, DataRes.Builder builder, int i) {
        List<al> dK = dK(com.baidu.tieba.recapp.a.r(builder.app_list, "CONCERN"));
        if (this.jJX == null) {
            this.jJX = new DataRes.Builder();
        }
        if (com.baidu.tieba.lego.card.d.a.isEmpty(this.jJX.app_list)) {
            this.jJX.app_list = new ArrayList();
        }
        this.jJX.app_list.addAll(builder.app_list);
        if (this.mPn == 1 || i == 0) {
            this.jKf.clear();
        }
        dK.addAll(this.jKf);
        if (!com.baidu.tieba.lego.card.d.a.isEmpty(dK)) {
            this.jKf = com.baidu.tieba.recapp.a.b(dK, list, i);
        }
        com.baidu.tieba.recapp.a.a(list, this.mPn, "CONCERN");
        dL(list);
    }

    private List<al> dK(List<q> list) {
        ArrayList arrayList = new ArrayList();
        for (q qVar : list) {
            if (qVar instanceof AdvertAppInfo) {
                arrayList.add(new com.baidu.tieba.card.data.d((AdvertAppInfo) qVar));
            } else if (qVar instanceof com.baidu.tieba.card.data.d) {
                arrayList.add((com.baidu.tieba.card.data.d) qVar);
            }
        }
        return arrayList;
    }

    private void dL(List<q> list) {
        com.baidu.tieba.recapp.report.b.dGe().bG("tag_home_concern_tab", com.baidu.tieba.recapp.a.fL(list));
    }

    private void bmf() {
        long currentTimeMillis = System.currentTimeMillis();
        long cNM = cNM();
        long j = currentTimeMillis - cNM;
        if (cNM == 0 || j > 86400000) {
            ad.a(new ac<DataRes>() { // from class: com.baidu.tieba.homepage.concern.d.10
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.ac
                /* renamed from: cNO */
                public DataRes doInBackground() {
                    com.baidu.tbadk.core.c.a.brq().clearByteCacheWithSapce("tb.concern_page_all", TbadkCoreApplication.getCurrentAccount());
                    return null;
                }
            }, new m<DataRes>() { // from class: com.baidu.tieba.homepage.concern.d.11
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.m
                /* renamed from: b */
                public void onReturnDataInUI(DataRes dataRes) {
                    d.this.a((DataRes) null);
                }
            });
        } else {
            ad.a(new ac<DataRes>() { // from class: com.baidu.tieba.homepage.concern.d.12
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.ac
                /* renamed from: cNO */
                public DataRes doInBackground() {
                    l<byte[]> dM = com.baidu.tbadk.core.c.a.brq().dM("tb.concern_page_all", TbadkCoreApplication.getCurrentAccount());
                    if (dM == null) {
                        return null;
                    }
                    byte[] bArr = dM.get("0");
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
            }, new m<DataRes>() { // from class: com.baidu.tieba.homepage.concern.d.13
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.m
                /* renamed from: b */
                public void onReturnDataInUI(DataRes dataRes) {
                    d.this.a(dataRes);
                }
            });
        }
    }

    private void cvq() {
        if (this.jJZ != null) {
            a(this.jJZ);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final DataRes.Builder builder) {
        if (cNJ()) {
            ad.a(new ac<Object>() { // from class: com.baidu.tieba.homepage.concern.d.2
                @Override // com.baidu.tbadk.util.ac
                public Object doInBackground() {
                    DataRes.Builder builder2 = new DataRes.Builder(builder.build(true));
                    l<byte[]> dM = com.baidu.tbadk.core.c.a.brq().dM("tb.concern_page_all", TbadkCoreApplication.getCurrentAccount());
                    try {
                        DataRes build = builder2.build(true);
                        if (build != null && !com.baidu.tbadk.core.util.y.isEmpty(build.thread_info)) {
                            dM.setForever("0", build.toByteArray());
                            d.Ml(d.this.pageTag);
                            d.gx(System.currentTimeMillis());
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
        this.jJV = aVar;
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

    public boolean cNH() {
        return this.jKb;
    }

    public void onDestroy() {
        this.jKc.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(CustomResponsedMessage<?> customResponsedMessage) {
        ThreadInfo threadInfo;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.jJX != null && com.baidu.tbadk.core.util.y.getCount(this.jJX.thread_info) != 0 && com.baidu.tbadk.core.util.y.getCount(this.jJW) != 0) {
            String optString = ((JSONObject) customResponsedMessage.getData()).optString("tid");
            if (!StringUtils.isNull(optString)) {
                Iterator<q> it = this.jJW.iterator();
                boolean z = false;
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    q next = it.next();
                    if (next instanceof com.baidu.tieba.card.data.b) {
                        com.baidu.tieba.card.data.b bVar = (com.baidu.tieba.card.data.b) next;
                        if (bVar.bmn() != null && bVar.bmn().getTid() != null) {
                            if (bVar.bmn().getTid().equals(optString)) {
                                z = true;
                                it.remove();
                            } else if (z) {
                                if (this.jKc != null) {
                                    this.jKc.cv(this.jJW);
                                }
                            }
                        }
                    }
                    z = z;
                }
                long j = com.baidu.adp.lib.f.b.toLong(optString, 0L);
                for (int i = 0; i < this.jJX.thread_info.size(); i++) {
                    ConcernData concernData = this.jJX.thread_info.get(i);
                    if (concernData != null && (threadInfo = concernData.thread_list) != null && threadInfo.tid != null && threadInfo.tid.longValue() == j) {
                        this.jJX.thread_info.remove(i);
                        cvq();
                        return;
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cNI() {
        if (this.jJX != null && com.baidu.tbadk.core.util.y.getCount(this.jJX.thread_info) != 0 && com.baidu.tbadk.core.util.y.getCount(this.jJW) != 0) {
            int i = 0;
            while (true) {
                if (i >= this.jJW.size()) {
                    break;
                } else if (!(this.jJW.get(i) instanceof com.baidu.tieba.homepage.concern.a.a)) {
                    i++;
                } else {
                    this.jJW.remove(i);
                    if (this.jKc != null) {
                        this.jKc.cv(this.jJW);
                    }
                }
            }
            for (int i2 = 0; i2 < this.jJX.thread_info.size(); i2++) {
                if (com.baidu.tieba.homepage.concern.a.a.a(this.jJX.thread_info.get(i2))) {
                    this.jJX.thread_info.remove(i2);
                    cvq();
                    return;
                }
            }
        }
    }

    public static boolean cNJ() {
        return com.baidu.tbadk.a.d.bkz() && com.baidu.tbadk.core.sharedPref.b.bsO().getInt("key_home_concern_all_status", 0) == 0;
    }

    public static void Mk(String str) {
        com.baidu.tbadk.core.sharedPref.b.bsO().putString(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("key_home_concern_all_status_cache_nextpage_key"), str);
    }

    public static String cNK() {
        return com.baidu.tbadk.core.sharedPref.b.bsO().getString(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("key_home_concern_all_status_cache_nextpage_key"), "");
    }

    public static void Ml(String str) {
        com.baidu.tbadk.core.sharedPref.b.bsO().putString(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("key_home_concern_all_status_cache_nextpage_update_key"), str);
    }

    public static String cNL() {
        return com.baidu.tbadk.core.sharedPref.b.bsO().getString(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("key_home_concern_all_status_cache_nextpage_update_key"), "");
    }

    public static void gx(long j) {
        com.baidu.tbadk.core.sharedPref.b.bsO().putLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("key_home_concern_all_status_cache_time"), j);
    }

    public static long cNM() {
        return com.baidu.tbadk.core.sharedPref.b.bsO().getLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("key_home_concern_all_status_cache_time"), 0L);
    }

    public static boolean cNN() {
        return com.baidu.tbadk.core.sharedPref.b.bsO().getBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("key_home_concern_all_status_cache_loaded"), false);
    }

    public static void rr(boolean z) {
        com.baidu.tbadk.core.sharedPref.b.bsO().putBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("key_home_concern_all_status_cache_loaded"), z);
    }
}
