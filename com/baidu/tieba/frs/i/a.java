package com.baidu.tieba.frs.i;

import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.data.bn;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.data.IconData;
import com.baidu.tieba.card.an;
import com.baidu.tieba.frs.aq;
import com.baidu.tieba.frs.h.e;
import com.baidu.tieba.r;
import com.baidu.tieba.view.g;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
/* loaded from: classes.dex */
public class a extends aq<bk, d> implements e {
    private BaseActivity aTb;
    private View.OnClickListener bXu;
    private bn cia;
    private int cib;
    private View.OnClickListener cic;

    public a(BaseActivity baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
        this.bXu = new b(this);
        this.cic = new c(this);
        this.aTb = baseActivity;
        this.cib = ((WindowManager) this.aTb.getSystemService("window")).getDefaultDisplay().getWidth() - this.aTb.getResources().getDimensionPixelSize(r.e.ds162);
    }

    private View a(int i, View view, bk bkVar, d dVar) {
        if (bkVar == null || bkVar.rA() == null) {
            return null;
        }
        bkVar.sN();
        if (dVar.mSkinType != this.mSkinType) {
            at.k(dVar.cdW, r.f.frs_item_control_btn_bg);
            at.k(dVar.cif, r.f.pb_togetherhi_content_selector);
            if (dVar.Xf != null) {
                at.l(dVar.Xf, r.d.cp_bg_line_c);
            }
            at.l(dVar.civ, r.d.common_color_10082);
            at.l(dVar.cim, r.d.cp_bg_line_c);
            at.c(dVar.cio, r.d.cp_link_tip_a, 1);
            at.c(dVar.cip, r.d.cp_cont_c, 1);
            at.c(dVar.ciq, r.d.cp_cont_c, 1);
            at.c(dVar.cir, r.d.cp_cont_b, 1);
            at.c(dVar.cis, r.d.cp_cont_c, 1);
            at.c(dVar.cit, r.d.cp_cont_c, 1);
            at.c(dVar.livingTag, r.d.cp_cont_g, 1);
            at.c(dVar.ciw, r.d.cp_cont_g, 1);
            at.c(dVar.cix, r.d.cp_cont_g, 1);
            at.c(dVar.location, r.d.cp_cont_g, 1);
            this.aTb.getLayoutMode().ai(this.mSkinType == 1);
            this.aTb.getLayoutMode().x(view);
        }
        String str = "";
        String str2 = "";
        if (bkVar.getAuthor() != null) {
            str = bkVar.getAuthor().getPortrait();
            if (bkVar.getAuthor().getPendantData() != null) {
                str2 = bkVar.getAuthor().getPendantData().pR();
            }
        }
        if (!StringUtils.isNull(str2)) {
            dVar.cih.setVisibility(4);
            dVar.cii.setVisibility(0);
            dVar.cii.dZ(str2);
            dVar.cii.getHeadView().c(str, 28, false);
        } else if (!TextUtils.isEmpty(str)) {
            dVar.cih.setVisibility(0);
            dVar.cii.setVisibility(8);
            dVar.cih.setIsRound(true);
            dVar.cih.setUserId(bkVar.getAuthor().getUserId());
            dVar.cih.setImageDrawable(null);
            dVar.cih.c(str, 28, false);
        }
        if (!StringUtils.isNull(bkVar.getAuthor().getSealPrefix())) {
            dVar.aYg.setText(ag(bkVar.getAuthor().getSealPrefix(), bkVar.getAuthor().getUserName()));
        } else {
            dVar.aYg.setText(bkVar.getAuthor().getUserName());
        }
        ArrayList<IconData> tShowInfoNew = bkVar.getAuthor().getTShowInfoNew();
        if (tShowInfoNew != null && tShowInfoNew.size() > 0) {
            dVar.cik.setVisibility(0);
            dVar.cik.setTag(Integer.valueOf(i));
            dVar.cik.setOnClickListener(this.bXu);
            dVar.cik.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(r.e.ds32), this.mContext.getResources().getDimensionPixelSize(r.e.ds32), this.mContext.getResources().getDimensionPixelSize(r.e.ds8), true);
        } else {
            dVar.cik.setVisibility(8);
        }
        if (!bkVar.st() && !TextUtils.isEmpty(bkVar.getAddress()) && !TextUtils.isEmpty(bkVar.getAddress().trim())) {
            dVar.cim.setVisibility(0);
            dVar.cin.setVisibility(0);
            dVar.cin.setText(bkVar.getAddress());
        } else {
            dVar.cim.setVisibility(8);
            dVar.cin.setVisibility(8);
        }
        com.baidu.tieba.tbadkCore.util.r readThreadHistory = TbadkCoreApplication.m9getInst().getReadThreadHistory();
        if (bkVar.sd() == 1) {
            dVar.cij.setVisibility(8);
        } else {
            dVar.cij.setVisibility(0);
            bkVar.sw();
            dVar.cij.setMovementMethod(g.bti());
            dVar.cij.setText(an.c(this.aTb.getActivity(), bkVar.so(), r.j.card_promotion_text));
            if (readThreadHistory != null && readThreadHistory.rP(bkVar.getId())) {
                at.c(dVar.cij, r.d.cp_cont_c, 1);
            } else {
                at.c(dVar.cij, r.d.cp_cont_b, 1);
            }
        }
        StringBuffer stringBuffer = new StringBuffer();
        if (bkVar.rW() != null && bkVar.rW().trim().length() > 0) {
            stringBuffer.append(bkVar.rW());
        }
        ArrayList<MediaData> rY = bkVar.rY();
        if (rY != null) {
            StringBuffer stringBuffer2 = new StringBuffer();
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= rY.size()) {
                    break;
                }
                if (rY.get(i3).getVideoUrl() != null && rY.get(i3).getVideoUrl().endsWith("swf")) {
                    stringBuffer2.append(rY.get(i3).getVideoUrl());
                }
                i2 = i3 + 1;
            }
            stringBuffer.append(stringBuffer2.toString());
            if (!TextUtils.isEmpty(bkVar.g(stringBuffer.toString(), true))) {
                if (stringBuffer.length() > 170) {
                    dVar.cil.setText(String.format("%s...", stringBuffer.toString().substring(0, 170)));
                } else {
                    dVar.cil.setText(stringBuffer.toString());
                }
                dVar.cil.setVisibility(0);
                if (readThreadHistory != null && readThreadHistory.rP(bkVar.getId())) {
                    at.c(dVar.cil, r.d.cp_cont_c, 1);
                } else {
                    at.c(dVar.cil, r.d.cp_cont_b, 1);
                }
            } else {
                dVar.cil.setVisibility(8);
            }
        }
        int rJ = bkVar.rJ();
        if (rJ > 0 && this.mContext != null) {
            dVar.ciA.setVisibility(0);
            dVar.ciA.setText(String.valueOf(this.mContext.getString(r.j.comment)) + " " + ax.v(rJ));
            at.j((View) dVar.ciA, r.d.cp_cont_e);
        } else {
            dVar.ciA.setVisibility(8);
        }
        if (com.baidu.tieba.graffiti.d.ak(dVar.ciz) && bkVar.rH() != null && bkVar.rH().getNum() > 0) {
            dVar.ciz.setVisibility(0);
            String y = ax.y(bkVar.rH().getNum());
            dVar.ciz.setText(y);
            dVar.ciz.setContentDescription(String.valueOf(this.aTb.getResources().getString(r.j.zan_num)) + y);
        } else {
            dVar.ciz.setVisibility(8);
        }
        dVar.ciy.setText(ax.s(bkVar.rK() * 1000));
        this.cia = bkVar.rA();
        if (this.cia.sW() == 1) {
            dVar.cif.setVisibility(0);
            dVar.cif.setTag(Integer.valueOf(i));
            dVar.cif.setOnClickListener(this.cic);
            dVar.cig.setVisibility(8);
            dVar.cio.setText(this.cia.getActivityName());
            if (TextUtils.isEmpty(this.cia.getLocation())) {
                dVar.cip.setVisibility(8);
            } else {
                dVar.cip.setVisibility(0);
                dVar.cip.setText(this.cia.getLocation());
            }
            dVar.ciq.setText(new SimpleDateFormat("MM月dd日 HH:mm", Locale.CHINA).format(new Date(this.cia.getStartTime() * 1000)));
            dVar.cir.setText(String.valueOf(this.cia.sU()));
            dVar.ciu.setPortraitList(this.cia.sV());
            return view;
        }
        dVar.cif.setVisibility(8);
        dVar.cig.setVisibility(0);
        dVar.cig.setTag(Integer.valueOf(i));
        dVar.cig.setOnClickListener(this.cic);
        if (this.cia.sW() == 2) {
            dVar.livingTag.setVisibility(0);
        } else {
            dVar.livingTag.setVisibility(8);
        }
        List<String> sR = this.cia.sR();
        int size = sR == null ? 0 : sR.size();
        if (sR != null && size > 0) {
            dVar.image1.a(sR.get(0), 13, this.cib, this.cib, false);
        } else {
            dVar.image1.a(null, 13, this.cib, this.cib, false);
        }
        if (sR != null && size > 1) {
            dVar.image2.a(sR.get(1), 13, this.cib, this.cib, false);
        } else {
            dVar.image2.a(null, 13, this.cib, this.cib, false);
        }
        if (sR != null && size > 2) {
            dVar.image3.a(sR.get(2), 13, this.cib, this.cib, false);
        } else {
            dVar.image3.a(null, 13, this.cib, this.cib, false);
        }
        if (sR != null && size > 3) {
            dVar.image4.a(sR.get(3), 13, this.cib, this.cib, false);
        } else {
            dVar.image4.a(null, 13, this.cib, this.cib, false);
        }
        dVar.ciw.setText(this.cia.getActivityName());
        dVar.cix.setText(Integer.toString(this.cia.sT()));
        if (TextUtils.isEmpty(this.cia.getLocation())) {
            dVar.location.setVisibility(8);
            return view;
        }
        dVar.location.setVisibility(0);
        dVar.location.setText(this.cia.getLocation());
        return view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ab */
    public d a(ViewGroup viewGroup) {
        return new d(LayoutInflater.from(this.mContext).inflate(r.h.frs_entelechy_togetherhi_item, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.aq, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bk bkVar, d dVar) {
        super.a(i, view, viewGroup, (ViewGroup) bkVar, (bk) dVar);
        return a(i, view, bkVar, dVar);
    }

    private SpannableStringBuilder ag(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new an.a(str));
            return an.a(this.mContext, str2, (ArrayList<an.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }
}
