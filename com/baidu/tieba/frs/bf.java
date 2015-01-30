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
public class bf extends bh<com.baidu.tbadk.core.data.c> {
    static final /* synthetic */ boolean $assertionsDisabled;
    private View.OnClickListener aDM;

    static {
        $assertionsDisabled = !bf.class.desiredAssertionStatus();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public bf(FrsActivity frsActivity, BdUniqueId bdUniqueId) {
        super(frsActivity, bdUniqueId);
    }

    @Override // com.baidu.adp.widget.ListView.a
    protected View a(ViewGroup viewGroup) {
        View inflate = com.baidu.adp.lib.g.b.ei().inflate(this.mContext, com.baidu.tieba.x.frs_item_app_new, null);
        bg bgVar = new bg();
        if ($assertionsDisabled || inflate != 0) {
            bgVar.aEB = (LinearLayout) inflate.findViewById(com.baidu.tieba.w.frs_app_item_parent);
            bgVar.aEC = (HeadImageView) inflate.findViewById(com.baidu.tieba.w.frs_app_icon);
            bgVar.aEC.setSupportNoImage(false);
            bgVar.aED = (TextView) inflate.findViewById(com.baidu.tieba.w.frs_app_name);
            bgVar.aEE = (TextView) inflate.findViewById(com.baidu.tieba.w.frs_app_time);
            bgVar.aEF = (TextView) inflate.findViewById(com.baidu.tieba.w.frs_app_desc);
            bgVar.aEG = (TbImageView) inflate.findViewById(com.baidu.tieba.w.frs_app_url);
            bgVar.aEH = (TextView) inflate.findViewById(com.baidu.tieba.w.frs_app_download);
            inflate.setTag(bgVar);
            return inflate;
        }
        throw new AssertionError();
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
        bg bgVar = (bg) view.getTag();
        bgVar.aEB.setPadding(0, i - this.aEK == 0 ? this.aCc : this.aCd, 0, 0);
        this.aEd.getLayoutMode().ab(this.mSkinType == 1);
        this.aEd.getLayoutMode().h(view);
        if (cVar instanceof com.baidu.tbadk.core.data.c) {
            if (!cVar.DD) {
                cVar.DD = true;
                this.aEd.a(cVar, "show");
                this.aEd.b(cVar, "show");
            }
            bgVar.aED.setText(fF(cVar.DB.userName));
            if (cVar.DB == null) {
                return null;
            }
            if (TextUtils.isEmpty(cVar.DB.DF) || TextUtils.isEmpty(cVar.DB.DF.trim())) {
                bgVar.aEF.setVisibility(8);
            } else {
                bgVar.aEF.setVisibility(0);
                bgVar.aEF.setText(cVar.DB.DF);
            }
            bgVar.aEE.setText(com.baidu.tbadk.core.util.bf.n(cVar.DA));
            if (com.baidu.tbadk.core.l.mc().me()) {
                bgVar.aEC.setVisibility(0);
                bgVar.aEC.d(cVar.DB.userPortrait, this.mIsFromCDN ? 13 : 14, false);
            } else {
                bgVar.aEC.setVisibility(8);
            }
            bgVar.aEC.setTag(cVar.DB.userPortrait);
            if (com.baidu.tbadk.core.l.mc().mg() && !TextUtils.isEmpty(cVar.DB.DG)) {
                bgVar.aEG.setVisibility(0);
                bgVar.aEG.d(cVar.DB.DG, this.mIsFromCDN ? 30 : 31, false);
                bgVar.aEF.setPadding(0, 0, 0, 0);
            } else {
                bgVar.aEG.setVisibility(8);
                bgVar.aEF.setPadding(0, 0, 0, this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.u.ds30));
            }
            bgVar.aEH.setTag(Integer.valueOf(i));
            if (cVar.mw()) {
                bgVar.aEH.setVisibility(8);
                return view;
            } else if (cVar.mv()) {
                bgVar.aEH.setVisibility(0);
                switch (cVar.Dm) {
                    case 0:
                        a(true, bgVar);
                        bgVar.aEH.setText(com.baidu.tieba.z.pb_app_download);
                        bgVar.aEH.setOnClickListener(this.aDM);
                        return view;
                    case 1:
                        a(false, bgVar);
                        bgVar.aEH.setText(com.baidu.tieba.z.downloading2);
                        bgVar.aEH.setOnClickListener(null);
                        return view;
                    case 2:
                        a(true, bgVar);
                        bgVar.aEH.setText(com.baidu.tieba.z.frs_new_style_download_text);
                        bgVar.aEH.setOnClickListener(this.aDM);
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

    public void j(View.OnClickListener onClickListener) {
        this.aDM = onClickListener;
    }

    private void a(boolean z, bg bgVar) {
        if (z) {
            com.baidu.tbadk.core.util.bc.i((View) bgVar.aEH, com.baidu.tieba.v.btn_appdownload);
            com.baidu.tbadk.core.util.bc.b(bgVar.aEH, com.baidu.tieba.t.cp_cont_i, 1);
            return;
        }
        com.baidu.tbadk.core.util.bc.i((View) bgVar.aEH, com.baidu.tieba.v.btn_content_download_d);
        com.baidu.tbadk.core.util.bc.b(bgVar.aEH, com.baidu.tieba.t.faceshop_downloaded_text, 1);
    }

    private String fF(String str) {
        if (!TextUtils.isEmpty(str) && str.length() > 14) {
            return str.substring(0, 14);
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public boolean d(View view) {
        return super.d(view) || !(view.getTag() instanceof bg);
    }
}
