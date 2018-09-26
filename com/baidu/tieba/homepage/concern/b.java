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
/* loaded from: classes2.dex */
public class b {
    private View.OnTouchListener aMz;
    private t aZW;
    private com.baidu.tieba.f.a dNM;
    private LongSparseArray<com.baidu.tieba.homepage.concern.b.b> dYD;
    private com.baidu.tieba.homepage.concern.b.a eaj;
    private com.baidu.tieba.homepage.concern.b.b eak;
    private DataRes.Builder eal;
    private final com.baidu.tieba.homepage.concern.a ean;
    private final com.baidu.tieba.homepage.concern.c.a eao;
    private int eap;
    private boolean hasMore;
    private final BdTypeListView mListView;
    private String pageTag;
    private a eai = null;
    private final List<h> mDataList = new LinkedList();
    private boolean mIsLoading = false;
    private boolean eam = false;
    private boolean mIsBackground = false;
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.homepage.concern.b.1
        private int ear = 0;

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (b.this.aZW != null && !b.this.mIsBackground) {
                b.this.aZW.g(absListView, i);
            }
            if (i == 0) {
                v.akM().Up();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (b.this.aZW != null && !b.this.mIsBackground) {
                b.this.aZW.onScroll(this.ear, i);
            }
            this.ear = i;
        }
    };
    private View.OnTouchListener aZX = new View.OnTouchListener() { // from class: com.baidu.tieba.homepage.concern.b.2
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (b.this.aMz != null) {
                b.this.aMz.onTouch(view, motionEvent);
            }
            if (b.this.dNM != null) {
                b.this.dNM.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private a.InterfaceC0145a bPQ = new a.InterfaceC0145a() { // from class: com.baidu.tieba.homepage.concern.b.3
        @Override // com.baidu.tieba.f.a.InterfaceC0145a
        public void ac(int i, int i2) {
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0145a
        public void ad(int i, int i2) {
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0145a
        public void ae(int i, int i2) {
        }
    };
    private CustomMessageListener eaq = new CustomMessageListener(2016488) { // from class: com.baidu.tieba.homepage.concern.b.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.this.h(customResponsedMessage);
        }
    };
    private CustomMessageListener dKX = new CustomMessageListener(2016553) { // from class: com.baidu.tieba.homepage.concern.b.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.this.h(customResponsedMessage);
        }
    };

    /* loaded from: classes2.dex */
    public interface a {
        void C(boolean z, boolean z2);

        void aFw();

        void aFx();

        void nY(String str);

        void onError(int i, String str);
    }

    public void setTabInForeBackgroundState(boolean z) {
        this.mIsBackground = z;
    }

    public void ga(boolean z) {
        this.mIsBackground = z;
    }

    public b(e<?> eVar, BdTypeListView bdTypeListView, com.baidu.tieba.homepage.concern.a aVar) {
        this.mListView = bdTypeListView;
        this.mListView.setOnTouchListener(this.aZX);
        this.dNM = new com.baidu.tieba.f.a();
        this.eao = new com.baidu.tieba.homepage.concern.c.a();
        this.dNM.a(this.bPQ);
        this.ean = aVar;
        bdTypeListView.setOnScrollListener(this.mOnScrollListener);
    }

    public void l(BdUniqueId bdUniqueId) {
        this.eaq.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.eaq);
        this.dKX.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.dKX);
    }

    public void setRecommendFrsNavigationAnimDispatcher(u uVar) {
        if (uVar != null) {
            this.aZW = uVar.MQ();
            this.aMz = uVar.MR();
        }
    }

    public void update() {
        if (this.mDataList.size() == 0 && !this.eam) {
            uz();
        } else {
            uy();
        }
    }

    public void aFy() {
        uy();
    }

    public void Vd() {
        if (!BO() && this.hasMore && this.eai != null) {
            setIsLoading(true);
            this.eai.nY(this.pageTag);
        }
    }

    public void a(boolean z, DataRes dataRes, int i, String str) {
        setIsLoading(false);
        this.mListView.completePullRefreshPostDelayed(2000L);
        if (i != 0 || dataRes == null || !a(true, z, dataRes)) {
            if (i == 0 && com.baidu.tbadk.core.util.v.y(this.mDataList) == 0 && this.eai != null) {
                this.eai.aFx();
                return;
            } else if (this.mDataList.size() > 0) {
                if (this.eai != null) {
                    this.eai.onError(1, str);
                    return;
                }
                return;
            } else if (this.eai != null) {
                this.eai.onError(2, str);
                return;
            } else {
                return;
            }
        }
        if (this.eai != null) {
            this.eai.C(z, false);
        }
        aqK();
    }

    public void hf(boolean z) {
        if (z) {
            this.ean.notifyDataSetChanged();
        }
    }

    private void uy() {
        if (this.eai != null) {
            this.eai.aFw();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(DataRes dataRes) {
        this.eam = true;
        if (dataRes != null) {
            if (a(false, true, dataRes)) {
                if (this.eai != null) {
                    this.eai.C(false, true);
                    return;
                }
                return;
            }
            uy();
            return;
        }
        uy();
    }

    private List<h> a(boolean z, DataRes.Builder builder, boolean z2) {
        if (this.eal == null) {
            this.eal = new DataRes.Builder();
        }
        if (builder == null) {
            builder = new DataRes.Builder();
        }
        c a2 = this.eao.a(z, this.eal, builder, z2 ? 0 : 1);
        if (a2 == null) {
            return null;
        }
        return a2.bny;
    }

    private List<h> a(DataRes.Builder builder) {
        if (builder == null || com.baidu.tbadk.core.util.v.z(builder.user_list)) {
            return null;
        }
        bP(builder.user_list);
        ArrayList arrayList = new ArrayList();
        if (!com.baidu.tbadk.core.util.v.z(builder.user_list)) {
            int i = 0;
            for (UserList userList : builder.user_list) {
                if (userList != null) {
                    if (i == 30) {
                        break;
                    }
                    com.baidu.tieba.homepage.concern.b.b bVar = this.dYD.get(userList.id.longValue());
                    if (bVar != null) {
                        arrayList.add(bVar);
                        i++;
                    }
                }
            }
        }
        this.dYD.clear();
        return arrayList;
    }

    private void bP(List<UserList> list) {
        if (this.dYD == null) {
            this.dYD = new LongSparseArray<>();
        }
        for (UserList userList : list) {
            com.baidu.tieba.homepage.concern.b.b a2 = a(userList);
            switch (this.eap) {
                case 2:
                    a2.nc(2);
                    break;
                case 3:
                    a2.nc(3);
                    break;
                case 4:
                    a2.nc(4);
                    break;
            }
            if (a2 != null) {
                this.dYD.put(userList.id.longValue(), a2);
            }
        }
    }

    private com.baidu.tieba.homepage.concern.b.b a(UserList userList) {
        com.baidu.tieba.homepage.concern.b.b bVar = new com.baidu.tieba.homepage.concern.b.b();
        bVar.eaW = new com.baidu.tieba.homepage.concern.b.c();
        bVar.eaW.b(userList);
        bVar.dhr = new bb();
        bVar.dhr.a(userList.thread_info);
        bVar.aFB();
        if (bVar.dhr.isLinkThread()) {
            bVar.isLinkThread = true;
        }
        if (StringUtils.isNull(bVar.eaW.getName()) || bVar.eaW.getId() == 0 || StringUtils.isNull(bVar.dhr.getTid()) || StringUtils.isNull(bVar.dhr.getId())) {
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
            this.eaj = null;
            this.eak = null;
        }
        DataRes.Builder builder = new DataRes.Builder(dataRes);
        if (dataRes.banner_follow_live != null && dataRes.banner_follow_live._switch.intValue() == 1 && TbadkCoreApplication.isLogin()) {
            com.baidu.tbadk.data.b bVar = new com.baidu.tbadk.data.b();
            bVar.a(dataRes.banner_follow_live);
            if (!com.baidu.tbadk.core.util.v.z(bVar.getList())) {
                this.mDataList.add(bVar);
            }
        }
        if (dataRes.req_unix != null) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("concern_data_res_request_time"), dataRes.req_unix.longValue());
        }
        if (dataRes.top_user_info != null && aFz()) {
            if (!ao.isEmpty(builder.top_tips)) {
                com.baidu.tieba.homepage.concern.b.a aVar = new com.baidu.tieba.homepage.concern.b.a();
                aVar.awG = builder.top_tips;
                this.eaj = aVar;
                this.mDataList.add(aVar);
            }
            com.baidu.tieba.homepage.concern.b.b a2 = a(dataRes.top_user_info);
            a2.nc(1);
            this.eak = a2;
            this.mDataList.add(a2);
        }
        if (dataRes.top_user_info == null && !z2 && this.eak != null && aFz() && this.eaj != null) {
            this.mDataList.add(this.eaj);
            this.mDataList.add(this.eak);
        }
        List<h> a3 = a(z, builder, z2);
        if (a3 != null && TbadkCoreApplication.isLogin()) {
            this.mDataList.addAll(a3);
        }
        if (!ao.isEmpty(builder.user_tips)) {
            com.baidu.tieba.homepage.concern.b.a aVar2 = new com.baidu.tieba.homepage.concern.b.a();
            this.eap = builder.user_tips_type.intValue();
            aVar2.eaR = builder.user_tips_type.intValue();
            aVar2.awG = builder.user_tips;
            aVar2.eaT = true;
            this.mDataList.add(aVar2);
        }
        List<h> a4 = a(builder);
        if (a4 != null) {
            this.mDataList.addAll(a4);
        }
        if (!ao.isEmpty(builder.last_tips)) {
            com.baidu.tieba.homepage.concern.b.a aVar3 = new com.baidu.tieba.homepage.concern.b.a();
            aVar3.awG = builder.last_tips;
            aVar3.eaS = true;
            this.mDataList.add(aVar3);
        }
        this.hasMore = builder.has_more.intValue() == 1;
        if (com.baidu.tbadk.core.util.v.z(this.mDataList)) {
            return false;
        }
        if (z2) {
            this.eal.page_tag = dataRes.page_tag;
            this.eal.has_more = dataRes.has_more;
            this.eal.user_list = dataRes.user_list;
            this.eal.user_tips_type = dataRes.user_tips_type;
            this.eal.user_tips = dataRes.user_tips;
            this.eal.last_tips = dataRes.last_tips;
        }
        this.eal.banner_user_story = dataRes.banner_user_story;
        this.eal.banner_follow_live = dataRes.banner_follow_live;
        this.eal.top_tips = dataRes.top_tips;
        this.eal.top_user_info = dataRes.top_user_info;
        if (this.eap == 2 || this.eap == 3) {
            this.eal.user_tips_type = dataRes.user_tips_type;
            this.eal.user_tips = dataRes.user_tips;
        }
        this.ean.aj(this.mDataList);
        return true;
    }

    private boolean aFz() {
        if (TbadkCoreApplication.isLogin()) {
            if (System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.getInstance().getLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("concern_top_user_user_like_time"), 0L) > 86400000) {
                return true;
            }
        }
        return false;
    }

    private void uz() {
        x.a(new w<DataRes>() { // from class: com.baidu.tieba.homepage.concern.b.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.w
            /* renamed from: aFA */
            public DataRes doInBackground() {
                l<byte[]> W = com.baidu.tbadk.core.c.a.yh().W("tb.concern_page", TbadkCoreApplication.getCurrentAccount());
                if (W == null) {
                    return null;
                }
                byte[] bArr = W.get("0");
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

    private void aqK() {
        if (this.eal != null) {
            DataRes.Builder builder = new DataRes.Builder(this.eal.build(true));
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
                    com.baidu.tbadk.core.c.a.yh().W("tb.concern_page", TbadkCoreApplication.getCurrentAccount()).e("0", builder2.build(true).toByteArray());
                    return null;
                } catch (Exception e) {
                    BdLog.e(e);
                    return null;
                }
            }
        }, null);
    }

    public void a(a aVar) {
        this.eai = aVar;
    }

    private boolean BO() {
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
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.eal != null && com.baidu.tbadk.core.util.v.y(this.eal.thread_info) != 0 && com.baidu.tbadk.core.util.v.y(this.mDataList) != 0) {
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
                        if (cVar.UT() != null && cVar.UT().getTid() != null && cVar.UT().getTid().equals(optString)) {
                            this.mDataList.remove(i);
                            if (this.ean != null) {
                                this.ean.aj(this.mDataList);
                            }
                        }
                    }
                    i++;
                }
                long d = com.baidu.adp.lib.g.b.d(optString, 0L);
                for (int i2 = 0; i2 < this.eal.thread_info.size(); i2++) {
                    ConcernData concernData = this.eal.thread_info.get(i2);
                    if (concernData != null && (threadInfo = concernData.thread_list) != null && threadInfo.tid != null && threadInfo.tid.longValue() == d) {
                        this.eal.thread_info.remove(i2);
                        aqK();
                        return;
                    }
                }
            }
        }
    }
}
