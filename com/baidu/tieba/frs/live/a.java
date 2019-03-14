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
import com.baidu.mapapi.UIMsg;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.ala.AlaLiveInfoListCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.aq;
import com.baidu.tieba.frs.k;
import com.baidu.tieba.frs.live.c;
/* loaded from: classes4.dex */
public class a {
    private aq dfH;
    private FrsFragment faG;
    private TextView fle;
    private FrameLayout fqm;
    private ImageView fqn;
    private int fqp;
    private String fqq;
    private AlaLiveInfoCoreData fqr;
    private AlaLiveInfoListCoreData fqs;
    private c fqt;
    private int mForumId;
    private boolean isFirst = true;
    private c.a fqu = new c.a() { // from class: com.baidu.tieba.frs.live.a.1
        @Override // com.baidu.tieba.frs.live.c.a
        public void a(FrsLiveTipResponseMessage frsLiveTipResponseMessage) {
            if (frsLiveTipResponseMessage != null) {
                a.this.fqp = frsLiveTipResponseMessage.remindType;
                a.this.fqq = frsLiveTipResponseMessage.remindText;
                a.this.fqr = frsLiveTipResponseMessage.infoCoreData;
                a.this.fqs = frsLiveTipResponseMessage.listCoreData;
                if (a.this.dfH != null) {
                    a.this.dfH.bez();
                }
                if (a.this.fqp != 0) {
                    a.this.bhu();
                }
            }
        }
    };
    private Runnable fqv = new Runnable() { // from class: com.baidu.tieba.frs.live.a.2
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.fqt != null) {
                a.this.fqt.ra(a.this.mForumId);
            }
        }
    };
    private int fqo = bhy();

    public a(FrsFragment frsFragment, int i) {
        this.faG = frsFragment;
        this.mForumId = i;
    }

    public void bht() {
        if (this.faG != null && this.faG.isAdded()) {
            if (System.currentTimeMillis() - getLastShowTime() >= 1800000) {
                if (this.faG.bcG() && isFirst()) {
                    this.isFirst = false;
                    return;
                }
                if (this.fqt == null) {
                    this.fqt = new c(this.fqu);
                }
                e.jH().removeCallbacks(this.fqv);
                e.jH().postDelayed(this.fqv, 5000L);
            }
        }
    }

    public void bhu() {
        if (!StringUtils.isNull(this.fqq) && this.fqr != null) {
            if (this.fqp != 2 || bhy() < 3) {
                initView(this.faG.getPageContext().getPageActivity());
                if (this.fle != null) {
                    this.fle.setText(this.fqq);
                }
                onChangeSkinType();
                aPE();
                saveLastShowTime();
            }
        }
    }

    public void bhv() {
        if (this.faG != null) {
            this.faG.bcs().rC(49);
        }
    }

    private void onChangeSkinType() {
        al.k(this.fqm, d.f.bg_frs_hot_live_tip_selector);
        al.j(this.fle, d.C0277d.cp_btn_a);
        al.c(this.fqn, d.f.icon_home_card_close_white);
        this.fle.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(d.f.icon_arrow_more_white), (Drawable) null);
    }

    private void initView(Context context) {
        if (context != null && this.fqm == null) {
            this.fqm = (FrameLayout) LayoutInflater.from(context).inflate(d.h.frs_hot_live_tip, (ViewGroup) null);
            this.fqm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.live.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.bhw();
                }
            });
            this.fle = (TextView) this.fqm.findViewById(d.g.frs_hot_live_tip_content);
            this.fqn = (ImageView) this.fqm.findViewById(d.g.frs_hot_live_tip_close);
            this.fqn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.live.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.qp();
                }
            });
            onChangeSkinType();
        }
    }

    private void aPE() {
        k bcu;
        FrameLayout frameLayout;
        if (this.faG != null && (bcu = this.faG.bcu()) != null && bcu.getListView() != null && (frameLayout = (FrameLayout) bcu.bdM()) != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, l.h(TbadkCoreApplication.getInst(), d.e.ds56));
            if (this.dfH == null) {
                this.dfH = new aq();
            }
            if (this.fqp == 2) {
                this.dfH.a(this.fqm, frameLayout, layoutParams, UIMsg.m_AppUI.MSG_APP_GPS);
            } else if (this.fqp == 1) {
                this.dfH.a(this.fqm, frameLayout, layoutParams);
                TiebaStatic.log(new am("c12539"));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bhw() {
        bhz();
        if (this.fqr != null && this.faG != null && this.faG.isAdded()) {
            boolean equals = TextUtils.equals(getUserId(), String.valueOf(this.fqr.userID));
            String str = "";
            if (this.fqp == 1) {
                str = AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_FRS_FOLLOWED_LIVE_TIP;
                TiebaStatic.log(new am("c12540"));
                if (this.dfH != null) {
                    this.dfH.hideTip();
                }
            } else if (this.fqp == 2) {
                str = AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_FRS_HOT_LIVE_TIP;
                TiebaStatic.log(new am("c12331"));
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(this.faG.getPageContext().getPageActivity(), this.fqr, this.fqs, str, getUserId(), equals, null, null)));
            if (this.faG.bcR().getForum().isGameForumType()) {
                CustomMessage customMessage = new CustomMessage(2001622);
                customMessage.setTag(this.faG.getBaseFragmentActivity().getUniqueId());
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2001622);
                customResponsedMessage.setOrginalMessage(customMessage);
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                return;
            }
            e.jH().post(new Runnable() { // from class: com.baidu.tieba.frs.live.a.5
                @Override // java.lang.Runnable
                public void run() {
                    a.this.bhv();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qp() {
        if (this.fqp == 2) {
            bhx();
        }
        if (this.dfH != null) {
            this.dfH.hideTip();
        }
    }

    private void bhx() {
        this.fqo++;
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("FRS_HOT_LIVE_TIP_CLOSE_NUM" + getUserId(), this.fqo);
    }

    private int bhy() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("FRS_HOT_LIVE_TIP_CLOSE_NUM" + getUserId(), 0);
    }

    private void bhz() {
        this.fqo = 0;
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("FRS_HOT_LIVE_TIP_CLOSE_NUM" + getUserId(), this.fqo);
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
        if (this.dfH != null) {
            this.dfH.bez();
        }
        e.jH().removeCallbacks(this.fqv);
        if (this.fqt != null) {
            this.fqt.onDestory();
        }
    }
}
