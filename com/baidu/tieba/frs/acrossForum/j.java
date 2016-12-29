package com.baidu.tieba.frs.acrossForum;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.frs.h.an;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class j {
    private View GD;
    private TbPageContext Gf;
    private View aqR;
    private com.baidu.tieba.frs.h.s bCV;
    private TextView bCW;
    private com.baidu.tieba.tbadkCore.o bCX;
    private TextView bCY;
    private ViewGroup bCZ;
    private View mView;
    private boolean bDa = false;
    private boolean bDb = true;
    private View.OnClickListener aMS = new k(this);
    private a bBM = new l(this);
    private CustomMessageListener bwo = new m(this, CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS);
    private an.a bDc = new n(this);
    private Runnable bDd = new o(this);
    private CustomMessageListener bCS = new p(this, CmdConfigCustom.CMD_FRS_EXIT_STICKY_MODE);

    /* loaded from: classes.dex */
    public interface a {
        void u(ViewGroup viewGroup);
    }

    public j(TbPageContext tbPageContext, an anVar, com.baidu.tieba.frs.h.s sVar, com.baidu.tieba.tbadkCore.o oVar) {
        this.Gf = tbPageContext;
        this.bCV = sVar;
        if (anVar != null) {
            anVar.a(this.bDc);
        }
    }

    public a Yo() {
        return this.bBM;
    }

    public void c(com.baidu.tieba.tbadkCore.o oVar) {
        this.bCX = oVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(ViewGroup viewGroup) {
        if (!this.bDa && this.mView == null && !this.bDb && viewGroup != null && this.bCX != null && this.bCX.aIk() != null && this.bCX.aIk().isLike() != 1) {
            this.bCZ = viewGroup;
            init();
        }
    }

    private void init() {
        this.Gf.registerListener(this.bwo);
        this.Gf.registerListener(this.bCS);
        this.mView = LayoutInflater.from(this.Gf.getPageActivity()).inflate(r.h.across_forum_frs_attention, this.bCZ, false);
        this.bCW = (TextView) this.mView.findViewById(r.g.across_forum_attention_btn);
        this.GD = this.mView.findViewById(r.g.across_forum_attention_bottom_line);
        this.aqR = this.mView.findViewById(r.g.across_forum_attention_top_line);
        this.mView.setClickable(true);
        this.bCW.setOnClickListener(this.aMS);
        this.bCY = (TextView) this.mView.findViewById(r.g.across_forum_attention_tip);
        this.bCZ.addView(this.mView);
        tm();
    }

    public void tm() {
        if (this.mView != null && this.bCW != null) {
            ar.j((View) this.bCY, r.d.cp_cont_b);
            ar.l(this.mView, r.d.common_color_10055);
            ar.l(this.GD, r.d.cp_bg_line_b);
            ar.l(this.aqR, r.d.cp_bg_line_b);
            this.bCW.setCompoundDrawablesWithIntrinsicBounds(ar.getDrawable(r.f.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
            ar.j((View) this.bCW, r.d.btn_forum_focus_color);
        }
    }

    public void onDestory() {
        com.baidu.adp.lib.h.h.eG().removeCallbacks(this.bDd);
    }
}
