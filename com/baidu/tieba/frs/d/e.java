package com.baidu.tieba.frs.d;

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
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.data.GodUserData;
import com.baidu.tieba.frs.ar;
import com.baidu.tieba.frs.bt;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class e {
    private static final int bZW = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds76);
    private static final int bZX = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds88);
    private static final int bZY = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds4);
    private static final int aip = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds6);
    private static final int bZZ = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds50);
    private static final int caa = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds108);
    private static final int cab = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds128);
    private static final int cac = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.fontsize28);
    private static final int cad = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.fontsize24);
    private static final String cae = TbadkCoreApplication.m9getInst().getString(w.l.relate_forum_is_followed);
    private static final String caf = TbadkCoreApplication.m9getInst().getString(w.l.attention);

    public static boolean a(TbPageContext<?> tbPageContext, View view, HeadImageView headImageView, TextView textView, View view2, View view3, RelativeLayout relativeLayout, LinearLayout linearLayout, View view4, bk bkVar, int i, View.OnClickListener onClickListener, com.baidu.tieba.frs.o oVar, BdUniqueId bdUniqueId) {
        MetaData author;
        GodUserData godUserData;
        ClickableHeaderImageView clickableHeaderImageView;
        TextView textView2;
        TextView textView3;
        ar arVar;
        View view5;
        if (tbPageContext == null || view == null || headImageView == null || textView == null || view2 == null || view3 == null || relativeLayout == null || linearLayout == null || view4 == null || bkVar == null || onClickListener == null || (author = bkVar.getAuthor()) == null || (godUserData = author.getGodUserData()) == null) {
            return false;
        }
        boolean z = false;
        if (godUserData.getType() == 2) {
            z = true;
        }
        if (z) {
            if (bkVar.getFid() != 0 && !bt.aad().e(bkVar.getFid(), bkVar.getId())) {
                bt.aad().d(bkVar.getFid(), bkVar.getId());
                TiebaStatic.log(new as("c10633").aa("tid", bkVar.getId()).aa("fid", String.valueOf(bkVar.getFid())));
            }
            f fVar = new f(author, onClickListener);
            g gVar = new g(tbPageContext, bkVar, author, z, bdUniqueId);
            relativeLayout.setOnClickListener(null);
            relativeLayout.setClickable(false);
            headImageView.setVisibility(8);
            textView.setOnClickListener(fVar);
            view2.setVisibility(8);
            view3.setVisibility(8);
            View findViewWithTag = relativeLayout.findViewWithTag("frs_god_fans_count_tag");
            if (findViewWithTag == null || !(findViewWithTag instanceof TextView)) {
                TextView textView4 = new TextView(tbPageContext.getPageActivity());
                textView4.setTextSize(0, cad);
                textView4.setSingleLine(true);
                textView4.setIncludeFontPadding(false);
                textView4.setGravity(16);
                textView4.setTag("frs_god_fans_count_tag");
                relativeLayout.addView(textView4);
                clickableHeaderImageView = new ClickableHeaderImageView(tbPageContext.getPageActivity());
                clickableHeaderImageView.setPageId(bdUniqueId);
                clickableHeaderImageView.setGodIconMargin(0);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(bZW, bZW);
                layoutParams.addRule(9);
                clickableHeaderImageView.setTag("frs_god_head_image_view_tag");
                relativeLayout.addView(clickableHeaderImageView, layoutParams);
                linearLayout.setPadding(bZX, linearLayout.getPaddingTop(), linearLayout.getPaddingRight(), linearLayout.getPaddingBottom());
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams2.addRule(11);
                layoutParams2.addRule(10);
                layoutParams2.topMargin = aip;
                TextView textView5 = new TextView(tbPageContext.getPageActivity());
                textView5.setTag("frs_god_btn_attention_love_tag");
                textView5.setId(w.h.btn_add_friend);
                textView5.setLayoutParams(layoutParams2);
                textView5.setTextSize(0, cad);
                textView5.setWidth(caa);
                textView5.setHeight(bZZ);
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
            layoutParams3.topMargin = bZY;
            layoutParams3.rightMargin = bZZ;
            layoutParams3.addRule(5, w.h.frs_user_tshow_icon_box);
            layoutParams3.addRule(3, w.h.frs_item_loc_view);
            if (clickableHeaderImageView != null) {
                if (com.baidu.tbadk.core.r.oV().oX()) {
                    clickableHeaderImageView.setVisibility(0);
                    linearLayout.setPadding(bZX, linearLayout.getPaddingTop(), cab, linearLayout.getPaddingBottom());
                    layoutParams3.leftMargin = bZX;
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
                if (!E(bkVar)) {
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
                    arVar = null;
                } else {
                    view5 = viewStub.inflate();
                    arVar = new ar(view5);
                    view5.setTag(arVar);
                }
            } else {
                findViewById.setVisibility(0);
                arVar = (ar) findViewById.getTag();
                view5 = findViewById;
            }
            if (arVar == null) {
                return false;
            }
            if (!bkVar.sd() && !TextUtils.isEmpty(bkVar.getAddress()) && !TextUtils.isEmpty(bkVar.getAddress().trim())) {
                arVar.bPs.setVisibility(0);
                arVar.bPs.setText(bkVar.getAddress());
            } else {
                arVar.bPs.setVisibility(8);
            }
            if (bkVar.ro() != null && bkVar.ro().getNum() > 0) {
                arVar.alH.setVisibility(0);
                arVar.alH.setText(au.t(bkVar.ro().getNum()));
            } else {
                arVar.alH.setVisibility(8);
            }
            com.baidu.tieba.graffiti.c.aj(arVar.alH);
            int rr = bkVar.rr();
            if (rr > 0) {
                arVar.bPt.setVisibility(0);
                arVar.bPt.setText(au.x(rr));
            } else {
                arVar.bPt.setVisibility(8);
            }
            arVar.alE.setText(au.q(bkVar.rt() * 1000));
            if (arVar.ane != i) {
                aq.j(textView2, w.g.icon_arrow_list);
                aq.c(textView3, w.e.cp_cont_d, 1);
                a(textView2, godUserData.getIsLike(), oVar);
                tbPageContext.getLayoutMode().t(view5);
                arVar.ane = i;
            }
            return true;
        }
        relativeLayout.setOnClickListener(onClickListener);
        if (com.baidu.tbadk.core.r.oV().oX()) {
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
            textView.setText(cae);
            textView.setBackgroundDrawable(null);
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            textView.setPadding(0, 0, 0, 0);
            return;
        }
        aq.c(textView, w.e.btn_forum_focus_color, 1);
        textView.setText(caf);
        if (oVar != null) {
            textView.setBackgroundDrawable(oVar.v(w.g.btn_focus_border_bg, TbadkCoreApplication.m9getInst().getSkinType()));
            textView.setCompoundDrawablesWithIntrinsicBounds(oVar.v(w.g.btn_focus_cross_bg, TbadkCoreApplication.m9getInst().getSkinType()), (Drawable) null, (Drawable) null, (Drawable) null);
        } else {
            aq.j(textView, w.g.btn_focus_border_bg);
            textView.setCompoundDrawablesWithIntrinsicBounds(aq.getDrawable(w.g.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        textView.setClickable(true);
        textView.setPadding(TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds18), 0, TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds10), 0);
    }

    private static boolean E(bk bkVar) {
        return (bkVar == null || bkVar.getAuthor() == null || bkVar.getAuthor().getUserId() == null || TbadkCoreApplication.getCurrentAccount() == null || !TbadkCoreApplication.getCurrentAccount().equals(bkVar.getAuthor().getUserId())) ? false : true;
    }
}
