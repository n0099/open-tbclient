package com.baidu.tieba.frs;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.h.b;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.AppDownloadView;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.i.a;
import com.baidu.tieba.t;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/* loaded from: classes.dex */
public class bo extends bw<com.baidu.tbadk.core.data.c, bq> {
    private Set<String> bhO;
    private boolean bhP;
    private DownloadData bhS;
    private View.OnClickListener bhd;
    private View.OnClickListener bhe;
    private View.OnClickListener bhf;

    public bo(BaseActivity<?> baseActivity, BdUniqueId bdUniqueId, boolean z) {
        super(baseActivity, bdUniqueId);
        this.bhO = new HashSet();
        this.bhS = new DownloadData();
        this.bhP = z;
    }

    public void m(View.OnClickListener onClickListener) {
        this.bhe = onClickListener;
    }

    public void l(View.OnClickListener onClickListener) {
        this.bhd = onClickListener;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: l */
    public bq b(ViewGroup viewGroup) {
        return new bq(LayoutInflater.from(this.mContext).inflate(t.h.frs_app_muti_pic_layout, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bw, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.c cVar, bq bqVar) {
        super.a(i, view, viewGroup, (ViewGroup) cVar, (com.baidu.tbadk.core.data.c) bqVar);
        b(i, view, viewGroup, cVar, bqVar);
        a(bqVar, cVar);
        return view;
    }

    private void a(bq bqVar, com.baidu.tbadk.core.data.c cVar) {
        if (cVar == null || cVar.Nb == null) {
            bqVar.bhV.setVisibility(8);
            return;
        }
        List<String> list = cVar.Nb.Np;
        if (list == null || list.size() <= 0) {
            bqVar.bhV.setVisibility(8);
        } else if (!com.baidu.tbadk.core.l.ob().oh()) {
            bqVar.bhV.setVisibility(8);
        } else {
            bqVar.bhV.setVisibility(0);
            int size = list.size();
            a(bqVar, size);
            int i = this.mIsFromCDN ? 30 : 31;
            if (size == 1) {
                bqVar.bib.c(list.get(0), i, false);
            } else if (size == 2) {
                bqVar.bib.c(list.get(0), i, false);
                bqVar.bic.c(list.get(1), i, false);
            } else if (size >= 3) {
                bqVar.bib.c(list.get(0), i, false);
                bqVar.bic.c(list.get(1), i, false);
                bqVar.bie.c(list.get(2), i, false);
            }
        }
    }

    private void a(bq bqVar, int i) {
        if (i > 0) {
            if (i == 1) {
                bqVar.bib.setVisibility(0);
                bqVar.bic.setVisibility(4);
                bqVar.bie.setVisibility(4);
            } else if (i == 2) {
                bqVar.bib.setVisibility(0);
                bqVar.bic.setVisibility(0);
                bqVar.bie.setVisibility(4);
            } else {
                bqVar.bib.setVisibility(0);
                bqVar.bic.setVisibility(0);
                bqVar.bie.setVisibility(0);
            }
        }
    }

    private void b(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.c cVar, bq bqVar) {
        int i2;
        if (this.bek == null || cVar == null || cVar.Nb == null || this.bek == null) {
            return;
        }
        if ((this.bek instanceof FrsActivity) || (this.bek instanceof ff)) {
            if (this.bek instanceof FrsActivity) {
                ((FrsActivity) this.bek).Qd().RF();
            }
            if (this.bek instanceof ff) {
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
            bqVar.bhU.setPadding(0, i2, 0, 0);
            this.bek.getLayoutMode().ae(this.mSkinType == 1);
            this.bek.getLayoutMode().x(view);
            if (cVar.Nd) {
                if (bqVar.bii == null) {
                    bqVar.bii = (ViewGroup) bqVar.bih.inflate().findViewById(t.g.frs_item_adkiller_tip);
                    a.a(this.bek.getPageContext(), bqVar.bii);
                }
                bqVar.bii.setVisibility(0);
                bqVar.bii.setOnClickListener(new bp(this, cVar));
                if (!this.bhO.contains(cVar.Nf)) {
                    this.bhO.add(cVar.Nf);
                    com.baidu.tbadk.core.util.aw awVar = new com.baidu.tbadk.core.util.aw("c10828");
                    awVar.ac("obj_id", new StringBuilder(String.valueOf(cVar.getFid())).toString());
                    TiebaStatic.log(awVar);
                }
            } else if (bqVar.bii != null) {
                bqVar.bii.setVisibility(8);
            }
            if (cVar.Ng) {
                if (bqVar.bik == null) {
                    bqVar.bik = (ViewGroup) bqVar.bij.inflate().findViewById(t.g.item_adkiller_close);
                    a.a(this.bek.getPageContext(), bqVar.bik);
                }
                bqVar.bik.setVisibility(0);
                bqVar.bik.setOnClickListener(this.bhf);
                bqVar.bik.setTag(Integer.valueOf(i));
            } else if (bqVar.bik != null) {
                bqVar.bik.setVisibility(8);
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
            bqVar.bhX.setText(hL(cVar.Nb.userName));
            if (StringUtils.isNull(cVar.Nb.Ni)) {
                bqVar.bhZ.setVisibility(8);
            } else {
                bqVar.bhZ.setVisibility(0);
                bqVar.bhZ.setText(cVar.Nb.Ni);
            }
            if (StringUtils.isNull(cVar.Nb.Nj)) {
                bqVar.bia.setVisibility(8);
            } else {
                bqVar.bia.setVisibility(0);
                bqVar.bia.setText(cVar.Nb.Nj);
            }
            bqVar.bhY.setText(com.baidu.tbadk.core.util.ay.x(cVar.Na));
            if (com.baidu.tbadk.core.l.ob().od()) {
                bqVar.bhW.setVisibility(0);
                bqVar.bhW.c(cVar.Nb.userPortrait, this.mIsFromCDN ? 13 : 14, false);
            } else {
                bqVar.bhW.setVisibility(8);
            }
            bqVar.bhW.setTag(cVar.Nb.userPortrait);
            bqVar.bif.setVisibility(0);
            bqVar.bif.setTag(Integer.valueOf(i));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bqVar.bhX.getLayoutParams();
            layoutParams.width = -2;
            if (cVar.oH()) {
                bqVar.ZT.setVisibility(8);
                if (StringUtils.isNull(cVar.Nb.EZ)) {
                    bqVar.bif.setVisibility(8);
                    layoutParams.width = -1;
                    return;
                }
                a(true, bqVar);
                bqVar.bif.setText(cVar.Nb.EZ);
                bqVar.bif.setOnClickListener(this.bhd);
            } else if (cVar.oG()) {
                this.bhS.setId(cVar.MS);
                this.bhS.setUrl(cVar.MR);
                this.bhS.setName(cVar.MO);
                this.bhS.setPosition(i);
                this.bhS.setNotifyId(b.g(cVar.MN, 0));
                this.bhS.setStatus(AppDownloadView.b(this.bhS));
                int status = this.bhS.getStatus();
                bqVar.ZT.setVisibility(status == 5 || status == 1 || status == 7 ? 0 : 8);
                bqVar.ZT.a(this.yd, this.bhS);
                a(true, bqVar);
                switch (status) {
                    case 1:
                        bqVar.bif.setText(t.j.downloading2);
                        break;
                    case 3:
                        bqVar.bif.setText(t.j.frs_new_style_download_text);
                        break;
                    case 6:
                        if (TextUtils.isEmpty(cVar.Nb.EZ) || TextUtils.isEmpty(cVar.Nb.EZ.trim())) {
                            bqVar.bif.setText(t.j.pb_app_download);
                            break;
                        } else {
                            bqVar.bif.setText(cVar.Nb.EZ);
                            break;
                        }
                        break;
                    case 7:
                        bqVar.bif.setText(t.j.frs_new_style_download_pause);
                        break;
                }
                ((AppDownloadView.a) this.bhe).b(bqVar.ZT);
                bqVar.bif.setOnClickListener(this.bhe);
            }
        }
    }

    private void a(boolean z, bq bqVar) {
        com.baidu.tbadk.core.util.at.k(bqVar.bif, t.f.btn_appdownload);
        com.baidu.tbadk.core.util.at.c(bqVar.bif, t.d.cp_cont_i, 1);
    }

    private String hL(String str) {
        if (!TextUtils.isEmpty(str) && str.length() > 14) {
            return str.substring(0, 14);
        }
        return str;
    }
}
