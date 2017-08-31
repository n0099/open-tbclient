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
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.util.h;
import com.baidu.tbadk.util.q;
import com.baidu.tbadk.util.r;
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
    private q aMz;
    private com.baidu.tieba.e.a cGC;
    private LongSparseArray<com.baidu.tieba.homepage.concern.b.b> cRy;
    private DataRes.Builder cYr;
    private final com.baidu.tieba.homepage.concern.a cYt;
    private View.OnTouchListener cYu;
    private final com.baidu.tieba.homepage.concern.c.a cYv;
    private boolean hasMore;
    private final BdTypeListView mListView;
    private String pageTag;
    private a cYq = null;
    private final List<f> mDataList = new LinkedList();
    private boolean mIsLoading = false;
    private boolean cYs = false;
    private boolean cqJ = false;
    private boolean mIsBackground = false;
    private int cYw = 0;
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.homepage.concern.d.1
        private int cYy = -1;
        private int cYz = 0;
        private boolean cYA = false;

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (d.this.aMz != null && !d.this.mIsBackground) {
                d.this.aMz.onScrollStateChanged(absListView, i);
            }
            if (i == 0) {
                u.XY().cC(true);
                this.cYA = false;
                return;
            }
            if (i == 1) {
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (this.cYz > i) {
                this.cYA = true;
            }
            if (d.this.aMz != null && !d.this.mIsBackground) {
                d.this.aMz.a(absListView, this.cYz, i, i2, i3);
            }
            this.cYz = i;
            int i4 = (i + i2) - 1;
            if (!this.cYA && this.cYy != i4) {
                this.cYy = i4;
            }
            if (this.cYA && this.cYy != i) {
                this.cYy = i;
            }
        }
    };
    private View.OnTouchListener aMA = new View.OnTouchListener() { // from class: com.baidu.tieba.homepage.concern.d.2
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (d.this.cYu != null) {
                d.this.cYu.onTouch(view, motionEvent);
            }
            if (d.this.cGC != null) {
                d.this.cGC.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private a.InterfaceC0082a bZO = new a.InterfaceC0082a() { // from class: com.baidu.tieba.homepage.concern.d.3
        @Override // com.baidu.tieba.e.a.InterfaceC0082a
        public void ag(int i, int i2) {
            d.this.cqJ = true;
        }

        @Override // com.baidu.tieba.e.a.InterfaceC0082a
        public void ah(int i, int i2) {
            d.this.cqJ = false;
        }
    };
    private CustomMessageListener cYx = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.homepage.concern.d.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ThreadInfo threadInfo;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && d.this.cYr != null && v.u(d.this.cYr.thread_info) != 0 && v.u(d.this.mDataList) != 0) {
                String optString = ((JSONObject) customResponsedMessage.getData()).optString("tid");
                if (!StringUtils.isNull(optString)) {
                    int i = 0;
                    while (true) {
                        if (i >= d.this.mDataList.size()) {
                            break;
                        }
                        f fVar = (f) d.this.mDataList.get(i);
                        if (fVar instanceof com.baidu.tieba.card.data.c) {
                            com.baidu.tieba.card.data.c cVar = (com.baidu.tieba.card.data.c) fVar;
                            if (cVar.MR() != null && cVar.MR().getTid() != null && cVar.MR().getTid().equals(optString)) {
                                d.this.mDataList.remove(i);
                                if (d.this.cYt != null) {
                                    d.this.cYt.bv(d.this.mDataList);
                                }
                            }
                        }
                        i++;
                    }
                    long c = com.baidu.adp.lib.g.b.c(optString, 0L);
                    for (int i2 = 0; i2 < d.this.cYr.thread_info.size(); i2++) {
                        ConcernData concernData = d.this.cYr.thread_info.get(i2);
                        if (concernData != null && (threadInfo = concernData.thread_list) != null && threadInfo.tid != null && threadInfo.tid.longValue() == c) {
                            d.this.cYr.thread_info.remove(i2);
                            d.this.aqh();
                            return;
                        }
                    }
                }
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void aqd();

        void lI(String str);

        void onError(int i, String str);

        void w(boolean z, boolean z2);
    }

    public void setTabInForeBackgroundState(boolean z) {
        this.mIsBackground = z;
    }

    public void eO(boolean z) {
        this.mIsBackground = z;
    }

    public d(e<?> eVar, BdTypeListView bdTypeListView, com.baidu.tieba.homepage.concern.a aVar) {
        this.mListView = bdTypeListView;
        this.mListView.setOnTouchListener(this.aMA);
        this.cGC = new com.baidu.tieba.e.a();
        this.cYv = new com.baidu.tieba.homepage.concern.c.a();
        this.cGC.a(this.bZO);
        this.cYt = aVar;
        bdTypeListView.setOnScrollListener(this.mOnScrollListener);
    }

    public void n(BdUniqueId bdUniqueId) {
        this.cYx.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.cYx);
    }

    public void setRecommendFrsNavigationAnimDispatcher(r rVar) {
        if (rVar != null) {
            this.aMz = rVar.Ho();
            this.cYu = rVar.Hp();
        }
    }

    public void update() {
        if (this.mDataList.size() == 0 && !this.cYs) {
            aqg();
        } else {
            aqe();
        }
    }

    public void Nf() {
        if (!xa() && this.hasMore && this.cYq != null) {
            setIsLoading(true);
            this.cYq.lI(this.pageTag);
        }
    }

    public void a(boolean z, DataRes dataRes, int i, String str) {
        setIsLoading(false);
        this.mListView.completePullRefreshPostDelayed(2000L);
        if (i != 0 || dataRes == null || !a(true, z, dataRes)) {
            if (this.mDataList.size() > 0) {
                if (this.cYq != null) {
                    this.cYq.onError(1, str);
                    return;
                }
                return;
            } else if (this.cYq != null) {
                this.cYq.onError(2, str);
                return;
            } else {
                return;
            }
        }
        if (this.cYq != null) {
            this.cYq.w(z, false);
        }
        aqh();
    }

    public void fN(boolean z) {
        if (z) {
            this.cYt.notifyDataSetChanged();
        }
    }

    private void aqe() {
        if (this.cYq != null) {
            this.cYq.aqd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(DataRes dataRes) {
        this.cYs = true;
        if (dataRes != null) {
            if (a(false, true, dataRes)) {
                if (this.cYq != null) {
                    this.cYq.w(false, true);
                    return;
                }
                return;
            }
            aqe();
            return;
        }
        aqe();
    }

    private List<f> a(boolean z, DataRes.Builder builder, boolean z2) {
        if (this.cYr == null) {
            this.cYr = new DataRes.Builder();
        }
        if (builder == null) {
            builder = new DataRes.Builder();
        }
        com.baidu.tieba.homepage.personalize.model.c a2 = this.cYv.a(z, this.cYr, builder, z2 ? 0 : 1);
        if (a2 == null) {
            return null;
        }
        List<f> list = a2.aTF;
        this.cYw = a2.ddt;
        return list;
    }

    private List<f> a(DataRes.Builder builder) {
        if (builder == null || v.v(builder.user_list)) {
            return null;
        }
        bp(builder.user_list);
        ArrayList arrayList = new ArrayList();
        if (!v.v(builder.user_list)) {
            int i = 0;
            for (UserList userList : builder.user_list) {
                if (userList != null) {
                    if (i == 30) {
                        break;
                    }
                    com.baidu.tieba.homepage.concern.b.b bVar = this.cRy.get(userList.id.longValue());
                    if (bVar != null) {
                        bVar.aqj();
                        arrayList.add(bVar);
                        i++;
                    }
                }
            }
        }
        this.cRy.clear();
        return arrayList;
    }

    private void bp(List<UserList> list) {
        if (this.cRy == null) {
            this.cRy = new LongSparseArray<>();
        }
        for (UserList userList : list) {
            com.baidu.tieba.homepage.concern.b.b bVar = new com.baidu.tieba.homepage.concern.b.b();
            bVar.cYY = new com.baidu.tieba.homepage.concern.b.c();
            bVar.cYY.a(userList);
            bVar.bdq = new bj();
            bVar.bdq.a(userList.thread_info);
            if (bVar.bdq.isLinkThread()) {
                bVar.isLinkThread = true;
            }
            if (!StringUtils.isNull(bVar.cYY.getName()) && bVar.cYY.getId() != 0 && !StringUtils.isNull(bVar.bdq.getTid()) && !StringUtils.isNull(bVar.bdq.getId())) {
                this.cRy.put(userList.id.longValue(), bVar);
            }
        }
    }

    public List<f> getDataList() {
        return this.mDataList;
    }

    public void aqf() {
        this.cYt.bv(this.mDataList);
    }

    private boolean a(boolean z, boolean z2, DataRes dataRes) {
        if (dataRes == null) {
            return false;
        }
        this.pageTag = dataRes.page_tag;
        this.mDataList.clear();
        DataRes.Builder builder = new DataRes.Builder(dataRes);
        if (dataRes.banner_user_story != null && dataRes.banner_user_story._switch.intValue() == 1 && TbadkCoreApplication.isLogin()) {
            com.baidu.tbadk.data.e eVar = new com.baidu.tbadk.data.e();
            eVar.a(dataRes.banner_user_story, 0L);
            this.mDataList.add(eVar);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_STORY_READ_CACHE, 0L));
        }
        List<f> a2 = a(z, builder, z2);
        if (a2 != null && TbadkCoreApplication.isLogin()) {
            this.mDataList.addAll(a2);
        }
        if (!am.isEmpty(builder.user_tips)) {
            com.baidu.tieba.homepage.concern.b.a aVar = new com.baidu.tieba.homepage.concern.b.a();
            aVar.ajD = builder.user_tips;
            this.mDataList.add(aVar);
        }
        List<f> a3 = a(builder);
        if (a3 != null) {
            this.mDataList.addAll(a3);
        }
        if (!am.isEmpty(builder.last_tips)) {
            com.baidu.tieba.homepage.concern.b.a aVar2 = new com.baidu.tieba.homepage.concern.b.a();
            aVar2.ajD = builder.last_tips;
            aVar2.cYV = true;
            this.mDataList.add(aVar2);
        }
        this.hasMore = builder.has_more.intValue() == 1;
        if (v.v(this.mDataList)) {
            return false;
        }
        if (z2) {
            this.cYr.page_tag = dataRes.page_tag;
            this.cYr.has_more = dataRes.has_more;
            this.cYr.last_tips = dataRes.last_tips;
            this.cYr.user_tips = dataRes.user_tips;
            this.cYr.user_list = dataRes.user_list;
        }
        this.cYr.banner_user_story = dataRes.banner_user_story;
        this.cYt.bv(this.mDataList);
        this.cYt.apV();
        return true;
    }

    private void aqg() {
        com.baidu.tbadk.util.u.a(new t<DataRes>() { // from class: com.baidu.tieba.homepage.concern.d.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.t
            /* renamed from: aqi */
            public DataRes doInBackground() {
                l<byte[]> N = com.baidu.tbadk.core.c.a.tk().N("tb.concern_page", TbadkCoreApplication.getCurrentAccount());
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
        }, new h<DataRes>() { // from class: com.baidu.tieba.homepage.concern.d.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.h
            /* renamed from: b */
            public void onReturnDataInUI(DataRes dataRes) {
                d.this.a(dataRes);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqh() {
        if (this.cYr != null) {
            DataRes.Builder builder = new DataRes.Builder(this.cYr.build(true));
            if (builder.thread_info != null && builder.thread_info.size() > 30) {
                builder.thread_info = builder.thread_info.subList(0, 30);
            }
            b(builder);
        }
    }

    private void b(final DataRes.Builder builder) {
        com.baidu.tbadk.util.u.a(new t<Object>() { // from class: com.baidu.tieba.homepage.concern.d.6
            @Override // com.baidu.tbadk.util.t
            public Object doInBackground() {
                DataRes.Builder builder2 = new DataRes.Builder(builder.build(true));
                try {
                    com.baidu.tbadk.core.c.a.tk().N("tb.concern_page", TbadkCoreApplication.getCurrentAccount()).e("0", builder2.build(true).toByteArray());
                    return null;
                } catch (Exception e) {
                    BdLog.e(e);
                    return null;
                }
            }
        }, null);
    }

    public void a(a aVar) {
        this.cYq = aVar;
    }

    private boolean xa() {
        return this.mIsLoading;
    }

    private void setIsLoading(boolean z) {
        this.mIsLoading = z;
    }

    public boolean hasMore() {
        return this.hasMore;
    }
}
