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
/* loaded from: classes9.dex */
public class e {
    private y dHb;
    private View.OnTouchListener duf;
    private com.baidu.tieba.f.a gMC;
    private boolean gVp;
    private final BigdaySwipeRefreshLayout gXi;
    private com.baidu.tieba.tbadkCore.data.f gov;
    private m gqP;
    private final BdTypeRecyclerView gtd;
    private ScrollFragmentTabHost hbR;
    private final long hcI;
    private final b hcJ;
    private DataRes.Builder hcL;
    private ar hcO;
    private final com.baidu.tieba.homepage.personalize.model.a hcP;
    private int hcS;
    private com.baidu.tieba.homepage.personalize.data.f hcU;
    private BdUniqueId hcX;
    private SmartBubbleAnimatedView hcY;
    private int hcZ;
    private final ab hce;
    private Runnable hdf;
    private final TbPageContext<?> mPageContext;
    private a hcK = null;
    private final List<com.baidu.adp.widget.ListView.m> mDataList = new LinkedList();
    private int mPn = 1;
    private boolean mIsLoading = false;
    private boolean gXq = false;
    private int hcM = 2;
    private int hcN = 0;
    private TextView mTipView = null;
    private int gsO = 2000;
    private com.baidu.tbadk.n.c hcQ = null;
    private boolean gqI = false;
    private int gqd = 0;
    private int eke = 0;
    private boolean mIsBackground = false;
    private boolean hbM = true;
    private boolean hcR = false;
    private boolean hcT = false;
    private boolean hcV = true;
    private FloatInfo hcW = null;
    private a.C0052a goN = new a.C0052a(2);
    private RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.e.12
        private int hdo = -1;
        private int gXy = 0;
        private boolean hdp = false;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (e.this.hcQ == null) {
                e.this.hcQ = new com.baidu.tbadk.n.c();
                e.this.hcQ.setSubType(1005);
                e.this.hcQ.pageType = 1;
            }
            if (e.this.dHb != null && !e.this.mIsBackground) {
                e.this.dHb.l(recyclerView, i);
            }
            if (i == 0) {
                c.d(e.this.gtd);
                e.this.hcQ.aRd();
                r.bvh().ib(true);
                com.baidu.tieba.a.d.aXG().cv("page_recommend", "show_");
                com.baidu.tieba.s.c.cKb().b(e.this.hcX, false);
                this.hdp = false;
                if (e.this.gqP != null && e.this.hbM && !e.this.mIsBackground) {
                    e.this.gqP.a(e.this.gqd, e.this.eke, e.this.gqI, 1);
                    return;
                }
                return;
            }
            e.this.hcQ.aRc();
            if (i == 1) {
                if (e.this.hcO != null) {
                    e.this.hcO.hideTip();
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
            if (this.gXy > i) {
                this.hdp = true;
            }
            if (e.this.dHb != null && !e.this.mIsBackground) {
                e.this.dHb.onScroll(this.gXy, i);
            }
            this.gXy = i;
            int i3 = (i + i2) - 1;
            if (!this.hdp && this.hdo != i3) {
                this.hdo = i3;
                e.this.vr(this.hdo);
            }
            if (this.hdp && this.hdo != i) {
                this.hdo = i;
                e.this.vr(this.hdo);
            }
            e.this.hde = i;
            e.this.gqd = i;
            e.this.eke = (i + i2) - 1;
            af bOr = e.this.bOr();
            if (bOr != null && bOr.nk() != null) {
                bOr.nk().b(e.this.goN);
            }
        }
    };
    private View.OnTouchListener drN = new View.OnTouchListener() { // from class: com.baidu.tieba.homepage.personalize.e.22
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (e.this.duf != null) {
                e.this.duf.onTouch(view, motionEvent);
            }
            if (e.this.gMC != null) {
                e.this.gMC.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private a.InterfaceC0499a fRM = new a.InterfaceC0499a() { // from class: com.baidu.tieba.homepage.personalize.e.23
        @Override // com.baidu.tieba.f.a.InterfaceC0499a
        public void z(int i, int i2) {
            e.this.gqI = false;
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0499a
        public void A(int i, int i2) {
            e.this.gqI = true;
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0499a
        public void bA(int i, int i2) {
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0499a
        public void B(int i, int i2) {
        }
    };
    private View.OnClickListener hda = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.e.24
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (e.this.hcO != null) {
                e.this.hcO.hideTip();
            }
        }
    };
    private final CustomMessageListener hdb = new CustomMessageListener(CmdConfigCustom.CMD_RELOAD_HP_PERSONALIZED) { // from class: com.baidu.tieba.homepage.personalize.e.25
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (e.this.gtd != null) {
                e.this.gqP.bOq();
                e.this.hbM = false;
                e.this.gXi.setRefreshing(true);
            }
        }
    };
    private CustomMessageListener gFA = new CustomMessageListener(CmdConfigCustom.PB_ACTION_PRAISE) { // from class: com.baidu.tieba.homepage.personalize.e.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            bj bjVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bj) && e.this.hcL != null && v.getCount(e.this.hcL.thread_list) != 0 && (bjVar = (bj) customResponsedMessage.getData()) != null && bjVar.aBZ() != null && bjVar.getId() != null && v.getCount(e.this.hcL.thread_list) != 0) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < e.this.hcL.thread_list.size()) {
                        ThreadInfo threadInfo = e.this.hcL.thread_list.get(i2);
                        if (threadInfo == null || threadInfo.id.longValue() != com.baidu.adp.lib.f.b.toLong(bjVar.getId(), -1L)) {
                            i = i2 + 1;
                        } else {
                            ThreadInfo.Builder builder = new ThreadInfo.Builder(threadInfo);
                            Zan.Builder builder2 = new Zan.Builder(builder.zan);
                            builder2.num = Integer.valueOf((int) bjVar.aBZ().getNum());
                            builder.zan = builder2.build(true);
                            e.this.hcL.thread_list.set(i2, builder.build(true));
                            return;
                        }
                    } else {
                        return;
                    }
                }
            }
        }
    };
    private CustomMessageListener hdc = new CustomMessageListener(CmdConfigCustom.CMD_LIVE_VIDEO_CLOSED_QUERY_RESPONSED) { // from class: com.baidu.tieba.homepage.personalize.e.6
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
                        if ((originData.get(i2) instanceof bj) && (bjVar = (bj) originData.get(i2)) != null && bjVar.aCH() != null && ids.contains(Long.valueOf(bjVar.aCH().live_id))) {
                            e.this.mDataList.remove(bjVar);
                        }
                        i = i2 + 1;
                    }
                    if (e.this.hce != null) {
                        e.this.hce.ac(new ArrayList(e.this.mDataList));
                    }
                }
            }
        }
    };
    private CustomMessageListener dag = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.homepage.personalize.e.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int intValue;
            if ((customResponsedMessage instanceof UpdateAttentionMessage) && e.this.hcL != null && !v.isEmpty(e.this.hcL.thread_list)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid)) {
                    int i = 0;
                    while (true) {
                        if (i >= e.this.hcL.thread_list.size()) {
                            break;
                        }
                        ThreadInfo threadInfo = e.this.hcL.thread_list.get(i);
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
                            e.this.hcL.thread_list.set(i, builder.build(true));
                        }
                    }
                    e.this.a(updateAttentionMessage);
                }
            }
        }
    };
    private String hdd = "lastReadReadPositionKey";
    private int hde = 0;
    private d hdg = new d() { // from class: com.baidu.tieba.homepage.personalize.e.11
        @Override // com.baidu.tieba.homepage.personalize.d
        public void va(final int i) {
            if (e.this.hdf == null) {
                e.this.hdf = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.e.11.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (e.this.gtd.getHandler() != null) {
                            e.this.gtd.requestFocusFromTouch();
                            if (i <= e.this.gtd.getCount() - 1) {
                                e.this.gtd.setSelection(i);
                            }
                        }
                    }
                };
            }
            e.this.gtd.removeCallbacks(e.this.hdf);
            e.this.gtd.post(e.this.hdf);
        }
    };
    private CustomMessageListener hdh = new CustomMessageListener(2016569) { // from class: com.baidu.tieba.homepage.personalize.e.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && e.this.hcU != null) {
                e.this.mDataList.remove(e.this.hcU);
                e.this.hce.ac(new ArrayList(e.this.mDataList));
                com.baidu.tbadk.core.sharedPref.b.aFD().putLong("key_maintab_banner_close_time", System.currentTimeMillis());
            }
        }
    };
    private CustomMessageListener gHL = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.homepage.personalize.e.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.h(customResponsedMessage);
            if (e.this.gqP != null && e.this.hbM) {
                e.this.gqP.a(e.this.gqd, e.this.eke, e.this.gqI, true);
            }
        }
    };
    private CustomMessageListener gHM = new CustomMessageListener(CmdConfigCustom.CMD_THREAD_NOT_EXIST_WHEN_ENTER_PB) { // from class: com.baidu.tieba.homepage.personalize.e.17
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.h(customResponsedMessage);
        }
    };
    private CustomMessageListener gFN = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.homepage.personalize.e.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && e.this.hcL != null && v.getCount(e.this.hcL.thread_list) != 0) {
                String str = (String) customResponsedMessage.getData();
                e.this.h(str, e.this.mDataList);
                e.this.Ck(str);
                if (e.this.hce != null) {
                    e.this.hce.ac(new ArrayList(e.this.mDataList));
                }
                if (e.this.gqP != null && e.this.hbM) {
                    e.this.gqP.a(e.this.gqd, e.this.eke, e.this.gqI, true);
                }
            }
        }
    };
    private CustomMessageListener gpV = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.homepage.personalize.e.19
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            af bOr;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent)) {
                KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24 && (bOr = e.this.bOr()) != null && bOr.nk() != null) {
                    bOr.nk().b(new a.C0052a(3));
                }
            }
        }
    };
    private com.baidu.adp.framework.listener.a hdi = new com.baidu.adp.framework.listener.a(1003065, CmdConfigSocket.CMD_TOPIC_BLESS) { // from class: com.baidu.tieba.homepage.personalize.e.20
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
                        if ((mVar instanceof com.baidu.tieba.homepage.topic.topictab.b.a) && (bVar = ((com.baidu.tieba.homepage.topic.topictab.b.a) mVar).hhK) != null && longValue == bVar.pkId) {
                            bVar.userPkId = j2;
                            return;
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener gpW = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.homepage.personalize.e.21
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int[] imageWidthAndHeight;
            List<com.baidu.adp.widget.ListView.m> dataList = e.this.hce.getDataList();
            if (!v.isEmpty(dataList)) {
                for (com.baidu.adp.widget.ListView.m mVar : dataList) {
                    if (mVar instanceof k) {
                        k kVar = (k) mVar;
                        if (kVar.cRh != 0 && kVar.cRg != null) {
                            if ((TbSingleton.getInstance().getHomePageStyleAbTest() & 4) != 0) {
                                imageWidthAndHeight = kVar.cRg.aEe();
                            } else {
                                imageWidthAndHeight = kVar.cRg.getImageWidthAndHeight();
                            }
                            kVar.cRh = imageWidthAndHeight[0];
                            kVar.cRi = imageWidthAndHeight[1];
                        }
                    }
                }
            }
            com.baidu.adp.lib.f.e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.personalize.e.21.1
                @Override // java.lang.Runnable
                public void run() {
                    e.this.hce.notifyDataSetChanged();
                    if (!e.this.mIsBackground && e.this.hbM) {
                        e.this.gqP.a(e.this.gqd, e.this.eke, e.this.gqI, true);
                    }
                }
            }, 500L);
        }
    };

    /* loaded from: classes9.dex */
    public interface a {
        void N(int i, int i2, int i3);

        void bOH();

        void onError(int i, String str);

        void onSuccess();

        void z(int i, int i2, int i3, int i4);
    }

    public void mH(boolean z) {
        this.hcV = z;
        if (this.hcO != null && !z) {
            this.hcO.hideTip();
        }
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.hbR = scrollFragmentTabHost;
        if (this.hbR != null) {
            this.hbR.setOnTabSelectedListener(new ScrollFragmentTabHost.b() { // from class: com.baidu.tieba.homepage.personalize.e.1
                @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.b
                public void vk(int i) {
                    if (e.this.hbR.vj(i) != 1 && e.this.hcO != null) {
                        e.this.hcO.hideTip();
                    }
                }
            });
        }
    }

    public void setTabInForeBackgroundState(boolean z) {
        this.mIsBackground = z;
    }

    public void lt(boolean z) {
        boolean z2 = false;
        this.mIsBackground = z;
        if (this.hbR != null) {
            this.hbR.lt(z);
        }
        if (this.gqP != null) {
            this.gqP.oB(!z);
            af bOr = bOr();
            if (bOr != null && bOr.nk() != null) {
                z2 = bOr.nk().b(new a.C0052a(8, Boolean.valueOf(z)));
            }
            if (!z2) {
                if (z) {
                    this.gqP.bOq();
                } else if (this.hbM) {
                    this.gqP.a(this.gqd, this.eke, this.gqI, true);
                }
            }
        }
    }

    public e(TbPageContext<?> tbPageContext, BdTypeRecyclerView bdTypeRecyclerView, ab abVar, BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout) {
        this.hcZ = 0;
        this.mPageContext = tbPageContext;
        this.hcZ = com.baidu.tbadk.core.sharedPref.b.aFD().getInt("key_personalized_refresh_type", 0);
        this.gXi = bigdaySwipeRefreshLayout;
        this.gtd = bdTypeRecyclerView;
        this.gtd.setOnTouchListener(this.drN);
        this.gMC = new com.baidu.tieba.f.a();
        this.gMC.a(this.fRM);
        this.hce = abVar;
        this.hcP = new com.baidu.tieba.homepage.personalize.model.a();
        this.hcI = com.baidu.tbadk.core.sharedPref.b.aFD().getLong("recommend_frs_cache_time", 3600L) * 1000;
        bdTypeRecyclerView.setOnScrollListener(this.mOnScrollListener);
        this.hcO = new ar();
        bOR();
        this.gqP = new m(this.mPageContext, this.gtd);
        this.gqP.Ar(1);
        this.gqP.Aq(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.hcJ = new b(this.mDataList, this.hce);
        this.hcY = new SmartBubbleAnimatedView(tbPageContext.getContext());
        this.hcY.setLayoutParams(new FrameLayout.LayoutParams(-1, l.getDimens(tbPageContext.getContext(), R.dimen.tbds83)));
        bOI();
        this.gpW.setTag(this.mPageContext.getUniqueId());
        MessageManager.getInstance().registerListener(this.gpW);
    }

    private void bOI() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2016323, new CustomMessageTask.CustomRunnable<Boolean>() { // from class: com.baidu.tieba.homepage.personalize.e.26
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Boolean> customMessage) {
                af bOr = e.this.bOr();
                return (bOr == null || bOr.nk() == null) ? new CustomResponsedMessage<>(2016323, false) : new CustomResponsedMessage<>(2016323, Boolean.valueOf(bOr.nk().b(new a.C0052a(6))));
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private boolean bOJ() {
        return com.baidu.tbadk.core.sharedPref.b.aFD().getBoolean(bOL(), true);
    }

    private void bOK() {
        com.baidu.tbadk.core.sharedPref.b.aFD().putBoolean(bOL(), false);
    }

    private String bOL() {
        return "key_rec_pfirst_load_" + TbadkCoreApplication.getCurrentAccount() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + TbConfig.getVersion();
    }

    public void setRecommendFrsNavigationAnimDispatcher(z zVar) {
        if (zVar != null) {
            this.dHb = zVar.aSp();
            this.duf = zVar.aSq();
        }
    }

    public void showFloatingView() {
        if (this.dHb != null) {
            this.dHb.hd(true);
        }
    }

    public void update() {
        com.baidu.tieba.homepage.framework.a.bNt().q(System.currentTimeMillis(), 1);
        this.mPn = 1;
        this.hcT = true;
        if (this.mDataList.size() == 0 && !bOJ()) {
            if (!this.gXq) {
                azY();
                return;
            }
            return;
        }
        azX();
    }

    public void bU(int i, int i2) {
        bj bjVar;
        if (!v.isEmpty(this.mDataList) && this.mDataList.size() > i) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            while (i < this.mDataList.size() && i <= i2) {
                if (this.mDataList.get(i).getType().getId() == bj.cRB.getId() && (bjVar = (bj) this.mDataList.get(i)) != null && bjVar.aCH() != null) {
                    arrayList.add(Long.valueOf(bjVar.aCH().live_id));
                    arrayList2.add(bjVar);
                }
                i++;
            }
            if (!v.isEmpty(arrayList)) {
                MessageManager.getInstance().sendMessage(new LiveRoomClosedQueryMessage(arrayList, arrayList2));
            }
        }
    }

    public void bOM() {
        if (this.gqP != null && !this.mIsBackground && this.hbM) {
            this.gqP.a(this.gqd, this.eke, this.gqI, true);
        }
        if (this.hcR) {
            if (this.gXi != null && !this.gXi.aHU()) {
                if (this.gVp) {
                    com.baidu.tieba.s.c.cKb().b(this.hcX, false);
                    if (mJ(false)) {
                        bV(3, this.hcN);
                    } else if (this.hcS > 0) {
                        bV(2, this.hcN);
                    }
                } else if (!this.gVp && this.hcN == 0) {
                    bV(2, 0);
                }
            }
            this.hcR = false;
            this.gVp = false;
            this.hcS = 0;
            if (this.hcT) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
            }
            this.hcT = false;
        }
    }

    public void bcg() {
        if (isLoading()) {
            com.baidu.tieba.homepage.framework.a.bNt().q(0L, 1);
        } else if (this.hcK != null) {
            bOO();
            this.mPn++;
            setIsLoading(true);
            this.hcK.z(this.mPn, (this.hcL == null || this.hcL.thread_list == null) ? 0 : this.hcL.thread_list.size(), mI(false), 0);
        }
    }

    public void a(boolean z, boolean z2, DataRes dataRes, int i, String str) {
        int size = (this.hcL == null || this.hcL.thread_list == null) ? 0 : this.hcL.thread_list.size();
        if (!z && i == 0 && dataRes != null && v.isEmpty(dataRes.thread_list)) {
            if (this.hcK != null) {
                this.hcK.bOH();
            }
            setIsLoading(false);
            if (this.gXi != null) {
                this.gXi.setRefreshing(false);
                return;
            }
            return;
        }
        if (i != 0 || dataRes == null || !a(true, z, z2, dataRes)) {
            this.hcR = false;
            if (this.mDataList.size() > 0) {
                if (this.hcK != null) {
                    this.hcK.onError(1, str);
                }
            } else if (this.hcK != null) {
                this.hcK.onError(2, str);
            }
        } else {
            bOK();
            if (this.hcK != null) {
                com.baidu.tbadk.core.sharedPref.b.aFD().putLong(SharedPrefConfig.RECOMMEND_FRS_REFRESH_TIME + TbadkCoreApplication.getCurrentAccount(), System.currentTimeMillis());
                this.hcK.onSuccess();
            }
            this.hcR = true;
            this.gVp = z;
            this.hcS = size;
            byJ();
        }
        setIsLoading(false);
        if (this.gXi != null) {
            g.e bON = bON();
            if (this.gXi.aHU() && bON != null) {
                this.gXi.c(bON);
            } else {
                this.gXi.setRefreshing(false);
            }
        }
    }

    private g.e bON() {
        int i;
        String feedText;
        if (this.hcR && this.gXi != null && this.gXi.aHU()) {
            int i2 = this.hcN;
            if (this.gVp) {
                com.baidu.tieba.s.c.cKb().b(this.hcX, false);
                if (mJ(false)) {
                    i = 3;
                } else {
                    i = this.hcS > 0 ? 2 : 0;
                }
            } else if (this.gVp || this.hcN != 0) {
                return null;
            } else {
                i2 = 0;
                i = 2;
            }
            if (this.hbR != null) {
                this.hcO.bFT();
            }
            if (this.hbR != null && this.hbR.getCurrentTabType() != 1) {
                this.hcO.hideTip();
                return null;
            } else if (!this.hcV) {
                this.hcO.hideTip();
                return null;
            } else {
                this.hcM = i;
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
                    this.gsO = 1000;
                } else {
                    this.gsO = 0;
                }
                return new g.e(feedText, this.gsO);
            }
        }
        return null;
    }

    public void mx(boolean z) {
        if (z) {
            this.hce.notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        if (this.gqP != null) {
            this.gqP.destroy();
        }
        if (this.hcO != null) {
            this.hcO.onDestroy();
        }
        if (this.hcJ != null) {
            this.hcJ.onDestroy();
        }
        if (this.gtd != null) {
            this.gtd.removeCallbacks(this.hdf);
        }
        MessageManager.getInstance().unRegisterTask(2016323);
        MessageManager.getInstance().unRegisterListener(this.gpW);
    }

    public void onPause() {
        c.d(this.gtd);
        vs(this.hde);
        if (this.hcQ != null) {
            this.hcQ.aRe();
        }
    }

    private void azX() {
        if (this.hcK != null) {
            this.hcK.N((this.hcL == null || this.hcL.thread_list == null || bOQ()) ? 0 : this.hcL.thread_list.size(), mI(true), 0);
        }
    }

    public int mI(boolean z) {
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
                if (!(mVar instanceof com.baidu.tieba.homepage.personalize.data.a) || mVar.getType() == AdvertAppInfo.cMM) {
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
                if ((mVar2 instanceof com.baidu.tieba.homepage.personalize.data.a) && mVar2.getType() != AdvertAppInfo.cMM) {
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
        this.gXq = true;
        if (dataRes != null) {
            if (a(false, true, true, dataRes) && !bOQ()) {
                if (this.hcK != null) {
                    this.hcK.onSuccess();
                    Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler() { // from class: com.baidu.tieba.homepage.personalize.e.27
                        @Override // android.os.MessageQueue.IdleHandler
                        public boolean queueIdle() {
                            e.this.aRj();
                            return false;
                        }
                    });
                    return;
                }
                return;
            }
            azX();
            return;
        }
        azX();
    }

    public void aRj() {
        long uY = com.baidu.tieba.homepage.framework.a.bNt().uY(1) + com.baidu.tieba.homepage.framework.a.bNt().getCreateTime();
        long uW = com.baidu.tieba.homepage.framework.a.bNt().uW(1);
        if (uW > 0) {
            uY = System.currentTimeMillis() - uW;
        }
        n.aRr().cj(uY);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.util.Set] */
    private void i(List<com.baidu.adp.widget.ListView.m> list, int i) {
        AdvertAppInfo bvy;
        AdvertAppInfo bvy2;
        if (!v.isEmpty(list)) {
            Set<com.baidu.adp.widget.ListView.m> Ia = com.baidu.tieba.recapp.report.a.Ia("NEWINDEX");
            HashSet hashSet = Ia == null ? new HashSet() : Ia;
            HashSet hashSet2 = new HashSet();
            for (com.baidu.adp.widget.ListView.m mVar : list) {
                if (mVar != null) {
                    for (com.baidu.adp.widget.ListView.m mVar2 : hashSet) {
                        if ((mVar instanceof com.baidu.tieba.card.data.d) && (bvy2 = ((com.baidu.tieba.card.data.d) mVar).bvy()) != null && mVar2 != null && (mVar2 instanceof AdvertAppInfo) && mVar2.hashCode() == bvy2.hashCode()) {
                            bvy2.advertAppContext = ((AdvertAppInfo) mVar2).advertAppContext;
                        }
                    }
                    if (mVar != null && (mVar instanceof com.baidu.tieba.card.data.d) && (bvy = ((com.baidu.tieba.card.data.d) mVar).bvy()) != null && bvy.advertAppContext == null) {
                        bvy.advertAppContext = new com.baidu.tbadk.core.data.c();
                        bvy.advertAppContext.page = "NEWINDEX";
                        bvy.advertAppContext.pn = this.mPn;
                        bvy.advertAppContext.extensionInfo = bvy.extensionInfo;
                        bvy.advertAppContext.Dn = false;
                        hashSet2.add(bvy);
                    }
                }
            }
            hashSet.addAll(hashSet2);
            com.baidu.tieba.recapp.report.a.b("NEWINDEX", hashSet);
            if (hashSet2.size() > 0) {
                com.baidu.tieba.s.c.cKb().b(this.hcX, com.baidu.tieba.s.a.b(PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE, "common_fill", true, hashSet2.size()));
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
        if (this.hcZ == 1) {
            if (z2 && (dataRes.thread_list.size() >= 6 || bOQ())) {
                bOP();
                this.hcL = null;
            }
        } else if (z2 && bOQ()) {
            this.hcL = null;
        }
        int size = z2 ? 0 : this.mDataList.size();
        DataRes.Builder builder = new DataRes.Builder(dataRes);
        this.mDataList.clear();
        com.baidu.tieba.homepage.personalize.model.c a2 = this.hcP.a(z, this.hcL, builder, z2 ? 0 : 1);
        if (a2 == null) {
            list = null;
            i = 0;
        } else {
            List<com.baidu.adp.widget.ListView.m> list2 = a2.dTr;
            this.hcN = a2.hfp;
            int i2 = a2.hfq;
            a2.hfq = 0;
            list = list2;
            i = i2;
        }
        if (list != null) {
            this.mDataList.addAll(list);
            i(list, size);
            a(z2 ? 0 : 1, list, size);
            if (this.hcT) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
            }
        }
        if (this.hcL == null) {
            this.hcL = builder;
            this.hcJ.cC(this.hcL.thread_list);
        }
        if (this.mDataList.size() == 0) {
            z4 = false;
        } else {
            if (z2) {
                if (dataRes.live_answer != null) {
                    this.hcU = new com.baidu.tieba.homepage.personalize.data.f();
                    this.hcU.a(dataRes.live_answer);
                    this.hcL.live_answer = dataRes.live_answer;
                } else if (z) {
                    this.hcU = null;
                    this.hcL.live_answer = null;
                }
                this.hcW = dataRes.float_info;
                this.hcL.float_info = dataRes.float_info;
            }
            long j = com.baidu.tbadk.core.sharedPref.b.aFD().getLong("key_maintab_banner_close_time", 0L);
            if (this.hcU != null && !aq.isTaday(j)) {
                this.mDataList.add(0, this.hcU);
            }
            LinkedList linkedList = new LinkedList(this.mDataList);
            this.hce.setFromCDN(dataRes.is_new_url.intValue() == 1);
            this.hce.j(linkedList, i);
            z4 = true;
            if (this.gqP != null && this.hbM) {
                this.gqP.a(this.gqd, this.eke, this.gqI, true);
            }
        }
        com.baidu.tieba.homepage.framework.a.bNt().o(System.currentTimeMillis() - currentTimeMillis, 1);
        long uZ = com.baidu.tieba.homepage.framework.a.bNt().uZ(1);
        if (uZ > 0) {
            com.baidu.tieba.homepage.framework.a.bNt().p(System.currentTimeMillis() - uZ, 1);
            com.baidu.tieba.homepage.framework.a.bNt().q(0L, 1);
        }
        if (dataRes.anti != null && dataRes.anti.block_pop_info != null) {
            com.baidu.tieba.ueg.d.d(dataRes.anti.block_pop_info);
        }
        ay ayVar = new ay();
        ayVar.a(dataRes.recom_post_topic);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_REFRESH_TOPIC_TIP, ayVar));
        return z4;
    }

    private void bOO() {
        List<com.baidu.adp.widget.ListView.m> list;
        int i;
        if (v.getCount(this.mDataList) >= this.hcP.bPj() - 40) {
            com.baidu.tieba.homepage.personalize.model.c a2 = this.hcP.a(true, this.hcL, (DataRes.Builder) null, 1);
            if (a2 != null) {
                List<com.baidu.adp.widget.ListView.m> list2 = a2.dTr;
                i = a2.hfq;
                a2.hfq = 0;
                list = list2;
            } else {
                list = null;
                i = 0;
            }
            if (list != null) {
                this.mDataList.clear();
                this.mDataList.addAll(list);
                this.hce.j(new LinkedList(this.mDataList), i);
            }
        }
    }

    private void azY() {
        this.gXq = true;
        ac.a(new com.baidu.tbadk.util.ab<DataRes>() { // from class: com.baidu.tieba.homepage.personalize.e.28
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.ab
            /* renamed from: bOV */
            public DataRes doInBackground() {
                com.baidu.adp.lib.cache.l<byte[]> cq = com.baidu.tbadk.core.c.a.aEB().cq("tb.rec_frs_update", TbadkCoreApplication.getCurrentAccount());
                if (cq == null) {
                    return null;
                }
                byte[] bArr = cq.get("0");
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

    private void byJ() {
        if (this.hcL != null) {
            DataRes.Builder builder = new DataRes.Builder(this.hcL.build(true));
            if (builder.thread_list != null && builder.thread_list.size() > 30) {
                builder.thread_list = builder.thread_list.subList(0, 30);
            }
            a(builder, builder.thread_list != null ? builder.thread_list.size() : 0);
            a(builder);
        }
    }

    private void bOP() {
        if (this.hcL != null) {
            final DataRes.Builder builder = new DataRes.Builder(this.hcL.build(true));
            if (builder.thread_list != null && builder.thread_list.size() > 50) {
                builder.thread_list = builder.thread_list.subList(0, 50);
            }
            a(builder, builder.thread_list != null ? builder.thread_list.size() : 0);
            ac.a(new com.baidu.tbadk.util.ab<Object>() { // from class: com.baidu.tieba.homepage.personalize.e.3
                @Override // com.baidu.tbadk.util.ab
                public Object doInBackground() {
                    DataRes.Builder builder2 = new DataRes.Builder(builder.build(true));
                    e.this.hcJ.cD(builder2.thread_list);
                    try {
                        com.baidu.tbadk.core.c.a.aEB().cq("tb.rec_old_data", TbadkCoreApplication.getCurrentAccount()).setForever("0", builder2.build(true).toByteArray());
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
    public void Ck(String str) {
        if (!TextUtils.isEmpty(str) && this.hcL != null && this.hcL.banner_list != null && this.hcL.banner_list.app != null && this.hcL.banner_list.app.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (App app : this.hcL.banner_list.app) {
                if (app != null && str.equals(app.id)) {
                    arrayList.add(app);
                }
            }
            BannerList.Builder builder = new BannerList.Builder(this.hcL.banner_list);
            if (builder.app != null) {
                builder.app.removeAll(arrayList);
            }
            this.hcL.banner_list = builder.build(false);
            DataRes.Builder builder2 = new DataRes.Builder(this.hcL.build(true));
            builder2.banner_list = builder.build(true);
            a(builder2);
        }
    }

    private void a(final DataRes.Builder builder) {
        ac.a(new com.baidu.tbadk.util.ab<Object>() { // from class: com.baidu.tieba.homepage.personalize.e.4
            @Override // com.baidu.tbadk.util.ab
            public Object doInBackground() {
                DataRes.Builder builder2 = new DataRes.Builder(builder.build(true));
                e.this.hcJ.cD(builder2.thread_list);
                try {
                    com.baidu.tbadk.core.c.a.aEB().cq("tb.rec_frs_update", TbadkCoreApplication.getCurrentAccount()).setForever("0", builder2.build(true).toByteArray());
                    return null;
                } catch (Exception e) {
                    BdLog.e(e);
                    return null;
                }
            }
        }, null);
    }

    private boolean bOQ() {
        return mJ(true);
    }

    private boolean mJ(boolean z) {
        long j = com.baidu.tbadk.core.sharedPref.b.aFD().getLong(SharedPrefConfig.RECOMMEND_FRS_REFRESH_TIME + TbadkCoreApplication.getCurrentAccount(), 0L);
        return j == 0 ? z : Math.abs(System.currentTimeMillis() - j) > this.hcI;
    }

    public void a(a aVar) {
        this.hcK = aVar;
    }

    private boolean isLoading() {
        return this.mIsLoading;
    }

    private void setIsLoading(boolean z) {
        this.mIsLoading = z;
    }

    public void bOE() {
        boolean z = true;
        com.baidu.tbadk.coreExtra.data.b activityPrizeData = TbadkCoreApplication.getInst().getActivityPrizeData();
        if (activityPrizeData.isSwitchTurn() && !StringUtils.isNull(activityPrizeData.getFeedText())) {
            String currentDay = UtilHelper.getCurrentDay();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            String str = "";
            if (!StringUtils.isNull(currentAccount)) {
                String string = com.baidu.tbadk.core.sharedPref.b.aFD().getString(SharedPrefConfig.ACTIVITY_PRIZE_FEED_TEXT_TIME, "");
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
                    com.baidu.tbadk.core.sharedPref.b.aFD().putString(SharedPrefConfig.ACTIVITY_PRIZE_FEED_TEXT_TIME, str);
                }
            }
        }
    }

    private void bV(int i, int i2) {
        if (this.hbR != null) {
            this.hcO.bFT();
        }
        if (this.hbR != null && this.hbR.getCurrentTabType() != 1) {
            this.hcO.hideTip();
        } else if (!this.hcV) {
            this.hcO.hideTip();
        } else {
            this.hcM = i;
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
                    this.gsO = 3000;
                } else {
                    this.gsO = 2000;
                }
                this.hcY.dhk = str;
                this.hcY.gsH = this.gsO;
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 49;
                if (this.hbR != null) {
                    FrameLayout frameLayout = this.hbR.getFrameLayout();
                    frameLayout.removeView(this.hcY);
                    frameLayout.addView(this.hcY, layoutParams);
                    this.hcY.bFR();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(Long l) {
        if (this.hcL != null && this.hcL.thread_list != null) {
            List<ThreadInfo> list = this.hcL.thread_list;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                ThreadInfo threadInfo = list.get(i);
                if (threadInfo.tid.equals(l) && threadInfo.top_agree_post != null) {
                    ThreadInfo.Builder builder = new ThreadInfo.Builder(threadInfo);
                    builder.top_agree_post = null;
                    list.set(i, builder.build(true));
                    byJ();
                    a(false, true, false, this.hcL.build(true));
                    return;
                }
            }
        }
    }

    public void m(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.hcX = bdUniqueId;
            if (this.gFA != null) {
                this.gFA.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.gFA);
            }
            if (this.hdb != null) {
                this.hdb.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.hdb);
            }
            this.dag.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.dag);
            this.hdc.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.hdc);
            this.gHL.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.gHL);
            this.gHM.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.gHM);
            this.gFN.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.gFN);
            if (this.gqP != null) {
                this.gqP.setUniqueId(bdUniqueId);
            }
            this.hcJ.j(bdUniqueId);
            this.hdh.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.hdh);
            this.gpV.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.gpV);
            this.hdi.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.hdi);
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
                        com.baidu.adp.lib.cache.l<byte[]> cq = com.baidu.tbadk.core.c.a.aEB().cq("tb.rec_frs_update", TbadkCoreApplication.getCurrentAccount());
                        if (cq == null) {
                            return false;
                        }
                        byte[] bArr = cq.get("0");
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
                        e.this.hcJ.cD(builder5.thread_list);
                        cq.setForever("0", builder5.build(true).toByteArray());
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

    public void bOR() {
        this.gov = new com.baidu.tieba.tbadkCore.data.f("new_index", null);
        this.gov.cKI();
    }

    public void a(int i, List<com.baidu.adp.widget.ListView.m> list, int i2) {
        int i3;
        int i4;
        if (this.gov != null) {
            if (i == 0) {
                this.gov.cKI();
            }
            if (list != null && !list.isEmpty()) {
                int[] iArr = com.baidu.tieba.tbadkCore.data.f.kgg;
                int i5 = 0;
                int i6 = 0;
                int i7 = 0;
                while (i7 < list.size() && i6 < iArr.length && (i3 = iArr[i6]) >= 0) {
                    if (list.get(i7) instanceof com.baidu.tieba.card.data.c) {
                        i4 = i5 + 1;
                        if (i4 == i3 - 1) {
                            if (i2 < i7 + 1) {
                                this.gov.cJ(i3, i7 + 1);
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

    public void vr(int i) {
        if ((this.gov != null ? this.gov.Ct(i) : -1) >= 0 && this.gtd != null && this.gtd.getData() != null && this.gtd.getData().size() > i) {
            this.gov.Cu(i);
        }
    }

    public m bEL() {
        return this.gqP;
    }

    public void mD(boolean z) {
        this.hbM = z;
    }

    public void vs(final int i) {
        ac.a(new com.baidu.tbadk.util.ab<Object>() { // from class: com.baidu.tieba.homepage.personalize.e.10
            @Override // com.baidu.tbadk.util.ab
            public Object doInBackground() {
                com.baidu.adp.lib.cache.l<String> cr = com.baidu.tbadk.core.c.a.aEB().cr(e.this.hdd, TbadkCoreApplication.getCurrentAccount());
                if (cr != null) {
                    cr.set(e.this.hdd, Integer.toString(i), 43200000L);
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
            /* renamed from: bOU */
            public String doInBackground() {
                com.baidu.adp.lib.cache.l<String> cr = com.baidu.tbadk.core.c.a.aEB().cr(e.this.hdd, TbadkCoreApplication.getCurrentAccount());
                if (cr != null) {
                    return cr.get(e.this.hdd);
                }
                return null;
            }
        }, new com.baidu.tbadk.util.l<String>() { // from class: com.baidu.tieba.homepage.personalize.e.14
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.l
            /* renamed from: Cl */
            public void onReturnDataInUI(String str) {
                if (dVar != null) {
                    dVar.va(com.baidu.adp.lib.f.b.toInt(str, 0));
                }
            }
        });
    }

    public void bOF() {
        c.e(this.gtd);
    }

    public void bOS() {
        a(this.hdg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(CustomResponsedMessage<?> customResponsedMessage) {
        boolean z;
        String str;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.hcL != null && v.getCount(this.hcL.thread_list) != 0 && v.getCount(this.mDataList) != 0) {
            JSONObject jSONObject = (JSONObject) customResponsedMessage.getData();
            String optString = jSONObject.optString("tid");
            if (StringUtils.isNull(optString)) {
                String optString2 = jSONObject.optString("liveid");
                if (this.gtd != null && !TextUtils.isEmpty(optString2)) {
                    int i = 0;
                    while (true) {
                        if (i >= this.gtd.getCount()) {
                            str = optString;
                            break;
                        }
                        com.baidu.adp.widget.ListView.m item = this.gtd.getItem(i);
                        if (item instanceof com.baidu.tieba.card.data.j) {
                            com.baidu.tieba.card.data.j jVar = (com.baidu.tieba.card.data.j) item;
                            if (jVar.aAg() != null && jVar.aAg().aCH() != null && optString2.equals(String.valueOf(jVar.aAg().aCH().live_id))) {
                                str = jVar.aAg().getTid();
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
                    if (cVar.aAg() != null && cVar.aAg().getTid() != null) {
                        if (cVar.aAg().getTid().equals(optString)) {
                            it.remove();
                            z = true;
                            z2 = z;
                        } else if (z2) {
                            com.baidu.tieba.homepage.personalize.model.b.cF(this.mDataList);
                            break;
                        }
                    }
                }
                z = z2;
                z2 = z;
            }
            if (this.hcL != null && this.hcL.thread_list != null) {
                long j = com.baidu.adp.lib.f.b.toLong(optString, 0L);
                int i2 = 0;
                while (true) {
                    if (i2 < this.hcL.thread_list.size()) {
                        ThreadInfo threadInfo = this.hcL.thread_list.get(i2);
                        if (threadInfo == null || threadInfo.tid == null || threadInfo.tid.longValue() != j) {
                            i2++;
                        } else {
                            this.hcL.thread_list.remove(i2);
                            byJ();
                            com.baidu.tieba.homepage.personalize.b.d.a(threadInfo.tid.longValue(), i2, this.hcL.thread_list, this.mDataList);
                            break;
                        }
                    } else {
                        break;
                    }
                }
                if (this.gtd != null) {
                    List<Integer> b = b(optString, this.gtd);
                    int intValue = b.get(0).intValue();
                    int intValue2 = b.get(1).intValue();
                    if (intValue != -1 && intValue2 != -1) {
                        this.gtd.m(intValue, intValue2);
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
                    if (cVar.aAg() != null && cVar.aAg().getTid().equals(str)) {
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
                    advertAppInfo = ((com.baidu.tieba.homepage.personalize.data.a) next).bvy();
                } else {
                    if (next instanceof ae) {
                        ae aeVar = (ae) next;
                        if (aeVar.aAM() instanceof AdvertAppInfo.ILegoAdvert) {
                            advertAppInfo = ((AdvertAppInfo.ILegoAdvert) aeVar.aAM()).getAdvertAppInfo();
                        }
                    }
                    advertAppInfo = advertAppInfo2;
                }
                if (advertAppInfo != null && str.equals(advertAppInfo.cMX)) {
                    it.remove();
                    advertAppInfo = null;
                }
                advertAppInfo2 = advertAppInfo;
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (this.hcY != null) {
            this.hcY.onChangeSkinType(i);
        }
    }

    public FloatInfo bOT() {
        return this.hcW;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public af bOr() {
        if (this.gqP == null || this.gqP.cyJ() == null || !(this.gqP.cyJ().getTag() instanceof af)) {
            return null;
        }
        return (af) this.gqP.cyJ().getTag();
    }
}
