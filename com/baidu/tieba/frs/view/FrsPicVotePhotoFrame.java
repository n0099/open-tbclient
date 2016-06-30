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
    private int bTU;
    private TbImageView bTV;
    private ImageView bTW;
    private View bTX;
    private View bTY;
    private TextView bTZ;
    private TextView bUa;
    int bUb;
    private View bUc;
    private Context mContext;

    public FrsPicVotePhotoFrame(Context context) {
        super(context);
        this.bTU = 3;
        this.mContext = context;
        init();
    }

    public FrsPicVotePhotoFrame(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bTU = 3;
        this.mContext = context;
        init();
    }

    private void init() {
        LayoutInflater.from(this.mContext).inflate(u.h.frs_pic_vote_photo_frame, (ViewGroup) this, true);
        this.bTV = (TbImageView) findViewById(u.g.frs_pic_vote_photo);
        this.bTW = (ImageView) findViewById(u.g.frs_pic_vote_grade);
        this.bTZ = (TextView) findViewById(u.g.frs_pic_vote_detail_name);
        this.bUa = (TextView) findViewById(u.g.frs_pic_vote_detail_num);
        this.bTY = findViewById(u.g.frs_pic_vote_detail_persontage_blue);
        this.bTX = findViewById(u.g.frs_pic_vote_detail_layout);
        this.bUc = findViewById(u.g.frs_pic_vote_white_triangle);
        this.bTV.setDefaultResource(u.f.transparent_bg);
        this.bTV.setDefaultErrorResource(u.f.img_default_100);
        this.bTV.setSupportNoImage(true);
        this.bTV.setDrawBorder(true);
        this.bTV.setBorderWidth(getResources().getDimensionPixelSize(u.e.ds1));
        this.bTV.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.bUb = com.baidu.adp.lib.util.k.c(this.mContext, u.e.ds40);
        setBlueHeight(this.bUb);
    }

    public void ah(int i, int i2) {
        ViewGroup.LayoutParams layoutParams = this.bUc.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i2;
    }

    public void setGrade(Drawable drawable) {
        if (drawable != null && this.bTW != null) {
            this.bTW.setImageDrawable(drawable);
        }
    }

    public void setBlueHeight(int i) {
        this.bUb = i;
        if (this.bTX != null) {
            this.bTX.getLayoutParams().height = i;
        }
        if (this.bTZ != null) {
            this.bTZ.getLayoutParams().height = i;
        }
        if (this.bUa != null) {
            this.bUa.getLayoutParams().height = i;
        }
    }

    public void setGradeViewLeftMargin(int i) {
        if (i >= 0 && (this.bTW.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            ((ViewGroup.MarginLayoutParams) this.bTW.getLayoutParams()).leftMargin = i;
        }
    }

    public void a(int i, String str, Boolean bool, String str2, long j, long j2) {
        this.bTV.c(str, bool.booleanValue() ? 13 : 14, false);
        double d = 0.0d;
        if (j2 > 0) {
            d = (j * 1.0d) / j2;
        }
        if (d > 0.0d && d <= 1.0d) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) (d * com.baidu.adp.lib.util.k.c(this.mContext, u.e.ds220)), this.bUb);
            layoutParams.gravity = 80;
            this.bTY.setLayoutParams(layoutParams);
        } else {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(0, this.bUb);
            layoutParams2.gravity = 80;
            this.bTY.setLayoutParams(layoutParams2);
        }
        if (str2 == null) {
            str2 = "";
        }
        this.bTZ.setText(str2);
        this.bUa.setText(ba.B(j));
    }

    public void onChangeSkinType(int i) {
        if (this.bTU != i) {
            this.bTU = i;
            this.bTV.setBorderColor(av.getColor(u.d.common_color_10043));
            this.bTV.setDefaultBg(av.getDrawable(u.d.common_color_10220));
            av.k(this.bUc, u.f.pic_triangle_white_grade);
            av.l(this.bTX, u.d.common_color_10175);
            av.l(this.bTY, u.d.common_color_10259);
            av.j((View) this.bTZ, u.d.cp_cont_g);
            av.j((View) this.bUa, u.d.cp_cont_g);
        }
    }
}
