package com.baidu.tieba.frs.c;

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
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.widget.LinearGradientView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.headerimage.FrsHeaderBannerView;
/* loaded from: classes2.dex */
public class g {
    public RelativeLayout gOH;
    public LinearGradientView jIY;
    public BarImageView jIZ;
    public TextView jJa;
    public FrsHeaderBannerView jJb;
    public LinearLayout jJc;
    public ImageView jJd;
    public View jJe;
    public TbImageView jJf;
    public ImageView jJg;
    public ImageView jJh;
    public ImageView jJi;
    public ImageView jJj;
    public View mRootView;

    public g(final Context context) {
        if (context != null) {
            this.mRootView = LayoutInflater.from(context).inflate(R.layout.frs_fake_view, (ViewGroup) null);
            this.gOH = (RelativeLayout) this.mRootView.findViewById(R.id.head_top_bg_container);
            this.jIY = (LinearGradientView) this.mRootView.findViewById(R.id.head_top_gradient_bg);
            this.jJf = (TbImageView) this.mRootView.findViewById(R.id.head_top_bg_mask);
            this.jJf.setDefaultBgResource(R.color.transparent);
            this.jJf.setDefaultResource(R.drawable.pic_frs_head_default);
            this.jIZ = (BarImageView) this.mRootView.findViewById(R.id.frs_image);
            this.jJa = (TextView) this.mRootView.findViewById(R.id.forum_name);
            ap.setViewTextColor(this.jJa, R.color.CAM_X0101);
            this.jJb = (FrsHeaderBannerView) this.mRootView.findViewById(R.id.frs_header_banner);
            this.jJc = (LinearLayout) this.mRootView.findViewById(R.id.fake_content_layout);
            this.jJd = (ImageView) this.mRootView.findViewById(R.id.fake_content_img);
            this.jJe = this.mRootView.findViewById(R.id.header_round_corner_layout);
            this.jJg = (ImageView) this.mRootView.findViewById(R.id.fake_return_icon);
            this.jJh = (ImageView) this.mRootView.findViewById(R.id.fake_share_icon);
            this.jJi = (ImageView) this.mRootView.findViewById(R.id.fake_information_icon);
            this.jJj = (ImageView) this.mRootView.findViewById(R.id.fake_search_icon);
            this.jJg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.c.g.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (context instanceof Activity) {
                        ((Activity) context).finish();
                    }
                }
            });
            this.jIZ.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            this.jIZ.setContentDescription(context.getResources().getString(R.string.bar_header));
            this.jIZ.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds4));
            this.jIZ.setShowOval(true);
            this.jIZ.setBorderColor(ap.getColor(R.color.black_alpha15));
            this.jIZ.setStrokeColorResId(R.color.CAM_X0201);
            ap.setBackgroundColor(this.mRootView, R.color.CAM_X0201);
            ap.setBackgroundResource(this.jJe, R.drawable.white_bg_frs_header_round_corner);
            ap.setBackgroundResource(this.jJd, R.color.CAM_X0201);
            ap.setImageResource(this.jJg, R.drawable.ic_icon_pure_topbar_return40_svg);
            SvgManager.bsR().a(this.jJh, R.drawable.ic_icon_pure_topbar_share40_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
            this.jJi.setImageDrawable(WebPManager.a(R.drawable.icon_pure_topbar_information40, ap.getColor(R.color.CAM_X0101), (WebPManager.ResourceStateType) null));
            SvgManager.bsR().a(this.jJj, R.drawable.ic_icon_pure_topbar_search40_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
            SvgManager.bsR().a(this.jJd, R.drawable.bg_pure_loadingskeleton_svg, R.color.CAM_X0204, SvgManager.SvgResourceStateType.NORMAL);
        }
    }
}
