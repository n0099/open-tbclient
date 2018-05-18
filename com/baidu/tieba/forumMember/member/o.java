package com.baidu.tieba.forumMember.member;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class o extends com.baidu.tieba.frs.f<p, q> {
    private static final int cVP = d.g.manager_apply_tip;
    private static final int cVQ = d.g.assist_apply_tip;
    private View.OnClickListener mClickListener;

    public o(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.member.o.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Object tag = view2.getTag(o.cVP);
                if (tag == null || tag.toString().equals("")) {
                    ax.wf().c((TbPageContext) com.baidu.adp.base.i.ab(o.this.mContext), new String[]{view2.getTag(o.cVQ).toString()});
                } else {
                    ax.wf().c((TbPageContext) com.baidu.adp.base.i.ab(o.this.mContext), new String[]{tag.toString()});
                }
            }
        };
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: an */
    public q onCreateViewHolder(ViewGroup viewGroup) {
        return new q(LayoutInflater.from(this.mContext).inflate(d.i.frs_member_manager_apply, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.f, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, p pVar, q qVar) {
        super.onFillViewHolder(i, view2, viewGroup, pVar, qVar);
        if (pVar != null && !pVar.isEmpty() && qVar != null) {
            if (pVar.isEmpty()) {
                qVar.mRootLayout.setVisibility(8);
            } else {
                if (qVar.mSkinType != this.mSkinType) {
                    ak.j(qVar.acP, d.C0126d.cp_bg_line_b);
                    ak.c(qVar.cWa, d.C0126d.cp_cont_d, 1);
                    ak.c(qVar.cWb, d.C0126d.cp_cont_d, 1);
                    ak.c(qVar.cVY, d.C0126d.cp_cont_b, 1);
                    ak.c(qVar.cVZ, d.C0126d.cp_cont_b, 1);
                    ak.i(qVar.cWc, d.f.frs_member_manito_bg);
                    ak.i(qVar.cWd, d.f.frs_member_manito_bg);
                }
                int aol = pVar.aol();
                if (aol == -1) {
                    int aok = pVar.aok();
                    String v = an.v(aok);
                    if (aok > 0) {
                        qVar.cWa.setText(String.format(this.mContext.getResources().getString(d.k.tbtitle_apply_left_num_tip), v));
                        qVar.cWc.setTag(cVP, pVar.aon());
                        qVar.cWc.setOnClickListener(this.mClickListener);
                        qVar.cWc.setEnabled(true);
                        qVar.cWc.setClickable(true);
                    } else {
                        qVar.cWa.setText(this.mContext.getResources().getString(d.k.tbtitle_quota_is_full));
                        qVar.cWc.setTag(cVP, pVar.aon());
                        qVar.cWc.setOnClickListener(this.mClickListener);
                        qVar.cWc.setEnabled(false);
                        qVar.cWc.setClickable(false);
                    }
                } else if (aol == 0) {
                    qVar.cWa.setText(this.mContext.getResources().getString(d.k.tbtitle_is_bazhu));
                    qVar.cWc.setTag(cVP, pVar.aon());
                    qVar.cWc.setOnClickListener(this.mClickListener);
                    qVar.cWc.setEnabled(true);
                    qVar.cWc.setClickable(true);
                } else if (aol == 1) {
                    qVar.cWa.setText(this.mContext.getResources().getString(d.k.tbtitle_applying));
                    qVar.cWc.setTag(cVP, pVar.aon());
                    qVar.cWc.setOnClickListener(this.mClickListener);
                    qVar.cWc.setEnabled(true);
                    qVar.cWc.setClickable(true);
                } else if (aol == 2) {
                    qVar.cWa.setText(this.mContext.getResources().getString(d.k.tbtitle_apply_failed));
                    qVar.cWc.setTag(cVP, pVar.aon());
                    qVar.cWc.setOnClickListener(this.mClickListener);
                    qVar.cWc.setEnabled(true);
                    qVar.cWc.setClickable(true);
                } else {
                    qVar.cWa.setText(this.mContext.getResources().getString(d.k.tbtitle_quota_is_full));
                    qVar.cWc.setTag(cVP, pVar.aon());
                    qVar.cWc.setOnClickListener(this.mClickListener);
                    qVar.cWc.setEnabled(false);
                    qVar.cWc.setClickable(false);
                }
                int aom = pVar.aom();
                if (aom > 0) {
                    qVar.cWb.setText(String.format(this.mContext.getResources().getString(d.k.apply_left_num_tip), an.v(aom)));
                    qVar.cWd.setTag(cVQ, pVar.aoo());
                    qVar.cWd.setOnClickListener(this.mClickListener);
                    qVar.cWd.setEnabled(true);
                    qVar.cWd.setClickable(true);
                } else {
                    qVar.cWb.setText(this.mContext.getResources().getString(d.k.apply_no_left_tip));
                    qVar.cWd.setEnabled(false);
                    qVar.cWd.setClickable(false);
                }
                qVar.cWb.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ak.getDrawable(d.f.icon_arrow_tab), (Drawable) null);
                qVar.cWa.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ak.getDrawable(d.f.icon_arrow_tab), (Drawable) null);
                qVar.mSkinType = this.mSkinType;
            }
        }
        return view2;
    }
}
