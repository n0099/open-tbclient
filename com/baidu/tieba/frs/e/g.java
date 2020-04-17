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
    public RelativeLayout fbm;
    public TbImageView hvA;
    public ImageView hvB;
    public ImageView hvC;
    public ImageView hvD;
    public ImageView hvE;
    public LinearGradientView hvt;
    public BarImageView hvu;
    public TextView hvv;
    public FrsHeaderBannerView hvw;
    public LinearLayout hvx;
    public ImageView hvy;
    public View hvz;
    public View mRootView;

    public g(final Context context) {
        if (context != null) {
            this.mRootView = LayoutInflater.from(context).inflate(R.layout.frs_fake_view, (ViewGroup) null);
            this.fbm = (RelativeLayout) this.mRootView.findViewById(R.id.head_top_bg_container);
            this.hvt = (LinearGradientView) this.mRootView.findViewById(R.id.head_top_gradient_bg);
            this.hvA = (TbImageView) this.mRootView.findViewById(R.id.head_top_bg_mask);
            this.hvA.setDefaultBgResource(R.color.transparent);
            this.hvA.setDefaultResource(R.drawable.pic_frs_head_default);
            this.hvu = (BarImageView) this.mRootView.findViewById(R.id.frs_image);
            this.hvv = (TextView) this.mRootView.findViewById(R.id.forum_name);
            am.setViewTextColor(this.hvv, (int) R.color.cp_cont_a);
            this.hvw = (FrsHeaderBannerView) this.mRootView.findViewById(R.id.frs_header_banner);
            this.hvx = (LinearLayout) this.mRootView.findViewById(R.id.fake_content_layout);
            this.hvy = (ImageView) this.mRootView.findViewById(R.id.fake_content_img);
            this.hvz = this.mRootView.findViewById(R.id.header_round_corner_layout);
            this.hvB = (ImageView) this.mRootView.findViewById(R.id.fake_return_icon);
            this.hvC = (ImageView) this.mRootView.findViewById(R.id.fake_share_icon);
            this.hvD = (ImageView) this.mRootView.findViewById(R.id.fake_information_icon);
            this.hvE = (ImageView) this.mRootView.findViewById(R.id.fake_search_icon);
            this.hvB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.e.g.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (context instanceof Activity) {
                        ((Activity) context).finish();
                    }
                }
            });
            this.hvu.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            this.hvu.setContentDescription(context.getResources().getString(R.string.bar_header));
            this.hvu.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds4));
            this.hvu.setShowOval(true);
            this.hvu.setBorderColor(am.getColor(R.color.black_alpha15));
            this.hvu.setStrokeColorResId(R.color.cp_bg_line_d);
            am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
            am.setBackgroundResource(this.hvz, R.drawable.bg_frs_header_round_corner);
            am.setImageResource(this.hvB, R.drawable.icon_topbar_return_white_n);
            SvgManager.aOU().a(this.hvC, R.drawable.icon_pure_topbar_share44_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
            SvgManager.aOU().a(this.hvD, R.drawable.icon_pure_topbar_information44_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
            SvgManager.aOU().a(this.hvE, R.drawable.icon_pure_topbar_search44_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
            SvgManager.aOU().a(this.hvy, R.drawable.bg_pure_loadingskeleton_svg, R.color.cp_bg_line_c, SvgManager.SvgResourceStateType.NORMAL);
        }
    }
}
