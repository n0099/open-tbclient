package com.baidu.tieba.frs;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class as extends av<com.baidu.tbadk.core.data.c, au> {
    private View.OnClickListener aLL;
    private View.OnClickListener aLM;

    /* JADX INFO: Access modifiers changed from: protected */
    public as(FrsActivity frsActivity, BdUniqueId bdUniqueId) {
        super(frsActivity, bdUniqueId);
    }

    public void i(View.OnClickListener onClickListener) {
        this.aLM = onClickListener;
    }

    public void h(View.OnClickListener onClickListener) {
        this.aLL = onClickListener;
    }

    private void a(boolean z, au auVar) {
        if (z) {
            com.baidu.tbadk.core.util.ay.i((View) auVar.aMS, com.baidu.tieba.p.btn_appdownload);
            com.baidu.tbadk.core.util.ay.b(auVar.aMS, com.baidu.tieba.n.cp_cont_i, 1);
            return;
        }
        com.baidu.tbadk.core.util.ay.i((View) auVar.aMS, com.baidu.tieba.p.btn_content_download_d);
        com.baidu.tbadk.core.util.ay.b(auVar.aMS, com.baidu.tieba.n.faceshop_downloaded_text, 1);
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
        if (this.aMk == null) {
            return null;
        }
        if (this.aMk != null) {
            this.aMk.oy().LT();
        }
        auVar.aMM.setPadding(0, i - this.aMU == 0 ? this.aKj : this.aKk, 0, 0);
        this.aMk.getLayoutMode().ab(this.mSkinType == 1);
        this.aMk.getLayoutMode().j(view);
        if (cVar instanceof com.baidu.tbadk.core.data.c) {
            if (!cVar.PJ) {
                cVar.PJ = true;
                this.aMk.a(cVar, "show");
                this.aMk.b(cVar, "show");
            }
            auVar.aMO.setText(gm(cVar.PH.userName));
            if (cVar.PH == null) {
                return null;
            }
            if (TextUtils.isEmpty(cVar.PH.PL) || TextUtils.isEmpty(cVar.PH.PL.trim())) {
                auVar.aMQ.setVisibility(8);
            } else {
                auVar.aMQ.setVisibility(0);
                auVar.aMQ.setText(cVar.PH.PL);
            }
            auVar.aMP.setText(com.baidu.tbadk.core.util.bb.o(cVar.PG));
            if (com.baidu.tbadk.core.n.qc().qe()) {
                auVar.aMN.setVisibility(0);
                auVar.aMN.c(cVar.PH.userPortrait, this.mIsFromCDN ? 13 : 14, false);
            } else {
                auVar.aMN.setVisibility(8);
            }
            auVar.aMN.setTag(cVar.PH.userPortrait);
            if (com.baidu.tbadk.core.n.qc().qg() && !TextUtils.isEmpty(cVar.PH.PM)) {
                auVar.aMR.setVisibility(0);
                auVar.aMR.c(cVar.PH.PM, this.mIsFromCDN ? 30 : 31, false);
                auVar.aMQ.setPadding(0, 0, 0, 0);
            } else {
                auVar.aMR.setVisibility(8);
                auVar.aMQ.setPadding(0, 0, 0, this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.o.ds30));
            }
            auVar.aMS.setTag(Integer.valueOf(i));
            if (cVar.qw()) {
                if (!TextUtils.isEmpty(cVar.PH.PR) && !TextUtils.isEmpty(cVar.PH.PR.trim())) {
                    a(true, auVar);
                    auVar.aMS.setText(cVar.PH.PR);
                    auVar.aMS.setOnClickListener(this.aLL);
                    return view;
                }
                auVar.aMS.setVisibility(8);
                return view;
            } else if (cVar.qv()) {
                auVar.aMS.setVisibility(0);
                switch (cVar.Pr) {
                    case 0:
                        if (TextUtils.isEmpty(cVar.PH.PR) || TextUtils.isEmpty(cVar.PH.PR.trim())) {
                            auVar.aMS.setText(com.baidu.tieba.t.pb_app_download);
                        } else {
                            auVar.aMS.setText(cVar.PH.PR);
                        }
                        a(true, auVar);
                        auVar.aMS.setOnClickListener(this.aLM);
                        return view;
                    case 1:
                        a(false, auVar);
                        auVar.aMS.setText(com.baidu.tieba.t.downloading2);
                        auVar.aMS.setOnClickListener(null);
                        return view;
                    case 2:
                        a(true, auVar);
                        auVar.aMS.setText(com.baidu.tieba.t.frs_new_style_download_text);
                        auVar.aMS.setOnClickListener(this.aLM);
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
