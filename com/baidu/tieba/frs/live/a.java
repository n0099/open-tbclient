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
    private aq dfL;
    private FrsFragment fat;
    private TextView fkQ;
    private FrameLayout fpY;
    private ImageView fpZ;
    private int fqb;
    private String fqc;
    private AlaLiveInfoCoreData fqd;
    private AlaLiveInfoListCoreData fqe;
    private c fqf;
    private int mForumId;
    private boolean isFirst = true;
    private c.a fqg = new c.a() { // from class: com.baidu.tieba.frs.live.a.1
        @Override // com.baidu.tieba.frs.live.c.a
        public void a(FrsLiveTipResponseMessage frsLiveTipResponseMessage) {
            if (frsLiveTipResponseMessage != null) {
                a.this.fqb = frsLiveTipResponseMessage.remindType;
                a.this.fqc = frsLiveTipResponseMessage.remindText;
                a.this.fqd = frsLiveTipResponseMessage.infoCoreData;
                a.this.fqe = frsLiveTipResponseMessage.listCoreData;
                if (a.this.dfL != null) {
                    a.this.dfL.bex();
                }
                if (a.this.fqb != 0) {
                    a.this.bhs();
                }
            }
        }
    };
    private Runnable fqh = new Runnable() { // from class: com.baidu.tieba.frs.live.a.2
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.fqf != null) {
                a.this.fqf.qW(a.this.mForumId);
            }
        }
    };
    private int fqa = bhw();

    public a(FrsFragment frsFragment, int i) {
        this.fat = frsFragment;
        this.mForumId = i;
    }

    public void bhr() {
        if (this.fat != null && this.fat.isAdded()) {
            if (System.currentTimeMillis() - getLastShowTime() >= 1800000) {
                if (this.fat.bcE() && isFirst()) {
                    this.isFirst = false;
                    return;
                }
                if (this.fqf == null) {
                    this.fqf = new c(this.fqg);
                }
                e.jH().removeCallbacks(this.fqh);
                e.jH().postDelayed(this.fqh, 5000L);
            }
        }
    }

    public void bhs() {
        if (!StringUtils.isNull(this.fqc) && this.fqd != null) {
            if (this.fqb != 2 || bhw() < 3) {
                initView(this.fat.getPageContext().getPageActivity());
                if (this.fkQ != null) {
                    this.fkQ.setText(this.fqc);
                }
                onChangeSkinType();
                aPC();
                saveLastShowTime();
            }
        }
    }

    public void bht() {
        if (this.fat != null) {
            this.fat.bcq().ry(49);
        }
    }

    private void onChangeSkinType() {
        al.k(this.fpY, d.f.bg_frs_hot_live_tip_selector);
        al.j(this.fkQ, d.C0277d.cp_btn_a);
        al.c(this.fpZ, d.f.icon_home_card_close_white);
        this.fkQ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(d.f.icon_arrow_more_white), (Drawable) null);
    }

    private void initView(Context context) {
        if (context != null && this.fpY == null) {
            this.fpY = (FrameLayout) LayoutInflater.from(context).inflate(d.h.frs_hot_live_tip, (ViewGroup) null);
            this.fpY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.live.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.bhu();
                }
            });
            this.fkQ = (TextView) this.fpY.findViewById(d.g.frs_hot_live_tip_content);
            this.fpZ = (ImageView) this.fpY.findViewById(d.g.frs_hot_live_tip_close);
            this.fpZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.live.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.qp();
                }
            });
            onChangeSkinType();
        }
    }

    private void aPC() {
        k bcs;
        FrameLayout frameLayout;
        if (this.fat != null && (bcs = this.fat.bcs()) != null && bcs.getListView() != null && (frameLayout = (FrameLayout) bcs.bdK()) != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, l.h(TbadkCoreApplication.getInst(), d.e.ds56));
            if (this.dfL == null) {
                this.dfL = new aq();
            }
            if (this.fqb == 2) {
                this.dfL.a(this.fpY, frameLayout, layoutParams, UIMsg.m_AppUI.MSG_APP_GPS);
            } else if (this.fqb == 1) {
                this.dfL.a(this.fpY, frameLayout, layoutParams);
                TiebaStatic.log(new am("c12539"));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bhu() {
        bhx();
        if (this.fqd != null && this.fat != null && this.fat.isAdded()) {
            boolean equals = TextUtils.equals(getUserId(), String.valueOf(this.fqd.userID));
            String str = "";
            if (this.fqb == 1) {
                str = AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_FRS_FOLLOWED_LIVE_TIP;
                TiebaStatic.log(new am("c12540"));
                if (this.dfL != null) {
                    this.dfL.hideTip();
                }
            } else if (this.fqb == 2) {
                str = AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_FRS_HOT_LIVE_TIP;
                TiebaStatic.log(new am("c12331"));
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(this.fat.getPageContext().getPageActivity(), this.fqd, this.fqe, str, getUserId(), equals, null, null)));
            if (this.fat.bcP().getForum().isGameForumType()) {
                CustomMessage customMessage = new CustomMessage(2001622);
                customMessage.setTag(this.fat.getBaseFragmentActivity().getUniqueId());
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2001622);
                customResponsedMessage.setOrginalMessage(customMessage);
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                return;
            }
            e.jH().post(new Runnable() { // from class: com.baidu.tieba.frs.live.a.5
                @Override // java.lang.Runnable
                public void run() {
                    a.this.bht();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qp() {
        if (this.fqb == 2) {
            bhv();
        }
        if (this.dfL != null) {
            this.dfL.hideTip();
        }
    }

    private void bhv() {
        this.fqa++;
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("FRS_HOT_LIVE_TIP_CLOSE_NUM" + getUserId(), this.fqa);
    }

    private int bhw() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("FRS_HOT_LIVE_TIP_CLOSE_NUM" + getUserId(), 0);
    }

    private void bhx() {
        this.fqa = 0;
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("FRS_HOT_LIVE_TIP_CLOSE_NUM" + getUserId(), this.fqa);
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
        if (this.dfL != null) {
            this.dfL.bex();
        }
        e.jH().removeCallbacks(this.fqh);
        if (this.fqf != null) {
            this.fqf.onDestory();
        }
    }
}
