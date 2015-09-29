package com.baidu.tieba.frs;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class bh extends bn<com.baidu.tbadk.core.data.b, bl> {
    private View.OnClickListener aUo;
    private View.OnClickListener aUp;

    /* JADX INFO: Access modifiers changed from: protected */
    public bh(BaseActivity baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
    }

    private void a(boolean z, bl blVar) {
        if (z) {
            com.baidu.tbadk.core.util.am.i((View) blVar.aVS, i.e.frs_praise_btn_bg);
            com.baidu.tbadk.core.util.am.b(blVar.aVS, i.c.cp_cont_f, 1);
            return;
        }
        com.baidu.tbadk.core.util.am.i((View) blVar.aVS, i.e.btn_content_download_d);
        com.baidu.tbadk.core.util.am.b(blVar.aVS, i.c.faceshop_downloaded_text, 1);
    }

    public void h(View.OnClickListener onClickListener) {
        this.aUo = onClickListener;
    }

    public void i(View.OnClickListener onClickListener) {
        this.aUp = onClickListener;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: f */
    public bl a(ViewGroup viewGroup) {
        return new bl(LayoutInflater.from(this.mContext).inflate(i.g.frs_item_app, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bn, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.b bVar, bl blVar) {
        super.a(i, view, viewGroup, (ViewGroup) bVar, (com.baidu.tbadk.core.data.b) blVar);
        if (this.aRT == null) {
            return null;
        }
        if (this.aRT != null && (this.aRT instanceof FrsActivity)) {
            ((FrsActivity) this.aRT).Lm().Nb();
        }
        blVar.aVO.setPadding(0, i - this.aTF == 0 ? this.aSG : this.aSH, 0, 0);
        this.aRT.getLayoutMode().ad(this.mSkinType == 1);
        this.aRT.getLayoutMode().k(view);
        if (bVar instanceof com.baidu.tbadk.core.data.b) {
            if (!bVar.Uj && (this.aRT instanceof FrsActivity)) {
                bVar.Uj = true;
                ((FrsActivity) this.aRT).a(bVar, "show");
                ((FrsActivity) this.aRT).b(bVar, "show");
            }
            blVar.aPf.setText(bVar.Ui.userName);
            blVar.aVR.setText(bVar.Ui.Ul);
            if (com.baidu.tbadk.core.m.qX().rb()) {
                blVar.aVQ.setVisibility(0);
                blVar.aVQ.d(bVar.Ui.userPortrait, this.mIsFromCDN ? 13 : 14, false);
            } else {
                blVar.aVQ.setVisibility(8);
            }
            blVar.aVQ.setTag(bVar.Ui.userPortrait);
            blVar.aVS.setTag(Integer.valueOf(i));
            com.baidu.tbadk.core.util.am.i((View) blVar.aVP, i.e.bg_label);
            if (bVar.rr()) {
                a(true, blVar);
                if (TextUtils.isEmpty(bVar.Ui.Us) || TextUtils.isEmpty(bVar.Ui.Us.trim())) {
                    blVar.aVS.setText(i.h.view);
                } else {
                    blVar.aVS.setText(bVar.Ui.Us);
                }
                blVar.aVS.setOnClickListener(this.aUo);
                return view;
            } else if (bVar.rq()) {
                switch (bVar.TT) {
                    case 0:
                        if (TextUtils.isEmpty(bVar.Ui.Us) || TextUtils.isEmpty(bVar.Ui.Us.trim())) {
                            blVar.aVS.setText(i.h.game_center_download);
                        } else {
                            blVar.aVS.setText(bVar.Ui.Us);
                        }
                        a(true, blVar);
                        blVar.aVS.setOnClickListener(this.aUp);
                        return view;
                    case 1:
                        a(false, blVar);
                        blVar.aVS.setText(i.h.downloading2);
                        blVar.aVS.setOnClickListener(null);
                        return view;
                    case 2:
                        a(true, blVar);
                        blVar.aVS.setText(i.h.frs_old_style_download_text);
                        blVar.aVS.setOnClickListener(this.aUp);
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
