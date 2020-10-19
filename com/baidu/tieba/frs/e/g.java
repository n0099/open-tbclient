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
    public RelativeLayout ggz;
    public LinearGradientView iOI;
    public BarImageView iOJ;
    public TextView iOK;
    public FrsHeaderBannerView iOL;
    public LinearLayout iOM;
    public ImageView iON;
    public View iOO;
    public TbImageView iOP;
    public ImageView iOQ;
    public ImageView iOR;
    public ImageView iOS;
    public ImageView iOT;
    public View mRootView;

    public g(final Context context) {
        if (context != null) {
            this.mRootView = LayoutInflater.from(context).inflate(R.layout.frs_fake_view, (ViewGroup) null);
            this.ggz = (RelativeLayout) this.mRootView.findViewById(R.id.head_top_bg_container);
            this.iOI = (LinearGradientView) this.mRootView.findViewById(R.id.head_top_gradient_bg);
            this.iOP = (TbImageView) this.mRootView.findViewById(R.id.head_top_bg_mask);
            this.iOP.setDefaultBgResource(R.color.transparent);
            this.iOP.setDefaultResource(R.drawable.pic_frs_head_default);
            this.iOJ = (BarImageView) this.mRootView.findViewById(R.id.frs_image);
            this.iOK = (TextView) this.mRootView.findViewById(R.id.forum_name);
            ap.setViewTextColor(this.iOK, R.color.cp_cont_a);
            this.iOL = (FrsHeaderBannerView) this.mRootView.findViewById(R.id.frs_header_banner);
            this.iOM = (LinearLayout) this.mRootView.findViewById(R.id.fake_content_layout);
            this.iON = (ImageView) this.mRootView.findViewById(R.id.fake_content_img);
            this.iOO = this.mRootView.findViewById(R.id.header_round_corner_layout);
            this.iOQ = (ImageView) this.mRootView.findViewById(R.id.fake_return_icon);
            this.iOR = (ImageView) this.mRootView.findViewById(R.id.fake_share_icon);
            this.iOS = (ImageView) this.mRootView.findViewById(R.id.fake_information_icon);
            this.iOT = (ImageView) this.mRootView.findViewById(R.id.fake_search_icon);
            this.iOQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.e.g.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (context instanceof Activity) {
                        ((Activity) context).finish();
                    }
                }
            });
            this.iOJ.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            this.iOJ.setContentDescription(context.getResources().getString(R.string.bar_header));
            this.iOJ.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds4));
            this.iOJ.setShowOval(true);
            this.iOJ.setBorderColor(ap.getColor(R.color.black_alpha15));
            this.iOJ.setStrokeColorResId(R.color.cp_bg_line_d);
            ap.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
            ap.setBackgroundResource(this.iOO, R.drawable.bg_frs_header_round_corner);
            ap.setImageResource(this.iOQ, R.drawable.icon_topbar_return_white_n);
            SvgManager.bmU().a(this.iOR, R.drawable.icon_pure_topbar_share44_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
            SvgManager.bmU().a(this.iOS, R.drawable.icon_pure_topbar_information44_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
            SvgManager.bmU().a(this.iOT, R.drawable.icon_pure_topbar_search44_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
            SvgManager.bmU().a(this.iON, R.drawable.bg_pure_loadingskeleton_svg, R.color.cp_bg_line_c, SvgManager.SvgResourceStateType.NORMAL);
        }
    }
}
