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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tieba.R;
/* loaded from: classes17.dex */
public class o extends com.baidu.tieba.frs.j<p, q> {
    private static final int hCm = R.id.assist_apply_tip;
    private com.baidu.tbadk.coreExtra.view.b epl;
    private View.OnClickListener mClickListener;

    public o(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.member.o.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Object tag = view.getTag(o.hCm);
                if (TbadkCoreApplication.isLogin() && StringUtils.isNull(TbadkCoreApplication.getCurrentAccountName())) {
                    o.this.i(TbadkCoreApplication.getCurrentAccountInfo());
                } else {
                    bd.baV().b((TbPageContext) com.baidu.adp.base.i.G(o.this.mContext), new String[]{tag.toString()});
                }
            }
        };
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: be */
    public q b(ViewGroup viewGroup) {
        return new q(LayoutInflater.from(this.mContext).inflate(R.layout.frs_member_manager_apply, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.j, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, p pVar, q qVar) {
        super.a(i, view, viewGroup, (ViewGroup) pVar, (p) qVar);
        if (pVar != null && !pVar.isEmpty() && qVar != null) {
            if (pVar.isEmpty()) {
                qVar.mRootLayout.setVisibility(8);
            } else {
                if (qVar.mSkinType != this.mSkinType) {
                    ao.setViewTextColor(qVar.hCv, R.color.cp_cont_d, 1);
                    ao.setViewTextColor(qVar.hCu, R.color.cp_cont_b, 1);
                    ao.setBackgroundResource(qVar.hCw, R.drawable.frs_member_manito_bg);
                }
                int bZS = pVar.bZS();
                if (bZS > 0) {
                    qVar.hCv.setText(String.format(this.mContext.getResources().getString(R.string.apply_left_num_tip), as.numberUniformFormat(bZS)));
                    qVar.hCw.setTag(hCm, pVar.bZT());
                    qVar.hCw.setOnClickListener(this.mClickListener);
                    qVar.hCw.setEnabled(true);
                    qVar.hCw.setClickable(true);
                } else {
                    qVar.hCv.setText(this.mContext.getResources().getString(R.string.apply_no_left_tip));
                    qVar.hCw.setEnabled(false);
                    qVar.hCw.setClickable(false);
                }
                qVar.hCv.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ao.getDrawable(R.drawable.icon_arrow12_gray66_right), (Drawable) null);
                qVar.mSkinType = this.mSkinType;
            }
        }
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(AccountData accountData) {
        Activity activity;
        com.baidu.adp.base.e<?> G = com.baidu.adp.base.i.G(this.mContext);
        if (!(G instanceof TbPageContext)) {
            activity = null;
        } else {
            activity = ((TbPageContext) G).getPageActivity();
        }
        if (this.epl == null) {
            this.epl = new com.baidu.tbadk.coreExtra.view.b(activity);
        }
        this.epl.bhi();
        this.epl.setAccountData(accountData);
        this.epl.nC(1);
    }

    public void onDestroy() {
        if (this.epl != null) {
            this.epl.onDestroy();
        }
    }
}
