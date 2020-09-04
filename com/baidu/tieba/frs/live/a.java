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
    private FrsFragment hVq;
    private ImageView hYy;
    private TextView iiB;
    private FrameLayout inK;
    private be inL;
    private int inN;
    private String inO;
    private AlaLiveInfoCoreData inP;
    private AlaLiveInfoListCoreData inQ;
    private c inR;
    private int mForumId;
    private boolean isFirst = true;
    private c.a inS = new c.a() { // from class: com.baidu.tieba.frs.live.a.1
        @Override // com.baidu.tieba.frs.live.c.a
        public void a(FrsLiveTipResponseMessage frsLiveTipResponseMessage) {
            if (frsLiveTipResponseMessage != null) {
                a.this.inN = frsLiveTipResponseMessage.remindType;
                a.this.inO = frsLiveTipResponseMessage.remindText;
                a.this.inP = frsLiveTipResponseMessage.infoCoreData;
                a.this.inQ = frsLiveTipResponseMessage.listCoreData;
                if (a.this.inL != null) {
                    a.this.inL.con();
                }
                if (a.this.inN != 0) {
                    a.this.crA();
                }
            }
        }
    };
    private Runnable inT = new Runnable() { // from class: com.baidu.tieba.frs.live.a.2
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.inR != null) {
                a.this.inR.ym(a.this.mForumId);
            }
        }
    };
    private int inM = crE();

    public a(FrsFragment frsFragment, int i) {
        this.hVq = frsFragment;
        this.mForumId = i;
    }

    public void crz() {
        if (this.hVq != null && this.hVq.isAdded()) {
            if (System.currentTimeMillis() - getLastShowTime() >= 1800000) {
                if (this.hVq.cmk() && isFirst()) {
                    this.isFirst = false;
                    return;
                }
                if (this.inR == null) {
                    this.inR = new c(this.inS);
                }
                e.mS().removeCallbacks(this.inT);
                e.mS().postDelayed(this.inT, 5000L);
            }
        }
    }

    public void crA() {
        if (!StringUtils.isNull(this.inO) && this.inP != null) {
            if (this.inN != 2 || crE() < 3) {
                dL(this.hVq.getPageContext().getPageActivity());
                if (this.iiB != null) {
                    this.iiB.setText(this.inO);
                }
                onChangeSkinType();
                bZZ();
                saveLastShowTime();
            }
        }
    }

    public void crB() {
        if (this.hVq != null) {
            this.hVq.clR().yU(49);
        }
    }

    private void onChangeSkinType() {
        ap.setBackgroundResource(this.inK, R.drawable.bg_frs_hot_live_tip_selector);
        ap.setViewTextColor(this.iiB, R.color.cp_cont_a);
        ap.setImageResource(this.hYy, R.drawable.icon_home_card_close_white);
        this.iiB.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ap.getDrawable(R.drawable.icon_arrow_more_white), (Drawable) null);
    }

    private void dL(Context context) {
        if (context != null && this.inK == null) {
            this.inK = (FrameLayout) LayoutInflater.from(context).inflate(R.layout.frs_hot_live_tip, (ViewGroup) null);
            this.inK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.live.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.crC();
                }
            });
            this.iiB = (TextView) this.inK.findViewById(R.id.frs_hot_live_tip_content);
            this.hYy = (ImageView) this.inK.findViewById(R.id.frs_hot_live_tip_close);
            this.hYy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.live.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.rJ();
                }
            });
            onChangeSkinType();
        }
    }

    private void bZZ() {
        q clT;
        FrameLayout frameLayout;
        if (this.hVq != null && (clT = this.hVq.clT()) != null && clT.getListView() != null && (frameLayout = (FrameLayout) clT.cnt()) != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds56));
            if (this.inL == null) {
                this.inL = new be();
            }
            if (this.inN == 2) {
                this.inL.a(this.inK, frameLayout, layoutParams, 5000);
            } else if (this.inN == 1) {
                this.inL.a(this.inK, frameLayout, layoutParams);
                TiebaStatic.log(new aq("c12539"));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void crC() {
        crF();
        if (this.inP != null && this.hVq != null && this.hVq.isAdded()) {
            boolean equals = TextUtils.equals(getUserId(), String.valueOf(this.inP.userID));
            String str = "";
            if (this.inN == 1) {
                str = "frs_followed_live_tip";
                TiebaStatic.log(new aq("c12540"));
                if (this.inL != null) {
                    this.inL.hideTip();
                }
            } else if (this.inN == 2) {
                str = "frs_hot_live_tip";
                TiebaStatic.log(new aq("c12331"));
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(this.hVq.getPageContext().getPageActivity(), this.inP, this.inQ, str, getUserId(), equals, null, null)));
            if (this.hVq.cmx().getForum().isGameForumType()) {
                CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_GAME_FRS_JUMP_TO_LIVE_TAB);
                customMessage.setTag(this.hVq.getBaseFragmentActivity().getUniqueId());
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_FRS_JUMP_TO_LIVE_TAB);
                customResponsedMessage.setOrginalMessage(customMessage);
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                return;
            }
            e.mS().post(new Runnable() { // from class: com.baidu.tieba.frs.live.a.5
                @Override // java.lang.Runnable
                public void run() {
                    a.this.crB();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rJ() {
        if (this.inN == 2) {
            crD();
        }
        if (this.inL != null) {
            this.inL.hideTip();
        }
    }

    private void crD() {
        this.inM++;
        com.baidu.tbadk.core.sharedPref.b.bik().putInt(SharedPrefConfig.FRS_HOT_LIVE_TIP_CLOSE_NUM + getUserId(), this.inM);
    }

    private int crE() {
        return com.baidu.tbadk.core.sharedPref.b.bik().getInt(SharedPrefConfig.FRS_HOT_LIVE_TIP_CLOSE_NUM + getUserId(), 0);
    }

    private void crF() {
        this.inM = 0;
        com.baidu.tbadk.core.sharedPref.b.bik().putInt(SharedPrefConfig.FRS_HOT_LIVE_TIP_CLOSE_NUM + getUserId(), this.inM);
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
        if (this.inL != null) {
            this.inL.con();
        }
        e.mS().removeCallbacks(this.inT);
        if (this.inR != null) {
            this.inR.onDestory();
        }
    }
}
