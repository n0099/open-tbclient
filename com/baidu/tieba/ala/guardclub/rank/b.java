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
/* loaded from: classes10.dex */
public class b implements d.a {
    private String aQq;
    private String aQr;
    private boolean aVI;
    private String beL;
    private com.baidu.live.o.c bgH;
    private CustomMessageListener bhY;
    private CustomMessageListener bqt;
    private String bwh;
    private long bwn;
    private a hcJ;
    private boolean hcK;
    private i hcL;
    private com.baidu.tieba.ala.guardclub.i hcM;
    private TbPageContext mContext;
    private String mOtherParams;
    private long mRoomId;

    /* loaded from: classes10.dex */
    public interface a {
        void O(Intent intent);

        void a(SupportXFragment... supportXFragmentArr);

        void aI(String str, int i);

        ViewGroup bVS();

        void uC(int i);

        void x(String str, long j);
    }

    public b(TbPageContext tbPageContext) {
        this.mContext = tbPageContext;
    }

    public void a(Intent intent, a aVar) {
        this.hcJ = aVar;
        k(intent);
        HS();
        bWi();
        HW();
    }

    public void bWg() {
        if (this.bgH == null) {
            this.bgH = new com.baidu.live.o.c();
            this.bgH.initListener();
        }
        this.bgH.refreshCurUserScores();
    }

    public void aJ(String str, int i) {
        if (i > TbadkCoreApplication.getInst().currentAccountTdouNum) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyTBeanActivityConfig(this.mContext.getPageActivity(), 0L, this.mOtherParams, true, "", true)));
            return;
        }
        if (this.hcL == null) {
            this.hcL = new i();
            this.hcL.a(new com.baidu.tieba.ala.guardclub.model.b() { // from class: com.baidu.tieba.ala.guardclub.rank.b.1
                @Override // com.baidu.tieba.ala.guardclub.model.b, com.baidu.tieba.ala.guardclub.model.m.a
                public void a(boolean z, String str2, long j, String str3, String str4) {
                    super.a(z, str2, j, str3, str4);
                    b.this.b(z, str2, j, str3, str4);
                }
            });
        }
        this.hcL.Hd(str);
    }

    public void release() {
        this.hcJ = null;
        if (this.hcM != null) {
            this.hcM.onDestory();
        }
        if (this.hcL != null) {
            this.hcL.release();
        }
        if (this.bgH != null) {
            this.bgH.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.bhY);
        MessageManager.getInstance().unRegisterListener(this.bqt);
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.d.a
    public void nr(boolean z) {
        this.hcK = z;
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.d.a
    public void uC(int i) {
        if (this.hcJ != null) {
            this.hcJ.uC(i);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.d.a
    public void c(k kVar) {
        if (kVar.liveStatus == 1 && !TextUtils.isEmpty(kVar.liveId)) {
            if (this.hcK) {
                BdUtilHelper.showToast(this.mContext.getPageActivity(), "正在直播中，不能切换直播间哟！");
                return;
            } else if (String.valueOf(this.bwn).equals(kVar.liveId)) {
                if (this.hcJ != null) {
                    this.hcJ.O(new Intent().putExtra("guard_club_rank_back_to_room", true));
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
        bn IY = g.IW().IY();
        if (IY != null && IY.aQJ > 0) {
            i = IY.aQJ;
        }
        if (this.hcJ != null) {
            this.hcJ.aI(kVar.id, i);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.d.a
    public void bWh() {
        if (this.hcJ != null) {
            this.hcJ.O(new Intent().putExtra("guard_club_rank_hit", true));
        }
    }

    private void k(Intent intent) {
        this.bwh = String.valueOf(intent.getLongExtra(GuardClubActivityConfig.ANCHOR_ID, 0L));
        this.bwn = intent.getLongExtra(GuardClubActivityConfig.LIVE_ID, 0L);
        this.aVI = intent.getBooleanExtra(GuardClubActivityConfig.IS_LIVE_OWNER, false);
        this.mOtherParams = intent.getStringExtra(IntentConfig.OTHER_PARAMS);
        this.mRoomId = intent.getLongExtra(GuardClubActivityConfig.ROOM_ID, 0L);
        this.beL = intent.getStringExtra(GuardClubActivityConfig.FEED_ID);
        this.aQq = intent.getStringExtra(GuardClubActivityConfig.ANCHOR_NAME);
        this.aQr = intent.getStringExtra(GuardClubActivityConfig.ANCHOR_PORTRAIT);
    }

    private void HS() {
        this.bhY = new CustomMessageListener(2913097) { // from class: com.baidu.tieba.ala.guardclub.rank.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (b.this.hcJ != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    b.this.hcJ.O(null);
                }
            }
        };
        MessageManager.getInstance().registerListener(this.bhY);
    }

    private void bWi() {
        this.bqt = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.guardclub.rank.b.3
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

    private void HW() {
        c cVar = new c(this.mContext.getPageActivity(), 2, this.bwh, this.aVI);
        cVar.a(this);
        c cVar2 = new c(this.mContext.getPageActivity(), 1, this.bwh, this.aVI);
        cVar2.a(this);
        if (this.hcJ != null) {
            this.hcJ.a(cVar, cVar2);
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
        if (this.hcJ != null) {
            this.hcJ.x(str, j);
            ViewGroup bVS = this.hcJ.bVS();
            if (bVS != null && (currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo()) != null) {
                if (this.hcM == null) {
                    this.hcM = new com.baidu.tieba.ala.guardclub.i(this.mContext.getPageActivity());
                }
                this.hcM.setOtherParams(this.mOtherParams);
                int[] iArr = new int[2];
                bVS.getLocationOnScreen(iArr);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams.topMargin = iArr[1] * (-1);
                this.hcM.a(bVS, layoutParams, currentAccountInfo.getPortrait(), currentAccountInfo.getAccountNameShow());
            }
        }
        if (!TextUtils.isEmpty(str2)) {
            com.baidu.live.q.a.aD(str2, "guard_club_join");
        }
    }

    private void fr(long j) {
        if (!TbadkCoreApplication.getInst().isMobileBaidu() || com.baidu.live.ae.a.Qm().bwx.aNW) {
            com.baidu.live.liveroom.a.Mu().a(com.baidu.live.liveroom.a.Mu().Mv().hq(String.valueOf(j)));
            AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(this.mContext.getPageActivity());
            alaLiveRoomActivityConfig.addExtraByLiveId(j, "", "live_sdk");
            alaLiveRoomActivityConfig.addExtraByParams(this.mOtherParams);
            AlaLastLiveroomInfo alaLastLiveroomInfo = new AlaLastLiveroomInfo();
            alaLastLiveroomInfo.setLastAnchorUid(this.bwh);
            alaLastLiveroomInfo.setLastAnchorUname(this.aQq);
            alaLastLiveroomInfo.setLastAnchorPortrait(this.aQr);
            alaLastLiveroomInfo.setLastLiveId(this.bwn);
            alaLastLiveroomInfo.setLastRoomId(this.mRoomId);
            alaLastLiveroomInfo.setFrom(AlaLastLiveroomInfo.TYPE_FROM_GUARD_RANK);
            alaLiveRoomActivityConfig.addLastLiveInfoParams(alaLastLiveroomInfo);
            com.baidu.live.liveroom.a.Mu().a(alaLiveRoomActivityConfig);
            if (this.hcJ != null) {
                this.hcJ.O(null);
            }
        }
    }

    private void e(k kVar) {
        boolean z = this.aVI;
        if (z && !TextUtils.isEmpty(this.bwh) && !TextUtils.isEmpty(kVar.aLm) && !this.bwh.equals(kVar.aLm)) {
            z = false;
        }
        GuardClubInfoActivityConfig guardClubInfoActivityConfig = new GuardClubInfoActivityConfig(this.mContext.getPageActivity(), Long.valueOf(kVar.aLm).longValue(), 0L, z, this.mOtherParams, kVar.hcH);
        guardClubInfoActivityConfig.setRoomId(this.mRoomId);
        guardClubInfoActivityConfig.setFeedId(this.beL);
        guardClubInfoActivityConfig.setIsClubMember(kVar.hcH);
        guardClubInfoActivityConfig.setHideRank(true);
        guardClubInfoActivityConfig.setIsTranslucent(true);
        guardClubInfoActivityConfig.setRequestCode(RequestResponseCode.REQUEST_GUARD_CLUB_INFO);
        guardClubInfoActivityConfig.setIntentAction(IntentAction.ActivityForResult);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, guardClubInfoActivityConfig));
    }
}
