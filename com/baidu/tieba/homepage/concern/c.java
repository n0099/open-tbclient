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
import com.baidu.adp.widget.ListView.o;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.v;
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
/* loaded from: classes9.dex */
public class c {
    private View.OnTouchListener eiB;
    private z evv;
    private com.baidu.tieba.f.a hMQ;
    private BigdaySwipeRefreshLayout hXJ;
    private DataRes.Builder hXQ;
    private final com.baidu.tieba.homepage.concern.a hXT;
    private final com.baidu.tieba.homepage.concern.c.a hXU;
    private int hXV;
    private boolean hasMore;
    private final BdTypeRecyclerView hrX;
    private String pageTag;
    private a hXO = null;
    private final LinkedList<o> hXP = new LinkedList<>();
    private boolean mIsLoading = false;
    private boolean hXR = false;
    private boolean hXS = false;
    private boolean mIsBackground = false;
    private CustomMessageListener dNP = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.homepage.concern.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (data.ecK == null) {
                    if (!data.isSucc) {
                        BdToast.a(TbadkCoreApplication.getInst().getContext(), updateAttentionMessage.getData().errorString, R.drawable.icon_pure_toast_mistake40_svg, 3000, true).aSY();
                    } else if (!data.isAttention) {
                        Iterator it = c.this.hXP.iterator();
                        while (it.hasNext()) {
                            Object next = it.next();
                            if ((next instanceof com.baidu.tieba.card.data.c) && au.a(((com.baidu.tieba.card.data.c) next).aOi(), data.toUid)) {
                                it.remove();
                            }
                        }
                        if (c.this.hXP.size() < 9) {
                            c.this.aNZ();
                            return;
                        }
                        c.this.setList(c.this.hXP);
                        c.this.hXT.notifyDataSetChanged();
                        if (c.this.hXO != null) {
                            c.this.hXO.V(false, false);
                        }
                    }
                }
            }
        }
    };
    RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.concern.c.2
        private int hXZ = 0;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (c.this.evv != null && !c.this.mIsBackground) {
                c.this.evv.j(recyclerView, i);
            }
            if (i == 0) {
                s.bLs().bpt();
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
            if (c.this.evv != null && !c.this.mIsBackground) {
                c.this.evv.onScroll(this.hXZ, i);
            }
            this.hXZ = i;
        }
    };
    private View.OnTouchListener evw = new View.OnTouchListener() { // from class: com.baidu.tieba.homepage.concern.c.3
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (c.this.eiB != null) {
                c.this.eiB.onTouch(view, motionEvent);
            }
            if (c.this.hMQ != null) {
                c.this.hMQ.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private CustomMessageListener hXW = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.homepage.concern.c.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c.this.g(customResponsedMessage);
        }
    };
    private CustomMessageListener gWn = new CustomMessageListener(CmdConfigCustom.CMD_THREAD_NOT_EXIST_WHEN_ENTER_PB) { // from class: com.baidu.tieba.homepage.concern.c.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c.this.g(customResponsedMessage);
        }
    };
    private CustomMessageListener hXX = new CustomMessageListener(2921425) { // from class: com.baidu.tieba.homepage.concern.c.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c.this.ceG();
        }
    };

    /* loaded from: classes9.dex */
    public interface a {
        void Fx(String str);

        void V(boolean z, boolean z2);

        void ceC();

        void ceD();

        void onError(int i, String str);
    }

    public void setTabInForeBackgroundState(boolean z) {
        this.mIsBackground = z;
    }

    public void mX(boolean z) {
        this.mIsBackground = z;
    }

    public c(e<?> eVar, BdTypeRecyclerView bdTypeRecyclerView, com.baidu.tieba.homepage.concern.a aVar, BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout) {
        this.hrX = bdTypeRecyclerView;
        this.hrX.setOnTouchListener(this.evw);
        this.hMQ = new com.baidu.tieba.f.a();
        this.hXU = new com.baidu.tieba.homepage.concern.c.a();
        this.hXT = aVar;
        bdTypeRecyclerView.setOnScrollListener(this.mOnScrollListener);
        this.hXJ = bigdaySwipeRefreshLayout;
    }

    public void s(BdUniqueId bdUniqueId) {
        this.hXW.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.hXW);
        this.gWn.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.gWn);
        this.hXX.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.hXX);
        this.dNP.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.dNP);
    }

    public void setRecommendFrsNavigationAnimDispatcher(aa aaVar) {
        if (aaVar != null) {
            this.evv = aaVar.bgM();
            this.eiB = aaVar.bgN();
        }
    }

    public void update() {
        if (this.hXP.size() == 0 && !this.hXR) {
            aOa();
        } else {
            aNZ();
        }
    }

    public void ceE() {
        aNZ();
    }

    public void bqx() {
        if (!isLoading() && this.hasMore && this.hXO != null) {
            setIsLoading(true);
            this.hXO.Fx(this.pageTag);
        }
    }

    public void a(boolean z, DataRes dataRes, int i, String str) {
        setIsLoading(false);
        if (i != 0 || dataRes == null || !a(true, z, dataRes)) {
            if (i == 0 && v.getCount(this.hXP) == 0 && this.hXO != null) {
                this.hXO.ceD();
                if (this.hXJ != null) {
                    this.hXJ.setRefreshing(false);
                    return;
                }
                return;
            } else if (this.hXP.size() > 0) {
                if (this.hXO != null) {
                    this.hXO.onError(1, str);
                }
            } else if (this.hXO != null) {
                this.hXO.onError(2, str);
            }
        } else {
            if (this.hXO != null) {
                this.hXO.V(z, false);
            }
            bPg();
        }
        if (this.hXJ != null) {
            this.hXJ.setRefreshing(false);
        }
    }

    public void oc(boolean z) {
        if (z) {
            this.hXT.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aNZ() {
        if (this.hXO != null) {
            this.hXO.ceC();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(DataRes dataRes) {
        this.hXR = true;
        if (dataRes != null) {
            if (a(false, true, dataRes)) {
                if (this.hXO != null) {
                    this.hXO.V(false, true);
                    return;
                }
                return;
            }
            aNZ();
            return;
        }
        aNZ();
    }

    private List<o> a(boolean z, DataRes.Builder builder, boolean z2) {
        if (this.hXQ == null) {
            this.hXQ = new DataRes.Builder();
        }
        if (builder == null) {
            builder = new DataRes.Builder();
        }
        com.baidu.tieba.homepage.personalize.model.c a2 = this.hXU.a(z, this.hXQ, builder, z2 ? 0 : 1);
        if (a2 == null) {
            return null;
        }
        return a2.eIv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setList(List<o> list) {
        this.hXT.bE(list);
    }

    private boolean a(boolean z, boolean z2, DataRes dataRes) {
        o oVar;
        if (dataRes == null) {
            return false;
        }
        this.pageTag = dataRes.page_tag;
        LinkedList linkedList = new LinkedList();
        DataRes.Builder builder = new DataRes.Builder(dataRes);
        this.hXV = builder.user_tips_type.intValue();
        if (dataRes.req_unix != null) {
            com.baidu.tbadk.core.sharedPref.b.aTX().putLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(SharedPrefConfig.CONCERN_DATA_RES_REQUEST_TIME), dataRes.req_unix.longValue());
        }
        List<o> a2 = a(z, builder, z2);
        this.hXS = false;
        if (a2 != null && TbadkCoreApplication.isLogin()) {
            if (3 == this.hXV) {
                if (v.isEmpty(a2)) {
                    a2.add(new com.baidu.tieba.homepage.concern.b.a());
                    this.hXS = true;
                } else if (v.getCount(a2) == 1 && (v.getItem(a2, 0) instanceof com.baidu.tieba.homepage.concern.b.b)) {
                    a2.add(new com.baidu.tieba.homepage.concern.b.a());
                    this.hXS = true;
                }
            }
            linkedList.addAll(a2);
        }
        if (!aq.isEmpty(builder.user_tips) && 2 == this.hXV) {
            com.baidu.tieba.homepage.concern.b.c cVar = new com.baidu.tieba.homepage.concern.b.c();
            cVar.hYP = builder.user_tips_type.intValue();
            cVar.tipString = builder.user_tips;
            if (builder.user_tips_type.intValue() == 4) {
                cVar.hYQ = true;
            } else {
                cVar.hYR = true;
            }
            linkedList.add(cVar);
        }
        this.hasMore = builder.has_more.intValue() == 1;
        if (v.isEmpty(linkedList)) {
            if (this.hXP.isEmpty()) {
                return false;
            }
            Iterator<o> it = this.hXP.iterator();
            while (true) {
                if (!it.hasNext()) {
                    oVar = null;
                    break;
                }
                oVar = it.next();
                if (oVar instanceof com.baidu.tbadk.data.a) {
                    break;
                }
            }
            if (oVar != null) {
                this.hXP.remove(oVar);
            }
            this.hXT.bE(this.hXP);
            return false;
        }
        this.hXP.clear();
        this.hXP.addAll(linkedList);
        if (z2) {
            this.hXQ.page_tag = dataRes.page_tag;
            this.hXQ.has_more = dataRes.has_more;
            this.hXQ.user_list = dataRes.user_list;
            this.hXQ.user_tips_type = dataRes.user_tips_type;
            this.hXQ.user_tips = dataRes.user_tips;
            this.hXQ.last_tips = dataRes.last_tips;
        }
        this.hXQ.banner_user_story = dataRes.banner_user_story;
        this.hXQ.banner_follow_live = dataRes.banner_follow_live;
        this.hXQ.top_tips = dataRes.top_tips;
        this.hXQ.top_user_info = dataRes.top_user_info;
        if (this.hXV == 2 || this.hXV == 3) {
            this.hXQ.user_tips_type = dataRes.user_tips_type;
            this.hXQ.user_tips = dataRes.user_tips;
        }
        this.hXT.bE(this.hXP);
        return true;
    }

    private void aOa() {
        ad.a(new ac<DataRes>() { // from class: com.baidu.tieba.homepage.concern.c.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.ac
            /* renamed from: ceH */
            public DataRes doInBackground() {
                l<byte[]> cZ = com.baidu.tbadk.core.c.a.aSS().cZ("tb.concern_page", TbadkCoreApplication.getCurrentAccount());
                if (cZ == null) {
                    return null;
                }
                byte[] bArr = cZ.get("0");
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

    private void bPg() {
        if (this.hXQ != null) {
            DataRes.Builder builder = new DataRes.Builder(this.hXQ.build(true));
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
                    com.baidu.tbadk.core.c.a.aSS().cZ("tb.concern_page", TbadkCoreApplication.getCurrentAccount()).setForever("0", builder2.build(true).toByteArray());
                    return null;
                } catch (Exception e) {
                    BdLog.e(e);
                    return null;
                }
            }
        }, null);
    }

    public void a(a aVar) {
        this.hXO = aVar;
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

    public boolean ceF() {
        return this.hXS;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(CustomResponsedMessage<?> customResponsedMessage) {
        ThreadInfo threadInfo;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.hXQ != null && v.getCount(this.hXQ.thread_info) != 0 && v.getCount(this.hXP) != 0) {
            String optString = ((JSONObject) customResponsedMessage.getData()).optString("tid");
            if (!StringUtils.isNull(optString)) {
                Iterator<o> it = this.hXP.iterator();
                boolean z = false;
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    o next = it.next();
                    if (next instanceof com.baidu.tieba.card.data.c) {
                        com.baidu.tieba.card.data.c cVar = (com.baidu.tieba.card.data.c) next;
                        if (cVar.aOi() != null && cVar.aOi().getTid() != null) {
                            if (cVar.aOi().getTid().equals(optString)) {
                                z = true;
                                it.remove();
                            } else if (z) {
                                if (this.hXT != null) {
                                    this.hXT.bE(this.hXP);
                                }
                            }
                        }
                    }
                    z = z;
                }
                long j = com.baidu.adp.lib.f.b.toLong(optString, 0L);
                for (int i = 0; i < this.hXQ.thread_info.size(); i++) {
                    ConcernData concernData = this.hXQ.thread_info.get(i);
                    if (concernData != null && (threadInfo = concernData.thread_list) != null && threadInfo.tid != null && threadInfo.tid.longValue() == j) {
                        this.hXQ.thread_info.remove(i);
                        bPg();
                        return;
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ceG() {
        if (this.hXQ != null && v.getCount(this.hXQ.thread_info) != 0 && v.getCount(this.hXP) != 0) {
            int i = 0;
            while (true) {
                if (i >= this.hXP.size()) {
                    break;
                } else if (!(this.hXP.get(i) instanceof com.baidu.tieba.homepage.concern.b.b)) {
                    i++;
                } else {
                    this.hXP.remove(i);
                    if (this.hXT != null) {
                        this.hXT.bE(this.hXP);
                    }
                }
            }
            for (int i2 = 0; i2 < this.hXQ.thread_info.size(); i2++) {
                if (com.baidu.tieba.homepage.concern.b.b.a(this.hXQ.thread_info.get(i2))) {
                    this.hXQ.thread_info.remove(i2);
                    bPg();
                    return;
                }
            }
        }
    }
}
