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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.aq;
import com.baidu.tieba.frs.i;
import com.baidu.tieba.frs.live.c;
/* loaded from: classes2.dex */
public class a {
    private aq bmC;
    private FrsFragment cZJ;
    private TextView diG;
    private FrameLayout dnA;
    private ImageView dnB;
    private int dnD;
    private String dnE;
    private AlaLiveInfoCoreData dnF;
    private AlaLiveInfoListCoreData dnG;
    private c dnH;
    private int mForumId;
    private boolean isFirst = true;
    private c.a dnI = new c.a() { // from class: com.baidu.tieba.frs.live.a.1
        @Override // com.baidu.tieba.frs.live.c.a
        public void a(FrsLiveTipResponseMessage frsLiveTipResponseMessage) {
            if (frsLiveTipResponseMessage != null) {
                a.this.dnD = frsLiveTipResponseMessage.remindType;
                a.this.dnE = frsLiveTipResponseMessage.remindText;
                a.this.dnF = frsLiveTipResponseMessage.infoCoreData;
                a.this.dnG = frsLiveTipResponseMessage.listCoreData;
                if (a.this.bmC != null) {
                    a.this.bmC.aqO();
                }
                if (a.this.dnD != 0) {
                    a.this.atQ();
                }
            }
        }
    };
    private Runnable dnJ = new Runnable() { // from class: com.baidu.tieba.frs.live.a.2
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.dnH != null) {
                a.this.dnH.kS(a.this.mForumId);
            }
        }
    };
    private int dnC = atU();

    public a(FrsFragment frsFragment, int i) {
        this.cZJ = frsFragment;
        this.mForumId = i;
    }

    public void atP() {
        if (this.cZJ != null && this.cZJ.isAdded()) {
            if (System.currentTimeMillis() - getLastShowTime() >= 1800000) {
                if (this.cZJ.apv() && isFirst()) {
                    this.isFirst = false;
                    return;
                }
                if (this.dnH == null) {
                    this.dnH = new c(this.dnI);
                }
                e.fw().removeCallbacks(this.dnJ);
                e.fw().postDelayed(this.dnJ, TbConfig.NOTIFY_SOUND_INTERVAL);
            }
        }
    }

    public void atQ() {
        if (!StringUtils.isNull(this.dnE) && this.dnF != null) {
            if (this.dnD != 2 || atU() < 3) {
                aM(this.cZJ.getPageContext().getPageActivity());
                if (this.diG != null) {
                    this.diG.setText(this.dnE);
                }
                onChangeSkinType();
                aeb();
                saveLastShowTime();
            }
        }
    }

    public void atR() {
        if (this.cZJ != null) {
            this.cZJ.apk().lr(49);
        }
    }

    private void onChangeSkinType() {
        ak.i(this.dnA, d.f.bg_frs_hot_live_tip_selector);
        ak.h(this.diG, d.C0126d.cp_cont_i);
        ak.c(this.dnB, d.f.icon_home_card_close_white);
        this.diG.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ak.getDrawable(d.f.icon_arrow_more_white), (Drawable) null);
    }

    private void aM(Context context) {
        if (context != null && this.dnA == null) {
            this.dnA = (FrameLayout) LayoutInflater.from(context).inflate(d.i.frs_hot_live_tip, (ViewGroup) null);
            this.dnA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.live.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    a.this.atS();
                }
            });
            this.diG = (TextView) this.dnA.findViewById(d.g.frs_hot_live_tip_content);
            this.dnB = (ImageView) this.dnA.findViewById(d.g.frs_hot_live_tip_close);
            this.dnB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.live.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    a.this.onClickClose();
                }
            });
            onChangeSkinType();
        }
    }

    private void aeb() {
        i apm;
        FrameLayout frameLayout;
        if (this.cZJ != null && (apm = this.cZJ.apm()) != null && apm.getListView() != null && (frameLayout = (FrameLayout) apm.aqt()) != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, l.e(TbadkCoreApplication.getInst(), d.e.ds56));
            if (apm.aqa() != null && apm.aqa().getLayoutParams() != null) {
                layoutParams.topMargin = apm.aqa().getLayoutParams().height;
            } else {
                layoutParams.topMargin = 0;
            }
            if (this.bmC == null) {
                this.bmC = new aq();
            }
            if (this.dnD == 2) {
                this.bmC.a(this.dnA, frameLayout, layoutParams, 5000);
            } else if (this.dnD == 1) {
                this.bmC.a(this.dnA, frameLayout, layoutParams);
                TiebaStatic.log(new al("c12539"));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void atS() {
        atV();
        if (this.dnF != null && this.cZJ != null && this.cZJ.isAdded()) {
            boolean equals = TextUtils.equals(getUserId(), String.valueOf(this.dnF.userID));
            String str = "";
            if (this.dnD == 1) {
                str = AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_FRS_FOLLOWED_LIVE_TIP;
                TiebaStatic.log(new al("c12540"));
                if (this.bmC != null) {
                    this.bmC.hideTip();
                }
            } else if (this.dnD == 2) {
                str = AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_FRS_HOT_LIVE_TIP;
                TiebaStatic.log(new al("c12331"));
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(this.cZJ.getPageContext().getPageActivity(), this.dnF, this.dnG, str, getUserId(), equals, null, null)));
            if (this.cZJ.apD().aVq().isGameForumType()) {
                CustomMessage customMessage = new CustomMessage(2001622);
                customMessage.setTag(this.cZJ.getBaseFragmentActivity().getUniqueId());
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2001622);
                customResponsedMessage.setOrginalMessage(customMessage);
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                return;
            }
            e.fw().post(new Runnable() { // from class: com.baidu.tieba.frs.live.a.5
                @Override // java.lang.Runnable
                public void run() {
                    a.this.atR();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onClickClose() {
        if (this.dnD == 2) {
            atT();
        }
        if (this.bmC != null) {
            this.bmC.hideTip();
        }
    }

    private void atT() {
        this.dnC++;
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("FRS_HOT_LIVE_TIP_CLOSE_NUM" + getUserId(), this.dnC);
    }

    private int atU() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("FRS_HOT_LIVE_TIP_CLOSE_NUM" + getUserId(), 0);
    }

    private void atV() {
        this.dnC = 0;
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("FRS_HOT_LIVE_TIP_CLOSE_NUM" + getUserId(), this.dnC);
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
        if (this.bmC != null) {
            this.bmC.aqO();
        }
        e.fw().removeCallbacks(this.dnJ);
        if (this.dnH != null) {
            this.dnH.onDestory();
        }
    }
}
