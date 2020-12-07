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
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.widget.LinearGradientView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.headerimage.FrsHeaderBannerView;
/* loaded from: classes22.dex */
public class g {
    public RelativeLayout gEG;
    public ImageView jvA;
    public LinearGradientView jvp;
    public BarImageView jvq;
    public TextView jvr;
    public FrsHeaderBannerView jvs;
    public LinearLayout jvt;
    public ImageView jvu;
    public View jvv;
    public TbImageView jvw;
    public ImageView jvx;
    public ImageView jvy;
    public ImageView jvz;
    public View mRootView;

    public g(final Context context) {
        if (context != null) {
            this.mRootView = LayoutInflater.from(context).inflate(R.layout.frs_fake_view, (ViewGroup) null);
            this.gEG = (RelativeLayout) this.mRootView.findViewById(R.id.head_top_bg_container);
            this.jvp = (LinearGradientView) this.mRootView.findViewById(R.id.head_top_gradient_bg);
            this.jvw = (TbImageView) this.mRootView.findViewById(R.id.head_top_bg_mask);
            this.jvw.setDefaultBgResource(R.color.transparent);
            this.jvw.setDefaultResource(R.drawable.pic_frs_head_default);
            this.jvq = (BarImageView) this.mRootView.findViewById(R.id.frs_image);
            this.jvr = (TextView) this.mRootView.findViewById(R.id.forum_name);
            ap.setViewTextColor(this.jvr, R.color.CAM_X0101);
            this.jvs = (FrsHeaderBannerView) this.mRootView.findViewById(R.id.frs_header_banner);
            this.jvt = (LinearLayout) this.mRootView.findViewById(R.id.fake_content_layout);
            this.jvu = (ImageView) this.mRootView.findViewById(R.id.fake_content_img);
            this.jvv = this.mRootView.findViewById(R.id.header_round_corner_layout);
            this.jvx = (ImageView) this.mRootView.findViewById(R.id.fake_return_icon);
            this.jvy = (ImageView) this.mRootView.findViewById(R.id.fake_share_icon);
            this.jvz = (ImageView) this.mRootView.findViewById(R.id.fake_information_icon);
            this.jvA = (ImageView) this.mRootView.findViewById(R.id.fake_search_icon);
            this.jvx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.e.g.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (context instanceof Activity) {
                        ((Activity) context).finish();
                    }
                }
            });
            this.jvq.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            this.jvq.setContentDescription(context.getResources().getString(R.string.bar_header));
            this.jvq.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds4));
            this.jvq.setShowOval(true);
            this.jvq.setBorderColor(ap.getColor(R.color.black_alpha15));
            this.jvq.setStrokeColorResId(R.color.CAM_X0201);
            ap.setBackgroundColor(this.mRootView, R.color.CAM_X0201);
            ap.setBackgroundResource(this.jvv, R.drawable.white_bg_frs_header_round_corner);
            ap.setBackgroundResource(this.jvu, R.color.CAM_X0201);
            ap.setImageResource(this.jvx, R.drawable.ic_icon_pure_topbar_return40_svg);
            SvgManager.btW().a(this.jvy, R.drawable.ic_icon_pure_topbar_share40_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
            this.jvz.setImageDrawable(WebPManager.a(R.drawable.icon_pure_topbar_information40, ap.getColor(R.color.CAM_X0101), (WebPManager.ResourceStateType) null));
            SvgManager.btW().a(this.jvA, R.drawable.ic_icon_pure_topbar_search40_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
            SvgManager.btW().a(this.jvu, R.drawable.bg_pure_loadingskeleton_svg, R.color.CAM_X0204, SvgManager.SvgResourceStateType.NORMAL);
        }
    }
}
