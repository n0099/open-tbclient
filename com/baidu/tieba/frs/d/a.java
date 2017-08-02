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
    private ar bdF;
    private FrameLayout csQ;
    private TextView csR;
    private ImageView csS;
    private AlaLiveNotify csT;
    private WeakReference<f> csV;
    private boolean isFirst = true;
    private Runnable btj = new Runnable() { // from class: com.baidu.tieba.frs.d.a.1
        @Override // java.lang.Runnable
        public void run() {
            a.this.onChangeSkinType();
            a.this.ahX();
            a.this.aid();
        }
    };
    private int csU = aib();

    public void a(f fVar, AlaLiveNotify alaLiveNotify) {
        if (fVar != null && alaLiveNotify != null) {
            this.csV = new WeakReference<>(fVar);
            if (!TextUtils.isEmpty(alaLiveNotify.noti_content) && !TextUtils.isEmpty(alaLiveNotify.noti_url)) {
                this.csT = alaLiveNotify;
                if (aib() < 3) {
                    if (System.currentTimeMillis() - aie() >= 7200000) {
                        if (fVar.afd() && isFirst()) {
                            this.isFirst = false;
                            return;
                        }
                        initView(fVar.getPageContext().getPageActivity());
                        if (this.csR != null) {
                            this.csR.setText(alaLiveNotify.noti_content);
                        }
                        e.fP().removeCallbacks(this.btj);
                        e.fP().postDelayed(this.btj, TbConfig.NOTIFY_SOUND_INTERVAL);
                    }
                }
            }
        }
    }

    public void ahW() {
        f fVar;
        if (this.csV != null && (fVar = this.csV.get()) != null) {
            d aeS = fVar.aeS();
            if ((aeS instanceof com.baidu.tieba.frs.entelechy.c.a) && ((com.baidu.tieba.frs.entelechy.c.a) aeS).agZ() != null) {
                ((com.baidu.tieba.frs.entelechy.c.a) aeS).agZ().jn(49);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onChangeSkinType() {
        ai.j(this.csQ, d.g.bg_frs_hot_live_tip_selector);
        ai.i(this.csR, d.e.cp_cont_i);
        ai.c(this.csS, d.g.icon_home_card_close_white);
        this.csR.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ai.getDrawable(d.g.icon_arrow_more_white), (Drawable) null);
    }

    private void initView(Context context) {
        if (context != null && this.csQ == null) {
            this.csQ = (FrameLayout) LayoutInflater.from(context).inflate(d.j.frs_hot_live_tip, (ViewGroup) null);
            this.csQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.d.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.ahY();
                }
            });
            this.csR = (TextView) this.csQ.findViewById(d.h.frs_hot_live_tip_content);
            this.csS = (ImageView) this.csQ.findViewById(d.h.frs_hot_live_tip_close);
            this.csS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.d.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.ahZ();
                }
            });
            onChangeSkinType();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ahX() {
        f fVar;
        if (this.csV != null && (fVar = this.csV.get()) != null) {
            com.baidu.tieba.frs.entelechy.b.d aeS = fVar.aeS();
            i aeU = fVar.aeU();
            if (aeU != null && aeS != null && aeS.agU() != null && (aeU.VM() instanceof NoPressedRelativeLayout)) {
                View agU = aeS.agU();
                BdTypeListView listView = aeU.getListView();
                if (agU != null && listView != null) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, k.g(TbadkCoreApplication.getInst(), d.f.ds56));
                    layoutParams.addRule(6, d.h.frs_list_content);
                    if (aeU.aft() != null && aeU.aft().getLayoutParams() != null) {
                        layoutParams.topMargin = aeU.aft().getLayoutParams().height;
                    } else {
                        layoutParams.topMargin = 0;
                    }
                    if (this.bdF == null) {
                        this.bdF = new ar();
                    }
                    this.bdF.a(this.csQ, (NoPressedRelativeLayout) aeU.VM(), layoutParams, 5000);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ahY() {
        f fVar;
        aic();
        if (this.csV != null && this.csT != null && this.csT.noti_url != null && (fVar = this.csV.get()) != null) {
            TiebaStatic.log(new aj("c12331"));
            if (at.vV().c(fVar.getPageContext(), new String[]{this.csT.noti_url + "&from=frs_hot_live_tip"})) {
                e.fP().post(new Runnable() { // from class: com.baidu.tieba.frs.d.a.4
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.ahW();
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ahZ() {
        aia();
        if (this.bdF != null) {
            this.bdF.hideTip();
        }
    }

    private void aia() {
        this.csU++;
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("FRS_HOT_LIVE_TIP_CLOSE_NUM" + getUserId(), this.csU);
    }

    private int aib() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("FRS_HOT_LIVE_TIP_CLOSE_NUM" + getUserId(), 0);
    }

    private void aic() {
        this.csU = 0;
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("FRS_HOT_LIVE_TIP_CLOSE_NUM" + getUserId(), this.csU);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aid() {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("FRS_HOT_LIVE_TIP_LAST_SHOWTIME" + getUserId(), System.currentTimeMillis());
    }

    private long aie() {
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
