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
    private au bZX;
    private TextView dHi;
    private FrameLayout dKk;
    private ImageView dKl;
    private int dKn;
    private String dKo;
    private AlaLiveInfoCoreData dKp;
    private AlaLiveInfoListCoreData dKq;
    private c dKr;
    private i dxW;
    private int mForumId;
    private boolean isFirst = true;
    private c.a dKs = new c.a() { // from class: com.baidu.tieba.frs.live.a.1
        @Override // com.baidu.tieba.frs.live.c.a
        public void a(FrsLiveTipResponseMessage frsLiveTipResponseMessage) {
            if (frsLiveTipResponseMessage != null) {
                a.this.dKn = frsLiveTipResponseMessage.remindType;
                a.this.dKo = frsLiveTipResponseMessage.remindText;
                a.this.dKp = frsLiveTipResponseMessage.infoCoreData;
                a.this.dKq = frsLiveTipResponseMessage.listCoreData;
                if (a.this.bZX != null) {
                    a.this.bZX.auq();
                }
                if (a.this.dKn != 0) {
                    a.this.awR();
                }
            }
        }
    };
    private Runnable dKt = new Runnable() { // from class: com.baidu.tieba.frs.live.a.2
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.dKr != null) {
                a.this.dKr.nC(a.this.mForumId);
            }
        }
    };
    private int dKm = awW();

    public a(i iVar, int i) {
        this.dxW = iVar;
        this.mForumId = i;
    }

    public void awQ() {
        if (this.dxW != null && this.dxW.isAdded()) {
            if (System.currentTimeMillis() - getLastShowTime() >= 1800000) {
                if (this.dxW.ate() && isFirst()) {
                    this.isFirst = false;
                    return;
                }
                if (this.dKr == null) {
                    this.dKr = new c(this.dKs);
                }
                e.nr().removeCallbacks(this.dKt);
                e.nr().postDelayed(this.dKt, TbConfig.NOTIFY_SOUND_INTERVAL);
            }
        }
    }

    public void awR() {
        if (!StringUtils.isNull(this.dKo) && this.dKp != null) {
            if (this.dKn != 2 || awW() < 3) {
                bD(this.dxW.getPageContext().getPageActivity());
                if (this.dHi != null) {
                    this.dHi.setText(this.dKo);
                }
                onChangeSkinType();
                Xj();
                saveLastShowTime();
            }
        }
    }

    public void awS() {
        if (this.dxW != null) {
            this.dxW.asT().nQ(49);
        }
    }

    private void onChangeSkinType() {
        aj.s(this.dKk, d.f.bg_frs_hot_live_tip_selector);
        aj.r(this.dHi, d.C0108d.cp_cont_i);
        aj.c(this.dKl, d.f.icon_home_card_close_white);
        this.dHi.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, aj.getDrawable(d.f.icon_arrow_more_white), (Drawable) null);
    }

    private void bD(Context context) {
        if (context != null && this.dKk == null) {
            this.dKk = (FrameLayout) LayoutInflater.from(context).inflate(d.h.frs_hot_live_tip, (ViewGroup) null);
            this.dKk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.live.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.awT();
                }
            });
            this.dHi = (TextView) this.dKk.findViewById(d.g.frs_hot_live_tip_content);
            this.dKl = (ImageView) this.dKk.findViewById(d.g.frs_hot_live_tip_close);
            this.dKl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.live.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.awU();
                }
            });
            onChangeSkinType();
        }
    }

    private void Xj() {
        k asV;
        FrameLayout frameLayout;
        if (this.dxW != null && (asV = this.dxW.asV()) != null && asV.getListView() != null && (frameLayout = (FrameLayout) asV.atN()) != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, l.s(TbadkCoreApplication.getInst(), d.e.ds56));
            if (asV.atv() != null && asV.atv().getLayoutParams() != null) {
                layoutParams.topMargin = asV.atv().getLayoutParams().height;
            } else {
                layoutParams.topMargin = 0;
            }
            if (this.bZX == null) {
                this.bZX = new au();
            }
            if (this.dKn == 2) {
                this.bZX.a(this.dKk, frameLayout, layoutParams, 5000);
            } else if (this.dKn == 1) {
                this.bZX.a(this.dKk, frameLayout, layoutParams);
                TiebaStatic.log(new ak("c12539"));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void awT() {
        awX();
        if (this.dKp != null && this.dxW != null && this.dxW.isAdded()) {
            boolean equals = TextUtils.equals(getUserId(), String.valueOf(this.dKp.userID));
            String str = "";
            if (this.dKn == 1) {
                str = AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_FRS_FOLLOWED_LIVE_TIP;
                TiebaStatic.log(new ak("c12540"));
                if (this.bZX != null) {
                    this.bZX.hideTip();
                }
            } else if (this.dKn == 2) {
                str = AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_FRS_HOT_LIVE_TIP;
                TiebaStatic.log(new ak("c12331"));
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(this.dxW.getPageContext().getPageActivity(), this.dKp, this.dKq, str, getUserId(), equals, null, null)));
            if (this.dxW.atn().aYy().isGameForumType()) {
                CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_GAME_FRS_JUMP_TO_LIVE_TAB);
                customMessage.setTag(this.dxW.getBaseFragmentActivity().getUniqueId());
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_FRS_JUMP_TO_LIVE_TAB);
                customResponsedMessage.setOrginalMessage(customMessage);
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                return;
            }
            e.nr().post(new Runnable() { // from class: com.baidu.tieba.frs.live.a.5
                @Override // java.lang.Runnable
                public void run() {
                    a.this.awS();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void awU() {
        if (this.dKn == 2) {
            awV();
        }
        if (this.bZX != null) {
            this.bZX.hideTip();
        }
    }

    private void awV() {
        this.dKm++;
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("FRS_HOT_LIVE_TIP_CLOSE_NUM" + getUserId(), this.dKm);
    }

    private int awW() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("FRS_HOT_LIVE_TIP_CLOSE_NUM" + getUserId(), 0);
    }

    private void awX() {
        this.dKm = 0;
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("FRS_HOT_LIVE_TIP_CLOSE_NUM" + getUserId(), this.dKm);
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
        if (this.bZX != null) {
            this.bZX.auq();
        }
        e.nr().removeCallbacks(this.dKt);
        if (this.dKr != null) {
            this.dKr.onDestory();
        }
    }
}
