package com.baidu.tieba.frs;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.view.HeadImageView;
/* loaded from: classes.dex */
public class bd extends bh<com.baidu.tbadk.core.data.c> {
    private View.OnClickListener aDI;
    private View.OnClickListener aDJ;

    /* JADX INFO: Access modifiers changed from: protected */
    public bd(FrsActivity frsActivity, BdUniqueId bdUniqueId) {
        super(frsActivity, bdUniqueId);
    }

    @Override // com.baidu.adp.widget.ListView.a
    protected View a(ViewGroup viewGroup) {
        View inflate = com.baidu.adp.lib.g.b.ei().inflate(this.mContext, com.baidu.tieba.x.frs_item_app, null);
        be beVar = new be(null);
        beVar.aEu = (LinearLayout) inflate.findViewById(com.baidu.tieba.w.app_parent);
        beVar.mTitle = (TextView) inflate.findViewById(com.baidu.tieba.w.app_name);
        beVar.awh = (TextView) inflate.findViewById(com.baidu.tieba.w.app_desc);
        beVar.aEw = (HeadImageView) inflate.findViewById(com.baidu.tieba.w.app_icon);
        beVar.aEw.setSupportNoImage(false);
        beVar.aEx = (TextView) inflate.findViewById(com.baidu.tieba.w.app_download);
        beVar.aEv = (TextView) inflate.findViewById(com.baidu.tieba.w.recommend_app);
        inflate.setTag(beVar);
        return inflate;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bh, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View b(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.c cVar) {
        super.b(i, view, viewGroup, cVar);
        if (this.aEa != null) {
            this.aEa.Ga();
        }
        be beVar = (be) view.getTag();
        beVar.aEu.setPadding(0, i - this.aEH == 0 ? this.aBZ : this.aCa, 0, 0);
        this.aEa.getLayoutMode().ab(this.mSkinType == 1);
        this.aEa.getLayoutMode().h(view);
        if (cVar instanceof com.baidu.tbadk.core.data.c) {
            if (!cVar.Dz) {
                cVar.Dz = true;
                this.aEa.a(cVar, "show");
                this.aEa.b(cVar, "show");
            }
            beVar.mTitle.setText(cVar.Dy.userName);
            beVar.awh.setText(cVar.Dy.DB);
            if (com.baidu.tbadk.core.l.lV().lZ()) {
                beVar.aEw.setVisibility(0);
                beVar.aEw.d(cVar.Dy.userPortrait, this.mIsFromCDN ? 13 : 14, false);
            } else {
                beVar.aEw.setVisibility(8);
            }
            beVar.aEw.setTag(cVar.Dy.userPortrait);
            beVar.aEx.setTag(Integer.valueOf(i));
            com.baidu.tbadk.core.util.bc.i((View) beVar.aEv, com.baidu.tieba.v.bg_label);
            if (cVar.mp()) {
                a(true, beVar);
                beVar.aEx.setText(com.baidu.tieba.z.view);
                beVar.aEx.setOnClickListener(this.aDI);
            } else if (cVar.mo()) {
                switch (cVar.Dj) {
                    case 0:
                        a(true, beVar);
                        beVar.aEx.setText(com.baidu.tieba.z.game_center_download);
                        beVar.aEx.setOnClickListener(this.aDJ);
                        break;
                    case 1:
                        a(false, beVar);
                        beVar.aEx.setText(com.baidu.tieba.z.downloading2);
                        beVar.aEx.setOnClickListener(null);
                        break;
                    case 2:
                        a(true, beVar);
                        beVar.aEx.setText(com.baidu.tieba.z.frs_old_style_download_text);
                        beVar.aEx.setOnClickListener(this.aDJ);
                        break;
                }
            }
        }
        return view;
    }

    private void a(boolean z, be beVar) {
        if (z) {
            com.baidu.tbadk.core.util.bc.i((View) beVar.aEx, com.baidu.tieba.v.frs_praise_btn_bg);
            com.baidu.tbadk.core.util.bc.b(beVar.aEx, com.baidu.tieba.t.cp_cont_f, 1);
            return;
        }
        com.baidu.tbadk.core.util.bc.i((View) beVar.aEx, com.baidu.tieba.v.btn_content_download_d);
        com.baidu.tbadk.core.util.bc.b(beVar.aEx, com.baidu.tieba.t.faceshop_downloaded_text, 1);
    }

    public void i(View.OnClickListener onClickListener) {
        this.aDI = onClickListener;
    }

    public void j(View.OnClickListener onClickListener) {
        this.aDJ = onClickListener;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public boolean d(View view) {
        return super.d(view) || !(view.getTag() instanceof be);
    }
}
