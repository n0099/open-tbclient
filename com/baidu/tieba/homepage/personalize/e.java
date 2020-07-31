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
import com.baidu.tbadk.core.data.aj;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.data.bf;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.x;
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
import com.baidu.tieba.play.i;
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
/* loaded from: classes16.dex */
public class e {
    private z eKX;
    private View.OnTouchListener exE;
    private com.baidu.tieba.tbadkCore.data.f hFv;
    private final BdTypeRecyclerView hKL;
    private bc hoP;
    private SmartBubbleAnimatedView hoQ;
    private i hoU;
    private com.baidu.tieba.f.a ige;
    private boolean iqq;
    private final BigdaySwipeRefreshLayout isk;
    private final af ixG;
    private ScrollFragmentTabHost ixu;
    private BdUniqueId iyB;
    private int iyC;
    private Runnable iyL;
    private final long iyn;
    private final b iyo;
    private DataRes.Builder iyq;
    private final com.baidu.tieba.homepage.personalize.model.a iyt;
    private int iyw;
    private h iyy;
    private final TbPageContext<?> mPageContext;
    private a iyp = null;
    private final List<q> mDataList = new LinkedList();
    private int mPn = 1;
    private boolean mIsLoading = false;
    private boolean iss = false;
    private int iyr = 2;
    private int iys = 0;
    private TextView mTipView = null;
    private int hKx = 2000;
    private com.baidu.tbadk.n.c iyu = null;
    private boolean hIq = false;
    private int hHG = 0;
    private int frk = 0;
    private boolean mIsBackground = false;
    private boolean iwF = true;
    private boolean iyv = false;
    private boolean iyx = false;
    private boolean iyz = true;
    private FloatInfo iyA = null;
    private BdUniqueId iyD = BdUniqueId.gen();
    private a.C0096a hFQ = new a.C0096a(2);
    private ThreadInfo iyE = null;
    private RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.e.12
        private int iyT = -1;
        private int isA = 0;
        private boolean iyU = false;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (e.this.iyu == null) {
                e.this.iyu = new com.baidu.tbadk.n.c();
                e.this.iyu.setSubType(1005);
                e.this.iyu.pageType = 1;
            }
            if (e.this.eKX != null && !e.this.mIsBackground) {
                e.this.eKX.k(recyclerView, i);
            }
            if (i == 0) {
                c.d(e.this.hKL);
                e.this.iyu.blr();
                s.bRL().km(true);
                com.baidu.tieba.a.d.brD().dk("page_recommend", "show_");
                com.baidu.tieba.s.c.dkh().b(e.this.iyB, false);
                this.iyU = false;
                if (e.this.hoU != null && e.this.iwF && !e.this.mIsBackground) {
                    e.this.hoU.a(e.this.hHG, e.this.frk, e.this.hIq, 1);
                    return;
                }
                return;
            }
            e.this.iyu.blq();
            if (i == 1) {
                if (e.this.hoP != null) {
                    e.this.hoP.hideTip();
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
            if (this.isA > i) {
                this.iyU = true;
            }
            if (e.this.eKX != null && !e.this.mIsBackground) {
                e.this.eKX.onScroll(this.isA, i);
            }
            this.isA = i;
            int i3 = (i + i2) - 1;
            if (!this.iyU && this.iyT != i3) {
                this.iyT = i3;
                e.this.xC(this.iyT);
            }
            if (this.iyU && this.iyT != i) {
                this.iyT = i;
                e.this.xC(this.iyT);
            }
            e.this.iyK = i;
            e.this.hHG = i;
            e.this.frk = (i + i2) - 1;
            ak cmH = e.this.cmH();
            if (cmH != null && cmH.sg() != null) {
                cmH.sg().b(e.this.hFQ);
            }
        }
    };
    private View.OnTouchListener eKY = new View.OnTouchListener() { // from class: com.baidu.tieba.homepage.personalize.e.23
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (e.this.exE != null) {
                e.this.exE.onTouch(view, motionEvent);
            }
            if (e.this.ige != null) {
                e.this.ige.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private a.InterfaceC0623a heG = new a.InterfaceC0623a() { // from class: com.baidu.tieba.homepage.personalize.e.26
        @Override // com.baidu.tieba.f.a.InterfaceC0623a
        public void D(int i, int i2) {
            e.this.hIq = false;
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0623a
        public void E(int i, int i2) {
            e.this.hIq = true;
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0623a
        public void bR(int i, int i2) {
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0623a
        public void F(int i, int i2) {
        }
    };
    private View.OnClickListener iyF = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.e.27
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (e.this.hoP != null) {
                e.this.hoP.hideTip();
            }
        }
    };
    private final CustomMessageListener iyG = new CustomMessageListener(CmdConfigCustom.CMD_RELOAD_HP_PERSONALIZED) { // from class: com.baidu.tieba.homepage.personalize.e.28
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (e.this.hKL != null) {
                e.this.hoU.cmG();
                e.this.iwF = false;
                e.this.isk.setRefreshing(true);
            }
        }
    };
    private final CustomMessageListener iyH = new CustomMessageListener(2921461) { // from class: com.baidu.tieba.homepage.personalize.e.29
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (e.this.hKL != null) {
                e.this.cnn();
            }
        }
    };
    private CustomMessageListener hYJ = new CustomMessageListener(CmdConfigCustom.PB_ACTION_PRAISE) { // from class: com.baidu.tieba.homepage.personalize.e.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            bv bvVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bv) && e.this.iyq != null && x.getCount(e.this.iyq.thread_list) != 0 && (bvVar = (bv) customResponsedMessage.getData()) != null && bvVar.aVW() != null && bvVar.getId() != null && x.getCount(e.this.iyq.thread_list) != 0) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < e.this.iyq.thread_list.size()) {
                        ThreadInfo threadInfo = e.this.iyq.thread_list.get(i2);
                        if (threadInfo == null || threadInfo.id.longValue() != com.baidu.adp.lib.f.b.toLong(bvVar.getId(), -1L)) {
                            i = i2 + 1;
                        } else {
                            ThreadInfo.Builder builder = new ThreadInfo.Builder(threadInfo);
                            Zan.Builder builder2 = new Zan.Builder(builder.zan);
                            builder2.num = Integer.valueOf((int) bvVar.aVW().getNum());
                            builder.zan = builder2.build(true);
                            e.this.iyq.thread_list.set(i2, builder.build(true));
                            return;
                        }
                    } else {
                        return;
                    }
                }
            }
        }
    };
    private CustomMessageListener iyI = new CustomMessageListener(CmdConfigCustom.CMD_LIVE_VIDEO_CLOSED_QUERY_RESPONSED) { // from class: com.baidu.tieba.homepage.personalize.e.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            bv bvVar;
            if (customResponsedMessage.getOrginalMessage() instanceof LiveRoomClosedQueryMessage) {
                List<Long> ids = ((LiveRoomClosedQueryMessage) customResponsedMessage.getOrginalMessage()).getIds();
                List<Object> originData = ((LiveRoomClosedQueryMessage) customResponsedMessage.getOrginalMessage()).getOriginData();
                if (!x.isEmpty(e.this.mDataList) && !x.isEmpty(ids) && !x.isEmpty(originData)) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= originData.size()) {
                            break;
                        }
                        if ((originData.get(i2) instanceof bv) && (bvVar = (bv) originData.get(i2)) != null && bvVar.aWF() != null && ids.contains(Long.valueOf(bvVar.aWF().live_id))) {
                            e.this.mDataList.remove(bvVar);
                        }
                        i = i2 + 1;
                    }
                    if (e.this.ixG != null) {
                        e.this.ixG.bR(new ArrayList(e.this.mDataList));
                    }
                }
            }
        }
    };
    private CustomMessageListener eaY = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.homepage.personalize.e.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int intValue;
            if ((customResponsedMessage instanceof UpdateAttentionMessage) && e.this.iyq != null && !x.isEmpty(e.this.iyq.thread_list)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid)) {
                    int i = 0;
                    while (true) {
                        if (i >= e.this.iyq.thread_list.size()) {
                            break;
                        }
                        ThreadInfo threadInfo = e.this.iyq.thread_list.get(i);
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
                            e.this.iyq.thread_list.set(i, builder.build(true));
                        }
                    }
                    e.this.a(updateAttentionMessage);
                }
            }
        }
    };
    private String iyJ = "lastReadReadPositionKey";
    private int iyK = 0;
    private d iyM = new d() { // from class: com.baidu.tieba.homepage.personalize.e.13
        @Override // com.baidu.tieba.homepage.personalize.d
        public void xl(final int i) {
            if (e.this.iyL == null) {
                e.this.iyL = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.e.13.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (e.this.hKL.getHandler() != null) {
                            e.this.hKL.requestFocusFromTouch();
                            if (i <= e.this.hKL.getCount() - 1) {
                                e.this.hKL.setSelection(i);
                            }
                        }
                    }
                };
            }
            e.this.hKL.removeCallbacks(e.this.iyL);
            e.this.hKL.post(e.this.iyL);
        }
    };
    private CustomMessageListener iyN = new CustomMessageListener(2016569) { // from class: com.baidu.tieba.homepage.personalize.e.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && e.this.iyy != null) {
                e.this.mDataList.remove(e.this.iyy);
                e.this.ixG.bR(new ArrayList(e.this.mDataList));
                com.baidu.tbadk.core.sharedPref.b.aZP().putLong("key_maintab_banner_close_time", System.currentTimeMillis());
            }
        }
    };
    private CustomMessageListener hoJ = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.homepage.personalize.e.17
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.g(customResponsedMessage);
            if (e.this.hoU != null && e.this.iwF) {
                e.this.hoU.a(e.this.hHG, e.this.frk, e.this.hIq, true);
            }
        }
    };
    private CustomMessageListener hoK = new CustomMessageListener(CmdConfigCustom.CMD_THREAD_NOT_EXIST_WHEN_ENTER_PB) { // from class: com.baidu.tieba.homepage.personalize.e.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.g(customResponsedMessage);
        }
    };
    private CustomMessageListener hYX = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.homepage.personalize.e.19
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && e.this.iyq != null && x.getCount(e.this.iyq.thread_list) != 0) {
                String str = (String) customResponsedMessage.getData();
                e.this.i(str, e.this.mDataList);
                e.this.GR(str);
                if (e.this.ixG != null) {
                    e.this.ixG.bR(new ArrayList(e.this.mDataList));
                }
                if (e.this.hoU != null && e.this.iwF) {
                    e.this.hoU.a(e.this.hHG, e.this.frk, e.this.hIq, true);
                }
            }
        }
    };
    private CustomMessageListener hHn = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.homepage.personalize.e.20
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ak cmH;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent)) {
                KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24 && (cmH = e.this.cmH()) != null && cmH.sg() != null) {
                    cmH.sg().b(new a.C0096a(3));
                }
            }
        }
    };
    private com.baidu.adp.framework.listener.a iyO = new com.baidu.adp.framework.listener.a(1003065, CmdConfigSocket.CMD_TOPIC_BLESS) { // from class: com.baidu.tieba.homepage.personalize.e.21
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
                        if ((qVar instanceof com.baidu.tieba.homepage.topic.topictab.b.a) && (bVar = ((com.baidu.tieba.homepage.topic.topictab.b.a) qVar).iFF) != null && longValue == bVar.pkId) {
                            bVar.userPkId = j2;
                            return;
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener hHo = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.homepage.personalize.e.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            List<q> dataList = e.this.ixG.getDataList();
            if (!x.isEmpty(dataList)) {
                for (q qVar : dataList) {
                    if (qVar instanceof k) {
                        k kVar = (k) qVar;
                        if (kVar.dRu != 0 && kVar.dLK != null) {
                            int[] imageWidthAndHeight = kVar.dLK.getImageWidthAndHeight();
                            kVar.dRu = imageWidthAndHeight[0];
                            kVar.dRv = imageWidthAndHeight[1];
                        }
                    }
                }
            }
            com.baidu.adp.lib.f.e.lt().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.personalize.e.22.1
                @Override // java.lang.Runnable
                public void run() {
                    e.this.ixG.notifyDataSetChanged();
                    if (!e.this.mIsBackground && e.this.iwF) {
                        e.this.hoU.a(e.this.hHG, e.this.frk, e.this.hIq, true);
                    }
                }
            }, 500L);
        }
    };
    private CustomMessageListener hoL = new CustomMessageListener(2921453) { // from class: com.baidu.tieba.homepage.personalize.e.24
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bd)) {
                bd bdVar = (bd) customResponsedMessage.getData();
                if (bdVar.dQv == 1) {
                    int equipmentWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst());
                    int equipmentHeight = l.getEquipmentHeight(TbadkCoreApplication.getInst());
                    float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
                    int i = at.baS().baT() ? 2 : 1;
                    RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
                    requestGetMyPostNetMessage.setTag(e.this.iyD);
                    requestGetMyPostNetMessage.setParams(com.baidu.adp.lib.f.b.toLong(bdVar.tid, 0L), 0L, 0L, equipmentWidth, equipmentHeight, f, i);
                    requestGetMyPostNetMessage.setBFrom("push");
                    MessageManager.getInstance().sendMessage(requestGetMyPostNetMessage);
                }
            }
        }
    };
    private final com.baidu.adp.framework.listener.a hoM = new com.baidu.adp.framework.listener.a(1003010, CmdConfigSocket.CMD_GET_MY_POST) { // from class: com.baidu.tieba.homepage.personalize.e.25
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            GetMyPostResIdl getMyPostResIdl = null;
            if (responsedMessage instanceof GetMyPostHttpResponseMessage) {
                getMyPostResIdl = ((GetMyPostHttpResponseMessage) responsedMessage).getResponseData();
            } else if (responsedMessage instanceof GetMyPostSocketResponseMessage) {
                getMyPostResIdl = ((GetMyPostSocketResponseMessage) responsedMessage).getResponseData();
            }
            if (getMyPostResIdl != null && getMyPostResIdl.data != null && getMyPostResIdl.data.thread_info != null) {
                e.this.iyE = getMyPostResIdl.data.thread_info;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921455));
            }
        }
    };

    /* loaded from: classes16.dex */
    public interface a {
        void B(int i, int i2, int i3, int i4);

        void P(int i, int i2, int i3);

        void cnb();

        void onError(int i, String str);

        void onSuccess();
    }

    public void pd(boolean z) {
        this.iyz = z;
        if (this.hoP != null && !z) {
            this.hoP.hideTip();
        }
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.ixu = scrollFragmentTabHost;
        if (this.ixu != null) {
            this.ixu.setOnTabSelectedListener(new ScrollFragmentTabHost.b() { // from class: com.baidu.tieba.homepage.personalize.e.1
                @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.b
                public void xv(int i) {
                    if (e.this.ixu.xu(i) != 1 && e.this.hoP != null) {
                        e.this.hoP.hideTip();
                    }
                }
            });
        }
    }

    public void setTabInForeBackgroundState(boolean z) {
        this.mIsBackground = z;
    }

    public void nN(boolean z) {
        boolean z2 = false;
        this.mIsBackground = z;
        if (this.ixu != null) {
            this.ixu.nN(z);
        }
        if (this.hoU != null) {
            this.hoU.qZ(!z);
            ak cmH = cmH();
            if (cmH != null && cmH.sg() != null) {
                z2 = cmH.sg().b(new a.C0096a(8, Boolean.valueOf(z)));
            }
            if (!z2) {
                if (z) {
                    this.hoU.cmG();
                } else if (this.iwF) {
                    this.hoU.a(this.hHG, this.frk, this.hIq, true);
                }
            }
        }
    }

    public e(TbPageContext<?> tbPageContext, BdTypeRecyclerView bdTypeRecyclerView, af afVar, BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout) {
        this.iyC = 0;
        this.mPageContext = tbPageContext;
        this.iyC = com.baidu.tbadk.core.sharedPref.b.aZP().getInt("key_personalized_refresh_type", 0);
        this.isk = bigdaySwipeRefreshLayout;
        this.hKL = bdTypeRecyclerView;
        this.hKL.setOnTouchListener(this.eKY);
        this.ige = new com.baidu.tieba.f.a();
        this.ige.a(this.heG);
        this.ixG = afVar;
        this.iyt = new com.baidu.tieba.homepage.personalize.model.a();
        this.iyn = com.baidu.tbadk.core.sharedPref.b.aZP().getLong("recommend_frs_cache_time", 1800L) * 1000;
        bdTypeRecyclerView.setOnScrollListener(this.mOnScrollListener);
        this.hoP = new bc();
        cnl();
        this.hoU = new i(this.mPageContext, this.hKL);
        this.hoU.Dm(1);
        this.hoU.Dl(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.iyo = new b(this.mDataList, this.ixG);
        this.hoQ = new SmartBubbleAnimatedView(tbPageContext.getContext());
        this.hoQ.setLayoutParams(new FrameLayout.LayoutParams(-1, l.getDimens(tbPageContext.getContext(), R.dimen.tbds83)));
        cnc();
        this.hHo.setTag(this.mPageContext.getUniqueId());
        MessageManager.getInstance().registerListener(this.hHo);
        if (MessageManager.getInstance().findTask(1003010) == null) {
            HomePageStatic.clp();
        }
        this.hoM.setTag(this.iyD);
        if (this.hoM.getHttpMessageListener() != null) {
            this.hoM.getHttpMessageListener().setSelfListener(true);
        }
        if (this.hoM.getSocketMessageListener() != null) {
            this.hoM.getSocketMessageListener().setSelfListener(true);
        }
        MessageManager.getInstance().registerListener(this.hoM);
        MessageManager.getInstance().registerListener(this.hoL);
    }

    private void cnc() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2016323, new CustomMessageTask.CustomRunnable<Boolean>() { // from class: com.baidu.tieba.homepage.personalize.e.30
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Boolean> customMessage) {
                ak cmH = e.this.cmH();
                return (cmH == null || cmH.sg() == null) ? new CustomResponsedMessage<>(2016323, false) : new CustomResponsedMessage<>(2016323, Boolean.valueOf(cmH.sg().b(new a.C0096a(6))));
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private boolean cnd() {
        return com.baidu.tbadk.core.sharedPref.b.aZP().getBoolean(cnf(), true);
    }

    private void cne() {
        com.baidu.tbadk.core.sharedPref.b.aZP().putBoolean(cnf(), false);
    }

    private String cnf() {
        return "key_rec_pfirst_load_" + TbadkCoreApplication.getCurrentAccount() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + TbConfig.getVersion();
    }

    public void setRecommendFrsNavigationAnimDispatcher(aa aaVar) {
        if (aaVar != null) {
            this.eKX = aaVar.bmT();
            this.exE = aaVar.bmU();
        }
    }

    public void showFloatingView() {
        if (this.eKX != null) {
            this.eKX.showFloatingView(true);
        }
    }

    public void update() {
        com.baidu.tieba.homepage.framework.a.clF().r(System.currentTimeMillis(), 1);
        this.mPn = 1;
        this.iyx = true;
        if (this.mDataList.size() == 0 && !cnd()) {
            if (!this.iss) {
                aTF();
                return;
            }
            return;
        }
        aTE();
    }

    public void cp(int i, int i2) {
        bv bvVar;
        if (!x.isEmpty(this.mDataList) && this.mDataList.size() > i) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            while (i < this.mDataList.size() && i <= i2) {
                if (this.mDataList.get(i).getType().getId() == bv.dRT.getId() && (bvVar = (bv) this.mDataList.get(i)) != null && bvVar.aWF() != null) {
                    arrayList.add(Long.valueOf(bvVar.aWF().live_id));
                    arrayList2.add(bvVar);
                }
                i++;
            }
            if (!x.isEmpty(arrayList)) {
                MessageManager.getInstance().sendMessage(new LiveRoomClosedQueryMessage(arrayList, arrayList2));
            }
        }
    }

    public void cng() {
        if (this.hoU != null && !this.mIsBackground && this.iwF) {
            this.hoU.a(this.hHG, this.frk, this.hIq, true);
        }
        if (this.iyv) {
            if (this.isk != null && !this.isk.bcn()) {
                if (this.iqq) {
                    com.baidu.tieba.s.c.dkh().b(this.iyB, false);
                    if (pf(false)) {
                        cq(3, this.iys);
                    } else if (this.iyw > 0) {
                        cq(2, this.iys);
                    }
                } else if (!this.iqq && this.iys == 0) {
                    cq(2, 0);
                }
            }
            this.iyv = false;
            this.iqq = false;
            this.iyw = 0;
            if (this.iyx) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
            }
            this.iyx = false;
        }
    }

    public void bwE() {
        if (isLoading()) {
            com.baidu.tieba.homepage.framework.a.clF().r(0L, 1);
        } else if (this.iyp != null) {
            cni();
            this.mPn++;
            setIsLoading(true);
            this.iyp.B(this.mPn, (this.iyq == null || this.iyq.thread_list == null) ? 0 : this.iyq.thread_list.size(), pe(false), 0);
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
        if (this.iyt != null && this.iyt.cnK() && !z && (dataRes == null || x.isEmpty(dataRes.thread_list))) {
            if (dataRes == null) {
                DataRes.Builder builder = new DataRes.Builder();
                builder.thread_list = new ArrayList();
                dataRes = builder.build(false);
            }
            if (dataRes.thread_list != null) {
                List<ThreadInfo> cnL = this.iyt.cnL();
                dataRes.thread_list.addAll(cnL);
                if (cnL != null) {
                    cnL.clear();
                }
                z3 = true;
                size = (this.iyq != null || this.iyq.thread_list == null) ? 0 : this.iyq.thread_list.size();
                if (z && i == 0 && dataRes != null && x.isEmpty(dataRes.thread_list)) {
                    if (this.iyp != null) {
                        this.iyp.cnb();
                    }
                    setIsLoading(false);
                    if (this.isk != null) {
                        this.isk.setRefreshing(false);
                        return;
                    }
                    return;
                }
                if (this.iyE != null) {
                    DataRes.Builder builder2 = new DataRes.Builder(dataRes);
                    builder2.thread_list.add(0, this.iyE);
                    dataRes = builder2.build(false);
                    if (this.iyq != null && !x.isEmpty(this.iyq.thread_list)) {
                        Iterator<ThreadInfo> it = this.iyq.thread_list.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            ThreadInfo next = it.next();
                            if (next != null && next.tid != null && this.iyE.tid != null && next.tid.longValue() == this.iyE.tid.longValue()) {
                                this.iyq.thread_list.remove(next);
                                break;
                            }
                        }
                    }
                    this.iyE = null;
                }
                if ((z3 && i != 0) || dataRes == null || !a(true, z, z2, dataRes)) {
                    this.iyv = false;
                    if (this.mDataList.size() > 0) {
                        if (this.iyp != null) {
                            this.iyp.onError(1, str);
                        }
                    } else if (this.iyp != null) {
                        this.iyp.onError(2, str);
                    }
                } else {
                    cne();
                    if (this.iyp != null) {
                        com.baidu.tbadk.core.sharedPref.b.aZP().putLong(SharedPrefConfig.RECOMMEND_FRS_REFRESH_TIME + TbadkCoreApplication.getCurrentAccount(), System.currentTimeMillis());
                        this.iyp.onSuccess();
                    }
                    this.iyv = true;
                    this.iqq = z;
                    this.iyw = size;
                    bVB();
                }
                setIsLoading(false);
                if (this.isk == null) {
                    f.e cnh = cnh();
                    if (this.isk.bcn() && cnh != null) {
                        this.isk.c(cnh);
                        return;
                    } else {
                        this.isk.setRefreshing(false);
                        return;
                    }
                }
                return;
            }
        }
        z3 = false;
        if (this.iyq != null) {
        }
        if (z) {
        }
        if (this.iyE != null) {
        }
        if (z3) {
        }
        cne();
        if (this.iyp != null) {
        }
        this.iyv = true;
        this.iqq = z;
        this.iyw = size;
        bVB();
        setIsLoading(false);
        if (this.isk == null) {
        }
    }

    private f.e cnh() {
        int i;
        String feedText;
        if (this.iyv && this.isk != null && this.isk.bcn()) {
            int i2 = this.iys;
            if (this.iqq) {
                com.baidu.tieba.s.c.dkh().b(this.iyB, false);
                if (pf(false)) {
                    i = 3;
                } else {
                    i = this.iyw > 0 ? 2 : 0;
                }
            } else if (this.iqq || this.iys != 0) {
                return null;
            } else {
                i2 = 0;
                i = 2;
            }
            if (this.ixu != null) {
                this.hoP.cdN();
            }
            if (this.ixu != null && this.ixu.getCurrentTabType() != 1) {
                this.hoP.hideTip();
                return null;
            } else if (!this.iyz) {
                this.hoP.hideTip();
                return null;
            } else {
                this.iyr = i;
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
                    this.hKx = 1000;
                } else {
                    this.hKx = 0;
                }
                return new f.e(feedText, this.hKx);
            }
        }
        return null;
    }

    public void oT(boolean z) {
        if (z) {
            this.ixG.notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        if (this.hoU != null) {
            this.hoU.destroy();
        }
        if (this.hoP != null) {
            this.hoP.onDestroy();
        }
        if (this.iyo != null) {
            this.iyo.onDestroy();
        }
        if (this.hKL != null) {
            this.hKL.removeCallbacks(this.iyL);
        }
        MessageManager.getInstance().unRegisterTask(2016323);
        MessageManager.getInstance().unRegisterListener(this.hHo);
        MessageManager.getInstance().unRegisterListener(this.hoL);
        MessageManager.getInstance().unRegisterListener(this.hoM);
    }

    public void onPause() {
        c.d(this.hKL);
        xD(this.iyK);
        if (this.iyu != null) {
            this.iyu.bls();
        }
    }

    private void aTE() {
        if (this.iyp != null) {
            this.iyp.P((this.iyq == null || this.iyq.thread_list == null || cnk()) ? 0 : this.iyq.thread_list.size(), pe(true), 0);
        }
    }

    public int pe(boolean z) {
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
                if (!(qVar instanceof com.baidu.tieba.homepage.personalize.data.a) || qVar.getType() == AdvertAppInfo.dML) {
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
                if ((qVar2 instanceof com.baidu.tieba.homepage.personalize.data.a) && qVar2.getType() != AdvertAppInfo.dML) {
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
        this.iss = true;
        if (dataRes != null) {
            if (a(false, true, true, dataRes) && !cnk()) {
                if (this.iyp != null) {
                    this.iyp.onSuccess();
                    Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler() { // from class: com.baidu.tieba.homepage.personalize.e.31
                        @Override // android.os.MessageQueue.IdleHandler
                        public boolean queueIdle() {
                            e.this.blx();
                            return false;
                        }
                    });
                }
                if (TbSingleton.getInstance().getForceRefreshHomeRecommend()) {
                    aTE();
                    TbSingleton.getInstance().setForceRefreshHomeRecommend(false);
                    return;
                }
                return;
            }
            aTE();
            return;
        }
        aTE();
    }

    public void blx() {
        long xj = com.baidu.tieba.homepage.framework.a.clF().xj(1) + com.baidu.tieba.homepage.framework.a.clF().getCreateTime();
        long xh = com.baidu.tieba.homepage.framework.a.clF().xh(1);
        if (xh > 0) {
            xj = System.currentTimeMillis() - xh;
        }
        n.blF().m33do(xj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.util.Set] */
    private void i(List<q> list, int i) {
        AdvertAppInfo bSf;
        AdvertAppInfo bSf2;
        if (!x.isEmpty(list)) {
            Set<q> MD = com.baidu.tieba.recapp.report.a.MD("NEWINDEX");
            HashSet hashSet = MD == null ? new HashSet() : MD;
            HashSet hashSet2 = new HashSet();
            for (q qVar : list) {
                if (qVar != null) {
                    for (q qVar2 : hashSet) {
                        if ((qVar instanceof com.baidu.tieba.card.data.d) && (bSf2 = ((com.baidu.tieba.card.data.d) qVar).bSf()) != null && qVar2 != null && (qVar2 instanceof AdvertAppInfo) && qVar2.hashCode() == bSf2.hashCode()) {
                            bSf2.advertAppContext = ((AdvertAppInfo) qVar2).advertAppContext;
                        }
                    }
                    if (qVar != null && (qVar instanceof com.baidu.tieba.card.data.d) && (bSf = ((com.baidu.tieba.card.data.d) qVar).bSf()) != null && bSf.advertAppContext == null) {
                        bSf.advertAppContext = new com.baidu.tbadk.core.data.b();
                        bSf.advertAppContext.page = "NEWINDEX";
                        bSf.advertAppContext.pn = this.mPn;
                        bSf.advertAppContext.extensionInfo = bSf.extensionInfo;
                        bSf.advertAppContext.Xw = false;
                        hashSet2.add(bSf);
                    }
                }
            }
            hashSet.addAll(hashSet2);
            com.baidu.tieba.recapp.report.a.b("NEWINDEX", hashSet);
            if (hashSet2.size() > 0) {
                com.baidu.tieba.s.c.dkh().b(this.iyB, com.baidu.tieba.s.a.b(PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE, "common_fill", true, hashSet2.size()));
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
        if (this.iyC == 1) {
            if (z2 && (dataRes.thread_list.size() >= 6 || cnk())) {
                cnj();
                this.iyq = null;
            }
        } else if (z2 && cnk()) {
            this.iyq = null;
        }
        int size = z2 ? 0 : this.mDataList.size();
        DataRes.Builder builder = new DataRes.Builder(dataRes);
        this.mDataList.clear();
        com.baidu.tieba.homepage.personalize.model.c a2 = this.iyt.a(z, this.iyq, builder, z2 ? 0 : 1);
        if (a2 == null) {
            list = null;
            i = 0;
        } else {
            List<q> list2 = a2.eZc;
            this.iys = a2.iBp;
            int i2 = a2.iBq;
            a2.iBq = 0;
            list = list2;
            i = i2;
        }
        if (list != null) {
            this.mDataList.addAll(list);
            i(list, size);
            a(z2 ? 0 : 1, list, size);
            if (this.iyx) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
            }
        }
        if (this.iyq == null) {
            this.iyq = builder;
            this.iyo.dc(this.iyq.thread_list);
        }
        if (this.mDataList.size() == 0) {
            z4 = false;
        } else {
            if (z2) {
                if (dataRes.live_answer != null) {
                    this.iyy = new h();
                    this.iyy.a(dataRes.live_answer);
                    this.iyq.live_answer = dataRes.live_answer;
                } else if (z) {
                    this.iyy = null;
                    this.iyq.live_answer = null;
                }
                this.iyA = dataRes.float_info;
                this.iyq.float_info = dataRes.float_info;
            }
            long j = com.baidu.tbadk.core.sharedPref.b.aZP().getLong("key_maintab_banner_close_time", 0L);
            if (this.iyy != null && !as.isTaday(j)) {
                this.mDataList.add(0, this.iyy);
            }
            LinkedList linkedList = new LinkedList(this.mDataList);
            this.ixG.setFromCDN(dataRes.is_new_url != null && dataRes.is_new_url.intValue() == 1);
            this.ixG.j(linkedList, i);
            z4 = true;
            if (this.hoU != null && this.iwF) {
                this.hoU.a(this.hHG, this.frk, this.hIq, true);
            }
        }
        com.baidu.tieba.homepage.framework.a.clF().p(System.currentTimeMillis() - currentTimeMillis, 1);
        long xk = com.baidu.tieba.homepage.framework.a.clF().xk(1);
        if (xk > 0) {
            com.baidu.tieba.homepage.framework.a.clF().q(System.currentTimeMillis() - xk, 1);
            com.baidu.tieba.homepage.framework.a.clF().r(0L, 1);
        }
        if (dataRes.anti != null && dataRes.anti.block_pop_info != null) {
            com.baidu.tieba.ueg.d.d(dataRes.anti.block_pop_info);
        }
        bf bfVar = new bf();
        bfVar.a(dataRes.recom_post_topic);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_REFRESH_TOPIC_TIP, bfVar));
        return z4;
    }

    private void cni() {
        List<q> list;
        int i;
        if (x.getCount(this.mDataList) >= this.iyt.cnG() - 40) {
            com.baidu.tieba.homepage.personalize.model.c a2 = this.iyt.a(true, this.iyq, null, 1);
            if (a2 != null) {
                List<q> list2 = a2.eZc;
                i = a2.iBq;
                a2.iBq = 0;
                list = list2;
            } else {
                list = null;
                i = 0;
            }
            if (list != null) {
                this.mDataList.clear();
                this.mDataList.addAll(list);
                this.ixG.j(new LinkedList(this.mDataList), i);
            }
        }
    }

    private void aTF() {
        this.iss = true;
        ad.a(new ac<DataRes>() { // from class: com.baidu.tieba.homepage.personalize.e.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.ac
            /* renamed from: cno */
            public DataRes doInBackground() {
                com.baidu.adp.lib.cache.l<byte[]> df = com.baidu.tbadk.core.c.a.aYG().df("tb.rec_frs_update", TbadkCoreApplication.getCurrentAccount());
                if (df == null) {
                    return null;
                }
                byte[] bArr = df.get("0");
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

    private void bVB() {
        if (this.iyq != null) {
            DataRes.Builder builder = new DataRes.Builder(this.iyq.build(true));
            if (builder.thread_list != null && builder.thread_list.size() > 30) {
                builder.thread_list = builder.thread_list.subList(0, 30);
            }
            a(builder, builder.thread_list != null ? builder.thread_list.size() : 0);
            a(builder);
            b(builder);
            c(builder);
        }
    }

    private void cnj() {
        if (this.iyq != null) {
            final DataRes.Builder builder = new DataRes.Builder(this.iyq.build(true));
            if (builder.thread_list != null && builder.thread_list.size() > 50) {
                builder.thread_list = builder.thread_list.subList(0, 50);
            }
            a(builder, builder.thread_list != null ? builder.thread_list.size() : 0);
            ad.a(new ac<Object>() { // from class: com.baidu.tieba.homepage.personalize.e.4
                @Override // com.baidu.tbadk.util.ac
                public Object doInBackground() {
                    DataRes.Builder builder2 = new DataRes.Builder(builder.build(true));
                    e.this.iyo.dd(builder2.thread_list);
                    try {
                        com.baidu.tbadk.core.c.a.aYG().df("tb.rec_old_data", TbadkCoreApplication.getCurrentAccount()).setForever("0", builder2.build(true).toByteArray());
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
    public void GR(String str) {
        if (!TextUtils.isEmpty(str) && this.iyq != null && this.iyq.banner_list != null && this.iyq.banner_list.app != null && this.iyq.banner_list.app.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (App app : this.iyq.banner_list.app) {
                if (app != null && str.equals(app.id)) {
                    arrayList.add(app);
                }
            }
            BannerList.Builder builder = new BannerList.Builder(this.iyq.banner_list);
            if (builder.app != null) {
                builder.app.removeAll(arrayList);
            }
            this.iyq.banner_list = builder.build(false);
            DataRes.Builder builder2 = new DataRes.Builder(this.iyq.build(true));
            builder2.banner_list = builder.build(true);
            c(builder2);
        }
    }

    private void c(final DataRes.Builder builder) {
        ad.a(new ac<Object>() { // from class: com.baidu.tieba.homepage.personalize.e.5
            @Override // com.baidu.tbadk.util.ac
            public Object doInBackground() {
                DataRes.Builder builder2 = new DataRes.Builder(builder.build(true));
                e.this.iyo.dd(builder2.thread_list);
                try {
                    com.baidu.tbadk.core.c.a.aYG().df("tb.rec_frs_update", TbadkCoreApplication.getCurrentAccount()).setForever("0", builder2.build(true).toByteArray());
                    return null;
                } catch (Exception e) {
                    BdLog.e(e);
                    return null;
                }
            }
        }, null);
    }

    private boolean cnk() {
        return pf(true);
    }

    private boolean pf(boolean z) {
        long j = com.baidu.tbadk.core.sharedPref.b.aZP().getLong(SharedPrefConfig.RECOMMEND_FRS_REFRESH_TIME + TbadkCoreApplication.getCurrentAccount(), 0L);
        return j == 0 ? z : Math.abs(System.currentTimeMillis() - j) > this.iyn;
    }

    public void a(a aVar) {
        this.iyp = aVar;
    }

    private boolean isLoading() {
        return this.mIsLoading;
    }

    private void setIsLoading(boolean z) {
        this.mIsLoading = z;
    }

    public void cmY() {
        boolean z = true;
        com.baidu.tbadk.coreExtra.data.b activityPrizeData = TbadkCoreApplication.getInst().getActivityPrizeData();
        if (activityPrizeData.isSwitchTurn() && !StringUtils.isNull(activityPrizeData.getFeedText())) {
            String currentDay = UtilHelper.getCurrentDay();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            String str = "";
            if (!StringUtils.isNull(currentAccount)) {
                String string = com.baidu.tbadk.core.sharedPref.b.aZP().getString(SharedPrefConfig.ACTIVITY_PRIZE_FEED_TEXT_TIME, "");
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
                    cq(4, 0);
                    com.baidu.tbadk.core.sharedPref.b.aZP().putString(SharedPrefConfig.ACTIVITY_PRIZE_FEED_TEXT_TIME, str);
                }
            }
        }
    }

    private void cq(int i, int i2) {
        if (this.ixu != null) {
            this.hoP.cdN();
        }
        if (this.ixu != null && this.ixu.getCurrentTabType() != 1) {
            this.hoP.hideTip();
        } else if (!this.iyz) {
            this.hoP.hideTip();
        } else {
            this.iyr = i;
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
                    this.hKx = 3000;
                } else {
                    this.hKx = 2000;
                }
                this.hoQ.ejr = str;
                this.hoQ.hKq = this.hKx;
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 49;
                if (this.ixu != null) {
                    FrameLayout frameLayout = this.ixu.getFrameLayout();
                    frameLayout.removeView(this.hoQ);
                    frameLayout.addView(this.hoQ, layoutParams);
                    this.hoQ.cdL();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(Long l) {
        if (this.iyq != null && this.iyq.thread_list != null) {
            List<ThreadInfo> list = this.iyq.thread_list;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                ThreadInfo threadInfo = list.get(i);
                if (threadInfo.tid.equals(l) && threadInfo.top_agree_post != null) {
                    ThreadInfo.Builder builder = new ThreadInfo.Builder(threadInfo);
                    builder.top_agree_post = null;
                    list.set(i, builder.build(true));
                    bVB();
                    a(false, true, false, this.iyq.build(true));
                    return;
                }
            }
        }
    }

    public void p(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.iyB = bdUniqueId;
            if (this.hYJ != null) {
                this.hYJ.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.hYJ);
            }
            if (this.iyG != null) {
                this.iyG.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.iyG);
            }
            this.iyH.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.iyH);
            this.eaY.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.eaY);
            this.iyI.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.iyI);
            this.hoJ.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.hoJ);
            this.hoK.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.hoK);
            this.hYX.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.hYX);
            if (this.hoU != null) {
                this.hoU.setUniqueId(bdUniqueId);
            }
            this.iyo.m(bdUniqueId);
            this.iyN.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.iyN);
            this.hHn.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.hHn);
            this.iyO.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.iyO);
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
                        com.baidu.adp.lib.cache.l<byte[]> df = com.baidu.tbadk.core.c.a.aYG().df("tb.rec_frs_update", TbadkCoreApplication.getCurrentAccount());
                        if (df == null) {
                            return false;
                        }
                        byte[] bArr = df.get("0");
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
                        e.this.iyo.dd(builder5.thread_list);
                        df.setForever("0", builder5.build(true).toByteArray());
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

    public void cnl() {
        this.hFv = new com.baidu.tieba.tbadkCore.data.f("new_index", null);
        this.hFv.dkN();
    }

    public void a(int i, List<q> list, int i2) {
        int i3;
        int i4;
        if (this.hFv != null) {
            if (i == 0) {
                this.hFv.dkN();
            }
            if (list != null && !list.isEmpty()) {
                int[] iArr = com.baidu.tieba.tbadkCore.data.f.lMC;
                int i5 = 0;
                int i6 = 0;
                int i7 = 0;
                while (i7 < list.size() && i6 < iArr.length && (i3 = iArr[i6]) >= 0) {
                    if (list.get(i7) instanceof com.baidu.tieba.card.data.c) {
                        i4 = i5 + 1;
                        if (i4 == i3 - 1) {
                            if (i2 < i7 + 1) {
                                this.hFv.dc(i3, i7 + 1);
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

    public void xC(int i) {
        if ((this.hFv != null ? this.hFv.Fp(i) : -1) >= 0 && this.hKL != null && this.hKL.getData() != null && this.hKL.getData().size() > i) {
            this.hFv.Fq(i);
        }
    }

    public i ccy() {
        return this.hoU;
    }

    public void oZ(boolean z) {
        this.iwF = z;
    }

    public void xD(final int i) {
        ad.a(new ac<Object>() { // from class: com.baidu.tieba.homepage.personalize.e.11
            @Override // com.baidu.tbadk.util.ac
            public Object doInBackground() {
                com.baidu.adp.lib.cache.l<String> dg = com.baidu.tbadk.core.c.a.aYG().dg(e.this.iyJ, TbadkCoreApplication.getCurrentAccount());
                if (dg != null) {
                    dg.set(e.this.iyJ, Integer.toString(i), 43200000L);
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
            /* renamed from: cnp */
            public String doInBackground() {
                com.baidu.adp.lib.cache.l<String> dg = com.baidu.tbadk.core.c.a.aYG().dg(e.this.iyJ, TbadkCoreApplication.getCurrentAccount());
                if (dg != null) {
                    return dg.get(e.this.iyJ);
                }
                return null;
            }
        }, new com.baidu.tbadk.util.l<String>() { // from class: com.baidu.tieba.homepage.personalize.e.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.l
            /* renamed from: GS */
            public void onReturnDataInUI(String str) {
                if (dVar != null) {
                    dVar.xl(com.baidu.adp.lib.f.b.toInt(str, 0));
                }
            }
        });
    }

    public void cmZ() {
        c.e(this.hKL);
    }

    public void cnm() {
        a(this.iyM);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cnn() {
        Iterator<q> it = this.mDataList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            } else if (it.next() instanceof g) {
                it.remove();
                break;
            }
        }
        if (this.iyq != null) {
            this.iyq.active_center = null;
            bVB();
            if (this.hKL != null) {
                List<Integer> f = f(this.hKL);
                int intValue = f.get(0).intValue();
                int intValue2 = f.get(1).intValue();
                if (intValue != -1 && intValue2 != -1) {
                    this.hKL.m(intValue, intValue2);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(CustomResponsedMessage<?> customResponsedMessage) {
        boolean z;
        String str;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.iyq != null && x.getCount(this.iyq.thread_list) != 0 && x.getCount(this.mDataList) != 0) {
            JSONObject jSONObject = (JSONObject) customResponsedMessage.getData();
            String optString = jSONObject.optString("tid");
            if (StringUtils.isNull(optString)) {
                String optString2 = jSONObject.optString(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_ID);
                if (this.hKL != null && !TextUtils.isEmpty(optString2)) {
                    int i = 0;
                    while (true) {
                        if (i >= this.hKL.getCount()) {
                            str = optString;
                            break;
                        }
                        q item = this.hKL.getItem(i);
                        if (item instanceof com.baidu.tieba.card.data.j) {
                            com.baidu.tieba.card.data.j jVar = (com.baidu.tieba.card.data.j) item;
                            if (jVar.aTN() != null && jVar.aTN().aWF() != null && optString2.equals(String.valueOf(jVar.aTN().aWF().live_id))) {
                                str = jVar.aTN().getTid();
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
                    if (cVar.aTN() != null && cVar.aTN().getTid() != null) {
                        if (cVar.aTN().getTid().equals(optString)) {
                            it.remove();
                            z = true;
                            z2 = z;
                        } else if (z2) {
                            com.baidu.tieba.homepage.personalize.model.b.df(this.mDataList);
                            break;
                        }
                    }
                }
                z = z2;
                z2 = z;
            }
            if (this.iyq != null && this.iyq.thread_list != null) {
                long j = com.baidu.adp.lib.f.b.toLong(optString, 0L);
                int i2 = 0;
                while (true) {
                    if (i2 < this.iyq.thread_list.size()) {
                        ThreadInfo threadInfo = this.iyq.thread_list.get(i2);
                        if (threadInfo == null || threadInfo.tid == null || threadInfo.tid.longValue() != j) {
                            i2++;
                        } else {
                            com.baidu.tieba.homepage.personalize.b.d.a(threadInfo.tid.longValue(), i2, this.iyq.thread_list, this.mDataList);
                            this.iyq.thread_list.remove(i2);
                            bVB();
                            break;
                        }
                    } else {
                        break;
                    }
                }
                if (this.hKL != null) {
                    List<Integer> b = b(optString, this.hKL);
                    int intValue = b.get(0).intValue();
                    int intValue2 = b.get(1).intValue();
                    if (intValue != -1 && intValue2 != -1) {
                        this.hKL.m(intValue, intValue2);
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
                    if (cVar.aTN() != null && cVar.aTN().getTid().equals(str)) {
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
    public void i(String str, List<q> list) {
        AdvertAppInfo advertAppInfo;
        if (list != null && list.size() > 0 && !TextUtils.isEmpty(str)) {
            Iterator<q> it = list.iterator();
            AdvertAppInfo advertAppInfo2 = null;
            while (it.hasNext()) {
                q next = it.next();
                if (next instanceof com.baidu.tieba.homepage.personalize.data.a) {
                    advertAppInfo = ((com.baidu.tieba.homepage.personalize.data.a) next).bSf();
                } else {
                    if (next instanceof aj) {
                        aj ajVar = (aj) next;
                        if (ajVar.aUC() instanceof AdvertAppInfo.ILegoAdvert) {
                            advertAppInfo = ((AdvertAppInfo.ILegoAdvert) ajVar.aUC()).getAdvertAppInfo();
                        }
                    }
                    advertAppInfo = advertAppInfo2;
                }
                if (advertAppInfo != null && str.equals(advertAppInfo.dMW)) {
                    it.remove();
                    advertAppInfo = null;
                }
                advertAppInfo2 = advertAppInfo;
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (this.hoQ != null) {
            this.hoQ.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ak cmH() {
        if (this.hoU == null || this.hoU.cYQ() == null || !(this.hoU.cYQ().getTag() instanceof ak)) {
            return null;
        }
        return (ak) this.hoU.cYQ().getTag();
    }
}
