package com.baidu.tieba.frs.g;

import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.data.z;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.frs.at;
import com.baidu.tieba.frs.e.e;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class a extends at<bj, c> implements e {
    public a(BaseActivity baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
    }

    private View a(int i, View view, bj bjVar, c cVar) {
        String str;
        String str2;
        if (bjVar == null || !(bjVar instanceof z)) {
            return null;
        }
        if (this.mSkinType == 1) {
            aq.k(cVar.mRootView, w.e.cp_bg_line_d_1);
            aq.k(cVar.cgj, w.e.cp_bg_line_c_1);
            aq.i((View) cVar.cgm, w.e.cp_cont_e);
            aq.i((View) cVar.cgo, w.e.cp_cont_e);
            aq.i((View) cVar.cgl, w.e.cp_cont_b);
            aq.i((View) cVar.cgn, w.e.cp_cont_b);
            str = "#4f93ef";
        } else {
            aq.k(cVar.mRootView, w.e.cp_bg_line_d);
            aq.k(cVar.cgj, w.e.cp_bg_line_c);
            aq.i((View) cVar.cgm, w.e.common_color_10139);
            aq.i((View) cVar.cgo, w.e.common_color_10139);
            aq.i((View) cVar.cgl, w.e.cp_bg_line_k);
            aq.i((View) cVar.cgn, w.e.cp_bg_line_k);
            str = "#3385ff";
        }
        z zVar = (z) bjVar;
        String str3 = zVar.VH;
        if (!StringUtils.isNull(str3)) {
            cVar.cgk.setVisibility(0);
            cVar.bTG.setVisibility(8);
            cVar.cgk.setIsRound(true);
            cVar.cgk.setUserId(bjVar.getAuthor().getUserId());
            cVar.cgk.setImageDrawable(null);
            cVar.cgk.c(str3, 10, false);
        }
        cVar.cgl.setText(zVar.userName);
        cVar.cgm.setText(zVar.tips);
        if (StringUtils.isNull(zVar.type)) {
            str2 = zVar.title;
        } else {
            str2 = "<font color='" + str + "'>" + zVar.type + "·</font>" + zVar.title;
        }
        cVar.cgn.setText(Html.fromHtml(str2));
        cVar.cgo.setText(zVar.VI);
        if (zVar.pics != null) {
            int size = zVar.pics.size();
            if (size == 1) {
                cVar.cgu.setVisibility(0);
                cVar.cgp.setVisibility(8);
                cVar.cgq.setVisibility(8);
                cVar.cgr.setVisibility(8);
                cVar.cgs.setVisibility(8);
                cVar.cgt.setVisibility(8);
                cVar.cgu.c(zVar.pics.get(0), 10, false);
            } else if (size == 2) {
                cVar.cgu.setVisibility(8);
                cVar.cgp.setVisibility(8);
                cVar.cgq.setVisibility(8);
                cVar.cgr.setVisibility(8);
                cVar.cgs.setVisibility(0);
                cVar.cgt.setVisibility(8);
                cVar.cgE.c(zVar.pics.get(0), 10, false);
                cVar.cgF.c(zVar.pics.get(1), 10, false);
            } else if (size == 3) {
                cVar.cgu.setVisibility(8);
                cVar.cgp.setVisibility(0);
                cVar.cgq.setVisibility(8);
                cVar.cgr.setVisibility(8);
                cVar.cgs.setVisibility(8);
                cVar.cgt.setVisibility(8);
                cVar.cgv.c(zVar.pics.get(0), 10, false);
                cVar.cgw.c(zVar.pics.get(1), 10, false);
                cVar.cgx.c(zVar.pics.get(2), 10, false);
            } else if (size == 4) {
                cVar.cgu.setVisibility(8);
                cVar.cgp.setVisibility(8);
                cVar.cgq.setVisibility(8);
                cVar.cgr.setVisibility(8);
                cVar.cgs.setVisibility(0);
                cVar.cgt.setVisibility(0);
                cVar.cgE.c(zVar.pics.get(0), 10, false);
                cVar.cgF.c(zVar.pics.get(1), 10, false);
                cVar.cgG.c(zVar.pics.get(2), 10, false);
                cVar.cgH.c(zVar.pics.get(3), 10, false);
            } else if (size == 5) {
                cVar.cgu.setVisibility(8);
                cVar.cgp.setVisibility(0);
                cVar.cgq.setVisibility(8);
                cVar.cgr.setVisibility(8);
                cVar.cgs.setVisibility(0);
                cVar.cgt.setVisibility(8);
                cVar.cgE.c(zVar.pics.get(0), 10, false);
                cVar.cgF.c(zVar.pics.get(1), 10, false);
                cVar.cgv.c(zVar.pics.get(2), 10, false);
                cVar.cgw.c(zVar.pics.get(3), 10, false);
                cVar.cgx.c(zVar.pics.get(4), 10, false);
            } else if (size >= 6 && size < 9) {
                cVar.cgu.setVisibility(8);
                cVar.cgp.setVisibility(0);
                cVar.cgq.setVisibility(0);
                cVar.cgr.setVisibility(8);
                cVar.cgs.setVisibility(8);
                cVar.cgt.setVisibility(8);
                cVar.cgv.c(zVar.pics.get(0), 10, false);
                cVar.cgw.c(zVar.pics.get(1), 10, false);
                cVar.cgx.c(zVar.pics.get(2), 10, false);
                cVar.cgy.c(zVar.pics.get(3), 10, false);
                cVar.cgz.c(zVar.pics.get(4), 10, false);
                cVar.cgA.c(zVar.pics.get(5), 10, false);
            } else if (size >= 9) {
                cVar.cgu.setVisibility(8);
                cVar.cgp.setVisibility(0);
                cVar.cgq.setVisibility(0);
                cVar.cgr.setVisibility(0);
                cVar.cgs.setVisibility(8);
                cVar.cgt.setVisibility(8);
                cVar.cgv.c(zVar.pics.get(0), 10, false);
                cVar.cgw.c(zVar.pics.get(1), 10, false);
                cVar.cgx.c(zVar.pics.get(2), 10, false);
                cVar.cgy.c(zVar.pics.get(3), 10, false);
                cVar.cgz.c(zVar.pics.get(4), 10, false);
                cVar.cgA.c(zVar.pics.get(5), 10, false);
                cVar.cgB.c(zVar.pics.get(6), 10, false);
                cVar.cgC.c(zVar.pics.get(7), 10, false);
                cVar.cgD.c(zVar.pics.get(8), 10, false);
            }
        }
        cVar.mRootView.setOnClickListener(new b(this, zVar));
        return view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: R */
    public c onCreateViewHolder(ViewGroup viewGroup) {
        return new c(this.bcF, LayoutInflater.from(this.mContext).inflate(w.j.frs_wefan_item, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.at, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bj bjVar, c cVar) {
        super.onFillViewHolder(i, view, viewGroup, bjVar, cVar);
        return a(i, view, bjVar, cVar);
    }
}
