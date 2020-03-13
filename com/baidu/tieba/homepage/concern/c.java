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
import com.baidu.adp.widget.ListView.m;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tbadk.util.ab;
import com.baidu.tbadk.util.ac;
import com.baidu.tbadk.util.y;
import com.baidu.tbadk.util.z;
import com.baidu.tieba.R;
import com.baidu.tieba.card.r;
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
/* loaded from: classes9.dex */
public class c {
    private y dHb;
    private View.OnTouchListener duf;
    private com.baidu.tieba.f.a gMC;
    private BigdaySwipeRefreshLayout gXi;
    private DataRes.Builder gXp;
    private final com.baidu.tieba.homepage.concern.a gXs;
    private final com.baidu.tieba.homepage.concern.c.a gXt;
    private int gXu;
    private final BdTypeRecyclerView gtd;
    private boolean hasMore;
    private String pageTag;
    private a gXn = null;
    private final LinkedList<m> gXo = new LinkedList<>();
    private boolean mIsLoading = false;
    private boolean gXq = false;
    private boolean gXr = false;
    private boolean mIsBackground = false;
    private CustomMessageListener dag = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.homepage.concern.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (data.doi == null) {
                    if (!data.isSucc) {
                        BdToast.a(TbadkCoreApplication.getInst().getContext(), updateAttentionMessage.getData().errorString, R.drawable.icon_pure_toast_mistake40_svg, 3000, true).aEH();
                    } else if (!data.isAttention) {
                        Iterator it = c.this.gXo.iterator();
                        while (it.hasNext()) {
                            Object next = it.next();
                            if ((next instanceof com.baidu.tieba.card.data.c) && au.a(((com.baidu.tieba.card.data.c) next).aAg(), data.toUid)) {
                                it.remove();
                            }
                        }
                        if (c.this.gXo.size() < 9) {
                            c.this.azX();
                            return;
                        }
                        c.this.setList(c.this.gXo);
                        c.this.gXs.notifyDataSetChanged();
                        if (c.this.gXn != null) {
                            c.this.gXn.S(false, false);
                        }
                    }
                }
            }
        }
    };
    RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.concern.c.2
        private int gXy = 0;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (c.this.dHb != null && !c.this.mIsBackground) {
                c.this.dHb.l(recyclerView, i);
            }
            if (i == 0) {
                r.bvh().bbS();
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
            if (c.this.dHb != null && !c.this.mIsBackground) {
                c.this.dHb.onScroll(this.gXy, i);
            }
            this.gXy = i;
        }
    };
    private View.OnTouchListener drN = new View.OnTouchListener() { // from class: com.baidu.tieba.homepage.concern.c.3
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (c.this.duf != null) {
                c.this.duf.onTouch(view, motionEvent);
            }
            if (c.this.gMC != null) {
                c.this.gMC.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private CustomMessageListener gXv = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.homepage.concern.c.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c.this.h(customResponsedMessage);
        }
    };
    private CustomMessageListener gHM = new CustomMessageListener(CmdConfigCustom.CMD_THREAD_NOT_EXIST_WHEN_ENTER_PB) { // from class: com.baidu.tieba.homepage.concern.c.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c.this.h(customResponsedMessage);
        }
    };
    private CustomMessageListener gXw = new CustomMessageListener(2921425) { // from class: com.baidu.tieba.homepage.concern.c.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c.this.bNm();
        }
    };

    /* loaded from: classes9.dex */
    public interface a {
        void Cd(String str);

        void S(boolean z, boolean z2);

        void bNi();

        void bNj();

        void onError(int i, String str);
    }

    public void setTabInForeBackgroundState(boolean z) {
        this.mIsBackground = z;
    }

    public void lt(boolean z) {
        this.mIsBackground = z;
    }

    public c(e<?> eVar, BdTypeRecyclerView bdTypeRecyclerView, com.baidu.tieba.homepage.concern.a aVar, BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout) {
        this.gtd = bdTypeRecyclerView;
        this.gtd.setOnTouchListener(this.drN);
        this.gMC = new com.baidu.tieba.f.a();
        this.gXt = new com.baidu.tieba.homepage.concern.c.a();
        this.gXs = aVar;
        bdTypeRecyclerView.setOnScrollListener(this.mOnScrollListener);
        this.gXi = bigdaySwipeRefreshLayout;
    }

    public void q(BdUniqueId bdUniqueId) {
        this.gXv.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.gXv);
        this.gHM.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.gHM);
        this.gXw.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.gXw);
        this.dag.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.dag);
    }

    public void setRecommendFrsNavigationAnimDispatcher(z zVar) {
        if (zVar != null) {
            this.dHb = zVar.aSp();
            this.duf = zVar.aSq();
        }
    }

    public void update() {
        if (this.gXo.size() == 0 && !this.gXq) {
            azY();
        } else {
            azX();
        }
    }

    public void bNk() {
        azX();
    }

    public void bcg() {
        if (!isLoading() && this.hasMore && this.gXn != null) {
            setIsLoading(true);
            this.gXn.Cd(this.pageTag);
        }
    }

    public void a(boolean z, DataRes dataRes, int i, String str) {
        setIsLoading(false);
        if (i != 0 || dataRes == null || !a(true, z, dataRes)) {
            if (i == 0 && v.getCount(this.gXo) == 0 && this.gXn != null) {
                this.gXn.bNj();
                if (this.gXi != null) {
                    this.gXi.setRefreshing(false);
                    return;
                }
                return;
            } else if (this.gXo.size() > 0) {
                if (this.gXn != null) {
                    this.gXn.onError(1, str);
                }
            } else if (this.gXn != null) {
                this.gXn.onError(2, str);
            }
        } else {
            if (this.gXn != null) {
                this.gXn.S(z, false);
            }
            byJ();
        }
        if (this.gXi != null) {
            this.gXi.setRefreshing(false);
        }
    }

    public void mx(boolean z) {
        if (z) {
            this.gXs.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void azX() {
        if (this.gXn != null) {
            this.gXn.bNi();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(DataRes dataRes) {
        this.gXq = true;
        if (dataRes != null) {
            if (a(false, true, dataRes)) {
                if (this.gXn != null) {
                    this.gXn.S(false, true);
                    return;
                }
                return;
            }
            azX();
            return;
        }
        azX();
    }

    private List<m> a(boolean z, DataRes.Builder builder, boolean z2) {
        if (this.gXp == null) {
            this.gXp = new DataRes.Builder();
        }
        if (builder == null) {
            builder = new DataRes.Builder();
        }
        com.baidu.tieba.homepage.personalize.model.c a2 = this.gXt.a(z, this.gXp, builder, z2 ? 0 : 1);
        if (a2 == null) {
            return null;
        }
        return a2.dTr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setList(List<m> list) {
        this.gXs.ac(list);
    }

    private boolean a(boolean z, boolean z2, DataRes dataRes) {
        m mVar;
        if (dataRes == null) {
            return false;
        }
        this.pageTag = dataRes.page_tag;
        LinkedList linkedList = new LinkedList();
        DataRes.Builder builder = new DataRes.Builder(dataRes);
        this.gXu = builder.user_tips_type.intValue();
        if (dataRes.req_unix != null) {
            com.baidu.tbadk.core.sharedPref.b.aFD().putLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(SharedPrefConfig.CONCERN_DATA_RES_REQUEST_TIME), dataRes.req_unix.longValue());
        }
        List<m> a2 = a(z, builder, z2);
        this.gXr = false;
        if (a2 != null && TbadkCoreApplication.isLogin()) {
            if (3 == this.gXu) {
                if (v.isEmpty(a2)) {
                    a2.add(new com.baidu.tieba.homepage.concern.b.a());
                    this.gXr = true;
                } else if (v.getCount(a2) == 1 && (v.getItem(a2, 0) instanceof com.baidu.tieba.homepage.concern.b.b)) {
                    a2.add(new com.baidu.tieba.homepage.concern.b.a());
                    this.gXr = true;
                }
            }
            linkedList.addAll(a2);
        }
        if (!aq.isEmpty(builder.user_tips) && 2 == this.gXu) {
            com.baidu.tieba.homepage.concern.b.c cVar = new com.baidu.tieba.homepage.concern.b.c();
            cVar.gYv = builder.user_tips_type.intValue();
            cVar.tipString = builder.user_tips;
            if (builder.user_tips_type.intValue() == 4) {
                cVar.gYw = true;
            } else {
                cVar.gYx = true;
            }
            linkedList.add(cVar);
        }
        this.hasMore = builder.has_more.intValue() == 1;
        if (v.isEmpty(linkedList)) {
            if (this.gXo.isEmpty()) {
                return false;
            }
            Iterator<m> it = this.gXo.iterator();
            while (true) {
                if (!it.hasNext()) {
                    mVar = null;
                    break;
                }
                mVar = it.next();
                if (mVar instanceof com.baidu.tbadk.data.a) {
                    break;
                }
            }
            if (mVar != null) {
                this.gXo.remove(mVar);
            }
            this.gXs.ac(this.gXo);
            return false;
        }
        this.gXo.clear();
        this.gXo.addAll(linkedList);
        if (z2) {
            this.gXp.page_tag = dataRes.page_tag;
            this.gXp.has_more = dataRes.has_more;
            this.gXp.user_list = dataRes.user_list;
            this.gXp.user_tips_type = dataRes.user_tips_type;
            this.gXp.user_tips = dataRes.user_tips;
            this.gXp.last_tips = dataRes.last_tips;
        }
        this.gXp.banner_user_story = dataRes.banner_user_story;
        this.gXp.banner_follow_live = dataRes.banner_follow_live;
        this.gXp.top_tips = dataRes.top_tips;
        this.gXp.top_user_info = dataRes.top_user_info;
        if (this.gXu == 2 || this.gXu == 3) {
            this.gXp.user_tips_type = dataRes.user_tips_type;
            this.gXp.user_tips = dataRes.user_tips;
        }
        this.gXs.ac(this.gXo);
        return true;
    }

    private void azY() {
        ac.a(new ab<DataRes>() { // from class: com.baidu.tieba.homepage.concern.c.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.ab
            /* renamed from: bNn */
            public DataRes doInBackground() {
                l<byte[]> cq = com.baidu.tbadk.core.c.a.aEB().cq("tb.concern_page", TbadkCoreApplication.getCurrentAccount());
                if (cq == null) {
                    return null;
                }
                byte[] bArr = cq.get("0");
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

    private void byJ() {
        if (this.gXp != null) {
            DataRes.Builder builder = new DataRes.Builder(this.gXp.build(true));
            if (builder.thread_info != null && builder.thread_info.size() > 30) {
                builder.thread_info = builder.thread_info.subList(0, 30);
            }
            a(builder);
        }
    }

    private void a(final DataRes.Builder builder) {
        ac.a(new ab<Object>() { // from class: com.baidu.tieba.homepage.concern.c.6
            @Override // com.baidu.tbadk.util.ab
            public Object doInBackground() {
                DataRes.Builder builder2 = new DataRes.Builder(builder.build(true));
                try {
                    com.baidu.tbadk.core.c.a.aEB().cq("tb.concern_page", TbadkCoreApplication.getCurrentAccount()).setForever("0", builder2.build(true).toByteArray());
                    return null;
                } catch (Exception e) {
                    BdLog.e(e);
                    return null;
                }
            }
        }, null);
    }

    public void a(a aVar) {
        this.gXn = aVar;
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

    public boolean bNl() {
        return this.gXr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(CustomResponsedMessage<?> customResponsedMessage) {
        ThreadInfo threadInfo;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.gXp != null && v.getCount(this.gXp.thread_info) != 0 && v.getCount(this.gXo) != 0) {
            String optString = ((JSONObject) customResponsedMessage.getData()).optString("tid");
            if (!StringUtils.isNull(optString)) {
                Iterator<m> it = this.gXo.iterator();
                boolean z = false;
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    m next = it.next();
                    if (next instanceof com.baidu.tieba.card.data.c) {
                        com.baidu.tieba.card.data.c cVar = (com.baidu.tieba.card.data.c) next;
                        if (cVar.aAg() != null && cVar.aAg().getTid() != null) {
                            if (cVar.aAg().getTid().equals(optString)) {
                                z = true;
                                it.remove();
                            } else if (z) {
                                if (this.gXs != null) {
                                    this.gXs.ac(this.gXo);
                                }
                            }
                        }
                    }
                    z = z;
                }
                long j = com.baidu.adp.lib.f.b.toLong(optString, 0L);
                for (int i = 0; i < this.gXp.thread_info.size(); i++) {
                    ConcernData concernData = this.gXp.thread_info.get(i);
                    if (concernData != null && (threadInfo = concernData.thread_list) != null && threadInfo.tid != null && threadInfo.tid.longValue() == j) {
                        this.gXp.thread_info.remove(i);
                        byJ();
                        return;
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bNm() {
        if (this.gXp != null && v.getCount(this.gXp.thread_info) != 0 && v.getCount(this.gXo) != 0) {
            int i = 0;
            while (true) {
                if (i >= this.gXo.size()) {
                    break;
                } else if (!(this.gXo.get(i) instanceof com.baidu.tieba.homepage.concern.b.b)) {
                    i++;
                } else {
                    this.gXo.remove(i);
                    if (this.gXs != null) {
                        this.gXs.ac(this.gXo);
                    }
                }
            }
            for (int i2 = 0; i2 < this.gXp.thread_info.size(); i2++) {
                if (com.baidu.tieba.homepage.concern.b.b.a(this.gXp.thread_info.get(i2))) {
                    this.gXp.thread_info.remove(i2);
                    byJ();
                    return;
                }
            }
        }
    }
}
