package com.baidu.tieba.frs.e;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.widget.LinearGradientView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.headerimage.FrsHeaderBannerView;
/* loaded from: classes9.dex */
public class g {
    public RelativeLayout fpe;
    public LinearGradientView hKZ;
    public BarImageView hLa;
    public TextView hLb;
    public FrsHeaderBannerView hLc;
    public LinearLayout hLd;
    public ImageView hLe;
    public View hLf;
    public TbImageView hLg;
    public ImageView hLh;
    public ImageView hLi;
    public ImageView hLj;
    public ImageView hLk;
    public View mRootView;

    public g(final Context context) {
        if (context != null) {
            this.mRootView = LayoutInflater.from(context).inflate(R.layout.frs_fake_view, (ViewGroup) null);
            this.fpe = (RelativeLayout) this.mRootView.findViewById(R.id.head_top_bg_container);
            this.hKZ = (LinearGradientView) this.mRootView.findViewById(R.id.head_top_gradient_bg);
            this.hLg = (TbImageView) this.mRootView.findViewById(R.id.head_top_bg_mask);
            this.hLg.setDefaultBgResource(R.color.transparent);
            this.hLg.setDefaultResource(R.drawable.pic_frs_head_default);
            this.hLa = (BarImageView) this.mRootView.findViewById(R.id.frs_image);
            this.hLb = (TextView) this.mRootView.findViewById(R.id.forum_name);
            am.setViewTextColor(this.hLb, (int) R.color.cp_cont_a);
            this.hLc = (FrsHeaderBannerView) this.mRootView.findViewById(R.id.frs_header_banner);
            this.hLd = (LinearLayout) this.mRootView.findViewById(R.id.fake_content_layout);
            this.hLe = (ImageView) this.mRootView.findViewById(R.id.fake_content_img);
            this.hLf = this.mRootView.findViewById(R.id.header_round_corner_layout);
            this.hLh = (ImageView) this.mRootView.findViewById(R.id.fake_return_icon);
            this.hLi = (ImageView) this.mRootView.findViewById(R.id.fake_share_icon);
            this.hLj = (ImageView) this.mRootView.findViewById(R.id.fake_information_icon);
            this.hLk = (ImageView) this.mRootView.findViewById(R.id.fake_search_icon);
            this.hLh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.e.g.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (context instanceof Activity) {
                        ((Activity) context).finish();
                    }
                }
            });
            this.hLa.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            this.hLa.setContentDescription(context.getResources().getString(R.string.bar_header));
            this.hLa.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds4));
            this.hLa.setShowOval(true);
            this.hLa.setBorderColor(am.getColor(R.color.black_alpha15));
            this.hLa.setStrokeColorResId(R.color.cp_bg_line_d);
            am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
            am.setBackgroundResource(this.hLf, R.drawable.bg_frs_header_round_corner);
            am.setImageResource(this.hLh, R.drawable.icon_topbar_return_white_n);
            SvgManager.aUW().a(this.hLi, R.drawable.icon_pure_topbar_share44_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
            SvgManager.aUW().a(this.hLj, R.drawable.icon_pure_topbar_information44_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
            SvgManager.aUW().a(this.hLk, R.drawable.icon_pure_topbar_search44_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
            SvgManager.aUW().a(this.hLe, R.drawable.bg_pure_loadingskeleton_svg, R.color.cp_bg_line_c, SvgManager.SvgResourceStateType.NORMAL);
        }
    }
}
