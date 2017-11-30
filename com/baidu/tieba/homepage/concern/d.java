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
    private r aNi;
    private View.OnTouchListener ayE;
    private com.baidu.tieba.e.a daK;
    private LongSparseArray<com.baidu.tieba.homepage.concern.b.b> dle;
    private DataRes.Builder dmN;
    private final com.baidu.tieba.homepage.concern.a dmP;
    private final com.baidu.tieba.homepage.concern.c.a dmQ;
    private int dmR;
    private boolean hasMore;
    private final BdTypeListView mListView;
    private String pageTag;
    private a dmM = null;
    private final List<f> mDataList = new LinkedList();
    private boolean mIsLoading = false;
    private boolean dmO = false;
    private boolean mIsBackground = false;
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.homepage.concern.d.1
        private int dmT = -1;
        private int dmU = 0;
        private boolean dmV = false;

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (d.this.aNi != null && !d.this.mIsBackground) {
                d.this.aNi.onScrollStateChanged(absListView, i);
            }
            if (i == 0) {
                s.abU().NQ();
                this.dmV = false;
                return;
            }
            if (i == 1) {
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (this.dmU > i) {
                this.dmV = true;
            }
            if (d.this.aNi != null && !d.this.mIsBackground) {
                d.this.aNi.a(absListView, this.dmU, i, i2, i3);
            }
            this.dmU = i;
            int i4 = (i + i2) - 1;
            if (!this.dmV && this.dmT != i4) {
                this.dmT = i4;
            }
            if (this.dmV && this.dmT != i) {
                this.dmT = i;
            }
        }
    };
    private View.OnTouchListener aNj = new View.OnTouchListener() { // from class: com.baidu.tieba.homepage.concern.d.2
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (d.this.ayE != null) {
                d.this.ayE.onTouch(view, motionEvent);
            }
            if (d.this.daK != null) {
                d.this.daK.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private a.InterfaceC0083a bHI = new a.InterfaceC0083a() { // from class: com.baidu.tieba.homepage.concern.d.3
        @Override // com.baidu.tieba.e.a.InterfaceC0083a
        public void af(int i, int i2) {
        }

        @Override // com.baidu.tieba.e.a.InterfaceC0083a
        public void ag(int i, int i2) {
        }

        @Override // com.baidu.tieba.e.a.InterfaceC0083a
        public void ah(int i, int i2) {
        }
    };
    private CustomMessageListener dmS = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.homepage.concern.d.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.this.d(customResponsedMessage);
        }
    };
    private CustomMessageListener cYf = new CustomMessageListener(CmdConfigCustom.CMD_THREAD_NOT_EXIST_WHEN_ENTER_PB) { // from class: com.baidu.tieba.homepage.concern.d.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.this.d(customResponsedMessage);
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void atw();

        void lW(String str);

        void onError(int i, String str);

        void y(boolean z, boolean z2);
    }

    public void setTabInForeBackgroundState(boolean z) {
        this.mIsBackground = z;
    }

    public void eW(boolean z) {
        this.mIsBackground = z;
    }

    public d(e<?> eVar, BdTypeListView bdTypeListView, com.baidu.tieba.homepage.concern.a aVar) {
        this.mListView = bdTypeListView;
        this.mListView.setOnTouchListener(this.aNj);
        this.daK = new com.baidu.tieba.e.a();
        this.dmQ = new com.baidu.tieba.homepage.concern.c.a();
        this.daK.a(this.bHI);
        this.dmP = aVar;
        bdTypeListView.setOnScrollListener(this.mOnScrollListener);
    }

    public void m(BdUniqueId bdUniqueId) {
        this.dmS.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.dmS);
        this.cYf.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.cYf);
    }

    public void setRecommendFrsNavigationAnimDispatcher(com.baidu.tbadk.util.s sVar) {
        if (sVar != null) {
            this.aNi = sVar.Hq();
            this.ayE = sVar.Hr();
        }
    }

    public void update() {
        if (this.mDataList.size() == 0 && !this.dmO) {
            atA();
        } else {
            atx();
        }
    }

    public void OI() {
        if (!wC() && this.hasMore && this.dmM != null) {
            setIsLoading(true);
            this.dmM.lW(this.pageTag);
        }
    }

    public void a(boolean z, DataRes dataRes, int i, String str) {
        setIsLoading(false);
        this.mListView.completePullRefreshPostDelayed(2000L);
        if (i != 0 || dataRes == null || !a(true, z, dataRes)) {
            if (this.mDataList.size() > 0) {
                if (this.dmM != null) {
                    this.dmM.onError(1, str);
                    return;
                }
                return;
            } else if (this.dmM != null) {
                this.dmM.onError(2, str);
                return;
            } else {
                return;
            }
        }
        if (this.dmM != null) {
            this.dmM.y(z, false);
        }
        atB();
    }

    public void fT(boolean z) {
        if (z) {
            this.dmP.notifyDataSetChanged();
        }
    }

    private void atx() {
        if (this.dmM != null) {
            this.dmM.atw();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(DataRes dataRes) {
        this.dmO = true;
        if (dataRes != null) {
            if (a(false, true, dataRes)) {
                if (this.dmM != null) {
                    this.dmM.y(false, true);
                    return;
                }
                return;
            }
            atx();
            return;
        }
        atx();
    }

    private List<f> a(boolean z, DataRes.Builder builder, boolean z2) {
        if (this.dmN == null) {
            this.dmN = new DataRes.Builder();
        }
        if (builder == null) {
            builder = new DataRes.Builder();
        }
        com.baidu.tieba.homepage.personalize.model.c a2 = this.dmQ.a(z, this.dmN, builder, z2 ? 0 : 1);
        if (a2 == null) {
            return null;
        }
        return a2.aXC;
    }

    private List<f> a(DataRes.Builder builder) {
        if (builder == null || v.w(builder.user_list)) {
            return null;
        }
        bC(builder.user_list);
        ArrayList arrayList = new ArrayList();
        if (!v.w(builder.user_list)) {
            int i = 0;
            for (UserList userList : builder.user_list) {
                if (userList != null) {
                    if (i == 30) {
                        break;
                    }
                    com.baidu.tieba.homepage.concern.b.b bVar = this.dle.get(userList.id.longValue());
                    if (bVar != null) {
                        arrayList.add(bVar);
                        i++;
                    }
                }
            }
        }
        this.dle.clear();
        return arrayList;
    }

    private void bC(List<UserList> list) {
        if (this.dle == null) {
            this.dle = new LongSparseArray<>();
        }
        for (UserList userList : list) {
            com.baidu.tieba.homepage.concern.b.b a2 = a(userList);
            switch (this.dmR) {
                case 2:
                    a2.lC(2);
                    break;
                case 3:
                    a2.lC(3);
                    break;
                case 4:
                    a2.lC(4);
                    break;
            }
            if (a2 != null) {
                this.dle.put(userList.id.longValue(), a2);
            }
        }
    }

    private com.baidu.tieba.homepage.concern.b.b a(UserList userList) {
        com.baidu.tieba.homepage.concern.b.b bVar = new com.baidu.tieba.homepage.concern.b.b();
        bVar.dnA = new com.baidu.tieba.homepage.concern.b.c();
        bVar.dnA.b(userList);
        bVar.cBr = new bd();
        bVar.cBr.a(userList.thread_info);
        bVar.atD();
        if (bVar.cBr.isLinkThread()) {
            bVar.isLinkThread = true;
        }
        if (StringUtils.isNull(bVar.dnA.getName()) || bVar.dnA.getId() == 0 || StringUtils.isNull(bVar.cBr.getTid()) || StringUtils.isNull(bVar.cBr.getId())) {
            return null;
        }
        return bVar;
    }

    public List<f> getDataList() {
        return this.mDataList;
    }

    public void aty() {
        this.dmP.ae(this.mDataList);
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
        if (dataRes.top_user_info != null && atz()) {
            if (!am.isEmpty(builder.top_tips)) {
                com.baidu.tieba.homepage.concern.b.a aVar = new com.baidu.tieba.homepage.concern.b.a();
                aVar.ajK = builder.top_tips;
                this.mDataList.add(aVar);
            }
            com.baidu.tieba.homepage.concern.b.b a2 = a(dataRes.top_user_info);
            a2.lC(1);
            this.mDataList.add(a2);
        }
        List<f> a3 = a(z, builder, z2);
        if (a3 != null && TbadkCoreApplication.isLogin()) {
            this.mDataList.addAll(a3);
        }
        if (!am.isEmpty(builder.user_tips)) {
            com.baidu.tieba.homepage.concern.b.a aVar2 = new com.baidu.tieba.homepage.concern.b.a();
            this.dmR = builder.user_tips_type.intValue();
            aVar2.dnv = builder.user_tips_type.intValue();
            aVar2.ajK = builder.user_tips;
            aVar2.dnx = true;
            this.mDataList.add(aVar2);
        }
        List<f> a4 = a(builder);
        if (a4 != null) {
            this.mDataList.addAll(a4);
        }
        if (!am.isEmpty(builder.last_tips)) {
            com.baidu.tieba.homepage.concern.b.a aVar3 = new com.baidu.tieba.homepage.concern.b.a();
            aVar3.ajK = builder.last_tips;
            aVar3.dnw = true;
            this.mDataList.add(aVar3);
        }
        this.hasMore = builder.has_more.intValue() == 1;
        if (v.w(this.mDataList)) {
            return false;
        }
        if (z2) {
            this.dmN.page_tag = dataRes.page_tag;
            this.dmN.has_more = dataRes.has_more;
            this.dmN.user_list = dataRes.user_list;
            this.dmN.user_tips_type = dataRes.user_tips_type;
            this.dmN.user_tips = dataRes.user_tips;
            this.dmN.last_tips = dataRes.last_tips;
        }
        this.dmN.banner_user_story = dataRes.banner_user_story;
        this.dmN.top_tips = dataRes.top_tips;
        this.dmN.top_user_info = dataRes.top_user_info;
        if (this.dmR == 2 || this.dmR == 3) {
            this.dmN.user_tips_type = dataRes.user_tips_type;
            this.dmN.user_tips = dataRes.user_tips;
        }
        this.dmP.ae(this.mDataList);
        this.dmP.ato();
        return true;
    }

    private boolean atz() {
        if (TbadkCoreApplication.isLogin()) {
            if (System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.getInstance().getLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("concern_top_user_user_like_time"), 0L) > 86400000) {
                return true;
            }
        }
        return false;
    }

    private void atA() {
        com.baidu.tbadk.util.v.a(new u<DataRes>() { // from class: com.baidu.tieba.homepage.concern.d.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.u
            /* renamed from: atC */
            public DataRes doInBackground() {
                l<byte[]> M = com.baidu.tbadk.core.c.a.tg().M("tb.concern_page", TbadkCoreApplication.getCurrentAccount());
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

    private void atB() {
        if (this.dmN != null) {
            DataRes.Builder builder = new DataRes.Builder(this.dmN.build(true));
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
                    com.baidu.tbadk.core.c.a.tg().M("tb.concern_page", TbadkCoreApplication.getCurrentAccount()).e("0", builder2.build(true).toByteArray());
                    return null;
                } catch (Exception e) {
                    BdLog.e(e);
                    return null;
                }
            }
        }, null);
    }

    public void a(a aVar) {
        this.dmM = aVar;
    }

    private boolean wC() {
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
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.dmN != null && v.v(this.dmN.thread_info) != 0 && v.v(this.mDataList) != 0) {
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
                            if (this.dmP != null) {
                                this.dmP.ae(this.mDataList);
                            }
                        }
                    }
                    i++;
                }
                long c = com.baidu.adp.lib.g.b.c(optString, 0L);
                for (int i2 = 0; i2 < this.dmN.thread_info.size(); i2++) {
                    ConcernData concernData = this.dmN.thread_info.get(i2);
                    if (concernData != null && (threadInfo = concernData.thread_list) != null && threadInfo.tid != null && threadInfo.tid.longValue() == c) {
                        this.dmN.thread_info.remove(i2);
                        atB();
                        return;
                    }
                }
            }
        }
    }
}
