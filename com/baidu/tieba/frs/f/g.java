package com.baidu.tieba.frs.f;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.data.GodUserData;
import com.baidu.tieba.frs.au;
import com.baidu.tieba.frs.ax;
import com.baidu.tieba.frs.ca;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class g {
    private static final int bZP = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds76);
    private static final int bZQ = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds88);
    private static final int bZR = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds4);
    private static final int aiR = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds6);
    private static final int bZS = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds50);
    private static final int bZT = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds108);
    private static final int bZU = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds128);
    private static final int bZV = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.fontsize28);
    private static final int bZW = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.fontsize24);
    private static final String bZX = TbadkCoreApplication.m9getInst().getString(w.l.relate_forum_is_followed);
    private static final String bZY = TbadkCoreApplication.m9getInst().getString(w.l.attention);

    public static boolean a(BaseActivity<?> baseActivity, View view, HeadImageView headImageView, TextView textView, View view2, View view3, RelativeLayout relativeLayout, LinearLayout linearLayout, View view4, bi biVar, int i, View.OnClickListener onClickListener, au auVar, BdUniqueId bdUniqueId) {
        MetaData author;
        GodUserData godUserData;
        ClickableHeaderImageView clickableHeaderImageView;
        TextView textView2;
        TextView textView3;
        ax axVar;
        View view5;
        if (baseActivity == null || view == null || headImageView == null || textView == null || view2 == null || view3 == null || relativeLayout == null || linearLayout == null || view4 == null || biVar == null || onClickListener == null || (author = biVar.getAuthor()) == null || (godUserData = author.getGodUserData()) == null) {
            return false;
        }
        boolean z = false;
        if (godUserData.getType() == 2) {
            z = true;
        }
        if (z) {
            if (biVar.getFid() != 0 && !ca.aaD().e(biVar.getFid(), biVar.getId())) {
                ca.aaD().d(biVar.getFid(), biVar.getId());
                TiebaStatic.log(new as("c10633").aa("tid", biVar.getId()).aa("fid", String.valueOf(biVar.getFid())));
            }
            h hVar = new h(author, onClickListener);
            i iVar = new i(baseActivity, biVar, author, z, bdUniqueId);
            relativeLayout.setOnClickListener(null);
            relativeLayout.setClickable(false);
            headImageView.setVisibility(8);
            textView.setOnClickListener(hVar);
            view2.setVisibility(8);
            view3.setVisibility(8);
            View findViewWithTag = relativeLayout.findViewWithTag("frs_god_fans_count_tag");
            if (findViewWithTag == null || !(findViewWithTag instanceof TextView)) {
                TextView textView4 = new TextView(baseActivity.getActivity());
                textView4.setTextSize(0, bZW);
                textView4.setSingleLine(true);
                textView4.setIncludeFontPadding(false);
                textView4.setGravity(16);
                textView4.setTag("frs_god_fans_count_tag");
                relativeLayout.addView(textView4);
                clickableHeaderImageView = new ClickableHeaderImageView(baseActivity.getActivity());
                clickableHeaderImageView.setGodIconMargin(0);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(bZP, bZP);
                layoutParams.addRule(9);
                clickableHeaderImageView.setTag("frs_god_head_image_view_tag");
                relativeLayout.addView(clickableHeaderImageView, layoutParams);
                linearLayout.setPadding(bZQ, linearLayout.getPaddingTop(), linearLayout.getPaddingRight(), linearLayout.getPaddingBottom());
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams2.addRule(11);
                layoutParams2.addRule(10);
                layoutParams2.topMargin = aiR;
                TextView textView5 = new TextView(baseActivity.getActivity());
                textView5.setTag("frs_god_btn_attention_love_tag");
                textView5.setId(w.h.btn_add_friend);
                textView5.setLayoutParams(layoutParams2);
                textView5.setTextSize(0, bZW);
                textView5.setWidth(bZT);
                textView5.setHeight(bZS);
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
                textView2.setOnClickListener(iVar);
            }
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams3.topMargin = bZR;
            layoutParams3.rightMargin = bZS;
            layoutParams3.addRule(5, w.h.frs_user_tshow_icon_box);
            layoutParams3.addRule(3, w.h.frs_item_loc_view);
            if (clickableHeaderImageView != null) {
                if (com.baidu.tbadk.core.q.po().pq()) {
                    clickableHeaderImageView.setVisibility(0);
                    linearLayout.setPadding(bZQ, linearLayout.getPaddingTop(), bZU, linearLayout.getPaddingBottom());
                    layoutParams3.leftMargin = bZQ;
                    clickableHeaderImageView.setOnClickListener(onClickListener);
                    clickableHeaderImageView.c(author.getPortrait(), 28, false);
                } else {
                    clickableHeaderImageView.setVisibility(8);
                    linearLayout.setPadding(0, linearLayout.getPaddingTop(), 0, linearLayout.getPaddingBottom());
                    layoutParams3.leftMargin = 0;
                }
            }
            textView3.setLayoutParams(layoutParams3);
            textView3.setText(String.format(baseActivity.getResources().getString(w.l.fans_default_name_god_user), com.baidu.tbadk.core.util.au.t(author.getFansNum())));
            textView3.setOnClickListener(onClickListener);
            if (textView2 != null) {
                if (!z(biVar)) {
                    if (godUserData.getIsFromNetWork()) {
                        if (godUserData.getIsLike()) {
                            textView2.setVisibility(8);
                        } else {
                            textView2.setVisibility(0);
                            a(textView2, godUserData.getIsLike(), auVar);
                        }
                    } else {
                        textView2.setVisibility(0);
                        a(textView2, godUserData.getIsLike(), auVar);
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
                    axVar = null;
                } else {
                    view5 = viewStub.inflate();
                    axVar = new ax(view5);
                    view5.setTag(axVar);
                }
            } else {
                findViewById.setVisibility(0);
                axVar = (ax) findViewById.getTag();
                view5 = findViewById;
            }
            if (axVar == null) {
                return false;
            }
            if (!biVar.sT() && !TextUtils.isEmpty(biVar.getAddress()) && !TextUtils.isEmpty(biVar.getAddress().trim())) {
                axVar.bOb.setVisibility(0);
                axVar.bOb.setText(biVar.getAddress());
            } else {
                axVar.bOb.setVisibility(8);
            }
            if (biVar.se() != null && biVar.se().getNum() > 0) {
                axVar.alL.setVisibility(0);
                axVar.alL.setText(com.baidu.tbadk.core.util.au.t(biVar.se().getNum()));
            } else {
                axVar.alL.setVisibility(8);
            }
            com.baidu.tieba.graffiti.c.al(axVar.alL);
            int sh = biVar.sh();
            if (sh > 0) {
                axVar.bOc.setVisibility(0);
                axVar.bOc.setText(com.baidu.tbadk.core.util.au.w(sh));
            } else {
                axVar.bOc.setVisibility(8);
            }
            axVar.alI.setText(com.baidu.tbadk.core.util.au.q(biVar.sj() * 1000));
            if (axVar.amZ != i) {
                aq.j(textView2, w.g.icon_arrow_list);
                aq.c(textView3, w.e.cp_cont_d, 1);
                a(textView2, godUserData.getIsLike(), auVar);
                baseActivity.getLayoutMode().t(view5);
                axVar.amZ = i;
            }
            return true;
        }
        relativeLayout.setOnClickListener(onClickListener);
        if (com.baidu.tbadk.core.q.po().pq()) {
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

    private static void a(TextView textView, boolean z, au auVar) {
        if (z) {
            textView.setClickable(false);
            aq.c(textView, w.e.cp_cont_d, 1);
            textView.setText(bZX);
            textView.setBackgroundDrawable(null);
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            textView.setPadding(0, 0, 0, 0);
            return;
        }
        aq.c(textView, w.e.btn_forum_focus_color, 1);
        textView.setText(bZY);
        if (auVar != null) {
            textView.setBackgroundDrawable(auVar.x(w.g.btn_focus_border_bg, TbadkCoreApplication.m9getInst().getSkinType()));
            textView.setCompoundDrawablesWithIntrinsicBounds(auVar.x(w.g.btn_focus_cross_bg, TbadkCoreApplication.m9getInst().getSkinType()), (Drawable) null, (Drawable) null, (Drawable) null);
        } else {
            aq.j(textView, w.g.btn_focus_border_bg);
            textView.setCompoundDrawablesWithIntrinsicBounds(aq.getDrawable(w.g.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        textView.setClickable(true);
        textView.setPadding(TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds18), 0, TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds10), 0);
    }

    private static boolean z(bi biVar) {
        return (biVar == null || biVar.getAuthor() == null || biVar.getAuthor().getUserId() == null || TbadkCoreApplication.getCurrentAccount() == null || !TbadkCoreApplication.getCurrentAccount().equals(biVar.getAuthor().getUserId())) ? false : true;
    }
}
