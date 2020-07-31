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
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.x;
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
    private z eKX;
    private View.OnTouchListener exE;
    private final BdTypeRecyclerView hKL;
    private boolean hasMore;
    private com.baidu.tieba.f.a ige;
    private BigdaySwipeRefreshLayout isk;
    private DataRes.Builder isr;
    private final com.baidu.tieba.homepage.concern.a isu;
    private final com.baidu.tieba.homepage.concern.c.a isv;
    private int isw;
    private String pageTag;
    private a isp = null;
    private final LinkedList<q> isq = new LinkedList<>();
    private boolean mIsLoading = false;
    private boolean iss = false;
    private boolean ist = false;
    private boolean mIsBackground = false;
    private CustomMessageListener eaY = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.homepage.concern.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (data.erH == null) {
                    if (!data.isSucc) {
                        BdToast.a(TbadkCoreApplication.getInst().getContext(), updateAttentionMessage.getData().errorString, R.drawable.icon_pure_toast_mistake40_svg, 3000, true).aYR();
                    } else if (!data.isAttention) {
                        Iterator it = c.this.isq.iterator();
                        while (it.hasNext()) {
                            Object next = it.next();
                            if ((next instanceof com.baidu.tieba.card.data.c) && ax.h(((com.baidu.tieba.card.data.c) next).aTN(), data.toUid)) {
                                it.remove();
                            }
                        }
                        if (c.this.isq.size() < 9) {
                            c.this.aTE();
                            return;
                        }
                        c.this.setList(c.this.isq);
                        c.this.isu.notifyDataSetChanged();
                        if (c.this.isp != null) {
                            c.this.isp.X(false, false);
                        }
                    }
                }
            }
        }
    };
    RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.concern.c.2
        private int isA = 0;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (c.this.eKX != null && !c.this.mIsBackground) {
                c.this.eKX.k(recyclerView, i);
            }
            if (i == 0) {
                s.bRL().bva();
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
            if (c.this.eKX != null && !c.this.mIsBackground) {
                c.this.eKX.onScroll(this.isA, i);
            }
            this.isA = i;
        }
    };
    private View.OnTouchListener eKY = new View.OnTouchListener() { // from class: com.baidu.tieba.homepage.concern.c.3
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (c.this.exE != null) {
                c.this.exE.onTouch(view, motionEvent);
            }
            if (c.this.ige != null) {
                c.this.ige.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private CustomMessageListener isx = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.homepage.concern.c.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c.this.g(customResponsedMessage);
        }
    };
    private CustomMessageListener hoK = new CustomMessageListener(CmdConfigCustom.CMD_THREAD_NOT_EXIST_WHEN_ENTER_PB) { // from class: com.baidu.tieba.homepage.concern.c.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c.this.g(customResponsedMessage);
        }
    };
    private CustomMessageListener isy = new CustomMessageListener(2921425) { // from class: com.baidu.tieba.homepage.concern.c.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c.this.clD();
        }
    };

    /* loaded from: classes16.dex */
    public interface a {
        void GJ(String str);

        void X(boolean z, boolean z2);

        void clA();

        void clz();

        void onError(int i, String str);
    }

    public void setTabInForeBackgroundState(boolean z) {
        this.mIsBackground = z;
    }

    public void nN(boolean z) {
        this.mIsBackground = z;
    }

    public c(e<?> eVar, BdTypeRecyclerView bdTypeRecyclerView, com.baidu.tieba.homepage.concern.a aVar, BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout) {
        this.hKL = bdTypeRecyclerView;
        this.hKL.setOnTouchListener(this.eKY);
        this.ige = new com.baidu.tieba.f.a();
        this.isv = new com.baidu.tieba.homepage.concern.c.a();
        this.isu = aVar;
        bdTypeRecyclerView.setOnScrollListener(this.mOnScrollListener);
        this.isk = bigdaySwipeRefreshLayout;
    }

    public void t(BdUniqueId bdUniqueId) {
        this.isx.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.isx);
        this.hoK.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.hoK);
        this.isy.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.isy);
        this.eaY.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.eaY);
    }

    public void setRecommendFrsNavigationAnimDispatcher(aa aaVar) {
        if (aaVar != null) {
            this.eKX = aaVar.bmT();
            this.exE = aaVar.bmU();
        }
    }

    public void update() {
        if (this.isq.size() == 0 && !this.iss) {
            aTF();
        } else {
            aTE();
        }
    }

    public void clB() {
        aTE();
    }

    public void bwE() {
        if (!isLoading() && this.hasMore && this.isp != null) {
            setIsLoading(true);
            this.isp.GJ(this.pageTag);
        }
    }

    public void a(boolean z, DataRes dataRes, int i, String str) {
        setIsLoading(false);
        if (i != 0 || dataRes == null || !a(true, z, dataRes)) {
            if (i == 0 && x.getCount(this.isq) == 0 && this.isp != null) {
                this.isp.clA();
                if (this.isk != null) {
                    this.isk.setRefreshing(false);
                    return;
                }
                return;
            } else if (this.isq.size() > 0) {
                if (this.isp != null) {
                    this.isp.onError(1, str);
                }
            } else if (this.isp != null) {
                this.isp.onError(2, str);
            }
        } else {
            if (this.isp != null) {
                this.isp.X(z, false);
            }
            bVB();
        }
        if (this.isk != null) {
            this.isk.setRefreshing(false);
        }
    }

    public void oT(boolean z) {
        if (z) {
            this.isu.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aTE() {
        if (this.isp != null) {
            this.isp.clz();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(DataRes dataRes) {
        this.iss = true;
        if (dataRes != null) {
            if (a(false, true, dataRes)) {
                if (this.isp != null) {
                    this.isp.X(false, true);
                    return;
                }
                return;
            }
            aTE();
            return;
        }
        aTE();
    }

    private List<q> a(boolean z, DataRes.Builder builder, boolean z2) {
        if (this.isr == null) {
            this.isr = new DataRes.Builder();
        }
        if (builder == null) {
            builder = new DataRes.Builder();
        }
        com.baidu.tieba.homepage.personalize.model.c a2 = this.isv.a(z, this.isr, builder, z2 ? 0 : 1);
        if (a2 == null) {
            return null;
        }
        return a2.eZc;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setList(List<q> list) {
        this.isu.bR(list);
    }

    private boolean a(boolean z, boolean z2, DataRes dataRes) {
        q qVar;
        if (dataRes == null) {
            return false;
        }
        this.pageTag = dataRes.page_tag;
        LinkedList linkedList = new LinkedList();
        DataRes.Builder builder = new DataRes.Builder(dataRes);
        this.isw = builder.user_tips_type.intValue();
        if (dataRes.req_unix != null) {
            com.baidu.tbadk.core.sharedPref.b.aZP().putLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(SharedPrefConfig.CONCERN_DATA_RES_REQUEST_TIME), dataRes.req_unix.longValue());
        }
        List<q> a2 = a(z, builder, z2);
        this.ist = false;
        if (a2 != null && TbadkCoreApplication.isLogin()) {
            if (3 == this.isw) {
                if (x.isEmpty(a2)) {
                    a2.add(new com.baidu.tieba.homepage.concern.b.a());
                    this.ist = true;
                } else if (x.getCount(a2) == 1 && (x.getItem(a2, 0) instanceof com.baidu.tieba.homepage.concern.b.b)) {
                    a2.add(new com.baidu.tieba.homepage.concern.b.a());
                    this.ist = true;
                }
            }
            linkedList.addAll(a2);
        }
        if (!as.isEmpty(builder.user_tips) && 2 == this.isw) {
            com.baidu.tieba.homepage.concern.b.c cVar = new com.baidu.tieba.homepage.concern.b.c();
            cVar.itt = builder.user_tips_type.intValue();
            cVar.tipString = builder.user_tips;
            if (builder.user_tips_type.intValue() == 4) {
                cVar.itu = true;
            } else {
                cVar.itv = true;
            }
            linkedList.add(cVar);
        }
        this.hasMore = builder.has_more.intValue() == 1;
        if (x.isEmpty(linkedList)) {
            if (this.isq.isEmpty()) {
                return false;
            }
            Iterator<q> it = this.isq.iterator();
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
                this.isq.remove(qVar);
            }
            this.isu.bR(this.isq);
            return false;
        }
        this.isq.clear();
        this.isq.addAll(linkedList);
        if (z2) {
            this.isr.page_tag = dataRes.page_tag;
            this.isr.has_more = dataRes.has_more;
            this.isr.user_list = dataRes.user_list;
            this.isr.user_tips_type = dataRes.user_tips_type;
            this.isr.user_tips = dataRes.user_tips;
            this.isr.last_tips = dataRes.last_tips;
        }
        this.isr.banner_user_story = dataRes.banner_user_story;
        this.isr.banner_follow_live = dataRes.banner_follow_live;
        this.isr.top_tips = dataRes.top_tips;
        this.isr.top_user_info = dataRes.top_user_info;
        if (this.isw == 2 || this.isw == 3) {
            this.isr.user_tips_type = dataRes.user_tips_type;
            this.isr.user_tips = dataRes.user_tips;
        }
        this.isu.bR(this.isq);
        return true;
    }

    private void aTF() {
        ad.a(new ac<DataRes>() { // from class: com.baidu.tieba.homepage.concern.c.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.ac
            /* renamed from: clE */
            public DataRes doInBackground() {
                l<byte[]> df = com.baidu.tbadk.core.c.a.aYG().df("tb.concern_page", TbadkCoreApplication.getCurrentAccount());
                if (df == null) {
                    return null;
                }
                byte[] bArr = df.get("0");
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

    private void bVB() {
        if (this.isr != null) {
            DataRes.Builder builder = new DataRes.Builder(this.isr.build(true));
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
                    com.baidu.tbadk.core.c.a.aYG().df("tb.concern_page", TbadkCoreApplication.getCurrentAccount()).setForever("0", builder2.build(true).toByteArray());
                    return null;
                } catch (Exception e) {
                    BdLog.e(e);
                    return null;
                }
            }
        }, null);
    }

    public void a(a aVar) {
        this.isp = aVar;
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

    public boolean clC() {
        return this.ist;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(CustomResponsedMessage<?> customResponsedMessage) {
        ThreadInfo threadInfo;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.isr != null && x.getCount(this.isr.thread_info) != 0 && x.getCount(this.isq) != 0) {
            String optString = ((JSONObject) customResponsedMessage.getData()).optString("tid");
            if (!StringUtils.isNull(optString)) {
                Iterator<q> it = this.isq.iterator();
                boolean z = false;
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    q next = it.next();
                    if (next instanceof com.baidu.tieba.card.data.c) {
                        com.baidu.tieba.card.data.c cVar = (com.baidu.tieba.card.data.c) next;
                        if (cVar.aTN() != null && cVar.aTN().getTid() != null) {
                            if (cVar.aTN().getTid().equals(optString)) {
                                z = true;
                                it.remove();
                            } else if (z) {
                                if (this.isu != null) {
                                    this.isu.bR(this.isq);
                                }
                            }
                        }
                    }
                    z = z;
                }
                long j = com.baidu.adp.lib.f.b.toLong(optString, 0L);
                for (int i = 0; i < this.isr.thread_info.size(); i++) {
                    ConcernData concernData = this.isr.thread_info.get(i);
                    if (concernData != null && (threadInfo = concernData.thread_list) != null && threadInfo.tid != null && threadInfo.tid.longValue() == j) {
                        this.isr.thread_info.remove(i);
                        bVB();
                        return;
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clD() {
        if (this.isr != null && x.getCount(this.isr.thread_info) != 0 && x.getCount(this.isq) != 0) {
            int i = 0;
            while (true) {
                if (i >= this.isq.size()) {
                    break;
                } else if (!(this.isq.get(i) instanceof com.baidu.tieba.homepage.concern.b.b)) {
                    i++;
                } else {
                    this.isq.remove(i);
                    if (this.isu != null) {
                        this.isu.bR(this.isq);
                    }
                }
            }
            for (int i2 = 0; i2 < this.isr.thread_info.size(); i2++) {
                if (com.baidu.tieba.homepage.concern.b.b.a(this.isr.thread_info.get(i2))) {
                    this.isr.thread_info.remove(i2);
                    bVB();
                    return;
                }
            }
        }
    }
}
