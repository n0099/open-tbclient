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
import com.baidu.live.data.ac;
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
    private String aiO;
    private com.baidu.live.i.c ajY;
    private CustomMessageListener alh;
    private CustomMessageListener apo;
    private String arr;
    private long arv;
    private InterfaceC0421a eCn;
    private boolean eCo;
    private boolean eCp;
    private n eCq;
    private f eCr;
    private TbPageContext mContext;
    private String mOtherParams;
    private long mRoomId;

    /* renamed from: com.baidu.tieba.ala.guardclub.rank.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0421a {
        void ab(Intent intent);

        void an(String str, int i);

        void b(Fragment... fragmentArr);

        ViewGroup bcB();

        void oZ(int i);

        void w(String str, long j);
    }

    public a(TbPageContext tbPageContext) {
        this.mContext = tbPageContext;
    }

    public void a(Intent intent, InterfaceC0421a interfaceC0421a) {
        this.eCn = interfaceC0421a;
        C(intent);
        ti();
        bda();
        bdb();
    }

    public void bcY() {
        if (this.ajY == null) {
            this.ajY = new com.baidu.live.i.c();
            this.ajY.initListener();
        }
        this.ajY.refreshCurUserScores();
    }

    public void ao(String str, int i) {
        if (i > TbadkCoreApplication.getInst().currentAccountTdouNum) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyTBeanActivityConfig(this.mContext.getPageActivity(), 0L, this.mOtherParams, true, "", true)));
            return;
        }
        if (this.eCq == null) {
            this.eCq = new n();
            this.eCq.a(new com.baidu.tieba.ala.guardclub.model.b() { // from class: com.baidu.tieba.ala.guardclub.rank.a.1
                @Override // com.baidu.tieba.ala.guardclub.model.b, com.baidu.tieba.ala.guardclub.model.r.a
                public void a(boolean z, String str2, long j, String str3, String str4) {
                    super.a(z, str2, j, str3, str4);
                    a.this.b(z, str2, j, str3, str4);
                }
            });
        }
        this.eCq.xY(str);
    }

    public void release() {
        this.eCn = null;
        if (this.eCr != null) {
            this.eCr.onDestory();
        }
        if (this.eCq != null) {
            this.eCq.release();
        }
        if (this.ajY != null) {
            this.ajY.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.alh);
        MessageManager.getInstance().unRegisterListener(this.apo);
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.b.a
    public void io(boolean z) {
        this.eCp = z;
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.b.a
    public void oZ(int i) {
        if (this.eCn != null) {
            this.eCn.oZ(i);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.b.a
    public void c(p pVar) {
        if (pVar.liveStatus == 1 && !TextUtils.isEmpty(pVar.liveId)) {
            if (this.eCp) {
                BdUtilHelper.showToast(this.mContext.getPageActivity(), "正在直播中，不能切换直播间哟！");
                return;
            } else if (String.valueOf(this.arv).equals(pVar.liveId)) {
                if (this.eCn != null) {
                    this.eCn.ab(new Intent().putExtra("guard_club_rank_back_to_room", true));
                    return;
                }
                return;
            } else {
                cG(Long.valueOf(pVar.liveId).longValue());
                return;
            }
        }
        e(pVar);
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.b.a
    public void d(p pVar) {
        int i = 1000;
        ac bcG = l.bcE().bcG();
        if (bcG != null && bcG.aab > 0) {
            i = bcG.aab;
        }
        if (this.eCn != null) {
            this.eCn.an(pVar.id, i);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.b.a
    public void bcZ() {
        if (this.eCn != null) {
            this.eCn.ab(new Intent().putExtra("guard_club_rank_hit", true));
        }
    }

    private void C(Intent intent) {
        this.arr = String.valueOf(intent.getLongExtra(GuardClubActivityConfig.ANCHOR_ID, 0L));
        this.arv = intent.getLongExtra(GuardClubActivityConfig.LIVE_ID, 0L);
        this.eCo = intent.getBooleanExtra(GuardClubActivityConfig.IS_LIVE_OWNER, false);
        this.mOtherParams = intent.getStringExtra(IntentConfig.OTHER_PARAMS);
        this.mRoomId = intent.getLongExtra(GuardClubActivityConfig.ROOM_ID, 0L);
        this.aiO = intent.getStringExtra(GuardClubActivityConfig.FEED_ID);
    }

    private void ti() {
        this.alh = new CustomMessageListener(2913097) { // from class: com.baidu.tieba.ala.guardclub.rank.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.eCn != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    a.this.eCn.ab(null);
                }
            }
        };
        MessageManager.getInstance().registerListener(this.alh);
    }

    private void bda() {
        this.apo = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.guardclub.rank.a.3
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

    private void bdb() {
        GuardClubRankFragment h = GuardClubRankFragment.h(2, this.arr, this.eCo);
        h.a(this);
        GuardClubRankFragment h2 = GuardClubRankFragment.h(1, this.arr, this.eCo);
        h2.a(this);
        if (this.eCn != null) {
            this.eCn.b(h, h2);
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
        if (this.eCn != null) {
            this.eCn.w(str, j);
            ViewGroup bcB = this.eCn.bcB();
            if (bcB != null && (currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo()) != null) {
                if (this.eCr == null) {
                    this.eCr = new f(this.mContext);
                }
                this.eCr.setOtherParams(this.mOtherParams);
                this.eCr.a(bcB, currentAccountInfo.getPortrait(), currentAccountInfo.getAccountNameShow());
            }
        }
        if (!TextUtils.isEmpty(str2)) {
            com.baidu.live.j.a.V(str2, "guard_club_join");
        }
    }

    private void cG(long j) {
        if (!TbadkCoreApplication.getInst().isMobileBaidu() || com.baidu.live.r.a.wA().arE.Yr) {
            AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(this.mContext.getPageActivity());
            alaLiveRoomActivityConfig.addExtraByLiveId(j, "", AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_SDK);
            alaLiveRoomActivityConfig.addExtraByParams(this.mOtherParams);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_LIVE_ROOM_START, alaLiveRoomActivityConfig));
            if (this.eCn != null) {
                this.eCn.ab(null);
            }
        }
    }

    private void e(p pVar) {
        boolean z = this.eCo;
        if (z && !TextUtils.isEmpty(this.arr) && !TextUtils.isEmpty(pVar.abl) && !this.arr.equals(pVar.abl)) {
            z = false;
        }
        GuardClubInfoActivityConfig guardClubInfoActivityConfig = new GuardClubInfoActivityConfig(this.mContext.getPageActivity(), Long.valueOf(pVar.abl).longValue(), 0L, z, this.mOtherParams, pVar.eCl);
        guardClubInfoActivityConfig.setRoomId(this.mRoomId);
        guardClubInfoActivityConfig.setFeedId(this.aiO);
        guardClubInfoActivityConfig.setIsClubMember(pVar.eCl);
        guardClubInfoActivityConfig.setHideRank(true);
        guardClubInfoActivityConfig.setIsTranslucent(true);
        guardClubInfoActivityConfig.setRequestCode(RequestResponseCode.REQUEST_GUARD_CLUB_INFO);
        guardClubInfoActivityConfig.setIntentAction(IntentAction.ActivityForResult);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, guardClubInfoActivityConfig));
    }
}
