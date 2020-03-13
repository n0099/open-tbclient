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
/* loaded from: classes9.dex */
public class a {
    private TextView gBe;
    private FrameLayout gGj;
    private ImageView gGk;
    private ar gGl;
    private int gGn;
    private String gGo;
    private AlaLiveInfoCoreData gGp;
    private AlaLiveInfoListCoreData gGq;
    private c gGr;
    private FrsFragment gqm;
    private int mForumId;
    private boolean isFirst = true;
    private c.a gGs = new c.a() { // from class: com.baidu.tieba.frs.live.a.1
        @Override // com.baidu.tieba.frs.live.c.a
        public void a(FrsLiveTipResponseMessage frsLiveTipResponseMessage) {
            if (frsLiveTipResponseMessage != null) {
                a.this.gGn = frsLiveTipResponseMessage.remindType;
                a.this.gGo = frsLiveTipResponseMessage.remindText;
                a.this.gGp = frsLiveTipResponseMessage.infoCoreData;
                a.this.gGq = frsLiveTipResponseMessage.listCoreData;
                if (a.this.gGl != null) {
                    a.this.gGl.bFT();
                }
                if (a.this.gGn != 0) {
                    a.this.bIU();
                }
            }
        }
    };
    private Runnable gGt = new Runnable() { // from class: com.baidu.tieba.frs.live.a.2
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.gGr != null) {
                a.this.gGr.tL(a.this.mForumId);
            }
        }
    };
    private int gGm = bIY();

    public a(FrsFragment frsFragment, int i) {
        this.gqm = frsFragment;
        this.mForumId = i;
    }

    public void bIT() {
        if (this.gqm != null && this.gqm.isAdded()) {
            if (System.currentTimeMillis() - getLastShowTime() >= 1800000) {
                if (this.gqm.bEf() && isFirst()) {
                    this.isFirst = false;
                    return;
                }
                if (this.gGr == null) {
                    this.gGr = new c(this.gGs);
                }
                e.gx().removeCallbacks(this.gGt);
                e.gx().postDelayed(this.gGt, 5000L);
            }
        }
    }

    public void bIU() {
        if (!StringUtils.isNull(this.gGo) && this.gGp != null) {
            if (this.gGn != 2 || bIY() < 3) {
                initView(this.gqm.getPageContext().getPageActivity());
                if (this.gBe != null) {
                    this.gBe.setText(this.gGo);
                }
                onChangeSkinType();
                btv();
                saveLastShowTime();
            }
        }
    }

    public void bIV() {
        if (this.gqm != null) {
            this.gqm.bDO().uq(49);
        }
    }

    private void onChangeSkinType() {
        am.setBackgroundResource(this.gGj, R.drawable.bg_frs_hot_live_tip_selector);
        am.setViewTextColor(this.gBe, (int) R.color.cp_cont_a);
        am.setImageResource(this.gGk, R.drawable.icon_home_card_close_white);
        this.gBe.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(R.drawable.icon_arrow_more_white), (Drawable) null);
    }

    private void initView(Context context) {
        if (context != null && this.gGj == null) {
            this.gGj = (FrameLayout) LayoutInflater.from(context).inflate(R.layout.frs_hot_live_tip, (ViewGroup) null);
            this.gGj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.live.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.bIW();
                }
            });
            this.gBe = (TextView) this.gGj.findViewById(R.id.frs_hot_live_tip_content);
            this.gGk = (ImageView) this.gGj.findViewById(R.id.frs_hot_live_tip_close);
            this.gGk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.live.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.li();
                }
            });
            onChangeSkinType();
        }
    }

    private void btv() {
        l bDQ;
        FrameLayout frameLayout;
        if (this.gqm != null && (bDQ = this.gqm.bDQ()) != null && bDQ.getListView() != null && (frameLayout = (FrameLayout) bDQ.bFh()) != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds56));
            if (this.gGl == null) {
                this.gGl = new ar();
            }
            if (this.gGn == 2) {
                this.gGl.a(this.gGj, frameLayout, layoutParams, 5000);
            } else if (this.gGn == 1) {
                this.gGl.a(this.gGj, frameLayout, layoutParams);
                TiebaStatic.log(new an("c12539"));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIW() {
        bIZ();
        if (this.gGp != null && this.gqm != null && this.gqm.isAdded()) {
            boolean equals = TextUtils.equals(getUserId(), String.valueOf(this.gGp.userID));
            String str = "";
            if (this.gGn == 1) {
                str = "frs_followed_live_tip";
                TiebaStatic.log(new an("c12540"));
                if (this.gGl != null) {
                    this.gGl.hideTip();
                }
            } else if (this.gGn == 2) {
                str = "frs_hot_live_tip";
                TiebaStatic.log(new an("c12331"));
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(this.gqm.getPageContext().getPageActivity(), this.gGp, this.gGq, str, getUserId(), equals, null, null)));
            if (this.gqm.bEq().getForum().isGameForumType()) {
                CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_GAME_FRS_JUMP_TO_LIVE_TAB);
                customMessage.setTag(this.gqm.getBaseFragmentActivity().getUniqueId());
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_FRS_JUMP_TO_LIVE_TAB);
                customResponsedMessage.setOrginalMessage(customMessage);
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                return;
            }
            e.gx().post(new Runnable() { // from class: com.baidu.tieba.frs.live.a.5
                @Override // java.lang.Runnable
                public void run() {
                    a.this.bIV();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void li() {
        if (this.gGn == 2) {
            bIX();
        }
        if (this.gGl != null) {
            this.gGl.hideTip();
        }
    }

    private void bIX() {
        this.gGm++;
        com.baidu.tbadk.core.sharedPref.b.aFD().putInt(SharedPrefConfig.FRS_HOT_LIVE_TIP_CLOSE_NUM + getUserId(), this.gGm);
    }

    private int bIY() {
        return com.baidu.tbadk.core.sharedPref.b.aFD().getInt(SharedPrefConfig.FRS_HOT_LIVE_TIP_CLOSE_NUM + getUserId(), 0);
    }

    private void bIZ() {
        this.gGm = 0;
        com.baidu.tbadk.core.sharedPref.b.aFD().putInt(SharedPrefConfig.FRS_HOT_LIVE_TIP_CLOSE_NUM + getUserId(), this.gGm);
    }

    private void saveLastShowTime() {
        com.baidu.tbadk.core.sharedPref.b.aFD().putLong(SharedPrefConfig.FRS_HOT_LIVE_TIP_LAST_SHOWTIME + getUserId(), System.currentTimeMillis());
    }

    private long getLastShowTime() {
        return com.baidu.tbadk.core.sharedPref.b.aFD().getLong(SharedPrefConfig.FRS_HOT_LIVE_TIP_LAST_SHOWTIME + getUserId(), 0L);
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
        if (this.gGl != null) {
            this.gGl.bFT();
        }
        e.gx().removeCallbacks(this.gGt);
        if (this.gGr != null) {
            this.gGr.onDestory();
        }
    }
}
