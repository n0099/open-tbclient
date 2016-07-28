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
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class FrsPicVotePhotoFrame extends FrameLayout {
    private int bVU;
    private TbImageView bVV;
    private ImageView bVW;
    private View bVX;
    private View bVY;
    private TextView bVZ;
    private TextView bWa;
    int bWb;
    private View bWc;
    private Context mContext;

    public FrsPicVotePhotoFrame(Context context) {
        super(context);
        this.bVU = 3;
        this.mContext = context;
        init();
    }

    public FrsPicVotePhotoFrame(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bVU = 3;
        this.mContext = context;
        init();
    }

    private void init() {
        LayoutInflater.from(this.mContext).inflate(u.h.frs_pic_vote_photo_frame, (ViewGroup) this, true);
        this.bVV = (TbImageView) findViewById(u.g.frs_pic_vote_photo);
        this.bVW = (ImageView) findViewById(u.g.frs_pic_vote_grade);
        this.bVZ = (TextView) findViewById(u.g.frs_pic_vote_detail_name);
        this.bWa = (TextView) findViewById(u.g.frs_pic_vote_detail_num);
        this.bVY = findViewById(u.g.frs_pic_vote_detail_persontage_blue);
        this.bVX = findViewById(u.g.frs_pic_vote_detail_layout);
        this.bWc = findViewById(u.g.frs_pic_vote_white_triangle);
        this.bVV.setDefaultResource(u.f.transparent_bg);
        this.bVV.setDefaultErrorResource(u.f.img_default_100);
        this.bVV.setSupportNoImage(true);
        this.bVV.setDrawBorder(true);
        this.bVV.setBorderWidth(getResources().getDimensionPixelSize(u.e.ds1));
        this.bVV.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.bWb = com.baidu.adp.lib.util.k.c(this.mContext, u.e.ds40);
        setBlueHeight(this.bWb);
    }

    public void ai(int i, int i2) {
        ViewGroup.LayoutParams layoutParams = this.bWc.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i2;
    }

    public void setGrade(Drawable drawable) {
        if (drawable != null && this.bVW != null) {
            this.bVW.setImageDrawable(drawable);
        }
    }

    public void setBlueHeight(int i) {
        this.bWb = i;
        if (this.bVX != null) {
            this.bVX.getLayoutParams().height = i;
        }
        if (this.bVZ != null) {
            this.bVZ.getLayoutParams().height = i;
        }
        if (this.bWa != null) {
            this.bWa.getLayoutParams().height = i;
        }
    }

    public void setGradeViewLeftMargin(int i) {
        if (i >= 0 && (this.bVW.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            ((ViewGroup.MarginLayoutParams) this.bVW.getLayoutParams()).leftMargin = i;
        }
    }

    public void a(int i, String str, Boolean bool, String str2, long j, long j2) {
        this.bVV.c(str, bool.booleanValue() ? 13 : 14, false);
        double d = 0.0d;
        if (j2 > 0) {
            d = (j * 1.0d) / j2;
        }
        if (d > 0.0d && d <= 1.0d) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) (d * com.baidu.adp.lib.util.k.c(this.mContext, u.e.ds220)), this.bWb);
            layoutParams.gravity = 80;
            this.bVY.setLayoutParams(layoutParams);
        } else {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(0, this.bWb);
            layoutParams2.gravity = 80;
            this.bVY.setLayoutParams(layoutParams2);
        }
        if (str2 == null) {
            str2 = "";
        }
        this.bVZ.setText(str2);
        this.bWa.setText(ba.w(j));
    }

    public void onChangeSkinType(int i) {
        if (this.bVU != i) {
            this.bVU = i;
            this.bVV.setBorderColor(av.getColor(u.d.common_color_10043));
            this.bVV.setDefaultBg(av.getDrawable(u.d.common_color_10220));
            av.k(this.bWc, u.f.pic_triangle_white_grade);
            av.l(this.bVX, u.d.common_color_10175);
            av.l(this.bVY, u.d.common_color_10259);
            av.j((View) this.bVZ, u.d.cp_cont_g);
            av.j((View) this.bWa, u.d.cp_cont_g);
        }
    }
}
