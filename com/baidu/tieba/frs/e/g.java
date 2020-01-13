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
/* loaded from: classes7.dex */
public class g {
    private TbImageView.c Nr = new TbImageView.c() { // from class: com.baidu.tieba.frs.e.g.2
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
    public RelativeLayout esp;
    public LinearGradientView gIJ;
    public BarImageView gIK;
    public TextView gIL;
    public FrsHeaderBannerView gIM;
    public View gIN;
    public TbImageView gIO;
    public TbImageView gIP;
    public ImageView gIQ;
    public ImageView gIR;
    public ImageView gIS;
    private Context mContext;
    public View mRootView;

    public g(final Context context) {
        if (context != null) {
            this.mContext = context;
            this.mRootView = LayoutInflater.from(context).inflate(R.layout.frs_fake_view, (ViewGroup) null);
            this.esp = (RelativeLayout) this.mRootView.findViewById(R.id.head_top_bg_container);
            this.gIJ = (LinearGradientView) this.mRootView.findViewById(R.id.head_top_gradient_bg);
            this.gIP = (TbImageView) this.mRootView.findViewById(R.id.head_top_bg_mask);
            this.gIP.setDefaultBgResource(R.color.transparent);
            this.gIP.setDefaultResource(R.drawable.pic_frs_head_default);
            this.gIK = (BarImageView) this.mRootView.findViewById(R.id.frs_image);
            this.gIL = (TextView) this.mRootView.findViewById(R.id.forum_name);
            am.setViewTextColor(this.gIL, (int) R.color.cp_cont_a);
            this.gIM = (FrsHeaderBannerView) this.mRootView.findViewById(R.id.frs_header_banner);
            this.gIN = this.mRootView.findViewById(R.id.frs_topview);
            this.gIO = (TbImageView) this.mRootView.findViewById(R.id.fake_content);
            this.gIO.setAutoChangeStyle(false);
            ((RelativeLayout.LayoutParams) this.gIO.getLayoutParams()).height = l.getEquipmentHeight(context) - l.getDimens(context, R.dimen.tbds108);
            this.gIO.setOnDrawListener(this.Nr);
            this.gIQ = (ImageView) this.mRootView.findViewById(R.id.fake_return_icon);
            this.gIR = (ImageView) this.mRootView.findViewById(R.id.fake_more_icon);
            this.gIS = (ImageView) this.mRootView.findViewById(R.id.fake_remind_icon);
            this.gIQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.e.g.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (context instanceof Activity) {
                        ((Activity) context).finish();
                    }
                }
            });
            this.gIK.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            this.gIK.setContentDescription(context.getResources().getString(R.string.bar_header));
            this.gIK.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds4));
            this.gIK.setShowOval(true);
            this.gIK.setBorderColor(am.getColor(R.color.black_alpha15));
            this.gIK.setStrokeColorResId(R.color.cp_bg_line_d);
            am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_c);
            am.setBackgroundResource(this.gIN, R.drawable.frs_fake_top_view);
            am.setImageResource(this.gIQ, R.drawable.icon_topbar_return_white_n);
            am.setImageResource(this.gIR, R.drawable.icon_topbar_more_white_n);
            SvgManager.aEp().a(this.gIS, R.drawable.icon_pure_topbar_information44_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
            am.setImageResource(this.gIO, R.drawable.pic_frs_transition_placeholder);
        }
    }
}
