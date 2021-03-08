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
    private View.OnTouchListener fAf;
    private z fOK;
    private bb iRa;
    private SmartBubbleAnimatedView iRb;
    private i iRf;
    private com.baidu.tieba.f.a jMD;
    private boolean jZV;
    private com.baidu.tieba.tbadkCore.data.f jia;
    private final BdTypeRecyclerView joh;
    private final BigdaySwipeRefreshLayout kcp;
    private ScrollFragmentTabHost kjT;
    private final long kkP;
    private final b kkQ;
    private DataRes.Builder kkS;
    private final com.baidu.tieba.homepage.personalize.model.a kkV;
    private int kkY;
    private final ab kkf;
    private h kla;
    private BdUniqueId kld;
    private HomePageYoungsterTopView kle;
    private int klf;
    private Runnable klp;
    private final TbPageContext<?> mPageContext;
    private a kkR = null;
    private final List<n> mDataList = new LinkedList();
    private int mPn = 1;
    private boolean mIsLoading = false;
    private boolean kcA = false;
    private int kkT = 2;
    private int kkU = 0;
    private TextView mTipView = null;
    private int jnn = 2000;
    private com.baidu.tbadk.n.c kkW = null;
    private boolean jkX = false;
    private int jkn = 0;
    private int gAO = 0;
    private boolean mIsBackground = false;
    private boolean kib = true;
    private boolean kkX = false;
    private boolean kkZ = false;
    private boolean klb = true;
    private FloatInfo klc = null;
    private BdUniqueId klg = BdUniqueId.gen();
    private a.C0095a jiv = new a.C0095a(2);
    private ThreadInfo klh = null;
    private RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.e.12
        private int klw = -1;
        private int kcL = 0;
        private boolean klx = false;

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (e.this.kkW == null) {
                e.this.kkW = new com.baidu.tbadk.n.c();
                e.this.kkW.setSubType(1005);
                e.this.kkW.pageType = 1;
            }
            if (e.this.fOK != null && !e.this.mIsBackground) {
                e.this.fOK.q(recyclerView, i);
            }
            if (i == 0) {
                c.i(e.this.joh);
                e.this.kkW.bEd();
                t.csH().mG(true);
                com.baidu.tieba.a.d.bKY().dK("page_recommend", "show_");
                com.baidu.tieba.s.c.dMH().b(e.this.kld, false);
                this.klx = false;
                if (e.this.iRf != null && e.this.kib && !e.this.mIsBackground) {
                    e.this.iRf.a(e.this.jkn, e.this.gAO, e.this.jkX, 1);
                    return;
                }
                return;
            }
            e.this.kkW.bEc();
            if (i == 1) {
                if (e.this.iRa != null) {
                    e.this.iRa.hideTip();
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
            if (this.kcL > i) {
                this.klx = true;
            }
            if (e.this.fOK != null && !e.this.mIsBackground) {
                e.this.fOK.onScroll(this.kcL, i);
            }
            this.kcL = i;
            int i3 = (i + i2) - 1;
            if (!this.klx && this.klw != i3) {
                this.klw = i3;
                e.this.BY(this.klw);
            }
            if (this.klx && this.klw != i) {
                this.klw = i;
                e.this.BY(this.klw);
            }
            e.this.klo = i;
            e.this.jkn = i;
            e.this.gAO = (i + i2) - 1;
            ThreadCardViewHolder cQJ = e.this.cQJ();
            if (cQJ != null && cQJ.tj() != null) {
                cQJ.tj().b(e.this.jiv);
            }
        }
    };
    private View.OnTouchListener bUt = new View.OnTouchListener() { // from class: com.baidu.tieba.homepage.personalize.e.23
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (e.this.fAf != null) {
                e.this.fAf.onTouch(view, motionEvent);
            }
            if (e.this.jMD != null) {
                e.this.jMD.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private a.InterfaceC0717a iHb = new a.InterfaceC0717a() { // from class: com.baidu.tieba.homepage.personalize.e.30
        @Override // com.baidu.tieba.f.a.InterfaceC0717a
        public void G(int i, int i2) {
            e.this.jkX = false;
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0717a
        public void H(int i, int i2) {
            e.this.jkX = true;
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0717a
        public void ch(int i, int i2) {
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0717a
        public void I(int i, int i2) {
        }
    };
    private View.OnClickListener kli = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.e.31
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (e.this.iRa != null) {
                e.this.iRa.hideTip();
            }
        }
    };
    private final CustomMessageListener klj = new CustomMessageListener(CmdConfigCustom.CMD_RELOAD_HP_PERSONALIZED) { // from class: com.baidu.tieba.homepage.personalize.e.32
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (e.this.joh != null) {
                e.this.iRf.cQI();
                e.this.kib = false;
                e.this.kcp.setRefreshing(true);
            }
        }
    };
    private final CustomMessageListener klk = new CustomMessageListener(2921461) { // from class: com.baidu.tieba.homepage.personalize.e.33
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (e.this.joh != null) {
                e.this.cRB();
            }
        }
    };
    private final CustomMessageListener kll = new CustomMessageListener(2921486) { // from class: com.baidu.tieba.homepage.personalize.e.34
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data = customResponsedMessage.getData();
            switch (data instanceof Integer ? ((Integer) data).intValue() : 0) {
                case 2:
                    new BdTopToast(e.this.mPageContext.getPageActivity(), 2000).zm(true).Vg(e.this.mPageContext.getPageActivity().getString(R.string.youngster_open_title)).aR((ViewGroup) e.this.mPageContext.getPageActivity().findViewById(R.id.maintabContainer));
                    e.this.sn(true);
                    return;
                case 3:
                    new BdTopToast(e.this.mPageContext.getPageActivity(), 2000).zm(true).Vg(e.this.mPageContext.getPageActivity().getString(R.string.youngster_close_title)).aR((ViewGroup) e.this.mPageContext.getPageActivity().findViewById(R.id.maintabContainer));
                    e.this.sn(false);
                    return;
                case 4:
                default:
                    if (com.baidu.tbadk.youngster.b.c.bJj()) {
                        e.this.sn(true);
                        return;
                    }
                    return;
                case 5:
                    new BdTopToast(e.this.mPageContext.getPageActivity(), 2000).zm(true).Vg(e.this.mPageContext.getPageActivity().getString(R.string.youngster_reset_title)).aR((ViewGroup) e.this.mPageContext.getPageActivity().findViewById(R.id.maintabContainer));
                    e.this.sn(true);
                    return;
            }
        }
    };
    private CustomMessageListener jFn = new CustomMessageListener(CmdConfigCustom.PB_ACTION_PRAISE) { // from class: com.baidu.tieba.homepage.personalize.e.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            cb cbVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof cb) && e.this.kkS != null && y.getCount(e.this.kkS.thread_list) != 0 && (cbVar = (cb) customResponsedMessage.getData()) != null && cbVar.bnD() != null && cbVar.getId() != null && y.getCount(e.this.kkS.thread_list) != 0) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < e.this.kkS.thread_list.size()) {
                        ThreadInfo threadInfo = e.this.kkS.thread_list.get(i2);
                        if (threadInfo == null || threadInfo.id.longValue() != com.baidu.adp.lib.f.b.toLong(cbVar.getId(), -1L)) {
                            i = i2 + 1;
                        } else {
                            ThreadInfo.Builder builder = new ThreadInfo.Builder(threadInfo);
                            Zan.Builder builder2 = new Zan.Builder(builder.zan);
                            builder2.num = Integer.valueOf((int) cbVar.bnD().getNum());
                            builder.zan = builder2.build(true);
                            e.this.kkS.thread_list.set(i2, builder.build(true));
                            return;
                        }
                    } else {
                        return;
                    }
                }
            }
        }
    };
    private CustomMessageListener klm = new CustomMessageListener(CmdConfigCustom.CMD_LIVE_VIDEO_CLOSED_QUERY_RESPONSED) { // from class: com.baidu.tieba.homepage.personalize.e.9
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
                        if ((originData.get(i2) instanceof cb) && (cbVar = (cb) originData.get(i2)) != null && cbVar.bol() != null && ids.contains(Long.valueOf(cbVar.bol().live_id))) {
                            e.this.mDataList.remove(cbVar);
                        }
                        i = i2 + 1;
                    }
                    if (e.this.kkf != null) {
                        e.this.kkf.cx(new ArrayList(e.this.mDataList));
                    }
                }
            }
        }
    };
    private CustomMessageListener fci = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.homepage.personalize.e.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int intValue;
            if ((customResponsedMessage instanceof UpdateAttentionMessage) && e.this.kkS != null && !y.isEmpty(e.this.kkS.thread_list)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid)) {
                    int i = 0;
                    while (true) {
                        if (i >= e.this.kkS.thread_list.size()) {
                            break;
                        }
                        ThreadInfo threadInfo = e.this.kkS.thread_list.get(i);
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
                            e.this.kkS.thread_list.set(i, builder.build(true));
                        }
                    }
                    e.this.a(updateAttentionMessage);
                }
            }
        }
    };
    private CustomMessageListener kcG = new CustomMessageListener(0) { // from class: com.baidu.tieba.homepage.personalize.e.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long) && e.this.kkS != null && e.this.kkS.hot_recomforum != null && !y.isEmpty(e.this.kkS.hot_recomforum.tab_list)) {
                long longValue = ((Long) customResponsedMessage.getData()).longValue();
                DiscoverHotForum.Builder builder = new DiscoverHotForum.Builder(e.this.kkS.hot_recomforum);
                if (com.baidu.tieba.homepage.concern.c.a(builder, longValue, customResponsedMessage.getCmd() == 2001335)) {
                    e.this.kkS.hot_recomforum = builder.build(true);
                    e.this.c(new DataRes.Builder(e.this.kkS.build(true)));
                }
            }
        }
    };
    private String kln = "lastReadReadPositionKey";
    private int klo = 0;
    private d klq = new d() { // from class: com.baidu.tieba.homepage.personalize.e.16
        @Override // com.baidu.tieba.homepage.personalize.d
        public void BF(final int i) {
            if (e.this.klp == null) {
                e.this.klp = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.e.16.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (e.this.joh.getHandler() != null) {
                            e.this.joh.requestFocusFromTouch();
                            if (i <= e.this.joh.getCount() - 1) {
                                e.this.joh.setSelection(i);
                            }
                        }
                    }
                };
            }
            e.this.joh.removeCallbacks(e.this.klp);
            e.this.joh.post(e.this.klp);
        }
    };
    private CustomMessageListener klr = new CustomMessageListener(2016569) { // from class: com.baidu.tieba.homepage.personalize.e.19
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && e.this.kla != null) {
                TbSingleton.getInstance().isAddBanner = false;
                e.this.mDataList.remove(e.this.kla);
                e.this.kkf.cx(new ArrayList(e.this.mDataList));
                com.baidu.tbadk.core.sharedPref.b.brR().putLong("key_maintab_banner_close_time", System.currentTimeMillis());
            }
        }
    };
    private CustomMessageListener iQU = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.homepage.personalize.e.20
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.g(customResponsedMessage);
            if (e.this.iRf != null && e.this.kib) {
                e.this.iRf.b(e.this.jkn, e.this.gAO, e.this.jkX, true);
            }
        }
    };
    private CustomMessageListener iQV = new CustomMessageListener(CmdConfigCustom.CMD_THREAD_NOT_EXIST_WHEN_ENTER_PB) { // from class: com.baidu.tieba.homepage.personalize.e.21
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.g(customResponsedMessage);
        }
    };
    private CustomMessageListener jrj = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.homepage.personalize.e.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && e.this.kkS != null && y.getCount(e.this.kkS.thread_list) != 0) {
                String str = (String) customResponsedMessage.getData();
                e.this.h(str, e.this.mDataList);
                e.this.Mk(str);
                if (e.this.kkf != null) {
                    e.this.kkf.cx(new ArrayList(e.this.mDataList));
                }
                if (e.this.iRf != null && e.this.kib) {
                    e.this.iRf.b(e.this.jkn, e.this.gAO, e.this.jkX, true);
                }
            }
        }
    };
    private CustomMessageListener jjU = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.homepage.personalize.e.24
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ThreadCardViewHolder cQJ;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent)) {
                KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24 && (cQJ = e.this.cQJ()) != null && cQJ.tj() != null) {
                    cQJ.tj().b(new a.C0095a(3));
                }
            }
        }
    };
    private com.baidu.adp.framework.listener.a kls = new com.baidu.adp.framework.listener.a(1003065, CmdConfigSocket.CMD_TOPIC_BLESS) { // from class: com.baidu.tieba.homepage.personalize.e.25
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
                        if ((nVar instanceof com.baidu.tieba.homepage.topic.topictab.b.a) && (bVar = ((com.baidu.tieba.homepage.topic.topictab.b.a) nVar).ksh) != null && longValue == bVar.pkId) {
                            bVar.userPkId = j2;
                            return;
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener jjV = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.homepage.personalize.e.26
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            List<n> dataList = e.this.kkf.getDataList();
            if (!y.isEmpty(dataList)) {
                for (n nVar : dataList) {
                    if (nVar instanceof k) {
                        k kVar = (k) nVar;
                        if (kVar.eRK != 0 && kVar.eLr != null) {
                            int[] imageWidthAndHeight = kVar.eLr.getImageWidthAndHeight();
                            kVar.eRK = imageWidthAndHeight[0];
                            kVar.eRL = imageWidthAndHeight[1];
                        }
                    }
                }
            }
            com.baidu.adp.lib.f.e.mA().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.personalize.e.26.1
                @Override // java.lang.Runnable
                public void run() {
                    e.this.kkf.notifyDataSetChanged();
                    if (!e.this.mIsBackground && e.this.kib) {
                        e.this.iRf.b(e.this.jkn, e.this.gAO, e.this.jkX, true);
                    }
                }
            }, 500L);
        }
    };
    private CustomMessageListener iQW = new CustomMessageListener(2921453) { // from class: com.baidu.tieba.homepage.personalize.e.27
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bj)) {
                bj bjVar = (bj) customResponsedMessage.getData();
                if (bjVar.eQG == 1) {
                    int equipmentWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst());
                    int equipmentHeight = l.getEquipmentHeight(TbadkCoreApplication.getInst());
                    float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
                    int i = av.bsV().bsW() ? 2 : 1;
                    RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
                    requestGetMyPostNetMessage.setTag(e.this.klg);
                    requestGetMyPostNetMessage.setParams(com.baidu.adp.lib.f.b.toLong(bjVar.tid, 0L), 0L, 0L, equipmentWidth, equipmentHeight, f, i);
                    requestGetMyPostNetMessage.setBFrom("push");
                    MessageManager.getInstance().sendMessage(requestGetMyPostNetMessage);
                }
            }
        }
    };
    private final com.baidu.adp.framework.listener.a iQX = new com.baidu.adp.framework.listener.a(1003010, CmdConfigSocket.CMD_GET_MY_POST) { // from class: com.baidu.tieba.homepage.personalize.e.28
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            GetMyPostResIdl getMyPostResIdl = null;
            if (responsedMessage instanceof GetMyPostHttpResponseMessage) {
                getMyPostResIdl = ((GetMyPostHttpResponseMessage) responsedMessage).getResponseData();
            } else if (responsedMessage instanceof GetMyPostSocketResponseMessage) {
                getMyPostResIdl = ((GetMyPostSocketResponseMessage) responsedMessage).getResponseData();
            }
            if (getMyPostResIdl != null && getMyPostResIdl.data != null && getMyPostResIdl.data.thread_info != null) {
                e.this.klh = getMyPostResIdl.data.thread_info;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921455));
            }
        }
    };
    private CustomMessageListener klt = new CustomMessageListener(2921482) { // from class: com.baidu.tieba.homepage.personalize.e.29
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

        void cRo();

        void onError(int i, String str);

        void si(boolean z);
    }

    public void sj(boolean z) {
        this.klb = z;
        if (this.iRa != null && !z) {
            this.iRa.hideTip();
        }
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.kjT = scrollFragmentTabHost;
        if (this.kjT != null) {
            this.kjT.setOnTabSelectedListener(new ScrollFragmentTabHost.b() { // from class: com.baidu.tieba.homepage.personalize.e.1
                @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.b
                public void BP(int i) {
                    if (e.this.kjT.BO(i) != 1 && e.this.iRa != null) {
                        e.this.iRa.hideTip();
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
        if (this.kjT != null) {
            this.kjT.qJ(z);
        }
        if (this.iRf != null) {
            this.iRf.tN(!z);
            ThreadCardViewHolder cQJ = cQJ();
            if (cQJ != null && cQJ.tj() != null) {
                z2 = cQJ.tj().b(new a.C0095a(8, Boolean.valueOf(z)));
            }
            if (!z2) {
                if (z) {
                    this.iRf.cQI();
                } else if (this.kib) {
                    this.iRf.b(this.jkn, this.gAO, this.jkX, true);
                }
            }
        }
    }

    public e(TbPageContext<?> tbPageContext, BdTypeRecyclerView bdTypeRecyclerView, ab abVar, BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout) {
        this.klf = 0;
        this.mPageContext = tbPageContext;
        this.klf = com.baidu.tbadk.core.sharedPref.b.brR().getInt("key_personalized_refresh_type", 0);
        this.kcp = bigdaySwipeRefreshLayout;
        this.joh = bdTypeRecyclerView;
        this.joh.setOnTouchListener(this.bUt);
        if (com.baidu.tbadk.youngster.b.c.bJj()) {
            sn(true);
        }
        this.jMD = new com.baidu.tieba.f.a();
        this.jMD.a(this.iHb);
        this.kkf = abVar;
        this.kkV = new com.baidu.tieba.homepage.personalize.model.a();
        this.kkP = com.baidu.tbadk.core.sharedPref.b.brR().getLong("recommend_frs_cache_time", 1800L) * 1000;
        bdTypeRecyclerView.setOnScrollListener(this.mOnScrollListener);
        this.iRa = new bb();
        cRz();
        this.iRf = new i(this.mPageContext, this.joh);
        this.iRf.Hr(1);
        this.iRf.Hq(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.kkQ = new b(this.mDataList, this.kkf);
        this.iRb = new SmartBubbleAnimatedView(tbPageContext.getContext());
        this.iRb.setLayoutParams(new FrameLayout.LayoutParams(-1, l.getDimens(tbPageContext.getContext(), R.dimen.tbds83)));
        cRp();
        this.jjV.setTag(this.mPageContext.getUniqueId());
        MessageManager.getInstance().registerListener(this.jjV);
        if (MessageManager.getInstance().findTask(1003010) == null) {
            HomePageStatic.cOR();
        }
        this.iQX.setTag(this.klg);
        if (this.iQX.getHttpMessageListener() != null) {
            this.iQX.getHttpMessageListener().setSelfListener(true);
        }
        if (this.iQX.getSocketMessageListener() != null) {
            this.iQX.getSocketMessageListener().setSelfListener(true);
        }
        MessageManager.getInstance().registerListener(this.iQX);
        MessageManager.getInstance().registerListener(this.iQW);
        MessageManager.getInstance().registerListener(this.klt);
    }

    private void cRp() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2016323, new CustomMessageTask.CustomRunnable<Boolean>() { // from class: com.baidu.tieba.homepage.personalize.e.35
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Boolean> customMessage) {
                ThreadCardViewHolder cQJ = e.this.cQJ();
                return (cQJ == null || cQJ.tj() == null) ? new CustomResponsedMessage<>(2016323, false) : new CustomResponsedMessage<>(2016323, Boolean.valueOf(cQJ.tj().b(new a.C0095a(6))));
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private boolean cRq() {
        return com.baidu.tbadk.core.sharedPref.b.brR().getBoolean(cRs(), true);
    }

    private void cRr() {
        com.baidu.tbadk.core.sharedPref.b.brR().putBoolean(cRs(), false);
    }

    private String cRs() {
        return "key_rec_pfirst_load_" + TbadkCoreApplication.getCurrentAccount() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + TbConfig.getVersion();
    }

    public void setRecommendFrsNavigationAnimDispatcher(aa aaVar) {
        if (aaVar != null) {
            this.fOK = aaVar.bFJ();
            this.fAf = aaVar.bFK();
        }
    }

    public void showFloatingView() {
        if (this.fOK != null) {
            this.fOK.lc(true);
        }
    }

    public void update() {
        com.baidu.tieba.homepage.framework.a.cPB().E(System.currentTimeMillis(), 1);
        this.mPn = 1;
        this.kkZ = true;
        if (this.mDataList.size() == 0 && !cRq()) {
            if (!this.kcA) {
                blf();
                return;
            }
            return;
        }
        ble();
    }

    public void cE(int i, int i2) {
        cb cbVar;
        if (!y.isEmpty(this.mDataList) && this.mDataList.size() > i) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            while (i < this.mDataList.size() && i <= i2) {
                if (this.mDataList.get(i).getType().getId() == cb.eSm.getId() && (cbVar = (cb) this.mDataList.get(i)) != null && cbVar.bol() != null) {
                    arrayList.add(Long.valueOf(cbVar.bol().live_id));
                    arrayList2.add(cbVar);
                }
                i++;
            }
            if (!y.isEmpty(arrayList)) {
                MessageManager.getInstance().sendMessage(new LiveRoomClosedQueryMessage(arrayList, arrayList2));
            }
        }
    }

    public void cRt() {
        if (this.iRf != null && !this.mIsBackground && this.kib) {
            this.iRf.b(this.jkn, this.gAO, this.jkX, true);
        }
        if (this.kkX) {
            if (this.kcp != null && !this.kcp.bux()) {
                if (this.jZV) {
                    com.baidu.tieba.s.c.dMH().b(this.kld, false);
                    if (sm(false)) {
                        cF(3, this.kkU);
                    } else if (this.kkY > 0) {
                        cF(2, this.kkU);
                    }
                } else if (!this.jZV && this.kkU == 0) {
                    cF(2, 0);
                }
            }
            this.kkX = false;
            this.jZV = false;
            this.kkY = 0;
            if (this.kkZ) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
            }
            this.kkZ = false;
        }
    }

    public void bRp() {
        if (isLoading()) {
            com.baidu.tieba.homepage.framework.a.cPB().E(0L, 1);
        } else if (this.kkR != null) {
            cRv();
            this.mPn++;
            setIsLoading(true);
            this.kkR.b(this.mPn, (this.kkS == null || this.kkS.thread_list == null) ? 0 : this.kkS.thread_list.size(), sk(false), 0);
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
            g.cRG();
        }
        if (this.kkV != null && this.kkV.cRZ() && !z && (dataRes == null || y.isEmpty(dataRes.thread_list))) {
            if (dataRes == null) {
                DataRes.Builder builder = new DataRes.Builder();
                builder.thread_list = new ArrayList();
                dataRes = builder.build(false);
            }
            if (dataRes.thread_list != null) {
                List<ThreadInfo> cSa = this.kkV.cSa();
                dataRes.thread_list.addAll(cSa);
                if (cSa != null) {
                    cSa.clear();
                }
                z3 = true;
                size = (this.kkS != null || this.kkS.thread_list == null) ? 0 : this.kkS.thread_list.size();
                if (z && i == 0 && dataRes != null && y.isEmpty(dataRes.thread_list)) {
                    if (this.kkR != null) {
                        this.kkR.cRo();
                    }
                    setIsLoading(false);
                    if (this.kcp != null) {
                        this.kcp.setRefreshing(false);
                        return;
                    }
                    return;
                }
                if (this.klh != null) {
                    DataRes.Builder builder2 = new DataRes.Builder(dataRes);
                    builder2.thread_list.add(0, this.klh);
                    dataRes = builder2.build(false);
                    if (this.kkS != null && !y.isEmpty(this.kkS.thread_list)) {
                        Iterator<ThreadInfo> it = this.kkS.thread_list.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            ThreadInfo next = it.next();
                            if (next != null && next.tid != null && this.klh.tid != null && next.tid.longValue() == this.klh.tid.longValue()) {
                                this.kkS.thread_list.remove(next);
                                break;
                            }
                        }
                    }
                    this.klh = null;
                }
                if ((z3 && i != 0) || dataRes == null || !a(true, z, z2, dataRes)) {
                    this.kkX = false;
                    if (this.mDataList.size() > 0) {
                        if (this.kkR != null) {
                            this.kkR.onError(1, str);
                        }
                    } else if (this.kkR != null) {
                        this.kkR.onError(2, str);
                    }
                } else {
                    cRr();
                    if (this.kkR != null) {
                        com.baidu.tbadk.core.sharedPref.b.brR().putLong(SharedPrefConfig.RECOMMEND_FRS_REFRESH_TIME + TbadkCoreApplication.getCurrentAccount(), System.currentTimeMillis());
                        this.kkR.si(false);
                    }
                    this.kkX = true;
                    this.jZV = z;
                    this.kkY = size;
                    cvS();
                }
                setIsLoading(false);
                if (this.kcp == null) {
                    f.e cRu = cRu();
                    if (this.kcp.bux() && cRu != null) {
                        this.kcp.c(cRu);
                        return;
                    } else {
                        this.kcp.setRefreshing(false);
                        return;
                    }
                }
                return;
            }
        }
        z3 = false;
        if (this.kkS != null) {
        }
        if (z) {
        }
        if (this.klh != null) {
        }
        if (z3) {
        }
        cRr();
        if (this.kkR != null) {
        }
        this.kkX = true;
        this.jZV = z;
        this.kkY = size;
        cvS();
        setIsLoading(false);
        if (this.kcp == null) {
        }
    }

    private f.e cRu() {
        int i;
        String feedText;
        if (!this.kkX || this.kcp == null || !this.kcp.bux() || cRy()) {
            return null;
        }
        int i2 = this.kkU;
        if (this.jZV) {
            com.baidu.tieba.s.c.dMH().b(this.kld, false);
            if (sm(false)) {
                i = 3;
            } else {
                i = this.kkY > 0 ? 2 : 0;
            }
        } else if (this.jZV || this.kkU != 0) {
            return null;
        } else {
            i2 = 0;
            i = 2;
        }
        if (this.kjT != null) {
            this.iRa.cFd();
        }
        if (this.kjT != null && this.kjT.getCurrentTabType() != 1) {
            this.iRa.hideTip();
            return null;
        } else if (!this.klb) {
            this.iRa.hideTip();
            return null;
        } else {
            this.kkT = i;
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
                this.jnn = 1000;
            } else {
                this.jnn = 0;
            }
            return new f.e(feedText, this.jnn);
        }
    }

    public void rV(boolean z) {
        if (z) {
            this.kkf.notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        if (this.iRf != null) {
            this.iRf.destroy();
        }
        if (this.iRa != null) {
            this.iRa.onDestroy();
        }
        if (this.kkQ != null) {
            this.kkQ.onDestroy();
        }
        if (this.joh != null) {
            this.joh.removeCallbacks(this.klp);
        }
        MessageManager.getInstance().unRegisterTask(2016323);
        MessageManager.getInstance().unRegisterListener(this.jjV);
        MessageManager.getInstance().unRegisterListener(this.iQW);
        MessageManager.getInstance().unRegisterListener(this.iQX);
        MessageManager.getInstance().unRegisterListener(this.klt);
    }

    public void onPause() {
        c.i(this.joh);
        BZ(this.klo);
        if (this.kkW != null) {
            this.kkW.bEe();
        }
    }

    private void ble() {
        if (this.kkR != null) {
            this.kkR.b((this.kkS == null || this.kkS.thread_list == null || cRx()) ? 0 : this.kkS.thread_list.size(), sk(true), 0);
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
                if (!(nVar instanceof com.baidu.tieba.homepage.personalize.data.a) || nVar.getType() == AdvertAppInfo.eMH) {
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
                if ((nVar2 instanceof com.baidu.tieba.homepage.personalize.data.a) && nVar2.getType() != AdvertAppInfo.eMH) {
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
        this.kcA = true;
        if (dataRes != null) {
            if (a(false, true, true, dataRes) && !cRx()) {
                if (this.kkR != null) {
                    this.kkR.si(true);
                    Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler() { // from class: com.baidu.tieba.homepage.personalize.e.2
                        @Override // android.os.MessageQueue.IdleHandler
                        public boolean queueIdle() {
                            e.this.bEh();
                            return false;
                        }
                    });
                }
                if (TbSingleton.getInstance().getForceRefreshHomeRecommend()) {
                    ble();
                    TbSingleton.getInstance().setForceRefreshHomeRecommend(false);
                    return;
                }
                return;
            }
            ble();
            return;
        }
        ble();
    }

    public void bEh() {
        com.baidu.tbadk.n.l.bEp().eB(System.currentTimeMillis() - com.baidu.tbadk.n.l.bEp().bEo());
    }

    private void i(List<n> list, int i) {
        Set<n> a2 = com.baidu.tieba.recapp.a.a(list, this.mPn, "NEWINDEX");
        if (a2.size() > 0) {
            com.baidu.tieba.s.c.dMH().b(this.kld, com.baidu.tieba.s.a.b(PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE, "common_fill", true, a2.size()));
        }
    }

    private boolean a(boolean z, boolean z2, boolean z3, DataRes dataRes) {
        boolean z4;
        if (dataRes == null) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.klf == 1) {
            if (z2 && (dataRes.thread_list.size() >= 6 || cRx())) {
                cRw();
                this.kkS = null;
            }
        } else if (z2 && cRx()) {
            this.kkS = null;
        }
        int size = z2 ? 0 : this.mDataList.size();
        DataRes.Builder builder = new DataRes.Builder(dataRes);
        this.mDataList.clear();
        com.baidu.tieba.homepage.personalize.model.c a2 = this.kkV.a(z, this.kkS, builder, z2 ? 0 : 1);
        List<n> list = null;
        int i = 0;
        if (a2 != null) {
            list = a2.gdY;
            this.kkU = a2.koa;
            i = a2.kob;
            a2.kob = 0;
        }
        int i2 = i;
        if (list != null) {
            this.mDataList.addAll(list);
            i(list, size);
            a(z2 ? 0 : 1, list, size);
            if (this.kkZ) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
            }
        }
        if (this.kkS == null) {
            this.kkS = builder;
            this.kkQ.eb(this.kkS.thread_list);
        }
        if (this.mDataList.size() == 0) {
            z4 = false;
        } else {
            if (z2) {
                if (dataRes.live_answer != null) {
                    this.kla = new h();
                    this.kla.a(dataRes.live_answer);
                    this.kkS.live_answer = dataRes.live_answer;
                } else if (z) {
                    this.kla = null;
                    this.kkS.live_answer = null;
                }
                this.klc = dataRes.float_info;
                this.kkS.float_info = dataRes.float_info;
            }
            long j = com.baidu.tbadk.core.sharedPref.b.brR().getLong("key_maintab_banner_close_time", 0L);
            if (this.kla != null && !au.isTaday(j)) {
                TbSingleton.getInstance().isAddBanner = true;
                this.mDataList.add(0, this.kla);
            }
            LinkedList linkedList = new LinkedList(this.mDataList);
            this.kkf.setFromCDN(dataRes.is_new_url != null && dataRes.is_new_url.intValue() == 1);
            this.kkf.j(linkedList, i2);
            z4 = true;
            if (this.iRf != null && this.kib) {
                this.iRf.b(this.jkn, this.gAO, this.jkX, true);
            }
        }
        com.baidu.tieba.homepage.framework.a.cPB().C(System.currentTimeMillis() - currentTimeMillis, 1);
        long BE = com.baidu.tieba.homepage.framework.a.cPB().BE(1);
        if (BE > 0) {
            com.baidu.tieba.homepage.framework.a.cPB().D(System.currentTimeMillis() - BE, 1);
            com.baidu.tieba.homepage.framework.a.cPB().E(0L, 1);
        }
        if (dataRes.anti != null && dataRes.anti.block_pop_info != null) {
            com.baidu.tieba.ueg.d.d(dataRes.anti.block_pop_info);
        }
        bl blVar = new bl();
        blVar.a(dataRes.recom_post_topic);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_REFRESH_TOPIC_TIP, blVar));
        if (!z && BE > 0) {
            com.baidu.tbadk.n.l.bEp().eN(System.currentTimeMillis() - BE);
            return z4;
        }
        return z4;
    }

    private void cRv() {
        int i;
        List<n> list = null;
        if (y.getCount(this.mDataList) >= this.kkV.cRV() - 40) {
            com.baidu.tieba.homepage.personalize.model.c a2 = this.kkV.a(true, this.kkS, null, 1);
            if (a2 != null) {
                list = a2.gdY;
                i = a2.kob;
                a2.kob = 0;
            } else {
                i = 0;
            }
            if (list != null) {
                this.mDataList.clear();
                this.mDataList.addAll(list);
                this.kkf.j(new LinkedList(this.mDataList), i);
            }
        }
    }

    private void blf() {
        this.kcA = true;
        af.a(new ae<DataRes>() { // from class: com.baidu.tieba.homepage.personalize.e.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.ae
            /* renamed from: cRC */
            public DataRes doInBackground() {
                com.baidu.adp.lib.cache.l<byte[]> dE = com.baidu.tbadk.core.c.a.bqt().dE("tb.rec_frs_update", TbadkCoreApplication.getCurrentAccount());
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

    private void cvS() {
        if (this.kkS != null) {
            DataRes.Builder builder = new DataRes.Builder(this.kkS.build(true));
            if (builder.thread_list != null && builder.thread_list.size() > 30) {
                builder.thread_list = builder.thread_list.subList(0, 30);
            }
            a(builder, builder.thread_list != null ? builder.thread_list.size() : 0);
            a(builder);
            b(builder);
            c(builder);
        }
    }

    private void cRw() {
        if (this.kkS != null) {
            final DataRes.Builder builder = new DataRes.Builder(this.kkS.build(true));
            if (builder.thread_list != null && builder.thread_list.size() > 50) {
                builder.thread_list = builder.thread_list.subList(0, 50);
            }
            a(builder, builder.thread_list != null ? builder.thread_list.size() : 0);
            af.a(new ae<Object>() { // from class: com.baidu.tieba.homepage.personalize.e.5
                @Override // com.baidu.tbadk.util.ae
                public Object doInBackground() {
                    DataRes.Builder builder2 = new DataRes.Builder(builder.build(true));
                    e.this.kkQ.ec(builder2.thread_list);
                    try {
                        com.baidu.tbadk.core.c.a.bqt().dE("tb.rec_old_data", TbadkCoreApplication.getCurrentAccount()).setForever("0", builder2.build(true).toByteArray());
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
    public void Mk(String str) {
        if (!TextUtils.isEmpty(str) && this.kkS != null && this.kkS.banner_list != null && this.kkS.banner_list.app != null && this.kkS.banner_list.app.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (App app : this.kkS.banner_list.app) {
                if (app != null && str.equals(app.id)) {
                    arrayList.add(app);
                }
            }
            BannerList.Builder builder = new BannerList.Builder(this.kkS.banner_list);
            if (builder.app != null) {
                builder.app.removeAll(arrayList);
            }
            this.kkS.banner_list = builder.build(false);
            DataRes.Builder builder2 = new DataRes.Builder(this.kkS.build(true));
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
                e.this.kkQ.ec(builder2.thread_list);
                try {
                    com.baidu.tbadk.core.c.a.bqt().dE("tb.rec_frs_update", TbadkCoreApplication.getCurrentAccount()).setForever("0", builder2.build(true).toByteArray());
                    return null;
                } catch (Exception e) {
                    BdLog.e(e);
                    return null;
                }
            }
        }, null);
    }

    private boolean cRx() {
        return sm(true);
    }

    private boolean sm(boolean z) {
        long j = com.baidu.tbadk.core.sharedPref.b.brR().getLong(SharedPrefConfig.RECOMMEND_FRS_REFRESH_TIME + TbadkCoreApplication.getCurrentAccount(), 0L);
        return j == 0 ? z : Math.abs(System.currentTimeMillis() - j) > this.kkP;
    }

    public void a(a aVar) {
        this.kkR = aVar;
    }

    private boolean isLoading() {
        return this.mIsLoading;
    }

    private void setIsLoading(boolean z) {
        this.mIsLoading = z;
    }

    public void cRj() {
        boolean z = true;
        com.baidu.tbadk.coreExtra.data.b activityPrizeData = TbadkCoreApplication.getInst().getActivityPrizeData();
        if (activityPrizeData.isSwitchTurn() && !StringUtils.isNull(activityPrizeData.getFeedText())) {
            String currentDay = UtilHelper.getCurrentDay();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            String str = "";
            if (!StringUtils.isNull(currentAccount)) {
                String string = com.baidu.tbadk.core.sharedPref.b.brR().getString(SharedPrefConfig.ACTIVITY_PRIZE_FEED_TEXT_TIME, "");
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
                    cF(4, 0);
                    com.baidu.tbadk.core.sharedPref.b.brR().putString(SharedPrefConfig.ACTIVITY_PRIZE_FEED_TEXT_TIME, str);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sn(boolean z) {
        boolean z2 = com.baidu.tbadk.core.sharedPref.b.brR().getBoolean("key_youngster_homgpage_top_view_closed", false);
        if (this.joh != null && !z2) {
            if (z) {
                if (this.kle == null) {
                    this.kle = new HomePageYoungsterTopView(this.mPageContext);
                    this.kle.setOnDeleteClick(new HomePageYoungsterTopView.a() { // from class: com.baidu.tieba.homepage.personalize.e.7
                        @Override // com.baidu.tieba.homepage.personalize.view.HomePageYoungsterTopView.a
                        public void cRD() {
                            new BdTopToast(e.this.mPageContext.getPageActivity(), 2000).zm(true).Vg(e.this.mPageContext.getPageActivity().getString(R.string.youngster_frs_top_toast)).aR((ViewGroup) e.this.mPageContext.getPageActivity().findViewById(R.id.maintabContainer));
                            e.this.sn(false);
                            com.baidu.tbadk.core.sharedPref.b.brR().putBoolean("key_youngster_homgpage_top_view_closed", true);
                        }
                    });
                }
                this.joh.setHeaderView(this.kle, false);
                this.kle.setVisibility(0);
                this.joh.scrollToPosition(0);
            } else if (this.kle != null) {
                this.kle.setVisibility(8);
                this.joh.removeHeaderView(this.kle);
                this.kle = null;
            }
        }
    }

    private boolean cRy() {
        return this.kle != null && this.kle.getVisibility() == 0;
    }

    private void cF(int i, int i2) {
        if (!cRy()) {
            if (this.kjT != null) {
                this.iRa.cFd();
            }
            if (this.kjT != null && this.kjT.getCurrentTabType() != 1) {
                this.iRa.hideTip();
            } else if (!this.klb) {
                this.iRa.hideTip();
            } else {
                this.kkT = i;
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
                        this.jnn = 3000;
                    } else {
                        this.jnn = 2000;
                    }
                    this.iRb.fll = str;
                    this.iRb.jng = this.jnn;
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 49;
                    if (this.kjT != null) {
                        FrameLayout frameLayout = this.kjT.getFrameLayout();
                        frameLayout.removeView(this.iRb);
                        frameLayout.addView(this.iRb, layoutParams);
                        this.iRb.cFb();
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(Long l) {
        if (this.kkS != null && this.kkS.thread_list != null) {
            List<ThreadInfo> list = this.kkS.thread_list;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                ThreadInfo threadInfo = list.get(i);
                if (threadInfo.tid.equals(l) && threadInfo.top_agree_post != null) {
                    ThreadInfo.Builder builder = new ThreadInfo.Builder(threadInfo);
                    builder.top_agree_post = null;
                    list.set(i, builder.build(true));
                    cvS();
                    a(false, true, false, this.kkS.build(true));
                    return;
                }
            }
        }
    }

    public void o(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.kld = bdUniqueId;
            if (this.jFn != null) {
                this.jFn.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.jFn);
            }
            if (this.klj != null) {
                this.klj.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.klj);
            }
            this.klk.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.klk);
            this.fci.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.fci);
            this.kcG.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_LIKE_FORUM, this.kcG);
            MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_UNLIKE_FORUM, this.kcG);
            this.klm.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.klm);
            this.iQU.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.iQU);
            this.iQV.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.iQV);
            this.jrj.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.jrj);
            if (this.iRf != null) {
                this.iRf.setUniqueId(bdUniqueId);
            }
            this.kkQ.l(bdUniqueId);
            this.klr.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.klr);
            this.jjU.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.jjU);
            this.kls.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.kls);
            this.kll.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.kll);
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
                        com.baidu.adp.lib.cache.l<byte[]> dE = com.baidu.tbadk.core.c.a.bqt().dE("tb.rec_frs_update", TbadkCoreApplication.getCurrentAccount());
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
                        e.this.kkQ.ec(builder5.thread_list);
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

    public void cRz() {
        this.jia = new com.baidu.tieba.tbadkCore.data.f("new_index", null);
        this.jia.dNq();
    }

    public void a(int i, List<n> list, int i2) {
        int i3;
        int i4;
        if (this.jia != null) {
            if (i == 0) {
                this.jia.dNq();
            }
            if (list != null && !list.isEmpty()) {
                int[] iArr = com.baidu.tieba.tbadkCore.data.f.nyy;
                int i5 = 0;
                int i6 = 0;
                int i7 = 0;
                while (i7 < list.size() && i6 < iArr.length && (i3 = iArr[i6]) >= 0) {
                    if (list.get(i7) instanceof com.baidu.tieba.card.data.b) {
                        i4 = i5 + 1;
                        if (i4 == i3 - 1) {
                            if (i2 < i7 + 1) {
                                this.jia.ds(i3, i7 + 1);
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

    public void BY(int i) {
        if ((this.jia != null ? this.jia.JF(i) : -1) >= 0 && this.joh != null && this.joh.getData() != null && this.joh.getData().size() > i) {
            this.jia.JG(i);
        }
    }

    public i cDL() {
        return this.iRf;
    }

    public void se(boolean z) {
        this.kib = z;
    }

    public void BZ(final int i) {
        af.a(new ae<Object>() { // from class: com.baidu.tieba.homepage.personalize.e.15
            @Override // com.baidu.tbadk.util.ae
            public Object doInBackground() {
                com.baidu.adp.lib.cache.l<String> dF = com.baidu.tbadk.core.c.a.bqt().dF(e.this.kln, TbadkCoreApplication.getCurrentAccount());
                if (dF != null) {
                    dF.set(e.this.kln, Integer.toString(i), 43200000L);
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
            /* renamed from: cRE */
            public String doInBackground() {
                com.baidu.adp.lib.cache.l<String> dF = com.baidu.tbadk.core.c.a.bqt().dF(e.this.kln, TbadkCoreApplication.getCurrentAccount());
                if (dF != null) {
                    return dF.get(e.this.kln);
                }
                return null;
            }
        }, new m<String>() { // from class: com.baidu.tieba.homepage.personalize.e.18
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.m
            /* renamed from: Ml */
            public void onReturnDataInUI(String str) {
                if (dVar != null) {
                    dVar.BF(com.baidu.adp.lib.f.b.toInt(str, 0));
                }
            }
        });
    }

    public void cRm() {
        c.j(this.joh);
    }

    public void cRA() {
        a(this.klq);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cRB() {
        Iterator<n> it = this.mDataList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            } else if (it.next() instanceof com.baidu.tieba.homepage.personalize.data.g) {
                it.remove();
                break;
            }
        }
        if (this.kkS != null) {
            this.kkS.active_center = null;
            cvS();
            if (this.joh != null) {
                List<Integer> k = k(this.joh);
                int intValue = k.get(0).intValue();
                int intValue2 = k.get(1).intValue();
                if (intValue != -1 && intValue2 != -1) {
                    this.joh.p(intValue, intValue2);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(CustomResponsedMessage<?> customResponsedMessage) {
        boolean z;
        String str;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.kkS != null && y.getCount(this.kkS.thread_list) != 0 && y.getCount(this.mDataList) != 0) {
            JSONObject jSONObject = (JSONObject) customResponsedMessage.getData();
            String optString = jSONObject.optString("tid");
            if (StringUtils.isNull(optString)) {
                String optString2 = jSONObject.optString(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_ID);
                if (this.joh != null && !TextUtils.isEmpty(optString2)) {
                    int i = 0;
                    while (true) {
                        if (i >= this.joh.getCount()) {
                            str = optString;
                            break;
                        }
                        n item = this.joh.getItem(i);
                        if (item instanceof com.baidu.tieba.card.data.j) {
                            com.baidu.tieba.card.data.j jVar = (com.baidu.tieba.card.data.j) item;
                            if (jVar.blp() != null && jVar.blp().bol() != null && optString2.equals(String.valueOf(jVar.blp().bol().live_id))) {
                                str = jVar.blp().getTid();
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
                    if (bVar.blp() != null && bVar.blp().getTid() != null) {
                        if (bVar.blp().getTid().equals(optString)) {
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
            if (this.kkS != null && this.kkS.thread_list != null) {
                long j = com.baidu.adp.lib.f.b.toLong(optString, 0L);
                int i2 = 0;
                while (true) {
                    if (i2 < this.kkS.thread_list.size()) {
                        ThreadInfo threadInfo = this.kkS.thread_list.get(i2);
                        if (threadInfo == null || threadInfo.tid == null || threadInfo.tid.longValue() != j) {
                            i2++;
                        } else {
                            com.baidu.tieba.homepage.personalize.readProgressBar.c.a(threadInfo.tid.longValue(), i2, this.kkS.thread_list, this.mDataList);
                            this.kkS.thread_list.remove(i2);
                            cvS();
                            break;
                        }
                    } else {
                        break;
                    }
                }
                if (this.joh != null) {
                    List<Integer> b = b(optString, this.joh);
                    int intValue = b.get(0).intValue();
                    int intValue2 = b.get(1).intValue();
                    if (intValue != -1 && intValue2 != -1) {
                        this.joh.p(intValue, intValue2);
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
                    if (bVar.blp() != null && bVar.blp().getTid().equals(str)) {
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
                    advertAppInfo = ((com.baidu.tieba.homepage.personalize.data.a) next).ctf();
                } else {
                    if (next instanceof an) {
                        an anVar = (an) next;
                        if (anVar.bmg() instanceof AdvertAppInfo.ILegoAdvert) {
                            advertAppInfo = ((AdvertAppInfo.ILegoAdvert) anVar.bmg()).getAdvertAppInfo();
                        }
                    }
                    advertAppInfo = advertAppInfo2;
                }
                if (advertAppInfo != null && str.equals(advertAppInfo.eMU)) {
                    it.remove();
                    advertAppInfo = null;
                }
                advertAppInfo2 = advertAppInfo;
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (this.iRb != null) {
            this.iRb.onChangeSkinType(i);
        }
        if (this.kle != null) {
            this.kle.onChangeSkinType();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ThreadCardViewHolder cQJ() {
        if (this.iRf == null || this.iRf.dAk() == null || !(this.iRf.dAk().getTag() instanceof ThreadCardViewHolder)) {
            return null;
        }
        return (ThreadCardViewHolder) this.iRf.dAk().getTag();
    }
}
