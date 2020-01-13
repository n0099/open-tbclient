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
import com.baidu.live.data.ag;
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
import com.baidu.tieba.ala.guardclub.l;
import com.baidu.tieba.ala.guardclub.model.n;
import com.baidu.tieba.ala.guardclub.model.p;
import com.baidu.tieba.ala.guardclub.rank.b;
/* loaded from: classes2.dex */
public class a implements b.a {
    private String ajy;
    private com.baidu.live.j.c akJ;
    private CustomMessageListener alV;
    private CustomMessageListener aqb;
    private String asd;
    private long ash;
    private boolean eDA;
    private n eDB;
    private f eDC;
    private InterfaceC0424a eDy;
    private boolean eDz;
    private TbPageContext mContext;
    private String mOtherParams;
    private long mRoomId;

    /* renamed from: com.baidu.tieba.ala.guardclub.rank.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0424a {
        void ab(Intent intent);

        void ao(String str, int i);

        void b(Fragment... fragmentArr);

        ViewGroup bcW();

        void pa(int i);

        void w(String str, long j);
    }

    public a(TbPageContext tbPageContext) {
        this.mContext = tbPageContext;
    }

    public void a(Intent intent, InterfaceC0424a interfaceC0424a) {
        this.eDy = interfaceC0424a;
        C(intent);
        tA();
        bdv();
        bdw();
    }

    public void bdt() {
        if (this.akJ == null) {
            this.akJ = new com.baidu.live.j.c();
            this.akJ.initListener();
        }
        this.akJ.refreshCurUserScores();
    }

    public void ap(String str, int i) {
        if (i > TbadkCoreApplication.getInst().currentAccountTdouNum) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyTBeanActivityConfig(this.mContext.getPageActivity(), 0L, this.mOtherParams, true, "", true)));
            return;
        }
        if (this.eDB == null) {
            this.eDB = new n();
            this.eDB.a(new com.baidu.tieba.ala.guardclub.model.b() { // from class: com.baidu.tieba.ala.guardclub.rank.a.1
                @Override // com.baidu.tieba.ala.guardclub.model.b, com.baidu.tieba.ala.guardclub.model.r.a
                public void a(boolean z, String str2, long j, String str3, String str4) {
                    super.a(z, str2, j, str3, str4);
                    a.this.b(z, str2, j, str3, str4);
                }
            });
        }
        this.eDB.yd(str);
    }

    public void release() {
        this.eDy = null;
        if (this.eDC != null) {
            this.eDC.onDestory();
        }
        if (this.eDB != null) {
            this.eDB.release();
        }
        if (this.akJ != null) {
            this.akJ.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.alV);
        MessageManager.getInstance().unRegisterListener(this.aqb);
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.b.a
    public void iy(boolean z) {
        this.eDA = z;
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.b.a
    public void pa(int i) {
        if (this.eDy != null) {
            this.eDy.pa(i);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.b.a
    public void c(p pVar) {
        if (pVar.liveStatus == 1 && !TextUtils.isEmpty(pVar.liveId)) {
            if (this.eDA) {
                BdUtilHelper.showToast(this.mContext.getPageActivity(), "正在直播中，不能切换直播间哟！");
                return;
            } else if (String.valueOf(this.ash).equals(pVar.liveId)) {
                if (this.eDy != null) {
                    this.eDy.ab(new Intent().putExtra("guard_club_rank_back_to_room", true));
                    return;
                }
                return;
            } else {
                cL(Long.valueOf(pVar.liveId).longValue());
                return;
            }
        }
        e(pVar);
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.b.a
    public void d(p pVar) {
        int i = 1000;
        ag bdb = l.bcZ().bdb();
        if (bdb != null && bdb.aap > 0) {
            i = bdb.aap;
        }
        if (this.eDy != null) {
            this.eDy.ao(pVar.id, i);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.b.a
    public void bdu() {
        if (this.eDy != null) {
            this.eDy.ab(new Intent().putExtra("guard_club_rank_hit", true));
        }
    }

    private void C(Intent intent) {
        this.asd = String.valueOf(intent.getLongExtra(GuardClubActivityConfig.ANCHOR_ID, 0L));
        this.ash = intent.getLongExtra(GuardClubActivityConfig.LIVE_ID, 0L);
        this.eDz = intent.getBooleanExtra(GuardClubActivityConfig.IS_LIVE_OWNER, false);
        this.mOtherParams = intent.getStringExtra(IntentConfig.OTHER_PARAMS);
        this.mRoomId = intent.getLongExtra(GuardClubActivityConfig.ROOM_ID, 0L);
        this.ajy = intent.getStringExtra(GuardClubActivityConfig.FEED_ID);
    }

    private void tA() {
        this.alV = new CustomMessageListener(2913097) { // from class: com.baidu.tieba.ala.guardclub.rank.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.eDy != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    a.this.eDy.ab(null);
                }
            }
        };
        MessageManager.getInstance().registerListener(this.alV);
    }

    private void bdv() {
        this.aqb = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.guardclub.rank.a.3
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

    private void bdw() {
        GuardClubRankFragment h = GuardClubRankFragment.h(2, this.asd, this.eDz);
        h.a(this);
        GuardClubRankFragment h2 = GuardClubRankFragment.h(1, this.asd, this.eDz);
        h2.a(this);
        if (this.eDy != null) {
            this.eDy.b(h, h2);
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
        if (this.eDy != null) {
            this.eDy.w(str, j);
            ViewGroup bcW = this.eDy.bcW();
            if (bcW != null && (currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo()) != null) {
                if (this.eDC == null) {
                    this.eDC = new f(this.mContext);
                }
                this.eDC.setOtherParams(this.mOtherParams);
                this.eDC.a(bcW, currentAccountInfo.getPortrait(), currentAccountInfo.getAccountNameShow());
            }
        }
        if (!TextUtils.isEmpty(str2)) {
            com.baidu.live.k.a.U(str2, "guard_club_join");
        }
    }

    private void cL(long j) {
        if (!TbadkCoreApplication.getInst().isMobileBaidu() || com.baidu.live.s.a.wR().asq.YD) {
            AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(this.mContext.getPageActivity());
            alaLiveRoomActivityConfig.addExtraByLiveId(j, "", AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_SDK);
            alaLiveRoomActivityConfig.addExtraByParams(this.mOtherParams);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_LIVE_ROOM_START, alaLiveRoomActivityConfig));
            if (this.eDy != null) {
                this.eDy.ab(null);
            }
        }
    }

    private void e(p pVar) {
        boolean z = this.eDz;
        if (z && !TextUtils.isEmpty(this.asd) && !TextUtils.isEmpty(pVar.abx) && !this.asd.equals(pVar.abx)) {
            z = false;
        }
        GuardClubInfoActivityConfig guardClubInfoActivityConfig = new GuardClubInfoActivityConfig(this.mContext.getPageActivity(), Long.valueOf(pVar.abx).longValue(), 0L, z, this.mOtherParams, pVar.eDw);
        guardClubInfoActivityConfig.setRoomId(this.mRoomId);
        guardClubInfoActivityConfig.setFeedId(this.ajy);
        guardClubInfoActivityConfig.setIsClubMember(pVar.eDw);
        guardClubInfoActivityConfig.setHideRank(true);
        guardClubInfoActivityConfig.setIsTranslucent(true);
        guardClubInfoActivityConfig.setRequestCode(RequestResponseCode.REQUEST_GUARD_CLUB_INFO);
        guardClubInfoActivityConfig.setIntentAction(IntentAction.ActivityForResult);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, guardClubInfoActivityConfig));
    }
}
