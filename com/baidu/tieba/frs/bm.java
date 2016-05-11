package com.baidu.tieba.frs;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.i.a;
import com.baidu.tieba.t;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes.dex */
public class bm extends bw<com.baidu.tbadk.core.data.c, bt> {
    private Set<String> bhO;
    private boolean bhP;
    private View.OnClickListener bhd;
    private View.OnClickListener bhe;
    private View.OnClickListener bhf;

    public bm(BaseActivity baseActivity, BdUniqueId bdUniqueId, boolean z) {
        super(baseActivity, bdUniqueId);
        this.bhO = new HashSet();
        this.bhP = z;
    }

    private void a(boolean z, bt btVar) {
        if (z) {
            com.baidu.tbadk.core.util.at.k(btVar.bir, t.f.frs_praise_btn_bg);
            com.baidu.tbadk.core.util.at.c(btVar.bir, t.d.cp_cont_f, 1);
            return;
        }
        com.baidu.tbadk.core.util.at.k(btVar.bir, t.f.btn_content_download_d);
        com.baidu.tbadk.core.util.at.c(btVar.bir, t.d.faceshop_downloaded_text, 1);
    }

    public void l(View.OnClickListener onClickListener) {
        this.bhd = onClickListener;
    }

    public void m(View.OnClickListener onClickListener) {
        this.bhe = onClickListener;
    }

    public void n(View.OnClickListener onClickListener) {
        this.bhf = onClickListener;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: k */
    public bt b(ViewGroup viewGroup) {
        return new bt(LayoutInflater.from(this.mContext).inflate(t.h.frs_item_app, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bw, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.c cVar, bt btVar) {
        int i2;
        super.a(i, view, viewGroup, (ViewGroup) cVar, (com.baidu.tbadk.core.data.c) btVar);
        if (this.bek == null) {
            return null;
        }
        if (this.bek != null && (this.bek instanceof FrsActivity)) {
            ((FrsActivity) this.bek).Qd().RF();
        }
        if (this.bek != null && (this.bek instanceof ff)) {
            ((ff) this.bek).RF();
        }
        int i3 = i - this.bgj;
        if (i3 == 0) {
            int i4 = this.bfn;
        } else {
            int i5 = this.bfo;
        }
        if (!this.bhP) {
            i2 = this.biw;
        } else {
            i2 = i3 == 0 ? this.bfn : this.bfo;
        }
        btVar.bin.setPadding(0, i2, 0, 0);
        this.bek.getLayoutMode().ae(this.mSkinType == 1);
        this.bek.getLayoutMode().x(view);
        if (cVar instanceof com.baidu.tbadk.core.data.c) {
            if (!cVar.Nc && (this.bek instanceof FrsActivity)) {
                cVar.Nc = true;
                ((FrsActivity) this.bek).a(cVar, "show");
                ((FrsActivity) this.bek).b(cVar, "show");
            }
            if (!cVar.Nc && (this.bek instanceof ff)) {
                cVar.Nc = true;
                ((ff) this.bek).a(cVar, "show");
                ((ff) this.bek).b(cVar, "show");
            }
            if (cVar.Nd) {
                if (btVar.bii == null) {
                    btVar.bii = (ViewGroup) btVar.bih.inflate().findViewById(t.g.frs_item_adkiller_tip);
                    a.a(this.bek.getPageContext(), btVar.bii);
                }
                btVar.bii.setVisibility(0);
                btVar.bii.setOnClickListener(new bn(this, cVar));
                if (!this.bhO.contains(cVar.Nf)) {
                    this.bhO.add(cVar.Nf);
                    com.baidu.tbadk.core.util.aw awVar = new com.baidu.tbadk.core.util.aw("c10828");
                    awVar.ac("obj_id", new StringBuilder(String.valueOf(cVar.getFid())).toString());
                    TiebaStatic.log(awVar);
                }
            } else if (btVar.bii != null) {
                btVar.bii.setVisibility(8);
            }
            if (cVar.Ng) {
                if (btVar.bik == null) {
                    btVar.bik = (ViewGroup) btVar.bij.inflate().findViewById(t.g.item_adkiller_close);
                    a.a(this.bek.getPageContext(), btVar.bik);
                }
                btVar.bik.setVisibility(0);
                btVar.bik.setOnClickListener(this.bhf);
                btVar.bik.setTag(Integer.valueOf(i));
            } else if (btVar.bik != null) {
                btVar.bik.setVisibility(8);
            }
            btVar.aOG.setText(cVar.Nb.userName);
            btVar.biq.setText(cVar.Nb.Ni);
            if (com.baidu.tbadk.core.l.ob().oh()) {
                btVar.bip.setVisibility(0);
                btVar.bip.c(cVar.Nb.userPortrait, this.mIsFromCDN ? 13 : 14, false);
            } else {
                btVar.bip.setVisibility(8);
            }
            btVar.bip.setTag(cVar.Nb.userPortrait);
            btVar.bir.setTag(Integer.valueOf(i));
            com.baidu.tbadk.core.util.at.k(btVar.bio, t.f.bg_label);
            if (cVar.oH()) {
                a(true, btVar);
                if (TextUtils.isEmpty(cVar.Nb.EZ) || TextUtils.isEmpty(cVar.Nb.EZ.trim())) {
                    btVar.bir.setText(t.j.view);
                } else {
                    btVar.bir.setText(cVar.Nb.EZ);
                }
                btVar.bir.setOnClickListener(this.bhd);
                return view;
            } else if (cVar.oG()) {
                switch (cVar.MM) {
                    case 0:
                        if (TextUtils.isEmpty(cVar.Nb.EZ) || TextUtils.isEmpty(cVar.Nb.EZ.trim())) {
                            btVar.bir.setText(t.j.game_center_download);
                        } else {
                            btVar.bir.setText(cVar.Nb.EZ);
                        }
                        a(true, btVar);
                        btVar.bir.setOnClickListener(this.bhe);
                        return view;
                    case 1:
                        a(false, btVar);
                        btVar.bir.setText(t.j.downloading2);
                        btVar.bir.setOnClickListener(null);
                        return view;
                    case 2:
                        a(true, btVar);
                        btVar.bir.setText(t.j.frs_old_style_download_text);
                        btVar.bir.setOnClickListener(this.bhe);
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
