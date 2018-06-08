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
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.ao;
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
    private View.OnTouchListener aIi;
    private s aVH;
    private com.baidu.tieba.f.a dAM;
    private LongSparseArray<com.baidu.tieba.homepage.concern.b.b> dLm;
    private DataRes.Builder dMU;
    private final com.baidu.tieba.homepage.concern.a dMW;
    private final com.baidu.tieba.homepage.concern.c.a dMX;
    private int dMY;
    private boolean hasMore;
    private final BdTypeListView mListView;
    private String pageTag;
    private a dMT = null;
    private final List<h> mDataList = new LinkedList();
    private boolean mIsLoading = false;
    private boolean dMV = false;
    private boolean mIsBackground = false;
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.homepage.concern.b.1
        private int dNa = 0;

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (b.this.aVH != null && !b.this.mIsBackground) {
                b.this.aVH.onScrollStateChanged(absListView, i);
            }
            if (i == 0) {
                v.ajh().RT();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (b.this.aVH != null && !b.this.mIsBackground) {
                b.this.aVH.a(absListView, this.dNa, i, i2, i3);
            }
            this.dNa = i;
        }
    };
    private View.OnTouchListener aVI = new View.OnTouchListener() { // from class: com.baidu.tieba.homepage.concern.b.2
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (b.this.aIi != null) {
                b.this.aIi.onTouch(view, motionEvent);
            }
            if (b.this.dAM != null) {
                b.this.dAM.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private a.InterfaceC0146a bHv = new a.InterfaceC0146a() { // from class: com.baidu.tieba.homepage.concern.b.3
        @Override // com.baidu.tieba.f.a.InterfaceC0146a
        public void X(int i, int i2) {
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0146a
        public void Y(int i, int i2) {
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0146a
        public void Z(int i, int i2) {
        }
    };
    private CustomMessageListener dMZ = new CustomMessageListener(2016488) { // from class: com.baidu.tieba.homepage.concern.b.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.this.h(customResponsedMessage);
        }
    };
    private CustomMessageListener dyj = new CustomMessageListener(2016553) { // from class: com.baidu.tieba.homepage.concern.b.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.this.h(customResponsedMessage);
        }
    };

    /* loaded from: classes2.dex */
    public interface a {
        void aBY();

        void aBZ();

        void ns(String str);

        void onError(int i, String str);

        void x(boolean z, boolean z2);
    }

    public void setTabInForeBackgroundState(boolean z) {
        this.mIsBackground = z;
    }

    public void fD(boolean z) {
        this.mIsBackground = z;
    }

    public b(e<?> eVar, BdTypeListView bdTypeListView, com.baidu.tieba.homepage.concern.a aVar) {
        this.mListView = bdTypeListView;
        this.mListView.setOnTouchListener(this.aVI);
        this.dAM = new com.baidu.tieba.f.a();
        this.dMX = new com.baidu.tieba.homepage.concern.c.a();
        this.dAM.a(this.bHv);
        this.dMW = aVar;
        bdTypeListView.setOnScrollListener(this.mOnScrollListener);
    }

    public void l(BdUniqueId bdUniqueId) {
        this.dMZ.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.dMZ);
        this.dyj.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.dyj);
    }

    public void setRecommendFrsNavigationAnimDispatcher(t tVar) {
        if (tVar != null) {
            this.aVH = tVar.Lh();
            this.aIi = tVar.Li();
        }
    }

    public void update() {
        if (this.mDataList.size() == 0 && !this.dMV) {
            aCd();
        } else {
            aCb();
        }
    }

    public void aCa() {
        aCb();
    }

    public void SJ() {
        if (!Ax() && this.hasMore && this.dMT != null) {
            setIsLoading(true);
            this.dMT.ns(this.pageTag);
        }
    }

    public void a(boolean z, DataRes dataRes, int i, String str) {
        setIsLoading(false);
        this.mListView.completePullRefreshPostDelayed(2000L);
        if (i != 0 || dataRes == null || !a(true, z, dataRes)) {
            if (i == 0 && w.y(this.mDataList) == 0 && this.dMT != null) {
                this.dMT.aBZ();
                return;
            } else if (this.mDataList.size() > 0) {
                if (this.dMT != null) {
                    this.dMT.onError(1, str);
                    return;
                }
                return;
            } else if (this.dMT != null) {
                this.dMT.onError(2, str);
                return;
            } else {
                return;
            }
        }
        if (this.dMT != null) {
            this.dMT.x(z, false);
        }
        apa();
    }

    public void gv(boolean z) {
        if (z) {
            this.dMW.notifyDataSetChanged();
        }
    }

    private void aCb() {
        if (this.dMT != null) {
            this.dMT.aBY();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(DataRes dataRes) {
        this.dMV = true;
        if (dataRes != null) {
            if (a(false, true, dataRes)) {
                if (this.dMT != null) {
                    this.dMT.x(false, true);
                    return;
                }
                return;
            }
            aCb();
            return;
        }
        aCb();
    }

    private List<h> a(boolean z, DataRes.Builder builder, boolean z2) {
        if (this.dMU == null) {
            this.dMU = new DataRes.Builder();
        }
        if (builder == null) {
            builder = new DataRes.Builder();
        }
        c a2 = this.dMX.a(z, this.dMU, builder, z2 ? 0 : 1);
        if (a2 == null) {
            return null;
        }
        return a2.bfM;
    }

    private List<h> a(DataRes.Builder builder) {
        if (builder == null || w.z(builder.user_list)) {
            return null;
        }
        bL(builder.user_list);
        ArrayList arrayList = new ArrayList();
        if (!w.z(builder.user_list)) {
            int i = 0;
            for (UserList userList : builder.user_list) {
                if (userList != null) {
                    if (i == 30) {
                        break;
                    }
                    com.baidu.tieba.homepage.concern.b.b bVar = this.dLm.get(userList.id.longValue());
                    if (bVar != null) {
                        arrayList.add(bVar);
                        i++;
                    }
                }
            }
        }
        this.dLm.clear();
        return arrayList;
    }

    private void bL(List<UserList> list) {
        if (this.dLm == null) {
            this.dLm = new LongSparseArray<>();
        }
        for (UserList userList : list) {
            com.baidu.tieba.homepage.concern.b.b a2 = a(userList);
            switch (this.dMY) {
                case 2:
                    a2.mf(2);
                    break;
                case 3:
                    a2.mf(3);
                    break;
                case 4:
                    a2.mf(4);
                    break;
            }
            if (a2 != null) {
                this.dLm.put(userList.id.longValue(), a2);
            }
        }
    }

    private com.baidu.tieba.homepage.concern.b.b a(UserList userList) {
        com.baidu.tieba.homepage.concern.b.b bVar = new com.baidu.tieba.homepage.concern.b.b();
        bVar.dND = new com.baidu.tieba.homepage.concern.b.c();
        bVar.dND.b(userList);
        bVar.daI = new bd();
        bVar.daI.a(userList.thread_info);
        bVar.aCf();
        if (bVar.daI.isLinkThread()) {
            bVar.isLinkThread = true;
        }
        if (StringUtils.isNull(bVar.dND.getName()) || bVar.dND.getId() == 0 || StringUtils.isNull(bVar.daI.getTid()) || StringUtils.isNull(bVar.daI.getId())) {
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
        if (dataRes.top_user_info != null && aCc()) {
            if (!ao.isEmpty(builder.top_tips)) {
                com.baidu.tieba.homepage.concern.b.a aVar = new com.baidu.tieba.homepage.concern.b.a();
                aVar.atk = builder.top_tips;
                this.mDataList.add(aVar);
            }
            com.baidu.tieba.homepage.concern.b.b a2 = a(dataRes.top_user_info);
            a2.mf(1);
            this.mDataList.add(a2);
        }
        List<h> a3 = a(z, builder, z2);
        if (a3 != null && TbadkCoreApplication.isLogin()) {
            this.mDataList.addAll(a3);
        }
        if (!ao.isEmpty(builder.user_tips)) {
            com.baidu.tieba.homepage.concern.b.a aVar2 = new com.baidu.tieba.homepage.concern.b.a();
            this.dMY = builder.user_tips_type.intValue();
            aVar2.dNy = builder.user_tips_type.intValue();
            aVar2.atk = builder.user_tips;
            aVar2.dNA = true;
            this.mDataList.add(aVar2);
        }
        List<h> a4 = a(builder);
        if (a4 != null) {
            this.mDataList.addAll(a4);
        }
        if (!ao.isEmpty(builder.last_tips)) {
            com.baidu.tieba.homepage.concern.b.a aVar3 = new com.baidu.tieba.homepage.concern.b.a();
            aVar3.atk = builder.last_tips;
            aVar3.dNz = true;
            this.mDataList.add(aVar3);
        }
        this.hasMore = builder.has_more.intValue() == 1;
        if (w.z(this.mDataList)) {
            return false;
        }
        if (z2) {
            this.dMU.page_tag = dataRes.page_tag;
            this.dMU.has_more = dataRes.has_more;
            this.dMU.user_list = dataRes.user_list;
            this.dMU.user_tips_type = dataRes.user_tips_type;
            this.dMU.user_tips = dataRes.user_tips;
            this.dMU.last_tips = dataRes.last_tips;
        }
        this.dMU.banner_user_story = dataRes.banner_user_story;
        this.dMU.banner_follow_live = dataRes.banner_follow_live;
        this.dMU.top_tips = dataRes.top_tips;
        this.dMU.top_user_info = dataRes.top_user_info;
        if (this.dMY == 2 || this.dMY == 3) {
            this.dMU.user_tips_type = dataRes.user_tips_type;
            this.dMU.user_tips = dataRes.user_tips;
        }
        this.dMW.ai(this.mDataList);
        return true;
    }

    private boolean aCc() {
        if (TbadkCoreApplication.isLogin()) {
            if (System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.getInstance().getLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("concern_top_user_user_like_time"), 0L) > 86400000) {
                return true;
            }
        }
        return false;
    }

    private void aCd() {
        com.baidu.tbadk.util.w.a(new com.baidu.tbadk.util.v<DataRes>() { // from class: com.baidu.tieba.homepage.concern.b.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.v
            /* renamed from: aCe */
            public DataRes doInBackground() {
                l<byte[]> Q = com.baidu.tbadk.core.c.a.wW().Q("tb.concern_page", TbadkCoreApplication.getCurrentAccount());
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

    private void apa() {
        if (this.dMU != null) {
            DataRes.Builder builder = new DataRes.Builder(this.dMU.build(true));
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
                    com.baidu.tbadk.core.c.a.wW().Q("tb.concern_page", TbadkCoreApplication.getCurrentAccount()).e("0", builder2.build(true).toByteArray());
                    return null;
                } catch (Exception e) {
                    BdLog.e(e);
                    return null;
                }
            }
        }, null);
    }

    public void a(a aVar) {
        this.dMT = aVar;
    }

    private boolean Ax() {
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
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.dMU != null && w.y(this.dMU.thread_info) != 0 && w.y(this.mDataList) != 0) {
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
                        if (cVar.Sz() != null && cVar.Sz().getTid() != null && cVar.Sz().getTid().equals(optString)) {
                            this.mDataList.remove(i);
                            if (this.dMW != null) {
                                this.dMW.ai(this.mDataList);
                            }
                        }
                    }
                    i++;
                }
                long c = com.baidu.adp.lib.g.b.c(optString, 0L);
                for (int i2 = 0; i2 < this.dMU.thread_info.size(); i2++) {
                    ConcernData concernData = this.dMU.thread_info.get(i2);
                    if (concernData != null && (threadInfo = concernData.thread_list) != null && threadInfo.tid != null && threadInfo.tid.longValue() == c) {
                        this.dMU.thread_info.remove(i2);
                        apa();
                        return;
                    }
                }
            }
        }
    }
}
