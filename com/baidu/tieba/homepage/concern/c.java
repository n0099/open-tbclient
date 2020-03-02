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
    private y dGO;
    private View.OnTouchListener dtS;
    private com.baidu.tieba.f.a gMq;
    private BigdaySwipeRefreshLayout gWW;
    private DataRes.Builder gXd;
    private final com.baidu.tieba.homepage.concern.a gXg;
    private final com.baidu.tieba.homepage.concern.c.a gXh;
    private int gXi;
    private final BdTypeRecyclerView gsQ;
    private boolean hasMore;
    private String pageTag;
    private a gXb = null;
    private final LinkedList<m> gXc = new LinkedList<>();
    private boolean mIsLoading = false;
    private boolean gXe = false;
    private boolean gXf = false;
    private boolean mIsBackground = false;
    private CustomMessageListener daf = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.homepage.concern.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (data.dnU == null) {
                    if (!data.isSucc) {
                        BdToast.a(TbadkCoreApplication.getInst().getContext(), updateAttentionMessage.getData().errorString, R.drawable.icon_pure_toast_mistake40_svg, 3000, true).aEH();
                    } else if (!data.isAttention) {
                        Iterator it = c.this.gXc.iterator();
                        while (it.hasNext()) {
                            Object next = it.next();
                            if ((next instanceof com.baidu.tieba.card.data.c) && au.a(((com.baidu.tieba.card.data.c) next).aAg(), data.toUid)) {
                                it.remove();
                            }
                        }
                        if (c.this.gXc.size() < 9) {
                            c.this.azX();
                            return;
                        }
                        c.this.setList(c.this.gXc);
                        c.this.gXg.notifyDataSetChanged();
                        if (c.this.gXb != null) {
                            c.this.gXb.S(false, false);
                        }
                    }
                }
            }
        }
    };
    RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.concern.c.2
        private int gXm = 0;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (c.this.dGO != null && !c.this.mIsBackground) {
                c.this.dGO.l(recyclerView, i);
            }
            if (i == 0) {
                r.bvg().bbR();
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
            if (c.this.dGO != null && !c.this.mIsBackground) {
                c.this.dGO.onScroll(this.gXm, i);
            }
            this.gXm = i;
        }
    };
    private View.OnTouchListener drA = new View.OnTouchListener() { // from class: com.baidu.tieba.homepage.concern.c.3
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (c.this.dtS != null) {
                c.this.dtS.onTouch(view, motionEvent);
            }
            if (c.this.gMq != null) {
                c.this.gMq.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private CustomMessageListener gXj = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.homepage.concern.c.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c.this.h(customResponsedMessage);
        }
    };
    private CustomMessageListener gHA = new CustomMessageListener(CmdConfigCustom.CMD_THREAD_NOT_EXIST_WHEN_ENTER_PB) { // from class: com.baidu.tieba.homepage.concern.c.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c.this.h(customResponsedMessage);
        }
    };
    private CustomMessageListener gXk = new CustomMessageListener(2921425) { // from class: com.baidu.tieba.homepage.concern.c.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c.this.bNl();
        }
    };

    /* loaded from: classes9.dex */
    public interface a {
        void Cc(String str);

        void S(boolean z, boolean z2);

        void bNh();

        void bNi();

        void onError(int i, String str);
    }

    public void setTabInForeBackgroundState(boolean z) {
        this.mIsBackground = z;
    }

    public void lt(boolean z) {
        this.mIsBackground = z;
    }

    public c(e<?> eVar, BdTypeRecyclerView bdTypeRecyclerView, com.baidu.tieba.homepage.concern.a aVar, BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout) {
        this.gsQ = bdTypeRecyclerView;
        this.gsQ.setOnTouchListener(this.drA);
        this.gMq = new com.baidu.tieba.f.a();
        this.gXh = new com.baidu.tieba.homepage.concern.c.a();
        this.gXg = aVar;
        bdTypeRecyclerView.setOnScrollListener(this.mOnScrollListener);
        this.gWW = bigdaySwipeRefreshLayout;
    }

    public void q(BdUniqueId bdUniqueId) {
        this.gXj.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.gXj);
        this.gHA.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.gHA);
        this.gXk.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.gXk);
        this.daf.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.daf);
    }

    public void setRecommendFrsNavigationAnimDispatcher(z zVar) {
        if (zVar != null) {
            this.dGO = zVar.aSo();
            this.dtS = zVar.aSp();
        }
    }

    public void update() {
        if (this.gXc.size() == 0 && !this.gXe) {
            azY();
        } else {
            azX();
        }
    }

    public void bNj() {
        azX();
    }

    public void bcf() {
        if (!isLoading() && this.hasMore && this.gXb != null) {
            setIsLoading(true);
            this.gXb.Cc(this.pageTag);
        }
    }

    public void a(boolean z, DataRes dataRes, int i, String str) {
        setIsLoading(false);
        if (i != 0 || dataRes == null || !a(true, z, dataRes)) {
            if (i == 0 && v.getCount(this.gXc) == 0 && this.gXb != null) {
                this.gXb.bNi();
                if (this.gWW != null) {
                    this.gWW.setRefreshing(false);
                    return;
                }
                return;
            } else if (this.gXc.size() > 0) {
                if (this.gXb != null) {
                    this.gXb.onError(1, str);
                }
            } else if (this.gXb != null) {
                this.gXb.onError(2, str);
            }
        } else {
            if (this.gXb != null) {
                this.gXb.S(z, false);
            }
            byI();
        }
        if (this.gWW != null) {
            this.gWW.setRefreshing(false);
        }
    }

    public void mx(boolean z) {
        if (z) {
            this.gXg.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void azX() {
        if (this.gXb != null) {
            this.gXb.bNh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(DataRes dataRes) {
        this.gXe = true;
        if (dataRes != null) {
            if (a(false, true, dataRes)) {
                if (this.gXb != null) {
                    this.gXb.S(false, true);
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
        if (this.gXd == null) {
            this.gXd = new DataRes.Builder();
        }
        if (builder == null) {
            builder = new DataRes.Builder();
        }
        com.baidu.tieba.homepage.personalize.model.c a2 = this.gXh.a(z, this.gXd, builder, z2 ? 0 : 1);
        if (a2 == null) {
            return null;
        }
        return a2.dTe;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setList(List<m> list) {
        this.gXg.ac(list);
    }

    private boolean a(boolean z, boolean z2, DataRes dataRes) {
        m mVar;
        if (dataRes == null) {
            return false;
        }
        this.pageTag = dataRes.page_tag;
        LinkedList linkedList = new LinkedList();
        DataRes.Builder builder = new DataRes.Builder(dataRes);
        this.gXi = builder.user_tips_type.intValue();
        if (dataRes.req_unix != null) {
            com.baidu.tbadk.core.sharedPref.b.aFD().putLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(SharedPrefConfig.CONCERN_DATA_RES_REQUEST_TIME), dataRes.req_unix.longValue());
        }
        List<m> a2 = a(z, builder, z2);
        this.gXf = false;
        if (a2 != null && TbadkCoreApplication.isLogin()) {
            if (3 == this.gXi) {
                if (v.isEmpty(a2)) {
                    a2.add(new com.baidu.tieba.homepage.concern.b.a());
                    this.gXf = true;
                } else if (v.getCount(a2) == 1 && (v.getItem(a2, 0) instanceof com.baidu.tieba.homepage.concern.b.b)) {
                    a2.add(new com.baidu.tieba.homepage.concern.b.a());
                    this.gXf = true;
                }
            }
            linkedList.addAll(a2);
        }
        if (!aq.isEmpty(builder.user_tips) && 2 == this.gXi) {
            com.baidu.tieba.homepage.concern.b.c cVar = new com.baidu.tieba.homepage.concern.b.c();
            cVar.gYj = builder.user_tips_type.intValue();
            cVar.tipString = builder.user_tips;
            if (builder.user_tips_type.intValue() == 4) {
                cVar.gYk = true;
            } else {
                cVar.gYl = true;
            }
            linkedList.add(cVar);
        }
        this.hasMore = builder.has_more.intValue() == 1;
        if (v.isEmpty(linkedList)) {
            if (this.gXc.isEmpty()) {
                return false;
            }
            Iterator<m> it = this.gXc.iterator();
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
                this.gXc.remove(mVar);
            }
            this.gXg.ac(this.gXc);
            return false;
        }
        this.gXc.clear();
        this.gXc.addAll(linkedList);
        if (z2) {
            this.gXd.page_tag = dataRes.page_tag;
            this.gXd.has_more = dataRes.has_more;
            this.gXd.user_list = dataRes.user_list;
            this.gXd.user_tips_type = dataRes.user_tips_type;
            this.gXd.user_tips = dataRes.user_tips;
            this.gXd.last_tips = dataRes.last_tips;
        }
        this.gXd.banner_user_story = dataRes.banner_user_story;
        this.gXd.banner_follow_live = dataRes.banner_follow_live;
        this.gXd.top_tips = dataRes.top_tips;
        this.gXd.top_user_info = dataRes.top_user_info;
        if (this.gXi == 2 || this.gXi == 3) {
            this.gXd.user_tips_type = dataRes.user_tips_type;
            this.gXd.user_tips = dataRes.user_tips;
        }
        this.gXg.ac(this.gXc);
        return true;
    }

    private void azY() {
        ac.a(new ab<DataRes>() { // from class: com.baidu.tieba.homepage.concern.c.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.ab
            /* renamed from: bNm */
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

    private void byI() {
        if (this.gXd != null) {
            DataRes.Builder builder = new DataRes.Builder(this.gXd.build(true));
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
        this.gXb = aVar;
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

    public boolean bNk() {
        return this.gXf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(CustomResponsedMessage<?> customResponsedMessage) {
        ThreadInfo threadInfo;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.gXd != null && v.getCount(this.gXd.thread_info) != 0 && v.getCount(this.gXc) != 0) {
            String optString = ((JSONObject) customResponsedMessage.getData()).optString("tid");
            if (!StringUtils.isNull(optString)) {
                Iterator<m> it = this.gXc.iterator();
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
                                if (this.gXg != null) {
                                    this.gXg.ac(this.gXc);
                                }
                            }
                        }
                    }
                    z = z;
                }
                long j = com.baidu.adp.lib.f.b.toLong(optString, 0L);
                for (int i = 0; i < this.gXd.thread_info.size(); i++) {
                    ConcernData concernData = this.gXd.thread_info.get(i);
                    if (concernData != null && (threadInfo = concernData.thread_list) != null && threadInfo.tid != null && threadInfo.tid.longValue() == j) {
                        this.gXd.thread_info.remove(i);
                        byI();
                        return;
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bNl() {
        if (this.gXd != null && v.getCount(this.gXd.thread_info) != 0 && v.getCount(this.gXc) != 0) {
            int i = 0;
            while (true) {
                if (i >= this.gXc.size()) {
                    break;
                } else if (!(this.gXc.get(i) instanceof com.baidu.tieba.homepage.concern.b.b)) {
                    i++;
                } else {
                    this.gXc.remove(i);
                    if (this.gXg != null) {
                        this.gXg.ac(this.gXc);
                    }
                }
            }
            for (int i2 = 0; i2 < this.gXd.thread_info.size(); i2++) {
                if (com.baidu.tieba.homepage.concern.b.b.a(this.gXd.thread_info.get(i2))) {
                    this.gXd.thread_info.remove(i2);
                    byI();
                    return;
                }
            }
        }
    }
}
