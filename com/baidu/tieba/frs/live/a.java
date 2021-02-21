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
    private FrameLayout jEn;
    private bb jEo;
    private int jEq;
    private String jEr;
    private AlaLiveInfoCoreData jEs;
    private AlaLiveInfoListCoreData jEt;
    private c jEu;
    private FrsFragment jiS;
    private ImageView jlZ;
    private TextView jyP;
    private int mForumId;
    private boolean isFirst = true;
    private c.a jEv = new c.a() { // from class: com.baidu.tieba.frs.live.a.1
        @Override // com.baidu.tieba.frs.live.c.a
        public void a(FrsLiveTipResponseMessage frsLiveTipResponseMessage) {
            if (frsLiveTipResponseMessage != null) {
                a.this.jEq = frsLiveTipResponseMessage.remindType;
                a.this.jEr = frsLiveTipResponseMessage.remindText;
                a.this.jEs = frsLiveTipResponseMessage.infoCoreData;
                a.this.jEt = frsLiveTipResponseMessage.listCoreData;
                if (a.this.jEo != null) {
                    a.this.jEo.cEX();
                }
                if (a.this.jEq != 0) {
                    a.this.cJp();
                }
            }
        }
    };
    private Runnable jEw = new Runnable() { // from class: com.baidu.tieba.frs.live.a.2
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.jEu != null) {
                a.this.jEu.zY(a.this.mForumId);
            }
        }
    };
    private int jEp = cJt();

    public a(FrsFragment frsFragment, int i) {
        this.jiS = frsFragment;
        this.mForumId = i;
    }

    public void cJo() {
        if (this.jiS != null && this.jiS.isAdded()) {
            if (System.currentTimeMillis() - getLastShowTime() >= 1800000) {
                if (this.jiS.cCS() && isFirst()) {
                    this.isFirst = false;
                    return;
                }
                if (this.jEu == null) {
                    this.jEu = new c(this.jEv);
                }
                e.mA().removeCallbacks(this.jEw);
                e.mA().postDelayed(this.jEw, 5000L);
            }
        }
    }

    public void cJp() {
        if (!StringUtils.isNull(this.jEr) && this.jEs != null) {
            if (this.jEq != 2 || cJt() < 3) {
                initView(this.jiS.getPageContext().getPageActivity());
                if (this.jyP != null) {
                    this.jyP.setText(this.jEr);
                }
                onChangeSkinType();
                cpf();
                saveLastShowTime();
            }
        }
    }

    public void cJq() {
        if (this.jiS != null) {
            this.jiS.cCz().sT(49);
        }
    }

    private void onChangeSkinType() {
        ap.setBackgroundResource(this.jEn, R.drawable.bg_frs_hot_live_tip_selector);
        ap.setViewTextColor(this.jyP, R.color.CAM_X0101);
        ap.setImageResource(this.jlZ, R.drawable.icon_home_card_close_white);
        this.jyP.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ap.getDrawable(R.drawable.icon_arrow_more_white), (Drawable) null);
    }

    private void initView(Context context) {
        if (context != null && this.jEn == null) {
            this.jEn = (FrameLayout) LayoutInflater.from(context).inflate(R.layout.frs_hot_live_tip, (ViewGroup) null);
            this.jEn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.live.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.cJr();
                }
            });
            this.jyP = (TextView) this.jEn.findViewById(R.id.frs_hot_live_tip_content);
            this.jlZ = (ImageView) this.jEn.findViewById(R.id.frs_hot_live_tip_close);
            this.jlZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.live.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.rp();
                }
            });
            onChangeSkinType();
        }
    }

    private void cpf() {
        q cCB;
        FrameLayout frameLayout;
        if (this.jiS != null && (cCB = this.jiS.cCB()) != null && cCB.getListView() != null && (frameLayout = (FrameLayout) cCB.cEc()) != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds56));
            if (this.jEo == null) {
                this.jEo = new bb();
            }
            if (this.jEq == 2) {
                this.jEo.a(this.jEn, frameLayout, layoutParams, 5000);
            } else if (this.jEq == 1) {
                this.jEo.a(this.jEn, frameLayout, layoutParams);
                TiebaStatic.log(new ar("c12539"));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cJr() {
        cJu();
        if (this.jEs != null && this.jiS != null && this.jiS.isAdded()) {
            boolean equals = TextUtils.equals(getUserId(), String.valueOf(this.jEs.userID));
            String str = "";
            if (this.jEq == 1) {
                str = "frs_followed_live_tip";
                TiebaStatic.log(new ar("c12540"));
                if (this.jEo != null) {
                    this.jEo.hideTip();
                }
            } else if (this.jEq == 2) {
                str = "frs_hot_live_tip";
                TiebaStatic.log(new ar("c12331"));
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(this.jiS.getPageContext().getPageActivity(), this.jEs, this.jEt, str, getUserId(), equals, null, null)));
            if (this.jiS.cDg().getForum().isGameForumType()) {
                CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_GAME_FRS_JUMP_TO_LIVE_TAB);
                customMessage.setTag(this.jiS.getBaseFragmentActivity().getUniqueId());
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_FRS_JUMP_TO_LIVE_TAB);
                customResponsedMessage.setOrginalMessage(customMessage);
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                return;
            }
            e.mA().post(new Runnable() { // from class: com.baidu.tieba.frs.live.a.5
                @Override // java.lang.Runnable
                public void run() {
                    a.this.cJq();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rp() {
        if (this.jEq == 2) {
            cJs();
        }
        if (this.jEo != null) {
            this.jEo.hideTip();
        }
    }

    private void cJs() {
        this.jEp++;
        com.baidu.tbadk.core.sharedPref.b.brQ().putInt(SharedPrefConfig.FRS_HOT_LIVE_TIP_CLOSE_NUM + getUserId(), this.jEp);
    }

    private int cJt() {
        return com.baidu.tbadk.core.sharedPref.b.brQ().getInt(SharedPrefConfig.FRS_HOT_LIVE_TIP_CLOSE_NUM + getUserId(), 0);
    }

    private void cJu() {
        this.jEp = 0;
        com.baidu.tbadk.core.sharedPref.b.brQ().putInt(SharedPrefConfig.FRS_HOT_LIVE_TIP_CLOSE_NUM + getUserId(), this.jEp);
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
        if (this.jEo != null) {
            this.jEo.cEX();
        }
        e.mA().removeCallbacks(this.jEw);
        if (this.jEu != null) {
            this.jEu.onDestory();
        }
    }
}
