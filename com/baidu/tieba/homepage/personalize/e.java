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
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tbadk.n.m;
import com.baidu.tbadk.util.ac;
import com.baidu.tbadk.util.ad;
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
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
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
    private y fGc;
    private View.OnTouchListener frt;
    private be iBO;
    private SmartBubbleAnimatedView iBP;
    private i iBT;
    private com.baidu.tieba.tbadkCore.data.f iSR;
    private final BdTypeRecyclerView iYU;
    private boolean jHo;
    private final BigdaySwipeRefreshLayout jJP;
    private ScrollFragmentTabHost jQO;
    private final long jRI;
    private final b jRJ;
    private DataRes.Builder jRL;
    private final com.baidu.tieba.homepage.personalize.model.a jRO;
    private int jRR;
    private h jRT;
    private BdUniqueId jRW;
    private HomePageYoungsterTopView jRX;
    private int jRY;
    private final af jRa;
    private Runnable jSi;
    private com.baidu.tieba.g.a jxj;
    private final TbPageContext<?> mPageContext;
    private a jRK = null;
    private final List<q> mDataList = new LinkedList();
    private int mPn = 1;
    private boolean mIsLoading = false;
    private boolean jKa = false;
    private int jRM = 2;
    private int jRN = 0;
    private TextView mTipView = null;
    private int iYa = 2000;
    private com.baidu.tbadk.n.c jRP = null;
    private boolean iVM = false;
    private int iVc = 0;
    private int gpN = 0;
    private boolean mIsBackground = false;
    private boolean jPy = true;
    private boolean jRQ = false;
    private boolean jRS = false;
    private boolean jRU = true;
    private FloatInfo jRV = null;
    private BdUniqueId jRZ = BdUniqueId.gen();
    private a.C0097a iTl = new a.C0097a(2);
    private ThreadInfo jSa = null;
    private RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.e.12
        private int jSp = -1;
        private int jKl = 0;
        private boolean jSq = false;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (e.this.jRP == null) {
                e.this.jRP = new com.baidu.tbadk.n.c();
                e.this.jRP.setSubType(1005);
                e.this.jRP.pageType = 1;
            }
            if (e.this.fGc != null && !e.this.mIsBackground) {
                e.this.fGc.m(recyclerView, i);
            }
            if (i == 0) {
                c.i(e.this.iYU);
                e.this.jRP.bFe();
                t.csg().mj(true);
                com.baidu.tieba.a.d.bLT().dS("page_recommend", "show_");
                com.baidu.tieba.t.c.dOe().b(e.this.jRW, false);
                this.jSq = false;
                if (e.this.iBT != null && e.this.jPy && !e.this.mIsBackground) {
                    e.this.iBT.a(e.this.iVc, e.this.gpN, e.this.iVM, 1);
                    return;
                }
                return;
            }
            e.this.jRP.bFd();
            if (i == 1) {
                if (e.this.iBO != null) {
                    e.this.iBO.hideTip();
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
            if (this.jKl > i) {
                this.jSq = true;
            }
            if (e.this.fGc != null && !e.this.mIsBackground) {
                e.this.fGc.onScroll(this.jKl, i);
            }
            this.jKl = i;
            int i3 = (i + i2) - 1;
            if (!this.jSq && this.jSp != i3) {
                this.jSp = i3;
                e.this.CW(this.jSp);
            }
            if (this.jSq && this.jSp != i) {
                this.jSp = i;
                e.this.CW(this.jSp);
            }
            e.this.jSh = i;
            e.this.iVc = i;
            e.this.gpN = (i + i2) - 1;
            am cPi = e.this.cPi();
            if (cPi != null && cPi.tZ() != null) {
                cPi.tZ().b(e.this.iTl);
            }
        }
    };
    private View.OnTouchListener fGd = new View.OnTouchListener() { // from class: com.baidu.tieba.homepage.personalize.e.23
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (e.this.frt != null) {
                e.this.frt.onTouch(view, motionEvent);
            }
            if (e.this.jxj != null) {
                e.this.jxj.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private a.InterfaceC0756a irM = new a.InterfaceC0756a() { // from class: com.baidu.tieba.homepage.personalize.e.30
        @Override // com.baidu.tieba.g.a.InterfaceC0756a
        public void G(int i, int i2) {
            e.this.iVM = false;
        }

        @Override // com.baidu.tieba.g.a.InterfaceC0756a
        public void H(int i, int i2) {
            e.this.iVM = true;
        }

        @Override // com.baidu.tieba.g.a.InterfaceC0756a
        public void ck(int i, int i2) {
        }

        @Override // com.baidu.tieba.g.a.InterfaceC0756a
        public void I(int i, int i2) {
        }
    };
    private View.OnClickListener jSb = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.e.31
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (e.this.iBO != null) {
                e.this.iBO.hideTip();
            }
        }
    };
    private final CustomMessageListener jSc = new CustomMessageListener(CmdConfigCustom.CMD_RELOAD_HP_PERSONALIZED) { // from class: com.baidu.tieba.homepage.personalize.e.32
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (e.this.iYU != null) {
                e.this.iBT.cPh();
                e.this.jPy = false;
                e.this.jJP.setRefreshing(true);
            }
        }
    };
    private final CustomMessageListener jSd = new CustomMessageListener(2921461) { // from class: com.baidu.tieba.homepage.personalize.e.33
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (e.this.iYU != null) {
                e.this.cPY();
            }
        }
    };
    private final CustomMessageListener jSe = new CustomMessageListener(2921486) { // from class: com.baidu.tieba.homepage.personalize.e.34
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data = customResponsedMessage.getData();
            switch (data instanceof Integer ? ((Integer) data).intValue() : 0) {
                case 2:
                    new BdTopToast(e.this.mPageContext.getPageActivity(), 2000).yW(true).Vt(e.this.mPageContext.getPageActivity().getString(R.string.youngster_open_title)).aF((ViewGroup) e.this.mPageContext.getPageActivity().findViewById(R.id.maintabContainer));
                    e.this.rH(true);
                    return;
                case 3:
                    new BdTopToast(e.this.mPageContext.getPageActivity(), 2000).yW(true).Vt(e.this.mPageContext.getPageActivity().getString(R.string.youngster_close_title)).aF((ViewGroup) e.this.mPageContext.getPageActivity().findViewById(R.id.maintabContainer));
                    e.this.rH(false);
                    return;
                case 4:
                default:
                    if (com.baidu.tbadk.youngster.b.c.bKl()) {
                        e.this.rH(true);
                        return;
                    }
                    return;
                case 5:
                    new BdTopToast(e.this.mPageContext.getPageActivity(), 2000).yW(true).Vt(e.this.mPageContext.getPageActivity().getString(R.string.youngster_reset_title)).aF((ViewGroup) e.this.mPageContext.getPageActivity().findViewById(R.id.maintabContainer));
                    e.this.rH(true);
                    return;
            }
        }
    };
    private CustomMessageListener jpR = new CustomMessageListener(CmdConfigCustom.PB_ACTION_PRAISE) { // from class: com.baidu.tieba.homepage.personalize.e.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            by byVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof by) && e.this.jRL != null && com.baidu.tbadk.core.util.y.getCount(e.this.jRL.thread_list) != 0 && (byVar = (by) customResponsedMessage.getData()) != null && byVar.boA() != null && byVar.getId() != null && com.baidu.tbadk.core.util.y.getCount(e.this.jRL.thread_list) != 0) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < e.this.jRL.thread_list.size()) {
                        ThreadInfo threadInfo = e.this.jRL.thread_list.get(i2);
                        if (threadInfo == null || threadInfo.id.longValue() != com.baidu.adp.lib.f.b.toLong(byVar.getId(), -1L)) {
                            i = i2 + 1;
                        } else {
                            ThreadInfo.Builder builder = new ThreadInfo.Builder(threadInfo);
                            Zan.Builder builder2 = new Zan.Builder(builder.zan);
                            builder2.num = Integer.valueOf((int) byVar.boA().getNum());
                            builder.zan = builder2.build(true);
                            e.this.jRL.thread_list.set(i2, builder.build(true));
                            return;
                        }
                    } else {
                        return;
                    }
                }
            }
        }
    };
    private CustomMessageListener jSf = new CustomMessageListener(CmdConfigCustom.CMD_LIVE_VIDEO_CLOSED_QUERY_RESPONSED) { // from class: com.baidu.tieba.homepage.personalize.e.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            by byVar;
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
                        if ((originData.get(i2) instanceof by) && (byVar = (by) originData.get(i2)) != null && byVar.bpj() != null && ids.contains(Long.valueOf(byVar.bpj().live_id))) {
                            e.this.mDataList.remove(byVar);
                        }
                        i = i2 + 1;
                    }
                    if (e.this.jRa != null) {
                        e.this.jRa.cv(new ArrayList(e.this.mDataList));
                    }
                }
            }
        }
    };
    private CustomMessageListener eTG = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.homepage.personalize.e.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int intValue;
            if ((customResponsedMessage instanceof UpdateAttentionMessage) && e.this.jRL != null && !com.baidu.tbadk.core.util.y.isEmpty(e.this.jRL.thread_list)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid)) {
                    int i = 0;
                    while (true) {
                        if (i >= e.this.jRL.thread_list.size()) {
                            break;
                        }
                        ThreadInfo threadInfo = e.this.jRL.thread_list.get(i);
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
                            e.this.jRL.thread_list.set(i, builder.build(true));
                        }
                    }
                    e.this.a(updateAttentionMessage);
                }
            }
        }
    };
    private CustomMessageListener jKg = new CustomMessageListener(0) { // from class: com.baidu.tieba.homepage.personalize.e.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long) && e.this.jRL != null && e.this.jRL.hot_recomforum != null && !com.baidu.tbadk.core.util.y.isEmpty(e.this.jRL.hot_recomforum.tab_list)) {
                long longValue = ((Long) customResponsedMessage.getData()).longValue();
                DiscoverHotForum.Builder builder = new DiscoverHotForum.Builder(e.this.jRL.hot_recomforum);
                if (com.baidu.tieba.homepage.concern.c.a(builder, longValue, customResponsedMessage.getCmd() == 2001335)) {
                    e.this.jRL.hot_recomforum = builder.build(true);
                    e.this.c(new DataRes.Builder(e.this.jRL.build(true)));
                }
            }
        }
    };
    private String jSg = "lastReadReadPositionKey";
    private int jSh = 0;
    private d jSj = new d() { // from class: com.baidu.tieba.homepage.personalize.e.16
        @Override // com.baidu.tieba.homepage.personalize.d
        public void CF(final int i) {
            if (e.this.jSi == null) {
                e.this.jSi = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.e.16.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (e.this.iYU.getHandler() != null) {
                            e.this.iYU.requestFocusFromTouch();
                            if (i <= e.this.iYU.getCount() - 1) {
                                e.this.iYU.setSelection(i);
                            }
                        }
                    }
                };
            }
            e.this.iYU.removeCallbacks(e.this.jSi);
            e.this.iYU.post(e.this.jSi);
        }
    };
    private CustomMessageListener jSk = new CustomMessageListener(2016569) { // from class: com.baidu.tieba.homepage.personalize.e.19
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && e.this.jRT != null) {
                e.this.mDataList.remove(e.this.jRT);
                e.this.jRa.cv(new ArrayList(e.this.mDataList));
                com.baidu.tbadk.core.sharedPref.b.bsO().putLong("key_maintab_banner_close_time", System.currentTimeMillis());
            }
        }
    };
    private CustomMessageListener iBI = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.homepage.personalize.e.20
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.g(customResponsedMessage);
            if (e.this.iBT != null && e.this.jPy) {
                e.this.iBT.a(e.this.iVc, e.this.gpN, e.this.iVM, true);
            }
        }
    };
    private CustomMessageListener iBJ = new CustomMessageListener(CmdConfigCustom.CMD_THREAD_NOT_EXIST_WHEN_ENTER_PB) { // from class: com.baidu.tieba.homepage.personalize.e.21
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.g(customResponsedMessage);
        }
    };
    private CustomMessageListener jqg = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.homepage.personalize.e.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && e.this.jRL != null && com.baidu.tbadk.core.util.y.getCount(e.this.jRL.thread_list) != 0) {
                String str = (String) customResponsedMessage.getData();
                e.this.h(str, e.this.mDataList);
                e.this.Mx(str);
                if (e.this.jRa != null) {
                    e.this.jRa.cv(new ArrayList(e.this.mDataList));
                }
                if (e.this.iBT != null && e.this.jPy) {
                    e.this.iBT.a(e.this.iVc, e.this.gpN, e.this.iVM, true);
                }
            }
        }
    };
    private CustomMessageListener iUJ = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.homepage.personalize.e.24
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            am cPi;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent)) {
                KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24 && (cPi = e.this.cPi()) != null && cPi.tZ() != null) {
                    cPi.tZ().b(new a.C0097a(3));
                }
            }
        }
    };
    private com.baidu.adp.framework.listener.a jSl = new com.baidu.adp.framework.listener.a(1003065, CmdConfigSocket.CMD_TOPIC_BLESS) { // from class: com.baidu.tieba.homepage.personalize.e.25
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
                        if ((qVar instanceof com.baidu.tieba.homepage.topic.topictab.b.a) && (bVar = ((com.baidu.tieba.homepage.topic.topictab.b.a) qVar).jZc) != null && longValue == bVar.pkId) {
                            bVar.userPkId = j2;
                            return;
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener iUK = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.homepage.personalize.e.26
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            List<q> dataList = e.this.jRa.getDataList();
            if (!com.baidu.tbadk.core.util.y.isEmpty(dataList)) {
                for (q qVar : dataList) {
                    if (qVar instanceof k) {
                        k kVar = (k) qVar;
                        if (kVar.eIP != 0 && kVar.eCR != null) {
                            int[] imageWidthAndHeight = kVar.eCR.getImageWidthAndHeight();
                            kVar.eIP = imageWidthAndHeight[0];
                            kVar.eIQ = imageWidthAndHeight[1];
                        }
                    }
                }
            }
            com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.personalize.e.26.1
                @Override // java.lang.Runnable
                public void run() {
                    e.this.jRa.notifyDataSetChanged();
                    if (!e.this.mIsBackground && e.this.jPy) {
                        e.this.iBT.a(e.this.iVc, e.this.gpN, e.this.iVM, true);
                    }
                }
            }, 500L);
        }
    };
    private CustomMessageListener iBK = new CustomMessageListener(2921453) { // from class: com.baidu.tieba.homepage.personalize.e.27
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bg)) {
                bg bgVar = (bg) customResponsedMessage.getData();
                if (bgVar.eHM == 1) {
                    int equipmentWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst());
                    int equipmentHeight = l.getEquipmentHeight(TbadkCoreApplication.getInst());
                    float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
                    int i = av.btX().btY() ? 2 : 1;
                    RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
                    requestGetMyPostNetMessage.setTag(e.this.jRZ);
                    requestGetMyPostNetMessage.setParams(com.baidu.adp.lib.f.b.toLong(bgVar.tid, 0L), 0L, 0L, equipmentWidth, equipmentHeight, f, i);
                    requestGetMyPostNetMessage.setBFrom("push");
                    MessageManager.getInstance().sendMessage(requestGetMyPostNetMessage);
                }
            }
        }
    };
    private final com.baidu.adp.framework.listener.a iBL = new com.baidu.adp.framework.listener.a(1003010, CmdConfigSocket.CMD_GET_MY_POST) { // from class: com.baidu.tieba.homepage.personalize.e.28
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            GetMyPostResIdl getMyPostResIdl = null;
            if (responsedMessage instanceof GetMyPostHttpResponseMessage) {
                getMyPostResIdl = ((GetMyPostHttpResponseMessage) responsedMessage).getResponseData();
            } else if (responsedMessage instanceof GetMyPostSocketResponseMessage) {
                getMyPostResIdl = ((GetMyPostSocketResponseMessage) responsedMessage).getResponseData();
            }
            if (getMyPostResIdl != null && getMyPostResIdl.data != null && getMyPostResIdl.data.thread_info != null) {
                e.this.jSa = getMyPostResIdl.data.thread_info;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921455));
            }
        }
    };
    private CustomMessageListener jSm = new CustomMessageListener(2921482) { // from class: com.baidu.tieba.homepage.personalize.e.29
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (com.baidu.tbadk.coreExtra.c.a.F(TbadkCoreApplication.getInst(), 1)) {
                com.baidu.tbadk.coreExtra.c.a.a(e.this.mPageContext, 7, 0L);
            }
        }
    };

    /* loaded from: classes22.dex */
    public interface a {
        void H(int i, int i2, int i3, int i4);

        void T(int i, int i2, int i3);

        void cPL();

        void onError(int i, String str);

        void rD(boolean z);
    }

    public void rE(boolean z) {
        this.jRU = z;
        if (this.iBO != null && !z) {
            this.iBO.hideTip();
        }
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.jQO = scrollFragmentTabHost;
        if (this.jQO != null) {
            this.jQO.setOnTabSelectedListener(new ScrollFragmentTabHost.b() { // from class: com.baidu.tieba.homepage.personalize.e.1
                @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.b
                public void CP(int i) {
                    if (e.this.jQO.CO(i) != 1 && e.this.iBO != null) {
                        e.this.iBO.hideTip();
                    }
                }
            });
        }
    }

    public void setTabInForeBackgroundState(boolean z) {
        this.mIsBackground = z;
    }

    public void qf(boolean z) {
        boolean z2 = false;
        this.mIsBackground = z;
        if (this.jQO != null) {
            this.jQO.qf(z);
        }
        if (this.iBT != null) {
            this.iBT.tC(!z);
            am cPi = cPi();
            if (cPi != null && cPi.tZ() != null) {
                z2 = cPi.tZ().b(new a.C0097a(8, Boolean.valueOf(z)));
            }
            if (!z2) {
                if (z) {
                    this.iBT.cPh();
                } else if (this.jPy) {
                    this.iBT.a(this.iVc, this.gpN, this.iVM, true);
                }
            }
        }
    }

    public e(TbPageContext<?> tbPageContext, BdTypeRecyclerView bdTypeRecyclerView, af afVar, BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout) {
        this.jRY = 0;
        this.mPageContext = tbPageContext;
        this.jRY = com.baidu.tbadk.core.sharedPref.b.bsO().getInt("key_personalized_refresh_type", 0);
        this.jJP = bigdaySwipeRefreshLayout;
        this.iYU = bdTypeRecyclerView;
        this.iYU.setOnTouchListener(this.fGd);
        if (com.baidu.tbadk.youngster.b.c.bKl()) {
            rH(true);
        }
        this.jxj = new com.baidu.tieba.g.a();
        this.jxj.a(this.irM);
        this.jRa = afVar;
        this.jRO = new com.baidu.tieba.homepage.personalize.model.a();
        this.jRI = com.baidu.tbadk.core.sharedPref.b.bsO().getLong("recommend_frs_cache_time", 1800L) * 1000;
        bdTypeRecyclerView.setOnScrollListener(this.mOnScrollListener);
        this.iBO = new be();
        cPW();
        this.iBT = new i(this.mPageContext, this.iYU);
        this.iBT.IJ(1);
        this.iBT.II(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.jRJ = new b(this.mDataList, this.jRa);
        this.iBP = new SmartBubbleAnimatedView(tbPageContext.getContext());
        this.iBP.setLayoutParams(new FrameLayout.LayoutParams(-1, l.getDimens(tbPageContext.getContext(), R.dimen.tbds83)));
        cPM();
        this.iUK.setTag(this.mPageContext.getUniqueId());
        MessageManager.getInstance().registerListener(this.iUK);
        if (MessageManager.getInstance().findTask(1003010) == null) {
            HomePageStatic.cNq();
        }
        this.iBL.setTag(this.jRZ);
        if (this.iBL.getHttpMessageListener() != null) {
            this.iBL.getHttpMessageListener().setSelfListener(true);
        }
        if (this.iBL.getSocketMessageListener() != null) {
            this.iBL.getSocketMessageListener().setSelfListener(true);
        }
        MessageManager.getInstance().registerListener(this.iBL);
        MessageManager.getInstance().registerListener(this.iBK);
        MessageManager.getInstance().registerListener(this.jSm);
    }

    private void cPM() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2016323, new CustomMessageTask.CustomRunnable<Boolean>() { // from class: com.baidu.tieba.homepage.personalize.e.35
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Boolean> customMessage) {
                am cPi = e.this.cPi();
                return (cPi == null || cPi.tZ() == null) ? new CustomResponsedMessage<>(2016323, false) : new CustomResponsedMessage<>(2016323, Boolean.valueOf(cPi.tZ().b(new a.C0097a(6))));
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private boolean cPN() {
        return com.baidu.tbadk.core.sharedPref.b.bsO().getBoolean(cPP(), true);
    }

    private void cPO() {
        com.baidu.tbadk.core.sharedPref.b.bsO().putBoolean(cPP(), false);
    }

    private String cPP() {
        return "key_rec_pfirst_load_" + TbadkCoreApplication.getCurrentAccount() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + TbConfig.getVersion();
    }

    public void setRecommendFrsNavigationAnimDispatcher(z zVar) {
        if (zVar != null) {
            this.fGc = zVar.bGK();
            this.frt = zVar.bGL();
        }
    }

    public void showFloatingView() {
        if (this.fGc != null) {
            this.fGc.kH(true);
        }
    }

    public void update() {
        com.baidu.tieba.homepage.framework.a.cOb().E(System.currentTimeMillis(), 1);
        this.mPn = 1;
        this.jRS = true;
        if (this.mDataList.size() == 0 && !cPN()) {
            if (!this.jKa) {
                bmf();
                return;
            }
            return;
        }
        bme();
    }

    public void cJ(int i, int i2) {
        by byVar;
        if (!com.baidu.tbadk.core.util.y.isEmpty(this.mDataList) && this.mDataList.size() > i) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            while (i < this.mDataList.size() && i <= i2) {
                if (this.mDataList.get(i).getType().getId() == by.eJr.getId() && (byVar = (by) this.mDataList.get(i)) != null && byVar.bpj() != null) {
                    arrayList.add(Long.valueOf(byVar.bpj().live_id));
                    arrayList2.add(byVar);
                }
                i++;
            }
            if (!com.baidu.tbadk.core.util.y.isEmpty(arrayList)) {
                MessageManager.getInstance().sendMessage(new LiveRoomClosedQueryMessage(arrayList, arrayList2));
            }
        }
    }

    public void cPQ() {
        if (this.iBT != null && !this.mIsBackground && this.jPy) {
            this.iBT.a(this.iVc, this.gpN, this.iVM, true);
        }
        if (this.jRQ) {
            if (this.jJP != null && !this.jJP.bvy()) {
                if (this.jHo) {
                    com.baidu.tieba.t.c.dOe().b(this.jRW, false);
                    if (rG(false)) {
                        cK(3, this.jRN);
                    } else if (this.jRR > 0) {
                        cK(2, this.jRN);
                    }
                } else if (!this.jHo && this.jRN == 0) {
                    cK(2, 0);
                }
            }
            this.jRQ = false;
            this.jHo = false;
            this.jRR = 0;
            if (this.jRS) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
            }
            this.jRS = false;
        }
    }

    public void bRM() {
        if (isLoading()) {
            com.baidu.tieba.homepage.framework.a.cOb().E(0L, 1);
        } else if (this.jRK != null) {
            cPS();
            this.mPn++;
            setIsLoading(true);
            this.jRK.H(this.mPn, (this.jRL == null || this.jRL.thread_list == null) ? 0 : this.jRL.thread_list.size(), rF(false), 0);
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
            g.cQd();
        }
        if (this.jRO != null && this.jRO.cQw() && !z && (dataRes == null || com.baidu.tbadk.core.util.y.isEmpty(dataRes.thread_list))) {
            if (dataRes == null) {
                DataRes.Builder builder = new DataRes.Builder();
                builder.thread_list = new ArrayList();
                dataRes = builder.build(false);
            }
            if (dataRes.thread_list != null) {
                List<ThreadInfo> cQx = this.jRO.cQx();
                dataRes.thread_list.addAll(cQx);
                if (cQx != null) {
                    cQx.clear();
                }
                z3 = true;
                size = (this.jRL != null || this.jRL.thread_list == null) ? 0 : this.jRL.thread_list.size();
                if (z && i == 0 && dataRes != null && com.baidu.tbadk.core.util.y.isEmpty(dataRes.thread_list)) {
                    if (this.jRK != null) {
                        this.jRK.cPL();
                    }
                    setIsLoading(false);
                    if (this.jJP != null) {
                        this.jJP.setRefreshing(false);
                        return;
                    }
                    return;
                }
                if (this.jSa != null) {
                    DataRes.Builder builder2 = new DataRes.Builder(dataRes);
                    builder2.thread_list.add(0, this.jSa);
                    dataRes = builder2.build(false);
                    if (this.jRL != null && !com.baidu.tbadk.core.util.y.isEmpty(this.jRL.thread_list)) {
                        Iterator<ThreadInfo> it = this.jRL.thread_list.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            ThreadInfo next = it.next();
                            if (next != null && next.tid != null && this.jSa.tid != null && next.tid.longValue() == this.jSa.tid.longValue()) {
                                this.jRL.thread_list.remove(next);
                                break;
                            }
                        }
                    }
                    this.jSa = null;
                }
                if ((z3 && i != 0) || dataRes == null || !a(true, z, z2, dataRes)) {
                    this.jRQ = false;
                    if (this.mDataList.size() > 0) {
                        if (this.jRK != null) {
                            this.jRK.onError(1, str);
                        }
                    } else if (this.jRK != null) {
                        this.jRK.onError(2, str);
                    }
                } else {
                    cPO();
                    if (this.jRK != null) {
                        com.baidu.tbadk.core.sharedPref.b.bsO().putLong(SharedPrefConfig.RECOMMEND_FRS_REFRESH_TIME + TbadkCoreApplication.getCurrentAccount(), System.currentTimeMillis());
                        this.jRK.rD(false);
                    }
                    this.jRQ = true;
                    this.jHo = z;
                    this.jRR = size;
                    cvq();
                }
                setIsLoading(false);
                if (this.jJP == null) {
                    f.e cPR = cPR();
                    if (this.jJP.bvy() && cPR != null) {
                        this.jJP.c(cPR);
                        return;
                    } else {
                        this.jJP.setRefreshing(false);
                        return;
                    }
                }
                return;
            }
        }
        z3 = false;
        if (this.jRL != null) {
        }
        if (z) {
        }
        if (this.jSa != null) {
        }
        if (z3) {
        }
        cPO();
        if (this.jRK != null) {
        }
        this.jRQ = true;
        this.jHo = z;
        this.jRR = size;
        cvq();
        setIsLoading(false);
        if (this.jJP == null) {
        }
    }

    private f.e cPR() {
        int i;
        String feedText;
        if (!this.jRQ || this.jJP == null || !this.jJP.bvy() || cPV()) {
            return null;
        }
        int i2 = this.jRN;
        if (this.jHo) {
            com.baidu.tieba.t.c.dOe().b(this.jRW, false);
            if (rG(false)) {
                i = 3;
            } else {
                i = this.jRR > 0 ? 2 : 0;
            }
        } else if (this.jHo || this.jRN != 0) {
            return null;
        } else {
            i2 = 0;
            i = 2;
        }
        if (this.jQO != null) {
            this.iBO.cEz();
        }
        if (this.jQO != null && this.jQO.getCurrentTabType() != 1) {
            this.iBO.hideTip();
            return null;
        } else if (!this.jRU) {
            this.iBO.hideTip();
            return null;
        } else {
            this.jRM = i;
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
                this.iYa = 1000;
            } else {
                this.iYa = 0;
            }
            return new f.e(feedText, this.iYa);
        }
    }

    public void rq(boolean z) {
        if (z) {
            this.jRa.notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        if (this.iBT != null) {
            this.iBT.destroy();
        }
        if (this.iBO != null) {
            this.iBO.onDestroy();
        }
        if (this.jRJ != null) {
            this.jRJ.onDestroy();
        }
        if (this.iYU != null) {
            this.iYU.removeCallbacks(this.jSi);
        }
        MessageManager.getInstance().unRegisterTask(2016323);
        MessageManager.getInstance().unRegisterListener(this.iUK);
        MessageManager.getInstance().unRegisterListener(this.iBK);
        MessageManager.getInstance().unRegisterListener(this.iBL);
        MessageManager.getInstance().unRegisterListener(this.jSm);
    }

    public void onPause() {
        c.i(this.iYU);
        CX(this.jSh);
        if (this.jRP != null) {
            this.jRP.bFf();
        }
    }

    private void bme() {
        if (this.jRK != null) {
            this.jRK.T((this.jRL == null || this.jRL.thread_list == null || cPU()) ? 0 : this.jRL.thread_list.size(), rF(true), 0);
        }
    }

    public int rF(boolean z) {
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
                if (!(qVar instanceof com.baidu.tieba.homepage.personalize.data.a) || qVar.getType() == AdvertAppInfo.eDS) {
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
                if ((qVar2 instanceof com.baidu.tieba.homepage.personalize.data.a) && qVar2.getType() != AdvertAppInfo.eDS) {
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
        this.jKa = true;
        if (dataRes != null) {
            if (a(false, true, true, dataRes) && !cPU()) {
                if (this.jRK != null) {
                    this.jRK.rD(true);
                    Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler() { // from class: com.baidu.tieba.homepage.personalize.e.2
                        @Override // android.os.MessageQueue.IdleHandler
                        public boolean queueIdle() {
                            e.this.bFi();
                            return false;
                        }
                    });
                }
                if (TbSingleton.getInstance().getForceRefreshHomeRecommend()) {
                    bme();
                    TbSingleton.getInstance().setForceRefreshHomeRecommend(false);
                    return;
                }
                return;
            }
            bme();
            return;
        }
        bme();
    }

    public void bFi() {
        m.bFp().ev(System.currentTimeMillis() - m.bFp().bFo());
    }

    private void i(List<q> list, int i) {
        Set<q> a2 = com.baidu.tieba.recapp.a.a(list, this.mPn, "NEWINDEX");
        if (a2.size() > 0) {
            com.baidu.tieba.t.c.dOe().b(this.jRW, com.baidu.tieba.t.a.b(PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE, "common_fill", true, a2.size()));
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
        if (this.jRY == 1) {
            if (z2 && (dataRes.thread_list.size() >= 6 || cPU())) {
                cPT();
                this.jRL = null;
            }
        } else if (z2 && cPU()) {
            this.jRL = null;
        }
        int size = z2 ? 0 : this.mDataList.size();
        DataRes.Builder builder = new DataRes.Builder(dataRes);
        this.mDataList.clear();
        com.baidu.tieba.homepage.personalize.model.c a2 = this.jRO.a(z, this.jRL, builder, z2 ? 0 : 1);
        if (a2 == null) {
            list = null;
            i = 0;
        } else {
            List<q> list2 = a2.fVe;
            this.jRN = a2.jUT;
            int i2 = a2.jUU;
            a2.jUU = 0;
            list = list2;
            i = i2;
        }
        if (list != null) {
            this.mDataList.addAll(list);
            i(list, size);
            a(z2 ? 0 : 1, list, size);
            if (this.jRS) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
            }
        }
        if (this.jRL == null) {
            this.jRL = builder;
            this.jRJ.dW(this.jRL.thread_list);
        }
        if (this.mDataList.size() == 0) {
            z4 = false;
        } else {
            if (z2) {
                if (dataRes.live_answer != null) {
                    this.jRT = new h();
                    this.jRT.a(dataRes.live_answer);
                    this.jRL.live_answer = dataRes.live_answer;
                } else if (z) {
                    this.jRT = null;
                    this.jRL.live_answer = null;
                }
                this.jRV = dataRes.float_info;
                this.jRL.float_info = dataRes.float_info;
            }
            long j = com.baidu.tbadk.core.sharedPref.b.bsO().getLong("key_maintab_banner_close_time", 0L);
            if (this.jRT != null && !au.isTaday(j)) {
                this.mDataList.add(0, this.jRT);
            }
            LinkedList linkedList = new LinkedList(this.mDataList);
            this.jRa.setFromCDN(dataRes.is_new_url != null && dataRes.is_new_url.intValue() == 1);
            this.jRa.j(linkedList, i);
            z4 = true;
            if (this.iBT != null && this.jPy) {
                this.iBT.a(this.iVc, this.gpN, this.iVM, true);
            }
        }
        com.baidu.tieba.homepage.framework.a.cOb().C(System.currentTimeMillis() - currentTimeMillis, 1);
        long CE = com.baidu.tieba.homepage.framework.a.cOb().CE(1);
        if (CE > 0) {
            com.baidu.tieba.homepage.framework.a.cOb().D(System.currentTimeMillis() - CE, 1);
            com.baidu.tieba.homepage.framework.a.cOb().E(0L, 1);
        }
        if (dataRes.anti != null && dataRes.anti.block_pop_info != null) {
            com.baidu.tieba.ueg.d.d(dataRes.anti.block_pop_info);
        }
        bi biVar = new bi();
        biVar.a(dataRes.recom_post_topic);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_REFRESH_TOPIC_TIP, biVar));
        if (!z && CE > 0) {
            m.bFp().eH(System.currentTimeMillis() - CE);
            return z4;
        }
        return z4;
    }

    private void cPS() {
        List<q> list;
        int i;
        if (com.baidu.tbadk.core.util.y.getCount(this.mDataList) >= this.jRO.cQs() - 40) {
            com.baidu.tieba.homepage.personalize.model.c a2 = this.jRO.a(true, this.jRL, null, 1);
            if (a2 != null) {
                List<q> list2 = a2.fVe;
                i = a2.jUU;
                a2.jUU = 0;
                list = list2;
            } else {
                list = null;
                i = 0;
            }
            if (list != null) {
                this.mDataList.clear();
                this.mDataList.addAll(list);
                this.jRa.j(new LinkedList(this.mDataList), i);
            }
        }
    }

    private void bmf() {
        this.jKa = true;
        ad.a(new ac<DataRes>() { // from class: com.baidu.tieba.homepage.personalize.e.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.ac
            /* renamed from: cPZ */
            public DataRes doInBackground() {
                com.baidu.adp.lib.cache.l<byte[]> dM = com.baidu.tbadk.core.c.a.brq().dM("tb.rec_frs_update", TbadkCoreApplication.getCurrentAccount());
                if (dM == null) {
                    return null;
                }
                byte[] bArr = dM.get("0");
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
        }, new com.baidu.tbadk.util.m<DataRes>() { // from class: com.baidu.tieba.homepage.personalize.e.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.m
            /* renamed from: b */
            public void onReturnDataInUI(DataRes dataRes) {
                e.this.a(dataRes);
            }
        });
    }

    private void cvq() {
        if (this.jRL != null) {
            DataRes.Builder builder = new DataRes.Builder(this.jRL.build(true));
            if (builder.thread_list != null && builder.thread_list.size() > 30) {
                builder.thread_list = builder.thread_list.subList(0, 30);
            }
            a(builder, builder.thread_list != null ? builder.thread_list.size() : 0);
            a(builder);
            b(builder);
            c(builder);
        }
    }

    private void cPT() {
        if (this.jRL != null) {
            final DataRes.Builder builder = new DataRes.Builder(this.jRL.build(true));
            if (builder.thread_list != null && builder.thread_list.size() > 50) {
                builder.thread_list = builder.thread_list.subList(0, 50);
            }
            a(builder, builder.thread_list != null ? builder.thread_list.size() : 0);
            ad.a(new ac<Object>() { // from class: com.baidu.tieba.homepage.personalize.e.5
                @Override // com.baidu.tbadk.util.ac
                public Object doInBackground() {
                    DataRes.Builder builder2 = new DataRes.Builder(builder.build(true));
                    e.this.jRJ.dX(builder2.thread_list);
                    try {
                        com.baidu.tbadk.core.c.a.brq().dM("tb.rec_old_data", TbadkCoreApplication.getCurrentAccount()).setForever("0", builder2.build(true).toByteArray());
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
    public void Mx(String str) {
        if (!TextUtils.isEmpty(str) && this.jRL != null && this.jRL.banner_list != null && this.jRL.banner_list.app != null && this.jRL.banner_list.app.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (App app : this.jRL.banner_list.app) {
                if (app != null && str.equals(app.id)) {
                    arrayList.add(app);
                }
            }
            BannerList.Builder builder = new BannerList.Builder(this.jRL.banner_list);
            if (builder.app != null) {
                builder.app.removeAll(arrayList);
            }
            this.jRL.banner_list = builder.build(false);
            DataRes.Builder builder2 = new DataRes.Builder(this.jRL.build(true));
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
                e.this.jRJ.dX(builder2.thread_list);
                try {
                    com.baidu.tbadk.core.c.a.brq().dM("tb.rec_frs_update", TbadkCoreApplication.getCurrentAccount()).setForever("0", builder2.build(true).toByteArray());
                    return null;
                } catch (Exception e) {
                    BdLog.e(e);
                    return null;
                }
            }
        }, null);
    }

    private boolean cPU() {
        return rG(true);
    }

    private boolean rG(boolean z) {
        long j = com.baidu.tbadk.core.sharedPref.b.bsO().getLong(SharedPrefConfig.RECOMMEND_FRS_REFRESH_TIME + TbadkCoreApplication.getCurrentAccount(), 0L);
        return j == 0 ? z : Math.abs(System.currentTimeMillis() - j) > this.jRI;
    }

    public void a(a aVar) {
        this.jRK = aVar;
    }

    private boolean isLoading() {
        return this.mIsLoading;
    }

    private void setIsLoading(boolean z) {
        this.mIsLoading = z;
    }

    public void cPG() {
        boolean z = true;
        com.baidu.tbadk.coreExtra.data.b activityPrizeData = TbadkCoreApplication.getInst().getActivityPrizeData();
        if (activityPrizeData.isSwitchTurn() && !StringUtils.isNull(activityPrizeData.getFeedText())) {
            String currentDay = UtilHelper.getCurrentDay();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            String str = "";
            if (!StringUtils.isNull(currentAccount)) {
                String string = com.baidu.tbadk.core.sharedPref.b.bsO().getString(SharedPrefConfig.ACTIVITY_PRIZE_FEED_TEXT_TIME, "");
                if (!StringUtils.isNull(string)) {
                    String[] split = string.split(UgcConstant.AT_RULE_TAG);
                    if (split != null && split.length == 2) {
                        String str2 = split[0];
                        String[] split2 = split[1].split(",");
                        if (!StringUtils.isNull(str2) && split2.length != 0) {
                            if (str2.equals(currentDay)) {
                                List<String> asList = Arrays.asList(split2);
                                if (asList.contains(currentAccount)) {
                                    z = false;
                                } else {
                                    StringBuilder sb = new StringBuilder();
                                    sb.append(currentDay).append(UgcConstant.AT_RULE_TAG);
                                    for (String str3 : asList) {
                                        sb.append(str3).append(",");
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
                    cK(4, 0);
                    com.baidu.tbadk.core.sharedPref.b.bsO().putString(SharedPrefConfig.ACTIVITY_PRIZE_FEED_TEXT_TIME, str);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rH(boolean z) {
        boolean z2 = com.baidu.tbadk.core.sharedPref.b.bsO().getBoolean("key_youngster_homgpage_top_view_closed", false);
        if (this.iYU != null && !z2) {
            if (z) {
                if (this.jRX == null) {
                    this.jRX = new HomePageYoungsterTopView(this.mPageContext);
                    this.jRX.setOnDeleteClick(new HomePageYoungsterTopView.a() { // from class: com.baidu.tieba.homepage.personalize.e.7
                        @Override // com.baidu.tieba.homepage.personalize.view.HomePageYoungsterTopView.a
                        public void cQa() {
                            new BdTopToast(e.this.mPageContext.getPageActivity(), 2000).yW(true).Vt(e.this.mPageContext.getPageActivity().getString(R.string.youngster_frs_top_toast)).aF((ViewGroup) e.this.mPageContext.getPageActivity().findViewById(R.id.maintabContainer));
                            e.this.rH(false);
                            com.baidu.tbadk.core.sharedPref.b.bsO().putBoolean("key_youngster_homgpage_top_view_closed", true);
                        }
                    });
                }
                this.iYU.setHeaderView(this.jRX, false);
                this.jRX.setVisibility(0);
                this.iYU.scrollToPosition(0);
            } else if (this.jRX != null) {
                this.jRX.setVisibility(8);
                this.iYU.removeHeaderView(this.jRX);
                this.jRX = null;
            }
        }
    }

    private boolean cPV() {
        return this.jRX != null && this.jRX.getVisibility() == 0;
    }

    private void cK(int i, int i2) {
        if (!cPV()) {
            if (this.jQO != null) {
                this.iBO.cEz();
            }
            if (this.jQO != null && this.jQO.getCurrentTabType() != 1) {
                this.iBO.hideTip();
            } else if (!this.jRU) {
                this.iBO.hideTip();
            } else {
                this.jRM = i;
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
                        this.iYa = 3000;
                    } else {
                        this.iYa = 2000;
                    }
                    this.iBP.fcw = str;
                    this.iBP.iXT = this.iYa;
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 49;
                    if (this.jQO != null) {
                        FrameLayout frameLayout = this.jQO.getFrameLayout();
                        frameLayout.removeView(this.iBP);
                        frameLayout.addView(this.iBP, layoutParams);
                        this.iBP.cEx();
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(Long l) {
        if (this.jRL != null && this.jRL.thread_list != null) {
            List<ThreadInfo> list = this.jRL.thread_list;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                ThreadInfo threadInfo = list.get(i);
                if (threadInfo.tid.equals(l) && threadInfo.top_agree_post != null) {
                    ThreadInfo.Builder builder = new ThreadInfo.Builder(threadInfo);
                    builder.top_agree_post = null;
                    list.set(i, builder.build(true));
                    cvq();
                    a(false, true, false, this.jRL.build(true));
                    return;
                }
            }
        }
    }

    public void o(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.jRW = bdUniqueId;
            if (this.jpR != null) {
                this.jpR.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.jpR);
            }
            if (this.jSc != null) {
                this.jSc.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.jSc);
            }
            this.jSd.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.jSd);
            this.eTG.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.eTG);
            this.jKg.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_LIKE_FORUM, this.jKg);
            MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_UNLIKE_FORUM, this.jKg);
            this.jSf.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.jSf);
            this.iBI.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.iBI);
            this.iBJ.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.iBJ);
            this.jqg.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.jqg);
            if (this.iBT != null) {
                this.iBT.setUniqueId(bdUniqueId);
            }
            this.jRJ.l(bdUniqueId);
            this.jSk.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.jSk);
            this.iUJ.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.iUJ);
            this.jSl.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.jSl);
            this.jSe.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.jSe);
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
                        com.baidu.adp.lib.cache.l<byte[]> dM = com.baidu.tbadk.core.c.a.brq().dM("tb.rec_frs_update", TbadkCoreApplication.getCurrentAccount());
                        if (dM == null) {
                            return false;
                        }
                        byte[] bArr = dM.get("0");
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
                        e.this.jRJ.dX(builder5.thread_list);
                        dM.setForever("0", builder5.build(true).toByteArray());
                        return true;
                    } catch (Exception e) {
                        BdLog.e(e);
                        return false;
                    }
                }
            }, new com.baidu.tbadk.util.m<Boolean>() { // from class: com.baidu.tieba.homepage.personalize.e.14
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.m
                public void onReturnDataInUI(Boolean bool) {
                }
            });
        }
    }

    public void cPW() {
        this.iSR = new com.baidu.tieba.tbadkCore.data.f("new_index", null);
        this.iSR.dON();
    }

    public void a(int i, List<q> list, int i2) {
        int i3;
        int i4;
        if (this.iSR != null) {
            if (i == 0) {
                this.iSR.dON();
            }
            if (list != null && !list.isEmpty()) {
                int[] iArr = com.baidu.tieba.tbadkCore.data.f.nli;
                int i5 = 0;
                int i6 = 0;
                int i7 = 0;
                while (i7 < list.size() && i6 < iArr.length && (i3 = iArr[i6]) >= 0) {
                    if (list.get(i7) instanceof com.baidu.tieba.card.data.b) {
                        i4 = i5 + 1;
                        if (i4 == i3 - 1) {
                            if (i2 < i7 + 1) {
                                this.iSR.dy(i3, i7 + 1);
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

    public void CW(int i) {
        if ((this.iSR != null ? this.iSR.KS(i) : -1) >= 0 && this.iYU != null && this.iYU.getData() != null && this.iYU.getData().size() > i) {
            this.iSR.KT(i);
        }
    }

    public i cDi() {
        return this.iBT;
    }

    public void rz(boolean z) {
        this.jPy = z;
    }

    public void CX(final int i) {
        ad.a(new ac<Object>() { // from class: com.baidu.tieba.homepage.personalize.e.15
            @Override // com.baidu.tbadk.util.ac
            public Object doInBackground() {
                com.baidu.adp.lib.cache.l<String> dN = com.baidu.tbadk.core.c.a.brq().dN(e.this.jSg, TbadkCoreApplication.getCurrentAccount());
                if (dN != null) {
                    dN.set(e.this.jSg, Integer.toString(i), 43200000L);
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
            /* renamed from: cQb */
            public String doInBackground() {
                com.baidu.adp.lib.cache.l<String> dN = com.baidu.tbadk.core.c.a.brq().dN(e.this.jSg, TbadkCoreApplication.getCurrentAccount());
                if (dN != null) {
                    return dN.get(e.this.jSg);
                }
                return null;
            }
        }, new com.baidu.tbadk.util.m<String>() { // from class: com.baidu.tieba.homepage.personalize.e.18
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.m
            /* renamed from: My */
            public void onReturnDataInUI(String str) {
                if (dVar != null) {
                    dVar.CF(com.baidu.adp.lib.f.b.toInt(str, 0));
                }
            }
        });
    }

    public void cPJ() {
        c.j(this.iYU);
    }

    public void cPX() {
        a(this.jSj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cPY() {
        Iterator<q> it = this.mDataList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            } else if (it.next() instanceof com.baidu.tieba.homepage.personalize.data.g) {
                it.remove();
                break;
            }
        }
        if (this.jRL != null) {
            this.jRL.active_center = null;
            cvq();
            if (this.iYU != null) {
                List<Integer> k = k(this.iYU);
                int intValue = k.get(0).intValue();
                int intValue2 = k.get(1).intValue();
                if (intValue != -1 && intValue2 != -1) {
                    this.iYU.p(intValue, intValue2);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(CustomResponsedMessage<?> customResponsedMessage) {
        boolean z;
        String str;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.jRL != null && com.baidu.tbadk.core.util.y.getCount(this.jRL.thread_list) != 0 && com.baidu.tbadk.core.util.y.getCount(this.mDataList) != 0) {
            JSONObject jSONObject = (JSONObject) customResponsedMessage.getData();
            String optString = jSONObject.optString("tid");
            if (StringUtils.isNull(optString)) {
                String optString2 = jSONObject.optString(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_ID);
                if (this.iYU != null && !TextUtils.isEmpty(optString2)) {
                    int i = 0;
                    while (true) {
                        if (i >= this.iYU.getCount()) {
                            str = optString;
                            break;
                        }
                        q item = this.iYU.getItem(i);
                        if (item instanceof com.baidu.tieba.card.data.j) {
                            com.baidu.tieba.card.data.j jVar = (com.baidu.tieba.card.data.j) item;
                            if (jVar.bmn() != null && jVar.bmn().bpj() != null && optString2.equals(String.valueOf(jVar.bmn().bpj().live_id))) {
                                str = jVar.bmn().getTid();
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
                    if (bVar.bmn() != null && bVar.bmn().getTid() != null) {
                        if (bVar.bmn().getTid().equals(optString)) {
                            it.remove();
                            z = true;
                            z2 = z;
                        } else if (z2) {
                            com.baidu.tieba.homepage.personalize.model.b.dZ(this.mDataList);
                            break;
                        }
                    }
                }
                z = z2;
                z2 = z;
            }
            if (this.jRL != null && this.jRL.thread_list != null) {
                long j = com.baidu.adp.lib.f.b.toLong(optString, 0L);
                int i2 = 0;
                while (true) {
                    if (i2 < this.jRL.thread_list.size()) {
                        ThreadInfo threadInfo = this.jRL.thread_list.get(i2);
                        if (threadInfo == null || threadInfo.tid == null || threadInfo.tid.longValue() != j) {
                            i2++;
                        } else {
                            com.baidu.tieba.homepage.personalize.b.d.a(threadInfo.tid.longValue(), i2, this.jRL.thread_list, this.mDataList);
                            this.jRL.thread_list.remove(i2);
                            cvq();
                            break;
                        }
                    } else {
                        break;
                    }
                }
                if (this.iYU != null) {
                    List<Integer> b = b(optString, this.iYU);
                    int intValue = b.get(0).intValue();
                    int intValue2 = b.get(1).intValue();
                    if (intValue != -1 && intValue2 != -1) {
                        this.iYU.p(intValue, intValue2);
                    }
                }
            }
        }
    }

    private List<Integer> k(BdTypeRecyclerView bdTypeRecyclerView) {
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
                    if (bVar.bmn() != null && bVar.bmn().getTid().equals(str)) {
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
                    advertAppInfo = ((com.baidu.tieba.homepage.personalize.data.a) next).csD();
                } else {
                    if (next instanceof com.baidu.tbadk.core.data.am) {
                        com.baidu.tbadk.core.data.am amVar = (com.baidu.tbadk.core.data.am) next;
                        if (amVar.bng() instanceof AdvertAppInfo.ILegoAdvert) {
                            advertAppInfo = ((AdvertAppInfo.ILegoAdvert) amVar.bng()).getAdvertAppInfo();
                        }
                    }
                    advertAppInfo = advertAppInfo2;
                }
                if (advertAppInfo != null && str.equals(advertAppInfo.eEd)) {
                    it.remove();
                    advertAppInfo = null;
                }
                advertAppInfo2 = advertAppInfo;
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (this.iBP != null) {
            this.iBP.onChangeSkinType(i);
        }
        if (this.jRX != null) {
            this.jRX.onChangeSkinType();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public am cPi() {
        if (this.iBT == null || this.iBT.dBO() == null || !(this.iBT.dBO().getTag() instanceof am)) {
            return null;
        }
        return (am) this.iBT.dBO().getTag();
    }
}
