package com.baidu.tieba.forumMember.member;

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
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class o extends com.baidu.tieba.frs.f<p, q> {
    private static final int dfb = d.g.manager_apply_tip;
    private static final int dfc = d.g.assist_apply_tip;
    private com.baidu.tbadk.coreExtra.view.a aAl;
    private View.OnClickListener mClickListener;

    public o(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.member.o.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Object tag = view.getTag(o.dfb);
                if (TbadkCoreApplication.isLogin() && StringUtils.isNull(TbadkCoreApplication.getCurrentAccountName())) {
                    o.this.j(TbadkCoreApplication.getCurrentAccountInfo());
                } else if (tag == null || tag.toString().equals("")) {
                    ay.zG().c((TbPageContext) com.baidu.adp.base.i.ad(o.this.mContext), new String[]{view.getTag(o.dfc).toString()});
                } else {
                    ay.zG().c((TbPageContext) com.baidu.adp.base.i.ad(o.this.mContext), new String[]{tag.toString()});
                }
            }
        };
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: am */
    public q onCreateViewHolder(ViewGroup viewGroup) {
        return new q(LayoutInflater.from(this.mContext).inflate(d.i.frs_member_manager_apply, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.f, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, p pVar, q qVar) {
        super.onFillViewHolder(i, view, viewGroup, pVar, qVar);
        if (pVar != null && !pVar.isEmpty() && qVar != null) {
            if (pVar.isEmpty()) {
                qVar.mRootLayout.setVisibility(8);
            } else {
                if (qVar.mSkinType != this.mSkinType) {
                    al.j(qVar.akT, d.C0141d.cp_bg_line_b);
                    al.c(qVar.dfm, d.C0141d.cp_cont_d, 1);
                    al.c(qVar.dfn, d.C0141d.cp_cont_d, 1);
                    al.c(qVar.dfk, d.C0141d.cp_cont_b, 1);
                    al.c(qVar.dfl, d.C0141d.cp_cont_b, 1);
                    al.i(qVar.dfo, d.f.frs_member_manito_bg);
                    al.i(qVar.dfp, d.f.frs_member_manito_bg);
                }
                int asq = pVar.asq();
                if (asq == -1) {
                    int asp = pVar.asp();
                    String y = ao.y(asp);
                    if (asp > 0) {
                        qVar.dfm.setText(String.format(this.mContext.getResources().getString(d.k.tbtitle_apply_left_num_tip), y));
                        qVar.dfo.setTag(dfb, pVar.ass());
                        qVar.dfo.setOnClickListener(this.mClickListener);
                        qVar.dfo.setEnabled(true);
                        qVar.dfo.setClickable(true);
                    } else {
                        qVar.dfm.setText(this.mContext.getResources().getString(d.k.tbtitle_quota_is_full));
                        qVar.dfo.setTag(dfb, pVar.ass());
                        qVar.dfo.setOnClickListener(this.mClickListener);
                        qVar.dfo.setEnabled(false);
                        qVar.dfo.setClickable(false);
                    }
                } else if (asq == 0) {
                    qVar.dfm.setText(this.mContext.getResources().getString(d.k.tbtitle_is_bazhu));
                    qVar.dfo.setTag(dfb, pVar.ass());
                    qVar.dfo.setOnClickListener(this.mClickListener);
                    qVar.dfo.setEnabled(true);
                    qVar.dfo.setClickable(true);
                } else if (asq == 1) {
                    qVar.dfm.setText(this.mContext.getResources().getString(d.k.tbtitle_applying));
                    qVar.dfo.setTag(dfb, pVar.ass());
                    qVar.dfo.setOnClickListener(this.mClickListener);
                    qVar.dfo.setEnabled(true);
                    qVar.dfo.setClickable(true);
                } else if (asq == 2) {
                    qVar.dfm.setText(this.mContext.getResources().getString(d.k.tbtitle_apply_failed));
                    qVar.dfo.setTag(dfb, pVar.ass());
                    qVar.dfo.setOnClickListener(this.mClickListener);
                    qVar.dfo.setEnabled(true);
                    qVar.dfo.setClickable(true);
                } else {
                    qVar.dfm.setText(this.mContext.getResources().getString(d.k.tbtitle_quota_is_full));
                    qVar.dfo.setTag(dfb, pVar.ass());
                    qVar.dfo.setOnClickListener(this.mClickListener);
                    qVar.dfo.setEnabled(false);
                    qVar.dfo.setClickable(false);
                }
                int asr = pVar.asr();
                if (asr > 0) {
                    qVar.dfn.setText(String.format(this.mContext.getResources().getString(d.k.apply_left_num_tip), ao.y(asr)));
                    qVar.dfp.setTag(dfc, pVar.ast());
                    qVar.dfp.setOnClickListener(this.mClickListener);
                    qVar.dfp.setEnabled(true);
                    qVar.dfp.setClickable(true);
                } else {
                    qVar.dfn.setText(this.mContext.getResources().getString(d.k.apply_no_left_tip));
                    qVar.dfp.setEnabled(false);
                    qVar.dfp.setClickable(false);
                }
                qVar.dfn.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(d.f.icon_arrow_tab), (Drawable) null);
                qVar.dfm.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(d.f.icon_arrow_tab), (Drawable) null);
                qVar.mSkinType = this.mSkinType;
            }
        }
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(AccountData accountData) {
        if (this.aAl == null) {
            this.aAl = new com.baidu.tbadk.coreExtra.view.a((TbPageContext) com.baidu.adp.base.i.ad(this.mContext));
        }
        this.aAl.Fz();
        this.aAl.i(accountData);
        this.aAl.er(1);
    }

    public void onDestroy() {
        if (this.aAl != null) {
            this.aAl.onDestroy();
        }
    }
}
