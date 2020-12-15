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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tieba.R;
/* loaded from: classes23.dex */
public class r extends com.baidu.tieba.frs.k<s, t> {
    private static final int iPU = R.id.private_apply_tip;
    private com.baidu.tbadk.coreExtra.view.b fiF;
    private View.OnClickListener mClickListener;

    public r(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.member.r.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TbadkCoreApplication.isLogin() || !StringUtils.isNull(TbadkCoreApplication.getCurrentAccountName())) {
                    Object tag = view.getTag(r.iPU);
                    if (tag != null && !tag.toString().equals("")) {
                        bf.bua().b((TbPageContext) com.baidu.adp.base.i.J(r.this.mContext), new String[]{tag.toString()});
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
    /* renamed from: bf */
    public t c(ViewGroup viewGroup) {
        return new t(LayoutInflater.from(this.mContext).inflate(R.layout.private_member_apply, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, s sVar, t tVar) {
        String string;
        boolean z = true;
        super.a(i, view, viewGroup, (ViewGroup) sVar, (s) tVar);
        if (sVar != null && !sVar.isEmpty() && tVar != null) {
            if (sVar.isEmpty()) {
                tVar.mRootLayout.setVisibility(8);
            } else {
                if (tVar.mSkinType != this.mSkinType) {
                    ap.setBackgroundColor(tVar.mLineView, R.color.CAM_X0204);
                    ap.setViewTextColor(tVar.iPS, R.color.CAM_X0109, 1);
                    ap.setViewTextColor(tVar.iPR, R.color.CAM_X0105, 1);
                    ap.setBackgroundResource(tVar.iPT, R.drawable.frs_member_manito_bg);
                }
                int cAD = sVar.cAD();
                String string2 = this.mContext.getResources().getString(R.string.tbtitle_quota_is_full);
                if (cAD == -1) {
                    int cAB = sVar.cAB();
                    String numberUniformFormat = au.numberUniformFormat(cAB);
                    if (cAB > 0) {
                        string = String.format(this.mContext.getResources().getString(R.string.tbtitle_apply_assist_left_num_tip), numberUniformFormat);
                        tVar.iPT.setOnClickListener(this.mClickListener);
                        tVar.iPS.setText(string);
                        tVar.iPT.setTag(iPU, sVar.cAC());
                        tVar.iPT.setEnabled(z);
                        tVar.iPT.setClickable(z);
                        tVar.iPS.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ap.getDrawable(R.drawable.icon_arrow12_gray66_right), (Drawable) null);
                        tVar.mSkinType = this.mSkinType;
                    }
                    z = false;
                    string = string2;
                    tVar.iPT.setOnClickListener(this.mClickListener);
                    tVar.iPS.setText(string);
                    tVar.iPT.setTag(iPU, sVar.cAC());
                    tVar.iPT.setEnabled(z);
                    tVar.iPT.setClickable(z);
                    tVar.iPS.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ap.getDrawable(R.drawable.icon_arrow12_gray66_right), (Drawable) null);
                    tVar.mSkinType = this.mSkinType;
                } else {
                    if (cAD == 0) {
                        string = this.mContext.getResources().getString(R.string.tbtitle_is_assist);
                    } else if (cAD == 1) {
                        string = this.mContext.getResources().getString(R.string.tbtitle_assist_applying);
                    } else {
                        if (cAD == 2) {
                            string = this.mContext.getResources().getString(R.string.tbtitle_assist_apply_failed);
                        }
                        z = false;
                        string = string2;
                    }
                    tVar.iPT.setOnClickListener(this.mClickListener);
                    tVar.iPS.setText(string);
                    tVar.iPT.setTag(iPU, sVar.cAC());
                    tVar.iPT.setEnabled(z);
                    tVar.iPT.setClickable(z);
                    tVar.iPS.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ap.getDrawable(R.drawable.icon_arrow12_gray66_right), (Drawable) null);
                    tVar.mSkinType = this.mSkinType;
                }
            }
        }
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(AccountData accountData) {
        Activity activity;
        com.baidu.adp.base.e<?> J = com.baidu.adp.base.i.J(this.mContext);
        if (!(J instanceof TbPageContext)) {
            activity = null;
        } else {
            activity = ((TbPageContext) J).getPageActivity();
        }
        if (this.fiF == null) {
            this.fiF = new com.baidu.tbadk.coreExtra.view.b(activity);
        }
        this.fiF.bAH();
        this.fiF.setAccountData(accountData);
        this.fiF.rS(1);
    }

    public void onDestroy() {
        if (this.fiF != null) {
            this.fiF.onDestroy();
        }
    }
}
