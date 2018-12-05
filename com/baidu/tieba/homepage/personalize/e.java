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
import com.baidu.mapapi.UIMsg;
import com.baidu.searchbox.ng.ai.apps.network.BaseRequestAction;
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
/* loaded from: classes6.dex */
public class e {
    private View.OnTouchListener aVo;
    private t biL;
    private com.baidu.tieba.tbadkCore.data.e dHZ;
    private m dKi;
    private final BdTypeRecyclerView dMj;
    private com.baidu.tieba.f.a eds;
    private boolean eoJ;
    private final BigdaySwipeRefreshLayout euC;
    private final long euY;
    private final b euZ;
    private ScrollFragmentTabHost eui;
    private final l euu;
    private DataRes.Builder evb;
    private as evf;
    private final com.baidu.tieba.homepage.personalize.model.a evg;
    private int evk;
    private g evm;
    private Runnable evu;
    private int mHeaderHeight;
    private final TbPageContext<?> mPageContext;
    private a eva = null;
    private final List<h> mDataList = new LinkedList();
    private int mPn = 1;
    private boolean mIsLoading = false;
    private boolean equ = false;
    private long evc = 0;
    private int evd = 1;
    private int eve = 0;
    private TextView axd = null;
    private int dLU = 2000;
    private com.baidu.tbadk.l.c evh = null;
    private boolean dKa = false;
    private int dJv = 0;
    private int bNa = 0;
    private boolean mIsBackground = false;
    private boolean evi = true;
    private boolean evj = false;
    private boolean evl = false;
    private boolean evn = true;
    private FloatInfo evo = null;
    private RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.e.12
        private int evA = -1;
        private int eqz = 0;
        private boolean evB = false;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (e.this.evh == null) {
                e.this.evh = new com.baidu.tbadk.l.c();
                e.this.evh.gi(1005);
                e.this.evh.pageType = 1;
            }
            if (e.this.biL != null && !e.this.mIsBackground) {
                e.this.biL.g(recyclerView, i);
            }
            if (i == 0) {
                c.d(e.this.dMj);
                e.this.evh.Pb();
                v.apD().dQ(true);
                if (this.evB) {
                    e.this.aLk();
                }
                this.evB = false;
                if (e.this.dKi != null && e.this.evi) {
                    e.this.dKi.a(e.this.dJv, e.this.bNa, e.this.dKa, 1);
                    return;
                }
                return;
            }
            e.this.evh.Pa();
            if (i == 1 && e.this.evf != null) {
                e.this.evf.hideTip();
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
            if (this.eqz > i) {
                this.evB = true;
            }
            if (e.this.biL != null && !e.this.mIsBackground) {
                e.this.biL.onScroll(this.eqz, i);
            }
            this.eqz = i;
            int i3 = (i + i2) - 1;
            if (!this.evB && this.evA != i3) {
                this.evA = i3;
                e.this.oF(this.evA);
            }
            if (this.evB && this.evA != i) {
                this.evA = i;
                e.this.oF(this.evA);
            }
            e.this.evt = i;
            e.this.dJv = i;
            e.this.bNa = (i + i2) - 1;
        }
    };
    private View.OnTouchListener biM = new View.OnTouchListener() { // from class: com.baidu.tieba.homepage.personalize.e.14
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (e.this.aVo != null) {
                e.this.aVo.onTouch(view, motionEvent);
            }
            if (e.this.eds != null) {
                e.this.eds.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private a.InterfaceC0214a cvL = new a.InterfaceC0214a() { // from class: com.baidu.tieba.homepage.personalize.e.15
        @Override // com.baidu.tieba.f.a.InterfaceC0214a
        public void aq(int i, int i2) {
            e.this.dKa = true;
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0214a
        public void ar(int i, int i2) {
            e.this.dKa = false;
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0214a
        public void as(int i, int i2) {
        }
    };
    private View.OnClickListener evp = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.e.16
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (e.this.evf != null) {
                e.this.evf.hideTip();
            }
            if (e.this.evd == 1 && e.this.dMj != null) {
                e.this.dMj.setSelection(0);
                e.this.euC.setRefreshing(true);
            }
        }
    };
    private final CustomMessageListener evq = new CustomMessageListener(2001399) { // from class: com.baidu.tieba.homepage.personalize.e.17
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (e.this.dMj != null) {
                e.this.dKi.aMx();
                e.this.evi = false;
                e.this.euC.setRefreshing(true);
            }
        }
    };
    private CustomMessageListener dYB = new CustomMessageListener(2004004) { // from class: com.baidu.tieba.homepage.personalize.e.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            bb bbVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bb) && e.this.evb != null && com.baidu.tbadk.core.util.v.H(e.this.evb.thread_list) != 0 && (bbVar = (bb) customResponsedMessage.getData()) != null && bbVar.zt() != null && bbVar.getId() != null && com.baidu.tbadk.core.util.v.H(e.this.evb.thread_list) != 0) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < e.this.evb.thread_list.size()) {
                        ThreadInfo threadInfo = e.this.evb.thread_list.get(i2);
                        if (threadInfo == null || threadInfo.id.longValue() != com.baidu.adp.lib.g.b.d(bbVar.getId(), -1L)) {
                            i = i2 + 1;
                        } else {
                            ThreadInfo.Builder builder = new ThreadInfo.Builder(threadInfo);
                            Zan.Builder builder2 = new Zan.Builder(builder.zan);
                            builder2.num = Integer.valueOf((int) bbVar.zt().getNum());
                            builder.zan = builder2.build(true);
                            e.this.evb.thread_list.set(i2, builder.build(true));
                            return;
                        }
                    } else {
                        return;
                    }
                }
            }
        }
    };
    private CustomMessageListener evr = new CustomMessageListener(2921026) { // from class: com.baidu.tieba.homepage.personalize.e.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            bb bbVar;
            if (customResponsedMessage.getOrginalMessage() instanceof LiveRoomClosedQueryMessage) {
                List<Long> ids = ((LiveRoomClosedQueryMessage) customResponsedMessage.getOrginalMessage()).getIds();
                List<Object> originData = ((LiveRoomClosedQueryMessage) customResponsedMessage.getOrginalMessage()).getOriginData();
                if (!com.baidu.tbadk.core.util.v.I(e.this.mDataList) && !com.baidu.tbadk.core.util.v.I(ids) && !com.baidu.tbadk.core.util.v.I(originData)) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= originData.size()) {
                            break;
                        }
                        if ((originData.get(i2) instanceof bb) && (bbVar = (bb) originData.get(i2)) != null && bbVar.Aa() != null && ids.contains(Long.valueOf(bbVar.Aa().live_id))) {
                            e.this.mDataList.remove(bbVar);
                        }
                        i = i2 + 1;
                    }
                    if (e.this.euu != null) {
                        e.this.euu.ak(new ArrayList(e.this.mDataList));
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
            if ((customResponsedMessage instanceof UpdateAttentionMessage) && e.this.evb != null && !com.baidu.tbadk.core.util.v.I(e.this.evb.thread_list)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid)) {
                    for (int i = 0; i < e.this.evb.thread_list.size(); i++) {
                        ThreadInfo threadInfo = e.this.evb.thread_list.get(i);
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
                            e.this.evb.thread_list.set(i, builder.build(true));
                            return;
                        }
                    }
                }
            }
        }
    };
    private String evs = "lastReadReadPositionKey";
    private int evt = 0;
    private d evv = new d() { // from class: com.baidu.tieba.homepage.personalize.e.6
        @Override // com.baidu.tieba.homepage.personalize.d
        public void ot(final int i) {
            if (e.this.evu == null) {
                e.this.evu = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.e.6.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (e.this.dMj.getHandler() != null) {
                            e.this.dMj.requestFocusFromTouch();
                            if (i <= e.this.dMj.getCount() - 1) {
                                e.this.dMj.setSelection(i);
                            }
                        }
                    }
                };
            }
            e.this.dMj.removeCallbacks(e.this.evu);
            e.this.dMj.post(e.this.evu);
        }
    };
    private CustomMessageListener evw = new CustomMessageListener(2016569) { // from class: com.baidu.tieba.homepage.personalize.e.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && e.this.evm != null) {
                e.this.mDataList.remove(e.this.evm);
                e.this.euu.ak(new ArrayList(e.this.mDataList));
                com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("key_maintab_banner_close_time", System.currentTimeMillis());
            }
        }
    };
    private CustomMessageListener eaC = new CustomMessageListener(2016488) { // from class: com.baidu.tieba.homepage.personalize.e.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.h(customResponsedMessage);
        }
    };
    private CustomMessageListener eaD = new CustomMessageListener(2016553) { // from class: com.baidu.tieba.homepage.personalize.e.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.h(customResponsedMessage);
        }
    };
    private CustomMessageListener eaE = new CustomMessageListener(2016331) { // from class: com.baidu.tieba.homepage.personalize.e.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && e.this.evb != null && com.baidu.tbadk.core.util.v.H(e.this.evb.thread_list) != 0) {
                String str = (String) customResponsedMessage.getData();
                e.this.g(str, e.this.mDataList);
                e.this.pm(str);
                if (e.this.euu != null) {
                    e.this.euu.ak(new ArrayList(e.this.mDataList));
                }
            }
        }
    };

    /* loaded from: classes6.dex */
    public interface a {
        void H(int i, int i2, int i3);

        void onError(int i, String str);

        void onSuccess();

        void s(int i, int i2, int i3, int i4);
    }

    public void hP(boolean z) {
        this.evn = z;
        if (this.evf != null && !z) {
            this.evf.hideTip();
        }
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.eui = scrollFragmentTabHost;
        if (this.eui != null) {
            this.eui.setOnTabSelectedListener(new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.personalize.e.1
                @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
                public void oE(int i) {
                    if (e.this.eui.oD(i) != 1 && e.this.evf != null) {
                        e.this.evf.hideTip();
                    }
                }
            });
        }
    }

    public void setTabInForeBackgroundState(boolean z) {
        this.mIsBackground = z;
    }

    public void gD(boolean z) {
        this.mIsBackground = z;
        if (this.dKi != null) {
            this.dKi.jz(!z);
            if (z) {
                this.dKi.aMx();
            } else if (this.evi) {
                this.dKi.b(this.dJv, this.bNa, this.dKa, true);
            }
        }
    }

    public e(TbPageContext<?> tbPageContext, BdTypeRecyclerView bdTypeRecyclerView, l lVar, BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout) {
        this.mPageContext = tbPageContext;
        this.euC = bigdaySwipeRefreshLayout;
        this.dMj = bdTypeRecyclerView;
        this.dMj.setOnTouchListener(this.biM);
        this.eds = new com.baidu.tieba.f.a();
        this.eds.a(this.cvL);
        this.euu = lVar;
        this.evg = new com.baidu.tieba.homepage.personalize.model.a();
        this.euY = com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("recommend_frs_cache_time", 43200L) * 1000;
        bdTypeRecyclerView.setOnScrollListener(this.mOnScrollListener);
        this.evf = new as();
        aLl();
        this.dKi = new m(this.mPageContext, this.dMj);
        this.euZ = new b(this.mDataList, this.euu);
    }

    private boolean aLd() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean(aLf(), true);
    }

    private void aLe() {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean(aLf(), false);
    }

    private String aLf() {
        return "key_rec_pfirst_load_" + TbadkCoreApplication.getCurrentAccount() + BaseRequestAction.SPLITE + TbConfig.getVersion();
    }

    public void setHeaderViewHeight(int i) {
        this.mHeaderHeight = i;
    }

    public void setRecommendFrsNavigationAnimDispatcher(u uVar) {
        if (uVar != null) {
            this.biL = uVar.Qd();
            this.aVo = uVar.Qe();
        }
    }

    public void showFloatingView() {
        if (this.biL != null) {
            this.biL.cS(true);
        }
    }

    public void update() {
        com.baidu.tieba.homepage.framework.a.aKB().k(System.currentTimeMillis(), 1);
        this.mPn = 1;
        this.evl = true;
        if (this.mDataList.size() == 0 && !aLd()) {
            if (!this.equ) {
                xU();
                return;
            }
            return;
        }
        xT();
    }

    public void aZ(int i, int i2) {
        bb bbVar;
        if (!com.baidu.tbadk.core.util.v.I(this.mDataList) && this.mDataList.size() > i) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            while (i < this.mDataList.size() && i <= i2) {
                if (this.mDataList.get(i).getType().getId() == bb.atk.getId() && (bbVar = (bb) this.mDataList.get(i)) != null && bbVar.Aa() != null) {
                    arrayList.add(Long.valueOf(bbVar.Aa().live_id));
                    arrayList2.add(bbVar);
                }
                i++;
            }
            if (!com.baidu.tbadk.core.util.v.I(arrayList)) {
                MessageManager.getInstance().sendMessage(new LiveRoomClosedQueryMessage(arrayList, arrayList2));
            }
        }
    }

    public void aLg() {
        if (this.dKi != null && !this.mIsBackground && this.evi) {
            this.dKi.b(this.dJv, this.bNa, this.dKa, true);
        }
        if (this.evj) {
            if (this.eoJ) {
                if (hR(false)) {
                    ba(3, this.eve);
                } else if (this.evk > 0) {
                    ba(2, this.eve);
                }
            } else if (!this.eoJ && this.eve == 0) {
                ba(2, 0);
            }
            com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("recommend_frs_refresh_time", System.currentTimeMillis());
            this.evj = false;
            this.eoJ = false;
            this.evk = 0;
            if (this.evl) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
            }
            this.evl = false;
        }
    }

    public void aab() {
        if (Fi()) {
            com.baidu.tieba.homepage.framework.a.aKB().k(0L, 1);
        } else if (this.eva != null) {
            aLi();
            this.mPn++;
            setIsLoading(true);
            this.eva.s(this.mPn, (this.evb == null || this.evb.thread_list == null) ? 0 : this.evb.thread_list.size(), hQ(false), 0);
        }
    }

    public void a(boolean z, boolean z2, DataRes dataRes, int i, String str) {
        if (z) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("recommend_frs_guide_time", System.currentTimeMillis());
        }
        int size = (this.evb == null || this.evb.thread_list == null) ? 0 : this.evb.thread_list.size();
        if (i != 0 || dataRes == null || !a(true, z, z2, dataRes)) {
            this.evj = false;
            if (this.mDataList.size() > 0) {
                if (this.eva != null) {
                    this.eva.onError(1, str);
                }
            } else if (this.eva != null) {
                this.eva.onError(2, str);
            }
        } else {
            aLe();
            if (this.eva != null) {
                this.eva.onSuccess();
            }
            this.evj = true;
            this.eoJ = z;
            this.evk = size;
            avs();
        }
        setIsLoading(false);
        if (this.euC != null) {
            this.euC.setRefreshing(false);
        }
    }

    public void hJ(boolean z) {
        if (z) {
            this.euu.notifyDataSetChanged();
        }
        if (!aLh()) {
            aLk();
        }
    }

    public void onDestroy() {
        if (this.dKi != null) {
            this.dKi.destroy();
        }
        if (this.evf != null) {
            this.evf.onDestroy();
        }
        if (this.euZ != null) {
            this.euZ.onDestroy();
        }
        if (this.dMj != null) {
            this.dMj.removeCallbacks(this.evu);
        }
    }

    public void onPause() {
        c.d(this.dMj);
        oG(this.evt);
        if (this.evh != null) {
            this.evh.Pc();
        }
    }

    public boolean aLh() {
        if (hR(false)) {
            if (this.dMj != null) {
                this.dMj.setSelection(0);
                this.euC.setRefreshing(true);
                return true;
            }
            return true;
        }
        return false;
    }

    private void xT() {
        if (this.eva != null) {
            this.eva.H((this.evb == null || this.evb.thread_list == null || aLj()) ? 0 : this.evb.thread_list.size(), hQ(true), 0);
        }
    }

    public int hQ(boolean z) {
        int i = 0;
        if (this.mDataList == null || this.mDataList.size() == 0) {
            return 0;
        }
        if (z) {
            while (true) {
                int i2 = i;
                if (i2 >= this.mDataList.size()) {
                    break;
                }
                h hVar = this.mDataList.get(i2);
                if (!(hVar instanceof com.baidu.tieba.homepage.personalize.data.a) || hVar.getType() == AdvertAppInfo.ape) {
                    i = i2 + 1;
                } else {
                    return i2;
                }
            }
        } else {
            for (int size = this.mDataList.size() - 1; size >= 0; size--) {
                h hVar2 = this.mDataList.get(size);
                if ((hVar2 instanceof com.baidu.tieba.homepage.personalize.data.a) && hVar2.getType() != AdvertAppInfo.ape) {
                    return (this.mDataList.size() - size) - 1;
                }
            }
        }
        return this.mDataList.size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(DataRes dataRes) {
        this.equ = true;
        if (dataRes != null) {
            if (a(false, true, true, dataRes) && !aLj()) {
                if (this.eva != null) {
                    this.eva.onSuccess();
                }
                aLk();
                return;
            }
            xT();
            return;
        }
        xT();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.util.Set] */
    private void l(List<h> list, int i) {
        AdvertAppInfo apV;
        AdvertAppInfo apV2;
        if (!com.baidu.tbadk.core.util.v.I(list)) {
            Set<h> uL = com.baidu.tieba.recapp.report.a.uL("NEWINDEX");
            HashSet hashSet = uL == null ? new HashSet() : uL;
            HashSet hashSet2 = new HashSet();
            for (h hVar : list) {
                if (hVar != null) {
                    for (h hVar2 : hashSet) {
                        if ((hVar instanceof com.baidu.tieba.card.data.d) && (apV2 = ((com.baidu.tieba.card.data.d) hVar).apV()) != null && hVar2 != null && (hVar2 instanceof AdvertAppInfo) && hVar2.hashCode() == apV2.hashCode()) {
                            apV2.advertAppContext = ((AdvertAppInfo) hVar2).advertAppContext;
                        }
                    }
                    if (hVar != null && (hVar instanceof com.baidu.tieba.card.data.d) && (apV = ((com.baidu.tieba.card.data.d) hVar).apV()) != null && apV.advertAppContext == null) {
                        apV.advertAppContext = new com.baidu.tbadk.core.data.b();
                        apV.advertAppContext.page = "NEWINDEX";
                        apV.advertAppContext.pn = this.mPn;
                        apV.advertAppContext.extensionInfo = apV.extensionInfo;
                        apV.advertAppContext.RT = false;
                        hashSet2.add(apV);
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
        this.evc = dataRes.sug_seconds.intValue() * 1000;
        if (z2 && aLj()) {
            this.evb = null;
        }
        int size = z2 ? 0 : this.mDataList.size();
        DataRes.Builder builder = new DataRes.Builder(dataRes);
        this.mDataList.clear();
        com.baidu.tieba.homepage.personalize.model.c a2 = this.evg.a(z, this.evb, builder, z2 ? 0 : 1);
        if (a2 == null) {
            list = null;
        } else {
            List<h> list2 = a2.bvL;
            this.eve = a2.ewX;
            list = list2;
        }
        if (list != null) {
            this.mDataList.addAll(list);
            l(list, size);
            a(z2 ? 0 : 1, list, size);
            if (this.evl) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
            }
        }
        if (this.evb == null) {
            this.evb = builder;
            this.euZ.ck(this.evb.thread_list);
        }
        if (this.mDataList.size() == 0) {
            z4 = false;
        } else {
            if (z2) {
                if (dataRes.live_answer != null) {
                    this.evm = new g();
                    this.evm.a(dataRes.live_answer);
                    this.evb.live_answer = dataRes.live_answer;
                } else if (z) {
                    this.evm = null;
                    this.evb.live_answer = null;
                }
                this.evo = dataRes.float_info;
                this.evb.float_info = dataRes.float_info;
            }
            long j = com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("key_maintab_banner_close_time", 0L);
            if (this.evm != null && !ao.aj(j)) {
                this.mDataList.add(0, this.evm);
            }
            LinkedList linkedList = new LinkedList(this.mDataList);
            this.euu.setFromCDN(dataRes.is_new_url.intValue() == 1);
            this.euu.ak(linkedList);
            z4 = true;
            if (this.dKi != null && this.evi) {
                this.dKi.b(this.dJv, this.bNa, this.dKa, true);
            }
        }
        com.baidu.tieba.homepage.framework.a.aKB().i(System.currentTimeMillis() - currentTimeMillis, 1);
        long os = com.baidu.tieba.homepage.framework.a.aKB().os(1);
        if (os > 0) {
            com.baidu.tieba.homepage.framework.a.aKB().j(System.currentTimeMillis() - os, 1);
            com.baidu.tieba.homepage.framework.a.aKB().k(0L, 1);
        }
        if (dataRes.anti != null && dataRes.anti.block_pop_info != null) {
            com.baidu.tieba.ueg.c.d(dataRes.anti.block_pop_info);
        }
        com.baidu.tbadk.core.data.as asVar = new com.baidu.tbadk.core.data.as();
        asVar.a(dataRes.recom_post_topic);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921333, asVar));
        return z4;
    }

    private void aLi() {
        if (com.baidu.tbadk.core.util.v.H(this.mDataList) >= this.evg.aLz() - 40) {
            com.baidu.tieba.homepage.personalize.model.c a2 = this.evg.a(true, this.evb, (DataRes.Builder) null, 1);
            List<h> list = a2 != null ? a2.bvL : null;
            if (list != null) {
                this.mDataList.clear();
                this.mDataList.addAll(list);
                this.euu.ak(new LinkedList(this.mDataList));
            }
        }
    }

    private void xU() {
        this.equ = true;
        x.a(new w<DataRes>() { // from class: com.baidu.tieba.homepage.personalize.e.18
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.w
            /* renamed from: aLp */
            public DataRes doInBackground() {
                com.baidu.adp.lib.cache.l<byte[]> am = com.baidu.tbadk.core.c.a.BB().am("tb.rec_frs_update", TbadkCoreApplication.getCurrentAccount());
                if (am == null) {
                    return null;
                }
                byte[] bArr = am.get("0");
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

    private void avs() {
        if (this.evb != null) {
            DataRes.Builder builder = new DataRes.Builder(this.evb.build(true));
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
    public void pm(String str) {
        if (!TextUtils.isEmpty(str) && this.evb != null && this.evb.banner_list != null && this.evb.banner_list.app != null && this.evb.banner_list.app.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (App app : this.evb.banner_list.app) {
                if (app != null && str.equals(app.id)) {
                    arrayList.add(app);
                }
            }
            BannerList.Builder builder = new BannerList.Builder(this.evb.banner_list);
            if (builder.app != null) {
                builder.app.removeAll(arrayList);
            }
            this.evb.banner_list = builder.build(false);
            DataRes.Builder builder2 = new DataRes.Builder(this.evb.build(true));
            builder2.banner_list = builder.build(true);
            a(builder2);
        }
    }

    private void a(final DataRes.Builder builder) {
        x.a(new w<Object>() { // from class: com.baidu.tieba.homepage.personalize.e.20
            @Override // com.baidu.tbadk.util.w
            public Object doInBackground() {
                DataRes.Builder builder2 = new DataRes.Builder(builder.build(true));
                e.this.euZ.cl(builder2.thread_list);
                try {
                    com.baidu.tbadk.core.c.a.BB().am("tb.rec_frs_update", TbadkCoreApplication.getCurrentAccount()).e("0", builder2.build(true).toByteArray());
                    return null;
                } catch (Exception e) {
                    BdLog.e(e);
                    return null;
                }
            }
        }, null);
    }

    private boolean aLj() {
        return hR(true);
    }

    private boolean hR(boolean z) {
        long j = com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("recommend_frs_refresh_time", 0L);
        return j == 0 ? z : Math.abs(System.currentTimeMillis() - j) > this.euY;
    }

    public void a(a aVar) {
        this.eva = aVar;
    }

    private boolean Fi() {
        return this.mIsLoading;
    }

    private void setIsLoading(boolean z) {
        this.mIsLoading = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aLk() {
        long j = com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("recommend_frs_guide_time", 0L);
        if (this.evc != 0) {
            if (j == 0 || Math.abs(System.currentTimeMillis() - j) > this.evc) {
                ba(1, 0);
            }
        }
    }

    public void aLa() {
        boolean z = true;
        com.baidu.tbadk.coreExtra.data.b activityPrizeData = TbadkCoreApplication.getInst().getActivityPrizeData();
        if (activityPrizeData.Gh() && !StringUtils.isNull(activityPrizeData.Gp())) {
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
                    ba(4, 0);
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putString("activity_prize_feed_text_time", str);
                }
            }
        }
    }

    private void ba(int i, int i2) {
        FrameLayout.LayoutParams layoutParams;
        if (this.eui != null) {
            this.evf.aCF();
        }
        if (this.eui != null && this.eui.getCurrentTabType() != 1) {
            this.evf.hideTip();
        } else if (!this.evn) {
            this.evf.hideTip();
        } else {
            this.evd = i;
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
                str = TbadkCoreApplication.getInst().getActivityPrizeData().Gp();
            }
            if (!TextUtils.isEmpty(str)) {
                if (this.axd == null) {
                    this.axd = new TextView(this.mPageContext.getPageActivity());
                    this.axd.setGravity(17);
                    this.axd.setOnClickListener(this.evp);
                }
                this.evf.aCF();
                FrameLayout frameLayout = this.eui.getFrameLayout();
                if (frameLayout != null && this.axd.getParent() == null) {
                    if (i == 1) {
                        if (j.kV()) {
                            int dimensionPixelSize = this.mPageContext.getResources().getDimensionPixelSize(e.C0210e.ds20);
                            int dimensionPixelSize2 = this.mPageContext.getResources().getDimensionPixelSize(e.C0210e.ds40);
                            this.axd.setPadding(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
                            this.axd.setTextSize(0, this.mPageContext.getResources().getDimensionPixelSize(e.C0210e.fontsize28));
                            com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("recommend_frs_guide_time", System.currentTimeMillis());
                            al.i(this.axd, e.f.bg_home_float);
                            al.h(this.axd, e.d.cp_link_tip_a);
                            layoutParams = new FrameLayout.LayoutParams(-2, -2);
                            layoutParams.gravity = 49;
                            layoutParams.topMargin = this.mHeaderHeight;
                        } else {
                            return;
                        }
                    } else {
                        this.axd.setPadding(0, 0, 0, 0);
                        this.axd.setTextSize(0, this.mPageContext.getResources().getDimensionPixelSize(e.C0210e.fontsize24));
                        al.i(this.axd, e.d.common_color_10260);
                        al.h(this.axd, e.d.cp_cont_g);
                        layoutParams = new FrameLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst(), e.C0210e.ds56));
                        layoutParams.gravity = 49;
                        layoutParams.topMargin = this.mHeaderHeight;
                    }
                    this.axd.setText(str);
                    if (i == 1) {
                        this.dLU = UIMsg.m_AppUI.MSG_APP_SAVESCREEN;
                    } else if (i == 4) {
                        this.dLU = 3000;
                    } else {
                        this.dLU = 2000;
                    }
                    this.evf.a(this.axd, frameLayout, layoutParams, this.dLU);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(Long l) {
        if (this.evb != null && this.evb.thread_list != null) {
            List<ThreadInfo> list = this.evb.thread_list;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                ThreadInfo threadInfo = list.get(i);
                if (threadInfo.tid.equals(l) && threadInfo.top_agree_post != null) {
                    ThreadInfo.Builder builder = new ThreadInfo.Builder(threadInfo);
                    builder.top_agree_post = null;
                    list.set(i, builder.build(true));
                    avs();
                    a(false, true, false, this.evb.build(true));
                    return;
                }
            }
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            if (this.dYB != null) {
                this.dYB.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.dYB);
            }
            if (this.evq != null) {
                this.evq.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.evq);
            }
            this.mAttentionListener.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.mAttentionListener);
            this.evr.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.evr);
            this.eaC.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.eaC);
            this.eaD.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.eaD);
            this.eaE.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.eaE);
            if (this.dKi != null) {
                this.dKi.setUniqueId(bdUniqueId);
            }
            this.euZ.h(bdUniqueId);
            this.evw.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.evw);
        }
    }

    public void aLl() {
        this.dHZ = new com.baidu.tieba.tbadkCore.data.e("new_index", null);
        this.dHZ.bCT();
    }

    public void a(int i, List<h> list, int i2) {
        int i3;
        int i4;
        if (this.dHZ != null) {
            if (i == 0) {
                this.dHZ.bCT();
            }
            if (list != null && !list.isEmpty()) {
                int[] iArr = com.baidu.tieba.tbadkCore.data.e.hkN;
                int i5 = 0;
                int i6 = 0;
                int i7 = 0;
                while (i7 < list.size() && i6 < iArr.length && (i3 = iArr[i6]) >= 0) {
                    if (list.get(i7) instanceof com.baidu.tieba.card.data.c) {
                        i4 = i5 + 1;
                        if (i4 == i3 - 1) {
                            if (i2 < i7 + 1) {
                                this.dHZ.bQ(i3, i7 + 1);
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

    public void oF(int i) {
        if ((this.dHZ != null ? this.dHZ.vs(i) : -1) >= 0 && this.dMj != null && this.dMj.getData() != null && this.dMj.getData().size() > i) {
            this.dHZ.vt(i);
        }
    }

    public m aBx() {
        return this.dKi;
    }

    public void hS(boolean z) {
        this.evi = z;
    }

    public void oG(final int i) {
        x.a(new w<Object>() { // from class: com.baidu.tieba.homepage.personalize.e.5
            @Override // com.baidu.tbadk.util.w
            public Object doInBackground() {
                com.baidu.adp.lib.cache.l<String> an = com.baidu.tbadk.core.c.a.BB().an(e.this.evs, TbadkCoreApplication.getCurrentAccount());
                if (an != null) {
                    an.a(e.this.evs, Integer.toString(i), 43200000L);
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
            /* renamed from: aLo */
            public String doInBackground() {
                com.baidu.adp.lib.cache.l<String> an = com.baidu.tbadk.core.c.a.BB().an(e.this.evs, TbadkCoreApplication.getCurrentAccount());
                if (an != null) {
                    return an.get(e.this.evs);
                }
                return null;
            }
        }, new com.baidu.tbadk.util.h<String>() { // from class: com.baidu.tieba.homepage.personalize.e.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.h
            /* renamed from: pn */
            public void onReturnDataInUI(String str) {
                if (dVar != null) {
                    dVar.ot(com.baidu.adp.lib.g.b.l(str, 0));
                }
            }
        });
    }

    public void aLc() {
        c.e(this.dMj);
    }

    public void aLm() {
        a(this.evv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(CustomResponsedMessage<?> customResponsedMessage) {
        int b;
        String str;
        int i = 0;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.evb != null && com.baidu.tbadk.core.util.v.H(this.evb.thread_list) != 0 && com.baidu.tbadk.core.util.v.H(this.mDataList) != 0) {
            JSONObject jSONObject = (JSONObject) customResponsedMessage.getData();
            String optString = jSONObject.optString("tid");
            if (StringUtils.isNull(optString)) {
                String optString2 = jSONObject.optString("liveid");
                if (this.dMj != null && !TextUtils.isEmpty(optString2)) {
                    int i2 = 0;
                    while (true) {
                        if (i2 >= this.dMj.getCount()) {
                            str = optString;
                            break;
                        }
                        h item = this.dMj.getItem(i2);
                        if (item instanceof com.baidu.tieba.card.data.j) {
                            com.baidu.tieba.card.data.j jVar = (com.baidu.tieba.card.data.j) item;
                            if (jVar.ZR() != null && jVar.ZR().Aa() != null && optString2.equals(String.valueOf(jVar.ZR().Aa().live_id))) {
                                str = jVar.ZR().getTid();
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
                    if (cVar.ZR() != null && cVar.ZR().getTid() != null && cVar.ZR().getTid().equals(optString)) {
                        it.remove();
                        com.baidu.tieba.homepage.personalize.model.b.cn(this.mDataList);
                        break;
                    }
                }
            }
            if (this.evb != null && this.evb.thread_list != null) {
                long d = com.baidu.adp.lib.g.b.d(optString, 0L);
                while (true) {
                    if (i < this.evb.thread_list.size()) {
                        ThreadInfo threadInfo = this.evb.thread_list.get(i);
                        if (threadInfo == null || threadInfo.tid == null || threadInfo.tid.longValue() != d) {
                            i++;
                        } else {
                            this.evb.thread_list.remove(i);
                            avs();
                            com.baidu.tieba.homepage.personalize.b.d.a(threadInfo.tid.longValue(), i, this.evb.thread_list, this.mDataList);
                            break;
                        }
                    } else {
                        break;
                    }
                }
                if (this.dMj != null && (b = b(optString, this.dMj)) != -1) {
                    this.dMj.removeItem(b);
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
                    if (cVar.ZR() != null && cVar.ZR().getTid().equals(str)) {
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
                    advertAppInfo = ((com.baidu.tieba.homepage.personalize.data.a) next).apV();
                } else {
                    if (next instanceof ab) {
                        ab abVar = (ab) next;
                        if (abVar.yy() instanceof AdvertAppInfo.ILegoAdvert) {
                            advertAppInfo = ((AdvertAppInfo.ILegoAdvert) abVar.yy()).getAdvertAppInfo();
                        }
                    }
                    advertAppInfo = advertAppInfo2;
                }
                if (advertAppInfo != null && str.equals(advertAppInfo.apq)) {
                    it.remove();
                    advertAppInfo = null;
                }
                advertAppInfo2 = advertAppInfo;
            }
        }
    }

    public FloatInfo aLn() {
        return this.evo;
    }
}
