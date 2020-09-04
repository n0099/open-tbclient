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
    public RelativeLayout fQV;
    public BarImageView isA;
    public TextView isB;
    public FrsHeaderBannerView isC;
    public LinearLayout isD;
    public ImageView isE;
    public View isF;
    public TbImageView isG;
    public ImageView isH;
    public ImageView isI;
    public ImageView isJ;
    public ImageView isK;
    public LinearGradientView isz;
    public View mRootView;

    public g(final Context context) {
        if (context != null) {
            this.mRootView = LayoutInflater.from(context).inflate(R.layout.frs_fake_view, (ViewGroup) null);
            this.fQV = (RelativeLayout) this.mRootView.findViewById(R.id.head_top_bg_container);
            this.isz = (LinearGradientView) this.mRootView.findViewById(R.id.head_top_gradient_bg);
            this.isG = (TbImageView) this.mRootView.findViewById(R.id.head_top_bg_mask);
            this.isG.setDefaultBgResource(R.color.transparent);
            this.isG.setDefaultResource(R.drawable.pic_frs_head_default);
            this.isA = (BarImageView) this.mRootView.findViewById(R.id.frs_image);
            this.isB = (TextView) this.mRootView.findViewById(R.id.forum_name);
            ap.setViewTextColor(this.isB, R.color.cp_cont_a);
            this.isC = (FrsHeaderBannerView) this.mRootView.findViewById(R.id.frs_header_banner);
            this.isD = (LinearLayout) this.mRootView.findViewById(R.id.fake_content_layout);
            this.isE = (ImageView) this.mRootView.findViewById(R.id.fake_content_img);
            this.isF = this.mRootView.findViewById(R.id.header_round_corner_layout);
            this.isH = (ImageView) this.mRootView.findViewById(R.id.fake_return_icon);
            this.isI = (ImageView) this.mRootView.findViewById(R.id.fake_share_icon);
            this.isJ = (ImageView) this.mRootView.findViewById(R.id.fake_information_icon);
            this.isK = (ImageView) this.mRootView.findViewById(R.id.fake_search_icon);
            this.isH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.e.g.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (context instanceof Activity) {
                        ((Activity) context).finish();
                    }
                }
            });
            this.isA.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            this.isA.setContentDescription(context.getResources().getString(R.string.bar_header));
            this.isA.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds4));
            this.isA.setShowOval(true);
            this.isA.setBorderColor(ap.getColor(R.color.black_alpha15));
            this.isA.setStrokeColorResId(R.color.cp_bg_line_d);
            ap.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
            ap.setBackgroundResource(this.isF, R.drawable.bg_frs_header_round_corner);
            ap.setImageResource(this.isH, R.drawable.icon_topbar_return_white_n);
            SvgManager.bjq().a(this.isI, R.drawable.icon_pure_topbar_share44_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
            SvgManager.bjq().a(this.isJ, R.drawable.icon_pure_topbar_information44_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
            SvgManager.bjq().a(this.isK, R.drawable.icon_pure_topbar_search44_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
            SvgManager.bjq().a(this.isE, R.drawable.bg_pure_loadingskeleton_svg, R.color.cp_bg_line_c, SvgManager.SvgResourceStateType.NORMAL);
        }
    }
}
