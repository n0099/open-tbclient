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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.aq;
import com.baidu.tieba.frs.k;
import com.baidu.tieba.frs.live.c;
/* loaded from: classes4.dex */
public class a {
    private aq dsy;
    private TextView fGk;
    private AlaLiveInfoListCoreData fLA;
    private c fLB;
    private FrameLayout fLu;
    private ImageView fLv;
    private int fLx;
    private String fLy;
    private AlaLiveInfoCoreData fLz;
    private FrsFragment fvH;
    private int mForumId;
    private boolean isFirst = true;
    private c.a fLC = new c.a() { // from class: com.baidu.tieba.frs.live.a.1
        @Override // com.baidu.tieba.frs.live.c.a
        public void a(FrsLiveTipResponseMessage frsLiveTipResponseMessage) {
            if (frsLiveTipResponseMessage != null) {
                a.this.fLx = frsLiveTipResponseMessage.remindType;
                a.this.fLy = frsLiveTipResponseMessage.remindText;
                a.this.fLz = frsLiveTipResponseMessage.infoCoreData;
                a.this.fLA = frsLiveTipResponseMessage.listCoreData;
                if (a.this.dsy != null) {
                    a.this.dsy.bnT();
                }
                if (a.this.fLx != 0) {
                    a.this.bqR();
                }
            }
        }
    };
    private Runnable fLD = new Runnable() { // from class: com.baidu.tieba.frs.live.a.2
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.fLB != null) {
                a.this.fLB.sw(a.this.mForumId);
            }
        }
    };
    private int fLw = bqV();

    public a(FrsFragment frsFragment, int i) {
        this.fvH = frsFragment;
        this.mForumId = i;
    }

    public void bqQ() {
        if (this.fvH != null && this.fvH.isAdded()) {
            if (System.currentTimeMillis() - getLastShowTime() >= 1800000) {
                if (this.fvH.bmd() && isFirst()) {
                    this.isFirst = false;
                    return;
                }
                if (this.fLB == null) {
                    this.fLB = new c(this.fLC);
                }
                e.iK().removeCallbacks(this.fLD);
                e.iK().postDelayed(this.fLD, 5000L);
            }
        }
    }

    public void bqR() {
        if (!StringUtils.isNull(this.fLy) && this.fLz != null) {
            if (this.fLx != 2 || bqV() < 3) {
                initView(this.fvH.getPageContext().getPageActivity());
                if (this.fGk != null) {
                    this.fGk.setText(this.fLy);
                }
                onChangeSkinType();
                aXL();
                saveLastShowTime();
            }
        }
    }

    public void bqS() {
        if (this.fvH != null) {
            this.fvH.blP().sY(49);
        }
    }

    private void onChangeSkinType() {
        am.k(this.fLu, R.drawable.bg_frs_hot_live_tip_selector);
        am.j(this.fGk, R.color.cp_btn_a);
        am.c(this.fLv, (int) R.drawable.icon_home_card_close_white);
        this.fGk.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(R.drawable.icon_arrow_more_white), (Drawable) null);
    }

    private void initView(Context context) {
        if (context != null && this.fLu == null) {
            this.fLu = (FrameLayout) LayoutInflater.from(context).inflate(R.layout.frs_hot_live_tip, (ViewGroup) null);
            this.fLu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.live.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.bqT();
                }
            });
            this.fGk = (TextView) this.fLu.findViewById(R.id.frs_hot_live_tip_content);
            this.fLv = (ImageView) this.fLu.findViewById(R.id.frs_hot_live_tip_close);
            this.fLv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.live.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.pF();
                }
            });
            onChangeSkinType();
        }
    }

    private void aXL() {
        k blR;
        FrameLayout frameLayout;
        if (this.fvH != null && (blR = this.fvH.blR()) != null && blR.getListView() != null && (frameLayout = (FrameLayout) blR.bnf()) != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, l.g(TbadkCoreApplication.getInst(), R.dimen.ds56));
            if (this.dsy == null) {
                this.dsy = new aq();
            }
            if (this.fLx == 2) {
                this.dsy.a(this.fLu, frameLayout, layoutParams, UIMsg.m_AppUI.MSG_APP_GPS);
            } else if (this.fLx == 1) {
                this.dsy.a(this.fLu, frameLayout, layoutParams);
                TiebaStatic.log(new an("c12539"));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqT() {
        bqW();
        if (this.fLz != null && this.fvH != null && this.fvH.isAdded()) {
            boolean equals = TextUtils.equals(getUserId(), String.valueOf(this.fLz.userID));
            String str = "";
            if (this.fLx == 1) {
                str = AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_FRS_FOLLOWED_LIVE_TIP;
                TiebaStatic.log(new an("c12540"));
                if (this.dsy != null) {
                    this.dsy.hideTip();
                }
            } else if (this.fLx == 2) {
                str = AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_FRS_HOT_LIVE_TIP;
                TiebaStatic.log(new an("c12331"));
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(this.fvH.getPageContext().getPageActivity(), this.fLz, this.fLA, str, getUserId(), equals, null, null)));
            if (this.fvH.bmo().getForum().isGameForumType()) {
                CustomMessage customMessage = new CustomMessage(2001622);
                customMessage.setTag(this.fvH.getBaseFragmentActivity().getUniqueId());
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2001622);
                customResponsedMessage.setOrginalMessage(customMessage);
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                return;
            }
            e.iK().post(new Runnable() { // from class: com.baidu.tieba.frs.live.a.5
                @Override // java.lang.Runnable
                public void run() {
                    a.this.bqS();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pF() {
        if (this.fLx == 2) {
            bqU();
        }
        if (this.dsy != null) {
            this.dsy.hideTip();
        }
    }

    private void bqU() {
        this.fLw++;
        com.baidu.tbadk.core.sharedPref.b.ahO().putInt("FRS_HOT_LIVE_TIP_CLOSE_NUM" + getUserId(), this.fLw);
    }

    private int bqV() {
        return com.baidu.tbadk.core.sharedPref.b.ahO().getInt("FRS_HOT_LIVE_TIP_CLOSE_NUM" + getUserId(), 0);
    }

    private void bqW() {
        this.fLw = 0;
        com.baidu.tbadk.core.sharedPref.b.ahO().putInt("FRS_HOT_LIVE_TIP_CLOSE_NUM" + getUserId(), this.fLw);
    }

    private void saveLastShowTime() {
        com.baidu.tbadk.core.sharedPref.b.ahO().putLong("FRS_HOT_LIVE_TIP_LAST_SHOWTIME" + getUserId(), System.currentTimeMillis());
    }

    private long getLastShowTime() {
        return com.baidu.tbadk.core.sharedPref.b.ahO().getLong("FRS_HOT_LIVE_TIP_LAST_SHOWTIME" + getUserId(), 0L);
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
        if (this.dsy != null) {
            this.dsy.bnT();
        }
        e.iK().removeCallbacks(this.fLD);
        if (this.fLB != null) {
            this.fLB.onDestory();
        }
    }
}
