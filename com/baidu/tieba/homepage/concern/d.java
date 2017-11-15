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
import com.baidu.tbadk.util.h;
import com.baidu.tbadk.util.r;
import com.baidu.tbadk.util.s;
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
    private r aMH;
    private View.OnTouchListener ayd;
    private com.baidu.tieba.e.a cRG;
    private LongSparseArray<com.baidu.tieba.homepage.concern.b.b> dcy;
    private DataRes.Builder deh;
    private final com.baidu.tieba.homepage.concern.a dej;
    private final com.baidu.tieba.homepage.concern.c.a dek;
    private int del;
    private boolean hasMore;
    private final BdTypeListView mListView;
    private String pageTag;
    private a deg = null;
    private final List<f> mDataList = new LinkedList();
    private boolean mIsLoading = false;
    private boolean dei = false;
    private boolean mIsBackground = false;
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.homepage.concern.d.1
        private int den = -1;
        private int deo = 0;
        private boolean dep = false;

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (d.this.aMH != null && !d.this.mIsBackground) {
                d.this.aMH.onScrollStateChanged(absListView, i);
            }
            if (i == 0) {
                u.aaj().Nm();
                this.dep = false;
                return;
            }
            if (i == 1) {
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (this.deo > i) {
                this.dep = true;
            }
            if (d.this.aMH != null && !d.this.mIsBackground) {
                d.this.aMH.a(absListView, this.deo, i, i2, i3);
            }
            this.deo = i;
            int i4 = (i + i2) - 1;
            if (!this.dep && this.den != i4) {
                this.den = i4;
            }
            if (this.dep && this.den != i) {
                this.den = i;
            }
        }
    };
    private View.OnTouchListener aMI = new View.OnTouchListener() { // from class: com.baidu.tieba.homepage.concern.d.2
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (d.this.ayd != null) {
                d.this.ayd.onTouch(view, motionEvent);
            }
            if (d.this.cRG != null) {
                d.this.cRG.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private a.InterfaceC0081a bzM = new a.InterfaceC0081a() { // from class: com.baidu.tieba.homepage.concern.d.3
        @Override // com.baidu.tieba.e.a.InterfaceC0081a
        public void ag(int i, int i2) {
        }

        @Override // com.baidu.tieba.e.a.InterfaceC0081a
        public void ah(int i, int i2) {
        }

        @Override // com.baidu.tieba.e.a.InterfaceC0081a
        public void ai(int i, int i2) {
        }
    };
    private CustomMessageListener dem = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.homepage.concern.d.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.this.d(customResponsedMessage);
        }
    };
    private CustomMessageListener cOQ = new CustomMessageListener(CmdConfigCustom.CMD_THREAD_NOT_EXIST_WHEN_ENTER_PB) { // from class: com.baidu.tieba.homepage.concern.d.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.this.d(customResponsedMessage);
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void arC();

        void lN(String str);

        void onError(int i, String str);

        void y(boolean z, boolean z2);
    }

    public void setTabInForeBackgroundState(boolean z) {
        this.mIsBackground = z;
    }

    public void eF(boolean z) {
        this.mIsBackground = z;
    }

    public d(e<?> eVar, BdTypeListView bdTypeListView, com.baidu.tieba.homepage.concern.a aVar) {
        this.mListView = bdTypeListView;
        this.mListView.setOnTouchListener(this.aMI);
        this.cRG = new com.baidu.tieba.e.a();
        this.dek = new com.baidu.tieba.homepage.concern.c.a();
        this.cRG.a(this.bzM);
        this.dej = aVar;
        bdTypeListView.setOnScrollListener(this.mOnScrollListener);
    }

    public void m(BdUniqueId bdUniqueId) {
        this.dem.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.dem);
        this.cOQ.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.cOQ);
    }

    public void setRecommendFrsNavigationAnimDispatcher(s sVar) {
        if (sVar != null) {
            this.aMH = sVar.Hj();
            this.ayd = sVar.Hk();
        }
    }

    public void update() {
        if (this.mDataList.size() == 0 && !this.dei) {
            arG();
        } else {
            arD();
        }
    }

    public void NQ() {
        if (!wz() && this.hasMore && this.deg != null) {
            setIsLoading(true);
            this.deg.lN(this.pageTag);
        }
    }

    public void a(boolean z, DataRes dataRes, int i, String str) {
        setIsLoading(false);
        this.mListView.completePullRefreshPostDelayed(2000L);
        if (i != 0 || dataRes == null || !a(true, z, dataRes)) {
            if (this.mDataList.size() > 0) {
                if (this.deg != null) {
                    this.deg.onError(1, str);
                    return;
                }
                return;
            } else if (this.deg != null) {
                this.deg.onError(2, str);
                return;
            } else {
                return;
            }
        }
        if (this.deg != null) {
            this.deg.y(z, false);
        }
        arH();
    }

    public void fC(boolean z) {
        if (z) {
            this.dej.notifyDataSetChanged();
        }
    }

    private void arD() {
        if (this.deg != null) {
            this.deg.arC();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(DataRes dataRes) {
        this.dei = true;
        if (dataRes != null) {
            if (a(false, true, dataRes)) {
                if (this.deg != null) {
                    this.deg.y(false, true);
                    return;
                }
                return;
            }
            arD();
            return;
        }
        arD();
    }

    private List<f> a(boolean z, DataRes.Builder builder, boolean z2) {
        if (this.deh == null) {
            this.deh = new DataRes.Builder();
        }
        if (builder == null) {
            builder = new DataRes.Builder();
        }
        com.baidu.tieba.homepage.personalize.model.c a2 = this.dek.a(z, this.deh, builder, z2 ? 0 : 1);
        if (a2 == null) {
            return null;
        }
        return a2.aUB;
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
                    com.baidu.tieba.homepage.concern.b.b bVar = this.dcy.get(userList.id.longValue());
                    if (bVar != null) {
                        arrayList.add(bVar);
                        i++;
                    }
                }
            }
        }
        this.dcy.clear();
        return arrayList;
    }

    private void bq(List<UserList> list) {
        if (this.dcy == null) {
            this.dcy = new LongSparseArray<>();
        }
        for (UserList userList : list) {
            com.baidu.tieba.homepage.concern.b.b a2 = a(userList);
            switch (this.del) {
                case 2:
                    a2.le(2);
                    break;
                case 3:
                    a2.le(3);
                    break;
                case 4:
                    a2.le(4);
                    break;
            }
            if (a2 != null) {
                this.dcy.put(userList.id.longValue(), a2);
            }
        }
    }

    private com.baidu.tieba.homepage.concern.b.b a(UserList userList) {
        com.baidu.tieba.homepage.concern.b.b bVar = new com.baidu.tieba.homepage.concern.b.b();
        bVar.deT = new com.baidu.tieba.homepage.concern.b.c();
        bVar.deT.b(userList);
        bVar.bfM = new bh();
        bVar.bfM.a(userList.thread_info);
        bVar.arJ();
        if (bVar.bfM.isLinkThread()) {
            bVar.isLinkThread = true;
        }
        if (StringUtils.isNull(bVar.deT.getName()) || bVar.deT.getId() == 0 || StringUtils.isNull(bVar.bfM.getTid()) || StringUtils.isNull(bVar.bfM.getId())) {
            return null;
        }
        return bVar;
    }

    public List<f> getDataList() {
        return this.mDataList;
    }

    public void arE() {
        this.dej.br(this.mDataList);
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
        if (dataRes.top_user_info != null && arF()) {
            if (!am.isEmpty(builder.top_tips)) {
                com.baidu.tieba.homepage.concern.b.a aVar = new com.baidu.tieba.homepage.concern.b.a();
                aVar.ajo = builder.top_tips;
                this.mDataList.add(aVar);
            }
            com.baidu.tieba.homepage.concern.b.b a2 = a(dataRes.top_user_info);
            a2.le(1);
            this.mDataList.add(a2);
        }
        List<f> a3 = a(z, builder, z2);
        if (a3 != null && TbadkCoreApplication.isLogin()) {
            this.mDataList.addAll(a3);
        }
        if (!am.isEmpty(builder.user_tips)) {
            com.baidu.tieba.homepage.concern.b.a aVar2 = new com.baidu.tieba.homepage.concern.b.a();
            this.del = builder.user_tips_type.intValue();
            aVar2.deO = builder.user_tips_type.intValue();
            aVar2.ajo = builder.user_tips;
            aVar2.deQ = true;
            this.mDataList.add(aVar2);
        }
        List<f> a4 = a(builder);
        if (a4 != null) {
            this.mDataList.addAll(a4);
        }
        if (!am.isEmpty(builder.last_tips)) {
            com.baidu.tieba.homepage.concern.b.a aVar3 = new com.baidu.tieba.homepage.concern.b.a();
            aVar3.ajo = builder.last_tips;
            aVar3.deP = true;
            this.mDataList.add(aVar3);
        }
        this.hasMore = builder.has_more.intValue() == 1;
        if (v.v(this.mDataList)) {
            return false;
        }
        if (z2) {
            this.deh.page_tag = dataRes.page_tag;
            this.deh.has_more = dataRes.has_more;
            this.deh.user_list = dataRes.user_list;
            this.deh.user_tips_type = dataRes.user_tips_type;
            this.deh.user_tips = dataRes.user_tips;
            this.deh.last_tips = dataRes.last_tips;
        }
        this.deh.banner_user_story = dataRes.banner_user_story;
        this.deh.top_tips = dataRes.top_tips;
        this.deh.top_user_info = dataRes.top_user_info;
        if (this.del == 2 || this.del == 3) {
            this.deh.user_tips_type = dataRes.user_tips_type;
            this.deh.user_tips = dataRes.user_tips;
        }
        this.dej.br(this.mDataList);
        this.dej.arv();
        return true;
    }

    private boolean arF() {
        if (TbadkCoreApplication.isLogin()) {
            if (System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.getInstance().getLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("concern_top_user_user_like_time"), 0L) > 86400000) {
                return true;
            }
        }
        return false;
    }

    private void arG() {
        com.baidu.tbadk.util.v.a(new com.baidu.tbadk.util.u<DataRes>() { // from class: com.baidu.tieba.homepage.concern.d.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.u
            /* renamed from: arI */
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

    private void arH() {
        if (this.deh != null) {
            DataRes.Builder builder = new DataRes.Builder(this.deh.build(true));
            if (builder.thread_info != null && builder.thread_info.size() > 30) {
                builder.thread_info = builder.thread_info.subList(0, 30);
            }
            b(builder);
        }
    }

    private void b(final DataRes.Builder builder) {
        com.baidu.tbadk.util.v.a(new com.baidu.tbadk.util.u<Object>() { // from class: com.baidu.tieba.homepage.concern.d.6
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
        this.deg = aVar;
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
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.deh != null && v.u(this.deh.thread_info) != 0 && v.u(this.mDataList) != 0) {
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
                        if (cVar.NA() != null && cVar.NA().getTid() != null && cVar.NA().getTid().equals(optString)) {
                            this.mDataList.remove(i);
                            if (this.dej != null) {
                                this.dej.br(this.mDataList);
                            }
                        }
                    }
                    i++;
                }
                long c = com.baidu.adp.lib.g.b.c(optString, 0L);
                for (int i2 = 0; i2 < this.deh.thread_info.size(); i2++) {
                    ConcernData concernData = this.deh.thread_info.get(i2);
                    if (concernData != null && (threadInfo = concernData.thread_list) != null && threadInfo.tid != null && threadInfo.tid.longValue() == c) {
                        this.deh.thread_info.remove(i2);
                        arH();
                        return;
                    }
                }
            }
        }
    }
}
