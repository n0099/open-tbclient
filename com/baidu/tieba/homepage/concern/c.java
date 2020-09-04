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
import com.baidu.tbadk.util.ac;
import com.baidu.tbadk.util.ad;
import com.baidu.tbadk.util.z;
import com.baidu.tieba.R;
import com.baidu.tieba.card.s;
import com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout;
import com.squareup.wire.Wire;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;
import tbclient.ThreadInfo;
import tbclient.Userlike.ConcernData;
import tbclient.Userlike.DataRes;
/* loaded from: classes16.dex */
public class c {
    private View.OnTouchListener eIi;
    private z eVG;
    private final BdTypeRecyclerView hYW;
    private boolean hasMore;
    private BigdaySwipeRefreshLayout iGH;
    private DataRes.Builder iGO;
    private final com.baidu.tieba.homepage.concern.a iGR;
    private final com.baidu.tieba.homepage.concern.c.a iGS;
    private int iGT;
    private com.baidu.tieba.f.a iuq;
    private String pageTag;
    private a iGM = null;
    private final LinkedList<q> iGN = new LinkedList<>();
    private boolean mIsLoading = false;
    private boolean iGP = false;
    private boolean iGQ = false;
    private boolean mIsBackground = false;
    private CustomMessageListener ekL = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.homepage.concern.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (data.eCe == null) {
                    if (!data.isSucc) {
                        BdToast.a(TbadkCoreApplication.getInst().getContext(), updateAttentionMessage.getData().errorString, R.drawable.icon_pure_toast_mistake40_svg, 3000, true).bhm();
                    } else if (!data.isAttention) {
                        Iterator it = c.this.iGN.iterator();
                        while (it.hasNext()) {
                            Object next = it.next();
                            if ((next instanceof com.baidu.tieba.card.data.c) && ay.h(((com.baidu.tieba.card.data.c) next).bce(), data.toUid)) {
                                it.remove();
                            }
                        }
                        if (c.this.iGN.size() < 9) {
                            c.this.bbV();
                            return;
                        }
                        c.this.setList(c.this.iGN);
                        c.this.iGR.notifyDataSetChanged();
                        if (c.this.iGM != null) {
                            c.this.iGM.ab(false, false);
                        }
                    }
                }
            }
        }
    };
    RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.concern.c.2
        private int iGX = 0;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (c.this.eVG != null && !c.this.mIsBackground) {
                c.this.eVG.k(recyclerView, i);
            }
            if (i == 0) {
                s.cbY().bDW();
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
            if (c.this.eVG != null && !c.this.mIsBackground) {
                c.this.eVG.onScroll(this.iGX, i);
            }
            this.iGX = i;
        }
    };
    private View.OnTouchListener eVH = new View.OnTouchListener() { // from class: com.baidu.tieba.homepage.concern.c.3
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (c.this.eIi != null) {
                c.this.eIi.onTouch(view, motionEvent);
            }
            if (c.this.iuq != null) {
                c.this.iuq.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private CustomMessageListener iGU = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.homepage.concern.c.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c.this.g(customResponsedMessage);
        }
    };
    private CustomMessageListener hBH = new CustomMessageListener(CmdConfigCustom.CMD_THREAD_NOT_EXIST_WHEN_ENTER_PB) { // from class: com.baidu.tieba.homepage.concern.c.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c.this.g(customResponsedMessage);
        }
    };
    private CustomMessageListener iGV = new CustomMessageListener(2921425) { // from class: com.baidu.tieba.homepage.concern.c.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c.this.cwn();
        }
    };

    /* loaded from: classes16.dex */
    public interface a {
        void JA(String str);

        void ab(boolean z, boolean z2);

        void cwj();

        void cwk();

        void onError(int i, String str);
    }

    public void setTabInForeBackgroundState(boolean z) {
        this.mIsBackground = z;
    }

    public void ot(boolean z) {
        this.mIsBackground = z;
    }

    public c(e<?> eVar, BdTypeRecyclerView bdTypeRecyclerView, com.baidu.tieba.homepage.concern.a aVar, BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout) {
        this.hYW = bdTypeRecyclerView;
        this.hYW.setOnTouchListener(this.eVH);
        this.iuq = new com.baidu.tieba.f.a();
        this.iGS = new com.baidu.tieba.homepage.concern.c.a();
        this.iGR = aVar;
        bdTypeRecyclerView.setOnScrollListener(this.mOnScrollListener);
        this.iGH = bigdaySwipeRefreshLayout;
    }

    public void t(BdUniqueId bdUniqueId) {
        this.iGU.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.iGU);
        this.hBH.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.hBH);
        this.iGV.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.iGV);
        this.ekL.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.ekL);
    }

    public void setRecommendFrsNavigationAnimDispatcher(aa aaVar) {
        if (aaVar != null) {
            this.eVG = aaVar.bvH();
            this.eIi = aaVar.bvI();
        }
    }

    public void update() {
        if (this.iGN.size() == 0 && !this.iGP) {
            bbW();
        } else {
            bbV();
        }
    }

    public void cwl() {
        bbV();
    }

    public void bFE() {
        if (!isLoading() && this.hasMore && this.iGM != null) {
            setIsLoading(true);
            this.iGM.JA(this.pageTag);
        }
    }

    public void a(boolean z, DataRes dataRes, int i, String str) {
        setIsLoading(false);
        if (i != 0 || dataRes == null || !a(true, z, dataRes)) {
            if (i == 0 && y.getCount(this.iGN) == 0 && this.iGM != null) {
                this.iGM.cwk();
                if (this.iGH != null) {
                    this.iGH.setRefreshing(false);
                    return;
                }
                return;
            } else if (this.iGN.size() > 0) {
                if (this.iGM != null) {
                    this.iGM.onError(1, str);
                }
            } else if (this.iGM != null) {
                this.iGM.onError(2, str);
            }
        } else {
            if (this.iGM != null) {
                this.iGM.ab(z, false);
            }
            cfg();
        }
        if (this.iGH != null) {
            this.iGH.setRefreshing(false);
        }
    }

    public void pA(boolean z) {
        if (z) {
            this.iGR.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bbV() {
        if (this.iGM != null) {
            this.iGM.cwj();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(DataRes dataRes) {
        this.iGP = true;
        if (dataRes != null) {
            if (a(false, true, dataRes)) {
                if (this.iGM != null) {
                    this.iGM.ab(false, true);
                    return;
                }
                return;
            }
            bbV();
            return;
        }
        bbV();
    }

    private List<q> a(boolean z, DataRes.Builder builder, boolean z2) {
        if (this.iGO == null) {
            this.iGO = new DataRes.Builder();
        }
        if (builder == null) {
            builder = new DataRes.Builder();
        }
        com.baidu.tieba.homepage.personalize.model.c a2 = this.iGS.a(z, this.iGO, builder, z2 ? 0 : 1);
        if (a2 == null) {
            return null;
        }
        return a2.fky;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setList(List<q> list) {
        this.iGR.bS(list);
    }

    private boolean a(boolean z, boolean z2, DataRes dataRes) {
        q qVar;
        if (dataRes == null) {
            return false;
        }
        this.pageTag = dataRes.page_tag;
        LinkedList linkedList = new LinkedList();
        DataRes.Builder builder = new DataRes.Builder(dataRes);
        this.iGT = builder.user_tips_type.intValue();
        if (dataRes.req_unix != null) {
            com.baidu.tbadk.core.sharedPref.b.bik().putLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(SharedPrefConfig.CONCERN_DATA_RES_REQUEST_TIME), dataRes.req_unix.longValue());
        }
        List<q> a2 = a(z, builder, z2);
        this.iGQ = false;
        if (a2 != null && TbadkCoreApplication.isLogin()) {
            if (3 == this.iGT) {
                if (y.isEmpty(a2)) {
                    a2.add(new com.baidu.tieba.homepage.concern.b.a());
                    this.iGQ = true;
                } else if (y.getCount(a2) == 1 && (y.getItem(a2, 0) instanceof com.baidu.tieba.homepage.concern.b.b)) {
                    a2.add(new com.baidu.tieba.homepage.concern.b.a());
                    this.iGQ = true;
                }
            }
            linkedList.addAll(a2);
        }
        if (!at.isEmpty(builder.user_tips) && 2 == this.iGT) {
            com.baidu.tieba.homepage.concern.b.c cVar = new com.baidu.tieba.homepage.concern.b.c();
            cVar.iHQ = builder.user_tips_type.intValue();
            cVar.tipString = builder.user_tips;
            if (builder.user_tips_type.intValue() == 4) {
                cVar.iHR = true;
            } else {
                cVar.iHS = true;
            }
            linkedList.add(cVar);
        }
        this.hasMore = builder.has_more.intValue() == 1;
        if (y.isEmpty(linkedList)) {
            if (this.iGN.isEmpty()) {
                return false;
            }
            Iterator<q> it = this.iGN.iterator();
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
                this.iGN.remove(qVar);
            }
            this.iGR.bS(this.iGN);
            return false;
        }
        this.iGN.clear();
        this.iGN.addAll(linkedList);
        if (z2) {
            this.iGO.page_tag = dataRes.page_tag;
            this.iGO.has_more = dataRes.has_more;
            this.iGO.user_list = dataRes.user_list;
            this.iGO.user_tips_type = dataRes.user_tips_type;
            this.iGO.user_tips = dataRes.user_tips;
            this.iGO.last_tips = dataRes.last_tips;
        }
        this.iGO.banner_user_story = dataRes.banner_user_story;
        this.iGO.banner_follow_live = dataRes.banner_follow_live;
        this.iGO.top_tips = dataRes.top_tips;
        this.iGO.top_user_info = dataRes.top_user_info;
        if (this.iGT == 2 || this.iGT == 3) {
            this.iGO.user_tips_type = dataRes.user_tips_type;
            this.iGO.user_tips = dataRes.user_tips;
        }
        this.iGR.bS(this.iGN);
        return true;
    }

    private void bbW() {
        ad.a(new ac<DataRes>() { // from class: com.baidu.tieba.homepage.concern.c.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.ac
            /* renamed from: cwo */
            public DataRes doInBackground() {
                l<byte[]> dv = com.baidu.tbadk.core.c.a.bhb().dv("tb.concern_page", TbadkCoreApplication.getCurrentAccount());
                if (dv == null) {
                    return null;
                }
                byte[] bArr = dv.get("0");
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
        }, new com.baidu.tbadk.util.l<DataRes>() { // from class: com.baidu.tieba.homepage.concern.c.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.l
            /* renamed from: b */
            public void onReturnDataInUI(DataRes dataRes) {
                c.this.a(dataRes);
            }
        });
    }

    private void cfg() {
        if (this.iGO != null) {
            DataRes.Builder builder = new DataRes.Builder(this.iGO.build(true));
            if (builder.thread_info != null && builder.thread_info.size() > 30) {
                builder.thread_info = builder.thread_info.subList(0, 30);
            }
            a(builder);
        }
    }

    private void a(final DataRes.Builder builder) {
        ad.a(new ac<Object>() { // from class: com.baidu.tieba.homepage.concern.c.6
            @Override // com.baidu.tbadk.util.ac
            public Object doInBackground() {
                DataRes.Builder builder2 = new DataRes.Builder(builder.build(true));
                try {
                    com.baidu.tbadk.core.c.a.bhb().dv("tb.concern_page", TbadkCoreApplication.getCurrentAccount()).setForever("0", builder2.build(true).toByteArray());
                    return null;
                } catch (Exception e) {
                    BdLog.e(e);
                    return null;
                }
            }
        }, null);
    }

    public void a(a aVar) {
        this.iGM = aVar;
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

    public boolean cwm() {
        return this.iGQ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(CustomResponsedMessage<?> customResponsedMessage) {
        ThreadInfo threadInfo;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.iGO != null && y.getCount(this.iGO.thread_info) != 0 && y.getCount(this.iGN) != 0) {
            String optString = ((JSONObject) customResponsedMessage.getData()).optString("tid");
            if (!StringUtils.isNull(optString)) {
                Iterator<q> it = this.iGN.iterator();
                boolean z = false;
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    q next = it.next();
                    if (next instanceof com.baidu.tieba.card.data.c) {
                        com.baidu.tieba.card.data.c cVar = (com.baidu.tieba.card.data.c) next;
                        if (cVar.bce() != null && cVar.bce().getTid() != null) {
                            if (cVar.bce().getTid().equals(optString)) {
                                z = true;
                                it.remove();
                            } else if (z) {
                                if (this.iGR != null) {
                                    this.iGR.bS(this.iGN);
                                }
                            }
                        }
                    }
                    z = z;
                }
                long j = com.baidu.adp.lib.f.b.toLong(optString, 0L);
                for (int i = 0; i < this.iGO.thread_info.size(); i++) {
                    ConcernData concernData = this.iGO.thread_info.get(i);
                    if (concernData != null && (threadInfo = concernData.thread_list) != null && threadInfo.tid != null && threadInfo.tid.longValue() == j) {
                        this.iGO.thread_info.remove(i);
                        cfg();
                        return;
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cwn() {
        if (this.iGO != null && y.getCount(this.iGO.thread_info) != 0 && y.getCount(this.iGN) != 0) {
            int i = 0;
            while (true) {
                if (i >= this.iGN.size()) {
                    break;
                } else if (!(this.iGN.get(i) instanceof com.baidu.tieba.homepage.concern.b.b)) {
                    i++;
                } else {
                    this.iGN.remove(i);
                    if (this.iGR != null) {
                        this.iGR.bS(this.iGN);
                    }
                }
            }
            for (int i2 = 0; i2 < this.iGO.thread_info.size(); i2++) {
                if (com.baidu.tieba.homepage.concern.b.b.a(this.iGO.thread_info.get(i2))) {
                    this.iGO.thread_info.remove(i2);
                    cfg();
                    return;
                }
            }
        }
    }
}
