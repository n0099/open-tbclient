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
    private View.OnTouchListener fkL;
    private aa fza;
    private com.baidu.tieba.tbadkCore.data.f iHl;
    private final BdTypeRecyclerView iNq;
    private be iqi;
    private SmartBubbleAnimatedView iqj;
    private i iqn;
    private final ag jCA;
    private ScrollFragmentTabHost jCo;
    private Runnable jDH;
    private final long jDh;
    private final b jDi;
    private DataRes.Builder jDk;
    private final com.baidu.tieba.homepage.personalize.model.a jDn;
    private int jDq;
    private h jDs;
    private BdUniqueId jDv;
    private HomePageYoungsterTopView jDw;
    private int jDx;
    private com.baidu.tieba.f.a jiW;
    private boolean jth;
    private final BigdaySwipeRefreshLayout jvC;
    private final TbPageContext<?> mPageContext;
    private a jDj = null;
    private final List<q> mDataList = new LinkedList();
    private int mPn = 1;
    private boolean mIsLoading = false;
    private boolean jvN = false;
    private int jDl = 2;
    private int jDm = 0;
    private TextView mTipView = null;
    private int iMw = 2000;
    private com.baidu.tbadk.n.c jDo = null;
    private boolean iKg = false;
    private int iJw = 0;
    private int ghW = 0;
    private boolean mIsBackground = false;
    private boolean jBa = true;
    private boolean jDp = false;
    private boolean jDr = false;
    private boolean jDt = true;
    private FloatInfo jDu = null;
    private BdUniqueId jDy = BdUniqueId.gen();
    private a.C0097a iHG = new a.C0097a(2);
    private ThreadInfo jDz = null;
    private RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.e.12
        private int jDO = -1;
        private int jvW = 0;
        private boolean jDP = false;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (e.this.jDo == null) {
                e.this.jDo = new com.baidu.tbadk.n.c();
                e.this.jDo.setSubType(1005);
                e.this.jDo.pageType = 1;
            }
            if (e.this.fza != null && !e.this.mIsBackground) {
                e.this.fza.m(recyclerView, i);
            }
            if (i == 0) {
                c.d(e.this.iNq);
                e.this.jDo.bCl();
                t.cor().lN(true);
                com.baidu.tieba.a.d.bIR().dM("page_recommend", "show_");
                com.baidu.tieba.s.c.dIX().b(e.this.jDv, false);
                this.jDP = false;
                if (e.this.iqn != null && e.this.jBa && !e.this.mIsBackground) {
                    e.this.iqn.a(e.this.iJw, e.this.ghW, e.this.iKg, 1);
                    return;
                }
                return;
            }
            e.this.jDo.bCk();
            if (i == 1) {
                if (e.this.iqi != null) {
                    e.this.iqi.hideTip();
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
            if (this.jvW > i) {
                this.jDP = true;
            }
            if (e.this.fza != null && !e.this.mIsBackground) {
                e.this.fza.onScroll(this.jvW, i);
            }
            this.jvW = i;
            int i3 = (i + i2) - 1;
            if (!this.jDP && this.jDO != i3) {
                this.jDO = i3;
                e.this.BJ(this.jDO);
            }
            if (this.jDP && this.jDO != i) {
                this.jDO = i;
                e.this.BJ(this.jDO);
            }
            e.this.jDG = i;
            e.this.iJw = i;
            e.this.ghW = (i + i2) - 1;
            am cKo = e.this.cKo();
            if (cKo != null && cKo.tW() != null) {
                cKo.tW().b(e.this.iHG);
            }
        }
    };
    private View.OnTouchListener fzb = new View.OnTouchListener() { // from class: com.baidu.tieba.homepage.personalize.e.23
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (e.this.fkL != null) {
                e.this.fkL.onTouch(view, motionEvent);
            }
            if (e.this.jiW != null) {
                e.this.jiW.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private a.InterfaceC0719a igd = new a.InterfaceC0719a() { // from class: com.baidu.tieba.homepage.personalize.e.30
        @Override // com.baidu.tieba.f.a.InterfaceC0719a
        public void H(int i, int i2) {
            e.this.iKg = false;
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0719a
        public void I(int i, int i2) {
            e.this.iKg = true;
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0719a
        public void cg(int i, int i2) {
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0719a
        public void J(int i, int i2) {
        }
    };
    private View.OnClickListener jDA = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.e.31
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (e.this.iqi != null) {
                e.this.iqi.hideTip();
            }
        }
    };
    private final CustomMessageListener jDB = new CustomMessageListener(CmdConfigCustom.CMD_RELOAD_HP_PERSONALIZED) { // from class: com.baidu.tieba.homepage.personalize.e.32
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (e.this.iNq != null) {
                e.this.iqn.cKn();
                e.this.jBa = false;
                e.this.jvC.setRefreshing(true);
            }
        }
    };
    private final CustomMessageListener jDC = new CustomMessageListener(2921461) { // from class: com.baidu.tieba.homepage.personalize.e.33
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (e.this.iNq != null) {
                e.this.cLd();
            }
        }
    };
    private final CustomMessageListener jDD = new CustomMessageListener(2921486) { // from class: com.baidu.tieba.homepage.personalize.e.34
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data = customResponsedMessage.getData();
            switch (data instanceof Integer ? ((Integer) data).intValue() : 0) {
                case 2:
                    new BdTopToast(e.this.mPageContext.getPageActivity(), 2000).yk(true).Ut(e.this.mPageContext.getPageActivity().getString(R.string.youngster_open_title)).aJ((ViewGroup) e.this.mPageContext.getPageActivity().findViewById(R.id.maintabContainer));
                    e.this.rc(true);
                    return;
                case 3:
                    new BdTopToast(e.this.mPageContext.getPageActivity(), 2000).yk(true).Ut(e.this.mPageContext.getPageActivity().getString(R.string.youngster_close_title)).aJ((ViewGroup) e.this.mPageContext.getPageActivity().findViewById(R.id.maintabContainer));
                    e.this.rc(false);
                    return;
                case 4:
                default:
                    if (com.baidu.tbadk.youngster.b.c.bHs()) {
                        e.this.rc(true);
                        return;
                    }
                    return;
                case 5:
                    new BdTopToast(e.this.mPageContext.getPageActivity(), 2000).yk(true).Ut(e.this.mPageContext.getPageActivity().getString(R.string.youngster_reset_title)).aJ((ViewGroup) e.this.mPageContext.getPageActivity().findViewById(R.id.maintabContainer));
                    e.this.rc(true);
                    return;
            }
        }
    };
    private CustomMessageListener jbC = new CustomMessageListener(CmdConfigCustom.PB_ACTION_PRAISE) { // from class: com.baidu.tieba.homepage.personalize.e.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            bw bwVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bw) && e.this.jDk != null && y.getCount(e.this.jDk.thread_list) != 0 && (bwVar = (bw) customResponsedMessage.getData()) != null && bwVar.bml() != null && bwVar.getId() != null && y.getCount(e.this.jDk.thread_list) != 0) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < e.this.jDk.thread_list.size()) {
                        ThreadInfo threadInfo = e.this.jDk.thread_list.get(i2);
                        if (threadInfo == null || threadInfo.id.longValue() != com.baidu.adp.lib.f.b.toLong(bwVar.getId(), -1L)) {
                            i = i2 + 1;
                        } else {
                            ThreadInfo.Builder builder = new ThreadInfo.Builder(threadInfo);
                            Zan.Builder builder2 = new Zan.Builder(builder.zan);
                            builder2.num = Integer.valueOf((int) bwVar.bml().getNum());
                            builder.zan = builder2.build(true);
                            e.this.jDk.thread_list.set(i2, builder.build(true));
                            return;
                        }
                    } else {
                        return;
                    }
                }
            }
        }
    };
    private CustomMessageListener jDE = new CustomMessageListener(CmdConfigCustom.CMD_LIVE_VIDEO_CLOSED_QUERY_RESPONSED) { // from class: com.baidu.tieba.homepage.personalize.e.9
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
                        if ((originData.get(i2) instanceof bw) && (bwVar = (bw) originData.get(i2)) != null && bwVar.bmU() != null && ids.contains(Long.valueOf(bwVar.bmU().live_id))) {
                            e.this.mDataList.remove(bwVar);
                        }
                        i = i2 + 1;
                    }
                    if (e.this.jCA != null) {
                        e.this.jCA.cr(new ArrayList(e.this.mDataList));
                    }
                }
            }
        }
    };
    private CustomMessageListener eNv = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.homepage.personalize.e.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int intValue;
            if ((customResponsedMessage instanceof UpdateAttentionMessage) && e.this.jDk != null && !y.isEmpty(e.this.jDk.thread_list)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid)) {
                    int i = 0;
                    while (true) {
                        if (i >= e.this.jDk.thread_list.size()) {
                            break;
                        }
                        ThreadInfo threadInfo = e.this.jDk.thread_list.get(i);
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
                            e.this.jDk.thread_list.set(i, builder.build(true));
                        }
                    }
                    e.this.a(updateAttentionMessage);
                }
            }
        }
    };
    private CustomMessageListener jvS = new CustomMessageListener(0) { // from class: com.baidu.tieba.homepage.personalize.e.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long) && e.this.jDk != null && e.this.jDk.hot_recomforum != null && !y.isEmpty(e.this.jDk.hot_recomforum.tab_list)) {
                long longValue = ((Long) customResponsedMessage.getData()).longValue();
                DiscoverHotForum.Builder builder = new DiscoverHotForum.Builder(e.this.jDk.hot_recomforum);
                if (com.baidu.tieba.homepage.concern.c.a(builder, longValue, customResponsedMessage.getCmd() == 2001335)) {
                    e.this.jDk.hot_recomforum = builder.build(true);
                    e.this.c(new DataRes.Builder(e.this.jDk.build(true)));
                }
            }
        }
    };
    private String jDF = "lastReadReadPositionKey";
    private int jDG = 0;
    private d jDI = new d() { // from class: com.baidu.tieba.homepage.personalize.e.16
        @Override // com.baidu.tieba.homepage.personalize.d
        public void Bs(final int i) {
            if (e.this.jDH == null) {
                e.this.jDH = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.e.16.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (e.this.iNq.getHandler() != null) {
                            e.this.iNq.requestFocusFromTouch();
                            if (i <= e.this.iNq.getCount() - 1) {
                                e.this.iNq.setSelection(i);
                            }
                        }
                    }
                };
            }
            e.this.iNq.removeCallbacks(e.this.jDH);
            e.this.iNq.post(e.this.jDH);
        }
    };
    private CustomMessageListener jDJ = new CustomMessageListener(2016569) { // from class: com.baidu.tieba.homepage.personalize.e.19
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && e.this.jDs != null) {
                e.this.mDataList.remove(e.this.jDs);
                e.this.jCA.cr(new ArrayList(e.this.mDataList));
                com.baidu.tbadk.core.sharedPref.b.bqh().putLong("key_maintab_banner_close_time", System.currentTimeMillis());
            }
        }
    };
    private CustomMessageListener iqc = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.homepage.personalize.e.20
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.g(customResponsedMessage);
            if (e.this.iqn != null && e.this.jBa) {
                e.this.iqn.a(e.this.iJw, e.this.ghW, e.this.iKg, true);
            }
        }
    };
    private CustomMessageListener iqd = new CustomMessageListener(CmdConfigCustom.CMD_THREAD_NOT_EXIST_WHEN_ENTER_PB) { // from class: com.baidu.tieba.homepage.personalize.e.21
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.g(customResponsedMessage);
        }
    };
    private CustomMessageListener jbQ = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.homepage.personalize.e.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && e.this.jDk != null && y.getCount(e.this.jDk.thread_list) != 0) {
                String str = (String) customResponsedMessage.getData();
                e.this.h(str, e.this.mDataList);
                e.this.LP(str);
                if (e.this.jCA != null) {
                    e.this.jCA.cr(new ArrayList(e.this.mDataList));
                }
                if (e.this.iqn != null && e.this.jBa) {
                    e.this.iqn.a(e.this.iJw, e.this.ghW, e.this.iKg, true);
                }
            }
        }
    };
    private CustomMessageListener iJd = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.homepage.personalize.e.24
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            am cKo;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent)) {
                KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24 && (cKo = e.this.cKo()) != null && cKo.tW() != null) {
                    cKo.tW().b(new a.C0097a(3));
                }
            }
        }
    };
    private com.baidu.adp.framework.listener.a jDK = new com.baidu.adp.framework.listener.a(1003065, CmdConfigSocket.CMD_TOPIC_BLESS) { // from class: com.baidu.tieba.homepage.personalize.e.25
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
                        if ((qVar instanceof com.baidu.tieba.homepage.topic.topictab.b.a) && (bVar = ((com.baidu.tieba.homepage.topic.topictab.b.a) qVar).jKO) != null && longValue == bVar.pkId) {
                            bVar.userPkId = j2;
                            return;
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener iJe = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.homepage.personalize.e.26
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            List<q> dataList = e.this.jCA.getDataList();
            if (!y.isEmpty(dataList)) {
                for (q qVar : dataList) {
                    if (qVar instanceof l) {
                        l lVar = (l) qVar;
                        if (lVar.eDx != 0 && lVar.exA != null) {
                            int[] imageWidthAndHeight = lVar.exA.getImageWidthAndHeight();
                            lVar.eDx = imageWidthAndHeight[0];
                            lVar.eDy = imageWidthAndHeight[1];
                        }
                    }
                }
            }
            com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.personalize.e.26.1
                @Override // java.lang.Runnable
                public void run() {
                    e.this.jCA.notifyDataSetChanged();
                    if (!e.this.mIsBackground && e.this.jBa) {
                        e.this.iqn.a(e.this.iJw, e.this.ghW, e.this.iKg, true);
                    }
                }
            }, 500L);
        }
    };
    private CustomMessageListener iqe = new CustomMessageListener(2921453) { // from class: com.baidu.tieba.homepage.personalize.e.27
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.data.be)) {
                com.baidu.tbadk.core.data.be beVar = (com.baidu.tbadk.core.data.be) customResponsedMessage.getData();
                if (beVar.eCw == 1) {
                    int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
                    int equipmentHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst());
                    float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
                    int i = au.bro().brp() ? 2 : 1;
                    RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
                    requestGetMyPostNetMessage.setTag(e.this.jDy);
                    requestGetMyPostNetMessage.setParams(com.baidu.adp.lib.f.b.toLong(beVar.tid, 0L), 0L, 0L, equipmentWidth, equipmentHeight, f, i);
                    requestGetMyPostNetMessage.setBFrom("push");
                    MessageManager.getInstance().sendMessage(requestGetMyPostNetMessage);
                }
            }
        }
    };
    private final com.baidu.adp.framework.listener.a iqf = new com.baidu.adp.framework.listener.a(1003010, CmdConfigSocket.CMD_GET_MY_POST) { // from class: com.baidu.tieba.homepage.personalize.e.28
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            GetMyPostResIdl getMyPostResIdl = null;
            if (responsedMessage instanceof GetMyPostHttpResponseMessage) {
                getMyPostResIdl = ((GetMyPostHttpResponseMessage) responsedMessage).getResponseData();
            } else if (responsedMessage instanceof GetMyPostSocketResponseMessage) {
                getMyPostResIdl = ((GetMyPostSocketResponseMessage) responsedMessage).getResponseData();
            }
            if (getMyPostResIdl != null && getMyPostResIdl.data != null && getMyPostResIdl.data.thread_info != null) {
                e.this.jDz = getMyPostResIdl.data.thread_info;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921455));
            }
        }
    };
    private CustomMessageListener jDL = new CustomMessageListener(2921482) { // from class: com.baidu.tieba.homepage.personalize.e.29
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

        void cKQ();

        void onError(int i, String str);

        void onSuccess();
    }

    public void qZ(boolean z) {
        this.jDt = z;
        if (this.iqi != null && !z) {
            this.iqi.hideTip();
        }
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.jCo = scrollFragmentTabHost;
        if (this.jCo != null) {
            this.jCo.setOnTabSelectedListener(new ScrollFragmentTabHost.b() { // from class: com.baidu.tieba.homepage.personalize.e.1
                @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.b
                public void BC(int i) {
                    if (e.this.jCo.BB(i) != 1 && e.this.iqi != null) {
                        e.this.iqi.hideTip();
                    }
                }
            });
        }
    }

    public void setTabInForeBackgroundState(boolean z) {
        this.mIsBackground = z;
    }

    public void pF(boolean z) {
        boolean z2 = false;
        this.mIsBackground = z;
        if (this.jCo != null) {
            this.jCo.pF(z);
        }
        if (this.iqn != null) {
            this.iqn.sX(!z);
            am cKo = cKo();
            if (cKo != null && cKo.tW() != null) {
                z2 = cKo.tW().b(new a.C0097a(8, Boolean.valueOf(z)));
            }
            if (!z2) {
                if (z) {
                    this.iqn.cKn();
                } else if (this.jBa) {
                    this.iqn.a(this.iJw, this.ghW, this.iKg, true);
                }
            }
        }
    }

    public e(TbPageContext<?> tbPageContext, BdTypeRecyclerView bdTypeRecyclerView, ag agVar, BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout) {
        this.jDx = 0;
        this.mPageContext = tbPageContext;
        this.jDx = com.baidu.tbadk.core.sharedPref.b.bqh().getInt("key_personalized_refresh_type", 0);
        this.jvC = bigdaySwipeRefreshLayout;
        this.iNq = bdTypeRecyclerView;
        this.iNq.setOnTouchListener(this.fzb);
        if (com.baidu.tbadk.youngster.b.c.bHs()) {
            rc(true);
        }
        this.jiW = new com.baidu.tieba.f.a();
        this.jiW.a(this.igd);
        this.jCA = agVar;
        this.jDn = new com.baidu.tieba.homepage.personalize.model.a();
        this.jDh = com.baidu.tbadk.core.sharedPref.b.bqh().getLong("recommend_frs_cache_time", 1800L) * 1000;
        bdTypeRecyclerView.setOnScrollListener(this.mOnScrollListener);
        this.iqi = new be();
        cLb();
        this.iqn = new i(this.mPageContext, this.iNq);
        this.iqn.Hu(1);
        this.iqn.Ht(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.jDi = new b(this.mDataList, this.jCA);
        this.iqj = new SmartBubbleAnimatedView(tbPageContext.getContext());
        this.iqj.setLayoutParams(new FrameLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(tbPageContext.getContext(), R.dimen.tbds83)));
        cKR();
        this.iJe.setTag(this.mPageContext.getUniqueId());
        MessageManager.getInstance().registerListener(this.iJe);
        if (MessageManager.getInstance().findTask(1003010) == null) {
            HomePageStatic.cIx();
        }
        this.iqf.setTag(this.jDy);
        if (this.iqf.getHttpMessageListener() != null) {
            this.iqf.getHttpMessageListener().setSelfListener(true);
        }
        if (this.iqf.getSocketMessageListener() != null) {
            this.iqf.getSocketMessageListener().setSelfListener(true);
        }
        MessageManager.getInstance().registerListener(this.iqf);
        MessageManager.getInstance().registerListener(this.iqe);
        MessageManager.getInstance().registerListener(this.jDL);
    }

    private void cKR() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2016323, new CustomMessageTask.CustomRunnable<Boolean>() { // from class: com.baidu.tieba.homepage.personalize.e.35
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Boolean> customMessage) {
                am cKo = e.this.cKo();
                return (cKo == null || cKo.tW() == null) ? new CustomResponsedMessage<>(2016323, false) : new CustomResponsedMessage<>(2016323, Boolean.valueOf(cKo.tW().b(new a.C0097a(6))));
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private boolean cKS() {
        return com.baidu.tbadk.core.sharedPref.b.bqh().getBoolean(cKU(), true);
    }

    private void cKT() {
        com.baidu.tbadk.core.sharedPref.b.bqh().putBoolean(cKU(), false);
    }

    private String cKU() {
        return "key_rec_pfirst_load_" + TbadkCoreApplication.getCurrentAccount() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + TbConfig.getVersion();
    }

    public void setRecommendFrsNavigationAnimDispatcher(ab abVar) {
        if (abVar != null) {
            this.fza = abVar.bDS();
            this.fkL = abVar.bDT();
        }
    }

    public void showFloatingView() {
        if (this.fza != null) {
            this.fza.showFloatingView(true);
        }
    }

    public void update() {
        com.baidu.tieba.homepage.framework.a.cJh().C(System.currentTimeMillis(), 1);
        this.mPn = 1;
        this.jDr = true;
        if (this.mDataList.size() == 0 && !cKS()) {
            if (!this.jvN) {
                bjR();
                return;
            }
            return;
        }
        bjQ();
    }

    public void cE(int i, int i2) {
        bw bwVar;
        if (!y.isEmpty(this.mDataList) && this.mDataList.size() > i) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            while (i < this.mDataList.size() && i <= i2) {
                if (this.mDataList.get(i).getType().getId() == bw.eDX.getId() && (bwVar = (bw) this.mDataList.get(i)) != null && bwVar.bmU() != null) {
                    arrayList.add(Long.valueOf(bwVar.bmU().live_id));
                    arrayList2.add(bwVar);
                }
                i++;
            }
            if (!y.isEmpty(arrayList)) {
                MessageManager.getInstance().sendMessage(new LiveRoomClosedQueryMessage(arrayList, arrayList2));
            }
        }
    }

    public void cKV() {
        if (this.iqn != null && !this.mIsBackground && this.jBa) {
            this.iqn.a(this.iJw, this.ghW, this.iKg, true);
        }
        if (this.jDp) {
            if (this.jvC != null && !this.jvC.bsI()) {
                if (this.jth) {
                    com.baidu.tieba.s.c.dIX().b(this.jDv, false);
                    if (rb(false)) {
                        cF(3, this.jDm);
                    } else if (this.jDq > 0) {
                        cF(2, this.jDm);
                    }
                } else if (!this.jth && this.jDm == 0) {
                    cF(2, 0);
                }
            }
            this.jDp = false;
            this.jth = false;
            this.jDq = 0;
            if (this.jDr) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
            }
            this.jDr = false;
        }
    }

    public void bOI() {
        if (isLoading()) {
            com.baidu.tieba.homepage.framework.a.cJh().C(0L, 1);
        } else if (this.jDj != null) {
            cKX();
            this.mPn++;
            setIsLoading(true);
            this.jDj.C(this.mPn, (this.jDk == null || this.jDk.thread_list == null) ? 0 : this.jDk.thread_list.size(), ra(false), 0);
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
            g.cLi();
        }
        if (this.jDn != null && this.jDn.cLC() && !z && (dataRes == null || y.isEmpty(dataRes.thread_list))) {
            if (dataRes == null) {
                DataRes.Builder builder = new DataRes.Builder();
                builder.thread_list = new ArrayList();
                dataRes = builder.build(false);
            }
            if (dataRes.thread_list != null) {
                List<ThreadInfo> cLD = this.jDn.cLD();
                dataRes.thread_list.addAll(cLD);
                if (cLD != null) {
                    cLD.clear();
                }
                z3 = true;
                size = (this.jDk != null || this.jDk.thread_list == null) ? 0 : this.jDk.thread_list.size();
                if (z && i == 0 && dataRes != null && y.isEmpty(dataRes.thread_list)) {
                    if (this.jDj != null) {
                        this.jDj.cKQ();
                    }
                    setIsLoading(false);
                    if (this.jvC != null) {
                        this.jvC.setRefreshing(false);
                        return;
                    }
                    return;
                }
                if (this.jDz != null) {
                    DataRes.Builder builder2 = new DataRes.Builder(dataRes);
                    builder2.thread_list.add(0, this.jDz);
                    dataRes = builder2.build(false);
                    if (this.jDk != null && !y.isEmpty(this.jDk.thread_list)) {
                        Iterator<ThreadInfo> it = this.jDk.thread_list.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            ThreadInfo next = it.next();
                            if (next != null && next.tid != null && this.jDz.tid != null && next.tid.longValue() == this.jDz.tid.longValue()) {
                                this.jDk.thread_list.remove(next);
                                break;
                            }
                        }
                    }
                    this.jDz = null;
                }
                if ((z3 && i != 0) || dataRes == null || !a(true, z, z2, dataRes)) {
                    this.jDp = false;
                    if (this.mDataList.size() > 0) {
                        if (this.jDj != null) {
                            this.jDj.onError(1, str);
                        }
                    } else if (this.jDj != null) {
                        this.jDj.onError(2, str);
                    }
                } else {
                    cKT();
                    if (this.jDj != null) {
                        com.baidu.tbadk.core.sharedPref.b.bqh().putLong(SharedPrefConfig.RECOMMEND_FRS_REFRESH_TIME + TbadkCoreApplication.getCurrentAccount(), System.currentTimeMillis());
                        this.jDj.onSuccess();
                    }
                    this.jDp = true;
                    this.jth = z;
                    this.jDq = size;
                    crz();
                }
                setIsLoading(false);
                if (this.jvC == null) {
                    f.e cKW = cKW();
                    if (this.jvC.bsI() && cKW != null) {
                        this.jvC.c(cKW);
                        return;
                    } else {
                        this.jvC.setRefreshing(false);
                        return;
                    }
                }
                return;
            }
        }
        z3 = false;
        if (this.jDk != null) {
        }
        if (z) {
        }
        if (this.jDz != null) {
        }
        if (z3) {
        }
        cKT();
        if (this.jDj != null) {
        }
        this.jDp = true;
        this.jth = z;
        this.jDq = size;
        crz();
        setIsLoading(false);
        if (this.jvC == null) {
        }
    }

    private f.e cKW() {
        int i;
        String feedText;
        if (!this.jDp || this.jvC == null || !this.jvC.bsI() || cLa()) {
            return null;
        }
        int i2 = this.jDm;
        if (this.jth) {
            com.baidu.tieba.s.c.dIX().b(this.jDv, false);
            if (rb(false)) {
                i = 3;
            } else {
                i = this.jDq > 0 ? 2 : 0;
            }
        } else if (this.jth || this.jDm != 0) {
            return null;
        } else {
            i2 = 0;
            i = 2;
        }
        if (this.jCo != null) {
            this.iqi.cAG();
        }
        if (this.jCo != null && this.jCo.getCurrentTabType() != 1) {
            this.iqi.hideTip();
            return null;
        } else if (!this.jDt) {
            this.iqi.hideTip();
            return null;
        } else {
            this.jDl = i;
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
                this.iMw = 1000;
            } else {
                this.iMw = 0;
            }
            return new f.e(feedText, this.iMw);
        }
    }

    public void qM(boolean z) {
        if (z) {
            this.jCA.notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        if (this.iqn != null) {
            this.iqn.destroy();
        }
        if (this.iqi != null) {
            this.iqi.onDestroy();
        }
        if (this.jDi != null) {
            this.jDi.onDestroy();
        }
        if (this.iNq != null) {
            this.iNq.removeCallbacks(this.jDH);
        }
        MessageManager.getInstance().unRegisterTask(2016323);
        MessageManager.getInstance().unRegisterListener(this.iJe);
        MessageManager.getInstance().unRegisterListener(this.iqe);
        MessageManager.getInstance().unRegisterListener(this.iqf);
        MessageManager.getInstance().unRegisterListener(this.jDL);
    }

    public void onPause() {
        c.d(this.iNq);
        BK(this.jDG);
        if (this.jDo != null) {
            this.jDo.bCm();
        }
    }

    private void bjQ() {
        if (this.jDj != null) {
            this.jDj.S((this.jDk == null || this.jDk.thread_list == null || cKZ()) ? 0 : this.jDk.thread_list.size(), ra(true), 0);
        }
    }

    public int ra(boolean z) {
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
                if (!(qVar instanceof com.baidu.tieba.homepage.personalize.data.a) || qVar.getType() == AdvertAppInfo.eyD) {
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
                if ((qVar2 instanceof com.baidu.tieba.homepage.personalize.data.a) && qVar2.getType() != AdvertAppInfo.eyD) {
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
        this.jvN = true;
        if (dataRes != null) {
            if (a(false, true, true, dataRes) && !cKZ()) {
                if (this.jDj != null) {
                    this.jDj.onSuccess();
                    Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler() { // from class: com.baidu.tieba.homepage.personalize.e.2
                        @Override // android.os.MessageQueue.IdleHandler
                        public boolean queueIdle() {
                            e.this.bCr();
                            return false;
                        }
                    });
                }
                if (TbSingleton.getInstance().getForceRefreshHomeRecommend()) {
                    bjQ();
                    TbSingleton.getInstance().setForceRefreshHomeRecommend(false);
                    return;
                }
                return;
            }
            bjQ();
            return;
        }
        bjQ();
    }

    public void bCr() {
        long Bq = com.baidu.tieba.homepage.framework.a.cJh().Bq(1) + com.baidu.tieba.homepage.framework.a.cJh().getCreateTime();
        long Bo = com.baidu.tieba.homepage.framework.a.cJh().Bo(1);
        if (Bo > 0) {
            Bq = System.currentTimeMillis() - Bo;
        }
        n.bCz().eg(Bq);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.util.Set] */
    private void i(List<q> list, int i) {
        AdvertAppInfo coL;
        AdvertAppInfo coL2;
        if (!y.isEmpty(list)) {
            Set<q> RE = com.baidu.tieba.recapp.report.a.RE("NEWINDEX");
            HashSet hashSet = RE == null ? new HashSet() : RE;
            HashSet hashSet2 = new HashSet();
            for (q qVar : list) {
                if (qVar != null) {
                    for (q qVar2 : hashSet) {
                        if ((qVar instanceof com.baidu.tieba.card.data.e) && (coL2 = ((com.baidu.tieba.card.data.e) qVar).coL()) != null && qVar2 != null && (qVar2 instanceof AdvertAppInfo) && qVar2.hashCode() == coL2.hashCode()) {
                            coL2.advertAppContext = ((AdvertAppInfo) qVar2).advertAppContext;
                        }
                    }
                    if (qVar != null && (qVar instanceof com.baidu.tieba.card.data.e) && (coL = ((com.baidu.tieba.card.data.e) qVar).coL()) != null && coL.advertAppContext == null) {
                        coL.advertAppContext = new com.baidu.tbadk.core.data.b();
                        coL.advertAppContext.page = "NEWINDEX";
                        coL.advertAppContext.pn = this.mPn;
                        coL.advertAppContext.extensionInfo = coL.extensionInfo;
                        coL.advertAppContext.YN = false;
                        hashSet2.add(coL);
                    }
                }
            }
            hashSet.addAll(hashSet2);
            com.baidu.tieba.recapp.report.a.b("NEWINDEX", hashSet);
            if (hashSet2.size() > 0) {
                com.baidu.tieba.s.c.dIX().b(this.jDv, com.baidu.tieba.s.a.b(PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE, "common_fill", true, hashSet2.size()));
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
        if (this.jDx == 1) {
            if (z2 && (dataRes.thread_list.size() >= 6 || cKZ())) {
                cKY();
                this.jDk = null;
            }
        } else if (z2 && cKZ()) {
            this.jDk = null;
        }
        int size = z2 ? 0 : this.mDataList.size();
        DataRes.Builder builder = new DataRes.Builder(dataRes);
        this.mDataList.clear();
        com.baidu.tieba.homepage.personalize.model.c a2 = this.jDn.a(z, this.jDk, builder, z2 ? 0 : 1);
        if (a2 == null) {
            list = null;
            i = 0;
        } else {
            List<q> list2 = a2.fNQ;
            this.jDm = a2.jGr;
            int i2 = a2.jGs;
            a2.jGs = 0;
            list = list2;
            i = i2;
        }
        if (list != null) {
            this.mDataList.addAll(list);
            i(list, size);
            a(z2 ? 0 : 1, list, size);
            if (this.jDr) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
            }
        }
        if (this.jDk == null) {
            this.jDk = builder;
            this.jDi.dL(this.jDk.thread_list);
        }
        if (this.mDataList.size() == 0) {
            z4 = false;
        } else {
            if (z2) {
                if (dataRes.live_answer != null) {
                    this.jDs = new h();
                    this.jDs.a(dataRes.live_answer);
                    this.jDk.live_answer = dataRes.live_answer;
                } else if (z) {
                    this.jDs = null;
                    this.jDk.live_answer = null;
                }
                this.jDu = dataRes.float_info;
                this.jDk.float_info = dataRes.float_info;
            }
            long j = com.baidu.tbadk.core.sharedPref.b.bqh().getLong("key_maintab_banner_close_time", 0L);
            if (this.jDs != null && !at.isTaday(j)) {
                this.mDataList.add(0, this.jDs);
            }
            LinkedList linkedList = new LinkedList(this.mDataList);
            this.jCA.setFromCDN(dataRes.is_new_url != null && dataRes.is_new_url.intValue() == 1);
            this.jCA.j(linkedList, i);
            z4 = true;
            if (this.iqn != null && this.jBa) {
                this.iqn.a(this.iJw, this.ghW, this.iKg, true);
            }
        }
        com.baidu.tieba.homepage.framework.a.cJh().A(System.currentTimeMillis() - currentTimeMillis, 1);
        long Br = com.baidu.tieba.homepage.framework.a.cJh().Br(1);
        if (Br > 0) {
            com.baidu.tieba.homepage.framework.a.cJh().B(System.currentTimeMillis() - Br, 1);
            com.baidu.tieba.homepage.framework.a.cJh().C(0L, 1);
        }
        if (dataRes.anti != null && dataRes.anti.block_pop_info != null) {
            com.baidu.tieba.ueg.d.d(dataRes.anti.block_pop_info);
        }
        bg bgVar = new bg();
        bgVar.a(dataRes.recom_post_topic);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_REFRESH_TOPIC_TIP, bgVar));
        return z4;
    }

    private void cKX() {
        List<q> list;
        int i;
        if (y.getCount(this.mDataList) >= this.jDn.cLy() - 40) {
            com.baidu.tieba.homepage.personalize.model.c a2 = this.jDn.a(true, this.jDk, null, 1);
            if (a2 != null) {
                List<q> list2 = a2.fNQ;
                i = a2.jGs;
                a2.jGs = 0;
                list = list2;
            } else {
                list = null;
                i = 0;
            }
            if (list != null) {
                this.mDataList.clear();
                this.mDataList.addAll(list);
                this.jCA.j(new LinkedList(this.mDataList), i);
            }
        }
    }

    private void bjR() {
        this.jvN = true;
        ae.a(new ad<DataRes>() { // from class: com.baidu.tieba.homepage.personalize.e.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.ad
            /* renamed from: cLe */
            public DataRes doInBackground() {
                com.baidu.adp.lib.cache.l<byte[]> dH = com.baidu.tbadk.core.c.a.boX().dH("tb.rec_frs_update", TbadkCoreApplication.getCurrentAccount());
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

    private void crz() {
        if (this.jDk != null) {
            DataRes.Builder builder = new DataRes.Builder(this.jDk.build(true));
            if (builder.thread_list != null && builder.thread_list.size() > 30) {
                builder.thread_list = builder.thread_list.subList(0, 30);
            }
            a(builder, builder.thread_list != null ? builder.thread_list.size() : 0);
            a(builder);
            b(builder);
            c(builder);
        }
    }

    private void cKY() {
        if (this.jDk != null) {
            final DataRes.Builder builder = new DataRes.Builder(this.jDk.build(true));
            if (builder.thread_list != null && builder.thread_list.size() > 50) {
                builder.thread_list = builder.thread_list.subList(0, 50);
            }
            a(builder, builder.thread_list != null ? builder.thread_list.size() : 0);
            ae.a(new ad<Object>() { // from class: com.baidu.tieba.homepage.personalize.e.5
                @Override // com.baidu.tbadk.util.ad
                public Object doInBackground() {
                    DataRes.Builder builder2 = new DataRes.Builder(builder.build(true));
                    e.this.jDi.dM(builder2.thread_list);
                    try {
                        com.baidu.tbadk.core.c.a.boX().dH("tb.rec_old_data", TbadkCoreApplication.getCurrentAccount()).setForever("0", builder2.build(true).toByteArray());
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
    public void LP(String str) {
        if (!TextUtils.isEmpty(str) && this.jDk != null && this.jDk.banner_list != null && this.jDk.banner_list.app != null && this.jDk.banner_list.app.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (App app : this.jDk.banner_list.app) {
                if (app != null && str.equals(app.id)) {
                    arrayList.add(app);
                }
            }
            BannerList.Builder builder = new BannerList.Builder(this.jDk.banner_list);
            if (builder.app != null) {
                builder.app.removeAll(arrayList);
            }
            this.jDk.banner_list = builder.build(false);
            DataRes.Builder builder2 = new DataRes.Builder(this.jDk.build(true));
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
                e.this.jDi.dM(builder2.thread_list);
                try {
                    com.baidu.tbadk.core.c.a.boX().dH("tb.rec_frs_update", TbadkCoreApplication.getCurrentAccount()).setForever("0", builder2.build(true).toByteArray());
                    return null;
                } catch (Exception e) {
                    BdLog.e(e);
                    return null;
                }
            }
        }, null);
    }

    private boolean cKZ() {
        return rb(true);
    }

    private boolean rb(boolean z) {
        long j = com.baidu.tbadk.core.sharedPref.b.bqh().getLong(SharedPrefConfig.RECOMMEND_FRS_REFRESH_TIME + TbadkCoreApplication.getCurrentAccount(), 0L);
        return j == 0 ? z : Math.abs(System.currentTimeMillis() - j) > this.jDh;
    }

    public void a(a aVar) {
        this.jDj = aVar;
    }

    private boolean isLoading() {
        return this.mIsLoading;
    }

    private void setIsLoading(boolean z) {
        this.mIsLoading = z;
    }

    public void cKM() {
        boolean z = true;
        com.baidu.tbadk.coreExtra.data.b activityPrizeData = TbadkCoreApplication.getInst().getActivityPrizeData();
        if (activityPrizeData.isSwitchTurn() && !StringUtils.isNull(activityPrizeData.getFeedText())) {
            String currentDay = UtilHelper.getCurrentDay();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            String str = "";
            if (!StringUtils.isNull(currentAccount)) {
                String string = com.baidu.tbadk.core.sharedPref.b.bqh().getString(SharedPrefConfig.ACTIVITY_PRIZE_FEED_TEXT_TIME, "");
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
                    com.baidu.tbadk.core.sharedPref.b.bqh().putString(SharedPrefConfig.ACTIVITY_PRIZE_FEED_TEXT_TIME, str);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rc(boolean z) {
        boolean z2 = com.baidu.tbadk.core.sharedPref.b.bqh().getBoolean("key_youngster_homgpage_top_view_closed", false);
        if (this.iNq != null && !z2) {
            if (z) {
                if (this.jDw == null) {
                    this.jDw = new HomePageYoungsterTopView(this.mPageContext);
                    this.jDw.setOnDeleteClick(new HomePageYoungsterTopView.a() { // from class: com.baidu.tieba.homepage.personalize.e.7
                        @Override // com.baidu.tieba.homepage.personalize.view.HomePageYoungsterTopView.a
                        public void cLf() {
                            new BdTopToast(e.this.mPageContext.getPageActivity(), 2000).yk(true).Ut(e.this.mPageContext.getPageActivity().getString(R.string.youngster_frs_top_toast)).aJ((ViewGroup) e.this.mPageContext.getPageActivity().findViewById(R.id.maintabContainer));
                            e.this.rc(false);
                            com.baidu.tbadk.core.sharedPref.b.bqh().putBoolean("key_youngster_homgpage_top_view_closed", true);
                        }
                    });
                }
                this.iNq.setHeaderView(this.jDw);
                this.jDw.setVisibility(0);
                this.iNq.scrollToPosition(0);
            } else if (this.jDw != null) {
                this.jDw.setVisibility(8);
                this.iNq.removeHeaderView(this.jDw);
            }
        }
    }

    private boolean cLa() {
        return this.jDw != null && this.jDw.getVisibility() == 0;
    }

    private void cF(int i, int i2) {
        if (!cLa()) {
            if (this.jCo != null) {
                this.iqi.cAG();
            }
            if (this.jCo != null && this.jCo.getCurrentTabType() != 1) {
                this.iqi.hideTip();
            } else if (!this.jDt) {
                this.iqi.hideTip();
            } else {
                this.jDl = i;
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
                        this.iMw = 3000;
                    } else {
                        this.iMw = 2000;
                    }
                    this.iqj.eVP = str;
                    this.iqj.iMp = this.iMw;
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 49;
                    if (this.jCo != null) {
                        FrameLayout frameLayout = this.jCo.getFrameLayout();
                        frameLayout.removeView(this.iqj);
                        frameLayout.addView(this.iqj, layoutParams);
                        this.iqj.cAE();
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(Long l) {
        if (this.jDk != null && this.jDk.thread_list != null) {
            List<ThreadInfo> list = this.jDk.thread_list;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                ThreadInfo threadInfo = list.get(i);
                if (threadInfo.tid.equals(l) && threadInfo.top_agree_post != null) {
                    ThreadInfo.Builder builder = new ThreadInfo.Builder(threadInfo);
                    builder.top_agree_post = null;
                    list.set(i, builder.build(true));
                    crz();
                    a(false, true, false, this.jDk.build(true));
                    return;
                }
            }
        }
    }

    public void o(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.jDv = bdUniqueId;
            if (this.jbC != null) {
                this.jbC.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.jbC);
            }
            if (this.jDB != null) {
                this.jDB.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.jDB);
            }
            this.jDC.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.jDC);
            this.eNv.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.eNv);
            this.jvS.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_LIKE_FORUM, this.jvS);
            MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_UNLIKE_FORUM, this.jvS);
            this.jDE.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.jDE);
            this.iqc.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.iqc);
            this.iqd.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.iqd);
            this.jbQ.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.jbQ);
            if (this.iqn != null) {
                this.iqn.setUniqueId(bdUniqueId);
            }
            this.jDi.l(bdUniqueId);
            this.jDJ.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.jDJ);
            this.iJd.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.iJd);
            this.jDK.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.jDK);
            this.jDD.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.jDD);
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
                        com.baidu.adp.lib.cache.l<byte[]> dH = com.baidu.tbadk.core.c.a.boX().dH("tb.rec_frs_update", TbadkCoreApplication.getCurrentAccount());
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
                        e.this.jDi.dM(builder5.thread_list);
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

    public void cLb() {
        this.iHl = new com.baidu.tieba.tbadkCore.data.f("new_index", null);
        this.iHl.dJF();
    }

    public void a(int i, List<q> list, int i2) {
        int i3;
        int i4;
        if (this.iHl != null) {
            if (i == 0) {
                this.iHl.dJF();
            }
            if (list != null && !list.isEmpty()) {
                int[] iArr = com.baidu.tieba.tbadkCore.data.f.mWr;
                int i5 = 0;
                int i6 = 0;
                int i7 = 0;
                while (i7 < list.size() && i6 < iArr.length && (i3 = iArr[i6]) >= 0) {
                    if (list.get(i7) instanceof com.baidu.tieba.card.data.c) {
                        i4 = i5 + 1;
                        if (i4 == i3 - 1) {
                            if (i2 < i7 + 1) {
                                this.iHl.ds(i3, i7 + 1);
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

    public void BJ(int i) {
        if ((this.iHl != null ? this.iHl.JA(i) : -1) >= 0 && this.iNq != null && this.iNq.getData() != null && this.iNq.getData().size() > i) {
            this.iHl.JB(i);
        }
    }

    public i czo() {
        return this.iqn;
    }

    public void qV(boolean z) {
        this.jBa = z;
    }

    public void BK(final int i) {
        ae.a(new ad<Object>() { // from class: com.baidu.tieba.homepage.personalize.e.15
            @Override // com.baidu.tbadk.util.ad
            public Object doInBackground() {
                com.baidu.adp.lib.cache.l<String> dI = com.baidu.tbadk.core.c.a.boX().dI(e.this.jDF, TbadkCoreApplication.getCurrentAccount());
                if (dI != null) {
                    dI.set(e.this.jDF, Integer.toString(i), 43200000L);
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
            /* renamed from: cLg */
            public String doInBackground() {
                com.baidu.adp.lib.cache.l<String> dI = com.baidu.tbadk.core.c.a.boX().dI(e.this.jDF, TbadkCoreApplication.getCurrentAccount());
                if (dI != null) {
                    return dI.get(e.this.jDF);
                }
                return null;
            }
        }, new m<String>() { // from class: com.baidu.tieba.homepage.personalize.e.18
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.m
            /* renamed from: LQ */
            public void onReturnDataInUI(String str) {
                if (dVar != null) {
                    dVar.Bs(com.baidu.adp.lib.f.b.toInt(str, 0));
                }
            }
        });
    }

    public void cKO() {
        c.e(this.iNq);
    }

    public void cLc() {
        a(this.jDI);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cLd() {
        Iterator<q> it = this.mDataList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            } else if (it.next() instanceof com.baidu.tieba.homepage.personalize.data.g) {
                it.remove();
                break;
            }
        }
        if (this.jDk != null) {
            this.jDk.active_center = null;
            crz();
            if (this.iNq != null) {
                List<Integer> f = f(this.iNq);
                int intValue = f.get(0).intValue();
                int intValue2 = f.get(1).intValue();
                if (intValue != -1 && intValue2 != -1) {
                    this.iNq.o(intValue, intValue2);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(CustomResponsedMessage<?> customResponsedMessage) {
        boolean z;
        String str;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.jDk != null && y.getCount(this.jDk.thread_list) != 0 && y.getCount(this.mDataList) != 0) {
            JSONObject jSONObject = (JSONObject) customResponsedMessage.getData();
            String optString = jSONObject.optString("tid");
            if (StringUtils.isNull(optString)) {
                String optString2 = jSONObject.optString(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_ID);
                if (this.iNq != null && !TextUtils.isEmpty(optString2)) {
                    int i = 0;
                    while (true) {
                        if (i >= this.iNq.getCount()) {
                            str = optString;
                            break;
                        }
                        q item = this.iNq.getItem(i);
                        if (item instanceof k) {
                            k kVar = (k) item;
                            if (kVar.bjZ() != null && kVar.bjZ().bmU() != null && optString2.equals(String.valueOf(kVar.bjZ().bmU().live_id))) {
                                str = kVar.bjZ().getTid();
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
                    if (cVar.bjZ() != null && cVar.bjZ().getTid() != null) {
                        if (cVar.bjZ().getTid().equals(optString)) {
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
            if (this.jDk != null && this.jDk.thread_list != null) {
                long j = com.baidu.adp.lib.f.b.toLong(optString, 0L);
                int i2 = 0;
                while (true) {
                    if (i2 < this.jDk.thread_list.size()) {
                        ThreadInfo threadInfo = this.jDk.thread_list.get(i2);
                        if (threadInfo == null || threadInfo.tid == null || threadInfo.tid.longValue() != j) {
                            i2++;
                        } else {
                            com.baidu.tieba.homepage.personalize.b.d.a(threadInfo.tid.longValue(), i2, this.jDk.thread_list, this.mDataList);
                            this.jDk.thread_list.remove(i2);
                            crz();
                            break;
                        }
                    } else {
                        break;
                    }
                }
                if (this.iNq != null) {
                    List<Integer> b = b(optString, this.iNq);
                    int intValue = b.get(0).intValue();
                    int intValue2 = b.get(1).intValue();
                    if (intValue != -1 && intValue2 != -1) {
                        this.iNq.o(intValue, intValue2);
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
                    if (cVar.bjZ() != null && cVar.bjZ().getTid().equals(str)) {
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
                    advertAppInfo = ((com.baidu.tieba.homepage.personalize.data.a) next).coL();
                } else {
                    if (next instanceof ak) {
                        ak akVar = (ak) next;
                        if (akVar.bkR() instanceof AdvertAppInfo.ILegoAdvert) {
                            advertAppInfo = ((AdvertAppInfo.ILegoAdvert) akVar.bkR()).getAdvertAppInfo();
                        }
                    }
                    advertAppInfo = advertAppInfo2;
                }
                if (advertAppInfo != null && str.equals(advertAppInfo.eyO)) {
                    it.remove();
                    advertAppInfo = null;
                }
                advertAppInfo2 = advertAppInfo;
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (this.iqj != null) {
            this.iqj.onChangeSkinType(i);
        }
        if (this.jDw != null) {
            this.jDw.onChangeSkinType();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public am cKo() {
        if (this.iqn == null || this.iqn.dwW() == null || !(this.iqn.dwW().getTag() instanceof am)) {
            return null;
        }
        return (am) this.iqn.dwW().getTag();
    }
}
