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
    private as bLQ;
    private FrsFragment dDf;
    private TextView dNB;
    private FrameLayout dSH;
    private ImageView dSI;
    private int dSK;
    private String dSL;
    private AlaLiveInfoCoreData dSM;
    private AlaLiveInfoListCoreData dSN;
    private c dSO;
    private int mForumId;
    private boolean isFirst = true;
    private c.a dSP = new c.a() { // from class: com.baidu.tieba.frs.live.a.1
        @Override // com.baidu.tieba.frs.live.c.a
        public void a(FrsLiveTipResponseMessage frsLiveTipResponseMessage) {
            if (frsLiveTipResponseMessage != null) {
                a.this.dSK = frsLiveTipResponseMessage.remindType;
                a.this.dSL = frsLiveTipResponseMessage.remindText;
                a.this.dSM = frsLiveTipResponseMessage.infoCoreData;
                a.this.dSN = frsLiveTipResponseMessage.listCoreData;
                if (a.this.bLQ != null) {
                    a.this.bLQ.aAV();
                }
                if (a.this.dSK != 0) {
                    a.this.aEj();
                }
            }
        }
    };
    private Runnable dSQ = new Runnable() { // from class: com.baidu.tieba.frs.live.a.2
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.dSO != null) {
                a.this.dSO.mJ(a.this.mForumId);
            }
        }
    };
    private int dSJ = aEo();

    public a(FrsFragment frsFragment, int i) {
        this.dDf = frsFragment;
        this.mForumId = i;
    }

    public void aEi() {
        if (this.dDf != null && this.dDf.isAdded()) {
            if (System.currentTimeMillis() - getLastShowTime() >= 1800000) {
                if (this.dDf.azh() && isFirst()) {
                    this.isFirst = false;
                    return;
                }
                if (this.dSO == null) {
                    this.dSO = new c(this.dSP);
                }
                e.jG().removeCallbacks(this.dSQ);
                e.jG().postDelayed(this.dSQ, 5000L);
            }
        }
    }

    public void aEj() {
        if (!StringUtils.isNull(this.dSL) && this.dSM != null) {
            if (this.dSK != 2 || aEo() < 3) {
                initView(this.dDf.getPageContext().getPageActivity());
                if (this.dNB != null) {
                    this.dNB.setText(this.dSL);
                }
                onChangeSkinType();
                ami();
                saveLastShowTime();
            }
        }
    }

    public void aEk() {
        if (this.dDf != null) {
            this.dDf.ayW().ni(49);
        }
    }

    private void onChangeSkinType() {
        al.i(this.dSH, e.f.bg_frs_hot_live_tip_selector);
        al.h(this.dNB, e.d.cp_cont_i);
        al.c(this.dSI, e.f.icon_home_card_close_white);
        this.dNB.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(e.f.icon_arrow_more_white), (Drawable) null);
    }

    private void initView(Context context) {
        if (context != null && this.dSH == null) {
            this.dSH = (FrameLayout) LayoutInflater.from(context).inflate(e.h.frs_hot_live_tip, (ViewGroup) null);
            this.dSH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.live.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.aEl();
                }
            });
            this.dNB = (TextView) this.dSH.findViewById(e.g.frs_hot_live_tip_content);
            this.dSI = (ImageView) this.dSH.findViewById(e.g.frs_hot_live_tip_close);
            this.dSI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.live.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.aEm();
                }
            });
            onChangeSkinType();
        }
    }

    private void ami() {
        k ayY;
        FrameLayout frameLayout;
        if (this.dDf != null && (ayY = this.dDf.ayY()) != null && ayY.getListView() != null && (frameLayout = (FrameLayout) ayY.aAh()) != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, l.h(TbadkCoreApplication.getInst(), e.C0200e.ds56));
            if (ayY.azM() != null && ayY.azM().getLayoutParams() != null) {
                layoutParams.topMargin = ayY.azM().getLayoutParams().height;
            } else {
                layoutParams.topMargin = 0;
            }
            if (this.bLQ == null) {
                this.bLQ = new as();
            }
            if (this.dSK == 2) {
                this.bLQ.a(this.dSH, frameLayout, layoutParams, UIMsg.m_AppUI.MSG_APP_GPS);
            } else if (this.dSK == 1) {
                this.bLQ.a(this.dSH, frameLayout, layoutParams);
                TiebaStatic.log(new am("c12539"));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aEl() {
        aEp();
        if (this.dSM != null && this.dDf != null && this.dDf.isAdded()) {
            boolean equals = TextUtils.equals(getUserId(), String.valueOf(this.dSM.userID));
            String str = "";
            if (this.dSK == 1) {
                str = AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_FRS_FOLLOWED_LIVE_TIP;
                TiebaStatic.log(new am("c12540"));
                if (this.bLQ != null) {
                    this.bLQ.hideTip();
                }
            } else if (this.dSK == 2) {
                str = AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_FRS_HOT_LIVE_TIP;
                TiebaStatic.log(new am("c12331"));
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(this.dDf.getPageContext().getPageActivity(), this.dSM, this.dSN, str, getUserId(), equals, null, null)));
            if (this.dDf.azp().ber().isGameForumType()) {
                CustomMessage customMessage = new CustomMessage(2001622);
                customMessage.setTag(this.dDf.getBaseFragmentActivity().getUniqueId());
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2001622);
                customResponsedMessage.setOrginalMessage(customMessage);
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                return;
            }
            com.baidu.adp.lib.g.e.jG().post(new Runnable() { // from class: com.baidu.tieba.frs.live.a.5
                @Override // java.lang.Runnable
                public void run() {
                    a.this.aEk();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aEm() {
        if (this.dSK == 2) {
            aEn();
        }
        if (this.bLQ != null) {
            this.bLQ.hideTip();
        }
    }

    private void aEn() {
        this.dSJ++;
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("FRS_HOT_LIVE_TIP_CLOSE_NUM" + getUserId(), this.dSJ);
    }

    private int aEo() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("FRS_HOT_LIVE_TIP_CLOSE_NUM" + getUserId(), 0);
    }

    private void aEp() {
        this.dSJ = 0;
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("FRS_HOT_LIVE_TIP_CLOSE_NUM" + getUserId(), this.dSJ);
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
        if (this.bLQ != null) {
            this.bLQ.aAV();
        }
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.dSQ);
        if (this.dSO != null) {
            this.dSO.onDestory();
        }
    }
}
