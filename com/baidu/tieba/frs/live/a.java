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
    private au ccn;
    private i dFH;
    private TextView dOW;
    private FrameLayout dSl;
    private ImageView dSm;
    private int dSo;
    private String dSp;
    private AlaLiveInfoCoreData dSq;
    private AlaLiveInfoListCoreData dSr;
    private c dSs;
    private int mForumId;
    private boolean isFirst = true;
    private c.a dSt = new c.a() { // from class: com.baidu.tieba.frs.live.a.1
        @Override // com.baidu.tieba.frs.live.c.a
        public void a(FrsLiveTipResponseMessage frsLiveTipResponseMessage) {
            if (frsLiveTipResponseMessage != null) {
                a.this.dSo = frsLiveTipResponseMessage.remindType;
                a.this.dSp = frsLiveTipResponseMessage.remindText;
                a.this.dSq = frsLiveTipResponseMessage.infoCoreData;
                a.this.dSr = frsLiveTipResponseMessage.listCoreData;
                if (a.this.ccn != null) {
                    a.this.ccn.aww();
                }
                if (a.this.dSo != 0) {
                    a.this.azc();
                }
            }
        }
    };
    private Runnable dSu = new Runnable() { // from class: com.baidu.tieba.frs.live.a.2
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.dSs != null) {
                a.this.dSs.nF(a.this.mForumId);
            }
        }
    };
    private int dSn = azh();

    public a(i iVar, int i) {
        this.dFH = iVar;
        this.mForumId = i;
    }

    public void azb() {
        if (this.dFH != null && this.dFH.isAdded()) {
            if (System.currentTimeMillis() - getLastShowTime() >= 1800000) {
                if (this.dFH.avc() && isFirst()) {
                    this.isFirst = false;
                    return;
                }
                if (this.dSs == null) {
                    this.dSs = new c(this.dSt);
                }
                e.ns().removeCallbacks(this.dSu);
                e.ns().postDelayed(this.dSu, TbConfig.NOTIFY_SOUND_INTERVAL);
            }
        }
    }

    public void azc() {
        if (!StringUtils.isNull(this.dSp) && this.dSq != null) {
            if (this.dSo != 2 || azh() < 3) {
                bx(this.dFH.getPageContext().getPageActivity());
                if (this.dOW != null) {
                    this.dOW.setText(this.dSp);
                }
                onChangeSkinType();
                Ye();
                saveLastShowTime();
            }
        }
    }

    public void azd() {
        if (this.dFH != null) {
            this.dFH.auR().nT(49);
        }
    }

    private void onChangeSkinType() {
        aj.s(this.dSl, d.f.bg_frs_hot_live_tip_selector);
        aj.r(this.dOW, d.C0141d.cp_cont_i);
        aj.c(this.dSm, d.f.icon_home_card_close_white);
        this.dOW.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, aj.getDrawable(d.f.icon_arrow_more_white), (Drawable) null);
    }

    private void bx(Context context) {
        if (context != null && this.dSl == null) {
            this.dSl = (FrameLayout) LayoutInflater.from(context).inflate(d.h.frs_hot_live_tip, (ViewGroup) null);
            this.dSl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.live.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.aze();
                }
            });
            this.dOW = (TextView) this.dSl.findViewById(d.g.frs_hot_live_tip_content);
            this.dSm = (ImageView) this.dSl.findViewById(d.g.frs_hot_live_tip_close);
            this.dSm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.live.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.azf();
                }
            });
            onChangeSkinType();
        }
    }

    private void Ye() {
        k auT;
        FrameLayout frameLayout;
        if (this.dFH != null && (auT = this.dFH.auT()) != null && auT.getListView() != null && (frameLayout = (FrameLayout) auT.avY()) != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, l.t(TbadkCoreApplication.getInst(), d.e.ds56));
            if (auT.avE() != null && auT.avE().getLayoutParams() != null) {
                layoutParams.topMargin = auT.avE().getLayoutParams().height;
            } else {
                layoutParams.topMargin = 0;
            }
            if (this.ccn == null) {
                this.ccn = new au();
            }
            if (this.dSo == 2) {
                this.ccn.a(this.dSl, frameLayout, layoutParams, 5000);
            } else if (this.dSo == 1) {
                this.ccn.a(this.dSl, frameLayout, layoutParams);
                TiebaStatic.log(new ak("c12539"));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aze() {
        azi();
        if (this.dSq != null && this.dFH != null && this.dFH.isAdded()) {
            boolean equals = TextUtils.equals(getUserId(), String.valueOf(this.dSq.userID));
            String str = "";
            if (this.dSo == 1) {
                str = AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_FRS_FOLLOWED_LIVE_TIP;
                TiebaStatic.log(new ak("c12540"));
                if (this.ccn != null) {
                    this.ccn.hideTip();
                }
            } else if (this.dSo == 2) {
                str = AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_FRS_HOT_LIVE_TIP;
                TiebaStatic.log(new ak("c12331"));
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(this.dFH.getPageContext().getPageActivity(), this.dSq, this.dSr, str, getUserId(), equals, null, null)));
            if (this.dFH.avl().bas().isGameForumType()) {
                CustomMessage customMessage = new CustomMessage(2001622);
                customMessage.setTag(this.dFH.getBaseFragmentActivity().getUniqueId());
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2001622);
                customResponsedMessage.setOrginalMessage(customMessage);
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                return;
            }
            e.ns().post(new Runnable() { // from class: com.baidu.tieba.frs.live.a.5
                @Override // java.lang.Runnable
                public void run() {
                    a.this.azd();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void azf() {
        if (this.dSo == 2) {
            azg();
        }
        if (this.ccn != null) {
            this.ccn.hideTip();
        }
    }

    private void azg() {
        this.dSn++;
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("FRS_HOT_LIVE_TIP_CLOSE_NUM" + getUserId(), this.dSn);
    }

    private int azh() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("FRS_HOT_LIVE_TIP_CLOSE_NUM" + getUserId(), 0);
    }

    private void azi() {
        this.dSn = 0;
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("FRS_HOT_LIVE_TIP_CLOSE_NUM" + getUserId(), this.dSn);
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
        if (this.ccn != null) {
            this.ccn.aww();
        }
        e.ns().removeCallbacks(this.dSu);
        if (this.dSs != null) {
            this.dSs.onDestory();
        }
    }
}
