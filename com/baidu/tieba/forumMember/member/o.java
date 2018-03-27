package com.baidu.tieba.forumMember.member;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class o extends com.baidu.tieba.frs.g<p, q> {
    private static final int dBZ = d.g.manager_apply_tip;
    private static final int dCa = d.g.assist_apply_tip;
    private View.OnClickListener mClickListener;

    public o(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.member.o.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Object tag = view.getTag(o.dBZ);
                if (tag == null || tag.toString().equals("")) {
                    aw.Du().c((TbPageContext) com.baidu.adp.base.i.ak(o.this.mContext), new String[]{view.getTag(o.dCa).toString()});
                } else {
                    aw.Du().c((TbPageContext) com.baidu.adp.base.i.ak(o.this.mContext), new String[]{tag.toString()});
                }
            }
        };
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aq */
    public q onCreateViewHolder(ViewGroup viewGroup) {
        return new q(LayoutInflater.from(this.mContext).inflate(d.h.frs_member_manager_apply, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.g, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, p pVar, q qVar) {
        super.onFillViewHolder(i, view, viewGroup, pVar, qVar);
        if (pVar != null && !pVar.isEmpty() && qVar != null) {
            if (pVar.isEmpty()) {
                qVar.mRootLayout.setVisibility(8);
            } else {
                if (qVar.mSkinType != this.mSkinType) {
                    aj.t(qVar.aRs, d.C0141d.cp_bg_line_b);
                    aj.e(qVar.dCk, d.C0141d.cp_cont_d, 1);
                    aj.e(qVar.dCl, d.C0141d.cp_cont_d, 1);
                    aj.e(qVar.dCi, d.C0141d.cp_cont_b, 1);
                    aj.e(qVar.dCj, d.C0141d.cp_cont_b, 1);
                    aj.s(qVar.dCm, d.f.frs_member_manito_bg);
                    aj.s(qVar.dCn, d.f.frs_member_manito_bg);
                }
                int atX = pVar.atX();
                if (atX == -1) {
                    int atW = pVar.atW();
                    String C = am.C(atW);
                    if (atW > 0) {
                        qVar.dCk.setText(String.format(this.mContext.getResources().getString(d.j.tbtitle_apply_left_num_tip), C));
                        qVar.dCm.setTag(dBZ, pVar.atZ());
                        qVar.dCm.setOnClickListener(this.mClickListener);
                        qVar.dCm.setEnabled(true);
                        qVar.dCm.setClickable(true);
                    } else {
                        qVar.dCk.setText(this.mContext.getResources().getString(d.j.tbtitle_quota_is_full));
                        qVar.dCm.setTag(dBZ, pVar.atZ());
                        qVar.dCm.setOnClickListener(this.mClickListener);
                        qVar.dCm.setEnabled(false);
                        qVar.dCm.setClickable(false);
                    }
                } else if (atX == 0) {
                    qVar.dCk.setText(this.mContext.getResources().getString(d.j.tbtitle_is_bazhu));
                    qVar.dCm.setTag(dBZ, pVar.atZ());
                    qVar.dCm.setOnClickListener(this.mClickListener);
                    qVar.dCm.setEnabled(true);
                    qVar.dCm.setClickable(true);
                } else if (atX == 1) {
                    qVar.dCk.setText(this.mContext.getResources().getString(d.j.tbtitle_applying));
                    qVar.dCm.setTag(dBZ, pVar.atZ());
                    qVar.dCm.setOnClickListener(this.mClickListener);
                    qVar.dCm.setEnabled(true);
                    qVar.dCm.setClickable(true);
                } else if (atX == 2) {
                    qVar.dCk.setText(this.mContext.getResources().getString(d.j.tbtitle_apply_failed));
                    qVar.dCm.setTag(dBZ, pVar.atZ());
                    qVar.dCm.setOnClickListener(this.mClickListener);
                    qVar.dCm.setEnabled(true);
                    qVar.dCm.setClickable(true);
                } else {
                    qVar.dCk.setText(this.mContext.getResources().getString(d.j.tbtitle_quota_is_full));
                    qVar.dCm.setTag(dBZ, pVar.atZ());
                    qVar.dCm.setOnClickListener(this.mClickListener);
                    qVar.dCm.setEnabled(false);
                    qVar.dCm.setClickable(false);
                }
                int atY = pVar.atY();
                if (atY > 0) {
                    qVar.dCl.setText(String.format(this.mContext.getResources().getString(d.j.apply_left_num_tip), am.C(atY)));
                    qVar.dCn.setTag(dCa, pVar.aua());
                    qVar.dCn.setOnClickListener(this.mClickListener);
                    qVar.dCn.setEnabled(true);
                    qVar.dCn.setClickable(true);
                } else {
                    qVar.dCl.setText(this.mContext.getResources().getString(d.j.apply_no_left_tip));
                    qVar.dCn.setEnabled(false);
                    qVar.dCn.setClickable(false);
                }
                qVar.dCl.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, aj.getDrawable(d.f.icon_arrow_tab), (Drawable) null);
                qVar.dCk.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, aj.getDrawable(d.f.icon_arrow_tab), (Drawable) null);
                qVar.mSkinType = this.mSkinType;
            }
        }
        return view;
    }
}
