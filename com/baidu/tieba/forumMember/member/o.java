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
    private com.baidu.tbadk.coreExtra.view.a aDY;
    private View.OnClickListener mClickListener;
    private static final int dpz = e.g.manager_apply_tip;
    private static final int dpA = e.g.assist_apply_tip;

    public o(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.member.o.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Object tag = view.getTag(o.dpz);
                if (TbadkCoreApplication.isLogin() && StringUtils.isNull(TbadkCoreApplication.getCurrentAccountName())) {
                    o.this.i(TbadkCoreApplication.getCurrentAccountInfo());
                } else if (tag != null && !tag.toString().equals("")) {
                    ay.AN().c((TbPageContext) com.baidu.adp.base.i.aK(o.this.mContext), new String[]{tag.toString()});
                } else {
                    ay.AN().c((TbPageContext) com.baidu.adp.base.i.aK(o.this.mContext), new String[]{view.getTag(o.dpA).toString()});
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
                    al.j(qVar.any, e.d.cp_bg_line_b);
                    al.c(qVar.dpK, e.d.cp_cont_d, 1);
                    al.c(qVar.dpL, e.d.cp_cont_d, 1);
                    al.c(qVar.dpI, e.d.cp_cont_b, 1);
                    al.c(qVar.dpJ, e.d.cp_cont_b, 1);
                    al.i(qVar.dpM, e.f.frs_member_manito_bg);
                    al.i(qVar.dpN, e.f.frs_member_manito_bg);
                }
                int auS = pVar.auS();
                if (auS == -1) {
                    int auR = pVar.auR();
                    String E = ao.E(auR);
                    if (auR > 0) {
                        qVar.dpK.setText(String.format(this.mContext.getResources().getString(e.j.tbtitle_apply_left_num_tip), E));
                        qVar.dpM.setTag(dpz, pVar.auU());
                        qVar.dpM.setOnClickListener(this.mClickListener);
                        qVar.dpM.setEnabled(true);
                        qVar.dpM.setClickable(true);
                    } else {
                        qVar.dpK.setText(this.mContext.getResources().getString(e.j.tbtitle_quota_is_full));
                        qVar.dpM.setTag(dpz, pVar.auU());
                        qVar.dpM.setOnClickListener(this.mClickListener);
                        qVar.dpM.setEnabled(false);
                        qVar.dpM.setClickable(false);
                    }
                } else if (auS == 0) {
                    qVar.dpK.setText(this.mContext.getResources().getString(e.j.tbtitle_is_bazhu));
                    qVar.dpM.setTag(dpz, pVar.auU());
                    qVar.dpM.setOnClickListener(this.mClickListener);
                    qVar.dpM.setEnabled(true);
                    qVar.dpM.setClickable(true);
                } else if (auS == 1) {
                    qVar.dpK.setText(this.mContext.getResources().getString(e.j.tbtitle_applying));
                    qVar.dpM.setTag(dpz, pVar.auU());
                    qVar.dpM.setOnClickListener(this.mClickListener);
                    qVar.dpM.setEnabled(true);
                    qVar.dpM.setClickable(true);
                } else if (auS == 2) {
                    qVar.dpK.setText(this.mContext.getResources().getString(e.j.tbtitle_apply_failed));
                    qVar.dpM.setTag(dpz, pVar.auU());
                    qVar.dpM.setOnClickListener(this.mClickListener);
                    qVar.dpM.setEnabled(true);
                    qVar.dpM.setClickable(true);
                } else {
                    qVar.dpK.setText(this.mContext.getResources().getString(e.j.tbtitle_quota_is_full));
                    qVar.dpM.setTag(dpz, pVar.auU());
                    qVar.dpM.setOnClickListener(this.mClickListener);
                    qVar.dpM.setEnabled(false);
                    qVar.dpM.setClickable(false);
                }
                int auT = pVar.auT();
                if (auT > 0) {
                    qVar.dpL.setText(String.format(this.mContext.getResources().getString(e.j.apply_left_num_tip), ao.E(auT)));
                    qVar.dpN.setTag(dpA, pVar.auV());
                    qVar.dpN.setOnClickListener(this.mClickListener);
                    qVar.dpN.setEnabled(true);
                    qVar.dpN.setClickable(true);
                } else {
                    qVar.dpL.setText(this.mContext.getResources().getString(e.j.apply_no_left_tip));
                    qVar.dpN.setEnabled(false);
                    qVar.dpN.setClickable(false);
                }
                qVar.dpL.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(e.f.icon_arrow_tab), (Drawable) null);
                qVar.dpK.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(e.f.icon_arrow_tab), (Drawable) null);
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
        if (this.aDY == null) {
            this.aDY = new com.baidu.tbadk.coreExtra.view.a(activity);
        }
        this.aDY.Hd();
        this.aDY.setAccountData(accountData);
        this.aDY.eG(1);
    }

    public void onDestroy() {
        if (this.aDY != null) {
            this.aDY.onDestroy();
        }
    }
}
