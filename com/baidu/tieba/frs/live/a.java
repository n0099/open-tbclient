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
import com.baidu.tieba.frs.aq;
import com.baidu.tieba.frs.k;
import com.baidu.tieba.frs.live.c;
/* loaded from: classes4.dex */
public class a {
    private TextView fHn;
    private ImageView fMA;
    private aq fMB;
    private int fMD;
    private String fME;
    private AlaLiveInfoCoreData fMF;
    private AlaLiveInfoListCoreData fMG;
    private c fMH;
    private FrameLayout fMz;
    private FrsFragment fwq;
    private int mForumId;
    private boolean isFirst = true;
    private c.a fMI = new c.a() { // from class: com.baidu.tieba.frs.live.a.1
        @Override // com.baidu.tieba.frs.live.c.a
        public void a(FrsLiveTipResponseMessage frsLiveTipResponseMessage) {
            if (frsLiveTipResponseMessage != null) {
                a.this.fMD = frsLiveTipResponseMessage.remindType;
                a.this.fME = frsLiveTipResponseMessage.remindText;
                a.this.fMF = frsLiveTipResponseMessage.infoCoreData;
                a.this.fMG = frsLiveTipResponseMessage.listCoreData;
                if (a.this.fMB != null) {
                    a.this.fMB.blQ();
                }
                if (a.this.fMD != 0) {
                    a.this.boR();
                }
            }
        }
    };
    private Runnable fMJ = new Runnable() { // from class: com.baidu.tieba.frs.live.a.2
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.fMH != null) {
                a.this.fMH.ru(a.this.mForumId);
            }
        }
    };
    private int fMC = boV();

    public a(FrsFragment frsFragment, int i) {
        this.fwq = frsFragment;
        this.mForumId = i;
    }

    public void boQ() {
        if (this.fwq != null && this.fwq.isAdded()) {
            if (System.currentTimeMillis() - getLastShowTime() >= 1800000) {
                if (this.fwq.bkc() && isFirst()) {
                    this.isFirst = false;
                    return;
                }
                if (this.fMH == null) {
                    this.fMH = new c(this.fMI);
                }
                e.fZ().removeCallbacks(this.fMJ);
                e.fZ().postDelayed(this.fMJ, 5000L);
            }
        }
    }

    public void boR() {
        if (!StringUtils.isNull(this.fME) && this.fMF != null) {
            if (this.fMD != 2 || boV() < 3) {
                initView(this.fwq.getPageContext().getPageActivity());
                if (this.fHn != null) {
                    this.fHn.setText(this.fME);
                }
                onChangeSkinType();
                aYL();
                saveLastShowTime();
            }
        }
    }

    public void boS() {
        if (this.fwq != null) {
            this.fwq.bjL().rX(49);
        }
    }

    private void onChangeSkinType() {
        am.setBackgroundResource(this.fMz, R.drawable.bg_frs_hot_live_tip_selector);
        am.setViewTextColor(this.fHn, (int) R.color.cp_cont_a);
        am.setImageResource(this.fMA, R.drawable.icon_home_card_close_white);
        this.fHn.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(R.drawable.icon_arrow_more_white), (Drawable) null);
    }

    private void initView(Context context) {
        if (context != null && this.fMz == null) {
            this.fMz = (FrameLayout) LayoutInflater.from(context).inflate(R.layout.frs_hot_live_tip, (ViewGroup) null);
            this.fMz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.live.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.boT();
                }
            });
            this.fHn = (TextView) this.fMz.findViewById(R.id.frs_hot_live_tip_content);
            this.fMA = (ImageView) this.fMz.findViewById(R.id.frs_hot_live_tip_close);
            this.fMA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.live.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.kB();
                }
            });
            onChangeSkinType();
        }
    }

    private void aYL() {
        k bjN;
        FrameLayout frameLayout;
        if (this.fwq != null && (bjN = this.fwq.bjN()) != null && bjN.getListView() != null && (frameLayout = (FrameLayout) bjN.bld()) != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds56));
            if (this.fMB == null) {
                this.fMB = new aq();
            }
            if (this.fMD == 2) {
                this.fMB.a(this.fMz, frameLayout, layoutParams, 5000);
            } else if (this.fMD == 1) {
                this.fMB.a(this.fMz, frameLayout, layoutParams);
                TiebaStatic.log(new an("c12539"));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void boT() {
        boW();
        if (this.fMF != null && this.fwq != null && this.fwq.isAdded()) {
            boolean equals = TextUtils.equals(getUserId(), String.valueOf(this.fMF.userID));
            String str = "";
            if (this.fMD == 1) {
                str = "frs_followed_live_tip";
                TiebaStatic.log(new an("c12540"));
                if (this.fMB != null) {
                    this.fMB.hideTip();
                }
            } else if (this.fMD == 2) {
                str = "frs_hot_live_tip";
                TiebaStatic.log(new an("c12331"));
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(this.fwq.getPageContext().getPageActivity(), this.fMF, this.fMG, str, getUserId(), equals, null, null)));
            if (this.fwq.bkn().getForum().isGameForumType()) {
                CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_GAME_FRS_JUMP_TO_LIVE_TAB);
                customMessage.setTag(this.fwq.getBaseFragmentActivity().getUniqueId());
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_FRS_JUMP_TO_LIVE_TAB);
                customResponsedMessage.setOrginalMessage(customMessage);
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                return;
            }
            e.fZ().post(new Runnable() { // from class: com.baidu.tieba.frs.live.a.5
                @Override // java.lang.Runnable
                public void run() {
                    a.this.boS();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kB() {
        if (this.fMD == 2) {
            boU();
        }
        if (this.fMB != null) {
            this.fMB.hideTip();
        }
    }

    private void boU() {
        this.fMC++;
        com.baidu.tbadk.core.sharedPref.b.alP().putInt(SharedPrefConfig.FRS_HOT_LIVE_TIP_CLOSE_NUM + getUserId(), this.fMC);
    }

    private int boV() {
        return com.baidu.tbadk.core.sharedPref.b.alP().getInt(SharedPrefConfig.FRS_HOT_LIVE_TIP_CLOSE_NUM + getUserId(), 0);
    }

    private void boW() {
        this.fMC = 0;
        com.baidu.tbadk.core.sharedPref.b.alP().putInt(SharedPrefConfig.FRS_HOT_LIVE_TIP_CLOSE_NUM + getUserId(), this.fMC);
    }

    private void saveLastShowTime() {
        com.baidu.tbadk.core.sharedPref.b.alP().putLong(SharedPrefConfig.FRS_HOT_LIVE_TIP_LAST_SHOWTIME + getUserId(), System.currentTimeMillis());
    }

    private long getLastShowTime() {
        return com.baidu.tbadk.core.sharedPref.b.alP().getLong(SharedPrefConfig.FRS_HOT_LIVE_TIP_LAST_SHOWTIME + getUserId(), 0L);
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
        if (this.fMB != null) {
            this.fMB.blQ();
        }
        e.fZ().removeCallbacks(this.fMJ);
        if (this.fMH != null) {
            this.fMH.onDestory();
        }
    }
}
