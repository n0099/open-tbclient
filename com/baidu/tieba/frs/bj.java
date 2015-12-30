package com.baidu.tieba.frs;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class bj extends bp<com.baidu.tbadk.core.data.b, bn> {
    private View.OnClickListener bdS;
    private View.OnClickListener bdT;

    /* JADX INFO: Access modifiers changed from: protected */
    public bj(BaseActivity baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
    }

    private void a(boolean z, bn bnVar) {
        if (z) {
            com.baidu.tbadk.core.util.as.i((View) bnVar.bfA, n.f.frs_praise_btn_bg);
            com.baidu.tbadk.core.util.as.b(bnVar.bfA, n.d.cp_cont_f, 1);
            return;
        }
        com.baidu.tbadk.core.util.as.i((View) bnVar.bfA, n.f.btn_content_download_d);
        com.baidu.tbadk.core.util.as.b(bnVar.bfA, n.d.faceshop_downloaded_text, 1);
    }

    public void h(View.OnClickListener onClickListener) {
        this.bdS = onClickListener;
    }

    public void i(View.OnClickListener onClickListener) {
        this.bdT = onClickListener;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: p */
    public bn a(ViewGroup viewGroup) {
        return new bn(LayoutInflater.from(this.mContext).inflate(n.h.frs_item_app, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bp, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.b bVar, bn bnVar) {
        super.a(i, view, viewGroup, (ViewGroup) bVar, (com.baidu.tbadk.core.data.b) bnVar);
        if (this.bbA == null) {
            return null;
        }
        if (this.bbA != null && (this.bbA instanceof FrsActivity)) {
            ((FrsActivity) this.bbA).Nr().Pn();
        }
        bnVar.bfw.setPadding(0, i - this.bdi == 0 ? this.bcm : this.bcn, 0, 0);
        this.bbA.getLayoutMode().ac(this.mSkinType == 1);
        this.bbA.getLayoutMode().k(view);
        if (bVar instanceof com.baidu.tbadk.core.data.b) {
            if (!bVar.Vc && (this.bbA instanceof FrsActivity)) {
                bVar.Vc = true;
                ((FrsActivity) this.bbA).a(bVar, "show");
                ((FrsActivity) this.bbA).b(bVar, "show");
            }
            bnVar.aOn.setText(bVar.Vb.userName);
            bnVar.bfz.setText(bVar.Vb.Ve);
            if (com.baidu.tbadk.core.m.qQ().qW()) {
                bnVar.bfy.setVisibility(0);
                bnVar.bfy.d(bVar.Vb.userPortrait, this.mIsFromCDN ? 13 : 14, false);
            } else {
                bnVar.bfy.setVisibility(8);
            }
            bnVar.bfy.setTag(bVar.Vb.userPortrait);
            bnVar.bfA.setTag(Integer.valueOf(i));
            com.baidu.tbadk.core.util.as.i((View) bnVar.bfx, n.f.bg_label);
            if (bVar.rm()) {
                a(true, bnVar);
                if (TextUtils.isEmpty(bVar.Vb.Vl) || TextUtils.isEmpty(bVar.Vb.Vl.trim())) {
                    bnVar.bfA.setText(n.j.view);
                } else {
                    bnVar.bfA.setText(bVar.Vb.Vl);
                }
                bnVar.bfA.setOnClickListener(this.bdS);
                return view;
            } else if (bVar.rl()) {
                switch (bVar.UL) {
                    case 0:
                        if (TextUtils.isEmpty(bVar.Vb.Vl) || TextUtils.isEmpty(bVar.Vb.Vl.trim())) {
                            bnVar.bfA.setText(n.j.game_center_download);
                        } else {
                            bnVar.bfA.setText(bVar.Vb.Vl);
                        }
                        a(true, bnVar);
                        bnVar.bfA.setOnClickListener(this.bdT);
                        return view;
                    case 1:
                        a(false, bnVar);
                        bnVar.bfA.setText(n.j.downloading2);
                        bnVar.bfA.setOnClickListener(null);
                        return view;
                    case 2:
                        a(true, bnVar);
                        bnVar.bfA.setText(n.j.frs_old_style_download_text);
                        bnVar.bfA.setOnClickListener(this.bdT);
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
