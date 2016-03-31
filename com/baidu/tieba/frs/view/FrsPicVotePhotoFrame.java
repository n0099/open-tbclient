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
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class FrsPicVotePhotoFrame extends FrameLayout {
    private int bwE;
    private TbImageView bwF;
    private View bwG;
    private View bwH;
    private View bwI;
    private TextView bwJ;
    private TextView bwK;
    int bwL;
    private View bwM;
    private Context mContext;

    public FrsPicVotePhotoFrame(Context context) {
        super(context);
        this.bwE = 3;
        this.mContext = context;
        init();
    }

    public FrsPicVotePhotoFrame(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bwE = 3;
        this.mContext = context;
        init();
    }

    private void init() {
        LayoutInflater.from(this.mContext).inflate(t.h.frs_pic_vote_photo_frame, (ViewGroup) this, true);
        this.bwL = com.baidu.adp.lib.util.k.c(this.mContext, t.e.ds40);
        this.bwF = (TbImageView) findViewById(t.g.frs_pic_vote_photo);
        this.bwG = findViewById(t.g.frs_pic_vote_grade);
        this.bwJ = (TextView) findViewById(t.g.frs_pic_vote_detail_name);
        this.bwK = (TextView) findViewById(t.g.frs_pic_vote_detail_num);
        this.bwI = findViewById(t.g.frs_pic_vote_detail_persontage_blue);
        this.bwH = findViewById(t.g.frs_pic_vote_detail_layout);
        this.bwM = findViewById(t.g.frs_pic_vote_white_triangle);
        this.bwF.setDefaultResource(t.f.transparent_bg);
        this.bwF.setDefaultErrorResource(t.f.img_default_100);
        this.bwF.setSupportNoImage(true);
        this.bwF.setDrawBorder(true);
        this.bwF.setBorderWidth(getResources().getDimensionPixelSize(t.e.ds1));
        this.bwF.setScaleType(ImageView.ScaleType.CENTER_CROP);
    }

    public void setGrade(Drawable drawable) {
        if (drawable != null && this.bwG != null) {
            this.bwG.setBackgroundDrawable(drawable);
        }
    }

    public void a(int i, String str, Boolean bool, String str2, long j, long j2) {
        this.bwF.c(str, bool.booleanValue() ? 13 : 14, false);
        double d = 0.0d;
        if (j2 > 0) {
            d = (j * 1.0d) / j2;
        }
        if (d > 0.0d && d <= 1.0d) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) (d * com.baidu.adp.lib.util.k.c(this.mContext, t.e.ds220)), this.bwL);
            layoutParams.gravity = 80;
            this.bwI.setLayoutParams(layoutParams);
        } else {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(0, this.bwL);
            layoutParams2.gravity = 80;
            this.bwI.setLayoutParams(layoutParams2);
        }
        if (str2 == null) {
            str2 = "";
        }
        this.bwJ.setText(str2);
        this.bwK.setText(ay.z(j));
    }

    public void onChangeSkinType(int i) {
        if (this.bwE != i) {
            this.bwE = i;
            this.bwF.setBorderColor(at.getColor(t.d.black_alpha10));
            this.bwF.setDefaultBg(at.getDrawable(t.d.pb_default_image_bg));
            at.k(this.bwM, t.f.pic_triangle_white_grade);
            at.l(this.bwH, t.d.black_alpha70);
            at.l(this.bwI, t.d.cp_link_tip_a_alpha70);
            at.j((View) this.bwJ, t.d.cp_cont_g);
            at.j((View) this.bwK, t.d.cp_cont_g);
        }
    }
}
