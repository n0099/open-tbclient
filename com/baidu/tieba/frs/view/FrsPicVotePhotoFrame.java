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
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class FrsPicVotePhotoFrame extends FrameLayout {
    private int cJW;
    private TbImageView cJX;
    private ImageView cJY;
    private View cJZ;
    private View cKa;
    private TextView cKb;
    private TextView cKc;
    int cKd;
    private View cKe;
    private Context mContext;

    public FrsPicVotePhotoFrame(Context context) {
        super(context);
        this.cJW = 3;
        this.mContext = context;
        init();
    }

    public FrsPicVotePhotoFrame(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cJW = 3;
        this.mContext = context;
        init();
    }

    private void init() {
        LayoutInflater.from(this.mContext).inflate(d.j.frs_pic_vote_photo_frame, (ViewGroup) this, true);
        this.cJX = (TbImageView) findViewById(d.h.frs_pic_vote_photo);
        this.cJY = (ImageView) findViewById(d.h.frs_pic_vote_grade);
        this.cKb = (TextView) findViewById(d.h.frs_pic_vote_detail_name);
        this.cKc = (TextView) findViewById(d.h.frs_pic_vote_detail_num);
        this.cKa = findViewById(d.h.frs_pic_vote_detail_persontage_blue);
        this.cJZ = findViewById(d.h.frs_pic_vote_detail_layout);
        this.cKe = findViewById(d.h.frs_pic_vote_white_triangle);
        this.cJX.setDefaultResource(d.g.transparent_bg);
        this.cJX.setDefaultErrorResource(d.g.img_default_100);
        this.cJX.setSupportNoImage(true);
        this.cJX.setDrawBorder(true);
        this.cJX.setBorderWidth(getResources().getDimensionPixelSize(d.f.ds1));
        this.cJX.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.cKd = l.f(this.mContext, d.f.ds40);
        setBlueHeight(this.cKd);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.cJX.setPageId(bdUniqueId);
    }

    public void aL(int i, int i2) {
        ViewGroup.LayoutParams layoutParams = this.cKe.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i2;
    }

    public void setGrade(Drawable drawable) {
        if (drawable != null && this.cJY != null) {
            this.cJY.setImageDrawable(drawable);
        }
    }

    public void setBlueHeight(int i) {
        this.cKd = i;
        if (this.cJZ != null) {
            this.cJZ.getLayoutParams().height = i;
        }
        if (this.cKb != null) {
            this.cKb.getLayoutParams().height = i;
        }
        if (this.cKc != null) {
            this.cKc.getLayoutParams().height = i;
        }
    }

    public void setGradeViewLeftMargin(int i) {
        if (i >= 0 && (this.cJY.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            ((ViewGroup.MarginLayoutParams) this.cJY.getLayoutParams()).leftMargin = i;
        }
    }

    public void a(int i, String str, Boolean bool, String str2, long j, long j2) {
        this.cJX.c(str, bool.booleanValue() ? 13 : 14, false);
        double d = 0.0d;
        if (j2 > 0) {
            d = (j * 1.0d) / j2;
        }
        if (d > 0.0d && d <= 1.0d) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) (d * l.f(this.mContext, d.f.ds220)), this.cKd);
            layoutParams.gravity = 80;
            this.cKa.setLayoutParams(layoutParams);
        } else {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(0, this.cKd);
            layoutParams2.gravity = 80;
            this.cKa.setLayoutParams(layoutParams2);
        }
        if (str2 == null) {
            str2 = "";
        }
        this.cKb.setText(str2);
        this.cKc.setText(am.t(j));
    }

    public void onChangeSkinType(int i) {
        if (this.cJW != i) {
            this.cJW = i;
            this.cJX.setBorderColor(aj.getColor(d.e.common_color_10043));
            this.cJX.setDefaultBg(aj.getDrawable(d.e.common_color_10220));
            aj.j(this.cKe, d.g.pic_triangle_white_grade);
            aj.k(this.cJZ, d.e.common_color_10175);
            aj.k(this.cKa, d.e.common_color_10259);
            aj.i(this.cKb, d.e.cp_cont_g);
            aj.i(this.cKc, d.e.cp_cont_g);
        }
    }
}
