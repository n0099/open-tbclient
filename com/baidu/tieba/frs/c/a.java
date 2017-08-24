package com.baidu.tieba.frs.c;

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
    private ar beR;
    private FrameLayout cwo;
    private TextView cwp;
    private ImageView cwq;
    private AlaLiveNotify cwr;
    private WeakReference<f> cwt;
    private boolean isFirst = true;
    private Runnable bQe = new Runnable() { // from class: com.baidu.tieba.frs.c.a.1
        @Override // java.lang.Runnable
        public void run() {
            a.this.onChangeSkinType();
            a.this.aiK();
            a.this.aiQ();
        }
    };
    private int cws = aiO();

    public void a(f fVar, AlaLiveNotify alaLiveNotify) {
        if (fVar != null && alaLiveNotify != null && fVar.isAdded()) {
            this.cwt = new WeakReference<>(fVar);
            if (!TextUtils.isEmpty(alaLiveNotify.noti_content) && !TextUtils.isEmpty(alaLiveNotify.noti_url)) {
                this.cwr = alaLiveNotify;
                if (aiO() < 3) {
                    if (System.currentTimeMillis() - aiR() >= 7200000) {
                        if (fVar.afy() && isFirst()) {
                            this.isFirst = false;
                            return;
                        }
                        initView(fVar.getPageContext().getPageActivity());
                        if (this.cwp != null) {
                            this.cwp.setText(alaLiveNotify.noti_content);
                        }
                        e.ga().removeCallbacks(this.bQe);
                        e.ga().postDelayed(this.bQe, TbConfig.NOTIFY_SOUND_INTERVAL);
                    }
                }
            }
        }
    }

    public void aiJ() {
        f fVar;
        if (this.cwt != null && (fVar = this.cwt.get()) != null) {
            d afn = fVar.afn();
            if ((afn instanceof com.baidu.tieba.frs.entelechy.c.a) && ((com.baidu.tieba.frs.entelechy.c.a) afn).ahv() != null) {
                ((com.baidu.tieba.frs.entelechy.c.a) afn).ahv().jx(49);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onChangeSkinType() {
        ai.j(this.cwo, d.g.bg_frs_hot_live_tip_selector);
        ai.i(this.cwp, d.e.cp_cont_i);
        ai.c(this.cwq, d.g.icon_home_card_close_white);
        this.cwp.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ai.getDrawable(d.g.icon_arrow_more_white), (Drawable) null);
    }

    private void initView(Context context) {
        if (context != null && this.cwo == null) {
            this.cwo = (FrameLayout) LayoutInflater.from(context).inflate(d.j.frs_hot_live_tip, (ViewGroup) null);
            this.cwo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.c.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.aiL();
                }
            });
            this.cwp = (TextView) this.cwo.findViewById(d.h.frs_hot_live_tip_content);
            this.cwq = (ImageView) this.cwo.findViewById(d.h.frs_hot_live_tip_close);
            this.cwq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.c.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.aiM();
                }
            });
            onChangeSkinType();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aiK() {
        f fVar;
        if (this.cwt != null && (fVar = this.cwt.get()) != null) {
            com.baidu.tieba.frs.entelechy.b.d afn = fVar.afn();
            i afp = fVar.afp();
            if (afp != null && afn != null && afn.ahq() != null && (afp.Wk() instanceof NoPressedRelativeLayout)) {
                View ahq = afn.ahq();
                BdTypeListView listView = afp.getListView();
                if (ahq != null && listView != null) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, k.g(TbadkCoreApplication.getInst(), d.f.ds56));
                    layoutParams.addRule(6, d.h.frs_list_content);
                    if (afp.afP() != null && afp.afP().getLayoutParams() != null) {
                        layoutParams.topMargin = afp.afP().getLayoutParams().height;
                    } else {
                        layoutParams.topMargin = 0;
                    }
                    if (this.beR == null) {
                        this.beR = new ar();
                    }
                    this.beR.a(this.cwo, (NoPressedRelativeLayout) afp.Wk(), layoutParams, 5000);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aiL() {
        f fVar;
        aiP();
        if (this.cwt != null && this.cwr != null && this.cwr.noti_url != null && (fVar = this.cwt.get()) != null && fVar.isAdded()) {
            TiebaStatic.log(new aj("c12331"));
            if (at.wg().c(fVar.getPageContext(), new String[]{this.cwr.noti_url + "&from=frs_hot_live_tip"})) {
                e.ga().post(new Runnable() { // from class: com.baidu.tieba.frs.c.a.4
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.aiJ();
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aiM() {
        aiN();
        if (this.beR != null) {
            this.beR.hideTip();
        }
    }

    private void aiN() {
        this.cws++;
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("FRS_HOT_LIVE_TIP_CLOSE_NUM" + getUserId(), this.cws);
    }

    private int aiO() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("FRS_HOT_LIVE_TIP_CLOSE_NUM" + getUserId(), 0);
    }

    private void aiP() {
        this.cws = 0;
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("FRS_HOT_LIVE_TIP_CLOSE_NUM" + getUserId(), this.cws);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aiQ() {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("FRS_HOT_LIVE_TIP_LAST_SHOWTIME" + getUserId(), System.currentTimeMillis());
    }

    private long aiR() {
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
