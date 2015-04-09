package com.baidu.tieba.frs;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class as extends av<com.baidu.tbadk.core.data.c, au> {
    private View.OnClickListener aJF;

    /* JADX INFO: Access modifiers changed from: protected */
    public as(FrsActivity frsActivity, BdUniqueId bdUniqueId) {
        super(frsActivity, bdUniqueId);
    }

    public void i(View.OnClickListener onClickListener) {
        this.aJF = onClickListener;
    }

    private void a(boolean z, au auVar) {
        if (z) {
            com.baidu.tbadk.core.util.ba.i((View) auVar.aKL, com.baidu.tieba.u.btn_appdownload);
            com.baidu.tbadk.core.util.ba.b(auVar.aKL, com.baidu.tieba.s.cp_cont_i, 1);
            return;
        }
        com.baidu.tbadk.core.util.ba.i((View) auVar.aKL, com.baidu.tieba.u.btn_content_download_d);
        com.baidu.tbadk.core.util.ba.b(auVar.aKL, com.baidu.tieba.s.faceshop_downloaded_text, 1);
    }

    private String fM(String str) {
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
        return new au(com.baidu.adp.lib.g.b.hH().inflate(this.mContext, com.baidu.tieba.w.frs_item_app_new, null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.av, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.c cVar, au auVar) {
        super.a(i, view, viewGroup, (ViewGroup) cVar, (com.baidu.tbadk.core.data.c) auVar);
        if (this.aKd == null) {
            return null;
        }
        if (this.aKd != null) {
            this.aKd.oi().KO();
        }
        auVar.aKF.setPadding(0, i - this.aKN == 0 ? this.aIb : this.aIc, 0, 0);
        this.aKd.getLayoutMode().X(this.mSkinType == 1);
        this.aKd.getLayoutMode().h(view);
        if (cVar instanceof com.baidu.tbadk.core.data.c) {
            if (!cVar.Pn) {
                cVar.Pn = true;
                this.aKd.a(cVar, "show");
                this.aKd.b(cVar, "show");
            }
            auVar.aKH.setText(fM(cVar.Pm.userName));
            if (cVar.Pm == null) {
                return null;
            }
            if (TextUtils.isEmpty(cVar.Pm.Pp) || TextUtils.isEmpty(cVar.Pm.Pp.trim())) {
                auVar.aKJ.setVisibility(8);
            } else {
                auVar.aKJ.setVisibility(0);
                auVar.aKJ.setText(cVar.Pm.Pp);
            }
            auVar.aKI.setText(com.baidu.tbadk.core.util.bd.n(cVar.Pl));
            if (com.baidu.tbadk.core.n.px().pz()) {
                auVar.aKG.setVisibility(0);
                auVar.aKG.c(cVar.Pm.userPortrait, this.mIsFromCDN ? 13 : 14, false);
            } else {
                auVar.aKG.setVisibility(8);
            }
            auVar.aKG.setTag(cVar.Pm.userPortrait);
            if (com.baidu.tbadk.core.n.px().pB() && !TextUtils.isEmpty(cVar.Pm.Pq)) {
                auVar.aKK.setVisibility(0);
                auVar.aKK.c(cVar.Pm.Pq, this.mIsFromCDN ? 30 : 31, false);
                auVar.aKJ.setPadding(0, 0, 0, 0);
            } else {
                auVar.aKK.setVisibility(8);
                auVar.aKJ.setPadding(0, 0, 0, this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.t.ds30));
            }
            auVar.aKL.setTag(Integer.valueOf(i));
            if (cVar.pQ()) {
                auVar.aKL.setVisibility(8);
                return view;
            } else if (cVar.pP()) {
                auVar.aKL.setVisibility(0);
                switch (cVar.OX) {
                    case 0:
                        a(true, auVar);
                        auVar.aKL.setText(com.baidu.tieba.y.pb_app_download);
                        auVar.aKL.setOnClickListener(this.aJF);
                        return view;
                    case 1:
                        a(false, auVar);
                        auVar.aKL.setText(com.baidu.tieba.y.downloading2);
                        auVar.aKL.setOnClickListener(null);
                        return view;
                    case 2:
                        a(true, auVar);
                        auVar.aKL.setText(com.baidu.tieba.y.frs_new_style_download_text);
                        auVar.aKL.setOnClickListener(this.aJF);
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
