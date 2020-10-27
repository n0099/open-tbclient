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
    public RelativeLayout gqC;
    public LinearGradientView jbe;
    public BarImageView jbf;
    public TextView jbg;
    public FrsHeaderBannerView jbh;
    public LinearLayout jbi;
    public ImageView jbj;
    public View jbk;
    public TbImageView jbl;
    public ImageView jbm;
    public ImageView jbn;
    public ImageView jbo;
    public ImageView jbp;
    public View mRootView;

    public g(final Context context) {
        if (context != null) {
            this.mRootView = LayoutInflater.from(context).inflate(R.layout.frs_fake_view, (ViewGroup) null);
            this.gqC = (RelativeLayout) this.mRootView.findViewById(R.id.head_top_bg_container);
            this.jbe = (LinearGradientView) this.mRootView.findViewById(R.id.head_top_gradient_bg);
            this.jbl = (TbImageView) this.mRootView.findViewById(R.id.head_top_bg_mask);
            this.jbl.setDefaultBgResource(R.color.transparent);
            this.jbl.setDefaultResource(R.drawable.pic_frs_head_default);
            this.jbf = (BarImageView) this.mRootView.findViewById(R.id.frs_image);
            this.jbg = (TextView) this.mRootView.findViewById(R.id.forum_name);
            ap.setViewTextColor(this.jbg, R.color.cp_cont_a);
            this.jbh = (FrsHeaderBannerView) this.mRootView.findViewById(R.id.frs_header_banner);
            this.jbi = (LinearLayout) this.mRootView.findViewById(R.id.fake_content_layout);
            this.jbj = (ImageView) this.mRootView.findViewById(R.id.fake_content_img);
            this.jbk = this.mRootView.findViewById(R.id.header_round_corner_layout);
            this.jbm = (ImageView) this.mRootView.findViewById(R.id.fake_return_icon);
            this.jbn = (ImageView) this.mRootView.findViewById(R.id.fake_share_icon);
            this.jbo = (ImageView) this.mRootView.findViewById(R.id.fake_information_icon);
            this.jbp = (ImageView) this.mRootView.findViewById(R.id.fake_search_icon);
            this.jbm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.e.g.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (context instanceof Activity) {
                        ((Activity) context).finish();
                    }
                }
            });
            this.jbf.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            this.jbf.setContentDescription(context.getResources().getString(R.string.bar_header));
            this.jbf.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds4));
            this.jbf.setShowOval(true);
            this.jbf.setBorderColor(ap.getColor(R.color.black_alpha15));
            this.jbf.setStrokeColorResId(R.color.cp_bg_line_d);
            ap.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
            ap.setBackgroundResource(this.jbk, R.drawable.bg_frs_header_round_corner);
            ap.setImageResource(this.jbm, R.drawable.icon_topbar_return_white_n);
            SvgManager.boN().a(this.jbn, R.drawable.icon_pure_topbar_share44_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
            SvgManager.boN().a(this.jbo, R.drawable.icon_pure_topbar_information44_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
            SvgManager.boN().a(this.jbp, R.drawable.icon_pure_topbar_search44_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
            SvgManager.boN().a(this.jbj, R.drawable.bg_pure_loadingskeleton_svg, R.color.cp_bg_line_c, SvgManager.SvgResourceStateType.NORMAL);
        }
    }
}
