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
    private View.OnClickListener aUo;
    private View.OnClickListener aUp;
    private int aVL;
    private int aVM;
    private int aVN;
    private int maxWidth;

    /* JADX INFO: Access modifiers changed from: protected */
    public bk(BaseActivity baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
        Activity pageActivity;
        if (baseActivity != null && baseActivity.getPageContext() != null && (pageActivity = baseActivity.getPageContext().getPageActivity()) != null && pageActivity.getResources() != null) {
            this.maxWidth = com.baidu.adp.lib.util.k.K(pageActivity) - (pageActivity.getResources().getDimensionPixelSize(i.d.ds30) * 2);
            this.aVL = pageActivity.getResources().getDimensionPixelSize(i.d.frs_item_app_big_img_heght);
            this.aVM = pageActivity.getResources().getDimensionPixelSize(i.d.frs_item_app_big_img_with);
            this.aVN = pageActivity.getResources().getDimensionPixelSize(i.d.ds374);
        }
    }

    public void i(View.OnClickListener onClickListener) {
        this.aUp = onClickListener;
    }

    public void h(View.OnClickListener onClickListener) {
        this.aUo = onClickListener;
    }

    private void a(boolean z, bm bmVar) {
        if (z) {
            com.baidu.tbadk.core.util.am.i((View) bmVar.aVU, i.e.btn_appdownload);
            com.baidu.tbadk.core.util.am.b(bmVar.aVU, i.c.cp_cont_i, 1);
            return;
        }
        com.baidu.tbadk.core.util.am.i((View) bmVar.aVU, i.e.btn_content_download_d);
        com.baidu.tbadk.core.util.am.b(bmVar.aVU, i.c.faceshop_downloaded_text, 1);
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
        if (this.aRT == null) {
            return null;
        }
        if (this.aRT != null && (this.aRT instanceof FrsActivity)) {
            ((FrsActivity) this.aRT).Lm().Nb();
        }
        bmVar.aVA.setPadding(0, i - this.aTF == 0 ? this.aSG : this.aSH, 0, 0);
        this.aRT.getLayoutMode().ad(this.mSkinType == 1);
        this.aRT.getLayoutMode().k(view);
        if (bVar instanceof com.baidu.tbadk.core.data.b) {
            if (!bVar.Uj && this.aRT != null && (this.aRT instanceof FrsActivity)) {
                bVar.Uj = true;
                ((FrsActivity) this.aRT).a(bVar, "show");
                ((FrsActivity) this.aRT).b(bVar, "show");
            }
            bmVar.aVD.setText(gP(bVar.Ui.userName));
            if (bVar.Ui == null) {
                return null;
            }
            if (TextUtils.isEmpty(bVar.Ui.Ul) || TextUtils.isEmpty(bVar.Ui.Ul.trim())) {
                bmVar.aVG.setVisibility(8);
            } else {
                bmVar.aVG.setVisibility(0);
                bmVar.aVG.setText(bVar.Ui.Ul);
            }
            bmVar.aVE.setText(com.baidu.tbadk.core.util.ar.o(bVar.Uh));
            if (com.baidu.tbadk.core.m.qX().qZ()) {
                bmVar.aVC.setVisibility(0);
                bmVar.aVC.d(bVar.Ui.userPortrait, this.mIsFromCDN ? 13 : 14, false);
            } else {
                bmVar.aVC.setVisibility(8);
            }
            bmVar.aVC.setTag(bVar.Ui.userPortrait);
            boolean a = a(bmVar.aVT, bVar);
            if (com.baidu.tbadk.core.m.qX().rb() && !TextUtils.isEmpty(bVar.Ui.Un) && a) {
                bmVar.aVT.setVisibility(0);
                bmVar.aVT.d(bVar.Ui.Un, this.mIsFromCDN ? 30 : 31, false);
                bmVar.aVG.setPadding(0, 0, 0, 0);
            } else {
                bmVar.aVT.setVisibility(8);
                bmVar.aVG.setPadding(0, 0, 0, this.mContext.getResources().getDimensionPixelSize(i.d.ds30));
            }
            bmVar.aVU.setTag(Integer.valueOf(i));
            if (bVar.rr()) {
                if (!TextUtils.isEmpty(bVar.Ui.Us) && !TextUtils.isEmpty(bVar.Ui.Us.trim())) {
                    a(true, bmVar);
                    bmVar.aVU.setText(bVar.Ui.Us);
                    bmVar.aVU.setOnClickListener(this.aUo);
                    return view;
                }
                bmVar.aVU.setVisibility(8);
                return view;
            } else if (bVar.rq()) {
                bmVar.aVU.setVisibility(0);
                switch (bVar.TT) {
                    case 0:
                        if (TextUtils.isEmpty(bVar.Ui.Us) || TextUtils.isEmpty(bVar.Ui.Us.trim())) {
                            bmVar.aVU.setText(i.h.pb_app_download);
                        } else {
                            bmVar.aVU.setText(bVar.Ui.Us);
                        }
                        a(true, bmVar);
                        bmVar.aVU.setOnClickListener(this.aUp);
                        return view;
                    case 1:
                        a(false, bmVar);
                        bmVar.aVU.setText(i.h.downloading2);
                        bmVar.aVU.setOnClickListener(null);
                        return view;
                    case 2:
                        a(true, bmVar);
                        bmVar.aVU.setText(i.h.frs_new_style_download_text);
                        bmVar.aVU.setOnClickListener(this.aUp);
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
        if (bVar == null || bVar.Ui == null || tbImageView == null) {
            a(tbImageView, this.aVL, this.aVM);
            return true;
        } else if (!bVar.Ui.Uu) {
            a(tbImageView, this.aVL, this.aVM);
            return true;
        } else {
            int i = bVar.Ui.height;
            int i2 = bVar.Ui.width;
            if (this.maxWidth <= 0 || i <= 0 || i2 <= 0) {
                a(tbImageView, this.aVL, this.aVM);
                return true;
            }
            int i3 = this.maxWidth;
            int i4 = (i * i3) / i2;
            if (i4 > this.aVN) {
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
