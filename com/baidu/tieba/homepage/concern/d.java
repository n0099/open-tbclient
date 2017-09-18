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
    private q aMw;
    private com.baidu.tieba.e.a cHw;
    private LongSparseArray<com.baidu.tieba.homepage.concern.b.b> cSs;
    private DataRes.Builder cZl;
    private final com.baidu.tieba.homepage.concern.a cZn;
    private View.OnTouchListener cZo;
    private final com.baidu.tieba.homepage.concern.c.a cZp;
    private boolean hasMore;
    private final BdTypeListView mListView;
    private String pageTag;
    private a cZk = null;
    private final List<f> mDataList = new LinkedList();
    private boolean mIsLoading = false;
    private boolean cZm = false;
    private boolean crC = false;
    private boolean mIsBackground = false;
    private int cZq = 0;
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.homepage.concern.d.1
        private int cZs = -1;
        private int cZt = 0;
        private boolean cZu = false;

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (d.this.aMw != null && !d.this.mIsBackground) {
                d.this.aMw.onScrollStateChanged(absListView, i);
            }
            if (i == 0) {
                u.Yj().cC(true);
                this.cZu = false;
                return;
            }
            if (i == 1) {
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (this.cZt > i) {
                this.cZu = true;
            }
            if (d.this.aMw != null && !d.this.mIsBackground) {
                d.this.aMw.a(absListView, this.cZt, i, i2, i3);
            }
            this.cZt = i;
            int i4 = (i + i2) - 1;
            if (!this.cZu && this.cZs != i4) {
                this.cZs = i4;
            }
            if (this.cZu && this.cZs != i) {
                this.cZs = i;
            }
        }
    };
    private View.OnTouchListener aMx = new View.OnTouchListener() { // from class: com.baidu.tieba.homepage.concern.d.2
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (d.this.cZo != null) {
                d.this.cZo.onTouch(view, motionEvent);
            }
            if (d.this.cHw != null) {
                d.this.cHw.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private a.InterfaceC0081a caG = new a.InterfaceC0081a() { // from class: com.baidu.tieba.homepage.concern.d.3
        @Override // com.baidu.tieba.e.a.InterfaceC0081a
        public void ak(int i, int i2) {
            d.this.crC = true;
        }

        @Override // com.baidu.tieba.e.a.InterfaceC0081a
        public void al(int i, int i2) {
            d.this.crC = false;
        }
    };
    private CustomMessageListener cZr = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.homepage.concern.d.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ThreadInfo threadInfo;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && d.this.cZl != null && v.u(d.this.cZl.thread_info) != 0 && v.u(d.this.mDataList) != 0) {
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
                                if (d.this.cZn != null) {
                                    d.this.cZn.bw(d.this.mDataList);
                                }
                            }
                        }
                        i++;
                    }
                    long c = com.baidu.adp.lib.g.b.c(optString, 0L);
                    for (int i2 = 0; i2 < d.this.cZl.thread_info.size(); i2++) {
                        ConcernData concernData = d.this.cZl.thread_info.get(i2);
                        if (concernData != null && (threadInfo = concernData.thread_list) != null && threadInfo.tid != null && threadInfo.tid.longValue() == c) {
                            d.this.cZl.thread_info.remove(i2);
                            d.this.aqs();
                            return;
                        }
                    }
                }
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void aqo();

        void lK(String str);

        void onError(int i, String str);

        void w(boolean z, boolean z2);
    }

    public void setTabInForeBackgroundState(boolean z) {
        this.mIsBackground = z;
    }

    public void eP(boolean z) {
        this.mIsBackground = z;
    }

    public d(e<?> eVar, BdTypeListView bdTypeListView, com.baidu.tieba.homepage.concern.a aVar) {
        this.mListView = bdTypeListView;
        this.mListView.setOnTouchListener(this.aMx);
        this.cHw = new com.baidu.tieba.e.a();
        this.cZp = new com.baidu.tieba.homepage.concern.c.a();
        this.cHw.a(this.caG);
        this.cZn = aVar;
        bdTypeListView.setOnScrollListener(this.mOnScrollListener);
    }

    public void n(BdUniqueId bdUniqueId) {
        this.cZr.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.cZr);
    }

    public void setRecommendFrsNavigationAnimDispatcher(r rVar) {
        if (rVar != null) {
            this.aMw = rVar.Ho();
            this.cZo = rVar.Hp();
        }
    }

    public void update() {
        if (this.mDataList.size() == 0 && !this.cZm) {
            aqr();
        } else {
            aqp();
        }
    }

    public void Ng() {
        if (!xa() && this.hasMore && this.cZk != null) {
            setIsLoading(true);
            this.cZk.lK(this.pageTag);
        }
    }

    public void a(boolean z, DataRes dataRes, int i, String str) {
        setIsLoading(false);
        this.mListView.completePullRefreshPostDelayed(2000L);
        if (i != 0 || dataRes == null || !a(true, z, dataRes)) {
            if (this.mDataList.size() > 0) {
                if (this.cZk != null) {
                    this.cZk.onError(1, str);
                    return;
                }
                return;
            } else if (this.cZk != null) {
                this.cZk.onError(2, str);
                return;
            } else {
                return;
            }
        }
        if (this.cZk != null) {
            this.cZk.w(z, false);
        }
        aqs();
    }

    public void fO(boolean z) {
        if (z) {
            this.cZn.notifyDataSetChanged();
        }
    }

    private void aqp() {
        if (this.cZk != null) {
            this.cZk.aqo();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(DataRes dataRes) {
        this.cZm = true;
        if (dataRes != null) {
            if (a(false, true, dataRes)) {
                if (this.cZk != null) {
                    this.cZk.w(false, true);
                    return;
                }
                return;
            }
            aqp();
            return;
        }
        aqp();
    }

    private List<f> a(boolean z, DataRes.Builder builder, boolean z2) {
        if (this.cZl == null) {
            this.cZl = new DataRes.Builder();
        }
        if (builder == null) {
            builder = new DataRes.Builder();
        }
        com.baidu.tieba.homepage.personalize.model.c a2 = this.cZp.a(z, this.cZl, builder, z2 ? 0 : 1);
        if (a2 == null) {
            return null;
        }
        List<f> list = a2.aTC;
        this.cZq = a2.dep;
        return list;
    }

    private List<f> a(DataRes.Builder builder) {
        if (builder == null || v.v(builder.user_list)) {
            return null;
        }
        bq(builder.user_list);
        ArrayList arrayList = new ArrayList();
        if (!v.v(builder.user_list)) {
            int i = 0;
            for (UserList userList : builder.user_list) {
                if (userList != null) {
                    if (i == 30) {
                        break;
                    }
                    com.baidu.tieba.homepage.concern.b.b bVar = this.cSs.get(userList.id.longValue());
                    if (bVar != null) {
                        bVar.aqu();
                        arrayList.add(bVar);
                        i++;
                    }
                }
            }
        }
        this.cSs.clear();
        return arrayList;
    }

    private void bq(List<UserList> list) {
        if (this.cSs == null) {
            this.cSs = new LongSparseArray<>();
        }
        for (UserList userList : list) {
            com.baidu.tieba.homepage.concern.b.b bVar = new com.baidu.tieba.homepage.concern.b.b();
            bVar.cZS = new com.baidu.tieba.homepage.concern.b.c();
            bVar.cZS.a(userList);
            bVar.bdn = new bj();
            bVar.bdn.a(userList.thread_info);
            if (bVar.bdn.isLinkThread()) {
                bVar.isLinkThread = true;
            }
            if (!StringUtils.isNull(bVar.cZS.getName()) && bVar.cZS.getId() != 0 && !StringUtils.isNull(bVar.bdn.getTid()) && !StringUtils.isNull(bVar.bdn.getId())) {
                this.cSs.put(userList.id.longValue(), bVar);
            }
        }
    }

    public List<f> getDataList() {
        return this.mDataList;
    }

    public void aqq() {
        this.cZn.bw(this.mDataList);
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
            aVar.ajC = builder.user_tips;
            this.mDataList.add(aVar);
        }
        List<f> a3 = a(builder);
        if (a3 != null) {
            this.mDataList.addAll(a3);
        }
        if (!am.isEmpty(builder.last_tips)) {
            com.baidu.tieba.homepage.concern.b.a aVar2 = new com.baidu.tieba.homepage.concern.b.a();
            aVar2.ajC = builder.last_tips;
            aVar2.cZP = true;
            this.mDataList.add(aVar2);
        }
        this.hasMore = builder.has_more.intValue() == 1;
        if (v.v(this.mDataList)) {
            return false;
        }
        if (z2) {
            this.cZl.page_tag = dataRes.page_tag;
            this.cZl.has_more = dataRes.has_more;
            this.cZl.last_tips = dataRes.last_tips;
            this.cZl.user_tips = dataRes.user_tips;
            this.cZl.user_list = dataRes.user_list;
        }
        this.cZl.banner_user_story = dataRes.banner_user_story;
        this.cZn.bw(this.mDataList);
        this.cZn.aqg();
        return true;
    }

    private void aqr() {
        com.baidu.tbadk.util.u.a(new t<DataRes>() { // from class: com.baidu.tieba.homepage.concern.d.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.t
            /* renamed from: aqt */
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
    public void aqs() {
        if (this.cZl != null) {
            DataRes.Builder builder = new DataRes.Builder(this.cZl.build(true));
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
        this.cZk = aVar;
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
