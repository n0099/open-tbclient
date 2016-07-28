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
    private View.OnClickListener bEC;
    private View.OnClickListener bED;
    private View.OnClickListener bFf;
    private Set<String> bFg;
    private boolean bFh;

    public be(BaseActivity baseActivity, BdUniqueId bdUniqueId, boolean z) {
        super(baseActivity, bdUniqueId);
        this.bFg = new HashSet();
        this.bFh = z;
    }

    private void a(boolean z, bg bgVar) {
        if (z) {
            com.baidu.tbadk.core.util.av.k(bgVar.bFo, u.f.frs_praise_btn_bg);
            com.baidu.tbadk.core.util.av.c(bgVar.bFo, u.d.cp_cont_f, 1);
            return;
        }
        com.baidu.tbadk.core.util.av.k(bgVar.bFo, u.f.btn_content_download_d);
        com.baidu.tbadk.core.util.av.c(bgVar.bFo, u.d.common_color_10172, 1);
    }

    public void m(View.OnClickListener onClickListener) {
        this.bEC = onClickListener;
    }

    public void n(View.OnClickListener onClickListener) {
        this.bED = onClickListener;
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
        if (this.bem == null) {
            return null;
        }
        if (this.bem != null && (this.bem instanceof FrsActivity)) {
            ((FrsActivity) this.bem).VY().Xr();
        }
        if (this.bem != null && (this.bem instanceof dk)) {
            ((dk) this.bem).Xr();
        }
        int i3 = i - this.bDE;
        if (i3 == 0) {
            int i4 = bFC;
        } else {
            int i5 = bFD;
        }
        if (!this.bFh) {
            i2 = bFE;
        } else {
            i2 = i3 == 0 ? bFC : bFD;
        }
        bgVar.bFk.setPadding(0, i2, 0, 0);
        this.bem.getLayoutMode().af(this.mSkinType == 1);
        this.bem.getLayoutMode().w(view);
        if (bVar instanceof b) {
            if (!bVar.MV && (this.bem instanceof FrsActivity)) {
                bVar.MV = true;
                ((FrsActivity) this.bem).a(bVar, "show");
                ((FrsActivity) this.bem).b(bVar, "show");
            }
            if (!bVar.MV && (this.bem instanceof dk)) {
                bVar.MV = true;
                ((dk) this.bem).a(bVar, "show");
                ((dk) this.bem).b(bVar, "show");
            }
            if (bVar.MW) {
                if (bgVar.bFq == null) {
                    bgVar.bFq = (ViewGroup) bgVar.bFp.inflate().findViewById(u.g.frs_item_adkiller_tip);
                    a.a(this.bem.getPageContext(), bgVar.bFq);
                }
                bgVar.bFq.setVisibility(0);
                bgVar.bFq.setOnClickListener(new bf(this, bVar));
                if (!this.bFg.contains(bVar.MY)) {
                    this.bFg.add(bVar.MY);
                    com.baidu.tbadk.core.util.ay ayVar = new com.baidu.tbadk.core.util.ay("c10828");
                    ayVar.ab("obj_id", new StringBuilder(String.valueOf(bVar.getFid())).toString());
                    TiebaStatic.log(ayVar);
                }
            } else if (bgVar.bFq != null) {
                bgVar.bFq.setVisibility(8);
            }
            if (bVar.MZ) {
                if (bgVar.bFs == null) {
                    bgVar.bFs = (ViewGroup) bgVar.bFr.inflate().findViewById(u.g.item_adkiller_close);
                    a.a(this.bem.getPageContext(), bgVar.bFs);
                }
                bgVar.bFs.setVisibility(0);
                bgVar.bFs.setOnClickListener(this.bFf);
                bgVar.bFs.setTag(Integer.valueOf(i));
            } else if (bgVar.bFs != null) {
                bgVar.bFs.setVisibility(8);
            }
            bgVar.aSZ.setText(bVar.MU.userName);
            bgVar.bFn.setText(bVar.MU.Nc);
            if (com.baidu.tbadk.core.l.nL().nR()) {
                bgVar.bFm.setVisibility(0);
                bgVar.bFm.c(bVar.MU.userPortrait, this.mIsFromCDN ? 13 : 14, false);
            } else {
                bgVar.bFm.setVisibility(8);
            }
            bgVar.bFm.setTag(bVar.MU.userPortrait);
            bgVar.bFo.setTag(Integer.valueOf(i));
            com.baidu.tbadk.core.util.av.k(bgVar.bFl, u.f.bg_label);
            if (bVar.om()) {
                a(true, bgVar);
                if (TextUtils.isEmpty(bVar.MU.FG) || TextUtils.isEmpty(bVar.MU.FG.trim())) {
                    bgVar.bFo.setText(u.j.view);
                } else {
                    bgVar.bFo.setText(bVar.MU.FG);
                }
                bgVar.bFo.setOnClickListener(this.bEC);
                return view;
            } else if (bVar.ol()) {
                switch (bVar.MD) {
                    case 0:
                        if (TextUtils.isEmpty(bVar.MU.FG) || TextUtils.isEmpty(bVar.MU.FG.trim())) {
                            bgVar.bFo.setText(u.j.game_center_download);
                        } else {
                            bgVar.bFo.setText(bVar.MU.FG);
                        }
                        a(true, bgVar);
                        bgVar.bFo.setOnClickListener(this.bED);
                        return view;
                    case 1:
                        a(false, bgVar);
                        bgVar.bFo.setText(u.j.downloading2);
                        bgVar.bFo.setOnClickListener(null);
                        return view;
                    case 2:
                        a(true, bgVar);
                        bgVar.bFo.setText(u.j.frs_old_style_download_text);
                        bgVar.bFo.setOnClickListener(this.bED);
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
