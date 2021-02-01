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
import com.baidu.tbadk.core.data.an;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tbadk.util.aa;
import com.baidu.tbadk.util.ae;
import com.baidu.tbadk.util.af;
import com.baidu.tbadk.util.m;
import com.baidu.tbadk.util.z;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.LiveRoomClosedQueryMessage;
import com.baidu.tieba.card.data.k;
import com.baidu.tieba.card.t;
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
    private z fNk;
    private View.OnTouchListener fyG;
    private bb iPd;
    private SmartBubbleAnimatedView iPe;
    private i iPi;
    private com.baidu.tieba.f.a jKG;
    private boolean jXF;
    private final BigdaySwipeRefreshLayout jZZ;
    private com.baidu.tieba.tbadkCore.data.f jgd;
    private final BdTypeRecyclerView jmj;
    private ScrollFragmentTabHost khC;
    private final ab khO;
    private final b kiA;
    private DataRes.Builder kiC;
    private final com.baidu.tieba.homepage.personalize.model.a kiF;
    private int kiI;
    private h kiK;
    private BdUniqueId kiN;
    private HomePageYoungsterTopView kiO;
    private int kiP;
    private Runnable kiZ;
    private final long kiz;
    private final TbPageContext<?> mPageContext;
    private a kiB = null;
    private final List<n> mDataList = new LinkedList();
    private int mPn = 1;
    private boolean mIsLoading = false;
    private boolean kak = false;
    private int kiD = 2;
    private int kiE = 0;
    private TextView mTipView = null;
    private int jlp = 2000;
    private com.baidu.tbadk.n.c kiG = null;
    private boolean jja = false;
    private int jiq = 0;
    private int gyR = 0;
    private boolean mIsBackground = false;
    private boolean kfL = true;
    private boolean kiH = false;
    private boolean kiJ = false;
    private boolean kiL = true;
    private FloatInfo kiM = null;
    private BdUniqueId kiQ = BdUniqueId.gen();
    private a.C0089a jgx = new a.C0089a(2);
    private ThreadInfo kiR = null;
    private RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.e.12
        private int kjg = -1;
        private int kav = 0;
        private boolean kjh = false;

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (e.this.kiG == null) {
                e.this.kiG = new com.baidu.tbadk.n.c();
                e.this.kiG.setSubType(1005);
                e.this.kiG.pageType = 1;
            }
            if (e.this.fNk != null && !e.this.mIsBackground) {
                e.this.fNk.q(recyclerView, i);
            }
            if (i == 0) {
                c.i(e.this.jmj);
                e.this.kiG.bDZ();
                t.csu().mG(true);
                com.baidu.tieba.a.d.bKP().dK("page_recommend", "show_");
                com.baidu.tieba.s.c.dMr().b(e.this.kiN, false);
                this.kjh = false;
                if (e.this.iPi != null && e.this.kfL && !e.this.mIsBackground) {
                    e.this.iPi.a(e.this.jiq, e.this.gyR, e.this.jja, 1);
                    return;
                }
                return;
            }
            e.this.kiG.bDY();
            if (i == 1) {
                if (e.this.iPd != null) {
                    e.this.iPd.hideTip();
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
            if (this.kav > i) {
                this.kjh = true;
            }
            if (e.this.fNk != null && !e.this.mIsBackground) {
                e.this.fNk.onScroll(this.kav, i);
            }
            this.kav = i;
            int i3 = (i + i2) - 1;
            if (!this.kjh && this.kjg != i3) {
                this.kjg = i3;
                e.this.BV(this.kjg);
            }
            if (this.kjh && this.kjg != i) {
                this.kjg = i;
                e.this.BV(this.kjg);
            }
            e.this.kiY = i;
            e.this.jiq = i;
            e.this.gyR = (i + i2) - 1;
            ThreadCardViewHolder cQv = e.this.cQv();
            if (cQv != null && cQv.tj() != null) {
                cQv.tj().b(e.this.jgx);
            }
        }
    };
    private View.OnTouchListener bST = new View.OnTouchListener() { // from class: com.baidu.tieba.homepage.personalize.e.23
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (e.this.fyG != null) {
                e.this.fyG.onTouch(view, motionEvent);
            }
            if (e.this.jKG != null) {
                e.this.jKG.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private a.InterfaceC0710a iFe = new a.InterfaceC0710a() { // from class: com.baidu.tieba.homepage.personalize.e.30
        @Override // com.baidu.tieba.f.a.InterfaceC0710a
        public void G(int i, int i2) {
            e.this.jja = false;
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0710a
        public void H(int i, int i2) {
            e.this.jja = true;
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0710a
        public void cg(int i, int i2) {
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0710a
        public void I(int i, int i2) {
        }
    };
    private View.OnClickListener kiS = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.e.31
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (e.this.iPd != null) {
                e.this.iPd.hideTip();
            }
        }
    };
    private final CustomMessageListener kiT = new CustomMessageListener(CmdConfigCustom.CMD_RELOAD_HP_PERSONALIZED) { // from class: com.baidu.tieba.homepage.personalize.e.32
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (e.this.jmj != null) {
                e.this.iPi.cQu();
                e.this.kfL = false;
                e.this.jZZ.setRefreshing(true);
            }
        }
    };
    private final CustomMessageListener kiU = new CustomMessageListener(2921461) { // from class: com.baidu.tieba.homepage.personalize.e.33
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (e.this.jmj != null) {
                e.this.cRn();
            }
        }
    };
    private final CustomMessageListener kiV = new CustomMessageListener(2921486) { // from class: com.baidu.tieba.homepage.personalize.e.34
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data = customResponsedMessage.getData();
            switch (data instanceof Integer ? ((Integer) data).intValue() : 0) {
                case 2:
                    new BdTopToast(e.this.mPageContext.getPageActivity(), 2000).zn(true).UN(e.this.mPageContext.getPageActivity().getString(R.string.youngster_open_title)).aR((ViewGroup) e.this.mPageContext.getPageActivity().findViewById(R.id.maintabContainer));
                    e.this.sn(true);
                    return;
                case 3:
                    new BdTopToast(e.this.mPageContext.getPageActivity(), 2000).zn(true).UN(e.this.mPageContext.getPageActivity().getString(R.string.youngster_close_title)).aR((ViewGroup) e.this.mPageContext.getPageActivity().findViewById(R.id.maintabContainer));
                    e.this.sn(false);
                    return;
                case 4:
                default:
                    if (com.baidu.tbadk.youngster.b.c.bJf()) {
                        e.this.sn(true);
                        return;
                    }
                    return;
                case 5:
                    new BdTopToast(e.this.mPageContext.getPageActivity(), 2000).zn(true).UN(e.this.mPageContext.getPageActivity().getString(R.string.youngster_reset_title)).aR((ViewGroup) e.this.mPageContext.getPageActivity().findViewById(R.id.maintabContainer));
                    e.this.sn(true);
                    return;
            }
        }
    };
    private CustomMessageListener jDq = new CustomMessageListener(CmdConfigCustom.PB_ACTION_PRAISE) { // from class: com.baidu.tieba.homepage.personalize.e.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            cb cbVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof cb) && e.this.kiC != null && y.getCount(e.this.kiC.thread_list) != 0 && (cbVar = (cb) customResponsedMessage.getData()) != null && cbVar.bnB() != null && cbVar.getId() != null && y.getCount(e.this.kiC.thread_list) != 0) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < e.this.kiC.thread_list.size()) {
                        ThreadInfo threadInfo = e.this.kiC.thread_list.get(i2);
                        if (threadInfo == null || threadInfo.id.longValue() != com.baidu.adp.lib.f.b.toLong(cbVar.getId(), -1L)) {
                            i = i2 + 1;
                        } else {
                            ThreadInfo.Builder builder = new ThreadInfo.Builder(threadInfo);
                            Zan.Builder builder2 = new Zan.Builder(builder.zan);
                            builder2.num = Integer.valueOf((int) cbVar.bnB().getNum());
                            builder.zan = builder2.build(true);
                            e.this.kiC.thread_list.set(i2, builder.build(true));
                            return;
                        }
                    } else {
                        return;
                    }
                }
            }
        }
    };
    private CustomMessageListener kiW = new CustomMessageListener(CmdConfigCustom.CMD_LIVE_VIDEO_CLOSED_QUERY_RESPONSED) { // from class: com.baidu.tieba.homepage.personalize.e.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            cb cbVar;
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
                        if ((originData.get(i2) instanceof cb) && (cbVar = (cb) originData.get(i2)) != null && cbVar.boj() != null && ids.contains(Long.valueOf(cbVar.boj().live_id))) {
                            e.this.mDataList.remove(cbVar);
                        }
                        i = i2 + 1;
                    }
                    if (e.this.khO != null) {
                        e.this.khO.cx(new ArrayList(e.this.mDataList));
                    }
                }
            }
        }
    };
    private CustomMessageListener faJ = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.homepage.personalize.e.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int intValue;
            if ((customResponsedMessage instanceof UpdateAttentionMessage) && e.this.kiC != null && !y.isEmpty(e.this.kiC.thread_list)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid)) {
                    int i = 0;
                    while (true) {
                        if (i >= e.this.kiC.thread_list.size()) {
                            break;
                        }
                        ThreadInfo threadInfo = e.this.kiC.thread_list.get(i);
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
                            e.this.kiC.thread_list.set(i, builder.build(true));
                        }
                    }
                    e.this.a(updateAttentionMessage);
                }
            }
        }
    };
    private CustomMessageListener kaq = new CustomMessageListener(0) { // from class: com.baidu.tieba.homepage.personalize.e.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long) && e.this.kiC != null && e.this.kiC.hot_recomforum != null && !y.isEmpty(e.this.kiC.hot_recomforum.tab_list)) {
                long longValue = ((Long) customResponsedMessage.getData()).longValue();
                DiscoverHotForum.Builder builder = new DiscoverHotForum.Builder(e.this.kiC.hot_recomforum);
                if (com.baidu.tieba.homepage.concern.c.a(builder, longValue, customResponsedMessage.getCmd() == 2001335)) {
                    e.this.kiC.hot_recomforum = builder.build(true);
                    e.this.c(new DataRes.Builder(e.this.kiC.build(true)));
                }
            }
        }
    };
    private String kiX = "lastReadReadPositionKey";
    private int kiY = 0;
    private d kja = new d() { // from class: com.baidu.tieba.homepage.personalize.e.16
        @Override // com.baidu.tieba.homepage.personalize.d
        public void BC(final int i) {
            if (e.this.kiZ == null) {
                e.this.kiZ = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.e.16.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (e.this.jmj.getHandler() != null) {
                            e.this.jmj.requestFocusFromTouch();
                            if (i <= e.this.jmj.getCount() - 1) {
                                e.this.jmj.setSelection(i);
                            }
                        }
                    }
                };
            }
            e.this.jmj.removeCallbacks(e.this.kiZ);
            e.this.jmj.post(e.this.kiZ);
        }
    };
    private CustomMessageListener kjb = new CustomMessageListener(2016569) { // from class: com.baidu.tieba.homepage.personalize.e.19
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && e.this.kiK != null) {
                TbSingleton.getInstance().isAddBanner = false;
                e.this.mDataList.remove(e.this.kiK);
                e.this.khO.cx(new ArrayList(e.this.mDataList));
                com.baidu.tbadk.core.sharedPref.b.brQ().putLong("key_maintab_banner_close_time", System.currentTimeMillis());
            }
        }
    };
    private CustomMessageListener iOX = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.homepage.personalize.e.20
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.g(customResponsedMessage);
            if (e.this.iPi != null && e.this.kfL) {
                e.this.iPi.b(e.this.jiq, e.this.gyR, e.this.jja, true);
            }
        }
    };
    private CustomMessageListener iOY = new CustomMessageListener(CmdConfigCustom.CMD_THREAD_NOT_EXIST_WHEN_ENTER_PB) { // from class: com.baidu.tieba.homepage.personalize.e.21
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.g(customResponsedMessage);
        }
    };
    private CustomMessageListener jpm = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.homepage.personalize.e.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && e.this.kiC != null && y.getCount(e.this.kiC.thread_list) != 0) {
                String str = (String) customResponsedMessage.getData();
                e.this.h(str, e.this.mDataList);
                e.this.Md(str);
                if (e.this.khO != null) {
                    e.this.khO.cx(new ArrayList(e.this.mDataList));
                }
                if (e.this.iPi != null && e.this.kfL) {
                    e.this.iPi.b(e.this.jiq, e.this.gyR, e.this.jja, true);
                }
            }
        }
    };
    private CustomMessageListener jhW = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.homepage.personalize.e.24
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ThreadCardViewHolder cQv;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent)) {
                KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24 && (cQv = e.this.cQv()) != null && cQv.tj() != null) {
                    cQv.tj().b(new a.C0089a(3));
                }
            }
        }
    };
    private com.baidu.adp.framework.listener.a kjc = new com.baidu.adp.framework.listener.a(1003065, CmdConfigSocket.CMD_TOPIC_BLESS) { // from class: com.baidu.tieba.homepage.personalize.e.25
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
                        if ((nVar instanceof com.baidu.tieba.homepage.topic.topictab.b.a) && (bVar = ((com.baidu.tieba.homepage.topic.topictab.b.a) nVar).kpR) != null && longValue == bVar.pkId) {
                            bVar.userPkId = j2;
                            return;
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener jhX = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.homepage.personalize.e.26
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            List<n> dataList = e.this.khO.getDataList();
            if (!y.isEmpty(dataList)) {
                for (n nVar : dataList) {
                    if (nVar instanceof k) {
                        k kVar = (k) nVar;
                        if (kVar.eQj != 0 && kVar.eJQ != null) {
                            int[] imageWidthAndHeight = kVar.eJQ.getImageWidthAndHeight();
                            kVar.eQj = imageWidthAndHeight[0];
                            kVar.eQk = imageWidthAndHeight[1];
                        }
                    }
                }
            }
            com.baidu.adp.lib.f.e.mA().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.personalize.e.26.1
                @Override // java.lang.Runnable
                public void run() {
                    e.this.khO.notifyDataSetChanged();
                    if (!e.this.mIsBackground && e.this.kfL) {
                        e.this.iPi.b(e.this.jiq, e.this.gyR, e.this.jja, true);
                    }
                }
            }, 500L);
        }
    };
    private CustomMessageListener iOZ = new CustomMessageListener(2921453) { // from class: com.baidu.tieba.homepage.personalize.e.27
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bj)) {
                bj bjVar = (bj) customResponsedMessage.getData();
                if (bjVar.ePf == 1) {
                    int equipmentWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst());
                    int equipmentHeight = l.getEquipmentHeight(TbadkCoreApplication.getInst());
                    float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
                    int i = av.bsS().bsT() ? 2 : 1;
                    RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
                    requestGetMyPostNetMessage.setTag(e.this.kiQ);
                    requestGetMyPostNetMessage.setParams(com.baidu.adp.lib.f.b.toLong(bjVar.tid, 0L), 0L, 0L, equipmentWidth, equipmentHeight, f, i);
                    requestGetMyPostNetMessage.setBFrom("push");
                    MessageManager.getInstance().sendMessage(requestGetMyPostNetMessage);
                }
            }
        }
    };
    private final com.baidu.adp.framework.listener.a iPa = new com.baidu.adp.framework.listener.a(1003010, CmdConfigSocket.CMD_GET_MY_POST) { // from class: com.baidu.tieba.homepage.personalize.e.28
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            GetMyPostResIdl getMyPostResIdl = null;
            if (responsedMessage instanceof GetMyPostHttpResponseMessage) {
                getMyPostResIdl = ((GetMyPostHttpResponseMessage) responsedMessage).getResponseData();
            } else if (responsedMessage instanceof GetMyPostSocketResponseMessage) {
                getMyPostResIdl = ((GetMyPostSocketResponseMessage) responsedMessage).getResponseData();
            }
            if (getMyPostResIdl != null && getMyPostResIdl.data != null && getMyPostResIdl.data.thread_info != null) {
                e.this.kiR = getMyPostResIdl.data.thread_info;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921455));
            }
        }
    };
    private CustomMessageListener kjd = new CustomMessageListener(2921482) { // from class: com.baidu.tieba.homepage.personalize.e.29
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
        void b(int i, int i2, com.baidu.tbadk.util.c cVar, int i3);

        void b(int i, com.baidu.tbadk.util.c cVar, int i2);

        void cRa();

        void onError(int i, String str);

        void si(boolean z);
    }

    public void sj(boolean z) {
        this.kiL = z;
        if (this.iPd != null && !z) {
            this.iPd.hideTip();
        }
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.khC = scrollFragmentTabHost;
        if (this.khC != null) {
            this.khC.setOnTabSelectedListener(new ScrollFragmentTabHost.b() { // from class: com.baidu.tieba.homepage.personalize.e.1
                @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.b
                public void BM(int i) {
                    if (e.this.khC.BL(i) != 1 && e.this.iPd != null) {
                        e.this.iPd.hideTip();
                    }
                }
            });
        }
    }

    public void setTabInForeBackgroundState(boolean z) {
        this.mIsBackground = z;
    }

    public void qJ(boolean z) {
        boolean z2 = false;
        this.mIsBackground = z;
        if (this.khC != null) {
            this.khC.qJ(z);
        }
        if (this.iPi != null) {
            this.iPi.tN(!z);
            ThreadCardViewHolder cQv = cQv();
            if (cQv != null && cQv.tj() != null) {
                z2 = cQv.tj().b(new a.C0089a(8, Boolean.valueOf(z)));
            }
            if (!z2) {
                if (z) {
                    this.iPi.cQu();
                } else if (this.kfL) {
                    this.iPi.b(this.jiq, this.gyR, this.jja, true);
                }
            }
        }
    }

    public e(TbPageContext<?> tbPageContext, BdTypeRecyclerView bdTypeRecyclerView, ab abVar, BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout) {
        this.kiP = 0;
        this.mPageContext = tbPageContext;
        this.kiP = com.baidu.tbadk.core.sharedPref.b.brQ().getInt("key_personalized_refresh_type", 0);
        this.jZZ = bigdaySwipeRefreshLayout;
        this.jmj = bdTypeRecyclerView;
        this.jmj.setOnTouchListener(this.bST);
        if (com.baidu.tbadk.youngster.b.c.bJf()) {
            sn(true);
        }
        this.jKG = new com.baidu.tieba.f.a();
        this.jKG.a(this.iFe);
        this.khO = abVar;
        this.kiF = new com.baidu.tieba.homepage.personalize.model.a();
        this.kiz = com.baidu.tbadk.core.sharedPref.b.brQ().getLong("recommend_frs_cache_time", 1800L) * 1000;
        bdTypeRecyclerView.setOnScrollListener(this.mOnScrollListener);
        this.iPd = new bb();
        cRl();
        this.iPi = new i(this.mPageContext, this.jmj);
        this.iPi.Ho(1);
        this.iPi.Hn(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.kiA = new b(this.mDataList, this.khO);
        this.iPe = new SmartBubbleAnimatedView(tbPageContext.getContext());
        this.iPe.setLayoutParams(new FrameLayout.LayoutParams(-1, l.getDimens(tbPageContext.getContext(), R.dimen.tbds83)));
        cRb();
        this.jhX.setTag(this.mPageContext.getUniqueId());
        MessageManager.getInstance().registerListener(this.jhX);
        if (MessageManager.getInstance().findTask(1003010) == null) {
            HomePageStatic.cOD();
        }
        this.iPa.setTag(this.kiQ);
        if (this.iPa.getHttpMessageListener() != null) {
            this.iPa.getHttpMessageListener().setSelfListener(true);
        }
        if (this.iPa.getSocketMessageListener() != null) {
            this.iPa.getSocketMessageListener().setSelfListener(true);
        }
        MessageManager.getInstance().registerListener(this.iPa);
        MessageManager.getInstance().registerListener(this.iOZ);
        MessageManager.getInstance().registerListener(this.kjd);
    }

    private void cRb() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2016323, new CustomMessageTask.CustomRunnable<Boolean>() { // from class: com.baidu.tieba.homepage.personalize.e.35
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Boolean> customMessage) {
                ThreadCardViewHolder cQv = e.this.cQv();
                return (cQv == null || cQv.tj() == null) ? new CustomResponsedMessage<>(2016323, false) : new CustomResponsedMessage<>(2016323, Boolean.valueOf(cQv.tj().b(new a.C0089a(6))));
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private boolean cRc() {
        return com.baidu.tbadk.core.sharedPref.b.brQ().getBoolean(cRe(), true);
    }

    private void cRd() {
        com.baidu.tbadk.core.sharedPref.b.brQ().putBoolean(cRe(), false);
    }

    private String cRe() {
        return "key_rec_pfirst_load_" + TbadkCoreApplication.getCurrentAccount() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + TbConfig.getVersion();
    }

    public void setRecommendFrsNavigationAnimDispatcher(aa aaVar) {
        if (aaVar != null) {
            this.fNk = aaVar.bFF();
            this.fyG = aaVar.bFG();
        }
    }

    public void showFloatingView() {
        if (this.fNk != null) {
            this.fNk.lc(true);
        }
    }

    public void update() {
        com.baidu.tieba.homepage.framework.a.cPn().E(System.currentTimeMillis(), 1);
        this.mPn = 1;
        this.kiJ = true;
        if (this.mDataList.size() == 0 && !cRc()) {
            if (!this.kak) {
                bld();
                return;
            }
            return;
        }
        blc();
    }

    public void cD(int i, int i2) {
        cb cbVar;
        if (!y.isEmpty(this.mDataList) && this.mDataList.size() > i) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            while (i < this.mDataList.size() && i <= i2) {
                if (this.mDataList.get(i).getType().getId() == cb.eQL.getId() && (cbVar = (cb) this.mDataList.get(i)) != null && cbVar.boj() != null) {
                    arrayList.add(Long.valueOf(cbVar.boj().live_id));
                    arrayList2.add(cbVar);
                }
                i++;
            }
            if (!y.isEmpty(arrayList)) {
                MessageManager.getInstance().sendMessage(new LiveRoomClosedQueryMessage(arrayList, arrayList2));
            }
        }
    }

    public void cRf() {
        if (this.iPi != null && !this.mIsBackground && this.kfL) {
            this.iPi.b(this.jiq, this.gyR, this.jja, true);
        }
        if (this.kiH) {
            if (this.jZZ != null && !this.jZZ.buu()) {
                if (this.jXF) {
                    com.baidu.tieba.s.c.dMr().b(this.kiN, false);
                    if (sm(false)) {
                        cE(3, this.kiE);
                    } else if (this.kiI > 0) {
                        cE(2, this.kiE);
                    }
                } else if (!this.jXF && this.kiE == 0) {
                    cE(2, 0);
                }
            }
            this.kiH = false;
            this.jXF = false;
            this.kiI = 0;
            if (this.kiJ) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
            }
            this.kiJ = false;
        }
    }

    public void bRc() {
        if (isLoading()) {
            com.baidu.tieba.homepage.framework.a.cPn().E(0L, 1);
        } else if (this.kiB != null) {
            cRh();
            this.mPn++;
            setIsLoading(true);
            this.kiB.b(this.mPn, (this.kiC == null || this.kiC.thread_list == null) ? 0 : this.kiC.thread_list.size(), sk(false), 0);
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
            g.cRs();
        }
        if (this.kiF != null && this.kiF.cRL() && !z && (dataRes == null || y.isEmpty(dataRes.thread_list))) {
            if (dataRes == null) {
                DataRes.Builder builder = new DataRes.Builder();
                builder.thread_list = new ArrayList();
                dataRes = builder.build(false);
            }
            if (dataRes.thread_list != null) {
                List<ThreadInfo> cRM = this.kiF.cRM();
                dataRes.thread_list.addAll(cRM);
                if (cRM != null) {
                    cRM.clear();
                }
                z3 = true;
                size = (this.kiC != null || this.kiC.thread_list == null) ? 0 : this.kiC.thread_list.size();
                if (z && i == 0 && dataRes != null && y.isEmpty(dataRes.thread_list)) {
                    if (this.kiB != null) {
                        this.kiB.cRa();
                    }
                    setIsLoading(false);
                    if (this.jZZ != null) {
                        this.jZZ.setRefreshing(false);
                        return;
                    }
                    return;
                }
                if (this.kiR != null) {
                    DataRes.Builder builder2 = new DataRes.Builder(dataRes);
                    builder2.thread_list.add(0, this.kiR);
                    dataRes = builder2.build(false);
                    if (this.kiC != null && !y.isEmpty(this.kiC.thread_list)) {
                        Iterator<ThreadInfo> it = this.kiC.thread_list.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            ThreadInfo next = it.next();
                            if (next != null && next.tid != null && this.kiR.tid != null && next.tid.longValue() == this.kiR.tid.longValue()) {
                                this.kiC.thread_list.remove(next);
                                break;
                            }
                        }
                    }
                    this.kiR = null;
                }
                if ((z3 && i != 0) || dataRes == null || !a(true, z, z2, dataRes)) {
                    this.kiH = false;
                    if (this.mDataList.size() > 0) {
                        if (this.kiB != null) {
                            this.kiB.onError(1, str);
                        }
                    } else if (this.kiB != null) {
                        this.kiB.onError(2, str);
                    }
                } else {
                    cRd();
                    if (this.kiB != null) {
                        com.baidu.tbadk.core.sharedPref.b.brQ().putLong(SharedPrefConfig.RECOMMEND_FRS_REFRESH_TIME + TbadkCoreApplication.getCurrentAccount(), System.currentTimeMillis());
                        this.kiB.si(false);
                    }
                    this.kiH = true;
                    this.jXF = z;
                    this.kiI = size;
                    cvF();
                }
                setIsLoading(false);
                if (this.jZZ == null) {
                    f.e cRg = cRg();
                    if (this.jZZ.buu() && cRg != null) {
                        this.jZZ.c(cRg);
                        return;
                    } else {
                        this.jZZ.setRefreshing(false);
                        return;
                    }
                }
                return;
            }
        }
        z3 = false;
        if (this.kiC != null) {
        }
        if (z) {
        }
        if (this.kiR != null) {
        }
        if (z3) {
        }
        cRd();
        if (this.kiB != null) {
        }
        this.kiH = true;
        this.jXF = z;
        this.kiI = size;
        cvF();
        setIsLoading(false);
        if (this.jZZ == null) {
        }
    }

    private f.e cRg() {
        int i;
        String feedText;
        if (!this.kiH || this.jZZ == null || !this.jZZ.buu() || cRk()) {
            return null;
        }
        int i2 = this.kiE;
        if (this.jXF) {
            com.baidu.tieba.s.c.dMr().b(this.kiN, false);
            if (sm(false)) {
                i = 3;
            } else {
                i = this.kiI > 0 ? 2 : 0;
            }
        } else if (this.jXF || this.kiE != 0) {
            return null;
        } else {
            i2 = 0;
            i = 2;
        }
        if (this.khC != null) {
            this.iPd.cEQ();
        }
        if (this.khC != null && this.khC.getCurrentTabType() != 1) {
            this.iPd.hideTip();
            return null;
        } else if (!this.kiL) {
            this.iPd.hideTip();
            return null;
        } else {
            this.kiD = i;
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
                this.jlp = 1000;
            } else {
                this.jlp = 0;
            }
            return new f.e(feedText, this.jlp);
        }
    }

    public void rV(boolean z) {
        if (z) {
            this.khO.notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        if (this.iPi != null) {
            this.iPi.destroy();
        }
        if (this.iPd != null) {
            this.iPd.onDestroy();
        }
        if (this.kiA != null) {
            this.kiA.onDestroy();
        }
        if (this.jmj != null) {
            this.jmj.removeCallbacks(this.kiZ);
        }
        MessageManager.getInstance().unRegisterTask(2016323);
        MessageManager.getInstance().unRegisterListener(this.jhX);
        MessageManager.getInstance().unRegisterListener(this.iOZ);
        MessageManager.getInstance().unRegisterListener(this.iPa);
        MessageManager.getInstance().unRegisterListener(this.kjd);
    }

    public void onPause() {
        c.i(this.jmj);
        BW(this.kiY);
        if (this.kiG != null) {
            this.kiG.bEa();
        }
    }

    private void blc() {
        if (this.kiB != null) {
            this.kiB.b((this.kiC == null || this.kiC.thread_list == null || cRj()) ? 0 : this.kiC.thread_list.size(), sk(true), 0);
        }
    }

    private com.baidu.tbadk.util.c sk(boolean z) {
        String y = com.baidu.tieba.recapp.a.y(this.mDataList, z);
        int sl = sl(z);
        com.baidu.tbadk.util.c cVar = new com.baidu.tbadk.util.c();
        cVar.adFloorInfo = y;
        cVar.preAdThreadCount = sl;
        return cVar;
    }

    public int sl(boolean z) {
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
                if (!(nVar instanceof com.baidu.tieba.homepage.personalize.data.a) || nVar.getType() == AdvertAppInfo.eLg) {
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
                if ((nVar2 instanceof com.baidu.tieba.homepage.personalize.data.a) && nVar2.getType() != AdvertAppInfo.eLg) {
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
        this.kak = true;
        if (dataRes != null) {
            if (a(false, true, true, dataRes) && !cRj()) {
                if (this.kiB != null) {
                    this.kiB.si(true);
                    Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler() { // from class: com.baidu.tieba.homepage.personalize.e.2
                        @Override // android.os.MessageQueue.IdleHandler
                        public boolean queueIdle() {
                            e.this.bEd();
                            return false;
                        }
                    });
                }
                if (TbSingleton.getInstance().getForceRefreshHomeRecommend()) {
                    blc();
                    TbSingleton.getInstance().setForceRefreshHomeRecommend(false);
                    return;
                }
                return;
            }
            blc();
            return;
        }
        blc();
    }

    public void bEd() {
        com.baidu.tbadk.n.l.bEl().eB(System.currentTimeMillis() - com.baidu.tbadk.n.l.bEl().bEk());
    }

    private void i(List<n> list, int i) {
        Set<n> a2 = com.baidu.tieba.recapp.a.a(list, this.mPn, "NEWINDEX");
        if (a2.size() > 0) {
            com.baidu.tieba.s.c.dMr().b(this.kiN, com.baidu.tieba.s.a.b(PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE, "common_fill", true, a2.size()));
        }
    }

    private boolean a(boolean z, boolean z2, boolean z3, DataRes dataRes) {
        boolean z4;
        if (dataRes == null) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.kiP == 1) {
            if (z2 && (dataRes.thread_list.size() >= 6 || cRj())) {
                cRi();
                this.kiC = null;
            }
        } else if (z2 && cRj()) {
            this.kiC = null;
        }
        int size = z2 ? 0 : this.mDataList.size();
        DataRes.Builder builder = new DataRes.Builder(dataRes);
        this.mDataList.clear();
        com.baidu.tieba.homepage.personalize.model.c a2 = this.kiF.a(z, this.kiC, builder, z2 ? 0 : 1);
        List<n> list = null;
        int i = 0;
        if (a2 != null) {
            list = a2.gcs;
            this.kiE = a2.klK;
            i = a2.klL;
            a2.klL = 0;
        }
        int i2 = i;
        if (list != null) {
            this.mDataList.addAll(list);
            i(list, size);
            a(z2 ? 0 : 1, list, size);
            if (this.kiJ) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
            }
        }
        if (this.kiC == null) {
            this.kiC = builder;
            this.kiA.eb(this.kiC.thread_list);
        }
        if (this.mDataList.size() == 0) {
            z4 = false;
        } else {
            if (z2) {
                if (dataRes.live_answer != null) {
                    this.kiK = new h();
                    this.kiK.a(dataRes.live_answer);
                    this.kiC.live_answer = dataRes.live_answer;
                } else if (z) {
                    this.kiK = null;
                    this.kiC.live_answer = null;
                }
                this.kiM = dataRes.float_info;
                this.kiC.float_info = dataRes.float_info;
            }
            long j = com.baidu.tbadk.core.sharedPref.b.brQ().getLong("key_maintab_banner_close_time", 0L);
            if (this.kiK != null && !au.isTaday(j)) {
                TbSingleton.getInstance().isAddBanner = true;
                this.mDataList.add(0, this.kiK);
            }
            LinkedList linkedList = new LinkedList(this.mDataList);
            this.khO.setFromCDN(dataRes.is_new_url != null && dataRes.is_new_url.intValue() == 1);
            this.khO.j(linkedList, i2);
            z4 = true;
            if (this.iPi != null && this.kfL) {
                this.iPi.b(this.jiq, this.gyR, this.jja, true);
            }
        }
        com.baidu.tieba.homepage.framework.a.cPn().C(System.currentTimeMillis() - currentTimeMillis, 1);
        long BB = com.baidu.tieba.homepage.framework.a.cPn().BB(1);
        if (BB > 0) {
            com.baidu.tieba.homepage.framework.a.cPn().D(System.currentTimeMillis() - BB, 1);
            com.baidu.tieba.homepage.framework.a.cPn().E(0L, 1);
        }
        if (dataRes.anti != null && dataRes.anti.block_pop_info != null) {
            com.baidu.tieba.ueg.d.d(dataRes.anti.block_pop_info);
        }
        bl blVar = new bl();
        blVar.a(dataRes.recom_post_topic);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_REFRESH_TOPIC_TIP, blVar));
        if (!z && BB > 0) {
            com.baidu.tbadk.n.l.bEl().eN(System.currentTimeMillis() - BB);
            return z4;
        }
        return z4;
    }

    private void cRh() {
        int i;
        List<n> list = null;
        if (y.getCount(this.mDataList) >= this.kiF.cRH() - 40) {
            com.baidu.tieba.homepage.personalize.model.c a2 = this.kiF.a(true, this.kiC, null, 1);
            if (a2 != null) {
                list = a2.gcs;
                i = a2.klL;
                a2.klL = 0;
            } else {
                i = 0;
            }
            if (list != null) {
                this.mDataList.clear();
                this.mDataList.addAll(list);
                this.khO.j(new LinkedList(this.mDataList), i);
            }
        }
    }

    private void bld() {
        this.kak = true;
        af.a(new ae<DataRes>() { // from class: com.baidu.tieba.homepage.personalize.e.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.ae
            /* renamed from: cRo */
            public DataRes doInBackground() {
                com.baidu.adp.lib.cache.l<byte[]> dE = com.baidu.tbadk.core.c.a.bqr().dE("tb.rec_frs_update", TbadkCoreApplication.getCurrentAccount());
                if (dE == null) {
                    return null;
                }
                byte[] bArr = dE.get("0");
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

    private void cvF() {
        if (this.kiC != null) {
            DataRes.Builder builder = new DataRes.Builder(this.kiC.build(true));
            if (builder.thread_list != null && builder.thread_list.size() > 30) {
                builder.thread_list = builder.thread_list.subList(0, 30);
            }
            a(builder, builder.thread_list != null ? builder.thread_list.size() : 0);
            a(builder);
            b(builder);
            c(builder);
        }
    }

    private void cRi() {
        if (this.kiC != null) {
            final DataRes.Builder builder = new DataRes.Builder(this.kiC.build(true));
            if (builder.thread_list != null && builder.thread_list.size() > 50) {
                builder.thread_list = builder.thread_list.subList(0, 50);
            }
            a(builder, builder.thread_list != null ? builder.thread_list.size() : 0);
            af.a(new ae<Object>() { // from class: com.baidu.tieba.homepage.personalize.e.5
                @Override // com.baidu.tbadk.util.ae
                public Object doInBackground() {
                    DataRes.Builder builder2 = new DataRes.Builder(builder.build(true));
                    e.this.kiA.ec(builder2.thread_list);
                    try {
                        com.baidu.tbadk.core.c.a.bqr().dE("tb.rec_old_data", TbadkCoreApplication.getCurrentAccount()).setForever("0", builder2.build(true).toByteArray());
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
    public void Md(String str) {
        if (!TextUtils.isEmpty(str) && this.kiC != null && this.kiC.banner_list != null && this.kiC.banner_list.app != null && this.kiC.banner_list.app.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (App app : this.kiC.banner_list.app) {
                if (app != null && str.equals(app.id)) {
                    arrayList.add(app);
                }
            }
            BannerList.Builder builder = new BannerList.Builder(this.kiC.banner_list);
            if (builder.app != null) {
                builder.app.removeAll(arrayList);
            }
            this.kiC.banner_list = builder.build(false);
            DataRes.Builder builder2 = new DataRes.Builder(this.kiC.build(true));
            builder2.banner_list = builder.build(true);
            c(builder2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final DataRes.Builder builder) {
        af.a(new ae<Object>() { // from class: com.baidu.tieba.homepage.personalize.e.6
            @Override // com.baidu.tbadk.util.ae
            public Object doInBackground() {
                DataRes.Builder builder2 = new DataRes.Builder(builder.build(true));
                e.this.kiA.ec(builder2.thread_list);
                try {
                    com.baidu.tbadk.core.c.a.bqr().dE("tb.rec_frs_update", TbadkCoreApplication.getCurrentAccount()).setForever("0", builder2.build(true).toByteArray());
                    return null;
                } catch (Exception e) {
                    BdLog.e(e);
                    return null;
                }
            }
        }, null);
    }

    private boolean cRj() {
        return sm(true);
    }

    private boolean sm(boolean z) {
        long j = com.baidu.tbadk.core.sharedPref.b.brQ().getLong(SharedPrefConfig.RECOMMEND_FRS_REFRESH_TIME + TbadkCoreApplication.getCurrentAccount(), 0L);
        return j == 0 ? z : Math.abs(System.currentTimeMillis() - j) > this.kiz;
    }

    public void a(a aVar) {
        this.kiB = aVar;
    }

    private boolean isLoading() {
        return this.mIsLoading;
    }

    private void setIsLoading(boolean z) {
        this.mIsLoading = z;
    }

    public void cQV() {
        boolean z = true;
        com.baidu.tbadk.coreExtra.data.b activityPrizeData = TbadkCoreApplication.getInst().getActivityPrizeData();
        if (activityPrizeData.isSwitchTurn() && !StringUtils.isNull(activityPrizeData.getFeedText())) {
            String currentDay = UtilHelper.getCurrentDay();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            String str = "";
            if (!StringUtils.isNull(currentAccount)) {
                String string = com.baidu.tbadk.core.sharedPref.b.brQ().getString(SharedPrefConfig.ACTIVITY_PRIZE_FEED_TEXT_TIME, "");
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
                    cE(4, 0);
                    com.baidu.tbadk.core.sharedPref.b.brQ().putString(SharedPrefConfig.ACTIVITY_PRIZE_FEED_TEXT_TIME, str);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sn(boolean z) {
        boolean z2 = com.baidu.tbadk.core.sharedPref.b.brQ().getBoolean("key_youngster_homgpage_top_view_closed", false);
        if (this.jmj != null && !z2) {
            if (z) {
                if (this.kiO == null) {
                    this.kiO = new HomePageYoungsterTopView(this.mPageContext);
                    this.kiO.setOnDeleteClick(new HomePageYoungsterTopView.a() { // from class: com.baidu.tieba.homepage.personalize.e.7
                        @Override // com.baidu.tieba.homepage.personalize.view.HomePageYoungsterTopView.a
                        public void cRp() {
                            new BdTopToast(e.this.mPageContext.getPageActivity(), 2000).zn(true).UN(e.this.mPageContext.getPageActivity().getString(R.string.youngster_frs_top_toast)).aR((ViewGroup) e.this.mPageContext.getPageActivity().findViewById(R.id.maintabContainer));
                            e.this.sn(false);
                            com.baidu.tbadk.core.sharedPref.b.brQ().putBoolean("key_youngster_homgpage_top_view_closed", true);
                        }
                    });
                }
                this.jmj.setHeaderView(this.kiO, false);
                this.kiO.setVisibility(0);
                this.jmj.scrollToPosition(0);
            } else if (this.kiO != null) {
                this.kiO.setVisibility(8);
                this.jmj.removeHeaderView(this.kiO);
                this.kiO = null;
            }
        }
    }

    private boolean cRk() {
        return this.kiO != null && this.kiO.getVisibility() == 0;
    }

    private void cE(int i, int i2) {
        if (!cRk()) {
            if (this.khC != null) {
                this.iPd.cEQ();
            }
            if (this.khC != null && this.khC.getCurrentTabType() != 1) {
                this.iPd.hideTip();
            } else if (!this.kiL) {
                this.iPd.hideTip();
            } else {
                this.kiD = i;
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
                        this.jlp = 3000;
                    } else {
                        this.jlp = 2000;
                    }
                    this.iPe.fjM = str;
                    this.iPe.jli = this.jlp;
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 49;
                    if (this.khC != null) {
                        FrameLayout frameLayout = this.khC.getFrameLayout();
                        frameLayout.removeView(this.iPe);
                        frameLayout.addView(this.iPe, layoutParams);
                        this.iPe.cEO();
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(Long l) {
        if (this.kiC != null && this.kiC.thread_list != null) {
            List<ThreadInfo> list = this.kiC.thread_list;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                ThreadInfo threadInfo = list.get(i);
                if (threadInfo.tid.equals(l) && threadInfo.top_agree_post != null) {
                    ThreadInfo.Builder builder = new ThreadInfo.Builder(threadInfo);
                    builder.top_agree_post = null;
                    list.set(i, builder.build(true));
                    cvF();
                    a(false, true, false, this.kiC.build(true));
                    return;
                }
            }
        }
    }

    public void o(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.kiN = bdUniqueId;
            if (this.jDq != null) {
                this.jDq.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.jDq);
            }
            if (this.kiT != null) {
                this.kiT.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.kiT);
            }
            this.kiU.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.kiU);
            this.faJ.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.faJ);
            this.kaq.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_LIKE_FORUM, this.kaq);
            MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_UNLIKE_FORUM, this.kaq);
            this.kiW.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.kiW);
            this.iOX.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.iOX);
            this.iOY.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.iOY);
            this.jpm.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.jpm);
            if (this.iPi != null) {
                this.iPi.setUniqueId(bdUniqueId);
            }
            this.kiA.l(bdUniqueId);
            this.kjb.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.kjb);
            this.jhW.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.jhW);
            this.kjc.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.kjc);
            this.kiV.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.kiV);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(UpdateAttentionMessage updateAttentionMessage) {
        if (updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid)) {
            final String str = updateAttentionMessage.getData().toUid;
            final boolean z = updateAttentionMessage.getData().isAttention;
            af.a(new ae<Boolean>() { // from class: com.baidu.tieba.homepage.personalize.e.13
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.baidu.tbadk.util.ae
                public Boolean doInBackground() {
                    int intValue;
                    try {
                        com.baidu.adp.lib.cache.l<byte[]> dE = com.baidu.tbadk.core.c.a.bqr().dE("tb.rec_frs_update", TbadkCoreApplication.getCurrentAccount());
                        if (dE == null) {
                            return false;
                        }
                        byte[] bArr = dE.get("0");
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
                        e.this.kiA.ec(builder5.thread_list);
                        dE.setForever("0", builder5.build(true).toByteArray());
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

    public void cRl() {
        this.jgd = new com.baidu.tieba.tbadkCore.data.f("new_index", null);
        this.jgd.dNa();
    }

    public void a(int i, List<n> list, int i2) {
        int i3;
        int i4;
        if (this.jgd != null) {
            if (i == 0) {
                this.jgd.dNa();
            }
            if (list != null && !list.isEmpty()) {
                int[] iArr = com.baidu.tieba.tbadkCore.data.f.nvU;
                int i5 = 0;
                int i6 = 0;
                int i7 = 0;
                while (i7 < list.size() && i6 < iArr.length && (i3 = iArr[i6]) >= 0) {
                    if (list.get(i7) instanceof com.baidu.tieba.card.data.b) {
                        i4 = i5 + 1;
                        if (i4 == i3 - 1) {
                            if (i2 < i7 + 1) {
                                this.jgd.dr(i3, i7 + 1);
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

    public void BV(int i) {
        if ((this.jgd != null ? this.jgd.JB(i) : -1) >= 0 && this.jmj != null && this.jmj.getData() != null && this.jmj.getData().size() > i) {
            this.jgd.JC(i);
        }
    }

    public i cDy() {
        return this.iPi;
    }

    public void se(boolean z) {
        this.kfL = z;
    }

    public void BW(final int i) {
        af.a(new ae<Object>() { // from class: com.baidu.tieba.homepage.personalize.e.15
            @Override // com.baidu.tbadk.util.ae
            public Object doInBackground() {
                com.baidu.adp.lib.cache.l<String> dF = com.baidu.tbadk.core.c.a.bqr().dF(e.this.kiX, TbadkCoreApplication.getCurrentAccount());
                if (dF != null) {
                    dF.set(e.this.kiX, Integer.toString(i), 43200000L);
                    return null;
                }
                return null;
            }
        }, null);
    }

    public void a(final d dVar) {
        af.a(new ae<String>() { // from class: com.baidu.tieba.homepage.personalize.e.17
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.ae
            /* renamed from: cRq */
            public String doInBackground() {
                com.baidu.adp.lib.cache.l<String> dF = com.baidu.tbadk.core.c.a.bqr().dF(e.this.kiX, TbadkCoreApplication.getCurrentAccount());
                if (dF != null) {
                    return dF.get(e.this.kiX);
                }
                return null;
            }
        }, new m<String>() { // from class: com.baidu.tieba.homepage.personalize.e.18
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.m
            /* renamed from: Me */
            public void onReturnDataInUI(String str) {
                if (dVar != null) {
                    dVar.BC(com.baidu.adp.lib.f.b.toInt(str, 0));
                }
            }
        });
    }

    public void cQY() {
        c.j(this.jmj);
    }

    public void cRm() {
        a(this.kja);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cRn() {
        Iterator<n> it = this.mDataList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            } else if (it.next() instanceof com.baidu.tieba.homepage.personalize.data.g) {
                it.remove();
                break;
            }
        }
        if (this.kiC != null) {
            this.kiC.active_center = null;
            cvF();
            if (this.jmj != null) {
                List<Integer> k = k(this.jmj);
                int intValue = k.get(0).intValue();
                int intValue2 = k.get(1).intValue();
                if (intValue != -1 && intValue2 != -1) {
                    this.jmj.p(intValue, intValue2);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(CustomResponsedMessage<?> customResponsedMessage) {
        boolean z;
        String str;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.kiC != null && y.getCount(this.kiC.thread_list) != 0 && y.getCount(this.mDataList) != 0) {
            JSONObject jSONObject = (JSONObject) customResponsedMessage.getData();
            String optString = jSONObject.optString("tid");
            if (StringUtils.isNull(optString)) {
                String optString2 = jSONObject.optString(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_ID);
                if (this.jmj != null && !TextUtils.isEmpty(optString2)) {
                    int i = 0;
                    while (true) {
                        if (i >= this.jmj.getCount()) {
                            str = optString;
                            break;
                        }
                        n item = this.jmj.getItem(i);
                        if (item instanceof com.baidu.tieba.card.data.j) {
                            com.baidu.tieba.card.data.j jVar = (com.baidu.tieba.card.data.j) item;
                            if (jVar.bln() != null && jVar.bln().boj() != null && optString2.equals(String.valueOf(jVar.bln().boj().live_id))) {
                                str = jVar.bln().getTid();
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
                    if (bVar.bln() != null && bVar.bln().getTid() != null) {
                        if (bVar.bln().getTid().equals(optString)) {
                            it.remove();
                            z = true;
                            z2 = z;
                        } else if (z2) {
                            com.baidu.tieba.homepage.personalize.model.b.ee(this.mDataList);
                            break;
                        }
                    }
                }
                z = z2;
                z2 = z;
            }
            if (this.kiC != null && this.kiC.thread_list != null) {
                long j = com.baidu.adp.lib.f.b.toLong(optString, 0L);
                int i2 = 0;
                while (true) {
                    if (i2 < this.kiC.thread_list.size()) {
                        ThreadInfo threadInfo = this.kiC.thread_list.get(i2);
                        if (threadInfo == null || threadInfo.tid == null || threadInfo.tid.longValue() != j) {
                            i2++;
                        } else {
                            com.baidu.tieba.homepage.personalize.readProgressBar.c.a(threadInfo.tid.longValue(), i2, this.kiC.thread_list, this.mDataList);
                            this.kiC.thread_list.remove(i2);
                            cvF();
                            break;
                        }
                    } else {
                        break;
                    }
                }
                if (this.jmj != null) {
                    List<Integer> b2 = b(optString, this.jmj);
                    int intValue = b2.get(0).intValue();
                    int intValue2 = b2.get(1).intValue();
                    if (intValue != -1 && intValue2 != -1) {
                        this.jmj.p(intValue, intValue2);
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
                    if (bVar.bln() != null && bVar.bln().getTid().equals(str)) {
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
                    advertAppInfo = ((com.baidu.tieba.homepage.personalize.data.a) next).csS();
                } else {
                    if (next instanceof an) {
                        an anVar = (an) next;
                        if (anVar.bme() instanceof AdvertAppInfo.ILegoAdvert) {
                            advertAppInfo = ((AdvertAppInfo.ILegoAdvert) anVar.bme()).getAdvertAppInfo();
                        }
                    }
                    advertAppInfo = advertAppInfo2;
                }
                if (advertAppInfo != null && str.equals(advertAppInfo.eLu)) {
                    it.remove();
                    advertAppInfo = null;
                }
                advertAppInfo2 = advertAppInfo;
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (this.iPe != null) {
            this.iPe.onChangeSkinType(i);
        }
        if (this.kiO != null) {
            this.kiO.onChangeSkinType();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ThreadCardViewHolder cQv() {
        if (this.iPi == null || this.iPi.dzV() == null || !(this.iPi.dzV().getTag() instanceof ThreadCardViewHolder)) {
            return null;
        }
        return (ThreadCardViewHolder) this.iPi.dzV().getTag();
    }
}
