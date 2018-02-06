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
import com.baidu.adp.widget.ListView.i;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.util.h;
import com.baidu.tbadk.util.r;
import com.baidu.tbadk.util.s;
import com.baidu.tbadk.util.u;
import com.baidu.tieba.e.a;
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
public class d {
    private r bDw;
    private View.OnTouchListener bpx;
    private com.baidu.tieba.e.a dVB;
    private LongSparseArray<com.baidu.tieba.homepage.concern.b.b> eeo;
    private DataRes.Builder efW;
    private final com.baidu.tieba.homepage.concern.a efY;
    private final com.baidu.tieba.homepage.concern.c.a efZ;
    private int ega;
    private boolean hasMore;
    private final BdTypeListView mListView;
    private String pageTag;
    private a efV = null;
    private final List<i> mDataList = new LinkedList();
    private boolean mIsLoading = false;
    private boolean efX = false;
    private boolean mIsBackground = false;
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.homepage.concern.d.1
        private int egc = -1;
        private int egd = 0;
        private boolean ege = false;

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (d.this.bDw != null && !d.this.mIsBackground) {
                d.this.bDw.onScrollStateChanged(absListView, i);
            }
            if (i == 0) {
                com.baidu.tieba.card.r.alt().VX();
                this.ege = false;
                return;
            }
            if (i == 1) {
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (this.egd > i) {
                this.ege = true;
            }
            if (d.this.bDw != null && !d.this.mIsBackground) {
                d.this.bDw.a(absListView, this.egd, i, i2, i3);
            }
            this.egd = i;
            int i4 = (i + i2) - 1;
            if (!this.ege && this.egc != i4) {
                this.egc = i4;
            }
            if (this.ege && this.egc != i) {
                this.egc = i;
            }
        }
    };
    private View.OnTouchListener bDx = new View.OnTouchListener() { // from class: com.baidu.tieba.homepage.concern.d.2
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (d.this.bpx != null) {
                d.this.bpx.onTouch(view, motionEvent);
            }
            if (d.this.dVB != null) {
                d.this.dVB.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private a.InterfaceC0142a cop = new a.InterfaceC0142a() { // from class: com.baidu.tieba.homepage.concern.d.3
        @Override // com.baidu.tieba.e.a.InterfaceC0142a
        public void aY(int i, int i2) {
        }

        @Override // com.baidu.tieba.e.a.InterfaceC0142a
        public void aZ(int i, int i2) {
        }

        @Override // com.baidu.tieba.e.a.InterfaceC0142a
        public void ba(int i, int i2) {
        }
    };
    private CustomMessageListener egb = new CustomMessageListener(2016488) { // from class: com.baidu.tieba.homepage.concern.d.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.this.h(customResponsedMessage);
        }
    };
    private CustomMessageListener dTG = new CustomMessageListener(2016553) { // from class: com.baidu.tieba.homepage.concern.d.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.this.h(customResponsedMessage);
        }
    };

    /* loaded from: classes2.dex */
    public interface a {
        void B(boolean z, boolean z2);

        void aCk();

        void mB(String str);

        void onError(int i, String str);
    }

    public void setTabInForeBackgroundState(boolean z) {
        this.mIsBackground = z;
    }

    public void fS(boolean z) {
        this.mIsBackground = z;
    }

    public d(e<?> eVar, BdTypeListView bdTypeListView, com.baidu.tieba.homepage.concern.a aVar) {
        this.mListView = bdTypeListView;
        this.mListView.setOnTouchListener(this.bDx);
        this.dVB = new com.baidu.tieba.e.a();
        this.efZ = new com.baidu.tieba.homepage.concern.c.a();
        this.dVB.a(this.cop);
        this.efY = aVar;
        bdTypeListView.setOnScrollListener(this.mOnScrollListener);
    }

    public void l(BdUniqueId bdUniqueId) {
        this.egb.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.egb);
        this.dTG.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.dTG);
    }

    public void setRecommendFrsNavigationAnimDispatcher(s sVar) {
        if (sVar != null) {
            this.bDw = sVar.Pl();
            this.bpx = sVar.Pm();
        }
    }

    public void update() {
        if (this.mDataList.size() == 0 && !this.efX) {
            aCn();
        } else {
            aCl();
        }
    }

    public void WO() {
        if (!El() && this.hasMore && this.efV != null) {
            setIsLoading(true);
            this.efV.mB(this.pageTag);
        }
    }

    public void a(boolean z, DataRes dataRes, int i, String str) {
        setIsLoading(false);
        this.mListView.completePullRefreshPostDelayed(2000L);
        if (i != 0 || dataRes == null || !a(true, z, dataRes)) {
            if (this.mDataList.size() > 0) {
                if (this.efV != null) {
                    this.efV.onError(1, str);
                    return;
                }
                return;
            } else if (this.efV != null) {
                this.efV.onError(2, str);
                return;
            } else {
                return;
            }
        }
        if (this.efV != null) {
            this.efV.B(z, false);
        }
        aCo();
    }

    public void gJ(boolean z) {
        if (z) {
            this.efY.notifyDataSetChanged();
        }
    }

    private void aCl() {
        if (this.efV != null) {
            this.efV.aCk();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(DataRes dataRes) {
        this.efX = true;
        if (dataRes != null) {
            if (a(false, true, dataRes)) {
                if (this.efV != null) {
                    this.efV.B(false, true);
                    return;
                }
                return;
            }
            aCl();
            return;
        }
        aCl();
    }

    private List<i> a(boolean z, DataRes.Builder builder, boolean z2) {
        if (this.efW == null) {
            this.efW = new DataRes.Builder();
        }
        if (builder == null) {
            builder = new DataRes.Builder();
        }
        com.baidu.tieba.homepage.personalize.model.c a2 = this.efZ.a(z, this.efW, builder, z2 ? 0 : 1);
        if (a2 == null) {
            return null;
        }
        return a2.bNQ;
    }

    private List<i> a(DataRes.Builder builder) {
        if (builder == null || v.E(builder.user_list)) {
            return null;
        }
        bJ(builder.user_list);
        ArrayList arrayList = new ArrayList();
        if (!v.E(builder.user_list)) {
            int i = 0;
            for (UserList userList : builder.user_list) {
                if (userList != null) {
                    if (i == 30) {
                        break;
                    }
                    com.baidu.tieba.homepage.concern.b.b bVar = this.eeo.get(userList.id.longValue());
                    if (bVar != null) {
                        arrayList.add(bVar);
                        i++;
                    }
                }
            }
        }
        this.eeo.clear();
        return arrayList;
    }

    private void bJ(List<UserList> list) {
        if (this.eeo == null) {
            this.eeo = new LongSparseArray<>();
        }
        for (UserList userList : list) {
            com.baidu.tieba.homepage.concern.b.b a2 = a(userList);
            switch (this.ega) {
                case 2:
                    a2.ou(2);
                    break;
                case 3:
                    a2.ou(3);
                    break;
                case 4:
                    a2.ou(4);
                    break;
            }
            if (a2 != null) {
                this.eeo.put(userList.id.longValue(), a2);
            }
        }
    }

    private com.baidu.tieba.homepage.concern.b.b a(UserList userList) {
        com.baidu.tieba.homepage.concern.b.b bVar = new com.baidu.tieba.homepage.concern.b.b();
        bVar.egJ = new com.baidu.tieba.homepage.concern.b.c();
        bVar.egJ.b(userList);
        bVar.dxT = new bd();
        bVar.dxT.a(userList.thread_info);
        bVar.aCq();
        if (bVar.dxT.isLinkThread()) {
            bVar.isLinkThread = true;
        }
        if (StringUtils.isNull(bVar.egJ.getName()) || bVar.egJ.getId() == 0 || StringUtils.isNull(bVar.dxT.getTid()) || StringUtils.isNull(bVar.dxT.getId())) {
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
            if (!v.E(bVar.getList())) {
                this.mDataList.add(bVar);
            }
        }
        if (dataRes.req_unix != null) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("concern_data_res_request_time"), dataRes.req_unix.longValue());
        }
        if (dataRes.top_user_info != null && aCm()) {
            if (!am.isEmpty(builder.top_tips)) {
                com.baidu.tieba.homepage.concern.b.a aVar = new com.baidu.tieba.homepage.concern.b.a();
                aVar.aZJ = builder.top_tips;
                this.mDataList.add(aVar);
            }
            com.baidu.tieba.homepage.concern.b.b a2 = a(dataRes.top_user_info);
            a2.ou(1);
            this.mDataList.add(a2);
        }
        List<i> a3 = a(z, builder, z2);
        if (a3 != null && TbadkCoreApplication.isLogin()) {
            this.mDataList.addAll(a3);
        }
        if (!am.isEmpty(builder.user_tips)) {
            com.baidu.tieba.homepage.concern.b.a aVar2 = new com.baidu.tieba.homepage.concern.b.a();
            this.ega = builder.user_tips_type.intValue();
            aVar2.egE = builder.user_tips_type.intValue();
            aVar2.aZJ = builder.user_tips;
            aVar2.egG = true;
            this.mDataList.add(aVar2);
        }
        List<i> a4 = a(builder);
        if (a4 != null) {
            this.mDataList.addAll(a4);
        }
        if (!am.isEmpty(builder.last_tips)) {
            com.baidu.tieba.homepage.concern.b.a aVar3 = new com.baidu.tieba.homepage.concern.b.a();
            aVar3.aZJ = builder.last_tips;
            aVar3.egF = true;
            this.mDataList.add(aVar3);
        }
        this.hasMore = builder.has_more.intValue() == 1;
        if (v.E(this.mDataList)) {
            return false;
        }
        if (z2) {
            this.efW.page_tag = dataRes.page_tag;
            this.efW.has_more = dataRes.has_more;
            this.efW.user_list = dataRes.user_list;
            this.efW.user_tips_type = dataRes.user_tips_type;
            this.efW.user_tips = dataRes.user_tips;
            this.efW.last_tips = dataRes.last_tips;
        }
        this.efW.banner_user_story = dataRes.banner_user_story;
        this.efW.banner_follow_live = dataRes.banner_follow_live;
        this.efW.top_tips = dataRes.top_tips;
        this.efW.top_user_info = dataRes.top_user_info;
        if (this.ega == 2 || this.ega == 3) {
            this.efW.user_tips_type = dataRes.user_tips_type;
            this.efW.user_tips = dataRes.user_tips;
        }
        this.efY.ao(this.mDataList);
        return true;
    }

    private boolean aCm() {
        if (TbadkCoreApplication.isLogin()) {
            if (System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.getInstance().getLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("concern_top_user_user_like_time"), 0L) > 86400000) {
                return true;
            }
        }
        return false;
    }

    private void aCn() {
        com.baidu.tbadk.util.v.a(new u<DataRes>() { // from class: com.baidu.tieba.homepage.concern.d.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.u
            /* renamed from: aCp */
            public DataRes doInBackground() {
                l<byte[]> M = com.baidu.tbadk.core.c.a.AQ().M("tb.concern_page", TbadkCoreApplication.getCurrentAccount());
                if (M == null) {
                    return null;
                }
                byte[] bArr = M.get("0");
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
        }, new h<DataRes>() { // from class: com.baidu.tieba.homepage.concern.d.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.h
            /* renamed from: b */
            public void onReturnDataInUI(DataRes dataRes) {
                d.this.a(dataRes);
            }
        });
    }

    private void aCo() {
        if (this.efW != null) {
            DataRes.Builder builder = new DataRes.Builder(this.efW.build(true));
            if (builder.thread_info != null && builder.thread_info.size() > 30) {
                builder.thread_info = builder.thread_info.subList(0, 30);
            }
            b(builder);
        }
    }

    private void b(final DataRes.Builder builder) {
        com.baidu.tbadk.util.v.a(new u<Object>() { // from class: com.baidu.tieba.homepage.concern.d.6
            @Override // com.baidu.tbadk.util.u
            public Object doInBackground() {
                DataRes.Builder builder2 = new DataRes.Builder(builder.build(true));
                try {
                    com.baidu.tbadk.core.c.a.AQ().M("tb.concern_page", TbadkCoreApplication.getCurrentAccount()).e("0", builder2.build(true).toByteArray());
                    return null;
                } catch (Exception e) {
                    BdLog.e(e);
                    return null;
                }
            }
        }, null);
    }

    public void a(a aVar) {
        this.efV = aVar;
    }

    private boolean El() {
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
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.efW != null && v.D(this.efW.thread_info) != 0 && v.D(this.mDataList) != 0) {
            String optString = ((JSONObject) customResponsedMessage.getData()).optString("tid");
            if (!StringUtils.isNull(optString)) {
                int i = 0;
                while (true) {
                    if (i >= this.mDataList.size()) {
                        break;
                    }
                    i iVar = this.mDataList.get(i);
                    if (iVar instanceof com.baidu.tieba.card.data.c) {
                        com.baidu.tieba.card.data.c cVar = (com.baidu.tieba.card.data.c) iVar;
                        if (cVar.WE() != null && cVar.WE().getTid() != null && cVar.WE().getTid().equals(optString)) {
                            this.mDataList.remove(i);
                            if (this.efY != null) {
                                this.efY.ao(this.mDataList);
                            }
                        }
                    }
                    i++;
                }
                long c = com.baidu.adp.lib.g.b.c(optString, 0L);
                for (int i2 = 0; i2 < this.efW.thread_info.size(); i2++) {
                    ConcernData concernData = this.efW.thread_info.get(i2);
                    if (concernData != null && (threadInfo = concernData.thread_list) != null && threadInfo.tid != null && threadInfo.tid.longValue() == c) {
                        this.efW.thread_info.remove(i2);
                        aCo();
                        return;
                    }
                }
            }
        }
    }
}
