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
    private au cam;
    private i dCS;
    private TextView dMe;
    private FrameLayout dPh;
    private ImageView dPi;
    private int dPk;
    private String dPl;
    private AlaLiveInfoCoreData dPm;
    private AlaLiveInfoListCoreData dPn;
    private c dPo;
    private int mForumId;
    private boolean isFirst = true;
    private c.a dPp = new c.a() { // from class: com.baidu.tieba.frs.live.a.1
        @Override // com.baidu.tieba.frs.live.c.a
        public void a(FrsLiveTipResponseMessage frsLiveTipResponseMessage) {
            if (frsLiveTipResponseMessage != null) {
                a.this.dPk = frsLiveTipResponseMessage.remindType;
                a.this.dPl = frsLiveTipResponseMessage.remindText;
                a.this.dPm = frsLiveTipResponseMessage.infoCoreData;
                a.this.dPn = frsLiveTipResponseMessage.listCoreData;
                if (a.this.cam != null) {
                    a.this.cam.avy();
                }
                if (a.this.dPk != 0) {
                    a.this.axZ();
                }
            }
        }
    };
    private Runnable dPq = new Runnable() { // from class: com.baidu.tieba.frs.live.a.2
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.dPo != null) {
                a.this.dPo.nF(a.this.mForumId);
            }
        }
    };
    private int dPj = aye();

    public a(i iVar, int i) {
        this.dCS = iVar;
        this.mForumId = i;
    }

    public void axY() {
        if (this.dCS != null && this.dCS.isAdded()) {
            if (System.currentTimeMillis() - getLastShowTime() >= 1800000) {
                if (this.dCS.aum() && isFirst()) {
                    this.isFirst = false;
                    return;
                }
                if (this.dPo == null) {
                    this.dPo = new c(this.dPp);
                }
                e.ns().removeCallbacks(this.dPq);
                e.ns().postDelayed(this.dPq, TbConfig.NOTIFY_SOUND_INTERVAL);
            }
        }
    }

    public void axZ() {
        if (!StringUtils.isNull(this.dPl) && this.dPm != null) {
            if (this.dPk != 2 || aye() < 3) {
                by(this.dCS.getPageContext().getPageActivity());
                if (this.dMe != null) {
                    this.dMe.setText(this.dPl);
                }
                onChangeSkinType();
                WZ();
                saveLastShowTime();
            }
        }
    }

    public void aya() {
        if (this.dCS != null) {
            this.dCS.aub().nT(49);
        }
    }

    private void onChangeSkinType() {
        aj.s(this.dPh, d.f.bg_frs_hot_live_tip_selector);
        aj.r(this.dMe, d.C0108d.cp_cont_i);
        aj.c(this.dPi, d.f.icon_home_card_close_white);
        this.dMe.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, aj.getDrawable(d.f.icon_arrow_more_white), (Drawable) null);
    }

    private void by(Context context) {
        if (context != null && this.dPh == null) {
            this.dPh = (FrameLayout) LayoutInflater.from(context).inflate(d.h.frs_hot_live_tip, (ViewGroup) null);
            this.dPh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.live.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.ayb();
                }
            });
            this.dMe = (TextView) this.dPh.findViewById(d.g.frs_hot_live_tip_content);
            this.dPi = (ImageView) this.dPh.findViewById(d.g.frs_hot_live_tip_close);
            this.dPi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.live.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.ayc();
                }
            });
            onChangeSkinType();
        }
    }

    private void WZ() {
        k aud;
        FrameLayout frameLayout;
        if (this.dCS != null && (aud = this.dCS.aud()) != null && aud.getListView() != null && (frameLayout = (FrameLayout) aud.auV()) != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, l.s(TbadkCoreApplication.getInst(), d.e.ds56));
            if (aud.auD() != null && aud.auD().getLayoutParams() != null) {
                layoutParams.topMargin = aud.auD().getLayoutParams().height;
            } else {
                layoutParams.topMargin = 0;
            }
            if (this.cam == null) {
                this.cam = new au();
            }
            if (this.dPk == 2) {
                this.cam.a(this.dPh, frameLayout, layoutParams, 5000);
            } else if (this.dPk == 1) {
                this.cam.a(this.dPh, frameLayout, layoutParams);
                TiebaStatic.log(new ak("c12539"));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ayb() {
        ayf();
        if (this.dPm != null && this.dCS != null && this.dCS.isAdded()) {
            boolean equals = TextUtils.equals(getUserId(), String.valueOf(this.dPm.userID));
            String str = "";
            if (this.dPk == 1) {
                str = AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_FRS_FOLLOWED_LIVE_TIP;
                TiebaStatic.log(new ak("c12540"));
                if (this.cam != null) {
                    this.cam.hideTip();
                }
            } else if (this.dPk == 2) {
                str = AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_FRS_HOT_LIVE_TIP;
                TiebaStatic.log(new ak("c12331"));
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(this.dCS.getPageContext().getPageActivity(), this.dPm, this.dPn, str, getUserId(), equals, null, null)));
            if (this.dCS.auv().aYJ().isGameForumType()) {
                CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_GAME_FRS_JUMP_TO_LIVE_TAB);
                customMessage.setTag(this.dCS.getBaseFragmentActivity().getUniqueId());
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_FRS_JUMP_TO_LIVE_TAB);
                customResponsedMessage.setOrginalMessage(customMessage);
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                return;
            }
            e.ns().post(new Runnable() { // from class: com.baidu.tieba.frs.live.a.5
                @Override // java.lang.Runnable
                public void run() {
                    a.this.aya();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ayc() {
        if (this.dPk == 2) {
            ayd();
        }
        if (this.cam != null) {
            this.cam.hideTip();
        }
    }

    private void ayd() {
        this.dPj++;
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("FRS_HOT_LIVE_TIP_CLOSE_NUM" + getUserId(), this.dPj);
    }

    private int aye() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("FRS_HOT_LIVE_TIP_CLOSE_NUM" + getUserId(), 0);
    }

    private void ayf() {
        this.dPj = 0;
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("FRS_HOT_LIVE_TIP_CLOSE_NUM" + getUserId(), this.dPj);
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
        if (this.cam != null) {
            this.cam.avy();
        }
        e.ns().removeCallbacks(this.dPq);
        if (this.dPo != null) {
            this.dPo.onDestory();
        }
    }
}
