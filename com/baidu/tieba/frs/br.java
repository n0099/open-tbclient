package com.baidu.tieba.frs;

import android.app.Activity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.h.b;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.AppDownloadView;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.i.a;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.t;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes.dex */
public class br extends bw<com.baidu.tbadk.core.data.c, bu> {
    private int aOc;
    private int aOd;
    private Set<String> bhO;
    private boolean bhP;
    private DownloadData bhS;
    private View.OnClickListener bhd;
    private View.OnClickListener bhe;
    private View.OnClickListener bhf;
    private int bil;
    private int maxWidth;
    private BdUniqueId yd;

    public br(BaseActivity baseActivity, BdUniqueId bdUniqueId, boolean z) {
        super(baseActivity, bdUniqueId);
        Activity pageActivity;
        this.bhO = new HashSet();
        this.bhS = new DownloadData();
        if (baseActivity != null && baseActivity.getPageContext() != null && (pageActivity = baseActivity.getPageContext().getPageActivity()) != null && pageActivity.getResources() != null) {
            this.yd = bdUniqueId;
            this.maxWidth = com.baidu.adp.lib.util.k.B(pageActivity) - (pageActivity.getResources().getDimensionPixelSize(t.e.ds24) * 2);
            this.aOd = pageActivity.getResources().getDimensionPixelSize(t.e.frs_item_app_big_img_heght);
            this.aOc = pageActivity.getResources().getDimensionPixelSize(t.e.frs_item_app_big_img_with);
            this.bil = pageActivity.getResources().getDimensionPixelSize(t.e.ds374);
            this.bhP = z;
        }
    }

    public void m(View.OnClickListener onClickListener) {
        this.bhe = onClickListener;
    }

    public void l(View.OnClickListener onClickListener) {
        this.bhd = onClickListener;
    }

    private void a(boolean z, bu buVar) {
        if (z) {
            com.baidu.tbadk.core.util.at.k(buVar.biu, t.f.btn_appdownload);
            com.baidu.tbadk.core.util.at.c(buVar.biu, t.d.cp_cont_i, 1);
            return;
        }
        com.baidu.tbadk.core.util.at.k(buVar.biu, t.f.btn_attention);
        com.baidu.tbadk.core.util.at.c(buVar.biu, t.d.cp_cont_f, 1);
    }

    private String hL(String str) {
        if (!TextUtils.isEmpty(str) && str.length() > 14) {
            return str.substring(0, 14);
        }
        return str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: m */
    public bu b(ViewGroup viewGroup) {
        return new bu(LayoutInflater.from(this.mContext).inflate(t.h.frs_item_app_new, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bw, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.c cVar, bu buVar) {
        int i2;
        super.a(i, view, viewGroup, (ViewGroup) cVar, (com.baidu.tbadk.core.data.c) buVar);
        if (this.bek == null) {
            return null;
        }
        if (this.bek != null && (this.bek instanceof FrsActivity)) {
            ((FrsActivity) this.bek).Qd().RF();
        }
        if (this.bek != null && (this.bek instanceof ff)) {
            ((ff) this.bek).RF();
        }
        int i3 = i - this.bgj;
        if (i3 == 0) {
            int i4 = this.bfn;
        } else {
            int i5 = this.bfo;
        }
        if (!this.bhP) {
            i2 = this.biw;
        } else {
            i2 = i3 == 0 ? this.bfn : this.bfo;
        }
        buVar.bhU.setPadding(0, i2, 0, 0);
        if (buVar.aej != this.mSkinType) {
            buVar.aej = this.mSkinType;
            this.bek.getLayoutMode().ae(this.mSkinType == 1);
            this.bek.getLayoutMode().x(view);
        }
        if (cVar instanceof com.baidu.tbadk.core.data.c) {
            if (cVar.Nd) {
                if (buVar.bii == null) {
                    buVar.bii = (ViewGroup) buVar.bih.inflate().findViewById(t.g.frs_item_adkiller_tip);
                    a.a(this.bek.getPageContext(), buVar.bii);
                }
                buVar.bii.setVisibility(0);
                buVar.bii.setOnClickListener(new bs(this, cVar));
                if (!this.bhO.contains(cVar.Nf)) {
                    this.bhO.add(cVar.Nf);
                    com.baidu.tbadk.core.util.aw awVar = new com.baidu.tbadk.core.util.aw("c10828");
                    awVar.ac("obj_id", new StringBuilder(String.valueOf(cVar.getFid())).toString());
                    TiebaStatic.log(awVar);
                }
            } else if (buVar.bii != null) {
                buVar.bii.setVisibility(8);
            }
            if (cVar.Ng) {
                if (buVar.bik == null) {
                    buVar.bik = (ViewGroup) buVar.bij.inflate().findViewById(t.g.item_adkiller_close);
                    a.a(this.bek.getPageContext(), buVar.bik);
                }
                buVar.bik.setVisibility(0);
                buVar.bik.setOnClickListener(this.bhf);
                buVar.bik.setTag(Integer.valueOf(i));
            } else if (buVar.bik != null) {
                buVar.bik.setVisibility(8);
            }
            if (!cVar.Nc && this.bek != null) {
                cVar.Nc = true;
                if (this.bek instanceof FrsActivity) {
                    ((FrsActivity) this.bek).a(cVar, "show");
                    ((FrsActivity) this.bek).b(cVar, "show");
                }
                if (this.bek instanceof ff) {
                    ((ff) this.bek).a(cVar, "show");
                    ((ff) this.bek).b(cVar, "show");
                }
            }
            buVar.bhX.setText(hL(cVar.Nb.userName));
            if (cVar.Nb == null) {
                return null;
            }
            if (StringUtils.isNull(cVar.Nb.Ni)) {
                buVar.bia.setVisibility(8);
            } else {
                buVar.bia.setVisibility(0);
                buVar.bia.setText(cVar.Nb.Ni);
            }
            buVar.bhY.setText(com.baidu.tbadk.core.util.ay.x(cVar.Na));
            if (com.baidu.tbadk.core.l.ob().od()) {
                buVar.bhW.setVisibility(0);
                buVar.bhW.c(cVar.Nb.userPortrait, this.mIsFromCDN ? 13 : 14, false);
            } else {
                buVar.bhW.setVisibility(8);
            }
            buVar.bhW.setTag(cVar.Nb.userPortrait);
            boolean a = a(buVar.bit, cVar);
            if (com.baidu.tbadk.core.l.ob().oh() && !TextUtils.isEmpty(cVar.Nb.Nk) && a) {
                buVar.bit.setVisibility(0);
                buVar.bit.c(cVar.Nb.Nk, this.mIsFromCDN ? 30 : 31, false);
                buVar.bia.setPadding(0, 0, 0, 0);
            } else {
                buVar.bit.setVisibility(8);
                buVar.bia.setPadding(0, 0, 0, this.mContext.getResources().getDimensionPixelSize(t.e.ds30));
            }
            buVar.biu.setVisibility(0);
            buVar.biu.setTag(Integer.valueOf(i));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) buVar.bhX.getLayoutParams();
            layoutParams.width = -2;
            if (cVar.oH()) {
                buVar.bis.setVisibility(8);
                if (!StringUtils.isNull(cVar.Nb.EZ)) {
                    a(true, buVar);
                    buVar.biu.setText(cVar.Nb.EZ);
                    buVar.biu.setOnClickListener(this.bhd);
                    return view;
                }
                buVar.biu.setVisibility(8);
                layoutParams.width = -1;
                return view;
            } else if (cVar.oG()) {
                this.bhS.setId(cVar.MS);
                this.bhS.setUrl(cVar.MR);
                this.bhS.setName(cVar.MO);
                this.bhS.setPosition(i);
                this.bhS.setNotifyId(b.g(cVar.MN, 0));
                this.bhS.setStatus(AppDownloadView.b(this.bhS));
                int status = this.bhS.getStatus();
                buVar.bis.setVisibility(status == 5 || status == 1 || status == 7 ? 0 : 8);
                buVar.bis.a(this.yd, this.bhS);
                a(true, buVar);
                switch (status) {
                    case 1:
                        buVar.biu.setText(t.j.downloading2);
                        break;
                    case 3:
                        buVar.biu.setText(t.j.frs_new_style_download_text);
                        break;
                    case 6:
                        if (TextUtils.isEmpty(cVar.Nb.EZ) || TextUtils.isEmpty(cVar.Nb.EZ.trim())) {
                            buVar.biu.setText(t.j.pb_app_download);
                            break;
                        } else {
                            buVar.biu.setText(cVar.Nb.EZ);
                            break;
                        }
                        break;
                    case 7:
                        buVar.biu.setText(t.j.frs_new_style_download_pause);
                        break;
                }
                ((AppDownloadView.a) this.bhe).b(buVar.bis);
                buVar.biu.setOnClickListener(this.bhe);
                return view;
            } else {
                return view;
            }
        }
        return view;
    }

    private boolean a(TbImageView tbImageView, com.baidu.tbadk.core.data.c cVar) {
        if (cVar == null || cVar.Nb == null || tbImageView == null) {
            a(tbImageView, this.aOd, this.aOc);
            return true;
        }
        int i = this.maxWidth;
        if (!cVar.Nb.Nq) {
            a(tbImageView, (this.aOd * i) / this.aOc, i);
            return true;
        }
        int i2 = cVar.Nb.height;
        int i3 = cVar.Nb.width;
        if (this.maxWidth <= 0 || i2 <= 0 || i3 <= 0) {
            a(tbImageView, this.aOd, this.aOc);
            return true;
        }
        int i4 = (i2 * i) / i3;
        if (i4 > this.bil) {
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
