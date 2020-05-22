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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.aw;
import com.baidu.tieba.frs.live.c;
import com.baidu.tieba.frs.n;
/* loaded from: classes9.dex */
public class a {
    private TextView hAs;
    private AlaLiveInfoCoreData hFA;
    private AlaLiveInfoListCoreData hFB;
    private c hFC;
    private FrameLayout hFu;
    private ImageView hFv;
    private aw hFw;
    private int hFy;
    private String hFz;
    private FrsFragment hpb;
    private int mForumId;
    private boolean isFirst = true;
    private c.a hFD = new c.a() { // from class: com.baidu.tieba.frs.live.a.1
        @Override // com.baidu.tieba.frs.live.c.a
        public void a(FrsLiveTipResponseMessage frsLiveTipResponseMessage) {
            if (frsLiveTipResponseMessage != null) {
                a.this.hFy = frsLiveTipResponseMessage.remindType;
                a.this.hFz = frsLiveTipResponseMessage.remindText;
                a.this.hFA = frsLiveTipResponseMessage.infoCoreData;
                a.this.hFB = frsLiveTipResponseMessage.listCoreData;
                if (a.this.hFw != null) {
                    a.this.hFw.bXb();
                }
                if (a.this.hFy != 0) {
                    a.this.bZY();
                }
            }
        }
    };
    private Runnable hFE = new Runnable() { // from class: com.baidu.tieba.frs.live.a.2
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.hFC != null) {
                a.this.hFC.uU(a.this.mForumId);
            }
        }
    };
    private int hFx = cac();

    public a(FrsFragment frsFragment, int i) {
        this.hpb = frsFragment;
        this.mForumId = i;
    }

    public void bZX() {
        if (this.hpb != null && this.hpb.isAdded()) {
            if (System.currentTimeMillis() - getLastShowTime() >= 1800000) {
                if (this.hpb.bVh() && isFirst()) {
                    this.isFirst = false;
                    return;
                }
                if (this.hFC == null) {
                    this.hFC = new c(this.hFD);
                }
                e.ld().removeCallbacks(this.hFE);
                e.ld().postDelayed(this.hFE, 5000L);
            }
        }
    }

    public void bZY() {
        if (!StringUtils.isNull(this.hFz) && this.hFA != null) {
            if (this.hFy != 2 || cac() < 3) {
                initView(this.hpb.getPageContext().getPageActivity());
                if (this.hAs != null) {
                    this.hAs.setText(this.hFz);
                }
                onChangeSkinType();
                bJz();
                saveLastShowTime();
            }
        }
    }

    public void bZZ() {
        if (this.hpb != null) {
            this.hpb.bUP().vB(49);
        }
    }

    private void onChangeSkinType() {
        am.setBackgroundResource(this.hFu, R.drawable.bg_frs_hot_live_tip_selector);
        am.setViewTextColor(this.hAs, (int) R.color.cp_cont_a);
        am.setImageResource(this.hFv, R.drawable.icon_home_card_close_white);
        this.hAs.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(R.drawable.icon_arrow_more_white), (Drawable) null);
    }

    private void initView(Context context) {
        if (context != null && this.hFu == null) {
            this.hFu = (FrameLayout) LayoutInflater.from(context).inflate(R.layout.frs_hot_live_tip, (ViewGroup) null);
            this.hFu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.live.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.caa();
                }
            });
            this.hAs = (TextView) this.hFu.findViewById(R.id.frs_hot_live_tip_content);
            this.hFv = (ImageView) this.hFu.findViewById(R.id.frs_hot_live_tip_close);
            this.hFv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.live.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.pS();
                }
            });
            onChangeSkinType();
        }
    }

    private void bJz() {
        n bUR;
        FrameLayout frameLayout;
        if (this.hpb != null && (bUR = this.hpb.bUR()) != null && bUR.getListView() != null && (frameLayout = (FrameLayout) bUR.bWn()) != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds56));
            if (this.hFw == null) {
                this.hFw = new aw();
            }
            if (this.hFy == 2) {
                this.hFw.a(this.hFu, frameLayout, layoutParams, 5000);
            } else if (this.hFy == 1) {
                this.hFw.a(this.hFu, frameLayout, layoutParams);
                TiebaStatic.log(new an("c12539"));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void caa() {
        cad();
        if (this.hFA != null && this.hpb != null && this.hpb.isAdded()) {
            boolean equals = TextUtils.equals(getUserId(), String.valueOf(this.hFA.userID));
            String str = "";
            if (this.hFy == 1) {
                str = "frs_followed_live_tip";
                TiebaStatic.log(new an("c12540"));
                if (this.hFw != null) {
                    this.hFw.hideTip();
                }
            } else if (this.hFy == 2) {
                str = "frs_hot_live_tip";
                TiebaStatic.log(new an("c12331"));
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(this.hpb.getPageContext().getPageActivity(), this.hFA, this.hFB, str, getUserId(), equals, null, null)));
            if (this.hpb.bVs().getForum().isGameForumType()) {
                CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_GAME_FRS_JUMP_TO_LIVE_TAB);
                customMessage.setTag(this.hpb.getBaseFragmentActivity().getUniqueId());
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_FRS_JUMP_TO_LIVE_TAB);
                customResponsedMessage.setOrginalMessage(customMessage);
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                return;
            }
            e.ld().post(new Runnable() { // from class: com.baidu.tieba.frs.live.a.5
                @Override // java.lang.Runnable
                public void run() {
                    a.this.bZZ();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pS() {
        if (this.hFy == 2) {
            cab();
        }
        if (this.hFw != null) {
            this.hFw.hideTip();
        }
    }

    private void cab() {
        this.hFx++;
        com.baidu.tbadk.core.sharedPref.b.aTX().putInt(SharedPrefConfig.FRS_HOT_LIVE_TIP_CLOSE_NUM + getUserId(), this.hFx);
    }

    private int cac() {
        return com.baidu.tbadk.core.sharedPref.b.aTX().getInt(SharedPrefConfig.FRS_HOT_LIVE_TIP_CLOSE_NUM + getUserId(), 0);
    }

    private void cad() {
        this.hFx = 0;
        com.baidu.tbadk.core.sharedPref.b.aTX().putInt(SharedPrefConfig.FRS_HOT_LIVE_TIP_CLOSE_NUM + getUserId(), this.hFx);
    }

    private void saveLastShowTime() {
        com.baidu.tbadk.core.sharedPref.b.aTX().putLong(SharedPrefConfig.FRS_HOT_LIVE_TIP_LAST_SHOWTIME + getUserId(), System.currentTimeMillis());
    }

    private long getLastShowTime() {
        return com.baidu.tbadk.core.sharedPref.b.aTX().getLong(SharedPrefConfig.FRS_HOT_LIVE_TIP_LAST_SHOWTIME + getUserId(), 0L);
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
        if (this.hFw != null) {
            this.hFw.bXb();
        }
        e.ld().removeCallbacks(this.hFE);
        if (this.hFC != null) {
            this.hFC.onDestory();
        }
    }
}
