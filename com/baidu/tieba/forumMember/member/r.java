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
    private static final int iPS = R.id.private_apply_tip;
    private com.baidu.tbadk.coreExtra.view.b fiF;
    private View.OnClickListener mClickListener;

    public r(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.member.r.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TbadkCoreApplication.isLogin() || !StringUtils.isNull(TbadkCoreApplication.getCurrentAccountName())) {
                    Object tag = view.getTag(r.iPS);
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
                    ap.setViewTextColor(tVar.iPQ, R.color.CAM_X0109, 1);
                    ap.setViewTextColor(tVar.iPP, R.color.CAM_X0105, 1);
                    ap.setBackgroundResource(tVar.iPR, R.drawable.frs_member_manito_bg);
                }
                int cAC = sVar.cAC();
                String string2 = this.mContext.getResources().getString(R.string.tbtitle_quota_is_full);
                if (cAC == -1) {
                    int cAA = sVar.cAA();
                    String numberUniformFormat = au.numberUniformFormat(cAA);
                    if (cAA > 0) {
                        string = String.format(this.mContext.getResources().getString(R.string.tbtitle_apply_assist_left_num_tip), numberUniformFormat);
                        tVar.iPR.setOnClickListener(this.mClickListener);
                        tVar.iPQ.setText(string);
                        tVar.iPR.setTag(iPS, sVar.cAB());
                        tVar.iPR.setEnabled(z);
                        tVar.iPR.setClickable(z);
                        tVar.iPQ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ap.getDrawable(R.drawable.icon_arrow12_gray66_right), (Drawable) null);
                        tVar.mSkinType = this.mSkinType;
                    }
                    z = false;
                    string = string2;
                    tVar.iPR.setOnClickListener(this.mClickListener);
                    tVar.iPQ.setText(string);
                    tVar.iPR.setTag(iPS, sVar.cAB());
                    tVar.iPR.setEnabled(z);
                    tVar.iPR.setClickable(z);
                    tVar.iPQ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ap.getDrawable(R.drawable.icon_arrow12_gray66_right), (Drawable) null);
                    tVar.mSkinType = this.mSkinType;
                } else {
                    if (cAC == 0) {
                        string = this.mContext.getResources().getString(R.string.tbtitle_is_assist);
                    } else if (cAC == 1) {
                        string = this.mContext.getResources().getString(R.string.tbtitle_assist_applying);
                    } else {
                        if (cAC == 2) {
                            string = this.mContext.getResources().getString(R.string.tbtitle_assist_apply_failed);
                        }
                        z = false;
                        string = string2;
                    }
                    tVar.iPR.setOnClickListener(this.mClickListener);
                    tVar.iPQ.setText(string);
                    tVar.iPR.setTag(iPS, sVar.cAB());
                    tVar.iPR.setEnabled(z);
                    tVar.iPR.setClickable(z);
                    tVar.iPQ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ap.getDrawable(R.drawable.icon_arrow12_gray66_right), (Drawable) null);
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
