package com.baidu.tieba.homepage.personalize;

import android.os.Looper;
import android.os.MessageQueue;
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
import com.baidu.tbadk.n.n;
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
/* loaded from: classes7.dex */
public class e {
    private y dCJ;
    private View.OnTouchListener dpJ;
    private com.baidu.tieba.f.a gKp;
    private boolean gTb;
    private final BigdaySwipeRefreshLayout gUT;
    private ScrollFragmentTabHost gZD;
    private final ab gZQ;
    private com.baidu.tieba.tbadkCore.data.f gmf;
    private m goz;
    private final BdTypeRecyclerView gqN;
    private ar haA;
    private final com.baidu.tieba.homepage.personalize.model.a haB;
    private int haE;
    private com.baidu.tieba.homepage.personalize.data.f haG;
    private BdUniqueId haJ;
    private SmartBubbleAnimatedView haK;
    private int haL;
    private Runnable haR;
    private final long hau;
    private final b hav;
    private DataRes.Builder hax;
    private final TbPageContext<?> mPageContext;
    private a haw = null;
    private final List<com.baidu.adp.widget.ListView.m> mDataList = new LinkedList();
    private int mPn = 1;
    private boolean mIsLoading = false;
    private boolean gVb = false;
    private int hay = 2;
    private int haz = 0;
    private TextView mTipView = null;
    private int gqy = 2000;
    private com.baidu.tbadk.n.c haC = null;
    private boolean gos = false;
    private int gnN = 0;
    private int efM = 0;
    private boolean mIsBackground = false;
    private boolean gZy = true;
    private boolean haD = false;
    private boolean haF = false;
    private boolean haH = true;
    private FloatInfo haI = null;
    private a.C0050a gmx = new a.C0050a(2);
    private RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.e.12
        private int hba = -1;
        private int gVj = 0;
        private boolean hbb = false;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (e.this.haC == null) {
                e.this.haC = new com.baidu.tbadk.n.c();
                e.this.haC.setSubType(1005);
                e.this.haC.pageType = 1;
            }
            if (e.this.dCJ != null && !e.this.mIsBackground) {
                e.this.dCJ.l(recyclerView, i);
            }
            if (i == 0) {
                c.d(e.this.gqN);
                e.this.haC.aOK();
                r.btA().hU(true);
                com.baidu.tieba.a.d.aVo().cm("page_recommend", "show_");
                com.baidu.tieba.r.c.cIs().b(e.this.haJ, false);
                this.hbb = false;
                if (e.this.goz != null && e.this.gZy && !e.this.mIsBackground) {
                    e.this.goz.a(e.this.gnN, e.this.efM, e.this.gos, 1);
                    return;
                }
                return;
            }
            e.this.haC.aOJ();
            if (i == 1) {
                if (e.this.haA != null) {
                    e.this.haA.hideTip();
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
            if (this.gVj > i) {
                this.hbb = true;
            }
            if (e.this.dCJ != null && !e.this.mIsBackground) {
                e.this.dCJ.onScroll(this.gVj, i);
            }
            this.gVj = i;
            int i3 = (i + i2) - 1;
            if (!this.hbb && this.hba != i3) {
                this.hba = i3;
                e.this.vl(this.hba);
            }
            if (this.hbb && this.hba != i) {
                this.hba = i;
                e.this.vl(this.hba);
            }
            e.this.haQ = i;
            e.this.gnN = i;
            e.this.efM = (i + i2) - 1;
            af bMM = e.this.bMM();
            if (bMM != null && bMM.mU() != null) {
                bMM.mU().b(e.this.gmx);
            }
        }
    };
    private View.OnTouchListener dnp = new View.OnTouchListener() { // from class: com.baidu.tieba.homepage.personalize.e.22
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (e.this.dpJ != null) {
                e.this.dpJ.onTouch(view, motionEvent);
            }
            if (e.this.gKp != null) {
                e.this.gKp.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private a.InterfaceC0492a fPc = new a.InterfaceC0492a() { // from class: com.baidu.tieba.homepage.personalize.e.23
        @Override // com.baidu.tieba.f.a.InterfaceC0492a
        public void y(int i, int i2) {
            e.this.gos = false;
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0492a
        public void z(int i, int i2) {
            e.this.gos = true;
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0492a
        public void bz(int i, int i2) {
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0492a
        public void A(int i, int i2) {
        }
    };
    private View.OnClickListener haM = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.e.24
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (e.this.haA != null) {
                e.this.haA.hideTip();
            }
        }
    };
    private final CustomMessageListener haN = new CustomMessageListener(CmdConfigCustom.CMD_RELOAD_HP_PERSONALIZED) { // from class: com.baidu.tieba.homepage.personalize.e.25
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (e.this.gqN != null) {
                e.this.goz.bML();
                e.this.gZy = false;
                e.this.gUT.setRefreshing(true);
            }
        }
    };
    private CustomMessageListener gDn = new CustomMessageListener(CmdConfigCustom.PB_ACTION_PRAISE) { // from class: com.baidu.tieba.homepage.personalize.e.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            bj bjVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bj) && e.this.hax != null && v.getCount(e.this.hax.thread_list) != 0 && (bjVar = (bj) customResponsedMessage.getData()) != null && bjVar.azI() != null && bjVar.getId() != null && v.getCount(e.this.hax.thread_list) != 0) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < e.this.hax.thread_list.size()) {
                        ThreadInfo threadInfo = e.this.hax.thread_list.get(i2);
                        if (threadInfo == null || threadInfo.id.longValue() != com.baidu.adp.lib.f.b.toLong(bjVar.getId(), -1L)) {
                            i = i2 + 1;
                        } else {
                            ThreadInfo.Builder builder = new ThreadInfo.Builder(threadInfo);
                            Zan.Builder builder2 = new Zan.Builder(builder.zan);
                            builder2.num = Integer.valueOf((int) bjVar.azI().getNum());
                            builder.zan = builder2.build(true);
                            e.this.hax.thread_list.set(i2, builder.build(true));
                            return;
                        }
                    } else {
                        return;
                    }
                }
            }
        }
    };
    private CustomMessageListener haO = new CustomMessageListener(CmdConfigCustom.CMD_LIVE_VIDEO_CLOSED_QUERY_RESPONSED) { // from class: com.baidu.tieba.homepage.personalize.e.6
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
                        if ((originData.get(i2) instanceof bj) && (bjVar = (bj) originData.get(i2)) != null && bjVar.aAq() != null && ids.contains(Long.valueOf(bjVar.aAq().live_id))) {
                            e.this.mDataList.remove(bjVar);
                        }
                        i = i2 + 1;
                    }
                    if (e.this.gZQ != null) {
                        e.this.gZQ.ac(new ArrayList(e.this.mDataList));
                    }
                }
            }
        }
    };
    private CustomMessageListener cWc = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.homepage.personalize.e.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int intValue;
            if ((customResponsedMessage instanceof UpdateAttentionMessage) && e.this.hax != null && !v.isEmpty(e.this.hax.thread_list)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid)) {
                    int i = 0;
                    while (true) {
                        if (i >= e.this.hax.thread_list.size()) {
                            break;
                        }
                        ThreadInfo threadInfo = e.this.hax.thread_list.get(i);
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
                            e.this.hax.thread_list.set(i, builder.build(true));
                        }
                    }
                    e.this.a(updateAttentionMessage);
                }
            }
        }
    };
    private String haP = "lastReadReadPositionKey";
    private int haQ = 0;
    private d haS = new d() { // from class: com.baidu.tieba.homepage.personalize.e.11
        @Override // com.baidu.tieba.homepage.personalize.d
        public void uU(final int i) {
            if (e.this.haR == null) {
                e.this.haR = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.e.11.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (e.this.gqN.getHandler() != null) {
                            e.this.gqN.requestFocusFromTouch();
                            if (i <= e.this.gqN.getCount() - 1) {
                                e.this.gqN.setSelection(i);
                            }
                        }
                    }
                };
            }
            e.this.gqN.removeCallbacks(e.this.haR);
            e.this.gqN.post(e.this.haR);
        }
    };
    private CustomMessageListener haT = new CustomMessageListener(2016569) { // from class: com.baidu.tieba.homepage.personalize.e.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && e.this.haG != null) {
                e.this.mDataList.remove(e.this.haG);
                e.this.gZQ.ac(new ArrayList(e.this.mDataList));
                com.baidu.tbadk.core.sharedPref.b.aDr().putLong("key_maintab_banner_close_time", System.currentTimeMillis());
            }
        }
    };
    private CustomMessageListener gFy = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.homepage.personalize.e.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.h(customResponsedMessage);
            if (e.this.goz != null && e.this.gZy) {
                e.this.goz.a(e.this.gnN, e.this.efM, e.this.gos, true);
            }
        }
    };
    private CustomMessageListener gFz = new CustomMessageListener(CmdConfigCustom.CMD_THREAD_NOT_EXIST_WHEN_ENTER_PB) { // from class: com.baidu.tieba.homepage.personalize.e.17
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.h(customResponsedMessage);
        }
    };
    private CustomMessageListener gDA = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.homepage.personalize.e.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && e.this.hax != null && v.getCount(e.this.hax.thread_list) != 0) {
                String str = (String) customResponsedMessage.getData();
                e.this.g(str, e.this.mDataList);
                e.this.BT(str);
                if (e.this.gZQ != null) {
                    e.this.gZQ.ac(new ArrayList(e.this.mDataList));
                }
                if (e.this.goz != null && e.this.gZy) {
                    e.this.goz.a(e.this.gnN, e.this.efM, e.this.gos, true);
                }
            }
        }
    };
    private CustomMessageListener gnF = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.homepage.personalize.e.19
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            af bMM;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent)) {
                KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24 && (bMM = e.this.bMM()) != null && bMM.mU() != null) {
                    bMM.mU().b(new a.C0050a(3));
                }
            }
        }
    };
    private com.baidu.adp.framework.listener.a haU = new com.baidu.adp.framework.listener.a(1003065, CmdConfigSocket.CMD_TOPIC_BLESS) { // from class: com.baidu.tieba.homepage.personalize.e.20
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
                        if ((mVar instanceof com.baidu.tieba.homepage.topic.topictab.b.a) && (bVar = ((com.baidu.tieba.homepage.topic.topictab.b.a) mVar).hfw) != null && longValue == bVar.pkId) {
                            bVar.userPkId = j2;
                            return;
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener gnG = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.homepage.personalize.e.21
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int[] imageWidthAndHeight;
            List<com.baidu.adp.widget.ListView.m> dataList = e.this.gZQ.getDataList();
            if (!v.isEmpty(dataList)) {
                for (com.baidu.adp.widget.ListView.m mVar : dataList) {
                    if (mVar instanceof k) {
                        k kVar = (k) mVar;
                        if (kVar.cNc != 0 && kVar.cNb != null) {
                            if ((TbSingleton.getInstance().getHomePageStyleAbTest() & 4) != 0) {
                                imageWidthAndHeight = kVar.cNb.aBQ();
                            } else {
                                imageWidthAndHeight = kVar.cNb.getImageWidthAndHeight();
                            }
                            kVar.cNc = imageWidthAndHeight[0];
                            kVar.cNd = imageWidthAndHeight[1];
                        }
                    }
                }
            }
            com.baidu.adp.lib.f.e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.personalize.e.21.1
                @Override // java.lang.Runnable
                public void run() {
                    e.this.gZQ.notifyDataSetChanged();
                    if (!e.this.mIsBackground && e.this.gZy) {
                        e.this.goz.a(e.this.gnN, e.this.efM, e.this.gos, true);
                    }
                }
            }, 500L);
        }
    };

    /* loaded from: classes7.dex */
    public interface a {
        void M(int i, int i2, int i3);

        void bNc();

        void onError(int i, String str);

        void onSuccess();

        void z(int i, int i2, int i3, int i4);
    }

    public void mF(boolean z) {
        this.haH = z;
        if (this.haA != null && !z) {
            this.haA.hideTip();
        }
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.gZD = scrollFragmentTabHost;
        if (this.gZD != null) {
            this.gZD.setOnTabSelectedListener(new ScrollFragmentTabHost.b() { // from class: com.baidu.tieba.homepage.personalize.e.1
                @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.b
                public void ve(int i) {
                    if (e.this.gZD.vd(i) != 1 && e.this.haA != null) {
                        e.this.haA.hideTip();
                    }
                }
            });
        }
    }

    public void setTabInForeBackgroundState(boolean z) {
        this.mIsBackground = z;
    }

    public void lq(boolean z) {
        boolean z2 = false;
        this.mIsBackground = z;
        if (this.gZD != null) {
            this.gZD.lq(z);
        }
        if (this.goz != null) {
            this.goz.oz(!z);
            af bMM = bMM();
            if (bMM != null && bMM.mU() != null) {
                z2 = bMM.mU().b(new a.C0050a(8, Boolean.valueOf(z)));
            }
            if (!z2) {
                if (z) {
                    this.goz.bML();
                } else if (this.gZy) {
                    this.goz.a(this.gnN, this.efM, this.gos, true);
                }
            }
        }
    }

    public e(TbPageContext<?> tbPageContext, BdTypeRecyclerView bdTypeRecyclerView, ab abVar, BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout) {
        this.haL = 0;
        this.mPageContext = tbPageContext;
        this.haL = com.baidu.tbadk.core.sharedPref.b.aDr().getInt("key_personalized_refresh_type", 0);
        this.gUT = bigdaySwipeRefreshLayout;
        this.gqN = bdTypeRecyclerView;
        this.gqN.setOnTouchListener(this.dnp);
        this.gKp = new com.baidu.tieba.f.a();
        this.gKp.a(this.fPc);
        this.gZQ = abVar;
        this.haB = new com.baidu.tieba.homepage.personalize.model.a();
        this.hau = com.baidu.tbadk.core.sharedPref.b.aDr().getLong("recommend_frs_cache_time", 3600L) * 1000;
        bdTypeRecyclerView.setOnScrollListener(this.mOnScrollListener);
        this.haA = new ar();
        bNm();
        this.goz = new m(this.mPageContext, this.gqN);
        this.goz.Ah(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.hav = new b(this.mDataList, this.gZQ);
        this.haK = new SmartBubbleAnimatedView(tbPageContext.getContext());
        this.haK.setLayoutParams(new FrameLayout.LayoutParams(-1, l.getDimens(tbPageContext.getContext(), R.dimen.tbds83)));
        bNd();
        this.gnG.setTag(this.mPageContext.getUniqueId());
        MessageManager.getInstance().registerListener(this.gnG);
    }

    private void bNd() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2016323, new CustomMessageTask.CustomRunnable<Boolean>() { // from class: com.baidu.tieba.homepage.personalize.e.26
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Boolean> customMessage) {
                af bMM = e.this.bMM();
                return (bMM == null || bMM.mU() == null) ? new CustomResponsedMessage<>(2016323, false) : new CustomResponsedMessage<>(2016323, Boolean.valueOf(bMM.mU().b(new a.C0050a(6))));
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private boolean bNe() {
        return com.baidu.tbadk.core.sharedPref.b.aDr().getBoolean(bNg(), true);
    }

    private void bNf() {
        com.baidu.tbadk.core.sharedPref.b.aDr().putBoolean(bNg(), false);
    }

    private String bNg() {
        return "key_rec_pfirst_load_" + TbadkCoreApplication.getCurrentAccount() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + TbConfig.getVersion();
    }

    public void setRecommendFrsNavigationAnimDispatcher(z zVar) {
        if (zVar != null) {
            this.dCJ = zVar.aPV();
            this.dpJ = zVar.aPW();
        }
    }

    public void showFloatingView() {
        if (this.dCJ != null) {
            this.dCJ.gW(true);
        }
    }

    public void update() {
        com.baidu.tieba.homepage.framework.a.bLN().q(System.currentTimeMillis(), 1);
        this.mPn = 1;
        this.haF = true;
        if (this.mDataList.size() == 0 && !bNe()) {
            if (!this.gVb) {
                axI();
                return;
            }
            return;
        }
        axH();
    }

    public void bT(int i, int i2) {
        bj bjVar;
        if (!v.isEmpty(this.mDataList) && this.mDataList.size() > i) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            while (i < this.mDataList.size() && i <= i2) {
                if (this.mDataList.get(i).getType().getId() == bj.cNw.getId() && (bjVar = (bj) this.mDataList.get(i)) != null && bjVar.aAq() != null) {
                    arrayList.add(Long.valueOf(bjVar.aAq().live_id));
                    arrayList2.add(bjVar);
                }
                i++;
            }
            if (!v.isEmpty(arrayList)) {
                MessageManager.getInstance().sendMessage(new LiveRoomClosedQueryMessage(arrayList, arrayList2));
            }
        }
    }

    public void bNh() {
        if (this.goz != null && !this.mIsBackground && this.gZy) {
            this.goz.a(this.gnN, this.efM, this.gos, true);
        }
        if (this.haD) {
            if (this.gUT != null && !this.gUT.aFC()) {
                if (this.gTb) {
                    com.baidu.tieba.r.c.cIs().b(this.haJ, false);
                    if (mH(false)) {
                        bU(3, this.haz);
                    } else if (this.haE > 0) {
                        bU(2, this.haz);
                    }
                } else if (!this.gTb && this.haz == 0) {
                    bU(2, 0);
                }
            }
            com.baidu.tbadk.core.sharedPref.b.aDr().putLong(SharedPrefConfig.RECOMMEND_FRS_REFRESH_TIME, System.currentTimeMillis());
            this.haD = false;
            this.gTb = false;
            this.haE = 0;
            if (this.haF) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
            }
            this.haF = false;
        }
    }

    public void aZN() {
        if (isLoading()) {
            com.baidu.tieba.homepage.framework.a.bLN().q(0L, 1);
        } else if (this.haw != null) {
            bNj();
            this.mPn++;
            setIsLoading(true);
            this.haw.z(this.mPn, (this.hax == null || this.hax.thread_list == null) ? 0 : this.hax.thread_list.size(), mG(false), 0);
        }
    }

    public void a(boolean z, boolean z2, DataRes dataRes, int i, String str) {
        int size = (this.hax == null || this.hax.thread_list == null) ? 0 : this.hax.thread_list.size();
        if (!z && i == 0 && dataRes != null && v.isEmpty(dataRes.thread_list)) {
            if (this.haw != null) {
                this.haw.bNc();
            }
            setIsLoading(false);
            if (this.gUT != null) {
                this.gUT.setRefreshing(false);
                return;
            }
            return;
        }
        if (i != 0 || dataRes == null || !a(true, z, z2, dataRes)) {
            this.haD = false;
            if (this.mDataList.size() > 0) {
                if (this.haw != null) {
                    this.haw.onError(1, str);
                }
            } else if (this.haw != null) {
                this.haw.onError(2, str);
            }
        } else {
            bNf();
            if (this.haw != null) {
                this.haw.onSuccess();
            }
            this.haD = true;
            this.gTb = z;
            this.haE = size;
            bxb();
        }
        setIsLoading(false);
        if (this.gUT != null) {
            g.e bNi = bNi();
            if (this.gUT.aFC() && bNi != null) {
                this.gUT.c(bNi);
            } else {
                this.gUT.setRefreshing(false);
            }
        }
    }

    private g.e bNi() {
        int i;
        String feedText;
        if (this.haD && this.gUT != null && this.gUT.aFC()) {
            int i2 = this.haz;
            if (this.gTb) {
                com.baidu.tieba.r.c.cIs().b(this.haJ, false);
                if (mH(false)) {
                    i = 3;
                } else {
                    i = this.haE > 0 ? 2 : 0;
                }
            } else if (this.gTb || this.haz != 0) {
                return null;
            } else {
                i2 = 0;
                i = 2;
            }
            if (this.gZD != null) {
                this.haA.bEo();
            }
            if (this.gZD != null && this.gZD.getCurrentTabType() != 1) {
                this.haA.hideTip();
                return null;
            } else if (!this.haH) {
                this.haA.hideTip();
                return null;
            } else {
                this.hay = i;
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
                    this.gqy = 1000;
                } else {
                    this.gqy = 0;
                }
                return new g.e(feedText, this.gqy);
            }
        }
        return null;
    }

    public void mv(boolean z) {
        if (z) {
            this.gZQ.notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        if (this.goz != null) {
            this.goz.destroy();
        }
        if (this.haA != null) {
            this.haA.onDestroy();
        }
        if (this.hav != null) {
            this.hav.onDestroy();
        }
        if (this.gqN != null) {
            this.gqN.removeCallbacks(this.haR);
        }
        MessageManager.getInstance().unRegisterTask(2016323);
        MessageManager.getInstance().unRegisterListener(this.gnG);
    }

    public void onPause() {
        c.d(this.gqN);
        vm(this.haQ);
        if (this.haC != null) {
            this.haC.aOL();
        }
    }

    private void axH() {
        if (this.haw != null) {
            this.haw.M((this.hax == null || this.hax.thread_list == null || bNl()) ? 0 : this.hax.thread_list.size(), mG(true), 0);
        }
    }

    public int mG(boolean z) {
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
                if (!(mVar instanceof com.baidu.tieba.homepage.personalize.data.a) || mVar.getType() == AdvertAppInfo.cIH) {
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
                if ((mVar2 instanceof com.baidu.tieba.homepage.personalize.data.a) && mVar2.getType() != AdvertAppInfo.cIH) {
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
        this.gVb = true;
        if (dataRes != null) {
            if (a(false, true, true, dataRes) && !bNl()) {
                if (this.haw != null) {
                    this.haw.onSuccess();
                    Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler() { // from class: com.baidu.tieba.homepage.personalize.e.27
                        @Override // android.os.MessageQueue.IdleHandler
                        public boolean queueIdle() {
                            e.this.aOQ();
                            return false;
                        }
                    });
                    return;
                }
                return;
            }
            axH();
            return;
        }
        axH();
    }

    public void aOQ() {
        long uS = com.baidu.tieba.homepage.framework.a.bLN().uS(1) + com.baidu.tieba.homepage.framework.a.bLN().getCreateTime();
        long uQ = com.baidu.tieba.homepage.framework.a.bLN().uQ(1);
        if (uQ > 0) {
            uS = System.currentTimeMillis() - uQ;
        }
        n.aOY().cf(uS);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.util.Set] */
    private void i(List<com.baidu.adp.widget.ListView.m> list, int i) {
        AdvertAppInfo btR;
        AdvertAppInfo btR2;
        if (!v.isEmpty(list)) {
            Set<com.baidu.adp.widget.ListView.m> HL = com.baidu.tieba.recapp.report.a.HL("NEWINDEX");
            HashSet hashSet = HL == null ? new HashSet() : HL;
            HashSet hashSet2 = new HashSet();
            for (com.baidu.adp.widget.ListView.m mVar : list) {
                if (mVar != null) {
                    for (com.baidu.adp.widget.ListView.m mVar2 : hashSet) {
                        if ((mVar instanceof com.baidu.tieba.card.data.d) && (btR2 = ((com.baidu.tieba.card.data.d) mVar).btR()) != null && mVar2 != null && (mVar2 instanceof AdvertAppInfo) && mVar2.hashCode() == btR2.hashCode()) {
                            btR2.advertAppContext = ((AdvertAppInfo) mVar2).advertAppContext;
                        }
                    }
                    if (mVar != null && (mVar instanceof com.baidu.tieba.card.data.d) && (btR = ((com.baidu.tieba.card.data.d) mVar).btR()) != null && btR.advertAppContext == null) {
                        btR.advertAppContext = new com.baidu.tbadk.core.data.c();
                        btR.advertAppContext.page = "NEWINDEX";
                        btR.advertAppContext.pn = this.mPn;
                        btR.advertAppContext.extensionInfo = btR.extensionInfo;
                        btR.advertAppContext.CU = false;
                        hashSet2.add(btR);
                    }
                }
            }
            hashSet.addAll(hashSet2);
            com.baidu.tieba.recapp.report.a.b("NEWINDEX", hashSet);
            if (hashSet2.size() > 0) {
                com.baidu.tieba.r.c.cIs().b(this.haJ, com.baidu.tieba.r.a.b(PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE, "common_fill", true, hashSet2.size()));
            }
        }
    }

    private boolean a(boolean z, boolean z2, boolean z3, DataRes dataRes) {
        List<com.baidu.adp.widget.ListView.m> list;
        int i;
        boolean z4;
        if (dataRes == null) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.haL == 1) {
            if (z2 && (dataRes.thread_list.size() >= 6 || bNl())) {
                bNk();
                this.hax = null;
            }
        } else if (z2 && bNl()) {
            this.hax = null;
        }
        int size = z2 ? 0 : this.mDataList.size();
        DataRes.Builder builder = new DataRes.Builder(dataRes);
        this.mDataList.clear();
        com.baidu.tieba.homepage.personalize.model.c a2 = this.haB.a(z, this.hax, builder, z2 ? 0 : 1);
        if (a2 == null) {
            list = null;
            i = 0;
        } else {
            List<com.baidu.adp.widget.ListView.m> list2 = a2.dOX;
            this.haz = a2.hdb;
            int i2 = a2.hdc;
            a2.hdc = 0;
            list = list2;
            i = i2;
        }
        if (list != null) {
            this.mDataList.addAll(list);
            i(list, size);
            a(z2 ? 0 : 1, list, size);
            if (this.haF) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
            }
        }
        if (this.hax == null) {
            this.hax = builder;
            this.hav.cG(this.hax.thread_list);
        }
        if (this.mDataList.size() == 0) {
            z4 = false;
        } else {
            if (z2) {
                if (dataRes.live_answer != null) {
                    this.haG = new com.baidu.tieba.homepage.personalize.data.f();
                    this.haG.a(dataRes.live_answer);
                    this.hax.live_answer = dataRes.live_answer;
                } else if (z) {
                    this.haG = null;
                    this.hax.live_answer = null;
                }
                this.haI = dataRes.float_info;
                this.hax.float_info = dataRes.float_info;
            }
            long j = com.baidu.tbadk.core.sharedPref.b.aDr().getLong("key_maintab_banner_close_time", 0L);
            if (this.haG != null && !aq.isTaday(j)) {
                this.mDataList.add(0, this.haG);
            }
            LinkedList linkedList = new LinkedList(this.mDataList);
            this.gZQ.setFromCDN(dataRes.is_new_url.intValue() == 1);
            this.gZQ.j(linkedList, i);
            z4 = true;
            if (this.goz != null && this.gZy) {
                this.goz.a(this.gnN, this.efM, this.gos, true);
            }
        }
        com.baidu.tieba.homepage.framework.a.bLN().o(System.currentTimeMillis() - currentTimeMillis, 1);
        long uT = com.baidu.tieba.homepage.framework.a.bLN().uT(1);
        if (uT > 0) {
            com.baidu.tieba.homepage.framework.a.bLN().p(System.currentTimeMillis() - uT, 1);
            com.baidu.tieba.homepage.framework.a.bLN().q(0L, 1);
        }
        if (dataRes.anti != null && dataRes.anti.block_pop_info != null) {
            com.baidu.tieba.ueg.d.d(dataRes.anti.block_pop_info);
        }
        ay ayVar = new ay();
        ayVar.a(dataRes.recom_post_topic);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_REFRESH_TOPIC_TIP, ayVar));
        return z4;
    }

    private void bNj() {
        List<com.baidu.adp.widget.ListView.m> list;
        int i;
        if (v.getCount(this.mDataList) >= this.haB.bNE() - 40) {
            com.baidu.tieba.homepage.personalize.model.c a2 = this.haB.a(true, this.hax, (DataRes.Builder) null, 1);
            if (a2 != null) {
                List<com.baidu.adp.widget.ListView.m> list2 = a2.dOX;
                i = a2.hdc;
                a2.hdc = 0;
                list = list2;
            } else {
                list = null;
                i = 0;
            }
            if (list != null) {
                this.mDataList.clear();
                this.mDataList.addAll(list);
                this.gZQ.j(new LinkedList(this.mDataList), i);
            }
        }
    }

    private void axI() {
        this.gVb = true;
        ac.a(new com.baidu.tbadk.util.ab<DataRes>() { // from class: com.baidu.tieba.homepage.personalize.e.28
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.ab
            /* renamed from: bNq */
            public DataRes doInBackground() {
                com.baidu.adp.lib.cache.l<byte[]> ch = com.baidu.tbadk.core.c.a.aCo().ch("tb.rec_frs_update", TbadkCoreApplication.getCurrentAccount());
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
        }, new com.baidu.tbadk.util.l<DataRes>() { // from class: com.baidu.tieba.homepage.personalize.e.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.l
            /* renamed from: b */
            public void onReturnDataInUI(DataRes dataRes) {
                e.this.a(dataRes);
            }
        });
    }

    private void bxb() {
        if (this.hax != null) {
            DataRes.Builder builder = new DataRes.Builder(this.hax.build(true));
            if (builder.thread_list != null && builder.thread_list.size() > 30) {
                builder.thread_list = builder.thread_list.subList(0, 30);
            }
            a(builder, builder.thread_list != null ? builder.thread_list.size() : 0);
            a(builder);
        }
    }

    private void bNk() {
        if (this.hax != null) {
            final DataRes.Builder builder = new DataRes.Builder(this.hax.build(true));
            if (builder.thread_list != null && builder.thread_list.size() > 50) {
                builder.thread_list = builder.thread_list.subList(0, 50);
            }
            a(builder, builder.thread_list != null ? builder.thread_list.size() : 0);
            ac.a(new com.baidu.tbadk.util.ab<Object>() { // from class: com.baidu.tieba.homepage.personalize.e.3
                @Override // com.baidu.tbadk.util.ab
                public Object doInBackground() {
                    DataRes.Builder builder2 = new DataRes.Builder(builder.build(true));
                    e.this.hav.cH(builder2.thread_list);
                    try {
                        com.baidu.tbadk.core.c.a.aCo().ch("tb.rec_old_data", TbadkCoreApplication.getCurrentAccount()).setForever("0", builder2.build(true).toByteArray());
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
    public void BT(String str) {
        if (!TextUtils.isEmpty(str) && this.hax != null && this.hax.banner_list != null && this.hax.banner_list.app != null && this.hax.banner_list.app.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (App app : this.hax.banner_list.app) {
                if (app != null && str.equals(app.id)) {
                    arrayList.add(app);
                }
            }
            BannerList.Builder builder = new BannerList.Builder(this.hax.banner_list);
            if (builder.app != null) {
                builder.app.removeAll(arrayList);
            }
            this.hax.banner_list = builder.build(false);
            DataRes.Builder builder2 = new DataRes.Builder(this.hax.build(true));
            builder2.banner_list = builder.build(true);
            a(builder2);
        }
    }

    private void a(final DataRes.Builder builder) {
        ac.a(new com.baidu.tbadk.util.ab<Object>() { // from class: com.baidu.tieba.homepage.personalize.e.4
            @Override // com.baidu.tbadk.util.ab
            public Object doInBackground() {
                DataRes.Builder builder2 = new DataRes.Builder(builder.build(true));
                e.this.hav.cH(builder2.thread_list);
                try {
                    com.baidu.tbadk.core.c.a.aCo().ch("tb.rec_frs_update", TbadkCoreApplication.getCurrentAccount()).setForever("0", builder2.build(true).toByteArray());
                    return null;
                } catch (Exception e) {
                    BdLog.e(e);
                    return null;
                }
            }
        }, null);
    }

    private boolean bNl() {
        return mH(true);
    }

    private boolean mH(boolean z) {
        long j = com.baidu.tbadk.core.sharedPref.b.aDr().getLong(SharedPrefConfig.RECOMMEND_FRS_REFRESH_TIME, 0L);
        return j == 0 ? z : Math.abs(System.currentTimeMillis() - j) > this.hau;
    }

    public void a(a aVar) {
        this.haw = aVar;
    }

    private boolean isLoading() {
        return this.mIsLoading;
    }

    private void setIsLoading(boolean z) {
        this.mIsLoading = z;
    }

    public void bMZ() {
        boolean z = true;
        com.baidu.tbadk.coreExtra.data.b activityPrizeData = TbadkCoreApplication.getInst().getActivityPrizeData();
        if (activityPrizeData.isSwitchTurn() && !StringUtils.isNull(activityPrizeData.getFeedText())) {
            String currentDay = UtilHelper.getCurrentDay();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            String str = "";
            if (!StringUtils.isNull(currentAccount)) {
                String string = com.baidu.tbadk.core.sharedPref.b.aDr().getString(SharedPrefConfig.ACTIVITY_PRIZE_FEED_TEXT_TIME, "");
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
                    bU(4, 0);
                    com.baidu.tbadk.core.sharedPref.b.aDr().putString(SharedPrefConfig.ACTIVITY_PRIZE_FEED_TEXT_TIME, str);
                }
            }
        }
    }

    private void bU(int i, int i2) {
        if (this.gZD != null) {
            this.haA.bEo();
        }
        if (this.gZD != null && this.gZD.getCurrentTabType() != 1) {
            this.haA.hideTip();
        } else if (!this.haH) {
            this.haA.hideTip();
        } else {
            this.hay = i;
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
                    this.gqy = 3000;
                } else {
                    this.gqy = 2000;
                }
                this.haK.dcR = str;
                this.haK.gqr = this.gqy;
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 49;
                if (this.gZD != null) {
                    FrameLayout frameLayout = this.gZD.getFrameLayout();
                    frameLayout.removeView(this.haK);
                    frameLayout.addView(this.haK, layoutParams);
                    this.haK.bEm();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(Long l) {
        if (this.hax != null && this.hax.thread_list != null) {
            List<ThreadInfo> list = this.hax.thread_list;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                ThreadInfo threadInfo = list.get(i);
                if (threadInfo.tid.equals(l) && threadInfo.top_agree_post != null) {
                    ThreadInfo.Builder builder = new ThreadInfo.Builder(threadInfo);
                    builder.top_agree_post = null;
                    list.set(i, builder.build(true));
                    bxb();
                    a(false, true, false, this.hax.build(true));
                    return;
                }
            }
        }
    }

    public void m(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.haJ = bdUniqueId;
            if (this.gDn != null) {
                this.gDn.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.gDn);
            }
            if (this.haN != null) {
                this.haN.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.haN);
            }
            this.cWc.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.cWc);
            this.haO.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.haO);
            this.gFy.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.gFy);
            this.gFz.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.gFz);
            this.gDA.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.gDA);
            if (this.goz != null) {
                this.goz.setUniqueId(bdUniqueId);
            }
            this.hav.j(bdUniqueId);
            this.haT.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.haT);
            this.gnF.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.gnF);
            this.haU.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.haU);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(UpdateAttentionMessage updateAttentionMessage) {
        if (updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid)) {
            final String str = updateAttentionMessage.getData().toUid;
            final boolean z = updateAttentionMessage.getData().isAttention;
            ac.a(new com.baidu.tbadk.util.ab<Boolean>() { // from class: com.baidu.tieba.homepage.personalize.e.8
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.baidu.tbadk.util.ab
                public Boolean doInBackground() {
                    int intValue;
                    try {
                        com.baidu.adp.lib.cache.l<byte[]> ch = com.baidu.tbadk.core.c.a.aCo().ch("tb.rec_frs_update", TbadkCoreApplication.getCurrentAccount());
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
                        e.this.hav.cH(builder5.thread_list);
                        ch.setForever("0", builder5.build(true).toByteArray());
                        return true;
                    } catch (Exception e) {
                        BdLog.e(e);
                        return false;
                    }
                }
            }, new com.baidu.tbadk.util.l<Boolean>() { // from class: com.baidu.tieba.homepage.personalize.e.9
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.l
                public void onReturnDataInUI(Boolean bool) {
                }
            });
        }
    }

    public void bNm() {
        this.gmf = new com.baidu.tieba.tbadkCore.data.f("new_index", null);
        this.gmf.cIZ();
    }

    public void a(int i, List<com.baidu.adp.widget.ListView.m> list, int i2) {
        int i3;
        int i4;
        if (this.gmf != null) {
            if (i == 0) {
                this.gmf.cIZ();
            }
            if (list != null && !list.isEmpty()) {
                int[] iArr = com.baidu.tieba.tbadkCore.data.f.keO;
                int i5 = 0;
                int i6 = 0;
                int i7 = 0;
                while (i7 < list.size() && i6 < iArr.length && (i3 = iArr[i6]) >= 0) {
                    if (list.get(i7) instanceof com.baidu.tieba.card.data.c) {
                        i4 = i5 + 1;
                        if (i4 == i3 - 1) {
                            if (i2 < i7 + 1) {
                                this.gmf.cG(i3, i7 + 1);
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

    public void vl(int i) {
        if ((this.gmf != null ? this.gmf.Cn(i) : -1) >= 0 && this.gqN != null && this.gqN.getData() != null && this.gqN.getData().size() > i) {
            this.gmf.Co(i);
        }
    }

    public m bDf() {
        return this.goz;
    }

    public void mB(boolean z) {
        this.gZy = z;
    }

    public void vm(final int i) {
        ac.a(new com.baidu.tbadk.util.ab<Object>() { // from class: com.baidu.tieba.homepage.personalize.e.10
            @Override // com.baidu.tbadk.util.ab
            public Object doInBackground() {
                com.baidu.adp.lib.cache.l<String> ci = com.baidu.tbadk.core.c.a.aCo().ci(e.this.haP, TbadkCoreApplication.getCurrentAccount());
                if (ci != null) {
                    ci.set(e.this.haP, Integer.toString(i), 43200000L);
                    return null;
                }
                return null;
            }
        }, null);
    }

    public void a(final d dVar) {
        ac.a(new com.baidu.tbadk.util.ab<String>() { // from class: com.baidu.tieba.homepage.personalize.e.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.ab
            /* renamed from: bNp */
            public String doInBackground() {
                com.baidu.adp.lib.cache.l<String> ci = com.baidu.tbadk.core.c.a.aCo().ci(e.this.haP, TbadkCoreApplication.getCurrentAccount());
                if (ci != null) {
                    return ci.get(e.this.haP);
                }
                return null;
            }
        }, new com.baidu.tbadk.util.l<String>() { // from class: com.baidu.tieba.homepage.personalize.e.14
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.l
            /* renamed from: BU */
            public void onReturnDataInUI(String str) {
                if (dVar != null) {
                    dVar.uU(com.baidu.adp.lib.f.b.toInt(str, 0));
                }
            }
        });
    }

    public void bNa() {
        c.e(this.gqN);
    }

    public void bNn() {
        a(this.haS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(CustomResponsedMessage<?> customResponsedMessage) {
        boolean z;
        String str;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.hax != null && v.getCount(this.hax.thread_list) != 0 && v.getCount(this.mDataList) != 0) {
            JSONObject jSONObject = (JSONObject) customResponsedMessage.getData();
            String optString = jSONObject.optString("tid");
            if (StringUtils.isNull(optString)) {
                String optString2 = jSONObject.optString("liveid");
                if (this.gqN != null && !TextUtils.isEmpty(optString2)) {
                    int i = 0;
                    while (true) {
                        if (i >= this.gqN.getCount()) {
                            str = optString;
                            break;
                        }
                        com.baidu.adp.widget.ListView.m item = this.gqN.getItem(i);
                        if (item instanceof com.baidu.tieba.card.data.j) {
                            com.baidu.tieba.card.data.j jVar = (com.baidu.tieba.card.data.j) item;
                            if (jVar.axQ() != null && jVar.axQ().aAq() != null && optString2.equals(String.valueOf(jVar.axQ().aAq().live_id))) {
                                str = jVar.axQ().getTid();
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
                    if (cVar.axQ() != null && cVar.axQ().getTid() != null) {
                        if (cVar.axQ().getTid().equals(optString)) {
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
            if (this.hax != null && this.hax.thread_list != null) {
                long j = com.baidu.adp.lib.f.b.toLong(optString, 0L);
                int i2 = 0;
                while (true) {
                    if (i2 < this.hax.thread_list.size()) {
                        ThreadInfo threadInfo = this.hax.thread_list.get(i2);
                        if (threadInfo == null || threadInfo.tid == null || threadInfo.tid.longValue() != j) {
                            i2++;
                        } else {
                            this.hax.thread_list.remove(i2);
                            bxb();
                            com.baidu.tieba.homepage.personalize.b.d.a(threadInfo.tid.longValue(), i2, this.hax.thread_list, this.mDataList);
                            break;
                        }
                    } else {
                        break;
                    }
                }
                if (this.gqN != null) {
                    List<Integer> b = b(optString, this.gqN);
                    int intValue = b.get(0).intValue();
                    int intValue2 = b.get(1).intValue();
                    if (intValue != -1 && intValue2 != -1) {
                        this.gqN.l(intValue, intValue2);
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
                    if (cVar.axQ() != null && cVar.axQ().getTid().equals(str)) {
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
                    advertAppInfo = ((com.baidu.tieba.homepage.personalize.data.a) next).btR();
                } else {
                    if (next instanceof ae) {
                        ae aeVar = (ae) next;
                        if (aeVar.ayw() instanceof AdvertAppInfo.ILegoAdvert) {
                            advertAppInfo = ((AdvertAppInfo.ILegoAdvert) aeVar.ayw()).getAdvertAppInfo();
                        }
                    }
                    advertAppInfo = advertAppInfo2;
                }
                if (advertAppInfo != null && str.equals(advertAppInfo.cIS)) {
                    it.remove();
                    advertAppInfo = null;
                }
                advertAppInfo2 = advertAppInfo;
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (this.haK != null) {
            this.haK.onChangeSkinType(i);
        }
    }

    public FloatInfo bNo() {
        return this.haI;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public af bMM() {
        if (this.goz == null || this.goz.cxl() == null || !(this.goz.cxl().getTag() instanceof af)) {
            return null;
        }
        return (af) this.goz.cxl().getTag();
    }
}
