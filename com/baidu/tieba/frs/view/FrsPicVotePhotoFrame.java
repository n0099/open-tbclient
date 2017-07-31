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
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class FrsPicVotePhotoFrame extends FrameLayout {
    private ImageView cAa;
    private View cAb;
    private View cAc;
    private TextView cAd;
    private TextView cAe;
    int cAf;
    private View cAg;
    private int czY;
    private TbImageView czZ;
    private Context mContext;

    public FrsPicVotePhotoFrame(Context context) {
        super(context);
        this.czY = 3;
        this.mContext = context;
        init();
    }

    public FrsPicVotePhotoFrame(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.czY = 3;
        this.mContext = context;
        init();
    }

    private void init() {
        LayoutInflater.from(this.mContext).inflate(d.j.frs_pic_vote_photo_frame, (ViewGroup) this, true);
        this.czZ = (TbImageView) findViewById(d.h.frs_pic_vote_photo);
        this.cAa = (ImageView) findViewById(d.h.frs_pic_vote_grade);
        this.cAd = (TextView) findViewById(d.h.frs_pic_vote_detail_name);
        this.cAe = (TextView) findViewById(d.h.frs_pic_vote_detail_num);
        this.cAc = findViewById(d.h.frs_pic_vote_detail_persontage_blue);
        this.cAb = findViewById(d.h.frs_pic_vote_detail_layout);
        this.cAg = findViewById(d.h.frs_pic_vote_white_triangle);
        this.czZ.setDefaultResource(d.g.transparent_bg);
        this.czZ.setDefaultErrorResource(d.g.img_default_100);
        this.czZ.setSupportNoImage(true);
        this.czZ.setDrawBorder(true);
        this.czZ.setBorderWidth(getResources().getDimensionPixelSize(d.f.ds1));
        this.czZ.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.cAf = k.g(this.mContext, d.f.ds40);
        setBlueHeight(this.cAf);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.czZ.setPageId(bdUniqueId);
    }

    public void av(int i, int i2) {
        ViewGroup.LayoutParams layoutParams = this.cAg.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i2;
    }

    public void setGrade(Drawable drawable) {
        if (drawable != null && this.cAa != null) {
            this.cAa.setImageDrawable(drawable);
        }
    }

    public void setBlueHeight(int i) {
        this.cAf = i;
        if (this.cAb != null) {
            this.cAb.getLayoutParams().height = i;
        }
        if (this.cAd != null) {
            this.cAd.getLayoutParams().height = i;
        }
        if (this.cAe != null) {
            this.cAe.getLayoutParams().height = i;
        }
    }

    public void setGradeViewLeftMargin(int i) {
        if (i >= 0 && (this.cAa.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            ((ViewGroup.MarginLayoutParams) this.cAa.getLayoutParams()).leftMargin = i;
        }
    }

    public void a(int i, String str, Boolean bool, String str2, long j, long j2) {
        this.czZ.c(str, bool.booleanValue() ? 13 : 14, false);
        double d = 0.0d;
        if (j2 > 0) {
            d = (j * 1.0d) / j2;
        }
        if (d > 0.0d && d <= 1.0d) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) (d * k.g(this.mContext, d.f.ds220)), this.cAf);
            layoutParams.gravity = 80;
            this.cAc.setLayoutParams(layoutParams);
        } else {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(0, this.cAf);
            layoutParams2.gravity = 80;
            this.cAc.setLayoutParams(layoutParams2);
        }
        if (str2 == null) {
            str2 = "";
        }
        this.cAd.setText(str2);
        this.cAe.setText(al.u(j));
    }

    public void onChangeSkinType(int i) {
        if (this.czY != i) {
            this.czY = i;
            this.czZ.setBorderColor(ai.getColor(d.e.common_color_10043));
            this.czZ.setDefaultBg(ai.getDrawable(d.e.common_color_10220));
            ai.j(this.cAg, d.g.pic_triangle_white_grade);
            ai.k(this.cAb, d.e.common_color_10175);
            ai.k(this.cAc, d.e.common_color_10259);
            ai.i(this.cAd, d.e.cp_cont_g);
            ai.i(this.cAe, d.e.cp_cont_g);
        }
    }
}
