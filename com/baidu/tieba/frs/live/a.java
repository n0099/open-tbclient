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
    private at bmN;
    private g cIC;
    private TextView cUX;
    private FrameLayout cXn;
    private ImageView cXo;
    private int cXq;
    private String cXr;
    private AlaLiveInfoCoreData cXs;
    private AlaLiveInfoListCoreData cXt;
    private c cXu;
    private int mForumId;
    private boolean isFirst = true;
    private c.a cXv = new c.a() { // from class: com.baidu.tieba.frs.live.a.1
        @Override // com.baidu.tieba.frs.live.c.a
        public void a(FrsLiveTipResponseMessage frsLiveTipResponseMessage) {
            if (frsLiveTipResponseMessage != null) {
                a.this.cXq = frsLiveTipResponseMessage.remindType;
                a.this.cXr = frsLiveTipResponseMessage.remindText;
                a.this.cXs = frsLiveTipResponseMessage.infoCoreData;
                a.this.cXt = frsLiveTipResponseMessage.listCoreData;
                if (a.this.bmN != null) {
                    a.this.bmN.amJ();
                }
                if (a.this.cXq != 0) {
                    a.this.apE();
                }
            }
        }
    };
    private Runnable cXw = new Runnable() { // from class: com.baidu.tieba.frs.live.a.2
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.cXu != null) {
                a.this.cXu.kF(a.this.mForumId);
            }
        }
    };
    private int cXp = apJ();

    public a(g gVar, int i) {
        this.cIC = gVar;
        this.mForumId = i;
    }

    public void apD() {
        if (this.cIC != null && this.cIC.isAdded()) {
            if (System.currentTimeMillis() - apM() >= 1800000) {
                if (this.cIC.alv() && isFirst()) {
                    this.isFirst = false;
                    return;
                }
                if (this.cXu == null) {
                    this.cXu = new c(this.cXv);
                }
                e.fP().removeCallbacks(this.cXw);
                e.fP().postDelayed(this.cXw, TbConfig.NOTIFY_SOUND_INTERVAL);
            }
        }
    }

    public void apE() {
        if (!StringUtils.isNull(this.cXr) && this.cXs != null) {
            if (this.cXq != 2 || apJ() < 3) {
                bs(this.cIC.getPageContext().getPageActivity());
                if (this.cUX != null) {
                    this.cUX.setText(this.cXr);
                }
                onChangeSkinType();
                PL();
                apL();
            }
        }
    }

    public void apF() {
        if (this.cIC != null) {
            d all = this.cIC.all();
            if ((all instanceof com.baidu.tieba.frs.entelechy.c.a) && ((com.baidu.tieba.frs.entelechy.c.a) all).anY() != null) {
                ((com.baidu.tieba.frs.entelechy.c.a) all).anY().kQ(49);
            }
        }
    }

    private void onChangeSkinType() {
        aj.j(this.cXn, d.f.bg_frs_hot_live_tip_selector);
        aj.i(this.cUX, d.C0095d.cp_cont_i);
        aj.c(this.cXo, d.f.icon_home_card_close_white);
        this.cUX.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, aj.getDrawable(d.f.icon_arrow_more_white), (Drawable) null);
    }

    private void bs(Context context) {
        if (context != null && this.cXn == null) {
            this.cXn = (FrameLayout) LayoutInflater.from(context).inflate(d.h.frs_hot_live_tip, (ViewGroup) null);
            this.cXn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.live.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.apG();
                }
            });
            this.cUX = (TextView) this.cXn.findViewById(d.g.frs_hot_live_tip_content);
            this.cXo = (ImageView) this.cXn.findViewById(d.g.frs_hot_live_tip_close);
            this.cXo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.live.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.apH();
                }
            });
            onChangeSkinType();
        }
    }

    private void PL() {
        if (this.cIC != null) {
            com.baidu.tieba.frs.entelechy.b.d all = this.cIC.all();
            j aln = this.cIC.aln();
            if (aln != null && all != null && all.anT() != null && (aln.WQ() instanceof NoPressedRelativeLayout)) {
                View anT = all.anT();
                BdTypeListView listView = aln.getListView();
                if (anT != null && listView != null) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, l.f(TbadkCoreApplication.getInst(), d.e.ds56));
                    layoutParams.addRule(6, d.g.frs_list_content);
                    if (aln.alL() != null && aln.alL().getLayoutParams() != null) {
                        layoutParams.topMargin = aln.alL().getLayoutParams().height;
                    } else {
                        layoutParams.topMargin = 0;
                    }
                    if (this.bmN == null) {
                        this.bmN = new at();
                    }
                    NoPressedRelativeLayout noPressedRelativeLayout = (NoPressedRelativeLayout) aln.WQ();
                    if (this.cXq == 2) {
                        this.bmN.a(this.cXn, noPressedRelativeLayout, layoutParams, 5000);
                    } else if (this.cXq == 1) {
                        this.bmN.a(this.cXn, noPressedRelativeLayout, layoutParams);
                        TiebaStatic.log(new ak("c12539"));
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void apG() {
        apK();
        if (this.cXs != null && this.cIC != null && this.cIC.isAdded()) {
            boolean equals = TextUtils.equals(getUserId(), String.valueOf(this.cXs.userID));
            String str = "";
            if (this.cXq == 1) {
                str = AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_FRS_FOLLOWED_LIVE_TIP;
                TiebaStatic.log(new ak("c12540"));
                if (this.bmN != null) {
                    this.bmN.hideTip();
                }
            } else if (this.cXq == 2) {
                str = AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_FRS_HOT_LIVE_TIP;
                TiebaStatic.log(new ak("c12331"));
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(this.cIC.getPageContext().getPageActivity(), this.cXs, this.cXt, str, getUserId(), equals, null, null)));
            if (this.cIC.alE().aRo().isGameForumType()) {
                CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_GAME_FRS_JUMP_TO_LIVE_TAB);
                customMessage.setTag(this.cIC.getBaseFragmentActivity().getUniqueId());
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
        if (this.cXq == 2) {
            apI();
        }
        if (this.bmN != null) {
            this.bmN.hideTip();
        }
    }

    private void apI() {
        this.cXp++;
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("FRS_HOT_LIVE_TIP_CLOSE_NUM" + getUserId(), this.cXp);
    }

    private int apJ() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("FRS_HOT_LIVE_TIP_CLOSE_NUM" + getUserId(), 0);
    }

    private void apK() {
        this.cXp = 0;
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("FRS_HOT_LIVE_TIP_CLOSE_NUM" + getUserId(), this.cXp);
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
        if (this.bmN != null) {
            this.bmN.amJ();
        }
        e.fP().removeCallbacks(this.cXw);
        if (this.cXu != null) {
            this.cXu.onDestory();
        }
    }
}
