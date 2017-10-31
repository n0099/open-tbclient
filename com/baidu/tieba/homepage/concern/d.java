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
    private r aMz;
    private View.OnTouchListener axV;
    private com.baidu.tieba.e.a cRm;
    private LongSparseArray<com.baidu.tieba.homepage.concern.b.b> dcd;
    private DataRes.Builder ddN;
    private final com.baidu.tieba.homepage.concern.a ddP;
    private final com.baidu.tieba.homepage.concern.c.a ddQ;
    private int ddR;
    private boolean hasMore;
    private final BdTypeListView mListView;
    private String pageTag;
    private a ddM = null;
    private final List<f> mDataList = new LinkedList();
    private boolean mIsLoading = false;
    private boolean ddO = false;
    private boolean mIsBackground = false;
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.homepage.concern.d.1
        private int ddT = -1;
        private int ddU = 0;
        private boolean ddV = false;

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (d.this.aMz != null && !d.this.mIsBackground) {
                d.this.aMz.onScrollStateChanged(absListView, i);
            }
            if (i == 0) {
                u.ZX().Nb();
                this.ddV = false;
                return;
            }
            if (i == 1) {
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (this.ddU > i) {
                this.ddV = true;
            }
            if (d.this.aMz != null && !d.this.mIsBackground) {
                d.this.aMz.a(absListView, this.ddU, i, i2, i3);
            }
            this.ddU = i;
            int i4 = (i + i2) - 1;
            if (!this.ddV && this.ddT != i4) {
                this.ddT = i4;
            }
            if (this.ddV && this.ddT != i) {
                this.ddT = i;
            }
        }
    };
    private View.OnTouchListener aMA = new View.OnTouchListener() { // from class: com.baidu.tieba.homepage.concern.d.2
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (d.this.axV != null) {
                d.this.axV.onTouch(view, motionEvent);
            }
            if (d.this.cRm != null) {
                d.this.cRm.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private a.InterfaceC0081a bzA = new a.InterfaceC0081a() { // from class: com.baidu.tieba.homepage.concern.d.3
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
    private CustomMessageListener ddS = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.homepage.concern.d.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.this.d(customResponsedMessage);
        }
    };
    private CustomMessageListener cOw = new CustomMessageListener(CmdConfigCustom.CMD_THREAD_NOT_EXIST_WHEN_ENTER_PB) { // from class: com.baidu.tieba.homepage.concern.d.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.this.d(customResponsedMessage);
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void arm();

        void lL(String str);

        void onError(int i, String str);

        void y(boolean z, boolean z2);
    }

    public void setTabInForeBackgroundState(boolean z) {
        this.mIsBackground = z;
    }

    public void eA(boolean z) {
        this.mIsBackground = z;
    }

    public d(e<?> eVar, BdTypeListView bdTypeListView, com.baidu.tieba.homepage.concern.a aVar) {
        this.mListView = bdTypeListView;
        this.mListView.setOnTouchListener(this.aMA);
        this.cRm = new com.baidu.tieba.e.a();
        this.ddQ = new com.baidu.tieba.homepage.concern.c.a();
        this.cRm.a(this.bzA);
        this.ddP = aVar;
        bdTypeListView.setOnScrollListener(this.mOnScrollListener);
    }

    public void m(BdUniqueId bdUniqueId) {
        this.ddS.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.ddS);
        this.cOw.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.cOw);
    }

    public void setRecommendFrsNavigationAnimDispatcher(s sVar) {
        if (sVar != null) {
            this.aMz = sVar.GY();
            this.axV = sVar.GZ();
        }
    }

    public void update() {
        if (this.mDataList.size() == 0 && !this.ddO) {
            arq();
        } else {
            arn();
        }
    }

    public void NF() {
        if (!wz() && this.hasMore && this.ddM != null) {
            setIsLoading(true);
            this.ddM.lL(this.pageTag);
        }
    }

    public void a(boolean z, DataRes dataRes, int i, String str) {
        setIsLoading(false);
        this.mListView.completePullRefreshPostDelayed(2000L);
        if (i != 0 || dataRes == null || !a(true, z, dataRes)) {
            if (this.mDataList.size() > 0) {
                if (this.ddM != null) {
                    this.ddM.onError(1, str);
                    return;
                }
                return;
            } else if (this.ddM != null) {
                this.ddM.onError(2, str);
                return;
            } else {
                return;
            }
        }
        if (this.ddM != null) {
            this.ddM.y(z, false);
        }
        arr();
    }

    public void fw(boolean z) {
        if (z) {
            this.ddP.notifyDataSetChanged();
        }
    }

    private void arn() {
        if (this.ddM != null) {
            this.ddM.arm();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(DataRes dataRes) {
        this.ddO = true;
        if (dataRes != null) {
            if (a(false, true, dataRes)) {
                if (this.ddM != null) {
                    this.ddM.y(false, true);
                    return;
                }
                return;
            }
            arn();
            return;
        }
        arn();
    }

    private List<f> a(boolean z, DataRes.Builder builder, boolean z2) {
        if (this.ddN == null) {
            this.ddN = new DataRes.Builder();
        }
        if (builder == null) {
            builder = new DataRes.Builder();
        }
        com.baidu.tieba.homepage.personalize.model.c a2 = this.ddQ.a(z, this.ddN, builder, z2 ? 0 : 1);
        if (a2 == null) {
            return null;
        }
        return a2.aUt;
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
                    com.baidu.tieba.homepage.concern.b.b bVar = this.dcd.get(userList.id.longValue());
                    if (bVar != null) {
                        arrayList.add(bVar);
                        i++;
                    }
                }
            }
        }
        this.dcd.clear();
        return arrayList;
    }

    private void bq(List<UserList> list) {
        if (this.dcd == null) {
            this.dcd = new LongSparseArray<>();
        }
        for (UserList userList : list) {
            com.baidu.tieba.homepage.concern.b.b a2 = a(userList);
            switch (this.ddR) {
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
                this.dcd.put(userList.id.longValue(), a2);
            }
        }
    }

    private com.baidu.tieba.homepage.concern.b.b a(UserList userList) {
        com.baidu.tieba.homepage.concern.b.b bVar = new com.baidu.tieba.homepage.concern.b.b();
        bVar.dez = new com.baidu.tieba.homepage.concern.b.c();
        bVar.dez.b(userList);
        bVar.bfD = new bh();
        bVar.bfD.a(userList.thread_info);
        bVar.art();
        if (bVar.bfD.isLinkThread()) {
            bVar.isLinkThread = true;
        }
        if (StringUtils.isNull(bVar.dez.getName()) || bVar.dez.getId() == 0 || StringUtils.isNull(bVar.bfD.getTid()) || StringUtils.isNull(bVar.bfD.getId())) {
            return null;
        }
        return bVar;
    }

    public List<f> getDataList() {
        return this.mDataList;
    }

    public void aro() {
        this.ddP.br(this.mDataList);
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
        if (dataRes.top_user_info != null && arp()) {
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
            this.ddR = builder.user_tips_type.intValue();
            aVar2.deu = builder.user_tips_type.intValue();
            aVar2.ajo = builder.user_tips;
            aVar2.dew = true;
            this.mDataList.add(aVar2);
        }
        List<f> a4 = a(builder);
        if (a4 != null) {
            this.mDataList.addAll(a4);
        }
        if (!am.isEmpty(builder.last_tips)) {
            com.baidu.tieba.homepage.concern.b.a aVar3 = new com.baidu.tieba.homepage.concern.b.a();
            aVar3.ajo = builder.last_tips;
            aVar3.dev = true;
            this.mDataList.add(aVar3);
        }
        this.hasMore = builder.has_more.intValue() == 1;
        if (v.v(this.mDataList)) {
            return false;
        }
        if (z2) {
            this.ddN.page_tag = dataRes.page_tag;
            this.ddN.has_more = dataRes.has_more;
            this.ddN.user_list = dataRes.user_list;
            this.ddN.user_tips_type = dataRes.user_tips_type;
            this.ddN.user_tips = dataRes.user_tips;
            this.ddN.last_tips = dataRes.last_tips;
        }
        this.ddN.banner_user_story = dataRes.banner_user_story;
        this.ddN.top_tips = dataRes.top_tips;
        this.ddN.top_user_info = dataRes.top_user_info;
        if (this.ddR == 2 || this.ddR == 3) {
            this.ddN.user_tips_type = dataRes.user_tips_type;
            this.ddN.user_tips = dataRes.user_tips;
        }
        this.ddP.br(this.mDataList);
        this.ddP.arf();
        return true;
    }

    private boolean arp() {
        if (TbadkCoreApplication.isLogin()) {
            if (System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.getInstance().getLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("concern_top_user_user_like_time"), 0L) > 86400000) {
                return true;
            }
        }
        return false;
    }

    private void arq() {
        com.baidu.tbadk.util.v.a(new com.baidu.tbadk.util.u<DataRes>() { // from class: com.baidu.tieba.homepage.concern.d.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.u
            /* renamed from: ars */
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

    private void arr() {
        if (this.ddN != null) {
            DataRes.Builder builder = new DataRes.Builder(this.ddN.build(true));
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
        this.ddM = aVar;
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
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.ddN != null && v.u(this.ddN.thread_info) != 0 && v.u(this.mDataList) != 0) {
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
                        if (cVar.Np() != null && cVar.Np().getTid() != null && cVar.Np().getTid().equals(optString)) {
                            this.mDataList.remove(i);
                            if (this.ddP != null) {
                                this.ddP.br(this.mDataList);
                            }
                        }
                    }
                    i++;
                }
                long c = com.baidu.adp.lib.g.b.c(optString, 0L);
                for (int i2 = 0; i2 < this.ddN.thread_info.size(); i2++) {
                    ConcernData concernData = this.ddN.thread_info.get(i2);
                    if (concernData != null && (threadInfo = concernData.thread_list) != null && threadInfo.tid != null && threadInfo.tid.longValue() == c) {
                        this.ddN.thread_info.remove(i2);
                        arr();
                        return;
                    }
                }
            }
        }
    }
}
