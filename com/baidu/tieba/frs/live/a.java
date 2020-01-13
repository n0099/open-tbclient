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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.ala.AlaLiveInfoListCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.ar;
import com.baidu.tieba.frs.l;
import com.baidu.tieba.frs.live.c;
/* loaded from: classes7.dex */
public class a {
    private FrameLayout gDW;
    private ImageView gDX;
    private ar gDY;
    private int gEa;
    private String gEb;
    private AlaLiveInfoCoreData gEc;
    private AlaLiveInfoListCoreData gEd;
    private c gEe;
    private FrsFragment gnW;
    private TextView gyQ;
    private int mForumId;
    private boolean isFirst = true;
    private c.a gEf = new c.a() { // from class: com.baidu.tieba.frs.live.a.1
        @Override // com.baidu.tieba.frs.live.c.a
        public void a(FrsLiveTipResponseMessage frsLiveTipResponseMessage) {
            if (frsLiveTipResponseMessage != null) {
                a.this.gEa = frsLiveTipResponseMessage.remindType;
                a.this.gEb = frsLiveTipResponseMessage.remindText;
                a.this.gEc = frsLiveTipResponseMessage.infoCoreData;
                a.this.gEd = frsLiveTipResponseMessage.listCoreData;
                if (a.this.gDY != null) {
                    a.this.gDY.bEo();
                }
                if (a.this.gEa != 0) {
                    a.this.bHp();
                }
            }
        }
    };
    private Runnable gEg = new Runnable() { // from class: com.baidu.tieba.frs.live.a.2
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.gEe != null) {
                a.this.gEe.tF(a.this.mForumId);
            }
        }
    };
    private int gDZ = bHt();

    public a(FrsFragment frsFragment, int i) {
        this.gnW = frsFragment;
        this.mForumId = i;
    }

    public void bHo() {
        if (this.gnW != null && this.gnW.isAdded()) {
            if (System.currentTimeMillis() - getLastShowTime() >= 1800000) {
                if (this.gnW.bCz() && isFirst()) {
                    this.isFirst = false;
                    return;
                }
                if (this.gEe == null) {
                    this.gEe = new c(this.gEf);
                }
                e.gx().removeCallbacks(this.gEg);
                e.gx().postDelayed(this.gEg, 5000L);
            }
        }
    }

    public void bHp() {
        if (!StringUtils.isNull(this.gEb) && this.gEc != null) {
            if (this.gEa != 2 || bHt() < 3) {
                initView(this.gnW.getPageContext().getPageActivity());
                if (this.gyQ != null) {
                    this.gyQ.setText(this.gEb);
                }
                onChangeSkinType();
                brO();
                saveLastShowTime();
            }
        }
    }

    public void bHq() {
        if (this.gnW != null) {
            this.gnW.bCi().uk(49);
        }
    }

    private void onChangeSkinType() {
        am.setBackgroundResource(this.gDW, R.drawable.bg_frs_hot_live_tip_selector);
        am.setViewTextColor(this.gyQ, (int) R.color.cp_cont_a);
        am.setImageResource(this.gDX, R.drawable.icon_home_card_close_white);
        this.gyQ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(R.drawable.icon_arrow_more_white), (Drawable) null);
    }

    private void initView(Context context) {
        if (context != null && this.gDW == null) {
            this.gDW = (FrameLayout) LayoutInflater.from(context).inflate(R.layout.frs_hot_live_tip, (ViewGroup) null);
            this.gDW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.live.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.bHr();
                }
            });
            this.gyQ = (TextView) this.gDW.findViewById(R.id.frs_hot_live_tip_content);
            this.gDX = (ImageView) this.gDW.findViewById(R.id.frs_hot_live_tip_close);
            this.gDX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.live.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.kT();
                }
            });
            onChangeSkinType();
        }
    }

    private void brO() {
        l bCk;
        FrameLayout frameLayout;
        if (this.gnW != null && (bCk = this.gnW.bCk()) != null && bCk.getListView() != null && (frameLayout = (FrameLayout) bCk.bDB()) != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds56));
            if (this.gDY == null) {
                this.gDY = new ar();
            }
            if (this.gEa == 2) {
                this.gDY.a(this.gDW, frameLayout, layoutParams, 5000);
            } else if (this.gEa == 1) {
                this.gDY.a(this.gDW, frameLayout, layoutParams);
                TiebaStatic.log(new an("c12539"));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bHr() {
        bHu();
        if (this.gEc != null && this.gnW != null && this.gnW.isAdded()) {
            boolean equals = TextUtils.equals(getUserId(), String.valueOf(this.gEc.userID));
            String str = "";
            if (this.gEa == 1) {
                str = "frs_followed_live_tip";
                TiebaStatic.log(new an("c12540"));
                if (this.gDY != null) {
                    this.gDY.hideTip();
                }
            } else if (this.gEa == 2) {
                str = "frs_hot_live_tip";
                TiebaStatic.log(new an("c12331"));
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(this.gnW.getPageContext().getPageActivity(), this.gEc, this.gEd, str, getUserId(), equals, null, null)));
            if (this.gnW.bCK().getForum().isGameForumType()) {
                CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_GAME_FRS_JUMP_TO_LIVE_TAB);
                customMessage.setTag(this.gnW.getBaseFragmentActivity().getUniqueId());
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_FRS_JUMP_TO_LIVE_TAB);
                customResponsedMessage.setOrginalMessage(customMessage);
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                return;
            }
            e.gx().post(new Runnable() { // from class: com.baidu.tieba.frs.live.a.5
                @Override // java.lang.Runnable
                public void run() {
                    a.this.bHq();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kT() {
        if (this.gEa == 2) {
            bHs();
        }
        if (this.gDY != null) {
            this.gDY.hideTip();
        }
    }

    private void bHs() {
        this.gDZ++;
        com.baidu.tbadk.core.sharedPref.b.aDr().putInt(SharedPrefConfig.FRS_HOT_LIVE_TIP_CLOSE_NUM + getUserId(), this.gDZ);
    }

    private int bHt() {
        return com.baidu.tbadk.core.sharedPref.b.aDr().getInt(SharedPrefConfig.FRS_HOT_LIVE_TIP_CLOSE_NUM + getUserId(), 0);
    }

    private void bHu() {
        this.gDZ = 0;
        com.baidu.tbadk.core.sharedPref.b.aDr().putInt(SharedPrefConfig.FRS_HOT_LIVE_TIP_CLOSE_NUM + getUserId(), this.gDZ);
    }

    private void saveLastShowTime() {
        com.baidu.tbadk.core.sharedPref.b.aDr().putLong(SharedPrefConfig.FRS_HOT_LIVE_TIP_LAST_SHOWTIME + getUserId(), System.currentTimeMillis());
    }

    private long getLastShowTime() {
        return com.baidu.tbadk.core.sharedPref.b.aDr().getLong(SharedPrefConfig.FRS_HOT_LIVE_TIP_LAST_SHOWTIME + getUserId(), 0L);
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
        if (this.gDY != null) {
            this.gDY.bEo();
        }
        e.gx().removeCallbacks(this.gEg);
        if (this.gEe != null) {
            this.gEe.onDestory();
        }
    }
}
