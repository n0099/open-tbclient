package com.baidu.tieba.homepage.personalize;

import android.os.Looper;
import android.os.MessageQueue;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
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
import com.baidu.card.a.a;
import com.baidu.card.af;
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
import com.baidu.tbadk.core.data.ae;
import com.baidu.tbadk.core.data.ay;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tbadk.n.n;
import com.baidu.tbadk.util.ab;
import com.baidu.tbadk.util.ac;
import com.baidu.tbadk.util.y;
import com.baidu.tbadk.util.z;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.LiveRoomClosedQueryMessage;
import com.baidu.tieba.card.data.k;
import com.baidu.tieba.card.r;
import com.baidu.tieba.f.a;
import com.baidu.tieba.frs.SmartBubbleAnimatedView;
import com.baidu.tieba.frs.as;
import com.baidu.tieba.homepage.BlessHttpResponseMessage;
import com.baidu.tieba.homepage.BlessSocketResponseMessage;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import com.baidu.tieba.homepage.personalize.a.ad;
import com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout;
import com.baidu.tieba.homepage.personalize.data.g;
import com.baidu.tieba.message.RequestBlessMessage;
import com.baidu.tieba.play.m;
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
import tbclient.GodInfo;
import tbclient.Personalized.DataRes;
import tbclient.Personalized.FloatInfo;
import tbclient.ThreadInfo;
import tbclient.User;
import tbclient.Zan;
/* loaded from: classes9.dex */
public class e {
    private y dHr;
    private View.OnTouchListener dus;
    private com.baidu.tieba.f.a gNH;
    private boolean gWw;
    private final BigdaySwipeRefreshLayout gYp;
    private com.baidu.tieba.tbadkCore.data.f gpf;
    private m grz;
    private final BdTypeRecyclerView gtH;
    private ScrollFragmentTabHost hcZ;
    private final long hdQ;
    private final b hdR;
    private DataRes.Builder hdT;
    private as hdW;
    private final com.baidu.tieba.homepage.personalize.model.a hdX;
    private final ad hdm;
    private int hea;
    private g hec;
    private BdUniqueId hef;
    private SmartBubbleAnimatedView heg;
    private int heh;
    private Runnable hen;
    private final TbPageContext<?> mPageContext;
    private a hdS = null;
    private final List<com.baidu.adp.widget.ListView.m> mDataList = new LinkedList();
    private int mPn = 1;
    private boolean mIsLoading = false;
    private boolean gYx = false;
    private int hdU = 2;
    private int hdV = 0;
    private TextView mTipView = null;
    private int gts = 2000;
    private com.baidu.tbadk.n.c hdY = null;
    private boolean grs = false;
    private int gqN = 0;
    private int eku = 0;
    private boolean mIsBackground = false;
    private boolean hcU = true;
    private boolean hdZ = false;
    private boolean heb = false;
    private boolean hed = true;
    private FloatInfo hee = null;
    private a.C0052a gpx = new a.C0052a(2);
    private RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.e.12
        private int hew = -1;
        private int gYF = 0;
        private boolean hex = false;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (e.this.hdY == null) {
                e.this.hdY = new com.baidu.tbadk.n.c();
                e.this.hdY.setSubType(1005);
                e.this.hdY.pageType = 1;
            }
            if (e.this.dHr != null && !e.this.mIsBackground) {
                e.this.dHr.l(recyclerView, i);
            }
            if (i == 0) {
                c.d(e.this.gtH);
                e.this.hdY.aRh();
                r.bvm().id(true);
                com.baidu.tieba.a.d.aXK().cu("page_recommend", "show_");
                com.baidu.tieba.s.c.cKv().b(e.this.hef, false);
                this.hex = false;
                if (e.this.grz != null && e.this.hcU && !e.this.mIsBackground) {
                    e.this.grz.a(e.this.gqN, e.this.eku, e.this.grs, 1);
                    return;
                }
                return;
            }
            e.this.hdY.aRg();
            if (i == 1) {
                if (e.this.hdW != null) {
                    e.this.hdW.hideTip();
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
            if (this.gYF > i) {
                this.hex = true;
            }
            if (e.this.dHr != null && !e.this.mIsBackground) {
                e.this.dHr.onScroll(this.gYF, i);
            }
            this.gYF = i;
            int i3 = (i + i2) - 1;
            if (!this.hex && this.hew != i3) {
                this.hew = i3;
                e.this.vy(this.hew);
            }
            if (this.hex && this.hew != i) {
                this.hew = i;
                e.this.vy(this.hew);
            }
            e.this.hem = i;
            e.this.gqN = i;
            e.this.eku = (i + i2) - 1;
            af bOF = e.this.bOF();
            if (bOF != null && bOF.nk() != null) {
                bOF.nk().b(e.this.gpx);
            }
        }
    };
    private View.OnTouchListener dsa = new View.OnTouchListener() { // from class: com.baidu.tieba.homepage.personalize.e.22
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (e.this.dus != null) {
                e.this.dus.onTouch(view, motionEvent);
            }
            if (e.this.gNH != null) {
                e.this.gNH.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private a.InterfaceC0499a fSv = new a.InterfaceC0499a() { // from class: com.baidu.tieba.homepage.personalize.e.23
        @Override // com.baidu.tieba.f.a.InterfaceC0499a
        public void z(int i, int i2) {
            e.this.grs = false;
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0499a
        public void A(int i, int i2) {
            e.this.grs = true;
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0499a
        public void bB(int i, int i2) {
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0499a
        public void B(int i, int i2) {
        }
    };
    private View.OnClickListener hei = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.e.24
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (e.this.hdW != null) {
                e.this.hdW.hideTip();
            }
        }
    };
    private final CustomMessageListener hej = new CustomMessageListener(CmdConfigCustom.CMD_RELOAD_HP_PERSONALIZED) { // from class: com.baidu.tieba.homepage.personalize.e.25
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (e.this.gtH != null) {
                e.this.grz.bOE();
                e.this.hcU = false;
                e.this.gYp.setRefreshing(true);
            }
        }
    };
    private CustomMessageListener gGy = new CustomMessageListener(CmdConfigCustom.PB_ACTION_PRAISE) { // from class: com.baidu.tieba.homepage.personalize.e.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            bj bjVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bj) && e.this.hdT != null && v.getCount(e.this.hdT.thread_list) != 0 && (bjVar = (bj) customResponsedMessage.getData()) != null && bjVar.aCc() != null && bjVar.getId() != null && v.getCount(e.this.hdT.thread_list) != 0) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < e.this.hdT.thread_list.size()) {
                        ThreadInfo threadInfo = e.this.hdT.thread_list.get(i2);
                        if (threadInfo == null || threadInfo.id.longValue() != com.baidu.adp.lib.f.b.toLong(bjVar.getId(), -1L)) {
                            i = i2 + 1;
                        } else {
                            ThreadInfo.Builder builder = new ThreadInfo.Builder(threadInfo);
                            Zan.Builder builder2 = new Zan.Builder(builder.zan);
                            builder2.num = Integer.valueOf((int) bjVar.aCc().getNum());
                            builder.zan = builder2.build(true);
                            e.this.hdT.thread_list.set(i2, builder.build(true));
                            return;
                        }
                    } else {
                        return;
                    }
                }
            }
        }
    };
    private CustomMessageListener hek = new CustomMessageListener(CmdConfigCustom.CMD_LIVE_VIDEO_CLOSED_QUERY_RESPONSED) { // from class: com.baidu.tieba.homepage.personalize.e.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            bj bjVar;
            if (customResponsedMessage.getOrginalMessage() instanceof LiveRoomClosedQueryMessage) {
                List<Long> ids = ((LiveRoomClosedQueryMessage) customResponsedMessage.getOrginalMessage()).getIds();
                List<Object> originData = ((LiveRoomClosedQueryMessage) customResponsedMessage.getOrginalMessage()).getOriginData();
                if (!v.isEmpty(e.this.mDataList) && !v.isEmpty(ids) && !v.isEmpty(originData)) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= originData.size()) {
                            break;
                        }
                        if ((originData.get(i2) instanceof bj) && (bjVar = (bj) originData.get(i2)) != null && bjVar.aCK() != null && ids.contains(Long.valueOf(bjVar.aCK().live_id))) {
                            e.this.mDataList.remove(bjVar);
                        }
                        i = i2 + 1;
                    }
                    if (e.this.hdm != null) {
                        e.this.hdm.ac(new ArrayList(e.this.mDataList));
                    }
                }
            }
        }
    };
    private CustomMessageListener dat = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.homepage.personalize.e.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int intValue;
            if ((customResponsedMessage instanceof UpdateAttentionMessage) && e.this.hdT != null && !v.isEmpty(e.this.hdT.thread_list)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid)) {
                    int i = 0;
                    while (true) {
                        if (i >= e.this.hdT.thread_list.size()) {
                            break;
                        }
                        ThreadInfo threadInfo = e.this.hdT.thread_list.get(i);
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
                            e.this.hdT.thread_list.set(i, builder.build(true));
                        }
                    }
                    e.this.a(updateAttentionMessage);
                }
            }
        }
    };
    private String hel = "lastReadReadPositionKey";
    private int hem = 0;
    private d heo = new d() { // from class: com.baidu.tieba.homepage.personalize.e.11
        @Override // com.baidu.tieba.homepage.personalize.d
        public void vh(final int i) {
            if (e.this.hen == null) {
                e.this.hen = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.e.11.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (e.this.gtH.getHandler() != null) {
                            e.this.gtH.requestFocusFromTouch();
                            if (i <= e.this.gtH.getCount() - 1) {
                                e.this.gtH.setSelection(i);
                            }
                        }
                    }
                };
            }
            e.this.gtH.removeCallbacks(e.this.hen);
            e.this.gtH.post(e.this.hen);
        }
    };
    private CustomMessageListener hep = new CustomMessageListener(2016569) { // from class: com.baidu.tieba.homepage.personalize.e.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && e.this.hec != null) {
                e.this.mDataList.remove(e.this.hec);
                e.this.hdm.ac(new ArrayList(e.this.mDataList));
                com.baidu.tbadk.core.sharedPref.b.aFH().putLong("key_maintab_banner_close_time", System.currentTimeMillis());
            }
        }
    };
    private CustomMessageListener gIJ = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.homepage.personalize.e.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.h(customResponsedMessage);
            if (e.this.grz != null && e.this.hcU) {
                e.this.grz.a(e.this.gqN, e.this.eku, e.this.grs, true);
            }
        }
    };
    private CustomMessageListener gIK = new CustomMessageListener(CmdConfigCustom.CMD_THREAD_NOT_EXIST_WHEN_ENTER_PB) { // from class: com.baidu.tieba.homepage.personalize.e.17
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.h(customResponsedMessage);
        }
    };
    private CustomMessageListener gGL = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.homepage.personalize.e.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && e.this.hdT != null && v.getCount(e.this.hdT.thread_list) != 0) {
                String str = (String) customResponsedMessage.getData();
                e.this.h(str, e.this.mDataList);
                e.this.Cj(str);
                if (e.this.hdm != null) {
                    e.this.hdm.ac(new ArrayList(e.this.mDataList));
                }
                if (e.this.grz != null && e.this.hcU) {
                    e.this.grz.a(e.this.gqN, e.this.eku, e.this.grs, true);
                }
            }
        }
    };
    private CustomMessageListener gqF = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.homepage.personalize.e.19
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            af bOF;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent)) {
                KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24 && (bOF = e.this.bOF()) != null && bOF.nk() != null) {
                    bOF.nk().b(new a.C0052a(3));
                }
            }
        }
    };
    private com.baidu.adp.framework.listener.a heq = new com.baidu.adp.framework.listener.a(1003065, CmdConfigSocket.CMD_TOPIC_BLESS) { // from class: com.baidu.tieba.homepage.personalize.e.20
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
                    for (com.baidu.adp.widget.ListView.m mVar : e.this.mDataList) {
                        if ((mVar instanceof com.baidu.tieba.homepage.topic.topictab.b.a) && (bVar = ((com.baidu.tieba.homepage.topic.topictab.b.a) mVar).hjl) != null && longValue == bVar.pkId) {
                            bVar.userPkId = j2;
                            return;
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener gqG = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.homepage.personalize.e.21
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int[] imageWidthAndHeight;
            List<com.baidu.adp.widget.ListView.m> dataList = e.this.hdm.getDataList();
            if (!v.isEmpty(dataList)) {
                for (com.baidu.adp.widget.ListView.m mVar : dataList) {
                    if (mVar instanceof k) {
                        k kVar = (k) mVar;
                        if (kVar.cRu != 0 && kVar.cRt != null) {
                            if ((TbSingleton.getInstance().getHomePageStyleAbTest() & 4) != 0) {
                                imageWidthAndHeight = kVar.cRt.aEi();
                            } else {
                                imageWidthAndHeight = kVar.cRt.getImageWidthAndHeight();
                            }
                            kVar.cRu = imageWidthAndHeight[0];
                            kVar.cRv = imageWidthAndHeight[1];
                        }
                    }
                }
            }
            com.baidu.adp.lib.f.e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.personalize.e.21.1
                @Override // java.lang.Runnable
                public void run() {
                    e.this.hdm.notifyDataSetChanged();
                    if (!e.this.mIsBackground && e.this.hcU) {
                        e.this.grz.a(e.this.gqN, e.this.eku, e.this.grs, true);
                    }
                }
            }, 500L);
        }
    };

    /* loaded from: classes9.dex */
    public interface a {
        void N(int i, int i2, int i3);

        void bOV();

        void onError(int i, String str);

        void onSuccess();

        void z(int i, int i2, int i3, int i4);
    }

    public void mN(boolean z) {
        this.hed = z;
        if (this.hdW != null && !z) {
            this.hdW.hideTip();
        }
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.hcZ = scrollFragmentTabHost;
        if (this.hcZ != null) {
            this.hcZ.setOnTabSelectedListener(new ScrollFragmentTabHost.b() { // from class: com.baidu.tieba.homepage.personalize.e.1
                @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.b
                public void vr(int i) {
                    if (e.this.hcZ.vq(i) != 1 && e.this.hdW != null) {
                        e.this.hdW.hideTip();
                    }
                }
            });
        }
    }

    public void setTabInForeBackgroundState(boolean z) {
        this.mIsBackground = z;
    }

    public void lz(boolean z) {
        boolean z2 = false;
        this.mIsBackground = z;
        if (this.hcZ != null) {
            this.hcZ.lz(z);
        }
        if (this.grz != null) {
            this.grz.oH(!z);
            af bOF = bOF();
            if (bOF != null && bOF.nk() != null) {
                z2 = bOF.nk().b(new a.C0052a(8, Boolean.valueOf(z)));
            }
            if (!z2) {
                if (z) {
                    this.grz.bOE();
                } else if (this.hcU) {
                    this.grz.a(this.gqN, this.eku, this.grs, true);
                }
            }
        }
    }

    public e(TbPageContext<?> tbPageContext, BdTypeRecyclerView bdTypeRecyclerView, ad adVar, BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout) {
        this.heh = 0;
        this.mPageContext = tbPageContext;
        this.heh = com.baidu.tbadk.core.sharedPref.b.aFH().getInt("key_personalized_refresh_type", 0);
        this.gYp = bigdaySwipeRefreshLayout;
        this.gtH = bdTypeRecyclerView;
        this.gtH.setOnTouchListener(this.dsa);
        this.gNH = new com.baidu.tieba.f.a();
        this.gNH.a(this.fSv);
        this.hdm = adVar;
        this.hdX = new com.baidu.tieba.homepage.personalize.model.a();
        this.hdQ = com.baidu.tbadk.core.sharedPref.b.aFH().getLong("recommend_frs_cache_time", 3600L) * 1000;
        bdTypeRecyclerView.setOnScrollListener(this.mOnScrollListener);
        this.hdW = new as();
        bPf();
        this.grz = new m(this.mPageContext, this.gtH);
        this.grz.Az(1);
        this.grz.Ay(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.hdR = new b(this.mDataList, this.hdm);
        this.heg = new SmartBubbleAnimatedView(tbPageContext.getContext());
        this.heg.setLayoutParams(new FrameLayout.LayoutParams(-1, l.getDimens(tbPageContext.getContext(), R.dimen.tbds83)));
        bOW();
        this.gqG.setTag(this.mPageContext.getUniqueId());
        MessageManager.getInstance().registerListener(this.gqG);
    }

    private void bOW() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2016323, new CustomMessageTask.CustomRunnable<Boolean>() { // from class: com.baidu.tieba.homepage.personalize.e.26
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Boolean> customMessage) {
                af bOF = e.this.bOF();
                return (bOF == null || bOF.nk() == null) ? new CustomResponsedMessage<>(2016323, false) : new CustomResponsedMessage<>(2016323, Boolean.valueOf(bOF.nk().b(new a.C0052a(6))));
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private boolean bOX() {
        return com.baidu.tbadk.core.sharedPref.b.aFH().getBoolean(bOZ(), true);
    }

    private void bOY() {
        com.baidu.tbadk.core.sharedPref.b.aFH().putBoolean(bOZ(), false);
    }

    private String bOZ() {
        return "key_rec_pfirst_load_" + TbadkCoreApplication.getCurrentAccount() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + TbConfig.getVersion();
    }

    public void setRecommendFrsNavigationAnimDispatcher(z zVar) {
        if (zVar != null) {
            this.dHr = zVar.aSt();
            this.dus = zVar.aSu();
        }
    }

    public void showFloatingView() {
        if (this.dHr != null) {
            this.dHr.he(true);
        }
    }

    public void update() {
        com.baidu.tieba.homepage.framework.a.bNH().q(System.currentTimeMillis(), 1);
        this.mPn = 1;
        this.heb = true;
        if (this.mDataList.size() == 0 && !bOX()) {
            if (!this.gYx) {
                aAb();
                return;
            }
            return;
        }
        aAa();
    }

    public void bV(int i, int i2) {
        bj bjVar;
        if (!v.isEmpty(this.mDataList) && this.mDataList.size() > i) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            while (i < this.mDataList.size() && i <= i2) {
                if (this.mDataList.get(i).getType().getId() == bj.cRO.getId() && (bjVar = (bj) this.mDataList.get(i)) != null && bjVar.aCK() != null) {
                    arrayList.add(Long.valueOf(bjVar.aCK().live_id));
                    arrayList2.add(bjVar);
                }
                i++;
            }
            if (!v.isEmpty(arrayList)) {
                MessageManager.getInstance().sendMessage(new LiveRoomClosedQueryMessage(arrayList, arrayList2));
            }
        }
    }

    public void bPa() {
        if (this.grz != null && !this.mIsBackground && this.hcU) {
            this.grz.a(this.gqN, this.eku, this.grs, true);
        }
        if (this.hdZ) {
            if (this.gYp != null && !this.gYp.aHY()) {
                if (this.gWw) {
                    com.baidu.tieba.s.c.cKv().b(this.hef, false);
                    if (mP(false)) {
                        bW(3, this.hdV);
                    } else if (this.hea > 0) {
                        bW(2, this.hdV);
                    }
                } else if (!this.gWw && this.hdV == 0) {
                    bW(2, 0);
                }
            }
            this.hdZ = false;
            this.gWw = false;
            this.hea = 0;
            if (this.heb) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
            }
            this.heb = false;
        }
    }

    public void bck() {
        if (isLoading()) {
            com.baidu.tieba.homepage.framework.a.bNH().q(0L, 1);
        } else if (this.hdS != null) {
            bPc();
            this.mPn++;
            setIsLoading(true);
            this.hdS.z(this.mPn, (this.hdT == null || this.hdT.thread_list == null) ? 0 : this.hdT.thread_list.size(), mO(false), 0);
        }
    }

    public void a(boolean z, boolean z2, DataRes dataRes, int i, String str) {
        int size = (this.hdT == null || this.hdT.thread_list == null) ? 0 : this.hdT.thread_list.size();
        if (!z && i == 0 && dataRes != null && v.isEmpty(dataRes.thread_list)) {
            if (this.hdS != null) {
                this.hdS.bOV();
            }
            setIsLoading(false);
            if (this.gYp != null) {
                this.gYp.setRefreshing(false);
                return;
            }
            return;
        }
        if (i != 0 || dataRes == null || !a(true, z, z2, dataRes)) {
            this.hdZ = false;
            if (this.mDataList.size() > 0) {
                if (this.hdS != null) {
                    this.hdS.onError(1, str);
                }
            } else if (this.hdS != null) {
                this.hdS.onError(2, str);
            }
        } else {
            bOY();
            if (this.hdS != null) {
                com.baidu.tbadk.core.sharedPref.b.aFH().putLong(SharedPrefConfig.RECOMMEND_FRS_REFRESH_TIME + TbadkCoreApplication.getCurrentAccount(), System.currentTimeMillis());
                this.hdS.onSuccess();
            }
            this.hdZ = true;
            this.gWw = z;
            this.hea = size;
            byP();
        }
        setIsLoading(false);
        if (this.gYp != null) {
            g.e bPb = bPb();
            if (this.gYp.aHY() && bPb != null) {
                this.gYp.c(bPb);
            } else {
                this.gYp.setRefreshing(false);
            }
        }
    }

    private g.e bPb() {
        int i;
        String feedText;
        if (this.hdZ && this.gYp != null && this.gYp.aHY()) {
            int i2 = this.hdV;
            if (this.gWw) {
                com.baidu.tieba.s.c.cKv().b(this.hef, false);
                if (mP(false)) {
                    i = 3;
                } else {
                    i = this.hea > 0 ? 2 : 0;
                }
            } else if (this.gWw || this.hdV != 0) {
                return null;
            } else {
                i2 = 0;
                i = 2;
            }
            if (this.hcZ != null) {
                this.hdW.bGe();
            }
            if (this.hcZ != null && this.hcZ.getCurrentTabType() != 1) {
                this.hdW.hideTip();
                return null;
            } else if (!this.hed) {
                this.hdW.hideTip();
                return null;
            } else {
                this.hdU = i;
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
                    this.gts = 1000;
                } else {
                    this.gts = 0;
                }
                return new g.e(feedText, this.gts);
            }
        }
        return null;
    }

    public void mD(boolean z) {
        if (z) {
            this.hdm.notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        if (this.grz != null) {
            this.grz.destroy();
        }
        if (this.hdW != null) {
            this.hdW.onDestroy();
        }
        if (this.hdR != null) {
            this.hdR.onDestroy();
        }
        if (this.gtH != null) {
            this.gtH.removeCallbacks(this.hen);
        }
        MessageManager.getInstance().unRegisterTask(2016323);
        MessageManager.getInstance().unRegisterListener(this.gqG);
    }

    public void onPause() {
        c.d(this.gtH);
        vz(this.hem);
        if (this.hdY != null) {
            this.hdY.aRi();
        }
    }

    private void aAa() {
        if (this.hdS != null) {
            this.hdS.N((this.hdT == null || this.hdT.thread_list == null || bPe()) ? 0 : this.hdT.thread_list.size(), mO(true), 0);
        }
    }

    public int mO(boolean z) {
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
                com.baidu.adp.widget.ListView.m mVar = this.mDataList.get(i5);
                if (!(mVar instanceof com.baidu.tieba.card.data.c) || (i3 = ((com.baidu.tieba.card.data.c) mVar).position) == i6) {
                    i3 = i6;
                    i4 = i7;
                } else {
                    i4 = i7 + 1;
                }
                if (!(mVar instanceof com.baidu.tieba.homepage.personalize.data.a) || mVar.getType() == AdvertAppInfo.cMX) {
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
                com.baidu.adp.widget.ListView.m mVar2 = this.mDataList.get(size);
                if (!(mVar2 instanceof com.baidu.tieba.card.data.c) || (i = ((com.baidu.tieba.card.data.c) mVar2).position) == i9) {
                    i = i9;
                    i2 = i8;
                } else {
                    i2 = i8 + 1;
                }
                if ((mVar2 instanceof com.baidu.tieba.homepage.personalize.data.a) && mVar2.getType() != AdvertAppInfo.cMX) {
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
        this.gYx = true;
        if (dataRes != null) {
            if (a(false, true, true, dataRes) && !bPe()) {
                if (this.hdS != null) {
                    this.hdS.onSuccess();
                    Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler() { // from class: com.baidu.tieba.homepage.personalize.e.27
                        @Override // android.os.MessageQueue.IdleHandler
                        public boolean queueIdle() {
                            e.this.aRn();
                            return false;
                        }
                    });
                    return;
                }
                return;
            }
            aAa();
            return;
        }
        aAa();
    }

    public void aRn() {
        long vf = com.baidu.tieba.homepage.framework.a.bNH().vf(1) + com.baidu.tieba.homepage.framework.a.bNH().getCreateTime();
        long vd = com.baidu.tieba.homepage.framework.a.bNH().vd(1);
        if (vd > 0) {
            vf = System.currentTimeMillis() - vd;
        }
        n.aRv().cj(vf);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.util.Set] */
    private void h(List<com.baidu.adp.widget.ListView.m> list, int i) {
        AdvertAppInfo bvD;
        AdvertAppInfo bvD2;
        if (!v.isEmpty(list)) {
            Set<com.baidu.adp.widget.ListView.m> HZ = com.baidu.tieba.recapp.report.a.HZ("NEWINDEX");
            HashSet hashSet = HZ == null ? new HashSet() : HZ;
            HashSet hashSet2 = new HashSet();
            for (com.baidu.adp.widget.ListView.m mVar : list) {
                if (mVar != null) {
                    for (com.baidu.adp.widget.ListView.m mVar2 : hashSet) {
                        if ((mVar instanceof com.baidu.tieba.card.data.d) && (bvD2 = ((com.baidu.tieba.card.data.d) mVar).bvD()) != null && mVar2 != null && (mVar2 instanceof AdvertAppInfo) && mVar2.hashCode() == bvD2.hashCode()) {
                            bvD2.advertAppContext = ((AdvertAppInfo) mVar2).advertAppContext;
                        }
                    }
                    if (mVar != null && (mVar instanceof com.baidu.tieba.card.data.d) && (bvD = ((com.baidu.tieba.card.data.d) mVar).bvD()) != null && bvD.advertAppContext == null) {
                        bvD.advertAppContext = new com.baidu.tbadk.core.data.c();
                        bvD.advertAppContext.page = "NEWINDEX";
                        bvD.advertAppContext.pn = this.mPn;
                        bvD.advertAppContext.extensionInfo = bvD.extensionInfo;
                        bvD.advertAppContext.Dn = false;
                        hashSet2.add(bvD);
                    }
                }
            }
            hashSet.addAll(hashSet2);
            com.baidu.tieba.recapp.report.a.b("NEWINDEX", hashSet);
            if (hashSet2.size() > 0) {
                com.baidu.tieba.s.c.cKv().b(this.hef, com.baidu.tieba.s.a.b(PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE, "common_fill", true, hashSet2.size()));
            }
        }
    }

    private boolean a(boolean z, boolean z2, boolean z3, DataRes dataRes) {
        List<com.baidu.adp.widget.ListView.m> list;
        int i;
        boolean z4;
        if (dataRes == null) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.heh == 1) {
            if (z2 && (dataRes.thread_list.size() >= 6 || bPe())) {
                bPd();
                this.hdT = null;
            }
        } else if (z2 && bPe()) {
            this.hdT = null;
        }
        int size = z2 ? 0 : this.mDataList.size();
        DataRes.Builder builder = new DataRes.Builder(dataRes);
        this.mDataList.clear();
        com.baidu.tieba.homepage.personalize.model.c a2 = this.hdX.a(z, this.hdT, builder, z2 ? 0 : 1);
        if (a2 == null) {
            list = null;
            i = 0;
        } else {
            List<com.baidu.adp.widget.ListView.m> list2 = a2.dTH;
            this.hdV = a2.hgM;
            int i2 = a2.hgN;
            a2.hgN = 0;
            list = list2;
            i = i2;
        }
        if (list != null) {
            this.mDataList.addAll(list);
            h(list, size);
            a(z2 ? 0 : 1, list, size);
            if (this.heb) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
            }
        }
        if (this.hdT == null) {
            this.hdT = builder;
            this.hdR.cC(this.hdT.thread_list);
        }
        if (this.mDataList.size() == 0) {
            z4 = false;
        } else {
            if (z2) {
                if (dataRes.live_answer != null) {
                    this.hec = new com.baidu.tieba.homepage.personalize.data.g();
                    this.hec.a(dataRes.live_answer);
                    this.hdT.live_answer = dataRes.live_answer;
                } else if (z) {
                    this.hec = null;
                    this.hdT.live_answer = null;
                }
                this.hee = dataRes.float_info;
                this.hdT.float_info = dataRes.float_info;
            }
            long j = com.baidu.tbadk.core.sharedPref.b.aFH().getLong("key_maintab_banner_close_time", 0L);
            if (this.hec != null && !aq.isTaday(j)) {
                this.mDataList.add(0, this.hec);
            }
            LinkedList linkedList = new LinkedList(this.mDataList);
            this.hdm.setFromCDN(dataRes.is_new_url.intValue() == 1);
            this.hdm.i(linkedList, i);
            z4 = true;
            if (this.grz != null && this.hcU) {
                this.grz.a(this.gqN, this.eku, this.grs, true);
            }
        }
        com.baidu.tieba.homepage.framework.a.bNH().o(System.currentTimeMillis() - currentTimeMillis, 1);
        long vg = com.baidu.tieba.homepage.framework.a.bNH().vg(1);
        if (vg > 0) {
            com.baidu.tieba.homepage.framework.a.bNH().p(System.currentTimeMillis() - vg, 1);
            com.baidu.tieba.homepage.framework.a.bNH().q(0L, 1);
        }
        if (dataRes.anti != null && dataRes.anti.block_pop_info != null) {
            com.baidu.tieba.ueg.d.d(dataRes.anti.block_pop_info);
        }
        ay ayVar = new ay();
        ayVar.a(dataRes.recom_post_topic);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_REFRESH_TOPIC_TIP, ayVar));
        return z4;
    }

    private void bPc() {
        List<com.baidu.adp.widget.ListView.m> list;
        int i;
        if (v.getCount(this.mDataList) >= this.hdX.bPz() - 40) {
            com.baidu.tieba.homepage.personalize.model.c a2 = this.hdX.a(true, this.hdT, (DataRes.Builder) null, 1);
            if (a2 != null) {
                List<com.baidu.adp.widget.ListView.m> list2 = a2.dTH;
                i = a2.hgN;
                a2.hgN = 0;
                list = list2;
            } else {
                list = null;
                i = 0;
            }
            if (list != null) {
                this.mDataList.clear();
                this.mDataList.addAll(list);
                this.hdm.i(new LinkedList(this.mDataList), i);
            }
        }
    }

    private void aAb() {
        this.gYx = true;
        ac.a(new ab<DataRes>() { // from class: com.baidu.tieba.homepage.personalize.e.28
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.ab
            /* renamed from: bPj */
            public DataRes doInBackground() {
                com.baidu.adp.lib.cache.l<byte[]> cp = com.baidu.tbadk.core.c.a.aEF().cp("tb.rec_frs_update", TbadkCoreApplication.getCurrentAccount());
                if (cp == null) {
                    return null;
                }
                byte[] bArr = cp.get("0");
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
        }, new com.baidu.tbadk.util.l<DataRes>() { // from class: com.baidu.tieba.homepage.personalize.e.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.l
            /* renamed from: b */
            public void onReturnDataInUI(DataRes dataRes) {
                e.this.a(dataRes);
            }
        });
    }

    private void byP() {
        if (this.hdT != null) {
            DataRes.Builder builder = new DataRes.Builder(this.hdT.build(true));
            if (builder.thread_list != null && builder.thread_list.size() > 30) {
                builder.thread_list = builder.thread_list.subList(0, 30);
            }
            a(builder, builder.thread_list != null ? builder.thread_list.size() : 0);
            a(builder);
            b(builder);
        }
    }

    private void bPd() {
        if (this.hdT != null) {
            final DataRes.Builder builder = new DataRes.Builder(this.hdT.build(true));
            if (builder.thread_list != null && builder.thread_list.size() > 50) {
                builder.thread_list = builder.thread_list.subList(0, 50);
            }
            a(builder, builder.thread_list != null ? builder.thread_list.size() : 0);
            ac.a(new ab<Object>() { // from class: com.baidu.tieba.homepage.personalize.e.3
                @Override // com.baidu.tbadk.util.ab
                public Object doInBackground() {
                    DataRes.Builder builder2 = new DataRes.Builder(builder.build(true));
                    e.this.hdR.cD(builder2.thread_list);
                    try {
                        com.baidu.tbadk.core.c.a.aEF().cp("tb.rec_old_data", TbadkCoreApplication.getCurrentAccount()).setForever("0", builder2.build(true).toByteArray());
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

    /* JADX INFO: Access modifiers changed from: private */
    public void Cj(String str) {
        if (!TextUtils.isEmpty(str) && this.hdT != null && this.hdT.banner_list != null && this.hdT.banner_list.app != null && this.hdT.banner_list.app.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (App app : this.hdT.banner_list.app) {
                if (app != null && str.equals(app.id)) {
                    arrayList.add(app);
                }
            }
            BannerList.Builder builder = new BannerList.Builder(this.hdT.banner_list);
            if (builder.app != null) {
                builder.app.removeAll(arrayList);
            }
            this.hdT.banner_list = builder.build(false);
            DataRes.Builder builder2 = new DataRes.Builder(this.hdT.build(true));
            builder2.banner_list = builder.build(true);
            b(builder2);
        }
    }

    private void b(final DataRes.Builder builder) {
        ac.a(new ab<Object>() { // from class: com.baidu.tieba.homepage.personalize.e.4
            @Override // com.baidu.tbadk.util.ab
            public Object doInBackground() {
                DataRes.Builder builder2 = new DataRes.Builder(builder.build(true));
                e.this.hdR.cD(builder2.thread_list);
                try {
                    com.baidu.tbadk.core.c.a.aEF().cp("tb.rec_frs_update", TbadkCoreApplication.getCurrentAccount()).setForever("0", builder2.build(true).toByteArray());
                    return null;
                } catch (Exception e) {
                    BdLog.e(e);
                    return null;
                }
            }
        }, null);
    }

    private boolean bPe() {
        return mP(true);
    }

    private boolean mP(boolean z) {
        long j = com.baidu.tbadk.core.sharedPref.b.aFH().getLong(SharedPrefConfig.RECOMMEND_FRS_REFRESH_TIME + TbadkCoreApplication.getCurrentAccount(), 0L);
        return j == 0 ? z : Math.abs(System.currentTimeMillis() - j) > this.hdQ;
    }

    public void a(a aVar) {
        this.hdS = aVar;
    }

    private boolean isLoading() {
        return this.mIsLoading;
    }

    private void setIsLoading(boolean z) {
        this.mIsLoading = z;
    }

    public void bOS() {
        boolean z = true;
        com.baidu.tbadk.coreExtra.data.b activityPrizeData = TbadkCoreApplication.getInst().getActivityPrizeData();
        if (activityPrizeData.isSwitchTurn() && !StringUtils.isNull(activityPrizeData.getFeedText())) {
            String currentDay = UtilHelper.getCurrentDay();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            String str = "";
            if (!StringUtils.isNull(currentAccount)) {
                String string = com.baidu.tbadk.core.sharedPref.b.aFH().getString(SharedPrefConfig.ACTIVITY_PRIZE_FEED_TEXT_TIME, "");
                if (!StringUtils.isNull(string)) {
                    String[] split = string.split("@");
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
                                    sb.append(currentDay).append("@");
                                    for (String str3 : asList) {
                                        sb.append(str3).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
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
                    bW(4, 0);
                    com.baidu.tbadk.core.sharedPref.b.aFH().putString(SharedPrefConfig.ACTIVITY_PRIZE_FEED_TEXT_TIME, str);
                }
            }
        }
    }

    private void bW(int i, int i2) {
        if (this.hcZ != null) {
            this.hdW.bGe();
        }
        if (this.hcZ != null && this.hcZ.getCurrentTabType() != 1) {
            this.hdW.hideTip();
        } else if (!this.hed) {
            this.hdW.hideTip();
        } else {
            this.hdU = i;
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
                    this.gts = 3000;
                } else {
                    this.gts = 2000;
                }
                this.heg.dhx = str;
                this.heg.gtl = this.gts;
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 49;
                if (this.hcZ != null) {
                    FrameLayout frameLayout = this.hcZ.getFrameLayout();
                    frameLayout.removeView(this.heg);
                    frameLayout.addView(this.heg, layoutParams);
                    this.heg.bGc();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(Long l) {
        if (this.hdT != null && this.hdT.thread_list != null) {
            List<ThreadInfo> list = this.hdT.thread_list;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                ThreadInfo threadInfo = list.get(i);
                if (threadInfo.tid.equals(l) && threadInfo.top_agree_post != null) {
                    ThreadInfo.Builder builder = new ThreadInfo.Builder(threadInfo);
                    builder.top_agree_post = null;
                    list.set(i, builder.build(true));
                    byP();
                    a(false, true, false, this.hdT.build(true));
                    return;
                }
            }
        }
    }

    public void m(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.hef = bdUniqueId;
            if (this.gGy != null) {
                this.gGy.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.gGy);
            }
            if (this.hej != null) {
                this.hej.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.hej);
            }
            this.dat.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.dat);
            this.hek.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.hek);
            this.gIJ.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.gIJ);
            this.gIK.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.gIK);
            this.gGL.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.gGL);
            if (this.grz != null) {
                this.grz.setUniqueId(bdUniqueId);
            }
            this.hdR.j(bdUniqueId);
            this.hep.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.hep);
            this.gqF.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.gqF);
            this.heq.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.heq);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(UpdateAttentionMessage updateAttentionMessage) {
        if (updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid)) {
            final String str = updateAttentionMessage.getData().toUid;
            final boolean z = updateAttentionMessage.getData().isAttention;
            ac.a(new ab<Boolean>() { // from class: com.baidu.tieba.homepage.personalize.e.8
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.baidu.tbadk.util.ab
                public Boolean doInBackground() {
                    int intValue;
                    try {
                        com.baidu.adp.lib.cache.l<byte[]> cp = com.baidu.tbadk.core.c.a.aEF().cp("tb.rec_frs_update", TbadkCoreApplication.getCurrentAccount());
                        if (cp == null) {
                            return false;
                        }
                        byte[] bArr = cp.get("0");
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
                        e.this.hdR.cD(builder5.thread_list);
                        cp.setForever("0", builder5.build(true).toByteArray());
                        return true;
                    } catch (Exception e) {
                        BdLog.e(e);
                        return false;
                    }
                }
            }, new com.baidu.tbadk.util.l<Boolean>() { // from class: com.baidu.tieba.homepage.personalize.e.9
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.l
                public void onReturnDataInUI(Boolean bool) {
                }
            });
        }
    }

    public void bPf() {
        this.gpf = new com.baidu.tieba.tbadkCore.data.f("new_index", null);
        this.gpf.cLc();
    }

    public void a(int i, List<com.baidu.adp.widget.ListView.m> list, int i2) {
        int i3;
        int i4;
        if (this.gpf != null) {
            if (i == 0) {
                this.gpf.cLc();
            }
            if (list != null && !list.isEmpty()) {
                int[] iArr = com.baidu.tieba.tbadkCore.data.f.khI;
                int i5 = 0;
                int i6 = 0;
                int i7 = 0;
                while (i7 < list.size() && i6 < iArr.length && (i3 = iArr[i6]) >= 0) {
                    if (list.get(i7) instanceof com.baidu.tieba.card.data.c) {
                        i4 = i5 + 1;
                        if (i4 == i3 - 1) {
                            if (i2 < i7 + 1) {
                                this.gpf.cK(i3, i7 + 1);
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

    public void vy(int i) {
        if ((this.gpf != null ? this.gpf.CB(i) : -1) >= 0 && this.gtH != null && this.gtH.getData() != null && this.gtH.getData().size() > i) {
            this.gpf.CC(i);
        }
    }

    public m bEV() {
        return this.grz;
    }

    public void mJ(boolean z) {
        this.hcU = z;
    }

    public void vz(final int i) {
        ac.a(new ab<Object>() { // from class: com.baidu.tieba.homepage.personalize.e.10
            @Override // com.baidu.tbadk.util.ab
            public Object doInBackground() {
                com.baidu.adp.lib.cache.l<String> cq = com.baidu.tbadk.core.c.a.aEF().cq(e.this.hel, TbadkCoreApplication.getCurrentAccount());
                if (cq != null) {
                    cq.set(e.this.hel, Integer.toString(i), 43200000L);
                    return null;
                }
                return null;
            }
        }, null);
    }

    public void a(final d dVar) {
        ac.a(new ab<String>() { // from class: com.baidu.tieba.homepage.personalize.e.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.ab
            /* renamed from: bPi */
            public String doInBackground() {
                com.baidu.adp.lib.cache.l<String> cq = com.baidu.tbadk.core.c.a.aEF().cq(e.this.hel, TbadkCoreApplication.getCurrentAccount());
                if (cq != null) {
                    return cq.get(e.this.hel);
                }
                return null;
            }
        }, new com.baidu.tbadk.util.l<String>() { // from class: com.baidu.tieba.homepage.personalize.e.14
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.l
            /* renamed from: Ck */
            public void onReturnDataInUI(String str) {
                if (dVar != null) {
                    dVar.vh(com.baidu.adp.lib.f.b.toInt(str, 0));
                }
            }
        });
    }

    public void bOT() {
        c.e(this.gtH);
    }

    public void bPg() {
        a(this.heo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(CustomResponsedMessage<?> customResponsedMessage) {
        boolean z;
        String str;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.hdT != null && v.getCount(this.hdT.thread_list) != 0 && v.getCount(this.mDataList) != 0) {
            JSONObject jSONObject = (JSONObject) customResponsedMessage.getData();
            String optString = jSONObject.optString("tid");
            if (StringUtils.isNull(optString)) {
                String optString2 = jSONObject.optString("liveid");
                if (this.gtH != null && !TextUtils.isEmpty(optString2)) {
                    int i = 0;
                    while (true) {
                        if (i >= this.gtH.getCount()) {
                            str = optString;
                            break;
                        }
                        com.baidu.adp.widget.ListView.m item = this.gtH.getItem(i);
                        if (item instanceof com.baidu.tieba.card.data.j) {
                            com.baidu.tieba.card.data.j jVar = (com.baidu.tieba.card.data.j) item;
                            if (jVar.aAj() != null && jVar.aAj().aCK() != null && optString2.equals(String.valueOf(jVar.aAj().aCK().live_id))) {
                                str = jVar.aAj().getTid();
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
            Iterator<com.baidu.adp.widget.ListView.m> it = this.mDataList.iterator();
            boolean z2 = false;
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.adp.widget.ListView.m next = it.next();
                if (next instanceof com.baidu.tieba.card.data.c) {
                    com.baidu.tieba.card.data.c cVar = (com.baidu.tieba.card.data.c) next;
                    if (cVar.aAj() != null && cVar.aAj().getTid() != null) {
                        if (cVar.aAj().getTid().equals(optString)) {
                            it.remove();
                            z = true;
                            z2 = z;
                        } else if (z2) {
                            com.baidu.tieba.homepage.personalize.model.b.cF(this.mDataList);
                            break;
                        }
                    }
                }
                z = z2;
                z2 = z;
            }
            if (this.hdT != null && this.hdT.thread_list != null) {
                long j = com.baidu.adp.lib.f.b.toLong(optString, 0L);
                int i2 = 0;
                while (true) {
                    if (i2 < this.hdT.thread_list.size()) {
                        ThreadInfo threadInfo = this.hdT.thread_list.get(i2);
                        if (threadInfo == null || threadInfo.tid == null || threadInfo.tid.longValue() != j) {
                            i2++;
                        } else {
                            this.hdT.thread_list.remove(i2);
                            byP();
                            com.baidu.tieba.homepage.personalize.b.d.a(threadInfo.tid.longValue(), i2, this.hdT.thread_list, this.mDataList);
                            break;
                        }
                    } else {
                        break;
                    }
                }
                if (this.gtH != null) {
                    List<Integer> b = b(optString, this.gtH);
                    int intValue = b.get(0).intValue();
                    int intValue2 = b.get(1).intValue();
                    if (intValue != -1 && intValue2 != -1) {
                        this.gtH.m(intValue, intValue2);
                    }
                }
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
                com.baidu.adp.widget.ListView.m item = bdTypeRecyclerView.getItem(i4);
                if (item instanceof com.baidu.tieba.card.data.c) {
                    com.baidu.tieba.card.data.c cVar = (com.baidu.tieba.card.data.c) item;
                    if (cVar.aAj() != null && cVar.aAj().getTid().equals(str)) {
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
    public void h(String str, List<com.baidu.adp.widget.ListView.m> list) {
        AdvertAppInfo advertAppInfo;
        if (list != null && list.size() > 0 && !TextUtils.isEmpty(str)) {
            Iterator<com.baidu.adp.widget.ListView.m> it = list.iterator();
            AdvertAppInfo advertAppInfo2 = null;
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.m next = it.next();
                if (next instanceof com.baidu.tieba.homepage.personalize.data.a) {
                    advertAppInfo = ((com.baidu.tieba.homepage.personalize.data.a) next).bvD();
                } else {
                    if (next instanceof ae) {
                        ae aeVar = (ae) next;
                        if (aeVar.aAP() instanceof AdvertAppInfo.ILegoAdvert) {
                            advertAppInfo = ((AdvertAppInfo.ILegoAdvert) aeVar.aAP()).getAdvertAppInfo();
                        }
                    }
                    advertAppInfo = advertAppInfo2;
                }
                if (advertAppInfo != null && str.equals(advertAppInfo.cNk)) {
                    it.remove();
                    advertAppInfo = null;
                }
                advertAppInfo2 = advertAppInfo;
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (this.heg != null) {
            this.heg.onChangeSkinType(i);
        }
    }

    public FloatInfo bPh() {
        return this.hee;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public af bOF() {
        if (this.grz == null || this.grz.czc() == null || !(this.grz.czc().getTag() instanceof af)) {
            return null;
        }
        return (af) this.grz.czc().getTag();
    }
}
