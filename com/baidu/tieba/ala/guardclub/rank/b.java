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
import com.baidu.live.data.ba;
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
    private String aJQ;
    private String aJR;
    private boolean aVq;
    private String aVs;
    private com.baidu.live.l.c aWS;
    private CustomMessageListener aYi;
    private CustomMessageListener beU;
    private String bhk;
    private long bhr;
    private a gfY;
    private boolean gfZ;
    private i gga;
    private h ggb;
    private TbPageContext mContext;
    private String mOtherParams;
    private long mRoomId;

    /* loaded from: classes4.dex */
    public interface a {
        void N(Intent intent);

        void a(SupportXFragment... supportXFragmentArr);

        void az(String str, int i);

        ViewGroup bLu();

        void tK(int i);

        void v(String str, long j);
    }

    public b(TbPageContext tbPageContext) {
        this.mContext = tbPageContext;
    }

    public void a(Intent intent, a aVar) {
        this.gfY = aVar;
        k(intent);
        HL();
        bLK();
        HP();
    }

    public void bLI() {
        if (this.aWS == null) {
            this.aWS = new com.baidu.live.l.c();
            this.aWS.initListener();
        }
        this.aWS.refreshCurUserScores();
    }

    public void aA(String str, int i) {
        if (i > TbadkCoreApplication.getInst().currentAccountTdouNum) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyTBeanActivityConfig(this.mContext.getPageActivity(), 0L, this.mOtherParams, true, "", true)));
            return;
        }
        if (this.gga == null) {
            this.gga = new i();
            this.gga.a(new com.baidu.tieba.ala.guardclub.model.b() { // from class: com.baidu.tieba.ala.guardclub.rank.b.1
                @Override // com.baidu.tieba.ala.guardclub.model.b, com.baidu.tieba.ala.guardclub.model.m.a
                public void a(boolean z, String str2, long j, String str3, String str4) {
                    super.a(z, str2, j, str3, str4);
                    b.this.b(z, str2, j, str3, str4);
                }
            });
        }
        this.gga.FV(str);
    }

    public void release() {
        this.gfY = null;
        if (this.ggb != null) {
            this.ggb.onDestory();
        }
        if (this.gga != null) {
            this.gga.release();
        }
        if (this.aWS != null) {
            this.aWS.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.aYi);
        MessageManager.getInstance().unRegisterListener(this.beU);
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.d.a
    public void lx(boolean z) {
        this.gfZ = z;
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.d.a
    public void tK(int i) {
        if (this.gfY != null) {
            this.gfY.tK(i);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.d.a
    public void c(k kVar) {
        if (kVar.liveStatus == 1 && !TextUtils.isEmpty(kVar.liveId)) {
            if (this.gfZ) {
                BdUtilHelper.showToast(this.mContext.getPageActivity(), "正在直播中，不能切换直播间哟！");
                return;
            } else if (String.valueOf(this.bhr).equals(kVar.liveId)) {
                if (this.gfY != null) {
                    this.gfY.N(new Intent().putExtra("guard_club_rank_back_to_room", true));
                    return;
                }
                return;
            } else {
                eb(Long.valueOf(kVar.liveId).longValue());
                return;
            }
        }
        e(kVar);
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.d.a
    public void d(k kVar) {
        int i = 1000;
        ba IR = g.IP().IR();
        if (IR != null && IR.aKi > 0) {
            i = IR.aKi;
        }
        if (this.gfY != null) {
            this.gfY.az(kVar.id, i);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.d.a
    public void bLJ() {
        if (this.gfY != null) {
            this.gfY.N(new Intent().putExtra("guard_club_rank_hit", true));
        }
    }

    private void k(Intent intent) {
        this.bhk = String.valueOf(intent.getLongExtra(GuardClubActivityConfig.ANCHOR_ID, 0L));
        this.bhr = intent.getLongExtra(GuardClubActivityConfig.LIVE_ID, 0L);
        this.aVq = intent.getBooleanExtra(GuardClubActivityConfig.IS_LIVE_OWNER, false);
        this.mOtherParams = intent.getStringExtra(IntentConfig.OTHER_PARAMS);
        this.mRoomId = intent.getLongExtra(GuardClubActivityConfig.ROOM_ID, 0L);
        this.aVs = intent.getStringExtra(GuardClubActivityConfig.FEED_ID);
        this.aJQ = intent.getStringExtra(GuardClubActivityConfig.ANCHOR_NAME);
        this.aJR = intent.getStringExtra(GuardClubActivityConfig.ANCHOR_PORTRAIT);
    }

    private void HL() {
        this.aYi = new CustomMessageListener(2913097) { // from class: com.baidu.tieba.ala.guardclub.rank.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (b.this.gfY != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    b.this.gfY.N(null);
                }
            }
        };
        MessageManager.getInstance().registerListener(this.aYi);
    }

    private void bLK() {
        this.beU = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.guardclub.rank.b.3
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

    private void HP() {
        c cVar = new c(this.mContext.getPageActivity(), 2, this.bhk, this.aVq);
        cVar.a(this);
        c cVar2 = new c(this.mContext.getPageActivity(), 1, this.bhk, this.aVq);
        cVar2.a(this);
        if (this.gfY != null) {
            this.gfY.a(cVar, cVar2);
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
        if (this.gfY != null) {
            this.gfY.v(str, j);
            ViewGroup bLu = this.gfY.bLu();
            if (bLu != null && (currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo()) != null) {
                if (this.ggb == null) {
                    this.ggb = new h(this.mContext.getPageActivity());
                }
                this.ggb.setOtherParams(this.mOtherParams);
                int[] iArr = new int[2];
                bLu.getLocationOnScreen(iArr);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams.topMargin = iArr[1] * (-1);
                this.ggb.a(bLu, layoutParams, currentAccountInfo.getPortrait(), currentAccountInfo.getAccountNameShow());
            }
        }
        if (!TextUtils.isEmpty(str2)) {
            com.baidu.live.n.a.ay(str2, "guard_club_join");
        }
    }

    private void eb(long j) {
        if (!TbadkCoreApplication.getInst().isMobileBaidu() || com.baidu.live.x.a.NN().bhy.aId) {
            AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(this.mContext.getPageActivity());
            alaLiveRoomActivityConfig.addExtraByLiveId(j, "", "live_sdk");
            alaLiveRoomActivityConfig.addExtraByParams(this.mOtherParams);
            AlaLastLiveroomInfo alaLastLiveroomInfo = new AlaLastLiveroomInfo();
            alaLastLiveroomInfo.setLastAnchorUid(this.bhk);
            alaLastLiveroomInfo.setLastAnchorUname(this.aJQ);
            alaLastLiveroomInfo.setLastAnchorPortrait(this.aJR);
            alaLastLiveroomInfo.setLastLiveId(this.bhr);
            alaLastLiveroomInfo.setLastRoomId(this.mRoomId);
            alaLastLiveroomInfo.setFrom(AlaLastLiveroomInfo.TYPE_FROM_GUARD_RANK);
            alaLiveRoomActivityConfig.addLastLiveInfoParams(alaLastLiveroomInfo);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_LIVE_ROOM_START, alaLiveRoomActivityConfig));
            if (this.gfY != null) {
                this.gfY.N(null);
            }
        }
    }

    private void e(k kVar) {
        boolean z = this.aVq;
        if (z && !TextUtils.isEmpty(this.bhk) && !TextUtils.isEmpty(kVar.aLM) && !this.bhk.equals(kVar.aLM)) {
            z = false;
        }
        GuardClubInfoActivityConfig guardClubInfoActivityConfig = new GuardClubInfoActivityConfig(this.mContext.getPageActivity(), Long.valueOf(kVar.aLM).longValue(), 0L, z, this.mOtherParams, kVar.gfW);
        guardClubInfoActivityConfig.setRoomId(this.mRoomId);
        guardClubInfoActivityConfig.setFeedId(this.aVs);
        guardClubInfoActivityConfig.setIsClubMember(kVar.gfW);
        guardClubInfoActivityConfig.setHideRank(true);
        guardClubInfoActivityConfig.setIsTranslucent(true);
        guardClubInfoActivityConfig.setRequestCode(RequestResponseCode.REQUEST_GUARD_CLUB_INFO);
        guardClubInfoActivityConfig.setIntentAction(IntentAction.ActivityForResult);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, guardClubInfoActivityConfig));
    }
}
