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
import com.baidu.tieba.d;
import com.baidu.tieba.frs.headerimage.FrsHeaderBannerView;
/* loaded from: classes4.dex */
public class g {
    public RelativeLayout dls;
    public LinearGradientView fuk;
    public BarImageView ful;
    public TextView fum;
    public FrsHeaderBannerView fun;
    public View fuo;
    public TbImageView fup;
    public TbImageView fuq;
    public ImageView fur;
    public ImageView fus;
    public ImageView fut;
    private Context mContext;
    private TbImageView.b mOnDrawListener = new TbImageView.b() { // from class: com.baidu.tieba.frs.e.g.2
        @Override // com.baidu.tbadk.widget.TbImageView.b
        public void a(TbImageView tbImageView, Canvas canvas) {
            if (tbImageView != null && tbImageView.getImageMatrix() != null) {
                Matrix imageMatrix = tbImageView.getImageMatrix();
                int aO = l.aO(g.this.mContext);
                Drawable drawable = tbImageView.getDrawable();
                if (drawable != null) {
                    float intrinsicWidth = aO / drawable.getIntrinsicWidth();
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
            this.mRootView = LayoutInflater.from(context).inflate(d.h.frs_fake_view, (ViewGroup) null);
            this.dls = (RelativeLayout) this.mRootView.findViewById(d.g.head_top_bg_container);
            this.fuk = (LinearGradientView) this.mRootView.findViewById(d.g.head_top_gradient_bg);
            this.fuq = (TbImageView) this.mRootView.findViewById(d.g.head_top_bg_mask);
            this.fuq.setDefaultBgResource(d.C0277d.transparent);
            this.fuq.setDefaultResource(d.f.pic_frs_head_default);
            this.ful = (BarImageView) this.mRootView.findViewById(d.g.frs_image);
            this.fum = (TextView) this.mRootView.findViewById(d.g.forum_name);
            al.j(this.fum, d.C0277d.cp_btn_a);
            this.fun = (FrsHeaderBannerView) this.mRootView.findViewById(d.g.frs_header_banner);
            this.fuo = this.mRootView.findViewById(d.g.frs_topview);
            this.fup = (TbImageView) this.mRootView.findViewById(d.g.fake_content);
            ((RelativeLayout.LayoutParams) this.fup.getLayoutParams()).height = l.aQ(context) - l.h(context, d.e.tbds108);
            this.fup.setOnDrawListener(this.mOnDrawListener);
            this.fur = (ImageView) this.mRootView.findViewById(d.g.fake_return_icon);
            this.fus = (ImageView) this.mRootView.findViewById(d.g.fake_search_icon);
            this.fut = (ImageView) this.mRootView.findViewById(d.g.fake_remind_icon);
            this.fur.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.e.g.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (context instanceof Activity) {
                        ((Activity) context).finish();
                    }
                }
            });
            this.ful.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            this.ful.setContentDescription(context.getResources().getString(d.j.bar_header));
            this.ful.setStrokeWith(l.h(TbadkCoreApplication.getInst(), d.e.tbds4));
            this.ful.setShowOval(true);
            this.ful.setBorderColor(al.getColor(d.C0277d.black_alpha15));
            this.ful.setStrokeColorResId(d.C0277d.cp_bg_line_d);
            al.l(this.mRootView, d.C0277d.cp_bg_line_c);
            al.k(this.fuo, d.f.frs_fake_top_view);
            al.c(this.fup, d.f.fake_bg);
            al.c(this.fur, d.f.icon_topbar_return_white_n);
            al.c(this.fus, d.f.icon_common_search_white_n);
            al.c(this.fut, d.f.icon_common_news_white_n);
            al.c(this.fup, d.f.fake_bg);
        }
    }
}
