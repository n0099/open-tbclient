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
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.AppDownloadView;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.t;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes.dex */
public class bs extends bx<com.baidu.tbadk.core.data.c, bv> {
    private BdUniqueId HL;
    private View.OnClickListener bkY;
    private View.OnClickListener bkZ;
    private View.OnClickListener bla;
    private int bmM;
    private Set<String> bms;
    private DownloadData bmv;
    private int imageHeight;
    private int imageWidth;
    private int maxWidth;

    /* JADX INFO: Access modifiers changed from: protected */
    public bs(BaseActivity baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
        Activity pageActivity;
        this.bms = new HashSet();
        this.bmv = new DownloadData();
        if (baseActivity != null && baseActivity.getPageContext() != null && (pageActivity = baseActivity.getPageContext().getPageActivity()) != null && pageActivity.getResources() != null) {
            this.HL = bdUniqueId;
            this.maxWidth = com.baidu.adp.lib.util.k.B(pageActivity) - (pageActivity.getResources().getDimensionPixelSize(t.e.ds24) * 2);
            this.imageHeight = pageActivity.getResources().getDimensionPixelSize(t.e.frs_item_app_big_img_heght);
            this.imageWidth = pageActivity.getResources().getDimensionPixelSize(t.e.frs_item_app_big_img_with);
            this.bmM = pageActivity.getResources().getDimensionPixelSize(t.e.ds374);
        }
    }

    public void m(View.OnClickListener onClickListener) {
        this.bkZ = onClickListener;
    }

    public void n(View.OnClickListener onClickListener) {
        this.bla = onClickListener;
    }

    public void l(View.OnClickListener onClickListener) {
        this.bkY = onClickListener;
    }

    private void a(boolean z, bv bvVar) {
        if (z) {
            com.baidu.tbadk.core.util.at.k(bvVar.bmV, t.f.btn_appdownload);
            com.baidu.tbadk.core.util.at.b(bvVar.bmV, t.d.cp_cont_i, 1);
            return;
        }
        com.baidu.tbadk.core.util.at.k(bvVar.bmV, t.f.btn_attention);
        com.baidu.tbadk.core.util.at.b(bvVar.bmV, t.d.cp_cont_f, 1);
    }

    private String hK(String str) {
        if (!TextUtils.isEmpty(str) && str.length() > 14) {
            return str.substring(0, 14);
        }
        return str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: t */
    public bv b(ViewGroup viewGroup) {
        return new bv(LayoutInflater.from(this.mContext).inflate(t.h.frs_item_app_new, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bx, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.c cVar, bv bvVar) {
        super.a(i, view, viewGroup, (ViewGroup) cVar, (com.baidu.tbadk.core.data.c) bvVar);
        if (this.bix == null) {
            return null;
        }
        if (this.bix != null && (this.bix instanceof FrsActivity)) {
            ((FrsActivity) this.bix).Rd().Te();
        }
        bvVar.bmx.setPadding(0, i - this.bkj == 0 ? this.bjn : this.bjo, 0, 0);
        if (bvVar.aik != this.mSkinType) {
            bvVar.aik = this.mSkinType;
            this.bix.getLayoutMode().ab(this.mSkinType == 1);
            this.bix.getLayoutMode().x(view);
        }
        if (cVar instanceof com.baidu.tbadk.core.data.c) {
            if (cVar.Sp) {
                if (bvVar.bmJ == null) {
                    bvVar.bmJ = (ViewGroup) bvVar.bmI.inflate().findViewById(t.g.frs_item_adkiller_tip);
                    com.baidu.tbadk.i.a.a(this.bix.getPageContext(), bvVar.bmJ);
                }
                bvVar.bmJ.setVisibility(0);
                bvVar.bmJ.setOnClickListener(new bt(this, cVar));
                if (!this.bms.contains(cVar.Sr)) {
                    this.bms.add(cVar.Sr);
                    com.baidu.tbadk.core.util.aw awVar = new com.baidu.tbadk.core.util.aw("c10828");
                    awVar.ac("obj_id", new StringBuilder(String.valueOf(cVar.getFid())).toString());
                    TiebaStatic.log(awVar);
                }
            } else if (bvVar.bmJ != null) {
                bvVar.bmJ.setVisibility(8);
            }
            if (cVar.Ss) {
                if (bvVar.bmL == null) {
                    bvVar.bmL = (ViewGroup) bvVar.bmK.inflate().findViewById(t.g.item_adkiller_close);
                    com.baidu.tbadk.i.a.a(this.bix.getPageContext(), bvVar.bmL);
                }
                bvVar.bmL.setVisibility(0);
                bvVar.bmL.setOnClickListener(this.bla);
                bvVar.bmL.setTag(Integer.valueOf(i));
            } else if (bvVar.bmL != null) {
                bvVar.bmL.setVisibility(8);
            }
            if (!cVar.So && this.bix != null && (this.bix instanceof FrsActivity)) {
                cVar.So = true;
                ((FrsActivity) this.bix).a(cVar, "show");
                ((FrsActivity) this.bix).b(cVar, "show");
            }
            bvVar.bmA.setText(hK(cVar.Sn.userName));
            if (cVar.Sn == null) {
                return null;
            }
            if (StringUtils.isNull(cVar.Sn.Su)) {
                bvVar.bmD.setVisibility(8);
            } else {
                bvVar.bmD.setVisibility(0);
                bvVar.bmD.setText(cVar.Sn.Su);
            }
            bvVar.bmB.setText(com.baidu.tbadk.core.util.ay.w(cVar.Sm));
            if (com.baidu.tbadk.core.l.qE().qG()) {
                bvVar.bmz.setVisibility(0);
                bvVar.bmz.c(cVar.Sn.userPortrait, this.mIsFromCDN ? 13 : 14, false);
            } else {
                bvVar.bmz.setVisibility(8);
            }
            bvVar.bmz.setTag(cVar.Sn.userPortrait);
            boolean a = a(bvVar.bmU, cVar);
            if (com.baidu.tbadk.core.l.qE().qK() && !TextUtils.isEmpty(cVar.Sn.Sw) && a) {
                bvVar.bmU.setVisibility(0);
                bvVar.bmU.c(cVar.Sn.Sw, this.mIsFromCDN ? 30 : 31, false);
                bvVar.bmD.setPadding(0, 0, 0, 0);
            } else {
                bvVar.bmU.setVisibility(8);
                bvVar.bmD.setPadding(0, 0, 0, this.mContext.getResources().getDimensionPixelSize(t.e.ds30));
            }
            bvVar.bmV.setVisibility(0);
            bvVar.bmV.setTag(Integer.valueOf(i));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bvVar.bmA.getLayoutParams();
            layoutParams.width = -2;
            if (cVar.rm()) {
                bvVar.bmT.setVisibility(8);
                if (!StringUtils.isNull(cVar.Sn.OJ)) {
                    a(true, bvVar);
                    bvVar.bmV.setText(cVar.Sn.OJ);
                    bvVar.bmV.setOnClickListener(this.bkY);
                    return view;
                }
                bvVar.bmV.setVisibility(8);
                layoutParams.width = -1;
                return view;
            } else if (cVar.rl()) {
                this.bmv.setId(cVar.Se);
                this.bmv.setUrl(cVar.Sd);
                this.bmv.setName(cVar.Sa);
                this.bmv.setPosition(i);
                this.bmv.setNotifyId(com.baidu.adp.lib.h.b.g(cVar.RZ, 0));
                int b = AppDownloadView.b(this.bmv);
                this.bmv.setStatus(b);
                bvVar.bmT.a(this.HL, this.bmv);
                a(true, bvVar);
                switch (b) {
                    case 1:
                        bvVar.bmV.setText(t.j.downloading2);
                        break;
                    case 3:
                        bvVar.bmV.setText(t.j.frs_new_style_download_text);
                        break;
                    case 6:
                        if (TextUtils.isEmpty(cVar.Sn.OJ) || TextUtils.isEmpty(cVar.Sn.OJ.trim())) {
                            bvVar.bmV.setText(t.j.pb_app_download);
                            break;
                        } else {
                            bvVar.bmV.setText(cVar.Sn.OJ);
                            break;
                        }
                        break;
                    case 7:
                        bvVar.bmV.setText(t.j.frs_new_style_download_pause);
                        break;
                }
                ((FrsActivity.b) this.bkZ).b(bvVar.bmT);
                bvVar.bmV.setOnClickListener(this.bkZ);
                return view;
            } else {
                return view;
            }
        }
        return view;
    }

    private boolean a(TbImageView tbImageView, com.baidu.tbadk.core.data.c cVar) {
        if (cVar == null || cVar.Sn == null || tbImageView == null) {
            a(tbImageView, this.imageHeight, this.imageWidth);
            return true;
        }
        int i = this.maxWidth;
        if (!cVar.Sn.SC) {
            a(tbImageView, (this.imageHeight * i) / this.imageWidth, i);
            return true;
        }
        int i2 = cVar.Sn.height;
        int i3 = cVar.Sn.width;
        if (this.maxWidth <= 0 || i2 <= 0 || i3 <= 0) {
            a(tbImageView, this.imageHeight, this.imageWidth);
            return true;
        }
        int i4 = (i2 * i) / i3;
        if (i4 > this.bmM) {
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
