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
import com.baidu.adp.widget.ListView.o;
import com.baidu.ala.atomdata.AlaSDKShareEmptyActivityConfig;
import com.baidu.card.a.a;
import com.baidu.card.ag;
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
import com.baidu.tbadk.core.data.ax;
import com.baidu.tbadk.core.data.az;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tbadk.n.n;
import com.baidu.tbadk.util.aa;
import com.baidu.tbadk.util.ac;
import com.baidu.tbadk.util.ad;
import com.baidu.tbadk.util.z;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.LiveRoomClosedQueryMessage;
import com.baidu.tieba.card.data.k;
import com.baidu.tieba.card.s;
import com.baidu.tieba.f.a;
import com.baidu.tieba.frs.SmartBubbleAnimatedView;
import com.baidu.tieba.frs.aw;
import com.baidu.tieba.homepage.BlessHttpResponseMessage;
import com.baidu.tieba.homepage.BlessSocketResponseMessage;
import com.baidu.tieba.homepage.GetMyPostHttpResponseMessage;
import com.baidu.tieba.homepage.GetMyPostSocketResponseMessage;
import com.baidu.tieba.homepage.HomePageStatic;
import com.baidu.tieba.homepage.RequestGetMyPostNetMessage;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import com.baidu.tieba.homepage.personalize.a.ab;
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
import tbclient.GetMyPost.GetMyPostResIdl;
import tbclient.GodInfo;
import tbclient.Personalized.DataRes;
import tbclient.Personalized.FloatInfo;
import tbclient.ThreadInfo;
import tbclient.User;
import tbclient.Zan;
/* loaded from: classes9.dex */
public class e {
    private View.OnTouchListener eiB;
    private z evv;
    private aw gWh;
    private SmartBubbleAnimatedView gWi;
    private m gWm;
    private com.baidu.tieba.f.a hMd;
    private boolean hVf;
    private final BigdaySwipeRefreshLayout hWW;
    private com.baidu.tieba.tbadkCore.data.f hne;
    private final BdTypeRecyclerView hrM;
    private final ab ibI;
    private ScrollFragmentTabHost ibw;
    private g icB;
    private BdUniqueId icE;
    private int icF;
    private Runnable icN;
    private final long icq;
    private final b icr;
    private DataRes.Builder ict;
    private final com.baidu.tieba.homepage.personalize.model.a icw;
    private int icz;
    private final TbPageContext<?> mPageContext;
    private a ics = null;
    private final List<o> mDataList = new LinkedList();
    private int mPn = 1;
    private boolean mIsLoading = false;
    private boolean hXe = false;
    private int icu = 2;
    private int icv = 0;
    private TextView mTipView = null;
    private int hrx = 2000;
    private com.baidu.tbadk.n.c icx = null;
    private boolean hpz = false;
    private int hoQ = 0;
    private int faG = 0;
    private boolean mIsBackground = false;
    private boolean ibr = true;
    private boolean icy = false;
    private boolean icA = false;
    private boolean icC = true;
    private FloatInfo icD = null;
    private BdUniqueId icG = BdUniqueId.gen();
    private a.C0097a hnw = new a.C0097a(2);
    private ThreadInfo icH = null;
    private RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.e.12
        private int icW = -1;
        private int hXm = 0;
        private boolean icX = false;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (e.this.icx == null) {
                e.this.icx = new com.baidu.tbadk.n.c();
                e.this.icx.setSubType(1005);
                e.this.icx.pageType = 1;
            }
            if (e.this.evv != null && !e.this.mIsBackground) {
                e.this.evv.j(recyclerView, i);
            }
            if (i == 0) {
                c.d(e.this.hrM);
                e.this.icx.bfz();
                s.bLq().jv(true);
                com.baidu.tieba.a.d.blZ().de("page_recommend", "show_");
                com.baidu.tieba.s.c.dct().b(e.this.icE, false);
                this.icX = false;
                if (e.this.gWm != null && e.this.ibr && !e.this.mIsBackground) {
                    e.this.gWm.a(e.this.hoQ, e.this.faG, e.this.hpz, 1);
                    return;
                }
                return;
            }
            e.this.icx.bfy();
            if (i == 1) {
                if (e.this.gWh != null) {
                    e.this.gWh.hideTip();
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
            if (this.hXm > i) {
                this.icX = true;
            }
            if (e.this.evv != null && !e.this.mIsBackground) {
                e.this.evv.onScroll(this.hXm, i);
            }
            this.hXm = i;
            int i3 = (i + i2) - 1;
            if (!this.icX && this.icW != i3) {
                this.icW = i3;
                e.this.wC(this.icW);
            }
            if (this.icX && this.icW != i) {
                this.icW = i;
                e.this.wC(this.icW);
            }
            e.this.icM = i;
            e.this.hoQ = i;
            e.this.faG = (i + i2) - 1;
            ag cfA = e.this.cfA();
            if (cfA != null && cfA.rM() != null) {
                cfA.rM().b(e.this.hnw);
            }
        }
    };
    private View.OnTouchListener evw = new View.OnTouchListener() { // from class: com.baidu.tieba.homepage.personalize.e.23
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (e.this.eiB != null) {
                e.this.eiB.onTouch(view, motionEvent);
            }
            if (e.this.hMd != null) {
                e.this.hMd.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private a.InterfaceC0607a gLT = new a.InterfaceC0607a() { // from class: com.baidu.tieba.homepage.personalize.e.25
        @Override // com.baidu.tieba.f.a.InterfaceC0607a
        public void B(int i, int i2) {
            e.this.hpz = false;
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0607a
        public void C(int i, int i2) {
            e.this.hpz = true;
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0607a
        public void bK(int i, int i2) {
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0607a
        public void D(int i, int i2) {
        }
    };
    private View.OnClickListener icI = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.e.26
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (e.this.gWh != null) {
                e.this.gWh.hideTip();
            }
        }
    };
    private final CustomMessageListener icJ = new CustomMessageListener(CmdConfigCustom.CMD_RELOAD_HP_PERSONALIZED) { // from class: com.baidu.tieba.homepage.personalize.e.27
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (e.this.hrM != null) {
                e.this.gWm.cfz();
                e.this.ibr = false;
                e.this.hWW.setRefreshing(true);
            }
        }
    };
    private CustomMessageListener hEK = new CustomMessageListener(CmdConfigCustom.PB_ACTION_PRAISE) { // from class: com.baidu.tieba.homepage.personalize.e.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            bk bkVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bk) && e.this.ict != null && v.getCount(e.this.ict.thread_list) != 0 && (bkVar = (bk) customResponsedMessage.getData()) != null && bkVar.aQi() != null && bkVar.getId() != null && v.getCount(e.this.ict.thread_list) != 0) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < e.this.ict.thread_list.size()) {
                        ThreadInfo threadInfo = e.this.ict.thread_list.get(i2);
                        if (threadInfo == null || threadInfo.id.longValue() != com.baidu.adp.lib.f.b.toLong(bkVar.getId(), -1L)) {
                            i = i2 + 1;
                        } else {
                            ThreadInfo.Builder builder = new ThreadInfo.Builder(threadInfo);
                            Zan.Builder builder2 = new Zan.Builder(builder.zan);
                            builder2.num = Integer.valueOf((int) bkVar.aQi().getNum());
                            builder.zan = builder2.build(true);
                            e.this.ict.thread_list.set(i2, builder.build(true));
                            return;
                        }
                    } else {
                        return;
                    }
                }
            }
        }
    };
    private CustomMessageListener icK = new CustomMessageListener(CmdConfigCustom.CMD_LIVE_VIDEO_CLOSED_QUERY_RESPONSED) { // from class: com.baidu.tieba.homepage.personalize.e.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            bk bkVar;
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
                        if ((originData.get(i2) instanceof bk) && (bkVar = (bk) originData.get(i2)) != null && bkVar.aQS() != null && ids.contains(Long.valueOf(bkVar.aQS().live_id))) {
                            e.this.mDataList.remove(bkVar);
                        }
                        i = i2 + 1;
                    }
                    if (e.this.ibI != null) {
                        e.this.ibI.bE(new ArrayList(e.this.mDataList));
                    }
                }
            }
        }
    };
    private CustomMessageListener dNP = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.homepage.personalize.e.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int intValue;
            if ((customResponsedMessage instanceof UpdateAttentionMessage) && e.this.ict != null && !v.isEmpty(e.this.ict.thread_list)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid)) {
                    int i = 0;
                    while (true) {
                        if (i >= e.this.ict.thread_list.size()) {
                            break;
                        }
                        ThreadInfo threadInfo = e.this.ict.thread_list.get(i);
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
                            e.this.ict.thread_list.set(i, builder.build(true));
                        }
                    }
                    e.this.a(updateAttentionMessage);
                }
            }
        }
    };
    private String icL = "lastReadReadPositionKey";
    private int icM = 0;
    private d icO = new d() { // from class: com.baidu.tieba.homepage.personalize.e.11
        @Override // com.baidu.tieba.homepage.personalize.d
        public void wl(final int i) {
            if (e.this.icN == null) {
                e.this.icN = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.e.11.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (e.this.hrM.getHandler() != null) {
                            e.this.hrM.requestFocusFromTouch();
                            if (i <= e.this.hrM.getCount() - 1) {
                                e.this.hrM.setSelection(i);
                            }
                        }
                    }
                };
            }
            e.this.hrM.removeCallbacks(e.this.icN);
            e.this.hrM.post(e.this.icN);
        }
    };
    private CustomMessageListener icP = new CustomMessageListener(2016569) { // from class: com.baidu.tieba.homepage.personalize.e.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && e.this.icB != null) {
                e.this.mDataList.remove(e.this.icB);
                e.this.ibI.bE(new ArrayList(e.this.mDataList));
                com.baidu.tbadk.core.sharedPref.b.aTX().putLong("key_maintab_banner_close_time", System.currentTimeMillis());
            }
        }
    };
    private CustomMessageListener gWb = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.homepage.personalize.e.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.g(customResponsedMessage);
            if (e.this.gWm != null && e.this.ibr) {
                e.this.gWm.a(e.this.hoQ, e.this.faG, e.this.hpz, true);
            }
        }
    };
    private CustomMessageListener gWc = new CustomMessageListener(CmdConfigCustom.CMD_THREAD_NOT_EXIST_WHEN_ENTER_PB) { // from class: com.baidu.tieba.homepage.personalize.e.17
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.g(customResponsedMessage);
        }
    };
    private CustomMessageListener hEY = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.homepage.personalize.e.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && e.this.ict != null && v.getCount(e.this.ict.thread_list) != 0) {
                String str = (String) customResponsedMessage.getData();
                e.this.h(str, e.this.mDataList);
                e.this.FE(str);
                if (e.this.ibI != null) {
                    e.this.ibI.bE(new ArrayList(e.this.mDataList));
                }
                if (e.this.gWm != null && e.this.ibr) {
                    e.this.gWm.a(e.this.hoQ, e.this.faG, e.this.hpz, true);
                }
            }
        }
    };
    private CustomMessageListener hoH = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.homepage.personalize.e.19
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ag cfA;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent)) {
                KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24 && (cfA = e.this.cfA()) != null && cfA.rM() != null) {
                    cfA.rM().b(new a.C0097a(3));
                }
            }
        }
    };
    private com.baidu.adp.framework.listener.a icQ = new com.baidu.adp.framework.listener.a(1003065, CmdConfigSocket.CMD_TOPIC_BLESS) { // from class: com.baidu.tieba.homepage.personalize.e.20
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
                    for (o oVar : e.this.mDataList) {
                        if ((oVar instanceof com.baidu.tieba.homepage.topic.topictab.b.a) && (bVar = ((com.baidu.tieba.homepage.topic.topictab.b.a) oVar).ihK) != null && longValue == bVar.pkId) {
                            bVar.userPkId = j2;
                            return;
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener hoI = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.homepage.personalize.e.21
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int[] imageWidthAndHeight;
            List<o> dataList = e.this.ibI.getDataList();
            if (!v.isEmpty(dataList)) {
                for (o oVar : dataList) {
                    if (oVar instanceof k) {
                        k kVar = (k) oVar;
                        if (kVar.dEB != 0 && kVar.dEA != null) {
                            if ((TbSingleton.getInstance().getHomePageStyleAbTest() & 4) != 0) {
                                imageWidthAndHeight = kVar.dEA.aSt();
                            } else {
                                imageWidthAndHeight = kVar.dEA.getImageWidthAndHeight();
                            }
                            kVar.dEB = imageWidthAndHeight[0];
                            kVar.dEC = imageWidthAndHeight[1];
                        }
                    }
                }
            }
            com.baidu.adp.lib.f.e.ld().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.personalize.e.21.1
                @Override // java.lang.Runnable
                public void run() {
                    e.this.ibI.notifyDataSetChanged();
                    if (!e.this.mIsBackground && e.this.ibr) {
                        e.this.gWm.a(e.this.hoQ, e.this.faG, e.this.hpz, true);
                    }
                }
            }, 500L);
        }
    };
    private CustomMessageListener gWd = new CustomMessageListener(2921453) { // from class: com.baidu.tieba.homepage.personalize.e.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof ax)) {
                ax axVar = (ax) customResponsedMessage.getData();
                if (axVar.dDN == 1) {
                    int equipmentWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst());
                    int equipmentHeight = l.getEquipmentHeight(TbadkCoreApplication.getInst());
                    float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
                    int i = ar.aUW().aUX() ? 2 : 1;
                    RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
                    requestGetMyPostNetMessage.setTag(e.this.icG);
                    requestGetMyPostNetMessage.setParams(com.baidu.adp.lib.f.b.toLong(axVar.tid, 0L), 0L, 0L, equipmentWidth, equipmentHeight, f, i);
                    requestGetMyPostNetMessage.setBFrom("push");
                    MessageManager.getInstance().sendMessage(requestGetMyPostNetMessage);
                }
            }
        }
    };
    private final com.baidu.adp.framework.listener.a gWe = new com.baidu.adp.framework.listener.a(1003010, CmdConfigSocket.CMD_GET_MY_POST) { // from class: com.baidu.tieba.homepage.personalize.e.24
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            GetMyPostResIdl getMyPostResIdl = null;
            if (responsedMessage instanceof GetMyPostHttpResponseMessage) {
                getMyPostResIdl = ((GetMyPostHttpResponseMessage) responsedMessage).getResponseData();
            } else if (responsedMessage instanceof GetMyPostSocketResponseMessage) {
                getMyPostResIdl = ((GetMyPostSocketResponseMessage) responsedMessage).getResponseData();
            }
            if (getMyPostResIdl != null && getMyPostResIdl.data != null && getMyPostResIdl.data.thread_info != null) {
                e.this.icH = getMyPostResIdl.data.thread_info;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921455));
            }
        }
    };

    /* loaded from: classes9.dex */
    public interface a {
        void A(int i, int i2, int i3, int i4);

        void Q(int i, int i2, int i3);

        void cfQ();

        void onError(int i, String str);

        void onSuccess();
    }

    public void on(boolean z) {
        this.icC = z;
        if (this.gWh != null && !z) {
            this.gWh.hideTip();
        }
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.ibw = scrollFragmentTabHost;
        if (this.ibw != null) {
            this.ibw.setOnTabSelectedListener(new ScrollFragmentTabHost.b() { // from class: com.baidu.tieba.homepage.personalize.e.1
                @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.b
                public void wv(int i) {
                    if (e.this.ibw.wu(i) != 1 && e.this.gWh != null) {
                        e.this.gWh.hideTip();
                    }
                }
            });
        }
    }

    public void setTabInForeBackgroundState(boolean z) {
        this.mIsBackground = z;
    }

    public void mX(boolean z) {
        boolean z2 = false;
        this.mIsBackground = z;
        if (this.ibw != null) {
            this.ibw.mX(z);
        }
        if (this.gWm != null) {
            this.gWm.qi(!z);
            ag cfA = cfA();
            if (cfA != null && cfA.rM() != null) {
                z2 = cfA.rM().b(new a.C0097a(8, Boolean.valueOf(z)));
            }
            if (!z2) {
                if (z) {
                    this.gWm.cfz();
                } else if (this.ibr) {
                    this.gWm.a(this.hoQ, this.faG, this.hpz, true);
                }
            }
        }
    }

    public e(TbPageContext<?> tbPageContext, BdTypeRecyclerView bdTypeRecyclerView, ab abVar, BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout) {
        this.icF = 0;
        this.mPageContext = tbPageContext;
        this.icF = com.baidu.tbadk.core.sharedPref.b.aTX().getInt("key_personalized_refresh_type", 0);
        this.hWW = bigdaySwipeRefreshLayout;
        this.hrM = bdTypeRecyclerView;
        this.hrM.setOnTouchListener(this.evw);
        this.hMd = new com.baidu.tieba.f.a();
        this.hMd.a(this.gLT);
        this.ibI = abVar;
        this.icw = new com.baidu.tieba.homepage.personalize.model.a();
        this.icq = com.baidu.tbadk.core.sharedPref.b.aTX().getLong("recommend_frs_cache_time", 1800L) * 1000;
        bdTypeRecyclerView.setOnScrollListener(this.mOnScrollListener);
        this.gWh = new aw();
        cga();
        this.gWm = new m(this.mPageContext, this.hrM);
        this.gWm.BJ(1);
        this.gWm.BI(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.icr = new b(this.mDataList, this.ibI);
        this.gWi = new SmartBubbleAnimatedView(tbPageContext.getContext());
        this.gWi.setLayoutParams(new FrameLayout.LayoutParams(-1, l.getDimens(tbPageContext.getContext(), R.dimen.tbds83)));
        cfR();
        this.hoI.setTag(this.mPageContext.getUniqueId());
        MessageManager.getInstance().registerListener(this.hoI);
        if (MessageManager.getInstance().findTask(1003010) == null) {
            HomePageStatic.cek();
        }
        this.gWe.setTag(this.icG);
        if (this.gWe.getHttpMessageListener() != null) {
            this.gWe.getHttpMessageListener().setSelfListener(true);
        }
        if (this.gWe.getSocketMessageListener() != null) {
            this.gWe.getSocketMessageListener().setSelfListener(true);
        }
        MessageManager.getInstance().registerListener(this.gWe);
        MessageManager.getInstance().registerListener(this.gWd);
    }

    private void cfR() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2016323, new CustomMessageTask.CustomRunnable<Boolean>() { // from class: com.baidu.tieba.homepage.personalize.e.28
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Boolean> customMessage) {
                ag cfA = e.this.cfA();
                return (cfA == null || cfA.rM() == null) ? new CustomResponsedMessage<>(2016323, false) : new CustomResponsedMessage<>(2016323, Boolean.valueOf(cfA.rM().b(new a.C0097a(6))));
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private boolean cfS() {
        return com.baidu.tbadk.core.sharedPref.b.aTX().getBoolean(cfU(), true);
    }

    private void cfT() {
        com.baidu.tbadk.core.sharedPref.b.aTX().putBoolean(cfU(), false);
    }

    private String cfU() {
        return "key_rec_pfirst_load_" + TbadkCoreApplication.getCurrentAccount() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + TbConfig.getVersion();
    }

    public void setRecommendFrsNavigationAnimDispatcher(aa aaVar) {
        if (aaVar != null) {
            this.evv = aaVar.bgL();
            this.eiB = aaVar.bgM();
        }
    }

    public void showFloatingView() {
        if (this.evv != null) {
            this.evv.iz(true);
        }
    }

    public void update() {
        com.baidu.tieba.homepage.framework.a.ceC().q(System.currentTimeMillis(), 1);
        this.mPn = 1;
        this.icA = true;
        if (this.mDataList.size() == 0 && !cfS()) {
            if (!this.hXe) {
                aOa();
                return;
            }
            return;
        }
        aNZ();
    }

    public void cg(int i, int i2) {
        bk bkVar;
        if (!v.isEmpty(this.mDataList) && this.mDataList.size() > i) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            while (i < this.mDataList.size() && i <= i2) {
                if (this.mDataList.get(i).getType().getId() == bk.dEW.getId() && (bkVar = (bk) this.mDataList.get(i)) != null && bkVar.aQS() != null) {
                    arrayList.add(Long.valueOf(bkVar.aQS().live_id));
                    arrayList2.add(bkVar);
                }
                i++;
            }
            if (!v.isEmpty(arrayList)) {
                MessageManager.getInstance().sendMessage(new LiveRoomClosedQueryMessage(arrayList, arrayList2));
            }
        }
    }

    public void cfV() {
        if (this.gWm != null && !this.mIsBackground && this.ibr) {
            this.gWm.a(this.hoQ, this.faG, this.hpz, true);
        }
        if (this.icy) {
            if (this.hWW != null && !this.hWW.aWv()) {
                if (this.hVf) {
                    com.baidu.tieba.s.c.dct().b(this.icE, false);
                    if (op(false)) {
                        ch(3, this.icv);
                    } else if (this.icz > 0) {
                        ch(2, this.icv);
                    }
                } else if (!this.hVf && this.icv == 0) {
                    ch(2, 0);
                }
            }
            this.icy = false;
            this.hVf = false;
            this.icz = 0;
            if (this.icA) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
            }
            this.icA = false;
        }
    }

    public void bqv() {
        if (isLoading()) {
            com.baidu.tieba.homepage.framework.a.ceC().q(0L, 1);
        } else if (this.ics != null) {
            cfX();
            this.mPn++;
            setIsLoading(true);
            this.ics.A(this.mPn, (this.ict == null || this.ict.thread_list == null) ? 0 : this.ict.thread_list.size(), oo(false), 0);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:91:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(boolean z, boolean z2, DataRes dataRes, int i, String str) {
        boolean z3;
        int size;
        if (this.icw != null && this.icw.cgy() && !z && (dataRes == null || v.isEmpty(dataRes.thread_list))) {
            if (dataRes == null) {
                DataRes.Builder builder = new DataRes.Builder();
                builder.thread_list = new ArrayList();
                dataRes = builder.build(false);
            }
            if (dataRes.thread_list != null) {
                List<ThreadInfo> cgz = this.icw.cgz();
                dataRes.thread_list.addAll(cgz);
                if (cgz != null) {
                    cgz.clear();
                }
                z3 = true;
                size = (this.ict != null || this.ict.thread_list == null) ? 0 : this.ict.thread_list.size();
                if (z && i == 0 && dataRes != null && v.isEmpty(dataRes.thread_list)) {
                    if (this.ics != null) {
                        this.ics.cfQ();
                    }
                    setIsLoading(false);
                    if (this.hWW != null) {
                        this.hWW.setRefreshing(false);
                        return;
                    }
                    return;
                }
                if (this.icH != null) {
                    DataRes.Builder builder2 = new DataRes.Builder(dataRes);
                    builder2.thread_list.add(0, this.icH);
                    dataRes = builder2.build(false);
                    if (this.ict != null && !v.isEmpty(this.ict.thread_list)) {
                        Iterator<ThreadInfo> it = this.ict.thread_list.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            ThreadInfo next = it.next();
                            if (next != null && next.tid != null && this.icH.tid != null && next.tid.longValue() == this.icH.tid.longValue()) {
                                this.ict.thread_list.remove(next);
                                break;
                            }
                        }
                    }
                    this.icH = null;
                }
                if ((z3 && i != 0) || dataRes == null || !a(true, z, z2, dataRes)) {
                    this.icy = false;
                    if (this.mDataList.size() > 0) {
                        if (this.ics != null) {
                            this.ics.onError(1, str);
                        }
                    } else if (this.ics != null) {
                        this.ics.onError(2, str);
                    }
                } else {
                    cfT();
                    if (this.ics != null) {
                        com.baidu.tbadk.core.sharedPref.b.aTX().putLong(SharedPrefConfig.RECOMMEND_FRS_REFRESH_TIME + TbadkCoreApplication.getCurrentAccount(), System.currentTimeMillis());
                        this.ics.onSuccess();
                    }
                    this.icy = true;
                    this.hVf = z;
                    this.icz = size;
                    bPe();
                }
                setIsLoading(false);
                if (this.hWW == null) {
                    f.e cfW = cfW();
                    if (this.hWW.aWv() && cfW != null) {
                        this.hWW.c(cfW);
                        return;
                    } else {
                        this.hWW.setRefreshing(false);
                        return;
                    }
                }
                return;
            }
        }
        z3 = false;
        if (this.ict != null) {
        }
        if (z) {
        }
        if (this.icH != null) {
        }
        if (z3) {
        }
        cfT();
        if (this.ics != null) {
        }
        this.icy = true;
        this.hVf = z;
        this.icz = size;
        bPe();
        setIsLoading(false);
        if (this.hWW == null) {
        }
    }

    private f.e cfW() {
        int i;
        String feedText;
        if (this.icy && this.hWW != null && this.hWW.aWv()) {
            int i2 = this.icv;
            if (this.hVf) {
                com.baidu.tieba.s.c.dct().b(this.icE, false);
                if (op(false)) {
                    i = 3;
                } else {
                    i = this.icz > 0 ? 2 : 0;
                }
            } else if (this.hVf || this.icv != 0) {
                return null;
            } else {
                i2 = 0;
                i = 2;
            }
            if (this.ibw != null) {
                this.gWh.bXb();
            }
            if (this.ibw != null && this.ibw.getCurrentTabType() != 1) {
                this.gWh.hideTip();
                return null;
            } else if (!this.icC) {
                this.gWh.hideTip();
                return null;
            } else {
                this.icu = i;
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
                    this.hrx = 1000;
                } else {
                    this.hrx = 0;
                }
                return new f.e(feedText, this.hrx);
            }
        }
        return null;
    }

    public void oc(boolean z) {
        if (z) {
            this.ibI.notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        if (this.gWm != null) {
            this.gWm.destroy();
        }
        if (this.gWh != null) {
            this.gWh.onDestroy();
        }
        if (this.icr != null) {
            this.icr.onDestroy();
        }
        if (this.hrM != null) {
            this.hrM.removeCallbacks(this.icN);
        }
        MessageManager.getInstance().unRegisterTask(2016323);
        MessageManager.getInstance().unRegisterListener(this.hoI);
        MessageManager.getInstance().unRegisterListener(this.gWd);
        MessageManager.getInstance().unRegisterListener(this.gWe);
    }

    public void onPause() {
        c.d(this.hrM);
        wD(this.icM);
        if (this.icx != null) {
            this.icx.bfA();
        }
    }

    private void aNZ() {
        if (this.ics != null) {
            this.ics.Q((this.ict == null || this.ict.thread_list == null || cfZ()) ? 0 : this.ict.thread_list.size(), oo(true), 0);
        }
    }

    public int oo(boolean z) {
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
                o oVar = this.mDataList.get(i5);
                if (!(oVar instanceof com.baidu.tieba.card.data.c) || (i3 = ((com.baidu.tieba.card.data.c) oVar).position) == i6) {
                    i3 = i6;
                    i4 = i7;
                } else {
                    i4 = i7 + 1;
                }
                if (!(oVar instanceof com.baidu.tieba.homepage.personalize.data.a) || oVar.getType() == AdvertAppInfo.dAj) {
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
                o oVar2 = this.mDataList.get(size);
                if (!(oVar2 instanceof com.baidu.tieba.card.data.c) || (i = ((com.baidu.tieba.card.data.c) oVar2).position) == i9) {
                    i = i9;
                    i2 = i8;
                } else {
                    i2 = i8 + 1;
                }
                if ((oVar2 instanceof com.baidu.tieba.homepage.personalize.data.a) && oVar2.getType() != AdvertAppInfo.dAj) {
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
        this.hXe = true;
        if (dataRes != null) {
            if (a(false, true, true, dataRes) && !cfZ()) {
                if (this.ics != null) {
                    this.ics.onSuccess();
                    Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler() { // from class: com.baidu.tieba.homepage.personalize.e.29
                        @Override // android.os.MessageQueue.IdleHandler
                        public boolean queueIdle() {
                            e.this.bfF();
                            return false;
                        }
                    });
                }
                if (TbSingleton.getInstance().getForceRefreshHomeRecommend()) {
                    aNZ();
                    TbSingleton.getInstance().setForceRefreshHomeRecommend(false);
                    return;
                }
                return;
            }
            aNZ();
            return;
        }
        aNZ();
    }

    public void bfF() {
        long wj = com.baidu.tieba.homepage.framework.a.ceC().wj(1) + com.baidu.tieba.homepage.framework.a.ceC().getCreateTime();
        long wh = com.baidu.tieba.homepage.framework.a.ceC().wh(1);
        if (wh > 0) {
            wj = System.currentTimeMillis() - wh;
        }
        n.bfN().cS(wj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.util.Set] */
    private void j(List<o> list, int i) {
        AdvertAppInfo bLH;
        AdvertAppInfo bLH2;
        if (!v.isEmpty(list)) {
            Set<o> Lt = com.baidu.tieba.recapp.report.a.Lt("NEWINDEX");
            HashSet hashSet = Lt == null ? new HashSet() : Lt;
            HashSet hashSet2 = new HashSet();
            for (o oVar : list) {
                if (oVar != null) {
                    for (o oVar2 : hashSet) {
                        if ((oVar instanceof com.baidu.tieba.card.data.d) && (bLH2 = ((com.baidu.tieba.card.data.d) oVar).bLH()) != null && oVar2 != null && (oVar2 instanceof AdvertAppInfo) && oVar2.hashCode() == bLH2.hashCode()) {
                            bLH2.advertAppContext = ((AdvertAppInfo) oVar2).advertAppContext;
                        }
                    }
                    if (oVar != null && (oVar instanceof com.baidu.tieba.card.data.d) && (bLH = ((com.baidu.tieba.card.data.d) oVar).bLH()) != null && bLH.advertAppContext == null) {
                        bLH.advertAppContext = new com.baidu.tbadk.core.data.b();
                        bLH.advertAppContext.page = "NEWINDEX";
                        bLH.advertAppContext.pn = this.mPn;
                        bLH.advertAppContext.extensionInfo = bLH.extensionInfo;
                        bLH.advertAppContext.WZ = false;
                        hashSet2.add(bLH);
                    }
                }
            }
            hashSet.addAll(hashSet2);
            com.baidu.tieba.recapp.report.a.b("NEWINDEX", hashSet);
            if (hashSet2.size() > 0) {
                com.baidu.tieba.s.c.dct().b(this.icE, com.baidu.tieba.s.a.b(PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE, "common_fill", true, hashSet2.size()));
            }
        }
    }

    private boolean a(boolean z, boolean z2, boolean z3, DataRes dataRes) {
        List<o> list;
        int i;
        boolean z4;
        if (dataRes == null) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.icF == 1) {
            if (z2 && (dataRes.thread_list.size() >= 6 || cfZ())) {
                cfY();
                this.ict = null;
            }
        } else if (z2 && cfZ()) {
            this.ict = null;
        }
        int size = z2 ? 0 : this.mDataList.size();
        DataRes.Builder builder = new DataRes.Builder(dataRes);
        this.mDataList.clear();
        com.baidu.tieba.homepage.personalize.model.c a2 = this.icw.a(z, this.ict, builder, z2 ? 0 : 1);
        if (a2 == null) {
            list = null;
            i = 0;
        } else {
            List<o> list2 = a2.eIk;
            this.icv = a2.ifm;
            int i2 = a2.ifn;
            a2.ifn = 0;
            list = list2;
            i = i2;
        }
        if (list != null) {
            this.mDataList.addAll(list);
            j(list, size);
            a(z2 ? 0 : 1, list, size);
            if (this.icA) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
            }
        }
        if (this.ict == null) {
            this.ict = builder;
            this.icr.cK(this.ict.thread_list);
        }
        if (this.mDataList.size() == 0) {
            z4 = false;
        } else {
            if (z2) {
                if (dataRes.live_answer != null) {
                    this.icB = new g();
                    this.icB.a(dataRes.live_answer);
                    this.ict.live_answer = dataRes.live_answer;
                } else if (z) {
                    this.icB = null;
                    this.ict.live_answer = null;
                }
                this.icD = dataRes.float_info;
                this.ict.float_info = dataRes.float_info;
            }
            long j = com.baidu.tbadk.core.sharedPref.b.aTX().getLong("key_maintab_banner_close_time", 0L);
            if (this.icB != null && !aq.isTaday(j)) {
                this.mDataList.add(0, this.icB);
            }
            LinkedList linkedList = new LinkedList(this.mDataList);
            this.ibI.setFromCDN(dataRes.is_new_url != null && dataRes.is_new_url.intValue() == 1);
            this.ibI.k(linkedList, i);
            z4 = true;
            if (this.gWm != null && this.ibr) {
                this.gWm.a(this.hoQ, this.faG, this.hpz, true);
            }
        }
        com.baidu.tieba.homepage.framework.a.ceC().o(System.currentTimeMillis() - currentTimeMillis, 1);
        long wk = com.baidu.tieba.homepage.framework.a.ceC().wk(1);
        if (wk > 0) {
            com.baidu.tieba.homepage.framework.a.ceC().p(System.currentTimeMillis() - wk, 1);
            com.baidu.tieba.homepage.framework.a.ceC().q(0L, 1);
        }
        if (dataRes.anti != null && dataRes.anti.block_pop_info != null) {
            com.baidu.tieba.ueg.d.d(dataRes.anti.block_pop_info);
        }
        az azVar = new az();
        azVar.a(dataRes.recom_post_topic);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_REFRESH_TOPIC_TIP, azVar));
        return z4;
    }

    private void cfX() {
        List<o> list;
        int i;
        if (v.getCount(this.mDataList) >= this.icw.cgv() - 40) {
            com.baidu.tieba.homepage.personalize.model.c a2 = this.icw.a(true, this.ict, null, 1);
            if (a2 != null) {
                List<o> list2 = a2.eIk;
                i = a2.ifn;
                a2.ifn = 0;
                list = list2;
            } else {
                list = null;
                i = 0;
            }
            if (list != null) {
                this.mDataList.clear();
                this.mDataList.addAll(list);
                this.ibI.k(new LinkedList(this.mDataList), i);
            }
        }
    }

    private void aOa() {
        this.hXe = true;
        ad.a(new ac<DataRes>() { // from class: com.baidu.tieba.homepage.personalize.e.30
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.ac
            /* renamed from: cge */
            public DataRes doInBackground() {
                com.baidu.adp.lib.cache.l<byte[]> cZ = com.baidu.tbadk.core.c.a.aSS().cZ("tb.rec_frs_update", TbadkCoreApplication.getCurrentAccount());
                if (cZ == null) {
                    return null;
                }
                byte[] bArr = cZ.get("0");
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

    private void bPe() {
        if (this.ict != null) {
            DataRes.Builder builder = new DataRes.Builder(this.ict.build(true));
            if (builder.thread_list != null && builder.thread_list.size() > 30) {
                builder.thread_list = builder.thread_list.subList(0, 30);
            }
            a(builder, builder.thread_list != null ? builder.thread_list.size() : 0);
            a(builder);
            b(builder);
        }
    }

    private void cfY() {
        if (this.ict != null) {
            final DataRes.Builder builder = new DataRes.Builder(this.ict.build(true));
            if (builder.thread_list != null && builder.thread_list.size() > 50) {
                builder.thread_list = builder.thread_list.subList(0, 50);
            }
            a(builder, builder.thread_list != null ? builder.thread_list.size() : 0);
            ad.a(new ac<Object>() { // from class: com.baidu.tieba.homepage.personalize.e.3
                @Override // com.baidu.tbadk.util.ac
                public Object doInBackground() {
                    DataRes.Builder builder2 = new DataRes.Builder(builder.build(true));
                    e.this.icr.cL(builder2.thread_list);
                    try {
                        com.baidu.tbadk.core.c.a.aSS().cZ("tb.rec_old_data", TbadkCoreApplication.getCurrentAccount()).setForever("0", builder2.build(true).toByteArray());
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
    public void FE(String str) {
        if (!TextUtils.isEmpty(str) && this.ict != null && this.ict.banner_list != null && this.ict.banner_list.app != null && this.ict.banner_list.app.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (App app : this.ict.banner_list.app) {
                if (app != null && str.equals(app.id)) {
                    arrayList.add(app);
                }
            }
            BannerList.Builder builder = new BannerList.Builder(this.ict.banner_list);
            if (builder.app != null) {
                builder.app.removeAll(arrayList);
            }
            this.ict.banner_list = builder.build(false);
            DataRes.Builder builder2 = new DataRes.Builder(this.ict.build(true));
            builder2.banner_list = builder.build(true);
            b(builder2);
        }
    }

    private void b(final DataRes.Builder builder) {
        ad.a(new ac<Object>() { // from class: com.baidu.tieba.homepage.personalize.e.4
            @Override // com.baidu.tbadk.util.ac
            public Object doInBackground() {
                DataRes.Builder builder2 = new DataRes.Builder(builder.build(true));
                e.this.icr.cL(builder2.thread_list);
                try {
                    com.baidu.tbadk.core.c.a.aSS().cZ("tb.rec_frs_update", TbadkCoreApplication.getCurrentAccount()).setForever("0", builder2.build(true).toByteArray());
                    return null;
                } catch (Exception e) {
                    BdLog.e(e);
                    return null;
                }
            }
        }, null);
    }

    private boolean cfZ() {
        return op(true);
    }

    private boolean op(boolean z) {
        long j = com.baidu.tbadk.core.sharedPref.b.aTX().getLong(SharedPrefConfig.RECOMMEND_FRS_REFRESH_TIME + TbadkCoreApplication.getCurrentAccount(), 0L);
        return j == 0 ? z : Math.abs(System.currentTimeMillis() - j) > this.icq;
    }

    public void a(a aVar) {
        this.ics = aVar;
    }

    private boolean isLoading() {
        return this.mIsLoading;
    }

    private void setIsLoading(boolean z) {
        this.mIsLoading = z;
    }

    public void cfN() {
        boolean z = true;
        com.baidu.tbadk.coreExtra.data.b activityPrizeData = TbadkCoreApplication.getInst().getActivityPrizeData();
        if (activityPrizeData.isSwitchTurn() && !StringUtils.isNull(activityPrizeData.getFeedText())) {
            String currentDay = UtilHelper.getCurrentDay();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            String str = "";
            if (!StringUtils.isNull(currentAccount)) {
                String string = com.baidu.tbadk.core.sharedPref.b.aTX().getString(SharedPrefConfig.ACTIVITY_PRIZE_FEED_TEXT_TIME, "");
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
                    ch(4, 0);
                    com.baidu.tbadk.core.sharedPref.b.aTX().putString(SharedPrefConfig.ACTIVITY_PRIZE_FEED_TEXT_TIME, str);
                }
            }
        }
    }

    private void ch(int i, int i2) {
        if (this.ibw != null) {
            this.gWh.bXb();
        }
        if (this.ibw != null && this.ibw.getCurrentTabType() != 1) {
            this.gWh.hideTip();
        } else if (!this.icC) {
            this.gWh.hideTip();
        } else {
            this.icu = i;
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
                    this.hrx = 3000;
                } else {
                    this.hrx = 2000;
                }
                this.gWi.dVI = str;
                this.gWi.hrq = this.hrx;
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 49;
                if (this.ibw != null) {
                    FrameLayout frameLayout = this.ibw.getFrameLayout();
                    frameLayout.removeView(this.gWi);
                    frameLayout.addView(this.gWi, layoutParams);
                    this.gWi.bWZ();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(Long l) {
        if (this.ict != null && this.ict.thread_list != null) {
            List<ThreadInfo> list = this.ict.thread_list;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                ThreadInfo threadInfo = list.get(i);
                if (threadInfo.tid.equals(l) && threadInfo.top_agree_post != null) {
                    ThreadInfo.Builder builder = new ThreadInfo.Builder(threadInfo);
                    builder.top_agree_post = null;
                    list.set(i, builder.build(true));
                    bPe();
                    a(false, true, false, this.ict.build(true));
                    return;
                }
            }
        }
    }

    public void o(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.icE = bdUniqueId;
            if (this.hEK != null) {
                this.hEK.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.hEK);
            }
            if (this.icJ != null) {
                this.icJ.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.icJ);
            }
            this.dNP.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.dNP);
            this.icK.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.icK);
            this.gWb.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.gWb);
            this.gWc.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.gWc);
            this.hEY.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.hEY);
            if (this.gWm != null) {
                this.gWm.setUniqueId(bdUniqueId);
            }
            this.icr.l(bdUniqueId);
            this.icP.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.icP);
            this.hoH.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.hoH);
            this.icQ.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.icQ);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(UpdateAttentionMessage updateAttentionMessage) {
        if (updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid)) {
            final String str = updateAttentionMessage.getData().toUid;
            final boolean z = updateAttentionMessage.getData().isAttention;
            ad.a(new ac<Boolean>() { // from class: com.baidu.tieba.homepage.personalize.e.8
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.baidu.tbadk.util.ac
                public Boolean doInBackground() {
                    int intValue;
                    try {
                        com.baidu.adp.lib.cache.l<byte[]> cZ = com.baidu.tbadk.core.c.a.aSS().cZ("tb.rec_frs_update", TbadkCoreApplication.getCurrentAccount());
                        if (cZ == null) {
                            return false;
                        }
                        byte[] bArr = cZ.get("0");
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
                        e.this.icr.cL(builder5.thread_list);
                        cZ.setForever("0", builder5.build(true).toByteArray());
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

    public void cga() {
        this.hne = new com.baidu.tieba.tbadkCore.data.f("new_index", null);
        this.hne.dda();
    }

    public void a(int i, List<o> list, int i2) {
        int i3;
        int i4;
        if (this.hne != null) {
            if (i == 0) {
                this.hne.dda();
            }
            if (list != null && !list.isEmpty()) {
                int[] iArr = com.baidu.tieba.tbadkCore.data.f.lkj;
                int i5 = 0;
                int i6 = 0;
                int i7 = 0;
                while (i7 < list.size() && i6 < iArr.length && (i3 = iArr[i6]) >= 0) {
                    if (list.get(i7) instanceof com.baidu.tieba.card.data.c) {
                        i4 = i5 + 1;
                        if (i4 == i3 - 1) {
                            if (i2 < i7 + 1) {
                                this.hne.cU(i3, i7 + 1);
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

    public void wC(int i) {
        if ((this.hne != null ? this.hne.DP(i) : -1) >= 0 && this.hrM != null && this.hrM.getData() != null && this.hrM.getData().size() > i) {
            this.hne.DQ(i);
        }
    }

    public m bVQ() {
        return this.gWm;
    }

    public void oj(boolean z) {
        this.ibr = z;
    }

    public void wD(final int i) {
        ad.a(new ac<Object>() { // from class: com.baidu.tieba.homepage.personalize.e.10
            @Override // com.baidu.tbadk.util.ac
            public Object doInBackground() {
                com.baidu.adp.lib.cache.l<String> da = com.baidu.tbadk.core.c.a.aSS().da(e.this.icL, TbadkCoreApplication.getCurrentAccount());
                if (da != null) {
                    da.set(e.this.icL, Integer.toString(i), 43200000L);
                    return null;
                }
                return null;
            }
        }, null);
    }

    public void a(final d dVar) {
        ad.a(new ac<String>() { // from class: com.baidu.tieba.homepage.personalize.e.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.ac
            /* renamed from: cgd */
            public String doInBackground() {
                com.baidu.adp.lib.cache.l<String> da = com.baidu.tbadk.core.c.a.aSS().da(e.this.icL, TbadkCoreApplication.getCurrentAccount());
                if (da != null) {
                    return da.get(e.this.icL);
                }
                return null;
            }
        }, new com.baidu.tbadk.util.l<String>() { // from class: com.baidu.tieba.homepage.personalize.e.14
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.l
            /* renamed from: FF */
            public void onReturnDataInUI(String str) {
                if (dVar != null) {
                    dVar.wl(com.baidu.adp.lib.f.b.toInt(str, 0));
                }
            }
        });
    }

    public void cfO() {
        c.e(this.hrM);
    }

    public void cgb() {
        a(this.icO);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(CustomResponsedMessage<?> customResponsedMessage) {
        boolean z;
        String str;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.ict != null && v.getCount(this.ict.thread_list) != 0 && v.getCount(this.mDataList) != 0) {
            JSONObject jSONObject = (JSONObject) customResponsedMessage.getData();
            String optString = jSONObject.optString("tid");
            if (StringUtils.isNull(optString)) {
                String optString2 = jSONObject.optString(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_ID);
                if (this.hrM != null && !TextUtils.isEmpty(optString2)) {
                    int i = 0;
                    while (true) {
                        if (i >= this.hrM.getCount()) {
                            str = optString;
                            break;
                        }
                        o item = this.hrM.getItem(i);
                        if (item instanceof com.baidu.tieba.card.data.j) {
                            com.baidu.tieba.card.data.j jVar = (com.baidu.tieba.card.data.j) item;
                            if (jVar.aOi() != null && jVar.aOi().aQS() != null && optString2.equals(String.valueOf(jVar.aOi().aQS().live_id))) {
                                str = jVar.aOi().getTid();
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
            Iterator<o> it = this.mDataList.iterator();
            boolean z2 = false;
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                o next = it.next();
                if (next instanceof com.baidu.tieba.card.data.c) {
                    com.baidu.tieba.card.data.c cVar = (com.baidu.tieba.card.data.c) next;
                    if (cVar.aOi() != null && cVar.aOi().getTid() != null) {
                        if (cVar.aOi().getTid().equals(optString)) {
                            it.remove();
                            z = true;
                            z2 = z;
                        } else if (z2) {
                            com.baidu.tieba.homepage.personalize.model.b.cN(this.mDataList);
                            break;
                        }
                    }
                }
                z = z2;
                z2 = z;
            }
            if (this.ict != null && this.ict.thread_list != null) {
                long j = com.baidu.adp.lib.f.b.toLong(optString, 0L);
                int i2 = 0;
                while (true) {
                    if (i2 < this.ict.thread_list.size()) {
                        ThreadInfo threadInfo = this.ict.thread_list.get(i2);
                        if (threadInfo == null || threadInfo.tid == null || threadInfo.tid.longValue() != j) {
                            i2++;
                        } else {
                            com.baidu.tieba.homepage.personalize.b.d.a(threadInfo.tid.longValue(), i2, this.ict.thread_list, this.mDataList);
                            this.ict.thread_list.remove(i2);
                            bPe();
                            break;
                        }
                    } else {
                        break;
                    }
                }
                if (this.hrM != null) {
                    List<Integer> b = b(optString, this.hrM);
                    int intValue = b.get(0).intValue();
                    int intValue2 = b.get(1).intValue();
                    if (intValue != -1 && intValue2 != -1) {
                        this.hrM.l(intValue, intValue2);
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
                o item = bdTypeRecyclerView.getItem(i4);
                if (item instanceof com.baidu.tieba.card.data.c) {
                    com.baidu.tieba.card.data.c cVar = (com.baidu.tieba.card.data.c) item;
                    if (cVar.aOi() != null && cVar.aOi().getTid().equals(str)) {
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
    public void h(String str, List<o> list) {
        AdvertAppInfo advertAppInfo;
        if (list != null && list.size() > 0 && !TextUtils.isEmpty(str)) {
            Iterator<o> it = list.iterator();
            AdvertAppInfo advertAppInfo2 = null;
            while (it.hasNext()) {
                o next = it.next();
                if (next instanceof com.baidu.tieba.homepage.personalize.data.a) {
                    advertAppInfo = ((com.baidu.tieba.homepage.personalize.data.a) next).bLH();
                } else {
                    if (next instanceof com.baidu.tbadk.core.data.ad) {
                        com.baidu.tbadk.core.data.ad adVar = (com.baidu.tbadk.core.data.ad) next;
                        if (adVar.aOV() instanceof AdvertAppInfo.ILegoAdvert) {
                            advertAppInfo = ((AdvertAppInfo.ILegoAdvert) adVar.aOV()).getAdvertAppInfo();
                        }
                    }
                    advertAppInfo = advertAppInfo2;
                }
                if (advertAppInfo != null && str.equals(advertAppInfo.dAu)) {
                    it.remove();
                    advertAppInfo = null;
                }
                advertAppInfo2 = advertAppInfo;
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (this.gWi != null) {
            this.gWi.onChangeSkinType(i);
        }
    }

    public FloatInfo cgc() {
        return this.icD;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ag cfA() {
        if (this.gWm == null || this.gWm.cQE() == null || !(this.gWm.cQE().getTag() instanceof ag)) {
            return null;
        }
        return (ag) this.gWm.cQE().getTag();
    }
}
