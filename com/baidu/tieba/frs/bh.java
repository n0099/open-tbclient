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
    private View.OnClickListener aUH;
    private View.OnClickListener aUI;

    /* JADX INFO: Access modifiers changed from: protected */
    public bh(BaseActivity baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
    }

    private void a(boolean z, bl blVar) {
        if (z) {
            com.baidu.tbadk.core.util.an.i((View) blVar.aWl, i.e.frs_praise_btn_bg);
            com.baidu.tbadk.core.util.an.b(blVar.aWl, i.c.cp_cont_f, 1);
            return;
        }
        com.baidu.tbadk.core.util.an.i((View) blVar.aWl, i.e.btn_content_download_d);
        com.baidu.tbadk.core.util.an.b(blVar.aWl, i.c.faceshop_downloaded_text, 1);
    }

    public void h(View.OnClickListener onClickListener) {
        this.aUH = onClickListener;
    }

    public void i(View.OnClickListener onClickListener) {
        this.aUI = onClickListener;
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
        if (this.aSm == null) {
            return null;
        }
        if (this.aSm != null && (this.aSm instanceof FrsActivity)) {
            ((FrsActivity) this.aSm).Ly().Np();
        }
        blVar.aWh.setPadding(0, i - this.aTY == 0 ? this.aSZ : this.aTa, 0, 0);
        this.aSm.getLayoutMode().ad(this.mSkinType == 1);
        this.aSm.getLayoutMode().k(view);
        if (bVar instanceof com.baidu.tbadk.core.data.b) {
            if (!bVar.Ul && (this.aSm instanceof FrsActivity)) {
                bVar.Ul = true;
                ((FrsActivity) this.aSm).a(bVar, "show");
                ((FrsActivity) this.aSm).b(bVar, "show");
            }
            blVar.aPy.setText(bVar.Uk.userName);
            blVar.aWk.setText(bVar.Uk.Un);
            if (com.baidu.tbadk.core.m.qV().qZ()) {
                blVar.aWj.setVisibility(0);
                blVar.aWj.d(bVar.Uk.userPortrait, this.mIsFromCDN ? 13 : 14, false);
            } else {
                blVar.aWj.setVisibility(8);
            }
            blVar.aWj.setTag(bVar.Uk.userPortrait);
            blVar.aWl.setTag(Integer.valueOf(i));
            com.baidu.tbadk.core.util.an.i((View) blVar.aWi, i.e.bg_label);
            if (bVar.rp()) {
                a(true, blVar);
                if (TextUtils.isEmpty(bVar.Uk.Uu) || TextUtils.isEmpty(bVar.Uk.Uu.trim())) {
                    blVar.aWl.setText(i.h.view);
                } else {
                    blVar.aWl.setText(bVar.Uk.Uu);
                }
                blVar.aWl.setOnClickListener(this.aUH);
                return view;
            } else if (bVar.ro()) {
                switch (bVar.TV) {
                    case 0:
                        if (TextUtils.isEmpty(bVar.Uk.Uu) || TextUtils.isEmpty(bVar.Uk.Uu.trim())) {
                            blVar.aWl.setText(i.h.game_center_download);
                        } else {
                            blVar.aWl.setText(bVar.Uk.Uu);
                        }
                        a(true, blVar);
                        blVar.aWl.setOnClickListener(this.aUI);
                        return view;
                    case 1:
                        a(false, blVar);
                        blVar.aWl.setText(i.h.downloading2);
                        blVar.aWl.setOnClickListener(null);
                        return view;
                    case 2:
                        a(true, blVar);
                        blVar.aWl.setText(i.h.frs_old_style_download_text);
                        blVar.aWl.setOnClickListener(this.aUI);
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
