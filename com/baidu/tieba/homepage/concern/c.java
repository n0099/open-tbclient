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
    private com.baidu.tieba.f.a igg;
    private BigdaySwipeRefreshLayout ism;
    private DataRes.Builder ist;
    private final com.baidu.tieba.homepage.concern.a isw;
    private final com.baidu.tieba.homepage.concern.c.a isx;
    private int isy;
    private String pageTag;
    private a isr = null;
    private final LinkedList<q> iss = new LinkedList<>();
    private boolean mIsLoading = false;
    private boolean isu = false;
    private boolean isv = false;
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
                        Iterator it = c.this.iss.iterator();
                        while (it.hasNext()) {
                            Object next = it.next();
                            if ((next instanceof com.baidu.tieba.card.data.c) && ax.h(((com.baidu.tieba.card.data.c) next).aTN(), data.toUid)) {
                                it.remove();
                            }
                        }
                        if (c.this.iss.size() < 9) {
                            c.this.aTE();
                            return;
                        }
                        c.this.setList(c.this.iss);
                        c.this.isw.notifyDataSetChanged();
                        if (c.this.isr != null) {
                            c.this.isr.X(false, false);
                        }
                    }
                }
            }
        }
    };
    RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.concern.c.2
        private int isC = 0;

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
                c.this.eKX.onScroll(this.isC, i);
            }
            this.isC = i;
        }
    };
    private View.OnTouchListener eKY = new View.OnTouchListener() { // from class: com.baidu.tieba.homepage.concern.c.3
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (c.this.exE != null) {
                c.this.exE.onTouch(view, motionEvent);
            }
            if (c.this.igg != null) {
                c.this.igg.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private CustomMessageListener isz = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.homepage.concern.c.7
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
    private CustomMessageListener isA = new CustomMessageListener(2921425) { // from class: com.baidu.tieba.homepage.concern.c.9
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
        this.igg = new com.baidu.tieba.f.a();
        this.isx = new com.baidu.tieba.homepage.concern.c.a();
        this.isw = aVar;
        bdTypeRecyclerView.setOnScrollListener(this.mOnScrollListener);
        this.ism = bigdaySwipeRefreshLayout;
    }

    public void t(BdUniqueId bdUniqueId) {
        this.isz.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.isz);
        this.hoK.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.hoK);
        this.isA.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.isA);
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
        if (this.iss.size() == 0 && !this.isu) {
            aTF();
        } else {
            aTE();
        }
    }

    public void clB() {
        aTE();
    }

    public void bwE() {
        if (!isLoading() && this.hasMore && this.isr != null) {
            setIsLoading(true);
            this.isr.GJ(this.pageTag);
        }
    }

    public void a(boolean z, DataRes dataRes, int i, String str) {
        setIsLoading(false);
        if (i != 0 || dataRes == null || !a(true, z, dataRes)) {
            if (i == 0 && x.getCount(this.iss) == 0 && this.isr != null) {
                this.isr.clA();
                if (this.ism != null) {
                    this.ism.setRefreshing(false);
                    return;
                }
                return;
            } else if (this.iss.size() > 0) {
                if (this.isr != null) {
                    this.isr.onError(1, str);
                }
            } else if (this.isr != null) {
                this.isr.onError(2, str);
            }
        } else {
            if (this.isr != null) {
                this.isr.X(z, false);
            }
            bVB();
        }
        if (this.ism != null) {
            this.ism.setRefreshing(false);
        }
    }

    public void oT(boolean z) {
        if (z) {
            this.isw.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aTE() {
        if (this.isr != null) {
            this.isr.clz();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(DataRes dataRes) {
        this.isu = true;
        if (dataRes != null) {
            if (a(false, true, dataRes)) {
                if (this.isr != null) {
                    this.isr.X(false, true);
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
        if (this.ist == null) {
            this.ist = new DataRes.Builder();
        }
        if (builder == null) {
            builder = new DataRes.Builder();
        }
        com.baidu.tieba.homepage.personalize.model.c a2 = this.isx.a(z, this.ist, builder, z2 ? 0 : 1);
        if (a2 == null) {
            return null;
        }
        return a2.eZc;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setList(List<q> list) {
        this.isw.bR(list);
    }

    private boolean a(boolean z, boolean z2, DataRes dataRes) {
        q qVar;
        if (dataRes == null) {
            return false;
        }
        this.pageTag = dataRes.page_tag;
        LinkedList linkedList = new LinkedList();
        DataRes.Builder builder = new DataRes.Builder(dataRes);
        this.isy = builder.user_tips_type.intValue();
        if (dataRes.req_unix != null) {
            com.baidu.tbadk.core.sharedPref.b.aZP().putLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(SharedPrefConfig.CONCERN_DATA_RES_REQUEST_TIME), dataRes.req_unix.longValue());
        }
        List<q> a2 = a(z, builder, z2);
        this.isv = false;
        if (a2 != null && TbadkCoreApplication.isLogin()) {
            if (3 == this.isy) {
                if (x.isEmpty(a2)) {
                    a2.add(new com.baidu.tieba.homepage.concern.b.a());
                    this.isv = true;
                } else if (x.getCount(a2) == 1 && (x.getItem(a2, 0) instanceof com.baidu.tieba.homepage.concern.b.b)) {
                    a2.add(new com.baidu.tieba.homepage.concern.b.a());
                    this.isv = true;
                }
            }
            linkedList.addAll(a2);
        }
        if (!as.isEmpty(builder.user_tips) && 2 == this.isy) {
            com.baidu.tieba.homepage.concern.b.c cVar = new com.baidu.tieba.homepage.concern.b.c();
            cVar.itv = builder.user_tips_type.intValue();
            cVar.tipString = builder.user_tips;
            if (builder.user_tips_type.intValue() == 4) {
                cVar.itw = true;
            } else {
                cVar.itx = true;
            }
            linkedList.add(cVar);
        }
        this.hasMore = builder.has_more.intValue() == 1;
        if (x.isEmpty(linkedList)) {
            if (this.iss.isEmpty()) {
                return false;
            }
            Iterator<q> it = this.iss.iterator();
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
                this.iss.remove(qVar);
            }
            this.isw.bR(this.iss);
            return false;
        }
        this.iss.clear();
        this.iss.addAll(linkedList);
        if (z2) {
            this.ist.page_tag = dataRes.page_tag;
            this.ist.has_more = dataRes.has_more;
            this.ist.user_list = dataRes.user_list;
            this.ist.user_tips_type = dataRes.user_tips_type;
            this.ist.user_tips = dataRes.user_tips;
            this.ist.last_tips = dataRes.last_tips;
        }
        this.ist.banner_user_story = dataRes.banner_user_story;
        this.ist.banner_follow_live = dataRes.banner_follow_live;
        this.ist.top_tips = dataRes.top_tips;
        this.ist.top_user_info = dataRes.top_user_info;
        if (this.isy == 2 || this.isy == 3) {
            this.ist.user_tips_type = dataRes.user_tips_type;
            this.ist.user_tips = dataRes.user_tips;
        }
        this.isw.bR(this.iss);
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
        if (this.ist != null) {
            DataRes.Builder builder = new DataRes.Builder(this.ist.build(true));
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
        this.isr = aVar;
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
        return this.isv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(CustomResponsedMessage<?> customResponsedMessage) {
        ThreadInfo threadInfo;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.ist != null && x.getCount(this.ist.thread_info) != 0 && x.getCount(this.iss) != 0) {
            String optString = ((JSONObject) customResponsedMessage.getData()).optString("tid");
            if (!StringUtils.isNull(optString)) {
                Iterator<q> it = this.iss.iterator();
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
                                if (this.isw != null) {
                                    this.isw.bR(this.iss);
                                }
                            }
                        }
                    }
                    z = z;
                }
                long j = com.baidu.adp.lib.f.b.toLong(optString, 0L);
                for (int i = 0; i < this.ist.thread_info.size(); i++) {
                    ConcernData concernData = this.ist.thread_info.get(i);
                    if (concernData != null && (threadInfo = concernData.thread_list) != null && threadInfo.tid != null && threadInfo.tid.longValue() == j) {
                        this.ist.thread_info.remove(i);
                        bVB();
                        return;
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clD() {
        if (this.ist != null && x.getCount(this.ist.thread_info) != 0 && x.getCount(this.iss) != 0) {
            int i = 0;
            while (true) {
                if (i >= this.iss.size()) {
                    break;
                } else if (!(this.iss.get(i) instanceof com.baidu.tieba.homepage.concern.b.b)) {
                    i++;
                } else {
                    this.iss.remove(i);
                    if (this.isw != null) {
                        this.isw.bR(this.iss);
                    }
                }
            }
            for (int i2 = 0; i2 < this.ist.thread_info.size(); i2++) {
                if (com.baidu.tieba.homepage.concern.b.b.a(this.ist.thread_info.get(i2))) {
                    this.ist.thread_info.remove(i2);
                    bVB();
                    return;
                }
            }
        }
    }
}
