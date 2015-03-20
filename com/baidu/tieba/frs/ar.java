package com.baidu.tieba.frs;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class ar extends av<com.baidu.tbadk.core.data.c, at> {
    private View.OnClickListener aJu;
    private View.OnClickListener aJv;

    /* JADX INFO: Access modifiers changed from: protected */
    public ar(FrsActivity frsActivity, BdUniqueId bdUniqueId) {
        super(frsActivity, bdUniqueId);
    }

    private void a(boolean z, at atVar) {
        if (z) {
            com.baidu.tbadk.core.util.ba.i((View) atVar.aKu, com.baidu.tieba.u.frs_praise_btn_bg);
            com.baidu.tbadk.core.util.ba.b(atVar.aKu, com.baidu.tieba.s.cp_cont_f, 1);
            return;
        }
        com.baidu.tbadk.core.util.ba.i((View) atVar.aKu, com.baidu.tieba.u.btn_content_download_d);
        com.baidu.tbadk.core.util.ba.b(atVar.aKu, com.baidu.tieba.s.faceshop_downloaded_text, 1);
    }

    public void h(View.OnClickListener onClickListener) {
        this.aJu = onClickListener;
    }

    public void i(View.OnClickListener onClickListener) {
        this.aJv = onClickListener;
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
        if (this.aJT == null) {
            return null;
        }
        if (this.aJT != null) {
            this.aJT.oi().KC();
        }
        atVar.aKq.setPadding(0, i - this.aKD == 0 ? this.aHT : this.aHU, 0, 0);
        this.aJT.getLayoutMode().X(this.mSkinType == 1);
        this.aJT.getLayoutMode().h(view);
        if (cVar instanceof com.baidu.tbadk.core.data.c) {
            if (!cVar.Pl) {
                cVar.Pl = true;
                this.aJT.a(cVar, "show");
                this.aJT.b(cVar, "show");
            }
            atVar.mTitle.setText(cVar.Pk.userName);
            atVar.aKt.setText(cVar.Pk.Pn);
            if (com.baidu.tbadk.core.n.px().pB()) {
                atVar.aKs.setVisibility(0);
                atVar.aKs.c(cVar.Pk.userPortrait, this.mIsFromCDN ? 13 : 14, false);
            } else {
                atVar.aKs.setVisibility(8);
            }
            atVar.aKs.setTag(cVar.Pk.userPortrait);
            atVar.aKu.setTag(Integer.valueOf(i));
            com.baidu.tbadk.core.util.ba.i((View) atVar.aKr, com.baidu.tieba.u.bg_label);
            if (cVar.pQ()) {
                a(true, atVar);
                atVar.aKu.setText(com.baidu.tieba.y.view);
                atVar.aKu.setOnClickListener(this.aJu);
                return view;
            } else if (cVar.pP()) {
                switch (cVar.OV) {
                    case 0:
                        a(true, atVar);
                        atVar.aKu.setText(com.baidu.tieba.y.game_center_download);
                        atVar.aKu.setOnClickListener(this.aJv);
                        return view;
                    case 1:
                        a(false, atVar);
                        atVar.aKu.setText(com.baidu.tieba.y.downloading2);
                        atVar.aKu.setOnClickListener(null);
                        return view;
                    case 2:
                        a(true, atVar);
                        atVar.aKu.setText(com.baidu.tieba.y.frs_old_style_download_text);
                        atVar.aKu.setOnClickListener(this.aJv);
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
