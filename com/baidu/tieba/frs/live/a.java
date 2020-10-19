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
import com.baidu.adp.lib.f.e;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.ala.AlaLiveInfoListCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.be;
import com.baidu.tieba.frs.live.c;
import com.baidu.tieba.frs.q;
/* loaded from: classes22.dex */
public class a {
    private TextView iEw;
    private FrameLayout iJT;
    private be iJU;
    private int iJW;
    private String iJX;
    private AlaLiveInfoCoreData iJY;
    private AlaLiveInfoListCoreData iJZ;
    private c iKa;
    private FrsFragment irr;
    private ImageView iuz;
    private int mForumId;
    private boolean isFirst = true;
    private c.a iKb = new c.a() { // from class: com.baidu.tieba.frs.live.a.1
        @Override // com.baidu.tieba.frs.live.c.a
        public void a(FrsLiveTipResponseMessage frsLiveTipResponseMessage) {
            if (frsLiveTipResponseMessage != null) {
                a.this.iJW = frsLiveTipResponseMessage.remindType;
                a.this.iJX = frsLiveTipResponseMessage.remindText;
                a.this.iJY = frsLiveTipResponseMessage.infoCoreData;
                a.this.iJZ = frsLiveTipResponseMessage.listCoreData;
                if (a.this.iJU != null) {
                    a.this.iJU.cuY();
                }
                if (a.this.iJW != 0) {
                    a.this.cym();
                }
            }
        }
    };
    private Runnable iKc = new Runnable() { // from class: com.baidu.tieba.frs.live.a.2
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.iKa != null) {
                a.this.iKa.zr(a.this.mForumId);
            }
        }
    };
    private int iJV = cyq();

    public a(FrsFragment frsFragment, int i) {
        this.irr = frsFragment;
        this.mForumId = i;
    }

    public void cyl() {
        if (this.irr != null && this.irr.isAdded()) {
            if (System.currentTimeMillis() - getLastShowTime() >= 1800000) {
                if (this.irr.csU() && isFirst()) {
                    this.isFirst = false;
                    return;
                }
                if (this.iKa == null) {
                    this.iKa = new c(this.iKb);
                }
                e.mY().removeCallbacks(this.iKc);
                e.mY().postDelayed(this.iKc, 5000L);
            }
        }
    }

    public void cym() {
        if (!StringUtils.isNull(this.iJX) && this.iJY != null) {
            if (this.iJW != 2 || cyq() < 3) {
                dQ(this.irr.getPageContext().getPageActivity());
                if (this.iEw != null) {
                    this.iEw.setText(this.iJX);
                }
                onChangeSkinType();
                cfF();
                saveLastShowTime();
            }
        }
    }

    public void cyn() {
        if (this.irr != null) {
            this.irr.csB().sL(49);
        }
    }

    private void onChangeSkinType() {
        ap.setBackgroundResource(this.iJT, R.drawable.bg_frs_hot_live_tip_selector);
        ap.setViewTextColor(this.iEw, R.color.cp_cont_a);
        ap.setImageResource(this.iuz, R.drawable.icon_home_card_close_white);
        this.iEw.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ap.getDrawable(R.drawable.icon_arrow_more_white), (Drawable) null);
    }

    private void dQ(Context context) {
        if (context != null && this.iJT == null) {
            this.iJT = (FrameLayout) LayoutInflater.from(context).inflate(R.layout.frs_hot_live_tip, (ViewGroup) null);
            this.iJT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.live.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.cyo();
                }
            });
            this.iEw = (TextView) this.iJT.findViewById(R.id.frs_hot_live_tip_content);
            this.iuz = (ImageView) this.iJT.findViewById(R.id.frs_hot_live_tip_close);
            this.iuz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.live.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.rO();
                }
            });
            onChangeSkinType();
        }
    }

    private void cfF() {
        q csD;
        FrameLayout frameLayout;
        if (this.irr != null && (csD = this.irr.csD()) != null && csD.getListView() != null && (frameLayout = (FrameLayout) csD.cud()) != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds56));
            if (this.iJU == null) {
                this.iJU = new be();
            }
            if (this.iJW == 2) {
                this.iJU.a(this.iJT, frameLayout, layoutParams, 5000);
            } else if (this.iJW == 1) {
                this.iJU.a(this.iJT, frameLayout, layoutParams);
                TiebaStatic.log(new aq("c12539"));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cyo() {
        cyr();
        if (this.iJY != null && this.irr != null && this.irr.isAdded()) {
            boolean equals = TextUtils.equals(getUserId(), String.valueOf(this.iJY.userID));
            String str = "";
            if (this.iJW == 1) {
                str = "frs_followed_live_tip";
                TiebaStatic.log(new aq("c12540"));
                if (this.iJU != null) {
                    this.iJU.hideTip();
                }
            } else if (this.iJW == 2) {
                str = "frs_hot_live_tip";
                TiebaStatic.log(new aq("c12331"));
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(this.irr.getPageContext().getPageActivity(), this.iJY, this.iJZ, str, getUserId(), equals, null, null)));
            if (this.irr.cth().getForum().isGameForumType()) {
                CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_GAME_FRS_JUMP_TO_LIVE_TAB);
                customMessage.setTag(this.irr.getBaseFragmentActivity().getUniqueId());
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_FRS_JUMP_TO_LIVE_TAB);
                customResponsedMessage.setOrginalMessage(customMessage);
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                return;
            }
            e.mY().post(new Runnable() { // from class: com.baidu.tieba.frs.live.a.5
                @Override // java.lang.Runnable
                public void run() {
                    a.this.cyn();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rO() {
        if (this.iJW == 2) {
            cyp();
        }
        if (this.iJU != null) {
            this.iJU.hideTip();
        }
    }

    private void cyp() {
        this.iJV++;
        com.baidu.tbadk.core.sharedPref.b.blO().putInt(SharedPrefConfig.FRS_HOT_LIVE_TIP_CLOSE_NUM + getUserId(), this.iJV);
    }

    private int cyq() {
        return com.baidu.tbadk.core.sharedPref.b.blO().getInt(SharedPrefConfig.FRS_HOT_LIVE_TIP_CLOSE_NUM + getUserId(), 0);
    }

    private void cyr() {
        this.iJV = 0;
        com.baidu.tbadk.core.sharedPref.b.blO().putInt(SharedPrefConfig.FRS_HOT_LIVE_TIP_CLOSE_NUM + getUserId(), this.iJV);
    }

    private void saveLastShowTime() {
        com.baidu.tbadk.core.sharedPref.b.blO().putLong(SharedPrefConfig.FRS_HOT_LIVE_TIP_LAST_SHOWTIME + getUserId(), System.currentTimeMillis());
    }

    private long getLastShowTime() {
        return com.baidu.tbadk.core.sharedPref.b.blO().getLong(SharedPrefConfig.FRS_HOT_LIVE_TIP_LAST_SHOWTIME + getUserId(), 0L);
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
        if (this.iJU != null) {
            this.iJU.cuY();
        }
        e.mY().removeCallbacks(this.iKc);
        if (this.iKa != null) {
            this.iKa.onDestory();
        }
    }
}
