package com.baidu.tieba.homepage.personalize;

import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.af;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tbadk.util.h;
import com.baidu.tbadk.util.r;
import com.baidu.tbadk.util.s;
import com.baidu.tieba.ala.LiveRoomClosedQueryMessage;
import com.baidu.tieba.card.u;
import com.baidu.tieba.d;
import com.baidu.tieba.e.a;
import com.baidu.tieba.frs.as;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import com.baidu.tieba.homepage.personalize.a.l;
import com.baidu.tieba.play.m;
import com.squareup.wire.Wire;
import com.xiaomi.mipush.sdk.Constants;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;
import tbclient.App;
import tbclient.BannerList;
import tbclient.GodInfo;
import tbclient.Personalized.DataRes;
import tbclient.ThreadInfo;
import tbclient.User;
import tbclient.Zan;
/* loaded from: classes.dex */
public class e {
    private r aMH;
    private View.OnTouchListener ayd;
    private com.baidu.tieba.e.a cRG;
    private com.baidu.tieba.tbadkCore.data.e cxQ;
    private m czG;
    private boolean dcw;
    private final l dgV;
    private Runnable dhF;
    private final long dhk;
    private final b dhl;
    private DataRes.Builder dhn;
    private as dhr;
    private final com.baidu.tieba.homepage.personalize.model.a dhs;
    private ScrollFragmentTabHost dhu;
    private int dhx;
    private int dhz;
    private final BdTypeListView mListView;
    private final com.baidu.adp.base.e<?> mPageContext;
    private a dhm = null;
    private final List<com.baidu.adp.widget.ListView.f> mDataList = new LinkedList();
    private int mPn = 1;
    private boolean mIsLoading = false;
    private boolean dei = false;
    private long dho = 0;
    private int dhp = 1;
    private int dhq = 0;
    private TextView acd = null;
    private int cBo = 2000;
    private com.baidu.tbadk.l.f dht = null;
    private boolean czz = false;
    private int czb = 0;
    private int bfu = 0;
    private boolean mIsBackground = false;
    private boolean dhv = true;
    private boolean dhw = false;
    private boolean dhy = false;
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.e.12
        private int den = -1;
        private int deo = 0;
        private boolean dep = false;

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (e.this.dht == null) {
                e.this.dht = new com.baidu.tbadk.l.f();
                e.this.dht.fs(1005);
                e.this.dht.pageType = 1;
            }
            if (e.this.aMH != null && !e.this.mIsBackground) {
                e.this.aMH.onScrollStateChanged(absListView, i);
            }
            e.this.dht.Ga();
            if (i == 0) {
                u.aaj().cw(true);
                if (this.dep) {
                    e.this.asn();
                }
                this.dep = false;
                if (e.this.czG != null && e.this.dhv) {
                    e.this.czG.a(e.this.czb, e.this.bfu, e.this.czz, 1);
                }
            } else if (i == 1 && e.this.dhr != null) {
                e.this.dhr.hideTip();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (this.deo > i) {
                this.dep = true;
            }
            if (e.this.aMH != null && !e.this.mIsBackground) {
                e.this.aMH.a(absListView, this.deo, i, i2, i3);
            }
            this.deo = i;
            int i4 = (i + i2) - 1;
            if (!this.dep && this.den != i4) {
                this.den = i4;
                e.this.lv(this.den);
            }
            if (this.dep && this.den != i) {
                this.den = i;
                e.this.lv(this.den);
            }
            e.this.dhE = i;
            e.this.czb = i;
            e.this.bfu = (i + i2) - 1;
        }
    };
    private View.OnTouchListener aMI = new View.OnTouchListener() { // from class: com.baidu.tieba.homepage.personalize.e.16
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (e.this.ayd != null) {
                e.this.ayd.onTouch(view, motionEvent);
            }
            if (e.this.cRG != null) {
                e.this.cRG.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private a.InterfaceC0081a bzM = new a.InterfaceC0081a() { // from class: com.baidu.tieba.homepage.personalize.e.17
        @Override // com.baidu.tieba.e.a.InterfaceC0081a
        public void ag(int i, int i2) {
            e.this.czz = true;
        }

        @Override // com.baidu.tieba.e.a.InterfaceC0081a
        public void ah(int i, int i2) {
            e.this.czz = false;
        }

        @Override // com.baidu.tieba.e.a.InterfaceC0081a
        public void ai(int i, int i2) {
        }
    };
    private View.OnClickListener dhA = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.e.18
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (e.this.dhr != null) {
                e.this.dhr.hideTip();
            }
            if (e.this.dhp == 1 && e.this.mListView != null) {
                e.this.mListView.setSelection(0);
                e.this.mListView.startPullRefresh();
            }
        }
    };
    private final CustomMessageListener dhB = new CustomMessageListener(CmdConfigCustom.CMD_RELOAD_HP_PERSONALIZED) { // from class: com.baidu.tieba.homepage.personalize.e.19
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (e.this.mListView != null) {
                e.this.czG.atL();
                e.this.dhv = false;
                e.this.mListView.completePullRefreshPostDelayed(2000L);
                e.this.mListView.startPullRefresh();
            }
        }
    };
    private CustomMessageListener anH = new CustomMessageListener(CmdConfigCustom.PB_ACTION_PRAISE) { // from class: com.baidu.tieba.homepage.personalize.e.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            bh bhVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bh) && e.this.dhn != null && v.u(e.this.dhn.thread_list) != 0 && (bhVar = (bh) customResponsedMessage.getData()) != null && bhVar.ri() != null && bhVar.getId() != null && v.u(e.this.dhn.thread_list) != 0) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < e.this.dhn.thread_list.size()) {
                        ThreadInfo threadInfo = e.this.dhn.thread_list.get(i2);
                        if (threadInfo == null || threadInfo.id.longValue() != com.baidu.adp.lib.g.b.c(bhVar.getId(), -1L)) {
                            i = i2 + 1;
                        } else {
                            ThreadInfo.Builder builder = new ThreadInfo.Builder(threadInfo);
                            Zan.Builder builder2 = new Zan.Builder(builder.zan);
                            builder2.num = Integer.valueOf((int) bhVar.ri().getNum());
                            builder.zan = builder2.build(true);
                            e.this.dhn.thread_list.set(i2, builder.build(true));
                            return;
                        }
                    } else {
                        return;
                    }
                }
            }
        }
    };
    private CustomMessageListener dhC = new CustomMessageListener(CmdConfigCustom.CMD_LIVE_VIDEO_CLOSED_QUERY_RESPONSED) { // from class: com.baidu.tieba.homepage.personalize.e.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            bh bhVar;
            if (customResponsedMessage.getOrginalMessage() instanceof LiveRoomClosedQueryMessage) {
                List<Long> ids = ((LiveRoomClosedQueryMessage) customResponsedMessage.getOrginalMessage()).getIds();
                List<Object> originData = ((LiveRoomClosedQueryMessage) customResponsedMessage.getOrginalMessage()).getOriginData();
                if (!v.v(e.this.mDataList) && !v.v(ids) && !v.v(originData)) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= originData.size()) {
                            break;
                        }
                        if ((originData.get(i2) instanceof bh) && (bhVar = (bh) originData.get(i2)) != null && bhVar.rM() != null && ids.contains(Long.valueOf(bhVar.rM().live_id))) {
                            e.this.mDataList.remove(bhVar);
                        }
                        i = i2 + 1;
                    }
                    if (e.this.dgV != null) {
                        e.this.dgV.br(new ArrayList(e.this.mDataList));
                    }
                }
            }
        }
    };
    private CustomMessageListener mAttentionListener = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.homepage.personalize.e.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int intValue;
            if ((customResponsedMessage instanceof UpdateAttentionMessage) && e.this.dhn != null && !v.v(e.this.dhn.thread_list)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid)) {
                    for (int i = 0; i < e.this.dhn.thread_list.size(); i++) {
                        ThreadInfo threadInfo = e.this.dhn.thread_list.get(i);
                        if (threadInfo != null && threadInfo.author != null && threadInfo.author.id.longValue() == com.baidu.adp.lib.g.b.c(updateAttentionMessage.getData().toUid, -1L)) {
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
                            e.this.dhn.thread_list.set(i, builder.build(true));
                            return;
                        }
                    }
                }
            }
        }
    };
    private String dhD = "lastReadReadPositionKey";
    private int dhE = 0;
    private d dhG = new d() { // from class: com.baidu.tieba.homepage.personalize.e.7
        @Override // com.baidu.tieba.homepage.personalize.d
        public void lj(final int i) {
            if (e.this.dhF == null) {
                e.this.dhF = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.e.7.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (e.this.mListView.getHandler() != null) {
                            e.this.mListView.requestFocusFromTouch();
                            if (i <= e.this.mListView.getCount() - 1) {
                                e.this.mListView.setSelection(i);
                            }
                        }
                    }
                };
            }
            e.this.mListView.removeCallbacks(e.this.dhF);
            e.this.mListView.post(e.this.dhF);
        }
    };
    private CustomMessageListener cOP = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.homepage.personalize.e.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.d(customResponsedMessage);
        }
    };
    private CustomMessageListener cOQ = new CustomMessageListener(CmdConfigCustom.CMD_THREAD_NOT_EXIST_WHEN_ENTER_PB) { // from class: com.baidu.tieba.homepage.personalize.e.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.d(customResponsedMessage);
        }
    };
    private CustomMessageListener cOR = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.homepage.personalize.e.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && e.this.dhn != null && v.u(e.this.dhn.thread_list) != 0) {
                String str = (String) customResponsedMessage.getData();
                e.this.g(str, e.this.mDataList);
                e.this.lQ(str);
                if (e.this.dgV != null) {
                    e.this.dgV.br(new ArrayList(e.this.mDataList));
                }
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void D(int i, int i2, int i3);

        void aP(int i, int i2);

        void onError(int i, String str);

        void onSuccess();
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.dhu = scrollFragmentTabHost;
        if (this.dhu != null) {
            this.dhu.setOnTabSelectedListener(new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.personalize.e.1
                @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
                public void lu(int i) {
                    if (e.this.dhu.lt(i) != 1 && e.this.dhr != null) {
                        e.this.dhr.hideTip();
                    }
                }
            });
        }
    }

    public void setTabInForeBackgroundState(boolean z) {
        this.mIsBackground = z;
    }

    public void eF(boolean z) {
        this.mIsBackground = z;
        if (this.czG != null) {
            this.czG.hu(!z);
            if (z) {
                this.czG.atL();
            } else if (this.dhv) {
                this.czG.a(this.czb, this.bfu, this.czz, true);
            }
        }
    }

    public e(com.baidu.adp.base.e<?> eVar, BdTypeListView bdTypeListView, l lVar) {
        this.mPageContext = eVar;
        this.mListView = bdTypeListView;
        this.mListView.setOnTouchListener(this.aMI);
        this.cRG = new com.baidu.tieba.e.a();
        this.cRG.a(this.bzM);
        this.dgV = lVar;
        this.dhs = new com.baidu.tieba.homepage.personalize.model.a();
        this.dhk = com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("recommend_frs_cache_time", 43200L) * 1000;
        bdTypeListView.setOnScrollListener(this.mOnScrollListener);
        this.dhr = new as();
        aso();
        this.czG = new m(this.mPageContext, this.mListView);
        this.dhl = new b(this.mDataList, this.dgV);
    }

    private boolean asg() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean(asi(), true);
    }

    private void ash() {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean(asi(), false);
    }

    private String asi() {
        return "key_rec_pfirst_load_" + TbadkCoreApplication.getCurrentAccount() + "_" + TbConfig.getVersion();
    }

    public void setHeaderViewHeight(int i) {
        this.dhz = i;
    }

    public void setRecommendFrsNavigationAnimDispatcher(s sVar) {
        if (sVar != null) {
            this.aMH = sVar.Hj();
            this.ayd = sVar.Hk();
        }
    }

    public void showFloatingView() {
        if (this.aMH != null) {
            this.aMH.ca(true);
        }
    }

    public void update() {
        if (com.baidu.tieba.homepage.framework.a.arN().li(1) == -1) {
            com.baidu.tieba.homepage.framework.a.arN().h(System.currentTimeMillis(), 1);
        }
        this.mPn = 1;
        this.dhy = true;
        if (this.mDataList.size() == 0 && !this.dei && !asg()) {
            arG();
        } else {
            arD();
        }
    }

    public void aQ(int i, int i2) {
        bh bhVar;
        if (!v.v(this.mDataList) && this.mDataList.size() > i) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            while (i < this.mDataList.size() && i <= i2) {
                if (this.mDataList.get(i).getType().getId() == bh.Ys.getId() && (bhVar = (bh) this.mDataList.get(i)) != null && bhVar.rM() != null) {
                    arrayList.add(Long.valueOf(bhVar.rM().live_id));
                    arrayList2.add(bhVar);
                }
                i++;
            }
            if (!v.v(arrayList)) {
                MessageManager.getInstance().sendMessage(new LiveRoomClosedQueryMessage(arrayList, arrayList2));
            }
        }
    }

    public void asj() {
        if (this.czG != null && !this.mIsBackground && this.dhv) {
            this.czG.a(this.czb, this.bfu, this.czz, true);
        }
        if (this.dhw) {
            if (this.dcw) {
                if (fF(false)) {
                    aR(3, this.dhq);
                } else if (this.dhx > 0) {
                    aR(2, this.dhq);
                }
            } else if (!this.dcw && this.dhq == 0) {
                aR(2, 0);
            }
            com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("recommend_frs_refresh_time", System.currentTimeMillis());
            this.dhw = false;
            this.dcw = false;
            this.dhx = 0;
            if (this.dhy) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
            }
            this.dhy = false;
        }
    }

    public void NQ() {
        if (!wz() && this.dhm != null) {
            asl();
            this.mPn++;
            setIsLoading(true);
            this.dhm.D(this.mPn, (this.dhn == null || this.dhn.thread_list == null) ? 0 : this.dhn.thread_list.size(), 0);
        }
    }

    public void a(boolean z, boolean z2, DataRes dataRes, int i, String str) {
        setIsLoading(false);
        this.mListView.completePullRefreshPostDelayed(2000L);
        if (z) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("recommend_frs_guide_time", System.currentTimeMillis());
        }
        int size = (this.dhn == null || this.dhn.thread_list == null) ? 0 : this.dhn.thread_list.size();
        if (i != 0 || dataRes == null || !a(true, z, z2, dataRes)) {
            this.dhw = false;
            if (this.mDataList.size() > 0) {
                if (this.dhm != null) {
                    this.dhm.onError(1, str);
                    return;
                }
                return;
            } else if (this.dhm != null) {
                this.dhm.onError(2, str);
                return;
            } else {
                return;
            }
        }
        ash();
        if (this.dhm != null) {
            this.dhm.onSuccess();
        }
        this.dhw = true;
        this.dcw = z;
        this.dhx = size;
        arH();
    }

    public void fC(boolean z) {
        if (z) {
            this.dgV.notifyDataSetChanged();
        }
        if (!ask()) {
            asn();
        }
    }

    public void onDestroy() {
        if (this.czG != null) {
            this.czG.destroy();
        }
        if (this.dht != null) {
            this.dht.onDestroy();
        }
        if (this.dhr != null) {
            this.dhr.onDestroy();
        }
        if (this.dhl != null) {
            this.dhl.onDestroy();
        }
        if (this.mListView != null) {
            this.mListView.removeCallbacks(this.dhF);
        }
    }

    public void onPause() {
        lw(this.dhE);
        gy(CmdConfigCustom.CMD_VIEW_PAGER_END_AUTO_SCROLL);
    }

    public void onResume() {
        gy(CmdConfigCustom.CMD_VIEW_PAGER_START_AUTO_SCROLL);
    }

    private void gy(final int i) {
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(i);
        final BdUniqueId uniqueId = this.mPageContext.getUniqueId();
        customResponsedMessage.setOrginalMessage(new CustomMessage<Object>(i, uniqueId) { // from class: com.baidu.tieba.homepage.personalize.PersonalizedUpdateController$7
        });
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
    }

    public boolean ask() {
        if (fF(false)) {
            if (this.mListView != null) {
                this.mListView.setSelection(0);
                this.mListView.startPullRefresh();
            }
            return true;
        }
        return false;
    }

    private void arD() {
        if (this.dhm != null) {
            this.dhm.aP((this.dhn == null || this.dhn.thread_list == null || asm()) ? 0 : this.dhn.thread_list.size(), 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(DataRes dataRes) {
        this.dei = true;
        if (dataRes != null) {
            if (a(false, true, true, dataRes) && !asm()) {
                if (this.dhm != null) {
                    this.dhm.onSuccess();
                }
                asn();
                return;
            }
            arD();
            return;
        }
        arD();
    }

    private void bu(List<com.baidu.adp.widget.ListView.f> list) {
        if (!v.v(list)) {
            for (com.baidu.adp.widget.ListView.f fVar : list) {
                if (fVar instanceof com.baidu.tieba.card.data.d) {
                    com.baidu.tieba.card.data.d dVar = (com.baidu.tieba.card.data.d) fVar;
                    if (dVar.aas() != null) {
                        dVar.aas().advertAppContext = new com.baidu.tbadk.core.data.b();
                        dVar.aas().advertAppContext.TL = "NEWINDEX";
                        dVar.aas().advertAppContext.pn = 1;
                        dVar.aas().advertAppContext.extensionInfo = dVar.aas().extensionInfo;
                        dVar.aas().advertAppContext.TR = false;
                    }
                }
            }
        }
    }

    private boolean a(boolean z, boolean z2, boolean z3, DataRes dataRes) {
        List<com.baidu.adp.widget.ListView.f> list;
        boolean z4;
        if (dataRes == null) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        this.dho = dataRes.sug_seconds.intValue() * 1000;
        if (z2 && asm()) {
            this.dhn = null;
        }
        int size = z2 ? 0 : this.mDataList.size();
        DataRes.Builder builder = new DataRes.Builder(dataRes);
        this.mDataList.clear();
        com.baidu.tieba.homepage.personalize.model.c a2 = this.dhs.a(z, this.dhn, builder, z2 ? 0 : 1);
        if (a2 == null) {
            list = null;
        } else {
            List<com.baidu.adp.widget.ListView.f> list2 = a2.aUB;
            this.dhq = a2.diA;
            list = list2;
        }
        if (list != null) {
            this.mDataList.addAll(list);
            bu(list);
            a(z2 ? 0 : 1, list, size);
            if (this.dhy) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
            }
        }
        if (this.dhn == null) {
            this.dhn = builder;
            this.dhl.bs(this.dhn.thread_list);
        }
        if (this.mDataList.size() == 0) {
            z4 = false;
        } else {
            LinkedList linkedList = new LinkedList(this.mDataList);
            this.dgV.setFromCDN(dataRes.is_new_url.intValue() == 1);
            this.dgV.br(linkedList);
            z4 = true;
            if (this.czG != null && this.dhv) {
                this.czG.a(this.czb, this.bfu, this.czz, true);
            }
        }
        com.baidu.tieba.homepage.framework.a.arN().f(System.currentTimeMillis() - currentTimeMillis, 1);
        long li = com.baidu.tieba.homepage.framework.a.arN().li(1);
        if (li > 0) {
            com.baidu.tieba.homepage.framework.a.arN().g(System.currentTimeMillis() - li, 1);
            com.baidu.tieba.homepage.framework.a.arN().h(0L, 1);
            return z4;
        }
        return z4;
    }

    private void asl() {
        if (v.u(this.mDataList) >= this.dhs.asu() - 40) {
            com.baidu.tieba.homepage.personalize.model.c a2 = this.dhs.a(true, this.dhn, (DataRes.Builder) null, 1);
            List<com.baidu.adp.widget.ListView.f> list = a2 != null ? a2.aUB : null;
            if (list != null) {
                this.mDataList.clear();
                this.mDataList.addAll(list);
                this.dgV.br(new LinkedList(this.mDataList));
            }
        }
    }

    private void arG() {
        com.baidu.tbadk.util.v.a(new com.baidu.tbadk.util.u<DataRes>() { // from class: com.baidu.tieba.homepage.personalize.e.20
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.u
            /* renamed from: asr */
            public DataRes doInBackground() {
                com.baidu.adp.lib.cache.l<byte[]> M = com.baidu.tbadk.core.c.a.td().M("tb.rec_frs_update", TbadkCoreApplication.getCurrentAccount());
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
        }, new h<DataRes>() { // from class: com.baidu.tieba.homepage.personalize.e.21
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.h
            /* renamed from: b */
            public void onReturnDataInUI(DataRes dataRes) {
                e.this.a(dataRes);
            }
        });
    }

    private void arH() {
        if (this.dhn != null) {
            DataRes.Builder builder = new DataRes.Builder(this.dhn.build(true));
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
                        int g = com.baidu.adp.lib.g.b.g(next.pos_name, -1);
                        if (g < 0) {
                            it.remove();
                        } else if (g < i + i2 + 1) {
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
    public void lQ(String str) {
        if (!TextUtils.isEmpty(str) && this.dhn != null && this.dhn.banner_list != null && this.dhn.banner_list.app != null && this.dhn.banner_list.app.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (App app : this.dhn.banner_list.app) {
                if (app != null && str.equals(app.id)) {
                    arrayList.add(app);
                }
            }
            BannerList.Builder builder = new BannerList.Builder(this.dhn.banner_list);
            if (builder.app != null) {
                builder.app.removeAll(arrayList);
            }
            this.dhn.banner_list = builder.build(false);
            DataRes.Builder builder2 = new DataRes.Builder(this.dhn.build(true));
            builder2.banner_list = builder.build(true);
            a(builder2);
        }
    }

    private void a(final DataRes.Builder builder) {
        com.baidu.tbadk.util.v.a(new com.baidu.tbadk.util.u<Object>() { // from class: com.baidu.tieba.homepage.personalize.e.2
            @Override // com.baidu.tbadk.util.u
            public Object doInBackground() {
                DataRes.Builder builder2 = new DataRes.Builder(builder.build(true));
                e.this.dhl.bt(builder2.thread_list);
                try {
                    com.baidu.tbadk.core.c.a.td().M("tb.rec_frs_update", TbadkCoreApplication.getCurrentAccount()).e("0", builder2.build(true).toByteArray());
                    return null;
                } catch (Exception e) {
                    BdLog.e(e);
                    return null;
                }
            }
        }, null);
    }

    private boolean asm() {
        return fF(true);
    }

    private boolean fF(boolean z) {
        long j = com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("recommend_frs_refresh_time", 0L);
        return j == 0 ? z : Math.abs(System.currentTimeMillis() - j) > this.dhk;
    }

    public void a(a aVar) {
        this.dhm = aVar;
    }

    private boolean wz() {
        return this.mIsLoading;
    }

    private void setIsLoading(boolean z) {
        this.mIsLoading = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void asn() {
        long j = com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("recommend_frs_guide_time", 0L);
        if (this.dho != 0) {
            if (j == 0 || Math.abs(System.currentTimeMillis() - j) > this.dho) {
                aR(1, 0);
            }
        }
    }

    public void ase() {
        boolean z = true;
        com.baidu.tbadk.coreExtra.data.a activityPrizeData = TbadkCoreApplication.getInst().getActivityPrizeData();
        if (activityPrizeData.xv() && !StringUtils.isNull(activityPrizeData.xC())) {
            String currentDay = UtilHelper.getCurrentDay();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            String str = "";
            if (!StringUtils.isNull(currentAccount)) {
                String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("activity_prize_feed_text_time", "");
                if (!StringUtils.isNull(string)) {
                    String[] split = string.split("@");
                    if (split != null && split.length == 2) {
                        String str2 = split[0];
                        String[] split2 = split[1].split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                        if (!StringUtils.isNull(str2) && split2.length != 0) {
                            if (str2.equals(currentDay)) {
                                List<String> asList = Arrays.asList(split2);
                                if (asList.contains(currentAccount)) {
                                    z = false;
                                } else {
                                    StringBuilder sb = new StringBuilder();
                                    sb.append(currentDay).append("@");
                                    for (String str3 : asList) {
                                        sb.append(str3).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
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
                    aR(4, 0);
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putString("activity_prize_feed_text_time", str);
                }
            }
        }
    }

    private void aR(int i, int i2) {
        FrameLayout.LayoutParams layoutParams;
        if (this.dhu != null) {
            this.dhr.akE();
        }
        if (this.dhu != null && this.dhu.getCurrentTabType() != 1) {
            this.dhr.hideTip();
            return;
        }
        this.dhp = i;
        String str = null;
        if (i == 1) {
            str = TbadkCoreApplication.getInst().getString(d.j.recommend_frs_refresh_guide);
        } else if (i == 2) {
            if (i2 > 0) {
                str = String.format(TbadkCoreApplication.getInst().getString(d.j.recommend_frs_refresh_return), Integer.valueOf(i2));
            } else {
                str = TbadkCoreApplication.getInst().getString(d.j.recommend_frs_refresh_nodata);
            }
        } else if (i == 3) {
            str = TbadkCoreApplication.getInst().getString(d.j.recommend_frs_refresh_cache_invalid);
        } else if (i == 4) {
            str = TbadkCoreApplication.getInst().getActivityPrizeData().xC();
        }
        if (!TextUtils.isEmpty(str)) {
            if (this.acd == null) {
                this.acd = new TextView(this.mPageContext.getPageActivity());
                this.acd.setGravity(17);
                this.acd.setOnClickListener(this.dhA);
            }
            this.dhr.akE();
            FrameLayout frameLayout = this.dhu.getFrameLayout();
            if (frameLayout != null && this.acd.getParent() == null) {
                if (i == 1) {
                    if (j.hh()) {
                        int dimensionPixelSize = this.mPageContext.getResources().getDimensionPixelSize(d.e.ds20);
                        int dimensionPixelSize2 = this.mPageContext.getResources().getDimensionPixelSize(d.e.ds40);
                        this.acd.setPadding(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
                        this.acd.setTextSize(0, this.mPageContext.getResources().getDimensionPixelSize(d.e.fontsize28));
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("recommend_frs_guide_time", System.currentTimeMillis());
                        aj.j(this.acd, d.f.bg_home_float);
                        aj.i(this.acd, d.C0080d.cp_link_tip_a);
                        layoutParams = new FrameLayout.LayoutParams(-2, -2);
                        layoutParams.gravity = 49;
                        layoutParams.topMargin = this.dhz;
                    } else {
                        return;
                    }
                } else {
                    this.acd.setPadding(0, 0, 0, 0);
                    this.acd.setTextSize(0, this.mPageContext.getResources().getDimensionPixelSize(d.e.fontsize24));
                    aj.j(this.acd, d.C0080d.common_color_10260);
                    aj.i(this.acd, d.C0080d.cp_cont_g);
                    layoutParams = new FrameLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.f(TbadkCoreApplication.getInst(), d.e.ds56));
                    layoutParams.gravity = 49;
                    layoutParams.topMargin = this.dhz;
                }
                this.acd.setText(str);
                if (i == 1) {
                    this.cBo = 4000;
                } else if (i == 4) {
                    this.cBo = 3000;
                } else {
                    this.cBo = 2000;
                }
                this.dhr.a(this.acd, frameLayout, layoutParams, this.cBo);
            }
        }
    }

    public void k(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            if (this.anH != null) {
                this.anH.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.anH);
            }
            if (this.dhB != null) {
                this.dhB.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.dhB);
            }
            this.mAttentionListener.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.mAttentionListener);
            this.dhC.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.dhC);
            this.cOP.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.cOP);
            this.cOQ.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.cOQ);
            this.cOR.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.cOR);
            if (this.czG != null) {
                this.czG.setUniqueId(bdUniqueId);
            }
            this.dhl.h(bdUniqueId);
        }
    }

    public void aso() {
        this.cxQ = new com.baidu.tieba.tbadkCore.data.e("new_index", null);
        this.cxQ.bui();
    }

    public void a(int i, List<com.baidu.adp.widget.ListView.f> list, int i2) {
        int i3;
        int i4;
        if (this.cxQ != null) {
            if (i == 0) {
                this.cxQ.bui();
            }
            if (list != null && !list.isEmpty()) {
                int[] iArr = com.baidu.tieba.tbadkCore.data.e.gpO;
                int i5 = 0;
                int i6 = 0;
                int i7 = 0;
                while (i7 < list.size() && i6 < iArr.length && (i3 = iArr[i6]) >= 0) {
                    if (list.get(i7) instanceof com.baidu.tieba.card.data.c) {
                        i4 = i5 + 1;
                        if (i4 == i3 - 1) {
                            if (i2 < i7 + 1) {
                                this.cxQ.bT(i3, i7 + 1);
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

    public void lv(int i) {
        if ((this.cxQ != null ? this.cxQ.tS(i) : -1) >= 0 && this.mListView != null && this.mListView.getData() != null && this.mListView.getData().size() > i) {
            this.cxQ.tT(i);
        }
    }

    public m ajJ() {
        return this.czG;
    }

    public void fG(boolean z) {
        this.dhv = z;
    }

    public void lw(final int i) {
        com.baidu.tbadk.util.v.a(new com.baidu.tbadk.util.u<Object>() { // from class: com.baidu.tieba.homepage.personalize.e.6
            @Override // com.baidu.tbadk.util.u
            public Object doInBackground() {
                com.baidu.adp.lib.cache.l<String> N = com.baidu.tbadk.core.c.a.td().N(e.this.dhD, TbadkCoreApplication.getCurrentAccount());
                if (N != null) {
                    N.a(e.this.dhD, Integer.toString(i), 43200000L);
                    return null;
                }
                return null;
            }
        }, null);
    }

    public void a(final d dVar) {
        com.baidu.tbadk.util.v.a(new com.baidu.tbadk.util.u<String>() { // from class: com.baidu.tieba.homepage.personalize.e.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.u
            /* renamed from: asq */
            public String doInBackground() {
                com.baidu.adp.lib.cache.l<String> N = com.baidu.tbadk.core.c.a.td().N(e.this.dhD, TbadkCoreApplication.getCurrentAccount());
                if (N != null) {
                    return N.get(e.this.dhD);
                }
                return null;
            }
        }, new h<String>() { // from class: com.baidu.tieba.homepage.personalize.e.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.h
            /* renamed from: lR */
            public void onReturnDataInUI(String str) {
                if (dVar != null) {
                    dVar.lj(com.baidu.adp.lib.g.b.g(str, 0));
                }
            }
        });
    }

    public void asp() {
        a(this.dhG);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.dhn != null && v.u(this.dhn.thread_list) != 0 && v.u(this.mDataList) != 0) {
            String optString = ((JSONObject) customResponsedMessage.getData()).optString("tid");
            if (!StringUtils.isNull(optString)) {
                if (this.mListView != null && this.mListView.getAdapter() != null) {
                    View childAt = this.mListView.getChildAt(a(optString, this.mListView));
                    if (childAt != null) {
                        aD(childAt);
                    } else if (this.dgV != null) {
                        this.dgV.br(new ArrayList(this.mDataList));
                    }
                }
                Iterator<com.baidu.adp.widget.ListView.f> it = this.mDataList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    com.baidu.adp.widget.ListView.f next = it.next();
                    if (next instanceof com.baidu.tieba.card.data.c) {
                        com.baidu.tieba.card.data.c cVar = (com.baidu.tieba.card.data.c) next;
                        if (cVar.NA() != null && cVar.NA().getTid() != null && cVar.NA().getTid().equals(optString)) {
                            it.remove();
                            com.baidu.tieba.homepage.personalize.model.b.bw(this.mDataList);
                            break;
                        }
                    }
                }
                if (this.dhn != null && this.dhn.thread_list != null) {
                    long c = com.baidu.adp.lib.g.b.c(optString, 0L);
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < this.dhn.thread_list.size()) {
                            ThreadInfo threadInfo = this.dhn.thread_list.get(i2);
                            if (threadInfo == null || threadInfo.tid == null || threadInfo.tid.longValue() != c) {
                                i = i2 + 1;
                            } else {
                                this.dhn.thread_list.remove(i2);
                                arH();
                                com.baidu.tieba.homepage.personalize.b.d.a(threadInfo.tid.longValue(), i2, this.dhn.thread_list, this.mDataList);
                                return;
                            }
                        } else {
                            return;
                        }
                    }
                }
            }
        }
    }

    private int a(String str, BdTypeListView bdTypeListView) {
        int headerViewsCount = bdTypeListView.getHeaderViewsCount();
        int firstVisiblePosition = bdTypeListView.getFirstVisiblePosition();
        int i = 0;
        for (int i2 = 0; i2 < bdTypeListView.getAdapter().getCount(); i2++) {
            com.baidu.adp.widget.ListView.f item = bdTypeListView.getItem(i2);
            if (item instanceof com.baidu.tieba.card.data.c) {
                com.baidu.tieba.card.data.c cVar = (com.baidu.tieba.card.data.c) item;
                if (cVar.NA() != null && cVar.NA().getTid().equals(str)) {
                    i = i2;
                }
            }
        }
        return (i + headerViewsCount) - firstVisiblePosition;
    }

    private void aD(final View view) {
        final int measuredHeight = view.getMeasuredHeight();
        Animation animation = new Animation() { // from class: com.baidu.tieba.homepage.personalize.e.13
            @Override // android.view.animation.Animation
            protected void applyTransformation(float f, Transformation transformation) {
                view.getLayoutParams().height = measuredHeight - ((int) (measuredHeight * f));
                view.requestLayout();
            }

            @Override // android.view.animation.Animation
            public boolean willChangeBounds() {
                return true;
            }
        };
        animation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.homepage.personalize.e.14
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation2) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation2) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation2) {
                view.setVisibility(8);
                if (e.this.dgV != null) {
                    e.this.dgV.br(new ArrayList(e.this.mDataList));
                }
            }
        });
        animation.setDuration(300L);
        view.startAnimation(animation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(String str, List<com.baidu.adp.widget.ListView.f> list) {
        AdvertAppInfo advertAppInfo;
        if (list != null && list.size() > 0 && !TextUtils.isEmpty(str)) {
            Iterator<com.baidu.adp.widget.ListView.f> it = list.iterator();
            AdvertAppInfo advertAppInfo2 = null;
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.f next = it.next();
                if (next instanceof com.baidu.tieba.homepage.personalize.data.a) {
                    advertAppInfo = ((com.baidu.tieba.homepage.personalize.data.a) next).aas();
                } else {
                    if (next instanceof af) {
                        af afVar = (af) next;
                        if (afVar.pZ() instanceof AdvertAppInfo.ILegoAdvert) {
                            advertAppInfo = ((AdvertAppInfo.ILegoAdvert) afVar.pZ()).getAdvertAppInfo();
                        }
                    }
                    advertAppInfo = advertAppInfo2;
                }
                if (advertAppInfo != null && str.equals(advertAppInfo.Ug)) {
                    it.remove();
                    advertAppInfo = null;
                }
                advertAppInfo2 = advertAppInfo;
            }
        }
    }
}
