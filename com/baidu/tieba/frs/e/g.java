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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.widget.LinearGradientView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.headerimage.FrsHeaderBannerView;
/* loaded from: classes4.dex */
public class g {
    public RelativeLayout dzg;
    public LinearGradientView fQQ;
    public BarImageView fQR;
    public TextView fQS;
    public FrsHeaderBannerView fQT;
    public View fQU;
    public TbImageView fQV;
    public TbImageView fQW;
    public ImageView fQX;
    public ImageView fQY;
    public ImageView fQZ;
    private Context mContext;
    private TbImageView.b mOnDrawListener = new TbImageView.b() { // from class: com.baidu.tieba.frs.e.g.2
        @Override // com.baidu.tbadk.widget.TbImageView.b
        public void a(TbImageView tbImageView, Canvas canvas) {
            if (tbImageView != null && tbImageView.getImageMatrix() != null) {
                Matrix imageMatrix = tbImageView.getImageMatrix();
                int af = l.af(g.this.mContext);
                Drawable drawable = tbImageView.getDrawable();
                if (drawable != null) {
                    float intrinsicWidth = af / drawable.getIntrinsicWidth();
                    imageMatrix.setScale(intrinsicWidth, intrinsicWidth);
                    tbImageView.setImageMatrix(imageMatrix);
                }
            }
        }

        @Override // com.baidu.tbadk.widget.TbImageView.b
        public void b(TbImageView tbImageView, Canvas canvas) {
        }
    };
    public View mRootView;

    public g(final Context context) {
        if (context != null) {
            this.mContext = context;
            this.mRootView = LayoutInflater.from(context).inflate(R.layout.frs_fake_view, (ViewGroup) null);
            this.dzg = (RelativeLayout) this.mRootView.findViewById(R.id.head_top_bg_container);
            this.fQQ = (LinearGradientView) this.mRootView.findViewById(R.id.head_top_gradient_bg);
            this.fQW = (TbImageView) this.mRootView.findViewById(R.id.head_top_bg_mask);
            this.fQW.setDefaultBgResource(R.color.transparent);
            this.fQW.setDefaultResource(R.drawable.pic_frs_head_default);
            this.fQR = (BarImageView) this.mRootView.findViewById(R.id.frs_image);
            this.fQS = (TextView) this.mRootView.findViewById(R.id.forum_name);
            am.j(this.fQS, R.color.cp_btn_a);
            this.fQT = (FrsHeaderBannerView) this.mRootView.findViewById(R.id.frs_header_banner);
            this.fQU = this.mRootView.findViewById(R.id.frs_topview);
            this.fQV = (TbImageView) this.mRootView.findViewById(R.id.fake_content);
            ((RelativeLayout.LayoutParams) this.fQV.getLayoutParams()).height = l.ah(context) - l.g(context, R.dimen.tbds108);
            this.fQV.setOnDrawListener(this.mOnDrawListener);
            this.fQX = (ImageView) this.mRootView.findViewById(R.id.fake_return_icon);
            this.fQY = (ImageView) this.mRootView.findViewById(R.id.fake_more_icon);
            this.fQZ = (ImageView) this.mRootView.findViewById(R.id.fake_remind_icon);
            this.fQX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.e.g.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (context instanceof Activity) {
                        ((Activity) context).finish();
                    }
                }
            });
            this.fQR.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            this.fQR.setContentDescription(context.getResources().getString(R.string.bar_header));
            this.fQR.setStrokeWith(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds4));
            this.fQR.setShowOval(true);
            this.fQR.setBorderColor(am.getColor(R.color.black_alpha15));
            this.fQR.setStrokeColorResId(R.color.cp_bg_line_d);
            am.l(this.mRootView, R.color.cp_bg_line_c);
            am.k(this.fQU, R.drawable.frs_fake_top_view);
            am.c(this.fQV, (int) R.drawable.fake_bg);
            am.c(this.fQX, (int) R.drawable.icon_topbar_return_white_n);
            am.c(this.fQY, (int) R.drawable.icon_topbar_more_white_n);
            am.c(this.fQZ, (int) R.drawable.icon_common_news_white_n);
            am.c(this.fQV, (int) R.drawable.fake_bg);
        }
    }
}
