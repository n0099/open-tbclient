package com.baidu.tieba.frs;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class as extends av<com.baidu.tbadk.core.data.c, au> {
    private View.OnClickListener aJv;

    /* JADX INFO: Access modifiers changed from: protected */
    public as(FrsActivity frsActivity, BdUniqueId bdUniqueId) {
        super(frsActivity, bdUniqueId);
    }

    public void i(View.OnClickListener onClickListener) {
        this.aJv = onClickListener;
    }

    private void a(boolean z, au auVar) {
        if (z) {
            com.baidu.tbadk.core.util.ba.i((View) auVar.aKB, com.baidu.tieba.u.btn_appdownload);
            com.baidu.tbadk.core.util.ba.b(auVar.aKB, com.baidu.tieba.s.cp_cont_i, 1);
            return;
        }
        com.baidu.tbadk.core.util.ba.i((View) auVar.aKB, com.baidu.tieba.u.btn_content_download_d);
        com.baidu.tbadk.core.util.ba.b(auVar.aKB, com.baidu.tieba.s.faceshop_downloaded_text, 1);
    }

    private String fJ(String str) {
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
        if (this.aJT == null) {
            return null;
        }
        if (this.aJT != null) {
            this.aJT.oi().KC();
        }
        auVar.aKv.setPadding(0, i - this.aKD == 0 ? this.aHT : this.aHU, 0, 0);
        this.aJT.getLayoutMode().X(this.mSkinType == 1);
        this.aJT.getLayoutMode().h(view);
        if (cVar instanceof com.baidu.tbadk.core.data.c) {
            if (!cVar.Pl) {
                cVar.Pl = true;
                this.aJT.a(cVar, "show");
                this.aJT.b(cVar, "show");
            }
            auVar.aKx.setText(fJ(cVar.Pk.userName));
            if (cVar.Pk == null) {
                return null;
            }
            if (TextUtils.isEmpty(cVar.Pk.Pn) || TextUtils.isEmpty(cVar.Pk.Pn.trim())) {
                auVar.aKz.setVisibility(8);
            } else {
                auVar.aKz.setVisibility(0);
                auVar.aKz.setText(cVar.Pk.Pn);
            }
            auVar.aKy.setText(com.baidu.tbadk.core.util.bd.n(cVar.Pj));
            if (com.baidu.tbadk.core.n.px().pz()) {
                auVar.aKw.setVisibility(0);
                auVar.aKw.c(cVar.Pk.userPortrait, this.mIsFromCDN ? 13 : 14, false);
            } else {
                auVar.aKw.setVisibility(8);
            }
            auVar.aKw.setTag(cVar.Pk.userPortrait);
            if (com.baidu.tbadk.core.n.px().pB() && !TextUtils.isEmpty(cVar.Pk.Po)) {
                auVar.aKA.setVisibility(0);
                auVar.aKA.c(cVar.Pk.Po, this.mIsFromCDN ? 30 : 31, false);
                auVar.aKz.setPadding(0, 0, 0, 0);
            } else {
                auVar.aKA.setVisibility(8);
                auVar.aKz.setPadding(0, 0, 0, this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.t.ds30));
            }
            auVar.aKB.setTag(Integer.valueOf(i));
            if (cVar.pQ()) {
                auVar.aKB.setVisibility(8);
                return view;
            } else if (cVar.pP()) {
                auVar.aKB.setVisibility(0);
                switch (cVar.OV) {
                    case 0:
                        a(true, auVar);
                        auVar.aKB.setText(com.baidu.tieba.y.pb_app_download);
                        auVar.aKB.setOnClickListener(this.aJv);
                        return view;
                    case 1:
                        a(false, auVar);
                        auVar.aKB.setText(com.baidu.tieba.y.downloading2);
                        auVar.aKB.setOnClickListener(null);
                        return view;
                    case 2:
                        a(true, auVar);
                        auVar.aKB.setText(com.baidu.tieba.y.frs_new_style_download_text);
                        auVar.aKB.setOnClickListener(this.aJv);
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
