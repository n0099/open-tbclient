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
import com.baidu.adp.lib.util.l;
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
import com.baidu.tbadk.core.data.al;
import com.baidu.tbadk.core.data.bf;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tbadk.n.n;
import com.baidu.tbadk.util.ac;
import com.baidu.tbadk.util.ad;
import com.baidu.tbadk.util.m;
import com.baidu.tbadk.util.y;
import com.baidu.tbadk.util.z;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.LiveRoomClosedQueryMessage;
import com.baidu.tieba.card.data.k;
import com.baidu.tieba.card.t;
import com.baidu.tieba.frs.SmartBubbleAnimatedView;
import com.baidu.tieba.frs.be;
import com.baidu.tieba.g.a;
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
    private View.OnTouchListener fjT;
    private y fyn;
    private com.baidu.tieba.tbadkCore.data.f iHZ;
    private final BdTypeRecyclerView iOd;
    private be iqW;
    private SmartBubbleAnimatedView iqX;
    private i irb;
    private ScrollFragmentTabHost jDm;
    private final af jDy;
    private Runnable jEF;
    private final long jEf;
    private final b jEg;
    private DataRes.Builder jEi;
    private final com.baidu.tieba.homepage.personalize.model.a jEl;
    private int jEo;
    private h jEq;
    private BdUniqueId jEt;
    private HomePageYoungsterTopView jEu;
    private int jEv;
    private com.baidu.tieba.g.a jjH;
    private boolean jtO;
    private final BigdaySwipeRefreshLayout jwo;
    private final TbPageContext<?> mPageContext;
    private a jEh = null;
    private final List<q> mDataList = new LinkedList();
    private int mPn = 1;
    private boolean mIsLoading = false;
    private boolean jwz = false;
    private int jEj = 2;
    private int jEk = 0;
    private TextView mTipView = null;
    private int iNj = 2000;
    private com.baidu.tbadk.n.c jEm = null;
    private boolean iKT = false;
    private int iKj = 0;
    private int ghD = 0;
    private boolean mIsBackground = false;
    private boolean jBW = true;
    private boolean jEn = false;
    private boolean jEp = false;
    private boolean jEr = true;
    private FloatInfo jEs = null;
    private BdUniqueId jEw = BdUniqueId.gen();
    private a.C0096a iIu = new a.C0096a(2);
    private ThreadInfo jEx = null;
    private RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.e.12
        private int jEM = -1;
        private int jwI = 0;
        private boolean jEN = false;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (e.this.jEm == null) {
                e.this.jEm = new com.baidu.tbadk.n.c();
                e.this.jEm.setSubType(1005);
                e.this.jEm.pageType = 1;
            }
            if (e.this.fyn != null && !e.this.mIsBackground) {
                e.this.fyn.m(recyclerView, i);
            }
            if (i == 0) {
                c.d(e.this.iOd);
                e.this.jEm.bBB();
                t.cnT().lO(true);
                com.baidu.tieba.a.d.bIl().dL("page_recommend", "show_");
                com.baidu.tieba.t.c.dIO().b(e.this.jEt, false);
                this.jEN = false;
                if (e.this.irb != null && e.this.jBW && !e.this.mIsBackground) {
                    e.this.irb.a(e.this.iKj, e.this.ghD, e.this.iKT, 1);
                    return;
                }
                return;
            }
            e.this.jEm.bBA();
            if (i == 1) {
                if (e.this.iqW != null) {
                    e.this.iqW.hideTip();
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
            if (this.jwI > i) {
                this.jEN = true;
            }
            if (e.this.fyn != null && !e.this.mIsBackground) {
                e.this.fyn.onScroll(this.jwI, i);
            }
            this.jwI = i;
            int i3 = (i + i2) - 1;
            if (!this.jEN && this.jEM != i3) {
                this.jEM = i3;
                e.this.Ch(this.jEM);
            }
            if (this.jEN && this.jEM != i) {
                this.jEM = i;
                e.this.Ch(this.jEM);
            }
            e.this.jEE = i;
            e.this.iKj = i;
            e.this.ghD = (i + i2) - 1;
            am cJT = e.this.cJT();
            if (cJT != null && cJT.tW() != null) {
                cJT.tW().b(e.this.iIu);
            }
        }
    };
    private View.OnTouchListener fyo = new View.OnTouchListener() { // from class: com.baidu.tieba.homepage.personalize.e.23
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (e.this.fjT != null) {
                e.this.fjT.onTouch(view, motionEvent);
            }
            if (e.this.jjH != null) {
                e.this.jjH.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private a.InterfaceC0740a igS = new a.InterfaceC0740a() { // from class: com.baidu.tieba.homepage.personalize.e.30
        @Override // com.baidu.tieba.g.a.InterfaceC0740a
        public void H(int i, int i2) {
            e.this.iKT = false;
        }

        @Override // com.baidu.tieba.g.a.InterfaceC0740a
        public void I(int i, int i2) {
            e.this.iKT = true;
        }

        @Override // com.baidu.tieba.g.a.InterfaceC0740a
        public void cg(int i, int i2) {
        }

        @Override // com.baidu.tieba.g.a.InterfaceC0740a
        public void J(int i, int i2) {
        }
    };
    private View.OnClickListener jEy = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.e.31
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (e.this.iqW != null) {
                e.this.iqW.hideTip();
            }
        }
    };
    private final CustomMessageListener jEz = new CustomMessageListener(CmdConfigCustom.CMD_RELOAD_HP_PERSONALIZED) { // from class: com.baidu.tieba.homepage.personalize.e.32
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (e.this.iOd != null) {
                e.this.irb.cJS();
                e.this.jBW = false;
                e.this.jwo.setRefreshing(true);
            }
        }
    };
    private final CustomMessageListener jEA = new CustomMessageListener(2921461) { // from class: com.baidu.tieba.homepage.personalize.e.33
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (e.this.iOd != null) {
                e.this.cKJ();
            }
        }
    };
    private final CustomMessageListener jEB = new CustomMessageListener(2921486) { // from class: com.baidu.tieba.homepage.personalize.e.34
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data = customResponsedMessage.getData();
            switch (data instanceof Integer ? ((Integer) data).intValue() : 0) {
                case 2:
                    new BdTopToast(e.this.mPageContext.getPageActivity(), 2000).yr(true).Ue(e.this.mPageContext.getPageActivity().getString(R.string.youngster_open_title)).aF((ViewGroup) e.this.mPageContext.getPageActivity().findViewById(R.id.maintabContainer));
                    e.this.rf(true);
                    return;
                case 3:
                    new BdTopToast(e.this.mPageContext.getPageActivity(), 2000).yr(true).Ue(e.this.mPageContext.getPageActivity().getString(R.string.youngster_close_title)).aF((ViewGroup) e.this.mPageContext.getPageActivity().findViewById(R.id.maintabContainer));
                    e.this.rf(false);
                    return;
                case 4:
                default:
                    if (com.baidu.tbadk.youngster.b.c.bGL()) {
                        e.this.rf(true);
                        return;
                    }
                    return;
                case 5:
                    new BdTopToast(e.this.mPageContext.getPageActivity(), 2000).yr(true).Ue(e.this.mPageContext.getPageActivity().getString(R.string.youngster_reset_title)).aF((ViewGroup) e.this.mPageContext.getPageActivity().findViewById(R.id.maintabContainer));
                    e.this.rf(true);
                    return;
            }
        }
    };
    private CustomMessageListener jco = new CustomMessageListener(CmdConfigCustom.PB_ACTION_PRAISE) { // from class: com.baidu.tieba.homepage.personalize.e.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            bx bxVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bx) && e.this.jEi != null && com.baidu.tbadk.core.util.y.getCount(e.this.jEi.thread_list) != 0 && (bxVar = (bx) customResponsedMessage.getData()) != null && bxVar.bln() != null && bxVar.getId() != null && com.baidu.tbadk.core.util.y.getCount(e.this.jEi.thread_list) != 0) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < e.this.jEi.thread_list.size()) {
                        ThreadInfo threadInfo = e.this.jEi.thread_list.get(i2);
                        if (threadInfo == null || threadInfo.id.longValue() != com.baidu.adp.lib.f.b.toLong(bxVar.getId(), -1L)) {
                            i = i2 + 1;
                        } else {
                            ThreadInfo.Builder builder = new ThreadInfo.Builder(threadInfo);
                            Zan.Builder builder2 = new Zan.Builder(builder.zan);
                            builder2.num = Integer.valueOf((int) bxVar.bln().getNum());
                            builder.zan = builder2.build(true);
                            e.this.jEi.thread_list.set(i2, builder.build(true));
                            return;
                        }
                    } else {
                        return;
                    }
                }
            }
        }
    };
    private CustomMessageListener jEC = new CustomMessageListener(CmdConfigCustom.CMD_LIVE_VIDEO_CLOSED_QUERY_RESPONSED) { // from class: com.baidu.tieba.homepage.personalize.e.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            bx bxVar;
            if (customResponsedMessage.getOrginalMessage() instanceof LiveRoomClosedQueryMessage) {
                List<Long> ids = ((LiveRoomClosedQueryMessage) customResponsedMessage.getOrginalMessage()).getIds();
                List<Object> originData = ((LiveRoomClosedQueryMessage) customResponsedMessage.getOrginalMessage()).getOriginData();
                if (!com.baidu.tbadk.core.util.y.isEmpty(e.this.mDataList) && !com.baidu.tbadk.core.util.y.isEmpty(ids) && !com.baidu.tbadk.core.util.y.isEmpty(originData)) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= originData.size()) {
                            break;
                        }
                        if ((originData.get(i2) instanceof bx) && (bxVar = (bx) originData.get(i2)) != null && bxVar.blW() != null && ids.contains(Long.valueOf(bxVar.blW().live_id))) {
                            e.this.mDataList.remove(bxVar);
                        }
                        i = i2 + 1;
                    }
                    if (e.this.jDy != null) {
                        e.this.jDy.cr(new ArrayList(e.this.mDataList));
                    }
                }
            }
        }
    };
    private CustomMessageListener eMu = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.homepage.personalize.e.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int intValue;
            if ((customResponsedMessage instanceof UpdateAttentionMessage) && e.this.jEi != null && !com.baidu.tbadk.core.util.y.isEmpty(e.this.jEi.thread_list)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid)) {
                    int i = 0;
                    while (true) {
                        if (i >= e.this.jEi.thread_list.size()) {
                            break;
                        }
                        ThreadInfo threadInfo = e.this.jEi.thread_list.get(i);
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
                            e.this.jEi.thread_list.set(i, builder.build(true));
                        }
                    }
                    e.this.a(updateAttentionMessage);
                }
            }
        }
    };
    private CustomMessageListener jwE = new CustomMessageListener(0) { // from class: com.baidu.tieba.homepage.personalize.e.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long) && e.this.jEi != null && e.this.jEi.hot_recomforum != null && !com.baidu.tbadk.core.util.y.isEmpty(e.this.jEi.hot_recomforum.tab_list)) {
                long longValue = ((Long) customResponsedMessage.getData()).longValue();
                DiscoverHotForum.Builder builder = new DiscoverHotForum.Builder(e.this.jEi.hot_recomforum);
                if (com.baidu.tieba.homepage.concern.c.a(builder, longValue, customResponsedMessage.getCmd() == 2001335)) {
                    e.this.jEi.hot_recomforum = builder.build(true);
                    e.this.c(new DataRes.Builder(e.this.jEi.build(true)));
                }
            }
        }
    };
    private String jED = "lastReadReadPositionKey";
    private int jEE = 0;
    private d jEG = new d() { // from class: com.baidu.tieba.homepage.personalize.e.16
        @Override // com.baidu.tieba.homepage.personalize.d
        public void BQ(final int i) {
            if (e.this.jEF == null) {
                e.this.jEF = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.e.16.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (e.this.iOd.getHandler() != null) {
                            e.this.iOd.requestFocusFromTouch();
                            if (i <= e.this.iOd.getCount() - 1) {
                                e.this.iOd.setSelection(i);
                            }
                        }
                    }
                };
            }
            e.this.iOd.removeCallbacks(e.this.jEF);
            e.this.iOd.post(e.this.jEF);
        }
    };
    private CustomMessageListener jEH = new CustomMessageListener(2016569) { // from class: com.baidu.tieba.homepage.personalize.e.19
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && e.this.jEq != null) {
                e.this.mDataList.remove(e.this.jEq);
                e.this.jDy.cr(new ArrayList(e.this.mDataList));
                com.baidu.tbadk.core.sharedPref.b.bpu().putLong("key_maintab_banner_close_time", System.currentTimeMillis());
            }
        }
    };
    private CustomMessageListener iqQ = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.homepage.personalize.e.20
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.g(customResponsedMessage);
            if (e.this.irb != null && e.this.jBW) {
                e.this.irb.a(e.this.iKj, e.this.ghD, e.this.iKT, true);
            }
        }
    };
    private CustomMessageListener iqR = new CustomMessageListener(CmdConfigCustom.CMD_THREAD_NOT_EXIST_WHEN_ENTER_PB) { // from class: com.baidu.tieba.homepage.personalize.e.21
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.g(customResponsedMessage);
        }
    };
    private CustomMessageListener jcD = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.homepage.personalize.e.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && e.this.jEi != null && com.baidu.tbadk.core.util.y.getCount(e.this.jEi.thread_list) != 0) {
                String str = (String) customResponsedMessage.getData();
                e.this.h(str, e.this.mDataList);
                e.this.Lq(str);
                if (e.this.jDy != null) {
                    e.this.jDy.cr(new ArrayList(e.this.mDataList));
                }
                if (e.this.irb != null && e.this.jBW) {
                    e.this.irb.a(e.this.iKj, e.this.ghD, e.this.iKT, true);
                }
            }
        }
    };
    private CustomMessageListener iJR = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.homepage.personalize.e.24
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            am cJT;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent)) {
                KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24 && (cJT = e.this.cJT()) != null && cJT.tW() != null) {
                    cJT.tW().b(new a.C0096a(3));
                }
            }
        }
    };
    private com.baidu.adp.framework.listener.a jEI = new com.baidu.adp.framework.listener.a(1003065, CmdConfigSocket.CMD_TOPIC_BLESS) { // from class: com.baidu.tieba.homepage.personalize.e.25
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
                        if ((qVar instanceof com.baidu.tieba.homepage.topic.topictab.b.a) && (bVar = ((com.baidu.tieba.homepage.topic.topictab.b.a) qVar).jLz) != null && longValue == bVar.pkId) {
                            bVar.userPkId = j2;
                            return;
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener iJS = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.homepage.personalize.e.26
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            List<q> dataList = e.this.jDy.getDataList();
            if (!com.baidu.tbadk.core.util.y.isEmpty(dataList)) {
                for (q qVar : dataList) {
                    if (qVar instanceof k) {
                        k kVar = (k) qVar;
                        if (kVar.eBO != 0 && kVar.evQ != null) {
                            int[] imageWidthAndHeight = kVar.evQ.getImageWidthAndHeight();
                            kVar.eBO = imageWidthAndHeight[0];
                            kVar.eBP = imageWidthAndHeight[1];
                        }
                    }
                }
            }
            com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.personalize.e.26.1
                @Override // java.lang.Runnable
                public void run() {
                    e.this.jDy.notifyDataSetChanged();
                    if (!e.this.mIsBackground && e.this.jBW) {
                        e.this.irb.a(e.this.iKj, e.this.ghD, e.this.iKT, true);
                    }
                }
            }, 500L);
        }
    };
    private CustomMessageListener iqS = new CustomMessageListener(2921453) { // from class: com.baidu.tieba.homepage.personalize.e.27
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bf)) {
                bf bfVar = (bf) customResponsedMessage.getData();
                if (bfVar.eAN == 1) {
                    int equipmentWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst());
                    int equipmentHeight = l.getEquipmentHeight(TbadkCoreApplication.getInst());
                    float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
                    int i = av.bqC().bqD() ? 2 : 1;
                    RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
                    requestGetMyPostNetMessage.setTag(e.this.jEw);
                    requestGetMyPostNetMessage.setParams(com.baidu.adp.lib.f.b.toLong(bfVar.tid, 0L), 0L, 0L, equipmentWidth, equipmentHeight, f, i);
                    requestGetMyPostNetMessage.setBFrom("push");
                    MessageManager.getInstance().sendMessage(requestGetMyPostNetMessage);
                }
            }
        }
    };
    private final com.baidu.adp.framework.listener.a iqT = new com.baidu.adp.framework.listener.a(1003010, CmdConfigSocket.CMD_GET_MY_POST) { // from class: com.baidu.tieba.homepage.personalize.e.28
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            GetMyPostResIdl getMyPostResIdl = null;
            if (responsedMessage instanceof GetMyPostHttpResponseMessage) {
                getMyPostResIdl = ((GetMyPostHttpResponseMessage) responsedMessage).getResponseData();
            } else if (responsedMessage instanceof GetMyPostSocketResponseMessage) {
                getMyPostResIdl = ((GetMyPostSocketResponseMessage) responsedMessage).getResponseData();
            }
            if (getMyPostResIdl != null && getMyPostResIdl.data != null && getMyPostResIdl.data.thread_info != null) {
                e.this.jEx = getMyPostResIdl.data.thread_info;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921455));
            }
        }
    };
    private CustomMessageListener jEJ = new CustomMessageListener(2921482) { // from class: com.baidu.tieba.homepage.personalize.e.29
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
        void D(int i, int i2, int i3, int i4);

        void U(int i, int i2, int i3);

        void cKw();

        void onError(int i, String str);

        void onSuccess();
    }

    public void rc(boolean z) {
        this.jEr = z;
        if (this.iqW != null && !z) {
            this.iqW.hideTip();
        }
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.jDm = scrollFragmentTabHost;
        if (this.jDm != null) {
            this.jDm.setOnTabSelectedListener(new ScrollFragmentTabHost.b() { // from class: com.baidu.tieba.homepage.personalize.e.1
                @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.b
                public void Ca(int i) {
                    if (e.this.jDm.BZ(i) != 1 && e.this.iqW != null) {
                        e.this.iqW.hideTip();
                    }
                }
            });
        }
    }

    public void setTabInForeBackgroundState(boolean z) {
        this.mIsBackground = z;
    }

    public void pI(boolean z) {
        boolean z2 = false;
        this.mIsBackground = z;
        if (this.jDm != null) {
            this.jDm.pI(z);
        }
        if (this.irb != null) {
            this.irb.ta(!z);
            am cJT = cJT();
            if (cJT != null && cJT.tW() != null) {
                z2 = cJT.tW().b(new a.C0096a(8, Boolean.valueOf(z)));
            }
            if (!z2) {
                if (z) {
                    this.irb.cJS();
                } else if (this.jBW) {
                    this.irb.a(this.iKj, this.ghD, this.iKT, true);
                }
            }
        }
    }

    public e(TbPageContext<?> tbPageContext, BdTypeRecyclerView bdTypeRecyclerView, af afVar, BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout) {
        this.jEv = 0;
        this.mPageContext = tbPageContext;
        this.jEv = com.baidu.tbadk.core.sharedPref.b.bpu().getInt("key_personalized_refresh_type", 0);
        this.jwo = bigdaySwipeRefreshLayout;
        this.iOd = bdTypeRecyclerView;
        this.iOd.setOnTouchListener(this.fyo);
        if (com.baidu.tbadk.youngster.b.c.bGL()) {
            rf(true);
        }
        this.jjH = new com.baidu.tieba.g.a();
        this.jjH.a(this.igS);
        this.jDy = afVar;
        this.jEl = new com.baidu.tieba.homepage.personalize.model.a();
        this.jEf = com.baidu.tbadk.core.sharedPref.b.bpu().getLong("recommend_frs_cache_time", 1800L) * 1000;
        bdTypeRecyclerView.setOnScrollListener(this.mOnScrollListener);
        this.iqW = new be();
        cKH();
        this.irb = new i(this.mPageContext, this.iOd);
        this.irb.HS(1);
        this.irb.HR(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.jEg = new b(this.mDataList, this.jDy);
        this.iqX = new SmartBubbleAnimatedView(tbPageContext.getContext());
        this.iqX.setLayoutParams(new FrameLayout.LayoutParams(-1, l.getDimens(tbPageContext.getContext(), R.dimen.tbds83)));
        cKx();
        this.iJS.setTag(this.mPageContext.getUniqueId());
        MessageManager.getInstance().registerListener(this.iJS);
        if (MessageManager.getInstance().findTask(1003010) == null) {
            HomePageStatic.cIc();
        }
        this.iqT.setTag(this.jEw);
        if (this.iqT.getHttpMessageListener() != null) {
            this.iqT.getHttpMessageListener().setSelfListener(true);
        }
        if (this.iqT.getSocketMessageListener() != null) {
            this.iqT.getSocketMessageListener().setSelfListener(true);
        }
        MessageManager.getInstance().registerListener(this.iqT);
        MessageManager.getInstance().registerListener(this.iqS);
        MessageManager.getInstance().registerListener(this.jEJ);
    }

    private void cKx() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2016323, new CustomMessageTask.CustomRunnable<Boolean>() { // from class: com.baidu.tieba.homepage.personalize.e.35
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Boolean> customMessage) {
                am cJT = e.this.cJT();
                return (cJT == null || cJT.tW() == null) ? new CustomResponsedMessage<>(2016323, false) : new CustomResponsedMessage<>(2016323, Boolean.valueOf(cJT.tW().b(new a.C0096a(6))));
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private boolean cKy() {
        return com.baidu.tbadk.core.sharedPref.b.bpu().getBoolean(cKA(), true);
    }

    private void cKz() {
        com.baidu.tbadk.core.sharedPref.b.bpu().putBoolean(cKA(), false);
    }

    private String cKA() {
        return "key_rec_pfirst_load_" + TbadkCoreApplication.getCurrentAccount() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + TbConfig.getVersion();
    }

    public void setRecommendFrsNavigationAnimDispatcher(z zVar) {
        if (zVar != null) {
            this.fyn = zVar.bDj();
            this.fjT = zVar.bDk();
        }
    }

    public void showFloatingView() {
        if (this.fyn != null) {
            this.fyn.showFloatingView(true);
        }
    }

    public void update() {
        com.baidu.tieba.homepage.framework.a.cIM().C(System.currentTimeMillis(), 1);
        this.mPn = 1;
        this.jEp = true;
        if (this.mDataList.size() == 0 && !cKy()) {
            if (!this.jwz) {
                biV();
                return;
            }
            return;
        }
        biU();
    }

    public void cE(int i, int i2) {
        bx bxVar;
        if (!com.baidu.tbadk.core.util.y.isEmpty(this.mDataList) && this.mDataList.size() > i) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            while (i < this.mDataList.size() && i <= i2) {
                if (this.mDataList.get(i).getType().getId() == bx.eCp.getId() && (bxVar = (bx) this.mDataList.get(i)) != null && bxVar.blW() != null) {
                    arrayList.add(Long.valueOf(bxVar.blW().live_id));
                    arrayList2.add(bxVar);
                }
                i++;
            }
            if (!com.baidu.tbadk.core.util.y.isEmpty(arrayList)) {
                MessageManager.getInstance().sendMessage(new LiveRoomClosedQueryMessage(arrayList, arrayList2));
            }
        }
    }

    public void cKB() {
        if (this.irb != null && !this.mIsBackground && this.jBW) {
            this.irb.a(this.iKj, this.ghD, this.iKT, true);
        }
        if (this.jEn) {
            if (this.jwo != null && !this.jwo.brY()) {
                if (this.jtO) {
                    com.baidu.tieba.t.c.dIO().b(this.jEt, false);
                    if (re(false)) {
                        cF(3, this.jEk);
                    } else if (this.jEo > 0) {
                        cF(2, this.jEk);
                    }
                } else if (!this.jtO && this.jEk == 0) {
                    cF(2, 0);
                }
            }
            this.jEn = false;
            this.jtO = false;
            this.jEo = 0;
            if (this.jEp) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
            }
            this.jEp = false;
        }
    }

    public void bOb() {
        if (isLoading()) {
            com.baidu.tieba.homepage.framework.a.cIM().C(0L, 1);
        } else if (this.jEh != null) {
            cKD();
            this.mPn++;
            setIsLoading(true);
            this.jEh.D(this.mPn, (this.jEi == null || this.jEi.thread_list == null) ? 0 : this.jEi.thread_list.size(), rd(false), 0);
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
            g.cKO();
        }
        if (this.jEl != null && this.jEl.cLi() && !z && (dataRes == null || com.baidu.tbadk.core.util.y.isEmpty(dataRes.thread_list))) {
            if (dataRes == null) {
                DataRes.Builder builder = new DataRes.Builder();
                builder.thread_list = new ArrayList();
                dataRes = builder.build(false);
            }
            if (dataRes.thread_list != null) {
                List<ThreadInfo> cLj = this.jEl.cLj();
                dataRes.thread_list.addAll(cLj);
                if (cLj != null) {
                    cLj.clear();
                }
                z3 = true;
                size = (this.jEi != null || this.jEi.thread_list == null) ? 0 : this.jEi.thread_list.size();
                if (z && i == 0 && dataRes != null && com.baidu.tbadk.core.util.y.isEmpty(dataRes.thread_list)) {
                    if (this.jEh != null) {
                        this.jEh.cKw();
                    }
                    setIsLoading(false);
                    if (this.jwo != null) {
                        this.jwo.setRefreshing(false);
                        return;
                    }
                    return;
                }
                if (this.jEx != null) {
                    DataRes.Builder builder2 = new DataRes.Builder(dataRes);
                    builder2.thread_list.add(0, this.jEx);
                    dataRes = builder2.build(false);
                    if (this.jEi != null && !com.baidu.tbadk.core.util.y.isEmpty(this.jEi.thread_list)) {
                        Iterator<ThreadInfo> it = this.jEi.thread_list.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            ThreadInfo next = it.next();
                            if (next != null && next.tid != null && this.jEx.tid != null && next.tid.longValue() == this.jEx.tid.longValue()) {
                                this.jEi.thread_list.remove(next);
                                break;
                            }
                        }
                    }
                    this.jEx = null;
                }
                if ((z3 && i != 0) || dataRes == null || !a(true, z, z2, dataRes)) {
                    this.jEn = false;
                    if (this.mDataList.size() > 0) {
                        if (this.jEh != null) {
                            this.jEh.onError(1, str);
                        }
                    } else if (this.jEh != null) {
                        this.jEh.onError(2, str);
                    }
                } else {
                    cKz();
                    if (this.jEh != null) {
                        com.baidu.tbadk.core.sharedPref.b.bpu().putLong(SharedPrefConfig.RECOMMEND_FRS_REFRESH_TIME + TbadkCoreApplication.getCurrentAccount(), System.currentTimeMillis());
                        this.jEh.onSuccess();
                    }
                    this.jEn = true;
                    this.jtO = z;
                    this.jEo = size;
                    crc();
                }
                setIsLoading(false);
                if (this.jwo == null) {
                    f.e cKC = cKC();
                    if (this.jwo.brY() && cKC != null) {
                        this.jwo.c(cKC);
                        return;
                    } else {
                        this.jwo.setRefreshing(false);
                        return;
                    }
                }
                return;
            }
        }
        z3 = false;
        if (this.jEi != null) {
        }
        if (z) {
        }
        if (this.jEx != null) {
        }
        if (z3) {
        }
        cKz();
        if (this.jEh != null) {
        }
        this.jEn = true;
        this.jtO = z;
        this.jEo = size;
        crc();
        setIsLoading(false);
        if (this.jwo == null) {
        }
    }

    private f.e cKC() {
        int i;
        String feedText;
        if (!this.jEn || this.jwo == null || !this.jwo.brY() || cKG()) {
            return null;
        }
        int i2 = this.jEk;
        if (this.jtO) {
            com.baidu.tieba.t.c.dIO().b(this.jEt, false);
            if (re(false)) {
                i = 3;
            } else {
                i = this.jEo > 0 ? 2 : 0;
            }
        } else if (this.jtO || this.jEk != 0) {
            return null;
        } else {
            i2 = 0;
            i = 2;
        }
        if (this.jDm != null) {
            this.iqW.cAj();
        }
        if (this.jDm != null && this.jDm.getCurrentTabType() != 1) {
            this.iqW.hideTip();
            return null;
        } else if (!this.jEr) {
            this.iqW.hideTip();
            return null;
        } else {
            this.jEj = i;
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
                this.iNj = 1000;
            } else {
                this.iNj = 0;
            }
            return new f.e(feedText, this.iNj);
        }
    }

    public void qP(boolean z) {
        if (z) {
            this.jDy.notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        if (this.irb != null) {
            this.irb.destroy();
        }
        if (this.iqW != null) {
            this.iqW.onDestroy();
        }
        if (this.jEg != null) {
            this.jEg.onDestroy();
        }
        if (this.iOd != null) {
            this.iOd.removeCallbacks(this.jEF);
        }
        MessageManager.getInstance().unRegisterTask(2016323);
        MessageManager.getInstance().unRegisterListener(this.iJS);
        MessageManager.getInstance().unRegisterListener(this.iqS);
        MessageManager.getInstance().unRegisterListener(this.iqT);
        MessageManager.getInstance().unRegisterListener(this.jEJ);
    }

    public void onPause() {
        c.d(this.iOd);
        Ci(this.jEE);
        if (this.jEm != null) {
            this.jEm.bBC();
        }
    }

    private void biU() {
        if (this.jEh != null) {
            this.jEh.U((this.jEi == null || this.jEi.thread_list == null || cKF()) ? 0 : this.jEi.thread_list.size(), rd(true), 0);
        }
    }

    public int rd(boolean z) {
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
                if (!(qVar instanceof com.baidu.tieba.card.data.b) || (i3 = ((com.baidu.tieba.card.data.b) qVar).position) == i6) {
                    i3 = i6;
                    i4 = i7;
                } else {
                    i4 = i7 + 1;
                }
                if (!(qVar instanceof com.baidu.tieba.homepage.personalize.data.a) || qVar.getType() == AdvertAppInfo.ewR) {
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
                if (!(qVar2 instanceof com.baidu.tieba.card.data.b) || (i = ((com.baidu.tieba.card.data.b) qVar2).position) == i9) {
                    i = i9;
                    i2 = i8;
                } else {
                    i2 = i8 + 1;
                }
                if ((qVar2 instanceof com.baidu.tieba.homepage.personalize.data.a) && qVar2.getType() != AdvertAppInfo.ewR) {
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
        this.jwz = true;
        if (dataRes != null) {
            if (a(false, true, true, dataRes) && !cKF()) {
                if (this.jEh != null) {
                    this.jEh.onSuccess();
                    Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler() { // from class: com.baidu.tieba.homepage.personalize.e.2
                        @Override // android.os.MessageQueue.IdleHandler
                        public boolean queueIdle() {
                            e.this.bBH();
                            return false;
                        }
                    });
                }
                if (TbSingleton.getInstance().getForceRefreshHomeRecommend()) {
                    biU();
                    TbSingleton.getInstance().setForceRefreshHomeRecommend(false);
                    return;
                }
                return;
            }
            biU();
            return;
        }
        biU();
    }

    public void bBH() {
        n.bBO().dW(System.currentTimeMillis() - n.bBO().bBN());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.util.Set] */
    private void i(List<q> list, int i) {
        AdvertAppInfo coq;
        AdvertAppInfo coq2;
        if (!com.baidu.tbadk.core.util.y.isEmpty(list)) {
            Set<q> Rc = com.baidu.tieba.recapp.report.a.Rc("NEWINDEX");
            HashSet hashSet = Rc == null ? new HashSet() : Rc;
            HashSet hashSet2 = new HashSet();
            for (q qVar : list) {
                if (qVar != null) {
                    for (q qVar2 : hashSet) {
                        if ((qVar instanceof com.baidu.tieba.card.data.d) && (coq2 = ((com.baidu.tieba.card.data.d) qVar).coq()) != null && qVar2 != null && (qVar2 instanceof AdvertAppInfo) && qVar2.hashCode() == coq2.hashCode()) {
                            coq2.advertAppContext = ((AdvertAppInfo) qVar2).advertAppContext;
                        }
                    }
                    if (qVar != null && (qVar instanceof com.baidu.tieba.card.data.d) && (coq = ((com.baidu.tieba.card.data.d) qVar).coq()) != null && coq.advertAppContext == null) {
                        coq.advertAppContext = new com.baidu.tbadk.core.data.c();
                        coq.advertAppContext.page = "NEWINDEX";
                        coq.advertAppContext.pn = this.mPn;
                        coq.advertAppContext.extensionInfo = coq.extensionInfo;
                        coq.advertAppContext.YS = false;
                        hashSet2.add(coq);
                    }
                }
            }
            hashSet.addAll(hashSet2);
            com.baidu.tieba.recapp.report.a.b("NEWINDEX", hashSet);
            if (hashSet2.size() > 0) {
                com.baidu.tieba.t.c.dIO().b(this.jEt, com.baidu.tieba.t.a.b(PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE, "common_fill", true, hashSet2.size()));
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
        if (this.jEv == 1) {
            if (z2 && (dataRes.thread_list.size() >= 6 || cKF())) {
                cKE();
                this.jEi = null;
            }
        } else if (z2 && cKF()) {
            this.jEi = null;
        }
        int size = z2 ? 0 : this.mDataList.size();
        DataRes.Builder builder = new DataRes.Builder(dataRes);
        this.mDataList.clear();
        com.baidu.tieba.homepage.personalize.model.c a2 = this.jEl.a(z, this.jEi, builder, z2 ? 0 : 1);
        if (a2 == null) {
            list = null;
            i = 0;
        } else {
            List<q> list2 = a2.fNt;
            this.jEk = a2.jHq;
            int i2 = a2.jHr;
            a2.jHr = 0;
            list = list2;
            i = i2;
        }
        if (list != null) {
            this.mDataList.addAll(list);
            i(list, size);
            a(z2 ? 0 : 1, list, size);
            if (this.jEp) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
            }
        }
        if (this.jEi == null) {
            this.jEi = builder;
            this.jEg.dL(this.jEi.thread_list);
        }
        if (this.mDataList.size() == 0) {
            z4 = false;
        } else {
            if (z2) {
                if (dataRes.live_answer != null) {
                    this.jEq = new h();
                    this.jEq.a(dataRes.live_answer);
                    this.jEi.live_answer = dataRes.live_answer;
                } else if (z) {
                    this.jEq = null;
                    this.jEi.live_answer = null;
                }
                this.jEs = dataRes.float_info;
                this.jEi.float_info = dataRes.float_info;
            }
            long j = com.baidu.tbadk.core.sharedPref.b.bpu().getLong("key_maintab_banner_close_time", 0L);
            if (this.jEq != null && !au.isTaday(j)) {
                this.mDataList.add(0, this.jEq);
            }
            LinkedList linkedList = new LinkedList(this.mDataList);
            this.jDy.setFromCDN(dataRes.is_new_url != null && dataRes.is_new_url.intValue() == 1);
            this.jDy.j(linkedList, i);
            z4 = true;
            if (this.irb != null && this.jBW) {
                this.irb.a(this.iKj, this.ghD, this.iKT, true);
            }
        }
        com.baidu.tieba.homepage.framework.a.cIM().A(System.currentTimeMillis() - currentTimeMillis, 1);
        long BP = com.baidu.tieba.homepage.framework.a.cIM().BP(1);
        if (BP > 0) {
            com.baidu.tieba.homepage.framework.a.cIM().B(System.currentTimeMillis() - BP, 1);
            com.baidu.tieba.homepage.framework.a.cIM().C(0L, 1);
        }
        if (dataRes.anti != null && dataRes.anti.block_pop_info != null) {
            com.baidu.tieba.ueg.d.d(dataRes.anti.block_pop_info);
        }
        bh bhVar = new bh();
        bhVar.a(dataRes.recom_post_topic);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_REFRESH_TOPIC_TIP, bhVar));
        return z4;
    }

    private void cKD() {
        List<q> list;
        int i;
        if (com.baidu.tbadk.core.util.y.getCount(this.mDataList) >= this.jEl.cLe() - 40) {
            com.baidu.tieba.homepage.personalize.model.c a2 = this.jEl.a(true, this.jEi, null, 1);
            if (a2 != null) {
                List<q> list2 = a2.fNt;
                i = a2.jHr;
                a2.jHr = 0;
                list = list2;
            } else {
                list = null;
                i = 0;
            }
            if (list != null) {
                this.mDataList.clear();
                this.mDataList.addAll(list);
                this.jDy.j(new LinkedList(this.mDataList), i);
            }
        }
    }

    private void biV() {
        this.jwz = true;
        ad.a(new ac<DataRes>() { // from class: com.baidu.tieba.homepage.personalize.e.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.ac
            /* renamed from: cKK */
            public DataRes doInBackground() {
                com.baidu.adp.lib.cache.l<byte[]> dF = com.baidu.tbadk.core.c.a.bob().dF("tb.rec_frs_update", TbadkCoreApplication.getCurrentAccount());
                if (dF == null) {
                    return null;
                }
                byte[] bArr = dF.get("0");
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

    private void crc() {
        if (this.jEi != null) {
            DataRes.Builder builder = new DataRes.Builder(this.jEi.build(true));
            if (builder.thread_list != null && builder.thread_list.size() > 30) {
                builder.thread_list = builder.thread_list.subList(0, 30);
            }
            a(builder, builder.thread_list != null ? builder.thread_list.size() : 0);
            a(builder);
            b(builder);
            c(builder);
        }
    }

    private void cKE() {
        if (this.jEi != null) {
            final DataRes.Builder builder = new DataRes.Builder(this.jEi.build(true));
            if (builder.thread_list != null && builder.thread_list.size() > 50) {
                builder.thread_list = builder.thread_list.subList(0, 50);
            }
            a(builder, builder.thread_list != null ? builder.thread_list.size() : 0);
            ad.a(new ac<Object>() { // from class: com.baidu.tieba.homepage.personalize.e.5
                @Override // com.baidu.tbadk.util.ac
                public Object doInBackground() {
                    DataRes.Builder builder2 = new DataRes.Builder(builder.build(true));
                    e.this.jEg.dM(builder2.thread_list);
                    try {
                        com.baidu.tbadk.core.c.a.bob().dF("tb.rec_old_data", TbadkCoreApplication.getCurrentAccount()).setForever("0", builder2.build(true).toByteArray());
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
    public void Lq(String str) {
        if (!TextUtils.isEmpty(str) && this.jEi != null && this.jEi.banner_list != null && this.jEi.banner_list.app != null && this.jEi.banner_list.app.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (App app : this.jEi.banner_list.app) {
                if (app != null && str.equals(app.id)) {
                    arrayList.add(app);
                }
            }
            BannerList.Builder builder = new BannerList.Builder(this.jEi.banner_list);
            if (builder.app != null) {
                builder.app.removeAll(arrayList);
            }
            this.jEi.banner_list = builder.build(false);
            DataRes.Builder builder2 = new DataRes.Builder(this.jEi.build(true));
            builder2.banner_list = builder.build(true);
            c(builder2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final DataRes.Builder builder) {
        ad.a(new ac<Object>() { // from class: com.baidu.tieba.homepage.personalize.e.6
            @Override // com.baidu.tbadk.util.ac
            public Object doInBackground() {
                DataRes.Builder builder2 = new DataRes.Builder(builder.build(true));
                e.this.jEg.dM(builder2.thread_list);
                try {
                    com.baidu.tbadk.core.c.a.bob().dF("tb.rec_frs_update", TbadkCoreApplication.getCurrentAccount()).setForever("0", builder2.build(true).toByteArray());
                    return null;
                } catch (Exception e) {
                    BdLog.e(e);
                    return null;
                }
            }
        }, null);
    }

    private boolean cKF() {
        return re(true);
    }

    private boolean re(boolean z) {
        long j = com.baidu.tbadk.core.sharedPref.b.bpu().getLong(SharedPrefConfig.RECOMMEND_FRS_REFRESH_TIME + TbadkCoreApplication.getCurrentAccount(), 0L);
        return j == 0 ? z : Math.abs(System.currentTimeMillis() - j) > this.jEf;
    }

    public void a(a aVar) {
        this.jEh = aVar;
    }

    private boolean isLoading() {
        return this.mIsLoading;
    }

    private void setIsLoading(boolean z) {
        this.mIsLoading = z;
    }

    public void cKr() {
        boolean z = true;
        com.baidu.tbadk.coreExtra.data.b activityPrizeData = TbadkCoreApplication.getInst().getActivityPrizeData();
        if (activityPrizeData.isSwitchTurn() && !StringUtils.isNull(activityPrizeData.getFeedText())) {
            String currentDay = UtilHelper.getCurrentDay();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            String str = "";
            if (!StringUtils.isNull(currentAccount)) {
                String string = com.baidu.tbadk.core.sharedPref.b.bpu().getString(SharedPrefConfig.ACTIVITY_PRIZE_FEED_TEXT_TIME, "");
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
                    cF(4, 0);
                    com.baidu.tbadk.core.sharedPref.b.bpu().putString(SharedPrefConfig.ACTIVITY_PRIZE_FEED_TEXT_TIME, str);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rf(boolean z) {
        boolean z2 = com.baidu.tbadk.core.sharedPref.b.bpu().getBoolean("key_youngster_homgpage_top_view_closed", false);
        if (this.iOd != null && !z2) {
            if (z) {
                if (this.jEu == null) {
                    this.jEu = new HomePageYoungsterTopView(this.mPageContext);
                    this.jEu.setOnDeleteClick(new HomePageYoungsterTopView.a() { // from class: com.baidu.tieba.homepage.personalize.e.7
                        @Override // com.baidu.tieba.homepage.personalize.view.HomePageYoungsterTopView.a
                        public void cKL() {
                            new BdTopToast(e.this.mPageContext.getPageActivity(), 2000).yr(true).Ue(e.this.mPageContext.getPageActivity().getString(R.string.youngster_frs_top_toast)).aF((ViewGroup) e.this.mPageContext.getPageActivity().findViewById(R.id.maintabContainer));
                            e.this.rf(false);
                            com.baidu.tbadk.core.sharedPref.b.bpu().putBoolean("key_youngster_homgpage_top_view_closed", true);
                        }
                    });
                }
                this.iOd.setHeaderView(this.jEu, false);
                this.jEu.setVisibility(0);
                this.iOd.scrollToPosition(0);
            } else if (this.jEu != null) {
                this.jEu.setVisibility(8);
                this.iOd.removeHeaderView(this.jEu);
                this.jEu = null;
            }
        }
    }

    private boolean cKG() {
        return this.jEu != null && this.jEu.getVisibility() == 0;
    }

    private void cF(int i, int i2) {
        if (!cKG()) {
            if (this.jDm != null) {
                this.iqW.cAj();
            }
            if (this.jDm != null && this.jDm.getCurrentTabType() != 1) {
                this.iqW.hideTip();
            } else if (!this.jEr) {
                this.iqW.hideTip();
            } else {
                this.jEj = i;
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
                        this.iNj = 3000;
                    } else {
                        this.iNj = 2000;
                    }
                    this.iqX.eUZ = str;
                    this.iqX.iNc = this.iNj;
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 49;
                    if (this.jDm != null) {
                        FrameLayout frameLayout = this.jDm.getFrameLayout();
                        frameLayout.removeView(this.iqX);
                        frameLayout.addView(this.iqX, layoutParams);
                        this.iqX.cAh();
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(Long l) {
        if (this.jEi != null && this.jEi.thread_list != null) {
            List<ThreadInfo> list = this.jEi.thread_list;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                ThreadInfo threadInfo = list.get(i);
                if (threadInfo.tid.equals(l) && threadInfo.top_agree_post != null) {
                    ThreadInfo.Builder builder = new ThreadInfo.Builder(threadInfo);
                    builder.top_agree_post = null;
                    list.set(i, builder.build(true));
                    crc();
                    a(false, true, false, this.jEi.build(true));
                    return;
                }
            }
        }
    }

    public void o(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.jEt = bdUniqueId;
            if (this.jco != null) {
                this.jco.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.jco);
            }
            if (this.jEz != null) {
                this.jEz.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.jEz);
            }
            this.jEA.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.jEA);
            this.eMu.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.eMu);
            this.jwE.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_LIKE_FORUM, this.jwE);
            MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_UNLIKE_FORUM, this.jwE);
            this.jEC.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.jEC);
            this.iqQ.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.iqQ);
            this.iqR.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.iqR);
            this.jcD.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.jcD);
            if (this.irb != null) {
                this.irb.setUniqueId(bdUniqueId);
            }
            this.jEg.l(bdUniqueId);
            this.jEH.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.jEH);
            this.iJR.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.iJR);
            this.jEI.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.jEI);
            this.jEB.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.jEB);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(UpdateAttentionMessage updateAttentionMessage) {
        if (updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid)) {
            final String str = updateAttentionMessage.getData().toUid;
            final boolean z = updateAttentionMessage.getData().isAttention;
            ad.a(new ac<Boolean>() { // from class: com.baidu.tieba.homepage.personalize.e.13
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.baidu.tbadk.util.ac
                public Boolean doInBackground() {
                    int intValue;
                    try {
                        com.baidu.adp.lib.cache.l<byte[]> dF = com.baidu.tbadk.core.c.a.bob().dF("tb.rec_frs_update", TbadkCoreApplication.getCurrentAccount());
                        if (dF == null) {
                            return false;
                        }
                        byte[] bArr = dF.get("0");
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
                        e.this.jEg.dM(builder5.thread_list);
                        dF.setForever("0", builder5.build(true).toByteArray());
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

    public void cKH() {
        this.iHZ = new com.baidu.tieba.tbadkCore.data.f("new_index", null);
        this.iHZ.dJw();
    }

    public void a(int i, List<q> list, int i2) {
        int i3;
        int i4;
        if (this.iHZ != null) {
            if (i == 0) {
                this.iHZ.dJw();
            }
            if (list != null && !list.isEmpty()) {
                int[] iArr = com.baidu.tieba.tbadkCore.data.f.mXk;
                int i5 = 0;
                int i6 = 0;
                int i7 = 0;
                while (i7 < list.size() && i6 < iArr.length && (i3 = iArr[i6]) >= 0) {
                    if (list.get(i7) instanceof com.baidu.tieba.card.data.b) {
                        i4 = i5 + 1;
                        if (i4 == i3 - 1) {
                            if (i2 < i7 + 1) {
                                this.iHZ.dt(i3, i7 + 1);
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

    public void Ch(int i) {
        if ((this.iHZ != null ? this.iHZ.Kc(i) : -1) >= 0 && this.iOd != null && this.iOd.getData() != null && this.iOd.getData().size() > i) {
            this.iHZ.Kd(i);
        }
    }

    public i cyR() {
        return this.irb;
    }

    public void qY(boolean z) {
        this.jBW = z;
    }

    public void Ci(final int i) {
        ad.a(new ac<Object>() { // from class: com.baidu.tieba.homepage.personalize.e.15
            @Override // com.baidu.tbadk.util.ac
            public Object doInBackground() {
                com.baidu.adp.lib.cache.l<String> dG = com.baidu.tbadk.core.c.a.bob().dG(e.this.jED, TbadkCoreApplication.getCurrentAccount());
                if (dG != null) {
                    dG.set(e.this.jED, Integer.toString(i), 43200000L);
                    return null;
                }
                return null;
            }
        }, null);
    }

    public void a(final d dVar) {
        ad.a(new ac<String>() { // from class: com.baidu.tieba.homepage.personalize.e.17
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.ac
            /* renamed from: cKM */
            public String doInBackground() {
                com.baidu.adp.lib.cache.l<String> dG = com.baidu.tbadk.core.c.a.bob().dG(e.this.jED, TbadkCoreApplication.getCurrentAccount());
                if (dG != null) {
                    return dG.get(e.this.jED);
                }
                return null;
            }
        }, new m<String>() { // from class: com.baidu.tieba.homepage.personalize.e.18
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.m
            /* renamed from: Lr */
            public void onReturnDataInUI(String str) {
                if (dVar != null) {
                    dVar.BQ(com.baidu.adp.lib.f.b.toInt(str, 0));
                }
            }
        });
    }

    public void cKu() {
        c.e(this.iOd);
    }

    public void cKI() {
        a(this.jEG);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cKJ() {
        Iterator<q> it = this.mDataList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            } else if (it.next() instanceof com.baidu.tieba.homepage.personalize.data.g) {
                it.remove();
                break;
            }
        }
        if (this.jEi != null) {
            this.jEi.active_center = null;
            crc();
            if (this.iOd != null) {
                List<Integer> f = f(this.iOd);
                int intValue = f.get(0).intValue();
                int intValue2 = f.get(1).intValue();
                if (intValue != -1 && intValue2 != -1) {
                    this.iOd.o(intValue, intValue2);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(CustomResponsedMessage<?> customResponsedMessage) {
        boolean z;
        String str;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.jEi != null && com.baidu.tbadk.core.util.y.getCount(this.jEi.thread_list) != 0 && com.baidu.tbadk.core.util.y.getCount(this.mDataList) != 0) {
            JSONObject jSONObject = (JSONObject) customResponsedMessage.getData();
            String optString = jSONObject.optString("tid");
            if (StringUtils.isNull(optString)) {
                String optString2 = jSONObject.optString(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_ID);
                if (this.iOd != null && !TextUtils.isEmpty(optString2)) {
                    int i = 0;
                    while (true) {
                        if (i >= this.iOd.getCount()) {
                            str = optString;
                            break;
                        }
                        q item = this.iOd.getItem(i);
                        if (item instanceof com.baidu.tieba.card.data.j) {
                            com.baidu.tieba.card.data.j jVar = (com.baidu.tieba.card.data.j) item;
                            if (jVar.bjd() != null && jVar.bjd().blW() != null && optString2.equals(String.valueOf(jVar.bjd().blW().live_id))) {
                                str = jVar.bjd().getTid();
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
                if (next instanceof com.baidu.tieba.card.data.b) {
                    com.baidu.tieba.card.data.b bVar = (com.baidu.tieba.card.data.b) next;
                    if (bVar.bjd() != null && bVar.bjd().getTid() != null) {
                        if (bVar.bjd().getTid().equals(optString)) {
                            it.remove();
                            z = true;
                            z2 = z;
                        } else if (z2) {
                            com.baidu.tieba.homepage.personalize.model.b.dO(this.mDataList);
                            break;
                        }
                    }
                }
                z = z2;
                z2 = z;
            }
            if (this.jEi != null && this.jEi.thread_list != null) {
                long j = com.baidu.adp.lib.f.b.toLong(optString, 0L);
                int i2 = 0;
                while (true) {
                    if (i2 < this.jEi.thread_list.size()) {
                        ThreadInfo threadInfo = this.jEi.thread_list.get(i2);
                        if (threadInfo == null || threadInfo.tid == null || threadInfo.tid.longValue() != j) {
                            i2++;
                        } else {
                            com.baidu.tieba.homepage.personalize.b.d.a(threadInfo.tid.longValue(), i2, this.jEi.thread_list, this.mDataList);
                            this.jEi.thread_list.remove(i2);
                            crc();
                            break;
                        }
                    } else {
                        break;
                    }
                }
                if (this.iOd != null) {
                    List<Integer> b = b(optString, this.iOd);
                    int intValue = b.get(0).intValue();
                    int intValue2 = b.get(1).intValue();
                    if (intValue != -1 && intValue2 != -1) {
                        this.iOd.o(intValue, intValue2);
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
                if (item instanceof com.baidu.tieba.card.data.b) {
                    com.baidu.tieba.card.data.b bVar = (com.baidu.tieba.card.data.b) item;
                    if (bVar.bjd() != null && bVar.bjd().getTid().equals(str)) {
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
                    advertAppInfo = ((com.baidu.tieba.homepage.personalize.data.a) next).coq();
                } else {
                    if (next instanceof al) {
                        al alVar = (al) next;
                        if (alVar.bjT() instanceof AdvertAppInfo.ILegoAdvert) {
                            advertAppInfo = ((AdvertAppInfo.ILegoAdvert) alVar.bjT()).getAdvertAppInfo();
                        }
                    }
                    advertAppInfo = advertAppInfo2;
                }
                if (advertAppInfo != null && str.equals(advertAppInfo.exc)) {
                    it.remove();
                    advertAppInfo = null;
                }
                advertAppInfo2 = advertAppInfo;
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (this.iqX != null) {
            this.iqX.onChangeSkinType(i);
        }
        if (this.jEu != null) {
            this.jEu.onChangeSkinType();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public am cJT() {
        if (this.irb == null || this.irb.dww() == null || !(this.irb.dww().getTag() instanceof am)) {
            return null;
        }
        return (am) this.irb.dww().getTag();
    }
}
