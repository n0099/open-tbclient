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
    public RelativeLayout fbr;
    public BarImageView hvA;
    public TextView hvB;
    public FrsHeaderBannerView hvC;
    public LinearLayout hvD;
    public ImageView hvE;
    public View hvF;
    public TbImageView hvG;
    public ImageView hvH;
    public ImageView hvI;
    public ImageView hvJ;
    public ImageView hvK;
    public LinearGradientView hvz;
    public View mRootView;

    public g(final Context context) {
        if (context != null) {
            this.mRootView = LayoutInflater.from(context).inflate(R.layout.frs_fake_view, (ViewGroup) null);
            this.fbr = (RelativeLayout) this.mRootView.findViewById(R.id.head_top_bg_container);
            this.hvz = (LinearGradientView) this.mRootView.findViewById(R.id.head_top_gradient_bg);
            this.hvG = (TbImageView) this.mRootView.findViewById(R.id.head_top_bg_mask);
            this.hvG.setDefaultBgResource(R.color.transparent);
            this.hvG.setDefaultResource(R.drawable.pic_frs_head_default);
            this.hvA = (BarImageView) this.mRootView.findViewById(R.id.frs_image);
            this.hvB = (TextView) this.mRootView.findViewById(R.id.forum_name);
            am.setViewTextColor(this.hvB, (int) R.color.cp_cont_a);
            this.hvC = (FrsHeaderBannerView) this.mRootView.findViewById(R.id.frs_header_banner);
            this.hvD = (LinearLayout) this.mRootView.findViewById(R.id.fake_content_layout);
            this.hvE = (ImageView) this.mRootView.findViewById(R.id.fake_content_img);
            this.hvF = this.mRootView.findViewById(R.id.header_round_corner_layout);
            this.hvH = (ImageView) this.mRootView.findViewById(R.id.fake_return_icon);
            this.hvI = (ImageView) this.mRootView.findViewById(R.id.fake_share_icon);
            this.hvJ = (ImageView) this.mRootView.findViewById(R.id.fake_information_icon);
            this.hvK = (ImageView) this.mRootView.findViewById(R.id.fake_search_icon);
            this.hvH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.e.g.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (context instanceof Activity) {
                        ((Activity) context).finish();
                    }
                }
            });
            this.hvA.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            this.hvA.setContentDescription(context.getResources().getString(R.string.bar_header));
            this.hvA.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds4));
            this.hvA.setShowOval(true);
            this.hvA.setBorderColor(am.getColor(R.color.black_alpha15));
            this.hvA.setStrokeColorResId(R.color.cp_bg_line_d);
            am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
            am.setBackgroundResource(this.hvF, R.drawable.bg_frs_header_round_corner);
            am.setImageResource(this.hvH, R.drawable.icon_topbar_return_white_n);
            SvgManager.aOR().a(this.hvI, R.drawable.icon_pure_topbar_share44_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
            SvgManager.aOR().a(this.hvJ, R.drawable.icon_pure_topbar_information44_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
            SvgManager.aOR().a(this.hvK, R.drawable.icon_pure_topbar_search44_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
            SvgManager.aOR().a(this.hvE, R.drawable.bg_pure_loadingskeleton_svg, R.color.cp_bg_line_c, SvgManager.SvgResourceStateType.NORMAL);
        }
    }
}
