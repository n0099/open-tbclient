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
    private String aaL;
    private com.baidu.live.e.b acb;
    private CustomMessageListener adk;
    private CustomMessageListener ahl;
    private long aju;
    private InterfaceC0342a dOg;
    private String dOh;
    private boolean dOi;
    private boolean dOj;
    private n dOk;
    private f dOl;
    private TbPageContext mContext;
    private String mOtherParams;
    private long mRoomId;

    /* renamed from: com.baidu.tieba.ala.guardclub.rank.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0342a {
        ViewGroup aLs();

        void ae(String str, int i);

        void aj(Intent intent);

        void b(Fragment... fragmentArr);

        void mJ(int i);

        void u(String str, long j);
    }

    public a(TbPageContext tbPageContext) {
        this.mContext = tbPageContext;
    }

    public void a(Intent intent, InterfaceC0342a interfaceC0342a) {
        this.dOg = interfaceC0342a;
        C(intent);
        ru();
        aLR();
        aLS();
    }

    public void aLP() {
        if (this.acb == null) {
            this.acb = new com.baidu.live.e.b();
            this.acb.initListener();
        }
        this.acb.refreshCurUserScores();
    }

    public void af(String str, int i) {
        if (i > TbadkCoreApplication.getInst().currentAccountTdouNum) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyTBeanActivityConfig(this.mContext.getPageActivity(), 0L, this.mOtherParams, true, "", true)));
            return;
        }
        if (this.dOk == null) {
            this.dOk = new n();
            this.dOk.a(new com.baidu.tieba.ala.guardclub.model.b() { // from class: com.baidu.tieba.ala.guardclub.rank.a.1
                @Override // com.baidu.tieba.ala.guardclub.model.b, com.baidu.tieba.ala.guardclub.model.r.a
                public void a(boolean z, String str2, long j, String str3, String str4) {
                    super.a(z, str2, j, str3, str4);
                    a.this.b(z, str2, j, str3, str4);
                }
            });
        }
        this.dOk.tn(str);
    }

    public void release() {
        this.dOg = null;
        if (this.dOl != null) {
            this.dOl.onDestory();
        }
        if (this.dOk != null) {
            this.dOk.release();
        }
        if (this.acb != null) {
            this.acb.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.adk);
        MessageManager.getInstance().unRegisterListener(this.ahl);
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.b.a
    public void hh(boolean z) {
        this.dOj = z;
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.b.a
    public void mJ(int i) {
        if (this.dOg != null) {
            this.dOg.mJ(i);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.b.a
    public void c(p pVar) {
        if (pVar.liveStatus == 1 && !TextUtils.isEmpty(pVar.liveId)) {
            if (this.dOj) {
                BdUtilHelper.showToast(this.mContext.getPageActivity(), "正在直播中，不能切换直播间哟！");
                return;
            } else if (String.valueOf(this.aju).equals(pVar.liveId)) {
                if (this.dOg != null) {
                    this.dOg.aj(new Intent().putExtra("guard_club_rank_back_to_room", true));
                    return;
                }
                return;
            } else {
                cb(Long.valueOf(pVar.liveId).longValue());
                return;
            }
        }
        e(pVar);
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.b.a
    public void d(p pVar) {
        int i = 1000;
        z aLx = m.aLv().aLx();
        if (aLx != null && aLx.Tl > 0) {
            i = aLx.Tl;
        }
        if (this.dOg != null) {
            this.dOg.ae(pVar.id, i);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.b.a
    public void aLQ() {
        if (this.dOg != null) {
            this.dOg.aj(new Intent().putExtra("guard_club_rank_hit", true));
        }
    }

    private void C(Intent intent) {
        this.dOh = String.valueOf(intent.getLongExtra(GuardClubActivityConfig.ANCHOR_ID, 0L));
        this.aju = intent.getLongExtra(GuardClubActivityConfig.LIVE_ID, 0L);
        this.dOi = intent.getBooleanExtra(GuardClubActivityConfig.IS_LIVE_OWNER, false);
        this.mOtherParams = intent.getStringExtra(IntentConfig.OTHER_PARAMS);
        this.mRoomId = intent.getLongExtra(GuardClubActivityConfig.ROOM_ID, 0L);
        this.aaL = intent.getStringExtra(GuardClubActivityConfig.FEED_ID);
    }

    private void ru() {
        this.adk = new CustomMessageListener(2913097) { // from class: com.baidu.tieba.ala.guardclub.rank.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.dOg != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    a.this.dOg.aj(null);
                }
            }
        };
        MessageManager.getInstance().registerListener(this.adk);
    }

    private void aLR() {
        this.ahl = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.guardclub.rank.a.3
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

    private void aLS() {
        GuardClubRankFragment f = GuardClubRankFragment.f(2, this.dOh, this.dOi);
        f.a(this);
        GuardClubRankFragment f2 = GuardClubRankFragment.f(1, this.dOh, this.dOi);
        f2.a(this);
        if (this.dOg != null) {
            this.dOg.b(f, f2);
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
        if (this.dOg != null) {
            this.dOg.u(str, j);
            ViewGroup aLs = this.dOg.aLs();
            if (aLs != null && (currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo()) != null) {
                if (this.dOl == null) {
                    this.dOl = new f(this.mContext);
                }
                this.dOl.setOtherParams(this.mOtherParams);
                this.dOl.a(aLs, currentAccountInfo.getPortrait(), currentAccountInfo.getAccountNameShow());
            }
        }
        if (!TextUtils.isEmpty(str2)) {
            com.baidu.live.f.a.N(str2, "guard_club_join");
        }
    }

    private void cb(long j) {
        AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(this.mContext.getPageActivity());
        alaLiveRoomActivityConfig.addExtraByLiveId(j, "", AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_SDK);
        alaLiveRoomActivityConfig.addExtraByParams(this.mOtherParams);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_LIVE_ROOM_START, alaLiveRoomActivityConfig));
        if (this.dOg != null) {
            this.dOg.aj(null);
        }
    }

    private void e(p pVar) {
        boolean z = this.dOi;
        if (z && !TextUtils.isEmpty(this.dOh) && !TextUtils.isEmpty(pVar.dND) && !this.dOh.equals(pVar.dND)) {
            z = false;
        }
        GuardClubInfoActivityConfig guardClubInfoActivityConfig = new GuardClubInfoActivityConfig(this.mContext.getPageActivity(), Long.valueOf(pVar.dND).longValue(), 0L, z, this.mOtherParams, pVar.dOe);
        guardClubInfoActivityConfig.setRoomId(this.mRoomId);
        guardClubInfoActivityConfig.setFeedId(this.aaL);
        guardClubInfoActivityConfig.setIsClubMember(pVar.dOe);
        guardClubInfoActivityConfig.setHideRank(true);
        guardClubInfoActivityConfig.setIsTranslucent(true);
        guardClubInfoActivityConfig.setRequestCode(RequestResponseCode.REQUEST_GUARD_CLUB_INFO);
        guardClubInfoActivityConfig.setIntentAction(IntentAction.ActivityForResult);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, guardClubInfoActivityConfig));
    }
}
