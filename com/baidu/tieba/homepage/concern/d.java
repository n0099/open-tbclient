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
    private p aLL;
    private View.OnTouchListener axl;
    private com.baidu.tieba.e.a cIb;
    private LongSparseArray<com.baidu.tieba.homepage.concern.b.b> cTm;
    private DataRes.Builder cVu;
    private final com.baidu.tieba.homepage.concern.a cVw;
    private final com.baidu.tieba.homepage.concern.c.a cVx;
    private int cVz;
    private boolean hasMore;
    private final BdTypeListView mListView;
    private String pageTag;
    private a cVt = null;
    private final List<f> mDataList = new LinkedList();
    private boolean mIsLoading = false;
    private boolean cVv = false;
    private boolean crM = false;
    private boolean mIsBackground = false;
    private int cVy = 0;
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.homepage.concern.d.1
        private int cVB = -1;
        private int cVC = 0;
        private boolean cVD = false;

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (d.this.aLL != null && !d.this.mIsBackground) {
                d.this.aLL.onScrollStateChanged(absListView, i);
            }
            if (i == 0) {
                u.XN().MO();
                this.cVD = false;
                return;
            }
            if (i == 1) {
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (this.cVC > i) {
                this.cVD = true;
            }
            if (d.this.aLL != null && !d.this.mIsBackground) {
                d.this.aLL.a(absListView, this.cVC, i, i2, i3);
            }
            this.cVC = i;
            int i4 = (i + i2) - 1;
            if (!this.cVD && this.cVB != i4) {
                this.cVB = i4;
            }
            if (this.cVD && this.cVB != i) {
                this.cVB = i;
            }
        }
    };
    private View.OnTouchListener aLM = new View.OnTouchListener() { // from class: com.baidu.tieba.homepage.concern.d.2
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (d.this.axl != null) {
                d.this.axl.onTouch(view, motionEvent);
            }
            if (d.this.cIb != null) {
                d.this.cIb.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private a.InterfaceC0081a cau = new a.InterfaceC0081a() { // from class: com.baidu.tieba.homepage.concern.d.3
        @Override // com.baidu.tieba.e.a.InterfaceC0081a
        public void ao(int i, int i2) {
            d.this.crM = true;
        }

        @Override // com.baidu.tieba.e.a.InterfaceC0081a
        public void ap(int i, int i2) {
            d.this.crM = false;
        }

        @Override // com.baidu.tieba.e.a.InterfaceC0081a
        public void aq(int i, int i2) {
        }
    };
    private CustomMessageListener cVA = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.homepage.concern.d.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.this.d(customResponsedMessage);
        }
    };
    private CustomMessageListener cFj = new CustomMessageListener(CmdConfigCustom.CMD_THREAD_NOT_EXIST_WHEN_ENTER_PB) { // from class: com.baidu.tieba.homepage.concern.d.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.this.d(customResponsedMessage);
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void aoN();

        void ln(String str);

        void onError(int i, String str);

        void x(boolean z, boolean z2);
    }

    public void setTabInForeBackgroundState(boolean z) {
        this.mIsBackground = z;
    }

    public void eE(boolean z) {
        this.mIsBackground = z;
    }

    public d(e<?> eVar, BdTypeListView bdTypeListView, com.baidu.tieba.homepage.concern.a aVar) {
        this.mListView = bdTypeListView;
        this.mListView.setOnTouchListener(this.aLM);
        this.cIb = new com.baidu.tieba.e.a();
        this.cVx = new com.baidu.tieba.homepage.concern.c.a();
        this.cIb.a(this.cau);
        this.cVw = aVar;
        bdTypeListView.setOnScrollListener(this.mOnScrollListener);
    }

    public void m(BdUniqueId bdUniqueId) {
        this.cVA.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.cVA);
        this.cFj.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.cFj);
    }

    public void setRecommendFrsNavigationAnimDispatcher(q qVar) {
        if (qVar != null) {
            this.aLL = qVar.GM();
            this.axl = qVar.GN();
        }
    }

    public void update() {
        if (this.mDataList.size() == 0 && !this.cVv) {
            aoR();
        } else {
            aoO();
        }
    }

    public void Ns() {
        if (!ws() && this.hasMore && this.cVt != null) {
            setIsLoading(true);
            this.cVt.ln(this.pageTag);
        }
    }

    public void a(boolean z, DataRes dataRes, int i, String str) {
        setIsLoading(false);
        this.mListView.completePullRefreshPostDelayed(2000L);
        if (i != 0 || dataRes == null || !a(true, z, dataRes)) {
            if (this.mDataList.size() > 0) {
                if (this.cVt != null) {
                    this.cVt.onError(1, str);
                    return;
                }
                return;
            } else if (this.cVt != null) {
                this.cVt.onError(2, str);
                return;
            } else {
                return;
            }
        }
        if (this.cVt != null) {
            this.cVt.x(z, false);
        }
        aoS();
    }

    public void fz(boolean z) {
        if (z) {
            this.cVw.notifyDataSetChanged();
        }
    }

    private void aoO() {
        if (this.cVt != null) {
            this.cVt.aoN();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(DataRes dataRes) {
        this.cVv = true;
        if (dataRes != null) {
            if (a(false, true, dataRes)) {
                if (this.cVt != null) {
                    this.cVt.x(false, true);
                    return;
                }
                return;
            }
            aoO();
            return;
        }
        aoO();
    }

    private List<f> a(boolean z, DataRes.Builder builder, boolean z2) {
        if (this.cVu == null) {
            this.cVu = new DataRes.Builder();
        }
        if (builder == null) {
            builder = new DataRes.Builder();
        }
        com.baidu.tieba.homepage.personalize.model.c a2 = this.cVx.a(z, this.cVu, builder, z2 ? 0 : 1);
        if (a2 == null) {
            return null;
        }
        List<f> list = a2.aUo;
        this.cVy = a2.dap;
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
                    com.baidu.tieba.homepage.concern.b.b bVar = this.cTm.get(userList.id.longValue());
                    if (bVar != null) {
                        arrayList.add(bVar);
                        i++;
                    }
                }
            }
        }
        this.cTm.clear();
        return arrayList;
    }

    private void bq(List<UserList> list) {
        if (this.cTm == null) {
            this.cTm = new LongSparseArray<>();
        }
        for (UserList userList : list) {
            com.baidu.tieba.homepage.concern.b.b a2 = a(userList);
            switch (this.cVz) {
                case 2:
                    a2.kM(2);
                    break;
                case 3:
                    a2.kM(3);
                    break;
                case 4:
                    a2.kM(4);
                    break;
            }
            if (a2 != null) {
                this.cTm.put(userList.id.longValue(), a2);
            }
        }
    }

    private com.baidu.tieba.homepage.concern.b.b a(UserList userList) {
        com.baidu.tieba.homepage.concern.b.b bVar = new com.baidu.tieba.homepage.concern.b.b();
        bVar.cWj = new com.baidu.tieba.homepage.concern.b.c();
        bVar.cWj.b(userList);
        bVar.beM = new bh();
        bVar.beM.a(userList.thread_info);
        bVar.aoU();
        if (bVar.beM.isLinkThread()) {
            bVar.isLinkThread = true;
        }
        if (StringUtils.isNull(bVar.cWj.getName()) || bVar.cWj.getId() == 0 || StringUtils.isNull(bVar.beM.getTid()) || StringUtils.isNull(bVar.beM.getId())) {
            return null;
        }
        return bVar;
    }

    public List<f> getDataList() {
        return this.mDataList;
    }

    public void aoP() {
        this.cVw.br(this.mDataList);
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
        if (dataRes.top_user_info != null && aoQ()) {
            if (!am.isEmpty(builder.top_tips)) {
                com.baidu.tieba.homepage.concern.b.a aVar = new com.baidu.tieba.homepage.concern.b.a();
                aVar.aiS = builder.top_tips;
                this.mDataList.add(aVar);
            }
            com.baidu.tieba.homepage.concern.b.b a2 = a(dataRes.top_user_info);
            a2.kM(1);
            this.mDataList.add(a2);
        }
        List<f> a3 = a(z, builder, z2);
        if (a3 != null && TbadkCoreApplication.isLogin()) {
            this.mDataList.addAll(a3);
        }
        if (!am.isEmpty(builder.user_tips)) {
            com.baidu.tieba.homepage.concern.b.a aVar2 = new com.baidu.tieba.homepage.concern.b.a();
            this.cVz = builder.user_tips_type.intValue();
            aVar2.cWe = builder.user_tips_type.intValue();
            aVar2.aiS = builder.user_tips;
            aVar2.cWg = true;
            this.mDataList.add(aVar2);
        }
        List<f> a4 = a(builder);
        if (a4 != null) {
            this.mDataList.addAll(a4);
        }
        if (!am.isEmpty(builder.last_tips)) {
            com.baidu.tieba.homepage.concern.b.a aVar3 = new com.baidu.tieba.homepage.concern.b.a();
            aVar3.aiS = builder.last_tips;
            aVar3.cWf = true;
            this.mDataList.add(aVar3);
        }
        this.hasMore = builder.has_more.intValue() == 1;
        if (v.u(this.mDataList)) {
            return false;
        }
        if (z2) {
            this.cVu.page_tag = dataRes.page_tag;
            this.cVu.has_more = dataRes.has_more;
            this.cVu.user_list = dataRes.user_list;
            this.cVu.user_tips_type = dataRes.user_tips_type;
            this.cVu.user_tips = dataRes.user_tips;
            this.cVu.last_tips = dataRes.last_tips;
        }
        this.cVu.banner_user_story = dataRes.banner_user_story;
        this.cVu.top_tips = dataRes.top_tips;
        this.cVu.top_user_info = dataRes.top_user_info;
        if (this.cVz == 2 || this.cVz == 3) {
            this.cVu.user_tips_type = dataRes.user_tips_type;
            this.cVu.user_tips = dataRes.user_tips;
        }
        this.cVw.br(this.mDataList);
        this.cVw.aoE();
        return true;
    }

    private boolean aoQ() {
        if (TbadkCoreApplication.isLogin()) {
            if (System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.getInstance().getLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("concern_top_user_user_like_time"), 0L) > 86400000) {
                return true;
            }
        }
        return false;
    }

    private void aoR() {
        t.a(new s<DataRes>() { // from class: com.baidu.tieba.homepage.concern.d.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.s
            /* renamed from: aoT */
            public DataRes doInBackground() {
                l<byte[]> M = com.baidu.tbadk.core.c.a.sX().M("tb.concern_page", TbadkCoreApplication.getCurrentAccount());
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
        }, new g<DataRes>() { // from class: com.baidu.tieba.homepage.concern.d.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.g
            /* renamed from: b */
            public void onReturnDataInUI(DataRes dataRes) {
                d.this.a(dataRes);
            }
        });
    }

    private void aoS() {
        if (this.cVu != null) {
            DataRes.Builder builder = new DataRes.Builder(this.cVu.build(true));
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
                    com.baidu.tbadk.core.c.a.sX().M("tb.concern_page", TbadkCoreApplication.getCurrentAccount()).e("0", builder2.build(true).toByteArray());
                    return null;
                } catch (Exception e) {
                    BdLog.e(e);
                    return null;
                }
            }
        }, null);
    }

    public void a(a aVar) {
        this.cVt = aVar;
    }

    private boolean ws() {
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
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.cVu != null && v.t(this.cVu.thread_info) != 0 && v.t(this.mDataList) != 0) {
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
                        if (cVar.Nd() != null && cVar.Nd().getTid() != null && cVar.Nd().getTid().equals(optString)) {
                            this.mDataList.remove(i);
                            if (this.cVw != null) {
                                this.cVw.br(this.mDataList);
                            }
                        }
                    }
                    i++;
                }
                long c = com.baidu.adp.lib.g.b.c(optString, 0L);
                for (int i2 = 0; i2 < this.cVu.thread_info.size(); i2++) {
                    ConcernData concernData = this.cVu.thread_info.get(i2);
                    if (concernData != null && (threadInfo = concernData.thread_list) != null && threadInfo.tid != null && threadInfo.tid.longValue() == c) {
                        this.cVu.thread_info.remove(i2);
                        aoS();
                        return;
                    }
                }
            }
        }
    }
}
