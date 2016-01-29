package com.baidu.tieba.frs;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.t;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes.dex */
public class bl extends bv<com.baidu.tbadk.core.data.c, bs> {
    private View.OnClickListener bgm;
    private View.OnClickListener bgn;
    private View.OnClickListener bgo;
    private Set<String> bhF;

    /* JADX INFO: Access modifiers changed from: protected */
    public bl(BaseActivity baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
        this.bhF = new HashSet();
    }

    private void a(boolean z, bs bsVar) {
        if (z) {
            com.baidu.tbadk.core.util.ar.k(bsVar.bih, t.f.frs_praise_btn_bg);
            com.baidu.tbadk.core.util.ar.b(bsVar.bih, t.d.cp_cont_f, 1);
            return;
        }
        com.baidu.tbadk.core.util.ar.k(bsVar.bih, t.f.btn_content_download_d);
        com.baidu.tbadk.core.util.ar.b(bsVar.bih, t.d.faceshop_downloaded_text, 1);
    }

    public void l(View.OnClickListener onClickListener) {
        this.bgm = onClickListener;
    }

    public void m(View.OnClickListener onClickListener) {
        this.bgn = onClickListener;
    }

    public void n(View.OnClickListener onClickListener) {
        this.bgo = onClickListener;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: q */
    public bs b(ViewGroup viewGroup) {
        return new bs(LayoutInflater.from(this.mContext).inflate(t.h.frs_item_app, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bv, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.c cVar, bs bsVar) {
        super.a(i, view, viewGroup, (ViewGroup) cVar, (com.baidu.tbadk.core.data.c) bsVar);
        if (this.bdK == null) {
            return null;
        }
        if (this.bdK != null && (this.bdK instanceof FrsActivity)) {
            ((FrsActivity) this.bdK).Po().Rr();
        }
        bsVar.bib.setPadding(0, i - this.bfz == 0 ? this.beB : this.beC, 0, 0);
        this.bdK.getLayoutMode().ac(this.mSkinType == 1);
        this.bdK.getLayoutMode().x(view);
        if (cVar instanceof com.baidu.tbadk.core.data.c) {
            if (!cVar.UJ && (this.bdK instanceof FrsActivity)) {
                cVar.UJ = true;
                ((FrsActivity) this.bdK).a(cVar, "show");
                ((FrsActivity) this.bdK).b(cVar, "show");
            }
            if (cVar.UK) {
                if (bsVar.bhW == null) {
                    bsVar.bhW = (ViewGroup) bsVar.bhV.inflate().findViewById(t.g.frs_item_adkiller_tip);
                    com.baidu.tbadk.i.a.a(this.bdK.getPageContext(), bsVar.bhW);
                }
                bsVar.bhW.setVisibility(0);
                bsVar.bhW.setOnClickListener(new bm(this, cVar));
                if (!this.bhF.contains(cVar.UM)) {
                    this.bhF.add(cVar.UM);
                    com.baidu.tbadk.core.util.au auVar = new com.baidu.tbadk.core.util.au("c10828");
                    auVar.aa("obj_id", new StringBuilder(String.valueOf(cVar.getFid())).toString());
                    TiebaStatic.log(auVar);
                }
            } else if (bsVar.bhW != null) {
                bsVar.bhW.setVisibility(8);
            }
            if (cVar.UN) {
                if (bsVar.bhY == null) {
                    bsVar.bhY = (ViewGroup) bsVar.bhX.inflate().findViewById(t.g.item_adkiller_close);
                    com.baidu.tbadk.i.a.a(this.bdK.getPageContext(), bsVar.bhY);
                }
                bsVar.bhY.setVisibility(0);
                bsVar.bhY.setOnClickListener(this.bgo);
                bsVar.bhY.setTag(Integer.valueOf(i));
            } else if (bsVar.bhY != null) {
                bsVar.bhY.setVisibility(8);
            }
            bsVar.aPr.setText(cVar.UI.userName);
            bsVar.bif.setText(cVar.UI.UQ);
            if (com.baidu.tbadk.core.l.rn().rt()) {
                bsVar.bie.setVisibility(0);
                bsVar.bie.d(cVar.UI.userPortrait, this.mIsFromCDN ? 13 : 14, false);
            } else {
                bsVar.bie.setVisibility(8);
            }
            bsVar.bie.setTag(cVar.UI.userPortrait);
            bsVar.bih.setTag(Integer.valueOf(i));
            com.baidu.tbadk.core.util.ar.k(bsVar.bic, t.f.bg_label);
            if (cVar.rO()) {
                a(true, bsVar);
                if (TextUtils.isEmpty(cVar.UI.OC) || TextUtils.isEmpty(cVar.UI.OC.trim())) {
                    bsVar.bih.setText(t.j.view);
                } else {
                    bsVar.bih.setText(cVar.UI.OC);
                }
                bsVar.bih.setOnClickListener(this.bgm);
                return view;
            } else if (cVar.rN()) {
                switch (cVar.Us) {
                    case 0:
                        if (TextUtils.isEmpty(cVar.UI.OC) || TextUtils.isEmpty(cVar.UI.OC.trim())) {
                            bsVar.bih.setText(t.j.game_center_download);
                        } else {
                            bsVar.bih.setText(cVar.UI.OC);
                        }
                        a(true, bsVar);
                        bsVar.bih.setOnClickListener(this.bgn);
                        return view;
                    case 1:
                        a(false, bsVar);
                        bsVar.bih.setText(t.j.downloading2);
                        bsVar.bih.setOnClickListener(null);
                        return view;
                    case 2:
                        a(true, bsVar);
                        bsVar.bih.setText(t.j.frs_old_style_download_text);
                        bsVar.bih.setOnClickListener(this.bgn);
                        return view;
                    default:
                        return view;
                }
            } else {
                return view;
            }
        }
        return view;
    }
}
