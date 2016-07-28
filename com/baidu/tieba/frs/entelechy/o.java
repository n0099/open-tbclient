package com.baidu.tieba.frs.entelechy;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.u;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class o extends e {
    private com.baidu.tieba.tbadkCore.o bKc;
    private TextView bKd;

    public o(FrsActivity frsActivity, String str, String str2, int i) {
        super(frsActivity, str, str2, i);
        this.bKc = null;
        if (this.aMh != null) {
            this.aMh.setPadding(0, 0, 0, 0);
        }
        this.bKd = (TextView) this.DP.findViewById(u.g.sign_done_bg);
        this.DP.findViewById(u.g.frs_header_divider).setVisibility(4);
    }

    @Override // com.baidu.tieba.frs.entelechy.e
    protected View XW() {
        return LayoutInflater.from(this.bGh.getPageContext().getPageActivity()).inflate(u.h.frs_star_header, (ViewGroup) null);
    }

    @Override // com.baidu.tieba.frs.entelechy.e, com.baidu.tieba.frs.view.c
    public void a(ForumData forumData, com.baidu.tieba.tbadkCore.p pVar) {
        if (pVar != null) {
            this.bKc = pVar.bdB();
        }
        super.a(forumData, pVar);
        this.mImageUrl = this.bKc.bee();
    }

    @Override // com.baidu.tieba.frs.entelechy.e
    protected void XY() {
        if (this.bKc != null && this.bVt != null) {
            MediaData mediaData = new MediaData();
            mediaData.setType(3);
            mediaData.setPic(this.bKc.bed());
            this.bVt.qF().add(mediaData);
            MediaData mediaData2 = new MediaData();
            mediaData2.setType(3);
            mediaData2.setPic(this.bKc.bee());
            this.bVt.qF().add(mediaData2);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.e
    protected void Yb() {
        if (this.bLD != null) {
            if (this.bLD.bdC() == null || this.bLD.bdC().oz() == null || (this.bLD.bdC().oz().size() <= 0 && this.bKc != null)) {
                this.bUS.setVisibility(8);
                ArrayList<com.baidu.tbadk.core.data.q> arrayList = new ArrayList<>();
                String str = "";
                if (this.bLD.aGX() != null && this.bLD.aGX().getFrsBannerData() != null) {
                    str = this.bLD.aGX().getFrsBannerData().getValue();
                }
                com.baidu.tbadk.core.data.q qVar = new com.baidu.tbadk.core.data.q(this.bKc.bed(), str, null);
                qVar.aj(true);
                arrayList.add(qVar);
                com.baidu.tbadk.core.data.p pVar = new com.baidu.tbadk.core.data.p();
                pVar.g(arrayList);
                a(pVar);
                return;
            }
            this.bUS.setVisibility(0);
            a(this.bLD.bdC());
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.e
    protected void Yd() {
    }

    @Override // com.baidu.tieba.frs.entelechy.e, com.baidu.tieba.frs.view.c
    public void d(View view, boolean z) {
        TiebaStatic.eventStat(this.bGh.getPageContext().getPageActivity(), "consume_6", "click");
        super.d(view, z);
    }

    @Override // com.baidu.tieba.frs.entelechy.e
    protected void b(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.b(u.j.cancel_text, new p(this));
    }

    @Override // com.baidu.tieba.frs.entelechy.e
    protected void c(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.a(u.j.open_now, new q(this));
    }

    @Override // com.baidu.tieba.frs.entelechy.e
    protected void XX() {
        av.c(this.DL, u.f.frs_text_color_selector, 1);
        av.k(this.bUD, u.f.frs_star_btn_like);
        this.bUE.setVisibility(8);
        this.DL.setCompoundDrawablesWithIntrinsicBounds(av.getDrawable(u.f.icon_like_selector), (Drawable) null, (Drawable) null, (Drawable) null);
        av.c(this.bUH, u.f.frs_text_color_selector, 1);
        av.k(this.bUF, u.f.frs_star_btn_like);
        this.bUG.setVisibility(8);
        this.bUH.setCompoundDrawablesWithIntrinsicBounds(av.getDrawable(u.f.icon_star_sign_selector), (Drawable) null, (Drawable) null, (Drawable) null);
    }

    @Override // com.baidu.tieba.frs.entelechy.e, com.baidu.tieba.frs.view.c
    public void setCommonClickListener(View.OnClickListener onClickListener) {
        super.setCommonClickListener(onClickListener);
        this.bUD.setOnClickListener(onClickListener);
        this.bUF.setOnClickListener(onClickListener);
    }

    @Override // com.baidu.tieba.frs.entelechy.e, com.baidu.tieba.frs.view.c
    protected void XZ() {
        if (this.bVy > 0) {
            if (com.baidu.adp.lib.util.k.A(this.DQ.getPageActivity()) >= 480) {
                this.bUK.setCompoundDrawablesWithIntrinsicBounds(av.getDrawable(u.f.frs_star_bu_selector), (Drawable) null, (Drawable) null, (Drawable) null);
            }
            av.c(this.bUK, u.f.frs_text_color_selector, 1);
            av.k(this.bKd, u.f.frs_star_btn_like);
            this.bUK.setText(String.format(this.DQ.getString(u.j.miss_sign_days), Integer.valueOf(this.bVy)));
        } else {
            this.bUK.setCompoundDrawablesWithIntrinsicBounds(av.getDrawable(u.f.icon_sign_blue_d), (Drawable) null, (Drawable) null, (Drawable) null);
            av.k(this.bKd, u.f.btn_frs_signed_bg_selector);
            av.c(this.bUK, u.d.cp_link_tip_a, 1);
            if (this.bVx <= 0) {
                this.bUK.setText(this.DQ.getString(u.j.signed));
            } else {
                this.bUK.setText(String.format(this.DQ.getString(u.j.continuous_sign_days), Integer.valueOf(this.bVx)));
            }
        }
        this.bUJ.setVisibility(0);
    }

    @Override // com.baidu.tieba.frs.entelechy.e, com.baidu.tieba.frs.view.c
    protected void Yh() {
        this.bVl.c(this.bUD, "frs_page");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.entelechy.e
    public void Ye() {
    }
}
