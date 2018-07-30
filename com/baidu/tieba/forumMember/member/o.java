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
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class o extends com.baidu.tieba.frs.h<p, q> {
    private static final int djI = d.g.manager_apply_tip;
    private static final int djJ = d.g.assist_apply_tip;
    private com.baidu.tbadk.coreExtra.view.a aAX;
    private View.OnClickListener mClickListener;

    public o(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.member.o.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Object tag = view.getTag(o.djI);
                if (TbadkCoreApplication.isLogin() && StringUtils.isNull(TbadkCoreApplication.getCurrentAccountName())) {
                    o.this.i(TbadkCoreApplication.getCurrentAccountInfo());
                } else if (tag != null && !tag.toString().equals("")) {
                    ay.zK().c((TbPageContext) com.baidu.adp.base.i.ad(o.this.mContext), new String[]{tag.toString()});
                } else {
                    ay.zK().c((TbPageContext) com.baidu.adp.base.i.ad(o.this.mContext), new String[]{view.getTag(o.djJ).toString()});
                }
            }
        };
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: al */
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
                    am.j(qVar.akS, d.C0140d.cp_bg_line_b);
                    am.c(qVar.djT, d.C0140d.cp_cont_d, 1);
                    am.c(qVar.djU, d.C0140d.cp_cont_d, 1);
                    am.c(qVar.djR, d.C0140d.cp_cont_b, 1);
                    am.c(qVar.djS, d.C0140d.cp_cont_b, 1);
                    am.i(qVar.djV, d.f.frs_member_manito_bg);
                    am.i(qVar.djW, d.f.frs_member_manito_bg);
                }
                int atf = pVar.atf();
                if (atf == -1) {
                    int ate = pVar.ate();
                    String A = ap.A(ate);
                    if (ate > 0) {
                        qVar.djT.setText(String.format(this.mContext.getResources().getString(d.j.tbtitle_apply_left_num_tip), A));
                        qVar.djV.setTag(djI, pVar.ath());
                        qVar.djV.setOnClickListener(this.mClickListener);
                        qVar.djV.setEnabled(true);
                        qVar.djV.setClickable(true);
                    } else {
                        qVar.djT.setText(this.mContext.getResources().getString(d.j.tbtitle_quota_is_full));
                        qVar.djV.setTag(djI, pVar.ath());
                        qVar.djV.setOnClickListener(this.mClickListener);
                        qVar.djV.setEnabled(false);
                        qVar.djV.setClickable(false);
                    }
                } else if (atf == 0) {
                    qVar.djT.setText(this.mContext.getResources().getString(d.j.tbtitle_is_bazhu));
                    qVar.djV.setTag(djI, pVar.ath());
                    qVar.djV.setOnClickListener(this.mClickListener);
                    qVar.djV.setEnabled(true);
                    qVar.djV.setClickable(true);
                } else if (atf == 1) {
                    qVar.djT.setText(this.mContext.getResources().getString(d.j.tbtitle_applying));
                    qVar.djV.setTag(djI, pVar.ath());
                    qVar.djV.setOnClickListener(this.mClickListener);
                    qVar.djV.setEnabled(true);
                    qVar.djV.setClickable(true);
                } else if (atf == 2) {
                    qVar.djT.setText(this.mContext.getResources().getString(d.j.tbtitle_apply_failed));
                    qVar.djV.setTag(djI, pVar.ath());
                    qVar.djV.setOnClickListener(this.mClickListener);
                    qVar.djV.setEnabled(true);
                    qVar.djV.setClickable(true);
                } else {
                    qVar.djT.setText(this.mContext.getResources().getString(d.j.tbtitle_quota_is_full));
                    qVar.djV.setTag(djI, pVar.ath());
                    qVar.djV.setOnClickListener(this.mClickListener);
                    qVar.djV.setEnabled(false);
                    qVar.djV.setClickable(false);
                }
                int atg = pVar.atg();
                if (atg > 0) {
                    qVar.djU.setText(String.format(this.mContext.getResources().getString(d.j.apply_left_num_tip), ap.A(atg)));
                    qVar.djW.setTag(djJ, pVar.ati());
                    qVar.djW.setOnClickListener(this.mClickListener);
                    qVar.djW.setEnabled(true);
                    qVar.djW.setClickable(true);
                } else {
                    qVar.djU.setText(this.mContext.getResources().getString(d.j.apply_no_left_tip));
                    qVar.djW.setEnabled(false);
                    qVar.djW.setClickable(false);
                }
                qVar.djU.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(d.f.icon_arrow_tab), (Drawable) null);
                qVar.djT.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(d.f.icon_arrow_tab), (Drawable) null);
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
        if (this.aAX == null) {
            this.aAX = new com.baidu.tbadk.coreExtra.view.a(activity);
        }
        this.aAX.FN();
        this.aAX.setAccountData(accountData);
        this.aAX.ev(1);
    }

    public void onDestroy() {
        if (this.aAX != null) {
            this.aAX.onDestroy();
        }
    }
}
