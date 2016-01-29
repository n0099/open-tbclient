package com.baidu.tieba.frs;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.data.IconData;
import com.baidu.tieba.t;
import java.util.ArrayList;
import tbclient.VideoInfo;
/* loaded from: classes.dex */
public class fa extends bv<com.baidu.tbadk.core.data.ah, fd> {
    private int bki;

    /* JADX INFO: Access modifiers changed from: protected */
    public fa(BaseActivity<?> baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
        this.bki = 0;
        this.bki = com.baidu.adp.lib.util.k.c(this.bdK.getPageContext().getPageActivity(), t.e.ds70);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: G */
    public fd b(ViewGroup viewGroup) {
        return new fd(LayoutInflater.from(this.mContext).inflate(t.h.frs_item_xiaoying, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bv, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.ah ahVar, fd fdVar) {
        super.a(i, view, viewGroup, (ViewGroup) ahVar, (com.baidu.tbadk.core.data.ah) fdVar);
        return a(i, view, ahVar, fdVar);
    }

    private View a(int i, View view, com.baidu.tbadk.core.data.ah ahVar, fd fdVar) {
        fb fbVar = new fb(this, ahVar);
        fc fcVar = new fc(this, ahVar);
        b(ahVar, fdVar);
        c(ahVar, fdVar);
        f(ahVar, fdVar);
        a(ahVar, fdVar, fbVar);
        a(ahVar, fdVar, i);
        a(ahVar, fdVar, i, fcVar);
        e(ahVar, fdVar);
        d(ahVar, fdVar);
        a(ahVar, fdVar);
        cg.a(this.bdK, fdVar.blS, fdVar.beU, fdVar.ahH, fdVar.bkq, fdVar.bkr, fdVar.blX, fdVar.bkp, view, ahVar, this.mSkinType, fbVar, this.bhx);
        a(view, fdVar);
        return view;
    }

    private void a(com.baidu.tbadk.core.data.ah ahVar, fd fdVar) {
        if (ahVar != null && fdVar != null) {
            if (ahVar.getPraise() != null && ahVar.getPraise().getNum() > 0) {
                fdVar.ahn.setVisibility(0);
                fdVar.ahn.setText(com.baidu.tbadk.core.util.aw.y(ahVar.getPraise().getNum()));
            } else {
                fdVar.ahn.setVisibility(8);
            }
            int reply_num = ahVar.getReply_num();
            if (reply_num > 0) {
                fdVar.beY.setVisibility(0);
                fdVar.beY.setText(com.baidu.tbadk.core.util.aw.y(reply_num));
                return;
            }
            fdVar.beY.setVisibility(8);
        }
    }

    private void b(com.baidu.tbadk.core.data.ah ahVar, fd fdVar) {
        if (ahVar != null && fdVar != null) {
            fdVar.ahm.setText(com.baidu.tbadk.core.util.aw.t(ahVar.getLast_time_int() * 1000));
        }
    }

    private void c(com.baidu.tbadk.core.data.ah ahVar, fd fdVar) {
        if (ahVar != null && ahVar.getAuthor() != null && fdVar != null) {
            fdVar.ahH.setText(ahVar.getAuthor().getUserName());
        }
    }

    private void d(com.baidu.tbadk.core.data.ah ahVar, fd fdVar) {
        VideoInfo tz;
        if (ahVar != null && fdVar != null && (tz = ahVar.tz()) != null) {
            if (com.baidu.tbadk.core.l.rn().rt() && !StringUtils.isNull(tz.video_url)) {
                fdVar.blY.setVisibility(0);
                fdVar.blV.d(tz.thumbnail_url, 13, false);
            } else {
                fdVar.blY.setVisibility(8);
            }
            int intValue = tz.play_count.intValue() > 0 ? tz.play_count.intValue() : 0;
            if (intValue > 0) {
                fdVar.bma.setText(String.format(this.bdK.getResources().getString(t.j.frs_video_play_count_text), com.baidu.tbadk.core.util.aw.x(intValue)));
                fdVar.bma.setVisibility(0);
                return;
            }
            fdVar.bma.setVisibility(8);
        }
    }

    private void e(com.baidu.tbadk.core.data.ah ahVar, fd fdVar) {
        if (ahVar != null && fdVar != null) {
            if (ahVar.tx() == 1) {
                fdVar.aPr.setVisibility(8);
                return;
            }
            com.baidu.tieba.tbadkCore.util.r readThreadHistory = TbadkCoreApplication.m411getInst().getReadThreadHistory();
            fdVar.aPr.setVisibility(0);
            ahVar.parser_title();
            fdVar.aPr.setText(ahVar.getSpan_str());
            if (readThreadHistory != null && readThreadHistory.mU(ahVar.getId())) {
                com.baidu.tbadk.core.util.ar.b(fdVar.aPr, t.d.cp_cont_c, 1);
            } else {
                com.baidu.tbadk.core.util.ar.b(fdVar.aPr, t.d.cp_cont_b, 1);
            }
        }
    }

    private void a(com.baidu.tbadk.core.data.ah ahVar, fd fdVar, int i, View.OnClickListener onClickListener) {
        if (ahVar != null && fdVar != null && i >= 0 && ahVar.getAuthor() != null) {
            ArrayList<IconData> tShowInfoNew = ahVar.getAuthor().getTShowInfoNew();
            if (tShowInfoNew != null && tShowInfoNew.size() > 0) {
                fdVar.ahI.setVisibility(0);
                com.baidu.tbadk.core.util.ar.b(fdVar.ahH, t.d.cp_cont_h, 1);
                fdVar.ahI.setTag(Integer.valueOf(i));
                fdVar.ahI.setOnClickListener(onClickListener);
                fdVar.ahI.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(t.e.small_icon_width), this.mContext.getResources().getDimensionPixelSize(t.e.small_icon_height), this.mContext.getResources().getDimensionPixelSize(t.e.small_icon_margin), true);
                return;
            }
            fdVar.ahI.setVisibility(8);
            com.baidu.tbadk.core.util.ar.b(fdVar.ahH, t.d.cp_cont_c, 1);
        }
    }

    private void a(com.baidu.tbadk.core.data.ah ahVar, fd fdVar, int i) {
        if (ahVar != null && ahVar.getAuthor() != null) {
            ArrayList<IconData> iconInfo = ahVar.getAuthor().getIconInfo();
            if (iconInfo != null && iconInfo.size() > 0) {
                fdVar.ahJ.setVisibility(0);
                com.baidu.tbadk.core.util.ar.b(fdVar.ahH, t.d.cp_cont_h, 1);
                fdVar.ahJ.setTag(Integer.valueOf(i));
                fdVar.ahJ.setOnClickListener(null);
                fdVar.ahJ.a(iconInfo, 3, this.mContext.getResources().getDimensionPixelSize(t.e.ds30), this.mContext.getResources().getDimensionPixelSize(t.e.ds30), this.mContext.getResources().getDimensionPixelSize(t.e.ds10), true);
                fdVar.ahJ.setOnClickListener(null);
                return;
            }
            fdVar.ahJ.setVisibility(8);
            com.baidu.tbadk.core.util.ar.b(fdVar.ahH, t.d.cp_cont_c, 1);
        }
    }

    private void a(com.baidu.tbadk.core.data.ah ahVar, fd fdVar, View.OnClickListener onClickListener) {
        boolean g = g(ahVar);
        if (ahVar == null || ahVar.getAuthor() == null || !com.baidu.tbadk.core.l.rn().rp() || g) {
            fdVar.beU.setVisibility(8);
        } else {
            fdVar.beU.setVisibility(0);
            String portrait = ahVar.getAuthor().getPortrait();
            fdVar.beU.setUserId(ahVar.getAuthor().getUserId());
            fdVar.beU.setImageDrawable(null);
            fdVar.beU.setOnClickListener(onClickListener);
            fdVar.beU.d(portrait, 28, false);
        }
        fdVar.blX.setOnClickListener(onClickListener);
    }

    private void f(com.baidu.tbadk.core.data.ah ahVar, fd fdVar) {
        if (ahVar != null && !ahVar.tF() && !StringUtils.isNull(ahVar.getAddress())) {
            fdVar.blT.setText(ahVar.getAddress());
            fdVar.blT.setVisibility(0);
            fdVar.blU.setVisibility(0);
            return;
        }
        fdVar.blT.setVisibility(8);
        fdVar.blU.setVisibility(8);
    }

    private void a(View view, fd fdVar) {
        if (this.bdK != null && this.bdK.getLayoutMode() != null && fdVar.ahU != this.mSkinType) {
            fdVar.ahU = this.mSkinType;
            this.bdK.getLayoutMode().ac(this.mSkinType == 1);
            this.bdK.getLayoutMode().x(view);
        }
    }

    private boolean g(com.baidu.tbadk.core.data.ah ahVar) {
        return (ahVar == null || ahVar.getAuthor() == null || ahVar.getAuthor().getGodInfo() == null || ahVar.getAuthor().getGodInfo().type.intValue() != 2) ? false : true;
    }
}
