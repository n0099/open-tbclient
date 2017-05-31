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
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.data.GodUserData;
import com.baidu.tieba.frs.as;
import com.baidu.tieba.frs.bu;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class e {
    private static final int cgi = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds76);
    private static final int cgj = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds88);
    private static final int cgk = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds4);
    private static final int aia = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds6);
    private static final int cgl = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds50);
    private static final int cgm = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds108);
    private static final int cgn = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds128);
    private static final int cgo = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.fontsize28);
    private static final int cgp = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.fontsize24);
    private static final String cgq = TbadkCoreApplication.m9getInst().getString(w.l.relate_forum_is_followed);
    private static final String cgr = TbadkCoreApplication.m9getInst().getString(w.l.attention);

    public static boolean a(TbPageContext<?> tbPageContext, View view, HeadImageView headImageView, TextView textView, View view2, View view3, RelativeLayout relativeLayout, LinearLayout linearLayout, View view4, bl blVar, int i, View.OnClickListener onClickListener, com.baidu.tieba.frs.o oVar, BdUniqueId bdUniqueId) {
        MetaData author;
        GodUserData godUserData;
        ClickableHeaderImageView clickableHeaderImageView;
        TextView textView2;
        TextView textView3;
        as asVar;
        View view5;
        if (tbPageContext == null || view == null || headImageView == null || textView == null || view2 == null || view3 == null || relativeLayout == null || linearLayout == null || view4 == null || blVar == null || onClickListener == null || (author = blVar.getAuthor()) == null || (godUserData = author.getGodUserData()) == null) {
            return false;
        }
        boolean z = false;
        if (godUserData.getType() == 2) {
            z = true;
        }
        if (z) {
            if (blVar.getFid() != 0 && !bu.abf().e(blVar.getFid(), blVar.getId())) {
                bu.abf().d(blVar.getFid(), blVar.getId());
                TiebaStatic.log(new com.baidu.tbadk.core.util.as("c10633").Z("tid", blVar.getId()).Z("fid", String.valueOf(blVar.getFid())));
            }
            f fVar = new f(author, onClickListener);
            g gVar = new g(tbPageContext, blVar, author, z, bdUniqueId);
            relativeLayout.setOnClickListener(null);
            relativeLayout.setClickable(false);
            headImageView.setVisibility(8);
            textView.setOnClickListener(fVar);
            view2.setVisibility(8);
            view3.setVisibility(8);
            View findViewWithTag = relativeLayout.findViewWithTag("frs_god_fans_count_tag");
            if (findViewWithTag == null || !(findViewWithTag instanceof TextView)) {
                TextView textView4 = new TextView(tbPageContext.getPageActivity());
                textView4.setTextSize(0, cgp);
                textView4.setSingleLine(true);
                textView4.setIncludeFontPadding(false);
                textView4.setGravity(16);
                textView4.setTag("frs_god_fans_count_tag");
                relativeLayout.addView(textView4);
                clickableHeaderImageView = new ClickableHeaderImageView(tbPageContext.getPageActivity());
                clickableHeaderImageView.setPageId(bdUniqueId);
                clickableHeaderImageView.setGodIconMargin(0);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(cgi, cgi);
                layoutParams.addRule(9);
                clickableHeaderImageView.setTag("frs_god_head_image_view_tag");
                relativeLayout.addView(clickableHeaderImageView, layoutParams);
                linearLayout.setPadding(cgj, linearLayout.getPaddingTop(), linearLayout.getPaddingRight(), linearLayout.getPaddingBottom());
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams2.addRule(11);
                layoutParams2.addRule(10);
                layoutParams2.topMargin = aia;
                TextView textView5 = new TextView(tbPageContext.getPageActivity());
                textView5.setTag("frs_god_btn_attention_love_tag");
                textView5.setId(w.h.btn_add_friend);
                textView5.setLayoutParams(layoutParams2);
                textView5.setTextSize(0, cgp);
                textView5.setWidth(cgm);
                textView5.setHeight(cgl);
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
            layoutParams3.topMargin = cgk;
            layoutParams3.rightMargin = cgl;
            layoutParams3.addRule(5, w.h.frs_user_tshow_icon_box);
            layoutParams3.addRule(3, w.h.frs_item_loc_view);
            if (clickableHeaderImageView != null) {
                if (com.baidu.tbadk.core.r.oN().oP()) {
                    clickableHeaderImageView.setVisibility(0);
                    linearLayout.setPadding(cgj, linearLayout.getPaddingTop(), cgn, linearLayout.getPaddingBottom());
                    layoutParams3.leftMargin = cgj;
                    clickableHeaderImageView.setOnClickListener(onClickListener);
                    clickableHeaderImageView.c(author.getPortrait(), 28, false);
                } else {
                    clickableHeaderImageView.setVisibility(8);
                    linearLayout.setPadding(0, linearLayout.getPaddingTop(), 0, linearLayout.getPaddingBottom());
                    layoutParams3.leftMargin = 0;
                }
            }
            textView3.setLayoutParams(layoutParams3);
            textView3.setText(String.format(tbPageContext.getResources().getString(w.l.fans_default_name_god_user), au.t(author.getFansNum())));
            textView3.setOnClickListener(onClickListener);
            if (textView2 != null) {
                if (!J(blVar)) {
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
                    asVar = null;
                } else {
                    view5 = viewStub.inflate();
                    asVar = new as(view5);
                    view5.setTag(asVar);
                }
            } else {
                findViewById.setVisibility(0);
                asVar = (as) findViewById.getTag();
                view5 = findViewById;
            }
            if (asVar == null) {
                return false;
            }
            if (!blVar.rZ() && !TextUtils.isEmpty(blVar.getAddress()) && !TextUtils.isEmpty(blVar.getAddress().trim())) {
                asVar.bVi.setVisibility(0);
                asVar.bVi.setText(blVar.getAddress());
            } else {
                asVar.bVi.setVisibility(8);
            }
            if (blVar.rk() != null && blVar.rk().getNum() > 0) {
                asVar.alx.setVisibility(0);
                asVar.alx.setText(au.t(blVar.rk().getNum()));
            } else {
                asVar.alx.setVisibility(8);
            }
            com.baidu.tieba.graffiti.c.aj(asVar.alx);
            int rn = blVar.rn();
            if (rn > 0) {
                asVar.bVj.setVisibility(0);
                asVar.bVj.setText(au.x(rn));
            } else {
                asVar.bVj.setVisibility(8);
            }
            asVar.alu.setText(au.q(blVar.rp() * 1000));
            if (asVar.ana != i) {
                aq.j(textView2, w.g.icon_arrow_list);
                aq.c(textView3, w.e.cp_cont_d, 1);
                a(textView2, godUserData.getIsLike(), oVar);
                tbPageContext.getLayoutMode().t(view5);
                asVar.ana = i;
            }
            return true;
        }
        relativeLayout.setOnClickListener(onClickListener);
        if (com.baidu.tbadk.core.r.oN().oP()) {
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
            aq.c(textView, w.e.cp_cont_d, 1);
            textView.setText(cgq);
            textView.setBackgroundDrawable(null);
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            textView.setPadding(0, 0, 0, 0);
            return;
        }
        aq.c(textView, w.e.btn_forum_focus_color, 1);
        textView.setText(cgr);
        if (oVar != null) {
            textView.setBackgroundDrawable(oVar.u(w.g.btn_focus_border_bg, TbadkCoreApplication.m9getInst().getSkinType()));
            textView.setCompoundDrawablesWithIntrinsicBounds(oVar.u(w.g.btn_focus_cross_bg, TbadkCoreApplication.m9getInst().getSkinType()), (Drawable) null, (Drawable) null, (Drawable) null);
        } else {
            aq.j(textView, w.g.btn_focus_border_bg);
            textView.setCompoundDrawablesWithIntrinsicBounds(aq.getDrawable(w.g.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        textView.setClickable(true);
        textView.setPadding(TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds18), 0, TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds10), 0);
    }

    private static boolean J(bl blVar) {
        return (blVar == null || blVar.getAuthor() == null || blVar.getAuthor().getUserId() == null || TbadkCoreApplication.getCurrentAccount() == null || !TbadkCoreApplication.getCurrentAccount().equals(blVar.getAuthor().getUserId())) ? false : true;
    }
}
