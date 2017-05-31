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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class FrsPicVotePhotoFrame extends FrameLayout {
    private TextView cjA;
    private TextView cjB;
    int cjC;
    private View cjD;
    private int cjv;
    private TbImageView cjw;
    private ImageView cjx;
    private View cjy;
    private View cjz;
    private Context mContext;

    public FrsPicVotePhotoFrame(Context context) {
        super(context);
        this.cjv = 3;
        this.mContext = context;
        init();
    }

    public FrsPicVotePhotoFrame(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cjv = 3;
        this.mContext = context;
        init();
    }

    private void init() {
        LayoutInflater.from(this.mContext).inflate(w.j.frs_pic_vote_photo_frame, (ViewGroup) this, true);
        this.cjw = (TbImageView) findViewById(w.h.frs_pic_vote_photo);
        this.cjx = (ImageView) findViewById(w.h.frs_pic_vote_grade);
        this.cjA = (TextView) findViewById(w.h.frs_pic_vote_detail_name);
        this.cjB = (TextView) findViewById(w.h.frs_pic_vote_detail_num);
        this.cjz = findViewById(w.h.frs_pic_vote_detail_persontage_blue);
        this.cjy = findViewById(w.h.frs_pic_vote_detail_layout);
        this.cjD = findViewById(w.h.frs_pic_vote_white_triangle);
        this.cjw.setDefaultResource(w.g.transparent_bg);
        this.cjw.setDefaultErrorResource(w.g.img_default_100);
        this.cjw.setSupportNoImage(true);
        this.cjw.setDrawBorder(true);
        this.cjw.setBorderWidth(getResources().getDimensionPixelSize(w.f.ds1));
        this.cjw.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.cjC = com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds40);
        setBlueHeight(this.cjC);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.cjw.setPageId(bdUniqueId);
    }

    public void ap(int i, int i2) {
        ViewGroup.LayoutParams layoutParams = this.cjD.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i2;
    }

    public void setGrade(Drawable drawable) {
        if (drawable != null && this.cjx != null) {
            this.cjx.setImageDrawable(drawable);
        }
    }

    public void setBlueHeight(int i) {
        this.cjC = i;
        if (this.cjy != null) {
            this.cjy.getLayoutParams().height = i;
        }
        if (this.cjA != null) {
            this.cjA.getLayoutParams().height = i;
        }
        if (this.cjB != null) {
            this.cjB.getLayoutParams().height = i;
        }
    }

    public void setGradeViewLeftMargin(int i) {
        if (i >= 0 && (this.cjx.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            ((ViewGroup.MarginLayoutParams) this.cjx.getLayoutParams()).leftMargin = i;
        }
    }

    public void a(int i, String str, Boolean bool, String str2, long j, long j2) {
        this.cjw.c(str, bool.booleanValue() ? 13 : 14, false);
        double d = 0.0d;
        if (j2 > 0) {
            d = (j * 1.0d) / j2;
        }
        if (d > 0.0d && d <= 1.0d) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) (d * com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds220)), this.cjC);
            layoutParams.gravity = 80;
            this.cjz.setLayoutParams(layoutParams);
        } else {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(0, this.cjC);
            layoutParams2.gravity = 80;
            this.cjz.setLayoutParams(layoutParams2);
        }
        if (str2 == null) {
            str2 = "";
        }
        this.cjA.setText(str2);
        this.cjB.setText(au.t(j));
    }

    public void onChangeSkinType(int i) {
        if (this.cjv != i) {
            this.cjv = i;
            this.cjw.setBorderColor(aq.getColor(w.e.common_color_10043));
            this.cjw.setDefaultBg(aq.getDrawable(w.e.common_color_10220));
            aq.j(this.cjD, w.g.pic_triangle_white_grade);
            aq.k(this.cjy, w.e.common_color_10175);
            aq.k(this.cjz, w.e.common_color_10259);
            aq.i(this.cjA, w.e.cp_cont_g);
            aq.i(this.cjB, w.e.cp_cont_g);
        }
    }
}
