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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.bb;
import com.baidu.tieba.frs.live.c;
import com.baidu.tieba.frs.q;
/* loaded from: classes2.dex */
public class a {
    private FrameLayout jDZ;
    private bb jEa;
    private int jEc;
    private String jEd;
    private AlaLiveInfoCoreData jEe;
    private AlaLiveInfoListCoreData jEf;
    private c jEg;
    private FrsFragment jiE;
    private ImageView jlL;
    private TextView jyB;
    private int mForumId;
    private boolean isFirst = true;
    private c.a jEh = new c.a() { // from class: com.baidu.tieba.frs.live.a.1
        @Override // com.baidu.tieba.frs.live.c.a
        public void a(FrsLiveTipResponseMessage frsLiveTipResponseMessage) {
            if (frsLiveTipResponseMessage != null) {
                a.this.jEc = frsLiveTipResponseMessage.remindType;
                a.this.jEd = frsLiveTipResponseMessage.remindText;
                a.this.jEe = frsLiveTipResponseMessage.infoCoreData;
                a.this.jEf = frsLiveTipResponseMessage.listCoreData;
                if (a.this.jEa != null) {
                    a.this.jEa.cEQ();
                }
                if (a.this.jEc != 0) {
                    a.this.cJi();
                }
            }
        }
    };
    private Runnable jEi = new Runnable() { // from class: com.baidu.tieba.frs.live.a.2
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.jEg != null) {
                a.this.jEg.zY(a.this.mForumId);
            }
        }
    };
    private int jEb = cJm();

    public a(FrsFragment frsFragment, int i) {
        this.jiE = frsFragment;
        this.mForumId = i;
    }

    public void cJh() {
        if (this.jiE != null && this.jiE.isAdded()) {
            if (System.currentTimeMillis() - getLastShowTime() >= 1800000) {
                if (this.jiE.cCL() && isFirst()) {
                    this.isFirst = false;
                    return;
                }
                if (this.jEg == null) {
                    this.jEg = new c(this.jEh);
                }
                e.mA().removeCallbacks(this.jEi);
                e.mA().postDelayed(this.jEi, 5000L);
            }
        }
    }

    public void cJi() {
        if (!StringUtils.isNull(this.jEd) && this.jEe != null) {
            if (this.jEc != 2 || cJm() < 3) {
                initView(this.jiE.getPageContext().getPageActivity());
                if (this.jyB != null) {
                    this.jyB.setText(this.jEd);
                }
                onChangeSkinType();
                coY();
                saveLastShowTime();
            }
        }
    }

    public void cJj() {
        if (this.jiE != null) {
            this.jiE.cCs().sT(49);
        }
    }

    private void onChangeSkinType() {
        ap.setBackgroundResource(this.jDZ, R.drawable.bg_frs_hot_live_tip_selector);
        ap.setViewTextColor(this.jyB, R.color.CAM_X0101);
        ap.setImageResource(this.jlL, R.drawable.icon_home_card_close_white);
        this.jyB.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ap.getDrawable(R.drawable.icon_arrow_more_white), (Drawable) null);
    }

    private void initView(Context context) {
        if (context != null && this.jDZ == null) {
            this.jDZ = (FrameLayout) LayoutInflater.from(context).inflate(R.layout.frs_hot_live_tip, (ViewGroup) null);
            this.jDZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.live.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.cJk();
                }
            });
            this.jyB = (TextView) this.jDZ.findViewById(R.id.frs_hot_live_tip_content);
            this.jlL = (ImageView) this.jDZ.findViewById(R.id.frs_hot_live_tip_close);
            this.jlL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.live.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.rp();
                }
            });
            onChangeSkinType();
        }
    }

    private void coY() {
        q cCu;
        FrameLayout frameLayout;
        if (this.jiE != null && (cCu = this.jiE.cCu()) != null && cCu.getListView() != null && (frameLayout = (FrameLayout) cCu.cDV()) != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds56));
            if (this.jEa == null) {
                this.jEa = new bb();
            }
            if (this.jEc == 2) {
                this.jEa.a(this.jDZ, frameLayout, layoutParams, 5000);
            } else if (this.jEc == 1) {
                this.jEa.a(this.jDZ, frameLayout, layoutParams);
                TiebaStatic.log(new ar("c12539"));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cJk() {
        cJn();
        if (this.jEe != null && this.jiE != null && this.jiE.isAdded()) {
            boolean equals = TextUtils.equals(getUserId(), String.valueOf(this.jEe.userID));
            String str = "";
            if (this.jEc == 1) {
                str = "frs_followed_live_tip";
                TiebaStatic.log(new ar("c12540"));
                if (this.jEa != null) {
                    this.jEa.hideTip();
                }
            } else if (this.jEc == 2) {
                str = "frs_hot_live_tip";
                TiebaStatic.log(new ar("c12331"));
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(this.jiE.getPageContext().getPageActivity(), this.jEe, this.jEf, str, getUserId(), equals, null, null)));
            if (this.jiE.cCZ().getForum().isGameForumType()) {
                CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_GAME_FRS_JUMP_TO_LIVE_TAB);
                customMessage.setTag(this.jiE.getBaseFragmentActivity().getUniqueId());
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_FRS_JUMP_TO_LIVE_TAB);
                customResponsedMessage.setOrginalMessage(customMessage);
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                return;
            }
            e.mA().post(new Runnable() { // from class: com.baidu.tieba.frs.live.a.5
                @Override // java.lang.Runnable
                public void run() {
                    a.this.cJj();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rp() {
        if (this.jEc == 2) {
            cJl();
        }
        if (this.jEa != null) {
            this.jEa.hideTip();
        }
    }

    private void cJl() {
        this.jEb++;
        com.baidu.tbadk.core.sharedPref.b.brQ().putInt(SharedPrefConfig.FRS_HOT_LIVE_TIP_CLOSE_NUM + getUserId(), this.jEb);
    }

    private int cJm() {
        return com.baidu.tbadk.core.sharedPref.b.brQ().getInt(SharedPrefConfig.FRS_HOT_LIVE_TIP_CLOSE_NUM + getUserId(), 0);
    }

    private void cJn() {
        this.jEb = 0;
        com.baidu.tbadk.core.sharedPref.b.brQ().putInt(SharedPrefConfig.FRS_HOT_LIVE_TIP_CLOSE_NUM + getUserId(), this.jEb);
    }

    private void saveLastShowTime() {
        com.baidu.tbadk.core.sharedPref.b.brQ().putLong(SharedPrefConfig.FRS_HOT_LIVE_TIP_LAST_SHOWTIME + getUserId(), System.currentTimeMillis());
    }

    private long getLastShowTime() {
        return com.baidu.tbadk.core.sharedPref.b.brQ().getLong(SharedPrefConfig.FRS_HOT_LIVE_TIP_LAST_SHOWTIME + getUserId(), 0L);
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
        if (this.jEa != null) {
            this.jEa.cEQ();
        }
        e.mA().removeCallbacks(this.jEi);
        if (this.jEg != null) {
            this.jEg.onDestory();
        }
    }
}
