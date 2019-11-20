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
    private TbImageView.b HC = new TbImageView.b() { // from class: com.baidu.tieba.frs.e.g.2
        @Override // com.baidu.tbadk.widget.TbImageView.b
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

        @Override // com.baidu.tbadk.widget.TbImageView.b
        public void b(TbImageView tbImageView, Canvas canvas) {
        }
    };
    public RelativeLayout dFa;
    public LinearGradientView fRj;
    public BarImageView fRk;
    public TextView fRl;
    public FrsHeaderBannerView fRm;
    public View fRn;
    public TbImageView fRo;
    public TbImageView fRp;
    public ImageView fRq;
    public ImageView fRr;
    public ImageView fRs;
    private Context mContext;
    public View mRootView;

    public g(final Context context) {
        if (context != null) {
            this.mContext = context;
            this.mRootView = LayoutInflater.from(context).inflate(R.layout.frs_fake_view, (ViewGroup) null);
            this.dFa = (RelativeLayout) this.mRootView.findViewById(R.id.head_top_bg_container);
            this.fRj = (LinearGradientView) this.mRootView.findViewById(R.id.head_top_gradient_bg);
            this.fRp = (TbImageView) this.mRootView.findViewById(R.id.head_top_bg_mask);
            this.fRp.setDefaultBgResource(R.color.transparent);
            this.fRp.setDefaultResource(R.drawable.pic_frs_head_default);
            this.fRk = (BarImageView) this.mRootView.findViewById(R.id.frs_image);
            this.fRl = (TextView) this.mRootView.findViewById(R.id.forum_name);
            am.setViewTextColor(this.fRl, (int) R.color.cp_cont_a);
            this.fRm = (FrsHeaderBannerView) this.mRootView.findViewById(R.id.frs_header_banner);
            this.fRn = this.mRootView.findViewById(R.id.frs_topview);
            this.fRo = (TbImageView) this.mRootView.findViewById(R.id.fake_content);
            this.fRo.setAutoChangeStyle(false);
            ((RelativeLayout.LayoutParams) this.fRo.getLayoutParams()).height = l.getEquipmentHeight(context) - l.getDimens(context, R.dimen.tbds108);
            this.fRo.setOnDrawListener(this.HC);
            this.fRq = (ImageView) this.mRootView.findViewById(R.id.fake_return_icon);
            this.fRr = (ImageView) this.mRootView.findViewById(R.id.fake_more_icon);
            this.fRs = (ImageView) this.mRootView.findViewById(R.id.fake_remind_icon);
            this.fRq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.e.g.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (context instanceof Activity) {
                        ((Activity) context).finish();
                    }
                }
            });
            this.fRk.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            this.fRk.setContentDescription(context.getResources().getString(R.string.bar_header));
            this.fRk.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds4));
            this.fRk.setShowOval(true);
            this.fRk.setBorderColor(am.getColor(R.color.black_alpha15));
            this.fRk.setStrokeColorResId(R.color.cp_bg_line_d);
            am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_c);
            am.setBackgroundResource(this.fRn, R.drawable.frs_fake_top_view);
            am.setImageResource(this.fRq, R.drawable.icon_topbar_return_white_n);
            am.setImageResource(this.fRr, R.drawable.icon_topbar_more_white_n);
            am.setImageResource(this.fRs, R.drawable.icon_common_news_white_n);
            am.setImageResource(this.fRo, R.drawable.pic_frs_transition_placeholder);
        }
    }
}
