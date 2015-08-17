package com.baidu.tieba.frs;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class ay extends bc<com.baidu.tbadk.core.data.c, ba> {
    private View.OnClickListener aVa;
    private View.OnClickListener aVb;

    /* JADX INFO: Access modifiers changed from: protected */
    public ay(BaseActivity baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
    }

    private void a(boolean z, ba baVar) {
        if (z) {
            com.baidu.tbadk.core.util.al.i((View) baVar.aWc, i.e.frs_praise_btn_bg);
            com.baidu.tbadk.core.util.al.b(baVar.aWc, i.c.cp_cont_f, 1);
            return;
        }
        com.baidu.tbadk.core.util.al.i((View) baVar.aWc, i.e.btn_content_download_d);
        com.baidu.tbadk.core.util.al.b(baVar.aWc, i.c.faceshop_downloaded_text, 1);
    }

    public void h(View.OnClickListener onClickListener) {
        this.aVa = onClickListener;
    }

    public void i(View.OnClickListener onClickListener) {
        this.aVb = onClickListener;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: f */
    public ba a(ViewGroup viewGroup) {
        return new ba(LayoutInflater.from(this.mContext).inflate(i.g.frs_item_app, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bc, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.c cVar, ba baVar) {
        super.a(i, view, viewGroup, (ViewGroup) cVar, (com.baidu.tbadk.core.data.c) baVar);
        if (this.aSJ == null) {
            return null;
        }
        if (this.aSJ != null && (this.aSJ instanceof FrsActivity)) {
            ((FrsActivity) this.aSJ).Lz().Nb();
        }
        baVar.aVY.setPadding(0, i - this.aWl == 0 ? this.aTw : this.aTx, 0, 0);
        this.aSJ.getLayoutMode().ad(this.mSkinType == 1);
        this.aSJ.getLayoutMode().k(view);
        if (cVar instanceof com.baidu.tbadk.core.data.c) {
            if (!cVar.Uw && (this.aSJ instanceof FrsActivity)) {
                cVar.Uw = true;
                ((FrsActivity) this.aSJ).a(cVar, "show");
                ((FrsActivity) this.aSJ).b(cVar, "show");
            }
            baVar.aPV.setText(cVar.Uv.userName);
            baVar.aWb.setText(cVar.Uv.Uy);
            if (com.baidu.tbadk.core.m.rd().rh()) {
                baVar.aWa.setVisibility(0);
                baVar.aWa.d(cVar.Uv.userPortrait, this.mIsFromCDN ? 13 : 14, false);
            } else {
                baVar.aWa.setVisibility(8);
            }
            baVar.aWa.setTag(cVar.Uv.userPortrait);
            baVar.aWc.setTag(Integer.valueOf(i));
            com.baidu.tbadk.core.util.al.i((View) baVar.aVZ, i.e.bg_label);
            if (cVar.rx()) {
                a(true, baVar);
                if (TextUtils.isEmpty(cVar.Uv.UE) || TextUtils.isEmpty(cVar.Uv.UE.trim())) {
                    baVar.aWc.setText(i.C0057i.view);
                } else {
                    baVar.aWc.setText(cVar.Uv.UE);
                }
                baVar.aWc.setOnClickListener(this.aVa);
                return view;
            } else if (cVar.rw()) {
                switch (cVar.Ug) {
                    case 0:
                        if (TextUtils.isEmpty(cVar.Uv.UE) || TextUtils.isEmpty(cVar.Uv.UE.trim())) {
                            baVar.aWc.setText(i.C0057i.game_center_download);
                        } else {
                            baVar.aWc.setText(cVar.Uv.UE);
                        }
                        a(true, baVar);
                        baVar.aWc.setOnClickListener(this.aVb);
                        return view;
                    case 1:
                        a(false, baVar);
                        baVar.aWc.setText(i.C0057i.downloading2);
                        baVar.aWc.setOnClickListener(null);
                        return view;
                    case 2:
                        a(true, baVar);
                        baVar.aWc.setText(i.C0057i.frs_old_style_download_text);
                        baVar.aWc.setOnClickListener(this.aVb);
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
