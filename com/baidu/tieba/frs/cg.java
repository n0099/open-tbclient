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
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.GodHeadImageView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.data.GodUserData;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class cg {
    private static final int biG = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(t.e.ds76);
    private static final int biH = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(t.e.ds88);
    private static final int biI = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(t.e.ds4);
    private static final int afp = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(t.e.ds6);
    private static final int biJ = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(t.e.ds50);
    private static final int biK = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(t.e.ds108);
    private static final int biL = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(t.e.ds128);
    private static final int biM = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(t.e.fontsize28);
    private static final int biN = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(t.e.fontsize24);
    private static final String biO = TbadkCoreApplication.m411getInst().getString(t.j.relate_forum_is_followed);
    private static final String biP = TbadkCoreApplication.m411getInst().getString(t.j.forum_list_attention_tv);

    public static void a(BaseActivity<?> baseActivity, View view, HeadImageView headImageView, TextView textView, View view2, View view3, RelativeLayout relativeLayout, LinearLayout linearLayout, View view4, com.baidu.tbadk.core.data.ah ahVar, int i, View.OnClickListener onClickListener, bu buVar) {
        GodUserData godUserData;
        GodHeadImageView godHeadImageView;
        TextView textView2;
        TextView textView3;
        if (baseActivity != null && view != null && headImageView != null && textView != null && view2 != null && view3 != null && relativeLayout != null && linearLayout != null && view4 != null && ahVar != null && onClickListener != null) {
            boolean z = false;
            MetaData author = ahVar.getAuthor();
            if (author != null && (godUserData = author.getGodUserData()) != null) {
                if (godUserData.getType() == 2) {
                    z = true;
                }
                com.baidu.tbadk.coreExtra.d.a aVar = new com.baidu.tbadk.coreExtra.d.a(null);
                if (z) {
                    if (ahVar.getFid() != 0 && !ex.QB().e(ahVar.getFid(), ahVar.getId())) {
                        ex.QB().d(ahVar.getFid(), ahVar.getId());
                        TiebaStatic.log(new com.baidu.tbadk.core.util.au("c10633").aa("tid", ahVar.getId()).aa(ImageViewerConfig.FORUM_ID, String.valueOf(ahVar.getFid())));
                    }
                    ch chVar = new ch(author, onClickListener);
                    ci ciVar = new ci(baseActivity, ahVar, aVar, author);
                    relativeLayout.setOnClickListener(null);
                    relativeLayout.setClickable(false);
                    headImageView.setVisibility(8);
                    textView.setTextSize(0, biM);
                    textView.setOnClickListener(chVar);
                    view2.setVisibility(8);
                    view3.setVisibility(8);
                    View findViewWithTag = relativeLayout.findViewWithTag("frs_god_fans_count_tag");
                    if (findViewWithTag == null || !(findViewWithTag instanceof TextView)) {
                        TextView textView4 = new TextView(baseActivity.getActivity());
                        textView4.setTextSize(0, biN);
                        textView4.setSingleLine(true);
                        textView4.setIncludeFontPadding(false);
                        textView4.setGravity(16);
                        textView4.setTag("frs_god_fans_count_tag");
                        relativeLayout.addView(textView4);
                        GodHeadImageView godHeadImageView2 = new GodHeadImageView(baseActivity.getActivity());
                        godHeadImageView2.setShapeType(2);
                        godHeadImageView2.setShowType(1);
                        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(biG, biG);
                        layoutParams.addRule(9);
                        godHeadImageView2.setTag("frs_god_head_image_view_tag");
                        relativeLayout.addView(godHeadImageView2, layoutParams);
                        linearLayout.setPadding(biH, linearLayout.getPaddingTop(), linearLayout.getPaddingRight(), linearLayout.getPaddingBottom());
                        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                        layoutParams2.addRule(11);
                        layoutParams2.addRule(10);
                        layoutParams2.topMargin = afp;
                        TextView textView5 = new TextView(baseActivity.getActivity());
                        textView5.setTag("frs_god_btn_attention_love_tag");
                        textView5.setId(t.g.btn_add_friend);
                        textView5.setLayoutParams(layoutParams2);
                        textView5.setTextSize(0, biN);
                        textView5.setWidth(biK);
                        textView5.setHeight(biJ);
                        textView5.setGravity(17);
                        relativeLayout.addView(textView5);
                        godHeadImageView = godHeadImageView2;
                        textView2 = textView5;
                        textView3 = textView4;
                    } else {
                        TextView textView6 = (TextView) findViewWithTag;
                        textView6.setVisibility(0);
                        godHeadImageView = (GodHeadImageView) relativeLayout.findViewWithTag("frs_god_head_image_view_tag");
                        textView2 = (TextView) relativeLayout.findViewWithTag("frs_god_btn_attention_love_tag");
                        textView3 = textView6;
                    }
                    if (textView2 != null) {
                        textView2.setOnClickListener(ciVar);
                    }
                    RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams3.topMargin = biI;
                    layoutParams3.rightMargin = biJ;
                    layoutParams3.addRule(5, t.g.frs_user_tshow_icon_box);
                    layoutParams3.addRule(3, t.g.frs_item_loc_view);
                    if (godHeadImageView != null) {
                        if (com.baidu.tbadk.core.l.rn().rp()) {
                            godHeadImageView.setVisibility(0);
                            linearLayout.setPadding(biH, linearLayout.getPaddingTop(), biL, linearLayout.getPaddingBottom());
                            layoutParams3.leftMargin = biH;
                            godHeadImageView.setOnClickListener(onClickListener);
                            godHeadImageView.d(author.getPortrait(), 28, false);
                        } else {
                            godHeadImageView.setVisibility(8);
                            linearLayout.setPadding(0, linearLayout.getPaddingTop(), 0, linearLayout.getPaddingBottom());
                            layoutParams3.leftMargin = 0;
                        }
                    }
                    textView3.setLayoutParams(layoutParams3);
                    textView3.setText(String.format(baseActivity.getResources().getString(t.j.fans_default_name_god_user), com.baidu.tbadk.core.util.aw.x(author.getFansNum())));
                    textView3.setOnClickListener(onClickListener);
                    if (textView2 != null) {
                        if (!f(ahVar)) {
                            if (godUserData.getIsFromNetWork()) {
                                if (godUserData.getFollowed() == 1) {
                                    textView2.setVisibility(8);
                                } else {
                                    textView2.setVisibility(0);
                                    a(textView2, godUserData.getFollowed() == 1, buVar);
                                }
                            } else {
                                textView2.setVisibility(0);
                                a(textView2, godUserData.getFollowed() == 1, buVar);
                            }
                        } else {
                            textView2.setVisibility(8);
                        }
                    }
                    cj cjVar = null;
                    View findViewById = view4.findViewById(t.g.frs_god_extra_info);
                    if (findViewById == null) {
                        ViewStub viewStub = (ViewStub) view4.findViewById(t.g.frs_god_extra_vs);
                        if (viewStub != null) {
                            View inflate = viewStub.inflate();
                            cj cjVar2 = new cj(inflate);
                            inflate.setTag(cjVar2);
                            cjVar = cjVar2;
                            findViewById = inflate;
                        }
                    } else {
                        findViewById.setVisibility(0);
                        cjVar = (cj) findViewById.getTag();
                    }
                    if (cjVar != null) {
                        if (ahVar != null && !ahVar.tF() && !TextUtils.isEmpty(ahVar.getAddress()) && !TextUtils.isEmpty(ahVar.getAddress().trim())) {
                            cjVar.biV.setVisibility(0);
                            cjVar.biV.setText(ahVar.getAddress());
                        } else {
                            cjVar.biV.setVisibility(8);
                        }
                        if (ahVar.getPraise() != null && ahVar.getPraise().getNum() > 0) {
                            cjVar.ahn.setVisibility(0);
                            cjVar.ahn.setText(com.baidu.tbadk.core.util.aw.x(ahVar.getPraise().getNum()));
                        } else {
                            cjVar.ahn.setVisibility(8);
                        }
                        int reply_num = ahVar.getReply_num();
                        if (reply_num > 0) {
                            cjVar.beY.setVisibility(0);
                            cjVar.beY.setText(com.baidu.tbadk.core.util.aw.y(reply_num));
                        } else {
                            cjVar.beY.setVisibility(8);
                        }
                        cjVar.ahm.setText(com.baidu.tbadk.core.util.aw.t(ahVar.getLast_time_int() * 1000));
                        if (cjVar.ahU != i) {
                            com.baidu.tbadk.core.util.ar.k(textView2, t.f.icon_arrow_list);
                            com.baidu.tbadk.core.util.ar.b(textView3, t.d.cp_cont_d, 1);
                            a(textView2, godUserData.getFollowed() == 1, buVar);
                            if (godHeadImageView != null) {
                                godHeadImageView.wP();
                            }
                            if (findViewById != null) {
                                baseActivity.getLayoutMode().x(findViewById);
                            }
                            cjVar.ahU = i;
                            return;
                        }
                        return;
                    }
                    return;
                }
                relativeLayout.setOnClickListener(onClickListener);
                if (com.baidu.tbadk.core.l.rn().rp()) {
                    headImageView.setVisibility(0);
                }
                textView.setTextSize(0, biM);
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
            }
        }
    }

    private static void a(TextView textView, boolean z, bu buVar) {
        if (z) {
            textView.setClickable(false);
            com.baidu.tbadk.core.util.ar.b(textView, t.d.cp_cont_d, 1);
            textView.setText(biO);
            textView.setBackgroundDrawable(null);
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            textView.setPadding(0, 0, 0, 0);
            return;
        }
        com.baidu.tbadk.core.util.ar.b(textView, t.d.btn_forum_focus_color, 1);
        textView.setText(biP);
        if (buVar != null) {
            textView.setBackgroundDrawable(buVar.s(t.f.btn_focus_border_bg, TbadkCoreApplication.m411getInst().getSkinType()));
            textView.setCompoundDrawablesWithIntrinsicBounds(buVar.s(t.f.btn_focus_cross_bg, TbadkCoreApplication.m411getInst().getSkinType()), (Drawable) null, (Drawable) null, (Drawable) null);
        } else {
            com.baidu.tbadk.core.util.ar.k(textView, t.f.btn_focus_border_bg);
            textView.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.ar.getDrawable(t.f.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        textView.setClickable(true);
        textView.setPadding(TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(t.e.ds18), 0, TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(t.e.ds10), 0);
    }

    private static boolean f(com.baidu.tbadk.core.data.ah ahVar) {
        return (ahVar == null || ahVar.getAuthor() == null || ahVar.getAuthor().getUserId() == null || TbadkCoreApplication.getCurrentAccount() == null || !TbadkCoreApplication.getCurrentAccount().equals(ahVar.getAuthor().getUserId())) ? false : true;
    }
}
