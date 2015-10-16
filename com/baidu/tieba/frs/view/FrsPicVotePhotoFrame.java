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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class FrsPicVotePhotoFrame extends FrameLayout {
    private View bdA;
    private View bdB;
    private View bdC;
    private TextView bdD;
    private TextView bdE;
    int bdF;
    private View bdG;
    private int bdy;
    private TbImageView bdz;
    private Context mContext;

    public FrsPicVotePhotoFrame(Context context) {
        super(context);
        this.bdy = 3;
        this.mContext = context;
        init();
    }

    public FrsPicVotePhotoFrame(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bdy = 3;
        this.mContext = context;
        init();
    }

    private void init() {
        LayoutInflater.from(this.mContext).inflate(i.g.frs_pic_vote_photo_frame, (ViewGroup) this, true);
        this.bdF = com.baidu.adp.lib.util.k.d(this.mContext, i.d.ds40);
        this.bdz = (TbImageView) findViewById(i.f.frs_pic_vote_photo);
        this.bdA = findViewById(i.f.frs_pic_vote_grade);
        this.bdD = (TextView) findViewById(i.f.frs_pic_vote_detail_name);
        this.bdE = (TextView) findViewById(i.f.frs_pic_vote_detail_num);
        this.bdC = findViewById(i.f.frs_pic_vote_detail_persontage_blue);
        this.bdB = findViewById(i.f.frs_pic_vote_detail_layout);
        this.bdG = findViewById(i.f.frs_pic_vote_white_triangle);
        this.bdz.setDefaultResource(i.e.img_default_100);
        this.bdz.setSupportNoImage(true);
        this.bdz.setDrawBorder(true);
        this.bdz.setBorderWidth(getResources().getDimensionPixelSize(i.d.ds1));
        this.bdz.setScaleType(ImageView.ScaleType.CENTER_CROP);
    }

    public void setGrade(Drawable drawable) {
        if (drawable != null && this.bdA != null) {
            this.bdA.setBackgroundDrawable(drawable);
        }
    }

    public void a(int i, String str, Boolean bool, String str2, long j, long j2) {
        this.bdz.d(str, bool.booleanValue() ? 13 : 14, false);
        double d = 0.0d;
        if (j2 > 0) {
            d = (j * 1.0d) / j2;
        }
        if (d > 0.0d && d <= 1.0d) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) (d * com.baidu.adp.lib.util.k.d(this.mContext, i.d.ds220)), this.bdF);
            layoutParams.gravity = 80;
            this.bdC.setLayoutParams(layoutParams);
        } else {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(0, this.bdF);
            layoutParams2.gravity = 80;
            this.bdC.setLayoutParams(layoutParams2);
        }
        if (str2 == null) {
            str2 = "";
        }
        this.bdD.setText(str2);
        this.bdE.setText(as.q(j));
    }

    public void onChangeSkinType(int i) {
        if (this.bdy != i) {
            this.bdy = i;
            this.bdz.setBorderColor(an.getColor(i.c.black_alpha10));
            this.bdz.setDefaultBg(an.getDrawable(i.c.pb_default_image_bg));
            an.i(this.bdG, i.e.pic_triangle_white_grade);
            an.j(this.bdB, i.c.black_alpha70);
            an.j(this.bdC, i.c.cp_link_tip_a_alpha70);
            an.h((View) this.bdD, i.c.cp_cont_g);
            an.h((View) this.bdE, i.c.cp_cont_g);
        }
    }
}
