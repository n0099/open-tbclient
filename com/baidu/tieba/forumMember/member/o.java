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
    private static final int dIQ = e.g.manager_apply_tip;
    private static final int dIR = e.g.assist_apply_tip;
    private com.baidu.tbadk.coreExtra.view.a aNx;
    private View.OnClickListener mClickListener;

    public o(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.member.o.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Object tag = view.getTag(o.dIQ);
                if (TbadkCoreApplication.isLogin() && StringUtils.isNull(TbadkCoreApplication.getCurrentAccountName())) {
                    o.this.i(TbadkCoreApplication.getCurrentAccountInfo());
                } else if (tag != null && !tag.toString().equals("")) {
                    ay.Es().c((TbPageContext) com.baidu.adp.base.i.aK(o.this.mContext), new String[]{tag.toString()});
                } else {
                    ay.Es().c((TbPageContext) com.baidu.adp.base.i.aK(o.this.mContext), new String[]{view.getTag(o.dIR).toString()});
                }
            }
        };
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: an */
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
                    al.j(qVar.axj, e.d.cp_bg_line_b);
                    al.c(qVar.dJb, e.d.cp_cont_d, 1);
                    al.c(qVar.dJc, e.d.cp_cont_d, 1);
                    al.c(qVar.dIZ, e.d.cp_cont_b, 1);
                    al.c(qVar.dJa, e.d.cp_cont_b, 1);
                    al.i(qVar.dJd, e.f.frs_member_manito_bg);
                    al.i(qVar.dJe, e.f.frs_member_manito_bg);
                }
                int aAI = pVar.aAI();
                if (aAI == -1) {
                    int aAH = pVar.aAH();
                    String Q = ao.Q(aAH);
                    if (aAH > 0) {
                        qVar.dJb.setText(String.format(this.mContext.getResources().getString(e.j.tbtitle_apply_left_num_tip), Q));
                        qVar.dJd.setTag(dIQ, pVar.aAK());
                        qVar.dJd.setOnClickListener(this.mClickListener);
                        qVar.dJd.setEnabled(true);
                        qVar.dJd.setClickable(true);
                    } else {
                        qVar.dJb.setText(this.mContext.getResources().getString(e.j.tbtitle_quota_is_full));
                        qVar.dJd.setTag(dIQ, pVar.aAK());
                        qVar.dJd.setOnClickListener(this.mClickListener);
                        qVar.dJd.setEnabled(false);
                        qVar.dJd.setClickable(false);
                    }
                } else if (aAI == 0) {
                    qVar.dJb.setText(this.mContext.getResources().getString(e.j.tbtitle_is_bazhu));
                    qVar.dJd.setTag(dIQ, pVar.aAK());
                    qVar.dJd.setOnClickListener(this.mClickListener);
                    qVar.dJd.setEnabled(true);
                    qVar.dJd.setClickable(true);
                } else if (aAI == 1) {
                    qVar.dJb.setText(this.mContext.getResources().getString(e.j.tbtitle_applying));
                    qVar.dJd.setTag(dIQ, pVar.aAK());
                    qVar.dJd.setOnClickListener(this.mClickListener);
                    qVar.dJd.setEnabled(true);
                    qVar.dJd.setClickable(true);
                } else if (aAI == 2) {
                    qVar.dJb.setText(this.mContext.getResources().getString(e.j.tbtitle_apply_failed));
                    qVar.dJd.setTag(dIQ, pVar.aAK());
                    qVar.dJd.setOnClickListener(this.mClickListener);
                    qVar.dJd.setEnabled(true);
                    qVar.dJd.setClickable(true);
                } else {
                    qVar.dJb.setText(this.mContext.getResources().getString(e.j.tbtitle_quota_is_full));
                    qVar.dJd.setTag(dIQ, pVar.aAK());
                    qVar.dJd.setOnClickListener(this.mClickListener);
                    qVar.dJd.setEnabled(false);
                    qVar.dJd.setClickable(false);
                }
                int aAJ = pVar.aAJ();
                if (aAJ > 0) {
                    qVar.dJc.setText(String.format(this.mContext.getResources().getString(e.j.apply_left_num_tip), ao.Q(aAJ)));
                    qVar.dJe.setTag(dIR, pVar.aAL());
                    qVar.dJe.setOnClickListener(this.mClickListener);
                    qVar.dJe.setEnabled(true);
                    qVar.dJe.setClickable(true);
                } else {
                    qVar.dJc.setText(this.mContext.getResources().getString(e.j.apply_no_left_tip));
                    qVar.dJe.setEnabled(false);
                    qVar.dJe.setClickable(false);
                }
                qVar.dJc.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(e.f.icon_arrow_tab), (Drawable) null);
                qVar.dJb.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(e.f.icon_arrow_tab), (Drawable) null);
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
        if (this.aNx == null) {
            this.aNx = new com.baidu.tbadk.coreExtra.view.a(activity);
        }
        this.aNx.KK();
        this.aNx.setAccountData(accountData);
        this.aNx.fs(1);
    }

    public void onDestroy() {
        if (this.aNx != null) {
            this.aNx.onDestroy();
        }
    }
}
