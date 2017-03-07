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
    private TextView cfA;
    int cfB;
    private View cfC;
    private int cfu;
    private TbImageView cfv;
    private ImageView cfw;
    private View cfx;
    private View cfy;
    private TextView cfz;
    private Context mContext;

    public FrsPicVotePhotoFrame(Context context) {
        super(context);
        this.cfu = 3;
        this.mContext = context;
        init();
    }

    public FrsPicVotePhotoFrame(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cfu = 3;
        this.mContext = context;
        init();
    }

    private void init() {
        LayoutInflater.from(this.mContext).inflate(w.j.frs_pic_vote_photo_frame, (ViewGroup) this, true);
        this.cfv = (TbImageView) findViewById(w.h.frs_pic_vote_photo);
        this.cfw = (ImageView) findViewById(w.h.frs_pic_vote_grade);
        this.cfz = (TextView) findViewById(w.h.frs_pic_vote_detail_name);
        this.cfA = (TextView) findViewById(w.h.frs_pic_vote_detail_num);
        this.cfy = findViewById(w.h.frs_pic_vote_detail_persontage_blue);
        this.cfx = findViewById(w.h.frs_pic_vote_detail_layout);
        this.cfC = findViewById(w.h.frs_pic_vote_white_triangle);
        this.cfv.setDefaultResource(w.g.transparent_bg);
        this.cfv.setDefaultErrorResource(w.g.img_default_100);
        this.cfv.setSupportNoImage(true);
        this.cfv.setDrawBorder(true);
        this.cfv.setBorderWidth(getResources().getDimensionPixelSize(w.f.ds1));
        this.cfv.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.cfB = com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds40);
        setBlueHeight(this.cfB);
    }

    public void aq(int i, int i2) {
        ViewGroup.LayoutParams layoutParams = this.cfC.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i2;
    }

    public void setGrade(Drawable drawable) {
        if (drawable != null && this.cfw != null) {
            this.cfw.setImageDrawable(drawable);
        }
    }

    public void setBlueHeight(int i) {
        this.cfB = i;
        if (this.cfx != null) {
            this.cfx.getLayoutParams().height = i;
        }
        if (this.cfz != null) {
            this.cfz.getLayoutParams().height = i;
        }
        if (this.cfA != null) {
            this.cfA.getLayoutParams().height = i;
        }
    }

    public void setGradeViewLeftMargin(int i) {
        if (i >= 0 && (this.cfw.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            ((ViewGroup.MarginLayoutParams) this.cfw.getLayoutParams()).leftMargin = i;
        }
    }

    public void a(int i, String str, Boolean bool, String str2, long j, long j2) {
        this.cfv.c(str, bool.booleanValue() ? 13 : 14, false);
        double d = 0.0d;
        if (j2 > 0) {
            d = (j * 1.0d) / j2;
        }
        if (d > 0.0d && d <= 1.0d) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) (d * com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds220)), this.cfB);
            layoutParams.gravity = 80;
            this.cfy.setLayoutParams(layoutParams);
        } else {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(0, this.cfB);
            layoutParams2.gravity = 80;
            this.cfy.setLayoutParams(layoutParams2);
        }
        if (str2 == null) {
            str2 = "";
        }
        this.cfz.setText(str2);
        this.cfA.setText(au.t(j));
    }

    public void onChangeSkinType(int i) {
        if (this.cfu != i) {
            this.cfu = i;
            this.cfv.setBorderColor(aq.getColor(w.e.common_color_10043));
            this.cfv.setDefaultBg(aq.getDrawable(w.e.common_color_10220));
            aq.j(this.cfC, w.g.pic_triangle_white_grade);
            aq.k(this.cfx, w.e.common_color_10175);
            aq.k(this.cfy, w.e.common_color_10259);
            aq.i((View) this.cfz, w.e.cp_cont_g);
            aq.i((View) this.cfA, w.e.cp_cont_g);
        }
    }
}
