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
    private as bPF;
    private FrsFragment dJE;
    private TextView dUe;
    private FrameLayout dZk;
    private ImageView dZl;
    private int dZn;
    private String dZo;
    private AlaLiveInfoCoreData dZp;
    private AlaLiveInfoListCoreData dZq;
    private c dZr;
    private int mForumId;
    private boolean isFirst = true;
    private c.a dZs = new c.a() { // from class: com.baidu.tieba.frs.live.a.1
        @Override // com.baidu.tieba.frs.live.c.a
        public void a(FrsLiveTipResponseMessage frsLiveTipResponseMessage) {
            if (frsLiveTipResponseMessage != null) {
                a.this.dZn = frsLiveTipResponseMessage.remindType;
                a.this.dZo = frsLiveTipResponseMessage.remindText;
                a.this.dZp = frsLiveTipResponseMessage.infoCoreData;
                a.this.dZq = frsLiveTipResponseMessage.listCoreData;
                if (a.this.bPF != null) {
                    a.this.bPF.aCF();
                }
                if (a.this.dZn != 0) {
                    a.this.aFV();
                }
            }
        }
    };
    private Runnable dZt = new Runnable() { // from class: com.baidu.tieba.frs.live.a.2
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.dZr != null) {
                a.this.dZr.mZ(a.this.mForumId);
            }
        }
    };
    private int dZm = aGa();

    public a(FrsFragment frsFragment, int i) {
        this.dJE = frsFragment;
        this.mForumId = i;
    }

    public void aFU() {
        if (this.dJE != null && this.dJE.isAdded()) {
            if (System.currentTimeMillis() - getLastShowTime() >= 1800000) {
                if (this.dJE.aAR() && isFirst()) {
                    this.isFirst = false;
                    return;
                }
                if (this.dZr == null) {
                    this.dZr = new c(this.dZs);
                }
                e.jG().removeCallbacks(this.dZt);
                e.jG().postDelayed(this.dZt, 5000L);
            }
        }
    }

    public void aFV() {
        if (!StringUtils.isNull(this.dZo) && this.dZp != null) {
            if (this.dZn != 2 || aGa() < 3) {
                initView(this.dJE.getPageContext().getPageActivity());
                if (this.dUe != null) {
                    this.dUe.setText(this.dZo);
                }
                onChangeSkinType();
                anU();
                saveLastShowTime();
            }
        }
    }

    public void aFW() {
        if (this.dJE != null) {
            this.dJE.aAG().ny(49);
        }
    }

    private void onChangeSkinType() {
        al.i(this.dZk, e.f.bg_frs_hot_live_tip_selector);
        al.h(this.dUe, e.d.cp_cont_i);
        al.c(this.dZl, e.f.icon_home_card_close_white);
        this.dUe.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(e.f.icon_arrow_more_white), (Drawable) null);
    }

    private void initView(Context context) {
        if (context != null && this.dZk == null) {
            this.dZk = (FrameLayout) LayoutInflater.from(context).inflate(e.h.frs_hot_live_tip, (ViewGroup) null);
            this.dZk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.live.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.aFX();
                }
            });
            this.dUe = (TextView) this.dZk.findViewById(e.g.frs_hot_live_tip_content);
            this.dZl = (ImageView) this.dZk.findViewById(e.g.frs_hot_live_tip_close);
            this.dZl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.live.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.aFY();
                }
            });
            onChangeSkinType();
        }
    }

    private void anU() {
        k aAI;
        FrameLayout frameLayout;
        if (this.dJE != null && (aAI = this.dJE.aAI()) != null && aAI.getListView() != null && (frameLayout = (FrameLayout) aAI.aBR()) != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, l.h(TbadkCoreApplication.getInst(), e.C0210e.ds56));
            if (aAI.aBw() != null && aAI.aBw().getLayoutParams() != null) {
                layoutParams.topMargin = aAI.aBw().getLayoutParams().height;
            } else {
                layoutParams.topMargin = 0;
            }
            if (this.bPF == null) {
                this.bPF = new as();
            }
            if (this.dZn == 2) {
                this.bPF.a(this.dZk, frameLayout, layoutParams, UIMsg.m_AppUI.MSG_APP_GPS);
            } else if (this.dZn == 1) {
                this.bPF.a(this.dZk, frameLayout, layoutParams);
                TiebaStatic.log(new am("c12539"));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aFX() {
        aGb();
        if (this.dZp != null && this.dJE != null && this.dJE.isAdded()) {
            boolean equals = TextUtils.equals(getUserId(), String.valueOf(this.dZp.userID));
            String str = "";
            if (this.dZn == 1) {
                str = AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_FRS_FOLLOWED_LIVE_TIP;
                TiebaStatic.log(new am("c12540"));
                if (this.bPF != null) {
                    this.bPF.hideTip();
                }
            } else if (this.dZn == 2) {
                str = AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_FRS_HOT_LIVE_TIP;
                TiebaStatic.log(new am("c12331"));
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(this.dJE.getPageContext().getPageActivity(), this.dZp, this.dZq, str, getUserId(), equals, null, null)));
            if (this.dJE.aAZ().bgh().isGameForumType()) {
                CustomMessage customMessage = new CustomMessage(2001622);
                customMessage.setTag(this.dJE.getBaseFragmentActivity().getUniqueId());
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2001622);
                customResponsedMessage.setOrginalMessage(customMessage);
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                return;
            }
            com.baidu.adp.lib.g.e.jG().post(new Runnable() { // from class: com.baidu.tieba.frs.live.a.5
                @Override // java.lang.Runnable
                public void run() {
                    a.this.aFW();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aFY() {
        if (this.dZn == 2) {
            aFZ();
        }
        if (this.bPF != null) {
            this.bPF.hideTip();
        }
    }

    private void aFZ() {
        this.dZm++;
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("FRS_HOT_LIVE_TIP_CLOSE_NUM" + getUserId(), this.dZm);
    }

    private int aGa() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("FRS_HOT_LIVE_TIP_CLOSE_NUM" + getUserId(), 0);
    }

    private void aGb() {
        this.dZm = 0;
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("FRS_HOT_LIVE_TIP_CLOSE_NUM" + getUserId(), this.dZm);
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
        if (this.bPF != null) {
            this.bPF.aCF();
        }
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.dZt);
        if (this.dZr != null) {
            this.dZr.onDestory();
        }
    }
}
