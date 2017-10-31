package com.baidu.tieba.frs.f;

import android.annotation.SuppressLint;
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
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.data.GodUserData;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.ad;
/* loaded from: classes.dex */
public class d {
    private static final int cPZ = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds76);
    private static final int cQa = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds88);
    private static final int DS4 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds4);
    private static final int DS6 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds6);
    private static final int cQb = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds50);
    private static final int cQc = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds108);
    private static final int cQd = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds128);
    private static final int cQe = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.fontsize24);
    private static final String cQf = TbadkCoreApplication.getInst().getString(d.j.relate_forum_is_followed);
    private static final String cQg = TbadkCoreApplication.getInst().getString(d.j.attention);

    public static boolean a(final TbPageContext<?> tbPageContext, View view, HeadImageView headImageView, TextView textView, View view2, View view3, RelativeLayout relativeLayout, LinearLayout linearLayout, View view4, final bh bhVar, int i, final View.OnClickListener onClickListener, com.baidu.tieba.frs.c cVar, final BdUniqueId bdUniqueId) {
        final MetaData rt;
        GodUserData godUserData;
        ClickableHeaderImageView clickableHeaderImageView;
        TextView textView2;
        TextView textView3;
        com.baidu.tieba.frs.g gVar;
        View view5;
        if (tbPageContext == null || view == null || headImageView == null || textView == null || view2 == null || view3 == null || relativeLayout == null || linearLayout == null || view4 == null || bhVar == null || onClickListener == null || (rt = bhVar.rt()) == null || (godUserData = rt.getGodUserData()) == null) {
            return false;
        }
        final boolean z = false;
        if (godUserData.getType() == 2) {
            z = true;
        }
        if (z) {
            if (bhVar.getFid() != 0 && !ad.akg().e(bhVar.getFid(), bhVar.getId())) {
                ad.akg().d(bhVar.getFid(), bhVar.getId());
                TiebaStatic.log(new ak("c10633").ac("tid", bhVar.getId()).ac(ImageViewerConfig.FORUM_ID, String.valueOf(bhVar.getFid())));
            }
            View.OnClickListener onClickListener2 = new View.OnClickListener() { // from class: com.baidu.tieba.frs.f.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view6) {
                    TiebaStatic.log(new ak("c10632").ac("obj_id", MetaData.this.getUserId()));
                    onClickListener.onClick(view6);
                }
            };
            View.OnClickListener onClickListener3 = new View.OnClickListener() { // from class: com.baidu.tieba.frs.f.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view6) {
                    if (!com.baidu.adp.lib.util.j.hh()) {
                        TbPageContext.this.showToast(d.j.neterror);
                    } else if (ax.aT(TbPageContext.this.getPageActivity())) {
                        TiebaStatic.log(new ak("c10803").ac("tid", bhVar.getTid()).r("obj_locate", 2));
                        new com.baidu.tbadk.coreExtra.c.a(null).a(true, rt.getPortrait(), rt.getUserId(), z, bdUniqueId);
                    }
                }
            };
            relativeLayout.setOnClickListener(null);
            relativeLayout.setClickable(false);
            headImageView.setVisibility(8);
            textView.setOnClickListener(onClickListener2);
            view2.setVisibility(8);
            view3.setVisibility(8);
            View findViewWithTag = relativeLayout.findViewWithTag("frs_god_fans_count_tag");
            if (findViewWithTag == null || !(findViewWithTag instanceof TextView)) {
                TextView textView4 = new TextView(tbPageContext.getPageActivity());
                textView4.setTextSize(0, cQe);
                textView4.setSingleLine(true);
                textView4.setIncludeFontPadding(false);
                textView4.setGravity(16);
                textView4.setTag("frs_god_fans_count_tag");
                relativeLayout.addView(textView4);
                clickableHeaderImageView = new ClickableHeaderImageView(tbPageContext.getPageActivity());
                clickableHeaderImageView.setPageId(bdUniqueId);
                clickableHeaderImageView.setGodIconMargin(0);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(cPZ, cPZ);
                layoutParams.addRule(9);
                clickableHeaderImageView.setTag("frs_god_head_image_view_tag");
                relativeLayout.addView(clickableHeaderImageView, layoutParams);
                linearLayout.setPadding(cQa, linearLayout.getPaddingTop(), linearLayout.getPaddingRight(), linearLayout.getPaddingBottom());
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams2.addRule(11);
                layoutParams2.addRule(10);
                layoutParams2.topMargin = DS6;
                TextView textView5 = new TextView(tbPageContext.getPageActivity());
                textView5.setTag("frs_god_btn_attention_love_tag");
                textView5.setId(d.g.btn_add_friend);
                textView5.setLayoutParams(layoutParams2);
                textView5.setTextSize(0, cQe);
                textView5.setWidth(cQc);
                textView5.setHeight(cQb);
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
                textView2.setOnClickListener(onClickListener3);
            }
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams3.topMargin = DS4;
            layoutParams3.rightMargin = cQb;
            layoutParams3.addRule(5, d.g.frs_user_tshow_icon_box);
            layoutParams3.addRule(3, d.g.frs_item_loc_view);
            if (clickableHeaderImageView != null) {
                if (com.baidu.tbadk.core.h.oT().oV()) {
                    clickableHeaderImageView.setVisibility(0);
                    linearLayout.setPadding(cQa, linearLayout.getPaddingTop(), cQd, linearLayout.getPaddingBottom());
                    layoutParams3.leftMargin = cQa;
                    clickableHeaderImageView.setOnClickListener(onClickListener);
                    clickableHeaderImageView.startLoad(rt.getPortrait(), 28, false);
                } else {
                    clickableHeaderImageView.setVisibility(8);
                    linearLayout.setPadding(0, linearLayout.getPaddingTop(), 0, linearLayout.getPaddingBottom());
                    layoutParams3.leftMargin = 0;
                }
            }
            textView3.setLayoutParams(layoutParams3);
            textView3.setText(String.format(tbPageContext.getResources().getString(d.j.fans_default_name_god_user), am.u(rt.getFansNum())));
            textView3.setOnClickListener(onClickListener);
            if (textView2 != null) {
                if (!P(bhVar)) {
                    if (godUserData.getIsFromNetWork()) {
                        if (godUserData.getIsLike()) {
                            textView2.setVisibility(8);
                        } else {
                            textView2.setVisibility(0);
                            a(textView2, godUserData.getIsLike(), cVar);
                        }
                    } else {
                        textView2.setVisibility(0);
                        a(textView2, godUserData.getIsLike(), cVar);
                    }
                } else {
                    textView2.setVisibility(8);
                }
            }
            View findViewById = view4.findViewById(d.g.frs_god_extra_info);
            if (findViewById == null) {
                ViewStub viewStub = (ViewStub) view4.findViewById(d.g.frs_god_extra_vs);
                if (viewStub == null) {
                    view5 = findViewById;
                    gVar = null;
                } else {
                    view5 = viewStub.inflate();
                    gVar = new com.baidu.tieba.frs.g(view5);
                    view5.setTag(gVar);
                }
            } else {
                findViewById.setVisibility(0);
                gVar = (com.baidu.tieba.frs.g) findViewById.getTag();
                view5 = findViewById;
            }
            if (gVar == null) {
                return false;
            }
            if (!bhVar.rZ() && !TextUtils.isEmpty(bhVar.getAddress()) && !TextUtils.isEmpty(bhVar.getAddress().trim())) {
                gVar.cyN.setVisibility(0);
                gVar.cyN.setText(bhVar.getAddress());
            } else {
                gVar.cyN.setVisibility(8);
            }
            if (bhVar.ri() != null && bhVar.ri().getNum() > 0) {
                gVar.amU.setVisibility(0);
                gVar.amU.setText(am.u(bhVar.ri().getNum()));
            } else {
                gVar.amU.setVisibility(8);
            }
            gVar.amU.setVisibility(8);
            int rl = bhVar.rl();
            if (rl > 0) {
                gVar.cyO.setVisibility(0);
                gVar.cyO.setText(am.y(rl));
            } else {
                gVar.cyO.setVisibility(8);
            }
            gVar.amR.setText(am.r(bhVar.rn() * 1000));
            if (gVar.api != i) {
                aj.j(textView2, d.f.icon_arrow_list);
                aj.c(textView3, d.C0080d.cp_cont_d, 1);
                a(textView2, godUserData.getIsLike(), cVar);
                tbPageContext.getLayoutMode().t(view5);
                gVar.api = i;
            }
            return true;
        }
        relativeLayout.setOnClickListener(onClickListener);
        if (com.baidu.tbadk.core.h.oT().oV()) {
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
        View findViewById2 = view4.findViewById(d.g.frs_god_extra_info);
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

    @SuppressLint({"ResourceAsColor"})
    private static void a(TextView textView, boolean z, com.baidu.tieba.frs.c cVar) {
        if (z) {
            textView.setClickable(false);
            aj.c(textView, d.C0080d.cp_cont_d, 1);
            textView.setText(cQf);
            textView.setBackgroundDrawable(null);
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            textView.setPadding(0, 0, 0, 0);
            return;
        }
        aj.c(textView, d.C0080d.btn_forum_focus_color, 1);
        textView.setText(cQg);
        if (cVar != null) {
            textView.setBackgroundDrawable(cVar.u(d.f.btn_focus_border_bg, TbadkCoreApplication.getInst().getSkinType()));
            textView.setCompoundDrawablesWithIntrinsicBounds(cVar.u(d.f.btn_focus_cross_bg, TbadkCoreApplication.getInst().getSkinType()), (Drawable) null, (Drawable) null, (Drawable) null);
        } else {
            aj.j(textView, d.f.btn_focus_border_bg);
            textView.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.f.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        textView.setClickable(true);
        textView.setPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds18), 0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds10), 0);
    }

    private static boolean P(bh bhVar) {
        return (bhVar == null || bhVar.rt() == null || bhVar.rt().getUserId() == null || TbadkCoreApplication.getCurrentAccount() == null || !TbadkCoreApplication.getCurrentAccount().equals(bhVar.rt().getUserId())) ? false : true;
    }
}
