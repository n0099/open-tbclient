package com.baidu.tieba.homepage.personalize;

import android.os.Looper;
import android.os.MessageQueue;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
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
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.ala.atomdata.AlaSDKShareEmptyActivityConfig;
import com.baidu.card.a.a;
import com.baidu.card.am;
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
import com.baidu.tbadk.core.data.ak;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tbadk.n.n;
import com.baidu.tbadk.util.aa;
import com.baidu.tbadk.util.ab;
import com.baidu.tbadk.util.ad;
import com.baidu.tbadk.util.ae;
import com.baidu.tbadk.util.m;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.LiveRoomClosedQueryMessage;
import com.baidu.tieba.card.data.k;
import com.baidu.tieba.card.data.l;
import com.baidu.tieba.card.s;
import com.baidu.tieba.f.a;
import com.baidu.tieba.frs.SmartBubbleAnimatedView;
import com.baidu.tieba.frs.be;
import com.baidu.tieba.homepage.BlessHttpResponseMessage;
import com.baidu.tieba.homepage.BlessSocketResponseMessage;
import com.baidu.tieba.homepage.GetMyPostHttpResponseMessage;
import com.baidu.tieba.homepage.GetMyPostSocketResponseMessage;
import com.baidu.tieba.homepage.HomePageStatic;
import com.baidu.tieba.homepage.RequestGetMyPostNetMessage;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import com.baidu.tieba.homepage.personalize.a.af;
import com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout;
import com.baidu.tieba.homepage.personalize.data.h;
import com.baidu.tieba.homepage.personalize.view.HomePageYoungsterTopView;
import com.baidu.tieba.message.RequestBlessMessage;
import com.baidu.tieba.play.i;
import com.baidu.tieba.view.BdTopToast;
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
import tbclient.DiscoverHotForum;
import tbclient.GetMyPost.GetMyPostResIdl;
import tbclient.GodInfo;
import tbclient.Personalized.DataRes;
import tbclient.Personalized.FloatInfo;
import tbclient.ThreadInfo;
import tbclient.User;
import tbclient.Zan;
/* loaded from: classes21.dex */
public class e {
    private View.OnTouchListener eKp;
    private aa eYx;
    private be hIO;
    private SmartBubbleAnimatedView hIP;
    private i hIT;
    private com.baidu.tieba.tbadkCore.data.f hZR;
    private com.baidu.tieba.f.a iBM;
    private boolean iLX;
    private final BigdaySwipeRefreshLayout iOr;
    private ScrollFragmentTabHost iUW;
    private final long iVP;
    private final b iVQ;
    private DataRes.Builder iVS;
    private final com.baidu.tieba.homepage.personalize.model.a iVV;
    private int iVY;
    private final af iVi;
    private h iWa;
    private BdUniqueId iWd;
    private HomePageYoungsterTopView iWe;
    private int iWf;
    private Runnable iWp;
    private final BdTypeRecyclerView iga;
    private final TbPageContext<?> mPageContext;
    private a iVR = null;
    private final List<q> mDataList = new LinkedList();
    private int mPn = 1;
    private boolean mIsLoading = false;
    private boolean iOA = false;
    private int iVT = 2;
    private int iVU = 0;
    private TextView mTipView = null;
    private int ifg = 2000;
    private com.baidu.tbadk.n.c iVW = null;
    private boolean icM = false;
    private int icc = 0;
    private int fFV = 0;
    private boolean mIsBackground = false;
    private boolean iTI = true;
    private boolean iVX = false;
    private boolean iVZ = false;
    private boolean iWb = true;
    private FloatInfo iWc = null;
    private BdUniqueId iWg = BdUniqueId.gen();
    private a.C0096a iam = new a.C0096a(2);
    private ThreadInfo iWh = null;
    private RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.e.12
        private int iWw = -1;
        private int iOJ = 0;
        private boolean iWx = false;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (e.this.iVW == null) {
                e.this.iVW = new com.baidu.tbadk.n.c();
                e.this.iVW.setSubType(1005);
                e.this.iVW.pageType = 1;
            }
            if (e.this.eYx != null && !e.this.mIsBackground) {
                e.this.eYx.k(recyclerView, i);
            }
            if (i == 0) {
                c.d(e.this.iga);
                e.this.iVW.bvj();
                s.cfn().kO(true);
                com.baidu.tieba.a.d.bBN().dA("page_recommend", "show_");
                com.baidu.tieba.s.c.dzC().b(e.this.iWd, false);
                this.iWx = false;
                if (e.this.hIT != null && e.this.iTI && !e.this.mIsBackground) {
                    e.this.hIT.a(e.this.icc, e.this.fFV, e.this.icM, 1);
                    return;
                }
                return;
            }
            e.this.iVW.bvi();
            if (i == 1) {
                if (e.this.hIO != null) {
                    e.this.hIO.hideTip();
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
            if (this.iOJ > i) {
                this.iWx = true;
            }
            if (e.this.eYx != null && !e.this.mIsBackground) {
                e.this.eYx.onScroll(this.iOJ, i);
            }
            this.iOJ = i;
            int i3 = (i + i2) - 1;
            if (!this.iWx && this.iWw != i3) {
                this.iWw = i3;
                e.this.Ax(this.iWw);
            }
            if (this.iWx && this.iWw != i) {
                this.iWw = i;
                e.this.Ax(this.iWw);
            }
            e.this.iWo = i;
            e.this.icc = i;
            e.this.fFV = (i + i2) - 1;
            am cAZ = e.this.cAZ();
            if (cAZ != null && cAZ.tW() != null) {
                cAZ.tW().b(e.this.iam);
            }
        }
    };
    private View.OnTouchListener eYy = new View.OnTouchListener() { // from class: com.baidu.tieba.homepage.personalize.e.23
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (e.this.eKp != null) {
                e.this.eKp.onTouch(view, motionEvent);
            }
            if (e.this.iBM != null) {
                e.this.iBM.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private a.InterfaceC0671a hyK = new a.InterfaceC0671a() { // from class: com.baidu.tieba.homepage.personalize.e.30
        @Override // com.baidu.tieba.f.a.InterfaceC0671a
        public void H(int i, int i2) {
            e.this.icM = false;
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0671a
        public void I(int i, int i2) {
            e.this.icM = true;
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0671a
        public void cc(int i, int i2) {
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0671a
        public void J(int i, int i2) {
        }
    };
    private View.OnClickListener iWi = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.e.31
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (e.this.hIO != null) {
                e.this.hIO.hideTip();
            }
        }
    };
    private final CustomMessageListener iWj = new CustomMessageListener(CmdConfigCustom.CMD_RELOAD_HP_PERSONALIZED) { // from class: com.baidu.tieba.homepage.personalize.e.32
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (e.this.iga != null) {
                e.this.hIT.cAY();
                e.this.iTI = false;
                e.this.iOr.setRefreshing(true);
            }
        }
    };
    private final CustomMessageListener iWk = new CustomMessageListener(2921461) { // from class: com.baidu.tieba.homepage.personalize.e.33
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (e.this.iga != null) {
                e.this.cBM();
            }
        }
    };
    private final CustomMessageListener iWl = new CustomMessageListener(2921486) { // from class: com.baidu.tieba.homepage.personalize.e.34
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data = customResponsedMessage.getData();
            switch (data instanceof Integer ? ((Integer) data).intValue() : 0) {
                case 2:
                    new BdTopToast(e.this.mPageContext.getPageActivity(), 2000).xd(true).SP(e.this.mPageContext.getPageActivity().getString(R.string.youngster_open_title)).aF((ViewGroup) e.this.mPageContext.getPageActivity().findViewById(R.id.maintabContainer));
                    e.this.pV(true);
                    return;
                case 3:
                    new BdTopToast(e.this.mPageContext.getPageActivity(), 2000).xd(true).SP(e.this.mPageContext.getPageActivity().getString(R.string.youngster_close_title)).aF((ViewGroup) e.this.mPageContext.getPageActivity().findViewById(R.id.maintabContainer));
                    e.this.pV(false);
                    return;
                case 4:
                default:
                    if (com.baidu.tbadk.youngster.b.b.bAo()) {
                        e.this.pV(true);
                        return;
                    }
                    return;
                case 5:
                    new BdTopToast(e.this.mPageContext.getPageActivity(), 2000).xd(true).SP(e.this.mPageContext.getPageActivity().getString(R.string.youngster_reset_title)).aF((ViewGroup) e.this.mPageContext.getPageActivity().findViewById(R.id.maintabContainer));
                    e.this.pV(true);
                    return;
            }
        }
    };
    private CustomMessageListener iuq = new CustomMessageListener(CmdConfigCustom.PB_ACTION_PRAISE) { // from class: com.baidu.tieba.homepage.personalize.e.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            bw bwVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bw) && e.this.iVS != null && y.getCount(e.this.iVS.thread_list) != 0 && (bwVar = (bw) customResponsedMessage.getData()) != null && bwVar.bfj() != null && bwVar.getId() != null && y.getCount(e.this.iVS.thread_list) != 0) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < e.this.iVS.thread_list.size()) {
                        ThreadInfo threadInfo = e.this.iVS.thread_list.get(i2);
                        if (threadInfo == null || threadInfo.id.longValue() != com.baidu.adp.lib.f.b.toLong(bwVar.getId(), -1L)) {
                            i = i2 + 1;
                        } else {
                            ThreadInfo.Builder builder = new ThreadInfo.Builder(threadInfo);
                            Zan.Builder builder2 = new Zan.Builder(builder.zan);
                            builder2.num = Integer.valueOf((int) bwVar.bfj().getNum());
                            builder.zan = builder2.build(true);
                            e.this.iVS.thread_list.set(i2, builder.build(true));
                            return;
                        }
                    } else {
                        return;
                    }
                }
            }
        }
    };
    private CustomMessageListener iWm = new CustomMessageListener(CmdConfigCustom.CMD_LIVE_VIDEO_CLOSED_QUERY_RESPONSED) { // from class: com.baidu.tieba.homepage.personalize.e.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            bw bwVar;
            if (customResponsedMessage.getOrginalMessage() instanceof LiveRoomClosedQueryMessage) {
                List<Long> ids = ((LiveRoomClosedQueryMessage) customResponsedMessage.getOrginalMessage()).getIds();
                List<Object> originData = ((LiveRoomClosedQueryMessage) customResponsedMessage.getOrginalMessage()).getOriginData();
                if (!y.isEmpty(e.this.mDataList) && !y.isEmpty(ids) && !y.isEmpty(originData)) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= originData.size()) {
                            break;
                        }
                        if ((originData.get(i2) instanceof bw) && (bwVar = (bw) originData.get(i2)) != null && bwVar.bfS() != null && ids.contains(Long.valueOf(bwVar.bfS().live_id))) {
                            e.this.mDataList.remove(bwVar);
                        }
                        i = i2 + 1;
                    }
                    if (e.this.iVi != null) {
                        e.this.iVi.bX(new ArrayList(e.this.mDataList));
                    }
                }
            }
        }
    };
    private CustomMessageListener ena = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.homepage.personalize.e.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int intValue;
            if ((customResponsedMessage instanceof UpdateAttentionMessage) && e.this.iVS != null && !y.isEmpty(e.this.iVS.thread_list)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid)) {
                    int i = 0;
                    while (true) {
                        if (i >= e.this.iVS.thread_list.size()) {
                            break;
                        }
                        ThreadInfo threadInfo = e.this.iVS.thread_list.get(i);
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
                            e.this.iVS.thread_list.set(i, builder.build(true));
                        }
                    }
                    e.this.a(updateAttentionMessage);
                }
            }
        }
    };
    private CustomMessageListener iOF = new CustomMessageListener(0) { // from class: com.baidu.tieba.homepage.personalize.e.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long) && e.this.iVS != null && e.this.iVS.hot_recomforum != null && !y.isEmpty(e.this.iVS.hot_recomforum.tab_list)) {
                long longValue = ((Long) customResponsedMessage.getData()).longValue();
                DiscoverHotForum.Builder builder = new DiscoverHotForum.Builder(e.this.iVS.hot_recomforum);
                if (com.baidu.tieba.homepage.concern.c.a(builder, longValue, customResponsedMessage.getCmd() == 2001335)) {
                    e.this.iVS.hot_recomforum = builder.build(true);
                    e.this.c(new DataRes.Builder(e.this.iVS.build(true)));
                }
            }
        }
    };
    private String iWn = "lastReadReadPositionKey";
    private int iWo = 0;
    private d iWq = new d() { // from class: com.baidu.tieba.homepage.personalize.e.16
        @Override // com.baidu.tieba.homepage.personalize.d
        public void Ag(final int i) {
            if (e.this.iWp == null) {
                e.this.iWp = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.e.16.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (e.this.iga.getHandler() != null) {
                            e.this.iga.requestFocusFromTouch();
                            if (i <= e.this.iga.getCount() - 1) {
                                e.this.iga.setSelection(i);
                            }
                        }
                    }
                };
            }
            e.this.iga.removeCallbacks(e.this.iWp);
            e.this.iga.post(e.this.iWp);
        }
    };
    private CustomMessageListener iWr = new CustomMessageListener(2016569) { // from class: com.baidu.tieba.homepage.personalize.e.19
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && e.this.iWa != null) {
                e.this.mDataList.remove(e.this.iWa);
                e.this.iVi.bX(new ArrayList(e.this.mDataList));
                com.baidu.tbadk.core.sharedPref.b.bjf().putLong("key_maintab_banner_close_time", System.currentTimeMillis());
            }
        }
    };
    private CustomMessageListener hII = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.homepage.personalize.e.20
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.g(customResponsedMessage);
            if (e.this.hIT != null && e.this.iTI) {
                e.this.hIT.a(e.this.icc, e.this.fFV, e.this.icM, true);
            }
        }
    };
    private CustomMessageListener hIJ = new CustomMessageListener(CmdConfigCustom.CMD_THREAD_NOT_EXIST_WHEN_ENTER_PB) { // from class: com.baidu.tieba.homepage.personalize.e.21
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.g(customResponsedMessage);
        }
    };
    private CustomMessageListener iuE = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.homepage.personalize.e.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && e.this.iVS != null && y.getCount(e.this.iVS.thread_list) != 0) {
                String str = (String) customResponsedMessage.getData();
                e.this.h(str, e.this.mDataList);
                e.this.Kl(str);
                if (e.this.iVi != null) {
                    e.this.iVi.bX(new ArrayList(e.this.mDataList));
                }
                if (e.this.hIT != null && e.this.iTI) {
                    e.this.hIT.a(e.this.icc, e.this.fFV, e.this.icM, true);
                }
            }
        }
    };
    private CustomMessageListener ibJ = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.homepage.personalize.e.24
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            am cAZ;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent)) {
                KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24 && (cAZ = e.this.cAZ()) != null && cAZ.tW() != null) {
                    cAZ.tW().b(new a.C0096a(3));
                }
            }
        }
    };
    private com.baidu.adp.framework.listener.a iWs = new com.baidu.adp.framework.listener.a(1003065, CmdConfigSocket.CMD_TOPIC_BLESS) { // from class: com.baidu.tieba.homepage.personalize.e.25
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
                        if ((qVar instanceof com.baidu.tieba.homepage.topic.topictab.b.a) && (bVar = ((com.baidu.tieba.homepage.topic.topictab.b.a) qVar).jdr) != null && longValue == bVar.pkId) {
                            bVar.userPkId = j2;
                            return;
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener ibK = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.homepage.personalize.e.26
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            List<q> dataList = e.this.iVi.getDataList();
            if (!y.isEmpty(dataList)) {
                for (q qVar : dataList) {
                    if (qVar instanceof l) {
                        l lVar = (l) qVar;
                        if (lVar.edd != 0 && lVar.dXg != null) {
                            int[] imageWidthAndHeight = lVar.dXg.getImageWidthAndHeight();
                            lVar.edd = imageWidthAndHeight[0];
                            lVar.ede = imageWidthAndHeight[1];
                        }
                    }
                }
            }
            com.baidu.adp.lib.f.e.mX().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.personalize.e.26.1
                @Override // java.lang.Runnable
                public void run() {
                    e.this.iVi.notifyDataSetChanged();
                    if (!e.this.mIsBackground && e.this.iTI) {
                        e.this.hIT.a(e.this.icc, e.this.fFV, e.this.icM, true);
                    }
                }
            }, 500L);
        }
    };
    private CustomMessageListener hIK = new CustomMessageListener(2921453) { // from class: com.baidu.tieba.homepage.personalize.e.27
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.data.be)) {
                com.baidu.tbadk.core.data.be beVar = (com.baidu.tbadk.core.data.be) customResponsedMessage.getData();
                if (beVar.ecc == 1) {
                    int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
                    int equipmentHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst());
                    float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
                    int i = au.bkm().bkn() ? 2 : 1;
                    RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
                    requestGetMyPostNetMessage.setTag(e.this.iWg);
                    requestGetMyPostNetMessage.setParams(com.baidu.adp.lib.f.b.toLong(beVar.tid, 0L), 0L, 0L, equipmentWidth, equipmentHeight, f, i);
                    requestGetMyPostNetMessage.setBFrom("push");
                    MessageManager.getInstance().sendMessage(requestGetMyPostNetMessage);
                }
            }
        }
    };
    private final com.baidu.adp.framework.listener.a hIL = new com.baidu.adp.framework.listener.a(1003010, CmdConfigSocket.CMD_GET_MY_POST) { // from class: com.baidu.tieba.homepage.personalize.e.28
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            GetMyPostResIdl getMyPostResIdl = null;
            if (responsedMessage instanceof GetMyPostHttpResponseMessage) {
                getMyPostResIdl = ((GetMyPostHttpResponseMessage) responsedMessage).getResponseData();
            } else if (responsedMessage instanceof GetMyPostSocketResponseMessage) {
                getMyPostResIdl = ((GetMyPostSocketResponseMessage) responsedMessage).getResponseData();
            }
            if (getMyPostResIdl != null && getMyPostResIdl.data != null && getMyPostResIdl.data.thread_info != null) {
                e.this.iWh = getMyPostResIdl.data.thread_info;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921455));
            }
        }
    };
    private CustomMessageListener iWt = new CustomMessageListener(2921482) { // from class: com.baidu.tieba.homepage.personalize.e.29
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (com.baidu.tbadk.coreExtra.c.a.w(TbadkCoreApplication.getInst(), 1)) {
                com.baidu.tbadk.coreExtra.c.a.a(e.this.mPageContext, 7, 0L);
            }
        }
    };

    /* loaded from: classes21.dex */
    public interface a {
        void B(int i, int i2, int i3, int i4);

        void Q(int i, int i2, int i3);

        void cBz();

        void onError(int i, String str);

        void onSuccess();
    }

    public void pS(boolean z) {
        this.iWb = z;
        if (this.hIO != null && !z) {
            this.hIO.hideTip();
        }
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.iUW = scrollFragmentTabHost;
        if (this.iUW != null) {
            this.iUW.setOnTabSelectedListener(new ScrollFragmentTabHost.b() { // from class: com.baidu.tieba.homepage.personalize.e.1
                @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.b
                public void Aq(int i) {
                    if (e.this.iUW.Ap(i) != 1 && e.this.hIO != null) {
                        e.this.hIO.hideTip();
                    }
                }
            });
        }
    }

    public void setTabInForeBackgroundState(boolean z) {
        this.mIsBackground = z;
    }

    public void oz(boolean z) {
        boolean z2 = false;
        this.mIsBackground = z;
        if (this.iUW != null) {
            this.iUW.oz(z);
        }
        if (this.hIT != null) {
            this.hIT.rP(!z);
            am cAZ = cAZ();
            if (cAZ != null && cAZ.tW() != null) {
                z2 = cAZ.tW().b(new a.C0096a(8, Boolean.valueOf(z)));
            }
            if (!z2) {
                if (z) {
                    this.hIT.cAY();
                } else if (this.iTI) {
                    this.hIT.a(this.icc, this.fFV, this.icM, true);
                }
            }
        }
    }

    public e(TbPageContext<?> tbPageContext, BdTypeRecyclerView bdTypeRecyclerView, af afVar, BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout) {
        this.iWf = 0;
        this.mPageContext = tbPageContext;
        this.iWf = com.baidu.tbadk.core.sharedPref.b.bjf().getInt("key_personalized_refresh_type", 0);
        this.iOr = bigdaySwipeRefreshLayout;
        this.iga = bdTypeRecyclerView;
        this.iga.setOnTouchListener(this.eYy);
        if (com.baidu.tbadk.youngster.b.b.bAo()) {
            pV(true);
        }
        this.iBM = new com.baidu.tieba.f.a();
        this.iBM.a(this.hyK);
        this.iVi = afVar;
        this.iVV = new com.baidu.tieba.homepage.personalize.model.a();
        this.iVP = com.baidu.tbadk.core.sharedPref.b.bjf().getLong("recommend_frs_cache_time", 1800L) * 1000;
        bdTypeRecyclerView.setOnScrollListener(this.mOnScrollListener);
        this.hIO = new be();
        cBK();
        this.hIT = new i(this.mPageContext, this.iga);
        this.hIT.Gi(1);
        this.hIT.Gh(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.iVQ = new b(this.mDataList, this.iVi);
        this.hIP = new SmartBubbleAnimatedView(tbPageContext.getContext());
        this.hIP.setLayoutParams(new FrameLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(tbPageContext.getContext(), R.dimen.tbds83)));
        cBA();
        this.ibK.setTag(this.mPageContext.getUniqueId());
        MessageManager.getInstance().registerListener(this.ibK);
        if (MessageManager.getInstance().findTask(1003010) == null) {
            HomePageStatic.czs();
        }
        this.hIL.setTag(this.iWg);
        if (this.hIL.getHttpMessageListener() != null) {
            this.hIL.getHttpMessageListener().setSelfListener(true);
        }
        if (this.hIL.getSocketMessageListener() != null) {
            this.hIL.getSocketMessageListener().setSelfListener(true);
        }
        MessageManager.getInstance().registerListener(this.hIL);
        MessageManager.getInstance().registerListener(this.hIK);
        MessageManager.getInstance().registerListener(this.iWt);
    }

    private void cBA() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2016323, new CustomMessageTask.CustomRunnable<Boolean>() { // from class: com.baidu.tieba.homepage.personalize.e.35
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Boolean> customMessage) {
                am cAZ = e.this.cAZ();
                return (cAZ == null || cAZ.tW() == null) ? new CustomResponsedMessage<>(2016323, false) : new CustomResponsedMessage<>(2016323, Boolean.valueOf(cAZ.tW().b(new a.C0096a(6))));
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private boolean cBB() {
        return com.baidu.tbadk.core.sharedPref.b.bjf().getBoolean(cBD(), true);
    }

    private void cBC() {
        com.baidu.tbadk.core.sharedPref.b.bjf().putBoolean(cBD(), false);
    }

    private String cBD() {
        return "key_rec_pfirst_load_" + TbadkCoreApplication.getCurrentAccount() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + TbConfig.getVersion();
    }

    public void setRecommendFrsNavigationAnimDispatcher(ab abVar) {
        if (abVar != null) {
            this.eYx = abVar.bwQ();
            this.eKp = abVar.bwR();
        }
    }

    public void showFloatingView() {
        if (this.eYx != null) {
            this.eYx.showFloatingView(true);
        }
    }

    public void update() {
        com.baidu.tieba.homepage.framework.a.czV().u(System.currentTimeMillis(), 1);
        this.mPn = 1;
        this.iVZ = true;
        if (this.mDataList.size() == 0 && !cBB()) {
            if (!this.iOA) {
                bcQ();
                return;
            }
            return;
        }
        bcP();
    }

    public void cA(int i, int i2) {
        bw bwVar;
        if (!y.isEmpty(this.mDataList) && this.mDataList.size() > i) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            while (i < this.mDataList.size() && i <= i2) {
                if (this.mDataList.get(i).getType().getId() == bw.edD.getId() && (bwVar = (bw) this.mDataList.get(i)) != null && bwVar.bfS() != null) {
                    arrayList.add(Long.valueOf(bwVar.bfS().live_id));
                    arrayList2.add(bwVar);
                }
                i++;
            }
            if (!y.isEmpty(arrayList)) {
                MessageManager.getInstance().sendMessage(new LiveRoomClosedQueryMessage(arrayList, arrayList2));
            }
        }
    }

    public void cBE() {
        if (this.hIT != null && !this.mIsBackground && this.iTI) {
            this.hIT.a(this.icc, this.fFV, this.icM, true);
        }
        if (this.iVX) {
            if (this.iOr != null && !this.iOr.blF()) {
                if (this.iLX) {
                    com.baidu.tieba.s.c.dzC().b(this.iWd, false);
                    if (pU(false)) {
                        cB(3, this.iVU);
                    } else if (this.iVY > 0) {
                        cB(2, this.iVU);
                    }
                } else if (!this.iLX && this.iVU == 0) {
                    cB(2, 0);
                }
            }
            this.iVX = false;
            this.iLX = false;
            this.iVY = 0;
            if (this.iVZ) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
            }
            this.iVZ = false;
        }
    }

    public void bGU() {
        if (isLoading()) {
            com.baidu.tieba.homepage.framework.a.czV().u(0L, 1);
        } else if (this.iVR != null) {
            cBG();
            this.mPn++;
            setIsLoading(true);
            this.iVR.B(this.mPn, (this.iVS == null || this.iVS.thread_list == null) ? 0 : this.iVS.thread_list.size(), pT(false), 0);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:94:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(boolean z, boolean z2, DataRes dataRes, int i, String str) {
        boolean z3;
        int size;
        if (z) {
            g.cBR();
        }
        if (this.iVV != null && this.iVV.cCl() && !z && (dataRes == null || y.isEmpty(dataRes.thread_list))) {
            if (dataRes == null) {
                DataRes.Builder builder = new DataRes.Builder();
                builder.thread_list = new ArrayList();
                dataRes = builder.build(false);
            }
            if (dataRes.thread_list != null) {
                List<ThreadInfo> cCm = this.iVV.cCm();
                dataRes.thread_list.addAll(cCm);
                if (cCm != null) {
                    cCm.clear();
                }
                z3 = true;
                size = (this.iVS != null || this.iVS.thread_list == null) ? 0 : this.iVS.thread_list.size();
                if (z && i == 0 && dataRes != null && y.isEmpty(dataRes.thread_list)) {
                    if (this.iVR != null) {
                        this.iVR.cBz();
                    }
                    setIsLoading(false);
                    if (this.iOr != null) {
                        this.iOr.setRefreshing(false);
                        return;
                    }
                    return;
                }
                if (this.iWh != null) {
                    DataRes.Builder builder2 = new DataRes.Builder(dataRes);
                    builder2.thread_list.add(0, this.iWh);
                    dataRes = builder2.build(false);
                    if (this.iVS != null && !y.isEmpty(this.iVS.thread_list)) {
                        Iterator<ThreadInfo> it = this.iVS.thread_list.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            ThreadInfo next = it.next();
                            if (next != null && next.tid != null && this.iWh.tid != null && next.tid.longValue() == this.iWh.tid.longValue()) {
                                this.iVS.thread_list.remove(next);
                                break;
                            }
                        }
                    }
                    this.iWh = null;
                }
                if ((z3 && i != 0) || dataRes == null || !a(true, z, z2, dataRes)) {
                    this.iVX = false;
                    if (this.mDataList.size() > 0) {
                        if (this.iVR != null) {
                            this.iVR.onError(1, str);
                        }
                    } else if (this.iVR != null) {
                        this.iVR.onError(2, str);
                    }
                } else {
                    cBC();
                    if (this.iVR != null) {
                        com.baidu.tbadk.core.sharedPref.b.bjf().putLong(SharedPrefConfig.RECOMMEND_FRS_REFRESH_TIME + TbadkCoreApplication.getCurrentAccount(), System.currentTimeMillis());
                        this.iVR.onSuccess();
                    }
                    this.iVX = true;
                    this.iLX = z;
                    this.iVY = size;
                    civ();
                }
                setIsLoading(false);
                if (this.iOr == null) {
                    f.e cBF = cBF();
                    if (this.iOr.blF() && cBF != null) {
                        this.iOr.c(cBF);
                        return;
                    } else {
                        this.iOr.setRefreshing(false);
                        return;
                    }
                }
                return;
            }
        }
        z3 = false;
        if (this.iVS != null) {
        }
        if (z) {
        }
        if (this.iWh != null) {
        }
        if (z3) {
        }
        cBC();
        if (this.iVR != null) {
        }
        this.iVX = true;
        this.iLX = z;
        this.iVY = size;
        civ();
        setIsLoading(false);
        if (this.iOr == null) {
        }
    }

    private f.e cBF() {
        int i;
        String feedText;
        if (!this.iVX || this.iOr == null || !this.iOr.blF() || cBJ()) {
            return null;
        }
        int i2 = this.iVU;
        if (this.iLX) {
            com.baidu.tieba.s.c.dzC().b(this.iWd, false);
            if (pU(false)) {
                i = 3;
            } else {
                i = this.iVY > 0 ? 2 : 0;
            }
        } else if (this.iLX || this.iVU != 0) {
            return null;
        } else {
            i2 = 0;
            i = 2;
        }
        if (this.iUW != null) {
            this.hIO.crA();
        }
        if (this.iUW != null && this.iUW.getCurrentTabType() != 1) {
            this.hIO.hideTip();
            return null;
        } else if (!this.iWb) {
            this.hIO.hideTip();
            return null;
        } else {
            this.iVT = i;
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
                this.ifg = 1000;
            } else {
                this.ifg = 0;
            }
            return new f.e(feedText, this.ifg);
        }
    }

    public void pG(boolean z) {
        if (z) {
            this.iVi.notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        if (this.hIT != null) {
            this.hIT.destroy();
        }
        if (this.hIO != null) {
            this.hIO.onDestroy();
        }
        if (this.iVQ != null) {
            this.iVQ.onDestroy();
        }
        if (this.iga != null) {
            this.iga.removeCallbacks(this.iWp);
        }
        MessageManager.getInstance().unRegisterTask(2016323);
        MessageManager.getInstance().unRegisterListener(this.ibK);
        MessageManager.getInstance().unRegisterListener(this.hIK);
        MessageManager.getInstance().unRegisterListener(this.hIL);
        MessageManager.getInstance().unRegisterListener(this.iWt);
    }

    public void onPause() {
        c.d(this.iga);
        Ay(this.iWo);
        if (this.iVW != null) {
            this.iVW.bvk();
        }
    }

    private void bcP() {
        if (this.iVR != null) {
            this.iVR.Q((this.iVS == null || this.iVS.thread_list == null || cBI()) ? 0 : this.iVS.thread_list.size(), pT(true), 0);
        }
    }

    public int pT(boolean z) {
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
                if (!(qVar instanceof com.baidu.tieba.homepage.personalize.data.a) || qVar.getType() == AdvertAppInfo.dYi) {
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
                if ((qVar2 instanceof com.baidu.tieba.homepage.personalize.data.a) && qVar2.getType() != AdvertAppInfo.dYi) {
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
        this.iOA = true;
        if (dataRes != null) {
            if (a(false, true, true, dataRes) && !cBI()) {
                if (this.iVR != null) {
                    this.iVR.onSuccess();
                    Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler() { // from class: com.baidu.tieba.homepage.personalize.e.2
                        @Override // android.os.MessageQueue.IdleHandler
                        public boolean queueIdle() {
                            e.this.bvp();
                            return false;
                        }
                    });
                }
                if (TbSingleton.getInstance().getForceRefreshHomeRecommend()) {
                    bcP();
                    TbSingleton.getInstance().setForceRefreshHomeRecommend(false);
                    return;
                }
                return;
            }
            bcP();
            return;
        }
        bcP();
    }

    public void bvp() {
        long Ae = com.baidu.tieba.homepage.framework.a.czV().Ae(1) + com.baidu.tieba.homepage.framework.a.czV().getCreateTime();
        long Ac = com.baidu.tieba.homepage.framework.a.czV().Ac(1);
        if (Ac > 0) {
            Ae = System.currentTimeMillis() - Ac;
        }
        n.bvx().dA(Ae);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.util.Set] */
    private void i(List<q> list, int i) {
        AdvertAppInfo cfH;
        AdvertAppInfo cfH2;
        if (!y.isEmpty(list)) {
            Set<q> Qb = com.baidu.tieba.recapp.report.a.Qb("NEWINDEX");
            HashSet hashSet = Qb == null ? new HashSet() : Qb;
            HashSet hashSet2 = new HashSet();
            for (q qVar : list) {
                if (qVar != null) {
                    for (q qVar2 : hashSet) {
                        if ((qVar instanceof com.baidu.tieba.card.data.e) && (cfH2 = ((com.baidu.tieba.card.data.e) qVar).cfH()) != null && qVar2 != null && (qVar2 instanceof AdvertAppInfo) && qVar2.hashCode() == cfH2.hashCode()) {
                            cfH2.advertAppContext = ((AdvertAppInfo) qVar2).advertAppContext;
                        }
                    }
                    if (qVar != null && (qVar instanceof com.baidu.tieba.card.data.e) && (cfH = ((com.baidu.tieba.card.data.e) qVar).cfH()) != null && cfH.advertAppContext == null) {
                        cfH.advertAppContext = new com.baidu.tbadk.core.data.b();
                        cfH.advertAppContext.page = "NEWINDEX";
                        cfH.advertAppContext.pn = this.mPn;
                        cfH.advertAppContext.extensionInfo = cfH.extensionInfo;
                        cfH.advertAppContext.Yw = false;
                        hashSet2.add(cfH);
                    }
                }
            }
            hashSet.addAll(hashSet2);
            com.baidu.tieba.recapp.report.a.b("NEWINDEX", hashSet);
            if (hashSet2.size() > 0) {
                com.baidu.tieba.s.c.dzC().b(this.iWd, com.baidu.tieba.s.a.b(PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE, "common_fill", true, hashSet2.size()));
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
        if (this.iWf == 1) {
            if (z2 && (dataRes.thread_list.size() >= 6 || cBI())) {
                cBH();
                this.iVS = null;
            }
        } else if (z2 && cBI()) {
            this.iVS = null;
        }
        int size = z2 ? 0 : this.mDataList.size();
        DataRes.Builder builder = new DataRes.Builder(dataRes);
        this.mDataList.clear();
        com.baidu.tieba.homepage.personalize.model.c a2 = this.iVV.a(z, this.iVS, builder, z2 ? 0 : 1);
        if (a2 == null) {
            list = null;
            i = 0;
        } else {
            List<q> list2 = a2.fnr;
            this.iVU = a2.iYV;
            int i2 = a2.iYW;
            a2.iYW = 0;
            list = list2;
            i = i2;
        }
        if (list != null) {
            this.mDataList.addAll(list);
            i(list, size);
            a(z2 ? 0 : 1, list, size);
            if (this.iVZ) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
            }
        }
        if (this.iVS == null) {
            this.iVS = builder;
            this.iVQ.dr(this.iVS.thread_list);
        }
        if (this.mDataList.size() == 0) {
            z4 = false;
        } else {
            if (z2) {
                if (dataRes.live_answer != null) {
                    this.iWa = new h();
                    this.iWa.a(dataRes.live_answer);
                    this.iVS.live_answer = dataRes.live_answer;
                } else if (z) {
                    this.iWa = null;
                    this.iVS.live_answer = null;
                }
                this.iWc = dataRes.float_info;
                this.iVS.float_info = dataRes.float_info;
            }
            long j = com.baidu.tbadk.core.sharedPref.b.bjf().getLong("key_maintab_banner_close_time", 0L);
            if (this.iWa != null && !at.isTaday(j)) {
                this.mDataList.add(0, this.iWa);
            }
            LinkedList linkedList = new LinkedList(this.mDataList);
            this.iVi.setFromCDN(dataRes.is_new_url != null && dataRes.is_new_url.intValue() == 1);
            this.iVi.j(linkedList, i);
            z4 = true;
            if (this.hIT != null && this.iTI) {
                this.hIT.a(this.icc, this.fFV, this.icM, true);
            }
        }
        com.baidu.tieba.homepage.framework.a.czV().s(System.currentTimeMillis() - currentTimeMillis, 1);
        long Af = com.baidu.tieba.homepage.framework.a.czV().Af(1);
        if (Af > 0) {
            com.baidu.tieba.homepage.framework.a.czV().t(System.currentTimeMillis() - Af, 1);
            com.baidu.tieba.homepage.framework.a.czV().u(0L, 1);
        }
        if (dataRes.anti != null && dataRes.anti.block_pop_info != null) {
            com.baidu.tieba.ueg.d.d(dataRes.anti.block_pop_info);
        }
        bg bgVar = new bg();
        bgVar.a(dataRes.recom_post_topic);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_REFRESH_TOPIC_TIP, bgVar));
        return z4;
    }

    private void cBG() {
        List<q> list;
        int i;
        if (y.getCount(this.mDataList) >= this.iVV.cCh() - 40) {
            com.baidu.tieba.homepage.personalize.model.c a2 = this.iVV.a(true, this.iVS, null, 1);
            if (a2 != null) {
                List<q> list2 = a2.fnr;
                i = a2.iYW;
                a2.iYW = 0;
                list = list2;
            } else {
                list = null;
                i = 0;
            }
            if (list != null) {
                this.mDataList.clear();
                this.mDataList.addAll(list);
                this.iVi.j(new LinkedList(this.mDataList), i);
            }
        }
    }

    private void bcQ() {
        this.iOA = true;
        ae.a(new ad<DataRes>() { // from class: com.baidu.tieba.homepage.personalize.e.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.ad
            /* renamed from: cBN */
            public DataRes doInBackground() {
                com.baidu.adp.lib.cache.l<byte[]> dv = com.baidu.tbadk.core.c.a.bhV().dv("tb.rec_frs_update", TbadkCoreApplication.getCurrentAccount());
                if (dv == null) {
                    return null;
                }
                byte[] bArr = dv.get("0");
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
        }, new m<DataRes>() { // from class: com.baidu.tieba.homepage.personalize.e.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.m
            /* renamed from: b */
            public void onReturnDataInUI(DataRes dataRes) {
                e.this.a(dataRes);
            }
        });
    }

    private void civ() {
        if (this.iVS != null) {
            DataRes.Builder builder = new DataRes.Builder(this.iVS.build(true));
            if (builder.thread_list != null && builder.thread_list.size() > 30) {
                builder.thread_list = builder.thread_list.subList(0, 30);
            }
            a(builder, builder.thread_list != null ? builder.thread_list.size() : 0);
            a(builder);
            b(builder);
            c(builder);
        }
    }

    private void cBH() {
        if (this.iVS != null) {
            final DataRes.Builder builder = new DataRes.Builder(this.iVS.build(true));
            if (builder.thread_list != null && builder.thread_list.size() > 50) {
                builder.thread_list = builder.thread_list.subList(0, 50);
            }
            a(builder, builder.thread_list != null ? builder.thread_list.size() : 0);
            ae.a(new ad<Object>() { // from class: com.baidu.tieba.homepage.personalize.e.5
                @Override // com.baidu.tbadk.util.ad
                public Object doInBackground() {
                    DataRes.Builder builder2 = new DataRes.Builder(builder.build(true));
                    e.this.iVQ.ds(builder2.thread_list);
                    try {
                        com.baidu.tbadk.core.c.a.bhV().dv("tb.rec_old_data", TbadkCoreApplication.getCurrentAccount()).setForever("0", builder2.build(true).toByteArray());
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
    public void Kl(String str) {
        if (!TextUtils.isEmpty(str) && this.iVS != null && this.iVS.banner_list != null && this.iVS.banner_list.app != null && this.iVS.banner_list.app.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (App app : this.iVS.banner_list.app) {
                if (app != null && str.equals(app.id)) {
                    arrayList.add(app);
                }
            }
            BannerList.Builder builder = new BannerList.Builder(this.iVS.banner_list);
            if (builder.app != null) {
                builder.app.removeAll(arrayList);
            }
            this.iVS.banner_list = builder.build(false);
            DataRes.Builder builder2 = new DataRes.Builder(this.iVS.build(true));
            builder2.banner_list = builder.build(true);
            c(builder2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final DataRes.Builder builder) {
        ae.a(new ad<Object>() { // from class: com.baidu.tieba.homepage.personalize.e.6
            @Override // com.baidu.tbadk.util.ad
            public Object doInBackground() {
                DataRes.Builder builder2 = new DataRes.Builder(builder.build(true));
                e.this.iVQ.ds(builder2.thread_list);
                try {
                    com.baidu.tbadk.core.c.a.bhV().dv("tb.rec_frs_update", TbadkCoreApplication.getCurrentAccount()).setForever("0", builder2.build(true).toByteArray());
                    return null;
                } catch (Exception e) {
                    BdLog.e(e);
                    return null;
                }
            }
        }, null);
    }

    private boolean cBI() {
        return pU(true);
    }

    private boolean pU(boolean z) {
        long j = com.baidu.tbadk.core.sharedPref.b.bjf().getLong(SharedPrefConfig.RECOMMEND_FRS_REFRESH_TIME + TbadkCoreApplication.getCurrentAccount(), 0L);
        return j == 0 ? z : Math.abs(System.currentTimeMillis() - j) > this.iVP;
    }

    public void a(a aVar) {
        this.iVR = aVar;
    }

    private boolean isLoading() {
        return this.mIsLoading;
    }

    private void setIsLoading(boolean z) {
        this.mIsLoading = z;
    }

    public void cBw() {
        boolean z = true;
        com.baidu.tbadk.coreExtra.data.b activityPrizeData = TbadkCoreApplication.getInst().getActivityPrizeData();
        if (activityPrizeData.isSwitchTurn() && !StringUtils.isNull(activityPrizeData.getFeedText())) {
            String currentDay = UtilHelper.getCurrentDay();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            String str = "";
            if (!StringUtils.isNull(currentAccount)) {
                String string = com.baidu.tbadk.core.sharedPref.b.bjf().getString(SharedPrefConfig.ACTIVITY_PRIZE_FEED_TEXT_TIME, "");
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
                    cB(4, 0);
                    com.baidu.tbadk.core.sharedPref.b.bjf().putString(SharedPrefConfig.ACTIVITY_PRIZE_FEED_TEXT_TIME, str);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pV(boolean z) {
        boolean z2 = com.baidu.tbadk.core.sharedPref.b.bjf().getBoolean("key_youngster_homgpage_top_view_closed", false);
        if (this.iga != null && !z2) {
            if (z) {
                if (this.iWe == null) {
                    this.iWe = new HomePageYoungsterTopView(this.mPageContext);
                    this.iWe.setOnDeleteClick(new HomePageYoungsterTopView.a() { // from class: com.baidu.tieba.homepage.personalize.e.7
                        @Override // com.baidu.tieba.homepage.personalize.view.HomePageYoungsterTopView.a
                        public void cBO() {
                            new BdTopToast(e.this.mPageContext.getPageActivity(), 2000).xd(true).SP(e.this.mPageContext.getPageActivity().getString(R.string.youngster_frs_top_toast)).aF((ViewGroup) e.this.mPageContext.getPageActivity().findViewById(R.id.maintabContainer));
                            e.this.pV(false);
                            com.baidu.tbadk.core.sharedPref.b.bjf().putBoolean("key_youngster_homgpage_top_view_closed", true);
                        }
                    });
                }
                this.iga.setHeaderView(this.iWe);
                this.iWe.setVisibility(0);
                this.iga.scrollToPosition(0);
            } else if (this.iWe != null) {
                this.iWe.setVisibility(8);
                this.iga.removeHeaderView(this.iWe);
            }
        }
    }

    private boolean cBJ() {
        return this.iWe != null && this.iWe.getVisibility() == 0;
    }

    private void cB(int i, int i2) {
        if (!cBJ()) {
            if (this.iUW != null) {
                this.hIO.crA();
            }
            if (this.iUW != null && this.iUW.getCurrentTabType() != 1) {
                this.hIO.hideTip();
            } else if (!this.iWb) {
                this.hIO.hideTip();
            } else {
                this.iVT = i;
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
                        this.ifg = 3000;
                    } else {
                        this.ifg = 2000;
                    }
                    this.hIP.evu = str;
                    this.hIP.ieZ = this.ifg;
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 49;
                    if (this.iUW != null) {
                        FrameLayout frameLayout = this.iUW.getFrameLayout();
                        frameLayout.removeView(this.hIP);
                        frameLayout.addView(this.hIP, layoutParams);
                        this.hIP.cry();
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(Long l) {
        if (this.iVS != null && this.iVS.thread_list != null) {
            List<ThreadInfo> list = this.iVS.thread_list;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                ThreadInfo threadInfo = list.get(i);
                if (threadInfo.tid.equals(l) && threadInfo.top_agree_post != null) {
                    ThreadInfo.Builder builder = new ThreadInfo.Builder(threadInfo);
                    builder.top_agree_post = null;
                    list.set(i, builder.build(true));
                    civ();
                    a(false, true, false, this.iVS.build(true));
                    return;
                }
            }
        }
    }

    public void o(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.iWd = bdUniqueId;
            if (this.iuq != null) {
                this.iuq.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.iuq);
            }
            if (this.iWj != null) {
                this.iWj.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.iWj);
            }
            this.iWk.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.iWk);
            this.ena.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.ena);
            this.iOF.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_LIKE_FORUM, this.iOF);
            MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_UNLIKE_FORUM, this.iOF);
            this.iWm.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.iWm);
            this.hII.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.hII);
            this.hIJ.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.hIJ);
            this.iuE.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.iuE);
            if (this.hIT != null) {
                this.hIT.setUniqueId(bdUniqueId);
            }
            this.iVQ.l(bdUniqueId);
            this.iWr.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.iWr);
            this.ibJ.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.ibJ);
            this.iWs.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.iWs);
            this.iWl.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.iWl);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(UpdateAttentionMessage updateAttentionMessage) {
        if (updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid)) {
            final String str = updateAttentionMessage.getData().toUid;
            final boolean z = updateAttentionMessage.getData().isAttention;
            ae.a(new ad<Boolean>() { // from class: com.baidu.tieba.homepage.personalize.e.13
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.baidu.tbadk.util.ad
                public Boolean doInBackground() {
                    int intValue;
                    try {
                        com.baidu.adp.lib.cache.l<byte[]> dv = com.baidu.tbadk.core.c.a.bhV().dv("tb.rec_frs_update", TbadkCoreApplication.getCurrentAccount());
                        if (dv == null) {
                            return false;
                        }
                        byte[] bArr = dv.get("0");
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
                        e.this.iVQ.ds(builder5.thread_list);
                        dv.setForever("0", builder5.build(true).toByteArray());
                        return true;
                    } catch (Exception e) {
                        BdLog.e(e);
                        return false;
                    }
                }
            }, new m<Boolean>() { // from class: com.baidu.tieba.homepage.personalize.e.14
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.m
                public void onReturnDataInUI(Boolean bool) {
                }
            });
        }
    }

    public void cBK() {
        this.hZR = new com.baidu.tieba.tbadkCore.data.f("new_index", null);
        this.hZR.dAj();
    }

    public void a(int i, List<q> list, int i2) {
        int i3;
        int i4;
        if (this.hZR != null) {
            if (i == 0) {
                this.hZR.dAj();
            }
            if (list != null && !list.isEmpty()) {
                int[] iArr = com.baidu.tieba.tbadkCore.data.f.mob;
                int i5 = 0;
                int i6 = 0;
                int i7 = 0;
                while (i7 < list.size() && i6 < iArr.length && (i3 = iArr[i6]) >= 0) {
                    if (list.get(i7) instanceof com.baidu.tieba.card.data.c) {
                        i4 = i5 + 1;
                        if (i4 == i3 - 1) {
                            if (i2 < i7 + 1) {
                                this.hZR.m43do(i3, i7 + 1);
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

    public void Ax(int i) {
        if ((this.hZR != null ? this.hZR.Ip(i) : -1) >= 0 && this.iga != null && this.iga.getData() != null && this.iga.getData().size() > i) {
            this.hZR.Iq(i);
        }
    }

    public i cqi() {
        return this.hIT;
    }

    public void pO(boolean z) {
        this.iTI = z;
    }

    public void Ay(final int i) {
        ae.a(new ad<Object>() { // from class: com.baidu.tieba.homepage.personalize.e.15
            @Override // com.baidu.tbadk.util.ad
            public Object doInBackground() {
                com.baidu.adp.lib.cache.l<String> dw = com.baidu.tbadk.core.c.a.bhV().dw(e.this.iWn, TbadkCoreApplication.getCurrentAccount());
                if (dw != null) {
                    dw.set(e.this.iWn, Integer.toString(i), 43200000L);
                    return null;
                }
                return null;
            }
        }, null);
    }

    public void a(final d dVar) {
        ae.a(new ad<String>() { // from class: com.baidu.tieba.homepage.personalize.e.17
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.ad
            /* renamed from: cBP */
            public String doInBackground() {
                com.baidu.adp.lib.cache.l<String> dw = com.baidu.tbadk.core.c.a.bhV().dw(e.this.iWn, TbadkCoreApplication.getCurrentAccount());
                if (dw != null) {
                    return dw.get(e.this.iWn);
                }
                return null;
            }
        }, new m<String>() { // from class: com.baidu.tieba.homepage.personalize.e.18
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.m
            /* renamed from: Km */
            public void onReturnDataInUI(String str) {
                if (dVar != null) {
                    dVar.Ag(com.baidu.adp.lib.f.b.toInt(str, 0));
                }
            }
        });
    }

    public void cBx() {
        c.e(this.iga);
    }

    public void cBL() {
        a(this.iWq);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cBM() {
        Iterator<q> it = this.mDataList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            } else if (it.next() instanceof com.baidu.tieba.homepage.personalize.data.g) {
                it.remove();
                break;
            }
        }
        if (this.iVS != null) {
            this.iVS.active_center = null;
            civ();
            if (this.iga != null) {
                List<Integer> f = f(this.iga);
                int intValue = f.get(0).intValue();
                int intValue2 = f.get(1).intValue();
                if (intValue != -1 && intValue2 != -1) {
                    this.iga.o(intValue, intValue2);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(CustomResponsedMessage<?> customResponsedMessage) {
        boolean z;
        String str;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.iVS != null && y.getCount(this.iVS.thread_list) != 0 && y.getCount(this.mDataList) != 0) {
            JSONObject jSONObject = (JSONObject) customResponsedMessage.getData();
            String optString = jSONObject.optString("tid");
            if (StringUtils.isNull(optString)) {
                String optString2 = jSONObject.optString(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_ID);
                if (this.iga != null && !TextUtils.isEmpty(optString2)) {
                    int i = 0;
                    while (true) {
                        if (i >= this.iga.getCount()) {
                            str = optString;
                            break;
                        }
                        q item = this.iga.getItem(i);
                        if (item instanceof k) {
                            k kVar = (k) item;
                            if (kVar.bcY() != null && kVar.bcY().bfS() != null && optString2.equals(String.valueOf(kVar.bcY().bfS().live_id))) {
                                str = kVar.bcY().getTid();
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
                    if (cVar.bcY() != null && cVar.bcY().getTid() != null) {
                        if (cVar.bcY().getTid().equals(optString)) {
                            it.remove();
                            z = true;
                            z2 = z;
                        } else if (z2) {
                            com.baidu.tieba.homepage.personalize.model.b.du(this.mDataList);
                            break;
                        }
                    }
                }
                z = z2;
                z2 = z;
            }
            if (this.iVS != null && this.iVS.thread_list != null) {
                long j = com.baidu.adp.lib.f.b.toLong(optString, 0L);
                int i2 = 0;
                while (true) {
                    if (i2 < this.iVS.thread_list.size()) {
                        ThreadInfo threadInfo = this.iVS.thread_list.get(i2);
                        if (threadInfo == null || threadInfo.tid == null || threadInfo.tid.longValue() != j) {
                            i2++;
                        } else {
                            com.baidu.tieba.homepage.personalize.b.d.a(threadInfo.tid.longValue(), i2, this.iVS.thread_list, this.mDataList);
                            this.iVS.thread_list.remove(i2);
                            civ();
                            break;
                        }
                    } else {
                        break;
                    }
                }
                if (this.iga != null) {
                    List<Integer> b = b(optString, this.iga);
                    int intValue = b.get(0).intValue();
                    int intValue2 = b.get(1).intValue();
                    if (intValue != -1 && intValue2 != -1) {
                        this.iga.o(intValue, intValue2);
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
                if (item instanceof com.baidu.tieba.homepage.personalize.data.g) {
                    com.baidu.tieba.homepage.personalize.data.g gVar = (com.baidu.tieba.homepage.personalize.data.g) item;
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
                    if (cVar.bcY() != null && cVar.bcY().getTid().equals(str)) {
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
                    advertAppInfo = ((com.baidu.tieba.homepage.personalize.data.a) next).cfH();
                } else {
                    if (next instanceof ak) {
                        ak akVar = (ak) next;
                        if (akVar.bdP() instanceof AdvertAppInfo.ILegoAdvert) {
                            advertAppInfo = ((AdvertAppInfo.ILegoAdvert) akVar.bdP()).getAdvertAppInfo();
                        }
                    }
                    advertAppInfo = advertAppInfo2;
                }
                if (advertAppInfo != null && str.equals(advertAppInfo.dYt)) {
                    it.remove();
                    advertAppInfo = null;
                }
                advertAppInfo2 = advertAppInfo;
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (this.hIP != null) {
            this.hIP.onChangeSkinType(i);
        }
        if (this.iWe != null) {
            this.iWe.onChangeSkinType();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public am cAZ() {
        if (this.hIT == null || this.hIT.dnC() == null || !(this.hIT.dnC().getTag() instanceof am)) {
            return null;
        }
        return (am) this.hIT.dnC().getTag();
    }
}
