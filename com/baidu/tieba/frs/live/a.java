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
    private TextView hUm;
    private AlaLiveInfoListCoreData hZA;
    private c hZB;
    private FrameLayout hZt;
    private ImageView hZu;
    private bc hZv;
    private int hZx;
    private String hZy;
    private AlaLiveInfoCoreData hZz;
    private int mForumId;
    private boolean isFirst = true;
    private c.a hZC = new c.a() { // from class: com.baidu.tieba.frs.live.a.1
        @Override // com.baidu.tieba.frs.live.c.a
        public void a(FrsLiveTipResponseMessage frsLiveTipResponseMessage) {
            if (frsLiveTipResponseMessage != null) {
                a.this.hZx = frsLiveTipResponseMessage.remindType;
                a.this.hZy = frsLiveTipResponseMessage.remindText;
                a.this.hZz = frsLiveTipResponseMessage.infoCoreData;
                a.this.hZA = frsLiveTipResponseMessage.listCoreData;
                if (a.this.hZv != null) {
                    a.this.hZv.cdN();
                }
                if (a.this.hZx != 0) {
                    a.this.cgU();
                }
            }
        }
    };
    private Runnable hZD = new Runnable() { // from class: com.baidu.tieba.frs.live.a.2
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.hZB != null) {
                a.this.hZB.vT(a.this.mForumId);
            }
        }
    };
    private int hZw = cgY();

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
                if (this.hZB == null) {
                    this.hZB = new c(this.hZC);
                }
                e.lt().removeCallbacks(this.hZD);
                e.lt().postDelayed(this.hZD, 5000L);
            }
        }
    }

    public void cgU() {
        if (!StringUtils.isNull(this.hZy) && this.hZz != null) {
            if (this.hZx != 2 || cgY() < 3) {
                initView(this.hHU.getPageContext().getPageActivity());
                if (this.hUm != null) {
                    this.hUm.setText(this.hZy);
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
        ao.setBackgroundResource(this.hZt, R.drawable.bg_frs_hot_live_tip_selector);
        ao.setViewTextColor(this.hUm, R.color.cp_cont_a);
        ao.setImageResource(this.hZu, R.drawable.icon_home_card_close_white);
        this.hUm.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ao.getDrawable(R.drawable.icon_arrow_more_white), (Drawable) null);
    }

    private void initView(Context context) {
        if (context != null && this.hZt == null) {
            this.hZt = (FrameLayout) LayoutInflater.from(context).inflate(R.layout.frs_hot_live_tip, (ViewGroup) null);
            this.hZt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.live.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.cgW();
                }
            });
            this.hUm = (TextView) this.hZt.findViewById(R.id.frs_hot_live_tip_content);
            this.hZu = (ImageView) this.hZt.findViewById(R.id.frs_hot_live_tip_close);
            this.hZu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.live.a.4
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
            if (this.hZv == null) {
                this.hZv = new bc();
            }
            if (this.hZx == 2) {
                this.hZv.a(this.hZt, frameLayout, layoutParams, 5000);
            } else if (this.hZx == 1) {
                this.hZv.a(this.hZt, frameLayout, layoutParams);
                TiebaStatic.log(new ap("c12539"));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cgW() {
        cgZ();
        if (this.hZz != null && this.hHU != null && this.hHU.isAdded()) {
            boolean equals = TextUtils.equals(getUserId(), String.valueOf(this.hZz.userID));
            String str = "";
            if (this.hZx == 1) {
                str = "frs_followed_live_tip";
                TiebaStatic.log(new ap("c12540"));
                if (this.hZv != null) {
                    this.hZv.hideTip();
                }
            } else if (this.hZx == 2) {
                str = "frs_hot_live_tip";
                TiebaStatic.log(new ap("c12331"));
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(this.hHU.getPageContext().getPageActivity(), this.hZz, this.hZA, str, getUserId(), equals, null, null)));
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
        if (this.hZx == 2) {
            cgX();
        }
        if (this.hZv != null) {
            this.hZv.hideTip();
        }
    }

    private void cgX() {
        this.hZw++;
        com.baidu.tbadk.core.sharedPref.b.aZP().putInt(SharedPrefConfig.FRS_HOT_LIVE_TIP_CLOSE_NUM + getUserId(), this.hZw);
    }

    private int cgY() {
        return com.baidu.tbadk.core.sharedPref.b.aZP().getInt(SharedPrefConfig.FRS_HOT_LIVE_TIP_CLOSE_NUM + getUserId(), 0);
    }

    private void cgZ() {
        this.hZw = 0;
        com.baidu.tbadk.core.sharedPref.b.aZP().putInt(SharedPrefConfig.FRS_HOT_LIVE_TIP_CLOSE_NUM + getUserId(), this.hZw);
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
        if (this.hZv != null) {
            this.hZv.cdN();
        }
        e.lt().removeCallbacks(this.hZD);
        if (this.hZB != null) {
            this.hZB.onDestory();
        }
    }
}
