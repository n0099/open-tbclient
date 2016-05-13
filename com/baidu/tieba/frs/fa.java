package com.baidu.tieba.frs;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.ThemeCardInUserData;
import com.baidu.tbadk.data.IconData;
import com.baidu.tieba.t;
import java.util.ArrayList;
import tbclient.VideoInfo;
/* loaded from: classes.dex */
public class fa extends bw<com.baidu.tbadk.core.data.ax, fe> {
    private int bkF;
    private int bkG;

    public fa(BaseActivity<?> baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
        this.bkG = 0;
        this.bkF = 0;
        this.bkG = com.baidu.adp.lib.util.k.c(this.bek.getPageContext().getPageActivity(), t.e.ds38);
        this.bkF = com.baidu.adp.lib.util.k.c(this.bek.getPageContext().getPageActivity(), t.e.ds24);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: B */
    public fe b(ViewGroup viewGroup) {
        return new fe(LayoutInflater.from(this.mContext).inflate(t.h.frs_item_xiaoying, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bw, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.ax axVar, fe feVar) {
        super.a(i, view, viewGroup, (ViewGroup) axVar, (com.baidu.tbadk.core.data.ax) feVar);
        return a(i, view, axVar, feVar);
    }

    private View a(int i, View view, com.baidu.tbadk.core.data.ax axVar, fe feVar) {
        fb fbVar = new fb(this, axVar);
        fc fcVar = new fc(this, axVar);
        a(axVar, feVar);
        c(axVar, feVar);
        d(axVar, feVar);
        g(axVar, feVar);
        a(axVar, feVar, fbVar);
        a(axVar, feVar, i);
        a(axVar, feVar, i, fcVar);
        f(axVar, feVar);
        e(axVar, feVar);
        b(axVar, feVar);
        ch.a(this.bek, feVar.bmx, feVar.bfG, feVar.adG, feVar.bkV, feVar.bkW, feVar.bmC, feVar.bkU, view, axVar, this.mSkinType, fbVar, this.biy);
        a(view, feVar);
        return view;
    }

    private void a(com.baidu.tbadk.core.data.ax axVar, fe feVar) {
        MetaData author;
        if (axVar != null && feVar != null && (author = axVar.getAuthor()) != null) {
            ThemeCardInUserData themeCard = author.getThemeCard();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) feVar.bmx.getLayoutParams();
                layoutParams.topMargin = this.bkF;
                feVar.bkR.setVisibility(8);
                feVar.bmx.setLayoutParams(layoutParams);
            } else {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) feVar.bmx.getLayoutParams();
                layoutParams2.topMargin = this.bkG;
                feVar.bkR.setVisibility(0);
                feVar.bkR.setImageBitmap(null);
                feVar.bkR.c(themeCard.getCardImageUrlAndroid(), 10, false);
                feVar.bmx.setLayoutParams(layoutParams2);
            }
            feVar.bkR.setOnClickListener(new fd(this, themeCard));
        }
    }

    private void b(com.baidu.tbadk.core.data.ax axVar, fe feVar) {
        if (axVar != null && feVar != null) {
            if (axVar.getPraise() != null && axVar.getPraise().getNum() > 0) {
                feVar.adj.setVisibility(0);
                feVar.adj.setText(com.baidu.tbadk.core.util.ay.B(axVar.getPraise().getNum()));
            } else {
                feVar.adj.setVisibility(8);
            }
            com.baidu.tieba.graffiti.d.aj(feVar.adj);
            int reply_num = axVar.getReply_num();
            if (reply_num > 0) {
                feVar.bfK.setVisibility(0);
                feVar.bfK.setText(com.baidu.tbadk.core.util.ay.B(reply_num));
                return;
            }
            feVar.bfK.setVisibility(8);
        }
    }

    private void c(com.baidu.tbadk.core.data.ax axVar, fe feVar) {
        if (axVar != null && feVar != null) {
            feVar.adg.setText(com.baidu.tbadk.core.util.ay.x(axVar.getLast_time_int() * 1000));
        }
    }

    private void d(com.baidu.tbadk.core.data.ax axVar, fe feVar) {
        if (axVar != null && axVar.getAuthor() != null && feVar != null) {
            feVar.adG.setText(axVar.getAuthor().getUserName());
        }
    }

    private void e(com.baidu.tbadk.core.data.ax axVar, fe feVar) {
        VideoInfo rb;
        if (axVar != null && feVar != null && (rb = axVar.rb()) != null) {
            if (com.baidu.tbadk.core.l.ob().oh() && !StringUtils.isNull(rb.video_url)) {
                feVar.bmD.setVisibility(0);
                feVar.bmA.c(rb.thumbnail_url, 13, false);
            } else {
                feVar.bmD.setVisibility(8);
            }
            int intValue = rb.play_count.intValue() > 0 ? rb.play_count.intValue() : 0;
            if (intValue > 0) {
                feVar.bmF.setText(String.format(this.bek.getResources().getString(t.j.frs_video_play_count_text), com.baidu.tbadk.core.util.ay.A(intValue)));
                feVar.bmF.setVisibility(0);
                return;
            }
            feVar.bmF.setVisibility(8);
        }
    }

    private void f(com.baidu.tbadk.core.data.ax axVar, fe feVar) {
        if (axVar != null && feVar != null) {
            if (axVar.qZ() == 1) {
                feVar.aOG.setVisibility(8);
                return;
            }
            com.baidu.tieba.tbadkCore.util.s readThreadHistory = TbadkCoreApplication.m11getInst().getReadThreadHistory();
            feVar.aOG.setVisibility(0);
            axVar.parser_title();
            feVar.aOG.setText(axVar.getSpan_str());
            if (readThreadHistory != null && readThreadHistory.od(axVar.getId())) {
                com.baidu.tbadk.core.util.at.c(feVar.aOG, t.d.cp_cont_c, 1);
            } else {
                com.baidu.tbadk.core.util.at.c(feVar.aOG, t.d.cp_cont_b, 1);
            }
        }
    }

    private void a(com.baidu.tbadk.core.data.ax axVar, fe feVar, int i, View.OnClickListener onClickListener) {
        if (axVar != null && feVar != null && i >= 0 && axVar.getAuthor() != null) {
            ArrayList<IconData> tShowInfoNew = axVar.getAuthor().getTShowInfoNew();
            if (tShowInfoNew != null && tShowInfoNew.size() > 0) {
                feVar.adH.setVisibility(0);
                com.baidu.tbadk.core.util.at.c(feVar.adG, t.d.cp_cont_h, 1);
                feVar.adH.setTag(Integer.valueOf(i));
                feVar.adH.setOnClickListener(onClickListener);
                feVar.adH.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(t.e.small_icon_width), this.mContext.getResources().getDimensionPixelSize(t.e.small_icon_height), this.mContext.getResources().getDimensionPixelSize(t.e.small_icon_margin), true);
                return;
            }
            feVar.adH.setVisibility(8);
            com.baidu.tbadk.core.util.at.c(feVar.adG, t.d.cp_cont_c, 1);
        }
    }

    private void a(com.baidu.tbadk.core.data.ax axVar, fe feVar, int i) {
        if (axVar != null && axVar.getAuthor() != null) {
            ArrayList<IconData> iconInfo = axVar.getAuthor().getIconInfo();
            if (iconInfo != null && iconInfo.size() > 0) {
                feVar.adI.setVisibility(0);
                com.baidu.tbadk.core.util.at.c(feVar.adG, t.d.cp_cont_h, 1);
                feVar.adI.setTag(Integer.valueOf(i));
                feVar.adI.setOnClickListener(null);
                feVar.adI.a(iconInfo, 3, this.mContext.getResources().getDimensionPixelSize(t.e.ds30), this.mContext.getResources().getDimensionPixelSize(t.e.ds30), this.mContext.getResources().getDimensionPixelSize(t.e.ds10), true);
                feVar.adI.setOnClickListener(null);
                return;
            }
            feVar.adI.setVisibility(8);
            com.baidu.tbadk.core.util.at.c(feVar.adG, t.d.cp_cont_c, 1);
        }
    }

    private void a(com.baidu.tbadk.core.data.ax axVar, fe feVar, View.OnClickListener onClickListener) {
        boolean g = g(axVar);
        if (axVar == null || axVar.getAuthor() == null || !com.baidu.tbadk.core.l.ob().od() || g) {
            feVar.bfG.setVisibility(8);
        } else {
            feVar.bfG.setVisibility(0);
            String portrait = axVar.getAuthor().getPortrait();
            feVar.bfG.setUserId(axVar.getAuthor().getUserId());
            feVar.bfG.setImageDrawable(null);
            feVar.bfG.setOnClickListener(onClickListener);
            feVar.bfG.c(portrait, 28, false);
        }
        feVar.bmC.setOnClickListener(onClickListener);
    }

    private void g(com.baidu.tbadk.core.data.ax axVar, fe feVar) {
        if (axVar != null && !axVar.ri() && !StringUtils.isNull(axVar.getAddress())) {
            feVar.bmy.setText(axVar.getAddress());
            feVar.bmy.setVisibility(0);
            feVar.bmz.setVisibility(0);
            return;
        }
        feVar.bmy.setVisibility(8);
        feVar.bmz.setVisibility(8);
    }

    private void a(View view, fe feVar) {
        if (this.bek != null && this.bek.getLayoutMode() != null && feVar.aej != this.mSkinType) {
            feVar.aej = this.mSkinType;
            this.bek.getLayoutMode().ae(this.mSkinType == 1);
            this.bek.getLayoutMode().x(view);
        }
    }

    private boolean g(com.baidu.tbadk.core.data.ax axVar) {
        return (axVar == null || axVar.getAuthor() == null || axVar.getAuthor().getGodInfo() == null || axVar.getAuthor().getGodInfo().type.intValue() != 2) ? false : true;
    }
}
