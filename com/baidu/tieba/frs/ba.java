package com.baidu.tieba.frs;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class ba extends bd<com.baidu.tbadk.core.data.c, bc> {
    private View.OnClickListener aVo;
    private View.OnClickListener aVp;

    /* JADX INFO: Access modifiers changed from: protected */
    public ba(BaseActivity baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
    }

    public void i(View.OnClickListener onClickListener) {
        this.aVp = onClickListener;
    }

    public void h(View.OnClickListener onClickListener) {
        this.aVo = onClickListener;
    }

    private void a(boolean z, bc bcVar) {
        if (z) {
            com.baidu.tbadk.core.util.al.h((View) bcVar.aWA, i.e.btn_appdownload);
            com.baidu.tbadk.core.util.al.b(bcVar.aWA, i.c.cp_cont_i, 1);
            return;
        }
        com.baidu.tbadk.core.util.al.h((View) bcVar.aWA, i.e.btn_content_download_d);
        com.baidu.tbadk.core.util.al.b(bcVar.aWA, i.c.faceshop_downloaded_text, 1);
    }

    private String gM(String str) {
        if (!TextUtils.isEmpty(str) && str.length() > 14) {
            return str.substring(0, 14);
        }
        return str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: g */
    public bc a(ViewGroup viewGroup) {
        return new bc(LayoutInflater.from(this.mContext).inflate(i.g.frs_item_app_new, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bd, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.c cVar, bc bcVar) {
        super.a(i, view, viewGroup, (ViewGroup) cVar, (com.baidu.tbadk.core.data.c) bcVar);
        if (this.aSX == null) {
            return null;
        }
        if (this.aSX != null && (this.aSX instanceof FrsActivity)) {
            ((FrsActivity) this.aSX).Lq().Nc();
        }
        bcVar.aWu.setPadding(0, i - this.aWC == 0 ? this.aTK : this.aTL, 0, 0);
        this.aSX.getLayoutMode().ad(this.mSkinType == 1);
        this.aSX.getLayoutMode().k(view);
        if (cVar instanceof com.baidu.tbadk.core.data.c) {
            if (!cVar.Ux && this.aSX != null && (this.aSX instanceof FrsActivity)) {
                cVar.Ux = true;
                ((FrsActivity) this.aSX).a(cVar, "show");
                ((FrsActivity) this.aSX).b(cVar, "show");
            }
            bcVar.aWw.setText(gM(cVar.Uw.userName));
            if (cVar.Uw == null) {
                return null;
            }
            if (TextUtils.isEmpty(cVar.Uw.Uz) || TextUtils.isEmpty(cVar.Uw.Uz.trim())) {
                bcVar.aWy.setVisibility(8);
            } else {
                bcVar.aWy.setVisibility(0);
                bcVar.aWy.setText(cVar.Uw.Uz);
            }
            bcVar.aWx.setText(com.baidu.tbadk.core.util.aq.m(cVar.Uv));
            if (com.baidu.tbadk.core.m.rb().rd()) {
                bcVar.aWv.setVisibility(0);
                bcVar.aWv.d(cVar.Uw.userPortrait, this.mIsFromCDN ? 13 : 14, false);
            } else {
                bcVar.aWv.setVisibility(8);
            }
            bcVar.aWv.setTag(cVar.Uw.userPortrait);
            if (com.baidu.tbadk.core.m.rb().rf() && !TextUtils.isEmpty(cVar.Uw.UA)) {
                bcVar.aWz.setVisibility(0);
                bcVar.aWz.d(cVar.Uw.UA, this.mIsFromCDN ? 30 : 31, false);
                bcVar.aWy.setPadding(0, 0, 0, 0);
            } else {
                bcVar.aWz.setVisibility(8);
                bcVar.aWy.setPadding(0, 0, 0, this.mContext.getResources().getDimensionPixelSize(i.d.ds30));
            }
            bcVar.aWA.setTag(Integer.valueOf(i));
            if (cVar.rw()) {
                if (!TextUtils.isEmpty(cVar.Uw.UF) && !TextUtils.isEmpty(cVar.Uw.UF.trim())) {
                    a(true, bcVar);
                    bcVar.aWA.setText(cVar.Uw.UF);
                    bcVar.aWA.setOnClickListener(this.aVo);
                    return view;
                }
                bcVar.aWA.setVisibility(8);
                return view;
            } else if (cVar.rv()) {
                bcVar.aWA.setVisibility(0);
                switch (cVar.Uh) {
                    case 0:
                        if (TextUtils.isEmpty(cVar.Uw.UF) || TextUtils.isEmpty(cVar.Uw.UF.trim())) {
                            bcVar.aWA.setText(i.h.pb_app_download);
                        } else {
                            bcVar.aWA.setText(cVar.Uw.UF);
                        }
                        a(true, bcVar);
                        bcVar.aWA.setOnClickListener(this.aVp);
                        return view;
                    case 1:
                        a(false, bcVar);
                        bcVar.aWA.setText(i.h.downloading2);
                        bcVar.aWA.setOnClickListener(null);
                        return view;
                    case 2:
                        a(true, bcVar);
                        bcVar.aWA.setText(i.h.frs_new_style_download_text);
                        bcVar.aWA.setOnClickListener(this.aVp);
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
