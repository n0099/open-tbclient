package com.baidu.tieba.frs.utils;

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
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.data.GodUserData;
import com.baidu.tieba.frs.at;
import com.baidu.tieba.frs.aw;
import com.baidu.tieba.frs.ca;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class g {
    private static final int bNO = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.ds76);
    private static final int bNP = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.ds88);
    private static final int bNQ = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.ds4);
    private static final int aed = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.ds6);
    private static final int bNR = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.ds50);
    private static final int bNS = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.ds108);
    private static final int bNT = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.ds128);
    private static final int bNU = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.fontsize28);
    private static final int bNV = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.fontsize24);
    private static final String bNW = TbadkCoreApplication.m9getInst().getString(r.j.relate_forum_is_followed);
    private static final String bNX = TbadkCoreApplication.m9getInst().getString(r.j.attention);

    public static boolean a(BaseActivity<?> baseActivity, View view, HeadImageView headImageView, TextView textView, View view2, View view3, RelativeLayout relativeLayout, LinearLayout linearLayout, View view4, bg bgVar, int i, View.OnClickListener onClickListener, at atVar, BdUniqueId bdUniqueId) {
        MetaData author;
        GodUserData godUserData;
        ClickableHeaderImageView clickableHeaderImageView;
        TextView textView2;
        TextView textView3;
        aw awVar;
        View view5;
        if (baseActivity == null || view == null || headImageView == null || textView == null || view2 == null || view3 == null || relativeLayout == null || linearLayout == null || view4 == null || bgVar == null || onClickListener == null || (author = bgVar.getAuthor()) == null || (godUserData = author.getGodUserData()) == null) {
            return false;
        }
        boolean z = false;
        if (godUserData.getType() == 2) {
            z = true;
        }
        if (z) {
            if (bgVar.getFid() != 0 && !ca.XZ().h(bgVar.getFid(), bgVar.getId())) {
                ca.XZ().g(bgVar.getFid(), bgVar.getId());
                TiebaStatic.log(new com.baidu.tbadk.core.util.at("c10633").ab("tid", bgVar.getId()).ab("fid", String.valueOf(bgVar.getFid())));
            }
            h hVar = new h(author, onClickListener);
            i iVar = new i(baseActivity, bgVar, author, z, bdUniqueId);
            relativeLayout.setOnClickListener(null);
            relativeLayout.setClickable(false);
            headImageView.setVisibility(8);
            textView.setOnClickListener(hVar);
            view2.setVisibility(8);
            view3.setVisibility(8);
            View findViewWithTag = relativeLayout.findViewWithTag("frs_god_fans_count_tag");
            if (findViewWithTag == null || !(findViewWithTag instanceof TextView)) {
                TextView textView4 = new TextView(baseActivity.getActivity());
                textView4.setTextSize(0, bNV);
                textView4.setSingleLine(true);
                textView4.setIncludeFontPadding(false);
                textView4.setGravity(16);
                textView4.setTag("frs_god_fans_count_tag");
                relativeLayout.addView(textView4);
                clickableHeaderImageView = new ClickableHeaderImageView(baseActivity.getActivity());
                clickableHeaderImageView.setGodIconMargin(0);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(bNO, bNO);
                layoutParams.addRule(9);
                clickableHeaderImageView.setTag("frs_god_head_image_view_tag");
                relativeLayout.addView(clickableHeaderImageView, layoutParams);
                linearLayout.setPadding(bNP, linearLayout.getPaddingTop(), linearLayout.getPaddingRight(), linearLayout.getPaddingBottom());
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams2.addRule(11);
                layoutParams2.addRule(10);
                layoutParams2.topMargin = aed;
                TextView textView5 = new TextView(baseActivity.getActivity());
                textView5.setTag("frs_god_btn_attention_love_tag");
                textView5.setId(r.g.btn_add_friend);
                textView5.setLayoutParams(layoutParams2);
                textView5.setTextSize(0, bNV);
                textView5.setWidth(bNS);
                textView5.setHeight(bNR);
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
            layoutParams3.topMargin = bNQ;
            layoutParams3.rightMargin = bNR;
            layoutParams3.addRule(5, r.g.frs_user_tshow_icon_box);
            layoutParams3.addRule(3, r.g.frs_item_loc_view);
            if (clickableHeaderImageView != null) {
                if (com.baidu.tbadk.core.l.oJ().oL()) {
                    clickableHeaderImageView.setVisibility(0);
                    linearLayout.setPadding(bNP, linearLayout.getPaddingTop(), bNT, linearLayout.getPaddingBottom());
                    layoutParams3.leftMargin = bNP;
                    clickableHeaderImageView.setOnClickListener(onClickListener);
                    clickableHeaderImageView.c(author.getPortrait(), 28, false);
                } else {
                    clickableHeaderImageView.setVisibility(8);
                    linearLayout.setPadding(0, linearLayout.getPaddingTop(), 0, linearLayout.getPaddingBottom());
                    layoutParams3.leftMargin = 0;
                }
            }
            textView3.setLayoutParams(layoutParams3);
            textView3.setText(String.format(baseActivity.getResources().getString(r.j.fans_default_name_god_user), av.v(author.getFansNum())));
            textView3.setOnClickListener(onClickListener);
            if (textView2 != null) {
                if (!y(bgVar)) {
                    if (godUserData.getIsFromNetWork()) {
                        if (godUserData.getIsLike()) {
                            textView2.setVisibility(8);
                        } else {
                            textView2.setVisibility(0);
                            a(textView2, godUserData.getIsLike(), atVar);
                        }
                    } else {
                        textView2.setVisibility(0);
                        a(textView2, godUserData.getIsLike(), atVar);
                    }
                } else {
                    textView2.setVisibility(8);
                }
            }
            View findViewById = view4.findViewById(r.g.frs_god_extra_info);
            if (findViewById == null) {
                ViewStub viewStub = (ViewStub) view4.findViewById(r.g.frs_god_extra_vs);
                if (viewStub == null) {
                    view5 = findViewById;
                    awVar = null;
                } else {
                    view5 = viewStub.inflate();
                    awVar = new aw(view5);
                    view5.setTag(awVar);
                }
            } else {
                findViewById.setVisibility(0);
                awVar = (aw) findViewById.getTag();
                view5 = findViewById;
            }
            if (awVar == null) {
                return false;
            }
            if (!bgVar.si() && !TextUtils.isEmpty(bgVar.getAddress()) && !TextUtils.isEmpty(bgVar.getAddress().trim())) {
                awVar.bzE.setVisibility(0);
                awVar.bzE.setText(bgVar.getAddress());
            } else {
                awVar.bzE.setVisibility(8);
            }
            if (bgVar.rv() != null && bgVar.rv().getNum() > 0) {
                awVar.agS.setVisibility(0);
                awVar.agS.setText(av.v(bgVar.rv().getNum()));
            } else {
                awVar.agS.setVisibility(8);
            }
            com.baidu.tieba.graffiti.d.ak(awVar.agS);
            int rx = bgVar.rx();
            if (rx > 0) {
                awVar.bzF.setVisibility(0);
                awVar.bzF.setText(av.y(rx));
            } else {
                awVar.bzF.setVisibility(8);
            }
            awVar.agP.setText(av.s(bgVar.rz() * 1000));
            if (awVar.aib != i) {
                ar.k(textView2, r.f.icon_arrow_list);
                ar.c(textView3, r.d.cp_cont_d, 1);
                a(textView2, godUserData.getIsLike(), atVar);
                baseActivity.getLayoutMode().x(view5);
                awVar.aib = i;
            }
            return true;
        }
        relativeLayout.setOnClickListener(onClickListener);
        if (com.baidu.tbadk.core.l.oJ().oL()) {
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
        View findViewById2 = view4.findViewById(r.g.frs_god_extra_info);
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

    private static void a(TextView textView, boolean z, at atVar) {
        if (z) {
            textView.setClickable(false);
            ar.c(textView, r.d.cp_cont_d, 1);
            textView.setText(bNW);
            textView.setBackgroundDrawable(null);
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            textView.setPadding(0, 0, 0, 0);
            return;
        }
        ar.c(textView, r.d.btn_forum_focus_color, 1);
        textView.setText(bNX);
        if (atVar != null) {
            textView.setBackgroundDrawable(atVar.q(r.f.btn_focus_border_bg, TbadkCoreApplication.m9getInst().getSkinType()));
            textView.setCompoundDrawablesWithIntrinsicBounds(atVar.q(r.f.btn_focus_cross_bg, TbadkCoreApplication.m9getInst().getSkinType()), (Drawable) null, (Drawable) null, (Drawable) null);
        } else {
            ar.k(textView, r.f.btn_focus_border_bg);
            textView.setCompoundDrawablesWithIntrinsicBounds(ar.getDrawable(r.f.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        textView.setClickable(true);
        textView.setPadding(TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.ds18), 0, TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.ds10), 0);
    }

    private static boolean y(bg bgVar) {
        return (bgVar == null || bgVar.getAuthor() == null || bgVar.getAuthor().getUserId() == null || TbadkCoreApplication.getCurrentAccount() == null || !TbadkCoreApplication.getCurrentAccount().equals(bgVar.getAuthor().getUserId())) ? false : true;
    }
}
