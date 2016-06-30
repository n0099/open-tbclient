package com.baidu.tieba.frs;

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
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.data.GodUserData;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class bl {
    private static final int bEx = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(u.e.ds76);
    private static final int bEy = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(u.e.ds88);
    private static final int bEz = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(u.e.ds4);
    private static final int aaG = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(u.e.ds6);
    private static final int bEA = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(u.e.ds50);
    private static final int bEB = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(u.e.ds108);
    private static final int bEC = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(u.e.ds128);
    private static final int bED = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(u.e.fontsize28);
    private static final int bEE = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(u.e.fontsize24);
    private static final String bEF = TbadkCoreApplication.m9getInst().getString(u.j.relate_forum_is_followed);
    private static final String bEG = TbadkCoreApplication.m9getInst().getString(u.j.forum_list_attention_tv);

    public static boolean a(BaseActivity<?> baseActivity, View view, HeadImageView headImageView, TextView textView, View view2, View view3, RelativeLayout relativeLayout, LinearLayout linearLayout, View view4, com.baidu.tbadk.core.data.az azVar, int i, View.OnClickListener onClickListener, bi biVar, BdUniqueId bdUniqueId) {
        MetaData author;
        GodUserData godUserData;
        ClickableHeaderImageView clickableHeaderImageView;
        TextView textView2;
        TextView textView3;
        if (baseActivity == null || view == null || headImageView == null || textView == null || view2 == null || view3 == null || relativeLayout == null || linearLayout == null || view4 == null || azVar == null || onClickListener == null || (author = azVar.getAuthor()) == null || (godUserData = author.getGodUserData()) == null) {
            return false;
        }
        boolean z = false;
        if (godUserData.getType() == 2) {
            z = true;
        }
        if (z) {
            if (azVar.getFid() != 0 && !dh.WY().e(azVar.getFid(), azVar.getId())) {
                dh.WY().d(azVar.getFid(), azVar.getId());
                TiebaStatic.log(new com.baidu.tbadk.core.util.ay("c10633").ab("tid", azVar.getId()).ab("fid", String.valueOf(azVar.getFid())));
            }
            bm bmVar = new bm(author, onClickListener);
            bn bnVar = new bn(baseActivity, azVar, author, z, bdUniqueId);
            relativeLayout.setOnClickListener(null);
            relativeLayout.setClickable(false);
            headImageView.setVisibility(8);
            textView.setOnClickListener(bmVar);
            view2.setVisibility(8);
            view3.setVisibility(8);
            View findViewWithTag = relativeLayout.findViewWithTag("frs_god_fans_count_tag");
            if (findViewWithTag == null || !(findViewWithTag instanceof TextView)) {
                TextView textView4 = new TextView(baseActivity.getActivity());
                textView4.setTextSize(0, bEE);
                textView4.setSingleLine(true);
                textView4.setIncludeFontPadding(false);
                textView4.setGravity(16);
                textView4.setTag("frs_god_fans_count_tag");
                relativeLayout.addView(textView4);
                clickableHeaderImageView = new ClickableHeaderImageView(baseActivity.getActivity());
                clickableHeaderImageView.setGodIconMargin(0);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(bEx, bEx);
                layoutParams.addRule(9);
                clickableHeaderImageView.setTag("frs_god_head_image_view_tag");
                relativeLayout.addView(clickableHeaderImageView, layoutParams);
                linearLayout.setPadding(bEy, linearLayout.getPaddingTop(), linearLayout.getPaddingRight(), linearLayout.getPaddingBottom());
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams2.addRule(11);
                layoutParams2.addRule(10);
                layoutParams2.topMargin = aaG;
                TextView textView5 = new TextView(baseActivity.getActivity());
                textView5.setTag("frs_god_btn_attention_love_tag");
                textView5.setId(u.g.btn_add_friend);
                textView5.setLayoutParams(layoutParams2);
                textView5.setTextSize(0, bEE);
                textView5.setWidth(bEB);
                textView5.setHeight(bEA);
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
                textView2.setOnClickListener(bnVar);
            }
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams3.topMargin = bEz;
            layoutParams3.rightMargin = bEA;
            layoutParams3.addRule(5, u.g.frs_user_tshow_icon_box);
            layoutParams3.addRule(3, u.g.frs_item_loc_view);
            if (clickableHeaderImageView != null) {
                if (com.baidu.tbadk.core.l.nW().nY()) {
                    clickableHeaderImageView.setVisibility(0);
                    linearLayout.setPadding(bEy, linearLayout.getPaddingTop(), bEC, linearLayout.getPaddingBottom());
                    layoutParams3.leftMargin = bEy;
                    clickableHeaderImageView.setOnClickListener(onClickListener);
                    clickableHeaderImageView.c(author.getPortrait(), 28, false);
                } else {
                    clickableHeaderImageView.setVisibility(8);
                    linearLayout.setPadding(0, linearLayout.getPaddingTop(), 0, linearLayout.getPaddingBottom());
                    layoutParams3.leftMargin = 0;
                }
            }
            textView3.setLayoutParams(layoutParams3);
            textView3.setText(String.format(baseActivity.getResources().getString(u.j.fans_default_name_god_user), com.baidu.tbadk.core.util.ba.B(author.getFansNum())));
            textView3.setOnClickListener(onClickListener);
            if (textView2 != null) {
                if (!g(azVar)) {
                    if (godUserData.getIsFromNetWork()) {
                        if (godUserData.getFollowed() == 1) {
                            textView2.setVisibility(8);
                        } else {
                            textView2.setVisibility(0);
                            a(textView2, godUserData.getFollowed() == 1, biVar);
                        }
                    } else {
                        textView2.setVisibility(0);
                        a(textView2, godUserData.getFollowed() == 1, biVar);
                    }
                } else {
                    textView2.setVisibility(8);
                }
            }
            bo boVar = null;
            View findViewById = view4.findViewById(u.g.frs_god_extra_info);
            if (findViewById == null) {
                ViewStub viewStub = (ViewStub) view4.findViewById(u.g.frs_god_extra_vs);
                if (viewStub != null) {
                    View inflate = viewStub.inflate();
                    bo boVar2 = new bo(inflate);
                    inflate.setTag(boVar2);
                    boVar = boVar2;
                    findViewById = inflate;
                }
            } else {
                findViewById.setVisibility(0);
                boVar = (bo) findViewById.getTag();
            }
            if (boVar == null) {
                return false;
            }
            if (!azVar.re() && !TextUtils.isEmpty(azVar.getAddress()) && !TextUtils.isEmpty(azVar.getAddress().trim())) {
                boVar.bEN.setVisibility(0);
                boVar.bEN.setText(azVar.getAddress());
            } else {
                boVar.bEN.setVisibility(8);
            }
            if (azVar.getPraise() != null && azVar.getPraise().getNum() > 0) {
                boVar.adH.setVisibility(0);
                boVar.adH.setText(com.baidu.tbadk.core.util.ba.B(azVar.getPraise().getNum()));
            } else {
                boVar.adH.setVisibility(8);
            }
            com.baidu.tieba.graffiti.d.an(boVar.adH);
            int reply_num = azVar.getReply_num();
            if (reply_num > 0) {
                boVar.bBW.setVisibility(0);
                boVar.bBW.setText(com.baidu.tbadk.core.util.ba.D(reply_num));
            } else {
                boVar.bBW.setVisibility(8);
            }
            boVar.adE.setText(com.baidu.tbadk.core.util.ba.y(azVar.getLast_time_int() * 1000));
            if (boVar.aeK != i) {
                com.baidu.tbadk.core.util.av.k(textView2, u.f.icon_arrow_list);
                com.baidu.tbadk.core.util.av.c(textView3, u.d.cp_cont_d, 1);
                a(textView2, godUserData.getFollowed() == 1, biVar);
                baseActivity.getLayoutMode().w(findViewById);
                boVar.aeK = i;
            }
            return true;
        }
        relativeLayout.setOnClickListener(onClickListener);
        if (com.baidu.tbadk.core.l.nW().nY()) {
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
        View findViewById2 = view4.findViewById(u.g.frs_god_extra_info);
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

    private static void a(TextView textView, boolean z, bi biVar) {
        if (z) {
            textView.setClickable(false);
            com.baidu.tbadk.core.util.av.c(textView, u.d.cp_cont_d, 1);
            textView.setText(bEF);
            textView.setBackgroundDrawable(null);
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            textView.setPadding(0, 0, 0, 0);
            return;
        }
        com.baidu.tbadk.core.util.av.c(textView, u.d.btn_forum_focus_color, 1);
        textView.setText(bEG);
        if (biVar != null) {
            textView.setBackgroundDrawable(biVar.o(u.f.btn_focus_border_bg, TbadkCoreApplication.m9getInst().getSkinType()));
            textView.setCompoundDrawablesWithIntrinsicBounds(biVar.o(u.f.btn_focus_cross_bg, TbadkCoreApplication.m9getInst().getSkinType()), (Drawable) null, (Drawable) null, (Drawable) null);
        } else {
            com.baidu.tbadk.core.util.av.k(textView, u.f.btn_focus_border_bg);
            textView.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.av.getDrawable(u.f.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        textView.setClickable(true);
        textView.setPadding(TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(u.e.ds18), 0, TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(u.e.ds10), 0);
    }

    private static boolean g(com.baidu.tbadk.core.data.az azVar) {
        return (azVar == null || azVar.getAuthor() == null || azVar.getAuthor().getUserId() == null || TbadkCoreApplication.getCurrentAccount() == null || !TbadkCoreApplication.getCurrentAccount().equals(azVar.getAuthor().getUserId())) ? false : true;
    }
}
