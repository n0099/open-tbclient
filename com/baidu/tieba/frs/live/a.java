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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.au;
import com.baidu.tieba.frs.i;
import com.baidu.tieba.frs.k;
import com.baidu.tieba.frs.live.c;
/* loaded from: classes2.dex */
public class a {
    private au cck;
    private i dFD;
    private TextView dOR;
    private FrameLayout dSg;
    private ImageView dSh;
    private int dSj;
    private String dSk;
    private AlaLiveInfoCoreData dSl;
    private AlaLiveInfoListCoreData dSm;
    private c dSn;
    private int mForumId;
    private boolean isFirst = true;
    private c.a dSo = new c.a() { // from class: com.baidu.tieba.frs.live.a.1
        @Override // com.baidu.tieba.frs.live.c.a
        public void a(FrsLiveTipResponseMessage frsLiveTipResponseMessage) {
            if (frsLiveTipResponseMessage != null) {
                a.this.dSj = frsLiveTipResponseMessage.remindType;
                a.this.dSk = frsLiveTipResponseMessage.remindText;
                a.this.dSl = frsLiveTipResponseMessage.infoCoreData;
                a.this.dSm = frsLiveTipResponseMessage.listCoreData;
                if (a.this.cck != null) {
                    a.this.cck.awu();
                }
                if (a.this.dSj != 0) {
                    a.this.aza();
                }
            }
        }
    };
    private Runnable dSp = new Runnable() { // from class: com.baidu.tieba.frs.live.a.2
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.dSn != null) {
                a.this.dSn.nF(a.this.mForumId);
            }
        }
    };
    private int dSi = azf();

    public a(i iVar, int i) {
        this.dFD = iVar;
        this.mForumId = i;
    }

    public void ayZ() {
        if (this.dFD != null && this.dFD.isAdded()) {
            if (System.currentTimeMillis() - getLastShowTime() >= 1800000) {
                if (this.dFD.avb() && isFirst()) {
                    this.isFirst = false;
                    return;
                }
                if (this.dSn == null) {
                    this.dSn = new c(this.dSo);
                }
                e.ns().removeCallbacks(this.dSp);
                e.ns().postDelayed(this.dSp, TbConfig.NOTIFY_SOUND_INTERVAL);
            }
        }
    }

    public void aza() {
        if (!StringUtils.isNull(this.dSk) && this.dSl != null) {
            if (this.dSj != 2 || azf() < 3) {
                bx(this.dFD.getPageContext().getPageActivity());
                if (this.dOR != null) {
                    this.dOR.setText(this.dSk);
                }
                onChangeSkinType();
                Yd();
                saveLastShowTime();
            }
        }
    }

    public void azb() {
        if (this.dFD != null) {
            this.dFD.auQ().nT(49);
        }
    }

    private void onChangeSkinType() {
        aj.s(this.dSg, d.f.bg_frs_hot_live_tip_selector);
        aj.r(this.dOR, d.C0141d.cp_cont_i);
        aj.c(this.dSh, d.f.icon_home_card_close_white);
        this.dOR.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, aj.getDrawable(d.f.icon_arrow_more_white), (Drawable) null);
    }

    private void bx(Context context) {
        if (context != null && this.dSg == null) {
            this.dSg = (FrameLayout) LayoutInflater.from(context).inflate(d.h.frs_hot_live_tip, (ViewGroup) null);
            this.dSg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.live.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.azc();
                }
            });
            this.dOR = (TextView) this.dSg.findViewById(d.g.frs_hot_live_tip_content);
            this.dSh = (ImageView) this.dSg.findViewById(d.g.frs_hot_live_tip_close);
            this.dSh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.live.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.azd();
                }
            });
            onChangeSkinType();
        }
    }

    private void Yd() {
        k auS;
        FrameLayout frameLayout;
        if (this.dFD != null && (auS = this.dFD.auS()) != null && auS.getListView() != null && (frameLayout = (FrameLayout) auS.avW()) != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, l.t(TbadkCoreApplication.getInst(), d.e.ds56));
            if (auS.avC() != null && auS.avC().getLayoutParams() != null) {
                layoutParams.topMargin = auS.avC().getLayoutParams().height;
            } else {
                layoutParams.topMargin = 0;
            }
            if (this.cck == null) {
                this.cck = new au();
            }
            if (this.dSj == 2) {
                this.cck.a(this.dSg, frameLayout, layoutParams, 5000);
            } else if (this.dSj == 1) {
                this.cck.a(this.dSg, frameLayout, layoutParams);
                TiebaStatic.log(new ak("c12539"));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void azc() {
        azg();
        if (this.dSl != null && this.dFD != null && this.dFD.isAdded()) {
            boolean equals = TextUtils.equals(getUserId(), String.valueOf(this.dSl.userID));
            String str = "";
            if (this.dSj == 1) {
                str = AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_FRS_FOLLOWED_LIVE_TIP;
                TiebaStatic.log(new ak("c12540"));
                if (this.cck != null) {
                    this.cck.hideTip();
                }
            } else if (this.dSj == 2) {
                str = AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_FRS_HOT_LIVE_TIP;
                TiebaStatic.log(new ak("c12331"));
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(this.dFD.getPageContext().getPageActivity(), this.dSl, this.dSm, str, getUserId(), equals, null, null)));
            if (this.dFD.avk().bar().isGameForumType()) {
                CustomMessage customMessage = new CustomMessage(2001622);
                customMessage.setTag(this.dFD.getBaseFragmentActivity().getUniqueId());
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2001622);
                customResponsedMessage.setOrginalMessage(customMessage);
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                return;
            }
            e.ns().post(new Runnable() { // from class: com.baidu.tieba.frs.live.a.5
                @Override // java.lang.Runnable
                public void run() {
                    a.this.azb();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void azd() {
        if (this.dSj == 2) {
            aze();
        }
        if (this.cck != null) {
            this.cck.hideTip();
        }
    }

    private void aze() {
        this.dSi++;
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("FRS_HOT_LIVE_TIP_CLOSE_NUM" + getUserId(), this.dSi);
    }

    private int azf() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("FRS_HOT_LIVE_TIP_CLOSE_NUM" + getUserId(), 0);
    }

    private void azg() {
        this.dSi = 0;
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("FRS_HOT_LIVE_TIP_CLOSE_NUM" + getUserId(), this.dSi);
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
        if (this.cck != null) {
            this.cck.awu();
        }
        e.ns().removeCallbacks(this.dSp);
        if (this.dSn != null) {
            this.dSn.onDestory();
        }
    }
}
