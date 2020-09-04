package com.baidu.tieba.ala.guardclub.rank;

import android.content.Intent;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.av;
import com.baidu.live.guardclub.g;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.ala.AlaLastLiveroomInfo;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atom.GuardClubActivityConfig;
import com.baidu.live.tbadk.core.atomdata.AlaLiveRoomActivityConfig;
import com.baidu.live.tbadk.core.atomdata.BuyTBeanActivityConfig;
import com.baidu.live.tbadk.core.atomdata.GuardClubInfoActivityConfig;
import com.baidu.live.tbadk.core.data.AccountData;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.fragment.SupportXFragment;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.frameworkdata.IntentAction;
import com.baidu.live.tbadk.core.frameworkdata.IntentConfig;
import com.baidu.tieba.ala.guardclub.h;
import com.baidu.tieba.ala.guardclub.model.i;
import com.baidu.tieba.ala.guardclub.model.k;
import com.baidu.tieba.ala.guardclub.rank.d;
/* loaded from: classes7.dex */
public class b implements d.a {
    private String aIA;
    private String aIB;
    private String aTe;
    private com.baidu.live.l.c aUD;
    private CustomMessageListener aVP;
    private CustomMessageListener bck;
    private String beu;
    private long bey;
    private a gcL;
    private boolean gcM;
    private boolean gcN;
    private i gcO;
    private h gcP;
    private TbPageContext mContext;
    private String mOtherParams;
    private long mRoomId;

    /* loaded from: classes7.dex */
    public interface a {
        void N(Intent intent);

        void a(SupportXFragment... supportXFragmentArr);

        void az(String str, int i);

        ViewGroup bKk();

        void tr(int i);

        void v(String str, long j);
    }

    public b(TbPageContext tbPageContext) {
        this.mContext = tbPageContext;
    }

    public void a(Intent intent, a aVar) {
        this.gcL = aVar;
        k(intent);
        Hk();
        bKA();
        Ho();
    }

    public void bKy() {
        if (this.aUD == null) {
            this.aUD = new com.baidu.live.l.c();
            this.aUD.initListener();
        }
        this.aUD.refreshCurUserScores();
    }

    public void aA(String str, int i) {
        if (i > TbadkCoreApplication.getInst().currentAccountTdouNum) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyTBeanActivityConfig(this.mContext.getPageActivity(), 0L, this.mOtherParams, true, "", true)));
            return;
        }
        if (this.gcO == null) {
            this.gcO = new i();
            this.gcO.a(new com.baidu.tieba.ala.guardclub.model.b() { // from class: com.baidu.tieba.ala.guardclub.rank.b.1
                @Override // com.baidu.tieba.ala.guardclub.model.b, com.baidu.tieba.ala.guardclub.model.m.a
                public void a(boolean z, String str2, long j, String str3, String str4) {
                    super.a(z, str2, j, str3, str4);
                    b.this.b(z, str2, j, str3, str4);
                }
            });
        }
        this.gcO.Fy(str);
    }

    public void release() {
        this.gcL = null;
        if (this.gcP != null) {
            this.gcP.onDestory();
        }
        if (this.gcO != null) {
            this.gcO.release();
        }
        if (this.aUD != null) {
            this.aUD.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.aVP);
        MessageManager.getInstance().unRegisterListener(this.bck);
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.d.a
    public void lv(boolean z) {
        this.gcN = z;
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.d.a
    public void tr(int i) {
        if (this.gcL != null) {
            this.gcL.tr(i);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.d.a
    public void c(k kVar) {
        if (kVar.liveStatus == 1 && !TextUtils.isEmpty(kVar.liveId)) {
            if (this.gcN) {
                BdUtilHelper.showToast(this.mContext.getPageActivity(), "正在直播中，不能切换直播间哟！");
                return;
            } else if (String.valueOf(this.bey).equals(kVar.liveId)) {
                if (this.gcL != null) {
                    this.gcL.N(new Intent().putExtra("guard_club_rank_back_to_room", true));
                    return;
                }
                return;
            } else {
                dZ(Long.valueOf(kVar.liveId).longValue());
                return;
            }
        }
        e(kVar);
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.d.a
    public void d(k kVar) {
        int i = 1000;
        av Io = g.Im().Io();
        if (Io != null && Io.aIS > 0) {
            i = Io.aIS;
        }
        if (this.gcL != null) {
            this.gcL.az(kVar.id, i);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.d.a
    public void bKz() {
        if (this.gcL != null) {
            this.gcL.N(new Intent().putExtra("guard_club_rank_hit", true));
        }
    }

    private void k(Intent intent) {
        this.beu = String.valueOf(intent.getLongExtra(GuardClubActivityConfig.ANCHOR_ID, 0L));
        this.bey = intent.getLongExtra(GuardClubActivityConfig.LIVE_ID, 0L);
        this.gcM = intent.getBooleanExtra(GuardClubActivityConfig.IS_LIVE_OWNER, false);
        this.mOtherParams = intent.getStringExtra(IntentConfig.OTHER_PARAMS);
        this.mRoomId = intent.getLongExtra(GuardClubActivityConfig.ROOM_ID, 0L);
        this.aTe = intent.getStringExtra(GuardClubActivityConfig.FEED_ID);
        this.aIA = intent.getStringExtra(GuardClubActivityConfig.ANCHOR_NAME);
        this.aIB = intent.getStringExtra(GuardClubActivityConfig.ANCHOR_PORTRAIT);
    }

    private void Hk() {
        this.aVP = new CustomMessageListener(2913097) { // from class: com.baidu.tieba.ala.guardclub.rank.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (b.this.gcL != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    b.this.gcL.N(null);
                }
            }
        };
        MessageManager.getInstance().registerListener(this.aVP);
    }

    private void bKA() {
        this.bck = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.guardclub.rank.b.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                    String str = (String) customResponsedMessage.getData();
                    if (str == null) {
                        str = "";
                    }
                    b.this.mOtherParams = str;
                }
            }
        };
    }

    private void Ho() {
        c cVar = new c(this.mContext.getPageActivity(), 2, this.beu, this.gcM);
        cVar.a(this);
        c cVar2 = new c(this.mContext.getPageActivity(), 1, this.beu, this.gcM);
        cVar2.a(this);
        if (this.gcL != null) {
            this.gcL.a(cVar, cVar2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z, String str, long j, String str2, String str3) {
        AccountData currentAccountInfo;
        if (!z) {
            if (TextUtils.isEmpty(str3)) {
                str3 = "加入真爱团失败";
            }
            BdUtilHelper.showToast(TbadkCoreApplication.getInst(), str3);
            return;
        }
        if (this.gcL != null) {
            this.gcL.v(str, j);
            ViewGroup bKk = this.gcL.bKk();
            if (bKk != null && (currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo()) != null) {
                if (this.gcP == null) {
                    this.gcP = new h(this.mContext.getPageActivity());
                }
                this.gcP.setOtherParams(this.mOtherParams);
                int[] iArr = new int[2];
                bKk.getLocationOnScreen(iArr);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams.topMargin = iArr[1] * (-1);
                this.gcP.a(bKk, layoutParams, currentAccountInfo.getPortrait(), currentAccountInfo.getAccountNameShow());
            }
        }
        if (!TextUtils.isEmpty(str2)) {
            com.baidu.live.m.a.ay(str2, "guard_club_join");
        }
    }

    private void dZ(long j) {
        if (!TbadkCoreApplication.getInst().isMobileBaidu() || com.baidu.live.w.a.Nk().beJ.aGO) {
            AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(this.mContext.getPageActivity());
            alaLiveRoomActivityConfig.addExtraByLiveId(j, "", AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_SDK);
            alaLiveRoomActivityConfig.addExtraByParams(this.mOtherParams);
            AlaLastLiveroomInfo alaLastLiveroomInfo = new AlaLastLiveroomInfo();
            alaLastLiveroomInfo.setLastAnchorUid(this.beu);
            alaLastLiveroomInfo.setLastAnchorUname(this.aIA);
            alaLastLiveroomInfo.setLastAnchorPortrait(this.aIB);
            alaLastLiveroomInfo.setLastLiveId(this.bey);
            alaLastLiveroomInfo.setLastRoomId(this.mRoomId);
            alaLastLiveroomInfo.setFrom(AlaLastLiveroomInfo.TYPE_FROM_GUARD_RANK);
            alaLiveRoomActivityConfig.addLastLiveInfoParams(alaLastLiveroomInfo);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_LIVE_ROOM_START, alaLiveRoomActivityConfig));
            if (this.gcL != null) {
                this.gcL.N(null);
            }
        }
    }

    private void e(k kVar) {
        boolean z = this.gcM;
        if (z && !TextUtils.isEmpty(this.beu) && !TextUtils.isEmpty(kVar.aKj) && !this.beu.equals(kVar.aKj)) {
            z = false;
        }
        GuardClubInfoActivityConfig guardClubInfoActivityConfig = new GuardClubInfoActivityConfig(this.mContext.getPageActivity(), Long.valueOf(kVar.aKj).longValue(), 0L, z, this.mOtherParams, kVar.gcJ);
        guardClubInfoActivityConfig.setRoomId(this.mRoomId);
        guardClubInfoActivityConfig.setFeedId(this.aTe);
        guardClubInfoActivityConfig.setIsClubMember(kVar.gcJ);
        guardClubInfoActivityConfig.setHideRank(true);
        guardClubInfoActivityConfig.setIsTranslucent(true);
        guardClubInfoActivityConfig.setRequestCode(RequestResponseCode.REQUEST_GUARD_CLUB_INFO);
        guardClubInfoActivityConfig.setIntentAction(IntentAction.ActivityForResult);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, guardClubInfoActivityConfig));
    }
}
