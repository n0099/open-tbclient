package com.baidu.tieba.homepage.concern;

import android.support.v4.util.LongSparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AbsListView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.e;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bc;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.util.s;
import com.baidu.tbadk.util.t;
import com.baidu.tieba.card.v;
import com.baidu.tieba.f.a;
import com.baidu.tieba.homepage.personalize.model.c;
import com.squareup.wire.Wire;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;
import tbclient.ThreadInfo;
import tbclient.Userlike.ConcernData;
import tbclient.Userlike.DataRes;
import tbclient.Userlike.UserList;
/* loaded from: classes2.dex */
public class b {
    private View.OnTouchListener aJf;
    private s aWC;
    private com.baidu.tieba.f.a dDX;
    private LongSparseArray<com.baidu.tieba.homepage.concern.b.b> dOD;
    private com.baidu.tieba.homepage.concern.b.a dQk;
    private com.baidu.tieba.homepage.concern.b.b dQl;
    private DataRes.Builder dQm;
    private final com.baidu.tieba.homepage.concern.a dQo;
    private final com.baidu.tieba.homepage.concern.c.a dQp;
    private int dQq;
    private boolean hasMore;
    private final BdTypeListView mListView;
    private String pageTag;
    private a dQj = null;
    private final List<h> mDataList = new LinkedList();
    private boolean mIsLoading = false;
    private boolean dQn = false;
    private boolean mIsBackground = false;
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.homepage.concern.b.1
        private int dQs = 0;

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (b.this.aWC != null && !b.this.mIsBackground) {
                b.this.aWC.h(absListView, i);
            }
            if (i == 0) {
                v.aiz().Sp();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (b.this.aWC != null && !b.this.mIsBackground) {
                b.this.aWC.onScroll(this.dQs, i);
            }
            this.dQs = i;
        }
    };
    private View.OnTouchListener aWD = new View.OnTouchListener() { // from class: com.baidu.tieba.homepage.concern.b.2
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (b.this.aJf != null) {
                b.this.aJf.onTouch(view, motionEvent);
            }
            if (b.this.dDX != null) {
                b.this.dDX.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private a.InterfaceC0147a bJo = new a.InterfaceC0147a() { // from class: com.baidu.tieba.homepage.concern.b.3
        @Override // com.baidu.tieba.f.a.InterfaceC0147a
        public void W(int i, int i2) {
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0147a
        public void X(int i, int i2) {
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0147a
        public void Y(int i, int i2) {
        }
    };
    private CustomMessageListener dQr = new CustomMessageListener(2016488) { // from class: com.baidu.tieba.homepage.concern.b.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.this.h(customResponsedMessage);
        }
    };
    private CustomMessageListener dBy = new CustomMessageListener(2016553) { // from class: com.baidu.tieba.homepage.concern.b.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.this.h(customResponsedMessage);
        }
    };

    /* loaded from: classes2.dex */
    public interface a {
        void A(boolean z, boolean z2);

        void aCE();

        void aCF();

        void nt(String str);

        void onError(int i, String str);
    }

    public void setTabInForeBackgroundState(boolean z) {
        this.mIsBackground = z;
    }

    public void fH(boolean z) {
        this.mIsBackground = z;
    }

    public b(e<?> eVar, BdTypeListView bdTypeListView, com.baidu.tieba.homepage.concern.a aVar) {
        this.mListView = bdTypeListView;
        this.mListView.setOnTouchListener(this.aWD);
        this.dDX = new com.baidu.tieba.f.a();
        this.dQp = new com.baidu.tieba.homepage.concern.c.a();
        this.dDX.a(this.bJo);
        this.dQo = aVar;
        bdTypeListView.setOnScrollListener(this.mOnScrollListener);
    }

    public void l(BdUniqueId bdUniqueId) {
        this.dQr.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.dQr);
        this.dBy.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.dBy);
    }

    public void setRecommendFrsNavigationAnimDispatcher(t tVar) {
        if (tVar != null) {
            this.aWC = tVar.Lz();
            this.aJf = tVar.LA();
        }
    }

    public void update() {
        if (this.mDataList.size() == 0 && !this.dQn) {
            tL();
        } else {
            tK();
        }
    }

    public void aCG() {
        tK();
    }

    public void Tf() {
        if (!AO() && this.hasMore && this.dQj != null) {
            setIsLoading(true);
            this.dQj.nt(this.pageTag);
        }
    }

    public void a(boolean z, DataRes dataRes, int i, String str) {
        setIsLoading(false);
        this.mListView.completePullRefreshPostDelayed(2000L);
        if (i != 0 || dataRes == null || !a(true, z, dataRes)) {
            if (i == 0 && w.z(this.mDataList) == 0 && this.dQj != null) {
                this.dQj.aCF();
                return;
            } else if (this.mDataList.size() > 0) {
                if (this.dQj != null) {
                    this.dQj.onError(1, str);
                    return;
                }
                return;
            } else if (this.dQj != null) {
                this.dQj.onError(2, str);
                return;
            } else {
                return;
            }
        }
        if (this.dQj != null) {
            this.dQj.A(z, false);
        }
        aov();
    }

    public void gF(boolean z) {
        if (z) {
            this.dQo.notifyDataSetChanged();
        }
    }

    private void tK() {
        if (this.dQj != null) {
            this.dQj.aCE();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(DataRes dataRes) {
        this.dQn = true;
        if (dataRes != null) {
            if (a(false, true, dataRes)) {
                if (this.dQj != null) {
                    this.dQj.A(false, true);
                    return;
                }
                return;
            }
            tK();
            return;
        }
        tK();
    }

    private List<h> a(boolean z, DataRes.Builder builder, boolean z2) {
        if (this.dQm == null) {
            this.dQm = new DataRes.Builder();
        }
        if (builder == null) {
            builder = new DataRes.Builder();
        }
        c a2 = this.dQp.a(z, this.dQm, builder, z2 ? 0 : 1);
        if (a2 == null) {
            return null;
        }
        return a2.bha;
    }

    private List<h> a(DataRes.Builder builder) {
        if (builder == null || w.A(builder.user_list)) {
            return null;
        }
        bP(builder.user_list);
        ArrayList arrayList = new ArrayList();
        if (!w.A(builder.user_list)) {
            int i = 0;
            for (UserList userList : builder.user_list) {
                if (userList != null) {
                    if (i == 30) {
                        break;
                    }
                    com.baidu.tieba.homepage.concern.b.b bVar = this.dOD.get(userList.id.longValue());
                    if (bVar != null) {
                        arrayList.add(bVar);
                        i++;
                    }
                }
            }
        }
        this.dOD.clear();
        return arrayList;
    }

    private void bP(List<UserList> list) {
        if (this.dOD == null) {
            this.dOD = new LongSparseArray<>();
        }
        for (UserList userList : list) {
            com.baidu.tieba.homepage.concern.b.b a2 = a(userList);
            switch (this.dQq) {
                case 2:
                    a2.mm(2);
                    break;
                case 3:
                    a2.mm(3);
                    break;
                case 4:
                    a2.mm(4);
                    break;
            }
            if (a2 != null) {
                this.dOD.put(userList.id.longValue(), a2);
            }
        }
    }

    private com.baidu.tieba.homepage.concern.b.b a(UserList userList) {
        com.baidu.tieba.homepage.concern.b.b bVar = new com.baidu.tieba.homepage.concern.b.b();
        bVar.dQV = new com.baidu.tieba.homepage.concern.b.c();
        bVar.dQV.b(userList);
        bVar.cYJ = new bc();
        bVar.cYJ.a(userList.thread_info);
        bVar.aCJ();
        if (bVar.cYJ.isLinkThread()) {
            bVar.isLinkThread = true;
        }
        if (StringUtils.isNull(bVar.dQV.getName()) || bVar.dQV.getId() == 0 || StringUtils.isNull(bVar.cYJ.getTid()) || StringUtils.isNull(bVar.cYJ.getId())) {
            return null;
        }
        return bVar;
    }

    private boolean a(boolean z, boolean z2, DataRes dataRes) {
        if (dataRes == null) {
            return false;
        }
        this.pageTag = dataRes.page_tag;
        this.mDataList.clear();
        if (z2) {
            this.dQk = null;
            this.dQl = null;
        }
        DataRes.Builder builder = new DataRes.Builder(dataRes);
        if (dataRes.banner_follow_live != null && dataRes.banner_follow_live._switch.intValue() == 1 && TbadkCoreApplication.isLogin()) {
            com.baidu.tbadk.data.b bVar = new com.baidu.tbadk.data.b();
            bVar.a(dataRes.banner_follow_live);
            if (!w.A(bVar.getList())) {
                this.mDataList.add(bVar);
            }
        }
        if (dataRes.req_unix != null) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("concern_data_res_request_time"), dataRes.req_unix.longValue());
        }
        if (dataRes.top_user_info != null && aCH()) {
            if (!ap.isEmpty(builder.top_tips)) {
                com.baidu.tieba.homepage.concern.b.a aVar = new com.baidu.tieba.homepage.concern.b.a();
                aVar.atN = builder.top_tips;
                this.dQk = aVar;
                this.mDataList.add(aVar);
            }
            com.baidu.tieba.homepage.concern.b.b a2 = a(dataRes.top_user_info);
            a2.mm(1);
            this.dQl = a2;
            this.mDataList.add(a2);
        }
        if (dataRes.top_user_info == null && !z2 && this.dQl != null && aCH() && this.dQk != null) {
            this.mDataList.add(this.dQk);
            this.mDataList.add(this.dQl);
        }
        List<h> a3 = a(z, builder, z2);
        if (a3 != null && TbadkCoreApplication.isLogin()) {
            this.mDataList.addAll(a3);
        }
        if (!ap.isEmpty(builder.user_tips)) {
            com.baidu.tieba.homepage.concern.b.a aVar2 = new com.baidu.tieba.homepage.concern.b.a();
            this.dQq = builder.user_tips_type.intValue();
            aVar2.dQQ = builder.user_tips_type.intValue();
            aVar2.atN = builder.user_tips;
            aVar2.dQS = true;
            this.mDataList.add(aVar2);
        }
        List<h> a4 = a(builder);
        if (a4 != null) {
            this.mDataList.addAll(a4);
        }
        if (!ap.isEmpty(builder.last_tips)) {
            com.baidu.tieba.homepage.concern.b.a aVar3 = new com.baidu.tieba.homepage.concern.b.a();
            aVar3.atN = builder.last_tips;
            aVar3.dQR = true;
            this.mDataList.add(aVar3);
        }
        this.hasMore = builder.has_more.intValue() == 1;
        if (w.A(this.mDataList)) {
            return false;
        }
        if (z2) {
            this.dQm.page_tag = dataRes.page_tag;
            this.dQm.has_more = dataRes.has_more;
            this.dQm.user_list = dataRes.user_list;
            this.dQm.user_tips_type = dataRes.user_tips_type;
            this.dQm.user_tips = dataRes.user_tips;
            this.dQm.last_tips = dataRes.last_tips;
        }
        this.dQm.banner_user_story = dataRes.banner_user_story;
        this.dQm.banner_follow_live = dataRes.banner_follow_live;
        this.dQm.top_tips = dataRes.top_tips;
        this.dQm.top_user_info = dataRes.top_user_info;
        if (this.dQq == 2 || this.dQq == 3) {
            this.dQm.user_tips_type = dataRes.user_tips_type;
            this.dQm.user_tips = dataRes.user_tips;
        }
        this.dQo.aj(this.mDataList);
        return true;
    }

    private boolean aCH() {
        if (TbadkCoreApplication.isLogin()) {
            if (System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.getInstance().getLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("concern_top_user_user_like_time"), 0L) > 86400000) {
                return true;
            }
        }
        return false;
    }

    private void tL() {
        com.baidu.tbadk.util.w.a(new com.baidu.tbadk.util.v<DataRes>() { // from class: com.baidu.tieba.homepage.concern.b.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.v
            /* renamed from: aCI */
            public DataRes doInBackground() {
                l<byte[]> Q = com.baidu.tbadk.core.c.a.xj().Q("tb.concern_page", TbadkCoreApplication.getCurrentAccount());
                if (Q == null) {
                    return null;
                }
                byte[] bArr = Q.get("0");
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
        }, new com.baidu.tbadk.util.h<DataRes>() { // from class: com.baidu.tieba.homepage.concern.b.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.h
            /* renamed from: b */
            public void onReturnDataInUI(DataRes dataRes) {
                b.this.a(dataRes);
            }
        });
    }

    private void aov() {
        if (this.dQm != null) {
            DataRes.Builder builder = new DataRes.Builder(this.dQm.build(true));
            if (builder.thread_info != null && builder.thread_info.size() > 30) {
                builder.thread_info = builder.thread_info.subList(0, 30);
            }
            b(builder);
        }
    }

    private void b(final DataRes.Builder builder) {
        com.baidu.tbadk.util.w.a(new com.baidu.tbadk.util.v<Object>() { // from class: com.baidu.tieba.homepage.concern.b.6
            @Override // com.baidu.tbadk.util.v
            public Object doInBackground() {
                DataRes.Builder builder2 = new DataRes.Builder(builder.build(true));
                try {
                    com.baidu.tbadk.core.c.a.xj().Q("tb.concern_page", TbadkCoreApplication.getCurrentAccount()).e("0", builder2.build(true).toByteArray());
                    return null;
                } catch (Exception e) {
                    BdLog.e(e);
                    return null;
                }
            }
        }, null);
    }

    public void a(a aVar) {
        this.dQj = aVar;
    }

    private boolean AO() {
        return this.mIsLoading;
    }

    private void setIsLoading(boolean z) {
        this.mIsLoading = z;
    }

    public boolean hasMore() {
        return this.hasMore;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(CustomResponsedMessage<?> customResponsedMessage) {
        ThreadInfo threadInfo;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.dQm != null && w.z(this.dQm.thread_info) != 0 && w.z(this.mDataList) != 0) {
            String optString = ((JSONObject) customResponsedMessage.getData()).optString("tid");
            if (!StringUtils.isNull(optString)) {
                int i = 0;
                while (true) {
                    if (i >= this.mDataList.size()) {
                        break;
                    }
                    h hVar = this.mDataList.get(i);
                    if (hVar instanceof com.baidu.tieba.card.data.c) {
                        com.baidu.tieba.card.data.c cVar = (com.baidu.tieba.card.data.c) hVar;
                        if (cVar.SV() != null && cVar.SV().getTid() != null && cVar.SV().getTid().equals(optString)) {
                            this.mDataList.remove(i);
                            if (this.dQo != null) {
                                this.dQo.aj(this.mDataList);
                            }
                        }
                    }
                    i++;
                }
                long c = com.baidu.adp.lib.g.b.c(optString, 0L);
                for (int i2 = 0; i2 < this.dQm.thread_info.size(); i2++) {
                    ConcernData concernData = this.dQm.thread_info.get(i2);
                    if (concernData != null && (threadInfo = concernData.thread_list) != null && threadInfo.tid != null && threadInfo.tid.longValue() == c) {
                        this.dQm.thread_info.remove(i2);
                        aov();
                        return;
                    }
                }
            }
        }
    }
}
