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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.widget.LinearGradientView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.headerimage.FrsHeaderBannerView;
/* loaded from: classes16.dex */
public class g {
    public RelativeLayout fFA;
    public LinearGradientView ien;
    public BarImageView ieo;
    public TextView iep;
    public FrsHeaderBannerView ieq;
    public LinearLayout ier;
    public ImageView ies;
    public View iet;
    public TbImageView ieu;
    public ImageView iev;
    public ImageView iew;
    public ImageView iex;
    public ImageView iey;
    public View mRootView;

    public g(final Context context) {
        if (context != null) {
            this.mRootView = LayoutInflater.from(context).inflate(R.layout.frs_fake_view, (ViewGroup) null);
            this.fFA = (RelativeLayout) this.mRootView.findViewById(R.id.head_top_bg_container);
            this.ien = (LinearGradientView) this.mRootView.findViewById(R.id.head_top_gradient_bg);
            this.ieu = (TbImageView) this.mRootView.findViewById(R.id.head_top_bg_mask);
            this.ieu.setDefaultBgResource(R.color.transparent);
            this.ieu.setDefaultResource(R.drawable.pic_frs_head_default);
            this.ieo = (BarImageView) this.mRootView.findViewById(R.id.frs_image);
            this.iep = (TextView) this.mRootView.findViewById(R.id.forum_name);
            ao.setViewTextColor(this.iep, R.color.cp_cont_a);
            this.ieq = (FrsHeaderBannerView) this.mRootView.findViewById(R.id.frs_header_banner);
            this.ier = (LinearLayout) this.mRootView.findViewById(R.id.fake_content_layout);
            this.ies = (ImageView) this.mRootView.findViewById(R.id.fake_content_img);
            this.iet = this.mRootView.findViewById(R.id.header_round_corner_layout);
            this.iev = (ImageView) this.mRootView.findViewById(R.id.fake_return_icon);
            this.iew = (ImageView) this.mRootView.findViewById(R.id.fake_share_icon);
            this.iex = (ImageView) this.mRootView.findViewById(R.id.fake_information_icon);
            this.iey = (ImageView) this.mRootView.findViewById(R.id.fake_search_icon);
            this.iev.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.e.g.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (context instanceof Activity) {
                        ((Activity) context).finish();
                    }
                }
            });
            this.ieo.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            this.ieo.setContentDescription(context.getResources().getString(R.string.bar_header));
            this.ieo.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds4));
            this.ieo.setShowOval(true);
            this.ieo.setBorderColor(ao.getColor(R.color.black_alpha15));
            this.ieo.setStrokeColorResId(R.color.cp_bg_line_d);
            ao.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
            ao.setBackgroundResource(this.iet, R.drawable.bg_frs_header_round_corner);
            ao.setImageResource(this.iev, R.drawable.icon_topbar_return_white_n);
            SvgManager.baR().a(this.iew, R.drawable.icon_pure_topbar_share44_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
            SvgManager.baR().a(this.iex, R.drawable.icon_pure_topbar_information44_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
            SvgManager.baR().a(this.iey, R.drawable.icon_pure_topbar_search44_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
            SvgManager.baR().a(this.ies, R.drawable.bg_pure_loadingskeleton_svg, R.color.cp_bg_line_c, SvgManager.SvgResourceStateType.NORMAL);
        }
    }
}
