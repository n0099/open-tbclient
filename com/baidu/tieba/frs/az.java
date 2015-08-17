package com.baidu.tieba.frs;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class az extends bc<com.baidu.tbadk.core.data.c, bb> {
    private View.OnClickListener aVa;
    private View.OnClickListener aVb;

    /* JADX INFO: Access modifiers changed from: protected */
    public az(BaseActivity baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
    }

    public void i(View.OnClickListener onClickListener) {
        this.aVb = onClickListener;
    }

    public void h(View.OnClickListener onClickListener) {
        this.aVa = onClickListener;
    }

    private void a(boolean z, bb bbVar) {
        if (z) {
            com.baidu.tbadk.core.util.al.i((View) bbVar.aWj, i.e.btn_appdownload);
            com.baidu.tbadk.core.util.al.b(bbVar.aWj, i.c.cp_cont_i, 1);
            return;
        }
        com.baidu.tbadk.core.util.al.i((View) bbVar.aWj, i.e.btn_content_download_d);
        com.baidu.tbadk.core.util.al.b(bbVar.aWj, i.c.faceshop_downloaded_text, 1);
    }

    private String gF(String str) {
        if (!TextUtils.isEmpty(str) && str.length() > 14) {
            return str.substring(0, 14);
        }
        return str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: g */
    public bb a(ViewGroup viewGroup) {
        return new bb(LayoutInflater.from(this.mContext).inflate(i.g.frs_item_app_new, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bc, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.c cVar, bb bbVar) {
        super.a(i, view, viewGroup, (ViewGroup) cVar, (com.baidu.tbadk.core.data.c) bbVar);
        if (this.aSJ == null) {
            return null;
        }
        if (this.aSJ != null && (this.aSJ instanceof FrsActivity)) {
            ((FrsActivity) this.aSJ).Lz().Nb();
        }
        bbVar.aWd.setPadding(0, i - this.aWl == 0 ? this.aTw : this.aTx, 0, 0);
        this.aSJ.getLayoutMode().ad(this.mSkinType == 1);
        this.aSJ.getLayoutMode().k(view);
        if (cVar instanceof com.baidu.tbadk.core.data.c) {
            if (!cVar.Uw && this.aSJ != null && (this.aSJ instanceof FrsActivity)) {
                cVar.Uw = true;
                ((FrsActivity) this.aSJ).a(cVar, "show");
                ((FrsActivity) this.aSJ).b(cVar, "show");
            }
            bbVar.aWf.setText(gF(cVar.Uv.userName));
            if (cVar.Uv == null) {
                return null;
            }
            if (TextUtils.isEmpty(cVar.Uv.Uy) || TextUtils.isEmpty(cVar.Uv.Uy.trim())) {
                bbVar.aWh.setVisibility(8);
            } else {
                bbVar.aWh.setVisibility(0);
                bbVar.aWh.setText(cVar.Uv.Uy);
            }
            bbVar.aWg.setText(com.baidu.tbadk.core.util.aq.m(cVar.Uu));
            if (com.baidu.tbadk.core.m.rd().rf()) {
                bbVar.aWe.setVisibility(0);
                bbVar.aWe.d(cVar.Uv.userPortrait, this.mIsFromCDN ? 13 : 14, false);
            } else {
                bbVar.aWe.setVisibility(8);
            }
            bbVar.aWe.setTag(cVar.Uv.userPortrait);
            if (com.baidu.tbadk.core.m.rd().rh() && !TextUtils.isEmpty(cVar.Uv.Uz)) {
                bbVar.aWi.setVisibility(0);
                bbVar.aWi.d(cVar.Uv.Uz, this.mIsFromCDN ? 30 : 31, false);
                bbVar.aWh.setPadding(0, 0, 0, 0);
            } else {
                bbVar.aWi.setVisibility(8);
                bbVar.aWh.setPadding(0, 0, 0, this.mContext.getResources().getDimensionPixelSize(i.d.ds30));
            }
            bbVar.aWj.setTag(Integer.valueOf(i));
            if (cVar.rx()) {
                if (!TextUtils.isEmpty(cVar.Uv.UE) && !TextUtils.isEmpty(cVar.Uv.UE.trim())) {
                    a(true, bbVar);
                    bbVar.aWj.setText(cVar.Uv.UE);
                    bbVar.aWj.setOnClickListener(this.aVa);
                    return view;
                }
                bbVar.aWj.setVisibility(8);
                return view;
            } else if (cVar.rw()) {
                bbVar.aWj.setVisibility(0);
                switch (cVar.Ug) {
                    case 0:
                        if (TextUtils.isEmpty(cVar.Uv.UE) || TextUtils.isEmpty(cVar.Uv.UE.trim())) {
                            bbVar.aWj.setText(i.C0057i.pb_app_download);
                        } else {
                            bbVar.aWj.setText(cVar.Uv.UE);
                        }
                        a(true, bbVar);
                        bbVar.aWj.setOnClickListener(this.aVb);
                        return view;
                    case 1:
                        a(false, bbVar);
                        bbVar.aWj.setText(i.C0057i.downloading2);
                        bbVar.aWj.setOnClickListener(null);
                        return view;
                    case 2:
                        a(true, bbVar);
                        bbVar.aWj.setText(i.C0057i.frs_new_style_download_text);
                        bbVar.aWj.setOnClickListener(this.aVb);
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
