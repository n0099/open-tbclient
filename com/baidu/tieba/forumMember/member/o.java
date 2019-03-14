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
public class o extends com.baidu.tieba.frs.h<p, q> {
    private static final int eWb = d.g.manager_apply_tip;
    private static final int eWc = d.g.assist_apply_tip;
    private com.baidu.tbadk.coreExtra.view.c bVX;
    private View.OnClickListener mClickListener;

    public o(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.member.o.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Object tag = view.getTag(o.eWb);
                if (TbadkCoreApplication.isLogin() && StringUtils.isNull(TbadkCoreApplication.getCurrentAccountName())) {
                    o.this.i(TbadkCoreApplication.getCurrentAccountInfo());
                } else if (tag != null && !tag.toString().equals("")) {
                    ba.adD().c((TbPageContext) com.baidu.adp.base.i.aK(o.this.mContext), new String[]{tag.toString()});
                } else {
                    ba.adD().c((TbPageContext) com.baidu.adp.base.i.aK(o.this.mContext), new String[]{view.getTag(o.eWc).toString()});
                }
            }
        };
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aB */
    public q onCreateViewHolder(ViewGroup viewGroup) {
        return new q(LayoutInflater.from(this.mContext).inflate(d.h.frs_member_manager_apply, (ViewGroup) null));
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
                    al.l(qVar.bER, d.C0277d.cp_bg_line_b);
                    al.d(qVar.eWm, d.C0277d.cp_cont_d, 1);
                    al.d(qVar.eWn, d.C0277d.cp_cont_d, 1);
                    al.d(qVar.eWk, d.C0277d.cp_cont_b, 1);
                    al.d(qVar.eWl, d.C0277d.cp_cont_b, 1);
                    al.k(qVar.eWo, d.f.frs_member_manito_bg);
                    al.k(qVar.eWp, d.f.frs_member_manito_bg);
                }
                int bbh = pVar.bbh();
                if (bbh == -1) {
                    int bbg = pVar.bbg();
                    String as = ap.as(bbg);
                    if (bbg > 0) {
                        qVar.eWm.setText(String.format(this.mContext.getResources().getString(d.j.tbtitle_apply_left_num_tip), as));
                        qVar.eWo.setTag(eWb, pVar.bbj());
                        qVar.eWo.setOnClickListener(this.mClickListener);
                        qVar.eWo.setEnabled(true);
                        qVar.eWo.setClickable(true);
                    } else {
                        qVar.eWm.setText(this.mContext.getResources().getString(d.j.tbtitle_quota_is_full));
                        qVar.eWo.setTag(eWb, pVar.bbj());
                        qVar.eWo.setOnClickListener(this.mClickListener);
                        qVar.eWo.setEnabled(false);
                        qVar.eWo.setClickable(false);
                    }
                } else if (bbh == 0) {
                    qVar.eWm.setText(this.mContext.getResources().getString(d.j.tbtitle_is_bazhu));
                    qVar.eWo.setTag(eWb, pVar.bbj());
                    qVar.eWo.setOnClickListener(this.mClickListener);
                    qVar.eWo.setEnabled(true);
                    qVar.eWo.setClickable(true);
                } else if (bbh == 1) {
                    qVar.eWm.setText(this.mContext.getResources().getString(d.j.tbtitle_applying));
                    qVar.eWo.setTag(eWb, pVar.bbj());
                    qVar.eWo.setOnClickListener(this.mClickListener);
                    qVar.eWo.setEnabled(true);
                    qVar.eWo.setClickable(true);
                } else if (bbh == 2) {
                    qVar.eWm.setText(this.mContext.getResources().getString(d.j.tbtitle_apply_failed));
                    qVar.eWo.setTag(eWb, pVar.bbj());
                    qVar.eWo.setOnClickListener(this.mClickListener);
                    qVar.eWo.setEnabled(true);
                    qVar.eWo.setClickable(true);
                } else {
                    qVar.eWm.setText(this.mContext.getResources().getString(d.j.tbtitle_quota_is_full));
                    qVar.eWo.setTag(eWb, pVar.bbj());
                    qVar.eWo.setOnClickListener(this.mClickListener);
                    qVar.eWo.setEnabled(false);
                    qVar.eWo.setClickable(false);
                }
                int bbi = pVar.bbi();
                if (bbi > 0) {
                    qVar.eWn.setText(String.format(this.mContext.getResources().getString(d.j.apply_left_num_tip), ap.as(bbi)));
                    qVar.eWp.setTag(eWc, pVar.bbk());
                    qVar.eWp.setOnClickListener(this.mClickListener);
                    qVar.eWp.setEnabled(true);
                    qVar.eWp.setClickable(true);
                } else {
                    qVar.eWn.setText(this.mContext.getResources().getString(d.j.apply_no_left_tip));
                    qVar.eWp.setEnabled(false);
                    qVar.eWp.setClickable(false);
                }
                qVar.eWn.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(d.f.icon_arrow12_gray66_right), (Drawable) null);
                qVar.eWm.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(d.f.icon_arrow12_gray66_right), (Drawable) null);
                qVar.mSkinType = this.mSkinType;
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
        if (this.bVX == null) {
            this.bVX = new com.baidu.tbadk.coreExtra.view.c(activity);
        }
        this.bVX.akm();
        this.bVX.setAccountData(accountData);
        this.bVX.ja(1);
    }

    public void onDestroy() {
        if (this.bVX != null) {
            this.bVX.onDestroy();
        }
    }
}
