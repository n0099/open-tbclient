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
    public RelativeLayout ewN;
    public LinearGradientView gKW;
    public BarImageView gKX;
    public TextView gKY;
    public FrsHeaderBannerView gKZ;
    public View gLa;
    public TbImageView gLb;
    public TbImageView gLc;
    public ImageView gLd;
    public ImageView gLe;
    public ImageView gLf;
    private Context mContext;
    public View mRootView;

    public g(final Context context) {
        if (context != null) {
            this.mContext = context;
            this.mRootView = LayoutInflater.from(context).inflate(R.layout.frs_fake_view, (ViewGroup) null);
            this.ewN = (RelativeLayout) this.mRootView.findViewById(R.id.head_top_bg_container);
            this.gKW = (LinearGradientView) this.mRootView.findViewById(R.id.head_top_gradient_bg);
            this.gLc = (TbImageView) this.mRootView.findViewById(R.id.head_top_bg_mask);
            this.gLc.setDefaultBgResource(R.color.transparent);
            this.gLc.setDefaultResource(R.drawable.pic_frs_head_default);
            this.gKX = (BarImageView) this.mRootView.findViewById(R.id.frs_image);
            this.gKY = (TextView) this.mRootView.findViewById(R.id.forum_name);
            am.setViewTextColor(this.gKY, (int) R.color.cp_cont_a);
            this.gKZ = (FrsHeaderBannerView) this.mRootView.findViewById(R.id.frs_header_banner);
            this.gLa = this.mRootView.findViewById(R.id.frs_topview);
            this.gLb = (TbImageView) this.mRootView.findViewById(R.id.fake_content);
            this.gLb.setAutoChangeStyle(false);
            ((RelativeLayout.LayoutParams) this.gLb.getLayoutParams()).height = l.getEquipmentHeight(context) - l.getDimens(context, R.dimen.tbds108);
            this.gLb.setOnDrawListener(this.NT);
            this.gLd = (ImageView) this.mRootView.findViewById(R.id.fake_return_icon);
            this.gLe = (ImageView) this.mRootView.findViewById(R.id.fake_more_icon);
            this.gLf = (ImageView) this.mRootView.findViewById(R.id.fake_remind_icon);
            this.gLd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.e.g.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (context instanceof Activity) {
                        ((Activity) context).finish();
                    }
                }
            });
            this.gKX.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            this.gKX.setContentDescription(context.getResources().getString(R.string.bar_header));
            this.gKX.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds4));
            this.gKX.setShowOval(true);
            this.gKX.setBorderColor(am.getColor(R.color.black_alpha15));
            this.gKX.setStrokeColorResId(R.color.cp_bg_line_d);
            am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_c);
            am.setBackgroundResource(this.gLa, R.drawable.frs_fake_top_view);
            am.setImageResource(this.gLd, R.drawable.icon_topbar_return_white_n);
            am.setImageResource(this.gLe, R.drawable.icon_topbar_more_white_n);
            SvgManager.aGC().a(this.gLf, R.drawable.icon_pure_topbar_information44_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
            am.setImageResource(this.gLb, R.drawable.pic_frs_transition_placeholder);
        }
    }
}
