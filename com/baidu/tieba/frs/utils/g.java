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
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.data.GodUserData;
import com.baidu.tieba.frs.as;
import com.baidu.tieba.frs.av;
import com.baidu.tieba.frs.by;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class g {
    private static final int cbo = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds76);
    private static final int cbp = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds88);
    private static final int cbq = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds4);
    private static final int aiD = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds6);
    private static final int cbr = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds50);
    private static final int cbs = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds108);
    private static final int cbt = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds128);
    private static final int cbu = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.fontsize28);
    private static final int cbv = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.fontsize24);
    private static final String cbw = TbadkCoreApplication.m9getInst().getString(w.l.relate_forum_is_followed);
    private static final String cbx = TbadkCoreApplication.m9getInst().getString(w.l.attention);

    public static boolean a(BaseActivity<?> baseActivity, View view, HeadImageView headImageView, TextView textView, View view2, View view3, RelativeLayout relativeLayout, LinearLayout linearLayout, View view4, bj bjVar, int i, View.OnClickListener onClickListener, as asVar, BdUniqueId bdUniqueId) {
        MetaData author;
        GodUserData godUserData;
        ClickableHeaderImageView clickableHeaderImageView;
        TextView textView2;
        TextView textView3;
        av avVar;
        View view5;
        if (baseActivity == null || view == null || headImageView == null || textView == null || view2 == null || view3 == null || relativeLayout == null || linearLayout == null || view4 == null || bjVar == null || onClickListener == null || (author = bjVar.getAuthor()) == null || (godUserData = author.getGodUserData()) == null) {
            return false;
        }
        boolean z = false;
        if (godUserData.getType() == 2) {
            z = true;
        }
        if (z) {
            if (bjVar.getFid() != 0 && !by.aaf().e(bjVar.getFid(), bjVar.getId())) {
                by.aaf().d(bjVar.getFid(), bjVar.getId());
                TiebaStatic.log(new com.baidu.tbadk.core.util.as("c10633").Z("tid", bjVar.getId()).Z("fid", String.valueOf(bjVar.getFid())));
            }
            h hVar = new h(author, onClickListener);
            i iVar = new i(baseActivity, bjVar, author, z, bdUniqueId);
            relativeLayout.setOnClickListener(null);
            relativeLayout.setClickable(false);
            headImageView.setVisibility(8);
            textView.setOnClickListener(hVar);
            view2.setVisibility(8);
            view3.setVisibility(8);
            View findViewWithTag = relativeLayout.findViewWithTag("frs_god_fans_count_tag");
            if (findViewWithTag == null || !(findViewWithTag instanceof TextView)) {
                TextView textView4 = new TextView(baseActivity.getActivity());
                textView4.setTextSize(0, cbv);
                textView4.setSingleLine(true);
                textView4.setIncludeFontPadding(false);
                textView4.setGravity(16);
                textView4.setTag("frs_god_fans_count_tag");
                relativeLayout.addView(textView4);
                clickableHeaderImageView = new ClickableHeaderImageView(baseActivity.getActivity());
                clickableHeaderImageView.setGodIconMargin(0);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(cbo, cbo);
                layoutParams.addRule(9);
                clickableHeaderImageView.setTag("frs_god_head_image_view_tag");
                relativeLayout.addView(clickableHeaderImageView, layoutParams);
                linearLayout.setPadding(cbp, linearLayout.getPaddingTop(), linearLayout.getPaddingRight(), linearLayout.getPaddingBottom());
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams2.addRule(11);
                layoutParams2.addRule(10);
                layoutParams2.topMargin = aiD;
                TextView textView5 = new TextView(baseActivity.getActivity());
                textView5.setTag("frs_god_btn_attention_love_tag");
                textView5.setId(w.h.btn_add_friend);
                textView5.setLayoutParams(layoutParams2);
                textView5.setTextSize(0, cbv);
                textView5.setWidth(cbs);
                textView5.setHeight(cbr);
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
            layoutParams3.topMargin = cbq;
            layoutParams3.rightMargin = cbr;
            layoutParams3.addRule(5, w.h.frs_user_tshow_icon_box);
            layoutParams3.addRule(3, w.h.frs_item_loc_view);
            if (clickableHeaderImageView != null) {
                if (com.baidu.tbadk.core.l.oQ().oS()) {
                    clickableHeaderImageView.setVisibility(0);
                    linearLayout.setPadding(cbp, linearLayout.getPaddingTop(), cbt, linearLayout.getPaddingBottom());
                    layoutParams3.leftMargin = cbp;
                    clickableHeaderImageView.setOnClickListener(onClickListener);
                    clickableHeaderImageView.c(author.getPortrait(), 28, false);
                } else {
                    clickableHeaderImageView.setVisibility(8);
                    linearLayout.setPadding(0, linearLayout.getPaddingTop(), 0, linearLayout.getPaddingBottom());
                    layoutParams3.leftMargin = 0;
                }
            }
            textView3.setLayoutParams(layoutParams3);
            textView3.setText(String.format(baseActivity.getResources().getString(w.l.fans_default_name_god_user), au.t(author.getFansNum())));
            textView3.setOnClickListener(onClickListener);
            if (textView2 != null) {
                if (!C(bjVar)) {
                    if (godUserData.getIsFromNetWork()) {
                        if (godUserData.getIsLike()) {
                            textView2.setVisibility(8);
                        } else {
                            textView2.setVisibility(0);
                            a(textView2, godUserData.getIsLike(), asVar);
                        }
                    } else {
                        textView2.setVisibility(0);
                        a(textView2, godUserData.getIsLike(), asVar);
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
                    avVar = null;
                } else {
                    view5 = viewStub.inflate();
                    avVar = new av(view5);
                    view5.setTag(avVar);
                }
            } else {
                findViewById.setVisibility(0);
                avVar = (av) findViewById.getTag();
                view5 = findViewById;
            }
            if (avVar == null) {
                return false;
            }
            if (!bjVar.sv() && !TextUtils.isEmpty(bjVar.getAddress()) && !TextUtils.isEmpty(bjVar.getAddress().trim())) {
                avVar.bOm.setVisibility(0);
                avVar.bOm.setText(bjVar.getAddress());
            } else {
                avVar.bOm.setVisibility(8);
            }
            if (bjVar.rG() != null && bjVar.rG().getNum() > 0) {
                avVar.alx.setVisibility(0);
                avVar.alx.setText(au.t(bjVar.rG().getNum()));
            } else {
                avVar.alx.setVisibility(8);
            }
            com.baidu.tieba.graffiti.c.an(avVar.alx);
            int rJ = bjVar.rJ();
            if (rJ > 0) {
                avVar.bOn.setVisibility(0);
                avVar.bOn.setText(au.w(rJ));
            } else {
                avVar.bOn.setVisibility(8);
            }
            avVar.alu.setText(au.q(bjVar.rL() * 1000));
            if (avVar.amL != i) {
                aq.j(textView2, w.g.icon_arrow_list);
                aq.c(textView3, w.e.cp_cont_d, 1);
                a(textView2, godUserData.getIsLike(), asVar);
                baseActivity.getLayoutMode().t(view5);
                avVar.amL = i;
            }
            return true;
        }
        relativeLayout.setOnClickListener(onClickListener);
        if (com.baidu.tbadk.core.l.oQ().oS()) {
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

    private static void a(TextView textView, boolean z, as asVar) {
        if (z) {
            textView.setClickable(false);
            aq.c(textView, w.e.cp_cont_d, 1);
            textView.setText(cbw);
            textView.setBackgroundDrawable(null);
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            textView.setPadding(0, 0, 0, 0);
            return;
        }
        aq.c(textView, w.e.btn_forum_focus_color, 1);
        textView.setText(cbx);
        if (asVar != null) {
            textView.setBackgroundDrawable(asVar.x(w.g.btn_focus_border_bg, TbadkCoreApplication.m9getInst().getSkinType()));
            textView.setCompoundDrawablesWithIntrinsicBounds(asVar.x(w.g.btn_focus_cross_bg, TbadkCoreApplication.m9getInst().getSkinType()), (Drawable) null, (Drawable) null, (Drawable) null);
        } else {
            aq.j(textView, w.g.btn_focus_border_bg);
            textView.setCompoundDrawablesWithIntrinsicBounds(aq.getDrawable(w.g.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        textView.setClickable(true);
        textView.setPadding(TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds18), 0, TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds10), 0);
    }

    private static boolean C(bj bjVar) {
        return (bjVar == null || bjVar.getAuthor() == null || bjVar.getAuthor().getUserId() == null || TbadkCoreApplication.getCurrentAccount() == null || !TbadkCoreApplication.getCurrentAccount().equals(bjVar.getAuthor().getUserId())) ? false : true;
    }
}
