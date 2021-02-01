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
    public RelativeLayout gOt;
    public LinearGradientView jIK;
    public BarImageView jIL;
    public TextView jIM;
    public FrsHeaderBannerView jIN;
    public LinearLayout jIO;
    public ImageView jIP;
    public View jIQ;
    public TbImageView jIR;
    public ImageView jIS;
    public ImageView jIT;
    public ImageView jIU;
    public ImageView jIV;
    public View mRootView;

    public g(final Context context) {
        if (context != null) {
            this.mRootView = LayoutInflater.from(context).inflate(R.layout.frs_fake_view, (ViewGroup) null);
            this.gOt = (RelativeLayout) this.mRootView.findViewById(R.id.head_top_bg_container);
            this.jIK = (LinearGradientView) this.mRootView.findViewById(R.id.head_top_gradient_bg);
            this.jIR = (TbImageView) this.mRootView.findViewById(R.id.head_top_bg_mask);
            this.jIR.setDefaultBgResource(R.color.transparent);
            this.jIR.setDefaultResource(R.drawable.pic_frs_head_default);
            this.jIL = (BarImageView) this.mRootView.findViewById(R.id.frs_image);
            this.jIM = (TextView) this.mRootView.findViewById(R.id.forum_name);
            ap.setViewTextColor(this.jIM, R.color.CAM_X0101);
            this.jIN = (FrsHeaderBannerView) this.mRootView.findViewById(R.id.frs_header_banner);
            this.jIO = (LinearLayout) this.mRootView.findViewById(R.id.fake_content_layout);
            this.jIP = (ImageView) this.mRootView.findViewById(R.id.fake_content_img);
            this.jIQ = this.mRootView.findViewById(R.id.header_round_corner_layout);
            this.jIS = (ImageView) this.mRootView.findViewById(R.id.fake_return_icon);
            this.jIT = (ImageView) this.mRootView.findViewById(R.id.fake_share_icon);
            this.jIU = (ImageView) this.mRootView.findViewById(R.id.fake_information_icon);
            this.jIV = (ImageView) this.mRootView.findViewById(R.id.fake_search_icon);
            this.jIS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.c.g.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (context instanceof Activity) {
                        ((Activity) context).finish();
                    }
                }
            });
            this.jIL.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            this.jIL.setContentDescription(context.getResources().getString(R.string.bar_header));
            this.jIL.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds4));
            this.jIL.setShowOval(true);
            this.jIL.setBorderColor(ap.getColor(R.color.black_alpha15));
            this.jIL.setStrokeColorResId(R.color.CAM_X0201);
            ap.setBackgroundColor(this.mRootView, R.color.CAM_X0201);
            ap.setBackgroundResource(this.jIQ, R.drawable.white_bg_frs_header_round_corner);
            ap.setBackgroundResource(this.jIP, R.color.CAM_X0201);
            ap.setImageResource(this.jIS, R.drawable.ic_icon_pure_topbar_return40_svg);
            SvgManager.bsR().a(this.jIT, R.drawable.ic_icon_pure_topbar_share40_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
            this.jIU.setImageDrawable(WebPManager.a(R.drawable.icon_pure_topbar_information40, ap.getColor(R.color.CAM_X0101), (WebPManager.ResourceStateType) null));
            SvgManager.bsR().a(this.jIV, R.drawable.ic_icon_pure_topbar_search40_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
            SvgManager.bsR().a(this.jIP, R.drawable.bg_pure_loadingskeleton_svg, R.color.CAM_X0204, SvgManager.SvgResourceStateType.NORMAL);
        }
    }
}
