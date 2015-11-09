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
    private int bed;
    private TbImageView bee;
    private View bef;
    private View beg;
    private View beh;
    private TextView bei;
    private TextView bej;
    int bek;
    private View bel;
    private Context mContext;

    public FrsPicVotePhotoFrame(Context context) {
        super(context);
        this.bed = 3;
        this.mContext = context;
        init();
    }

    public FrsPicVotePhotoFrame(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bed = 3;
        this.mContext = context;
        init();
    }

    private void init() {
        LayoutInflater.from(this.mContext).inflate(i.g.frs_pic_vote_photo_frame, (ViewGroup) this, true);
        this.bek = com.baidu.adp.lib.util.k.d(this.mContext, i.d.ds40);
        this.bee = (TbImageView) findViewById(i.f.frs_pic_vote_photo);
        this.bef = findViewById(i.f.frs_pic_vote_grade);
        this.bei = (TextView) findViewById(i.f.frs_pic_vote_detail_name);
        this.bej = (TextView) findViewById(i.f.frs_pic_vote_detail_num);
        this.beh = findViewById(i.f.frs_pic_vote_detail_persontage_blue);
        this.beg = findViewById(i.f.frs_pic_vote_detail_layout);
        this.bel = findViewById(i.f.frs_pic_vote_white_triangle);
        this.bee.setDefaultResource(i.e.img_default_100);
        this.bee.setSupportNoImage(true);
        this.bee.setDrawBorder(true);
        this.bee.setBorderWidth(getResources().getDimensionPixelSize(i.d.ds1));
        this.bee.setScaleType(ImageView.ScaleType.CENTER_CROP);
    }

    public void setGrade(Drawable drawable) {
        if (drawable != null && this.bef != null) {
            this.bef.setBackgroundDrawable(drawable);
        }
    }

    public void a(int i, String str, Boolean bool, String str2, long j, long j2) {
        this.bee.d(str, bool.booleanValue() ? 13 : 14, false);
        double d = 0.0d;
        if (j2 > 0) {
            d = (j * 1.0d) / j2;
        }
        if (d > 0.0d && d <= 1.0d) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) (d * com.baidu.adp.lib.util.k.d(this.mContext, i.d.ds220)), this.bek);
            layoutParams.gravity = 80;
            this.beh.setLayoutParams(layoutParams);
        } else {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(0, this.bek);
            layoutParams2.gravity = 80;
            this.beh.setLayoutParams(layoutParams2);
        }
        if (str2 == null) {
            str2 = "";
        }
        this.bei.setText(str2);
        this.bej.setText(as.o(j));
    }

    public void onChangeSkinType(int i) {
        if (this.bed != i) {
            this.bed = i;
            this.bee.setBorderColor(an.getColor(i.c.black_alpha10));
            this.bee.setDefaultBg(an.getDrawable(i.c.pb_default_image_bg));
            an.i(this.bel, i.e.pic_triangle_white_grade);
            an.j(this.beg, i.c.black_alpha70);
            an.j(this.beh, i.c.cp_link_tip_a_alpha70);
            an.h((View) this.bei, i.c.cp_cont_g);
            an.h((View) this.bej, i.c.cp_cont_g);
        }
    }
}
