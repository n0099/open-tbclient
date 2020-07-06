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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.w;
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
    private z eEB;
    private View.OnTouchListener erl;
    private final BdTypeRecyclerView hEN;
    private boolean hasMore;
    private com.baidu.tieba.f.a iac;
    private BigdaySwipeRefreshLayout imi;
    private DataRes.Builder imp;
    private final com.baidu.tieba.homepage.concern.a ims;
    private final com.baidu.tieba.homepage.concern.c.a imt;
    private int imu;
    private String pageTag;
    private a imn = null;
    private final LinkedList<q> imo = new LinkedList<>();
    private boolean mIsLoading = false;
    private boolean imq = false;
    private boolean imr = false;
    private boolean mIsBackground = false;
    private CustomMessageListener dUF = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.homepage.concern.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (data.els == null) {
                    if (!data.isSucc) {
                        BdToast.a(TbadkCoreApplication.getInst().getContext(), updateAttentionMessage.getData().errorString, R.drawable.icon_pure_toast_mistake40_svg, 3000, true).aUS();
                    } else if (!data.isAttention) {
                        Iterator it = c.this.imo.iterator();
                        while (it.hasNext()) {
                            Object next = it.next();
                            if ((next instanceof com.baidu.tieba.card.data.c) && aw.h(((com.baidu.tieba.card.data.c) next).aPS(), data.toUid)) {
                                it.remove();
                            }
                        }
                        if (c.this.imo.size() < 9) {
                            c.this.aPJ();
                            return;
                        }
                        c.this.setList(c.this.imo);
                        c.this.ims.notifyDataSetChanged();
                        if (c.this.imn != null) {
                            c.this.imn.W(false, false);
                        }
                    }
                }
            }
        }
    };
    RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.concern.c.2
        private int imy = 0;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (c.this.eEB != null && !c.this.mIsBackground) {
                c.this.eEB.k(recyclerView, i);
            }
            if (i == 0) {
                s.bOB().brU();
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
            if (c.this.eEB != null && !c.this.mIsBackground) {
                c.this.eEB.onScroll(this.imy, i);
            }
            this.imy = i;
        }
    };
    private View.OnTouchListener eEC = new View.OnTouchListener() { // from class: com.baidu.tieba.homepage.concern.c.3
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (c.this.erl != null) {
                c.this.erl.onTouch(view, motionEvent);
            }
            if (c.this.iac != null) {
                c.this.iac.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private CustomMessageListener imv = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.homepage.concern.c.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c.this.g(customResponsedMessage);
        }
    };
    private CustomMessageListener hjc = new CustomMessageListener(CmdConfigCustom.CMD_THREAD_NOT_EXIST_WHEN_ENTER_PB) { // from class: com.baidu.tieba.homepage.concern.c.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c.this.g(customResponsedMessage);
        }
    };
    private CustomMessageListener imw = new CustomMessageListener(2921425) { // from class: com.baidu.tieba.homepage.concern.c.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c.this.cie();
        }
    };

    /* loaded from: classes9.dex */
    public interface a {
        void FX(String str);

        void W(boolean z, boolean z2);

        void cia();

        void cib();

        void onError(int i, String str);
    }

    public void setTabInForeBackgroundState(boolean z) {
        this.mIsBackground = z;
    }

    public void ni(boolean z) {
        this.mIsBackground = z;
    }

    public c(e<?> eVar, BdTypeRecyclerView bdTypeRecyclerView, com.baidu.tieba.homepage.concern.a aVar, BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout) {
        this.hEN = bdTypeRecyclerView;
        this.hEN.setOnTouchListener(this.eEC);
        this.iac = new com.baidu.tieba.f.a();
        this.imt = new com.baidu.tieba.homepage.concern.c.a();
        this.ims = aVar;
        bdTypeRecyclerView.setOnScrollListener(this.mOnScrollListener);
        this.imi = bigdaySwipeRefreshLayout;
    }

    public void s(BdUniqueId bdUniqueId) {
        this.imv.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.imv);
        this.hjc.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.hjc);
        this.imw.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.imw);
        this.dUF.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.dUF);
    }

    public void setRecommendFrsNavigationAnimDispatcher(aa aaVar) {
        if (aaVar != null) {
            this.eEB = aaVar.bja();
            this.erl = aaVar.bjb();
        }
    }

    public void update() {
        if (this.imo.size() == 0 && !this.imq) {
            aPK();
        } else {
            aPJ();
        }
    }

    public void cic() {
        aPJ();
    }

    public void btv() {
        if (!isLoading() && this.hasMore && this.imn != null) {
            setIsLoading(true);
            this.imn.FX(this.pageTag);
        }
    }

    public void a(boolean z, DataRes dataRes, int i, String str) {
        setIsLoading(false);
        if (i != 0 || dataRes == null || !a(true, z, dataRes)) {
            if (i == 0 && w.getCount(this.imo) == 0 && this.imn != null) {
                this.imn.cib();
                if (this.imi != null) {
                    this.imi.setRefreshing(false);
                    return;
                }
                return;
            } else if (this.imo.size() > 0) {
                if (this.imn != null) {
                    this.imn.onError(1, str);
                }
            } else if (this.imn != null) {
                this.imn.onError(2, str);
            }
        } else {
            if (this.imn != null) {
                this.imn.W(z, false);
            }
            bSk();
        }
        if (this.imi != null) {
            this.imi.setRefreshing(false);
        }
    }

    public void oo(boolean z) {
        if (z) {
            this.ims.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aPJ() {
        if (this.imn != null) {
            this.imn.cia();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(DataRes dataRes) {
        this.imq = true;
        if (dataRes != null) {
            if (a(false, true, dataRes)) {
                if (this.imn != null) {
                    this.imn.W(false, true);
                    return;
                }
                return;
            }
            aPJ();
            return;
        }
        aPJ();
    }

    private List<q> a(boolean z, DataRes.Builder builder, boolean z2) {
        if (this.imp == null) {
            this.imp = new DataRes.Builder();
        }
        if (builder == null) {
            builder = new DataRes.Builder();
        }
        com.baidu.tieba.homepage.personalize.model.c a2 = this.imt.a(z, this.imp, builder, z2 ? 0 : 1);
        if (a2 == null) {
            return null;
        }
        return a2.eSH;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setList(List<q> list) {
        this.ims.bN(list);
    }

    private boolean a(boolean z, boolean z2, DataRes dataRes) {
        q qVar;
        if (dataRes == null) {
            return false;
        }
        this.pageTag = dataRes.page_tag;
        LinkedList linkedList = new LinkedList();
        DataRes.Builder builder = new DataRes.Builder(dataRes);
        this.imu = builder.user_tips_type.intValue();
        if (dataRes.req_unix != null) {
            com.baidu.tbadk.core.sharedPref.b.aVP().putLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(SharedPrefConfig.CONCERN_DATA_RES_REQUEST_TIME), dataRes.req_unix.longValue());
        }
        List<q> a2 = a(z, builder, z2);
        this.imr = false;
        if (a2 != null && TbadkCoreApplication.isLogin()) {
            if (3 == this.imu) {
                if (w.isEmpty(a2)) {
                    a2.add(new com.baidu.tieba.homepage.concern.b.a());
                    this.imr = true;
                } else if (w.getCount(a2) == 1 && (w.getItem(a2, 0) instanceof com.baidu.tieba.homepage.concern.b.b)) {
                    a2.add(new com.baidu.tieba.homepage.concern.b.a());
                    this.imr = true;
                }
            }
            linkedList.addAll(a2);
        }
        if (!ar.isEmpty(builder.user_tips) && 2 == this.imu) {
            com.baidu.tieba.homepage.concern.b.c cVar = new com.baidu.tieba.homepage.concern.b.c();
            cVar.inq = builder.user_tips_type.intValue();
            cVar.tipString = builder.user_tips;
            if (builder.user_tips_type.intValue() == 4) {
                cVar.inr = true;
            } else {
                cVar.f7int = true;
            }
            linkedList.add(cVar);
        }
        this.hasMore = builder.has_more.intValue() == 1;
        if (w.isEmpty(linkedList)) {
            if (this.imo.isEmpty()) {
                return false;
            }
            Iterator<q> it = this.imo.iterator();
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
                this.imo.remove(qVar);
            }
            this.ims.bN(this.imo);
            return false;
        }
        this.imo.clear();
        this.imo.addAll(linkedList);
        if (z2) {
            this.imp.page_tag = dataRes.page_tag;
            this.imp.has_more = dataRes.has_more;
            this.imp.user_list = dataRes.user_list;
            this.imp.user_tips_type = dataRes.user_tips_type;
            this.imp.user_tips = dataRes.user_tips;
            this.imp.last_tips = dataRes.last_tips;
        }
        this.imp.banner_user_story = dataRes.banner_user_story;
        this.imp.banner_follow_live = dataRes.banner_follow_live;
        this.imp.top_tips = dataRes.top_tips;
        this.imp.top_user_info = dataRes.top_user_info;
        if (this.imu == 2 || this.imu == 3) {
            this.imp.user_tips_type = dataRes.user_tips_type;
            this.imp.user_tips = dataRes.user_tips;
        }
        this.ims.bN(this.imo);
        return true;
    }

    private void aPK() {
        ad.a(new ac<DataRes>() { // from class: com.baidu.tieba.homepage.concern.c.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.ac
            /* renamed from: cif */
            public DataRes doInBackground() {
                l<byte[]> dc = com.baidu.tbadk.core.c.a.aUM().dc("tb.concern_page", TbadkCoreApplication.getCurrentAccount());
                if (dc == null) {
                    return null;
                }
                byte[] bArr = dc.get("0");
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

    private void bSk() {
        if (this.imp != null) {
            DataRes.Builder builder = new DataRes.Builder(this.imp.build(true));
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
                    com.baidu.tbadk.core.c.a.aUM().dc("tb.concern_page", TbadkCoreApplication.getCurrentAccount()).setForever("0", builder2.build(true).toByteArray());
                    return null;
                } catch (Exception e) {
                    BdLog.e(e);
                    return null;
                }
            }
        }, null);
    }

    public void a(a aVar) {
        this.imn = aVar;
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

    public boolean cid() {
        return this.imr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(CustomResponsedMessage<?> customResponsedMessage) {
        ThreadInfo threadInfo;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.imp != null && w.getCount(this.imp.thread_info) != 0 && w.getCount(this.imo) != 0) {
            String optString = ((JSONObject) customResponsedMessage.getData()).optString("tid");
            if (!StringUtils.isNull(optString)) {
                Iterator<q> it = this.imo.iterator();
                boolean z = false;
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    q next = it.next();
                    if (next instanceof com.baidu.tieba.card.data.c) {
                        com.baidu.tieba.card.data.c cVar = (com.baidu.tieba.card.data.c) next;
                        if (cVar.aPS() != null && cVar.aPS().getTid() != null) {
                            if (cVar.aPS().getTid().equals(optString)) {
                                z = true;
                                it.remove();
                            } else if (z) {
                                if (this.ims != null) {
                                    this.ims.bN(this.imo);
                                }
                            }
                        }
                    }
                    z = z;
                }
                long j = com.baidu.adp.lib.f.b.toLong(optString, 0L);
                for (int i = 0; i < this.imp.thread_info.size(); i++) {
                    ConcernData concernData = this.imp.thread_info.get(i);
                    if (concernData != null && (threadInfo = concernData.thread_list) != null && threadInfo.tid != null && threadInfo.tid.longValue() == j) {
                        this.imp.thread_info.remove(i);
                        bSk();
                        return;
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cie() {
        if (this.imp != null && w.getCount(this.imp.thread_info) != 0 && w.getCount(this.imo) != 0) {
            int i = 0;
            while (true) {
                if (i >= this.imo.size()) {
                    break;
                } else if (!(this.imo.get(i) instanceof com.baidu.tieba.homepage.concern.b.b)) {
                    i++;
                } else {
                    this.imo.remove(i);
                    if (this.ims != null) {
                        this.ims.bN(this.imo);
                    }
                }
            }
            for (int i2 = 0; i2 < this.imp.thread_info.size(); i2++) {
                if (com.baidu.tieba.homepage.concern.b.b.a(this.imp.thread_info.get(i2))) {
                    this.imp.thread_info.remove(i2);
                    bSk();
                    return;
                }
            }
        }
    }
}
