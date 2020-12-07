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
public class o extends com.baidu.tieba.frs.k<p, q> {
    private static final int iPH = R.id.assist_apply_tip;
    private com.baidu.tbadk.coreExtra.view.b fiF;
    private View.OnClickListener mClickListener;

    public o(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.member.o.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Object tag = view.getTag(o.iPH);
                if (TbadkCoreApplication.isLogin() && StringUtils.isNull(TbadkCoreApplication.getCurrentAccountName())) {
                    o.this.i(TbadkCoreApplication.getCurrentAccountInfo());
                } else {
                    bf.bua().b((TbPageContext) com.baidu.adp.base.i.J(o.this.mContext), new String[]{tag.toString()});
                }
            }
        };
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: be */
    public q c(ViewGroup viewGroup) {
        return new q(LayoutInflater.from(this.mContext).inflate(R.layout.frs_member_manager_apply, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, p pVar, q qVar) {
        super.a(i, view, viewGroup, (ViewGroup) pVar, (p) qVar);
        if (pVar != null && !pVar.isEmpty() && qVar != null) {
            if (pVar.isEmpty()) {
                qVar.mRootLayout.setVisibility(8);
            } else {
                if (qVar.mSkinType != this.mSkinType) {
                    ap.setViewTextColor(qVar.iPQ, R.color.CAM_X0109, 1);
                    ap.setViewTextColor(qVar.iPP, R.color.CAM_X0105, 1);
                    ap.setBackgroundResource(qVar.iPR, R.drawable.frs_member_manito_bg);
                }
                int cAA = pVar.cAA();
                if (cAA > 0) {
                    qVar.iPQ.setText(String.format(this.mContext.getResources().getString(R.string.apply_left_num_tip), au.numberUniformFormat(cAA)));
                    qVar.iPR.setTag(iPH, pVar.cAB());
                    qVar.iPR.setOnClickListener(this.mClickListener);
                    qVar.iPR.setEnabled(true);
                    qVar.iPR.setClickable(true);
                } else {
                    qVar.iPQ.setText(this.mContext.getResources().getString(R.string.apply_no_left_tip));
                    qVar.iPR.setEnabled(false);
                    qVar.iPR.setClickable(false);
                }
                qVar.iPQ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ap.getDrawable(R.drawable.icon_arrow12_gray66_right), (Drawable) null);
                qVar.mSkinType = this.mSkinType;
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
