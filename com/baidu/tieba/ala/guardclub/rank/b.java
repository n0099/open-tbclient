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
import com.baidu.live.data.bg;
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
/* loaded from: classes4.dex */
public class b implements d.a {
    private String aPR;
    private String aPS;
    private boolean aUy;
    private String bdh;
    private com.baidu.live.o.c bff;
    private CustomMessageListener bgy;
    private CustomMessageListener boC;
    private String brl;
    private long brr;
    private a gQV;
    private boolean gQW;
    private i gQX;
    private com.baidu.tieba.ala.guardclub.i gQY;
    private TbPageContext mContext;
    private String mOtherParams;
    private long mRoomId;

    /* loaded from: classes4.dex */
    public interface a {
        void N(Intent intent);

        void a(SupportXFragment... supportXFragmentArr);

        void aD(String str, int i);

        ViewGroup bWm();

        void vP(int i);

        void y(String str, long j);
    }

    public b(TbPageContext tbPageContext) {
        this.mContext = tbPageContext;
    }

    public void a(Intent intent, a aVar) {
        this.gQV = aVar;
        k(intent);
        KU();
        bWC();
        KY();
    }

    public void bWA() {
        if (this.bff == null) {
            this.bff = new com.baidu.live.o.c();
            this.bff.initListener();
        }
        this.bff.refreshCurUserScores();
    }

    public void aE(String str, int i) {
        if (i > TbadkCoreApplication.getInst().currentAccountTdouNum) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyTBeanActivityConfig(this.mContext.getPageActivity(), 0L, this.mOtherParams, true, "", true)));
            return;
        }
        if (this.gQX == null) {
            this.gQX = new i();
            this.gQX.a(new com.baidu.tieba.ala.guardclub.model.b() { // from class: com.baidu.tieba.ala.guardclub.rank.b.1
                @Override // com.baidu.tieba.ala.guardclub.model.b, com.baidu.tieba.ala.guardclub.model.m.a
                public void a(boolean z, String str2, long j, String str3, String str4) {
                    super.a(z, str2, j, str3, str4);
                    b.this.b(z, str2, j, str3, str4);
                }
            });
        }
        this.gQX.HG(str);
    }

    public void release() {
        this.gQV = null;
        if (this.gQY != null) {
            this.gQY.onDestory();
        }
        if (this.gQX != null) {
            this.gQX.release();
        }
        if (this.bff != null) {
            this.bff.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.bgy);
        MessageManager.getInstance().unRegisterListener(this.boC);
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.d.a
    public void mQ(boolean z) {
        this.gQW = z;
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.d.a
    public void vP(int i) {
        if (this.gQV != null) {
            this.gQV.vP(i);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.d.a
    public void c(k kVar) {
        if (kVar.liveStatus == 1 && !TextUtils.isEmpty(kVar.liveId)) {
            if (this.gQW) {
                BdUtilHelper.showToast(this.mContext.getPageActivity(), "正在直播中，不能切换直播间哟！");
                return;
            } else if (String.valueOf(this.brr).equals(kVar.liveId)) {
                if (this.gQV != null) {
                    this.gQV.N(new Intent().putExtra("guard_club_rank_back_to_room", true));
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
        bg Mb = g.LZ().Mb();
        if (Mb != null && Mb.aQj > 0) {
            i = Mb.aQj;
        }
        if (this.gQV != null) {
            this.gQV.aD(kVar.id, i);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.d.a
    public void bWB() {
        if (this.gQV != null) {
            this.gQV.N(new Intent().putExtra("guard_club_rank_hit", true));
        }
    }

    private void k(Intent intent) {
        this.brl = String.valueOf(intent.getLongExtra(GuardClubActivityConfig.ANCHOR_ID, 0L));
        this.brr = intent.getLongExtra(GuardClubActivityConfig.LIVE_ID, 0L);
        this.aUy = intent.getBooleanExtra(GuardClubActivityConfig.IS_LIVE_OWNER, false);
        this.mOtherParams = intent.getStringExtra(IntentConfig.OTHER_PARAMS);
        this.mRoomId = intent.getLongExtra(GuardClubActivityConfig.ROOM_ID, 0L);
        this.bdh = intent.getStringExtra(GuardClubActivityConfig.FEED_ID);
        this.aPR = intent.getStringExtra(GuardClubActivityConfig.ANCHOR_NAME);
        this.aPS = intent.getStringExtra(GuardClubActivityConfig.ANCHOR_PORTRAIT);
    }

    private void KU() {
        this.bgy = new CustomMessageListener(2913097) { // from class: com.baidu.tieba.ala.guardclub.rank.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (b.this.gQV != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    b.this.gQV.N(null);
                }
            }
        };
        MessageManager.getInstance().registerListener(this.bgy);
    }

    private void bWC() {
        this.boC = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.guardclub.rank.b.3
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

    private void KY() {
        c cVar = new c(this.mContext.getPageActivity(), 2, this.brl, this.aUy);
        cVar.a(this);
        c cVar2 = new c(this.mContext.getPageActivity(), 1, this.brl, this.aUy);
        cVar2.a(this);
        if (this.gQV != null) {
            this.gQV.a(cVar, cVar2);
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
        if (this.gQV != null) {
            this.gQV.y(str, j);
            ViewGroup bWm = this.gQV.bWm();
            if (bWm != null && (currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo()) != null) {
                if (this.gQY == null) {
                    this.gQY = new com.baidu.tieba.ala.guardclub.i(this.mContext.getPageActivity());
                }
                this.gQY.setOtherParams(this.mOtherParams);
                int[] iArr = new int[2];
                bWm.getLocationOnScreen(iArr);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams.topMargin = iArr[1] * (-1);
                this.gQY.a(bWm, layoutParams, currentAccountInfo.getPortrait(), currentAccountInfo.getAccountNameShow());
            }
        }
        if (!TextUtils.isEmpty(str2)) {
            com.baidu.live.q.a.aG(str2, "guard_club_join");
        }
    }

    private void fl(long j) {
        if (!TbadkCoreApplication.getInst().isMobileBaidu() || com.baidu.live.ae.a.RB().brA.aNV) {
            AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(this.mContext.getPageActivity());
            alaLiveRoomActivityConfig.addExtraByLiveId(j, "", "live_sdk");
            alaLiveRoomActivityConfig.addExtraByParams(this.mOtherParams);
            AlaLastLiveroomInfo alaLastLiveroomInfo = new AlaLastLiveroomInfo();
            alaLastLiveroomInfo.setLastAnchorUid(this.brl);
            alaLastLiveroomInfo.setLastAnchorUname(this.aPR);
            alaLastLiveroomInfo.setLastAnchorPortrait(this.aPS);
            alaLastLiveroomInfo.setLastLiveId(this.brr);
            alaLastLiveroomInfo.setLastRoomId(this.mRoomId);
            alaLastLiveroomInfo.setFrom(AlaLastLiveroomInfo.TYPE_FROM_GUARD_RANK);
            alaLiveRoomActivityConfig.addLastLiveInfoParams(alaLastLiveroomInfo);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_LIVE_ROOM_START, alaLiveRoomActivityConfig));
            if (this.gQV != null) {
                this.gQV.N(null);
            }
        }
    }

    private void e(k kVar) {
        boolean z = this.aUy;
        if (z && !TextUtils.isEmpty(this.brl) && !TextUtils.isEmpty(kVar.aRO) && !this.brl.equals(kVar.aRO)) {
            z = false;
        }
        GuardClubInfoActivityConfig guardClubInfoActivityConfig = new GuardClubInfoActivityConfig(this.mContext.getPageActivity(), Long.valueOf(kVar.aRO).longValue(), 0L, z, this.mOtherParams, kVar.gQT);
        guardClubInfoActivityConfig.setRoomId(this.mRoomId);
        guardClubInfoActivityConfig.setFeedId(this.bdh);
        guardClubInfoActivityConfig.setIsClubMember(kVar.gQT);
        guardClubInfoActivityConfig.setHideRank(true);
        guardClubInfoActivityConfig.setIsTranslucent(true);
        guardClubInfoActivityConfig.setRequestCode(RequestResponseCode.REQUEST_GUARD_CLUB_INFO);
        guardClubInfoActivityConfig.setIntentAction(IntentAction.ActivityForResult);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, guardClubInfoActivityConfig));
    }
}
