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
    private as bhb;
    private TextView cLb;
    private FrameLayout cNp;
    private ImageView cNq;
    private int cNs;
    private String cNt;
    private AlaLiveInfoCoreData cNu;
    private AlaLiveInfoListCoreData cNv;
    private c cNw;
    private f cyR;
    private int mForumId;
    private boolean isFirst = true;
    private c.a cNx = new c.a() { // from class: com.baidu.tieba.frs.live.a.1
        @Override // com.baidu.tieba.frs.live.c.a
        public void a(FrsLiveTipResponseMessage frsLiveTipResponseMessage) {
            if (frsLiveTipResponseMessage != null) {
                a.this.cNs = frsLiveTipResponseMessage.remindType;
                a.this.cNt = frsLiveTipResponseMessage.remindText;
                a.this.cNu = frsLiveTipResponseMessage.infoCoreData;
                a.this.cNv = frsLiveTipResponseMessage.listCoreData;
                if (a.this.bhb != null) {
                    a.this.bhb.akq();
                }
                if (a.this.cNs != 0) {
                    a.this.anm();
                }
            }
        }
    };
    private Runnable cNy = new Runnable() { // from class: com.baidu.tieba.frs.live.a.2
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.cNw != null) {
                a.this.cNw.kf(a.this.mForumId);
            }
        }
    };
    private int cNr = anr();

    public a(f fVar, int i) {
        this.cyR = fVar;
        this.mForumId = i;
    }

    public void anl() {
        if (this.cyR != null && this.cyR.isAdded()) {
            if (System.currentTimeMillis() - anu() >= 1800000) {
                if (this.cyR.aje() && isFirst()) {
                    this.isFirst = false;
                    return;
                }
                if (this.cNw == null) {
                    this.cNw = new c(this.cNx);
                }
                e.fP().removeCallbacks(this.cNy);
                e.fP().postDelayed(this.cNy, TbConfig.NOTIFY_SOUND_INTERVAL);
            }
        }
    }

    public void anm() {
        if (!StringUtils.isNull(this.cNt) && this.cNu != null) {
            if (this.cNs != 2 || anr() < 3) {
                bq(this.cyR.getPageContext().getPageActivity());
                if (this.cLb != null) {
                    this.cLb.setText(this.cNt);
                }
                onChangeSkinType();
                On();
                ant();
            }
        }
    }

    public void ann() {
        if (this.cyR != null) {
            d aiU = this.cyR.aiU();
            if ((aiU instanceof com.baidu.tieba.frs.entelechy.c.a) && ((com.baidu.tieba.frs.entelechy.c.a) aiU).alG() != null) {
                ((com.baidu.tieba.frs.entelechy.c.a) aiU).alG().kq(49);
            }
        }
    }

    private void onChangeSkinType() {
        aj.j(this.cNp, d.f.bg_frs_hot_live_tip_selector);
        aj.i(this.cLb, d.C0080d.cp_cont_i);
        aj.c(this.cNq, d.f.icon_home_card_close_white);
        this.cLb.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, aj.getDrawable(d.f.icon_arrow_more_white), (Drawable) null);
    }

    private void bq(Context context) {
        if (context != null && this.cNp == null) {
            this.cNp = (FrameLayout) LayoutInflater.from(context).inflate(d.h.frs_hot_live_tip, (ViewGroup) null);
            this.cNp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.live.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.ano();
                }
            });
            this.cLb = (TextView) this.cNp.findViewById(d.g.frs_hot_live_tip_content);
            this.cNq = (ImageView) this.cNp.findViewById(d.g.frs_hot_live_tip_close);
            this.cNq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.live.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.anp();
                }
            });
            onChangeSkinType();
        }
    }

    private void On() {
        if (this.cyR != null) {
            com.baidu.tieba.frs.entelechy.b.d aiU = this.cyR.aiU();
            i aiW = this.cyR.aiW();
            if (aiW != null && aiU != null && aiU.alB() != null && (aiW.Vq() instanceof NoPressedRelativeLayout)) {
                View alB = aiU.alB();
                BdTypeListView listView = aiW.getListView();
                if (alB != null && listView != null) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, l.f(TbadkCoreApplication.getInst(), d.e.ds56));
                    layoutParams.addRule(6, d.g.frs_list_content);
                    if (aiW.aju() != null && aiW.aju().getLayoutParams() != null) {
                        layoutParams.topMargin = aiW.aju().getLayoutParams().height;
                    } else {
                        layoutParams.topMargin = 0;
                    }
                    if (this.bhb == null) {
                        this.bhb = new as();
                    }
                    NoPressedRelativeLayout noPressedRelativeLayout = (NoPressedRelativeLayout) aiW.Vq();
                    if (this.cNs == 2) {
                        this.bhb.a(this.cNp, noPressedRelativeLayout, layoutParams, 5000);
                    } else if (this.cNs == 1) {
                        this.bhb.a(this.cNp, noPressedRelativeLayout, layoutParams);
                        TiebaStatic.log(new ak("c12539"));
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ano() {
        ans();
        if (this.cNu != null && this.cyR != null && this.cyR.isAdded()) {
            boolean equals = TextUtils.equals(getUserId(), String.valueOf(this.cNu.userID));
            String str = "";
            if (this.cNs == 1) {
                str = AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_FRS_FOLLOWED_LIVE_TIP;
                TiebaStatic.log(new ak("c12540"));
                if (this.bhb != null) {
                    this.bhb.hideTip();
                }
            } else if (this.cNs == 2) {
                str = AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_FRS_HOT_LIVE_TIP;
                TiebaStatic.log(new ak("c12331"));
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(this.cyR.getPageContext().getPageActivity(), this.cNu, this.cNv, str, getUserId(), equals, null, null)));
            if (this.cyR.ajn().aPM().isGameForumType()) {
                CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_GAME_FRS_JUMP_TO_LIVE_TAB);
                customMessage.setTag(this.cyR.getBaseFragmentActivity().getUniqueId());
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_FRS_JUMP_TO_LIVE_TAB);
                customResponsedMessage.setOrginalMessage(customMessage);
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                return;
            }
            e.fP().post(new Runnable() { // from class: com.baidu.tieba.frs.live.a.5
                @Override // java.lang.Runnable
                public void run() {
                    a.this.ann();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void anp() {
        if (this.cNs == 2) {
            anq();
        }
        if (this.bhb != null) {
            this.bhb.hideTip();
        }
    }

    private void anq() {
        this.cNr++;
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("FRS_HOT_LIVE_TIP_CLOSE_NUM" + getUserId(), this.cNr);
    }

    private int anr() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("FRS_HOT_LIVE_TIP_CLOSE_NUM" + getUserId(), 0);
    }

    private void ans() {
        this.cNr = 0;
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("FRS_HOT_LIVE_TIP_CLOSE_NUM" + getUserId(), this.cNr);
    }

    private void ant() {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("FRS_HOT_LIVE_TIP_LAST_SHOWTIME" + getUserId(), System.currentTimeMillis());
    }

    private long anu() {
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
        if (this.bhb != null) {
            this.bhb.akq();
        }
        e.fP().removeCallbacks(this.cNy);
        if (this.cNw != null) {
            this.cNw.onDestory();
        }
    }
}
