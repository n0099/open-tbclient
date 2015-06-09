package com.baidu.tieba.frs;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class as extends av<com.baidu.tbadk.core.data.c, au> {
    private View.OnClickListener aLM;
    private View.OnClickListener aLN;

    /* JADX INFO: Access modifiers changed from: protected */
    public as(FrsActivity frsActivity, BdUniqueId bdUniqueId) {
        super(frsActivity, bdUniqueId);
    }

    public void i(View.OnClickListener onClickListener) {
        this.aLN = onClickListener;
    }

    public void h(View.OnClickListener onClickListener) {
        this.aLM = onClickListener;
    }

    private void a(boolean z, au auVar) {
        if (z) {
            com.baidu.tbadk.core.util.ay.i((View) auVar.aMT, com.baidu.tieba.p.btn_appdownload);
            com.baidu.tbadk.core.util.ay.b(auVar.aMT, com.baidu.tieba.n.cp_cont_i, 1);
            return;
        }
        com.baidu.tbadk.core.util.ay.i((View) auVar.aMT, com.baidu.tieba.p.btn_content_download_d);
        com.baidu.tbadk.core.util.ay.b(auVar.aMT, com.baidu.tieba.n.faceshop_downloaded_text, 1);
    }

    private String gm(String str) {
        if (!TextUtils.isEmpty(str) && str.length() > 14) {
            return str.substring(0, 14);
        }
        return str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: f */
    public au a(ViewGroup viewGroup) {
        return new au(com.baidu.adp.lib.g.b.hr().inflate(this.mContext, com.baidu.tieba.r.frs_item_app_new, null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.av, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.c cVar, au auVar) {
        super.a(i, view, viewGroup, (ViewGroup) cVar, (com.baidu.tbadk.core.data.c) auVar);
        if (this.aMl == null) {
            return null;
        }
        if (this.aMl != null) {
            this.aMl.oy().LU();
        }
        auVar.aMN.setPadding(0, i - this.aMV == 0 ? this.aKk : this.aKl, 0, 0);
        this.aMl.getLayoutMode().ab(this.mSkinType == 1);
        this.aMl.getLayoutMode().j(view);
        if (cVar instanceof com.baidu.tbadk.core.data.c) {
            if (!cVar.PJ) {
                cVar.PJ = true;
                this.aMl.a(cVar, "show");
                this.aMl.b(cVar, "show");
            }
            auVar.aMP.setText(gm(cVar.PH.userName));
            if (cVar.PH == null) {
                return null;
            }
            if (TextUtils.isEmpty(cVar.PH.PL) || TextUtils.isEmpty(cVar.PH.PL.trim())) {
                auVar.aMR.setVisibility(8);
            } else {
                auVar.aMR.setVisibility(0);
                auVar.aMR.setText(cVar.PH.PL);
            }
            auVar.aMQ.setText(com.baidu.tbadk.core.util.bb.o(cVar.PG));
            if (com.baidu.tbadk.core.n.qc().qe()) {
                auVar.aMO.setVisibility(0);
                auVar.aMO.c(cVar.PH.userPortrait, this.mIsFromCDN ? 13 : 14, false);
            } else {
                auVar.aMO.setVisibility(8);
            }
            auVar.aMO.setTag(cVar.PH.userPortrait);
            if (com.baidu.tbadk.core.n.qc().qg() && !TextUtils.isEmpty(cVar.PH.PM)) {
                auVar.aMS.setVisibility(0);
                auVar.aMS.c(cVar.PH.PM, this.mIsFromCDN ? 30 : 31, false);
                auVar.aMR.setPadding(0, 0, 0, 0);
            } else {
                auVar.aMS.setVisibility(8);
                auVar.aMR.setPadding(0, 0, 0, this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.o.ds30));
            }
            auVar.aMT.setTag(Integer.valueOf(i));
            if (cVar.qw()) {
                if (!TextUtils.isEmpty(cVar.PH.PR) && !TextUtils.isEmpty(cVar.PH.PR.trim())) {
                    a(true, auVar);
                    auVar.aMT.setText(cVar.PH.PR);
                    auVar.aMT.setOnClickListener(this.aLM);
                    return view;
                }
                auVar.aMT.setVisibility(8);
                return view;
            } else if (cVar.qv()) {
                auVar.aMT.setVisibility(0);
                switch (cVar.Pr) {
                    case 0:
                        if (TextUtils.isEmpty(cVar.PH.PR) || TextUtils.isEmpty(cVar.PH.PR.trim())) {
                            auVar.aMT.setText(com.baidu.tieba.t.pb_app_download);
                        } else {
                            auVar.aMT.setText(cVar.PH.PR);
                        }
                        a(true, auVar);
                        auVar.aMT.setOnClickListener(this.aLN);
                        return view;
                    case 1:
                        a(false, auVar);
                        auVar.aMT.setText(com.baidu.tieba.t.downloading2);
                        auVar.aMT.setOnClickListener(null);
                        return view;
                    case 2:
                        a(true, auVar);
                        auVar.aMT.setText(com.baidu.tieba.t.frs_new_style_download_text);
                        auVar.aMT.setOnClickListener(this.aLN);
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
}
