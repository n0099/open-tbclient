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
    public RelativeLayout dlo;
    public TextView fuA;
    public FrsHeaderBannerView fuB;
    public View fuC;
    public TbImageView fuD;
    public TbImageView fuE;
    public ImageView fuF;
    public ImageView fuG;
    public ImageView fuH;
    public LinearGradientView fuy;
    public BarImageView fuz;
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
            this.dlo = (RelativeLayout) this.mRootView.findViewById(d.g.head_top_bg_container);
            this.fuy = (LinearGradientView) this.mRootView.findViewById(d.g.head_top_gradient_bg);
            this.fuE = (TbImageView) this.mRootView.findViewById(d.g.head_top_bg_mask);
            this.fuE.setDefaultBgResource(d.C0277d.transparent);
            this.fuE.setDefaultResource(d.f.pic_frs_head_default);
            this.fuz = (BarImageView) this.mRootView.findViewById(d.g.frs_image);
            this.fuA = (TextView) this.mRootView.findViewById(d.g.forum_name);
            al.j(this.fuA, d.C0277d.cp_btn_a);
            this.fuB = (FrsHeaderBannerView) this.mRootView.findViewById(d.g.frs_header_banner);
            this.fuC = this.mRootView.findViewById(d.g.frs_topview);
            this.fuD = (TbImageView) this.mRootView.findViewById(d.g.fake_content);
            ((RelativeLayout.LayoutParams) this.fuD.getLayoutParams()).height = l.aQ(context) - l.h(context, d.e.tbds108);
            this.fuD.setOnDrawListener(this.mOnDrawListener);
            this.fuF = (ImageView) this.mRootView.findViewById(d.g.fake_return_icon);
            this.fuG = (ImageView) this.mRootView.findViewById(d.g.fake_search_icon);
            this.fuH = (ImageView) this.mRootView.findViewById(d.g.fake_remind_icon);
            this.fuF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.e.g.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (context instanceof Activity) {
                        ((Activity) context).finish();
                    }
                }
            });
            this.fuz.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            this.fuz.setContentDescription(context.getResources().getString(d.j.bar_header));
            this.fuz.setStrokeWith(l.h(TbadkCoreApplication.getInst(), d.e.tbds4));
            this.fuz.setShowOval(true);
            this.fuz.setBorderColor(al.getColor(d.C0277d.black_alpha15));
            this.fuz.setStrokeColorResId(d.C0277d.cp_bg_line_d);
            al.l(this.mRootView, d.C0277d.cp_bg_line_c);
            al.k(this.fuC, d.f.frs_fake_top_view);
            al.c(this.fuD, d.f.fake_bg);
            al.c(this.fuF, d.f.icon_topbar_return_white_n);
            al.c(this.fuG, d.f.icon_common_search_white_n);
            al.c(this.fuH, d.f.icon_common_news_white_n);
            al.c(this.fuD, d.f.fake_bg);
        }
    }
}
