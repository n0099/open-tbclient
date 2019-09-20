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
    private aq duq;
    private TextView fIN;
    private FrameLayout fNX;
    private ImageView fNY;
    private int fOa;
    private String fOb;
    private AlaLiveInfoCoreData fOc;
    private AlaLiveInfoListCoreData fOd;
    private c fOe;
    private FrsFragment fxT;
    private int mForumId;
    private boolean isFirst = true;
    private c.a fOf = new c.a() { // from class: com.baidu.tieba.frs.live.a.1
        @Override // com.baidu.tieba.frs.live.c.a
        public void a(FrsLiveTipResponseMessage frsLiveTipResponseMessage) {
            if (frsLiveTipResponseMessage != null) {
                a.this.fOa = frsLiveTipResponseMessage.remindType;
                a.this.fOb = frsLiveTipResponseMessage.remindText;
                a.this.fOc = frsLiveTipResponseMessage.infoCoreData;
                a.this.fOd = frsLiveTipResponseMessage.listCoreData;
                if (a.this.duq != null) {
                    a.this.duq.boO();
                }
                if (a.this.fOa != 0) {
                    a.this.brP();
                }
            }
        }
    };
    private Runnable fOg = new Runnable() { // from class: com.baidu.tieba.frs.live.a.2
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.fOe != null) {
                a.this.fOe.sC(a.this.mForumId);
            }
        }
    };
    private int fNZ = brT();

    public a(FrsFragment frsFragment, int i) {
        this.fxT = frsFragment;
        this.mForumId = i;
    }

    public void brO() {
        if (this.fxT != null && this.fxT.isAdded()) {
            if (System.currentTimeMillis() - getLastShowTime() >= 1800000) {
                if (this.fxT.bmY() && isFirst()) {
                    this.isFirst = false;
                    return;
                }
                if (this.fOe == null) {
                    this.fOe = new c(this.fOf);
                }
                e.iK().removeCallbacks(this.fOg);
                e.iK().postDelayed(this.fOg, 5000L);
            }
        }
    }

    public void brP() {
        if (!StringUtils.isNull(this.fOb) && this.fOc != null) {
            if (this.fOa != 2 || brT() < 3) {
                initView(this.fxT.getPageContext().getPageActivity());
                if (this.fIN != null) {
                    this.fIN.setText(this.fOb);
                }
                onChangeSkinType();
                aYr();
                saveLastShowTime();
            }
        }
    }

    public void brQ() {
        if (this.fxT != null) {
            this.fxT.bmH().te(49);
        }
    }

    private void onChangeSkinType() {
        am.k(this.fNX, R.drawable.bg_frs_hot_live_tip_selector);
        am.j(this.fIN, R.color.cp_cont_a);
        am.c(this.fNY, (int) R.drawable.icon_home_card_close_white);
        this.fIN.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(R.drawable.icon_arrow_more_white), (Drawable) null);
    }

    private void initView(Context context) {
        if (context != null && this.fNX == null) {
            this.fNX = (FrameLayout) LayoutInflater.from(context).inflate(R.layout.frs_hot_live_tip, (ViewGroup) null);
            this.fNX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.live.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.brR();
                }
            });
            this.fIN = (TextView) this.fNX.findViewById(R.id.frs_hot_live_tip_content);
            this.fNY = (ImageView) this.fNX.findViewById(R.id.frs_hot_live_tip_close);
            this.fNY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.live.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.pG();
                }
            });
            onChangeSkinType();
        }
    }

    private void aYr() {
        k bmJ;
        FrameLayout frameLayout;
        if (this.fxT != null && (bmJ = this.fxT.bmJ()) != null && bmJ.getListView() != null && (frameLayout = (FrameLayout) bmJ.boa()) != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, l.g(TbadkCoreApplication.getInst(), R.dimen.ds56));
            if (this.duq == null) {
                this.duq = new aq();
            }
            if (this.fOa == 2) {
                this.duq.a(this.fNX, frameLayout, layoutParams, 5000);
            } else if (this.fOa == 1) {
                this.duq.a(this.fNX, frameLayout, layoutParams);
                TiebaStatic.log(new an("c12539"));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void brR() {
        brU();
        if (this.fOc != null && this.fxT != null && this.fxT.isAdded()) {
            boolean equals = TextUtils.equals(getUserId(), String.valueOf(this.fOc.userID));
            String str = "";
            if (this.fOa == 1) {
                str = AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_FRS_FOLLOWED_LIVE_TIP;
                TiebaStatic.log(new an("c12540"));
                if (this.duq != null) {
                    this.duq.hideTip();
                }
            } else if (this.fOa == 2) {
                str = AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_FRS_HOT_LIVE_TIP;
                TiebaStatic.log(new an("c12331"));
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(this.fxT.getPageContext().getPageActivity(), this.fOc, this.fOd, str, getUserId(), equals, null, null)));
            if (this.fxT.bnj().getForum().isGameForumType()) {
                CustomMessage customMessage = new CustomMessage(2001622);
                customMessage.setTag(this.fxT.getBaseFragmentActivity().getUniqueId());
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2001622);
                customResponsedMessage.setOrginalMessage(customMessage);
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                return;
            }
            e.iK().post(new Runnable() { // from class: com.baidu.tieba.frs.live.a.5
                @Override // java.lang.Runnable
                public void run() {
                    a.this.brQ();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pG() {
        if (this.fOa == 2) {
            brS();
        }
        if (this.duq != null) {
            this.duq.hideTip();
        }
    }

    private void brS() {
        this.fNZ++;
        com.baidu.tbadk.core.sharedPref.b.ahU().putInt("FRS_HOT_LIVE_TIP_CLOSE_NUM" + getUserId(), this.fNZ);
    }

    private int brT() {
        return com.baidu.tbadk.core.sharedPref.b.ahU().getInt("FRS_HOT_LIVE_TIP_CLOSE_NUM" + getUserId(), 0);
    }

    private void brU() {
        this.fNZ = 0;
        com.baidu.tbadk.core.sharedPref.b.ahU().putInt("FRS_HOT_LIVE_TIP_CLOSE_NUM" + getUserId(), this.fNZ);
    }

    private void saveLastShowTime() {
        com.baidu.tbadk.core.sharedPref.b.ahU().putLong("FRS_HOT_LIVE_TIP_LAST_SHOWTIME" + getUserId(), System.currentTimeMillis());
    }

    private long getLastShowTime() {
        return com.baidu.tbadk.core.sharedPref.b.ahU().getLong("FRS_HOT_LIVE_TIP_LAST_SHOWTIME" + getUserId(), 0L);
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
        if (this.duq != null) {
            this.duq.boO();
        }
        e.iK().removeCallbacks(this.fOg);
        if (this.fOe != null) {
            this.fOe.onDestory();
        }
    }
}
