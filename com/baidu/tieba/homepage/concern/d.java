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
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.util.h;
import com.baidu.tbadk.util.r;
import com.baidu.tbadk.util.u;
import com.baidu.tieba.card.s;
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
    private r aNl;
    private View.OnTouchListener ayJ;
    private com.baidu.tieba.e.a daY;
    private LongSparseArray<com.baidu.tieba.homepage.concern.b.b> dmj;
    private DataRes.Builder dnS;
    private final com.baidu.tieba.homepage.concern.a dnU;
    private final com.baidu.tieba.homepage.concern.c.a dnV;
    private int dnW;
    private boolean hasMore;
    private final BdTypeListView mListView;
    private String pageTag;
    private a dnR = null;
    private final List<f> mDataList = new LinkedList();
    private boolean mIsLoading = false;
    private boolean dnT = false;
    private boolean mIsBackground = false;
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.homepage.concern.d.1
        private int dnY = -1;
        private int dnZ = 0;
        private boolean doa = false;

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (d.this.aNl != null && !d.this.mIsBackground) {
                d.this.aNl.onScrollStateChanged(absListView, i);
            }
            if (i == 0) {
                s.abX().NQ();
                this.doa = false;
                return;
            }
            if (i == 1) {
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (this.dnZ > i) {
                this.doa = true;
            }
            if (d.this.aNl != null && !d.this.mIsBackground) {
                d.this.aNl.a(absListView, this.dnZ, i, i2, i3);
            }
            this.dnZ = i;
            int i4 = (i + i2) - 1;
            if (!this.doa && this.dnY != i4) {
                this.dnY = i4;
            }
            if (this.doa && this.dnY != i) {
                this.dnY = i;
            }
        }
    };
    private View.OnTouchListener aNm = new View.OnTouchListener() { // from class: com.baidu.tieba.homepage.concern.d.2
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (d.this.ayJ != null) {
                d.this.ayJ.onTouch(view, motionEvent);
            }
            if (d.this.daY != null) {
                d.this.daY.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private a.InterfaceC0097a bHM = new a.InterfaceC0097a() { // from class: com.baidu.tieba.homepage.concern.d.3
        @Override // com.baidu.tieba.e.a.InterfaceC0097a
        public void ag(int i, int i2) {
        }

        @Override // com.baidu.tieba.e.a.InterfaceC0097a
        public void ah(int i, int i2) {
        }

        @Override // com.baidu.tieba.e.a.InterfaceC0097a
        public void ai(int i, int i2) {
        }
    };
    private CustomMessageListener dnX = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.homepage.concern.d.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.this.e(customResponsedMessage);
        }
    };
    private CustomMessageListener cYr = new CustomMessageListener(CmdConfigCustom.CMD_THREAD_NOT_EXIST_WHEN_ENTER_PB) { // from class: com.baidu.tieba.homepage.concern.d.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.this.e(customResponsedMessage);
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void atF();

        void lW(String str);

        void onError(int i, String str);

        void y(boolean z, boolean z2);
    }

    public void setTabInForeBackgroundState(boolean z) {
        this.mIsBackground = z;
    }

    public void eX(boolean z) {
        this.mIsBackground = z;
    }

    public d(e<?> eVar, BdTypeListView bdTypeListView, com.baidu.tieba.homepage.concern.a aVar) {
        this.mListView = bdTypeListView;
        this.mListView.setOnTouchListener(this.aNm);
        this.daY = new com.baidu.tieba.e.a();
        this.dnV = new com.baidu.tieba.homepage.concern.c.a();
        this.daY.a(this.bHM);
        this.dnU = aVar;
        bdTypeListView.setOnScrollListener(this.mOnScrollListener);
    }

    public void m(BdUniqueId bdUniqueId) {
        this.dnX.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.dnX);
        this.cYr.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.cYr);
    }

    public void setRecommendFrsNavigationAnimDispatcher(com.baidu.tbadk.util.s sVar) {
        if (sVar != null) {
            this.aNl = sVar.Hr();
            this.ayJ = sVar.Hs();
        }
    }

    public void update() {
        if (this.mDataList.size() == 0 && !this.dnT) {
            atJ();
        } else {
            atG();
        }
    }

    public void OI() {
        if (!wA() && this.hasMore && this.dnR != null) {
            setIsLoading(true);
            this.dnR.lW(this.pageTag);
        }
    }

    public void a(boolean z, DataRes dataRes, int i, String str) {
        setIsLoading(false);
        this.mListView.completePullRefreshPostDelayed(2000L);
        if (i != 0 || dataRes == null || !a(true, z, dataRes)) {
            if (this.mDataList.size() > 0) {
                if (this.dnR != null) {
                    this.dnR.onError(1, str);
                    return;
                }
                return;
            } else if (this.dnR != null) {
                this.dnR.onError(2, str);
                return;
            } else {
                return;
            }
        }
        if (this.dnR != null) {
            this.dnR.y(z, false);
        }
        atK();
    }

    public void fU(boolean z) {
        if (z) {
            this.dnU.notifyDataSetChanged();
        }
    }

    private void atG() {
        if (this.dnR != null) {
            this.dnR.atF();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(DataRes dataRes) {
        this.dnT = true;
        if (dataRes != null) {
            if (a(false, true, dataRes)) {
                if (this.dnR != null) {
                    this.dnR.y(false, true);
                    return;
                }
                return;
            }
            atG();
            return;
        }
        atG();
    }

    private List<f> a(boolean z, DataRes.Builder builder, boolean z2) {
        if (this.dnS == null) {
            this.dnS = new DataRes.Builder();
        }
        if (builder == null) {
            builder = new DataRes.Builder();
        }
        com.baidu.tieba.homepage.personalize.model.c a2 = this.dnV.a(z, this.dnS, builder, z2 ? 0 : 1);
        if (a2 == null) {
            return null;
        }
        return a2.aXE;
    }

    private List<f> a(DataRes.Builder builder) {
        if (builder == null || v.w(builder.user_list)) {
            return null;
        }
        bD(builder.user_list);
        ArrayList arrayList = new ArrayList();
        if (!v.w(builder.user_list)) {
            int i = 0;
            for (UserList userList : builder.user_list) {
                if (userList != null) {
                    if (i == 30) {
                        break;
                    }
                    com.baidu.tieba.homepage.concern.b.b bVar = this.dmj.get(userList.id.longValue());
                    if (bVar != null) {
                        arrayList.add(bVar);
                        i++;
                    }
                }
            }
        }
        this.dmj.clear();
        return arrayList;
    }

    private void bD(List<UserList> list) {
        if (this.dmj == null) {
            this.dmj = new LongSparseArray<>();
        }
        for (UserList userList : list) {
            com.baidu.tieba.homepage.concern.b.b a2 = a(userList);
            switch (this.dnW) {
                case 2:
                    a2.lJ(2);
                    break;
                case 3:
                    a2.lJ(3);
                    break;
                case 4:
                    a2.lJ(4);
                    break;
            }
            if (a2 != null) {
                this.dmj.put(userList.id.longValue(), a2);
            }
        }
    }

    private com.baidu.tieba.homepage.concern.b.b a(UserList userList) {
        com.baidu.tieba.homepage.concern.b.b bVar = new com.baidu.tieba.homepage.concern.b.b();
        bVar.doG = new com.baidu.tieba.homepage.concern.b.c();
        bVar.doG.b(userList);
        bVar.cBz = new bd();
        bVar.cBz.a(userList.thread_info);
        bVar.atM();
        if (bVar.cBz.isLinkThread()) {
            bVar.isLinkThread = true;
        }
        if (StringUtils.isNull(bVar.doG.getName()) || bVar.doG.getId() == 0 || StringUtils.isNull(bVar.cBz.getTid()) || StringUtils.isNull(bVar.cBz.getId())) {
            return null;
        }
        return bVar;
    }

    public List<f> getDataList() {
        return this.mDataList;
    }

    public void atH() {
        this.dnU.ae(this.mDataList);
    }

    private boolean a(boolean z, boolean z2, DataRes dataRes) {
        if (dataRes == null) {
            return false;
        }
        this.pageTag = dataRes.page_tag;
        this.mDataList.clear();
        DataRes.Builder builder = new DataRes.Builder(dataRes);
        if (dataRes.banner_user_story != null && dataRes.banner_user_story._switch.intValue() == 1 && TbadkCoreApplication.isLogin()) {
            com.baidu.tbadk.data.f fVar = new com.baidu.tbadk.data.f();
            fVar.a(dataRes.banner_user_story, 0L, 0L, "", false);
            this.mDataList.add(fVar);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_STORY_READ_CACHE, 0L));
        }
        if (dataRes.req_unix != null) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("concern_data_res_request_time"), dataRes.req_unix.longValue());
        }
        if (dataRes.top_user_info != null && atI()) {
            if (!am.isEmpty(builder.top_tips)) {
                com.baidu.tieba.homepage.concern.b.a aVar = new com.baidu.tieba.homepage.concern.b.a();
                aVar.ajH = builder.top_tips;
                this.mDataList.add(aVar);
            }
            com.baidu.tieba.homepage.concern.b.b a2 = a(dataRes.top_user_info);
            a2.lJ(1);
            this.mDataList.add(a2);
        }
        List<f> a3 = a(z, builder, z2);
        if (a3 != null && TbadkCoreApplication.isLogin()) {
            this.mDataList.addAll(a3);
        }
        if (!am.isEmpty(builder.user_tips)) {
            com.baidu.tieba.homepage.concern.b.a aVar2 = new com.baidu.tieba.homepage.concern.b.a();
            this.dnW = builder.user_tips_type.intValue();
            aVar2.doB = builder.user_tips_type.intValue();
            aVar2.ajH = builder.user_tips;
            aVar2.doD = true;
            this.mDataList.add(aVar2);
        }
        List<f> a4 = a(builder);
        if (a4 != null) {
            this.mDataList.addAll(a4);
        }
        if (!am.isEmpty(builder.last_tips)) {
            com.baidu.tieba.homepage.concern.b.a aVar3 = new com.baidu.tieba.homepage.concern.b.a();
            aVar3.ajH = builder.last_tips;
            aVar3.doC = true;
            this.mDataList.add(aVar3);
        }
        this.hasMore = builder.has_more.intValue() == 1;
        if (v.w(this.mDataList)) {
            return false;
        }
        if (z2) {
            this.dnS.page_tag = dataRes.page_tag;
            this.dnS.has_more = dataRes.has_more;
            this.dnS.user_list = dataRes.user_list;
            this.dnS.user_tips_type = dataRes.user_tips_type;
            this.dnS.user_tips = dataRes.user_tips;
            this.dnS.last_tips = dataRes.last_tips;
        }
        this.dnS.banner_user_story = dataRes.banner_user_story;
        this.dnS.top_tips = dataRes.top_tips;
        this.dnS.top_user_info = dataRes.top_user_info;
        if (this.dnW == 2 || this.dnW == 3) {
            this.dnS.user_tips_type = dataRes.user_tips_type;
            this.dnS.user_tips = dataRes.user_tips;
        }
        this.dnU.ae(this.mDataList);
        this.dnU.atx();
        return true;
    }

    private boolean atI() {
        if (TbadkCoreApplication.isLogin()) {
            if (System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.getInstance().getLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("concern_top_user_user_like_time"), 0L) > 86400000) {
                return true;
            }
        }
        return false;
    }

    private void atJ() {
        com.baidu.tbadk.util.v.a(new u<DataRes>() { // from class: com.baidu.tieba.homepage.concern.d.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.u
            /* renamed from: atL */
            public DataRes doInBackground() {
                l<byte[]> M = com.baidu.tbadk.core.c.a.td().M("tb.concern_page", TbadkCoreApplication.getCurrentAccount());
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

    private void atK() {
        if (this.dnS != null) {
            DataRes.Builder builder = new DataRes.Builder(this.dnS.build(true));
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
                    com.baidu.tbadk.core.c.a.td().M("tb.concern_page", TbadkCoreApplication.getCurrentAccount()).e("0", builder2.build(true).toByteArray());
                    return null;
                } catch (Exception e) {
                    BdLog.e(e);
                    return null;
                }
            }
        }, null);
    }

    public void a(a aVar) {
        this.dnR = aVar;
    }

    private boolean wA() {
        return this.mIsLoading;
    }

    private void setIsLoading(boolean z) {
        this.mIsLoading = z;
    }

    public boolean hasMore() {
        return this.hasMore;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(CustomResponsedMessage<?> customResponsedMessage) {
        ThreadInfo threadInfo;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.dnS != null && v.v(this.dnS.thread_info) != 0 && v.v(this.mDataList) != 0) {
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
                        if (cVar.Ox() != null && cVar.Ox().getTid() != null && cVar.Ox().getTid().equals(optString)) {
                            this.mDataList.remove(i);
                            if (this.dnU != null) {
                                this.dnU.ae(this.mDataList);
                            }
                        }
                    }
                    i++;
                }
                long c = com.baidu.adp.lib.g.b.c(optString, 0L);
                for (int i2 = 0; i2 < this.dnS.thread_info.size(); i2++) {
                    ConcernData concernData = this.dnS.thread_info.get(i2);
                    if (concernData != null && (threadInfo = concernData.thread_list) != null && threadInfo.tid != null && threadInfo.tid.longValue() == c) {
                        this.dnS.thread_info.remove(i2);
                        atK();
                        return;
                    }
                }
            }
        }
    }
}
