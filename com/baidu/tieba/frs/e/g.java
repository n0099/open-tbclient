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
    public RelativeLayout dAR;
    public LinearGradientView fSH;
    public BarImageView fSI;
    public TextView fSJ;
    public FrsHeaderBannerView fSK;
    public View fSL;
    public TbImageView fSM;
    public TbImageView fSN;
    public ImageView fSO;
    public ImageView fSP;
    public ImageView fSQ;
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
            this.dAR = (RelativeLayout) this.mRootView.findViewById(R.id.head_top_bg_container);
            this.fSH = (LinearGradientView) this.mRootView.findViewById(R.id.head_top_gradient_bg);
            this.fSN = (TbImageView) this.mRootView.findViewById(R.id.head_top_bg_mask);
            this.fSN.setDefaultBgResource(R.color.transparent);
            this.fSN.setDefaultResource(R.drawable.pic_frs_head_default);
            this.fSI = (BarImageView) this.mRootView.findViewById(R.id.frs_image);
            this.fSJ = (TextView) this.mRootView.findViewById(R.id.forum_name);
            am.j(this.fSJ, R.color.cp_cont_a);
            this.fSK = (FrsHeaderBannerView) this.mRootView.findViewById(R.id.frs_header_banner);
            this.fSL = this.mRootView.findViewById(R.id.frs_topview);
            this.fSM = (TbImageView) this.mRootView.findViewById(R.id.fake_content);
            this.fSM.setAutoChangeStyle(false);
            ((RelativeLayout.LayoutParams) this.fSM.getLayoutParams()).height = l.ah(context) - l.g(context, R.dimen.tbds108);
            this.fSM.setOnDrawListener(this.mOnDrawListener);
            this.fSO = (ImageView) this.mRootView.findViewById(R.id.fake_return_icon);
            this.fSP = (ImageView) this.mRootView.findViewById(R.id.fake_more_icon);
            this.fSQ = (ImageView) this.mRootView.findViewById(R.id.fake_remind_icon);
            this.fSO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.e.g.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (context instanceof Activity) {
                        ((Activity) context).finish();
                    }
                }
            });
            this.fSI.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            this.fSI.setContentDescription(context.getResources().getString(R.string.bar_header));
            this.fSI.setStrokeWith(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds4));
            this.fSI.setShowOval(true);
            this.fSI.setBorderColor(am.getColor(R.color.black_alpha15));
            this.fSI.setStrokeColorResId(R.color.cp_bg_line_d);
            am.l(this.mRootView, R.color.cp_bg_line_c);
            am.k(this.fSL, R.drawable.frs_fake_top_view);
            am.c(this.fSO, (int) R.drawable.icon_topbar_return_white_n);
            am.c(this.fSP, (int) R.drawable.icon_topbar_more_white_n);
            am.c(this.fSQ, (int) R.drawable.icon_common_news_white_n);
            am.c(this.fSM, (int) R.drawable.pic_frs_transition_placeholder);
        }
    }
}
