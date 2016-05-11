package com.baidu.tieba.frs.entelechy;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.view.FrsHeaderView;
import com.baidu.tieba.t;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class n extends d {
    private com.baidu.tieba.tbadkCore.n boa;
    private TextView bob;

    public n(FrsActivity frsActivity, FrsHeaderView.PAGE page, String str, String str2, int i) {
        super(frsActivity, page, str, str2, i);
        this.boa = null;
        if (this.aHR != null) {
            this.aHR.setPadding(0, 0, 0, 0);
        }
        this.bob = (TextView) this.Dn.findViewById(t.g.sign_done_bg);
        this.Dn.findViewById(t.g.frs_header_divider).setVisibility(4);
    }

    @Override // com.baidu.tieba.frs.entelechy.d
    protected View Si() {
        return LayoutInflater.from(this.bjB.getPageContext().getPageActivity()).inflate(t.h.frs_star_header, (ViewGroup) null);
    }

    @Override // com.baidu.tieba.frs.entelechy.d, com.baidu.tieba.frs.view.c
    public void a(ForumData forumData, com.baidu.tieba.tbadkCore.o oVar) {
        if (oVar != null) {
            this.boa = oVar.aSa();
        }
        super.a(forumData, oVar);
        this.mImageUrl = this.boa.aSB();
    }

    @Override // com.baidu.tieba.frs.entelechy.d
    protected void Sk() {
        if (this.boa != null && this.bvI != null) {
            MediaData mediaData = new MediaData();
            mediaData.setType(3);
            mediaData.setPic(this.boa.aSA());
            this.bvI.getMedias().add(mediaData);
            MediaData mediaData2 = new MediaData();
            mediaData2.setType(3);
            mediaData2.setPic(this.boa.aSB());
            this.bvI.getMedias().add(mediaData2);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.d
    protected void Sn() {
        if (this.bpp != null) {
            if (this.bpp.aSb() == null || this.bpp.aSb().oS() == null || (this.bpp.aSb().oS().size() <= 0 && this.boa != null)) {
                this.bvl.setVisibility(8);
                ArrayList<com.baidu.tbadk.core.data.n> arrayList = new ArrayList<>();
                String str = "";
                if (this.bpp.avA() != null && this.bpp.avA().getFrsBannerData() != null) {
                    str = this.bpp.avA().getFrsBannerData().getValue();
                }
                com.baidu.tbadk.core.data.n nVar = new com.baidu.tbadk.core.data.n(this.boa.aSA(), str, null);
                nVar.aj(true);
                arrayList.add(nVar);
                com.baidu.tbadk.core.data.m mVar = new com.baidu.tbadk.core.data.m();
                mVar.f(arrayList);
                a(mVar);
                return;
            }
            this.bvl.setVisibility(0);
            a(this.bpp.aSb());
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.d
    protected void Sp() {
    }

    @Override // com.baidu.tieba.frs.entelechy.d, com.baidu.tieba.frs.view.c
    public void f(View view, boolean z) {
        TiebaStatic.eventStat(this.bjB.getPageContext().getPageActivity(), "consume_6", "click");
        super.f(view, z);
    }

    @Override // com.baidu.tieba.frs.entelechy.d
    protected void b(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.b(t.j.cancel_text, new o(this));
    }

    @Override // com.baidu.tieba.frs.entelechy.d
    protected void c(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.a(t.j.open_now, new p(this));
    }

    @Override // com.baidu.tieba.frs.entelechy.d
    protected void Sj() {
        at.c(this.Dj, t.f.frs_text_color_selector, 1);
        at.k(this.buS, t.f.frs_star_btn_like);
        this.buT.setVisibility(8);
        this.Dj.setCompoundDrawablesWithIntrinsicBounds(at.getDrawable(t.f.icon_like_selector), (Drawable) null, (Drawable) null, (Drawable) null);
        at.c(this.buW, t.f.frs_text_color_selector, 1);
        at.k(this.buU, t.f.frs_star_btn_like);
        this.buV.setVisibility(8);
        this.buW.setCompoundDrawablesWithIntrinsicBounds(at.getDrawable(t.f.icon_star_sign_selector), (Drawable) null, (Drawable) null, (Drawable) null);
    }

    @Override // com.baidu.tieba.frs.entelechy.d, com.baidu.tieba.frs.view.c
    public void setCommonClickListener(View.OnClickListener onClickListener) {
        super.setCommonClickListener(onClickListener);
        this.buS.setOnClickListener(onClickListener);
        this.buU.setOnClickListener(onClickListener);
    }

    @Override // com.baidu.tieba.frs.entelechy.d, com.baidu.tieba.frs.view.c
    protected void Sl() {
        if (this.bvN > 0) {
            if (com.baidu.adp.lib.util.k.B(this.Do.getPageActivity()) >= 480) {
                this.buZ.setCompoundDrawablesWithIntrinsicBounds(at.getDrawable(t.f.frs_star_bu_selector), (Drawable) null, (Drawable) null, (Drawable) null);
            }
            at.c(this.buZ, t.f.frs_text_color_selector, 1);
            at.k(this.bob, t.f.frs_star_btn_like);
            this.buZ.setText(String.format(this.Do.getString(t.j.miss_sign_days), Integer.valueOf(this.bvN)));
        } else {
            this.buZ.setCompoundDrawablesWithIntrinsicBounds(at.getDrawable(t.f.icon_sign_blue_d), (Drawable) null, (Drawable) null, (Drawable) null);
            at.k(this.bob, t.f.btn_frs_signed_bg_selector);
            at.c(this.buZ, t.d.cp_link_tip_a, 1);
            if (this.bvM <= 0) {
                this.buZ.setText(this.Do.getString(t.j.signed));
            } else {
                this.buZ.setText(String.format(this.Do.getString(t.j.continuous_sign_days), Integer.valueOf(this.bvM)));
            }
        }
        this.buY.setVisibility(0);
    }

    @Override // com.baidu.tieba.frs.entelechy.d, com.baidu.tieba.frs.view.c
    protected void St() {
        this.bvA.c(this.buS, "frs_page");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.entelechy.d
    public void Sq() {
    }
}
