package com.baidu.tieba.forumMember.member;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.d;
/* loaded from: classes5.dex */
public class r extends com.baidu.tieba.frs.h<s, t> {
    private static final int eWc = d.g.private_apply_tip;
    private com.baidu.tbadk.coreExtra.view.c bVZ;
    private View.OnClickListener mClickListener;

    public r(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.member.r.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TbadkCoreApplication.isLogin() || !StringUtils.isNull(TbadkCoreApplication.getCurrentAccountName())) {
                    Object tag = view.getTag(r.eWc);
                    if (tag != null && !tag.toString().equals("")) {
                        ba.adA().c((TbPageContext) com.baidu.adp.base.i.aK(r.this.mContext), new String[]{tag.toString()});
                        return;
                    }
                    return;
                }
                r.this.i(TbadkCoreApplication.getCurrentAccountInfo());
            }
        };
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aC */
    public t onCreateViewHolder(ViewGroup viewGroup) {
        return new t(LayoutInflater.from(this.mContext).inflate(d.h.private_member_apply, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, s sVar, t tVar) {
        String string;
        boolean z = true;
        super.onFillViewHolder(i, view, viewGroup, sVar, tVar);
        if (sVar != null && !sVar.isEmpty() && tVar != null) {
            if (sVar.isEmpty()) {
                tVar.mRootLayout.setVisibility(8);
            } else {
                if (tVar.mSkinType != this.mSkinType) {
                    al.l(tVar.bET, d.C0277d.cp_bg_line_b);
                    al.d(tVar.eVZ, d.C0277d.cp_cont_d, 1);
                    al.d(tVar.eVX, d.C0277d.cp_cont_b, 1);
                    al.k(tVar.eWb, d.f.frs_member_manito_bg);
                }
                int bbj = sVar.bbj();
                String string2 = this.mContext.getResources().getString(d.j.tbtitle_quota_is_full);
                if (bbj == -1) {
                    int bbg = sVar.bbg();
                    String as = ap.as(bbg);
                    if (bbg > 0) {
                        string = String.format(this.mContext.getResources().getString(d.j.tbtitle_apply_assist_left_num_tip), as);
                        tVar.eWb.setOnClickListener(this.mClickListener);
                        tVar.eVZ.setText(string);
                        tVar.eWb.setTag(eWc, sVar.bbi());
                        tVar.eWb.setEnabled(z);
                        tVar.eWb.setClickable(z);
                        tVar.eVZ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(d.f.icon_arrow12_gray66_right), (Drawable) null);
                        tVar.mSkinType = this.mSkinType;
                    }
                    z = false;
                    string = string2;
                    tVar.eWb.setOnClickListener(this.mClickListener);
                    tVar.eVZ.setText(string);
                    tVar.eWb.setTag(eWc, sVar.bbi());
                    tVar.eWb.setEnabled(z);
                    tVar.eWb.setClickable(z);
                    tVar.eVZ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(d.f.icon_arrow12_gray66_right), (Drawable) null);
                    tVar.mSkinType = this.mSkinType;
                } else {
                    if (bbj == 0) {
                        string = this.mContext.getResources().getString(d.j.tbtitle_is_assist);
                    } else if (bbj == 1) {
                        string = this.mContext.getResources().getString(d.j.tbtitle_assist_applying);
                    } else {
                        if (bbj == 2) {
                            string = this.mContext.getResources().getString(d.j.tbtitle_assist_apply_failed);
                        }
                        z = false;
                        string = string2;
                    }
                    tVar.eWb.setOnClickListener(this.mClickListener);
                    tVar.eVZ.setText(string);
                    tVar.eWb.setTag(eWc, sVar.bbi());
                    tVar.eWb.setEnabled(z);
                    tVar.eWb.setClickable(z);
                    tVar.eVZ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(d.f.icon_arrow12_gray66_right), (Drawable) null);
                    tVar.mSkinType = this.mSkinType;
                }
            }
        }
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(AccountData accountData) {
        Activity activity;
        com.baidu.adp.base.e<?> aK = com.baidu.adp.base.i.aK(this.mContext);
        if (!(aK instanceof TbPageContext)) {
            activity = null;
        } else {
            activity = ((TbPageContext) aK).getPageActivity();
        }
        if (this.bVZ == null) {
            this.bVZ = new com.baidu.tbadk.coreExtra.view.c(activity);
        }
        this.bVZ.akj();
        this.bVZ.setAccountData(accountData);
        this.bVZ.iZ(1);
    }

    public void onDestroy() {
        if (this.bVZ != null) {
            this.bVZ.onDestroy();
        }
    }
}
