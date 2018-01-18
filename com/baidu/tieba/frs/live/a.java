package com.baidu.tieba.frs.live;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.g.e;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
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
import com.baidu.tieba.d;
import com.baidu.tieba.frs.au;
import com.baidu.tieba.frs.i;
import com.baidu.tieba.frs.k;
import com.baidu.tieba.frs.live.c;
/* loaded from: classes2.dex */
public class a {
    private au cae;
    private i dCx;
    private TextView dLJ;
    private FrameLayout dOM;
    private ImageView dON;
    private int dOP;
    private String dOQ;
    private AlaLiveInfoCoreData dOR;
    private AlaLiveInfoListCoreData dOS;
    private c dOT;
    private int mForumId;
    private boolean isFirst = true;
    private c.a dOU = new c.a() { // from class: com.baidu.tieba.frs.live.a.1
        @Override // com.baidu.tieba.frs.live.c.a
        public void a(FrsLiveTipResponseMessage frsLiveTipResponseMessage) {
            if (frsLiveTipResponseMessage != null) {
                a.this.dOP = frsLiveTipResponseMessage.remindType;
                a.this.dOQ = frsLiveTipResponseMessage.remindText;
                a.this.dOR = frsLiveTipResponseMessage.infoCoreData;
                a.this.dOS = frsLiveTipResponseMessage.listCoreData;
                if (a.this.cae != null) {
                    a.this.cae.avt();
                }
                if (a.this.dOP != 0) {
                    a.this.axU();
                }
            }
        }
    };
    private Runnable dOV = new Runnable() { // from class: com.baidu.tieba.frs.live.a.2
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.dOT != null) {
                a.this.dOT.nF(a.this.mForumId);
            }
        }
    };
    private int dOO = axZ();

    public a(i iVar, int i) {
        this.dCx = iVar;
        this.mForumId = i;
    }

    public void axT() {
        if (this.dCx != null && this.dCx.isAdded()) {
            if (System.currentTimeMillis() - getLastShowTime() >= 1800000) {
                if (this.dCx.auh() && isFirst()) {
                    this.isFirst = false;
                    return;
                }
                if (this.dOT == null) {
                    this.dOT = new c(this.dOU);
                }
                e.nr().removeCallbacks(this.dOV);
                e.nr().postDelayed(this.dOV, TbConfig.NOTIFY_SOUND_INTERVAL);
            }
        }
    }

    public void axU() {
        if (!StringUtils.isNull(this.dOQ) && this.dOR != null) {
            if (this.dOP != 2 || axZ() < 3) {
                bB(this.dCx.getPageContext().getPageActivity());
                if (this.dLJ != null) {
                    this.dLJ.setText(this.dOQ);
                }
                onChangeSkinType();
                WX();
                saveLastShowTime();
            }
        }
    }

    public void axV() {
        if (this.dCx != null) {
            this.dCx.atW().nT(49);
        }
    }

    private void onChangeSkinType() {
        aj.s(this.dOM, d.f.bg_frs_hot_live_tip_selector);
        aj.r(this.dLJ, d.C0107d.cp_cont_i);
        aj.c(this.dON, d.f.icon_home_card_close_white);
        this.dLJ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, aj.getDrawable(d.f.icon_arrow_more_white), (Drawable) null);
    }

    private void bB(Context context) {
        if (context != null && this.dOM == null) {
            this.dOM = (FrameLayout) LayoutInflater.from(context).inflate(d.h.frs_hot_live_tip, (ViewGroup) null);
            this.dOM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.live.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.axW();
                }
            });
            this.dLJ = (TextView) this.dOM.findViewById(d.g.frs_hot_live_tip_content);
            this.dON = (ImageView) this.dOM.findViewById(d.g.frs_hot_live_tip_close);
            this.dON.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.live.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.axX();
                }
            });
            onChangeSkinType();
        }
    }

    private void WX() {
        k atY;
        FrameLayout frameLayout;
        if (this.dCx != null && (atY = this.dCx.atY()) != null && atY.getListView() != null && (frameLayout = (FrameLayout) atY.auQ()) != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, l.s(TbadkCoreApplication.getInst(), d.e.ds56));
            if (atY.auy() != null && atY.auy().getLayoutParams() != null) {
                layoutParams.topMargin = atY.auy().getLayoutParams().height;
            } else {
                layoutParams.topMargin = 0;
            }
            if (this.cae == null) {
                this.cae = new au();
            }
            if (this.dOP == 2) {
                this.cae.a(this.dOM, frameLayout, layoutParams, 5000);
            } else if (this.dOP == 1) {
                this.cae.a(this.dOM, frameLayout, layoutParams);
                TiebaStatic.log(new ak("c12539"));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void axW() {
        aya();
        if (this.dOR != null && this.dCx != null && this.dCx.isAdded()) {
            boolean equals = TextUtils.equals(getUserId(), String.valueOf(this.dOR.userID));
            String str = "";
            if (this.dOP == 1) {
                str = AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_FRS_FOLLOWED_LIVE_TIP;
                TiebaStatic.log(new ak("c12540"));
                if (this.cae != null) {
                    this.cae.hideTip();
                }
            } else if (this.dOP == 2) {
                str = AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_FRS_HOT_LIVE_TIP;
                TiebaStatic.log(new ak("c12331"));
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(this.dCx.getPageContext().getPageActivity(), this.dOR, this.dOS, str, getUserId(), equals, null, null)));
            if (this.dCx.auq().aYE().isGameForumType()) {
                CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_GAME_FRS_JUMP_TO_LIVE_TAB);
                customMessage.setTag(this.dCx.getBaseFragmentActivity().getUniqueId());
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_FRS_JUMP_TO_LIVE_TAB);
                customResponsedMessage.setOrginalMessage(customMessage);
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                return;
            }
            e.nr().post(new Runnable() { // from class: com.baidu.tieba.frs.live.a.5
                @Override // java.lang.Runnable
                public void run() {
                    a.this.axV();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void axX() {
        if (this.dOP == 2) {
            axY();
        }
        if (this.cae != null) {
            this.cae.hideTip();
        }
    }

    private void axY() {
        this.dOO++;
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("FRS_HOT_LIVE_TIP_CLOSE_NUM" + getUserId(), this.dOO);
    }

    private int axZ() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("FRS_HOT_LIVE_TIP_CLOSE_NUM" + getUserId(), 0);
    }

    private void aya() {
        this.dOO = 0;
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("FRS_HOT_LIVE_TIP_CLOSE_NUM" + getUserId(), this.dOO);
    }

    private void saveLastShowTime() {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("FRS_HOT_LIVE_TIP_LAST_SHOWTIME" + getUserId(), System.currentTimeMillis());
    }

    private long getLastShowTime() {
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
        if (this.cae != null) {
            this.cae.avt();
        }
        e.nr().removeCallbacks(this.dOV);
        if (this.dOT != null) {
            this.dOT.onDestory();
        }
    }
}
