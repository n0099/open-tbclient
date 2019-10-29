package com.baidu.tieba.ala.guardclub.rank;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.z;
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
import com.baidu.tieba.ala.guardclub.f;
import com.baidu.tieba.ala.guardclub.m;
import com.baidu.tieba.ala.guardclub.model.n;
import com.baidu.tieba.ala.guardclub.model.p;
import com.baidu.tieba.ala.guardclub.rank.b;
/* loaded from: classes6.dex */
public class a implements b.a {
    private String abe;
    private com.baidu.live.e.b acu;
    private CustomMessageListener adC;
    private CustomMessageListener ahD;
    private long ajM;
    private InterfaceC0347a dOX;
    private String dOY;
    private boolean dOZ;
    private boolean dPa;
    private n dPb;
    private f dPc;
    private TbPageContext mContext;
    private String mOtherParams;
    private long mRoomId;

    /* renamed from: com.baidu.tieba.ala.guardclub.rank.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0347a {
        ViewGroup aLu();

        void ae(String str, int i);

        void aj(Intent intent);

        void b(Fragment... fragmentArr);

        void mK(int i);

        void u(String str, long j);
    }

    public a(TbPageContext tbPageContext) {
        this.mContext = tbPageContext;
    }

    public void a(Intent intent, InterfaceC0347a interfaceC0347a) {
        this.dOX = interfaceC0347a;
        C(intent);
        rt();
        aLT();
        aLU();
    }

    public void aLR() {
        if (this.acu == null) {
            this.acu = new com.baidu.live.e.b();
            this.acu.initListener();
        }
        this.acu.refreshCurUserScores();
    }

    public void af(String str, int i) {
        if (i > TbadkCoreApplication.getInst().currentAccountTdouNum) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyTBeanActivityConfig(this.mContext.getPageActivity(), 0L, this.mOtherParams, true, "", true)));
            return;
        }
        if (this.dPb == null) {
            this.dPb = new n();
            this.dPb.a(new com.baidu.tieba.ala.guardclub.model.b() { // from class: com.baidu.tieba.ala.guardclub.rank.a.1
                @Override // com.baidu.tieba.ala.guardclub.model.b, com.baidu.tieba.ala.guardclub.model.r.a
                public void a(boolean z, String str2, long j, String str3, String str4) {
                    super.a(z, str2, j, str3, str4);
                    a.this.b(z, str2, j, str3, str4);
                }
            });
        }
        this.dPb.tn(str);
    }

    public void release() {
        this.dOX = null;
        if (this.dPc != null) {
            this.dPc.onDestory();
        }
        if (this.dPb != null) {
            this.dPb.release();
        }
        if (this.acu != null) {
            this.acu.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.adC);
        MessageManager.getInstance().unRegisterListener(this.ahD);
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.b.a
    public void hh(boolean z) {
        this.dPa = z;
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.b.a
    public void mK(int i) {
        if (this.dOX != null) {
            this.dOX.mK(i);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.b.a
    public void c(p pVar) {
        if (pVar.liveStatus == 1 && !TextUtils.isEmpty(pVar.liveId)) {
            if (this.dPa) {
                BdUtilHelper.showToast(this.mContext.getPageActivity(), "正在直播中，不能切换直播间哟！");
                return;
            } else if (String.valueOf(this.ajM).equals(pVar.liveId)) {
                if (this.dOX != null) {
                    this.dOX.aj(new Intent().putExtra("guard_club_rank_back_to_room", true));
                    return;
                }
                return;
            } else {
                cc(Long.valueOf(pVar.liveId).longValue());
                return;
            }
        }
        e(pVar);
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.b.a
    public void d(p pVar) {
        int i = 1000;
        z aLz = m.aLx().aLz();
        if (aLz != null && aLz.TF > 0) {
            i = aLz.TF;
        }
        if (this.dOX != null) {
            this.dOX.ae(pVar.id, i);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.b.a
    public void aLS() {
        if (this.dOX != null) {
            this.dOX.aj(new Intent().putExtra("guard_club_rank_hit", true));
        }
    }

    private void C(Intent intent) {
        this.dOY = String.valueOf(intent.getLongExtra(GuardClubActivityConfig.ANCHOR_ID, 0L));
        this.ajM = intent.getLongExtra(GuardClubActivityConfig.LIVE_ID, 0L);
        this.dOZ = intent.getBooleanExtra(GuardClubActivityConfig.IS_LIVE_OWNER, false);
        this.mOtherParams = intent.getStringExtra(IntentConfig.OTHER_PARAMS);
        this.mRoomId = intent.getLongExtra(GuardClubActivityConfig.ROOM_ID, 0L);
        this.abe = intent.getStringExtra(GuardClubActivityConfig.FEED_ID);
    }

    private void rt() {
        this.adC = new CustomMessageListener(2913097) { // from class: com.baidu.tieba.ala.guardclub.rank.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.dOX != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    a.this.dOX.aj(null);
                }
            }
        };
        MessageManager.getInstance().registerListener(this.adC);
    }

    private void aLT() {
        this.ahD = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.guardclub.rank.a.3
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

    private void aLU() {
        GuardClubRankFragment f = GuardClubRankFragment.f(2, this.dOY, this.dOZ);
        f.a(this);
        GuardClubRankFragment f2 = GuardClubRankFragment.f(1, this.dOY, this.dOZ);
        f2.a(this);
        if (this.dOX != null) {
            this.dOX.b(f, f2);
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
        if (this.dOX != null) {
            this.dOX.u(str, j);
            ViewGroup aLu = this.dOX.aLu();
            if (aLu != null && (currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo()) != null) {
                if (this.dPc == null) {
                    this.dPc = new f(this.mContext);
                }
                this.dPc.setOtherParams(this.mOtherParams);
                this.dPc.a(aLu, currentAccountInfo.getPortrait(), currentAccountInfo.getAccountNameShow());
            }
        }
        if (!TextUtils.isEmpty(str2)) {
            com.baidu.live.f.a.N(str2, "guard_club_join");
        }
    }

    private void cc(long j) {
        AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(this.mContext.getPageActivity());
        alaLiveRoomActivityConfig.addExtraByLiveId(j, "", AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_SDK);
        alaLiveRoomActivityConfig.addExtraByParams(this.mOtherParams);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_LIVE_ROOM_START, alaLiveRoomActivityConfig));
        if (this.dOX != null) {
            this.dOX.aj(null);
        }
    }

    private void e(p pVar) {
        boolean z = this.dOZ;
        if (z && !TextUtils.isEmpty(this.dOY) && !TextUtils.isEmpty(pVar.dOu) && !this.dOY.equals(pVar.dOu)) {
            z = false;
        }
        GuardClubInfoActivityConfig guardClubInfoActivityConfig = new GuardClubInfoActivityConfig(this.mContext.getPageActivity(), Long.valueOf(pVar.dOu).longValue(), 0L, z, this.mOtherParams, pVar.dOV);
        guardClubInfoActivityConfig.setRoomId(this.mRoomId);
        guardClubInfoActivityConfig.setFeedId(this.abe);
        guardClubInfoActivityConfig.setIsClubMember(pVar.dOV);
        guardClubInfoActivityConfig.setHideRank(true);
        guardClubInfoActivityConfig.setIsTranslucent(true);
        guardClubInfoActivityConfig.setRequestCode(RequestResponseCode.REQUEST_GUARD_CLUB_INFO);
        guardClubInfoActivityConfig.setIntentAction(IntentAction.ActivityForResult);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, guardClubInfoActivityConfig));
    }
}
