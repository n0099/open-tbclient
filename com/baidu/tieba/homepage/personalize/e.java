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
import com.baidu.ala.atomdata.AlaSDKShareEmptyActivityConfig;
import com.baidu.card.a.a;
import com.baidu.card.af;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.searchbox.ugc.model.UgcConstant;
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
import com.baidu.tbadk.util.ab;
import com.baidu.tbadk.util.ac;
import com.baidu.tbadk.util.y;
import com.baidu.tbadk.util.z;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.LiveRoomClosedQueryMessage;
import com.baidu.tieba.card.data.k;
import com.baidu.tieba.card.r;
import com.baidu.tieba.f.a;
import com.baidu.tieba.frs.SmartBubbleAnimatedView;
import com.baidu.tieba.frs.aw;
import com.baidu.tieba.homepage.BlessHttpResponseMessage;
import com.baidu.tieba.homepage.BlessSocketResponseMessage;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import com.baidu.tieba.homepage.personalize.a.ad;
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
/* loaded from: classes9.dex */
public class e {
    private View.OnTouchListener dUn;
    private y egY;
    private aw gHq;
    private SmartBubbleAnimatedView gHr;
    private m gHv;
    private com.baidu.tieba.tbadkCore.data.f gYm;
    private boolean hGn;
    private final BigdaySwipeRefreshLayout hIg;
    private ScrollFragmentTabHost hMP;
    private final long hNF;
    private final b hNG;
    private DataRes.Builder hNI;
    private final com.baidu.tieba.homepage.personalize.model.a hNL;
    private int hNO;
    private g hNQ;
    private BdUniqueId hNT;
    private int hNU;
    private final ad hNb;
    private Runnable hOa;
    private final BdTypeRecyclerView hcS;
    private com.baidu.tieba.f.a hxk;
    private final TbPageContext<?> mPageContext;
    private a hNH = null;
    private final List<com.baidu.adp.widget.ListView.m> mDataList = new LinkedList();
    private int mPn = 1;
    private boolean mIsLoading = false;
    private boolean hIo = false;
    private int hNJ = 2;
    private int hNK = 0;
    private TextView mTipView = null;
    private int hcD = 2000;
    private com.baidu.tbadk.n.c hNM = null;
    private boolean haF = false;
    private int gZW = 0;
    private int eNU = 0;
    private boolean mIsBackground = false;
    private boolean hMK = true;
    private boolean hNN = false;
    private boolean hNP = false;
    private boolean hNR = true;
    private FloatInfo hNS = null;
    private a.C0074a gYE = new a.C0074a(2);
    private RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.e.12
        private int hOj = -1;
        private int hIw = 0;
        private boolean hOk = false;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (e.this.hNM == null) {
                e.this.hNM = new com.baidu.tbadk.n.c();
                e.this.hNM.setSubType(1005);
                e.this.hNM.pageType = 1;
            }
            if (e.this.egY != null && !e.this.mIsBackground) {
                e.this.egY.l(recyclerView, i);
            }
            if (i == 0) {
                c.d(e.this.hcS);
                e.this.hNM.aZr();
                r.bEY().jd(true);
                com.baidu.tieba.a.d.bfP().cF("page_recommend", "show_");
                com.baidu.tieba.s.c.cVr().b(e.this.hNT, false);
                this.hOk = false;
                if (e.this.gHv != null && e.this.hMK && !e.this.mIsBackground) {
                    e.this.gHv.a(e.this.gZW, e.this.eNU, e.this.haF, 1);
                    return;
                }
                return;
            }
            e.this.hNM.aZq();
            if (i == 1) {
                if (e.this.gHq != null) {
                    e.this.gHq.hideTip();
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
            if (this.hIw > i) {
                this.hOk = true;
            }
            if (e.this.egY != null && !e.this.mIsBackground) {
                e.this.egY.onScroll(this.hIw, i);
            }
            this.hIw = i;
            int i3 = (i + i2) - 1;
            if (!this.hOk && this.hOj != i3) {
                this.hOj = i3;
                e.this.vW(this.hOj);
            }
            if (this.hOk && this.hOj != i) {
                this.hOj = i;
                e.this.vW(this.hOj);
            }
            e.this.hNZ = i;
            e.this.gZW = i;
            e.this.eNU = (i + i2) - 1;
            af bZg = e.this.bZg();
            if (bZg != null && bZg.rD() != null) {
                bZg.rD().b(e.this.gYE);
            }
        }
    };
    private View.OnTouchListener dRW = new View.OnTouchListener() { // from class: com.baidu.tieba.homepage.personalize.e.22
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (e.this.dUn != null) {
                e.this.dUn.onTouch(view, motionEvent);
            }
            if (e.this.hxk != null) {
                e.this.hxk.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private a.InterfaceC0536a gxd = new a.InterfaceC0536a() { // from class: com.baidu.tieba.homepage.personalize.e.23
        @Override // com.baidu.tieba.f.a.InterfaceC0536a
        public void y(int i, int i2) {
            e.this.haF = false;
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0536a
        public void z(int i, int i2) {
            e.this.haF = true;
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0536a
        public void bG(int i, int i2) {
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0536a
        public void A(int i, int i2) {
        }
    };
    private View.OnClickListener hNV = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.e.24
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (e.this.gHq != null) {
                e.this.gHq.hideTip();
            }
        }
    };
    private final CustomMessageListener hNW = new CustomMessageListener(CmdConfigCustom.CMD_RELOAD_HP_PERSONALIZED) { // from class: com.baidu.tieba.homepage.personalize.e.25
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (e.this.hcS != null) {
                e.this.gHv.bZf();
                e.this.hMK = false;
                e.this.hIg.setRefreshing(true);
            }
        }
    };
    private CustomMessageListener hpQ = new CustomMessageListener(CmdConfigCustom.PB_ACTION_PRAISE) { // from class: com.baidu.tieba.homepage.personalize.e.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            bj bjVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bj) && e.this.hNI != null && v.getCount(e.this.hNI.thread_list) != 0 && (bjVar = (bj) customResponsedMessage.getData()) != null && bjVar.aKp() != null && bjVar.getId() != null && v.getCount(e.this.hNI.thread_list) != 0) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < e.this.hNI.thread_list.size()) {
                        ThreadInfo threadInfo = e.this.hNI.thread_list.get(i2);
                        if (threadInfo == null || threadInfo.id.longValue() != com.baidu.adp.lib.f.b.toLong(bjVar.getId(), -1L)) {
                            i = i2 + 1;
                        } else {
                            ThreadInfo.Builder builder = new ThreadInfo.Builder(threadInfo);
                            Zan.Builder builder2 = new Zan.Builder(builder.zan);
                            builder2.num = Integer.valueOf((int) bjVar.aKp().getNum());
                            builder.zan = builder2.build(true);
                            e.this.hNI.thread_list.set(i2, builder.build(true));
                            return;
                        }
                    } else {
                        return;
                    }
                }
            }
        }
    };
    private CustomMessageListener hNX = new CustomMessageListener(CmdConfigCustom.CMD_LIVE_VIDEO_CLOSED_QUERY_RESPONSED) { // from class: com.baidu.tieba.homepage.personalize.e.6
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
                        if ((originData.get(i2) instanceof bj) && (bjVar = (bj) originData.get(i2)) != null && bjVar.aKX() != null && ids.contains(Long.valueOf(bjVar.aKX().live_id))) {
                            e.this.mDataList.remove(bjVar);
                        }
                        i = i2 + 1;
                    }
                    if (e.this.hNb != null) {
                        e.this.hNb.ak(new ArrayList(e.this.mDataList));
                    }
                }
            }
        }
    };
    private CustomMessageListener dzH = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.homepage.personalize.e.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int intValue;
            if ((customResponsedMessage instanceof UpdateAttentionMessage) && e.this.hNI != null && !v.isEmpty(e.this.hNI.thread_list)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid)) {
                    int i = 0;
                    while (true) {
                        if (i >= e.this.hNI.thread_list.size()) {
                            break;
                        }
                        ThreadInfo threadInfo = e.this.hNI.thread_list.get(i);
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
                            e.this.hNI.thread_list.set(i, builder.build(true));
                        }
                    }
                    e.this.a(updateAttentionMessage);
                }
            }
        }
    };
    private String hNY = "lastReadReadPositionKey";
    private int hNZ = 0;
    private d hOb = new d() { // from class: com.baidu.tieba.homepage.personalize.e.11
        @Override // com.baidu.tieba.homepage.personalize.d
        public void vF(final int i) {
            if (e.this.hOa == null) {
                e.this.hOa = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.e.11.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (e.this.hcS.getHandler() != null) {
                            e.this.hcS.requestFocusFromTouch();
                            if (i <= e.this.hcS.getCount() - 1) {
                                e.this.hcS.setSelection(i);
                            }
                        }
                    }
                };
            }
            e.this.hcS.removeCallbacks(e.this.hOa);
            e.this.hcS.post(e.this.hOa);
        }
    };
    private CustomMessageListener hOc = new CustomMessageListener(2016569) { // from class: com.baidu.tieba.homepage.personalize.e.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && e.this.hNQ != null) {
                e.this.mDataList.remove(e.this.hNQ);
                e.this.hNb.ak(new ArrayList(e.this.mDataList));
                com.baidu.tbadk.core.sharedPref.b.aNV().putLong("key_maintab_banner_close_time", System.currentTimeMillis());
            }
        }
    };
    private CustomMessageListener gHm = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.homepage.personalize.e.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.g(customResponsedMessage);
            if (e.this.gHv != null && e.this.hMK) {
                e.this.gHv.a(e.this.gZW, e.this.eNU, e.this.haF, true);
            }
        }
    };
    private CustomMessageListener gHn = new CustomMessageListener(CmdConfigCustom.CMD_THREAD_NOT_EXIST_WHEN_ENTER_PB) { // from class: com.baidu.tieba.homepage.personalize.e.17
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.g(customResponsedMessage);
        }
    };
    private CustomMessageListener hqe = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.homepage.personalize.e.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && e.this.hNI != null && v.getCount(e.this.hNI.thread_list) != 0) {
                String str = (String) customResponsedMessage.getData();
                e.this.h(str, e.this.mDataList);
                e.this.DS(str);
                if (e.this.hNb != null) {
                    e.this.hNb.ak(new ArrayList(e.this.mDataList));
                }
                if (e.this.gHv != null && e.this.hMK) {
                    e.this.gHv.a(e.this.gZW, e.this.eNU, e.this.haF, true);
                }
            }
        }
    };
    private CustomMessageListener gZN = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.homepage.personalize.e.19
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            af bZg;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent)) {
                KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24 && (bZg = e.this.bZg()) != null && bZg.rD() != null) {
                    bZg.rD().b(new a.C0074a(3));
                }
            }
        }
    };
    private com.baidu.adp.framework.listener.a hOd = new com.baidu.adp.framework.listener.a(1003065, CmdConfigSocket.CMD_TOPIC_BLESS) { // from class: com.baidu.tieba.homepage.personalize.e.20
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
                        if ((mVar instanceof com.baidu.tieba.homepage.topic.topictab.b.a) && (bVar = ((com.baidu.tieba.homepage.topic.topictab.b.a) mVar).hSU) != null && longValue == bVar.pkId) {
                            bVar.userPkId = j2;
                            return;
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener gZO = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.homepage.personalize.e.21
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int[] imageWidthAndHeight;
            List<com.baidu.adp.widget.ListView.m> dataList = e.this.hNb.getDataList();
            if (!v.isEmpty(dataList)) {
                for (com.baidu.adp.widget.ListView.m mVar : dataList) {
                    if (mVar instanceof k) {
                        k kVar = (k) mVar;
                        if (kVar.dqB != 0 && kVar.dqA != null) {
                            if ((TbSingleton.getInstance().getHomePageStyleAbTest() & 4) != 0) {
                                imageWidthAndHeight = kVar.dqA.aMw();
                            } else {
                                imageWidthAndHeight = kVar.dqA.getImageWidthAndHeight();
                            }
                            kVar.dqB = imageWidthAndHeight[0];
                            kVar.dqC = imageWidthAndHeight[1];
                        }
                    }
                }
            }
            com.baidu.adp.lib.f.e.lb().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.personalize.e.21.1
                @Override // java.lang.Runnable
                public void run() {
                    e.this.hNb.notifyDataSetChanged();
                    if (!e.this.mIsBackground && e.this.hMK) {
                        e.this.gHv.a(e.this.gZW, e.this.eNU, e.this.haF, true);
                    }
                }
            }, 500L);
        }
    };

    /* loaded from: classes9.dex */
    public interface a {
        void Q(int i, int i2, int i3);

        void bZw();

        void onError(int i, String str);

        void onSuccess();

        void z(int i, int i2, int i3, int i4);
    }

    public void nR(boolean z) {
        this.hNR = z;
        if (this.gHq != null && !z) {
            this.gHq.hideTip();
        }
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.hMP = scrollFragmentTabHost;
        if (this.hMP != null) {
            this.hMP.setOnTabSelectedListener(new ScrollFragmentTabHost.b() { // from class: com.baidu.tieba.homepage.personalize.e.1
                @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.b
                public void vP(int i) {
                    if (e.this.hMP.vO(i) != 1 && e.this.gHq != null) {
                        e.this.gHq.hideTip();
                    }
                }
            });
        }
    }

    public void setTabInForeBackgroundState(boolean z) {
        this.mIsBackground = z;
    }

    public void mC(boolean z) {
        boolean z2 = false;
        this.mIsBackground = z;
        if (this.hMP != null) {
            this.hMP.mC(z);
        }
        if (this.gHv != null) {
            this.gHv.pL(!z);
            af bZg = bZg();
            if (bZg != null && bZg.rD() != null) {
                z2 = bZg.rD().b(new a.C0074a(8, Boolean.valueOf(z)));
            }
            if (!z2) {
                if (z) {
                    this.gHv.bZf();
                } else if (this.hMK) {
                    this.gHv.a(this.gZW, this.eNU, this.haF, true);
                }
            }
        }
    }

    public e(TbPageContext<?> tbPageContext, BdTypeRecyclerView bdTypeRecyclerView, ad adVar, BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout) {
        this.hNU = 0;
        this.mPageContext = tbPageContext;
        this.hNU = com.baidu.tbadk.core.sharedPref.b.aNV().getInt("key_personalized_refresh_type", 0);
        this.hIg = bigdaySwipeRefreshLayout;
        this.hcS = bdTypeRecyclerView;
        this.hcS.setOnTouchListener(this.dRW);
        this.hxk = new com.baidu.tieba.f.a();
        this.hxk.a(this.gxd);
        this.hNb = adVar;
        this.hNL = new com.baidu.tieba.homepage.personalize.model.a();
        this.hNF = com.baidu.tbadk.core.sharedPref.b.aNV().getLong("recommend_frs_cache_time", 3600L) * 1000;
        bdTypeRecyclerView.setOnScrollListener(this.mOnScrollListener);
        this.gHq = new aw();
        bZG();
        this.gHv = new m(this.mPageContext, this.hcS);
        this.gHv.AZ(1);
        this.gHv.AY(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.hNG = new b(this.mDataList, this.hNb);
        this.gHr = new SmartBubbleAnimatedView(tbPageContext.getContext());
        this.gHr.setLayoutParams(new FrameLayout.LayoutParams(-1, l.getDimens(tbPageContext.getContext(), R.dimen.tbds83)));
        bZx();
        this.gZO.setTag(this.mPageContext.getUniqueId());
        MessageManager.getInstance().registerListener(this.gZO);
    }

    private void bZx() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2016323, new CustomMessageTask.CustomRunnable<Boolean>() { // from class: com.baidu.tieba.homepage.personalize.e.26
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Boolean> customMessage) {
                af bZg = e.this.bZg();
                return (bZg == null || bZg.rD() == null) ? new CustomResponsedMessage<>(2016323, false) : new CustomResponsedMessage<>(2016323, Boolean.valueOf(bZg.rD().b(new a.C0074a(6))));
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private boolean bZy() {
        return com.baidu.tbadk.core.sharedPref.b.aNV().getBoolean(bZA(), true);
    }

    private void bZz() {
        com.baidu.tbadk.core.sharedPref.b.aNV().putBoolean(bZA(), false);
    }

    private String bZA() {
        return "key_rec_pfirst_load_" + TbadkCoreApplication.getCurrentAccount() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + TbConfig.getVersion();
    }

    public void setRecommendFrsNavigationAnimDispatcher(z zVar) {
        if (zVar != null) {
            this.egY = zVar.baC();
            this.dUn = zVar.baD();
        }
    }

    public void showFloatingView() {
        if (this.egY != null) {
            this.egY.ic(true);
        }
    }

    public void update() {
        com.baidu.tieba.homepage.framework.a.bYi().q(System.currentTimeMillis(), 1);
        this.mPn = 1;
        this.hNP = true;
        if (this.mDataList.size() == 0 && !bZy()) {
            if (!this.hIo) {
                aIo();
                return;
            }
            return;
        }
        aIn();
    }

    public void cb(int i, int i2) {
        bj bjVar;
        if (!v.isEmpty(this.mDataList) && this.mDataList.size() > i) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            while (i < this.mDataList.size() && i <= i2) {
                if (this.mDataList.get(i).getType().getId() == bj.dqW.getId() && (bjVar = (bj) this.mDataList.get(i)) != null && bjVar.aKX() != null) {
                    arrayList.add(Long.valueOf(bjVar.aKX().live_id));
                    arrayList2.add(bjVar);
                }
                i++;
            }
            if (!v.isEmpty(arrayList)) {
                MessageManager.getInstance().sendMessage(new LiveRoomClosedQueryMessage(arrayList, arrayList2));
            }
        }
    }

    public void bZB() {
        if (this.gHv != null && !this.mIsBackground && this.hMK) {
            this.gHv.a(this.gZW, this.eNU, this.haF, true);
        }
        if (this.hNN) {
            if (this.hIg != null && !this.hIg.aQu()) {
                if (this.hGn) {
                    com.baidu.tieba.s.c.cVr().b(this.hNT, false);
                    if (nT(false)) {
                        cc(3, this.hNK);
                    } else if (this.hNO > 0) {
                        cc(2, this.hNK);
                    }
                } else if (!this.hGn && this.hNK == 0) {
                    cc(2, 0);
                }
            }
            this.hNN = false;
            this.hGn = false;
            this.hNO = 0;
            if (this.hNP) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
            }
            this.hNP = false;
        }
    }

    public void blb() {
        if (isLoading()) {
            com.baidu.tieba.homepage.framework.a.bYi().q(0L, 1);
        } else if (this.hNH != null) {
            bZD();
            this.mPn++;
            setIsLoading(true);
            this.hNH.z(this.mPn, (this.hNI == null || this.hNI.thread_list == null) ? 0 : this.hNI.thread_list.size(), nS(false), 0);
        }
    }

    public void a(boolean z, boolean z2, DataRes dataRes, int i, String str) {
        int size = (this.hNI == null || this.hNI.thread_list == null) ? 0 : this.hNI.thread_list.size();
        if (!z && i == 0 && dataRes != null && v.isEmpty(dataRes.thread_list)) {
            if (this.hNH != null) {
                this.hNH.bZw();
            }
            setIsLoading(false);
            if (this.hIg != null) {
                this.hIg.setRefreshing(false);
                return;
            }
            return;
        }
        if (i != 0 || dataRes == null || !a(true, z, z2, dataRes)) {
            this.hNN = false;
            if (this.mDataList.size() > 0) {
                if (this.hNH != null) {
                    this.hNH.onError(1, str);
                }
            } else if (this.hNH != null) {
                this.hNH.onError(2, str);
            }
        } else {
            bZz();
            if (this.hNH != null) {
                com.baidu.tbadk.core.sharedPref.b.aNV().putLong(SharedPrefConfig.RECOMMEND_FRS_REFRESH_TIME + TbadkCoreApplication.getCurrentAccount(), System.currentTimeMillis());
                this.hNH.onSuccess();
            }
            this.hNN = true;
            this.hGn = z;
            this.hNO = size;
            bIM();
        }
        setIsLoading(false);
        if (this.hIg != null) {
            g.e bZC = bZC();
            if (this.hIg.aQu() && bZC != null) {
                this.hIg.c(bZC);
            } else {
                this.hIg.setRefreshing(false);
            }
        }
    }

    private g.e bZC() {
        int i;
        String feedText;
        if (this.hNN && this.hIg != null && this.hIg.aQu()) {
            int i2 = this.hNK;
            if (this.hGn) {
                com.baidu.tieba.s.c.cVr().b(this.hNT, false);
                if (nT(false)) {
                    i = 3;
                } else {
                    i = this.hNO > 0 ? 2 : 0;
                }
            } else if (this.hGn || this.hNK != 0) {
                return null;
            } else {
                i2 = 0;
                i = 2;
            }
            if (this.hMP != null) {
                this.gHq.bQG();
            }
            if (this.hMP != null && this.hMP.getCurrentTabType() != 1) {
                this.gHq.hideTip();
                return null;
            } else if (!this.hNR) {
                this.gHq.hideTip();
                return null;
            } else {
                this.hNJ = i;
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
                    this.hcD = 1000;
                } else {
                    this.hcD = 0;
                }
                return new g.e(feedText, this.hcD);
            }
        }
        return null;
    }

    public void nH(boolean z) {
        if (z) {
            this.hNb.notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        if (this.gHv != null) {
            this.gHv.destroy();
        }
        if (this.gHq != null) {
            this.gHq.onDestroy();
        }
        if (this.hNG != null) {
            this.hNG.onDestroy();
        }
        if (this.hcS != null) {
            this.hcS.removeCallbacks(this.hOa);
        }
        MessageManager.getInstance().unRegisterTask(2016323);
        MessageManager.getInstance().unRegisterListener(this.gZO);
    }

    public void onPause() {
        c.d(this.hcS);
        vX(this.hNZ);
        if (this.hNM != null) {
            this.hNM.aZs();
        }
    }

    private void aIn() {
        if (this.hNH != null) {
            this.hNH.Q((this.hNI == null || this.hNI.thread_list == null || bZF()) ? 0 : this.hNI.thread_list.size(), nS(true), 0);
        }
    }

    public int nS(boolean z) {
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
                if (!(mVar instanceof com.baidu.tieba.homepage.personalize.data.a) || mVar.getType() == AdvertAppInfo.dmd) {
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
                if ((mVar2 instanceof com.baidu.tieba.homepage.personalize.data.a) && mVar2.getType() != AdvertAppInfo.dmd) {
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
        this.hIo = true;
        if (dataRes != null) {
            if (a(false, true, true, dataRes) && !bZF()) {
                if (this.hNH != null) {
                    this.hNH.onSuccess();
                    Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler() { // from class: com.baidu.tieba.homepage.personalize.e.27
                        @Override // android.os.MessageQueue.IdleHandler
                        public boolean queueIdle() {
                            e.this.aZx();
                            return false;
                        }
                    });
                    return;
                }
                return;
            }
            aIn();
            return;
        }
        aIn();
    }

    public void aZx() {
        long vD = com.baidu.tieba.homepage.framework.a.bYi().vD(1) + com.baidu.tieba.homepage.framework.a.bYi().getCreateTime();
        long vB = com.baidu.tieba.homepage.framework.a.bYi().vB(1);
        if (vB > 0) {
            vD = System.currentTimeMillis() - vB;
        }
        n.aZF().cQ(vD);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.util.Set] */
    private void i(List<com.baidu.adp.widget.ListView.m> list, int i) {
        AdvertAppInfo bFo;
        AdvertAppInfo bFo2;
        if (!v.isEmpty(list)) {
            Set<com.baidu.adp.widget.ListView.m> JE = com.baidu.tieba.recapp.report.a.JE("NEWINDEX");
            HashSet hashSet = JE == null ? new HashSet() : JE;
            HashSet hashSet2 = new HashSet();
            for (com.baidu.adp.widget.ListView.m mVar : list) {
                if (mVar != null) {
                    for (com.baidu.adp.widget.ListView.m mVar2 : hashSet) {
                        if ((mVar instanceof com.baidu.tieba.card.data.d) && (bFo2 = ((com.baidu.tieba.card.data.d) mVar).bFo()) != null && mVar2 != null && (mVar2 instanceof AdvertAppInfo) && mVar2.hashCode() == bFo2.hashCode()) {
                            bFo2.advertAppContext = ((AdvertAppInfo) mVar2).advertAppContext;
                        }
                    }
                    if (mVar != null && (mVar instanceof com.baidu.tieba.card.data.d) && (bFo = ((com.baidu.tieba.card.data.d) mVar).bFo()) != null && bFo.advertAppContext == null) {
                        bFo.advertAppContext = new com.baidu.tbadk.core.data.c();
                        bFo.advertAppContext.page = "NEWINDEX";
                        bFo.advertAppContext.pn = this.mPn;
                        bFo.advertAppContext.extensionInfo = bFo.extensionInfo;
                        bFo.advertAppContext.WI = false;
                        hashSet2.add(bFo);
                    }
                }
            }
            hashSet.addAll(hashSet2);
            com.baidu.tieba.recapp.report.a.b("NEWINDEX", hashSet);
            if (hashSet2.size() > 0) {
                com.baidu.tieba.s.c.cVr().b(this.hNT, com.baidu.tieba.s.a.b(PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE, "common_fill", true, hashSet2.size()));
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
        if (this.hNU == 1) {
            if (z2 && (dataRes.thread_list.size() >= 6 || bZF())) {
                bZE();
                this.hNI = null;
            }
        } else if (z2 && bZF()) {
            this.hNI = null;
        }
        int size = z2 ? 0 : this.mDataList.size();
        DataRes.Builder builder = new DataRes.Builder(dataRes);
        this.mDataList.clear();
        com.baidu.tieba.homepage.personalize.model.c a2 = this.hNL.a(z, this.hNI, builder, z2 ? 0 : 1);
        if (a2 == null) {
            list = null;
            i = 0;
        } else {
            List<com.baidu.adp.widget.ListView.m> list2 = a2.etG;
            this.hNK = a2.hQw;
            int i2 = a2.hQx;
            a2.hQx = 0;
            list = list2;
            i = i2;
        }
        if (list != null) {
            this.mDataList.addAll(list);
            i(list, size);
            a(z2 ? 0 : 1, list, size);
            if (this.hNP) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
            }
        }
        if (this.hNI == null) {
            this.hNI = builder;
            this.hNG.cN(this.hNI.thread_list);
        }
        if (this.mDataList.size() == 0) {
            z4 = false;
        } else {
            if (z2) {
                if (dataRes.live_answer != null) {
                    this.hNQ = new com.baidu.tieba.homepage.personalize.data.g();
                    this.hNQ.a(dataRes.live_answer);
                    this.hNI.live_answer = dataRes.live_answer;
                } else if (z) {
                    this.hNQ = null;
                    this.hNI.live_answer = null;
                }
                this.hNS = dataRes.float_info;
                this.hNI.float_info = dataRes.float_info;
            }
            long j = com.baidu.tbadk.core.sharedPref.b.aNV().getLong("key_maintab_banner_close_time", 0L);
            if (this.hNQ != null && !aq.isTaday(j)) {
                this.mDataList.add(0, this.hNQ);
            }
            LinkedList linkedList = new LinkedList(this.mDataList);
            this.hNb.setFromCDN(dataRes.is_new_url.intValue() == 1);
            this.hNb.j(linkedList, i);
            z4 = true;
            if (this.gHv != null && this.hMK) {
                this.gHv.a(this.gZW, this.eNU, this.haF, true);
            }
        }
        com.baidu.tieba.homepage.framework.a.bYi().o(System.currentTimeMillis() - currentTimeMillis, 1);
        long vE = com.baidu.tieba.homepage.framework.a.bYi().vE(1);
        if (vE > 0) {
            com.baidu.tieba.homepage.framework.a.bYi().p(System.currentTimeMillis() - vE, 1);
            com.baidu.tieba.homepage.framework.a.bYi().q(0L, 1);
        }
        if (dataRes.anti != null && dataRes.anti.block_pop_info != null) {
            com.baidu.tieba.ueg.d.d(dataRes.anti.block_pop_info);
        }
        ay ayVar = new ay();
        ayVar.a(dataRes.recom_post_topic);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_REFRESH_TOPIC_TIP, ayVar));
        return z4;
    }

    private void bZD() {
        List<com.baidu.adp.widget.ListView.m> list;
        int i;
        if (v.getCount(this.mDataList) >= this.hNL.caa() - 40) {
            com.baidu.tieba.homepage.personalize.model.c a2 = this.hNL.a(true, this.hNI, (DataRes.Builder) null, 1);
            if (a2 != null) {
                List<com.baidu.adp.widget.ListView.m> list2 = a2.etG;
                i = a2.hQx;
                a2.hQx = 0;
                list = list2;
            } else {
                list = null;
                i = 0;
            }
            if (list != null) {
                this.mDataList.clear();
                this.mDataList.addAll(list);
                this.hNb.j(new LinkedList(this.mDataList), i);
            }
        }
    }

    private void aIo() {
        this.hIo = true;
        ac.a(new ab<DataRes>() { // from class: com.baidu.tieba.homepage.personalize.e.28
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.ab
            /* renamed from: bZK */
            public DataRes doInBackground() {
                com.baidu.adp.lib.cache.l<byte[]> cA = com.baidu.tbadk.core.c.a.aMT().cA("tb.rec_frs_update", TbadkCoreApplication.getCurrentAccount());
                if (cA == null) {
                    return null;
                }
                byte[] bArr = cA.get("0");
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

    private void bIM() {
        if (this.hNI != null) {
            DataRes.Builder builder = new DataRes.Builder(this.hNI.build(true));
            if (builder.thread_list != null && builder.thread_list.size() > 30) {
                builder.thread_list = builder.thread_list.subList(0, 30);
            }
            a(builder, builder.thread_list != null ? builder.thread_list.size() : 0);
            a(builder);
            b(builder);
        }
    }

    private void bZE() {
        if (this.hNI != null) {
            final DataRes.Builder builder = new DataRes.Builder(this.hNI.build(true));
            if (builder.thread_list != null && builder.thread_list.size() > 50) {
                builder.thread_list = builder.thread_list.subList(0, 50);
            }
            a(builder, builder.thread_list != null ? builder.thread_list.size() : 0);
            ac.a(new ab<Object>() { // from class: com.baidu.tieba.homepage.personalize.e.3
                @Override // com.baidu.tbadk.util.ab
                public Object doInBackground() {
                    DataRes.Builder builder2 = new DataRes.Builder(builder.build(true));
                    e.this.hNG.cO(builder2.thread_list);
                    try {
                        com.baidu.tbadk.core.c.a.aMT().cA("tb.rec_old_data", TbadkCoreApplication.getCurrentAccount()).setForever("0", builder2.build(true).toByteArray());
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

    private void a(DataRes.Builder builder) {
        builder.user_follow_live = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DS(String str) {
        if (!TextUtils.isEmpty(str) && this.hNI != null && this.hNI.banner_list != null && this.hNI.banner_list.app != null && this.hNI.banner_list.app.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (App app : this.hNI.banner_list.app) {
                if (app != null && str.equals(app.id)) {
                    arrayList.add(app);
                }
            }
            BannerList.Builder builder = new BannerList.Builder(this.hNI.banner_list);
            if (builder.app != null) {
                builder.app.removeAll(arrayList);
            }
            this.hNI.banner_list = builder.build(false);
            DataRes.Builder builder2 = new DataRes.Builder(this.hNI.build(true));
            builder2.banner_list = builder.build(true);
            b(builder2);
        }
    }

    private void b(final DataRes.Builder builder) {
        ac.a(new ab<Object>() { // from class: com.baidu.tieba.homepage.personalize.e.4
            @Override // com.baidu.tbadk.util.ab
            public Object doInBackground() {
                DataRes.Builder builder2 = new DataRes.Builder(builder.build(true));
                e.this.hNG.cO(builder2.thread_list);
                try {
                    com.baidu.tbadk.core.c.a.aMT().cA("tb.rec_frs_update", TbadkCoreApplication.getCurrentAccount()).setForever("0", builder2.build(true).toByteArray());
                    return null;
                } catch (Exception e) {
                    BdLog.e(e);
                    return null;
                }
            }
        }, null);
    }

    private boolean bZF() {
        return nT(true);
    }

    private boolean nT(boolean z) {
        long j = com.baidu.tbadk.core.sharedPref.b.aNV().getLong(SharedPrefConfig.RECOMMEND_FRS_REFRESH_TIME + TbadkCoreApplication.getCurrentAccount(), 0L);
        return j == 0 ? z : Math.abs(System.currentTimeMillis() - j) > this.hNF;
    }

    public void a(a aVar) {
        this.hNH = aVar;
    }

    private boolean isLoading() {
        return this.mIsLoading;
    }

    private void setIsLoading(boolean z) {
        this.mIsLoading = z;
    }

    public void bZt() {
        boolean z = true;
        com.baidu.tbadk.coreExtra.data.b activityPrizeData = TbadkCoreApplication.getInst().getActivityPrizeData();
        if (activityPrizeData.isSwitchTurn() && !StringUtils.isNull(activityPrizeData.getFeedText())) {
            String currentDay = UtilHelper.getCurrentDay();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            String str = "";
            if (!StringUtils.isNull(currentAccount)) {
                String string = com.baidu.tbadk.core.sharedPref.b.aNV().getString(SharedPrefConfig.ACTIVITY_PRIZE_FEED_TEXT_TIME, "");
                if (!StringUtils.isNull(string)) {
                    String[] split = string.split(UgcConstant.AT_RULE_TAG);
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
                                    sb.append(currentDay).append(UgcConstant.AT_RULE_TAG);
                                    for (String str3 : asList) {
                                        sb.append(str3).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                                    }
                                    str = sb.append(currentAccount).toString();
                                }
                            } else {
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append(currentDay).append(UgcConstant.AT_RULE_TAG);
                                sb2.append(currentAccount);
                                str = sb2.toString();
                            }
                        } else {
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append(currentDay).append(UgcConstant.AT_RULE_TAG);
                            sb3.append(currentAccount);
                            str = sb3.toString();
                        }
                    } else {
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append(currentDay).append(UgcConstant.AT_RULE_TAG);
                        sb4.append(currentAccount);
                        str = sb4.toString();
                    }
                } else {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(currentDay).append(UgcConstant.AT_RULE_TAG);
                    sb5.append(currentAccount);
                    str = sb5.toString();
                }
                if (z) {
                    cc(4, 0);
                    com.baidu.tbadk.core.sharedPref.b.aNV().putString(SharedPrefConfig.ACTIVITY_PRIZE_FEED_TEXT_TIME, str);
                }
            }
        }
    }

    private void cc(int i, int i2) {
        if (this.hMP != null) {
            this.gHq.bQG();
        }
        if (this.hMP != null && this.hMP.getCurrentTabType() != 1) {
            this.gHq.hideTip();
        } else if (!this.hNR) {
            this.gHq.hideTip();
        } else {
            this.hNJ = i;
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
                    this.hcD = 3000;
                } else {
                    this.hcD = 2000;
                }
                this.gHr.dHs = str;
                this.gHr.hcw = this.hcD;
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 49;
                if (this.hMP != null) {
                    FrameLayout frameLayout = this.hMP.getFrameLayout();
                    frameLayout.removeView(this.gHr);
                    frameLayout.addView(this.gHr, layoutParams);
                    this.gHr.bQE();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(Long l) {
        if (this.hNI != null && this.hNI.thread_list != null) {
            List<ThreadInfo> list = this.hNI.thread_list;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                ThreadInfo threadInfo = list.get(i);
                if (threadInfo.tid.equals(l) && threadInfo.top_agree_post != null) {
                    ThreadInfo.Builder builder = new ThreadInfo.Builder(threadInfo);
                    builder.top_agree_post = null;
                    list.set(i, builder.build(true));
                    bIM();
                    a(false, true, false, this.hNI.build(true));
                    return;
                }
            }
        }
    }

    public void m(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.hNT = bdUniqueId;
            if (this.hpQ != null) {
                this.hpQ.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.hpQ);
            }
            if (this.hNW != null) {
                this.hNW.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.hNW);
            }
            this.dzH.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.dzH);
            this.hNX.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.hNX);
            this.gHm.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.gHm);
            this.gHn.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.gHn);
            this.hqe.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.hqe);
            if (this.gHv != null) {
                this.gHv.setUniqueId(bdUniqueId);
            }
            this.hNG.j(bdUniqueId);
            this.hOc.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.hOc);
            this.gZN.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.gZN);
            this.hOd.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.hOd);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(UpdateAttentionMessage updateAttentionMessage) {
        if (updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid)) {
            final String str = updateAttentionMessage.getData().toUid;
            final boolean z = updateAttentionMessage.getData().isAttention;
            ac.a(new ab<Boolean>() { // from class: com.baidu.tieba.homepage.personalize.e.8
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.baidu.tbadk.util.ab
                public Boolean doInBackground() {
                    int intValue;
                    try {
                        com.baidu.adp.lib.cache.l<byte[]> cA = com.baidu.tbadk.core.c.a.aMT().cA("tb.rec_frs_update", TbadkCoreApplication.getCurrentAccount());
                        if (cA == null) {
                            return false;
                        }
                        byte[] bArr = cA.get("0");
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
                        e.this.hNG.cO(builder5.thread_list);
                        cA.setForever("0", builder5.build(true).toByteArray());
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

    public void bZG() {
        this.gYm = new com.baidu.tieba.tbadkCore.data.f("new_index", null);
        this.gYm.cVY();
    }

    public void a(int i, List<com.baidu.adp.widget.ListView.m> list, int i2) {
        int i3;
        int i4;
        if (this.gYm != null) {
            if (i == 0) {
                this.gYm.cVY();
            }
            if (list != null && !list.isEmpty()) {
                int[] iArr = com.baidu.tieba.tbadkCore.data.f.kRP;
                int i5 = 0;
                int i6 = 0;
                int i7 = 0;
                while (i7 < list.size() && i6 < iArr.length && (i3 = iArr[i6]) >= 0) {
                    if (list.get(i7) instanceof com.baidu.tieba.card.data.c) {
                        i4 = i5 + 1;
                        if (i4 == i3 - 1) {
                            if (i2 < i7 + 1) {
                                this.gYm.cP(i3, i7 + 1);
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

    public void vW(int i) {
        if ((this.gYm != null ? this.gYm.Df(i) : -1) >= 0 && this.hcS != null && this.hcS.getData() != null && this.hcS.getData().size() > i) {
            this.gYm.Dg(i);
        }
    }

    public m bPv() {
        return this.gHv;
    }

    public void nN(boolean z) {
        this.hMK = z;
    }

    public void vX(final int i) {
        ac.a(new ab<Object>() { // from class: com.baidu.tieba.homepage.personalize.e.10
            @Override // com.baidu.tbadk.util.ab
            public Object doInBackground() {
                com.baidu.adp.lib.cache.l<String> cB = com.baidu.tbadk.core.c.a.aMT().cB(e.this.hNY, TbadkCoreApplication.getCurrentAccount());
                if (cB != null) {
                    cB.set(e.this.hNY, Integer.toString(i), 43200000L);
                    return null;
                }
                return null;
            }
        }, null);
    }

    public void a(final d dVar) {
        ac.a(new ab<String>() { // from class: com.baidu.tieba.homepage.personalize.e.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.ab
            /* renamed from: bZJ */
            public String doInBackground() {
                com.baidu.adp.lib.cache.l<String> cB = com.baidu.tbadk.core.c.a.aMT().cB(e.this.hNY, TbadkCoreApplication.getCurrentAccount());
                if (cB != null) {
                    return cB.get(e.this.hNY);
                }
                return null;
            }
        }, new com.baidu.tbadk.util.l<String>() { // from class: com.baidu.tieba.homepage.personalize.e.14
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.l
            /* renamed from: DT */
            public void onReturnDataInUI(String str) {
                if (dVar != null) {
                    dVar.vF(com.baidu.adp.lib.f.b.toInt(str, 0));
                }
            }
        });
    }

    public void bZu() {
        c.e(this.hcS);
    }

    public void bZH() {
        a(this.hOb);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(CustomResponsedMessage<?> customResponsedMessage) {
        boolean z;
        String str;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.hNI != null && v.getCount(this.hNI.thread_list) != 0 && v.getCount(this.mDataList) != 0) {
            JSONObject jSONObject = (JSONObject) customResponsedMessage.getData();
            String optString = jSONObject.optString("tid");
            if (StringUtils.isNull(optString)) {
                String optString2 = jSONObject.optString(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_ID);
                if (this.hcS != null && !TextUtils.isEmpty(optString2)) {
                    int i = 0;
                    while (true) {
                        if (i >= this.hcS.getCount()) {
                            str = optString;
                            break;
                        }
                        com.baidu.adp.widget.ListView.m item = this.hcS.getItem(i);
                        if (item instanceof com.baidu.tieba.card.data.j) {
                            com.baidu.tieba.card.data.j jVar = (com.baidu.tieba.card.data.j) item;
                            if (jVar.aIw() != null && jVar.aIw().aKX() != null && optString2.equals(String.valueOf(jVar.aIw().aKX().live_id))) {
                                str = jVar.aIw().getTid();
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
                    if (cVar.aIw() != null && cVar.aIw().getTid() != null) {
                        if (cVar.aIw().getTid().equals(optString)) {
                            it.remove();
                            z = true;
                            z2 = z;
                        } else if (z2) {
                            com.baidu.tieba.homepage.personalize.model.b.cQ(this.mDataList);
                            break;
                        }
                    }
                }
                z = z2;
                z2 = z;
            }
            if (this.hNI != null && this.hNI.thread_list != null) {
                long j = com.baidu.adp.lib.f.b.toLong(optString, 0L);
                int i2 = 0;
                while (true) {
                    if (i2 < this.hNI.thread_list.size()) {
                        ThreadInfo threadInfo = this.hNI.thread_list.get(i2);
                        if (threadInfo == null || threadInfo.tid == null || threadInfo.tid.longValue() != j) {
                            i2++;
                        } else {
                            this.hNI.thread_list.remove(i2);
                            bIM();
                            com.baidu.tieba.homepage.personalize.b.d.a(threadInfo.tid.longValue(), i2, this.hNI.thread_list, this.mDataList);
                            break;
                        }
                    } else {
                        break;
                    }
                }
                if (this.hcS != null) {
                    List<Integer> b = b(optString, this.hcS);
                    int intValue = b.get(0).intValue();
                    int intValue2 = b.get(1).intValue();
                    if (intValue != -1 && intValue2 != -1) {
                        this.hcS.l(intValue, intValue2);
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
                    if (cVar.aIw() != null && cVar.aIw().getTid().equals(str)) {
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
                    advertAppInfo = ((com.baidu.tieba.homepage.personalize.data.a) next).bFo();
                } else {
                    if (next instanceof ae) {
                        ae aeVar = (ae) next;
                        if (aeVar.aJc() instanceof AdvertAppInfo.ILegoAdvert) {
                            advertAppInfo = ((AdvertAppInfo.ILegoAdvert) aeVar.aJc()).getAdvertAppInfo();
                        }
                    }
                    advertAppInfo = advertAppInfo2;
                }
                if (advertAppInfo != null && str.equals(advertAppInfo.dmo)) {
                    it.remove();
                    advertAppInfo = null;
                }
                advertAppInfo2 = advertAppInfo;
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (this.gHr != null) {
            this.gHr.onChangeSkinType(i);
        }
    }

    public FloatInfo bZI() {
        return this.hNS;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public af bZg() {
        if (this.gHv == null || this.gHv.cJH() == null || !(this.gHv.cJH().getTag() instanceof af)) {
            return null;
        }
        return (af) this.gHv.cJH().getTag();
    }
}
