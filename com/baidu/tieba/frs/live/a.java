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
/* loaded from: classes6.dex */
public class a {
    private FrameLayout gAM;
    private ImageView gAN;
    private ar gAO;
    private int gAQ;
    private String gAR;
    private AlaLiveInfoCoreData gAS;
    private AlaLiveInfoListCoreData gAT;
    private c gAU;
    private FrsFragment gkN;
    private TextView gvG;
    private int mForumId;
    private boolean isFirst = true;
    private c.a gAV = new c.a() { // from class: com.baidu.tieba.frs.live.a.1
        @Override // com.baidu.tieba.frs.live.c.a
        public void a(FrsLiveTipResponseMessage frsLiveTipResponseMessage) {
            if (frsLiveTipResponseMessage != null) {
                a.this.gAQ = frsLiveTipResponseMessage.remindType;
                a.this.gAR = frsLiveTipResponseMessage.remindText;
                a.this.gAS = frsLiveTipResponseMessage.infoCoreData;
                a.this.gAT = frsLiveTipResponseMessage.listCoreData;
                if (a.this.gAO != null) {
                    a.this.gAO.bDm();
                }
                if (a.this.gAQ != 0) {
                    a.this.bGn();
                }
            }
        }
    };
    private Runnable gAW = new Runnable() { // from class: com.baidu.tieba.frs.live.a.2
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.gAU != null) {
                a.this.gAU.tA(a.this.mForumId);
            }
        }
    };
    private int gAP = bGr();

    public a(FrsFragment frsFragment, int i) {
        this.gkN = frsFragment;
        this.mForumId = i;
    }

    public void bGm() {
        if (this.gkN != null && this.gkN.isAdded()) {
            if (System.currentTimeMillis() - getLastShowTime() >= 1800000) {
                if (this.gkN.bBx() && isFirst()) {
                    this.isFirst = false;
                    return;
                }
                if (this.gAU == null) {
                    this.gAU = new c(this.gAV);
                }
                e.gy().removeCallbacks(this.gAW);
                e.gy().postDelayed(this.gAW, 5000L);
            }
        }
    }

    public void bGn() {
        if (!StringUtils.isNull(this.gAR) && this.gAS != null) {
            if (this.gAQ != 2 || bGr() < 3) {
                initView(this.gkN.getPageContext().getPageActivity());
                if (this.gvG != null) {
                    this.gvG.setText(this.gAR);
                }
                onChangeSkinType();
                bqM();
                saveLastShowTime();
            }
        }
    }

    public void bGo() {
        if (this.gkN != null) {
            this.gkN.bBg().uf(49);
        }
    }

    private void onChangeSkinType() {
        am.setBackgroundResource(this.gAM, R.drawable.bg_frs_hot_live_tip_selector);
        am.setViewTextColor(this.gvG, (int) R.color.cp_cont_a);
        am.setImageResource(this.gAN, R.drawable.icon_home_card_close_white);
        this.gvG.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(R.drawable.icon_arrow_more_white), (Drawable) null);
    }

    private void initView(Context context) {
        if (context != null && this.gAM == null) {
            this.gAM = (FrameLayout) LayoutInflater.from(context).inflate(R.layout.frs_hot_live_tip, (ViewGroup) null);
            this.gAM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.live.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.bGp();
                }
            });
            this.gvG = (TextView) this.gAM.findViewById(R.id.frs_hot_live_tip_content);
            this.gAN = (ImageView) this.gAM.findViewById(R.id.frs_hot_live_tip_close);
            this.gAN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.live.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.kS();
                }
            });
            onChangeSkinType();
        }
    }

    private void bqM() {
        l bBi;
        FrameLayout frameLayout;
        if (this.gkN != null && (bBi = this.gkN.bBi()) != null && bBi.getListView() != null && (frameLayout = (FrameLayout) bBi.bCz()) != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds56));
            if (this.gAO == null) {
                this.gAO = new ar();
            }
            if (this.gAQ == 2) {
                this.gAO.a(this.gAM, frameLayout, layoutParams, 5000);
            } else if (this.gAQ == 1) {
                this.gAO.a(this.gAM, frameLayout, layoutParams);
                TiebaStatic.log(new an("c12539"));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bGp() {
        bGs();
        if (this.gAS != null && this.gkN != null && this.gkN.isAdded()) {
            boolean equals = TextUtils.equals(getUserId(), String.valueOf(this.gAS.userID));
            String str = "";
            if (this.gAQ == 1) {
                str = "frs_followed_live_tip";
                TiebaStatic.log(new an("c12540"));
                if (this.gAO != null) {
                    this.gAO.hideTip();
                }
            } else if (this.gAQ == 2) {
                str = "frs_hot_live_tip";
                TiebaStatic.log(new an("c12331"));
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(this.gkN.getPageContext().getPageActivity(), this.gAS, this.gAT, str, getUserId(), equals, null, null)));
            if (this.gkN.bBI().getForum().isGameForumType()) {
                CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_GAME_FRS_JUMP_TO_LIVE_TAB);
                customMessage.setTag(this.gkN.getBaseFragmentActivity().getUniqueId());
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_FRS_JUMP_TO_LIVE_TAB);
                customResponsedMessage.setOrginalMessage(customMessage);
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                return;
            }
            e.gy().post(new Runnable() { // from class: com.baidu.tieba.frs.live.a.5
                @Override // java.lang.Runnable
                public void run() {
                    a.this.bGo();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kS() {
        if (this.gAQ == 2) {
            bGq();
        }
        if (this.gAO != null) {
            this.gAO.hideTip();
        }
    }

    private void bGq() {
        this.gAP++;
        com.baidu.tbadk.core.sharedPref.b.aCY().putInt(SharedPrefConfig.FRS_HOT_LIVE_TIP_CLOSE_NUM + getUserId(), this.gAP);
    }

    private int bGr() {
        return com.baidu.tbadk.core.sharedPref.b.aCY().getInt(SharedPrefConfig.FRS_HOT_LIVE_TIP_CLOSE_NUM + getUserId(), 0);
    }

    private void bGs() {
        this.gAP = 0;
        com.baidu.tbadk.core.sharedPref.b.aCY().putInt(SharedPrefConfig.FRS_HOT_LIVE_TIP_CLOSE_NUM + getUserId(), this.gAP);
    }

    private void saveLastShowTime() {
        com.baidu.tbadk.core.sharedPref.b.aCY().putLong(SharedPrefConfig.FRS_HOT_LIVE_TIP_LAST_SHOWTIME + getUserId(), System.currentTimeMillis());
    }

    private long getLastShowTime() {
        return com.baidu.tbadk.core.sharedPref.b.aCY().getLong(SharedPrefConfig.FRS_HOT_LIVE_TIP_LAST_SHOWTIME + getUserId(), 0L);
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
        if (this.gAO != null) {
            this.gAO.bDm();
        }
        e.gy().removeCallbacks(this.gAW);
        if (this.gAU != null) {
            this.gAU.onDestory();
        }
    }
}
