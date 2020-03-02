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
    private y dGO;
    private View.OnTouchListener dtS;
    private com.baidu.tieba.f.a gMq;
    private boolean gVd;
    private final BigdaySwipeRefreshLayout gWW;
    private com.baidu.tieba.tbadkCore.data.f goi;
    private m gqC;
    private final BdTypeRecyclerView gsQ;
    private ScrollFragmentTabHost hbF;
    private final ab hbS;
    private ar hcC;
    private final com.baidu.tieba.homepage.personalize.model.a hcD;
    private int hcG;
    private com.baidu.tieba.homepage.personalize.data.f hcI;
    private BdUniqueId hcL;
    private SmartBubbleAnimatedView hcM;
    private int hcN;
    private Runnable hcT;
    private final long hcw;
    private final b hcx;
    private DataRes.Builder hcz;
    private final TbPageContext<?> mPageContext;
    private a hcy = null;
    private final List<com.baidu.adp.widget.ListView.m> mDataList = new LinkedList();
    private int mPn = 1;
    private boolean mIsLoading = false;
    private boolean gXe = false;
    private int hcA = 2;
    private int hcB = 0;
    private TextView mTipView = null;
    private int gsB = 2000;
    private com.baidu.tbadk.n.c hcE = null;
    private boolean gqv = false;
    private int gpQ = 0;
    private int ejR = 0;
    private boolean mIsBackground = false;
    private boolean hbA = true;
    private boolean hcF = false;
    private boolean hcH = false;
    private boolean hcJ = true;
    private FloatInfo hcK = null;
    private a.C0052a goA = new a.C0052a(2);
    private RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.e.12
        private int hdc = -1;
        private int gXm = 0;
        private boolean hdd = false;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (e.this.hcE == null) {
                e.this.hcE = new com.baidu.tbadk.n.c();
                e.this.hcE.setSubType(1005);
                e.this.hcE.pageType = 1;
            }
            if (e.this.dGO != null && !e.this.mIsBackground) {
                e.this.dGO.l(recyclerView, i);
            }
            if (i == 0) {
                c.d(e.this.gsQ);
                e.this.hcE.aRc();
                r.bvg().ib(true);
                com.baidu.tieba.a.d.aXF().cv("page_recommend", "show_");
                com.baidu.tieba.s.c.cKa().b(e.this.hcL, false);
                this.hdd = false;
                if (e.this.gqC != null && e.this.hbA && !e.this.mIsBackground) {
                    e.this.gqC.a(e.this.gpQ, e.this.ejR, e.this.gqv, 1);
                    return;
                }
                return;
            }
            e.this.hcE.aRb();
            if (i == 1) {
                if (e.this.hcC != null) {
                    e.this.hcC.hideTip();
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
            if (this.gXm > i) {
                this.hdd = true;
            }
            if (e.this.dGO != null && !e.this.mIsBackground) {
                e.this.dGO.onScroll(this.gXm, i);
            }
            this.gXm = i;
            int i3 = (i + i2) - 1;
            if (!this.hdd && this.hdc != i3) {
                this.hdc = i3;
                e.this.vr(this.hdc);
            }
            if (this.hdd && this.hdc != i) {
                this.hdc = i;
                e.this.vr(this.hdc);
            }
            e.this.hcS = i;
            e.this.gpQ = i;
            e.this.ejR = (i + i2) - 1;
            af bOq = e.this.bOq();
            if (bOq != null && bOq.nk() != null) {
                bOq.nk().b(e.this.goA);
            }
        }
    };
    private View.OnTouchListener drA = new View.OnTouchListener() { // from class: com.baidu.tieba.homepage.personalize.e.22
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (e.this.dtS != null) {
                e.this.dtS.onTouch(view, motionEvent);
            }
            if (e.this.gMq != null) {
                e.this.gMq.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private a.InterfaceC0499a fRz = new a.InterfaceC0499a() { // from class: com.baidu.tieba.homepage.personalize.e.23
        @Override // com.baidu.tieba.f.a.InterfaceC0499a
        public void z(int i, int i2) {
            e.this.gqv = false;
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0499a
        public void A(int i, int i2) {
            e.this.gqv = true;
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0499a
        public void bA(int i, int i2) {
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0499a
        public void B(int i, int i2) {
        }
    };
    private View.OnClickListener hcO = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.e.24
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (e.this.hcC != null) {
                e.this.hcC.hideTip();
            }
        }
    };
    private final CustomMessageListener hcP = new CustomMessageListener(CmdConfigCustom.CMD_RELOAD_HP_PERSONALIZED) { // from class: com.baidu.tieba.homepage.personalize.e.25
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (e.this.gsQ != null) {
                e.this.gqC.bOp();
                e.this.hbA = false;
                e.this.gWW.setRefreshing(true);
            }
        }
    };
    private CustomMessageListener gFo = new CustomMessageListener(CmdConfigCustom.PB_ACTION_PRAISE) { // from class: com.baidu.tieba.homepage.personalize.e.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            bj bjVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bj) && e.this.hcz != null && v.getCount(e.this.hcz.thread_list) != 0 && (bjVar = (bj) customResponsedMessage.getData()) != null && bjVar.aBZ() != null && bjVar.getId() != null && v.getCount(e.this.hcz.thread_list) != 0) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < e.this.hcz.thread_list.size()) {
                        ThreadInfo threadInfo = e.this.hcz.thread_list.get(i2);
                        if (threadInfo == null || threadInfo.id.longValue() != com.baidu.adp.lib.f.b.toLong(bjVar.getId(), -1L)) {
                            i = i2 + 1;
                        } else {
                            ThreadInfo.Builder builder = new ThreadInfo.Builder(threadInfo);
                            Zan.Builder builder2 = new Zan.Builder(builder.zan);
                            builder2.num = Integer.valueOf((int) bjVar.aBZ().getNum());
                            builder.zan = builder2.build(true);
                            e.this.hcz.thread_list.set(i2, builder.build(true));
                            return;
                        }
                    } else {
                        return;
                    }
                }
            }
        }
    };
    private CustomMessageListener hcQ = new CustomMessageListener(CmdConfigCustom.CMD_LIVE_VIDEO_CLOSED_QUERY_RESPONSED) { // from class: com.baidu.tieba.homepage.personalize.e.6
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
                    if (e.this.hbS != null) {
                        e.this.hbS.ac(new ArrayList(e.this.mDataList));
                    }
                }
            }
        }
    };
    private CustomMessageListener daf = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.homepage.personalize.e.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int intValue;
            if ((customResponsedMessage instanceof UpdateAttentionMessage) && e.this.hcz != null && !v.isEmpty(e.this.hcz.thread_list)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid)) {
                    int i = 0;
                    while (true) {
                        if (i >= e.this.hcz.thread_list.size()) {
                            break;
                        }
                        ThreadInfo threadInfo = e.this.hcz.thread_list.get(i);
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
                            e.this.hcz.thread_list.set(i, builder.build(true));
                        }
                    }
                    e.this.a(updateAttentionMessage);
                }
            }
        }
    };
    private String hcR = "lastReadReadPositionKey";
    private int hcS = 0;
    private d hcU = new d() { // from class: com.baidu.tieba.homepage.personalize.e.11
        @Override // com.baidu.tieba.homepage.personalize.d
        public void va(final int i) {
            if (e.this.hcT == null) {
                e.this.hcT = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.e.11.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (e.this.gsQ.getHandler() != null) {
                            e.this.gsQ.requestFocusFromTouch();
                            if (i <= e.this.gsQ.getCount() - 1) {
                                e.this.gsQ.setSelection(i);
                            }
                        }
                    }
                };
            }
            e.this.gsQ.removeCallbacks(e.this.hcT);
            e.this.gsQ.post(e.this.hcT);
        }
    };
    private CustomMessageListener hcV = new CustomMessageListener(2016569) { // from class: com.baidu.tieba.homepage.personalize.e.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && e.this.hcI != null) {
                e.this.mDataList.remove(e.this.hcI);
                e.this.hbS.ac(new ArrayList(e.this.mDataList));
                com.baidu.tbadk.core.sharedPref.b.aFD().putLong("key_maintab_banner_close_time", System.currentTimeMillis());
            }
        }
    };
    private CustomMessageListener gHz = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.homepage.personalize.e.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.h(customResponsedMessage);
            if (e.this.gqC != null && e.this.hbA) {
                e.this.gqC.a(e.this.gpQ, e.this.ejR, e.this.gqv, true);
            }
        }
    };
    private CustomMessageListener gHA = new CustomMessageListener(CmdConfigCustom.CMD_THREAD_NOT_EXIST_WHEN_ENTER_PB) { // from class: com.baidu.tieba.homepage.personalize.e.17
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.h(customResponsedMessage);
        }
    };
    private CustomMessageListener gFB = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.homepage.personalize.e.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && e.this.hcz != null && v.getCount(e.this.hcz.thread_list) != 0) {
                String str = (String) customResponsedMessage.getData();
                e.this.h(str, e.this.mDataList);
                e.this.Cj(str);
                if (e.this.hbS != null) {
                    e.this.hbS.ac(new ArrayList(e.this.mDataList));
                }
                if (e.this.gqC != null && e.this.hbA) {
                    e.this.gqC.a(e.this.gpQ, e.this.ejR, e.this.gqv, true);
                }
            }
        }
    };
    private CustomMessageListener gpI = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.homepage.personalize.e.19
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            af bOq;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent)) {
                KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24 && (bOq = e.this.bOq()) != null && bOq.nk() != null) {
                    bOq.nk().b(new a.C0052a(3));
                }
            }
        }
    };
    private com.baidu.adp.framework.listener.a hcW = new com.baidu.adp.framework.listener.a(1003065, CmdConfigSocket.CMD_TOPIC_BLESS) { // from class: com.baidu.tieba.homepage.personalize.e.20
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
                        if ((mVar instanceof com.baidu.tieba.homepage.topic.topictab.b.a) && (bVar = ((com.baidu.tieba.homepage.topic.topictab.b.a) mVar).hhy) != null && longValue == bVar.pkId) {
                            bVar.userPkId = j2;
                            return;
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener gpJ = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.homepage.personalize.e.21
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int[] imageWidthAndHeight;
            List<com.baidu.adp.widget.ListView.m> dataList = e.this.hbS.getDataList();
            if (!v.isEmpty(dataList)) {
                for (com.baidu.adp.widget.ListView.m mVar : dataList) {
                    if (mVar instanceof k) {
                        k kVar = (k) mVar;
                        if (kVar.cRg != 0 && kVar.cRf != null) {
                            if ((TbSingleton.getInstance().getHomePageStyleAbTest() & 4) != 0) {
                                imageWidthAndHeight = kVar.cRf.aEe();
                            } else {
                                imageWidthAndHeight = kVar.cRf.getImageWidthAndHeight();
                            }
                            kVar.cRg = imageWidthAndHeight[0];
                            kVar.cRh = imageWidthAndHeight[1];
                        }
                    }
                }
            }
            com.baidu.adp.lib.f.e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.personalize.e.21.1
                @Override // java.lang.Runnable
                public void run() {
                    e.this.hbS.notifyDataSetChanged();
                    if (!e.this.mIsBackground && e.this.hbA) {
                        e.this.gqC.a(e.this.gpQ, e.this.ejR, e.this.gqv, true);
                    }
                }
            }, 500L);
        }
    };

    /* loaded from: classes9.dex */
    public interface a {
        void N(int i, int i2, int i3);

        void bOG();

        void onError(int i, String str);

        void onSuccess();

        void z(int i, int i2, int i3, int i4);
    }

    public void mH(boolean z) {
        this.hcJ = z;
        if (this.hcC != null && !z) {
            this.hcC.hideTip();
        }
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.hbF = scrollFragmentTabHost;
        if (this.hbF != null) {
            this.hbF.setOnTabSelectedListener(new ScrollFragmentTabHost.b() { // from class: com.baidu.tieba.homepage.personalize.e.1
                @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.b
                public void vk(int i) {
                    if (e.this.hbF.vj(i) != 1 && e.this.hcC != null) {
                        e.this.hcC.hideTip();
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
        if (this.hbF != null) {
            this.hbF.lt(z);
        }
        if (this.gqC != null) {
            this.gqC.oB(!z);
            af bOq = bOq();
            if (bOq != null && bOq.nk() != null) {
                z2 = bOq.nk().b(new a.C0052a(8, Boolean.valueOf(z)));
            }
            if (!z2) {
                if (z) {
                    this.gqC.bOp();
                } else if (this.hbA) {
                    this.gqC.a(this.gpQ, this.ejR, this.gqv, true);
                }
            }
        }
    }

    public e(TbPageContext<?> tbPageContext, BdTypeRecyclerView bdTypeRecyclerView, ab abVar, BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout) {
        this.hcN = 0;
        this.mPageContext = tbPageContext;
        this.hcN = com.baidu.tbadk.core.sharedPref.b.aFD().getInt("key_personalized_refresh_type", 0);
        this.gWW = bigdaySwipeRefreshLayout;
        this.gsQ = bdTypeRecyclerView;
        this.gsQ.setOnTouchListener(this.drA);
        this.gMq = new com.baidu.tieba.f.a();
        this.gMq.a(this.fRz);
        this.hbS = abVar;
        this.hcD = new com.baidu.tieba.homepage.personalize.model.a();
        this.hcw = com.baidu.tbadk.core.sharedPref.b.aFD().getLong("recommend_frs_cache_time", 3600L) * 1000;
        bdTypeRecyclerView.setOnScrollListener(this.mOnScrollListener);
        this.hcC = new ar();
        bOQ();
        this.gqC = new m(this.mPageContext, this.gsQ);
        this.gqC.Ar(1);
        this.gqC.Aq(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.hcx = new b(this.mDataList, this.hbS);
        this.hcM = new SmartBubbleAnimatedView(tbPageContext.getContext());
        this.hcM.setLayoutParams(new FrameLayout.LayoutParams(-1, l.getDimens(tbPageContext.getContext(), R.dimen.tbds83)));
        bOH();
        this.gpJ.setTag(this.mPageContext.getUniqueId());
        MessageManager.getInstance().registerListener(this.gpJ);
    }

    private void bOH() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2016323, new CustomMessageTask.CustomRunnable<Boolean>() { // from class: com.baidu.tieba.homepage.personalize.e.26
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Boolean> customMessage) {
                af bOq = e.this.bOq();
                return (bOq == null || bOq.nk() == null) ? new CustomResponsedMessage<>(2016323, false) : new CustomResponsedMessage<>(2016323, Boolean.valueOf(bOq.nk().b(new a.C0052a(6))));
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private boolean bOI() {
        return com.baidu.tbadk.core.sharedPref.b.aFD().getBoolean(bOK(), true);
    }

    private void bOJ() {
        com.baidu.tbadk.core.sharedPref.b.aFD().putBoolean(bOK(), false);
    }

    private String bOK() {
        return "key_rec_pfirst_load_" + TbadkCoreApplication.getCurrentAccount() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + TbConfig.getVersion();
    }

    public void setRecommendFrsNavigationAnimDispatcher(z zVar) {
        if (zVar != null) {
            this.dGO = zVar.aSo();
            this.dtS = zVar.aSp();
        }
    }

    public void showFloatingView() {
        if (this.dGO != null) {
            this.dGO.hd(true);
        }
    }

    public void update() {
        com.baidu.tieba.homepage.framework.a.bNs().q(System.currentTimeMillis(), 1);
        this.mPn = 1;
        this.hcH = true;
        if (this.mDataList.size() == 0 && !bOI()) {
            if (!this.gXe) {
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
                if (this.mDataList.get(i).getType().getId() == bj.cRA.getId() && (bjVar = (bj) this.mDataList.get(i)) != null && bjVar.aCH() != null) {
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

    public void bOL() {
        if (this.gqC != null && !this.mIsBackground && this.hbA) {
            this.gqC.a(this.gpQ, this.ejR, this.gqv, true);
        }
        if (this.hcF) {
            if (this.gWW != null && !this.gWW.aHT()) {
                if (this.gVd) {
                    com.baidu.tieba.s.c.cKa().b(this.hcL, false);
                    if (mJ(false)) {
                        bV(3, this.hcB);
                    } else if (this.hcG > 0) {
                        bV(2, this.hcB);
                    }
                } else if (!this.gVd && this.hcB == 0) {
                    bV(2, 0);
                }
            }
            this.hcF = false;
            this.gVd = false;
            this.hcG = 0;
            if (this.hcH) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
            }
            this.hcH = false;
        }
    }

    public void bcf() {
        if (isLoading()) {
            com.baidu.tieba.homepage.framework.a.bNs().q(0L, 1);
        } else if (this.hcy != null) {
            bON();
            this.mPn++;
            setIsLoading(true);
            this.hcy.z(this.mPn, (this.hcz == null || this.hcz.thread_list == null) ? 0 : this.hcz.thread_list.size(), mI(false), 0);
        }
    }

    public void a(boolean z, boolean z2, DataRes dataRes, int i, String str) {
        int size = (this.hcz == null || this.hcz.thread_list == null) ? 0 : this.hcz.thread_list.size();
        if (!z && i == 0 && dataRes != null && v.isEmpty(dataRes.thread_list)) {
            if (this.hcy != null) {
                this.hcy.bOG();
            }
            setIsLoading(false);
            if (this.gWW != null) {
                this.gWW.setRefreshing(false);
                return;
            }
            return;
        }
        if (i != 0 || dataRes == null || !a(true, z, z2, dataRes)) {
            this.hcF = false;
            if (this.mDataList.size() > 0) {
                if (this.hcy != null) {
                    this.hcy.onError(1, str);
                }
            } else if (this.hcy != null) {
                this.hcy.onError(2, str);
            }
        } else {
            bOJ();
            if (this.hcy != null) {
                com.baidu.tbadk.core.sharedPref.b.aFD().putLong(SharedPrefConfig.RECOMMEND_FRS_REFRESH_TIME + TbadkCoreApplication.getCurrentAccount(), System.currentTimeMillis());
                this.hcy.onSuccess();
            }
            this.hcF = true;
            this.gVd = z;
            this.hcG = size;
            byI();
        }
        setIsLoading(false);
        if (this.gWW != null) {
            g.e bOM = bOM();
            if (this.gWW.aHT() && bOM != null) {
                this.gWW.c(bOM);
            } else {
                this.gWW.setRefreshing(false);
            }
        }
    }

    private g.e bOM() {
        int i;
        String feedText;
        if (this.hcF && this.gWW != null && this.gWW.aHT()) {
            int i2 = this.hcB;
            if (this.gVd) {
                com.baidu.tieba.s.c.cKa().b(this.hcL, false);
                if (mJ(false)) {
                    i = 3;
                } else {
                    i = this.hcG > 0 ? 2 : 0;
                }
            } else if (this.gVd || this.hcB != 0) {
                return null;
            } else {
                i2 = 0;
                i = 2;
            }
            if (this.hbF != null) {
                this.hcC.bFS();
            }
            if (this.hbF != null && this.hbF.getCurrentTabType() != 1) {
                this.hcC.hideTip();
                return null;
            } else if (!this.hcJ) {
                this.hcC.hideTip();
                return null;
            } else {
                this.hcA = i;
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
                    this.gsB = 1000;
                } else {
                    this.gsB = 0;
                }
                return new g.e(feedText, this.gsB);
            }
        }
        return null;
    }

    public void mx(boolean z) {
        if (z) {
            this.hbS.notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        if (this.gqC != null) {
            this.gqC.destroy();
        }
        if (this.hcC != null) {
            this.hcC.onDestroy();
        }
        if (this.hcx != null) {
            this.hcx.onDestroy();
        }
        if (this.gsQ != null) {
            this.gsQ.removeCallbacks(this.hcT);
        }
        MessageManager.getInstance().unRegisterTask(2016323);
        MessageManager.getInstance().unRegisterListener(this.gpJ);
    }

    public void onPause() {
        c.d(this.gsQ);
        vs(this.hcS);
        if (this.hcE != null) {
            this.hcE.aRd();
        }
    }

    private void azX() {
        if (this.hcy != null) {
            this.hcy.N((this.hcz == null || this.hcz.thread_list == null || bOP()) ? 0 : this.hcz.thread_list.size(), mI(true), 0);
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
                if (!(mVar instanceof com.baidu.tieba.homepage.personalize.data.a) || mVar.getType() == AdvertAppInfo.cML) {
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
                if ((mVar2 instanceof com.baidu.tieba.homepage.personalize.data.a) && mVar2.getType() != AdvertAppInfo.cML) {
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
        this.gXe = true;
        if (dataRes != null) {
            if (a(false, true, true, dataRes) && !bOP()) {
                if (this.hcy != null) {
                    this.hcy.onSuccess();
                    Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler() { // from class: com.baidu.tieba.homepage.personalize.e.27
                        @Override // android.os.MessageQueue.IdleHandler
                        public boolean queueIdle() {
                            e.this.aRi();
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

    public void aRi() {
        long uY = com.baidu.tieba.homepage.framework.a.bNs().uY(1) + com.baidu.tieba.homepage.framework.a.bNs().getCreateTime();
        long uW = com.baidu.tieba.homepage.framework.a.bNs().uW(1);
        if (uW > 0) {
            uY = System.currentTimeMillis() - uW;
        }
        n.aRq().cj(uY);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.util.Set] */
    private void i(List<com.baidu.adp.widget.ListView.m> list, int i) {
        AdvertAppInfo bvx;
        AdvertAppInfo bvx2;
        if (!v.isEmpty(list)) {
            Set<com.baidu.adp.widget.ListView.m> HZ = com.baidu.tieba.recapp.report.a.HZ("NEWINDEX");
            HashSet hashSet = HZ == null ? new HashSet() : HZ;
            HashSet hashSet2 = new HashSet();
            for (com.baidu.adp.widget.ListView.m mVar : list) {
                if (mVar != null) {
                    for (com.baidu.adp.widget.ListView.m mVar2 : hashSet) {
                        if ((mVar instanceof com.baidu.tieba.card.data.d) && (bvx2 = ((com.baidu.tieba.card.data.d) mVar).bvx()) != null && mVar2 != null && (mVar2 instanceof AdvertAppInfo) && mVar2.hashCode() == bvx2.hashCode()) {
                            bvx2.advertAppContext = ((AdvertAppInfo) mVar2).advertAppContext;
                        }
                    }
                    if (mVar != null && (mVar instanceof com.baidu.tieba.card.data.d) && (bvx = ((com.baidu.tieba.card.data.d) mVar).bvx()) != null && bvx.advertAppContext == null) {
                        bvx.advertAppContext = new com.baidu.tbadk.core.data.c();
                        bvx.advertAppContext.page = "NEWINDEX";
                        bvx.advertAppContext.pn = this.mPn;
                        bvx.advertAppContext.extensionInfo = bvx.extensionInfo;
                        bvx.advertAppContext.Dn = false;
                        hashSet2.add(bvx);
                    }
                }
            }
            hashSet.addAll(hashSet2);
            com.baidu.tieba.recapp.report.a.b("NEWINDEX", hashSet);
            if (hashSet2.size() > 0) {
                com.baidu.tieba.s.c.cKa().b(this.hcL, com.baidu.tieba.s.a.b(PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE, "common_fill", true, hashSet2.size()));
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
        if (this.hcN == 1) {
            if (z2 && (dataRes.thread_list.size() >= 6 || bOP())) {
                bOO();
                this.hcz = null;
            }
        } else if (z2 && bOP()) {
            this.hcz = null;
        }
        int size = z2 ? 0 : this.mDataList.size();
        DataRes.Builder builder = new DataRes.Builder(dataRes);
        this.mDataList.clear();
        com.baidu.tieba.homepage.personalize.model.c a2 = this.hcD.a(z, this.hcz, builder, z2 ? 0 : 1);
        if (a2 == null) {
            list = null;
            i = 0;
        } else {
            List<com.baidu.adp.widget.ListView.m> list2 = a2.dTe;
            this.hcB = a2.hfd;
            int i2 = a2.hfe;
            a2.hfe = 0;
            list = list2;
            i = i2;
        }
        if (list != null) {
            this.mDataList.addAll(list);
            i(list, size);
            a(z2 ? 0 : 1, list, size);
            if (this.hcH) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
            }
        }
        if (this.hcz == null) {
            this.hcz = builder;
            this.hcx.cC(this.hcz.thread_list);
        }
        if (this.mDataList.size() == 0) {
            z4 = false;
        } else {
            if (z2) {
                if (dataRes.live_answer != null) {
                    this.hcI = new com.baidu.tieba.homepage.personalize.data.f();
                    this.hcI.a(dataRes.live_answer);
                    this.hcz.live_answer = dataRes.live_answer;
                } else if (z) {
                    this.hcI = null;
                    this.hcz.live_answer = null;
                }
                this.hcK = dataRes.float_info;
                this.hcz.float_info = dataRes.float_info;
            }
            long j = com.baidu.tbadk.core.sharedPref.b.aFD().getLong("key_maintab_banner_close_time", 0L);
            if (this.hcI != null && !aq.isTaday(j)) {
                this.mDataList.add(0, this.hcI);
            }
            LinkedList linkedList = new LinkedList(this.mDataList);
            this.hbS.setFromCDN(dataRes.is_new_url.intValue() == 1);
            this.hbS.j(linkedList, i);
            z4 = true;
            if (this.gqC != null && this.hbA) {
                this.gqC.a(this.gpQ, this.ejR, this.gqv, true);
            }
        }
        com.baidu.tieba.homepage.framework.a.bNs().o(System.currentTimeMillis() - currentTimeMillis, 1);
        long uZ = com.baidu.tieba.homepage.framework.a.bNs().uZ(1);
        if (uZ > 0) {
            com.baidu.tieba.homepage.framework.a.bNs().p(System.currentTimeMillis() - uZ, 1);
            com.baidu.tieba.homepage.framework.a.bNs().q(0L, 1);
        }
        if (dataRes.anti != null && dataRes.anti.block_pop_info != null) {
            com.baidu.tieba.ueg.d.d(dataRes.anti.block_pop_info);
        }
        ay ayVar = new ay();
        ayVar.a(dataRes.recom_post_topic);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_REFRESH_TOPIC_TIP, ayVar));
        return z4;
    }

    private void bON() {
        List<com.baidu.adp.widget.ListView.m> list;
        int i;
        if (v.getCount(this.mDataList) >= this.hcD.bPi() - 40) {
            com.baidu.tieba.homepage.personalize.model.c a2 = this.hcD.a(true, this.hcz, (DataRes.Builder) null, 1);
            if (a2 != null) {
                List<com.baidu.adp.widget.ListView.m> list2 = a2.dTe;
                i = a2.hfe;
                a2.hfe = 0;
                list = list2;
            } else {
                list = null;
                i = 0;
            }
            if (list != null) {
                this.mDataList.clear();
                this.mDataList.addAll(list);
                this.hbS.j(new LinkedList(this.mDataList), i);
            }
        }
    }

    private void azY() {
        this.gXe = true;
        ac.a(new com.baidu.tbadk.util.ab<DataRes>() { // from class: com.baidu.tieba.homepage.personalize.e.28
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.ab
            /* renamed from: bOU */
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

    private void byI() {
        if (this.hcz != null) {
            DataRes.Builder builder = new DataRes.Builder(this.hcz.build(true));
            if (builder.thread_list != null && builder.thread_list.size() > 30) {
                builder.thread_list = builder.thread_list.subList(0, 30);
            }
            a(builder, builder.thread_list != null ? builder.thread_list.size() : 0);
            a(builder);
        }
    }

    private void bOO() {
        if (this.hcz != null) {
            final DataRes.Builder builder = new DataRes.Builder(this.hcz.build(true));
            if (builder.thread_list != null && builder.thread_list.size() > 50) {
                builder.thread_list = builder.thread_list.subList(0, 50);
            }
            a(builder, builder.thread_list != null ? builder.thread_list.size() : 0);
            ac.a(new com.baidu.tbadk.util.ab<Object>() { // from class: com.baidu.tieba.homepage.personalize.e.3
                @Override // com.baidu.tbadk.util.ab
                public Object doInBackground() {
                    DataRes.Builder builder2 = new DataRes.Builder(builder.build(true));
                    e.this.hcx.cD(builder2.thread_list);
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
    public void Cj(String str) {
        if (!TextUtils.isEmpty(str) && this.hcz != null && this.hcz.banner_list != null && this.hcz.banner_list.app != null && this.hcz.banner_list.app.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (App app : this.hcz.banner_list.app) {
                if (app != null && str.equals(app.id)) {
                    arrayList.add(app);
                }
            }
            BannerList.Builder builder = new BannerList.Builder(this.hcz.banner_list);
            if (builder.app != null) {
                builder.app.removeAll(arrayList);
            }
            this.hcz.banner_list = builder.build(false);
            DataRes.Builder builder2 = new DataRes.Builder(this.hcz.build(true));
            builder2.banner_list = builder.build(true);
            a(builder2);
        }
    }

    private void a(final DataRes.Builder builder) {
        ac.a(new com.baidu.tbadk.util.ab<Object>() { // from class: com.baidu.tieba.homepage.personalize.e.4
            @Override // com.baidu.tbadk.util.ab
            public Object doInBackground() {
                DataRes.Builder builder2 = new DataRes.Builder(builder.build(true));
                e.this.hcx.cD(builder2.thread_list);
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

    private boolean bOP() {
        return mJ(true);
    }

    private boolean mJ(boolean z) {
        long j = com.baidu.tbadk.core.sharedPref.b.aFD().getLong(SharedPrefConfig.RECOMMEND_FRS_REFRESH_TIME + TbadkCoreApplication.getCurrentAccount(), 0L);
        return j == 0 ? z : Math.abs(System.currentTimeMillis() - j) > this.hcw;
    }

    public void a(a aVar) {
        this.hcy = aVar;
    }

    private boolean isLoading() {
        return this.mIsLoading;
    }

    private void setIsLoading(boolean z) {
        this.mIsLoading = z;
    }

    public void bOD() {
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
        if (this.hbF != null) {
            this.hcC.bFS();
        }
        if (this.hbF != null && this.hbF.getCurrentTabType() != 1) {
            this.hcC.hideTip();
        } else if (!this.hcJ) {
            this.hcC.hideTip();
        } else {
            this.hcA = i;
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
                    this.gsB = 3000;
                } else {
                    this.gsB = 2000;
                }
                this.hcM.dgX = str;
                this.hcM.gsu = this.gsB;
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 49;
                if (this.hbF != null) {
                    FrameLayout frameLayout = this.hbF.getFrameLayout();
                    frameLayout.removeView(this.hcM);
                    frameLayout.addView(this.hcM, layoutParams);
                    this.hcM.bFQ();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(Long l) {
        if (this.hcz != null && this.hcz.thread_list != null) {
            List<ThreadInfo> list = this.hcz.thread_list;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                ThreadInfo threadInfo = list.get(i);
                if (threadInfo.tid.equals(l) && threadInfo.top_agree_post != null) {
                    ThreadInfo.Builder builder = new ThreadInfo.Builder(threadInfo);
                    builder.top_agree_post = null;
                    list.set(i, builder.build(true));
                    byI();
                    a(false, true, false, this.hcz.build(true));
                    return;
                }
            }
        }
    }

    public void m(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.hcL = bdUniqueId;
            if (this.gFo != null) {
                this.gFo.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.gFo);
            }
            if (this.hcP != null) {
                this.hcP.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.hcP);
            }
            this.daf.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.daf);
            this.hcQ.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.hcQ);
            this.gHz.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.gHz);
            this.gHA.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.gHA);
            this.gFB.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.gFB);
            if (this.gqC != null) {
                this.gqC.setUniqueId(bdUniqueId);
            }
            this.hcx.j(bdUniqueId);
            this.hcV.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.hcV);
            this.gpI.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.gpI);
            this.hcW.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.hcW);
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
                        e.this.hcx.cD(builder5.thread_list);
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

    public void bOQ() {
        this.goi = new com.baidu.tieba.tbadkCore.data.f("new_index", null);
        this.goi.cKH();
    }

    public void a(int i, List<com.baidu.adp.widget.ListView.m> list, int i2) {
        int i3;
        int i4;
        if (this.goi != null) {
            if (i == 0) {
                this.goi.cKH();
            }
            if (list != null && !list.isEmpty()) {
                int[] iArr = com.baidu.tieba.tbadkCore.data.f.kfU;
                int i5 = 0;
                int i6 = 0;
                int i7 = 0;
                while (i7 < list.size() && i6 < iArr.length && (i3 = iArr[i6]) >= 0) {
                    if (list.get(i7) instanceof com.baidu.tieba.card.data.c) {
                        i4 = i5 + 1;
                        if (i4 == i3 - 1) {
                            if (i2 < i7 + 1) {
                                this.goi.cJ(i3, i7 + 1);
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
        if ((this.goi != null ? this.goi.Ct(i) : -1) >= 0 && this.gsQ != null && this.gsQ.getData() != null && this.gsQ.getData().size() > i) {
            this.goi.Cu(i);
        }
    }

    public m bEK() {
        return this.gqC;
    }

    public void mD(boolean z) {
        this.hbA = z;
    }

    public void vs(final int i) {
        ac.a(new com.baidu.tbadk.util.ab<Object>() { // from class: com.baidu.tieba.homepage.personalize.e.10
            @Override // com.baidu.tbadk.util.ab
            public Object doInBackground() {
                com.baidu.adp.lib.cache.l<String> cr = com.baidu.tbadk.core.c.a.aEB().cr(e.this.hcR, TbadkCoreApplication.getCurrentAccount());
                if (cr != null) {
                    cr.set(e.this.hcR, Integer.toString(i), 43200000L);
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
            /* renamed from: bOT */
            public String doInBackground() {
                com.baidu.adp.lib.cache.l<String> cr = com.baidu.tbadk.core.c.a.aEB().cr(e.this.hcR, TbadkCoreApplication.getCurrentAccount());
                if (cr != null) {
                    return cr.get(e.this.hcR);
                }
                return null;
            }
        }, new com.baidu.tbadk.util.l<String>() { // from class: com.baidu.tieba.homepage.personalize.e.14
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.l
            /* renamed from: Ck */
            public void onReturnDataInUI(String str) {
                if (dVar != null) {
                    dVar.va(com.baidu.adp.lib.f.b.toInt(str, 0));
                }
            }
        });
    }

    public void bOE() {
        c.e(this.gsQ);
    }

    public void bOR() {
        a(this.hcU);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(CustomResponsedMessage<?> customResponsedMessage) {
        boolean z;
        String str;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.hcz != null && v.getCount(this.hcz.thread_list) != 0 && v.getCount(this.mDataList) != 0) {
            JSONObject jSONObject = (JSONObject) customResponsedMessage.getData();
            String optString = jSONObject.optString("tid");
            if (StringUtils.isNull(optString)) {
                String optString2 = jSONObject.optString("liveid");
                if (this.gsQ != null && !TextUtils.isEmpty(optString2)) {
                    int i = 0;
                    while (true) {
                        if (i >= this.gsQ.getCount()) {
                            str = optString;
                            break;
                        }
                        com.baidu.adp.widget.ListView.m item = this.gsQ.getItem(i);
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
            if (this.hcz != null && this.hcz.thread_list != null) {
                long j = com.baidu.adp.lib.f.b.toLong(optString, 0L);
                int i2 = 0;
                while (true) {
                    if (i2 < this.hcz.thread_list.size()) {
                        ThreadInfo threadInfo = this.hcz.thread_list.get(i2);
                        if (threadInfo == null || threadInfo.tid == null || threadInfo.tid.longValue() != j) {
                            i2++;
                        } else {
                            this.hcz.thread_list.remove(i2);
                            byI();
                            com.baidu.tieba.homepage.personalize.b.d.a(threadInfo.tid.longValue(), i2, this.hcz.thread_list, this.mDataList);
                            break;
                        }
                    } else {
                        break;
                    }
                }
                if (this.gsQ != null) {
                    List<Integer> b = b(optString, this.gsQ);
                    int intValue = b.get(0).intValue();
                    int intValue2 = b.get(1).intValue();
                    if (intValue != -1 && intValue2 != -1) {
                        this.gsQ.m(intValue, intValue2);
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
                    advertAppInfo = ((com.baidu.tieba.homepage.personalize.data.a) next).bvx();
                } else {
                    if (next instanceof ae) {
                        ae aeVar = (ae) next;
                        if (aeVar.aAM() instanceof AdvertAppInfo.ILegoAdvert) {
                            advertAppInfo = ((AdvertAppInfo.ILegoAdvert) aeVar.aAM()).getAdvertAppInfo();
                        }
                    }
                    advertAppInfo = advertAppInfo2;
                }
                if (advertAppInfo != null && str.equals(advertAppInfo.cMW)) {
                    it.remove();
                    advertAppInfo = null;
                }
                advertAppInfo2 = advertAppInfo;
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (this.hcM != null) {
            this.hcM.onChangeSkinType(i);
        }
    }

    public FloatInfo bOS() {
        return this.hcK;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public af bOq() {
        if (this.gqC == null || this.gqC.cyI() == null || !(this.gqC.cyI().getTag() instanceof af)) {
            return null;
        }
        return (af) this.gqC.cyI().getTag();
    }
}
