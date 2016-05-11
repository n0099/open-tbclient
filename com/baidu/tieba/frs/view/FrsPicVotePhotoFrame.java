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
    private int bwo;
    private TbImageView bwp;
    private ImageView bwq;
    private View bwr;
    private View bws;
    private TextView bwt;
    private TextView bwu;
    int bwv;
    private View bww;
    private Context mContext;

    public FrsPicVotePhotoFrame(Context context) {
        super(context);
        this.bwo = 3;
        this.mContext = context;
        init();
    }

    public FrsPicVotePhotoFrame(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bwo = 3;
        this.mContext = context;
        init();
    }

    private void init() {
        LayoutInflater.from(this.mContext).inflate(t.h.frs_pic_vote_photo_frame, (ViewGroup) this, true);
        this.bwp = (TbImageView) findViewById(t.g.frs_pic_vote_photo);
        this.bwq = (ImageView) findViewById(t.g.frs_pic_vote_grade);
        this.bwt = (TextView) findViewById(t.g.frs_pic_vote_detail_name);
        this.bwu = (TextView) findViewById(t.g.frs_pic_vote_detail_num);
        this.bws = findViewById(t.g.frs_pic_vote_detail_persontage_blue);
        this.bwr = findViewById(t.g.frs_pic_vote_detail_layout);
        this.bww = findViewById(t.g.frs_pic_vote_white_triangle);
        this.bwp.setDefaultResource(t.f.transparent_bg);
        this.bwp.setDefaultErrorResource(t.f.img_default_100);
        this.bwp.setSupportNoImage(true);
        this.bwp.setDrawBorder(true);
        this.bwp.setBorderWidth(getResources().getDimensionPixelSize(t.e.ds1));
        this.bwp.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.bwv = com.baidu.adp.lib.util.k.c(this.mContext, t.e.ds40);
        setBlueHeight(this.bwv);
    }

    public void Z(int i, int i2) {
        ViewGroup.LayoutParams layoutParams = this.bww.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i2;
    }

    public void setGrade(Drawable drawable) {
        if (drawable != null && this.bwq != null) {
            this.bwq.setImageDrawable(drawable);
        }
    }

    public void setBlueHeight(int i) {
        this.bwv = i;
        if (this.bwr != null) {
            this.bwr.getLayoutParams().height = i;
        }
        if (this.bwt != null) {
            this.bwt.getLayoutParams().height = i;
        }
        if (this.bwu != null) {
            this.bwu.getLayoutParams().height = i;
        }
    }

    public void setGradeViewLeftMargin(int i) {
        if (i >= 0 && (this.bwq.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            ((ViewGroup.MarginLayoutParams) this.bwq.getLayoutParams()).leftMargin = i;
        }
    }

    public void a(int i, String str, Boolean bool, String str2, long j, long j2) {
        this.bwp.c(str, bool.booleanValue() ? 13 : 14, false);
        double d = 0.0d;
        if (j2 > 0) {
            d = (j * 1.0d) / j2;
        }
        if (d > 0.0d && d <= 1.0d) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) (d * com.baidu.adp.lib.util.k.c(this.mContext, t.e.ds220)), this.bwv);
            layoutParams.gravity = 80;
            this.bws.setLayoutParams(layoutParams);
        } else {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(0, this.bwv);
            layoutParams2.gravity = 80;
            this.bws.setLayoutParams(layoutParams2);
        }
        if (str2 == null) {
            str2 = "";
        }
        this.bwt.setText(str2);
        this.bwu.setText(ay.A(j));
    }

    public void onChangeSkinType(int i) {
        if (this.bwo != i) {
            this.bwo = i;
            this.bwp.setBorderColor(at.getColor(t.d.black_alpha10));
            this.bwp.setDefaultBg(at.getDrawable(t.d.pb_default_image_bg));
            at.k(this.bww, t.f.pic_triangle_white_grade);
            at.l(this.bwr, t.d.black_alpha70);
            at.l(this.bws, t.d.cp_link_tip_a_alpha70);
            at.j((View) this.bwt, t.d.cp_cont_g);
            at.j((View) this.bwu, t.d.cp_cont_g);
        }
    }
}
