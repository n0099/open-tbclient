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
import com.baidu.tieba.frs.as;
import com.baidu.tieba.frs.entelechy.b.d;
import com.baidu.tieba.frs.f;
import com.baidu.tieba.frs.i;
import com.baidu.tieba.frs.live.c;
/* loaded from: classes.dex */
public class a {
    private as bhk;
    private TextView cLu;
    private FrameLayout cNJ;
    private ImageView cNK;
    private int cNM;
    private String cNN;
    private AlaLiveInfoCoreData cNO;
    private AlaLiveInfoListCoreData cNP;
    private c cNQ;
    private f czk;
    private int mForumId;
    private boolean isFirst = true;
    private c.a cNR = new c.a() { // from class: com.baidu.tieba.frs.live.a.1
        @Override // com.baidu.tieba.frs.live.c.a
        public void a(FrsLiveTipResponseMessage frsLiveTipResponseMessage) {
            if (frsLiveTipResponseMessage != null) {
                a.this.cNM = frsLiveTipResponseMessage.remindType;
                a.this.cNN = frsLiveTipResponseMessage.remindText;
                a.this.cNO = frsLiveTipResponseMessage.infoCoreData;
                a.this.cNP = frsLiveTipResponseMessage.listCoreData;
                if (a.this.bhk != null) {
                    a.this.bhk.akE();
                }
                if (a.this.cNM != 0) {
                    a.this.anB();
                }
            }
        }
    };
    private Runnable cNS = new Runnable() { // from class: com.baidu.tieba.frs.live.a.2
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.cNQ != null) {
                a.this.cNQ.kf(a.this.mForumId);
            }
        }
    };
    private int cNL = anG();

    public a(f fVar, int i) {
        this.czk = fVar;
        this.mForumId = i;
    }

    public void anA() {
        if (this.czk != null && this.czk.isAdded()) {
            if (System.currentTimeMillis() - anJ() >= 1800000) {
                if (this.czk.ajs() && isFirst()) {
                    this.isFirst = false;
                    return;
                }
                if (this.cNQ == null) {
                    this.cNQ = new c(this.cNR);
                }
                e.fP().removeCallbacks(this.cNS);
                e.fP().postDelayed(this.cNS, TbConfig.NOTIFY_SOUND_INTERVAL);
            }
        }
    }

    public void anB() {
        if (!StringUtils.isNull(this.cNN) && this.cNO != null) {
            if (this.cNM != 2 || anG() < 3) {
                bq(this.czk.getPageContext().getPageActivity());
                if (this.cLu != null) {
                    this.cLu.setText(this.cNN);
                }
                onChangeSkinType();
                Oy();
                anI();
            }
        }
    }

    public void anC() {
        if (this.czk != null) {
            d aji = this.czk.aji();
            if ((aji instanceof com.baidu.tieba.frs.entelechy.c.a) && ((com.baidu.tieba.frs.entelechy.c.a) aji).alU() != null) {
                ((com.baidu.tieba.frs.entelechy.c.a) aji).alU().kq(49);
            }
        }
    }

    private void onChangeSkinType() {
        aj.j(this.cNJ, d.f.bg_frs_hot_live_tip_selector);
        aj.i(this.cLu, d.C0080d.cp_cont_i);
        aj.c(this.cNK, d.f.icon_home_card_close_white);
        this.cLu.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, aj.getDrawable(d.f.icon_arrow_more_white), (Drawable) null);
    }

    private void bq(Context context) {
        if (context != null && this.cNJ == null) {
            this.cNJ = (FrameLayout) LayoutInflater.from(context).inflate(d.h.frs_hot_live_tip, (ViewGroup) null);
            this.cNJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.live.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.anD();
                }
            });
            this.cLu = (TextView) this.cNJ.findViewById(d.g.frs_hot_live_tip_content);
            this.cNK = (ImageView) this.cNJ.findViewById(d.g.frs_hot_live_tip_close);
            this.cNK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.live.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.anE();
                }
            });
            onChangeSkinType();
        }
    }

    private void Oy() {
        if (this.czk != null) {
            com.baidu.tieba.frs.entelechy.b.d aji = this.czk.aji();
            i ajk = this.czk.ajk();
            if (ajk != null && aji != null && aji.alP() != null && (ajk.VB() instanceof NoPressedRelativeLayout)) {
                View alP = aji.alP();
                BdTypeListView listView = ajk.getListView();
                if (alP != null && listView != null) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, l.f(TbadkCoreApplication.getInst(), d.e.ds56));
                    layoutParams.addRule(6, d.g.frs_list_content);
                    if (ajk.ajI() != null && ajk.ajI().getLayoutParams() != null) {
                        layoutParams.topMargin = ajk.ajI().getLayoutParams().height;
                    } else {
                        layoutParams.topMargin = 0;
                    }
                    if (this.bhk == null) {
                        this.bhk = new as();
                    }
                    NoPressedRelativeLayout noPressedRelativeLayout = (NoPressedRelativeLayout) ajk.VB();
                    if (this.cNM == 2) {
                        this.bhk.a(this.cNJ, noPressedRelativeLayout, layoutParams, 5000);
                    } else if (this.cNM == 1) {
                        this.bhk.a(this.cNJ, noPressedRelativeLayout, layoutParams);
                        TiebaStatic.log(new ak("c12539"));
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void anD() {
        anH();
        if (this.cNO != null && this.czk != null && this.czk.isAdded()) {
            boolean equals = TextUtils.equals(getUserId(), String.valueOf(this.cNO.userID));
            String str = "";
            if (this.cNM == 1) {
                str = AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_FRS_FOLLOWED_LIVE_TIP;
                TiebaStatic.log(new ak("c12540"));
                if (this.bhk != null) {
                    this.bhk.hideTip();
                }
            } else if (this.cNM == 2) {
                str = AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_FRS_HOT_LIVE_TIP;
                TiebaStatic.log(new ak("c12331"));
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(this.czk.getPageContext().getPageActivity(), this.cNO, this.cNP, str, getUserId(), equals, null, null)));
            if (this.czk.ajB().aPU().isGameForumType()) {
                CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_GAME_FRS_JUMP_TO_LIVE_TAB);
                customMessage.setTag(this.czk.getBaseFragmentActivity().getUniqueId());
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_FRS_JUMP_TO_LIVE_TAB);
                customResponsedMessage.setOrginalMessage(customMessage);
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                return;
            }
            e.fP().post(new Runnable() { // from class: com.baidu.tieba.frs.live.a.5
                @Override // java.lang.Runnable
                public void run() {
                    a.this.anC();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void anE() {
        if (this.cNM == 2) {
            anF();
        }
        if (this.bhk != null) {
            this.bhk.hideTip();
        }
    }

    private void anF() {
        this.cNL++;
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("FRS_HOT_LIVE_TIP_CLOSE_NUM" + getUserId(), this.cNL);
    }

    private int anG() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("FRS_HOT_LIVE_TIP_CLOSE_NUM" + getUserId(), 0);
    }

    private void anH() {
        this.cNL = 0;
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("FRS_HOT_LIVE_TIP_CLOSE_NUM" + getUserId(), this.cNL);
    }

    private void anI() {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("FRS_HOT_LIVE_TIP_LAST_SHOWTIME" + getUserId(), System.currentTimeMillis());
    }

    private long anJ() {
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
        if (this.bhk != null) {
            this.bhk.akE();
        }
        e.fP().removeCallbacks(this.cNS);
        if (this.cNQ != null) {
            this.cNQ.onDestory();
        }
    }
}
