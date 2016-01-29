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
public class bq extends bv<com.baidu.tbadk.core.data.c, bt> {
    private BdUniqueId HF;
    private View.OnClickListener bgm;
    private View.OnClickListener bgn;
    private View.OnClickListener bgo;
    private Set<String> bhF;
    private DownloadData bhI;
    private int bhZ;
    private int imageHeight;
    private int imageWidth;
    private int maxWidth;

    /* JADX INFO: Access modifiers changed from: protected */
    public bq(BaseActivity baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
        Activity pageActivity;
        this.bhF = new HashSet();
        this.bhI = new DownloadData();
        if (baseActivity != null && baseActivity.getPageContext() != null && (pageActivity = baseActivity.getPageContext().getPageActivity()) != null && pageActivity.getResources() != null) {
            this.HF = bdUniqueId;
            this.maxWidth = com.baidu.adp.lib.util.k.K(pageActivity) - (pageActivity.getResources().getDimensionPixelSize(t.e.ds30) * 2);
            this.imageHeight = pageActivity.getResources().getDimensionPixelSize(t.e.frs_item_app_big_img_heght);
            this.imageWidth = pageActivity.getResources().getDimensionPixelSize(t.e.frs_item_app_big_img_with);
            this.bhZ = pageActivity.getResources().getDimensionPixelSize(t.e.ds374);
        }
    }

    public void m(View.OnClickListener onClickListener) {
        this.bgn = onClickListener;
    }

    public void n(View.OnClickListener onClickListener) {
        this.bgo = onClickListener;
    }

    public void l(View.OnClickListener onClickListener) {
        this.bgm = onClickListener;
    }

    private void a(boolean z, bt btVar) {
        if (z) {
            com.baidu.tbadk.core.util.ar.k(btVar.bik, t.f.btn_appdownload);
            com.baidu.tbadk.core.util.ar.b(btVar.bik, t.d.cp_cont_i, 1);
            return;
        }
        com.baidu.tbadk.core.util.ar.k(btVar.bik, t.f.btn_attention);
        com.baidu.tbadk.core.util.ar.b(btVar.bik, t.d.cp_cont_f, 1);
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
    /* renamed from: s */
    public bt b(ViewGroup viewGroup) {
        return new bt(LayoutInflater.from(this.mContext).inflate(t.h.frs_item_app_new, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bv, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.c cVar, bt btVar) {
        super.a(i, view, viewGroup, (ViewGroup) cVar, (com.baidu.tbadk.core.data.c) btVar);
        if (this.bdK == null) {
            return null;
        }
        if (this.bdK != null && (this.bdK instanceof FrsActivity)) {
            ((FrsActivity) this.bdK).Po().Rr();
        }
        btVar.bhK.setPadding(0, i - this.bfz == 0 ? this.beB : this.beC, 0, 0);
        if (btVar.ahU != this.mSkinType) {
            btVar.ahU = this.mSkinType;
            this.bdK.getLayoutMode().ac(this.mSkinType == 1);
            this.bdK.getLayoutMode().x(view);
        }
        if (cVar instanceof com.baidu.tbadk.core.data.c) {
            if (cVar.UK) {
                if (btVar.bhW == null) {
                    btVar.bhW = (ViewGroup) btVar.bhV.inflate().findViewById(t.g.frs_item_adkiller_tip);
                    com.baidu.tbadk.i.a.a(this.bdK.getPageContext(), btVar.bhW);
                }
                btVar.bhW.setVisibility(0);
                btVar.bhW.setOnClickListener(new br(this, cVar));
                if (!this.bhF.contains(cVar.UM)) {
                    this.bhF.add(cVar.UM);
                    com.baidu.tbadk.core.util.au auVar = new com.baidu.tbadk.core.util.au("c10828");
                    auVar.aa("obj_id", new StringBuilder(String.valueOf(cVar.getFid())).toString());
                    TiebaStatic.log(auVar);
                }
            } else if (btVar.bhW != null) {
                btVar.bhW.setVisibility(8);
            }
            if (cVar.UN) {
                if (btVar.bhY == null) {
                    btVar.bhY = (ViewGroup) btVar.bhX.inflate().findViewById(t.g.item_adkiller_close);
                    com.baidu.tbadk.i.a.a(this.bdK.getPageContext(), btVar.bhY);
                }
                btVar.bhY.setVisibility(0);
                btVar.bhY.setOnClickListener(this.bgo);
                btVar.bhY.setTag(Integer.valueOf(i));
            } else if (btVar.bhY != null) {
                btVar.bhY.setVisibility(8);
            }
            if (!cVar.UJ && this.bdK != null && (this.bdK instanceof FrsActivity)) {
                cVar.UJ = true;
                ((FrsActivity) this.bdK).a(cVar, "show");
                ((FrsActivity) this.bdK).b(cVar, "show");
            }
            btVar.bhN.setText(hu(cVar.UI.userName));
            if (cVar.UI == null) {
                return null;
            }
            if (StringUtils.isNull(cVar.UI.UQ)) {
                btVar.bhQ.setVisibility(8);
            } else {
                btVar.bhQ.setVisibility(0);
                btVar.bhQ.setText(cVar.UI.UQ);
            }
            btVar.bhO.setText(com.baidu.tbadk.core.util.aw.t(cVar.UH));
            if (com.baidu.tbadk.core.l.rn().rp()) {
                btVar.bhM.setVisibility(0);
                btVar.bhM.d(cVar.UI.userPortrait, this.mIsFromCDN ? 13 : 14, false);
            } else {
                btVar.bhM.setVisibility(8);
            }
            btVar.bhM.setTag(cVar.UI.userPortrait);
            boolean a = a(btVar.bij, cVar);
            if (com.baidu.tbadk.core.l.rn().rt() && !TextUtils.isEmpty(cVar.UI.US) && a) {
                btVar.bij.setVisibility(0);
                btVar.bij.d(cVar.UI.US, this.mIsFromCDN ? 30 : 31, false);
                btVar.bhQ.setPadding(0, 0, 0, 0);
            } else {
                btVar.bij.setVisibility(8);
                btVar.bhQ.setPadding(0, 0, 0, this.mContext.getResources().getDimensionPixelSize(t.e.ds30));
            }
            btVar.bik.setVisibility(0);
            btVar.bik.setTag(Integer.valueOf(i));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) btVar.bhN.getLayoutParams();
            layoutParams.width = -2;
            if (cVar.rO()) {
                btVar.bii.setVisibility(8);
                if (!StringUtils.isNull(cVar.UI.OC)) {
                    a(true, btVar);
                    btVar.bik.setText(cVar.UI.OC);
                    btVar.bik.setOnClickListener(this.bgm);
                    return view;
                }
                btVar.bik.setVisibility(8);
                layoutParams.width = -1;
                return view;
            } else if (cVar.rN()) {
                this.bhI.setId(cVar.Uy);
                this.bhI.setUrl(cVar.Ux);
                this.bhI.setName(cVar.Uu);
                this.bhI.setPosition(i);
                this.bhI.setNotifyId(com.baidu.adp.lib.h.b.g(cVar.Ut, 0));
                int b = AppDownloadView.b(this.bhI);
                this.bhI.setStatus(b);
                btVar.bii.a(this.HF, this.bhI);
                a(true, btVar);
                switch (b) {
                    case 1:
                        btVar.bik.setText(t.j.downloading2);
                        break;
                    case 3:
                        btVar.bik.setText(t.j.frs_new_style_download_text);
                        break;
                    case 6:
                        if (TextUtils.isEmpty(cVar.UI.OC) || TextUtils.isEmpty(cVar.UI.OC.trim())) {
                            btVar.bik.setText(t.j.pb_app_download);
                            break;
                        } else {
                            btVar.bik.setText(cVar.UI.OC);
                            break;
                        }
                        break;
                    case 7:
                        btVar.bik.setText(t.j.frs_new_style_download_pause);
                        break;
                }
                ((FrsActivity.b) this.bgn).b(btVar.bii);
                btVar.bik.setOnClickListener(this.bgn);
                return view;
            } else {
                return view;
            }
        }
        return view;
    }

    private boolean a(TbImageView tbImageView, com.baidu.tbadk.core.data.c cVar) {
        if (cVar == null || cVar.UI == null || tbImageView == null) {
            a(tbImageView, this.imageHeight, this.imageWidth);
            return true;
        }
        int i = this.maxWidth;
        if (!cVar.UI.UY) {
            a(tbImageView, (this.imageHeight * i) / this.imageWidth, i);
            return true;
        }
        int i2 = cVar.UI.height;
        int i3 = cVar.UI.width;
        if (this.maxWidth <= 0 || i2 <= 0 || i3 <= 0) {
            a(tbImageView, this.imageHeight, this.imageWidth);
            return true;
        }
        int i4 = (i2 * i) / i3;
        if (i4 > this.bhZ) {
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
