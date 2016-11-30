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
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.data.GodUserData;
import com.baidu.tieba.frs.ap;
import com.baidu.tieba.frs.as;
import com.baidu.tieba.frs.cb;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class g {
    private static final int ciH = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.ds76);
    private static final int ciI = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.ds88);
    private static final int ciJ = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.ds4);
    private static final int aeK = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.ds6);
    private static final int ciK = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.ds50);
    private static final int ciL = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.ds108);
    private static final int ciM = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.ds128);
    private static final int ciN = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.fontsize28);
    private static final int ciO = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.fontsize24);
    private static final String ciP = TbadkCoreApplication.m9getInst().getString(r.j.relate_forum_is_followed);
    private static final String ciQ = TbadkCoreApplication.m9getInst().getString(r.j.forum_list_attention_tv);

    public static boolean a(BaseActivity<?> baseActivity, View view, HeadImageView headImageView, TextView textView, View view2, View view3, RelativeLayout relativeLayout, LinearLayout linearLayout, View view4, bk bkVar, int i, View.OnClickListener onClickListener, ap apVar, BdUniqueId bdUniqueId) {
        MetaData author;
        GodUserData godUserData;
        ClickableHeaderImageView clickableHeaderImageView;
        TextView textView2;
        TextView textView3;
        as asVar;
        View view5;
        if (baseActivity == null || view == null || headImageView == null || textView == null || view2 == null || view3 == null || relativeLayout == null || linearLayout == null || view4 == null || bkVar == null || onClickListener == null || (author = bkVar.getAuthor()) == null || (godUserData = author.getGodUserData()) == null) {
            return false;
        }
        boolean z = false;
        if (godUserData.getType() == 2) {
            z = true;
        }
        if (z) {
            if (bkVar.getFid() != 0 && !cb.adG().h(bkVar.getFid(), bkVar.getId())) {
                cb.adG().g(bkVar.getFid(), bkVar.getId());
                TiebaStatic.log(new av("c10633").ab("tid", bkVar.getId()).ab("fid", String.valueOf(bkVar.getFid())));
            }
            h hVar = new h(author, onClickListener);
            i iVar = new i(baseActivity, bkVar, author, z, bdUniqueId);
            relativeLayout.setOnClickListener(null);
            relativeLayout.setClickable(false);
            headImageView.setVisibility(8);
            textView.setOnClickListener(hVar);
            view2.setVisibility(8);
            view3.setVisibility(8);
            View findViewWithTag = relativeLayout.findViewWithTag("frs_god_fans_count_tag");
            if (findViewWithTag == null || !(findViewWithTag instanceof TextView)) {
                TextView textView4 = new TextView(baseActivity.getActivity());
                textView4.setTextSize(0, ciO);
                textView4.setSingleLine(true);
                textView4.setIncludeFontPadding(false);
                textView4.setGravity(16);
                textView4.setTag("frs_god_fans_count_tag");
                relativeLayout.addView(textView4);
                clickableHeaderImageView = new ClickableHeaderImageView(baseActivity.getActivity());
                clickableHeaderImageView.setGodIconMargin(0);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ciH, ciH);
                layoutParams.addRule(9);
                clickableHeaderImageView.setTag("frs_god_head_image_view_tag");
                relativeLayout.addView(clickableHeaderImageView, layoutParams);
                linearLayout.setPadding(ciI, linearLayout.getPaddingTop(), linearLayout.getPaddingRight(), linearLayout.getPaddingBottom());
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams2.addRule(11);
                layoutParams2.addRule(10);
                layoutParams2.topMargin = aeK;
                TextView textView5 = new TextView(baseActivity.getActivity());
                textView5.setTag("frs_god_btn_attention_love_tag");
                textView5.setId(r.g.btn_add_friend);
                textView5.setLayoutParams(layoutParams2);
                textView5.setTextSize(0, ciO);
                textView5.setWidth(ciL);
                textView5.setHeight(ciK);
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
            layoutParams3.topMargin = ciJ;
            layoutParams3.rightMargin = ciK;
            layoutParams3.addRule(5, r.g.frs_user_tshow_icon_box);
            layoutParams3.addRule(3, r.g.frs_item_loc_view);
            if (clickableHeaderImageView != null) {
                if (com.baidu.tbadk.core.l.oJ().oL()) {
                    clickableHeaderImageView.setVisibility(0);
                    linearLayout.setPadding(ciI, linearLayout.getPaddingTop(), ciM, linearLayout.getPaddingBottom());
                    layoutParams3.leftMargin = ciI;
                    clickableHeaderImageView.setOnClickListener(onClickListener);
                    clickableHeaderImageView.c(author.getPortrait(), 28, false);
                } else {
                    clickableHeaderImageView.setVisibility(8);
                    linearLayout.setPadding(0, linearLayout.getPaddingTop(), 0, linearLayout.getPaddingBottom());
                    layoutParams3.leftMargin = 0;
                }
            }
            textView3.setLayoutParams(layoutParams3);
            textView3.setText(String.format(baseActivity.getResources().getString(r.j.fans_default_name_god_user), ax.v(author.getFansNum())));
            textView3.setOnClickListener(onClickListener);
            if (textView2 != null) {
                if (!t(bkVar)) {
                    if (godUserData.getIsFromNetWork()) {
                        if (godUserData.getIsLike()) {
                            textView2.setVisibility(8);
                        } else {
                            textView2.setVisibility(0);
                            a(textView2, godUserData.getIsLike(), apVar);
                        }
                    } else {
                        textView2.setVisibility(0);
                        a(textView2, godUserData.getIsLike(), apVar);
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
            if (!bkVar.st() && !TextUtils.isEmpty(bkVar.getAddress()) && !TextUtils.isEmpty(bkVar.getAddress().trim())) {
                asVar.bTt.setVisibility(0);
                asVar.bTt.setText(bkVar.getAddress());
            } else {
                asVar.bTt.setVisibility(8);
            }
            if (bkVar.rH() != null && bkVar.rH().getNum() > 0) {
                asVar.ahz.setVisibility(0);
                asVar.ahz.setText(ax.v(bkVar.rH().getNum()));
            } else {
                asVar.ahz.setVisibility(8);
            }
            com.baidu.tieba.graffiti.d.ak(asVar.ahz);
            int rJ = bkVar.rJ();
            if (rJ > 0) {
                asVar.bTu.setVisibility(0);
                asVar.bTu.setText(ax.y(rJ));
            } else {
                asVar.bTu.setVisibility(8);
            }
            asVar.ahw.setText(ax.s(bkVar.rK() * 1000));
            if (asVar.aiA != i) {
                at.k(textView2, r.f.icon_arrow_list);
                at.c(textView3, r.d.cp_cont_d, 1);
                a(textView2, godUserData.getIsLike(), apVar);
                baseActivity.getLayoutMode().x(view5);
                asVar.aiA = i;
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

    private static void a(TextView textView, boolean z, ap apVar) {
        if (z) {
            textView.setClickable(false);
            at.c(textView, r.d.cp_cont_d, 1);
            textView.setText(ciP);
            textView.setBackgroundDrawable(null);
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            textView.setPadding(0, 0, 0, 0);
            return;
        }
        at.c(textView, r.d.btn_forum_focus_color, 1);
        textView.setText(ciQ);
        if (apVar != null) {
            textView.setBackgroundDrawable(apVar.q(r.f.btn_focus_border_bg, TbadkCoreApplication.m9getInst().getSkinType()));
            textView.setCompoundDrawablesWithIntrinsicBounds(apVar.q(r.f.btn_focus_cross_bg, TbadkCoreApplication.m9getInst().getSkinType()), (Drawable) null, (Drawable) null, (Drawable) null);
        } else {
            at.k(textView, r.f.btn_focus_border_bg);
            textView.setCompoundDrawablesWithIntrinsicBounds(at.getDrawable(r.f.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        textView.setClickable(true);
        textView.setPadding(TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.ds18), 0, TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.ds10), 0);
    }

    private static boolean t(bk bkVar) {
        return (bkVar == null || bkVar.getAuthor() == null || bkVar.getAuthor().getUserId() == null || TbadkCoreApplication.getCurrentAccount() == null || !TbadkCoreApplication.getCurrentAccount().equals(bkVar.getAuthor().getUserId())) ? false : true;
    }
}
