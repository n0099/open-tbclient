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
    private View.OnTouchListener dUs;
    private y ehd;
    private m gHB;
    private aw gHw;
    private SmartBubbleAnimatedView gHx;
    private com.baidu.tieba.tbadkCore.data.f gYs;
    private boolean hGt;
    private final BigdaySwipeRefreshLayout hIm;
    private ScrollFragmentTabHost hMV;
    private final long hNL;
    private final b hNM;
    private DataRes.Builder hNO;
    private final com.baidu.tieba.homepage.personalize.model.a hNR;
    private int hNU;
    private g hNW;
    private BdUniqueId hNZ;
    private final ad hNh;
    private int hOa;
    private Runnable hOg;
    private final BdTypeRecyclerView hcY;
    private com.baidu.tieba.f.a hxq;
    private final TbPageContext<?> mPageContext;
    private a hNN = null;
    private final List<com.baidu.adp.widget.ListView.m> mDataList = new LinkedList();
    private int mPn = 1;
    private boolean mIsLoading = false;
    private boolean hIu = false;
    private int hNP = 2;
    private int hNQ = 0;
    private TextView mTipView = null;
    private int hcJ = 2000;
    private com.baidu.tbadk.n.c hNS = null;
    private boolean haL = false;
    private int hac = 0;
    private int eNZ = 0;
    private boolean mIsBackground = false;
    private boolean hMQ = true;
    private boolean hNT = false;
    private boolean hNV = false;
    private boolean hNX = true;
    private FloatInfo hNY = null;
    private a.C0095a gYK = new a.C0095a(2);
    private RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.e.12
        private int hOp = -1;
        private int hIC = 0;
        private boolean hOq = false;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (e.this.hNS == null) {
                e.this.hNS = new com.baidu.tbadk.n.c();
                e.this.hNS.setSubType(1005);
                e.this.hNS.pageType = 1;
            }
            if (e.this.ehd != null && !e.this.mIsBackground) {
                e.this.ehd.l(recyclerView, i);
            }
            if (i == 0) {
                c.d(e.this.hcY);
                e.this.hNS.aZp();
                r.bEX().jd(true);
                com.baidu.tieba.a.d.bfN().cF("page_recommend", "show_");
                com.baidu.tieba.s.c.cVp().b(e.this.hNZ, false);
                this.hOq = false;
                if (e.this.gHB != null && e.this.hMQ && !e.this.mIsBackground) {
                    e.this.gHB.a(e.this.hac, e.this.eNZ, e.this.haL, 1);
                    return;
                }
                return;
            }
            e.this.hNS.aZo();
            if (i == 1) {
                if (e.this.gHw != null) {
                    e.this.gHw.hideTip();
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
            if (this.hIC > i) {
                this.hOq = true;
            }
            if (e.this.ehd != null && !e.this.mIsBackground) {
                e.this.ehd.onScroll(this.hIC, i);
            }
            this.hIC = i;
            int i3 = (i + i2) - 1;
            if (!this.hOq && this.hOp != i3) {
                this.hOp = i3;
                e.this.vW(this.hOp);
            }
            if (this.hOq && this.hOp != i) {
                this.hOp = i;
                e.this.vW(this.hOp);
            }
            e.this.hOf = i;
            e.this.hac = i;
            e.this.eNZ = (i + i2) - 1;
            af bZf = e.this.bZf();
            if (bZf != null && bZf.rD() != null) {
                bZf.rD().b(e.this.gYK);
            }
        }
    };
    private View.OnTouchListener dSb = new View.OnTouchListener() { // from class: com.baidu.tieba.homepage.personalize.e.22
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (e.this.dUs != null) {
                e.this.dUs.onTouch(view, motionEvent);
            }
            if (e.this.hxq != null) {
                e.this.hxq.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private a.InterfaceC0557a gxj = new a.InterfaceC0557a() { // from class: com.baidu.tieba.homepage.personalize.e.23
        @Override // com.baidu.tieba.f.a.InterfaceC0557a
        public void y(int i, int i2) {
            e.this.haL = false;
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0557a
        public void z(int i, int i2) {
            e.this.haL = true;
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0557a
        public void bG(int i, int i2) {
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0557a
        public void A(int i, int i2) {
        }
    };
    private View.OnClickListener hOb = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.e.24
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (e.this.gHw != null) {
                e.this.gHw.hideTip();
            }
        }
    };
    private final CustomMessageListener hOc = new CustomMessageListener(CmdConfigCustom.CMD_RELOAD_HP_PERSONALIZED) { // from class: com.baidu.tieba.homepage.personalize.e.25
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (e.this.hcY != null) {
                e.this.gHB.bZe();
                e.this.hMQ = false;
                e.this.hIm.setRefreshing(true);
            }
        }
    };
    private CustomMessageListener hpW = new CustomMessageListener(CmdConfigCustom.PB_ACTION_PRAISE) { // from class: com.baidu.tieba.homepage.personalize.e.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            bj bjVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bj) && e.this.hNO != null && v.getCount(e.this.hNO.thread_list) != 0 && (bjVar = (bj) customResponsedMessage.getData()) != null && bjVar.aKn() != null && bjVar.getId() != null && v.getCount(e.this.hNO.thread_list) != 0) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < e.this.hNO.thread_list.size()) {
                        ThreadInfo threadInfo = e.this.hNO.thread_list.get(i2);
                        if (threadInfo == null || threadInfo.id.longValue() != com.baidu.adp.lib.f.b.toLong(bjVar.getId(), -1L)) {
                            i = i2 + 1;
                        } else {
                            ThreadInfo.Builder builder = new ThreadInfo.Builder(threadInfo);
                            Zan.Builder builder2 = new Zan.Builder(builder.zan);
                            builder2.num = Integer.valueOf((int) bjVar.aKn().getNum());
                            builder.zan = builder2.build(true);
                            e.this.hNO.thread_list.set(i2, builder.build(true));
                            return;
                        }
                    } else {
                        return;
                    }
                }
            }
        }
    };
    private CustomMessageListener hOd = new CustomMessageListener(CmdConfigCustom.CMD_LIVE_VIDEO_CLOSED_QUERY_RESPONSED) { // from class: com.baidu.tieba.homepage.personalize.e.6
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
                        if ((originData.get(i2) instanceof bj) && (bjVar = (bj) originData.get(i2)) != null && bjVar.aKV() != null && ids.contains(Long.valueOf(bjVar.aKV().live_id))) {
                            e.this.mDataList.remove(bjVar);
                        }
                        i = i2 + 1;
                    }
                    if (e.this.hNh != null) {
                        e.this.hNh.ak(new ArrayList(e.this.mDataList));
                    }
                }
            }
        }
    };
    private CustomMessageListener dzL = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.homepage.personalize.e.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int intValue;
            if ((customResponsedMessage instanceof UpdateAttentionMessage) && e.this.hNO != null && !v.isEmpty(e.this.hNO.thread_list)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid)) {
                    int i = 0;
                    while (true) {
                        if (i >= e.this.hNO.thread_list.size()) {
                            break;
                        }
                        ThreadInfo threadInfo = e.this.hNO.thread_list.get(i);
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
                            e.this.hNO.thread_list.set(i, builder.build(true));
                        }
                    }
                    e.this.a(updateAttentionMessage);
                }
            }
        }
    };
    private String hOe = "lastReadReadPositionKey";
    private int hOf = 0;
    private d hOh = new d() { // from class: com.baidu.tieba.homepage.personalize.e.11
        @Override // com.baidu.tieba.homepage.personalize.d
        public void vF(final int i) {
            if (e.this.hOg == null) {
                e.this.hOg = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.e.11.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (e.this.hcY.getHandler() != null) {
                            e.this.hcY.requestFocusFromTouch();
                            if (i <= e.this.hcY.getCount() - 1) {
                                e.this.hcY.setSelection(i);
                            }
                        }
                    }
                };
            }
            e.this.hcY.removeCallbacks(e.this.hOg);
            e.this.hcY.post(e.this.hOg);
        }
    };
    private CustomMessageListener hOi = new CustomMessageListener(2016569) { // from class: com.baidu.tieba.homepage.personalize.e.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && e.this.hNW != null) {
                e.this.mDataList.remove(e.this.hNW);
                e.this.hNh.ak(new ArrayList(e.this.mDataList));
                com.baidu.tbadk.core.sharedPref.b.aNT().putLong("key_maintab_banner_close_time", System.currentTimeMillis());
            }
        }
    };
    private CustomMessageListener gHs = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.homepage.personalize.e.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.g(customResponsedMessage);
            if (e.this.gHB != null && e.this.hMQ) {
                e.this.gHB.a(e.this.hac, e.this.eNZ, e.this.haL, true);
            }
        }
    };
    private CustomMessageListener gHt = new CustomMessageListener(CmdConfigCustom.CMD_THREAD_NOT_EXIST_WHEN_ENTER_PB) { // from class: com.baidu.tieba.homepage.personalize.e.17
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.g(customResponsedMessage);
        }
    };
    private CustomMessageListener hqk = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.homepage.personalize.e.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && e.this.hNO != null && v.getCount(e.this.hNO.thread_list) != 0) {
                String str = (String) customResponsedMessage.getData();
                e.this.h(str, e.this.mDataList);
                e.this.DV(str);
                if (e.this.hNh != null) {
                    e.this.hNh.ak(new ArrayList(e.this.mDataList));
                }
                if (e.this.gHB != null && e.this.hMQ) {
                    e.this.gHB.a(e.this.hac, e.this.eNZ, e.this.haL, true);
                }
            }
        }
    };
    private CustomMessageListener gZT = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.homepage.personalize.e.19
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            af bZf;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent)) {
                KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24 && (bZf = e.this.bZf()) != null && bZf.rD() != null) {
                    bZf.rD().b(new a.C0095a(3));
                }
            }
        }
    };
    private com.baidu.adp.framework.listener.a hOj = new com.baidu.adp.framework.listener.a(1003065, CmdConfigSocket.CMD_TOPIC_BLESS) { // from class: com.baidu.tieba.homepage.personalize.e.20
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
                        if ((mVar instanceof com.baidu.tieba.homepage.topic.topictab.b.a) && (bVar = ((com.baidu.tieba.homepage.topic.topictab.b.a) mVar).hTa) != null && longValue == bVar.pkId) {
                            bVar.userPkId = j2;
                            return;
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener gZU = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.homepage.personalize.e.21
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int[] imageWidthAndHeight;
            List<com.baidu.adp.widget.ListView.m> dataList = e.this.hNh.getDataList();
            if (!v.isEmpty(dataList)) {
                for (com.baidu.adp.widget.ListView.m mVar : dataList) {
                    if (mVar instanceof k) {
                        k kVar = (k) mVar;
                        if (kVar.dqF != 0 && kVar.dqE != null) {
                            if ((TbSingleton.getInstance().getHomePageStyleAbTest() & 4) != 0) {
                                imageWidthAndHeight = kVar.dqE.aMu();
                            } else {
                                imageWidthAndHeight = kVar.dqE.getImageWidthAndHeight();
                            }
                            kVar.dqF = imageWidthAndHeight[0];
                            kVar.dqG = imageWidthAndHeight[1];
                        }
                    }
                }
            }
            com.baidu.adp.lib.f.e.lb().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.personalize.e.21.1
                @Override // java.lang.Runnable
                public void run() {
                    e.this.hNh.notifyDataSetChanged();
                    if (!e.this.mIsBackground && e.this.hMQ) {
                        e.this.gHB.a(e.this.hac, e.this.eNZ, e.this.haL, true);
                    }
                }
            }, 500L);
        }
    };

    /* loaded from: classes9.dex */
    public interface a {
        void Q(int i, int i2, int i3);

        void bZv();

        void onError(int i, String str);

        void onSuccess();

        void z(int i, int i2, int i3, int i4);
    }

    public void nR(boolean z) {
        this.hNX = z;
        if (this.gHw != null && !z) {
            this.gHw.hideTip();
        }
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.hMV = scrollFragmentTabHost;
        if (this.hMV != null) {
            this.hMV.setOnTabSelectedListener(new ScrollFragmentTabHost.b() { // from class: com.baidu.tieba.homepage.personalize.e.1
                @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.b
                public void vP(int i) {
                    if (e.this.hMV.vO(i) != 1 && e.this.gHw != null) {
                        e.this.gHw.hideTip();
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
        if (this.hMV != null) {
            this.hMV.mC(z);
        }
        if (this.gHB != null) {
            this.gHB.pL(!z);
            af bZf = bZf();
            if (bZf != null && bZf.rD() != null) {
                z2 = bZf.rD().b(new a.C0095a(8, Boolean.valueOf(z)));
            }
            if (!z2) {
                if (z) {
                    this.gHB.bZe();
                } else if (this.hMQ) {
                    this.gHB.a(this.hac, this.eNZ, this.haL, true);
                }
            }
        }
    }

    public e(TbPageContext<?> tbPageContext, BdTypeRecyclerView bdTypeRecyclerView, ad adVar, BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout) {
        this.hOa = 0;
        this.mPageContext = tbPageContext;
        this.hOa = com.baidu.tbadk.core.sharedPref.b.aNT().getInt("key_personalized_refresh_type", 0);
        this.hIm = bigdaySwipeRefreshLayout;
        this.hcY = bdTypeRecyclerView;
        this.hcY.setOnTouchListener(this.dSb);
        this.hxq = new com.baidu.tieba.f.a();
        this.hxq.a(this.gxj);
        this.hNh = adVar;
        this.hNR = new com.baidu.tieba.homepage.personalize.model.a();
        this.hNL = com.baidu.tbadk.core.sharedPref.b.aNT().getLong("recommend_frs_cache_time", 3600L) * 1000;
        bdTypeRecyclerView.setOnScrollListener(this.mOnScrollListener);
        this.gHw = new aw();
        bZF();
        this.gHB = new m(this.mPageContext, this.hcY);
        this.gHB.AZ(1);
        this.gHB.AY(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.hNM = new b(this.mDataList, this.hNh);
        this.gHx = new SmartBubbleAnimatedView(tbPageContext.getContext());
        this.gHx.setLayoutParams(new FrameLayout.LayoutParams(-1, l.getDimens(tbPageContext.getContext(), R.dimen.tbds83)));
        bZw();
        this.gZU.setTag(this.mPageContext.getUniqueId());
        MessageManager.getInstance().registerListener(this.gZU);
    }

    private void bZw() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2016323, new CustomMessageTask.CustomRunnable<Boolean>() { // from class: com.baidu.tieba.homepage.personalize.e.26
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Boolean> customMessage) {
                af bZf = e.this.bZf();
                return (bZf == null || bZf.rD() == null) ? new CustomResponsedMessage<>(2016323, false) : new CustomResponsedMessage<>(2016323, Boolean.valueOf(bZf.rD().b(new a.C0095a(6))));
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private boolean bZx() {
        return com.baidu.tbadk.core.sharedPref.b.aNT().getBoolean(bZz(), true);
    }

    private void bZy() {
        com.baidu.tbadk.core.sharedPref.b.aNT().putBoolean(bZz(), false);
    }

    private String bZz() {
        return "key_rec_pfirst_load_" + TbadkCoreApplication.getCurrentAccount() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + TbConfig.getVersion();
    }

    public void setRecommendFrsNavigationAnimDispatcher(z zVar) {
        if (zVar != null) {
            this.ehd = zVar.baA();
            this.dUs = zVar.baB();
        }
    }

    public void showFloatingView() {
        if (this.ehd != null) {
            this.ehd.ic(true);
        }
    }

    public void update() {
        com.baidu.tieba.homepage.framework.a.bYh().q(System.currentTimeMillis(), 1);
        this.mPn = 1;
        this.hNV = true;
        if (this.mDataList.size() == 0 && !bZx()) {
            if (!this.hIu) {
                aIm();
                return;
            }
            return;
        }
        aIl();
    }

    public void cb(int i, int i2) {
        bj bjVar;
        if (!v.isEmpty(this.mDataList) && this.mDataList.size() > i) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            while (i < this.mDataList.size() && i <= i2) {
                if (this.mDataList.get(i).getType().getId() == bj.dra.getId() && (bjVar = (bj) this.mDataList.get(i)) != null && bjVar.aKV() != null) {
                    arrayList.add(Long.valueOf(bjVar.aKV().live_id));
                    arrayList2.add(bjVar);
                }
                i++;
            }
            if (!v.isEmpty(arrayList)) {
                MessageManager.getInstance().sendMessage(new LiveRoomClosedQueryMessage(arrayList, arrayList2));
            }
        }
    }

    public void bZA() {
        if (this.gHB != null && !this.mIsBackground && this.hMQ) {
            this.gHB.a(this.hac, this.eNZ, this.haL, true);
        }
        if (this.hNT) {
            if (this.hIm != null && !this.hIm.aQr()) {
                if (this.hGt) {
                    com.baidu.tieba.s.c.cVp().b(this.hNZ, false);
                    if (nT(false)) {
                        cc(3, this.hNQ);
                    } else if (this.hNU > 0) {
                        cc(2, this.hNQ);
                    }
                } else if (!this.hGt && this.hNQ == 0) {
                    cc(2, 0);
                }
            }
            this.hNT = false;
            this.hGt = false;
            this.hNU = 0;
            if (this.hNV) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
            }
            this.hNV = false;
        }
    }

    public void bkZ() {
        if (isLoading()) {
            com.baidu.tieba.homepage.framework.a.bYh().q(0L, 1);
        } else if (this.hNN != null) {
            bZC();
            this.mPn++;
            setIsLoading(true);
            this.hNN.z(this.mPn, (this.hNO == null || this.hNO.thread_list == null) ? 0 : this.hNO.thread_list.size(), nS(false), 0);
        }
    }

    public void a(boolean z, boolean z2, DataRes dataRes, int i, String str) {
        int size = (this.hNO == null || this.hNO.thread_list == null) ? 0 : this.hNO.thread_list.size();
        if (!z && i == 0 && dataRes != null && v.isEmpty(dataRes.thread_list)) {
            if (this.hNN != null) {
                this.hNN.bZv();
            }
            setIsLoading(false);
            if (this.hIm != null) {
                this.hIm.setRefreshing(false);
                return;
            }
            return;
        }
        if (i != 0 || dataRes == null || !a(true, z, z2, dataRes)) {
            this.hNT = false;
            if (this.mDataList.size() > 0) {
                if (this.hNN != null) {
                    this.hNN.onError(1, str);
                }
            } else if (this.hNN != null) {
                this.hNN.onError(2, str);
            }
        } else {
            bZy();
            if (this.hNN != null) {
                com.baidu.tbadk.core.sharedPref.b.aNT().putLong(SharedPrefConfig.RECOMMEND_FRS_REFRESH_TIME + TbadkCoreApplication.getCurrentAccount(), System.currentTimeMillis());
                this.hNN.onSuccess();
            }
            this.hNT = true;
            this.hGt = z;
            this.hNU = size;
            bIL();
        }
        setIsLoading(false);
        if (this.hIm != null) {
            g.e bZB = bZB();
            if (this.hIm.aQr() && bZB != null) {
                this.hIm.c(bZB);
            } else {
                this.hIm.setRefreshing(false);
            }
        }
    }

    private g.e bZB() {
        int i;
        String feedText;
        if (this.hNT && this.hIm != null && this.hIm.aQr()) {
            int i2 = this.hNQ;
            if (this.hGt) {
                com.baidu.tieba.s.c.cVp().b(this.hNZ, false);
                if (nT(false)) {
                    i = 3;
                } else {
                    i = this.hNU > 0 ? 2 : 0;
                }
            } else if (this.hGt || this.hNQ != 0) {
                return null;
            } else {
                i2 = 0;
                i = 2;
            }
            if (this.hMV != null) {
                this.gHw.bQF();
            }
            if (this.hMV != null && this.hMV.getCurrentTabType() != 1) {
                this.gHw.hideTip();
                return null;
            } else if (!this.hNX) {
                this.gHw.hideTip();
                return null;
            } else {
                this.hNP = i;
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
                    this.hcJ = 1000;
                } else {
                    this.hcJ = 0;
                }
                return new g.e(feedText, this.hcJ);
            }
        }
        return null;
    }

    public void nH(boolean z) {
        if (z) {
            this.hNh.notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        if (this.gHB != null) {
            this.gHB.destroy();
        }
        if (this.gHw != null) {
            this.gHw.onDestroy();
        }
        if (this.hNM != null) {
            this.hNM.onDestroy();
        }
        if (this.hcY != null) {
            this.hcY.removeCallbacks(this.hOg);
        }
        MessageManager.getInstance().unRegisterTask(2016323);
        MessageManager.getInstance().unRegisterListener(this.gZU);
    }

    public void onPause() {
        c.d(this.hcY);
        vX(this.hOf);
        if (this.hNS != null) {
            this.hNS.aZq();
        }
    }

    private void aIl() {
        if (this.hNN != null) {
            this.hNN.Q((this.hNO == null || this.hNO.thread_list == null || bZE()) ? 0 : this.hNO.thread_list.size(), nS(true), 0);
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
                if (!(mVar instanceof com.baidu.tieba.homepage.personalize.data.a) || mVar.getType() == AdvertAppInfo.dmh) {
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
                if ((mVar2 instanceof com.baidu.tieba.homepage.personalize.data.a) && mVar2.getType() != AdvertAppInfo.dmh) {
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
        this.hIu = true;
        if (dataRes != null) {
            if (a(false, true, true, dataRes) && !bZE()) {
                if (this.hNN != null) {
                    this.hNN.onSuccess();
                    Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler() { // from class: com.baidu.tieba.homepage.personalize.e.27
                        @Override // android.os.MessageQueue.IdleHandler
                        public boolean queueIdle() {
                            e.this.aZv();
                            return false;
                        }
                    });
                    return;
                }
                return;
            }
            aIl();
            return;
        }
        aIl();
    }

    public void aZv() {
        long vD = com.baidu.tieba.homepage.framework.a.bYh().vD(1) + com.baidu.tieba.homepage.framework.a.bYh().getCreateTime();
        long vB = com.baidu.tieba.homepage.framework.a.bYh().vB(1);
        if (vB > 0) {
            vD = System.currentTimeMillis() - vB;
        }
        n.aZD().cQ(vD);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.util.Set] */
    private void i(List<com.baidu.adp.widget.ListView.m> list, int i) {
        AdvertAppInfo bFn;
        AdvertAppInfo bFn2;
        if (!v.isEmpty(list)) {
            Set<com.baidu.adp.widget.ListView.m> JH = com.baidu.tieba.recapp.report.a.JH("NEWINDEX");
            HashSet hashSet = JH == null ? new HashSet() : JH;
            HashSet hashSet2 = new HashSet();
            for (com.baidu.adp.widget.ListView.m mVar : list) {
                if (mVar != null) {
                    for (com.baidu.adp.widget.ListView.m mVar2 : hashSet) {
                        if ((mVar instanceof com.baidu.tieba.card.data.d) && (bFn2 = ((com.baidu.tieba.card.data.d) mVar).bFn()) != null && mVar2 != null && (mVar2 instanceof AdvertAppInfo) && mVar2.hashCode() == bFn2.hashCode()) {
                            bFn2.advertAppContext = ((AdvertAppInfo) mVar2).advertAppContext;
                        }
                    }
                    if (mVar != null && (mVar instanceof com.baidu.tieba.card.data.d) && (bFn = ((com.baidu.tieba.card.data.d) mVar).bFn()) != null && bFn.advertAppContext == null) {
                        bFn.advertAppContext = new com.baidu.tbadk.core.data.c();
                        bFn.advertAppContext.page = "NEWINDEX";
                        bFn.advertAppContext.pn = this.mPn;
                        bFn.advertAppContext.extensionInfo = bFn.extensionInfo;
                        bFn.advertAppContext.WL = false;
                        hashSet2.add(bFn);
                    }
                }
            }
            hashSet.addAll(hashSet2);
            com.baidu.tieba.recapp.report.a.b("NEWINDEX", hashSet);
            if (hashSet2.size() > 0) {
                com.baidu.tieba.s.c.cVp().b(this.hNZ, com.baidu.tieba.s.a.b(PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE, "common_fill", true, hashSet2.size()));
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
        if (this.hOa == 1) {
            if (z2 && (dataRes.thread_list.size() >= 6 || bZE())) {
                bZD();
                this.hNO = null;
            }
        } else if (z2 && bZE()) {
            this.hNO = null;
        }
        int size = z2 ? 0 : this.mDataList.size();
        DataRes.Builder builder = new DataRes.Builder(dataRes);
        this.mDataList.clear();
        com.baidu.tieba.homepage.personalize.model.c a2 = this.hNR.a(z, this.hNO, builder, z2 ? 0 : 1);
        if (a2 == null) {
            list = null;
            i = 0;
        } else {
            List<com.baidu.adp.widget.ListView.m> list2 = a2.etL;
            this.hNQ = a2.hQC;
            int i2 = a2.hQD;
            a2.hQD = 0;
            list = list2;
            i = i2;
        }
        if (list != null) {
            this.mDataList.addAll(list);
            i(list, size);
            a(z2 ? 0 : 1, list, size);
            if (this.hNV) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
            }
        }
        if (this.hNO == null) {
            this.hNO = builder;
            this.hNM.cN(this.hNO.thread_list);
        }
        if (this.mDataList.size() == 0) {
            z4 = false;
        } else {
            if (z2) {
                if (dataRes.live_answer != null) {
                    this.hNW = new com.baidu.tieba.homepage.personalize.data.g();
                    this.hNW.a(dataRes.live_answer);
                    this.hNO.live_answer = dataRes.live_answer;
                } else if (z) {
                    this.hNW = null;
                    this.hNO.live_answer = null;
                }
                this.hNY = dataRes.float_info;
                this.hNO.float_info = dataRes.float_info;
            }
            long j = com.baidu.tbadk.core.sharedPref.b.aNT().getLong("key_maintab_banner_close_time", 0L);
            if (this.hNW != null && !aq.isTaday(j)) {
                this.mDataList.add(0, this.hNW);
            }
            LinkedList linkedList = new LinkedList(this.mDataList);
            this.hNh.setFromCDN(dataRes.is_new_url.intValue() == 1);
            this.hNh.j(linkedList, i);
            z4 = true;
            if (this.gHB != null && this.hMQ) {
                this.gHB.a(this.hac, this.eNZ, this.haL, true);
            }
        }
        com.baidu.tieba.homepage.framework.a.bYh().o(System.currentTimeMillis() - currentTimeMillis, 1);
        long vE = com.baidu.tieba.homepage.framework.a.bYh().vE(1);
        if (vE > 0) {
            com.baidu.tieba.homepage.framework.a.bYh().p(System.currentTimeMillis() - vE, 1);
            com.baidu.tieba.homepage.framework.a.bYh().q(0L, 1);
        }
        if (dataRes.anti != null && dataRes.anti.block_pop_info != null) {
            com.baidu.tieba.ueg.d.d(dataRes.anti.block_pop_info);
        }
        ay ayVar = new ay();
        ayVar.a(dataRes.recom_post_topic);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_REFRESH_TOPIC_TIP, ayVar));
        return z4;
    }

    private void bZC() {
        List<com.baidu.adp.widget.ListView.m> list;
        int i;
        if (v.getCount(this.mDataList) >= this.hNR.bZZ() - 40) {
            com.baidu.tieba.homepage.personalize.model.c a2 = this.hNR.a(true, this.hNO, (DataRes.Builder) null, 1);
            if (a2 != null) {
                List<com.baidu.adp.widget.ListView.m> list2 = a2.etL;
                i = a2.hQD;
                a2.hQD = 0;
                list = list2;
            } else {
                list = null;
                i = 0;
            }
            if (list != null) {
                this.mDataList.clear();
                this.mDataList.addAll(list);
                this.hNh.j(new LinkedList(this.mDataList), i);
            }
        }
    }

    private void aIm() {
        this.hIu = true;
        ac.a(new ab<DataRes>() { // from class: com.baidu.tieba.homepage.personalize.e.28
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.ab
            /* renamed from: bZJ */
            public DataRes doInBackground() {
                com.baidu.adp.lib.cache.l<byte[]> cA = com.baidu.tbadk.core.c.a.aMR().cA("tb.rec_frs_update", TbadkCoreApplication.getCurrentAccount());
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

    private void bIL() {
        if (this.hNO != null) {
            DataRes.Builder builder = new DataRes.Builder(this.hNO.build(true));
            if (builder.thread_list != null && builder.thread_list.size() > 30) {
                builder.thread_list = builder.thread_list.subList(0, 30);
            }
            a(builder, builder.thread_list != null ? builder.thread_list.size() : 0);
            a(builder);
            b(builder);
        }
    }

    private void bZD() {
        if (this.hNO != null) {
            final DataRes.Builder builder = new DataRes.Builder(this.hNO.build(true));
            if (builder.thread_list != null && builder.thread_list.size() > 50) {
                builder.thread_list = builder.thread_list.subList(0, 50);
            }
            a(builder, builder.thread_list != null ? builder.thread_list.size() : 0);
            ac.a(new ab<Object>() { // from class: com.baidu.tieba.homepage.personalize.e.3
                @Override // com.baidu.tbadk.util.ab
                public Object doInBackground() {
                    DataRes.Builder builder2 = new DataRes.Builder(builder.build(true));
                    e.this.hNM.cO(builder2.thread_list);
                    try {
                        com.baidu.tbadk.core.c.a.aMR().cA("tb.rec_old_data", TbadkCoreApplication.getCurrentAccount()).setForever("0", builder2.build(true).toByteArray());
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
    public void DV(String str) {
        if (!TextUtils.isEmpty(str) && this.hNO != null && this.hNO.banner_list != null && this.hNO.banner_list.app != null && this.hNO.banner_list.app.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (App app : this.hNO.banner_list.app) {
                if (app != null && str.equals(app.id)) {
                    arrayList.add(app);
                }
            }
            BannerList.Builder builder = new BannerList.Builder(this.hNO.banner_list);
            if (builder.app != null) {
                builder.app.removeAll(arrayList);
            }
            this.hNO.banner_list = builder.build(false);
            DataRes.Builder builder2 = new DataRes.Builder(this.hNO.build(true));
            builder2.banner_list = builder.build(true);
            b(builder2);
        }
    }

    private void b(final DataRes.Builder builder) {
        ac.a(new ab<Object>() { // from class: com.baidu.tieba.homepage.personalize.e.4
            @Override // com.baidu.tbadk.util.ab
            public Object doInBackground() {
                DataRes.Builder builder2 = new DataRes.Builder(builder.build(true));
                e.this.hNM.cO(builder2.thread_list);
                try {
                    com.baidu.tbadk.core.c.a.aMR().cA("tb.rec_frs_update", TbadkCoreApplication.getCurrentAccount()).setForever("0", builder2.build(true).toByteArray());
                    return null;
                } catch (Exception e) {
                    BdLog.e(e);
                    return null;
                }
            }
        }, null);
    }

    private boolean bZE() {
        return nT(true);
    }

    private boolean nT(boolean z) {
        long j = com.baidu.tbadk.core.sharedPref.b.aNT().getLong(SharedPrefConfig.RECOMMEND_FRS_REFRESH_TIME + TbadkCoreApplication.getCurrentAccount(), 0L);
        return j == 0 ? z : Math.abs(System.currentTimeMillis() - j) > this.hNL;
    }

    public void a(a aVar) {
        this.hNN = aVar;
    }

    private boolean isLoading() {
        return this.mIsLoading;
    }

    private void setIsLoading(boolean z) {
        this.mIsLoading = z;
    }

    public void bZs() {
        boolean z = true;
        com.baidu.tbadk.coreExtra.data.b activityPrizeData = TbadkCoreApplication.getInst().getActivityPrizeData();
        if (activityPrizeData.isSwitchTurn() && !StringUtils.isNull(activityPrizeData.getFeedText())) {
            String currentDay = UtilHelper.getCurrentDay();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            String str = "";
            if (!StringUtils.isNull(currentAccount)) {
                String string = com.baidu.tbadk.core.sharedPref.b.aNT().getString(SharedPrefConfig.ACTIVITY_PRIZE_FEED_TEXT_TIME, "");
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
                    com.baidu.tbadk.core.sharedPref.b.aNT().putString(SharedPrefConfig.ACTIVITY_PRIZE_FEED_TEXT_TIME, str);
                }
            }
        }
    }

    private void cc(int i, int i2) {
        if (this.hMV != null) {
            this.gHw.bQF();
        }
        if (this.hMV != null && this.hMV.getCurrentTabType() != 1) {
            this.gHw.hideTip();
        } else if (!this.hNX) {
            this.gHw.hideTip();
        } else {
            this.hNP = i;
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
                    this.hcJ = 3000;
                } else {
                    this.hcJ = 2000;
                }
                this.gHx.dHw = str;
                this.gHx.hcC = this.hcJ;
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 49;
                if (this.hMV != null) {
                    FrameLayout frameLayout = this.hMV.getFrameLayout();
                    frameLayout.removeView(this.gHx);
                    frameLayout.addView(this.gHx, layoutParams);
                    this.gHx.bQD();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(Long l) {
        if (this.hNO != null && this.hNO.thread_list != null) {
            List<ThreadInfo> list = this.hNO.thread_list;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                ThreadInfo threadInfo = list.get(i);
                if (threadInfo.tid.equals(l) && threadInfo.top_agree_post != null) {
                    ThreadInfo.Builder builder = new ThreadInfo.Builder(threadInfo);
                    builder.top_agree_post = null;
                    list.set(i, builder.build(true));
                    bIL();
                    a(false, true, false, this.hNO.build(true));
                    return;
                }
            }
        }
    }

    public void m(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.hNZ = bdUniqueId;
            if (this.hpW != null) {
                this.hpW.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.hpW);
            }
            if (this.hOc != null) {
                this.hOc.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.hOc);
            }
            this.dzL.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.dzL);
            this.hOd.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.hOd);
            this.gHs.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.gHs);
            this.gHt.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.gHt);
            this.hqk.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.hqk);
            if (this.gHB != null) {
                this.gHB.setUniqueId(bdUniqueId);
            }
            this.hNM.j(bdUniqueId);
            this.hOi.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.hOi);
            this.gZT.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.gZT);
            this.hOj.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.hOj);
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
                        com.baidu.adp.lib.cache.l<byte[]> cA = com.baidu.tbadk.core.c.a.aMR().cA("tb.rec_frs_update", TbadkCoreApplication.getCurrentAccount());
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
                        e.this.hNM.cO(builder5.thread_list);
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

    public void bZF() {
        this.gYs = new com.baidu.tieba.tbadkCore.data.f("new_index", null);
        this.gYs.cVW();
    }

    public void a(int i, List<com.baidu.adp.widget.ListView.m> list, int i2) {
        int i3;
        int i4;
        if (this.gYs != null) {
            if (i == 0) {
                this.gYs.cVW();
            }
            if (list != null && !list.isEmpty()) {
                int[] iArr = com.baidu.tieba.tbadkCore.data.f.kRT;
                int i5 = 0;
                int i6 = 0;
                int i7 = 0;
                while (i7 < list.size() && i6 < iArr.length && (i3 = iArr[i6]) >= 0) {
                    if (list.get(i7) instanceof com.baidu.tieba.card.data.c) {
                        i4 = i5 + 1;
                        if (i4 == i3 - 1) {
                            if (i2 < i7 + 1) {
                                this.gYs.cP(i3, i7 + 1);
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
        if ((this.gYs != null ? this.gYs.Df(i) : -1) >= 0 && this.hcY != null && this.hcY.getData() != null && this.hcY.getData().size() > i) {
            this.gYs.Dg(i);
        }
    }

    public m bPu() {
        return this.gHB;
    }

    public void nN(boolean z) {
        this.hMQ = z;
    }

    public void vX(final int i) {
        ac.a(new ab<Object>() { // from class: com.baidu.tieba.homepage.personalize.e.10
            @Override // com.baidu.tbadk.util.ab
            public Object doInBackground() {
                com.baidu.adp.lib.cache.l<String> cB = com.baidu.tbadk.core.c.a.aMR().cB(e.this.hOe, TbadkCoreApplication.getCurrentAccount());
                if (cB != null) {
                    cB.set(e.this.hOe, Integer.toString(i), 43200000L);
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
            /* renamed from: bZI */
            public String doInBackground() {
                com.baidu.adp.lib.cache.l<String> cB = com.baidu.tbadk.core.c.a.aMR().cB(e.this.hOe, TbadkCoreApplication.getCurrentAccount());
                if (cB != null) {
                    return cB.get(e.this.hOe);
                }
                return null;
            }
        }, new com.baidu.tbadk.util.l<String>() { // from class: com.baidu.tieba.homepage.personalize.e.14
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.l
            /* renamed from: DW */
            public void onReturnDataInUI(String str) {
                if (dVar != null) {
                    dVar.vF(com.baidu.adp.lib.f.b.toInt(str, 0));
                }
            }
        });
    }

    public void bZt() {
        c.e(this.hcY);
    }

    public void bZG() {
        a(this.hOh);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(CustomResponsedMessage<?> customResponsedMessage) {
        boolean z;
        String str;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.hNO != null && v.getCount(this.hNO.thread_list) != 0 && v.getCount(this.mDataList) != 0) {
            JSONObject jSONObject = (JSONObject) customResponsedMessage.getData();
            String optString = jSONObject.optString("tid");
            if (StringUtils.isNull(optString)) {
                String optString2 = jSONObject.optString(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_ID);
                if (this.hcY != null && !TextUtils.isEmpty(optString2)) {
                    int i = 0;
                    while (true) {
                        if (i >= this.hcY.getCount()) {
                            str = optString;
                            break;
                        }
                        com.baidu.adp.widget.ListView.m item = this.hcY.getItem(i);
                        if (item instanceof com.baidu.tieba.card.data.j) {
                            com.baidu.tieba.card.data.j jVar = (com.baidu.tieba.card.data.j) item;
                            if (jVar.aIu() != null && jVar.aIu().aKV() != null && optString2.equals(String.valueOf(jVar.aIu().aKV().live_id))) {
                                str = jVar.aIu().getTid();
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
                    if (cVar.aIu() != null && cVar.aIu().getTid() != null) {
                        if (cVar.aIu().getTid().equals(optString)) {
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
            if (this.hNO != null && this.hNO.thread_list != null) {
                long j = com.baidu.adp.lib.f.b.toLong(optString, 0L);
                int i2 = 0;
                while (true) {
                    if (i2 < this.hNO.thread_list.size()) {
                        ThreadInfo threadInfo = this.hNO.thread_list.get(i2);
                        if (threadInfo == null || threadInfo.tid == null || threadInfo.tid.longValue() != j) {
                            i2++;
                        } else {
                            this.hNO.thread_list.remove(i2);
                            bIL();
                            com.baidu.tieba.homepage.personalize.b.d.a(threadInfo.tid.longValue(), i2, this.hNO.thread_list, this.mDataList);
                            break;
                        }
                    } else {
                        break;
                    }
                }
                if (this.hcY != null) {
                    List<Integer> b = b(optString, this.hcY);
                    int intValue = b.get(0).intValue();
                    int intValue2 = b.get(1).intValue();
                    if (intValue != -1 && intValue2 != -1) {
                        this.hcY.l(intValue, intValue2);
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
                    if (cVar.aIu() != null && cVar.aIu().getTid().equals(str)) {
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
                    advertAppInfo = ((com.baidu.tieba.homepage.personalize.data.a) next).bFn();
                } else {
                    if (next instanceof ae) {
                        ae aeVar = (ae) next;
                        if (aeVar.aJa() instanceof AdvertAppInfo.ILegoAdvert) {
                            advertAppInfo = ((AdvertAppInfo.ILegoAdvert) aeVar.aJa()).getAdvertAppInfo();
                        }
                    }
                    advertAppInfo = advertAppInfo2;
                }
                if (advertAppInfo != null && str.equals(advertAppInfo.dms)) {
                    it.remove();
                    advertAppInfo = null;
                }
                advertAppInfo2 = advertAppInfo;
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (this.gHx != null) {
            this.gHx.onChangeSkinType(i);
        }
    }

    public FloatInfo bZH() {
        return this.hNY;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public af bZf() {
        if (this.gHB == null || this.gHB.cJF() == null || !(this.gHB.cJF().getTag() instanceof af)) {
            return null;
        }
        return (af) this.gHB.cJF().getTag();
    }
}
