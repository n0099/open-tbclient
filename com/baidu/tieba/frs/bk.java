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
    private View.OnClickListener aUA;
    private View.OnClickListener aUz;
    private int aVW;
    private int aVX;
    private int aVY;
    private int maxWidth;

    /* JADX INFO: Access modifiers changed from: protected */
    public bk(BaseActivity baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
        Activity pageActivity;
        if (baseActivity != null && baseActivity.getPageContext() != null && (pageActivity = baseActivity.getPageContext().getPageActivity()) != null && pageActivity.getResources() != null) {
            this.maxWidth = com.baidu.adp.lib.util.k.K(pageActivity) - (pageActivity.getResources().getDimensionPixelSize(i.d.ds30) * 2);
            this.aVW = pageActivity.getResources().getDimensionPixelSize(i.d.frs_item_app_big_img_heght);
            this.aVX = pageActivity.getResources().getDimensionPixelSize(i.d.frs_item_app_big_img_with);
            this.aVY = pageActivity.getResources().getDimensionPixelSize(i.d.ds374);
        }
    }

    public void i(View.OnClickListener onClickListener) {
        this.aUA = onClickListener;
    }

    public void h(View.OnClickListener onClickListener) {
        this.aUz = onClickListener;
    }

    private void a(boolean z, bm bmVar) {
        if (z) {
            com.baidu.tbadk.core.util.an.i((View) bmVar.aWf, i.e.btn_appdownload);
            com.baidu.tbadk.core.util.an.b(bmVar.aWf, i.c.cp_cont_i, 1);
            return;
        }
        com.baidu.tbadk.core.util.an.i((View) bmVar.aWf, i.e.btn_content_download_d);
        com.baidu.tbadk.core.util.an.b(bmVar.aWf, i.c.faceshop_downloaded_text, 1);
    }

    private String gP(String str) {
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
        if (this.aSe == null) {
            return null;
        }
        if (this.aSe != null && (this.aSe instanceof FrsActivity)) {
            ((FrsActivity) this.aSe).Li().MX();
        }
        bmVar.aVL.setPadding(0, i - this.aTQ == 0 ? this.aSR : this.aSS, 0, 0);
        this.aSe.getLayoutMode().ad(this.mSkinType == 1);
        this.aSe.getLayoutMode().k(view);
        if (bVar instanceof com.baidu.tbadk.core.data.b) {
            if (!bVar.Uk && this.aSe != null && (this.aSe instanceof FrsActivity)) {
                bVar.Uk = true;
                ((FrsActivity) this.aSe).a(bVar, "show");
                ((FrsActivity) this.aSe).b(bVar, "show");
            }
            bmVar.aVO.setText(gP(bVar.Uj.userName));
            if (bVar.Uj == null) {
                return null;
            }
            if (TextUtils.isEmpty(bVar.Uj.Um) || TextUtils.isEmpty(bVar.Uj.Um.trim())) {
                bmVar.aVR.setVisibility(8);
            } else {
                bmVar.aVR.setVisibility(0);
                bmVar.aVR.setText(bVar.Uj.Um);
            }
            bmVar.aVP.setText(com.baidu.tbadk.core.util.as.m(bVar.Ui));
            if (com.baidu.tbadk.core.m.qU().qW()) {
                bmVar.aVN.setVisibility(0);
                bmVar.aVN.d(bVar.Uj.userPortrait, this.mIsFromCDN ? 13 : 14, false);
            } else {
                bmVar.aVN.setVisibility(8);
            }
            bmVar.aVN.setTag(bVar.Uj.userPortrait);
            boolean a = a(bmVar.aWe, bVar);
            if (com.baidu.tbadk.core.m.qU().qY() && !TextUtils.isEmpty(bVar.Uj.Uo) && a) {
                bmVar.aWe.setVisibility(0);
                bmVar.aWe.d(bVar.Uj.Uo, this.mIsFromCDN ? 30 : 31, false);
                bmVar.aVR.setPadding(0, 0, 0, 0);
            } else {
                bmVar.aWe.setVisibility(8);
                bmVar.aVR.setPadding(0, 0, 0, this.mContext.getResources().getDimensionPixelSize(i.d.ds30));
            }
            bmVar.aWf.setTag(Integer.valueOf(i));
            if (bVar.ro()) {
                if (!TextUtils.isEmpty(bVar.Uj.Ut) && !TextUtils.isEmpty(bVar.Uj.Ut.trim())) {
                    a(true, bmVar);
                    bmVar.aWf.setText(bVar.Uj.Ut);
                    bmVar.aWf.setOnClickListener(this.aUz);
                    return view;
                }
                bmVar.aWf.setVisibility(8);
                return view;
            } else if (bVar.rn()) {
                bmVar.aWf.setVisibility(0);
                switch (bVar.TU) {
                    case 0:
                        if (TextUtils.isEmpty(bVar.Uj.Ut) || TextUtils.isEmpty(bVar.Uj.Ut.trim())) {
                            bmVar.aWf.setText(i.h.pb_app_download);
                        } else {
                            bmVar.aWf.setText(bVar.Uj.Ut);
                        }
                        a(true, bmVar);
                        bmVar.aWf.setOnClickListener(this.aUA);
                        return view;
                    case 1:
                        a(false, bmVar);
                        bmVar.aWf.setText(i.h.downloading2);
                        bmVar.aWf.setOnClickListener(null);
                        return view;
                    case 2:
                        a(true, bmVar);
                        bmVar.aWf.setText(i.h.frs_new_style_download_text);
                        bmVar.aWf.setOnClickListener(this.aUA);
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
        if (bVar == null || bVar.Uj == null || tbImageView == null) {
            a(tbImageView, this.aVW, this.aVX);
            return true;
        } else if (!bVar.Uj.Uv) {
            a(tbImageView, this.aVW, this.aVX);
            return true;
        } else {
            int i = bVar.Uj.height;
            int i2 = bVar.Uj.width;
            if (this.maxWidth <= 0 || i <= 0 || i2 <= 0) {
                a(tbImageView, this.aVW, this.aVX);
                return true;
            }
            int i3 = this.maxWidth;
            int i4 = (i * i3) / i2;
            if (i4 > this.aVY) {
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
