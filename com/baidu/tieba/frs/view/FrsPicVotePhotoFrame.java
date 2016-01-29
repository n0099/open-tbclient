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
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class FrsPicVotePhotoFrame extends FrameLayout {
    private View brA;
    private TextView brB;
    private TextView brC;
    int brD;
    private View brE;
    private int brw;
    private TbImageView brx;
    private View bry;
    private View brz;
    private Context mContext;

    public FrsPicVotePhotoFrame(Context context) {
        super(context);
        this.brw = 3;
        this.mContext = context;
        init();
    }

    public FrsPicVotePhotoFrame(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.brw = 3;
        this.mContext = context;
        init();
    }

    private void init() {
        LayoutInflater.from(this.mContext).inflate(t.h.frs_pic_vote_photo_frame, (ViewGroup) this, true);
        this.brD = com.baidu.adp.lib.util.k.c(this.mContext, t.e.ds40);
        this.brx = (TbImageView) findViewById(t.g.frs_pic_vote_photo);
        this.bry = findViewById(t.g.frs_pic_vote_grade);
        this.brB = (TextView) findViewById(t.g.frs_pic_vote_detail_name);
        this.brC = (TextView) findViewById(t.g.frs_pic_vote_detail_num);
        this.brA = findViewById(t.g.frs_pic_vote_detail_persontage_blue);
        this.brz = findViewById(t.g.frs_pic_vote_detail_layout);
        this.brE = findViewById(t.g.frs_pic_vote_white_triangle);
        this.brx.setDefaultResource(t.f.img_default_100);
        this.brx.setSupportNoImage(true);
        this.brx.setDrawBorder(true);
        this.brx.setBorderWidth(getResources().getDimensionPixelSize(t.e.ds1));
        this.brx.setScaleType(ImageView.ScaleType.CENTER_CROP);
    }

    public void setGrade(Drawable drawable) {
        if (drawable != null && this.bry != null) {
            this.bry.setBackgroundDrawable(drawable);
        }
    }

    public void a(int i, String str, Boolean bool, String str2, long j, long j2) {
        this.brx.d(str, bool.booleanValue() ? 13 : 14, false);
        double d = 0.0d;
        if (j2 > 0) {
            d = (j * 1.0d) / j2;
        }
        if (d > 0.0d && d <= 1.0d) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) (d * com.baidu.adp.lib.util.k.c(this.mContext, t.e.ds220)), this.brD);
            layoutParams.gravity = 80;
            this.brA.setLayoutParams(layoutParams);
        } else {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(0, this.brD);
            layoutParams2.gravity = 80;
            this.brA.setLayoutParams(layoutParams2);
        }
        if (str2 == null) {
            str2 = "";
        }
        this.brB.setText(str2);
        this.brC.setText(aw.x(j));
    }

    public void onChangeSkinType(int i) {
        if (this.brw != i) {
            this.brw = i;
            this.brx.setBorderColor(ar.getColor(t.d.black_alpha10));
            this.brx.setDefaultBg(ar.getDrawable(t.d.pb_default_image_bg));
            ar.k(this.brE, t.f.pic_triangle_white_grade);
            ar.l(this.brz, t.d.black_alpha70);
            ar.l(this.brA, t.d.cp_link_tip_a_alpha70);
            ar.j((View) this.brB, t.d.cp_cont_g);
            ar.j((View) this.brC, t.d.cp_cont_g);
        }
    }
}
