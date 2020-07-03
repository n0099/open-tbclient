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
import com.baidu.live.data.as;
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
/* loaded from: classes3.dex */
public class b implements d.a {
    private String aBT;
    private String aBU;
    private String aMu;
    private com.baidu.live.l.c aNS;
    private CustomMessageListener aPg;
    private CustomMessageListener aVB;
    private String aZa;
    private long aZe;
    private a fLp;
    private boolean fLq;
    private boolean fLr;
    private i fLs;
    private h fLt;
    private TbPageContext mContext;
    private String mOtherParams;
    private long mRoomId;

    /* loaded from: classes3.dex */
    public interface a {
        void K(Intent intent);

        void a(SupportXFragment... supportXFragmentArr);

        void ax(String str, int i);

        ViewGroup bxx();

        void qP(int i);

        void w(String str, long j);
    }

    public b(TbPageContext tbPageContext) {
        this.mContext = tbPageContext;
    }

    public void a(Intent intent, a aVar) {
        this.fLp = aVar;
        k(intent);
        Bf();
        bxP();
        Bj();
    }

    public void bxN() {
        if (this.aNS == null) {
            this.aNS = new com.baidu.live.l.c();
            this.aNS.initListener();
        }
        this.aNS.refreshCurUserScores();
    }

    public void ay(String str, int i) {
        if (i > TbadkCoreApplication.getInst().currentAccountTdouNum) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyTBeanActivityConfig(this.mContext.getPageActivity(), 0L, this.mOtherParams, true, "", true)));
            return;
        }
        if (this.fLs == null) {
            this.fLs = new i();
            this.fLs.a(new com.baidu.tieba.ala.guardclub.model.b() { // from class: com.baidu.tieba.ala.guardclub.rank.b.1
                @Override // com.baidu.tieba.ala.guardclub.model.b, com.baidu.tieba.ala.guardclub.model.m.a
                public void a(boolean z, String str2, long j, String str3, String str4) {
                    super.a(z, str2, j, str3, str4);
                    b.this.b(z, str2, j, str3, str4);
                }
            });
        }
        this.fLs.Cq(str);
    }

    public void release() {
        this.fLp = null;
        if (this.fLt != null) {
            this.fLt.onDestory();
        }
        if (this.fLs != null) {
            this.fLs.release();
        }
        if (this.aNS != null) {
            this.aNS.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.aPg);
        MessageManager.getInstance().unRegisterListener(this.aVB);
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.d.a
    public void kp(boolean z) {
        this.fLr = z;
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.d.a
    public void qP(int i) {
        if (this.fLp != null) {
            this.fLp.qP(i);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.d.a
    public void c(k kVar) {
        if (kVar.liveStatus == 1 && !TextUtils.isEmpty(kVar.liveId)) {
            if (this.fLr) {
                BdUtilHelper.showToast(this.mContext.getPageActivity(), "正在直播中，不能切换直播间哟！");
                return;
            } else if (String.valueOf(this.aZe).equals(kVar.liveId)) {
                if (this.fLp != null) {
                    this.fLp.K(new Intent().putExtra("guard_club_rank_back_to_room", true));
                    return;
                }
                return;
            } else {
                dA(Long.valueOf(kVar.liveId).longValue());
                return;
            }
        }
        e(kVar);
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.d.a
    public void d(k kVar) {
        int i = 1000;
        as Cj = g.Ch().Cj();
        if (Cj != null && Cj.aCl > 0) {
            i = Cj.aCl;
        }
        if (this.fLp != null) {
            this.fLp.ax(kVar.id, i);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.d.a
    public void bxO() {
        if (this.fLp != null) {
            this.fLp.K(new Intent().putExtra("guard_club_rank_hit", true));
        }
    }

    private void k(Intent intent) {
        this.aZa = String.valueOf(intent.getLongExtra(GuardClubActivityConfig.ANCHOR_ID, 0L));
        this.aZe = intent.getLongExtra(GuardClubActivityConfig.LIVE_ID, 0L);
        this.fLq = intent.getBooleanExtra(GuardClubActivityConfig.IS_LIVE_OWNER, false);
        this.mOtherParams = intent.getStringExtra(IntentConfig.OTHER_PARAMS);
        this.mRoomId = intent.getLongExtra(GuardClubActivityConfig.ROOM_ID, 0L);
        this.aMu = intent.getStringExtra(GuardClubActivityConfig.FEED_ID);
        this.aBT = intent.getStringExtra(GuardClubActivityConfig.ANCHOR_NAME);
        this.aBU = intent.getStringExtra(GuardClubActivityConfig.ANCHOR_PORTRAIT);
    }

    private void Bf() {
        this.aPg = new CustomMessageListener(2913097) { // from class: com.baidu.tieba.ala.guardclub.rank.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (b.this.fLp != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    b.this.fLp.K(null);
                }
            }
        };
        MessageManager.getInstance().registerListener(this.aPg);
    }

    private void bxP() {
        this.aVB = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.guardclub.rank.b.3
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

    private void Bj() {
        c cVar = new c(this.mContext.getPageActivity(), 2, this.aZa, this.fLq);
        cVar.a(this);
        c cVar2 = new c(this.mContext.getPageActivity(), 1, this.aZa, this.fLq);
        cVar2.a(this);
        if (this.fLp != null) {
            this.fLp.a(cVar, cVar2);
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
        if (this.fLp != null) {
            this.fLp.w(str, j);
            ViewGroup bxx = this.fLp.bxx();
            if (bxx != null && (currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo()) != null) {
                if (this.fLt == null) {
                    this.fLt = new h(this.mContext.getPageActivity());
                }
                this.fLt.setOtherParams(this.mOtherParams);
                int[] iArr = new int[2];
                bxx.getLocationOnScreen(iArr);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams.topMargin = iArr[1] * (-1);
                this.fLt.a(bxx, layoutParams, currentAccountInfo.getPortrait(), currentAccountInfo.getAccountNameShow());
            }
        }
        if (!TextUtils.isEmpty(str2)) {
            com.baidu.live.m.a.av(str2, "guard_club_join");
        }
    }

    private void dA(long j) {
        if (!TbadkCoreApplication.getInst().isMobileBaidu() || com.baidu.live.v.a.Hm().aZp.aAp) {
            AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(this.mContext.getPageActivity());
            alaLiveRoomActivityConfig.addExtraByLiveId(j, "", AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_SDK);
            alaLiveRoomActivityConfig.addExtraByParams(this.mOtherParams);
            AlaLastLiveroomInfo alaLastLiveroomInfo = new AlaLastLiveroomInfo();
            alaLastLiveroomInfo.setLastAnchorUid(this.aZa);
            alaLastLiveroomInfo.setLastAnchorUname(this.aBT);
            alaLastLiveroomInfo.setLastAnchorPortrait(this.aBU);
            alaLastLiveroomInfo.setLastLiveId(this.aZe);
            alaLastLiveroomInfo.setLastRoomId(this.mRoomId);
            alaLastLiveroomInfo.setFrom(AlaLastLiveroomInfo.TYPE_FROM_GUARD_RANK);
            alaLiveRoomActivityConfig.addLastLiveInfoParams(alaLastLiveroomInfo);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_LIVE_ROOM_START, alaLiveRoomActivityConfig));
            if (this.fLp != null) {
                this.fLp.K(null);
            }
        }
    }

    private void e(k kVar) {
        boolean z = this.fLq;
        if (z && !TextUtils.isEmpty(this.aZa) && !TextUtils.isEmpty(kVar.aDD) && !this.aZa.equals(kVar.aDD)) {
            z = false;
        }
        GuardClubInfoActivityConfig guardClubInfoActivityConfig = new GuardClubInfoActivityConfig(this.mContext.getPageActivity(), Long.valueOf(kVar.aDD).longValue(), 0L, z, this.mOtherParams, kVar.fLn);
        guardClubInfoActivityConfig.setRoomId(this.mRoomId);
        guardClubInfoActivityConfig.setFeedId(this.aMu);
        guardClubInfoActivityConfig.setIsClubMember(kVar.fLn);
        guardClubInfoActivityConfig.setHideRank(true);
        guardClubInfoActivityConfig.setIsTranslucent(true);
        guardClubInfoActivityConfig.setRequestCode(RequestResponseCode.REQUEST_GUARD_CLUB_INFO);
        guardClubInfoActivityConfig.setIntentAction(IntentAction.ActivityForResult);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, guardClubInfoActivityConfig));
    }
}
