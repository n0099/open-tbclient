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
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.ala.AlaLiveInfoListCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.e;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.as;
import com.baidu.tieba.frs.k;
import com.baidu.tieba.frs.live.c;
/* loaded from: classes6.dex */
public class a {
    private as bLf;
    private FrsFragment dBO;
    private TextView dMx;
    private FrameLayout dRA;
    private ImageView dRB;
    private int dRD;
    private String dRE;
    private AlaLiveInfoCoreData dRF;
    private AlaLiveInfoListCoreData dRG;
    private c dRH;
    private int mForumId;
    private boolean isFirst = true;
    private c.a dRI = new c.a() { // from class: com.baidu.tieba.frs.live.a.1
        @Override // com.baidu.tieba.frs.live.c.a
        public void a(FrsLiveTipResponseMessage frsLiveTipResponseMessage) {
            if (frsLiveTipResponseMessage != null) {
                a.this.dRD = frsLiveTipResponseMessage.remindType;
                a.this.dRE = frsLiveTipResponseMessage.remindText;
                a.this.dRF = frsLiveTipResponseMessage.infoCoreData;
                a.this.dRG = frsLiveTipResponseMessage.listCoreData;
                if (a.this.bLf != null) {
                    a.this.bLf.aBx();
                }
                if (a.this.dRD != 0) {
                    a.this.aEN();
                }
            }
        }
    };
    private Runnable dRJ = new Runnable() { // from class: com.baidu.tieba.frs.live.a.2
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.dRH != null) {
                a.this.dRH.mr(a.this.mForumId);
            }
        }
    };
    private int dRC = aES();

    public a(FrsFragment frsFragment, int i) {
        this.dBO = frsFragment;
        this.mForumId = i;
    }

    public void aEM() {
        if (this.dBO != null && this.dBO.isAdded()) {
            if (System.currentTimeMillis() - getLastShowTime() >= 1800000) {
                if (this.dBO.azJ() && isFirst()) {
                    this.isFirst = false;
                    return;
                }
                if (this.dRH == null) {
                    this.dRH = new c(this.dRI);
                }
                e.jI().removeCallbacks(this.dRJ);
                e.jI().postDelayed(this.dRJ, 5000L);
            }
        }
    }

    public void aEN() {
        if (!StringUtils.isNull(this.dRE) && this.dRF != null) {
            if (this.dRD != 2 || aES() < 3) {
                bJ(this.dBO.getPageContext().getPageActivity());
                if (this.dMx != null) {
                    this.dMx.setText(this.dRE);
                }
                onChangeSkinType();
                amI();
                saveLastShowTime();
            }
        }
    }

    public void aEO() {
        if (this.dBO != null) {
            this.dBO.azy().mQ(49);
        }
    }

    private void onChangeSkinType() {
        al.i(this.dRA, e.f.bg_frs_hot_live_tip_selector);
        al.h(this.dMx, e.d.cp_cont_i);
        al.c(this.dRB, e.f.icon_home_card_close_white);
        this.dMx.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(e.f.icon_arrow_more_white), (Drawable) null);
    }

    private void bJ(Context context) {
        if (context != null && this.dRA == null) {
            this.dRA = (FrameLayout) LayoutInflater.from(context).inflate(e.h.frs_hot_live_tip, (ViewGroup) null);
            this.dRA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.live.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.aEP();
                }
            });
            this.dMx = (TextView) this.dRA.findViewById(e.g.frs_hot_live_tip_content);
            this.dRB = (ImageView) this.dRA.findViewById(e.g.frs_hot_live_tip_close);
            this.dRB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.live.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.aEQ();
                }
            });
            onChangeSkinType();
        }
    }

    private void amI() {
        k azA;
        FrameLayout frameLayout;
        if (this.dBO != null && (azA = this.dBO.azA()) != null && azA.getListView() != null && (frameLayout = (FrameLayout) azA.aAJ()) != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, l.h(TbadkCoreApplication.getInst(), e.C0175e.ds56));
            if (azA.aAo() != null && azA.aAo().getLayoutParams() != null) {
                layoutParams.topMargin = azA.aAo().getLayoutParams().height;
            } else {
                layoutParams.topMargin = 0;
            }
            if (this.bLf == null) {
                this.bLf = new as();
            }
            if (this.dRD == 2) {
                this.bLf.a(this.dRA, frameLayout, layoutParams, 5000);
            } else if (this.dRD == 1) {
                this.bLf.a(this.dRA, frameLayout, layoutParams);
                TiebaStatic.log(new am("c12539"));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aEP() {
        aET();
        if (this.dRF != null && this.dBO != null && this.dBO.isAdded()) {
            boolean equals = TextUtils.equals(getUserId(), String.valueOf(this.dRF.userID));
            String str = "";
            if (this.dRD == 1) {
                str = AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_FRS_FOLLOWED_LIVE_TIP;
                TiebaStatic.log(new am("c12540"));
                if (this.bLf != null) {
                    this.bLf.hideTip();
                }
            } else if (this.dRD == 2) {
                str = AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_FRS_HOT_LIVE_TIP;
                TiebaStatic.log(new am("c12331"));
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(this.dBO.getPageContext().getPageActivity(), this.dRF, this.dRG, str, getUserId(), equals, null, null)));
            if (this.dBO.azR().beT().isGameForumType()) {
                CustomMessage customMessage = new CustomMessage(2001622);
                customMessage.setTag(this.dBO.getBaseFragmentActivity().getUniqueId());
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2001622);
                customResponsedMessage.setOrginalMessage(customMessage);
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                return;
            }
            com.baidu.adp.lib.g.e.jI().post(new Runnable() { // from class: com.baidu.tieba.frs.live.a.5
                @Override // java.lang.Runnable
                public void run() {
                    a.this.aEO();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aEQ() {
        if (this.dRD == 2) {
            aER();
        }
        if (this.bLf != null) {
            this.bLf.hideTip();
        }
    }

    private void aER() {
        this.dRC++;
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("FRS_HOT_LIVE_TIP_CLOSE_NUM" + getUserId(), this.dRC);
    }

    private int aES() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("FRS_HOT_LIVE_TIP_CLOSE_NUM" + getUserId(), 0);
    }

    private void aET() {
        this.dRC = 0;
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("FRS_HOT_LIVE_TIP_CLOSE_NUM" + getUserId(), this.dRC);
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
        if (this.bLf != null) {
            this.bLf.aBx();
        }
        com.baidu.adp.lib.g.e.jI().removeCallbacks(this.dRJ);
        if (this.dRH != null) {
            this.dRH.onDestory();
        }
    }
}
