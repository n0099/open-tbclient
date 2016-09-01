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
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.data.IconData;
import com.baidu.tieba.card.ap;
import com.baidu.tieba.frs.bf;
import com.baidu.tieba.frs.g.e;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.util.s;
import com.baidu.tieba.view.g;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/* loaded from: classes.dex */
public class a extends bf<bg, d> implements e {
    private BaseActivity aPR;
    private bg bPs;
    private View.OnClickListener bUu;
    private bj cea;
    private int ceb;
    private View.OnClickListener cec;

    public a(BaseActivity baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
        this.bUu = new b(this);
        this.cec = new c(this);
        this.aPR = baseActivity;
        this.ceb = ((WindowManager) this.aPR.getSystemService("window")).getDefaultDisplay().getWidth() - this.aPR.getResources().getDimensionPixelSize(t.e.ds162);
    }

    private View a(int i, View view, bg bgVar, d dVar) {
        if (bgVar == null || bgVar.rm() == null) {
            return null;
        }
        if (dVar.mSkinType != this.mSkinType) {
            av.k(dVar.cax, t.f.frs_item_control_btn_bg);
            av.k(dVar.cee, t.f.pb_togetherhi_content_selector);
            if (dVar.Wx != null) {
                av.l(dVar.Wx, t.d.cp_bg_line_c);
            }
            av.l(dVar.ceu, t.d.common_color_10082);
            av.l(dVar.cel, t.d.cp_bg_line_c);
            av.c(dVar.cen, t.d.cp_link_tip_a, 1);
            av.c(dVar.ceo, t.d.cp_cont_c, 1);
            av.c(dVar.cep, t.d.cp_cont_c, 1);
            av.c(dVar.ceq, t.d.cp_cont_b, 1);
            av.c(dVar.cer, t.d.cp_cont_c, 1);
            av.c(dVar.ces, t.d.cp_cont_c, 1);
            av.c(dVar.livingTag, t.d.cp_cont_g, 1);
            av.c(dVar.cev, t.d.cp_cont_g, 1);
            av.c(dVar.cew, t.d.cp_cont_g, 1);
            av.c(dVar.location, t.d.cp_cont_g, 1);
            this.aPR.getLayoutMode().ah(this.mSkinType == 1);
            this.aPR.getLayoutMode().x(view);
        }
        String str = "";
        String str2 = "";
        if (bgVar.getAuthor() != null) {
            str = bgVar.getAuthor().getPortrait();
            if (bgVar.getAuthor().getPendantData() != null) {
                str2 = bgVar.getAuthor().getPendantData().rc();
            }
        }
        if (!StringUtils.isNull(str2)) {
            dVar.ceg.setVisibility(4);
            dVar.ceh.setVisibility(0);
            dVar.ceh.dU(str2);
            dVar.ceh.getHeadView().c(str, 28, false);
        } else if (!TextUtils.isEmpty(str)) {
            dVar.ceg.setVisibility(0);
            dVar.ceh.setVisibility(8);
            dVar.ceg.setIsRound(true);
            dVar.ceg.setUserId(bgVar.getAuthor().getUserId());
            dVar.ceg.setImageDrawable(null);
            dVar.ceg.c(str, 28, false);
        }
        dVar.aVl.setText(bgVar.getAuthor().getUserName());
        ArrayList<IconData> tShowInfoNew = bgVar.getAuthor().getTShowInfoNew();
        if (tShowInfoNew != null && tShowInfoNew.size() > 0) {
            dVar.cej.setVisibility(0);
            dVar.cej.setTag(Integer.valueOf(i));
            dVar.cej.setOnClickListener(this.bUu);
            dVar.cej.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(t.e.ds32), this.mContext.getResources().getDimensionPixelSize(t.e.ds32), this.mContext.getResources().getDimensionPixelSize(t.e.ds8), true);
        } else {
            dVar.cej.setVisibility(8);
        }
        if (!bgVar.sf() && !TextUtils.isEmpty(bgVar.getAddress()) && !TextUtils.isEmpty(bgVar.getAddress().trim())) {
            dVar.cel.setVisibility(0);
            dVar.cem.setVisibility(0);
            dVar.cem.setText(bgVar.getAddress());
        } else {
            dVar.cel.setVisibility(8);
            dVar.cem.setVisibility(8);
        }
        s readThreadHistory = TbadkCoreApplication.m9getInst().getReadThreadHistory();
        if (bgVar.rP() == 1) {
            dVar.cei.setVisibility(8);
        } else {
            dVar.cei.setVisibility(0);
            bgVar.si();
            dVar.cei.setMovementMethod(g.bql());
            dVar.cei.setText(ap.c(this.aPR.getActivity(), bgVar.sa(), t.j.card_promotion_text));
            if (readThreadHistory != null && readThreadHistory.rf(bgVar.getId())) {
                av.c(dVar.cei, t.d.cp_cont_c, 1);
            } else {
                av.c(dVar.cei, t.d.cp_cont_b, 1);
            }
        }
        StringBuffer stringBuffer = new StringBuffer();
        if (bgVar.rI() != null && bgVar.rI().trim().length() > 0) {
            stringBuffer.append(bgVar.rI());
        }
        ArrayList<MediaData> rK = bgVar.rK();
        if (rK != null) {
            StringBuffer stringBuffer2 = new StringBuffer();
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= rK.size()) {
                    break;
                }
                if (rK.get(i3).getVideoUrl() != null && rK.get(i3).getVideoUrl().endsWith("swf")) {
                    stringBuffer2.append(rK.get(i3).getVideoUrl());
                }
                i2 = i3 + 1;
            }
            stringBuffer.append(stringBuffer2.toString());
            if (!TextUtils.isEmpty(bgVar.g(stringBuffer.toString(), true))) {
                if (stringBuffer.length() > 170) {
                    dVar.cek.setText(String.valueOf(stringBuffer.toString().substring(0, 170)) + "...");
                } else {
                    dVar.cek.setText(stringBuffer.toString());
                }
                dVar.cek.setVisibility(0);
                if (readThreadHistory != null && readThreadHistory.rf(bgVar.getId())) {
                    av.c(dVar.cek, t.d.cp_cont_c, 1);
                } else {
                    av.c(dVar.cek, t.d.cp_cont_b, 1);
                }
            } else {
                dVar.cek.setVisibility(8);
            }
        }
        int rv = bgVar.rv();
        if (rv > 0) {
            dVar.cez.setVisibility(0);
            dVar.cez.setText(ba.w(rv));
        } else {
            dVar.cez.setVisibility(8);
        }
        if (com.baidu.tieba.graffiti.d.al(dVar.cey) && bgVar.rt() != null && bgVar.rt().getNum() > 0) {
            dVar.cey.setVisibility(0);
            String y = ba.y(bgVar.rt().getNum());
            dVar.cey.setText(y);
            dVar.cey.setContentDescription(String.valueOf(this.aPR.getResources().getString(t.j.zan_num)) + y);
        } else {
            dVar.cey.setVisibility(8);
        }
        dVar.cex.setText(ba.t(bgVar.rw() * 1000));
        this.cea = bgVar.rm();
        if (this.cea.sD() == 1) {
            dVar.cee.setVisibility(0);
            dVar.cee.setTag(Integer.valueOf(i));
            dVar.cee.setOnClickListener(this.cec);
            dVar.cef.setVisibility(8);
            dVar.cen.setText(this.cea.getActivityName());
            if (TextUtils.isEmpty(this.cea.getLocation())) {
                dVar.ceo.setVisibility(8);
            } else {
                dVar.ceo.setVisibility(0);
                dVar.ceo.setText(this.cea.getLocation());
            }
            dVar.cep.setText(new SimpleDateFormat("MM月dd日 HH:mm").format(new Date(this.cea.getStartTime() * 1000)));
            dVar.ceq.setText(Integer.toString(this.cea.sB()));
            dVar.cet.setPortraitList(this.cea.sC());
            return view;
        }
        dVar.cee.setVisibility(8);
        dVar.cef.setVisibility(0);
        dVar.cef.setTag(Integer.valueOf(i));
        dVar.cef.setOnClickListener(this.cec);
        if (this.cea.sD() == 2) {
            dVar.livingTag.setVisibility(0);
        } else {
            dVar.livingTag.setVisibility(8);
        }
        List<String> sy = this.cea.sy();
        int size = sy == null ? 0 : sy.size();
        if (sy != null && size > 0) {
            dVar.image1.a(sy.get(0), 13, this.ceb, this.ceb, false);
        } else {
            dVar.image1.a(null, 13, this.ceb, this.ceb, false);
        }
        if (sy != null && size > 1) {
            dVar.image2.a(sy.get(1), 13, this.ceb, this.ceb, false);
        } else {
            dVar.image2.a(null, 13, this.ceb, this.ceb, false);
        }
        if (sy != null && size > 2) {
            dVar.image3.a(sy.get(2), 13, this.ceb, this.ceb, false);
        } else {
            dVar.image3.a(null, 13, this.ceb, this.ceb, false);
        }
        if (sy != null && size > 3) {
            dVar.image4.a(sy.get(3), 13, this.ceb, this.ceb, false);
        } else {
            dVar.image4.a(null, 13, this.ceb, this.ceb, false);
        }
        dVar.cev.setText(this.cea.getActivityName());
        dVar.cew.setText(Integer.toString(this.cea.sA()));
        if (TextUtils.isEmpty(this.cea.getLocation())) {
            dVar.location.setVisibility(8);
            return view;
        }
        dVar.location.setVisibility(0);
        dVar.location.setText(this.cea.getLocation());
        return view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: T */
    public d a(ViewGroup viewGroup) {
        return new d(LayoutInflater.from(this.mContext).inflate(t.h.frs_entelechy_togetherhi_item, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bf, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bg bgVar, d dVar) {
        super.a(i, view, viewGroup, (ViewGroup) bgVar, (bg) dVar);
        return a(i, view, bgVar, dVar);
    }
}
