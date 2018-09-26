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
/* loaded from: classes2.dex */
public class a {
    private as bCA;
    private TextView dEy;
    private FrameLayout dJE;
    private ImageView dJF;
    private int dJH;
    private String dJI;
    private AlaLiveInfoCoreData dJJ;
    private AlaLiveInfoListCoreData dJK;
    private c dJL;
    private FrsFragment dtN;
    private int mForumId;
    private boolean isFirst = true;
    private c.a dJM = new c.a() { // from class: com.baidu.tieba.frs.live.a.1
        @Override // com.baidu.tieba.frs.live.c.a
        public void a(FrsLiveTipResponseMessage frsLiveTipResponseMessage) {
            if (frsLiveTipResponseMessage != null) {
                a.this.dJH = frsLiveTipResponseMessage.remindType;
                a.this.dJI = frsLiveTipResponseMessage.remindText;
                a.this.dJJ = frsLiveTipResponseMessage.infoCoreData;
                a.this.dJK = frsLiveTipResponseMessage.listCoreData;
                if (a.this.bCA != null) {
                    a.this.bCA.ayc();
                }
                if (a.this.dJH != 0) {
                    a.this.aBu();
                }
            }
        }
    };
    private Runnable dJN = new Runnable() { // from class: com.baidu.tieba.frs.live.a.2
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.dJL != null) {
                a.this.dJL.lT(a.this.mForumId);
            }
        }
    };
    private int dJG = aBz();

    public a(FrsFragment frsFragment, int i) {
        this.dtN = frsFragment;
        this.mForumId = i;
    }

    public void aBt() {
        if (this.dtN != null && this.dtN.isAdded()) {
            if (System.currentTimeMillis() - getLastShowTime() >= 1800000) {
                if (this.dtN.awn() && isFirst()) {
                    this.isFirst = false;
                    return;
                }
                if (this.dJL == null) {
                    this.dJL = new c(this.dJM);
                }
                e.jt().removeCallbacks(this.dJN);
                e.jt().postDelayed(this.dJN, 5000L);
            }
        }
    }

    public void aBu() {
        if (!StringUtils.isNull(this.dJI) && this.dJJ != null) {
            if (this.dJH != 2 || aBz() < 3) {
                bB(this.dtN.getPageContext().getPageActivity());
                if (this.dEy != null) {
                    this.dEy.setText(this.dJI);
                }
                onChangeSkinType();
                aje();
                saveLastShowTime();
            }
        }
    }

    public void aBv() {
        if (this.dtN != null) {
            this.dtN.awc().ms(49);
        }
    }

    private void onChangeSkinType() {
        al.i(this.dJE, e.f.bg_frs_hot_live_tip_selector);
        al.h(this.dEy, e.d.cp_cont_i);
        al.c(this.dJF, e.f.icon_home_card_close_white);
        this.dEy.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(e.f.icon_arrow_more_white), (Drawable) null);
    }

    private void bB(Context context) {
        if (context != null && this.dJE == null) {
            this.dJE = (FrameLayout) LayoutInflater.from(context).inflate(e.h.frs_hot_live_tip, (ViewGroup) null);
            this.dJE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.live.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.aBw();
                }
            });
            this.dEy = (TextView) this.dJE.findViewById(e.g.frs_hot_live_tip_content);
            this.dJF = (ImageView) this.dJE.findViewById(e.g.frs_hot_live_tip_close);
            this.dJF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.live.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.aBx();
                }
            });
            onChangeSkinType();
        }
    }

    private void aje() {
        k awe;
        FrameLayout frameLayout;
        if (this.dtN != null && (awe = this.dtN.awe()) != null && awe.getListView() != null && (frameLayout = (FrameLayout) awe.axo()) != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, l.h(TbadkCoreApplication.getInst(), e.C0141e.ds56));
            if (awe.awT() != null && awe.awT().getLayoutParams() != null) {
                layoutParams.topMargin = awe.awT().getLayoutParams().height;
            } else {
                layoutParams.topMargin = 0;
            }
            if (this.bCA == null) {
                this.bCA = new as();
            }
            if (this.dJH == 2) {
                this.bCA.a(this.dJE, frameLayout, layoutParams, 5000);
            } else if (this.dJH == 1) {
                this.bCA.a(this.dJE, frameLayout, layoutParams);
                TiebaStatic.log(new am("c12539"));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBw() {
        aBA();
        if (this.dJJ != null && this.dtN != null && this.dtN.isAdded()) {
            boolean equals = TextUtils.equals(getUserId(), String.valueOf(this.dJJ.userID));
            String str = "";
            if (this.dJH == 1) {
                str = AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_FRS_FOLLOWED_LIVE_TIP;
                TiebaStatic.log(new am("c12540"));
                if (this.bCA != null) {
                    this.bCA.hideTip();
                }
            } else if (this.dJH == 2) {
                str = AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_FRS_HOT_LIVE_TIP;
                TiebaStatic.log(new am("c12331"));
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(this.dtN.getPageContext().getPageActivity(), this.dJJ, this.dJK, str, getUserId(), equals, null, null)));
            if (this.dtN.awv().bbH().isGameForumType()) {
                CustomMessage customMessage = new CustomMessage(2001622);
                customMessage.setTag(this.dtN.getBaseFragmentActivity().getUniqueId());
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2001622);
                customResponsedMessage.setOrginalMessage(customMessage);
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                return;
            }
            com.baidu.adp.lib.g.e.jt().post(new Runnable() { // from class: com.baidu.tieba.frs.live.a.5
                @Override // java.lang.Runnable
                public void run() {
                    a.this.aBv();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBx() {
        if (this.dJH == 2) {
            aBy();
        }
        if (this.bCA != null) {
            this.bCA.hideTip();
        }
    }

    private void aBy() {
        this.dJG++;
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("FRS_HOT_LIVE_TIP_CLOSE_NUM" + getUserId(), this.dJG);
    }

    private int aBz() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("FRS_HOT_LIVE_TIP_CLOSE_NUM" + getUserId(), 0);
    }

    private void aBA() {
        this.dJG = 0;
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("FRS_HOT_LIVE_TIP_CLOSE_NUM" + getUserId(), this.dJG);
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
        if (this.bCA != null) {
            this.bCA.ayc();
        }
        com.baidu.adp.lib.g.e.jt().removeCallbacks(this.dJN);
        if (this.dJL != null) {
            this.dJL.onDestory();
        }
    }
}
