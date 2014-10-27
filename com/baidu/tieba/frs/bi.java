package com.baidu.tieba.frs;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.view.HeadImageView;
/* loaded from: classes.dex */
public class bi extends bm<com.baidu.tbadk.core.data.a> {
    private View.OnClickListener aAZ;
    private View.OnClickListener aBa;

    /* JADX INFO: Access modifiers changed from: protected */
    public bi(FrsActivity frsActivity, BdUniqueId bdUniqueId) {
        super(frsActivity, bdUniqueId);
    }

    @Override // com.baidu.adp.widget.ListView.a
    protected View a(ViewGroup viewGroup) {
        View inflate = com.baidu.adp.lib.g.b.ek().inflate(this.mContext, com.baidu.tieba.w.frs_item_app, null);
        bj bjVar = new bj(null);
        bjVar.aBK = (LinearLayout) inflate.findViewById(com.baidu.tieba.v.app_parent);
        bjVar.JM = (TextView) inflate.findViewById(com.baidu.tieba.v.app_name);
        bjVar.apR = (TextView) inflate.findViewById(com.baidu.tieba.v.app_desc);
        bjVar.aBM = (HeadImageView) inflate.findViewById(com.baidu.tieba.v.app_icon);
        bjVar.aBM.setSupportNoImage(false);
        bjVar.aBN = (TextView) inflate.findViewById(com.baidu.tieba.v.app_download);
        bjVar.aBL = (TextView) inflate.findViewById(com.baidu.tieba.v.recommend_app);
        inflate.setTag(bjVar);
        return inflate;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bm, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View b(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.a aVar) {
        super.b(i, view, viewGroup, aVar);
        if (this.aBp != null) {
            this.aBp.FC();
        }
        bj bjVar = (bj) view.getTag();
        bjVar.aBK.setPadding(0, i - this.aBX == 0 ? this.ayR : this.ayS, 0, 0);
        this.aBp.getLayoutMode().L(this.mSkinType == 1);
        this.aBp.getLayoutMode().h(view);
        if (aVar instanceof com.baidu.tbadk.core.data.a) {
            if (!aVar.zv) {
                aVar.zv = true;
                this.aBp.a(aVar, "show");
                this.aBp.b(aVar, "show");
            }
            bjVar.JM.setText(aVar.zu.userName);
            bjVar.apR.setText(aVar.zu.zx);
            if (com.baidu.tbadk.core.k.js().jw()) {
                bjVar.aBM.setVisibility(0);
                bjVar.aBM.c(aVar.zu.userPortrait, this.mIsFromCDN ? 13 : 14, false);
            } else {
                bjVar.aBM.setVisibility(8);
            }
            bjVar.aBM.setTag(aVar.zu.userPortrait);
            bjVar.aBN.setTag(Integer.valueOf(i));
            com.baidu.tbadk.core.util.aw.h((View) bjVar.aBL, com.baidu.tieba.u.bg_label);
            if (aVar.jH()) {
                a(true, bjVar);
                bjVar.aBN.setText(com.baidu.tieba.y.view);
                bjVar.aBN.setOnClickListener(this.aAZ);
            } else if (aVar.jG()) {
                switch (aVar.zf) {
                    case 0:
                        a(true, bjVar);
                        bjVar.aBN.setText(com.baidu.tieba.y.game_center_download);
                        bjVar.aBN.setOnClickListener(this.aBa);
                        break;
                    case 1:
                        a(false, bjVar);
                        bjVar.aBN.setText(com.baidu.tieba.y.downloading2);
                        bjVar.aBN.setOnClickListener(null);
                        break;
                    case 2:
                        a(true, bjVar);
                        bjVar.aBN.setText(com.baidu.tieba.y.frs_old_style_download_text);
                        bjVar.aBN.setOnClickListener(this.aBa);
                        break;
                }
            }
        }
        return view;
    }

    private void a(boolean z, bj bjVar) {
        if (z) {
            com.baidu.tbadk.core.util.aw.h((View) bjVar.aBN, com.baidu.tieba.u.frs_praise_btn_bg);
            com.baidu.tbadk.core.util.aw.b(bjVar.aBN, com.baidu.tieba.s.cp_cont_f, 1);
            return;
        }
        com.baidu.tbadk.core.util.aw.h((View) bjVar.aBN, com.baidu.tieba.u.btn_content_download_d);
        com.baidu.tbadk.core.util.aw.b(bjVar.aBN, com.baidu.tieba.s.faceshop_downloaded_text, 1);
    }

    public void i(View.OnClickListener onClickListener) {
        this.aAZ = onClickListener;
    }

    public void j(View.OnClickListener onClickListener) {
        this.aBa = onClickListener;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public boolean d(View view) {
        return super.d(view) || !(view.getTag() instanceof bj);
    }
}
