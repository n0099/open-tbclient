package com.baidu.tieba.frs;

import android.app.Activity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class bk extends bn<com.baidu.tbadk.core.data.b, bm> {
    private View.OnClickListener aUH;
    private View.OnClickListener aUI;
    private int aWe;
    private int aWf;
    private int aWg;
    private int maxWidth;

    /* JADX INFO: Access modifiers changed from: protected */
    public bk(BaseActivity baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
        Activity pageActivity;
        if (baseActivity != null && baseActivity.getPageContext() != null && (pageActivity = baseActivity.getPageContext().getPageActivity()) != null && pageActivity.getResources() != null) {
            this.maxWidth = com.baidu.adp.lib.util.k.K(pageActivity) - (pageActivity.getResources().getDimensionPixelSize(i.d.ds30) * 2);
            this.aWe = pageActivity.getResources().getDimensionPixelSize(i.d.frs_item_app_big_img_heght);
            this.aWf = pageActivity.getResources().getDimensionPixelSize(i.d.frs_item_app_big_img_with);
            this.aWg = pageActivity.getResources().getDimensionPixelSize(i.d.ds374);
        }
    }

    public void i(View.OnClickListener onClickListener) {
        this.aUI = onClickListener;
    }

    public void h(View.OnClickListener onClickListener) {
        this.aUH = onClickListener;
    }

    private void a(boolean z, bm bmVar) {
        if (z) {
            com.baidu.tbadk.core.util.an.i((View) bmVar.aWn, i.e.btn_appdownload);
            com.baidu.tbadk.core.util.an.b(bmVar.aWn, i.c.cp_cont_i, 1);
            return;
        }
        com.baidu.tbadk.core.util.an.i((View) bmVar.aWn, i.e.btn_content_download_d);
        com.baidu.tbadk.core.util.an.b(bmVar.aWn, i.c.faceshop_downloaded_text, 1);
    }

    private String gR(String str) {
        if (!TextUtils.isEmpty(str) && str.length() > 14) {
            return str.substring(0, 14);
        }
        return str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: h */
    public bm a(ViewGroup viewGroup) {
        return new bm(LayoutInflater.from(this.mContext).inflate(i.g.frs_item_app_new, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bn, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.b bVar, bm bmVar) {
        super.a(i, view, viewGroup, (ViewGroup) bVar, (com.baidu.tbadk.core.data.b) bmVar);
        if (this.aSm == null) {
            return null;
        }
        if (this.aSm != null && (this.aSm instanceof FrsActivity)) {
            ((FrsActivity) this.aSm).Ly().Np();
        }
        bmVar.aVT.setPadding(0, i - this.aTY == 0 ? this.aSZ : this.aTa, 0, 0);
        this.aSm.getLayoutMode().ad(this.mSkinType == 1);
        this.aSm.getLayoutMode().k(view);
        if (bVar instanceof com.baidu.tbadk.core.data.b) {
            if (!bVar.Ul && this.aSm != null && (this.aSm instanceof FrsActivity)) {
                bVar.Ul = true;
                ((FrsActivity) this.aSm).a(bVar, "show");
                ((FrsActivity) this.aSm).b(bVar, "show");
            }
            bmVar.aVW.setText(gR(bVar.Uk.userName));
            if (bVar.Uk == null) {
                return null;
            }
            if (TextUtils.isEmpty(bVar.Uk.Un) || TextUtils.isEmpty(bVar.Uk.Un.trim())) {
                bmVar.aVZ.setVisibility(8);
            } else {
                bmVar.aVZ.setVisibility(0);
                bmVar.aVZ.setText(bVar.Uk.Un);
            }
            bmVar.aVX.setText(com.baidu.tbadk.core.util.as.m(bVar.Uj));
            if (com.baidu.tbadk.core.m.qV().qX()) {
                bmVar.aVV.setVisibility(0);
                bmVar.aVV.d(bVar.Uk.userPortrait, this.mIsFromCDN ? 13 : 14, false);
            } else {
                bmVar.aVV.setVisibility(8);
            }
            bmVar.aVV.setTag(bVar.Uk.userPortrait);
            boolean a = a(bmVar.aWm, bVar);
            if (com.baidu.tbadk.core.m.qV().qZ() && !TextUtils.isEmpty(bVar.Uk.Up) && a) {
                bmVar.aWm.setVisibility(0);
                bmVar.aWm.d(bVar.Uk.Up, this.mIsFromCDN ? 30 : 31, false);
                bmVar.aVZ.setPadding(0, 0, 0, 0);
            } else {
                bmVar.aWm.setVisibility(8);
                bmVar.aVZ.setPadding(0, 0, 0, this.mContext.getResources().getDimensionPixelSize(i.d.ds30));
            }
            bmVar.aWn.setTag(Integer.valueOf(i));
            if (bVar.rp()) {
                if (!TextUtils.isEmpty(bVar.Uk.Uu) && !TextUtils.isEmpty(bVar.Uk.Uu.trim())) {
                    a(true, bmVar);
                    bmVar.aWn.setText(bVar.Uk.Uu);
                    bmVar.aWn.setOnClickListener(this.aUH);
                    return view;
                }
                bmVar.aWn.setVisibility(8);
                return view;
            } else if (bVar.ro()) {
                bmVar.aWn.setVisibility(0);
                switch (bVar.TV) {
                    case 0:
                        if (TextUtils.isEmpty(bVar.Uk.Uu) || TextUtils.isEmpty(bVar.Uk.Uu.trim())) {
                            bmVar.aWn.setText(i.h.pb_app_download);
                        } else {
                            bmVar.aWn.setText(bVar.Uk.Uu);
                        }
                        a(true, bmVar);
                        bmVar.aWn.setOnClickListener(this.aUI);
                        return view;
                    case 1:
                        a(false, bmVar);
                        bmVar.aWn.setText(i.h.downloading2);
                        bmVar.aWn.setOnClickListener(null);
                        return view;
                    case 2:
                        a(true, bmVar);
                        bmVar.aWn.setText(i.h.frs_new_style_download_text);
                        bmVar.aWn.setOnClickListener(this.aUI);
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

    private boolean a(TbImageView tbImageView, com.baidu.tbadk.core.data.b bVar) {
        if (bVar == null || bVar.Uk == null || tbImageView == null) {
            a(tbImageView, this.aWe, this.aWf);
            return true;
        } else if (!bVar.Uk.Uw) {
            a(tbImageView, this.aWe, this.aWf);
            return true;
        } else {
            int i = bVar.Uk.height;
            int i2 = bVar.Uk.width;
            if (this.maxWidth <= 0 || i <= 0 || i2 <= 0) {
                a(tbImageView, this.aWe, this.aWf);
                return true;
            }
            int i3 = this.maxWidth;
            int i4 = (i * i3) / i2;
            if (i4 > this.aWg) {
                return false;
            }
            a(tbImageView, i4, i3);
            return true;
        }
    }

    private void a(TbImageView tbImageView, int i, int i2) {
        ViewGroup.LayoutParams layoutParams = tbImageView.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new AbsListView.LayoutParams(i2, i);
        } else {
            layoutParams.height = i;
            layoutParams.width = i2;
        }
        tbImageView.setLayoutParams(layoutParams);
    }
}
