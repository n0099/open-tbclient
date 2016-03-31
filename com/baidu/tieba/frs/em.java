package com.baidu.tieba.frs;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes.dex */
public class em extends bx<com.baidu.tbadk.core.data.as, er> implements View.OnClickListener {
    private BaseActivity bix;
    private View.OnClickListener bpv;
    private Set<String> bqD;

    /* JADX INFO: Access modifiers changed from: protected */
    public em(BaseActivity baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
        this.bpv = new en(this);
        this.bix = baseActivity;
        this.bqD = new HashSet();
    }

    private View a(int i, View view, com.baidu.tbadk.core.data.as asVar, er erVar) {
        int i2;
        if (asVar == null) {
            return null;
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(0, 0, 0, 0);
        layoutParams.gravity = 1;
        erVar.bjB.setLayoutParams(layoutParams);
        ci.a(this.bix, erVar.bpA, erVar.bjG, erVar.bjF, erVar.bpF, erVar.bpG, erVar.bpD, erVar.bpE, view, asVar, this.mSkinType, new eo(this, asVar), this.bmj);
        if (erVar.aik != this.mSkinType) {
            com.baidu.tbadk.core.util.at.k(erVar.bjB, t.f.frs_item_control_btn_bg);
            this.bix.getLayoutMode().ab(this.mSkinType == 1);
            this.bix.getLayoutMode().x(view);
        }
        if (asVar != null && !asVar.tJ() && !TextUtils.isEmpty(asVar.getAddress()) && !TextUtils.isEmpty(asVar.getAddress().trim())) {
            erVar.bnF.setVisibility(0);
            erVar.bpH.setVisibility(0);
            erVar.bnF.setText(asVar.getAddress());
        } else {
            erVar.bnF.setVisibility(8);
            erVar.bpH.setVisibility(8);
        }
        erVar.ahr.setText(com.baidu.tbadk.core.util.ay.w(asVar.getLast_time_int() * 1000));
        if (com.baidu.tbadk.core.l.qE().qG()) {
            erVar.bjG.setVisibility(0);
            String portrait = asVar.getAuthor().getPortrait();
            erVar.bjG.setUserId(asVar.getAuthor().getUserId());
            erVar.bjG.setImageDrawable(null);
            erVar.bjG.c(portrait, 28, false);
        } else {
            erVar.bjG.setVisibility(8);
        }
        erVar.bjG.setOnClickListener(new ep(this, asVar));
        ArrayList<IconData> iconInfo = asVar.getAuthor().getIconInfo();
        if (iconInfo != null && iconInfo.size() > 0) {
            erVar.ahO.setVisibility(0);
            com.baidu.tbadk.core.util.at.b(erVar.bjF, t.d.cp_cont_h, 1);
            erVar.ahO.setTag(Integer.valueOf(i));
            erVar.ahO.setOnClickListener(this);
            erVar.ahO.a(iconInfo, 3, this.mContext.getResources().getDimensionPixelSize(t.e.ds30), this.mContext.getResources().getDimensionPixelSize(t.e.ds30), this.mContext.getResources().getDimensionPixelSize(t.e.ds10), true);
            erVar.ahO.setOnClickListener(this.bpv);
        } else {
            erVar.ahO.setVisibility(8);
            com.baidu.tbadk.core.util.at.b(erVar.bjF, t.d.cp_cont_c, 1);
        }
        ArrayList<IconData> tShowInfoNew = asVar.getAuthor().getTShowInfoNew();
        if (tShowInfoNew != null && tShowInfoNew.size() > 0) {
            erVar.ahN.setVisibility(0);
            com.baidu.tbadk.core.util.at.b(erVar.bjF, t.d.cp_cont_h, 1);
            erVar.ahN.setTag(Integer.valueOf(i));
            erVar.ahN.setOnClickListener(this);
            erVar.ahN.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(t.e.ds36), this.mContext.getResources().getDimensionPixelSize(t.e.small_icon_height), this.mContext.getResources().getDimensionPixelSize(t.e.small_icon_margin), true);
        } else {
            erVar.ahN.setVisibility(8);
            com.baidu.tbadk.core.util.at.b(erVar.bjF, t.d.cp_cont_c, 1);
        }
        erVar.bjF.setText(asVar.getAuthor().getName_show());
        com.baidu.tieba.tbadkCore.util.s readThreadHistory = TbadkCoreApplication.m411getInst().getReadThreadHistory();
        if (asVar.tA() == 1) {
            erVar.aSh.setVisibility(8);
        } else {
            erVar.aSh.setVisibility(0);
            asVar.parser_title();
            erVar.aSh.setText(asVar.getSpan_str());
            if (readThreadHistory != null && readThreadHistory.oh(asVar.getId())) {
                com.baidu.tbadk.core.util.at.b(erVar.aSh, t.d.cp_cont_c, 1);
            } else {
                com.baidu.tbadk.core.util.at.b(erVar.aSh, t.d.cp_cont_b, 1);
            }
        }
        String tu = asVar.tu();
        if (!StringUtils.isNull(tu)) {
            erVar.bjC.setText(tu);
            erVar.bjC.setVisibility(0);
            if (readThreadHistory != null && readThreadHistory.oh(asVar.getId())) {
                com.baidu.tbadk.core.util.at.b(erVar.bjC, t.d.cp_cont_c, 1);
            } else {
                com.baidu.tbadk.core.util.at.b(erVar.bjC, t.d.cp_cont_b, 1);
            }
        } else {
            erVar.bjC.setVisibility(8);
        }
        com.baidu.tbadk.core.data.aq tg = asVar.tg();
        if (tg != null) {
            String taskId = tg.getTaskId();
            String tf = tg.tf();
            if (StringUtils.isNull(tf)) {
                tf = tg.getTaskId();
            }
            if (this.bqD.add(taskId)) {
                com.baidu.tieba.tbadkCore.d.a.a("frs", null, "VIEW_TRUE", tg.getForumId(), tg.getForumName(), tg.getThreadId(), null, "tieba.baidu.com/p/" + asVar.getTid(), tf);
            }
        }
        if (com.baidu.tbadk.core.l.qE().qK() && tg != null && !StringUtils.isNull(tg.tc())) {
            erVar.bqG.setVisibility(0);
            erVar.bqG.setSupportNoImage(true);
            erVar.bqG.setScaleType(ImageView.ScaleType.CENTER_CROP);
            erVar.bqG.c(tg.tc(), this.mIsFromCDN ? 13 : 14, false);
            int B = com.baidu.adp.lib.util.k.B(this.mContext);
            float te = tg.te() / tg.td();
            if (te > 1.0f) {
                i2 = (int) (1.0f * B);
            } else if (te < 0.2f) {
                i2 = (int) (B * 0.2f);
            } else {
                i2 = (int) (B * te);
            }
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) erVar.bqG.getLayoutParams();
            layoutParams2.height = i2;
            layoutParams2.width = B;
            erVar.bqG.setLayoutParams(layoutParams2);
        } else {
            erVar.bqG.setVisibility(8);
        }
        if (com.baidu.tbadk.core.l.qE().qK()) {
            int B2 = com.baidu.adp.lib.util.k.B(this.mContext);
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) erVar.bqH.getLayoutParams();
            layoutParams3.width = B2;
            layoutParams3.height = (int) (B2 / 9.0f);
            erVar.bqH.setScaleType(ImageView.ScaleType.CENTER_CROP);
            erVar.bqH.setLayoutParams(layoutParams3);
            String tb = tg.tb();
            if (!StringUtils.isNull(tb)) {
                TbImageView tbImageView = erVar.bqH;
                erVar.bqH.setImageDrawable(null);
                erVar.bqH.reset();
                erVar.bqH.setEvent(new eq(this, tbImageView));
                erVar.bqH.c(tb, this.mIsFromCDN ? 13 : 14, false);
            } else {
                erVar.bqH.reset();
                erVar.bqH.setImageResource(t.f.pic_interview_top);
            }
            erVar.bqH.setVisibility(0);
            ((LinearLayout.LayoutParams) erVar.bpA.getLayoutParams()).topMargin = com.baidu.adp.lib.util.k.c(this.bix.getActivity(), t.e.ds20);
        } else {
            ((LinearLayout.LayoutParams) erVar.bpA.getLayoutParams()).topMargin = com.baidu.adp.lib.util.k.c(this.bix.getActivity(), t.e.ds24);
            erVar.bqH.setVisibility(8);
        }
        if (asVar.getPraise() != null && asVar.getPraise().getNum() > 0) {
            erVar.ahs.setVisibility(0);
            erVar.ahs.setText(com.baidu.tbadk.core.util.ay.A(asVar.getPraise().getNum()));
        } else {
            erVar.ahs.setVisibility(8);
        }
        com.baidu.tieba.graffiti.d.af(erVar.ahs);
        int reply_num = asVar.getReply_num();
        if (reply_num > 0) {
            erVar.bjK.setVisibility(0);
            erVar.bjK.setText(com.baidu.tbadk.core.util.ay.A(reply_num));
        } else {
            erVar.bjK.setVisibility(8);
        }
        erVar.aik = this.mSkinType;
        return view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bmX != null && view != null) {
            int id = view.getId();
            Object tag = view.getTag();
            if (tag instanceof Integer) {
                int intValue = ((Integer) tag).intValue();
                com.baidu.adp.widget.ListView.u aF = aF(intValue);
                if (aF instanceof com.baidu.tbadk.core.data.as) {
                    View childAt = this.bjr.getChildAt(intValue - (this.bjr.getFirstVisiblePosition() - this.bjr.getHeaderViewsCount()));
                    this.bmX.a(id, intValue, view, childAt, (com.baidu.tbadk.core.data.as) aF);
                }
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: E */
    public er b(ViewGroup viewGroup) {
        this.bjr = (ListView) viewGroup;
        return new er(LayoutInflater.from(this.mContext).inflate(t.h.frs_star_interview_item, (ViewGroup) null), this.bjo);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bx, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.as asVar, er erVar) {
        super.a(i, view, viewGroup, (ViewGroup) asVar, (com.baidu.tbadk.core.data.as) erVar);
        return a(i, view, asVar, erVar);
    }

    @Override // com.baidu.tieba.frs.bx
    public void release() {
        super.release();
        this.bqD.clear();
    }
}
