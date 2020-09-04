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
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.be;
import com.baidu.tieba.R;
/* loaded from: classes17.dex */
public class o extends com.baidu.tieba.frs.k<p, q> {
    private static final int hPH = R.id.assist_apply_tip;
    private com.baidu.tbadk.coreExtra.view.b ezB;
    private View.OnClickListener mClickListener;

    public o(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.member.o.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Object tag = view.getTag(o.hPH);
                if (TbadkCoreApplication.isLogin() && StringUtils.isNull(TbadkCoreApplication.getCurrentAccountName())) {
                    o.this.i(TbadkCoreApplication.getCurrentAccountInfo());
                } else {
                    be.bju().b((TbPageContext) com.baidu.adp.base.i.I(o.this.mContext), new String[]{tag.toString()});
                }
            }
        };
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bd */
    public q b(ViewGroup viewGroup) {
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
                    ap.setViewTextColor(qVar.hPQ, R.color.cp_cont_d, 1);
                    ap.setViewTextColor(qVar.hPP, R.color.cp_cont_b, 1);
                    ap.setBackgroundResource(qVar.hPR, R.drawable.frs_member_manito_bg);
                }
                int ckp = pVar.ckp();
                if (ckp > 0) {
                    qVar.hPQ.setText(String.format(this.mContext.getResources().getString(R.string.apply_left_num_tip), at.numberUniformFormat(ckp)));
                    qVar.hPR.setTag(hPH, pVar.ckq());
                    qVar.hPR.setOnClickListener(this.mClickListener);
                    qVar.hPR.setEnabled(true);
                    qVar.hPR.setClickable(true);
                } else {
                    qVar.hPQ.setText(this.mContext.getResources().getString(R.string.apply_no_left_tip));
                    qVar.hPR.setEnabled(false);
                    qVar.hPR.setClickable(false);
                }
                qVar.hPQ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ap.getDrawable(R.drawable.icon_arrow12_gray66_right), (Drawable) null);
                qVar.mSkinType = this.mSkinType;
            }
        }
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(AccountData accountData) {
        Activity activity;
        com.baidu.adp.base.e<?> I = com.baidu.adp.base.i.I(this.mContext);
        if (!(I instanceof TbPageContext)) {
            activity = null;
        } else {
            activity = ((TbPageContext) I).getPageActivity();
        }
        if (this.ezB == null) {
            this.ezB = new com.baidu.tbadk.coreExtra.view.b(activity);
        }
        this.ezB.bpV();
        this.ezB.setAccountData(accountData);
        this.ezB.pN(1);
    }

    public void onDestroy() {
        if (this.ezB != null) {
            this.ezB.onDestroy();
        }
    }
}
