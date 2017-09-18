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
    private ar beL;
    private FrameLayout cDB;
    private TextView cDC;
    private ImageView cDD;
    private AlaLiveNotify cDE;
    private WeakReference<f> cDG;
    private boolean isFirst = true;
    private Runnable bTT = new Runnable() { // from class: com.baidu.tieba.frs.d.a.1
        @Override // java.lang.Runnable
        public void run() {
            a.this.onChangeSkinType();
            a.this.NS();
            a.this.akJ();
        }
    };
    private int cDF = akH();

    public void a(f fVar, AlaLiveNotify alaLiveNotify) {
        if (fVar != null && alaLiveNotify != null && fVar.isAdded()) {
            this.cDG = new WeakReference<>(fVar);
            if (!TextUtils.isEmpty(alaLiveNotify.noti_content) && !TextUtils.isEmpty(alaLiveNotify.noti_url)) {
                this.cDE = alaLiveNotify;
                if (akH() < 3) {
                    if (System.currentTimeMillis() - akK() >= 7200000) {
                        if (fVar.ahh() && isFirst()) {
                            this.isFirst = false;
                            return;
                        }
                        bs(fVar.getPageContext().getPageActivity());
                        if (this.cDC != null) {
                            this.cDC.setText(alaLiveNotify.noti_content);
                        }
                        e.fQ().removeCallbacks(this.bTT);
                        e.fQ().postDelayed(this.bTT, TbConfig.NOTIFY_SOUND_INTERVAL);
                    }
                }
            }
        }
    }

    public void akD() {
        f fVar;
        if (this.cDG != null && (fVar = this.cDG.get()) != null) {
            d agW = fVar.agW();
            if ((agW instanceof com.baidu.tieba.frs.entelechy.c.a) && ((com.baidu.tieba.frs.entelechy.c.a) agW).ajt() != null) {
                ((com.baidu.tieba.frs.entelechy.c.a) agW).ajt().jN(49);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onChangeSkinType() {
        aj.j(this.cDB, d.g.bg_frs_hot_live_tip_selector);
        aj.i(this.cDC, d.e.cp_cont_i);
        aj.c(this.cDD, d.g.icon_home_card_close_white);
        this.cDC.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, aj.getDrawable(d.g.icon_arrow_more_white), (Drawable) null);
    }

    private void bs(Context context) {
        if (context != null && this.cDB == null) {
            this.cDB = (FrameLayout) LayoutInflater.from(context).inflate(d.j.frs_hot_live_tip, (ViewGroup) null);
            this.cDB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.d.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.akE();
                }
            });
            this.cDC = (TextView) this.cDB.findViewById(d.h.frs_hot_live_tip_content);
            this.cDD = (ImageView) this.cDB.findViewById(d.h.frs_hot_live_tip_close);
            this.cDD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.d.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.akF();
                }
            });
            onChangeSkinType();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void NS() {
        f fVar;
        if (this.cDG != null && (fVar = this.cDG.get()) != null) {
            com.baidu.tieba.frs.entelechy.b.d agW = fVar.agW();
            i agY = fVar.agY();
            if (agY != null && agW != null && agW.ajo() != null && (agY.Xy() instanceof NoPressedRelativeLayout)) {
                View ajo = agW.ajo();
                BdTypeListView listView = agY.getListView();
                if (ajo != null && listView != null) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, k.f(TbadkCoreApplication.getInst(), d.f.ds56));
                    layoutParams.addRule(6, d.h.frs_list_content);
                    if (agY.ahy() != null && agY.ahy().getLayoutParams() != null) {
                        layoutParams.topMargin = agY.ahy().getLayoutParams().height;
                    } else {
                        layoutParams.topMargin = 0;
                    }
                    if (this.beL == null) {
                        this.beL = new ar();
                    }
                    this.beL.a(this.cDB, (NoPressedRelativeLayout) agY.Xy(), layoutParams, 5000);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akE() {
        f fVar;
        akI();
        if (this.cDG != null && this.cDE != null && this.cDE.noti_url != null && (fVar = this.cDG.get()) != null && fVar.isAdded()) {
            TiebaStatic.log(new ak("c12331"));
            if (au.wd().c(fVar.getPageContext(), new String[]{this.cDE.noti_url + "&from=frs_hot_live_tip"})) {
                e.fQ().post(new Runnable() { // from class: com.baidu.tieba.frs.d.a.4
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.akD();
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akF() {
        akG();
        if (this.beL != null) {
            this.beL.hideTip();
        }
    }

    private void akG() {
        this.cDF++;
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("FRS_HOT_LIVE_TIP_CLOSE_NUM" + getUserId(), this.cDF);
    }

    private int akH() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("FRS_HOT_LIVE_TIP_CLOSE_NUM" + getUserId(), 0);
    }

    private void akI() {
        this.cDF = 0;
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("FRS_HOT_LIVE_TIP_CLOSE_NUM" + getUserId(), this.cDF);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akJ() {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("FRS_HOT_LIVE_TIP_LAST_SHOWTIME" + getUserId(), System.currentTimeMillis());
    }

    private long akK() {
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
