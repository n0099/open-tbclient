package com.baidu.tieba.homepage.personalize;

import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.card.a.a;
import com.baidu.card.af;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.ae;
import com.baidu.tbadk.core.data.ay;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tbadk.util.ac;
import com.baidu.tbadk.util.y;
import com.baidu.tbadk.util.z;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.LiveRoomClosedQueryMessage;
import com.baidu.tieba.card.data.k;
import com.baidu.tieba.card.r;
import com.baidu.tieba.f.a;
import com.baidu.tieba.frs.SmartBubbleAnimatedView;
import com.baidu.tieba.frs.ar;
import com.baidu.tieba.homepage.BlessHttpResponseMessage;
import com.baidu.tieba.homepage.BlessSocketResponseMessage;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import com.baidu.tieba.homepage.personalize.a.ab;
import com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout;
import com.baidu.tieba.message.RequestBlessMessage;
import com.baidu.tieba.play.m;
import com.squareup.wire.Wire;
import com.xiaomi.mipush.sdk.Constants;
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
    private y dCz;
    private View.OnTouchListener dpy;
    private com.baidu.tieba.f.a gHa;
    private boolean gPH;
    private final BigdaySwipeRefreshLayout gRz;
    private final long gWW;
    private final b gWX;
    private DataRes.Builder gWZ;
    private ScrollFragmentTabHost gWf;
    private final ab gWs;
    private ar gXc;
    private final com.baidu.tieba.homepage.personalize.model.a gXd;
    private int gXg;
    private com.baidu.tieba.homepage.personalize.data.f gXi;
    private BdUniqueId gXl;
    private SmartBubbleAnimatedView gXm;
    private int gXn;
    private Runnable gXt;
    private com.baidu.tieba.tbadkCore.data.f giW;
    private m glq;
    private final BdTypeRecyclerView gnE;
    private final TbPageContext<?> mPageContext;
    private a gWY = null;
    private final List<com.baidu.adp.widget.ListView.m> mDataList = new LinkedList();
    private int mPn = 1;
    private boolean mIsLoading = false;
    private boolean gRH = false;
    private int gXa = 2;
    private int gXb = 0;
    private TextView mTipView = null;
    private int gnp = 2000;
    private com.baidu.tbadk.n.c gXe = null;
    private boolean glj = false;
    private int gkE = 0;
    private int efC = 0;
    private boolean mIsBackground = false;
    private boolean gWa = true;
    private boolean gXf = false;
    private boolean gXh = false;
    private boolean gXj = true;
    private FloatInfo gXk = null;
    private a.C0050a gjn = new a.C0050a(2);
    private RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.e.12
        private int gXC = -1;
        private int gRP = 0;
        private boolean gXD = false;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (e.this.gXe == null) {
                e.this.gXe = new com.baidu.tbadk.n.c();
                e.this.gXe.setSubType(1005);
                e.this.gXe.pageType = 1;
            }
            if (e.this.dCz != null && !e.this.mIsBackground) {
                e.this.dCz.l(recyclerView, i);
            }
            if (i == 0) {
                c.d(e.this.gnE);
                e.this.gXe.aOr();
                r.bsy().hK(true);
                com.baidu.tieba.a.d.aUV().cm("page_recommend", "show_");
                com.baidu.tieba.r.c.cHo().b(e.this.gXl, false);
                this.gXD = false;
                if (e.this.glq != null && e.this.gWa && !e.this.mIsBackground) {
                    e.this.glq.a(e.this.gkE, e.this.efC, e.this.glj, 1);
                    return;
                }
                return;
            }
            e.this.gXe.aOq();
            if (i == 1) {
                if (e.this.gXc != null) {
                    e.this.gXc.hideTip();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921418));
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
            if (this.gRP > i) {
                this.gXD = true;
            }
            if (e.this.dCz != null && !e.this.mIsBackground) {
                e.this.dCz.onScroll(this.gRP, i);
            }
            this.gRP = i;
            int i3 = (i + i2) - 1;
            if (!this.gXD && this.gXC != i3) {
                this.gXC = i3;
                e.this.vg(this.gXC);
            }
            if (this.gXD && this.gXC != i) {
                this.gXC = i;
                e.this.vg(this.gXC);
            }
            e.this.gXs = i;
            e.this.gkE = i;
            e.this.efC = (i + i2) - 1;
            af bLE = e.this.bLE();
            if (bLE != null && bLE.mT() != null) {
                bLE.mT().b(e.this.gjn);
            }
        }
    };
    private View.OnTouchListener dne = new View.OnTouchListener() { // from class: com.baidu.tieba.homepage.personalize.e.21
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (e.this.dpy != null) {
                e.this.dpy.onTouch(view, motionEvent);
            }
            if (e.this.gHa != null) {
                e.this.gHa.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private a.InterfaceC0488a fLT = new a.InterfaceC0488a() { // from class: com.baidu.tieba.homepage.personalize.e.22
        @Override // com.baidu.tieba.f.a.InterfaceC0488a
        public void u(int i, int i2) {
            e.this.glj = false;
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0488a
        public void v(int i, int i2) {
            e.this.glj = true;
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0488a
        public void bA(int i, int i2) {
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0488a
        public void w(int i, int i2) {
        }
    };
    private View.OnClickListener gXo = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.e.23
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (e.this.gXc != null) {
                e.this.gXc.hideTip();
            }
        }
    };
    private final CustomMessageListener gXp = new CustomMessageListener(CmdConfigCustom.CMD_RELOAD_HP_PERSONALIZED) { // from class: com.baidu.tieba.homepage.personalize.e.24
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (e.this.gnE != null) {
                e.this.glq.bLD();
                e.this.gWa = false;
                e.this.gRz.setRefreshing(true);
            }
        }
    };
    private CustomMessageListener gAd = new CustomMessageListener(CmdConfigCustom.PB_ACTION_PRAISE) { // from class: com.baidu.tieba.homepage.personalize.e.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            bj bjVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bj) && e.this.gWZ != null && v.getCount(e.this.gWZ.thread_list) != 0 && (bjVar = (bj) customResponsedMessage.getData()) != null && bjVar.azp() != null && bjVar.getId() != null && v.getCount(e.this.gWZ.thread_list) != 0) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < e.this.gWZ.thread_list.size()) {
                        ThreadInfo threadInfo = e.this.gWZ.thread_list.get(i2);
                        if (threadInfo == null || threadInfo.id.longValue() != com.baidu.adp.lib.f.b.toLong(bjVar.getId(), -1L)) {
                            i = i2 + 1;
                        } else {
                            ThreadInfo.Builder builder = new ThreadInfo.Builder(threadInfo);
                            Zan.Builder builder2 = new Zan.Builder(builder.zan);
                            builder2.num = Integer.valueOf((int) bjVar.azp().getNum());
                            builder.zan = builder2.build(true);
                            e.this.gWZ.thread_list.set(i2, builder.build(true));
                            return;
                        }
                    } else {
                        return;
                    }
                }
            }
        }
    };
    private CustomMessageListener gXq = new CustomMessageListener(CmdConfigCustom.CMD_LIVE_VIDEO_CLOSED_QUERY_RESPONSED) { // from class: com.baidu.tieba.homepage.personalize.e.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            bj bjVar;
            if (customResponsedMessage.getOrginalMessage() instanceof LiveRoomClosedQueryMessage) {
                List<Long> ids = ((LiveRoomClosedQueryMessage) customResponsedMessage.getOrginalMessage()).getIds();
                List<Object> originData = ((LiveRoomClosedQueryMessage) customResponsedMessage.getOrginalMessage()).getOriginData();
                if (!v.isEmpty(e.this.mDataList) && !v.isEmpty(ids) && !v.isEmpty(originData)) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= originData.size()) {
                            break;
                        }
                        if ((originData.get(i2) instanceof bj) && (bjVar = (bj) originData.get(i2)) != null && bjVar.azX() != null && ids.contains(Long.valueOf(bjVar.azX().live_id))) {
                            e.this.mDataList.remove(bjVar);
                        }
                        i = i2 + 1;
                    }
                    if (e.this.gWs != null) {
                        e.this.gWs.ad(new ArrayList(e.this.mDataList));
                    }
                }
            }
        }
    };
    private CustomMessageListener cVS = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.homepage.personalize.e.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int intValue;
            if ((customResponsedMessage instanceof UpdateAttentionMessage) && e.this.gWZ != null && !v.isEmpty(e.this.gWZ.thread_list)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid)) {
                    int i = 0;
                    while (true) {
                        if (i >= e.this.gWZ.thread_list.size()) {
                            break;
                        }
                        ThreadInfo threadInfo = e.this.gWZ.thread_list.get(i);
                        if (threadInfo == null || threadInfo.author == null || threadInfo.author.id.longValue() != com.baidu.adp.lib.f.b.toLong(updateAttentionMessage.getData().toUid, -1L)) {
                            i++;
                        } else {
                            ThreadInfo.Builder builder = new ThreadInfo.Builder(threadInfo);
                            User.Builder builder2 = new User.Builder(builder.author);
                            builder2.is_like = Integer.valueOf(updateAttentionMessage.getData().isAttention ? 1 : 0);
                            builder2.has_concerned = Integer.valueOf(updateAttentionMessage.getData().isAttention ? 1 : 0);
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
                            e.this.gWZ.thread_list.set(i, builder.build(true));
                        }
                    }
                    e.this.a(updateAttentionMessage);
                }
            }
        }
    };
    private String gXr = "lastReadReadPositionKey";
    private int gXs = 0;
    private d gXu = new d() { // from class: com.baidu.tieba.homepage.personalize.e.10
        @Override // com.baidu.tieba.homepage.personalize.d
        public void uP(final int i) {
            if (e.this.gXt == null) {
                e.this.gXt = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.e.10.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (e.this.gnE.getHandler() != null) {
                            e.this.gnE.requestFocusFromTouch();
                            if (i <= e.this.gnE.getCount() - 1) {
                                e.this.gnE.setSelection(i);
                            }
                        }
                    }
                };
            }
            e.this.gnE.removeCallbacks(e.this.gXt);
            e.this.gnE.post(e.this.gXt);
        }
    };
    private CustomMessageListener gXv = new CustomMessageListener(2016569) { // from class: com.baidu.tieba.homepage.personalize.e.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && e.this.gXi != null) {
                e.this.mDataList.remove(e.this.gXi);
                e.this.gWs.ad(new ArrayList(e.this.mDataList));
                com.baidu.tbadk.core.sharedPref.b.aCY().putLong("key_maintab_banner_close_time", System.currentTimeMillis());
            }
        }
    };
    private CustomMessageListener gCj = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.homepage.personalize.e.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.h(customResponsedMessage);
            if (e.this.glq != null && e.this.gWa) {
                e.this.glq.a(e.this.gkE, e.this.efC, e.this.glj, true);
            }
        }
    };
    private CustomMessageListener gCk = new CustomMessageListener(CmdConfigCustom.CMD_THREAD_NOT_EXIST_WHEN_ENTER_PB) { // from class: com.baidu.tieba.homepage.personalize.e.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.h(customResponsedMessage);
        }
    };
    private CustomMessageListener gAq = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.homepage.personalize.e.17
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && e.this.gWZ != null && v.getCount(e.this.gWZ.thread_list) != 0) {
                String str = (String) customResponsedMessage.getData();
                e.this.g(str, e.this.mDataList);
                e.this.BJ(str);
                if (e.this.gWs != null) {
                    e.this.gWs.ad(new ArrayList(e.this.mDataList));
                }
                if (e.this.glq != null && e.this.gWa) {
                    e.this.glq.a(e.this.gkE, e.this.efC, e.this.glj, true);
                }
            }
        }
    };
    private CustomMessageListener gkw = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.homepage.personalize.e.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            af bLE;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent)) {
                KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24 && (bLE = e.this.bLE()) != null && bLE.mT() != null) {
                    bLE.mT().b(new a.C0050a(3));
                }
            }
        }
    };
    private com.baidu.adp.framework.listener.a gXw = new com.baidu.adp.framework.listener.a(1003065, CmdConfigSocket.CMD_TOPIC_BLESS) { // from class: com.baidu.tieba.homepage.personalize.e.19
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            long j;
            long j2;
            com.baidu.tieba.homepage.topic.topictab.b.b bVar;
            if (responsedMessage != null) {
                if (responsedMessage instanceof BlessHttpResponseMessage) {
                    long j3 = ((BlessHttpResponseMessage) responsedMessage).userPkId;
                    j = ((BlessHttpResponseMessage) responsedMessage).pkID;
                    j2 = j3;
                } else if (responsedMessage instanceof BlessSocketResponseMessage) {
                    long j4 = ((BlessSocketResponseMessage) responsedMessage).userPkId;
                    j = ((BlessSocketResponseMessage) responsedMessage).pkID;
                    j2 = j4;
                } else {
                    j = 0;
                    j2 = 0;
                }
                long longValue = (j == 0 && responsedMessage.getOrginalMessage() != null && (responsedMessage.getOrginalMessage().getExtra() instanceof RequestBlessMessage)) ? ((RequestBlessMessage) responsedMessage.getOrginalMessage().getExtra()).pk_id.longValue() : j;
                if (longValue != 0) {
                    for (com.baidu.adp.widget.ListView.m mVar : e.this.mDataList) {
                        if ((mVar instanceof com.baidu.tieba.homepage.topic.topictab.b.a) && (bVar = ((com.baidu.tieba.homepage.topic.topictab.b.a) mVar).hbT) != null && longValue == bVar.pkId) {
                            bVar.userPkId = j2;
                            return;
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener gkx = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.homepage.personalize.e.20
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int[] imageWidthAndHeight;
            List<com.baidu.adp.widget.ListView.m> dataList = e.this.gWs.getDataList();
            if (!v.isEmpty(dataList)) {
                for (com.baidu.adp.widget.ListView.m mVar : dataList) {
                    if (mVar instanceof k) {
                        k kVar = (k) mVar;
                        if (kVar.cMS != 0 && kVar.cMR != null) {
                            if ((TbSingleton.getInstance().getHomePageStyleAbTest() & 4) != 0) {
                                imageWidthAndHeight = kVar.cMR.aBx();
                            } else {
                                imageWidthAndHeight = kVar.cMR.getImageWidthAndHeight();
                            }
                            kVar.cMS = imageWidthAndHeight[0];
                            kVar.cMT = imageWidthAndHeight[1];
                        }
                    }
                }
            }
            com.baidu.adp.lib.f.e.gy().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.personalize.e.20.1
                @Override // java.lang.Runnable
                public void run() {
                    e.this.gWs.notifyDataSetChanged();
                    if (!e.this.mIsBackground && e.this.gWa) {
                        e.this.glq.a(e.this.gkE, e.this.efC, e.this.glj, true);
                    }
                }
            }, 500L);
        }
    };

    /* loaded from: classes6.dex */
    public interface a {
        void M(int i, int i2, int i3);

        void bLU();

        void onError(int i, String str);

        void onSuccess();

        void z(int i, int i2, int i3, int i4);
    }

    public void mu(boolean z) {
        this.gXj = z;
        if (this.gXc != null && !z) {
            this.gXc.hideTip();
        }
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.gWf = scrollFragmentTabHost;
        if (this.gWf != null) {
            this.gWf.setOnTabSelectedListener(new ScrollFragmentTabHost.b() { // from class: com.baidu.tieba.homepage.personalize.e.1
                @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.b
                public void uZ(int i) {
                    if (e.this.gWf.uY(i) != 1 && e.this.gXc != null) {
                        e.this.gXc.hideTip();
                    }
                }
            });
        }
    }

    public void setTabInForeBackgroundState(boolean z) {
        this.mIsBackground = z;
    }

    public void lf(boolean z) {
        boolean z2 = false;
        this.mIsBackground = z;
        if (this.gWf != null) {
            this.gWf.lf(z);
        }
        if (this.glq != null) {
            this.glq.on(!z);
            af bLE = bLE();
            if (bLE != null && bLE.mT() != null) {
                z2 = bLE.mT().b(new a.C0050a(8, Boolean.valueOf(z)));
            }
            if (!z2) {
                if (z) {
                    this.glq.bLD();
                } else if (this.gWa) {
                    this.glq.a(this.gkE, this.efC, this.glj, true);
                }
            }
        }
    }

    public e(TbPageContext<?> tbPageContext, BdTypeRecyclerView bdTypeRecyclerView, ab abVar, BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout) {
        this.gXn = 0;
        this.mPageContext = tbPageContext;
        this.gXn = com.baidu.tbadk.core.sharedPref.b.aCY().getInt("key_personalized_refresh_type", 0);
        this.gRz = bigdaySwipeRefreshLayout;
        this.gnE = bdTypeRecyclerView;
        this.gnE.setOnTouchListener(this.dne);
        this.gHa = new com.baidu.tieba.f.a();
        this.gHa.a(this.fLT);
        this.gWs = abVar;
        this.gXd = new com.baidu.tieba.homepage.personalize.model.a();
        this.gWW = com.baidu.tbadk.core.sharedPref.b.aCY().getLong("recommend_frs_cache_time", 3600L) * 1000;
        bdTypeRecyclerView.setOnScrollListener(this.mOnScrollListener);
        this.gXc = new ar();
        bMe();
        this.glq = new m(this.mPageContext, this.gnE);
        this.glq.Ac(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.gWX = new b(this.mDataList, this.gWs);
        this.gXm = new SmartBubbleAnimatedView(tbPageContext.getContext());
        this.gXm.setLayoutParams(new FrameLayout.LayoutParams(-1, l.getDimens(tbPageContext.getContext(), R.dimen.tbds83)));
        bLV();
        this.gkx.setTag(this.mPageContext.getUniqueId());
        MessageManager.getInstance().registerListener(this.gkx);
    }

    private void bLV() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2016323, new CustomMessageTask.CustomRunnable<Boolean>() { // from class: com.baidu.tieba.homepage.personalize.e.25
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Boolean> customMessage) {
                af bLE = e.this.bLE();
                return (bLE == null || bLE.mT() == null) ? new CustomResponsedMessage<>(2016323, false) : new CustomResponsedMessage<>(2016323, Boolean.valueOf(bLE.mT().b(new a.C0050a(6))));
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private boolean bLW() {
        return com.baidu.tbadk.core.sharedPref.b.aCY().getBoolean(bLY(), true);
    }

    private void bLX() {
        com.baidu.tbadk.core.sharedPref.b.aCY().putBoolean(bLY(), false);
    }

    private String bLY() {
        return "key_rec_pfirst_load_" + TbadkCoreApplication.getCurrentAccount() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + TbConfig.getVersion();
    }

    public void setRecommendFrsNavigationAnimDispatcher(z zVar) {
        if (zVar != null) {
            this.dCz = zVar.aPC();
            this.dpy = zVar.aPD();
        }
    }

    public void showFloatingView() {
        if (this.dCz != null) {
            this.dCz.gR(true);
        }
    }

    public void update() {
        com.baidu.tieba.homepage.framework.a.bKI().q(System.currentTimeMillis(), 1);
        this.mPn = 1;
        this.gXh = true;
        if (this.mDataList.size() == 0 && !bLW()) {
            if (!this.gRH) {
                axp();
                return;
            }
            return;
        }
        axo();
    }

    public void bU(int i, int i2) {
        bj bjVar;
        if (!v.isEmpty(this.mDataList) && this.mDataList.size() > i) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            while (i < this.mDataList.size() && i <= i2) {
                if (this.mDataList.get(i).getType().getId() == bj.cNm.getId() && (bjVar = (bj) this.mDataList.get(i)) != null && bjVar.azX() != null) {
                    arrayList.add(Long.valueOf(bjVar.azX().live_id));
                    arrayList2.add(bjVar);
                }
                i++;
            }
            if (!v.isEmpty(arrayList)) {
                MessageManager.getInstance().sendMessage(new LiveRoomClosedQueryMessage(arrayList, arrayList2));
            }
        }
    }

    public void bLZ() {
        if (this.glq != null && !this.mIsBackground && this.gWa) {
            this.glq.a(this.gkE, this.efC, this.glj, true);
        }
        if (this.gXf) {
            if (this.gRz != null && !this.gRz.aFj()) {
                if (this.gPH) {
                    com.baidu.tieba.r.c.cHo().b(this.gXl, false);
                    if (mw(false)) {
                        bV(3, this.gXb);
                    } else if (this.gXg > 0) {
                        bV(2, this.gXb);
                    }
                } else if (!this.gPH && this.gXb == 0) {
                    bV(2, 0);
                }
            }
            com.baidu.tbadk.core.sharedPref.b.aCY().putLong(SharedPrefConfig.RECOMMEND_FRS_REFRESH_TIME, System.currentTimeMillis());
            this.gXf = false;
            this.gPH = false;
            this.gXg = 0;
            if (this.gXh) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
            }
            this.gXh = false;
        }
    }

    public void aZs() {
        if (isLoading()) {
            com.baidu.tieba.homepage.framework.a.bKI().q(0L, 1);
        } else if (this.gWY != null) {
            bMb();
            this.mPn++;
            setIsLoading(true);
            this.gWY.z(this.mPn, (this.gWZ == null || this.gWZ.thread_list == null) ? 0 : this.gWZ.thread_list.size(), mv(false), 0);
        }
    }

    public void a(boolean z, boolean z2, DataRes dataRes, int i, String str) {
        int size = (this.gWZ == null || this.gWZ.thread_list == null) ? 0 : this.gWZ.thread_list.size();
        if (!z && i == 0 && dataRes != null && v.isEmpty(dataRes.thread_list)) {
            if (this.gWY != null) {
                this.gWY.bLU();
            }
            setIsLoading(false);
            if (this.gRz != null) {
                this.gRz.setRefreshing(false);
                return;
            }
            return;
        }
        if (i != 0 || dataRes == null || !a(true, z, z2, dataRes)) {
            this.gXf = false;
            if (this.mDataList.size() > 0) {
                if (this.gWY != null) {
                    this.gWY.onError(1, str);
                }
            } else if (this.gWY != null) {
                this.gWY.onError(2, str);
            }
        } else {
            bLX();
            if (this.gWY != null) {
                this.gWY.onSuccess();
            }
            this.gXf = true;
            this.gPH = z;
            this.gXg = size;
            bvZ();
        }
        setIsLoading(false);
        if (this.gRz != null) {
            g.e bMa = bMa();
            if (this.gRz.aFj() && bMa != null) {
                this.gRz.c(bMa);
            } else {
                this.gRz.setRefreshing(false);
            }
        }
    }

    private g.e bMa() {
        int i;
        String feedText;
        if (this.gXf && this.gRz != null && this.gRz.aFj()) {
            int i2 = this.gXb;
            if (this.gPH) {
                com.baidu.tieba.r.c.cHo().b(this.gXl, false);
                if (mw(false)) {
                    i = 3;
                } else {
                    i = this.gXg > 0 ? 2 : 0;
                }
            } else if (this.gPH || this.gXb != 0) {
                return null;
            } else {
                i2 = 0;
                i = 2;
            }
            if (this.gWf != null) {
                this.gXc.bDm();
            }
            if (this.gWf != null && this.gWf.getCurrentTabType() != 1) {
                this.gXc.hideTip();
                return null;
            } else if (!this.gXj) {
                this.gXc.hideTip();
                return null;
            } else {
                this.gXa = i;
                if (i == 2) {
                    if (i2 > 0) {
                        feedText = String.format(TbadkCoreApplication.getInst().getString(R.string.recommend_frs_refresh_return), Integer.valueOf(i2));
                    } else {
                        feedText = TbadkCoreApplication.getInst().getString(R.string.recommend_frs_refresh_nodata);
                    }
                } else if (i == 3) {
                    feedText = TbadkCoreApplication.getInst().getString(R.string.recommend_frs_refresh_cache_invalid);
                } else {
                    feedText = i == 4 ? TbadkCoreApplication.getInst().getActivityPrizeData().getFeedText() : null;
                }
                if (TextUtils.isEmpty(feedText) || !j.isNetWorkAvailable()) {
                    return null;
                }
                if (i == 4) {
                    this.gnp = 1000;
                } else {
                    this.gnp = 0;
                }
                return new g.e(feedText, this.gnp);
            }
        }
        return null;
    }

    public void mk(boolean z) {
        if (z) {
            this.gWs.notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        if (this.glq != null) {
            this.glq.destroy();
        }
        if (this.gXc != null) {
            this.gXc.onDestroy();
        }
        if (this.gWX != null) {
            this.gWX.onDestroy();
        }
        if (this.gnE != null) {
            this.gnE.removeCallbacks(this.gXt);
        }
        MessageManager.getInstance().unRegisterTask(2016323);
        MessageManager.getInstance().unRegisterListener(this.gkx);
    }

    public void onPause() {
        c.d(this.gnE);
        vh(this.gXs);
        if (this.gXe != null) {
            this.gXe.aOs();
        }
    }

    private void axo() {
        if (this.gWY != null) {
            this.gWY.M((this.gWZ == null || this.gWZ.thread_list == null || bMd()) ? 0 : this.gWZ.thread_list.size(), mv(true), 0);
        }
    }

    public int mv(boolean z) {
        int i;
        int i2;
        int i3;
        int i4;
        if (this.mDataList == null || this.mDataList.size() == 0) {
            return 0;
        }
        if (z) {
            int i5 = 0;
            int i6 = -1;
            int i7 = 0;
            while (i5 < this.mDataList.size()) {
                com.baidu.adp.widget.ListView.m mVar = this.mDataList.get(i5);
                if (!(mVar instanceof com.baidu.tieba.card.data.c) || (i3 = ((com.baidu.tieba.card.data.c) mVar).position) == i6) {
                    i3 = i6;
                    i4 = i7;
                } else {
                    i4 = i7 + 1;
                }
                if (!(mVar instanceof com.baidu.tieba.homepage.personalize.data.a) || mVar.getType() == AdvertAppInfo.cIv) {
                    i5++;
                    i7 = i4;
                    i6 = i3;
                } else {
                    return i4;
                }
            }
        } else {
            int size = this.mDataList.size() - 1;
            int i8 = 0;
            int i9 = -1;
            while (size >= 0) {
                com.baidu.adp.widget.ListView.m mVar2 = this.mDataList.get(size);
                if (!(mVar2 instanceof com.baidu.tieba.card.data.c) || (i = ((com.baidu.tieba.card.data.c) mVar2).position) == i9) {
                    i = i9;
                    i2 = i8;
                } else {
                    i2 = i8 + 1;
                }
                if ((mVar2 instanceof com.baidu.tieba.homepage.personalize.data.a) && mVar2.getType() != AdvertAppInfo.cIv) {
                    return i2;
                }
                size--;
                i8 = i2;
                i9 = i;
            }
        }
        return this.mDataList.size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(DataRes dataRes) {
        this.gRH = true;
        if (dataRes != null) {
            if (a(false, true, true, dataRes) && !bMd()) {
                if (this.gWY != null) {
                    this.gWY.onSuccess();
                    return;
                }
                return;
            }
            axo();
            return;
        }
        axo();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.util.Set] */
    private void i(List<com.baidu.adp.widget.ListView.m> list, int i) {
        AdvertAppInfo bsP;
        AdvertAppInfo bsP2;
        if (!v.isEmpty(list)) {
            Set<com.baidu.adp.widget.ListView.m> HB = com.baidu.tieba.recapp.report.a.HB("NEWINDEX");
            HashSet hashSet = HB == null ? new HashSet() : HB;
            HashSet hashSet2 = new HashSet();
            for (com.baidu.adp.widget.ListView.m mVar : list) {
                if (mVar != null) {
                    for (com.baidu.adp.widget.ListView.m mVar2 : hashSet) {
                        if ((mVar instanceof com.baidu.tieba.card.data.d) && (bsP2 = ((com.baidu.tieba.card.data.d) mVar).bsP()) != null && mVar2 != null && (mVar2 instanceof AdvertAppInfo) && mVar2.hashCode() == bsP2.hashCode()) {
                            bsP2.advertAppContext = ((AdvertAppInfo) mVar2).advertAppContext;
                        }
                    }
                    if (mVar != null && (mVar instanceof com.baidu.tieba.card.data.d) && (bsP = ((com.baidu.tieba.card.data.d) mVar).bsP()) != null && bsP.advertAppContext == null) {
                        bsP.advertAppContext = new com.baidu.tbadk.core.data.c();
                        bsP.advertAppContext.page = "NEWINDEX";
                        bsP.advertAppContext.pn = this.mPn;
                        bsP.advertAppContext.extensionInfo = bsP.extensionInfo;
                        bsP.advertAppContext.CN = false;
                        hashSet2.add(bsP);
                    }
                }
            }
            hashSet.addAll(hashSet2);
            com.baidu.tieba.recapp.report.a.b("NEWINDEX", hashSet);
            if (hashSet2.size() > 0) {
                com.baidu.tieba.r.c.cHo().b(this.gXl, com.baidu.tieba.r.a.b(PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE, "common_fill", true, hashSet2.size()));
            }
        }
    }

    private boolean a(boolean z, boolean z2, boolean z3, DataRes dataRes) {
        List<com.baidu.adp.widget.ListView.m> list;
        boolean z4;
        if (dataRes == null) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.gXn == 1) {
            if (z2 && (dataRes.thread_list.size() >= 6 || bMd())) {
                bMc();
                this.gWZ = null;
            }
        } else if (z2 && bMd()) {
            this.gWZ = null;
        }
        int size = z2 ? 0 : this.mDataList.size();
        DataRes.Builder builder = new DataRes.Builder(dataRes);
        this.mDataList.clear();
        com.baidu.tieba.homepage.personalize.model.c a2 = this.gXd.a(z, this.gWZ, builder, z2 ? 0 : 1);
        if (a2 == null) {
            list = null;
        } else {
            List<com.baidu.adp.widget.ListView.m> list2 = a2.dOP;
            this.gXb = a2.gZD;
            list = list2;
        }
        if (list != null) {
            this.mDataList.addAll(list);
            i(list, size);
            a(z2 ? 0 : 1, list, size);
            if (this.gXh) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
            }
        }
        if (this.gWZ == null) {
            this.gWZ = builder;
            this.gWX.cG(this.gWZ.thread_list);
        }
        if (this.mDataList.size() == 0) {
            z4 = false;
        } else {
            if (z2) {
                if (dataRes.live_answer != null) {
                    this.gXi = new com.baidu.tieba.homepage.personalize.data.f();
                    this.gXi.a(dataRes.live_answer);
                    this.gWZ.live_answer = dataRes.live_answer;
                } else if (z) {
                    this.gXi = null;
                    this.gWZ.live_answer = null;
                }
                this.gXk = dataRes.float_info;
                this.gWZ.float_info = dataRes.float_info;
            }
            long j = com.baidu.tbadk.core.sharedPref.b.aCY().getLong("key_maintab_banner_close_time", 0L);
            if (this.gXi != null && !aq.isTaday(j)) {
                this.mDataList.add(0, this.gXi);
            }
            LinkedList linkedList = new LinkedList(this.mDataList);
            this.gWs.setFromCDN(dataRes.is_new_url.intValue() == 1);
            this.gWs.ad(linkedList);
            z4 = true;
            if (this.glq != null && this.gWa) {
                this.glq.a(this.gkE, this.efC, this.glj, true);
            }
        }
        com.baidu.tieba.homepage.framework.a.bKI().o(System.currentTimeMillis() - currentTimeMillis, 1);
        long uO = com.baidu.tieba.homepage.framework.a.bKI().uO(1);
        if (uO > 0) {
            com.baidu.tieba.homepage.framework.a.bKI().p(System.currentTimeMillis() - uO, 1);
            com.baidu.tieba.homepage.framework.a.bKI().q(0L, 1);
        }
        if (dataRes.anti != null && dataRes.anti.block_pop_info != null) {
            com.baidu.tieba.ueg.d.d(dataRes.anti.block_pop_info);
        }
        ay ayVar = new ay();
        ayVar.a(dataRes.recom_post_topic);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_REFRESH_TOPIC_TIP, ayVar));
        return z4;
    }

    private void bMb() {
        if (v.getCount(this.mDataList) >= this.gXd.bMw() - 40) {
            com.baidu.tieba.homepage.personalize.model.c a2 = this.gXd.a(true, this.gWZ, (DataRes.Builder) null, 1);
            List<com.baidu.adp.widget.ListView.m> list = a2 != null ? a2.dOP : null;
            if (list != null) {
                this.mDataList.clear();
                this.mDataList.addAll(list);
                this.gWs.ad(new LinkedList(this.mDataList));
            }
        }
    }

    private void axp() {
        this.gRH = true;
        ac.a(new com.baidu.tbadk.util.ab<DataRes>() { // from class: com.baidu.tieba.homepage.personalize.e.26
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.ab
            /* renamed from: bMi */
            public DataRes doInBackground() {
                com.baidu.adp.lib.cache.l<byte[]> ch = com.baidu.tbadk.core.c.a.aBV().ch("tb.rec_frs_update", TbadkCoreApplication.getCurrentAccount());
                if (ch == null) {
                    return null;
                }
                byte[] bArr = ch.get("0");
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
        }, new com.baidu.tbadk.util.l<DataRes>() { // from class: com.baidu.tieba.homepage.personalize.e.27
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.l
            /* renamed from: b */
            public void onReturnDataInUI(DataRes dataRes) {
                e.this.a(dataRes);
            }
        });
    }

    private void bvZ() {
        if (this.gWZ != null) {
            DataRes.Builder builder = new DataRes.Builder(this.gWZ.build(true));
            if (builder.thread_list != null && builder.thread_list.size() > 30) {
                builder.thread_list = builder.thread_list.subList(0, 30);
            }
            a(builder, builder.thread_list != null ? builder.thread_list.size() : 0);
            a(builder);
        }
    }

    private void bMc() {
        if (this.gWZ != null) {
            final DataRes.Builder builder = new DataRes.Builder(this.gWZ.build(true));
            if (builder.thread_list != null && builder.thread_list.size() > 50) {
                builder.thread_list = builder.thread_list.subList(0, 50);
            }
            a(builder, builder.thread_list != null ? builder.thread_list.size() : 0);
            ac.a(new com.baidu.tbadk.util.ab<Object>() { // from class: com.baidu.tieba.homepage.personalize.e.2
                @Override // com.baidu.tbadk.util.ab
                public Object doInBackground() {
                    DataRes.Builder builder2 = new DataRes.Builder(builder.build(true));
                    e.this.gWX.cH(builder2.thread_list);
                    try {
                        com.baidu.tbadk.core.c.a.aBV().ch("tb.rec_old_data", TbadkCoreApplication.getCurrentAccount()).setForever("0", builder2.build(true).toByteArray());
                        return null;
                    } catch (Exception e) {
                        BdLog.e(e);
                        return null;
                    }
                }
            }, null);
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
                        int i3 = com.baidu.adp.lib.f.b.toInt(next.pos_name, -1);
                        if (i3 < 0) {
                            it.remove();
                        } else if (i3 < i + i2 + 1) {
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
    public void BJ(String str) {
        if (!TextUtils.isEmpty(str) && this.gWZ != null && this.gWZ.banner_list != null && this.gWZ.banner_list.app != null && this.gWZ.banner_list.app.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (App app : this.gWZ.banner_list.app) {
                if (app != null && str.equals(app.id)) {
                    arrayList.add(app);
                }
            }
            BannerList.Builder builder = new BannerList.Builder(this.gWZ.banner_list);
            if (builder.app != null) {
                builder.app.removeAll(arrayList);
            }
            this.gWZ.banner_list = builder.build(false);
            DataRes.Builder builder2 = new DataRes.Builder(this.gWZ.build(true));
            builder2.banner_list = builder.build(true);
            a(builder2);
        }
    }

    private void a(final DataRes.Builder builder) {
        ac.a(new com.baidu.tbadk.util.ab<Object>() { // from class: com.baidu.tieba.homepage.personalize.e.3
            @Override // com.baidu.tbadk.util.ab
            public Object doInBackground() {
                DataRes.Builder builder2 = new DataRes.Builder(builder.build(true));
                e.this.gWX.cH(builder2.thread_list);
                try {
                    com.baidu.tbadk.core.c.a.aBV().ch("tb.rec_frs_update", TbadkCoreApplication.getCurrentAccount()).setForever("0", builder2.build(true).toByteArray());
                    return null;
                } catch (Exception e) {
                    BdLog.e(e);
                    return null;
                }
            }
        }, null);
    }

    private boolean bMd() {
        return mw(true);
    }

    private boolean mw(boolean z) {
        long j = com.baidu.tbadk.core.sharedPref.b.aCY().getLong(SharedPrefConfig.RECOMMEND_FRS_REFRESH_TIME, 0L);
        return j == 0 ? z : Math.abs(System.currentTimeMillis() - j) > this.gWW;
    }

    public void a(a aVar) {
        this.gWY = aVar;
    }

    private boolean isLoading() {
        return this.mIsLoading;
    }

    private void setIsLoading(boolean z) {
        this.mIsLoading = z;
    }

    public void bLR() {
        boolean z = true;
        com.baidu.tbadk.coreExtra.data.b activityPrizeData = TbadkCoreApplication.getInst().getActivityPrizeData();
        if (activityPrizeData.isSwitchTurn() && !StringUtils.isNull(activityPrizeData.getFeedText())) {
            String currentDay = UtilHelper.getCurrentDay();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            String str = "";
            if (!StringUtils.isNull(currentAccount)) {
                String string = com.baidu.tbadk.core.sharedPref.b.aCY().getString(SharedPrefConfig.ACTIVITY_PRIZE_FEED_TEXT_TIME, "");
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
                    bV(4, 0);
                    com.baidu.tbadk.core.sharedPref.b.aCY().putString(SharedPrefConfig.ACTIVITY_PRIZE_FEED_TEXT_TIME, str);
                }
            }
        }
    }

    private void bV(int i, int i2) {
        if (this.gWf != null) {
            this.gXc.bDm();
        }
        if (this.gWf != null && this.gWf.getCurrentTabType() != 1) {
            this.gXc.hideTip();
        } else if (!this.gXj) {
            this.gXc.hideTip();
        } else {
            this.gXa = i;
            String str = null;
            if (i == 2) {
                if (i2 > 0) {
                    str = String.format(TbadkCoreApplication.getInst().getString(R.string.recommend_frs_refresh_return), Integer.valueOf(i2));
                } else {
                    str = TbadkCoreApplication.getInst().getString(R.string.recommend_frs_refresh_nodata);
                }
            } else if (i == 3) {
                str = TbadkCoreApplication.getInst().getString(R.string.recommend_frs_refresh_cache_invalid);
            } else if (i == 4) {
                str = TbadkCoreApplication.getInst().getActivityPrizeData().getFeedText();
            }
            if (!TextUtils.isEmpty(str) && j.isNetWorkAvailable()) {
                if (i == 4) {
                    this.gnp = 3000;
                } else {
                    this.gnp = 2000;
                }
                this.gXm.dcH = str;
                this.gXm.gni = this.gnp;
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 49;
                FrameLayout frameLayout = this.gWf.getFrameLayout();
                frameLayout.removeView(this.gXm);
                frameLayout.addView(this.gXm, layoutParams);
                this.gXm.bDk();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(Long l) {
        if (this.gWZ != null && this.gWZ.thread_list != null) {
            List<ThreadInfo> list = this.gWZ.thread_list;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                ThreadInfo threadInfo = list.get(i);
                if (threadInfo.tid.equals(l) && threadInfo.top_agree_post != null) {
                    ThreadInfo.Builder builder = new ThreadInfo.Builder(threadInfo);
                    builder.top_agree_post = null;
                    list.set(i, builder.build(true));
                    bvZ();
                    a(false, true, false, this.gWZ.build(true));
                    return;
                }
            }
        }
    }

    public void m(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.gXl = bdUniqueId;
            if (this.gAd != null) {
                this.gAd.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.gAd);
            }
            if (this.gXp != null) {
                this.gXp.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.gXp);
            }
            this.cVS.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.cVS);
            this.gXq.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.gXq);
            this.gCj.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.gCj);
            this.gCk.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.gCk);
            this.gAq.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.gAq);
            if (this.glq != null) {
                this.glq.setUniqueId(bdUniqueId);
            }
            this.gWX.j(bdUniqueId);
            this.gXv.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.gXv);
            this.gkw.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.gkw);
            this.gXw.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.gXw);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(UpdateAttentionMessage updateAttentionMessage) {
        if (updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid)) {
            final String str = updateAttentionMessage.getData().toUid;
            final boolean z = updateAttentionMessage.getData().isAttention;
            ac.a(new com.baidu.tbadk.util.ab<Boolean>() { // from class: com.baidu.tieba.homepage.personalize.e.7
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.baidu.tbadk.util.ab
                public Boolean doInBackground() {
                    int intValue;
                    try {
                        com.baidu.adp.lib.cache.l<byte[]> ch = com.baidu.tbadk.core.c.a.aBV().ch("tb.rec_frs_update", TbadkCoreApplication.getCurrentAccount());
                        if (ch == null) {
                            return false;
                        }
                        byte[] bArr = ch.get("0");
                        if (bArr == null || bArr.length == 0) {
                            return false;
                        }
                        DataRes.Builder builder = new DataRes.Builder((DataRes) new Wire(new Class[0]).parseFrom(bArr, DataRes.class));
                        if (builder.thread_list == null || builder.thread_list.size() <= 0) {
                            return false;
                        }
                        for (int i = 0; i < builder.thread_list.size(); i++) {
                            ThreadInfo threadInfo = builder.thread_list.get(i);
                            if (threadInfo != null && threadInfo.author != null && threadInfo.author.id.longValue() == com.baidu.adp.lib.f.b.toLong(str, -1L)) {
                                ThreadInfo.Builder builder2 = new ThreadInfo.Builder(threadInfo);
                                User.Builder builder3 = new User.Builder(builder2.author);
                                builder3.is_like = Integer.valueOf(z ? 1 : 0);
                                builder3.has_concerned = Integer.valueOf(z ? 1 : 0);
                                GodInfo.Builder builder4 = new GodInfo.Builder(builder3.god_data);
                                if (z) {
                                    intValue = builder3.fans_num.intValue() + 1;
                                    builder4.followed = 1;
                                } else {
                                    intValue = builder3.fans_num.intValue() - 1;
                                    builder4.followed = 0;
                                }
                                builder3.fans_num = Integer.valueOf(intValue);
                                builder3.god_data = builder4.build(true);
                                builder2.author = builder3.build(true);
                                builder.thread_list.set(i, builder2.build(true));
                            }
                        }
                        DataRes.Builder builder5 = new DataRes.Builder(builder.build(true));
                        e.this.gWX.cH(builder5.thread_list);
                        ch.setForever("0", builder5.build(true).toByteArray());
                        return true;
                    } catch (Exception e) {
                        BdLog.e(e);
                        return false;
                    }
                }
            }, new com.baidu.tbadk.util.l<Boolean>() { // from class: com.baidu.tieba.homepage.personalize.e.8
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.l
                public void onReturnDataInUI(Boolean bool) {
                }
            });
        }
    }

    public void bMe() {
        this.giW = new com.baidu.tieba.tbadkCore.data.f("new_index", null);
        this.giW.cHV();
    }

    public void a(int i, List<com.baidu.adp.widget.ListView.m> list, int i2) {
        int i3;
        int i4;
        if (this.giW != null) {
            if (i == 0) {
                this.giW.cHV();
            }
            if (list != null && !list.isEmpty()) {
                int[] iArr = com.baidu.tieba.tbadkCore.data.f.kbk;
                int i5 = 0;
                int i6 = 0;
                int i7 = 0;
                while (i7 < list.size() && i6 < iArr.length && (i3 = iArr[i6]) >= 0) {
                    if (list.get(i7) instanceof com.baidu.tieba.card.data.c) {
                        i4 = i5 + 1;
                        if (i4 == i3 - 1) {
                            if (i2 < i7 + 1) {
                                this.giW.cH(i3, i7 + 1);
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

    public void vg(int i) {
        if ((this.giW != null ? this.giW.Ci(i) : -1) >= 0 && this.gnE != null && this.gnE.getData() != null && this.gnE.getData().size() > i) {
            this.giW.Cj(i);
        }
    }

    public m bCd() {
        return this.glq;
    }

    public void mq(boolean z) {
        this.gWa = z;
    }

    public void vh(final int i) {
        ac.a(new com.baidu.tbadk.util.ab<Object>() { // from class: com.baidu.tieba.homepage.personalize.e.9
            @Override // com.baidu.tbadk.util.ab
            public Object doInBackground() {
                com.baidu.adp.lib.cache.l<String> ci = com.baidu.tbadk.core.c.a.aBV().ci(e.this.gXr, TbadkCoreApplication.getCurrentAccount());
                if (ci != null) {
                    ci.set(e.this.gXr, Integer.toString(i), 43200000L);
                    return null;
                }
                return null;
            }
        }, null);
    }

    public void a(final d dVar) {
        ac.a(new com.baidu.tbadk.util.ab<String>() { // from class: com.baidu.tieba.homepage.personalize.e.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.ab
            /* renamed from: bMh */
            public String doInBackground() {
                com.baidu.adp.lib.cache.l<String> ci = com.baidu.tbadk.core.c.a.aBV().ci(e.this.gXr, TbadkCoreApplication.getCurrentAccount());
                if (ci != null) {
                    return ci.get(e.this.gXr);
                }
                return null;
            }
        }, new com.baidu.tbadk.util.l<String>() { // from class: com.baidu.tieba.homepage.personalize.e.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.l
            /* renamed from: BK */
            public void onReturnDataInUI(String str) {
                if (dVar != null) {
                    dVar.uP(com.baidu.adp.lib.f.b.toInt(str, 0));
                }
            }
        });
    }

    public void bLS() {
        c.e(this.gnE);
    }

    public void bMf() {
        a(this.gXu);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(CustomResponsedMessage<?> customResponsedMessage) {
        boolean z;
        String str;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.gWZ != null && v.getCount(this.gWZ.thread_list) != 0 && v.getCount(this.mDataList) != 0) {
            JSONObject jSONObject = (JSONObject) customResponsedMessage.getData();
            String optString = jSONObject.optString("tid");
            if (StringUtils.isNull(optString)) {
                String optString2 = jSONObject.optString("liveid");
                if (this.gnE != null && !TextUtils.isEmpty(optString2)) {
                    int i = 0;
                    while (true) {
                        if (i >= this.gnE.getCount()) {
                            str = optString;
                            break;
                        }
                        com.baidu.adp.widget.ListView.m item = this.gnE.getItem(i);
                        if (item instanceof com.baidu.tieba.card.data.j) {
                            com.baidu.tieba.card.data.j jVar = (com.baidu.tieba.card.data.j) item;
                            if (jVar.axx() != null && jVar.axx().azX() != null && optString2.equals(String.valueOf(jVar.axx().azX().live_id))) {
                                str = jVar.axx().getTid();
                                break;
                            }
                        }
                        i++;
                    }
                    if (StringUtils.isNull(str)) {
                        return;
                    }
                    optString = str;
                } else {
                    return;
                }
            }
            Iterator<com.baidu.adp.widget.ListView.m> it = this.mDataList.iterator();
            boolean z2 = false;
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.adp.widget.ListView.m next = it.next();
                if (next instanceof com.baidu.tieba.card.data.c) {
                    com.baidu.tieba.card.data.c cVar = (com.baidu.tieba.card.data.c) next;
                    if (cVar.axx() != null && cVar.axx().getTid() != null) {
                        if (cVar.axx().getTid().equals(optString)) {
                            it.remove();
                            z = true;
                            z2 = z;
                        } else if (z2) {
                            com.baidu.tieba.homepage.personalize.model.b.cJ(this.mDataList);
                            break;
                        }
                    }
                }
                z = z2;
                z2 = z;
            }
            if (this.gWZ != null && this.gWZ.thread_list != null) {
                long j = com.baidu.adp.lib.f.b.toLong(optString, 0L);
                int i2 = 0;
                while (true) {
                    if (i2 < this.gWZ.thread_list.size()) {
                        ThreadInfo threadInfo = this.gWZ.thread_list.get(i2);
                        if (threadInfo == null || threadInfo.tid == null || threadInfo.tid.longValue() != j) {
                            i2++;
                        } else {
                            this.gWZ.thread_list.remove(i2);
                            bvZ();
                            com.baidu.tieba.homepage.personalize.b.d.a(threadInfo.tid.longValue(), i2, this.gWZ.thread_list, this.mDataList);
                            break;
                        }
                    } else {
                        break;
                    }
                }
                if (this.gnE != null) {
                    List<Integer> b = b(optString, this.gnE);
                    int intValue = b.get(0).intValue();
                    int intValue2 = b.get(1).intValue();
                    if (intValue != -1 && intValue2 != -1) {
                        this.gnE.l(intValue, intValue2);
                    }
                }
            }
        }
    }

    private List<Integer> b(String str, BdTypeRecyclerView bdTypeRecyclerView) {
        int i = 0;
        ArrayList arrayList = new ArrayList(2);
        boolean z = false;
        int i2 = -1;
        int i3 = -1;
        while (true) {
            int i4 = i;
            if (i4 < bdTypeRecyclerView.getCount()) {
                com.baidu.adp.widget.ListView.m item = bdTypeRecyclerView.getItem(i4);
                if (item instanceof com.baidu.tieba.card.data.c) {
                    com.baidu.tieba.card.data.c cVar = (com.baidu.tieba.card.data.c) item;
                    if (cVar.axx() != null && cVar.axx().getTid().equals(str)) {
                        if (!z) {
                            i3 = i4;
                        }
                        z = true;
                        i2 = i4;
                    }
                }
                i = i4 + 1;
            } else {
                arrayList.add(Integer.valueOf(i3));
                arrayList.add(Integer.valueOf(i2));
                return arrayList;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(String str, List<com.baidu.adp.widget.ListView.m> list) {
        AdvertAppInfo advertAppInfo;
        if (list != null && list.size() > 0 && !TextUtils.isEmpty(str)) {
            Iterator<com.baidu.adp.widget.ListView.m> it = list.iterator();
            AdvertAppInfo advertAppInfo2 = null;
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.m next = it.next();
                if (next instanceof com.baidu.tieba.homepage.personalize.data.a) {
                    advertAppInfo = ((com.baidu.tieba.homepage.personalize.data.a) next).bsP();
                } else {
                    if (next instanceof ae) {
                        ae aeVar = (ae) next;
                        if (aeVar.ayd() instanceof AdvertAppInfo.ILegoAdvert) {
                            advertAppInfo = ((AdvertAppInfo.ILegoAdvert) aeVar.ayd()).getAdvertAppInfo();
                        }
                    }
                    advertAppInfo = advertAppInfo2;
                }
                if (advertAppInfo != null && str.equals(advertAppInfo.cIG)) {
                    it.remove();
                    advertAppInfo = null;
                }
                advertAppInfo2 = advertAppInfo;
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (this.gXm != null) {
            this.gXm.onChangeSkinType(i);
        }
    }

    public FloatInfo bMg() {
        return this.gXk;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public af bLE() {
        if (this.glq == null || this.glq.cwe() == null || !(this.glq.cwe().getTag() instanceof af)) {
            return null;
        }
        return (af) this.glq.cwe().getTag();
    }
}
