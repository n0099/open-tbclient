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
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class FrsPicVotePhotoFrame extends FrameLayout {
    private TextView crA;
    private TextView crB;
    int crC;
    private View crD;
    private int crv;
    private TbImageView crw;
    private ImageView crx;
    private View cry;
    private View crz;
    private Context mContext;

    public FrsPicVotePhotoFrame(Context context) {
        super(context);
        this.crv = 3;
        this.mContext = context;
        init();
    }

    public FrsPicVotePhotoFrame(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.crv = 3;
        this.mContext = context;
        init();
    }

    private void init() {
        LayoutInflater.from(this.mContext).inflate(w.j.frs_pic_vote_photo_frame, (ViewGroup) this, true);
        this.crw = (TbImageView) findViewById(w.h.frs_pic_vote_photo);
        this.crx = (ImageView) findViewById(w.h.frs_pic_vote_grade);
        this.crA = (TextView) findViewById(w.h.frs_pic_vote_detail_name);
        this.crB = (TextView) findViewById(w.h.frs_pic_vote_detail_num);
        this.crz = findViewById(w.h.frs_pic_vote_detail_persontage_blue);
        this.cry = findViewById(w.h.frs_pic_vote_detail_layout);
        this.crD = findViewById(w.h.frs_pic_vote_white_triangle);
        this.crw.setDefaultResource(w.g.transparent_bg);
        this.crw.setDefaultErrorResource(w.g.img_default_100);
        this.crw.setSupportNoImage(true);
        this.crw.setDrawBorder(true);
        this.crw.setBorderWidth(getResources().getDimensionPixelSize(w.f.ds1));
        this.crw.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.crC = com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds40);
        setBlueHeight(this.crC);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.crw.setPageId(bdUniqueId);
    }

    public void av(int i, int i2) {
        ViewGroup.LayoutParams layoutParams = this.crD.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i2;
    }

    public void setGrade(Drawable drawable) {
        if (drawable != null && this.crx != null) {
            this.crx.setImageDrawable(drawable);
        }
    }

    public void setBlueHeight(int i) {
        this.crC = i;
        if (this.cry != null) {
            this.cry.getLayoutParams().height = i;
        }
        if (this.crA != null) {
            this.crA.getLayoutParams().height = i;
        }
        if (this.crB != null) {
            this.crB.getLayoutParams().height = i;
        }
    }

    public void setGradeViewLeftMargin(int i) {
        if (i >= 0 && (this.crx.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            ((ViewGroup.MarginLayoutParams) this.crx.getLayoutParams()).leftMargin = i;
        }
    }

    public void a(int i, String str, Boolean bool, String str2, long j, long j2) {
        this.crw.c(str, bool.booleanValue() ? 13 : 14, false);
        double d = 0.0d;
        if (j2 > 0) {
            d = (j * 1.0d) / j2;
        }
        if (d > 0.0d && d <= 1.0d) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) (d * com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds220)), this.crC);
            layoutParams.gravity = 80;
            this.crz.setLayoutParams(layoutParams);
        } else {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(0, this.crC);
            layoutParams2.gravity = 80;
            this.crz.setLayoutParams(layoutParams2);
        }
        if (str2 == null) {
            str2 = "";
        }
        this.crA.setText(str2);
        this.crB.setText(aw.t(j));
    }

    public void onChangeSkinType(int i) {
        if (this.crv != i) {
            this.crv = i;
            this.crw.setBorderColor(as.getColor(w.e.common_color_10043));
            this.crw.setDefaultBg(as.getDrawable(w.e.common_color_10220));
            as.j(this.crD, w.g.pic_triangle_white_grade);
            as.k(this.cry, w.e.common_color_10175);
            as.k(this.crz, w.e.common_color_10259);
            as.i(this.crA, w.e.cp_cont_g);
            as.i(this.crB, w.e.cp_cont_g);
        }
    }
}
