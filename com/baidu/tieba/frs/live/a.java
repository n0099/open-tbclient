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
    private TextView gAQ;
    private FrameLayout gFV;
    private ImageView gFW;
    private ar gFX;
    private int gFZ;
    private String gGa;
    private AlaLiveInfoCoreData gGb;
    private AlaLiveInfoListCoreData gGc;
    private c gGd;
    private FrsFragment gpX;
    private int mForumId;
    private boolean isFirst = true;
    private c.a gGe = new c.a() { // from class: com.baidu.tieba.frs.live.a.1
        @Override // com.baidu.tieba.frs.live.c.a
        public void a(FrsLiveTipResponseMessage frsLiveTipResponseMessage) {
            if (frsLiveTipResponseMessage != null) {
                a.this.gFZ = frsLiveTipResponseMessage.remindType;
                a.this.gGa = frsLiveTipResponseMessage.remindText;
                a.this.gGb = frsLiveTipResponseMessage.infoCoreData;
                a.this.gGc = frsLiveTipResponseMessage.listCoreData;
                if (a.this.gFX != null) {
                    a.this.gFX.bFQ();
                }
                if (a.this.gFZ != 0) {
                    a.this.bIR();
                }
            }
        }
    };
    private Runnable gGf = new Runnable() { // from class: com.baidu.tieba.frs.live.a.2
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.gGd != null) {
                a.this.gGd.tL(a.this.mForumId);
            }
        }
    };
    private int gFY = bIV();

    public a(FrsFragment frsFragment, int i) {
        this.gpX = frsFragment;
        this.mForumId = i;
    }

    public void bIQ() {
        if (this.gpX != null && this.gpX.isAdded()) {
            if (System.currentTimeMillis() - getLastShowTime() >= 1800000) {
                if (this.gpX.bEc() && isFirst()) {
                    this.isFirst = false;
                    return;
                }
                if (this.gGd == null) {
                    this.gGd = new c(this.gGe);
                }
                e.gx().removeCallbacks(this.gGf);
                e.gx().postDelayed(this.gGf, 5000L);
            }
        }
    }

    public void bIR() {
        if (!StringUtils.isNull(this.gGa) && this.gGb != null) {
            if (this.gFZ != 2 || bIV() < 3) {
                initView(this.gpX.getPageContext().getPageActivity());
                if (this.gAQ != null) {
                    this.gAQ.setText(this.gGa);
                }
                onChangeSkinType();
                bts();
                saveLastShowTime();
            }
        }
    }

    public void bIS() {
        if (this.gpX != null) {
            this.gpX.bDL().uq(49);
        }
    }

    private void onChangeSkinType() {
        am.setBackgroundResource(this.gFV, R.drawable.bg_frs_hot_live_tip_selector);
        am.setViewTextColor(this.gAQ, (int) R.color.cp_cont_a);
        am.setImageResource(this.gFW, R.drawable.icon_home_card_close_white);
        this.gAQ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(R.drawable.icon_arrow_more_white), (Drawable) null);
    }

    private void initView(Context context) {
        if (context != null && this.gFV == null) {
            this.gFV = (FrameLayout) LayoutInflater.from(context).inflate(R.layout.frs_hot_live_tip, (ViewGroup) null);
            this.gFV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.live.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.bIT();
                }
            });
            this.gAQ = (TextView) this.gFV.findViewById(R.id.frs_hot_live_tip_content);
            this.gFW = (ImageView) this.gFV.findViewById(R.id.frs_hot_live_tip_close);
            this.gFW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.live.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.li();
                }
            });
            onChangeSkinType();
        }
    }

    private void bts() {
        l bDN;
        FrameLayout frameLayout;
        if (this.gpX != null && (bDN = this.gpX.bDN()) != null && bDN.getListView() != null && (frameLayout = (FrameLayout) bDN.bFe()) != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds56));
            if (this.gFX == null) {
                this.gFX = new ar();
            }
            if (this.gFZ == 2) {
                this.gFX.a(this.gFV, frameLayout, layoutParams, 5000);
            } else if (this.gFZ == 1) {
                this.gFX.a(this.gFV, frameLayout, layoutParams);
                TiebaStatic.log(new an("c12539"));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIT() {
        bIW();
        if (this.gGb != null && this.gpX != null && this.gpX.isAdded()) {
            boolean equals = TextUtils.equals(getUserId(), String.valueOf(this.gGb.userID));
            String str = "";
            if (this.gFZ == 1) {
                str = "frs_followed_live_tip";
                TiebaStatic.log(new an("c12540"));
                if (this.gFX != null) {
                    this.gFX.hideTip();
                }
            } else if (this.gFZ == 2) {
                str = "frs_hot_live_tip";
                TiebaStatic.log(new an("c12331"));
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(this.gpX.getPageContext().getPageActivity(), this.gGb, this.gGc, str, getUserId(), equals, null, null)));
            if (this.gpX.bEn().getForum().isGameForumType()) {
                CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_GAME_FRS_JUMP_TO_LIVE_TAB);
                customMessage.setTag(this.gpX.getBaseFragmentActivity().getUniqueId());
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_FRS_JUMP_TO_LIVE_TAB);
                customResponsedMessage.setOrginalMessage(customMessage);
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                return;
            }
            e.gx().post(new Runnable() { // from class: com.baidu.tieba.frs.live.a.5
                @Override // java.lang.Runnable
                public void run() {
                    a.this.bIS();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void li() {
        if (this.gFZ == 2) {
            bIU();
        }
        if (this.gFX != null) {
            this.gFX.hideTip();
        }
    }

    private void bIU() {
        this.gFY++;
        com.baidu.tbadk.core.sharedPref.b.aFB().putInt(SharedPrefConfig.FRS_HOT_LIVE_TIP_CLOSE_NUM + getUserId(), this.gFY);
    }

    private int bIV() {
        return com.baidu.tbadk.core.sharedPref.b.aFB().getInt(SharedPrefConfig.FRS_HOT_LIVE_TIP_CLOSE_NUM + getUserId(), 0);
    }

    private void bIW() {
        this.gFY = 0;
        com.baidu.tbadk.core.sharedPref.b.aFB().putInt(SharedPrefConfig.FRS_HOT_LIVE_TIP_CLOSE_NUM + getUserId(), this.gFY);
    }

    private void saveLastShowTime() {
        com.baidu.tbadk.core.sharedPref.b.aFB().putLong(SharedPrefConfig.FRS_HOT_LIVE_TIP_LAST_SHOWTIME + getUserId(), System.currentTimeMillis());
    }

    private long getLastShowTime() {
        return com.baidu.tbadk.core.sharedPref.b.aFB().getLong(SharedPrefConfig.FRS_HOT_LIVE_TIP_LAST_SHOWTIME + getUserId(), 0L);
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
        if (this.gFX != null) {
            this.gFX.bFQ();
        }
        e.gx().removeCallbacks(this.gGf);
        if (this.gGd != null) {
            this.gGd.onDestory();
        }
    }
}
