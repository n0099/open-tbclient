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
import com.baidu.live.data.bf;
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
    private String aOD;
    private String aOE;
    private boolean aTh;
    private String bbt;
    private com.baidu.live.m.c bcR;
    private CustomMessageListener bek;
    private CustomMessageListener blw;
    private String bnP;
    private long bnV;
    private a gIf;
    private boolean gIg;
    private i gIh;
    private h gIi;
    private TbPageContext mContext;
    private String mOtherParams;
    private long mRoomId;

    /* loaded from: classes4.dex */
    public interface a {
        void N(Intent intent);

        void a(SupportXFragment... supportXFragmentArr);

        void aD(String str, int i);

        ViewGroup bTi();

        void uK(int i);

        void y(String str, long j);
    }

    public b(TbPageContext tbPageContext) {
        this.mContext = tbPageContext;
    }

    public void a(Intent intent, a aVar) {
        this.gIf = aVar;
        k(intent);
        JC();
        bTy();
        JG();
    }

    public void bTw() {
        if (this.bcR == null) {
            this.bcR = new com.baidu.live.m.c();
            this.bcR.initListener();
        }
        this.bcR.refreshCurUserScores();
    }

    public void aE(String str, int i) {
        if (i > TbadkCoreApplication.getInst().currentAccountTdouNum) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyTBeanActivityConfig(this.mContext.getPageActivity(), 0L, this.mOtherParams, true, "", true)));
            return;
        }
        if (this.gIh == null) {
            this.gIh = new i();
            this.gIh.a(new com.baidu.tieba.ala.guardclub.model.b() { // from class: com.baidu.tieba.ala.guardclub.rank.b.1
                @Override // com.baidu.tieba.ala.guardclub.model.b, com.baidu.tieba.ala.guardclub.model.m.a
                public void a(boolean z, String str2, long j, String str3, String str4) {
                    super.a(z, str2, j, str3, str4);
                    b.this.b(z, str2, j, str3, str4);
                }
            });
        }
        this.gIh.Hr(str);
    }

    public void release() {
        this.gIf = null;
        if (this.gIi != null) {
            this.gIi.onDestory();
        }
        if (this.gIh != null) {
            this.gIh.release();
        }
        if (this.bcR != null) {
            this.bcR.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.bek);
        MessageManager.getInstance().unRegisterListener(this.blw);
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.d.a
    public void mu(boolean z) {
        this.gIg = z;
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.d.a
    public void uK(int i) {
        if (this.gIf != null) {
            this.gIf.uK(i);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.d.a
    public void c(k kVar) {
        if (kVar.liveStatus == 1 && !TextUtils.isEmpty(kVar.liveId)) {
            if (this.gIg) {
                BdUtilHelper.showToast(this.mContext.getPageActivity(), "正在直播中，不能切换直播间哟！");
                return;
            } else if (String.valueOf(this.bnV).equals(kVar.liveId)) {
                if (this.gIf != null) {
                    this.gIf.N(new Intent().putExtra("guard_club_rank_back_to_room", true));
                    return;
                }
                return;
            } else {
                eH(Long.valueOf(kVar.liveId).longValue());
                return;
            }
        }
        e(kVar);
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.d.a
    public void d(k kVar) {
        int i = 1000;
        bf KH = g.KF().KH();
        if (KH != null && KH.aOV > 0) {
            i = KH.aOV;
        }
        if (this.gIf != null) {
            this.gIf.aD(kVar.id, i);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.d.a
    public void bTx() {
        if (this.gIf != null) {
            this.gIf.N(new Intent().putExtra("guard_club_rank_hit", true));
        }
    }

    private void k(Intent intent) {
        this.bnP = String.valueOf(intent.getLongExtra(GuardClubActivityConfig.ANCHOR_ID, 0L));
        this.bnV = intent.getLongExtra(GuardClubActivityConfig.LIVE_ID, 0L);
        this.aTh = intent.getBooleanExtra(GuardClubActivityConfig.IS_LIVE_OWNER, false);
        this.mOtherParams = intent.getStringExtra(IntentConfig.OTHER_PARAMS);
        this.mRoomId = intent.getLongExtra(GuardClubActivityConfig.ROOM_ID, 0L);
        this.bbt = intent.getStringExtra(GuardClubActivityConfig.FEED_ID);
        this.aOD = intent.getStringExtra(GuardClubActivityConfig.ANCHOR_NAME);
        this.aOE = intent.getStringExtra(GuardClubActivityConfig.ANCHOR_PORTRAIT);
    }

    private void JC() {
        this.bek = new CustomMessageListener(2913097) { // from class: com.baidu.tieba.ala.guardclub.rank.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (b.this.gIf != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    b.this.gIf.N(null);
                }
            }
        };
        MessageManager.getInstance().registerListener(this.bek);
    }

    private void bTy() {
        this.blw = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.guardclub.rank.b.3
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

    private void JG() {
        c cVar = new c(this.mContext.getPageActivity(), 2, this.bnP, this.aTh);
        cVar.a(this);
        c cVar2 = new c(this.mContext.getPageActivity(), 1, this.bnP, this.aTh);
        cVar2.a(this);
        if (this.gIf != null) {
            this.gIf.a(cVar, cVar2);
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
        if (this.gIf != null) {
            this.gIf.y(str, j);
            ViewGroup bTi = this.gIf.bTi();
            if (bTi != null && (currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo()) != null) {
                if (this.gIi == null) {
                    this.gIi = new h(this.mContext.getPageActivity());
                }
                this.gIi.setOtherParams(this.mOtherParams);
                int[] iArr = new int[2];
                bTi.getLocationOnScreen(iArr);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams.topMargin = iArr[1] * (-1);
                this.gIi.a(bTi, layoutParams, currentAccountInfo.getPortrait(), currentAccountInfo.getAccountNameShow());
            }
        }
        if (!TextUtils.isEmpty(str2)) {
            com.baidu.live.o.a.aD(str2, "guard_club_join");
        }
    }

    private void eH(long j) {
        if (!TbadkCoreApplication.getInst().isMobileBaidu() || com.baidu.live.aa.a.PQ().bod.aML) {
            AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(this.mContext.getPageActivity());
            alaLiveRoomActivityConfig.addExtraByLiveId(j, "", "live_sdk");
            alaLiveRoomActivityConfig.addExtraByParams(this.mOtherParams);
            AlaLastLiveroomInfo alaLastLiveroomInfo = new AlaLastLiveroomInfo();
            alaLastLiveroomInfo.setLastAnchorUid(this.bnP);
            alaLastLiveroomInfo.setLastAnchorUname(this.aOD);
            alaLastLiveroomInfo.setLastAnchorPortrait(this.aOE);
            alaLastLiveroomInfo.setLastLiveId(this.bnV);
            alaLastLiveroomInfo.setLastRoomId(this.mRoomId);
            alaLastLiveroomInfo.setFrom(AlaLastLiveroomInfo.TYPE_FROM_GUARD_RANK);
            alaLiveRoomActivityConfig.addLastLiveInfoParams(alaLastLiveroomInfo);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_LIVE_ROOM_START, alaLiveRoomActivityConfig));
            if (this.gIf != null) {
                this.gIf.N(null);
            }
        }
    }

    private void e(k kVar) {
        boolean z = this.aTh;
        if (z && !TextUtils.isEmpty(this.bnP) && !TextUtils.isEmpty(kVar.aQx) && !this.bnP.equals(kVar.aQx)) {
            z = false;
        }
        GuardClubInfoActivityConfig guardClubInfoActivityConfig = new GuardClubInfoActivityConfig(this.mContext.getPageActivity(), Long.valueOf(kVar.aQx).longValue(), 0L, z, this.mOtherParams, kVar.gId);
        guardClubInfoActivityConfig.setRoomId(this.mRoomId);
        guardClubInfoActivityConfig.setFeedId(this.bbt);
        guardClubInfoActivityConfig.setIsClubMember(kVar.gId);
        guardClubInfoActivityConfig.setHideRank(true);
        guardClubInfoActivityConfig.setIsTranslucent(true);
        guardClubInfoActivityConfig.setRequestCode(RequestResponseCode.REQUEST_GUARD_CLUB_INFO);
        guardClubInfoActivityConfig.setIntentAction(IntentAction.ActivityForResult);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, guardClubInfoActivityConfig));
    }
}
