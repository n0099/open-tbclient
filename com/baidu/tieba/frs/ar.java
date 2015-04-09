package com.baidu.tieba.frs;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class ar extends av<com.baidu.tbadk.core.data.c, at> {
    private View.OnClickListener aJE;
    private View.OnClickListener aJF;

    /* JADX INFO: Access modifiers changed from: protected */
    public ar(FrsActivity frsActivity, BdUniqueId bdUniqueId) {
        super(frsActivity, bdUniqueId);
    }

    private void a(boolean z, at atVar) {
        if (z) {
            com.baidu.tbadk.core.util.ba.i((View) atVar.aKE, com.baidu.tieba.u.frs_praise_btn_bg);
            com.baidu.tbadk.core.util.ba.b(atVar.aKE, com.baidu.tieba.s.cp_cont_f, 1);
            return;
        }
        com.baidu.tbadk.core.util.ba.i((View) atVar.aKE, com.baidu.tieba.u.btn_content_download_d);
        com.baidu.tbadk.core.util.ba.b(atVar.aKE, com.baidu.tieba.s.faceshop_downloaded_text, 1);
    }

    public void h(View.OnClickListener onClickListener) {
        this.aJE = onClickListener;
    }

    public void i(View.OnClickListener onClickListener) {
        this.aJF = onClickListener;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: e */
    public at a(ViewGroup viewGroup) {
        return new at(com.baidu.adp.lib.g.b.hH().inflate(this.mContext, com.baidu.tieba.w.frs_item_app, null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.av, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.c cVar, at atVar) {
        super.a(i, view, viewGroup, (ViewGroup) cVar, (com.baidu.tbadk.core.data.c) atVar);
        if (this.aKd == null) {
            return null;
        }
        if (this.aKd != null) {
            this.aKd.oi().KO();
        }
        atVar.aKA.setPadding(0, i - this.aKN == 0 ? this.aIb : this.aIc, 0, 0);
        this.aKd.getLayoutMode().X(this.mSkinType == 1);
        this.aKd.getLayoutMode().h(view);
        if (cVar instanceof com.baidu.tbadk.core.data.c) {
            if (!cVar.Pn) {
                cVar.Pn = true;
                this.aKd.a(cVar, "show");
                this.aKd.b(cVar, "show");
            }
            atVar.mTitle.setText(cVar.Pm.userName);
            atVar.aKD.setText(cVar.Pm.Pp);
            if (com.baidu.tbadk.core.n.px().pB()) {
                atVar.aKC.setVisibility(0);
                atVar.aKC.c(cVar.Pm.userPortrait, this.mIsFromCDN ? 13 : 14, false);
            } else {
                atVar.aKC.setVisibility(8);
            }
            atVar.aKC.setTag(cVar.Pm.userPortrait);
            atVar.aKE.setTag(Integer.valueOf(i));
            com.baidu.tbadk.core.util.ba.i((View) atVar.aKB, com.baidu.tieba.u.bg_label);
            if (cVar.pQ()) {
                a(true, atVar);
                atVar.aKE.setText(com.baidu.tieba.y.view);
                atVar.aKE.setOnClickListener(this.aJE);
                return view;
            } else if (cVar.pP()) {
                switch (cVar.OX) {
                    case 0:
                        a(true, atVar);
                        atVar.aKE.setText(com.baidu.tieba.y.game_center_download);
                        atVar.aKE.setOnClickListener(this.aJF);
                        return view;
                    case 1:
                        a(false, atVar);
                        atVar.aKE.setText(com.baidu.tieba.y.downloading2);
                        atVar.aKE.setOnClickListener(null);
                        return view;
                    case 2:
                        a(true, atVar);
                        atVar.aKE.setText(com.baidu.tieba.y.frs_old_style_download_text);
                        atVar.aKE.setOnClickListener(this.aJF);
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
