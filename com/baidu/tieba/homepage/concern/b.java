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
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.util.g;
import com.baidu.tbadk.util.r;
import com.baidu.tbadk.util.s;
import com.baidu.tbadk.util.u;
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
    private View.OnTouchListener aJj;
    private r aWE;
    private com.baidu.tieba.f.a dGF;
    private LongSparseArray<com.baidu.tieba.homepage.concern.b.b> dRl;
    private com.baidu.tieba.homepage.concern.b.a dSS;
    private com.baidu.tieba.homepage.concern.b.b dST;
    private DataRes.Builder dSU;
    private final com.baidu.tieba.homepage.concern.a dSW;
    private final com.baidu.tieba.homepage.concern.c.a dSX;
    private int dSY;
    private boolean hasMore;
    private final BdTypeListView mListView;
    private String pageTag;
    private a dSR = null;
    private final List<h> mDataList = new LinkedList();
    private boolean mIsLoading = false;
    private boolean dSV = false;
    private boolean mIsBackground = false;
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.homepage.concern.b.1
        private int dTa = 0;

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (b.this.aWE != null && !b.this.mIsBackground) {
                b.this.aWE.g(absListView, i);
            }
            if (i == 0) {
                v.ajb().SC();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (b.this.aWE != null && !b.this.mIsBackground) {
                b.this.aWE.onScroll(this.dTa, i);
            }
            this.dTa = i;
        }
    };
    private View.OnTouchListener aWF = new View.OnTouchListener() { // from class: com.baidu.tieba.homepage.concern.b.2
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (b.this.aJj != null) {
                b.this.aJj.onTouch(view, motionEvent);
            }
            if (b.this.dGF != null) {
                b.this.dGF.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private a.InterfaceC0144a bKb = new a.InterfaceC0144a() { // from class: com.baidu.tieba.homepage.concern.b.3
        @Override // com.baidu.tieba.f.a.InterfaceC0144a
        public void Y(int i, int i2) {
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0144a
        public void Z(int i, int i2) {
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0144a
        public void aa(int i, int i2) {
        }
    };
    private CustomMessageListener dSZ = new CustomMessageListener(2016488) { // from class: com.baidu.tieba.homepage.concern.b.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.this.h(customResponsedMessage);
        }
    };
    private CustomMessageListener dEh = new CustomMessageListener(2016553) { // from class: com.baidu.tieba.homepage.concern.b.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.this.h(customResponsedMessage);
        }
    };

    /* loaded from: classes2.dex */
    public interface a {
        void A(boolean z, boolean z2);

        void aDj();

        void aDk();

        void nt(String str);

        void onError(int i, String str);
    }

    public void setTabInForeBackgroundState(boolean z) {
        this.mIsBackground = z;
    }

    public void fJ(boolean z) {
        this.mIsBackground = z;
    }

    public b(e<?> eVar, BdTypeListView bdTypeListView, com.baidu.tieba.homepage.concern.a aVar) {
        this.mListView = bdTypeListView;
        this.mListView.setOnTouchListener(this.aWF);
        this.dGF = new com.baidu.tieba.f.a();
        this.dSX = new com.baidu.tieba.homepage.concern.c.a();
        this.dGF.a(this.bKb);
        this.dSW = aVar;
        bdTypeListView.setOnScrollListener(this.mOnScrollListener);
    }

    public void l(BdUniqueId bdUniqueId) {
        this.dSZ.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.dSZ);
        this.dEh.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.dEh);
    }

    public void setRecommendFrsNavigationAnimDispatcher(s sVar) {
        if (sVar != null) {
            this.aWE = sVar.Ly();
            this.aJj = sVar.Lz();
        }
    }

    public void update() {
        if (this.mDataList.size() == 0 && !this.dSV) {
            tw();
        } else {
            tv();
        }
    }

    public void aDl() {
        tv();
    }

    public void Tq() {
        if (!AB() && this.hasMore && this.dSR != null) {
            setIsLoading(true);
            this.dSR.nt(this.pageTag);
        }
    }

    public void a(boolean z, DataRes dataRes, int i, String str) {
        setIsLoading(false);
        this.mListView.completePullRefreshPostDelayed(2000L);
        if (i != 0 || dataRes == null || !a(true, z, dataRes)) {
            if (i == 0 && w.y(this.mDataList) == 0 && this.dSR != null) {
                this.dSR.aDk();
                return;
            } else if (this.mDataList.size() > 0) {
                if (this.dSR != null) {
                    this.dSR.onError(1, str);
                    return;
                }
                return;
            } else if (this.dSR != null) {
                this.dSR.onError(2, str);
                return;
            } else {
                return;
            }
        }
        if (this.dSR != null) {
            this.dSR.A(z, false);
        }
        aoV();
    }

    public void gH(boolean z) {
        if (z) {
            this.dSW.notifyDataSetChanged();
        }
    }

    private void tv() {
        if (this.dSR != null) {
            this.dSR.aDj();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(DataRes dataRes) {
        this.dSV = true;
        if (dataRes != null) {
            if (a(false, true, dataRes)) {
                if (this.dSR != null) {
                    this.dSR.A(false, true);
                    return;
                }
                return;
            }
            tv();
            return;
        }
        tv();
    }

    private List<h> a(boolean z, DataRes.Builder builder, boolean z2) {
        if (this.dSU == null) {
            this.dSU = new DataRes.Builder();
        }
        if (builder == null) {
            builder = new DataRes.Builder();
        }
        c a2 = this.dSX.a(z, this.dSU, builder, z2 ? 0 : 1);
        if (a2 == null) {
            return null;
        }
        return a2.bhG;
    }

    private List<h> a(DataRes.Builder builder) {
        if (builder == null || w.z(builder.user_list)) {
            return null;
        }
        bO(builder.user_list);
        ArrayList arrayList = new ArrayList();
        if (!w.z(builder.user_list)) {
            int i = 0;
            for (UserList userList : builder.user_list) {
                if (userList != null) {
                    if (i == 30) {
                        break;
                    }
                    com.baidu.tieba.homepage.concern.b.b bVar = this.dRl.get(userList.id.longValue());
                    if (bVar != null) {
                        arrayList.add(bVar);
                        i++;
                    }
                }
            }
        }
        this.dRl.clear();
        return arrayList;
    }

    private void bO(List<UserList> list) {
        if (this.dRl == null) {
            this.dRl = new LongSparseArray<>();
        }
        for (UserList userList : list) {
            com.baidu.tieba.homepage.concern.b.b a2 = a(userList);
            switch (this.dSY) {
                case 2:
                    a2.my(2);
                    break;
                case 3:
                    a2.my(3);
                    break;
                case 4:
                    a2.my(4);
                    break;
            }
            if (a2 != null) {
                this.dRl.put(userList.id.longValue(), a2);
            }
        }
    }

    private com.baidu.tieba.homepage.concern.b.b a(UserList userList) {
        com.baidu.tieba.homepage.concern.b.b bVar = new com.baidu.tieba.homepage.concern.b.b();
        bVar.dTD = new com.baidu.tieba.homepage.concern.b.c();
        bVar.dTD.b(userList);
        bVar.dbw = new bb();
        bVar.dbw.a(userList.thread_info);
        bVar.aDo();
        if (bVar.dbw.isLinkThread()) {
            bVar.isLinkThread = true;
        }
        if (StringUtils.isNull(bVar.dTD.getName()) || bVar.dTD.getId() == 0 || StringUtils.isNull(bVar.dbw.getTid()) || StringUtils.isNull(bVar.dbw.getId())) {
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
            this.dSS = null;
            this.dST = null;
        }
        DataRes.Builder builder = new DataRes.Builder(dataRes);
        if (dataRes.banner_follow_live != null && dataRes.banner_follow_live._switch.intValue() == 1 && TbadkCoreApplication.isLogin()) {
            com.baidu.tbadk.data.b bVar = new com.baidu.tbadk.data.b();
            bVar.a(dataRes.banner_follow_live);
            if (!w.z(bVar.getList())) {
                this.mDataList.add(bVar);
            }
        }
        if (dataRes.req_unix != null) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("concern_data_res_request_time"), dataRes.req_unix.longValue());
        }
        if (dataRes.top_user_info != null && aDm()) {
            if (!ap.isEmpty(builder.top_tips)) {
                com.baidu.tieba.homepage.concern.b.a aVar = new com.baidu.tieba.homepage.concern.b.a();
                aVar.ats = builder.top_tips;
                this.dSS = aVar;
                this.mDataList.add(aVar);
            }
            com.baidu.tieba.homepage.concern.b.b a2 = a(dataRes.top_user_info);
            a2.my(1);
            this.dST = a2;
            this.mDataList.add(a2);
        }
        if (dataRes.top_user_info == null && !z2 && this.dST != null && aDm() && this.dSS != null) {
            this.mDataList.add(this.dSS);
            this.mDataList.add(this.dST);
        }
        List<h> a3 = a(z, builder, z2);
        if (a3 != null && TbadkCoreApplication.isLogin()) {
            this.mDataList.addAll(a3);
        }
        if (!ap.isEmpty(builder.user_tips)) {
            com.baidu.tieba.homepage.concern.b.a aVar2 = new com.baidu.tieba.homepage.concern.b.a();
            this.dSY = builder.user_tips_type.intValue();
            aVar2.dTy = builder.user_tips_type.intValue();
            aVar2.ats = builder.user_tips;
            aVar2.dTA = true;
            this.mDataList.add(aVar2);
        }
        List<h> a4 = a(builder);
        if (a4 != null) {
            this.mDataList.addAll(a4);
        }
        if (!ap.isEmpty(builder.last_tips)) {
            com.baidu.tieba.homepage.concern.b.a aVar3 = new com.baidu.tieba.homepage.concern.b.a();
            aVar3.ats = builder.last_tips;
            aVar3.dTz = true;
            this.mDataList.add(aVar3);
        }
        this.hasMore = builder.has_more.intValue() == 1;
        if (w.z(this.mDataList)) {
            return false;
        }
        if (z2) {
            this.dSU.page_tag = dataRes.page_tag;
            this.dSU.has_more = dataRes.has_more;
            this.dSU.user_list = dataRes.user_list;
            this.dSU.user_tips_type = dataRes.user_tips_type;
            this.dSU.user_tips = dataRes.user_tips;
            this.dSU.last_tips = dataRes.last_tips;
        }
        this.dSU.banner_user_story = dataRes.banner_user_story;
        this.dSU.banner_follow_live = dataRes.banner_follow_live;
        this.dSU.top_tips = dataRes.top_tips;
        this.dSU.top_user_info = dataRes.top_user_info;
        if (this.dSY == 2 || this.dSY == 3) {
            this.dSU.user_tips_type = dataRes.user_tips_type;
            this.dSU.user_tips = dataRes.user_tips;
        }
        this.dSW.ai(this.mDataList);
        return true;
    }

    private boolean aDm() {
        if (TbadkCoreApplication.isLogin()) {
            if (System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.getInstance().getLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("concern_top_user_user_like_time"), 0L) > 86400000) {
                return true;
            }
        }
        return false;
    }

    private void tw() {
        com.baidu.tbadk.util.v.a(new u<DataRes>() { // from class: com.baidu.tieba.homepage.concern.b.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.u
            /* renamed from: aDn */
            public DataRes doInBackground() {
                l<byte[]> P = com.baidu.tbadk.core.c.a.xa().P("tb.concern_page", TbadkCoreApplication.getCurrentAccount());
                if (P == null) {
                    return null;
                }
                byte[] bArr = P.get("0");
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
        }, new g<DataRes>() { // from class: com.baidu.tieba.homepage.concern.b.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.g
            /* renamed from: b */
            public void onReturnDataInUI(DataRes dataRes) {
                b.this.a(dataRes);
            }
        });
    }

    private void aoV() {
        if (this.dSU != null) {
            DataRes.Builder builder = new DataRes.Builder(this.dSU.build(true));
            if (builder.thread_info != null && builder.thread_info.size() > 30) {
                builder.thread_info = builder.thread_info.subList(0, 30);
            }
            b(builder);
        }
    }

    private void b(final DataRes.Builder builder) {
        com.baidu.tbadk.util.v.a(new u<Object>() { // from class: com.baidu.tieba.homepage.concern.b.6
            @Override // com.baidu.tbadk.util.u
            public Object doInBackground() {
                DataRes.Builder builder2 = new DataRes.Builder(builder.build(true));
                try {
                    com.baidu.tbadk.core.c.a.xa().P("tb.concern_page", TbadkCoreApplication.getCurrentAccount()).e("0", builder2.build(true).toByteArray());
                    return null;
                } catch (Exception e) {
                    BdLog.e(e);
                    return null;
                }
            }
        }, null);
    }

    public void a(a aVar) {
        this.dSR = aVar;
    }

    private boolean AB() {
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
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.dSU != null && w.y(this.dSU.thread_info) != 0 && w.y(this.mDataList) != 0) {
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
                        if (cVar.Tg() != null && cVar.Tg().getTid() != null && cVar.Tg().getTid().equals(optString)) {
                            this.mDataList.remove(i);
                            if (this.dSW != null) {
                                this.dSW.ai(this.mDataList);
                            }
                        }
                    }
                    i++;
                }
                long c = com.baidu.adp.lib.g.b.c(optString, 0L);
                for (int i2 = 0; i2 < this.dSU.thread_info.size(); i2++) {
                    ConcernData concernData = this.dSU.thread_info.get(i2);
                    if (concernData != null && (threadInfo = concernData.thread_list) != null && threadInfo.tid != null && threadInfo.tid.longValue() == c) {
                        this.dSU.thread_info.remove(i2);
                        aoV();
                        return;
                    }
                }
            }
        }
    }
}
