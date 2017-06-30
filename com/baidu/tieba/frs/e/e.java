package com.baidu.tieba.frs.e;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.bm;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.data.GodUserData;
import com.baidu.tieba.frs.at;
import com.baidu.tieba.frs.bv;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class e {
    private static final int coy = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds76);
    private static final int coz = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds88);
    private static final int coA = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds4);
    private static final int aiI = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds6);
    private static final int coB = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds50);
    private static final int coC = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds108);
    private static final int coD = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds128);
    private static final int coE = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.fontsize28);
    private static final int coF = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.fontsize24);
    private static final String coG = TbadkCoreApplication.m9getInst().getString(w.l.relate_forum_is_followed);
    private static final String coH = TbadkCoreApplication.m9getInst().getString(w.l.attention);

    public static boolean a(TbPageContext<?> tbPageContext, View view, HeadImageView headImageView, TextView textView, View view2, View view3, RelativeLayout relativeLayout, LinearLayout linearLayout, View view4, bm bmVar, int i, View.OnClickListener onClickListener, com.baidu.tieba.frs.o oVar, BdUniqueId bdUniqueId) {
        MetaData author;
        GodUserData godUserData;
        ClickableHeaderImageView clickableHeaderImageView;
        TextView textView2;
        TextView textView3;
        at atVar;
        View view5;
        if (tbPageContext == null || view == null || headImageView == null || textView == null || view2 == null || view3 == null || relativeLayout == null || linearLayout == null || view4 == null || bmVar == null || onClickListener == null || (author = bmVar.getAuthor()) == null || (godUserData = author.getGodUserData()) == null) {
            return false;
        }
        boolean z = false;
        if (godUserData.getType() == 2) {
            z = true;
        }
        if (z) {
            if (bmVar.getFid() != 0 && !bv.aeW().e(bmVar.getFid(), bmVar.getId())) {
                bv.aeW().d(bmVar.getFid(), bmVar.getId());
                TiebaStatic.log(new au("c10633").Z("tid", bmVar.getId()).Z("fid", String.valueOf(bmVar.getFid())));
            }
            f fVar = new f(author, onClickListener);
            g gVar = new g(tbPageContext, bmVar, author, z, bdUniqueId);
            relativeLayout.setOnClickListener(null);
            relativeLayout.setClickable(false);
            headImageView.setVisibility(8);
            textView.setOnClickListener(fVar);
            view2.setVisibility(8);
            view3.setVisibility(8);
            View findViewWithTag = relativeLayout.findViewWithTag("frs_god_fans_count_tag");
            if (findViewWithTag == null || !(findViewWithTag instanceof TextView)) {
                TextView textView4 = new TextView(tbPageContext.getPageActivity());
                textView4.setTextSize(0, coF);
                textView4.setSingleLine(true);
                textView4.setIncludeFontPadding(false);
                textView4.setGravity(16);
                textView4.setTag("frs_god_fans_count_tag");
                relativeLayout.addView(textView4);
                clickableHeaderImageView = new ClickableHeaderImageView(tbPageContext.getPageActivity());
                clickableHeaderImageView.setPageId(bdUniqueId);
                clickableHeaderImageView.setGodIconMargin(0);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(coy, coy);
                layoutParams.addRule(9);
                clickableHeaderImageView.setTag("frs_god_head_image_view_tag");
                relativeLayout.addView(clickableHeaderImageView, layoutParams);
                linearLayout.setPadding(coz, linearLayout.getPaddingTop(), linearLayout.getPaddingRight(), linearLayout.getPaddingBottom());
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams2.addRule(11);
                layoutParams2.addRule(10);
                layoutParams2.topMargin = aiI;
                TextView textView5 = new TextView(tbPageContext.getPageActivity());
                textView5.setTag("frs_god_btn_attention_love_tag");
                textView5.setId(w.h.btn_add_friend);
                textView5.setLayoutParams(layoutParams2);
                textView5.setTextSize(0, coF);
                textView5.setWidth(coC);
                textView5.setHeight(coB);
                textView5.setGravity(17);
                relativeLayout.addView(textView5);
                textView2 = textView5;
                textView3 = textView4;
            } else {
                TextView textView6 = (TextView) findViewWithTag;
                textView6.setVisibility(0);
                clickableHeaderImageView = (ClickableHeaderImageView) relativeLayout.findViewWithTag("frs_god_head_image_view_tag");
                textView2 = (TextView) relativeLayout.findViewWithTag("frs_god_btn_attention_love_tag");
                textView3 = textView6;
            }
            if (textView2 != null) {
                textView2.setOnClickListener(gVar);
            }
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams3.topMargin = coA;
            layoutParams3.rightMargin = coB;
            layoutParams3.addRule(5, w.h.frs_user_tshow_icon_box);
            layoutParams3.addRule(3, w.h.frs_item_loc_view);
            if (clickableHeaderImageView != null) {
                if (com.baidu.tbadk.core.r.oK().oM()) {
                    clickableHeaderImageView.setVisibility(0);
                    linearLayout.setPadding(coz, linearLayout.getPaddingTop(), coD, linearLayout.getPaddingBottom());
                    layoutParams3.leftMargin = coz;
                    clickableHeaderImageView.setOnClickListener(onClickListener);
                    clickableHeaderImageView.c(author.getPortrait(), 28, false);
                } else {
                    clickableHeaderImageView.setVisibility(8);
                    linearLayout.setPadding(0, linearLayout.getPaddingTop(), 0, linearLayout.getPaddingBottom());
                    layoutParams3.leftMargin = 0;
                }
            }
            textView3.setLayoutParams(layoutParams3);
            textView3.setText(String.format(tbPageContext.getResources().getString(w.l.fans_default_name_god_user), aw.t(author.getFansNum())));
            textView3.setOnClickListener(onClickListener);
            if (textView2 != null) {
                if (!K(bmVar)) {
                    if (godUserData.getIsFromNetWork()) {
                        if (godUserData.getIsLike()) {
                            textView2.setVisibility(8);
                        } else {
                            textView2.setVisibility(0);
                            a(textView2, godUserData.getIsLike(), oVar);
                        }
                    } else {
                        textView2.setVisibility(0);
                        a(textView2, godUserData.getIsLike(), oVar);
                    }
                } else {
                    textView2.setVisibility(8);
                }
            }
            View findViewById = view4.findViewById(w.h.frs_god_extra_info);
            if (findViewById == null) {
                ViewStub viewStub = (ViewStub) view4.findViewById(w.h.frs_god_extra_vs);
                if (viewStub == null) {
                    view5 = findViewById;
                    atVar = null;
                } else {
                    view5 = viewStub.inflate();
                    atVar = new at(view5);
                    view5.setTag(atVar);
                }
            } else {
                findViewById.setVisibility(0);
                atVar = (at) findViewById.getTag();
                view5 = findViewById;
            }
            if (atVar == null) {
                return false;
            }
            if (!bmVar.rW() && !TextUtils.isEmpty(bmVar.getAddress()) && !TextUtils.isEmpty(bmVar.getAddress().trim())) {
                atVar.cdr.setVisibility(0);
                atVar.cdr.setText(bmVar.getAddress());
            } else {
                atVar.cdr.setVisibility(8);
            }
            if (bmVar.rh() != null && bmVar.rh().getNum() > 0) {
                atVar.aml.setVisibility(0);
                atVar.aml.setText(aw.t(bmVar.rh().getNum()));
            } else {
                atVar.aml.setVisibility(8);
            }
            com.baidu.tieba.graffiti.c.al(atVar.aml);
            int rj = bmVar.rj();
            if (rj > 0) {
                atVar.cds.setVisibility(0);
                atVar.cds.setText(aw.y(rj));
            } else {
                atVar.cds.setVisibility(8);
            }
            atVar.ami.setText(aw.q(bmVar.rl() * 1000));
            if (atVar.aoa != i) {
                as.j(textView2, w.g.icon_arrow_list);
                as.c(textView3, w.e.cp_cont_d, 1);
                a(textView2, godUserData.getIsLike(), oVar);
                tbPageContext.getLayoutMode().t(view5);
                atVar.aoa = i;
            }
            return true;
        }
        relativeLayout.setOnClickListener(onClickListener);
        if (com.baidu.tbadk.core.r.oK().oM()) {
            headImageView.setVisibility(0);
        }
        textView.setOnClickListener(onClickListener);
        view2.setVisibility(0);
        view3.setVisibility(0);
        View findViewWithTag2 = relativeLayout.findViewWithTag("frs_god_fans_count_tag");
        linearLayout.setPadding(0, linearLayout.getPaddingTop(), 0, linearLayout.getPaddingBottom());
        if (findViewWithTag2 != null) {
            findViewWithTag2.setVisibility(8);
        }
        View findViewById2 = view4.findViewById(w.h.frs_god_extra_info);
        if (findViewById2 != null) {
            findViewById2.setVisibility(8);
        }
        View findViewWithTag3 = relativeLayout.findViewWithTag("frs_god_btn_attention_love_tag");
        if (findViewWithTag3 != null) {
            findViewWithTag3.setVisibility(8);
            findViewWithTag3.setOnClickListener(null);
        }
        View findViewWithTag4 = relativeLayout.findViewWithTag("frs_god_head_image_view_tag");
        if (findViewWithTag4 != null) {
            findViewWithTag4.setVisibility(8);
            findViewWithTag4.setOnClickListener(null);
        }
        return false;
    }

    private static void a(TextView textView, boolean z, com.baidu.tieba.frs.o oVar) {
        if (z) {
            textView.setClickable(false);
            as.c(textView, w.e.cp_cont_d, 1);
            textView.setText(coG);
            textView.setBackgroundDrawable(null);
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            textView.setPadding(0, 0, 0, 0);
            return;
        }
        as.c(textView, w.e.btn_forum_focus_color, 1);
        textView.setText(coH);
        if (oVar != null) {
            textView.setBackgroundDrawable(oVar.u(w.g.btn_focus_border_bg, TbadkCoreApplication.m9getInst().getSkinType()));
            textView.setCompoundDrawablesWithIntrinsicBounds(oVar.u(w.g.btn_focus_cross_bg, TbadkCoreApplication.m9getInst().getSkinType()), (Drawable) null, (Drawable) null, (Drawable) null);
        } else {
            as.j(textView, w.g.btn_focus_border_bg);
            textView.setCompoundDrawablesWithIntrinsicBounds(as.getDrawable(w.g.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        textView.setClickable(true);
        textView.setPadding(TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds18), 0, TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds10), 0);
    }

    private static boolean K(bm bmVar) {
        return (bmVar == null || bmVar.getAuthor() == null || bmVar.getAuthor().getUserId() == null || TbadkCoreApplication.getCurrentAccount() == null || !TbadkCoreApplication.getCurrentAccount().equals(bmVar.getAuthor().getUserId())) ? false : true;
    }
}
