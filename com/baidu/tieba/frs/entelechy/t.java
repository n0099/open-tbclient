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
    private com.baidu.tbadk.core.data.u bRA;
    private ViewStub bRB;
    private TextView bRC;
    private TextView bRD;
    private ImageView bRE;
    private com.baidu.tieba.tbadkCore.m bRy;
    private TextView bRz;

    public t(FrsActivity frsActivity, String str, String str2, int i) {
        super(frsActivity, str, str2, i);
        this.bRy = null;
        this.bRA = null;
        if (this.aVp != null) {
            this.aVp.setPadding(0, 0, 0, 0);
        }
        this.bRz = (TextView) this.aXl.findViewById(w.h.sign_done_bg);
        this.aXl.findViewById(w.h.frs_header_divider).setVisibility(4);
    }

    @Override // com.baidu.tieba.frs.entelechy.j
    protected View aaP() {
        return LayoutInflater.from(this.bOf.getPageContext().getPageActivity()).inflate(w.j.frs_star_header, (ViewGroup) null);
    }

    @Override // com.baidu.tieba.frs.entelechy.j, com.baidu.tieba.frs.view.c
    public void a(ForumData forumData, com.baidu.tieba.tbadkCore.n nVar) {
        if (nVar != null) {
            this.bRy = nVar.bgn();
            this.bRA = nVar.bgK();
        }
        super.a(forumData, nVar);
        this.mImageUrl = this.bRy.bgW();
    }

    @Override // com.baidu.tieba.frs.entelechy.j
    protected void abd() {
        if (this.bRy != null && this.cds != null) {
            MediaData mediaData = new MediaData();
            mediaData.setType(3);
            mediaData.setPic(this.bRy.bgV());
            this.cds.sy().add(mediaData);
            MediaData mediaData2 = new MediaData();
            mediaData2.setType(3);
            mediaData2.setPic(this.bRy.bgW());
            this.cds.sy().add(mediaData2);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.j
    protected void abg() {
        if (this.bSZ != null) {
            if (this.bRA == null || StringUtils.isNull(this.bRA.qB(), true)) {
                if (this.bRB != null) {
                    this.bRB.setVisibility(8);
                }
                if (this.bSZ.bgo() == null || this.bSZ.bgo().qi() == null || (this.bSZ.bgo().qi().size() <= 0 && this.bRy != null)) {
                    this.ccQ.setVisibility(8);
                    ArrayList<com.baidu.tbadk.core.data.t> arrayList = new ArrayList<>();
                    String str = "";
                    if (this.bSZ.aJw() != null && this.bSZ.aJw().getFrsBannerData() != null) {
                        str = this.bSZ.aJw().getFrsBannerData().getValue();
                    }
                    com.baidu.tbadk.core.data.t tVar = new com.baidu.tbadk.core.data.t(this.bRy.bgV(), str, null);
                    tVar.ao(true);
                    arrayList.add(tVar);
                    com.baidu.tbadk.core.data.r rVar = new com.baidu.tbadk.core.data.r();
                    rVar.f(arrayList);
                    a(rVar);
                    return;
                }
                this.ccQ.setVisibility(0);
                a(this.bSZ.bgo());
                return;
            }
            abk();
        }
    }

    private void abk() {
        if (this.bOf != null && this.bRA != null && !StringUtils.isNull(this.bRA.qB(), true)) {
            if (this.bRB == null) {
                this.bRB = (ViewStub) this.aXl.findViewById(w.h.frs_star_cover_info);
            }
            this.bRB.setVisibility(0);
            if (this.bRC == null) {
                this.bRC = (TextView) this.aXl.findViewById(w.h.frs_star_cover_pic_author);
            }
            if (this.bRD == null) {
                this.bRD = (TextView) this.aXl.findViewById(w.h.frs_star_cover_post_author);
            }
            if (this.bRE == null) {
                this.bRE = (ImageView) this.aXl.findViewById(w.h.frs_star_cover_goto_h5);
            }
            if (this.bRA.qx()) {
                this.bRD.setVisibility(4);
            } else {
                this.bRD.setText(String.format(this.aaX.getString(w.l.star_cover_post_author), this.bRA.qz()));
                this.bRD.setVisibility(0);
            }
            if (this.bRA.qy()) {
                this.bRC.setVisibility(4);
            } else {
                this.bRC.setText(String.format(this.aaX.getString(w.l.star_cover_pic_author), this.bRA.qA()));
                this.bRC.setVisibility(0);
            }
            abl();
            this.bRE.setOnClickListener(new u(this));
            this.ccQ.setVisibility(8);
            a(this.bRA.qD());
        }
    }

    @Override // com.baidu.tieba.frs.view.c
    public void a(com.baidu.tbadk.core.data.r rVar) {
        super.a(rVar);
        if (this.bRA != null && !StringUtils.isNull(this.bRA.qB(), true)) {
            this.ccP.setCallback(new v(this));
        }
    }

    private void abl() {
        if (this.bRA != null) {
            if (!this.bRA.qw()) {
                aq.j(this.bRE, w.g.btn_frs_toutiao_n);
            } else {
                aq.j(this.bRE, w.g.btn_frs_enter_n);
            }
            aq.i(this.bRC, w.e.cp_cont_i);
            aq.i(this.bRD, w.e.cp_cont_i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.entelechy.j
    public void Nw() {
    }

    @Override // com.baidu.tieba.frs.entelechy.j, com.baidu.tieba.frs.view.c
    public void c(View view, boolean z) {
        TiebaStatic.eventStat(this.bOf.getPageContext().getPageActivity(), "consume_6", "click");
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
    protected void abc() {
        aq.c(this.ccA, w.g.frs_text_color_selector, 1);
        aq.j(this.ccy, w.g.frs_star_btn_like);
        this.ccz.setVisibility(8);
        this.ccA.setCompoundDrawablesWithIntrinsicBounds(aq.getDrawable(w.g.icon_like_selector), (Drawable) null, (Drawable) null, (Drawable) null);
        aq.c(this.ccD, w.g.frs_text_color_selector, 1);
        aq.j(this.ccB, w.g.frs_star_btn_like);
        this.ccC.setVisibility(8);
        this.ccD.setCompoundDrawablesWithIntrinsicBounds(aq.getDrawable(w.g.icon_star_sign_selector), (Drawable) null, (Drawable) null, (Drawable) null);
    }

    @Override // com.baidu.tieba.frs.entelechy.j, com.baidu.tieba.frs.view.c
    public void setCommonClickListener(View.OnClickListener onClickListener) {
        super.setCommonClickListener(onClickListener);
        this.ccy.setOnClickListener(onClickListener);
        this.ccB.setOnClickListener(onClickListener);
    }

    @Override // com.baidu.tieba.frs.entelechy.j, com.baidu.tieba.frs.view.c
    protected void abe() {
        if (this.cdw > 0) {
            if (com.baidu.adp.lib.util.k.af(this.aaX.getPageActivity()) >= 480) {
                this.ccG.setCompoundDrawablesWithIntrinsicBounds(aq.getDrawable(w.g.frs_star_bu_selector), (Drawable) null, (Drawable) null, (Drawable) null);
            }
            aq.c(this.ccG, w.g.frs_text_color_selector, 1);
            aq.j(this.bRz, w.g.frs_star_btn_like);
            this.ccG.setText(String.format(this.aaX.getString(w.l.miss_sign_days), Integer.valueOf(this.cdw)));
        } else {
            this.ccG.setCompoundDrawablesWithIntrinsicBounds(aq.getDrawable(w.g.icon_sign_blue_d), (Drawable) null, (Drawable) null, (Drawable) null);
            aq.j(this.bRz, w.g.btn_frs_signed_bg_selector);
            aq.c(this.ccG, w.e.cp_link_tip_a, 1);
            if (this.cdv <= 0) {
                this.ccG.setText(this.aaX.getString(w.l.signed));
            } else {
                this.ccG.setText(String.format(this.aaX.getString(w.l.continuous_sign_days), Integer.valueOf(this.cdv)));
            }
        }
        this.ccF.setVisibility(0);
    }

    @Override // com.baidu.tieba.frs.entelechy.j, com.baidu.tieba.frs.view.c
    protected void abi() {
        this.cdk.c(this.ccy, "frs_page");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.entelechy.j
    public void Nx() {
    }

    @Override // com.baidu.tieba.frs.entelechy.j, com.baidu.tieba.frs.view.c
    public void changeSkinType(int i) {
        super.changeSkinType(i);
        if (this.bRA != null && !StringUtils.isNull(this.bRA.qB(), true)) {
            abl();
        }
    }
}
