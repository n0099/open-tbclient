package com.baidu.tieba.frs;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class ca {
    private static final int bfY = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(n.e.ds70);
    private static final int bfZ = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(n.e.ds100);
    private static final int bga = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(n.e.ds20);
    private static final int bgb = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(n.e.ds18);
    private static final int bgc = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(n.e.ds16);
    private static final int bgd = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(n.e.ds50);
    private static final int bge = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(n.e.fontsize32);
    private static final int bgf = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(n.e.fontsize28);
    private static final int bgg = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(n.e.fontsize20);

    public static void a(BaseActivity<?> baseActivity, View view, View view2, TextView textView, View view3, View view4, RelativeLayout relativeLayout, View view5, com.baidu.tbadk.core.data.z zVar, int i, View.OnClickListener onClickListener) {
        View view6;
        TextView textView2;
        cc ccVar;
        View view7;
        if (baseActivity != null && view != null && view2 != null && textView != null && view3 != null && view4 != null && relativeLayout != null && view5 != null && zVar != null) {
            boolean z = false;
            if (zVar.getAuthor() != null && zVar.getAuthor().getGodInfo() != null) {
                z = true;
            }
            if (z) {
                if (zVar.ss() != 0 && !em.Oz().e(zVar.ss(), zVar.getId())) {
                    em.Oz().d(zVar.ss(), zVar.getId());
                    TiebaStatic.log(new com.baidu.tbadk.core.util.av("c10633").aa("tid", zVar.getId()).aa(ImageViewerConfig.FORUM_ID, String.valueOf(zVar.ss())));
                }
                cb cbVar = new cb(zVar, onClickListener);
                com.baidu.tbadk.core.util.as.i(view, n.f.frs_item_control_btn_trans_bg);
                view.setClickable(true);
                view.setOnClickListener(cbVar);
                relativeLayout.setOnClickListener(null);
                relativeLayout.setClickable(false);
                view2.setOnClickListener(cbVar);
                ViewGroup.MarginLayoutParams marginLayoutParams = null;
                if (view2.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                    marginLayoutParams = (ViewGroup.MarginLayoutParams) view2.getLayoutParams();
                }
                if (marginLayoutParams == null) {
                    marginLayoutParams = new LinearLayout.LayoutParams(bfY, bfY);
                } else {
                    marginLayoutParams.rightMargin = bgb;
                }
                marginLayoutParams.width = bfZ;
                marginLayoutParams.height = bfZ;
                textView.setTextSize(0, bge);
                view3.setVisibility(8);
                view4.setVisibility(8);
                View findViewWithTag = relativeLayout.findViewWithTag("frs_god_intro_tag");
                if (findViewWithTag == null || !(findViewWithTag instanceof TextView)) {
                    TextView textView3 = new TextView(baseActivity.getActivity());
                    textView3.setTextSize(0, bgg);
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.topMargin = bgc;
                    layoutParams.rightMargin = bgd;
                    layoutParams.addRule(5, n.g.frs_user_tshow_icon_box);
                    layoutParams.addRule(3, n.g.frs_item_loc_view);
                    textView3.setLayoutParams(layoutParams);
                    textView3.setSingleLine(true);
                    textView3.setEllipsize(TextUtils.TruncateAt.END);
                    textView3.setIncludeFontPadding(false);
                    textView3.setGravity(16);
                    textView3.setTag("frs_god_intro_tag");
                    relativeLayout.addView(textView3);
                    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams2.addRule(11);
                    layoutParams2.addRule(15);
                    View imageView = new ImageView(baseActivity.getActivity());
                    imageView.setTag("frs_god_arrow_tag");
                    imageView.setLayoutParams(layoutParams2);
                    relativeLayout.addView(imageView);
                    view6 = imageView;
                    textView2 = textView3;
                } else {
                    TextView textView4 = (TextView) findViewWithTag;
                    textView4.setVisibility(0);
                    View findViewWithTag2 = relativeLayout.findViewWithTag("frs_god_arrow_tag");
                    if (findViewWithTag2 != null) {
                        findViewWithTag2.setVisibility(0);
                    }
                    view6 = findViewWithTag2;
                    textView2 = textView4;
                }
                if (textView2 != null) {
                    if (StringUtils.isNull(zVar.getAuthor().getGodInfo().intro, true)) {
                        textView2.setText(n.j.god_intro_default);
                    } else {
                        textView2.setText(zVar.getAuthor().getGodInfo().intro);
                    }
                }
                View findViewById = view5.findViewById(n.g.frs_god_extra_info);
                if (findViewById == null) {
                    ViewStub viewStub = (ViewStub) view5.findViewById(n.g.frs_god_extra_vs);
                    if (viewStub == null) {
                        view7 = findViewById;
                        ccVar = null;
                    } else {
                        view7 = viewStub.inflate();
                        ccVar = new cc(view7);
                        view7.setTag(ccVar);
                    }
                } else {
                    findViewById.setVisibility(0);
                    ccVar = (cc) findViewById.getTag();
                    view7 = findViewById;
                }
                if (zVar != null && !zVar.sJ() && !TextUtils.isEmpty(zVar.getAddress()) && !TextUtils.isEmpty(zVar.getAddress().trim())) {
                    ccVar.bgj.setVisibility(0);
                    ccVar.bgk.setVisibility(0);
                    ccVar.bgj.setText(zVar.getAddress());
                } else {
                    ccVar.bgj.setVisibility(8);
                    ccVar.bgk.setVisibility(8);
                }
                if (zVar.getPraise() != null && zVar.getPraise().getNum() > 0) {
                    ccVar.agz.setVisibility(0);
                    ccVar.agz.setText(com.baidu.tbadk.core.util.ax.x(zVar.getPraise().getNum()));
                } else {
                    ccVar.agz.setVisibility(8);
                }
                int reply_num = zVar.getReply_num();
                if (reply_num > 0) {
                    ccVar.bcG.setVisibility(0);
                    ccVar.bcG.setText(com.baidu.tbadk.core.util.ax.x(reply_num));
                } else {
                    ccVar.bcG.setVisibility(8);
                }
                ccVar.agy.setText(com.baidu.tbadk.core.util.ax.s(zVar.getLast_time_int() * 1000));
                if (ccVar.ahf != i) {
                    com.baidu.tbadk.core.util.as.i(view6, n.f.icon_arrow_list);
                    com.baidu.tbadk.core.util.as.b(textView2, n.d.cp_cont_h, 1);
                    com.baidu.tbadk.core.util.as.i((View) textView2, n.f.icon_shen);
                    if (view7 != null) {
                        baseActivity.getLayoutMode().k(view7);
                    }
                    ccVar.ahf = i;
                    return;
                }
                return;
            }
            view.setBackgroundDrawable(null);
            view.setClickable(false);
            relativeLayout.setOnClickListener(onClickListener);
            view2.setOnClickListener(onClickListener);
            relativeLayout.setClickable(true);
            ViewGroup.LayoutParams layoutParams3 = null;
            if (view2.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                layoutParams3 = (LinearLayout.LayoutParams) view2.getLayoutParams();
                ((LinearLayout.LayoutParams) layoutParams3).rightMargin = bga;
            } else if (view2.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                layoutParams3 = (RelativeLayout.LayoutParams) view2.getLayoutParams();
                ((RelativeLayout.LayoutParams) layoutParams3).rightMargin = bga;
            }
            if (layoutParams3 == null) {
                layoutParams3 = new LinearLayout.LayoutParams(bfY, bfY);
            }
            layoutParams3.width = bfY;
            layoutParams3.height = bfY;
            textView.setTextSize(0, bgf);
            view3.setVisibility(0);
            view4.setVisibility(0);
            View findViewWithTag3 = relativeLayout.findViewWithTag("frs_god_intro_tag");
            if (findViewWithTag3 != null) {
                findViewWithTag3.setVisibility(8);
            }
            View findViewById2 = view5.findViewById(n.g.frs_god_extra_info);
            if (findViewById2 != null) {
                findViewById2.setVisibility(8);
            }
            View findViewWithTag4 = relativeLayout.findViewWithTag("frs_god_arrow_tag");
            if (findViewWithTag4 != null) {
                findViewWithTag4.setVisibility(8);
            }
        }
    }
}
