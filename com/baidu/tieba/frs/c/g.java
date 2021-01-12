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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.widget.LinearGradientView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.headerimage.FrsHeaderBannerView;
/* loaded from: classes2.dex */
public class g {
    public RelativeLayout gLN;
    public LinearGradientView jDg;
    public BarImageView jDh;
    public TextView jDi;
    public FrsHeaderBannerView jDj;
    public LinearLayout jDk;
    public ImageView jDl;
    public View jDm;
    public TbImageView jDn;
    public ImageView jDo;
    public ImageView jDp;
    public ImageView jDq;
    public ImageView jDr;
    public View mRootView;

    public g(final Context context) {
        if (context != null) {
            this.mRootView = LayoutInflater.from(context).inflate(R.layout.frs_fake_view, (ViewGroup) null);
            this.gLN = (RelativeLayout) this.mRootView.findViewById(R.id.head_top_bg_container);
            this.jDg = (LinearGradientView) this.mRootView.findViewById(R.id.head_top_gradient_bg);
            this.jDn = (TbImageView) this.mRootView.findViewById(R.id.head_top_bg_mask);
            this.jDn.setDefaultBgResource(R.color.transparent);
            this.jDn.setDefaultResource(R.drawable.pic_frs_head_default);
            this.jDh = (BarImageView) this.mRootView.findViewById(R.id.frs_image);
            this.jDi = (TextView) this.mRootView.findViewById(R.id.forum_name);
            ao.setViewTextColor(this.jDi, R.color.CAM_X0101);
            this.jDj = (FrsHeaderBannerView) this.mRootView.findViewById(R.id.frs_header_banner);
            this.jDk = (LinearLayout) this.mRootView.findViewById(R.id.fake_content_layout);
            this.jDl = (ImageView) this.mRootView.findViewById(R.id.fake_content_img);
            this.jDm = this.mRootView.findViewById(R.id.header_round_corner_layout);
            this.jDo = (ImageView) this.mRootView.findViewById(R.id.fake_return_icon);
            this.jDp = (ImageView) this.mRootView.findViewById(R.id.fake_share_icon);
            this.jDq = (ImageView) this.mRootView.findViewById(R.id.fake_information_icon);
            this.jDr = (ImageView) this.mRootView.findViewById(R.id.fake_search_icon);
            this.jDo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.c.g.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (context instanceof Activity) {
                        ((Activity) context).finish();
                    }
                }
            });
            this.jDh.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            this.jDh.setContentDescription(context.getResources().getString(R.string.bar_header));
            this.jDh.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds4));
            this.jDh.setShowOval(true);
            this.jDh.setBorderColor(ao.getColor(R.color.black_alpha15));
            this.jDh.setStrokeColorResId(R.color.CAM_X0201);
            ao.setBackgroundColor(this.mRootView, R.color.CAM_X0201);
            ao.setBackgroundResource(this.jDm, R.drawable.white_bg_frs_header_round_corner);
            ao.setBackgroundResource(this.jDl, R.color.CAM_X0201);
            ao.setImageResource(this.jDo, R.drawable.ic_icon_pure_topbar_return40_svg);
            SvgManager.bsx().a(this.jDp, R.drawable.ic_icon_pure_topbar_share40_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
            this.jDq.setImageDrawable(WebPManager.a(R.drawable.icon_pure_topbar_information40, ao.getColor(R.color.CAM_X0101), (WebPManager.ResourceStateType) null));
            SvgManager.bsx().a(this.jDr, R.drawable.ic_icon_pure_topbar_search40_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
            SvgManager.bsx().a(this.jDl, R.drawable.bg_pure_loadingskeleton_svg, R.color.CAM_X0204, SvgManager.SvgResourceStateType.NORMAL);
        }
    }
}
