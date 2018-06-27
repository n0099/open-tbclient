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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.az;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class o extends com.baidu.tieba.frs.h<p, q> {
    private static final int dgS = d.g.manager_apply_tip;
    private static final int dgT = d.g.assist_apply_tip;
    private com.baidu.tbadk.coreExtra.view.a aBd;
    private View.OnClickListener mClickListener;

    public o(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.member.o.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Object tag = view.getTag(o.dgS);
                if (TbadkCoreApplication.isLogin() && StringUtils.isNull(TbadkCoreApplication.getCurrentAccountName())) {
                    o.this.i(TbadkCoreApplication.getCurrentAccountInfo());
                } else if (tag != null && !tag.toString().equals("")) {
                    az.zV().c((TbPageContext) com.baidu.adp.base.i.ad(o.this.mContext), new String[]{tag.toString()});
                } else {
                    az.zV().c((TbPageContext) com.baidu.adp.base.i.ad(o.this.mContext), new String[]{view.getTag(o.dgT).toString()});
                }
            }
        };
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ak */
    public q onCreateViewHolder(ViewGroup viewGroup) {
        return new q(LayoutInflater.from(this.mContext).inflate(d.i.frs_member_manager_apply, (ViewGroup) null));
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
                    am.j(qVar.alt, d.C0142d.cp_bg_line_b);
                    am.c(qVar.dhd, d.C0142d.cp_cont_d, 1);
                    am.c(qVar.dhe, d.C0142d.cp_cont_d, 1);
                    am.c(qVar.dhb, d.C0142d.cp_cont_b, 1);
                    am.c(qVar.dhc, d.C0142d.cp_cont_b, 1);
                    am.i(qVar.dhf, d.f.frs_member_manito_bg);
                    am.i(qVar.dhg, d.f.frs_member_manito_bg);
                }
                int asB = pVar.asB();
                if (asB == -1) {
                    int asA = pVar.asA();
                    String z = ap.z(asA);
                    if (asA > 0) {
                        qVar.dhd.setText(String.format(this.mContext.getResources().getString(d.k.tbtitle_apply_left_num_tip), z));
                        qVar.dhf.setTag(dgS, pVar.asD());
                        qVar.dhf.setOnClickListener(this.mClickListener);
                        qVar.dhf.setEnabled(true);
                        qVar.dhf.setClickable(true);
                    } else {
                        qVar.dhd.setText(this.mContext.getResources().getString(d.k.tbtitle_quota_is_full));
                        qVar.dhf.setTag(dgS, pVar.asD());
                        qVar.dhf.setOnClickListener(this.mClickListener);
                        qVar.dhf.setEnabled(false);
                        qVar.dhf.setClickable(false);
                    }
                } else if (asB == 0) {
                    qVar.dhd.setText(this.mContext.getResources().getString(d.k.tbtitle_is_bazhu));
                    qVar.dhf.setTag(dgS, pVar.asD());
                    qVar.dhf.setOnClickListener(this.mClickListener);
                    qVar.dhf.setEnabled(true);
                    qVar.dhf.setClickable(true);
                } else if (asB == 1) {
                    qVar.dhd.setText(this.mContext.getResources().getString(d.k.tbtitle_applying));
                    qVar.dhf.setTag(dgS, pVar.asD());
                    qVar.dhf.setOnClickListener(this.mClickListener);
                    qVar.dhf.setEnabled(true);
                    qVar.dhf.setClickable(true);
                } else if (asB == 2) {
                    qVar.dhd.setText(this.mContext.getResources().getString(d.k.tbtitle_apply_failed));
                    qVar.dhf.setTag(dgS, pVar.asD());
                    qVar.dhf.setOnClickListener(this.mClickListener);
                    qVar.dhf.setEnabled(true);
                    qVar.dhf.setClickable(true);
                } else {
                    qVar.dhd.setText(this.mContext.getResources().getString(d.k.tbtitle_quota_is_full));
                    qVar.dhf.setTag(dgS, pVar.asD());
                    qVar.dhf.setOnClickListener(this.mClickListener);
                    qVar.dhf.setEnabled(false);
                    qVar.dhf.setClickable(false);
                }
                int asC = pVar.asC();
                if (asC > 0) {
                    qVar.dhe.setText(String.format(this.mContext.getResources().getString(d.k.apply_left_num_tip), ap.z(asC)));
                    qVar.dhg.setTag(dgT, pVar.asE());
                    qVar.dhg.setOnClickListener(this.mClickListener);
                    qVar.dhg.setEnabled(true);
                    qVar.dhg.setClickable(true);
                } else {
                    qVar.dhe.setText(this.mContext.getResources().getString(d.k.apply_no_left_tip));
                    qVar.dhg.setEnabled(false);
                    qVar.dhg.setClickable(false);
                }
                qVar.dhe.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(d.f.icon_arrow_tab), (Drawable) null);
                qVar.dhd.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(d.f.icon_arrow_tab), (Drawable) null);
                qVar.mSkinType = this.mSkinType;
            }
        }
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(AccountData accountData) {
        Activity activity;
        com.baidu.adp.base.e<?> ad = com.baidu.adp.base.i.ad(this.mContext);
        if (!(ad instanceof TbPageContext)) {
            activity = null;
        } else {
            activity = ((TbPageContext) ad).getPageActivity();
        }
        if (this.aBd == null) {
            this.aBd = new com.baidu.tbadk.coreExtra.view.a(activity);
        }
        this.aBd.FR();
        this.aBd.setAccountData(accountData);
        this.aBd.es(1);
    }

    public void onDestroy() {
        if (this.aBd != null) {
            this.aBd.onDestroy();
        }
    }
}
