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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.bc;
import com.baidu.tieba.frs.live.c;
import com.baidu.tieba.frs.p;
/* loaded from: classes16.dex */
public class a {
    private FrsFragment hHU;
    private TextView hUo;
    private String hZA;
    private AlaLiveInfoCoreData hZB;
    private AlaLiveInfoListCoreData hZC;
    private c hZD;
    private FrameLayout hZv;
    private ImageView hZw;
    private bc hZx;
    private int hZz;
    private int mForumId;
    private boolean isFirst = true;
    private c.a hZE = new c.a() { // from class: com.baidu.tieba.frs.live.a.1
        @Override // com.baidu.tieba.frs.live.c.a
        public void a(FrsLiveTipResponseMessage frsLiveTipResponseMessage) {
            if (frsLiveTipResponseMessage != null) {
                a.this.hZz = frsLiveTipResponseMessage.remindType;
                a.this.hZA = frsLiveTipResponseMessage.remindText;
                a.this.hZB = frsLiveTipResponseMessage.infoCoreData;
                a.this.hZC = frsLiveTipResponseMessage.listCoreData;
                if (a.this.hZx != null) {
                    a.this.hZx.cdN();
                }
                if (a.this.hZz != 0) {
                    a.this.cgU();
                }
            }
        }
    };
    private Runnable hZF = new Runnable() { // from class: com.baidu.tieba.frs.live.a.2
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.hZD != null) {
                a.this.hZD.vT(a.this.mForumId);
            }
        }
    };
    private int hZy = cgY();

    public a(FrsFragment frsFragment, int i) {
        this.hHU = frsFragment;
        this.mForumId = i;
    }

    public void cgT() {
        if (this.hHU != null && this.hHU.isAdded()) {
            if (System.currentTimeMillis() - getLastShowTime() >= 1800000) {
                if (this.hHU.cbM() && isFirst()) {
                    this.isFirst = false;
                    return;
                }
                if (this.hZD == null) {
                    this.hZD = new c(this.hZE);
                }
                e.lt().removeCallbacks(this.hZF);
                e.lt().postDelayed(this.hZF, 5000L);
            }
        }
    }

    public void cgU() {
        if (!StringUtils.isNull(this.hZA) && this.hZB != null) {
            if (this.hZz != 2 || cgY() < 3) {
                initView(this.hHU.getPageContext().getPageActivity());
                if (this.hUo != null) {
                    this.hUo.setText(this.hZA);
                }
                onChangeSkinType();
                bPN();
                saveLastShowTime();
            }
        }
    }

    public void cgV() {
        if (this.hHU != null) {
            this.hHU.cbu().wA(49);
        }
    }

    private void onChangeSkinType() {
        ao.setBackgroundResource(this.hZv, R.drawable.bg_frs_hot_live_tip_selector);
        ao.setViewTextColor(this.hUo, R.color.cp_cont_a);
        ao.setImageResource(this.hZw, R.drawable.icon_home_card_close_white);
        this.hUo.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ao.getDrawable(R.drawable.icon_arrow_more_white), (Drawable) null);
    }

    private void initView(Context context) {
        if (context != null && this.hZv == null) {
            this.hZv = (FrameLayout) LayoutInflater.from(context).inflate(R.layout.frs_hot_live_tip, (ViewGroup) null);
            this.hZv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.live.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.cgW();
                }
            });
            this.hUo = (TextView) this.hZv.findViewById(R.id.frs_hot_live_tip_content);
            this.hZw = (ImageView) this.hZv.findViewById(R.id.frs_hot_live_tip_close);
            this.hZw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.live.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.qk();
                }
            });
            onChangeSkinType();
        }
    }

    private void bPN() {
        p cbw;
        FrameLayout frameLayout;
        if (this.hHU != null && (cbw = this.hHU.cbw()) != null && cbw.getListView() != null && (frameLayout = (FrameLayout) cbw.ccV()) != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds56));
            if (this.hZx == null) {
                this.hZx = new bc();
            }
            if (this.hZz == 2) {
                this.hZx.a(this.hZv, frameLayout, layoutParams, 5000);
            } else if (this.hZz == 1) {
                this.hZx.a(this.hZv, frameLayout, layoutParams);
                TiebaStatic.log(new ap("c12539"));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cgW() {
        cgZ();
        if (this.hZB != null && this.hHU != null && this.hHU.isAdded()) {
            boolean equals = TextUtils.equals(getUserId(), String.valueOf(this.hZB.userID));
            String str = "";
            if (this.hZz == 1) {
                str = "frs_followed_live_tip";
                TiebaStatic.log(new ap("c12540"));
                if (this.hZx != null) {
                    this.hZx.hideTip();
                }
            } else if (this.hZz == 2) {
                str = "frs_hot_live_tip";
                TiebaStatic.log(new ap("c12331"));
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(this.hHU.getPageContext().getPageActivity(), this.hZB, this.hZC, str, getUserId(), equals, null, null)));
            if (this.hHU.cbZ().getForum().isGameForumType()) {
                CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_GAME_FRS_JUMP_TO_LIVE_TAB);
                customMessage.setTag(this.hHU.getBaseFragmentActivity().getUniqueId());
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_FRS_JUMP_TO_LIVE_TAB);
                customResponsedMessage.setOrginalMessage(customMessage);
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                return;
            }
            e.lt().post(new Runnable() { // from class: com.baidu.tieba.frs.live.a.5
                @Override // java.lang.Runnable
                public void run() {
                    a.this.cgV();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qk() {
        if (this.hZz == 2) {
            cgX();
        }
        if (this.hZx != null) {
            this.hZx.hideTip();
        }
    }

    private void cgX() {
        this.hZy++;
        com.baidu.tbadk.core.sharedPref.b.aZP().putInt(SharedPrefConfig.FRS_HOT_LIVE_TIP_CLOSE_NUM + getUserId(), this.hZy);
    }

    private int cgY() {
        return com.baidu.tbadk.core.sharedPref.b.aZP().getInt(SharedPrefConfig.FRS_HOT_LIVE_TIP_CLOSE_NUM + getUserId(), 0);
    }

    private void cgZ() {
        this.hZy = 0;
        com.baidu.tbadk.core.sharedPref.b.aZP().putInt(SharedPrefConfig.FRS_HOT_LIVE_TIP_CLOSE_NUM + getUserId(), this.hZy);
    }

    private void saveLastShowTime() {
        com.baidu.tbadk.core.sharedPref.b.aZP().putLong(SharedPrefConfig.FRS_HOT_LIVE_TIP_LAST_SHOWTIME + getUserId(), System.currentTimeMillis());
    }

    private long getLastShowTime() {
        return com.baidu.tbadk.core.sharedPref.b.aZP().getLong(SharedPrefConfig.FRS_HOT_LIVE_TIP_LAST_SHOWTIME + getUserId(), 0L);
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
        if (this.hZx != null) {
            this.hZx.cdN();
        }
        e.lt().removeCallbacks(this.hZF);
        if (this.hZD != null) {
            this.hZD.onDestory();
        }
    }
}
