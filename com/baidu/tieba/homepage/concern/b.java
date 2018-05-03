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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.util.r;
import com.baidu.tbadk.util.s;
import com.baidu.tbadk.util.u;
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
    private r aNJ;
    private View.OnTouchListener azM;
    private DataRes.Builder dAD;
    private final com.baidu.tieba.homepage.concern.a dAF;
    private final com.baidu.tieba.homepage.concern.c.a dAG;
    private int dAH;
    private com.baidu.tieba.f.a dqr;
    private LongSparseArray<com.baidu.tieba.homepage.concern.b.b> dyV;
    private boolean hasMore;
    private final BdTypeListView mListView;
    private String pageTag;
    private a dAC = null;
    private final List<h> mDataList = new LinkedList();
    private boolean mIsLoading = false;
    private boolean dAE = false;
    private boolean mIsBackground = false;
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.homepage.concern.b.1
        private int dAJ = -1;
        private int dAK = 0;
        private boolean dAL = false;

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (b.this.aNJ != null && !b.this.mIsBackground) {
                b.this.aNJ.onScrollStateChanged(absListView, i);
            }
            if (i == 0) {
                v.afy().Ox();
                this.dAL = false;
                return;
            }
            if (i == 1) {
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (this.dAK > i) {
                this.dAL = true;
            }
            if (b.this.aNJ != null && !b.this.mIsBackground) {
                b.this.aNJ.a(absListView, this.dAK, i, i2, i3);
            }
            this.dAK = i;
            int i4 = (i + i2) - 1;
            if (!this.dAL && this.dAJ != i4) {
                this.dAJ = i4;
            }
            if (this.dAL && this.dAJ != i) {
                this.dAJ = i;
            }
        }
    };
    private View.OnTouchListener aNK = new View.OnTouchListener() { // from class: com.baidu.tieba.homepage.concern.b.2
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            if (b.this.azM != null) {
                b.this.azM.onTouch(view2, motionEvent);
            }
            if (b.this.dqr != null) {
                b.this.dqr.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private a.InterfaceC0131a byz = new a.InterfaceC0131a() { // from class: com.baidu.tieba.homepage.concern.b.3
        @Override // com.baidu.tieba.f.a.InterfaceC0131a
        public void W(int i, int i2) {
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0131a
        public void X(int i, int i2) {
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0131a
        public void Y(int i, int i2) {
        }
    };
    private CustomMessageListener dAI = new CustomMessageListener(2016488) { // from class: com.baidu.tieba.homepage.concern.b.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.this.h(customResponsedMessage);
        }
    };
    private CustomMessageListener dnK = new CustomMessageListener(2016553) { // from class: com.baidu.tieba.homepage.concern.b.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.this.h(customResponsedMessage);
        }
    };

    /* loaded from: classes2.dex */
    public interface a {
        void axh();

        void mE(String str);

        void onError(int i, String str);

        void x(boolean z, boolean z2);
    }

    public void setTabInForeBackgroundState(boolean z) {
        this.mIsBackground = z;
    }

    public void fx(boolean z) {
        this.mIsBackground = z;
    }

    public b(e<?> eVar, BdTypeListView bdTypeListView, com.baidu.tieba.homepage.concern.a aVar) {
        this.mListView = bdTypeListView;
        this.mListView.setOnTouchListener(this.aNK);
        this.dqr = new com.baidu.tieba.f.a();
        this.dAG = new com.baidu.tieba.homepage.concern.c.a();
        this.dqr.a(this.byz);
        this.dAF = aVar;
        bdTypeListView.setOnScrollListener(this.mOnScrollListener);
    }

    public void l(BdUniqueId bdUniqueId) {
        this.dAI.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.dAI);
        this.dnK.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.dnK);
    }

    public void setRecommendFrsNavigationAnimDispatcher(s sVar) {
        if (sVar != null) {
            this.aNJ = sVar.HN();
            this.azM = sVar.HO();
        }
    }

    public void update() {
        if (this.mDataList.size() == 0 && !this.dAE) {
            axl();
        } else {
            axj();
        }
    }

    public void axi() {
        axj();
    }

    public void Po() {
        if (!wX() && this.hasMore && this.dAC != null) {
            setIsLoading(true);
            this.dAC.mE(this.pageTag);
        }
    }

    public void a(boolean z, DataRes dataRes, int i, String str) {
        setIsLoading(false);
        this.mListView.completePullRefreshPostDelayed(2000L);
        if (i != 0 || dataRes == null || !a(true, z, dataRes)) {
            if (this.mDataList.size() > 0) {
                if (this.dAC != null) {
                    this.dAC.onError(1, str);
                    return;
                }
                return;
            } else if (this.dAC != null) {
                this.dAC.onError(2, str);
                return;
            } else {
                return;
            }
        }
        if (this.dAC != null) {
            this.dAC.x(z, false);
        }
        akU();
    }

    public void go(boolean z) {
        if (z) {
            this.dAF.notifyDataSetChanged();
        }
    }

    private void axj() {
        if (this.dAC != null) {
            this.dAC.axh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(DataRes dataRes) {
        this.dAE = true;
        if (dataRes != null) {
            if (a(false, true, dataRes)) {
                if (this.dAC != null) {
                    this.dAC.x(false, true);
                    return;
                }
                return;
            }
            axj();
            return;
        }
        axj();
    }

    private List<h> a(boolean z, DataRes.Builder builder, boolean z2) {
        if (this.dAD == null) {
            this.dAD = new DataRes.Builder();
        }
        if (builder == null) {
            builder = new DataRes.Builder();
        }
        c a2 = this.dAG.a(z, this.dAD, builder, z2 ? 0 : 1);
        if (a2 == null) {
            return null;
        }
        return a2.aXE;
    }

    private List<h> a(DataRes.Builder builder) {
        if (builder == null || com.baidu.tbadk.core.util.v.w(builder.user_list)) {
            return null;
        }
        bD(builder.user_list);
        ArrayList arrayList = new ArrayList();
        if (!com.baidu.tbadk.core.util.v.w(builder.user_list)) {
            int i = 0;
            for (UserList userList : builder.user_list) {
                if (userList != null) {
                    if (i == 30) {
                        break;
                    }
                    com.baidu.tieba.homepage.concern.b.b bVar = this.dyV.get(userList.id.longValue());
                    if (bVar != null) {
                        arrayList.add(bVar);
                        i++;
                    }
                }
            }
        }
        this.dyV.clear();
        return arrayList;
    }

    private void bD(List<UserList> list) {
        if (this.dyV == null) {
            this.dyV = new LongSparseArray<>();
        }
        for (UserList userList : list) {
            com.baidu.tieba.homepage.concern.b.b a2 = a(userList);
            switch (this.dAH) {
                case 2:
                    a2.lU(2);
                    break;
                case 3:
                    a2.lU(3);
                    break;
                case 4:
                    a2.lU(4);
                    break;
            }
            if (a2 != null) {
                this.dyV.put(userList.id.longValue(), a2);
            }
        }
    }

    private com.baidu.tieba.homepage.concern.b.b a(UserList userList) {
        com.baidu.tieba.homepage.concern.b.b bVar = new com.baidu.tieba.homepage.concern.b.b();
        bVar.dBq = new com.baidu.tieba.homepage.concern.b.c();
        bVar.dBq.b(userList);
        bVar.cQu = new bd();
        bVar.cQu.a(userList.thread_info);
        bVar.axn();
        if (bVar.cQu.isLinkThread()) {
            bVar.isLinkThread = true;
        }
        if (StringUtils.isNull(bVar.dBq.getName()) || bVar.dBq.getId() == 0 || StringUtils.isNull(bVar.cQu.getTid()) || StringUtils.isNull(bVar.cQu.getId())) {
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
            if (!com.baidu.tbadk.core.util.v.w(bVar.getList())) {
                this.mDataList.add(bVar);
            }
        }
        if (dataRes.req_unix != null) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("concern_data_res_request_time"), dataRes.req_unix.longValue());
        }
        if (dataRes.top_user_info != null && axk()) {
            if (!an.isEmpty(builder.top_tips)) {
                com.baidu.tieba.homepage.concern.b.a aVar = new com.baidu.tieba.homepage.concern.b.a();
                aVar.alc = builder.top_tips;
                this.mDataList.add(aVar);
            }
            com.baidu.tieba.homepage.concern.b.b a2 = a(dataRes.top_user_info);
            a2.lU(1);
            this.mDataList.add(a2);
        }
        List<h> a3 = a(z, builder, z2);
        if (a3 != null && TbadkCoreApplication.isLogin()) {
            this.mDataList.addAll(a3);
        }
        if (!an.isEmpty(builder.user_tips)) {
            com.baidu.tieba.homepage.concern.b.a aVar2 = new com.baidu.tieba.homepage.concern.b.a();
            this.dAH = builder.user_tips_type.intValue();
            aVar2.dBl = builder.user_tips_type.intValue();
            aVar2.alc = builder.user_tips;
            aVar2.dBn = true;
            this.mDataList.add(aVar2);
        }
        List<h> a4 = a(builder);
        if (a4 != null) {
            this.mDataList.addAll(a4);
        }
        if (!an.isEmpty(builder.last_tips)) {
            com.baidu.tieba.homepage.concern.b.a aVar3 = new com.baidu.tieba.homepage.concern.b.a();
            aVar3.alc = builder.last_tips;
            aVar3.dBm = true;
            this.mDataList.add(aVar3);
        }
        this.hasMore = builder.has_more.intValue() == 1;
        if (com.baidu.tbadk.core.util.v.w(this.mDataList)) {
            return false;
        }
        if (z2) {
            this.dAD.page_tag = dataRes.page_tag;
            this.dAD.has_more = dataRes.has_more;
            this.dAD.user_list = dataRes.user_list;
            this.dAD.user_tips_type = dataRes.user_tips_type;
            this.dAD.user_tips = dataRes.user_tips;
            this.dAD.last_tips = dataRes.last_tips;
        }
        this.dAD.banner_user_story = dataRes.banner_user_story;
        this.dAD.banner_follow_live = dataRes.banner_follow_live;
        this.dAD.top_tips = dataRes.top_tips;
        this.dAD.top_user_info = dataRes.top_user_info;
        if (this.dAH == 2 || this.dAH == 3) {
            this.dAD.user_tips_type = dataRes.user_tips_type;
            this.dAD.user_tips = dataRes.user_tips;
        }
        this.dAF.af(this.mDataList);
        return true;
    }

    private boolean axk() {
        if (TbadkCoreApplication.isLogin()) {
            if (System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.getInstance().getLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("concern_top_user_user_like_time"), 0L) > 86400000) {
                return true;
            }
        }
        return false;
    }

    private void axl() {
        com.baidu.tbadk.util.v.a(new u<DataRes>() { // from class: com.baidu.tieba.homepage.concern.b.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.u
            /* renamed from: axm */
            public DataRes doInBackground() {
                l<byte[]> N = com.baidu.tbadk.core.c.a.tz().N("tb.concern_page", TbadkCoreApplication.getCurrentAccount());
                if (N == null) {
                    return null;
                }
                byte[] bArr = N.get("0");
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

    private void akU() {
        if (this.dAD != null) {
            DataRes.Builder builder = new DataRes.Builder(this.dAD.build(true));
            if (builder.thread_info != null && builder.thread_info.size() > 30) {
                builder.thread_info = builder.thread_info.subList(0, 30);
            }
            b(builder);
        }
    }

    private void b(final DataRes.Builder builder) {
        com.baidu.tbadk.util.v.a(new u<Object>() { // from class: com.baidu.tieba.homepage.concern.b.6
            @Override // com.baidu.tbadk.util.u
            public Object doInBackground() {
                DataRes.Builder builder2 = new DataRes.Builder(builder.build(true));
                try {
                    com.baidu.tbadk.core.c.a.tz().N("tb.concern_page", TbadkCoreApplication.getCurrentAccount()).e("0", builder2.build(true).toByteArray());
                    return null;
                } catch (Exception e) {
                    BdLog.e(e);
                    return null;
                }
            }
        }, null);
    }

    public void a(a aVar) {
        this.dAC = aVar;
    }

    private boolean wX() {
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
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.dAD != null && com.baidu.tbadk.core.util.v.v(this.dAD.thread_info) != 0 && com.baidu.tbadk.core.util.v.v(this.mDataList) != 0) {
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
                        if (cVar.Pe() != null && cVar.Pe().getTid() != null && cVar.Pe().getTid().equals(optString)) {
                            this.mDataList.remove(i);
                            if (this.dAF != null) {
                                this.dAF.af(this.mDataList);
                            }
                        }
                    }
                    i++;
                }
                long c = com.baidu.adp.lib.g.b.c(optString, 0L);
                for (int i2 = 0; i2 < this.dAD.thread_info.size(); i2++) {
                    ConcernData concernData = this.dAD.thread_info.get(i2);
                    if (concernData != null && (threadInfo = concernData.thread_list) != null && threadInfo.tid != null && threadInfo.tid.longValue() == c) {
                        this.dAD.thread_info.remove(i2);
                        akU();
                        return;
                    }
                }
            }
        }
    }
}
