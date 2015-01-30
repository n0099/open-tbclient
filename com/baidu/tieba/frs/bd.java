package com.baidu.tieba.frs;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.view.HeadImageView;
/* loaded from: classes.dex */
public class bd extends bh<com.baidu.tbadk.core.data.c> {
    private View.OnClickListener aDL;
    private View.OnClickListener aDM;

    /* JADX INFO: Access modifiers changed from: protected */
    public bd(FrsActivity frsActivity, BdUniqueId bdUniqueId) {
        super(frsActivity, bdUniqueId);
    }

    @Override // com.baidu.adp.widget.ListView.a
    protected View a(ViewGroup viewGroup) {
        View inflate = com.baidu.adp.lib.g.b.ei().inflate(this.mContext, com.baidu.tieba.x.frs_item_app, null);
        be beVar = new be(null);
        beVar.aEx = (LinearLayout) inflate.findViewById(com.baidu.tieba.w.app_parent);
        beVar.mTitle = (TextView) inflate.findViewById(com.baidu.tieba.w.app_name);
        beVar.awk = (TextView) inflate.findViewById(com.baidu.tieba.w.app_desc);
        beVar.aEz = (HeadImageView) inflate.findViewById(com.baidu.tieba.w.app_icon);
        beVar.aEz.setSupportNoImage(false);
        beVar.aEA = (TextView) inflate.findViewById(com.baidu.tieba.w.app_download);
        beVar.aEy = (TextView) inflate.findViewById(com.baidu.tieba.w.recommend_app);
        inflate.setTag(beVar);
        return inflate;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bh, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View b(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.c cVar) {
        super.b(i, view, viewGroup, cVar);
        if (this.aEd != null) {
            this.aEd.Gg();
        }
        be beVar = (be) view.getTag();
        beVar.aEx.setPadding(0, i - this.aEK == 0 ? this.aCc : this.aCd, 0, 0);
        this.aEd.getLayoutMode().ab(this.mSkinType == 1);
        this.aEd.getLayoutMode().h(view);
        if (cVar instanceof com.baidu.tbadk.core.data.c) {
            if (!cVar.DD) {
                cVar.DD = true;
                this.aEd.a(cVar, "show");
                this.aEd.b(cVar, "show");
            }
            beVar.mTitle.setText(cVar.DB.userName);
            beVar.awk.setText(cVar.DB.DF);
            if (com.baidu.tbadk.core.l.mc().mg()) {
                beVar.aEz.setVisibility(0);
                beVar.aEz.d(cVar.DB.userPortrait, this.mIsFromCDN ? 13 : 14, false);
            } else {
                beVar.aEz.setVisibility(8);
            }
            beVar.aEz.setTag(cVar.DB.userPortrait);
            beVar.aEA.setTag(Integer.valueOf(i));
            com.baidu.tbadk.core.util.bc.i((View) beVar.aEy, com.baidu.tieba.v.bg_label);
            if (cVar.mw()) {
                a(true, beVar);
                beVar.aEA.setText(com.baidu.tieba.z.view);
                beVar.aEA.setOnClickListener(this.aDL);
            } else if (cVar.mv()) {
                switch (cVar.Dm) {
                    case 0:
                        a(true, beVar);
                        beVar.aEA.setText(com.baidu.tieba.z.game_center_download);
                        beVar.aEA.setOnClickListener(this.aDM);
                        break;
                    case 1:
                        a(false, beVar);
                        beVar.aEA.setText(com.baidu.tieba.z.downloading2);
                        beVar.aEA.setOnClickListener(null);
                        break;
                    case 2:
                        a(true, beVar);
                        beVar.aEA.setText(com.baidu.tieba.z.frs_old_style_download_text);
                        beVar.aEA.setOnClickListener(this.aDM);
                        break;
                }
            }
        }
        return view;
    }

    private void a(boolean z, be beVar) {
        if (z) {
            com.baidu.tbadk.core.util.bc.i((View) beVar.aEA, com.baidu.tieba.v.frs_praise_btn_bg);
            com.baidu.tbadk.core.util.bc.b(beVar.aEA, com.baidu.tieba.t.cp_cont_f, 1);
            return;
        }
        com.baidu.tbadk.core.util.bc.i((View) beVar.aEA, com.baidu.tieba.v.btn_content_download_d);
        com.baidu.tbadk.core.util.bc.b(beVar.aEA, com.baidu.tieba.t.faceshop_downloaded_text, 1);
    }

    public void i(View.OnClickListener onClickListener) {
        this.aDL = onClickListener;
    }

    public void j(View.OnClickListener onClickListener) {
        this.aDM = onClickListener;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public boolean d(View view) {
        return super.d(view) || !(view.getTag() instanceof be);
    }
}
