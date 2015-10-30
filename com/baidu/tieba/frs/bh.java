package com.baidu.tieba.frs;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class bh extends bn<com.baidu.tbadk.core.data.b, bl> {
    private View.OnClickListener aUA;
    private View.OnClickListener aUz;

    /* JADX INFO: Access modifiers changed from: protected */
    public bh(BaseActivity baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
    }

    private void a(boolean z, bl blVar) {
        if (z) {
            com.baidu.tbadk.core.util.an.i((View) blVar.aWd, i.e.frs_praise_btn_bg);
            com.baidu.tbadk.core.util.an.b(blVar.aWd, i.c.cp_cont_f, 1);
            return;
        }
        com.baidu.tbadk.core.util.an.i((View) blVar.aWd, i.e.btn_content_download_d);
        com.baidu.tbadk.core.util.an.b(blVar.aWd, i.c.faceshop_downloaded_text, 1);
    }

    public void h(View.OnClickListener onClickListener) {
        this.aUz = onClickListener;
    }

    public void i(View.OnClickListener onClickListener) {
        this.aUA = onClickListener;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: f */
    public bl a(ViewGroup viewGroup) {
        return new bl(LayoutInflater.from(this.mContext).inflate(i.g.frs_item_app, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bn, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.b bVar, bl blVar) {
        super.a(i, view, viewGroup, (ViewGroup) bVar, (com.baidu.tbadk.core.data.b) blVar);
        if (this.aSe == null) {
            return null;
        }
        if (this.aSe != null && (this.aSe instanceof FrsActivity)) {
            ((FrsActivity) this.aSe).Li().MX();
        }
        blVar.aVZ.setPadding(0, i - this.aTQ == 0 ? this.aSR : this.aSS, 0, 0);
        this.aSe.getLayoutMode().ad(this.mSkinType == 1);
        this.aSe.getLayoutMode().k(view);
        if (bVar instanceof com.baidu.tbadk.core.data.b) {
            if (!bVar.Uk && (this.aSe instanceof FrsActivity)) {
                bVar.Uk = true;
                ((FrsActivity) this.aSe).a(bVar, "show");
                ((FrsActivity) this.aSe).b(bVar, "show");
            }
            blVar.aPq.setText(bVar.Uj.userName);
            blVar.aWc.setText(bVar.Uj.Um);
            if (com.baidu.tbadk.core.m.qU().qY()) {
                blVar.aWb.setVisibility(0);
                blVar.aWb.d(bVar.Uj.userPortrait, this.mIsFromCDN ? 13 : 14, false);
            } else {
                blVar.aWb.setVisibility(8);
            }
            blVar.aWb.setTag(bVar.Uj.userPortrait);
            blVar.aWd.setTag(Integer.valueOf(i));
            com.baidu.tbadk.core.util.an.i((View) blVar.aWa, i.e.bg_label);
            if (bVar.ro()) {
                a(true, blVar);
                if (TextUtils.isEmpty(bVar.Uj.Ut) || TextUtils.isEmpty(bVar.Uj.Ut.trim())) {
                    blVar.aWd.setText(i.h.view);
                } else {
                    blVar.aWd.setText(bVar.Uj.Ut);
                }
                blVar.aWd.setOnClickListener(this.aUz);
                return view;
            } else if (bVar.rn()) {
                switch (bVar.TU) {
                    case 0:
                        if (TextUtils.isEmpty(bVar.Uj.Ut) || TextUtils.isEmpty(bVar.Uj.Ut.trim())) {
                            blVar.aWd.setText(i.h.game_center_download);
                        } else {
                            blVar.aWd.setText(bVar.Uj.Ut);
                        }
                        a(true, blVar);
                        blVar.aWd.setOnClickListener(this.aUA);
                        return view;
                    case 1:
                        a(false, blVar);
                        blVar.aWd.setText(i.h.downloading2);
                        blVar.aWd.setOnClickListener(null);
                        return view;
                    case 2:
                        a(true, blVar);
                        blVar.aWd.setText(i.h.frs_old_style_download_text);
                        blVar.aWd.setOnClickListener(this.aUA);
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
