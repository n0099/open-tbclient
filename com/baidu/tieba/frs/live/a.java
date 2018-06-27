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
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.ala.AlaLiveInfoListCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.as;
import com.baidu.tieba.frs.k;
import com.baidu.tieba.frs.live.c;
/* loaded from: classes2.dex */
public class a {
    private as bwd;
    private FrameLayout dAf;
    private ImageView dAg;
    private int dAi;
    private String dAj;
    private AlaLiveInfoCoreData dAk;
    private AlaLiveInfoListCoreData dAl;
    private c dAm;
    private FrsFragment dla;
    private TextView dve;
    private int mForumId;
    private boolean isFirst = true;
    private c.a dAn = new c.a() { // from class: com.baidu.tieba.frs.live.a.1
        @Override // com.baidu.tieba.frs.live.c.a
        public void a(FrsLiveTipResponseMessage frsLiveTipResponseMessage) {
            if (frsLiveTipResponseMessage != null) {
                a.this.dAi = frsLiveTipResponseMessage.remindType;
                a.this.dAj = frsLiveTipResponseMessage.remindText;
                a.this.dAk = frsLiveTipResponseMessage.infoCoreData;
                a.this.dAl = frsLiveTipResponseMessage.listCoreData;
                if (a.this.bwd != null) {
                    a.this.bwd.avn();
                }
                if (a.this.dAi != 0) {
                    a.this.ayJ();
                }
            }
        }
    };
    private Runnable dAo = new Runnable() { // from class: com.baidu.tieba.frs.live.a.2
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.dAm != null) {
                a.this.dAm.lg(a.this.mForumId);
            }
        }
    };
    private int dAh = ayN();

    public a(FrsFragment frsFragment, int i) {
        this.dla = frsFragment;
        this.mForumId = i;
    }

    public void ayI() {
        if (this.dla != null && this.dla.isAdded()) {
            if (System.currentTimeMillis() - getLastShowTime() >= 1800000) {
                if (this.dla.atR() && isFirst()) {
                    this.isFirst = false;
                    return;
                }
                if (this.dAm == null) {
                    this.dAm = new c(this.dAn);
                }
                e.im().removeCallbacks(this.dAo);
                e.im().postDelayed(this.dAo, TbConfig.NOTIFY_SOUND_INTERVAL);
            }
        }
    }

    public void ayJ() {
        if (!StringUtils.isNull(this.dAj) && this.dAk != null) {
            if (this.dAi != 2 || ayN() < 3) {
                aW(this.dla.getPageContext().getPageActivity());
                if (this.dve != null) {
                    this.dve.setText(this.dAj);
                }
                onChangeSkinType();
                agR();
                saveLastShowTime();
            }
        }
    }

    public void ayK() {
        if (this.dla != null) {
            this.dla.atG().lF(49);
        }
    }

    private void onChangeSkinType() {
        am.i(this.dAf, d.f.bg_frs_hot_live_tip_selector);
        am.h(this.dve, d.C0142d.cp_cont_i);
        am.c(this.dAg, d.f.icon_home_card_close_white);
        this.dve.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(d.f.icon_arrow_more_white), (Drawable) null);
    }

    private void aW(Context context) {
        if (context != null && this.dAf == null) {
            this.dAf = (FrameLayout) LayoutInflater.from(context).inflate(d.i.frs_hot_live_tip, (ViewGroup) null);
            this.dAf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.live.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.ayL();
                }
            });
            this.dve = (TextView) this.dAf.findViewById(d.g.frs_hot_live_tip_content);
            this.dAg = (ImageView) this.dAf.findViewById(d.g.frs_hot_live_tip_close);
            this.dAg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.live.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.onClickClose();
                }
            });
            onChangeSkinType();
        }
    }

    private void agR() {
        k atI;
        FrameLayout frameLayout;
        if (this.dla != null && (atI = this.dla.atI()) != null && atI.getListView() != null && (frameLayout = (FrameLayout) atI.auR()) != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, l.e(TbadkCoreApplication.getInst(), d.e.ds56));
            if (atI.aux() != null && atI.aux().getLayoutParams() != null) {
                layoutParams.topMargin = atI.aux().getLayoutParams().height;
            } else {
                layoutParams.topMargin = 0;
            }
            if (this.bwd == null) {
                this.bwd = new as();
            }
            if (this.dAi == 2) {
                this.bwd.a(this.dAf, frameLayout, layoutParams, 5000);
            } else if (this.dAi == 1) {
                this.bwd.a(this.dAf, frameLayout, layoutParams);
                TiebaStatic.log(new an("c12539"));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ayL() {
        ayO();
        if (this.dAk != null && this.dla != null && this.dla.isAdded()) {
            boolean equals = TextUtils.equals(getUserId(), String.valueOf(this.dAk.userID));
            String str = "";
            if (this.dAi == 1) {
                str = AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_FRS_FOLLOWED_LIVE_TIP;
                TiebaStatic.log(new an("c12540"));
                if (this.bwd != null) {
                    this.bwd.hideTip();
                }
            } else if (this.dAi == 2) {
                str = AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_FRS_HOT_LIVE_TIP;
                TiebaStatic.log(new an("c12331"));
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(this.dla.getPageContext().getPageActivity(), this.dAk, this.dAl, str, getUserId(), equals, null, null)));
            if (this.dla.atZ().baT().isGameForumType()) {
                CustomMessage customMessage = new CustomMessage(2001622);
                customMessage.setTag(this.dla.getBaseFragmentActivity().getUniqueId());
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2001622);
                customResponsedMessage.setOrginalMessage(customMessage);
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                return;
            }
            e.im().post(new Runnable() { // from class: com.baidu.tieba.frs.live.a.5
                @Override // java.lang.Runnable
                public void run() {
                    a.this.ayK();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onClickClose() {
        if (this.dAi == 2) {
            ayM();
        }
        if (this.bwd != null) {
            this.bwd.hideTip();
        }
    }

    private void ayM() {
        this.dAh++;
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("FRS_HOT_LIVE_TIP_CLOSE_NUM" + getUserId(), this.dAh);
    }

    private int ayN() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("FRS_HOT_LIVE_TIP_CLOSE_NUM" + getUserId(), 0);
    }

    private void ayO() {
        this.dAh = 0;
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("FRS_HOT_LIVE_TIP_CLOSE_NUM" + getUserId(), this.dAh);
    }

    private void saveLastShowTime() {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("FRS_HOT_LIVE_TIP_LAST_SHOWTIME" + getUserId(), System.currentTimeMillis());
    }

    private long getLastShowTime() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("FRS_HOT_LIVE_TIP_LAST_SHOWTIME" + getUserId(), 0L);
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
        if (this.bwd != null) {
            this.bwd.avn();
        }
        e.im().removeCallbacks(this.dAo);
        if (this.dAm != null) {
            this.dAm.onDestory();
        }
    }
}
