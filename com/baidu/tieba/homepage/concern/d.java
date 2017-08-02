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
    private q aLC;
    private LongSparseArray<com.baidu.tieba.homepage.concern.b.c> cHP;
    private DataRes.Builder cOE;
    private final com.baidu.tieba.homepage.concern.a cOG;
    private View.OnTouchListener cOH;
    private final com.baidu.tieba.homepage.concern.c.a cOI;
    private com.baidu.tieba.e.a cwS;
    private boolean hasMore;
    private final BdTypeListView mListView;
    private String pageTag;
    private a cOD = null;
    private final List<f> mDataList = new LinkedList();
    private boolean mIsLoading = false;
    private boolean cOF = false;
    private boolean cjw = false;
    private boolean mIsBackground = false;
    private int cOJ = 0;
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.homepage.concern.d.1
        private int cOK = -1;
        private int cOL = 0;
        private boolean cOM = false;

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (d.this.aLC != null && !d.this.mIsBackground) {
                d.this.aLC.onScrollStateChanged(absListView, i);
            }
            if (i == 0) {
                u.Ww().cA(true);
                this.cOM = false;
                return;
            }
            if (i == 1) {
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (this.cOL > i) {
                this.cOM = true;
            }
            if (d.this.aLC != null && !d.this.mIsBackground) {
                d.this.aLC.a(absListView, this.cOL, i, i2, i3);
            }
            this.cOL = i;
            int i4 = (i + i2) - 1;
            if (!this.cOM && this.cOK != i4) {
                this.cOK = i4;
            }
            if (this.cOM && this.cOK != i) {
                this.cOK = i;
            }
        }
    };
    private View.OnTouchListener aLD = new View.OnTouchListener() { // from class: com.baidu.tieba.homepage.concern.d.2
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (d.this.cOH != null) {
                d.this.cOH.onTouch(view, motionEvent);
            }
            if (d.this.cwS != null) {
                d.this.cwS.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private a.InterfaceC0080a bUZ = new a.InterfaceC0080a() { // from class: com.baidu.tieba.homepage.concern.d.3
        @Override // com.baidu.tieba.e.a.InterfaceC0080a
        public void ag(int i, int i2) {
            d.this.cjw = true;
        }

        @Override // com.baidu.tieba.e.a.InterfaceC0080a
        public void ah(int i, int i2) {
            d.this.cjw = false;
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void anI();

        void lg(String str);

        void onError(int i, String str);

        void u(boolean z, boolean z2);
    }

    public void setTabInForeBackgroundState(boolean z) {
        this.mIsBackground = z;
    }

    public void eJ(boolean z) {
        this.mIsBackground = z;
    }

    public d(e<?> eVar, BdTypeListView bdTypeListView, com.baidu.tieba.homepage.concern.a aVar) {
        this.mListView = bdTypeListView;
        this.mListView.setOnTouchListener(this.aLD);
        this.cwS = new com.baidu.tieba.e.a();
        this.cOI = new com.baidu.tieba.homepage.concern.c.a();
        this.cwS.a(this.bUZ);
        this.cOG = aVar;
        bdTypeListView.setOnScrollListener(this.mOnScrollListener);
    }

    public void setRecommendFrsNavigationAnimDispatcher(r rVar) {
        if (rVar != null) {
            this.aLC = rVar.Hh();
            this.cOH = rVar.Hi();
        }
    }

    public void update() {
        if (this.mDataList.size() == 0 && !this.cOF) {
            anL();
        } else {
            anJ();
        }
    }

    public void MN() {
        if (!wT() && this.hasMore && this.cOD != null) {
            setIsLoading(true);
            this.cOD.lg(this.pageTag);
        }
    }

    public void a(boolean z, DataRes dataRes, int i, String str) {
        setIsLoading(false);
        this.mListView.completePullRefreshPostDelayed(2000L);
        if (i != 0 || dataRes == null || !a(true, z, dataRes)) {
            if (this.mDataList.size() > 0) {
                if (this.cOD != null) {
                    this.cOD.onError(1, str);
                    return;
                }
                return;
            } else if (this.cOD != null) {
                this.cOD.onError(2, str);
                return;
            } else {
                return;
            }
        }
        if (this.cOD != null) {
            this.cOD.u(z, false);
        }
        anM();
    }

    public void fC(boolean z) {
        if (z) {
            this.cOG.notifyDataSetChanged();
        }
    }

    private void anJ() {
        if (this.cOD != null) {
            this.cOD.anI();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(DataRes dataRes) {
        this.cOF = true;
        if (dataRes != null) {
            if (a(false, true, dataRes)) {
                if (this.cOD != null) {
                    this.cOD.u(false, true);
                    return;
                }
                return;
            }
            anJ();
            return;
        }
        anJ();
    }

    private List<f> a(boolean z, DataRes.Builder builder, boolean z2) {
        if (this.cOE == null) {
            this.cOE = new DataRes.Builder();
        }
        if (builder == null) {
            builder = new DataRes.Builder();
        }
        com.baidu.tieba.homepage.personalize.model.c a2 = this.cOI.a(z, this.cOE, builder, z2 ? 0 : 1);
        if (a2 == null) {
            return null;
        }
        List<f> list = a2.aSH;
        this.cOJ = a2.cTw;
        return list;
    }

    private List<f> a(DataRes.Builder builder) {
        if (builder == null || com.baidu.tbadk.core.util.u.v(builder.user_list)) {
            return null;
        }
        bi(builder.user_list);
        ArrayList arrayList = new ArrayList();
        if (!com.baidu.tbadk.core.util.u.v(builder.user_list)) {
            int i = 0;
            for (UserList userList : builder.user_list) {
                if (userList != null) {
                    if (i == 30) {
                        break;
                    }
                    com.baidu.tieba.homepage.concern.b.c cVar = this.cHP.get(userList.id.longValue());
                    if (cVar != null) {
                        com.baidu.tieba.homepage.concern.b.b bVar = new com.baidu.tieba.homepage.concern.b.b();
                        bVar.cPh = cVar;
                        bVar.anO();
                        arrayList.add(bVar);
                        i++;
                    }
                }
            }
        }
        this.cHP.clear();
        return arrayList;
    }

    private void bi(List<UserList> list) {
        if (this.cHP == null) {
            this.cHP = new LongSparseArray<>();
        }
        for (UserList userList : list) {
            com.baidu.tieba.homepage.concern.b.b bVar = new com.baidu.tieba.homepage.concern.b.b();
            bVar.cPh = new com.baidu.tieba.homepage.concern.b.c();
            bVar.cPh.a(userList);
            if (!StringUtils.isNull(bVar.cPh.getName()) && bVar.cPh.getId() != 0) {
                this.cHP.put(userList.id.longValue(), bVar.cPh);
            }
        }
    }

    public List<f> getDataList() {
        return this.mDataList;
    }

    public void anK() {
        this.cOG.bo(this.mDataList);
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
            aVar.aiO = builder.user_tips;
            this.mDataList.add(aVar);
        }
        List<f> a3 = a(builder);
        if (a3 != null) {
            this.mDataList.addAll(a3);
        }
        if (!al.isEmpty(builder.last_tips)) {
            com.baidu.tieba.homepage.concern.b.a aVar2 = new com.baidu.tieba.homepage.concern.b.a();
            aVar2.aiO = builder.last_tips;
            aVar2.cPf = true;
            this.mDataList.add(aVar2);
        }
        this.hasMore = builder.has_more.intValue() == 1;
        if (com.baidu.tbadk.core.util.u.v(this.mDataList)) {
            return false;
        }
        if (z2) {
            this.cOE.page_tag = dataRes.page_tag;
            this.cOE.has_more = dataRes.has_more;
            this.cOE.last_tips = dataRes.last_tips;
            this.cOE.user_tips = dataRes.user_tips;
            this.cOE.user_list = dataRes.user_list;
        }
        this.cOE.banner_user_story = dataRes.banner_user_story;
        this.cOG.bo(this.mDataList);
        return true;
    }

    private void anL() {
        com.baidu.tbadk.util.u.a(new t<DataRes>() { // from class: com.baidu.tieba.homepage.concern.d.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.t
            /* renamed from: anN */
            public DataRes doInBackground() {
                l<byte[]> L = com.baidu.tbadk.core.c.a.td().L("tb.concern_page", TbadkCoreApplication.getCurrentAccount());
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

    private void anM() {
        if (this.cOE != null) {
            DataRes.Builder builder = new DataRes.Builder(this.cOE.build(true));
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
                    com.baidu.tbadk.core.c.a.td().L("tb.concern_page", TbadkCoreApplication.getCurrentAccount()).k("0", builder2.build(true).toByteArray());
                    return null;
                } catch (Exception e) {
                    BdLog.e(e);
                    return null;
                }
            }
        }, null);
    }

    public void a(a aVar) {
        this.cOD = aVar;
    }

    private boolean wT() {
        return this.mIsLoading;
    }

    private void setIsLoading(boolean z) {
        this.mIsLoading = z;
    }

    public boolean hasMore() {
        return this.hasMore;
    }
}
