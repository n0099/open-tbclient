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
import com.baidu.live.data.bi;
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
    private String aQG;
    private String aQH;
    private boolean aVQ;
    private String beS;
    private com.baidu.live.p.c bgO;
    private CustomMessageListener bih;
    private CustomMessageListener bql;
    private String bvS;
    private long bvY;
    private a hcI;
    private boolean hcJ;
    private i hcK;
    private com.baidu.tieba.ala.guardclub.i hcL;
    private TbPageContext mContext;
    private String mOtherParams;
    private long mRoomId;

    /* loaded from: classes11.dex */
    public interface a {
        void O(Intent intent);

        void a(SupportXFragment... supportXFragmentArr);

        void aF(String str, int i);

        ViewGroup bYR();

        void wa(int i);

        void y(String str, long j);
    }

    public b(TbPageContext tbPageContext) {
        this.mContext = tbPageContext;
    }

    public void a(Intent intent, a aVar) {
        this.hcI = aVar;
        k(intent);
        Ku();
        bZh();
        Ky();
    }

    public void bZf() {
        if (this.bgO == null) {
            this.bgO = new com.baidu.live.p.c();
            this.bgO.initListener();
        }
        this.bgO.refreshCurUserScores();
    }

    public void aG(String str, int i) {
        if (i > TbadkCoreApplication.getInst().currentAccountTdouNum) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyTBeanActivityConfig(this.mContext.getPageActivity(), 0L, this.mOtherParams, true, "", true)));
            return;
        }
        if (this.hcK == null) {
            this.hcK = new i();
            this.hcK.a(new com.baidu.tieba.ala.guardclub.model.b() { // from class: com.baidu.tieba.ala.guardclub.rank.b.1
                @Override // com.baidu.tieba.ala.guardclub.model.b, com.baidu.tieba.ala.guardclub.model.m.a
                public void a(boolean z, String str2, long j, String str3, String str4) {
                    super.a(z, str2, j, str3, str4);
                    b.this.b(z, str2, j, str3, str4);
                }
            });
        }
        this.hcK.HG(str);
    }

    public void release() {
        this.hcI = null;
        if (this.hcL != null) {
            this.hcL.onDestory();
        }
        if (this.hcK != null) {
            this.hcK.release();
        }
        if (this.bgO != null) {
            this.bgO.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.bih);
        MessageManager.getInstance().unRegisterListener(this.bql);
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.d.a
    public void nq(boolean z) {
        this.hcJ = z;
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.d.a
    public void wa(int i) {
        if (this.hcI != null) {
            this.hcI.wa(i);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.d.a
    public void c(k kVar) {
        if (kVar.liveStatus == 1 && !TextUtils.isEmpty(kVar.liveId)) {
            if (this.hcJ) {
                BdUtilHelper.showToast(this.mContext.getPageActivity(), "正在直播中，不能切换直播间哟！");
                return;
            } else if (String.valueOf(this.bvY).equals(kVar.liveId)) {
                if (this.hcI != null) {
                    this.hcI.O(new Intent().putExtra("guard_club_rank_back_to_room", true));
                    return;
                }
                return;
            } else {
                fl(Long.valueOf(kVar.liveId).longValue());
                return;
            }
        }
        e(kVar);
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.d.a
    public void d(k kVar) {
        int i = 1000;
        bi LA = g.Ly().LA();
        if (LA != null && LA.aQY > 0) {
            i = LA.aQY;
        }
        if (this.hcI != null) {
            this.hcI.aF(kVar.id, i);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.d.a
    public void bZg() {
        if (this.hcI != null) {
            this.hcI.O(new Intent().putExtra("guard_club_rank_hit", true));
        }
    }

    private void k(Intent intent) {
        this.bvS = String.valueOf(intent.getLongExtra(GuardClubActivityConfig.ANCHOR_ID, 0L));
        this.bvY = intent.getLongExtra(GuardClubActivityConfig.LIVE_ID, 0L);
        this.aVQ = intent.getBooleanExtra(GuardClubActivityConfig.IS_LIVE_OWNER, false);
        this.mOtherParams = intent.getStringExtra(IntentConfig.OTHER_PARAMS);
        this.mRoomId = intent.getLongExtra(GuardClubActivityConfig.ROOM_ID, 0L);
        this.beS = intent.getStringExtra(GuardClubActivityConfig.FEED_ID);
        this.aQG = intent.getStringExtra(GuardClubActivityConfig.ANCHOR_NAME);
        this.aQH = intent.getStringExtra(GuardClubActivityConfig.ANCHOR_PORTRAIT);
    }

    private void Ku() {
        this.bih = new CustomMessageListener(2913097) { // from class: com.baidu.tieba.ala.guardclub.rank.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (b.this.hcI != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    b.this.hcI.O(null);
                }
            }
        };
        MessageManager.getInstance().registerListener(this.bih);
    }

    private void bZh() {
        this.bql = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.guardclub.rank.b.3
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

    private void Ky() {
        c cVar = new c(this.mContext.getPageActivity(), 2, this.bvS, this.aVQ);
        cVar.a(this);
        c cVar2 = new c(this.mContext.getPageActivity(), 1, this.bvS, this.aVQ);
        cVar2.a(this);
        if (this.hcI != null) {
            this.hcI.a(cVar, cVar2);
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
        if (this.hcI != null) {
            this.hcI.y(str, j);
            ViewGroup bYR = this.hcI.bYR();
            if (bYR != null && (currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo()) != null) {
                if (this.hcL == null) {
                    this.hcL = new com.baidu.tieba.ala.guardclub.i(this.mContext.getPageActivity());
                }
                this.hcL.setOtherParams(this.mOtherParams);
                int[] iArr = new int[2];
                bYR.getLocationOnScreen(iArr);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams.topMargin = iArr[1] * (-1);
                this.hcL.a(bYR, layoutParams, currentAccountInfo.getPortrait(), currentAccountInfo.getAccountNameShow());
            }
        }
        if (!TextUtils.isEmpty(str2)) {
            com.baidu.live.r.a.aE(str2, "guard_club_join");
        }
    }

    private void fl(long j) {
        if (!TbadkCoreApplication.getInst().isMobileBaidu() || com.baidu.live.af.a.SE().bwi.aOz) {
            com.baidu.live.liveroom.a.OO().a(com.baidu.live.liveroom.a.OO().OP().hW(String.valueOf(j)));
            AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(this.mContext.getPageActivity());
            alaLiveRoomActivityConfig.addExtraByLiveId(j, "", "live_sdk");
            alaLiveRoomActivityConfig.addExtraByParams(this.mOtherParams);
            AlaLastLiveroomInfo alaLastLiveroomInfo = new AlaLastLiveroomInfo();
            alaLastLiveroomInfo.setLastAnchorUid(this.bvS);
            alaLastLiveroomInfo.setLastAnchorUname(this.aQG);
            alaLastLiveroomInfo.setLastAnchorPortrait(this.aQH);
            alaLastLiveroomInfo.setLastLiveId(this.bvY);
            alaLastLiveroomInfo.setLastRoomId(this.mRoomId);
            alaLastLiveroomInfo.setFrom(AlaLastLiveroomInfo.TYPE_FROM_GUARD_RANK);
            alaLiveRoomActivityConfig.addLastLiveInfoParams(alaLastLiveroomInfo);
            com.baidu.live.liveroom.a.OO().a(alaLiveRoomActivityConfig);
            if (this.hcI != null) {
                this.hcI.O(null);
            }
        }
    }

    private void e(k kVar) {
        boolean z = this.aVQ;
        if (z && !TextUtils.isEmpty(this.bvS) && !TextUtils.isEmpty(kVar.aLV) && !this.bvS.equals(kVar.aLV)) {
            z = false;
        }
        GuardClubInfoActivityConfig guardClubInfoActivityConfig = new GuardClubInfoActivityConfig(this.mContext.getPageActivity(), Long.valueOf(kVar.aLV).longValue(), 0L, z, this.mOtherParams, kVar.hcG);
        guardClubInfoActivityConfig.setRoomId(this.mRoomId);
        guardClubInfoActivityConfig.setFeedId(this.beS);
        guardClubInfoActivityConfig.setIsClubMember(kVar.hcG);
        guardClubInfoActivityConfig.setHideRank(true);
        guardClubInfoActivityConfig.setIsTranslucent(true);
        guardClubInfoActivityConfig.setRequestCode(RequestResponseCode.REQUEST_GUARD_CLUB_INFO);
        guardClubInfoActivityConfig.setIntentAction(IntentAction.ActivityForResult);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, guardClubInfoActivityConfig));
    }
}
