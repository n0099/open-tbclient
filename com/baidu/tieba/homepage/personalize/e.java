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
/* loaded from: classes22.dex */
public class e {
    private View.OnTouchListener eWw;
    private aa fkJ;
    private be hXJ;
    private SmartBubbleAnimatedView hXK;
    private i hXO;
    private com.baidu.tieba.f.a iQC;
    private com.baidu.tieba.tbadkCore.data.f ioS;
    private final BdTypeRecyclerView iuX;
    private boolean jaP;
    private final BigdaySwipeRefreshLayout jdj;
    private ScrollFragmentTabHost jjU;
    private final long jkN;
    private final b jkO;
    private DataRes.Builder jkQ;
    private final com.baidu.tieba.homepage.personalize.model.a jkT;
    private int jkW;
    private h jkY;
    private final af jkg;
    private BdUniqueId jlb;
    private HomePageYoungsterTopView jlc;
    private int jld;
    private Runnable jln;
    private final TbPageContext<?> mPageContext;
    private a jkP = null;
    private final List<q> mDataList = new LinkedList();
    private int mPn = 1;
    private boolean mIsLoading = false;
    private boolean jdu = false;
    private int jkR = 2;
    private int jkS = 0;
    private TextView mTipView = null;
    private int iud = 2000;
    private com.baidu.tbadk.n.c jkU = null;
    private boolean irN = false;
    private int ird = 0;
    private int fSe = 0;
    private boolean mIsBackground = false;
    private boolean jiG = true;
    private boolean jkV = false;
    private boolean jkX = false;
    private boolean jkZ = true;
    private FloatInfo jla = null;
    private BdUniqueId jle = BdUniqueId.gen();
    private a.C0097a ipn = new a.C0097a(2);
    private ThreadInfo jlf = null;
    private RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.e.12
        private int jlu = -1;
        private int jdD = 0;
        private boolean jlv = false;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (e.this.jkU == null) {
                e.this.jkU = new com.baidu.tbadk.n.c();
                e.this.jkU.setSubType(1005);
                e.this.jkU.pageType = 1;
            }
            if (e.this.fkJ != null && !e.this.mIsBackground) {
                e.this.fkJ.m(recyclerView, i);
            }
            if (i == 0) {
                c.d(e.this.iuX);
                e.this.jkU.bxT();
                s.ciJ().lm(true);
                com.baidu.tieba.a.d.bEz().dF("page_recommend", "show_");
                com.baidu.tieba.s.c.dDn().b(e.this.jlb, false);
                this.jlv = false;
                if (e.this.hXO != null && e.this.jiG && !e.this.mIsBackground) {
                    e.this.hXO.a(e.this.ird, e.this.fSe, e.this.irN, 1);
                    return;
                }
                return;
            }
            e.this.jkU.bxS();
            if (i == 1) {
                if (e.this.hXJ != null) {
                    e.this.hXJ.hideTip();
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
            if (this.jdD > i) {
                this.jlv = true;
            }
            if (e.this.fkJ != null && !e.this.mIsBackground) {
                e.this.fkJ.onScroll(this.jdD, i);
            }
            this.jdD = i;
            int i3 = (i + i2) - 1;
            if (!this.jlv && this.jlu != i3) {
                this.jlu = i3;
                e.this.Bd(this.jlu);
            }
            if (this.jlv && this.jlu != i) {
                this.jlu = i;
                e.this.Bd(this.jlu);
            }
            e.this.jlm = i;
            e.this.ird = i;
            e.this.fSe = (i + i2) - 1;
            am cEG = e.this.cEG();
            if (cEG != null && cEG.tW() != null) {
                cEG.tW().b(e.this.ipn);
            }
        }
    };
    private View.OnTouchListener fkK = new View.OnTouchListener() { // from class: com.baidu.tieba.homepage.personalize.e.23
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (e.this.eWw != null) {
                e.this.eWw.onTouch(view, motionEvent);
            }
            if (e.this.iQC != null) {
                e.this.iQC.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private a.InterfaceC0689a hNF = new a.InterfaceC0689a() { // from class: com.baidu.tieba.homepage.personalize.e.30
        @Override // com.baidu.tieba.f.a.InterfaceC0689a
        public void H(int i, int i2) {
            e.this.irN = false;
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0689a
        public void I(int i, int i2) {
            e.this.irN = true;
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0689a
        public void cc(int i, int i2) {
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0689a
        public void J(int i, int i2) {
        }
    };
    private View.OnClickListener jlg = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.e.31
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (e.this.hXJ != null) {
                e.this.hXJ.hideTip();
            }
        }
    };
    private final CustomMessageListener jlh = new CustomMessageListener(CmdConfigCustom.CMD_RELOAD_HP_PERSONALIZED) { // from class: com.baidu.tieba.homepage.personalize.e.32
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (e.this.iuX != null) {
                e.this.hXO.cEF();
                e.this.jiG = false;
                e.this.jdj.setRefreshing(true);
            }
        }
    };
    private final CustomMessageListener jli = new CustomMessageListener(2921461) { // from class: com.baidu.tieba.homepage.personalize.e.33
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (e.this.iuX != null) {
                e.this.cFv();
            }
        }
    };
    private final CustomMessageListener jlj = new CustomMessageListener(2921486) { // from class: com.baidu.tieba.homepage.personalize.e.34
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data = customResponsedMessage.getData();
            switch (data instanceof Integer ? ((Integer) data).intValue() : 0) {
                case 2:
                    new BdTopToast(e.this.mPageContext.getPageActivity(), 2000).xK(true).TD(e.this.mPageContext.getPageActivity().getString(R.string.youngster_open_title)).aH((ViewGroup) e.this.mPageContext.getPageActivity().findViewById(R.id.maintabContainer));
                    e.this.qB(true);
                    return;
                case 3:
                    new BdTopToast(e.this.mPageContext.getPageActivity(), 2000).xK(true).TD(e.this.mPageContext.getPageActivity().getString(R.string.youngster_close_title)).aH((ViewGroup) e.this.mPageContext.getPageActivity().findViewById(R.id.maintabContainer));
                    e.this.qB(false);
                    return;
                case 4:
                default:
                    if (com.baidu.tbadk.youngster.b.c.bDa()) {
                        e.this.qB(true);
                        return;
                    }
                    return;
                case 5:
                    new BdTopToast(e.this.mPageContext.getPageActivity(), 2000).xK(true).TD(e.this.mPageContext.getPageActivity().getString(R.string.youngster_reset_title)).aH((ViewGroup) e.this.mPageContext.getPageActivity().findViewById(R.id.maintabContainer));
                    e.this.qB(true);
                    return;
            }
        }
    };
    private CustomMessageListener iJj = new CustomMessageListener(CmdConfigCustom.PB_ACTION_PRAISE) { // from class: com.baidu.tieba.homepage.personalize.e.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            bw bwVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bw) && e.this.jkQ != null && y.getCount(e.this.jkQ.thread_list) != 0 && (bwVar = (bw) customResponsedMessage.getData()) != null && bwVar.bhS() != null && bwVar.getId() != null && y.getCount(e.this.jkQ.thread_list) != 0) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < e.this.jkQ.thread_list.size()) {
                        ThreadInfo threadInfo = e.this.jkQ.thread_list.get(i2);
                        if (threadInfo == null || threadInfo.id.longValue() != com.baidu.adp.lib.f.b.toLong(bwVar.getId(), -1L)) {
                            i = i2 + 1;
                        } else {
                            ThreadInfo.Builder builder = new ThreadInfo.Builder(threadInfo);
                            Zan.Builder builder2 = new Zan.Builder(builder.zan);
                            builder2.num = Integer.valueOf((int) bwVar.bhS().getNum());
                            builder.zan = builder2.build(true);
                            e.this.jkQ.thread_list.set(i2, builder.build(true));
                            return;
                        }
                    } else {
                        return;
                    }
                }
            }
        }
    };
    private CustomMessageListener jlk = new CustomMessageListener(CmdConfigCustom.CMD_LIVE_VIDEO_CLOSED_QUERY_RESPONSED) { // from class: com.baidu.tieba.homepage.personalize.e.9
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
                        if ((originData.get(i2) instanceof bw) && (bwVar = (bw) originData.get(i2)) != null && bwVar.biB() != null && ids.contains(Long.valueOf(bwVar.biB().live_id))) {
                            e.this.mDataList.remove(bwVar);
                        }
                        i = i2 + 1;
                    }
                    if (e.this.jkg != null) {
                        e.this.jkg.ca(new ArrayList(e.this.mDataList));
                    }
                }
            }
        }
    };
    private CustomMessageListener ezk = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.homepage.personalize.e.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int intValue;
            if ((customResponsedMessage instanceof UpdateAttentionMessage) && e.this.jkQ != null && !y.isEmpty(e.this.jkQ.thread_list)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid)) {
                    int i = 0;
                    while (true) {
                        if (i >= e.this.jkQ.thread_list.size()) {
                            break;
                        }
                        ThreadInfo threadInfo = e.this.jkQ.thread_list.get(i);
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
                            e.this.jkQ.thread_list.set(i, builder.build(true));
                        }
                    }
                    e.this.a(updateAttentionMessage);
                }
            }
        }
    };
    private CustomMessageListener jdz = new CustomMessageListener(0) { // from class: com.baidu.tieba.homepage.personalize.e.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long) && e.this.jkQ != null && e.this.jkQ.hot_recomforum != null && !y.isEmpty(e.this.jkQ.hot_recomforum.tab_list)) {
                long longValue = ((Long) customResponsedMessage.getData()).longValue();
                DiscoverHotForum.Builder builder = new DiscoverHotForum.Builder(e.this.jkQ.hot_recomforum);
                if (com.baidu.tieba.homepage.concern.c.a(builder, longValue, customResponsedMessage.getCmd() == 2001335)) {
                    e.this.jkQ.hot_recomforum = builder.build(true);
                    e.this.c(new DataRes.Builder(e.this.jkQ.build(true)));
                }
            }
        }
    };
    private String jll = "lastReadReadPositionKey";
    private int jlm = 0;
    private d jlo = new d() { // from class: com.baidu.tieba.homepage.personalize.e.16
        @Override // com.baidu.tieba.homepage.personalize.d
        public void AM(final int i) {
            if (e.this.jln == null) {
                e.this.jln = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.e.16.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (e.this.iuX.getHandler() != null) {
                            e.this.iuX.requestFocusFromTouch();
                            if (i <= e.this.iuX.getCount() - 1) {
                                e.this.iuX.setSelection(i);
                            }
                        }
                    }
                };
            }
            e.this.iuX.removeCallbacks(e.this.jln);
            e.this.iuX.post(e.this.jln);
        }
    };
    private CustomMessageListener jlp = new CustomMessageListener(2016569) { // from class: com.baidu.tieba.homepage.personalize.e.19
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && e.this.jkY != null) {
                e.this.mDataList.remove(e.this.jkY);
                e.this.jkg.ca(new ArrayList(e.this.mDataList));
                com.baidu.tbadk.core.sharedPref.b.blO().putLong("key_maintab_banner_close_time", System.currentTimeMillis());
            }
        }
    };
    private CustomMessageListener hXD = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.homepage.personalize.e.20
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.g(customResponsedMessage);
            if (e.this.hXO != null && e.this.jiG) {
                e.this.hXO.a(e.this.ird, e.this.fSe, e.this.irN, true);
            }
        }
    };
    private CustomMessageListener hXE = new CustomMessageListener(CmdConfigCustom.CMD_THREAD_NOT_EXIST_WHEN_ENTER_PB) { // from class: com.baidu.tieba.homepage.personalize.e.21
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.g(customResponsedMessage);
        }
    };
    private CustomMessageListener iJx = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.homepage.personalize.e.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && e.this.jkQ != null && y.getCount(e.this.jkQ.thread_list) != 0) {
                String str = (String) customResponsedMessage.getData();
                e.this.h(str, e.this.mDataList);
                e.this.La(str);
                if (e.this.jkg != null) {
                    e.this.jkg.ca(new ArrayList(e.this.mDataList));
                }
                if (e.this.hXO != null && e.this.jiG) {
                    e.this.hXO.a(e.this.ird, e.this.fSe, e.this.irN, true);
                }
            }
        }
    };
    private CustomMessageListener iqK = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.homepage.personalize.e.24
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            am cEG;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent)) {
                KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24 && (cEG = e.this.cEG()) != null && cEG.tW() != null) {
                    cEG.tW().b(new a.C0097a(3));
                }
            }
        }
    };
    private com.baidu.adp.framework.listener.a jlq = new com.baidu.adp.framework.listener.a(1003065, CmdConfigSocket.CMD_TOPIC_BLESS) { // from class: com.baidu.tieba.homepage.personalize.e.25
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
                        if ((qVar instanceof com.baidu.tieba.homepage.topic.topictab.b.a) && (bVar = ((com.baidu.tieba.homepage.topic.topictab.b.a) qVar).jsq) != null && longValue == bVar.pkId) {
                            bVar.userPkId = j2;
                            return;
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener iqL = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.homepage.personalize.e.26
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            List<q> dataList = e.this.jkg.getDataList();
            if (!y.isEmpty(dataList)) {
                for (q qVar : dataList) {
                    if (qVar instanceof l) {
                        l lVar = (l) qVar;
                        if (lVar.epi != 0 && lVar.eji != null) {
                            int[] imageWidthAndHeight = lVar.eji.getImageWidthAndHeight();
                            lVar.epi = imageWidthAndHeight[0];
                            lVar.epj = imageWidthAndHeight[1];
                        }
                    }
                }
            }
            com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.personalize.e.26.1
                @Override // java.lang.Runnable
                public void run() {
                    e.this.jkg.notifyDataSetChanged();
                    if (!e.this.mIsBackground && e.this.jiG) {
                        e.this.hXO.a(e.this.ird, e.this.fSe, e.this.irN, true);
                    }
                }
            }, 500L);
        }
    };
    private CustomMessageListener hXF = new CustomMessageListener(2921453) { // from class: com.baidu.tieba.homepage.personalize.e.27
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.data.be)) {
                com.baidu.tbadk.core.data.be beVar = (com.baidu.tbadk.core.data.be) customResponsedMessage.getData();
                if (beVar.eoh == 1) {
                    int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
                    int equipmentHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst());
                    float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
                    int i = au.bmV().bmW() ? 2 : 1;
                    RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
                    requestGetMyPostNetMessage.setTag(e.this.jle);
                    requestGetMyPostNetMessage.setParams(com.baidu.adp.lib.f.b.toLong(beVar.tid, 0L), 0L, 0L, equipmentWidth, equipmentHeight, f, i);
                    requestGetMyPostNetMessage.setBFrom("push");
                    MessageManager.getInstance().sendMessage(requestGetMyPostNetMessage);
                }
            }
        }
    };
    private final com.baidu.adp.framework.listener.a hXG = new com.baidu.adp.framework.listener.a(1003010, CmdConfigSocket.CMD_GET_MY_POST) { // from class: com.baidu.tieba.homepage.personalize.e.28
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            GetMyPostResIdl getMyPostResIdl = null;
            if (responsedMessage instanceof GetMyPostHttpResponseMessage) {
                getMyPostResIdl = ((GetMyPostHttpResponseMessage) responsedMessage).getResponseData();
            } else if (responsedMessage instanceof GetMyPostSocketResponseMessage) {
                getMyPostResIdl = ((GetMyPostSocketResponseMessage) responsedMessage).getResponseData();
            }
            if (getMyPostResIdl != null && getMyPostResIdl.data != null && getMyPostResIdl.data.thread_info != null) {
                e.this.jlf = getMyPostResIdl.data.thread_info;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921455));
            }
        }
    };
    private CustomMessageListener jlr = new CustomMessageListener(2921482) { // from class: com.baidu.tieba.homepage.personalize.e.29
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
        void B(int i, int i2, int i3, int i4);

        void Q(int i, int i2, int i3);

        void cFi();

        void onError(int i, String str);

        void onSuccess();
    }

    public void qy(boolean z) {
        this.jkZ = z;
        if (this.hXJ != null && !z) {
            this.hXJ.hideTip();
        }
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.jjU = scrollFragmentTabHost;
        if (this.jjU != null) {
            this.jjU.setOnTabSelectedListener(new ScrollFragmentTabHost.b() { // from class: com.baidu.tieba.homepage.personalize.e.1
                @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.b
                public void AW(int i) {
                    if (e.this.jjU.AV(i) != 1 && e.this.hXJ != null) {
                        e.this.hXJ.hideTip();
                    }
                }
            });
        }
    }

    public void setTabInForeBackgroundState(boolean z) {
        this.mIsBackground = z;
    }

    public void pe(boolean z) {
        boolean z2 = false;
        this.mIsBackground = z;
        if (this.jjU != null) {
            this.jjU.pe(z);
        }
        if (this.hXO != null) {
            this.hXO.sw(!z);
            am cEG = cEG();
            if (cEG != null && cEG.tW() != null) {
                z2 = cEG.tW().b(new a.C0097a(8, Boolean.valueOf(z)));
            }
            if (!z2) {
                if (z) {
                    this.hXO.cEF();
                } else if (this.jiG) {
                    this.hXO.a(this.ird, this.fSe, this.irN, true);
                }
            }
        }
    }

    public e(TbPageContext<?> tbPageContext, BdTypeRecyclerView bdTypeRecyclerView, af afVar, BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout) {
        this.jld = 0;
        this.mPageContext = tbPageContext;
        this.jld = com.baidu.tbadk.core.sharedPref.b.blO().getInt("key_personalized_refresh_type", 0);
        this.jdj = bigdaySwipeRefreshLayout;
        this.iuX = bdTypeRecyclerView;
        this.iuX.setOnTouchListener(this.fkK);
        if (com.baidu.tbadk.youngster.b.c.bDa()) {
            qB(true);
        }
        this.iQC = new com.baidu.tieba.f.a();
        this.iQC.a(this.hNF);
        this.jkg = afVar;
        this.jkT = new com.baidu.tieba.homepage.personalize.model.a();
        this.jkN = com.baidu.tbadk.core.sharedPref.b.blO().getLong("recommend_frs_cache_time", 1800L) * 1000;
        bdTypeRecyclerView.setOnScrollListener(this.mOnScrollListener);
        this.hXJ = new be();
        cFt();
        this.hXO = new i(this.mPageContext, this.iuX);
        this.hXO.GO(1);
        this.hXO.GN(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.jkO = new b(this.mDataList, this.jkg);
        this.hXK = new SmartBubbleAnimatedView(tbPageContext.getContext());
        this.hXK.setLayoutParams(new FrameLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(tbPageContext.getContext(), R.dimen.tbds83)));
        cFj();
        this.iqL.setTag(this.mPageContext.getUniqueId());
        MessageManager.getInstance().registerListener(this.iqL);
        if (MessageManager.getInstance().findTask(1003010) == null) {
            HomePageStatic.cCP();
        }
        this.hXG.setTag(this.jle);
        if (this.hXG.getHttpMessageListener() != null) {
            this.hXG.getHttpMessageListener().setSelfListener(true);
        }
        if (this.hXG.getSocketMessageListener() != null) {
            this.hXG.getSocketMessageListener().setSelfListener(true);
        }
        MessageManager.getInstance().registerListener(this.hXG);
        MessageManager.getInstance().registerListener(this.hXF);
        MessageManager.getInstance().registerListener(this.jlr);
    }

    private void cFj() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2016323, new CustomMessageTask.CustomRunnable<Boolean>() { // from class: com.baidu.tieba.homepage.personalize.e.35
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Boolean> customMessage) {
                am cEG = e.this.cEG();
                return (cEG == null || cEG.tW() == null) ? new CustomResponsedMessage<>(2016323, false) : new CustomResponsedMessage<>(2016323, Boolean.valueOf(cEG.tW().b(new a.C0097a(6))));
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private boolean cFk() {
        return com.baidu.tbadk.core.sharedPref.b.blO().getBoolean(cFm(), true);
    }

    private void cFl() {
        com.baidu.tbadk.core.sharedPref.b.blO().putBoolean(cFm(), false);
    }

    private String cFm() {
        return "key_rec_pfirst_load_" + TbadkCoreApplication.getCurrentAccount() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + TbConfig.getVersion();
    }

    public void setRecommendFrsNavigationAnimDispatcher(ab abVar) {
        if (abVar != null) {
            this.fkJ = abVar.bzA();
            this.eWw = abVar.bzB();
        }
    }

    public void showFloatingView() {
        if (this.fkJ != null) {
            this.fkJ.showFloatingView(true);
        }
    }

    public void update() {
        com.baidu.tieba.homepage.framework.a.cDz().y(System.currentTimeMillis(), 1);
        this.mPn = 1;
        this.jkX = true;
        if (this.mDataList.size() == 0 && !cFk()) {
            if (!this.jdu) {
                bfy();
                return;
            }
            return;
        }
        bfx();
    }

    public void cA(int i, int i2) {
        bw bwVar;
        if (!y.isEmpty(this.mDataList) && this.mDataList.size() > i) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            while (i < this.mDataList.size() && i <= i2) {
                if (this.mDataList.get(i).getType().getId() == bw.epI.getId() && (bwVar = (bw) this.mDataList.get(i)) != null && bwVar.biB() != null) {
                    arrayList.add(Long.valueOf(bwVar.biB().live_id));
                    arrayList2.add(bwVar);
                }
                i++;
            }
            if (!y.isEmpty(arrayList)) {
                MessageManager.getInstance().sendMessage(new LiveRoomClosedQueryMessage(arrayList, arrayList2));
            }
        }
    }

    public void cFn() {
        if (this.hXO != null && !this.mIsBackground && this.jiG) {
            this.hXO.a(this.ird, this.fSe, this.irN, true);
        }
        if (this.jkV) {
            if (this.jdj != null && !this.jdj.bop()) {
                if (this.jaP) {
                    com.baidu.tieba.s.c.dDn().b(this.jlb, false);
                    if (qA(false)) {
                        cB(3, this.jkS);
                    } else if (this.jkW > 0) {
                        cB(2, this.jkS);
                    }
                } else if (!this.jaP && this.jkS == 0) {
                    cB(2, 0);
                }
            }
            this.jkV = false;
            this.jaP = false;
            this.jkW = 0;
            if (this.jkX) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
            }
            this.jkX = false;
        }
    }

    public void bJG() {
        if (isLoading()) {
            com.baidu.tieba.homepage.framework.a.cDz().y(0L, 1);
        } else if (this.jkP != null) {
            cFp();
            this.mPn++;
            setIsLoading(true);
            this.jkP.B(this.mPn, (this.jkQ == null || this.jkQ.thread_list == null) ? 0 : this.jkQ.thread_list.size(), qz(false), 0);
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
            g.cFA();
        }
        if (this.jkT != null && this.jkT.cFU() && !z && (dataRes == null || y.isEmpty(dataRes.thread_list))) {
            if (dataRes == null) {
                DataRes.Builder builder = new DataRes.Builder();
                builder.thread_list = new ArrayList();
                dataRes = builder.build(false);
            }
            if (dataRes.thread_list != null) {
                List<ThreadInfo> cFV = this.jkT.cFV();
                dataRes.thread_list.addAll(cFV);
                if (cFV != null) {
                    cFV.clear();
                }
                z3 = true;
                size = (this.jkQ != null || this.jkQ.thread_list == null) ? 0 : this.jkQ.thread_list.size();
                if (z && i == 0 && dataRes != null && y.isEmpty(dataRes.thread_list)) {
                    if (this.jkP != null) {
                        this.jkP.cFi();
                    }
                    setIsLoading(false);
                    if (this.jdj != null) {
                        this.jdj.setRefreshing(false);
                        return;
                    }
                    return;
                }
                if (this.jlf != null) {
                    DataRes.Builder builder2 = new DataRes.Builder(dataRes);
                    builder2.thread_list.add(0, this.jlf);
                    dataRes = builder2.build(false);
                    if (this.jkQ != null && !y.isEmpty(this.jkQ.thread_list)) {
                        Iterator<ThreadInfo> it = this.jkQ.thread_list.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            ThreadInfo next = it.next();
                            if (next != null && next.tid != null && this.jlf.tid != null && next.tid.longValue() == this.jlf.tid.longValue()) {
                                this.jkQ.thread_list.remove(next);
                                break;
                            }
                        }
                    }
                    this.jlf = null;
                }
                if ((z3 && i != 0) || dataRes == null || !a(true, z, z2, dataRes)) {
                    this.jkV = false;
                    if (this.mDataList.size() > 0) {
                        if (this.jkP != null) {
                            this.jkP.onError(1, str);
                        }
                    } else if (this.jkP != null) {
                        this.jkP.onError(2, str);
                    }
                } else {
                    cFl();
                    if (this.jkP != null) {
                        com.baidu.tbadk.core.sharedPref.b.blO().putLong(SharedPrefConfig.RECOMMEND_FRS_REFRESH_TIME + TbadkCoreApplication.getCurrentAccount(), System.currentTimeMillis());
                        this.jkP.onSuccess();
                    }
                    this.jkV = true;
                    this.jaP = z;
                    this.jkW = size;
                    clR();
                }
                setIsLoading(false);
                if (this.jdj == null) {
                    f.e cFo = cFo();
                    if (this.jdj.bop() && cFo != null) {
                        this.jdj.c(cFo);
                        return;
                    } else {
                        this.jdj.setRefreshing(false);
                        return;
                    }
                }
                return;
            }
        }
        z3 = false;
        if (this.jkQ != null) {
        }
        if (z) {
        }
        if (this.jlf != null) {
        }
        if (z3) {
        }
        cFl();
        if (this.jkP != null) {
        }
        this.jkV = true;
        this.jaP = z;
        this.jkW = size;
        clR();
        setIsLoading(false);
        if (this.jdj == null) {
        }
    }

    private f.e cFo() {
        int i;
        String feedText;
        if (!this.jkV || this.jdj == null || !this.jdj.bop() || cFs()) {
            return null;
        }
        int i2 = this.jkS;
        if (this.jaP) {
            com.baidu.tieba.s.c.dDn().b(this.jlb, false);
            if (qA(false)) {
                i = 3;
            } else {
                i = this.jkW > 0 ? 2 : 0;
            }
        } else if (this.jaP || this.jkS != 0) {
            return null;
        } else {
            i2 = 0;
            i = 2;
        }
        if (this.jjU != null) {
            this.hXJ.cuY();
        }
        if (this.jjU != null && this.jjU.getCurrentTabType() != 1) {
            this.hXJ.hideTip();
            return null;
        } else if (!this.jkZ) {
            this.hXJ.hideTip();
            return null;
        } else {
            this.jkR = i;
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
                this.iud = 1000;
            } else {
                this.iud = 0;
            }
            return new f.e(feedText, this.iud);
        }
    }

    public void ql(boolean z) {
        if (z) {
            this.jkg.notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        if (this.hXO != null) {
            this.hXO.destroy();
        }
        if (this.hXJ != null) {
            this.hXJ.onDestroy();
        }
        if (this.jkO != null) {
            this.jkO.onDestroy();
        }
        if (this.iuX != null) {
            this.iuX.removeCallbacks(this.jln);
        }
        MessageManager.getInstance().unRegisterTask(2016323);
        MessageManager.getInstance().unRegisterListener(this.iqL);
        MessageManager.getInstance().unRegisterListener(this.hXF);
        MessageManager.getInstance().unRegisterListener(this.hXG);
        MessageManager.getInstance().unRegisterListener(this.jlr);
    }

    public void onPause() {
        c.d(this.iuX);
        Be(this.jlm);
        if (this.jkU != null) {
            this.jkU.bxU();
        }
    }

    private void bfx() {
        if (this.jkP != null) {
            this.jkP.Q((this.jkQ == null || this.jkQ.thread_list == null || cFr()) ? 0 : this.jkQ.thread_list.size(), qz(true), 0);
        }
    }

    public int qz(boolean z) {
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
                if (!(qVar instanceof com.baidu.tieba.homepage.personalize.data.a) || qVar.getType() == AdvertAppInfo.ekk) {
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
                if ((qVar2 instanceof com.baidu.tieba.homepage.personalize.data.a) && qVar2.getType() != AdvertAppInfo.ekk) {
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
        this.jdu = true;
        if (dataRes != null) {
            if (a(false, true, true, dataRes) && !cFr()) {
                if (this.jkP != null) {
                    this.jkP.onSuccess();
                    Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler() { // from class: com.baidu.tieba.homepage.personalize.e.2
                        @Override // android.os.MessageQueue.IdleHandler
                        public boolean queueIdle() {
                            e.this.bxZ();
                            return false;
                        }
                    });
                }
                if (TbSingleton.getInstance().getForceRefreshHomeRecommend()) {
                    bfx();
                    TbSingleton.getInstance().setForceRefreshHomeRecommend(false);
                    return;
                }
                return;
            }
            bfx();
            return;
        }
        bfx();
    }

    public void bxZ() {
        long AK = com.baidu.tieba.homepage.framework.a.cDz().AK(1) + com.baidu.tieba.homepage.framework.a.cDz().getCreateTime();
        long AI = com.baidu.tieba.homepage.framework.a.cDz().AI(1);
        if (AI > 0) {
            AK = System.currentTimeMillis() - AI;
        }
        n.byh().dI(AK);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.util.Set] */
    private void i(List<q> list, int i) {
        AdvertAppInfo cjd;
        AdvertAppInfo cjd2;
        if (!y.isEmpty(list)) {
            Set<q> QP = com.baidu.tieba.recapp.report.a.QP("NEWINDEX");
            HashSet hashSet = QP == null ? new HashSet() : QP;
            HashSet hashSet2 = new HashSet();
            for (q qVar : list) {
                if (qVar != null) {
                    for (q qVar2 : hashSet) {
                        if ((qVar instanceof com.baidu.tieba.card.data.e) && (cjd2 = ((com.baidu.tieba.card.data.e) qVar).cjd()) != null && qVar2 != null && (qVar2 instanceof AdvertAppInfo) && qVar2.hashCode() == cjd2.hashCode()) {
                            cjd2.advertAppContext = ((AdvertAppInfo) qVar2).advertAppContext;
                        }
                    }
                    if (qVar != null && (qVar instanceof com.baidu.tieba.card.data.e) && (cjd = ((com.baidu.tieba.card.data.e) qVar).cjd()) != null && cjd.advertAppContext == null) {
                        cjd.advertAppContext = new com.baidu.tbadk.core.data.b();
                        cjd.advertAppContext.page = "NEWINDEX";
                        cjd.advertAppContext.pn = this.mPn;
                        cjd.advertAppContext.extensionInfo = cjd.extensionInfo;
                        cjd.advertAppContext.YM = false;
                        hashSet2.add(cjd);
                    }
                }
            }
            hashSet.addAll(hashSet2);
            com.baidu.tieba.recapp.report.a.b("NEWINDEX", hashSet);
            if (hashSet2.size() > 0) {
                com.baidu.tieba.s.c.dDn().b(this.jlb, com.baidu.tieba.s.a.b(PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE, "common_fill", true, hashSet2.size()));
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
        if (this.jld == 1) {
            if (z2 && (dataRes.thread_list.size() >= 6 || cFr())) {
                cFq();
                this.jkQ = null;
            }
        } else if (z2 && cFr()) {
            this.jkQ = null;
        }
        int size = z2 ? 0 : this.mDataList.size();
        DataRes.Builder builder = new DataRes.Builder(dataRes);
        this.mDataList.clear();
        com.baidu.tieba.homepage.personalize.model.c a2 = this.jkT.a(z, this.jkQ, builder, z2 ? 0 : 1);
        if (a2 == null) {
            list = null;
            i = 0;
        } else {
            List<q> list2 = a2.fzF;
            this.jkS = a2.jnU;
            int i2 = a2.jnV;
            a2.jnV = 0;
            list = list2;
            i = i2;
        }
        if (list != null) {
            this.mDataList.addAll(list);
            i(list, size);
            a(z2 ? 0 : 1, list, size);
            if (this.jkX) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
            }
        }
        if (this.jkQ == null) {
            this.jkQ = builder;
            this.jkO.du(this.jkQ.thread_list);
        }
        if (this.mDataList.size() == 0) {
            z4 = false;
        } else {
            if (z2) {
                if (dataRes.live_answer != null) {
                    this.jkY = new h();
                    this.jkY.a(dataRes.live_answer);
                    this.jkQ.live_answer = dataRes.live_answer;
                } else if (z) {
                    this.jkY = null;
                    this.jkQ.live_answer = null;
                }
                this.jla = dataRes.float_info;
                this.jkQ.float_info = dataRes.float_info;
            }
            long j = com.baidu.tbadk.core.sharedPref.b.blO().getLong("key_maintab_banner_close_time", 0L);
            if (this.jkY != null && !at.isTaday(j)) {
                this.mDataList.add(0, this.jkY);
            }
            LinkedList linkedList = new LinkedList(this.mDataList);
            this.jkg.setFromCDN(dataRes.is_new_url != null && dataRes.is_new_url.intValue() == 1);
            this.jkg.j(linkedList, i);
            z4 = true;
            if (this.hXO != null && this.jiG) {
                this.hXO.a(this.ird, this.fSe, this.irN, true);
            }
        }
        com.baidu.tieba.homepage.framework.a.cDz().w(System.currentTimeMillis() - currentTimeMillis, 1);
        long AL = com.baidu.tieba.homepage.framework.a.cDz().AL(1);
        if (AL > 0) {
            com.baidu.tieba.homepage.framework.a.cDz().x(System.currentTimeMillis() - AL, 1);
            com.baidu.tieba.homepage.framework.a.cDz().y(0L, 1);
        }
        if (dataRes.anti != null && dataRes.anti.block_pop_info != null) {
            com.baidu.tieba.ueg.d.d(dataRes.anti.block_pop_info);
        }
        bg bgVar = new bg();
        bgVar.a(dataRes.recom_post_topic);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_REFRESH_TOPIC_TIP, bgVar));
        return z4;
    }

    private void cFp() {
        List<q> list;
        int i;
        if (y.getCount(this.mDataList) >= this.jkT.cFQ() - 40) {
            com.baidu.tieba.homepage.personalize.model.c a2 = this.jkT.a(true, this.jkQ, null, 1);
            if (a2 != null) {
                List<q> list2 = a2.fzF;
                i = a2.jnV;
                a2.jnV = 0;
                list = list2;
            } else {
                list = null;
                i = 0;
            }
            if (list != null) {
                this.mDataList.clear();
                this.mDataList.addAll(list);
                this.jkg.j(new LinkedList(this.mDataList), i);
            }
        }
    }

    private void bfy() {
        this.jdu = true;
        ae.a(new ad<DataRes>() { // from class: com.baidu.tieba.homepage.personalize.e.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.ad
            /* renamed from: cFw */
            public DataRes doInBackground() {
                com.baidu.adp.lib.cache.l<byte[]> dA = com.baidu.tbadk.core.c.a.bkE().dA("tb.rec_frs_update", TbadkCoreApplication.getCurrentAccount());
                if (dA == null) {
                    return null;
                }
                byte[] bArr = dA.get("0");
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

    private void clR() {
        if (this.jkQ != null) {
            DataRes.Builder builder = new DataRes.Builder(this.jkQ.build(true));
            if (builder.thread_list != null && builder.thread_list.size() > 30) {
                builder.thread_list = builder.thread_list.subList(0, 30);
            }
            a(builder, builder.thread_list != null ? builder.thread_list.size() : 0);
            a(builder);
            b(builder);
            c(builder);
        }
    }

    private void cFq() {
        if (this.jkQ != null) {
            final DataRes.Builder builder = new DataRes.Builder(this.jkQ.build(true));
            if (builder.thread_list != null && builder.thread_list.size() > 50) {
                builder.thread_list = builder.thread_list.subList(0, 50);
            }
            a(builder, builder.thread_list != null ? builder.thread_list.size() : 0);
            ae.a(new ad<Object>() { // from class: com.baidu.tieba.homepage.personalize.e.5
                @Override // com.baidu.tbadk.util.ad
                public Object doInBackground() {
                    DataRes.Builder builder2 = new DataRes.Builder(builder.build(true));
                    e.this.jkO.dv(builder2.thread_list);
                    try {
                        com.baidu.tbadk.core.c.a.bkE().dA("tb.rec_old_data", TbadkCoreApplication.getCurrentAccount()).setForever("0", builder2.build(true).toByteArray());
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
    public void La(String str) {
        if (!TextUtils.isEmpty(str) && this.jkQ != null && this.jkQ.banner_list != null && this.jkQ.banner_list.app != null && this.jkQ.banner_list.app.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (App app : this.jkQ.banner_list.app) {
                if (app != null && str.equals(app.id)) {
                    arrayList.add(app);
                }
            }
            BannerList.Builder builder = new BannerList.Builder(this.jkQ.banner_list);
            if (builder.app != null) {
                builder.app.removeAll(arrayList);
            }
            this.jkQ.banner_list = builder.build(false);
            DataRes.Builder builder2 = new DataRes.Builder(this.jkQ.build(true));
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
                e.this.jkO.dv(builder2.thread_list);
                try {
                    com.baidu.tbadk.core.c.a.bkE().dA("tb.rec_frs_update", TbadkCoreApplication.getCurrentAccount()).setForever("0", builder2.build(true).toByteArray());
                    return null;
                } catch (Exception e) {
                    BdLog.e(e);
                    return null;
                }
            }
        }, null);
    }

    private boolean cFr() {
        return qA(true);
    }

    private boolean qA(boolean z) {
        long j = com.baidu.tbadk.core.sharedPref.b.blO().getLong(SharedPrefConfig.RECOMMEND_FRS_REFRESH_TIME + TbadkCoreApplication.getCurrentAccount(), 0L);
        return j == 0 ? z : Math.abs(System.currentTimeMillis() - j) > this.jkN;
    }

    public void a(a aVar) {
        this.jkP = aVar;
    }

    private boolean isLoading() {
        return this.mIsLoading;
    }

    private void setIsLoading(boolean z) {
        this.mIsLoading = z;
    }

    public void cFe() {
        boolean z = true;
        com.baidu.tbadk.coreExtra.data.b activityPrizeData = TbadkCoreApplication.getInst().getActivityPrizeData();
        if (activityPrizeData.isSwitchTurn() && !StringUtils.isNull(activityPrizeData.getFeedText())) {
            String currentDay = UtilHelper.getCurrentDay();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            String str = "";
            if (!StringUtils.isNull(currentAccount)) {
                String string = com.baidu.tbadk.core.sharedPref.b.blO().getString(SharedPrefConfig.ACTIVITY_PRIZE_FEED_TEXT_TIME, "");
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
                    com.baidu.tbadk.core.sharedPref.b.blO().putString(SharedPrefConfig.ACTIVITY_PRIZE_FEED_TEXT_TIME, str);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qB(boolean z) {
        boolean z2 = com.baidu.tbadk.core.sharedPref.b.blO().getBoolean("key_youngster_homgpage_top_view_closed", false);
        if (this.iuX != null && !z2) {
            if (z) {
                if (this.jlc == null) {
                    this.jlc = new HomePageYoungsterTopView(this.mPageContext);
                    this.jlc.setOnDeleteClick(new HomePageYoungsterTopView.a() { // from class: com.baidu.tieba.homepage.personalize.e.7
                        @Override // com.baidu.tieba.homepage.personalize.view.HomePageYoungsterTopView.a
                        public void cFx() {
                            new BdTopToast(e.this.mPageContext.getPageActivity(), 2000).xK(true).TD(e.this.mPageContext.getPageActivity().getString(R.string.youngster_frs_top_toast)).aH((ViewGroup) e.this.mPageContext.getPageActivity().findViewById(R.id.maintabContainer));
                            e.this.qB(false);
                            com.baidu.tbadk.core.sharedPref.b.blO().putBoolean("key_youngster_homgpage_top_view_closed", true);
                        }
                    });
                }
                this.iuX.setHeaderView(this.jlc);
                this.jlc.setVisibility(0);
                this.iuX.scrollToPosition(0);
            } else if (this.jlc != null) {
                this.jlc.setVisibility(8);
                this.iuX.removeHeaderView(this.jlc);
            }
        }
    }

    private boolean cFs() {
        return this.jlc != null && this.jlc.getVisibility() == 0;
    }

    private void cB(int i, int i2) {
        if (!cFs()) {
            if (this.jjU != null) {
                this.hXJ.cuY();
            }
            if (this.jjU != null && this.jjU.getCurrentTabType() != 1) {
                this.hXJ.hideTip();
            } else if (!this.jkZ) {
                this.hXJ.hideTip();
            } else {
                this.jkR = i;
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
                        this.iud = 3000;
                    } else {
                        this.iud = 2000;
                    }
                    this.hXK.eHE = str;
                    this.hXK.itW = this.iud;
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 49;
                    if (this.jjU != null) {
                        FrameLayout frameLayout = this.jjU.getFrameLayout();
                        frameLayout.removeView(this.hXK);
                        frameLayout.addView(this.hXK, layoutParams);
                        this.hXK.cuW();
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(Long l) {
        if (this.jkQ != null && this.jkQ.thread_list != null) {
            List<ThreadInfo> list = this.jkQ.thread_list;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                ThreadInfo threadInfo = list.get(i);
                if (threadInfo.tid.equals(l) && threadInfo.top_agree_post != null) {
                    ThreadInfo.Builder builder = new ThreadInfo.Builder(threadInfo);
                    builder.top_agree_post = null;
                    list.set(i, builder.build(true));
                    clR();
                    a(false, true, false, this.jkQ.build(true));
                    return;
                }
            }
        }
    }

    public void o(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.jlb = bdUniqueId;
            if (this.iJj != null) {
                this.iJj.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.iJj);
            }
            if (this.jlh != null) {
                this.jlh.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.jlh);
            }
            this.jli.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.jli);
            this.ezk.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.ezk);
            this.jdz.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_LIKE_FORUM, this.jdz);
            MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_UNLIKE_FORUM, this.jdz);
            this.jlk.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.jlk);
            this.hXD.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.hXD);
            this.hXE.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.hXE);
            this.iJx.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.iJx);
            if (this.hXO != null) {
                this.hXO.setUniqueId(bdUniqueId);
            }
            this.jkO.l(bdUniqueId);
            this.jlp.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.jlp);
            this.iqK.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.iqK);
            this.jlq.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.jlq);
            this.jlj.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.jlj);
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
                        com.baidu.adp.lib.cache.l<byte[]> dA = com.baidu.tbadk.core.c.a.bkE().dA("tb.rec_frs_update", TbadkCoreApplication.getCurrentAccount());
                        if (dA == null) {
                            return false;
                        }
                        byte[] bArr = dA.get("0");
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
                        e.this.jkO.dv(builder5.thread_list);
                        dA.setForever("0", builder5.build(true).toByteArray());
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

    public void cFt() {
        this.ioS = new com.baidu.tieba.tbadkCore.data.f("new_index", null);
        this.ioS.dDV();
    }

    public void a(int i, List<q> list, int i2) {
        int i3;
        int i4;
        if (this.ioS != null) {
            if (i == 0) {
                this.ioS.dDV();
            }
            if (list != null && !list.isEmpty()) {
                int[] iArr = com.baidu.tieba.tbadkCore.data.f.mDI;
                int i5 = 0;
                int i6 = 0;
                int i7 = 0;
                while (i7 < list.size() && i6 < iArr.length && (i3 = iArr[i6]) >= 0) {
                    if (list.get(i7) instanceof com.baidu.tieba.card.data.c) {
                        i4 = i5 + 1;
                        if (i4 == i3 - 1) {
                            if (i2 < i7 + 1) {
                                this.ioS.m42do(i3, i7 + 1);
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

    public void Bd(int i) {
        if ((this.ioS != null ? this.ioS.IV(i) : -1) >= 0 && this.iuX != null && this.iuX.getData() != null && this.iuX.getData().size() > i) {
            this.ioS.IW(i);
        }
    }

    public i ctG() {
        return this.hXO;
    }

    public void qu(boolean z) {
        this.jiG = z;
    }

    public void Be(final int i) {
        ae.a(new ad<Object>() { // from class: com.baidu.tieba.homepage.personalize.e.15
            @Override // com.baidu.tbadk.util.ad
            public Object doInBackground() {
                com.baidu.adp.lib.cache.l<String> dB = com.baidu.tbadk.core.c.a.bkE().dB(e.this.jll, TbadkCoreApplication.getCurrentAccount());
                if (dB != null) {
                    dB.set(e.this.jll, Integer.toString(i), 43200000L);
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
            /* renamed from: cFy */
            public String doInBackground() {
                com.baidu.adp.lib.cache.l<String> dB = com.baidu.tbadk.core.c.a.bkE().dB(e.this.jll, TbadkCoreApplication.getCurrentAccount());
                if (dB != null) {
                    return dB.get(e.this.jll);
                }
                return null;
            }
        }, new m<String>() { // from class: com.baidu.tieba.homepage.personalize.e.18
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.m
            /* renamed from: Lb */
            public void onReturnDataInUI(String str) {
                if (dVar != null) {
                    dVar.AM(com.baidu.adp.lib.f.b.toInt(str, 0));
                }
            }
        });
    }

    public void cFg() {
        c.e(this.iuX);
    }

    public void cFu() {
        a(this.jlo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cFv() {
        Iterator<q> it = this.mDataList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            } else if (it.next() instanceof com.baidu.tieba.homepage.personalize.data.g) {
                it.remove();
                break;
            }
        }
        if (this.jkQ != null) {
            this.jkQ.active_center = null;
            clR();
            if (this.iuX != null) {
                List<Integer> f = f(this.iuX);
                int intValue = f.get(0).intValue();
                int intValue2 = f.get(1).intValue();
                if (intValue != -1 && intValue2 != -1) {
                    this.iuX.o(intValue, intValue2);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(CustomResponsedMessage<?> customResponsedMessage) {
        boolean z;
        String str;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.jkQ != null && y.getCount(this.jkQ.thread_list) != 0 && y.getCount(this.mDataList) != 0) {
            JSONObject jSONObject = (JSONObject) customResponsedMessage.getData();
            String optString = jSONObject.optString("tid");
            if (StringUtils.isNull(optString)) {
                String optString2 = jSONObject.optString(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_ID);
                if (this.iuX != null && !TextUtils.isEmpty(optString2)) {
                    int i = 0;
                    while (true) {
                        if (i >= this.iuX.getCount()) {
                            str = optString;
                            break;
                        }
                        q item = this.iuX.getItem(i);
                        if (item instanceof k) {
                            k kVar = (k) item;
                            if (kVar.bfG() != null && kVar.bfG().biB() != null && optString2.equals(String.valueOf(kVar.bfG().biB().live_id))) {
                                str = kVar.bfG().getTid();
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
                    if (cVar.bfG() != null && cVar.bfG().getTid() != null) {
                        if (cVar.bfG().getTid().equals(optString)) {
                            it.remove();
                            z = true;
                            z2 = z;
                        } else if (z2) {
                            com.baidu.tieba.homepage.personalize.model.b.dx(this.mDataList);
                            break;
                        }
                    }
                }
                z = z2;
                z2 = z;
            }
            if (this.jkQ != null && this.jkQ.thread_list != null) {
                long j = com.baidu.adp.lib.f.b.toLong(optString, 0L);
                int i2 = 0;
                while (true) {
                    if (i2 < this.jkQ.thread_list.size()) {
                        ThreadInfo threadInfo = this.jkQ.thread_list.get(i2);
                        if (threadInfo == null || threadInfo.tid == null || threadInfo.tid.longValue() != j) {
                            i2++;
                        } else {
                            com.baidu.tieba.homepage.personalize.b.d.a(threadInfo.tid.longValue(), i2, this.jkQ.thread_list, this.mDataList);
                            this.jkQ.thread_list.remove(i2);
                            clR();
                            break;
                        }
                    } else {
                        break;
                    }
                }
                if (this.iuX != null) {
                    List<Integer> b = b(optString, this.iuX);
                    int intValue = b.get(0).intValue();
                    int intValue2 = b.get(1).intValue();
                    if (intValue != -1 && intValue2 != -1) {
                        this.iuX.o(intValue, intValue2);
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
                    if (cVar.bfG() != null && cVar.bfG().getTid().equals(str)) {
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
                    advertAppInfo = ((com.baidu.tieba.homepage.personalize.data.a) next).cjd();
                } else {
                    if (next instanceof ak) {
                        ak akVar = (ak) next;
                        if (akVar.bgy() instanceof AdvertAppInfo.ILegoAdvert) {
                            advertAppInfo = ((AdvertAppInfo.ILegoAdvert) akVar.bgy()).getAdvertAppInfo();
                        }
                    }
                    advertAppInfo = advertAppInfo2;
                }
                if (advertAppInfo != null && str.equals(advertAppInfo.ekv)) {
                    it.remove();
                    advertAppInfo = null;
                }
                advertAppInfo2 = advertAppInfo;
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (this.hXK != null) {
            this.hXK.onChangeSkinType(i);
        }
        if (this.jlc != null) {
            this.jlc.onChangeSkinType();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public am cEG() {
        if (this.hXO == null || this.hXO.drn() == null || !(this.hXO.drn().getTag() instanceof am)) {
            return null;
        }
        return (am) this.hXO.drn().getTag();
    }
}
