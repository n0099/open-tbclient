package com.baidu.tieba.frs;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class ar extends av<com.baidu.tbadk.core.data.c, at> {
    private View.OnClickListener aLL;
    private View.OnClickListener aLM;

    /* JADX INFO: Access modifiers changed from: protected */
    public ar(FrsActivity frsActivity, BdUniqueId bdUniqueId) {
        super(frsActivity, bdUniqueId);
    }

    private void a(boolean z, at atVar) {
        if (z) {
            com.baidu.tbadk.core.util.ay.i((View) atVar.aML, com.baidu.tieba.p.frs_praise_btn_bg);
            com.baidu.tbadk.core.util.ay.b(atVar.aML, com.baidu.tieba.n.cp_cont_f, 1);
            return;
        }
        com.baidu.tbadk.core.util.ay.i((View) atVar.aML, com.baidu.tieba.p.btn_content_download_d);
        com.baidu.tbadk.core.util.ay.b(atVar.aML, com.baidu.tieba.n.faceshop_downloaded_text, 1);
    }

    public void h(View.OnClickListener onClickListener) {
        this.aLL = onClickListener;
    }

    public void i(View.OnClickListener onClickListener) {
        this.aLM = onClickListener;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: e */
    public at a(ViewGroup viewGroup) {
        return new at(com.baidu.adp.lib.g.b.hr().inflate(this.mContext, com.baidu.tieba.r.frs_item_app, null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.av, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.c cVar, at atVar) {
        super.a(i, view, viewGroup, (ViewGroup) cVar, (com.baidu.tbadk.core.data.c) atVar);
        if (this.aMk == null) {
            return null;
        }
        if (this.aMk != null) {
            this.aMk.oy().LT();
        }
        atVar.aMH.setPadding(0, i - this.aMU == 0 ? this.aKj : this.aKk, 0, 0);
        this.aMk.getLayoutMode().ab(this.mSkinType == 1);
        this.aMk.getLayoutMode().j(view);
        if (cVar instanceof com.baidu.tbadk.core.data.c) {
            if (!cVar.PJ) {
                cVar.PJ = true;
                this.aMk.a(cVar, "show");
                this.aMk.b(cVar, "show");
            }
            atVar.mTitle.setText(cVar.PH.userName);
            atVar.aMK.setText(cVar.PH.PL);
            if (com.baidu.tbadk.core.n.qc().qg()) {
                atVar.aMJ.setVisibility(0);
                atVar.aMJ.c(cVar.PH.userPortrait, this.mIsFromCDN ? 13 : 14, false);
            } else {
                atVar.aMJ.setVisibility(8);
            }
            atVar.aMJ.setTag(cVar.PH.userPortrait);
            atVar.aML.setTag(Integer.valueOf(i));
            com.baidu.tbadk.core.util.ay.i((View) atVar.aMI, com.baidu.tieba.p.bg_label);
            if (cVar.qw()) {
                a(true, atVar);
                if (TextUtils.isEmpty(cVar.PH.PR) || TextUtils.isEmpty(cVar.PH.PR.trim())) {
                    atVar.aML.setText(com.baidu.tieba.t.view);
                } else {
                    atVar.aML.setText(cVar.PH.PR);
                }
                atVar.aML.setOnClickListener(this.aLL);
                return view;
            } else if (cVar.qv()) {
                switch (cVar.Pr) {
                    case 0:
                        if (TextUtils.isEmpty(cVar.PH.PR) || TextUtils.isEmpty(cVar.PH.PR.trim())) {
                            atVar.aML.setText(com.baidu.tieba.t.game_center_download);
                        } else {
                            atVar.aML.setText(cVar.PH.PR);
                        }
                        a(true, atVar);
                        atVar.aML.setOnClickListener(this.aLM);
                        return view;
                    case 1:
                        a(false, atVar);
                        atVar.aML.setText(com.baidu.tieba.t.downloading2);
                        atVar.aML.setOnClickListener(null);
                        return view;
                    case 2:
                        a(true, atVar);
                        atVar.aML.setText(com.baidu.tieba.t.frs_old_style_download_text);
                        atVar.aML.setOnClickListener(this.aLM);
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
