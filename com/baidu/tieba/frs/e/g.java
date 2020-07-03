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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.widget.LinearGradientView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.headerimage.FrsHeaderBannerView;
/* loaded from: classes9.dex */
public class g {
    public RelativeLayout fAq;
    public LinearGradientView hYl;
    public BarImageView hYm;
    public TextView hYn;
    public FrsHeaderBannerView hYo;
    public LinearLayout hYp;
    public ImageView hYq;
    public View hYr;
    public TbImageView hYs;
    public ImageView hYt;
    public ImageView hYu;
    public ImageView hYv;
    public ImageView hYw;
    public View mRootView;

    public g(final Context context) {
        if (context != null) {
            this.mRootView = LayoutInflater.from(context).inflate(R.layout.frs_fake_view, (ViewGroup) null);
            this.fAq = (RelativeLayout) this.mRootView.findViewById(R.id.head_top_bg_container);
            this.hYl = (LinearGradientView) this.mRootView.findViewById(R.id.head_top_gradient_bg);
            this.hYs = (TbImageView) this.mRootView.findViewById(R.id.head_top_bg_mask);
            this.hYs.setDefaultBgResource(R.color.transparent);
            this.hYs.setDefaultResource(R.drawable.pic_frs_head_default);
            this.hYm = (BarImageView) this.mRootView.findViewById(R.id.frs_image);
            this.hYn = (TextView) this.mRootView.findViewById(R.id.forum_name);
            an.setViewTextColor(this.hYn, (int) R.color.cp_cont_a);
            this.hYo = (FrsHeaderBannerView) this.mRootView.findViewById(R.id.frs_header_banner);
            this.hYp = (LinearLayout) this.mRootView.findViewById(R.id.fake_content_layout);
            this.hYq = (ImageView) this.mRootView.findViewById(R.id.fake_content_img);
            this.hYr = this.mRootView.findViewById(R.id.header_round_corner_layout);
            this.hYt = (ImageView) this.mRootView.findViewById(R.id.fake_return_icon);
            this.hYu = (ImageView) this.mRootView.findViewById(R.id.fake_share_icon);
            this.hYv = (ImageView) this.mRootView.findViewById(R.id.fake_information_icon);
            this.hYw = (ImageView) this.mRootView.findViewById(R.id.fake_search_icon);
            this.hYt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.e.g.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (context instanceof Activity) {
                        ((Activity) context).finish();
                    }
                }
            });
            this.hYm.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            this.hYm.setContentDescription(context.getResources().getString(R.string.bar_header));
            this.hYm.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds4));
            this.hYm.setShowOval(true);
            this.hYm.setBorderColor(an.getColor(R.color.black_alpha15));
            this.hYm.setStrokeColorResId(R.color.cp_bg_line_d);
            an.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
            an.setBackgroundResource(this.hYr, R.drawable.bg_frs_header_round_corner);
            an.setImageResource(this.hYt, R.drawable.icon_topbar_return_white_n);
            SvgManager.aWQ().a(this.hYu, R.drawable.icon_pure_topbar_share44_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
            SvgManager.aWQ().a(this.hYv, R.drawable.icon_pure_topbar_information44_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
            SvgManager.aWQ().a(this.hYw, R.drawable.icon_pure_topbar_search44_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
            SvgManager.aWQ().a(this.hYq, R.drawable.bg_pure_loadingskeleton_svg, R.color.cp_bg_line_c, SvgManager.SvgResourceStateType.NORMAL);
        }
    }
}
