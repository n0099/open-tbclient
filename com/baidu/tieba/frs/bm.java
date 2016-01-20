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
public class bm extends bp<com.baidu.tbadk.core.data.b, bo> {
    private BdUniqueId Ht;
    private View.OnClickListener bdS;
    private View.OnClickListener bdT;
    private DownloadData bfh;
    private int bft;
    private int bfu;
    private int bfv;
    private int maxWidth;

    /* JADX INFO: Access modifiers changed from: protected */
    public bm(BaseActivity baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
        Activity pageActivity;
        this.bfh = new DownloadData();
        if (baseActivity != null && baseActivity.getPageContext() != null && (pageActivity = baseActivity.getPageContext().getPageActivity()) != null && pageActivity.getResources() != null) {
            this.Ht = bdUniqueId;
            this.maxWidth = com.baidu.adp.lib.util.k.K(pageActivity) - (pageActivity.getResources().getDimensionPixelSize(n.e.ds30) * 2);
            this.bft = pageActivity.getResources().getDimensionPixelSize(n.e.frs_item_app_big_img_heght);
            this.bfu = pageActivity.getResources().getDimensionPixelSize(n.e.frs_item_app_big_img_with);
            this.bfv = pageActivity.getResources().getDimensionPixelSize(n.e.ds374);
        }
    }

    public void i(View.OnClickListener onClickListener) {
        this.bdT = onClickListener;
    }

    public void h(View.OnClickListener onClickListener) {
        this.bdS = onClickListener;
    }

    private void a(boolean z, bo boVar) {
        if (z) {
            com.baidu.tbadk.core.util.as.i((View) boVar.bfD, n.f.btn_appdownload);
            com.baidu.tbadk.core.util.as.b(boVar.bfD, n.d.cp_cont_i, 1);
            return;
        }
        com.baidu.tbadk.core.util.as.i((View) boVar.bfD, n.f.btn_attention);
        com.baidu.tbadk.core.util.as.b(boVar.bfD, n.d.cp_cont_f, 1);
    }

    private String hu(String str) {
        if (!TextUtils.isEmpty(str) && str.length() > 14) {
            return str.substring(0, 14);
        }
        return str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: r */
    public bo a(ViewGroup viewGroup) {
        return new bo(LayoutInflater.from(this.mContext).inflate(n.h.frs_item_app_new, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bp, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.b bVar, bo boVar) {
        super.a(i, view, viewGroup, (ViewGroup) bVar, (com.baidu.tbadk.core.data.b) boVar);
        if (this.bbA == null) {
            return null;
        }
        if (this.bbA != null && (this.bbA instanceof FrsActivity)) {
            ((FrsActivity) this.bbA).Nr().Pn();
        }
        boVar.bfi.setPadding(0, i - this.bdi == 0 ? this.bcm : this.bcn, 0, 0);
        if (boVar.ahf != this.mSkinType) {
            boVar.ahf = this.mSkinType;
            this.bbA.getLayoutMode().ac(this.mSkinType == 1);
            this.bbA.getLayoutMode().k(view);
        }
        if (bVar instanceof com.baidu.tbadk.core.data.b) {
            if (!bVar.Vc && this.bbA != null && (this.bbA instanceof FrsActivity)) {
                bVar.Vc = true;
                ((FrsActivity) this.bbA).a(bVar, "show");
                ((FrsActivity) this.bbA).b(bVar, "show");
            }
            boVar.bfl.setText(hu(bVar.Vb.userName));
            if (bVar.Vb == null) {
                return null;
            }
            if (StringUtils.isNull(bVar.Vb.Ve)) {
                boVar.bfo.setVisibility(8);
            } else {
                boVar.bfo.setVisibility(0);
                boVar.bfo.setText(bVar.Vb.Ve);
            }
            boVar.bfm.setText(com.baidu.tbadk.core.util.ax.s(bVar.Va));
            if (com.baidu.tbadk.core.m.qQ().qS()) {
                boVar.bfk.setVisibility(0);
                boVar.bfk.d(bVar.Vb.userPortrait, this.mIsFromCDN ? 13 : 14, false);
            } else {
                boVar.bfk.setVisibility(8);
            }
            boVar.bfk.setTag(bVar.Vb.userPortrait);
            boolean a = a(boVar.bfC, bVar);
            if (com.baidu.tbadk.core.m.qQ().qW() && !TextUtils.isEmpty(bVar.Vb.Vg) && a) {
                boVar.bfC.setVisibility(0);
                boVar.bfC.d(bVar.Vb.Vg, this.mIsFromCDN ? 30 : 31, false);
                boVar.bfo.setPadding(0, 0, 0, 0);
            } else {
                boVar.bfC.setVisibility(8);
                boVar.bfo.setPadding(0, 0, 0, this.mContext.getResources().getDimensionPixelSize(n.e.ds30));
            }
            boVar.bfD.setVisibility(0);
            boVar.bfD.setTag(Integer.valueOf(i));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) boVar.bfl.getLayoutParams();
            layoutParams.width = -2;
            if (bVar.rm()) {
                boVar.bfB.setVisibility(8);
                if (!StringUtils.isNull(bVar.Vb.Vl)) {
                    a(true, boVar);
                    boVar.bfD.setText(bVar.Vb.Vl);
                    boVar.bfD.setOnClickListener(this.bdS);
                    return view;
                }
                boVar.bfD.setVisibility(8);
                layoutParams.width = -1;
                return view;
            } else if (bVar.rl()) {
                this.bfh.setId(bVar.US);
                this.bfh.setUrl(bVar.UR);
                this.bfh.setName(bVar.UN);
                this.bfh.setPosition(i);
                this.bfh.setNotifyId(com.baidu.adp.lib.h.b.g(bVar.UM, 0));
                int b = AppDownloadView.b(this.bfh);
                this.bfh.setStatus(b);
                boVar.bfB.a(this.Ht, this.bfh);
                a(true, boVar);
                switch (b) {
                    case 1:
                        boVar.bfD.setText(n.j.downloading2);
                        break;
                    case 3:
                        boVar.bfD.setText(n.j.frs_new_style_download_text);
                        break;
                    case 6:
                        if (TextUtils.isEmpty(bVar.Vb.Vl) || TextUtils.isEmpty(bVar.Vb.Vl.trim())) {
                            boVar.bfD.setText(n.j.pb_app_download);
                            break;
                        } else {
                            boVar.bfD.setText(bVar.Vb.Vl);
                            break;
                        }
                        break;
                    case 7:
                        boVar.bfD.setText(n.j.frs_new_style_download_pause);
                        break;
                }
                ((FrsActivity.b) this.bdT).b(boVar.bfB);
                boVar.bfD.setOnClickListener(this.bdT);
                return view;
            } else {
                return view;
            }
        }
        return view;
    }

    private boolean a(TbImageView tbImageView, com.baidu.tbadk.core.data.b bVar) {
        if (bVar == null || bVar.Vb == null || tbImageView == null) {
            a(tbImageView, this.bft, this.bfu);
            return true;
        }
        int i = this.maxWidth;
        if (!bVar.Vb.Vn) {
            a(tbImageView, (this.bft * i) / this.bfu, i);
            return true;
        }
        int i2 = bVar.Vb.height;
        int i3 = bVar.Vb.width;
        if (this.maxWidth <= 0 || i2 <= 0 || i3 <= 0) {
            a(tbImageView, this.bft, this.bfu);
            return true;
        }
        int i4 = (i2 * i) / i3;
        if (i4 > this.bfv) {
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
