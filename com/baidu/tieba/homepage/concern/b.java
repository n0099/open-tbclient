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
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.util.aa;
import com.baidu.tbadk.util.k;
import com.baidu.tbadk.util.w;
import com.baidu.tbadk.util.x;
import com.baidu.tbadk.util.z;
import com.baidu.tieba.card.t;
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
/* loaded from: classes4.dex */
public class b {
    private View.OnTouchListener cfr;
    private w ctJ;
    private LongSparseArray<com.baidu.tieba.homepage.concern.b.b> fEH;
    private com.baidu.tieba.homepage.concern.b.a fGo;
    private com.baidu.tieba.homepage.concern.b.b fGp;
    private DataRes.Builder fGq;
    private final com.baidu.tieba.homepage.concern.a fGs;
    private final com.baidu.tieba.homepage.concern.c.a fGt;
    private int fGu;
    private com.baidu.tieba.f.a fvR;
    private boolean hasMore;
    private final BdTypeListView mListView;
    private String pageTag;
    private a fGn = null;
    private final List<m> mDataList = new LinkedList();
    private boolean mIsLoading = false;
    private boolean fGr = false;
    private boolean mIsBackground = false;
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.homepage.concern.b.1
        private int fGw = 0;

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (b.this.ctJ != null && !b.this.mIsBackground) {
                b.this.ctJ.h(absListView, i);
            }
            if (i == 0) {
                t.aQF().aAo();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (b.this.ctJ != null && !b.this.mIsBackground) {
                b.this.ctJ.onScroll(this.fGw, i);
            }
            this.fGw = i;
        }
    };
    private View.OnTouchListener ccU = new View.OnTouchListener() { // from class: com.baidu.tieba.homepage.concern.b.2
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (b.this.cfr != null) {
                b.this.cfr.onTouch(view, motionEvent);
            }
            if (b.this.fvR != null) {
                b.this.fvR.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private a.InterfaceC0243a dMw = new a.InterfaceC0243a() { // from class: com.baidu.tieba.homepage.concern.b.3
        @Override // com.baidu.tieba.f.a.InterfaceC0243a
        public void aR(int i, int i2) {
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0243a
        public void aS(int i, int i2) {
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0243a
        public void aT(int i, int i2) {
        }
    };
    private CustomMessageListener fGv = new CustomMessageListener(2016488) { // from class: com.baidu.tieba.homepage.concern.b.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.this.h(customResponsedMessage);
        }
    };
    private CustomMessageListener frJ = new CustomMessageListener(2016553) { // from class: com.baidu.tieba.homepage.concern.b.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.this.h(customResponsedMessage);
        }
    };

    /* loaded from: classes4.dex */
    public interface a {
        void M(boolean z, boolean z2);

        void blu();

        void wb(String str);
    }

    public void setTabInForeBackgroundState(boolean z) {
        this.mIsBackground = z;
    }

    public void ji(boolean z) {
        this.mIsBackground = z;
    }

    public b(e<?> eVar, BdTypeListView bdTypeListView, com.baidu.tieba.homepage.concern.a aVar) {
        this.mListView = bdTypeListView;
        this.mListView.setOnTouchListener(this.ccU);
        this.fvR = new com.baidu.tieba.f.a();
        this.fGt = new com.baidu.tieba.homepage.concern.c.a();
        this.fvR.a(this.dMw);
        this.fGs = aVar;
        bdTypeListView.setOnScrollListener(this.mOnScrollListener);
    }

    public void m(BdUniqueId bdUniqueId) {
        this.fGv.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.fGv);
        this.frJ.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.frJ);
    }

    public void setRecommendFrsNavigationAnimDispatcher(x xVar) {
        if (xVar != null) {
            this.ctJ = xVar.aql();
            this.cfr = xVar.aqm();
        }
    }

    public void update() {
        if (this.mDataList.size() == 0 && !this.fGr) {
            WO();
        } else {
            WN();
        }
    }

    public void aBc() {
        if (!qz() && this.hasMore && this.fGn != null) {
            setIsLoading(true);
            this.fGn.wb(this.pageTag);
        }
    }

    public void kg(boolean z) {
        if (z) {
            this.fGs.notifyDataSetChanged();
        }
    }

    private void WN() {
        if (this.fGn != null) {
            this.fGn.blu();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(DataRes dataRes) {
        this.fGr = true;
        if (dataRes != null) {
            if (a(false, true, dataRes)) {
                if (this.fGn != null) {
                    this.fGn.M(false, true);
                    return;
                }
                return;
            }
            WN();
            return;
        }
        WN();
    }

    private List<m> a(boolean z, DataRes.Builder builder, boolean z2) {
        if (this.fGq == null) {
            this.fGq = new DataRes.Builder();
        }
        if (builder == null) {
            builder = new DataRes.Builder();
        }
        c a2 = this.fGt.a(z, this.fGq, builder, z2 ? 0 : 1);
        if (a2 == null) {
            return null;
        }
        return a2.cHM;
    }

    private List<m> a(DataRes.Builder builder) {
        if (builder == null || v.T(builder.user_list)) {
            return null;
        }
        ct(builder.user_list);
        ArrayList arrayList = new ArrayList();
        if (!v.T(builder.user_list)) {
            int i = 0;
            for (UserList userList : builder.user_list) {
                if (userList != null) {
                    if (i == 30) {
                        break;
                    }
                    com.baidu.tieba.homepage.concern.b.b bVar = this.fEH.get(userList.id.longValue());
                    if (bVar != null) {
                        arrayList.add(bVar);
                        i++;
                    }
                }
            }
        }
        this.fEH.clear();
        return arrayList;
    }

    private void ct(List<UserList> list) {
        if (this.fEH == null) {
            this.fEH = new LongSparseArray<>();
        }
        for (UserList userList : list) {
            com.baidu.tieba.homepage.concern.b.b a2 = a(userList);
            switch (this.fGu) {
                case 2:
                    a2.sj(2);
                    break;
                case 3:
                    a2.sj(3);
                    break;
                case 4:
                    a2.sj(4);
                    break;
            }
            if (a2 != null) {
                this.fEH.put(userList.id.longValue(), a2);
            }
        }
    }

    private com.baidu.tieba.homepage.concern.b.b a(UserList userList) {
        com.baidu.tieba.homepage.concern.b.b bVar = new com.baidu.tieba.homepage.concern.b.b();
        bVar.fHb = new com.baidu.tieba.homepage.concern.b.c();
        bVar.fHb.b(userList);
        bVar.eNQ = new bg();
        bVar.eNQ.a(userList.thread_info);
        bVar.blx();
        if (bVar.eNQ.isLinkThread()) {
            bVar.isLinkThread = true;
        }
        if (StringUtils.isNull(bVar.fHb.getName()) || bVar.fHb.getId() == 0 || StringUtils.isNull(bVar.eNQ.getTid()) || StringUtils.isNull(bVar.eNQ.getId())) {
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
            this.fGo = null;
            this.fGp = null;
        }
        DataRes.Builder builder = new DataRes.Builder(dataRes);
        if (dataRes.banner_follow_live != null && dataRes.banner_follow_live._switch.intValue() == 1 && TbadkCoreApplication.isLogin()) {
            com.baidu.tbadk.data.b bVar = new com.baidu.tbadk.data.b();
            bVar.a(dataRes.banner_follow_live);
            if (!v.T(bVar.getList())) {
                this.mDataList.add(bVar);
            }
        }
        if (dataRes.req_unix != null) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("concern_data_res_request_time"), dataRes.req_unix.longValue());
        }
        if (dataRes.top_user_info != null && blv()) {
            if (!ap.isEmpty(builder.top_tips)) {
                com.baidu.tieba.homepage.concern.b.a aVar = new com.baidu.tieba.homepage.concern.b.a();
                aVar.bOr = builder.top_tips;
                this.fGo = aVar;
                this.mDataList.add(aVar);
            }
            com.baidu.tieba.homepage.concern.b.b a2 = a(dataRes.top_user_info);
            a2.sj(1);
            this.fGp = a2;
            this.mDataList.add(a2);
        }
        if (dataRes.top_user_info == null && !z2 && this.fGp != null && blv() && this.fGo != null) {
            this.mDataList.add(this.fGo);
            this.mDataList.add(this.fGp);
        }
        List<m> a3 = a(z, builder, z2);
        if (a3 != null && TbadkCoreApplication.isLogin()) {
            this.mDataList.addAll(a3);
        }
        if (!ap.isEmpty(builder.user_tips)) {
            com.baidu.tieba.homepage.concern.b.a aVar2 = new com.baidu.tieba.homepage.concern.b.a();
            this.fGu = builder.user_tips_type.intValue();
            aVar2.fGW = builder.user_tips_type.intValue();
            aVar2.bOr = builder.user_tips;
            aVar2.fGY = true;
            this.mDataList.add(aVar2);
        }
        List<m> a4 = a(builder);
        if (a4 != null) {
            this.mDataList.addAll(a4);
        }
        if (!ap.isEmpty(builder.last_tips)) {
            com.baidu.tieba.homepage.concern.b.a aVar3 = new com.baidu.tieba.homepage.concern.b.a();
            aVar3.bOr = builder.last_tips;
            aVar3.fGX = true;
            this.mDataList.add(aVar3);
        }
        this.hasMore = builder.has_more.intValue() == 1;
        if (v.T(this.mDataList)) {
            return false;
        }
        if (z2) {
            this.fGq.page_tag = dataRes.page_tag;
            this.fGq.has_more = dataRes.has_more;
            this.fGq.user_list = dataRes.user_list;
            this.fGq.user_tips_type = dataRes.user_tips_type;
            this.fGq.user_tips = dataRes.user_tips;
            this.fGq.last_tips = dataRes.last_tips;
        }
        this.fGq.banner_user_story = dataRes.banner_user_story;
        this.fGq.banner_follow_live = dataRes.banner_follow_live;
        this.fGq.top_tips = dataRes.top_tips;
        this.fGq.top_user_info = dataRes.top_user_info;
        if (this.fGu == 2 || this.fGu == 3) {
            this.fGq.user_tips_type = dataRes.user_tips_type;
            this.fGq.user_tips = dataRes.user_tips;
        }
        this.fGs.ay(this.mDataList);
        return true;
    }

    private boolean blv() {
        if (TbadkCoreApplication.isLogin()) {
            if (System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.getInstance().getLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("concern_top_user_user_like_time"), 0L) > 86400000) {
                return true;
            }
        }
        return false;
    }

    private void WO() {
        aa.a(new z<DataRes>() { // from class: com.baidu.tieba.homepage.concern.b.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.z
            /* renamed from: blw */
            public DataRes doInBackground() {
                l<byte[]> bu = com.baidu.tbadk.core.c.a.aaW().bu("tb.concern_page", TbadkCoreApplication.getCurrentAccount());
                if (bu == null) {
                    return null;
                }
                byte[] bArr = bu.get("0");
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
        }, new k<DataRes>() { // from class: com.baidu.tieba.homepage.concern.b.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.k
            /* renamed from: b */
            public void onReturnDataInUI(DataRes dataRes) {
                b.this.a(dataRes);
            }
        });
    }

    private void aWO() {
        if (this.fGq != null) {
            DataRes.Builder builder = new DataRes.Builder(this.fGq.build(true));
            if (builder.thread_info != null && builder.thread_info.size() > 30) {
                builder.thread_info = builder.thread_info.subList(0, 30);
            }
            b(builder);
        }
    }

    private void b(final DataRes.Builder builder) {
        aa.a(new z<Object>() { // from class: com.baidu.tieba.homepage.concern.b.6
            @Override // com.baidu.tbadk.util.z
            public Object doInBackground() {
                DataRes.Builder builder2 = new DataRes.Builder(builder.build(true));
                try {
                    com.baidu.tbadk.core.c.a.aaW().bu("tb.concern_page", TbadkCoreApplication.getCurrentAccount()).e("0", builder2.build(true).toByteArray());
                    return null;
                } catch (Exception e) {
                    BdLog.e(e);
                    return null;
                }
            }
        }, null);
    }

    public void a(a aVar) {
        this.fGn = aVar;
    }

    private boolean qz() {
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
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.fGq != null && v.S(this.fGq.thread_info) != 0 && v.S(this.mDataList) != 0) {
            String optString = ((JSONObject) customResponsedMessage.getData()).optString("tid");
            if (!StringUtils.isNull(optString)) {
                int i = 0;
                while (true) {
                    if (i >= this.mDataList.size()) {
                        break;
                    }
                    m mVar = this.mDataList.get(i);
                    if (mVar instanceof com.baidu.tieba.card.data.c) {
                        com.baidu.tieba.card.data.c cVar = (com.baidu.tieba.card.data.c) mVar;
                        if (cVar.WR() != null && cVar.WR().getTid() != null && cVar.WR().getTid().equals(optString)) {
                            this.mDataList.remove(i);
                            if (this.fGs != null) {
                                this.fGs.ay(this.mDataList);
                            }
                        }
                    }
                    i++;
                }
                long d = com.baidu.adp.lib.g.b.d(optString, 0L);
                for (int i2 = 0; i2 < this.fGq.thread_info.size(); i2++) {
                    ConcernData concernData = this.fGq.thread_info.get(i2);
                    if (concernData != null && (threadInfo = concernData.thread_list) != null && threadInfo.tid != null && threadInfo.tid.longValue() == d) {
                        this.fGq.thread_info.remove(i2);
                        aWO();
                        return;
                    }
                }
            }
        }
    }
}
