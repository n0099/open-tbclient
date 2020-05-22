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
import com.baidu.live.data.ao;
import com.baidu.live.guardclub.g;
import com.baidu.live.tbadk.TbPageContext;
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
    private String aJO;
    private com.baidu.live.k.c aLm;
    private CustomMessageListener aMA;
    private CustomMessageListener aSV;
    private String aWr;
    private long aWv;
    private a fzV;
    private boolean fzW;
    private boolean fzX;
    private i fzY;
    private h fzZ;
    private TbPageContext mContext;
    private String mOtherParams;
    private long mRoomId;

    /* loaded from: classes3.dex */
    public interface a {
        void K(Intent intent);

        void a(SupportXFragment... supportXFragmentArr);

        void ax(String str, int i);

        ViewGroup buA();

        void qo(int i);

        void w(String str, long j);
    }

    public b(TbPageContext tbPageContext) {
        this.mContext = tbPageContext;
    }

    public void a(Intent intent, a aVar) {
        this.fzV = aVar;
        k(intent);
        AF();
        buS();
        AJ();
    }

    public void buQ() {
        if (this.aLm == null) {
            this.aLm = new com.baidu.live.k.c();
            this.aLm.initListener();
        }
        this.aLm.refreshCurUserScores();
    }

    public void ay(String str, int i) {
        if (i > TbadkCoreApplication.getInst().currentAccountTdouNum) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyTBeanActivityConfig(this.mContext.getPageActivity(), 0L, this.mOtherParams, true, "", true)));
            return;
        }
        if (this.fzY == null) {
            this.fzY = new i();
            this.fzY.a(new com.baidu.tieba.ala.guardclub.model.b() { // from class: com.baidu.tieba.ala.guardclub.rank.b.1
                @Override // com.baidu.tieba.ala.guardclub.model.b, com.baidu.tieba.ala.guardclub.model.m.a
                public void a(boolean z, String str2, long j, String str3, String str4) {
                    super.a(z, str2, j, str3, str4);
                    b.this.b(z, str2, j, str3, str4);
                }
            });
        }
        this.fzY.BS(str);
    }

    public void release() {
        this.fzV = null;
        if (this.fzZ != null) {
            this.fzZ.onDestory();
        }
        if (this.fzY != null) {
            this.fzY.release();
        }
        if (this.aLm != null) {
            this.aLm.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.aMA);
        MessageManager.getInstance().unRegisterListener(this.aSV);
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.d.a
    public void kb(boolean z) {
        this.fzX = z;
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.d.a
    public void qo(int i) {
        if (this.fzV != null) {
            this.fzV.qo(i);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.d.a
    public void c(k kVar) {
        if (kVar.liveStatus == 1 && !TextUtils.isEmpty(kVar.liveId)) {
            if (this.fzX) {
                BdUtilHelper.showToast(this.mContext.getPageActivity(), "正在直播中，不能切换直播间哟！");
                return;
            } else if (String.valueOf(this.aWv).equals(kVar.liveId)) {
                if (this.fzV != null) {
                    this.fzV.K(new Intent().putExtra("guard_club_rank_back_to_room", true));
                    return;
                }
                return;
            } else {
                dx(Long.valueOf(kVar.liveId).longValue());
                return;
            }
        }
        e(kVar);
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.d.a
    public void d(k kVar) {
        int i = 1000;
        ao BJ = g.BH().BJ();
        if (BJ != null && BJ.aAa > 0) {
            i = BJ.aAa;
        }
        if (this.fzV != null) {
            this.fzV.ax(kVar.id, i);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.d.a
    public void buR() {
        if (this.fzV != null) {
            this.fzV.K(new Intent().putExtra("guard_club_rank_hit", true));
        }
    }

    private void k(Intent intent) {
        this.aWr = String.valueOf(intent.getLongExtra(GuardClubActivityConfig.ANCHOR_ID, 0L));
        this.aWv = intent.getLongExtra(GuardClubActivityConfig.LIVE_ID, 0L);
        this.fzW = intent.getBooleanExtra(GuardClubActivityConfig.IS_LIVE_OWNER, false);
        this.mOtherParams = intent.getStringExtra(IntentConfig.OTHER_PARAMS);
        this.mRoomId = intent.getLongExtra(GuardClubActivityConfig.ROOM_ID, 0L);
        this.aJO = intent.getStringExtra(GuardClubActivityConfig.FEED_ID);
    }

    private void AF() {
        this.aMA = new CustomMessageListener(2913097) { // from class: com.baidu.tieba.ala.guardclub.rank.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (b.this.fzV != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    b.this.fzV.K(null);
                }
            }
        };
        MessageManager.getInstance().registerListener(this.aMA);
    }

    private void buS() {
        this.aSV = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.guardclub.rank.b.3
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

    private void AJ() {
        c cVar = new c(this.mContext.getPageActivity(), 2, this.aWr, this.fzW);
        cVar.a(this);
        c cVar2 = new c(this.mContext.getPageActivity(), 1, this.aWr, this.fzW);
        cVar2.a(this);
        if (this.fzV != null) {
            this.fzV.a(cVar, cVar2);
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
        if (this.fzV != null) {
            this.fzV.w(str, j);
            ViewGroup buA = this.fzV.buA();
            if (buA != null && (currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo()) != null) {
                if (this.fzZ == null) {
                    this.fzZ = new h(this.mContext.getPageActivity());
                }
                this.fzZ.setOtherParams(this.mOtherParams);
                int[] iArr = new int[2];
                buA.getLocationOnScreen(iArr);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams.topMargin = iArr[1] * (-1);
                this.fzZ.a(buA, layoutParams, currentAccountInfo.getPortrait(), currentAccountInfo.getAccountNameShow());
            }
        }
        if (!TextUtils.isEmpty(str2)) {
            com.baidu.live.l.a.au(str2, "guard_club_join");
        }
    }

    private void dx(long j) {
        if (!TbadkCoreApplication.getInst().isMobileBaidu() || com.baidu.live.v.a.Ge().aWF.aya) {
            AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(this.mContext.getPageActivity());
            alaLiveRoomActivityConfig.addExtraByLiveId(j, "", AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_SDK);
            alaLiveRoomActivityConfig.addExtraByParams(this.mOtherParams);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_LIVE_ROOM_START, alaLiveRoomActivityConfig));
            if (this.fzV != null) {
                this.fzV.K(null);
            }
        }
    }

    private void e(k kVar) {
        boolean z = this.fzW;
        if (z && !TextUtils.isEmpty(this.aWr) && !TextUtils.isEmpty(kVar.aBs) && !this.aWr.equals(kVar.aBs)) {
            z = false;
        }
        GuardClubInfoActivityConfig guardClubInfoActivityConfig = new GuardClubInfoActivityConfig(this.mContext.getPageActivity(), Long.valueOf(kVar.aBs).longValue(), 0L, z, this.mOtherParams, kVar.fzT);
        guardClubInfoActivityConfig.setRoomId(this.mRoomId);
        guardClubInfoActivityConfig.setFeedId(this.aJO);
        guardClubInfoActivityConfig.setIsClubMember(kVar.fzT);
        guardClubInfoActivityConfig.setHideRank(true);
        guardClubInfoActivityConfig.setIsTranslucent(true);
        guardClubInfoActivityConfig.setRequestCode(RequestResponseCode.REQUEST_GUARD_CLUB_INFO);
        guardClubInfoActivityConfig.setIntentAction(IntentAction.ActivityForResult);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, guardClubInfoActivityConfig));
    }
}
