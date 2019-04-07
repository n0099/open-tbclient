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
    private View.OnTouchListener cft;
    private w ctI;
    private LongSparseArray<com.baidu.tieba.homepage.concern.b.b> fEu;
    private com.baidu.tieba.homepage.concern.b.a fGb;
    private com.baidu.tieba.homepage.concern.b.b fGc;
    private DataRes.Builder fGd;
    private final com.baidu.tieba.homepage.concern.a fGf;
    private final com.baidu.tieba.homepage.concern.c.a fGg;
    private int fGh;
    private com.baidu.tieba.f.a fvC;
    private boolean hasMore;
    private final BdTypeListView mListView;
    private String pageTag;
    private a fGa = null;
    private final List<m> mDataList = new LinkedList();
    private boolean mIsLoading = false;
    private boolean fGe = false;
    private boolean mIsBackground = false;
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.homepage.concern.b.1
        private int fGj = 0;

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (b.this.ctI != null && !b.this.mIsBackground) {
                b.this.ctI.h(absListView, i);
            }
            if (i == 0) {
                t.aQD().aAl();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (b.this.ctI != null && !b.this.mIsBackground) {
                b.this.ctI.onScroll(this.fGj, i);
            }
            this.fGj = i;
        }
    };
    private View.OnTouchListener ccW = new View.OnTouchListener() { // from class: com.baidu.tieba.homepage.concern.b.2
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (b.this.cft != null) {
                b.this.cft.onTouch(view, motionEvent);
            }
            if (b.this.fvC != null) {
                b.this.fvC.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private a.InterfaceC0284a dLJ = new a.InterfaceC0284a() { // from class: com.baidu.tieba.homepage.concern.b.3
        @Override // com.baidu.tieba.f.a.InterfaceC0284a
        public void aR(int i, int i2) {
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0284a
        public void aS(int i, int i2) {
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0284a
        public void aT(int i, int i2) {
        }
    };
    private CustomMessageListener fGi = new CustomMessageListener(2016488) { // from class: com.baidu.tieba.homepage.concern.b.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.this.h(customResponsedMessage);
        }
    };
    private CustomMessageListener fru = new CustomMessageListener(2016553) { // from class: com.baidu.tieba.homepage.concern.b.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.this.h(customResponsedMessage);
        }
    };

    /* loaded from: classes4.dex */
    public interface a {
        void K(boolean z, boolean z2);

        void blr();

        void vZ(String str);
    }

    public void setTabInForeBackgroundState(boolean z) {
        this.mIsBackground = z;
    }

    public void ji(boolean z) {
        this.mIsBackground = z;
    }

    public b(e<?> eVar, BdTypeListView bdTypeListView, com.baidu.tieba.homepage.concern.a aVar) {
        this.mListView = bdTypeListView;
        this.mListView.setOnTouchListener(this.ccW);
        this.fvC = new com.baidu.tieba.f.a();
        this.fGg = new com.baidu.tieba.homepage.concern.c.a();
        this.fvC.a(this.dLJ);
        this.fGf = aVar;
        bdTypeListView.setOnScrollListener(this.mOnScrollListener);
    }

    public void m(BdUniqueId bdUniqueId) {
        this.fGi.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.fGi);
        this.fru.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.fru);
    }

    public void setRecommendFrsNavigationAnimDispatcher(x xVar) {
        if (xVar != null) {
            this.ctI = xVar.aqi();
            this.cft = xVar.aqj();
        }
    }

    public void update() {
        if (this.mDataList.size() == 0 && !this.fGe) {
            WL();
        } else {
            WK();
        }
    }

    public void aAZ() {
        if (!qz() && this.hasMore && this.fGa != null) {
            setIsLoading(true);
            this.fGa.vZ(this.pageTag);
        }
    }

    public void kg(boolean z) {
        if (z) {
            this.fGf.notifyDataSetChanged();
        }
    }

    private void WK() {
        if (this.fGa != null) {
            this.fGa.blr();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(DataRes dataRes) {
        this.fGe = true;
        if (dataRes != null) {
            if (a(false, true, dataRes)) {
                if (this.fGa != null) {
                    this.fGa.K(false, true);
                    return;
                }
                return;
            }
            WK();
            return;
        }
        WK();
    }

    private List<m> a(boolean z, DataRes.Builder builder, boolean z2) {
        if (this.fGd == null) {
            this.fGd = new DataRes.Builder();
        }
        if (builder == null) {
            builder = new DataRes.Builder();
        }
        c a2 = this.fGg.a(z, this.fGd, builder, z2 ? 0 : 1);
        if (a2 == null) {
            return null;
        }
        return a2.cHL;
    }

    private List<m> a(DataRes.Builder builder) {
        if (builder == null || v.T(builder.user_list)) {
            return null;
        }
        cq(builder.user_list);
        ArrayList arrayList = new ArrayList();
        if (!v.T(builder.user_list)) {
            int i = 0;
            for (UserList userList : builder.user_list) {
                if (userList != null) {
                    if (i == 30) {
                        break;
                    }
                    com.baidu.tieba.homepage.concern.b.b bVar = this.fEu.get(userList.id.longValue());
                    if (bVar != null) {
                        arrayList.add(bVar);
                        i++;
                    }
                }
            }
        }
        this.fEu.clear();
        return arrayList;
    }

    private void cq(List<UserList> list) {
        if (this.fEu == null) {
            this.fEu = new LongSparseArray<>();
        }
        for (UserList userList : list) {
            com.baidu.tieba.homepage.concern.b.b a2 = a(userList);
            switch (this.fGh) {
                case 2:
                    a2.sf(2);
                    break;
                case 3:
                    a2.sf(3);
                    break;
                case 4:
                    a2.sf(4);
                    break;
            }
            if (a2 != null) {
                this.fEu.put(userList.id.longValue(), a2);
            }
        }
    }

    private com.baidu.tieba.homepage.concern.b.b a(UserList userList) {
        com.baidu.tieba.homepage.concern.b.b bVar = new com.baidu.tieba.homepage.concern.b.b();
        bVar.fGO = new com.baidu.tieba.homepage.concern.b.c();
        bVar.fGO.b(userList);
        bVar.eNy = new bg();
        bVar.eNy.a(userList.thread_info);
        bVar.blu();
        if (bVar.eNy.isLinkThread()) {
            bVar.isLinkThread = true;
        }
        if (StringUtils.isNull(bVar.fGO.getName()) || bVar.fGO.getId() == 0 || StringUtils.isNull(bVar.eNy.getTid()) || StringUtils.isNull(bVar.eNy.getId())) {
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
            this.fGb = null;
            this.fGc = null;
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
        if (dataRes.top_user_info != null && bls()) {
            if (!ap.isEmpty(builder.top_tips)) {
                com.baidu.tieba.homepage.concern.b.a aVar = new com.baidu.tieba.homepage.concern.b.a();
                aVar.bOu = builder.top_tips;
                this.fGb = aVar;
                this.mDataList.add(aVar);
            }
            com.baidu.tieba.homepage.concern.b.b a2 = a(dataRes.top_user_info);
            a2.sf(1);
            this.fGc = a2;
            this.mDataList.add(a2);
        }
        if (dataRes.top_user_info == null && !z2 && this.fGc != null && bls() && this.fGb != null) {
            this.mDataList.add(this.fGb);
            this.mDataList.add(this.fGc);
        }
        List<m> a3 = a(z, builder, z2);
        if (a3 != null && TbadkCoreApplication.isLogin()) {
            this.mDataList.addAll(a3);
        }
        if (!ap.isEmpty(builder.user_tips)) {
            com.baidu.tieba.homepage.concern.b.a aVar2 = new com.baidu.tieba.homepage.concern.b.a();
            this.fGh = builder.user_tips_type.intValue();
            aVar2.fGJ = builder.user_tips_type.intValue();
            aVar2.bOu = builder.user_tips;
            aVar2.fGL = true;
            this.mDataList.add(aVar2);
        }
        List<m> a4 = a(builder);
        if (a4 != null) {
            this.mDataList.addAll(a4);
        }
        if (!ap.isEmpty(builder.last_tips)) {
            com.baidu.tieba.homepage.concern.b.a aVar3 = new com.baidu.tieba.homepage.concern.b.a();
            aVar3.bOu = builder.last_tips;
            aVar3.fGK = true;
            this.mDataList.add(aVar3);
        }
        this.hasMore = builder.has_more.intValue() == 1;
        if (v.T(this.mDataList)) {
            return false;
        }
        if (z2) {
            this.fGd.page_tag = dataRes.page_tag;
            this.fGd.has_more = dataRes.has_more;
            this.fGd.user_list = dataRes.user_list;
            this.fGd.user_tips_type = dataRes.user_tips_type;
            this.fGd.user_tips = dataRes.user_tips;
            this.fGd.last_tips = dataRes.last_tips;
        }
        this.fGd.banner_user_story = dataRes.banner_user_story;
        this.fGd.banner_follow_live = dataRes.banner_follow_live;
        this.fGd.top_tips = dataRes.top_tips;
        this.fGd.top_user_info = dataRes.top_user_info;
        if (this.fGh == 2 || this.fGh == 3) {
            this.fGd.user_tips_type = dataRes.user_tips_type;
            this.fGd.user_tips = dataRes.user_tips;
        }
        this.fGf.ay(this.mDataList);
        return true;
    }

    private boolean bls() {
        if (TbadkCoreApplication.isLogin()) {
            if (System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.getInstance().getLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("concern_top_user_user_like_time"), 0L) > 86400000) {
                return true;
            }
        }
        return false;
    }

    private void WL() {
        aa.a(new z<DataRes>() { // from class: com.baidu.tieba.homepage.concern.b.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.z
            /* renamed from: blt */
            public DataRes doInBackground() {
                l<byte[]> bu = com.baidu.tbadk.core.c.a.aaT().bu("tb.concern_page", TbadkCoreApplication.getCurrentAccount());
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

    private void aWM() {
        if (this.fGd != null) {
            DataRes.Builder builder = new DataRes.Builder(this.fGd.build(true));
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
                    com.baidu.tbadk.core.c.a.aaT().bu("tb.concern_page", TbadkCoreApplication.getCurrentAccount()).e("0", builder2.build(true).toByteArray());
                    return null;
                } catch (Exception e) {
                    BdLog.e(e);
                    return null;
                }
            }
        }, null);
    }

    public void a(a aVar) {
        this.fGa = aVar;
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
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.fGd != null && v.S(this.fGd.thread_info) != 0 && v.S(this.mDataList) != 0) {
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
                        if (cVar.WO() != null && cVar.WO().getTid() != null && cVar.WO().getTid().equals(optString)) {
                            this.mDataList.remove(i);
                            if (this.fGf != null) {
                                this.fGf.ay(this.mDataList);
                            }
                        }
                    }
                    i++;
                }
                long d = com.baidu.adp.lib.g.b.d(optString, 0L);
                for (int i2 = 0; i2 < this.fGd.thread_info.size(); i2++) {
                    ConcernData concernData = this.fGd.thread_info.get(i2);
                    if (concernData != null && (threadInfo = concernData.thread_list) != null && threadInfo.tid != null && threadInfo.tid.longValue() == d) {
                        this.fGd.thread_info.remove(i2);
                        aWM();
                        return;
                    }
                }
            }
        }
    }
}
