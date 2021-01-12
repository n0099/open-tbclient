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
/* loaded from: classes10.dex */
public class b implements d.a {
    private String aLT;
    private String aLU;
    private boolean aRd;
    private String bac;
    private com.baidu.live.p.c bbX;
    private CustomMessageListener bdo;
    private CustomMessageListener bly;
    private String bre;
    private long brk;
    private a gYc;
    private boolean gYd;
    private i gYe;
    private com.baidu.tieba.ala.guardclub.i gYf;
    private TbPageContext mContext;
    private String mOtherParams;
    private long mRoomId;

    /* loaded from: classes10.dex */
    public interface a {
        void O(Intent intent);

        void a(SupportXFragment... supportXFragmentArr);

        void aF(String str, int i);

        ViewGroup bVa();

        void uu(int i);

        void y(String str, long j);
    }

    public b(TbPageContext tbPageContext) {
        this.mContext = tbPageContext;
    }

    public void a(Intent intent, a aVar) {
        this.gYc = aVar;
        k(intent);
        Gz();
        bVq();
        GD();
    }

    public void bVo() {
        if (this.bbX == null) {
            this.bbX = new com.baidu.live.p.c();
            this.bbX.initListener();
        }
        this.bbX.refreshCurUserScores();
    }

    public void aG(String str, int i) {
        if (i > TbadkCoreApplication.getInst().currentAccountTdouNum) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyTBeanActivityConfig(this.mContext.getPageActivity(), 0L, this.mOtherParams, true, "", true)));
            return;
        }
        if (this.gYe == null) {
            this.gYe = new i();
            this.gYe.a(new com.baidu.tieba.ala.guardclub.model.b() { // from class: com.baidu.tieba.ala.guardclub.rank.b.1
                @Override // com.baidu.tieba.ala.guardclub.model.b, com.baidu.tieba.ala.guardclub.model.m.a
                public void a(boolean z, String str2, long j, String str3, String str4) {
                    super.a(z, str2, j, str3, str4);
                    b.this.b(z, str2, j, str3, str4);
                }
            });
        }
        this.gYe.Gu(str);
    }

    public void release() {
        this.gYc = null;
        if (this.gYf != null) {
            this.gYf.onDestory();
        }
        if (this.gYe != null) {
            this.gYe.release();
        }
        if (this.bbX != null) {
            this.bbX.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.bdo);
        MessageManager.getInstance().unRegisterListener(this.bly);
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.d.a
    public void nm(boolean z) {
        this.gYd = z;
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.d.a
    public void uu(int i) {
        if (this.gYc != null) {
            this.gYc.uu(i);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.d.a
    public void c(k kVar) {
        if (kVar.liveStatus == 1 && !TextUtils.isEmpty(kVar.liveId)) {
            if (this.gYd) {
                BdUtilHelper.showToast(this.mContext.getPageActivity(), "正在直播中，不能切换直播间哟！");
                return;
            } else if (String.valueOf(this.brk).equals(kVar.liveId)) {
                if (this.gYc != null) {
                    this.gYc.O(new Intent().putExtra("guard_club_rank_back_to_room", true));
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
        bi HF = g.HD().HF();
        if (HF != null && HF.aMl > 0) {
            i = HF.aMl;
        }
        if (this.gYc != null) {
            this.gYc.aF(kVar.id, i);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.d.a
    public void bVp() {
        if (this.gYc != null) {
            this.gYc.O(new Intent().putExtra("guard_club_rank_hit", true));
        }
    }

    private void k(Intent intent) {
        this.bre = String.valueOf(intent.getLongExtra(GuardClubActivityConfig.ANCHOR_ID, 0L));
        this.brk = intent.getLongExtra(GuardClubActivityConfig.LIVE_ID, 0L);
        this.aRd = intent.getBooleanExtra(GuardClubActivityConfig.IS_LIVE_OWNER, false);
        this.mOtherParams = intent.getStringExtra(IntentConfig.OTHER_PARAMS);
        this.mRoomId = intent.getLongExtra(GuardClubActivityConfig.ROOM_ID, 0L);
        this.bac = intent.getStringExtra(GuardClubActivityConfig.FEED_ID);
        this.aLT = intent.getStringExtra(GuardClubActivityConfig.ANCHOR_NAME);
        this.aLU = intent.getStringExtra(GuardClubActivityConfig.ANCHOR_PORTRAIT);
    }

    private void Gz() {
        this.bdo = new CustomMessageListener(2913097) { // from class: com.baidu.tieba.ala.guardclub.rank.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (b.this.gYc != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    b.this.gYc.O(null);
                }
            }
        };
        MessageManager.getInstance().registerListener(this.bdo);
    }

    private void bVq() {
        this.bly = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.guardclub.rank.b.3
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

    private void GD() {
        c cVar = new c(this.mContext.getPageActivity(), 2, this.bre, this.aRd);
        cVar.a(this);
        c cVar2 = new c(this.mContext.getPageActivity(), 1, this.bre, this.aRd);
        cVar2.a(this);
        if (this.gYc != null) {
            this.gYc.a(cVar, cVar2);
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
        if (this.gYc != null) {
            this.gYc.y(str, j);
            ViewGroup bVa = this.gYc.bVa();
            if (bVa != null && (currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo()) != null) {
                if (this.gYf == null) {
                    this.gYf = new com.baidu.tieba.ala.guardclub.i(this.mContext.getPageActivity());
                }
                this.gYf.setOtherParams(this.mOtherParams);
                int[] iArr = new int[2];
                bVa.getLocationOnScreen(iArr);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams.topMargin = iArr[1] * (-1);
                this.gYf.a(bVa, layoutParams, currentAccountInfo.getPortrait(), currentAccountInfo.getAccountNameShow());
            }
        }
        if (!TextUtils.isEmpty(str2)) {
            com.baidu.live.r.a.aD(str2, "guard_club_join");
        }
    }

    private void fl(long j) {
        if (!TbadkCoreApplication.getInst().isMobileBaidu() || com.baidu.live.af.a.OJ().bru.aJM) {
            com.baidu.live.liveroom.a.KT().a(com.baidu.live.liveroom.a.KT().KU().gL(String.valueOf(j)));
            AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(this.mContext.getPageActivity());
            alaLiveRoomActivityConfig.addExtraByLiveId(j, "", "live_sdk");
            alaLiveRoomActivityConfig.addExtraByParams(this.mOtherParams);
            AlaLastLiveroomInfo alaLastLiveroomInfo = new AlaLastLiveroomInfo();
            alaLastLiveroomInfo.setLastAnchorUid(this.bre);
            alaLastLiveroomInfo.setLastAnchorUname(this.aLT);
            alaLastLiveroomInfo.setLastAnchorPortrait(this.aLU);
            alaLastLiveroomInfo.setLastLiveId(this.brk);
            alaLastLiveroomInfo.setLastRoomId(this.mRoomId);
            alaLastLiveroomInfo.setFrom(AlaLastLiveroomInfo.TYPE_FROM_GUARD_RANK);
            alaLiveRoomActivityConfig.addLastLiveInfoParams(alaLastLiveroomInfo);
            com.baidu.live.liveroom.a.KT().a(alaLiveRoomActivityConfig);
            if (this.gYc != null) {
                this.gYc.O(null);
            }
        }
    }

    private void e(k kVar) {
        boolean z = this.aRd;
        if (z && !TextUtils.isEmpty(this.bre) && !TextUtils.isEmpty(kVar.aHi) && !this.bre.equals(kVar.aHi)) {
            z = false;
        }
        GuardClubInfoActivityConfig guardClubInfoActivityConfig = new GuardClubInfoActivityConfig(this.mContext.getPageActivity(), Long.valueOf(kVar.aHi).longValue(), 0L, z, this.mOtherParams, kVar.gYa);
        guardClubInfoActivityConfig.setRoomId(this.mRoomId);
        guardClubInfoActivityConfig.setFeedId(this.bac);
        guardClubInfoActivityConfig.setIsClubMember(kVar.gYa);
        guardClubInfoActivityConfig.setHideRank(true);
        guardClubInfoActivityConfig.setIsTranslucent(true);
        guardClubInfoActivityConfig.setRequestCode(RequestResponseCode.REQUEST_GUARD_CLUB_INFO);
        guardClubInfoActivityConfig.setIntentAction(IntentAction.ActivityForResult);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, guardClubInfoActivityConfig));
    }
}
