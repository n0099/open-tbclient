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
    public ImageView ieA;
    public LinearGradientView iep;
    public BarImageView ieq;
    public TextView ier;
    public FrsHeaderBannerView ies;
    public LinearLayout iet;
    public ImageView ieu;
    public View iev;
    public TbImageView iew;
    public ImageView iex;
    public ImageView iey;
    public ImageView iez;
    public View mRootView;

    public g(final Context context) {
        if (context != null) {
            this.mRootView = LayoutInflater.from(context).inflate(R.layout.frs_fake_view, (ViewGroup) null);
            this.fFA = (RelativeLayout) this.mRootView.findViewById(R.id.head_top_bg_container);
            this.iep = (LinearGradientView) this.mRootView.findViewById(R.id.head_top_gradient_bg);
            this.iew = (TbImageView) this.mRootView.findViewById(R.id.head_top_bg_mask);
            this.iew.setDefaultBgResource(R.color.transparent);
            this.iew.setDefaultResource(R.drawable.pic_frs_head_default);
            this.ieq = (BarImageView) this.mRootView.findViewById(R.id.frs_image);
            this.ier = (TextView) this.mRootView.findViewById(R.id.forum_name);
            ao.setViewTextColor(this.ier, R.color.cp_cont_a);
            this.ies = (FrsHeaderBannerView) this.mRootView.findViewById(R.id.frs_header_banner);
            this.iet = (LinearLayout) this.mRootView.findViewById(R.id.fake_content_layout);
            this.ieu = (ImageView) this.mRootView.findViewById(R.id.fake_content_img);
            this.iev = this.mRootView.findViewById(R.id.header_round_corner_layout);
            this.iex = (ImageView) this.mRootView.findViewById(R.id.fake_return_icon);
            this.iey = (ImageView) this.mRootView.findViewById(R.id.fake_share_icon);
            this.iez = (ImageView) this.mRootView.findViewById(R.id.fake_information_icon);
            this.ieA = (ImageView) this.mRootView.findViewById(R.id.fake_search_icon);
            this.iex.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.e.g.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (context instanceof Activity) {
                        ((Activity) context).finish();
                    }
                }
            });
            this.ieq.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            this.ieq.setContentDescription(context.getResources().getString(R.string.bar_header));
            this.ieq.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds4));
            this.ieq.setShowOval(true);
            this.ieq.setBorderColor(ao.getColor(R.color.black_alpha15));
            this.ieq.setStrokeColorResId(R.color.cp_bg_line_d);
            ao.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
            ao.setBackgroundResource(this.iev, R.drawable.bg_frs_header_round_corner);
            ao.setImageResource(this.iex, R.drawable.icon_topbar_return_white_n);
            SvgManager.baR().a(this.iey, R.drawable.icon_pure_topbar_share44_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
            SvgManager.baR().a(this.iez, R.drawable.icon_pure_topbar_information44_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
            SvgManager.baR().a(this.ieA, R.drawable.icon_pure_topbar_search44_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
            SvgManager.baR().a(this.ieu, R.drawable.bg_pure_loadingskeleton_svg, R.color.cp_bg_line_c, SvgManager.SvgResourceStateType.NORMAL);
        }
    }
}
