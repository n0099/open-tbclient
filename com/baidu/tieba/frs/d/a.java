package com.baidu.tieba.frs.d;

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
import com.baidu.adp.lib.g.e;
import com.baidu.adp.lib.util.k;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.ar;
import com.baidu.tieba.frs.entelechy.b.d;
import com.baidu.tieba.frs.f;
import com.baidu.tieba.frs.i;
import java.lang.ref.WeakReference;
import tbclient.AlaLiveNotify;
/* loaded from: classes.dex */
public class a {
    private ar beO;
    private FrameLayout cCJ;
    private TextView cCK;
    private ImageView cCL;
    private AlaLiveNotify cCM;
    private WeakReference<f> cCO;
    private boolean isFirst = true;
    private Runnable bTb = new Runnable() { // from class: com.baidu.tieba.frs.d.a.1
        @Override // java.lang.Runnable
        public void run() {
            a.this.onChangeSkinType();
            a.this.NR();
            a.this.aky();
        }
    };
    private int cCN = akw();

    public void a(f fVar, AlaLiveNotify alaLiveNotify) {
        if (fVar != null && alaLiveNotify != null && fVar.isAdded()) {
            this.cCO = new WeakReference<>(fVar);
            if (!TextUtils.isEmpty(alaLiveNotify.noti_content) && !TextUtils.isEmpty(alaLiveNotify.noti_url)) {
                this.cCM = alaLiveNotify;
                if (akw() < 3) {
                    if (System.currentTimeMillis() - akz() >= 7200000) {
                        if (fVar.agW() && isFirst()) {
                            this.isFirst = false;
                            return;
                        }
                        br(fVar.getPageContext().getPageActivity());
                        if (this.cCK != null) {
                            this.cCK.setText(alaLiveNotify.noti_content);
                        }
                        e.fQ().removeCallbacks(this.bTb);
                        e.fQ().postDelayed(this.bTb, TbConfig.NOTIFY_SOUND_INTERVAL);
                    }
                }
            }
        }
    }

    public void aks() {
        f fVar;
        if (this.cCO != null && (fVar = this.cCO.get()) != null) {
            d agL = fVar.agL();
            if ((agL instanceof com.baidu.tieba.frs.entelechy.c.a) && ((com.baidu.tieba.frs.entelechy.c.a) agL).aji() != null) {
                ((com.baidu.tieba.frs.entelechy.c.a) agL).aji().jL(49);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onChangeSkinType() {
        aj.j(this.cCJ, d.g.bg_frs_hot_live_tip_selector);
        aj.i(this.cCK, d.e.cp_cont_i);
        aj.c(this.cCL, d.g.icon_home_card_close_white);
        this.cCK.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, aj.getDrawable(d.g.icon_arrow_more_white), (Drawable) null);
    }

    private void br(Context context) {
        if (context != null && this.cCJ == null) {
            this.cCJ = (FrameLayout) LayoutInflater.from(context).inflate(d.j.frs_hot_live_tip, (ViewGroup) null);
            this.cCJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.d.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.akt();
                }
            });
            this.cCK = (TextView) this.cCJ.findViewById(d.h.frs_hot_live_tip_content);
            this.cCL = (ImageView) this.cCJ.findViewById(d.h.frs_hot_live_tip_close);
            this.cCL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.d.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.aku();
                }
            });
            onChangeSkinType();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void NR() {
        f fVar;
        if (this.cCO != null && (fVar = this.cCO.get()) != null) {
            com.baidu.tieba.frs.entelechy.b.d agL = fVar.agL();
            i agN = fVar.agN();
            if (agN != null && agL != null && agL.ajd() != null && (agN.Xn() instanceof NoPressedRelativeLayout)) {
                View ajd = agL.ajd();
                BdTypeListView listView = agN.getListView();
                if (ajd != null && listView != null) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, k.g(TbadkCoreApplication.getInst(), d.f.ds56));
                    layoutParams.addRule(6, d.h.frs_list_content);
                    if (agN.ahn() != null && agN.ahn().getLayoutParams() != null) {
                        layoutParams.topMargin = agN.ahn().getLayoutParams().height;
                    } else {
                        layoutParams.topMargin = 0;
                    }
                    if (this.beO == null) {
                        this.beO = new ar();
                    }
                    this.beO.a(this.cCJ, (NoPressedRelativeLayout) agN.Xn(), layoutParams, 5000);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akt() {
        f fVar;
        akx();
        if (this.cCO != null && this.cCM != null && this.cCM.noti_url != null && (fVar = this.cCO.get()) != null && fVar.isAdded()) {
            TiebaStatic.log(new ak("c12331"));
            if (au.wd().c(fVar.getPageContext(), new String[]{this.cCM.noti_url + "&from=frs_hot_live_tip"})) {
                e.fQ().post(new Runnable() { // from class: com.baidu.tieba.frs.d.a.4
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.aks();
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aku() {
        akv();
        if (this.beO != null) {
            this.beO.hideTip();
        }
    }

    private void akv() {
        this.cCN++;
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("FRS_HOT_LIVE_TIP_CLOSE_NUM" + getUserId(), this.cCN);
    }

    private int akw() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("FRS_HOT_LIVE_TIP_CLOSE_NUM" + getUserId(), 0);
    }

    private void akx() {
        this.cCN = 0;
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("FRS_HOT_LIVE_TIP_CLOSE_NUM" + getUserId(), this.cCN);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aky() {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("FRS_HOT_LIVE_TIP_LAST_SHOWTIME" + getUserId(), System.currentTimeMillis());
    }

    private long akz() {
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
}
