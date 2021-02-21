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
import com.baidu.live.data.bn;
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
import com.baidu.tieba.ala.guardclub.model.i;
import com.baidu.tieba.ala.guardclub.model.k;
import com.baidu.tieba.ala.guardclub.rank.d;
/* loaded from: classes11.dex */
public class b implements d.a {
    private String aOQ;
    private String aOR;
    private boolean aUi;
    private String bdj;
    private com.baidu.live.o.c bff;
    private CustomMessageListener bgy;
    private CustomMessageListener boT;
    private String buH;
    private long buN;
    private a hba;
    private boolean hbb;
    private i hbc;
    private com.baidu.tieba.ala.guardclub.i hbd;
    private TbPageContext mContext;
    private String mOtherParams;
    private long mRoomId;

    /* loaded from: classes11.dex */
    public interface a {
        void O(Intent intent);

        void a(SupportXFragment... supportXFragmentArr);

        void aH(String str, int i);

        ViewGroup bVM();

        void uA(int i);

        void x(String str, long j);
    }

    public b(TbPageContext tbPageContext) {
        this.mContext = tbPageContext;
    }

    public void a(Intent intent, a aVar) {
        this.hba = aVar;
        k(intent);
        HP();
        bWc();
        HT();
    }

    public void bWa() {
        if (this.bff == null) {
            this.bff = new com.baidu.live.o.c();
            this.bff.initListener();
        }
        this.bff.refreshCurUserScores();
    }

    public void aI(String str, int i) {
        if (i > TbadkCoreApplication.getInst().currentAccountTdouNum) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyTBeanActivityConfig(this.mContext.getPageActivity(), 0L, this.mOtherParams, true, "", true)));
            return;
        }
        if (this.hbc == null) {
            this.hbc = new i();
            this.hbc.a(new com.baidu.tieba.ala.guardclub.model.b() { // from class: com.baidu.tieba.ala.guardclub.rank.b.1
                @Override // com.baidu.tieba.ala.guardclub.model.b, com.baidu.tieba.ala.guardclub.model.m.a
                public void a(boolean z, String str2, long j, String str3, String str4) {
                    super.a(z, str2, j, str3, str4);
                    b.this.b(z, str2, j, str3, str4);
                }
            });
        }
        this.hbc.GU(str);
    }

    public void release() {
        this.hba = null;
        if (this.hbd != null) {
            this.hbd.onDestory();
        }
        if (this.hbc != null) {
            this.hbc.release();
        }
        if (this.bff != null) {
            this.bff.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.bgy);
        MessageManager.getInstance().unRegisterListener(this.boT);
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.d.a
    public void nr(boolean z) {
        this.hbb = z;
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.d.a
    public void uA(int i) {
        if (this.hba != null) {
            this.hba.uA(i);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.d.a
    public void c(k kVar) {
        if (kVar.liveStatus == 1 && !TextUtils.isEmpty(kVar.liveId)) {
            if (this.hbb) {
                BdUtilHelper.showToast(this.mContext.getPageActivity(), "正在直播中，不能切换直播间哟！");
                return;
            } else if (String.valueOf(this.buN).equals(kVar.liveId)) {
                if (this.hba != null) {
                    this.hba.O(new Intent().putExtra("guard_club_rank_back_to_room", true));
                    return;
                }
                return;
            } else {
                fr(Long.valueOf(kVar.liveId).longValue());
                return;
            }
        }
        e(kVar);
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.d.a
    public void d(k kVar) {
        int i = 1000;
        bn IV = g.IT().IV();
        if (IV != null && IV.aPj > 0) {
            i = IV.aPj;
        }
        if (this.hba != null) {
            this.hba.aH(kVar.id, i);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.d.a
    public void bWb() {
        if (this.hba != null) {
            this.hba.O(new Intent().putExtra("guard_club_rank_hit", true));
        }
    }

    private void k(Intent intent) {
        this.buH = String.valueOf(intent.getLongExtra(GuardClubActivityConfig.ANCHOR_ID, 0L));
        this.buN = intent.getLongExtra(GuardClubActivityConfig.LIVE_ID, 0L);
        this.aUi = intent.getBooleanExtra(GuardClubActivityConfig.IS_LIVE_OWNER, false);
        this.mOtherParams = intent.getStringExtra(IntentConfig.OTHER_PARAMS);
        this.mRoomId = intent.getLongExtra(GuardClubActivityConfig.ROOM_ID, 0L);
        this.bdj = intent.getStringExtra(GuardClubActivityConfig.FEED_ID);
        this.aOQ = intent.getStringExtra(GuardClubActivityConfig.ANCHOR_NAME);
        this.aOR = intent.getStringExtra(GuardClubActivityConfig.ANCHOR_PORTRAIT);
    }

    private void HP() {
        this.bgy = new CustomMessageListener(2913097) { // from class: com.baidu.tieba.ala.guardclub.rank.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (b.this.hba != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    b.this.hba.O(null);
                }
            }
        };
        MessageManager.getInstance().registerListener(this.bgy);
    }

    private void bWc() {
        this.boT = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.guardclub.rank.b.3
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

    private void HT() {
        c cVar = new c(this.mContext.getPageActivity(), 2, this.buH, this.aUi);
        cVar.a(this);
        c cVar2 = new c(this.mContext.getPageActivity(), 1, this.buH, this.aUi);
        cVar2.a(this);
        if (this.hba != null) {
            this.hba.a(cVar, cVar2);
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
        if (this.hba != null) {
            this.hba.x(str, j);
            ViewGroup bVM = this.hba.bVM();
            if (bVM != null && (currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo()) != null) {
                if (this.hbd == null) {
                    this.hbd = new com.baidu.tieba.ala.guardclub.i(this.mContext.getPageActivity());
                }
                this.hbd.setOtherParams(this.mOtherParams);
                int[] iArr = new int[2];
                bVM.getLocationOnScreen(iArr);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams.topMargin = iArr[1] * (-1);
                this.hbd.a(bVM, layoutParams, currentAccountInfo.getPortrait(), currentAccountInfo.getAccountNameShow());
            }
        }
        if (!TextUtils.isEmpty(str2)) {
            com.baidu.live.q.a.aD(str2, "guard_club_join");
        }
    }

    private void fr(long j) {
        if (!TbadkCoreApplication.getInst().isMobileBaidu() || com.baidu.live.ae.a.Qj().buX.aMw) {
            com.baidu.live.liveroom.a.Mr().a(com.baidu.live.liveroom.a.Mr().Ms().hk(String.valueOf(j)));
            AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(this.mContext.getPageActivity());
            alaLiveRoomActivityConfig.addExtraByLiveId(j, "", "live_sdk");
            alaLiveRoomActivityConfig.addExtraByParams(this.mOtherParams);
            AlaLastLiveroomInfo alaLastLiveroomInfo = new AlaLastLiveroomInfo();
            alaLastLiveroomInfo.setLastAnchorUid(this.buH);
            alaLastLiveroomInfo.setLastAnchorUname(this.aOQ);
            alaLastLiveroomInfo.setLastAnchorPortrait(this.aOR);
            alaLastLiveroomInfo.setLastLiveId(this.buN);
            alaLastLiveroomInfo.setLastRoomId(this.mRoomId);
            alaLastLiveroomInfo.setFrom(AlaLastLiveroomInfo.TYPE_FROM_GUARD_RANK);
            alaLiveRoomActivityConfig.addLastLiveInfoParams(alaLastLiveroomInfo);
            com.baidu.live.liveroom.a.Mr().a(alaLiveRoomActivityConfig);
            if (this.hba != null) {
                this.hba.O(null);
            }
        }
    }

    private void e(k kVar) {
        boolean z = this.aUi;
        if (z && !TextUtils.isEmpty(this.buH) && !TextUtils.isEmpty(kVar.aJM) && !this.buH.equals(kVar.aJM)) {
            z = false;
        }
        GuardClubInfoActivityConfig guardClubInfoActivityConfig = new GuardClubInfoActivityConfig(this.mContext.getPageActivity(), Long.valueOf(kVar.aJM).longValue(), 0L, z, this.mOtherParams, kVar.haY);
        guardClubInfoActivityConfig.setRoomId(this.mRoomId);
        guardClubInfoActivityConfig.setFeedId(this.bdj);
        guardClubInfoActivityConfig.setIsClubMember(kVar.haY);
        guardClubInfoActivityConfig.setHideRank(true);
        guardClubInfoActivityConfig.setIsTranslucent(true);
        guardClubInfoActivityConfig.setRequestCode(RequestResponseCode.REQUEST_GUARD_CLUB_INFO);
        guardClubInfoActivityConfig.setIntentAction(IntentAction.ActivityForResult);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, guardClubInfoActivityConfig));
    }
}
