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
    private View.OnTouchListener cCE;
    private v cPo;
    private com.baidu.tieba.f.a fTs;
    private com.baidu.tieba.tbadkCore.data.f fvk;
    private m fxK;
    private final BdTypeRecyclerView fzZ;
    private boolean gcu;
    private final BigdaySwipeRefreshLayout geg;
    private ScrollFragmentTabHost gjE;
    private final w gjQ;
    private aq gkA;
    private final com.baidu.tieba.homepage.personalize.model.a gkB;
    private int gkE;
    private g gkG;
    private BdUniqueId gkJ;
    private SmartBubbleAnimatedView gkK;
    private int gkL;
    private Runnable gkR;
    private final long gku;
    private final b gkv;
    private DataRes.Builder gkx;
    private final TbPageContext<?> mPageContext;
    private a gkw = null;
    private final List<com.baidu.adp.widget.ListView.m> mDataList = new LinkedList();
    private int mPn = 1;
    private boolean mIsLoading = false;
    private boolean geq = false;
    private int gky = 2;
    private int gkz = 0;
    private TextView mTipView = null;
    private int fzK = 2000;
    private com.baidu.tbadk.p.c gkC = null;
    private boolean fxD = false;
    private int fwY = 0;
    private int dvr = 0;
    private boolean mIsBackground = false;
    private boolean gjz = true;
    private boolean gkD = false;
    private boolean gkF = false;
    private boolean gkH = true;
    private FloatInfo gkI = null;
    private a.C0044a fvD = new a.C0044a(2);
    private RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.e.12
        private int gkZ = -1;
        private int gev = 0;
        private boolean gla = false;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (e.this.gkC == null) {
                e.this.gkC = new com.baidu.tbadk.p.c();
                e.this.gkC.setSubType(1005);
                e.this.gkC.pageType = 1;
            }
            if (e.this.cPo != null && !e.this.mIsBackground) {
                e.this.cPo.g(recyclerView, i);
            }
            if (i == 0) {
                c.d(e.this.fzZ);
                e.this.gkC.awE();
                t.baw().gF(true);
                com.baidu.tieba.a.d.aDe().bO("page_recommend", "show_");
                com.baidu.tieba.q.c.cnk().b(e.this.gkJ, false);
                this.gla = false;
                if (e.this.fxK != null && e.this.gjz) {
                    e.this.fxK.a(e.this.fwY, e.this.dvr, e.this.fxD, 1);
                    return;
                }
                return;
            }
            e.this.gkC.awD();
            if (i == 1) {
                if (e.this.gkA != null) {
                    e.this.gkA.hideTip();
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
            if (this.gev > i) {
                this.gla = true;
            }
            if (e.this.cPo != null && !e.this.mIsBackground) {
                e.this.cPo.onScroll(this.gev, i);
            }
            this.gev = i;
            int i3 = (i + i2) - 1;
            if (!this.gla && this.gkZ != i3) {
                this.gkZ = i3;
                e.this.te(this.gkZ);
            }
            if (this.gla && this.gkZ != i) {
                this.gkZ = i;
                e.this.te(this.gkZ);
            }
            e.this.gkQ = i;
            e.this.fwY = i;
            e.this.dvr = (i + i2) - 1;
            z bus = e.this.bus();
            if (bus != null && bus.lV() != null) {
                bus.lV().b(e.this.fvD);
            }
        }
    };
    private View.OnTouchListener cAp = new View.OnTouchListener() { // from class: com.baidu.tieba.homepage.personalize.e.19
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (e.this.cCE != null) {
                e.this.cCE.onTouch(view, motionEvent);
            }
            if (e.this.fTs != null) {
                e.this.fTs.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private a.InterfaceC0405a eYb = new a.InterfaceC0405a() { // from class: com.baidu.tieba.homepage.personalize.e.20
        @Override // com.baidu.tieba.f.a.InterfaceC0405a
        public void v(int i, int i2) {
            e.this.fxD = true;
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0405a
        public void w(int i, int i2) {
            e.this.fxD = false;
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0405a
        public void x(int i, int i2) {
        }
    };
    private View.OnClickListener gkM = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.e.21
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (e.this.gkA != null) {
                e.this.gkA.hideTip();
            }
        }
    };
    private final CustomMessageListener gkN = new CustomMessageListener(CmdConfigCustom.CMD_RELOAD_HP_PERSONALIZED) { // from class: com.baidu.tieba.homepage.personalize.e.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (e.this.fzZ != null) {
                e.this.fxK.bur();
                e.this.gjz = false;
                e.this.geg.setRefreshing(true);
            }
        }
    };
    private CustomMessageListener fMF = new CustomMessageListener(CmdConfigCustom.PB_ACTION_PRAISE) { // from class: com.baidu.tieba.homepage.personalize.e.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            bh bhVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bh) && e.this.gkx != null && com.baidu.tbadk.core.util.v.getCount(e.this.gkx.thread_list) != 0 && (bhVar = (bh) customResponsedMessage.getData()) != null && bhVar.ais() != null && bhVar.getId() != null && com.baidu.tbadk.core.util.v.getCount(e.this.gkx.thread_list) != 0) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < e.this.gkx.thread_list.size()) {
                        ThreadInfo threadInfo = e.this.gkx.thread_list.get(i2);
                        if (threadInfo == null || threadInfo.id.longValue() != com.baidu.adp.lib.g.b.toLong(bhVar.getId(), -1L)) {
                            i = i2 + 1;
                        } else {
                            ThreadInfo.Builder builder = new ThreadInfo.Builder(threadInfo);
                            Zan.Builder builder2 = new Zan.Builder(builder.zan);
                            builder2.num = Integer.valueOf((int) bhVar.ais().getNum());
                            builder.zan = builder2.build(true);
                            e.this.gkx.thread_list.set(i2, builder.build(true));
                            return;
                        }
                    } else {
                        return;
                    }
                }
            }
        }
    };
    private CustomMessageListener gkO = new CustomMessageListener(CmdConfigCustom.CMD_LIVE_VIDEO_CLOSED_QUERY_RESPONSED) { // from class: com.baidu.tieba.homepage.personalize.e.5
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
                        if ((originData.get(i2) instanceof bh) && (bhVar = (bh) originData.get(i2)) != null && bhVar.aiZ() != null && ids.contains(Long.valueOf(bhVar.aiZ().live_id))) {
                            e.this.mDataList.remove(bhVar);
                        }
                        i = i2 + 1;
                    }
                    if (e.this.gjQ != null) {
                        e.this.gjQ.aY(new ArrayList(e.this.mDataList));
                    }
                }
            }
        }
    };
    private CustomMessageListener cjZ = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.homepage.personalize.e.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int intValue;
            if ((customResponsedMessage instanceof UpdateAttentionMessage) && e.this.gkx != null && !com.baidu.tbadk.core.util.v.isEmpty(e.this.gkx.thread_list)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid)) {
                    for (int i = 0; i < e.this.gkx.thread_list.size(); i++) {
                        ThreadInfo threadInfo = e.this.gkx.thread_list.get(i);
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
                            e.this.gkx.thread_list.set(i, builder.build(true));
                            return;
                        }
                    }
                }
            }
        }
    };
    private String gkP = "lastReadReadPositionKey";
    private int gkQ = 0;
    private d gkS = new d() { // from class: com.baidu.tieba.homepage.personalize.e.8
        @Override // com.baidu.tieba.homepage.personalize.d
        public void sM(final int i) {
            if (e.this.gkR == null) {
                e.this.gkR = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.e.8.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (e.this.fzZ.getHandler() != null) {
                            e.this.fzZ.requestFocusFromTouch();
                            if (i <= e.this.fzZ.getCount() - 1) {
                                e.this.fzZ.setSelection(i);
                            }
                        }
                    }
                };
            }
            e.this.fzZ.removeCallbacks(e.this.gkR);
            e.this.fzZ.post(e.this.gkR);
        }
    };
    private CustomMessageListener gkT = new CustomMessageListener(2016569) { // from class: com.baidu.tieba.homepage.personalize.e.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && e.this.gkG != null) {
                e.this.mDataList.remove(e.this.gkG);
                e.this.gjQ.aY(new ArrayList(e.this.mDataList));
                com.baidu.tbadk.core.sharedPref.b.alR().putLong("key_maintab_banner_close_time", System.currentTimeMillis());
            }
        }
    };
    private CustomMessageListener fON = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.homepage.personalize.e.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.h(customResponsedMessage);
            if (e.this.fxK != null && e.this.gjz) {
                e.this.fxK.c(e.this.fwY, e.this.dvr, e.this.fxD, true);
            }
        }
    };
    private CustomMessageListener fOO = new CustomMessageListener(CmdConfigCustom.CMD_THREAD_NOT_EXIST_WHEN_ENTER_PB) { // from class: com.baidu.tieba.homepage.personalize.e.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.h(customResponsedMessage);
        }
    };
    private CustomMessageListener fMU = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.homepage.personalize.e.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && e.this.gkx != null && com.baidu.tbadk.core.util.v.getCount(e.this.gkx.thread_list) != 0) {
                String str = (String) customResponsedMessage.getData();
                e.this.h(str, e.this.mDataList);
                e.this.xa(str);
                if (e.this.gjQ != null) {
                    e.this.gjQ.aY(new ArrayList(e.this.mDataList));
                }
                if (e.this.fxK != null && e.this.gjz) {
                    e.this.fxK.c(e.this.fwY, e.this.dvr, e.this.fxD, true);
                }
            }
        }
    };
    private CustomMessageListener fwR = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.homepage.personalize.e.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            z bus;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent)) {
                KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24 && (bus = e.this.bus()) != null && bus.lV() != null) {
                    bus.lV().b(new a.C0044a(3));
                }
            }
        }
    };
    private com.baidu.adp.framework.listener.a gkU = new com.baidu.adp.framework.listener.a(1003065, CmdConfigSocket.CMD_TOPIC_BLESS) { // from class: com.baidu.tieba.homepage.personalize.e.17
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
                        if ((mVar instanceof com.baidu.tieba.homepage.topic.topictab.b.a) && (bVar = ((com.baidu.tieba.homepage.topic.topictab.b.a) mVar).gpj) != null && longValue == bVar.pkId) {
                            bVar.userPkId = j2;
                            return;
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener fwS = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.homepage.personalize.e.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int[] imageWidthAndHeight;
            List<com.baidu.adp.widget.ListView.m> dataList = e.this.gjQ.getDataList();
            if (!com.baidu.tbadk.core.util.v.isEmpty(dataList)) {
                for (com.baidu.adp.widget.ListView.m mVar : dataList) {
                    if (mVar instanceof k) {
                        k kVar = (k) mVar;
                        if (kVar.cbr != 0 && kVar.cbq != null) {
                            if ((TbSingleton.getInstance().getHomePageStyleAbTest() & 4) != 0) {
                                imageWidthAndHeight = kVar.cbq.aky();
                            } else {
                                imageWidthAndHeight = kVar.cbq.getImageWidthAndHeight();
                            }
                            kVar.cbr = imageWidthAndHeight[0];
                            kVar.cbs = imageWidthAndHeight[1];
                        }
                    }
                }
            }
            com.baidu.adp.lib.g.e.fZ().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.personalize.e.18.1
                @Override // java.lang.Runnable
                public void run() {
                    e.this.gjQ.notifyDataSetChanged();
                    if (!e.this.mIsBackground && e.this.gjz) {
                        e.this.fxK.c(e.this.fwY, e.this.dvr, e.this.fxD, true);
                    }
                }
            }, 500L);
        }
    };

    /* loaded from: classes4.dex */
    public interface a {
        void M(int i, int i2, int i3);

        void buI();

        void onError(int i, String str);

        void onSuccess();

        void v(int i, int i2, int i3, int i4);
    }

    public void lh(boolean z) {
        this.gkH = z;
        if (this.gkA != null && !z) {
            this.gkA.hideTip();
        }
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.gjE = scrollFragmentTabHost;
        if (this.gjE != null) {
            this.gjE.setOnTabSelectedListener(new ScrollFragmentTabHost.b() { // from class: com.baidu.tieba.homepage.personalize.e.1
                @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.b
                public void sX(int i) {
                    if (e.this.gjE.sW(i) != 1 && e.this.gkA != null) {
                        e.this.gkA.hideTip();
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
        if (this.gjE != null) {
            this.gjE.jT(z);
        }
        if (this.fxK != null) {
            this.fxK.mY(!z);
            z bus = bus();
            if (bus != null && bus.lV() != null) {
                z2 = bus.lV().b(new a.C0044a(8, Boolean.valueOf(z)));
            }
            if (!z2) {
                if (z) {
                    this.fxK.bur();
                } else if (this.gjz) {
                    this.fxK.c(this.fwY, this.dvr, this.fxD, true);
                }
            }
        }
    }

    public e(TbPageContext<?> tbPageContext, BdTypeRecyclerView bdTypeRecyclerView, w wVar, BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout) {
        this.gkL = 0;
        this.mPageContext = tbPageContext;
        this.gkL = com.baidu.tbadk.core.sharedPref.b.alR().getInt("key_personalized_refresh_type", 0);
        this.geg = bigdaySwipeRefreshLayout;
        this.fzZ = bdTypeRecyclerView;
        this.fzZ.setOnTouchListener(this.cAp);
        this.fTs = new com.baidu.tieba.f.a();
        this.fTs.a(this.eYb);
        this.gjQ = wVar;
        this.gkB = new com.baidu.tieba.homepage.personalize.model.a();
        this.gku = com.baidu.tbadk.core.sharedPref.b.alR().getLong("recommend_frs_cache_time", 3600L) * 1000;
        bdTypeRecyclerView.setOnScrollListener(this.mOnScrollListener);
        this.gkA = new aq();
        buS();
        this.fxK = new m(this.mPageContext, this.fzZ);
        this.fxK.xG(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.gkv = new b(this.mDataList, this.gjQ);
        this.gkK = new SmartBubbleAnimatedView(tbPageContext.getContext());
        this.gkK.setLayoutParams(new FrameLayout.LayoutParams(-1, l.getDimens(tbPageContext.getContext(), R.dimen.tbds83)));
        buJ();
        this.fwS.setTag(this.mPageContext.getUniqueId());
        MessageManager.getInstance().registerListener(this.fwS);
    }

    private void buJ() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2016323, new CustomMessageTask.CustomRunnable<Boolean>() { // from class: com.baidu.tieba.homepage.personalize.e.23
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Boolean> customMessage) {
                z bus = e.this.bus();
                return (bus == null || bus.lV() == null) ? new CustomResponsedMessage<>(2016323, false) : new CustomResponsedMessage<>(2016323, Boolean.valueOf(bus.lV().b(new a.C0044a(6))));
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private boolean buK() {
        return com.baidu.tbadk.core.sharedPref.b.alR().getBoolean(buM(), true);
    }

    private void buL() {
        com.baidu.tbadk.core.sharedPref.b.alR().putBoolean(buM(), false);
    }

    private String buM() {
        return "key_rec_pfirst_load_" + TbadkCoreApplication.getCurrentAccount() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + TbConfig.getVersion();
    }

    public void setRecommendFrsNavigationAnimDispatcher(com.baidu.tbadk.util.w wVar) {
        if (wVar != null) {
            this.cPo = wVar.axN();
            this.cCE = wVar.axO();
        }
    }

    public void showFloatingView() {
        if (this.cPo != null) {
            this.cPo.fE(true);
        }
    }

    public void update() {
        com.baidu.tieba.homepage.framework.a.btv().p(System.currentTimeMillis(), 1);
        this.mPn = 1;
        this.gkF = true;
        if (this.mDataList.size() == 0 && !buK()) {
            if (!this.geq) {
                agA();
                return;
            }
            return;
        }
        agz();
    }

    public void bE(int i, int i2) {
        bh bhVar;
        if (!com.baidu.tbadk.core.util.v.isEmpty(this.mDataList) && this.mDataList.size() > i) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            while (i < this.mDataList.size() && i <= i2) {
                if (this.mDataList.get(i).getType().getId() == bh.cbJ.getId() && (bhVar = (bh) this.mDataList.get(i)) != null && bhVar.aiZ() != null) {
                    arrayList.add(Long.valueOf(bhVar.aiZ().live_id));
                    arrayList2.add(bhVar);
                }
                i++;
            }
            if (!com.baidu.tbadk.core.util.v.isEmpty(arrayList)) {
                MessageManager.getInstance().sendMessage(new LiveRoomClosedQueryMessage(arrayList, arrayList2));
            }
        }
    }

    public void buN() {
        if (this.fxK != null && !this.mIsBackground && this.gjz) {
            this.fxK.c(this.fwY, this.dvr, this.fxD, true);
        }
        if (this.gkD) {
            if (this.geg != null && !this.geg.anS()) {
                if (this.gcu) {
                    com.baidu.tieba.q.c.cnk().b(this.gkJ, false);
                    if (lj(false)) {
                        bF(3, this.gkz);
                    } else if (this.gkE > 0) {
                        bF(2, this.gkz);
                    }
                } else if (!this.gcu && this.gkz == 0) {
                    bF(2, 0);
                }
            }
            com.baidu.tbadk.core.sharedPref.b.alR().putLong(SharedPrefConfig.RECOMMEND_FRS_REFRESH_TIME, System.currentTimeMillis());
            this.gkD = false;
            this.gcu = false;
            this.gkE = 0;
            if (this.gkF) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
            }
            this.gkF = false;
        }
    }

    public void aIW() {
        if (isLoading()) {
            com.baidu.tieba.homepage.framework.a.btv().p(0L, 1);
        } else if (this.gkw != null) {
            buP();
            this.mPn++;
            setIsLoading(true);
            this.gkw.v(this.mPn, (this.gkx == null || this.gkx.thread_list == null) ? 0 : this.gkx.thread_list.size(), li(false), 0);
        }
    }

    public void a(boolean z, boolean z2, DataRes dataRes, int i, String str) {
        int size = (this.gkx == null || this.gkx.thread_list == null) ? 0 : this.gkx.thread_list.size();
        if (!z && i == 0 && dataRes != null && com.baidu.tbadk.core.util.v.isEmpty(dataRes.thread_list)) {
            if (this.gkw != null) {
                this.gkw.buI();
            }
            setIsLoading(false);
            if (this.geg != null) {
                this.geg.setRefreshing(false);
                return;
            }
            return;
        }
        if (i != 0 || dataRes == null || !a(true, z, z2, dataRes)) {
            this.gkD = false;
            if (this.mDataList.size() > 0) {
                if (this.gkw != null) {
                    this.gkw.onError(1, str);
                }
            } else if (this.gkw != null) {
                this.gkw.onError(2, str);
            }
        } else {
            buL();
            if (this.gkw != null) {
                this.gkw.onSuccess();
            }
            this.gkD = true;
            this.gcu = z;
            this.gkE = size;
            beH();
        }
        setIsLoading(false);
        if (this.geg != null) {
            h.e buO = buO();
            if (this.geg.anS() && buO != null) {
                this.geg.c(buO);
            } else {
                this.geg.setRefreshing(false);
            }
        }
    }

    private h.e buO() {
        int i;
        String feedText;
        if (this.gkD && this.geg != null && this.geg.anS()) {
            int i2 = this.gkz;
            if (this.gcu) {
                com.baidu.tieba.q.c.cnk().b(this.gkJ, false);
                if (lj(false)) {
                    i = 3;
                } else {
                    i = this.gkE > 0 ? 2 : 0;
                }
            } else if (this.gcu || this.gkz != 0) {
                return null;
            } else {
                i2 = 0;
                i = 2;
            }
            if (this.gjE != null) {
                this.gkA.blS();
            }
            if (this.gjE != null && this.gjE.getCurrentTabType() != 1) {
                this.gkA.hideTip();
                return null;
            } else if (!this.gkH) {
                this.gkA.hideTip();
                return null;
            } else {
                this.gky = i;
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
                    this.fzK = 1000;
                } else {
                    this.fzK = 0;
                }
                return new h.e(feedText, this.fzK);
            }
        }
        return null;
    }

    public void kX(boolean z) {
        if (z) {
            this.gjQ.notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        if (this.fxK != null) {
            this.fxK.destroy();
        }
        if (this.gkA != null) {
            this.gkA.onDestroy();
        }
        if (this.gkv != null) {
            this.gkv.onDestroy();
        }
        if (this.fzZ != null) {
            this.fzZ.removeCallbacks(this.gkR);
        }
        MessageManager.getInstance().unRegisterTask(2016323);
        MessageManager.getInstance().unRegisterListener(this.fwS);
    }

    public void onPause() {
        c.d(this.fzZ);
        tf(this.gkQ);
        if (this.gkC != null) {
            this.gkC.awF();
        }
    }

    private void agz() {
        if (this.gkw != null) {
            this.gkw.M((this.gkx == null || this.gkx.thread_list == null || buR()) ? 0 : this.gkx.thread_list.size(), li(true), 0);
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
                if (!(mVar instanceof com.baidu.tieba.homepage.personalize.data.a) || mVar.getType() == AdvertAppInfo.bWZ) {
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
                if ((mVar2 instanceof com.baidu.tieba.homepage.personalize.data.a) && mVar2.getType() != AdvertAppInfo.bWZ) {
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
        this.geq = true;
        if (dataRes != null) {
            if (a(false, true, true, dataRes) && !buR()) {
                if (this.gkw != null) {
                    this.gkw.onSuccess();
                    return;
                }
                return;
            }
            agz();
            return;
        }
        agz();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.util.Set] */
    private void i(List<com.baidu.adp.widget.ListView.m> list, int i) {
        AdvertAppInfo baN;
        AdvertAppInfo baN2;
        if (!com.baidu.tbadk.core.util.v.isEmpty(list)) {
            Set<com.baidu.adp.widget.ListView.m> CO = com.baidu.tieba.recapp.report.a.CO("NEWINDEX");
            HashSet hashSet = CO == null ? new HashSet() : CO;
            HashSet hashSet2 = new HashSet();
            for (com.baidu.adp.widget.ListView.m mVar : list) {
                if (mVar != null) {
                    for (com.baidu.adp.widget.ListView.m mVar2 : hashSet) {
                        if ((mVar instanceof com.baidu.tieba.card.data.d) && (baN2 = ((com.baidu.tieba.card.data.d) mVar).baN()) != null && mVar2 != null && (mVar2 instanceof AdvertAppInfo) && mVar2.hashCode() == baN2.hashCode()) {
                            baN2.advertAppContext = ((AdvertAppInfo) mVar2).advertAppContext;
                        }
                    }
                    if (mVar != null && (mVar instanceof com.baidu.tieba.card.data.d) && (baN = ((com.baidu.tieba.card.data.d) mVar).baN()) != null && baN.advertAppContext == null) {
                        baN.advertAppContext = new com.baidu.tbadk.core.data.c();
                        baN.advertAppContext.page = "NEWINDEX";
                        baN.advertAppContext.pn = this.mPn;
                        baN.advertAppContext.extensionInfo = baN.extensionInfo;
                        baN.advertAppContext.AJ = false;
                        hashSet2.add(baN);
                    }
                }
            }
            hashSet.addAll(hashSet2);
            com.baidu.tieba.recapp.report.a.e("NEWINDEX", hashSet);
            if (hashSet2.size() > 0) {
                com.baidu.tieba.q.c.cnk().b(this.gkJ, com.baidu.tieba.q.a.b(PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE, "common_fill", true, hashSet2.size()));
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
        if (this.gkL == 1) {
            if (z2 && (dataRes.thread_list.size() >= 6 || buR())) {
                buQ();
                this.gkx = null;
            }
        } else if (z2 && buR()) {
            this.gkx = null;
        }
        int size = z2 ? 0 : this.mDataList.size();
        DataRes.Builder builder = new DataRes.Builder(dataRes);
        this.mDataList.clear();
        com.baidu.tieba.homepage.personalize.model.c a2 = this.gkB.a(z, this.gkx, builder, z2 ? 0 : 1);
        if (a2 == null) {
            list = null;
        } else {
            List<com.baidu.adp.widget.ListView.m> list2 = a2.dbM;
            this.gkz = a2.gmR;
            list = list2;
        }
        if (list != null) {
            this.mDataList.addAll(list);
            i(list, size);
            a(z2 ? 0 : 1, list, size);
            if (this.gkF) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
            }
        }
        if (this.gkx == null) {
            this.gkx = builder;
            this.gkv.cR(this.gkx.thread_list);
        }
        if (this.mDataList.size() == 0) {
            z4 = false;
        } else {
            if (z2) {
                if (dataRes.live_answer != null) {
                    this.gkG = new g();
                    this.gkG.a(dataRes.live_answer);
                    this.gkx.live_answer = dataRes.live_answer;
                } else if (z) {
                    this.gkG = null;
                    this.gkx.live_answer = null;
                }
                this.gkI = dataRes.float_info;
                this.gkx.float_info = dataRes.float_info;
            }
            long j = com.baidu.tbadk.core.sharedPref.b.alR().getLong("key_maintab_banner_close_time", 0L);
            if (this.gkG != null && !com.baidu.tbadk.core.util.aq.isTaday(j)) {
                this.mDataList.add(0, this.gkG);
            }
            LinkedList linkedList = new LinkedList(this.mDataList);
            this.gjQ.setFromCDN(dataRes.is_new_url.intValue() == 1);
            this.gjQ.aY(linkedList);
            z4 = true;
            if (this.fxK != null && this.gjz) {
                this.fxK.c(this.fwY, this.dvr, this.fxD, true);
            }
        }
        com.baidu.tieba.homepage.framework.a.btv().n(System.currentTimeMillis() - currentTimeMillis, 1);
        long sL = com.baidu.tieba.homepage.framework.a.btv().sL(1);
        if (sL > 0) {
            com.baidu.tieba.homepage.framework.a.btv().o(System.currentTimeMillis() - sL, 1);
            com.baidu.tieba.homepage.framework.a.btv().p(0L, 1);
        }
        if (dataRes.anti != null && dataRes.anti.block_pop_info != null) {
            com.baidu.tieba.ueg.d.d(dataRes.anti.block_pop_info);
        }
        aw awVar = new aw();
        awVar.a(dataRes.recom_post_topic);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_REFRESH_TOPIC_TIP, awVar));
        return z4;
    }

    private void buP() {
        if (com.baidu.tbadk.core.util.v.getCount(this.mDataList) >= this.gkB.bvk() - 40) {
            com.baidu.tieba.homepage.personalize.model.c a2 = this.gkB.a(true, this.gkx, (DataRes.Builder) null, 1);
            List<com.baidu.adp.widget.ListView.m> list = a2 != null ? a2.dbM : null;
            if (list != null) {
                this.mDataList.clear();
                this.mDataList.addAll(list);
                this.gjQ.aY(new LinkedList(this.mDataList));
            }
        }
    }

    private void agA() {
        this.geq = true;
        com.baidu.tbadk.util.z.a(new y<DataRes>() { // from class: com.baidu.tieba.homepage.personalize.e.24
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.y
            /* renamed from: buW */
            public DataRes doInBackground() {
                com.baidu.adp.lib.cache.l<byte[]> bJ = com.baidu.tbadk.core.d.a.akN().bJ("tb.rec_frs_update", TbadkCoreApplication.getCurrentAccount());
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

    private void beH() {
        if (this.gkx != null) {
            DataRes.Builder builder = new DataRes.Builder(this.gkx.build(true));
            if (builder.thread_list != null && builder.thread_list.size() > 30) {
                builder.thread_list = builder.thread_list.subList(0, 30);
            }
            a(builder, builder.thread_list != null ? builder.thread_list.size() : 0);
            a(builder);
        }
    }

    private void buQ() {
        if (this.gkx != null) {
            final DataRes.Builder builder = new DataRes.Builder(this.gkx.build(true));
            if (builder.thread_list != null && builder.thread_list.size() > 50) {
                builder.thread_list = builder.thread_list.subList(0, 50);
            }
            a(builder, builder.thread_list != null ? builder.thread_list.size() : 0);
            com.baidu.tbadk.util.z.a(new y<Object>() { // from class: com.baidu.tieba.homepage.personalize.e.2
                @Override // com.baidu.tbadk.util.y
                public Object doInBackground() {
                    DataRes.Builder builder2 = new DataRes.Builder(builder.build(true));
                    e.this.gkv.cS(builder2.thread_list);
                    try {
                        com.baidu.tbadk.core.d.a.akN().bJ("tb.rec_old_data", TbadkCoreApplication.getCurrentAccount()).setForever("0", builder2.build(true).toByteArray());
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
        if (!TextUtils.isEmpty(str) && this.gkx != null && this.gkx.banner_list != null && this.gkx.banner_list.app != null && this.gkx.banner_list.app.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (App app : this.gkx.banner_list.app) {
                if (app != null && str.equals(app.id)) {
                    arrayList.add(app);
                }
            }
            BannerList.Builder builder = new BannerList.Builder(this.gkx.banner_list);
            if (builder.app != null) {
                builder.app.removeAll(arrayList);
            }
            this.gkx.banner_list = builder.build(false);
            DataRes.Builder builder2 = new DataRes.Builder(this.gkx.build(true));
            builder2.banner_list = builder.build(true);
            a(builder2);
        }
    }

    private void a(final DataRes.Builder builder) {
        com.baidu.tbadk.util.z.a(new y<Object>() { // from class: com.baidu.tieba.homepage.personalize.e.3
            @Override // com.baidu.tbadk.util.y
            public Object doInBackground() {
                DataRes.Builder builder2 = new DataRes.Builder(builder.build(true));
                e.this.gkv.cS(builder2.thread_list);
                try {
                    com.baidu.tbadk.core.d.a.akN().bJ("tb.rec_frs_update", TbadkCoreApplication.getCurrentAccount()).setForever("0", builder2.build(true).toByteArray());
                    return null;
                } catch (Exception e) {
                    BdLog.e(e);
                    return null;
                }
            }
        }, null);
    }

    private boolean buR() {
        return lj(true);
    }

    private boolean lj(boolean z) {
        long j = com.baidu.tbadk.core.sharedPref.b.alR().getLong(SharedPrefConfig.RECOMMEND_FRS_REFRESH_TIME, 0L);
        return j == 0 ? z : Math.abs(System.currentTimeMillis() - j) > this.gku;
    }

    public void a(a aVar) {
        this.gkw = aVar;
    }

    private boolean isLoading() {
        return this.mIsLoading;
    }

    private void setIsLoading(boolean z) {
        this.mIsLoading = z;
    }

    public void buF() {
        boolean z = true;
        com.baidu.tbadk.coreExtra.data.b activityPrizeData = TbadkCoreApplication.getInst().getActivityPrizeData();
        if (activityPrizeData.isSwitchTurn() && !StringUtils.isNull(activityPrizeData.getFeedText())) {
            String currentDay = UtilHelper.getCurrentDay();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            String str = "";
            if (!StringUtils.isNull(currentAccount)) {
                String string = com.baidu.tbadk.core.sharedPref.b.alR().getString(SharedPrefConfig.ACTIVITY_PRIZE_FEED_TEXT_TIME, "");
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
                    bF(4, 0);
                    com.baidu.tbadk.core.sharedPref.b.alR().putString(SharedPrefConfig.ACTIVITY_PRIZE_FEED_TEXT_TIME, str);
                }
            }
        }
    }

    private void bF(int i, int i2) {
        if (this.gjE != null) {
            this.gkA.blS();
        }
        if (this.gjE != null && this.gjE.getCurrentTabType() != 1) {
            this.gkA.hideTip();
        } else if (!this.gkH) {
            this.gkA.hideTip();
        } else {
            this.gky = i;
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
                    this.fzK = 3000;
                } else {
                    this.fzK = 2000;
                }
                this.gkK.cqf = str;
                this.gkK.fzC = this.fzK;
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 49;
                FrameLayout frameLayout = this.gjE.getFrameLayout();
                frameLayout.removeView(this.gkK);
                frameLayout.addView(this.gkK, layoutParams);
                this.gkK.blQ();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(Long l) {
        if (this.gkx != null && this.gkx.thread_list != null) {
            List<ThreadInfo> list = this.gkx.thread_list;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                ThreadInfo threadInfo = list.get(i);
                if (threadInfo.tid.equals(l) && threadInfo.top_agree_post != null) {
                    ThreadInfo.Builder builder = new ThreadInfo.Builder(threadInfo);
                    builder.top_agree_post = null;
                    list.set(i, builder.build(true));
                    beH();
                    a(false, true, false, this.gkx.build(true));
                    return;
                }
            }
        }
    }

    public void l(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.gkJ = bdUniqueId;
            if (this.fMF != null) {
                this.fMF.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.fMF);
            }
            if (this.gkN != null) {
                this.gkN.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.gkN);
            }
            this.cjZ.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.cjZ);
            this.gkO.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.gkO);
            this.fON.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.fON);
            this.fOO.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.fOO);
            this.fMU.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.fMU);
            if (this.fxK != null) {
                this.fxK.setUniqueId(bdUniqueId);
            }
            this.gkv.j(bdUniqueId);
            this.gkT.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.gkT);
            this.fwR.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.fwR);
            this.gkU.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.gkU);
        }
    }

    public void buS() {
        this.fvk = new com.baidu.tieba.tbadkCore.data.f("new_index", null);
        this.fvk.cnR();
    }

    public void a(int i, List<com.baidu.adp.widget.ListView.m> list, int i2) {
        int i3;
        int i4;
        if (this.fvk != null) {
            if (i == 0) {
                this.fvk.cnR();
            }
            if (list != null && !list.isEmpty()) {
                int[] iArr = com.baidu.tieba.tbadkCore.data.f.jhO;
                int i5 = 0;
                int i6 = 0;
                int i7 = 0;
                while (i7 < list.size() && i6 < iArr.length && (i3 = iArr[i6]) >= 0) {
                    if (list.get(i7) instanceof com.baidu.tieba.card.data.c) {
                        i4 = i5 + 1;
                        if (i4 == i3 - 1) {
                            if (i2 < i7 + 1) {
                                this.fvk.cr(i3, i7 + 1);
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

    public void te(int i) {
        if ((this.fvk != null ? this.fvk.zO(i) : -1) >= 0 && this.fzZ != null && this.fzZ.getData() != null && this.fzZ.getData().size() > i) {
            this.fvk.zP(i);
        }
    }

    public m bkJ() {
        return this.fxK;
    }

    public void ld(boolean z) {
        this.gjz = z;
    }

    public void tf(final int i) {
        com.baidu.tbadk.util.z.a(new y<Object>() { // from class: com.baidu.tieba.homepage.personalize.e.7
            @Override // com.baidu.tbadk.util.y
            public Object doInBackground() {
                com.baidu.adp.lib.cache.l<String> bK = com.baidu.tbadk.core.d.a.akN().bK(e.this.gkP, TbadkCoreApplication.getCurrentAccount());
                if (bK != null) {
                    bK.set(e.this.gkP, Integer.toString(i), 43200000L);
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
            /* renamed from: buV */
            public String doInBackground() {
                com.baidu.adp.lib.cache.l<String> bK = com.baidu.tbadk.core.d.a.akN().bK(e.this.gkP, TbadkCoreApplication.getCurrentAccount());
                if (bK != null) {
                    return bK.get(e.this.gkP);
                }
                return null;
            }
        }, new com.baidu.tbadk.util.j<String>() { // from class: com.baidu.tieba.homepage.personalize.e.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.j
            /* renamed from: xb */
            public void onReturnDataInUI(String str) {
                if (dVar != null) {
                    dVar.sM(com.baidu.adp.lib.g.b.toInt(str, 0));
                }
            }
        });
    }

    public void buG() {
        c.e(this.fzZ);
    }

    public void buT() {
        a(this.gkS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(CustomResponsedMessage<?> customResponsedMessage) {
        boolean z;
        String str;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.gkx != null && com.baidu.tbadk.core.util.v.getCount(this.gkx.thread_list) != 0 && com.baidu.tbadk.core.util.v.getCount(this.mDataList) != 0) {
            JSONObject jSONObject = (JSONObject) customResponsedMessage.getData();
            String optString = jSONObject.optString("tid");
            if (StringUtils.isNull(optString)) {
                String optString2 = jSONObject.optString("liveid");
                if (this.fzZ != null && !TextUtils.isEmpty(optString2)) {
                    int i = 0;
                    while (true) {
                        if (i >= this.fzZ.getCount()) {
                            str = optString;
                            break;
                        }
                        com.baidu.adp.widget.ListView.m item = this.fzZ.getItem(i);
                        if (item instanceof com.baidu.tieba.card.data.j) {
                            com.baidu.tieba.card.data.j jVar = (com.baidu.tieba.card.data.j) item;
                            if (jVar.agI() != null && jVar.agI().aiZ() != null && optString2.equals(String.valueOf(jVar.agI().aiZ().live_id))) {
                                str = jVar.agI().getTid();
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
                    if (cVar.agI() != null && cVar.agI().getTid() != null) {
                        if (cVar.agI().getTid().equals(optString)) {
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
            if (this.gkx != null && this.gkx.thread_list != null) {
                long j = com.baidu.adp.lib.g.b.toLong(optString, 0L);
                int i2 = 0;
                while (true) {
                    if (i2 < this.gkx.thread_list.size()) {
                        ThreadInfo threadInfo = this.gkx.thread_list.get(i2);
                        if (threadInfo == null || threadInfo.tid == null || threadInfo.tid.longValue() != j) {
                            i2++;
                        } else {
                            this.gkx.thread_list.remove(i2);
                            beH();
                            com.baidu.tieba.homepage.personalize.b.d.a(threadInfo.tid.longValue(), i2, this.gkx.thread_list, this.mDataList);
                            break;
                        }
                    } else {
                        break;
                    }
                }
                if (this.fzZ != null) {
                    List<Integer> b = b(optString, this.fzZ);
                    int intValue = b.get(0).intValue();
                    int intValue2 = b.get(1).intValue();
                    if (intValue != -1 && intValue2 != -1) {
                        this.fzZ.l(intValue, intValue2);
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
                    if (cVar.agI() != null && cVar.agI().getTid().equals(str)) {
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
                    advertAppInfo = ((com.baidu.tieba.homepage.personalize.data.a) next).baN();
                } else {
                    if (next instanceof ad) {
                        ad adVar = (ad) next;
                        if (adVar.ahl() instanceof AdvertAppInfo.ILegoAdvert) {
                            advertAppInfo = ((AdvertAppInfo.ILegoAdvert) adVar.ahl()).getAdvertAppInfo();
                        }
                    }
                    advertAppInfo = advertAppInfo2;
                }
                if (advertAppInfo != null && str.equals(advertAppInfo.bXk)) {
                    it.remove();
                    advertAppInfo = null;
                }
                advertAppInfo2 = advertAppInfo;
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (this.gkK != null) {
            this.gkK.onChangeSkinType(i);
        }
    }

    public FloatInfo buU() {
        return this.gkI;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public z bus() {
        if (this.fxK == null || this.fxK.ccm() == null || !(this.fxK.ccm().getTag() instanceof z)) {
            return null;
        }
        return (z) this.fxK.ccm().getTag();
    }
}
