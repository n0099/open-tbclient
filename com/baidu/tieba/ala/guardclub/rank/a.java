package com.baidu.tieba.ala.guardclub.rank;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.ak;
import com.baidu.live.guardclub.g;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atom.GuardClubActivityConfig;
import com.baidu.live.tbadk.core.atomdata.AlaLiveRoomActivityConfig;
import com.baidu.live.tbadk.core.atomdata.BuyTBeanActivityConfig;
import com.baidu.live.tbadk.core.atomdata.GuardClubInfoActivityConfig;
import com.baidu.live.tbadk.core.data.AccountData;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.frameworkdata.IntentAction;
import com.baidu.live.tbadk.core.frameworkdata.IntentConfig;
import com.baidu.tieba.ala.guardclub.h;
import com.baidu.tieba.ala.guardclub.model.i;
import com.baidu.tieba.ala.guardclub.model.k;
import com.baidu.tieba.ala.guardclub.rank.b;
/* loaded from: classes3.dex */
public class a implements b.a {
    private String aEn;
    private com.baidu.live.k.c aFE;
    private CustomMessageListener aGS;
    private CustomMessageListener aMR;
    private String aQi;
    private long aQm;
    private InterfaceC0491a fmo;
    private boolean fmp;
    private boolean fmq;
    private i fmr;
    private h fms;
    private TbPageContext mContext;
    private String mOtherParams;
    private long mRoomId;

    /* renamed from: com.baidu.tieba.ala.guardclub.rank.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0491a {
        void N(Intent intent);

        void aw(String str, int i);

        void b(Fragment... fragmentArr);

        ViewGroup boI();

        void pN(int i);

        void x(String str, long j);
    }

    public a(TbPageContext tbPageContext) {
        this.mContext = tbPageContext;
    }

    public void a(Intent intent, InterfaceC0491a interfaceC0491a) {
        this.fmo = interfaceC0491a;
        o(intent);
        zq();
        bpa();
        bpb();
    }

    public void boY() {
        if (this.aFE == null) {
            this.aFE = new com.baidu.live.k.c();
            this.aFE.initListener();
        }
        this.aFE.refreshCurUserScores();
    }

    public void ax(String str, int i) {
        if (i > TbadkCoreApplication.getInst().currentAccountTdouNum) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyTBeanActivityConfig(this.mContext.getPageActivity(), 0L, this.mOtherParams, true, "", true)));
            return;
        }
        if (this.fmr == null) {
            this.fmr = new i();
            this.fmr.a(new com.baidu.tieba.ala.guardclub.model.b() { // from class: com.baidu.tieba.ala.guardclub.rank.a.1
                @Override // com.baidu.tieba.ala.guardclub.model.b, com.baidu.tieba.ala.guardclub.model.m.a
                public void a(boolean z, String str2, long j, String str3, String str4) {
                    super.a(z, str2, j, str3, str4);
                    a.this.b(z, str2, j, str3, str4);
                }
            });
        }
        this.fmr.Al(str);
    }

    public void release() {
        this.fmo = null;
        if (this.fms != null) {
            this.fms.onDestory();
        }
        if (this.fmr != null) {
            this.fmr.release();
        }
        if (this.aFE != null) {
            this.aFE.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.aGS);
        MessageManager.getInstance().unRegisterListener(this.aMR);
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.b.a
    public void jI(boolean z) {
        this.fmq = z;
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.b.a
    public void pN(int i) {
        if (this.fmo != null) {
            this.fmo.pN(i);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.b.a
    public void c(k kVar) {
        if (kVar.liveStatus == 1 && !TextUtils.isEmpty(kVar.liveId)) {
            if (this.fmq) {
                BdUtilHelper.showToast(this.mContext.getPageActivity(), "正在直播中，不能切换直播间哟！");
                return;
            } else if (String.valueOf(this.aQm).equals(kVar.liveId)) {
                if (this.fmo != null) {
                    this.fmo.N(new Intent().putExtra("guard_club_rank_back_to_room", true));
                    return;
                }
                return;
            } else {
                dv(Long.valueOf(kVar.liveId).longValue());
                return;
            }
        }
        e(kVar);
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.b.a
    public void d(k kVar) {
        int i = 1000;
        ak At = g.Ar().At();
        if (At != null && At.auW > 0) {
            i = At.auW;
        }
        if (this.fmo != null) {
            this.fmo.aw(kVar.id, i);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.b.a
    public void boZ() {
        if (this.fmo != null) {
            this.fmo.N(new Intent().putExtra("guard_club_rank_hit", true));
        }
    }

    private void o(Intent intent) {
        this.aQi = String.valueOf(intent.getLongExtra(GuardClubActivityConfig.ANCHOR_ID, 0L));
        this.aQm = intent.getLongExtra(GuardClubActivityConfig.LIVE_ID, 0L);
        this.fmp = intent.getBooleanExtra(GuardClubActivityConfig.IS_LIVE_OWNER, false);
        this.mOtherParams = intent.getStringExtra(IntentConfig.OTHER_PARAMS);
        this.mRoomId = intent.getLongExtra(GuardClubActivityConfig.ROOM_ID, 0L);
        this.aEn = intent.getStringExtra(GuardClubActivityConfig.FEED_ID);
    }

    private void zq() {
        this.aGS = new CustomMessageListener(2913097) { // from class: com.baidu.tieba.ala.guardclub.rank.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.fmo != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    a.this.fmo.N(null);
                }
            }
        };
        MessageManager.getInstance().registerListener(this.aGS);
    }

    private void bpa() {
        this.aMR = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.guardclub.rank.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                    String str = (String) customResponsedMessage.getData();
                    if (str == null) {
                        str = "";
                    }
                    a.this.mOtherParams = str;
                }
            }
        };
    }

    private void bpb() {
        GuardClubRankFragment i = GuardClubRankFragment.i(2, this.aQi, this.fmp);
        i.a(this);
        GuardClubRankFragment i2 = GuardClubRankFragment.i(1, this.aQi, this.fmp);
        i2.a(this);
        if (this.fmo != null) {
            this.fmo.b(i, i2);
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
        if (this.fmo != null) {
            this.fmo.x(str, j);
            ViewGroup boI = this.fmo.boI();
            if (boI != null && (currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo()) != null) {
                if (this.fms == null) {
                    this.fms = new h(this.mContext.getPageActivity());
                }
                this.fms.setOtherParams(this.mOtherParams);
                int[] iArr = new int[2];
                boI.getLocationOnScreen(iArr);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams.topMargin = iArr[1] * (-1);
                this.fms.a(boI, layoutParams, currentAccountInfo.getPortrait(), currentAccountInfo.getAccountNameShow());
            }
        }
        if (!TextUtils.isEmpty(str2)) {
            com.baidu.live.l.a.af(str2, "guard_club_join");
        }
    }

    private void dv(long j) {
        if (!TbadkCoreApplication.getInst().isMobileBaidu() || com.baidu.live.v.a.En().aQu.ata) {
            AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(this.mContext.getPageActivity());
            alaLiveRoomActivityConfig.addExtraByLiveId(j, "", AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_SDK);
            alaLiveRoomActivityConfig.addExtraByParams(this.mOtherParams);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_LIVE_ROOM_START, alaLiveRoomActivityConfig));
            if (this.fmo != null) {
                this.fmo.N(null);
            }
        }
    }

    private void e(k kVar) {
        boolean z = this.fmp;
        if (z && !TextUtils.isEmpty(this.aQi) && !TextUtils.isEmpty(kVar.awj) && !this.aQi.equals(kVar.awj)) {
            z = false;
        }
        GuardClubInfoActivityConfig guardClubInfoActivityConfig = new GuardClubInfoActivityConfig(this.mContext.getPageActivity(), Long.valueOf(kVar.awj).longValue(), 0L, z, this.mOtherParams, kVar.fmm);
        guardClubInfoActivityConfig.setRoomId(this.mRoomId);
        guardClubInfoActivityConfig.setFeedId(this.aEn);
        guardClubInfoActivityConfig.setIsClubMember(kVar.fmm);
        guardClubInfoActivityConfig.setHideRank(true);
        guardClubInfoActivityConfig.setIsTranslucent(true);
        guardClubInfoActivityConfig.setRequestCode(RequestResponseCode.REQUEST_GUARD_CLUB_INFO);
        guardClubInfoActivityConfig.setIntentAction(IntentAction.ActivityForResult);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, guardClubInfoActivityConfig));
    }
}
