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
    private View.OnTouchListener fAY;
    private x fPF;
    private boolean hasMore;
    private com.baidu.tieba.f.a jJI;
    private BigdaySwipeRefreshLayout jXd;
    private DataRes.Builder jXl;
    private DataRes.Builder jXm;
    private DataRes.Builder jXn;
    private final com.baidu.tieba.homepage.concern.a jXq;
    private final com.baidu.tieba.homepage.concern.b.a jXr;
    private int jXs;
    private final BdTypeRecyclerView jlj;
    private String pageTag;
    private a jXj = null;
    private final LinkedList<n> jXk = new LinkedList<>();
    private boolean mIsLoading = false;
    private boolean jXo = false;
    private boolean jXp = false;
    private boolean mIsBackground = false;
    private int mPn = 0;
    private List<al> jXt = new ArrayList();
    private CustomMessageListener fdd = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.homepage.concern.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (data.fuV == null) {
                    if (!data.isSucc) {
                        BdToast.a(TbadkCoreApplication.getInst().getContext(), updateAttentionMessage.getData().errorString, R.drawable.icon_pure_toast_mistake40_svg, 3000, true).bud();
                    } else if (!data.isAttention) {
                        Iterator it = d.this.jXk.iterator();
                        while (it.hasNext()) {
                            Object next = it.next();
                            if ((next instanceof com.baidu.tieba.card.data.b) && ay.h(((com.baidu.tieba.card.data.b) next).boO(), data.toUid)) {
                                it.remove();
                            }
                        }
                        com.baidu.tieba.recapp.a.fN(d.this.jXk);
                        d.this.jXt.clear();
                        if (d.this.jXk.size() < 9) {
                            d.this.boD();
                        } else {
                            d.this.setList(d.this.jXk);
                            d.this.jXq.notifyDataSetChanged();
                            if (d.this.jXj != null) {
                                d.this.jXj.ah(false, false);
                            }
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921517, Boolean.valueOf(d.this.mIsBackground)));
                    }
                }
            }
        }
    };
    private CustomMessageListener jXu = new CustomMessageListener(0) { // from class: com.baidu.tieba.homepage.concern.d.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long) && d.this.jXl != null && d.this.jXl.hot_recomforum != null && !com.baidu.tbadk.core.util.x.isEmpty(d.this.jXl.hot_recomforum.tab_list)) {
                long longValue = ((Long) customResponsedMessage.getData()).longValue();
                DiscoverHotForum.Builder builder = new DiscoverHotForum.Builder(d.this.jXl.hot_recomforum);
                if (c.a(builder, longValue, customResponsedMessage.getCmd() == 2001335)) {
                    d.this.jXl.hot_recomforum = builder.build(true);
                    d.this.a(new DataRes.Builder(d.this.jXl.build(true)));
                }
            }
        }
    };
    RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.concern.d.7
        private int jXz = 0;

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (d.this.fPF != null && !d.this.mIsBackground) {
                d.this.fPF.q(recyclerView, i);
            }
            if (i == 0) {
                s.cva().bRS();
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
            if (d.this.fPF != null && !d.this.mIsBackground) {
                d.this.fPF.onScroll(this.jXz, i);
            }
            this.jXz = i;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921517, Boolean.valueOf(d.this.mIsBackground)));
        }
    };
    private CustomMessageListener jom = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.homepage.concern.d.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && d.this.jXl != null && !com.baidu.tieba.lego.card.c.a.isEmpty(d.this.jXk)) {
                String str = (String) customResponsedMessage.getData();
                if (!TextUtils.isEmpty(str)) {
                    com.baidu.tieba.recapp.a.i(str, d.this.jXk);
                    com.baidu.tieba.recapp.a.i(str, d.this.jXl.app_list);
                    com.baidu.tieba.recapp.a.i(str, d.this.jXt);
                    com.baidu.tieba.recapp.a.fM(d.this.jXk);
                    if (d.this.jXq != null) {
                        d.this.jXq.cC(new ArrayList(d.this.jXk));
                    }
                    d.this.dT(d.this.jXk);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921517, Boolean.valueOf(d.this.mIsBackground)));
                }
            }
        }
    };
    private View.OnTouchListener bTP = new View.OnTouchListener() { // from class: com.baidu.tieba.homepage.concern.d.9
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (d.this.fAY != null) {
                d.this.fAY.onTouch(view, motionEvent);
            }
            if (d.this.jJI != null) {
                d.this.jJI.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private CustomMessageListener jXv = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.homepage.concern.d.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.this.g(customResponsedMessage);
        }
    };
    private CustomMessageListener iNX = new CustomMessageListener(CmdConfigCustom.CMD_THREAD_NOT_EXIST_WHEN_ENTER_PB) { // from class: com.baidu.tieba.homepage.concern.d.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.this.g(customResponsedMessage);
        }
    };
    private CustomMessageListener jXw = new CustomMessageListener(2921425) { // from class: com.baidu.tieba.homepage.concern.d.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.this.cQP();
        }
    };

    /* loaded from: classes2.dex */
    public interface a {
        void Mi(String str);

        void ah(boolean z, boolean z2);

        void cQJ();

        void cQK();

        void onError(int i, String str);
    }

    public void setTabInForeBackgroundState(boolean z) {
        this.mIsBackground = z;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921517, Boolean.valueOf(this.mIsBackground)));
    }

    public void qD(boolean z) {
        this.mIsBackground = z;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921517, Boolean.valueOf(this.mIsBackground)));
    }

    public d(f<?> fVar, BdTypeRecyclerView bdTypeRecyclerView, com.baidu.tieba.homepage.concern.a aVar, BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout) {
        this.jlj = bdTypeRecyclerView;
        this.jlj.setOnTouchListener(this.bTP);
        this.jJI = new com.baidu.tieba.f.a();
        this.jXr = new com.baidu.tieba.homepage.concern.b.a();
        this.jXq = aVar;
        bdTypeRecyclerView.setOnScrollListener(this.mOnScrollListener);
        this.jXd = bigdaySwipeRefreshLayout;
        rO(false);
    }

    public void s(BdUniqueId bdUniqueId) {
        this.jXv.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.jXv);
        this.iNX.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.iNX);
        this.jXw.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.jXw);
        this.fdd.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.fdd);
        this.jXu.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_LIKE_FORUM, this.jXu);
        MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_UNLIKE_FORUM, this.jXu);
        this.jom.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.jom);
    }

    public void setRecommendFrsNavigationAnimDispatcher(y yVar) {
        if (yVar != null) {
            this.fPF = yVar.bJd();
            this.fAY = yVar.bJe();
        }
    }

    public void update() {
        if (cQQ() && !this.jXo) {
            boE();
        } else {
            boD();
        }
    }

    public void cQL() {
        this.jXm = new DataRes.Builder(this.jXl.build(true));
    }

    public void cQM() {
        this.jXl = new DataRes.Builder(this.jXm.build(true));
    }

    public void cQN() {
        boD();
    }

    public void bUp() {
        if (!isLoading() && this.hasMore && this.jXj != null) {
            setIsLoading(true);
            this.jXj.Mi(this.pageTag);
        }
    }

    public void a(boolean z, DataRes dataRes, int i, String str) {
        setIsLoading(false);
        if (i != 0 || dataRes == null || !a(true, z, dataRes)) {
            if (i == 0 && com.baidu.tbadk.core.util.x.getCount(this.jXk) == 0 && this.jXj != null) {
                this.jXj.cQK();
                if (this.jXd != null) {
                    this.jXd.setRefreshing(false);
                    return;
                }
                return;
            } else if (this.jXk.size() > 0) {
                if (this.jXj != null) {
                    this.jXj.onError(1, str);
                }
            } else if (this.jXj != null) {
                this.jXj.onError(2, str);
            }
        } else {
            if (this.jXj != null) {
                this.jXj.ah(z, false);
            }
            if (z) {
                cyk();
            }
        }
        if (this.jXd != null) {
            this.jXd.setRefreshing(false);
        }
    }

    public void rN(boolean z) {
        if (z) {
            this.jXq.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void boD() {
        if (this.jXj != null) {
            this.jXj.cQJ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(DataRes dataRes) {
        this.jXo = true;
        rO(true);
        if (dataRes != null) {
            if (a(false, true, dataRes)) {
                if (this.jXj != null) {
                    this.jXj.ah(false, true);
                    return;
                }
                return;
            }
            boD();
            return;
        }
        boD();
    }

    private List<n> a(boolean z, DataRes.Builder builder, boolean z2) {
        if (this.jXl == null) {
            this.jXl = new DataRes.Builder();
        }
        if (builder == null) {
            builder = new DataRes.Builder();
        }
        com.baidu.tieba.homepage.personalize.model.c a2 = this.jXr.a(z, this.jXl, builder, z2 ? 0 : 1);
        if (a2 == null) {
            return null;
        }
        return a2.geK;
    }

    public void aB(bz bzVar) {
        bzVar.jF(true);
        com.baidu.tbadk.a.a.a.a(bzVar);
        List<n> a2 = this.jXr.a(bzVar, -1, null);
        if ((this.jXl == null || com.baidu.tbadk.core.util.x.getCount(this.jXl.thread_info) <= 0) && com.baidu.tbadk.core.util.x.getCount(this.jXk) <= 1) {
            this.jXk.clear();
        }
        this.jXk.addAll(0, a2);
        this.jXq.cC(this.jXk);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setList(List<n> list) {
        this.jXq.cC(list);
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
        int eN = this.mPn == 1 ? 0 : com.baidu.tieba.lego.card.c.a.eN(this.jXl.thread_info);
        this.pageTag = dataRes.page_tag;
        this.jXn = new DataRes.Builder(dataRes);
        if (cQQ()) {
            Mk(this.pageTag);
        }
        LinkedList linkedList = new LinkedList();
        DataRes.Builder builder = new DataRes.Builder(dataRes);
        this.jXs = builder.user_tips_type.intValue();
        if (dataRes.req_unix != null) {
            com.baidu.tbadk.core.sharedPref.b.bvq().putLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(SharedPrefConfig.CONCERN_DATA_RES_REQUEST_TIME), dataRes.req_unix.longValue());
        }
        List<n> a2 = a(z, builder, z2);
        a(a2, builder, eN);
        this.jXp = false;
        if (a2 != null && TbadkCoreApplication.isLogin()) {
            if (com.baidu.tbadk.core.util.x.isEmpty(a2) || (com.baidu.tbadk.core.util.x.getCount(a2) == 1 && (com.baidu.tbadk.core.util.x.getItem(a2, 0) instanceof com.baidu.tieba.homepage.concern.a.a))) {
                if (3 == this.jXs) {
                    com.baidu.tieba.homepage.concern.a.b bVar = new com.baidu.tieba.homepage.concern.a.b();
                    bVar.jYG = com.baidu.tieba.homepage.concern.a.b.jYB;
                    bVar.jYD = 3;
                    a2.add(bVar);
                    this.jXp = true;
                } else if (2 == this.jXs) {
                    com.baidu.tieba.homepage.concern.a.b bVar2 = new com.baidu.tieba.homepage.concern.a.b();
                    bVar2.jYG = com.baidu.tieba.homepage.concern.a.b.jYB;
                    bVar2.jYD = 2;
                    a2.add(bVar2);
                    this.jXp = true;
                }
            }
            linkedList.addAll(a2);
        }
        if (!at.isEmpty(builder.user_tips) && 2 == this.jXs) {
            com.baidu.tieba.homepage.concern.a.b bVar3 = new com.baidu.tieba.homepage.concern.a.b();
            bVar3.jYD = builder.user_tips_type.intValue();
            bVar3.tipString = builder.user_tips;
            if (builder.user_tips_type.intValue() == 4) {
                bVar3.jYE = true;
            } else {
                bVar3.jYF = true;
            }
            if (cQQ() && (bVar3.jYD == 2 || bVar3.jYD == 3)) {
                if (linkedList.size() > 0) {
                    bVar3.jYD = 0;
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
            if (this.jXk.isEmpty()) {
                return false;
            }
            Iterator<n> it = this.jXk.iterator();
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
                this.jXk.remove(nVar);
            }
            this.jXq.cC(this.jXk);
            return false;
        }
        this.jXk.clear();
        this.jXk.addAll(linkedList);
        if (z2) {
            this.jXl.page_tag = dataRes.page_tag;
            this.jXl.has_more = dataRes.has_more;
            this.jXl.user_list = dataRes.user_list;
            this.jXl.user_tips_type = dataRes.user_tips_type;
            this.jXl.user_tips = dataRes.user_tips;
            this.jXl.last_tips = dataRes.last_tips;
        }
        this.jXl.banner_user_story = dataRes.banner_user_story;
        this.jXl.banner_follow_live = dataRes.banner_follow_live;
        this.jXl.hot_recomforum = dataRes.hot_recomforum;
        this.jXl.top_tips = dataRes.top_tips;
        this.jXl.top_user_info = dataRes.top_user_info;
        if (this.jXs == 2 || this.jXs == 3) {
            this.jXl.user_tips_type = dataRes.user_tips_type;
            this.jXl.user_tips = dataRes.user_tips;
        }
        this.jXq.cC(this.jXk);
        return true;
    }

    private void a(List<n> list, DataRes.Builder builder, int i) {
        List<al> dS = dS(com.baidu.tieba.recapp.a.r(builder.app_list, "CONCERN"));
        if (this.jXl == null) {
            this.jXl = new DataRes.Builder();
        }
        if (com.baidu.tieba.lego.card.c.a.isEmpty(this.jXl.app_list)) {
            this.jXl.app_list = new ArrayList();
        }
        this.jXl.app_list.addAll(builder.app_list);
        if (this.mPn == 1 || i == 0) {
            this.jXt.clear();
        }
        dS.addAll(this.jXt);
        if (!com.baidu.tieba.lego.card.c.a.isEmpty(dS)) {
            this.jXt = com.baidu.tieba.recapp.a.b(dS, list, i);
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
        com.baidu.tieba.recapp.report.b.dFU().bN("CONCERN", com.baidu.tieba.recapp.a.fL(list));
    }

    private void boE() {
        long currentTimeMillis = System.currentTimeMillis();
        long cQT = cQT();
        long j = currentTimeMillis - cQT;
        if (cQT == 0 || j > 86400000) {
            ac.a(new ab<DataRes>() { // from class: com.baidu.tieba.homepage.concern.d.10
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.ab
                /* renamed from: cQV */
                public DataRes doInBackground() {
                    com.baidu.tbadk.core.c.a.btS().clearByteCacheWithSapce("tb.concern_page_all", TbadkCoreApplication.getCurrentAccount());
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
                /* renamed from: cQV */
                public DataRes doInBackground() {
                    com.baidu.adp.lib.cache.l<byte[]> dL = com.baidu.tbadk.core.c.a.btS().dL("tb.concern_page_all", TbadkCoreApplication.getCurrentAccount());
                    if (dL == null) {
                        return null;
                    }
                    byte[] bArr = dL.get("0");
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

    private void cyk() {
        if (this.jXn != null) {
            a(this.jXn);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final DataRes.Builder builder) {
        if (cQQ()) {
            ac.a(new ab<Object>() { // from class: com.baidu.tieba.homepage.concern.d.2
                @Override // com.baidu.tbadk.util.ab
                public Object doInBackground() {
                    DataRes.Builder builder2 = new DataRes.Builder(builder.build(true));
                    com.baidu.adp.lib.cache.l<byte[]> dL = com.baidu.tbadk.core.c.a.btS().dL("tb.concern_page_all", TbadkCoreApplication.getCurrentAccount());
                    try {
                        DataRes build = builder2.build(true);
                        if (build != null && !com.baidu.tbadk.core.util.x.isEmpty(build.thread_info)) {
                            dL.setForever("0", build.toByteArray());
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
        this.jXj = aVar;
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

    public boolean cQO() {
        return this.jXp;
    }

    public void onDestroy() {
        this.jXq.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(CustomResponsedMessage<?> customResponsedMessage) {
        ThreadInfo threadInfo;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.jXl != null && com.baidu.tbadk.core.util.x.getCount(this.jXl.thread_info) != 0 && com.baidu.tbadk.core.util.x.getCount(this.jXk) != 0) {
            String optString = ((JSONObject) customResponsedMessage.getData()).optString("tid");
            if (!StringUtils.isNull(optString)) {
                Iterator<n> it = this.jXk.iterator();
                boolean z = false;
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    n next = it.next();
                    if (next instanceof com.baidu.tieba.card.data.b) {
                        com.baidu.tieba.card.data.b bVar = (com.baidu.tieba.card.data.b) next;
                        if (bVar.boO() != null && bVar.boO().getTid() != null) {
                            if (bVar.boO().getTid().equals(optString)) {
                                z = true;
                                it.remove();
                            } else if (z) {
                                if (this.jXq != null) {
                                    this.jXq.cC(this.jXk);
                                }
                            }
                        }
                    }
                    z = z;
                }
                long j = com.baidu.adp.lib.f.b.toLong(optString, 0L);
                for (int i = 0; i < this.jXl.thread_info.size(); i++) {
                    ConcernData concernData = this.jXl.thread_info.get(i);
                    if (concernData != null && (threadInfo = concernData.thread_list) != null && threadInfo.tid != null && threadInfo.tid.longValue() == j) {
                        this.jXl.thread_info.remove(i);
                        cyk();
                        return;
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cQP() {
        if (this.jXl != null && com.baidu.tbadk.core.util.x.getCount(this.jXl.thread_info) != 0 && com.baidu.tbadk.core.util.x.getCount(this.jXk) != 0) {
            int i = 0;
            while (true) {
                if (i >= this.jXk.size()) {
                    break;
                } else if (!(this.jXk.get(i) instanceof com.baidu.tieba.homepage.concern.a.a)) {
                    i++;
                } else {
                    this.jXk.remove(i);
                    if (this.jXq != null) {
                        this.jXq.cC(this.jXk);
                    }
                }
            }
            for (int i2 = 0; i2 < this.jXl.thread_info.size(); i2++) {
                if (com.baidu.tieba.homepage.concern.a.a.a(this.jXl.thread_info.get(i2))) {
                    this.jXl.thread_info.remove(i2);
                    cyk();
                    return;
                }
            }
        }
    }

    public static boolean cQQ() {
        return com.baidu.tbadk.a.d.bmN() && com.baidu.tbadk.core.sharedPref.b.bvq().getInt("key_home_concern_all_status", 0) == 0;
    }

    public static void Mk(String str) {
        com.baidu.tbadk.core.sharedPref.b.bvq().putString(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("key_home_concern_all_status_cache_nextpage_key"), str);
    }

    public static String cQR() {
        return com.baidu.tbadk.core.sharedPref.b.bvq().getString(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("key_home_concern_all_status_cache_nextpage_key"), "");
    }

    public static void Ml(String str) {
        com.baidu.tbadk.core.sharedPref.b.bvq().putString(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("key_home_concern_all_status_cache_nextpage_update_key"), str);
    }

    public static String cQS() {
        return com.baidu.tbadk.core.sharedPref.b.bvq().getString(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("key_home_concern_all_status_cache_nextpage_update_key"), "");
    }

    public static void gx(long j) {
        com.baidu.tbadk.core.sharedPref.b.bvq().putLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("key_home_concern_all_status_cache_time"), j);
    }

    public static long cQT() {
        return com.baidu.tbadk.core.sharedPref.b.bvq().getLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("key_home_concern_all_status_cache_time"), 0L);
    }

    public static boolean cQU() {
        return com.baidu.tbadk.core.sharedPref.b.bvq().getBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("key_home_concern_all_status_cache_loaded"), false);
    }

    public static void rO(boolean z) {
        com.baidu.tbadk.core.sharedPref.b.bvq().putBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("key_home_concern_all_status_cache_loaded"), z);
    }
}
