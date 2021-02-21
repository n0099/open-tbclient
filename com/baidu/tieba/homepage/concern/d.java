package com.baidu.tieba.homepage.concern;

import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.f;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.n;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.am;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tbadk.util.aa;
import com.baidu.tbadk.util.ae;
import com.baidu.tbadk.util.af;
import com.baidu.tbadk.util.m;
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
/* loaded from: classes2.dex */
public class d {
    private z fNk;
    private View.OnTouchListener fyG;
    private boolean hasMore;
    private com.baidu.tieba.f.a jKU;
    private final BdTypeRecyclerView jmy;
    private final com.baidu.tieba.homepage.concern.a kaA;
    private final com.baidu.tieba.homepage.concern.b.a kaB;
    private int kaC;
    private BigdaySwipeRefreshLayout kan;
    private DataRes.Builder kav;
    private DataRes.Builder kaw;
    private DataRes.Builder kax;
    private String pageTag;
    private a kat = null;
    private final LinkedList<n> kau = new LinkedList<>();
    private boolean mIsLoading = false;
    private boolean kay = false;
    private boolean kaz = false;
    private boolean mIsBackground = false;
    private int mPn = 0;
    private List<am> kaD = new ArrayList();
    private CustomMessageListener faJ = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.homepage.concern.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (data.fsD == null) {
                    if (!data.isSucc) {
                        BdToast.a(TbadkCoreApplication.getInst().getContext(), updateAttentionMessage.getData().errorString, R.drawable.icon_pure_toast_mistake40_svg, 3000, true).bqD();
                    } else if (!data.isAttention) {
                        Iterator it = d.this.kau.iterator();
                        while (it.hasNext()) {
                            Object next = it.next();
                            if ((next instanceof com.baidu.tieba.card.data.b) && az.h(((com.baidu.tieba.card.data.b) next).bln(), data.toUid)) {
                                it.remove();
                            }
                        }
                        com.baidu.tieba.recapp.a.fL(d.this.kau);
                        d.this.kaD.clear();
                        if (d.this.kau.size() < 9) {
                            d.this.blc();
                        } else {
                            d.this.setList(d.this.kau);
                            d.this.kaA.notifyDataSetChanged();
                            if (d.this.kat != null) {
                                d.this.kat.ah(false, false);
                            }
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921517, Boolean.valueOf(d.this.mIsBackground)));
                    }
                }
            }
        }
    };
    private CustomMessageListener kaE = new CustomMessageListener(0) { // from class: com.baidu.tieba.homepage.concern.d.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long) && d.this.kav != null && d.this.kav.hot_recomforum != null && !y.isEmpty(d.this.kav.hot_recomforum.tab_list)) {
                long longValue = ((Long) customResponsedMessage.getData()).longValue();
                DiscoverHotForum.Builder builder = new DiscoverHotForum.Builder(d.this.kav.hot_recomforum);
                if (c.a(builder, longValue, customResponsedMessage.getCmd() == 2001335)) {
                    d.this.kav.hot_recomforum = builder.build(true);
                    d.this.a(new DataRes.Builder(d.this.kav.build(true)));
                }
            }
        }
    };
    RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.concern.d.7
        private int kaJ = 0;

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (d.this.fNk != null && !d.this.mIsBackground) {
                d.this.fNk.q(recyclerView, i);
            }
            if (i == 0) {
                t.csB().bOM();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921517, Boolean.valueOf(d.this.mIsBackground)));
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            int i3;
            int i4;
            if (recyclerView == null || !(recyclerView instanceof BdRecyclerView)) {
                i3 = 0;
                i4 = 0;
            } else {
                int firstVisiblePosition = ((BdRecyclerView) recyclerView).getFirstVisiblePosition();
                i3 = ((BdRecyclerView) recyclerView).getLastVisiblePosition();
                i4 = firstVisiblePosition;
            }
            onScroll(i4, (i3 - i4) + 1);
        }

        public void onScroll(int i, int i2) {
            if (d.this.fNk != null && !d.this.mIsBackground) {
                d.this.fNk.onScroll(this.kaJ, i);
            }
            this.kaJ = i;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921517, Boolean.valueOf(d.this.mIsBackground)));
        }
    };
    private CustomMessageListener jpA = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.homepage.concern.d.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && d.this.kav != null && !com.baidu.tieba.lego.card.c.a.isEmpty(d.this.kau)) {
                String str = (String) customResponsedMessage.getData();
                if (!TextUtils.isEmpty(str)) {
                    com.baidu.tieba.recapp.a.i(str, d.this.kau);
                    com.baidu.tieba.recapp.a.i(str, d.this.kav.app_list);
                    com.baidu.tieba.recapp.a.i(str, d.this.kaD);
                    com.baidu.tieba.recapp.a.fK(d.this.kau);
                    if (d.this.kaA != null) {
                        d.this.kaA.cx(new ArrayList(d.this.kau));
                    }
                    d.this.dQ(d.this.kau);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921517, Boolean.valueOf(d.this.mIsBackground)));
                }
            }
        }
    };
    private View.OnTouchListener bST = new View.OnTouchListener() { // from class: com.baidu.tieba.homepage.concern.d.9
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (d.this.fyG != null) {
                d.this.fyG.onTouch(view, motionEvent);
            }
            if (d.this.jKU != null) {
                d.this.jKU.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private CustomMessageListener kaF = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.homepage.concern.d.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.this.g(customResponsedMessage);
        }
    };
    private CustomMessageListener iPm = new CustomMessageListener(CmdConfigCustom.CMD_THREAD_NOT_EXIST_WHEN_ENTER_PB) { // from class: com.baidu.tieba.homepage.concern.d.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.this.g(customResponsedMessage);
        }
    };
    private CustomMessageListener kaG = new CustomMessageListener(2921425) { // from class: com.baidu.tieba.homepage.concern.d.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.this.cPb();
        }
    };

    /* loaded from: classes2.dex */
    public interface a {
        void a(com.baidu.tbadk.util.c cVar);

        void a(String str, com.baidu.tbadk.util.c cVar);

        void ah(boolean z, boolean z2);

        void cOW();

        void onError(int i, String str);
    }

    public void setTabInForeBackgroundState(boolean z) {
        this.mIsBackground = z;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921517, Boolean.valueOf(this.mIsBackground)));
    }

    public void qJ(boolean z) {
        this.mIsBackground = z;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921517, Boolean.valueOf(this.mIsBackground)));
    }

    public d(f<?> fVar, BdTypeRecyclerView bdTypeRecyclerView, com.baidu.tieba.homepage.concern.a aVar, BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout) {
        this.jmy = bdTypeRecyclerView;
        this.jmy.setOnTouchListener(this.bST);
        this.jKU = new com.baidu.tieba.f.a();
        this.kaB = new com.baidu.tieba.homepage.concern.b.a();
        this.kaA = aVar;
        bdTypeRecyclerView.setOnScrollListener(this.mOnScrollListener);
        this.kan = bigdaySwipeRefreshLayout;
        rW(false);
    }

    public void s(BdUniqueId bdUniqueId) {
        this.kaF.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.kaF);
        this.iPm.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.iPm);
        this.kaG.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.kaG);
        this.faJ.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.faJ);
        this.kaE.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_LIKE_FORUM, this.kaE);
        MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_UNLIKE_FORUM, this.kaE);
        this.jpA.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.jpA);
    }

    public void setRecommendFrsNavigationAnimDispatcher(aa aaVar) {
        if (aaVar != null) {
            this.fNk = aaVar.bFF();
            this.fyG = aaVar.bFG();
        }
    }

    public void update() {
        if (cPc() && !this.kay) {
            bld();
        } else {
            blc();
        }
    }

    public void cOX() {
        this.kaw = new DataRes.Builder(this.kav.build(true));
    }

    public void cOY() {
        this.kav = new DataRes.Builder(this.kaw.build(true));
    }

    public void cOZ() {
        blc();
    }

    public void bRj() {
        if (!isLoading() && this.hasMore) {
            com.baidu.tbadk.util.c rU = rU(false);
            if (this.kat != null) {
                setIsLoading(true);
                this.kat.a(this.pageTag, rU);
            }
        }
    }

    private com.baidu.tbadk.util.c rU(boolean z) {
        String y = com.baidu.tieba.recapp.a.y(this.kau, z);
        com.baidu.tbadk.util.c cVar = new com.baidu.tbadk.util.c();
        cVar.adFloorInfo = y;
        return cVar;
    }

    public void a(boolean z, DataRes dataRes, int i, String str) {
        setIsLoading(false);
        if (i != 0 || dataRes == null || !a(true, z, dataRes)) {
            if (i == 0 && y.getCount(this.kau) == 0 && this.kat != null) {
                this.kat.cOW();
                if (this.kan != null) {
                    this.kan.setRefreshing(false);
                    return;
                }
                return;
            } else if (this.kau.size() > 0) {
                if (this.kat != null) {
                    this.kat.onError(1, str);
                }
            } else if (this.kat != null) {
                this.kat.onError(2, str);
            }
        } else {
            if (this.kat != null) {
                this.kat.ah(z, false);
            }
            if (z) {
                cvM();
            }
        }
        if (this.kan != null) {
            this.kan.setRefreshing(false);
        }
    }

    public void rV(boolean z) {
        if (z) {
            this.kaA.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void blc() {
        com.baidu.tbadk.util.c rU = rU(true);
        if (this.kat != null) {
            this.kat.a(rU);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(DataRes dataRes) {
        this.kay = true;
        rW(true);
        if (dataRes != null) {
            if (a(false, true, dataRes)) {
                if (this.kat != null) {
                    this.kat.ah(false, true);
                    return;
                }
                return;
            }
            blc();
            return;
        }
        blc();
    }

    private List<n> a(boolean z, DataRes.Builder builder, boolean z2) {
        if (this.kav == null) {
            this.kav = new DataRes.Builder();
        }
        if (builder == null) {
            builder = new DataRes.Builder();
        }
        com.baidu.tieba.homepage.personalize.model.c a2 = this.kaB.a(z, this.kav, builder, z2 ? 0 : 1);
        if (a2 == null) {
            return null;
        }
        return a2.gcy;
    }

    public void aC(cb cbVar) {
        cbVar.jD(true);
        com.baidu.tbadk.a.a.a.a(cbVar);
        List<n> a2 = this.kaB.a(cbVar, -1, null);
        if ((this.kav == null || y.getCount(this.kav.thread_info) <= 0) && y.getCount(this.kau) <= 1) {
            this.kau.clear();
        }
        this.kau.addAll(0, a2);
        this.kaA.cx(this.kau);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setList(List<n> list) {
        this.kaA.cx(list);
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x00ce  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean a(boolean z, boolean z2, DataRes dataRes) {
        n nVar;
        boolean z3;
        if (dataRes == null) {
            return false;
        }
        this.mPn = z2 ? 1 : this.mPn + 1;
        int eL = this.mPn == 1 ? 0 : com.baidu.tieba.lego.card.c.a.eL(this.kau);
        this.pageTag = dataRes.page_tag;
        this.kax = new DataRes.Builder(dataRes);
        if (cPc()) {
            LO(this.pageTag);
        }
        LinkedList linkedList = new LinkedList();
        DataRes.Builder builder = new DataRes.Builder(dataRes);
        this.kaC = builder.user_tips_type.intValue();
        if (dataRes.req_unix != null) {
            com.baidu.tbadk.core.sharedPref.b.brQ().putLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(SharedPrefConfig.CONCERN_DATA_RES_REQUEST_TIME), dataRes.req_unix.longValue());
        }
        List<n> a2 = a(z, builder, z2);
        a(a2, builder, eL);
        this.kaz = false;
        if (a2 != null && TbadkCoreApplication.isLogin()) {
            if (y.isEmpty(a2) || (y.getCount(a2) == 1 && (y.getItem(a2, 0) instanceof com.baidu.tieba.homepage.concern.a.a))) {
                if (3 == this.kaC) {
                    com.baidu.tieba.homepage.concern.a.b bVar = new com.baidu.tieba.homepage.concern.a.b();
                    bVar.kbQ = com.baidu.tieba.homepage.concern.a.b.kbL;
                    bVar.kbN = 3;
                    a2.add(bVar);
                    this.kaz = true;
                } else if (2 == this.kaC) {
                    com.baidu.tieba.homepage.concern.a.b bVar2 = new com.baidu.tieba.homepage.concern.a.b();
                    bVar2.kbQ = com.baidu.tieba.homepage.concern.a.b.kbL;
                    bVar2.kbN = 2;
                    a2.add(bVar2);
                    this.kaz = true;
                }
            }
            linkedList.addAll(a2);
        }
        if (!au.isEmpty(builder.user_tips) && 2 == this.kaC) {
            com.baidu.tieba.homepage.concern.a.b bVar3 = new com.baidu.tieba.homepage.concern.a.b();
            bVar3.kbN = builder.user_tips_type.intValue();
            bVar3.tipString = builder.user_tips;
            if (builder.user_tips_type.intValue() == 4) {
                bVar3.kbO = true;
            } else {
                bVar3.kbP = true;
            }
            if (cPc() && (bVar3.kbN == 2 || bVar3.kbN == 3)) {
                if (linkedList.size() > 0) {
                    bVar3.kbN = 0;
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
        if (y.isEmpty(linkedList)) {
            if (this.kau.isEmpty()) {
                return false;
            }
            Iterator<n> it = this.kau.iterator();
            while (true) {
                if (!it.hasNext()) {
                    nVar = null;
                    break;
                }
                nVar = it.next();
                if (nVar instanceof com.baidu.tbadk.data.a) {
                    break;
                }
            }
            if (nVar != null) {
                this.kau.remove(nVar);
            }
            this.kaA.cx(this.kau);
            return false;
        }
        this.kau.clear();
        this.kau.addAll(linkedList);
        if (z2) {
            this.kav.page_tag = dataRes.page_tag;
            this.kav.has_more = dataRes.has_more;
            this.kav.user_list = dataRes.user_list;
            this.kav.user_tips_type = dataRes.user_tips_type;
            this.kav.user_tips = dataRes.user_tips;
            this.kav.last_tips = dataRes.last_tips;
        }
        this.kav.banner_user_story = dataRes.banner_user_story;
        this.kav.banner_follow_live = dataRes.banner_follow_live;
        this.kav.hot_recomforum = dataRes.hot_recomforum;
        this.kav.top_tips = dataRes.top_tips;
        this.kav.top_user_info = dataRes.top_user_info;
        if (this.kaC == 2 || this.kaC == 3) {
            this.kav.user_tips_type = dataRes.user_tips_type;
            this.kav.user_tips = dataRes.user_tips;
        }
        this.kaA.cx(this.kau);
        return true;
    }

    private void a(List<n> list, DataRes.Builder builder, int i) {
        List<am> dP = dP(com.baidu.tieba.recapp.a.p(builder.app_list, "CONCERN"));
        if (this.kav == null) {
            this.kav = new DataRes.Builder();
        }
        if (com.baidu.tieba.lego.card.c.a.isEmpty(this.kav.app_list)) {
            this.kav.app_list = new ArrayList();
        }
        this.kav.app_list.addAll(builder.app_list);
        if (this.mPn == 1 || i == 0) {
            this.kaD.clear();
        }
        dP.addAll(this.kaD);
        if (!com.baidu.tieba.lego.card.c.a.isEmpty(dP)) {
            this.kaD = com.baidu.tieba.recapp.a.b(dP, list, i);
        }
        com.baidu.tieba.recapp.a.fK(list);
        com.baidu.tieba.recapp.a.a(list, this.mPn, "CONCERN");
        dQ(list);
    }

    private List<am> dP(List<am> list) {
        ArrayList arrayList = new ArrayList();
        for (am amVar : list) {
            if (amVar instanceof AdvertAppInfo) {
                arrayList.add(new com.baidu.tieba.card.data.d((AdvertAppInfo) amVar));
            } else if (amVar instanceof com.baidu.tieba.card.data.d) {
                arrayList.add((com.baidu.tieba.card.data.d) amVar);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dQ(List<n> list) {
        com.baidu.tieba.recapp.report.b.dEt().bO("CONCERN", com.baidu.tieba.recapp.a.fJ(list));
    }

    private void bld() {
        long currentTimeMillis = System.currentTimeMillis();
        long cPf = cPf();
        long j = currentTimeMillis - cPf;
        if (cPf == 0 || j > 86400000) {
            af.a(new ae<DataRes>() { // from class: com.baidu.tieba.homepage.concern.d.10
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.ae
                /* renamed from: cPh */
                public DataRes doInBackground() {
                    com.baidu.tbadk.core.c.a.bqr().clearByteCacheWithSapce("tb.concern_page_all", TbadkCoreApplication.getCurrentAccount());
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
            af.a(new ae<DataRes>() { // from class: com.baidu.tieba.homepage.concern.d.12
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.ae
                /* renamed from: cPh */
                public DataRes doInBackground() {
                    l<byte[]> dE = com.baidu.tbadk.core.c.a.bqr().dE("tb.concern_page_all", TbadkCoreApplication.getCurrentAccount());
                    if (dE == null) {
                        return null;
                    }
                    byte[] bArr = dE.get("0");
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

    private void cvM() {
        if (this.kax != null) {
            a(this.kax);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final DataRes.Builder builder) {
        if (cPc()) {
            af.a(new ae<Object>() { // from class: com.baidu.tieba.homepage.concern.d.2
                @Override // com.baidu.tbadk.util.ae
                public Object doInBackground() {
                    DataRes.Builder builder2 = new DataRes.Builder(builder.build(true));
                    l<byte[]> dE = com.baidu.tbadk.core.c.a.bqr().dE("tb.concern_page_all", TbadkCoreApplication.getCurrentAccount());
                    try {
                        DataRes build = builder2.build(true);
                        if (build != null && !y.isEmpty(build.thread_info)) {
                            dE.setForever("0", build.toByteArray());
                            d.LP(d.this.pageTag);
                            d.gC(System.currentTimeMillis());
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
        this.kat = aVar;
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

    public boolean cPa() {
        return this.kaz;
    }

    public void onDestroy() {
        this.kaA.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(CustomResponsedMessage<?> customResponsedMessage) {
        ThreadInfo threadInfo;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.kav != null && y.getCount(this.kav.thread_info) != 0 && y.getCount(this.kau) != 0) {
            String optString = ((JSONObject) customResponsedMessage.getData()).optString("tid");
            if (!StringUtils.isNull(optString)) {
                Iterator<n> it = this.kau.iterator();
                boolean z = false;
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    n next = it.next();
                    if (next instanceof com.baidu.tieba.card.data.b) {
                        com.baidu.tieba.card.data.b bVar = (com.baidu.tieba.card.data.b) next;
                        if (bVar.bln() != null && bVar.bln().getTid() != null) {
                            if (bVar.bln().getTid().equals(optString)) {
                                z = true;
                                it.remove();
                            } else if (z) {
                                if (this.kaA != null) {
                                    this.kaA.cx(this.kau);
                                }
                            }
                        }
                    }
                    z = z;
                }
                long j = com.baidu.adp.lib.f.b.toLong(optString, 0L);
                for (int i = 0; i < this.kav.thread_info.size(); i++) {
                    ConcernData concernData = this.kav.thread_info.get(i);
                    if (concernData != null && (threadInfo = concernData.thread_list) != null && threadInfo.tid != null && threadInfo.tid.longValue() == j) {
                        this.kav.thread_info.remove(i);
                        cvM();
                        return;
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cPb() {
        if (this.kav != null && y.getCount(this.kav.thread_info) != 0 && y.getCount(this.kau) != 0) {
            int i = 0;
            while (true) {
                if (i >= this.kau.size()) {
                    break;
                } else if (!(this.kau.get(i) instanceof com.baidu.tieba.homepage.concern.a.a)) {
                    i++;
                } else {
                    this.kau.remove(i);
                    if (this.kaA != null) {
                        this.kaA.cx(this.kau);
                    }
                }
            }
            for (int i2 = 0; i2 < this.kav.thread_info.size(); i2++) {
                if (com.baidu.tieba.homepage.concern.a.a.a(this.kav.thread_info.get(i2))) {
                    this.kav.thread_info.remove(i2);
                    cvM();
                    return;
                }
            }
        }
    }

    public static boolean cPc() {
        return com.baidu.tbadk.a.d.bjg() && com.baidu.tbadk.core.sharedPref.b.brQ().getInt("key_home_concern_all_status", 0) == 0;
    }

    public static void LO(String str) {
        com.baidu.tbadk.core.sharedPref.b.brQ().putString(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("key_home_concern_all_status_cache_nextpage_key"), str);
    }

    public static String cPd() {
        return com.baidu.tbadk.core.sharedPref.b.brQ().getString(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("key_home_concern_all_status_cache_nextpage_key"), "");
    }

    public static void LP(String str) {
        com.baidu.tbadk.core.sharedPref.b.brQ().putString(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("key_home_concern_all_status_cache_nextpage_update_key"), str);
    }

    public static String cPe() {
        return com.baidu.tbadk.core.sharedPref.b.brQ().getString(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("key_home_concern_all_status_cache_nextpage_update_key"), "");
    }

    public static void gC(long j) {
        com.baidu.tbadk.core.sharedPref.b.brQ().putLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("key_home_concern_all_status_cache_time"), j);
    }

    public static long cPf() {
        return com.baidu.tbadk.core.sharedPref.b.brQ().getLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("key_home_concern_all_status_cache_time"), 0L);
    }

    public static boolean cPg() {
        return com.baidu.tbadk.core.sharedPref.b.brQ().getBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("key_home_concern_all_status_cache_loaded"), false);
    }

    public static void rW(boolean z) {
        com.baidu.tbadk.core.sharedPref.b.brQ().putBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("key_home_concern_all_status_cache_loaded"), z);
    }
}
