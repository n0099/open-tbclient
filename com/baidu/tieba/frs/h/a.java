package com.baidu.tieba.frs.h;

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
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.data.IconData;
import com.baidu.tieba.card.an;
import com.baidu.tieba.frs.bf;
import com.baidu.tieba.frs.g.e;
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.util.s;
import com.baidu.tieba.view.g;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/* loaded from: classes.dex */
public class a extends bf<bi, d> implements e {
    private bi aLV;
    private BaseActivity aRd;
    private View.OnClickListener bUn;
    private bl cdZ;
    private int cea;
    private View.OnClickListener ceb;

    public a(BaseActivity baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
        this.bUn = new b(this);
        this.ceb = new c(this);
        this.aRd = baseActivity;
        this.cea = ((WindowManager) this.aRd.getSystemService("window")).getDefaultDisplay().getWidth() - this.aRd.getResources().getDimensionPixelSize(r.e.ds162);
    }

    private View a(int i, View view, bi biVar, d dVar) {
        if (biVar == null || biVar.ry() == null) {
            return null;
        }
        biVar.sL();
        if (dVar.mSkinType != this.mSkinType) {
            av.k(dVar.caz, r.f.frs_item_control_btn_bg);
            av.k(dVar.ced, r.f.pb_togetherhi_content_selector);
            if (dVar.WH != null) {
                av.l(dVar.WH, r.d.cp_bg_line_c);
            }
            av.l(dVar.cet, r.d.common_color_10082);
            av.l(dVar.cek, r.d.cp_bg_line_c);
            av.c(dVar.cem, r.d.cp_link_tip_a, 1);
            av.c(dVar.cen, r.d.cp_cont_c, 1);
            av.c(dVar.ceo, r.d.cp_cont_c, 1);
            av.c(dVar.cep, r.d.cp_cont_b, 1);
            av.c(dVar.ceq, r.d.cp_cont_c, 1);
            av.c(dVar.cer, r.d.cp_cont_c, 1);
            av.c(dVar.livingTag, r.d.cp_cont_g, 1);
            av.c(dVar.ceu, r.d.cp_cont_g, 1);
            av.c(dVar.cev, r.d.cp_cont_g, 1);
            av.c(dVar.location, r.d.cp_cont_g, 1);
            this.aRd.getLayoutMode().ah(this.mSkinType == 1);
            this.aRd.getLayoutMode().x(view);
        }
        String str = "";
        String str2 = "";
        if (biVar.getAuthor() != null) {
            str = biVar.getAuthor().getPortrait();
            if (biVar.getAuthor().getPendantData() != null) {
                str2 = biVar.getAuthor().getPendantData().pO();
            }
        }
        if (!StringUtils.isNull(str2)) {
            dVar.cef.setVisibility(4);
            dVar.ceg.setVisibility(0);
            dVar.ceg.dX(str2);
            dVar.ceg.getHeadView().c(str, 28, false);
        } else if (!TextUtils.isEmpty(str)) {
            dVar.cef.setVisibility(0);
            dVar.ceg.setVisibility(8);
            dVar.cef.setIsRound(true);
            dVar.cef.setUserId(biVar.getAuthor().getUserId());
            dVar.cef.setImageDrawable(null);
            dVar.cef.c(str, 28, false);
        }
        dVar.aVU.setText(biVar.getAuthor().getUserName());
        ArrayList<IconData> tShowInfoNew = biVar.getAuthor().getTShowInfoNew();
        if (tShowInfoNew != null && tShowInfoNew.size() > 0) {
            dVar.cei.setVisibility(0);
            dVar.cei.setTag(Integer.valueOf(i));
            dVar.cei.setOnClickListener(this.bUn);
            dVar.cei.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(r.e.ds32), this.mContext.getResources().getDimensionPixelSize(r.e.ds32), this.mContext.getResources().getDimensionPixelSize(r.e.ds8), true);
        } else {
            dVar.cei.setVisibility(8);
        }
        if (!biVar.sr() && !TextUtils.isEmpty(biVar.getAddress()) && !TextUtils.isEmpty(biVar.getAddress().trim())) {
            dVar.cek.setVisibility(0);
            dVar.cel.setVisibility(0);
            dVar.cel.setText(biVar.getAddress());
        } else {
            dVar.cek.setVisibility(8);
            dVar.cel.setVisibility(8);
        }
        s readThreadHistory = TbadkCoreApplication.m9getInst().getReadThreadHistory();
        if (biVar.sb() == 1) {
            dVar.ceh.setVisibility(8);
        } else {
            dVar.ceh.setVisibility(0);
            biVar.su();
            dVar.ceh.setMovementMethod(g.bqP());
            dVar.ceh.setText(an.c(this.aRd.getActivity(), biVar.sm(), r.j.card_promotion_text));
            if (readThreadHistory != null && readThreadHistory.ru(biVar.getId())) {
                av.c(dVar.ceh, r.d.cp_cont_c, 1);
            } else {
                av.c(dVar.ceh, r.d.cp_cont_b, 1);
            }
        }
        StringBuffer stringBuffer = new StringBuffer();
        if (biVar.rU() != null && biVar.rU().trim().length() > 0) {
            stringBuffer.append(biVar.rU());
        }
        ArrayList<MediaData> rW = biVar.rW();
        if (rW != null) {
            StringBuffer stringBuffer2 = new StringBuffer();
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= rW.size()) {
                    break;
                }
                if (rW.get(i3).getVideoUrl() != null && rW.get(i3).getVideoUrl().endsWith("swf")) {
                    stringBuffer2.append(rW.get(i3).getVideoUrl());
                }
                i2 = i3 + 1;
            }
            stringBuffer.append(stringBuffer2.toString());
            if (!TextUtils.isEmpty(biVar.g(stringBuffer.toString(), true))) {
                if (stringBuffer.length() > 170) {
                    dVar.cej.setText(String.valueOf(stringBuffer.toString().substring(0, 170)) + "...");
                } else {
                    dVar.cej.setText(stringBuffer.toString());
                }
                dVar.cej.setVisibility(0);
                if (readThreadHistory != null && readThreadHistory.ru(biVar.getId())) {
                    av.c(dVar.cej, r.d.cp_cont_c, 1);
                } else {
                    av.c(dVar.cej, r.d.cp_cont_b, 1);
                }
            } else {
                dVar.cej.setVisibility(8);
            }
        }
        int rH = biVar.rH();
        if (rH > 0 && this.mContext != null) {
            dVar.cey.setVisibility(0);
            dVar.cey.setText(String.valueOf(this.mContext.getString(r.j.comment)) + " " + az.w(rH));
            av.j((View) dVar.cey, r.d.cp_cont_e);
        } else {
            dVar.cey.setVisibility(8);
        }
        if (com.baidu.tieba.graffiti.d.ak(dVar.cex) && biVar.rF() != null && biVar.rF().getNum() > 0) {
            dVar.cex.setVisibility(0);
            String z = az.z(biVar.rF().getNum());
            dVar.cex.setText(z);
            dVar.cex.setContentDescription(String.valueOf(this.aRd.getResources().getString(r.j.zan_num)) + z);
        } else {
            dVar.cex.setVisibility(8);
        }
        dVar.cew.setText(az.t(biVar.rI() * 1000));
        this.cdZ = biVar.ry();
        if (this.cdZ.sS() == 1) {
            dVar.ced.setVisibility(0);
            dVar.ced.setTag(Integer.valueOf(i));
            dVar.ced.setOnClickListener(this.ceb);
            dVar.cee.setVisibility(8);
            dVar.cem.setText(this.cdZ.getActivityName());
            if (TextUtils.isEmpty(this.cdZ.getLocation())) {
                dVar.cen.setVisibility(8);
            } else {
                dVar.cen.setVisibility(0);
                dVar.cen.setText(this.cdZ.getLocation());
            }
            dVar.ceo.setText(new SimpleDateFormat("MM月dd日 HH:mm").format(new Date(this.cdZ.getStartTime() * 1000)));
            dVar.cep.setText(Integer.toString(this.cdZ.sQ()));
            dVar.ces.setPortraitList(this.cdZ.sR());
            return view;
        }
        dVar.ced.setVisibility(8);
        dVar.cee.setVisibility(0);
        dVar.cee.setTag(Integer.valueOf(i));
        dVar.cee.setOnClickListener(this.ceb);
        if (this.cdZ.sS() == 2) {
            dVar.livingTag.setVisibility(0);
        } else {
            dVar.livingTag.setVisibility(8);
        }
        List<String> sN = this.cdZ.sN();
        int size = sN == null ? 0 : sN.size();
        if (sN != null && size > 0) {
            dVar.image1.a(sN.get(0), 13, this.cea, this.cea, false);
        } else {
            dVar.image1.a(null, 13, this.cea, this.cea, false);
        }
        if (sN != null && size > 1) {
            dVar.image2.a(sN.get(1), 13, this.cea, this.cea, false);
        } else {
            dVar.image2.a(null, 13, this.cea, this.cea, false);
        }
        if (sN != null && size > 2) {
            dVar.image3.a(sN.get(2), 13, this.cea, this.cea, false);
        } else {
            dVar.image3.a(null, 13, this.cea, this.cea, false);
        }
        if (sN != null && size > 3) {
            dVar.image4.a(sN.get(3), 13, this.cea, this.cea, false);
        } else {
            dVar.image4.a(null, 13, this.cea, this.cea, false);
        }
        dVar.ceu.setText(this.cdZ.getActivityName());
        dVar.cev.setText(Integer.toString(this.cdZ.sP()));
        if (TextUtils.isEmpty(this.cdZ.getLocation())) {
            dVar.location.setVisibility(8);
            return view;
        }
        dVar.location.setVisibility(0);
        dVar.location.setText(this.cdZ.getLocation());
        return view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: U */
    public d a(ViewGroup viewGroup) {
        return new d(LayoutInflater.from(this.mContext).inflate(r.h.frs_entelechy_togetherhi_item, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bf, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bi biVar, d dVar) {
        super.a(i, view, viewGroup, (ViewGroup) biVar, (bi) dVar);
        return a(i, view, biVar, dVar);
    }
}
