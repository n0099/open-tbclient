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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class FrsPicVotePhotoFrame extends FrameLayout {
    private int cdU;
    private TbImageView cdV;
    private ImageView cdW;
    private View cdX;
    private View cdY;
    private TextView cdZ;
    private TextView cea;
    int ceb;
    private View cec;
    private Context mContext;

    public FrsPicVotePhotoFrame(Context context) {
        super(context);
        this.cdU = 3;
        this.mContext = context;
        init();
    }

    public FrsPicVotePhotoFrame(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cdU = 3;
        this.mContext = context;
        init();
    }

    private void init() {
        LayoutInflater.from(this.mContext).inflate(w.j.frs_pic_vote_photo_frame, (ViewGroup) this, true);
        this.cdV = (TbImageView) findViewById(w.h.frs_pic_vote_photo);
        this.cdW = (ImageView) findViewById(w.h.frs_pic_vote_grade);
        this.cdZ = (TextView) findViewById(w.h.frs_pic_vote_detail_name);
        this.cea = (TextView) findViewById(w.h.frs_pic_vote_detail_num);
        this.cdY = findViewById(w.h.frs_pic_vote_detail_persontage_blue);
        this.cdX = findViewById(w.h.frs_pic_vote_detail_layout);
        this.cec = findViewById(w.h.frs_pic_vote_white_triangle);
        this.cdV.setDefaultResource(w.g.transparent_bg);
        this.cdV.setDefaultErrorResource(w.g.img_default_100);
        this.cdV.setSupportNoImage(true);
        this.cdV.setDrawBorder(true);
        this.cdV.setBorderWidth(getResources().getDimensionPixelSize(w.f.ds1));
        this.cdV.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.ceb = com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds40);
        setBlueHeight(this.ceb);
    }

    public void ao(int i, int i2) {
        ViewGroup.LayoutParams layoutParams = this.cec.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i2;
    }

    public void setGrade(Drawable drawable) {
        if (drawable != null && this.cdW != null) {
            this.cdW.setImageDrawable(drawable);
        }
    }

    public void setBlueHeight(int i) {
        this.ceb = i;
        if (this.cdX != null) {
            this.cdX.getLayoutParams().height = i;
        }
        if (this.cdZ != null) {
            this.cdZ.getLayoutParams().height = i;
        }
        if (this.cea != null) {
            this.cea.getLayoutParams().height = i;
        }
    }

    public void setGradeViewLeftMargin(int i) {
        if (i >= 0 && (this.cdW.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            ((ViewGroup.MarginLayoutParams) this.cdW.getLayoutParams()).leftMargin = i;
        }
    }

    public void a(int i, String str, Boolean bool, String str2, long j, long j2) {
        this.cdV.c(str, bool.booleanValue() ? 13 : 14, false);
        double d = 0.0d;
        if (j2 > 0) {
            d = (j * 1.0d) / j2;
        }
        if (d > 0.0d && d <= 1.0d) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) (d * com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds220)), this.ceb);
            layoutParams.gravity = 80;
            this.cdY.setLayoutParams(layoutParams);
        } else {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(0, this.ceb);
            layoutParams2.gravity = 80;
            this.cdY.setLayoutParams(layoutParams2);
        }
        if (str2 == null) {
            str2 = "";
        }
        this.cdZ.setText(str2);
        this.cea.setText(au.t(j));
    }

    public void onChangeSkinType(int i) {
        if (this.cdU != i) {
            this.cdU = i;
            this.cdV.setBorderColor(aq.getColor(w.e.common_color_10043));
            this.cdV.setDefaultBg(aq.getDrawable(w.e.common_color_10220));
            aq.j(this.cec, w.g.pic_triangle_white_grade);
            aq.k(this.cdX, w.e.common_color_10175);
            aq.k(this.cdY, w.e.common_color_10259);
            aq.i(this.cdZ, w.e.cp_cont_g);
            aq.i(this.cea, w.e.cp_cont_g);
        }
    }
}
