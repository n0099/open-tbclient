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
    private aw gWs;
    private SmartBubbleAnimatedView gWt;
    private m gWx;
    private com.baidu.tieba.f.a hMQ;
    private boolean hVS;
    private final BigdaySwipeRefreshLayout hXJ;
    private com.baidu.tieba.tbadkCore.data.f hnp;
    private final BdTypeRecyclerView hrX;
    private ScrollFragmentTabHost icj;
    private final ab icv;
    private Runnable idE;
    private final long idd;
    private final b ide;
    private DataRes.Builder idg;
    private final com.baidu.tieba.homepage.personalize.model.a idj;
    private int idn;
    private g idp;
    private BdUniqueId idu;
    private int idv;
    private final TbPageContext<?> mPageContext;
    private a idf = null;
    private final List<o> mDataList = new LinkedList();
    private int mPn = 1;
    private boolean mIsLoading = false;
    private boolean hXR = false;
    private int idh = 2;
    private int idi = 0;
    private TextView mTipView = null;
    private int hrI = 2000;
    private com.baidu.tbadk.n.c idk = null;
    private boolean hpK = false;
    private int hpb = 0;
    private int faR = 0;
    private boolean mIsBackground = false;
    private boolean ice = true;
    private boolean idm = false;
    private boolean ido = false;
    private boolean idq = true;
    private FloatInfo idr = null;
    private BdUniqueId idw = BdUniqueId.gen();
    private a.C0097a hnH = new a.C0097a(2);
    private ThreadInfo idy = null;
    private RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.e.12
        private int idN = -1;
        private int hXZ = 0;
        private boolean idO = false;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (e.this.idk == null) {
                e.this.idk = new com.baidu.tbadk.n.c();
                e.this.idk.setSubType(1005);
                e.this.idk.pageType = 1;
            }
            if (e.this.evv != null && !e.this.mIsBackground) {
                e.this.evv.j(recyclerView, i);
            }
            if (i == 0) {
                c.d(e.this.hrX);
                e.this.idk.bfA();
                s.bLs().jv(true);
                com.baidu.tieba.a.d.bmb().de("page_recommend", "show_");
                com.baidu.tieba.s.c.dcI().b(e.this.idu, false);
                this.idO = false;
                if (e.this.gWx != null && e.this.ice && !e.this.mIsBackground) {
                    e.this.gWx.a(e.this.hpb, e.this.faR, e.this.hpK, 1);
                    return;
                }
                return;
            }
            e.this.idk.bfz();
            if (i == 1) {
                if (e.this.gWs != null) {
                    e.this.gWs.hideTip();
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
            if (this.hXZ > i) {
                this.idO = true;
            }
            if (e.this.evv != null && !e.this.mIsBackground) {
                e.this.evv.onScroll(this.hXZ, i);
            }
            this.hXZ = i;
            int i3 = (i + i2) - 1;
            if (!this.idO && this.idN != i3) {
                this.idN = i3;
                e.this.wE(this.idN);
            }
            if (this.idO && this.idN != i) {
                this.idN = i;
                e.this.wE(this.idN);
            }
            e.this.idD = i;
            e.this.hpb = i;
            e.this.faR = (i + i2) - 1;
            ag cfJ = e.this.cfJ();
            if (cfJ != null && cfJ.rM() != null) {
                cfJ.rM().b(e.this.hnH);
            }
        }
    };
    private View.OnTouchListener evw = new View.OnTouchListener() { // from class: com.baidu.tieba.homepage.personalize.e.23
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (e.this.eiB != null) {
                e.this.eiB.onTouch(view, motionEvent);
            }
            if (e.this.hMQ != null) {
                e.this.hMQ.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private a.InterfaceC0607a gMe = new a.InterfaceC0607a() { // from class: com.baidu.tieba.homepage.personalize.e.25
        @Override // com.baidu.tieba.f.a.InterfaceC0607a
        public void B(int i, int i2) {
            e.this.hpK = false;
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0607a
        public void C(int i, int i2) {
            e.this.hpK = true;
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0607a
        public void bK(int i, int i2) {
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0607a
        public void D(int i, int i2) {
        }
    };
    private View.OnClickListener idz = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.e.26
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (e.this.gWs != null) {
                e.this.gWs.hideTip();
            }
        }
    };
    private final CustomMessageListener idA = new CustomMessageListener(CmdConfigCustom.CMD_RELOAD_HP_PERSONALIZED) { // from class: com.baidu.tieba.homepage.personalize.e.27
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (e.this.hrX != null) {
                e.this.gWx.cfI();
                e.this.ice = false;
                e.this.hXJ.setRefreshing(true);
            }
        }
    };
    private CustomMessageListener hFx = new CustomMessageListener(CmdConfigCustom.PB_ACTION_PRAISE) { // from class: com.baidu.tieba.homepage.personalize.e.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            bk bkVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bk) && e.this.idg != null && v.getCount(e.this.idg.thread_list) != 0 && (bkVar = (bk) customResponsedMessage.getData()) != null && bkVar.aQi() != null && bkVar.getId() != null && v.getCount(e.this.idg.thread_list) != 0) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < e.this.idg.thread_list.size()) {
                        ThreadInfo threadInfo = e.this.idg.thread_list.get(i2);
                        if (threadInfo == null || threadInfo.id.longValue() != com.baidu.adp.lib.f.b.toLong(bkVar.getId(), -1L)) {
                            i = i2 + 1;
                        } else {
                            ThreadInfo.Builder builder = new ThreadInfo.Builder(threadInfo);
                            Zan.Builder builder2 = new Zan.Builder(builder.zan);
                            builder2.num = Integer.valueOf((int) bkVar.aQi().getNum());
                            builder.zan = builder2.build(true);
                            e.this.idg.thread_list.set(i2, builder.build(true));
                            return;
                        }
                    } else {
                        return;
                    }
                }
            }
        }
    };
    private CustomMessageListener idB = new CustomMessageListener(CmdConfigCustom.CMD_LIVE_VIDEO_CLOSED_QUERY_RESPONSED) { // from class: com.baidu.tieba.homepage.personalize.e.6
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
                    if (e.this.icv != null) {
                        e.this.icv.bE(new ArrayList(e.this.mDataList));
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
            if ((customResponsedMessage instanceof UpdateAttentionMessage) && e.this.idg != null && !v.isEmpty(e.this.idg.thread_list)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid)) {
                    int i = 0;
                    while (true) {
                        if (i >= e.this.idg.thread_list.size()) {
                            break;
                        }
                        ThreadInfo threadInfo = e.this.idg.thread_list.get(i);
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
                            e.this.idg.thread_list.set(i, builder.build(true));
                        }
                    }
                    e.this.a(updateAttentionMessage);
                }
            }
        }
    };
    private String idC = "lastReadReadPositionKey";
    private int idD = 0;
    private d idF = new d() { // from class: com.baidu.tieba.homepage.personalize.e.11
        @Override // com.baidu.tieba.homepage.personalize.d
        public void wn(final int i) {
            if (e.this.idE == null) {
                e.this.idE = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.e.11.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (e.this.hrX.getHandler() != null) {
                            e.this.hrX.requestFocusFromTouch();
                            if (i <= e.this.hrX.getCount() - 1) {
                                e.this.hrX.setSelection(i);
                            }
                        }
                    }
                };
            }
            e.this.hrX.removeCallbacks(e.this.idE);
            e.this.hrX.post(e.this.idE);
        }
    };
    private CustomMessageListener idG = new CustomMessageListener(2016569) { // from class: com.baidu.tieba.homepage.personalize.e.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && e.this.idp != null) {
                e.this.mDataList.remove(e.this.idp);
                e.this.icv.bE(new ArrayList(e.this.mDataList));
                com.baidu.tbadk.core.sharedPref.b.aTX().putLong("key_maintab_banner_close_time", System.currentTimeMillis());
            }
        }
    };
    private CustomMessageListener gWm = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.homepage.personalize.e.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.g(customResponsedMessage);
            if (e.this.gWx != null && e.this.ice) {
                e.this.gWx.a(e.this.hpb, e.this.faR, e.this.hpK, true);
            }
        }
    };
    private CustomMessageListener gWn = new CustomMessageListener(CmdConfigCustom.CMD_THREAD_NOT_EXIST_WHEN_ENTER_PB) { // from class: com.baidu.tieba.homepage.personalize.e.17
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.g(customResponsedMessage);
        }
    };
    private CustomMessageListener hFL = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.homepage.personalize.e.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && e.this.idg != null && v.getCount(e.this.idg.thread_list) != 0) {
                String str = (String) customResponsedMessage.getData();
                e.this.h(str, e.this.mDataList);
                e.this.FE(str);
                if (e.this.icv != null) {
                    e.this.icv.bE(new ArrayList(e.this.mDataList));
                }
                if (e.this.gWx != null && e.this.ice) {
                    e.this.gWx.a(e.this.hpb, e.this.faR, e.this.hpK, true);
                }
            }
        }
    };
    private CustomMessageListener hoS = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.homepage.personalize.e.19
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ag cfJ;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent)) {
                KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24 && (cfJ = e.this.cfJ()) != null && cfJ.rM() != null) {
                    cfJ.rM().b(new a.C0097a(3));
                }
            }
        }
    };
    private com.baidu.adp.framework.listener.a idH = new com.baidu.adp.framework.listener.a(1003065, CmdConfigSocket.CMD_TOPIC_BLESS) { // from class: com.baidu.tieba.homepage.personalize.e.20
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
                        if ((oVar instanceof com.baidu.tieba.homepage.topic.topictab.b.a) && (bVar = ((com.baidu.tieba.homepage.topic.topictab.b.a) oVar).iix) != null && longValue == bVar.pkId) {
                            bVar.userPkId = j2;
                            return;
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener hoT = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.homepage.personalize.e.21
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int[] imageWidthAndHeight;
            List<o> dataList = e.this.icv.getDataList();
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
                    e.this.icv.notifyDataSetChanged();
                    if (!e.this.mIsBackground && e.this.ice) {
                        e.this.gWx.a(e.this.hpb, e.this.faR, e.this.hpK, true);
                    }
                }
            }, 500L);
        }
    };
    private CustomMessageListener gWo = new CustomMessageListener(2921453) { // from class: com.baidu.tieba.homepage.personalize.e.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof ax)) {
                ax axVar = (ax) customResponsedMessage.getData();
                if (axVar.dDN == 1) {
                    int equipmentWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst());
                    int equipmentHeight = l.getEquipmentHeight(TbadkCoreApplication.getInst());
                    float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
                    int i = ar.aUX().aUY() ? 2 : 1;
                    RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
                    requestGetMyPostNetMessage.setTag(e.this.idw);
                    requestGetMyPostNetMessage.setParams(com.baidu.adp.lib.f.b.toLong(axVar.tid, 0L), 0L, 0L, equipmentWidth, equipmentHeight, f, i);
                    requestGetMyPostNetMessage.setBFrom("push");
                    MessageManager.getInstance().sendMessage(requestGetMyPostNetMessage);
                }
            }
        }
    };
    private final com.baidu.adp.framework.listener.a gWp = new com.baidu.adp.framework.listener.a(1003010, CmdConfigSocket.CMD_GET_MY_POST) { // from class: com.baidu.tieba.homepage.personalize.e.24
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            GetMyPostResIdl getMyPostResIdl = null;
            if (responsedMessage instanceof GetMyPostHttpResponseMessage) {
                getMyPostResIdl = ((GetMyPostHttpResponseMessage) responsedMessage).getResponseData();
            } else if (responsedMessage instanceof GetMyPostSocketResponseMessage) {
                getMyPostResIdl = ((GetMyPostSocketResponseMessage) responsedMessage).getResponseData();
            }
            if (getMyPostResIdl != null && getMyPostResIdl.data != null && getMyPostResIdl.data.thread_info != null) {
                e.this.idy = getMyPostResIdl.data.thread_info;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921455));
            }
        }
    };

    /* loaded from: classes9.dex */
    public interface a {
        void A(int i, int i2, int i3, int i4);

        void Q(int i, int i2, int i3);

        void cfZ();

        void onError(int i, String str);

        void onSuccess();
    }

    public void on(boolean z) {
        this.idq = z;
        if (this.gWs != null && !z) {
            this.gWs.hideTip();
        }
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.icj = scrollFragmentTabHost;
        if (this.icj != null) {
            this.icj.setOnTabSelectedListener(new ScrollFragmentTabHost.b() { // from class: com.baidu.tieba.homepage.personalize.e.1
                @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.b
                public void wx(int i) {
                    if (e.this.icj.ww(i) != 1 && e.this.gWs != null) {
                        e.this.gWs.hideTip();
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
        if (this.icj != null) {
            this.icj.mX(z);
        }
        if (this.gWx != null) {
            this.gWx.qi(!z);
            ag cfJ = cfJ();
            if (cfJ != null && cfJ.rM() != null) {
                z2 = cfJ.rM().b(new a.C0097a(8, Boolean.valueOf(z)));
            }
            if (!z2) {
                if (z) {
                    this.gWx.cfI();
                } else if (this.ice) {
                    this.gWx.a(this.hpb, this.faR, this.hpK, true);
                }
            }
        }
    }

    public e(TbPageContext<?> tbPageContext, BdTypeRecyclerView bdTypeRecyclerView, ab abVar, BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout) {
        this.idv = 0;
        this.mPageContext = tbPageContext;
        this.idv = com.baidu.tbadk.core.sharedPref.b.aTX().getInt("key_personalized_refresh_type", 0);
        this.hXJ = bigdaySwipeRefreshLayout;
        this.hrX = bdTypeRecyclerView;
        this.hrX.setOnTouchListener(this.evw);
        this.hMQ = new com.baidu.tieba.f.a();
        this.hMQ.a(this.gMe);
        this.icv = abVar;
        this.idj = new com.baidu.tieba.homepage.personalize.model.a();
        this.idd = com.baidu.tbadk.core.sharedPref.b.aTX().getLong("recommend_frs_cache_time", 1800L) * 1000;
        bdTypeRecyclerView.setOnScrollListener(this.mOnScrollListener);
        this.gWs = new aw();
        cgj();
        this.gWx = new m(this.mPageContext, this.hrX);
        this.gWx.BL(1);
        this.gWx.BK(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.ide = new b(this.mDataList, this.icv);
        this.gWt = new SmartBubbleAnimatedView(tbPageContext.getContext());
        this.gWt.setLayoutParams(new FrameLayout.LayoutParams(-1, l.getDimens(tbPageContext.getContext(), R.dimen.tbds83)));
        cga();
        this.hoT.setTag(this.mPageContext.getUniqueId());
        MessageManager.getInstance().registerListener(this.hoT);
        if (MessageManager.getInstance().findTask(1003010) == null) {
            HomePageStatic.ces();
        }
        this.gWp.setTag(this.idw);
        if (this.gWp.getHttpMessageListener() != null) {
            this.gWp.getHttpMessageListener().setSelfListener(true);
        }
        if (this.gWp.getSocketMessageListener() != null) {
            this.gWp.getSocketMessageListener().setSelfListener(true);
        }
        MessageManager.getInstance().registerListener(this.gWp);
        MessageManager.getInstance().registerListener(this.gWo);
    }

    private void cga() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2016323, new CustomMessageTask.CustomRunnable<Boolean>() { // from class: com.baidu.tieba.homepage.personalize.e.28
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Boolean> customMessage) {
                ag cfJ = e.this.cfJ();
                return (cfJ == null || cfJ.rM() == null) ? new CustomResponsedMessage<>(2016323, false) : new CustomResponsedMessage<>(2016323, Boolean.valueOf(cfJ.rM().b(new a.C0097a(6))));
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private boolean cgb() {
        return com.baidu.tbadk.core.sharedPref.b.aTX().getBoolean(cgd(), true);
    }

    private void cgc() {
        com.baidu.tbadk.core.sharedPref.b.aTX().putBoolean(cgd(), false);
    }

    private String cgd() {
        return "key_rec_pfirst_load_" + TbadkCoreApplication.getCurrentAccount() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + TbConfig.getVersion();
    }

    public void setRecommendFrsNavigationAnimDispatcher(aa aaVar) {
        if (aaVar != null) {
            this.evv = aaVar.bgM();
            this.eiB = aaVar.bgN();
        }
    }

    public void showFloatingView() {
        if (this.evv != null) {
            this.evv.iz(true);
        }
    }

    public void update() {
        com.baidu.tieba.homepage.framework.a.ceK().q(System.currentTimeMillis(), 1);
        this.mPn = 1;
        this.ido = true;
        if (this.mDataList.size() == 0 && !cgb()) {
            if (!this.hXR) {
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

    public void cge() {
        if (this.gWx != null && !this.mIsBackground && this.ice) {
            this.gWx.a(this.hpb, this.faR, this.hpK, true);
        }
        if (this.idm) {
            if (this.hXJ != null && !this.hXJ.aWw()) {
                if (this.hVS) {
                    com.baidu.tieba.s.c.dcI().b(this.idu, false);
                    if (op(false)) {
                        ch(3, this.idi);
                    } else if (this.idn > 0) {
                        ch(2, this.idi);
                    }
                } else if (!this.hVS && this.idi == 0) {
                    ch(2, 0);
                }
            }
            this.idm = false;
            this.hVS = false;
            this.idn = 0;
            if (this.ido) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
            }
            this.ido = false;
        }
    }

    public void bqx() {
        if (isLoading()) {
            com.baidu.tieba.homepage.framework.a.ceK().q(0L, 1);
        } else if (this.idf != null) {
            cgg();
            this.mPn++;
            setIsLoading(true);
            this.idf.A(this.mPn, (this.idg == null || this.idg.thread_list == null) ? 0 : this.idg.thread_list.size(), oo(false), 0);
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
        if (this.idj != null && this.idj.cgH() && !z && (dataRes == null || v.isEmpty(dataRes.thread_list))) {
            if (dataRes == null) {
                DataRes.Builder builder = new DataRes.Builder();
                builder.thread_list = new ArrayList();
                dataRes = builder.build(false);
            }
            if (dataRes.thread_list != null) {
                List<ThreadInfo> cgI = this.idj.cgI();
                dataRes.thread_list.addAll(cgI);
                if (cgI != null) {
                    cgI.clear();
                }
                z3 = true;
                size = (this.idg != null || this.idg.thread_list == null) ? 0 : this.idg.thread_list.size();
                if (z && i == 0 && dataRes != null && v.isEmpty(dataRes.thread_list)) {
                    if (this.idf != null) {
                        this.idf.cfZ();
                    }
                    setIsLoading(false);
                    if (this.hXJ != null) {
                        this.hXJ.setRefreshing(false);
                        return;
                    }
                    return;
                }
                if (this.idy != null) {
                    DataRes.Builder builder2 = new DataRes.Builder(dataRes);
                    builder2.thread_list.add(0, this.idy);
                    dataRes = builder2.build(false);
                    if (this.idg != null && !v.isEmpty(this.idg.thread_list)) {
                        Iterator<ThreadInfo> it = this.idg.thread_list.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            ThreadInfo next = it.next();
                            if (next != null && next.tid != null && this.idy.tid != null && next.tid.longValue() == this.idy.tid.longValue()) {
                                this.idg.thread_list.remove(next);
                                break;
                            }
                        }
                    }
                    this.idy = null;
                }
                if ((z3 && i != 0) || dataRes == null || !a(true, z, z2, dataRes)) {
                    this.idm = false;
                    if (this.mDataList.size() > 0) {
                        if (this.idf != null) {
                            this.idf.onError(1, str);
                        }
                    } else if (this.idf != null) {
                        this.idf.onError(2, str);
                    }
                } else {
                    cgc();
                    if (this.idf != null) {
                        com.baidu.tbadk.core.sharedPref.b.aTX().putLong(SharedPrefConfig.RECOMMEND_FRS_REFRESH_TIME + TbadkCoreApplication.getCurrentAccount(), System.currentTimeMillis());
                        this.idf.onSuccess();
                    }
                    this.idm = true;
                    this.hVS = z;
                    this.idn = size;
                    bPg();
                }
                setIsLoading(false);
                if (this.hXJ == null) {
                    f.e cgf = cgf();
                    if (this.hXJ.aWw() && cgf != null) {
                        this.hXJ.c(cgf);
                        return;
                    } else {
                        this.hXJ.setRefreshing(false);
                        return;
                    }
                }
                return;
            }
        }
        z3 = false;
        if (this.idg != null) {
        }
        if (z) {
        }
        if (this.idy != null) {
        }
        if (z3) {
        }
        cgc();
        if (this.idf != null) {
        }
        this.idm = true;
        this.hVS = z;
        this.idn = size;
        bPg();
        setIsLoading(false);
        if (this.hXJ == null) {
        }
    }

    private f.e cgf() {
        int i;
        String feedText;
        if (this.idm && this.hXJ != null && this.hXJ.aWw()) {
            int i2 = this.idi;
            if (this.hVS) {
                com.baidu.tieba.s.c.dcI().b(this.idu, false);
                if (op(false)) {
                    i = 3;
                } else {
                    i = this.idn > 0 ? 2 : 0;
                }
            } else if (this.hVS || this.idi != 0) {
                return null;
            } else {
                i2 = 0;
                i = 2;
            }
            if (this.icj != null) {
                this.gWs.bXd();
            }
            if (this.icj != null && this.icj.getCurrentTabType() != 1) {
                this.gWs.hideTip();
                return null;
            } else if (!this.idq) {
                this.gWs.hideTip();
                return null;
            } else {
                this.idh = i;
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
                    this.hrI = 1000;
                } else {
                    this.hrI = 0;
                }
                return new f.e(feedText, this.hrI);
            }
        }
        return null;
    }

    public void oc(boolean z) {
        if (z) {
            this.icv.notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        if (this.gWx != null) {
            this.gWx.destroy();
        }
        if (this.gWs != null) {
            this.gWs.onDestroy();
        }
        if (this.ide != null) {
            this.ide.onDestroy();
        }
        if (this.hrX != null) {
            this.hrX.removeCallbacks(this.idE);
        }
        MessageManager.getInstance().unRegisterTask(2016323);
        MessageManager.getInstance().unRegisterListener(this.hoT);
        MessageManager.getInstance().unRegisterListener(this.gWo);
        MessageManager.getInstance().unRegisterListener(this.gWp);
    }

    public void onPause() {
        c.d(this.hrX);
        wF(this.idD);
        if (this.idk != null) {
            this.idk.bfB();
        }
    }

    private void aNZ() {
        if (this.idf != null) {
            this.idf.Q((this.idg == null || this.idg.thread_list == null || cgi()) ? 0 : this.idg.thread_list.size(), oo(true), 0);
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
        this.hXR = true;
        if (dataRes != null) {
            if (a(false, true, true, dataRes) && !cgi()) {
                if (this.idf != null) {
                    this.idf.onSuccess();
                    Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler() { // from class: com.baidu.tieba.homepage.personalize.e.29
                        @Override // android.os.MessageQueue.IdleHandler
                        public boolean queueIdle() {
                            e.this.bfG();
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

    public void bfG() {
        long wl = com.baidu.tieba.homepage.framework.a.ceK().wl(1) + com.baidu.tieba.homepage.framework.a.ceK().getCreateTime();
        long wj = com.baidu.tieba.homepage.framework.a.ceK().wj(1);
        if (wj > 0) {
            wl = System.currentTimeMillis() - wj;
        }
        n.bfO().cS(wl);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.util.Set] */
    private void j(List<o> list, int i) {
        AdvertAppInfo bLJ;
        AdvertAppInfo bLJ2;
        if (!v.isEmpty(list)) {
            Set<o> Lu = com.baidu.tieba.recapp.report.a.Lu("NEWINDEX");
            HashSet hashSet = Lu == null ? new HashSet() : Lu;
            HashSet hashSet2 = new HashSet();
            for (o oVar : list) {
                if (oVar != null) {
                    for (o oVar2 : hashSet) {
                        if ((oVar instanceof com.baidu.tieba.card.data.d) && (bLJ2 = ((com.baidu.tieba.card.data.d) oVar).bLJ()) != null && oVar2 != null && (oVar2 instanceof AdvertAppInfo) && oVar2.hashCode() == bLJ2.hashCode()) {
                            bLJ2.advertAppContext = ((AdvertAppInfo) oVar2).advertAppContext;
                        }
                    }
                    if (oVar != null && (oVar instanceof com.baidu.tieba.card.data.d) && (bLJ = ((com.baidu.tieba.card.data.d) oVar).bLJ()) != null && bLJ.advertAppContext == null) {
                        bLJ.advertAppContext = new com.baidu.tbadk.core.data.b();
                        bLJ.advertAppContext.page = "NEWINDEX";
                        bLJ.advertAppContext.pn = this.mPn;
                        bLJ.advertAppContext.extensionInfo = bLJ.extensionInfo;
                        bLJ.advertAppContext.WZ = false;
                        hashSet2.add(bLJ);
                    }
                }
            }
            hashSet.addAll(hashSet2);
            com.baidu.tieba.recapp.report.a.b("NEWINDEX", hashSet);
            if (hashSet2.size() > 0) {
                com.baidu.tieba.s.c.dcI().b(this.idu, com.baidu.tieba.s.a.b(PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE, "common_fill", true, hashSet2.size()));
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
        if (this.idv == 1) {
            if (z2 && (dataRes.thread_list.size() >= 6 || cgi())) {
                cgh();
                this.idg = null;
            }
        } else if (z2 && cgi()) {
            this.idg = null;
        }
        int size = z2 ? 0 : this.mDataList.size();
        DataRes.Builder builder = new DataRes.Builder(dataRes);
        this.mDataList.clear();
        com.baidu.tieba.homepage.personalize.model.c a2 = this.idj.a(z, this.idg, builder, z2 ? 0 : 1);
        if (a2 == null) {
            list = null;
            i = 0;
        } else {
            List<o> list2 = a2.eIv;
            this.idi = a2.ifZ;
            int i2 = a2.iga;
            a2.iga = 0;
            list = list2;
            i = i2;
        }
        if (list != null) {
            this.mDataList.addAll(list);
            j(list, size);
            a(z2 ? 0 : 1, list, size);
            if (this.ido) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
            }
        }
        if (this.idg == null) {
            this.idg = builder;
            this.ide.cL(this.idg.thread_list);
        }
        if (this.mDataList.size() == 0) {
            z4 = false;
        } else {
            if (z2) {
                if (dataRes.live_answer != null) {
                    this.idp = new g();
                    this.idp.a(dataRes.live_answer);
                    this.idg.live_answer = dataRes.live_answer;
                } else if (z) {
                    this.idp = null;
                    this.idg.live_answer = null;
                }
                this.idr = dataRes.float_info;
                this.idg.float_info = dataRes.float_info;
            }
            long j = com.baidu.tbadk.core.sharedPref.b.aTX().getLong("key_maintab_banner_close_time", 0L);
            if (this.idp != null && !aq.isTaday(j)) {
                this.mDataList.add(0, this.idp);
            }
            LinkedList linkedList = new LinkedList(this.mDataList);
            this.icv.setFromCDN(dataRes.is_new_url != null && dataRes.is_new_url.intValue() == 1);
            this.icv.k(linkedList, i);
            z4 = true;
            if (this.gWx != null && this.ice) {
                this.gWx.a(this.hpb, this.faR, this.hpK, true);
            }
        }
        com.baidu.tieba.homepage.framework.a.ceK().o(System.currentTimeMillis() - currentTimeMillis, 1);
        long wm = com.baidu.tieba.homepage.framework.a.ceK().wm(1);
        if (wm > 0) {
            com.baidu.tieba.homepage.framework.a.ceK().p(System.currentTimeMillis() - wm, 1);
            com.baidu.tieba.homepage.framework.a.ceK().q(0L, 1);
        }
        if (dataRes.anti != null && dataRes.anti.block_pop_info != null) {
            com.baidu.tieba.ueg.d.d(dataRes.anti.block_pop_info);
        }
        az azVar = new az();
        azVar.a(dataRes.recom_post_topic);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_REFRESH_TOPIC_TIP, azVar));
        return z4;
    }

    private void cgg() {
        List<o> list;
        int i;
        if (v.getCount(this.mDataList) >= this.idj.cgE() - 40) {
            com.baidu.tieba.homepage.personalize.model.c a2 = this.idj.a(true, this.idg, null, 1);
            if (a2 != null) {
                List<o> list2 = a2.eIv;
                i = a2.iga;
                a2.iga = 0;
                list = list2;
            } else {
                list = null;
                i = 0;
            }
            if (list != null) {
                this.mDataList.clear();
                this.mDataList.addAll(list);
                this.icv.k(new LinkedList(this.mDataList), i);
            }
        }
    }

    private void aOa() {
        this.hXR = true;
        ad.a(new ac<DataRes>() { // from class: com.baidu.tieba.homepage.personalize.e.30
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.ac
            /* renamed from: cgn */
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

    private void bPg() {
        if (this.idg != null) {
            DataRes.Builder builder = new DataRes.Builder(this.idg.build(true));
            if (builder.thread_list != null && builder.thread_list.size() > 30) {
                builder.thread_list = builder.thread_list.subList(0, 30);
            }
            a(builder, builder.thread_list != null ? builder.thread_list.size() : 0);
            a(builder);
            b(builder);
        }
    }

    private void cgh() {
        if (this.idg != null) {
            final DataRes.Builder builder = new DataRes.Builder(this.idg.build(true));
            if (builder.thread_list != null && builder.thread_list.size() > 50) {
                builder.thread_list = builder.thread_list.subList(0, 50);
            }
            a(builder, builder.thread_list != null ? builder.thread_list.size() : 0);
            ad.a(new ac<Object>() { // from class: com.baidu.tieba.homepage.personalize.e.3
                @Override // com.baidu.tbadk.util.ac
                public Object doInBackground() {
                    DataRes.Builder builder2 = new DataRes.Builder(builder.build(true));
                    e.this.ide.cM(builder2.thread_list);
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
        if (!TextUtils.isEmpty(str) && this.idg != null && this.idg.banner_list != null && this.idg.banner_list.app != null && this.idg.banner_list.app.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (App app : this.idg.banner_list.app) {
                if (app != null && str.equals(app.id)) {
                    arrayList.add(app);
                }
            }
            BannerList.Builder builder = new BannerList.Builder(this.idg.banner_list);
            if (builder.app != null) {
                builder.app.removeAll(arrayList);
            }
            this.idg.banner_list = builder.build(false);
            DataRes.Builder builder2 = new DataRes.Builder(this.idg.build(true));
            builder2.banner_list = builder.build(true);
            b(builder2);
        }
    }

    private void b(final DataRes.Builder builder) {
        ad.a(new ac<Object>() { // from class: com.baidu.tieba.homepage.personalize.e.4
            @Override // com.baidu.tbadk.util.ac
            public Object doInBackground() {
                DataRes.Builder builder2 = new DataRes.Builder(builder.build(true));
                e.this.ide.cM(builder2.thread_list);
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

    private boolean cgi() {
        return op(true);
    }

    private boolean op(boolean z) {
        long j = com.baidu.tbadk.core.sharedPref.b.aTX().getLong(SharedPrefConfig.RECOMMEND_FRS_REFRESH_TIME + TbadkCoreApplication.getCurrentAccount(), 0L);
        return j == 0 ? z : Math.abs(System.currentTimeMillis() - j) > this.idd;
    }

    public void a(a aVar) {
        this.idf = aVar;
    }

    private boolean isLoading() {
        return this.mIsLoading;
    }

    private void setIsLoading(boolean z) {
        this.mIsLoading = z;
    }

    public void cfW() {
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
        if (this.icj != null) {
            this.gWs.bXd();
        }
        if (this.icj != null && this.icj.getCurrentTabType() != 1) {
            this.gWs.hideTip();
        } else if (!this.idq) {
            this.gWs.hideTip();
        } else {
            this.idh = i;
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
                    this.hrI = 3000;
                } else {
                    this.hrI = 2000;
                }
                this.gWt.dVI = str;
                this.gWt.hrB = this.hrI;
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 49;
                if (this.icj != null) {
                    FrameLayout frameLayout = this.icj.getFrameLayout();
                    frameLayout.removeView(this.gWt);
                    frameLayout.addView(this.gWt, layoutParams);
                    this.gWt.bXb();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(Long l) {
        if (this.idg != null && this.idg.thread_list != null) {
            List<ThreadInfo> list = this.idg.thread_list;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                ThreadInfo threadInfo = list.get(i);
                if (threadInfo.tid.equals(l) && threadInfo.top_agree_post != null) {
                    ThreadInfo.Builder builder = new ThreadInfo.Builder(threadInfo);
                    builder.top_agree_post = null;
                    list.set(i, builder.build(true));
                    bPg();
                    a(false, true, false, this.idg.build(true));
                    return;
                }
            }
        }
    }

    public void o(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.idu = bdUniqueId;
            if (this.hFx != null) {
                this.hFx.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.hFx);
            }
            if (this.idA != null) {
                this.idA.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.idA);
            }
            this.dNP.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.dNP);
            this.idB.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.idB);
            this.gWm.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.gWm);
            this.gWn.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.gWn);
            this.hFL.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.hFL);
            if (this.gWx != null) {
                this.gWx.setUniqueId(bdUniqueId);
            }
            this.ide.l(bdUniqueId);
            this.idG.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.idG);
            this.hoS.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.hoS);
            this.idH.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.idH);
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
                        e.this.ide.cM(builder5.thread_list);
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

    public void cgj() {
        this.hnp = new com.baidu.tieba.tbadkCore.data.f("new_index", null);
        this.hnp.ddp();
    }

    public void a(int i, List<o> list, int i2) {
        int i3;
        int i4;
        if (this.hnp != null) {
            if (i == 0) {
                this.hnp.ddp();
            }
            if (list != null && !list.isEmpty()) {
                int[] iArr = com.baidu.tieba.tbadkCore.data.f.lls;
                int i5 = 0;
                int i6 = 0;
                int i7 = 0;
                while (i7 < list.size() && i6 < iArr.length && (i3 = iArr[i6]) >= 0) {
                    if (list.get(i7) instanceof com.baidu.tieba.card.data.c) {
                        i4 = i5 + 1;
                        if (i4 == i3 - 1) {
                            if (i2 < i7 + 1) {
                                this.hnp.cU(i3, i7 + 1);
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

    public void wE(int i) {
        if ((this.hnp != null ? this.hnp.DR(i) : -1) >= 0 && this.hrX != null && this.hrX.getData() != null && this.hrX.getData().size() > i) {
            this.hnp.DS(i);
        }
    }

    public m bVS() {
        return this.gWx;
    }

    public void oj(boolean z) {
        this.ice = z;
    }

    public void wF(final int i) {
        ad.a(new ac<Object>() { // from class: com.baidu.tieba.homepage.personalize.e.10
            @Override // com.baidu.tbadk.util.ac
            public Object doInBackground() {
                com.baidu.adp.lib.cache.l<String> da = com.baidu.tbadk.core.c.a.aSS().da(e.this.idC, TbadkCoreApplication.getCurrentAccount());
                if (da != null) {
                    da.set(e.this.idC, Integer.toString(i), 43200000L);
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
            /* renamed from: cgm */
            public String doInBackground() {
                com.baidu.adp.lib.cache.l<String> da = com.baidu.tbadk.core.c.a.aSS().da(e.this.idC, TbadkCoreApplication.getCurrentAccount());
                if (da != null) {
                    return da.get(e.this.idC);
                }
                return null;
            }
        }, new com.baidu.tbadk.util.l<String>() { // from class: com.baidu.tieba.homepage.personalize.e.14
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.l
            /* renamed from: FF */
            public void onReturnDataInUI(String str) {
                if (dVar != null) {
                    dVar.wn(com.baidu.adp.lib.f.b.toInt(str, 0));
                }
            }
        });
    }

    public void cfX() {
        c.e(this.hrX);
    }

    public void cgk() {
        a(this.idF);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(CustomResponsedMessage<?> customResponsedMessage) {
        boolean z;
        String str;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.idg != null && v.getCount(this.idg.thread_list) != 0 && v.getCount(this.mDataList) != 0) {
            JSONObject jSONObject = (JSONObject) customResponsedMessage.getData();
            String optString = jSONObject.optString("tid");
            if (StringUtils.isNull(optString)) {
                String optString2 = jSONObject.optString(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_ID);
                if (this.hrX != null && !TextUtils.isEmpty(optString2)) {
                    int i = 0;
                    while (true) {
                        if (i >= this.hrX.getCount()) {
                            str = optString;
                            break;
                        }
                        o item = this.hrX.getItem(i);
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
                            com.baidu.tieba.homepage.personalize.model.b.cO(this.mDataList);
                            break;
                        }
                    }
                }
                z = z2;
                z2 = z;
            }
            if (this.idg != null && this.idg.thread_list != null) {
                long j = com.baidu.adp.lib.f.b.toLong(optString, 0L);
                int i2 = 0;
                while (true) {
                    if (i2 < this.idg.thread_list.size()) {
                        ThreadInfo threadInfo = this.idg.thread_list.get(i2);
                        if (threadInfo == null || threadInfo.tid == null || threadInfo.tid.longValue() != j) {
                            i2++;
                        } else {
                            com.baidu.tieba.homepage.personalize.b.d.a(threadInfo.tid.longValue(), i2, this.idg.thread_list, this.mDataList);
                            this.idg.thread_list.remove(i2);
                            bPg();
                            break;
                        }
                    } else {
                        break;
                    }
                }
                if (this.hrX != null) {
                    List<Integer> b = b(optString, this.hrX);
                    int intValue = b.get(0).intValue();
                    int intValue2 = b.get(1).intValue();
                    if (intValue != -1 && intValue2 != -1) {
                        this.hrX.l(intValue, intValue2);
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
                    advertAppInfo = ((com.baidu.tieba.homepage.personalize.data.a) next).bLJ();
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
        if (this.gWt != null) {
            this.gWt.onChangeSkinType(i);
        }
    }

    public FloatInfo cgl() {
        return this.idr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ag cfJ() {
        if (this.gWx == null || this.gWx.cQU() == null || !(this.gWx.cQU().getTag() instanceof ag)) {
            return null;
        }
        return (ag) this.gWx.cQU().getTag();
    }
}
