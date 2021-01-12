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
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.n;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.al;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tbadk.util.ab;
import com.baidu.tbadk.util.ac;
import com.baidu.tbadk.util.l;
import com.baidu.tbadk.util.x;
import com.baidu.tbadk.util.y;
import com.baidu.tieba.R;
import com.baidu.tieba.card.s;
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
    private x fKY;
    private View.OnTouchListener fwq;
    private boolean hasMore;
    private com.baidu.tieba.f.a jFc;
    private DataRes.Builder jSG;
    private DataRes.Builder jSH;
    private DataRes.Builder jSI;
    private final com.baidu.tieba.homepage.concern.a jSL;
    private final com.baidu.tieba.homepage.concern.b.a jSM;
    private int jSN;
    private BigdaySwipeRefreshLayout jSy;
    private final BdTypeRecyclerView jgC;
    private String pageTag;
    private a jSE = null;
    private final LinkedList<n> jSF = new LinkedList<>();
    private boolean mIsLoading = false;
    private boolean jSJ = false;
    private boolean jSK = false;
    private boolean mIsBackground = false;
    private int mPn = 0;
    private List<al> jSO = new ArrayList();
    private CustomMessageListener eYu = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.homepage.concern.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (data.fqk == null) {
                    if (!data.isSucc) {
                        BdToast.a(TbadkCoreApplication.getInst().getContext(), updateAttentionMessage.getData().errorString, R.drawable.icon_pure_toast_mistake40_svg, 3000, true).bqk();
                    } else if (!data.isAttention) {
                        Iterator it = d.this.jSF.iterator();
                        while (it.hasNext()) {
                            Object next = it.next();
                            if ((next instanceof com.baidu.tieba.card.data.b) && ay.h(((com.baidu.tieba.card.data.b) next).bkV(), data.toUid)) {
                                it.remove();
                            }
                        }
                        com.baidu.tieba.recapp.a.fN(d.this.jSF);
                        d.this.jSO.clear();
                        if (d.this.jSF.size() < 9) {
                            d.this.bkK();
                        } else {
                            d.this.setList(d.this.jSF);
                            d.this.jSL.notifyDataSetChanged();
                            if (d.this.jSE != null) {
                                d.this.jSE.ah(false, false);
                            }
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921517, Boolean.valueOf(d.this.mIsBackground)));
                    }
                }
            }
        }
    };
    private CustomMessageListener jSP = new CustomMessageListener(0) { // from class: com.baidu.tieba.homepage.concern.d.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long) && d.this.jSG != null && d.this.jSG.hot_recomforum != null && !com.baidu.tbadk.core.util.x.isEmpty(d.this.jSG.hot_recomforum.tab_list)) {
                long longValue = ((Long) customResponsedMessage.getData()).longValue();
                DiscoverHotForum.Builder builder = new DiscoverHotForum.Builder(d.this.jSG.hot_recomforum);
                if (c.a(builder, longValue, customResponsedMessage.getCmd() == 2001335)) {
                    d.this.jSG.hot_recomforum = builder.build(true);
                    d.this.a(new DataRes.Builder(d.this.jSG.build(true)));
                }
            }
        }
    };
    RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.concern.d.7
        private int jSU = 0;

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (d.this.fKY != null && !d.this.mIsBackground) {
                d.this.fKY.q(recyclerView, i);
            }
            if (i == 0) {
                s.crj().bOb();
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
            if (d.this.fKY != null && !d.this.mIsBackground) {
                d.this.fKY.onScroll(this.jSU, i);
            }
            this.jSU = i;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921517, Boolean.valueOf(d.this.mIsBackground)));
        }
    };
    private CustomMessageListener jjF = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.homepage.concern.d.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && d.this.jSG != null && !com.baidu.tieba.lego.card.c.a.isEmpty(d.this.jSF)) {
                String str = (String) customResponsedMessage.getData();
                if (!TextUtils.isEmpty(str)) {
                    com.baidu.tieba.recapp.a.i(str, d.this.jSF);
                    com.baidu.tieba.recapp.a.i(str, d.this.jSG.app_list);
                    com.baidu.tieba.recapp.a.i(str, d.this.jSO);
                    com.baidu.tieba.recapp.a.fM(d.this.jSF);
                    if (d.this.jSL != null) {
                        d.this.jSL.cC(new ArrayList(d.this.jSF));
                    }
                    d.this.dT(d.this.jSF);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921517, Boolean.valueOf(d.this.mIsBackground)));
                }
            }
        }
    };
    private View.OnTouchListener bPd = new View.OnTouchListener() { // from class: com.baidu.tieba.homepage.concern.d.9
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (d.this.fwq != null) {
                d.this.fwq.onTouch(view, motionEvent);
            }
            if (d.this.jFc != null) {
                d.this.jFc.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private CustomMessageListener jSQ = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.homepage.concern.d.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.this.g(customResponsedMessage);
        }
    };
    private CustomMessageListener iJq = new CustomMessageListener(CmdConfigCustom.CMD_THREAD_NOT_EXIST_WHEN_ENTER_PB) { // from class: com.baidu.tieba.homepage.concern.d.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.this.g(customResponsedMessage);
        }
    };
    private CustomMessageListener jSR = new CustomMessageListener(2921425) { // from class: com.baidu.tieba.homepage.concern.d.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.this.cMY();
        }
    };

    /* loaded from: classes2.dex */
    public interface a {
        void KZ(String str);

        void ah(boolean z, boolean z2);

        void cMS();

        void cMT();

        void onError(int i, String str);
    }

    public void setTabInForeBackgroundState(boolean z) {
        this.mIsBackground = z;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921517, Boolean.valueOf(this.mIsBackground)));
    }

    public void qz(boolean z) {
        this.mIsBackground = z;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921517, Boolean.valueOf(this.mIsBackground)));
    }

    public d(f<?> fVar, BdTypeRecyclerView bdTypeRecyclerView, com.baidu.tieba.homepage.concern.a aVar, BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout) {
        this.jgC = bdTypeRecyclerView;
        this.jgC.setOnTouchListener(this.bPd);
        this.jFc = new com.baidu.tieba.f.a();
        this.jSM = new com.baidu.tieba.homepage.concern.b.a();
        this.jSL = aVar;
        bdTypeRecyclerView.setOnScrollListener(this.mOnScrollListener);
        this.jSy = bigdaySwipeRefreshLayout;
        rK(false);
    }

    public void s(BdUniqueId bdUniqueId) {
        this.jSQ.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.jSQ);
        this.iJq.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.iJq);
        this.jSR.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.jSR);
        this.eYu.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.eYu);
        this.jSP.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_LIKE_FORUM, this.jSP);
        MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_UNLIKE_FORUM, this.jSP);
        this.jjF.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.jjF);
    }

    public void setRecommendFrsNavigationAnimDispatcher(y yVar) {
        if (yVar != null) {
            this.fKY = yVar.bFm();
            this.fwq = yVar.bFn();
        }
    }

    public void update() {
        if (cMZ() && !this.jSJ) {
            bkL();
        } else {
            bkK();
        }
    }

    public void cMU() {
        this.jSH = new DataRes.Builder(this.jSG.build(true));
    }

    public void cMV() {
        this.jSG = new DataRes.Builder(this.jSH.build(true));
    }

    public void cMW() {
        bkK();
    }

    public void bQy() {
        if (!isLoading() && this.hasMore && this.jSE != null) {
            setIsLoading(true);
            this.jSE.KZ(this.pageTag);
        }
    }

    public void a(boolean z, DataRes dataRes, int i, String str) {
        setIsLoading(false);
        if (i != 0 || dataRes == null || !a(true, z, dataRes)) {
            if (i == 0 && com.baidu.tbadk.core.util.x.getCount(this.jSF) == 0 && this.jSE != null) {
                this.jSE.cMT();
                if (this.jSy != null) {
                    this.jSy.setRefreshing(false);
                    return;
                }
                return;
            } else if (this.jSF.size() > 0) {
                if (this.jSE != null) {
                    this.jSE.onError(1, str);
                }
            } else if (this.jSE != null) {
                this.jSE.onError(2, str);
            }
        } else {
            if (this.jSE != null) {
                this.jSE.ah(z, false);
            }
            if (z) {
                cut();
            }
        }
        if (this.jSy != null) {
            this.jSy.setRefreshing(false);
        }
    }

    public void rJ(boolean z) {
        if (z) {
            this.jSL.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bkK() {
        if (this.jSE != null) {
            this.jSE.cMS();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(DataRes dataRes) {
        this.jSJ = true;
        rK(true);
        if (dataRes != null) {
            if (a(false, true, dataRes)) {
                if (this.jSE != null) {
                    this.jSE.ah(false, true);
                    return;
                }
                return;
            }
            bkK();
            return;
        }
        bkK();
    }

    private List<n> a(boolean z, DataRes.Builder builder, boolean z2) {
        if (this.jSG == null) {
            this.jSG = new DataRes.Builder();
        }
        if (builder == null) {
            builder = new DataRes.Builder();
        }
        com.baidu.tieba.homepage.personalize.model.c a2 = this.jSM.a(z, this.jSG, builder, z2 ? 0 : 1);
        if (a2 == null) {
            return null;
        }
        return a2.gaa;
    }

    public void aB(bz bzVar) {
        bzVar.jB(true);
        com.baidu.tbadk.a.a.a.a(bzVar);
        List<n> a2 = this.jSM.a(bzVar, -1, null);
        if ((this.jSG == null || com.baidu.tbadk.core.util.x.getCount(this.jSG.thread_info) <= 0) && com.baidu.tbadk.core.util.x.getCount(this.jSF) <= 1) {
            this.jSF.clear();
        }
        this.jSF.addAll(0, a2);
        this.jSL.cC(this.jSF);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setList(List<n> list) {
        this.jSL.cC(list);
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
        int eN = this.mPn == 1 ? 0 : com.baidu.tieba.lego.card.c.a.eN(this.jSG.thread_info);
        this.pageTag = dataRes.page_tag;
        this.jSI = new DataRes.Builder(dataRes);
        if (cMZ()) {
            Lb(this.pageTag);
        }
        LinkedList linkedList = new LinkedList();
        DataRes.Builder builder = new DataRes.Builder(dataRes);
        this.jSN = builder.user_tips_type.intValue();
        if (dataRes.req_unix != null) {
            com.baidu.tbadk.core.sharedPref.b.brx().putLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(SharedPrefConfig.CONCERN_DATA_RES_REQUEST_TIME), dataRes.req_unix.longValue());
        }
        List<n> a2 = a(z, builder, z2);
        a(a2, builder, eN);
        this.jSK = false;
        if (a2 != null && TbadkCoreApplication.isLogin()) {
            if (com.baidu.tbadk.core.util.x.isEmpty(a2) || (com.baidu.tbadk.core.util.x.getCount(a2) == 1 && (com.baidu.tbadk.core.util.x.getItem(a2, 0) instanceof com.baidu.tieba.homepage.concern.a.a))) {
                if (3 == this.jSN) {
                    com.baidu.tieba.homepage.concern.a.b bVar = new com.baidu.tieba.homepage.concern.a.b();
                    bVar.jUb = com.baidu.tieba.homepage.concern.a.b.jTW;
                    bVar.jTY = 3;
                    a2.add(bVar);
                    this.jSK = true;
                } else if (2 == this.jSN) {
                    com.baidu.tieba.homepage.concern.a.b bVar2 = new com.baidu.tieba.homepage.concern.a.b();
                    bVar2.jUb = com.baidu.tieba.homepage.concern.a.b.jTW;
                    bVar2.jTY = 2;
                    a2.add(bVar2);
                    this.jSK = true;
                }
            }
            linkedList.addAll(a2);
        }
        if (!at.isEmpty(builder.user_tips) && 2 == this.jSN) {
            com.baidu.tieba.homepage.concern.a.b bVar3 = new com.baidu.tieba.homepage.concern.a.b();
            bVar3.jTY = builder.user_tips_type.intValue();
            bVar3.tipString = builder.user_tips;
            if (builder.user_tips_type.intValue() == 4) {
                bVar3.jTZ = true;
            } else {
                bVar3.jUa = true;
            }
            if (cMZ() && (bVar3.jTY == 2 || bVar3.jTY == 3)) {
                if (linkedList.size() > 0) {
                    bVar3.jTY = 0;
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
        if (com.baidu.tbadk.core.util.x.isEmpty(linkedList)) {
            if (this.jSF.isEmpty()) {
                return false;
            }
            Iterator<n> it = this.jSF.iterator();
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
                this.jSF.remove(nVar);
            }
            this.jSL.cC(this.jSF);
            return false;
        }
        this.jSF.clear();
        this.jSF.addAll(linkedList);
        if (z2) {
            this.jSG.page_tag = dataRes.page_tag;
            this.jSG.has_more = dataRes.has_more;
            this.jSG.user_list = dataRes.user_list;
            this.jSG.user_tips_type = dataRes.user_tips_type;
            this.jSG.user_tips = dataRes.user_tips;
            this.jSG.last_tips = dataRes.last_tips;
        }
        this.jSG.banner_user_story = dataRes.banner_user_story;
        this.jSG.banner_follow_live = dataRes.banner_follow_live;
        this.jSG.hot_recomforum = dataRes.hot_recomforum;
        this.jSG.top_tips = dataRes.top_tips;
        this.jSG.top_user_info = dataRes.top_user_info;
        if (this.jSN == 2 || this.jSN == 3) {
            this.jSG.user_tips_type = dataRes.user_tips_type;
            this.jSG.user_tips = dataRes.user_tips;
        }
        this.jSL.cC(this.jSF);
        return true;
    }

    private void a(List<n> list, DataRes.Builder builder, int i) {
        List<al> dS = dS(com.baidu.tieba.recapp.a.r(builder.app_list, "CONCERN"));
        if (this.jSG == null) {
            this.jSG = new DataRes.Builder();
        }
        if (com.baidu.tieba.lego.card.c.a.isEmpty(this.jSG.app_list)) {
            this.jSG.app_list = new ArrayList();
        }
        this.jSG.app_list.addAll(builder.app_list);
        if (this.mPn == 1 || i == 0) {
            this.jSO.clear();
        }
        dS.addAll(this.jSO);
        if (!com.baidu.tieba.lego.card.c.a.isEmpty(dS)) {
            this.jSO = com.baidu.tieba.recapp.a.b(dS, list, i);
        }
        com.baidu.tieba.recapp.a.a(list, this.mPn, "CONCERN");
        dT(list);
    }

    private List<al> dS(List<al> list) {
        ArrayList arrayList = new ArrayList();
        for (al alVar : list) {
            if (alVar instanceof AdvertAppInfo) {
                arrayList.add(new com.baidu.tieba.card.data.d((AdvertAppInfo) alVar));
            } else if (alVar instanceof com.baidu.tieba.card.data.d) {
                arrayList.add((com.baidu.tieba.card.data.d) alVar);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dT(List<n> list) {
        com.baidu.tieba.recapp.report.b.dCd().bN("CONCERN", com.baidu.tieba.recapp.a.fL(list));
    }

    private void bkL() {
        long currentTimeMillis = System.currentTimeMillis();
        long cNc = cNc();
        long j = currentTimeMillis - cNc;
        if (cNc == 0 || j > 86400000) {
            ac.a(new ab<DataRes>() { // from class: com.baidu.tieba.homepage.concern.d.10
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.ab
                /* renamed from: cNe */
                public DataRes doInBackground() {
                    com.baidu.tbadk.core.c.a.bpZ().clearByteCacheWithSapce("tb.concern_page_all", TbadkCoreApplication.getCurrentAccount());
                    return null;
                }
            }, new l<DataRes>() { // from class: com.baidu.tieba.homepage.concern.d.11
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.l
                /* renamed from: b */
                public void onReturnDataInUI(DataRes dataRes) {
                    d.this.a((DataRes) null);
                }
            });
        } else {
            ac.a(new ab<DataRes>() { // from class: com.baidu.tieba.homepage.concern.d.12
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.ab
                /* renamed from: cNe */
                public DataRes doInBackground() {
                    com.baidu.adp.lib.cache.l<byte[]> dK = com.baidu.tbadk.core.c.a.bpZ().dK("tb.concern_page_all", TbadkCoreApplication.getCurrentAccount());
                    if (dK == null) {
                        return null;
                    }
                    byte[] bArr = dK.get("0");
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
            }, new l<DataRes>() { // from class: com.baidu.tieba.homepage.concern.d.13
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.l
                /* renamed from: b */
                public void onReturnDataInUI(DataRes dataRes) {
                    d.this.a(dataRes);
                }
            });
        }
    }

    private void cut() {
        if (this.jSI != null) {
            a(this.jSI);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final DataRes.Builder builder) {
        if (cMZ()) {
            ac.a(new ab<Object>() { // from class: com.baidu.tieba.homepage.concern.d.2
                @Override // com.baidu.tbadk.util.ab
                public Object doInBackground() {
                    DataRes.Builder builder2 = new DataRes.Builder(builder.build(true));
                    com.baidu.adp.lib.cache.l<byte[]> dK = com.baidu.tbadk.core.c.a.bpZ().dK("tb.concern_page_all", TbadkCoreApplication.getCurrentAccount());
                    try {
                        DataRes build = builder2.build(true);
                        if (build != null && !com.baidu.tbadk.core.util.x.isEmpty(build.thread_info)) {
                            dK.setForever("0", build.toByteArray());
                            d.Lc(d.this.pageTag);
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
        this.jSE = aVar;
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

    public boolean cMX() {
        return this.jSK;
    }

    public void onDestroy() {
        this.jSL.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(CustomResponsedMessage<?> customResponsedMessage) {
        ThreadInfo threadInfo;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.jSG != null && com.baidu.tbadk.core.util.x.getCount(this.jSG.thread_info) != 0 && com.baidu.tbadk.core.util.x.getCount(this.jSF) != 0) {
            String optString = ((JSONObject) customResponsedMessage.getData()).optString("tid");
            if (!StringUtils.isNull(optString)) {
                Iterator<n> it = this.jSF.iterator();
                boolean z = false;
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    n next = it.next();
                    if (next instanceof com.baidu.tieba.card.data.b) {
                        com.baidu.tieba.card.data.b bVar = (com.baidu.tieba.card.data.b) next;
                        if (bVar.bkV() != null && bVar.bkV().getTid() != null) {
                            if (bVar.bkV().getTid().equals(optString)) {
                                z = true;
                                it.remove();
                            } else if (z) {
                                if (this.jSL != null) {
                                    this.jSL.cC(this.jSF);
                                }
                            }
                        }
                    }
                    z = z;
                }
                long j = com.baidu.adp.lib.f.b.toLong(optString, 0L);
                for (int i = 0; i < this.jSG.thread_info.size(); i++) {
                    ConcernData concernData = this.jSG.thread_info.get(i);
                    if (concernData != null && (threadInfo = concernData.thread_list) != null && threadInfo.tid != null && threadInfo.tid.longValue() == j) {
                        this.jSG.thread_info.remove(i);
                        cut();
                        return;
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cMY() {
        if (this.jSG != null && com.baidu.tbadk.core.util.x.getCount(this.jSG.thread_info) != 0 && com.baidu.tbadk.core.util.x.getCount(this.jSF) != 0) {
            int i = 0;
            while (true) {
                if (i >= this.jSF.size()) {
                    break;
                } else if (!(this.jSF.get(i) instanceof com.baidu.tieba.homepage.concern.a.a)) {
                    i++;
                } else {
                    this.jSF.remove(i);
                    if (this.jSL != null) {
                        this.jSL.cC(this.jSF);
                    }
                }
            }
            for (int i2 = 0; i2 < this.jSG.thread_info.size(); i2++) {
                if (com.baidu.tieba.homepage.concern.a.a.a(this.jSG.thread_info.get(i2))) {
                    this.jSG.thread_info.remove(i2);
                    cut();
                    return;
                }
            }
        }
    }

    public static boolean cMZ() {
        return com.baidu.tbadk.a.d.biU() && com.baidu.tbadk.core.sharedPref.b.brx().getInt("key_home_concern_all_status", 0) == 0;
    }

    public static void Lb(String str) {
        com.baidu.tbadk.core.sharedPref.b.brx().putString(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("key_home_concern_all_status_cache_nextpage_key"), str);
    }

    public static String cNa() {
        return com.baidu.tbadk.core.sharedPref.b.brx().getString(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("key_home_concern_all_status_cache_nextpage_key"), "");
    }

    public static void Lc(String str) {
        com.baidu.tbadk.core.sharedPref.b.brx().putString(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("key_home_concern_all_status_cache_nextpage_update_key"), str);
    }

    public static String cNb() {
        return com.baidu.tbadk.core.sharedPref.b.brx().getString(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("key_home_concern_all_status_cache_nextpage_update_key"), "");
    }

    public static void gx(long j) {
        com.baidu.tbadk.core.sharedPref.b.brx().putLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("key_home_concern_all_status_cache_time"), j);
    }

    public static long cNc() {
        return com.baidu.tbadk.core.sharedPref.b.brx().getLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("key_home_concern_all_status_cache_time"), 0L);
    }

    public static boolean cNd() {
        return com.baidu.tbadk.core.sharedPref.b.brx().getBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("key_home_concern_all_status_cache_loaded"), false);
    }

    public static void rK(boolean z) {
        com.baidu.tbadk.core.sharedPref.b.brx().putBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("key_home_concern_all_status_cache_loaded"), z);
    }
}
