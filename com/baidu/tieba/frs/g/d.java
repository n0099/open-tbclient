package com.baidu.tieba.frs.g;

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
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.data.GodUserData;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.ac;
/* loaded from: classes.dex */
public class d {
    private static final int cvr = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds76);
    private static final int cvs = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds88);
    private static final int cvt = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds4);
    private static final int aje = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds6);
    private static final int cvu = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds50);
    private static final int cvv = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds108);
    private static final int cvw = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds128);
    private static final int cvx = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.fontsize28);
    private static final int cvy = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.fontsize24);
    private static final String cvz = TbadkCoreApplication.getInst().getString(d.l.relate_forum_is_followed);
    private static final String cvA = TbadkCoreApplication.getInst().getString(d.l.attention);

    public static boolean a(final TbPageContext<?> tbPageContext, View view, HeadImageView headImageView, TextView textView, View view2, View view3, RelativeLayout relativeLayout, LinearLayout linearLayout, View view4, final bl blVar, int i, final View.OnClickListener onClickListener, com.baidu.tieba.frs.c cVar, final BdUniqueId bdUniqueId) {
        final MetaData author;
        GodUserData godUserData;
        ClickableHeaderImageView clickableHeaderImageView;
        TextView textView2;
        TextView textView3;
        com.baidu.tieba.frs.g gVar;
        View view5;
        if (tbPageContext == null || view == null || headImageView == null || textView == null || view2 == null || view3 == null || relativeLayout == null || linearLayout == null || view4 == null || blVar == null || onClickListener == null || (author = blVar.getAuthor()) == null || (godUserData = author.getGodUserData()) == null) {
            return false;
        }
        final boolean z = false;
        if (godUserData.getType() == 2) {
            z = true;
        }
        if (z) {
            if (blVar.getFid() != 0 && !ac.aga().e(blVar.getFid(), blVar.getId())) {
                ac.aga().d(blVar.getFid(), blVar.getId());
                TiebaStatic.log(new aj("c10633").aa("tid", blVar.getId()).aa("fid", String.valueOf(blVar.getFid())));
            }
            View.OnClickListener onClickListener2 = new View.OnClickListener() { // from class: com.baidu.tieba.frs.g.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view6) {
                    TiebaStatic.log(new aj("c10632").aa("obj_id", MetaData.this.getUserId()));
                    onClickListener.onClick(view6);
                }
            };
            View.OnClickListener onClickListener3 = new View.OnClickListener() { // from class: com.baidu.tieba.frs.g.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view6) {
                    if (!com.baidu.adp.lib.util.i.hh()) {
                        TbPageContext.this.showToast(d.l.neterror);
                    } else if (aw.aN(TbPageContext.this.getPageActivity())) {
                        TiebaStatic.log(new aj("c10803").aa("tid", blVar.getTid()).r("obj_locate", 2));
                        new com.baidu.tbadk.coreExtra.c.a(null).a(true, author.getPortrait(), author.getUserId(), z, bdUniqueId);
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
                textView4.setTextSize(0, cvy);
                textView4.setSingleLine(true);
                textView4.setIncludeFontPadding(false);
                textView4.setGravity(16);
                textView4.setTag("frs_god_fans_count_tag");
                relativeLayout.addView(textView4);
                clickableHeaderImageView = new ClickableHeaderImageView(tbPageContext.getPageActivity());
                clickableHeaderImageView.setPageId(bdUniqueId);
                clickableHeaderImageView.setGodIconMargin(0);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(cvr, cvr);
                layoutParams.addRule(9);
                clickableHeaderImageView.setTag("frs_god_head_image_view_tag");
                relativeLayout.addView(clickableHeaderImageView, layoutParams);
                linearLayout.setPadding(cvs, linearLayout.getPaddingTop(), linearLayout.getPaddingRight(), linearLayout.getPaddingBottom());
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams2.addRule(11);
                layoutParams2.addRule(10);
                layoutParams2.topMargin = aje;
                TextView textView5 = new TextView(tbPageContext.getPageActivity());
                textView5.setTag("frs_god_btn_attention_love_tag");
                textView5.setId(d.h.btn_add_friend);
                textView5.setLayoutParams(layoutParams2);
                textView5.setTextSize(0, cvy);
                textView5.setWidth(cvv);
                textView5.setHeight(cvu);
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
            layoutParams3.topMargin = cvt;
            layoutParams3.rightMargin = cvu;
            layoutParams3.addRule(5, d.h.frs_user_tshow_icon_box);
            layoutParams3.addRule(3, d.h.frs_item_loc_view);
            if (clickableHeaderImageView != null) {
                if (com.baidu.tbadk.core.h.oN().oP()) {
                    clickableHeaderImageView.setVisibility(0);
                    linearLayout.setPadding(cvs, linearLayout.getPaddingTop(), cvw, linearLayout.getPaddingBottom());
                    layoutParams3.leftMargin = cvs;
                    clickableHeaderImageView.setOnClickListener(onClickListener);
                    clickableHeaderImageView.c(author.getPortrait(), 28, false);
                } else {
                    clickableHeaderImageView.setVisibility(8);
                    linearLayout.setPadding(0, linearLayout.getPaddingTop(), 0, linearLayout.getPaddingBottom());
                    layoutParams3.leftMargin = 0;
                }
            }
            textView3.setLayoutParams(layoutParams3);
            textView3.setText(String.format(tbPageContext.getResources().getString(d.l.fans_default_name_god_user), al.u(author.getFansNum())));
            textView3.setOnClickListener(onClickListener);
            if (textView2 != null) {
                if (!O(blVar)) {
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
            View findViewById = view4.findViewById(d.h.frs_god_extra_info);
            if (findViewById == null) {
                ViewStub viewStub = (ViewStub) view4.findViewById(d.h.frs_god_extra_vs);
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
            if (!blVar.sa() && !TextUtils.isEmpty(blVar.getAddress()) && !TextUtils.isEmpty(blVar.getAddress().trim())) {
                gVar.cjc.setVisibility(0);
                gVar.cjc.setText(blVar.getAddress());
            } else {
                gVar.cjc.setVisibility(8);
            }
            if (blVar.rl() != null && blVar.rl().getNum() > 0) {
                gVar.amP.setVisibility(0);
                gVar.amP.setText(al.u(blVar.rl().getNum()));
            } else {
                gVar.amP.setVisibility(8);
            }
            com.baidu.tieba.graffiti.b.aq(gVar.amP);
            int rn = blVar.rn();
            if (rn > 0) {
                gVar.cjd.setVisibility(0);
                gVar.cjd.setText(al.z(rn));
            } else {
                gVar.cjd.setVisibility(8);
            }
            gVar.amM.setText(al.r(blVar.rp() * 1000));
            if (gVar.aoR != i) {
                ai.j(textView2, d.g.icon_arrow_list);
                ai.c(textView3, d.e.cp_cont_d, 1);
                a(textView2, godUserData.getIsLike(), cVar);
                tbPageContext.getLayoutMode().t(view5);
                gVar.aoR = i;
            }
            return true;
        }
        relativeLayout.setOnClickListener(onClickListener);
        if (com.baidu.tbadk.core.h.oN().oP()) {
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
        View findViewById2 = view4.findViewById(d.h.frs_god_extra_info);
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
            ai.c(textView, d.e.cp_cont_d, 1);
            textView.setText(cvz);
            textView.setBackgroundDrawable(null);
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            textView.setPadding(0, 0, 0, 0);
            return;
        }
        ai.c(textView, d.e.btn_forum_focus_color, 1);
        textView.setText(cvA);
        if (cVar != null) {
            textView.setBackgroundDrawable(cVar.u(d.g.btn_focus_border_bg, TbadkCoreApplication.getInst().getSkinType()));
            textView.setCompoundDrawablesWithIntrinsicBounds(cVar.u(d.g.btn_focus_cross_bg, TbadkCoreApplication.getInst().getSkinType()), (Drawable) null, (Drawable) null, (Drawable) null);
        } else {
            ai.j(textView, d.g.btn_focus_border_bg);
            textView.setCompoundDrawablesWithIntrinsicBounds(ai.getDrawable(d.g.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        textView.setClickable(true);
        textView.setPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds18), 0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds10), 0);
    }

    private static boolean O(bl blVar) {
        return (blVar == null || blVar.getAuthor() == null || blVar.getAuthor().getUserId() == null || TbadkCoreApplication.getCurrentAccount() == null || !TbadkCoreApplication.getCurrentAccount().equals(blVar.getAuthor().getUserId())) ? false : true;
    }
}
