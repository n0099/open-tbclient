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
    private aq bmn;
    private FrsFragment cYF;
    private TextView dhC;
    private AlaLiveInfoCoreData dmA;
    private AlaLiveInfoListCoreData dmB;
    private c dmC;
    private FrameLayout dmv;
    private ImageView dmw;
    private int dmy;
    private String dmz;
    private int mForumId;
    private boolean isFirst = true;
    private c.a dmD = new c.a() { // from class: com.baidu.tieba.frs.live.a.1
        @Override // com.baidu.tieba.frs.live.c.a
        public void a(FrsLiveTipResponseMessage frsLiveTipResponseMessage) {
            if (frsLiveTipResponseMessage != null) {
                a.this.dmy = frsLiveTipResponseMessage.remindType;
                a.this.dmz = frsLiveTipResponseMessage.remindText;
                a.this.dmA = frsLiveTipResponseMessage.infoCoreData;
                a.this.dmB = frsLiveTipResponseMessage.listCoreData;
                if (a.this.bmn != null) {
                    a.this.bmn.aqP();
                }
                if (a.this.dmy != 0) {
                    a.this.atR();
                }
            }
        }
    };
    private Runnable dmE = new Runnable() { // from class: com.baidu.tieba.frs.live.a.2
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.dmC != null) {
                a.this.dmC.kT(a.this.mForumId);
            }
        }
    };
    private int dmx = atV();

    public a(FrsFragment frsFragment, int i) {
        this.cYF = frsFragment;
        this.mForumId = i;
    }

    public void atQ() {
        if (this.cYF != null && this.cYF.isAdded()) {
            if (System.currentTimeMillis() - getLastShowTime() >= 1800000) {
                if (this.cYF.apw() && isFirst()) {
                    this.isFirst = false;
                    return;
                }
                if (this.dmC == null) {
                    this.dmC = new c(this.dmD);
                }
                e.fw().removeCallbacks(this.dmE);
                e.fw().postDelayed(this.dmE, TbConfig.NOTIFY_SOUND_INTERVAL);
            }
        }
    }

    public void atR() {
        if (!StringUtils.isNull(this.dmz) && this.dmA != null) {
            if (this.dmy != 2 || atV() < 3) {
                aM(this.cYF.getPageContext().getPageActivity());
                if (this.dhC != null) {
                    this.dhC.setText(this.dmz);
                }
                onChangeSkinType();
                aeb();
                saveLastShowTime();
            }
        }
    }

    public void atS() {
        if (this.cYF != null) {
            this.cYF.apl().ls(49);
        }
    }

    private void onChangeSkinType() {
        ak.i(this.dmv, d.f.bg_frs_hot_live_tip_selector);
        ak.h(this.dhC, d.C0126d.cp_cont_i);
        ak.c(this.dmw, d.f.icon_home_card_close_white);
        this.dhC.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ak.getDrawable(d.f.icon_arrow_more_white), (Drawable) null);
    }

    private void aM(Context context) {
        if (context != null && this.dmv == null) {
            this.dmv = (FrameLayout) LayoutInflater.from(context).inflate(d.i.frs_hot_live_tip, (ViewGroup) null);
            this.dmv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.live.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    a.this.atT();
                }
            });
            this.dhC = (TextView) this.dmv.findViewById(d.g.frs_hot_live_tip_content);
            this.dmw = (ImageView) this.dmv.findViewById(d.g.frs_hot_live_tip_close);
            this.dmw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.live.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    a.this.onClickClose();
                }
            });
            onChangeSkinType();
        }
    }

    private void aeb() {
        i apn;
        FrameLayout frameLayout;
        if (this.cYF != null && (apn = this.cYF.apn()) != null && apn.getListView() != null && (frameLayout = (FrameLayout) apn.aqu()) != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, l.e(TbadkCoreApplication.getInst(), d.e.ds56));
            if (apn.aqb() != null && apn.aqb().getLayoutParams() != null) {
                layoutParams.topMargin = apn.aqb().getLayoutParams().height;
            } else {
                layoutParams.topMargin = 0;
            }
            if (this.bmn == null) {
                this.bmn = new aq();
            }
            if (this.dmy == 2) {
                this.bmn.a(this.dmv, frameLayout, layoutParams, 5000);
            } else if (this.dmy == 1) {
                this.bmn.a(this.dmv, frameLayout, layoutParams);
                TiebaStatic.log(new al("c12539"));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void atT() {
        atW();
        if (this.dmA != null && this.cYF != null && this.cYF.isAdded()) {
            boolean equals = TextUtils.equals(getUserId(), String.valueOf(this.dmA.userID));
            String str = "";
            if (this.dmy == 1) {
                str = AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_FRS_FOLLOWED_LIVE_TIP;
                TiebaStatic.log(new al("c12540"));
                if (this.bmn != null) {
                    this.bmn.hideTip();
                }
            } else if (this.dmy == 2) {
                str = AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_FRS_HOT_LIVE_TIP;
                TiebaStatic.log(new al("c12331"));
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(this.cYF.getPageContext().getPageActivity(), this.dmA, this.dmB, str, getUserId(), equals, null, null)));
            if (this.cYF.apE().aVq().isGameForumType()) {
                CustomMessage customMessage = new CustomMessage(2001622);
                customMessage.setTag(this.cYF.getBaseFragmentActivity().getUniqueId());
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2001622);
                customResponsedMessage.setOrginalMessage(customMessage);
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                return;
            }
            e.fw().post(new Runnable() { // from class: com.baidu.tieba.frs.live.a.5
                @Override // java.lang.Runnable
                public void run() {
                    a.this.atS();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onClickClose() {
        if (this.dmy == 2) {
            atU();
        }
        if (this.bmn != null) {
            this.bmn.hideTip();
        }
    }

    private void atU() {
        this.dmx++;
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("FRS_HOT_LIVE_TIP_CLOSE_NUM" + getUserId(), this.dmx);
    }

    private int atV() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("FRS_HOT_LIVE_TIP_CLOSE_NUM" + getUserId(), 0);
    }

    private void atW() {
        this.dmx = 0;
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("FRS_HOT_LIVE_TIP_CLOSE_NUM" + getUserId(), this.dmx);
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
        if (this.bmn != null) {
            this.bmn.aqP();
        }
        e.fw().removeCallbacks(this.dmE);
        if (this.dmC != null) {
            this.dmC.onDestory();
        }
    }
}
