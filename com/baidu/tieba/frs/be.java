package com.baidu.tieba.frs;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.view.HeadImageView;
/* loaded from: classes.dex */
public class be extends bi<com.baidu.tbadk.core.data.c> {
    private View.OnClickListener aCK;
    private View.OnClickListener aCL;

    /* JADX INFO: Access modifiers changed from: protected */
    public be(FrsActivity frsActivity, BdUniqueId bdUniqueId) {
        super(frsActivity, bdUniqueId);
    }

    @Override // com.baidu.adp.widget.ListView.a
    protected View a(ViewGroup viewGroup) {
        View inflate = com.baidu.adp.lib.g.b.ek().inflate(this.mContext, com.baidu.tieba.x.frs_item_app, null);
        bf bfVar = new bf(null);
        bfVar.aDw = (LinearLayout) inflate.findViewById(com.baidu.tieba.w.app_parent);
        bfVar.mTitle = (TextView) inflate.findViewById(com.baidu.tieba.w.app_name);
        bfVar.avk = (TextView) inflate.findViewById(com.baidu.tieba.w.app_desc);
        bfVar.aDy = (HeadImageView) inflate.findViewById(com.baidu.tieba.w.app_icon);
        bfVar.aDy.setSupportNoImage(false);
        bfVar.aDz = (TextView) inflate.findViewById(com.baidu.tieba.w.app_download);
        bfVar.aDx = (TextView) inflate.findViewById(com.baidu.tieba.w.recommend_app);
        inflate.setTag(bfVar);
        return inflate;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bi, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View b(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.c cVar) {
        super.b(i, view, viewGroup, cVar);
        if (this.aDc != null) {
            this.aDc.FI();
        }
        bf bfVar = (bf) view.getTag();
        bfVar.aDw.setPadding(0, i - this.aDJ == 0 ? this.aBb : this.aBc, 0, 0);
        this.aDc.getLayoutMode().ab(this.mSkinType == 1);
        this.aDc.getLayoutMode().h(view);
        if (cVar instanceof com.baidu.tbadk.core.data.c) {
            if (!cVar.DA) {
                cVar.DA = true;
                this.aDc.a(cVar, "show");
                this.aDc.b(cVar, "show");
            }
            bfVar.mTitle.setText(cVar.Dz.userName);
            bfVar.avk.setText(cVar.Dz.DD);
            if (com.baidu.tbadk.core.l.mc().mg()) {
                bfVar.aDy.setVisibility(0);
                bfVar.aDy.d(cVar.Dz.userPortrait, this.mIsFromCDN ? 13 : 14, false);
            } else {
                bfVar.aDy.setVisibility(8);
            }
            bfVar.aDy.setTag(cVar.Dz.userPortrait);
            bfVar.aDz.setTag(Integer.valueOf(i));
            com.baidu.tbadk.core.util.ax.i((View) bfVar.aDx, com.baidu.tieba.v.bg_label);
            if (cVar.mw()) {
                a(true, bfVar);
                bfVar.aDz.setText(com.baidu.tieba.z.view);
                bfVar.aDz.setOnClickListener(this.aCK);
            } else if (cVar.mv()) {
                switch (cVar.Dk) {
                    case 0:
                        a(true, bfVar);
                        bfVar.aDz.setText(com.baidu.tieba.z.game_center_download);
                        bfVar.aDz.setOnClickListener(this.aCL);
                        break;
                    case 1:
                        a(false, bfVar);
                        bfVar.aDz.setText(com.baidu.tieba.z.downloading2);
                        bfVar.aDz.setOnClickListener(null);
                        break;
                    case 2:
                        a(true, bfVar);
                        bfVar.aDz.setText(com.baidu.tieba.z.frs_old_style_download_text);
                        bfVar.aDz.setOnClickListener(this.aCL);
                        break;
                }
            }
        }
        return view;
    }

    private void a(boolean z, bf bfVar) {
        if (z) {
            com.baidu.tbadk.core.util.ax.i((View) bfVar.aDz, com.baidu.tieba.v.frs_praise_btn_bg);
            com.baidu.tbadk.core.util.ax.b(bfVar.aDz, com.baidu.tieba.t.cp_cont_f, 1);
            return;
        }
        com.baidu.tbadk.core.util.ax.i((View) bfVar.aDz, com.baidu.tieba.v.btn_content_download_d);
        com.baidu.tbadk.core.util.ax.b(bfVar.aDz, com.baidu.tieba.t.faceshop_downloaded_text, 1);
    }

    public void h(View.OnClickListener onClickListener) {
        this.aCK = onClickListener;
    }

    public void i(View.OnClickListener onClickListener) {
        this.aCL = onClickListener;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public boolean d(View view) {
        return super.d(view) || !(view.getTag() instanceof bf);
    }
}
