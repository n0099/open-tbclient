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
public class ci {
    private static final int bnr = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(t.e.ds76);
    private static final int bns = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(t.e.ds88);
    private static final int bnt = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(t.e.ds4);
    private static final int aeO = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(t.e.ds6);
    private static final int bnu = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(t.e.ds50);
    private static final int bnv = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(t.e.ds108);
    private static final int bnw = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(t.e.ds128);
    private static final int bnx = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(t.e.fontsize28);
    private static final int bny = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(t.e.fontsize24);
    private static final String bnz = TbadkCoreApplication.m411getInst().getString(t.j.relate_forum_is_followed);
    private static final String bnA = TbadkCoreApplication.m411getInst().getString(t.j.forum_list_attention_tv);

    public static boolean a(BaseActivity<?> baseActivity, View view, HeadImageView headImageView, TextView textView, View view2, View view3, RelativeLayout relativeLayout, LinearLayout linearLayout, View view4, com.baidu.tbadk.core.data.as asVar, int i, View.OnClickListener onClickListener, bw bwVar) {
        MetaData author;
        GodUserData godUserData;
        ClickableHeaderImageView clickableHeaderImageView;
        TextView textView2;
        TextView textView3;
        if (baseActivity == null || view == null || headImageView == null || textView == null || view2 == null || view3 == null || relativeLayout == null || linearLayout == null || view4 == null || asVar == null || onClickListener == null || (author = asVar.getAuthor()) == null || (godUserData = author.getGodUserData()) == null) {
            return false;
        }
        boolean z = false;
        if (godUserData.getType() == 2) {
            z = true;
        }
        if (z) {
            if (asVar.getFid() != 0 && !fg.Sv().e(asVar.getFid(), asVar.getId())) {
                fg.Sv().d(asVar.getFid(), asVar.getId());
                TiebaStatic.log(new com.baidu.tbadk.core.util.aw("c10633").ac("tid", asVar.getId()).ac("fid", String.valueOf(asVar.getFid())));
            }
            cj cjVar = new cj(author, onClickListener);
            ck ckVar = new ck(baseActivity, asVar, author);
            relativeLayout.setOnClickListener(null);
            relativeLayout.setClickable(false);
            headImageView.setVisibility(8);
            textView.setOnClickListener(cjVar);
            view2.setVisibility(8);
            view3.setVisibility(8);
            View findViewWithTag = relativeLayout.findViewWithTag("frs_god_fans_count_tag");
            if (findViewWithTag == null || !(findViewWithTag instanceof TextView)) {
                TextView textView4 = new TextView(baseActivity.getActivity());
                textView4.setTextSize(0, bny);
                textView4.setSingleLine(true);
                textView4.setIncludeFontPadding(false);
                textView4.setGravity(16);
                textView4.setTag("frs_god_fans_count_tag");
                relativeLayout.addView(textView4);
                clickableHeaderImageView = new ClickableHeaderImageView(baseActivity.getActivity());
                clickableHeaderImageView.setGodIconMargin(0);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(bnr, bnr);
                layoutParams.addRule(9);
                clickableHeaderImageView.setTag("frs_god_head_image_view_tag");
                relativeLayout.addView(clickableHeaderImageView, layoutParams);
                linearLayout.setPadding(bns, linearLayout.getPaddingTop(), linearLayout.getPaddingRight(), linearLayout.getPaddingBottom());
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams2.addRule(11);
                layoutParams2.addRule(10);
                layoutParams2.topMargin = aeO;
                TextView textView5 = new TextView(baseActivity.getActivity());
                textView5.setTag("frs_god_btn_attention_love_tag");
                textView5.setId(t.g.btn_add_friend);
                textView5.setLayoutParams(layoutParams2);
                textView5.setTextSize(0, bny);
                textView5.setWidth(bnv);
                textView5.setHeight(bnu);
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
                textView2.setOnClickListener(ckVar);
            }
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams3.topMargin = bnt;
            layoutParams3.rightMargin = bnu;
            layoutParams3.addRule(5, t.g.frs_user_tshow_icon_box);
            layoutParams3.addRule(3, t.g.frs_item_loc_view);
            if (clickableHeaderImageView != null) {
                if (com.baidu.tbadk.core.l.qE().qG()) {
                    clickableHeaderImageView.setVisibility(0);
                    linearLayout.setPadding(bns, linearLayout.getPaddingTop(), bnw, linearLayout.getPaddingBottom());
                    layoutParams3.leftMargin = bns;
                    clickableHeaderImageView.setOnClickListener(onClickListener);
                    clickableHeaderImageView.c(author.getPortrait(), 28, false);
                } else {
                    clickableHeaderImageView.setVisibility(8);
                    linearLayout.setPadding(0, linearLayout.getPaddingTop(), 0, linearLayout.getPaddingBottom());
                    layoutParams3.leftMargin = 0;
                }
            }
            textView3.setLayoutParams(layoutParams3);
            textView3.setText(String.format(baseActivity.getResources().getString(t.j.fans_default_name_god_user), com.baidu.tbadk.core.util.ay.z(author.getFansNum())));
            textView3.setOnClickListener(onClickListener);
            if (textView2 != null) {
                if (!f(asVar)) {
                    if (godUserData.getIsFromNetWork()) {
                        if (godUserData.getFollowed() == 1) {
                            textView2.setVisibility(8);
                        } else {
                            textView2.setVisibility(0);
                            a(textView2, godUserData.getFollowed() == 1, bwVar);
                        }
                    } else {
                        textView2.setVisibility(0);
                        a(textView2, godUserData.getFollowed() == 1, bwVar);
                    }
                } else {
                    textView2.setVisibility(8);
                }
            }
            cl clVar = null;
            View findViewById = view4.findViewById(t.g.frs_god_extra_info);
            if (findViewById == null) {
                ViewStub viewStub = (ViewStub) view4.findViewById(t.g.frs_god_extra_vs);
                if (viewStub != null) {
                    View inflate = viewStub.inflate();
                    cl clVar2 = new cl(inflate);
                    inflate.setTag(clVar2);
                    clVar = clVar2;
                    findViewById = inflate;
                }
            } else {
                findViewById.setVisibility(0);
                clVar = (cl) findViewById.getTag();
            }
            if (clVar == null) {
                return false;
            }
            if (!asVar.tJ() && !TextUtils.isEmpty(asVar.getAddress()) && !TextUtils.isEmpty(asVar.getAddress().trim())) {
                clVar.bnF.setVisibility(0);
                clVar.bnF.setText(asVar.getAddress());
            } else {
                clVar.bnF.setVisibility(8);
            }
            if (asVar.getPraise() != null && asVar.getPraise().getNum() > 0) {
                clVar.ahs.setVisibility(0);
                clVar.ahs.setText(com.baidu.tbadk.core.util.ay.z(asVar.getPraise().getNum()));
            } else {
                clVar.ahs.setVisibility(8);
            }
            com.baidu.tieba.graffiti.d.af(clVar.ahs);
            int reply_num = asVar.getReply_num();
            if (reply_num > 0) {
                clVar.bjK.setVisibility(0);
                clVar.bjK.setText(com.baidu.tbadk.core.util.ay.A(reply_num));
            } else {
                clVar.bjK.setVisibility(8);
            }
            clVar.ahr.setText(com.baidu.tbadk.core.util.ay.w(asVar.getLast_time_int() * 1000));
            if (clVar.aik != i) {
                com.baidu.tbadk.core.util.at.k(textView2, t.f.icon_arrow_list);
                com.baidu.tbadk.core.util.at.b(textView3, t.d.cp_cont_d, 1);
                a(textView2, godUserData.getFollowed() == 1, bwVar);
                baseActivity.getLayoutMode().x(findViewById);
                clVar.aik = i;
            }
            return true;
        }
        relativeLayout.setOnClickListener(onClickListener);
        if (com.baidu.tbadk.core.l.qE().qG()) {
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

    private static void a(TextView textView, boolean z, bw bwVar) {
        if (z) {
            textView.setClickable(false);
            com.baidu.tbadk.core.util.at.b(textView, t.d.cp_cont_d, 1);
            textView.setText(bnz);
            textView.setBackgroundDrawable(null);
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            textView.setPadding(0, 0, 0, 0);
            return;
        }
        com.baidu.tbadk.core.util.at.b(textView, t.d.btn_forum_focus_color, 1);
        textView.setText(bnA);
        if (bwVar != null) {
            textView.setBackgroundDrawable(bwVar.o(t.f.btn_focus_border_bg, TbadkCoreApplication.m411getInst().getSkinType()));
            textView.setCompoundDrawablesWithIntrinsicBounds(bwVar.o(t.f.btn_focus_cross_bg, TbadkCoreApplication.m411getInst().getSkinType()), (Drawable) null, (Drawable) null, (Drawable) null);
        } else {
            com.baidu.tbadk.core.util.at.k(textView, t.f.btn_focus_border_bg);
            textView.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.at.getDrawable(t.f.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        textView.setClickable(true);
        textView.setPadding(TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(t.e.ds18), 0, TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(t.e.ds10), 0);
    }

    private static boolean f(com.baidu.tbadk.core.data.as asVar) {
        return (asVar == null || asVar.getAuthor() == null || asVar.getAuthor().getUserId() == null || TbadkCoreApplication.getCurrentAccount() == null || !TbadkCoreApplication.getCurrentAccount().equals(asVar.getAuthor().getUserId())) ? false : true;
    }
}
