package com.baidu.tieba.frs.h;

import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.data.z;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.frs.av;
import com.baidu.tieba.frs.e.e;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class a extends av<bi, c> implements e {
    public a(BaseActivity baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
    }

    private View a(int i, View view, bi biVar, c cVar) {
        String str;
        String str2;
        if (biVar == null || !(biVar instanceof z)) {
            return null;
        }
        if (this.mSkinType == 1) {
            aq.k(cVar.mRootView, w.e.cp_bg_line_d_1);
            aq.k(cVar.cha, w.e.cp_bg_line_c_1);
            aq.i(cVar.chd, w.e.cp_cont_e);
            aq.i(cVar.chf, w.e.cp_cont_e);
            aq.i(cVar.chc, w.e.cp_cont_b);
            aq.i(cVar.che, w.e.cp_cont_b);
            str = "#4f93ef";
        } else {
            aq.k(cVar.mRootView, w.e.cp_bg_line_d);
            aq.k(cVar.cha, w.e.cp_bg_line_c);
            aq.i(cVar.chd, w.e.common_color_10139);
            aq.i(cVar.chf, w.e.common_color_10139);
            aq.i(cVar.chc, w.e.cp_bg_line_k);
            aq.i(cVar.che, w.e.cp_bg_line_k);
            str = "#3385ff";
        }
        z zVar = (z) biVar;
        String str3 = zVar.Wa;
        if (!StringUtils.isNull(str3)) {
            cVar.chb.setVisibility(0);
            cVar.bVL.setVisibility(8);
            cVar.chb.setIsRound(true);
            cVar.chb.setUserId(biVar.getAuthor().getUserId());
            cVar.chb.setImageDrawable(null);
            cVar.chb.c(str3, 10, false);
        }
        cVar.chc.setText(zVar.userName);
        cVar.chd.setText(zVar.tips);
        if (StringUtils.isNull(zVar.type)) {
            str2 = zVar.title;
        } else {
            str2 = "<font color='" + str + "'>" + zVar.type + "·</font>" + zVar.title;
        }
        cVar.che.setText(Html.fromHtml(str2));
        cVar.chf.setText(zVar.Wb);
        if (zVar.pics != null) {
            int size = zVar.pics.size();
            if (size == 1) {
                cVar.chl.setVisibility(0);
                cVar.chg.setVisibility(8);
                cVar.chh.setVisibility(8);
                cVar.chi.setVisibility(8);
                cVar.chj.setVisibility(8);
                cVar.chk.setVisibility(8);
                cVar.chl.c(zVar.pics.get(0), 10, false);
            } else if (size == 2) {
                cVar.chl.setVisibility(8);
                cVar.chg.setVisibility(8);
                cVar.chh.setVisibility(8);
                cVar.chi.setVisibility(8);
                cVar.chj.setVisibility(0);
                cVar.chk.setVisibility(8);
                cVar.chv.c(zVar.pics.get(0), 10, false);
                cVar.chw.c(zVar.pics.get(1), 10, false);
            } else if (size == 3) {
                cVar.chl.setVisibility(8);
                cVar.chg.setVisibility(0);
                cVar.chh.setVisibility(8);
                cVar.chi.setVisibility(8);
                cVar.chj.setVisibility(8);
                cVar.chk.setVisibility(8);
                cVar.chm.c(zVar.pics.get(0), 10, false);
                cVar.chn.c(zVar.pics.get(1), 10, false);
                cVar.cho.c(zVar.pics.get(2), 10, false);
            } else if (size == 4) {
                cVar.chl.setVisibility(8);
                cVar.chg.setVisibility(8);
                cVar.chh.setVisibility(8);
                cVar.chi.setVisibility(8);
                cVar.chj.setVisibility(0);
                cVar.chk.setVisibility(0);
                cVar.chv.c(zVar.pics.get(0), 10, false);
                cVar.chw.c(zVar.pics.get(1), 10, false);
                cVar.chx.c(zVar.pics.get(2), 10, false);
                cVar.chy.c(zVar.pics.get(3), 10, false);
            } else if (size == 5) {
                cVar.chl.setVisibility(8);
                cVar.chg.setVisibility(0);
                cVar.chh.setVisibility(8);
                cVar.chi.setVisibility(8);
                cVar.chj.setVisibility(0);
                cVar.chk.setVisibility(8);
                cVar.chv.c(zVar.pics.get(0), 10, false);
                cVar.chw.c(zVar.pics.get(1), 10, false);
                cVar.chm.c(zVar.pics.get(2), 10, false);
                cVar.chn.c(zVar.pics.get(3), 10, false);
                cVar.cho.c(zVar.pics.get(4), 10, false);
            } else if (size >= 6 && size < 9) {
                cVar.chl.setVisibility(8);
                cVar.chg.setVisibility(0);
                cVar.chh.setVisibility(0);
                cVar.chi.setVisibility(8);
                cVar.chj.setVisibility(8);
                cVar.chk.setVisibility(8);
                cVar.chm.c(zVar.pics.get(0), 10, false);
                cVar.chn.c(zVar.pics.get(1), 10, false);
                cVar.cho.c(zVar.pics.get(2), 10, false);
                cVar.chp.c(zVar.pics.get(3), 10, false);
                cVar.chq.c(zVar.pics.get(4), 10, false);
                cVar.chr.c(zVar.pics.get(5), 10, false);
            } else if (size >= 9) {
                cVar.chl.setVisibility(8);
                cVar.chg.setVisibility(0);
                cVar.chh.setVisibility(0);
                cVar.chi.setVisibility(0);
                cVar.chj.setVisibility(8);
                cVar.chk.setVisibility(8);
                cVar.chm.c(zVar.pics.get(0), 10, false);
                cVar.chn.c(zVar.pics.get(1), 10, false);
                cVar.cho.c(zVar.pics.get(2), 10, false);
                cVar.chp.c(zVar.pics.get(3), 10, false);
                cVar.chq.c(zVar.pics.get(4), 10, false);
                cVar.chr.c(zVar.pics.get(5), 10, false);
                cVar.chs.c(zVar.pics.get(6), 10, false);
                cVar.cht.c(zVar.pics.get(7), 10, false);
                cVar.chu.c(zVar.pics.get(8), 10, false);
            }
        }
        cVar.mRootView.setOnClickListener(new b(this, zVar));
        return view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: S */
    public c onCreateViewHolder(ViewGroup viewGroup) {
        return new c(this.bdG, LayoutInflater.from(this.mContext).inflate(w.j.frs_wefan_item, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.av, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bi biVar, c cVar) {
        super.onFillViewHolder(i, view, viewGroup, biVar, cVar);
        return a(i, view, biVar, cVar);
    }
}
