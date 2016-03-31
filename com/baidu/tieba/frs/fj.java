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
public class fj extends bx<com.baidu.tbadk.core.data.as, fn> {
    private int bpo;
    private int bpq;

    /* JADX INFO: Access modifiers changed from: protected */
    public fj(BaseActivity<?> baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
        this.bpq = 0;
        this.bpo = 0;
        this.bpq = com.baidu.adp.lib.util.k.c(this.bix.getPageContext().getPageActivity(), t.e.ds38);
        this.bpo = com.baidu.adp.lib.util.k.c(this.bix.getPageContext().getPageActivity(), t.e.ds24);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: I */
    public fn b(ViewGroup viewGroup) {
        return new fn(LayoutInflater.from(this.mContext).inflate(t.h.frs_item_xiaoying, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bx, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.as asVar, fn fnVar) {
        super.a(i, view, viewGroup, (ViewGroup) asVar, (com.baidu.tbadk.core.data.as) fnVar);
        return a(i, view, asVar, fnVar);
    }

    private View a(int i, View view, com.baidu.tbadk.core.data.as asVar, fn fnVar) {
        fk fkVar = new fk(this, asVar);
        fl flVar = new fl(this, asVar);
        a(asVar, fnVar);
        c(asVar, fnVar);
        d(asVar, fnVar);
        g(asVar, fnVar);
        a(asVar, fnVar, fkVar);
        a(asVar, fnVar, i);
        a(asVar, fnVar, i, flVar);
        f(asVar, fnVar);
        e(asVar, fnVar);
        b(asVar, fnVar);
        ci.a(this.bix, fnVar.brj, fnVar.bjG, fnVar.ahM, fnVar.bpF, fnVar.bpG, fnVar.bro, fnVar.bpE, view, asVar, this.mSkinType, fkVar, this.bmj);
        a(view, fnVar);
        return view;
    }

    private void a(com.baidu.tbadk.core.data.as asVar, fn fnVar) {
        MetaData author;
        if (asVar != null && fnVar != null && (author = asVar.getAuthor()) != null) {
            ThemeCardInUserData themeCard = author.getThemeCard();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) fnVar.brj.getLayoutParams();
                layoutParams.topMargin = this.bpo;
                fnVar.bpB.setVisibility(8);
                fnVar.brj.setLayoutParams(layoutParams);
            } else {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) fnVar.brj.getLayoutParams();
                layoutParams2.topMargin = this.bpq;
                fnVar.bpB.setVisibility(0);
                fnVar.bpB.setImageBitmap(null);
                fnVar.bpB.c(themeCard.getCardImageUrlAndroid(), 10, false);
                fnVar.brj.setLayoutParams(layoutParams2);
            }
            fnVar.bpB.setOnClickListener(new fm(this, themeCard));
        }
    }

    private void b(com.baidu.tbadk.core.data.as asVar, fn fnVar) {
        if (asVar != null && fnVar != null) {
            if (asVar.getPraise() != null && asVar.getPraise().getNum() > 0) {
                fnVar.ahs.setVisibility(0);
                fnVar.ahs.setText(com.baidu.tbadk.core.util.ay.A(asVar.getPraise().getNum()));
            } else {
                fnVar.ahs.setVisibility(8);
            }
            com.baidu.tieba.graffiti.d.af(fnVar.ahs);
            int reply_num = asVar.getReply_num();
            if (reply_num > 0) {
                fnVar.bjK.setVisibility(0);
                fnVar.bjK.setText(com.baidu.tbadk.core.util.ay.A(reply_num));
                return;
            }
            fnVar.bjK.setVisibility(8);
        }
    }

    private void c(com.baidu.tbadk.core.data.as asVar, fn fnVar) {
        if (asVar != null && fnVar != null) {
            fnVar.ahr.setText(com.baidu.tbadk.core.util.ay.w(asVar.getLast_time_int() * 1000));
        }
    }

    private void d(com.baidu.tbadk.core.data.as asVar, fn fnVar) {
        if (asVar != null && asVar.getAuthor() != null && fnVar != null) {
            fnVar.ahM.setText(asVar.getAuthor().getUserName());
        }
    }

    private void e(com.baidu.tbadk.core.data.as asVar, fn fnVar) {
        VideoInfo tC;
        if (asVar != null && fnVar != null && (tC = asVar.tC()) != null) {
            if (com.baidu.tbadk.core.l.qE().qK() && !StringUtils.isNull(tC.video_url)) {
                fnVar.brp.setVisibility(0);
                fnVar.brm.c(tC.thumbnail_url, 13, false);
            } else {
                fnVar.brp.setVisibility(8);
            }
            int intValue = tC.play_count.intValue() > 0 ? tC.play_count.intValue() : 0;
            if (intValue > 0) {
                fnVar.brr.setText(String.format(this.bix.getResources().getString(t.j.frs_video_play_count_text), com.baidu.tbadk.core.util.ay.z(intValue)));
                fnVar.brr.setVisibility(0);
                return;
            }
            fnVar.brr.setVisibility(8);
        }
    }

    private void f(com.baidu.tbadk.core.data.as asVar, fn fnVar) {
        if (asVar != null && fnVar != null) {
            if (asVar.tA() == 1) {
                fnVar.aSh.setVisibility(8);
                return;
            }
            com.baidu.tieba.tbadkCore.util.s readThreadHistory = TbadkCoreApplication.m411getInst().getReadThreadHistory();
            fnVar.aSh.setVisibility(0);
            asVar.parser_title();
            fnVar.aSh.setText(asVar.getSpan_str());
            if (readThreadHistory != null && readThreadHistory.oh(asVar.getId())) {
                com.baidu.tbadk.core.util.at.b(fnVar.aSh, t.d.cp_cont_c, 1);
            } else {
                com.baidu.tbadk.core.util.at.b(fnVar.aSh, t.d.cp_cont_b, 1);
            }
        }
    }

    private void a(com.baidu.tbadk.core.data.as asVar, fn fnVar, int i, View.OnClickListener onClickListener) {
        if (asVar != null && fnVar != null && i >= 0 && asVar.getAuthor() != null) {
            ArrayList<IconData> tShowInfoNew = asVar.getAuthor().getTShowInfoNew();
            if (tShowInfoNew != null && tShowInfoNew.size() > 0) {
                fnVar.ahN.setVisibility(0);
                com.baidu.tbadk.core.util.at.b(fnVar.ahM, t.d.cp_cont_h, 1);
                fnVar.ahN.setTag(Integer.valueOf(i));
                fnVar.ahN.setOnClickListener(onClickListener);
                fnVar.ahN.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(t.e.small_icon_width), this.mContext.getResources().getDimensionPixelSize(t.e.small_icon_height), this.mContext.getResources().getDimensionPixelSize(t.e.small_icon_margin), true);
                return;
            }
            fnVar.ahN.setVisibility(8);
            com.baidu.tbadk.core.util.at.b(fnVar.ahM, t.d.cp_cont_c, 1);
        }
    }

    private void a(com.baidu.tbadk.core.data.as asVar, fn fnVar, int i) {
        if (asVar != null && asVar.getAuthor() != null) {
            ArrayList<IconData> iconInfo = asVar.getAuthor().getIconInfo();
            if (iconInfo != null && iconInfo.size() > 0) {
                fnVar.ahO.setVisibility(0);
                com.baidu.tbadk.core.util.at.b(fnVar.ahM, t.d.cp_cont_h, 1);
                fnVar.ahO.setTag(Integer.valueOf(i));
                fnVar.ahO.setOnClickListener(null);
                fnVar.ahO.a(iconInfo, 3, this.mContext.getResources().getDimensionPixelSize(t.e.ds30), this.mContext.getResources().getDimensionPixelSize(t.e.ds30), this.mContext.getResources().getDimensionPixelSize(t.e.ds10), true);
                fnVar.ahO.setOnClickListener(null);
                return;
            }
            fnVar.ahO.setVisibility(8);
            com.baidu.tbadk.core.util.at.b(fnVar.ahM, t.d.cp_cont_c, 1);
        }
    }

    private void a(com.baidu.tbadk.core.data.as asVar, fn fnVar, View.OnClickListener onClickListener) {
        boolean g = g(asVar);
        if (asVar == null || asVar.getAuthor() == null || !com.baidu.tbadk.core.l.qE().qG() || g) {
            fnVar.bjG.setVisibility(8);
        } else {
            fnVar.bjG.setVisibility(0);
            String portrait = asVar.getAuthor().getPortrait();
            fnVar.bjG.setUserId(asVar.getAuthor().getUserId());
            fnVar.bjG.setImageDrawable(null);
            fnVar.bjG.setOnClickListener(onClickListener);
            fnVar.bjG.c(portrait, 28, false);
        }
        fnVar.bro.setOnClickListener(onClickListener);
    }

    private void g(com.baidu.tbadk.core.data.as asVar, fn fnVar) {
        if (asVar != null && !asVar.tJ() && !StringUtils.isNull(asVar.getAddress())) {
            fnVar.brk.setText(asVar.getAddress());
            fnVar.brk.setVisibility(0);
            fnVar.brl.setVisibility(0);
            return;
        }
        fnVar.brk.setVisibility(8);
        fnVar.brl.setVisibility(8);
    }

    private void a(View view, fn fnVar) {
        if (this.bix != null && this.bix.getLayoutMode() != null && fnVar.aik != this.mSkinType) {
            fnVar.aik = this.mSkinType;
            this.bix.getLayoutMode().ab(this.mSkinType == 1);
            this.bix.getLayoutMode().x(view);
        }
    }

    private boolean g(com.baidu.tbadk.core.data.as asVar) {
        return (asVar == null || asVar.getAuthor() == null || asVar.getAuthor().getGodInfo() == null || asVar.getAuthor().getGodInfo().type.intValue() != 2) ? false : true;
    }
}
