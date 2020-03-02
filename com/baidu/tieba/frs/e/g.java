package com.baidu.tieba.frs.e;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.widget.LinearGradientView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.headerimage.FrsHeaderBannerView;
/* loaded from: classes9.dex */
public class g {
    private TbImageView.c NT = new TbImageView.c() { // from class: com.baidu.tieba.frs.e.g.2
        @Override // com.baidu.tbadk.widget.TbImageView.c
        public void a(TbImageView tbImageView, Canvas canvas) {
            if (tbImageView != null && tbImageView.getImageMatrix() != null) {
                Matrix imageMatrix = tbImageView.getImageMatrix();
                int equipmentWidth = l.getEquipmentWidth(g.this.mContext);
                Drawable drawable = tbImageView.getDrawable();
                if (drawable != null) {
                    float intrinsicWidth = equipmentWidth / drawable.getIntrinsicWidth();
                    imageMatrix.setScale(intrinsicWidth, intrinsicWidth);
                    tbImageView.setImageMatrix(imageMatrix);
                }
            }
        }

        @Override // com.baidu.tbadk.widget.TbImageView.c
        public void b(TbImageView tbImageView, Canvas canvas) {
        }
    };
    public RelativeLayout ewA;
    public LinearGradientView gKK;
    public BarImageView gKL;
    public TextView gKM;
    public FrsHeaderBannerView gKN;
    public View gKO;
    public TbImageView gKP;
    public TbImageView gKQ;
    public ImageView gKR;
    public ImageView gKS;
    public ImageView gKT;
    private Context mContext;
    public View mRootView;

    public g(final Context context) {
        if (context != null) {
            this.mContext = context;
            this.mRootView = LayoutInflater.from(context).inflate(R.layout.frs_fake_view, (ViewGroup) null);
            this.ewA = (RelativeLayout) this.mRootView.findViewById(R.id.head_top_bg_container);
            this.gKK = (LinearGradientView) this.mRootView.findViewById(R.id.head_top_gradient_bg);
            this.gKQ = (TbImageView) this.mRootView.findViewById(R.id.head_top_bg_mask);
            this.gKQ.setDefaultBgResource(R.color.transparent);
            this.gKQ.setDefaultResource(R.drawable.pic_frs_head_default);
            this.gKL = (BarImageView) this.mRootView.findViewById(R.id.frs_image);
            this.gKM = (TextView) this.mRootView.findViewById(R.id.forum_name);
            am.setViewTextColor(this.gKM, (int) R.color.cp_cont_a);
            this.gKN = (FrsHeaderBannerView) this.mRootView.findViewById(R.id.frs_header_banner);
            this.gKO = this.mRootView.findViewById(R.id.frs_topview);
            this.gKP = (TbImageView) this.mRootView.findViewById(R.id.fake_content);
            this.gKP.setAutoChangeStyle(false);
            ((RelativeLayout.LayoutParams) this.gKP.getLayoutParams()).height = l.getEquipmentHeight(context) - l.getDimens(context, R.dimen.tbds108);
            this.gKP.setOnDrawListener(this.NT);
            this.gKR = (ImageView) this.mRootView.findViewById(R.id.fake_return_icon);
            this.gKS = (ImageView) this.mRootView.findViewById(R.id.fake_more_icon);
            this.gKT = (ImageView) this.mRootView.findViewById(R.id.fake_remind_icon);
            this.gKR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.e.g.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (context instanceof Activity) {
                        ((Activity) context).finish();
                    }
                }
            });
            this.gKL.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            this.gKL.setContentDescription(context.getResources().getString(R.string.bar_header));
            this.gKL.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds4));
            this.gKL.setShowOval(true);
            this.gKL.setBorderColor(am.getColor(R.color.black_alpha15));
            this.gKL.setStrokeColorResId(R.color.cp_bg_line_d);
            am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_c);
            am.setBackgroundResource(this.gKO, R.drawable.frs_fake_top_view);
            am.setImageResource(this.gKR, R.drawable.icon_topbar_return_white_n);
            am.setImageResource(this.gKS, R.drawable.icon_topbar_more_white_n);
            SvgManager.aGC().a(this.gKT, R.drawable.icon_pure_topbar_information44_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
            am.setImageResource(this.gKP, R.drawable.pic_frs_transition_placeholder);
        }
    }
}
