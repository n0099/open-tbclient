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
    private static final int dyT = e.g.manager_apply_tip;
    private static final int dyU = e.g.assist_apply_tip;
    private com.baidu.tbadk.coreExtra.view.a aJs;
    private View.OnClickListener mClickListener;

    public o(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.member.o.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Object tag = view.getTag(o.dyT);
                if (TbadkCoreApplication.isLogin() && StringUtils.isNull(TbadkCoreApplication.getCurrentAccountName())) {
                    o.this.i(TbadkCoreApplication.getCurrentAccountInfo());
                } else if (tag != null && !tag.toString().equals("")) {
                    ay.Db().c((TbPageContext) com.baidu.adp.base.i.aK(o.this.mContext), new String[]{tag.toString()});
                } else {
                    ay.Db().c((TbPageContext) com.baidu.adp.base.i.aK(o.this.mContext), new String[]{view.getTag(o.dyU).toString()});
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
                    al.j(qVar.atf, e.d.cp_bg_line_b);
                    al.c(qVar.dze, e.d.cp_cont_d, 1);
                    al.c(qVar.dzf, e.d.cp_cont_d, 1);
                    al.c(qVar.dzc, e.d.cp_cont_b, 1);
                    al.c(qVar.dzd, e.d.cp_cont_b, 1);
                    al.i(qVar.dzg, e.f.frs_member_manito_bg);
                    al.i(qVar.dzh, e.f.frs_member_manito_bg);
                }
                int axM = pVar.axM();
                if (axM == -1) {
                    int axL = pVar.axL();
                    String I = ao.I(axL);
                    if (axL > 0) {
                        qVar.dze.setText(String.format(this.mContext.getResources().getString(e.j.tbtitle_apply_left_num_tip), I));
                        qVar.dzg.setTag(dyT, pVar.axO());
                        qVar.dzg.setOnClickListener(this.mClickListener);
                        qVar.dzg.setEnabled(true);
                        qVar.dzg.setClickable(true);
                    } else {
                        qVar.dze.setText(this.mContext.getResources().getString(e.j.tbtitle_quota_is_full));
                        qVar.dzg.setTag(dyT, pVar.axO());
                        qVar.dzg.setOnClickListener(this.mClickListener);
                        qVar.dzg.setEnabled(false);
                        qVar.dzg.setClickable(false);
                    }
                } else if (axM == 0) {
                    qVar.dze.setText(this.mContext.getResources().getString(e.j.tbtitle_is_bazhu));
                    qVar.dzg.setTag(dyT, pVar.axO());
                    qVar.dzg.setOnClickListener(this.mClickListener);
                    qVar.dzg.setEnabled(true);
                    qVar.dzg.setClickable(true);
                } else if (axM == 1) {
                    qVar.dze.setText(this.mContext.getResources().getString(e.j.tbtitle_applying));
                    qVar.dzg.setTag(dyT, pVar.axO());
                    qVar.dzg.setOnClickListener(this.mClickListener);
                    qVar.dzg.setEnabled(true);
                    qVar.dzg.setClickable(true);
                } else if (axM == 2) {
                    qVar.dze.setText(this.mContext.getResources().getString(e.j.tbtitle_apply_failed));
                    qVar.dzg.setTag(dyT, pVar.axO());
                    qVar.dzg.setOnClickListener(this.mClickListener);
                    qVar.dzg.setEnabled(true);
                    qVar.dzg.setClickable(true);
                } else {
                    qVar.dze.setText(this.mContext.getResources().getString(e.j.tbtitle_quota_is_full));
                    qVar.dzg.setTag(dyT, pVar.axO());
                    qVar.dzg.setOnClickListener(this.mClickListener);
                    qVar.dzg.setEnabled(false);
                    qVar.dzg.setClickable(false);
                }
                int axN = pVar.axN();
                if (axN > 0) {
                    qVar.dzf.setText(String.format(this.mContext.getResources().getString(e.j.apply_left_num_tip), ao.I(axN)));
                    qVar.dzh.setTag(dyU, pVar.axP());
                    qVar.dzh.setOnClickListener(this.mClickListener);
                    qVar.dzh.setEnabled(true);
                    qVar.dzh.setClickable(true);
                } else {
                    qVar.dzf.setText(this.mContext.getResources().getString(e.j.apply_no_left_tip));
                    qVar.dzh.setEnabled(false);
                    qVar.dzh.setClickable(false);
                }
                qVar.dzf.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(e.f.icon_arrow_tab), (Drawable) null);
                qVar.dze.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(e.f.icon_arrow_tab), (Drawable) null);
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
        if (this.aJs == null) {
            this.aJs = new com.baidu.tbadk.coreExtra.view.a(activity);
        }
        this.aJs.Jq();
        this.aJs.setAccountData(accountData);
        this.aJs.fd(1);
    }

    public void onDestroy() {
        if (this.aJs != null) {
            this.aJs.onDestroy();
        }
    }
}
