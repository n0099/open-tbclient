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
public class n extends d {
    private com.baidu.tieba.tbadkCore.o bIy;
    private TextView bIz;

    public n(FrsActivity frsActivity, String str, String str2, int i) {
        super(frsActivity, str, str2, i);
        this.bIy = null;
        if (this.aLn != null) {
            this.aLn.setPadding(0, 0, 0, 0);
        }
        this.bIz = (TextView) this.Do.findViewById(u.g.sign_done_bg);
        this.Do.findViewById(u.g.frs_header_divider).setVisibility(4);
    }

    @Override // com.baidu.tieba.frs.entelechy.d
    protected View XD() {
        return LayoutInflater.from(this.bET.getPageContext().getPageActivity()).inflate(u.h.frs_star_header, (ViewGroup) null);
    }

    @Override // com.baidu.tieba.frs.entelechy.d, com.baidu.tieba.frs.view.c
    public void a(ForumData forumData, com.baidu.tieba.tbadkCore.p pVar) {
        if (pVar != null) {
            this.bIy = pVar.ban();
        }
        super.a(forumData, pVar);
        this.mImageUrl = this.bIy.baQ();
    }

    @Override // com.baidu.tieba.frs.entelechy.d
    protected void XF() {
        if (this.bIy != null && this.bTt != null) {
            MediaData mediaData = new MediaData();
            mediaData.setType(3);
            mediaData.setPic(this.bIy.baP());
            this.bTt.getMedias().add(mediaData);
            MediaData mediaData2 = new MediaData();
            mediaData2.setType(3);
            mediaData2.setPic(this.bIy.baQ());
            this.bTt.getMedias().add(mediaData2);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.d
    protected void XI() {
        if (this.bJX != null) {
            if (this.bJX.bao() == null || this.bJX.bao().oK() == null || (this.bJX.bao().oK().size() <= 0 && this.bIy != null)) {
                this.bSS.setVisibility(8);
                ArrayList<com.baidu.tbadk.core.data.p> arrayList = new ArrayList<>();
                String str = "";
                if (this.bJX.aDN() != null && this.bJX.aDN().getFrsBannerData() != null) {
                    str = this.bJX.aDN().getFrsBannerData().getValue();
                }
                com.baidu.tbadk.core.data.p pVar = new com.baidu.tbadk.core.data.p(this.bIy.baP(), str, null);
                pVar.ah(true);
                arrayList.add(pVar);
                com.baidu.tbadk.core.data.o oVar = new com.baidu.tbadk.core.data.o();
                oVar.f(arrayList);
                a(oVar);
                return;
            }
            this.bSS.setVisibility(0);
            a(this.bJX.bao());
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.d
    protected void XK() {
    }

    @Override // com.baidu.tieba.frs.entelechy.d, com.baidu.tieba.frs.view.c
    public void f(View view, boolean z) {
        TiebaStatic.eventStat(this.bET.getPageContext().getPageActivity(), "consume_6", "click");
        super.f(view, z);
    }

    @Override // com.baidu.tieba.frs.entelechy.d
    protected void b(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.b(u.j.cancel_text, new o(this));
    }

    @Override // com.baidu.tieba.frs.entelechy.d
    protected void c(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.a(u.j.open_now, new p(this));
    }

    @Override // com.baidu.tieba.frs.entelechy.d
    protected void XE() {
        av.c(this.Dk, u.f.frs_text_color_selector, 1);
        av.k(this.bSD, u.f.frs_star_btn_like);
        this.bSE.setVisibility(8);
        this.Dk.setCompoundDrawablesWithIntrinsicBounds(av.getDrawable(u.f.icon_like_selector), (Drawable) null, (Drawable) null, (Drawable) null);
        av.c(this.bSH, u.f.frs_text_color_selector, 1);
        av.k(this.bSF, u.f.frs_star_btn_like);
        this.bSG.setVisibility(8);
        this.bSH.setCompoundDrawablesWithIntrinsicBounds(av.getDrawable(u.f.icon_star_sign_selector), (Drawable) null, (Drawable) null, (Drawable) null);
    }

    @Override // com.baidu.tieba.frs.entelechy.d, com.baidu.tieba.frs.view.c
    public void setCommonClickListener(View.OnClickListener onClickListener) {
        super.setCommonClickListener(onClickListener);
        this.bSD.setOnClickListener(onClickListener);
        this.bSF.setOnClickListener(onClickListener);
    }

    @Override // com.baidu.tieba.frs.entelechy.d, com.baidu.tieba.frs.view.c
    protected void XG() {
        if (this.bTy > 0) {
            if (com.baidu.adp.lib.util.k.A(this.Dp.getPageActivity()) >= 480) {
                this.bSK.setCompoundDrawablesWithIntrinsicBounds(av.getDrawable(u.f.frs_star_bu_selector), (Drawable) null, (Drawable) null, (Drawable) null);
            }
            av.c(this.bSK, u.f.frs_text_color_selector, 1);
            av.k(this.bIz, u.f.frs_star_btn_like);
            this.bSK.setText(String.format(this.Dp.getString(u.j.miss_sign_days), Integer.valueOf(this.bTy)));
        } else {
            this.bSK.setCompoundDrawablesWithIntrinsicBounds(av.getDrawable(u.f.icon_sign_blue_d), (Drawable) null, (Drawable) null, (Drawable) null);
            av.k(this.bIz, u.f.btn_frs_signed_bg_selector);
            av.c(this.bSK, u.d.cp_link_tip_a, 1);
            if (this.bTx <= 0) {
                this.bSK.setText(this.Dp.getString(u.j.signed));
            } else {
                this.bSK.setText(String.format(this.Dp.getString(u.j.continuous_sign_days), Integer.valueOf(this.bTx)));
            }
        }
        this.bSJ.setVisibility(0);
    }

    @Override // com.baidu.tieba.frs.entelechy.d, com.baidu.tieba.frs.view.c
    protected void XO() {
        this.bTl.c(this.bSD, "frs_page");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.entelechy.d
    public void XL() {
    }
}
