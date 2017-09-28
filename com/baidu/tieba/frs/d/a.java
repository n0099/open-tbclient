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
    private as bgz;
    private FrameLayout cEu;
    private TextView cEv;
    private ImageView cEw;
    private AlaLiveNotify cEx;
    private WeakReference<f> cEz;
    private boolean isFirst = true;
    private Runnable bTE = new Runnable() { // from class: com.baidu.tieba.frs.d.a.1
        @Override // java.lang.Runnable
        public void run() {
            a.this.onChangeSkinType();
            a.this.On();
            a.this.akN();
        }
    };
    private int cEy = akL();

    public void a(f fVar, AlaLiveNotify alaLiveNotify) {
        if (fVar != null && alaLiveNotify != null && fVar.isAdded()) {
            this.cEz = new WeakReference<>(fVar);
            if (!TextUtils.isEmpty(alaLiveNotify.noti_content) && !TextUtils.isEmpty(alaLiveNotify.noti_url)) {
                this.cEx = alaLiveNotify;
                if (akL() < 3) {
                    if (System.currentTimeMillis() - akO() >= 7200000) {
                        if (fVar.ahb() && isFirst()) {
                            this.isFirst = false;
                            return;
                        }
                        br(fVar.getPageContext().getPageActivity());
                        if (this.cEv != null) {
                            this.cEv.setText(alaLiveNotify.noti_content);
                        }
                        e.fP().removeCallbacks(this.bTE);
                        e.fP().postDelayed(this.bTE, TbConfig.NOTIFY_SOUND_INTERVAL);
                    }
                }
            }
        }
    }

    public void akH() {
        f fVar;
        if (this.cEz != null && (fVar = this.cEz.get()) != null) {
            d agS = fVar.agS();
            if ((agS instanceof com.baidu.tieba.frs.entelechy.c.a) && ((com.baidu.tieba.frs.entelechy.c.a) agS).ajy() != null) {
                ((com.baidu.tieba.frs.entelechy.c.a) agS).ajy().jV(49);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onChangeSkinType() {
        aj.j(this.cEu, d.g.bg_frs_hot_live_tip_selector);
        aj.i(this.cEv, d.e.cp_cont_i);
        aj.c(this.cEw, d.g.icon_home_card_close_white);
        this.cEv.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, aj.getDrawable(d.g.icon_arrow_more_white), (Drawable) null);
    }

    private void br(Context context) {
        if (context != null && this.cEu == null) {
            this.cEu = (FrameLayout) LayoutInflater.from(context).inflate(d.j.frs_hot_live_tip, (ViewGroup) null);
            this.cEu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.d.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.akI();
                }
            });
            this.cEv = (TextView) this.cEu.findViewById(d.h.frs_hot_live_tip_content);
            this.cEw = (ImageView) this.cEu.findViewById(d.h.frs_hot_live_tip_close);
            this.cEw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.d.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.akJ();
                }
            });
            onChangeSkinType();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void On() {
        f fVar;
        if (this.cEz != null && (fVar = this.cEz.get()) != null) {
            com.baidu.tieba.frs.entelechy.b.d agS = fVar.agS();
            i agU = fVar.agU();
            if (agU != null && agS != null && agS.ajt() != null && (agU.ahL() instanceof NoPressedRelativeLayout)) {
                View ajt = agS.ajt();
                BdTypeListView listView = agU.getListView();
                if (ajt != null && listView != null) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, l.f(TbadkCoreApplication.getInst(), d.f.ds56));
                    layoutParams.addRule(6, d.h.frs_list_content);
                    if (agU.ahr() != null && agU.ahr().getLayoutParams() != null) {
                        layoutParams.topMargin = agU.ahr().getLayoutParams().height;
                    } else {
                        layoutParams.topMargin = 0;
                    }
                    if (this.bgz == null) {
                        this.bgz = new as();
                    }
                    this.bgz.a(this.cEu, (NoPressedRelativeLayout) agU.ahL(), layoutParams, 5000);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akI() {
        f fVar;
        akM();
        if (this.cEz != null && this.cEx != null && this.cEx.noti_url != null && (fVar = this.cEz.get()) != null && fVar.isAdded()) {
            TiebaStatic.log(new ak("c12331"));
            if (av.vH().c(fVar.getPageContext(), new String[]{this.cEx.noti_url + "&from=frs_hot_live_tip"})) {
                e.fP().post(new Runnable() { // from class: com.baidu.tieba.frs.d.a.4
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.akH();
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akJ() {
        akK();
        if (this.bgz != null) {
            this.bgz.hideTip();
        }
    }

    private void akK() {
        this.cEy++;
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("FRS_HOT_LIVE_TIP_CLOSE_NUM" + getUserId(), this.cEy);
    }

    private int akL() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("FRS_HOT_LIVE_TIP_CLOSE_NUM" + getUserId(), 0);
    }

    private void akM() {
        this.cEy = 0;
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("FRS_HOT_LIVE_TIP_CLOSE_NUM" + getUserId(), this.cEy);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akN() {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("FRS_HOT_LIVE_TIP_LAST_SHOWTIME" + getUserId(), System.currentTimeMillis());
    }

    private long akO() {
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
