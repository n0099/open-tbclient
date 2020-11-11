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
/* loaded from: classes22.dex */
public class a {
    private FrsFragment iJK;
    private ImageView iMS;
    private TextView iWP;
    private FrameLayout jcm;
    private be jcn;
    private int jcp;
    private String jcq;
    private AlaLiveInfoCoreData jcr;
    private AlaLiveInfoListCoreData jcs;
    private c jct;
    private int mForumId;
    private boolean isFirst = true;
    private c.a jcu = new c.a() { // from class: com.baidu.tieba.frs.live.a.1
        @Override // com.baidu.tieba.frs.live.c.a
        public void a(FrsLiveTipResponseMessage frsLiveTipResponseMessage) {
            if (frsLiveTipResponseMessage != null) {
                a.this.jcp = frsLiveTipResponseMessage.remindType;
                a.this.jcq = frsLiveTipResponseMessage.remindText;
                a.this.jcr = frsLiveTipResponseMessage.infoCoreData;
                a.this.jcs = frsLiveTipResponseMessage.listCoreData;
                if (a.this.jcn != null) {
                    a.this.jcn.cAG();
                }
                if (a.this.jcp != 0) {
                    a.this.cDU();
                }
            }
        }
    };
    private Runnable jcv = new Runnable() { // from class: com.baidu.tieba.frs.live.a.2
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.jct != null) {
                a.this.jct.zX(a.this.mForumId);
            }
        }
    };
    private int jco = cDY();

    public a(FrsFragment frsFragment, int i) {
        this.iJK = frsFragment;
        this.mForumId = i;
    }

    public void cDT() {
        if (this.iJK != null && this.iJK.isAdded()) {
            if (System.currentTimeMillis() - getLastShowTime() >= 1800000) {
                if (this.iJK.cyC() && isFirst()) {
                    this.isFirst = false;
                    return;
                }
                if (this.jct == null) {
                    this.jct = new c(this.jcu);
                }
                e.mY().removeCallbacks(this.jcv);
                e.mY().postDelayed(this.jcv, 5000L);
            }
        }
    }

    public void cDU() {
        if (!StringUtils.isNull(this.jcq) && this.jcr != null) {
            if (this.jcp != 2 || cDY() < 3) {
                dQ(this.iJK.getPageContext().getPageActivity());
                if (this.iWP != null) {
                    this.iWP.setText(this.jcq);
                }
                onChangeSkinType();
                cli();
                saveLastShowTime();
            }
        }
    }

    public void cDV() {
        if (this.iJK != null) {
            this.iJK.cyj().tg(49);
        }
    }

    private void onChangeSkinType() {
        ap.setBackgroundResource(this.jcm, R.drawable.bg_frs_hot_live_tip_selector);
        ap.setViewTextColor(this.iWP, R.color.cp_cont_a);
        ap.setImageResource(this.iMS, R.drawable.icon_home_card_close_white);
        this.iWP.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ap.getDrawable(R.drawable.icon_arrow_more_white), (Drawable) null);
    }

    private void dQ(Context context) {
        if (context != null && this.jcm == null) {
            this.jcm = (FrameLayout) LayoutInflater.from(context).inflate(R.layout.frs_hot_live_tip, (ViewGroup) null);
            this.jcm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.live.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.cDW();
                }
            });
            this.iWP = (TextView) this.jcm.findViewById(R.id.frs_hot_live_tip_content);
            this.iMS = (ImageView) this.jcm.findViewById(R.id.frs_hot_live_tip_close);
            this.iMS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.live.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.rO();
                }
            });
            onChangeSkinType();
        }
    }

    private void cli() {
        q cyl;
        FrameLayout frameLayout;
        if (this.iJK != null && (cyl = this.iJK.cyl()) != null && cyl.getListView() != null && (frameLayout = (FrameLayout) cyl.czL()) != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds56));
            if (this.jcn == null) {
                this.jcn = new be();
            }
            if (this.jcp == 2) {
                this.jcn.a(this.jcm, frameLayout, layoutParams, 5000);
            } else if (this.jcp == 1) {
                this.jcn.a(this.jcm, frameLayout, layoutParams);
                TiebaStatic.log(new aq("c12539"));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cDW() {
        cDZ();
        if (this.jcr != null && this.iJK != null && this.iJK.isAdded()) {
            boolean equals = TextUtils.equals(getUserId(), String.valueOf(this.jcr.userID));
            String str = "";
            if (this.jcp == 1) {
                str = "frs_followed_live_tip";
                TiebaStatic.log(new aq("c12540"));
                if (this.jcn != null) {
                    this.jcn.hideTip();
                }
            } else if (this.jcp == 2) {
                str = "frs_hot_live_tip";
                TiebaStatic.log(new aq("c12331"));
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(this.iJK.getPageContext().getPageActivity(), this.jcr, this.jcs, str, getUserId(), equals, null, null)));
            if (this.iJK.cyP().getForum().isGameForumType()) {
                CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_GAME_FRS_JUMP_TO_LIVE_TAB);
                customMessage.setTag(this.iJK.getBaseFragmentActivity().getUniqueId());
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_FRS_JUMP_TO_LIVE_TAB);
                customResponsedMessage.setOrginalMessage(customMessage);
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                return;
            }
            e.mY().post(new Runnable() { // from class: com.baidu.tieba.frs.live.a.5
                @Override // java.lang.Runnable
                public void run() {
                    a.this.cDV();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rO() {
        if (this.jcp == 2) {
            cDX();
        }
        if (this.jcn != null) {
            this.jcn.hideTip();
        }
    }

    private void cDX() {
        this.jco++;
        com.baidu.tbadk.core.sharedPref.b.bqh().putInt(SharedPrefConfig.FRS_HOT_LIVE_TIP_CLOSE_NUM + getUserId(), this.jco);
    }

    private int cDY() {
        return com.baidu.tbadk.core.sharedPref.b.bqh().getInt(SharedPrefConfig.FRS_HOT_LIVE_TIP_CLOSE_NUM + getUserId(), 0);
    }

    private void cDZ() {
        this.jco = 0;
        com.baidu.tbadk.core.sharedPref.b.bqh().putInt(SharedPrefConfig.FRS_HOT_LIVE_TIP_CLOSE_NUM + getUserId(), this.jco);
    }

    private void saveLastShowTime() {
        com.baidu.tbadk.core.sharedPref.b.bqh().putLong(SharedPrefConfig.FRS_HOT_LIVE_TIP_LAST_SHOWTIME + getUserId(), System.currentTimeMillis());
    }

    private long getLastShowTime() {
        return com.baidu.tbadk.core.sharedPref.b.bqh().getLong(SharedPrefConfig.FRS_HOT_LIVE_TIP_LAST_SHOWTIME + getUserId(), 0L);
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
        if (this.jcn != null) {
            this.jcn.cAG();
        }
        e.mY().removeCallbacks(this.jcv);
        if (this.jct != null) {
            this.jct.onDestory();
        }
    }
}
