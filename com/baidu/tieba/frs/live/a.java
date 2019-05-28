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
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.aq;
import com.baidu.tieba.frs.k;
import com.baidu.tieba.frs.live.c;
/* loaded from: classes4.dex */
public class a {
    private aq dqp;
    private TextView fBm;
    private AlaLiveInfoListCoreData fGA;
    private c fGB;
    private FrameLayout fGu;
    private ImageView fGv;
    private int fGx;
    private String fGy;
    private AlaLiveInfoCoreData fGz;
    private FrsFragment fqJ;
    private int mForumId;
    private boolean isFirst = true;
    private c.a fGC = new c.a() { // from class: com.baidu.tieba.frs.live.a.1
        @Override // com.baidu.tieba.frs.live.c.a
        public void a(FrsLiveTipResponseMessage frsLiveTipResponseMessage) {
            if (frsLiveTipResponseMessage != null) {
                a.this.fGx = frsLiveTipResponseMessage.remindType;
                a.this.fGy = frsLiveTipResponseMessage.remindText;
                a.this.fGz = frsLiveTipResponseMessage.infoCoreData;
                a.this.fGA = frsLiveTipResponseMessage.listCoreData;
                if (a.this.dqp != null) {
                    a.this.dqp.blS();
                }
                if (a.this.fGx != 0) {
                    a.this.boO();
                }
            }
        }
    };
    private Runnable fGD = new Runnable() { // from class: com.baidu.tieba.frs.live.a.2
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.fGB != null) {
                a.this.fGB.se(a.this.mForumId);
            }
        }
    };
    private int fGw = boS();

    public a(FrsFragment frsFragment, int i) {
        this.fqJ = frsFragment;
        this.mForumId = i;
    }

    public void boN() {
        if (this.fqJ != null && this.fqJ.isAdded()) {
            if (System.currentTimeMillis() - getLastShowTime() >= 1800000) {
                if (this.fqJ.bkb() && isFirst()) {
                    this.isFirst = false;
                    return;
                }
                if (this.fGB == null) {
                    this.fGB = new c(this.fGC);
                }
                e.iB().removeCallbacks(this.fGD);
                e.iB().postDelayed(this.fGD, 5000L);
            }
        }
    }

    public void boO() {
        if (!StringUtils.isNull(this.fGy) && this.fGz != null) {
            if (this.fGx != 2 || boS() < 3) {
                initView(this.fqJ.getPageContext().getPageActivity());
                if (this.fBm != null) {
                    this.fBm.setText(this.fGy);
                }
                onChangeSkinType();
                aVP();
                saveLastShowTime();
            }
        }
    }

    public void boP() {
        if (this.fqJ != null) {
            this.fqJ.bjN().sG(49);
        }
    }

    private void onChangeSkinType() {
        al.k(this.fGu, R.drawable.bg_frs_hot_live_tip_selector);
        al.j(this.fBm, R.color.cp_btn_a);
        al.c(this.fGv, (int) R.drawable.icon_home_card_close_white);
        this.fBm.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(R.drawable.icon_arrow_more_white), (Drawable) null);
    }

    private void initView(Context context) {
        if (context != null && this.fGu == null) {
            this.fGu = (FrameLayout) LayoutInflater.from(context).inflate(R.layout.frs_hot_live_tip, (ViewGroup) null);
            this.fGu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.live.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.boQ();
                }
            });
            this.fBm = (TextView) this.fGu.findViewById(R.id.frs_hot_live_tip_content);
            this.fGv = (ImageView) this.fGu.findViewById(R.id.frs_hot_live_tip_close);
            this.fGv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.live.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.pk();
                }
            });
            onChangeSkinType();
        }
    }

    private void aVP() {
        k bjP;
        FrameLayout frameLayout;
        if (this.fqJ != null && (bjP = this.fqJ.bjP()) != null && bjP.getListView() != null && (frameLayout = (FrameLayout) bjP.ble()) != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, l.g(TbadkCoreApplication.getInst(), R.dimen.ds56));
            if (this.dqp == null) {
                this.dqp = new aq();
            }
            if (this.fGx == 2) {
                this.dqp.a(this.fGu, frameLayout, layoutParams, UIMsg.m_AppUI.MSG_APP_GPS);
            } else if (this.fGx == 1) {
                this.dqp.a(this.fGu, frameLayout, layoutParams);
                TiebaStatic.log(new am("c12539"));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void boQ() {
        boT();
        if (this.fGz != null && this.fqJ != null && this.fqJ.isAdded()) {
            boolean equals = TextUtils.equals(getUserId(), String.valueOf(this.fGz.userID));
            String str = "";
            if (this.fGx == 1) {
                str = AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_FRS_FOLLOWED_LIVE_TIP;
                TiebaStatic.log(new am("c12540"));
                if (this.dqp != null) {
                    this.dqp.hideTip();
                }
            } else if (this.fGx == 2) {
                str = AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_FRS_HOT_LIVE_TIP;
                TiebaStatic.log(new am("c12331"));
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(this.fqJ.getPageContext().getPageActivity(), this.fGz, this.fGA, str, getUserId(), equals, null, null)));
            if (this.fqJ.bkm().getForum().isGameForumType()) {
                CustomMessage customMessage = new CustomMessage(2001622);
                customMessage.setTag(this.fqJ.getBaseFragmentActivity().getUniqueId());
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2001622);
                customResponsedMessage.setOrginalMessage(customMessage);
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                return;
            }
            e.iB().post(new Runnable() { // from class: com.baidu.tieba.frs.live.a.5
                @Override // java.lang.Runnable
                public void run() {
                    a.this.boP();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pk() {
        if (this.fGx == 2) {
            boR();
        }
        if (this.dqp != null) {
            this.dqp.hideTip();
        }
    }

    private void boR() {
        this.fGw++;
        com.baidu.tbadk.core.sharedPref.b.agM().putInt("FRS_HOT_LIVE_TIP_CLOSE_NUM" + getUserId(), this.fGw);
    }

    private int boS() {
        return com.baidu.tbadk.core.sharedPref.b.agM().getInt("FRS_HOT_LIVE_TIP_CLOSE_NUM" + getUserId(), 0);
    }

    private void boT() {
        this.fGw = 0;
        com.baidu.tbadk.core.sharedPref.b.agM().putInt("FRS_HOT_LIVE_TIP_CLOSE_NUM" + getUserId(), this.fGw);
    }

    private void saveLastShowTime() {
        com.baidu.tbadk.core.sharedPref.b.agM().putLong("FRS_HOT_LIVE_TIP_LAST_SHOWTIME" + getUserId(), System.currentTimeMillis());
    }

    private long getLastShowTime() {
        return com.baidu.tbadk.core.sharedPref.b.agM().getLong("FRS_HOT_LIVE_TIP_LAST_SHOWTIME" + getUserId(), 0L);
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
        if (this.dqp != null) {
            this.dqp.blS();
        }
        e.iB().removeCallbacks(this.fGD);
        if (this.fGB != null) {
            this.fGB.onDestory();
        }
    }
}
