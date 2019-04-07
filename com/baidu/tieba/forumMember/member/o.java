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
    private static final int eVN = d.g.manager_apply_tip;
    private static final int eVO = d.g.assist_apply_tip;
    private com.baidu.tbadk.coreExtra.view.c bVZ;
    private View.OnClickListener mClickListener;

    public o(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.member.o.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Object tag = view.getTag(o.eVN);
                if (TbadkCoreApplication.isLogin() && StringUtils.isNull(TbadkCoreApplication.getCurrentAccountName())) {
                    o.this.i(TbadkCoreApplication.getCurrentAccountInfo());
                } else if (tag != null && !tag.toString().equals("")) {
                    ba.adA().c((TbPageContext) com.baidu.adp.base.i.aK(o.this.mContext), new String[]{tag.toString()});
                } else {
                    ba.adA().c((TbPageContext) com.baidu.adp.base.i.aK(o.this.mContext), new String[]{view.getTag(o.eVO).toString()});
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
                    al.l(qVar.bET, d.C0277d.cp_bg_line_b);
                    al.d(qVar.eVY, d.C0277d.cp_cont_d, 1);
                    al.d(qVar.eVZ, d.C0277d.cp_cont_d, 1);
                    al.d(qVar.eVW, d.C0277d.cp_cont_b, 1);
                    al.d(qVar.eVX, d.C0277d.cp_cont_b, 1);
                    al.k(qVar.eWa, d.f.frs_member_manito_bg);
                    al.k(qVar.eWb, d.f.frs_member_manito_bg);
                }
                int bbf = pVar.bbf();
                if (bbf == -1) {
                    int bbe = pVar.bbe();
                    String as = ap.as(bbe);
                    if (bbe > 0) {
                        qVar.eVY.setText(String.format(this.mContext.getResources().getString(d.j.tbtitle_apply_left_num_tip), as));
                        qVar.eWa.setTag(eVN, pVar.bbh());
                        qVar.eWa.setOnClickListener(this.mClickListener);
                        qVar.eWa.setEnabled(true);
                        qVar.eWa.setClickable(true);
                    } else {
                        qVar.eVY.setText(this.mContext.getResources().getString(d.j.tbtitle_quota_is_full));
                        qVar.eWa.setTag(eVN, pVar.bbh());
                        qVar.eWa.setOnClickListener(this.mClickListener);
                        qVar.eWa.setEnabled(false);
                        qVar.eWa.setClickable(false);
                    }
                } else if (bbf == 0) {
                    qVar.eVY.setText(this.mContext.getResources().getString(d.j.tbtitle_is_bazhu));
                    qVar.eWa.setTag(eVN, pVar.bbh());
                    qVar.eWa.setOnClickListener(this.mClickListener);
                    qVar.eWa.setEnabled(true);
                    qVar.eWa.setClickable(true);
                } else if (bbf == 1) {
                    qVar.eVY.setText(this.mContext.getResources().getString(d.j.tbtitle_applying));
                    qVar.eWa.setTag(eVN, pVar.bbh());
                    qVar.eWa.setOnClickListener(this.mClickListener);
                    qVar.eWa.setEnabled(true);
                    qVar.eWa.setClickable(true);
                } else if (bbf == 2) {
                    qVar.eVY.setText(this.mContext.getResources().getString(d.j.tbtitle_apply_failed));
                    qVar.eWa.setTag(eVN, pVar.bbh());
                    qVar.eWa.setOnClickListener(this.mClickListener);
                    qVar.eWa.setEnabled(true);
                    qVar.eWa.setClickable(true);
                } else {
                    qVar.eVY.setText(this.mContext.getResources().getString(d.j.tbtitle_quota_is_full));
                    qVar.eWa.setTag(eVN, pVar.bbh());
                    qVar.eWa.setOnClickListener(this.mClickListener);
                    qVar.eWa.setEnabled(false);
                    qVar.eWa.setClickable(false);
                }
                int bbg = pVar.bbg();
                if (bbg > 0) {
                    qVar.eVZ.setText(String.format(this.mContext.getResources().getString(d.j.apply_left_num_tip), ap.as(bbg)));
                    qVar.eWb.setTag(eVO, pVar.bbi());
                    qVar.eWb.setOnClickListener(this.mClickListener);
                    qVar.eWb.setEnabled(true);
                    qVar.eWb.setClickable(true);
                } else {
                    qVar.eVZ.setText(this.mContext.getResources().getString(d.j.apply_no_left_tip));
                    qVar.eWb.setEnabled(false);
                    qVar.eWb.setClickable(false);
                }
                qVar.eVZ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(d.f.icon_arrow12_gray66_right), (Drawable) null);
                qVar.eVY.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(d.f.icon_arrow12_gray66_right), (Drawable) null);
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
