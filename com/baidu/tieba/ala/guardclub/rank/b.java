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
import com.baidu.live.data.at;
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
/* loaded from: classes4.dex */
public class b implements d.a {
    private String aDo;
    private String aDp;
    private String aNP;
    private com.baidu.live.l.c aPn;
    private CustomMessageListener aQz;
    private CustomMessageListener aWT;
    private String aYY;
    private long aZc;
    private a fQJ;
    private boolean fQK;
    private boolean fQL;
    private i fQM;
    private h fQN;
    private TbPageContext mContext;
    private String mOtherParams;
    private long mRoomId;

    /* loaded from: classes4.dex */
    public interface a {
        void L(Intent intent);

        void a(SupportXFragment... supportXFragmentArr);

        void aw(String str, int i);

        ViewGroup bAO();

        void rf(int i);

        void u(String str, long j);
    }

    public b(TbPageContext tbPageContext) {
        this.mContext = tbPageContext;
    }

    public void a(Intent intent, a aVar) {
        this.fQJ = aVar;
        k(intent);
        BH();
        bBf();
        BL();
    }

    public void bBd() {
        if (this.aPn == null) {
            this.aPn = new com.baidu.live.l.c();
            this.aPn.initListener();
        }
        this.aPn.refreshCurUserScores();
    }

    public void ax(String str, int i) {
        if (i > TbadkCoreApplication.getInst().currentAccountTdouNum) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyTBeanActivityConfig(this.mContext.getPageActivity(), 0L, this.mOtherParams, true, "", true)));
            return;
        }
        if (this.fQM == null) {
            this.fQM = new i();
            this.fQM.a(new com.baidu.tieba.ala.guardclub.model.b() { // from class: com.baidu.tieba.ala.guardclub.rank.b.1
                @Override // com.baidu.tieba.ala.guardclub.model.b, com.baidu.tieba.ala.guardclub.model.m.a
                public void a(boolean z, String str2, long j, String str3, String str4) {
                    super.a(z, str2, j, str3, str4);
                    b.this.b(z, str2, j, str3, str4);
                }
            });
        }
        this.fQM.Dc(str);
    }

    public void release() {
        this.fQJ = null;
        if (this.fQN != null) {
            this.fQN.onDestory();
        }
        if (this.fQM != null) {
            this.fQM.release();
        }
        if (this.aPn != null) {
            this.aPn.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.aQz);
        MessageManager.getInstance().unRegisterListener(this.aWT);
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.d.a
    public void kT(boolean z) {
        this.fQL = z;
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.d.a
    public void rf(int i) {
        if (this.fQJ != null) {
            this.fQJ.rf(i);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.d.a
    public void c(k kVar) {
        if (kVar.liveStatus == 1 && !TextUtils.isEmpty(kVar.liveId)) {
            if (this.fQL) {
                BdUtilHelper.showToast(this.mContext.getPageActivity(), "正在直播中，不能切换直播间哟！");
                return;
            } else if (String.valueOf(this.aZc).equals(kVar.liveId)) {
                if (this.fQJ != null) {
                    this.fQJ.L(new Intent().putExtra("guard_club_rank_back_to_room", true));
                    return;
                }
                return;
            } else {
                dO(Long.valueOf(kVar.liveId).longValue());
                return;
            }
        }
        e(kVar);
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.d.a
    public void d(k kVar) {
        int i = 1000;
        at CL = g.CJ().CL();
        if (CL != null && CL.aDG > 0) {
            i = CL.aDG;
        }
        if (this.fQJ != null) {
            this.fQJ.aw(kVar.id, i);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.d.a
    public void bBe() {
        if (this.fQJ != null) {
            this.fQJ.L(new Intent().putExtra("guard_club_rank_hit", true));
        }
    }

    private void k(Intent intent) {
        this.aYY = String.valueOf(intent.getLongExtra(GuardClubActivityConfig.ANCHOR_ID, 0L));
        this.aZc = intent.getLongExtra(GuardClubActivityConfig.LIVE_ID, 0L);
        this.fQK = intent.getBooleanExtra(GuardClubActivityConfig.IS_LIVE_OWNER, false);
        this.mOtherParams = intent.getStringExtra(IntentConfig.OTHER_PARAMS);
        this.mRoomId = intent.getLongExtra(GuardClubActivityConfig.ROOM_ID, 0L);
        this.aNP = intent.getStringExtra(GuardClubActivityConfig.FEED_ID);
        this.aDo = intent.getStringExtra(GuardClubActivityConfig.ANCHOR_NAME);
        this.aDp = intent.getStringExtra(GuardClubActivityConfig.ANCHOR_PORTRAIT);
    }

    private void BH() {
        this.aQz = new CustomMessageListener(2913097) { // from class: com.baidu.tieba.ala.guardclub.rank.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (b.this.fQJ != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    b.this.fQJ.L(null);
                }
            }
        };
        MessageManager.getInstance().registerListener(this.aQz);
    }

    private void bBf() {
        this.aWT = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.guardclub.rank.b.3
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

    private void BL() {
        c cVar = new c(this.mContext.getPageActivity(), 2, this.aYY, this.fQK);
        cVar.a(this);
        c cVar2 = new c(this.mContext.getPageActivity(), 1, this.aYY, this.fQK);
        cVar2.a(this);
        if (this.fQJ != null) {
            this.fQJ.a(cVar, cVar2);
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
        if (this.fQJ != null) {
            this.fQJ.u(str, j);
            ViewGroup bAO = this.fQJ.bAO();
            if (bAO != null && (currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo()) != null) {
                if (this.fQN == null) {
                    this.fQN = new h(this.mContext.getPageActivity());
                }
                this.fQN.setOtherParams(this.mOtherParams);
                int[] iArr = new int[2];
                bAO.getLocationOnScreen(iArr);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams.topMargin = iArr[1] * (-1);
                this.fQN.a(bAO, layoutParams, currentAccountInfo.getPortrait(), currentAccountInfo.getAccountNameShow());
            }
        }
        if (!TextUtils.isEmpty(str2)) {
            com.baidu.live.m.a.au(str2, "guard_club_join");
        }
    }

    private void dO(long j) {
        if (!TbadkCoreApplication.getInst().isMobileBaidu() || com.baidu.live.v.a.Hs().aZn.aBC) {
            AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(this.mContext.getPageActivity());
            alaLiveRoomActivityConfig.addExtraByLiveId(j, "", AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_SDK);
            alaLiveRoomActivityConfig.addExtraByParams(this.mOtherParams);
            AlaLastLiveroomInfo alaLastLiveroomInfo = new AlaLastLiveroomInfo();
            alaLastLiveroomInfo.setLastAnchorUid(this.aYY);
            alaLastLiveroomInfo.setLastAnchorUname(this.aDo);
            alaLastLiveroomInfo.setLastAnchorPortrait(this.aDp);
            alaLastLiveroomInfo.setLastLiveId(this.aZc);
            alaLastLiveroomInfo.setLastRoomId(this.mRoomId);
            alaLastLiveroomInfo.setFrom(AlaLastLiveroomInfo.TYPE_FROM_GUARD_RANK);
            alaLiveRoomActivityConfig.addLastLiveInfoParams(alaLastLiveroomInfo);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_LIVE_ROOM_START, alaLiveRoomActivityConfig));
            if (this.fQJ != null) {
                this.fQJ.L(null);
            }
        }
    }

    private void e(k kVar) {
        boolean z = this.fQK;
        if (z && !TextUtils.isEmpty(this.aYY) && !TextUtils.isEmpty(kVar.aEX) && !this.aYY.equals(kVar.aEX)) {
            z = false;
        }
        GuardClubInfoActivityConfig guardClubInfoActivityConfig = new GuardClubInfoActivityConfig(this.mContext.getPageActivity(), Long.valueOf(kVar.aEX).longValue(), 0L, z, this.mOtherParams, kVar.fQH);
        guardClubInfoActivityConfig.setRoomId(this.mRoomId);
        guardClubInfoActivityConfig.setFeedId(this.aNP);
        guardClubInfoActivityConfig.setIsClubMember(kVar.fQH);
        guardClubInfoActivityConfig.setHideRank(true);
        guardClubInfoActivityConfig.setIsTranslucent(true);
        guardClubInfoActivityConfig.setRequestCode(RequestResponseCode.REQUEST_GUARD_CLUB_INFO);
        guardClubInfoActivityConfig.setIntentAction(IntentAction.ActivityForResult);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, guardClubInfoActivityConfig));
    }
}
