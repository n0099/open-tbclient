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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class FrsPicVotePhotoFrame extends FrameLayout {
    private TextView bRA;
    int bRB;
    private View bRC;
    private int bRu;
    private TbImageView bRv;
    private ImageView bRw;
    private View bRx;
    private View bRy;
    private TextView bRz;
    private Context mContext;

    public FrsPicVotePhotoFrame(Context context) {
        super(context);
        this.bRu = 3;
        this.mContext = context;
        init();
    }

    public FrsPicVotePhotoFrame(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bRu = 3;
        this.mContext = context;
        init();
    }

    private void init() {
        LayoutInflater.from(this.mContext).inflate(r.h.frs_pic_vote_photo_frame, (ViewGroup) this, true);
        this.bRv = (TbImageView) findViewById(r.g.frs_pic_vote_photo);
        this.bRw = (ImageView) findViewById(r.g.frs_pic_vote_grade);
        this.bRz = (TextView) findViewById(r.g.frs_pic_vote_detail_name);
        this.bRA = (TextView) findViewById(r.g.frs_pic_vote_detail_num);
        this.bRy = findViewById(r.g.frs_pic_vote_detail_persontage_blue);
        this.bRx = findViewById(r.g.frs_pic_vote_detail_layout);
        this.bRC = findViewById(r.g.frs_pic_vote_white_triangle);
        this.bRv.setDefaultResource(r.f.transparent_bg);
        this.bRv.setDefaultErrorResource(r.f.img_default_100);
        this.bRv.setSupportNoImage(true);
        this.bRv.setDrawBorder(true);
        this.bRv.setBorderWidth(getResources().getDimensionPixelSize(r.e.ds1));
        this.bRv.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.bRB = com.baidu.adp.lib.util.k.e(this.mContext, r.e.ds40);
        setBlueHeight(this.bRB);
    }

    public void ak(int i, int i2) {
        ViewGroup.LayoutParams layoutParams = this.bRC.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i2;
    }

    public void setGrade(Drawable drawable) {
        if (drawable != null && this.bRw != null) {
            this.bRw.setImageDrawable(drawable);
        }
    }

    public void setBlueHeight(int i) {
        this.bRB = i;
        if (this.bRx != null) {
            this.bRx.getLayoutParams().height = i;
        }
        if (this.bRz != null) {
            this.bRz.getLayoutParams().height = i;
        }
        if (this.bRA != null) {
            this.bRA.getLayoutParams().height = i;
        }
    }

    public void setGradeViewLeftMargin(int i) {
        if (i >= 0 && (this.bRw.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            ((ViewGroup.MarginLayoutParams) this.bRw.getLayoutParams()).leftMargin = i;
        }
    }

    public void a(int i, String str, Boolean bool, String str2, long j, long j2) {
        this.bRv.c(str, bool.booleanValue() ? 13 : 14, false);
        double d = 0.0d;
        if (j2 > 0) {
            d = (j * 1.0d) / j2;
        }
        if (d > 0.0d && d <= 1.0d) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) (d * com.baidu.adp.lib.util.k.e(this.mContext, r.e.ds220)), this.bRB);
            layoutParams.gravity = 80;
            this.bRy.setLayoutParams(layoutParams);
        } else {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(0, this.bRB);
            layoutParams2.gravity = 80;
            this.bRy.setLayoutParams(layoutParams2);
        }
        if (str2 == null) {
            str2 = "";
        }
        this.bRz.setText(str2);
        this.bRA.setText(av.v(j));
    }

    public void onChangeSkinType(int i) {
        if (this.bRu != i) {
            this.bRu = i;
            this.bRv.setBorderColor(ar.getColor(r.d.common_color_10043));
            this.bRv.setDefaultBg(ar.getDrawable(r.d.common_color_10220));
            ar.k(this.bRC, r.f.pic_triangle_white_grade);
            ar.l(this.bRx, r.d.common_color_10175);
            ar.l(this.bRy, r.d.common_color_10259);
            ar.j((View) this.bRz, r.d.cp_cont_g);
            ar.j((View) this.bRA, r.d.cp_cont_g);
        }
    }
}
