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
import com.baidu.searchbox.ng.ai.apps.screenshot.SystemScreenshotManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.util.t;
import com.baidu.tbadk.util.u;
import com.baidu.tbadk.util.w;
import com.baidu.tbadk.util.x;
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
/* loaded from: classes6.dex */
public class b {
    private View.OnTouchListener aRb;
    private t bey;
    private com.baidu.tieba.f.a dVH;
    private LongSparseArray<com.baidu.tieba.homepage.concern.b.b> egw;
    private com.baidu.tieba.homepage.concern.b.a eic;
    private com.baidu.tieba.homepage.concern.b.b eid;
    private DataRes.Builder eie;
    private final com.baidu.tieba.homepage.concern.a eig;
    private final com.baidu.tieba.homepage.concern.c.a eih;
    private int eii;
    private boolean hasMore;
    private final BdTypeListView mListView;
    private String pageTag;
    private a eib = null;
    private final List<h> mDataList = new LinkedList();
    private boolean mIsLoading = false;
    private boolean eif = false;
    private boolean mIsBackground = false;
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.homepage.concern.b.1
        private int eik = 0;

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (b.this.bey != null && !b.this.mIsBackground) {
                b.this.bey.g(absListView, i);
            }
            if (i == 0) {
                v.aoo().XX();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (b.this.bey != null && !b.this.mIsBackground) {
                b.this.bey.onScroll(this.eik, i);
            }
            this.eik = i;
        }
    };
    private View.OnTouchListener bez = new View.OnTouchListener() { // from class: com.baidu.tieba.homepage.concern.b.2
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (b.this.aRb != null) {
                b.this.aRb.onTouch(view, motionEvent);
            }
            if (b.this.dVH != null) {
                b.this.dVH.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private a.InterfaceC0179a bYr = new a.InterfaceC0179a() { // from class: com.baidu.tieba.homepage.concern.b.3
        @Override // com.baidu.tieba.f.a.InterfaceC0179a
        public void af(int i, int i2) {
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0179a
        public void ag(int i, int i2) {
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0179a
        public void ah(int i, int i2) {
        }
    };
    private CustomMessageListener eij = new CustomMessageListener(2016488) { // from class: com.baidu.tieba.homepage.concern.b.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.this.h(customResponsedMessage);
        }
    };
    private CustomMessageListener dST = new CustomMessageListener(2016553) { // from class: com.baidu.tieba.homepage.concern.b.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.this.h(customResponsedMessage);
        }
    };

    /* loaded from: classes6.dex */
    public interface a {
        void D(boolean z, boolean z2);

        void aIO();

        void aIP();

        void oC(String str);

        void onError(int i, String str);
    }

    public void setTabInForeBackgroundState(boolean z) {
        this.mIsBackground = z;
    }

    public void gs(boolean z) {
        this.mIsBackground = z;
    }

    public b(e<?> eVar, BdTypeListView bdTypeListView, com.baidu.tieba.homepage.concern.a aVar) {
        this.mListView = bdTypeListView;
        this.mListView.setOnTouchListener(this.bez);
        this.dVH = new com.baidu.tieba.f.a();
        this.eih = new com.baidu.tieba.homepage.concern.c.a();
        this.dVH.a(this.bYr);
        this.eig = aVar;
        bdTypeListView.setOnScrollListener(this.mOnScrollListener);
    }

    public void l(BdUniqueId bdUniqueId) {
        this.eij.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.eij);
        this.dST.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.dST);
    }

    public void setRecommendFrsNavigationAnimDispatcher(u uVar) {
        if (uVar != null) {
            this.bey = uVar.OO();
            this.aRb = uVar.OP();
        }
    }

    public void update() {
        if (this.mDataList.size() == 0 && !this.eif) {
            wI();
        } else {
            wH();
        }
    }

    public void aIQ() {
        wH();
    }

    public void YK() {
        if (!DU() && this.hasMore && this.eib != null) {
            setIsLoading(true);
            this.eib.oC(this.pageTag);
        }
    }

    public void a(boolean z, DataRes dataRes, int i, String str) {
        setIsLoading(false);
        this.mListView.completePullRefreshPostDelayed(SystemScreenshotManager.DELAY_TIME);
        if (i != 0 || dataRes == null || !a(true, z, dataRes)) {
            if (i == 0 && com.baidu.tbadk.core.util.v.I(this.mDataList) == 0 && this.eib != null) {
                this.eib.aIP();
                return;
            } else if (this.mDataList.size() > 0) {
                if (this.eib != null) {
                    this.eib.onError(1, str);
                    return;
                }
                return;
            } else if (this.eib != null) {
                this.eib.onError(2, str);
                return;
            } else {
                return;
            }
        }
        if (this.eib != null) {
            this.eib.D(z, false);
        }
        aug();
    }

    public void hx(boolean z) {
        if (z) {
            this.eig.notifyDataSetChanged();
        }
    }

    private void wH() {
        if (this.eib != null) {
            this.eib.aIO();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(DataRes dataRes) {
        this.eif = true;
        if (dataRes != null) {
            if (a(false, true, dataRes)) {
                if (this.eib != null) {
                    this.eib.D(false, true);
                    return;
                }
                return;
            }
            wH();
            return;
        }
        wH();
    }

    private List<h> a(boolean z, DataRes.Builder builder, boolean z2) {
        if (this.eie == null) {
            this.eie = new DataRes.Builder();
        }
        if (builder == null) {
            builder = new DataRes.Builder();
        }
        c a2 = this.eih.a(z, this.eie, builder, z2 ? 0 : 1);
        if (a2 == null) {
            return null;
        }
        return a2.brA;
    }

    private List<h> a(DataRes.Builder builder) {
        if (builder == null || com.baidu.tbadk.core.util.v.J(builder.user_list)) {
            return null;
        }
        cf(builder.user_list);
        ArrayList arrayList = new ArrayList();
        if (!com.baidu.tbadk.core.util.v.J(builder.user_list)) {
            int i = 0;
            for (UserList userList : builder.user_list) {
                if (userList != null) {
                    if (i == 30) {
                        break;
                    }
                    com.baidu.tieba.homepage.concern.b.b bVar = this.egw.get(userList.id.longValue());
                    if (bVar != null) {
                        arrayList.add(bVar);
                        i++;
                    }
                }
            }
        }
        this.egw.clear();
        return arrayList;
    }

    private void cf(List<UserList> list) {
        if (this.egw == null) {
            this.egw = new LongSparseArray<>();
        }
        for (UserList userList : list) {
            com.baidu.tieba.homepage.concern.b.b a2 = a(userList);
            switch (this.eii) {
                case 2:
                    a2.nA(2);
                    break;
                case 3:
                    a2.nA(3);
                    break;
                case 4:
                    a2.nA(4);
                    break;
            }
            if (a2 != null) {
                this.egw.put(userList.id.longValue(), a2);
            }
        }
    }

    private com.baidu.tieba.homepage.concern.b.b a(UserList userList) {
        com.baidu.tieba.homepage.concern.b.b bVar = new com.baidu.tieba.homepage.concern.b.b();
        bVar.eiP = new com.baidu.tieba.homepage.concern.b.c();
        bVar.eiP.b(userList);
        bVar.dpv = new bb();
        bVar.dpv.a(userList.thread_info);
        bVar.aIT();
        if (bVar.dpv.isLinkThread()) {
            bVar.isLinkThread = true;
        }
        if (StringUtils.isNull(bVar.eiP.getName()) || bVar.eiP.getId() == 0 || StringUtils.isNull(bVar.dpv.getTid()) || StringUtils.isNull(bVar.dpv.getId())) {
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
            this.eic = null;
            this.eid = null;
        }
        DataRes.Builder builder = new DataRes.Builder(dataRes);
        if (dataRes.banner_follow_live != null && dataRes.banner_follow_live._switch.intValue() == 1 && TbadkCoreApplication.isLogin()) {
            com.baidu.tbadk.data.b bVar = new com.baidu.tbadk.data.b();
            bVar.a(dataRes.banner_follow_live);
            if (!com.baidu.tbadk.core.util.v.J(bVar.getList())) {
                this.mDataList.add(bVar);
            }
        }
        if (dataRes.req_unix != null) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("concern_data_res_request_time"), dataRes.req_unix.longValue());
        }
        if (dataRes.top_user_info != null && aIR()) {
            if (!ao.isEmpty(builder.top_tips)) {
                com.baidu.tieba.homepage.concern.b.a aVar = new com.baidu.tieba.homepage.concern.b.a();
                aVar.aBr = builder.top_tips;
                this.eic = aVar;
                this.mDataList.add(aVar);
            }
            com.baidu.tieba.homepage.concern.b.b a2 = a(dataRes.top_user_info);
            a2.nA(1);
            this.eid = a2;
            this.mDataList.add(a2);
        }
        if (dataRes.top_user_info == null && !z2 && this.eid != null && aIR() && this.eic != null) {
            this.mDataList.add(this.eic);
            this.mDataList.add(this.eid);
        }
        List<h> a3 = a(z, builder, z2);
        if (a3 != null && TbadkCoreApplication.isLogin()) {
            this.mDataList.addAll(a3);
        }
        if (!ao.isEmpty(builder.user_tips)) {
            com.baidu.tieba.homepage.concern.b.a aVar2 = new com.baidu.tieba.homepage.concern.b.a();
            this.eii = builder.user_tips_type.intValue();
            aVar2.eiK = builder.user_tips_type.intValue();
            aVar2.aBr = builder.user_tips;
            aVar2.eiM = true;
            this.mDataList.add(aVar2);
        }
        List<h> a4 = a(builder);
        if (a4 != null) {
            this.mDataList.addAll(a4);
        }
        if (!ao.isEmpty(builder.last_tips)) {
            com.baidu.tieba.homepage.concern.b.a aVar3 = new com.baidu.tieba.homepage.concern.b.a();
            aVar3.aBr = builder.last_tips;
            aVar3.eiL = true;
            this.mDataList.add(aVar3);
        }
        this.hasMore = builder.has_more.intValue() == 1;
        if (com.baidu.tbadk.core.util.v.J(this.mDataList)) {
            return false;
        }
        if (z2) {
            this.eie.page_tag = dataRes.page_tag;
            this.eie.has_more = dataRes.has_more;
            this.eie.user_list = dataRes.user_list;
            this.eie.user_tips_type = dataRes.user_tips_type;
            this.eie.user_tips = dataRes.user_tips;
            this.eie.last_tips = dataRes.last_tips;
        }
        this.eie.banner_user_story = dataRes.banner_user_story;
        this.eie.banner_follow_live = dataRes.banner_follow_live;
        this.eie.top_tips = dataRes.top_tips;
        this.eie.top_user_info = dataRes.top_user_info;
        if (this.eii == 2 || this.eii == 3) {
            this.eie.user_tips_type = dataRes.user_tips_type;
            this.eie.user_tips = dataRes.user_tips;
        }
        this.eig.al(this.mDataList);
        return true;
    }

    private boolean aIR() {
        if (TbadkCoreApplication.isLogin()) {
            if (System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.getInstance().getLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("concern_top_user_user_like_time"), 0L) > 86400000) {
                return true;
            }
        }
        return false;
    }

    private void wI() {
        x.a(new w<DataRes>() { // from class: com.baidu.tieba.homepage.concern.b.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.w
            /* renamed from: aIS */
            public DataRes doInBackground() {
                l<byte[]> aj = com.baidu.tbadk.core.c.a.Aq().aj("tb.concern_page", TbadkCoreApplication.getCurrentAccount());
                if (aj == null) {
                    return null;
                }
                byte[] bArr = aj.get("0");
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

    private void aug() {
        if (this.eie != null) {
            DataRes.Builder builder = new DataRes.Builder(this.eie.build(true));
            if (builder.thread_info != null && builder.thread_info.size() > 30) {
                builder.thread_info = builder.thread_info.subList(0, 30);
            }
            b(builder);
        }
    }

    private void b(final DataRes.Builder builder) {
        x.a(new w<Object>() { // from class: com.baidu.tieba.homepage.concern.b.6
            @Override // com.baidu.tbadk.util.w
            public Object doInBackground() {
                DataRes.Builder builder2 = new DataRes.Builder(builder.build(true));
                try {
                    com.baidu.tbadk.core.c.a.Aq().aj("tb.concern_page", TbadkCoreApplication.getCurrentAccount()).e("0", builder2.build(true).toByteArray());
                    return null;
                } catch (Exception e) {
                    BdLog.e(e);
                    return null;
                }
            }
        }, null);
    }

    public void a(a aVar) {
        this.eib = aVar;
    }

    private boolean DU() {
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
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.eie != null && com.baidu.tbadk.core.util.v.I(this.eie.thread_info) != 0 && com.baidu.tbadk.core.util.v.I(this.mDataList) != 0) {
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
                        if (cVar.YA() != null && cVar.YA().getTid() != null && cVar.YA().getTid().equals(optString)) {
                            this.mDataList.remove(i);
                            if (this.eig != null) {
                                this.eig.al(this.mDataList);
                            }
                        }
                    }
                    i++;
                }
                long d = com.baidu.adp.lib.g.b.d(optString, 0L);
                for (int i2 = 0; i2 < this.eie.thread_info.size(); i2++) {
                    ConcernData concernData = this.eie.thread_info.get(i2);
                    if (concernData != null && (threadInfo = concernData.thread_list) != null && threadInfo.tid != null && threadInfo.tid.longValue() == d) {
                        this.eie.thread_info.remove(i2);
                        aug();
                        return;
                    }
                }
            }
        }
    }
}
