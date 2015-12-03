package com.baidu.tieba.frs;

import android.app.Activity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.view.AppDownloadView;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class bj extends bm<com.baidu.tbadk.core.data.b, bl> {
    private BdUniqueId Hd;
    private View.OnClickListener aZV;
    private View.OnClickListener aZW;
    private DownloadData bbi;
    private int bbu;
    private int bbv;
    private int bbw;
    private int maxWidth;

    /* JADX INFO: Access modifiers changed from: protected */
    public bj(BaseActivity baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
        Activity pageActivity;
        this.bbi = new DownloadData();
        if (baseActivity != null && baseActivity.getPageContext() != null && (pageActivity = baseActivity.getPageContext().getPageActivity()) != null && pageActivity.getResources() != null) {
            this.Hd = bdUniqueId;
            this.maxWidth = com.baidu.adp.lib.util.k.K(pageActivity) - (pageActivity.getResources().getDimensionPixelSize(n.d.ds30) * 2);
            this.bbu = pageActivity.getResources().getDimensionPixelSize(n.d.frs_item_app_big_img_heght);
            this.bbv = pageActivity.getResources().getDimensionPixelSize(n.d.frs_item_app_big_img_with);
            this.bbw = pageActivity.getResources().getDimensionPixelSize(n.d.ds374);
        }
    }

    public void i(View.OnClickListener onClickListener) {
        this.aZW = onClickListener;
    }

    public void h(View.OnClickListener onClickListener) {
        this.aZV = onClickListener;
    }

    private void a(boolean z, bl blVar) {
        if (z) {
            com.baidu.tbadk.core.util.as.i((View) blVar.bbE, n.e.btn_appdownload);
            com.baidu.tbadk.core.util.as.b(blVar.bbE, n.c.cp_cont_i, 1);
            return;
        }
        com.baidu.tbadk.core.util.as.i((View) blVar.bbE, n.e.btn_attention);
        com.baidu.tbadk.core.util.as.b(blVar.bbE, n.c.cp_cont_f, 1);
    }

    private String hi(String str) {
        if (!TextUtils.isEmpty(str) && str.length() > 14) {
            return str.substring(0, 14);
        }
        return str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: m */
    public bl a(ViewGroup viewGroup) {
        return new bl(LayoutInflater.from(this.mContext).inflate(n.g.frs_item_app_new, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bm, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.b bVar, bl blVar) {
        super.a(i, view, viewGroup, (ViewGroup) bVar, (com.baidu.tbadk.core.data.b) blVar);
        if (this.aXA == null) {
            return null;
        }
        if (this.aXA != null && (this.aXA instanceof FrsActivity)) {
            ((FrsActivity) this.aXA).MX().OV();
        }
        blVar.bbj.setPadding(0, i - this.aZm == 0 ? this.aYn : this.aYo, 0, 0);
        if (blVar.afY != this.mSkinType) {
            blVar.afY = this.mSkinType;
            this.aXA.getLayoutMode().af(this.mSkinType == 1);
            this.aXA.getLayoutMode().k(view);
        }
        if (bVar instanceof com.baidu.tbadk.core.data.b) {
            if (!bVar.UB && this.aXA != null && (this.aXA instanceof FrsActivity)) {
                bVar.UB = true;
                ((FrsActivity) this.aXA).a(bVar, "show");
                ((FrsActivity) this.aXA).b(bVar, "show");
            }
            blVar.bbm.setText(hi(bVar.UA.userName));
            if (bVar.UA == null) {
                return null;
            }
            if (StringUtils.isNull(bVar.UA.UD)) {
                blVar.bbp.setVisibility(8);
            } else {
                blVar.bbp.setVisibility(0);
                blVar.bbp.setText(bVar.UA.UD);
            }
            blVar.bbn.setText(com.baidu.tbadk.core.util.ax.s(bVar.Uz));
            if (com.baidu.tbadk.core.m.rh().rj()) {
                blVar.bbl.setVisibility(0);
                blVar.bbl.d(bVar.UA.userPortrait, this.mIsFromCDN ? 13 : 14, false);
            } else {
                blVar.bbl.setVisibility(8);
            }
            blVar.bbl.setTag(bVar.UA.userPortrait);
            boolean a = a(blVar.bbD, bVar);
            if (com.baidu.tbadk.core.m.rh().rn() && !TextUtils.isEmpty(bVar.UA.UF) && a) {
                blVar.bbD.setVisibility(0);
                blVar.bbD.d(bVar.UA.UF, this.mIsFromCDN ? 30 : 31, false);
                blVar.bbp.setPadding(0, 0, 0, 0);
            } else {
                blVar.bbD.setVisibility(8);
                blVar.bbp.setPadding(0, 0, 0, this.mContext.getResources().getDimensionPixelSize(n.d.ds30));
            }
            blVar.bbE.setVisibility(0);
            blVar.bbE.setTag(Integer.valueOf(i));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) blVar.bbm.getLayoutParams();
            layoutParams.width = -2;
            if (bVar.rD()) {
                blVar.bbC.setVisibility(8);
                if (!StringUtils.isNull(bVar.UA.UK)) {
                    a(true, blVar);
                    blVar.bbE.setText(bVar.UA.UK);
                    blVar.bbE.setOnClickListener(this.aZV);
                    return view;
                }
                blVar.bbE.setVisibility(8);
                layoutParams.width = -1;
                return view;
            } else if (bVar.rC()) {
                this.bbi.setId(bVar.Ur);
                this.bbi.setUrl(bVar.Uq);
                this.bbi.setName(bVar.Un);
                this.bbi.setPosition(i);
                this.bbi.setNotifyId(com.baidu.adp.lib.h.b.g(bVar.Um, 0));
                int b = AppDownloadView.b(this.bbi);
                this.bbi.setStatus(b);
                blVar.bbC.a(this.Hd, this.bbi);
                a(true, blVar);
                switch (b) {
                    case 1:
                        blVar.bbE.setText(n.i.downloading2);
                        break;
                    case 3:
                        blVar.bbE.setText(n.i.frs_new_style_download_text);
                        break;
                    case 6:
                        if (TextUtils.isEmpty(bVar.UA.UK) || TextUtils.isEmpty(bVar.UA.UK.trim())) {
                            blVar.bbE.setText(n.i.pb_app_download);
                            break;
                        } else {
                            blVar.bbE.setText(bVar.UA.UK);
                            break;
                        }
                        break;
                    case 7:
                        blVar.bbE.setText(n.i.frs_new_style_download_pause);
                        break;
                }
                ((FrsActivity.b) this.aZW).b(blVar.bbC);
                blVar.bbE.setOnClickListener(this.aZW);
                return view;
            } else {
                return view;
            }
        }
        return view;
    }

    private boolean a(TbImageView tbImageView, com.baidu.tbadk.core.data.b bVar) {
        if (bVar == null || bVar.UA == null || tbImageView == null) {
            a(tbImageView, this.bbu, this.bbv);
            return true;
        }
        int i = this.maxWidth;
        if (!bVar.UA.UM) {
            a(tbImageView, (this.bbu * i) / this.bbv, i);
            return true;
        }
        int i2 = bVar.UA.height;
        int i3 = bVar.UA.width;
        if (this.maxWidth <= 0 || i2 <= 0 || i3 <= 0) {
            a(tbImageView, this.bbu, this.bbv);
            return true;
        }
        int i4 = (i2 * i) / i3;
        if (i4 > this.bbw) {
            return false;
        }
        a(tbImageView, i4, i);
        return true;
    }

    private void a(TbImageView tbImageView, int i, int i2) {
        if (tbImageView != null) {
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
}
