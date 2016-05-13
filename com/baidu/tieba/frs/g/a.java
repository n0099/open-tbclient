package com.baidu.tieba.frs.g;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.ax;
import com.baidu.tbadk.core.data.ay;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.data.IconData;
import com.baidu.tieba.card.au;
import com.baidu.tieba.frs.bw;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.util.s;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/* loaded from: classes.dex */
public class a extends bw<ax, d> {
    private int aOc;
    private BaseActivity bek;
    private View.OnClickListener bkL;
    private ay bts;
    private View.OnClickListener btt;

    public a(BaseActivity baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
        this.bkL = new b(this);
        this.btt = new c(this);
        this.bek = baseActivity;
        this.aOc = ((WindowManager) this.bek.getSystemService("window")).getDefaultDisplay().getWidth() - this.bek.getResources().getDimensionPixelSize(t.e.ds162);
    }

    private View a(int i, View view, ax axVar, d dVar) {
        if (axVar == null || axVar.qG() == null) {
            return null;
        }
        if (dVar.mSkinType != this.mSkinType) {
            at.k(dVar.bmh, t.f.frs_item_control_btn_bg);
            at.k(dVar.btv, t.f.pb_togetherhi_content_selector);
            if (dVar.SI != null) {
                at.l(dVar.SI, t.d.cp_bg_line_c);
            }
            at.l(dVar.btK, t.d.black_alpha30);
            at.l(dVar.btB, t.d.cp_bg_line_c);
            at.c(dVar.btD, t.d.cp_link_tip_a, 1);
            at.c(dVar.btE, t.d.cp_cont_c, 1);
            at.c(dVar.btF, t.d.cp_cont_c, 1);
            at.c(dVar.btG, t.d.cp_cont_b, 1);
            at.c(dVar.btH, t.d.cp_cont_c, 1);
            at.c(dVar.btI, t.d.cp_cont_c, 1);
            at.c(dVar.livingTag, t.d.cp_cont_g, 1);
            at.c(dVar.btL, t.d.cp_cont_g, 1);
            at.c(dVar.btM, t.d.cp_cont_g, 1);
            at.c(dVar.location, t.d.cp_cont_g, 1);
            this.bek.getLayoutMode().ae(this.mSkinType == 1);
            this.bek.getLayoutMode().x(view);
        }
        String portrait = axVar.getAuthor().getPortrait();
        dVar.btx.setIsRound(true);
        if (!TextUtils.isEmpty(portrait)) {
            dVar.btx.setUserId(axVar.getAuthor().getUserId());
            dVar.btx.setImageDrawable(null);
            dVar.btx.c(portrait, 28, false);
        }
        dVar.aLz.setText(axVar.getAuthor().getUserName());
        ArrayList<IconData> tShowInfoNew = axVar.getAuthor().getTShowInfoNew();
        if (tShowInfoNew != null && tShowInfoNew.size() > 0) {
            dVar.btz.setVisibility(0);
            dVar.btz.setTag(Integer.valueOf(i));
            dVar.btz.setOnClickListener(this.bkL);
            dVar.btz.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(t.e.small_icon_width), this.mContext.getResources().getDimensionPixelSize(t.e.small_icon_height), this.mContext.getResources().getDimensionPixelSize(t.e.small_icon_margin), true);
        } else {
            dVar.btz.setVisibility(8);
        }
        if (!axVar.ri() && !TextUtils.isEmpty(axVar.getAddress()) && !TextUtils.isEmpty(axVar.getAddress().trim())) {
            dVar.btB.setVisibility(0);
            dVar.btC.setVisibility(0);
            dVar.btC.setText(axVar.getAddress());
        } else {
            dVar.btB.setVisibility(8);
            dVar.btC.setVisibility(8);
        }
        s readThreadHistory = TbadkCoreApplication.m11getInst().getReadThreadHistory();
        if (axVar.qZ() == 1) {
            dVar.bty.setVisibility(8);
        } else {
            dVar.bty.setVisibility(0);
            axVar.parser_title();
            dVar.bty.setText(au.c(this.bek.getActivity(), axVar.getSpan_str(), t.j.card_promotion_text));
            if (readThreadHistory != null && readThreadHistory.od(axVar.getId())) {
                at.c(dVar.bty, t.d.cp_cont_c, 1);
            } else {
                at.c(dVar.bty, t.d.cp_cont_b, 1);
            }
        }
        StringBuffer stringBuffer = new StringBuffer();
        if (axVar.qT() != null && axVar.qT().trim().length() > 0) {
            stringBuffer.append(axVar.qT());
        }
        ArrayList<MediaData> medias = axVar.getMedias();
        if (medias != null) {
            StringBuffer stringBuffer2 = new StringBuffer();
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= medias.size()) {
                    break;
                }
                if (medias.get(i3).getVideoUrl() != null && medias.get(i3).getVideoUrl().endsWith("swf")) {
                    stringBuffer2.append(medias.get(i3).getVideoUrl());
                }
                i2 = i3 + 1;
            }
            stringBuffer.append(stringBuffer2.toString());
            if (stringBuffer.length() > 0) {
                if (stringBuffer.length() > 170) {
                    dVar.btA.setText(String.valueOf(stringBuffer.toString().substring(0, 170)) + "...");
                } else {
                    dVar.btA.setText(stringBuffer.toString());
                }
                dVar.btA.setVisibility(0);
                if (readThreadHistory != null && readThreadHistory.od(axVar.getId())) {
                    at.c(dVar.btA, t.d.cp_cont_c, 1);
                } else {
                    at.c(dVar.btA, t.d.cp_cont_b, 1);
                }
            } else {
                dVar.btA.setVisibility(8);
            }
        }
        int reply_num = axVar.getReply_num();
        if (reply_num > 0) {
            dVar.btP.setVisibility(0);
            dVar.btP.setText(com.baidu.tbadk.core.util.ay.A(reply_num));
        } else {
            dVar.btP.setVisibility(8);
        }
        if (com.baidu.tieba.graffiti.d.aj(dVar.btO) && axVar.getPraise() != null && axVar.getPraise().getNum() > 0) {
            dVar.btO.setVisibility(0);
            String B = com.baidu.tbadk.core.util.ay.B(axVar.getPraise().getNum());
            dVar.btO.setText(B);
            dVar.btO.setContentDescription(String.valueOf(this.bek.getResources().getString(t.j.zan_num)) + B);
        } else {
            dVar.btO.setVisibility(8);
        }
        dVar.btN.setText(com.baidu.tbadk.core.util.ay.x(axVar.getLast_time_int() * 1000));
        this.bts = axVar.qG();
        if (this.bts.rB() == 1) {
            dVar.btv.setVisibility(0);
            dVar.btv.setTag(Integer.valueOf(i));
            dVar.btv.setOnClickListener(this.btt);
            dVar.btw.setVisibility(8);
            dVar.btD.setText(this.bts.getActivityName());
            if (TextUtils.isEmpty(this.bts.getLocation())) {
                dVar.btE.setVisibility(8);
            } else {
                dVar.btE.setVisibility(0);
                dVar.btE.setText(this.bts.getLocation());
            }
            dVar.btF.setText(new SimpleDateFormat("MM月dd日 HH:mm").format(new Date(this.bts.getStartTime() * 1000)));
            dVar.btG.setText(Integer.toString(this.bts.rz()));
            dVar.btJ.setPortraitList(this.bts.rA());
            return view;
        }
        dVar.btv.setVisibility(8);
        dVar.btw.setVisibility(0);
        dVar.btw.setTag(Integer.valueOf(i));
        dVar.btw.setOnClickListener(this.btt);
        if (this.bts.rB() == 2) {
            dVar.livingTag.setVisibility(0);
        } else {
            dVar.livingTag.setVisibility(8);
        }
        List<String> rw = this.bts.rw();
        int size = rw == null ? 0 : rw.size();
        if (rw != null && size > 0) {
            dVar.image1.a(rw.get(0), 13, this.aOc, this.aOc, false);
        } else {
            dVar.image1.a(null, 13, this.aOc, this.aOc, false);
        }
        if (rw != null && size > 1) {
            dVar.image2.a(rw.get(1), 13, this.aOc, this.aOc, false);
        } else {
            dVar.image2.a(null, 13, this.aOc, this.aOc, false);
        }
        if (rw != null && size > 2) {
            dVar.image3.a(rw.get(2), 13, this.aOc, this.aOc, false);
        } else {
            dVar.image3.a(null, 13, this.aOc, this.aOc, false);
        }
        if (rw != null && size > 3) {
            dVar.image4.a(rw.get(3), 13, this.aOc, this.aOc, false);
        } else {
            dVar.image4.a(null, 13, this.aOc, this.aOc, false);
        }
        dVar.btL.setText(this.bts.getActivityName());
        dVar.btM.setText(Integer.toString(this.bts.ry()));
        if (TextUtils.isEmpty(this.bts.getLocation())) {
            dVar.location.setVisibility(8);
            return view;
        }
        dVar.location.setVisibility(0);
        dVar.location.setText(this.bts.getLocation());
        return view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: S */
    public d b(ViewGroup viewGroup) {
        return new d(LayoutInflater.from(this.mContext).inflate(t.h.frs_entelechy_togetherhi_item, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bw, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, ax axVar, d dVar) {
        super.a(i, view, viewGroup, (ViewGroup) axVar, (ax) dVar);
        return a(i, view, axVar, dVar);
    }
}
