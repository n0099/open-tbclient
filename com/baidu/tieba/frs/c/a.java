package com.baidu.tieba.frs.c;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.g.e;
import com.baidu.adp.lib.util.k;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.at;
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
    private ar beQ;
    private FrameLayout cuk;
    private TextView cul;
    private ImageView cum;
    private AlaLiveNotify cun;
    private WeakReference<f> cup;
    private boolean isFirst = true;
    private Runnable buu = new Runnable() { // from class: com.baidu.tieba.frs.c.a.1
        @Override // java.lang.Runnable
        public void run() {
            a.this.onChangeSkinType();
            a.this.aij();
            a.this.aip();
        }
    };
    private int cuo = ain();

    public void a(f fVar, AlaLiveNotify alaLiveNotify) {
        if (fVar != null && alaLiveNotify != null) {
            this.cup = new WeakReference<>(fVar);
            if (!TextUtils.isEmpty(alaLiveNotify.noti_content) && !TextUtils.isEmpty(alaLiveNotify.noti_url)) {
                this.cun = alaLiveNotify;
                if (ain() < 3) {
                    if (System.currentTimeMillis() - aiq() >= 7200000) {
                        if (fVar.afi() && isFirst()) {
                            this.isFirst = false;
                            return;
                        }
                        initView(fVar.getPageContext().getPageActivity());
                        if (this.cul != null) {
                            this.cul.setText(alaLiveNotify.noti_content);
                        }
                        e.ga().removeCallbacks(this.buu);
                        e.ga().postDelayed(this.buu, TbConfig.NOTIFY_SOUND_INTERVAL);
                    }
                }
            }
        }
    }

    public void aii() {
        f fVar;
        if (this.cup != null && (fVar = this.cup.get()) != null) {
            d aeX = fVar.aeX();
            if ((aeX instanceof com.baidu.tieba.frs.entelechy.c.a) && ((com.baidu.tieba.frs.entelechy.c.a) aeX).ahg() != null) {
                ((com.baidu.tieba.frs.entelechy.c.a) aeX).ahg().jn(49);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onChangeSkinType() {
        ai.j(this.cuk, d.g.bg_frs_hot_live_tip_selector);
        ai.i(this.cul, d.e.cp_cont_i);
        ai.c(this.cum, d.g.icon_home_card_close_white);
        this.cul.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ai.getDrawable(d.g.icon_arrow_more_white), (Drawable) null);
    }

    private void initView(Context context) {
        if (context != null && this.cuk == null) {
            this.cuk = (FrameLayout) LayoutInflater.from(context).inflate(d.j.frs_hot_live_tip, (ViewGroup) null);
            this.cuk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.c.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.aik();
                }
            });
            this.cul = (TextView) this.cuk.findViewById(d.h.frs_hot_live_tip_content);
            this.cum = (ImageView) this.cuk.findViewById(d.h.frs_hot_live_tip_close);
            this.cum.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.c.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.ail();
                }
            });
            onChangeSkinType();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aij() {
        f fVar;
        if (this.cup != null && (fVar = this.cup.get()) != null) {
            com.baidu.tieba.frs.entelechy.b.d aeX = fVar.aeX();
            i aeZ = fVar.aeZ();
            if (aeZ != null && aeX != null && aeX.ahb() != null && (aeZ.VR() instanceof NoPressedRelativeLayout)) {
                View ahb = aeX.ahb();
                BdTypeListView listView = aeZ.getListView();
                if (ahb != null && listView != null) {
                    ViewGroup viewGroup = (ViewGroup) ((NoPressedRelativeLayout) aeZ.VR()).findViewById(d.h.tip_container);
                    ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, k.g(TbadkCoreApplication.getInst(), d.f.ds56));
                    if (this.beQ == null) {
                        this.beQ = new ar();
                    }
                    this.beQ.a(this.cuk, viewGroup, layoutParams, 5000);
                    TiebaStatic.log(new aj("c12332"));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aik() {
        f fVar;
        aio();
        if (this.cup != null && this.cun != null && this.cun.noti_url != null && (fVar = this.cup.get()) != null) {
            TiebaStatic.log(new aj("c12331"));
            if (at.wf().c(fVar.getPageContext(), new String[]{this.cun.noti_url + "&from=frs_hot_live_tip"})) {
                e.ga().post(new Runnable() { // from class: com.baidu.tieba.frs.c.a.4
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.aii();
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ail() {
        aim();
        if (this.beQ != null) {
            this.beQ.hideTip();
        }
    }

    private void aim() {
        this.cuo++;
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("FRS_HOT_LIVE_TIP_CLOSE_NUM" + getUserId(), this.cuo);
    }

    private int ain() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("FRS_HOT_LIVE_TIP_CLOSE_NUM" + getUserId(), 0);
    }

    private void aio() {
        this.cuo = 0;
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("FRS_HOT_LIVE_TIP_CLOSE_NUM" + getUserId(), this.cuo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aip() {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("FRS_HOT_LIVE_TIP_LAST_SHOWTIME" + getUserId(), System.currentTimeMillis());
    }

    private long aiq() {
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
