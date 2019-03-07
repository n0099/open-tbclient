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
    public BarImageView fuA;
    public TextView fuB;
    public FrsHeaderBannerView fuC;
    public View fuD;
    public TbImageView fuE;
    public TbImageView fuF;
    public ImageView fuG;
    public ImageView fuH;
    public ImageView fuI;
    public LinearGradientView fuz;
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
            this.fuz = (LinearGradientView) this.mRootView.findViewById(d.g.head_top_gradient_bg);
            this.fuF = (TbImageView) this.mRootView.findViewById(d.g.head_top_bg_mask);
            this.fuF.setDefaultBgResource(d.C0236d.transparent);
            this.fuF.setDefaultResource(d.f.pic_frs_head_default);
            this.fuA = (BarImageView) this.mRootView.findViewById(d.g.frs_image);
            this.fuB = (TextView) this.mRootView.findViewById(d.g.forum_name);
            al.j(this.fuB, d.C0236d.cp_btn_a);
            this.fuC = (FrsHeaderBannerView) this.mRootView.findViewById(d.g.frs_header_banner);
            this.fuD = this.mRootView.findViewById(d.g.frs_topview);
            this.fuE = (TbImageView) this.mRootView.findViewById(d.g.fake_content);
            ((RelativeLayout.LayoutParams) this.fuE.getLayoutParams()).height = l.aQ(context) - l.h(context, d.e.tbds108);
            this.fuE.setOnDrawListener(this.mOnDrawListener);
            this.fuG = (ImageView) this.mRootView.findViewById(d.g.fake_return_icon);
            this.fuH = (ImageView) this.mRootView.findViewById(d.g.fake_search_icon);
            this.fuI = (ImageView) this.mRootView.findViewById(d.g.fake_remind_icon);
            this.fuG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.e.g.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (context instanceof Activity) {
                        ((Activity) context).finish();
                    }
                }
            });
            this.fuA.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            this.fuA.setContentDescription(context.getResources().getString(d.j.bar_header));
            this.fuA.setStrokeWith(l.h(TbadkCoreApplication.getInst(), d.e.tbds4));
            this.fuA.setShowOval(true);
            this.fuA.setBorderColor(al.getColor(d.C0236d.black_alpha15));
            this.fuA.setStrokeColorResId(d.C0236d.cp_bg_line_d);
            al.l(this.mRootView, d.C0236d.cp_bg_line_c);
            al.k(this.fuD, d.f.frs_fake_top_view);
            al.c(this.fuE, d.f.fake_bg);
            al.c(this.fuG, d.f.icon_topbar_return_white_n);
            al.c(this.fuH, d.f.icon_common_search_white_n);
            al.c(this.fuI, d.f.icon_common_news_white_n);
            al.c(this.fuE, d.f.fake_bg);
        }
    }
}
