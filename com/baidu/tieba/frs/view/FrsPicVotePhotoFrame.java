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
    private int cgl;
    private TbImageView cgm;
    private ImageView cgn;
    private View cgo;
    private View cgp;
    private TextView cgq;
    private TextView cgr;
    int cgs;
    private View cgt;
    private Context mContext;

    public FrsPicVotePhotoFrame(Context context) {
        super(context);
        this.cgl = 3;
        this.mContext = context;
        init();
    }

    public FrsPicVotePhotoFrame(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cgl = 3;
        this.mContext = context;
        init();
    }

    private void init() {
        LayoutInflater.from(this.mContext).inflate(w.j.frs_pic_vote_photo_frame, (ViewGroup) this, true);
        this.cgm = (TbImageView) findViewById(w.h.frs_pic_vote_photo);
        this.cgn = (ImageView) findViewById(w.h.frs_pic_vote_grade);
        this.cgq = (TextView) findViewById(w.h.frs_pic_vote_detail_name);
        this.cgr = (TextView) findViewById(w.h.frs_pic_vote_detail_num);
        this.cgp = findViewById(w.h.frs_pic_vote_detail_persontage_blue);
        this.cgo = findViewById(w.h.frs_pic_vote_detail_layout);
        this.cgt = findViewById(w.h.frs_pic_vote_white_triangle);
        this.cgm.setDefaultResource(w.g.transparent_bg);
        this.cgm.setDefaultErrorResource(w.g.img_default_100);
        this.cgm.setSupportNoImage(true);
        this.cgm.setDrawBorder(true);
        this.cgm.setBorderWidth(getResources().getDimensionPixelSize(w.f.ds1));
        this.cgm.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.cgs = com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds40);
        setBlueHeight(this.cgs);
    }

    public void ao(int i, int i2) {
        ViewGroup.LayoutParams layoutParams = this.cgt.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i2;
    }

    public void setGrade(Drawable drawable) {
        if (drawable != null && this.cgn != null) {
            this.cgn.setImageDrawable(drawable);
        }
    }

    public void setBlueHeight(int i) {
        this.cgs = i;
        if (this.cgo != null) {
            this.cgo.getLayoutParams().height = i;
        }
        if (this.cgq != null) {
            this.cgq.getLayoutParams().height = i;
        }
        if (this.cgr != null) {
            this.cgr.getLayoutParams().height = i;
        }
    }

    public void setGradeViewLeftMargin(int i) {
        if (i >= 0 && (this.cgn.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            ((ViewGroup.MarginLayoutParams) this.cgn.getLayoutParams()).leftMargin = i;
        }
    }

    public void a(int i, String str, Boolean bool, String str2, long j, long j2) {
        this.cgm.c(str, bool.booleanValue() ? 13 : 14, false);
        double d = 0.0d;
        if (j2 > 0) {
            d = (j * 1.0d) / j2;
        }
        if (d > 0.0d && d <= 1.0d) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) (d * com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds220)), this.cgs);
            layoutParams.gravity = 80;
            this.cgp.setLayoutParams(layoutParams);
        } else {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(0, this.cgs);
            layoutParams2.gravity = 80;
            this.cgp.setLayoutParams(layoutParams2);
        }
        if (str2 == null) {
            str2 = "";
        }
        this.cgq.setText(str2);
        this.cgr.setText(au.t(j));
    }

    public void onChangeSkinType(int i) {
        if (this.cgl != i) {
            this.cgl = i;
            this.cgm.setBorderColor(aq.getColor(w.e.common_color_10043));
            this.cgm.setDefaultBg(aq.getDrawable(w.e.common_color_10220));
            aq.j(this.cgt, w.g.pic_triangle_white_grade);
            aq.k(this.cgo, w.e.common_color_10175);
            aq.k(this.cgp, w.e.common_color_10259);
            aq.i(this.cgq, w.e.cp_cont_g);
            aq.i(this.cgr, w.e.cp_cont_g);
        }
    }
}
