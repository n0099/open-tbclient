package com.baidu.tieba.homepage.concern;

import android.support.v4.util.LongSparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AbsListView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.e;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.f;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.util.g;
import com.baidu.tbadk.util.p;
import com.baidu.tbadk.util.q;
import com.baidu.tbadk.util.s;
import com.baidu.tbadk.util.t;
import com.baidu.tieba.card.u;
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
/* loaded from: classes.dex */
public class d {
    private p aLY;
    private View.OnTouchListener axx;
    private com.baidu.tieba.e.a cIn;
    private LongSparseArray<com.baidu.tieba.homepage.concern.b.b> cTy;
    private DataRes.Builder cVG;
    private final com.baidu.tieba.homepage.concern.a cVI;
    private final com.baidu.tieba.homepage.concern.c.a cVJ;
    private int cVL;
    private boolean hasMore;
    private final BdTypeListView mListView;
    private String pageTag;
    private a cVF = null;
    private final List<f> mDataList = new LinkedList();
    private boolean mIsLoading = false;
    private boolean cVH = false;
    private boolean crY = false;
    private boolean mIsBackground = false;
    private int cVK = 0;
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.homepage.concern.d.1
        private int cVN = -1;
        private int cVO = 0;
        private boolean cVP = false;

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (d.this.aLY != null && !d.this.mIsBackground) {
                d.this.aLY.onScrollStateChanged(absListView, i);
            }
            if (i == 0) {
                u.XR().MU();
                this.cVP = false;
                return;
            }
            if (i == 1) {
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (this.cVO > i) {
                this.cVP = true;
            }
            if (d.this.aLY != null && !d.this.mIsBackground) {
                d.this.aLY.a(absListView, this.cVO, i, i2, i3);
            }
            this.cVO = i;
            int i4 = (i + i2) - 1;
            if (!this.cVP && this.cVN != i4) {
                this.cVN = i4;
            }
            if (this.cVP && this.cVN != i) {
                this.cVN = i;
            }
        }
    };
    private View.OnTouchListener aLZ = new View.OnTouchListener() { // from class: com.baidu.tieba.homepage.concern.d.2
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (d.this.axx != null) {
                d.this.axx.onTouch(view, motionEvent);
            }
            if (d.this.cIn != null) {
                d.this.cIn.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private a.InterfaceC0081a caG = new a.InterfaceC0081a() { // from class: com.baidu.tieba.homepage.concern.d.3
        @Override // com.baidu.tieba.e.a.InterfaceC0081a
        public void ao(int i, int i2) {
            d.this.crY = true;
        }

        @Override // com.baidu.tieba.e.a.InterfaceC0081a
        public void ap(int i, int i2) {
            d.this.crY = false;
        }

        @Override // com.baidu.tieba.e.a.InterfaceC0081a
        public void aq(int i, int i2) {
        }
    };
    private CustomMessageListener cVM = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.homepage.concern.d.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.this.d(customResponsedMessage);
        }
    };
    private CustomMessageListener cFv = new CustomMessageListener(CmdConfigCustom.CMD_THREAD_NOT_EXIST_WHEN_ENTER_PB) { // from class: com.baidu.tieba.homepage.concern.d.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.this.d(customResponsedMessage);
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void aoS();

        void lo(String str);

        void onError(int i, String str);

        void x(boolean z, boolean z2);
    }

    public void setTabInForeBackgroundState(boolean z) {
        this.mIsBackground = z;
    }

    public void eF(boolean z) {
        this.mIsBackground = z;
    }

    public d(e<?> eVar, BdTypeListView bdTypeListView, com.baidu.tieba.homepage.concern.a aVar) {
        this.mListView = bdTypeListView;
        this.mListView.setOnTouchListener(this.aLZ);
        this.cIn = new com.baidu.tieba.e.a();
        this.cVJ = new com.baidu.tieba.homepage.concern.c.a();
        this.cIn.a(this.caG);
        this.cVI = aVar;
        bdTypeListView.setOnScrollListener(this.mOnScrollListener);
    }

    public void m(BdUniqueId bdUniqueId) {
        this.cVM.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.cVM);
        this.cFv.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.cFv);
    }

    public void setRecommendFrsNavigationAnimDispatcher(q qVar) {
        if (qVar != null) {
            this.aLY = qVar.GS();
            this.axx = qVar.GT();
        }
    }

    public void update() {
        if (this.mDataList.size() == 0 && !this.cVH) {
            aoW();
        } else {
            aoT();
        }
    }

    public void Ny() {
        if (!wz() && this.hasMore && this.cVF != null) {
            setIsLoading(true);
            this.cVF.lo(this.pageTag);
        }
    }

    public void a(boolean z, DataRes dataRes, int i, String str) {
        setIsLoading(false);
        this.mListView.completePullRefreshPostDelayed(2000L);
        if (i != 0 || dataRes == null || !a(true, z, dataRes)) {
            if (this.mDataList.size() > 0) {
                if (this.cVF != null) {
                    this.cVF.onError(1, str);
                    return;
                }
                return;
            } else if (this.cVF != null) {
                this.cVF.onError(2, str);
                return;
            } else {
                return;
            }
        }
        if (this.cVF != null) {
            this.cVF.x(z, false);
        }
        aoX();
    }

    public void fA(boolean z) {
        if (z) {
            this.cVI.notifyDataSetChanged();
        }
    }

    private void aoT() {
        if (this.cVF != null) {
            this.cVF.aoS();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(DataRes dataRes) {
        this.cVH = true;
        if (dataRes != null) {
            if (a(false, true, dataRes)) {
                if (this.cVF != null) {
                    this.cVF.x(false, true);
                    return;
                }
                return;
            }
            aoT();
            return;
        }
        aoT();
    }

    private List<f> a(boolean z, DataRes.Builder builder, boolean z2) {
        if (this.cVG == null) {
            this.cVG = new DataRes.Builder();
        }
        if (builder == null) {
            builder = new DataRes.Builder();
        }
        com.baidu.tieba.homepage.personalize.model.c a2 = this.cVJ.a(z, this.cVG, builder, z2 ? 0 : 1);
        if (a2 == null) {
            return null;
        }
        List<f> list = a2.aUB;
        this.cVK = a2.daE;
        return list;
    }

    private List<f> a(DataRes.Builder builder) {
        if (builder == null || v.u(builder.user_list)) {
            return null;
        }
        bq(builder.user_list);
        ArrayList arrayList = new ArrayList();
        if (!v.u(builder.user_list)) {
            int i = 0;
            for (UserList userList : builder.user_list) {
                if (userList != null) {
                    if (i == 30) {
                        break;
                    }
                    com.baidu.tieba.homepage.concern.b.b bVar = this.cTy.get(userList.id.longValue());
                    if (bVar != null) {
                        arrayList.add(bVar);
                        i++;
                    }
                }
            }
        }
        this.cTy.clear();
        return arrayList;
    }

    private void bq(List<UserList> list) {
        if (this.cTy == null) {
            this.cTy = new LongSparseArray<>();
        }
        for (UserList userList : list) {
            com.baidu.tieba.homepage.concern.b.b a2 = a(userList);
            switch (this.cVL) {
                case 2:
                    a2.kN(2);
                    break;
                case 3:
                    a2.kN(3);
                    break;
                case 4:
                    a2.kN(4);
                    break;
            }
            if (a2 != null) {
                this.cTy.put(userList.id.longValue(), a2);
            }
        }
    }

    private com.baidu.tieba.homepage.concern.b.b a(UserList userList) {
        com.baidu.tieba.homepage.concern.b.b bVar = new com.baidu.tieba.homepage.concern.b.b();
        bVar.cWv = new com.baidu.tieba.homepage.concern.b.c();
        bVar.cWv.b(userList);
        bVar.bfa = new bh();
        bVar.bfa.a(userList.thread_info);
        bVar.aoZ();
        if (bVar.bfa.isLinkThread()) {
            bVar.isLinkThread = true;
        }
        if (StringUtils.isNull(bVar.cWv.getName()) || bVar.cWv.getId() == 0 || StringUtils.isNull(bVar.bfa.getTid()) || StringUtils.isNull(bVar.bfa.getId())) {
            return null;
        }
        return bVar;
    }

    public List<f> getDataList() {
        return this.mDataList;
    }

    public void aoU() {
        this.cVI.br(this.mDataList);
    }

    private boolean a(boolean z, boolean z2, DataRes dataRes) {
        if (dataRes == null) {
            return false;
        }
        this.pageTag = dataRes.page_tag;
        this.mDataList.clear();
        DataRes.Builder builder = new DataRes.Builder(dataRes);
        if (dataRes.banner_user_story != null && dataRes.banner_user_story._switch.intValue() == 1 && TbadkCoreApplication.isLogin()) {
            com.baidu.tbadk.data.d dVar = new com.baidu.tbadk.data.d();
            dVar.a(dataRes.banner_user_story, 0L);
            this.mDataList.add(dVar);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_STORY_READ_CACHE, 0L));
        }
        if (dataRes.req_unix != null) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("concern_data_res_request_time"), dataRes.req_unix.longValue());
        }
        if (dataRes.top_user_info != null && aoV()) {
            if (!am.isEmpty(builder.top_tips)) {
                com.baidu.tieba.homepage.concern.b.a aVar = new com.baidu.tieba.homepage.concern.b.a();
                aVar.aje = builder.top_tips;
                this.mDataList.add(aVar);
            }
            com.baidu.tieba.homepage.concern.b.b a2 = a(dataRes.top_user_info);
            a2.kN(1);
            this.mDataList.add(a2);
        }
        List<f> a3 = a(z, builder, z2);
        if (a3 != null && TbadkCoreApplication.isLogin()) {
            this.mDataList.addAll(a3);
        }
        if (!am.isEmpty(builder.user_tips)) {
            com.baidu.tieba.homepage.concern.b.a aVar2 = new com.baidu.tieba.homepage.concern.b.a();
            this.cVL = builder.user_tips_type.intValue();
            aVar2.cWq = builder.user_tips_type.intValue();
            aVar2.aje = builder.user_tips;
            aVar2.cWs = true;
            this.mDataList.add(aVar2);
        }
        List<f> a4 = a(builder);
        if (a4 != null) {
            this.mDataList.addAll(a4);
        }
        if (!am.isEmpty(builder.last_tips)) {
            com.baidu.tieba.homepage.concern.b.a aVar3 = new com.baidu.tieba.homepage.concern.b.a();
            aVar3.aje = builder.last_tips;
            aVar3.cWr = true;
            this.mDataList.add(aVar3);
        }
        this.hasMore = builder.has_more.intValue() == 1;
        if (v.u(this.mDataList)) {
            return false;
        }
        if (z2) {
            this.cVG.page_tag = dataRes.page_tag;
            this.cVG.has_more = dataRes.has_more;
            this.cVG.user_list = dataRes.user_list;
            this.cVG.user_tips_type = dataRes.user_tips_type;
            this.cVG.user_tips = dataRes.user_tips;
            this.cVG.last_tips = dataRes.last_tips;
        }
        this.cVG.banner_user_story = dataRes.banner_user_story;
        this.cVG.top_tips = dataRes.top_tips;
        this.cVG.top_user_info = dataRes.top_user_info;
        if (this.cVL == 2 || this.cVL == 3) {
            this.cVG.user_tips_type = dataRes.user_tips_type;
            this.cVG.user_tips = dataRes.user_tips;
        }
        this.cVI.br(this.mDataList);
        this.cVI.aoJ();
        return true;
    }

    private boolean aoV() {
        if (TbadkCoreApplication.isLogin()) {
            if (System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.getInstance().getLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("concern_top_user_user_like_time"), 0L) > 86400000) {
                return true;
            }
        }
        return false;
    }

    private void aoW() {
        t.a(new s<DataRes>() { // from class: com.baidu.tieba.homepage.concern.d.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.s
            /* renamed from: aoY */
            public DataRes doInBackground() {
                l<byte[]> N = com.baidu.tbadk.core.c.a.te().N("tb.concern_page", TbadkCoreApplication.getCurrentAccount());
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
        }, new g<DataRes>() { // from class: com.baidu.tieba.homepage.concern.d.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.g
            /* renamed from: b */
            public void onReturnDataInUI(DataRes dataRes) {
                d.this.a(dataRes);
            }
        });
    }

    private void aoX() {
        if (this.cVG != null) {
            DataRes.Builder builder = new DataRes.Builder(this.cVG.build(true));
            if (builder.thread_info != null && builder.thread_info.size() > 30) {
                builder.thread_info = builder.thread_info.subList(0, 30);
            }
            b(builder);
        }
    }

    private void b(final DataRes.Builder builder) {
        t.a(new s<Object>() { // from class: com.baidu.tieba.homepage.concern.d.6
            @Override // com.baidu.tbadk.util.s
            public Object doInBackground() {
                DataRes.Builder builder2 = new DataRes.Builder(builder.build(true));
                try {
                    com.baidu.tbadk.core.c.a.te().N("tb.concern_page", TbadkCoreApplication.getCurrentAccount()).e("0", builder2.build(true).toByteArray());
                    return null;
                } catch (Exception e) {
                    BdLog.e(e);
                    return null;
                }
            }
        }, null);
    }

    public void a(a aVar) {
        this.cVF = aVar;
    }

    private boolean wz() {
        return this.mIsLoading;
    }

    private void setIsLoading(boolean z) {
        this.mIsLoading = z;
    }

    public boolean hasMore() {
        return this.hasMore;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(CustomResponsedMessage<?> customResponsedMessage) {
        ThreadInfo threadInfo;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.cVG != null && v.t(this.cVG.thread_info) != 0 && v.t(this.mDataList) != 0) {
            String optString = ((JSONObject) customResponsedMessage.getData()).optString("tid");
            if (!StringUtils.isNull(optString)) {
                int i = 0;
                while (true) {
                    if (i >= this.mDataList.size()) {
                        break;
                    }
                    f fVar = this.mDataList.get(i);
                    if (fVar instanceof com.baidu.tieba.card.data.c) {
                        com.baidu.tieba.card.data.c cVar = (com.baidu.tieba.card.data.c) fVar;
                        if (cVar.Nj() != null && cVar.Nj().getTid() != null && cVar.Nj().getTid().equals(optString)) {
                            this.mDataList.remove(i);
                            if (this.cVI != null) {
                                this.cVI.br(this.mDataList);
                            }
                        }
                    }
                    i++;
                }
                long c = com.baidu.adp.lib.g.b.c(optString, 0L);
                for (int i2 = 0; i2 < this.cVG.thread_info.size(); i2++) {
                    ConcernData concernData = this.cVG.thread_info.get(i2);
                    if (concernData != null && (threadInfo = concernData.thread_list) != null && threadInfo.tid != null && threadInfo.tid.longValue() == c) {
                        this.cVG.thread_info.remove(i2);
                        aoX();
                        return;
                    }
                }
            }
        }
    }
}
