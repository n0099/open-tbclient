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
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class bh {
    private static final int bQS = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(t.e.ds76);
    private static final int bQT = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(t.e.ds88);
    private static final int bQU = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(t.e.ds4);
    private static final int aeb = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(t.e.ds6);
    private static final int bQV = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(t.e.ds50);
    private static final int bQW = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(t.e.ds108);
    private static final int bQX = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(t.e.ds128);
    private static final int bQY = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(t.e.fontsize28);
    private static final int bQZ = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(t.e.fontsize24);
    private static final String bRa = TbadkCoreApplication.m9getInst().getString(t.j.relate_forum_is_followed);
    private static final String bRb = TbadkCoreApplication.m9getInst().getString(t.j.forum_list_attention_tv);

    public static boolean a(BaseActivity<?> baseActivity, View view, HeadImageView headImageView, TextView textView, View view2, View view3, RelativeLayout relativeLayout, LinearLayout linearLayout, View view4, com.baidu.tbadk.core.data.bg bgVar, int i, View.OnClickListener onClickListener, be beVar, BdUniqueId bdUniqueId) {
        MetaData author;
        GodUserData godUserData;
        ClickableHeaderImageView clickableHeaderImageView;
        TextView textView2;
        TextView textView3;
        if (baseActivity == null || view == null || headImageView == null || textView == null || view2 == null || view3 == null || relativeLayout == null || linearLayout == null || view4 == null || bgVar == null || onClickListener == null || (author = bgVar.getAuthor()) == null || (godUserData = author.getGodUserData()) == null) {
            return false;
        }
        boolean z = false;
        if (godUserData.getType() == 2) {
            z = true;
        }
        if (z) {
            if (bgVar.getFid() != 0 && !dd.acn().h(bgVar.getFid(), bgVar.getId())) {
                dd.acn().g(bgVar.getFid(), bgVar.getId());
                TiebaStatic.log(new com.baidu.tbadk.core.util.ay("c10633").ab("tid", bgVar.getId()).ab("fid", String.valueOf(bgVar.getFid())));
            }
            bi biVar = new bi(author, onClickListener);
            bj bjVar = new bj(baseActivity, bgVar, author, z, bdUniqueId);
            relativeLayout.setOnClickListener(null);
            relativeLayout.setClickable(false);
            headImageView.setVisibility(8);
            textView.setOnClickListener(biVar);
            view2.setVisibility(8);
            view3.setVisibility(8);
            View findViewWithTag = relativeLayout.findViewWithTag("frs_god_fans_count_tag");
            if (findViewWithTag == null || !(findViewWithTag instanceof TextView)) {
                TextView textView4 = new TextView(baseActivity.getActivity());
                textView4.setTextSize(0, bQZ);
                textView4.setSingleLine(true);
                textView4.setIncludeFontPadding(false);
                textView4.setGravity(16);
                textView4.setTag("frs_god_fans_count_tag");
                relativeLayout.addView(textView4);
                clickableHeaderImageView = new ClickableHeaderImageView(baseActivity.getActivity());
                clickableHeaderImageView.setGodIconMargin(0);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(bQS, bQS);
                layoutParams.addRule(9);
                clickableHeaderImageView.setTag("frs_god_head_image_view_tag");
                relativeLayout.addView(clickableHeaderImageView, layoutParams);
                linearLayout.setPadding(bQT, linearLayout.getPaddingTop(), linearLayout.getPaddingRight(), linearLayout.getPaddingBottom());
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams2.addRule(11);
                layoutParams2.addRule(10);
                layoutParams2.topMargin = aeb;
                TextView textView5 = new TextView(baseActivity.getActivity());
                textView5.setTag("frs_god_btn_attention_love_tag");
                textView5.setId(t.g.btn_add_friend);
                textView5.setLayoutParams(layoutParams2);
                textView5.setTextSize(0, bQZ);
                textView5.setWidth(bQW);
                textView5.setHeight(bQV);
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
                textView2.setOnClickListener(bjVar);
            }
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams3.topMargin = bQU;
            layoutParams3.rightMargin = bQV;
            layoutParams3.addRule(5, t.g.frs_user_tshow_icon_box);
            layoutParams3.addRule(3, t.g.frs_item_loc_view);
            if (clickableHeaderImageView != null) {
                if (com.baidu.tbadk.core.l.oG().oI()) {
                    clickableHeaderImageView.setVisibility(0);
                    linearLayout.setPadding(bQT, linearLayout.getPaddingTop(), bQX, linearLayout.getPaddingBottom());
                    layoutParams3.leftMargin = bQT;
                    clickableHeaderImageView.setOnClickListener(onClickListener);
                    clickableHeaderImageView.c(author.getPortrait(), 28, false);
                } else {
                    clickableHeaderImageView.setVisibility(8);
                    linearLayout.setPadding(0, linearLayout.getPaddingTop(), 0, linearLayout.getPaddingBottom());
                    layoutParams3.leftMargin = 0;
                }
            }
            textView3.setLayoutParams(layoutParams3);
            textView3.setText(String.format(baseActivity.getResources().getString(t.j.fans_default_name_god_user), com.baidu.tbadk.core.util.ba.w(author.getFansNum())));
            textView3.setOnClickListener(onClickListener);
            if (textView2 != null) {
                if (!g(bgVar)) {
                    if (godUserData.getIsFromNetWork()) {
                        if (godUserData.getFollowed() == 1) {
                            textView2.setVisibility(8);
                        } else {
                            textView2.setVisibility(0);
                            a(textView2, godUserData.getFollowed() == 1, beVar);
                        }
                    } else {
                        textView2.setVisibility(0);
                        a(textView2, godUserData.getFollowed() == 1, beVar);
                    }
                } else {
                    textView2.setVisibility(8);
                }
            }
            bk bkVar = null;
            View findViewById = view4.findViewById(t.g.frs_god_extra_info);
            if (findViewById == null) {
                ViewStub viewStub = (ViewStub) view4.findViewById(t.g.frs_god_extra_vs);
                if (viewStub != null) {
                    View inflate = viewStub.inflate();
                    bk bkVar2 = new bk(inflate);
                    inflate.setTag(bkVar2);
                    bkVar = bkVar2;
                    findViewById = inflate;
                }
            } else {
                findViewById.setVisibility(0);
                bkVar = (bk) findViewById.getTag();
            }
            if (bkVar == null) {
                return false;
            }
            if (!bgVar.sf() && !TextUtils.isEmpty(bgVar.getAddress()) && !TextUtils.isEmpty(bgVar.getAddress().trim())) {
                bkVar.bRi.setVisibility(0);
                bkVar.bRi.setText(bgVar.getAddress());
            } else {
                bkVar.bRi.setVisibility(8);
            }
            if (bgVar.rt() != null && bgVar.rt().getNum() > 0) {
                bkVar.ahq.setVisibility(0);
                bkVar.ahq.setText(com.baidu.tbadk.core.util.ba.w(bgVar.rt().getNum()));
            } else {
                bkVar.ahq.setVisibility(8);
            }
            com.baidu.tieba.graffiti.d.al(bkVar.ahq);
            int rv = bgVar.rv();
            if (rv > 0) {
                bkVar.bRj.setVisibility(0);
                bkVar.bRj.setText(com.baidu.tbadk.core.util.ba.y(rv));
            } else {
                bkVar.bRj.setVisibility(8);
            }
            bkVar.ahn.setText(com.baidu.tbadk.core.util.ba.t(bgVar.rw() * 1000));
            if (bkVar.ait != i) {
                com.baidu.tbadk.core.util.av.k(textView2, t.f.icon_arrow_list);
                com.baidu.tbadk.core.util.av.c(textView3, t.d.cp_cont_d, 1);
                a(textView2, godUserData.getFollowed() == 1, beVar);
                baseActivity.getLayoutMode().x(findViewById);
                bkVar.ait = i;
            }
            return true;
        }
        relativeLayout.setOnClickListener(onClickListener);
        if (com.baidu.tbadk.core.l.oG().oI()) {
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

    private static void a(TextView textView, boolean z, be beVar) {
        if (z) {
            textView.setClickable(false);
            com.baidu.tbadk.core.util.av.c(textView, t.d.cp_cont_d, 1);
            textView.setText(bRa);
            textView.setBackgroundDrawable(null);
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            textView.setPadding(0, 0, 0, 0);
            return;
        }
        com.baidu.tbadk.core.util.av.c(textView, t.d.btn_forum_focus_color, 1);
        textView.setText(bRb);
        if (beVar != null) {
            textView.setBackgroundDrawable(beVar.q(t.f.btn_focus_border_bg, TbadkCoreApplication.m9getInst().getSkinType()));
            textView.setCompoundDrawablesWithIntrinsicBounds(beVar.q(t.f.btn_focus_cross_bg, TbadkCoreApplication.m9getInst().getSkinType()), (Drawable) null, (Drawable) null, (Drawable) null);
        } else {
            com.baidu.tbadk.core.util.av.k(textView, t.f.btn_focus_border_bg);
            textView.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.av.getDrawable(t.f.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        textView.setClickable(true);
        textView.setPadding(TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(t.e.ds18), 0, TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(t.e.ds10), 0);
    }

    private static boolean g(com.baidu.tbadk.core.data.bg bgVar) {
        return (bgVar == null || bgVar.getAuthor() == null || bgVar.getAuthor().getUserId() == null || TbadkCoreApplication.getCurrentAccount() == null || !TbadkCoreApplication.getCurrentAccount().equals(bgVar.getAuthor().getUserId())) ? false : true;
    }
}
