package com.baidu.tieba.frs;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
/* loaded from: classes.dex */
public class bg extends bi<com.baidu.tbadk.core.data.c> {
    static final /* synthetic */ boolean $assertionsDisabled;
    private View.OnClickListener aCL;

    static {
        $assertionsDisabled = !bg.class.desiredAssertionStatus();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public bg(FrsActivity frsActivity, BdUniqueId bdUniqueId) {
        super(frsActivity, bdUniqueId);
    }

    @Override // com.baidu.adp.widget.ListView.a
    protected View a(ViewGroup viewGroup) {
        View inflate = com.baidu.adp.lib.g.b.ek().inflate(this.mContext, com.baidu.tieba.x.frs_item_app_new, null);
        bh bhVar = new bh();
        if ($assertionsDisabled || inflate != 0) {
            bhVar.aDA = (LinearLayout) inflate.findViewById(com.baidu.tieba.w.frs_app_item_parent);
            bhVar.aDB = (HeadImageView) inflate.findViewById(com.baidu.tieba.w.frs_app_icon);
            bhVar.aDB.setSupportNoImage(false);
            bhVar.aDC = (TextView) inflate.findViewById(com.baidu.tieba.w.frs_app_name);
            bhVar.aDD = (TextView) inflate.findViewById(com.baidu.tieba.w.frs_app_time);
            bhVar.aDE = (TextView) inflate.findViewById(com.baidu.tieba.w.frs_app_desc);
            bhVar.aDF = (TbImageView) inflate.findViewById(com.baidu.tieba.w.frs_app_url);
            bhVar.aDG = (TextView) inflate.findViewById(com.baidu.tieba.w.frs_app_download);
            inflate.setTag(bhVar);
            return inflate;
        }
        throw new AssertionError();
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
        bh bhVar = (bh) view.getTag();
        bhVar.aDA.setPadding(0, i - this.aDJ == 0 ? this.aBb : this.aBc, 0, 0);
        this.aDc.getLayoutMode().ab(this.mSkinType == 1);
        this.aDc.getLayoutMode().h(view);
        if (cVar instanceof com.baidu.tbadk.core.data.c) {
            if (!cVar.DA) {
                cVar.DA = true;
                this.aDc.a(cVar, "show");
                this.aDc.b(cVar, "show");
            }
            bhVar.aDC.setText(fA(cVar.Dz.userName));
            if (cVar.Dz == null) {
                return null;
            }
            if (TextUtils.isEmpty(cVar.Dz.DD) || TextUtils.isEmpty(cVar.Dz.DD.trim())) {
                bhVar.aDE.setVisibility(8);
            } else {
                bhVar.aDE.setVisibility(0);
                bhVar.aDE.setText(cVar.Dz.DD);
            }
            bhVar.aDD.setText(com.baidu.tbadk.core.util.ba.n(cVar.Dy));
            if (com.baidu.tbadk.core.l.mc().me()) {
                bhVar.aDB.setVisibility(0);
                bhVar.aDB.d(cVar.Dz.userPortrait, this.mIsFromCDN ? 13 : 14, false);
            } else {
                bhVar.aDB.setVisibility(8);
            }
            bhVar.aDB.setTag(cVar.Dz.userPortrait);
            if (com.baidu.tbadk.core.l.mc().mg() && !TextUtils.isEmpty(cVar.Dz.DE)) {
                bhVar.aDF.setVisibility(0);
                bhVar.aDF.d(cVar.Dz.DE, this.mIsFromCDN ? 30 : 31, false);
                bhVar.aDE.setPadding(0, 0, 0, 0);
            } else {
                bhVar.aDF.setVisibility(8);
                bhVar.aDE.setPadding(0, 0, 0, this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.u.ds30));
            }
            bhVar.aDG.setTag(Integer.valueOf(i));
            if (cVar.mw()) {
                bhVar.aDG.setVisibility(8);
                return view;
            } else if (cVar.mv()) {
                bhVar.aDG.setVisibility(0);
                switch (cVar.Dk) {
                    case 0:
                        a(true, bhVar);
                        bhVar.aDG.setText(com.baidu.tieba.z.pb_app_download);
                        bhVar.aDG.setOnClickListener(this.aCL);
                        return view;
                    case 1:
                        a(false, bhVar);
                        bhVar.aDG.setText(com.baidu.tieba.z.downloading2);
                        bhVar.aDG.setOnClickListener(null);
                        return view;
                    case 2:
                        a(true, bhVar);
                        bhVar.aDG.setText(com.baidu.tieba.z.frs_new_style_download_text);
                        bhVar.aDG.setOnClickListener(this.aCL);
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

    public void i(View.OnClickListener onClickListener) {
        this.aCL = onClickListener;
    }

    private void a(boolean z, bh bhVar) {
        if (z) {
            com.baidu.tbadk.core.util.ax.i((View) bhVar.aDG, com.baidu.tieba.v.btn_appdownload);
            com.baidu.tbadk.core.util.ax.b(bhVar.aDG, com.baidu.tieba.t.cp_cont_i, 1);
            return;
        }
        com.baidu.tbadk.core.util.ax.i((View) bhVar.aDG, com.baidu.tieba.v.btn_content_download_d);
        com.baidu.tbadk.core.util.ax.b(bhVar.aDG, com.baidu.tieba.t.faceshop_downloaded_text, 1);
    }

    private String fA(String str) {
        if (!TextUtils.isEmpty(str) && str.length() > 14) {
            return str.substring(0, 14);
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public boolean d(View view) {
        return super.d(view) || !(view.getTag() instanceof bh);
    }
}
