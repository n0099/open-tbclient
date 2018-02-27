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
    private r bDj;
    private View.OnTouchListener bpk;
    private com.baidu.tieba.e.a dVp;
    private LongSparseArray<com.baidu.tieba.homepage.concern.b.b> eec;
    private DataRes.Builder efK;
    private final com.baidu.tieba.homepage.concern.a efM;
    private final com.baidu.tieba.homepage.concern.c.a efN;
    private int efO;
    private boolean hasMore;
    private final BdTypeListView mListView;
    private String pageTag;
    private a efJ = null;
    private final List<i> mDataList = new LinkedList();
    private boolean mIsLoading = false;
    private boolean efL = false;
    private boolean mIsBackground = false;
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.homepage.concern.d.1
        private int efQ = -1;
        private int efR = 0;
        private boolean efS = false;

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (d.this.bDj != null && !d.this.mIsBackground) {
                d.this.bDj.onScrollStateChanged(absListView, i);
            }
            if (i == 0) {
                com.baidu.tieba.card.r.als().VW();
                this.efS = false;
                return;
            }
            if (i == 1) {
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (this.efR > i) {
                this.efS = true;
            }
            if (d.this.bDj != null && !d.this.mIsBackground) {
                d.this.bDj.a(absListView, this.efR, i, i2, i3);
            }
            this.efR = i;
            int i4 = (i + i2) - 1;
            if (!this.efS && this.efQ != i4) {
                this.efQ = i4;
            }
            if (this.efS && this.efQ != i) {
                this.efQ = i;
            }
        }
    };
    private View.OnTouchListener bDk = new View.OnTouchListener() { // from class: com.baidu.tieba.homepage.concern.d.2
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (d.this.bpk != null) {
                d.this.bpk.onTouch(view, motionEvent);
            }
            if (d.this.dVp != null) {
                d.this.dVp.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private a.InterfaceC0143a cod = new a.InterfaceC0143a() { // from class: com.baidu.tieba.homepage.concern.d.3
        @Override // com.baidu.tieba.e.a.InterfaceC0143a
        public void aY(int i, int i2) {
        }

        @Override // com.baidu.tieba.e.a.InterfaceC0143a
        public void aZ(int i, int i2) {
        }

        @Override // com.baidu.tieba.e.a.InterfaceC0143a
        public void ba(int i, int i2) {
        }
    };
    private CustomMessageListener efP = new CustomMessageListener(2016488) { // from class: com.baidu.tieba.homepage.concern.d.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.this.h(customResponsedMessage);
        }
    };
    private CustomMessageListener dTu = new CustomMessageListener(2016553) { // from class: com.baidu.tieba.homepage.concern.d.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.this.h(customResponsedMessage);
        }
    };

    /* loaded from: classes2.dex */
    public interface a {
        void B(boolean z, boolean z2);

        void aCj();

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
        this.mListView.setOnTouchListener(this.bDk);
        this.dVp = new com.baidu.tieba.e.a();
        this.efN = new com.baidu.tieba.homepage.concern.c.a();
        this.dVp.a(this.cod);
        this.efM = aVar;
        bdTypeListView.setOnScrollListener(this.mOnScrollListener);
    }

    public void l(BdUniqueId bdUniqueId) {
        this.efP.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.efP);
        this.dTu.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.dTu);
    }

    public void setRecommendFrsNavigationAnimDispatcher(s sVar) {
        if (sVar != null) {
            this.bDj = sVar.Pk();
            this.bpk = sVar.Pl();
        }
    }

    public void update() {
        if (this.mDataList.size() == 0 && !this.efL) {
            aCm();
        } else {
            aCk();
        }
    }

    public void WN() {
        if (!Ek() && this.hasMore && this.efJ != null) {
            setIsLoading(true);
            this.efJ.mB(this.pageTag);
        }
    }

    public void a(boolean z, DataRes dataRes, int i, String str) {
        setIsLoading(false);
        this.mListView.completePullRefreshPostDelayed(2000L);
        if (i != 0 || dataRes == null || !a(true, z, dataRes)) {
            if (this.mDataList.size() > 0) {
                if (this.efJ != null) {
                    this.efJ.onError(1, str);
                    return;
                }
                return;
            } else if (this.efJ != null) {
                this.efJ.onError(2, str);
                return;
            } else {
                return;
            }
        }
        if (this.efJ != null) {
            this.efJ.B(z, false);
        }
        aCn();
    }

    public void gJ(boolean z) {
        if (z) {
            this.efM.notifyDataSetChanged();
        }
    }

    private void aCk() {
        if (this.efJ != null) {
            this.efJ.aCj();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(DataRes dataRes) {
        this.efL = true;
        if (dataRes != null) {
            if (a(false, true, dataRes)) {
                if (this.efJ != null) {
                    this.efJ.B(false, true);
                    return;
                }
                return;
            }
            aCk();
            return;
        }
        aCk();
    }

    private List<i> a(boolean z, DataRes.Builder builder, boolean z2) {
        if (this.efK == null) {
            this.efK = new DataRes.Builder();
        }
        if (builder == null) {
            builder = new DataRes.Builder();
        }
        com.baidu.tieba.homepage.personalize.model.c a2 = this.efN.a(z, this.efK, builder, z2 ? 0 : 1);
        if (a2 == null) {
            return null;
        }
        return a2.bND;
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
                    com.baidu.tieba.homepage.concern.b.b bVar = this.eec.get(userList.id.longValue());
                    if (bVar != null) {
                        arrayList.add(bVar);
                        i++;
                    }
                }
            }
        }
        this.eec.clear();
        return arrayList;
    }

    private void bJ(List<UserList> list) {
        if (this.eec == null) {
            this.eec = new LongSparseArray<>();
        }
        for (UserList userList : list) {
            com.baidu.tieba.homepage.concern.b.b a2 = a(userList);
            switch (this.efO) {
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
                this.eec.put(userList.id.longValue(), a2);
            }
        }
    }

    private com.baidu.tieba.homepage.concern.b.b a(UserList userList) {
        com.baidu.tieba.homepage.concern.b.b bVar = new com.baidu.tieba.homepage.concern.b.b();
        bVar.egx = new com.baidu.tieba.homepage.concern.b.c();
        bVar.egx.b(userList);
        bVar.dxH = new bd();
        bVar.dxH.a(userList.thread_info);
        bVar.aCp();
        if (bVar.dxH.isLinkThread()) {
            bVar.isLinkThread = true;
        }
        if (StringUtils.isNull(bVar.egx.getName()) || bVar.egx.getId() == 0 || StringUtils.isNull(bVar.dxH.getTid()) || StringUtils.isNull(bVar.dxH.getId())) {
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
        if (dataRes.top_user_info != null && aCl()) {
            if (!am.isEmpty(builder.top_tips)) {
                com.baidu.tieba.homepage.concern.b.a aVar = new com.baidu.tieba.homepage.concern.b.a();
                aVar.aZx = builder.top_tips;
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
            this.efO = builder.user_tips_type.intValue();
            aVar2.egs = builder.user_tips_type.intValue();
            aVar2.aZx = builder.user_tips;
            aVar2.egu = true;
            this.mDataList.add(aVar2);
        }
        List<i> a4 = a(builder);
        if (a4 != null) {
            this.mDataList.addAll(a4);
        }
        if (!am.isEmpty(builder.last_tips)) {
            com.baidu.tieba.homepage.concern.b.a aVar3 = new com.baidu.tieba.homepage.concern.b.a();
            aVar3.aZx = builder.last_tips;
            aVar3.egt = true;
            this.mDataList.add(aVar3);
        }
        this.hasMore = builder.has_more.intValue() == 1;
        if (v.E(this.mDataList)) {
            return false;
        }
        if (z2) {
            this.efK.page_tag = dataRes.page_tag;
            this.efK.has_more = dataRes.has_more;
            this.efK.user_list = dataRes.user_list;
            this.efK.user_tips_type = dataRes.user_tips_type;
            this.efK.user_tips = dataRes.user_tips;
            this.efK.last_tips = dataRes.last_tips;
        }
        this.efK.banner_user_story = dataRes.banner_user_story;
        this.efK.banner_follow_live = dataRes.banner_follow_live;
        this.efK.top_tips = dataRes.top_tips;
        this.efK.top_user_info = dataRes.top_user_info;
        if (this.efO == 2 || this.efO == 3) {
            this.efK.user_tips_type = dataRes.user_tips_type;
            this.efK.user_tips = dataRes.user_tips;
        }
        this.efM.ao(this.mDataList);
        return true;
    }

    private boolean aCl() {
        if (TbadkCoreApplication.isLogin()) {
            if (System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.getInstance().getLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("concern_top_user_user_like_time"), 0L) > 86400000) {
                return true;
            }
        }
        return false;
    }

    private void aCm() {
        com.baidu.tbadk.util.v.a(new u<DataRes>() { // from class: com.baidu.tieba.homepage.concern.d.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.u
            /* renamed from: aCo */
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

    private void aCn() {
        if (this.efK != null) {
            DataRes.Builder builder = new DataRes.Builder(this.efK.build(true));
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
        this.efJ = aVar;
    }

    private boolean Ek() {
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
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.efK != null && v.D(this.efK.thread_info) != 0 && v.D(this.mDataList) != 0) {
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
                        if (cVar.WD() != null && cVar.WD().getTid() != null && cVar.WD().getTid().equals(optString)) {
                            this.mDataList.remove(i);
                            if (this.efM != null) {
                                this.efM.ao(this.mDataList);
                            }
                        }
                    }
                    i++;
                }
                long c = com.baidu.adp.lib.g.b.c(optString, 0L);
                for (int i2 = 0; i2 < this.efK.thread_info.size(); i2++) {
                    ConcernData concernData = this.efK.thread_info.get(i2);
                    if (concernData != null && (threadInfo = concernData.thread_list) != null && threadInfo.tid != null && threadInfo.tid.longValue() == c) {
                        this.efK.thread_info.remove(i2);
                        aCn();
                        return;
                    }
                }
            }
        }
    }
}
