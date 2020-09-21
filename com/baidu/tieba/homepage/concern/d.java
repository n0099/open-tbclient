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
/* loaded from: classes21.dex */
public class d {
    private View.OnTouchListener eKp;
    private aa eYx;
    private boolean hasMore;
    private com.baidu.tieba.f.a iBM;
    private final com.baidu.tieba.homepage.concern.a iOC;
    private final com.baidu.tieba.homepage.concern.b.a iOD;
    private int iOE;
    private BigdaySwipeRefreshLayout iOr;
    private DataRes.Builder iOz;
    private final BdTypeRecyclerView iga;
    private String pageTag;
    private a iOx = null;
    private final LinkedList<q> iOy = new LinkedList<>();
    private boolean mIsLoading = false;
    private boolean iOA = false;
    private boolean iOB = false;
    private boolean mIsBackground = false;
    private CustomMessageListener ena = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.homepage.concern.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (data.eEj == null) {
                    if (!data.isSucc) {
                        BdToast.a(TbadkCoreApplication.getInst().getContext(), updateAttentionMessage.getData().errorString, R.drawable.icon_pure_toast_mistake40_svg, 3000, true).big();
                    } else if (!data.isAttention) {
                        Iterator it = d.this.iOy.iterator();
                        while (it.hasNext()) {
                            Object next = it.next();
                            if ((next instanceof com.baidu.tieba.card.data.c) && ay.h(((com.baidu.tieba.card.data.c) next).bcY(), data.toUid)) {
                                it.remove();
                            }
                        }
                        if (d.this.iOy.size() < 9) {
                            d.this.bcP();
                            return;
                        }
                        d.this.setList(d.this.iOy);
                        d.this.iOC.notifyDataSetChanged();
                        if (d.this.iOx != null) {
                            d.this.iOx.ad(false, false);
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener iOF = new CustomMessageListener(0) { // from class: com.baidu.tieba.homepage.concern.d.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long) && d.this.iOz != null && d.this.iOz.hot_recomforum != null && !y.isEmpty(d.this.iOz.hot_recomforum.tab_list)) {
                long longValue = ((Long) customResponsedMessage.getData()).longValue();
                DiscoverHotForum.Builder builder = new DiscoverHotForum.Builder(d.this.iOz.hot_recomforum);
                if (c.a(builder, longValue, customResponsedMessage.getCmd() == 2001335)) {
                    d.this.iOz.hot_recomforum = builder.build(true);
                    d.this.a(new DataRes.Builder(d.this.iOz.build(true)));
                }
            }
        }
    };
    RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.concern.d.4
        private int iOJ = 0;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (d.this.eYx != null && !d.this.mIsBackground) {
                d.this.eYx.k(recyclerView, i);
            }
            if (i == 0) {
                s.cfn().bFm();
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
            if (d.this.eYx != null && !d.this.mIsBackground) {
                d.this.eYx.onScroll(this.iOJ, i);
            }
            this.iOJ = i;
        }
    };
    private View.OnTouchListener eYy = new View.OnTouchListener() { // from class: com.baidu.tieba.homepage.concern.d.5
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (d.this.eKp != null) {
                d.this.eKp.onTouch(view, motionEvent);
            }
            if (d.this.iBM != null) {
                d.this.iBM.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private CustomMessageListener iOG = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.homepage.concern.d.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.this.g(customResponsedMessage);
        }
    };
    private CustomMessageListener hIJ = new CustomMessageListener(CmdConfigCustom.CMD_THREAD_NOT_EXIST_WHEN_ENTER_PB) { // from class: com.baidu.tieba.homepage.concern.d.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.this.g(customResponsedMessage);
        }
    };
    private CustomMessageListener iOH = new CustomMessageListener(2921425) { // from class: com.baidu.tieba.homepage.concern.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.this.czH();
        }
    };

    /* loaded from: classes21.dex */
    public interface a {
        void JY(String str);

        void ad(boolean z, boolean z2);

        void czD();

        void czE();

        void onError(int i, String str);
    }

    public void setTabInForeBackgroundState(boolean z) {
        this.mIsBackground = z;
    }

    public void oz(boolean z) {
        this.mIsBackground = z;
    }

    public d(e<?> eVar, BdTypeRecyclerView bdTypeRecyclerView, com.baidu.tieba.homepage.concern.a aVar, BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout) {
        this.iga = bdTypeRecyclerView;
        this.iga.setOnTouchListener(this.eYy);
        this.iBM = new com.baidu.tieba.f.a();
        this.iOD = new com.baidu.tieba.homepage.concern.b.a();
        this.iOC = aVar;
        bdTypeRecyclerView.setOnScrollListener(this.mOnScrollListener);
        this.iOr = bigdaySwipeRefreshLayout;
    }

    public void s(BdUniqueId bdUniqueId) {
        this.iOG.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.iOG);
        this.hIJ.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.hIJ);
        this.iOH.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.iOH);
        this.ena.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.ena);
        this.iOF.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_LIKE_FORUM, this.iOF);
        MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_UNLIKE_FORUM, this.iOF);
    }

    public void setRecommendFrsNavigationAnimDispatcher(ab abVar) {
        if (abVar != null) {
            this.eYx = abVar.bwQ();
            this.eKp = abVar.bwR();
        }
    }

    public void update() {
        if (this.iOy.size() == 0 && !this.iOA) {
            bcQ();
        } else {
            bcP();
        }
    }

    public void czF() {
        bcP();
    }

    public void bGU() {
        if (!isLoading() && this.hasMore && this.iOx != null) {
            setIsLoading(true);
            this.iOx.JY(this.pageTag);
        }
    }

    public void a(boolean z, DataRes dataRes, int i, String str) {
        setIsLoading(false);
        if (i != 0 || dataRes == null || !a(true, z, dataRes)) {
            if (i == 0 && y.getCount(this.iOy) == 0 && this.iOx != null) {
                this.iOx.czE();
                if (this.iOr != null) {
                    this.iOr.setRefreshing(false);
                    return;
                }
                return;
            } else if (this.iOy.size() > 0) {
                if (this.iOx != null) {
                    this.iOx.onError(1, str);
                }
            } else if (this.iOx != null) {
                this.iOx.onError(2, str);
            }
        } else {
            if (this.iOx != null) {
                this.iOx.ad(z, false);
            }
            civ();
        }
        if (this.iOr != null) {
            this.iOr.setRefreshing(false);
        }
    }

    public void pG(boolean z) {
        if (z) {
            this.iOC.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bcP() {
        if (this.iOx != null) {
            this.iOx.czD();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(DataRes dataRes) {
        this.iOA = true;
        if (dataRes != null) {
            if (a(false, true, dataRes)) {
                if (this.iOx != null) {
                    this.iOx.ad(false, true);
                    return;
                }
                return;
            }
            bcP();
            return;
        }
        bcP();
    }

    private List<q> a(boolean z, DataRes.Builder builder, boolean z2) {
        if (this.iOz == null) {
            this.iOz = new DataRes.Builder();
        }
        if (builder == null) {
            builder = new DataRes.Builder();
        }
        com.baidu.tieba.homepage.personalize.model.c a2 = this.iOD.a(z, this.iOz, builder, z2 ? 0 : 1);
        if (a2 == null) {
            return null;
        }
        return a2.fnr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setList(List<q> list) {
        this.iOC.bX(list);
    }

    private boolean a(boolean z, boolean z2, DataRes dataRes) {
        q qVar;
        if (dataRes == null) {
            return false;
        }
        this.pageTag = dataRes.page_tag;
        LinkedList linkedList = new LinkedList();
        DataRes.Builder builder = new DataRes.Builder(dataRes);
        this.iOE = builder.user_tips_type.intValue();
        if (dataRes.req_unix != null) {
            com.baidu.tbadk.core.sharedPref.b.bjf().putLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(SharedPrefConfig.CONCERN_DATA_RES_REQUEST_TIME), dataRes.req_unix.longValue());
        }
        List<q> a2 = a(z, builder, z2);
        this.iOB = false;
        if (a2 != null && TbadkCoreApplication.isLogin()) {
            if (3 == this.iOE) {
                if (y.isEmpty(a2)) {
                    a2.add(new com.baidu.tieba.homepage.concern.a.a());
                    this.iOB = true;
                } else if (y.getCount(a2) == 1 && (y.getItem(a2, 0) instanceof com.baidu.tieba.homepage.concern.a.b)) {
                    a2.add(new com.baidu.tieba.homepage.concern.a.a());
                    this.iOB = true;
                }
            }
            linkedList.addAll(a2);
        }
        if (!at.isEmpty(builder.user_tips) && 2 == this.iOE) {
            com.baidu.tieba.homepage.concern.a.c cVar = new com.baidu.tieba.homepage.concern.a.c();
            cVar.iPG = builder.user_tips_type.intValue();
            cVar.tipString = builder.user_tips;
            if (builder.user_tips_type.intValue() == 4) {
                cVar.iPH = true;
            } else {
                cVar.iPI = true;
            }
            linkedList.add(cVar);
        }
        this.hasMore = builder.has_more.intValue() == 1;
        if (y.isEmpty(linkedList)) {
            if (this.iOy.isEmpty()) {
                return false;
            }
            Iterator<q> it = this.iOy.iterator();
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
                this.iOy.remove(qVar);
            }
            this.iOC.bX(this.iOy);
            return false;
        }
        this.iOy.clear();
        this.iOy.addAll(linkedList);
        if (z2) {
            this.iOz.page_tag = dataRes.page_tag;
            this.iOz.has_more = dataRes.has_more;
            this.iOz.user_list = dataRes.user_list;
            this.iOz.user_tips_type = dataRes.user_tips_type;
            this.iOz.user_tips = dataRes.user_tips;
            this.iOz.last_tips = dataRes.last_tips;
        }
        this.iOz.banner_user_story = dataRes.banner_user_story;
        this.iOz.banner_follow_live = dataRes.banner_follow_live;
        this.iOz.hot_recomforum = dataRes.hot_recomforum;
        this.iOz.top_tips = dataRes.top_tips;
        this.iOz.top_user_info = dataRes.top_user_info;
        if (this.iOE == 2 || this.iOE == 3) {
            this.iOz.user_tips_type = dataRes.user_tips_type;
            this.iOz.user_tips = dataRes.user_tips;
        }
        this.iOC.bX(this.iOy);
        return true;
    }

    private void bcQ() {
        ae.a(new ad<DataRes>() { // from class: com.baidu.tieba.homepage.concern.d.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.ad
            /* renamed from: czI */
            public DataRes doInBackground() {
                l<byte[]> dv = com.baidu.tbadk.core.c.a.bhV().dv("tb.concern_page", TbadkCoreApplication.getCurrentAccount());
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
        }, new m<DataRes>() { // from class: com.baidu.tieba.homepage.concern.d.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.m
            /* renamed from: b */
            public void onReturnDataInUI(DataRes dataRes) {
                d.this.a(dataRes);
            }
        });
    }

    private void civ() {
        if (this.iOz != null) {
            DataRes.Builder builder = new DataRes.Builder(this.iOz.build(true));
            if (builder.thread_info != null && builder.thread_info.size() > 30) {
                builder.thread_info = builder.thread_info.subList(0, 30);
            }
            a(builder);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final DataRes.Builder builder) {
        ae.a(new ad<Object>() { // from class: com.baidu.tieba.homepage.concern.d.8
            @Override // com.baidu.tbadk.util.ad
            public Object doInBackground() {
                DataRes.Builder builder2 = new DataRes.Builder(builder.build(true));
                try {
                    com.baidu.tbadk.core.c.a.bhV().dv("tb.concern_page", TbadkCoreApplication.getCurrentAccount()).setForever("0", builder2.build(true).toByteArray());
                    return null;
                } catch (Exception e) {
                    BdLog.e(e);
                    return null;
                }
            }
        }, null);
    }

    public void a(a aVar) {
        this.iOx = aVar;
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

    public boolean czG() {
        return this.iOB;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(CustomResponsedMessage<?> customResponsedMessage) {
        ThreadInfo threadInfo;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.iOz != null && y.getCount(this.iOz.thread_info) != 0 && y.getCount(this.iOy) != 0) {
            String optString = ((JSONObject) customResponsedMessage.getData()).optString("tid");
            if (!StringUtils.isNull(optString)) {
                Iterator<q> it = this.iOy.iterator();
                boolean z = false;
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    q next = it.next();
                    if (next instanceof com.baidu.tieba.card.data.c) {
                        com.baidu.tieba.card.data.c cVar = (com.baidu.tieba.card.data.c) next;
                        if (cVar.bcY() != null && cVar.bcY().getTid() != null) {
                            if (cVar.bcY().getTid().equals(optString)) {
                                z = true;
                                it.remove();
                            } else if (z) {
                                if (this.iOC != null) {
                                    this.iOC.bX(this.iOy);
                                }
                            }
                        }
                    }
                    z = z;
                }
                long j = com.baidu.adp.lib.f.b.toLong(optString, 0L);
                for (int i = 0; i < this.iOz.thread_info.size(); i++) {
                    ConcernData concernData = this.iOz.thread_info.get(i);
                    if (concernData != null && (threadInfo = concernData.thread_list) != null && threadInfo.tid != null && threadInfo.tid.longValue() == j) {
                        this.iOz.thread_info.remove(i);
                        civ();
                        return;
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void czH() {
        if (this.iOz != null && y.getCount(this.iOz.thread_info) != 0 && y.getCount(this.iOy) != 0) {
            int i = 0;
            while (true) {
                if (i >= this.iOy.size()) {
                    break;
                } else if (!(this.iOy.get(i) instanceof com.baidu.tieba.homepage.concern.a.b)) {
                    i++;
                } else {
                    this.iOy.remove(i);
                    if (this.iOC != null) {
                        this.iOC.bX(this.iOy);
                    }
                }
            }
            for (int i2 = 0; i2 < this.iOz.thread_info.size(); i2++) {
                if (com.baidu.tieba.homepage.concern.a.b.a(this.iOz.thread_info.get(i2))) {
                    this.iOz.thread_info.remove(i2);
                    civ();
                    return;
                }
            }
        }
    }
}
