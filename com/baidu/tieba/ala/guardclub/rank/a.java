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
    private String aEh;
    private com.baidu.live.k.c aFy;
    private CustomMessageListener aGM;
    private CustomMessageListener aML;
    private String aQc;
    private long aQg;
    private InterfaceC0470a fmj;
    private boolean fmk;
    private boolean fml;
    private i fmm;
    private h fmn;
    private TbPageContext mContext;
    private String mOtherParams;
    private long mRoomId;

    /* renamed from: com.baidu.tieba.ala.guardclub.rank.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0470a {
        void aa(Intent intent);

        void aw(String str, int i);

        void b(Fragment... fragmentArr);

        ViewGroup boK();

        void pN(int i);

        void x(String str, long j);
    }

    public a(TbPageContext tbPageContext) {
        this.mContext = tbPageContext;
    }

    public void a(Intent intent, InterfaceC0470a interfaceC0470a) {
        this.fmj = interfaceC0470a;
        B(intent);
        zr();
        bpc();
        bpd();
    }

    public void bpa() {
        if (this.aFy == null) {
            this.aFy = new com.baidu.live.k.c();
            this.aFy.initListener();
        }
        this.aFy.refreshCurUserScores();
    }

    public void ax(String str, int i) {
        if (i > TbadkCoreApplication.getInst().currentAccountTdouNum) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyTBeanActivityConfig(this.mContext.getPageActivity(), 0L, this.mOtherParams, true, "", true)));
            return;
        }
        if (this.fmm == null) {
            this.fmm = new i();
            this.fmm.a(new com.baidu.tieba.ala.guardclub.model.b() { // from class: com.baidu.tieba.ala.guardclub.rank.a.1
                @Override // com.baidu.tieba.ala.guardclub.model.b, com.baidu.tieba.ala.guardclub.model.m.a
                public void a(boolean z, String str2, long j, String str3, String str4) {
                    super.a(z, str2, j, str3, str4);
                    a.this.b(z, str2, j, str3, str4);
                }
            });
        }
        this.fmm.Ai(str);
    }

    public void release() {
        this.fmj = null;
        if (this.fmn != null) {
            this.fmn.onDestory();
        }
        if (this.fmm != null) {
            this.fmm.release();
        }
        if (this.aFy != null) {
            this.aFy.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.aGM);
        MessageManager.getInstance().unRegisterListener(this.aML);
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.b.a
    public void jI(boolean z) {
        this.fml = z;
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.b.a
    public void pN(int i) {
        if (this.fmj != null) {
            this.fmj.pN(i);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.b.a
    public void c(k kVar) {
        if (kVar.liveStatus == 1 && !TextUtils.isEmpty(kVar.liveId)) {
            if (this.fml) {
                BdUtilHelper.showToast(this.mContext.getPageActivity(), "正在直播中，不能切换直播间哟！");
                return;
            } else if (String.valueOf(this.aQg).equals(kVar.liveId)) {
                if (this.fmj != null) {
                    this.fmj.aa(new Intent().putExtra("guard_club_rank_back_to_room", true));
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
        ak Au = g.As().Au();
        if (Au != null && Au.auQ > 0) {
            i = Au.auQ;
        }
        if (this.fmj != null) {
            this.fmj.aw(kVar.id, i);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.b.a
    public void bpb() {
        if (this.fmj != null) {
            this.fmj.aa(new Intent().putExtra("guard_club_rank_hit", true));
        }
    }

    private void B(Intent intent) {
        this.aQc = String.valueOf(intent.getLongExtra(GuardClubActivityConfig.ANCHOR_ID, 0L));
        this.aQg = intent.getLongExtra(GuardClubActivityConfig.LIVE_ID, 0L);
        this.fmk = intent.getBooleanExtra(GuardClubActivityConfig.IS_LIVE_OWNER, false);
        this.mOtherParams = intent.getStringExtra(IntentConfig.OTHER_PARAMS);
        this.mRoomId = intent.getLongExtra(GuardClubActivityConfig.ROOM_ID, 0L);
        this.aEh = intent.getStringExtra(GuardClubActivityConfig.FEED_ID);
    }

    private void zr() {
        this.aGM = new CustomMessageListener(2913097) { // from class: com.baidu.tieba.ala.guardclub.rank.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.fmj != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    a.this.fmj.aa(null);
                }
            }
        };
        MessageManager.getInstance().registerListener(this.aGM);
    }

    private void bpc() {
        this.aML = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.guardclub.rank.a.3
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

    private void bpd() {
        GuardClubRankFragment i = GuardClubRankFragment.i(2, this.aQc, this.fmk);
        i.a(this);
        GuardClubRankFragment i2 = GuardClubRankFragment.i(1, this.aQc, this.fmk);
        i2.a(this);
        if (this.fmj != null) {
            this.fmj.b(i, i2);
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
        if (this.fmj != null) {
            this.fmj.x(str, j);
            ViewGroup boK = this.fmj.boK();
            if (boK != null && (currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo()) != null) {
                if (this.fmn == null) {
                    this.fmn = new h(this.mContext.getPageActivity());
                }
                this.fmn.setOtherParams(this.mOtherParams);
                int[] iArr = new int[2];
                boK.getLocationOnScreen(iArr);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams.topMargin = iArr[1] * (-1);
                this.fmn.a(boK, layoutParams, currentAccountInfo.getPortrait(), currentAccountInfo.getAccountNameShow());
            }
        }
        if (!TextUtils.isEmpty(str2)) {
            com.baidu.live.l.a.af(str2, "guard_club_join");
        }
    }

    private void dv(long j) {
        if (!TbadkCoreApplication.getInst().isMobileBaidu() || com.baidu.live.v.a.Eo().aQp.asU) {
            AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(this.mContext.getPageActivity());
            alaLiveRoomActivityConfig.addExtraByLiveId(j, "", AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_SDK);
            alaLiveRoomActivityConfig.addExtraByParams(this.mOtherParams);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_LIVE_ROOM_START, alaLiveRoomActivityConfig));
            if (this.fmj != null) {
                this.fmj.aa(null);
            }
        }
    }

    private void e(k kVar) {
        boolean z = this.fmk;
        if (z && !TextUtils.isEmpty(this.aQc) && !TextUtils.isEmpty(kVar.awd) && !this.aQc.equals(kVar.awd)) {
            z = false;
        }
        GuardClubInfoActivityConfig guardClubInfoActivityConfig = new GuardClubInfoActivityConfig(this.mContext.getPageActivity(), Long.valueOf(kVar.awd).longValue(), 0L, z, this.mOtherParams, kVar.fmh);
        guardClubInfoActivityConfig.setRoomId(this.mRoomId);
        guardClubInfoActivityConfig.setFeedId(this.aEh);
        guardClubInfoActivityConfig.setIsClubMember(kVar.fmh);
        guardClubInfoActivityConfig.setHideRank(true);
        guardClubInfoActivityConfig.setIsTranslucent(true);
        guardClubInfoActivityConfig.setRequestCode(RequestResponseCode.REQUEST_GUARD_CLUB_INFO);
        guardClubInfoActivityConfig.setIntentAction(IntentAction.ActivityForResult);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, guardClubInfoActivityConfig));
    }
}
