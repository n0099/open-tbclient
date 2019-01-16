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
import com.baidu.tbadk.util.u;
import com.baidu.tbadk.util.x;
import com.baidu.tbadk.util.y;
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
    private View.OnTouchListener aVZ;
    private u bjB;
    private com.baidu.tieba.f.a egP;
    private LongSparseArray<com.baidu.tieba.homepage.concern.b.b> esi;
    private com.baidu.tieba.homepage.concern.b.a etP;
    private com.baidu.tieba.homepage.concern.b.b etQ;
    private DataRes.Builder etR;
    private final com.baidu.tieba.homepage.concern.a etT;
    private final com.baidu.tieba.homepage.concern.c.a etU;
    private int etV;
    private boolean hasMore;
    private final BdTypeListView mListView;
    private String pageTag;
    private a etO = null;
    private final List<h> mDataList = new LinkedList();
    private boolean mIsLoading = false;
    private boolean etS = false;
    private boolean mIsBackground = false;
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.homepage.concern.b.1
        private int etX = 0;

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (b.this.bjB != null && !b.this.mIsBackground) {
                b.this.bjB.g(absListView, i);
            }
            if (i == 0) {
                v.aqP().ZM();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (b.this.bjB != null && !b.this.mIsBackground) {
                b.this.bjB.onScroll(this.etX, i);
            }
            this.etX = i;
        }
    };
    private View.OnTouchListener bjC = new View.OnTouchListener() { // from class: com.baidu.tieba.homepage.concern.b.2
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (b.this.aVZ != null) {
                b.this.aVZ.onTouch(view, motionEvent);
            }
            if (b.this.egP != null) {
                b.this.egP.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private a.InterfaceC0214a cxB = new a.InterfaceC0214a() { // from class: com.baidu.tieba.homepage.concern.b.3
        @Override // com.baidu.tieba.f.a.InterfaceC0214a
        public void ar(int i, int i2) {
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0214a
        public void as(int i, int i2) {
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0214a
        public void at(int i, int i2) {
        }
    };
    private CustomMessageListener etW = new CustomMessageListener(2016488) { // from class: com.baidu.tieba.homepage.concern.b.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.this.h(customResponsedMessage);
        }
    };
    private CustomMessageListener eea = new CustomMessageListener(2016553) { // from class: com.baidu.tieba.homepage.concern.b.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.this.h(customResponsedMessage);
        }
    };

    /* loaded from: classes6.dex */
    public interface a {
        void F(boolean z, boolean z2);

        void aLq();

        void aLr();

        void onError(int i, String str);

        void py(String str);
    }

    public void setTabInForeBackgroundState(boolean z) {
        this.mIsBackground = z;
    }

    public void gJ(boolean z) {
        this.mIsBackground = z;
    }

    public b(e<?> eVar, BdTypeListView bdTypeListView, com.baidu.tieba.homepage.concern.a aVar) {
        this.mListView = bdTypeListView;
        this.mListView.setOnTouchListener(this.bjC);
        this.egP = new com.baidu.tieba.f.a();
        this.etU = new com.baidu.tieba.homepage.concern.c.a();
        this.egP.a(this.cxB);
        this.etT = aVar;
        bdTypeListView.setOnScrollListener(this.mOnScrollListener);
    }

    public void l(BdUniqueId bdUniqueId) {
        this.etW.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.etW);
        this.eea.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.eea);
    }

    public void setRecommendFrsNavigationAnimDispatcher(com.baidu.tbadk.util.v vVar) {
        if (vVar != null) {
            this.bjB = vVar.QA();
            this.aVZ = vVar.QB();
        }
    }

    public void update() {
        if (this.mDataList.size() == 0 && !this.etS) {
            yh();
        } else {
            yg();
        }
    }

    public void aLs() {
        yg();
    }

    public void aaA() {
        if (!Fv() && this.hasMore && this.etO != null) {
            setIsLoading(true);
            this.etO.py(this.pageTag);
        }
    }

    public void a(boolean z, DataRes dataRes, int i, String str) {
        setIsLoading(false);
        this.mListView.completePullRefreshPostDelayed(SystemScreenshotManager.DELAY_TIME);
        if (i != 0 || dataRes == null || !a(true, z, dataRes)) {
            if (i == 0 && com.baidu.tbadk.core.util.v.H(this.mDataList) == 0 && this.etO != null) {
                this.etO.aLr();
                return;
            } else if (this.mDataList.size() > 0) {
                if (this.etO != null) {
                    this.etO.onError(1, str);
                    return;
                }
                return;
            } else if (this.etO != null) {
                this.etO.onError(2, str);
                return;
            } else {
                return;
            }
        }
        if (this.etO != null) {
            this.etO.F(z, false);
        }
        awE();
    }

    public void hM(boolean z) {
        if (z) {
            this.etT.notifyDataSetChanged();
        }
    }

    private void yg() {
        if (this.etO != null) {
            this.etO.aLq();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(DataRes dataRes) {
        this.etS = true;
        if (dataRes != null) {
            if (a(false, true, dataRes)) {
                if (this.etO != null) {
                    this.etO.F(false, true);
                    return;
                }
                return;
            }
            yg();
            return;
        }
        yg();
    }

    private List<h> a(boolean z, DataRes.Builder builder, boolean z2) {
        if (this.etR == null) {
            this.etR = new DataRes.Builder();
        }
        if (builder == null) {
            builder = new DataRes.Builder();
        }
        c a2 = this.etU.a(z, this.etR, builder, z2 ? 0 : 1);
        if (a2 == null) {
            return null;
        }
        return a2.bwC;
    }

    private List<h> a(DataRes.Builder builder) {
        if (builder == null || com.baidu.tbadk.core.util.v.I(builder.user_list)) {
            return null;
        }
        cj(builder.user_list);
        ArrayList arrayList = new ArrayList();
        if (!com.baidu.tbadk.core.util.v.I(builder.user_list)) {
            int i = 0;
            for (UserList userList : builder.user_list) {
                if (userList != null) {
                    if (i == 30) {
                        break;
                    }
                    com.baidu.tieba.homepage.concern.b.b bVar = this.esi.get(userList.id.longValue());
                    if (bVar != null) {
                        arrayList.add(bVar);
                        i++;
                    }
                }
            }
        }
        this.esi.clear();
        return arrayList;
    }

    private void cj(List<UserList> list) {
        if (this.esi == null) {
            this.esi = new LongSparseArray<>();
        }
        for (UserList userList : list) {
            com.baidu.tieba.homepage.concern.b.b a2 = a(userList);
            switch (this.etV) {
                case 2:
                    a2.oA(2);
                    break;
                case 3:
                    a2.oA(3);
                    break;
                case 4:
                    a2.oA(4);
                    break;
            }
            if (a2 != null) {
                this.esi.put(userList.id.longValue(), a2);
            }
        }
    }

    private com.baidu.tieba.homepage.concern.b.b a(UserList userList) {
        com.baidu.tieba.homepage.concern.b.b bVar = new com.baidu.tieba.homepage.concern.b.b();
        bVar.euC = new com.baidu.tieba.homepage.concern.b.c();
        bVar.euC.b(userList);
        bVar.dAv = new bb();
        bVar.dAv.a(userList.thread_info);
        bVar.aLv();
        if (bVar.dAv.isLinkThread()) {
            bVar.isLinkThread = true;
        }
        if (StringUtils.isNull(bVar.euC.getName()) || bVar.euC.getId() == 0 || StringUtils.isNull(bVar.dAv.getTid()) || StringUtils.isNull(bVar.dAv.getId())) {
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
            this.etP = null;
            this.etQ = null;
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
        if (dataRes.top_user_info != null && aLt()) {
            if (!ao.isEmpty(builder.top_tips)) {
                com.baidu.tieba.homepage.concern.b.a aVar = new com.baidu.tieba.homepage.concern.b.a();
                aVar.aGj = builder.top_tips;
                this.etP = aVar;
                this.mDataList.add(aVar);
            }
            com.baidu.tieba.homepage.concern.b.b a2 = a(dataRes.top_user_info);
            a2.oA(1);
            this.etQ = a2;
            this.mDataList.add(a2);
        }
        if (dataRes.top_user_info == null && !z2 && this.etQ != null && aLt() && this.etP != null) {
            this.mDataList.add(this.etP);
            this.mDataList.add(this.etQ);
        }
        List<h> a3 = a(z, builder, z2);
        if (a3 != null && TbadkCoreApplication.isLogin()) {
            this.mDataList.addAll(a3);
        }
        if (!ao.isEmpty(builder.user_tips)) {
            com.baidu.tieba.homepage.concern.b.a aVar2 = new com.baidu.tieba.homepage.concern.b.a();
            this.etV = builder.user_tips_type.intValue();
            aVar2.eux = builder.user_tips_type.intValue();
            aVar2.aGj = builder.user_tips;
            aVar2.euz = true;
            this.mDataList.add(aVar2);
        }
        List<h> a4 = a(builder);
        if (a4 != null) {
            this.mDataList.addAll(a4);
        }
        if (!ao.isEmpty(builder.last_tips)) {
            com.baidu.tieba.homepage.concern.b.a aVar3 = new com.baidu.tieba.homepage.concern.b.a();
            aVar3.aGj = builder.last_tips;
            aVar3.euy = true;
            this.mDataList.add(aVar3);
        }
        this.hasMore = builder.has_more.intValue() == 1;
        if (com.baidu.tbadk.core.util.v.I(this.mDataList)) {
            return false;
        }
        if (z2) {
            this.etR.page_tag = dataRes.page_tag;
            this.etR.has_more = dataRes.has_more;
            this.etR.user_list = dataRes.user_list;
            this.etR.user_tips_type = dataRes.user_tips_type;
            this.etR.user_tips = dataRes.user_tips;
            this.etR.last_tips = dataRes.last_tips;
        }
        this.etR.banner_user_story = dataRes.banner_user_story;
        this.etR.banner_follow_live = dataRes.banner_follow_live;
        this.etR.top_tips = dataRes.top_tips;
        this.etR.top_user_info = dataRes.top_user_info;
        if (this.etV == 2 || this.etV == 3) {
            this.etR.user_tips_type = dataRes.user_tips_type;
            this.etR.user_tips = dataRes.user_tips;
        }
        this.etT.al(this.mDataList);
        return true;
    }

    private boolean aLt() {
        if (TbadkCoreApplication.isLogin()) {
            if (System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.getInstance().getLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("concern_top_user_user_like_time"), 0L) > 86400000) {
                return true;
            }
        }
        return false;
    }

    private void yh() {
        y.a(new x<DataRes>() { // from class: com.baidu.tieba.homepage.concern.b.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.x
            /* renamed from: aLu */
            public DataRes doInBackground() {
                l<byte[]> an = com.baidu.tbadk.core.c.a.BO().an("tb.concern_page", TbadkCoreApplication.getCurrentAccount());
                if (an == null) {
                    return null;
                }
                byte[] bArr = an.get("0");
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

    private void awE() {
        if (this.etR != null) {
            DataRes.Builder builder = new DataRes.Builder(this.etR.build(true));
            if (builder.thread_info != null && builder.thread_info.size() > 30) {
                builder.thread_info = builder.thread_info.subList(0, 30);
            }
            b(builder);
        }
    }

    private void b(final DataRes.Builder builder) {
        y.a(new x<Object>() { // from class: com.baidu.tieba.homepage.concern.b.6
            @Override // com.baidu.tbadk.util.x
            public Object doInBackground() {
                DataRes.Builder builder2 = new DataRes.Builder(builder.build(true));
                try {
                    com.baidu.tbadk.core.c.a.BO().an("tb.concern_page", TbadkCoreApplication.getCurrentAccount()).e("0", builder2.build(true).toByteArray());
                    return null;
                } catch (Exception e) {
                    BdLog.e(e);
                    return null;
                }
            }
        }, null);
    }

    public void a(a aVar) {
        this.etO = aVar;
    }

    private boolean Fv() {
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
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.etR != null && com.baidu.tbadk.core.util.v.H(this.etR.thread_info) != 0 && com.baidu.tbadk.core.util.v.H(this.mDataList) != 0) {
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
                        if (cVar.aaq() != null && cVar.aaq().getTid() != null && cVar.aaq().getTid().equals(optString)) {
                            this.mDataList.remove(i);
                            if (this.etT != null) {
                                this.etT.al(this.mDataList);
                            }
                        }
                    }
                    i++;
                }
                long d = com.baidu.adp.lib.g.b.d(optString, 0L);
                for (int i2 = 0; i2 < this.etR.thread_info.size(); i2++) {
                    ConcernData concernData = this.etR.thread_info.get(i2);
                    if (concernData != null && (threadInfo = concernData.thread_list) != null && threadInfo.tid != null && threadInfo.tid.longValue() == d) {
                        this.etR.thread_info.remove(i2);
                        awE();
                        return;
                    }
                }
            }
        }
    }
}
