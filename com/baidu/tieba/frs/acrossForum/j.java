package com.baidu.tieba.frs.acrossForum;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.frs.j.ai;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class j {
    private View GD;
    private TbPageContext Gf;
    private View aro;
    private com.baidu.tieba.frs.j.n bWL;
    private TextView bWM;
    private com.baidu.tieba.tbadkCore.p bWN;
    private TextView bWO;
    private ViewGroup bWP;
    private View mView;
    private boolean bWQ = false;
    private boolean bWR = true;
    private View.OnClickListener aNB = new k(this);
    private a bVE = new l(this);
    private CustomMessageListener bQk = new m(this, CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS);
    private ai.a bWS = new n(this);
    private Runnable bWT = new o(this);
    private CustomMessageListener bWI = new p(this, CmdConfigCustom.CMD_FRS_EXIT_STICKY_MODE);

    /* loaded from: classes.dex */
    public interface a {
        void z(ViewGroup viewGroup);
    }

    public j(TbPageContext tbPageContext, ai aiVar, com.baidu.tieba.frs.j.n nVar, com.baidu.tieba.tbadkCore.p pVar) {
        this.Gf = tbPageContext;
        this.bWL = nVar;
        if (aiVar != null) {
            aiVar.a(this.bWS);
        }
    }

    public a adU() {
        return this.bVE;
    }

    public void c(com.baidu.tieba.tbadkCore.p pVar) {
        this.bWN = pVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(ViewGroup viewGroup) {
        if (!this.bWQ && this.mView == null && !this.bWR && viewGroup != null && this.bWN != null && this.bWN.aOk() != null && this.bWN.aOk().isLike() != 1) {
            this.bWP = viewGroup;
            init();
        }
    }

    private void init() {
        this.Gf.registerListener(this.bQk);
        this.Gf.registerListener(this.bWI);
        this.mView = LayoutInflater.from(this.Gf.getPageActivity()).inflate(r.h.across_forum_frs_attention, this.bWP, false);
        this.bWM = (TextView) this.mView.findViewById(r.g.across_forum_attention_btn);
        this.GD = this.mView.findViewById(r.g.across_forum_attention_bottom_line);
        this.aro = this.mView.findViewById(r.g.across_forum_attention_top_line);
        this.mView.setClickable(true);
        this.bWM.setOnClickListener(this.aNB);
        this.bWO = (TextView) this.mView.findViewById(r.g.across_forum_attention_tip);
        this.bWP.addView(this.mView);
        tB();
    }

    public void tB() {
        if (this.mView != null && this.bWM != null) {
            at.j((View) this.bWO, r.d.cp_cont_b);
            at.l(this.mView, r.d.common_color_10055);
            at.l(this.GD, r.d.cp_bg_line_b);
            at.l(this.aro, r.d.cp_bg_line_b);
            this.bWM.setCompoundDrawablesWithIntrinsicBounds(at.getDrawable(r.f.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
            at.j((View) this.bWM, r.d.btn_forum_focus_color);
        }
    }

    public void onDestory() {
        com.baidu.adp.lib.h.h.eG().removeCallbacks(this.bWT);
    }
}
