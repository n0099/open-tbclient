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
    private TextView gAS;
    private FrameLayout gFX;
    private ImageView gFY;
    private ar gFZ;
    private int gGb;
    private String gGc;
    private AlaLiveInfoCoreData gGd;
    private AlaLiveInfoListCoreData gGe;
    private c gGf;
    private FrsFragment gpZ;
    private int mForumId;
    private boolean isFirst = true;
    private c.a gGg = new c.a() { // from class: com.baidu.tieba.frs.live.a.1
        @Override // com.baidu.tieba.frs.live.c.a
        public void a(FrsLiveTipResponseMessage frsLiveTipResponseMessage) {
            if (frsLiveTipResponseMessage != null) {
                a.this.gGb = frsLiveTipResponseMessage.remindType;
                a.this.gGc = frsLiveTipResponseMessage.remindText;
                a.this.gGd = frsLiveTipResponseMessage.infoCoreData;
                a.this.gGe = frsLiveTipResponseMessage.listCoreData;
                if (a.this.gFZ != null) {
                    a.this.gFZ.bFS();
                }
                if (a.this.gGb != 0) {
                    a.this.bIT();
                }
            }
        }
    };
    private Runnable gGh = new Runnable() { // from class: com.baidu.tieba.frs.live.a.2
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.gGf != null) {
                a.this.gGf.tL(a.this.mForumId);
            }
        }
    };
    private int gGa = bIX();

    public a(FrsFragment frsFragment, int i) {
        this.gpZ = frsFragment;
        this.mForumId = i;
    }

    public void bIS() {
        if (this.gpZ != null && this.gpZ.isAdded()) {
            if (System.currentTimeMillis() - getLastShowTime() >= 1800000) {
                if (this.gpZ.bEe() && isFirst()) {
                    this.isFirst = false;
                    return;
                }
                if (this.gGf == null) {
                    this.gGf = new c(this.gGg);
                }
                e.gx().removeCallbacks(this.gGh);
                e.gx().postDelayed(this.gGh, 5000L);
            }
        }
    }

    public void bIT() {
        if (!StringUtils.isNull(this.gGc) && this.gGd != null) {
            if (this.gGb != 2 || bIX() < 3) {
                initView(this.gpZ.getPageContext().getPageActivity());
                if (this.gAS != null) {
                    this.gAS.setText(this.gGc);
                }
                onChangeSkinType();
                btu();
                saveLastShowTime();
            }
        }
    }

    public void bIU() {
        if (this.gpZ != null) {
            this.gpZ.bDN().uq(49);
        }
    }

    private void onChangeSkinType() {
        am.setBackgroundResource(this.gFX, R.drawable.bg_frs_hot_live_tip_selector);
        am.setViewTextColor(this.gAS, (int) R.color.cp_cont_a);
        am.setImageResource(this.gFY, R.drawable.icon_home_card_close_white);
        this.gAS.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(R.drawable.icon_arrow_more_white), (Drawable) null);
    }

    private void initView(Context context) {
        if (context != null && this.gFX == null) {
            this.gFX = (FrameLayout) LayoutInflater.from(context).inflate(R.layout.frs_hot_live_tip, (ViewGroup) null);
            this.gFX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.live.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.bIV();
                }
            });
            this.gAS = (TextView) this.gFX.findViewById(R.id.frs_hot_live_tip_content);
            this.gFY = (ImageView) this.gFX.findViewById(R.id.frs_hot_live_tip_close);
            this.gFY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.live.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.li();
                }
            });
            onChangeSkinType();
        }
    }

    private void btu() {
        l bDP;
        FrameLayout frameLayout;
        if (this.gpZ != null && (bDP = this.gpZ.bDP()) != null && bDP.getListView() != null && (frameLayout = (FrameLayout) bDP.bFg()) != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds56));
            if (this.gFZ == null) {
                this.gFZ = new ar();
            }
            if (this.gGb == 2) {
                this.gFZ.a(this.gFX, frameLayout, layoutParams, 5000);
            } else if (this.gGb == 1) {
                this.gFZ.a(this.gFX, frameLayout, layoutParams);
                TiebaStatic.log(new an("c12539"));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIV() {
        bIY();
        if (this.gGd != null && this.gpZ != null && this.gpZ.isAdded()) {
            boolean equals = TextUtils.equals(getUserId(), String.valueOf(this.gGd.userID));
            String str = "";
            if (this.gGb == 1) {
                str = "frs_followed_live_tip";
                TiebaStatic.log(new an("c12540"));
                if (this.gFZ != null) {
                    this.gFZ.hideTip();
                }
            } else if (this.gGb == 2) {
                str = "frs_hot_live_tip";
                TiebaStatic.log(new an("c12331"));
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(this.gpZ.getPageContext().getPageActivity(), this.gGd, this.gGe, str, getUserId(), equals, null, null)));
            if (this.gpZ.bEp().getForum().isGameForumType()) {
                CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_GAME_FRS_JUMP_TO_LIVE_TAB);
                customMessage.setTag(this.gpZ.getBaseFragmentActivity().getUniqueId());
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_FRS_JUMP_TO_LIVE_TAB);
                customResponsedMessage.setOrginalMessage(customMessage);
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                return;
            }
            e.gx().post(new Runnable() { // from class: com.baidu.tieba.frs.live.a.5
                @Override // java.lang.Runnable
                public void run() {
                    a.this.bIU();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void li() {
        if (this.gGb == 2) {
            bIW();
        }
        if (this.gFZ != null) {
            this.gFZ.hideTip();
        }
    }

    private void bIW() {
        this.gGa++;
        com.baidu.tbadk.core.sharedPref.b.aFD().putInt(SharedPrefConfig.FRS_HOT_LIVE_TIP_CLOSE_NUM + getUserId(), this.gGa);
    }

    private int bIX() {
        return com.baidu.tbadk.core.sharedPref.b.aFD().getInt(SharedPrefConfig.FRS_HOT_LIVE_TIP_CLOSE_NUM + getUserId(), 0);
    }

    private void bIY() {
        this.gGa = 0;
        com.baidu.tbadk.core.sharedPref.b.aFD().putInt(SharedPrefConfig.FRS_HOT_LIVE_TIP_CLOSE_NUM + getUserId(), this.gGa);
    }

    private void saveLastShowTime() {
        com.baidu.tbadk.core.sharedPref.b.aFD().putLong(SharedPrefConfig.FRS_HOT_LIVE_TIP_LAST_SHOWTIME + getUserId(), System.currentTimeMillis());
    }

    private long getLastShowTime() {
        return com.baidu.tbadk.core.sharedPref.b.aFD().getLong(SharedPrefConfig.FRS_HOT_LIVE_TIP_LAST_SHOWTIME + getUserId(), 0L);
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
        if (this.gFZ != null) {
            this.gFZ.bFS();
        }
        e.gx().removeCallbacks(this.gGh);
        if (this.gGf != null) {
            this.gGf.onDestory();
        }
    }
}
