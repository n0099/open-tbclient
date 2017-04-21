package com.baidu.tieba.frs.entelechy;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.w;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class t extends j {
    private com.baidu.tieba.tbadkCore.m bTP;
    private TextView bTQ;
    private com.baidu.tbadk.core.data.u bTR;
    private ViewStub bTS;
    private TextView bTT;
    private TextView bTU;
    private ImageView bTV;

    public t(FrsActivity frsActivity, String str, String str2, int i) {
        super(frsActivity, str, str2, i);
        this.bTP = null;
        this.bTR = null;
        if (this.aVr != null) {
            this.aVr.setPadding(0, 0, 0, 0);
        }
        this.bTQ = (TextView) this.aXo.findViewById(w.h.sign_done_bg);
        this.aXo.findViewById(w.h.frs_header_divider).setVisibility(4);
    }

    @Override // com.baidu.tieba.frs.entelechy.j
    protected View abQ() {
        return LayoutInflater.from(this.bQw.getPageContext().getPageActivity()).inflate(w.j.frs_star_header, (ViewGroup) null);
    }

    @Override // com.baidu.tieba.frs.entelechy.j, com.baidu.tieba.frs.view.c
    public void a(ForumData forumData, com.baidu.tieba.tbadkCore.n nVar) {
        if (nVar != null) {
            this.bTP = nVar.bhp();
            this.bTR = nVar.bhM();
        }
        super.a(forumData, nVar);
        this.mImageUrl = this.bTP.bhX();
    }

    @Override // com.baidu.tieba.frs.entelechy.j
    protected void ace() {
        if (this.bTP != null && this.cfJ != null) {
            MediaData mediaData = new MediaData();
            mediaData.setType(3);
            mediaData.setPic(this.bTP.bhW());
            this.cfJ.sy().add(mediaData);
            MediaData mediaData2 = new MediaData();
            mediaData2.setType(3);
            mediaData2.setPic(this.bTP.bhX());
            this.cfJ.sy().add(mediaData2);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.j
    protected void ach() {
        if (this.bVq != null) {
            if (this.bTR == null || StringUtils.isNull(this.bTR.qB(), true)) {
                if (this.bTS != null) {
                    this.bTS.setVisibility(8);
                }
                if (this.bVq.bhq() == null || this.bVq.bhq().qi() == null || (this.bVq.bhq().qi().size() <= 0 && this.bTP != null)) {
                    this.cfh.setVisibility(8);
                    ArrayList<com.baidu.tbadk.core.data.t> arrayList = new ArrayList<>();
                    String str = "";
                    if (this.bVq.aKx() != null && this.bVq.aKx().getFrsBannerData() != null) {
                        str = this.bVq.aKx().getFrsBannerData().getValue();
                    }
                    com.baidu.tbadk.core.data.t tVar = new com.baidu.tbadk.core.data.t(this.bTP.bhW(), str, null);
                    tVar.ao(true);
                    arrayList.add(tVar);
                    com.baidu.tbadk.core.data.r rVar = new com.baidu.tbadk.core.data.r();
                    rVar.f(arrayList);
                    a(rVar);
                    return;
                }
                this.cfh.setVisibility(0);
                a(this.bVq.bhq());
                return;
            }
            acl();
        }
    }

    private void acl() {
        if (this.bQw != null && this.bTR != null && !StringUtils.isNull(this.bTR.qB(), true)) {
            if (this.bTS == null) {
                this.bTS = (ViewStub) this.aXo.findViewById(w.h.frs_star_cover_info);
            }
            this.bTS.setVisibility(0);
            if (this.bTT == null) {
                this.bTT = (TextView) this.aXo.findViewById(w.h.frs_star_cover_pic_author);
            }
            if (this.bTU == null) {
                this.bTU = (TextView) this.aXo.findViewById(w.h.frs_star_cover_post_author);
            }
            if (this.bTV == null) {
                this.bTV = (ImageView) this.aXo.findViewById(w.h.frs_star_cover_goto_h5);
            }
            if (this.bTR.qx()) {
                this.bTU.setVisibility(4);
            } else {
                this.bTU.setText(String.format(this.aaY.getString(w.l.star_cover_post_author), this.bTR.qz()));
                this.bTU.setVisibility(0);
            }
            if (this.bTR.qy()) {
                this.bTT.setVisibility(4);
            } else {
                this.bTT.setText(String.format(this.aaY.getString(w.l.star_cover_pic_author), this.bTR.qA()));
                this.bTT.setVisibility(0);
            }
            acm();
            this.bTV.setOnClickListener(new u(this));
            this.cfh.setVisibility(8);
            a(this.bTR.qD());
        }
    }

    @Override // com.baidu.tieba.frs.view.c
    public void a(com.baidu.tbadk.core.data.r rVar) {
        super.a(rVar);
        if (this.bTR != null && !StringUtils.isNull(this.bTR.qB(), true)) {
            this.cfg.setCallback(new v(this));
        }
    }

    private void acm() {
        if (this.bTR != null) {
            if (!this.bTR.qw()) {
                aq.j(this.bTV, w.g.btn_frs_toutiao_n);
            } else {
                aq.j(this.bTV, w.g.btn_frs_enter_n);
            }
            aq.i(this.bTT, w.e.cp_cont_i);
            aq.i(this.bTU, w.e.cp_cont_i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.entelechy.j
    public void NE() {
    }

    @Override // com.baidu.tieba.frs.entelechy.j, com.baidu.tieba.frs.view.c
    public void c(View view, boolean z) {
        TiebaStatic.eventStat(this.bQw.getPageContext().getPageActivity(), "consume_6", "click");
        super.c(view, z);
    }

    @Override // com.baidu.tieba.frs.entelechy.j
    protected void b(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.b(w.l.cancel, new w(this));
    }

    @Override // com.baidu.tieba.frs.entelechy.j
    protected void c(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.a(w.l.open_now, new x(this));
    }

    @Override // com.baidu.tieba.frs.entelechy.j
    protected void acd() {
        aq.c(this.ceR, w.g.frs_text_color_selector, 1);
        aq.j(this.ceP, w.g.frs_star_btn_like);
        this.ceQ.setVisibility(8);
        this.ceR.setCompoundDrawablesWithIntrinsicBounds(aq.getDrawable(w.g.icon_like_selector), (Drawable) null, (Drawable) null, (Drawable) null);
        aq.c(this.ceU, w.g.frs_text_color_selector, 1);
        aq.j(this.ceS, w.g.frs_star_btn_like);
        this.ceT.setVisibility(8);
        this.ceU.setCompoundDrawablesWithIntrinsicBounds(aq.getDrawable(w.g.icon_star_sign_selector), (Drawable) null, (Drawable) null, (Drawable) null);
    }

    @Override // com.baidu.tieba.frs.entelechy.j, com.baidu.tieba.frs.view.c
    public void setCommonClickListener(View.OnClickListener onClickListener) {
        super.setCommonClickListener(onClickListener);
        this.ceP.setOnClickListener(onClickListener);
        this.ceS.setOnClickListener(onClickListener);
    }

    @Override // com.baidu.tieba.frs.entelechy.j, com.baidu.tieba.frs.view.c
    protected void acf() {
        if (this.cfN > 0) {
            if (com.baidu.adp.lib.util.k.af(this.aaY.getPageActivity()) >= 480) {
                this.ceX.setCompoundDrawablesWithIntrinsicBounds(aq.getDrawable(w.g.frs_star_bu_selector), (Drawable) null, (Drawable) null, (Drawable) null);
            }
            aq.c(this.ceX, w.g.frs_text_color_selector, 1);
            aq.j(this.bTQ, w.g.frs_star_btn_like);
            this.ceX.setText(String.format(this.aaY.getString(w.l.miss_sign_days), Integer.valueOf(this.cfN)));
        } else {
            this.ceX.setCompoundDrawablesWithIntrinsicBounds(aq.getDrawable(w.g.icon_sign_blue_d), (Drawable) null, (Drawable) null, (Drawable) null);
            aq.j(this.bTQ, w.g.btn_frs_signed_bg_selector);
            aq.c(this.ceX, w.e.cp_link_tip_a, 1);
            if (this.cfM <= 0) {
                this.ceX.setText(this.aaY.getString(w.l.signed));
            } else {
                this.ceX.setText(String.format(this.aaY.getString(w.l.continuous_sign_days), Integer.valueOf(this.cfM)));
            }
        }
        this.ceW.setVisibility(0);
    }

    @Override // com.baidu.tieba.frs.entelechy.j, com.baidu.tieba.frs.view.c
    protected void acj() {
        this.cfB.c(this.ceP, "frs_page");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.entelechy.j
    public void NF() {
    }

    @Override // com.baidu.tieba.frs.entelechy.j, com.baidu.tieba.frs.view.c
    public void changeSkinType(int i) {
        super.changeSkinType(i);
        if (this.bTR != null && !StringUtils.isNull(this.bTR.qB(), true)) {
            acm();
        }
    }
}
