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
/* loaded from: classes23.dex */
public class o extends com.baidu.tieba.frs.k<p, q> {
    private static final int iye = R.id.assist_apply_tip;
    private com.baidu.tbadk.coreExtra.view.b eWi;
    private View.OnClickListener mClickListener;

    public o(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.member.o.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Object tag = view.getTag(o.iye);
                if (TbadkCoreApplication.isLogin() && StringUtils.isNull(TbadkCoreApplication.getCurrentAccountName())) {
                    o.this.i(TbadkCoreApplication.getCurrentAccountInfo());
                } else {
                    be.boR().b((TbPageContext) com.baidu.adp.base.i.I(o.this.mContext), new String[]{tag.toString()});
                }
            }
        };
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bg */
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
                    ap.setViewTextColor(qVar.iyn, R.color.cp_cont_d, 1);
                    ap.setViewTextColor(qVar.iym, R.color.cp_cont_b, 1);
                    ap.setBackgroundResource(qVar.iyo, R.drawable.frs_member_manito_bg);
                }
                int cuh = pVar.cuh();
                if (cuh > 0) {
                    qVar.iyn.setText(String.format(this.mContext.getResources().getString(R.string.apply_left_num_tip), at.numberUniformFormat(cuh)));
                    qVar.iyo.setTag(iye, pVar.cui());
                    qVar.iyo.setOnClickListener(this.mClickListener);
                    qVar.iyo.setEnabled(true);
                    qVar.iyo.setClickable(true);
                } else {
                    qVar.iyn.setText(this.mContext.getResources().getString(R.string.apply_no_left_tip));
                    qVar.iyo.setEnabled(false);
                    qVar.iyo.setClickable(false);
                }
                qVar.iyn.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ap.getDrawable(R.drawable.icon_arrow12_gray66_right), (Drawable) null);
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
        if (this.eWi == null) {
            this.eWi = new com.baidu.tbadk.coreExtra.view.b(activity);
        }
        this.eWi.bvs();
        this.eWi.setAccountData(accountData);
        this.eWi.qJ(1);
    }

    public void onDestroy() {
        if (this.eWi != null) {
            this.eWi.onDestroy();
        }
    }
}
