package com.baidu.tieba.frs;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.data.GodUserData;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class ch {
    private static final int biU = TbadkCoreApplication.m11getInst().getResources().getDimensionPixelSize(t.e.ds76);
    private static final int biV = TbadkCoreApplication.m11getInst().getResources().getDimensionPixelSize(t.e.ds88);
    private static final int biW = TbadkCoreApplication.m11getInst().getResources().getDimensionPixelSize(t.e.ds4);
    private static final int aan = TbadkCoreApplication.m11getInst().getResources().getDimensionPixelSize(t.e.ds6);
    private static final int biX = TbadkCoreApplication.m11getInst().getResources().getDimensionPixelSize(t.e.ds50);
    private static final int biY = TbadkCoreApplication.m11getInst().getResources().getDimensionPixelSize(t.e.ds108);
    private static final int biZ = TbadkCoreApplication.m11getInst().getResources().getDimensionPixelSize(t.e.ds128);
    private static final int bja = TbadkCoreApplication.m11getInst().getResources().getDimensionPixelSize(t.e.fontsize28);
    private static final int bjb = TbadkCoreApplication.m11getInst().getResources().getDimensionPixelSize(t.e.fontsize24);
    private static final String bjc = TbadkCoreApplication.m11getInst().getString(t.j.relate_forum_is_followed);
    private static final String bjd = TbadkCoreApplication.m11getInst().getString(t.j.forum_list_attention_tv);

    public static boolean a(BaseActivity<?> baseActivity, View view, HeadImageView headImageView, TextView textView, View view2, View view3, RelativeLayout relativeLayout, LinearLayout linearLayout, View view4, com.baidu.tbadk.core.data.ax axVar, int i, View.OnClickListener onClickListener, bv bvVar) {
        MetaData author;
        GodUserData godUserData;
        ClickableHeaderImageView clickableHeaderImageView;
        TextView textView2;
        TextView textView3;
        if (baseActivity == null || view == null || headImageView == null || textView == null || view2 == null || view3 == null || relativeLayout == null || linearLayout == null || view4 == null || axVar == null || onClickListener == null || (author = axVar.getAuthor()) == null || (godUserData = author.getGodUserData()) == null) {
            return false;
        }
        boolean z = false;
        if (godUserData.getType() == 2) {
            z = true;
        }
        if (z) {
            if (axVar.getFid() != 0 && !ex.RE().e(axVar.getFid(), axVar.getId())) {
                ex.RE().d(axVar.getFid(), axVar.getId());
                TiebaStatic.log(new com.baidu.tbadk.core.util.aw("c10633").ac("tid", axVar.getId()).ac("fid", String.valueOf(axVar.getFid())));
            }
            ci ciVar = new ci(author, onClickListener);
            cj cjVar = new cj(baseActivity, axVar, author);
            relativeLayout.setOnClickListener(null);
            relativeLayout.setClickable(false);
            headImageView.setVisibility(8);
            textView.setOnClickListener(ciVar);
            view2.setVisibility(8);
            view3.setVisibility(8);
            View findViewWithTag = relativeLayout.findViewWithTag("frs_god_fans_count_tag");
            if (findViewWithTag == null || !(findViewWithTag instanceof TextView)) {
                TextView textView4 = new TextView(baseActivity.getActivity());
                textView4.setTextSize(0, bjb);
                textView4.setSingleLine(true);
                textView4.setIncludeFontPadding(false);
                textView4.setGravity(16);
                textView4.setTag("frs_god_fans_count_tag");
                relativeLayout.addView(textView4);
                clickableHeaderImageView = new ClickableHeaderImageView(baseActivity.getActivity());
                clickableHeaderImageView.setGodIconMargin(0);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(biU, biU);
                layoutParams.addRule(9);
                clickableHeaderImageView.setTag("frs_god_head_image_view_tag");
                relativeLayout.addView(clickableHeaderImageView, layoutParams);
                linearLayout.setPadding(biV, linearLayout.getPaddingTop(), linearLayout.getPaddingRight(), linearLayout.getPaddingBottom());
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams2.addRule(11);
                layoutParams2.addRule(10);
                layoutParams2.topMargin = aan;
                TextView textView5 = new TextView(baseActivity.getActivity());
                textView5.setTag("frs_god_btn_attention_love_tag");
                textView5.setId(t.g.btn_add_friend);
                textView5.setLayoutParams(layoutParams2);
                textView5.setTextSize(0, bjb);
                textView5.setWidth(biY);
                textView5.setHeight(biX);
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
                textView2.setOnClickListener(cjVar);
            }
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams3.topMargin = biW;
            layoutParams3.rightMargin = biX;
            layoutParams3.addRule(5, t.g.frs_user_tshow_icon_box);
            layoutParams3.addRule(3, t.g.frs_item_loc_view);
            if (clickableHeaderImageView != null) {
                if (com.baidu.tbadk.core.l.ob().od()) {
                    clickableHeaderImageView.setVisibility(0);
                    linearLayout.setPadding(biV, linearLayout.getPaddingTop(), biZ, linearLayout.getPaddingBottom());
                    layoutParams3.leftMargin = biV;
                    clickableHeaderImageView.setOnClickListener(onClickListener);
                    clickableHeaderImageView.c(author.getPortrait(), 28, false);
                } else {
                    clickableHeaderImageView.setVisibility(8);
                    linearLayout.setPadding(0, linearLayout.getPaddingTop(), 0, linearLayout.getPaddingBottom());
                    layoutParams3.leftMargin = 0;
                }
            }
            textView3.setLayoutParams(layoutParams3);
            textView3.setText(String.format(baseActivity.getResources().getString(t.j.fans_default_name_god_user), com.baidu.tbadk.core.util.ay.A(author.getFansNum())));
            textView3.setOnClickListener(onClickListener);
            if (textView2 != null) {
                if (!f(axVar)) {
                    if (godUserData.getIsFromNetWork()) {
                        if (godUserData.getFollowed() == 1) {
                            textView2.setVisibility(8);
                        } else {
                            textView2.setVisibility(0);
                            a(textView2, godUserData.getFollowed() == 1, bvVar);
                        }
                    } else {
                        textView2.setVisibility(0);
                        a(textView2, godUserData.getFollowed() == 1, bvVar);
                    }
                } else {
                    textView2.setVisibility(8);
                }
            }
            ck ckVar = null;
            View findViewById = view4.findViewById(t.g.frs_god_extra_info);
            if (findViewById == null) {
                ViewStub viewStub = (ViewStub) view4.findViewById(t.g.frs_god_extra_vs);
                if (viewStub != null) {
                    View inflate = viewStub.inflate();
                    ck ckVar2 = new ck(inflate);
                    inflate.setTag(ckVar2);
                    ckVar = ckVar2;
                    findViewById = inflate;
                }
            } else {
                findViewById.setVisibility(0);
                ckVar = (ck) findViewById.getTag();
            }
            if (ckVar == null) {
                return false;
            }
            if (!axVar.ri() && !TextUtils.isEmpty(axVar.getAddress()) && !TextUtils.isEmpty(axVar.getAddress().trim())) {
                ckVar.bji.setVisibility(0);
                ckVar.bji.setText(axVar.getAddress());
            } else {
                ckVar.bji.setVisibility(8);
            }
            if (axVar.getPraise() != null && axVar.getPraise().getNum() > 0) {
                ckVar.adj.setVisibility(0);
                ckVar.adj.setText(com.baidu.tbadk.core.util.ay.A(axVar.getPraise().getNum()));
            } else {
                ckVar.adj.setVisibility(8);
            }
            com.baidu.tieba.graffiti.d.aj(ckVar.adj);
            int reply_num = axVar.getReply_num();
            if (reply_num > 0) {
                ckVar.bfK.setVisibility(0);
                ckVar.bfK.setText(com.baidu.tbadk.core.util.ay.B(reply_num));
            } else {
                ckVar.bfK.setVisibility(8);
            }
            ckVar.adg.setText(com.baidu.tbadk.core.util.ay.x(axVar.getLast_time_int() * 1000));
            if (ckVar.aej != i) {
                com.baidu.tbadk.core.util.at.k(textView2, t.f.icon_arrow_list);
                com.baidu.tbadk.core.util.at.c(textView3, t.d.cp_cont_d, 1);
                a(textView2, godUserData.getFollowed() == 1, bvVar);
                baseActivity.getLayoutMode().x(findViewById);
                ckVar.aej = i;
            }
            return true;
        }
        relativeLayout.setOnClickListener(onClickListener);
        if (com.baidu.tbadk.core.l.ob().od()) {
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
        View findViewById2 = view4.findViewById(t.g.frs_god_extra_info);
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

    private static void a(TextView textView, boolean z, bv bvVar) {
        if (z) {
            textView.setClickable(false);
            com.baidu.tbadk.core.util.at.c(textView, t.d.cp_cont_d, 1);
            textView.setText(bjc);
            textView.setBackgroundDrawable(null);
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            textView.setPadding(0, 0, 0, 0);
            return;
        }
        com.baidu.tbadk.core.util.at.c(textView, t.d.btn_forum_focus_color, 1);
        textView.setText(bjd);
        if (bvVar != null) {
            textView.setBackgroundDrawable(bvVar.o(t.f.btn_focus_border_bg, TbadkCoreApplication.m11getInst().getSkinType()));
            textView.setCompoundDrawablesWithIntrinsicBounds(bvVar.o(t.f.btn_focus_cross_bg, TbadkCoreApplication.m11getInst().getSkinType()), (Drawable) null, (Drawable) null, (Drawable) null);
        } else {
            com.baidu.tbadk.core.util.at.k(textView, t.f.btn_focus_border_bg);
            textView.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.at.getDrawable(t.f.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        textView.setClickable(true);
        textView.setPadding(TbadkCoreApplication.m11getInst().getResources().getDimensionPixelSize(t.e.ds18), 0, TbadkCoreApplication.m11getInst().getResources().getDimensionPixelSize(t.e.ds10), 0);
    }

    private static boolean f(com.baidu.tbadk.core.data.ax axVar) {
        return (axVar == null || axVar.getAuthor() == null || axVar.getAuthor().getUserId() == null || TbadkCoreApplication.getCurrentAccount() == null || !TbadkCoreApplication.getCurrentAccount().equals(axVar.getAuthor().getUserId())) ? false : true;
    }
}
