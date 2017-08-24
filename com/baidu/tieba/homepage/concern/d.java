package com.baidu.tieba.homepage.concern;

import android.support.v4.util.LongSparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AbsListView;
import com.baidu.adp.base.e;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.f;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.al;
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
import tbclient.Userlike.DataRes;
import tbclient.Userlike.UserList;
/* loaded from: classes.dex */
public class d {
    private q aMT;
    private com.baidu.tieba.e.a cAk;
    private LongSparseArray<com.baidu.tieba.homepage.concern.b.c> cLh;
    private DataRes.Builder cRW;
    private final com.baidu.tieba.homepage.concern.a cRY;
    private View.OnTouchListener cRZ;
    private final com.baidu.tieba.homepage.concern.c.a cSa;
    private boolean hasMore;
    private final BdTypeListView mListView;
    private String pageTag;
    private a cRV = null;
    private final List<f> mDataList = new LinkedList();
    private boolean mIsLoading = false;
    private boolean cRX = false;
    private boolean clq = false;
    private boolean mIsBackground = false;
    private int cSb = 0;
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.homepage.concern.d.1
        private int cSc = -1;
        private int cSd = 0;
        private boolean cSe = false;

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (d.this.aMT != null && !d.this.mIsBackground) {
                d.this.aMT.onScrollStateChanged(absListView, i);
            }
            if (i == 0) {
                u.WU().cA(true);
                this.cSe = false;
                return;
            }
            if (i == 1) {
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (this.cSd > i) {
                this.cSe = true;
            }
            if (d.this.aMT != null && !d.this.mIsBackground) {
                d.this.aMT.a(absListView, this.cSd, i, i2, i3);
            }
            this.cSd = i;
            int i4 = (i + i2) - 1;
            if (!this.cSe && this.cSc != i4) {
                this.cSc = i4;
            }
            if (this.cSe && this.cSc != i) {
                this.cSc = i;
            }
        }
    };
    private View.OnTouchListener aMU = new View.OnTouchListener() { // from class: com.baidu.tieba.homepage.concern.d.2
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (d.this.cRZ != null) {
                d.this.cRZ.onTouch(view, motionEvent);
            }
            if (d.this.cAk != null) {
                d.this.cAk.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private a.InterfaceC0080a bWS = new a.InterfaceC0080a() { // from class: com.baidu.tieba.homepage.concern.d.3
        @Override // com.baidu.tieba.e.a.InterfaceC0080a
        public void ah(int i, int i2) {
            d.this.clq = true;
        }

        @Override // com.baidu.tieba.e.a.InterfaceC0080a
        public void ai(int i, int i2) {
            d.this.clq = false;
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void aov();

        void lr(String str);

        void onError(int i, String str);

        void v(boolean z, boolean z2);
    }

    public void setTabInForeBackgroundState(boolean z) {
        this.mIsBackground = z;
    }

    public void eL(boolean z) {
        this.mIsBackground = z;
    }

    public d(e<?> eVar, BdTypeListView bdTypeListView, com.baidu.tieba.homepage.concern.a aVar) {
        this.mListView = bdTypeListView;
        this.mListView.setOnTouchListener(this.aMU);
        this.cAk = new com.baidu.tieba.e.a();
        this.cSa = new com.baidu.tieba.homepage.concern.c.a();
        this.cAk.a(this.bWS);
        this.cRY = aVar;
        bdTypeListView.setOnScrollListener(this.mOnScrollListener);
    }

    public void setRecommendFrsNavigationAnimDispatcher(r rVar) {
        if (rVar != null) {
            this.aMT = rVar.Hp();
            this.cRZ = rVar.Hq();
        }
    }

    public void update() {
        if (this.mDataList.size() == 0 && !this.cRX) {
            aoy();
        } else {
            aow();
        }
    }

    public void MS() {
        if (!xc() && this.hasMore && this.cRV != null) {
            setIsLoading(true);
            this.cRV.lr(this.pageTag);
        }
    }

    public void a(boolean z, DataRes dataRes, int i, String str) {
        setIsLoading(false);
        this.mListView.completePullRefreshPostDelayed(2000L);
        if (i != 0 || dataRes == null || !a(true, z, dataRes)) {
            if (this.mDataList.size() > 0) {
                if (this.cRV != null) {
                    this.cRV.onError(1, str);
                    return;
                }
                return;
            } else if (this.cRV != null) {
                this.cRV.onError(2, str);
                return;
            } else {
                return;
            }
        }
        if (this.cRV != null) {
            this.cRV.v(z, false);
        }
        aoz();
    }

    public void fF(boolean z) {
        if (z) {
            this.cRY.notifyDataSetChanged();
        }
    }

    private void aow() {
        if (this.cRV != null) {
            this.cRV.aov();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(DataRes dataRes) {
        this.cRX = true;
        if (dataRes != null) {
            if (a(false, true, dataRes)) {
                if (this.cRV != null) {
                    this.cRV.v(false, true);
                    return;
                }
                return;
            }
            aow();
            return;
        }
        aow();
    }

    private List<f> a(boolean z, DataRes.Builder builder, boolean z2) {
        if (this.cRW == null) {
            this.cRW = new DataRes.Builder();
        }
        if (builder == null) {
            builder = new DataRes.Builder();
        }
        com.baidu.tieba.homepage.personalize.model.c a2 = this.cSa.a(z, this.cRW, builder, z2 ? 0 : 1);
        if (a2 == null) {
            return null;
        }
        List<f> list = a2.aTV;
        this.cSb = a2.cWO;
        return list;
    }

    private List<f> a(DataRes.Builder builder) {
        if (builder == null || com.baidu.tbadk.core.util.u.v(builder.user_list)) {
            return null;
        }
        bl(builder.user_list);
        ArrayList arrayList = new ArrayList();
        if (!com.baidu.tbadk.core.util.u.v(builder.user_list)) {
            int i = 0;
            for (UserList userList : builder.user_list) {
                if (userList != null) {
                    if (i == 30) {
                        break;
                    }
                    com.baidu.tieba.homepage.concern.b.c cVar = this.cLh.get(userList.id.longValue());
                    if (cVar != null) {
                        com.baidu.tieba.homepage.concern.b.b bVar = new com.baidu.tieba.homepage.concern.b.b();
                        bVar.cSz = cVar;
                        bVar.aoB();
                        arrayList.add(bVar);
                        i++;
                    }
                }
            }
        }
        this.cLh.clear();
        return arrayList;
    }

    private void bl(List<UserList> list) {
        if (this.cLh == null) {
            this.cLh = new LongSparseArray<>();
        }
        for (UserList userList : list) {
            com.baidu.tieba.homepage.concern.b.b bVar = new com.baidu.tieba.homepage.concern.b.b();
            bVar.cSz = new com.baidu.tieba.homepage.concern.b.c();
            bVar.cSz.a(userList);
            if (!StringUtils.isNull(bVar.cSz.getName()) && bVar.cSz.getId() != 0) {
                this.cLh.put(userList.id.longValue(), bVar.cSz);
            }
        }
    }

    public List<f> getDataList() {
        return this.mDataList;
    }

    public void aox() {
        this.cRY.br(this.mDataList);
    }

    private boolean a(boolean z, boolean z2, DataRes dataRes) {
        if (dataRes == null) {
            return false;
        }
        this.pageTag = dataRes.page_tag;
        this.mDataList.clear();
        DataRes.Builder builder = new DataRes.Builder(dataRes);
        if (dataRes.banner_user_story != null && dataRes.banner_user_story._switch.intValue() == 1) {
            com.baidu.tbadk.data.e eVar = new com.baidu.tbadk.data.e();
            eVar.a(dataRes.banner_user_story, 0L);
            this.mDataList.add(eVar);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_STORY_READ_CACHE, 0L));
        }
        List<f> a2 = a(z, builder, z2);
        if (a2 != null) {
            this.mDataList.addAll(a2);
        }
        if (!al.isEmpty(builder.user_tips)) {
            com.baidu.tieba.homepage.concern.b.a aVar = new com.baidu.tieba.homepage.concern.b.a();
            aVar.akj = builder.user_tips;
            this.mDataList.add(aVar);
        }
        List<f> a3 = a(builder);
        if (a3 != null) {
            this.mDataList.addAll(a3);
        }
        if (!al.isEmpty(builder.last_tips)) {
            com.baidu.tieba.homepage.concern.b.a aVar2 = new com.baidu.tieba.homepage.concern.b.a();
            aVar2.akj = builder.last_tips;
            aVar2.cSx = true;
            this.mDataList.add(aVar2);
        }
        this.hasMore = builder.has_more.intValue() == 1;
        if (com.baidu.tbadk.core.util.u.v(this.mDataList)) {
            return false;
        }
        if (z2) {
            this.cRW.page_tag = dataRes.page_tag;
            this.cRW.has_more = dataRes.has_more;
            this.cRW.last_tips = dataRes.last_tips;
            this.cRW.user_tips = dataRes.user_tips;
            this.cRW.user_list = dataRes.user_list;
        }
        this.cRW.banner_user_story = dataRes.banner_user_story;
        this.cRY.br(this.mDataList);
        return true;
    }

    private void aoy() {
        com.baidu.tbadk.util.u.a(new t<DataRes>() { // from class: com.baidu.tieba.homepage.concern.d.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.t
            /* renamed from: aoA */
            public DataRes doInBackground() {
                l<byte[]> L = com.baidu.tbadk.core.c.a.to().L("tb.concern_page", TbadkCoreApplication.getCurrentAccount());
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

    private void aoz() {
        if (this.cRW != null) {
            DataRes.Builder builder = new DataRes.Builder(this.cRW.build(true));
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
                    com.baidu.tbadk.core.c.a.to().L("tb.concern_page", TbadkCoreApplication.getCurrentAccount()).k("0", builder2.build(true).toByteArray());
                    return null;
                } catch (Exception e) {
                    BdLog.e(e);
                    return null;
                }
            }
        }, null);
    }

    public void a(a aVar) {
        this.cRV = aVar;
    }

    private boolean xc() {
        return this.mIsLoading;
    }

    private void setIsLoading(boolean z) {
        this.mIsLoading = z;
    }

    public boolean hasMore() {
        return this.hasMore;
    }
}
