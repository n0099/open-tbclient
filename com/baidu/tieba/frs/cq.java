package com.baidu.tieba.frs;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.t;
import java.text.SimpleDateFormat;
import java.util.Date;
/* loaded from: classes.dex */
public class cq extends bx<com.baidu.tbadk.core.data.as, cr> {
    /* JADX INFO: Access modifiers changed from: protected */
    public cq(BaseActivity baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
    }

    private View a(int i, View view, com.baidu.tbadk.core.data.as asVar, cr crVar) {
        int tH;
        if (asVar == null || asVar.tw() == null || asVar.tw().get(0) == null || (tH = asVar.tH()) == -1) {
            return null;
        }
        if (crVar.mSkinType != this.mSkinType) {
            com.baidu.tbadk.core.util.at.k(crVar.bor, t.f.frs_item_control_btn_bg);
            this.bix.getLayoutMode().ab(this.mSkinType == 1);
            this.bix.getLayoutMode().x(view);
            com.baidu.tbadk.core.util.at.j((View) crVar.bog, t.d.cp_cont_b);
            com.baidu.tbadk.core.util.at.k(crVar.boq, t.f.bg_frs_item_cp_bg_line_e_selector);
            com.baidu.tbadk.core.util.at.j((View) crVar.boi, t.d.cp_cont_c);
            com.baidu.tbadk.core.util.at.j((View) crVar.boj, t.d.cp_cont_c);
        }
        com.baidu.tbadk.core.data.a aVar = asVar.tw().get(0);
        if (!StringUtils.isNull(aVar.rb())) {
            if (com.baidu.adp.lib.g.c.hr().ah(10)) {
                crVar.bof.c(aVar.rb(), 10, false);
                crVar.bof.setVisibility(0);
            } else {
                crVar.bof.setVisibility(8);
            }
        } else {
            crVar.bof.setVisibility(8);
        }
        crVar.bog.setText(asVar.getSpan_str());
        if (asVar.getMedias() != null && asVar.getMedias().get(0) != null) {
            if (com.baidu.adp.lib.g.c.hr().ah(10)) {
                crVar.boh.c(asVar.getMedias().get(0).getPicUrl(), 10, false);
                crVar.boh.setVisibility(0);
            } else {
                crVar.boh.setVisibility(8);
            }
        } else {
            crVar.boh.setVisibility(8);
        }
        if (tH == 4) {
            if (crVar.boo != null) {
                crVar.boo.setVisibility(8);
            }
            if (StringUtils.isNull(asVar.tu())) {
                crVar.boi.setText("【】");
            } else {
                crVar.boi.setText(asVar.tu());
            }
            crVar.boj.setText(this.bix.getResources().getString(t.j.time_before_lottery));
            long qV = (aVar.qV() * 1000) - System.currentTimeMillis();
            if (crVar.bop == null) {
                crVar.bop = (FrsLotteryCountDownView) crVar.bol.inflate();
            }
            crVar.bop.setVisibility(0);
            crVar.bop.setData(qV);
        } else {
            if (crVar.bop != null) {
                crVar.bop.setVisibility(8);
            }
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd");
            crVar.boi.setText(StringUtils.string(this.bix.getResources().getString(t.j.lottery_time), "  ", simpleDateFormat.format(new Date(aVar.qV() * 1000)), "-", simpleDateFormat.format(new Date(aVar.qW() * 1000))));
            crVar.boj.setText(this.bix.getResources().getString(t.j.lottery_join_num));
            if (crVar.boo == null) {
                crVar.boo = (VerticalScrollNumberView) crVar.bom.inflate();
            }
            crVar.boo.setVisibility(0);
            crVar.boo.setData(aVar.rc());
        }
        int reply_num = asVar.getReply_num();
        if (reply_num > 0) {
            crVar.bok.setVisibility(0);
            crVar.bok.setText(com.baidu.tbadk.core.util.ay.A(reply_num));
        } else {
            crVar.bok.setVisibility(8);
        }
        if (tH == 1) {
            crVar.bon.setText(TbadkCoreApplication.m411getInst().getResources().getString(t.j.join_immediately));
        } else {
            crVar.bon.setText(TbadkCoreApplication.m411getInst().getResources().getString(t.j.check_detail));
        }
        crVar.mSkinType = this.mSkinType;
        return view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: v */
    public cr b(ViewGroup viewGroup) {
        return new cr(LayoutInflater.from(this.mContext).inflate(t.h.frs_item_lottery, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bx, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.as asVar, cr crVar) {
        super.a(i, view, viewGroup, (ViewGroup) asVar, (com.baidu.tbadk.core.data.as) crVar);
        return a(i, view, asVar, crVar);
    }
}
