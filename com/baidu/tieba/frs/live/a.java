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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.f;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.as;
import com.baidu.tieba.frs.k;
import com.baidu.tieba.frs.live.c;
/* loaded from: classes2.dex */
public class a {
    private as bwL;
    private FrameLayout dCO;
    private ImageView dCP;
    private int dCR;
    private String dCS;
    private AlaLiveInfoCoreData dCT;
    private AlaLiveInfoListCoreData dCU;
    private c dCV;
    private FrsFragment dnP;
    private TextView dxO;
    private int mForumId;
    private boolean isFirst = true;
    private c.a dCW = new c.a() { // from class: com.baidu.tieba.frs.live.a.1
        @Override // com.baidu.tieba.frs.live.c.a
        public void a(FrsLiveTipResponseMessage frsLiveTipResponseMessage) {
            if (frsLiveTipResponseMessage != null) {
                a.this.dCR = frsLiveTipResponseMessage.remindType;
                a.this.dCS = frsLiveTipResponseMessage.remindText;
                a.this.dCT = frsLiveTipResponseMessage.infoCoreData;
                a.this.dCU = frsLiveTipResponseMessage.listCoreData;
                if (a.this.bwL != null) {
                    a.this.bwL.avR();
                }
                if (a.this.dCR != 0) {
                    a.this.azm();
                }
            }
        }
    };
    private Runnable dCX = new Runnable() { // from class: com.baidu.tieba.frs.live.a.2
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.dCV != null) {
                a.this.dCV.lr(a.this.mForumId);
            }
        }
    };
    private int dCQ = azr();

    public a(FrsFragment frsFragment, int i) {
        this.dnP = frsFragment;
        this.mForumId = i;
    }

    public void azl() {
        if (this.dnP != null && this.dnP.isAdded()) {
            if (System.currentTimeMillis() - getLastShowTime() >= 1800000) {
                if (this.dnP.auu() && isFirst()) {
                    this.isFirst = false;
                    return;
                }
                if (this.dCV == null) {
                    this.dCV = new c(this.dCW);
                }
                e.in().removeCallbacks(this.dCX);
                e.in().postDelayed(this.dCX, TbConfig.NOTIFY_SOUND_INTERVAL);
            }
        }
    }

    public void azm() {
        if (!StringUtils.isNull(this.dCS) && this.dCT != null) {
            if (this.dCR != 2 || azr() < 3) {
                aW(this.dnP.getPageContext().getPageActivity());
                if (this.dxO != null) {
                    this.dxO.setText(this.dCS);
                }
                onChangeSkinType();
                ahs();
                saveLastShowTime();
            }
        }
    }

    public void azn() {
        if (this.dnP != null) {
            this.dnP.auj().lQ(49);
        }
    }

    private void onChangeSkinType() {
        am.i(this.dCO, f.C0146f.bg_frs_hot_live_tip_selector);
        am.h(this.dxO, f.d.cp_cont_i);
        am.c(this.dCP, f.C0146f.icon_home_card_close_white);
        this.dxO.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(f.C0146f.icon_arrow_more_white), (Drawable) null);
    }

    private void aW(Context context) {
        if (context != null && this.dCO == null) {
            this.dCO = (FrameLayout) LayoutInflater.from(context).inflate(f.h.frs_hot_live_tip, (ViewGroup) null);
            this.dCO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.live.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.azo();
                }
            });
            this.dxO = (TextView) this.dCO.findViewById(f.g.frs_hot_live_tip_content);
            this.dCP = (ImageView) this.dCO.findViewById(f.g.frs_hot_live_tip_close);
            this.dCP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.live.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.azp();
                }
            });
            onChangeSkinType();
        }
    }

    private void ahs() {
        k aul;
        FrameLayout frameLayout;
        if (this.dnP != null && (aul = this.dnP.aul()) != null && aul.getListView() != null && (frameLayout = (FrameLayout) aul.avu()) != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, l.f(TbadkCoreApplication.getInst(), f.e.ds56));
            if (aul.ava() != null && aul.ava().getLayoutParams() != null) {
                layoutParams.topMargin = aul.ava().getLayoutParams().height;
            } else {
                layoutParams.topMargin = 0;
            }
            if (this.bwL == null) {
                this.bwL = new as();
            }
            if (this.dCR == 2) {
                this.bwL.a(this.dCO, frameLayout, layoutParams, 5000);
            } else if (this.dCR == 1) {
                this.bwL.a(this.dCO, frameLayout, layoutParams);
                TiebaStatic.log(new an("c12539"));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void azo() {
        azs();
        if (this.dCT != null && this.dnP != null && this.dnP.isAdded()) {
            boolean equals = TextUtils.equals(getUserId(), String.valueOf(this.dCT.userID));
            String str = "";
            if (this.dCR == 1) {
                str = AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_FRS_FOLLOWED_LIVE_TIP;
                TiebaStatic.log(new an("c12540"));
                if (this.bwL != null) {
                    this.bwL.hideTip();
                }
            } else if (this.dCR == 2) {
                str = AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_FRS_HOT_LIVE_TIP;
                TiebaStatic.log(new an("c12331"));
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(this.dnP.getPageContext().getPageActivity(), this.dCT, this.dCU, str, getUserId(), equals, null, null)));
            if (this.dnP.auC().aZg().isGameForumType()) {
                CustomMessage customMessage = new CustomMessage(2001622);
                customMessage.setTag(this.dnP.getBaseFragmentActivity().getUniqueId());
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2001622);
                customResponsedMessage.setOrginalMessage(customMessage);
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                return;
            }
            e.in().post(new Runnable() { // from class: com.baidu.tieba.frs.live.a.5
                @Override // java.lang.Runnable
                public void run() {
                    a.this.azn();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void azp() {
        if (this.dCR == 2) {
            azq();
        }
        if (this.bwL != null) {
            this.bwL.hideTip();
        }
    }

    private void azq() {
        this.dCQ++;
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("FRS_HOT_LIVE_TIP_CLOSE_NUM" + getUserId(), this.dCQ);
    }

    private int azr() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("FRS_HOT_LIVE_TIP_CLOSE_NUM" + getUserId(), 0);
    }

    private void azs() {
        this.dCQ = 0;
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("FRS_HOT_LIVE_TIP_CLOSE_NUM" + getUserId(), this.dCQ);
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
        if (this.bwL != null) {
            this.bwL.avR();
        }
        e.in().removeCallbacks(this.dCX);
        if (this.dCV != null) {
            this.dCV.onDestory();
        }
    }
}
