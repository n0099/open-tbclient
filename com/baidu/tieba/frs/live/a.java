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
    private FrsFragment hah;
    private TextView hly;
    private FrameLayout hqA;
    private ImageView hqB;
    private aw hqC;
    private int hqE;
    private String hqF;
    private AlaLiveInfoCoreData hqG;
    private AlaLiveInfoListCoreData hqH;
    private c hqI;
    private int mForumId;
    private boolean isFirst = true;
    private c.a hqJ = new c.a() { // from class: com.baidu.tieba.frs.live.a.1
        @Override // com.baidu.tieba.frs.live.c.a
        public void a(FrsLiveTipResponseMessage frsLiveTipResponseMessage) {
            if (frsLiveTipResponseMessage != null) {
                a.this.hqE = frsLiveTipResponseMessage.remindType;
                a.this.hqF = frsLiveTipResponseMessage.remindText;
                a.this.hqG = frsLiveTipResponseMessage.infoCoreData;
                a.this.hqH = frsLiveTipResponseMessage.listCoreData;
                if (a.this.hqC != null) {
                    a.this.hqC.bQG();
                }
                if (a.this.hqE != 0) {
                    a.this.bTD();
                }
            }
        }
    };
    private Runnable hqK = new Runnable() { // from class: com.baidu.tieba.frs.live.a.2
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.hqI != null) {
                a.this.hqI.uo(a.this.mForumId);
            }
        }
    };
    private int hqD = bTH();

    public a(FrsFragment frsFragment, int i) {
        this.hah = frsFragment;
        this.mForumId = i;
    }

    public void bTC() {
        if (this.hah != null && this.hah.isAdded()) {
            if (System.currentTimeMillis() - getLastShowTime() >= 1800000) {
                if (this.hah.bON() && isFirst()) {
                    this.isFirst = false;
                    return;
                }
                if (this.hqI == null) {
                    this.hqI = new c(this.hqJ);
                }
                e.lb().removeCallbacks(this.hqK);
                e.lb().postDelayed(this.hqK, 5000L);
            }
        }
    }

    public void bTD() {
        if (!StringUtils.isNull(this.hqF) && this.hqG != null) {
            if (this.hqE != 2 || bTH() < 3) {
                initView(this.hah.getPageContext().getPageActivity());
                if (this.hly != null) {
                    this.hly.setText(this.hqF);
                }
                onChangeSkinType();
                bDj();
                saveLastShowTime();
            }
        }
    }

    public void bTE() {
        if (this.hah != null) {
            this.hah.bOv().uV(49);
        }
    }

    private void onChangeSkinType() {
        am.setBackgroundResource(this.hqA, R.drawable.bg_frs_hot_live_tip_selector);
        am.setViewTextColor(this.hly, (int) R.color.cp_cont_a);
        am.setImageResource(this.hqB, R.drawable.icon_home_card_close_white);
        this.hly.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(R.drawable.icon_arrow_more_white), (Drawable) null);
    }

    private void initView(Context context) {
        if (context != null && this.hqA == null) {
            this.hqA = (FrameLayout) LayoutInflater.from(context).inflate(R.layout.frs_hot_live_tip, (ViewGroup) null);
            this.hqA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.live.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.bTF();
                }
            });
            this.hly = (TextView) this.hqA.findViewById(R.id.frs_hot_live_tip_content);
            this.hqB = (ImageView) this.hqA.findViewById(R.id.frs_hot_live_tip_close);
            this.hqB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.live.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.pM();
                }
            });
            onChangeSkinType();
        }
    }

    private void bDj() {
        n bOx;
        FrameLayout frameLayout;
        if (this.hah != null && (bOx = this.hah.bOx()) != null && bOx.getListView() != null && (frameLayout = (FrameLayout) bOx.bPS()) != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds56));
            if (this.hqC == null) {
                this.hqC = new aw();
            }
            if (this.hqE == 2) {
                this.hqC.a(this.hqA, frameLayout, layoutParams, 5000);
            } else if (this.hqE == 1) {
                this.hqC.a(this.hqA, frameLayout, layoutParams);
                TiebaStatic.log(new an("c12539"));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bTF() {
        bTI();
        if (this.hqG != null && this.hah != null && this.hah.isAdded()) {
            boolean equals = TextUtils.equals(getUserId(), String.valueOf(this.hqG.userID));
            String str = "";
            if (this.hqE == 1) {
                str = "frs_followed_live_tip";
                TiebaStatic.log(new an("c12540"));
                if (this.hqC != null) {
                    this.hqC.hideTip();
                }
            } else if (this.hqE == 2) {
                str = "frs_hot_live_tip";
                TiebaStatic.log(new an("c12331"));
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(this.hah.getPageContext().getPageActivity(), this.hqG, this.hqH, str, getUserId(), equals, null, null)));
            if (this.hah.bOY().getForum().isGameForumType()) {
                CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_GAME_FRS_JUMP_TO_LIVE_TAB);
                customMessage.setTag(this.hah.getBaseFragmentActivity().getUniqueId());
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_FRS_JUMP_TO_LIVE_TAB);
                customResponsedMessage.setOrginalMessage(customMessage);
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                return;
            }
            e.lb().post(new Runnable() { // from class: com.baidu.tieba.frs.live.a.5
                @Override // java.lang.Runnable
                public void run() {
                    a.this.bTE();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pM() {
        if (this.hqE == 2) {
            bTG();
        }
        if (this.hqC != null) {
            this.hqC.hideTip();
        }
    }

    private void bTG() {
        this.hqD++;
        com.baidu.tbadk.core.sharedPref.b.aNV().putInt(SharedPrefConfig.FRS_HOT_LIVE_TIP_CLOSE_NUM + getUserId(), this.hqD);
    }

    private int bTH() {
        return com.baidu.tbadk.core.sharedPref.b.aNV().getInt(SharedPrefConfig.FRS_HOT_LIVE_TIP_CLOSE_NUM + getUserId(), 0);
    }

    private void bTI() {
        this.hqD = 0;
        com.baidu.tbadk.core.sharedPref.b.aNV().putInt(SharedPrefConfig.FRS_HOT_LIVE_TIP_CLOSE_NUM + getUserId(), this.hqD);
    }

    private void saveLastShowTime() {
        com.baidu.tbadk.core.sharedPref.b.aNV().putLong(SharedPrefConfig.FRS_HOT_LIVE_TIP_LAST_SHOWTIME + getUserId(), System.currentTimeMillis());
    }

    private long getLastShowTime() {
        return com.baidu.tbadk.core.sharedPref.b.aNV().getLong(SharedPrefConfig.FRS_HOT_LIVE_TIP_LAST_SHOWTIME + getUserId(), 0L);
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
        if (this.hqC != null) {
            this.hqC.bQG();
        }
        e.lb().removeCallbacks(this.hqK);
        if (this.hqI != null) {
            this.hqI.onDestory();
        }
    }
}
