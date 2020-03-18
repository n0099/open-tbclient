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
    private TbImageView.c NU = new TbImageView.c() { // from class: com.baidu.tieba.frs.e.g.2
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
    public RelativeLayout exj;
    public LinearGradientView gMb;
    public BarImageView gMc;
    public TextView gMd;
    public FrsHeaderBannerView gMe;
    public View gMf;
    public TbImageView gMg;
    public TbImageView gMh;
    public ImageView gMi;
    public ImageView gMj;
    public ImageView gMk;
    private Context mContext;
    public View mRootView;

    public g(final Context context) {
        if (context != null) {
            this.mContext = context;
            this.mRootView = LayoutInflater.from(context).inflate(R.layout.frs_fake_view, (ViewGroup) null);
            this.exj = (RelativeLayout) this.mRootView.findViewById(R.id.head_top_bg_container);
            this.gMb = (LinearGradientView) this.mRootView.findViewById(R.id.head_top_gradient_bg);
            this.gMh = (TbImageView) this.mRootView.findViewById(R.id.head_top_bg_mask);
            this.gMh.setDefaultBgResource(R.color.transparent);
            this.gMh.setDefaultResource(R.drawable.pic_frs_head_default);
            this.gMc = (BarImageView) this.mRootView.findViewById(R.id.frs_image);
            this.gMd = (TextView) this.mRootView.findViewById(R.id.forum_name);
            am.setViewTextColor(this.gMd, (int) R.color.cp_cont_a);
            this.gMe = (FrsHeaderBannerView) this.mRootView.findViewById(R.id.frs_header_banner);
            this.gMf = this.mRootView.findViewById(R.id.frs_topview);
            this.gMg = (TbImageView) this.mRootView.findViewById(R.id.fake_content);
            this.gMg.setAutoChangeStyle(false);
            ((RelativeLayout.LayoutParams) this.gMg.getLayoutParams()).height = l.getEquipmentHeight(context) - l.getDimens(context, R.dimen.tbds108);
            this.gMg.setOnDrawListener(this.NU);
            this.gMi = (ImageView) this.mRootView.findViewById(R.id.fake_return_icon);
            this.gMj = (ImageView) this.mRootView.findViewById(R.id.fake_more_icon);
            this.gMk = (ImageView) this.mRootView.findViewById(R.id.fake_remind_icon);
            this.gMi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.e.g.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (context instanceof Activity) {
                        ((Activity) context).finish();
                    }
                }
            });
            this.gMc.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            this.gMc.setContentDescription(context.getResources().getString(R.string.bar_header));
            this.gMc.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds4));
            this.gMc.setShowOval(true);
            this.gMc.setBorderColor(am.getColor(R.color.black_alpha15));
            this.gMc.setStrokeColorResId(R.color.cp_bg_line_d);
            am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_c);
            am.setBackgroundResource(this.gMf, R.drawable.frs_fake_top_view);
            am.setImageResource(this.gMi, R.drawable.icon_topbar_return_white_n);
            am.setImageResource(this.gMj, R.drawable.icon_topbar_more_white_n);
            SvgManager.aGG().a(this.gMk, R.drawable.icon_pure_topbar_information44_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
            am.setImageResource(this.gMg, R.drawable.pic_frs_transition_placeholder);
        }
    }
}
