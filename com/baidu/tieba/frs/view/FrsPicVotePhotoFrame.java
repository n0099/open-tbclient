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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class FrsPicVotePhotoFrame extends FrameLayout {
    private int cIm;
    private TbImageView cIn;
    private ImageView cIo;
    private View cIp;
    private View cIq;
    private TextView cIr;
    private TextView cIs;
    int cIt;
    private View cIu;
    private Context mContext;

    public FrsPicVotePhotoFrame(Context context) {
        super(context);
        this.cIm = 3;
        this.mContext = context;
        init();
    }

    public FrsPicVotePhotoFrame(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cIm = 3;
        this.mContext = context;
        init();
    }

    private void init() {
        LayoutInflater.from(this.mContext).inflate(d.j.frs_pic_vote_photo_frame, (ViewGroup) this, true);
        this.cIn = (TbImageView) findViewById(d.h.frs_pic_vote_photo);
        this.cIo = (ImageView) findViewById(d.h.frs_pic_vote_grade);
        this.cIr = (TextView) findViewById(d.h.frs_pic_vote_detail_name);
        this.cIs = (TextView) findViewById(d.h.frs_pic_vote_detail_num);
        this.cIq = findViewById(d.h.frs_pic_vote_detail_persontage_blue);
        this.cIp = findViewById(d.h.frs_pic_vote_detail_layout);
        this.cIu = findViewById(d.h.frs_pic_vote_white_triangle);
        this.cIn.setDefaultResource(d.g.transparent_bg);
        this.cIn.setDefaultErrorResource(d.g.img_default_100);
        this.cIn.setSupportNoImage(true);
        this.cIn.setDrawBorder(true);
        this.cIn.setBorderWidth(getResources().getDimensionPixelSize(d.f.ds1));
        this.cIn.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.cIt = k.g(this.mContext, d.f.ds40);
        setBlueHeight(this.cIt);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.cIn.setPageId(bdUniqueId);
    }

    public void aC(int i, int i2) {
        ViewGroup.LayoutParams layoutParams = this.cIu.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i2;
    }

    public void setGrade(Drawable drawable) {
        if (drawable != null && this.cIo != null) {
            this.cIo.setImageDrawable(drawable);
        }
    }

    public void setBlueHeight(int i) {
        this.cIt = i;
        if (this.cIp != null) {
            this.cIp.getLayoutParams().height = i;
        }
        if (this.cIr != null) {
            this.cIr.getLayoutParams().height = i;
        }
        if (this.cIs != null) {
            this.cIs.getLayoutParams().height = i;
        }
    }

    public void setGradeViewLeftMargin(int i) {
        if (i >= 0 && (this.cIo.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            ((ViewGroup.MarginLayoutParams) this.cIo.getLayoutParams()).leftMargin = i;
        }
    }

    public void a(int i, String str, Boolean bool, String str2, long j, long j2) {
        this.cIn.c(str, bool.booleanValue() ? 13 : 14, false);
        double d = 0.0d;
        if (j2 > 0) {
            d = (j * 1.0d) / j2;
        }
        if (d > 0.0d && d <= 1.0d) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) (d * k.g(this.mContext, d.f.ds220)), this.cIt);
            layoutParams.gravity = 80;
            this.cIq.setLayoutParams(layoutParams);
        } else {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(0, this.cIt);
            layoutParams2.gravity = 80;
            this.cIq.setLayoutParams(layoutParams2);
        }
        if (str2 == null) {
            str2 = "";
        }
        this.cIr.setText(str2);
        this.cIs.setText(am.u(j));
    }

    public void onChangeSkinType(int i) {
        if (this.cIm != i) {
            this.cIm = i;
            this.cIn.setBorderColor(aj.getColor(d.e.common_color_10043));
            this.cIn.setDefaultBg(aj.getDrawable(d.e.common_color_10220));
            aj.j(this.cIu, d.g.pic_triangle_white_grade);
            aj.k(this.cIp, d.e.common_color_10175);
            aj.k(this.cIq, d.e.common_color_10259);
            aj.i(this.cIr, d.e.cp_cont_g);
            aj.i(this.cIs, d.e.cp_cont_g);
        }
    }
}
