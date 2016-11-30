package com.baidu.tieba.frs.k;

import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.data.y;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.frs.aq;
import com.baidu.tieba.frs.h.e;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class a extends aq<bk, c> implements e {
    public a(BaseActivity baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
    }

    private View a(int i, View view, bk bkVar, c cVar) {
        String str;
        String str2;
        if (bkVar == null || !(bkVar instanceof y)) {
            return null;
        }
        if (this.mSkinType == 1) {
            at.l(cVar.mRootView, r.d.cp_bg_line_d_1);
            at.l(cVar.cnf, r.d.cp_bg_line_c_1);
            at.j((View) cVar.cnh, r.d.cp_cont_e);
            at.j((View) cVar.cnj, r.d.cp_cont_e);
            at.j((View) cVar.bCV, r.d.cp_cont_b);
            at.j((View) cVar.cni, r.d.cp_cont_b);
            str = "#4f93ef";
        } else {
            at.l(cVar.mRootView, r.d.cp_bg_line_d);
            at.l(cVar.cnf, r.d.cp_bg_line_c);
            at.j((View) cVar.cnh, r.d.common_color_10139);
            at.j((View) cVar.cnj, r.d.common_color_10139);
            at.j((View) cVar.bCV, r.d.cp_bg_line_k);
            at.j((View) cVar.cni, r.d.cp_bg_line_k);
            str = "#3385ff";
        }
        y yVar = (y) bkVar;
        String str3 = yVar.Ro;
        if (!StringUtils.isNull(str3)) {
            cVar.cng.setVisibility(0);
            cVar.caA.setVisibility(8);
            cVar.cng.setIsRound(true);
            cVar.cng.setUserId(bkVar.getAuthor().getUserId());
            cVar.cng.setImageDrawable(null);
            cVar.cng.c(str3, 10, false);
        }
        cVar.bCV.setText(yVar.userName);
        cVar.cnh.setText(yVar.tips);
        if (StringUtils.isNull(yVar.type)) {
            str2 = yVar.title;
        } else {
            str2 = "<font color='" + str + "'>" + yVar.type + "·</font>" + yVar.title;
        }
        cVar.cni.setText(Html.fromHtml(str2));
        cVar.cnj.setText(yVar.Rp);
        if (yVar.pics != null) {
            int size = yVar.pics.size();
            if (size == 1) {
                cVar.cnp.setVisibility(0);
                cVar.cnk.setVisibility(8);
                cVar.cnl.setVisibility(8);
                cVar.cnm.setVisibility(8);
                cVar.cnn.setVisibility(8);
                cVar.cno.setVisibility(8);
                cVar.cnp.c(yVar.pics.get(0), 10, false);
            } else if (size == 2) {
                cVar.cnp.setVisibility(8);
                cVar.cnk.setVisibility(8);
                cVar.cnl.setVisibility(8);
                cVar.cnm.setVisibility(8);
                cVar.cnn.setVisibility(0);
                cVar.cno.setVisibility(8);
                cVar.cnA.c(yVar.pics.get(0), 10, false);
                cVar.cnB.c(yVar.pics.get(1), 10, false);
            } else if (size == 3) {
                cVar.cnp.setVisibility(8);
                cVar.cnk.setVisibility(0);
                cVar.cnl.setVisibility(8);
                cVar.cnm.setVisibility(8);
                cVar.cnn.setVisibility(8);
                cVar.cno.setVisibility(8);
                cVar.cnq.c(yVar.pics.get(0), 10, false);
                cVar.cnr.c(yVar.pics.get(1), 10, false);
                cVar.cns.c(yVar.pics.get(2), 10, false);
            } else if (size == 4) {
                cVar.cnp.setVisibility(8);
                cVar.cnk.setVisibility(8);
                cVar.cnl.setVisibility(8);
                cVar.cnm.setVisibility(8);
                cVar.cnn.setVisibility(0);
                cVar.cno.setVisibility(0);
                cVar.cnA.c(yVar.pics.get(0), 10, false);
                cVar.cnB.c(yVar.pics.get(1), 10, false);
                cVar.cnC.c(yVar.pics.get(2), 10, false);
                cVar.cnD.c(yVar.pics.get(3), 10, false);
            } else if (size == 5) {
                cVar.cnp.setVisibility(8);
                cVar.cnk.setVisibility(0);
                cVar.cnl.setVisibility(8);
                cVar.cnm.setVisibility(8);
                cVar.cnn.setVisibility(0);
                cVar.cno.setVisibility(8);
                cVar.cnA.c(yVar.pics.get(0), 10, false);
                cVar.cnB.c(yVar.pics.get(1), 10, false);
                cVar.cnq.c(yVar.pics.get(2), 10, false);
                cVar.cnr.c(yVar.pics.get(3), 10, false);
                cVar.cns.c(yVar.pics.get(4), 10, false);
            } else if (size >= 6 && size < 9) {
                cVar.cnp.setVisibility(8);
                cVar.cnk.setVisibility(0);
                cVar.cnl.setVisibility(0);
                cVar.cnm.setVisibility(8);
                cVar.cnn.setVisibility(8);
                cVar.cno.setVisibility(8);
                cVar.cnq.c(yVar.pics.get(0), 10, false);
                cVar.cnr.c(yVar.pics.get(1), 10, false);
                cVar.cns.c(yVar.pics.get(2), 10, false);
                cVar.cnu.c(yVar.pics.get(3), 10, false);
                cVar.cnv.c(yVar.pics.get(4), 10, false);
                cVar.cnw.c(yVar.pics.get(5), 10, false);
            } else if (size >= 9) {
                cVar.cnp.setVisibility(8);
                cVar.cnk.setVisibility(0);
                cVar.cnl.setVisibility(0);
                cVar.cnm.setVisibility(0);
                cVar.cnn.setVisibility(8);
                cVar.cno.setVisibility(8);
                cVar.cnq.c(yVar.pics.get(0), 10, false);
                cVar.cnr.c(yVar.pics.get(1), 10, false);
                cVar.cns.c(yVar.pics.get(2), 10, false);
                cVar.cnu.c(yVar.pics.get(3), 10, false);
                cVar.cnv.c(yVar.pics.get(4), 10, false);
                cVar.cnw.c(yVar.pics.get(5), 10, false);
                cVar.cnx.c(yVar.pics.get(6), 10, false);
                cVar.cny.c(yVar.pics.get(7), 10, false);
                cVar.cnz.c(yVar.pics.get(8), 10, false);
            }
        }
        cVar.mRootView.setOnClickListener(new b(this, yVar));
        return view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ac */
    public c a(ViewGroup viewGroup) {
        return new c(this.aTb, LayoutInflater.from(this.mContext).inflate(r.h.frs_wefan_item, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.aq, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bk bkVar, c cVar) {
        super.a(i, view, viewGroup, (ViewGroup) bkVar, (bk) cVar);
        return a(i, view, bkVar, cVar);
    }
}
