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
    public RelativeLayout foT;
    public LinearGradientView hKm;
    public BarImageView hKn;
    public TextView hKo;
    public FrsHeaderBannerView hKp;
    public LinearLayout hKq;
    public ImageView hKr;
    public View hKs;
    public TbImageView hKt;
    public ImageView hKu;
    public ImageView hKv;
    public ImageView hKw;
    public ImageView hKx;
    public View mRootView;

    public g(final Context context) {
        if (context != null) {
            this.mRootView = LayoutInflater.from(context).inflate(R.layout.frs_fake_view, (ViewGroup) null);
            this.foT = (RelativeLayout) this.mRootView.findViewById(R.id.head_top_bg_container);
            this.hKm = (LinearGradientView) this.mRootView.findViewById(R.id.head_top_gradient_bg);
            this.hKt = (TbImageView) this.mRootView.findViewById(R.id.head_top_bg_mask);
            this.hKt.setDefaultBgResource(R.color.transparent);
            this.hKt.setDefaultResource(R.drawable.pic_frs_head_default);
            this.hKn = (BarImageView) this.mRootView.findViewById(R.id.frs_image);
            this.hKo = (TextView) this.mRootView.findViewById(R.id.forum_name);
            am.setViewTextColor(this.hKo, (int) R.color.cp_cont_a);
            this.hKp = (FrsHeaderBannerView) this.mRootView.findViewById(R.id.frs_header_banner);
            this.hKq = (LinearLayout) this.mRootView.findViewById(R.id.fake_content_layout);
            this.hKr = (ImageView) this.mRootView.findViewById(R.id.fake_content_img);
            this.hKs = this.mRootView.findViewById(R.id.header_round_corner_layout);
            this.hKu = (ImageView) this.mRootView.findViewById(R.id.fake_return_icon);
            this.hKv = (ImageView) this.mRootView.findViewById(R.id.fake_share_icon);
            this.hKw = (ImageView) this.mRootView.findViewById(R.id.fake_information_icon);
            this.hKx = (ImageView) this.mRootView.findViewById(R.id.fake_search_icon);
            this.hKu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.e.g.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (context instanceof Activity) {
                        ((Activity) context).finish();
                    }
                }
            });
            this.hKn.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            this.hKn.setContentDescription(context.getResources().getString(R.string.bar_header));
            this.hKn.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds4));
            this.hKn.setShowOval(true);
            this.hKn.setBorderColor(am.getColor(R.color.black_alpha15));
            this.hKn.setStrokeColorResId(R.color.cp_bg_line_d);
            am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
            am.setBackgroundResource(this.hKs, R.drawable.bg_frs_header_round_corner);
            am.setImageResource(this.hKu, R.drawable.icon_topbar_return_white_n);
            SvgManager.aUV().a(this.hKv, R.drawable.icon_pure_topbar_share44_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
            SvgManager.aUV().a(this.hKw, R.drawable.icon_pure_topbar_information44_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
            SvgManager.aUV().a(this.hKx, R.drawable.icon_pure_topbar_search44_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
            SvgManager.aUV().a(this.hKr, R.drawable.bg_pure_loadingskeleton_svg, R.color.cp_bg_line_c, SvgManager.SvgResourceStateType.NORMAL);
        }
    }
}
