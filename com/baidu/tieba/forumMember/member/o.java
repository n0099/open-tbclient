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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tieba.R;
/* loaded from: classes10.dex */
public class o extends com.baidu.tieba.frs.j<p, q> {
    private com.baidu.tbadk.coreExtra.view.b eiZ;
    private View.OnClickListener mClickListener;

    public o(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.member.o.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Object tag = view.getTag(R.id.assist_apply_tip);
                if (TbadkCoreApplication.isLogin() && StringUtils.isNull(TbadkCoreApplication.getCurrentAccountName())) {
                    o.this.i(TbadkCoreApplication.getCurrentAccountInfo());
                } else {
                    bc.aWU().b((TbPageContext) com.baidu.adp.base.i.G(o.this.mContext), new String[]{tag.toString()});
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
    @Override // com.baidu.tieba.frs.j, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, p pVar, q qVar) {
        super.a(i, view, viewGroup, (ViewGroup) pVar, (p) qVar);
        if (pVar != null && !pVar.isEmpty() && qVar != null) {
            if (pVar.isEmpty()) {
                qVar.mRootLayout.setVisibility(8);
            } else {
                if (qVar.mSkinType != this.mSkinType) {
                    an.setViewTextColor(qVar.hwI, R.color.cp_cont_d, 1);
                    an.setViewTextColor(qVar.hwH, R.color.cp_cont_b, 1);
                    an.setBackgroundResource(qVar.hwJ, R.drawable.frs_member_manito_bg);
                }
                int bWy = pVar.bWy();
                if (bWy > 0) {
                    qVar.hwI.setText(String.format(this.mContext.getResources().getString(R.string.apply_left_num_tip), ar.numberUniformFormat(bWy)));
                    qVar.hwJ.setTag(R.id.assist_apply_tip, pVar.bWz());
                    qVar.hwJ.setOnClickListener(this.mClickListener);
                    qVar.hwJ.setEnabled(true);
                    qVar.hwJ.setClickable(true);
                } else {
                    qVar.hwI.setText(this.mContext.getResources().getString(R.string.apply_no_left_tip));
                    qVar.hwJ.setEnabled(false);
                    qVar.hwJ.setClickable(false);
                }
                qVar.hwI.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, an.getDrawable(R.drawable.icon_arrow12_gray66_right), (Drawable) null);
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
        if (this.eiZ == null) {
            this.eiZ = new com.baidu.tbadk.coreExtra.view.b(activity);
        }
        this.eiZ.bdz();
        this.eiZ.setAccountData(accountData);
        this.eiZ.nk(1);
    }

    public void onDestroy() {
        if (this.eiZ != null) {
            this.eiZ.onDestroy();
        }
    }
}
