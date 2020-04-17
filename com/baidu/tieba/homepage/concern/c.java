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
    private View.OnTouchListener dUn;
    private y egY;
    private BigdaySwipeRefreshLayout hIg;
    private DataRes.Builder hIn;
    private final com.baidu.tieba.homepage.concern.a hIq;
    private final com.baidu.tieba.homepage.concern.c.a hIr;
    private int hIs;
    private boolean hasMore;
    private final BdTypeRecyclerView hcS;
    private com.baidu.tieba.f.a hxk;
    private String pageTag;
    private a hIl = null;
    private final LinkedList<m> hIm = new LinkedList<>();
    private boolean mIsLoading = false;
    private boolean hIo = false;
    private boolean hIp = false;
    private boolean mIsBackground = false;
    private CustomMessageListener dzH = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.homepage.concern.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (data.dOo == null) {
                    if (!data.isSucc) {
                        BdToast.a(TbadkCoreApplication.getInst().getContext(), updateAttentionMessage.getData().errorString, R.drawable.icon_pure_toast_mistake40_svg, 3000, true).aMZ();
                    } else if (!data.isAttention) {
                        Iterator it = c.this.hIm.iterator();
                        while (it.hasNext()) {
                            Object next = it.next();
                            if ((next instanceof com.baidu.tieba.card.data.c) && au.a(((com.baidu.tieba.card.data.c) next).aIw(), data.toUid)) {
                                it.remove();
                            }
                        }
                        if (c.this.hIm.size() < 9) {
                            c.this.aIn();
                            return;
                        }
                        c.this.setList(c.this.hIm);
                        c.this.hIq.notifyDataSetChanged();
                        if (c.this.hIl != null) {
                            c.this.hIl.S(false, false);
                        }
                    }
                }
            }
        }
    };
    RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.concern.c.2
        private int hIw = 0;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (c.this.egY != null && !c.this.mIsBackground) {
                c.this.egY.l(recyclerView, i);
            }
            if (i == 0) {
                r.bEY().bjZ();
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
            if (c.this.egY != null && !c.this.mIsBackground) {
                c.this.egY.onScroll(this.hIw, i);
            }
            this.hIw = i;
        }
    };
    private View.OnTouchListener dRW = new View.OnTouchListener() { // from class: com.baidu.tieba.homepage.concern.c.3
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (c.this.dUn != null) {
                c.this.dUn.onTouch(view, motionEvent);
            }
            if (c.this.hxk != null) {
                c.this.hxk.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private CustomMessageListener hIt = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.homepage.concern.c.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c.this.g(customResponsedMessage);
        }
    };
    private CustomMessageListener gHn = new CustomMessageListener(CmdConfigCustom.CMD_THREAD_NOT_EXIST_WHEN_ENTER_PB) { // from class: com.baidu.tieba.homepage.concern.c.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c.this.g(customResponsedMessage);
        }
    };
    private CustomMessageListener hIu = new CustomMessageListener(2921425) { // from class: com.baidu.tieba.homepage.concern.c.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c.this.bYb();
        }
    };

    /* loaded from: classes9.dex */
    public interface a {
        void DL(String str);

        void S(boolean z, boolean z2);

        void bXX();

        void bXY();

        void onError(int i, String str);
    }

    public void setTabInForeBackgroundState(boolean z) {
        this.mIsBackground = z;
    }

    public void mC(boolean z) {
        this.mIsBackground = z;
    }

    public c(e<?> eVar, BdTypeRecyclerView bdTypeRecyclerView, com.baidu.tieba.homepage.concern.a aVar, BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout) {
        this.hcS = bdTypeRecyclerView;
        this.hcS.setOnTouchListener(this.dRW);
        this.hxk = new com.baidu.tieba.f.a();
        this.hIr = new com.baidu.tieba.homepage.concern.c.a();
        this.hIq = aVar;
        bdTypeRecyclerView.setOnScrollListener(this.mOnScrollListener);
        this.hIg = bigdaySwipeRefreshLayout;
    }

    public void q(BdUniqueId bdUniqueId) {
        this.hIt.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.hIt);
        this.gHn.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.gHn);
        this.hIu.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.hIu);
        this.dzH.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.dzH);
    }

    public void setRecommendFrsNavigationAnimDispatcher(z zVar) {
        if (zVar != null) {
            this.egY = zVar.baC();
            this.dUn = zVar.baD();
        }
    }

    public void update() {
        if (this.hIm.size() == 0 && !this.hIo) {
            aIo();
        } else {
            aIn();
        }
    }

    public void bXZ() {
        aIn();
    }

    public void blb() {
        if (!isLoading() && this.hasMore && this.hIl != null) {
            setIsLoading(true);
            this.hIl.DL(this.pageTag);
        }
    }

    public void a(boolean z, DataRes dataRes, int i, String str) {
        setIsLoading(false);
        if (i != 0 || dataRes == null || !a(true, z, dataRes)) {
            if (i == 0 && v.getCount(this.hIm) == 0 && this.hIl != null) {
                this.hIl.bXY();
                if (this.hIg != null) {
                    this.hIg.setRefreshing(false);
                    return;
                }
                return;
            } else if (this.hIm.size() > 0) {
                if (this.hIl != null) {
                    this.hIl.onError(1, str);
                }
            } else if (this.hIl != null) {
                this.hIl.onError(2, str);
            }
        } else {
            if (this.hIl != null) {
                this.hIl.S(z, false);
            }
            bIM();
        }
        if (this.hIg != null) {
            this.hIg.setRefreshing(false);
        }
    }

    public void nH(boolean z) {
        if (z) {
            this.hIq.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aIn() {
        if (this.hIl != null) {
            this.hIl.bXX();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(DataRes dataRes) {
        this.hIo = true;
        if (dataRes != null) {
            if (a(false, true, dataRes)) {
                if (this.hIl != null) {
                    this.hIl.S(false, true);
                    return;
                }
                return;
            }
            aIn();
            return;
        }
        aIn();
    }

    private List<m> a(boolean z, DataRes.Builder builder, boolean z2) {
        if (this.hIn == null) {
            this.hIn = new DataRes.Builder();
        }
        if (builder == null) {
            builder = new DataRes.Builder();
        }
        com.baidu.tieba.homepage.personalize.model.c a2 = this.hIr.a(z, this.hIn, builder, z2 ? 0 : 1);
        if (a2 == null) {
            return null;
        }
        return a2.etG;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setList(List<m> list) {
        this.hIq.ak(list);
    }

    private boolean a(boolean z, boolean z2, DataRes dataRes) {
        m mVar;
        if (dataRes == null) {
            return false;
        }
        this.pageTag = dataRes.page_tag;
        LinkedList linkedList = new LinkedList();
        DataRes.Builder builder = new DataRes.Builder(dataRes);
        this.hIs = builder.user_tips_type.intValue();
        if (dataRes.req_unix != null) {
            com.baidu.tbadk.core.sharedPref.b.aNV().putLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(SharedPrefConfig.CONCERN_DATA_RES_REQUEST_TIME), dataRes.req_unix.longValue());
        }
        List<m> a2 = a(z, builder, z2);
        this.hIp = false;
        if (a2 != null && TbadkCoreApplication.isLogin()) {
            if (3 == this.hIs) {
                if (v.isEmpty(a2)) {
                    a2.add(new com.baidu.tieba.homepage.concern.b.a());
                    this.hIp = true;
                } else if (v.getCount(a2) == 1 && (v.getItem(a2, 0) instanceof com.baidu.tieba.homepage.concern.b.b)) {
                    a2.add(new com.baidu.tieba.homepage.concern.b.a());
                    this.hIp = true;
                }
            }
            linkedList.addAll(a2);
        }
        if (!aq.isEmpty(builder.user_tips) && 2 == this.hIs) {
            com.baidu.tieba.homepage.concern.b.c cVar = new com.baidu.tieba.homepage.concern.b.c();
            cVar.hJs = builder.user_tips_type.intValue();
            cVar.tipString = builder.user_tips;
            if (builder.user_tips_type.intValue() == 4) {
                cVar.hJt = true;
            } else {
                cVar.hJu = true;
            }
            linkedList.add(cVar);
        }
        this.hasMore = builder.has_more.intValue() == 1;
        if (v.isEmpty(linkedList)) {
            if (this.hIm.isEmpty()) {
                return false;
            }
            Iterator<m> it = this.hIm.iterator();
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
                this.hIm.remove(mVar);
            }
            this.hIq.ak(this.hIm);
            return false;
        }
        this.hIm.clear();
        this.hIm.addAll(linkedList);
        if (z2) {
            this.hIn.page_tag = dataRes.page_tag;
            this.hIn.has_more = dataRes.has_more;
            this.hIn.user_list = dataRes.user_list;
            this.hIn.user_tips_type = dataRes.user_tips_type;
            this.hIn.user_tips = dataRes.user_tips;
            this.hIn.last_tips = dataRes.last_tips;
        }
        this.hIn.banner_user_story = dataRes.banner_user_story;
        this.hIn.banner_follow_live = dataRes.banner_follow_live;
        this.hIn.top_tips = dataRes.top_tips;
        this.hIn.top_user_info = dataRes.top_user_info;
        if (this.hIs == 2 || this.hIs == 3) {
            this.hIn.user_tips_type = dataRes.user_tips_type;
            this.hIn.user_tips = dataRes.user_tips;
        }
        this.hIq.ak(this.hIm);
        return true;
    }

    private void aIo() {
        ac.a(new ab<DataRes>() { // from class: com.baidu.tieba.homepage.concern.c.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.ab
            /* renamed from: bYc */
            public DataRes doInBackground() {
                l<byte[]> cA = com.baidu.tbadk.core.c.a.aMT().cA("tb.concern_page", TbadkCoreApplication.getCurrentAccount());
                if (cA == null) {
                    return null;
                }
                byte[] bArr = cA.get("0");
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

    private void bIM() {
        if (this.hIn != null) {
            DataRes.Builder builder = new DataRes.Builder(this.hIn.build(true));
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
                    com.baidu.tbadk.core.c.a.aMT().cA("tb.concern_page", TbadkCoreApplication.getCurrentAccount()).setForever("0", builder2.build(true).toByteArray());
                    return null;
                } catch (Exception e) {
                    BdLog.e(e);
                    return null;
                }
            }
        }, null);
    }

    public void a(a aVar) {
        this.hIl = aVar;
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

    public boolean bYa() {
        return this.hIp;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(CustomResponsedMessage<?> customResponsedMessage) {
        ThreadInfo threadInfo;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.hIn != null && v.getCount(this.hIn.thread_info) != 0 && v.getCount(this.hIm) != 0) {
            String optString = ((JSONObject) customResponsedMessage.getData()).optString("tid");
            if (!StringUtils.isNull(optString)) {
                Iterator<m> it = this.hIm.iterator();
                boolean z = false;
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    m next = it.next();
                    if (next instanceof com.baidu.tieba.card.data.c) {
                        com.baidu.tieba.card.data.c cVar = (com.baidu.tieba.card.data.c) next;
                        if (cVar.aIw() != null && cVar.aIw().getTid() != null) {
                            if (cVar.aIw().getTid().equals(optString)) {
                                z = true;
                                it.remove();
                            } else if (z) {
                                if (this.hIq != null) {
                                    this.hIq.ak(this.hIm);
                                }
                            }
                        }
                    }
                    z = z;
                }
                long j = com.baidu.adp.lib.f.b.toLong(optString, 0L);
                for (int i = 0; i < this.hIn.thread_info.size(); i++) {
                    ConcernData concernData = this.hIn.thread_info.get(i);
                    if (concernData != null && (threadInfo = concernData.thread_list) != null && threadInfo.tid != null && threadInfo.tid.longValue() == j) {
                        this.hIn.thread_info.remove(i);
                        bIM();
                        return;
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bYb() {
        if (this.hIn != null && v.getCount(this.hIn.thread_info) != 0 && v.getCount(this.hIm) != 0) {
            int i = 0;
            while (true) {
                if (i >= this.hIm.size()) {
                    break;
                } else if (!(this.hIm.get(i) instanceof com.baidu.tieba.homepage.concern.b.b)) {
                    i++;
                } else {
                    this.hIm.remove(i);
                    if (this.hIq != null) {
                        this.hIq.ak(this.hIm);
                    }
                }
            }
            for (int i2 = 0; i2 < this.hIn.thread_info.size(); i2++) {
                if (com.baidu.tieba.homepage.concern.b.b.a(this.hIn.thread_info.get(i2))) {
                    this.hIn.thread_info.remove(i2);
                    bIM();
                    return;
                }
            }
        }
    }
}
