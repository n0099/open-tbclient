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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class o extends com.baidu.tieba.frs.h<p, q> {
    private static final int dxB = e.g.manager_apply_tip;
    private static final int dxC = e.g.assist_apply_tip;
    private com.baidu.tbadk.coreExtra.view.a aIC;
    private View.OnClickListener mClickListener;

    public o(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.member.o.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Object tag = view.getTag(o.dxB);
                if (TbadkCoreApplication.isLogin() && StringUtils.isNull(TbadkCoreApplication.getCurrentAccountName())) {
                    o.this.i(TbadkCoreApplication.getCurrentAccountInfo());
                } else if (tag != null && !tag.toString().equals("")) {
                    ay.CU().c((TbPageContext) com.baidu.adp.base.i.aK(o.this.mContext), new String[]{tag.toString()});
                } else {
                    ay.CU().c((TbPageContext) com.baidu.adp.base.i.aK(o.this.mContext), new String[]{view.getTag(o.dxC).toString()});
                }
            }
        };
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: al */
    public q onCreateViewHolder(ViewGroup viewGroup) {
        return new q(LayoutInflater.from(this.mContext).inflate(e.h.frs_member_manager_apply, (ViewGroup) null));
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
                    al.j(qVar.ass, e.d.cp_bg_line_b);
                    al.c(qVar.dxM, e.d.cp_cont_d, 1);
                    al.c(qVar.dxN, e.d.cp_cont_d, 1);
                    al.c(qVar.dxK, e.d.cp_cont_b, 1);
                    al.c(qVar.dxL, e.d.cp_cont_b, 1);
                    al.i(qVar.dxO, e.f.frs_member_manito_bg);
                    al.i(qVar.dxP, e.f.frs_member_manito_bg);
                }
                int ayp = pVar.ayp();
                if (ayp == -1) {
                    int ayo = pVar.ayo();
                    String G = ao.G(ayo);
                    if (ayo > 0) {
                        qVar.dxM.setText(String.format(this.mContext.getResources().getString(e.j.tbtitle_apply_left_num_tip), G));
                        qVar.dxO.setTag(dxB, pVar.ayr());
                        qVar.dxO.setOnClickListener(this.mClickListener);
                        qVar.dxO.setEnabled(true);
                        qVar.dxO.setClickable(true);
                    } else {
                        qVar.dxM.setText(this.mContext.getResources().getString(e.j.tbtitle_quota_is_full));
                        qVar.dxO.setTag(dxB, pVar.ayr());
                        qVar.dxO.setOnClickListener(this.mClickListener);
                        qVar.dxO.setEnabled(false);
                        qVar.dxO.setClickable(false);
                    }
                } else if (ayp == 0) {
                    qVar.dxM.setText(this.mContext.getResources().getString(e.j.tbtitle_is_bazhu));
                    qVar.dxO.setTag(dxB, pVar.ayr());
                    qVar.dxO.setOnClickListener(this.mClickListener);
                    qVar.dxO.setEnabled(true);
                    qVar.dxO.setClickable(true);
                } else if (ayp == 1) {
                    qVar.dxM.setText(this.mContext.getResources().getString(e.j.tbtitle_applying));
                    qVar.dxO.setTag(dxB, pVar.ayr());
                    qVar.dxO.setOnClickListener(this.mClickListener);
                    qVar.dxO.setEnabled(true);
                    qVar.dxO.setClickable(true);
                } else if (ayp == 2) {
                    qVar.dxM.setText(this.mContext.getResources().getString(e.j.tbtitle_apply_failed));
                    qVar.dxO.setTag(dxB, pVar.ayr());
                    qVar.dxO.setOnClickListener(this.mClickListener);
                    qVar.dxO.setEnabled(true);
                    qVar.dxO.setClickable(true);
                } else {
                    qVar.dxM.setText(this.mContext.getResources().getString(e.j.tbtitle_quota_is_full));
                    qVar.dxO.setTag(dxB, pVar.ayr());
                    qVar.dxO.setOnClickListener(this.mClickListener);
                    qVar.dxO.setEnabled(false);
                    qVar.dxO.setClickable(false);
                }
                int ayq = pVar.ayq();
                if (ayq > 0) {
                    qVar.dxN.setText(String.format(this.mContext.getResources().getString(e.j.apply_left_num_tip), ao.G(ayq)));
                    qVar.dxP.setTag(dxC, pVar.ays());
                    qVar.dxP.setOnClickListener(this.mClickListener);
                    qVar.dxP.setEnabled(true);
                    qVar.dxP.setClickable(true);
                } else {
                    qVar.dxN.setText(this.mContext.getResources().getString(e.j.apply_no_left_tip));
                    qVar.dxP.setEnabled(false);
                    qVar.dxP.setClickable(false);
                }
                qVar.dxN.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(e.f.icon_arrow_tab), (Drawable) null);
                qVar.dxM.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(e.f.icon_arrow_tab), (Drawable) null);
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
        if (this.aIC == null) {
            this.aIC = new com.baidu.tbadk.coreExtra.view.a(activity);
        }
        this.aIC.Je();
        this.aIC.setAccountData(accountData);
        this.aIC.eP(1);
    }

    public void onDestroy() {
        if (this.aIC != null) {
            this.aIC.onDestroy();
        }
    }
}
