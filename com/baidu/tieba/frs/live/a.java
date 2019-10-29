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
    private TextView fIe;
    private FrameLayout fNq;
    private ImageView fNr;
    private aq fNs;
    private int fNu;
    private String fNv;
    private AlaLiveInfoCoreData fNw;
    private AlaLiveInfoListCoreData fNx;
    private c fNy;
    private FrsFragment fxh;
    private int mForumId;
    private boolean isFirst = true;
    private c.a fNz = new c.a() { // from class: com.baidu.tieba.frs.live.a.1
        @Override // com.baidu.tieba.frs.live.c.a
        public void a(FrsLiveTipResponseMessage frsLiveTipResponseMessage) {
            if (frsLiveTipResponseMessage != null) {
                a.this.fNu = frsLiveTipResponseMessage.remindType;
                a.this.fNv = frsLiveTipResponseMessage.remindText;
                a.this.fNw = frsLiveTipResponseMessage.infoCoreData;
                a.this.fNx = frsLiveTipResponseMessage.listCoreData;
                if (a.this.fNs != null) {
                    a.this.fNs.blS();
                }
                if (a.this.fNu != 0) {
                    a.this.boT();
                }
            }
        }
    };
    private Runnable fNA = new Runnable() { // from class: com.baidu.tieba.frs.live.a.2
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.fNy != null) {
                a.this.fNy.rv(a.this.mForumId);
            }
        }
    };
    private int fNt = boX();

    public a(FrsFragment frsFragment, int i) {
        this.fxh = frsFragment;
        this.mForumId = i;
    }

    public void boS() {
        if (this.fxh != null && this.fxh.isAdded()) {
            if (System.currentTimeMillis() - getLastShowTime() >= 1800000) {
                if (this.fxh.bke() && isFirst()) {
                    this.isFirst = false;
                    return;
                }
                if (this.fNy == null) {
                    this.fNy = new c(this.fNz);
                }
                e.fZ().removeCallbacks(this.fNA);
                e.fZ().postDelayed(this.fNA, 5000L);
            }
        }
    }

    public void boT() {
        if (!StringUtils.isNull(this.fNv) && this.fNw != null) {
            if (this.fNu != 2 || boX() < 3) {
                initView(this.fxh.getPageContext().getPageActivity());
                if (this.fIe != null) {
                    this.fIe.setText(this.fNv);
                }
                onChangeSkinType();
                aYN();
                saveLastShowTime();
            }
        }
    }

    public void boU() {
        if (this.fxh != null) {
            this.fxh.bjN().rY(49);
        }
    }

    private void onChangeSkinType() {
        am.setBackgroundResource(this.fNq, R.drawable.bg_frs_hot_live_tip_selector);
        am.setViewTextColor(this.fIe, (int) R.color.cp_cont_a);
        am.setImageResource(this.fNr, R.drawable.icon_home_card_close_white);
        this.fIe.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(R.drawable.icon_arrow_more_white), (Drawable) null);
    }

    private void initView(Context context) {
        if (context != null && this.fNq == null) {
            this.fNq = (FrameLayout) LayoutInflater.from(context).inflate(R.layout.frs_hot_live_tip, (ViewGroup) null);
            this.fNq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.live.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.boV();
                }
            });
            this.fIe = (TextView) this.fNq.findViewById(R.id.frs_hot_live_tip_content);
            this.fNr = (ImageView) this.fNq.findViewById(R.id.frs_hot_live_tip_close);
            this.fNr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.live.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.kB();
                }
            });
            onChangeSkinType();
        }
    }

    private void aYN() {
        k bjP;
        FrameLayout frameLayout;
        if (this.fxh != null && (bjP = this.fxh.bjP()) != null && bjP.getListView() != null && (frameLayout = (FrameLayout) bjP.blf()) != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds56));
            if (this.fNs == null) {
                this.fNs = new aq();
            }
            if (this.fNu == 2) {
                this.fNs.a(this.fNq, frameLayout, layoutParams, 5000);
            } else if (this.fNu == 1) {
                this.fNs.a(this.fNq, frameLayout, layoutParams);
                TiebaStatic.log(new an("c12539"));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void boV() {
        boY();
        if (this.fNw != null && this.fxh != null && this.fxh.isAdded()) {
            boolean equals = TextUtils.equals(getUserId(), String.valueOf(this.fNw.userID));
            String str = "";
            if (this.fNu == 1) {
                str = "frs_followed_live_tip";
                TiebaStatic.log(new an("c12540"));
                if (this.fNs != null) {
                    this.fNs.hideTip();
                }
            } else if (this.fNu == 2) {
                str = "frs_hot_live_tip";
                TiebaStatic.log(new an("c12331"));
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(this.fxh.getPageContext().getPageActivity(), this.fNw, this.fNx, str, getUserId(), equals, null, null)));
            if (this.fxh.bkp().getForum().isGameForumType()) {
                CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_GAME_FRS_JUMP_TO_LIVE_TAB);
                customMessage.setTag(this.fxh.getBaseFragmentActivity().getUniqueId());
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_FRS_JUMP_TO_LIVE_TAB);
                customResponsedMessage.setOrginalMessage(customMessage);
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                return;
            }
            e.fZ().post(new Runnable() { // from class: com.baidu.tieba.frs.live.a.5
                @Override // java.lang.Runnable
                public void run() {
                    a.this.boU();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kB() {
        if (this.fNu == 2) {
            boW();
        }
        if (this.fNs != null) {
            this.fNs.hideTip();
        }
    }

    private void boW() {
        this.fNt++;
        com.baidu.tbadk.core.sharedPref.b.alR().putInt(SharedPrefConfig.FRS_HOT_LIVE_TIP_CLOSE_NUM + getUserId(), this.fNt);
    }

    private int boX() {
        return com.baidu.tbadk.core.sharedPref.b.alR().getInt(SharedPrefConfig.FRS_HOT_LIVE_TIP_CLOSE_NUM + getUserId(), 0);
    }

    private void boY() {
        this.fNt = 0;
        com.baidu.tbadk.core.sharedPref.b.alR().putInt(SharedPrefConfig.FRS_HOT_LIVE_TIP_CLOSE_NUM + getUserId(), this.fNt);
    }

    private void saveLastShowTime() {
        com.baidu.tbadk.core.sharedPref.b.alR().putLong(SharedPrefConfig.FRS_HOT_LIVE_TIP_LAST_SHOWTIME + getUserId(), System.currentTimeMillis());
    }

    private long getLastShowTime() {
        return com.baidu.tbadk.core.sharedPref.b.alR().getLong(SharedPrefConfig.FRS_HOT_LIVE_TIP_LAST_SHOWTIME + getUserId(), 0L);
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
        if (this.fNs != null) {
            this.fNs.blS();
        }
        e.fZ().removeCallbacks(this.fNA);
        if (this.fNy != null) {
            this.fNy.onDestory();
        }
    }
}
