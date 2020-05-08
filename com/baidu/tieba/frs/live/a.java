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
    private FrsFragment han;
    private TextView hlE;
    private FrameLayout hqG;
    private ImageView hqH;
    private aw hqI;
    private int hqK;
    private String hqL;
    private AlaLiveInfoCoreData hqM;
    private AlaLiveInfoListCoreData hqN;
    private c hqO;
    private int mForumId;
    private boolean isFirst = true;
    private c.a hqP = new c.a() { // from class: com.baidu.tieba.frs.live.a.1
        @Override // com.baidu.tieba.frs.live.c.a
        public void a(FrsLiveTipResponseMessage frsLiveTipResponseMessage) {
            if (frsLiveTipResponseMessage != null) {
                a.this.hqK = frsLiveTipResponseMessage.remindType;
                a.this.hqL = frsLiveTipResponseMessage.remindText;
                a.this.hqM = frsLiveTipResponseMessage.infoCoreData;
                a.this.hqN = frsLiveTipResponseMessage.listCoreData;
                if (a.this.hqI != null) {
                    a.this.hqI.bQE();
                }
                if (a.this.hqK != 0) {
                    a.this.bTB();
                }
            }
        }
    };
    private Runnable hqQ = new Runnable() { // from class: com.baidu.tieba.frs.live.a.2
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.hqO != null) {
                a.this.hqO.uo(a.this.mForumId);
            }
        }
    };
    private int hqJ = bTF();

    public a(FrsFragment frsFragment, int i) {
        this.han = frsFragment;
        this.mForumId = i;
    }

    public void bTA() {
        if (this.han != null && this.han.isAdded()) {
            if (System.currentTimeMillis() - getLastShowTime() >= 1800000) {
                if (this.han.bOL() && isFirst()) {
                    this.isFirst = false;
                    return;
                }
                if (this.hqO == null) {
                    this.hqO = new c(this.hqP);
                }
                e.lb().removeCallbacks(this.hqQ);
                e.lb().postDelayed(this.hqQ, 5000L);
            }
        }
    }

    public void bTB() {
        if (!StringUtils.isNull(this.hqL) && this.hqM != null) {
            if (this.hqK != 2 || bTF() < 3) {
                initView(this.han.getPageContext().getPageActivity());
                if (this.hlE != null) {
                    this.hlE.setText(this.hqL);
                }
                onChangeSkinType();
                bDh();
                saveLastShowTime();
            }
        }
    }

    public void bTC() {
        if (this.han != null) {
            this.han.bOt().uV(49);
        }
    }

    private void onChangeSkinType() {
        am.setBackgroundResource(this.hqG, R.drawable.bg_frs_hot_live_tip_selector);
        am.setViewTextColor(this.hlE, (int) R.color.cp_cont_a);
        am.setImageResource(this.hqH, R.drawable.icon_home_card_close_white);
        this.hlE.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(R.drawable.icon_arrow_more_white), (Drawable) null);
    }

    private void initView(Context context) {
        if (context != null && this.hqG == null) {
            this.hqG = (FrameLayout) LayoutInflater.from(context).inflate(R.layout.frs_hot_live_tip, (ViewGroup) null);
            this.hqG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.live.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.bTD();
                }
            });
            this.hlE = (TextView) this.hqG.findViewById(R.id.frs_hot_live_tip_content);
            this.hqH = (ImageView) this.hqG.findViewById(R.id.frs_hot_live_tip_close);
            this.hqH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.live.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.pM();
                }
            });
            onChangeSkinType();
        }
    }

    private void bDh() {
        n bOv;
        FrameLayout frameLayout;
        if (this.han != null && (bOv = this.han.bOv()) != null && bOv.getListView() != null && (frameLayout = (FrameLayout) bOv.bPQ()) != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds56));
            if (this.hqI == null) {
                this.hqI = new aw();
            }
            if (this.hqK == 2) {
                this.hqI.a(this.hqG, frameLayout, layoutParams, 5000);
            } else if (this.hqK == 1) {
                this.hqI.a(this.hqG, frameLayout, layoutParams);
                TiebaStatic.log(new an("c12539"));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bTD() {
        bTG();
        if (this.hqM != null && this.han != null && this.han.isAdded()) {
            boolean equals = TextUtils.equals(getUserId(), String.valueOf(this.hqM.userID));
            String str = "";
            if (this.hqK == 1) {
                str = "frs_followed_live_tip";
                TiebaStatic.log(new an("c12540"));
                if (this.hqI != null) {
                    this.hqI.hideTip();
                }
            } else if (this.hqK == 2) {
                str = "frs_hot_live_tip";
                TiebaStatic.log(new an("c12331"));
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(this.han.getPageContext().getPageActivity(), this.hqM, this.hqN, str, getUserId(), equals, null, null)));
            if (this.han.bOW().getForum().isGameForumType()) {
                CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_GAME_FRS_JUMP_TO_LIVE_TAB);
                customMessage.setTag(this.han.getBaseFragmentActivity().getUniqueId());
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_FRS_JUMP_TO_LIVE_TAB);
                customResponsedMessage.setOrginalMessage(customMessage);
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                return;
            }
            e.lb().post(new Runnable() { // from class: com.baidu.tieba.frs.live.a.5
                @Override // java.lang.Runnable
                public void run() {
                    a.this.bTC();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pM() {
        if (this.hqK == 2) {
            bTE();
        }
        if (this.hqI != null) {
            this.hqI.hideTip();
        }
    }

    private void bTE() {
        this.hqJ++;
        com.baidu.tbadk.core.sharedPref.b.aNT().putInt(SharedPrefConfig.FRS_HOT_LIVE_TIP_CLOSE_NUM + getUserId(), this.hqJ);
    }

    private int bTF() {
        return com.baidu.tbadk.core.sharedPref.b.aNT().getInt(SharedPrefConfig.FRS_HOT_LIVE_TIP_CLOSE_NUM + getUserId(), 0);
    }

    private void bTG() {
        this.hqJ = 0;
        com.baidu.tbadk.core.sharedPref.b.aNT().putInt(SharedPrefConfig.FRS_HOT_LIVE_TIP_CLOSE_NUM + getUserId(), this.hqJ);
    }

    private void saveLastShowTime() {
        com.baidu.tbadk.core.sharedPref.b.aNT().putLong(SharedPrefConfig.FRS_HOT_LIVE_TIP_LAST_SHOWTIME + getUserId(), System.currentTimeMillis());
    }

    private long getLastShowTime() {
        return com.baidu.tbadk.core.sharedPref.b.aNT().getLong(SharedPrefConfig.FRS_HOT_LIVE_TIP_LAST_SHOWTIME + getUserId(), 0L);
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
        if (this.hqI != null) {
            this.hqI.bQE();
        }
        e.lb().removeCallbacks(this.hqQ);
        if (this.hqO != null) {
            this.hqO.onDestory();
        }
    }
}
