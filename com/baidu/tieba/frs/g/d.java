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
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.data.GodUserData;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.ac;
/* loaded from: classes.dex */
public class d {
    private static final int cFn = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds76);
    private static final int cFo = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds88);
    private static final int cFp = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds4);
    private static final int ajT = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds6);
    private static final int cFq = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds50);
    private static final int cFr = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds108);
    private static final int cFs = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds128);
    private static final int cFt = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.fontsize28);
    private static final int cFu = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.fontsize24);
    private static final String cFv = TbadkCoreApplication.getInst().getString(d.l.relate_forum_is_followed);
    private static final String cFw = TbadkCoreApplication.getInst().getString(d.l.attention);

    public static boolean a(final TbPageContext<?> tbPageContext, View view, HeadImageView headImageView, TextView textView, View view2, View view3, RelativeLayout relativeLayout, LinearLayout linearLayout, View view4, final bj bjVar, int i, final View.OnClickListener onClickListener, com.baidu.tieba.frs.c cVar, final BdUniqueId bdUniqueId) {
        final MetaData author;
        GodUserData godUserData;
        ClickableHeaderImageView clickableHeaderImageView;
        TextView textView2;
        TextView textView3;
        com.baidu.tieba.frs.g gVar;
        View view5;
        if (tbPageContext == null || view == null || headImageView == null || textView == null || view2 == null || view3 == null || relativeLayout == null || linearLayout == null || view4 == null || bjVar == null || onClickListener == null || (author = bjVar.getAuthor()) == null || (godUserData = author.getGodUserData()) == null) {
            return false;
        }
        final boolean z = false;
        if (godUserData.getType() == 2) {
            z = true;
        }
        if (z) {
            if (bjVar.getFid() != 0 && !ac.ahU().e(bjVar.getFid(), bjVar.getId())) {
                ac.ahU().d(bjVar.getFid(), bjVar.getId());
                TiebaStatic.log(new ak("c10633").ad("tid", bjVar.getId()).ad("fid", String.valueOf(bjVar.getFid())));
            }
            View.OnClickListener onClickListener2 = new View.OnClickListener() { // from class: com.baidu.tieba.frs.g.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view6) {
                    TiebaStatic.log(new ak("c10632").ad("obj_id", MetaData.this.getUserId()));
                    onClickListener.onClick(view6);
                }
            };
            View.OnClickListener onClickListener3 = new View.OnClickListener() { // from class: com.baidu.tieba.frs.g.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view6) {
                    if (!com.baidu.adp.lib.util.i.hi()) {
                        TbPageContext.this.showToast(d.l.neterror);
                    } else if (ax.aT(TbPageContext.this.getPageActivity())) {
                        TiebaStatic.log(new ak("c10803").ad("tid", bjVar.getTid()).r("obj_locate", 2));
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
                textView4.setTextSize(0, cFu);
                textView4.setSingleLine(true);
                textView4.setIncludeFontPadding(false);
                textView4.setGravity(16);
                textView4.setTag("frs_god_fans_count_tag");
                relativeLayout.addView(textView4);
                clickableHeaderImageView = new ClickableHeaderImageView(tbPageContext.getPageActivity());
                clickableHeaderImageView.setPageId(bdUniqueId);
                clickableHeaderImageView.setGodIconMargin(0);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(cFn, cFn);
                layoutParams.addRule(9);
                clickableHeaderImageView.setTag("frs_god_head_image_view_tag");
                relativeLayout.addView(clickableHeaderImageView, layoutParams);
                linearLayout.setPadding(cFo, linearLayout.getPaddingTop(), linearLayout.getPaddingRight(), linearLayout.getPaddingBottom());
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams2.addRule(11);
                layoutParams2.addRule(10);
                layoutParams2.topMargin = ajT;
                TextView textView5 = new TextView(tbPageContext.getPageActivity());
                textView5.setTag("frs_god_btn_attention_love_tag");
                textView5.setId(d.h.btn_add_friend);
                textView5.setLayoutParams(layoutParams2);
                textView5.setTextSize(0, cFu);
                textView5.setWidth(cFr);
                textView5.setHeight(cFq);
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
            layoutParams3.topMargin = cFp;
            layoutParams3.rightMargin = cFq;
            layoutParams3.addRule(5, d.h.frs_user_tshow_icon_box);
            layoutParams3.addRule(3, d.h.frs_item_loc_view);
            if (clickableHeaderImageView != null) {
                if (com.baidu.tbadk.core.h.oS().oU()) {
                    clickableHeaderImageView.setVisibility(0);
                    linearLayout.setPadding(cFo, linearLayout.getPaddingTop(), cFs, linearLayout.getPaddingBottom());
                    layoutParams3.leftMargin = cFo;
                    clickableHeaderImageView.setOnClickListener(onClickListener);
                    clickableHeaderImageView.c(author.getPortrait(), 28, false);
                } else {
                    clickableHeaderImageView.setVisibility(8);
                    linearLayout.setPadding(0, linearLayout.getPaddingTop(), 0, linearLayout.getPaddingBottom());
                    layoutParams3.leftMargin = 0;
                }
            }
            textView3.setLayoutParams(layoutParams3);
            textView3.setText(String.format(tbPageContext.getResources().getString(d.l.fans_default_name_god_user), am.u(author.getFansNum())));
            textView3.setOnClickListener(onClickListener);
            if (textView2 != null) {
                if (!S(bjVar)) {
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
            if (!bjVar.sg() && !TextUtils.isEmpty(bjVar.getAddress()) && !TextUtils.isEmpty(bjVar.getAddress().trim())) {
                gVar.cqp.setVisibility(0);
                gVar.cqp.setText(bjVar.getAddress());
            } else {
                gVar.cqp.setVisibility(8);
            }
            if (bjVar.rr() != null && bjVar.rr().getNum() > 0) {
                gVar.anD.setVisibility(0);
                gVar.anD.setText(am.u(bjVar.rr().getNum()));
            } else {
                gVar.anD.setVisibility(8);
            }
            com.baidu.tieba.graffiti.b.az(gVar.anD);
            int rt = bjVar.rt();
            if (rt > 0) {
                gVar.cqq.setVisibility(0);
                gVar.cqq.setText(am.y(rt));
            } else {
                gVar.cqq.setVisibility(8);
            }
            gVar.anA.setText(am.r(bjVar.rv() * 1000));
            if (gVar.apS != i) {
                aj.j(textView2, d.g.icon_arrow_list);
                aj.c(textView3, d.e.cp_cont_d, 1);
                a(textView2, godUserData.getIsLike(), cVar);
                tbPageContext.getLayoutMode().t(view5);
                gVar.apS = i;
            }
            return true;
        }
        relativeLayout.setOnClickListener(onClickListener);
        if (com.baidu.tbadk.core.h.oS().oU()) {
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
            aj.c(textView, d.e.cp_cont_d, 1);
            textView.setText(cFv);
            textView.setBackgroundDrawable(null);
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            textView.setPadding(0, 0, 0, 0);
            return;
        }
        aj.c(textView, d.e.btn_forum_focus_color, 1);
        textView.setText(cFw);
        if (cVar != null) {
            textView.setBackgroundDrawable(cVar.u(d.g.btn_focus_border_bg, TbadkCoreApplication.getInst().getSkinType()));
            textView.setCompoundDrawablesWithIntrinsicBounds(cVar.u(d.g.btn_focus_cross_bg, TbadkCoreApplication.getInst().getSkinType()), (Drawable) null, (Drawable) null, (Drawable) null);
        } else {
            aj.j(textView, d.g.btn_focus_border_bg);
            textView.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.g.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        textView.setClickable(true);
        textView.setPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds18), 0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds10), 0);
    }

    private static boolean S(bj bjVar) {
        return (bjVar == null || bjVar.getAuthor() == null || bjVar.getAuthor().getUserId() == null || TbadkCoreApplication.getCurrentAccount() == null || !TbadkCoreApplication.getCurrentAccount().equals(bjVar.getAuthor().getUserId())) ? false : true;
    }
}
