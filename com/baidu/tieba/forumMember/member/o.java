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
    private static final int dBW = d.g.manager_apply_tip;
    private static final int dBX = d.g.assist_apply_tip;
    private View.OnClickListener mClickListener;

    public o(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.member.o.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Object tag = view.getTag(o.dBW);
                if (tag == null || tag.toString().equals("")) {
                    aw.Dt().c((TbPageContext) com.baidu.adp.base.i.ak(o.this.mContext), new String[]{view.getTag(o.dBX).toString()});
                } else {
                    aw.Dt().c((TbPageContext) com.baidu.adp.base.i.ak(o.this.mContext), new String[]{tag.toString()});
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
                    aj.t(qVar.aRq, d.C0141d.cp_bg_line_b);
                    aj.e(qVar.dCh, d.C0141d.cp_cont_d, 1);
                    aj.e(qVar.dCi, d.C0141d.cp_cont_d, 1);
                    aj.e(qVar.dCf, d.C0141d.cp_cont_b, 1);
                    aj.e(qVar.dCg, d.C0141d.cp_cont_b, 1);
                    aj.s(qVar.dCj, d.f.frs_member_manito_bg);
                    aj.s(qVar.dCk, d.f.frs_member_manito_bg);
                }
                int atW = pVar.atW();
                if (atW == -1) {
                    int atV = pVar.atV();
                    String C = am.C(atV);
                    if (atV > 0) {
                        qVar.dCh.setText(String.format(this.mContext.getResources().getString(d.j.tbtitle_apply_left_num_tip), C));
                        qVar.dCj.setTag(dBW, pVar.atY());
                        qVar.dCj.setOnClickListener(this.mClickListener);
                        qVar.dCj.setEnabled(true);
                        qVar.dCj.setClickable(true);
                    } else {
                        qVar.dCh.setText(this.mContext.getResources().getString(d.j.tbtitle_quota_is_full));
                        qVar.dCj.setTag(dBW, pVar.atY());
                        qVar.dCj.setOnClickListener(this.mClickListener);
                        qVar.dCj.setEnabled(false);
                        qVar.dCj.setClickable(false);
                    }
                } else if (atW == 0) {
                    qVar.dCh.setText(this.mContext.getResources().getString(d.j.tbtitle_is_bazhu));
                    qVar.dCj.setTag(dBW, pVar.atY());
                    qVar.dCj.setOnClickListener(this.mClickListener);
                    qVar.dCj.setEnabled(true);
                    qVar.dCj.setClickable(true);
                } else if (atW == 1) {
                    qVar.dCh.setText(this.mContext.getResources().getString(d.j.tbtitle_applying));
                    qVar.dCj.setTag(dBW, pVar.atY());
                    qVar.dCj.setOnClickListener(this.mClickListener);
                    qVar.dCj.setEnabled(true);
                    qVar.dCj.setClickable(true);
                } else if (atW == 2) {
                    qVar.dCh.setText(this.mContext.getResources().getString(d.j.tbtitle_apply_failed));
                    qVar.dCj.setTag(dBW, pVar.atY());
                    qVar.dCj.setOnClickListener(this.mClickListener);
                    qVar.dCj.setEnabled(true);
                    qVar.dCj.setClickable(true);
                } else {
                    qVar.dCh.setText(this.mContext.getResources().getString(d.j.tbtitle_quota_is_full));
                    qVar.dCj.setTag(dBW, pVar.atY());
                    qVar.dCj.setOnClickListener(this.mClickListener);
                    qVar.dCj.setEnabled(false);
                    qVar.dCj.setClickable(false);
                }
                int atX = pVar.atX();
                if (atX > 0) {
                    qVar.dCi.setText(String.format(this.mContext.getResources().getString(d.j.apply_left_num_tip), am.C(atX)));
                    qVar.dCk.setTag(dBX, pVar.atZ());
                    qVar.dCk.setOnClickListener(this.mClickListener);
                    qVar.dCk.setEnabled(true);
                    qVar.dCk.setClickable(true);
                } else {
                    qVar.dCi.setText(this.mContext.getResources().getString(d.j.apply_no_left_tip));
                    qVar.dCk.setEnabled(false);
                    qVar.dCk.setClickable(false);
                }
                qVar.dCi.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, aj.getDrawable(d.f.icon_arrow_tab), (Drawable) null);
                qVar.dCh.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, aj.getDrawable(d.f.icon_arrow_tab), (Drawable) null);
                qVar.mSkinType = this.mSkinType;
            }
        }
        return view;
    }
}
