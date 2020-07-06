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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.bc;
import com.baidu.tieba.frs.live.c;
import com.baidu.tieba.frs.p;
/* loaded from: classes9.dex */
public class a {
    private FrsFragment hBW;
    private TextView hOn;
    private AlaLiveInfoCoreData hTA;
    private AlaLiveInfoListCoreData hTB;
    private c hTC;
    private FrameLayout hTu;
    private ImageView hTv;
    private bc hTw;
    private int hTy;
    private String hTz;
    private int mForumId;
    private boolean isFirst = true;
    private c.a hTD = new c.a() { // from class: com.baidu.tieba.frs.live.a.1
        @Override // com.baidu.tieba.frs.live.c.a
        public void a(FrsLiveTipResponseMessage frsLiveTipResponseMessage) {
            if (frsLiveTipResponseMessage != null) {
                a.this.hTy = frsLiveTipResponseMessage.remindType;
                a.this.hTz = frsLiveTipResponseMessage.remindText;
                a.this.hTA = frsLiveTipResponseMessage.infoCoreData;
                a.this.hTB = frsLiveTipResponseMessage.listCoreData;
                if (a.this.hTw != null) {
                    a.this.hTw.cap();
                }
                if (a.this.hTy != 0) {
                    a.this.cdv();
                }
            }
        }
    };
    private Runnable hTE = new Runnable() { // from class: com.baidu.tieba.frs.live.a.2
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.hTC != null) {
                a.this.hTC.vB(a.this.mForumId);
            }
        }
    };
    private int hTx = cdz();

    public a(FrsFragment frsFragment, int i) {
        this.hBW = frsFragment;
        this.mForumId = i;
    }

    public void cdu() {
        if (this.hBW != null && this.hBW.isAdded()) {
            if (System.currentTimeMillis() - getLastShowTime() >= 1800000) {
                if (this.hBW.bYr() && isFirst()) {
                    this.isFirst = false;
                    return;
                }
                if (this.hTC == null) {
                    this.hTC = new c(this.hTD);
                }
                e.lt().removeCallbacks(this.hTE);
                e.lt().postDelayed(this.hTE, 5000L);
            }
        }
    }

    public void cdv() {
        if (!StringUtils.isNull(this.hTz) && this.hTA != null) {
            if (this.hTy != 2 || cdz() < 3) {
                initView(this.hBW.getPageContext().getPageActivity());
                if (this.hOn != null) {
                    this.hOn.setText(this.hTz);
                }
                onChangeSkinType();
                bMH();
                saveLastShowTime();
            }
        }
    }

    public void cdw() {
        if (this.hBW != null) {
            this.hBW.bXY().wi(49);
        }
    }

    private void onChangeSkinType() {
        an.setBackgroundResource(this.hTu, R.drawable.bg_frs_hot_live_tip_selector);
        an.setViewTextColor(this.hOn, (int) R.color.cp_cont_a);
        an.setImageResource(this.hTv, R.drawable.icon_home_card_close_white);
        this.hOn.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, an.getDrawable(R.drawable.icon_arrow_more_white), (Drawable) null);
    }

    private void initView(Context context) {
        if (context != null && this.hTu == null) {
            this.hTu = (FrameLayout) LayoutInflater.from(context).inflate(R.layout.frs_hot_live_tip, (ViewGroup) null);
            this.hTu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.live.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.cdx();
                }
            });
            this.hOn = (TextView) this.hTu.findViewById(R.id.frs_hot_live_tip_content);
            this.hTv = (ImageView) this.hTu.findViewById(R.id.frs_hot_live_tip_close);
            this.hTv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.live.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.qj();
                }
            });
            onChangeSkinType();
        }
    }

    private void bMH() {
        p bYa;
        FrameLayout frameLayout;
        if (this.hBW != null && (bYa = this.hBW.bYa()) != null && bYa.getListView() != null && (frameLayout = (FrameLayout) bYa.bZy()) != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds56));
            if (this.hTw == null) {
                this.hTw = new bc();
            }
            if (this.hTy == 2) {
                this.hTw.a(this.hTu, frameLayout, layoutParams, 5000);
            } else if (this.hTy == 1) {
                this.hTw.a(this.hTu, frameLayout, layoutParams);
                TiebaStatic.log(new ao("c12539"));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cdx() {
        cdA();
        if (this.hTA != null && this.hBW != null && this.hBW.isAdded()) {
            boolean equals = TextUtils.equals(getUserId(), String.valueOf(this.hTA.userID));
            String str = "";
            if (this.hTy == 1) {
                str = "frs_followed_live_tip";
                TiebaStatic.log(new ao("c12540"));
                if (this.hTw != null) {
                    this.hTw.hideTip();
                }
            } else if (this.hTy == 2) {
                str = "frs_hot_live_tip";
                TiebaStatic.log(new ao("c12331"));
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(this.hBW.getPageContext().getPageActivity(), this.hTA, this.hTB, str, getUserId(), equals, null, null)));
            if (this.hBW.bYC().getForum().isGameForumType()) {
                CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_GAME_FRS_JUMP_TO_LIVE_TAB);
                customMessage.setTag(this.hBW.getBaseFragmentActivity().getUniqueId());
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_FRS_JUMP_TO_LIVE_TAB);
                customResponsedMessage.setOrginalMessage(customMessage);
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                return;
            }
            e.lt().post(new Runnable() { // from class: com.baidu.tieba.frs.live.a.5
                @Override // java.lang.Runnable
                public void run() {
                    a.this.cdw();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qj() {
        if (this.hTy == 2) {
            cdy();
        }
        if (this.hTw != null) {
            this.hTw.hideTip();
        }
    }

    private void cdy() {
        this.hTx++;
        com.baidu.tbadk.core.sharedPref.b.aVP().putInt(SharedPrefConfig.FRS_HOT_LIVE_TIP_CLOSE_NUM + getUserId(), this.hTx);
    }

    private int cdz() {
        return com.baidu.tbadk.core.sharedPref.b.aVP().getInt(SharedPrefConfig.FRS_HOT_LIVE_TIP_CLOSE_NUM + getUserId(), 0);
    }

    private void cdA() {
        this.hTx = 0;
        com.baidu.tbadk.core.sharedPref.b.aVP().putInt(SharedPrefConfig.FRS_HOT_LIVE_TIP_CLOSE_NUM + getUserId(), this.hTx);
    }

    private void saveLastShowTime() {
        com.baidu.tbadk.core.sharedPref.b.aVP().putLong(SharedPrefConfig.FRS_HOT_LIVE_TIP_LAST_SHOWTIME + getUserId(), System.currentTimeMillis());
    }

    private long getLastShowTime() {
        return com.baidu.tbadk.core.sharedPref.b.aVP().getLong(SharedPrefConfig.FRS_HOT_LIVE_TIP_LAST_SHOWTIME + getUserId(), 0L);
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
        if (this.hTw != null) {
            this.hTw.cap();
        }
        e.lt().removeCallbacks(this.hTE);
        if (this.hTC != null) {
            this.hTC.onDestory();
        }
    }
}
