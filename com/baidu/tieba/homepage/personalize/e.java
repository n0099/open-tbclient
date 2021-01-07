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
    private View.OnTouchListener fAY;
    private x fPF;
    private bb iOc;
    private SmartBubbleAnimatedView iOd;
    private i iOh;
    private com.baidu.tieba.f.a jJI;
    private boolean jUI;
    private final BigdaySwipeRefreshLayout jXd;
    private com.baidu.tieba.tbadkCore.data.f jfe;
    private final BdTypeRecyclerView jlj;
    private final long keV;
    private final b keW;
    private DataRes.Builder keY;
    private ScrollFragmentTabHost kea;
    private final ab kem;
    private final com.baidu.tieba.homepage.personalize.model.a kfb;
    private int kfe;
    private h kfg;
    private BdUniqueId kfj;
    private HomePageYoungsterTopView kfk;
    private int kfl;
    private Runnable kfv;
    private final TbPageContext<?> mPageContext;
    private a keX = null;
    private final List<n> mDataList = new LinkedList();
    private int mPn = 1;
    private boolean mIsLoading = false;
    private boolean jXo = false;
    private int keZ = 2;
    private int kfa = 0;
    private TextView mTipView = null;
    private int jkp = 2000;
    private com.baidu.tbadk.n.c kfc = null;
    private boolean jia = false;
    private int jhq = 0;
    private int gAO = 0;
    private boolean mIsBackground = false;
    private boolean kcO = true;
    private boolean kfd = false;
    private boolean kff = false;
    private boolean kfh = true;
    private FloatInfo kfi = null;
    private BdUniqueId kfm = BdUniqueId.gen();
    private a.C0090a jfy = new a.C0090a(2);
    private ThreadInfo kfn = null;
    private RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.e.12
        private int kfC = -1;
        private int jXz = 0;
        private boolean kfD = false;

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (e.this.kfc == null) {
                e.this.kfc = new com.baidu.tbadk.n.c();
                e.this.kfc.setSubType(1005);
                e.this.kfc.pageType = 1;
            }
            if (e.this.fPF != null && !e.this.mIsBackground) {
                e.this.fPF.q(recyclerView, i);
            }
            if (i == 0) {
                c.i(e.this.jlj);
                e.this.kfc.bHz();
                s.cvb().mG(true);
                com.baidu.tieba.a.d.bOn().dR("page_recommend", "show_");
                com.baidu.tieba.s.c.dNY().b(e.this.kfj, false);
                this.kfD = false;
                if (e.this.iOh != null && e.this.kcO && !e.this.mIsBackground) {
                    e.this.iOh.a(e.this.jhq, e.this.gAO, e.this.jia, 1);
                    return;
                }
                return;
            }
            e.this.kfc.bHy();
            if (i == 1) {
                if (e.this.iOc != null) {
                    e.this.iOc.hideTip();
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
            if (this.jXz > i) {
                this.kfD = true;
            }
            if (e.this.fPF != null && !e.this.mIsBackground) {
                e.this.fPF.onScroll(this.jXz, i);
            }
            this.jXz = i;
            int i3 = (i + i2) - 1;
            if (!this.kfD && this.kfC != i3) {
                this.kfC = i3;
                e.this.Dk(this.kfC);
            }
            if (this.kfD && this.kfC != i) {
                this.kfC = i;
                e.this.Dk(this.kfC);
            }
            e.this.kfu = i;
            e.this.jhq = i;
            e.this.gAO = (i + i2) - 1;
            ThreadCardViewHolder cSq = e.this.cSq();
            if (cSq != null && cSq.ty() != null) {
                cSq.ty().b(e.this.jfy);
            }
        }
    };
    private View.OnTouchListener bTP = new View.OnTouchListener() { // from class: com.baidu.tieba.homepage.personalize.e.23
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (e.this.fAY != null) {
                e.this.fAY.onTouch(view, motionEvent);
            }
            if (e.this.jJI != null) {
                e.this.jJI.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private a.InterfaceC0727a iEb = new a.InterfaceC0727a() { // from class: com.baidu.tieba.homepage.personalize.e.30
        @Override // com.baidu.tieba.f.a.InterfaceC0727a
        public void G(int i, int i2) {
            e.this.jia = false;
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0727a
        public void H(int i, int i2) {
            e.this.jia = true;
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0727a
        public void cj(int i, int i2) {
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0727a
        public void I(int i, int i2) {
        }
    };
    private View.OnClickListener kfo = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.e.31
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (e.this.iOc != null) {
                e.this.iOc.hideTip();
            }
        }
    };
    private final CustomMessageListener kfp = new CustomMessageListener(CmdConfigCustom.CMD_RELOAD_HP_PERSONALIZED) { // from class: com.baidu.tieba.homepage.personalize.e.32
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (e.this.jlj != null) {
                e.this.iOh.cSp();
                e.this.kcO = false;
                e.this.jXd.setRefreshing(true);
            }
        }
    };
    private final CustomMessageListener kfq = new CustomMessageListener(2921461) { // from class: com.baidu.tieba.homepage.personalize.e.33
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (e.this.jlj != null) {
                e.this.cTg();
            }
        }
    };
    private final CustomMessageListener kfr = new CustomMessageListener(2921486) { // from class: com.baidu.tieba.homepage.personalize.e.34
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data = customResponsedMessage.getData();
            switch (data instanceof Integer ? ((Integer) data).intValue() : 0) {
                case 2:
                    new BdTopToast(e.this.mPageContext.getPageActivity(), 2000).yW(true).UX(e.this.mPageContext.getPageActivity().getString(R.string.youngster_open_title)).aR((ViewGroup) e.this.mPageContext.getPageActivity().findViewById(R.id.maintabContainer));
                    e.this.se(true);
                    return;
                case 3:
                    new BdTopToast(e.this.mPageContext.getPageActivity(), 2000).yW(true).UX(e.this.mPageContext.getPageActivity().getString(R.string.youngster_close_title)).aR((ViewGroup) e.this.mPageContext.getPageActivity().findViewById(R.id.maintabContainer));
                    e.this.se(false);
                    return;
                case 4:
                default:
                    if (com.baidu.tbadk.youngster.b.c.bME()) {
                        e.this.se(true);
                        return;
                    }
                    return;
                case 5:
                    new BdTopToast(e.this.mPageContext.getPageActivity(), 2000).yW(true).UX(e.this.mPageContext.getPageActivity().getString(R.string.youngster_reset_title)).aR((ViewGroup) e.this.mPageContext.getPageActivity().findViewById(R.id.maintabContainer));
                    e.this.se(true);
                    return;
            }
        }
    };
    private CustomMessageListener jCq = new CustomMessageListener(CmdConfigCustom.PB_ACTION_PRAISE) { // from class: com.baidu.tieba.homepage.personalize.e.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            bz bzVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bz) && e.this.keY != null && com.baidu.tbadk.core.util.x.getCount(e.this.keY.thread_list) != 0 && (bzVar = (bz) customResponsedMessage.getData()) != null && bzVar.brc() != null && bzVar.getId() != null && com.baidu.tbadk.core.util.x.getCount(e.this.keY.thread_list) != 0) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < e.this.keY.thread_list.size()) {
                        ThreadInfo threadInfo = e.this.keY.thread_list.get(i2);
                        if (threadInfo == null || threadInfo.id.longValue() != com.baidu.adp.lib.f.b.toLong(bzVar.getId(), -1L)) {
                            i = i2 + 1;
                        } else {
                            ThreadInfo.Builder builder = new ThreadInfo.Builder(threadInfo);
                            Zan.Builder builder2 = new Zan.Builder(builder.zan);
                            builder2.num = Integer.valueOf((int) bzVar.brc().getNum());
                            builder.zan = builder2.build(true);
                            e.this.keY.thread_list.set(i2, builder.build(true));
                            return;
                        }
                    } else {
                        return;
                    }
                }
            }
        }
    };
    private CustomMessageListener kfs = new CustomMessageListener(CmdConfigCustom.CMD_LIVE_VIDEO_CLOSED_QUERY_RESPONSED) { // from class: com.baidu.tieba.homepage.personalize.e.9
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
                        if ((originData.get(i2) instanceof bz) && (bzVar = (bz) originData.get(i2)) != null && bzVar.brK() != null && ids.contains(Long.valueOf(bzVar.brK().live_id))) {
                            e.this.mDataList.remove(bzVar);
                        }
                        i = i2 + 1;
                    }
                    if (e.this.kem != null) {
                        e.this.kem.cC(new ArrayList(e.this.mDataList));
                    }
                }
            }
        }
    };
    private CustomMessageListener fdd = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.homepage.personalize.e.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int intValue;
            if ((customResponsedMessage instanceof UpdateAttentionMessage) && e.this.keY != null && !com.baidu.tbadk.core.util.x.isEmpty(e.this.keY.thread_list)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid)) {
                    int i = 0;
                    while (true) {
                        if (i >= e.this.keY.thread_list.size()) {
                            break;
                        }
                        ThreadInfo threadInfo = e.this.keY.thread_list.get(i);
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
                            e.this.keY.thread_list.set(i, builder.build(true));
                        }
                    }
                    e.this.a(updateAttentionMessage);
                }
            }
        }
    };
    private CustomMessageListener jXu = new CustomMessageListener(0) { // from class: com.baidu.tieba.homepage.personalize.e.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long) && e.this.keY != null && e.this.keY.hot_recomforum != null && !com.baidu.tbadk.core.util.x.isEmpty(e.this.keY.hot_recomforum.tab_list)) {
                long longValue = ((Long) customResponsedMessage.getData()).longValue();
                DiscoverHotForum.Builder builder = new DiscoverHotForum.Builder(e.this.keY.hot_recomforum);
                if (com.baidu.tieba.homepage.concern.c.a(builder, longValue, customResponsedMessage.getCmd() == 2001335)) {
                    e.this.keY.hot_recomforum = builder.build(true);
                    e.this.c(new DataRes.Builder(e.this.keY.build(true)));
                }
            }
        }
    };
    private String kft = "lastReadReadPositionKey";
    private int kfu = 0;
    private d kfw = new d() { // from class: com.baidu.tieba.homepage.personalize.e.16
        @Override // com.baidu.tieba.homepage.personalize.d
        public void CT(final int i) {
            if (e.this.kfv == null) {
                e.this.kfv = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.e.16.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (e.this.jlj.getHandler() != null) {
                            e.this.jlj.requestFocusFromTouch();
                            if (i <= e.this.jlj.getCount() - 1) {
                                e.this.jlj.setSelection(i);
                            }
                        }
                    }
                };
            }
            e.this.jlj.removeCallbacks(e.this.kfv);
            e.this.jlj.post(e.this.kfv);
        }
    };
    private CustomMessageListener kfx = new CustomMessageListener(2016569) { // from class: com.baidu.tieba.homepage.personalize.e.19
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && e.this.kfg != null) {
                e.this.mDataList.remove(e.this.kfg);
                e.this.kem.cC(new ArrayList(e.this.mDataList));
                com.baidu.tbadk.core.sharedPref.b.bvr().putLong("key_maintab_banner_close_time", System.currentTimeMillis());
            }
        }
    };
    private CustomMessageListener iNW = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.homepage.personalize.e.20
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.g(customResponsedMessage);
            if (e.this.iOh != null && e.this.kcO) {
                e.this.iOh.b(e.this.jhq, e.this.gAO, e.this.jia, true);
            }
        }
    };
    private CustomMessageListener iNX = new CustomMessageListener(CmdConfigCustom.CMD_THREAD_NOT_EXIST_WHEN_ENTER_PB) { // from class: com.baidu.tieba.homepage.personalize.e.21
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.g(customResponsedMessage);
        }
    };
    private CustomMessageListener jom = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.homepage.personalize.e.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && e.this.keY != null && com.baidu.tbadk.core.util.x.getCount(e.this.keY.thread_list) != 0) {
                String str = (String) customResponsedMessage.getData();
                e.this.h(str, e.this.mDataList);
                e.this.Mw(str);
                if (e.this.kem != null) {
                    e.this.kem.cC(new ArrayList(e.this.mDataList));
                }
                if (e.this.iOh != null && e.this.kcO) {
                    e.this.iOh.b(e.this.jhq, e.this.gAO, e.this.jia, true);
                }
            }
        }
    };
    private CustomMessageListener jgX = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.homepage.personalize.e.24
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ThreadCardViewHolder cSq;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent)) {
                KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24 && (cSq = e.this.cSq()) != null && cSq.ty() != null) {
                    cSq.ty().b(new a.C0090a(3));
                }
            }
        }
    };
    private com.baidu.adp.framework.listener.a kfy = new com.baidu.adp.framework.listener.a(1003065, CmdConfigSocket.CMD_TOPIC_BLESS) { // from class: com.baidu.tieba.homepage.personalize.e.25
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
                        if ((nVar instanceof com.baidu.tieba.homepage.topic.topictab.b.a) && (bVar = ((com.baidu.tieba.homepage.topic.topictab.b.a) nVar).kmp) != null && longValue == bVar.pkId) {
                            bVar.userPkId = j2;
                            return;
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener jgY = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.homepage.personalize.e.26
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            List<n> dataList = e.this.kem.getDataList();
            if (!com.baidu.tbadk.core.util.x.isEmpty(dataList)) {
                for (n nVar : dataList) {
                    if (nVar instanceof k) {
                        k kVar = (k) nVar;
                        if (kVar.eSI != 0 && kVar.eMv != null) {
                            int[] imageWidthAndHeight = kVar.eMv.getImageWidthAndHeight();
                            kVar.eSI = imageWidthAndHeight[0];
                            kVar.eSJ = imageWidthAndHeight[1];
                        }
                    }
                }
            }
            com.baidu.adp.lib.f.e.mB().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.personalize.e.26.1
                @Override // java.lang.Runnable
                public void run() {
                    e.this.kem.notifyDataSetChanged();
                    if (!e.this.mIsBackground && e.this.kcO) {
                        e.this.iOh.b(e.this.jhq, e.this.gAO, e.this.jia, true);
                    }
                }
            }, 500L);
        }
    };
    private CustomMessageListener iNY = new CustomMessageListener(2921453) { // from class: com.baidu.tieba.homepage.personalize.e.27
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bh)) {
                bh bhVar = (bh) customResponsedMessage.getData();
                if (bhVar.eRE == 1) {
                    int equipmentWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst());
                    int equipmentHeight = l.getEquipmentHeight(TbadkCoreApplication.getInst());
                    float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
                    int i = au.bws().bwt() ? 2 : 1;
                    RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
                    requestGetMyPostNetMessage.setTag(e.this.kfm);
                    requestGetMyPostNetMessage.setParams(com.baidu.adp.lib.f.b.toLong(bhVar.tid, 0L), 0L, 0L, equipmentWidth, equipmentHeight, f, i);
                    requestGetMyPostNetMessage.setBFrom("push");
                    MessageManager.getInstance().sendMessage(requestGetMyPostNetMessage);
                }
            }
        }
    };
    private final com.baidu.adp.framework.listener.a iNZ = new com.baidu.adp.framework.listener.a(1003010, CmdConfigSocket.CMD_GET_MY_POST) { // from class: com.baidu.tieba.homepage.personalize.e.28
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            GetMyPostResIdl getMyPostResIdl = null;
            if (responsedMessage instanceof GetMyPostHttpResponseMessage) {
                getMyPostResIdl = ((GetMyPostHttpResponseMessage) responsedMessage).getResponseData();
            } else if (responsedMessage instanceof GetMyPostSocketResponseMessage) {
                getMyPostResIdl = ((GetMyPostSocketResponseMessage) responsedMessage).getResponseData();
            }
            if (getMyPostResIdl != null && getMyPostResIdl.data != null && getMyPostResIdl.data.thread_info != null) {
                e.this.kfn = getMyPostResIdl.data.thread_info;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921455));
            }
        }
    };
    private CustomMessageListener kfz = new CustomMessageListener(2921482) { // from class: com.baidu.tieba.homepage.personalize.e.29
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

        void cST();

        void onError(int i, String str);

        void sa(boolean z);
    }

    public void sb(boolean z) {
        this.kfh = z;
        if (this.iOc != null && !z) {
            this.iOc.hideTip();
        }
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.kea = scrollFragmentTabHost;
        if (this.kea != null) {
            this.kea.setOnTabSelectedListener(new ScrollFragmentTabHost.b() { // from class: com.baidu.tieba.homepage.personalize.e.1
                @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.b
                public void Dd(int i) {
                    if (e.this.kea.Dc(i) != 1 && e.this.iOc != null) {
                        e.this.iOc.hideTip();
                    }
                }
            });
        }
    }

    public void setTabInForeBackgroundState(boolean z) {
        this.mIsBackground = z;
    }

    public void qD(boolean z) {
        boolean z2 = false;
        this.mIsBackground = z;
        if (this.kea != null) {
            this.kea.qD(z);
        }
        if (this.iOh != null) {
            this.iOh.tE(!z);
            ThreadCardViewHolder cSq = cSq();
            if (cSq != null && cSq.ty() != null) {
                z2 = cSq.ty().b(new a.C0090a(8, Boolean.valueOf(z)));
            }
            if (!z2) {
                if (z) {
                    this.iOh.cSp();
                } else if (this.kcO) {
                    this.iOh.b(this.jhq, this.gAO, this.jia, true);
                }
            }
        }
    }

    public e(TbPageContext<?> tbPageContext, BdTypeRecyclerView bdTypeRecyclerView, ab abVar, BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout) {
        this.kfl = 0;
        this.mPageContext = tbPageContext;
        this.kfl = com.baidu.tbadk.core.sharedPref.b.bvr().getInt("key_personalized_refresh_type", 0);
        this.jXd = bigdaySwipeRefreshLayout;
        this.jlj = bdTypeRecyclerView;
        this.jlj.setOnTouchListener(this.bTP);
        if (com.baidu.tbadk.youngster.b.c.bME()) {
            se(true);
        }
        this.jJI = new com.baidu.tieba.f.a();
        this.jJI.a(this.iEb);
        this.kem = abVar;
        this.kfb = new com.baidu.tieba.homepage.personalize.model.a();
        this.keV = com.baidu.tbadk.core.sharedPref.b.bvr().getLong("recommend_frs_cache_time", 1800L) * 1000;
        bdTypeRecyclerView.setOnScrollListener(this.mOnScrollListener);
        this.iOc = new bb();
        cTe();
        this.iOh = new i(this.mPageContext, this.jlj);
        this.iOh.ID(1);
        this.iOh.IC(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.keW = new b(this.mDataList, this.kem);
        this.iOd = new SmartBubbleAnimatedView(tbPageContext.getContext());
        this.iOd.setLayoutParams(new FrameLayout.LayoutParams(-1, l.getDimens(tbPageContext.getContext(), R.dimen.tbds83)));
        cSU();
        this.jgY.setTag(this.mPageContext.getUniqueId());
        MessageManager.getInstance().registerListener(this.jgY);
        if (MessageManager.getInstance().findTask(1003010) == null) {
            HomePageStatic.cQy();
        }
        this.iNZ.setTag(this.kfm);
        if (this.iNZ.getHttpMessageListener() != null) {
            this.iNZ.getHttpMessageListener().setSelfListener(true);
        }
        if (this.iNZ.getSocketMessageListener() != null) {
            this.iNZ.getSocketMessageListener().setSelfListener(true);
        }
        MessageManager.getInstance().registerListener(this.iNZ);
        MessageManager.getInstance().registerListener(this.iNY);
        MessageManager.getInstance().registerListener(this.kfz);
    }

    private void cSU() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2016323, new CustomMessageTask.CustomRunnable<Boolean>() { // from class: com.baidu.tieba.homepage.personalize.e.35
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Boolean> customMessage) {
                ThreadCardViewHolder cSq = e.this.cSq();
                return (cSq == null || cSq.ty() == null) ? new CustomResponsedMessage<>(2016323, false) : new CustomResponsedMessage<>(2016323, Boolean.valueOf(cSq.ty().b(new a.C0090a(6))));
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private boolean cSV() {
        return com.baidu.tbadk.core.sharedPref.b.bvr().getBoolean(cSX(), true);
    }

    private void cSW() {
        com.baidu.tbadk.core.sharedPref.b.bvr().putBoolean(cSX(), false);
    }

    private String cSX() {
        return "key_rec_pfirst_load_" + TbadkCoreApplication.getCurrentAccount() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + TbConfig.getVersion();
    }

    public void setRecommendFrsNavigationAnimDispatcher(y yVar) {
        if (yVar != null) {
            this.fPF = yVar.bJe();
            this.fAY = yVar.bJf();
        }
    }

    public void showFloatingView() {
        if (this.fPF != null) {
            this.fPF.ld(true);
        }
    }

    public void update() {
        com.baidu.tieba.homepage.framework.a.cRj().G(System.currentTimeMillis(), 1);
        this.mPn = 1;
        this.kff = true;
        if (this.mDataList.size() == 0 && !cSV()) {
            if (!this.jXo) {
                boF();
                return;
            }
            return;
        }
        boE();
    }

    public void cG(int i, int i2) {
        bz bzVar;
        if (!com.baidu.tbadk.core.util.x.isEmpty(this.mDataList) && this.mDataList.size() > i) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            while (i < this.mDataList.size() && i <= i2) {
                if (this.mDataList.get(i).getType().getId() == bz.eTk.getId() && (bzVar = (bz) this.mDataList.get(i)) != null && bzVar.brK() != null) {
                    arrayList.add(Long.valueOf(bzVar.brK().live_id));
                    arrayList2.add(bzVar);
                }
                i++;
            }
            if (!com.baidu.tbadk.core.util.x.isEmpty(arrayList)) {
                MessageManager.getInstance().sendMessage(new LiveRoomClosedQueryMessage(arrayList, arrayList2));
            }
        }
    }

    public void cSY() {
        if (this.iOh != null && !this.mIsBackground && this.kcO) {
            this.iOh.b(this.jhq, this.gAO, this.jia, true);
        }
        if (this.kfd) {
            if (this.jXd != null && !this.jXd.bxU()) {
                if (this.jUI) {
                    com.baidu.tieba.s.c.dNY().b(this.kfj, false);
                    if (sd(false)) {
                        cH(3, this.kfa);
                    } else if (this.kfe > 0) {
                        cH(2, this.kfa);
                    }
                } else if (!this.jUI && this.kfa == 0) {
                    cH(2, 0);
                }
            }
            this.kfd = false;
            this.jUI = false;
            this.kfe = 0;
            if (this.kff) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
            }
            this.kff = false;
        }
    }

    public void bUq() {
        if (isLoading()) {
            com.baidu.tieba.homepage.framework.a.cRj().G(0L, 1);
        } else if (this.keX != null) {
            cTa();
            this.mPn++;
            setIsLoading(true);
            this.keX.I(this.mPn, (this.keY == null || this.keY.thread_list == null) ? 0 : this.keY.thread_list.size(), sc(false), 0);
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
            g.cTl();
        }
        if (this.kfb != null && this.kfb.cTE() && !z && (dataRes == null || com.baidu.tbadk.core.util.x.isEmpty(dataRes.thread_list))) {
            if (dataRes == null) {
                DataRes.Builder builder = new DataRes.Builder();
                builder.thread_list = new ArrayList();
                dataRes = builder.build(false);
            }
            if (dataRes.thread_list != null) {
                List<ThreadInfo> cTF = this.kfb.cTF();
                dataRes.thread_list.addAll(cTF);
                if (cTF != null) {
                    cTF.clear();
                }
                z3 = true;
                size = (this.keY != null || this.keY.thread_list == null) ? 0 : this.keY.thread_list.size();
                if (z && i == 0 && dataRes != null && com.baidu.tbadk.core.util.x.isEmpty(dataRes.thread_list)) {
                    if (this.keX != null) {
                        this.keX.cST();
                    }
                    setIsLoading(false);
                    if (this.jXd != null) {
                        this.jXd.setRefreshing(false);
                        return;
                    }
                    return;
                }
                if (this.kfn != null) {
                    DataRes.Builder builder2 = new DataRes.Builder(dataRes);
                    builder2.thread_list.add(0, this.kfn);
                    dataRes = builder2.build(false);
                    if (this.keY != null && !com.baidu.tbadk.core.util.x.isEmpty(this.keY.thread_list)) {
                        Iterator<ThreadInfo> it = this.keY.thread_list.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            ThreadInfo next = it.next();
                            if (next != null && next.tid != null && this.kfn.tid != null && next.tid.longValue() == this.kfn.tid.longValue()) {
                                this.keY.thread_list.remove(next);
                                break;
                            }
                        }
                    }
                    this.kfn = null;
                }
                if ((z3 && i != 0) || dataRes == null || !a(true, z, z2, dataRes)) {
                    this.kfd = false;
                    if (this.mDataList.size() > 0) {
                        if (this.keX != null) {
                            this.keX.onError(1, str);
                        }
                    } else if (this.keX != null) {
                        this.keX.onError(2, str);
                    }
                } else {
                    cSW();
                    if (this.keX != null) {
                        com.baidu.tbadk.core.sharedPref.b.bvr().putLong(SharedPrefConfig.RECOMMEND_FRS_REFRESH_TIME + TbadkCoreApplication.getCurrentAccount(), System.currentTimeMillis());
                        this.keX.sa(false);
                    }
                    this.kfd = true;
                    this.jUI = z;
                    this.kfe = size;
                    cyl();
                }
                setIsLoading(false);
                if (this.jXd == null) {
                    f.e cSZ = cSZ();
                    if (this.jXd.bxU() && cSZ != null) {
                        this.jXd.c(cSZ);
                        return;
                    } else {
                        this.jXd.setRefreshing(false);
                        return;
                    }
                }
                return;
            }
        }
        z3 = false;
        if (this.keY != null) {
        }
        if (z) {
        }
        if (this.kfn != null) {
        }
        if (z3) {
        }
        cSW();
        if (this.keX != null) {
        }
        this.kfd = true;
        this.jUI = z;
        this.kfe = size;
        cyl();
        setIsLoading(false);
        if (this.jXd == null) {
        }
    }

    private f.e cSZ() {
        int i;
        String feedText;
        if (!this.kfd || this.jXd == null || !this.jXd.bxU() || cTd()) {
            return null;
        }
        int i2 = this.kfa;
        if (this.jUI) {
            com.baidu.tieba.s.c.dNY().b(this.kfj, false);
            if (sd(false)) {
                i = 3;
            } else {
                i = this.kfe > 0 ? 2 : 0;
            }
        } else if (this.jUI || this.kfa != 0) {
            return null;
        } else {
            i2 = 0;
            i = 2;
        }
        if (this.kea != null) {
            this.iOc.cHw();
        }
        if (this.kea != null && this.kea.getCurrentTabType() != 1) {
            this.iOc.hideTip();
            return null;
        } else if (!this.kfh) {
            this.iOc.hideTip();
            return null;
        } else {
            this.keZ = i;
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
                this.jkp = 1000;
            } else {
                this.jkp = 0;
            }
            return new f.e(feedText, this.jkp);
        }
    }

    public void rN(boolean z) {
        if (z) {
            this.kem.notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        if (this.iOh != null) {
            this.iOh.destroy();
        }
        if (this.iOc != null) {
            this.iOc.onDestroy();
        }
        if (this.keW != null) {
            this.keW.onDestroy();
        }
        if (this.jlj != null) {
            this.jlj.removeCallbacks(this.kfv);
        }
        MessageManager.getInstance().unRegisterTask(2016323);
        MessageManager.getInstance().unRegisterListener(this.jgY);
        MessageManager.getInstance().unRegisterListener(this.iNY);
        MessageManager.getInstance().unRegisterListener(this.iNZ);
        MessageManager.getInstance().unRegisterListener(this.kfz);
    }

    public void onPause() {
        c.i(this.jlj);
        Dl(this.kfu);
        if (this.kfc != null) {
            this.kfc.bHA();
        }
    }

    private void boE() {
        if (this.keX != null) {
            this.keX.V((this.keY == null || this.keY.thread_list == null || cTc()) ? 0 : this.keY.thread_list.size(), sc(true), 0);
        }
    }

    public int sc(boolean z) {
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
                if (!(nVar instanceof com.baidu.tieba.homepage.personalize.data.a) || nVar.getType() == AdvertAppInfo.eNF) {
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
                if ((nVar2 instanceof com.baidu.tieba.homepage.personalize.data.a) && nVar2.getType() != AdvertAppInfo.eNF) {
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
        this.jXo = true;
        if (dataRes != null) {
            if (a(false, true, true, dataRes) && !cTc()) {
                if (this.keX != null) {
                    this.keX.sa(true);
                    Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler() { // from class: com.baidu.tieba.homepage.personalize.e.2
                        @Override // android.os.MessageQueue.IdleHandler
                        public boolean queueIdle() {
                            e.this.bHD();
                            return false;
                        }
                    });
                }
                if (TbSingleton.getInstance().getForceRefreshHomeRecommend()) {
                    boE();
                    TbSingleton.getInstance().setForceRefreshHomeRecommend(false);
                    return;
                }
                return;
            }
            boE();
            return;
        }
        boE();
    }

    public void bHD() {
        com.baidu.tbadk.n.l.bHL().ev(System.currentTimeMillis() - com.baidu.tbadk.n.l.bHL().bHK());
    }

    private void i(List<n> list, int i) {
        Set<n> a2 = com.baidu.tieba.recapp.a.a(list, this.mPn, "NEWINDEX");
        if (a2.size() > 0) {
            com.baidu.tieba.s.c.dNY().b(this.kfj, com.baidu.tieba.s.a.b(PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE, "common_fill", true, a2.size()));
        }
    }

    private boolean a(boolean z, boolean z2, boolean z3, DataRes dataRes) {
        boolean z4;
        if (dataRes == null) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.kfl == 1) {
            if (z2 && (dataRes.thread_list.size() >= 6 || cTc())) {
                cTb();
                this.keY = null;
            }
        } else if (z2 && cTc()) {
            this.keY = null;
        }
        int size = z2 ? 0 : this.mDataList.size();
        DataRes.Builder builder = new DataRes.Builder(dataRes);
        this.mDataList.clear();
        com.baidu.tieba.homepage.personalize.model.c a2 = this.kfb.a(z, this.keY, builder, z2 ? 0 : 1);
        List<n> list = null;
        int i = 0;
        if (a2 != null) {
            list = a2.geK;
            this.kfa = a2.kih;
            i = a2.kii;
            a2.kii = 0;
        }
        int i2 = i;
        if (list != null) {
            this.mDataList.addAll(list);
            i(list, size);
            a(z2 ? 0 : 1, list, size);
            if (this.kff) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
            }
        }
        if (this.keY == null) {
            this.keY = builder;
            this.keW.ed(this.keY.thread_list);
        }
        if (this.mDataList.size() == 0) {
            z4 = false;
        } else {
            if (z2) {
                if (dataRes.live_answer != null) {
                    this.kfg = new h();
                    this.kfg.a(dataRes.live_answer);
                    this.keY.live_answer = dataRes.live_answer;
                } else if (z) {
                    this.kfg = null;
                    this.keY.live_answer = null;
                }
                this.kfi = dataRes.float_info;
                this.keY.float_info = dataRes.float_info;
            }
            long j = com.baidu.tbadk.core.sharedPref.b.bvr().getLong("key_maintab_banner_close_time", 0L);
            if (this.kfg != null && !at.isTaday(j)) {
                this.mDataList.add(0, this.kfg);
            }
            LinkedList linkedList = new LinkedList(this.mDataList);
            this.kem.setFromCDN(dataRes.is_new_url != null && dataRes.is_new_url.intValue() == 1);
            this.kem.j(linkedList, i2);
            z4 = true;
            if (this.iOh != null && this.kcO) {
                this.iOh.b(this.jhq, this.gAO, this.jia, true);
            }
        }
        com.baidu.tieba.homepage.framework.a.cRj().E(System.currentTimeMillis() - currentTimeMillis, 1);
        long CS = com.baidu.tieba.homepage.framework.a.cRj().CS(1);
        if (CS > 0) {
            com.baidu.tieba.homepage.framework.a.cRj().F(System.currentTimeMillis() - CS, 1);
            com.baidu.tieba.homepage.framework.a.cRj().G(0L, 1);
        }
        if (dataRes.anti != null && dataRes.anti.block_pop_info != null) {
            com.baidu.tieba.ueg.d.d(dataRes.anti.block_pop_info);
        }
        bj bjVar = new bj();
        bjVar.a(dataRes.recom_post_topic);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_REFRESH_TOPIC_TIP, bjVar));
        if (!z && CS > 0) {
            com.baidu.tbadk.n.l.bHL().eH(System.currentTimeMillis() - CS);
            return z4;
        }
        return z4;
    }

    private void cTa() {
        int i;
        List<n> list = null;
        if (com.baidu.tbadk.core.util.x.getCount(this.mDataList) >= this.kfb.cTA() - 40) {
            com.baidu.tieba.homepage.personalize.model.c a2 = this.kfb.a(true, this.keY, null, 1);
            if (a2 != null) {
                list = a2.geK;
                i = a2.kii;
                a2.kii = 0;
            } else {
                i = 0;
            }
            if (list != null) {
                this.mDataList.clear();
                this.mDataList.addAll(list);
                this.kem.j(new LinkedList(this.mDataList), i);
            }
        }
    }

    private void boF() {
        this.jXo = true;
        ac.a(new com.baidu.tbadk.util.ab<DataRes>() { // from class: com.baidu.tieba.homepage.personalize.e.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.ab
            /* renamed from: cTh */
            public DataRes doInBackground() {
                com.baidu.adp.lib.cache.l<byte[]> dL = com.baidu.tbadk.core.c.a.btT().dL("tb.rec_frs_update", TbadkCoreApplication.getCurrentAccount());
                if (dL == null) {
                    return null;
                }
                byte[] bArr = dL.get("0");
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

    private void cyl() {
        if (this.keY != null) {
            DataRes.Builder builder = new DataRes.Builder(this.keY.build(true));
            if (builder.thread_list != null && builder.thread_list.size() > 30) {
                builder.thread_list = builder.thread_list.subList(0, 30);
            }
            a(builder, builder.thread_list != null ? builder.thread_list.size() : 0);
            a(builder);
            b(builder);
            c(builder);
        }
    }

    private void cTb() {
        if (this.keY != null) {
            final DataRes.Builder builder = new DataRes.Builder(this.keY.build(true));
            if (builder.thread_list != null && builder.thread_list.size() > 50) {
                builder.thread_list = builder.thread_list.subList(0, 50);
            }
            a(builder, builder.thread_list != null ? builder.thread_list.size() : 0);
            ac.a(new com.baidu.tbadk.util.ab<Object>() { // from class: com.baidu.tieba.homepage.personalize.e.5
                @Override // com.baidu.tbadk.util.ab
                public Object doInBackground() {
                    DataRes.Builder builder2 = new DataRes.Builder(builder.build(true));
                    e.this.keW.ee(builder2.thread_list);
                    try {
                        com.baidu.tbadk.core.c.a.btT().dL("tb.rec_old_data", TbadkCoreApplication.getCurrentAccount()).setForever("0", builder2.build(true).toByteArray());
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
    public void Mw(String str) {
        if (!TextUtils.isEmpty(str) && this.keY != null && this.keY.banner_list != null && this.keY.banner_list.app != null && this.keY.banner_list.app.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (App app : this.keY.banner_list.app) {
                if (app != null && str.equals(app.id)) {
                    arrayList.add(app);
                }
            }
            BannerList.Builder builder = new BannerList.Builder(this.keY.banner_list);
            if (builder.app != null) {
                builder.app.removeAll(arrayList);
            }
            this.keY.banner_list = builder.build(false);
            DataRes.Builder builder2 = new DataRes.Builder(this.keY.build(true));
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
                e.this.keW.ee(builder2.thread_list);
                try {
                    com.baidu.tbadk.core.c.a.btT().dL("tb.rec_frs_update", TbadkCoreApplication.getCurrentAccount()).setForever("0", builder2.build(true).toByteArray());
                    return null;
                } catch (Exception e) {
                    BdLog.e(e);
                    return null;
                }
            }
        }, null);
    }

    private boolean cTc() {
        return sd(true);
    }

    private boolean sd(boolean z) {
        long j = com.baidu.tbadk.core.sharedPref.b.bvr().getLong(SharedPrefConfig.RECOMMEND_FRS_REFRESH_TIME + TbadkCoreApplication.getCurrentAccount(), 0L);
        return j == 0 ? z : Math.abs(System.currentTimeMillis() - j) > this.keV;
    }

    public void a(a aVar) {
        this.keX = aVar;
    }

    private boolean isLoading() {
        return this.mIsLoading;
    }

    private void setIsLoading(boolean z) {
        this.mIsLoading = z;
    }

    public void cSO() {
        boolean z = true;
        com.baidu.tbadk.coreExtra.data.b activityPrizeData = TbadkCoreApplication.getInst().getActivityPrizeData();
        if (activityPrizeData.isSwitchTurn() && !StringUtils.isNull(activityPrizeData.getFeedText())) {
            String currentDay = UtilHelper.getCurrentDay();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            String str = "";
            if (!StringUtils.isNull(currentAccount)) {
                String string = com.baidu.tbadk.core.sharedPref.b.bvr().getString(SharedPrefConfig.ACTIVITY_PRIZE_FEED_TEXT_TIME, "");
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
                    com.baidu.tbadk.core.sharedPref.b.bvr().putString(SharedPrefConfig.ACTIVITY_PRIZE_FEED_TEXT_TIME, str);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void se(boolean z) {
        boolean z2 = com.baidu.tbadk.core.sharedPref.b.bvr().getBoolean("key_youngster_homgpage_top_view_closed", false);
        if (this.jlj != null && !z2) {
            if (z) {
                if (this.kfk == null) {
                    this.kfk = new HomePageYoungsterTopView(this.mPageContext);
                    this.kfk.setOnDeleteClick(new HomePageYoungsterTopView.a() { // from class: com.baidu.tieba.homepage.personalize.e.7
                        @Override // com.baidu.tieba.homepage.personalize.view.HomePageYoungsterTopView.a
                        public void cTi() {
                            new BdTopToast(e.this.mPageContext.getPageActivity(), 2000).yW(true).UX(e.this.mPageContext.getPageActivity().getString(R.string.youngster_frs_top_toast)).aR((ViewGroup) e.this.mPageContext.getPageActivity().findViewById(R.id.maintabContainer));
                            e.this.se(false);
                            com.baidu.tbadk.core.sharedPref.b.bvr().putBoolean("key_youngster_homgpage_top_view_closed", true);
                        }
                    });
                }
                this.jlj.setHeaderView(this.kfk, false);
                this.kfk.setVisibility(0);
                this.jlj.scrollToPosition(0);
            } else if (this.kfk != null) {
                this.kfk.setVisibility(8);
                this.jlj.removeHeaderView(this.kfk);
                this.kfk = null;
            }
        }
    }

    private boolean cTd() {
        return this.kfk != null && this.kfk.getVisibility() == 0;
    }

    private void cH(int i, int i2) {
        if (!cTd()) {
            if (this.kea != null) {
                this.iOc.cHw();
            }
            if (this.kea != null && this.kea.getCurrentTabType() != 1) {
                this.iOc.hideTip();
            } else if (!this.kfh) {
                this.iOc.hideTip();
            } else {
                this.keZ = i;
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
                        this.jkp = 3000;
                    } else {
                        this.jkp = 2000;
                    }
                    this.iOd.fme = str;
                    this.iOd.jki = this.jkp;
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 49;
                    if (this.kea != null) {
                        FrameLayout frameLayout = this.kea.getFrameLayout();
                        frameLayout.removeView(this.iOd);
                        frameLayout.addView(this.iOd, layoutParams);
                        this.iOd.cHu();
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(Long l) {
        if (this.keY != null && this.keY.thread_list != null) {
            List<ThreadInfo> list = this.keY.thread_list;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                ThreadInfo threadInfo = list.get(i);
                if (threadInfo.tid.equals(l) && threadInfo.top_agree_post != null) {
                    ThreadInfo.Builder builder = new ThreadInfo.Builder(threadInfo);
                    builder.top_agree_post = null;
                    list.set(i, builder.build(true));
                    cyl();
                    a(false, true, false, this.keY.build(true));
                    return;
                }
            }
        }
    }

    public void o(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.kfj = bdUniqueId;
            if (this.jCq != null) {
                this.jCq.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.jCq);
            }
            if (this.kfp != null) {
                this.kfp.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.kfp);
            }
            this.kfq.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.kfq);
            this.fdd.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.fdd);
            this.jXu.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_LIKE_FORUM, this.jXu);
            MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_UNLIKE_FORUM, this.jXu);
            this.kfs.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.kfs);
            this.iNW.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.iNW);
            this.iNX.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.iNX);
            this.jom.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.jom);
            if (this.iOh != null) {
                this.iOh.setUniqueId(bdUniqueId);
            }
            this.keW.l(bdUniqueId);
            this.kfx.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.kfx);
            this.jgX.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.jgX);
            this.kfy.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.kfy);
            this.kfr.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.kfr);
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
                        com.baidu.adp.lib.cache.l<byte[]> dL = com.baidu.tbadk.core.c.a.btT().dL("tb.rec_frs_update", TbadkCoreApplication.getCurrentAccount());
                        if (dL == null) {
                            return false;
                        }
                        byte[] bArr = dL.get("0");
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
                        e.this.keW.ee(builder5.thread_list);
                        dL.setForever("0", builder5.build(true).toByteArray());
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

    public void cTe() {
        this.jfe = new com.baidu.tieba.tbadkCore.data.f("new_index", null);
        this.jfe.dOH();
    }

    public void a(int i, List<n> list, int i2) {
        int i3;
        int i4;
        if (this.jfe != null) {
            if (i == 0) {
                this.jfe.dOH();
            }
            if (list != null && !list.isEmpty()) {
                int[] iArr = com.baidu.tieba.tbadkCore.data.f.nqR;
                int i5 = 0;
                int i6 = 0;
                int i7 = 0;
                while (i7 < list.size() && i6 < iArr.length && (i3 = iArr[i6]) >= 0) {
                    if (list.get(i7) instanceof com.baidu.tieba.card.data.b) {
                        i4 = i5 + 1;
                        if (i4 == i3 - 1) {
                            if (i2 < i7 + 1) {
                                this.jfe.du(i3, i7 + 1);
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

    public void Dk(int i) {
        if ((this.jfe != null ? this.jfe.KO(i) : -1) >= 0 && this.jlj != null && this.jlj.getData() != null && this.jlj.getData().size() > i) {
            this.jfe.KP(i);
        }
    }

    public i cGe() {
        return this.iOh;
    }

    public void rW(boolean z) {
        this.kcO = z;
    }

    public void Dl(final int i) {
        ac.a(new com.baidu.tbadk.util.ab<Object>() { // from class: com.baidu.tieba.homepage.personalize.e.15
            @Override // com.baidu.tbadk.util.ab
            public Object doInBackground() {
                com.baidu.adp.lib.cache.l<String> dM = com.baidu.tbadk.core.c.a.btT().dM(e.this.kft, TbadkCoreApplication.getCurrentAccount());
                if (dM != null) {
                    dM.set(e.this.kft, Integer.toString(i), 43200000L);
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
            /* renamed from: cTj */
            public String doInBackground() {
                com.baidu.adp.lib.cache.l<String> dM = com.baidu.tbadk.core.c.a.btT().dM(e.this.kft, TbadkCoreApplication.getCurrentAccount());
                if (dM != null) {
                    return dM.get(e.this.kft);
                }
                return null;
            }
        }, new com.baidu.tbadk.util.l<String>() { // from class: com.baidu.tieba.homepage.personalize.e.18
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.l
            /* renamed from: Mx */
            public void onReturnDataInUI(String str) {
                if (dVar != null) {
                    dVar.CT(com.baidu.adp.lib.f.b.toInt(str, 0));
                }
            }
        });
    }

    public void cSR() {
        c.j(this.jlj);
    }

    public void cTf() {
        a(this.kfw);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cTg() {
        Iterator<n> it = this.mDataList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            } else if (it.next() instanceof com.baidu.tieba.homepage.personalize.data.g) {
                it.remove();
                break;
            }
        }
        if (this.keY != null) {
            this.keY.active_center = null;
            cyl();
            if (this.jlj != null) {
                List<Integer> k = k(this.jlj);
                int intValue = k.get(0).intValue();
                int intValue2 = k.get(1).intValue();
                if (intValue != -1 && intValue2 != -1) {
                    this.jlj.p(intValue, intValue2);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(CustomResponsedMessage<?> customResponsedMessage) {
        boolean z;
        String str;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.keY != null && com.baidu.tbadk.core.util.x.getCount(this.keY.thread_list) != 0 && com.baidu.tbadk.core.util.x.getCount(this.mDataList) != 0) {
            JSONObject jSONObject = (JSONObject) customResponsedMessage.getData();
            String optString = jSONObject.optString("tid");
            if (StringUtils.isNull(optString)) {
                String optString2 = jSONObject.optString(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_ID);
                if (this.jlj != null && !TextUtils.isEmpty(optString2)) {
                    int i = 0;
                    while (true) {
                        if (i >= this.jlj.getCount()) {
                            str = optString;
                            break;
                        }
                        n item = this.jlj.getItem(i);
                        if (item instanceof com.baidu.tieba.card.data.j) {
                            com.baidu.tieba.card.data.j jVar = (com.baidu.tieba.card.data.j) item;
                            if (jVar.boP() != null && jVar.boP().brK() != null && optString2.equals(String.valueOf(jVar.boP().brK().live_id))) {
                                str = jVar.boP().getTid();
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
                    if (bVar.boP() != null && bVar.boP().getTid() != null) {
                        if (bVar.boP().getTid().equals(optString)) {
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
            if (this.keY != null && this.keY.thread_list != null) {
                long j = com.baidu.adp.lib.f.b.toLong(optString, 0L);
                int i2 = 0;
                while (true) {
                    if (i2 < this.keY.thread_list.size()) {
                        ThreadInfo threadInfo = this.keY.thread_list.get(i2);
                        if (threadInfo == null || threadInfo.tid == null || threadInfo.tid.longValue() != j) {
                            i2++;
                        } else {
                            com.baidu.tieba.homepage.personalize.readProgressBar.c.a(threadInfo.tid.longValue(), i2, this.keY.thread_list, this.mDataList);
                            this.keY.thread_list.remove(i2);
                            cyl();
                            break;
                        }
                    } else {
                        break;
                    }
                }
                if (this.jlj != null) {
                    List<Integer> b2 = b(optString, this.jlj);
                    int intValue = b2.get(0).intValue();
                    int intValue2 = b2.get(1).intValue();
                    if (intValue != -1 && intValue2 != -1) {
                        this.jlj.p(intValue, intValue2);
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
                    if (bVar.boP() != null && bVar.boP().getTid().equals(str)) {
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
                    advertAppInfo = ((com.baidu.tieba.homepage.personalize.data.a) next).cvy();
                } else {
                    if (next instanceof am) {
                        am amVar = (am) next;
                        if (amVar.bpG() instanceof AdvertAppInfo.ILegoAdvert) {
                            advertAppInfo = ((AdvertAppInfo.ILegoAdvert) amVar.bpG()).getAdvertAppInfo();
                        }
                    }
                    advertAppInfo = advertAppInfo2;
                }
                if (advertAppInfo != null && str.equals(advertAppInfo.eNT)) {
                    it.remove();
                    advertAppInfo = null;
                }
                advertAppInfo2 = advertAppInfo;
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (this.iOd != null) {
            this.iOd.onChangeSkinType(i);
        }
        if (this.kfk != null) {
            this.kfk.onChangeSkinType();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ThreadCardViewHolder cSq() {
        if (this.iOh == null || this.iOh.dBF() == null || !(this.iOh.dBF().getTag() instanceof ThreadCardViewHolder)) {
            return null;
        }
        return (ThreadCardViewHolder) this.iOh.dBF().getTag();
    }
}
