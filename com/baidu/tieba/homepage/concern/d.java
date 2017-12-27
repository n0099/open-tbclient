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
import com.baidu.adp.widget.ListView.i;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.be;
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
/* loaded from: classes2.dex */
public class d {
    private r bBb;
    private View.OnTouchListener bmR;
    private com.baidu.tieba.e.a dNs;
    private LongSparseArray<com.baidu.tieba.homepage.concern.b.b> dYw;
    private DataRes.Builder eaf;
    private final com.baidu.tieba.homepage.concern.a eah;
    private final com.baidu.tieba.homepage.concern.c.a eai;
    private int eaj;
    private boolean hasMore;
    private final BdTypeListView mListView;
    private String pageTag;
    private a eae = null;
    private final List<i> mDataList = new LinkedList();
    private boolean mIsLoading = false;
    private boolean eag = false;
    private boolean mIsBackground = false;
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.homepage.concern.d.1
        private int eal = -1;
        private int eam = 0;
        private boolean ean = false;

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (d.this.bBb != null && !d.this.mIsBackground) {
                d.this.bBb.onScrollStateChanged(absListView, i);
            }
            if (i == 0) {
                s.ajC().Vp();
                this.ean = false;
                return;
            }
            if (i == 1) {
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (this.eam > i) {
                this.ean = true;
            }
            if (d.this.bBb != null && !d.this.mIsBackground) {
                d.this.bBb.a(absListView, this.eam, i, i2, i3);
            }
            this.eam = i;
            int i4 = (i + i2) - 1;
            if (!this.ean && this.eal != i4) {
                this.eal = i4;
            }
            if (this.ean && this.eal != i) {
                this.eal = i;
            }
        }
    };
    private View.OnTouchListener bBc = new View.OnTouchListener() { // from class: com.baidu.tieba.homepage.concern.d.2
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (d.this.bmR != null) {
                d.this.bmR.onTouch(view, motionEvent);
            }
            if (d.this.dNs != null) {
                d.this.dNs.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private a.InterfaceC0109a ckE = new a.InterfaceC0109a() { // from class: com.baidu.tieba.homepage.concern.d.3
        @Override // com.baidu.tieba.e.a.InterfaceC0109a
        public void aY(int i, int i2) {
        }

        @Override // com.baidu.tieba.e.a.InterfaceC0109a
        public void aZ(int i, int i2) {
        }

        @Override // com.baidu.tieba.e.a.InterfaceC0109a
        public void ba(int i, int i2) {
        }
    };
    private CustomMessageListener eak = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.homepage.concern.d.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.this.d(customResponsedMessage);
        }
    };
    private CustomMessageListener dLy = new CustomMessageListener(CmdConfigCustom.CMD_THREAD_NOT_EXIST_WHEN_ENTER_PB) { // from class: com.baidu.tieba.homepage.concern.d.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.this.d(customResponsedMessage);
        }
    };

    /* loaded from: classes2.dex */
    public interface a {
        void A(boolean z, boolean z2);

        void aAJ();

        void mf(String str);

        void onError(int i, String str);
    }

    public void setTabInForeBackgroundState(boolean z) {
        this.mIsBackground = z;
    }

    public void fD(boolean z) {
        this.mIsBackground = z;
    }

    public d(e<?> eVar, BdTypeListView bdTypeListView, com.baidu.tieba.homepage.concern.a aVar) {
        this.mListView = bdTypeListView;
        this.mListView.setOnTouchListener(this.bBc);
        this.dNs = new com.baidu.tieba.e.a();
        this.eai = new com.baidu.tieba.homepage.concern.c.a();
        this.dNs.a(this.ckE);
        this.eah = aVar;
        bdTypeListView.setOnScrollListener(this.mOnScrollListener);
    }

    public void l(BdUniqueId bdUniqueId) {
        this.eak.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.eak);
        this.dLy.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.dLy);
    }

    public void setRecommendFrsNavigationAnimDispatcher(com.baidu.tbadk.util.s sVar) {
        if (sVar != null) {
            this.bBb = sVar.OQ();
            this.bmR = sVar.OR();
        }
    }

    public void update() {
        if (this.mDataList.size() == 0 && !this.eag) {
            aAM();
        } else {
            aAK();
        }
    }

    public void Wh() {
        if (!DY() && this.hasMore && this.eae != null) {
            setIsLoading(true);
            this.eae.mf(this.pageTag);
        }
    }

    public void a(boolean z, DataRes dataRes, int i, String str) {
        setIsLoading(false);
        this.mListView.completePullRefreshPostDelayed(2000L);
        if (i != 0 || dataRes == null || !a(true, z, dataRes)) {
            if (this.mDataList.size() > 0) {
                if (this.eae != null) {
                    this.eae.onError(1, str);
                    return;
                }
                return;
            } else if (this.eae != null) {
                this.eae.onError(2, str);
                return;
            } else {
                return;
            }
        }
        if (this.eae != null) {
            this.eae.A(z, false);
        }
        aAN();
    }

    public void gt(boolean z) {
        if (z) {
            this.eah.notifyDataSetChanged();
        }
    }

    private void aAK() {
        if (this.eae != null) {
            this.eae.aAJ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(DataRes dataRes) {
        this.eag = true;
        if (dataRes != null) {
            if (a(false, true, dataRes)) {
                if (this.eae != null) {
                    this.eae.A(false, true);
                    return;
                }
                return;
            }
            aAK();
            return;
        }
        aAK();
    }

    private List<i> a(boolean z, DataRes.Builder builder, boolean z2) {
        if (this.eaf == null) {
            this.eaf = new DataRes.Builder();
        }
        if (builder == null) {
            builder = new DataRes.Builder();
        }
        com.baidu.tieba.homepage.personalize.model.c a2 = this.eai.a(z, this.eaf, builder, z2 ? 0 : 1);
        if (a2 == null) {
            return null;
        }
        return a2.bLw;
    }

    private List<i> a(DataRes.Builder builder) {
        if (builder == null || v.G(builder.user_list)) {
            return null;
        }
        bO(builder.user_list);
        ArrayList arrayList = new ArrayList();
        if (!v.G(builder.user_list)) {
            int i = 0;
            for (UserList userList : builder.user_list) {
                if (userList != null) {
                    if (i == 30) {
                        break;
                    }
                    com.baidu.tieba.homepage.concern.b.b bVar = this.dYw.get(userList.id.longValue());
                    if (bVar != null) {
                        arrayList.add(bVar);
                        i++;
                    }
                }
            }
        }
        this.dYw.clear();
        return arrayList;
    }

    private void bO(List<UserList> list) {
        if (this.dYw == null) {
            this.dYw = new LongSparseArray<>();
        }
        for (UserList userList : list) {
            com.baidu.tieba.homepage.concern.b.b a2 = a(userList);
            switch (this.eaj) {
                case 2:
                    a2.oA(2);
                    break;
                case 3:
                    a2.oA(3);
                    break;
                case 4:
                    a2.oA(4);
                    break;
            }
            if (a2 != null) {
                this.dYw.put(userList.id.longValue(), a2);
            }
        }
    }

    private com.baidu.tieba.homepage.concern.b.b a(UserList userList) {
        com.baidu.tieba.homepage.concern.b.b bVar = new com.baidu.tieba.homepage.concern.b.b();
        bVar.eaS = new com.baidu.tieba.homepage.concern.b.c();
        bVar.eaS.b(userList);
        bVar.dqg = new be();
        bVar.dqg.a(userList.thread_info);
        bVar.aAP();
        if (bVar.dqg.isLinkThread()) {
            bVar.isLinkThread = true;
        }
        if (StringUtils.isNull(bVar.eaS.getName()) || bVar.eaS.getId() == 0 || StringUtils.isNull(bVar.dqg.getTid()) || StringUtils.isNull(bVar.dqg.getId())) {
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
            this.mDataList.add(bVar);
        }
        if (dataRes.req_unix != null) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("concern_data_res_request_time"), dataRes.req_unix.longValue());
        }
        if (dataRes.top_user_info != null && aAL()) {
            if (!am.isEmpty(builder.top_tips)) {
                com.baidu.tieba.homepage.concern.b.a aVar = new com.baidu.tieba.homepage.concern.b.a();
                aVar.aXT = builder.top_tips;
                this.mDataList.add(aVar);
            }
            com.baidu.tieba.homepage.concern.b.b a2 = a(dataRes.top_user_info);
            a2.oA(1);
            this.mDataList.add(a2);
        }
        List<i> a3 = a(z, builder, z2);
        if (a3 != null && TbadkCoreApplication.isLogin()) {
            this.mDataList.addAll(a3);
        }
        if (!am.isEmpty(builder.user_tips)) {
            com.baidu.tieba.homepage.concern.b.a aVar2 = new com.baidu.tieba.homepage.concern.b.a();
            this.eaj = builder.user_tips_type.intValue();
            aVar2.eaN = builder.user_tips_type.intValue();
            aVar2.aXT = builder.user_tips;
            aVar2.eaP = true;
            this.mDataList.add(aVar2);
        }
        List<i> a4 = a(builder);
        if (a4 != null) {
            this.mDataList.addAll(a4);
        }
        if (!am.isEmpty(builder.last_tips)) {
            com.baidu.tieba.homepage.concern.b.a aVar3 = new com.baidu.tieba.homepage.concern.b.a();
            aVar3.aXT = builder.last_tips;
            aVar3.eaO = true;
            this.mDataList.add(aVar3);
        }
        this.hasMore = builder.has_more.intValue() == 1;
        if (v.G(this.mDataList)) {
            return false;
        }
        if (z2) {
            this.eaf.page_tag = dataRes.page_tag;
            this.eaf.has_more = dataRes.has_more;
            this.eaf.user_list = dataRes.user_list;
            this.eaf.user_tips_type = dataRes.user_tips_type;
            this.eaf.user_tips = dataRes.user_tips;
            this.eaf.last_tips = dataRes.last_tips;
        }
        this.eaf.banner_user_story = dataRes.banner_user_story;
        this.eaf.banner_follow_live = dataRes.banner_follow_live;
        this.eaf.top_tips = dataRes.top_tips;
        this.eaf.top_user_info = dataRes.top_user_info;
        if (this.eaj == 2 || this.eaj == 3) {
            this.eaf.user_tips_type = dataRes.user_tips_type;
            this.eaf.user_tips = dataRes.user_tips;
        }
        this.eah.ao(this.mDataList);
        return true;
    }

    private boolean aAL() {
        if (TbadkCoreApplication.isLogin()) {
            if (System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.getInstance().getLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("concern_top_user_user_like_time"), 0L) > 86400000) {
                return true;
            }
        }
        return false;
    }

    private void aAM() {
        com.baidu.tbadk.util.v.a(new u<DataRes>() { // from class: com.baidu.tieba.homepage.concern.d.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.u
            /* renamed from: aAO */
            public DataRes doInBackground() {
                l<byte[]> L = com.baidu.tbadk.core.c.a.AE().L("tb.concern_page", TbadkCoreApplication.getCurrentAccount());
                if (L == null) {
                    return null;
                }
                byte[] bArr = L.get("0");
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

    private void aAN() {
        if (this.eaf != null) {
            DataRes.Builder builder = new DataRes.Builder(this.eaf.build(true));
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
                    com.baidu.tbadk.core.c.a.AE().L("tb.concern_page", TbadkCoreApplication.getCurrentAccount()).e("0", builder2.build(true).toByteArray());
                    return null;
                } catch (Exception e) {
                    BdLog.e(e);
                    return null;
                }
            }
        }, null);
    }

    public void a(a aVar) {
        this.eae = aVar;
    }

    private boolean DY() {
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
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.eaf != null && v.F(this.eaf.thread_info) != 0 && v.F(this.mDataList) != 0) {
            String optString = ((JSONObject) customResponsedMessage.getData()).optString("tid");
            if (!StringUtils.isNull(optString)) {
                int i = 0;
                while (true) {
                    if (i >= this.mDataList.size()) {
                        break;
                    }
                    i iVar = this.mDataList.get(i);
                    if (iVar instanceof com.baidu.tieba.card.data.c) {
                        com.baidu.tieba.card.data.c cVar = (com.baidu.tieba.card.data.c) iVar;
                        if (cVar.VW() != null && cVar.VW().getTid() != null && cVar.VW().getTid().equals(optString)) {
                            this.mDataList.remove(i);
                            if (this.eah != null) {
                                this.eah.ao(this.mDataList);
                            }
                        }
                    }
                    i++;
                }
                long c = com.baidu.adp.lib.g.b.c(optString, 0L);
                for (int i2 = 0; i2 < this.eaf.thread_info.size(); i2++) {
                    ConcernData concernData = this.eaf.thread_info.get(i2);
                    if (concernData != null && (threadInfo = concernData.thread_list) != null && threadInfo.tid != null && threadInfo.tid.longValue() == c) {
                        this.eaf.thread_info.remove(i2);
                        aAN();
                        return;
                    }
                }
            }
        }
    }
}
