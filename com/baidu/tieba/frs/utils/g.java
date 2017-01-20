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
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.data.GodUserData;
import com.baidu.tieba.frs.as;
import com.baidu.tieba.frs.av;
import com.baidu.tieba.frs.by;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class g {
    private static final int bUc = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.f.ds76);
    private static final int bUd = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.f.ds88);
    private static final int bUe = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.f.ds4);
    private static final int ado = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.f.ds6);
    private static final int bUf = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.f.ds50);
    private static final int bUg = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.f.ds108);
    private static final int bUh = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.f.ds128);
    private static final int bUi = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.f.fontsize28);
    private static final int bUj = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.f.fontsize24);
    private static final String bUk = TbadkCoreApplication.m9getInst().getString(r.l.relate_forum_is_followed);
    private static final String bUl = TbadkCoreApplication.m9getInst().getString(r.l.attention);

    public static boolean a(BaseActivity<?> baseActivity, View view, HeadImageView headImageView, TextView textView, View view2, View view3, RelativeLayout relativeLayout, LinearLayout linearLayout, View view4, bh bhVar, int i, View.OnClickListener onClickListener, as asVar, BdUniqueId bdUniqueId) {
        MetaData author;
        GodUserData godUserData;
        ClickableHeaderImageView clickableHeaderImageView;
        TextView textView2;
        TextView textView3;
        av avVar;
        View view5;
        if (baseActivity == null || view == null || headImageView == null || textView == null || view2 == null || view3 == null || relativeLayout == null || linearLayout == null || view4 == null || bhVar == null || onClickListener == null || (author = bhVar.getAuthor()) == null || (godUserData = author.getGodUserData()) == null) {
            return false;
        }
        boolean z = false;
        if (godUserData.getType() == 2) {
            z = true;
        }
        if (z) {
            if (bhVar.getFid() != 0 && !by.Zg().e(bhVar.getFid(), bhVar.getId())) {
                by.Zg().d(bhVar.getFid(), bhVar.getId());
                TiebaStatic.log(new ar("c10633").ab("tid", bhVar.getId()).ab("fid", String.valueOf(bhVar.getFid())));
            }
            h hVar = new h(author, onClickListener);
            i iVar = new i(baseActivity, bhVar, author, z, bdUniqueId);
            relativeLayout.setOnClickListener(null);
            relativeLayout.setClickable(false);
            headImageView.setVisibility(8);
            textView.setOnClickListener(hVar);
            view2.setVisibility(8);
            view3.setVisibility(8);
            View findViewWithTag = relativeLayout.findViewWithTag("frs_god_fans_count_tag");
            if (findViewWithTag == null || !(findViewWithTag instanceof TextView)) {
                TextView textView4 = new TextView(baseActivity.getActivity());
                textView4.setTextSize(0, bUj);
                textView4.setSingleLine(true);
                textView4.setIncludeFontPadding(false);
                textView4.setGravity(16);
                textView4.setTag("frs_god_fans_count_tag");
                relativeLayout.addView(textView4);
                clickableHeaderImageView = new ClickableHeaderImageView(baseActivity.getActivity());
                clickableHeaderImageView.setGodIconMargin(0);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(bUc, bUc);
                layoutParams.addRule(9);
                clickableHeaderImageView.setTag("frs_god_head_image_view_tag");
                relativeLayout.addView(clickableHeaderImageView, layoutParams);
                linearLayout.setPadding(bUd, linearLayout.getPaddingTop(), linearLayout.getPaddingRight(), linearLayout.getPaddingBottom());
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams2.addRule(11);
                layoutParams2.addRule(10);
                layoutParams2.topMargin = ado;
                TextView textView5 = new TextView(baseActivity.getActivity());
                textView5.setTag("frs_god_btn_attention_love_tag");
                textView5.setId(r.h.btn_add_friend);
                textView5.setLayoutParams(layoutParams2);
                textView5.setTextSize(0, bUj);
                textView5.setWidth(bUg);
                textView5.setHeight(bUf);
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
            layoutParams3.topMargin = bUe;
            layoutParams3.rightMargin = bUf;
            layoutParams3.addRule(5, r.h.frs_user_tshow_icon_box);
            layoutParams3.addRule(3, r.h.frs_item_loc_view);
            if (clickableHeaderImageView != null) {
                if (com.baidu.tbadk.core.l.oC().oE()) {
                    clickableHeaderImageView.setVisibility(0);
                    linearLayout.setPadding(bUd, linearLayout.getPaddingTop(), bUh, linearLayout.getPaddingBottom());
                    layoutParams3.leftMargin = bUd;
                    clickableHeaderImageView.setOnClickListener(onClickListener);
                    clickableHeaderImageView.c(author.getPortrait(), 28, false);
                } else {
                    clickableHeaderImageView.setVisibility(8);
                    linearLayout.setPadding(0, linearLayout.getPaddingTop(), 0, linearLayout.getPaddingBottom());
                    layoutParams3.leftMargin = 0;
                }
            }
            textView3.setLayoutParams(layoutParams3);
            textView3.setText(String.format(baseActivity.getResources().getString(r.l.fans_default_name_god_user), at.u(author.getFansNum())));
            textView3.setOnClickListener(onClickListener);
            if (textView2 != null) {
                if (!C(bhVar)) {
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
            View findViewById = view4.findViewById(r.h.frs_god_extra_info);
            if (findViewById == null) {
                ViewStub viewStub = (ViewStub) view4.findViewById(r.h.frs_god_extra_vs);
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
            if (!bhVar.sa() && !TextUtils.isEmpty(bhVar.getAddress()) && !TextUtils.isEmpty(bhVar.getAddress().trim())) {
                avVar.bHd.setVisibility(0);
                avVar.bHd.setText(bhVar.getAddress());
            } else {
                avVar.bHd.setVisibility(8);
            }
            if (bhVar.rn() != null && bhVar.rn().getNum() > 0) {
                avVar.agf.setVisibility(0);
                avVar.agf.setText(at.u(bhVar.rn().getNum()));
            } else {
                avVar.agf.setVisibility(8);
            }
            com.baidu.tieba.graffiti.c.ap(avVar.agf);
            int rp = bhVar.rp();
            if (rp > 0) {
                avVar.bHe.setVisibility(0);
                avVar.bHe.setText(at.w(rp));
            } else {
                avVar.bHe.setVisibility(8);
            }
            avVar.agb.setText(at.r(bhVar.rr() * 1000));
            if (avVar.ahp != i) {
                ap.j((View) textView2, r.g.icon_arrow_list);
                ap.c(textView3, r.e.cp_cont_d, 1);
                a(textView2, godUserData.getIsLike(), asVar);
                baseActivity.getLayoutMode().v(view5);
                avVar.ahp = i;
            }
            return true;
        }
        relativeLayout.setOnClickListener(onClickListener);
        if (com.baidu.tbadk.core.l.oC().oE()) {
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
        View findViewById2 = view4.findViewById(r.h.frs_god_extra_info);
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
            ap.c(textView, r.e.cp_cont_d, 1);
            textView.setText(bUk);
            textView.setBackgroundDrawable(null);
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            textView.setPadding(0, 0, 0, 0);
            return;
        }
        ap.c(textView, r.e.btn_forum_focus_color, 1);
        textView.setText(bUl);
        if (asVar != null) {
            textView.setBackgroundDrawable(asVar.r(r.g.btn_focus_border_bg, TbadkCoreApplication.m9getInst().getSkinType()));
            textView.setCompoundDrawablesWithIntrinsicBounds(asVar.r(r.g.btn_focus_cross_bg, TbadkCoreApplication.m9getInst().getSkinType()), (Drawable) null, (Drawable) null, (Drawable) null);
        } else {
            ap.j((View) textView, r.g.btn_focus_border_bg);
            textView.setCompoundDrawablesWithIntrinsicBounds(ap.getDrawable(r.g.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        textView.setClickable(true);
        textView.setPadding(TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.f.ds18), 0, TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.f.ds10), 0);
    }

    private static boolean C(bh bhVar) {
        return (bhVar == null || bhVar.getAuthor() == null || bhVar.getAuthor().getUserId() == null || TbadkCoreApplication.getCurrentAccount() == null || !TbadkCoreApplication.getCurrentAccount().equals(bhVar.getAuthor().getUserId())) ? false : true;
    }
}
