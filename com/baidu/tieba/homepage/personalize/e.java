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
    private View.OnTouchListener eIi;
    private z eVG;
    private be hBM;
    private SmartBubbleAnimatedView hBN;
    private i hBR;
    private com.baidu.tieba.tbadkCore.data.f hSR;
    private final BdTypeRecyclerView hYW;
    private boolean iEC;
    private final BigdaySwipeRefreshLayout iGH;
    private final af iMC;
    private ScrollFragmentTabHost iMq;
    private Runnable iNJ;
    private final long iNj;
    private final b iNk;
    private DataRes.Builder iNm;
    private final com.baidu.tieba.homepage.personalize.model.a iNp;
    private int iNs;
    private h iNu;
    private BdUniqueId iNx;
    private HomePageYoungsterTopView iNy;
    private int iNz;
    private com.baidu.tieba.f.a iuq;
    private final TbPageContext<?> mPageContext;
    private a iNl = null;
    private final List<q> mDataList = new LinkedList();
    private int mPn = 1;
    private boolean mIsLoading = false;
    private boolean iGP = false;
    private int iNn = 2;
    private int iNo = 0;
    private TextView mTipView = null;
    private int hYc = 2000;
    private com.baidu.tbadk.n.c iNq = null;
    private boolean hVM = false;
    private int hVc = 0;
    private int fCJ = 0;
    private boolean mIsBackground = false;
    private boolean iLc = true;
    private boolean iNr = false;
    private boolean iNt = false;
    private boolean iNv = true;
    private FloatInfo iNw = null;
    private BdUniqueId iNA = BdUniqueId.gen();
    private a.C0095a hTm = new a.C0095a(2);
    private ThreadInfo iNB = null;
    private RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.e.12
        private int iNS = -1;
        private int iGX = 0;
        private boolean iNT = false;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (e.this.iNq == null) {
                e.this.iNq = new com.baidu.tbadk.n.c();
                e.this.iNq.setSubType(1005);
                e.this.iNq.pageType = 1;
            }
            if (e.this.eVG != null && !e.this.mIsBackground) {
                e.this.eVG.k(recyclerView, i);
            }
            if (i == 0) {
                c.d(e.this.hYW);
                e.this.iNq.buf();
                s.cbY().kM(true);
                com.baidu.tieba.a.d.bAB().dA("page_recommend", "show_");
                com.baidu.tieba.s.c.dvJ().b(e.this.iNx, false);
                this.iNT = false;
                if (e.this.hBR != null && e.this.iLc && !e.this.mIsBackground) {
                    e.this.hBR.a(e.this.hVc, e.this.fCJ, e.this.hVM, 1);
                    return;
                }
                return;
            }
            e.this.iNq.bue();
            if (i == 1) {
                if (e.this.hBM != null) {
                    e.this.hBM.hideTip();
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
            if (this.iGX > i) {
                this.iNT = true;
            }
            if (e.this.eVG != null && !e.this.mIsBackground) {
                e.this.eVG.onScroll(this.iGX, i);
            }
            this.iGX = i;
            int i3 = (i + i2) - 1;
            if (!this.iNT && this.iNS != i3) {
                this.iNS = i3;
                e.this.zW(this.iNS);
            }
            if (this.iNT && this.iNS != i) {
                this.iNS = i;
                e.this.zW(this.iNS);
            }
            e.this.iNI = i;
            e.this.hVc = i;
            e.this.fCJ = (i + i2) - 1;
            al cxr = e.this.cxr();
            if (cxr != null && cxr.tR() != null) {
                cxr.tR().b(e.this.hTm);
            }
        }
    };
    private View.OnTouchListener eVH = new View.OnTouchListener() { // from class: com.baidu.tieba.homepage.personalize.e.23
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (e.this.eIi != null) {
                e.this.eIi.onTouch(view, motionEvent);
            }
            if (e.this.iuq != null) {
                e.this.iuq.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private a.InterfaceC0674a hrF = new a.InterfaceC0674a() { // from class: com.baidu.tieba.homepage.personalize.e.29
        @Override // com.baidu.tieba.f.a.InterfaceC0674a
        public void H(int i, int i2) {
            e.this.hVM = false;
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0674a
        public void I(int i, int i2) {
            e.this.hVM = true;
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0674a
        public void bZ(int i, int i2) {
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0674a
        public void J(int i, int i2) {
        }
    };
    private View.OnClickListener iNC = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.e.30
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (e.this.hBM != null) {
                e.this.hBM.hideTip();
            }
        }
    };
    private final CustomMessageListener iND = new CustomMessageListener(CmdConfigCustom.CMD_RELOAD_HP_PERSONALIZED) { // from class: com.baidu.tieba.homepage.personalize.e.31
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (e.this.hYW != null) {
                e.this.hBR.cxq();
                e.this.iLc = false;
                e.this.iGH.setRefreshing(true);
            }
        }
    };
    private final CustomMessageListener iNE = new CustomMessageListener(2921461) { // from class: com.baidu.tieba.homepage.personalize.e.32
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (e.this.hYW != null) {
                e.this.cye();
            }
        }
    };
    private final CustomMessageListener iNF = new CustomMessageListener(2921486) { // from class: com.baidu.tieba.homepage.personalize.e.33
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data = customResponsedMessage.getData();
            switch (data instanceof Integer ? ((Integer) data).intValue() : 0) {
                case 2:
                    new BdTopToast(e.this.mPageContext.getPageActivity(), 2000).wU(true).Sp(e.this.mPageContext.getPageActivity().getString(R.string.youngster_open_title)).aE((ViewGroup) e.this.mPageContext.getPageActivity().findViewById(R.id.maintabContainer));
                    e.this.pN(true);
                    return;
                case 3:
                    new BdTopToast(e.this.mPageContext.getPageActivity(), 2000).wU(true).Sp(e.this.mPageContext.getPageActivity().getString(R.string.youngster_close_title)).aE((ViewGroup) e.this.mPageContext.getPageActivity().findViewById(R.id.maintabContainer));
                    e.this.pN(false);
                    return;
                case 4:
                default:
                    if (com.baidu.tbadk.youngster.b.b.bzf()) {
                        e.this.pN(true);
                        return;
                    }
                    return;
                case 5:
                    new BdTopToast(e.this.mPageContext.getPageActivity(), 2000).wU(true).Sp(e.this.mPageContext.getPageActivity().getString(R.string.youngster_reset_title)).aE((ViewGroup) e.this.mPageContext.getPageActivity().findViewById(R.id.maintabContainer));
                    e.this.pN(true);
                    return;
            }
        }
    };
    private CustomMessageListener imZ = new CustomMessageListener(CmdConfigCustom.PB_ACTION_PRAISE) { // from class: com.baidu.tieba.homepage.personalize.e.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            bw bwVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bw) && e.this.iNm != null && y.getCount(e.this.iNm.thread_list) != 0 && (bwVar = (bw) customResponsedMessage.getData()) != null && bwVar.bep() != null && bwVar.getId() != null && y.getCount(e.this.iNm.thread_list) != 0) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < e.this.iNm.thread_list.size()) {
                        ThreadInfo threadInfo = e.this.iNm.thread_list.get(i2);
                        if (threadInfo == null || threadInfo.id.longValue() != com.baidu.adp.lib.f.b.toLong(bwVar.getId(), -1L)) {
                            i = i2 + 1;
                        } else {
                            ThreadInfo.Builder builder = new ThreadInfo.Builder(threadInfo);
                            Zan.Builder builder2 = new Zan.Builder(builder.zan);
                            builder2.num = Integer.valueOf((int) bwVar.bep().getNum());
                            builder.zan = builder2.build(true);
                            e.this.iNm.thread_list.set(i2, builder.build(true));
                            return;
                        }
                    } else {
                        return;
                    }
                }
            }
        }
    };
    private CustomMessageListener iNG = new CustomMessageListener(CmdConfigCustom.CMD_LIVE_VIDEO_CLOSED_QUERY_RESPONSED) { // from class: com.baidu.tieba.homepage.personalize.e.9
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
                    if (e.this.iMC != null) {
                        e.this.iMC.bS(new ArrayList(e.this.mDataList));
                    }
                }
            }
        }
    };
    private CustomMessageListener ekL = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.homepage.personalize.e.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int intValue;
            if ((customResponsedMessage instanceof UpdateAttentionMessage) && e.this.iNm != null && !y.isEmpty(e.this.iNm.thread_list)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid)) {
                    int i = 0;
                    while (true) {
                        if (i >= e.this.iNm.thread_list.size()) {
                            break;
                        }
                        ThreadInfo threadInfo = e.this.iNm.thread_list.get(i);
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
                            e.this.iNm.thread_list.set(i, builder.build(true));
                        }
                    }
                    e.this.a(updateAttentionMessage);
                }
            }
        }
    };
    private String iNH = "lastReadReadPositionKey";
    private int iNI = 0;
    private d iNK = new d() { // from class: com.baidu.tieba.homepage.personalize.e.15
        @Override // com.baidu.tieba.homepage.personalize.d
        public void zF(final int i) {
            if (e.this.iNJ == null) {
                e.this.iNJ = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.e.15.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (e.this.hYW.getHandler() != null) {
                            e.this.hYW.requestFocusFromTouch();
                            if (i <= e.this.hYW.getCount() - 1) {
                                e.this.hYW.setSelection(i);
                            }
                        }
                    }
                };
            }
            e.this.hYW.removeCallbacks(e.this.iNJ);
            e.this.hYW.post(e.this.iNJ);
        }
    };
    private CustomMessageListener iNL = new CustomMessageListener(2016569) { // from class: com.baidu.tieba.homepage.personalize.e.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && e.this.iNu != null) {
                e.this.mDataList.remove(e.this.iNu);
                e.this.iMC.bS(new ArrayList(e.this.mDataList));
                com.baidu.tbadk.core.sharedPref.b.bik().putLong("key_maintab_banner_close_time", System.currentTimeMillis());
            }
        }
    };
    private CustomMessageListener hBG = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.homepage.personalize.e.19
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.g(customResponsedMessage);
            if (e.this.hBR != null && e.this.iLc) {
                e.this.hBR.a(e.this.hVc, e.this.fCJ, e.this.hVM, true);
            }
        }
    };
    private CustomMessageListener hBH = new CustomMessageListener(CmdConfigCustom.CMD_THREAD_NOT_EXIST_WHEN_ENTER_PB) { // from class: com.baidu.tieba.homepage.personalize.e.20
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.g(customResponsedMessage);
        }
    };
    private CustomMessageListener inn = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.homepage.personalize.e.21
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && e.this.iNm != null && y.getCount(e.this.iNm.thread_list) != 0) {
                String str = (String) customResponsedMessage.getData();
                e.this.h(str, e.this.mDataList);
                e.this.JJ(str);
                if (e.this.iMC != null) {
                    e.this.iMC.bS(new ArrayList(e.this.mDataList));
                }
                if (e.this.hBR != null && e.this.iLc) {
                    e.this.hBR.a(e.this.hVc, e.this.fCJ, e.this.hVM, true);
                }
            }
        }
    };
    private CustomMessageListener hUJ = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.homepage.personalize.e.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            al cxr;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent)) {
                KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24 && (cxr = e.this.cxr()) != null && cxr.tR() != null) {
                    cxr.tR().b(new a.C0095a(3));
                }
            }
        }
    };
    private com.baidu.adp.framework.listener.a iNM = new com.baidu.adp.framework.listener.a(1003065, CmdConfigSocket.CMD_TOPIC_BLESS) { // from class: com.baidu.tieba.homepage.personalize.e.24
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
                        if ((qVar instanceof com.baidu.tieba.homepage.topic.topictab.b.a) && (bVar = ((com.baidu.tieba.homepage.topic.topictab.b.a) qVar).iUL) != null && longValue == bVar.pkId) {
                            bVar.userPkId = j2;
                            return;
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener hUK = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.homepage.personalize.e.25
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            List<q> dataList = e.this.iMC.getDataList();
            if (!y.isEmpty(dataList)) {
                for (q qVar : dataList) {
                    if (qVar instanceof l) {
                        l lVar = (l) qVar;
                        if (lVar.eaT != 0 && lVar.dUW != null) {
                            int[] imageWidthAndHeight = lVar.dUW.getImageWidthAndHeight();
                            lVar.eaT = imageWidthAndHeight[0];
                            lVar.eaU = imageWidthAndHeight[1];
                        }
                    }
                }
            }
            com.baidu.adp.lib.f.e.mS().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.personalize.e.25.1
                @Override // java.lang.Runnable
                public void run() {
                    e.this.iMC.notifyDataSetChanged();
                    if (!e.this.mIsBackground && e.this.iLc) {
                        e.this.hBR.a(e.this.hVc, e.this.fCJ, e.this.hVM, true);
                    }
                }
            }, 500L);
        }
    };
    private CustomMessageListener hBI = new CustomMessageListener(2921453) { // from class: com.baidu.tieba.homepage.personalize.e.26
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.data.be)) {
                com.baidu.tbadk.core.data.be beVar = (com.baidu.tbadk.core.data.be) customResponsedMessage.getData();
                if (beVar.dZS == 1) {
                    int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
                    int equipmentHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst());
                    float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
                    int i = au.bjr().bjs() ? 2 : 1;
                    RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
                    requestGetMyPostNetMessage.setTag(e.this.iNA);
                    requestGetMyPostNetMessage.setParams(com.baidu.adp.lib.f.b.toLong(beVar.tid, 0L), 0L, 0L, equipmentWidth, equipmentHeight, f, i);
                    requestGetMyPostNetMessage.setBFrom("push");
                    MessageManager.getInstance().sendMessage(requestGetMyPostNetMessage);
                }
            }
        }
    };
    private final com.baidu.adp.framework.listener.a hBJ = new com.baidu.adp.framework.listener.a(1003010, CmdConfigSocket.CMD_GET_MY_POST) { // from class: com.baidu.tieba.homepage.personalize.e.27
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            GetMyPostResIdl getMyPostResIdl = null;
            if (responsedMessage instanceof GetMyPostHttpResponseMessage) {
                getMyPostResIdl = ((GetMyPostHttpResponseMessage) responsedMessage).getResponseData();
            } else if (responsedMessage instanceof GetMyPostSocketResponseMessage) {
                getMyPostResIdl = ((GetMyPostSocketResponseMessage) responsedMessage).getResponseData();
            }
            if (getMyPostResIdl != null && getMyPostResIdl.data != null && getMyPostResIdl.data.thread_info != null) {
                e.this.iNB = getMyPostResIdl.data.thread_info;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921455));
            }
        }
    };
    private CustomMessageListener iNN = new CustomMessageListener(2921482) { // from class: com.baidu.tieba.homepage.personalize.e.28
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

        void cxR();

        void onError(int i, String str);

        void onSuccess();
    }

    public void pK(boolean z) {
        this.iNv = z;
        if (this.hBM != null && !z) {
            this.hBM.hideTip();
        }
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.iMq = scrollFragmentTabHost;
        if (this.iMq != null) {
            this.iMq.setOnTabSelectedListener(new ScrollFragmentTabHost.b() { // from class: com.baidu.tieba.homepage.personalize.e.1
                @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.b
                public void zP(int i) {
                    if (e.this.iMq.zO(i) != 1 && e.this.hBM != null) {
                        e.this.hBM.hideTip();
                    }
                }
            });
        }
    }

    public void setTabInForeBackgroundState(boolean z) {
        this.mIsBackground = z;
    }

    public void ot(boolean z) {
        boolean z2 = false;
        this.mIsBackground = z;
        if (this.iMq != null) {
            this.iMq.ot(z);
        }
        if (this.hBR != null) {
            this.hBR.rH(!z);
            al cxr = cxr();
            if (cxr != null && cxr.tR() != null) {
                z2 = cxr.tR().b(new a.C0095a(8, Boolean.valueOf(z)));
            }
            if (!z2) {
                if (z) {
                    this.hBR.cxq();
                } else if (this.iLc) {
                    this.hBR.a(this.hVc, this.fCJ, this.hVM, true);
                }
            }
        }
    }

    public e(TbPageContext<?> tbPageContext, BdTypeRecyclerView bdTypeRecyclerView, af afVar, BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout) {
        this.iNz = 0;
        this.mPageContext = tbPageContext;
        this.iNz = com.baidu.tbadk.core.sharedPref.b.bik().getInt("key_personalized_refresh_type", 0);
        this.iGH = bigdaySwipeRefreshLayout;
        this.hYW = bdTypeRecyclerView;
        this.hYW.setOnTouchListener(this.eVH);
        if (com.baidu.tbadk.youngster.b.b.bzf()) {
            pN(true);
        }
        this.iuq = new com.baidu.tieba.f.a();
        this.iuq.a(this.hrF);
        this.iMC = afVar;
        this.iNp = new com.baidu.tieba.homepage.personalize.model.a();
        this.iNj = com.baidu.tbadk.core.sharedPref.b.bik().getLong("recommend_frs_cache_time", 1800L) * 1000;
        bdTypeRecyclerView.setOnScrollListener(this.mOnScrollListener);
        this.hBM = new be();
        cyc();
        this.hBR = new i(this.mPageContext, this.hYW);
        this.hBR.FH(1);
        this.hBR.FG(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.iNk = new b(this.mDataList, this.iMC);
        this.hBN = new SmartBubbleAnimatedView(tbPageContext.getContext());
        this.hBN.setLayoutParams(new FrameLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(tbPageContext.getContext(), R.dimen.tbds83)));
        cxS();
        this.hUK.setTag(this.mPageContext.getUniqueId());
        MessageManager.getInstance().registerListener(this.hUK);
        if (MessageManager.getInstance().findTask(1003010) == null) {
            HomePageStatic.cvZ();
        }
        this.hBJ.setTag(this.iNA);
        if (this.hBJ.getHttpMessageListener() != null) {
            this.hBJ.getHttpMessageListener().setSelfListener(true);
        }
        if (this.hBJ.getSocketMessageListener() != null) {
            this.hBJ.getSocketMessageListener().setSelfListener(true);
        }
        MessageManager.getInstance().registerListener(this.hBJ);
        MessageManager.getInstance().registerListener(this.hBI);
        MessageManager.getInstance().registerListener(this.iNN);
    }

    private void cxS() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2016323, new CustomMessageTask.CustomRunnable<Boolean>() { // from class: com.baidu.tieba.homepage.personalize.e.34
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Boolean> customMessage) {
                al cxr = e.this.cxr();
                return (cxr == null || cxr.tR() == null) ? new CustomResponsedMessage<>(2016323, false) : new CustomResponsedMessage<>(2016323, Boolean.valueOf(cxr.tR().b(new a.C0095a(6))));
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private boolean cxT() {
        return com.baidu.tbadk.core.sharedPref.b.bik().getBoolean(cxV(), true);
    }

    private void cxU() {
        com.baidu.tbadk.core.sharedPref.b.bik().putBoolean(cxV(), false);
    }

    private String cxV() {
        return "key_rec_pfirst_load_" + TbadkCoreApplication.getCurrentAccount() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + TbConfig.getVersion();
    }

    public void setRecommendFrsNavigationAnimDispatcher(aa aaVar) {
        if (aaVar != null) {
            this.eVG = aaVar.bvH();
            this.eIi = aaVar.bvI();
        }
    }

    public void showFloatingView() {
        if (this.eVG != null) {
            this.eVG.showFloatingView(true);
        }
    }

    public void update() {
        com.baidu.tieba.homepage.framework.a.cwp().r(System.currentTimeMillis(), 1);
        this.mPn = 1;
        this.iNt = true;
        if (this.mDataList.size() == 0 && !cxT()) {
            if (!this.iGP) {
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
                if (this.mDataList.get(i).getType().getId() == bw.ebt.getId() && (bwVar = (bw) this.mDataList.get(i)) != null && bwVar.beY() != null) {
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

    public void cxW() {
        if (this.hBR != null && !this.mIsBackground && this.iLc) {
            this.hBR.a(this.hVc, this.fCJ, this.hVM, true);
        }
        if (this.iNr) {
            if (this.iGH != null && !this.iGH.bkK()) {
                if (this.iEC) {
                    com.baidu.tieba.s.c.dvJ().b(this.iNx, false);
                    if (pM(false)) {
                        cy(3, this.iNo);
                    } else if (this.iNs > 0) {
                        cy(2, this.iNo);
                    }
                } else if (!this.iEC && this.iNo == 0) {
                    cy(2, 0);
                }
            }
            this.iNr = false;
            this.iEC = false;
            this.iNs = 0;
            if (this.iNt) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
            }
            this.iNt = false;
        }
    }

    public void bFE() {
        if (isLoading()) {
            com.baidu.tieba.homepage.framework.a.cwp().r(0L, 1);
        } else if (this.iNl != null) {
            cxY();
            this.mPn++;
            setIsLoading(true);
            this.iNl.B(this.mPn, (this.iNm == null || this.iNm.thread_list == null) ? 0 : this.iNm.thread_list.size(), pL(false), 0);
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
            g.cyj();
        }
        if (this.iNp != null && this.iNp.cyE() && !z && (dataRes == null || y.isEmpty(dataRes.thread_list))) {
            if (dataRes == null) {
                DataRes.Builder builder = new DataRes.Builder();
                builder.thread_list = new ArrayList();
                dataRes = builder.build(false);
            }
            if (dataRes.thread_list != null) {
                List<ThreadInfo> cyF = this.iNp.cyF();
                dataRes.thread_list.addAll(cyF);
                if (cyF != null) {
                    cyF.clear();
                }
                z3 = true;
                size = (this.iNm != null || this.iNm.thread_list == null) ? 0 : this.iNm.thread_list.size();
                if (z && i == 0 && dataRes != null && y.isEmpty(dataRes.thread_list)) {
                    if (this.iNl != null) {
                        this.iNl.cxR();
                    }
                    setIsLoading(false);
                    if (this.iGH != null) {
                        this.iGH.setRefreshing(false);
                        return;
                    }
                    return;
                }
                if (this.iNB != null) {
                    DataRes.Builder builder2 = new DataRes.Builder(dataRes);
                    builder2.thread_list.add(0, this.iNB);
                    dataRes = builder2.build(false);
                    if (this.iNm != null && !y.isEmpty(this.iNm.thread_list)) {
                        Iterator<ThreadInfo> it = this.iNm.thread_list.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            ThreadInfo next = it.next();
                            if (next != null && next.tid != null && this.iNB.tid != null && next.tid.longValue() == this.iNB.tid.longValue()) {
                                this.iNm.thread_list.remove(next);
                                break;
                            }
                        }
                    }
                    this.iNB = null;
                }
                if ((z3 && i != 0) || dataRes == null || !a(true, z, z2, dataRes)) {
                    this.iNr = false;
                    if (this.mDataList.size() > 0) {
                        if (this.iNl != null) {
                            this.iNl.onError(1, str);
                        }
                    } else if (this.iNl != null) {
                        this.iNl.onError(2, str);
                    }
                } else {
                    cxU();
                    if (this.iNl != null) {
                        com.baidu.tbadk.core.sharedPref.b.bik().putLong(SharedPrefConfig.RECOMMEND_FRS_REFRESH_TIME + TbadkCoreApplication.getCurrentAccount(), System.currentTimeMillis());
                        this.iNl.onSuccess();
                    }
                    this.iNr = true;
                    this.iEC = z;
                    this.iNs = size;
                    cfg();
                }
                setIsLoading(false);
                if (this.iGH == null) {
                    f.e cxX = cxX();
                    if (this.iGH.bkK() && cxX != null) {
                        this.iGH.c(cxX);
                        return;
                    } else {
                        this.iGH.setRefreshing(false);
                        return;
                    }
                }
                return;
            }
        }
        z3 = false;
        if (this.iNm != null) {
        }
        if (z) {
        }
        if (this.iNB != null) {
        }
        if (z3) {
        }
        cxU();
        if (this.iNl != null) {
        }
        this.iNr = true;
        this.iEC = z;
        this.iNs = size;
        cfg();
        setIsLoading(false);
        if (this.iGH == null) {
        }
    }

    private f.e cxX() {
        int i;
        String feedText;
        if (!this.iNr || this.iGH == null || !this.iGH.bkK() || cyb()) {
            return null;
        }
        int i2 = this.iNo;
        if (this.iEC) {
            com.baidu.tieba.s.c.dvJ().b(this.iNx, false);
            if (pM(false)) {
                i = 3;
            } else {
                i = this.iNs > 0 ? 2 : 0;
            }
        } else if (this.iEC || this.iNo != 0) {
            return null;
        } else {
            i2 = 0;
            i = 2;
        }
        if (this.iMq != null) {
            this.hBM.con();
        }
        if (this.iMq != null && this.iMq.getCurrentTabType() != 1) {
            this.hBM.hideTip();
            return null;
        } else if (!this.iNv) {
            this.hBM.hideTip();
            return null;
        } else {
            this.iNn = i;
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
                this.hYc = 1000;
            } else {
                this.hYc = 0;
            }
            return new f.e(feedText, this.hYc);
        }
    }

    public void pA(boolean z) {
        if (z) {
            this.iMC.notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        if (this.hBR != null) {
            this.hBR.destroy();
        }
        if (this.hBM != null) {
            this.hBM.onDestroy();
        }
        if (this.iNk != null) {
            this.iNk.onDestroy();
        }
        if (this.hYW != null) {
            this.hYW.removeCallbacks(this.iNJ);
        }
        MessageManager.getInstance().unRegisterTask(2016323);
        MessageManager.getInstance().unRegisterListener(this.hUK);
        MessageManager.getInstance().unRegisterListener(this.hBI);
        MessageManager.getInstance().unRegisterListener(this.hBJ);
        MessageManager.getInstance().unRegisterListener(this.iNN);
    }

    public void onPause() {
        c.d(this.hYW);
        zX(this.iNI);
        if (this.iNq != null) {
            this.iNq.bug();
        }
    }

    private void bbV() {
        if (this.iNl != null) {
            this.iNl.O((this.iNm == null || this.iNm.thread_list == null || cya()) ? 0 : this.iNm.thread_list.size(), pL(true), 0);
        }
    }

    public int pL(boolean z) {
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
                if (!(qVar instanceof com.baidu.tieba.homepage.personalize.data.a) || qVar.getType() == AdvertAppInfo.dVY) {
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
                if ((qVar2 instanceof com.baidu.tieba.homepage.personalize.data.a) && qVar2.getType() != AdvertAppInfo.dVY) {
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
        this.iGP = true;
        if (dataRes != null) {
            if (a(false, true, true, dataRes) && !cya()) {
                if (this.iNl != null) {
                    this.iNl.onSuccess();
                    Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler() { // from class: com.baidu.tieba.homepage.personalize.e.2
                        @Override // android.os.MessageQueue.IdleHandler
                        public boolean queueIdle() {
                            e.this.bul();
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

    public void bul() {
        long zD = com.baidu.tieba.homepage.framework.a.cwp().zD(1) + com.baidu.tieba.homepage.framework.a.cwp().getCreateTime();
        long zB = com.baidu.tieba.homepage.framework.a.cwp().zB(1);
        if (zB > 0) {
            zD = System.currentTimeMillis() - zB;
        }
        n.but().dz(zD);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.util.Set] */
    private void i(List<q> list, int i) {
        AdvertAppInfo ccs;
        AdvertAppInfo ccs2;
        if (!y.isEmpty(list)) {
            Set<q> PB = com.baidu.tieba.recapp.report.a.PB("NEWINDEX");
            HashSet hashSet = PB == null ? new HashSet() : PB;
            HashSet hashSet2 = new HashSet();
            for (q qVar : list) {
                if (qVar != null) {
                    for (q qVar2 : hashSet) {
                        if ((qVar instanceof com.baidu.tieba.card.data.e) && (ccs2 = ((com.baidu.tieba.card.data.e) qVar).ccs()) != null && qVar2 != null && (qVar2 instanceof AdvertAppInfo) && qVar2.hashCode() == ccs2.hashCode()) {
                            ccs2.advertAppContext = ((AdvertAppInfo) qVar2).advertAppContext;
                        }
                    }
                    if (qVar != null && (qVar instanceof com.baidu.tieba.card.data.e) && (ccs = ((com.baidu.tieba.card.data.e) qVar).ccs()) != null && ccs.advertAppContext == null) {
                        ccs.advertAppContext = new com.baidu.tbadk.core.data.b();
                        ccs.advertAppContext.page = "NEWINDEX";
                        ccs.advertAppContext.pn = this.mPn;
                        ccs.advertAppContext.extensionInfo = ccs.extensionInfo;
                        ccs.advertAppContext.Ye = false;
                        hashSet2.add(ccs);
                    }
                }
            }
            hashSet.addAll(hashSet2);
            com.baidu.tieba.recapp.report.a.b("NEWINDEX", hashSet);
            if (hashSet2.size() > 0) {
                com.baidu.tieba.s.c.dvJ().b(this.iNx, com.baidu.tieba.s.a.b(PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE, "common_fill", true, hashSet2.size()));
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
        if (this.iNz == 1) {
            if (z2 && (dataRes.thread_list.size() >= 6 || cya())) {
                cxZ();
                this.iNm = null;
            }
        } else if (z2 && cya()) {
            this.iNm = null;
        }
        int size = z2 ? 0 : this.mDataList.size();
        DataRes.Builder builder = new DataRes.Builder(dataRes);
        this.mDataList.clear();
        com.baidu.tieba.homepage.personalize.model.c a2 = this.iNp.a(z, this.iNm, builder, z2 ? 0 : 1);
        if (a2 == null) {
            list = null;
            i = 0;
        } else {
            List<q> list2 = a2.fky;
            this.iNo = a2.iQp;
            int i2 = a2.iQq;
            a2.iQq = 0;
            list = list2;
            i = i2;
        }
        if (list != null) {
            this.mDataList.addAll(list);
            i(list, size);
            a(z2 ? 0 : 1, list, size);
            if (this.iNt) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
            }
        }
        if (this.iNm == null) {
            this.iNm = builder;
            this.iNk.dj(this.iNm.thread_list);
        }
        if (this.mDataList.size() == 0) {
            z4 = false;
        } else {
            if (z2) {
                if (dataRes.live_answer != null) {
                    this.iNu = new h();
                    this.iNu.a(dataRes.live_answer);
                    this.iNm.live_answer = dataRes.live_answer;
                } else if (z) {
                    this.iNu = null;
                    this.iNm.live_answer = null;
                }
                this.iNw = dataRes.float_info;
                this.iNm.float_info = dataRes.float_info;
            }
            long j = com.baidu.tbadk.core.sharedPref.b.bik().getLong("key_maintab_banner_close_time", 0L);
            if (this.iNu != null && !at.isTaday(j)) {
                this.mDataList.add(0, this.iNu);
            }
            LinkedList linkedList = new LinkedList(this.mDataList);
            this.iMC.setFromCDN(dataRes.is_new_url != null && dataRes.is_new_url.intValue() == 1);
            this.iMC.j(linkedList, i);
            z4 = true;
            if (this.hBR != null && this.iLc) {
                this.hBR.a(this.hVc, this.fCJ, this.hVM, true);
            }
        }
        com.baidu.tieba.homepage.framework.a.cwp().p(System.currentTimeMillis() - currentTimeMillis, 1);
        long zE = com.baidu.tieba.homepage.framework.a.cwp().zE(1);
        if (zE > 0) {
            com.baidu.tieba.homepage.framework.a.cwp().q(System.currentTimeMillis() - zE, 1);
            com.baidu.tieba.homepage.framework.a.cwp().r(0L, 1);
        }
        if (dataRes.anti != null && dataRes.anti.block_pop_info != null) {
            com.baidu.tieba.ueg.d.d(dataRes.anti.block_pop_info);
        }
        bg bgVar = new bg();
        bgVar.a(dataRes.recom_post_topic);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_REFRESH_TOPIC_TIP, bgVar));
        return z4;
    }

    private void cxY() {
        List<q> list;
        int i;
        if (y.getCount(this.mDataList) >= this.iNp.cyA() - 40) {
            com.baidu.tieba.homepage.personalize.model.c a2 = this.iNp.a(true, this.iNm, null, 1);
            if (a2 != null) {
                List<q> list2 = a2.fky;
                i = a2.iQq;
                a2.iQq = 0;
                list = list2;
            } else {
                list = null;
                i = 0;
            }
            if (list != null) {
                this.mDataList.clear();
                this.mDataList.addAll(list);
                this.iMC.j(new LinkedList(this.mDataList), i);
            }
        }
    }

    private void bbW() {
        this.iGP = true;
        ad.a(new ac<DataRes>() { // from class: com.baidu.tieba.homepage.personalize.e.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.ac
            /* renamed from: cyf */
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

    private void cfg() {
        if (this.iNm != null) {
            DataRes.Builder builder = new DataRes.Builder(this.iNm.build(true));
            if (builder.thread_list != null && builder.thread_list.size() > 30) {
                builder.thread_list = builder.thread_list.subList(0, 30);
            }
            a(builder, builder.thread_list != null ? builder.thread_list.size() : 0);
            a(builder);
            b(builder);
            c(builder);
        }
    }

    private void cxZ() {
        if (this.iNm != null) {
            final DataRes.Builder builder = new DataRes.Builder(this.iNm.build(true));
            if (builder.thread_list != null && builder.thread_list.size() > 50) {
                builder.thread_list = builder.thread_list.subList(0, 50);
            }
            a(builder, builder.thread_list != null ? builder.thread_list.size() : 0);
            ad.a(new ac<Object>() { // from class: com.baidu.tieba.homepage.personalize.e.5
                @Override // com.baidu.tbadk.util.ac
                public Object doInBackground() {
                    DataRes.Builder builder2 = new DataRes.Builder(builder.build(true));
                    e.this.iNk.dk(builder2.thread_list);
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
    public void JJ(String str) {
        if (!TextUtils.isEmpty(str) && this.iNm != null && this.iNm.banner_list != null && this.iNm.banner_list.app != null && this.iNm.banner_list.app.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (App app : this.iNm.banner_list.app) {
                if (app != null && str.equals(app.id)) {
                    arrayList.add(app);
                }
            }
            BannerList.Builder builder = new BannerList.Builder(this.iNm.banner_list);
            if (builder.app != null) {
                builder.app.removeAll(arrayList);
            }
            this.iNm.banner_list = builder.build(false);
            DataRes.Builder builder2 = new DataRes.Builder(this.iNm.build(true));
            builder2.banner_list = builder.build(true);
            c(builder2);
        }
    }

    private void c(final DataRes.Builder builder) {
        ad.a(new ac<Object>() { // from class: com.baidu.tieba.homepage.personalize.e.6
            @Override // com.baidu.tbadk.util.ac
            public Object doInBackground() {
                DataRes.Builder builder2 = new DataRes.Builder(builder.build(true));
                e.this.iNk.dk(builder2.thread_list);
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

    private boolean cya() {
        return pM(true);
    }

    private boolean pM(boolean z) {
        long j = com.baidu.tbadk.core.sharedPref.b.bik().getLong(SharedPrefConfig.RECOMMEND_FRS_REFRESH_TIME + TbadkCoreApplication.getCurrentAccount(), 0L);
        return j == 0 ? z : Math.abs(System.currentTimeMillis() - j) > this.iNj;
    }

    public void a(a aVar) {
        this.iNl = aVar;
    }

    private boolean isLoading() {
        return this.mIsLoading;
    }

    private void setIsLoading(boolean z) {
        this.mIsLoading = z;
    }

    public void cxO() {
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
    public void pN(boolean z) {
        boolean z2 = com.baidu.tbadk.core.sharedPref.b.bik().getBoolean("key_youngster_homgpage_top_view_closed", false);
        if (this.hYW != null && !z2) {
            if (z) {
                if (this.iNy == null) {
                    this.iNy = new HomePageYoungsterTopView(this.mPageContext);
                    this.iNy.setOnDeleteClick(new HomePageYoungsterTopView.a() { // from class: com.baidu.tieba.homepage.personalize.e.7
                        @Override // com.baidu.tieba.homepage.personalize.view.HomePageYoungsterTopView.a
                        public void cyg() {
                            new BdTopToast(e.this.mPageContext.getPageActivity(), 2000).wU(true).Sp(e.this.mPageContext.getPageActivity().getString(R.string.youngster_frs_top_toast)).aE((ViewGroup) e.this.mPageContext.getPageActivity().findViewById(R.id.maintabContainer));
                            e.this.pN(false);
                            com.baidu.tbadk.core.sharedPref.b.bik().putBoolean("key_youngster_homgpage_top_view_closed", true);
                        }
                    });
                }
                this.hYW.setHeaderView(this.iNy);
                this.iNy.setVisibility(0);
                this.hYW.scrollToPosition(0);
            } else if (this.iNy != null) {
                this.iNy.setVisibility(8);
                this.hYW.removeHeaderView(this.iNy);
            }
        }
    }

    private boolean cyb() {
        return this.iNy != null && this.iNy.getVisibility() == 0;
    }

    private void cy(int i, int i2) {
        if (!cyb()) {
            if (this.iMq != null) {
                this.hBM.con();
            }
            if (this.iMq != null && this.iMq.getCurrentTabType() != 1) {
                this.hBM.hideTip();
            } else if (!this.iNv) {
                this.hBM.hideTip();
            } else {
                this.iNn = i;
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
                        this.hYc = 3000;
                    } else {
                        this.hYc = 2000;
                    }
                    this.hBN.etq = str;
                    this.hBN.hXV = this.hYc;
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 49;
                    if (this.iMq != null) {
                        FrameLayout frameLayout = this.iMq.getFrameLayout();
                        frameLayout.removeView(this.hBN);
                        frameLayout.addView(this.hBN, layoutParams);
                        this.hBN.col();
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(Long l) {
        if (this.iNm != null && this.iNm.thread_list != null) {
            List<ThreadInfo> list = this.iNm.thread_list;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                ThreadInfo threadInfo = list.get(i);
                if (threadInfo.tid.equals(l) && threadInfo.top_agree_post != null) {
                    ThreadInfo.Builder builder = new ThreadInfo.Builder(threadInfo);
                    builder.top_agree_post = null;
                    list.set(i, builder.build(true));
                    cfg();
                    a(false, true, false, this.iNm.build(true));
                    return;
                }
            }
        }
    }

    public void p(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.iNx = bdUniqueId;
            if (this.imZ != null) {
                this.imZ.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.imZ);
            }
            if (this.iND != null) {
                this.iND.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.iND);
            }
            this.iNE.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.iNE);
            this.ekL.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.ekL);
            this.iNG.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.iNG);
            this.hBG.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.hBG);
            this.hBH.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.hBH);
            this.inn.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.inn);
            if (this.hBR != null) {
                this.hBR.setUniqueId(bdUniqueId);
            }
            this.iNk.m(bdUniqueId);
            this.iNL.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.iNL);
            this.hUJ.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.hUJ);
            this.iNM.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.iNM);
            this.iNF.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.iNF);
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
                        e.this.iNk.dk(builder5.thread_list);
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

    public void cyc() {
        this.hSR = new com.baidu.tieba.tbadkCore.data.f("new_index", null);
        this.hSR.dwq();
    }

    public void a(int i, List<q> list, int i2) {
        int i3;
        int i4;
        if (this.hSR != null) {
            if (i == 0) {
                this.hSR.dwq();
            }
            if (list != null && !list.isEmpty()) {
                int[] iArr = com.baidu.tieba.tbadkCore.data.f.meD;
                int i5 = 0;
                int i6 = 0;
                int i7 = 0;
                while (i7 < list.size() && i6 < iArr.length && (i3 = iArr[i6]) >= 0) {
                    if (list.get(i7) instanceof com.baidu.tieba.card.data.c) {
                        i4 = i5 + 1;
                        if (i4 == i3 - 1) {
                            if (i2 < i7 + 1) {
                                this.hSR.dk(i3, i7 + 1);
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
        if ((this.hSR != null ? this.hSR.HM(i) : -1) >= 0 && this.hYW != null && this.hYW.getData() != null && this.hYW.getData().size() > i) {
            this.hSR.HN(i);
        }
    }

    public i cmW() {
        return this.hBR;
    }

    public void pG(boolean z) {
        this.iLc = z;
    }

    public void zX(final int i) {
        ad.a(new ac<Object>() { // from class: com.baidu.tieba.homepage.personalize.e.14
            @Override // com.baidu.tbadk.util.ac
            public Object doInBackground() {
                com.baidu.adp.lib.cache.l<String> dw = com.baidu.tbadk.core.c.a.bhb().dw(e.this.iNH, TbadkCoreApplication.getCurrentAccount());
                if (dw != null) {
                    dw.set(e.this.iNH, Integer.toString(i), 43200000L);
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
            /* renamed from: cyh */
            public String doInBackground() {
                com.baidu.adp.lib.cache.l<String> dw = com.baidu.tbadk.core.c.a.bhb().dw(e.this.iNH, TbadkCoreApplication.getCurrentAccount());
                if (dw != null) {
                    return dw.get(e.this.iNH);
                }
                return null;
            }
        }, new com.baidu.tbadk.util.l<String>() { // from class: com.baidu.tieba.homepage.personalize.e.17
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.l
            /* renamed from: JK */
            public void onReturnDataInUI(String str) {
                if (dVar != null) {
                    dVar.zF(com.baidu.adp.lib.f.b.toInt(str, 0));
                }
            }
        });
    }

    public void cxP() {
        c.e(this.hYW);
    }

    public void cyd() {
        a(this.iNK);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cye() {
        Iterator<q> it = this.mDataList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            } else if (it.next() instanceof com.baidu.tieba.homepage.personalize.data.g) {
                it.remove();
                break;
            }
        }
        if (this.iNm != null) {
            this.iNm.active_center = null;
            cfg();
            if (this.hYW != null) {
                List<Integer> f = f(this.hYW);
                int intValue = f.get(0).intValue();
                int intValue2 = f.get(1).intValue();
                if (intValue != -1 && intValue2 != -1) {
                    this.hYW.o(intValue, intValue2);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(CustomResponsedMessage<?> customResponsedMessage) {
        boolean z;
        String str;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.iNm != null && y.getCount(this.iNm.thread_list) != 0 && y.getCount(this.mDataList) != 0) {
            JSONObject jSONObject = (JSONObject) customResponsedMessage.getData();
            String optString = jSONObject.optString("tid");
            if (StringUtils.isNull(optString)) {
                String optString2 = jSONObject.optString(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_ID);
                if (this.hYW != null && !TextUtils.isEmpty(optString2)) {
                    int i = 0;
                    while (true) {
                        if (i >= this.hYW.getCount()) {
                            str = optString;
                            break;
                        }
                        q item = this.hYW.getItem(i);
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
            if (this.iNm != null && this.iNm.thread_list != null) {
                long j = com.baidu.adp.lib.f.b.toLong(optString, 0L);
                int i2 = 0;
                while (true) {
                    if (i2 < this.iNm.thread_list.size()) {
                        ThreadInfo threadInfo = this.iNm.thread_list.get(i2);
                        if (threadInfo == null || threadInfo.tid == null || threadInfo.tid.longValue() != j) {
                            i2++;
                        } else {
                            com.baidu.tieba.homepage.personalize.b.d.a(threadInfo.tid.longValue(), i2, this.iNm.thread_list, this.mDataList);
                            this.iNm.thread_list.remove(i2);
                            cfg();
                            break;
                        }
                    } else {
                        break;
                    }
                }
                if (this.hYW != null) {
                    List<Integer> b = b(optString, this.hYW);
                    int intValue = b.get(0).intValue();
                    int intValue2 = b.get(1).intValue();
                    if (intValue != -1 && intValue2 != -1) {
                        this.hYW.o(intValue, intValue2);
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
                    advertAppInfo = ((com.baidu.tieba.homepage.personalize.data.a) next).ccs();
                } else {
                    if (next instanceof ak) {
                        ak akVar = (ak) next;
                        if (akVar.bcV() instanceof AdvertAppInfo.ILegoAdvert) {
                            advertAppInfo = ((AdvertAppInfo.ILegoAdvert) akVar.bcV()).getAdvertAppInfo();
                        }
                    }
                    advertAppInfo = advertAppInfo2;
                }
                if (advertAppInfo != null && str.equals(advertAppInfo.dWj)) {
                    it.remove();
                    advertAppInfo = null;
                }
                advertAppInfo2 = advertAppInfo;
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (this.hBN != null) {
            this.hBN.onChangeSkinType(i);
        }
        if (this.iNy != null) {
            this.iNy.onChangeSkinType();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public al cxr() {
        if (this.hBR == null || this.hBR.djW() == null || !(this.hBR.djW().getTag() instanceof al)) {
            return null;
        }
        return (al) this.hBR.djW().getTag();
    }
}
