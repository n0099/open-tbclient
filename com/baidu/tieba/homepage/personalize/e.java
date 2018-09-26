package com.baidu.tieba.homepage.personalize;

import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.h;
import com.baidu.baiduarsdk.ArBridge;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.ab;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tbadk.util.t;
import com.baidu.tbadk.util.u;
import com.baidu.tbadk.util.w;
import com.baidu.tbadk.util.x;
import com.baidu.tieba.ala.LiveRoomClosedQueryMessage;
import com.baidu.tieba.card.v;
import com.baidu.tieba.e;
import com.baidu.tieba.f.a;
import com.baidu.tieba.frs.as;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import com.baidu.tieba.homepage.personalize.a.l;
import com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout;
import com.baidu.tieba.homepage.personalize.data.g;
import com.baidu.tieba.play.m;
import com.squareup.wire.Wire;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import org.json.JSONObject;
import tbclient.App;
import tbclient.BannerList;
import tbclient.GodInfo;
import tbclient.Personalized.DataRes;
import tbclient.Personalized.FloatInfo;
import tbclient.ThreadInfo;
import tbclient.User;
import tbclient.Zan;
/* loaded from: classes2.dex */
public class e {
    private View.OnTouchListener aMz;
    private t aZW;
    private com.baidu.tieba.f.a dNM;
    private boolean dYB;
    private com.baidu.tieba.tbadkCore.data.e dsh;
    private m dur;
    private final BdTypeRecyclerView dwt;
    private ScrollFragmentTabHost edZ;
    private final long eeQ;
    private final b eeR;
    private DataRes.Builder eeT;
    private as eeX;
    private final com.baidu.tieba.homepage.personalize.model.a eeY;
    private int eec;
    private final l eem;
    private final BigdaySwipeRefreshLayout eeu;
    private int efc;
    private g efe;
    private Runnable efm;
    private final TbPageContext<?> mPageContext;
    private a eeS = null;
    private final List<h> mDataList = new LinkedList();
    private int mPn = 1;
    private boolean mIsLoading = false;
    private boolean eam = false;
    private long eeU = 0;
    private int eeV = 1;
    private int eeW = 0;
    private TextView anY = null;
    private int dwe = 2000;
    private com.baidu.tbadk.l.c eeZ = null;
    private boolean duj = false;
    private int dtE = 0;
    private int bzS = 0;
    private boolean mIsBackground = false;
    private boolean efa = true;
    private boolean efb = false;
    private boolean efd = false;
    private boolean eff = true;
    private FloatInfo efg = null;
    private RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.e.12
        private int efs = -1;
        private int ear = 0;
        private boolean eft = false;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (e.this.eeZ == null) {
                e.this.eeZ = new com.baidu.tbadk.l.c();
                e.this.eeZ.fx(ArBridge.MessageType.MSG_TYPE_RESUME_MUSIC);
                e.this.eeZ.pageType = 1;
            }
            if (e.this.aZW != null && !e.this.mIsBackground) {
                e.this.aZW.g(recyclerView, i);
            }
            if (i == 0) {
                c.d(e.this.dwt);
                e.this.eeZ.LQ();
                v.akM().dc(true);
                if (this.eft) {
                    e.this.aGC();
                }
                this.eft = false;
                if (e.this.dur != null && e.this.efa) {
                    e.this.dur.a(e.this.dtE, e.this.bzS, e.this.duj, 1);
                    return;
                }
                return;
            }
            e.this.eeZ.LP();
            if (i == 1 && e.this.eeX != null) {
                e.this.eeX.hideTip();
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            int i3;
            int i4 = 0;
            if (recyclerView == null || !(recyclerView instanceof BdRecyclerView)) {
                i3 = 0;
            } else {
                i3 = ((BdRecyclerView) recyclerView).getFirstVisiblePosition();
                i4 = ((BdRecyclerView) recyclerView).getLastVisiblePosition();
            }
            onScroll(i3, (i4 - i3) + 1);
        }

        public void onScroll(int i, int i2) {
            if (this.ear > i) {
                this.eft = true;
            }
            if (e.this.aZW != null && !e.this.mIsBackground) {
                e.this.aZW.onScroll(this.ear, i);
            }
            this.ear = i;
            int i3 = (i + i2) - 1;
            if (!this.eft && this.efs != i3) {
                this.efs = i3;
                e.this.nv(this.efs);
            }
            if (this.eft && this.efs != i) {
                this.efs = i;
                e.this.nv(this.efs);
            }
            e.this.efl = i;
            e.this.dtE = i;
            e.this.bzS = (i + i2) - 1;
        }
    };
    private View.OnTouchListener aZX = new View.OnTouchListener() { // from class: com.baidu.tieba.homepage.personalize.e.14
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (e.this.aMz != null) {
                e.this.aMz.onTouch(view, motionEvent);
            }
            if (e.this.dNM != null) {
                e.this.dNM.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private a.InterfaceC0145a bPQ = new a.InterfaceC0145a() { // from class: com.baidu.tieba.homepage.personalize.e.15
        @Override // com.baidu.tieba.f.a.InterfaceC0145a
        public void ac(int i, int i2) {
            e.this.duj = true;
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0145a
        public void ad(int i, int i2) {
            e.this.duj = false;
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0145a
        public void ae(int i, int i2) {
        }
    };
    private View.OnClickListener efh = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.e.16
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (e.this.eeX != null) {
                e.this.eeX.hideTip();
            }
            if (e.this.eeV == 1 && e.this.dwt != null) {
                e.this.dwt.setSelection(0);
                e.this.eeu.setRefreshing(true);
            }
        }
    };
    private final CustomMessageListener efi = new CustomMessageListener(2001399) { // from class: com.baidu.tieba.homepage.personalize.e.17
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (e.this.dwt != null) {
                e.this.dur.aHP();
                e.this.efa = false;
                e.this.eeu.setRefreshing(true);
            }
        }
    };
    private CustomMessageListener dzq = new CustomMessageListener(2004004) { // from class: com.baidu.tieba.homepage.personalize.e.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            bb bbVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bb) && e.this.eeT != null && com.baidu.tbadk.core.util.v.y(e.this.eeT.thread_list) != 0 && (bbVar = (bb) customResponsedMessage.getData()) != null && bbVar.vZ() != null && bbVar.getId() != null && com.baidu.tbadk.core.util.v.y(e.this.eeT.thread_list) != 0) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < e.this.eeT.thread_list.size()) {
                        ThreadInfo threadInfo = e.this.eeT.thread_list.get(i2);
                        if (threadInfo == null || threadInfo.id.longValue() != com.baidu.adp.lib.g.b.d(bbVar.getId(), -1L)) {
                            i = i2 + 1;
                        } else {
                            ThreadInfo.Builder builder = new ThreadInfo.Builder(threadInfo);
                            Zan.Builder builder2 = new Zan.Builder(builder.zan);
                            builder2.num = Integer.valueOf((int) bbVar.vZ().getNum());
                            builder.zan = builder2.build(true);
                            e.this.eeT.thread_list.set(i2, builder.build(true));
                            return;
                        }
                    } else {
                        return;
                    }
                }
            }
        }
    };
    private CustomMessageListener efj = new CustomMessageListener(2921026) { // from class: com.baidu.tieba.homepage.personalize.e.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            bb bbVar;
            if (customResponsedMessage.getOrginalMessage() instanceof LiveRoomClosedQueryMessage) {
                List<Long> ids = ((LiveRoomClosedQueryMessage) customResponsedMessage.getOrginalMessage()).getIds();
                List<Object> originData = ((LiveRoomClosedQueryMessage) customResponsedMessage.getOrginalMessage()).getOriginData();
                if (!com.baidu.tbadk.core.util.v.z(e.this.mDataList) && !com.baidu.tbadk.core.util.v.z(ids) && !com.baidu.tbadk.core.util.v.z(originData)) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= originData.size()) {
                            break;
                        }
                        if ((originData.get(i2) instanceof bb) && (bbVar = (bb) originData.get(i2)) != null && bbVar.wG() != null && ids.contains(Long.valueOf(bbVar.wG().live_id))) {
                            e.this.mDataList.remove(bbVar);
                        }
                        i = i2 + 1;
                    }
                    if (e.this.eem != null) {
                        e.this.eem.aj(new ArrayList(e.this.mDataList));
                    }
                }
            }
        }
    };
    private CustomMessageListener mAttentionListener = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.homepage.personalize.e.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int intValue;
            if ((customResponsedMessage instanceof UpdateAttentionMessage) && e.this.eeT != null && !com.baidu.tbadk.core.util.v.z(e.this.eeT.thread_list)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid)) {
                    for (int i = 0; i < e.this.eeT.thread_list.size(); i++) {
                        ThreadInfo threadInfo = e.this.eeT.thread_list.get(i);
                        if (threadInfo != null && threadInfo.author != null && threadInfo.author.id.longValue() == com.baidu.adp.lib.g.b.d(updateAttentionMessage.getData().toUid, -1L)) {
                            ThreadInfo.Builder builder = new ThreadInfo.Builder(threadInfo);
                            User.Builder builder2 = new User.Builder(builder.author);
                            GodInfo.Builder builder3 = new GodInfo.Builder(builder2.god_data);
                            if (updateAttentionMessage.getData().isAttention) {
                                intValue = builder2.fans_num.intValue() + 1;
                                builder3.followed = 1;
                            } else {
                                intValue = builder2.fans_num.intValue() - 1;
                                builder3.followed = 0;
                            }
                            builder2.fans_num = Integer.valueOf(intValue);
                            builder2.god_data = builder3.build(true);
                            builder.author = builder2.build(true);
                            e.this.eeT.thread_list.set(i, builder.build(true));
                            return;
                        }
                    }
                }
            }
        }
    };
    private String efk = "lastReadReadPositionKey";
    private int efl = 0;
    private d efn = new d() { // from class: com.baidu.tieba.homepage.personalize.e.6
        @Override // com.baidu.tieba.homepage.personalize.d
        public void nj(final int i) {
            if (e.this.efm == null) {
                e.this.efm = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.e.6.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (e.this.dwt.getHandler() != null) {
                            e.this.dwt.requestFocusFromTouch();
                            if (i <= e.this.dwt.getCount() - 1) {
                                e.this.dwt.setSelection(i);
                            }
                        }
                    }
                };
            }
            e.this.dwt.removeCallbacks(e.this.efm);
            e.this.dwt.post(e.this.efm);
        }
    };
    private CustomMessageListener efo = new CustomMessageListener(2016569) { // from class: com.baidu.tieba.homepage.personalize.e.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && e.this.efe != null) {
                e.this.mDataList.remove(e.this.efe);
                e.this.eem.aj(new ArrayList(e.this.mDataList));
                com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("key_maintab_banner_close_time", System.currentTimeMillis());
            }
        }
    };
    private CustomMessageListener dKW = new CustomMessageListener(2016488) { // from class: com.baidu.tieba.homepage.personalize.e.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.h(customResponsedMessage);
        }
    };
    private CustomMessageListener dKX = new CustomMessageListener(2016553) { // from class: com.baidu.tieba.homepage.personalize.e.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.h(customResponsedMessage);
        }
    };
    private CustomMessageListener dKY = new CustomMessageListener(2016331) { // from class: com.baidu.tieba.homepage.personalize.e.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && e.this.eeT != null && com.baidu.tbadk.core.util.v.y(e.this.eeT.thread_list) != 0) {
                String str = (String) customResponsedMessage.getData();
                e.this.g(str, e.this.mDataList);
                e.this.og(str);
                if (e.this.eem != null) {
                    e.this.eem.aj(new ArrayList(e.this.mDataList));
                }
            }
        }
    };

    /* loaded from: classes2.dex */
    public interface a {
        void H(int i, int i2, int i3);

        void aV(int i, int i2);

        void onError(int i, String str);

        void onSuccess();
    }

    public void hl(boolean z) {
        this.eff = z;
        if (this.eeX != null && !z) {
            this.eeX.hideTip();
        }
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.edZ = scrollFragmentTabHost;
        if (this.edZ != null) {
            this.edZ.setOnTabSelectedListener(new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.personalize.e.1
                @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
                public void nu(int i) {
                    if (e.this.edZ.nt(i) != 1 && e.this.eeX != null) {
                        e.this.eeX.hideTip();
                    }
                }
            });
        }
    }

    public void setTabInForeBackgroundState(boolean z) {
        this.mIsBackground = z;
    }

    public void ga(boolean z) {
        this.mIsBackground = z;
        if (this.dur != null) {
            this.dur.iU(!z);
            if (z) {
                this.dur.aHP();
            } else if (this.efa) {
                this.dur.b(this.dtE, this.bzS, this.duj, true);
            }
        }
    }

    public e(TbPageContext<?> tbPageContext, BdTypeRecyclerView bdTypeRecyclerView, l lVar, BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout) {
        this.mPageContext = tbPageContext;
        this.eeu = bigdaySwipeRefreshLayout;
        this.dwt = bdTypeRecyclerView;
        this.dwt.setOnTouchListener(this.aZX);
        this.dNM = new com.baidu.tieba.f.a();
        this.dNM.a(this.bPQ);
        this.eem = lVar;
        this.eeY = new com.baidu.tieba.homepage.personalize.model.a();
        this.eeQ = com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("recommend_frs_cache_time", 43200L) * 1000;
        bdTypeRecyclerView.setOnScrollListener(this.mOnScrollListener);
        this.eeX = new as();
        aGD();
        this.dur = new m(this.mPageContext, this.dwt);
        this.eeR = new b(this.mDataList, this.eem);
    }

    private boolean aGv() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean(aGx(), true);
    }

    private void aGw() {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean(aGx(), false);
    }

    private String aGx() {
        return "key_rec_pfirst_load_" + TbadkCoreApplication.getCurrentAccount() + "_" + TbConfig.getVersion();
    }

    public void setHeaderViewHeight(int i) {
        this.eec = i;
    }

    public void setRecommendFrsNavigationAnimDispatcher(u uVar) {
        if (uVar != null) {
            this.aZW = uVar.MQ();
            this.aMz = uVar.MR();
        }
    }

    public void showFloatingView() {
        if (this.aZW != null) {
            this.aZW.cr(true);
        }
    }

    public void update() {
        com.baidu.tieba.homepage.framework.a.aFU().k(System.currentTimeMillis(), 1);
        this.mPn = 1;
        this.efd = true;
        if (this.mDataList.size() == 0 && !aGv()) {
            if (!this.eam) {
                uz();
                return;
            }
            return;
        }
        uy();
    }

    public void aW(int i, int i2) {
        bb bbVar;
        if (!com.baidu.tbadk.core.util.v.z(this.mDataList) && this.mDataList.size() > i) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            while (i < this.mDataList.size() && i <= i2) {
                if (this.mDataList.get(i).getType().getId() == bb.akb.getId() && (bbVar = (bb) this.mDataList.get(i)) != null && bbVar.wG() != null) {
                    arrayList.add(Long.valueOf(bbVar.wG().live_id));
                    arrayList2.add(bbVar);
                }
                i++;
            }
            if (!com.baidu.tbadk.core.util.v.z(arrayList)) {
                MessageManager.getInstance().sendMessage(new LiveRoomClosedQueryMessage(arrayList, arrayList2));
            }
        }
    }

    public void aGy() {
        if (this.dur != null && !this.mIsBackground && this.efa) {
            this.dur.b(this.dtE, this.bzS, this.duj, true);
        }
        if (this.efb) {
            if (this.dYB) {
                if (hm(false)) {
                    aX(3, this.eeW);
                } else if (this.efc > 0) {
                    aX(2, this.eeW);
                }
            } else if (!this.dYB && this.eeW == 0) {
                aX(2, 0);
            }
            com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("recommend_frs_refresh_time", System.currentTimeMillis());
            this.efb = false;
            this.dYB = false;
            this.efc = 0;
            if (this.efd) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
            }
            this.efd = false;
        }
    }

    public void Vd() {
        if (BO()) {
            com.baidu.tieba.homepage.framework.a.aFU().k(0L, 1);
        } else if (this.eeS != null) {
            aGA();
            this.mPn++;
            setIsLoading(true);
            this.eeS.H(this.mPn, (this.eeT == null || this.eeT.thread_list == null) ? 0 : this.eeT.thread_list.size(), 0);
        }
    }

    public void a(boolean z, boolean z2, DataRes dataRes, int i, String str) {
        if (z) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("recommend_frs_guide_time", System.currentTimeMillis());
        }
        int size = (this.eeT == null || this.eeT.thread_list == null) ? 0 : this.eeT.thread_list.size();
        if (i != 0 || dataRes == null || !a(true, z, z2, dataRes)) {
            this.efb = false;
            if (this.mDataList.size() > 0) {
                if (this.eeS != null) {
                    this.eeS.onError(1, str);
                }
            } else if (this.eeS != null) {
                this.eeS.onError(2, str);
            }
        } else {
            aGw();
            if (this.eeS != null) {
                this.eeS.onSuccess();
            }
            this.efb = true;
            this.dYB = z;
            this.efc = size;
            aqK();
        }
        setIsLoading(false);
        if (this.eeu != null) {
            this.eeu.setRefreshing(false);
        }
    }

    public void hf(boolean z) {
        if (z) {
            this.eem.notifyDataSetChanged();
        }
        if (!aGz()) {
            aGC();
        }
    }

    public void onDestroy() {
        if (this.dur != null) {
            this.dur.destroy();
        }
        if (this.eeX != null) {
            this.eeX.onDestroy();
        }
        if (this.eeR != null) {
            this.eeR.onDestroy();
        }
        if (this.dwt != null) {
            this.dwt.removeCallbacks(this.efm);
        }
    }

    public void onPause() {
        c.d(this.dwt);
        nw(this.efl);
        if (this.eeZ != null) {
            this.eeZ.LR();
        }
    }

    public boolean aGz() {
        if (hm(false)) {
            if (this.dwt != null) {
                this.dwt.setSelection(0);
                this.eeu.setRefreshing(true);
                return true;
            }
            return true;
        }
        return false;
    }

    private void uy() {
        if (this.eeS != null) {
            this.eeS.aV((this.eeT == null || this.eeT.thread_list == null || aGB()) ? 0 : this.eeT.thread_list.size(), 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(DataRes dataRes) {
        this.eam = true;
        if (dataRes != null) {
            if (a(false, true, true, dataRes) && !aGB()) {
                if (this.eeS != null) {
                    this.eeS.onSuccess();
                }
                aGC();
                return;
            }
            uy();
            return;
        }
        uy();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.util.Set] */
    private void k(List<h> list, int i) {
        AdvertAppInfo ale;
        AdvertAppInfo ale2;
        if (!com.baidu.tbadk.core.util.v.z(list)) {
            Set<h> tE = com.baidu.tieba.recapp.report.a.tE("NEWINDEX");
            HashSet hashSet = tE == null ? new HashSet() : tE;
            HashSet hashSet2 = new HashSet();
            for (h hVar : list) {
                if (hVar != null) {
                    for (h hVar2 : hashSet) {
                        if ((hVar instanceof com.baidu.tieba.card.data.d) && (ale2 = ((com.baidu.tieba.card.data.d) hVar).ale()) != null && hVar2 != null && (hVar2 instanceof AdvertAppInfo) && hVar2.hashCode() == ale2.hashCode()) {
                            ale2.advertAppContext = ((AdvertAppInfo) hVar2).advertAppContext;
                        }
                    }
                    if (hVar != null && (hVar instanceof com.baidu.tieba.card.data.d) && (ale = ((com.baidu.tieba.card.data.d) hVar).ale()) != null && ale.advertAppContext == null) {
                        ale.advertAppContext = new com.baidu.tbadk.core.data.b();
                        ale.advertAppContext.page = "NEWINDEX";
                        ale.advertAppContext.pn = this.mPn;
                        ale.advertAppContext.extensionInfo = ale.extensionInfo;
                        ale.advertAppContext.Rz = false;
                        hashSet2.add(ale);
                    }
                }
            }
            hashSet.addAll(hashSet2);
            com.baidu.tieba.recapp.report.a.b("NEWINDEX", hashSet);
        }
    }

    private boolean a(boolean z, boolean z2, boolean z3, DataRes dataRes) {
        List<h> list;
        boolean z4;
        if (dataRes == null) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        this.eeU = dataRes.sug_seconds.intValue() * 1000;
        if (z2 && aGB()) {
            this.eeT = null;
        }
        int size = z2 ? 0 : this.mDataList.size();
        DataRes.Builder builder = new DataRes.Builder(dataRes);
        this.mDataList.clear();
        com.baidu.tieba.homepage.personalize.model.c a2 = this.eeY.a(z, this.eeT, builder, z2 ? 0 : 1);
        if (a2 == null) {
            list = null;
        } else {
            List<h> list2 = a2.bny;
            this.eeW = a2.egP;
            list = list2;
        }
        if (list != null) {
            this.mDataList.addAll(list);
            k(list, size);
            a(z2 ? 0 : 1, list, size);
            if (this.efd) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
            }
        }
        if (this.eeT == null) {
            this.eeT = builder;
            this.eeR.bS(this.eeT.thread_list);
        }
        if (this.mDataList.size() == 0) {
            z4 = false;
        } else {
            if (z2) {
                if (dataRes.live_answer != null) {
                    this.efe = new g();
                    this.efe.a(dataRes.live_answer);
                    this.eeT.live_answer = dataRes.live_answer;
                } else if (z) {
                    this.efe = null;
                    this.eeT.live_answer = null;
                }
                this.efg = dataRes.float_info;
                this.eeT.float_info = dataRes.float_info;
            }
            long j = com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("key_maintab_banner_close_time", 0L);
            if (this.efe != null && !ao.Y(j)) {
                this.mDataList.add(0, this.efe);
            }
            LinkedList linkedList = new LinkedList(this.mDataList);
            this.eem.setFromCDN(dataRes.is_new_url.intValue() == 1);
            this.eem.aj(linkedList);
            z4 = true;
            if (this.dur != null && this.efa) {
                this.dur.b(this.dtE, this.bzS, this.duj, true);
            }
        }
        com.baidu.tieba.homepage.framework.a.aFU().i(System.currentTimeMillis() - currentTimeMillis, 1);
        long ni = com.baidu.tieba.homepage.framework.a.aFU().ni(1);
        if (ni > 0) {
            com.baidu.tieba.homepage.framework.a.aFU().j(System.currentTimeMillis() - ni, 1);
            com.baidu.tieba.homepage.framework.a.aFU().k(0L, 1);
        }
        if (dataRes.anti != null && dataRes.anti.block_pop_info != null) {
            com.baidu.tieba.ueg.c.d(dataRes.anti.block_pop_info);
        }
        com.baidu.tbadk.core.data.as asVar = new com.baidu.tbadk.core.data.as();
        asVar.a(dataRes.recom_post_topic);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921333, asVar));
        return z4;
    }

    private void aGA() {
        if (com.baidu.tbadk.core.util.v.y(this.mDataList) >= this.eeY.aGR() - 40) {
            com.baidu.tieba.homepage.personalize.model.c a2 = this.eeY.a(true, this.eeT, (DataRes.Builder) null, 1);
            List<h> list = a2 != null ? a2.bny : null;
            if (list != null) {
                this.mDataList.clear();
                this.mDataList.addAll(list);
                this.eem.aj(new LinkedList(this.mDataList));
            }
        }
    }

    private void uz() {
        this.eam = true;
        x.a(new w<DataRes>() { // from class: com.baidu.tieba.homepage.personalize.e.18
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.w
            /* renamed from: aGH */
            public DataRes doInBackground() {
                com.baidu.adp.lib.cache.l<byte[]> W = com.baidu.tbadk.core.c.a.yh().W("tb.rec_frs_update", TbadkCoreApplication.getCurrentAccount());
                if (W == null) {
                    return null;
                }
                byte[] bArr = W.get("0");
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
        }, new com.baidu.tbadk.util.h<DataRes>() { // from class: com.baidu.tieba.homepage.personalize.e.19
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.h
            /* renamed from: b */
            public void onReturnDataInUI(DataRes dataRes) {
                e.this.a(dataRes);
            }
        });
    }

    private void aqK() {
        if (this.eeT != null) {
            DataRes.Builder builder = new DataRes.Builder(this.eeT.build(true));
            if (builder.thread_list != null && builder.thread_list.size() > 30) {
                builder.thread_list = builder.thread_list.subList(0, 30);
            }
            a(builder, builder.thread_list != null ? builder.thread_list.size() : 0);
            a(builder);
        }
    }

    private void a(DataRes.Builder builder, int i) {
        if (builder != null && builder.banner_list != null && builder.banner_list.app != null) {
            BannerList.Builder builder2 = new BannerList.Builder(builder.banner_list);
            if (builder2.app != null) {
                Iterator<App> it = builder2.app.iterator();
                int i2 = 0;
                while (it.hasNext()) {
                    App next = it.next();
                    if (next != null) {
                        int l = com.baidu.adp.lib.g.b.l(next.pos_name, -1);
                        if (l < 0) {
                            it.remove();
                        } else if (l < i + i2 + 1) {
                            i2++;
                        } else {
                            it.remove();
                        }
                    } else {
                        it.remove();
                    }
                    i2 = i2;
                }
                builder.banner_list = builder2.build(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void og(String str) {
        if (!TextUtils.isEmpty(str) && this.eeT != null && this.eeT.banner_list != null && this.eeT.banner_list.app != null && this.eeT.banner_list.app.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (App app : this.eeT.banner_list.app) {
                if (app != null && str.equals(app.id)) {
                    arrayList.add(app);
                }
            }
            BannerList.Builder builder = new BannerList.Builder(this.eeT.banner_list);
            if (builder.app != null) {
                builder.app.removeAll(arrayList);
            }
            this.eeT.banner_list = builder.build(false);
            DataRes.Builder builder2 = new DataRes.Builder(this.eeT.build(true));
            builder2.banner_list = builder.build(true);
            a(builder2);
        }
    }

    private void a(final DataRes.Builder builder) {
        x.a(new w<Object>() { // from class: com.baidu.tieba.homepage.personalize.e.20
            @Override // com.baidu.tbadk.util.w
            public Object doInBackground() {
                DataRes.Builder builder2 = new DataRes.Builder(builder.build(true));
                e.this.eeR.bT(builder2.thread_list);
                try {
                    com.baidu.tbadk.core.c.a.yh().W("tb.rec_frs_update", TbadkCoreApplication.getCurrentAccount()).e("0", builder2.build(true).toByteArray());
                    return null;
                } catch (Exception e) {
                    BdLog.e(e);
                    return null;
                }
            }
        }, null);
    }

    private boolean aGB() {
        return hm(true);
    }

    private boolean hm(boolean z) {
        long j = com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("recommend_frs_refresh_time", 0L);
        return j == 0 ? z : Math.abs(System.currentTimeMillis() - j) > this.eeQ;
    }

    public void a(a aVar) {
        this.eeS = aVar;
    }

    private boolean BO() {
        return this.mIsLoading;
    }

    private void setIsLoading(boolean z) {
        this.mIsLoading = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aGC() {
        long j = com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("recommend_frs_guide_time", 0L);
        if (this.eeU != 0) {
            if (j == 0 || Math.abs(System.currentTimeMillis() - j) > this.eeU) {
                aX(1, 0);
            }
        }
    }

    public void aGs() {
        boolean z = true;
        com.baidu.tbadk.coreExtra.data.b activityPrizeData = TbadkCoreApplication.getInst().getActivityPrizeData();
        if (activityPrizeData.CO() && !StringUtils.isNull(activityPrizeData.CW())) {
            String currentDay = UtilHelper.getCurrentDay();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            String str = "";
            if (!StringUtils.isNull(currentAccount)) {
                String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("activity_prize_feed_text_time", "");
                if (!StringUtils.isNull(string)) {
                    String[] split = string.split("@");
                    if (split != null && split.length == 2) {
                        String str2 = split[0];
                        String[] split2 = split[1].split(",");
                        if (!StringUtils.isNull(str2) && split2.length != 0) {
                            if (str2.equals(currentDay)) {
                                List<String> asList = Arrays.asList(split2);
                                if (asList.contains(currentAccount)) {
                                    z = false;
                                } else {
                                    StringBuilder sb = new StringBuilder();
                                    sb.append(currentDay).append("@");
                                    for (String str3 : asList) {
                                        sb.append(str3).append(",");
                                    }
                                    str = sb.append(currentAccount).toString();
                                }
                            } else {
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append(currentDay).append("@");
                                sb2.append(currentAccount);
                                str = sb2.toString();
                            }
                        } else {
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append(currentDay).append("@");
                            sb3.append(currentAccount);
                            str = sb3.toString();
                        }
                    } else {
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append(currentDay).append("@");
                        sb4.append(currentAccount);
                        str = sb4.toString();
                    }
                } else {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(currentDay).append("@");
                    sb5.append(currentAccount);
                    str = sb5.toString();
                }
                if (z) {
                    aX(4, 0);
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putString("activity_prize_feed_text_time", str);
                }
            }
        }
    }

    private void aX(int i, int i2) {
        FrameLayout.LayoutParams layoutParams;
        if (this.edZ != null) {
            this.eeX.ayc();
        }
        if (this.edZ != null && this.edZ.getCurrentTabType() != 1) {
            this.eeX.hideTip();
        } else if (!this.eff) {
            this.eeX.hideTip();
        } else {
            this.eeV = i;
            String str = null;
            if (i == 1) {
                str = TbadkCoreApplication.getInst().getString(e.j.recommend_frs_refresh_guide);
            } else if (i == 2) {
                if (i2 > 0) {
                    str = String.format(TbadkCoreApplication.getInst().getString(e.j.recommend_frs_refresh_return), Integer.valueOf(i2));
                } else {
                    str = TbadkCoreApplication.getInst().getString(e.j.recommend_frs_refresh_nodata);
                }
            } else if (i == 3) {
                str = TbadkCoreApplication.getInst().getString(e.j.recommend_frs_refresh_cache_invalid);
            } else if (i == 4) {
                str = TbadkCoreApplication.getInst().getActivityPrizeData().CW();
            }
            if (!TextUtils.isEmpty(str)) {
                if (this.anY == null) {
                    this.anY = new TextView(this.mPageContext.getPageActivity());
                    this.anY.setGravity(17);
                    this.anY.setOnClickListener(this.efh);
                }
                this.eeX.ayc();
                FrameLayout frameLayout = this.edZ.getFrameLayout();
                if (frameLayout != null && this.anY.getParent() == null) {
                    if (i == 1) {
                        if (j.kK()) {
                            int dimensionPixelSize = this.mPageContext.getResources().getDimensionPixelSize(e.C0141e.ds20);
                            int dimensionPixelSize2 = this.mPageContext.getResources().getDimensionPixelSize(e.C0141e.ds40);
                            this.anY.setPadding(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
                            this.anY.setTextSize(0, this.mPageContext.getResources().getDimensionPixelSize(e.C0141e.fontsize28));
                            com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("recommend_frs_guide_time", System.currentTimeMillis());
                            al.i(this.anY, e.f.bg_home_float);
                            al.h(this.anY, e.d.cp_link_tip_a);
                            layoutParams = new FrameLayout.LayoutParams(-2, -2);
                            layoutParams.gravity = 49;
                            layoutParams.topMargin = this.eec;
                        } else {
                            return;
                        }
                    } else {
                        this.anY.setPadding(0, 0, 0, 0);
                        this.anY.setTextSize(0, this.mPageContext.getResources().getDimensionPixelSize(e.C0141e.fontsize24));
                        al.i(this.anY, e.d.common_color_10260);
                        al.h(this.anY, e.d.cp_cont_g);
                        layoutParams = new FrameLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst(), e.C0141e.ds56));
                        layoutParams.gravity = 49;
                        layoutParams.topMargin = this.eec;
                    }
                    this.anY.setText(str);
                    if (i == 1) {
                        this.dwe = 4000;
                    } else if (i == 4) {
                        this.dwe = 3000;
                    } else {
                        this.dwe = 2000;
                    }
                    this.eeX.a(this.anY, frameLayout, layoutParams, this.dwe);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(Long l) {
        if (this.eeT != null && this.eeT.thread_list != null) {
            List<ThreadInfo> list = this.eeT.thread_list;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                ThreadInfo threadInfo = list.get(i);
                if (threadInfo.tid.equals(l) && threadInfo.top_agree_post != null) {
                    ThreadInfo.Builder builder = new ThreadInfo.Builder(threadInfo);
                    builder.top_agree_post = null;
                    list.set(i, builder.build(true));
                    aqK();
                    a(false, true, false, this.eeT.build(true));
                    return;
                }
            }
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            if (this.dzq != null) {
                this.dzq.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.dzq);
            }
            if (this.efi != null) {
                this.efi.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.efi);
            }
            this.mAttentionListener.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.mAttentionListener);
            this.efj.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.efj);
            this.dKW.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.dKW);
            this.dKX.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.dKX);
            this.dKY.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.dKY);
            if (this.dur != null) {
                this.dur.setUniqueId(bdUniqueId);
            }
            this.eeR.h(bdUniqueId);
            this.efo.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.efo);
        }
    }

    public void aGD() {
        this.dsh = new com.baidu.tieba.tbadkCore.data.e("new_index", null);
        this.dsh.byn();
    }

    public void a(int i, List<h> list, int i2) {
        int i3;
        int i4;
        if (this.dsh != null) {
            if (i == 0) {
                this.dsh.byn();
            }
            if (list != null && !list.isEmpty()) {
                int[] iArr = com.baidu.tieba.tbadkCore.data.e.gVa;
                int i5 = 0;
                int i6 = 0;
                int i7 = 0;
                while (i7 < list.size() && i6 < iArr.length && (i3 = iArr[i6]) >= 0) {
                    if (list.get(i7) instanceof com.baidu.tieba.card.data.c) {
                        i4 = i5 + 1;
                        if (i4 == i3 - 1) {
                            if (i2 < i7 + 1) {
                                this.dsh.bL(i3, i7 + 1);
                            }
                            i6++;
                        }
                    } else {
                        i4 = i5;
                    }
                    i7++;
                    i6 = i6;
                    i5 = i4;
                }
            }
        }
    }

    public void nv(int i) {
        if ((this.dsh != null ? this.dsh.ug(i) : -1) >= 0 && this.dwt != null && this.dwt.getData() != null && this.dwt.getData().size() > i) {
            this.dsh.uh(i);
        }
    }

    public m awU() {
        return this.dur;
    }

    public void hn(boolean z) {
        this.efa = z;
    }

    public void nw(final int i) {
        x.a(new w<Object>() { // from class: com.baidu.tieba.homepage.personalize.e.5
            @Override // com.baidu.tbadk.util.w
            public Object doInBackground() {
                com.baidu.adp.lib.cache.l<String> X = com.baidu.tbadk.core.c.a.yh().X(e.this.efk, TbadkCoreApplication.getCurrentAccount());
                if (X != null) {
                    X.a(e.this.efk, Integer.toString(i), 43200000L);
                    return null;
                }
                return null;
            }
        }, null);
    }

    public void a(final d dVar) {
        x.a(new w<String>() { // from class: com.baidu.tieba.homepage.personalize.e.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.w
            /* renamed from: aGG */
            public String doInBackground() {
                com.baidu.adp.lib.cache.l<String> X = com.baidu.tbadk.core.c.a.yh().X(e.this.efk, TbadkCoreApplication.getCurrentAccount());
                if (X != null) {
                    return X.get(e.this.efk);
                }
                return null;
            }
        }, new com.baidu.tbadk.util.h<String>() { // from class: com.baidu.tieba.homepage.personalize.e.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.h
            /* renamed from: oh */
            public void onReturnDataInUI(String str) {
                if (dVar != null) {
                    dVar.nj(com.baidu.adp.lib.g.b.l(str, 0));
                }
            }
        });
    }

    public void aGu() {
        c.e(this.dwt);
    }

    public void aGE() {
        a(this.efn);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(CustomResponsedMessage<?> customResponsedMessage) {
        int b;
        String str;
        int i = 0;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.eeT != null && com.baidu.tbadk.core.util.v.y(this.eeT.thread_list) != 0 && com.baidu.tbadk.core.util.v.y(this.mDataList) != 0) {
            JSONObject jSONObject = (JSONObject) customResponsedMessage.getData();
            String optString = jSONObject.optString("tid");
            if (StringUtils.isNull(optString)) {
                String optString2 = jSONObject.optString("liveid");
                if (this.dwt != null && !TextUtils.isEmpty(optString2)) {
                    int i2 = 0;
                    while (true) {
                        if (i2 >= this.dwt.getCount()) {
                            str = optString;
                            break;
                        }
                        h item = this.dwt.getItem(i2);
                        if (item instanceof com.baidu.tieba.card.data.j) {
                            com.baidu.tieba.card.data.j jVar = (com.baidu.tieba.card.data.j) item;
                            if (jVar.UT() != null && jVar.UT().wG() != null && optString2.equals(String.valueOf(jVar.UT().wG().live_id))) {
                                str = jVar.UT().getTid();
                                break;
                            }
                        }
                        i2++;
                    }
                    if (StringUtils.isNull(str)) {
                        return;
                    }
                    optString = str;
                } else {
                    return;
                }
            }
            Iterator<h> it = this.mDataList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                h next = it.next();
                if (next instanceof com.baidu.tieba.card.data.c) {
                    com.baidu.tieba.card.data.c cVar = (com.baidu.tieba.card.data.c) next;
                    if (cVar.UT() != null && cVar.UT().getTid() != null && cVar.UT().getTid().equals(optString)) {
                        it.remove();
                        com.baidu.tieba.homepage.personalize.model.b.bV(this.mDataList);
                        break;
                    }
                }
            }
            if (this.eeT != null && this.eeT.thread_list != null) {
                long d = com.baidu.adp.lib.g.b.d(optString, 0L);
                while (true) {
                    if (i < this.eeT.thread_list.size()) {
                        ThreadInfo threadInfo = this.eeT.thread_list.get(i);
                        if (threadInfo == null || threadInfo.tid == null || threadInfo.tid.longValue() != d) {
                            i++;
                        } else {
                            this.eeT.thread_list.remove(i);
                            aqK();
                            com.baidu.tieba.homepage.personalize.b.d.a(threadInfo.tid.longValue(), i, this.eeT.thread_list, this.mDataList);
                            break;
                        }
                    } else {
                        break;
                    }
                }
                if (this.dwt != null && (b = b(optString, this.dwt)) != -1) {
                    this.dwt.removeItem(b);
                }
            }
        }
    }

    private int b(String str, BdTypeRecyclerView bdTypeRecyclerView) {
        int i = 0;
        int i2 = -1;
        while (true) {
            int i3 = i;
            if (i3 < bdTypeRecyclerView.getCount()) {
                h item = bdTypeRecyclerView.getItem(i3);
                if (item instanceof com.baidu.tieba.card.data.c) {
                    com.baidu.tieba.card.data.c cVar = (com.baidu.tieba.card.data.c) item;
                    if (cVar.UT() != null && cVar.UT().getTid().equals(str)) {
                        i2 = i3;
                    }
                }
                i = i3 + 1;
            } else {
                return i2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(String str, List<h> list) {
        AdvertAppInfo advertAppInfo;
        if (list != null && list.size() > 0 && !TextUtils.isEmpty(str)) {
            Iterator<h> it = list.iterator();
            AdvertAppInfo advertAppInfo2 = null;
            while (it.hasNext()) {
                h next = it.next();
                if (next instanceof com.baidu.tieba.homepage.personalize.data.a) {
                    advertAppInfo = ((com.baidu.tieba.homepage.personalize.data.a) next).ale();
                } else {
                    if (next instanceof ab) {
                        ab abVar = (ab) next;
                        if (abVar.vd() instanceof AdvertAppInfo.ILegoAdvert) {
                            advertAppInfo = ((AdvertAppInfo.ILegoAdvert) abVar.vd()).getAdvertAppInfo();
                        }
                    }
                    advertAppInfo = advertAppInfo2;
                }
                if (advertAppInfo != null && str.equals(advertAppInfo.agf)) {
                    it.remove();
                    advertAppInfo = null;
                }
                advertAppInfo2 = advertAppInfo;
            }
        }
    }

    public FloatInfo aGF() {
        return this.efg;
    }
}
