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
    private View.OnTouchListener aJm;
    private r aWE;
    private com.baidu.tieba.f.a dGJ;
    private LongSparseArray<com.baidu.tieba.homepage.concern.b.b> dRq;
    private com.baidu.tieba.homepage.concern.b.a dSX;
    private com.baidu.tieba.homepage.concern.b.b dSY;
    private DataRes.Builder dSZ;
    private final com.baidu.tieba.homepage.concern.a dTb;
    private final com.baidu.tieba.homepage.concern.c.a dTc;
    private int dTd;
    private boolean hasMore;
    private final BdTypeListView mListView;
    private String pageTag;
    private a dSW = null;
    private final List<h> mDataList = new LinkedList();
    private boolean mIsLoading = false;
    private boolean dTa = false;
    private boolean mIsBackground = false;
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.homepage.concern.b.1
        private int dTf = 0;

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (b.this.aWE != null && !b.this.mIsBackground) {
                b.this.aWE.g(absListView, i);
            }
            if (i == 0) {
                v.aiY().Sy();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (b.this.aWE != null && !b.this.mIsBackground) {
                b.this.aWE.onScroll(this.dTf, i);
            }
            this.dTf = i;
        }
    };
    private View.OnTouchListener aWF = new View.OnTouchListener() { // from class: com.baidu.tieba.homepage.concern.b.2
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (b.this.aJm != null) {
                b.this.aJm.onTouch(view, motionEvent);
            }
            if (b.this.dGJ != null) {
                b.this.dGJ.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private a.InterfaceC0145a bKc = new a.InterfaceC0145a() { // from class: com.baidu.tieba.homepage.concern.b.3
        @Override // com.baidu.tieba.f.a.InterfaceC0145a
        public void Y(int i, int i2) {
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0145a
        public void Z(int i, int i2) {
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0145a
        public void aa(int i, int i2) {
        }
    };
    private CustomMessageListener dTe = new CustomMessageListener(2016488) { // from class: com.baidu.tieba.homepage.concern.b.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.this.h(customResponsedMessage);
        }
    };
    private CustomMessageListener dEk = new CustomMessageListener(2016553) { // from class: com.baidu.tieba.homepage.concern.b.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.this.h(customResponsedMessage);
        }
    };

    /* loaded from: classes2.dex */
    public interface a {
        void A(boolean z, boolean z2);

        void aDm();

        void aDn();

        void nr(String str);

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
        this.dGJ = new com.baidu.tieba.f.a();
        this.dTc = new com.baidu.tieba.homepage.concern.c.a();
        this.dGJ.a(this.bKc);
        this.dTb = aVar;
        bdTypeListView.setOnScrollListener(this.mOnScrollListener);
    }

    public void l(BdUniqueId bdUniqueId) {
        this.dTe.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.dTe);
        this.dEk.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.dEk);
    }

    public void setRecommendFrsNavigationAnimDispatcher(s sVar) {
        if (sVar != null) {
            this.aWE = sVar.Lu();
            this.aJm = sVar.Lv();
        }
    }

    public void update() {
        if (this.mDataList.size() == 0 && !this.dTa) {
            tx();
        } else {
            tw();
        }
    }

    public void aDo() {
        tw();
    }

    public void Tn() {
        if (!AE() && this.hasMore && this.dSW != null) {
            setIsLoading(true);
            this.dSW.nr(this.pageTag);
        }
    }

    public void a(boolean z, DataRes dataRes, int i, String str) {
        setIsLoading(false);
        this.mListView.completePullRefreshPostDelayed(2000L);
        if (i != 0 || dataRes == null || !a(true, z, dataRes)) {
            if (i == 0 && w.y(this.mDataList) == 0 && this.dSW != null) {
                this.dSW.aDn();
                return;
            } else if (this.mDataList.size() > 0) {
                if (this.dSW != null) {
                    this.dSW.onError(1, str);
                    return;
                }
                return;
            } else if (this.dSW != null) {
                this.dSW.onError(2, str);
                return;
            } else {
                return;
            }
        }
        if (this.dSW != null) {
            this.dSW.A(z, false);
        }
        aoV();
    }

    public void gH(boolean z) {
        if (z) {
            this.dTb.notifyDataSetChanged();
        }
    }

    private void tw() {
        if (this.dSW != null) {
            this.dSW.aDm();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(DataRes dataRes) {
        this.dTa = true;
        if (dataRes != null) {
            if (a(false, true, dataRes)) {
                if (this.dSW != null) {
                    this.dSW.A(false, true);
                    return;
                }
                return;
            }
            tw();
            return;
        }
        tw();
    }

    private List<h> a(boolean z, DataRes.Builder builder, boolean z2) {
        if (this.dSZ == null) {
            this.dSZ = new DataRes.Builder();
        }
        if (builder == null) {
            builder = new DataRes.Builder();
        }
        c a2 = this.dTc.a(z, this.dSZ, builder, z2 ? 0 : 1);
        if (a2 == null) {
            return null;
        }
        return a2.bhF;
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
                    com.baidu.tieba.homepage.concern.b.b bVar = this.dRq.get(userList.id.longValue());
                    if (bVar != null) {
                        arrayList.add(bVar);
                        i++;
                    }
                }
            }
        }
        this.dRq.clear();
        return arrayList;
    }

    private void bO(List<UserList> list) {
        if (this.dRq == null) {
            this.dRq = new LongSparseArray<>();
        }
        for (UserList userList : list) {
            com.baidu.tieba.homepage.concern.b.b a2 = a(userList);
            switch (this.dTd) {
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
                this.dRq.put(userList.id.longValue(), a2);
            }
        }
    }

    private com.baidu.tieba.homepage.concern.b.b a(UserList userList) {
        com.baidu.tieba.homepage.concern.b.b bVar = new com.baidu.tieba.homepage.concern.b.b();
        bVar.dTI = new com.baidu.tieba.homepage.concern.b.c();
        bVar.dTI.b(userList);
        bVar.dbA = new bb();
        bVar.dbA.a(userList.thread_info);
        bVar.aDr();
        if (bVar.dbA.isLinkThread()) {
            bVar.isLinkThread = true;
        }
        if (StringUtils.isNull(bVar.dTI.getName()) || bVar.dTI.getId() == 0 || StringUtils.isNull(bVar.dbA.getTid()) || StringUtils.isNull(bVar.dbA.getId())) {
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
            this.dSX = null;
            this.dSY = null;
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
        if (dataRes.top_user_info != null && aDp()) {
            if (!ap.isEmpty(builder.top_tips)) {
                com.baidu.tieba.homepage.concern.b.a aVar = new com.baidu.tieba.homepage.concern.b.a();
                aVar.atr = builder.top_tips;
                this.dSX = aVar;
                this.mDataList.add(aVar);
            }
            com.baidu.tieba.homepage.concern.b.b a2 = a(dataRes.top_user_info);
            a2.my(1);
            this.dSY = a2;
            this.mDataList.add(a2);
        }
        if (dataRes.top_user_info == null && !z2 && this.dSY != null && aDp() && this.dSX != null) {
            this.mDataList.add(this.dSX);
            this.mDataList.add(this.dSY);
        }
        List<h> a3 = a(z, builder, z2);
        if (a3 != null && TbadkCoreApplication.isLogin()) {
            this.mDataList.addAll(a3);
        }
        if (!ap.isEmpty(builder.user_tips)) {
            com.baidu.tieba.homepage.concern.b.a aVar2 = new com.baidu.tieba.homepage.concern.b.a();
            this.dTd = builder.user_tips_type.intValue();
            aVar2.dTD = builder.user_tips_type.intValue();
            aVar2.atr = builder.user_tips;
            aVar2.dTF = true;
            this.mDataList.add(aVar2);
        }
        List<h> a4 = a(builder);
        if (a4 != null) {
            this.mDataList.addAll(a4);
        }
        if (!ap.isEmpty(builder.last_tips)) {
            com.baidu.tieba.homepage.concern.b.a aVar3 = new com.baidu.tieba.homepage.concern.b.a();
            aVar3.atr = builder.last_tips;
            aVar3.dTE = true;
            this.mDataList.add(aVar3);
        }
        this.hasMore = builder.has_more.intValue() == 1;
        if (w.z(this.mDataList)) {
            return false;
        }
        if (z2) {
            this.dSZ.page_tag = dataRes.page_tag;
            this.dSZ.has_more = dataRes.has_more;
            this.dSZ.user_list = dataRes.user_list;
            this.dSZ.user_tips_type = dataRes.user_tips_type;
            this.dSZ.user_tips = dataRes.user_tips;
            this.dSZ.last_tips = dataRes.last_tips;
        }
        this.dSZ.banner_user_story = dataRes.banner_user_story;
        this.dSZ.banner_follow_live = dataRes.banner_follow_live;
        this.dSZ.top_tips = dataRes.top_tips;
        this.dSZ.top_user_info = dataRes.top_user_info;
        if (this.dTd == 2 || this.dTd == 3) {
            this.dSZ.user_tips_type = dataRes.user_tips_type;
            this.dSZ.user_tips = dataRes.user_tips;
        }
        this.dTb.ai(this.mDataList);
        return true;
    }

    private boolean aDp() {
        if (TbadkCoreApplication.isLogin()) {
            if (System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.getInstance().getLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("concern_top_user_user_like_time"), 0L) > 86400000) {
                return true;
            }
        }
        return false;
    }

    private void tx() {
        com.baidu.tbadk.util.v.a(new u<DataRes>() { // from class: com.baidu.tieba.homepage.concern.b.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.u
            /* renamed from: aDq */
            public DataRes doInBackground() {
                l<byte[]> P = com.baidu.tbadk.core.c.a.xb().P("tb.concern_page", TbadkCoreApplication.getCurrentAccount());
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
        if (this.dSZ != null) {
            DataRes.Builder builder = new DataRes.Builder(this.dSZ.build(true));
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
                    com.baidu.tbadk.core.c.a.xb().P("tb.concern_page", TbadkCoreApplication.getCurrentAccount()).e("0", builder2.build(true).toByteArray());
                    return null;
                } catch (Exception e) {
                    BdLog.e(e);
                    return null;
                }
            }
        }, null);
    }

    public void a(a aVar) {
        this.dSW = aVar;
    }

    private boolean AE() {
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
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.dSZ != null && w.y(this.dSZ.thread_info) != 0 && w.y(this.mDataList) != 0) {
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
                        if (cVar.Td() != null && cVar.Td().getTid() != null && cVar.Td().getTid().equals(optString)) {
                            this.mDataList.remove(i);
                            if (this.dTb != null) {
                                this.dTb.ai(this.mDataList);
                            }
                        }
                    }
                    i++;
                }
                long c = com.baidu.adp.lib.g.b.c(optString, 0L);
                for (int i2 = 0; i2 < this.dSZ.thread_info.size(); i2++) {
                    ConcernData concernData = this.dSZ.thread_info.get(i2);
                    if (concernData != null && (threadInfo = concernData.thread_list) != null && threadInfo.tid != null && threadInfo.tid.longValue() == c) {
                        this.dSZ.thread_info.remove(i2);
                        aoV();
                        return;
                    }
                }
            }
        }
    }
}
