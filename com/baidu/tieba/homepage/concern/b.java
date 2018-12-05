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
    private View.OnTouchListener aVo;
    private t biL;
    private com.baidu.tieba.f.a eds;
    private LongSparseArray<com.baidu.tieba.homepage.concern.b.b> eoL;
    private com.baidu.tieba.homepage.concern.b.a eqr;
    private com.baidu.tieba.homepage.concern.b.b eqs;
    private DataRes.Builder eqt;
    private final com.baidu.tieba.homepage.concern.a eqv;
    private final com.baidu.tieba.homepage.concern.c.a eqw;
    private int eqx;
    private boolean hasMore;
    private final BdTypeListView mListView;
    private String pageTag;
    private a eqq = null;
    private final List<h> mDataList = new LinkedList();
    private boolean mIsLoading = false;
    private boolean equ = false;
    private boolean mIsBackground = false;
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.homepage.concern.b.1
        private int eqz = 0;

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (b.this.biL != null && !b.this.mIsBackground) {
                b.this.biL.g(absListView, i);
            }
            if (i == 0) {
                v.apD().Zn();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (b.this.biL != null && !b.this.mIsBackground) {
                b.this.biL.onScroll(this.eqz, i);
            }
            this.eqz = i;
        }
    };
    private View.OnTouchListener biM = new View.OnTouchListener() { // from class: com.baidu.tieba.homepage.concern.b.2
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (b.this.aVo != null) {
                b.this.aVo.onTouch(view, motionEvent);
            }
            if (b.this.eds != null) {
                b.this.eds.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private a.InterfaceC0214a cvL = new a.InterfaceC0214a() { // from class: com.baidu.tieba.homepage.concern.b.3
        @Override // com.baidu.tieba.f.a.InterfaceC0214a
        public void aq(int i, int i2) {
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0214a
        public void ar(int i, int i2) {
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0214a
        public void as(int i, int i2) {
        }
    };
    private CustomMessageListener eqy = new CustomMessageListener(2016488) { // from class: com.baidu.tieba.homepage.concern.b.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.this.h(customResponsedMessage);
        }
    };
    private CustomMessageListener eaD = new CustomMessageListener(2016553) { // from class: com.baidu.tieba.homepage.concern.b.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.this.h(customResponsedMessage);
        }
    };

    /* loaded from: classes6.dex */
    public interface a {
        void F(boolean z, boolean z2);

        void aKd();

        void aKe();

        void onError(int i, String str);

        void pf(String str);
    }

    public void setTabInForeBackgroundState(boolean z) {
        this.mIsBackground = z;
    }

    public void gD(boolean z) {
        this.mIsBackground = z;
    }

    public b(e<?> eVar, BdTypeListView bdTypeListView, com.baidu.tieba.homepage.concern.a aVar) {
        this.mListView = bdTypeListView;
        this.mListView.setOnTouchListener(this.biM);
        this.eds = new com.baidu.tieba.f.a();
        this.eqw = new com.baidu.tieba.homepage.concern.c.a();
        this.eds.a(this.cvL);
        this.eqv = aVar;
        bdTypeListView.setOnScrollListener(this.mOnScrollListener);
    }

    public void l(BdUniqueId bdUniqueId) {
        this.eqy.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.eqy);
        this.eaD.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.eaD);
    }

    public void setRecommendFrsNavigationAnimDispatcher(u uVar) {
        if (uVar != null) {
            this.biL = uVar.Qd();
            this.aVo = uVar.Qe();
        }
    }

    public void update() {
        if (this.mDataList.size() == 0 && !this.equ) {
            xU();
        } else {
            xT();
        }
    }

    public void aKf() {
        xT();
    }

    public void aab() {
        if (!Fi() && this.hasMore && this.eqq != null) {
            setIsLoading(true);
            this.eqq.pf(this.pageTag);
        }
    }

    public void a(boolean z, DataRes dataRes, int i, String str) {
        setIsLoading(false);
        this.mListView.completePullRefreshPostDelayed(SystemScreenshotManager.DELAY_TIME);
        if (i != 0 || dataRes == null || !a(true, z, dataRes)) {
            if (i == 0 && com.baidu.tbadk.core.util.v.H(this.mDataList) == 0 && this.eqq != null) {
                this.eqq.aKe();
                return;
            } else if (this.mDataList.size() > 0) {
                if (this.eqq != null) {
                    this.eqq.onError(1, str);
                    return;
                }
                return;
            } else if (this.eqq != null) {
                this.eqq.onError(2, str);
                return;
            } else {
                return;
            }
        }
        if (this.eqq != null) {
            this.eqq.F(z, false);
        }
        avs();
    }

    public void hJ(boolean z) {
        if (z) {
            this.eqv.notifyDataSetChanged();
        }
    }

    private void xT() {
        if (this.eqq != null) {
            this.eqq.aKd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(DataRes dataRes) {
        this.equ = true;
        if (dataRes != null) {
            if (a(false, true, dataRes)) {
                if (this.eqq != null) {
                    this.eqq.F(false, true);
                    return;
                }
                return;
            }
            xT();
            return;
        }
        xT();
    }

    private List<h> a(boolean z, DataRes.Builder builder, boolean z2) {
        if (this.eqt == null) {
            this.eqt = new DataRes.Builder();
        }
        if (builder == null) {
            builder = new DataRes.Builder();
        }
        c a2 = this.eqw.a(z, this.eqt, builder, z2 ? 0 : 1);
        if (a2 == null) {
            return null;
        }
        return a2.bvL;
    }

    private List<h> a(DataRes.Builder builder) {
        if (builder == null || com.baidu.tbadk.core.util.v.I(builder.user_list)) {
            return null;
        }
        ch(builder.user_list);
        ArrayList arrayList = new ArrayList();
        if (!com.baidu.tbadk.core.util.v.I(builder.user_list)) {
            int i = 0;
            for (UserList userList : builder.user_list) {
                if (userList != null) {
                    if (i == 30) {
                        break;
                    }
                    com.baidu.tieba.homepage.concern.b.b bVar = this.eoL.get(userList.id.longValue());
                    if (bVar != null) {
                        arrayList.add(bVar);
                        i++;
                    }
                }
            }
        }
        this.eoL.clear();
        return arrayList;
    }

    private void ch(List<UserList> list) {
        if (this.eoL == null) {
            this.eoL = new LongSparseArray<>();
        }
        for (UserList userList : list) {
            com.baidu.tieba.homepage.concern.b.b a2 = a(userList);
            switch (this.eqx) {
                case 2:
                    a2.om(2);
                    break;
                case 3:
                    a2.om(3);
                    break;
                case 4:
                    a2.om(4);
                    break;
            }
            if (a2 != null) {
                this.eoL.put(userList.id.longValue(), a2);
            }
        }
    }

    private com.baidu.tieba.homepage.concern.b.b a(UserList userList) {
        com.baidu.tieba.homepage.concern.b.b bVar = new com.baidu.tieba.homepage.concern.b.b();
        bVar.ere = new com.baidu.tieba.homepage.concern.b.c();
        bVar.ere.b(userList);
        bVar.dwZ = new bb();
        bVar.dwZ.a(userList.thread_info);
        bVar.aKi();
        if (bVar.dwZ.isLinkThread()) {
            bVar.isLinkThread = true;
        }
        if (StringUtils.isNull(bVar.ere.getName()) || bVar.ere.getId() == 0 || StringUtils.isNull(bVar.dwZ.getTid()) || StringUtils.isNull(bVar.dwZ.getId())) {
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
            this.eqr = null;
            this.eqs = null;
        }
        DataRes.Builder builder = new DataRes.Builder(dataRes);
        if (dataRes.banner_follow_live != null && dataRes.banner_follow_live._switch.intValue() == 1 && TbadkCoreApplication.isLogin()) {
            com.baidu.tbadk.data.b bVar = new com.baidu.tbadk.data.b();
            bVar.a(dataRes.banner_follow_live);
            if (!com.baidu.tbadk.core.util.v.I(bVar.getList())) {
                this.mDataList.add(bVar);
            }
        }
        if (dataRes.req_unix != null) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("concern_data_res_request_time"), dataRes.req_unix.longValue());
        }
        if (dataRes.top_user_info != null && aKg()) {
            if (!ao.isEmpty(builder.top_tips)) {
                com.baidu.tieba.homepage.concern.b.a aVar = new com.baidu.tieba.homepage.concern.b.a();
                aVar.aFG = builder.top_tips;
                this.eqr = aVar;
                this.mDataList.add(aVar);
            }
            com.baidu.tieba.homepage.concern.b.b a2 = a(dataRes.top_user_info);
            a2.om(1);
            this.eqs = a2;
            this.mDataList.add(a2);
        }
        if (dataRes.top_user_info == null && !z2 && this.eqs != null && aKg() && this.eqr != null) {
            this.mDataList.add(this.eqr);
            this.mDataList.add(this.eqs);
        }
        List<h> a3 = a(z, builder, z2);
        if (a3 != null && TbadkCoreApplication.isLogin()) {
            this.mDataList.addAll(a3);
        }
        if (!ao.isEmpty(builder.user_tips)) {
            com.baidu.tieba.homepage.concern.b.a aVar2 = new com.baidu.tieba.homepage.concern.b.a();
            this.eqx = builder.user_tips_type.intValue();
            aVar2.eqZ = builder.user_tips_type.intValue();
            aVar2.aFG = builder.user_tips;
            aVar2.erb = true;
            this.mDataList.add(aVar2);
        }
        List<h> a4 = a(builder);
        if (a4 != null) {
            this.mDataList.addAll(a4);
        }
        if (!ao.isEmpty(builder.last_tips)) {
            com.baidu.tieba.homepage.concern.b.a aVar3 = new com.baidu.tieba.homepage.concern.b.a();
            aVar3.aFG = builder.last_tips;
            aVar3.era = true;
            this.mDataList.add(aVar3);
        }
        this.hasMore = builder.has_more.intValue() == 1;
        if (com.baidu.tbadk.core.util.v.I(this.mDataList)) {
            return false;
        }
        if (z2) {
            this.eqt.page_tag = dataRes.page_tag;
            this.eqt.has_more = dataRes.has_more;
            this.eqt.user_list = dataRes.user_list;
            this.eqt.user_tips_type = dataRes.user_tips_type;
            this.eqt.user_tips = dataRes.user_tips;
            this.eqt.last_tips = dataRes.last_tips;
        }
        this.eqt.banner_user_story = dataRes.banner_user_story;
        this.eqt.banner_follow_live = dataRes.banner_follow_live;
        this.eqt.top_tips = dataRes.top_tips;
        this.eqt.top_user_info = dataRes.top_user_info;
        if (this.eqx == 2 || this.eqx == 3) {
            this.eqt.user_tips_type = dataRes.user_tips_type;
            this.eqt.user_tips = dataRes.user_tips;
        }
        this.eqv.ak(this.mDataList);
        return true;
    }

    private boolean aKg() {
        if (TbadkCoreApplication.isLogin()) {
            if (System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.getInstance().getLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("concern_top_user_user_like_time"), 0L) > 86400000) {
                return true;
            }
        }
        return false;
    }

    private void xU() {
        x.a(new w<DataRes>() { // from class: com.baidu.tieba.homepage.concern.b.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.w
            /* renamed from: aKh */
            public DataRes doInBackground() {
                l<byte[]> am = com.baidu.tbadk.core.c.a.BB().am("tb.concern_page", TbadkCoreApplication.getCurrentAccount());
                if (am == null) {
                    return null;
                }
                byte[] bArr = am.get("0");
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

    private void avs() {
        if (this.eqt != null) {
            DataRes.Builder builder = new DataRes.Builder(this.eqt.build(true));
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
                    com.baidu.tbadk.core.c.a.BB().am("tb.concern_page", TbadkCoreApplication.getCurrentAccount()).e("0", builder2.build(true).toByteArray());
                    return null;
                } catch (Exception e) {
                    BdLog.e(e);
                    return null;
                }
            }
        }, null);
    }

    public void a(a aVar) {
        this.eqq = aVar;
    }

    private boolean Fi() {
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
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.eqt != null && com.baidu.tbadk.core.util.v.H(this.eqt.thread_info) != 0 && com.baidu.tbadk.core.util.v.H(this.mDataList) != 0) {
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
                        if (cVar.ZR() != null && cVar.ZR().getTid() != null && cVar.ZR().getTid().equals(optString)) {
                            this.mDataList.remove(i);
                            if (this.eqv != null) {
                                this.eqv.ak(this.mDataList);
                            }
                        }
                    }
                    i++;
                }
                long d = com.baidu.adp.lib.g.b.d(optString, 0L);
                for (int i2 = 0; i2 < this.eqt.thread_info.size(); i2++) {
                    ConcernData concernData = this.eqt.thread_info.get(i2);
                    if (concernData != null && (threadInfo = concernData.thread_list) != null && threadInfo.tid != null && threadInfo.tid.longValue() == d) {
                        this.eqt.thread_info.remove(i2);
                        avs();
                        return;
                    }
                }
            }
        }
    }
}
