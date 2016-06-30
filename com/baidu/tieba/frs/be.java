package com.baidu.tieba.frs;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.data.b;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.j.a;
import com.baidu.tieba.u;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes.dex */
public class be extends bj<b, bg> {
    private View.OnClickListener bDV;
    private Set<String> bDW;
    private boolean bDX;
    private View.OnClickListener bDt;
    private View.OnClickListener bDu;

    public be(BaseActivity baseActivity, BdUniqueId bdUniqueId, boolean z) {
        super(baseActivity, bdUniqueId);
        this.bDW = new HashSet();
        this.bDX = z;
    }

    private void a(boolean z, bg bgVar) {
        if (z) {
            com.baidu.tbadk.core.util.av.k(bgVar.bEe, u.f.frs_praise_btn_bg);
            com.baidu.tbadk.core.util.av.c(bgVar.bEe, u.d.cp_cont_f, 1);
            return;
        }
        com.baidu.tbadk.core.util.av.k(bgVar.bEe, u.f.btn_content_download_d);
        com.baidu.tbadk.core.util.av.c(bgVar.bEe, u.d.common_color_10172, 1);
    }

    public void m(View.OnClickListener onClickListener) {
        this.bDt = onClickListener;
    }

    public void n(View.OnClickListener onClickListener) {
        this.bDu = onClickListener;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: q */
    public bg a(ViewGroup viewGroup) {
        return new bg(LayoutInflater.from(this.mContext).inflate(u.h.frs_item_app, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bj, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, b bVar, bg bgVar) {
        int i2;
        super.a(i, view, viewGroup, (ViewGroup) bVar, (b) bgVar);
        if (this.bkc == null) {
            return null;
        }
        if (this.bkc != null && (this.bkc instanceof FrsActivity)) {
            ((FrsActivity) this.bkc).VG().WZ();
        }
        if (this.bkc != null && (this.bkc instanceof dk)) {
            ((dk) this.bkc).WZ();
        }
        int i3 = i - this.bCx;
        if (i3 == 0) {
            int i4 = bBz;
        } else {
            int i5 = bBA;
        }
        if (!this.bDX) {
            i2 = bEs;
        } else {
            i2 = i3 == 0 ? bBz : bBA;
        }
        bgVar.bEa.setPadding(0, i2, 0, 0);
        this.bkc.getLayoutMode().ad(this.mSkinType == 1);
        this.bkc.getLayoutMode().w(view);
        if (bVar instanceof b) {
            if (!bVar.MX && (this.bkc instanceof FrsActivity)) {
                bVar.MX = true;
                ((FrsActivity) this.bkc).a(bVar, "show");
                ((FrsActivity) this.bkc).b(bVar, "show");
            }
            if (!bVar.MX && (this.bkc instanceof dk)) {
                bVar.MX = true;
                ((dk) this.bkc).a(bVar, "show");
                ((dk) this.bkc).b(bVar, "show");
            }
            if (bVar.MY) {
                if (bgVar.bEg == null) {
                    bgVar.bEg = (ViewGroup) bgVar.bEf.inflate().findViewById(u.g.frs_item_adkiller_tip);
                    a.a(this.bkc.getPageContext(), bgVar.bEg);
                }
                bgVar.bEg.setVisibility(0);
                bgVar.bEg.setOnClickListener(new bf(this, bVar));
                if (!this.bDW.contains(bVar.Na)) {
                    this.bDW.add(bVar.Na);
                    com.baidu.tbadk.core.util.ay ayVar = new com.baidu.tbadk.core.util.ay("c10828");
                    ayVar.ab("obj_id", new StringBuilder(String.valueOf(bVar.getFid())).toString());
                    TiebaStatic.log(ayVar);
                }
            } else if (bgVar.bEg != null) {
                bgVar.bEg.setVisibility(8);
            }
            if (bVar.Nb) {
                if (bgVar.bEi == null) {
                    bgVar.bEi = (ViewGroup) bgVar.bEh.inflate().findViewById(u.g.item_adkiller_close);
                    a.a(this.bkc.getPageContext(), bgVar.bEi);
                }
                bgVar.bEi.setVisibility(0);
                bgVar.bEi.setOnClickListener(this.bDV);
                bgVar.bEi.setTag(Integer.valueOf(i));
            } else if (bgVar.bEi != null) {
                bgVar.bEi.setVisibility(8);
            }
            bgVar.aSd.setText(bVar.MW.userName);
            bgVar.bEd.setText(bVar.MW.Ne);
            if (com.baidu.tbadk.core.l.nW().oc()) {
                bgVar.bEc.setVisibility(0);
                bgVar.bEc.c(bVar.MW.userPortrait, this.mIsFromCDN ? 13 : 14, false);
            } else {
                bgVar.bEc.setVisibility(8);
            }
            bgVar.bEc.setTag(bVar.MW.userPortrait);
            bgVar.bEe.setTag(Integer.valueOf(i));
            com.baidu.tbadk.core.util.av.k(bgVar.bEb, u.f.bg_label);
            if (bVar.ox()) {
                a(true, bgVar);
                if (TextUtils.isEmpty(bVar.MW.Fg) || TextUtils.isEmpty(bVar.MW.Fg.trim())) {
                    bgVar.bEe.setText(u.j.view);
                } else {
                    bgVar.bEe.setText(bVar.MW.Fg);
                }
                bgVar.bEe.setOnClickListener(this.bDt);
                return view;
            } else if (bVar.ow()) {
                switch (bVar.MF) {
                    case 0:
                        if (TextUtils.isEmpty(bVar.MW.Fg) || TextUtils.isEmpty(bVar.MW.Fg.trim())) {
                            bgVar.bEe.setText(u.j.game_center_download);
                        } else {
                            bgVar.bEe.setText(bVar.MW.Fg);
                        }
                        a(true, bgVar);
                        bgVar.bEe.setOnClickListener(this.bDu);
                        return view;
                    case 1:
                        a(false, bgVar);
                        bgVar.bEe.setText(u.j.downloading2);
                        bgVar.bEe.setOnClickListener(null);
                        return view;
                    case 2:
                        a(true, bgVar);
                        bgVar.bEe.setText(u.j.frs_old_style_download_text);
                        bgVar.bEe.setOnClickListener(this.bDu);
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
