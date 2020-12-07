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
    private FrsFragment iVq;
    private ImageView iYw;
    private TextView jla;
    private FrameLayout jqC;
    private be jqD;
    private int jqF;
    private String jqG;
    private AlaLiveInfoCoreData jqH;
    private AlaLiveInfoListCoreData jqI;
    private c jqJ;
    private int mForumId;
    private boolean isFirst = true;
    private c.a jqK = new c.a() { // from class: com.baidu.tieba.frs.live.a.1
        @Override // com.baidu.tieba.frs.live.c.a
        public void a(FrsLiveTipResponseMessage frsLiveTipResponseMessage) {
            if (frsLiveTipResponseMessage != null) {
                a.this.jqF = frsLiveTipResponseMessage.remindType;
                a.this.jqG = frsLiveTipResponseMessage.remindText;
                a.this.jqH = frsLiveTipResponseMessage.infoCoreData;
                a.this.jqI = frsLiveTipResponseMessage.listCoreData;
                if (a.this.jqD != null) {
                    a.this.jqD.cEz();
                }
                if (a.this.jqF != 0) {
                    a.this.cIL();
                }
            }
        }
    };
    private Runnable jqL = new Runnable() { // from class: com.baidu.tieba.frs.live.a.2
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.jqJ != null) {
                a.this.jqJ.Bj(a.this.mForumId);
            }
        }
    };
    private int jqE = cIP();

    public a(FrsFragment frsFragment, int i) {
        this.iVq = frsFragment;
        this.mForumId = i;
    }

    public void cIK() {
        if (this.iVq != null && this.iVq.isAdded()) {
            if (System.currentTimeMillis() - getLastShowTime() >= 1800000) {
                if (this.iVq.cCv() && isFirst()) {
                    this.isFirst = false;
                    return;
                }
                if (this.jqJ == null) {
                    this.jqJ = new c(this.jqK);
                }
                e.mY().removeCallbacks(this.jqL);
                e.mY().postDelayed(this.jqL, 5000L);
            }
        }
    }

    public void cIL() {
        if (!StringUtils.isNull(this.jqG) && this.jqH != null) {
            if (this.jqF != 2 || cIP() < 3) {
                ev(this.iVq.getPageContext().getPageActivity());
                if (this.jla != null) {
                    this.jla.setText(this.jqG);
                }
                onChangeSkinType();
                coQ();
                saveLastShowTime();
            }
        }
    }

    public void cIM() {
        if (this.iVq != null) {
            this.iVq.cCc().ui(49);
        }
    }

    private void onChangeSkinType() {
        ap.setBackgroundResource(this.jqC, R.drawable.bg_frs_hot_live_tip_selector);
        ap.setViewTextColor(this.jla, R.color.CAM_X0101);
        ap.setImageResource(this.iYw, R.drawable.icon_home_card_close_white);
        this.jla.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ap.getDrawable(R.drawable.icon_arrow_more_white), (Drawable) null);
    }

    private void ev(Context context) {
        if (context != null && this.jqC == null) {
            this.jqC = (FrameLayout) LayoutInflater.from(context).inflate(R.layout.frs_hot_live_tip, (ViewGroup) null);
            this.jqC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.live.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.cIN();
                }
            });
            this.jla = (TextView) this.jqC.findViewById(R.id.frs_hot_live_tip_content);
            this.iYw = (ImageView) this.jqC.findViewById(R.id.frs_hot_live_tip_close);
            this.iYw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.live.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.rQ();
                }
            });
            onChangeSkinType();
        }
    }

    private void coQ() {
        q cCe;
        FrameLayout frameLayout;
        if (this.iVq != null && (cCe = this.iVq.cCe()) != null && cCe.getListView() != null && (frameLayout = (FrameLayout) cCe.cDF()) != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds56));
            if (this.jqD == null) {
                this.jqD = new be();
            }
            if (this.jqF == 2) {
                this.jqD.a(this.jqC, frameLayout, layoutParams, 5000);
            } else if (this.jqF == 1) {
                this.jqD.a(this.jqC, frameLayout, layoutParams);
                TiebaStatic.log(new ar("c12539"));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cIN() {
        cIQ();
        if (this.jqH != null && this.iVq != null && this.iVq.isAdded()) {
            boolean equals = TextUtils.equals(getUserId(), String.valueOf(this.jqH.userID));
            String str = "";
            if (this.jqF == 1) {
                str = "frs_followed_live_tip";
                TiebaStatic.log(new ar("c12540"));
                if (this.jqD != null) {
                    this.jqD.hideTip();
                }
            } else if (this.jqF == 2) {
                str = "frs_hot_live_tip";
                TiebaStatic.log(new ar("c12331"));
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(this.iVq.getPageContext().getPageActivity(), this.jqH, this.jqI, str, getUserId(), equals, null, null)));
            if (this.iVq.cCJ().getForum().isGameForumType()) {
                CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_GAME_FRS_JUMP_TO_LIVE_TAB);
                customMessage.setTag(this.iVq.getBaseFragmentActivity().getUniqueId());
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_FRS_JUMP_TO_LIVE_TAB);
                customResponsedMessage.setOrginalMessage(customMessage);
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                return;
            }
            e.mY().post(new Runnable() { // from class: com.baidu.tieba.frs.live.a.5
                @Override // java.lang.Runnable
                public void run() {
                    a.this.cIM();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rQ() {
        if (this.jqF == 2) {
            cIO();
        }
        if (this.jqD != null) {
            this.jqD.hideTip();
        }
    }

    private void cIO() {
        this.jqE++;
        com.baidu.tbadk.core.sharedPref.b.bsO().putInt(SharedPrefConfig.FRS_HOT_LIVE_TIP_CLOSE_NUM + getUserId(), this.jqE);
    }

    private int cIP() {
        return com.baidu.tbadk.core.sharedPref.b.bsO().getInt(SharedPrefConfig.FRS_HOT_LIVE_TIP_CLOSE_NUM + getUserId(), 0);
    }

    private void cIQ() {
        this.jqE = 0;
        com.baidu.tbadk.core.sharedPref.b.bsO().putInt(SharedPrefConfig.FRS_HOT_LIVE_TIP_CLOSE_NUM + getUserId(), this.jqE);
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
        if (this.jqD != null) {
            this.jqD.cEz();
        }
        e.mY().removeCallbacks(this.jqL);
        if (this.jqJ != null) {
            this.jqJ.onDestory();
        }
    }
}
