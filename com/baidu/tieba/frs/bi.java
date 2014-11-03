package com.baidu.tieba.frs;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.view.HeadImageView;
/* loaded from: classes.dex */
public class bi extends bm<com.baidu.tbadk.core.data.a> {
    private View.OnClickListener aBj;
    private View.OnClickListener aBk;

    /* JADX INFO: Access modifiers changed from: protected */
    public bi(FrsActivity frsActivity, BdUniqueId bdUniqueId) {
        super(frsActivity, bdUniqueId);
    }

    @Override // com.baidu.adp.widget.ListView.a
    protected View a(ViewGroup viewGroup) {
        View inflate = com.baidu.adp.lib.g.b.ek().inflate(this.mContext, com.baidu.tieba.w.frs_item_app, null);
        bj bjVar = new bj(null);
        bjVar.aBU = (LinearLayout) inflate.findViewById(com.baidu.tieba.v.app_parent);
        bjVar.JN = (TextView) inflate.findViewById(com.baidu.tieba.v.app_name);
        bjVar.aqa = (TextView) inflate.findViewById(com.baidu.tieba.v.app_desc);
        bjVar.aBW = (HeadImageView) inflate.findViewById(com.baidu.tieba.v.app_icon);
        bjVar.aBW.setSupportNoImage(false);
        bjVar.aBX = (TextView) inflate.findViewById(com.baidu.tieba.v.app_download);
        bjVar.aBV = (TextView) inflate.findViewById(com.baidu.tieba.v.recommend_app);
        inflate.setTag(bjVar);
        return inflate;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bm, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View b(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.a aVar) {
        super.b(i, view, viewGroup, aVar);
        if (this.aBz != null) {
            this.aBz.FE();
        }
        bj bjVar = (bj) view.getTag();
        bjVar.aBU.setPadding(0, i - this.aCh == 0 ? this.aza : this.azb, 0, 0);
        this.aBz.getLayoutMode().L(this.mSkinType == 1);
        this.aBz.getLayoutMode().h(view);
        if (aVar instanceof com.baidu.tbadk.core.data.a) {
            if (!aVar.zv) {
                aVar.zv = true;
                this.aBz.a(aVar, "show");
                this.aBz.b(aVar, "show");
            }
            bjVar.JN.setText(aVar.zu.userName);
            bjVar.aqa.setText(aVar.zu.zx);
            if (com.baidu.tbadk.core.l.js().jw()) {
                bjVar.aBW.setVisibility(0);
                bjVar.aBW.c(aVar.zu.userPortrait, this.mIsFromCDN ? 13 : 14, false);
            } else {
                bjVar.aBW.setVisibility(8);
            }
            bjVar.aBW.setTag(aVar.zu.userPortrait);
            bjVar.aBX.setTag(Integer.valueOf(i));
            com.baidu.tbadk.core.util.aw.h((View) bjVar.aBV, com.baidu.tieba.u.bg_label);
            if (aVar.jH()) {
                a(true, bjVar);
                bjVar.aBX.setText(com.baidu.tieba.y.view);
                bjVar.aBX.setOnClickListener(this.aBj);
            } else if (aVar.jG()) {
                switch (aVar.zf) {
                    case 0:
                        a(true, bjVar);
                        bjVar.aBX.setText(com.baidu.tieba.y.game_center_download);
                        bjVar.aBX.setOnClickListener(this.aBk);
                        break;
                    case 1:
                        a(false, bjVar);
                        bjVar.aBX.setText(com.baidu.tieba.y.downloading2);
                        bjVar.aBX.setOnClickListener(null);
                        break;
                    case 2:
                        a(true, bjVar);
                        bjVar.aBX.setText(com.baidu.tieba.y.frs_old_style_download_text);
                        bjVar.aBX.setOnClickListener(this.aBk);
                        break;
                }
            }
        }
        return view;
    }

    private void a(boolean z, bj bjVar) {
        if (z) {
            com.baidu.tbadk.core.util.aw.h((View) bjVar.aBX, com.baidu.tieba.u.frs_praise_btn_bg);
            com.baidu.tbadk.core.util.aw.b(bjVar.aBX, com.baidu.tieba.s.cp_cont_f, 1);
            return;
        }
        com.baidu.tbadk.core.util.aw.h((View) bjVar.aBX, com.baidu.tieba.u.btn_content_download_d);
        com.baidu.tbadk.core.util.aw.b(bjVar.aBX, com.baidu.tieba.s.faceshop_downloaded_text, 1);
    }

    public void i(View.OnClickListener onClickListener) {
        this.aBj = onClickListener;
    }

    public void j(View.OnClickListener onClickListener) {
        this.aBk = onClickListener;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public boolean d(View view) {
        return super.d(view) || !(view.getTag() instanceof bj);
    }
}
