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
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public class o extends com.baidu.tieba.frs.h<p, q> {
    private com.baidu.tbadk.coreExtra.view.c cdW;
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
                    ba.aiz().c((TbPageContext) com.baidu.adp.base.i.ab(o.this.mContext), new String[]{tag.toString()});
                }
            }
        };
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aB */
    public q onCreateViewHolder(ViewGroup viewGroup) {
        return new q(LayoutInflater.from(this.mContext).inflate(R.layout.frs_member_manager_apply, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, p pVar, q qVar) {
        super.onFillViewHolder(i, view, viewGroup, pVar, qVar);
        if (pVar != null && !pVar.isEmpty() && qVar != null) {
            if (pVar.isEmpty()) {
                qVar.mRootLayout.setVisibility(8);
            } else {
                if (qVar.mSkinType != this.mSkinType) {
                    al.f(qVar.fmh, R.color.cp_cont_d, 1);
                    al.f(qVar.fmg, R.color.cp_cont_b, 1);
                    al.k(qVar.fmi, R.drawable.frs_member_manito_bg);
                }
                int biA = pVar.biA();
                if (biA > 0) {
                    qVar.fmh.setText(String.format(this.mContext.getResources().getString(R.string.apply_left_num_tip), ap.aG(biA)));
                    qVar.fmi.setTag(R.id.assist_apply_tip, pVar.biB());
                    qVar.fmi.setOnClickListener(this.mClickListener);
                    qVar.fmi.setEnabled(true);
                    qVar.fmi.setClickable(true);
                } else {
                    qVar.fmh.setText(this.mContext.getResources().getString(R.string.apply_no_left_tip));
                    qVar.fmi.setEnabled(false);
                    qVar.fmi.setClickable(false);
                }
                qVar.fmh.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(R.drawable.icon_arrow12_gray66_right), (Drawable) null);
                qVar.mSkinType = this.mSkinType;
            }
        }
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(AccountData accountData) {
        Activity activity;
        com.baidu.adp.base.e<?> ab = com.baidu.adp.base.i.ab(this.mContext);
        if (!(ab instanceof TbPageContext)) {
            activity = null;
        } else {
            activity = ((TbPageContext) ab).getPageActivity();
        }
        if (this.cdW == null) {
            this.cdW = new com.baidu.tbadk.coreExtra.view.c(activity);
        }
        this.cdW.apm();
        this.cdW.setAccountData(accountData);
        this.cdW.jN(1);
    }

    public void onDestroy() {
        if (this.cdW != null) {
            this.cdW.onDestroy();
        }
    }
}
