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
    private String aMV;
    private String aMW;
    private boolean aYB;
    private String aYD;
    private com.baidu.live.l.c bae;
    private CustomMessageListener bbC;
    private CustomMessageListener biH;
    private String bla;
    private long blh;
    private a gsn;
    private boolean gso;
    private i gsp;
    private h gsq;
    private TbPageContext mContext;
    private String mOtherParams;
    private long mRoomId;

    /* loaded from: classes4.dex */
    public interface a {
        void N(Intent intent);

        void a(SupportXFragment... supportXFragmentArr);

        void aA(String str, int i);

        ViewGroup bOe();

        void ui(int i);

        void v(String str, long j);
    }

    public b(TbPageContext tbPageContext) {
        this.mContext = tbPageContext;
    }

    public void a(Intent intent, a aVar) {
        this.gsn = aVar;
        k(intent);
        II();
        bOu();
        IM();
    }

    public void bOs() {
        if (this.bae == null) {
            this.bae = new com.baidu.live.l.c();
            this.bae.initListener();
        }
        this.bae.refreshCurUserScores();
    }

    public void aB(String str, int i) {
        if (i > TbadkCoreApplication.getInst().currentAccountTdouNum) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyTBeanActivityConfig(this.mContext.getPageActivity(), 0L, this.mOtherParams, true, "", true)));
            return;
        }
        if (this.gsp == null) {
            this.gsp = new i();
            this.gsp.a(new com.baidu.tieba.ala.guardclub.model.b() { // from class: com.baidu.tieba.ala.guardclub.rank.b.1
                @Override // com.baidu.tieba.ala.guardclub.model.b, com.baidu.tieba.ala.guardclub.model.m.a
                public void a(boolean z, String str2, long j, String str3, String str4) {
                    super.a(z, str2, j, str3, str4);
                    b.this.b(z, str2, j, str3, str4);
                }
            });
        }
        this.gsp.GG(str);
    }

    public void release() {
        this.gsn = null;
        if (this.gsq != null) {
            this.gsq.onDestory();
        }
        if (this.gsp != null) {
            this.gsp.release();
        }
        if (this.bae != null) {
            this.bae.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.bbC);
        MessageManager.getInstance().unRegisterListener(this.biH);
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.d.a
    public void lV(boolean z) {
        this.gso = z;
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.d.a
    public void ui(int i) {
        if (this.gsn != null) {
            this.gsn.ui(i);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.d.a
    public void c(k kVar) {
        if (kVar.liveStatus == 1 && !TextUtils.isEmpty(kVar.liveId)) {
            if (this.gso) {
                BdUtilHelper.showToast(this.mContext.getPageActivity(), "正在直播中，不能切换直播间哟！");
                return;
            } else if (String.valueOf(this.blh).equals(kVar.liveId)) {
                if (this.gsn != null) {
                    this.gsn.N(new Intent().putExtra("guard_club_rank_back_to_room", true));
                    return;
                }
                return;
            } else {
                ek(Long.valueOf(kVar.liveId).longValue());
                return;
            }
        }
        e(kVar);
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.d.a
    public void d(k kVar) {
        int i = 1000;
        ba JO = g.JM().JO();
        if (JO != null && JO.aNn > 0) {
            i = JO.aNn;
        }
        if (this.gsn != null) {
            this.gsn.aA(kVar.id, i);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.d.a
    public void bOt() {
        if (this.gsn != null) {
            this.gsn.N(new Intent().putExtra("guard_club_rank_hit", true));
        }
    }

    private void k(Intent intent) {
        this.bla = String.valueOf(intent.getLongExtra(GuardClubActivityConfig.ANCHOR_ID, 0L));
        this.blh = intent.getLongExtra(GuardClubActivityConfig.LIVE_ID, 0L);
        this.aYB = intent.getBooleanExtra(GuardClubActivityConfig.IS_LIVE_OWNER, false);
        this.mOtherParams = intent.getStringExtra(IntentConfig.OTHER_PARAMS);
        this.mRoomId = intent.getLongExtra(GuardClubActivityConfig.ROOM_ID, 0L);
        this.aYD = intent.getStringExtra(GuardClubActivityConfig.FEED_ID);
        this.aMV = intent.getStringExtra(GuardClubActivityConfig.ANCHOR_NAME);
        this.aMW = intent.getStringExtra(GuardClubActivityConfig.ANCHOR_PORTRAIT);
    }

    private void II() {
        this.bbC = new CustomMessageListener(2913097) { // from class: com.baidu.tieba.ala.guardclub.rank.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (b.this.gsn != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    b.this.gsn.N(null);
                }
            }
        };
        MessageManager.getInstance().registerListener(this.bbC);
    }

    private void bOu() {
        this.biH = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.guardclub.rank.b.3
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

    private void IM() {
        c cVar = new c(this.mContext.getPageActivity(), 2, this.bla, this.aYB);
        cVar.a(this);
        c cVar2 = new c(this.mContext.getPageActivity(), 1, this.bla, this.aYB);
        cVar2.a(this);
        if (this.gsn != null) {
            this.gsn.a(cVar, cVar2);
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
        if (this.gsn != null) {
            this.gsn.v(str, j);
            ViewGroup bOe = this.gsn.bOe();
            if (bOe != null && (currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo()) != null) {
                if (this.gsq == null) {
                    this.gsq = new h(this.mContext.getPageActivity());
                }
                this.gsq.setOtherParams(this.mOtherParams);
                int[] iArr = new int[2];
                bOe.getLocationOnScreen(iArr);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams.topMargin = iArr[1] * (-1);
                this.gsq.a(bOe, layoutParams, currentAccountInfo.getPortrait(), currentAccountInfo.getAccountNameShow());
            }
        }
        if (!TextUtils.isEmpty(str2)) {
            com.baidu.live.n.a.aB(str2, "guard_club_join");
        }
    }

    private void ek(long j) {
        if (!TbadkCoreApplication.getInst().isMobileBaidu() || com.baidu.live.x.a.OS().blo.aLh) {
            AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(this.mContext.getPageActivity());
            alaLiveRoomActivityConfig.addExtraByLiveId(j, "", "live_sdk");
            alaLiveRoomActivityConfig.addExtraByParams(this.mOtherParams);
            AlaLastLiveroomInfo alaLastLiveroomInfo = new AlaLastLiveroomInfo();
            alaLastLiveroomInfo.setLastAnchorUid(this.bla);
            alaLastLiveroomInfo.setLastAnchorUname(this.aMV);
            alaLastLiveroomInfo.setLastAnchorPortrait(this.aMW);
            alaLastLiveroomInfo.setLastLiveId(this.blh);
            alaLastLiveroomInfo.setLastRoomId(this.mRoomId);
            alaLastLiveroomInfo.setFrom(AlaLastLiveroomInfo.TYPE_FROM_GUARD_RANK);
            alaLiveRoomActivityConfig.addLastLiveInfoParams(alaLastLiveroomInfo);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_LIVE_ROOM_START, alaLiveRoomActivityConfig));
            if (this.gsn != null) {
                this.gsn.N(null);
            }
        }
    }

    private void e(k kVar) {
        boolean z = this.aYB;
        if (z && !TextUtils.isEmpty(this.bla) && !TextUtils.isEmpty(kVar.aOR) && !this.bla.equals(kVar.aOR)) {
            z = false;
        }
        GuardClubInfoActivityConfig guardClubInfoActivityConfig = new GuardClubInfoActivityConfig(this.mContext.getPageActivity(), Long.valueOf(kVar.aOR).longValue(), 0L, z, this.mOtherParams, kVar.gsl);
        guardClubInfoActivityConfig.setRoomId(this.mRoomId);
        guardClubInfoActivityConfig.setFeedId(this.aYD);
        guardClubInfoActivityConfig.setIsClubMember(kVar.gsl);
        guardClubInfoActivityConfig.setHideRank(true);
        guardClubInfoActivityConfig.setIsTranslucent(true);
        guardClubInfoActivityConfig.setRequestCode(RequestResponseCode.REQUEST_GUARD_CLUB_INFO);
        guardClubInfoActivityConfig.setIntentAction(IntentAction.ActivityForResult);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, guardClubInfoActivityConfig));
    }
}
