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
    private as bQt;
    private FrsFragment dNb;
    private TextView dXB;
    private FrameLayout ecH;
    private ImageView ecI;
    private int ecK;
    private String ecL;
    private AlaLiveInfoCoreData ecM;
    private AlaLiveInfoListCoreData ecN;
    private c ecO;
    private int mForumId;
    private boolean isFirst = true;
    private c.a ecP = new c.a() { // from class: com.baidu.tieba.frs.live.a.1
        @Override // com.baidu.tieba.frs.live.c.a
        public void a(FrsLiveTipResponseMessage frsLiveTipResponseMessage) {
            if (frsLiveTipResponseMessage != null) {
                a.this.ecK = frsLiveTipResponseMessage.remindType;
                a.this.ecL = frsLiveTipResponseMessage.remindText;
                a.this.ecM = frsLiveTipResponseMessage.infoCoreData;
                a.this.ecN = frsLiveTipResponseMessage.listCoreData;
                if (a.this.bQt != null) {
                    a.this.bQt.aDR();
                }
                if (a.this.ecK != 0) {
                    a.this.aHh();
                }
            }
        }
    };
    private Runnable ecQ = new Runnable() { // from class: com.baidu.tieba.frs.live.a.2
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.ecO != null) {
                a.this.ecO.nn(a.this.mForumId);
            }
        }
    };
    private int ecJ = aHm();

    public a(FrsFragment frsFragment, int i) {
        this.dNb = frsFragment;
        this.mForumId = i;
    }

    public void aHg() {
        if (this.dNb != null && this.dNb.isAdded()) {
            if (System.currentTimeMillis() - getLastShowTime() >= 1800000) {
                if (this.dNb.aCd() && isFirst()) {
                    this.isFirst = false;
                    return;
                }
                if (this.ecO == null) {
                    this.ecO = new c(this.ecP);
                }
                e.jG().removeCallbacks(this.ecQ);
                e.jG().postDelayed(this.ecQ, 5000L);
            }
        }
    }

    public void aHh() {
        if (!StringUtils.isNull(this.ecL) && this.ecM != null) {
            if (this.ecK != 2 || aHm() < 3) {
                initView(this.dNb.getPageContext().getPageActivity());
                if (this.dXB != null) {
                    this.dXB.setText(this.ecL);
                }
                onChangeSkinType();
                apf();
                saveLastShowTime();
            }
        }
    }

    public void aHi() {
        if (this.dNb != null) {
            this.dNb.aBS().nM(49);
        }
    }

    private void onChangeSkinType() {
        al.i(this.ecH, e.f.bg_frs_hot_live_tip_selector);
        al.h(this.dXB, e.d.cp_cont_i);
        al.c(this.ecI, e.f.icon_home_card_close_white);
        this.dXB.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(e.f.icon_arrow_more_white), (Drawable) null);
    }

    private void initView(Context context) {
        if (context != null && this.ecH == null) {
            this.ecH = (FrameLayout) LayoutInflater.from(context).inflate(e.h.frs_hot_live_tip, (ViewGroup) null);
            this.ecH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.live.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.aHj();
                }
            });
            this.dXB = (TextView) this.ecH.findViewById(e.g.frs_hot_live_tip_content);
            this.ecI = (ImageView) this.ecH.findViewById(e.g.frs_hot_live_tip_close);
            this.ecI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.live.a.4
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
        if (this.dNb != null && (aBU = this.dNb.aBU()) != null && aBU.getListView() != null && (frameLayout = (FrameLayout) aBU.aDd()) != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, l.h(TbadkCoreApplication.getInst(), e.C0210e.ds56));
            if (aBU.aCI() != null && aBU.aCI().getLayoutParams() != null) {
                layoutParams.topMargin = aBU.aCI().getLayoutParams().height;
            } else {
                layoutParams.topMargin = 0;
            }
            if (this.bQt == null) {
                this.bQt = new as();
            }
            if (this.ecK == 2) {
                this.bQt.a(this.ecH, frameLayout, layoutParams, UIMsg.m_AppUI.MSG_APP_GPS);
            } else if (this.ecK == 1) {
                this.bQt.a(this.ecH, frameLayout, layoutParams);
                TiebaStatic.log(new am("c12539"));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aHj() {
        aHn();
        if (this.ecM != null && this.dNb != null && this.dNb.isAdded()) {
            boolean equals = TextUtils.equals(getUserId(), String.valueOf(this.ecM.userID));
            String str = "";
            if (this.ecK == 1) {
                str = AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_FRS_FOLLOWED_LIVE_TIP;
                TiebaStatic.log(new am("c12540"));
                if (this.bQt != null) {
                    this.bQt.hideTip();
                }
            } else if (this.ecK == 2) {
                str = AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_FRS_HOT_LIVE_TIP;
                TiebaStatic.log(new am("c12331"));
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(this.dNb.getPageContext().getPageActivity(), this.ecM, this.ecN, str, getUserId(), equals, null, null)));
            if (this.dNb.aCl().bhx().isGameForumType()) {
                CustomMessage customMessage = new CustomMessage(2001622);
                customMessage.setTag(this.dNb.getBaseFragmentActivity().getUniqueId());
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
        if (this.ecK == 2) {
            aHl();
        }
        if (this.bQt != null) {
            this.bQt.hideTip();
        }
    }

    private void aHl() {
        this.ecJ++;
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("FRS_HOT_LIVE_TIP_CLOSE_NUM" + getUserId(), this.ecJ);
    }

    private int aHm() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("FRS_HOT_LIVE_TIP_CLOSE_NUM" + getUserId(), 0);
    }

    private void aHn() {
        this.ecJ = 0;
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("FRS_HOT_LIVE_TIP_CLOSE_NUM" + getUserId(), this.ecJ);
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
        if (this.bQt != null) {
            this.bQt.aDR();
        }
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.ecQ);
        if (this.ecO != null) {
            this.ecO.onDestory();
        }
    }
}
