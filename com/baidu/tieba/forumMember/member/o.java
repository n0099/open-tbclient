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
    private static final int cUL = d.g.manager_apply_tip;
    private static final int cUM = d.g.assist_apply_tip;
    private View.OnClickListener mClickListener;

    public o(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.member.o.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Object tag = view2.getTag(o.cUL);
                if (tag == null || tag.toString().equals("")) {
                    ax.wg().c((TbPageContext) com.baidu.adp.base.i.ab(o.this.mContext), new String[]{view2.getTag(o.cUM).toString()});
                } else {
                    ax.wg().c((TbPageContext) com.baidu.adp.base.i.ab(o.this.mContext), new String[]{tag.toString()});
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
                    ak.j(qVar.acO, d.C0126d.cp_bg_line_b);
                    ak.c(qVar.cUW, d.C0126d.cp_cont_d, 1);
                    ak.c(qVar.cUX, d.C0126d.cp_cont_d, 1);
                    ak.c(qVar.cUU, d.C0126d.cp_cont_b, 1);
                    ak.c(qVar.cUV, d.C0126d.cp_cont_b, 1);
                    ak.i(qVar.cUY, d.f.frs_member_manito_bg);
                    ak.i(qVar.cUZ, d.f.frs_member_manito_bg);
                }
                int aom = pVar.aom();
                if (aom == -1) {
                    int aol = pVar.aol();
                    String v = an.v(aol);
                    if (aol > 0) {
                        qVar.cUW.setText(String.format(this.mContext.getResources().getString(d.k.tbtitle_apply_left_num_tip), v));
                        qVar.cUY.setTag(cUL, pVar.aoo());
                        qVar.cUY.setOnClickListener(this.mClickListener);
                        qVar.cUY.setEnabled(true);
                        qVar.cUY.setClickable(true);
                    } else {
                        qVar.cUW.setText(this.mContext.getResources().getString(d.k.tbtitle_quota_is_full));
                        qVar.cUY.setTag(cUL, pVar.aoo());
                        qVar.cUY.setOnClickListener(this.mClickListener);
                        qVar.cUY.setEnabled(false);
                        qVar.cUY.setClickable(false);
                    }
                } else if (aom == 0) {
                    qVar.cUW.setText(this.mContext.getResources().getString(d.k.tbtitle_is_bazhu));
                    qVar.cUY.setTag(cUL, pVar.aoo());
                    qVar.cUY.setOnClickListener(this.mClickListener);
                    qVar.cUY.setEnabled(true);
                    qVar.cUY.setClickable(true);
                } else if (aom == 1) {
                    qVar.cUW.setText(this.mContext.getResources().getString(d.k.tbtitle_applying));
                    qVar.cUY.setTag(cUL, pVar.aoo());
                    qVar.cUY.setOnClickListener(this.mClickListener);
                    qVar.cUY.setEnabled(true);
                    qVar.cUY.setClickable(true);
                } else if (aom == 2) {
                    qVar.cUW.setText(this.mContext.getResources().getString(d.k.tbtitle_apply_failed));
                    qVar.cUY.setTag(cUL, pVar.aoo());
                    qVar.cUY.setOnClickListener(this.mClickListener);
                    qVar.cUY.setEnabled(true);
                    qVar.cUY.setClickable(true);
                } else {
                    qVar.cUW.setText(this.mContext.getResources().getString(d.k.tbtitle_quota_is_full));
                    qVar.cUY.setTag(cUL, pVar.aoo());
                    qVar.cUY.setOnClickListener(this.mClickListener);
                    qVar.cUY.setEnabled(false);
                    qVar.cUY.setClickable(false);
                }
                int aon = pVar.aon();
                if (aon > 0) {
                    qVar.cUX.setText(String.format(this.mContext.getResources().getString(d.k.apply_left_num_tip), an.v(aon)));
                    qVar.cUZ.setTag(cUM, pVar.aop());
                    qVar.cUZ.setOnClickListener(this.mClickListener);
                    qVar.cUZ.setEnabled(true);
                    qVar.cUZ.setClickable(true);
                } else {
                    qVar.cUX.setText(this.mContext.getResources().getString(d.k.apply_no_left_tip));
                    qVar.cUZ.setEnabled(false);
                    qVar.cUZ.setClickable(false);
                }
                qVar.cUX.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ak.getDrawable(d.f.icon_arrow_tab), (Drawable) null);
                qVar.cUW.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ak.getDrawable(d.f.icon_arrow_tab), (Drawable) null);
                qVar.mSkinType = this.mSkinType;
            }
        }
        return view2;
    }
}
