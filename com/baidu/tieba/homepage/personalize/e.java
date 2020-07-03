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
import com.baidu.adp.widget.ListView.q;
import com.baidu.ala.atomdata.AlaSDKShareEmptyActivityConfig;
import com.baidu.card.a.a;
import com.baidu.card.ak;
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
import com.baidu.tbadk.core.data.ai;
import com.baidu.tbadk.core.data.be;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.w;
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
import com.baidu.tieba.frs.bc;
import com.baidu.tieba.homepage.BlessHttpResponseMessage;
import com.baidu.tieba.homepage.BlessSocketResponseMessage;
import com.baidu.tieba.homepage.GetMyPostHttpResponseMessage;
import com.baidu.tieba.homepage.GetMyPostSocketResponseMessage;
import com.baidu.tieba.homepage.HomePageStatic;
import com.baidu.tieba.homepage.RequestGetMyPostNetMessage;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import com.baidu.tieba.homepage.personalize.a.af;
import com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout;
import com.baidu.tieba.homepage.personalize.data.g;
import com.baidu.tieba.homepage.personalize.data.h;
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
    private z eEB;
    private View.OnTouchListener erl;
    private final BdTypeRecyclerView hEN;
    private bc hjh;
    private SmartBubbleAnimatedView hji;
    private m hjm;
    private com.baidu.tieba.tbadkCore.data.f hzG;
    private com.baidu.tieba.f.a iac;
    private boolean ikn;
    private final BigdaySwipeRefreshLayout imi;
    private final af irC;
    private ScrollFragmentTabHost irq;
    private Runnable isH;
    private final long isj;
    private final b isk;
    private DataRes.Builder ism;
    private final com.baidu.tieba.homepage.personalize.model.a isp;
    private int iss;
    private h isu;
    private BdUniqueId isx;
    private int isy;
    private final TbPageContext<?> mPageContext;
    private a isl = null;
    private final List<q> mDataList = new LinkedList();
    private int mPn = 1;
    private boolean mIsLoading = false;
    private boolean imq = false;
    private int isn = 2;
    private int iso = 0;
    private TextView mTipView = null;
    private int hEz = 2000;
    private com.baidu.tbadk.n.c isq = null;
    private boolean hCs = false;
    private int hBI = 0;
    private int fmb = 0;
    private boolean mIsBackground = false;
    private boolean iqB = true;
    private boolean isr = false;
    private boolean ist = false;
    private boolean isv = true;
    private FloatInfo isw = null;
    private BdUniqueId isz = BdUniqueId.gen();
    private a.C0098a hAa = new a.C0098a(2);
    private ThreadInfo isA = null;
    private RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.e.12
        private int isP = -1;
        private int imy = 0;
        private boolean isQ = false;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (e.this.isq == null) {
                e.this.isq = new com.baidu.tbadk.n.c();
                e.this.isq.setSubType(1005);
                e.this.isq.pageType = 1;
            }
            if (e.this.eEB != null && !e.this.mIsBackground) {
                e.this.eEB.k(recyclerView, i);
            }
            if (i == 0) {
                c.d(e.this.hEN);
                e.this.isq.bhG();
                s.bOA().jI(true);
                com.baidu.tieba.a.d.boA().dh("page_recommend", "show_");
                com.baidu.tieba.s.c.dgX().b(e.this.isx, false);
                this.isQ = false;
                if (e.this.hjm != null && e.this.iqB && !e.this.mIsBackground) {
                    e.this.hjm.a(e.this.hBI, e.this.fmb, e.this.hCs, 1);
                    return;
                }
                return;
            }
            e.this.isq.bhF();
            if (i == 1) {
                if (e.this.hjh != null) {
                    e.this.hjh.hideTip();
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
            if (this.imy > i) {
                this.isQ = true;
            }
            if (e.this.eEB != null && !e.this.mIsBackground) {
                e.this.eEB.onScroll(this.imy, i);
            }
            this.imy = i;
            int i3 = (i + i2) - 1;
            if (!this.isQ && this.isP != i3) {
                this.isP = i3;
                e.this.xk(this.isP);
            }
            if (this.isQ && this.isP != i) {
                this.isP = i;
                e.this.xk(this.isP);
            }
            e.this.isG = i;
            e.this.hBI = i;
            e.this.fmb = (i + i2) - 1;
            ak cjf = e.this.cjf();
            if (cjf != null && cjf.se() != null) {
                cjf.se().b(e.this.hAa);
            }
        }
    };
    private View.OnTouchListener eEC = new View.OnTouchListener() { // from class: com.baidu.tieba.homepage.personalize.e.23
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (e.this.erl != null) {
                e.this.erl.onTouch(view, motionEvent);
            }
            if (e.this.iac != null) {
                e.this.iac.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private a.InterfaceC0614a gZb = new a.InterfaceC0614a() { // from class: com.baidu.tieba.homepage.personalize.e.26
        @Override // com.baidu.tieba.f.a.InterfaceC0614a
        public void D(int i, int i2) {
            e.this.hCs = false;
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0614a
        public void E(int i, int i2) {
            e.this.hCs = true;
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0614a
        public void bO(int i, int i2) {
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0614a
        public void F(int i, int i2) {
        }
    };
    private View.OnClickListener isB = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.e.27
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (e.this.hjh != null) {
                e.this.hjh.hideTip();
            }
        }
    };
    private final CustomMessageListener isC = new CustomMessageListener(CmdConfigCustom.CMD_RELOAD_HP_PERSONALIZED) { // from class: com.baidu.tieba.homepage.personalize.e.28
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (e.this.hEN != null) {
                e.this.hjm.cje();
                e.this.iqB = false;
                e.this.imi.setRefreshing(true);
            }
        }
    };
    private final CustomMessageListener isD = new CustomMessageListener(2921461) { // from class: com.baidu.tieba.homepage.personalize.e.29
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (e.this.hEN != null) {
                e.this.cjL();
            }
        }
    };
    private CustomMessageListener hSK = new CustomMessageListener(CmdConfigCustom.PB_ACTION_PRAISE) { // from class: com.baidu.tieba.homepage.personalize.e.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            bu buVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bu) && e.this.ism != null && w.getCount(e.this.ism.thread_list) != 0 && (buVar = (bu) customResponsedMessage.getData()) != null && buVar.aSa() != null && buVar.getId() != null && w.getCount(e.this.ism.thread_list) != 0) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < e.this.ism.thread_list.size()) {
                        ThreadInfo threadInfo = e.this.ism.thread_list.get(i2);
                        if (threadInfo == null || threadInfo.id.longValue() != com.baidu.adp.lib.f.b.toLong(buVar.getId(), -1L)) {
                            i = i2 + 1;
                        } else {
                            ThreadInfo.Builder builder = new ThreadInfo.Builder(threadInfo);
                            Zan.Builder builder2 = new Zan.Builder(builder.zan);
                            builder2.num = Integer.valueOf((int) buVar.aSa().getNum());
                            builder.zan = builder2.build(true);
                            e.this.ism.thread_list.set(i2, builder.build(true));
                            return;
                        }
                    } else {
                        return;
                    }
                }
            }
        }
    };
    private CustomMessageListener isE = new CustomMessageListener(CmdConfigCustom.CMD_LIVE_VIDEO_CLOSED_QUERY_RESPONSED) { // from class: com.baidu.tieba.homepage.personalize.e.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            bu buVar;
            if (customResponsedMessage.getOrginalMessage() instanceof LiveRoomClosedQueryMessage) {
                List<Long> ids = ((LiveRoomClosedQueryMessage) customResponsedMessage.getOrginalMessage()).getIds();
                List<Object> originData = ((LiveRoomClosedQueryMessage) customResponsedMessage.getOrginalMessage()).getOriginData();
                if (!w.isEmpty(e.this.mDataList) && !w.isEmpty(ids) && !w.isEmpty(originData)) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= originData.size()) {
                            break;
                        }
                        if ((originData.get(i2) instanceof bu) && (buVar = (bu) originData.get(i2)) != null && buVar.aSJ() != null && ids.contains(Long.valueOf(buVar.aSJ().live_id))) {
                            e.this.mDataList.remove(buVar);
                        }
                        i = i2 + 1;
                    }
                    if (e.this.irC != null) {
                        e.this.irC.bN(new ArrayList(e.this.mDataList));
                    }
                }
            }
        }
    };
    private CustomMessageListener dUF = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.homepage.personalize.e.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int intValue;
            if ((customResponsedMessage instanceof UpdateAttentionMessage) && e.this.ism != null && !w.isEmpty(e.this.ism.thread_list)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid)) {
                    int i = 0;
                    while (true) {
                        if (i >= e.this.ism.thread_list.size()) {
                            break;
                        }
                        ThreadInfo threadInfo = e.this.ism.thread_list.get(i);
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
                            e.this.ism.thread_list.set(i, builder.build(true));
                        }
                    }
                    e.this.a(updateAttentionMessage);
                }
            }
        }
    };
    private String isF = "lastReadReadPositionKey";
    private int isG = 0;
    private d isI = new d() { // from class: com.baidu.tieba.homepage.personalize.e.13
        @Override // com.baidu.tieba.homepage.personalize.d
        public void wT(final int i) {
            if (e.this.isH == null) {
                e.this.isH = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.e.13.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (e.this.hEN.getHandler() != null) {
                            e.this.hEN.requestFocusFromTouch();
                            if (i <= e.this.hEN.getCount() - 1) {
                                e.this.hEN.setSelection(i);
                            }
                        }
                    }
                };
            }
            e.this.hEN.removeCallbacks(e.this.isH);
            e.this.hEN.post(e.this.isH);
        }
    };
    private CustomMessageListener isJ = new CustomMessageListener(2016569) { // from class: com.baidu.tieba.homepage.personalize.e.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && e.this.isu != null) {
                e.this.mDataList.remove(e.this.isu);
                e.this.irC.bN(new ArrayList(e.this.mDataList));
                com.baidu.tbadk.core.sharedPref.b.aVP().putLong("key_maintab_banner_close_time", System.currentTimeMillis());
            }
        }
    };
    private CustomMessageListener hjb = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.homepage.personalize.e.17
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.g(customResponsedMessage);
            if (e.this.hjm != null && e.this.iqB) {
                e.this.hjm.a(e.this.hBI, e.this.fmb, e.this.hCs, true);
            }
        }
    };
    private CustomMessageListener hjc = new CustomMessageListener(CmdConfigCustom.CMD_THREAD_NOT_EXIST_WHEN_ENTER_PB) { // from class: com.baidu.tieba.homepage.personalize.e.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.g(customResponsedMessage);
        }
    };
    private CustomMessageListener hSY = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.homepage.personalize.e.19
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && e.this.ism != null && w.getCount(e.this.ism.thread_list) != 0) {
                String str = (String) customResponsedMessage.getData();
                e.this.h(str, e.this.mDataList);
                e.this.Gf(str);
                if (e.this.irC != null) {
                    e.this.irC.bN(new ArrayList(e.this.mDataList));
                }
                if (e.this.hjm != null && e.this.iqB) {
                    e.this.hjm.a(e.this.hBI, e.this.fmb, e.this.hCs, true);
                }
            }
        }
    };
    private CustomMessageListener hBs = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.homepage.personalize.e.20
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ak cjf;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent)) {
                KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24 && (cjf = e.this.cjf()) != null && cjf.se() != null) {
                    cjf.se().b(new a.C0098a(3));
                }
            }
        }
    };
    private com.baidu.adp.framework.listener.a isK = new com.baidu.adp.framework.listener.a(1003065, CmdConfigSocket.CMD_TOPIC_BLESS) { // from class: com.baidu.tieba.homepage.personalize.e.21
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
                    for (q qVar : e.this.mDataList) {
                        if ((qVar instanceof com.baidu.tieba.homepage.topic.topictab.b.a) && (bVar = ((com.baidu.tieba.homepage.topic.topictab.b.a) qVar).izB) != null && longValue == bVar.pkId) {
                            bVar.userPkId = j2;
                            return;
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener hBt = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.homepage.personalize.e.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            List<q> dataList = e.this.irC.getDataList();
            if (!w.isEmpty(dataList)) {
                for (q qVar : dataList) {
                    if (qVar instanceof k) {
                        k kVar = (k) qVar;
                        if (kVar.dLj != 0 && kVar.dLi != null) {
                            int[] imageWidthAndHeight = kVar.dLi.getImageWidthAndHeight();
                            kVar.dLj = imageWidthAndHeight[0];
                            kVar.dLk = imageWidthAndHeight[1];
                        }
                    }
                }
            }
            com.baidu.adp.lib.f.e.lt().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.personalize.e.22.1
                @Override // java.lang.Runnable
                public void run() {
                    e.this.irC.notifyDataSetChanged();
                    if (!e.this.mIsBackground && e.this.iqB) {
                        e.this.hjm.a(e.this.hBI, e.this.fmb, e.this.hCs, true);
                    }
                }
            }, 500L);
        }
    };
    private CustomMessageListener hjd = new CustomMessageListener(2921453) { // from class: com.baidu.tieba.homepage.personalize.e.24
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.data.bc)) {
                com.baidu.tbadk.core.data.bc bcVar = (com.baidu.tbadk.core.data.bc) customResponsedMessage.getData();
                if (bcVar.dKj == 1) {
                    int equipmentWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst());
                    int equipmentHeight = l.getEquipmentHeight(TbadkCoreApplication.getInst());
                    float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
                    int i = as.aWR().aWS() ? 2 : 1;
                    RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
                    requestGetMyPostNetMessage.setTag(e.this.isz);
                    requestGetMyPostNetMessage.setParams(com.baidu.adp.lib.f.b.toLong(bcVar.tid, 0L), 0L, 0L, equipmentWidth, equipmentHeight, f, i);
                    requestGetMyPostNetMessage.setBFrom("push");
                    MessageManager.getInstance().sendMessage(requestGetMyPostNetMessage);
                }
            }
        }
    };
    private final com.baidu.adp.framework.listener.a hje = new com.baidu.adp.framework.listener.a(1003010, CmdConfigSocket.CMD_GET_MY_POST) { // from class: com.baidu.tieba.homepage.personalize.e.25
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            GetMyPostResIdl getMyPostResIdl = null;
            if (responsedMessage instanceof GetMyPostHttpResponseMessage) {
                getMyPostResIdl = ((GetMyPostHttpResponseMessage) responsedMessage).getResponseData();
            } else if (responsedMessage instanceof GetMyPostSocketResponseMessage) {
                getMyPostResIdl = ((GetMyPostSocketResponseMessage) responsedMessage).getResponseData();
            }
            if (getMyPostResIdl != null && getMyPostResIdl.data != null && getMyPostResIdl.data.thread_info != null) {
                e.this.isA = getMyPostResIdl.data.thread_info;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921455));
            }
        }
    };

    /* loaded from: classes9.dex */
    public interface a {
        void A(int i, int i2, int i3, int i4);

        void Q(int i, int i2, int i3);

        void cjz();

        void onError(int i, String str);

        void onSuccess();
    }

    public void oy(boolean z) {
        this.isv = z;
        if (this.hjh != null && !z) {
            this.hjh.hideTip();
        }
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.irq = scrollFragmentTabHost;
        if (this.irq != null) {
            this.irq.setOnTabSelectedListener(new ScrollFragmentTabHost.b() { // from class: com.baidu.tieba.homepage.personalize.e.1
                @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.b
                public void xd(int i) {
                    if (e.this.irq.xc(i) != 1 && e.this.hjh != null) {
                        e.this.hjh.hideTip();
                    }
                }
            });
        }
    }

    public void setTabInForeBackgroundState(boolean z) {
        this.mIsBackground = z;
    }

    public void ni(boolean z) {
        boolean z2 = false;
        this.mIsBackground = z;
        if (this.irq != null) {
            this.irq.ni(z);
        }
        if (this.hjm != null) {
            this.hjm.qs(!z);
            ak cjf = cjf();
            if (cjf != null && cjf.se() != null) {
                z2 = cjf.se().b(new a.C0098a(8, Boolean.valueOf(z)));
            }
            if (!z2) {
                if (z) {
                    this.hjm.cje();
                } else if (this.iqB) {
                    this.hjm.a(this.hBI, this.fmb, this.hCs, true);
                }
            }
        }
    }

    public e(TbPageContext<?> tbPageContext, BdTypeRecyclerView bdTypeRecyclerView, af afVar, BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout) {
        this.isy = 0;
        this.mPageContext = tbPageContext;
        this.isy = com.baidu.tbadk.core.sharedPref.b.aVP().getInt("key_personalized_refresh_type", 0);
        this.imi = bigdaySwipeRefreshLayout;
        this.hEN = bdTypeRecyclerView;
        this.hEN.setOnTouchListener(this.eEC);
        this.iac = new com.baidu.tieba.f.a();
        this.iac.a(this.gZb);
        this.irC = afVar;
        this.isp = new com.baidu.tieba.homepage.personalize.model.a();
        this.isj = com.baidu.tbadk.core.sharedPref.b.aVP().getLong("recommend_frs_cache_time", 1800L) * 1000;
        bdTypeRecyclerView.setOnScrollListener(this.mOnScrollListener);
        this.hjh = new bc();
        cjJ();
        this.hjm = new m(this.mPageContext, this.hEN);
        this.hjm.CN(1);
        this.hjm.CM(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.isk = new b(this.mDataList, this.irC);
        this.hji = new SmartBubbleAnimatedView(tbPageContext.getContext());
        this.hji.setLayoutParams(new FrameLayout.LayoutParams(-1, l.getDimens(tbPageContext.getContext(), R.dimen.tbds83)));
        cjA();
        this.hBt.setTag(this.mPageContext.getUniqueId());
        MessageManager.getInstance().registerListener(this.hBt);
        if (MessageManager.getInstance().findTask(1003010) == null) {
            HomePageStatic.chP();
        }
        this.hje.setTag(this.isz);
        if (this.hje.getHttpMessageListener() != null) {
            this.hje.getHttpMessageListener().setSelfListener(true);
        }
        if (this.hje.getSocketMessageListener() != null) {
            this.hje.getSocketMessageListener().setSelfListener(true);
        }
        MessageManager.getInstance().registerListener(this.hje);
        MessageManager.getInstance().registerListener(this.hjd);
    }

    private void cjA() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2016323, new CustomMessageTask.CustomRunnable<Boolean>() { // from class: com.baidu.tieba.homepage.personalize.e.30
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Boolean> customMessage) {
                ak cjf = e.this.cjf();
                return (cjf == null || cjf.se() == null) ? new CustomResponsedMessage<>(2016323, false) : new CustomResponsedMessage<>(2016323, Boolean.valueOf(cjf.se().b(new a.C0098a(6))));
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private boolean cjB() {
        return com.baidu.tbadk.core.sharedPref.b.aVP().getBoolean(cjD(), true);
    }

    private void cjC() {
        com.baidu.tbadk.core.sharedPref.b.aVP().putBoolean(cjD(), false);
    }

    private String cjD() {
        return "key_rec_pfirst_load_" + TbadkCoreApplication.getCurrentAccount() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + TbConfig.getVersion();
    }

    public void setRecommendFrsNavigationAnimDispatcher(aa aaVar) {
        if (aaVar != null) {
            this.eEB = aaVar.biZ();
            this.erl = aaVar.bja();
        }
    }

    public void showFloatingView() {
        if (this.eEB != null) {
            this.eEB.iK(true);
        }
    }

    public void update() {
        com.baidu.tieba.homepage.framework.a.cif().q(System.currentTimeMillis(), 1);
        this.mPn = 1;
        this.ist = true;
        if (this.mDataList.size() == 0 && !cjB()) {
            if (!this.imq) {
                aPK();
                return;
            }
            return;
        }
        aPJ();
    }

    public void cm(int i, int i2) {
        bu buVar;
        if (!w.isEmpty(this.mDataList) && this.mDataList.size() > i) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            while (i < this.mDataList.size() && i <= i2) {
                if (this.mDataList.get(i).getType().getId() == bu.dLI.getId() && (buVar = (bu) this.mDataList.get(i)) != null && buVar.aSJ() != null) {
                    arrayList.add(Long.valueOf(buVar.aSJ().live_id));
                    arrayList2.add(buVar);
                }
                i++;
            }
            if (!w.isEmpty(arrayList)) {
                MessageManager.getInstance().sendMessage(new LiveRoomClosedQueryMessage(arrayList, arrayList2));
            }
        }
    }

    public void cjE() {
        if (this.hjm != null && !this.mIsBackground && this.iqB) {
            this.hjm.a(this.hBI, this.fmb, this.hCs, true);
        }
        if (this.isr) {
            if (this.imi != null && !this.imi.aYo()) {
                if (this.ikn) {
                    com.baidu.tieba.s.c.dgX().b(this.isx, false);
                    if (oA(false)) {
                        cn(3, this.iso);
                    } else if (this.iss > 0) {
                        cn(2, this.iso);
                    }
                } else if (!this.ikn && this.iso == 0) {
                    cn(2, 0);
                }
            }
            this.isr = false;
            this.ikn = false;
            this.iss = 0;
            if (this.ist) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
            }
            this.ist = false;
        }
    }

    public void btu() {
        if (isLoading()) {
            com.baidu.tieba.homepage.framework.a.cif().q(0L, 1);
        } else if (this.isl != null) {
            cjG();
            this.mPn++;
            setIsLoading(true);
            this.isl.A(this.mPn, (this.ism == null || this.ism.thread_list == null) ? 0 : this.ism.thread_list.size(), oz(false), 0);
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
        if (this.isp != null && this.isp.cki() && !z && (dataRes == null || w.isEmpty(dataRes.thread_list))) {
            if (dataRes == null) {
                DataRes.Builder builder = new DataRes.Builder();
                builder.thread_list = new ArrayList();
                dataRes = builder.build(false);
            }
            if (dataRes.thread_list != null) {
                List<ThreadInfo> ckj = this.isp.ckj();
                dataRes.thread_list.addAll(ckj);
                if (ckj != null) {
                    ckj.clear();
                }
                z3 = true;
                size = (this.ism != null || this.ism.thread_list == null) ? 0 : this.ism.thread_list.size();
                if (z && i == 0 && dataRes != null && w.isEmpty(dataRes.thread_list)) {
                    if (this.isl != null) {
                        this.isl.cjz();
                    }
                    setIsLoading(false);
                    if (this.imi != null) {
                        this.imi.setRefreshing(false);
                        return;
                    }
                    return;
                }
                if (this.isA != null) {
                    DataRes.Builder builder2 = new DataRes.Builder(dataRes);
                    builder2.thread_list.add(0, this.isA);
                    dataRes = builder2.build(false);
                    if (this.ism != null && !w.isEmpty(this.ism.thread_list)) {
                        Iterator<ThreadInfo> it = this.ism.thread_list.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            ThreadInfo next = it.next();
                            if (next != null && next.tid != null && this.isA.tid != null && next.tid.longValue() == this.isA.tid.longValue()) {
                                this.ism.thread_list.remove(next);
                                break;
                            }
                        }
                    }
                    this.isA = null;
                }
                if ((z3 && i != 0) || dataRes == null || !a(true, z, z2, dataRes)) {
                    this.isr = false;
                    if (this.mDataList.size() > 0) {
                        if (this.isl != null) {
                            this.isl.onError(1, str);
                        }
                    } else if (this.isl != null) {
                        this.isl.onError(2, str);
                    }
                } else {
                    cjC();
                    if (this.isl != null) {
                        com.baidu.tbadk.core.sharedPref.b.aVP().putLong(SharedPrefConfig.RECOMMEND_FRS_REFRESH_TIME + TbadkCoreApplication.getCurrentAccount(), System.currentTimeMillis());
                        this.isl.onSuccess();
                    }
                    this.isr = true;
                    this.ikn = z;
                    this.iss = size;
                    bSj();
                }
                setIsLoading(false);
                if (this.imi == null) {
                    f.e cjF = cjF();
                    if (this.imi.aYo() && cjF != null) {
                        this.imi.c(cjF);
                        return;
                    } else {
                        this.imi.setRefreshing(false);
                        return;
                    }
                }
                return;
            }
        }
        z3 = false;
        if (this.ism != null) {
        }
        if (z) {
        }
        if (this.isA != null) {
        }
        if (z3) {
        }
        cjC();
        if (this.isl != null) {
        }
        this.isr = true;
        this.ikn = z;
        this.iss = size;
        bSj();
        setIsLoading(false);
        if (this.imi == null) {
        }
    }

    private f.e cjF() {
        int i;
        String feedText;
        if (this.isr && this.imi != null && this.imi.aYo()) {
            int i2 = this.iso;
            if (this.ikn) {
                com.baidu.tieba.s.c.dgX().b(this.isx, false);
                if (oA(false)) {
                    i = 3;
                } else {
                    i = this.iss > 0 ? 2 : 0;
                }
            } else if (this.ikn || this.iso != 0) {
                return null;
            } else {
                i2 = 0;
                i = 2;
            }
            if (this.irq != null) {
                this.hjh.cao();
            }
            if (this.irq != null && this.irq.getCurrentTabType() != 1) {
                this.hjh.hideTip();
                return null;
            } else if (!this.isv) {
                this.hjh.hideTip();
                return null;
            } else {
                this.isn = i;
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
                    this.hEz = 1000;
                } else {
                    this.hEz = 0;
                }
                return new f.e(feedText, this.hEz);
            }
        }
        return null;
    }

    public void oo(boolean z) {
        if (z) {
            this.irC.notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        if (this.hjm != null) {
            this.hjm.destroy();
        }
        if (this.hjh != null) {
            this.hjh.onDestroy();
        }
        if (this.isk != null) {
            this.isk.onDestroy();
        }
        if (this.hEN != null) {
            this.hEN.removeCallbacks(this.isH);
        }
        MessageManager.getInstance().unRegisterTask(2016323);
        MessageManager.getInstance().unRegisterListener(this.hBt);
        MessageManager.getInstance().unRegisterListener(this.hjd);
        MessageManager.getInstance().unRegisterListener(this.hje);
    }

    public void onPause() {
        c.d(this.hEN);
        xl(this.isG);
        if (this.isq != null) {
            this.isq.bhH();
        }
    }

    private void aPJ() {
        if (this.isl != null) {
            this.isl.Q((this.ism == null || this.ism.thread_list == null || cjI()) ? 0 : this.ism.thread_list.size(), oz(true), 0);
        }
    }

    public int oz(boolean z) {
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
                q qVar = this.mDataList.get(i5);
                if (!(qVar instanceof com.baidu.tieba.card.data.c) || (i3 = ((com.baidu.tieba.card.data.c) qVar).position) == i6) {
                    i3 = i6;
                    i4 = i7;
                } else {
                    i4 = i7 + 1;
                }
                if (!(qVar instanceof com.baidu.tieba.homepage.personalize.data.a) || qVar.getType() == AdvertAppInfo.dGA) {
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
                q qVar2 = this.mDataList.get(size);
                if (!(qVar2 instanceof com.baidu.tieba.card.data.c) || (i = ((com.baidu.tieba.card.data.c) qVar2).position) == i9) {
                    i = i9;
                    i2 = i8;
                } else {
                    i2 = i8 + 1;
                }
                if ((qVar2 instanceof com.baidu.tieba.homepage.personalize.data.a) && qVar2.getType() != AdvertAppInfo.dGA) {
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
        this.imq = true;
        if (dataRes != null) {
            if (a(false, true, true, dataRes) && !cjI()) {
                if (this.isl != null) {
                    this.isl.onSuccess();
                    Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler() { // from class: com.baidu.tieba.homepage.personalize.e.31
                        @Override // android.os.MessageQueue.IdleHandler
                        public boolean queueIdle() {
                            e.this.bhM();
                            return false;
                        }
                    });
                }
                if (TbSingleton.getInstance().getForceRefreshHomeRecommend()) {
                    aPJ();
                    TbSingleton.getInstance().setForceRefreshHomeRecommend(false);
                    return;
                }
                return;
            }
            aPJ();
            return;
        }
        aPJ();
    }

    public void bhM() {
        long wR = com.baidu.tieba.homepage.framework.a.cif().wR(1) + com.baidu.tieba.homepage.framework.a.cif().getCreateTime();
        long wP = com.baidu.tieba.homepage.framework.a.cif().wP(1);
        if (wP > 0) {
            wR = System.currentTimeMillis() - wP;
        }
        n.bhU().cU(wR);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.util.Set] */
    private void k(List<q> list, int i) {
        AdvertAppInfo bOT;
        AdvertAppInfo bOT2;
        if (!w.isEmpty(list)) {
            Set<q> LV = com.baidu.tieba.recapp.report.a.LV("NEWINDEX");
            HashSet hashSet = LV == null ? new HashSet() : LV;
            HashSet hashSet2 = new HashSet();
            for (q qVar : list) {
                if (qVar != null) {
                    for (q qVar2 : hashSet) {
                        if ((qVar instanceof com.baidu.tieba.card.data.d) && (bOT2 = ((com.baidu.tieba.card.data.d) qVar).bOT()) != null && qVar2 != null && (qVar2 instanceof AdvertAppInfo) && qVar2.hashCode() == bOT2.hashCode()) {
                            bOT2.advertAppContext = ((AdvertAppInfo) qVar2).advertAppContext;
                        }
                    }
                    if (qVar != null && (qVar instanceof com.baidu.tieba.card.data.d) && (bOT = ((com.baidu.tieba.card.data.d) qVar).bOT()) != null && bOT.advertAppContext == null) {
                        bOT.advertAppContext = new com.baidu.tbadk.core.data.b();
                        bOT.advertAppContext.page = "NEWINDEX";
                        bOT.advertAppContext.pn = this.mPn;
                        bOT.advertAppContext.extensionInfo = bOT.extensionInfo;
                        bOT.advertAppContext.XE = false;
                        hashSet2.add(bOT);
                    }
                }
            }
            hashSet.addAll(hashSet2);
            com.baidu.tieba.recapp.report.a.b("NEWINDEX", hashSet);
            if (hashSet2.size() > 0) {
                com.baidu.tieba.s.c.dgX().b(this.isx, com.baidu.tieba.s.a.b(PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE, "common_fill", true, hashSet2.size()));
            }
        }
    }

    private boolean a(boolean z, boolean z2, boolean z3, DataRes dataRes) {
        List<q> list;
        int i;
        boolean z4;
        if (dataRes == null) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.isy == 1) {
            if (z2 && (dataRes.thread_list.size() >= 6 || cjI())) {
                cjH();
                this.ism = null;
            }
        } else if (z2 && cjI()) {
            this.ism = null;
        }
        int size = z2 ? 0 : this.mDataList.size();
        DataRes.Builder builder = new DataRes.Builder(dataRes);
        this.mDataList.clear();
        com.baidu.tieba.homepage.personalize.model.c a2 = this.isp.a(z, this.ism, builder, z2 ? 0 : 1);
        if (a2 == null) {
            list = null;
            i = 0;
        } else {
            List<q> list2 = a2.eSH;
            this.iso = a2.ivl;
            int i2 = a2.ivm;
            a2.ivm = 0;
            list = list2;
            i = i2;
        }
        if (list != null) {
            this.mDataList.addAll(list);
            k(list, size);
            a(z2 ? 0 : 1, list, size);
            if (this.ist) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
            }
        }
        if (this.ism == null) {
            this.ism = builder;
            this.isk.cX(this.ism.thread_list);
        }
        if (this.mDataList.size() == 0) {
            z4 = false;
        } else {
            if (z2) {
                if (dataRes.live_answer != null) {
                    this.isu = new h();
                    this.isu.a(dataRes.live_answer);
                    this.ism.live_answer = dataRes.live_answer;
                } else if (z) {
                    this.isu = null;
                    this.ism.live_answer = null;
                }
                this.isw = dataRes.float_info;
                this.ism.float_info = dataRes.float_info;
            }
            long j = com.baidu.tbadk.core.sharedPref.b.aVP().getLong("key_maintab_banner_close_time", 0L);
            if (this.isu != null && !ar.isTaday(j)) {
                this.mDataList.add(0, this.isu);
            }
            LinkedList linkedList = new LinkedList(this.mDataList);
            this.irC.setFromCDN(dataRes.is_new_url != null && dataRes.is_new_url.intValue() == 1);
            this.irC.l(linkedList, i);
            z4 = true;
            if (this.hjm != null && this.iqB) {
                this.hjm.a(this.hBI, this.fmb, this.hCs, true);
            }
        }
        com.baidu.tieba.homepage.framework.a.cif().o(System.currentTimeMillis() - currentTimeMillis, 1);
        long wS = com.baidu.tieba.homepage.framework.a.cif().wS(1);
        if (wS > 0) {
            com.baidu.tieba.homepage.framework.a.cif().p(System.currentTimeMillis() - wS, 1);
            com.baidu.tieba.homepage.framework.a.cif().q(0L, 1);
        }
        if (dataRes.anti != null && dataRes.anti.block_pop_info != null) {
            com.baidu.tieba.ueg.d.d(dataRes.anti.block_pop_info);
        }
        be beVar = new be();
        beVar.a(dataRes.recom_post_topic);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_REFRESH_TOPIC_TIP, beVar));
        return z4;
    }

    private void cjG() {
        List<q> list;
        int i;
        if (w.getCount(this.mDataList) >= this.isp.cke() - 40) {
            com.baidu.tieba.homepage.personalize.model.c a2 = this.isp.a(true, this.ism, null, 1);
            if (a2 != null) {
                List<q> list2 = a2.eSH;
                i = a2.ivm;
                a2.ivm = 0;
                list = list2;
            } else {
                list = null;
                i = 0;
            }
            if (list != null) {
                this.mDataList.clear();
                this.mDataList.addAll(list);
                this.irC.l(new LinkedList(this.mDataList), i);
            }
        }
    }

    private void aPK() {
        this.imq = true;
        ad.a(new ac<DataRes>() { // from class: com.baidu.tieba.homepage.personalize.e.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.ac
            /* renamed from: cjM */
            public DataRes doInBackground() {
                com.baidu.adp.lib.cache.l<byte[]> dc = com.baidu.tbadk.core.c.a.aUM().dc("tb.rec_frs_update", TbadkCoreApplication.getCurrentAccount());
                if (dc == null) {
                    return null;
                }
                byte[] bArr = dc.get("0");
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
        }, new com.baidu.tbadk.util.l<DataRes>() { // from class: com.baidu.tieba.homepage.personalize.e.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.l
            /* renamed from: b */
            public void onReturnDataInUI(DataRes dataRes) {
                e.this.a(dataRes);
            }
        });
    }

    private void bSj() {
        if (this.ism != null) {
            DataRes.Builder builder = new DataRes.Builder(this.ism.build(true));
            if (builder.thread_list != null && builder.thread_list.size() > 30) {
                builder.thread_list = builder.thread_list.subList(0, 30);
            }
            a(builder, builder.thread_list != null ? builder.thread_list.size() : 0);
            a(builder);
            b(builder);
            c(builder);
        }
    }

    private void cjH() {
        if (this.ism != null) {
            final DataRes.Builder builder = new DataRes.Builder(this.ism.build(true));
            if (builder.thread_list != null && builder.thread_list.size() > 50) {
                builder.thread_list = builder.thread_list.subList(0, 50);
            }
            a(builder, builder.thread_list != null ? builder.thread_list.size() : 0);
            ad.a(new ac<Object>() { // from class: com.baidu.tieba.homepage.personalize.e.4
                @Override // com.baidu.tbadk.util.ac
                public Object doInBackground() {
                    DataRes.Builder builder2 = new DataRes.Builder(builder.build(true));
                    e.this.isk.cY(builder2.thread_list);
                    try {
                        com.baidu.tbadk.core.c.a.aUM().dc("tb.rec_old_data", TbadkCoreApplication.getCurrentAccount()).setForever("0", builder2.build(true).toByteArray());
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

    private void b(DataRes.Builder builder) {
        builder.active_center = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Gf(String str) {
        if (!TextUtils.isEmpty(str) && this.ism != null && this.ism.banner_list != null && this.ism.banner_list.app != null && this.ism.banner_list.app.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (App app : this.ism.banner_list.app) {
                if (app != null && str.equals(app.id)) {
                    arrayList.add(app);
                }
            }
            BannerList.Builder builder = new BannerList.Builder(this.ism.banner_list);
            if (builder.app != null) {
                builder.app.removeAll(arrayList);
            }
            this.ism.banner_list = builder.build(false);
            DataRes.Builder builder2 = new DataRes.Builder(this.ism.build(true));
            builder2.banner_list = builder.build(true);
            c(builder2);
        }
    }

    private void c(final DataRes.Builder builder) {
        ad.a(new ac<Object>() { // from class: com.baidu.tieba.homepage.personalize.e.5
            @Override // com.baidu.tbadk.util.ac
            public Object doInBackground() {
                DataRes.Builder builder2 = new DataRes.Builder(builder.build(true));
                e.this.isk.cY(builder2.thread_list);
                try {
                    com.baidu.tbadk.core.c.a.aUM().dc("tb.rec_frs_update", TbadkCoreApplication.getCurrentAccount()).setForever("0", builder2.build(true).toByteArray());
                    return null;
                } catch (Exception e) {
                    BdLog.e(e);
                    return null;
                }
            }
        }, null);
    }

    private boolean cjI() {
        return oA(true);
    }

    private boolean oA(boolean z) {
        long j = com.baidu.tbadk.core.sharedPref.b.aVP().getLong(SharedPrefConfig.RECOMMEND_FRS_REFRESH_TIME + TbadkCoreApplication.getCurrentAccount(), 0L);
        return j == 0 ? z : Math.abs(System.currentTimeMillis() - j) > this.isj;
    }

    public void a(a aVar) {
        this.isl = aVar;
    }

    private boolean isLoading() {
        return this.mIsLoading;
    }

    private void setIsLoading(boolean z) {
        this.mIsLoading = z;
    }

    public void cjw() {
        boolean z = true;
        com.baidu.tbadk.coreExtra.data.b activityPrizeData = TbadkCoreApplication.getInst().getActivityPrizeData();
        if (activityPrizeData.isSwitchTurn() && !StringUtils.isNull(activityPrizeData.getFeedText())) {
            String currentDay = UtilHelper.getCurrentDay();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            String str = "";
            if (!StringUtils.isNull(currentAccount)) {
                String string = com.baidu.tbadk.core.sharedPref.b.aVP().getString(SharedPrefConfig.ACTIVITY_PRIZE_FEED_TEXT_TIME, "");
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
                    cn(4, 0);
                    com.baidu.tbadk.core.sharedPref.b.aVP().putString(SharedPrefConfig.ACTIVITY_PRIZE_FEED_TEXT_TIME, str);
                }
            }
        }
    }

    private void cn(int i, int i2) {
        if (this.irq != null) {
            this.hjh.cao();
        }
        if (this.irq != null && this.irq.getCurrentTabType() != 1) {
            this.hjh.hideTip();
        } else if (!this.isv) {
            this.hjh.hideTip();
        } else {
            this.isn = i;
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
                    this.hEz = 3000;
                } else {
                    this.hEz = 2000;
                }
                this.hji.edh = str;
                this.hji.hEs = this.hEz;
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 49;
                if (this.irq != null) {
                    FrameLayout frameLayout = this.irq.getFrameLayout();
                    frameLayout.removeView(this.hji);
                    frameLayout.addView(this.hji, layoutParams);
                    this.hji.cam();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(Long l) {
        if (this.ism != null && this.ism.thread_list != null) {
            List<ThreadInfo> list = this.ism.thread_list;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                ThreadInfo threadInfo = list.get(i);
                if (threadInfo.tid.equals(l) && threadInfo.top_agree_post != null) {
                    ThreadInfo.Builder builder = new ThreadInfo.Builder(threadInfo);
                    builder.top_agree_post = null;
                    list.set(i, builder.build(true));
                    bSj();
                    a(false, true, false, this.ism.build(true));
                    return;
                }
            }
        }
    }

    public void o(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.isx = bdUniqueId;
            if (this.hSK != null) {
                this.hSK.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.hSK);
            }
            if (this.isC != null) {
                this.isC.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.isC);
            }
            this.isD.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.isD);
            this.dUF.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.dUF);
            this.isE.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.isE);
            this.hjb.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.hjb);
            this.hjc.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.hjc);
            this.hSY.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.hSY);
            if (this.hjm != null) {
                this.hjm.setUniqueId(bdUniqueId);
            }
            this.isk.l(bdUniqueId);
            this.isJ.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.isJ);
            this.hBs.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.hBs);
            this.isK.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.isK);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(UpdateAttentionMessage updateAttentionMessage) {
        if (updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid)) {
            final String str = updateAttentionMessage.getData().toUid;
            final boolean z = updateAttentionMessage.getData().isAttention;
            ad.a(new ac<Boolean>() { // from class: com.baidu.tieba.homepage.personalize.e.9
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.baidu.tbadk.util.ac
                public Boolean doInBackground() {
                    int intValue;
                    try {
                        com.baidu.adp.lib.cache.l<byte[]> dc = com.baidu.tbadk.core.c.a.aUM().dc("tb.rec_frs_update", TbadkCoreApplication.getCurrentAccount());
                        if (dc == null) {
                            return false;
                        }
                        byte[] bArr = dc.get("0");
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
                        e.this.isk.cY(builder5.thread_list);
                        dc.setForever("0", builder5.build(true).toByteArray());
                        return true;
                    } catch (Exception e) {
                        BdLog.e(e);
                        return false;
                    }
                }
            }, new com.baidu.tbadk.util.l<Boolean>() { // from class: com.baidu.tieba.homepage.personalize.e.10
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.l
                public void onReturnDataInUI(Boolean bool) {
                }
            });
        }
    }

    public void cjJ() {
        this.hzG = new com.baidu.tieba.tbadkCore.data.f("new_index", null);
        this.hzG.dhE();
    }

    public void a(int i, List<q> list, int i2) {
        int i3;
        int i4;
        if (this.hzG != null) {
            if (i == 0) {
                this.hzG.dhE();
            }
            if (list != null && !list.isEmpty()) {
                int[] iArr = com.baidu.tieba.tbadkCore.data.f.lFm;
                int i5 = 0;
                int i6 = 0;
                int i7 = 0;
                while (i7 < list.size() && i6 < iArr.length && (i3 = iArr[i6]) >= 0) {
                    if (list.get(i7) instanceof com.baidu.tieba.card.data.c) {
                        i4 = i5 + 1;
                        if (i4 == i3 - 1) {
                            if (i2 < i7 + 1) {
                                this.hzG.da(i3, i7 + 1);
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

    public void xk(int i) {
        if ((this.hzG != null ? this.hzG.ET(i) : -1) >= 0 && this.hEN != null && this.hEN.getData() != null && this.hEN.getData().size() > i) {
            this.hzG.EU(i);
        }
    }

    public m bZa() {
        return this.hjm;
    }

    public void ou(boolean z) {
        this.iqB = z;
    }

    public void xl(final int i) {
        ad.a(new ac<Object>() { // from class: com.baidu.tieba.homepage.personalize.e.11
            @Override // com.baidu.tbadk.util.ac
            public Object doInBackground() {
                com.baidu.adp.lib.cache.l<String> dd = com.baidu.tbadk.core.c.a.aUM().dd(e.this.isF, TbadkCoreApplication.getCurrentAccount());
                if (dd != null) {
                    dd.set(e.this.isF, Integer.toString(i), 43200000L);
                    return null;
                }
                return null;
            }
        }, null);
    }

    public void a(final d dVar) {
        ad.a(new ac<String>() { // from class: com.baidu.tieba.homepage.personalize.e.14
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.ac
            /* renamed from: cjN */
            public String doInBackground() {
                com.baidu.adp.lib.cache.l<String> dd = com.baidu.tbadk.core.c.a.aUM().dd(e.this.isF, TbadkCoreApplication.getCurrentAccount());
                if (dd != null) {
                    return dd.get(e.this.isF);
                }
                return null;
            }
        }, new com.baidu.tbadk.util.l<String>() { // from class: com.baidu.tieba.homepage.personalize.e.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.l
            /* renamed from: Gg */
            public void onReturnDataInUI(String str) {
                if (dVar != null) {
                    dVar.wT(com.baidu.adp.lib.f.b.toInt(str, 0));
                }
            }
        });
    }

    public void cjx() {
        c.e(this.hEN);
    }

    public void cjK() {
        a(this.isI);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cjL() {
        Iterator<q> it = this.mDataList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            } else if (it.next() instanceof g) {
                it.remove();
                break;
            }
        }
        if (this.ism != null) {
            this.ism.active_center = null;
            bSj();
            if (this.hEN != null) {
                List<Integer> f = f(this.hEN);
                int intValue = f.get(0).intValue();
                int intValue2 = f.get(1).intValue();
                if (intValue != -1 && intValue2 != -1) {
                    this.hEN.m(intValue, intValue2);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(CustomResponsedMessage<?> customResponsedMessage) {
        boolean z;
        String str;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.ism != null && w.getCount(this.ism.thread_list) != 0 && w.getCount(this.mDataList) != 0) {
            JSONObject jSONObject = (JSONObject) customResponsedMessage.getData();
            String optString = jSONObject.optString("tid");
            if (StringUtils.isNull(optString)) {
                String optString2 = jSONObject.optString(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_ID);
                if (this.hEN != null && !TextUtils.isEmpty(optString2)) {
                    int i = 0;
                    while (true) {
                        if (i >= this.hEN.getCount()) {
                            str = optString;
                            break;
                        }
                        q item = this.hEN.getItem(i);
                        if (item instanceof com.baidu.tieba.card.data.j) {
                            com.baidu.tieba.card.data.j jVar = (com.baidu.tieba.card.data.j) item;
                            if (jVar.aPS() != null && jVar.aPS().aSJ() != null && optString2.equals(String.valueOf(jVar.aPS().aSJ().live_id))) {
                                str = jVar.aPS().getTid();
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
            Iterator<q> it = this.mDataList.iterator();
            boolean z2 = false;
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                q next = it.next();
                if (next instanceof com.baidu.tieba.card.data.c) {
                    com.baidu.tieba.card.data.c cVar = (com.baidu.tieba.card.data.c) next;
                    if (cVar.aPS() != null && cVar.aPS().getTid() != null) {
                        if (cVar.aPS().getTid().equals(optString)) {
                            it.remove();
                            z = true;
                            z2 = z;
                        } else if (z2) {
                            com.baidu.tieba.homepage.personalize.model.b.da(this.mDataList);
                            break;
                        }
                    }
                }
                z = z2;
                z2 = z;
            }
            if (this.ism != null && this.ism.thread_list != null) {
                long j = com.baidu.adp.lib.f.b.toLong(optString, 0L);
                int i2 = 0;
                while (true) {
                    if (i2 < this.ism.thread_list.size()) {
                        ThreadInfo threadInfo = this.ism.thread_list.get(i2);
                        if (threadInfo == null || threadInfo.tid == null || threadInfo.tid.longValue() != j) {
                            i2++;
                        } else {
                            com.baidu.tieba.homepage.personalize.b.d.a(threadInfo.tid.longValue(), i2, this.ism.thread_list, this.mDataList);
                            this.ism.thread_list.remove(i2);
                            bSj();
                            break;
                        }
                    } else {
                        break;
                    }
                }
                if (this.hEN != null) {
                    List<Integer> b = b(optString, this.hEN);
                    int intValue = b.get(0).intValue();
                    int intValue2 = b.get(1).intValue();
                    if (intValue != -1 && intValue2 != -1) {
                        this.hEN.m(intValue, intValue2);
                    }
                }
            }
        }
    }

    private List<Integer> f(BdTypeRecyclerView bdTypeRecyclerView) {
        int i = 0;
        ArrayList arrayList = new ArrayList(2);
        boolean z = false;
        int i2 = -1;
        int i3 = -1;
        while (true) {
            int i4 = i;
            if (i4 < bdTypeRecyclerView.getCount()) {
                q item = bdTypeRecyclerView.getItem(i4);
                if (item instanceof g) {
                    g gVar = (g) item;
                    if (!z) {
                        i3 = i4;
                    }
                    z = true;
                    i2 = i4;
                }
                i = i4 + 1;
            } else {
                arrayList.add(Integer.valueOf(i3));
                arrayList.add(Integer.valueOf(i2));
                return arrayList;
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
                q item = bdTypeRecyclerView.getItem(i4);
                if (item instanceof com.baidu.tieba.card.data.c) {
                    com.baidu.tieba.card.data.c cVar = (com.baidu.tieba.card.data.c) item;
                    if (cVar.aPS() != null && cVar.aPS().getTid().equals(str)) {
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
    public void h(String str, List<q> list) {
        AdvertAppInfo advertAppInfo;
        if (list != null && list.size() > 0 && !TextUtils.isEmpty(str)) {
            Iterator<q> it = list.iterator();
            AdvertAppInfo advertAppInfo2 = null;
            while (it.hasNext()) {
                q next = it.next();
                if (next instanceof com.baidu.tieba.homepage.personalize.data.a) {
                    advertAppInfo = ((com.baidu.tieba.homepage.personalize.data.a) next).bOT();
                } else {
                    if (next instanceof ai) {
                        ai aiVar = (ai) next;
                        if (aiVar.aQG() instanceof AdvertAppInfo.ILegoAdvert) {
                            advertAppInfo = ((AdvertAppInfo.ILegoAdvert) aiVar.aQG()).getAdvertAppInfo();
                        }
                    }
                    advertAppInfo = advertAppInfo2;
                }
                if (advertAppInfo != null && str.equals(advertAppInfo.dGL)) {
                    it.remove();
                    advertAppInfo = null;
                }
                advertAppInfo2 = advertAppInfo;
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (this.hji != null) {
            this.hji.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ak cjf() {
        if (this.hjm == null || this.hjm.cVl() == null || !(this.hjm.cVl().getTag() instanceof ak)) {
            return null;
        }
        return (ak) this.hjm.cVl().getTag();
    }
}
