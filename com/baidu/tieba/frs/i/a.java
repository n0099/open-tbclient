package com.baidu.tieba.frs.i;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.be;
import com.baidu.tbadk.core.data.bf;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.data.IconData;
import com.baidu.tieba.card.at;
import com.baidu.tieba.frs.bj;
import com.baidu.tieba.frs.h.e;
import com.baidu.tieba.tbadkCore.util.s;
import com.baidu.tieba.u;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/* loaded from: classes.dex */
public class a extends bj<be, d> implements e {
    private int aSt;
    private be bDO;
    private View.OnClickListener bJt;
    private bf bSU;
    private View.OnClickListener bSV;
    private BaseActivity bem;

    public a(BaseActivity baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
        this.bJt = new b(this);
        this.bSV = new c(this);
        this.bem = baseActivity;
        this.aSt = ((WindowManager) this.bem.getSystemService("window")).getDefaultDisplay().getWidth() - this.bem.getResources().getDimensionPixelSize(u.e.ds162);
    }

    private View a(int i, View view, be beVar, d dVar) {
        if (beVar == null || beVar.qi() == null) {
            return null;
        }
        if (dVar.mSkinType != this.mSkinType) {
            av.k(dVar.bPp, u.f.frs_item_control_btn_bg);
            av.k(dVar.bSX, u.f.pb_togetherhi_content_selector);
            if (dVar.TH != null) {
                av.l(dVar.TH, u.d.cp_bg_line_c);
            }
            av.l(dVar.bTm, u.d.common_color_10082);
            av.l(dVar.bTd, u.d.cp_bg_line_c);
            av.c(dVar.bTf, u.d.cp_link_tip_a, 1);
            av.c(dVar.bTg, u.d.cp_cont_c, 1);
            av.c(dVar.bTh, u.d.cp_cont_c, 1);
            av.c(dVar.bTi, u.d.cp_cont_b, 1);
            av.c(dVar.bTj, u.d.cp_cont_c, 1);
            av.c(dVar.bTk, u.d.cp_cont_c, 1);
            av.c(dVar.livingTag, u.d.cp_cont_g, 1);
            av.c(dVar.bTn, u.d.cp_cont_g, 1);
            av.c(dVar.bTo, u.d.cp_cont_g, 1);
            av.c(dVar.location, u.d.cp_cont_g, 1);
            this.bem.getLayoutMode().af(this.mSkinType == 1);
            this.bem.getLayoutMode().w(view);
        }
        String portrait = beVar.getAuthor().getPortrait();
        dVar.bSZ.setIsRound(true);
        if (!TextUtils.isEmpty(portrait)) {
            dVar.bSZ.setUserId(beVar.getAuthor().getUserId());
            dVar.bSZ.setImageDrawable(null);
            dVar.bSZ.c(portrait, 28, false);
        }
        dVar.aPR.setText(beVar.getAuthor().getUserName());
        ArrayList<IconData> tShowInfoNew = beVar.getAuthor().getTShowInfoNew();
        if (tShowInfoNew != null && tShowInfoNew.size() > 0) {
            dVar.bTb.setVisibility(0);
            dVar.bTb.setTag(Integer.valueOf(i));
            dVar.bTb.setOnClickListener(this.bJt);
            dVar.bTb.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(u.e.ds32), this.mContext.getResources().getDimensionPixelSize(u.e.ds32), this.mContext.getResources().getDimensionPixelSize(u.e.ds8), true);
        } else {
            dVar.bTb.setVisibility(8);
        }
        if (!beVar.ra() && !TextUtils.isEmpty(beVar.getAddress()) && !TextUtils.isEmpty(beVar.getAddress().trim())) {
            dVar.bTd.setVisibility(0);
            dVar.bTe.setVisibility(0);
            dVar.bTe.setText(beVar.getAddress());
        } else {
            dVar.bTd.setVisibility(8);
            dVar.bTe.setVisibility(8);
        }
        s readThreadHistory = TbadkCoreApplication.m10getInst().getReadThreadHistory();
        if (beVar.qK() == 1) {
            dVar.bTa.setVisibility(8);
        } else {
            dVar.bTa.setVisibility(0);
            beVar.rd();
            dVar.bTa.setText(at.c(this.bem.getActivity(), beVar.qV(), u.j.card_promotion_text));
            if (readThreadHistory != null && readThreadHistory.qv(beVar.getId())) {
                av.c(dVar.bTa, u.d.cp_cont_c, 1);
            } else {
                av.c(dVar.bTa, u.d.cp_cont_b, 1);
            }
        }
        StringBuffer stringBuffer = new StringBuffer();
        if (beVar.qD() != null && beVar.qD().trim().length() > 0) {
            stringBuffer.append(beVar.qD());
        }
        ArrayList<MediaData> qF = beVar.qF();
        if (qF != null) {
            StringBuffer stringBuffer2 = new StringBuffer();
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= qF.size()) {
                    break;
                }
                if (qF.get(i3).getVideoUrl() != null && qF.get(i3).getVideoUrl().endsWith("swf")) {
                    stringBuffer2.append(qF.get(i3).getVideoUrl());
                }
                i2 = i3 + 1;
            }
            stringBuffer.append(stringBuffer2.toString());
            if (stringBuffer.length() > 0) {
                if (stringBuffer.length() > 170) {
                    dVar.bTc.setText(String.valueOf(stringBuffer.toString().substring(0, 170)) + "...");
                } else {
                    dVar.bTc.setText(stringBuffer.toString());
                }
                dVar.bTc.setVisibility(0);
                if (readThreadHistory != null && readThreadHistory.qv(beVar.getId())) {
                    av.c(dVar.bTc, u.d.cp_cont_c, 1);
                } else {
                    av.c(dVar.bTc, u.d.cp_cont_b, 1);
                }
            } else {
                dVar.bTc.setVisibility(8);
            }
        }
        int qr = beVar.qr();
        if (qr > 0) {
            dVar.bTr.setVisibility(0);
            dVar.bTr.setText(ba.w(qr));
        } else {
            dVar.bTr.setVisibility(8);
        }
        if (com.baidu.tieba.graffiti.d.al(dVar.bTq) && beVar.qp() != null && beVar.qp().getNum() > 0) {
            dVar.bTq.setVisibility(0);
            String y = ba.y(beVar.qp().getNum());
            dVar.bTq.setText(y);
            dVar.bTq.setContentDescription(String.valueOf(this.bem.getResources().getString(u.j.zan_num)) + y);
        } else {
            dVar.bTq.setVisibility(8);
        }
        dVar.bTp.setText(ba.t(beVar.qs() * 1000));
        this.bSU = beVar.qi();
        if (this.bSU.ry() == 1) {
            dVar.bSX.setVisibility(0);
            dVar.bSX.setTag(Integer.valueOf(i));
            dVar.bSX.setOnClickListener(this.bSV);
            dVar.bSY.setVisibility(8);
            dVar.bTf.setText(this.bSU.getActivityName());
            if (TextUtils.isEmpty(this.bSU.getLocation())) {
                dVar.bTg.setVisibility(8);
            } else {
                dVar.bTg.setVisibility(0);
                dVar.bTg.setText(this.bSU.getLocation());
            }
            dVar.bTh.setText(new SimpleDateFormat("MM月dd日 HH:mm").format(new Date(this.bSU.getStartTime() * 1000)));
            dVar.bTi.setText(Integer.toString(this.bSU.rw()));
            dVar.bTl.setPortraitList(this.bSU.rx());
            return view;
        }
        dVar.bSX.setVisibility(8);
        dVar.bSY.setVisibility(0);
        dVar.bSY.setTag(Integer.valueOf(i));
        dVar.bSY.setOnClickListener(this.bSV);
        if (this.bSU.ry() == 2) {
            dVar.livingTag.setVisibility(0);
        } else {
            dVar.livingTag.setVisibility(8);
        }
        List<String> rt = this.bSU.rt();
        int size = rt == null ? 0 : rt.size();
        if (rt != null && size > 0) {
            dVar.image1.a(rt.get(0), 13, this.aSt, this.aSt, false);
        } else {
            dVar.image1.a(null, 13, this.aSt, this.aSt, false);
        }
        if (rt != null && size > 1) {
            dVar.image2.a(rt.get(1), 13, this.aSt, this.aSt, false);
        } else {
            dVar.image2.a(null, 13, this.aSt, this.aSt, false);
        }
        if (rt != null && size > 2) {
            dVar.image3.a(rt.get(2), 13, this.aSt, this.aSt, false);
        } else {
            dVar.image3.a(null, 13, this.aSt, this.aSt, false);
        }
        if (rt != null && size > 3) {
            dVar.image4.a(rt.get(3), 13, this.aSt, this.aSt, false);
        } else {
            dVar.image4.a(null, 13, this.aSt, this.aSt, false);
        }
        dVar.bTn.setText(this.bSU.getActivityName());
        dVar.bTo.setText(Integer.toString(this.bSU.rv()));
        if (TextUtils.isEmpty(this.bSU.getLocation())) {
            dVar.location.setVisibility(8);
            return view;
        }
        dVar.location.setVisibility(0);
        dVar.location.setText(this.bSU.getLocation());
        return view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ab */
    public d a(ViewGroup viewGroup) {
        return new d(LayoutInflater.from(this.mContext).inflate(u.h.frs_entelechy_togetherhi_item, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bj, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, be beVar, d dVar) {
        super.a(i, view, viewGroup, (ViewGroup) beVar, (be) dVar);
        return a(i, view, beVar, dVar);
    }
}
