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
import com.baidu.tieba.f;
/* loaded from: classes3.dex */
public class o extends com.baidu.tieba.frs.h<p, q> {
    private static final int djG = f.g.manager_apply_tip;
    private static final int djH = f.g.assist_apply_tip;
    private com.baidu.tbadk.coreExtra.view.a aAU;
    private View.OnClickListener mClickListener;

    public o(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.member.o.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Object tag = view.getTag(o.djG);
                if (TbadkCoreApplication.isLogin() && StringUtils.isNull(TbadkCoreApplication.getCurrentAccountName())) {
                    o.this.i(TbadkCoreApplication.getCurrentAccountInfo());
                } else if (tag != null && !tag.toString().equals("")) {
                    az.zI().c((TbPageContext) com.baidu.adp.base.i.ad(o.this.mContext), new String[]{tag.toString()});
                } else {
                    az.zI().c((TbPageContext) com.baidu.adp.base.i.ad(o.this.mContext), new String[]{view.getTag(o.djH).toString()});
                }
            }
        };
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: al */
    public q onCreateViewHolder(ViewGroup viewGroup) {
        return new q(LayoutInflater.from(this.mContext).inflate(f.h.frs_member_manager_apply, (ViewGroup) null));
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
                    am.j(qVar.akS, f.d.cp_bg_line_b);
                    am.c(qVar.djR, f.d.cp_cont_d, 1);
                    am.c(qVar.djS, f.d.cp_cont_d, 1);
                    am.c(qVar.djP, f.d.cp_cont_b, 1);
                    am.c(qVar.djQ, f.d.cp_cont_b, 1);
                    am.i(qVar.djT, f.C0146f.frs_member_manito_bg);
                    am.i(qVar.djU, f.C0146f.frs_member_manito_bg);
                }
                int ate = pVar.ate();
                if (ate == -1) {
                    int atd = pVar.atd();
                    String A = ap.A(atd);
                    if (atd > 0) {
                        qVar.djR.setText(String.format(this.mContext.getResources().getString(f.j.tbtitle_apply_left_num_tip), A));
                        qVar.djT.setTag(djG, pVar.atg());
                        qVar.djT.setOnClickListener(this.mClickListener);
                        qVar.djT.setEnabled(true);
                        qVar.djT.setClickable(true);
                    } else {
                        qVar.djR.setText(this.mContext.getResources().getString(f.j.tbtitle_quota_is_full));
                        qVar.djT.setTag(djG, pVar.atg());
                        qVar.djT.setOnClickListener(this.mClickListener);
                        qVar.djT.setEnabled(false);
                        qVar.djT.setClickable(false);
                    }
                } else if (ate == 0) {
                    qVar.djR.setText(this.mContext.getResources().getString(f.j.tbtitle_is_bazhu));
                    qVar.djT.setTag(djG, pVar.atg());
                    qVar.djT.setOnClickListener(this.mClickListener);
                    qVar.djT.setEnabled(true);
                    qVar.djT.setClickable(true);
                } else if (ate == 1) {
                    qVar.djR.setText(this.mContext.getResources().getString(f.j.tbtitle_applying));
                    qVar.djT.setTag(djG, pVar.atg());
                    qVar.djT.setOnClickListener(this.mClickListener);
                    qVar.djT.setEnabled(true);
                    qVar.djT.setClickable(true);
                } else if (ate == 2) {
                    qVar.djR.setText(this.mContext.getResources().getString(f.j.tbtitle_apply_failed));
                    qVar.djT.setTag(djG, pVar.atg());
                    qVar.djT.setOnClickListener(this.mClickListener);
                    qVar.djT.setEnabled(true);
                    qVar.djT.setClickable(true);
                } else {
                    qVar.djR.setText(this.mContext.getResources().getString(f.j.tbtitle_quota_is_full));
                    qVar.djT.setTag(djG, pVar.atg());
                    qVar.djT.setOnClickListener(this.mClickListener);
                    qVar.djT.setEnabled(false);
                    qVar.djT.setClickable(false);
                }
                int atf = pVar.atf();
                if (atf > 0) {
                    qVar.djS.setText(String.format(this.mContext.getResources().getString(f.j.apply_left_num_tip), ap.A(atf)));
                    qVar.djU.setTag(djH, pVar.ath());
                    qVar.djU.setOnClickListener(this.mClickListener);
                    qVar.djU.setEnabled(true);
                    qVar.djU.setClickable(true);
                } else {
                    qVar.djS.setText(this.mContext.getResources().getString(f.j.apply_no_left_tip));
                    qVar.djU.setEnabled(false);
                    qVar.djU.setClickable(false);
                }
                qVar.djS.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(f.C0146f.icon_arrow_tab), (Drawable) null);
                qVar.djR.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(f.C0146f.icon_arrow_tab), (Drawable) null);
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
        if (this.aAU == null) {
            this.aAU = new com.baidu.tbadk.coreExtra.view.a(activity);
        }
        this.aAU.FN();
        this.aAU.setAccountData(accountData);
        this.aAU.eu(1);
    }

    public void onDestroy() {
        if (this.aAU != null) {
            this.aAU.onDestroy();
        }
    }
}
