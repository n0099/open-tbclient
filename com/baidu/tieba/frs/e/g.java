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
/* loaded from: classes21.dex */
public class g {
    public RelativeLayout fUg;
    public ImageView iAa;
    public LinearGradientView izP;
    public BarImageView izQ;
    public TextView izR;
    public FrsHeaderBannerView izS;
    public LinearLayout izT;
    public ImageView izU;
    public View izV;
    public TbImageView izW;
    public ImageView izX;
    public ImageView izY;
    public ImageView izZ;
    public View mRootView;

    public g(final Context context) {
        if (context != null) {
            this.mRootView = LayoutInflater.from(context).inflate(R.layout.frs_fake_view, (ViewGroup) null);
            this.fUg = (RelativeLayout) this.mRootView.findViewById(R.id.head_top_bg_container);
            this.izP = (LinearGradientView) this.mRootView.findViewById(R.id.head_top_gradient_bg);
            this.izW = (TbImageView) this.mRootView.findViewById(R.id.head_top_bg_mask);
            this.izW.setDefaultBgResource(R.color.transparent);
            this.izW.setDefaultResource(R.drawable.pic_frs_head_default);
            this.izQ = (BarImageView) this.mRootView.findViewById(R.id.frs_image);
            this.izR = (TextView) this.mRootView.findViewById(R.id.forum_name);
            ap.setViewTextColor(this.izR, R.color.cp_cont_a);
            this.izS = (FrsHeaderBannerView) this.mRootView.findViewById(R.id.frs_header_banner);
            this.izT = (LinearLayout) this.mRootView.findViewById(R.id.fake_content_layout);
            this.izU = (ImageView) this.mRootView.findViewById(R.id.fake_content_img);
            this.izV = this.mRootView.findViewById(R.id.header_round_corner_layout);
            this.izX = (ImageView) this.mRootView.findViewById(R.id.fake_return_icon);
            this.izY = (ImageView) this.mRootView.findViewById(R.id.fake_share_icon);
            this.izZ = (ImageView) this.mRootView.findViewById(R.id.fake_information_icon);
            this.iAa = (ImageView) this.mRootView.findViewById(R.id.fake_search_icon);
            this.izX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.e.g.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (context instanceof Activity) {
                        ((Activity) context).finish();
                    }
                }
            });
            this.izQ.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            this.izQ.setContentDescription(context.getResources().getString(R.string.bar_header));
            this.izQ.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds4));
            this.izQ.setShowOval(true);
            this.izQ.setBorderColor(ap.getColor(R.color.black_alpha15));
            this.izQ.setStrokeColorResId(R.color.cp_bg_line_d);
            ap.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
            ap.setBackgroundResource(this.izV, R.drawable.bg_frs_header_round_corner);
            ap.setImageResource(this.izX, R.drawable.icon_topbar_return_white_n);
            SvgManager.bkl().a(this.izY, R.drawable.icon_pure_topbar_share44_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
            SvgManager.bkl().a(this.izZ, R.drawable.icon_pure_topbar_information44_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
            SvgManager.bkl().a(this.iAa, R.drawable.icon_pure_topbar_search44_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
            SvgManager.bkl().a(this.izU, R.drawable.bg_pure_loadingskeleton_svg, R.color.cp_bg_line_c, SvgManager.SvgResourceStateType.NORMAL);
        }
    }
}
