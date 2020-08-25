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
import com.baidu.card.al;
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
import com.baidu.tbadk.util.ac;
import com.baidu.tbadk.util.ad;
import com.baidu.tbadk.util.z;
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
import tbclient.GetMyPost.GetMyPostResIdl;
import tbclient.GodInfo;
import tbclient.Personalized.DataRes;
import tbclient.Personalized.FloatInfo;
import tbclient.ThreadInfo;
import tbclient.User;
import tbclient.Zan;
/* loaded from: classes16.dex */
public class e {
    private View.OnTouchListener eIe;
    private z eVC;
    private be hBG;
    private SmartBubbleAnimatedView hBH;
    private i hBL;
    private com.baidu.tieba.tbadkCore.data.f hSL;
    private final BdTypeRecyclerView hYQ;
    private boolean iEw;
    private final BigdaySwipeRefreshLayout iGB;
    private ScrollFragmentTabHost iMk;
    private final af iMw;
    private Runnable iND;
    private final long iNd;
    private final b iNe;
    private DataRes.Builder iNg;
    private final com.baidu.tieba.homepage.personalize.model.a iNj;
    private int iNm;
    private h iNo;
    private BdUniqueId iNr;
    private HomePageYoungsterTopView iNs;
    private int iNt;
    private com.baidu.tieba.f.a iuk;
    private final TbPageContext<?> mPageContext;
    private a iNf = null;
    private final List<q> mDataList = new LinkedList();
    private int mPn = 1;
    private boolean mIsLoading = false;
    private boolean iGJ = false;
    private int iNh = 2;
    private int iNi = 0;
    private TextView mTipView = null;
    private int hXW = 2000;
    private com.baidu.tbadk.n.c iNk = null;
    private boolean hVG = false;
    private int hUW = 0;
    private int fCF = 0;
    private boolean mIsBackground = false;
    private boolean iKW = true;
    private boolean iNl = false;
    private boolean iNn = false;
    private boolean iNp = true;
    private FloatInfo iNq = null;
    private BdUniqueId iNu = BdUniqueId.gen();
    private a.C0095a hTg = new a.C0095a(2);
    private ThreadInfo iNv = null;
    private RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.e.12
        private int iNM = -1;
        private int iGR = 0;
        private boolean iNN = false;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (e.this.iNk == null) {
                e.this.iNk = new com.baidu.tbadk.n.c();
                e.this.iNk.setSubType(1005);
                e.this.iNk.pageType = 1;
            }
            if (e.this.eVC != null && !e.this.mIsBackground) {
                e.this.eVC.k(recyclerView, i);
            }
            if (i == 0) {
                c.d(e.this.hYQ);
                e.this.iNk.bue();
                s.cbX().kK(true);
                com.baidu.tieba.a.d.bAA().dA("page_recommend", "show_");
                com.baidu.tieba.s.c.dvE().b(e.this.iNr, false);
                this.iNN = false;
                if (e.this.hBL != null && e.this.iKW && !e.this.mIsBackground) {
                    e.this.hBL.a(e.this.hUW, e.this.fCF, e.this.hVG, 1);
                    return;
                }
                return;
            }
            e.this.iNk.bud();
            if (i == 1) {
                if (e.this.hBG != null) {
                    e.this.hBG.hideTip();
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
            if (this.iGR > i) {
                this.iNN = true;
            }
            if (e.this.eVC != null && !e.this.mIsBackground) {
                e.this.eVC.onScroll(this.iGR, i);
            }
            this.iGR = i;
            int i3 = (i + i2) - 1;
            if (!this.iNN && this.iNM != i3) {
                this.iNM = i3;
                e.this.zW(this.iNM);
            }
            if (this.iNN && this.iNM != i) {
                this.iNM = i;
                e.this.zW(this.iNM);
            }
            e.this.iNC = i;
            e.this.hUW = i;
            e.this.fCF = (i + i2) - 1;
            al cxq = e.this.cxq();
            if (cxq != null && cxq.tR() != null) {
                cxq.tR().b(e.this.hTg);
            }
        }
    };
    private View.OnTouchListener eVD = new View.OnTouchListener() { // from class: com.baidu.tieba.homepage.personalize.e.23
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (e.this.eIe != null) {
                e.this.eIe.onTouch(view, motionEvent);
            }
            if (e.this.iuk != null) {
                e.this.iuk.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private a.InterfaceC0674a hrz = new a.InterfaceC0674a() { // from class: com.baidu.tieba.homepage.personalize.e.29
        @Override // com.baidu.tieba.f.a.InterfaceC0674a
        public void H(int i, int i2) {
            e.this.hVG = false;
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0674a
        public void I(int i, int i2) {
            e.this.hVG = true;
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0674a
        public void bZ(int i, int i2) {
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0674a
        public void J(int i, int i2) {
        }
    };
    private View.OnClickListener iNw = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.e.30
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (e.this.hBG != null) {
                e.this.hBG.hideTip();
            }
        }
    };
    private final CustomMessageListener iNx = new CustomMessageListener(CmdConfigCustom.CMD_RELOAD_HP_PERSONALIZED) { // from class: com.baidu.tieba.homepage.personalize.e.31
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (e.this.hYQ != null) {
                e.this.hBL.cxp();
                e.this.iKW = false;
                e.this.iGB.setRefreshing(true);
            }
        }
    };
    private final CustomMessageListener iNy = new CustomMessageListener(2921461) { // from class: com.baidu.tieba.homepage.personalize.e.32
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (e.this.hYQ != null) {
                e.this.cyd();
            }
        }
    };
    private final CustomMessageListener iNz = new CustomMessageListener(2921486) { // from class: com.baidu.tieba.homepage.personalize.e.33
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data = customResponsedMessage.getData();
            switch (data instanceof Integer ? ((Integer) data).intValue() : 0) {
                case 2:
                    new BdTopToast(e.this.mPageContext.getPageActivity(), 2000).wS(true).Sp(e.this.mPageContext.getPageActivity().getString(R.string.youngster_open_title)).aE((ViewGroup) e.this.mPageContext.getPageActivity().findViewById(R.id.maintabContainer));
                    e.this.pL(true);
                    return;
                case 3:
                    new BdTopToast(e.this.mPageContext.getPageActivity(), 2000).wS(true).Sp(e.this.mPageContext.getPageActivity().getString(R.string.youngster_close_title)).aE((ViewGroup) e.this.mPageContext.getPageActivity().findViewById(R.id.maintabContainer));
                    e.this.pL(false);
                    return;
                case 4:
                default:
                    if (com.baidu.tbadk.youngster.b.b.bze()) {
                        e.this.pL(true);
                        return;
                    }
                    return;
                case 5:
                    new BdTopToast(e.this.mPageContext.getPageActivity(), 2000).wS(true).Sp(e.this.mPageContext.getPageActivity().getString(R.string.youngster_reset_title)).aE((ViewGroup) e.this.mPageContext.getPageActivity().findViewById(R.id.maintabContainer));
                    e.this.pL(true);
                    return;
            }
        }
    };
    private CustomMessageListener imT = new CustomMessageListener(CmdConfigCustom.PB_ACTION_PRAISE) { // from class: com.baidu.tieba.homepage.personalize.e.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            bw bwVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bw) && e.this.iNg != null && y.getCount(e.this.iNg.thread_list) != 0 && (bwVar = (bw) customResponsedMessage.getData()) != null && bwVar.bep() != null && bwVar.getId() != null && y.getCount(e.this.iNg.thread_list) != 0) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < e.this.iNg.thread_list.size()) {
                        ThreadInfo threadInfo = e.this.iNg.thread_list.get(i2);
                        if (threadInfo == null || threadInfo.id.longValue() != com.baidu.adp.lib.f.b.toLong(bwVar.getId(), -1L)) {
                            i = i2 + 1;
                        } else {
                            ThreadInfo.Builder builder = new ThreadInfo.Builder(threadInfo);
                            Zan.Builder builder2 = new Zan.Builder(builder.zan);
                            builder2.num = Integer.valueOf((int) bwVar.bep().getNum());
                            builder.zan = builder2.build(true);
                            e.this.iNg.thread_list.set(i2, builder.build(true));
                            return;
                        }
                    } else {
                        return;
                    }
                }
            }
        }
    };
    private CustomMessageListener iNA = new CustomMessageListener(CmdConfigCustom.CMD_LIVE_VIDEO_CLOSED_QUERY_RESPONSED) { // from class: com.baidu.tieba.homepage.personalize.e.9
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
                        if ((originData.get(i2) instanceof bw) && (bwVar = (bw) originData.get(i2)) != null && bwVar.beY() != null && ids.contains(Long.valueOf(bwVar.beY().live_id))) {
                            e.this.mDataList.remove(bwVar);
                        }
                        i = i2 + 1;
                    }
                    if (e.this.iMw != null) {
                        e.this.iMw.bS(new ArrayList(e.this.mDataList));
                    }
                }
            }
        }
    };
    private CustomMessageListener ekH = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.homepage.personalize.e.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int intValue;
            if ((customResponsedMessage instanceof UpdateAttentionMessage) && e.this.iNg != null && !y.isEmpty(e.this.iNg.thread_list)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid)) {
                    int i = 0;
                    while (true) {
                        if (i >= e.this.iNg.thread_list.size()) {
                            break;
                        }
                        ThreadInfo threadInfo = e.this.iNg.thread_list.get(i);
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
                            e.this.iNg.thread_list.set(i, builder.build(true));
                        }
                    }
                    e.this.a(updateAttentionMessage);
                }
            }
        }
    };
    private String iNB = "lastReadReadPositionKey";
    private int iNC = 0;
    private d iNE = new d() { // from class: com.baidu.tieba.homepage.personalize.e.15
        @Override // com.baidu.tieba.homepage.personalize.d
        public void zF(final int i) {
            if (e.this.iND == null) {
                e.this.iND = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.e.15.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (e.this.hYQ.getHandler() != null) {
                            e.this.hYQ.requestFocusFromTouch();
                            if (i <= e.this.hYQ.getCount() - 1) {
                                e.this.hYQ.setSelection(i);
                            }
                        }
                    }
                };
            }
            e.this.hYQ.removeCallbacks(e.this.iND);
            e.this.hYQ.post(e.this.iND);
        }
    };
    private CustomMessageListener iNF = new CustomMessageListener(2016569) { // from class: com.baidu.tieba.homepage.personalize.e.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && e.this.iNo != null) {
                e.this.mDataList.remove(e.this.iNo);
                e.this.iMw.bS(new ArrayList(e.this.mDataList));
                com.baidu.tbadk.core.sharedPref.b.bik().putLong("key_maintab_banner_close_time", System.currentTimeMillis());
            }
        }
    };
    private CustomMessageListener hBA = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.homepage.personalize.e.19
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.g(customResponsedMessage);
            if (e.this.hBL != null && e.this.iKW) {
                e.this.hBL.a(e.this.hUW, e.this.fCF, e.this.hVG, true);
            }
        }
    };
    private CustomMessageListener hBB = new CustomMessageListener(CmdConfigCustom.CMD_THREAD_NOT_EXIST_WHEN_ENTER_PB) { // from class: com.baidu.tieba.homepage.personalize.e.20
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.g(customResponsedMessage);
        }
    };
    private CustomMessageListener inh = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.homepage.personalize.e.21
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && e.this.iNg != null && y.getCount(e.this.iNg.thread_list) != 0) {
                String str = (String) customResponsedMessage.getData();
                e.this.h(str, e.this.mDataList);
                e.this.JI(str);
                if (e.this.iMw != null) {
                    e.this.iMw.bS(new ArrayList(e.this.mDataList));
                }
                if (e.this.hBL != null && e.this.iKW) {
                    e.this.hBL.a(e.this.hUW, e.this.fCF, e.this.hVG, true);
                }
            }
        }
    };
    private CustomMessageListener hUD = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.homepage.personalize.e.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            al cxq;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent)) {
                KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24 && (cxq = e.this.cxq()) != null && cxq.tR() != null) {
                    cxq.tR().b(new a.C0095a(3));
                }
            }
        }
    };
    private com.baidu.adp.framework.listener.a iNG = new com.baidu.adp.framework.listener.a(1003065, CmdConfigSocket.CMD_TOPIC_BLESS) { // from class: com.baidu.tieba.homepage.personalize.e.24
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
                        if ((qVar instanceof com.baidu.tieba.homepage.topic.topictab.b.a) && (bVar = ((com.baidu.tieba.homepage.topic.topictab.b.a) qVar).iUF) != null && longValue == bVar.pkId) {
                            bVar.userPkId = j2;
                            return;
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener hUE = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.homepage.personalize.e.25
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            List<q> dataList = e.this.iMw.getDataList();
            if (!y.isEmpty(dataList)) {
                for (q qVar : dataList) {
                    if (qVar instanceof l) {
                        l lVar = (l) qVar;
                        if (lVar.eaP != 0 && lVar.dUS != null) {
                            int[] imageWidthAndHeight = lVar.dUS.getImageWidthAndHeight();
                            lVar.eaP = imageWidthAndHeight[0];
                            lVar.eaQ = imageWidthAndHeight[1];
                        }
                    }
                }
            }
            com.baidu.adp.lib.f.e.mS().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.personalize.e.25.1
                @Override // java.lang.Runnable
                public void run() {
                    e.this.iMw.notifyDataSetChanged();
                    if (!e.this.mIsBackground && e.this.iKW) {
                        e.this.hBL.a(e.this.hUW, e.this.fCF, e.this.hVG, true);
                    }
                }
            }, 500L);
        }
    };
    private CustomMessageListener hBC = new CustomMessageListener(2921453) { // from class: com.baidu.tieba.homepage.personalize.e.26
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.data.be)) {
                com.baidu.tbadk.core.data.be beVar = (com.baidu.tbadk.core.data.be) customResponsedMessage.getData();
                if (beVar.dZO == 1) {
                    int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
                    int equipmentHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst());
                    float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
                    int i = au.bjr().bjs() ? 2 : 1;
                    RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
                    requestGetMyPostNetMessage.setTag(e.this.iNu);
                    requestGetMyPostNetMessage.setParams(com.baidu.adp.lib.f.b.toLong(beVar.tid, 0L), 0L, 0L, equipmentWidth, equipmentHeight, f, i);
                    requestGetMyPostNetMessage.setBFrom("push");
                    MessageManager.getInstance().sendMessage(requestGetMyPostNetMessage);
                }
            }
        }
    };
    private final com.baidu.adp.framework.listener.a hBD = new com.baidu.adp.framework.listener.a(1003010, CmdConfigSocket.CMD_GET_MY_POST) { // from class: com.baidu.tieba.homepage.personalize.e.27
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            GetMyPostResIdl getMyPostResIdl = null;
            if (responsedMessage instanceof GetMyPostHttpResponseMessage) {
                getMyPostResIdl = ((GetMyPostHttpResponseMessage) responsedMessage).getResponseData();
            } else if (responsedMessage instanceof GetMyPostSocketResponseMessage) {
                getMyPostResIdl = ((GetMyPostSocketResponseMessage) responsedMessage).getResponseData();
            }
            if (getMyPostResIdl != null && getMyPostResIdl.data != null && getMyPostResIdl.data.thread_info != null) {
                e.this.iNv = getMyPostResIdl.data.thread_info;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921455));
            }
        }
    };
    private CustomMessageListener iNH = new CustomMessageListener(2921482) { // from class: com.baidu.tieba.homepage.personalize.e.28
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (com.baidu.tbadk.coreExtra.c.a.w(TbadkCoreApplication.getInst(), 1)) {
                com.baidu.tbadk.coreExtra.c.a.a(e.this.mPageContext, 7, 0L);
            }
        }
    };

    /* loaded from: classes16.dex */
    public interface a {
        void B(int i, int i2, int i3, int i4);

        void O(int i, int i2, int i3);

        void cxQ();

        void onError(int i, String str);

        void onSuccess();
    }

    public void pI(boolean z) {
        this.iNp = z;
        if (this.hBG != null && !z) {
            this.hBG.hideTip();
        }
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.iMk = scrollFragmentTabHost;
        if (this.iMk != null) {
            this.iMk.setOnTabSelectedListener(new ScrollFragmentTabHost.b() { // from class: com.baidu.tieba.homepage.personalize.e.1
                @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.b
                public void zP(int i) {
                    if (e.this.iMk.zO(i) != 1 && e.this.hBG != null) {
                        e.this.hBG.hideTip();
                    }
                }
            });
        }
    }

    public void setTabInForeBackgroundState(boolean z) {
        this.mIsBackground = z;
    }

    public void or(boolean z) {
        boolean z2 = false;
        this.mIsBackground = z;
        if (this.iMk != null) {
            this.iMk.or(z);
        }
        if (this.hBL != null) {
            this.hBL.rF(!z);
            al cxq = cxq();
            if (cxq != null && cxq.tR() != null) {
                z2 = cxq.tR().b(new a.C0095a(8, Boolean.valueOf(z)));
            }
            if (!z2) {
                if (z) {
                    this.hBL.cxp();
                } else if (this.iKW) {
                    this.hBL.a(this.hUW, this.fCF, this.hVG, true);
                }
            }
        }
    }

    public e(TbPageContext<?> tbPageContext, BdTypeRecyclerView bdTypeRecyclerView, af afVar, BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout) {
        this.iNt = 0;
        this.mPageContext = tbPageContext;
        this.iNt = com.baidu.tbadk.core.sharedPref.b.bik().getInt("key_personalized_refresh_type", 0);
        this.iGB = bigdaySwipeRefreshLayout;
        this.hYQ = bdTypeRecyclerView;
        this.hYQ.setOnTouchListener(this.eVD);
        if (com.baidu.tbadk.youngster.b.b.bze()) {
            pL(true);
        }
        this.iuk = new com.baidu.tieba.f.a();
        this.iuk.a(this.hrz);
        this.iMw = afVar;
        this.iNj = new com.baidu.tieba.homepage.personalize.model.a();
        this.iNd = com.baidu.tbadk.core.sharedPref.b.bik().getLong("recommend_frs_cache_time", 1800L) * 1000;
        bdTypeRecyclerView.setOnScrollListener(this.mOnScrollListener);
        this.hBG = new be();
        cyb();
        this.hBL = new i(this.mPageContext, this.hYQ);
        this.hBL.FH(1);
        this.hBL.FG(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.iNe = new b(this.mDataList, this.iMw);
        this.hBH = new SmartBubbleAnimatedView(tbPageContext.getContext());
        this.hBH.setLayoutParams(new FrameLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(tbPageContext.getContext(), R.dimen.tbds83)));
        cxR();
        this.hUE.setTag(this.mPageContext.getUniqueId());
        MessageManager.getInstance().registerListener(this.hUE);
        if (MessageManager.getInstance().findTask(1003010) == null) {
            HomePageStatic.cvY();
        }
        this.hBD.setTag(this.iNu);
        if (this.hBD.getHttpMessageListener() != null) {
            this.hBD.getHttpMessageListener().setSelfListener(true);
        }
        if (this.hBD.getSocketMessageListener() != null) {
            this.hBD.getSocketMessageListener().setSelfListener(true);
        }
        MessageManager.getInstance().registerListener(this.hBD);
        MessageManager.getInstance().registerListener(this.hBC);
        MessageManager.getInstance().registerListener(this.iNH);
    }

    private void cxR() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2016323, new CustomMessageTask.CustomRunnable<Boolean>() { // from class: com.baidu.tieba.homepage.personalize.e.34
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Boolean> customMessage) {
                al cxq = e.this.cxq();
                return (cxq == null || cxq.tR() == null) ? new CustomResponsedMessage<>(2016323, false) : new CustomResponsedMessage<>(2016323, Boolean.valueOf(cxq.tR().b(new a.C0095a(6))));
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private boolean cxS() {
        return com.baidu.tbadk.core.sharedPref.b.bik().getBoolean(cxU(), true);
    }

    private void cxT() {
        com.baidu.tbadk.core.sharedPref.b.bik().putBoolean(cxU(), false);
    }

    private String cxU() {
        return "key_rec_pfirst_load_" + TbadkCoreApplication.getCurrentAccount() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + TbConfig.getVersion();
    }

    public void setRecommendFrsNavigationAnimDispatcher(aa aaVar) {
        if (aaVar != null) {
            this.eVC = aaVar.bvG();
            this.eIe = aaVar.bvH();
        }
    }

    public void showFloatingView() {
        if (this.eVC != null) {
            this.eVC.showFloatingView(true);
        }
    }

    public void update() {
        com.baidu.tieba.homepage.framework.a.cwo().r(System.currentTimeMillis(), 1);
        this.mPn = 1;
        this.iNn = true;
        if (this.mDataList.size() == 0 && !cxS()) {
            if (!this.iGJ) {
                bbW();
                return;
            }
            return;
        }
        bbV();
    }

    public void cx(int i, int i2) {
        bw bwVar;
        if (!y.isEmpty(this.mDataList) && this.mDataList.size() > i) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            while (i < this.mDataList.size() && i <= i2) {
                if (this.mDataList.get(i).getType().getId() == bw.ebp.getId() && (bwVar = (bw) this.mDataList.get(i)) != null && bwVar.beY() != null) {
                    arrayList.add(Long.valueOf(bwVar.beY().live_id));
                    arrayList2.add(bwVar);
                }
                i++;
            }
            if (!y.isEmpty(arrayList)) {
                MessageManager.getInstance().sendMessage(new LiveRoomClosedQueryMessage(arrayList, arrayList2));
            }
        }
    }

    public void cxV() {
        if (this.hBL != null && !this.mIsBackground && this.iKW) {
            this.hBL.a(this.hUW, this.fCF, this.hVG, true);
        }
        if (this.iNl) {
            if (this.iGB != null && !this.iGB.bkK()) {
                if (this.iEw) {
                    com.baidu.tieba.s.c.dvE().b(this.iNr, false);
                    if (pK(false)) {
                        cy(3, this.iNi);
                    } else if (this.iNm > 0) {
                        cy(2, this.iNi);
                    }
                } else if (!this.iEw && this.iNi == 0) {
                    cy(2, 0);
                }
            }
            this.iNl = false;
            this.iEw = false;
            this.iNm = 0;
            if (this.iNn) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
            }
            this.iNn = false;
        }
    }

    public void bFD() {
        if (isLoading()) {
            com.baidu.tieba.homepage.framework.a.cwo().r(0L, 1);
        } else if (this.iNf != null) {
            cxX();
            this.mPn++;
            setIsLoading(true);
            this.iNf.B(this.mPn, (this.iNg == null || this.iNg.thread_list == null) ? 0 : this.iNg.thread_list.size(), pJ(false), 0);
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
            g.cyi();
        }
        if (this.iNj != null && this.iNj.cyD() && !z && (dataRes == null || y.isEmpty(dataRes.thread_list))) {
            if (dataRes == null) {
                DataRes.Builder builder = new DataRes.Builder();
                builder.thread_list = new ArrayList();
                dataRes = builder.build(false);
            }
            if (dataRes.thread_list != null) {
                List<ThreadInfo> cyE = this.iNj.cyE();
                dataRes.thread_list.addAll(cyE);
                if (cyE != null) {
                    cyE.clear();
                }
                z3 = true;
                size = (this.iNg != null || this.iNg.thread_list == null) ? 0 : this.iNg.thread_list.size();
                if (z && i == 0 && dataRes != null && y.isEmpty(dataRes.thread_list)) {
                    if (this.iNf != null) {
                        this.iNf.cxQ();
                    }
                    setIsLoading(false);
                    if (this.iGB != null) {
                        this.iGB.setRefreshing(false);
                        return;
                    }
                    return;
                }
                if (this.iNv != null) {
                    DataRes.Builder builder2 = new DataRes.Builder(dataRes);
                    builder2.thread_list.add(0, this.iNv);
                    dataRes = builder2.build(false);
                    if (this.iNg != null && !y.isEmpty(this.iNg.thread_list)) {
                        Iterator<ThreadInfo> it = this.iNg.thread_list.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            ThreadInfo next = it.next();
                            if (next != null && next.tid != null && this.iNv.tid != null && next.tid.longValue() == this.iNv.tid.longValue()) {
                                this.iNg.thread_list.remove(next);
                                break;
                            }
                        }
                    }
                    this.iNv = null;
                }
                if ((z3 && i != 0) || dataRes == null || !a(true, z, z2, dataRes)) {
                    this.iNl = false;
                    if (this.mDataList.size() > 0) {
                        if (this.iNf != null) {
                            this.iNf.onError(1, str);
                        }
                    } else if (this.iNf != null) {
                        this.iNf.onError(2, str);
                    }
                } else {
                    cxT();
                    if (this.iNf != null) {
                        com.baidu.tbadk.core.sharedPref.b.bik().putLong(SharedPrefConfig.RECOMMEND_FRS_REFRESH_TIME + TbadkCoreApplication.getCurrentAccount(), System.currentTimeMillis());
                        this.iNf.onSuccess();
                    }
                    this.iNl = true;
                    this.iEw = z;
                    this.iNm = size;
                    cff();
                }
                setIsLoading(false);
                if (this.iGB == null) {
                    f.e cxW = cxW();
                    if (this.iGB.bkK() && cxW != null) {
                        this.iGB.c(cxW);
                        return;
                    } else {
                        this.iGB.setRefreshing(false);
                        return;
                    }
                }
                return;
            }
        }
        z3 = false;
        if (this.iNg != null) {
        }
        if (z) {
        }
        if (this.iNv != null) {
        }
        if (z3) {
        }
        cxT();
        if (this.iNf != null) {
        }
        this.iNl = true;
        this.iEw = z;
        this.iNm = size;
        cff();
        setIsLoading(false);
        if (this.iGB == null) {
        }
    }

    private f.e cxW() {
        int i;
        String feedText;
        if (!this.iNl || this.iGB == null || !this.iGB.bkK() || cya()) {
            return null;
        }
        int i2 = this.iNi;
        if (this.iEw) {
            com.baidu.tieba.s.c.dvE().b(this.iNr, false);
            if (pK(false)) {
                i = 3;
            } else {
                i = this.iNm > 0 ? 2 : 0;
            }
        } else if (this.iEw || this.iNi != 0) {
            return null;
        } else {
            i2 = 0;
            i = 2;
        }
        if (this.iMk != null) {
            this.hBG.com();
        }
        if (this.iMk != null && this.iMk.getCurrentTabType() != 1) {
            this.hBG.hideTip();
            return null;
        } else if (!this.iNp) {
            this.hBG.hideTip();
            return null;
        } else {
            this.iNh = i;
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
                this.hXW = 1000;
            } else {
                this.hXW = 0;
            }
            return new f.e(feedText, this.hXW);
        }
    }

    public void py(boolean z) {
        if (z) {
            this.iMw.notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        if (this.hBL != null) {
            this.hBL.destroy();
        }
        if (this.hBG != null) {
            this.hBG.onDestroy();
        }
        if (this.iNe != null) {
            this.iNe.onDestroy();
        }
        if (this.hYQ != null) {
            this.hYQ.removeCallbacks(this.iND);
        }
        MessageManager.getInstance().unRegisterTask(2016323);
        MessageManager.getInstance().unRegisterListener(this.hUE);
        MessageManager.getInstance().unRegisterListener(this.hBC);
        MessageManager.getInstance().unRegisterListener(this.hBD);
        MessageManager.getInstance().unRegisterListener(this.iNH);
    }

    public void onPause() {
        c.d(this.hYQ);
        zX(this.iNC);
        if (this.iNk != null) {
            this.iNk.buf();
        }
    }

    private void bbV() {
        if (this.iNf != null) {
            this.iNf.O((this.iNg == null || this.iNg.thread_list == null || cxZ()) ? 0 : this.iNg.thread_list.size(), pJ(true), 0);
        }
    }

    public int pJ(boolean z) {
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
                if (!(qVar instanceof com.baidu.tieba.homepage.personalize.data.a) || qVar.getType() == AdvertAppInfo.dVU) {
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
                if ((qVar2 instanceof com.baidu.tieba.homepage.personalize.data.a) && qVar2.getType() != AdvertAppInfo.dVU) {
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
        this.iGJ = true;
        if (dataRes != null) {
            if (a(false, true, true, dataRes) && !cxZ()) {
                if (this.iNf != null) {
                    this.iNf.onSuccess();
                    Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler() { // from class: com.baidu.tieba.homepage.personalize.e.2
                        @Override // android.os.MessageQueue.IdleHandler
                        public boolean queueIdle() {
                            e.this.buk();
                            return false;
                        }
                    });
                }
                if (TbSingleton.getInstance().getForceRefreshHomeRecommend()) {
                    bbV();
                    TbSingleton.getInstance().setForceRefreshHomeRecommend(false);
                    return;
                }
                return;
            }
            bbV();
            return;
        }
        bbV();
    }

    public void buk() {
        long zD = com.baidu.tieba.homepage.framework.a.cwo().zD(1) + com.baidu.tieba.homepage.framework.a.cwo().getCreateTime();
        long zB = com.baidu.tieba.homepage.framework.a.cwo().zB(1);
        if (zB > 0) {
            zD = System.currentTimeMillis() - zB;
        }
        n.bus().dz(zD);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.util.Set] */
    private void i(List<q> list, int i) {
        AdvertAppInfo ccr;
        AdvertAppInfo ccr2;
        if (!y.isEmpty(list)) {
            Set<q> PA = com.baidu.tieba.recapp.report.a.PA("NEWINDEX");
            HashSet hashSet = PA == null ? new HashSet() : PA;
            HashSet hashSet2 = new HashSet();
            for (q qVar : list) {
                if (qVar != null) {
                    for (q qVar2 : hashSet) {
                        if ((qVar instanceof com.baidu.tieba.card.data.e) && (ccr2 = ((com.baidu.tieba.card.data.e) qVar).ccr()) != null && qVar2 != null && (qVar2 instanceof AdvertAppInfo) && qVar2.hashCode() == ccr2.hashCode()) {
                            ccr2.advertAppContext = ((AdvertAppInfo) qVar2).advertAppContext;
                        }
                    }
                    if (qVar != null && (qVar instanceof com.baidu.tieba.card.data.e) && (ccr = ((com.baidu.tieba.card.data.e) qVar).ccr()) != null && ccr.advertAppContext == null) {
                        ccr.advertAppContext = new com.baidu.tbadk.core.data.b();
                        ccr.advertAppContext.page = "NEWINDEX";
                        ccr.advertAppContext.pn = this.mPn;
                        ccr.advertAppContext.extensionInfo = ccr.extensionInfo;
                        ccr.advertAppContext.Yb = false;
                        hashSet2.add(ccr);
                    }
                }
            }
            hashSet.addAll(hashSet2);
            com.baidu.tieba.recapp.report.a.b("NEWINDEX", hashSet);
            if (hashSet2.size() > 0) {
                com.baidu.tieba.s.c.dvE().b(this.iNr, com.baidu.tieba.s.a.b(PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE, "common_fill", true, hashSet2.size()));
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
        if (this.iNt == 1) {
            if (z2 && (dataRes.thread_list.size() >= 6 || cxZ())) {
                cxY();
                this.iNg = null;
            }
        } else if (z2 && cxZ()) {
            this.iNg = null;
        }
        int size = z2 ? 0 : this.mDataList.size();
        DataRes.Builder builder = new DataRes.Builder(dataRes);
        this.mDataList.clear();
        com.baidu.tieba.homepage.personalize.model.c a2 = this.iNj.a(z, this.iNg, builder, z2 ? 0 : 1);
        if (a2 == null) {
            list = null;
            i = 0;
        } else {
            List<q> list2 = a2.fku;
            this.iNi = a2.iQj;
            int i2 = a2.iQk;
            a2.iQk = 0;
            list = list2;
            i = i2;
        }
        if (list != null) {
            this.mDataList.addAll(list);
            i(list, size);
            a(z2 ? 0 : 1, list, size);
            if (this.iNn) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
            }
        }
        if (this.iNg == null) {
            this.iNg = builder;
            this.iNe.dj(this.iNg.thread_list);
        }
        if (this.mDataList.size() == 0) {
            z4 = false;
        } else {
            if (z2) {
                if (dataRes.live_answer != null) {
                    this.iNo = new h();
                    this.iNo.a(dataRes.live_answer);
                    this.iNg.live_answer = dataRes.live_answer;
                } else if (z) {
                    this.iNo = null;
                    this.iNg.live_answer = null;
                }
                this.iNq = dataRes.float_info;
                this.iNg.float_info = dataRes.float_info;
            }
            long j = com.baidu.tbadk.core.sharedPref.b.bik().getLong("key_maintab_banner_close_time", 0L);
            if (this.iNo != null && !at.isTaday(j)) {
                this.mDataList.add(0, this.iNo);
            }
            LinkedList linkedList = new LinkedList(this.mDataList);
            this.iMw.setFromCDN(dataRes.is_new_url != null && dataRes.is_new_url.intValue() == 1);
            this.iMw.j(linkedList, i);
            z4 = true;
            if (this.hBL != null && this.iKW) {
                this.hBL.a(this.hUW, this.fCF, this.hVG, true);
            }
        }
        com.baidu.tieba.homepage.framework.a.cwo().p(System.currentTimeMillis() - currentTimeMillis, 1);
        long zE = com.baidu.tieba.homepage.framework.a.cwo().zE(1);
        if (zE > 0) {
            com.baidu.tieba.homepage.framework.a.cwo().q(System.currentTimeMillis() - zE, 1);
            com.baidu.tieba.homepage.framework.a.cwo().r(0L, 1);
        }
        if (dataRes.anti != null && dataRes.anti.block_pop_info != null) {
            com.baidu.tieba.ueg.d.d(dataRes.anti.block_pop_info);
        }
        bg bgVar = new bg();
        bgVar.a(dataRes.recom_post_topic);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_REFRESH_TOPIC_TIP, bgVar));
        return z4;
    }

    private void cxX() {
        List<q> list;
        int i;
        if (y.getCount(this.mDataList) >= this.iNj.cyz() - 40) {
            com.baidu.tieba.homepage.personalize.model.c a2 = this.iNj.a(true, this.iNg, null, 1);
            if (a2 != null) {
                List<q> list2 = a2.fku;
                i = a2.iQk;
                a2.iQk = 0;
                list = list2;
            } else {
                list = null;
                i = 0;
            }
            if (list != null) {
                this.mDataList.clear();
                this.mDataList.addAll(list);
                this.iMw.j(new LinkedList(this.mDataList), i);
            }
        }
    }

    private void bbW() {
        this.iGJ = true;
        ad.a(new ac<DataRes>() { // from class: com.baidu.tieba.homepage.personalize.e.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.ac
            /* renamed from: cye */
            public DataRes doInBackground() {
                com.baidu.adp.lib.cache.l<byte[]> dv = com.baidu.tbadk.core.c.a.bhb().dv("tb.rec_frs_update", TbadkCoreApplication.getCurrentAccount());
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
        }, new com.baidu.tbadk.util.l<DataRes>() { // from class: com.baidu.tieba.homepage.personalize.e.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.l
            /* renamed from: b */
            public void onReturnDataInUI(DataRes dataRes) {
                e.this.a(dataRes);
            }
        });
    }

    private void cff() {
        if (this.iNg != null) {
            DataRes.Builder builder = new DataRes.Builder(this.iNg.build(true));
            if (builder.thread_list != null && builder.thread_list.size() > 30) {
                builder.thread_list = builder.thread_list.subList(0, 30);
            }
            a(builder, builder.thread_list != null ? builder.thread_list.size() : 0);
            a(builder);
            b(builder);
            c(builder);
        }
    }

    private void cxY() {
        if (this.iNg != null) {
            final DataRes.Builder builder = new DataRes.Builder(this.iNg.build(true));
            if (builder.thread_list != null && builder.thread_list.size() > 50) {
                builder.thread_list = builder.thread_list.subList(0, 50);
            }
            a(builder, builder.thread_list != null ? builder.thread_list.size() : 0);
            ad.a(new ac<Object>() { // from class: com.baidu.tieba.homepage.personalize.e.5
                @Override // com.baidu.tbadk.util.ac
                public Object doInBackground() {
                    DataRes.Builder builder2 = new DataRes.Builder(builder.build(true));
                    e.this.iNe.dk(builder2.thread_list);
                    try {
                        com.baidu.tbadk.core.c.a.bhb().dv("tb.rec_old_data", TbadkCoreApplication.getCurrentAccount()).setForever("0", builder2.build(true).toByteArray());
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
    public void JI(String str) {
        if (!TextUtils.isEmpty(str) && this.iNg != null && this.iNg.banner_list != null && this.iNg.banner_list.app != null && this.iNg.banner_list.app.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (App app : this.iNg.banner_list.app) {
                if (app != null && str.equals(app.id)) {
                    arrayList.add(app);
                }
            }
            BannerList.Builder builder = new BannerList.Builder(this.iNg.banner_list);
            if (builder.app != null) {
                builder.app.removeAll(arrayList);
            }
            this.iNg.banner_list = builder.build(false);
            DataRes.Builder builder2 = new DataRes.Builder(this.iNg.build(true));
            builder2.banner_list = builder.build(true);
            c(builder2);
        }
    }

    private void c(final DataRes.Builder builder) {
        ad.a(new ac<Object>() { // from class: com.baidu.tieba.homepage.personalize.e.6
            @Override // com.baidu.tbadk.util.ac
            public Object doInBackground() {
                DataRes.Builder builder2 = new DataRes.Builder(builder.build(true));
                e.this.iNe.dk(builder2.thread_list);
                try {
                    com.baidu.tbadk.core.c.a.bhb().dv("tb.rec_frs_update", TbadkCoreApplication.getCurrentAccount()).setForever("0", builder2.build(true).toByteArray());
                    return null;
                } catch (Exception e) {
                    BdLog.e(e);
                    return null;
                }
            }
        }, null);
    }

    private boolean cxZ() {
        return pK(true);
    }

    private boolean pK(boolean z) {
        long j = com.baidu.tbadk.core.sharedPref.b.bik().getLong(SharedPrefConfig.RECOMMEND_FRS_REFRESH_TIME + TbadkCoreApplication.getCurrentAccount(), 0L);
        return j == 0 ? z : Math.abs(System.currentTimeMillis() - j) > this.iNd;
    }

    public void a(a aVar) {
        this.iNf = aVar;
    }

    private boolean isLoading() {
        return this.mIsLoading;
    }

    private void setIsLoading(boolean z) {
        this.mIsLoading = z;
    }

    public void cxN() {
        boolean z = true;
        com.baidu.tbadk.coreExtra.data.b activityPrizeData = TbadkCoreApplication.getInst().getActivityPrizeData();
        if (activityPrizeData.isSwitchTurn() && !StringUtils.isNull(activityPrizeData.getFeedText())) {
            String currentDay = UtilHelper.getCurrentDay();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            String str = "";
            if (!StringUtils.isNull(currentAccount)) {
                String string = com.baidu.tbadk.core.sharedPref.b.bik().getString(SharedPrefConfig.ACTIVITY_PRIZE_FEED_TEXT_TIME, "");
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
                    cy(4, 0);
                    com.baidu.tbadk.core.sharedPref.b.bik().putString(SharedPrefConfig.ACTIVITY_PRIZE_FEED_TEXT_TIME, str);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pL(boolean z) {
        boolean z2 = com.baidu.tbadk.core.sharedPref.b.bik().getBoolean("key_youngster_homgpage_top_view_closed", false);
        if (this.hYQ != null && !z2) {
            if (z) {
                if (this.iNs == null) {
                    this.iNs = new HomePageYoungsterTopView(this.mPageContext);
                    this.iNs.setOnDeleteClick(new HomePageYoungsterTopView.a() { // from class: com.baidu.tieba.homepage.personalize.e.7
                        @Override // com.baidu.tieba.homepage.personalize.view.HomePageYoungsterTopView.a
                        public void cyf() {
                            new BdTopToast(e.this.mPageContext.getPageActivity(), 2000).wS(true).Sp(e.this.mPageContext.getPageActivity().getString(R.string.youngster_frs_top_toast)).aE((ViewGroup) e.this.mPageContext.getPageActivity().findViewById(R.id.maintabContainer));
                            e.this.pL(false);
                            com.baidu.tbadk.core.sharedPref.b.bik().putBoolean("key_youngster_homgpage_top_view_closed", true);
                        }
                    });
                }
                this.hYQ.setHeaderView(this.iNs);
                this.iNs.setVisibility(0);
                this.hYQ.scrollToPosition(0);
            } else if (this.iNs != null) {
                this.iNs.setVisibility(8);
                this.hYQ.removeHeaderView(this.iNs);
            }
        }
    }

    private boolean cya() {
        return this.iNs != null && this.iNs.getVisibility() == 0;
    }

    private void cy(int i, int i2) {
        if (!cya()) {
            if (this.iMk != null) {
                this.hBG.com();
            }
            if (this.iMk != null && this.iMk.getCurrentTabType() != 1) {
                this.hBG.hideTip();
            } else if (!this.iNp) {
                this.hBG.hideTip();
            } else {
                this.iNh = i;
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
                        this.hXW = 3000;
                    } else {
                        this.hXW = 2000;
                    }
                    this.hBH.etm = str;
                    this.hBH.hXP = this.hXW;
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 49;
                    if (this.iMk != null) {
                        FrameLayout frameLayout = this.iMk.getFrameLayout();
                        frameLayout.removeView(this.hBH);
                        frameLayout.addView(this.hBH, layoutParams);
                        this.hBH.cok();
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(Long l) {
        if (this.iNg != null && this.iNg.thread_list != null) {
            List<ThreadInfo> list = this.iNg.thread_list;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                ThreadInfo threadInfo = list.get(i);
                if (threadInfo.tid.equals(l) && threadInfo.top_agree_post != null) {
                    ThreadInfo.Builder builder = new ThreadInfo.Builder(threadInfo);
                    builder.top_agree_post = null;
                    list.set(i, builder.build(true));
                    cff();
                    a(false, true, false, this.iNg.build(true));
                    return;
                }
            }
        }
    }

    public void p(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.iNr = bdUniqueId;
            if (this.imT != null) {
                this.imT.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.imT);
            }
            if (this.iNx != null) {
                this.iNx.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.iNx);
            }
            this.iNy.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.iNy);
            this.ekH.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.ekH);
            this.iNA.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.iNA);
            this.hBA.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.hBA);
            this.hBB.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.hBB);
            this.inh.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.inh);
            if (this.hBL != null) {
                this.hBL.setUniqueId(bdUniqueId);
            }
            this.iNe.m(bdUniqueId);
            this.iNF.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.iNF);
            this.hUD.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.hUD);
            this.iNG.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.iNG);
            this.iNz.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.iNz);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(UpdateAttentionMessage updateAttentionMessage) {
        if (updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid)) {
            final String str = updateAttentionMessage.getData().toUid;
            final boolean z = updateAttentionMessage.getData().isAttention;
            ad.a(new ac<Boolean>() { // from class: com.baidu.tieba.homepage.personalize.e.11
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.baidu.tbadk.util.ac
                public Boolean doInBackground() {
                    int intValue;
                    try {
                        com.baidu.adp.lib.cache.l<byte[]> dv = com.baidu.tbadk.core.c.a.bhb().dv("tb.rec_frs_update", TbadkCoreApplication.getCurrentAccount());
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
                        e.this.iNe.dk(builder5.thread_list);
                        dv.setForever("0", builder5.build(true).toByteArray());
                        return true;
                    } catch (Exception e) {
                        BdLog.e(e);
                        return false;
                    }
                }
            }, new com.baidu.tbadk.util.l<Boolean>() { // from class: com.baidu.tieba.homepage.personalize.e.13
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.l
                public void onReturnDataInUI(Boolean bool) {
                }
            });
        }
    }

    public void cyb() {
        this.hSL = new com.baidu.tieba.tbadkCore.data.f("new_index", null);
        this.hSL.dwl();
    }

    public void a(int i, List<q> list, int i2) {
        int i3;
        int i4;
        if (this.hSL != null) {
            if (i == 0) {
                this.hSL.dwl();
            }
            if (list != null && !list.isEmpty()) {
                int[] iArr = com.baidu.tieba.tbadkCore.data.f.meo;
                int i5 = 0;
                int i6 = 0;
                int i7 = 0;
                while (i7 < list.size() && i6 < iArr.length && (i3 = iArr[i6]) >= 0) {
                    if (list.get(i7) instanceof com.baidu.tieba.card.data.c) {
                        i4 = i5 + 1;
                        if (i4 == i3 - 1) {
                            if (i2 < i7 + 1) {
                                this.hSL.dk(i3, i7 + 1);
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

    public void zW(int i) {
        if ((this.hSL != null ? this.hSL.HM(i) : -1) >= 0 && this.hYQ != null && this.hYQ.getData() != null && this.hYQ.getData().size() > i) {
            this.hSL.HN(i);
        }
    }

    public i cmV() {
        return this.hBL;
    }

    public void pE(boolean z) {
        this.iKW = z;
    }

    public void zX(final int i) {
        ad.a(new ac<Object>() { // from class: com.baidu.tieba.homepage.personalize.e.14
            @Override // com.baidu.tbadk.util.ac
            public Object doInBackground() {
                com.baidu.adp.lib.cache.l<String> dw = com.baidu.tbadk.core.c.a.bhb().dw(e.this.iNB, TbadkCoreApplication.getCurrentAccount());
                if (dw != null) {
                    dw.set(e.this.iNB, Integer.toString(i), 43200000L);
                    return null;
                }
                return null;
            }
        }, null);
    }

    public void a(final d dVar) {
        ad.a(new ac<String>() { // from class: com.baidu.tieba.homepage.personalize.e.16
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.ac
            /* renamed from: cyg */
            public String doInBackground() {
                com.baidu.adp.lib.cache.l<String> dw = com.baidu.tbadk.core.c.a.bhb().dw(e.this.iNB, TbadkCoreApplication.getCurrentAccount());
                if (dw != null) {
                    return dw.get(e.this.iNB);
                }
                return null;
            }
        }, new com.baidu.tbadk.util.l<String>() { // from class: com.baidu.tieba.homepage.personalize.e.17
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.l
            /* renamed from: JJ */
            public void onReturnDataInUI(String str) {
                if (dVar != null) {
                    dVar.zF(com.baidu.adp.lib.f.b.toInt(str, 0));
                }
            }
        });
    }

    public void cxO() {
        c.e(this.hYQ);
    }

    public void cyc() {
        a(this.iNE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cyd() {
        Iterator<q> it = this.mDataList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            } else if (it.next() instanceof com.baidu.tieba.homepage.personalize.data.g) {
                it.remove();
                break;
            }
        }
        if (this.iNg != null) {
            this.iNg.active_center = null;
            cff();
            if (this.hYQ != null) {
                List<Integer> f = f(this.hYQ);
                int intValue = f.get(0).intValue();
                int intValue2 = f.get(1).intValue();
                if (intValue != -1 && intValue2 != -1) {
                    this.hYQ.o(intValue, intValue2);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(CustomResponsedMessage<?> customResponsedMessage) {
        boolean z;
        String str;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.iNg != null && y.getCount(this.iNg.thread_list) != 0 && y.getCount(this.mDataList) != 0) {
            JSONObject jSONObject = (JSONObject) customResponsedMessage.getData();
            String optString = jSONObject.optString("tid");
            if (StringUtils.isNull(optString)) {
                String optString2 = jSONObject.optString(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_ID);
                if (this.hYQ != null && !TextUtils.isEmpty(optString2)) {
                    int i = 0;
                    while (true) {
                        if (i >= this.hYQ.getCount()) {
                            str = optString;
                            break;
                        }
                        q item = this.hYQ.getItem(i);
                        if (item instanceof k) {
                            k kVar = (k) item;
                            if (kVar.bce() != null && kVar.bce().beY() != null && optString2.equals(String.valueOf(kVar.bce().beY().live_id))) {
                                str = kVar.bce().getTid();
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
                    if (cVar.bce() != null && cVar.bce().getTid() != null) {
                        if (cVar.bce().getTid().equals(optString)) {
                            it.remove();
                            z = true;
                            z2 = z;
                        } else if (z2) {
                            com.baidu.tieba.homepage.personalize.model.b.dm(this.mDataList);
                            break;
                        }
                    }
                }
                z = z2;
                z2 = z;
            }
            if (this.iNg != null && this.iNg.thread_list != null) {
                long j = com.baidu.adp.lib.f.b.toLong(optString, 0L);
                int i2 = 0;
                while (true) {
                    if (i2 < this.iNg.thread_list.size()) {
                        ThreadInfo threadInfo = this.iNg.thread_list.get(i2);
                        if (threadInfo == null || threadInfo.tid == null || threadInfo.tid.longValue() != j) {
                            i2++;
                        } else {
                            com.baidu.tieba.homepage.personalize.b.d.a(threadInfo.tid.longValue(), i2, this.iNg.thread_list, this.mDataList);
                            this.iNg.thread_list.remove(i2);
                            cff();
                            break;
                        }
                    } else {
                        break;
                    }
                }
                if (this.hYQ != null) {
                    List<Integer> b = b(optString, this.hYQ);
                    int intValue = b.get(0).intValue();
                    int intValue2 = b.get(1).intValue();
                    if (intValue != -1 && intValue2 != -1) {
                        this.hYQ.o(intValue, intValue2);
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
                    if (cVar.bce() != null && cVar.bce().getTid().equals(str)) {
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
                    advertAppInfo = ((com.baidu.tieba.homepage.personalize.data.a) next).ccr();
                } else {
                    if (next instanceof ak) {
                        ak akVar = (ak) next;
                        if (akVar.bcV() instanceof AdvertAppInfo.ILegoAdvert) {
                            advertAppInfo = ((AdvertAppInfo.ILegoAdvert) akVar.bcV()).getAdvertAppInfo();
                        }
                    }
                    advertAppInfo = advertAppInfo2;
                }
                if (advertAppInfo != null && str.equals(advertAppInfo.dWf)) {
                    it.remove();
                    advertAppInfo = null;
                }
                advertAppInfo2 = advertAppInfo;
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (this.hBH != null) {
            this.hBH.onChangeSkinType(i);
        }
        if (this.iNs != null) {
            this.iNs.onChangeSkinType();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public al cxq() {
        if (this.hBL == null || this.hBL.djT() == null || !(this.hBL.djT().getTag() instanceof al)) {
            return null;
        }
        return (al) this.hBL.djT().getTag();
    }
}
