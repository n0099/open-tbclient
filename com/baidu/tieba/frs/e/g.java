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
/* loaded from: classes22.dex */
public class g {
    public RelativeLayout gwq;
    public LinearGradientView jhb;
    public BarImageView jhc;
    public TextView jhd;
    public FrsHeaderBannerView jhe;
    public LinearLayout jhf;
    public ImageView jhg;
    public View jhh;
    public TbImageView jhi;
    public ImageView jhj;
    public ImageView jhk;
    public ImageView jhl;
    public ImageView jhm;
    public View mRootView;

    public g(final Context context) {
        if (context != null) {
            this.mRootView = LayoutInflater.from(context).inflate(R.layout.frs_fake_view, (ViewGroup) null);
            this.gwq = (RelativeLayout) this.mRootView.findViewById(R.id.head_top_bg_container);
            this.jhb = (LinearGradientView) this.mRootView.findViewById(R.id.head_top_gradient_bg);
            this.jhi = (TbImageView) this.mRootView.findViewById(R.id.head_top_bg_mask);
            this.jhi.setDefaultBgResource(R.color.transparent);
            this.jhi.setDefaultResource(R.drawable.pic_frs_head_default);
            this.jhc = (BarImageView) this.mRootView.findViewById(R.id.frs_image);
            this.jhd = (TextView) this.mRootView.findViewById(R.id.forum_name);
            ap.setViewTextColor(this.jhd, R.color.cp_cont_a);
            this.jhe = (FrsHeaderBannerView) this.mRootView.findViewById(R.id.frs_header_banner);
            this.jhf = (LinearLayout) this.mRootView.findViewById(R.id.fake_content_layout);
            this.jhg = (ImageView) this.mRootView.findViewById(R.id.fake_content_img);
            this.jhh = this.mRootView.findViewById(R.id.header_round_corner_layout);
            this.jhj = (ImageView) this.mRootView.findViewById(R.id.fake_return_icon);
            this.jhk = (ImageView) this.mRootView.findViewById(R.id.fake_share_icon);
            this.jhl = (ImageView) this.mRootView.findViewById(R.id.fake_information_icon);
            this.jhm = (ImageView) this.mRootView.findViewById(R.id.fake_search_icon);
            this.jhj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.e.g.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (context instanceof Activity) {
                        ((Activity) context).finish();
                    }
                }
            });
            this.jhc.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            this.jhc.setContentDescription(context.getResources().getString(R.string.bar_header));
            this.jhc.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds4));
            this.jhc.setShowOval(true);
            this.jhc.setBorderColor(ap.getColor(R.color.black_alpha15));
            this.jhc.setStrokeColorResId(R.color.cp_bg_line_d);
            ap.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
            ap.setBackgroundResource(this.jhh, R.drawable.bg_frs_header_round_corner);
            ap.setImageResource(this.jhj, R.drawable.icon_topbar_return_white_n);
            SvgManager.brn().a(this.jhk, R.drawable.icon_pure_topbar_share44_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
            SvgManager.brn().a(this.jhl, R.drawable.icon_pure_topbar_information44_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
            SvgManager.brn().a(this.jhm, R.drawable.icon_pure_topbar_search44_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
            SvgManager.brn().a(this.jhg, R.drawable.bg_pure_loadingskeleton_svg, R.color.cp_bg_line_c, SvgManager.SvgResourceStateType.NORMAL);
        }
    }
}
