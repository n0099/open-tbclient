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
    private au ccx;
    private i dFP;
    private TextView dPd;
    private FrameLayout dSs;
    private ImageView dSt;
    private int dSv;
    private String dSw;
    private AlaLiveInfoCoreData dSx;
    private AlaLiveInfoListCoreData dSy;
    private c dSz;
    private int mForumId;
    private boolean isFirst = true;
    private c.a dSA = new c.a() { // from class: com.baidu.tieba.frs.live.a.1
        @Override // com.baidu.tieba.frs.live.c.a
        public void a(FrsLiveTipResponseMessage frsLiveTipResponseMessage) {
            if (frsLiveTipResponseMessage != null) {
                a.this.dSv = frsLiveTipResponseMessage.remindType;
                a.this.dSw = frsLiveTipResponseMessage.remindText;
                a.this.dSx = frsLiveTipResponseMessage.infoCoreData;
                a.this.dSy = frsLiveTipResponseMessage.listCoreData;
                if (a.this.ccx != null) {
                    a.this.ccx.awv();
                }
                if (a.this.dSv != 0) {
                    a.this.azb();
                }
            }
        }
    };
    private Runnable dSB = new Runnable() { // from class: com.baidu.tieba.frs.live.a.2
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.dSz != null) {
                a.this.dSz.nF(a.this.mForumId);
            }
        }
    };
    private int dSu = azg();

    public a(i iVar, int i) {
        this.dFP = iVar;
        this.mForumId = i;
    }

    public void aza() {
        if (this.dFP != null && this.dFP.isAdded()) {
            if (System.currentTimeMillis() - getLastShowTime() >= 1800000) {
                if (this.dFP.avc() && isFirst()) {
                    this.isFirst = false;
                    return;
                }
                if (this.dSz == null) {
                    this.dSz = new c(this.dSA);
                }
                e.ns().removeCallbacks(this.dSB);
                e.ns().postDelayed(this.dSB, TbConfig.NOTIFY_SOUND_INTERVAL);
            }
        }
    }

    public void azb() {
        if (!StringUtils.isNull(this.dSw) && this.dSx != null) {
            if (this.dSv != 2 || azg() < 3) {
                bx(this.dFP.getPageContext().getPageActivity());
                if (this.dPd != null) {
                    this.dPd.setText(this.dSw);
                }
                onChangeSkinType();
                Ye();
                saveLastShowTime();
            }
        }
    }

    public void azc() {
        if (this.dFP != null) {
            this.dFP.auR().nT(49);
        }
    }

    private void onChangeSkinType() {
        aj.s(this.dSs, d.f.bg_frs_hot_live_tip_selector);
        aj.r(this.dPd, d.C0140d.cp_cont_i);
        aj.c(this.dSt, d.f.icon_home_card_close_white);
        this.dPd.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, aj.getDrawable(d.f.icon_arrow_more_white), (Drawable) null);
    }

    private void bx(Context context) {
        if (context != null && this.dSs == null) {
            this.dSs = (FrameLayout) LayoutInflater.from(context).inflate(d.h.frs_hot_live_tip, (ViewGroup) null);
            this.dSs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.live.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.azd();
                }
            });
            this.dPd = (TextView) this.dSs.findViewById(d.g.frs_hot_live_tip_content);
            this.dSt = (ImageView) this.dSs.findViewById(d.g.frs_hot_live_tip_close);
            this.dSt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.live.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.aze();
                }
            });
            onChangeSkinType();
        }
    }

    private void Ye() {
        k auT;
        FrameLayout frameLayout;
        if (this.dFP != null && (auT = this.dFP.auT()) != null && auT.getListView() != null && (frameLayout = (FrameLayout) auT.avX()) != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, l.t(TbadkCoreApplication.getInst(), d.e.ds56));
            if (auT.avD() != null && auT.avD().getLayoutParams() != null) {
                layoutParams.topMargin = auT.avD().getLayoutParams().height;
            } else {
                layoutParams.topMargin = 0;
            }
            if (this.ccx == null) {
                this.ccx = new au();
            }
            if (this.dSv == 2) {
                this.ccx.a(this.dSs, frameLayout, layoutParams, 5000);
            } else if (this.dSv == 1) {
                this.ccx.a(this.dSs, frameLayout, layoutParams);
                TiebaStatic.log(new ak("c12539"));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void azd() {
        azh();
        if (this.dSx != null && this.dFP != null && this.dFP.isAdded()) {
            boolean equals = TextUtils.equals(getUserId(), String.valueOf(this.dSx.userID));
            String str = "";
            if (this.dSv == 1) {
                str = AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_FRS_FOLLOWED_LIVE_TIP;
                TiebaStatic.log(new ak("c12540"));
                if (this.ccx != null) {
                    this.ccx.hideTip();
                }
            } else if (this.dSv == 2) {
                str = AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_FRS_HOT_LIVE_TIP;
                TiebaStatic.log(new ak("c12331"));
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(this.dFP.getPageContext().getPageActivity(), this.dSx, this.dSy, str, getUserId(), equals, null, null)));
            if (this.dFP.avl().bas().isGameForumType()) {
                CustomMessage customMessage = new CustomMessage(2001622);
                customMessage.setTag(this.dFP.getBaseFragmentActivity().getUniqueId());
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2001622);
                customResponsedMessage.setOrginalMessage(customMessage);
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                return;
            }
            e.ns().post(new Runnable() { // from class: com.baidu.tieba.frs.live.a.5
                @Override // java.lang.Runnable
                public void run() {
                    a.this.azc();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aze() {
        if (this.dSv == 2) {
            azf();
        }
        if (this.ccx != null) {
            this.ccx.hideTip();
        }
    }

    private void azf() {
        this.dSu++;
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("FRS_HOT_LIVE_TIP_CLOSE_NUM" + getUserId(), this.dSu);
    }

    private int azg() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("FRS_HOT_LIVE_TIP_CLOSE_NUM" + getUserId(), 0);
    }

    private void azh() {
        this.dSu = 0;
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("FRS_HOT_LIVE_TIP_CLOSE_NUM" + getUserId(), this.dSu);
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
        if (this.ccx != null) {
            this.ccx.awv();
        }
        e.ns().removeCallbacks(this.dSB);
        if (this.dSz != null) {
            this.dSz.onDestory();
        }
    }
}
