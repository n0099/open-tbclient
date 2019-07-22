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
    public RelativeLayout dyZ;
    public LinearGradientView fQc;
    public BarImageView fQd;
    public TextView fQe;
    public FrsHeaderBannerView fQf;
    public View fQg;
    public TbImageView fQh;
    public TbImageView fQi;
    public ImageView fQj;
    public ImageView fQk;
    public ImageView fQl;
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
            this.dyZ = (RelativeLayout) this.mRootView.findViewById(R.id.head_top_bg_container);
            this.fQc = (LinearGradientView) this.mRootView.findViewById(R.id.head_top_gradient_bg);
            this.fQi = (TbImageView) this.mRootView.findViewById(R.id.head_top_bg_mask);
            this.fQi.setDefaultBgResource(R.color.transparent);
            this.fQi.setDefaultResource(R.drawable.pic_frs_head_default);
            this.fQd = (BarImageView) this.mRootView.findViewById(R.id.frs_image);
            this.fQe = (TextView) this.mRootView.findViewById(R.id.forum_name);
            am.j(this.fQe, R.color.cp_btn_a);
            this.fQf = (FrsHeaderBannerView) this.mRootView.findViewById(R.id.frs_header_banner);
            this.fQg = this.mRootView.findViewById(R.id.frs_topview);
            this.fQh = (TbImageView) this.mRootView.findViewById(R.id.fake_content);
            ((RelativeLayout.LayoutParams) this.fQh.getLayoutParams()).height = l.ah(context) - l.g(context, R.dimen.tbds108);
            this.fQh.setOnDrawListener(this.mOnDrawListener);
            this.fQj = (ImageView) this.mRootView.findViewById(R.id.fake_return_icon);
            this.fQk = (ImageView) this.mRootView.findViewById(R.id.fake_more_icon);
            this.fQl = (ImageView) this.mRootView.findViewById(R.id.fake_remind_icon);
            this.fQj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.e.g.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (context instanceof Activity) {
                        ((Activity) context).finish();
                    }
                }
            });
            this.fQd.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            this.fQd.setContentDescription(context.getResources().getString(R.string.bar_header));
            this.fQd.setStrokeWith(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds4));
            this.fQd.setShowOval(true);
            this.fQd.setBorderColor(am.getColor(R.color.black_alpha15));
            this.fQd.setStrokeColorResId(R.color.cp_bg_line_d);
            am.l(this.mRootView, R.color.cp_bg_line_c);
            am.k(this.fQg, R.drawable.frs_fake_top_view);
            am.c(this.fQh, (int) R.drawable.fake_bg);
            am.c(this.fQj, (int) R.drawable.icon_topbar_return_white_n);
            am.c(this.fQk, (int) R.drawable.icon_topbar_more_white_n);
            am.c(this.fQl, (int) R.drawable.icon_common_news_white_n);
            am.c(this.fQh, (int) R.drawable.fake_bg);
        }
    }
}
