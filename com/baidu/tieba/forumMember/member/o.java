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
    private static final int dFs = e.g.manager_apply_tip;
    private static final int dFt = e.g.assist_apply_tip;
    private com.baidu.tbadk.coreExtra.view.a aMS;
    private View.OnClickListener mClickListener;

    public o(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.member.o.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Object tag = view.getTag(o.dFs);
                if (TbadkCoreApplication.isLogin() && StringUtils.isNull(TbadkCoreApplication.getCurrentAccountName())) {
                    o.this.i(TbadkCoreApplication.getCurrentAccountInfo());
                } else if (tag != null && !tag.toString().equals("")) {
                    ay.Ef().c((TbPageContext) com.baidu.adp.base.i.aK(o.this.mContext), new String[]{tag.toString()});
                } else {
                    ay.Ef().c((TbPageContext) com.baidu.adp.base.i.aK(o.this.mContext), new String[]{view.getTag(o.dFt).toString()});
                }
            }
        };
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: am */
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
                    al.j(qVar.awF, e.d.cp_bg_line_b);
                    al.c(qVar.dFD, e.d.cp_cont_d, 1);
                    al.c(qVar.dFE, e.d.cp_cont_d, 1);
                    al.c(qVar.dFB, e.d.cp_cont_b, 1);
                    al.c(qVar.dFC, e.d.cp_cont_b, 1);
                    al.i(qVar.dFF, e.f.frs_member_manito_bg);
                    al.i(qVar.dFG, e.f.frs_member_manito_bg);
                }
                int azw = pVar.azw();
                if (azw == -1) {
                    int azv = pVar.azv();
                    String P = ao.P(azv);
                    if (azv > 0) {
                        qVar.dFD.setText(String.format(this.mContext.getResources().getString(e.j.tbtitle_apply_left_num_tip), P));
                        qVar.dFF.setTag(dFs, pVar.azy());
                        qVar.dFF.setOnClickListener(this.mClickListener);
                        qVar.dFF.setEnabled(true);
                        qVar.dFF.setClickable(true);
                    } else {
                        qVar.dFD.setText(this.mContext.getResources().getString(e.j.tbtitle_quota_is_full));
                        qVar.dFF.setTag(dFs, pVar.azy());
                        qVar.dFF.setOnClickListener(this.mClickListener);
                        qVar.dFF.setEnabled(false);
                        qVar.dFF.setClickable(false);
                    }
                } else if (azw == 0) {
                    qVar.dFD.setText(this.mContext.getResources().getString(e.j.tbtitle_is_bazhu));
                    qVar.dFF.setTag(dFs, pVar.azy());
                    qVar.dFF.setOnClickListener(this.mClickListener);
                    qVar.dFF.setEnabled(true);
                    qVar.dFF.setClickable(true);
                } else if (azw == 1) {
                    qVar.dFD.setText(this.mContext.getResources().getString(e.j.tbtitle_applying));
                    qVar.dFF.setTag(dFs, pVar.azy());
                    qVar.dFF.setOnClickListener(this.mClickListener);
                    qVar.dFF.setEnabled(true);
                    qVar.dFF.setClickable(true);
                } else if (azw == 2) {
                    qVar.dFD.setText(this.mContext.getResources().getString(e.j.tbtitle_apply_failed));
                    qVar.dFF.setTag(dFs, pVar.azy());
                    qVar.dFF.setOnClickListener(this.mClickListener);
                    qVar.dFF.setEnabled(true);
                    qVar.dFF.setClickable(true);
                } else {
                    qVar.dFD.setText(this.mContext.getResources().getString(e.j.tbtitle_quota_is_full));
                    qVar.dFF.setTag(dFs, pVar.azy());
                    qVar.dFF.setOnClickListener(this.mClickListener);
                    qVar.dFF.setEnabled(false);
                    qVar.dFF.setClickable(false);
                }
                int azx = pVar.azx();
                if (azx > 0) {
                    qVar.dFE.setText(String.format(this.mContext.getResources().getString(e.j.apply_left_num_tip), ao.P(azx)));
                    qVar.dFG.setTag(dFt, pVar.azz());
                    qVar.dFG.setOnClickListener(this.mClickListener);
                    qVar.dFG.setEnabled(true);
                    qVar.dFG.setClickable(true);
                } else {
                    qVar.dFE.setText(this.mContext.getResources().getString(e.j.apply_no_left_tip));
                    qVar.dFG.setEnabled(false);
                    qVar.dFG.setClickable(false);
                }
                qVar.dFE.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(e.f.icon_arrow_tab), (Drawable) null);
                qVar.dFD.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(e.f.icon_arrow_tab), (Drawable) null);
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
        if (this.aMS == null) {
            this.aMS = new com.baidu.tbadk.coreExtra.view.a(activity);
        }
        this.aMS.Ku();
        this.aMS.setAccountData(accountData);
        this.aMS.fr(1);
    }

    public void onDestroy() {
        if (this.aMS != null) {
            this.aMS.onDestroy();
        }
    }
}
