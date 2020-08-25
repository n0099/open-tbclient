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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.be;
import com.baidu.tieba.frs.live.c;
import com.baidu.tieba.frs.q;
/* loaded from: classes16.dex */
public class a {
    private FrsFragment hVk;
    private ImageView hYs;
    private TextView iiv;
    private FrameLayout inE;
    private be inF;
    private int inH;
    private String inI;
    private AlaLiveInfoCoreData inJ;
    private AlaLiveInfoListCoreData inK;
    private c inL;
    private int mForumId;
    private boolean isFirst = true;
    private c.a inM = new c.a() { // from class: com.baidu.tieba.frs.live.a.1
        @Override // com.baidu.tieba.frs.live.c.a
        public void a(FrsLiveTipResponseMessage frsLiveTipResponseMessage) {
            if (frsLiveTipResponseMessage != null) {
                a.this.inH = frsLiveTipResponseMessage.remindType;
                a.this.inI = frsLiveTipResponseMessage.remindText;
                a.this.inJ = frsLiveTipResponseMessage.infoCoreData;
                a.this.inK = frsLiveTipResponseMessage.listCoreData;
                if (a.this.inF != null) {
                    a.this.inF.com();
                }
                if (a.this.inH != 0) {
                    a.this.crz();
                }
            }
        }
    };
    private Runnable inN = new Runnable() { // from class: com.baidu.tieba.frs.live.a.2
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.inL != null) {
                a.this.inL.ym(a.this.mForumId);
            }
        }
    };
    private int inG = crD();

    public a(FrsFragment frsFragment, int i) {
        this.hVk = frsFragment;
        this.mForumId = i;
    }

    public void cry() {
        if (this.hVk != null && this.hVk.isAdded()) {
            if (System.currentTimeMillis() - getLastShowTime() >= 1800000) {
                if (this.hVk.cmj() && isFirst()) {
                    this.isFirst = false;
                    return;
                }
                if (this.inL == null) {
                    this.inL = new c(this.inM);
                }
                e.mS().removeCallbacks(this.inN);
                e.mS().postDelayed(this.inN, 5000L);
            }
        }
    }

    public void crz() {
        if (!StringUtils.isNull(this.inI) && this.inJ != null) {
            if (this.inH != 2 || crD() < 3) {
                dL(this.hVk.getPageContext().getPageActivity());
                if (this.iiv != null) {
                    this.iiv.setText(this.inI);
                }
                onChangeSkinType();
                bZY();
                saveLastShowTime();
            }
        }
    }

    public void crA() {
        if (this.hVk != null) {
            this.hVk.clQ().yU(49);
        }
    }

    private void onChangeSkinType() {
        ap.setBackgroundResource(this.inE, R.drawable.bg_frs_hot_live_tip_selector);
        ap.setViewTextColor(this.iiv, R.color.cp_cont_a);
        ap.setImageResource(this.hYs, R.drawable.icon_home_card_close_white);
        this.iiv.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ap.getDrawable(R.drawable.icon_arrow_more_white), (Drawable) null);
    }

    private void dL(Context context) {
        if (context != null && this.inE == null) {
            this.inE = (FrameLayout) LayoutInflater.from(context).inflate(R.layout.frs_hot_live_tip, (ViewGroup) null);
            this.inE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.live.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.crB();
                }
            });
            this.iiv = (TextView) this.inE.findViewById(R.id.frs_hot_live_tip_content);
            this.hYs = (ImageView) this.inE.findViewById(R.id.frs_hot_live_tip_close);
            this.hYs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.live.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.rJ();
                }
            });
            onChangeSkinType();
        }
    }

    private void bZY() {
        q clS;
        FrameLayout frameLayout;
        if (this.hVk != null && (clS = this.hVk.clS()) != null && clS.getListView() != null && (frameLayout = (FrameLayout) clS.cns()) != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds56));
            if (this.inF == null) {
                this.inF = new be();
            }
            if (this.inH == 2) {
                this.inF.a(this.inE, frameLayout, layoutParams, 5000);
            } else if (this.inH == 1) {
                this.inF.a(this.inE, frameLayout, layoutParams);
                TiebaStatic.log(new aq("c12539"));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void crB() {
        crE();
        if (this.inJ != null && this.hVk != null && this.hVk.isAdded()) {
            boolean equals = TextUtils.equals(getUserId(), String.valueOf(this.inJ.userID));
            String str = "";
            if (this.inH == 1) {
                str = "frs_followed_live_tip";
                TiebaStatic.log(new aq("c12540"));
                if (this.inF != null) {
                    this.inF.hideTip();
                }
            } else if (this.inH == 2) {
                str = "frs_hot_live_tip";
                TiebaStatic.log(new aq("c12331"));
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(this.hVk.getPageContext().getPageActivity(), this.inJ, this.inK, str, getUserId(), equals, null, null)));
            if (this.hVk.cmw().getForum().isGameForumType()) {
                CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_GAME_FRS_JUMP_TO_LIVE_TAB);
                customMessage.setTag(this.hVk.getBaseFragmentActivity().getUniqueId());
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_FRS_JUMP_TO_LIVE_TAB);
                customResponsedMessage.setOrginalMessage(customMessage);
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                return;
            }
            e.mS().post(new Runnable() { // from class: com.baidu.tieba.frs.live.a.5
                @Override // java.lang.Runnable
                public void run() {
                    a.this.crA();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rJ() {
        if (this.inH == 2) {
            crC();
        }
        if (this.inF != null) {
            this.inF.hideTip();
        }
    }

    private void crC() {
        this.inG++;
        com.baidu.tbadk.core.sharedPref.b.bik().putInt(SharedPrefConfig.FRS_HOT_LIVE_TIP_CLOSE_NUM + getUserId(), this.inG);
    }

    private int crD() {
        return com.baidu.tbadk.core.sharedPref.b.bik().getInt(SharedPrefConfig.FRS_HOT_LIVE_TIP_CLOSE_NUM + getUserId(), 0);
    }

    private void crE() {
        this.inG = 0;
        com.baidu.tbadk.core.sharedPref.b.bik().putInt(SharedPrefConfig.FRS_HOT_LIVE_TIP_CLOSE_NUM + getUserId(), this.inG);
    }

    private void saveLastShowTime() {
        com.baidu.tbadk.core.sharedPref.b.bik().putLong(SharedPrefConfig.FRS_HOT_LIVE_TIP_LAST_SHOWTIME + getUserId(), System.currentTimeMillis());
    }

    private long getLastShowTime() {
        return com.baidu.tbadk.core.sharedPref.b.bik().getLong(SharedPrefConfig.FRS_HOT_LIVE_TIP_LAST_SHOWTIME + getUserId(), 0L);
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
        if (this.inF != null) {
            this.inF.com();
        }
        e.mS().removeCallbacks(this.inN);
        if (this.inL != null) {
            this.inL.onDestory();
        }
    }
}
