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
    private r aNK;
    private View.OnTouchListener azN;
    private LongSparseArray<com.baidu.tieba.homepage.concern.b.b> dAc;
    private DataRes.Builder dBK;
    private final com.baidu.tieba.homepage.concern.a dBM;
    private final com.baidu.tieba.homepage.concern.c.a dBN;
    private int dBO;
    private com.baidu.tieba.f.a drz;
    private boolean hasMore;
    private final BdTypeListView mListView;
    private String pageTag;
    private a dBJ = null;
    private final List<h> mDataList = new LinkedList();
    private boolean mIsLoading = false;
    private boolean dBL = false;
    private boolean mIsBackground = false;
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.homepage.concern.b.1
        private int dBQ = -1;
        private int dBR = 0;
        private boolean dBS = false;

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (b.this.aNK != null && !b.this.mIsBackground) {
                b.this.aNK.onScrollStateChanged(absListView, i);
            }
            if (i == 0) {
                v.afy().Ov();
                this.dBS = false;
                return;
            }
            if (i == 1) {
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (this.dBR > i) {
                this.dBS = true;
            }
            if (b.this.aNK != null && !b.this.mIsBackground) {
                b.this.aNK.a(absListView, this.dBR, i, i2, i3);
            }
            this.dBR = i;
            int i4 = (i + i2) - 1;
            if (!this.dBS && this.dBQ != i4) {
                this.dBQ = i4;
            }
            if (this.dBS && this.dBQ != i) {
                this.dBQ = i;
            }
        }
    };
    private View.OnTouchListener aNL = new View.OnTouchListener() { // from class: com.baidu.tieba.homepage.concern.b.2
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            if (b.this.azN != null) {
                b.this.azN.onTouch(view2, motionEvent);
            }
            if (b.this.drz != null) {
                b.this.drz.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private a.InterfaceC0131a bzs = new a.InterfaceC0131a() { // from class: com.baidu.tieba.homepage.concern.b.3
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
    private CustomMessageListener dBP = new CustomMessageListener(2016488) { // from class: com.baidu.tieba.homepage.concern.b.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.this.h(customResponsedMessage);
        }
    };
    private CustomMessageListener doS = new CustomMessageListener(2016553) { // from class: com.baidu.tieba.homepage.concern.b.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.this.h(customResponsedMessage);
        }
    };

    /* loaded from: classes2.dex */
    public interface a {
        void axg();

        void mH(String str);

        void onError(int i, String str);

        void x(boolean z, boolean z2);
    }

    public void setTabInForeBackgroundState(boolean z) {
        this.mIsBackground = z;
    }

    public void fy(boolean z) {
        this.mIsBackground = z;
    }

    public b(e<?> eVar, BdTypeListView bdTypeListView, com.baidu.tieba.homepage.concern.a aVar) {
        this.mListView = bdTypeListView;
        this.mListView.setOnTouchListener(this.aNL);
        this.drz = new com.baidu.tieba.f.a();
        this.dBN = new com.baidu.tieba.homepage.concern.c.a();
        this.drz.a(this.bzs);
        this.dBM = aVar;
        bdTypeListView.setOnScrollListener(this.mOnScrollListener);
    }

    public void l(BdUniqueId bdUniqueId) {
        this.dBP.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.dBP);
        this.doS.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.doS);
    }

    public void setRecommendFrsNavigationAnimDispatcher(s sVar) {
        if (sVar != null) {
            this.aNK = sVar.HL();
            this.azN = sVar.HM();
        }
    }

    public void update() {
        if (this.mDataList.size() == 0 && !this.dBL) {
            axk();
        } else {
            axi();
        }
    }

    public void axh() {
        axi();
    }

    public void Pl() {
        if (!wW() && this.hasMore && this.dBJ != null) {
            setIsLoading(true);
            this.dBJ.mH(this.pageTag);
        }
    }

    public void a(boolean z, DataRes dataRes, int i, String str) {
        setIsLoading(false);
        this.mListView.completePullRefreshPostDelayed(2000L);
        if (i != 0 || dataRes == null || !a(true, z, dataRes)) {
            if (this.mDataList.size() > 0) {
                if (this.dBJ != null) {
                    this.dBJ.onError(1, str);
                    return;
                }
                return;
            } else if (this.dBJ != null) {
                this.dBJ.onError(2, str);
                return;
            } else {
                return;
            }
        }
        if (this.dBJ != null) {
            this.dBJ.x(z, false);
        }
        akU();
    }

    public void gp(boolean z) {
        if (z) {
            this.dBM.notifyDataSetChanged();
        }
    }

    private void axi() {
        if (this.dBJ != null) {
            this.dBJ.axg();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(DataRes dataRes) {
        this.dBL = true;
        if (dataRes != null) {
            if (a(false, true, dataRes)) {
                if (this.dBJ != null) {
                    this.dBJ.x(false, true);
                    return;
                }
                return;
            }
            axi();
            return;
        }
        axi();
    }

    private List<h> a(boolean z, DataRes.Builder builder, boolean z2) {
        if (this.dBK == null) {
            this.dBK = new DataRes.Builder();
        }
        if (builder == null) {
            builder = new DataRes.Builder();
        }
        c a2 = this.dBN.a(z, this.dBK, builder, z2 ? 0 : 1);
        if (a2 == null) {
            return null;
        }
        return a2.aXF;
    }

    private List<h> a(DataRes.Builder builder) {
        if (builder == null || com.baidu.tbadk.core.util.v.w(builder.user_list)) {
            return null;
        }
        bG(builder.user_list);
        ArrayList arrayList = new ArrayList();
        if (!com.baidu.tbadk.core.util.v.w(builder.user_list)) {
            int i = 0;
            for (UserList userList : builder.user_list) {
                if (userList != null) {
                    if (i == 30) {
                        break;
                    }
                    com.baidu.tieba.homepage.concern.b.b bVar = this.dAc.get(userList.id.longValue());
                    if (bVar != null) {
                        arrayList.add(bVar);
                        i++;
                    }
                }
            }
        }
        this.dAc.clear();
        return arrayList;
    }

    private void bG(List<UserList> list) {
        if (this.dAc == null) {
            this.dAc = new LongSparseArray<>();
        }
        for (UserList userList : list) {
            com.baidu.tieba.homepage.concern.b.b a2 = a(userList);
            switch (this.dBO) {
                case 2:
                    a2.lT(2);
                    break;
                case 3:
                    a2.lT(3);
                    break;
                case 4:
                    a2.lT(4);
                    break;
            }
            if (a2 != null) {
                this.dAc.put(userList.id.longValue(), a2);
            }
        }
    }

    private com.baidu.tieba.homepage.concern.b.b a(UserList userList) {
        com.baidu.tieba.homepage.concern.b.b bVar = new com.baidu.tieba.homepage.concern.b.b();
        bVar.dCx = new com.baidu.tieba.homepage.concern.b.c();
        bVar.dCx.b(userList);
        bVar.cRB = new bd();
        bVar.cRB.a(userList.thread_info);
        bVar.axm();
        if (bVar.cRB.isLinkThread()) {
            bVar.isLinkThread = true;
        }
        if (StringUtils.isNull(bVar.dCx.getName()) || bVar.dCx.getId() == 0 || StringUtils.isNull(bVar.cRB.getTid()) || StringUtils.isNull(bVar.cRB.getId())) {
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
        if (dataRes.top_user_info != null && axj()) {
            if (!an.isEmpty(builder.top_tips)) {
                com.baidu.tieba.homepage.concern.b.a aVar = new com.baidu.tieba.homepage.concern.b.a();
                aVar.alc = builder.top_tips;
                this.mDataList.add(aVar);
            }
            com.baidu.tieba.homepage.concern.b.b a2 = a(dataRes.top_user_info);
            a2.lT(1);
            this.mDataList.add(a2);
        }
        List<h> a3 = a(z, builder, z2);
        if (a3 != null && TbadkCoreApplication.isLogin()) {
            this.mDataList.addAll(a3);
        }
        if (!an.isEmpty(builder.user_tips)) {
            com.baidu.tieba.homepage.concern.b.a aVar2 = new com.baidu.tieba.homepage.concern.b.a();
            this.dBO = builder.user_tips_type.intValue();
            aVar2.dCs = builder.user_tips_type.intValue();
            aVar2.alc = builder.user_tips;
            aVar2.dCu = true;
            this.mDataList.add(aVar2);
        }
        List<h> a4 = a(builder);
        if (a4 != null) {
            this.mDataList.addAll(a4);
        }
        if (!an.isEmpty(builder.last_tips)) {
            com.baidu.tieba.homepage.concern.b.a aVar3 = new com.baidu.tieba.homepage.concern.b.a();
            aVar3.alc = builder.last_tips;
            aVar3.dCt = true;
            this.mDataList.add(aVar3);
        }
        this.hasMore = builder.has_more.intValue() == 1;
        if (com.baidu.tbadk.core.util.v.w(this.mDataList)) {
            return false;
        }
        if (z2) {
            this.dBK.page_tag = dataRes.page_tag;
            this.dBK.has_more = dataRes.has_more;
            this.dBK.user_list = dataRes.user_list;
            this.dBK.user_tips_type = dataRes.user_tips_type;
            this.dBK.user_tips = dataRes.user_tips;
            this.dBK.last_tips = dataRes.last_tips;
        }
        this.dBK.banner_user_story = dataRes.banner_user_story;
        this.dBK.banner_follow_live = dataRes.banner_follow_live;
        this.dBK.top_tips = dataRes.top_tips;
        this.dBK.top_user_info = dataRes.top_user_info;
        if (this.dBO == 2 || this.dBO == 3) {
            this.dBK.user_tips_type = dataRes.user_tips_type;
            this.dBK.user_tips = dataRes.user_tips;
        }
        this.dBM.af(this.mDataList);
        return true;
    }

    private boolean axj() {
        if (TbadkCoreApplication.isLogin()) {
            if (System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.getInstance().getLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("concern_top_user_user_like_time"), 0L) > 86400000) {
                return true;
            }
        }
        return false;
    }

    private void axk() {
        com.baidu.tbadk.util.v.a(new u<DataRes>() { // from class: com.baidu.tieba.homepage.concern.b.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.u
            /* renamed from: axl */
            public DataRes doInBackground() {
                l<byte[]> N = com.baidu.tbadk.core.c.a.ty().N("tb.concern_page", TbadkCoreApplication.getCurrentAccount());
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
        if (this.dBK != null) {
            DataRes.Builder builder = new DataRes.Builder(this.dBK.build(true));
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
                    com.baidu.tbadk.core.c.a.ty().N("tb.concern_page", TbadkCoreApplication.getCurrentAccount()).e("0", builder2.build(true).toByteArray());
                    return null;
                } catch (Exception e) {
                    BdLog.e(e);
                    return null;
                }
            }
        }, null);
    }

    public void a(a aVar) {
        this.dBJ = aVar;
    }

    private boolean wW() {
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
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.dBK != null && com.baidu.tbadk.core.util.v.v(this.dBK.thread_info) != 0 && com.baidu.tbadk.core.util.v.v(this.mDataList) != 0) {
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
                        if (cVar.Pb() != null && cVar.Pb().getTid() != null && cVar.Pb().getTid().equals(optString)) {
                            this.mDataList.remove(i);
                            if (this.dBM != null) {
                                this.dBM.af(this.mDataList);
                            }
                        }
                    }
                    i++;
                }
                long c = com.baidu.adp.lib.g.b.c(optString, 0L);
                for (int i2 = 0; i2 < this.dBK.thread_info.size(); i2++) {
                    ConcernData concernData = this.dBK.thread_info.get(i2);
                    if (concernData != null && (threadInfo = concernData.thread_list) != null && threadInfo.tid != null && threadInfo.tid.longValue() == c) {
                        this.dBK.thread_info.remove(i2);
                        akU();
                        return;
                    }
                }
            }
        }
    }
}
