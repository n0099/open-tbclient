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
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.ala.AlaLiveInfoListCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.as;
import com.baidu.tieba.frs.k;
import com.baidu.tieba.frs.live.c;
/* loaded from: classes2.dex */
public class a {
    private as bwJ;
    private FrameLayout dCR;
    private ImageView dCS;
    private int dCU;
    private String dCV;
    private AlaLiveInfoCoreData dCW;
    private AlaLiveInfoListCoreData dCX;
    private c dCY;
    private FrsFragment dnR;
    private TextView dxR;
    private int mForumId;
    private boolean isFirst = true;
    private c.a dCZ = new c.a() { // from class: com.baidu.tieba.frs.live.a.1
        @Override // com.baidu.tieba.frs.live.c.a
        public void a(FrsLiveTipResponseMessage frsLiveTipResponseMessage) {
            if (frsLiveTipResponseMessage != null) {
                a.this.dCU = frsLiveTipResponseMessage.remindType;
                a.this.dCV = frsLiveTipResponseMessage.remindText;
                a.this.dCW = frsLiveTipResponseMessage.infoCoreData;
                a.this.dCX = frsLiveTipResponseMessage.listCoreData;
                if (a.this.bwJ != null) {
                    a.this.bwJ.avS();
                }
                if (a.this.dCU != 0) {
                    a.this.azo();
                }
            }
        }
    };
    private Runnable dDa = new Runnable() { // from class: com.baidu.tieba.frs.live.a.2
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.dCY != null) {
                a.this.dCY.lr(a.this.mForumId);
            }
        }
    };
    private int dCT = azt();

    public a(FrsFragment frsFragment, int i) {
        this.dnR = frsFragment;
        this.mForumId = i;
    }

    public void azn() {
        if (this.dnR != null && this.dnR.isAdded()) {
            if (System.currentTimeMillis() - getLastShowTime() >= 1800000) {
                if (this.dnR.auv() && isFirst()) {
                    this.isFirst = false;
                    return;
                }
                if (this.dCY == null) {
                    this.dCY = new c(this.dCZ);
                }
                e.in().removeCallbacks(this.dDa);
                e.in().postDelayed(this.dDa, TbConfig.NOTIFY_SOUND_INTERVAL);
            }
        }
    }

    public void azo() {
        if (!StringUtils.isNull(this.dCV) && this.dCW != null) {
            if (this.dCU != 2 || azt() < 3) {
                aX(this.dnR.getPageContext().getPageActivity());
                if (this.dxR != null) {
                    this.dxR.setText(this.dCV);
                }
                onChangeSkinType();
                ahq();
                saveLastShowTime();
            }
        }
    }

    public void azp() {
        if (this.dnR != null) {
            this.dnR.auk().lQ(49);
        }
    }

    private void onChangeSkinType() {
        am.i(this.dCR, d.f.bg_frs_hot_live_tip_selector);
        am.h(this.dxR, d.C0140d.cp_cont_i);
        am.c(this.dCS, d.f.icon_home_card_close_white);
        this.dxR.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(d.f.icon_arrow_more_white), (Drawable) null);
    }

    private void aX(Context context) {
        if (context != null && this.dCR == null) {
            this.dCR = (FrameLayout) LayoutInflater.from(context).inflate(d.h.frs_hot_live_tip, (ViewGroup) null);
            this.dCR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.live.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.azq();
                }
            });
            this.dxR = (TextView) this.dCR.findViewById(d.g.frs_hot_live_tip_content);
            this.dCS = (ImageView) this.dCR.findViewById(d.g.frs_hot_live_tip_close);
            this.dCS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.live.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.azr();
                }
            });
            onChangeSkinType();
        }
    }

    private void ahq() {
        k aum;
        FrameLayout frameLayout;
        if (this.dnR != null && (aum = this.dnR.aum()) != null && aum.getListView() != null && (frameLayout = (FrameLayout) aum.avv()) != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, l.f(TbadkCoreApplication.getInst(), d.e.ds56));
            if (aum.avb() != null && aum.avb().getLayoutParams() != null) {
                layoutParams.topMargin = aum.avb().getLayoutParams().height;
            } else {
                layoutParams.topMargin = 0;
            }
            if (this.bwJ == null) {
                this.bwJ = new as();
            }
            if (this.dCU == 2) {
                this.bwJ.a(this.dCR, frameLayout, layoutParams, 5000);
            } else if (this.dCU == 1) {
                this.bwJ.a(this.dCR, frameLayout, layoutParams);
                TiebaStatic.log(new an("c12539"));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void azq() {
        azu();
        if (this.dCW != null && this.dnR != null && this.dnR.isAdded()) {
            boolean equals = TextUtils.equals(getUserId(), String.valueOf(this.dCW.userID));
            String str = "";
            if (this.dCU == 1) {
                str = AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_FRS_FOLLOWED_LIVE_TIP;
                TiebaStatic.log(new an("c12540"));
                if (this.bwJ != null) {
                    this.bwJ.hideTip();
                }
            } else if (this.dCU == 2) {
                str = AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_FRS_HOT_LIVE_TIP;
                TiebaStatic.log(new an("c12331"));
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(this.dnR.getPageContext().getPageActivity(), this.dCW, this.dCX, str, getUserId(), equals, null, null)));
            if (this.dnR.auD().aZl().isGameForumType()) {
                CustomMessage customMessage = new CustomMessage(2001622);
                customMessage.setTag(this.dnR.getBaseFragmentActivity().getUniqueId());
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2001622);
                customResponsedMessage.setOrginalMessage(customMessage);
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                return;
            }
            e.in().post(new Runnable() { // from class: com.baidu.tieba.frs.live.a.5
                @Override // java.lang.Runnable
                public void run() {
                    a.this.azp();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void azr() {
        if (this.dCU == 2) {
            azs();
        }
        if (this.bwJ != null) {
            this.bwJ.hideTip();
        }
    }

    private void azs() {
        this.dCT++;
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("FRS_HOT_LIVE_TIP_CLOSE_NUM" + getUserId(), this.dCT);
    }

    private int azt() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("FRS_HOT_LIVE_TIP_CLOSE_NUM" + getUserId(), 0);
    }

    private void azu() {
        this.dCT = 0;
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("FRS_HOT_LIVE_TIP_CLOSE_NUM" + getUserId(), this.dCT);
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
        if (this.bwJ != null) {
            this.bwJ.avS();
        }
        e.in().removeCallbacks(this.dDa);
        if (this.dCY != null) {
            this.dCY.onDestory();
        }
    }
}
