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
    private View.OnTouchListener dUs;
    private y ehd;
    private BigdaySwipeRefreshLayout hIm;
    private DataRes.Builder hIt;
    private final com.baidu.tieba.homepage.concern.a hIw;
    private final com.baidu.tieba.homepage.concern.c.a hIx;
    private int hIy;
    private boolean hasMore;
    private final BdTypeRecyclerView hcY;
    private com.baidu.tieba.f.a hxq;
    private String pageTag;
    private a hIr = null;
    private final LinkedList<m> hIs = new LinkedList<>();
    private boolean mIsLoading = false;
    private boolean hIu = false;
    private boolean hIv = false;
    private boolean mIsBackground = false;
    private CustomMessageListener dzL = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.homepage.concern.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (data.dOt == null) {
                    if (!data.isSucc) {
                        BdToast.a(TbadkCoreApplication.getInst().getContext(), updateAttentionMessage.getData().errorString, R.drawable.icon_pure_toast_mistake40_svg, 3000, true).aMX();
                    } else if (!data.isAttention) {
                        Iterator it = c.this.hIs.iterator();
                        while (it.hasNext()) {
                            Object next = it.next();
                            if ((next instanceof com.baidu.tieba.card.data.c) && au.a(((com.baidu.tieba.card.data.c) next).aIu(), data.toUid)) {
                                it.remove();
                            }
                        }
                        if (c.this.hIs.size() < 9) {
                            c.this.aIl();
                            return;
                        }
                        c.this.setList(c.this.hIs);
                        c.this.hIw.notifyDataSetChanged();
                        if (c.this.hIr != null) {
                            c.this.hIr.S(false, false);
                        }
                    }
                }
            }
        }
    };
    RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.concern.c.2
        private int hIC = 0;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (c.this.ehd != null && !c.this.mIsBackground) {
                c.this.ehd.l(recyclerView, i);
            }
            if (i == 0) {
                r.bEX().bjX();
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
            if (c.this.ehd != null && !c.this.mIsBackground) {
                c.this.ehd.onScroll(this.hIC, i);
            }
            this.hIC = i;
        }
    };
    private View.OnTouchListener dSb = new View.OnTouchListener() { // from class: com.baidu.tieba.homepage.concern.c.3
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (c.this.dUs != null) {
                c.this.dUs.onTouch(view, motionEvent);
            }
            if (c.this.hxq != null) {
                c.this.hxq.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private CustomMessageListener hIz = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.homepage.concern.c.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c.this.g(customResponsedMessage);
        }
    };
    private CustomMessageListener gHt = new CustomMessageListener(CmdConfigCustom.CMD_THREAD_NOT_EXIST_WHEN_ENTER_PB) { // from class: com.baidu.tieba.homepage.concern.c.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c.this.g(customResponsedMessage);
        }
    };
    private CustomMessageListener hIA = new CustomMessageListener(2921425) { // from class: com.baidu.tieba.homepage.concern.c.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c.this.bYa();
        }
    };

    /* loaded from: classes9.dex */
    public interface a {
        void DO(String str);

        void S(boolean z, boolean z2);

        void bXW();

        void bXX();

        void onError(int i, String str);
    }

    public void setTabInForeBackgroundState(boolean z) {
        this.mIsBackground = z;
    }

    public void mC(boolean z) {
        this.mIsBackground = z;
    }

    public c(e<?> eVar, BdTypeRecyclerView bdTypeRecyclerView, com.baidu.tieba.homepage.concern.a aVar, BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout) {
        this.hcY = bdTypeRecyclerView;
        this.hcY.setOnTouchListener(this.dSb);
        this.hxq = new com.baidu.tieba.f.a();
        this.hIx = new com.baidu.tieba.homepage.concern.c.a();
        this.hIw = aVar;
        bdTypeRecyclerView.setOnScrollListener(this.mOnScrollListener);
        this.hIm = bigdaySwipeRefreshLayout;
    }

    public void q(BdUniqueId bdUniqueId) {
        this.hIz.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.hIz);
        this.gHt.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.gHt);
        this.hIA.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.hIA);
        this.dzL.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.dzL);
    }

    public void setRecommendFrsNavigationAnimDispatcher(z zVar) {
        if (zVar != null) {
            this.ehd = zVar.baA();
            this.dUs = zVar.baB();
        }
    }

    public void update() {
        if (this.hIs.size() == 0 && !this.hIu) {
            aIm();
        } else {
            aIl();
        }
    }

    public void bXY() {
        aIl();
    }

    public void bkZ() {
        if (!isLoading() && this.hasMore && this.hIr != null) {
            setIsLoading(true);
            this.hIr.DO(this.pageTag);
        }
    }

    public void a(boolean z, DataRes dataRes, int i, String str) {
        setIsLoading(false);
        if (i != 0 || dataRes == null || !a(true, z, dataRes)) {
            if (i == 0 && v.getCount(this.hIs) == 0 && this.hIr != null) {
                this.hIr.bXX();
                if (this.hIm != null) {
                    this.hIm.setRefreshing(false);
                    return;
                }
                return;
            } else if (this.hIs.size() > 0) {
                if (this.hIr != null) {
                    this.hIr.onError(1, str);
                }
            } else if (this.hIr != null) {
                this.hIr.onError(2, str);
            }
        } else {
            if (this.hIr != null) {
                this.hIr.S(z, false);
            }
            bIL();
        }
        if (this.hIm != null) {
            this.hIm.setRefreshing(false);
        }
    }

    public void nH(boolean z) {
        if (z) {
            this.hIw.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aIl() {
        if (this.hIr != null) {
            this.hIr.bXW();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(DataRes dataRes) {
        this.hIu = true;
        if (dataRes != null) {
            if (a(false, true, dataRes)) {
                if (this.hIr != null) {
                    this.hIr.S(false, true);
                    return;
                }
                return;
            }
            aIl();
            return;
        }
        aIl();
    }

    private List<m> a(boolean z, DataRes.Builder builder, boolean z2) {
        if (this.hIt == null) {
            this.hIt = new DataRes.Builder();
        }
        if (builder == null) {
            builder = new DataRes.Builder();
        }
        com.baidu.tieba.homepage.personalize.model.c a2 = this.hIx.a(z, this.hIt, builder, z2 ? 0 : 1);
        if (a2 == null) {
            return null;
        }
        return a2.etL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setList(List<m> list) {
        this.hIw.ak(list);
    }

    private boolean a(boolean z, boolean z2, DataRes dataRes) {
        m mVar;
        if (dataRes == null) {
            return false;
        }
        this.pageTag = dataRes.page_tag;
        LinkedList linkedList = new LinkedList();
        DataRes.Builder builder = new DataRes.Builder(dataRes);
        this.hIy = builder.user_tips_type.intValue();
        if (dataRes.req_unix != null) {
            com.baidu.tbadk.core.sharedPref.b.aNT().putLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(SharedPrefConfig.CONCERN_DATA_RES_REQUEST_TIME), dataRes.req_unix.longValue());
        }
        List<m> a2 = a(z, builder, z2);
        this.hIv = false;
        if (a2 != null && TbadkCoreApplication.isLogin()) {
            if (3 == this.hIy) {
                if (v.isEmpty(a2)) {
                    a2.add(new com.baidu.tieba.homepage.concern.b.a());
                    this.hIv = true;
                } else if (v.getCount(a2) == 1 && (v.getItem(a2, 0) instanceof com.baidu.tieba.homepage.concern.b.b)) {
                    a2.add(new com.baidu.tieba.homepage.concern.b.a());
                    this.hIv = true;
                }
            }
            linkedList.addAll(a2);
        }
        if (!aq.isEmpty(builder.user_tips) && 2 == this.hIy) {
            com.baidu.tieba.homepage.concern.b.c cVar = new com.baidu.tieba.homepage.concern.b.c();
            cVar.hJy = builder.user_tips_type.intValue();
            cVar.tipString = builder.user_tips;
            if (builder.user_tips_type.intValue() == 4) {
                cVar.hJz = true;
            } else {
                cVar.hJA = true;
            }
            linkedList.add(cVar);
        }
        this.hasMore = builder.has_more.intValue() == 1;
        if (v.isEmpty(linkedList)) {
            if (this.hIs.isEmpty()) {
                return false;
            }
            Iterator<m> it = this.hIs.iterator();
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
                this.hIs.remove(mVar);
            }
            this.hIw.ak(this.hIs);
            return false;
        }
        this.hIs.clear();
        this.hIs.addAll(linkedList);
        if (z2) {
            this.hIt.page_tag = dataRes.page_tag;
            this.hIt.has_more = dataRes.has_more;
            this.hIt.user_list = dataRes.user_list;
            this.hIt.user_tips_type = dataRes.user_tips_type;
            this.hIt.user_tips = dataRes.user_tips;
            this.hIt.last_tips = dataRes.last_tips;
        }
        this.hIt.banner_user_story = dataRes.banner_user_story;
        this.hIt.banner_follow_live = dataRes.banner_follow_live;
        this.hIt.top_tips = dataRes.top_tips;
        this.hIt.top_user_info = dataRes.top_user_info;
        if (this.hIy == 2 || this.hIy == 3) {
            this.hIt.user_tips_type = dataRes.user_tips_type;
            this.hIt.user_tips = dataRes.user_tips;
        }
        this.hIw.ak(this.hIs);
        return true;
    }

    private void aIm() {
        ac.a(new ab<DataRes>() { // from class: com.baidu.tieba.homepage.concern.c.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.ab
            /* renamed from: bYb */
            public DataRes doInBackground() {
                l<byte[]> cA = com.baidu.tbadk.core.c.a.aMR().cA("tb.concern_page", TbadkCoreApplication.getCurrentAccount());
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

    private void bIL() {
        if (this.hIt != null) {
            DataRes.Builder builder = new DataRes.Builder(this.hIt.build(true));
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
                    com.baidu.tbadk.core.c.a.aMR().cA("tb.concern_page", TbadkCoreApplication.getCurrentAccount()).setForever("0", builder2.build(true).toByteArray());
                    return null;
                } catch (Exception e) {
                    BdLog.e(e);
                    return null;
                }
            }
        }, null);
    }

    public void a(a aVar) {
        this.hIr = aVar;
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

    public boolean bXZ() {
        return this.hIv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(CustomResponsedMessage<?> customResponsedMessage) {
        ThreadInfo threadInfo;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.hIt != null && v.getCount(this.hIt.thread_info) != 0 && v.getCount(this.hIs) != 0) {
            String optString = ((JSONObject) customResponsedMessage.getData()).optString("tid");
            if (!StringUtils.isNull(optString)) {
                Iterator<m> it = this.hIs.iterator();
                boolean z = false;
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    m next = it.next();
                    if (next instanceof com.baidu.tieba.card.data.c) {
                        com.baidu.tieba.card.data.c cVar = (com.baidu.tieba.card.data.c) next;
                        if (cVar.aIu() != null && cVar.aIu().getTid() != null) {
                            if (cVar.aIu().getTid().equals(optString)) {
                                z = true;
                                it.remove();
                            } else if (z) {
                                if (this.hIw != null) {
                                    this.hIw.ak(this.hIs);
                                }
                            }
                        }
                    }
                    z = z;
                }
                long j = com.baidu.adp.lib.f.b.toLong(optString, 0L);
                for (int i = 0; i < this.hIt.thread_info.size(); i++) {
                    ConcernData concernData = this.hIt.thread_info.get(i);
                    if (concernData != null && (threadInfo = concernData.thread_list) != null && threadInfo.tid != null && threadInfo.tid.longValue() == j) {
                        this.hIt.thread_info.remove(i);
                        bIL();
                        return;
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bYa() {
        if (this.hIt != null && v.getCount(this.hIt.thread_info) != 0 && v.getCount(this.hIs) != 0) {
            int i = 0;
            while (true) {
                if (i >= this.hIs.size()) {
                    break;
                } else if (!(this.hIs.get(i) instanceof com.baidu.tieba.homepage.concern.b.b)) {
                    i++;
                } else {
                    this.hIs.remove(i);
                    if (this.hIw != null) {
                        this.hIw.ak(this.hIs);
                    }
                }
            }
            for (int i2 = 0; i2 < this.hIt.thread_info.size(); i2++) {
                if (com.baidu.tieba.homepage.concern.b.b.a(this.hIt.thread_info.get(i2))) {
                    this.hIt.thread_info.remove(i2);
                    bIL();
                    return;
                }
            }
        }
    }
}
