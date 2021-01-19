package com.baidu.tieba.homepage.personalize;

import android.os.Looper;
import android.os.MessageQueue;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
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
import com.baidu.adp.widget.ListView.n;
import com.baidu.ala.atomdata.AlaSDKShareEmptyActivityConfig;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.card.a.a;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.am;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tbadk.util.ac;
import com.baidu.tbadk.util.x;
import com.baidu.tbadk.util.y;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.LiveRoomClosedQueryMessage;
import com.baidu.tieba.card.data.k;
import com.baidu.tieba.card.s;
import com.baidu.tieba.f.a;
import com.baidu.tieba.frs.SmartBubbleAnimatedView;
import com.baidu.tieba.frs.bb;
import com.baidu.tieba.homepage.BlessHttpResponseMessage;
import com.baidu.tieba.homepage.BlessSocketResponseMessage;
import com.baidu.tieba.homepage.GetMyPostHttpResponseMessage;
import com.baidu.tieba.homepage.GetMyPostSocketResponseMessage;
import com.baidu.tieba.homepage.HomePageStatic;
import com.baidu.tieba.homepage.RequestGetMyPostNetMessage;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import com.baidu.tieba.homepage.personalize.adapter.ab;
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
/* loaded from: classes2.dex */
public class e {
    private x fKY;
    private View.OnTouchListener fwq;
    private i iJA;
    private bb iJv;
    private SmartBubbleAnimatedView iJw;
    private com.baidu.tieba.f.a jFc;
    private boolean jQd;
    private final BigdaySwipeRefreshLayout jSy;
    private final ab jZH;
    private ScrollFragmentTabHost jZv;
    private com.baidu.tieba.tbadkCore.data.f jax;
    private final BdTypeRecyclerView jgC;
    private h kaA;
    private BdUniqueId kaD;
    private HomePageYoungsterTopView kaE;
    private int kaF;
    private Runnable kaP;
    private final long kap;
    private final b kaq;
    private DataRes.Builder kas;
    private final com.baidu.tieba.homepage.personalize.model.a kav;
    private int kay;
    private final TbPageContext<?> mPageContext;
    private a kar = null;
    private final List<n> mDataList = new LinkedList();
    private int mPn = 1;
    private boolean mIsLoading = false;
    private boolean jSJ = false;
    private int kat = 2;
    private int kau = 0;
    private TextView mTipView = null;
    private int jfI = 2000;
    private com.baidu.tbadk.n.c kaw = null;
    private boolean jdt = false;
    private int jcJ = 0;
    private int gwh = 0;
    private boolean mIsBackground = false;
    private boolean jYj = true;
    private boolean kax = false;
    private boolean kaz = false;
    private boolean kaB = true;
    private FloatInfo kaC = null;
    private BdUniqueId kaG = BdUniqueId.gen();
    private a.C0089a jaR = new a.C0089a(2);
    private ThreadInfo kaH = null;
    private RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.e.12
        private int kaW = -1;
        private int jSU = 0;
        private boolean kaX = false;

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (e.this.kaw == null) {
                e.this.kaw = new com.baidu.tbadk.n.c();
                e.this.kaw.setSubType(1005);
                e.this.kaw.pageType = 1;
            }
            if (e.this.fKY != null && !e.this.mIsBackground) {
                e.this.fKY.q(recyclerView, i);
            }
            if (i == 0) {
                c.i(e.this.jgC);
                e.this.kaw.bDH();
                s.crj().mC(true);
                com.baidu.tieba.a.d.bKv().dQ("page_recommend", "show_");
                com.baidu.tieba.s.c.dKg().b(e.this.kaD, false);
                this.kaX = false;
                if (e.this.iJA != null && e.this.jYj && !e.this.mIsBackground) {
                    e.this.iJA.a(e.this.jcJ, e.this.gwh, e.this.jdt, 1);
                    return;
                }
                return;
            }
            e.this.kaw.bDG();
            if (i == 1) {
                if (e.this.iJv != null) {
                    e.this.iJv.hideTip();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921418));
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            int i3;
            int i4;
            if (recyclerView == null || !(recyclerView instanceof BdRecyclerView)) {
                i3 = 0;
                i4 = 0;
            } else {
                int firstVisiblePosition = ((BdRecyclerView) recyclerView).getFirstVisiblePosition();
                i3 = ((BdRecyclerView) recyclerView).getLastVisiblePosition();
                i4 = firstVisiblePosition;
            }
            onScroll(i4, (i3 - i4) + 1);
        }

        public void onScroll(int i, int i2) {
            if (this.jSU > i) {
                this.kaX = true;
            }
            if (e.this.fKY != null && !e.this.mIsBackground) {
                e.this.fKY.onScroll(this.jSU, i);
            }
            this.jSU = i;
            int i3 = (i + i2) - 1;
            if (!this.kaX && this.kaW != i3) {
                this.kaW = i3;
                e.this.BD(this.kaW);
            }
            if (this.kaX && this.kaW != i) {
                this.kaW = i;
                e.this.BD(this.kaW);
            }
            e.this.kaO = i;
            e.this.jcJ = i;
            e.this.gwh = (i + i2) - 1;
            ThreadCardViewHolder cOy = e.this.cOy();
            if (cOy != null && cOy.tm() != null) {
                cOy.tm().b(e.this.jaR);
            }
        }
    };
    private View.OnTouchListener bPd = new View.OnTouchListener() { // from class: com.baidu.tieba.homepage.personalize.e.23
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (e.this.fwq != null) {
                e.this.fwq.onTouch(view, motionEvent);
            }
            if (e.this.jFc != null) {
                e.this.jFc.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private a.InterfaceC0710a izu = new a.InterfaceC0710a() { // from class: com.baidu.tieba.homepage.personalize.e.30
        @Override // com.baidu.tieba.f.a.InterfaceC0710a
        public void G(int i, int i2) {
            e.this.jdt = false;
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0710a
        public void H(int i, int i2) {
            e.this.jdt = true;
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0710a
        public void cj(int i, int i2) {
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0710a
        public void I(int i, int i2) {
        }
    };
    private View.OnClickListener kaI = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.e.31
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (e.this.iJv != null) {
                e.this.iJv.hideTip();
            }
        }
    };
    private final CustomMessageListener kaJ = new CustomMessageListener(CmdConfigCustom.CMD_RELOAD_HP_PERSONALIZED) { // from class: com.baidu.tieba.homepage.personalize.e.32
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (e.this.jgC != null) {
                e.this.iJA.cOx();
                e.this.jYj = false;
                e.this.jSy.setRefreshing(true);
            }
        }
    };
    private final CustomMessageListener kaK = new CustomMessageListener(2921461) { // from class: com.baidu.tieba.homepage.personalize.e.33
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (e.this.jgC != null) {
                e.this.cPo();
            }
        }
    };
    private final CustomMessageListener kaL = new CustomMessageListener(2921486) { // from class: com.baidu.tieba.homepage.personalize.e.34
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data = customResponsedMessage.getData();
            switch (data instanceof Integer ? ((Integer) data).intValue() : 0) {
                case 2:
                    new BdTopToast(e.this.mPageContext.getPageActivity(), 2000).yS(true).TQ(e.this.mPageContext.getPageActivity().getString(R.string.youngster_open_title)).aR((ViewGroup) e.this.mPageContext.getPageActivity().findViewById(R.id.maintabContainer));
                    e.this.sa(true);
                    return;
                case 3:
                    new BdTopToast(e.this.mPageContext.getPageActivity(), 2000).yS(true).TQ(e.this.mPageContext.getPageActivity().getString(R.string.youngster_close_title)).aR((ViewGroup) e.this.mPageContext.getPageActivity().findViewById(R.id.maintabContainer));
                    e.this.sa(false);
                    return;
                case 4:
                default:
                    if (com.baidu.tbadk.youngster.b.c.bIM()) {
                        e.this.sa(true);
                        return;
                    }
                    return;
                case 5:
                    new BdTopToast(e.this.mPageContext.getPageActivity(), 2000).yS(true).TQ(e.this.mPageContext.getPageActivity().getString(R.string.youngster_reset_title)).aR((ViewGroup) e.this.mPageContext.getPageActivity().findViewById(R.id.maintabContainer));
                    e.this.sa(true);
                    return;
            }
        }
    };
    private CustomMessageListener jxK = new CustomMessageListener(CmdConfigCustom.PB_ACTION_PRAISE) { // from class: com.baidu.tieba.homepage.personalize.e.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            bz bzVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bz) && e.this.kas != null && com.baidu.tbadk.core.util.x.getCount(e.this.kas.thread_list) != 0 && (bzVar = (bz) customResponsedMessage.getData()) != null && bzVar.bni() != null && bzVar.getId() != null && com.baidu.tbadk.core.util.x.getCount(e.this.kas.thread_list) != 0) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < e.this.kas.thread_list.size()) {
                        ThreadInfo threadInfo = e.this.kas.thread_list.get(i2);
                        if (threadInfo == null || threadInfo.id.longValue() != com.baidu.adp.lib.f.b.toLong(bzVar.getId(), -1L)) {
                            i = i2 + 1;
                        } else {
                            ThreadInfo.Builder builder = new ThreadInfo.Builder(threadInfo);
                            Zan.Builder builder2 = new Zan.Builder(builder.zan);
                            builder2.num = Integer.valueOf((int) bzVar.bni().getNum());
                            builder.zan = builder2.build(true);
                            e.this.kas.thread_list.set(i2, builder.build(true));
                            return;
                        }
                    } else {
                        return;
                    }
                }
            }
        }
    };
    private CustomMessageListener kaM = new CustomMessageListener(CmdConfigCustom.CMD_LIVE_VIDEO_CLOSED_QUERY_RESPONSED) { // from class: com.baidu.tieba.homepage.personalize.e.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            bz bzVar;
            if (customResponsedMessage.getOrginalMessage() instanceof LiveRoomClosedQueryMessage) {
                List<Long> ids = ((LiveRoomClosedQueryMessage) customResponsedMessage.getOrginalMessage()).getIds();
                List<Object> originData = ((LiveRoomClosedQueryMessage) customResponsedMessage.getOrginalMessage()).getOriginData();
                if (!com.baidu.tbadk.core.util.x.isEmpty(e.this.mDataList) && !com.baidu.tbadk.core.util.x.isEmpty(ids) && !com.baidu.tbadk.core.util.x.isEmpty(originData)) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= originData.size()) {
                            break;
                        }
                        if ((originData.get(i2) instanceof bz) && (bzVar = (bz) originData.get(i2)) != null && bzVar.bnQ() != null && ids.contains(Long.valueOf(bzVar.bnQ().live_id))) {
                            e.this.mDataList.remove(bzVar);
                        }
                        i = i2 + 1;
                    }
                    if (e.this.jZH != null) {
                        e.this.jZH.cC(new ArrayList(e.this.mDataList));
                    }
                }
            }
        }
    };
    private CustomMessageListener eYu = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.homepage.personalize.e.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int intValue;
            if ((customResponsedMessage instanceof UpdateAttentionMessage) && e.this.kas != null && !com.baidu.tbadk.core.util.x.isEmpty(e.this.kas.thread_list)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid)) {
                    int i = 0;
                    while (true) {
                        if (i >= e.this.kas.thread_list.size()) {
                            break;
                        }
                        ThreadInfo threadInfo = e.this.kas.thread_list.get(i);
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
                            e.this.kas.thread_list.set(i, builder.build(true));
                        }
                    }
                    e.this.a(updateAttentionMessage);
                }
            }
        }
    };
    private CustomMessageListener jSP = new CustomMessageListener(0) { // from class: com.baidu.tieba.homepage.personalize.e.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long) && e.this.kas != null && e.this.kas.hot_recomforum != null && !com.baidu.tbadk.core.util.x.isEmpty(e.this.kas.hot_recomforum.tab_list)) {
                long longValue = ((Long) customResponsedMessage.getData()).longValue();
                DiscoverHotForum.Builder builder = new DiscoverHotForum.Builder(e.this.kas.hot_recomforum);
                if (com.baidu.tieba.homepage.concern.c.a(builder, longValue, customResponsedMessage.getCmd() == 2001335)) {
                    e.this.kas.hot_recomforum = builder.build(true);
                    e.this.c(new DataRes.Builder(e.this.kas.build(true)));
                }
            }
        }
    };
    private String kaN = "lastReadReadPositionKey";
    private int kaO = 0;
    private d kaQ = new d() { // from class: com.baidu.tieba.homepage.personalize.e.16
        @Override // com.baidu.tieba.homepage.personalize.d
        public void Bm(final int i) {
            if (e.this.kaP == null) {
                e.this.kaP = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.e.16.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (e.this.jgC.getHandler() != null) {
                            e.this.jgC.requestFocusFromTouch();
                            if (i <= e.this.jgC.getCount() - 1) {
                                e.this.jgC.setSelection(i);
                            }
                        }
                    }
                };
            }
            e.this.jgC.removeCallbacks(e.this.kaP);
            e.this.jgC.post(e.this.kaP);
        }
    };
    private CustomMessageListener kaR = new CustomMessageListener(2016569) { // from class: com.baidu.tieba.homepage.personalize.e.19
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && e.this.kaA != null) {
                e.this.mDataList.remove(e.this.kaA);
                e.this.jZH.cC(new ArrayList(e.this.mDataList));
                com.baidu.tbadk.core.sharedPref.b.brx().putLong("key_maintab_banner_close_time", System.currentTimeMillis());
            }
        }
    };
    private CustomMessageListener iJp = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.homepage.personalize.e.20
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.g(customResponsedMessage);
            if (e.this.iJA != null && e.this.jYj) {
                e.this.iJA.b(e.this.jcJ, e.this.gwh, e.this.jdt, true);
            }
        }
    };
    private CustomMessageListener iJq = new CustomMessageListener(CmdConfigCustom.CMD_THREAD_NOT_EXIST_WHEN_ENTER_PB) { // from class: com.baidu.tieba.homepage.personalize.e.21
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.g(customResponsedMessage);
        }
    };
    private CustomMessageListener jjF = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.homepage.personalize.e.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && e.this.kas != null && com.baidu.tbadk.core.util.x.getCount(e.this.kas.thread_list) != 0) {
                String str = (String) customResponsedMessage.getData();
                e.this.h(str, e.this.mDataList);
                e.this.Lp(str);
                if (e.this.jZH != null) {
                    e.this.jZH.cC(new ArrayList(e.this.mDataList));
                }
                if (e.this.iJA != null && e.this.jYj) {
                    e.this.iJA.b(e.this.jcJ, e.this.gwh, e.this.jdt, true);
                }
            }
        }
    };
    private CustomMessageListener jcq = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.homepage.personalize.e.24
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ThreadCardViewHolder cOy;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent)) {
                KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24 && (cOy = e.this.cOy()) != null && cOy.tm() != null) {
                    cOy.tm().b(new a.C0089a(3));
                }
            }
        }
    };
    private com.baidu.adp.framework.listener.a kaS = new com.baidu.adp.framework.listener.a(1003065, CmdConfigSocket.CMD_TOPIC_BLESS) { // from class: com.baidu.tieba.homepage.personalize.e.25
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
                    for (n nVar : e.this.mDataList) {
                        if ((nVar instanceof com.baidu.tieba.homepage.topic.topictab.b.a) && (bVar = ((com.baidu.tieba.homepage.topic.topictab.b.a) nVar).khJ) != null && longValue == bVar.pkId) {
                            bVar.userPkId = j2;
                            return;
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener jcr = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.homepage.personalize.e.26
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            List<n> dataList = e.this.jZH.getDataList();
            if (!com.baidu.tbadk.core.util.x.isEmpty(dataList)) {
                for (n nVar : dataList) {
                    if (nVar instanceof k) {
                        k kVar = (k) nVar;
                        if (kVar.eNX != 0 && kVar.eHK != null) {
                            int[] imageWidthAndHeight = kVar.eHK.getImageWidthAndHeight();
                            kVar.eNX = imageWidthAndHeight[0];
                            kVar.eNY = imageWidthAndHeight[1];
                        }
                    }
                }
            }
            com.baidu.adp.lib.f.e.mB().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.personalize.e.26.1
                @Override // java.lang.Runnable
                public void run() {
                    e.this.jZH.notifyDataSetChanged();
                    if (!e.this.mIsBackground && e.this.jYj) {
                        e.this.iJA.b(e.this.jcJ, e.this.gwh, e.this.jdt, true);
                    }
                }
            }, 500L);
        }
    };
    private CustomMessageListener iJr = new CustomMessageListener(2921453) { // from class: com.baidu.tieba.homepage.personalize.e.27
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bh)) {
                bh bhVar = (bh) customResponsedMessage.getData();
                if (bhVar.eMT == 1) {
                    int equipmentWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst());
                    int equipmentHeight = l.getEquipmentHeight(TbadkCoreApplication.getInst());
                    float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
                    int i = au.bsy().bsz() ? 2 : 1;
                    RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
                    requestGetMyPostNetMessage.setTag(e.this.kaG);
                    requestGetMyPostNetMessage.setParams(com.baidu.adp.lib.f.b.toLong(bhVar.tid, 0L), 0L, 0L, equipmentWidth, equipmentHeight, f, i);
                    requestGetMyPostNetMessage.setBFrom("push");
                    MessageManager.getInstance().sendMessage(requestGetMyPostNetMessage);
                }
            }
        }
    };
    private final com.baidu.adp.framework.listener.a iJs = new com.baidu.adp.framework.listener.a(1003010, CmdConfigSocket.CMD_GET_MY_POST) { // from class: com.baidu.tieba.homepage.personalize.e.28
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            GetMyPostResIdl getMyPostResIdl = null;
            if (responsedMessage instanceof GetMyPostHttpResponseMessage) {
                getMyPostResIdl = ((GetMyPostHttpResponseMessage) responsedMessage).getResponseData();
            } else if (responsedMessage instanceof GetMyPostSocketResponseMessage) {
                getMyPostResIdl = ((GetMyPostSocketResponseMessage) responsedMessage).getResponseData();
            }
            if (getMyPostResIdl != null && getMyPostResIdl.data != null && getMyPostResIdl.data.thread_info != null) {
                e.this.kaH = getMyPostResIdl.data.thread_info;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921455));
            }
        }
    };
    private CustomMessageListener kaT = new CustomMessageListener(2921482) { // from class: com.baidu.tieba.homepage.personalize.e.29
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (com.baidu.tbadk.coreExtra.c.a.G(TbadkCoreApplication.getInst(), 1)) {
                com.baidu.tbadk.coreExtra.c.a.a(e.this.mPageContext, 7, 0L);
            }
        }
    };

    /* loaded from: classes2.dex */
    public interface a {
        void I(int i, int i2, int i3, int i4);

        void V(int i, int i2, int i3);

        void cPb();

        void onError(int i, String str);

        void rW(boolean z);
    }

    public void rX(boolean z) {
        this.kaB = z;
        if (this.iJv != null && !z) {
            this.iJv.hideTip();
        }
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.jZv = scrollFragmentTabHost;
        if (this.jZv != null) {
            this.jZv.setOnTabSelectedListener(new ScrollFragmentTabHost.b() { // from class: com.baidu.tieba.homepage.personalize.e.1
                @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.b
                public void Bw(int i) {
                    if (e.this.jZv.Bv(i) != 1 && e.this.iJv != null) {
                        e.this.iJv.hideTip();
                    }
                }
            });
        }
    }

    public void setTabInForeBackgroundState(boolean z) {
        this.mIsBackground = z;
    }

    public void qz(boolean z) {
        boolean z2 = false;
        this.mIsBackground = z;
        if (this.jZv != null) {
            this.jZv.qz(z);
        }
        if (this.iJA != null) {
            this.iJA.tA(!z);
            ThreadCardViewHolder cOy = cOy();
            if (cOy != null && cOy.tm() != null) {
                z2 = cOy.tm().b(new a.C0089a(8, Boolean.valueOf(z)));
            }
            if (!z2) {
                if (z) {
                    this.iJA.cOx();
                } else if (this.jYj) {
                    this.iJA.b(this.jcJ, this.gwh, this.jdt, true);
                }
            }
        }
    }

    public e(TbPageContext<?> tbPageContext, BdTypeRecyclerView bdTypeRecyclerView, ab abVar, BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout) {
        this.kaF = 0;
        this.mPageContext = tbPageContext;
        this.kaF = com.baidu.tbadk.core.sharedPref.b.brx().getInt("key_personalized_refresh_type", 0);
        this.jSy = bigdaySwipeRefreshLayout;
        this.jgC = bdTypeRecyclerView;
        this.jgC.setOnTouchListener(this.bPd);
        if (com.baidu.tbadk.youngster.b.c.bIM()) {
            sa(true);
        }
        this.jFc = new com.baidu.tieba.f.a();
        this.jFc.a(this.izu);
        this.jZH = abVar;
        this.kav = new com.baidu.tieba.homepage.personalize.model.a();
        this.kap = com.baidu.tbadk.core.sharedPref.b.brx().getLong("recommend_frs_cache_time", 1800L) * 1000;
        bdTypeRecyclerView.setOnScrollListener(this.mOnScrollListener);
        this.iJv = new bb();
        cPm();
        this.iJA = new i(this.mPageContext, this.jgC);
        this.iJA.GW(1);
        this.iJA.GV(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.kaq = new b(this.mDataList, this.jZH);
        this.iJw = new SmartBubbleAnimatedView(tbPageContext.getContext());
        this.iJw.setLayoutParams(new FrameLayout.LayoutParams(-1, l.getDimens(tbPageContext.getContext(), R.dimen.tbds83)));
        cPc();
        this.jcr.setTag(this.mPageContext.getUniqueId());
        MessageManager.getInstance().registerListener(this.jcr);
        if (MessageManager.getInstance().findTask(1003010) == null) {
            HomePageStatic.cMG();
        }
        this.iJs.setTag(this.kaG);
        if (this.iJs.getHttpMessageListener() != null) {
            this.iJs.getHttpMessageListener().setSelfListener(true);
        }
        if (this.iJs.getSocketMessageListener() != null) {
            this.iJs.getSocketMessageListener().setSelfListener(true);
        }
        MessageManager.getInstance().registerListener(this.iJs);
        MessageManager.getInstance().registerListener(this.iJr);
        MessageManager.getInstance().registerListener(this.kaT);
    }

    private void cPc() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2016323, new CustomMessageTask.CustomRunnable<Boolean>() { // from class: com.baidu.tieba.homepage.personalize.e.35
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Boolean> customMessage) {
                ThreadCardViewHolder cOy = e.this.cOy();
                return (cOy == null || cOy.tm() == null) ? new CustomResponsedMessage<>(2016323, false) : new CustomResponsedMessage<>(2016323, Boolean.valueOf(cOy.tm().b(new a.C0089a(6))));
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private boolean cPd() {
        return com.baidu.tbadk.core.sharedPref.b.brx().getBoolean(cPf(), true);
    }

    private void cPe() {
        com.baidu.tbadk.core.sharedPref.b.brx().putBoolean(cPf(), false);
    }

    private String cPf() {
        return "key_rec_pfirst_load_" + TbadkCoreApplication.getCurrentAccount() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + TbConfig.getVersion();
    }

    public void setRecommendFrsNavigationAnimDispatcher(y yVar) {
        if (yVar != null) {
            this.fKY = yVar.bFm();
            this.fwq = yVar.bFn();
        }
    }

    public void showFloatingView() {
        if (this.fKY != null) {
            this.fKY.kZ(true);
        }
    }

    public void update() {
        com.baidu.tieba.homepage.framework.a.cNr().G(System.currentTimeMillis(), 1);
        this.mPn = 1;
        this.kaz = true;
        if (this.mDataList.size() == 0 && !cPd()) {
            if (!this.jSJ) {
                bkL();
                return;
            }
            return;
        }
        bkK();
    }

    public void cG(int i, int i2) {
        bz bzVar;
        if (!com.baidu.tbadk.core.util.x.isEmpty(this.mDataList) && this.mDataList.size() > i) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            while (i < this.mDataList.size() && i <= i2) {
                if (this.mDataList.get(i).getType().getId() == bz.eOz.getId() && (bzVar = (bz) this.mDataList.get(i)) != null && bzVar.bnQ() != null) {
                    arrayList.add(Long.valueOf(bzVar.bnQ().live_id));
                    arrayList2.add(bzVar);
                }
                i++;
            }
            if (!com.baidu.tbadk.core.util.x.isEmpty(arrayList)) {
                MessageManager.getInstance().sendMessage(new LiveRoomClosedQueryMessage(arrayList, arrayList2));
            }
        }
    }

    public void cPg() {
        if (this.iJA != null && !this.mIsBackground && this.jYj) {
            this.iJA.b(this.jcJ, this.gwh, this.jdt, true);
        }
        if (this.kax) {
            if (this.jSy != null && !this.jSy.bua()) {
                if (this.jQd) {
                    com.baidu.tieba.s.c.dKg().b(this.kaD, false);
                    if (rZ(false)) {
                        cH(3, this.kau);
                    } else if (this.kay > 0) {
                        cH(2, this.kau);
                    }
                } else if (!this.jQd && this.kau == 0) {
                    cH(2, 0);
                }
            }
            this.kax = false;
            this.jQd = false;
            this.kay = 0;
            if (this.kaz) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
            }
            this.kaz = false;
        }
    }

    public void bQy() {
        if (isLoading()) {
            com.baidu.tieba.homepage.framework.a.cNr().G(0L, 1);
        } else if (this.kar != null) {
            cPi();
            this.mPn++;
            setIsLoading(true);
            this.kar.I(this.mPn, (this.kas == null || this.kas.thread_list == null) ? 0 : this.kas.thread_list.size(), rY(false), 0);
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
            g.cPt();
        }
        if (this.kav != null && this.kav.cPM() && !z && (dataRes == null || com.baidu.tbadk.core.util.x.isEmpty(dataRes.thread_list))) {
            if (dataRes == null) {
                DataRes.Builder builder = new DataRes.Builder();
                builder.thread_list = new ArrayList();
                dataRes = builder.build(false);
            }
            if (dataRes.thread_list != null) {
                List<ThreadInfo> cPN = this.kav.cPN();
                dataRes.thread_list.addAll(cPN);
                if (cPN != null) {
                    cPN.clear();
                }
                z3 = true;
                size = (this.kas != null || this.kas.thread_list == null) ? 0 : this.kas.thread_list.size();
                if (z && i == 0 && dataRes != null && com.baidu.tbadk.core.util.x.isEmpty(dataRes.thread_list)) {
                    if (this.kar != null) {
                        this.kar.cPb();
                    }
                    setIsLoading(false);
                    if (this.jSy != null) {
                        this.jSy.setRefreshing(false);
                        return;
                    }
                    return;
                }
                if (this.kaH != null) {
                    DataRes.Builder builder2 = new DataRes.Builder(dataRes);
                    builder2.thread_list.add(0, this.kaH);
                    dataRes = builder2.build(false);
                    if (this.kas != null && !com.baidu.tbadk.core.util.x.isEmpty(this.kas.thread_list)) {
                        Iterator<ThreadInfo> it = this.kas.thread_list.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            ThreadInfo next = it.next();
                            if (next != null && next.tid != null && this.kaH.tid != null && next.tid.longValue() == this.kaH.tid.longValue()) {
                                this.kas.thread_list.remove(next);
                                break;
                            }
                        }
                    }
                    this.kaH = null;
                }
                if ((z3 && i != 0) || dataRes == null || !a(true, z, z2, dataRes)) {
                    this.kax = false;
                    if (this.mDataList.size() > 0) {
                        if (this.kar != null) {
                            this.kar.onError(1, str);
                        }
                    } else if (this.kar != null) {
                        this.kar.onError(2, str);
                    }
                } else {
                    cPe();
                    if (this.kar != null) {
                        com.baidu.tbadk.core.sharedPref.b.brx().putLong(SharedPrefConfig.RECOMMEND_FRS_REFRESH_TIME + TbadkCoreApplication.getCurrentAccount(), System.currentTimeMillis());
                        this.kar.rW(false);
                    }
                    this.kax = true;
                    this.jQd = z;
                    this.kay = size;
                    cut();
                }
                setIsLoading(false);
                if (this.jSy == null) {
                    f.e cPh = cPh();
                    if (this.jSy.bua() && cPh != null) {
                        this.jSy.c(cPh);
                        return;
                    } else {
                        this.jSy.setRefreshing(false);
                        return;
                    }
                }
                return;
            }
        }
        z3 = false;
        if (this.kas != null) {
        }
        if (z) {
        }
        if (this.kaH != null) {
        }
        if (z3) {
        }
        cPe();
        if (this.kar != null) {
        }
        this.kax = true;
        this.jQd = z;
        this.kay = size;
        cut();
        setIsLoading(false);
        if (this.jSy == null) {
        }
    }

    private f.e cPh() {
        int i;
        String feedText;
        if (!this.kax || this.jSy == null || !this.jSy.bua() || cPl()) {
            return null;
        }
        int i2 = this.kau;
        if (this.jQd) {
            com.baidu.tieba.s.c.dKg().b(this.kaD, false);
            if (rZ(false)) {
                i = 3;
            } else {
                i = this.kay > 0 ? 2 : 0;
            }
        } else if (this.jQd || this.kau != 0) {
            return null;
        } else {
            i2 = 0;
            i = 2;
        }
        if (this.jZv != null) {
            this.iJv.cDE();
        }
        if (this.jZv != null && this.jZv.getCurrentTabType() != 1) {
            this.iJv.hideTip();
            return null;
        } else if (!this.kaB) {
            this.iJv.hideTip();
            return null;
        } else {
            this.kat = i;
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
                this.jfI = 1000;
            } else {
                this.jfI = 0;
            }
            return new f.e(feedText, this.jfI);
        }
    }

    public void rJ(boolean z) {
        if (z) {
            this.jZH.notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        if (this.iJA != null) {
            this.iJA.destroy();
        }
        if (this.iJv != null) {
            this.iJv.onDestroy();
        }
        if (this.kaq != null) {
            this.kaq.onDestroy();
        }
        if (this.jgC != null) {
            this.jgC.removeCallbacks(this.kaP);
        }
        MessageManager.getInstance().unRegisterTask(2016323);
        MessageManager.getInstance().unRegisterListener(this.jcr);
        MessageManager.getInstance().unRegisterListener(this.iJr);
        MessageManager.getInstance().unRegisterListener(this.iJs);
        MessageManager.getInstance().unRegisterListener(this.kaT);
    }

    public void onPause() {
        c.i(this.jgC);
        BE(this.kaO);
        if (this.kaw != null) {
            this.kaw.bDI();
        }
    }

    private void bkK() {
        if (this.kar != null) {
            this.kar.V((this.kas == null || this.kas.thread_list == null || cPk()) ? 0 : this.kas.thread_list.size(), rY(true), 0);
        }
    }

    public int rY(boolean z) {
        int i;
        int i2;
        if (this.mDataList == null || this.mDataList.size() == 0) {
            return 0;
        }
        if (z) {
            int i3 = 0;
            int i4 = -1;
            int i5 = 0;
            while (i3 < this.mDataList.size()) {
                n nVar = this.mDataList.get(i3);
                if (!(nVar instanceof com.baidu.tieba.card.data.b) || (i2 = ((com.baidu.tieba.card.data.b) nVar).position) == i4) {
                    i2 = i4;
                } else {
                    i5++;
                }
                if (!(nVar instanceof com.baidu.tieba.homepage.personalize.data.a) || nVar.getType() == AdvertAppInfo.eIU) {
                    i3++;
                    i4 = i2;
                } else {
                    return i5;
                }
            }
        } else {
            int size = this.mDataList.size() - 1;
            int i6 = -1;
            int i7 = 0;
            while (size >= 0) {
                n nVar2 = this.mDataList.get(size);
                if (!(nVar2 instanceof com.baidu.tieba.card.data.b) || (i = ((com.baidu.tieba.card.data.b) nVar2).position) == i6) {
                    i = i6;
                } else {
                    i7++;
                }
                if ((nVar2 instanceof com.baidu.tieba.homepage.personalize.data.a) && nVar2.getType() != AdvertAppInfo.eIU) {
                    return i7;
                }
                size--;
                i6 = i;
            }
        }
        return this.mDataList.size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(DataRes dataRes) {
        this.jSJ = true;
        if (dataRes != null) {
            if (a(false, true, true, dataRes) && !cPk()) {
                if (this.kar != null) {
                    this.kar.rW(true);
                    Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler() { // from class: com.baidu.tieba.homepage.personalize.e.2
                        @Override // android.os.MessageQueue.IdleHandler
                        public boolean queueIdle() {
                            e.this.bDL();
                            return false;
                        }
                    });
                }
                if (TbSingleton.getInstance().getForceRefreshHomeRecommend()) {
                    bkK();
                    TbSingleton.getInstance().setForceRefreshHomeRecommend(false);
                    return;
                }
                return;
            }
            bkK();
            return;
        }
        bkK();
    }

    public void bDL() {
        com.baidu.tbadk.n.l.bDT().ev(System.currentTimeMillis() - com.baidu.tbadk.n.l.bDT().bDS());
    }

    private void i(List<n> list, int i) {
        Set<n> a2 = com.baidu.tieba.recapp.a.a(list, this.mPn, "NEWINDEX");
        if (a2.size() > 0) {
            com.baidu.tieba.s.c.dKg().b(this.kaD, com.baidu.tieba.s.a.b(PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE, "common_fill", true, a2.size()));
        }
    }

    private boolean a(boolean z, boolean z2, boolean z3, DataRes dataRes) {
        boolean z4;
        if (dataRes == null) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.kaF == 1) {
            if (z2 && (dataRes.thread_list.size() >= 6 || cPk())) {
                cPj();
                this.kas = null;
            }
        } else if (z2 && cPk()) {
            this.kas = null;
        }
        int size = z2 ? 0 : this.mDataList.size();
        DataRes.Builder builder = new DataRes.Builder(dataRes);
        this.mDataList.clear();
        com.baidu.tieba.homepage.personalize.model.c a2 = this.kav.a(z, this.kas, builder, z2 ? 0 : 1);
        List<n> list = null;
        int i = 0;
        if (a2 != null) {
            list = a2.gaa;
            this.kau = a2.kdA;
            i = a2.kdB;
            a2.kdB = 0;
        }
        int i2 = i;
        if (list != null) {
            this.mDataList.addAll(list);
            i(list, size);
            a(z2 ? 0 : 1, list, size);
            if (this.kaz) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
            }
        }
        if (this.kas == null) {
            this.kas = builder;
            this.kaq.ed(this.kas.thread_list);
        }
        if (this.mDataList.size() == 0) {
            z4 = false;
        } else {
            if (z2) {
                if (dataRes.live_answer != null) {
                    this.kaA = new h();
                    this.kaA.a(dataRes.live_answer);
                    this.kas.live_answer = dataRes.live_answer;
                } else if (z) {
                    this.kaA = null;
                    this.kas.live_answer = null;
                }
                this.kaC = dataRes.float_info;
                this.kas.float_info = dataRes.float_info;
            }
            long j = com.baidu.tbadk.core.sharedPref.b.brx().getLong("key_maintab_banner_close_time", 0L);
            if (this.kaA != null && !at.isTaday(j)) {
                this.mDataList.add(0, this.kaA);
            }
            LinkedList linkedList = new LinkedList(this.mDataList);
            this.jZH.setFromCDN(dataRes.is_new_url != null && dataRes.is_new_url.intValue() == 1);
            this.jZH.j(linkedList, i2);
            z4 = true;
            if (this.iJA != null && this.jYj) {
                this.iJA.b(this.jcJ, this.gwh, this.jdt, true);
            }
        }
        com.baidu.tieba.homepage.framework.a.cNr().E(System.currentTimeMillis() - currentTimeMillis, 1);
        long Bl = com.baidu.tieba.homepage.framework.a.cNr().Bl(1);
        if (Bl > 0) {
            com.baidu.tieba.homepage.framework.a.cNr().F(System.currentTimeMillis() - Bl, 1);
            com.baidu.tieba.homepage.framework.a.cNr().G(0L, 1);
        }
        if (dataRes.anti != null && dataRes.anti.block_pop_info != null) {
            com.baidu.tieba.ueg.d.d(dataRes.anti.block_pop_info);
        }
        bj bjVar = new bj();
        bjVar.a(dataRes.recom_post_topic);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_REFRESH_TOPIC_TIP, bjVar));
        if (!z && Bl > 0) {
            com.baidu.tbadk.n.l.bDT().eH(System.currentTimeMillis() - Bl);
            return z4;
        }
        return z4;
    }

    private void cPi() {
        int i;
        List<n> list = null;
        if (com.baidu.tbadk.core.util.x.getCount(this.mDataList) >= this.kav.cPI() - 40) {
            com.baidu.tieba.homepage.personalize.model.c a2 = this.kav.a(true, this.kas, null, 1);
            if (a2 != null) {
                list = a2.gaa;
                i = a2.kdB;
                a2.kdB = 0;
            } else {
                i = 0;
            }
            if (list != null) {
                this.mDataList.clear();
                this.mDataList.addAll(list);
                this.jZH.j(new LinkedList(this.mDataList), i);
            }
        }
    }

    private void bkL() {
        this.jSJ = true;
        ac.a(new com.baidu.tbadk.util.ab<DataRes>() { // from class: com.baidu.tieba.homepage.personalize.e.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.ab
            /* renamed from: cPp */
            public DataRes doInBackground() {
                com.baidu.adp.lib.cache.l<byte[]> dK = com.baidu.tbadk.core.c.a.bpZ().dK("tb.rec_frs_update", TbadkCoreApplication.getCurrentAccount());
                if (dK == null) {
                    return null;
                }
                byte[] bArr = dK.get("0");
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
        }, new com.baidu.tbadk.util.l<DataRes>() { // from class: com.baidu.tieba.homepage.personalize.e.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.l
            /* renamed from: b */
            public void onReturnDataInUI(DataRes dataRes) {
                e.this.a(dataRes);
            }
        });
    }

    private void cut() {
        if (this.kas != null) {
            DataRes.Builder builder = new DataRes.Builder(this.kas.build(true));
            if (builder.thread_list != null && builder.thread_list.size() > 30) {
                builder.thread_list = builder.thread_list.subList(0, 30);
            }
            a(builder, builder.thread_list != null ? builder.thread_list.size() : 0);
            a(builder);
            b(builder);
            c(builder);
        }
    }

    private void cPj() {
        if (this.kas != null) {
            final DataRes.Builder builder = new DataRes.Builder(this.kas.build(true));
            if (builder.thread_list != null && builder.thread_list.size() > 50) {
                builder.thread_list = builder.thread_list.subList(0, 50);
            }
            a(builder, builder.thread_list != null ? builder.thread_list.size() : 0);
            ac.a(new com.baidu.tbadk.util.ab<Object>() { // from class: com.baidu.tieba.homepage.personalize.e.5
                @Override // com.baidu.tbadk.util.ab
                public Object doInBackground() {
                    DataRes.Builder builder2 = new DataRes.Builder(builder.build(true));
                    e.this.kaq.ee(builder2.thread_list);
                    try {
                        com.baidu.tbadk.core.c.a.bpZ().dK("tb.rec_old_data", TbadkCoreApplication.getCurrentAccount()).setForever("0", builder2.build(true).toByteArray());
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
    public void Lp(String str) {
        if (!TextUtils.isEmpty(str) && this.kas != null && this.kas.banner_list != null && this.kas.banner_list.app != null && this.kas.banner_list.app.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (App app : this.kas.banner_list.app) {
                if (app != null && str.equals(app.id)) {
                    arrayList.add(app);
                }
            }
            BannerList.Builder builder = new BannerList.Builder(this.kas.banner_list);
            if (builder.app != null) {
                builder.app.removeAll(arrayList);
            }
            this.kas.banner_list = builder.build(false);
            DataRes.Builder builder2 = new DataRes.Builder(this.kas.build(true));
            builder2.banner_list = builder.build(true);
            c(builder2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final DataRes.Builder builder) {
        ac.a(new com.baidu.tbadk.util.ab<Object>() { // from class: com.baidu.tieba.homepage.personalize.e.6
            @Override // com.baidu.tbadk.util.ab
            public Object doInBackground() {
                DataRes.Builder builder2 = new DataRes.Builder(builder.build(true));
                e.this.kaq.ee(builder2.thread_list);
                try {
                    com.baidu.tbadk.core.c.a.bpZ().dK("tb.rec_frs_update", TbadkCoreApplication.getCurrentAccount()).setForever("0", builder2.build(true).toByteArray());
                    return null;
                } catch (Exception e) {
                    BdLog.e(e);
                    return null;
                }
            }
        }, null);
    }

    private boolean cPk() {
        return rZ(true);
    }

    private boolean rZ(boolean z) {
        long j = com.baidu.tbadk.core.sharedPref.b.brx().getLong(SharedPrefConfig.RECOMMEND_FRS_REFRESH_TIME + TbadkCoreApplication.getCurrentAccount(), 0L);
        return j == 0 ? z : Math.abs(System.currentTimeMillis() - j) > this.kap;
    }

    public void a(a aVar) {
        this.kar = aVar;
    }

    private boolean isLoading() {
        return this.mIsLoading;
    }

    private void setIsLoading(boolean z) {
        this.mIsLoading = z;
    }

    public void cOW() {
        boolean z = true;
        com.baidu.tbadk.coreExtra.data.b activityPrizeData = TbadkCoreApplication.getInst().getActivityPrizeData();
        if (activityPrizeData.isSwitchTurn() && !StringUtils.isNull(activityPrizeData.getFeedText())) {
            String currentDay = UtilHelper.getCurrentDay();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            String str = "";
            if (!StringUtils.isNull(currentAccount)) {
                String string = com.baidu.tbadk.core.sharedPref.b.brx().getString(SharedPrefConfig.ACTIVITY_PRIZE_FEED_TEXT_TIME, "");
                if (!StringUtils.isNull(string)) {
                    String[] split = string.split("@");
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
                                    sb.append(currentDay).append("@");
                                    for (String str3 : asList) {
                                        sb.append(str3).append(",");
                                    }
                                    str = sb.append(currentAccount).toString();
                                }
                            } else {
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append(currentDay).append("@");
                                sb2.append(currentAccount);
                                str = sb2.toString();
                            }
                        } else {
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append(currentDay).append("@");
                            sb3.append(currentAccount);
                            str = sb3.toString();
                        }
                    } else {
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append(currentDay).append("@");
                        sb4.append(currentAccount);
                        str = sb4.toString();
                    }
                } else {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(currentDay).append("@");
                    sb5.append(currentAccount);
                    str = sb5.toString();
                }
                if (z) {
                    cH(4, 0);
                    com.baidu.tbadk.core.sharedPref.b.brx().putString(SharedPrefConfig.ACTIVITY_PRIZE_FEED_TEXT_TIME, str);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sa(boolean z) {
        boolean z2 = com.baidu.tbadk.core.sharedPref.b.brx().getBoolean("key_youngster_homgpage_top_view_closed", false);
        if (this.jgC != null && !z2) {
            if (z) {
                if (this.kaE == null) {
                    this.kaE = new HomePageYoungsterTopView(this.mPageContext);
                    this.kaE.setOnDeleteClick(new HomePageYoungsterTopView.a() { // from class: com.baidu.tieba.homepage.personalize.e.7
                        @Override // com.baidu.tieba.homepage.personalize.view.HomePageYoungsterTopView.a
                        public void cPq() {
                            new BdTopToast(e.this.mPageContext.getPageActivity(), 2000).yS(true).TQ(e.this.mPageContext.getPageActivity().getString(R.string.youngster_frs_top_toast)).aR((ViewGroup) e.this.mPageContext.getPageActivity().findViewById(R.id.maintabContainer));
                            e.this.sa(false);
                            com.baidu.tbadk.core.sharedPref.b.brx().putBoolean("key_youngster_homgpage_top_view_closed", true);
                        }
                    });
                }
                this.jgC.setHeaderView(this.kaE, false);
                this.kaE.setVisibility(0);
                this.jgC.scrollToPosition(0);
            } else if (this.kaE != null) {
                this.kaE.setVisibility(8);
                this.jgC.removeHeaderView(this.kaE);
                this.kaE = null;
            }
        }
    }

    private boolean cPl() {
        return this.kaE != null && this.kaE.getVisibility() == 0;
    }

    private void cH(int i, int i2) {
        if (!cPl()) {
            if (this.jZv != null) {
                this.iJv.cDE();
            }
            if (this.jZv != null && this.jZv.getCurrentTabType() != 1) {
                this.iJv.hideTip();
            } else if (!this.kaB) {
                this.iJv.hideTip();
            } else {
                this.kat = i;
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
                        this.jfI = 3000;
                    } else {
                        this.jfI = 2000;
                    }
                    this.iJw.fht = str;
                    this.iJw.jfB = this.jfI;
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 49;
                    if (this.jZv != null) {
                        FrameLayout frameLayout = this.jZv.getFrameLayout();
                        frameLayout.removeView(this.iJw);
                        frameLayout.addView(this.iJw, layoutParams);
                        this.iJw.cDC();
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(Long l) {
        if (this.kas != null && this.kas.thread_list != null) {
            List<ThreadInfo> list = this.kas.thread_list;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                ThreadInfo threadInfo = list.get(i);
                if (threadInfo.tid.equals(l) && threadInfo.top_agree_post != null) {
                    ThreadInfo.Builder builder = new ThreadInfo.Builder(threadInfo);
                    builder.top_agree_post = null;
                    list.set(i, builder.build(true));
                    cut();
                    a(false, true, false, this.kas.build(true));
                    return;
                }
            }
        }
    }

    public void o(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.kaD = bdUniqueId;
            if (this.jxK != null) {
                this.jxK.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.jxK);
            }
            if (this.kaJ != null) {
                this.kaJ.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.kaJ);
            }
            this.kaK.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.kaK);
            this.eYu.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.eYu);
            this.jSP.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_LIKE_FORUM, this.jSP);
            MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_UNLIKE_FORUM, this.jSP);
            this.kaM.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.kaM);
            this.iJp.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.iJp);
            this.iJq.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.iJq);
            this.jjF.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.jjF);
            if (this.iJA != null) {
                this.iJA.setUniqueId(bdUniqueId);
            }
            this.kaq.l(bdUniqueId);
            this.kaR.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.kaR);
            this.jcq.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.jcq);
            this.kaS.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.kaS);
            this.kaL.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.kaL);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(UpdateAttentionMessage updateAttentionMessage) {
        if (updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid)) {
            final String str = updateAttentionMessage.getData().toUid;
            final boolean z = updateAttentionMessage.getData().isAttention;
            ac.a(new com.baidu.tbadk.util.ab<Boolean>() { // from class: com.baidu.tieba.homepage.personalize.e.13
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.baidu.tbadk.util.ab
                public Boolean doInBackground() {
                    int intValue;
                    try {
                        com.baidu.adp.lib.cache.l<byte[]> dK = com.baidu.tbadk.core.c.a.bpZ().dK("tb.rec_frs_update", TbadkCoreApplication.getCurrentAccount());
                        if (dK == null) {
                            return false;
                        }
                        byte[] bArr = dK.get("0");
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
                        e.this.kaq.ee(builder5.thread_list);
                        dK.setForever("0", builder5.build(true).toByteArray());
                        return true;
                    } catch (Exception e) {
                        BdLog.e(e);
                        return false;
                    }
                }
            }, new com.baidu.tbadk.util.l<Boolean>() { // from class: com.baidu.tieba.homepage.personalize.e.14
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.l
                public void onReturnDataInUI(Boolean bool) {
                }
            });
        }
    }

    public void cPm() {
        this.jax = new com.baidu.tieba.tbadkCore.data.f("new_index", null);
        this.jax.dKP();
    }

    public void a(int i, List<n> list, int i2) {
        int i3;
        int i4;
        if (this.jax != null) {
            if (i == 0) {
                this.jax.dKP();
            }
            if (list != null && !list.isEmpty()) {
                int[] iArr = com.baidu.tieba.tbadkCore.data.f.nmk;
                int i5 = 0;
                int i6 = 0;
                int i7 = 0;
                while (i7 < list.size() && i6 < iArr.length && (i3 = iArr[i6]) >= 0) {
                    if (list.get(i7) instanceof com.baidu.tieba.card.data.b) {
                        i4 = i5 + 1;
                        if (i4 == i3 - 1) {
                            if (i2 < i7 + 1) {
                                this.jax.du(i3, i7 + 1);
                            }
                            i6++;
                        }
                    } else {
                        i4 = i5;
                    }
                    i7++;
                    i5 = i4;
                }
            }
        }
    }

    public void BD(int i) {
        if ((this.jax != null ? this.jax.Jh(i) : -1) >= 0 && this.jgC != null && this.jgC.getData() != null && this.jgC.getData().size() > i) {
            this.jax.Ji(i);
        }
    }

    public i cCm() {
        return this.iJA;
    }

    public void rS(boolean z) {
        this.jYj = z;
    }

    public void BE(final int i) {
        ac.a(new com.baidu.tbadk.util.ab<Object>() { // from class: com.baidu.tieba.homepage.personalize.e.15
            @Override // com.baidu.tbadk.util.ab
            public Object doInBackground() {
                com.baidu.adp.lib.cache.l<String> dL = com.baidu.tbadk.core.c.a.bpZ().dL(e.this.kaN, TbadkCoreApplication.getCurrentAccount());
                if (dL != null) {
                    dL.set(e.this.kaN, Integer.toString(i), 43200000L);
                    return null;
                }
                return null;
            }
        }, null);
    }

    public void a(final d dVar) {
        ac.a(new com.baidu.tbadk.util.ab<String>() { // from class: com.baidu.tieba.homepage.personalize.e.17
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.ab
            /* renamed from: cPr */
            public String doInBackground() {
                com.baidu.adp.lib.cache.l<String> dL = com.baidu.tbadk.core.c.a.bpZ().dL(e.this.kaN, TbadkCoreApplication.getCurrentAccount());
                if (dL != null) {
                    return dL.get(e.this.kaN);
                }
                return null;
            }
        }, new com.baidu.tbadk.util.l<String>() { // from class: com.baidu.tieba.homepage.personalize.e.18
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.l
            /* renamed from: Lq */
            public void onReturnDataInUI(String str) {
                if (dVar != null) {
                    dVar.Bm(com.baidu.adp.lib.f.b.toInt(str, 0));
                }
            }
        });
    }

    public void cOZ() {
        c.j(this.jgC);
    }

    public void cPn() {
        a(this.kaQ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cPo() {
        Iterator<n> it = this.mDataList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            } else if (it.next() instanceof com.baidu.tieba.homepage.personalize.data.g) {
                it.remove();
                break;
            }
        }
        if (this.kas != null) {
            this.kas.active_center = null;
            cut();
            if (this.jgC != null) {
                List<Integer> k = k(this.jgC);
                int intValue = k.get(0).intValue();
                int intValue2 = k.get(1).intValue();
                if (intValue != -1 && intValue2 != -1) {
                    this.jgC.p(intValue, intValue2);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(CustomResponsedMessage<?> customResponsedMessage) {
        boolean z;
        String str;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.kas != null && com.baidu.tbadk.core.util.x.getCount(this.kas.thread_list) != 0 && com.baidu.tbadk.core.util.x.getCount(this.mDataList) != 0) {
            JSONObject jSONObject = (JSONObject) customResponsedMessage.getData();
            String optString = jSONObject.optString("tid");
            if (StringUtils.isNull(optString)) {
                String optString2 = jSONObject.optString(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_ID);
                if (this.jgC != null && !TextUtils.isEmpty(optString2)) {
                    int i = 0;
                    while (true) {
                        if (i >= this.jgC.getCount()) {
                            str = optString;
                            break;
                        }
                        n item = this.jgC.getItem(i);
                        if (item instanceof com.baidu.tieba.card.data.j) {
                            com.baidu.tieba.card.data.j jVar = (com.baidu.tieba.card.data.j) item;
                            if (jVar.bkV() != null && jVar.bkV().bnQ() != null && optString2.equals(String.valueOf(jVar.bkV().bnQ().live_id))) {
                                str = jVar.bkV().getTid();
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
            Iterator<n> it = this.mDataList.iterator();
            boolean z2 = false;
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                n next = it.next();
                if (next instanceof com.baidu.tieba.card.data.b) {
                    com.baidu.tieba.card.data.b bVar = (com.baidu.tieba.card.data.b) next;
                    if (bVar.bkV() != null && bVar.bkV().getTid() != null) {
                        if (bVar.bkV().getTid().equals(optString)) {
                            it.remove();
                            z = true;
                            z2 = z;
                        } else if (z2) {
                            com.baidu.tieba.homepage.personalize.model.b.eg(this.mDataList);
                            break;
                        }
                    }
                }
                z = z2;
                z2 = z;
            }
            if (this.kas != null && this.kas.thread_list != null) {
                long j = com.baidu.adp.lib.f.b.toLong(optString, 0L);
                int i2 = 0;
                while (true) {
                    if (i2 < this.kas.thread_list.size()) {
                        ThreadInfo threadInfo = this.kas.thread_list.get(i2);
                        if (threadInfo == null || threadInfo.tid == null || threadInfo.tid.longValue() != j) {
                            i2++;
                        } else {
                            com.baidu.tieba.homepage.personalize.readProgressBar.c.a(threadInfo.tid.longValue(), i2, this.kas.thread_list, this.mDataList);
                            this.kas.thread_list.remove(i2);
                            cut();
                            break;
                        }
                    } else {
                        break;
                    }
                }
                if (this.jgC != null) {
                    List<Integer> b2 = b(optString, this.jgC);
                    int intValue = b2.get(0).intValue();
                    int intValue2 = b2.get(1).intValue();
                    if (intValue != -1 && intValue2 != -1) {
                        this.jgC.p(intValue, intValue2);
                    }
                }
            }
        }
    }

    private List<Integer> k(BdTypeRecyclerView bdTypeRecyclerView) {
        int i = -1;
        ArrayList arrayList = new ArrayList(2);
        int i2 = 0;
        boolean z = false;
        int i3 = -1;
        while (true) {
            int i4 = i;
            if (i2 < bdTypeRecyclerView.getCount()) {
                n item = bdTypeRecyclerView.getItem(i2);
                if (item instanceof com.baidu.tieba.homepage.personalize.data.g) {
                    com.baidu.tieba.homepage.personalize.data.g gVar = (com.baidu.tieba.homepage.personalize.data.g) item;
                    if (!z) {
                        i4 = i2;
                    }
                    z = true;
                    i3 = i2;
                }
                i = i4;
                i2++;
            } else {
                arrayList.add(Integer.valueOf(i4));
                arrayList.add(Integer.valueOf(i3));
                return arrayList;
            }
        }
    }

    private List<Integer> b(String str, BdTypeRecyclerView bdTypeRecyclerView) {
        int i = -1;
        ArrayList arrayList = new ArrayList(2);
        int i2 = 0;
        boolean z = false;
        int i3 = -1;
        while (true) {
            int i4 = i;
            if (i2 < bdTypeRecyclerView.getCount()) {
                n item = bdTypeRecyclerView.getItem(i2);
                if (item instanceof com.baidu.tieba.card.data.b) {
                    com.baidu.tieba.card.data.b bVar = (com.baidu.tieba.card.data.b) item;
                    if (bVar.bkV() != null && bVar.bkV().getTid().equals(str)) {
                        if (!z) {
                            i4 = i2;
                        }
                        z = true;
                        i3 = i2;
                    }
                }
                i = i4;
                i2++;
            } else {
                arrayList.add(Integer.valueOf(i4));
                arrayList.add(Integer.valueOf(i3));
                return arrayList;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(String str, List<n> list) {
        AdvertAppInfo advertAppInfo;
        if (list != null && list.size() > 0 && !TextUtils.isEmpty(str)) {
            Iterator<n> it = list.iterator();
            AdvertAppInfo advertAppInfo2 = null;
            while (it.hasNext()) {
                n next = it.next();
                if (next instanceof com.baidu.tieba.homepage.personalize.data.a) {
                    advertAppInfo = ((com.baidu.tieba.homepage.personalize.data.a) next).crG();
                } else {
                    if (next instanceof am) {
                        am amVar = (am) next;
                        if (amVar.blM() instanceof AdvertAppInfo.ILegoAdvert) {
                            advertAppInfo = ((AdvertAppInfo.ILegoAdvert) amVar.blM()).getAdvertAppInfo();
                        }
                    }
                    advertAppInfo = advertAppInfo2;
                }
                if (advertAppInfo != null && str.equals(advertAppInfo.eJi)) {
                    it.remove();
                    advertAppInfo = null;
                }
                advertAppInfo2 = advertAppInfo;
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (this.iJw != null) {
            this.iJw.onChangeSkinType(i);
        }
        if (this.kaE != null) {
            this.kaE.onChangeSkinType();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ThreadCardViewHolder cOy() {
        if (this.iJA == null || this.iJA.dxN() == null || !(this.iJA.dxN().getTag() instanceof ThreadCardViewHolder)) {
            return null;
        }
        return (ThreadCardViewHolder) this.iJA.dxN().getTag();
    }
}
