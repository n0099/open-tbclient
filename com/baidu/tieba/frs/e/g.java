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
/* loaded from: classes21.dex */
public class g {
    public RelativeLayout gvX;
    public LinearGradientView jhM;
    public BarImageView jhN;
    public TextView jhO;
    public FrsHeaderBannerView jhP;
    public LinearLayout jhQ;
    public ImageView jhR;
    public View jhS;
    public TbImageView jhT;
    public ImageView jhU;
    public ImageView jhV;
    public ImageView jhW;
    public ImageView jhX;
    public View mRootView;

    public g(final Context context) {
        if (context != null) {
            this.mRootView = LayoutInflater.from(context).inflate(R.layout.frs_fake_view, (ViewGroup) null);
            this.gvX = (RelativeLayout) this.mRootView.findViewById(R.id.head_top_bg_container);
            this.jhM = (LinearGradientView) this.mRootView.findViewById(R.id.head_top_gradient_bg);
            this.jhT = (TbImageView) this.mRootView.findViewById(R.id.head_top_bg_mask);
            this.jhT.setDefaultBgResource(R.color.transparent);
            this.jhT.setDefaultResource(R.drawable.pic_frs_head_default);
            this.jhN = (BarImageView) this.mRootView.findViewById(R.id.frs_image);
            this.jhO = (TextView) this.mRootView.findViewById(R.id.forum_name);
            ap.setViewTextColor(this.jhO, R.color.CAM_X0101);
            this.jhP = (FrsHeaderBannerView) this.mRootView.findViewById(R.id.frs_header_banner);
            this.jhQ = (LinearLayout) this.mRootView.findViewById(R.id.fake_content_layout);
            this.jhR = (ImageView) this.mRootView.findViewById(R.id.fake_content_img);
            this.jhS = this.mRootView.findViewById(R.id.header_round_corner_layout);
            this.jhU = (ImageView) this.mRootView.findViewById(R.id.fake_return_icon);
            this.jhV = (ImageView) this.mRootView.findViewById(R.id.fake_share_icon);
            this.jhW = (ImageView) this.mRootView.findViewById(R.id.fake_information_icon);
            this.jhX = (ImageView) this.mRootView.findViewById(R.id.fake_search_icon);
            this.jhU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.e.g.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (context instanceof Activity) {
                        ((Activity) context).finish();
                    }
                }
            });
            this.jhN.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            this.jhN.setContentDescription(context.getResources().getString(R.string.bar_header));
            this.jhN.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds4));
            this.jhN.setShowOval(true);
            this.jhN.setBorderColor(ap.getColor(R.color.black_alpha15));
            this.jhN.setStrokeColorResId(R.color.CAM_X0201);
            ap.setBackgroundColor(this.mRootView, R.color.CAM_X0201);
            ap.setBackgroundResource(this.jhS, R.drawable.white_bg_frs_header_round_corner);
            ap.setBackgroundResource(this.jhR, R.color.CAM_X0201);
            ap.setImageResource(this.jhU, R.drawable.ic_icon_pure_topbar_return40_svg);
            SvgManager.bqB().a(this.jhV, R.drawable.ic_icon_pure_topbar_share40_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
            this.jhW.setImageDrawable(WebPManager.a(R.drawable.icon_pure_topbar_information40, ap.getColor(R.color.CAM_X0101), (WebPManager.ResourceStateType) null));
            SvgManager.bqB().a(this.jhX, R.drawable.ic_icon_pure_topbar_search40_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
            SvgManager.bqB().a(this.jhR, R.drawable.bg_pure_loadingskeleton_svg, R.color.CAM_X0204, SvgManager.SvgResourceStateType.NORMAL);
        }
    }
}
