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
/* loaded from: classes7.dex */
public class c {
    private y dCJ;
    private View.OnTouchListener dpJ;
    private com.baidu.tieba.f.a gKp;
    private BigdaySwipeRefreshLayout gUT;
    private DataRes.Builder gVa;
    private final com.baidu.tieba.homepage.concern.a gVd;
    private final com.baidu.tieba.homepage.concern.c.a gVe;
    private int gVf;
    private final BdTypeRecyclerView gqN;
    private boolean hasMore;
    private String pageTag;
    private a gUY = null;
    private final LinkedList<m> gUZ = new LinkedList<>();
    private boolean mIsLoading = false;
    private boolean gVb = false;
    private boolean gVc = false;
    private boolean mIsBackground = false;
    private CustomMessageListener cWc = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.homepage.concern.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (data.djO == null) {
                    if (!data.isSucc) {
                        BdToast.a(TbadkCoreApplication.getInst().getContext(), updateAttentionMessage.getData().errorString, R.drawable.icon_pure_toast_mistake40_svg, 3000, true).aCu();
                    } else if (!data.isAttention) {
                        Iterator it = c.this.gUZ.iterator();
                        while (it.hasNext()) {
                            Object next = it.next();
                            if ((next instanceof com.baidu.tieba.card.data.c) && au.a(((com.baidu.tieba.card.data.c) next).axQ(), data.toUid)) {
                                it.remove();
                            }
                        }
                        if (c.this.gUZ.size() < 9) {
                            c.this.axH();
                            return;
                        }
                        c.this.setList(c.this.gUZ);
                        c.this.gVd.notifyDataSetChanged();
                        if (c.this.gUY != null) {
                            c.this.gUY.Q(false, false);
                        }
                    }
                }
            }
        }
    };
    RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.concern.c.2
        private int gVj = 0;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (c.this.dCJ != null && !c.this.mIsBackground) {
                c.this.dCJ.l(recyclerView, i);
            }
            if (i == 0) {
                r.btA().aZA();
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
            if (c.this.dCJ != null && !c.this.mIsBackground) {
                c.this.dCJ.onScroll(this.gVj, i);
            }
            this.gVj = i;
        }
    };
    private View.OnTouchListener dnp = new View.OnTouchListener() { // from class: com.baidu.tieba.homepage.concern.c.3
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (c.this.dpJ != null) {
                c.this.dpJ.onTouch(view, motionEvent);
            }
            if (c.this.gKp != null) {
                c.this.gKp.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private CustomMessageListener gVg = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.homepage.concern.c.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c.this.h(customResponsedMessage);
        }
    };
    private CustomMessageListener gFz = new CustomMessageListener(CmdConfigCustom.CMD_THREAD_NOT_EXIST_WHEN_ENTER_PB) { // from class: com.baidu.tieba.homepage.concern.c.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c.this.h(customResponsedMessage);
        }
    };
    private CustomMessageListener gVh = new CustomMessageListener(2921425) { // from class: com.baidu.tieba.homepage.concern.c.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c.this.bLG();
        }
    };

    /* loaded from: classes7.dex */
    public interface a {
        void BM(String str);

        void Q(boolean z, boolean z2);

        void bLC();

        void bLD();

        void onError(int i, String str);
    }

    public void setTabInForeBackgroundState(boolean z) {
        this.mIsBackground = z;
    }

    public void lq(boolean z) {
        this.mIsBackground = z;
    }

    public c(e<?> eVar, BdTypeRecyclerView bdTypeRecyclerView, com.baidu.tieba.homepage.concern.a aVar, BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout) {
        this.gqN = bdTypeRecyclerView;
        this.gqN.setOnTouchListener(this.dnp);
        this.gKp = new com.baidu.tieba.f.a();
        this.gVe = new com.baidu.tieba.homepage.concern.c.a();
        this.gVd = aVar;
        bdTypeRecyclerView.setOnScrollListener(this.mOnScrollListener);
        this.gUT = bigdaySwipeRefreshLayout;
    }

    public void q(BdUniqueId bdUniqueId) {
        this.gVg.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.gVg);
        this.gFz.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.gFz);
        this.gVh.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.gVh);
        this.cWc.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.cWc);
    }

    public void setRecommendFrsNavigationAnimDispatcher(z zVar) {
        if (zVar != null) {
            this.dCJ = zVar.aPV();
            this.dpJ = zVar.aPW();
        }
    }

    public void update() {
        if (this.gUZ.size() == 0 && !this.gVb) {
            axI();
        } else {
            axH();
        }
    }

    public void bLE() {
        axH();
    }

    public void aZN() {
        if (!isLoading() && this.hasMore && this.gUY != null) {
            setIsLoading(true);
            this.gUY.BM(this.pageTag);
        }
    }

    public void a(boolean z, DataRes dataRes, int i, String str) {
        setIsLoading(false);
        if (i != 0 || dataRes == null || !a(true, z, dataRes)) {
            if (i == 0 && v.getCount(this.gUZ) == 0 && this.gUY != null) {
                this.gUY.bLD();
                if (this.gUT != null) {
                    this.gUT.setRefreshing(false);
                    return;
                }
                return;
            } else if (this.gUZ.size() > 0) {
                if (this.gUY != null) {
                    this.gUY.onError(1, str);
                }
            } else if (this.gUY != null) {
                this.gUY.onError(2, str);
            }
        } else {
            if (this.gUY != null) {
                this.gUY.Q(z, false);
            }
            bxb();
        }
        if (this.gUT != null) {
            this.gUT.setRefreshing(false);
        }
    }

    public void mv(boolean z) {
        if (z) {
            this.gVd.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void axH() {
        if (this.gUY != null) {
            this.gUY.bLC();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(DataRes dataRes) {
        this.gVb = true;
        if (dataRes != null) {
            if (a(false, true, dataRes)) {
                if (this.gUY != null) {
                    this.gUY.Q(false, true);
                    return;
                }
                return;
            }
            axH();
            return;
        }
        axH();
    }

    private List<m> a(boolean z, DataRes.Builder builder, boolean z2) {
        if (this.gVa == null) {
            this.gVa = new DataRes.Builder();
        }
        if (builder == null) {
            builder = new DataRes.Builder();
        }
        com.baidu.tieba.homepage.personalize.model.c a2 = this.gVe.a(z, this.gVa, builder, z2 ? 0 : 1);
        if (a2 == null) {
            return null;
        }
        return a2.dOX;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setList(List<m> list) {
        this.gVd.ac(list);
    }

    private boolean a(boolean z, boolean z2, DataRes dataRes) {
        m mVar;
        if (dataRes == null) {
            return false;
        }
        this.pageTag = dataRes.page_tag;
        LinkedList linkedList = new LinkedList();
        DataRes.Builder builder = new DataRes.Builder(dataRes);
        this.gVf = builder.user_tips_type.intValue();
        if (dataRes.req_unix != null) {
            com.baidu.tbadk.core.sharedPref.b.aDr().putLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(SharedPrefConfig.CONCERN_DATA_RES_REQUEST_TIME), dataRes.req_unix.longValue());
        }
        List<m> a2 = a(z, builder, z2);
        this.gVc = false;
        if (a2 != null && TbadkCoreApplication.isLogin()) {
            if (3 == this.gVf) {
                if (v.isEmpty(a2)) {
                    a2.add(new com.baidu.tieba.homepage.concern.b.a());
                    this.gVc = true;
                } else if (v.getCount(a2) == 1 && (v.getItem(a2, 0) instanceof com.baidu.tieba.homepage.concern.b.b)) {
                    a2.add(new com.baidu.tieba.homepage.concern.b.a());
                    this.gVc = true;
                }
            }
            linkedList.addAll(a2);
        }
        if (!aq.isEmpty(builder.user_tips) && 2 == this.gVf) {
            com.baidu.tieba.homepage.concern.b.c cVar = new com.baidu.tieba.homepage.concern.b.c();
            cVar.gWg = builder.user_tips_type.intValue();
            cVar.tipString = builder.user_tips;
            if (builder.user_tips_type.intValue() == 4) {
                cVar.gWh = true;
            } else {
                cVar.gWi = true;
            }
            linkedList.add(cVar);
        }
        this.hasMore = builder.has_more.intValue() == 1;
        if (v.isEmpty(linkedList)) {
            if (this.gUZ.isEmpty()) {
                return false;
            }
            Iterator<m> it = this.gUZ.iterator();
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
                this.gUZ.remove(mVar);
            }
            this.gVd.ac(this.gUZ);
            return false;
        }
        this.gUZ.clear();
        this.gUZ.addAll(linkedList);
        if (z2) {
            this.gVa.page_tag = dataRes.page_tag;
            this.gVa.has_more = dataRes.has_more;
            this.gVa.user_list = dataRes.user_list;
            this.gVa.user_tips_type = dataRes.user_tips_type;
            this.gVa.user_tips = dataRes.user_tips;
            this.gVa.last_tips = dataRes.last_tips;
        }
        this.gVa.banner_user_story = dataRes.banner_user_story;
        this.gVa.banner_follow_live = dataRes.banner_follow_live;
        this.gVa.top_tips = dataRes.top_tips;
        this.gVa.top_user_info = dataRes.top_user_info;
        if (this.gVf == 2 || this.gVf == 3) {
            this.gVa.user_tips_type = dataRes.user_tips_type;
            this.gVa.user_tips = dataRes.user_tips;
        }
        this.gVd.ac(this.gUZ);
        return true;
    }

    private void axI() {
        ac.a(new ab<DataRes>() { // from class: com.baidu.tieba.homepage.concern.c.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.ab
            /* renamed from: bLH */
            public DataRes doInBackground() {
                l<byte[]> ch = com.baidu.tbadk.core.c.a.aCo().ch("tb.concern_page", TbadkCoreApplication.getCurrentAccount());
                if (ch == null) {
                    return null;
                }
                byte[] bArr = ch.get("0");
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

    private void bxb() {
        if (this.gVa != null) {
            DataRes.Builder builder = new DataRes.Builder(this.gVa.build(true));
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
                    com.baidu.tbadk.core.c.a.aCo().ch("tb.concern_page", TbadkCoreApplication.getCurrentAccount()).setForever("0", builder2.build(true).toByteArray());
                    return null;
                } catch (Exception e) {
                    BdLog.e(e);
                    return null;
                }
            }
        }, null);
    }

    public void a(a aVar) {
        this.gUY = aVar;
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

    public boolean bLF() {
        return this.gVc;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(CustomResponsedMessage<?> customResponsedMessage) {
        ThreadInfo threadInfo;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.gVa != null && v.getCount(this.gVa.thread_info) != 0 && v.getCount(this.gUZ) != 0) {
            String optString = ((JSONObject) customResponsedMessage.getData()).optString("tid");
            if (!StringUtils.isNull(optString)) {
                Iterator<m> it = this.gUZ.iterator();
                boolean z = false;
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    m next = it.next();
                    if (next instanceof com.baidu.tieba.card.data.c) {
                        com.baidu.tieba.card.data.c cVar = (com.baidu.tieba.card.data.c) next;
                        if (cVar.axQ() != null && cVar.axQ().getTid() != null) {
                            if (cVar.axQ().getTid().equals(optString)) {
                                z = true;
                                it.remove();
                            } else if (z) {
                                if (this.gVd != null) {
                                    this.gVd.ac(this.gUZ);
                                }
                            }
                        }
                    }
                    z = z;
                }
                long j = com.baidu.adp.lib.f.b.toLong(optString, 0L);
                for (int i = 0; i < this.gVa.thread_info.size(); i++) {
                    ConcernData concernData = this.gVa.thread_info.get(i);
                    if (concernData != null && (threadInfo = concernData.thread_list) != null && threadInfo.tid != null && threadInfo.tid.longValue() == j) {
                        this.gVa.thread_info.remove(i);
                        bxb();
                        return;
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bLG() {
        if (this.gVa != null && v.getCount(this.gVa.thread_info) != 0 && v.getCount(this.gUZ) != 0) {
            int i = 0;
            while (true) {
                if (i >= this.gUZ.size()) {
                    break;
                } else if (!(this.gUZ.get(i) instanceof com.baidu.tieba.homepage.concern.b.b)) {
                    i++;
                } else {
                    this.gUZ.remove(i);
                    if (this.gVd != null) {
                        this.gVd.ac(this.gUZ);
                    }
                }
            }
            for (int i2 = 0; i2 < this.gVa.thread_info.size(); i2++) {
                if (com.baidu.tieba.homepage.concern.b.b.a(this.gVa.thread_info.get(i2))) {
                    this.gVa.thread_info.remove(i2);
                    bxb();
                    return;
                }
            }
        }
    }
}
