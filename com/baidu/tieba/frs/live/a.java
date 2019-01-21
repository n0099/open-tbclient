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
    private as bQu;
    private FrsFragment dNc;
    private TextView dXC;
    private FrameLayout ecI;
    private ImageView ecJ;
    private int ecL;
    private String ecM;
    private AlaLiveInfoCoreData ecN;
    private AlaLiveInfoListCoreData ecO;
    private c ecP;
    private int mForumId;
    private boolean isFirst = true;
    private c.a ecQ = new c.a() { // from class: com.baidu.tieba.frs.live.a.1
        @Override // com.baidu.tieba.frs.live.c.a
        public void a(FrsLiveTipResponseMessage frsLiveTipResponseMessage) {
            if (frsLiveTipResponseMessage != null) {
                a.this.ecL = frsLiveTipResponseMessage.remindType;
                a.this.ecM = frsLiveTipResponseMessage.remindText;
                a.this.ecN = frsLiveTipResponseMessage.infoCoreData;
                a.this.ecO = frsLiveTipResponseMessage.listCoreData;
                if (a.this.bQu != null) {
                    a.this.bQu.aDR();
                }
                if (a.this.ecL != 0) {
                    a.this.aHh();
                }
            }
        }
    };
    private Runnable ecR = new Runnable() { // from class: com.baidu.tieba.frs.live.a.2
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.ecP != null) {
                a.this.ecP.nn(a.this.mForumId);
            }
        }
    };
    private int ecK = aHm();

    public a(FrsFragment frsFragment, int i) {
        this.dNc = frsFragment;
        this.mForumId = i;
    }

    public void aHg() {
        if (this.dNc != null && this.dNc.isAdded()) {
            if (System.currentTimeMillis() - getLastShowTime() >= 1800000) {
                if (this.dNc.aCd() && isFirst()) {
                    this.isFirst = false;
                    return;
                }
                if (this.ecP == null) {
                    this.ecP = new c(this.ecQ);
                }
                e.jG().removeCallbacks(this.ecR);
                e.jG().postDelayed(this.ecR, 5000L);
            }
        }
    }

    public void aHh() {
        if (!StringUtils.isNull(this.ecM) && this.ecN != null) {
            if (this.ecL != 2 || aHm() < 3) {
                initView(this.dNc.getPageContext().getPageActivity());
                if (this.dXC != null) {
                    this.dXC.setText(this.ecM);
                }
                onChangeSkinType();
                apf();
                saveLastShowTime();
            }
        }
    }

    public void aHi() {
        if (this.dNc != null) {
            this.dNc.aBS().nM(49);
        }
    }

    private void onChangeSkinType() {
        al.i(this.ecI, e.f.bg_frs_hot_live_tip_selector);
        al.h(this.dXC, e.d.cp_cont_i);
        al.c(this.ecJ, e.f.icon_home_card_close_white);
        this.dXC.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(e.f.icon_arrow_more_white), (Drawable) null);
    }

    private void initView(Context context) {
        if (context != null && this.ecI == null) {
            this.ecI = (FrameLayout) LayoutInflater.from(context).inflate(e.h.frs_hot_live_tip, (ViewGroup) null);
            this.ecI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.live.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.aHj();
                }
            });
            this.dXC = (TextView) this.ecI.findViewById(e.g.frs_hot_live_tip_content);
            this.ecJ = (ImageView) this.ecI.findViewById(e.g.frs_hot_live_tip_close);
            this.ecJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.live.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.aHk();
                }
            });
            onChangeSkinType();
        }
    }

    private void apf() {
        k aBU;
        FrameLayout frameLayout;
        if (this.dNc != null && (aBU = this.dNc.aBU()) != null && aBU.getListView() != null && (frameLayout = (FrameLayout) aBU.aDd()) != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, l.h(TbadkCoreApplication.getInst(), e.C0210e.ds56));
            if (aBU.aCI() != null && aBU.aCI().getLayoutParams() != null) {
                layoutParams.topMargin = aBU.aCI().getLayoutParams().height;
            } else {
                layoutParams.topMargin = 0;
            }
            if (this.bQu == null) {
                this.bQu = new as();
            }
            if (this.ecL == 2) {
                this.bQu.a(this.ecI, frameLayout, layoutParams, UIMsg.m_AppUI.MSG_APP_GPS);
            } else if (this.ecL == 1) {
                this.bQu.a(this.ecI, frameLayout, layoutParams);
                TiebaStatic.log(new am("c12539"));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aHj() {
        aHn();
        if (this.ecN != null && this.dNc != null && this.dNc.isAdded()) {
            boolean equals = TextUtils.equals(getUserId(), String.valueOf(this.ecN.userID));
            String str = "";
            if (this.ecL == 1) {
                str = AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_FRS_FOLLOWED_LIVE_TIP;
                TiebaStatic.log(new am("c12540"));
                if (this.bQu != null) {
                    this.bQu.hideTip();
                }
            } else if (this.ecL == 2) {
                str = AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_FRS_HOT_LIVE_TIP;
                TiebaStatic.log(new am("c12331"));
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(this.dNc.getPageContext().getPageActivity(), this.ecN, this.ecO, str, getUserId(), equals, null, null)));
            if (this.dNc.aCl().bhx().isGameForumType()) {
                CustomMessage customMessage = new CustomMessage(2001622);
                customMessage.setTag(this.dNc.getBaseFragmentActivity().getUniqueId());
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2001622);
                customResponsedMessage.setOrginalMessage(customMessage);
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                return;
            }
            com.baidu.adp.lib.g.e.jG().post(new Runnable() { // from class: com.baidu.tieba.frs.live.a.5
                @Override // java.lang.Runnable
                public void run() {
                    a.this.aHi();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aHk() {
        if (this.ecL == 2) {
            aHl();
        }
        if (this.bQu != null) {
            this.bQu.hideTip();
        }
    }

    private void aHl() {
        this.ecK++;
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("FRS_HOT_LIVE_TIP_CLOSE_NUM" + getUserId(), this.ecK);
    }

    private int aHm() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("FRS_HOT_LIVE_TIP_CLOSE_NUM" + getUserId(), 0);
    }

    private void aHn() {
        this.ecK = 0;
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("FRS_HOT_LIVE_TIP_CLOSE_NUM" + getUserId(), this.ecK);
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
        if (this.bQu != null) {
            this.bQu.aDR();
        }
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.ecR);
        if (this.ecP != null) {
            this.ecP.onDestory();
        }
    }
}
