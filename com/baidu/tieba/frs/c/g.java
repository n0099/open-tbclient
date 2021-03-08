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
    public RelativeLayout gQq;
    public LinearGradientView jKH;
    public BarImageView jKI;
    public TextView jKJ;
    public FrsHeaderBannerView jKK;
    public LinearLayout jKL;
    public ImageView jKM;
    public View jKN;
    public TbImageView jKO;
    public ImageView jKP;
    public ImageView jKQ;
    public ImageView jKR;
    public ImageView jKS;
    public View mRootView;

    public g(final Context context) {
        if (context != null) {
            this.mRootView = LayoutInflater.from(context).inflate(R.layout.frs_fake_view, (ViewGroup) null);
            this.gQq = (RelativeLayout) this.mRootView.findViewById(R.id.head_top_bg_container);
            this.jKH = (LinearGradientView) this.mRootView.findViewById(R.id.head_top_gradient_bg);
            this.jKO = (TbImageView) this.mRootView.findViewById(R.id.head_top_bg_mask);
            this.jKO.setDefaultBgResource(R.color.transparent);
            this.jKO.setDefaultResource(R.drawable.pic_frs_head_default);
            this.jKI = (BarImageView) this.mRootView.findViewById(R.id.frs_image);
            this.jKJ = (TextView) this.mRootView.findViewById(R.id.forum_name);
            ap.setViewTextColor(this.jKJ, R.color.CAM_X0101);
            this.jKK = (FrsHeaderBannerView) this.mRootView.findViewById(R.id.frs_header_banner);
            this.jKL = (LinearLayout) this.mRootView.findViewById(R.id.fake_content_layout);
            this.jKM = (ImageView) this.mRootView.findViewById(R.id.fake_content_img);
            this.jKN = this.mRootView.findViewById(R.id.header_round_corner_layout);
            this.jKP = (ImageView) this.mRootView.findViewById(R.id.fake_return_icon);
            this.jKQ = (ImageView) this.mRootView.findViewById(R.id.fake_share_icon);
            this.jKR = (ImageView) this.mRootView.findViewById(R.id.fake_information_icon);
            this.jKS = (ImageView) this.mRootView.findViewById(R.id.fake_search_icon);
            this.jKP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.c.g.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (context instanceof Activity) {
                        ((Activity) context).finish();
                    }
                }
            });
            this.jKI.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            this.jKI.setContentDescription(context.getResources().getString(R.string.bar_header));
            this.jKI.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds4));
            this.jKI.setShowOval(true);
            this.jKI.setBorderColor(ap.getColor(R.color.black_alpha15));
            this.jKI.setStrokeColorResId(R.color.CAM_X0201);
            ap.setBackgroundColor(this.mRootView, R.color.CAM_X0201);
            ap.setBackgroundResource(this.jKN, R.drawable.white_bg_frs_header_round_corner);
            ap.setBackgroundResource(this.jKM, R.color.CAM_X0201);
            ap.setImageResource(this.jKP, R.drawable.ic_icon_pure_topbar_return40_svg);
            SvgManager.bsU().a(this.jKQ, R.drawable.ic_icon_pure_topbar_share40_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
            this.jKR.setImageDrawable(WebPManager.a(R.drawable.icon_pure_topbar_information40, ap.getColor(R.color.CAM_X0101), (WebPManager.ResourceStateType) null));
            SvgManager.bsU().a(this.jKS, R.drawable.ic_icon_pure_topbar_search40_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
            SvgManager.bsU().a(this.jKM, R.drawable.bg_pure_loadingskeleton_svg, R.color.CAM_X0204, SvgManager.SvgResourceStateType.NORMAL);
        }
    }
}
