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
import com.baidu.mapapi.UIMsg;
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
    private as bPI;
    private FrsFragment dMs;
    private TextView dWV;
    private FrameLayout ecb;
    private ImageView ecc;
    private int ece;
    private String ecf;
    private AlaLiveInfoCoreData ecg;
    private AlaLiveInfoListCoreData ech;
    private c eci;
    private int mForumId;
    private boolean isFirst = true;
    private c.a ecj = new c.a() { // from class: com.baidu.tieba.frs.live.a.1
        @Override // com.baidu.tieba.frs.live.c.a
        public void a(FrsLiveTipResponseMessage frsLiveTipResponseMessage) {
            if (frsLiveTipResponseMessage != null) {
                a.this.ece = frsLiveTipResponseMessage.remindType;
                a.this.ecf = frsLiveTipResponseMessage.remindText;
                a.this.ecg = frsLiveTipResponseMessage.infoCoreData;
                a.this.ech = frsLiveTipResponseMessage.listCoreData;
                if (a.this.bPI != null) {
                    a.this.bPI.aDu();
                }
                if (a.this.ece != 0) {
                    a.this.aGK();
                }
            }
        }
    };
    private Runnable eck = new Runnable() { // from class: com.baidu.tieba.frs.live.a.2
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.eci != null) {
                a.this.eci.nm(a.this.mForumId);
            }
        }
    };
    private int ecd = aGP();

    public a(FrsFragment frsFragment, int i) {
        this.dMs = frsFragment;
        this.mForumId = i;
    }

    public void aGJ() {
        if (this.dMs != null && this.dMs.isAdded()) {
            if (System.currentTimeMillis() - getLastShowTime() >= 1800000) {
                if (this.dMs.aBG() && isFirst()) {
                    this.isFirst = false;
                    return;
                }
                if (this.eci == null) {
                    this.eci = new c(this.ecj);
                }
                e.jG().removeCallbacks(this.eck);
                e.jG().postDelayed(this.eck, 5000L);
            }
        }
    }

    public void aGK() {
        if (!StringUtils.isNull(this.ecf) && this.ecg != null) {
            if (this.ece != 2 || aGP() < 3) {
                initView(this.dMs.getPageContext().getPageActivity());
                if (this.dWV != null) {
                    this.dWV.setText(this.ecf);
                }
                onChangeSkinType();
                aoI();
                saveLastShowTime();
            }
        }
    }

    public void aGL() {
        if (this.dMs != null) {
            this.dMs.aBv().nL(49);
        }
    }

    private void onChangeSkinType() {
        al.i(this.ecb, e.f.bg_frs_hot_live_tip_selector);
        al.h(this.dWV, e.d.cp_cont_i);
        al.c(this.ecc, e.f.icon_home_card_close_white);
        this.dWV.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(e.f.icon_arrow_more_white), (Drawable) null);
    }

    private void initView(Context context) {
        if (context != null && this.ecb == null) {
            this.ecb = (FrameLayout) LayoutInflater.from(context).inflate(e.h.frs_hot_live_tip, (ViewGroup) null);
            this.ecb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.live.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.aGM();
                }
            });
            this.dWV = (TextView) this.ecb.findViewById(e.g.frs_hot_live_tip_content);
            this.ecc = (ImageView) this.ecb.findViewById(e.g.frs_hot_live_tip_close);
            this.ecc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.live.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.aGN();
                }
            });
            onChangeSkinType();
        }
    }

    private void aoI() {
        k aBx;
        FrameLayout frameLayout;
        if (this.dMs != null && (aBx = this.dMs.aBx()) != null && aBx.getListView() != null && (frameLayout = (FrameLayout) aBx.aCG()) != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, l.h(TbadkCoreApplication.getInst(), e.C0210e.ds56));
            if (aBx.aCl() != null && aBx.aCl().getLayoutParams() != null) {
                layoutParams.topMargin = aBx.aCl().getLayoutParams().height;
            } else {
                layoutParams.topMargin = 0;
            }
            if (this.bPI == null) {
                this.bPI = new as();
            }
            if (this.ece == 2) {
                this.bPI.a(this.ecb, frameLayout, layoutParams, UIMsg.m_AppUI.MSG_APP_GPS);
            } else if (this.ece == 1) {
                this.bPI.a(this.ecb, frameLayout, layoutParams);
                TiebaStatic.log(new am("c12539"));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aGM() {
        aGQ();
        if (this.ecg != null && this.dMs != null && this.dMs.isAdded()) {
            boolean equals = TextUtils.equals(getUserId(), String.valueOf(this.ecg.userID));
            String str = "";
            if (this.ece == 1) {
                str = AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_FRS_FOLLOWED_LIVE_TIP;
                TiebaStatic.log(new am("c12540"));
                if (this.bPI != null) {
                    this.bPI.hideTip();
                }
            } else if (this.ece == 2) {
                str = AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_FRS_HOT_LIVE_TIP;
                TiebaStatic.log(new am("c12331"));
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(this.dMs.getPageContext().getPageActivity(), this.ecg, this.ech, str, getUserId(), equals, null, null)));
            if (this.dMs.aBO().bgT().isGameForumType()) {
                CustomMessage customMessage = new CustomMessage(2001622);
                customMessage.setTag(this.dMs.getBaseFragmentActivity().getUniqueId());
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2001622);
                customResponsedMessage.setOrginalMessage(customMessage);
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                return;
            }
            com.baidu.adp.lib.g.e.jG().post(new Runnable() { // from class: com.baidu.tieba.frs.live.a.5
                @Override // java.lang.Runnable
                public void run() {
                    a.this.aGL();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aGN() {
        if (this.ece == 2) {
            aGO();
        }
        if (this.bPI != null) {
            this.bPI.hideTip();
        }
    }

    private void aGO() {
        this.ecd++;
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("FRS_HOT_LIVE_TIP_CLOSE_NUM" + getUserId(), this.ecd);
    }

    private int aGP() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("FRS_HOT_LIVE_TIP_CLOSE_NUM" + getUserId(), 0);
    }

    private void aGQ() {
        this.ecd = 0;
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("FRS_HOT_LIVE_TIP_CLOSE_NUM" + getUserId(), this.ecd);
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
        if (this.bPI != null) {
            this.bPI.aDu();
        }
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.eck);
        if (this.eci != null) {
            this.eci.onDestory();
        }
    }
}
