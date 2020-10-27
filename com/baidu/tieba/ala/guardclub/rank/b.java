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
import com.baidu.live.data.bd;
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
    private String aNA;
    private String aNB;
    private boolean aRP;
    private String baa;
    private com.baidu.live.m.c bby;
    private CustomMessageListener bcQ;
    private CustomMessageListener bkc;
    private long bmB;
    private String bmv;
    private a gCr;
    private boolean gCs;
    private i gCt;
    private h gCu;
    private TbPageContext mContext;
    private String mOtherParams;
    private long mRoomId;

    /* loaded from: classes4.dex */
    public interface a {
        void N(Intent intent);

        void a(SupportXFragment... supportXFragmentArr);

        void aB(String str, int i);

        ViewGroup bQJ();

        void uA(int i);

        void y(String str, long j);
    }

    public b(TbPageContext tbPageContext) {
        this.mContext = tbPageContext;
    }

    public void a(Intent intent, a aVar) {
        this.gCr = aVar;
        k(intent);
        Jb();
        bQZ();
        Jf();
    }

    public void bQX() {
        if (this.bby == null) {
            this.bby = new com.baidu.live.m.c();
            this.bby.initListener();
        }
        this.bby.refreshCurUserScores();
    }

    public void aC(String str, int i) {
        if (i > TbadkCoreApplication.getInst().currentAccountTdouNum) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyTBeanActivityConfig(this.mContext.getPageActivity(), 0L, this.mOtherParams, true, "", true)));
            return;
        }
        if (this.gCt == null) {
            this.gCt = new i();
            this.gCt.a(new com.baidu.tieba.ala.guardclub.model.b() { // from class: com.baidu.tieba.ala.guardclub.rank.b.1
                @Override // com.baidu.tieba.ala.guardclub.model.b, com.baidu.tieba.ala.guardclub.model.m.a
                public void a(boolean z, String str2, long j, String str3, String str4) {
                    super.a(z, str2, j, str3, str4);
                    b.this.b(z, str2, j, str3, str4);
                }
            });
        }
        this.gCt.He(str);
    }

    public void release() {
        this.gCr = null;
        if (this.gCu != null) {
            this.gCu.onDestory();
        }
        if (this.gCt != null) {
            this.gCt.release();
        }
        if (this.bby != null) {
            this.bby.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.bcQ);
        MessageManager.getInstance().unRegisterListener(this.bkc);
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.d.a
    public void ml(boolean z) {
        this.gCs = z;
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.d.a
    public void uA(int i) {
        if (this.gCr != null) {
            this.gCr.uA(i);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.d.a
    public void c(k kVar) {
        if (kVar.liveStatus == 1 && !TextUtils.isEmpty(kVar.liveId)) {
            if (this.gCs) {
                BdUtilHelper.showToast(this.mContext.getPageActivity(), "正在直播中，不能切换直播间哟！");
                return;
            } else if (String.valueOf(this.bmB).equals(kVar.liveId)) {
                if (this.gCr != null) {
                    this.gCr.N(new Intent().putExtra("guard_club_rank_back_to_room", true));
                    return;
                }
                return;
            } else {
                el(Long.valueOf(kVar.liveId).longValue());
                return;
            }
        }
        e(kVar);
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.d.a
    public void d(k kVar) {
        int i = 1000;
        bd Kh = g.Kf().Kh();
        if (Kh != null && Kh.aNS > 0) {
            i = Kh.aNS;
        }
        if (this.gCr != null) {
            this.gCr.aB(kVar.id, i);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.d.a
    public void bQY() {
        if (this.gCr != null) {
            this.gCr.N(new Intent().putExtra("guard_club_rank_hit", true));
        }
    }

    private void k(Intent intent) {
        this.bmv = String.valueOf(intent.getLongExtra(GuardClubActivityConfig.ANCHOR_ID, 0L));
        this.bmB = intent.getLongExtra(GuardClubActivityConfig.LIVE_ID, 0L);
        this.aRP = intent.getBooleanExtra(GuardClubActivityConfig.IS_LIVE_OWNER, false);
        this.mOtherParams = intent.getStringExtra(IntentConfig.OTHER_PARAMS);
        this.mRoomId = intent.getLongExtra(GuardClubActivityConfig.ROOM_ID, 0L);
        this.baa = intent.getStringExtra(GuardClubActivityConfig.FEED_ID);
        this.aNA = intent.getStringExtra(GuardClubActivityConfig.ANCHOR_NAME);
        this.aNB = intent.getStringExtra(GuardClubActivityConfig.ANCHOR_PORTRAIT);
    }

    private void Jb() {
        this.bcQ = new CustomMessageListener(2913097) { // from class: com.baidu.tieba.ala.guardclub.rank.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (b.this.gCr != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    b.this.gCr.N(null);
                }
            }
        };
        MessageManager.getInstance().registerListener(this.bcQ);
    }

    private void bQZ() {
        this.bkc = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.guardclub.rank.b.3
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

    private void Jf() {
        c cVar = new c(this.mContext.getPageActivity(), 2, this.bmv, this.aRP);
        cVar.a(this);
        c cVar2 = new c(this.mContext.getPageActivity(), 1, this.bmv, this.aRP);
        cVar2.a(this);
        if (this.gCr != null) {
            this.gCr.a(cVar, cVar2);
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
        if (this.gCr != null) {
            this.gCr.y(str, j);
            ViewGroup bQJ = this.gCr.bQJ();
            if (bQJ != null && (currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo()) != null) {
                if (this.gCu == null) {
                    this.gCu = new h(this.mContext.getPageActivity());
                }
                this.gCu.setOtherParams(this.mOtherParams);
                int[] iArr = new int[2];
                bQJ.getLocationOnScreen(iArr);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams.topMargin = iArr[1] * (-1);
                this.gCu.a(bQJ, layoutParams, currentAccountInfo.getPortrait(), currentAccountInfo.getAccountNameShow());
            }
        }
        if (!TextUtils.isEmpty(str2)) {
            com.baidu.live.o.a.aC(str2, "guard_club_join");
        }
    }

    private void el(long j) {
        if (!TbadkCoreApplication.getInst().isMobileBaidu() || com.baidu.live.z.a.Pq().bmJ.aLL) {
            AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(this.mContext.getPageActivity());
            alaLiveRoomActivityConfig.addExtraByLiveId(j, "", "live_sdk");
            alaLiveRoomActivityConfig.addExtraByParams(this.mOtherParams);
            AlaLastLiveroomInfo alaLastLiveroomInfo = new AlaLastLiveroomInfo();
            alaLastLiveroomInfo.setLastAnchorUid(this.bmv);
            alaLastLiveroomInfo.setLastAnchorUname(this.aNA);
            alaLastLiveroomInfo.setLastAnchorPortrait(this.aNB);
            alaLastLiveroomInfo.setLastLiveId(this.bmB);
            alaLastLiveroomInfo.setLastRoomId(this.mRoomId);
            alaLastLiveroomInfo.setFrom(AlaLastLiveroomInfo.TYPE_FROM_GUARD_RANK);
            alaLiveRoomActivityConfig.addLastLiveInfoParams(alaLastLiveroomInfo);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_LIVE_ROOM_START, alaLiveRoomActivityConfig));
            if (this.gCr != null) {
                this.gCr.N(null);
            }
        }
    }

    private void e(k kVar) {
        boolean z = this.aRP;
        if (z && !TextUtils.isEmpty(this.bmv) && !TextUtils.isEmpty(kVar.aPA) && !this.bmv.equals(kVar.aPA)) {
            z = false;
        }
        GuardClubInfoActivityConfig guardClubInfoActivityConfig = new GuardClubInfoActivityConfig(this.mContext.getPageActivity(), Long.valueOf(kVar.aPA).longValue(), 0L, z, this.mOtherParams, kVar.gCp);
        guardClubInfoActivityConfig.setRoomId(this.mRoomId);
        guardClubInfoActivityConfig.setFeedId(this.baa);
        guardClubInfoActivityConfig.setIsClubMember(kVar.gCp);
        guardClubInfoActivityConfig.setHideRank(true);
        guardClubInfoActivityConfig.setIsTranslucent(true);
        guardClubInfoActivityConfig.setRequestCode(RequestResponseCode.REQUEST_GUARD_CLUB_INFO);
        guardClubInfoActivityConfig.setIntentAction(IntentAction.ActivityForResult);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, guardClubInfoActivityConfig));
    }
}
