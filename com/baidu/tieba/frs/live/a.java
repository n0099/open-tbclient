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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.as;
import com.baidu.tieba.frs.live.c;
import com.baidu.tieba.frs.m;
/* loaded from: classes9.dex */
public class a {
    private TextView gCc;
    private FrameLayout gHh;
    private ImageView gHi;
    private as gHj;
    private int gHl;
    private String gHm;
    private AlaLiveInfoCoreData gHn;
    private AlaLiveInfoListCoreData gHo;
    private c gHp;
    private FrsFragment gqW;
    private int mForumId;
    private boolean isFirst = true;
    private c.a gHq = new c.a() { // from class: com.baidu.tieba.frs.live.a.1
        @Override // com.baidu.tieba.frs.live.c.a
        public void a(FrsLiveTipResponseMessage frsLiveTipResponseMessage) {
            if (frsLiveTipResponseMessage != null) {
                a.this.gHl = frsLiveTipResponseMessage.remindType;
                a.this.gHm = frsLiveTipResponseMessage.remindText;
                a.this.gHn = frsLiveTipResponseMessage.infoCoreData;
                a.this.gHo = frsLiveTipResponseMessage.listCoreData;
                if (a.this.gHj != null) {
                    a.this.gHj.bGe();
                }
                if (a.this.gHl != 0) {
                    a.this.bJg();
                }
            }
        }
    };
    private Runnable gHr = new Runnable() { // from class: com.baidu.tieba.frs.live.a.2
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.gHp != null) {
                a.this.gHp.tQ(a.this.mForumId);
            }
        }
    };
    private int gHk = bJk();

    public a(FrsFragment frsFragment, int i) {
        this.gqW = frsFragment;
        this.mForumId = i;
    }

    public void bJf() {
        if (this.gqW != null && this.gqW.isAdded()) {
            if (System.currentTimeMillis() - getLastShowTime() >= 1800000) {
                if (this.gqW.bEo() && isFirst()) {
                    this.isFirst = false;
                    return;
                }
                if (this.gHp == null) {
                    this.gHp = new c(this.gHq);
                }
                e.gx().removeCallbacks(this.gHr);
                e.gx().postDelayed(this.gHr, 5000L);
            }
        }
    }

    public void bJg() {
        if (!StringUtils.isNull(this.gHm) && this.gHn != null) {
            if (this.gHl != 2 || bJk() < 3) {
                initView(this.gqW.getPageContext().getPageActivity());
                if (this.gCc != null) {
                    this.gCc.setText(this.gHm);
                }
                onChangeSkinType();
                btA();
                saveLastShowTime();
            }
        }
    }

    public void bJh() {
        if (this.gqW != null) {
            this.gqW.bDW().ux(49);
        }
    }

    private void onChangeSkinType() {
        am.setBackgroundResource(this.gHh, R.drawable.bg_frs_hot_live_tip_selector);
        am.setViewTextColor(this.gCc, (int) R.color.cp_cont_a);
        am.setImageResource(this.gHi, R.drawable.icon_home_card_close_white);
        this.gCc.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(R.drawable.icon_arrow_more_white), (Drawable) null);
    }

    private void initView(Context context) {
        if (context != null && this.gHh == null) {
            this.gHh = (FrameLayout) LayoutInflater.from(context).inflate(R.layout.frs_hot_live_tip, (ViewGroup) null);
            this.gHh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.live.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.bJi();
                }
            });
            this.gCc = (TextView) this.gHh.findViewById(R.id.frs_hot_live_tip_content);
            this.gHi = (ImageView) this.gHh.findViewById(R.id.frs_hot_live_tip_close);
            this.gHi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.live.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.li();
                }
            });
            onChangeSkinType();
        }
    }

    private void btA() {
        m bDY;
        FrameLayout frameLayout;
        if (this.gqW != null && (bDY = this.gqW.bDY()) != null && bDY.getListView() != null && (frameLayout = (FrameLayout) bDY.bFr()) != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds56));
            if (this.gHj == null) {
                this.gHj = new as();
            }
            if (this.gHl == 2) {
                this.gHj.a(this.gHh, frameLayout, layoutParams, 5000);
            } else if (this.gHl == 1) {
                this.gHj.a(this.gHh, frameLayout, layoutParams);
                TiebaStatic.log(new an("c12539"));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJi() {
        bJl();
        if (this.gHn != null && this.gqW != null && this.gqW.isAdded()) {
            boolean equals = TextUtils.equals(getUserId(), String.valueOf(this.gHn.userID));
            String str = "";
            if (this.gHl == 1) {
                str = "frs_followed_live_tip";
                TiebaStatic.log(new an("c12540"));
                if (this.gHj != null) {
                    this.gHj.hideTip();
                }
            } else if (this.gHl == 2) {
                str = "frs_hot_live_tip";
                TiebaStatic.log(new an("c12331"));
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(this.gqW.getPageContext().getPageActivity(), this.gHn, this.gHo, str, getUserId(), equals, null, null)));
            if (this.gqW.bEz().getForum().isGameForumType()) {
                CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_GAME_FRS_JUMP_TO_LIVE_TAB);
                customMessage.setTag(this.gqW.getBaseFragmentActivity().getUniqueId());
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_FRS_JUMP_TO_LIVE_TAB);
                customResponsedMessage.setOrginalMessage(customMessage);
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                return;
            }
            e.gx().post(new Runnable() { // from class: com.baidu.tieba.frs.live.a.5
                @Override // java.lang.Runnable
                public void run() {
                    a.this.bJh();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void li() {
        if (this.gHl == 2) {
            bJj();
        }
        if (this.gHj != null) {
            this.gHj.hideTip();
        }
    }

    private void bJj() {
        this.gHk++;
        com.baidu.tbadk.core.sharedPref.b.aFH().putInt(SharedPrefConfig.FRS_HOT_LIVE_TIP_CLOSE_NUM + getUserId(), this.gHk);
    }

    private int bJk() {
        return com.baidu.tbadk.core.sharedPref.b.aFH().getInt(SharedPrefConfig.FRS_HOT_LIVE_TIP_CLOSE_NUM + getUserId(), 0);
    }

    private void bJl() {
        this.gHk = 0;
        com.baidu.tbadk.core.sharedPref.b.aFH().putInt(SharedPrefConfig.FRS_HOT_LIVE_TIP_CLOSE_NUM + getUserId(), this.gHk);
    }

    private void saveLastShowTime() {
        com.baidu.tbadk.core.sharedPref.b.aFH().putLong(SharedPrefConfig.FRS_HOT_LIVE_TIP_LAST_SHOWTIME + getUserId(), System.currentTimeMillis());
    }

    private long getLastShowTime() {
        return com.baidu.tbadk.core.sharedPref.b.aFH().getLong(SharedPrefConfig.FRS_HOT_LIVE_TIP_LAST_SHOWTIME + getUserId(), 0L);
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
        if (this.gHj != null) {
            this.gHj.bGe();
        }
        e.gx().removeCallbacks(this.gHr);
        if (this.gHp != null) {
            this.gHp.onDestory();
        }
    }
}
