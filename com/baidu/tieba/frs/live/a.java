package com.baidu.tieba.frs.live;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.g.e;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.ala.AlaLiveInfoListCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.as;
import com.baidu.tieba.frs.entelechy.b.d;
import com.baidu.tieba.frs.f;
import com.baidu.tieba.frs.i;
import com.baidu.tieba.frs.live.c;
/* loaded from: classes.dex */
public class a {
    private as bmI;
    private f cIp;
    private TextView cUI;
    private FrameLayout cWY;
    private ImageView cWZ;
    private int cXb;
    private String cXc;
    private AlaLiveInfoCoreData cXd;
    private AlaLiveInfoListCoreData cXe;
    private c cXf;
    private int mForumId;
    private boolean isFirst = true;
    private c.a cXg = new c.a() { // from class: com.baidu.tieba.frs.live.a.1
        @Override // com.baidu.tieba.frs.live.c.a
        public void a(FrsLiveTipResponseMessage frsLiveTipResponseMessage) {
            if (frsLiveTipResponseMessage != null) {
                a.this.cXb = frsLiveTipResponseMessage.remindType;
                a.this.cXc = frsLiveTipResponseMessage.remindText;
                a.this.cXd = frsLiveTipResponseMessage.infoCoreData;
                a.this.cXe = frsLiveTipResponseMessage.listCoreData;
                if (a.this.bmI != null) {
                    a.this.bmI.amA();
                }
                if (a.this.cXb != 0) {
                    a.this.apv();
                }
            }
        }
    };
    private Runnable cXh = new Runnable() { // from class: com.baidu.tieba.frs.live.a.2
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.cXf != null) {
                a.this.cXf.kD(a.this.mForumId);
            }
        }
    };
    private int cXa = apA();

    public a(f fVar, int i) {
        this.cIp = fVar;
        this.mForumId = i;
    }

    public void apu() {
        if (this.cIp != null && this.cIp.isAdded()) {
            if (System.currentTimeMillis() - apD() >= 1800000) {
                if (this.cIp.alm() && isFirst()) {
                    this.isFirst = false;
                    return;
                }
                if (this.cXf == null) {
                    this.cXf = new c(this.cXg);
                }
                e.fP().removeCallbacks(this.cXh);
                e.fP().postDelayed(this.cXh, TbConfig.NOTIFY_SOUND_INTERVAL);
            }
        }
    }

    public void apv() {
        if (!StringUtils.isNull(this.cXc) && this.cXd != null) {
            if (this.cXb != 2 || apA() < 3) {
                bv(this.cIp.getPageContext().getPageActivity());
                if (this.cUI != null) {
                    this.cUI.setText(this.cXc);
                }
                onChangeSkinType();
                PL();
                apC();
            }
        }
    }

    public void apw() {
        if (this.cIp != null) {
            d alc = this.cIp.alc();
            if ((alc instanceof com.baidu.tieba.frs.entelechy.c.a) && ((com.baidu.tieba.frs.entelechy.c.a) alc).anP() != null) {
                ((com.baidu.tieba.frs.entelechy.c.a) alc).anP().kO(49);
            }
        }
    }

    private void onChangeSkinType() {
        aj.j(this.cWY, d.f.bg_frs_hot_live_tip_selector);
        aj.i(this.cUI, d.C0082d.cp_cont_i);
        aj.c(this.cWZ, d.f.icon_home_card_close_white);
        this.cUI.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, aj.getDrawable(d.f.icon_arrow_more_white), (Drawable) null);
    }

    private void bv(Context context) {
        if (context != null && this.cWY == null) {
            this.cWY = (FrameLayout) LayoutInflater.from(context).inflate(d.h.frs_hot_live_tip, (ViewGroup) null);
            this.cWY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.live.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.apx();
                }
            });
            this.cUI = (TextView) this.cWY.findViewById(d.g.frs_hot_live_tip_content);
            this.cWZ = (ImageView) this.cWY.findViewById(d.g.frs_hot_live_tip_close);
            this.cWZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.live.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.apy();
                }
            });
            onChangeSkinType();
        }
    }

    private void PL() {
        if (this.cIp != null) {
            com.baidu.tieba.frs.entelechy.b.d alc = this.cIp.alc();
            i ale = this.cIp.ale();
            if (ale != null && alc != null && alc.anK() != null && (ale.WP() instanceof NoPressedRelativeLayout)) {
                View anK = alc.anK();
                BdTypeListView listView = ale.getListView();
                if (anK != null && listView != null) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, l.f(TbadkCoreApplication.getInst(), d.e.ds56));
                    layoutParams.addRule(6, d.g.frs_list_content);
                    if (ale.alC() != null && ale.alC().getLayoutParams() != null) {
                        layoutParams.topMargin = ale.alC().getLayoutParams().height;
                    } else {
                        layoutParams.topMargin = 0;
                    }
                    if (this.bmI == null) {
                        this.bmI = new as();
                    }
                    NoPressedRelativeLayout noPressedRelativeLayout = (NoPressedRelativeLayout) ale.WP();
                    if (this.cXb == 2) {
                        this.bmI.a(this.cWY, noPressedRelativeLayout, layoutParams, 5000);
                    } else if (this.cXb == 1) {
                        this.bmI.a(this.cWY, noPressedRelativeLayout, layoutParams);
                        TiebaStatic.log(new ak("c12539"));
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void apx() {
        apB();
        if (this.cXd != null && this.cIp != null && this.cIp.isAdded()) {
            boolean equals = TextUtils.equals(getUserId(), String.valueOf(this.cXd.userID));
            String str = "";
            if (this.cXb == 1) {
                str = AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_FRS_FOLLOWED_LIVE_TIP;
                TiebaStatic.log(new ak("c12540"));
                if (this.bmI != null) {
                    this.bmI.hideTip();
                }
            } else if (this.cXb == 2) {
                str = AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_FRS_HOT_LIVE_TIP;
                TiebaStatic.log(new ak("c12331"));
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(this.cIp.getPageContext().getPageActivity(), this.cXd, this.cXe, str, getUserId(), equals, null, null)));
            if (this.cIp.alv().aRf().isGameForumType()) {
                CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_GAME_FRS_JUMP_TO_LIVE_TAB);
                customMessage.setTag(this.cIp.getBaseFragmentActivity().getUniqueId());
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_FRS_JUMP_TO_LIVE_TAB);
                customResponsedMessage.setOrginalMessage(customMessage);
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                return;
            }
            e.fP().post(new Runnable() { // from class: com.baidu.tieba.frs.live.a.5
                @Override // java.lang.Runnable
                public void run() {
                    a.this.apw();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void apy() {
        if (this.cXb == 2) {
            apz();
        }
        if (this.bmI != null) {
            this.bmI.hideTip();
        }
    }

    private void apz() {
        this.cXa++;
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("FRS_HOT_LIVE_TIP_CLOSE_NUM" + getUserId(), this.cXa);
    }

    private int apA() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("FRS_HOT_LIVE_TIP_CLOSE_NUM" + getUserId(), 0);
    }

    private void apB() {
        this.cXa = 0;
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("FRS_HOT_LIVE_TIP_CLOSE_NUM" + getUserId(), this.cXa);
    }

    private void apC() {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("FRS_HOT_LIVE_TIP_LAST_SHOWTIME" + getUserId(), System.currentTimeMillis());
    }

    private long apD() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("FRS_HOT_LIVE_TIP_LAST_SHOWTIME" + getUserId(), 0L);
    }

    private boolean isFirst() {
        return this.isFirst;
    }

    private String getUserId() {
        AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
        if (currentAccountInfo != null) {
            String id = currentAccountInfo.getID();
            if (!TextUtils.isEmpty(id)) {
                return id;
            }
        }
        return "";
    }

    public void onDestory() {
        if (this.bmI != null) {
            this.bmI.amA();
        }
        e.fP().removeCallbacks(this.cXh);
        if (this.cXf != null) {
            this.cXf.onDestory();
        }
    }
}
