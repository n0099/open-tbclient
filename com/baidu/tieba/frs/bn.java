package com.baidu.tieba.frs;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.AppDownloadView;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.t;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/* loaded from: classes.dex */
public class bn extends bv<com.baidu.tbadk.core.data.c, bp> {
    private View.OnClickListener bgm;
    private View.OnClickListener bgn;
    private View.OnClickListener bgo;
    private Set<String> bhF;
    private DownloadData bhI;

    /* JADX INFO: Access modifiers changed from: protected */
    public bn(BaseActivity<?> baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
        this.bhF = new HashSet();
        this.bhI = new DownloadData();
    }

    public void m(View.OnClickListener onClickListener) {
        this.bgn = onClickListener;
    }

    public void l(View.OnClickListener onClickListener) {
        this.bgm = onClickListener;
    }

    public void n(View.OnClickListener onClickListener) {
        this.bgo = onClickListener;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: r */
    public bp b(ViewGroup viewGroup) {
        return new bp(LayoutInflater.from(this.mContext).inflate(t.h.frs_app_muti_pic_layout, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bv, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.c cVar, bp bpVar) {
        super.a(i, view, viewGroup, (ViewGroup) cVar, (com.baidu.tbadk.core.data.c) bpVar);
        b(i, view, viewGroup, cVar, bpVar);
        a(bpVar, cVar);
        return view;
    }

    private void a(bp bpVar, com.baidu.tbadk.core.data.c cVar) {
        if (cVar == null || cVar.UI == null) {
            bpVar.bhL.setVisibility(8);
            return;
        }
        List<String> list = cVar.UI.UX;
        if (list == null || list.size() <= 0) {
            bpVar.bhL.setVisibility(8);
        } else if (!com.baidu.tbadk.core.l.rn().rt()) {
            bpVar.bhL.setVisibility(8);
        } else {
            bpVar.bhL.setVisibility(0);
            int size = list.size();
            a(bpVar, size);
            int i = this.mIsFromCDN ? 30 : 31;
            if (size == 1) {
                bpVar.bhR.d(list.get(0), i, false);
            } else if (size == 2) {
                bpVar.bhR.d(list.get(0), i, false);
                bpVar.bhS.d(list.get(1), i, false);
            } else if (size >= 3) {
                bpVar.bhR.d(list.get(0), i, false);
                bpVar.bhS.d(list.get(1), i, false);
                bpVar.bhT.d(list.get(2), i, false);
            }
        }
    }

    private void a(bp bpVar, int i) {
        if (i > 0) {
            if (i == 1) {
                bpVar.bhR.setVisibility(0);
                bpVar.bhS.setVisibility(4);
                bpVar.bhT.setVisibility(4);
            } else if (i == 2) {
                bpVar.bhR.setVisibility(0);
                bpVar.bhS.setVisibility(0);
                bpVar.bhT.setVisibility(4);
            } else {
                bpVar.bhR.setVisibility(0);
                bpVar.bhS.setVisibility(0);
                bpVar.bhT.setVisibility(0);
            }
        }
    }

    private void b(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.c cVar, bp bpVar) {
        if (this.bdK != null && cVar != null && cVar.UI != null && this.bdK != null && (this.bdK instanceof FrsActivity)) {
            ((FrsActivity) this.bdK).Po().Rr();
            bpVar.bhK.setPadding(0, i - this.bfz == 0 ? this.beB : this.beC, 0, 0);
            this.bdK.getLayoutMode().ac(this.mSkinType == 1);
            this.bdK.getLayoutMode().x(view);
            if (cVar.UK) {
                if (bpVar.bhW == null) {
                    bpVar.bhW = (ViewGroup) bpVar.bhV.inflate().findViewById(t.g.frs_item_adkiller_tip);
                    com.baidu.tbadk.i.a.a(this.bdK.getPageContext(), bpVar.bhW);
                }
                bpVar.bhW.setVisibility(0);
                bpVar.bhW.setOnClickListener(new bo(this, cVar));
                if (!this.bhF.contains(cVar.UM)) {
                    this.bhF.add(cVar.UM);
                    com.baidu.tbadk.core.util.au auVar = new com.baidu.tbadk.core.util.au("c10828");
                    auVar.aa("obj_id", new StringBuilder(String.valueOf(cVar.getFid())).toString());
                    TiebaStatic.log(auVar);
                }
            } else if (bpVar.bhW != null) {
                bpVar.bhW.setVisibility(8);
            }
            if (cVar.UN) {
                if (bpVar.bhY == null) {
                    bpVar.bhY = (ViewGroup) bpVar.bhX.inflate().findViewById(t.g.item_adkiller_close);
                    com.baidu.tbadk.i.a.a(this.bdK.getPageContext(), bpVar.bhY);
                }
                bpVar.bhY.setVisibility(0);
                bpVar.bhY.setOnClickListener(this.bgo);
                bpVar.bhY.setTag(Integer.valueOf(i));
            } else if (bpVar.bhY != null) {
                bpVar.bhY.setVisibility(8);
            }
            if (!cVar.UJ && this.bdK != null && (this.bdK instanceof FrsActivity)) {
                cVar.UJ = true;
                ((FrsActivity) this.bdK).a(cVar, "show");
                ((FrsActivity) this.bdK).b(cVar, "show");
            }
            bpVar.bhN.setText(hu(cVar.UI.userName));
            if (StringUtils.isNull(cVar.UI.UQ)) {
                bpVar.bhP.setVisibility(8);
            } else {
                bpVar.bhP.setVisibility(0);
                bpVar.bhP.setText(cVar.UI.UQ);
            }
            if (StringUtils.isNull(cVar.UI.UR)) {
                bpVar.bhQ.setVisibility(8);
            } else {
                bpVar.bhQ.setVisibility(0);
                bpVar.bhQ.setText(cVar.UI.UR);
            }
            bpVar.bhO.setText(com.baidu.tbadk.core.util.aw.t(cVar.UH));
            if (com.baidu.tbadk.core.l.rn().rp()) {
                bpVar.bhM.setVisibility(0);
                bpVar.bhM.d(cVar.UI.userPortrait, this.mIsFromCDN ? 13 : 14, false);
            } else {
                bpVar.bhM.setVisibility(8);
            }
            bpVar.bhM.setTag(cVar.UI.userPortrait);
            bpVar.bhU.setVisibility(0);
            bpVar.bhU.setTag(Integer.valueOf(i));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bpVar.bhN.getLayoutParams();
            layoutParams.width = -2;
            if (cVar.rO()) {
                bpVar.bgO.setVisibility(8);
                if (StringUtils.isNull(cVar.UI.OC)) {
                    bpVar.bhU.setVisibility(8);
                    layoutParams.width = -1;
                    return;
                }
                a(true, bpVar);
                bpVar.bhU.setText(cVar.UI.OC);
                bpVar.bhU.setOnClickListener(this.bgm);
            } else if (cVar.rN()) {
                this.bhI.setId(cVar.Uy);
                this.bhI.setUrl(cVar.Ux);
                this.bhI.setName(cVar.Uu);
                this.bhI.setPosition(i);
                this.bhI.setNotifyId(com.baidu.adp.lib.h.b.g(cVar.Ut, 0));
                int b = AppDownloadView.b(this.bhI);
                this.bhI.setStatus(b);
                bpVar.bgO.a(this.HF, this.bhI);
                a(true, bpVar);
                switch (b) {
                    case 1:
                        bpVar.bhU.setText(t.j.downloading2);
                        break;
                    case 3:
                        bpVar.bhU.setText(t.j.frs_new_style_download_text);
                        break;
                    case 6:
                        if (TextUtils.isEmpty(cVar.UI.OC) || TextUtils.isEmpty(cVar.UI.OC.trim())) {
                            bpVar.bhU.setText(t.j.pb_app_download);
                            break;
                        } else {
                            bpVar.bhU.setText(cVar.UI.OC);
                            break;
                        }
                        break;
                    case 7:
                        bpVar.bhU.setText(t.j.frs_new_style_download_pause);
                        break;
                }
                ((FrsActivity.b) this.bgn).b(bpVar.bgO);
                bpVar.bhU.setOnClickListener(this.bgn);
            }
        }
    }

    private void a(boolean z, bp bpVar) {
        com.baidu.tbadk.core.util.ar.k(bpVar.bhU, t.f.btn_appdownload);
        com.baidu.tbadk.core.util.ar.b(bpVar.bhU, t.d.cp_cont_i, 1);
    }

    private String hu(String str) {
        if (!TextUtils.isEmpty(str) && str.length() > 14) {
            return str.substring(0, 14);
        }
        return str;
    }
}
