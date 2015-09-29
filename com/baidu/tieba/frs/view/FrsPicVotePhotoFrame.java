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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class FrsPicVotePhotoFrame extends FrameLayout {
    private int bdn;
    private TbImageView bdo;
    private View bdp;
    private View bdq;
    private View bdr;
    private TextView bds;
    private TextView bdt;
    int bdu;
    private View bdv;
    private Context mContext;

    public FrsPicVotePhotoFrame(Context context) {
        super(context);
        this.bdn = 3;
        this.mContext = context;
        init();
    }

    public FrsPicVotePhotoFrame(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bdn = 3;
        this.mContext = context;
        init();
    }

    private void init() {
        LayoutInflater.from(this.mContext).inflate(i.g.frs_pic_vote_photo_frame, (ViewGroup) this, true);
        this.bdu = com.baidu.adp.lib.util.k.d(this.mContext, i.d.ds40);
        this.bdo = (TbImageView) findViewById(i.f.frs_pic_vote_photo);
        this.bdp = findViewById(i.f.frs_pic_vote_grade);
        this.bds = (TextView) findViewById(i.f.frs_pic_vote_detail_name);
        this.bdt = (TextView) findViewById(i.f.frs_pic_vote_detail_num);
        this.bdr = findViewById(i.f.frs_pic_vote_detail_persontage_blue);
        this.bdq = findViewById(i.f.frs_pic_vote_detail_layout);
        this.bdv = findViewById(i.f.frs_pic_vote_white_triangle);
        this.bdo.setDefaultResource(i.e.img_default_100);
        this.bdo.setSupportNoImage(true);
        this.bdo.setDrawBorder(true);
        this.bdo.setBorderWidth(getResources().getDimensionPixelSize(i.d.ds1));
        this.bdo.setScaleType(ImageView.ScaleType.CENTER_CROP);
    }

    public void setGrade(Drawable drawable) {
        if (drawable != null && this.bdp != null) {
            this.bdp.setBackgroundDrawable(drawable);
        }
    }

    public void a(int i, String str, Boolean bool, String str2, long j, long j2) {
        this.bdo.d(str, bool.booleanValue() ? 13 : 14, false);
        double d = 0.0d;
        if (j2 > 0) {
            d = (j * 1.0d) / j2;
        }
        if (d > 0.0d && d <= 1.0d) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) (d * com.baidu.adp.lib.util.k.d(this.mContext, i.d.ds220)), this.bdu);
            layoutParams.gravity = 80;
            this.bdr.setLayoutParams(layoutParams);
        } else {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(0, this.bdu);
            layoutParams2.gravity = 80;
            this.bdr.setLayoutParams(layoutParams2);
        }
        if (str2 == null) {
            str2 = "";
        }
        this.bds.setText(str2);
        this.bdt.setText(ar.q(j));
    }

    public void onChangeSkinType(int i) {
        if (this.bdn != i) {
            this.bdn = i;
            this.bdo.setBorderColor(am.getColor(i.c.black_alpha10));
            this.bdo.setDefaultBg(am.getDrawable(i.c.pb_default_image_bg));
            am.i(this.bdv, i.e.pic_triangle_white_grade);
            am.j(this.bdq, i.c.black_alpha70);
            am.j(this.bdr, i.c.cp_link_tip_a_alpha70);
            am.h((View) this.bds, i.c.cp_cont_g);
            am.h((View) this.bdt, i.c.cp_cont_g);
        }
    }
}
