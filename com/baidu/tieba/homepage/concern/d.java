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
    private com.baidu.tieba.f.a jKG;
    private BigdaySwipeRefreshLayout jZZ;
    private final BdTypeRecyclerView jmj;
    private DataRes.Builder kah;
    private DataRes.Builder kai;
    private DataRes.Builder kaj;
    private final com.baidu.tieba.homepage.concern.a kam;
    private final com.baidu.tieba.homepage.concern.b.a kan;
    private int kao;
    private String pageTag;
    private a kaf = null;
    private final LinkedList<n> kag = new LinkedList<>();
    private boolean mIsLoading = false;
    private boolean kak = false;
    private boolean kal = false;
    private boolean mIsBackground = false;
    private int mPn = 0;
    private List<am> kap = new ArrayList();
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
                        Iterator it = d.this.kag.iterator();
                        while (it.hasNext()) {
                            Object next = it.next();
                            if ((next instanceof com.baidu.tieba.card.data.b) && az.h(((com.baidu.tieba.card.data.b) next).bln(), data.toUid)) {
                                it.remove();
                            }
                        }
                        com.baidu.tieba.recapp.a.fL(d.this.kag);
                        d.this.kap.clear();
                        if (d.this.kag.size() < 9) {
                            d.this.blc();
                        } else {
                            d.this.setList(d.this.kag);
                            d.this.kam.notifyDataSetChanged();
                            if (d.this.kaf != null) {
                                d.this.kaf.ah(false, false);
                            }
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921517, Boolean.valueOf(d.this.mIsBackground)));
                    }
                }
            }
        }
    };
    private CustomMessageListener kaq = new CustomMessageListener(0) { // from class: com.baidu.tieba.homepage.concern.d.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long) && d.this.kah != null && d.this.kah.hot_recomforum != null && !y.isEmpty(d.this.kah.hot_recomforum.tab_list)) {
                long longValue = ((Long) customResponsedMessage.getData()).longValue();
                DiscoverHotForum.Builder builder = new DiscoverHotForum.Builder(d.this.kah.hot_recomforum);
                if (c.a(builder, longValue, customResponsedMessage.getCmd() == 2001335)) {
                    d.this.kah.hot_recomforum = builder.build(true);
                    d.this.a(new DataRes.Builder(d.this.kah.build(true)));
                }
            }
        }
    };
    RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.concern.d.7
        private int kav = 0;

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (d.this.fNk != null && !d.this.mIsBackground) {
                d.this.fNk.q(recyclerView, i);
            }
            if (i == 0) {
                t.csu().bOF();
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
                d.this.fNk.onScroll(this.kav, i);
            }
            this.kav = i;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921517, Boolean.valueOf(d.this.mIsBackground)));
        }
    };
    private CustomMessageListener jpm = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.homepage.concern.d.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && d.this.kah != null && !com.baidu.tieba.lego.card.c.a.isEmpty(d.this.kag)) {
                String str = (String) customResponsedMessage.getData();
                if (!TextUtils.isEmpty(str)) {
                    com.baidu.tieba.recapp.a.i(str, d.this.kag);
                    com.baidu.tieba.recapp.a.i(str, d.this.kah.app_list);
                    com.baidu.tieba.recapp.a.i(str, d.this.kap);
                    com.baidu.tieba.recapp.a.fK(d.this.kag);
                    if (d.this.kam != null) {
                        d.this.kam.cx(new ArrayList(d.this.kag));
                    }
                    d.this.dQ(d.this.kag);
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
            if (d.this.jKG != null) {
                d.this.jKG.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private CustomMessageListener kar = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.homepage.concern.d.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.this.g(customResponsedMessage);
        }
    };
    private CustomMessageListener iOY = new CustomMessageListener(CmdConfigCustom.CMD_THREAD_NOT_EXIST_WHEN_ENTER_PB) { // from class: com.baidu.tieba.homepage.concern.d.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.this.g(customResponsedMessage);
        }
    };
    private CustomMessageListener kas = new CustomMessageListener(2921425) { // from class: com.baidu.tieba.homepage.concern.d.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.this.cOU();
        }
    };

    /* loaded from: classes2.dex */
    public interface a {
        void a(com.baidu.tbadk.util.c cVar);

        void a(String str, com.baidu.tbadk.util.c cVar);

        void ah(boolean z, boolean z2);

        void cOP();

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
        this.jmj = bdTypeRecyclerView;
        this.jmj.setOnTouchListener(this.bST);
        this.jKG = new com.baidu.tieba.f.a();
        this.kan = new com.baidu.tieba.homepage.concern.b.a();
        this.kam = aVar;
        bdTypeRecyclerView.setOnScrollListener(this.mOnScrollListener);
        this.jZZ = bigdaySwipeRefreshLayout;
        rW(false);
    }

    public void s(BdUniqueId bdUniqueId) {
        this.kar.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.kar);
        this.iOY.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.iOY);
        this.kas.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.kas);
        this.faJ.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.faJ);
        this.kaq.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_LIKE_FORUM, this.kaq);
        MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_UNLIKE_FORUM, this.kaq);
        this.jpm.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.jpm);
    }

    public void setRecommendFrsNavigationAnimDispatcher(aa aaVar) {
        if (aaVar != null) {
            this.fNk = aaVar.bFF();
            this.fyG = aaVar.bFG();
        }
    }

    public void update() {
        if (cOV() && !this.kak) {
            bld();
        } else {
            blc();
        }
    }

    public void cOQ() {
        this.kai = new DataRes.Builder(this.kah.build(true));
    }

    public void cOR() {
        this.kah = new DataRes.Builder(this.kai.build(true));
    }

    public void cOS() {
        blc();
    }

    public void bRc() {
        if (!isLoading() && this.hasMore) {
            com.baidu.tbadk.util.c rU = rU(false);
            if (this.kaf != null) {
                setIsLoading(true);
                this.kaf.a(this.pageTag, rU);
            }
        }
    }

    private com.baidu.tbadk.util.c rU(boolean z) {
        String y = com.baidu.tieba.recapp.a.y(this.kag, z);
        com.baidu.tbadk.util.c cVar = new com.baidu.tbadk.util.c();
        cVar.adFloorInfo = y;
        return cVar;
    }

    public void a(boolean z, DataRes dataRes, int i, String str) {
        setIsLoading(false);
        if (i != 0 || dataRes == null || !a(true, z, dataRes)) {
            if (i == 0 && y.getCount(this.kag) == 0 && this.kaf != null) {
                this.kaf.cOP();
                if (this.jZZ != null) {
                    this.jZZ.setRefreshing(false);
                    return;
                }
                return;
            } else if (this.kag.size() > 0) {
                if (this.kaf != null) {
                    this.kaf.onError(1, str);
                }
            } else if (this.kaf != null) {
                this.kaf.onError(2, str);
            }
        } else {
            if (this.kaf != null) {
                this.kaf.ah(z, false);
            }
            if (z) {
                cvF();
            }
        }
        if (this.jZZ != null) {
            this.jZZ.setRefreshing(false);
        }
    }

    public void rV(boolean z) {
        if (z) {
            this.kam.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void blc() {
        com.baidu.tbadk.util.c rU = rU(true);
        if (this.kaf != null) {
            this.kaf.a(rU);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(DataRes dataRes) {
        this.kak = true;
        rW(true);
        if (dataRes != null) {
            if (a(false, true, dataRes)) {
                if (this.kaf != null) {
                    this.kaf.ah(false, true);
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
        if (this.kah == null) {
            this.kah = new DataRes.Builder();
        }
        if (builder == null) {
            builder = new DataRes.Builder();
        }
        com.baidu.tieba.homepage.personalize.model.c a2 = this.kan.a(z, this.kah, builder, z2 ? 0 : 1);
        if (a2 == null) {
            return null;
        }
        return a2.gcs;
    }

    public void aC(cb cbVar) {
        cbVar.jD(true);
        com.baidu.tbadk.a.a.a.a(cbVar);
        List<n> a2 = this.kan.a(cbVar, -1, null);
        if ((this.kah == null || y.getCount(this.kah.thread_info) <= 0) && y.getCount(this.kag) <= 1) {
            this.kag.clear();
        }
        this.kag.addAll(0, a2);
        this.kam.cx(this.kag);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setList(List<n> list) {
        this.kam.cx(list);
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
        int eL = this.mPn == 1 ? 0 : com.baidu.tieba.lego.card.c.a.eL(this.kag);
        this.pageTag = dataRes.page_tag;
        this.kaj = new DataRes.Builder(dataRes);
        if (cOV()) {
            LN(this.pageTag);
        }
        LinkedList linkedList = new LinkedList();
        DataRes.Builder builder = new DataRes.Builder(dataRes);
        this.kao = builder.user_tips_type.intValue();
        if (dataRes.req_unix != null) {
            com.baidu.tbadk.core.sharedPref.b.brQ().putLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(SharedPrefConfig.CONCERN_DATA_RES_REQUEST_TIME), dataRes.req_unix.longValue());
        }
        List<n> a2 = a(z, builder, z2);
        a(a2, builder, eL);
        this.kal = false;
        if (a2 != null && TbadkCoreApplication.isLogin()) {
            if (y.isEmpty(a2) || (y.getCount(a2) == 1 && (y.getItem(a2, 0) instanceof com.baidu.tieba.homepage.concern.a.a))) {
                if (3 == this.kao) {
                    com.baidu.tieba.homepage.concern.a.b bVar = new com.baidu.tieba.homepage.concern.a.b();
                    bVar.kbC = com.baidu.tieba.homepage.concern.a.b.kbx;
                    bVar.kbz = 3;
                    a2.add(bVar);
                    this.kal = true;
                } else if (2 == this.kao) {
                    com.baidu.tieba.homepage.concern.a.b bVar2 = new com.baidu.tieba.homepage.concern.a.b();
                    bVar2.kbC = com.baidu.tieba.homepage.concern.a.b.kbx;
                    bVar2.kbz = 2;
                    a2.add(bVar2);
                    this.kal = true;
                }
            }
            linkedList.addAll(a2);
        }
        if (!au.isEmpty(builder.user_tips) && 2 == this.kao) {
            com.baidu.tieba.homepage.concern.a.b bVar3 = new com.baidu.tieba.homepage.concern.a.b();
            bVar3.kbz = builder.user_tips_type.intValue();
            bVar3.tipString = builder.user_tips;
            if (builder.user_tips_type.intValue() == 4) {
                bVar3.kbA = true;
            } else {
                bVar3.kbB = true;
            }
            if (cOV() && (bVar3.kbz == 2 || bVar3.kbz == 3)) {
                if (linkedList.size() > 0) {
                    bVar3.kbz = 0;
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
            if (this.kag.isEmpty()) {
                return false;
            }
            Iterator<n> it = this.kag.iterator();
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
                this.kag.remove(nVar);
            }
            this.kam.cx(this.kag);
            return false;
        }
        this.kag.clear();
        this.kag.addAll(linkedList);
        if (z2) {
            this.kah.page_tag = dataRes.page_tag;
            this.kah.has_more = dataRes.has_more;
            this.kah.user_list = dataRes.user_list;
            this.kah.user_tips_type = dataRes.user_tips_type;
            this.kah.user_tips = dataRes.user_tips;
            this.kah.last_tips = dataRes.last_tips;
        }
        this.kah.banner_user_story = dataRes.banner_user_story;
        this.kah.banner_follow_live = dataRes.banner_follow_live;
        this.kah.hot_recomforum = dataRes.hot_recomforum;
        this.kah.top_tips = dataRes.top_tips;
        this.kah.top_user_info = dataRes.top_user_info;
        if (this.kao == 2 || this.kao == 3) {
            this.kah.user_tips_type = dataRes.user_tips_type;
            this.kah.user_tips = dataRes.user_tips;
        }
        this.kam.cx(this.kag);
        return true;
    }

    private void a(List<n> list, DataRes.Builder builder, int i) {
        List<am> dP = dP(com.baidu.tieba.recapp.a.p(builder.app_list, "CONCERN"));
        if (this.kah == null) {
            this.kah = new DataRes.Builder();
        }
        if (com.baidu.tieba.lego.card.c.a.isEmpty(this.kah.app_list)) {
            this.kah.app_list = new ArrayList();
        }
        this.kah.app_list.addAll(builder.app_list);
        if (this.mPn == 1 || i == 0) {
            this.kap.clear();
        }
        dP.addAll(this.kap);
        if (!com.baidu.tieba.lego.card.c.a.isEmpty(dP)) {
            this.kap = com.baidu.tieba.recapp.a.b(dP, list, i);
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
        com.baidu.tieba.recapp.report.b.dEl().bO("CONCERN", com.baidu.tieba.recapp.a.fJ(list));
    }

    private void bld() {
        long currentTimeMillis = System.currentTimeMillis();
        long cOY = cOY();
        long j = currentTimeMillis - cOY;
        if (cOY == 0 || j > 86400000) {
            af.a(new ae<DataRes>() { // from class: com.baidu.tieba.homepage.concern.d.10
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.ae
                /* renamed from: cPa */
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
                /* renamed from: cPa */
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

    private void cvF() {
        if (this.kaj != null) {
            a(this.kaj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final DataRes.Builder builder) {
        if (cOV()) {
            af.a(new ae<Object>() { // from class: com.baidu.tieba.homepage.concern.d.2
                @Override // com.baidu.tbadk.util.ae
                public Object doInBackground() {
                    DataRes.Builder builder2 = new DataRes.Builder(builder.build(true));
                    l<byte[]> dE = com.baidu.tbadk.core.c.a.bqr().dE("tb.concern_page_all", TbadkCoreApplication.getCurrentAccount());
                    try {
                        DataRes build = builder2.build(true);
                        if (build != null && !y.isEmpty(build.thread_info)) {
                            dE.setForever("0", build.toByteArray());
                            d.LO(d.this.pageTag);
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
        this.kaf = aVar;
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

    public boolean cOT() {
        return this.kal;
    }

    public void onDestroy() {
        this.kam.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(CustomResponsedMessage<?> customResponsedMessage) {
        ThreadInfo threadInfo;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.kah != null && y.getCount(this.kah.thread_info) != 0 && y.getCount(this.kag) != 0) {
            String optString = ((JSONObject) customResponsedMessage.getData()).optString("tid");
            if (!StringUtils.isNull(optString)) {
                Iterator<n> it = this.kag.iterator();
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
                                if (this.kam != null) {
                                    this.kam.cx(this.kag);
                                }
                            }
                        }
                    }
                    z = z;
                }
                long j = com.baidu.adp.lib.f.b.toLong(optString, 0L);
                for (int i = 0; i < this.kah.thread_info.size(); i++) {
                    ConcernData concernData = this.kah.thread_info.get(i);
                    if (concernData != null && (threadInfo = concernData.thread_list) != null && threadInfo.tid != null && threadInfo.tid.longValue() == j) {
                        this.kah.thread_info.remove(i);
                        cvF();
                        return;
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cOU() {
        if (this.kah != null && y.getCount(this.kah.thread_info) != 0 && y.getCount(this.kag) != 0) {
            int i = 0;
            while (true) {
                if (i >= this.kag.size()) {
                    break;
                } else if (!(this.kag.get(i) instanceof com.baidu.tieba.homepage.concern.a.a)) {
                    i++;
                } else {
                    this.kag.remove(i);
                    if (this.kam != null) {
                        this.kam.cx(this.kag);
                    }
                }
            }
            for (int i2 = 0; i2 < this.kah.thread_info.size(); i2++) {
                if (com.baidu.tieba.homepage.concern.a.a.a(this.kah.thread_info.get(i2))) {
                    this.kah.thread_info.remove(i2);
                    cvF();
                    return;
                }
            }
        }
    }

    public static boolean cOV() {
        return com.baidu.tbadk.a.d.bjg() && com.baidu.tbadk.core.sharedPref.b.brQ().getInt("key_home_concern_all_status", 0) == 0;
    }

    public static void LN(String str) {
        com.baidu.tbadk.core.sharedPref.b.brQ().putString(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("key_home_concern_all_status_cache_nextpage_key"), str);
    }

    public static String cOW() {
        return com.baidu.tbadk.core.sharedPref.b.brQ().getString(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("key_home_concern_all_status_cache_nextpage_key"), "");
    }

    public static void LO(String str) {
        com.baidu.tbadk.core.sharedPref.b.brQ().putString(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("key_home_concern_all_status_cache_nextpage_update_key"), str);
    }

    public static String cOX() {
        return com.baidu.tbadk.core.sharedPref.b.brQ().getString(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("key_home_concern_all_status_cache_nextpage_update_key"), "");
    }

    public static void gC(long j) {
        com.baidu.tbadk.core.sharedPref.b.brQ().putLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("key_home_concern_all_status_cache_time"), j);
    }

    public static long cOY() {
        return com.baidu.tbadk.core.sharedPref.b.brQ().getLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("key_home_concern_all_status_cache_time"), 0L);
    }

    public static boolean cOZ() {
        return com.baidu.tbadk.core.sharedPref.b.brQ().getBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("key_home_concern_all_status_cache_loaded"), false);
    }

    public static void rW(boolean z) {
        com.baidu.tbadk.core.sharedPref.b.brQ().putBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("key_home_concern_all_status_cache_loaded"), z);
    }
}
