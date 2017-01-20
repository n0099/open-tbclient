package com.baidu.tieba.frs.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class FrsPicVotePhotoFrame extends FrameLayout {
    private int bXY;
    private TbImageView bXZ;
    private ImageView bYa;
    private View bYb;
    private View bYc;
    private TextView bYd;
    private TextView bYe;
    int bYf;
    private View bYg;
    private Context mContext;

    public FrsPicVotePhotoFrame(Context context) {
        super(context);
        this.bXY = 3;
        this.mContext = context;
        init();
    }

    public FrsPicVotePhotoFrame(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bXY = 3;
        this.mContext = context;
        init();
    }

    private void init() {
        LayoutInflater.from(this.mContext).inflate(r.j.frs_pic_vote_photo_frame, (ViewGroup) this, true);
        this.bXZ = (TbImageView) findViewById(r.h.frs_pic_vote_photo);
        this.bYa = (ImageView) findViewById(r.h.frs_pic_vote_grade);
        this.bYd = (TextView) findViewById(r.h.frs_pic_vote_detail_name);
        this.bYe = (TextView) findViewById(r.h.frs_pic_vote_detail_num);
        this.bYc = findViewById(r.h.frs_pic_vote_detail_persontage_blue);
        this.bYb = findViewById(r.h.frs_pic_vote_detail_layout);
        this.bYg = findViewById(r.h.frs_pic_vote_white_triangle);
        this.bXZ.setDefaultResource(r.g.transparent_bg);
        this.bXZ.setDefaultErrorResource(r.g.img_default_100);
        this.bXZ.setSupportNoImage(true);
        this.bXZ.setDrawBorder(true);
        this.bXZ.setBorderWidth(getResources().getDimensionPixelSize(r.f.ds1));
        this.bXZ.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.bYf = com.baidu.adp.lib.util.k.e(this.mContext, r.f.ds40);
        setBlueHeight(this.bYf);
    }

    public void ak(int i, int i2) {
        ViewGroup.LayoutParams layoutParams = this.bYg.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i2;
    }

    public void setGrade(Drawable drawable) {
        if (drawable != null && this.bYa != null) {
            this.bYa.setImageDrawable(drawable);
        }
    }

    public void setBlueHeight(int i) {
        this.bYf = i;
        if (this.bYb != null) {
            this.bYb.getLayoutParams().height = i;
        }
        if (this.bYd != null) {
            this.bYd.getLayoutParams().height = i;
        }
        if (this.bYe != null) {
            this.bYe.getLayoutParams().height = i;
        }
    }

    public void setGradeViewLeftMargin(int i) {
        if (i >= 0 && (this.bYa.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            ((ViewGroup.MarginLayoutParams) this.bYa.getLayoutParams()).leftMargin = i;
        }
    }

    public void a(int i, String str, Boolean bool, String str2, long j, long j2) {
        this.bXZ.c(str, bool.booleanValue() ? 13 : 14, false);
        double d = 0.0d;
        if (j2 > 0) {
            d = (j * 1.0d) / j2;
        }
        if (d > 0.0d && d <= 1.0d) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) (d * com.baidu.adp.lib.util.k.e(this.mContext, r.f.ds220)), this.bYf);
            layoutParams.gravity = 80;
            this.bYc.setLayoutParams(layoutParams);
        } else {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(0, this.bYf);
            layoutParams2.gravity = 80;
            this.bYc.setLayoutParams(layoutParams2);
        }
        if (str2 == null) {
            str2 = "";
        }
        this.bYd.setText(str2);
        this.bYe.setText(at.u(j));
    }

    public void onChangeSkinType(int i) {
        if (this.bXY != i) {
            this.bXY = i;
            this.bXZ.setBorderColor(ap.getColor(r.e.common_color_10043));
            this.bXZ.setDefaultBg(ap.getDrawable(r.e.common_color_10220));
            ap.j(this.bYg, r.g.pic_triangle_white_grade);
            ap.k(this.bYb, r.e.common_color_10175);
            ap.k(this.bYc, r.e.common_color_10259);
            ap.i((View) this.bYd, r.e.cp_cont_g);
            ap.i((View) this.bYe, r.e.cp_cont_g);
        }
    }
}
