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
    private View.OnTouchListener aWa;
    private u bjC;
    private com.baidu.tieba.f.a egQ;
    private LongSparseArray<com.baidu.tieba.homepage.concern.b.b> esj;
    private com.baidu.tieba.homepage.concern.b.a etQ;
    private com.baidu.tieba.homepage.concern.b.b etR;
    private DataRes.Builder etS;
    private final com.baidu.tieba.homepage.concern.a etU;
    private final com.baidu.tieba.homepage.concern.c.a etV;
    private int etW;
    private boolean hasMore;
    private final BdTypeListView mListView;
    private String pageTag;
    private a etP = null;
    private final List<h> mDataList = new LinkedList();
    private boolean mIsLoading = false;
    private boolean etT = false;
    private boolean mIsBackground = false;
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.homepage.concern.b.1
        private int etY = 0;

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (b.this.bjC != null && !b.this.mIsBackground) {
                b.this.bjC.g(absListView, i);
            }
            if (i == 0) {
                v.aqP().ZM();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (b.this.bjC != null && !b.this.mIsBackground) {
                b.this.bjC.onScroll(this.etY, i);
            }
            this.etY = i;
        }
    };
    private View.OnTouchListener bjD = new View.OnTouchListener() { // from class: com.baidu.tieba.homepage.concern.b.2
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (b.this.aWa != null) {
                b.this.aWa.onTouch(view, motionEvent);
            }
            if (b.this.egQ != null) {
                b.this.egQ.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private a.InterfaceC0214a cxC = new a.InterfaceC0214a() { // from class: com.baidu.tieba.homepage.concern.b.3
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
    private CustomMessageListener etX = new CustomMessageListener(2016488) { // from class: com.baidu.tieba.homepage.concern.b.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.this.h(customResponsedMessage);
        }
    };
    private CustomMessageListener eeb = new CustomMessageListener(2016553) { // from class: com.baidu.tieba.homepage.concern.b.8
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
        this.mListView.setOnTouchListener(this.bjD);
        this.egQ = new com.baidu.tieba.f.a();
        this.etV = new com.baidu.tieba.homepage.concern.c.a();
        this.egQ.a(this.cxC);
        this.etU = aVar;
        bdTypeListView.setOnScrollListener(this.mOnScrollListener);
    }

    public void l(BdUniqueId bdUniqueId) {
        this.etX.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.etX);
        this.eeb.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.eeb);
    }

    public void setRecommendFrsNavigationAnimDispatcher(com.baidu.tbadk.util.v vVar) {
        if (vVar != null) {
            this.bjC = vVar.QA();
            this.aWa = vVar.QB();
        }
    }

    public void update() {
        if (this.mDataList.size() == 0 && !this.etT) {
            yh();
        } else {
            yg();
        }
    }

    public void aLs() {
        yg();
    }

    public void aaA() {
        if (!Fv() && this.hasMore && this.etP != null) {
            setIsLoading(true);
            this.etP.py(this.pageTag);
        }
    }

    public void a(boolean z, DataRes dataRes, int i, String str) {
        setIsLoading(false);
        this.mListView.completePullRefreshPostDelayed(SystemScreenshotManager.DELAY_TIME);
        if (i != 0 || dataRes == null || !a(true, z, dataRes)) {
            if (i == 0 && com.baidu.tbadk.core.util.v.H(this.mDataList) == 0 && this.etP != null) {
                this.etP.aLr();
                return;
            } else if (this.mDataList.size() > 0) {
                if (this.etP != null) {
                    this.etP.onError(1, str);
                    return;
                }
                return;
            } else if (this.etP != null) {
                this.etP.onError(2, str);
                return;
            } else {
                return;
            }
        }
        if (this.etP != null) {
            this.etP.F(z, false);
        }
        awE();
    }

    public void hM(boolean z) {
        if (z) {
            this.etU.notifyDataSetChanged();
        }
    }

    private void yg() {
        if (this.etP != null) {
            this.etP.aLq();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(DataRes dataRes) {
        this.etT = true;
        if (dataRes != null) {
            if (a(false, true, dataRes)) {
                if (this.etP != null) {
                    this.etP.F(false, true);
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
        if (this.etS == null) {
            this.etS = new DataRes.Builder();
        }
        if (builder == null) {
            builder = new DataRes.Builder();
        }
        c a2 = this.etV.a(z, this.etS, builder, z2 ? 0 : 1);
        if (a2 == null) {
            return null;
        }
        return a2.bwD;
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
                    com.baidu.tieba.homepage.concern.b.b bVar = this.esj.get(userList.id.longValue());
                    if (bVar != null) {
                        arrayList.add(bVar);
                        i++;
                    }
                }
            }
        }
        this.esj.clear();
        return arrayList;
    }

    private void cj(List<UserList> list) {
        if (this.esj == null) {
            this.esj = new LongSparseArray<>();
        }
        for (UserList userList : list) {
            com.baidu.tieba.homepage.concern.b.b a2 = a(userList);
            switch (this.etW) {
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
                this.esj.put(userList.id.longValue(), a2);
            }
        }
    }

    private com.baidu.tieba.homepage.concern.b.b a(UserList userList) {
        com.baidu.tieba.homepage.concern.b.b bVar = new com.baidu.tieba.homepage.concern.b.b();
        bVar.euD = new com.baidu.tieba.homepage.concern.b.c();
        bVar.euD.b(userList);
        bVar.dAw = new bb();
        bVar.dAw.a(userList.thread_info);
        bVar.aLv();
        if (bVar.dAw.isLinkThread()) {
            bVar.isLinkThread = true;
        }
        if (StringUtils.isNull(bVar.euD.getName()) || bVar.euD.getId() == 0 || StringUtils.isNull(bVar.dAw.getTid()) || StringUtils.isNull(bVar.dAw.getId())) {
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
            this.etQ = null;
            this.etR = null;
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
                aVar.aGk = builder.top_tips;
                this.etQ = aVar;
                this.mDataList.add(aVar);
            }
            com.baidu.tieba.homepage.concern.b.b a2 = a(dataRes.top_user_info);
            a2.oA(1);
            this.etR = a2;
            this.mDataList.add(a2);
        }
        if (dataRes.top_user_info == null && !z2 && this.etR != null && aLt() && this.etQ != null) {
            this.mDataList.add(this.etQ);
            this.mDataList.add(this.etR);
        }
        List<h> a3 = a(z, builder, z2);
        if (a3 != null && TbadkCoreApplication.isLogin()) {
            this.mDataList.addAll(a3);
        }
        if (!ao.isEmpty(builder.user_tips)) {
            com.baidu.tieba.homepage.concern.b.a aVar2 = new com.baidu.tieba.homepage.concern.b.a();
            this.etW = builder.user_tips_type.intValue();
            aVar2.euy = builder.user_tips_type.intValue();
            aVar2.aGk = builder.user_tips;
            aVar2.euA = true;
            this.mDataList.add(aVar2);
        }
        List<h> a4 = a(builder);
        if (a4 != null) {
            this.mDataList.addAll(a4);
        }
        if (!ao.isEmpty(builder.last_tips)) {
            com.baidu.tieba.homepage.concern.b.a aVar3 = new com.baidu.tieba.homepage.concern.b.a();
            aVar3.aGk = builder.last_tips;
            aVar3.euz = true;
            this.mDataList.add(aVar3);
        }
        this.hasMore = builder.has_more.intValue() == 1;
        if (com.baidu.tbadk.core.util.v.I(this.mDataList)) {
            return false;
        }
        if (z2) {
            this.etS.page_tag = dataRes.page_tag;
            this.etS.has_more = dataRes.has_more;
            this.etS.user_list = dataRes.user_list;
            this.etS.user_tips_type = dataRes.user_tips_type;
            this.etS.user_tips = dataRes.user_tips;
            this.etS.last_tips = dataRes.last_tips;
        }
        this.etS.banner_user_story = dataRes.banner_user_story;
        this.etS.banner_follow_live = dataRes.banner_follow_live;
        this.etS.top_tips = dataRes.top_tips;
        this.etS.top_user_info = dataRes.top_user_info;
        if (this.etW == 2 || this.etW == 3) {
            this.etS.user_tips_type = dataRes.user_tips_type;
            this.etS.user_tips = dataRes.user_tips;
        }
        this.etU.al(this.mDataList);
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
        if (this.etS != null) {
            DataRes.Builder builder = new DataRes.Builder(this.etS.build(true));
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
        this.etP = aVar;
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
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.etS != null && com.baidu.tbadk.core.util.v.H(this.etS.thread_info) != 0 && com.baidu.tbadk.core.util.v.H(this.mDataList) != 0) {
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
                            if (this.etU != null) {
                                this.etU.al(this.mDataList);
                            }
                        }
                    }
                    i++;
                }
                long d = com.baidu.adp.lib.g.b.d(optString, 0L);
                for (int i2 = 0; i2 < this.etS.thread_info.size(); i2++) {
                    ConcernData concernData = this.etS.thread_info.get(i2);
                    if (concernData != null && (threadInfo = concernData.thread_list) != null && threadInfo.tid != null && threadInfo.tid.longValue() == d) {
                        this.etS.thread_info.remove(i2);
                        awE();
                        return;
                    }
                }
            }
        }
    }
}
