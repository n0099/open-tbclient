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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.widget.LinearGradientView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.headerimage.FrsHeaderBannerView;
/* loaded from: classes16.dex */
public class g {
    public RelativeLayout fQR;
    public TbImageView isA;
    public ImageView isB;
    public ImageView isC;
    public ImageView isD;
    public ImageView isE;
    public LinearGradientView ist;
    public BarImageView isu;
    public TextView isv;
    public FrsHeaderBannerView isw;
    public LinearLayout isx;
    public ImageView isy;
    public View isz;
    public View mRootView;

    public g(final Context context) {
        if (context != null) {
            this.mRootView = LayoutInflater.from(context).inflate(R.layout.frs_fake_view, (ViewGroup) null);
            this.fQR = (RelativeLayout) this.mRootView.findViewById(R.id.head_top_bg_container);
            this.ist = (LinearGradientView) this.mRootView.findViewById(R.id.head_top_gradient_bg);
            this.isA = (TbImageView) this.mRootView.findViewById(R.id.head_top_bg_mask);
            this.isA.setDefaultBgResource(R.color.transparent);
            this.isA.setDefaultResource(R.drawable.pic_frs_head_default);
            this.isu = (BarImageView) this.mRootView.findViewById(R.id.frs_image);
            this.isv = (TextView) this.mRootView.findViewById(R.id.forum_name);
            ap.setViewTextColor(this.isv, R.color.cp_cont_a);
            this.isw = (FrsHeaderBannerView) this.mRootView.findViewById(R.id.frs_header_banner);
            this.isx = (LinearLayout) this.mRootView.findViewById(R.id.fake_content_layout);
            this.isy = (ImageView) this.mRootView.findViewById(R.id.fake_content_img);
            this.isz = this.mRootView.findViewById(R.id.header_round_corner_layout);
            this.isB = (ImageView) this.mRootView.findViewById(R.id.fake_return_icon);
            this.isC = (ImageView) this.mRootView.findViewById(R.id.fake_share_icon);
            this.isD = (ImageView) this.mRootView.findViewById(R.id.fake_information_icon);
            this.isE = (ImageView) this.mRootView.findViewById(R.id.fake_search_icon);
            this.isB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.e.g.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (context instanceof Activity) {
                        ((Activity) context).finish();
                    }
                }
            });
            this.isu.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            this.isu.setContentDescription(context.getResources().getString(R.string.bar_header));
            this.isu.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds4));
            this.isu.setShowOval(true);
            this.isu.setBorderColor(ap.getColor(R.color.black_alpha15));
            this.isu.setStrokeColorResId(R.color.cp_bg_line_d);
            ap.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
            ap.setBackgroundResource(this.isz, R.drawable.bg_frs_header_round_corner);
            ap.setImageResource(this.isB, R.drawable.icon_topbar_return_white_n);
            SvgManager.bjq().a(this.isC, R.drawable.icon_pure_topbar_share44_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
            SvgManager.bjq().a(this.isD, R.drawable.icon_pure_topbar_information44_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
            SvgManager.bjq().a(this.isE, R.drawable.icon_pure_topbar_search44_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
            SvgManager.bjq().a(this.isy, R.drawable.bg_pure_loadingskeleton_svg, R.color.cp_bg_line_c, SvgManager.SvgResourceStateType.NORMAL);
        }
    }
}
