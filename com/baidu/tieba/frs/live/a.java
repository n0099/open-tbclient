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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.bb;
import com.baidu.tieba.frs.live.c;
import com.baidu.tieba.frs.q;
/* loaded from: classes2.dex */
public class a {
    private FrameLayout jDa;
    private bb jDb;
    private int jDd;
    private String jDe;
    private AlaLiveInfoCoreData jDf;
    private AlaLiveInfoListCoreData jDg;
    private c jDh;
    private FrsFragment jhE;
    private ImageView jkL;
    private TextView jxB;
    private int mForumId;
    private boolean isFirst = true;
    private c.a jDi = new c.a() { // from class: com.baidu.tieba.frs.live.a.1
        @Override // com.baidu.tieba.frs.live.c.a
        public void a(FrsLiveTipResponseMessage frsLiveTipResponseMessage) {
            if (frsLiveTipResponseMessage != null) {
                a.this.jDd = frsLiveTipResponseMessage.remindType;
                a.this.jDe = frsLiveTipResponseMessage.remindText;
                a.this.jDf = frsLiveTipResponseMessage.infoCoreData;
                a.this.jDg = frsLiveTipResponseMessage.listCoreData;
                if (a.this.jDb != null) {
                    a.this.jDb.cHv();
                }
                if (a.this.jDd != 0) {
                    a.this.cLM();
                }
            }
        }
    };
    private Runnable jDj = new Runnable() { // from class: com.baidu.tieba.frs.live.a.2
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.jDh != null) {
                a.this.jDh.Bv(a.this.mForumId);
            }
        }
    };
    private int jDc = cLQ();

    public a(FrsFragment frsFragment, int i) {
        this.jhE = frsFragment;
        this.mForumId = i;
    }

    public void cLL() {
        if (this.jhE != null && this.jhE.isAdded()) {
            if (System.currentTimeMillis() - getLastShowTime() >= 1800000) {
                if (this.jhE.cFq() && isFirst()) {
                    this.isFirst = false;
                    return;
                }
                if (this.jDh == null) {
                    this.jDh = new c(this.jDi);
                }
                e.mB().removeCallbacks(this.jDj);
                e.mB().postDelayed(this.jDj, 5000L);
            }
        }
    }

    public void cLM() {
        if (!StringUtils.isNull(this.jDe) && this.jDf != null) {
            if (this.jDd != 2 || cLQ() < 3) {
                eO(this.jhE.getPageContext().getPageActivity());
                if (this.jxB != null) {
                    this.jxB.setText(this.jDe);
                }
                onChangeSkinType();
                crK();
                saveLastShowTime();
            }
        }
    }

    public void cLN() {
        if (this.jhE != null) {
            this.jhE.cEX().uu(49);
        }
    }

    private void onChangeSkinType() {
        ao.setBackgroundResource(this.jDa, R.drawable.bg_frs_hot_live_tip_selector);
        ao.setViewTextColor(this.jxB, R.color.CAM_X0101);
        ao.setImageResource(this.jkL, R.drawable.icon_home_card_close_white);
        this.jxB.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ao.getDrawable(R.drawable.icon_arrow_more_white), (Drawable) null);
    }

    private void eO(Context context) {
        if (context != null && this.jDa == null) {
            this.jDa = (FrameLayout) LayoutInflater.from(context).inflate(R.layout.frs_hot_live_tip, (ViewGroup) null);
            this.jDa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.live.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.cLO();
                }
            });
            this.jxB = (TextView) this.jDa.findViewById(R.id.frs_hot_live_tip_content);
            this.jkL = (ImageView) this.jDa.findViewById(R.id.frs_hot_live_tip_close);
            this.jkL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.live.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.rr();
                }
            });
            onChangeSkinType();
        }
    }

    private void crK() {
        q cEZ;
        FrameLayout frameLayout;
        if (this.jhE != null && (cEZ = this.jhE.cEZ()) != null && cEZ.getListView() != null && (frameLayout = (FrameLayout) cEZ.cGA()) != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds56));
            if (this.jDb == null) {
                this.jDb = new bb();
            }
            if (this.jDd == 2) {
                this.jDb.a(this.jDa, frameLayout, layoutParams, 5000);
            } else if (this.jDd == 1) {
                this.jDb.a(this.jDa, frameLayout, layoutParams);
                TiebaStatic.log(new aq("c12539"));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cLO() {
        cLR();
        if (this.jDf != null && this.jhE != null && this.jhE.isAdded()) {
            boolean equals = TextUtils.equals(getUserId(), String.valueOf(this.jDf.userID));
            String str = "";
            if (this.jDd == 1) {
                str = "frs_followed_live_tip";
                TiebaStatic.log(new aq("c12540"));
                if (this.jDb != null) {
                    this.jDb.hideTip();
                }
            } else if (this.jDd == 2) {
                str = "frs_hot_live_tip";
                TiebaStatic.log(new aq("c12331"));
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(this.jhE.getPageContext().getPageActivity(), this.jDf, this.jDg, str, getUserId(), equals, null, null)));
            if (this.jhE.cFE().getForum().isGameForumType()) {
                CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_GAME_FRS_JUMP_TO_LIVE_TAB);
                customMessage.setTag(this.jhE.getBaseFragmentActivity().getUniqueId());
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_FRS_JUMP_TO_LIVE_TAB);
                customResponsedMessage.setOrginalMessage(customMessage);
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                return;
            }
            e.mB().post(new Runnable() { // from class: com.baidu.tieba.frs.live.a.5
                @Override // java.lang.Runnable
                public void run() {
                    a.this.cLN();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rr() {
        if (this.jDd == 2) {
            cLP();
        }
        if (this.jDb != null) {
            this.jDb.hideTip();
        }
    }

    private void cLP() {
        this.jDc++;
        com.baidu.tbadk.core.sharedPref.b.bvq().putInt(SharedPrefConfig.FRS_HOT_LIVE_TIP_CLOSE_NUM + getUserId(), this.jDc);
    }

    private int cLQ() {
        return com.baidu.tbadk.core.sharedPref.b.bvq().getInt(SharedPrefConfig.FRS_HOT_LIVE_TIP_CLOSE_NUM + getUserId(), 0);
    }

    private void cLR() {
        this.jDc = 0;
        com.baidu.tbadk.core.sharedPref.b.bvq().putInt(SharedPrefConfig.FRS_HOT_LIVE_TIP_CLOSE_NUM + getUserId(), this.jDc);
    }

    private void saveLastShowTime() {
        com.baidu.tbadk.core.sharedPref.b.bvq().putLong(SharedPrefConfig.FRS_HOT_LIVE_TIP_LAST_SHOWTIME + getUserId(), System.currentTimeMillis());
    }

    private long getLastShowTime() {
        return com.baidu.tbadk.core.sharedPref.b.bvq().getLong(SharedPrefConfig.FRS_HOT_LIVE_TIP_LAST_SHOWTIME + getUserId(), 0L);
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
        if (this.jDb != null) {
            this.jDb.cHv();
        }
        e.mB().removeCallbacks(this.jDj);
        if (this.jDh != null) {
            this.jDh.onDestory();
        }
    }
}
