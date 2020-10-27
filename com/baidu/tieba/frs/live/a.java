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
    private FrsFragment iDN;
    private ImageView iGV;
    private TextView iQS;
    private FrameLayout iWp;
    private be iWq;
    private int iWs;
    private String iWt;
    private AlaLiveInfoCoreData iWu;
    private AlaLiveInfoListCoreData iWv;
    private c iWw;
    private int mForumId;
    private boolean isFirst = true;
    private c.a iWx = new c.a() { // from class: com.baidu.tieba.frs.live.a.1
        @Override // com.baidu.tieba.frs.live.c.a
        public void a(FrsLiveTipResponseMessage frsLiveTipResponseMessage) {
            if (frsLiveTipResponseMessage != null) {
                a.this.iWs = frsLiveTipResponseMessage.remindType;
                a.this.iWt = frsLiveTipResponseMessage.remindText;
                a.this.iWu = frsLiveTipResponseMessage.infoCoreData;
                a.this.iWv = frsLiveTipResponseMessage.listCoreData;
                if (a.this.iWq != null) {
                    a.this.iWq.cyf();
                }
                if (a.this.iWs != 0) {
                    a.this.cBt();
                }
            }
        }
    };
    private Runnable iWy = new Runnable() { // from class: com.baidu.tieba.frs.live.a.2
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.iWw != null) {
                a.this.iWw.zK(a.this.mForumId);
            }
        }
    };
    private int iWr = cBx();

    public a(FrsFragment frsFragment, int i) {
        this.iDN = frsFragment;
        this.mForumId = i;
    }

    public void cBs() {
        if (this.iDN != null && this.iDN.isAdded()) {
            if (System.currentTimeMillis() - getLastShowTime() >= 1800000) {
                if (this.iDN.cwb() && isFirst()) {
                    this.isFirst = false;
                    return;
                }
                if (this.iWw == null) {
                    this.iWw = new c(this.iWx);
                }
                e.mY().removeCallbacks(this.iWy);
                e.mY().postDelayed(this.iWy, 5000L);
            }
        }
    }

    public void cBt() {
        if (!StringUtils.isNull(this.iWt) && this.iWu != null) {
            if (this.iWs != 2 || cBx() < 3) {
                dQ(this.iDN.getPageContext().getPageActivity());
                if (this.iQS != null) {
                    this.iQS.setText(this.iWt);
                }
                onChangeSkinType();
                ciG();
                saveLastShowTime();
            }
        }
    }

    public void cBu() {
        if (this.iDN != null) {
            this.iDN.cvI().sW(49);
        }
    }

    private void onChangeSkinType() {
        ap.setBackgroundResource(this.iWp, R.drawable.bg_frs_hot_live_tip_selector);
        ap.setViewTextColor(this.iQS, R.color.cp_cont_a);
        ap.setImageResource(this.iGV, R.drawable.icon_home_card_close_white);
        this.iQS.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ap.getDrawable(R.drawable.icon_arrow_more_white), (Drawable) null);
    }

    private void dQ(Context context) {
        if (context != null && this.iWp == null) {
            this.iWp = (FrameLayout) LayoutInflater.from(context).inflate(R.layout.frs_hot_live_tip, (ViewGroup) null);
            this.iWp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.live.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.cBv();
                }
            });
            this.iQS = (TextView) this.iWp.findViewById(R.id.frs_hot_live_tip_content);
            this.iGV = (ImageView) this.iWp.findViewById(R.id.frs_hot_live_tip_close);
            this.iGV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.live.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.rO();
                }
            });
            onChangeSkinType();
        }
    }

    private void ciG() {
        q cvK;
        FrameLayout frameLayout;
        if (this.iDN != null && (cvK = this.iDN.cvK()) != null && cvK.getListView() != null && (frameLayout = (FrameLayout) cvK.cxk()) != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds56));
            if (this.iWq == null) {
                this.iWq = new be();
            }
            if (this.iWs == 2) {
                this.iWq.a(this.iWp, frameLayout, layoutParams, 5000);
            } else if (this.iWs == 1) {
                this.iWq.a(this.iWp, frameLayout, layoutParams);
                TiebaStatic.log(new aq("c12539"));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cBv() {
        cBy();
        if (this.iWu != null && this.iDN != null && this.iDN.isAdded()) {
            boolean equals = TextUtils.equals(getUserId(), String.valueOf(this.iWu.userID));
            String str = "";
            if (this.iWs == 1) {
                str = "frs_followed_live_tip";
                TiebaStatic.log(new aq("c12540"));
                if (this.iWq != null) {
                    this.iWq.hideTip();
                }
            } else if (this.iWs == 2) {
                str = "frs_hot_live_tip";
                TiebaStatic.log(new aq("c12331"));
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(this.iDN.getPageContext().getPageActivity(), this.iWu, this.iWv, str, getUserId(), equals, null, null)));
            if (this.iDN.cwo().getForum().isGameForumType()) {
                CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_GAME_FRS_JUMP_TO_LIVE_TAB);
                customMessage.setTag(this.iDN.getBaseFragmentActivity().getUniqueId());
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_FRS_JUMP_TO_LIVE_TAB);
                customResponsedMessage.setOrginalMessage(customMessage);
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                return;
            }
            e.mY().post(new Runnable() { // from class: com.baidu.tieba.frs.live.a.5
                @Override // java.lang.Runnable
                public void run() {
                    a.this.cBu();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rO() {
        if (this.iWs == 2) {
            cBw();
        }
        if (this.iWq != null) {
            this.iWq.hideTip();
        }
    }

    private void cBw() {
        this.iWr++;
        com.baidu.tbadk.core.sharedPref.b.bnH().putInt(SharedPrefConfig.FRS_HOT_LIVE_TIP_CLOSE_NUM + getUserId(), this.iWr);
    }

    private int cBx() {
        return com.baidu.tbadk.core.sharedPref.b.bnH().getInt(SharedPrefConfig.FRS_HOT_LIVE_TIP_CLOSE_NUM + getUserId(), 0);
    }

    private void cBy() {
        this.iWr = 0;
        com.baidu.tbadk.core.sharedPref.b.bnH().putInt(SharedPrefConfig.FRS_HOT_LIVE_TIP_CLOSE_NUM + getUserId(), this.iWr);
    }

    private void saveLastShowTime() {
        com.baidu.tbadk.core.sharedPref.b.bnH().putLong(SharedPrefConfig.FRS_HOT_LIVE_TIP_LAST_SHOWTIME + getUserId(), System.currentTimeMillis());
    }

    private long getLastShowTime() {
        return com.baidu.tbadk.core.sharedPref.b.bnH().getLong(SharedPrefConfig.FRS_HOT_LIVE_TIP_LAST_SHOWTIME + getUserId(), 0L);
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
        if (this.iWq != null) {
            this.iWq.cyf();
        }
        e.mY().removeCallbacks(this.iWy);
        if (this.iWw != null) {
            this.iWw.onDestory();
        }
    }
}
