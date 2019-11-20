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
import com.baidu.card.z;
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
import com.baidu.tbadk.core.data.ad;
import com.baidu.tbadk.core.data.aw;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tbadk.util.v;
import com.baidu.tbadk.util.y;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.LiveRoomClosedQueryMessage;
import com.baidu.tieba.card.data.k;
import com.baidu.tieba.card.t;
import com.baidu.tieba.f.a;
import com.baidu.tieba.frs.SmartBubbleAnimatedView;
import com.baidu.tieba.frs.aq;
import com.baidu.tieba.homepage.BlessHttpResponseMessage;
import com.baidu.tieba.homepage.BlessSocketResponseMessage;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import com.baidu.tieba.homepage.personalize.a.w;
import com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout;
import com.baidu.tieba.homepage.personalize.data.g;
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
/* loaded from: classes4.dex */
public class e {
    private View.OnTouchListener cBN;
    private v cOx;
    private com.baidu.tieba.f.a fSB;
    private com.baidu.tieba.tbadkCore.data.f fut;
    private m fwT;
    private final BdTypeRecyclerView fzi;
    private boolean gbD;
    private final BigdaySwipeRefreshLayout gdp;
    private ScrollFragmentTabHost giN;
    private final w giZ;
    private final long gjD;
    private final b gjE;
    private DataRes.Builder gjG;
    private aq gjJ;
    private final com.baidu.tieba.homepage.personalize.model.a gjK;
    private int gjN;
    private g gjP;
    private BdUniqueId gjS;
    private SmartBubbleAnimatedView gjT;
    private int gjU;
    private Runnable gka;
    private final TbPageContext<?> mPageContext;
    private a gjF = null;
    private final List<com.baidu.adp.widget.ListView.m> mDataList = new LinkedList();
    private int mPn = 1;
    private boolean mIsLoading = false;
    private boolean gdy = false;
    private int gjH = 2;
    private int gjI = 0;
    private TextView mTipView = null;
    private int fyT = 2000;
    private com.baidu.tbadk.p.c gjL = null;
    private boolean fwM = false;
    private int fwh = 0;
    private int duA = 0;
    private boolean mIsBackground = false;
    private boolean giI = true;
    private boolean gjM = false;
    private boolean gjO = false;
    private boolean gjQ = true;
    private FloatInfo gjR = null;
    private a.C0044a fuM = new a.C0044a(2);
    private RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.e.12
        private int gki = -1;
        private int gdD = 0;
        private boolean gkj = false;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (e.this.gjL == null) {
                e.this.gjL = new com.baidu.tbadk.p.c();
                e.this.gjL.setSubType(1005);
                e.this.gjL.pageType = 1;
            }
            if (e.this.cOx != null && !e.this.mIsBackground) {
                e.this.cOx.g(recyclerView, i);
            }
            if (i == 0) {
                c.d(e.this.fzi);
                e.this.gjL.awC();
                t.bau().gF(true);
                com.baidu.tieba.a.d.aDc().bO("page_recommend", "show_");
                com.baidu.tieba.q.c.cni().b(e.this.gjS, false);
                this.gkj = false;
                if (e.this.fwT != null && e.this.giI) {
                    e.this.fwT.a(e.this.fwh, e.this.duA, e.this.fwM, 1);
                    return;
                }
                return;
            }
            e.this.gjL.awB();
            if (i == 1) {
                if (e.this.gjJ != null) {
                    e.this.gjJ.hideTip();
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
            if (this.gdD > i) {
                this.gkj = true;
            }
            if (e.this.cOx != null && !e.this.mIsBackground) {
                e.this.cOx.onScroll(this.gdD, i);
            }
            this.gdD = i;
            int i3 = (i + i2) - 1;
            if (!this.gkj && this.gki != i3) {
                this.gki = i3;
                e.this.td(this.gki);
            }
            if (this.gkj && this.gki != i) {
                this.gki = i;
                e.this.td(this.gki);
            }
            e.this.gjZ = i;
            e.this.fwh = i;
            e.this.duA = (i + i2) - 1;
            z buq = e.this.buq();
            if (buq != null && buq.lV() != null) {
                buq.lV().b(e.this.fuM);
            }
        }
    };
    private View.OnTouchListener czy = new View.OnTouchListener() { // from class: com.baidu.tieba.homepage.personalize.e.19
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (e.this.cBN != null) {
                e.this.cBN.onTouch(view, motionEvent);
            }
            if (e.this.fSB != null) {
                e.this.fSB.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private a.InterfaceC0405a eXk = new a.InterfaceC0405a() { // from class: com.baidu.tieba.homepage.personalize.e.20
        @Override // com.baidu.tieba.f.a.InterfaceC0405a
        public void t(int i, int i2) {
            e.this.fwM = true;
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0405a
        public void u(int i, int i2) {
            e.this.fwM = false;
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0405a
        public void v(int i, int i2) {
        }
    };
    private View.OnClickListener gjV = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.e.21
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (e.this.gjJ != null) {
                e.this.gjJ.hideTip();
            }
        }
    };
    private final CustomMessageListener gjW = new CustomMessageListener(CmdConfigCustom.CMD_RELOAD_HP_PERSONALIZED) { // from class: com.baidu.tieba.homepage.personalize.e.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (e.this.fzi != null) {
                e.this.fwT.bup();
                e.this.giI = false;
                e.this.gdp.setRefreshing(true);
            }
        }
    };
    private CustomMessageListener fLO = new CustomMessageListener(CmdConfigCustom.PB_ACTION_PRAISE) { // from class: com.baidu.tieba.homepage.personalize.e.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            bh bhVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bh) && e.this.gjG != null && com.baidu.tbadk.core.util.v.getCount(e.this.gjG.thread_list) != 0 && (bhVar = (bh) customResponsedMessage.getData()) != null && bhVar.aiq() != null && bhVar.getId() != null && com.baidu.tbadk.core.util.v.getCount(e.this.gjG.thread_list) != 0) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < e.this.gjG.thread_list.size()) {
                        ThreadInfo threadInfo = e.this.gjG.thread_list.get(i2);
                        if (threadInfo == null || threadInfo.id.longValue() != com.baidu.adp.lib.g.b.toLong(bhVar.getId(), -1L)) {
                            i = i2 + 1;
                        } else {
                            ThreadInfo.Builder builder = new ThreadInfo.Builder(threadInfo);
                            Zan.Builder builder2 = new Zan.Builder(builder.zan);
                            builder2.num = Integer.valueOf((int) bhVar.aiq().getNum());
                            builder.zan = builder2.build(true);
                            e.this.gjG.thread_list.set(i2, builder.build(true));
                            return;
                        }
                    } else {
                        return;
                    }
                }
            }
        }
    };
    private CustomMessageListener gjX = new CustomMessageListener(CmdConfigCustom.CMD_LIVE_VIDEO_CLOSED_QUERY_RESPONSED) { // from class: com.baidu.tieba.homepage.personalize.e.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            bh bhVar;
            if (customResponsedMessage.getOrginalMessage() instanceof LiveRoomClosedQueryMessage) {
                List<Long> ids = ((LiveRoomClosedQueryMessage) customResponsedMessage.getOrginalMessage()).getIds();
                List<Object> originData = ((LiveRoomClosedQueryMessage) customResponsedMessage.getOrginalMessage()).getOriginData();
                if (!com.baidu.tbadk.core.util.v.isEmpty(e.this.mDataList) && !com.baidu.tbadk.core.util.v.isEmpty(ids) && !com.baidu.tbadk.core.util.v.isEmpty(originData)) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= originData.size()) {
                            break;
                        }
                        if ((originData.get(i2) instanceof bh) && (bhVar = (bh) originData.get(i2)) != null && bhVar.aiX() != null && ids.contains(Long.valueOf(bhVar.aiX().live_id))) {
                            e.this.mDataList.remove(bhVar);
                        }
                        i = i2 + 1;
                    }
                    if (e.this.giZ != null) {
                        e.this.giZ.aY(new ArrayList(e.this.mDataList));
                    }
                }
            }
        }
    };
    private CustomMessageListener cji = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.homepage.personalize.e.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int intValue;
            if ((customResponsedMessage instanceof UpdateAttentionMessage) && e.this.gjG != null && !com.baidu.tbadk.core.util.v.isEmpty(e.this.gjG.thread_list)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid)) {
                    for (int i = 0; i < e.this.gjG.thread_list.size(); i++) {
                        ThreadInfo threadInfo = e.this.gjG.thread_list.get(i);
                        if (threadInfo != null && threadInfo.author != null && threadInfo.author.id.longValue() == com.baidu.adp.lib.g.b.toLong(updateAttentionMessage.getData().toUid, -1L)) {
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
                            e.this.gjG.thread_list.set(i, builder.build(true));
                            return;
                        }
                    }
                }
            }
        }
    };
    private String gjY = "lastReadReadPositionKey";
    private int gjZ = 0;
    private d gkb = new d() { // from class: com.baidu.tieba.homepage.personalize.e.8
        @Override // com.baidu.tieba.homepage.personalize.d
        public void sL(final int i) {
            if (e.this.gka == null) {
                e.this.gka = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.e.8.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (e.this.fzi.getHandler() != null) {
                            e.this.fzi.requestFocusFromTouch();
                            if (i <= e.this.fzi.getCount() - 1) {
                                e.this.fzi.setSelection(i);
                            }
                        }
                    }
                };
            }
            e.this.fzi.removeCallbacks(e.this.gka);
            e.this.fzi.post(e.this.gka);
        }
    };
    private CustomMessageListener gkc = new CustomMessageListener(2016569) { // from class: com.baidu.tieba.homepage.personalize.e.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && e.this.gjP != null) {
                e.this.mDataList.remove(e.this.gjP);
                e.this.giZ.aY(new ArrayList(e.this.mDataList));
                com.baidu.tbadk.core.sharedPref.b.alP().putLong("key_maintab_banner_close_time", System.currentTimeMillis());
            }
        }
    };
    private CustomMessageListener fNW = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.homepage.personalize.e.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.h(customResponsedMessage);
            if (e.this.fwT != null && e.this.giI) {
                e.this.fwT.c(e.this.fwh, e.this.duA, e.this.fwM, true);
            }
        }
    };
    private CustomMessageListener fNX = new CustomMessageListener(CmdConfigCustom.CMD_THREAD_NOT_EXIST_WHEN_ENTER_PB) { // from class: com.baidu.tieba.homepage.personalize.e.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.h(customResponsedMessage);
        }
    };
    private CustomMessageListener fMd = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.homepage.personalize.e.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && e.this.gjG != null && com.baidu.tbadk.core.util.v.getCount(e.this.gjG.thread_list) != 0) {
                String str = (String) customResponsedMessage.getData();
                e.this.h(str, e.this.mDataList);
                e.this.xa(str);
                if (e.this.giZ != null) {
                    e.this.giZ.aY(new ArrayList(e.this.mDataList));
                }
                if (e.this.fwT != null && e.this.giI) {
                    e.this.fwT.c(e.this.fwh, e.this.duA, e.this.fwM, true);
                }
            }
        }
    };
    private CustomMessageListener fwa = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.homepage.personalize.e.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            z buq;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent)) {
                KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24 && (buq = e.this.buq()) != null && buq.lV() != null) {
                    buq.lV().b(new a.C0044a(3));
                }
            }
        }
    };
    private com.baidu.adp.framework.listener.a gkd = new com.baidu.adp.framework.listener.a(1003065, CmdConfigSocket.CMD_TOPIC_BLESS) { // from class: com.baidu.tieba.homepage.personalize.e.17
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
                        if ((mVar instanceof com.baidu.tieba.homepage.topic.topictab.b.a) && (bVar = ((com.baidu.tieba.homepage.topic.topictab.b.a) mVar).gos) != null && longValue == bVar.pkId) {
                            bVar.userPkId = j2;
                            return;
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener fwb = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.homepage.personalize.e.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int[] imageWidthAndHeight;
            List<com.baidu.adp.widget.ListView.m> dataList = e.this.giZ.getDataList();
            if (!com.baidu.tbadk.core.util.v.isEmpty(dataList)) {
                for (com.baidu.adp.widget.ListView.m mVar : dataList) {
                    if (mVar instanceof k) {
                        k kVar = (k) mVar;
                        if (kVar.caA != 0 && kVar.caz != null) {
                            if ((TbSingleton.getInstance().getHomePageStyleAbTest() & 4) != 0) {
                                imageWidthAndHeight = kVar.caz.akw();
                            } else {
                                imageWidthAndHeight = kVar.caz.getImageWidthAndHeight();
                            }
                            kVar.caA = imageWidthAndHeight[0];
                            kVar.caB = imageWidthAndHeight[1];
                        }
                    }
                }
            }
            com.baidu.adp.lib.g.e.fZ().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.personalize.e.18.1
                @Override // java.lang.Runnable
                public void run() {
                    e.this.giZ.notifyDataSetChanged();
                    if (!e.this.mIsBackground && e.this.giI) {
                        e.this.fwT.c(e.this.fwh, e.this.duA, e.this.fwM, true);
                    }
                }
            }, 500L);
        }
    };

    /* loaded from: classes4.dex */
    public interface a {
        void M(int i, int i2, int i3);

        void buG();

        void onError(int i, String str);

        void onSuccess();

        void v(int i, int i2, int i3, int i4);
    }

    public void lh(boolean z) {
        this.gjQ = z;
        if (this.gjJ != null && !z) {
            this.gjJ.hideTip();
        }
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.giN = scrollFragmentTabHost;
        if (this.giN != null) {
            this.giN.setOnTabSelectedListener(new ScrollFragmentTabHost.b() { // from class: com.baidu.tieba.homepage.personalize.e.1
                @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.b
                public void sW(int i) {
                    if (e.this.giN.sV(i) != 1 && e.this.gjJ != null) {
                        e.this.gjJ.hideTip();
                    }
                }
            });
        }
    }

    public void setTabInForeBackgroundState(boolean z) {
        this.mIsBackground = z;
    }

    public void jT(boolean z) {
        boolean z2 = false;
        this.mIsBackground = z;
        if (this.giN != null) {
            this.giN.jT(z);
        }
        if (this.fwT != null) {
            this.fwT.mY(!z);
            z buq = buq();
            if (buq != null && buq.lV() != null) {
                z2 = buq.lV().b(new a.C0044a(8, Boolean.valueOf(z)));
            }
            if (!z2) {
                if (z) {
                    this.fwT.bup();
                } else if (this.giI) {
                    this.fwT.c(this.fwh, this.duA, this.fwM, true);
                }
            }
        }
    }

    public e(TbPageContext<?> tbPageContext, BdTypeRecyclerView bdTypeRecyclerView, w wVar, BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout) {
        this.gjU = 0;
        this.mPageContext = tbPageContext;
        this.gjU = com.baidu.tbadk.core.sharedPref.b.alP().getInt("key_personalized_refresh_type", 0);
        this.gdp = bigdaySwipeRefreshLayout;
        this.fzi = bdTypeRecyclerView;
        this.fzi.setOnTouchListener(this.czy);
        this.fSB = new com.baidu.tieba.f.a();
        this.fSB.a(this.eXk);
        this.giZ = wVar;
        this.gjK = new com.baidu.tieba.homepage.personalize.model.a();
        this.gjD = com.baidu.tbadk.core.sharedPref.b.alP().getLong("recommend_frs_cache_time", 3600L) * 1000;
        bdTypeRecyclerView.setOnScrollListener(this.mOnScrollListener);
        this.gjJ = new aq();
        buQ();
        this.fwT = new m(this.mPageContext, this.fzi);
        this.fwT.xF(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.gjE = new b(this.mDataList, this.giZ);
        this.gjT = new SmartBubbleAnimatedView(tbPageContext.getContext());
        this.gjT.setLayoutParams(new FrameLayout.LayoutParams(-1, l.getDimens(tbPageContext.getContext(), R.dimen.tbds83)));
        buH();
        this.fwb.setTag(this.mPageContext.getUniqueId());
        MessageManager.getInstance().registerListener(this.fwb);
    }

    private void buH() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2016323, new CustomMessageTask.CustomRunnable<Boolean>() { // from class: com.baidu.tieba.homepage.personalize.e.23
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Boolean> customMessage) {
                z buq = e.this.buq();
                return (buq == null || buq.lV() == null) ? new CustomResponsedMessage<>(2016323, false) : new CustomResponsedMessage<>(2016323, Boolean.valueOf(buq.lV().b(new a.C0044a(6))));
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private boolean buI() {
        return com.baidu.tbadk.core.sharedPref.b.alP().getBoolean(buK(), true);
    }

    private void buJ() {
        com.baidu.tbadk.core.sharedPref.b.alP().putBoolean(buK(), false);
    }

    private String buK() {
        return "key_rec_pfirst_load_" + TbadkCoreApplication.getCurrentAccount() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + TbConfig.getVersion();
    }

    public void setRecommendFrsNavigationAnimDispatcher(com.baidu.tbadk.util.w wVar) {
        if (wVar != null) {
            this.cOx = wVar.axL();
            this.cBN = wVar.axM();
        }
    }

    public void showFloatingView() {
        if (this.cOx != null) {
            this.cOx.fE(true);
        }
    }

    public void update() {
        com.baidu.tieba.homepage.framework.a.btt().p(System.currentTimeMillis(), 1);
        this.mPn = 1;
        this.gjO = true;
        if (this.mDataList.size() == 0 && !buI()) {
            if (!this.gdy) {
                agy();
                return;
            }
            return;
        }
        agx();
    }

    public void bC(int i, int i2) {
        bh bhVar;
        if (!com.baidu.tbadk.core.util.v.isEmpty(this.mDataList) && this.mDataList.size() > i) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            while (i < this.mDataList.size() && i <= i2) {
                if (this.mDataList.get(i).getType().getId() == bh.caS.getId() && (bhVar = (bh) this.mDataList.get(i)) != null && bhVar.aiX() != null) {
                    arrayList.add(Long.valueOf(bhVar.aiX().live_id));
                    arrayList2.add(bhVar);
                }
                i++;
            }
            if (!com.baidu.tbadk.core.util.v.isEmpty(arrayList)) {
                MessageManager.getInstance().sendMessage(new LiveRoomClosedQueryMessage(arrayList, arrayList2));
            }
        }
    }

    public void buL() {
        if (this.fwT != null && !this.mIsBackground && this.giI) {
            this.fwT.c(this.fwh, this.duA, this.fwM, true);
        }
        if (this.gjM) {
            if (this.gdp != null && !this.gdp.anQ()) {
                if (this.gbD) {
                    com.baidu.tieba.q.c.cni().b(this.gjS, false);
                    if (lj(false)) {
                        bD(3, this.gjI);
                    } else if (this.gjN > 0) {
                        bD(2, this.gjI);
                    }
                } else if (!this.gbD && this.gjI == 0) {
                    bD(2, 0);
                }
            }
            com.baidu.tbadk.core.sharedPref.b.alP().putLong(SharedPrefConfig.RECOMMEND_FRS_REFRESH_TIME, System.currentTimeMillis());
            this.gjM = false;
            this.gbD = false;
            this.gjN = 0;
            if (this.gjO) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
            }
            this.gjO = false;
        }
    }

    public void aIU() {
        if (isLoading()) {
            com.baidu.tieba.homepage.framework.a.btt().p(0L, 1);
        } else if (this.gjF != null) {
            buN();
            this.mPn++;
            setIsLoading(true);
            this.gjF.v(this.mPn, (this.gjG == null || this.gjG.thread_list == null) ? 0 : this.gjG.thread_list.size(), li(false), 0);
        }
    }

    public void a(boolean z, boolean z2, DataRes dataRes, int i, String str) {
        int size = (this.gjG == null || this.gjG.thread_list == null) ? 0 : this.gjG.thread_list.size();
        if (!z && i == 0 && dataRes != null && com.baidu.tbadk.core.util.v.isEmpty(dataRes.thread_list)) {
            if (this.gjF != null) {
                this.gjF.buG();
            }
            setIsLoading(false);
            if (this.gdp != null) {
                this.gdp.setRefreshing(false);
                return;
            }
            return;
        }
        if (i != 0 || dataRes == null || !a(true, z, z2, dataRes)) {
            this.gjM = false;
            if (this.mDataList.size() > 0) {
                if (this.gjF != null) {
                    this.gjF.onError(1, str);
                }
            } else if (this.gjF != null) {
                this.gjF.onError(2, str);
            }
        } else {
            buJ();
            if (this.gjF != null) {
                this.gjF.onSuccess();
            }
            this.gjM = true;
            this.gbD = z;
            this.gjN = size;
            beF();
        }
        setIsLoading(false);
        if (this.gdp != null) {
            h.e buM = buM();
            if (this.gdp.anQ() && buM != null) {
                this.gdp.c(buM);
            } else {
                this.gdp.setRefreshing(false);
            }
        }
    }

    private h.e buM() {
        int i;
        String feedText;
        if (this.gjM && this.gdp != null && this.gdp.anQ()) {
            int i2 = this.gjI;
            if (this.gbD) {
                com.baidu.tieba.q.c.cni().b(this.gjS, false);
                if (lj(false)) {
                    i = 3;
                } else {
                    i = this.gjN > 0 ? 2 : 0;
                }
            } else if (this.gbD || this.gjI != 0) {
                return null;
            } else {
                i2 = 0;
                i = 2;
            }
            if (this.giN != null) {
                this.gjJ.blQ();
            }
            if (this.giN != null && this.giN.getCurrentTabType() != 1) {
                this.gjJ.hideTip();
                return null;
            } else if (!this.gjQ) {
                this.gjJ.hideTip();
                return null;
            } else {
                this.gjH = i;
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
                    this.fyT = 1000;
                } else {
                    this.fyT = 0;
                }
                return new h.e(feedText, this.fyT);
            }
        }
        return null;
    }

    public void kX(boolean z) {
        if (z) {
            this.giZ.notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        if (this.fwT != null) {
            this.fwT.destroy();
        }
        if (this.gjJ != null) {
            this.gjJ.onDestroy();
        }
        if (this.gjE != null) {
            this.gjE.onDestroy();
        }
        if (this.fzi != null) {
            this.fzi.removeCallbacks(this.gka);
        }
        MessageManager.getInstance().unRegisterTask(2016323);
        MessageManager.getInstance().unRegisterListener(this.fwb);
    }

    public void onPause() {
        c.d(this.fzi);
        te(this.gjZ);
        if (this.gjL != null) {
            this.gjL.awD();
        }
    }

    private void agx() {
        if (this.gjF != null) {
            this.gjF.M((this.gjG == null || this.gjG.thread_list == null || buP()) ? 0 : this.gjG.thread_list.size(), li(true), 0);
        }
    }

    public int li(boolean z) {
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
                if (!(mVar instanceof com.baidu.tieba.homepage.personalize.data.a) || mVar.getType() == AdvertAppInfo.bWi) {
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
                if ((mVar2 instanceof com.baidu.tieba.homepage.personalize.data.a) && mVar2.getType() != AdvertAppInfo.bWi) {
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
        this.gdy = true;
        if (dataRes != null) {
            if (a(false, true, true, dataRes) && !buP()) {
                if (this.gjF != null) {
                    this.gjF.onSuccess();
                    return;
                }
                return;
            }
            agx();
            return;
        }
        agx();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.util.Set] */
    private void i(List<com.baidu.adp.widget.ListView.m> list, int i) {
        AdvertAppInfo baL;
        AdvertAppInfo baL2;
        if (!com.baidu.tbadk.core.util.v.isEmpty(list)) {
            Set<com.baidu.adp.widget.ListView.m> CO = com.baidu.tieba.recapp.report.a.CO("NEWINDEX");
            HashSet hashSet = CO == null ? new HashSet() : CO;
            HashSet hashSet2 = new HashSet();
            for (com.baidu.adp.widget.ListView.m mVar : list) {
                if (mVar != null) {
                    for (com.baidu.adp.widget.ListView.m mVar2 : hashSet) {
                        if ((mVar instanceof com.baidu.tieba.card.data.d) && (baL2 = ((com.baidu.tieba.card.data.d) mVar).baL()) != null && mVar2 != null && (mVar2 instanceof AdvertAppInfo) && mVar2.hashCode() == baL2.hashCode()) {
                            baL2.advertAppContext = ((AdvertAppInfo) mVar2).advertAppContext;
                        }
                    }
                    if (mVar != null && (mVar instanceof com.baidu.tieba.card.data.d) && (baL = ((com.baidu.tieba.card.data.d) mVar).baL()) != null && baL.advertAppContext == null) {
                        baL.advertAppContext = new com.baidu.tbadk.core.data.c();
                        baL.advertAppContext.page = "NEWINDEX";
                        baL.advertAppContext.pn = this.mPn;
                        baL.advertAppContext.extensionInfo = baL.extensionInfo;
                        baL.advertAppContext.Aj = false;
                        hashSet2.add(baL);
                    }
                }
            }
            hashSet.addAll(hashSet2);
            com.baidu.tieba.recapp.report.a.e("NEWINDEX", hashSet);
            if (hashSet2.size() > 0) {
                com.baidu.tieba.q.c.cni().b(this.gjS, com.baidu.tieba.q.a.b(PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE, "common_fill", true, hashSet2.size()));
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
        if (this.gjU == 1) {
            if (z2 && (dataRes.thread_list.size() >= 6 || buP())) {
                buO();
                this.gjG = null;
            }
        } else if (z2 && buP()) {
            this.gjG = null;
        }
        int size = z2 ? 0 : this.mDataList.size();
        DataRes.Builder builder = new DataRes.Builder(dataRes);
        this.mDataList.clear();
        com.baidu.tieba.homepage.personalize.model.c a2 = this.gjK.a(z, this.gjG, builder, z2 ? 0 : 1);
        if (a2 == null) {
            list = null;
        } else {
            List<com.baidu.adp.widget.ListView.m> list2 = a2.daV;
            this.gjI = a2.gma;
            list = list2;
        }
        if (list != null) {
            this.mDataList.addAll(list);
            i(list, size);
            a(z2 ? 0 : 1, list, size);
            if (this.gjO) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
            }
        }
        if (this.gjG == null) {
            this.gjG = builder;
            this.gjE.cR(this.gjG.thread_list);
        }
        if (this.mDataList.size() == 0) {
            z4 = false;
        } else {
            if (z2) {
                if (dataRes.live_answer != null) {
                    this.gjP = new g();
                    this.gjP.a(dataRes.live_answer);
                    this.gjG.live_answer = dataRes.live_answer;
                } else if (z) {
                    this.gjP = null;
                    this.gjG.live_answer = null;
                }
                this.gjR = dataRes.float_info;
                this.gjG.float_info = dataRes.float_info;
            }
            long j = com.baidu.tbadk.core.sharedPref.b.alP().getLong("key_maintab_banner_close_time", 0L);
            if (this.gjP != null && !com.baidu.tbadk.core.util.aq.isTaday(j)) {
                this.mDataList.add(0, this.gjP);
            }
            LinkedList linkedList = new LinkedList(this.mDataList);
            this.giZ.setFromCDN(dataRes.is_new_url.intValue() == 1);
            this.giZ.aY(linkedList);
            z4 = true;
            if (this.fwT != null && this.giI) {
                this.fwT.c(this.fwh, this.duA, this.fwM, true);
            }
        }
        com.baidu.tieba.homepage.framework.a.btt().n(System.currentTimeMillis() - currentTimeMillis, 1);
        long sK = com.baidu.tieba.homepage.framework.a.btt().sK(1);
        if (sK > 0) {
            com.baidu.tieba.homepage.framework.a.btt().o(System.currentTimeMillis() - sK, 1);
            com.baidu.tieba.homepage.framework.a.btt().p(0L, 1);
        }
        if (dataRes.anti != null && dataRes.anti.block_pop_info != null) {
            com.baidu.tieba.ueg.d.d(dataRes.anti.block_pop_info);
        }
        aw awVar = new aw();
        awVar.a(dataRes.recom_post_topic);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_REFRESH_TOPIC_TIP, awVar));
        return z4;
    }

    private void buN() {
        if (com.baidu.tbadk.core.util.v.getCount(this.mDataList) >= this.gjK.bvi() - 40) {
            com.baidu.tieba.homepage.personalize.model.c a2 = this.gjK.a(true, this.gjG, (DataRes.Builder) null, 1);
            List<com.baidu.adp.widget.ListView.m> list = a2 != null ? a2.daV : null;
            if (list != null) {
                this.mDataList.clear();
                this.mDataList.addAll(list);
                this.giZ.aY(new LinkedList(this.mDataList));
            }
        }
    }

    private void agy() {
        this.gdy = true;
        com.baidu.tbadk.util.z.a(new y<DataRes>() { // from class: com.baidu.tieba.homepage.personalize.e.24
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.y
            /* renamed from: buU */
            public DataRes doInBackground() {
                com.baidu.adp.lib.cache.l<byte[]> bJ = com.baidu.tbadk.core.d.a.akL().bJ("tb.rec_frs_update", TbadkCoreApplication.getCurrentAccount());
                if (bJ == null) {
                    return null;
                }
                byte[] bArr = bJ.get("0");
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
        }, new com.baidu.tbadk.util.j<DataRes>() { // from class: com.baidu.tieba.homepage.personalize.e.25
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.j
            /* renamed from: b */
            public void onReturnDataInUI(DataRes dataRes) {
                e.this.a(dataRes);
            }
        });
    }

    private void beF() {
        if (this.gjG != null) {
            DataRes.Builder builder = new DataRes.Builder(this.gjG.build(true));
            if (builder.thread_list != null && builder.thread_list.size() > 30) {
                builder.thread_list = builder.thread_list.subList(0, 30);
            }
            a(builder, builder.thread_list != null ? builder.thread_list.size() : 0);
            a(builder);
        }
    }

    private void buO() {
        if (this.gjG != null) {
            final DataRes.Builder builder = new DataRes.Builder(this.gjG.build(true));
            if (builder.thread_list != null && builder.thread_list.size() > 50) {
                builder.thread_list = builder.thread_list.subList(0, 50);
            }
            a(builder, builder.thread_list != null ? builder.thread_list.size() : 0);
            com.baidu.tbadk.util.z.a(new y<Object>() { // from class: com.baidu.tieba.homepage.personalize.e.2
                @Override // com.baidu.tbadk.util.y
                public Object doInBackground() {
                    DataRes.Builder builder2 = new DataRes.Builder(builder.build(true));
                    e.this.gjE.cS(builder2.thread_list);
                    try {
                        com.baidu.tbadk.core.d.a.akL().bJ("tb.rec_old_data", TbadkCoreApplication.getCurrentAccount()).setForever("0", builder2.build(true).toByteArray());
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
                        int i3 = com.baidu.adp.lib.g.b.toInt(next.pos_name, -1);
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
    public void xa(String str) {
        if (!TextUtils.isEmpty(str) && this.gjG != null && this.gjG.banner_list != null && this.gjG.banner_list.app != null && this.gjG.banner_list.app.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (App app : this.gjG.banner_list.app) {
                if (app != null && str.equals(app.id)) {
                    arrayList.add(app);
                }
            }
            BannerList.Builder builder = new BannerList.Builder(this.gjG.banner_list);
            if (builder.app != null) {
                builder.app.removeAll(arrayList);
            }
            this.gjG.banner_list = builder.build(false);
            DataRes.Builder builder2 = new DataRes.Builder(this.gjG.build(true));
            builder2.banner_list = builder.build(true);
            a(builder2);
        }
    }

    private void a(final DataRes.Builder builder) {
        com.baidu.tbadk.util.z.a(new y<Object>() { // from class: com.baidu.tieba.homepage.personalize.e.3
            @Override // com.baidu.tbadk.util.y
            public Object doInBackground() {
                DataRes.Builder builder2 = new DataRes.Builder(builder.build(true));
                e.this.gjE.cS(builder2.thread_list);
                try {
                    com.baidu.tbadk.core.d.a.akL().bJ("tb.rec_frs_update", TbadkCoreApplication.getCurrentAccount()).setForever("0", builder2.build(true).toByteArray());
                    return null;
                } catch (Exception e) {
                    BdLog.e(e);
                    return null;
                }
            }
        }, null);
    }

    private boolean buP() {
        return lj(true);
    }

    private boolean lj(boolean z) {
        long j = com.baidu.tbadk.core.sharedPref.b.alP().getLong(SharedPrefConfig.RECOMMEND_FRS_REFRESH_TIME, 0L);
        return j == 0 ? z : Math.abs(System.currentTimeMillis() - j) > this.gjD;
    }

    public void a(a aVar) {
        this.gjF = aVar;
    }

    private boolean isLoading() {
        return this.mIsLoading;
    }

    private void setIsLoading(boolean z) {
        this.mIsLoading = z;
    }

    public void buD() {
        boolean z = true;
        com.baidu.tbadk.coreExtra.data.b activityPrizeData = TbadkCoreApplication.getInst().getActivityPrizeData();
        if (activityPrizeData.isSwitchTurn() && !StringUtils.isNull(activityPrizeData.getFeedText())) {
            String currentDay = UtilHelper.getCurrentDay();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            String str = "";
            if (!StringUtils.isNull(currentAccount)) {
                String string = com.baidu.tbadk.core.sharedPref.b.alP().getString(SharedPrefConfig.ACTIVITY_PRIZE_FEED_TEXT_TIME, "");
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
                    bD(4, 0);
                    com.baidu.tbadk.core.sharedPref.b.alP().putString(SharedPrefConfig.ACTIVITY_PRIZE_FEED_TEXT_TIME, str);
                }
            }
        }
    }

    private void bD(int i, int i2) {
        if (this.giN != null) {
            this.gjJ.blQ();
        }
        if (this.giN != null && this.giN.getCurrentTabType() != 1) {
            this.gjJ.hideTip();
        } else if (!this.gjQ) {
            this.gjJ.hideTip();
        } else {
            this.gjH = i;
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
                    this.fyT = 3000;
                } else {
                    this.fyT = 2000;
                }
                this.gjT.cpn = str;
                this.gjT.fyL = this.fyT;
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 49;
                FrameLayout frameLayout = this.giN.getFrameLayout();
                frameLayout.removeView(this.gjT);
                frameLayout.addView(this.gjT, layoutParams);
                this.gjT.blO();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(Long l) {
        if (this.gjG != null && this.gjG.thread_list != null) {
            List<ThreadInfo> list = this.gjG.thread_list;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                ThreadInfo threadInfo = list.get(i);
                if (threadInfo.tid.equals(l) && threadInfo.top_agree_post != null) {
                    ThreadInfo.Builder builder = new ThreadInfo.Builder(threadInfo);
                    builder.top_agree_post = null;
                    list.set(i, builder.build(true));
                    beF();
                    a(false, true, false, this.gjG.build(true));
                    return;
                }
            }
        }
    }

    public void l(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.gjS = bdUniqueId;
            if (this.fLO != null) {
                this.fLO.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.fLO);
            }
            if (this.gjW != null) {
                this.gjW.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.gjW);
            }
            this.cji.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.cji);
            this.gjX.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.gjX);
            this.fNW.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.fNW);
            this.fNX.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.fNX);
            this.fMd.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.fMd);
            if (this.fwT != null) {
                this.fwT.setUniqueId(bdUniqueId);
            }
            this.gjE.j(bdUniqueId);
            this.gkc.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.gkc);
            this.fwa.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.fwa);
            this.gkd.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.gkd);
        }
    }

    public void buQ() {
        this.fut = new com.baidu.tieba.tbadkCore.data.f("new_index", null);
        this.fut.cnP();
    }

    public void a(int i, List<com.baidu.adp.widget.ListView.m> list, int i2) {
        int i3;
        int i4;
        if (this.fut != null) {
            if (i == 0) {
                this.fut.cnP();
            }
            if (list != null && !list.isEmpty()) {
                int[] iArr = com.baidu.tieba.tbadkCore.data.f.jgX;
                int i5 = 0;
                int i6 = 0;
                int i7 = 0;
                while (i7 < list.size() && i6 < iArr.length && (i3 = iArr[i6]) >= 0) {
                    if (list.get(i7) instanceof com.baidu.tieba.card.data.c) {
                        i4 = i5 + 1;
                        if (i4 == i3 - 1) {
                            if (i2 < i7 + 1) {
                                this.fut.cp(i3, i7 + 1);
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

    public void td(int i) {
        if ((this.fut != null ? this.fut.zN(i) : -1) >= 0 && this.fzi != null && this.fzi.getData() != null && this.fzi.getData().size() > i) {
            this.fut.zO(i);
        }
    }

    public m bkH() {
        return this.fwT;
    }

    public void ld(boolean z) {
        this.giI = z;
    }

    public void te(final int i) {
        com.baidu.tbadk.util.z.a(new y<Object>() { // from class: com.baidu.tieba.homepage.personalize.e.7
            @Override // com.baidu.tbadk.util.y
            public Object doInBackground() {
                com.baidu.adp.lib.cache.l<String> bK = com.baidu.tbadk.core.d.a.akL().bK(e.this.gjY, TbadkCoreApplication.getCurrentAccount());
                if (bK != null) {
                    bK.set(e.this.gjY, Integer.toString(i), 43200000L);
                    return null;
                }
                return null;
            }
        }, null);
    }

    public void a(final d dVar) {
        com.baidu.tbadk.util.z.a(new y<String>() { // from class: com.baidu.tieba.homepage.personalize.e.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.y
            /* renamed from: buT */
            public String doInBackground() {
                com.baidu.adp.lib.cache.l<String> bK = com.baidu.tbadk.core.d.a.akL().bK(e.this.gjY, TbadkCoreApplication.getCurrentAccount());
                if (bK != null) {
                    return bK.get(e.this.gjY);
                }
                return null;
            }
        }, new com.baidu.tbadk.util.j<String>() { // from class: com.baidu.tieba.homepage.personalize.e.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.j
            /* renamed from: xb */
            public void onReturnDataInUI(String str) {
                if (dVar != null) {
                    dVar.sL(com.baidu.adp.lib.g.b.toInt(str, 0));
                }
            }
        });
    }

    public void buE() {
        c.e(this.fzi);
    }

    public void buR() {
        a(this.gkb);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(CustomResponsedMessage<?> customResponsedMessage) {
        boolean z;
        String str;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.gjG != null && com.baidu.tbadk.core.util.v.getCount(this.gjG.thread_list) != 0 && com.baidu.tbadk.core.util.v.getCount(this.mDataList) != 0) {
            JSONObject jSONObject = (JSONObject) customResponsedMessage.getData();
            String optString = jSONObject.optString("tid");
            if (StringUtils.isNull(optString)) {
                String optString2 = jSONObject.optString("liveid");
                if (this.fzi != null && !TextUtils.isEmpty(optString2)) {
                    int i = 0;
                    while (true) {
                        if (i >= this.fzi.getCount()) {
                            str = optString;
                            break;
                        }
                        com.baidu.adp.widget.ListView.m item = this.fzi.getItem(i);
                        if (item instanceof com.baidu.tieba.card.data.j) {
                            com.baidu.tieba.card.data.j jVar = (com.baidu.tieba.card.data.j) item;
                            if (jVar.agG() != null && jVar.agG().aiX() != null && optString2.equals(String.valueOf(jVar.agG().aiX().live_id))) {
                                str = jVar.agG().getTid();
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
                    if (cVar.agG() != null && cVar.agG().getTid() != null) {
                        if (cVar.agG().getTid().equals(optString)) {
                            it.remove();
                            z = true;
                            z2 = z;
                        } else if (z2) {
                            com.baidu.tieba.homepage.personalize.model.b.cU(this.mDataList);
                            break;
                        }
                    }
                }
                z = z2;
                z2 = z;
            }
            if (this.gjG != null && this.gjG.thread_list != null) {
                long j = com.baidu.adp.lib.g.b.toLong(optString, 0L);
                int i2 = 0;
                while (true) {
                    if (i2 < this.gjG.thread_list.size()) {
                        ThreadInfo threadInfo = this.gjG.thread_list.get(i2);
                        if (threadInfo == null || threadInfo.tid == null || threadInfo.tid.longValue() != j) {
                            i2++;
                        } else {
                            this.gjG.thread_list.remove(i2);
                            beF();
                            com.baidu.tieba.homepage.personalize.b.d.a(threadInfo.tid.longValue(), i2, this.gjG.thread_list, this.mDataList);
                            break;
                        }
                    } else {
                        break;
                    }
                }
                if (this.fzi != null) {
                    List<Integer> b = b(optString, this.fzi);
                    int intValue = b.get(0).intValue();
                    int intValue2 = b.get(1).intValue();
                    if (intValue != -1 && intValue2 != -1) {
                        this.fzi.j(intValue, intValue2);
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
                    if (cVar.agG() != null && cVar.agG().getTid().equals(str)) {
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
    public void h(String str, List<com.baidu.adp.widget.ListView.m> list) {
        AdvertAppInfo advertAppInfo;
        if (list != null && list.size() > 0 && !TextUtils.isEmpty(str)) {
            Iterator<com.baidu.adp.widget.ListView.m> it = list.iterator();
            AdvertAppInfo advertAppInfo2 = null;
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.m next = it.next();
                if (next instanceof com.baidu.tieba.homepage.personalize.data.a) {
                    advertAppInfo = ((com.baidu.tieba.homepage.personalize.data.a) next).baL();
                } else {
                    if (next instanceof ad) {
                        ad adVar = (ad) next;
                        if (adVar.ahj() instanceof AdvertAppInfo.ILegoAdvert) {
                            advertAppInfo = ((AdvertAppInfo.ILegoAdvert) adVar.ahj()).getAdvertAppInfo();
                        }
                    }
                    advertAppInfo = advertAppInfo2;
                }
                if (advertAppInfo != null && str.equals(advertAppInfo.bWt)) {
                    it.remove();
                    advertAppInfo = null;
                }
                advertAppInfo2 = advertAppInfo;
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (this.gjT != null) {
            this.gjT.onChangeSkinType(i);
        }
    }

    public FloatInfo buS() {
        return this.gjR;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public z buq() {
        if (this.fwT == null || this.fwT.cck() == null || !(this.fwT.cck().getTag() instanceof z)) {
            return null;
        }
        return (z) this.fwT.cck().getTag();
    }
}
