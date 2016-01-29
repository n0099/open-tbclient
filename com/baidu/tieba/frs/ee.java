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
public class ee extends bv<com.baidu.tbadk.core.data.ah, ej> implements View.OnClickListener {
    private BaseActivity bdK;
    private View.OnClickListener bkj;
    private Set<String> bll;

    /* JADX INFO: Access modifiers changed from: protected */
    public ee(BaseActivity baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
        this.bkj = new ef(this);
        this.bdK = baseActivity;
        this.bll = new HashSet();
    }

    private View a(int i, View view, com.baidu.tbadk.core.data.ah ahVar, ej ejVar) {
        int i2;
        if (ahVar == null) {
            return null;
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(0, 0, 0, 0);
        layoutParams.gravity = 1;
        ejVar.beP.setLayoutParams(layoutParams);
        cg.a(this.bdK, ejVar.bkl, ejVar.beU, ejVar.beT, ejVar.bkq, ejVar.bkr, ejVar.bko, ejVar.bkp, view, ahVar, this.mSkinType, new eg(this, ahVar), this.bhx);
        if (ejVar.ahU != this.mSkinType) {
            com.baidu.tbadk.core.util.ar.k(ejVar.beP, t.f.frs_item_control_btn_bg);
            this.bdK.getLayoutMode().ac(this.mSkinType == 1);
            this.bdK.getLayoutMode().x(view);
        }
        if (ahVar != null && !ahVar.tF() && !TextUtils.isEmpty(ahVar.getAddress()) && !TextUtils.isEmpty(ahVar.getAddress().trim())) {
            ejVar.biV.setVisibility(0);
            ejVar.bks.setVisibility(0);
            ejVar.biV.setText(ahVar.getAddress());
        } else {
            ejVar.biV.setVisibility(8);
            ejVar.bks.setVisibility(8);
        }
        ejVar.ahm.setText(com.baidu.tbadk.core.util.aw.t(ahVar.getLast_time_int() * 1000));
        if (com.baidu.tbadk.core.l.rn().rp()) {
            ejVar.beU.setVisibility(0);
            String portrait = ahVar.getAuthor().getPortrait();
            ejVar.beU.setUserId(ahVar.getAuthor().getUserId());
            ejVar.beU.setImageDrawable(null);
            ejVar.beU.d(portrait, 28, false);
        } else {
            ejVar.beU.setVisibility(8);
        }
        ejVar.beU.setOnClickListener(new eh(this, ahVar));
        ArrayList<IconData> iconInfo = ahVar.getAuthor().getIconInfo();
        if (iconInfo != null && iconInfo.size() > 0) {
            ejVar.ahJ.setVisibility(0);
            com.baidu.tbadk.core.util.ar.b(ejVar.beT, t.d.cp_cont_h, 1);
            ejVar.ahJ.setTag(Integer.valueOf(i));
            ejVar.ahJ.setOnClickListener(this);
            ejVar.ahJ.a(iconInfo, 3, this.mContext.getResources().getDimensionPixelSize(t.e.ds30), this.mContext.getResources().getDimensionPixelSize(t.e.ds30), this.mContext.getResources().getDimensionPixelSize(t.e.ds10), true);
            ejVar.ahJ.setOnClickListener(this.bkj);
        } else {
            ejVar.ahJ.setVisibility(8);
            com.baidu.tbadk.core.util.ar.b(ejVar.beT, t.d.cp_cont_c, 1);
        }
        ArrayList<IconData> tShowInfoNew = ahVar.getAuthor().getTShowInfoNew();
        if (tShowInfoNew != null && tShowInfoNew.size() > 0) {
            ejVar.ahI.setVisibility(0);
            com.baidu.tbadk.core.util.ar.b(ejVar.beT, t.d.cp_cont_h, 1);
            ejVar.ahI.setTag(Integer.valueOf(i));
            ejVar.ahI.setOnClickListener(this);
            ejVar.ahI.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(t.e.ds36), this.mContext.getResources().getDimensionPixelSize(t.e.small_icon_height), this.mContext.getResources().getDimensionPixelSize(t.e.small_icon_margin), true);
        } else {
            ejVar.ahI.setVisibility(8);
            com.baidu.tbadk.core.util.ar.b(ejVar.beT, t.d.cp_cont_c, 1);
        }
        ejVar.beT.setText(ahVar.getAuthor().getName_show());
        com.baidu.tieba.tbadkCore.util.r readThreadHistory = TbadkCoreApplication.m411getInst().getReadThreadHistory();
        if (ahVar.tx() == 1) {
            ejVar.aPr.setVisibility(8);
        } else {
            ejVar.aPr.setVisibility(0);
            ahVar.parser_title();
            ejVar.aPr.setText(ahVar.getSpan_str());
            if (readThreadHistory != null && readThreadHistory.mU(ahVar.getId())) {
                com.baidu.tbadk.core.util.ar.b(ejVar.aPr, t.d.cp_cont_c, 1);
            } else {
                com.baidu.tbadk.core.util.ar.b(ejVar.aPr, t.d.cp_cont_b, 1);
            }
        }
        String tr = ahVar.tr();
        if (!StringUtils.isNull(tr)) {
            ejVar.beQ.setText(tr);
            ejVar.beQ.setVisibility(0);
            if (readThreadHistory != null && readThreadHistory.mU(ahVar.getId())) {
                com.baidu.tbadk.core.util.ar.b(ejVar.beQ, t.d.cp_cont_c, 1);
            } else {
                com.baidu.tbadk.core.util.ar.b(ejVar.beQ, t.d.cp_cont_b, 1);
            }
        } else {
            ejVar.beQ.setVisibility(8);
        }
        com.baidu.tbadk.core.data.af te = ahVar.te();
        if (te != null) {
            if (this.bll.add(te.getTaskId())) {
                com.baidu.tieba.tbadkCore.d.a.a("frs", null, "VIEW_TRUE", te.getForumId(), te.getForumName(), te.getThreadId(), null, null);
            }
        }
        if (com.baidu.tbadk.core.l.rn().rt() && te != null && !StringUtils.isNull(te.tb())) {
            ejVar.blo.setVisibility(0);
            ejVar.blo.setSupportNoImage(true);
            ejVar.blo.setScaleType(ImageView.ScaleType.CENTER_CROP);
            ejVar.blo.d(te.tb(), this.mIsFromCDN ? 13 : 14, false);
            int K = com.baidu.adp.lib.util.k.K(this.mContext);
            float td = te.td() / te.tc();
            if (td > 1.0f) {
                i2 = (int) (1.0f * K);
            } else if (td < 0.2f) {
                i2 = (int) (K * 0.2f);
            } else {
                i2 = (int) (K * td);
            }
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) ejVar.blo.getLayoutParams();
            layoutParams2.height = i2;
            layoutParams2.width = K;
            ejVar.blo.setLayoutParams(layoutParams2);
        } else {
            ejVar.blo.setVisibility(8);
        }
        if (com.baidu.tbadk.core.l.rn().rt()) {
            int K2 = com.baidu.adp.lib.util.k.K(this.mContext);
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) ejVar.blp.getLayoutParams();
            layoutParams3.width = K2;
            layoutParams3.height = (int) (K2 / 9.0f);
            ejVar.blp.setScaleType(ImageView.ScaleType.CENTER_CROP);
            ejVar.blp.setLayoutParams(layoutParams3);
            String ta = te.ta();
            if (!StringUtils.isNull(ta)) {
                TbImageView tbImageView = ejVar.blp;
                ejVar.blp.setImageDrawable(null);
                ejVar.blp.reset();
                ejVar.blp.setEvent(new ei(this, tbImageView));
                ejVar.blp.d(ta, this.mIsFromCDN ? 13 : 14, false);
            } else {
                ejVar.blp.reset();
                ejVar.blp.setImageResource(t.f.pic_interview_top);
            }
            ejVar.blp.setVisibility(0);
            ((LinearLayout.LayoutParams) ejVar.bkl.getLayoutParams()).topMargin = com.baidu.adp.lib.util.k.c(this.bdK.getActivity(), t.e.ds20);
        } else {
            ((LinearLayout.LayoutParams) ejVar.bkl.getLayoutParams()).topMargin = com.baidu.adp.lib.util.k.c(this.bdK.getActivity(), t.e.ds24);
            ejVar.blp.setVisibility(8);
        }
        if (ahVar.getPraise() != null && ahVar.getPraise().getNum() > 0) {
            ejVar.ahn.setVisibility(0);
            ejVar.ahn.setText(com.baidu.tbadk.core.util.aw.y(ahVar.getPraise().getNum()));
        } else {
            ejVar.ahn.setVisibility(8);
        }
        int reply_num = ahVar.getReply_num();
        if (reply_num > 0) {
            ejVar.beY.setVisibility(0);
            ejVar.beY.setText(com.baidu.tbadk.core.util.aw.y(reply_num));
        } else {
            ejVar.beY.setVisibility(8);
        }
        ejVar.ahU = this.mSkinType;
        return view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bim != null && view != null) {
            int id = view.getId();
            Object tag = view.getTag();
            if (tag instanceof Integer) {
                int intValue = ((Integer) tag).intValue();
                com.baidu.adp.widget.ListView.u aG = aG(intValue);
                if (aG instanceof com.baidu.tbadk.core.data.ah) {
                    View childAt = this.beF.getChildAt(intValue - (this.beF.getFirstVisiblePosition() - this.beF.getHeaderViewsCount()));
                    this.bim.a(id, intValue, view, childAt, (com.baidu.tbadk.core.data.ah) aG);
                }
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: C */
    public ej b(ViewGroup viewGroup) {
        this.beF = (ListView) viewGroup;
        return new ej(LayoutInflater.from(this.mContext).inflate(t.h.frs_star_interview_item, (ViewGroup) null), this.beC);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bv, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.ah ahVar, ej ejVar) {
        super.a(i, view, viewGroup, (ViewGroup) ahVar, (com.baidu.tbadk.core.data.ah) ejVar);
        return a(i, view, ahVar, ejVar);
    }

    @Override // com.baidu.tieba.frs.bv
    public void release() {
        super.release();
        this.bll.clear();
    }
}
