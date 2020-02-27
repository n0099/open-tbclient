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
    public RelativeLayout ewz;
    public LinearGradientView gKI;
    public BarImageView gKJ;
    public TextView gKK;
    public FrsHeaderBannerView gKL;
    public View gKM;
    public TbImageView gKN;
    public TbImageView gKO;
    public ImageView gKP;
    public ImageView gKQ;
    public ImageView gKR;
    private Context mContext;
    public View mRootView;

    public g(final Context context) {
        if (context != null) {
            this.mContext = context;
            this.mRootView = LayoutInflater.from(context).inflate(R.layout.frs_fake_view, (ViewGroup) null);
            this.ewz = (RelativeLayout) this.mRootView.findViewById(R.id.head_top_bg_container);
            this.gKI = (LinearGradientView) this.mRootView.findViewById(R.id.head_top_gradient_bg);
            this.gKO = (TbImageView) this.mRootView.findViewById(R.id.head_top_bg_mask);
            this.gKO.setDefaultBgResource(R.color.transparent);
            this.gKO.setDefaultResource(R.drawable.pic_frs_head_default);
            this.gKJ = (BarImageView) this.mRootView.findViewById(R.id.frs_image);
            this.gKK = (TextView) this.mRootView.findViewById(R.id.forum_name);
            am.setViewTextColor(this.gKK, (int) R.color.cp_cont_a);
            this.gKL = (FrsHeaderBannerView) this.mRootView.findViewById(R.id.frs_header_banner);
            this.gKM = this.mRootView.findViewById(R.id.frs_topview);
            this.gKN = (TbImageView) this.mRootView.findViewById(R.id.fake_content);
            this.gKN.setAutoChangeStyle(false);
            ((RelativeLayout.LayoutParams) this.gKN.getLayoutParams()).height = l.getEquipmentHeight(context) - l.getDimens(context, R.dimen.tbds108);
            this.gKN.setOnDrawListener(this.NT);
            this.gKP = (ImageView) this.mRootView.findViewById(R.id.fake_return_icon);
            this.gKQ = (ImageView) this.mRootView.findViewById(R.id.fake_more_icon);
            this.gKR = (ImageView) this.mRootView.findViewById(R.id.fake_remind_icon);
            this.gKP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.e.g.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (context instanceof Activity) {
                        ((Activity) context).finish();
                    }
                }
            });
            this.gKJ.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            this.gKJ.setContentDescription(context.getResources().getString(R.string.bar_header));
            this.gKJ.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds4));
            this.gKJ.setShowOval(true);
            this.gKJ.setBorderColor(am.getColor(R.color.black_alpha15));
            this.gKJ.setStrokeColorResId(R.color.cp_bg_line_d);
            am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_c);
            am.setBackgroundResource(this.gKM, R.drawable.frs_fake_top_view);
            am.setImageResource(this.gKP, R.drawable.icon_topbar_return_white_n);
            am.setImageResource(this.gKQ, R.drawable.icon_topbar_more_white_n);
            SvgManager.aGA().a(this.gKR, R.drawable.icon_pure_topbar_information44_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
            am.setImageResource(this.gKN, R.drawable.pic_frs_transition_placeholder);
        }
    }
}
