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
    private static final int dIg = e.g.manager_apply_tip;
    private static final int dIh = e.g.assist_apply_tip;
    private com.baidu.tbadk.coreExtra.view.a aMU;
    private View.OnClickListener mClickListener;

    public o(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.member.o.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Object tag = view.getTag(o.dIg);
                if (TbadkCoreApplication.isLogin() && StringUtils.isNull(TbadkCoreApplication.getCurrentAccountName())) {
                    o.this.i(TbadkCoreApplication.getCurrentAccountInfo());
                } else if (tag != null && !tag.toString().equals("")) {
                    ay.Ef().c((TbPageContext) com.baidu.adp.base.i.aK(o.this.mContext), new String[]{tag.toString()});
                } else {
                    ay.Ef().c((TbPageContext) com.baidu.adp.base.i.aK(o.this.mContext), new String[]{view.getTag(o.dIh).toString()});
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
                    al.j(qVar.awG, e.d.cp_bg_line_b);
                    al.c(qVar.dIr, e.d.cp_cont_d, 1);
                    al.c(qVar.dIs, e.d.cp_cont_d, 1);
                    al.c(qVar.dIp, e.d.cp_cont_b, 1);
                    al.c(qVar.dIq, e.d.cp_cont_b, 1);
                    al.i(qVar.dIt, e.f.frs_member_manito_bg);
                    al.i(qVar.dIu, e.f.frs_member_manito_bg);
                }
                int aAl = pVar.aAl();
                if (aAl == -1) {
                    int aAk = pVar.aAk();
                    String Q = ao.Q(aAk);
                    if (aAk > 0) {
                        qVar.dIr.setText(String.format(this.mContext.getResources().getString(e.j.tbtitle_apply_left_num_tip), Q));
                        qVar.dIt.setTag(dIg, pVar.aAn());
                        qVar.dIt.setOnClickListener(this.mClickListener);
                        qVar.dIt.setEnabled(true);
                        qVar.dIt.setClickable(true);
                    } else {
                        qVar.dIr.setText(this.mContext.getResources().getString(e.j.tbtitle_quota_is_full));
                        qVar.dIt.setTag(dIg, pVar.aAn());
                        qVar.dIt.setOnClickListener(this.mClickListener);
                        qVar.dIt.setEnabled(false);
                        qVar.dIt.setClickable(false);
                    }
                } else if (aAl == 0) {
                    qVar.dIr.setText(this.mContext.getResources().getString(e.j.tbtitle_is_bazhu));
                    qVar.dIt.setTag(dIg, pVar.aAn());
                    qVar.dIt.setOnClickListener(this.mClickListener);
                    qVar.dIt.setEnabled(true);
                    qVar.dIt.setClickable(true);
                } else if (aAl == 1) {
                    qVar.dIr.setText(this.mContext.getResources().getString(e.j.tbtitle_applying));
                    qVar.dIt.setTag(dIg, pVar.aAn());
                    qVar.dIt.setOnClickListener(this.mClickListener);
                    qVar.dIt.setEnabled(true);
                    qVar.dIt.setClickable(true);
                } else if (aAl == 2) {
                    qVar.dIr.setText(this.mContext.getResources().getString(e.j.tbtitle_apply_failed));
                    qVar.dIt.setTag(dIg, pVar.aAn());
                    qVar.dIt.setOnClickListener(this.mClickListener);
                    qVar.dIt.setEnabled(true);
                    qVar.dIt.setClickable(true);
                } else {
                    qVar.dIr.setText(this.mContext.getResources().getString(e.j.tbtitle_quota_is_full));
                    qVar.dIt.setTag(dIg, pVar.aAn());
                    qVar.dIt.setOnClickListener(this.mClickListener);
                    qVar.dIt.setEnabled(false);
                    qVar.dIt.setClickable(false);
                }
                int aAm = pVar.aAm();
                if (aAm > 0) {
                    qVar.dIs.setText(String.format(this.mContext.getResources().getString(e.j.apply_left_num_tip), ao.Q(aAm)));
                    qVar.dIu.setTag(dIh, pVar.aAo());
                    qVar.dIu.setOnClickListener(this.mClickListener);
                    qVar.dIu.setEnabled(true);
                    qVar.dIu.setClickable(true);
                } else {
                    qVar.dIs.setText(this.mContext.getResources().getString(e.j.apply_no_left_tip));
                    qVar.dIu.setEnabled(false);
                    qVar.dIu.setClickable(false);
                }
                qVar.dIs.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(e.f.icon_arrow_tab), (Drawable) null);
                qVar.dIr.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(e.f.icon_arrow_tab), (Drawable) null);
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
        if (this.aMU == null) {
            this.aMU = new com.baidu.tbadk.coreExtra.view.a(activity);
        }
        this.aMU.Kv();
        this.aMU.setAccountData(accountData);
        this.aMU.fs(1);
    }

    public void onDestroy() {
        if (this.aMU != null) {
            this.aMU.onDestroy();
        }
    }
}
