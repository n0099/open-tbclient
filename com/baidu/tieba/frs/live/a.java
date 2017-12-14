package com.baidu.tieba.frs.live;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.g.e;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.ala.AlaLiveInfoListCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.at;
import com.baidu.tieba.frs.entelechy.b.d;
import com.baidu.tieba.frs.g;
import com.baidu.tieba.frs.j;
import com.baidu.tieba.frs.live.c;
/* loaded from: classes.dex */
public class a {
    private at bmJ;
    private g cIy;
    private TextView cUT;
    private FrameLayout cXj;
    private ImageView cXk;
    private int cXm;
    private String cXn;
    private AlaLiveInfoCoreData cXo;
    private AlaLiveInfoListCoreData cXp;
    private c cXq;
    private int mForumId;
    private boolean isFirst = true;
    private c.a cXr = new c.a() { // from class: com.baidu.tieba.frs.live.a.1
        @Override // com.baidu.tieba.frs.live.c.a
        public void a(FrsLiveTipResponseMessage frsLiveTipResponseMessage) {
            if (frsLiveTipResponseMessage != null) {
                a.this.cXm = frsLiveTipResponseMessage.remindType;
                a.this.cXn = frsLiveTipResponseMessage.remindText;
                a.this.cXo = frsLiveTipResponseMessage.infoCoreData;
                a.this.cXp = frsLiveTipResponseMessage.listCoreData;
                if (a.this.bmJ != null) {
                    a.this.bmJ.amJ();
                }
                if (a.this.cXm != 0) {
                    a.this.apE();
                }
            }
        }
    };
    private Runnable cXs = new Runnable() { // from class: com.baidu.tieba.frs.live.a.2
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.cXq != null) {
                a.this.cXq.kF(a.this.mForumId);
            }
        }
    };
    private int cXl = apJ();

    public a(g gVar, int i) {
        this.cIy = gVar;
        this.mForumId = i;
    }

    public void apD() {
        if (this.cIy != null && this.cIy.isAdded()) {
            if (System.currentTimeMillis() - apM() >= 1800000) {
                if (this.cIy.alw() && isFirst()) {
                    this.isFirst = false;
                    return;
                }
                if (this.cXq == null) {
                    this.cXq = new c(this.cXr);
                }
                e.fP().removeCallbacks(this.cXs);
                e.fP().postDelayed(this.cXs, TbConfig.NOTIFY_SOUND_INTERVAL);
            }
        }
    }

    public void apE() {
        if (!StringUtils.isNull(this.cXn) && this.cXo != null) {
            if (this.cXm != 2 || apJ() < 3) {
                bs(this.cIy.getPageContext().getPageActivity());
                if (this.cUT != null) {
                    this.cUT.setText(this.cXn);
                }
                onChangeSkinType();
                PL();
                apL();
            }
        }
    }

    public void apF() {
        if (this.cIy != null) {
            d alm = this.cIy.alm();
            if ((alm instanceof com.baidu.tieba.frs.entelechy.c.a) && ((com.baidu.tieba.frs.entelechy.c.a) alm).anY() != null) {
                ((com.baidu.tieba.frs.entelechy.c.a) alm).anY().kQ(49);
            }
        }
    }

    private void onChangeSkinType() {
        aj.j(this.cXj, d.f.bg_frs_hot_live_tip_selector);
        aj.i(this.cUT, d.C0096d.cp_cont_i);
        aj.c(this.cXk, d.f.icon_home_card_close_white);
        this.cUT.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, aj.getDrawable(d.f.icon_arrow_more_white), (Drawable) null);
    }

    private void bs(Context context) {
        if (context != null && this.cXj == null) {
            this.cXj = (FrameLayout) LayoutInflater.from(context).inflate(d.h.frs_hot_live_tip, (ViewGroup) null);
            this.cXj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.live.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.apG();
                }
            });
            this.cUT = (TextView) this.cXj.findViewById(d.g.frs_hot_live_tip_content);
            this.cXk = (ImageView) this.cXj.findViewById(d.g.frs_hot_live_tip_close);
            this.cXk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.live.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.apH();
                }
            });
            onChangeSkinType();
        }
    }

    private void PL() {
        if (this.cIy != null) {
            com.baidu.tieba.frs.entelechy.b.d alm = this.cIy.alm();
            j alo = this.cIy.alo();
            if (alo != null && alm != null && alm.anT() != null && (alo.WQ() instanceof NoPressedRelativeLayout)) {
                View anT = alm.anT();
                BdTypeListView listView = alo.getListView();
                if (anT != null && listView != null) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, l.f(TbadkCoreApplication.getInst(), d.e.ds56));
                    layoutParams.addRule(6, d.g.frs_list_content);
                    if (alo.alL() != null && alo.alL().getLayoutParams() != null) {
                        layoutParams.topMargin = alo.alL().getLayoutParams().height;
                    } else {
                        layoutParams.topMargin = 0;
                    }
                    if (this.bmJ == null) {
                        this.bmJ = new at();
                    }
                    NoPressedRelativeLayout noPressedRelativeLayout = (NoPressedRelativeLayout) alo.WQ();
                    if (this.cXm == 2) {
                        this.bmJ.a(this.cXj, noPressedRelativeLayout, layoutParams, 5000);
                    } else if (this.cXm == 1) {
                        this.bmJ.a(this.cXj, noPressedRelativeLayout, layoutParams);
                        TiebaStatic.log(new ak("c12539"));
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void apG() {
        apK();
        if (this.cXo != null && this.cIy != null && this.cIy.isAdded()) {
            boolean equals = TextUtils.equals(getUserId(), String.valueOf(this.cXo.userID));
            String str = "";
            if (this.cXm == 1) {
                str = AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_FRS_FOLLOWED_LIVE_TIP;
                TiebaStatic.log(new ak("c12540"));
                if (this.bmJ != null) {
                    this.bmJ.hideTip();
                }
            } else if (this.cXm == 2) {
                str = AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_FRS_HOT_LIVE_TIP;
                TiebaStatic.log(new ak("c12331"));
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(this.cIy.getPageContext().getPageActivity(), this.cXo, this.cXp, str, getUserId(), equals, null, null)));
            if (this.cIy.alF().aRo().isGameForumType()) {
                CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_GAME_FRS_JUMP_TO_LIVE_TAB);
                customMessage.setTag(this.cIy.getBaseFragmentActivity().getUniqueId());
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_FRS_JUMP_TO_LIVE_TAB);
                customResponsedMessage.setOrginalMessage(customMessage);
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                return;
            }
            e.fP().post(new Runnable() { // from class: com.baidu.tieba.frs.live.a.5
                @Override // java.lang.Runnable
                public void run() {
                    a.this.apF();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void apH() {
        if (this.cXm == 2) {
            apI();
        }
        if (this.bmJ != null) {
            this.bmJ.hideTip();
        }
    }

    private void apI() {
        this.cXl++;
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("FRS_HOT_LIVE_TIP_CLOSE_NUM" + getUserId(), this.cXl);
    }

    private int apJ() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("FRS_HOT_LIVE_TIP_CLOSE_NUM" + getUserId(), 0);
    }

    private void apK() {
        this.cXl = 0;
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("FRS_HOT_LIVE_TIP_CLOSE_NUM" + getUserId(), this.cXl);
    }

    private void apL() {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("FRS_HOT_LIVE_TIP_LAST_SHOWTIME" + getUserId(), System.currentTimeMillis());
    }

    private long apM() {
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
        if (this.bmJ != null) {
            this.bmJ.amJ();
        }
        e.fP().removeCallbacks(this.cXs);
        if (this.cXq != null) {
            this.cXq.onDestory();
        }
    }
}
