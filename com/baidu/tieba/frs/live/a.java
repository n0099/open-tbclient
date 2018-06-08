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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.aq;
import com.baidu.tieba.frs.i;
import com.baidu.tieba.frs.live.c;
/* loaded from: classes2.dex */
public class a {
    private aq buI;
    private FrsFragment diZ;
    private TextView drV;
    private FrameLayout dwR;
    private ImageView dwS;
    private int dwU;
    private String dwV;
    private AlaLiveInfoCoreData dwW;
    private AlaLiveInfoListCoreData dwX;
    private c dwY;
    private int mForumId;
    private boolean isFirst = true;
    private c.a dwZ = new c.a() { // from class: com.baidu.tieba.frs.live.a.1
        @Override // com.baidu.tieba.frs.live.c.a
        public void a(FrsLiveTipResponseMessage frsLiveTipResponseMessage) {
            if (frsLiveTipResponseMessage != null) {
                a.this.dwU = frsLiveTipResponseMessage.remindType;
                a.this.dwV = frsLiveTipResponseMessage.remindText;
                a.this.dwW = frsLiveTipResponseMessage.infoCoreData;
                a.this.dwX = frsLiveTipResponseMessage.listCoreData;
                if (a.this.buI != null) {
                    a.this.buI.auT();
                }
                if (a.this.dwU != 0) {
                    a.this.ayd();
                }
            }
        }
    };
    private Runnable dxa = new Runnable() { // from class: com.baidu.tieba.frs.live.a.2
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.dwY != null) {
                a.this.dwY.kZ(a.this.mForumId);
            }
        }
    };
    private int dwT = ayh();

    public a(FrsFragment frsFragment, int i) {
        this.diZ = frsFragment;
        this.mForumId = i;
    }

    public void ayc() {
        if (this.diZ != null && this.diZ.isAdded()) {
            if (System.currentTimeMillis() - getLastShowTime() >= 1800000) {
                if (this.diZ.atA() && isFirst()) {
                    this.isFirst = false;
                    return;
                }
                if (this.dwY == null) {
                    this.dwY = new c(this.dwZ);
                }
                e.im().removeCallbacks(this.dxa);
                e.im().postDelayed(this.dxa, TbConfig.NOTIFY_SOUND_INTERVAL);
            }
        }
    }

    public void ayd() {
        if (!StringUtils.isNull(this.dwV) && this.dwW != null) {
            if (this.dwU != 2 || ayh() < 3) {
                aW(this.diZ.getPageContext().getPageActivity());
                if (this.drV != null) {
                    this.drV.setText(this.dwV);
                }
                onChangeSkinType();
                ahy();
                saveLastShowTime();
            }
        }
    }

    public void aye() {
        if (this.diZ != null) {
            this.diZ.atp().ly(49);
        }
    }

    private void onChangeSkinType() {
        al.i(this.dwR, d.f.bg_frs_hot_live_tip_selector);
        al.h(this.drV, d.C0141d.cp_cont_i);
        al.c(this.dwS, d.f.icon_home_card_close_white);
        this.drV.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(d.f.icon_arrow_more_white), (Drawable) null);
    }

    private void aW(Context context) {
        if (context != null && this.dwR == null) {
            this.dwR = (FrameLayout) LayoutInflater.from(context).inflate(d.i.frs_hot_live_tip, (ViewGroup) null);
            this.dwR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.live.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.ayf();
                }
            });
            this.drV = (TextView) this.dwR.findViewById(d.g.frs_hot_live_tip_content);
            this.dwS = (ImageView) this.dwR.findViewById(d.g.frs_hot_live_tip_close);
            this.dwS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.live.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.onClickClose();
                }
            });
            onChangeSkinType();
        }
    }

    private void ahy() {
        i atr;
        FrameLayout frameLayout;
        if (this.diZ != null && (atr = this.diZ.atr()) != null && atr.getListView() != null && (frameLayout = (FrameLayout) atr.auy()) != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, l.e(TbadkCoreApplication.getInst(), d.e.ds56));
            if (atr.auf() != null && atr.auf().getLayoutParams() != null) {
                layoutParams.topMargin = atr.auf().getLayoutParams().height;
            } else {
                layoutParams.topMargin = 0;
            }
            if (this.buI == null) {
                this.buI = new aq();
            }
            if (this.dwU == 2) {
                this.buI.a(this.dwR, frameLayout, layoutParams, 5000);
            } else if (this.dwU == 1) {
                this.buI.a(this.dwR, frameLayout, layoutParams);
                TiebaStatic.log(new am("c12539"));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ayf() {
        ayi();
        if (this.dwW != null && this.diZ != null && this.diZ.isAdded()) {
            boolean equals = TextUtils.equals(getUserId(), String.valueOf(this.dwW.userID));
            String str = "";
            if (this.dwU == 1) {
                str = AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_FRS_FOLLOWED_LIVE_TIP;
                TiebaStatic.log(new am("c12540"));
                if (this.buI != null) {
                    this.buI.hideTip();
                }
            } else if (this.dwU == 2) {
                str = AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_FRS_HOT_LIVE_TIP;
                TiebaStatic.log(new am("c12331"));
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(this.diZ.getPageContext().getPageActivity(), this.dwW, this.dwX, str, getUserId(), equals, null, null)));
            if (this.diZ.atI().bam().isGameForumType()) {
                CustomMessage customMessage = new CustomMessage(2001622);
                customMessage.setTag(this.diZ.getBaseFragmentActivity().getUniqueId());
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2001622);
                customResponsedMessage.setOrginalMessage(customMessage);
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                return;
            }
            e.im().post(new Runnable() { // from class: com.baidu.tieba.frs.live.a.5
                @Override // java.lang.Runnable
                public void run() {
                    a.this.aye();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onClickClose() {
        if (this.dwU == 2) {
            ayg();
        }
        if (this.buI != null) {
            this.buI.hideTip();
        }
    }

    private void ayg() {
        this.dwT++;
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("FRS_HOT_LIVE_TIP_CLOSE_NUM" + getUserId(), this.dwT);
    }

    private int ayh() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("FRS_HOT_LIVE_TIP_CLOSE_NUM" + getUserId(), 0);
    }

    private void ayi() {
        this.dwT = 0;
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("FRS_HOT_LIVE_TIP_CLOSE_NUM" + getUserId(), this.dwT);
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
        if (this.buI != null) {
            this.buI.auT();
        }
        e.im().removeCallbacks(this.dxa);
        if (this.dwY != null) {
            this.dwY.onDestory();
        }
    }
}
