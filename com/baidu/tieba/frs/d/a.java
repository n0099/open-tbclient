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
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.as;
import com.baidu.tieba.frs.entelechy.b.d;
import com.baidu.tieba.frs.f;
import com.baidu.tieba.frs.i;
import java.lang.ref.WeakReference;
import tbclient.AlaLiveNotify;
/* loaded from: classes.dex */
public class a {
    private as bgk;
    private FrameLayout cEi;
    private TextView cEj;
    private ImageView cEk;
    private AlaLiveNotify cEl;
    private WeakReference<f> cEn;
    private boolean isFirst = true;
    private Runnable bTs = new Runnable() { // from class: com.baidu.tieba.frs.d.a.1
        @Override // java.lang.Runnable
        public void run() {
            a.this.onChangeSkinType();
            a.this.Oh();
            a.this.akI();
        }
    };
    private int cEm = akG();

    public void a(f fVar, AlaLiveNotify alaLiveNotify) {
        if (fVar != null && alaLiveNotify != null && fVar.isAdded()) {
            this.cEn = new WeakReference<>(fVar);
            if (!TextUtils.isEmpty(alaLiveNotify.noti_content) && !TextUtils.isEmpty(alaLiveNotify.noti_url)) {
                this.cEl = alaLiveNotify;
                if (akG() < 3) {
                    if (System.currentTimeMillis() - akJ() >= 7200000) {
                        if (fVar.agW() && isFirst()) {
                            this.isFirst = false;
                            return;
                        }
                        bq(fVar.getPageContext().getPageActivity());
                        if (this.cEj != null) {
                            this.cEj.setText(alaLiveNotify.noti_content);
                        }
                        e.fP().removeCallbacks(this.bTs);
                        e.fP().postDelayed(this.bTs, TbConfig.NOTIFY_SOUND_INTERVAL);
                    }
                }
            }
        }
    }

    public void akC() {
        f fVar;
        if (this.cEn != null && (fVar = this.cEn.get()) != null) {
            d agN = fVar.agN();
            if ((agN instanceof com.baidu.tieba.frs.entelechy.c.a) && ((com.baidu.tieba.frs.entelechy.c.a) agN).ajt() != null) {
                ((com.baidu.tieba.frs.entelechy.c.a) agN).ajt().jU(49);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onChangeSkinType() {
        aj.j(this.cEi, d.g.bg_frs_hot_live_tip_selector);
        aj.i(this.cEj, d.e.cp_cont_i);
        aj.c(this.cEk, d.g.icon_home_card_close_white);
        this.cEj.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, aj.getDrawable(d.g.icon_arrow_more_white), (Drawable) null);
    }

    private void bq(Context context) {
        if (context != null && this.cEi == null) {
            this.cEi = (FrameLayout) LayoutInflater.from(context).inflate(d.j.frs_hot_live_tip, (ViewGroup) null);
            this.cEi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.d.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.akD();
                }
            });
            this.cEj = (TextView) this.cEi.findViewById(d.h.frs_hot_live_tip_content);
            this.cEk = (ImageView) this.cEi.findViewById(d.h.frs_hot_live_tip_close);
            this.cEk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.d.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.akE();
                }
            });
            onChangeSkinType();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Oh() {
        f fVar;
        if (this.cEn != null && (fVar = this.cEn.get()) != null) {
            com.baidu.tieba.frs.entelechy.b.d agN = fVar.agN();
            i agP = fVar.agP();
            if (agP != null && agN != null && agN.ajo() != null && (agP.ahG() instanceof NoPressedRelativeLayout)) {
                View ajo = agN.ajo();
                BdTypeListView listView = agP.getListView();
                if (ajo != null && listView != null) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, l.f(TbadkCoreApplication.getInst(), d.f.ds56));
                    layoutParams.addRule(6, d.h.frs_list_content);
                    if (agP.ahm() != null && agP.ahm().getLayoutParams() != null) {
                        layoutParams.topMargin = agP.ahm().getLayoutParams().height;
                    } else {
                        layoutParams.topMargin = 0;
                    }
                    if (this.bgk == null) {
                        this.bgk = new as();
                    }
                    this.bgk.a(this.cEi, (NoPressedRelativeLayout) agP.ahG(), layoutParams, 5000);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akD() {
        f fVar;
        akH();
        if (this.cEn != null && this.cEl != null && this.cEl.noti_url != null && (fVar = this.cEn.get()) != null && fVar.isAdded()) {
            TiebaStatic.log(new ak("c12331"));
            if (av.vA().c(fVar.getPageContext(), new String[]{this.cEl.noti_url + "&from=frs_hot_live_tip"})) {
                e.fP().post(new Runnable() { // from class: com.baidu.tieba.frs.d.a.4
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.akC();
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akE() {
        akF();
        if (this.bgk != null) {
            this.bgk.hideTip();
        }
    }

    private void akF() {
        this.cEm++;
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("FRS_HOT_LIVE_TIP_CLOSE_NUM" + getUserId(), this.cEm);
    }

    private int akG() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("FRS_HOT_LIVE_TIP_CLOSE_NUM" + getUserId(), 0);
    }

    private void akH() {
        this.cEm = 0;
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("FRS_HOT_LIVE_TIP_CLOSE_NUM" + getUserId(), this.cEm);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akI() {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("FRS_HOT_LIVE_TIP_LAST_SHOWTIME" + getUserId(), System.currentTimeMillis());
    }

    private long akJ() {
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
