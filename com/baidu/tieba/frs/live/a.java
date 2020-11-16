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
/* loaded from: classes21.dex */
public class a {
    private FrsFragment iKx;
    private ImageView iNF;
    private TextView iXB;
    private FrameLayout jcZ;
    private be jda;
    private int jdc;
    private String jdd;
    private AlaLiveInfoCoreData jde;
    private AlaLiveInfoListCoreData jdf;
    private c jdg;
    private int mForumId;
    private boolean isFirst = true;
    private c.a jdh = new c.a() { // from class: com.baidu.tieba.frs.live.a.1
        @Override // com.baidu.tieba.frs.live.c.a
        public void a(FrsLiveTipResponseMessage frsLiveTipResponseMessage) {
            if (frsLiveTipResponseMessage != null) {
                a.this.jdc = frsLiveTipResponseMessage.remindType;
                a.this.jdd = frsLiveTipResponseMessage.remindText;
                a.this.jde = frsLiveTipResponseMessage.infoCoreData;
                a.this.jdf = frsLiveTipResponseMessage.listCoreData;
                if (a.this.jda != null) {
                    a.this.jda.cAj();
                }
                if (a.this.jdc != 0) {
                    a.this.cDy();
                }
            }
        }
    };
    private Runnable jdi = new Runnable() { // from class: com.baidu.tieba.frs.live.a.2
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.jdg != null) {
                a.this.jdg.Av(a.this.mForumId);
            }
        }
    };
    private int jdb = cDC();

    public a(FrsFragment frsFragment, int i) {
        this.iKx = frsFragment;
        this.mForumId = i;
    }

    public void cDx() {
        if (this.iKx != null && this.iKx.isAdded()) {
            if (System.currentTimeMillis() - getLastShowTime() >= 1800000) {
                if (this.iKx.cyf() && isFirst()) {
                    this.isFirst = false;
                    return;
                }
                if (this.jdg == null) {
                    this.jdg = new c(this.jdh);
                }
                e.mY().removeCallbacks(this.jdi);
                e.mY().postDelayed(this.jdi, 5000L);
            }
        }
    }

    public void cDy() {
        if (!StringUtils.isNull(this.jdd) && this.jde != null) {
            if (this.jdc != 2 || cDC() < 3) {
                dQ(this.iKx.getPageContext().getPageActivity());
                if (this.iXB != null) {
                    this.iXB.setText(this.jdd);
                }
                onChangeSkinType();
                ckB();
                saveLastShowTime();
            }
        }
    }

    public void cDz() {
        if (this.iKx != null) {
            this.iKx.cxM().tE(49);
        }
    }

    private void onChangeSkinType() {
        ap.setBackgroundResource(this.jcZ, R.drawable.bg_frs_hot_live_tip_selector);
        ap.setViewTextColor(this.iXB, R.color.CAM_X0101);
        ap.setImageResource(this.iNF, R.drawable.icon_home_card_close_white);
        this.iXB.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ap.getDrawable(R.drawable.icon_arrow_more_white), (Drawable) null);
    }

    private void dQ(Context context) {
        if (context != null && this.jcZ == null) {
            this.jcZ = (FrameLayout) LayoutInflater.from(context).inflate(R.layout.frs_hot_live_tip, (ViewGroup) null);
            this.jcZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.live.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.cDA();
                }
            });
            this.iXB = (TextView) this.jcZ.findViewById(R.id.frs_hot_live_tip_content);
            this.iNF = (ImageView) this.jcZ.findViewById(R.id.frs_hot_live_tip_close);
            this.iNF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.live.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.rO();
                }
            });
            onChangeSkinType();
        }
    }

    private void ckB() {
        q cxO;
        FrameLayout frameLayout;
        if (this.iKx != null && (cxO = this.iKx.cxO()) != null && cxO.getListView() != null && (frameLayout = (FrameLayout) cxO.czo()) != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds56));
            if (this.jda == null) {
                this.jda = new be();
            }
            if (this.jdc == 2) {
                this.jda.a(this.jcZ, frameLayout, layoutParams, 5000);
            } else if (this.jdc == 1) {
                this.jda.a(this.jcZ, frameLayout, layoutParams);
                TiebaStatic.log(new ar("c12539"));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cDA() {
        cDD();
        if (this.jde != null && this.iKx != null && this.iKx.isAdded()) {
            boolean equals = TextUtils.equals(getUserId(), String.valueOf(this.jde.userID));
            String str = "";
            if (this.jdc == 1) {
                str = "frs_followed_live_tip";
                TiebaStatic.log(new ar("c12540"));
                if (this.jda != null) {
                    this.jda.hideTip();
                }
            } else if (this.jdc == 2) {
                str = "frs_hot_live_tip";
                TiebaStatic.log(new ar("c12331"));
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(this.iKx.getPageContext().getPageActivity(), this.jde, this.jdf, str, getUserId(), equals, null, null)));
            if (this.iKx.cys().getForum().isGameForumType()) {
                CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_GAME_FRS_JUMP_TO_LIVE_TAB);
                customMessage.setTag(this.iKx.getBaseFragmentActivity().getUniqueId());
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_FRS_JUMP_TO_LIVE_TAB);
                customResponsedMessage.setOrginalMessage(customMessage);
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                return;
            }
            e.mY().post(new Runnable() { // from class: com.baidu.tieba.frs.live.a.5
                @Override // java.lang.Runnable
                public void run() {
                    a.this.cDz();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rO() {
        if (this.jdc == 2) {
            cDB();
        }
        if (this.jda != null) {
            this.jda.hideTip();
        }
    }

    private void cDB() {
        this.jdb++;
        com.baidu.tbadk.core.sharedPref.b.bpu().putInt(SharedPrefConfig.FRS_HOT_LIVE_TIP_CLOSE_NUM + getUserId(), this.jdb);
    }

    private int cDC() {
        return com.baidu.tbadk.core.sharedPref.b.bpu().getInt(SharedPrefConfig.FRS_HOT_LIVE_TIP_CLOSE_NUM + getUserId(), 0);
    }

    private void cDD() {
        this.jdb = 0;
        com.baidu.tbadk.core.sharedPref.b.bpu().putInt(SharedPrefConfig.FRS_HOT_LIVE_TIP_CLOSE_NUM + getUserId(), this.jdb);
    }

    private void saveLastShowTime() {
        com.baidu.tbadk.core.sharedPref.b.bpu().putLong(SharedPrefConfig.FRS_HOT_LIVE_TIP_LAST_SHOWTIME + getUserId(), System.currentTimeMillis());
    }

    private long getLastShowTime() {
        return com.baidu.tbadk.core.sharedPref.b.bpu().getLong(SharedPrefConfig.FRS_HOT_LIVE_TIP_LAST_SHOWTIME + getUserId(), 0L);
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
        if (this.jda != null) {
            this.jda.cAj();
        }
        e.mY().removeCallbacks(this.jdi);
        if (this.jdg != null) {
            this.jdg.onDestory();
        }
    }
}
