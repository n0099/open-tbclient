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
import com.baidu.live.data.ah;
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
    private String alH;
    private com.baidu.live.k.c amW;
    private CustomMessageListener aoj;
    private CustomMessageListener atu;
    private String awp;
    private long awt;
    private h eHA;
    private InterfaceC0435a eHw;
    private boolean eHx;
    private boolean eHy;
    private i eHz;
    private TbPageContext mContext;
    private String mOtherParams;
    private long mRoomId;

    /* renamed from: com.baidu.tieba.ala.guardclub.rank.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0435a {
        void ab(Intent intent);

        void am(String str, int i);

        void b(Fragment... fragmentArr);

        ViewGroup bfo();

        void pr(int i);

        void w(String str, long j);
    }

    public a(TbPageContext tbPageContext) {
        this.mContext = tbPageContext;
    }

    public void a(Intent intent, InterfaceC0435a interfaceC0435a) {
        this.eHw = interfaceC0435a;
        C(intent);
        uQ();
        bfG();
        bfH();
    }

    public void bfE() {
        if (this.amW == null) {
            this.amW = new com.baidu.live.k.c();
            this.amW.initListener();
        }
        this.amW.refreshCurUserScores();
    }

    public void an(String str, int i) {
        if (i > TbadkCoreApplication.getInst().currentAccountTdouNum) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyTBeanActivityConfig(this.mContext.getPageActivity(), 0L, this.mOtherParams, true, "", true)));
            return;
        }
        if (this.eHz == null) {
            this.eHz = new i();
            this.eHz.a(new com.baidu.tieba.ala.guardclub.model.b() { // from class: com.baidu.tieba.ala.guardclub.rank.a.1
                @Override // com.baidu.tieba.ala.guardclub.model.b, com.baidu.tieba.ala.guardclub.model.m.a
                public void a(boolean z, String str2, long j, String str3, String str4) {
                    super.a(z, str2, j, str3, str4);
                    a.this.b(z, str2, j, str3, str4);
                }
            });
        }
        this.eHz.yz(str);
    }

    public void release() {
        this.eHw = null;
        if (this.eHA != null) {
            this.eHA.onDestory();
        }
        if (this.eHz != null) {
            this.eHz.release();
        }
        if (this.amW != null) {
            this.amW.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.aoj);
        MessageManager.getInstance().unRegisterListener(this.atu);
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.b.a
    public void iF(boolean z) {
        this.eHy = z;
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.b.a
    public void pr(int i) {
        if (this.eHw != null) {
            this.eHw.pr(i);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.b.a
    public void c(k kVar) {
        if (kVar.liveStatus == 1 && !TextUtils.isEmpty(kVar.liveId)) {
            if (this.eHy) {
                BdUtilHelper.showToast(this.mContext.getPageActivity(), "正在直播中，不能切换直播间哟！");
                return;
            } else if (String.valueOf(this.awt).equals(kVar.liveId)) {
                if (this.eHw != null) {
                    this.eHw.ab(new Intent().putExtra("guard_club_rank_back_to_room", true));
                    return;
                }
                return;
            } else {
                cN(Long.valueOf(kVar.liveId).longValue());
                return;
            }
        }
        e(kVar);
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.b.a
    public void d(k kVar) {
        int i = 1000;
        ah vJ = g.vH().vJ();
        if (vJ != null && vJ.acj > 0) {
            i = vJ.acj;
        }
        if (this.eHw != null) {
            this.eHw.am(kVar.id, i);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.b.a
    public void bfF() {
        if (this.eHw != null) {
            this.eHw.ab(new Intent().putExtra("guard_club_rank_hit", true));
        }
    }

    private void C(Intent intent) {
        this.awp = String.valueOf(intent.getLongExtra(GuardClubActivityConfig.ANCHOR_ID, 0L));
        this.awt = intent.getLongExtra(GuardClubActivityConfig.LIVE_ID, 0L);
        this.eHx = intent.getBooleanExtra(GuardClubActivityConfig.IS_LIVE_OWNER, false);
        this.mOtherParams = intent.getStringExtra(IntentConfig.OTHER_PARAMS);
        this.mRoomId = intent.getLongExtra(GuardClubActivityConfig.ROOM_ID, 0L);
        this.alH = intent.getStringExtra(GuardClubActivityConfig.FEED_ID);
    }

    private void uQ() {
        this.aoj = new CustomMessageListener(2913097) { // from class: com.baidu.tieba.ala.guardclub.rank.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.eHw != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    a.this.eHw.ab(null);
                }
            }
        };
        MessageManager.getInstance().registerListener(this.aoj);
    }

    private void bfG() {
        this.atu = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.guardclub.rank.a.3
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

    private void bfH() {
        GuardClubRankFragment h = GuardClubRankFragment.h(2, this.awp, this.eHx);
        h.a(this);
        GuardClubRankFragment h2 = GuardClubRankFragment.h(1, this.awp, this.eHx);
        h2.a(this);
        if (this.eHw != null) {
            this.eHw.b(h, h2);
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
        if (this.eHw != null) {
            this.eHw.w(str, j);
            ViewGroup bfo = this.eHw.bfo();
            if (bfo != null && (currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo()) != null) {
                if (this.eHA == null) {
                    this.eHA = new h(this.mContext.getPageActivity());
                }
                this.eHA.setOtherParams(this.mOtherParams);
                int[] iArr = new int[2];
                bfo.getLocationOnScreen(iArr);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams.topMargin = iArr[1] * (-1);
                this.eHA.a(bfo, layoutParams, currentAccountInfo.getPortrait(), currentAccountInfo.getAccountNameShow());
            }
        }
        if (!TextUtils.isEmpty(str2)) {
            com.baidu.live.l.a.ac(str2, "guard_club_join");
        }
    }

    private void cN(long j) {
        if (!TbadkCoreApplication.getInst().isMobileBaidu() || com.baidu.live.v.a.zl().awC.aav) {
            AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(this.mContext.getPageActivity());
            alaLiveRoomActivityConfig.addExtraByLiveId(j, "", AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_SDK);
            alaLiveRoomActivityConfig.addExtraByParams(this.mOtherParams);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_LIVE_ROOM_START, alaLiveRoomActivityConfig));
            if (this.eHw != null) {
                this.eHw.ab(null);
            }
        }
    }

    private void e(k kVar) {
        boolean z = this.eHx;
        if (z && !TextUtils.isEmpty(this.awp) && !TextUtils.isEmpty(kVar.adC) && !this.awp.equals(kVar.adC)) {
            z = false;
        }
        GuardClubInfoActivityConfig guardClubInfoActivityConfig = new GuardClubInfoActivityConfig(this.mContext.getPageActivity(), Long.valueOf(kVar.adC).longValue(), 0L, z, this.mOtherParams, kVar.eHu);
        guardClubInfoActivityConfig.setRoomId(this.mRoomId);
        guardClubInfoActivityConfig.setFeedId(this.alH);
        guardClubInfoActivityConfig.setIsClubMember(kVar.eHu);
        guardClubInfoActivityConfig.setHideRank(true);
        guardClubInfoActivityConfig.setIsTranslucent(true);
        guardClubInfoActivityConfig.setRequestCode(RequestResponseCode.REQUEST_GUARD_CLUB_INFO);
        guardClubInfoActivityConfig.setIntentAction(IntentAction.ActivityForResult);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, guardClubInfoActivityConfig));
    }
}
