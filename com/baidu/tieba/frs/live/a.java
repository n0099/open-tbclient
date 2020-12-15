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
import com.baidu.tieba.frs.be;
import com.baidu.tieba.frs.live.c;
import com.baidu.tieba.frs.q;
/* loaded from: classes22.dex */
public class a {
    private FrsFragment iVs;
    private ImageView iYy;
    private TextView jlc;
    private FrameLayout jqE;
    private be jqF;
    private int jqH;
    private String jqI;
    private AlaLiveInfoCoreData jqJ;
    private AlaLiveInfoListCoreData jqK;
    private c jqL;
    private int mForumId;
    private boolean isFirst = true;
    private c.a jqM = new c.a() { // from class: com.baidu.tieba.frs.live.a.1
        @Override // com.baidu.tieba.frs.live.c.a
        public void a(FrsLiveTipResponseMessage frsLiveTipResponseMessage) {
            if (frsLiveTipResponseMessage != null) {
                a.this.jqH = frsLiveTipResponseMessage.remindType;
                a.this.jqI = frsLiveTipResponseMessage.remindText;
                a.this.jqJ = frsLiveTipResponseMessage.infoCoreData;
                a.this.jqK = frsLiveTipResponseMessage.listCoreData;
                if (a.this.jqF != null) {
                    a.this.jqF.cEA();
                }
                if (a.this.jqH != 0) {
                    a.this.cIM();
                }
            }
        }
    };
    private Runnable jqN = new Runnable() { // from class: com.baidu.tieba.frs.live.a.2
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.jqL != null) {
                a.this.jqL.Bj(a.this.mForumId);
            }
        }
    };
    private int jqG = cIQ();

    public a(FrsFragment frsFragment, int i) {
        this.iVs = frsFragment;
        this.mForumId = i;
    }

    public void cIL() {
        if (this.iVs != null && this.iVs.isAdded()) {
            if (System.currentTimeMillis() - getLastShowTime() >= 1800000) {
                if (this.iVs.cCw() && isFirst()) {
                    this.isFirst = false;
                    return;
                }
                if (this.jqL == null) {
                    this.jqL = new c(this.jqM);
                }
                e.mY().removeCallbacks(this.jqN);
                e.mY().postDelayed(this.jqN, 5000L);
            }
        }
    }

    public void cIM() {
        if (!StringUtils.isNull(this.jqI) && this.jqJ != null) {
            if (this.jqH != 2 || cIQ() < 3) {
                ev(this.iVs.getPageContext().getPageActivity());
                if (this.jlc != null) {
                    this.jlc.setText(this.jqI);
                }
                onChangeSkinType();
                coR();
                saveLastShowTime();
            }
        }
    }

    public void cIN() {
        if (this.iVs != null) {
            this.iVs.cCd().ui(49);
        }
    }

    private void onChangeSkinType() {
        ap.setBackgroundResource(this.jqE, R.drawable.bg_frs_hot_live_tip_selector);
        ap.setViewTextColor(this.jlc, R.color.CAM_X0101);
        ap.setImageResource(this.iYy, R.drawable.icon_home_card_close_white);
        this.jlc.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ap.getDrawable(R.drawable.icon_arrow_more_white), (Drawable) null);
    }

    private void ev(Context context) {
        if (context != null && this.jqE == null) {
            this.jqE = (FrameLayout) LayoutInflater.from(context).inflate(R.layout.frs_hot_live_tip, (ViewGroup) null);
            this.jqE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.live.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.cIO();
                }
            });
            this.jlc = (TextView) this.jqE.findViewById(R.id.frs_hot_live_tip_content);
            this.iYy = (ImageView) this.jqE.findViewById(R.id.frs_hot_live_tip_close);
            this.iYy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.live.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.rQ();
                }
            });
            onChangeSkinType();
        }
    }

    private void coR() {
        q cCf;
        FrameLayout frameLayout;
        if (this.iVs != null && (cCf = this.iVs.cCf()) != null && cCf.getListView() != null && (frameLayout = (FrameLayout) cCf.cDG()) != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds56));
            if (this.jqF == null) {
                this.jqF = new be();
            }
            if (this.jqH == 2) {
                this.jqF.a(this.jqE, frameLayout, layoutParams, 5000);
            } else if (this.jqH == 1) {
                this.jqF.a(this.jqE, frameLayout, layoutParams);
                TiebaStatic.log(new ar("c12539"));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cIO() {
        cIR();
        if (this.jqJ != null && this.iVs != null && this.iVs.isAdded()) {
            boolean equals = TextUtils.equals(getUserId(), String.valueOf(this.jqJ.userID));
            String str = "";
            if (this.jqH == 1) {
                str = "frs_followed_live_tip";
                TiebaStatic.log(new ar("c12540"));
                if (this.jqF != null) {
                    this.jqF.hideTip();
                }
            } else if (this.jqH == 2) {
                str = "frs_hot_live_tip";
                TiebaStatic.log(new ar("c12331"));
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(this.iVs.getPageContext().getPageActivity(), this.jqJ, this.jqK, str, getUserId(), equals, null, null)));
            if (this.iVs.cCK().getForum().isGameForumType()) {
                CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_GAME_FRS_JUMP_TO_LIVE_TAB);
                customMessage.setTag(this.iVs.getBaseFragmentActivity().getUniqueId());
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_FRS_JUMP_TO_LIVE_TAB);
                customResponsedMessage.setOrginalMessage(customMessage);
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                return;
            }
            e.mY().post(new Runnable() { // from class: com.baidu.tieba.frs.live.a.5
                @Override // java.lang.Runnable
                public void run() {
                    a.this.cIN();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rQ() {
        if (this.jqH == 2) {
            cIP();
        }
        if (this.jqF != null) {
            this.jqF.hideTip();
        }
    }

    private void cIP() {
        this.jqG++;
        com.baidu.tbadk.core.sharedPref.b.bsO().putInt(SharedPrefConfig.FRS_HOT_LIVE_TIP_CLOSE_NUM + getUserId(), this.jqG);
    }

    private int cIQ() {
        return com.baidu.tbadk.core.sharedPref.b.bsO().getInt(SharedPrefConfig.FRS_HOT_LIVE_TIP_CLOSE_NUM + getUserId(), 0);
    }

    private void cIR() {
        this.jqG = 0;
        com.baidu.tbadk.core.sharedPref.b.bsO().putInt(SharedPrefConfig.FRS_HOT_LIVE_TIP_CLOSE_NUM + getUserId(), this.jqG);
    }

    private void saveLastShowTime() {
        com.baidu.tbadk.core.sharedPref.b.bsO().putLong(SharedPrefConfig.FRS_HOT_LIVE_TIP_LAST_SHOWTIME + getUserId(), System.currentTimeMillis());
    }

    private long getLastShowTime() {
        return com.baidu.tbadk.core.sharedPref.b.bsO().getLong(SharedPrefConfig.FRS_HOT_LIVE_TIP_LAST_SHOWTIME + getUserId(), 0L);
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
        if (this.jqF != null) {
            this.jqF.cEA();
        }
        e.mY().removeCallbacks(this.jqN);
        if (this.jqL != null) {
            this.jqL.onDestory();
        }
    }
}
