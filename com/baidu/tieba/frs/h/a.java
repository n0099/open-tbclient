package com.baidu.tieba.frs.h;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.az;
import com.baidu.tbadk.core.data.ba;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.data.IconData;
import com.baidu.tieba.card.at;
import com.baidu.tieba.frs.bj;
import com.baidu.tieba.tbadkCore.util.s;
import com.baidu.tieba.u;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/* loaded from: classes.dex */
public class a extends bj<az, d> {
    private int aRz;
    private View.OnClickListener bHY;
    private ba bQW;
    private View.OnClickListener bQX;
    private BaseActivity bkc;

    public a(BaseActivity baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
        this.bHY = new b(this);
        this.bQX = new c(this);
        this.bkc = baseActivity;
        this.aRz = ((WindowManager) this.bkc.getSystemService("window")).getDefaultDisplay().getWidth() - this.bkc.getResources().getDimensionPixelSize(u.e.ds162);
    }

    private View a(int i, View view, az azVar, d dVar) {
        if (azVar == null || azVar.qz() == null) {
            return null;
        }
        if (dVar.mSkinType != this.mSkinType) {
            av.k(dVar.bNE, u.f.frs_item_control_btn_bg);
            av.k(dVar.bQZ, u.f.pb_togetherhi_content_selector);
            if (dVar.SZ != null) {
                av.l(dVar.SZ, u.d.cp_bg_line_c);
            }
            av.l(dVar.bRo, u.d.common_color_10082);
            av.l(dVar.bRf, u.d.cp_bg_line_c);
            av.c(dVar.bRh, u.d.cp_link_tip_a, 1);
            av.c(dVar.bRi, u.d.cp_cont_c, 1);
            av.c(dVar.bRj, u.d.cp_cont_c, 1);
            av.c(dVar.bRk, u.d.cp_cont_b, 1);
            av.c(dVar.bRl, u.d.cp_cont_c, 1);
            av.c(dVar.bRm, u.d.cp_cont_c, 1);
            av.c(dVar.livingTag, u.d.cp_cont_g, 1);
            av.c(dVar.bRp, u.d.cp_cont_g, 1);
            av.c(dVar.bRq, u.d.cp_cont_g, 1);
            av.c(dVar.location, u.d.cp_cont_g, 1);
            this.bkc.getLayoutMode().ad(this.mSkinType == 1);
            this.bkc.getLayoutMode().w(view);
        }
        String portrait = azVar.getAuthor().getPortrait();
        dVar.bRb.setIsRound(true);
        if (!TextUtils.isEmpty(portrait)) {
            dVar.bRb.setUserId(azVar.getAuthor().getUserId());
            dVar.bRb.setImageDrawable(null);
            dVar.bRb.c(portrait, 28, false);
        }
        dVar.aOX.setText(azVar.getAuthor().getUserName());
        ArrayList<IconData> tShowInfoNew = azVar.getAuthor().getTShowInfoNew();
        if (tShowInfoNew != null && tShowInfoNew.size() > 0) {
            dVar.bRd.setVisibility(0);
            dVar.bRd.setTag(Integer.valueOf(i));
            dVar.bRd.setOnClickListener(this.bHY);
            dVar.bRd.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(u.e.ds32), this.mContext.getResources().getDimensionPixelSize(u.e.ds32), this.mContext.getResources().getDimensionPixelSize(u.e.ds8), true);
        } else {
            dVar.bRd.setVisibility(8);
        }
        if (!azVar.re() && !TextUtils.isEmpty(azVar.getAddress()) && !TextUtils.isEmpty(azVar.getAddress().trim())) {
            dVar.bRf.setVisibility(0);
            dVar.bRg.setVisibility(0);
            dVar.bRg.setText(azVar.getAddress());
        } else {
            dVar.bRf.setVisibility(8);
            dVar.bRg.setVisibility(8);
        }
        s readThreadHistory = TbadkCoreApplication.m9getInst().getReadThreadHistory();
        if (azVar.qU() == 1) {
            dVar.bRc.setVisibility(8);
        } else {
            dVar.bRc.setVisibility(0);
            azVar.parser_title();
            dVar.bRc.setText(at.c(this.bkc.getActivity(), azVar.getSpan_str(), u.j.card_promotion_text));
            if (readThreadHistory != null && readThreadHistory.pL(azVar.getId())) {
                av.c(dVar.bRc, u.d.cp_cont_c, 1);
            } else {
                av.c(dVar.bRc, u.d.cp_cont_b, 1);
            }
        }
        StringBuffer stringBuffer = new StringBuffer();
        if (azVar.qO() != null && azVar.qO().trim().length() > 0) {
            stringBuffer.append(azVar.qO());
        }
        ArrayList<MediaData> medias = azVar.getMedias();
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
                    dVar.bRe.setText(String.valueOf(stringBuffer.toString().substring(0, 170)) + "...");
                } else {
                    dVar.bRe.setText(stringBuffer.toString());
                }
                dVar.bRe.setVisibility(0);
                if (readThreadHistory != null && readThreadHistory.pL(azVar.getId())) {
                    av.c(dVar.bRe, u.d.cp_cont_c, 1);
                } else {
                    av.c(dVar.bRe, u.d.cp_cont_b, 1);
                }
            } else {
                dVar.bRe.setVisibility(8);
            }
        }
        int reply_num = azVar.getReply_num();
        if (reply_num > 0) {
            dVar.bRt.setVisibility(0);
            dVar.bRt.setText(com.baidu.tbadk.core.util.ba.B(reply_num));
        } else {
            dVar.bRt.setVisibility(8);
        }
        if (com.baidu.tieba.graffiti.d.an(dVar.bRs) && azVar.getPraise() != null && azVar.getPraise().getNum() > 0) {
            dVar.bRs.setVisibility(0);
            String D = com.baidu.tbadk.core.util.ba.D(azVar.getPraise().getNum());
            dVar.bRs.setText(D);
            dVar.bRs.setContentDescription(String.valueOf(this.bkc.getResources().getString(u.j.zan_num)) + D);
        } else {
            dVar.bRs.setVisibility(8);
        }
        dVar.bRr.setText(com.baidu.tbadk.core.util.ba.y(azVar.getLast_time_int() * 1000));
        this.bQW = azVar.qz();
        if (this.bQW.rz() == 1) {
            dVar.bQZ.setVisibility(0);
            dVar.bQZ.setTag(Integer.valueOf(i));
            dVar.bQZ.setOnClickListener(this.bQX);
            dVar.bRa.setVisibility(8);
            dVar.bRh.setText(this.bQW.getActivityName());
            if (TextUtils.isEmpty(this.bQW.getLocation())) {
                dVar.bRi.setVisibility(8);
            } else {
                dVar.bRi.setVisibility(0);
                dVar.bRi.setText(this.bQW.getLocation());
            }
            dVar.bRj.setText(new SimpleDateFormat("MM月dd日 HH:mm").format(new Date(this.bQW.getStartTime() * 1000)));
            dVar.bRk.setText(Integer.toString(this.bQW.rx()));
            dVar.bRn.setPortraitList(this.bQW.ry());
            return view;
        }
        dVar.bQZ.setVisibility(8);
        dVar.bRa.setVisibility(0);
        dVar.bRa.setTag(Integer.valueOf(i));
        dVar.bRa.setOnClickListener(this.bQX);
        if (this.bQW.rz() == 2) {
            dVar.livingTag.setVisibility(0);
        } else {
            dVar.livingTag.setVisibility(8);
        }
        List<String> ru = this.bQW.ru();
        int size = ru == null ? 0 : ru.size();
        if (ru != null && size > 0) {
            dVar.image1.a(ru.get(0), 13, this.aRz, this.aRz, false);
        } else {
            dVar.image1.a(null, 13, this.aRz, this.aRz, false);
        }
        if (ru != null && size > 1) {
            dVar.image2.a(ru.get(1), 13, this.aRz, this.aRz, false);
        } else {
            dVar.image2.a(null, 13, this.aRz, this.aRz, false);
        }
        if (ru != null && size > 2) {
            dVar.image3.a(ru.get(2), 13, this.aRz, this.aRz, false);
        } else {
            dVar.image3.a(null, 13, this.aRz, this.aRz, false);
        }
        if (ru != null && size > 3) {
            dVar.image4.a(ru.get(3), 13, this.aRz, this.aRz, false);
        } else {
            dVar.image4.a(null, 13, this.aRz, this.aRz, false);
        }
        dVar.bRp.setText(this.bQW.getActivityName());
        dVar.bRq.setText(Integer.toString(this.bQW.rw()));
        if (TextUtils.isEmpty(this.bQW.getLocation())) {
            dVar.location.setVisibility(8);
            return view;
        }
        dVar.location.setVisibility(0);
        dVar.location.setText(this.bQW.getLocation());
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
    public View a(int i, View view, ViewGroup viewGroup, az azVar, d dVar) {
        super.a(i, view, viewGroup, (ViewGroup) azVar, (az) dVar);
        return a(i, view, azVar, dVar);
    }
}
