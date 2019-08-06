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
    private aq dsF;
    private TextView fGY;
    private FrameLayout fMi;
    private ImageView fMj;
    private int fMl;
    private String fMm;
    private AlaLiveInfoCoreData fMn;
    private AlaLiveInfoListCoreData fMo;
    private c fMp;
    private FrsFragment fwg;
    private int mForumId;
    private boolean isFirst = true;
    private c.a fMq = new c.a() { // from class: com.baidu.tieba.frs.live.a.1
        @Override // com.baidu.tieba.frs.live.c.a
        public void a(FrsLiveTipResponseMessage frsLiveTipResponseMessage) {
            if (frsLiveTipResponseMessage != null) {
                a.this.fMl = frsLiveTipResponseMessage.remindType;
                a.this.fMm = frsLiveTipResponseMessage.remindText;
                a.this.fMn = frsLiveTipResponseMessage.infoCoreData;
                a.this.fMo = frsLiveTipResponseMessage.listCoreData;
                if (a.this.dsF != null) {
                    a.this.dsF.bod();
                }
                if (a.this.fMl != 0) {
                    a.this.bre();
                }
            }
        }
    };
    private Runnable fMr = new Runnable() { // from class: com.baidu.tieba.frs.live.a.2
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.fMp != null) {
                a.this.fMp.sy(a.this.mForumId);
            }
        }
    };
    private int fMk = bri();

    public a(FrsFragment frsFragment, int i) {
        this.fwg = frsFragment;
        this.mForumId = i;
    }

    public void brd() {
        if (this.fwg != null && this.fwg.isAdded()) {
            if (System.currentTimeMillis() - getLastShowTime() >= 1800000) {
                if (this.fwg.bmn() && isFirst()) {
                    this.isFirst = false;
                    return;
                }
                if (this.fMp == null) {
                    this.fMp = new c(this.fMq);
                }
                e.iK().removeCallbacks(this.fMr);
                e.iK().postDelayed(this.fMr, 5000L);
            }
        }
    }

    public void bre() {
        if (!StringUtils.isNull(this.fMm) && this.fMn != null) {
            if (this.fMl != 2 || bri() < 3) {
                initView(this.fwg.getPageContext().getPageActivity());
                if (this.fGY != null) {
                    this.fGY.setText(this.fMm);
                }
                onChangeSkinType();
                aXN();
                saveLastShowTime();
            }
        }
    }

    public void brf() {
        if (this.fwg != null) {
            this.fwg.blW().ta(49);
        }
    }

    private void onChangeSkinType() {
        am.k(this.fMi, R.drawable.bg_frs_hot_live_tip_selector);
        am.j(this.fGY, R.color.cp_btn_a);
        am.c(this.fMj, (int) R.drawable.icon_home_card_close_white);
        this.fGY.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(R.drawable.icon_arrow_more_white), (Drawable) null);
    }

    private void initView(Context context) {
        if (context != null && this.fMi == null) {
            this.fMi = (FrameLayout) LayoutInflater.from(context).inflate(R.layout.frs_hot_live_tip, (ViewGroup) null);
            this.fMi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.live.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.brg();
                }
            });
            this.fGY = (TextView) this.fMi.findViewById(R.id.frs_hot_live_tip_content);
            this.fMj = (ImageView) this.fMi.findViewById(R.id.frs_hot_live_tip_close);
            this.fMj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.live.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.pF();
                }
            });
            onChangeSkinType();
        }
    }

    private void aXN() {
        k blY;
        FrameLayout frameLayout;
        if (this.fwg != null && (blY = this.fwg.blY()) != null && blY.getListView() != null && (frameLayout = (FrameLayout) blY.bnp()) != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, l.g(TbadkCoreApplication.getInst(), R.dimen.ds56));
            if (this.dsF == null) {
                this.dsF = new aq();
            }
            if (this.fMl == 2) {
                this.dsF.a(this.fMi, frameLayout, layoutParams, UIMsg.m_AppUI.MSG_APP_GPS);
            } else if (this.fMl == 1) {
                this.dsF.a(this.fMi, frameLayout, layoutParams);
                TiebaStatic.log(new an("c12539"));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void brg() {
        brj();
        if (this.fMn != null && this.fwg != null && this.fwg.isAdded()) {
            boolean equals = TextUtils.equals(getUserId(), String.valueOf(this.fMn.userID));
            String str = "";
            if (this.fMl == 1) {
                str = AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_FRS_FOLLOWED_LIVE_TIP;
                TiebaStatic.log(new an("c12540"));
                if (this.dsF != null) {
                    this.dsF.hideTip();
                }
            } else if (this.fMl == 2) {
                str = AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_FRS_HOT_LIVE_TIP;
                TiebaStatic.log(new an("c12331"));
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(this.fwg.getPageContext().getPageActivity(), this.fMn, this.fMo, str, getUserId(), equals, null, null)));
            if (this.fwg.bmy().getForum().isGameForumType()) {
                CustomMessage customMessage = new CustomMessage(2001622);
                customMessage.setTag(this.fwg.getBaseFragmentActivity().getUniqueId());
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2001622);
                customResponsedMessage.setOrginalMessage(customMessage);
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                return;
            }
            e.iK().post(new Runnable() { // from class: com.baidu.tieba.frs.live.a.5
                @Override // java.lang.Runnable
                public void run() {
                    a.this.brf();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pF() {
        if (this.fMl == 2) {
            brh();
        }
        if (this.dsF != null) {
            this.dsF.hideTip();
        }
    }

    private void brh() {
        this.fMk++;
        com.baidu.tbadk.core.sharedPref.b.ahQ().putInt("FRS_HOT_LIVE_TIP_CLOSE_NUM" + getUserId(), this.fMk);
    }

    private int bri() {
        return com.baidu.tbadk.core.sharedPref.b.ahQ().getInt("FRS_HOT_LIVE_TIP_CLOSE_NUM" + getUserId(), 0);
    }

    private void brj() {
        this.fMk = 0;
        com.baidu.tbadk.core.sharedPref.b.ahQ().putInt("FRS_HOT_LIVE_TIP_CLOSE_NUM" + getUserId(), this.fMk);
    }

    private void saveLastShowTime() {
        com.baidu.tbadk.core.sharedPref.b.ahQ().putLong("FRS_HOT_LIVE_TIP_LAST_SHOWTIME" + getUserId(), System.currentTimeMillis());
    }

    private long getLastShowTime() {
        return com.baidu.tbadk.core.sharedPref.b.ahQ().getLong("FRS_HOT_LIVE_TIP_LAST_SHOWTIME" + getUserId(), 0L);
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
        if (this.dsF != null) {
            this.dsF.bod();
        }
        e.iK().removeCallbacks(this.fMr);
        if (this.fMp != null) {
            this.fMp.onDestory();
        }
    }
}
