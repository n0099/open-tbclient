package com.baidu.tieba.frs.g;

import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.data.y;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.frs.at;
import com.baidu.tieba.frs.e.e;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class a extends at<bh, c> implements e {
    public a(BaseActivity baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
    }

    private View a(int i, View view, bh bhVar, c cVar) {
        String str;
        String str2;
        if (bhVar == null || !(bhVar instanceof y)) {
            return null;
        }
        if (this.mSkinType == 1) {
            ap.k(cVar.mRootView, r.e.cp_bg_line_d_1);
            ap.k(cVar.bYN, r.e.cp_bg_line_c_1);
            ap.i((View) cVar.bYQ, r.e.cp_cont_e);
            ap.i((View) cVar.bYS, r.e.cp_cont_e);
            ap.i((View) cVar.bYP, r.e.cp_cont_b);
            ap.i((View) cVar.bYR, r.e.cp_cont_b);
            str = "#4f93ef";
        } else {
            ap.k(cVar.mRootView, r.e.cp_bg_line_d);
            ap.k(cVar.bYN, r.e.cp_bg_line_c);
            ap.i((View) cVar.bYQ, r.e.common_color_10139);
            ap.i((View) cVar.bYS, r.e.common_color_10139);
            ap.i((View) cVar.bYP, r.e.cp_bg_line_k);
            ap.i((View) cVar.bYR, r.e.cp_bg_line_k);
            str = "#3385ff";
        }
        y yVar = (y) bhVar;
        String str3 = yVar.Qu;
        if (!StringUtils.isNull(str3)) {
            cVar.bYO.setVisibility(0);
            cVar.bMy.setVisibility(8);
            cVar.bYO.setIsRound(true);
            cVar.bYO.setUserId(bhVar.getAuthor().getUserId());
            cVar.bYO.setImageDrawable(null);
            cVar.bYO.c(str3, 10, false);
        }
        cVar.bYP.setText(yVar.userName);
        cVar.bYQ.setText(yVar.tips);
        if (StringUtils.isNull(yVar.type)) {
            str2 = yVar.title;
        } else {
            str2 = "<font color='" + str + "'>" + yVar.type + "·</font>" + yVar.title;
        }
        cVar.bYR.setText(Html.fromHtml(str2));
        cVar.bYS.setText(yVar.Qv);
        if (yVar.pics != null) {
            int size = yVar.pics.size();
            if (size == 1) {
                cVar.bYY.setVisibility(0);
                cVar.bYT.setVisibility(8);
                cVar.bYU.setVisibility(8);
                cVar.bYV.setVisibility(8);
                cVar.bYW.setVisibility(8);
                cVar.bYX.setVisibility(8);
                cVar.bYY.c(yVar.pics.get(0), 10, false);
            } else if (size == 2) {
                cVar.bYY.setVisibility(8);
                cVar.bYT.setVisibility(8);
                cVar.bYU.setVisibility(8);
                cVar.bYV.setVisibility(8);
                cVar.bYW.setVisibility(0);
                cVar.bYX.setVisibility(8);
                cVar.bZi.c(yVar.pics.get(0), 10, false);
                cVar.bZj.c(yVar.pics.get(1), 10, false);
            } else if (size == 3) {
                cVar.bYY.setVisibility(8);
                cVar.bYT.setVisibility(0);
                cVar.bYU.setVisibility(8);
                cVar.bYV.setVisibility(8);
                cVar.bYW.setVisibility(8);
                cVar.bYX.setVisibility(8);
                cVar.bYZ.c(yVar.pics.get(0), 10, false);
                cVar.bZa.c(yVar.pics.get(1), 10, false);
                cVar.bZb.c(yVar.pics.get(2), 10, false);
            } else if (size == 4) {
                cVar.bYY.setVisibility(8);
                cVar.bYT.setVisibility(8);
                cVar.bYU.setVisibility(8);
                cVar.bYV.setVisibility(8);
                cVar.bYW.setVisibility(0);
                cVar.bYX.setVisibility(0);
                cVar.bZi.c(yVar.pics.get(0), 10, false);
                cVar.bZj.c(yVar.pics.get(1), 10, false);
                cVar.bZk.c(yVar.pics.get(2), 10, false);
                cVar.bZl.c(yVar.pics.get(3), 10, false);
            } else if (size == 5) {
                cVar.bYY.setVisibility(8);
                cVar.bYT.setVisibility(0);
                cVar.bYU.setVisibility(8);
                cVar.bYV.setVisibility(8);
                cVar.bYW.setVisibility(0);
                cVar.bYX.setVisibility(8);
                cVar.bZi.c(yVar.pics.get(0), 10, false);
                cVar.bZj.c(yVar.pics.get(1), 10, false);
                cVar.bYZ.c(yVar.pics.get(2), 10, false);
                cVar.bZa.c(yVar.pics.get(3), 10, false);
                cVar.bZb.c(yVar.pics.get(4), 10, false);
            } else if (size >= 6 && size < 9) {
                cVar.bYY.setVisibility(8);
                cVar.bYT.setVisibility(0);
                cVar.bYU.setVisibility(0);
                cVar.bYV.setVisibility(8);
                cVar.bYW.setVisibility(8);
                cVar.bYX.setVisibility(8);
                cVar.bYZ.c(yVar.pics.get(0), 10, false);
                cVar.bZa.c(yVar.pics.get(1), 10, false);
                cVar.bZb.c(yVar.pics.get(2), 10, false);
                cVar.bZc.c(yVar.pics.get(3), 10, false);
                cVar.bZd.c(yVar.pics.get(4), 10, false);
                cVar.bZe.c(yVar.pics.get(5), 10, false);
            } else if (size >= 9) {
                cVar.bYY.setVisibility(8);
                cVar.bYT.setVisibility(0);
                cVar.bYU.setVisibility(0);
                cVar.bYV.setVisibility(0);
                cVar.bYW.setVisibility(8);
                cVar.bYX.setVisibility(8);
                cVar.bYZ.c(yVar.pics.get(0), 10, false);
                cVar.bZa.c(yVar.pics.get(1), 10, false);
                cVar.bZb.c(yVar.pics.get(2), 10, false);
                cVar.bZc.c(yVar.pics.get(3), 10, false);
                cVar.bZd.c(yVar.pics.get(4), 10, false);
                cVar.bZe.c(yVar.pics.get(5), 10, false);
                cVar.bZf.c(yVar.pics.get(6), 10, false);
                cVar.bZg.c(yVar.pics.get(7), 10, false);
                cVar.bZh.c(yVar.pics.get(8), 10, false);
            }
        }
        cVar.mRootView.setOnClickListener(new b(this, yVar));
        return view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: R */
    public c onCreateViewHolder(ViewGroup viewGroup) {
        return new c(this.aWr, LayoutInflater.from(this.mContext).inflate(r.j.frs_wefan_item, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.at, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bh bhVar, c cVar) {
        super.onFillViewHolder(i, view, viewGroup, bhVar, cVar);
        return a(i, view, bhVar, cVar);
    }
}
