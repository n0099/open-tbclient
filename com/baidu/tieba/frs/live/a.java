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
    private TextView hBf;
    private FrameLayout hGh;
    private ImageView hGi;
    private aw hGj;
    private int hGl;
    private String hGm;
    private AlaLiveInfoCoreData hGn;
    private AlaLiveInfoListCoreData hGo;
    private c hGp;
    private FrsFragment hpm;
    private int mForumId;
    private boolean isFirst = true;
    private c.a hGq = new c.a() { // from class: com.baidu.tieba.frs.live.a.1
        @Override // com.baidu.tieba.frs.live.c.a
        public void a(FrsLiveTipResponseMessage frsLiveTipResponseMessage) {
            if (frsLiveTipResponseMessage != null) {
                a.this.hGl = frsLiveTipResponseMessage.remindType;
                a.this.hGm = frsLiveTipResponseMessage.remindText;
                a.this.hGn = frsLiveTipResponseMessage.infoCoreData;
                a.this.hGo = frsLiveTipResponseMessage.listCoreData;
                if (a.this.hGj != null) {
                    a.this.hGj.bXd();
                }
                if (a.this.hGl != 0) {
                    a.this.cag();
                }
            }
        }
    };
    private Runnable hGr = new Runnable() { // from class: com.baidu.tieba.frs.live.a.2
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.hGp != null) {
                a.this.hGp.uW(a.this.mForumId);
            }
        }
    };
    private int hGk = cak();

    public a(FrsFragment frsFragment, int i) {
        this.hpm = frsFragment;
        this.mForumId = i;
    }

    public void caf() {
        if (this.hpm != null && this.hpm.isAdded()) {
            if (System.currentTimeMillis() - getLastShowTime() >= 1800000) {
                if (this.hpm.bVj() && isFirst()) {
                    this.isFirst = false;
                    return;
                }
                if (this.hGp == null) {
                    this.hGp = new c(this.hGq);
                }
                e.ld().removeCallbacks(this.hGr);
                e.ld().postDelayed(this.hGr, 5000L);
            }
        }
    }

    public void cag() {
        if (!StringUtils.isNull(this.hGm) && this.hGn != null) {
            if (this.hGl != 2 || cak() < 3) {
                initView(this.hpm.getPageContext().getPageActivity());
                if (this.hBf != null) {
                    this.hBf.setText(this.hGm);
                }
                onChangeSkinType();
                bJB();
                saveLastShowTime();
            }
        }
    }

    public void cah() {
        if (this.hpm != null) {
            this.hpm.bUR().vD(49);
        }
    }

    private void onChangeSkinType() {
        am.setBackgroundResource(this.hGh, R.drawable.bg_frs_hot_live_tip_selector);
        am.setViewTextColor(this.hBf, (int) R.color.cp_cont_a);
        am.setImageResource(this.hGi, R.drawable.icon_home_card_close_white);
        this.hBf.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(R.drawable.icon_arrow_more_white), (Drawable) null);
    }

    private void initView(Context context) {
        if (context != null && this.hGh == null) {
            this.hGh = (FrameLayout) LayoutInflater.from(context).inflate(R.layout.frs_hot_live_tip, (ViewGroup) null);
            this.hGh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.live.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.cai();
                }
            });
            this.hBf = (TextView) this.hGh.findViewById(R.id.frs_hot_live_tip_content);
            this.hGi = (ImageView) this.hGh.findViewById(R.id.frs_hot_live_tip_close);
            this.hGi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.live.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.pS();
                }
            });
            onChangeSkinType();
        }
    }

    private void bJB() {
        n bUT;
        FrameLayout frameLayout;
        if (this.hpm != null && (bUT = this.hpm.bUT()) != null && bUT.getListView() != null && (frameLayout = (FrameLayout) bUT.bWp()) != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds56));
            if (this.hGj == null) {
                this.hGj = new aw();
            }
            if (this.hGl == 2) {
                this.hGj.a(this.hGh, frameLayout, layoutParams, 5000);
            } else if (this.hGl == 1) {
                this.hGj.a(this.hGh, frameLayout, layoutParams);
                TiebaStatic.log(new an("c12539"));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cai() {
        cal();
        if (this.hGn != null && this.hpm != null && this.hpm.isAdded()) {
            boolean equals = TextUtils.equals(getUserId(), String.valueOf(this.hGn.userID));
            String str = "";
            if (this.hGl == 1) {
                str = "frs_followed_live_tip";
                TiebaStatic.log(new an("c12540"));
                if (this.hGj != null) {
                    this.hGj.hideTip();
                }
            } else if (this.hGl == 2) {
                str = "frs_hot_live_tip";
                TiebaStatic.log(new an("c12331"));
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(this.hpm.getPageContext().getPageActivity(), this.hGn, this.hGo, str, getUserId(), equals, null, null)));
            if (this.hpm.bVu().getForum().isGameForumType()) {
                CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_GAME_FRS_JUMP_TO_LIVE_TAB);
                customMessage.setTag(this.hpm.getBaseFragmentActivity().getUniqueId());
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_FRS_JUMP_TO_LIVE_TAB);
                customResponsedMessage.setOrginalMessage(customMessage);
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                return;
            }
            e.ld().post(new Runnable() { // from class: com.baidu.tieba.frs.live.a.5
                @Override // java.lang.Runnable
                public void run() {
                    a.this.cah();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pS() {
        if (this.hGl == 2) {
            caj();
        }
        if (this.hGj != null) {
            this.hGj.hideTip();
        }
    }

    private void caj() {
        this.hGk++;
        com.baidu.tbadk.core.sharedPref.b.aTX().putInt(SharedPrefConfig.FRS_HOT_LIVE_TIP_CLOSE_NUM + getUserId(), this.hGk);
    }

    private int cak() {
        return com.baidu.tbadk.core.sharedPref.b.aTX().getInt(SharedPrefConfig.FRS_HOT_LIVE_TIP_CLOSE_NUM + getUserId(), 0);
    }

    private void cal() {
        this.hGk = 0;
        com.baidu.tbadk.core.sharedPref.b.aTX().putInt(SharedPrefConfig.FRS_HOT_LIVE_TIP_CLOSE_NUM + getUserId(), this.hGk);
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
        if (this.hGj != null) {
            this.hGj.bXd();
        }
        e.ld().removeCallbacks(this.hGr);
        if (this.hGp != null) {
            this.hGp.onDestory();
        }
    }
}
