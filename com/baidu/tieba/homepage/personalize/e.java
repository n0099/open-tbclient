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
import com.baidu.tieba.card.t;
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
import com.baidu.tieba.homepage.personalize.a.ag;
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
/* loaded from: classes22.dex */
public class e {
    private View.OnTouchListener feS;
    private aa fti;
    private com.baidu.tieba.tbadkCore.data.f iBo;
    private final BdTypeRecyclerView iHt;
    private be ikj;
    private SmartBubbleAnimatedView ikk;
    private i iko;
    private com.baidu.tieba.f.a jcY;
    private boolean jnk;
    private final BigdaySwipeRefreshLayout jpF;
    private final ag jwD;
    private ScrollFragmentTabHost jwr;
    private int jxA;
    private Runnable jxK;
    private final long jxk;
    private final b jxl;
    private DataRes.Builder jxn;
    private final com.baidu.tieba.homepage.personalize.model.a jxq;
    private int jxt;
    private h jxv;
    private BdUniqueId jxy;
    private HomePageYoungsterTopView jxz;
    private final TbPageContext<?> mPageContext;
    private a jxm = null;
    private final List<q> mDataList = new LinkedList();
    private int mPn = 1;
    private boolean mIsLoading = false;
    private boolean jpQ = false;
    private int jxo = 2;
    private int jxp = 0;
    private TextView mTipView = null;
    private int iGz = 2000;
    private com.baidu.tbadk.n.c jxr = null;
    private boolean iEj = false;
    private int iDz = 0;
    private int gch = 0;
    private boolean mIsBackground = false;
    private boolean jvd = true;
    private boolean jxs = false;
    private boolean jxu = false;
    private boolean jxw = true;
    private FloatInfo jxx = null;
    private BdUniqueId jxB = BdUniqueId.gen();
    private a.C0097a iBJ = new a.C0097a(2);
    private ThreadInfo jxC = null;
    private RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.e.12
        private int jxR = -1;
        private int jpZ = 0;
        private boolean jxS = false;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (e.this.jxr == null) {
                e.this.jxr = new com.baidu.tbadk.n.c();
                e.this.jxr.setSubType(1005);
                e.this.jxr.pageType = 1;
            }
            if (e.this.fti != null && !e.this.mIsBackground) {
                e.this.fti.m(recyclerView, i);
            }
            if (i == 0) {
                c.d(e.this.iHt);
                e.this.jxr.bzM();
                t.clQ().lE(true);
                com.baidu.tieba.a.d.bGs().dM("page_recommend", "show_");
                com.baidu.tieba.s.c.dGv().b(e.this.jxy, false);
                this.jxS = false;
                if (e.this.iko != null && e.this.jvd && !e.this.mIsBackground) {
                    e.this.iko.a(e.this.iDz, e.this.gch, e.this.iEj, 1);
                    return;
                }
                return;
            }
            e.this.jxr.bzL();
            if (i == 1) {
                if (e.this.ikj != null) {
                    e.this.ikj.hideTip();
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
            if (this.jpZ > i) {
                this.jxS = true;
            }
            if (e.this.fti != null && !e.this.mIsBackground) {
                e.this.fti.onScroll(this.jpZ, i);
            }
            this.jpZ = i;
            int i3 = (i + i2) - 1;
            if (!this.jxS && this.jxR != i3) {
                this.jxR = i3;
                e.this.Bw(this.jxR);
            }
            if (this.jxS && this.jxR != i) {
                this.jxR = i;
                e.this.Bw(this.jxR);
            }
            e.this.jxJ = i;
            e.this.iDz = i;
            e.this.gch = (i + i2) - 1;
            am cHN = e.this.cHN();
            if (cHN != null && cHN.tW() != null) {
                cHN.tW().b(e.this.iBJ);
            }
        }
    };
    private View.OnTouchListener ftj = new View.OnTouchListener() { // from class: com.baidu.tieba.homepage.personalize.e.23
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (e.this.feS != null) {
                e.this.feS.onTouch(view, motionEvent);
            }
            if (e.this.jcY != null) {
                e.this.jcY.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private a.InterfaceC0705a iac = new a.InterfaceC0705a() { // from class: com.baidu.tieba.homepage.personalize.e.30
        @Override // com.baidu.tieba.f.a.InterfaceC0705a
        public void H(int i, int i2) {
            e.this.iEj = false;
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0705a
        public void I(int i, int i2) {
            e.this.iEj = true;
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0705a
        public void ce(int i, int i2) {
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0705a
        public void J(int i, int i2) {
        }
    };
    private View.OnClickListener jxD = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.e.31
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (e.this.ikj != null) {
                e.this.ikj.hideTip();
            }
        }
    };
    private final CustomMessageListener jxE = new CustomMessageListener(CmdConfigCustom.CMD_RELOAD_HP_PERSONALIZED) { // from class: com.baidu.tieba.homepage.personalize.e.32
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (e.this.iHt != null) {
                e.this.iko.cHM();
                e.this.jvd = false;
                e.this.jpF.setRefreshing(true);
            }
        }
    };
    private final CustomMessageListener jxF = new CustomMessageListener(2921461) { // from class: com.baidu.tieba.homepage.personalize.e.33
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (e.this.iHt != null) {
                e.this.cIC();
            }
        }
    };
    private final CustomMessageListener jxG = new CustomMessageListener(2921486) { // from class: com.baidu.tieba.homepage.personalize.e.34
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data = customResponsedMessage.getData();
            switch (data instanceof Integer ? ((Integer) data).intValue() : 0) {
                case 2:
                    new BdTopToast(e.this.mPageContext.getPageActivity(), 2000).yb(true).Uc(e.this.mPageContext.getPageActivity().getString(R.string.youngster_open_title)).aH((ViewGroup) e.this.mPageContext.getPageActivity().findViewById(R.id.maintabContainer));
                    e.this.qT(true);
                    return;
                case 3:
                    new BdTopToast(e.this.mPageContext.getPageActivity(), 2000).yb(true).Uc(e.this.mPageContext.getPageActivity().getString(R.string.youngster_close_title)).aH((ViewGroup) e.this.mPageContext.getPageActivity().findViewById(R.id.maintabContainer));
                    e.this.qT(false);
                    return;
                case 4:
                default:
                    if (com.baidu.tbadk.youngster.b.c.bET()) {
                        e.this.qT(true);
                        return;
                    }
                    return;
                case 5:
                    new BdTopToast(e.this.mPageContext.getPageActivity(), 2000).yb(true).Uc(e.this.mPageContext.getPageActivity().getString(R.string.youngster_reset_title)).aH((ViewGroup) e.this.mPageContext.getPageActivity().findViewById(R.id.maintabContainer));
                    e.this.qT(true);
                    return;
            }
        }
    };
    private CustomMessageListener iVF = new CustomMessageListener(CmdConfigCustom.PB_ACTION_PRAISE) { // from class: com.baidu.tieba.homepage.personalize.e.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            bw bwVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bw) && e.this.jxn != null && y.getCount(e.this.jxn.thread_list) != 0 && (bwVar = (bw) customResponsedMessage.getData()) != null && bwVar.bjL() != null && bwVar.getId() != null && y.getCount(e.this.jxn.thread_list) != 0) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < e.this.jxn.thread_list.size()) {
                        ThreadInfo threadInfo = e.this.jxn.thread_list.get(i2);
                        if (threadInfo == null || threadInfo.id.longValue() != com.baidu.adp.lib.f.b.toLong(bwVar.getId(), -1L)) {
                            i = i2 + 1;
                        } else {
                            ThreadInfo.Builder builder = new ThreadInfo.Builder(threadInfo);
                            Zan.Builder builder2 = new Zan.Builder(builder.zan);
                            builder2.num = Integer.valueOf((int) bwVar.bjL().getNum());
                            builder.zan = builder2.build(true);
                            e.this.jxn.thread_list.set(i2, builder.build(true));
                            return;
                        }
                    } else {
                        return;
                    }
                }
            }
        }
    };
    private CustomMessageListener jxH = new CustomMessageListener(CmdConfigCustom.CMD_LIVE_VIDEO_CLOSED_QUERY_RESPONSED) { // from class: com.baidu.tieba.homepage.personalize.e.9
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
                        if ((originData.get(i2) instanceof bw) && (bwVar = (bw) originData.get(i2)) != null && bwVar.bku() != null && ids.contains(Long.valueOf(bwVar.bku().live_id))) {
                            e.this.mDataList.remove(bwVar);
                        }
                        i = i2 + 1;
                    }
                    if (e.this.jwD != null) {
                        e.this.jwD.ck(new ArrayList(e.this.mDataList));
                    }
                }
            }
        }
    };
    private CustomMessageListener eHG = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.homepage.personalize.e.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int intValue;
            if ((customResponsedMessage instanceof UpdateAttentionMessage) && e.this.jxn != null && !y.isEmpty(e.this.jxn.thread_list)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid)) {
                    int i = 0;
                    while (true) {
                        if (i >= e.this.jxn.thread_list.size()) {
                            break;
                        }
                        ThreadInfo threadInfo = e.this.jxn.thread_list.get(i);
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
                            e.this.jxn.thread_list.set(i, builder.build(true));
                        }
                    }
                    e.this.a(updateAttentionMessage);
                }
            }
        }
    };
    private CustomMessageListener jpV = new CustomMessageListener(0) { // from class: com.baidu.tieba.homepage.personalize.e.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long) && e.this.jxn != null && e.this.jxn.hot_recomforum != null && !y.isEmpty(e.this.jxn.hot_recomforum.tab_list)) {
                long longValue = ((Long) customResponsedMessage.getData()).longValue();
                DiscoverHotForum.Builder builder = new DiscoverHotForum.Builder(e.this.jxn.hot_recomforum);
                if (com.baidu.tieba.homepage.concern.c.a(builder, longValue, customResponsedMessage.getCmd() == 2001335)) {
                    e.this.jxn.hot_recomforum = builder.build(true);
                    e.this.c(new DataRes.Builder(e.this.jxn.build(true)));
                }
            }
        }
    };
    private String jxI = "lastReadReadPositionKey";
    private int jxJ = 0;
    private d jxL = new d() { // from class: com.baidu.tieba.homepage.personalize.e.16
        @Override // com.baidu.tieba.homepage.personalize.d
        public void Bf(final int i) {
            if (e.this.jxK == null) {
                e.this.jxK = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.e.16.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (e.this.iHt.getHandler() != null) {
                            e.this.iHt.requestFocusFromTouch();
                            if (i <= e.this.iHt.getCount() - 1) {
                                e.this.iHt.setSelection(i);
                            }
                        }
                    }
                };
            }
            e.this.iHt.removeCallbacks(e.this.jxK);
            e.this.iHt.post(e.this.jxK);
        }
    };
    private CustomMessageListener jxM = new CustomMessageListener(2016569) { // from class: com.baidu.tieba.homepage.personalize.e.19
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && e.this.jxv != null) {
                e.this.mDataList.remove(e.this.jxv);
                e.this.jwD.ck(new ArrayList(e.this.mDataList));
                com.baidu.tbadk.core.sharedPref.b.bnH().putLong("key_maintab_banner_close_time", System.currentTimeMillis());
            }
        }
    };
    private CustomMessageListener ikd = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.homepage.personalize.e.20
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.g(customResponsedMessage);
            if (e.this.iko != null && e.this.jvd) {
                e.this.iko.a(e.this.iDz, e.this.gch, e.this.iEj, true);
            }
        }
    };
    private CustomMessageListener ike = new CustomMessageListener(CmdConfigCustom.CMD_THREAD_NOT_EXIST_WHEN_ENTER_PB) { // from class: com.baidu.tieba.homepage.personalize.e.21
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.g(customResponsedMessage);
        }
    };
    private CustomMessageListener iVT = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.homepage.personalize.e.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && e.this.jxn != null && y.getCount(e.this.jxn.thread_list) != 0) {
                String str = (String) customResponsedMessage.getData();
                e.this.h(str, e.this.mDataList);
                e.this.Ly(str);
                if (e.this.jwD != null) {
                    e.this.jwD.ck(new ArrayList(e.this.mDataList));
                }
                if (e.this.iko != null && e.this.jvd) {
                    e.this.iko.a(e.this.iDz, e.this.gch, e.this.iEj, true);
                }
            }
        }
    };
    private CustomMessageListener iDg = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.homepage.personalize.e.24
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            am cHN;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent)) {
                KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24 && (cHN = e.this.cHN()) != null && cHN.tW() != null) {
                    cHN.tW().b(new a.C0097a(3));
                }
            }
        }
    };
    private com.baidu.adp.framework.listener.a jxN = new com.baidu.adp.framework.listener.a(1003065, CmdConfigSocket.CMD_TOPIC_BLESS) { // from class: com.baidu.tieba.homepage.personalize.e.25
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
                        if ((qVar instanceof com.baidu.tieba.homepage.topic.topictab.b.a) && (bVar = ((com.baidu.tieba.homepage.topic.topictab.b.a) qVar).jEQ) != null && longValue == bVar.pkId) {
                            bVar.userPkId = j2;
                            return;
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener iDh = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.homepage.personalize.e.26
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            List<q> dataList = e.this.jwD.getDataList();
            if (!y.isEmpty(dataList)) {
                for (q qVar : dataList) {
                    if (qVar instanceof l) {
                        l lVar = (l) qVar;
                        if (lVar.exG != 0 && lVar.erH != null) {
                            int[] imageWidthAndHeight = lVar.erH.getImageWidthAndHeight();
                            lVar.exG = imageWidthAndHeight[0];
                            lVar.exH = imageWidthAndHeight[1];
                        }
                    }
                }
            }
            com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.personalize.e.26.1
                @Override // java.lang.Runnable
                public void run() {
                    e.this.jwD.notifyDataSetChanged();
                    if (!e.this.mIsBackground && e.this.jvd) {
                        e.this.iko.a(e.this.iDz, e.this.gch, e.this.iEj, true);
                    }
                }
            }, 500L);
        }
    };
    private CustomMessageListener ikf = new CustomMessageListener(2921453) { // from class: com.baidu.tieba.homepage.personalize.e.27
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.data.be)) {
                com.baidu.tbadk.core.data.be beVar = (com.baidu.tbadk.core.data.be) customResponsedMessage.getData();
                if (beVar.ewE == 1) {
                    int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
                    int equipmentHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst());
                    float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
                    int i = au.boO().boP() ? 2 : 1;
                    RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
                    requestGetMyPostNetMessage.setTag(e.this.jxB);
                    requestGetMyPostNetMessage.setParams(com.baidu.adp.lib.f.b.toLong(beVar.tid, 0L), 0L, 0L, equipmentWidth, equipmentHeight, f, i);
                    requestGetMyPostNetMessage.setBFrom("push");
                    MessageManager.getInstance().sendMessage(requestGetMyPostNetMessage);
                }
            }
        }
    };
    private final com.baidu.adp.framework.listener.a ikg = new com.baidu.adp.framework.listener.a(1003010, CmdConfigSocket.CMD_GET_MY_POST) { // from class: com.baidu.tieba.homepage.personalize.e.28
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            GetMyPostResIdl getMyPostResIdl = null;
            if (responsedMessage instanceof GetMyPostHttpResponseMessage) {
                getMyPostResIdl = ((GetMyPostHttpResponseMessage) responsedMessage).getResponseData();
            } else if (responsedMessage instanceof GetMyPostSocketResponseMessage) {
                getMyPostResIdl = ((GetMyPostSocketResponseMessage) responsedMessage).getResponseData();
            }
            if (getMyPostResIdl != null && getMyPostResIdl.data != null && getMyPostResIdl.data.thread_info != null) {
                e.this.jxC = getMyPostResIdl.data.thread_info;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921455));
            }
        }
    };
    private CustomMessageListener jxO = new CustomMessageListener(2921482) { // from class: com.baidu.tieba.homepage.personalize.e.29
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (com.baidu.tbadk.coreExtra.c.a.w(TbadkCoreApplication.getInst(), 1)) {
                com.baidu.tbadk.coreExtra.c.a.a(e.this.mPageContext, 7, 0L);
            }
        }
    };

    /* loaded from: classes22.dex */
    public interface a {
        void C(int i, int i2, int i3, int i4);

        void S(int i, int i2, int i3);

        void cIp();

        void onError(int i, String str);

        void onSuccess();
    }

    public void qQ(boolean z) {
        this.jxw = z;
        if (this.ikj != null && !z) {
            this.ikj.hideTip();
        }
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.jwr = scrollFragmentTabHost;
        if (this.jwr != null) {
            this.jwr.setOnTabSelectedListener(new ScrollFragmentTabHost.b() { // from class: com.baidu.tieba.homepage.personalize.e.1
                @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.b
                public void Bp(int i) {
                    if (e.this.jwr.Bo(i) != 1 && e.this.ikj != null) {
                        e.this.ikj.hideTip();
                    }
                }
            });
        }
    }

    public void setTabInForeBackgroundState(boolean z) {
        this.mIsBackground = z;
    }

    public void pw(boolean z) {
        boolean z2 = false;
        this.mIsBackground = z;
        if (this.jwr != null) {
            this.jwr.pw(z);
        }
        if (this.iko != null) {
            this.iko.sO(!z);
            am cHN = cHN();
            if (cHN != null && cHN.tW() != null) {
                z2 = cHN.tW().b(new a.C0097a(8, Boolean.valueOf(z)));
            }
            if (!z2) {
                if (z) {
                    this.iko.cHM();
                } else if (this.jvd) {
                    this.iko.a(this.iDz, this.gch, this.iEj, true);
                }
            }
        }
    }

    public e(TbPageContext<?> tbPageContext, BdTypeRecyclerView bdTypeRecyclerView, ag agVar, BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout) {
        this.jxA = 0;
        this.mPageContext = tbPageContext;
        this.jxA = com.baidu.tbadk.core.sharedPref.b.bnH().getInt("key_personalized_refresh_type", 0);
        this.jpF = bigdaySwipeRefreshLayout;
        this.iHt = bdTypeRecyclerView;
        this.iHt.setOnTouchListener(this.ftj);
        if (com.baidu.tbadk.youngster.b.c.bET()) {
            qT(true);
        }
        this.jcY = new com.baidu.tieba.f.a();
        this.jcY.a(this.iac);
        this.jwD = agVar;
        this.jxq = new com.baidu.tieba.homepage.personalize.model.a();
        this.jxk = com.baidu.tbadk.core.sharedPref.b.bnH().getLong("recommend_frs_cache_time", 1800L) * 1000;
        bdTypeRecyclerView.setOnScrollListener(this.mOnScrollListener);
        this.ikj = new be();
        cIA();
        this.iko = new i(this.mPageContext, this.iHt);
        this.iko.Hh(1);
        this.iko.Hg(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.jxl = new b(this.mDataList, this.jwD);
        this.ikk = new SmartBubbleAnimatedView(tbPageContext.getContext());
        this.ikk.setLayoutParams(new FrameLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(tbPageContext.getContext(), R.dimen.tbds83)));
        cIq();
        this.iDh.setTag(this.mPageContext.getUniqueId());
        MessageManager.getInstance().registerListener(this.iDh);
        if (MessageManager.getInstance().findTask(1003010) == null) {
            HomePageStatic.cFW();
        }
        this.ikg.setTag(this.jxB);
        if (this.ikg.getHttpMessageListener() != null) {
            this.ikg.getHttpMessageListener().setSelfListener(true);
        }
        if (this.ikg.getSocketMessageListener() != null) {
            this.ikg.getSocketMessageListener().setSelfListener(true);
        }
        MessageManager.getInstance().registerListener(this.ikg);
        MessageManager.getInstance().registerListener(this.ikf);
        MessageManager.getInstance().registerListener(this.jxO);
    }

    private void cIq() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2016323, new CustomMessageTask.CustomRunnable<Boolean>() { // from class: com.baidu.tieba.homepage.personalize.e.35
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Boolean> customMessage) {
                am cHN = e.this.cHN();
                return (cHN == null || cHN.tW() == null) ? new CustomResponsedMessage<>(2016323, false) : new CustomResponsedMessage<>(2016323, Boolean.valueOf(cHN.tW().b(new a.C0097a(6))));
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private boolean cIr() {
        return com.baidu.tbadk.core.sharedPref.b.bnH().getBoolean(cIt(), true);
    }

    private void cIs() {
        com.baidu.tbadk.core.sharedPref.b.bnH().putBoolean(cIt(), false);
    }

    private String cIt() {
        return "key_rec_pfirst_load_" + TbadkCoreApplication.getCurrentAccount() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + TbConfig.getVersion();
    }

    public void setRecommendFrsNavigationAnimDispatcher(ab abVar) {
        if (abVar != null) {
            this.fti = abVar.bBt();
            this.feS = abVar.bBu();
        }
    }

    public void showFloatingView() {
        if (this.fti != null) {
            this.fti.showFloatingView(true);
        }
    }

    public void update() {
        com.baidu.tieba.homepage.framework.a.cGG().y(System.currentTimeMillis(), 1);
        this.mPn = 1;
        this.jxu = true;
        if (this.mDataList.size() == 0 && !cIr()) {
            if (!this.jpQ) {
                bhr();
                return;
            }
            return;
        }
        bhq();
    }

    public void cC(int i, int i2) {
        bw bwVar;
        if (!y.isEmpty(this.mDataList) && this.mDataList.size() > i) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            while (i < this.mDataList.size() && i <= i2) {
                if (this.mDataList.get(i).getType().getId() == bw.eyh.getId() && (bwVar = (bw) this.mDataList.get(i)) != null && bwVar.bku() != null) {
                    arrayList.add(Long.valueOf(bwVar.bku().live_id));
                    arrayList2.add(bwVar);
                }
                i++;
            }
            if (!y.isEmpty(arrayList)) {
                MessageManager.getInstance().sendMessage(new LiveRoomClosedQueryMessage(arrayList, arrayList2));
            }
        }
    }

    public void cIu() {
        if (this.iko != null && !this.mIsBackground && this.jvd) {
            this.iko.a(this.iDz, this.gch, this.iEj, true);
        }
        if (this.jxs) {
            if (this.jpF != null && !this.jpF.bqi()) {
                if (this.jnk) {
                    com.baidu.tieba.s.c.dGv().b(this.jxy, false);
                    if (qS(false)) {
                        cD(3, this.jxp);
                    } else if (this.jxt > 0) {
                        cD(2, this.jxp);
                    }
                } else if (!this.jnk && this.jxp == 0) {
                    cD(2, 0);
                }
            }
            this.jxs = false;
            this.jnk = false;
            this.jxt = 0;
            if (this.jxu) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
            }
            this.jxu = false;
        }
    }

    public void bMi() {
        if (isLoading()) {
            com.baidu.tieba.homepage.framework.a.cGG().y(0L, 1);
        } else if (this.jxm != null) {
            cIw();
            this.mPn++;
            setIsLoading(true);
            this.jxm.C(this.mPn, (this.jxn == null || this.jxn.thread_list == null) ? 0 : this.jxn.thread_list.size(), qR(false), 0);
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
            g.cIH();
        }
        if (this.jxq != null && this.jxq.cJb() && !z && (dataRes == null || y.isEmpty(dataRes.thread_list))) {
            if (dataRes == null) {
                DataRes.Builder builder = new DataRes.Builder();
                builder.thread_list = new ArrayList();
                dataRes = builder.build(false);
            }
            if (dataRes.thread_list != null) {
                List<ThreadInfo> cJc = this.jxq.cJc();
                dataRes.thread_list.addAll(cJc);
                if (cJc != null) {
                    cJc.clear();
                }
                z3 = true;
                size = (this.jxn != null || this.jxn.thread_list == null) ? 0 : this.jxn.thread_list.size();
                if (z && i == 0 && dataRes != null && y.isEmpty(dataRes.thread_list)) {
                    if (this.jxm != null) {
                        this.jxm.cIp();
                    }
                    setIsLoading(false);
                    if (this.jpF != null) {
                        this.jpF.setRefreshing(false);
                        return;
                    }
                    return;
                }
                if (this.jxC != null) {
                    DataRes.Builder builder2 = new DataRes.Builder(dataRes);
                    builder2.thread_list.add(0, this.jxC);
                    dataRes = builder2.build(false);
                    if (this.jxn != null && !y.isEmpty(this.jxn.thread_list)) {
                        Iterator<ThreadInfo> it = this.jxn.thread_list.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            ThreadInfo next = it.next();
                            if (next != null && next.tid != null && this.jxC.tid != null && next.tid.longValue() == this.jxC.tid.longValue()) {
                                this.jxn.thread_list.remove(next);
                                break;
                            }
                        }
                    }
                    this.jxC = null;
                }
                if ((z3 && i != 0) || dataRes == null || !a(true, z, z2, dataRes)) {
                    this.jxs = false;
                    if (this.mDataList.size() > 0) {
                        if (this.jxm != null) {
                            this.jxm.onError(1, str);
                        }
                    } else if (this.jxm != null) {
                        this.jxm.onError(2, str);
                    }
                } else {
                    cIs();
                    if (this.jxm != null) {
                        com.baidu.tbadk.core.sharedPref.b.bnH().putLong(SharedPrefConfig.RECOMMEND_FRS_REFRESH_TIME + TbadkCoreApplication.getCurrentAccount(), System.currentTimeMillis());
                        this.jxm.onSuccess();
                    }
                    this.jxs = true;
                    this.jnk = z;
                    this.jxt = size;
                    coY();
                }
                setIsLoading(false);
                if (this.jpF == null) {
                    f.e cIv = cIv();
                    if (this.jpF.bqi() && cIv != null) {
                        this.jpF.c(cIv);
                        return;
                    } else {
                        this.jpF.setRefreshing(false);
                        return;
                    }
                }
                return;
            }
        }
        z3 = false;
        if (this.jxn != null) {
        }
        if (z) {
        }
        if (this.jxC != null) {
        }
        if (z3) {
        }
        cIs();
        if (this.jxm != null) {
        }
        this.jxs = true;
        this.jnk = z;
        this.jxt = size;
        coY();
        setIsLoading(false);
        if (this.jpF == null) {
        }
    }

    private f.e cIv() {
        int i;
        String feedText;
        if (!this.jxs || this.jpF == null || !this.jpF.bqi() || cIz()) {
            return null;
        }
        int i2 = this.jxp;
        if (this.jnk) {
            com.baidu.tieba.s.c.dGv().b(this.jxy, false);
            if (qS(false)) {
                i = 3;
            } else {
                i = this.jxt > 0 ? 2 : 0;
            }
        } else if (this.jnk || this.jxp != 0) {
            return null;
        } else {
            i2 = 0;
            i = 2;
        }
        if (this.jwr != null) {
            this.ikj.cyf();
        }
        if (this.jwr != null && this.jwr.getCurrentTabType() != 1) {
            this.ikj.hideTip();
            return null;
        } else if (!this.jxw) {
            this.ikj.hideTip();
            return null;
        } else {
            this.jxo = i;
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
                this.iGz = 1000;
            } else {
                this.iGz = 0;
            }
            return new f.e(feedText, this.iGz);
        }
    }

    public void qD(boolean z) {
        if (z) {
            this.jwD.notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        if (this.iko != null) {
            this.iko.destroy();
        }
        if (this.ikj != null) {
            this.ikj.onDestroy();
        }
        if (this.jxl != null) {
            this.jxl.onDestroy();
        }
        if (this.iHt != null) {
            this.iHt.removeCallbacks(this.jxK);
        }
        MessageManager.getInstance().unRegisterTask(2016323);
        MessageManager.getInstance().unRegisterListener(this.iDh);
        MessageManager.getInstance().unRegisterListener(this.ikf);
        MessageManager.getInstance().unRegisterListener(this.ikg);
        MessageManager.getInstance().unRegisterListener(this.jxO);
    }

    public void onPause() {
        c.d(this.iHt);
        Bx(this.jxJ);
        if (this.jxr != null) {
            this.jxr.bzN();
        }
    }

    private void bhq() {
        if (this.jxm != null) {
            this.jxm.S((this.jxn == null || this.jxn.thread_list == null || cIy()) ? 0 : this.jxn.thread_list.size(), qR(true), 0);
        }
    }

    public int qR(boolean z) {
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
                if (!(qVar instanceof com.baidu.tieba.homepage.personalize.data.a) || qVar.getType() == AdvertAppInfo.esJ) {
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
                if ((qVar2 instanceof com.baidu.tieba.homepage.personalize.data.a) && qVar2.getType() != AdvertAppInfo.esJ) {
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
        this.jpQ = true;
        if (dataRes != null) {
            if (a(false, true, true, dataRes) && !cIy()) {
                if (this.jxm != null) {
                    this.jxm.onSuccess();
                    Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler() { // from class: com.baidu.tieba.homepage.personalize.e.2
                        @Override // android.os.MessageQueue.IdleHandler
                        public boolean queueIdle() {
                            e.this.bzS();
                            return false;
                        }
                    });
                }
                if (TbSingleton.getInstance().getForceRefreshHomeRecommend()) {
                    bhq();
                    TbSingleton.getInstance().setForceRefreshHomeRecommend(false);
                    return;
                }
                return;
            }
            bhq();
            return;
        }
        bhq();
    }

    public void bzS() {
        long Bd = com.baidu.tieba.homepage.framework.a.cGG().Bd(1) + com.baidu.tieba.homepage.framework.a.cGG().getCreateTime();
        long Bb = com.baidu.tieba.homepage.framework.a.cGG().Bb(1);
        if (Bb > 0) {
            Bd = System.currentTimeMillis() - Bb;
        }
        n.bAa().dK(Bd);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.util.Set] */
    private void i(List<q> list, int i) {
        AdvertAppInfo cmk;
        AdvertAppInfo cmk2;
        if (!y.isEmpty(list)) {
            Set<q> Rn = com.baidu.tieba.recapp.report.a.Rn("NEWINDEX");
            HashSet hashSet = Rn == null ? new HashSet() : Rn;
            HashSet hashSet2 = new HashSet();
            for (q qVar : list) {
                if (qVar != null) {
                    for (q qVar2 : hashSet) {
                        if ((qVar instanceof com.baidu.tieba.card.data.e) && (cmk2 = ((com.baidu.tieba.card.data.e) qVar).cmk()) != null && qVar2 != null && (qVar2 instanceof AdvertAppInfo) && qVar2.hashCode() == cmk2.hashCode()) {
                            cmk2.advertAppContext = ((AdvertAppInfo) qVar2).advertAppContext;
                        }
                    }
                    if (qVar != null && (qVar instanceof com.baidu.tieba.card.data.e) && (cmk = ((com.baidu.tieba.card.data.e) qVar).cmk()) != null && cmk.advertAppContext == null) {
                        cmk.advertAppContext = new com.baidu.tbadk.core.data.b();
                        cmk.advertAppContext.page = "NEWINDEX";
                        cmk.advertAppContext.pn = this.mPn;
                        cmk.advertAppContext.extensionInfo = cmk.extensionInfo;
                        cmk.advertAppContext.YN = false;
                        hashSet2.add(cmk);
                    }
                }
            }
            hashSet.addAll(hashSet2);
            com.baidu.tieba.recapp.report.a.b("NEWINDEX", hashSet);
            if (hashSet2.size() > 0) {
                com.baidu.tieba.s.c.dGv().b(this.jxy, com.baidu.tieba.s.a.b(PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE, "common_fill", true, hashSet2.size()));
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
        if (this.jxA == 1) {
            if (z2 && (dataRes.thread_list.size() >= 6 || cIy())) {
                cIx();
                this.jxn = null;
            }
        } else if (z2 && cIy()) {
            this.jxn = null;
        }
        int size = z2 ? 0 : this.mDataList.size();
        DataRes.Builder builder = new DataRes.Builder(dataRes);
        this.mDataList.clear();
        com.baidu.tieba.homepage.personalize.model.c a2 = this.jxq.a(z, this.jxn, builder, z2 ? 0 : 1);
        if (a2 == null) {
            list = null;
            i = 0;
        } else {
            List<q> list2 = a2.fIa;
            this.jxp = a2.jAu;
            int i2 = a2.jAv;
            a2.jAv = 0;
            list = list2;
            i = i2;
        }
        if (list != null) {
            this.mDataList.addAll(list);
            i(list, size);
            a(z2 ? 0 : 1, list, size);
            if (this.jxu) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
            }
        }
        if (this.jxn == null) {
            this.jxn = builder;
            this.jxl.dD(this.jxn.thread_list);
        }
        if (this.mDataList.size() == 0) {
            z4 = false;
        } else {
            if (z2) {
                if (dataRes.live_answer != null) {
                    this.jxv = new h();
                    this.jxv.a(dataRes.live_answer);
                    this.jxn.live_answer = dataRes.live_answer;
                } else if (z) {
                    this.jxv = null;
                    this.jxn.live_answer = null;
                }
                this.jxx = dataRes.float_info;
                this.jxn.float_info = dataRes.float_info;
            }
            long j = com.baidu.tbadk.core.sharedPref.b.bnH().getLong("key_maintab_banner_close_time", 0L);
            if (this.jxv != null && !at.isTaday(j)) {
                this.mDataList.add(0, this.jxv);
            }
            LinkedList linkedList = new LinkedList(this.mDataList);
            this.jwD.setFromCDN(dataRes.is_new_url != null && dataRes.is_new_url.intValue() == 1);
            this.jwD.j(linkedList, i);
            z4 = true;
            if (this.iko != null && this.jvd) {
                this.iko.a(this.iDz, this.gch, this.iEj, true);
            }
        }
        com.baidu.tieba.homepage.framework.a.cGG().w(System.currentTimeMillis() - currentTimeMillis, 1);
        long Be = com.baidu.tieba.homepage.framework.a.cGG().Be(1);
        if (Be > 0) {
            com.baidu.tieba.homepage.framework.a.cGG().x(System.currentTimeMillis() - Be, 1);
            com.baidu.tieba.homepage.framework.a.cGG().y(0L, 1);
        }
        if (dataRes.anti != null && dataRes.anti.block_pop_info != null) {
            com.baidu.tieba.ueg.d.d(dataRes.anti.block_pop_info);
        }
        bg bgVar = new bg();
        bgVar.a(dataRes.recom_post_topic);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_REFRESH_TOPIC_TIP, bgVar));
        return z4;
    }

    private void cIw() {
        List<q> list;
        int i;
        if (y.getCount(this.mDataList) >= this.jxq.cIX() - 40) {
            com.baidu.tieba.homepage.personalize.model.c a2 = this.jxq.a(true, this.jxn, null, 1);
            if (a2 != null) {
                List<q> list2 = a2.fIa;
                i = a2.jAv;
                a2.jAv = 0;
                list = list2;
            } else {
                list = null;
                i = 0;
            }
            if (list != null) {
                this.mDataList.clear();
                this.mDataList.addAll(list);
                this.jwD.j(new LinkedList(this.mDataList), i);
            }
        }
    }

    private void bhr() {
        this.jpQ = true;
        ae.a(new ad<DataRes>() { // from class: com.baidu.tieba.homepage.personalize.e.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.ad
            /* renamed from: cID */
            public DataRes doInBackground() {
                com.baidu.adp.lib.cache.l<byte[]> dH = com.baidu.tbadk.core.c.a.bmx().dH("tb.rec_frs_update", TbadkCoreApplication.getCurrentAccount());
                if (dH == null) {
                    return null;
                }
                byte[] bArr = dH.get("0");
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

    private void coY() {
        if (this.jxn != null) {
            DataRes.Builder builder = new DataRes.Builder(this.jxn.build(true));
            if (builder.thread_list != null && builder.thread_list.size() > 30) {
                builder.thread_list = builder.thread_list.subList(0, 30);
            }
            a(builder, builder.thread_list != null ? builder.thread_list.size() : 0);
            a(builder);
            b(builder);
            c(builder);
        }
    }

    private void cIx() {
        if (this.jxn != null) {
            final DataRes.Builder builder = new DataRes.Builder(this.jxn.build(true));
            if (builder.thread_list != null && builder.thread_list.size() > 50) {
                builder.thread_list = builder.thread_list.subList(0, 50);
            }
            a(builder, builder.thread_list != null ? builder.thread_list.size() : 0);
            ae.a(new ad<Object>() { // from class: com.baidu.tieba.homepage.personalize.e.5
                @Override // com.baidu.tbadk.util.ad
                public Object doInBackground() {
                    DataRes.Builder builder2 = new DataRes.Builder(builder.build(true));
                    e.this.jxl.dE(builder2.thread_list);
                    try {
                        com.baidu.tbadk.core.c.a.bmx().dH("tb.rec_old_data", TbadkCoreApplication.getCurrentAccount()).setForever("0", builder2.build(true).toByteArray());
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
    public void Ly(String str) {
        if (!TextUtils.isEmpty(str) && this.jxn != null && this.jxn.banner_list != null && this.jxn.banner_list.app != null && this.jxn.banner_list.app.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (App app : this.jxn.banner_list.app) {
                if (app != null && str.equals(app.id)) {
                    arrayList.add(app);
                }
            }
            BannerList.Builder builder = new BannerList.Builder(this.jxn.banner_list);
            if (builder.app != null) {
                builder.app.removeAll(arrayList);
            }
            this.jxn.banner_list = builder.build(false);
            DataRes.Builder builder2 = new DataRes.Builder(this.jxn.build(true));
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
                e.this.jxl.dE(builder2.thread_list);
                try {
                    com.baidu.tbadk.core.c.a.bmx().dH("tb.rec_frs_update", TbadkCoreApplication.getCurrentAccount()).setForever("0", builder2.build(true).toByteArray());
                    return null;
                } catch (Exception e) {
                    BdLog.e(e);
                    return null;
                }
            }
        }, null);
    }

    private boolean cIy() {
        return qS(true);
    }

    private boolean qS(boolean z) {
        long j = com.baidu.tbadk.core.sharedPref.b.bnH().getLong(SharedPrefConfig.RECOMMEND_FRS_REFRESH_TIME + TbadkCoreApplication.getCurrentAccount(), 0L);
        return j == 0 ? z : Math.abs(System.currentTimeMillis() - j) > this.jxk;
    }

    public void a(a aVar) {
        this.jxm = aVar;
    }

    private boolean isLoading() {
        return this.mIsLoading;
    }

    private void setIsLoading(boolean z) {
        this.mIsLoading = z;
    }

    public void cIl() {
        boolean z = true;
        com.baidu.tbadk.coreExtra.data.b activityPrizeData = TbadkCoreApplication.getInst().getActivityPrizeData();
        if (activityPrizeData.isSwitchTurn() && !StringUtils.isNull(activityPrizeData.getFeedText())) {
            String currentDay = UtilHelper.getCurrentDay();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            String str = "";
            if (!StringUtils.isNull(currentAccount)) {
                String string = com.baidu.tbadk.core.sharedPref.b.bnH().getString(SharedPrefConfig.ACTIVITY_PRIZE_FEED_TEXT_TIME, "");
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
                    cD(4, 0);
                    com.baidu.tbadk.core.sharedPref.b.bnH().putString(SharedPrefConfig.ACTIVITY_PRIZE_FEED_TEXT_TIME, str);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qT(boolean z) {
        boolean z2 = com.baidu.tbadk.core.sharedPref.b.bnH().getBoolean("key_youngster_homgpage_top_view_closed", false);
        if (this.iHt != null && !z2) {
            if (z) {
                if (this.jxz == null) {
                    this.jxz = new HomePageYoungsterTopView(this.mPageContext);
                    this.jxz.setOnDeleteClick(new HomePageYoungsterTopView.a() { // from class: com.baidu.tieba.homepage.personalize.e.7
                        @Override // com.baidu.tieba.homepage.personalize.view.HomePageYoungsterTopView.a
                        public void cIE() {
                            new BdTopToast(e.this.mPageContext.getPageActivity(), 2000).yb(true).Uc(e.this.mPageContext.getPageActivity().getString(R.string.youngster_frs_top_toast)).aH((ViewGroup) e.this.mPageContext.getPageActivity().findViewById(R.id.maintabContainer));
                            e.this.qT(false);
                            com.baidu.tbadk.core.sharedPref.b.bnH().putBoolean("key_youngster_homgpage_top_view_closed", true);
                        }
                    });
                }
                this.iHt.setHeaderView(this.jxz);
                this.jxz.setVisibility(0);
                this.iHt.scrollToPosition(0);
            } else if (this.jxz != null) {
                this.jxz.setVisibility(8);
                this.iHt.removeHeaderView(this.jxz);
            }
        }
    }

    private boolean cIz() {
        return this.jxz != null && this.jxz.getVisibility() == 0;
    }

    private void cD(int i, int i2) {
        if (!cIz()) {
            if (this.jwr != null) {
                this.ikj.cyf();
            }
            if (this.jwr != null && this.jwr.getCurrentTabType() != 1) {
                this.ikj.hideTip();
            } else if (!this.jxw) {
                this.ikj.hideTip();
            } else {
                this.jxo = i;
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
                        this.iGz = 3000;
                    } else {
                        this.iGz = 2000;
                    }
                    this.ikk.eQa = str;
                    this.ikk.iGs = this.iGz;
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 49;
                    if (this.jwr != null) {
                        FrameLayout frameLayout = this.jwr.getFrameLayout();
                        frameLayout.removeView(this.ikk);
                        frameLayout.addView(this.ikk, layoutParams);
                        this.ikk.cyd();
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(Long l) {
        if (this.jxn != null && this.jxn.thread_list != null) {
            List<ThreadInfo> list = this.jxn.thread_list;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                ThreadInfo threadInfo = list.get(i);
                if (threadInfo.tid.equals(l) && threadInfo.top_agree_post != null) {
                    ThreadInfo.Builder builder = new ThreadInfo.Builder(threadInfo);
                    builder.top_agree_post = null;
                    list.set(i, builder.build(true));
                    coY();
                    a(false, true, false, this.jxn.build(true));
                    return;
                }
            }
        }
    }

    public void o(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.jxy = bdUniqueId;
            if (this.iVF != null) {
                this.iVF.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.iVF);
            }
            if (this.jxE != null) {
                this.jxE.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.jxE);
            }
            this.jxF.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.jxF);
            this.eHG.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.eHG);
            this.jpV.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_LIKE_FORUM, this.jpV);
            MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_UNLIKE_FORUM, this.jpV);
            this.jxH.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.jxH);
            this.ikd.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.ikd);
            this.ike.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.ike);
            this.iVT.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.iVT);
            if (this.iko != null) {
                this.iko.setUniqueId(bdUniqueId);
            }
            this.jxl.l(bdUniqueId);
            this.jxM.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.jxM);
            this.iDg.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.iDg);
            this.jxN.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.jxN);
            this.jxG.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.jxG);
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
                        com.baidu.adp.lib.cache.l<byte[]> dH = com.baidu.tbadk.core.c.a.bmx().dH("tb.rec_frs_update", TbadkCoreApplication.getCurrentAccount());
                        if (dH == null) {
                            return false;
                        }
                        byte[] bArr = dH.get("0");
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
                        e.this.jxl.dE(builder5.thread_list);
                        dH.setForever("0", builder5.build(true).toByteArray());
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

    public void cIA() {
        this.iBo = new com.baidu.tieba.tbadkCore.data.f("new_index", null);
        this.iBo.dHd();
    }

    public void a(int i, List<q> list, int i2) {
        int i3;
        int i4;
        if (this.iBo != null) {
            if (i == 0) {
                this.iBo.dHd();
            }
            if (list != null && !list.isEmpty()) {
                int[] iArr = com.baidu.tieba.tbadkCore.data.f.mQo;
                int i5 = 0;
                int i6 = 0;
                int i7 = 0;
                while (i7 < list.size() && i6 < iArr.length && (i3 = iArr[i6]) >= 0) {
                    if (list.get(i7) instanceof com.baidu.tieba.card.data.c) {
                        i4 = i5 + 1;
                        if (i4 == i3 - 1) {
                            if (i2 < i7 + 1) {
                                this.iBo.dq(i3, i7 + 1);
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

    public void Bw(int i) {
        if ((this.iBo != null ? this.iBo.Jn(i) : -1) >= 0 && this.iHt != null && this.iHt.getData() != null && this.iHt.getData().size() > i) {
            this.iBo.Jo(i);
        }
    }

    public i cwN() {
        return this.iko;
    }

    public void qM(boolean z) {
        this.jvd = z;
    }

    public void Bx(final int i) {
        ae.a(new ad<Object>() { // from class: com.baidu.tieba.homepage.personalize.e.15
            @Override // com.baidu.tbadk.util.ad
            public Object doInBackground() {
                com.baidu.adp.lib.cache.l<String> dI = com.baidu.tbadk.core.c.a.bmx().dI(e.this.jxI, TbadkCoreApplication.getCurrentAccount());
                if (dI != null) {
                    dI.set(e.this.jxI, Integer.toString(i), 43200000L);
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
            /* renamed from: cIF */
            public String doInBackground() {
                com.baidu.adp.lib.cache.l<String> dI = com.baidu.tbadk.core.c.a.bmx().dI(e.this.jxI, TbadkCoreApplication.getCurrentAccount());
                if (dI != null) {
                    return dI.get(e.this.jxI);
                }
                return null;
            }
        }, new m<String>() { // from class: com.baidu.tieba.homepage.personalize.e.18
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.m
            /* renamed from: Lz */
            public void onReturnDataInUI(String str) {
                if (dVar != null) {
                    dVar.Bf(com.baidu.adp.lib.f.b.toInt(str, 0));
                }
            }
        });
    }

    public void cIn() {
        c.e(this.iHt);
    }

    public void cIB() {
        a(this.jxL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cIC() {
        Iterator<q> it = this.mDataList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            } else if (it.next() instanceof com.baidu.tieba.homepage.personalize.data.g) {
                it.remove();
                break;
            }
        }
        if (this.jxn != null) {
            this.jxn.active_center = null;
            coY();
            if (this.iHt != null) {
                List<Integer> f = f(this.iHt);
                int intValue = f.get(0).intValue();
                int intValue2 = f.get(1).intValue();
                if (intValue != -1 && intValue2 != -1) {
                    this.iHt.o(intValue, intValue2);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(CustomResponsedMessage<?> customResponsedMessage) {
        boolean z;
        String str;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.jxn != null && y.getCount(this.jxn.thread_list) != 0 && y.getCount(this.mDataList) != 0) {
            JSONObject jSONObject = (JSONObject) customResponsedMessage.getData();
            String optString = jSONObject.optString("tid");
            if (StringUtils.isNull(optString)) {
                String optString2 = jSONObject.optString(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_ID);
                if (this.iHt != null && !TextUtils.isEmpty(optString2)) {
                    int i = 0;
                    while (true) {
                        if (i >= this.iHt.getCount()) {
                            str = optString;
                            break;
                        }
                        q item = this.iHt.getItem(i);
                        if (item instanceof k) {
                            k kVar = (k) item;
                            if (kVar.bhz() != null && kVar.bhz().bku() != null && optString2.equals(String.valueOf(kVar.bhz().bku().live_id))) {
                                str = kVar.bhz().getTid();
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
                    if (cVar.bhz() != null && cVar.bhz().getTid() != null) {
                        if (cVar.bhz().getTid().equals(optString)) {
                            it.remove();
                            z = true;
                            z2 = z;
                        } else if (z2) {
                            com.baidu.tieba.homepage.personalize.model.b.dG(this.mDataList);
                            break;
                        }
                    }
                }
                z = z2;
                z2 = z;
            }
            if (this.jxn != null && this.jxn.thread_list != null) {
                long j = com.baidu.adp.lib.f.b.toLong(optString, 0L);
                int i2 = 0;
                while (true) {
                    if (i2 < this.jxn.thread_list.size()) {
                        ThreadInfo threadInfo = this.jxn.thread_list.get(i2);
                        if (threadInfo == null || threadInfo.tid == null || threadInfo.tid.longValue() != j) {
                            i2++;
                        } else {
                            com.baidu.tieba.homepage.personalize.b.d.a(threadInfo.tid.longValue(), i2, this.jxn.thread_list, this.mDataList);
                            this.jxn.thread_list.remove(i2);
                            coY();
                            break;
                        }
                    } else {
                        break;
                    }
                }
                if (this.iHt != null) {
                    List<Integer> b = b(optString, this.iHt);
                    int intValue = b.get(0).intValue();
                    int intValue2 = b.get(1).intValue();
                    if (intValue != -1 && intValue2 != -1) {
                        this.iHt.o(intValue, intValue2);
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
                    if (cVar.bhz() != null && cVar.bhz().getTid().equals(str)) {
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
                    advertAppInfo = ((com.baidu.tieba.homepage.personalize.data.a) next).cmk();
                } else {
                    if (next instanceof ak) {
                        ak akVar = (ak) next;
                        if (akVar.bir() instanceof AdvertAppInfo.ILegoAdvert) {
                            advertAppInfo = ((AdvertAppInfo.ILegoAdvert) akVar.bir()).getAdvertAppInfo();
                        }
                    }
                    advertAppInfo = advertAppInfo2;
                }
                if (advertAppInfo != null && str.equals(advertAppInfo.esU)) {
                    it.remove();
                    advertAppInfo = null;
                }
                advertAppInfo2 = advertAppInfo;
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (this.ikk != null) {
            this.ikk.onChangeSkinType(i);
        }
        if (this.jxz != null) {
            this.jxz.onChangeSkinType();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public am cHN() {
        if (this.iko == null || this.iko.duu() == null || !(this.iko.duu().getTag() instanceof am)) {
            return null;
        }
        return (am) this.iko.duu().getTag();
    }
}
