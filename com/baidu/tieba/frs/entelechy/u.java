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
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.r;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class u extends j {
    private com.baidu.tieba.tbadkCore.o bYr;
    private TextView bYs;
    private com.baidu.tbadk.core.data.t bYt;
    private ViewStub bYu;
    private TextView bYv;
    private TextView bYw;
    private ImageView bYx;

    public u(FrsActivity frsActivity, String str, String str2, int i) {
        super(frsActivity, str, str2, i);
        this.bYr = null;
        this.bYt = null;
        if (this.aUH != null) {
            this.aUH.setPadding(0, 0, 0, 0);
        }
        this.bYs = (TextView) this.Ge.findViewById(r.g.sign_done_bg);
        this.Ge.findViewById(r.g.frs_header_divider).setVisibility(4);
    }

    @Override // com.baidu.tieba.frs.entelechy.j
    protected View adX() {
        return LayoutInflater.from(this.bTA.getPageContext().getPageActivity()).inflate(r.h.frs_star_header, (ViewGroup) null);
    }

    @Override // com.baidu.tieba.frs.entelechy.j, com.baidu.tieba.frs.view.c
    public void a(ForumData forumData, com.baidu.tieba.tbadkCore.p pVar) {
        if (pVar != null) {
            this.bYr = pVar.bki();
            this.bYt = pVar.bkG();
        }
        super.a(forumData, pVar);
        this.mImageUrl = this.bYr.bkR();
    }

    @Override // com.baidu.tieba.frs.entelechy.j
    protected void ael() {
        if (this.bYr != null && this.clF != null) {
            MediaData mediaData = new MediaData();
            mediaData.setType(3);
            mediaData.setPic(this.bYr.bkQ());
            this.clF.rY().add(mediaData);
            MediaData mediaData2 = new MediaData();
            mediaData2.setType(3);
            mediaData2.setPic(this.bYr.bkR());
            this.clF.rY().add(mediaData2);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.j
    protected void aeo() {
        if (this.cae != null) {
            if (this.bYt == null || StringUtils.isNull(this.bYt.pR(), true)) {
                if (this.bYu != null) {
                    this.bYu.setVisibility(8);
                }
                this.clj = true;
                if (this.cae.bkj() == null || this.cae.bkj().pz() == null || (this.cae.bkj().pz().size() <= 0 && this.bYr != null)) {
                    this.clc.setVisibility(8);
                    ArrayList<com.baidu.tbadk.core.data.s> arrayList = new ArrayList<>();
                    String str = "";
                    if (this.cae.aOk() != null && this.cae.aOk().getFrsBannerData() != null) {
                        str = this.cae.aOk().getFrsBannerData().getValue();
                    }
                    com.baidu.tbadk.core.data.s sVar = new com.baidu.tbadk.core.data.s(this.bYr.bkQ(), str, null);
                    sVar.an(true);
                    arrayList.add(sVar);
                    com.baidu.tbadk.core.data.q qVar = new com.baidu.tbadk.core.data.q();
                    qVar.g(arrayList);
                    a(qVar);
                    return;
                }
                this.clc.setVisibility(0);
                a(this.cae.bkj());
                return;
            }
            aeu();
        }
    }

    private void aeu() {
        if (this.bTA != null && this.bYt != null && !StringUtils.isNull(this.bYt.pR(), true)) {
            if (this.bYu == null) {
                this.bYu = (ViewStub) this.Ge.findViewById(r.g.frs_star_cover_info);
            }
            this.bYu.setVisibility(0);
            if (this.bYv == null) {
                this.bYv = (TextView) this.Ge.findViewById(r.g.frs_star_cover_pic_author);
            }
            if (this.bYw == null) {
                this.bYw = (TextView) this.Ge.findViewById(r.g.frs_star_cover_post_author);
            }
            if (this.bYx == null) {
                this.bYx = (ImageView) this.Ge.findViewById(r.g.frs_star_cover_goto_h5);
            }
            this.clj = false;
            if (this.bYt.pN()) {
                this.bYw.setVisibility(4);
            } else {
                this.bYw.setText(String.format(this.Gf.getString(r.j.star_cover_post_author), this.bYt.pP()));
                this.bYw.setVisibility(0);
            }
            if (this.bYt.pO()) {
                this.bYv.setVisibility(4);
            } else {
                this.bYv.setText(String.format(this.Gf.getString(r.j.star_cover_pic_author), this.bYt.pQ()));
                this.bYv.setVisibility(0);
            }
            aev();
            this.bYx.setOnClickListener(new v(this));
            this.clc.setVisibility(8);
            a(this.bYt.pT());
        }
    }

    @Override // com.baidu.tieba.frs.view.c
    public void a(com.baidu.tbadk.core.data.q qVar) {
        super.a(qVar);
        if (this.bYt != null && !StringUtils.isNull(this.bYt.pR(), true)) {
            this.bCZ.setCallback(new w(this));
        }
    }

    private void aev() {
        if (this.bYt != null) {
            if (!this.bYt.pM()) {
                at.k(this.bYx, r.f.btn_frs_toutiao_n);
            } else {
                at.k(this.bYx, r.f.btn_frs_enter_n);
            }
            at.j((View) this.bYv, r.d.cp_cont_i);
            at.j((View) this.bYw, r.d.cp_cont_i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.entelechy.j
    public void aep() {
    }

    @Override // com.baidu.tieba.frs.entelechy.j, com.baidu.tieba.frs.view.c
    public void c(View view, boolean z) {
        TiebaStatic.eventStat(this.bTA.getPageContext().getPageActivity(), "consume_6", "click");
        super.c(view, z);
    }

    @Override // com.baidu.tieba.frs.entelechy.j
    protected void a(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.b(r.j.cancel_text, new x(this));
    }

    @Override // com.baidu.tieba.frs.entelechy.j
    protected void b(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.a(r.j.open_now, new y(this));
    }

    @Override // com.baidu.tieba.frs.entelechy.j
    protected void aek() {
        at.c(this.Ga, r.f.frs_text_color_selector, 1);
        at.k(this.ckL, r.f.frs_star_btn_like);
        this.ckM.setVisibility(8);
        this.Ga.setCompoundDrawablesWithIntrinsicBounds(at.getDrawable(r.f.icon_like_selector), (Drawable) null, (Drawable) null, (Drawable) null);
        at.c(this.ckP, r.f.frs_text_color_selector, 1);
        at.k(this.ckN, r.f.frs_star_btn_like);
        this.ckO.setVisibility(8);
        this.ckP.setCompoundDrawablesWithIntrinsicBounds(at.getDrawable(r.f.icon_star_sign_selector), (Drawable) null, (Drawable) null, (Drawable) null);
    }

    @Override // com.baidu.tieba.frs.entelechy.j, com.baidu.tieba.frs.view.c
    public void setCommonClickListener(View.OnClickListener onClickListener) {
        super.setCommonClickListener(onClickListener);
        this.ckL.setOnClickListener(onClickListener);
        this.ckN.setOnClickListener(onClickListener);
    }

    @Override // com.baidu.tieba.frs.entelechy.j, com.baidu.tieba.frs.view.c
    protected void aem() {
        if (this.clK > 0) {
            if (com.baidu.adp.lib.util.k.K(this.Gf.getPageActivity()) >= 480) {
                this.ckS.setCompoundDrawablesWithIntrinsicBounds(at.getDrawable(r.f.frs_star_bu_selector), (Drawable) null, (Drawable) null, (Drawable) null);
            }
            at.c(this.ckS, r.f.frs_text_color_selector, 1);
            at.k(this.bYs, r.f.frs_star_btn_like);
            this.ckS.setText(String.format(this.Gf.getString(r.j.miss_sign_days), Integer.valueOf(this.clK)));
        } else {
            this.ckS.setCompoundDrawablesWithIntrinsicBounds(at.getDrawable(r.f.icon_sign_blue_d), (Drawable) null, (Drawable) null, (Drawable) null);
            at.k(this.bYs, r.f.btn_frs_signed_bg_selector);
            at.c(this.ckS, r.d.cp_link_tip_a, 1);
            if (this.clJ <= 0) {
                this.ckS.setText(this.Gf.getString(r.j.signed));
            } else {
                this.ckS.setText(String.format(this.Gf.getString(r.j.continuous_sign_days), Integer.valueOf(this.clJ)));
            }
        }
        this.ckR.setVisibility(0);
    }

    @Override // com.baidu.tieba.frs.entelechy.j, com.baidu.tieba.frs.view.c
    protected void aes() {
        this.clx.c(this.ckL, "frs_page");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.entelechy.j
    public void aeq() {
    }

    @Override // com.baidu.tieba.frs.entelechy.j, com.baidu.tieba.frs.view.c
    public void changeSkinType(int i) {
        super.changeSkinType(i);
        if (this.bYt != null && !StringUtils.isNull(this.bYt.pR(), true)) {
            aev();
        }
    }
}
