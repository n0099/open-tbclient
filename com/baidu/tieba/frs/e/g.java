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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.widget.LinearGradientView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.headerimage.FrsHeaderBannerView;
/* loaded from: classes4.dex */
public class g {
    public RelativeLayout dvZ;
    public LinearGradientView fLb;
    public BarImageView fLc;
    public TextView fLd;
    public FrsHeaderBannerView fLe;
    public View fLf;
    public TbImageView fLg;
    public TbImageView fLh;
    public ImageView fLi;
    public ImageView fLj;
    public ImageView fLk;
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
            this.dvZ = (RelativeLayout) this.mRootView.findViewById(R.id.head_top_bg_container);
            this.fLb = (LinearGradientView) this.mRootView.findViewById(R.id.head_top_gradient_bg);
            this.fLh = (TbImageView) this.mRootView.findViewById(R.id.head_top_bg_mask);
            this.fLh.setDefaultBgResource(R.color.transparent);
            this.fLh.setDefaultResource(R.drawable.pic_frs_head_default);
            this.fLc = (BarImageView) this.mRootView.findViewById(R.id.frs_image);
            this.fLd = (TextView) this.mRootView.findViewById(R.id.forum_name);
            al.j(this.fLd, R.color.cp_btn_a);
            this.fLe = (FrsHeaderBannerView) this.mRootView.findViewById(R.id.frs_header_banner);
            this.fLf = this.mRootView.findViewById(R.id.frs_topview);
            this.fLg = (TbImageView) this.mRootView.findViewById(R.id.fake_content);
            ((RelativeLayout.LayoutParams) this.fLg.getLayoutParams()).height = l.ah(context) - l.g(context, R.dimen.tbds108);
            this.fLg.setOnDrawListener(this.mOnDrawListener);
            this.fLi = (ImageView) this.mRootView.findViewById(R.id.fake_return_icon);
            this.fLj = (ImageView) this.mRootView.findViewById(R.id.fake_more_icon);
            this.fLk = (ImageView) this.mRootView.findViewById(R.id.fake_remind_icon);
            this.fLi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.e.g.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (context instanceof Activity) {
                        ((Activity) context).finish();
                    }
                }
            });
            this.fLc.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            this.fLc.setContentDescription(context.getResources().getString(R.string.bar_header));
            this.fLc.setStrokeWith(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds4));
            this.fLc.setShowOval(true);
            this.fLc.setBorderColor(al.getColor(R.color.black_alpha15));
            this.fLc.setStrokeColorResId(R.color.cp_bg_line_d);
            al.l(this.mRootView, R.color.cp_bg_line_c);
            al.k(this.fLf, R.drawable.frs_fake_top_view);
            al.c(this.fLg, (int) R.drawable.fake_bg);
            al.c(this.fLi, (int) R.drawable.icon_topbar_return_white_n);
            al.c(this.fLj, (int) R.drawable.icon_topbar_more_white_n);
            al.c(this.fLk, (int) R.drawable.icon_common_news_white_n);
            al.c(this.fLg, (int) R.drawable.fake_bg);
        }
    }
}
