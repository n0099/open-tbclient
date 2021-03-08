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
    private View.OnTouchListener fAf;
    private z fOK;
    private boolean hasMore;
    private com.baidu.tieba.f.a jMD;
    private final BdTypeRecyclerView joh;
    private final com.baidu.tieba.homepage.concern.a kcC;
    private final com.baidu.tieba.homepage.concern.b.a kcD;
    private int kcE;
    private BigdaySwipeRefreshLayout kcp;
    private DataRes.Builder kcx;
    private DataRes.Builder kcy;
    private DataRes.Builder kcz;
    private String pageTag;
    private a kcv = null;
    private final LinkedList<n> kcw = new LinkedList<>();
    private boolean mIsLoading = false;
    private boolean kcA = false;
    private boolean kcB = false;
    private boolean mIsBackground = false;
    private int mPn = 0;
    private List<am> kcF = new ArrayList();
    private CustomMessageListener fci = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.homepage.concern.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (data.fud == null) {
                    if (!data.isSucc) {
                        BdToast.a(TbadkCoreApplication.getInst().getContext(), updateAttentionMessage.getData().errorString, R.drawable.icon_pure_toast_mistake40_svg, 3000, true).bqF();
                    } else if (!data.isAttention) {
                        Iterator it = d.this.kcw.iterator();
                        while (it.hasNext()) {
                            Object next = it.next();
                            if ((next instanceof com.baidu.tieba.card.data.b) && az.h(((com.baidu.tieba.card.data.b) next).blp(), data.toUid)) {
                                it.remove();
                            }
                        }
                        com.baidu.tieba.recapp.a.fL(d.this.kcw);
                        d.this.kcF.clear();
                        if (d.this.kcw.size() < 9) {
                            d.this.ble();
                        } else {
                            d.this.setList(d.this.kcw);
                            d.this.kcC.notifyDataSetChanged();
                            if (d.this.kcv != null) {
                                d.this.kcv.ah(false, false);
                            }
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921517, Boolean.valueOf(d.this.mIsBackground)));
                    }
                }
            }
        }
    };
    private CustomMessageListener kcG = new CustomMessageListener(0) { // from class: com.baidu.tieba.homepage.concern.d.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long) && d.this.kcx != null && d.this.kcx.hot_recomforum != null && !y.isEmpty(d.this.kcx.hot_recomforum.tab_list)) {
                long longValue = ((Long) customResponsedMessage.getData()).longValue();
                DiscoverHotForum.Builder builder = new DiscoverHotForum.Builder(d.this.kcx.hot_recomforum);
                if (c.a(builder, longValue, customResponsedMessage.getCmd() == 2001335)) {
                    d.this.kcx.hot_recomforum = builder.build(true);
                    d.this.a(new DataRes.Builder(d.this.kcx.build(true)));
                }
            }
        }
    };
    RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.concern.d.7
        private int kcL = 0;

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (d.this.fOK != null && !d.this.mIsBackground) {
                d.this.fOK.q(recyclerView, i);
            }
            if (i == 0) {
                t.csH().bOS();
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
            if (d.this.fOK != null && !d.this.mIsBackground) {
                d.this.fOK.onScroll(this.kcL, i);
            }
            this.kcL = i;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921517, Boolean.valueOf(d.this.mIsBackground)));
        }
    };
    private CustomMessageListener jrj = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.homepage.concern.d.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && d.this.kcx != null && !com.baidu.tieba.lego.card.c.a.isEmpty(d.this.kcw)) {
                String str = (String) customResponsedMessage.getData();
                if (!TextUtils.isEmpty(str)) {
                    com.baidu.tieba.recapp.a.i(str, d.this.kcw);
                    com.baidu.tieba.recapp.a.i(str, d.this.kcx.app_list);
                    com.baidu.tieba.recapp.a.i(str, d.this.kcF);
                    com.baidu.tieba.recapp.a.fK(d.this.kcw);
                    if (d.this.kcC != null) {
                        d.this.kcC.cx(new ArrayList(d.this.kcw));
                    }
                    d.this.dQ(d.this.kcw);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921517, Boolean.valueOf(d.this.mIsBackground)));
                }
            }
        }
    };
    private View.OnTouchListener bUt = new View.OnTouchListener() { // from class: com.baidu.tieba.homepage.concern.d.9
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (d.this.fAf != null) {
                d.this.fAf.onTouch(view, motionEvent);
            }
            if (d.this.jMD != null) {
                d.this.jMD.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private CustomMessageListener kcH = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.homepage.concern.d.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.this.g(customResponsedMessage);
        }
    };
    private CustomMessageListener iQV = new CustomMessageListener(CmdConfigCustom.CMD_THREAD_NOT_EXIST_WHEN_ENTER_PB) { // from class: com.baidu.tieba.homepage.concern.d.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.this.g(customResponsedMessage);
        }
    };
    private CustomMessageListener kcI = new CustomMessageListener(2921425) { // from class: com.baidu.tieba.homepage.concern.d.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.this.cPi();
        }
    };

    /* loaded from: classes2.dex */
    public interface a {
        void a(com.baidu.tbadk.util.c cVar);

        void a(String str, com.baidu.tbadk.util.c cVar);

        void ah(boolean z, boolean z2);

        void cPd();

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
        this.joh = bdTypeRecyclerView;
        this.joh.setOnTouchListener(this.bUt);
        this.jMD = new com.baidu.tieba.f.a();
        this.kcD = new com.baidu.tieba.homepage.concern.b.a();
        this.kcC = aVar;
        bdTypeRecyclerView.setOnScrollListener(this.mOnScrollListener);
        this.kcp = bigdaySwipeRefreshLayout;
        rW(false);
    }

    public void t(BdUniqueId bdUniqueId) {
        this.kcH.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.kcH);
        this.iQV.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.iQV);
        this.kcI.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.kcI);
        this.fci.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.fci);
        this.kcG.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_LIKE_FORUM, this.kcG);
        MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_UNLIKE_FORUM, this.kcG);
        this.jrj.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.jrj);
    }

    public void setRecommendFrsNavigationAnimDispatcher(aa aaVar) {
        if (aaVar != null) {
            this.fOK = aaVar.bFJ();
            this.fAf = aaVar.bFK();
        }
    }

    public void update() {
        if (cPj() && !this.kcA) {
            blf();
        } else {
            ble();
        }
    }

    public void cPe() {
        this.kcy = new DataRes.Builder(this.kcx.build(true));
    }

    public void cPf() {
        this.kcx = new DataRes.Builder(this.kcy.build(true));
    }

    public void cPg() {
        ble();
    }

    public void bRp() {
        if (!isLoading() && this.hasMore) {
            com.baidu.tbadk.util.c rU = rU(false);
            if (this.kcv != null) {
                setIsLoading(true);
                this.kcv.a(this.pageTag, rU);
            }
        }
    }

    private com.baidu.tbadk.util.c rU(boolean z) {
        String y = com.baidu.tieba.recapp.a.y(this.kcw, z);
        com.baidu.tbadk.util.c cVar = new com.baidu.tbadk.util.c();
        cVar.adFloorInfo = y;
        return cVar;
    }

    public void a(boolean z, DataRes dataRes, int i, String str) {
        setIsLoading(false);
        if (i != 0 || dataRes == null || !a(true, z, dataRes)) {
            if (i == 0 && y.getCount(this.kcw) == 0 && this.kcv != null) {
                this.kcv.cPd();
                if (this.kcp != null) {
                    this.kcp.setRefreshing(false);
                    return;
                }
                return;
            } else if (this.kcw.size() > 0) {
                if (this.kcv != null) {
                    this.kcv.onError(1, str);
                }
            } else if (this.kcv != null) {
                this.kcv.onError(2, str);
            }
        } else {
            if (this.kcv != null) {
                this.kcv.ah(z, false);
            }
            if (z) {
                cvS();
            }
        }
        if (this.kcp != null) {
            this.kcp.setRefreshing(false);
        }
    }

    public void rV(boolean z) {
        if (z) {
            this.kcC.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ble() {
        com.baidu.tbadk.util.c rU = rU(true);
        if (this.kcv != null) {
            this.kcv.a(rU);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(DataRes dataRes) {
        this.kcA = true;
        rW(true);
        if (dataRes != null) {
            if (a(false, true, dataRes)) {
                if (this.kcv != null) {
                    this.kcv.ah(false, true);
                    return;
                }
                return;
            }
            ble();
            return;
        }
        ble();
    }

    private List<n> a(boolean z, DataRes.Builder builder, boolean z2) {
        if (this.kcx == null) {
            this.kcx = new DataRes.Builder();
        }
        if (builder == null) {
            builder = new DataRes.Builder();
        }
        com.baidu.tieba.homepage.personalize.model.c a2 = this.kcD.a(z, this.kcx, builder, z2 ? 0 : 1);
        if (a2 == null) {
            return null;
        }
        return a2.gdY;
    }

    public void aC(cb cbVar) {
        cbVar.jD(true);
        com.baidu.tbadk.a.a.a.a(cbVar);
        List<n> a2 = this.kcD.a(cbVar, -1, null);
        if ((this.kcx == null || y.getCount(this.kcx.thread_info) <= 0) && y.getCount(this.kcw) <= 1) {
            this.kcw.clear();
        }
        this.kcw.addAll(0, a2);
        this.kcC.cx(this.kcw);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setList(List<n> list) {
        this.kcC.cx(list);
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
        int eL = this.mPn == 1 ? 0 : com.baidu.tieba.lego.card.c.a.eL(this.kcw);
        this.pageTag = dataRes.page_tag;
        this.kcz = new DataRes.Builder(dataRes);
        if (cPj()) {
            LU(this.pageTag);
        }
        LinkedList linkedList = new LinkedList();
        DataRes.Builder builder = new DataRes.Builder(dataRes);
        this.kcE = builder.user_tips_type.intValue();
        if (dataRes.req_unix != null) {
            com.baidu.tbadk.core.sharedPref.b.brR().putLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(SharedPrefConfig.CONCERN_DATA_RES_REQUEST_TIME), dataRes.req_unix.longValue());
        }
        List<n> a2 = a(z, builder, z2);
        a(a2, builder, eL);
        this.kcB = false;
        if (a2 != null && TbadkCoreApplication.isLogin()) {
            if (y.isEmpty(a2) || (y.getCount(a2) == 1 && (y.getItem(a2, 0) instanceof com.baidu.tieba.homepage.concern.a.a))) {
                if (3 == this.kcE) {
                    com.baidu.tieba.homepage.concern.a.b bVar = new com.baidu.tieba.homepage.concern.a.b();
                    bVar.kdS = com.baidu.tieba.homepage.concern.a.b.kdN;
                    bVar.kdP = 3;
                    a2.add(bVar);
                    this.kcB = true;
                } else if (2 == this.kcE) {
                    com.baidu.tieba.homepage.concern.a.b bVar2 = new com.baidu.tieba.homepage.concern.a.b();
                    bVar2.kdS = com.baidu.tieba.homepage.concern.a.b.kdN;
                    bVar2.kdP = 2;
                    a2.add(bVar2);
                    this.kcB = true;
                }
            }
            linkedList.addAll(a2);
        }
        if (!au.isEmpty(builder.user_tips) && 2 == this.kcE) {
            com.baidu.tieba.homepage.concern.a.b bVar3 = new com.baidu.tieba.homepage.concern.a.b();
            bVar3.kdP = builder.user_tips_type.intValue();
            bVar3.tipString = builder.user_tips;
            if (builder.user_tips_type.intValue() == 4) {
                bVar3.kdQ = true;
            } else {
                bVar3.kdR = true;
            }
            if (cPj() && (bVar3.kdP == 2 || bVar3.kdP == 3)) {
                if (linkedList.size() > 0) {
                    bVar3.kdP = 0;
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
            if (this.kcw.isEmpty()) {
                return false;
            }
            Iterator<n> it = this.kcw.iterator();
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
                this.kcw.remove(nVar);
            }
            this.kcC.cx(this.kcw);
            return false;
        }
        this.kcw.clear();
        this.kcw.addAll(linkedList);
        if (z2) {
            this.kcx.page_tag = dataRes.page_tag;
            this.kcx.has_more = dataRes.has_more;
            this.kcx.user_list = dataRes.user_list;
            this.kcx.user_tips_type = dataRes.user_tips_type;
            this.kcx.user_tips = dataRes.user_tips;
            this.kcx.last_tips = dataRes.last_tips;
        }
        this.kcx.banner_user_story = dataRes.banner_user_story;
        this.kcx.banner_follow_live = dataRes.banner_follow_live;
        this.kcx.hot_recomforum = dataRes.hot_recomforum;
        this.kcx.top_tips = dataRes.top_tips;
        this.kcx.top_user_info = dataRes.top_user_info;
        if (this.kcE == 2 || this.kcE == 3) {
            this.kcx.user_tips_type = dataRes.user_tips_type;
            this.kcx.user_tips = dataRes.user_tips;
        }
        this.kcC.cx(this.kcw);
        return true;
    }

    private void a(List<n> list, DataRes.Builder builder, int i) {
        List<am> dP = dP(com.baidu.tieba.recapp.a.p(builder.app_list, "CONCERN"));
        if (this.kcx == null) {
            this.kcx = new DataRes.Builder();
        }
        if (com.baidu.tieba.lego.card.c.a.isEmpty(this.kcx.app_list)) {
            this.kcx.app_list = new ArrayList();
        }
        this.kcx.app_list.addAll(builder.app_list);
        if (this.mPn == 1 || i == 0) {
            this.kcF.clear();
        }
        dP.addAll(this.kcF);
        if (!com.baidu.tieba.lego.card.c.a.isEmpty(dP)) {
            this.kcF = com.baidu.tieba.recapp.a.b(dP, list, i);
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
        com.baidu.tieba.recapp.report.b.dEB().bO("CONCERN", com.baidu.tieba.recapp.a.fJ(list));
    }

    private void blf() {
        long currentTimeMillis = System.currentTimeMillis();
        long cPm = cPm();
        long j = currentTimeMillis - cPm;
        if (cPm == 0 || j > 86400000) {
            af.a(new ae<DataRes>() { // from class: com.baidu.tieba.homepage.concern.d.10
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.ae
                /* renamed from: cPo */
                public DataRes doInBackground() {
                    com.baidu.tbadk.core.c.a.bqt().clearByteCacheWithSapce("tb.concern_page_all", TbadkCoreApplication.getCurrentAccount());
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
                /* renamed from: cPo */
                public DataRes doInBackground() {
                    l<byte[]> dE = com.baidu.tbadk.core.c.a.bqt().dE("tb.concern_page_all", TbadkCoreApplication.getCurrentAccount());
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

    private void cvS() {
        if (this.kcz != null) {
            a(this.kcz);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final DataRes.Builder builder) {
        if (cPj()) {
            af.a(new ae<Object>() { // from class: com.baidu.tieba.homepage.concern.d.2
                @Override // com.baidu.tbadk.util.ae
                public Object doInBackground() {
                    DataRes.Builder builder2 = new DataRes.Builder(builder.build(true));
                    l<byte[]> dE = com.baidu.tbadk.core.c.a.bqt().dE("tb.concern_page_all", TbadkCoreApplication.getCurrentAccount());
                    try {
                        DataRes build = builder2.build(true);
                        if (build != null && !y.isEmpty(build.thread_info)) {
                            dE.setForever("0", build.toByteArray());
                            d.LV(d.this.pageTag);
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
        this.kcv = aVar;
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

    public boolean cPh() {
        return this.kcB;
    }

    public void onDestroy() {
        this.kcC.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(CustomResponsedMessage<?> customResponsedMessage) {
        ThreadInfo threadInfo;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.kcx != null && y.getCount(this.kcx.thread_info) != 0 && y.getCount(this.kcw) != 0) {
            String optString = ((JSONObject) customResponsedMessage.getData()).optString("tid");
            if (!StringUtils.isNull(optString)) {
                Iterator<n> it = this.kcw.iterator();
                boolean z = false;
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    n next = it.next();
                    if (next instanceof com.baidu.tieba.card.data.b) {
                        com.baidu.tieba.card.data.b bVar = (com.baidu.tieba.card.data.b) next;
                        if (bVar.blp() != null && bVar.blp().getTid() != null) {
                            if (bVar.blp().getTid().equals(optString)) {
                                z = true;
                                it.remove();
                            } else if (z) {
                                if (this.kcC != null) {
                                    this.kcC.cx(this.kcw);
                                }
                            }
                        }
                    }
                    z = z;
                }
                long j = com.baidu.adp.lib.f.b.toLong(optString, 0L);
                for (int i = 0; i < this.kcx.thread_info.size(); i++) {
                    ConcernData concernData = this.kcx.thread_info.get(i);
                    if (concernData != null && (threadInfo = concernData.thread_list) != null && threadInfo.tid != null && threadInfo.tid.longValue() == j) {
                        this.kcx.thread_info.remove(i);
                        cvS();
                        return;
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cPi() {
        if (this.kcx != null && y.getCount(this.kcx.thread_info) != 0 && y.getCount(this.kcw) != 0) {
            int i = 0;
            while (true) {
                if (i >= this.kcw.size()) {
                    break;
                } else if (!(this.kcw.get(i) instanceof com.baidu.tieba.homepage.concern.a.a)) {
                    i++;
                } else {
                    this.kcw.remove(i);
                    if (this.kcC != null) {
                        this.kcC.cx(this.kcw);
                    }
                }
            }
            for (int i2 = 0; i2 < this.kcx.thread_info.size(); i2++) {
                if (com.baidu.tieba.homepage.concern.a.a.a(this.kcx.thread_info.get(i2))) {
                    this.kcx.thread_info.remove(i2);
                    cvS();
                    return;
                }
            }
        }
    }

    public static boolean cPj() {
        return com.baidu.tbadk.a.d.bji() && com.baidu.tbadk.core.sharedPref.b.brR().getInt("key_home_concern_all_status", 0) == 0;
    }

    public static void LU(String str) {
        com.baidu.tbadk.core.sharedPref.b.brR().putString(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("key_home_concern_all_status_cache_nextpage_key"), str);
    }

    public static String cPk() {
        return com.baidu.tbadk.core.sharedPref.b.brR().getString(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("key_home_concern_all_status_cache_nextpage_key"), "");
    }

    public static void LV(String str) {
        com.baidu.tbadk.core.sharedPref.b.brR().putString(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("key_home_concern_all_status_cache_nextpage_update_key"), str);
    }

    public static String cPl() {
        return com.baidu.tbadk.core.sharedPref.b.brR().getString(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("key_home_concern_all_status_cache_nextpage_update_key"), "");
    }

    public static void gC(long j) {
        com.baidu.tbadk.core.sharedPref.b.brR().putLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("key_home_concern_all_status_cache_time"), j);
    }

    public static long cPm() {
        return com.baidu.tbadk.core.sharedPref.b.brR().getLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("key_home_concern_all_status_cache_time"), 0L);
    }

    public static boolean cPn() {
        return com.baidu.tbadk.core.sharedPref.b.brR().getBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("key_home_concern_all_status_cache_loaded"), false);
    }

    public static void rW(boolean z) {
        com.baidu.tbadk.core.sharedPref.b.brR().putBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("key_home_concern_all_status_cache_loaded"), z);
    }
}
