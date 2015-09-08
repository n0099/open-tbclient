package com.baidu.tieba.frs;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class az extends bd<com.baidu.tbadk.core.data.c, bb> {
    private View.OnClickListener aVo;
    private View.OnClickListener aVp;

    /* JADX INFO: Access modifiers changed from: protected */
    public az(BaseActivity baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
    }

    private void a(boolean z, bb bbVar) {
        if (z) {
            com.baidu.tbadk.core.util.al.h((View) bbVar.aWt, i.e.frs_praise_btn_bg);
            com.baidu.tbadk.core.util.al.b(bbVar.aWt, i.c.cp_cont_f, 1);
            return;
        }
        com.baidu.tbadk.core.util.al.h((View) bbVar.aWt, i.e.btn_content_download_d);
        com.baidu.tbadk.core.util.al.b(bbVar.aWt, i.c.faceshop_downloaded_text, 1);
    }

    public void h(View.OnClickListener onClickListener) {
        this.aVo = onClickListener;
    }

    public void i(View.OnClickListener onClickListener) {
        this.aVp = onClickListener;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: f */
    public bb a(ViewGroup viewGroup) {
        return new bb(LayoutInflater.from(this.mContext).inflate(i.g.frs_item_app, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bd, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.c cVar, bb bbVar) {
        super.a(i, view, viewGroup, (ViewGroup) cVar, (com.baidu.tbadk.core.data.c) bbVar);
        if (this.aSX == null) {
            return null;
        }
        if (this.aSX != null && (this.aSX instanceof FrsActivity)) {
            ((FrsActivity) this.aSX).Lq().Nc();
        }
        bbVar.aWp.setPadding(0, i - this.aWC == 0 ? this.aTK : this.aTL, 0, 0);
        this.aSX.getLayoutMode().ad(this.mSkinType == 1);
        this.aSX.getLayoutMode().k(view);
        if (cVar instanceof com.baidu.tbadk.core.data.c) {
            if (!cVar.Ux && (this.aSX instanceof FrsActivity)) {
                cVar.Ux = true;
                ((FrsActivity) this.aSX).a(cVar, "show");
                ((FrsActivity) this.aSX).b(cVar, "show");
            }
            bbVar.aQj.setText(cVar.Uw.userName);
            bbVar.aWs.setText(cVar.Uw.Uz);
            if (com.baidu.tbadk.core.m.rb().rf()) {
                bbVar.aWr.setVisibility(0);
                bbVar.aWr.d(cVar.Uw.userPortrait, this.mIsFromCDN ? 13 : 14, false);
            } else {
                bbVar.aWr.setVisibility(8);
            }
            bbVar.aWr.setTag(cVar.Uw.userPortrait);
            bbVar.aWt.setTag(Integer.valueOf(i));
            com.baidu.tbadk.core.util.al.h((View) bbVar.aWq, i.e.bg_label);
            if (cVar.rw()) {
                a(true, bbVar);
                if (TextUtils.isEmpty(cVar.Uw.UF) || TextUtils.isEmpty(cVar.Uw.UF.trim())) {
                    bbVar.aWt.setText(i.h.view);
                } else {
                    bbVar.aWt.setText(cVar.Uw.UF);
                }
                bbVar.aWt.setOnClickListener(this.aVo);
                return view;
            } else if (cVar.rv()) {
                switch (cVar.Uh) {
                    case 0:
                        if (TextUtils.isEmpty(cVar.Uw.UF) || TextUtils.isEmpty(cVar.Uw.UF.trim())) {
                            bbVar.aWt.setText(i.h.game_center_download);
                        } else {
                            bbVar.aWt.setText(cVar.Uw.UF);
                        }
                        a(true, bbVar);
                        bbVar.aWt.setOnClickListener(this.aVp);
                        return view;
                    case 1:
                        a(false, bbVar);
                        bbVar.aWt.setText(i.h.downloading2);
                        bbVar.aWt.setOnClickListener(null);
                        return view;
                    case 2:
                        a(true, bbVar);
                        bbVar.aWt.setText(i.h.frs_old_style_download_text);
                        bbVar.aWt.setOnClickListener(this.aVp);
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
