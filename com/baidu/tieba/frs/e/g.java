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
    public RelativeLayout dwa;
    public LinearGradientView fLe;
    public BarImageView fLf;
    public TextView fLg;
    public FrsHeaderBannerView fLh;
    public View fLi;
    public TbImageView fLj;
    public TbImageView fLk;
    public ImageView fLl;
    public ImageView fLm;
    public ImageView fLn;
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
            this.dwa = (RelativeLayout) this.mRootView.findViewById(R.id.head_top_bg_container);
            this.fLe = (LinearGradientView) this.mRootView.findViewById(R.id.head_top_gradient_bg);
            this.fLk = (TbImageView) this.mRootView.findViewById(R.id.head_top_bg_mask);
            this.fLk.setDefaultBgResource(R.color.transparent);
            this.fLk.setDefaultResource(R.drawable.pic_frs_head_default);
            this.fLf = (BarImageView) this.mRootView.findViewById(R.id.frs_image);
            this.fLg = (TextView) this.mRootView.findViewById(R.id.forum_name);
            al.j(this.fLg, R.color.cp_btn_a);
            this.fLh = (FrsHeaderBannerView) this.mRootView.findViewById(R.id.frs_header_banner);
            this.fLi = this.mRootView.findViewById(R.id.frs_topview);
            this.fLj = (TbImageView) this.mRootView.findViewById(R.id.fake_content);
            ((RelativeLayout.LayoutParams) this.fLj.getLayoutParams()).height = l.ah(context) - l.g(context, R.dimen.tbds108);
            this.fLj.setOnDrawListener(this.mOnDrawListener);
            this.fLl = (ImageView) this.mRootView.findViewById(R.id.fake_return_icon);
            this.fLm = (ImageView) this.mRootView.findViewById(R.id.fake_more_icon);
            this.fLn = (ImageView) this.mRootView.findViewById(R.id.fake_remind_icon);
            this.fLl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.e.g.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (context instanceof Activity) {
                        ((Activity) context).finish();
                    }
                }
            });
            this.fLf.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            this.fLf.setContentDescription(context.getResources().getString(R.string.bar_header));
            this.fLf.setStrokeWith(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds4));
            this.fLf.setShowOval(true);
            this.fLf.setBorderColor(al.getColor(R.color.black_alpha15));
            this.fLf.setStrokeColorResId(R.color.cp_bg_line_d);
            al.l(this.mRootView, R.color.cp_bg_line_c);
            al.k(this.fLi, R.drawable.frs_fake_top_view);
            al.c(this.fLj, (int) R.drawable.fake_bg);
            al.c(this.fLl, (int) R.drawable.icon_topbar_return_white_n);
            al.c(this.fLm, (int) R.drawable.icon_topbar_more_white_n);
            al.c(this.fLn, (int) R.drawable.icon_common_news_white_n);
            al.c(this.fLj, (int) R.drawable.fake_bg);
        }
    }
}
