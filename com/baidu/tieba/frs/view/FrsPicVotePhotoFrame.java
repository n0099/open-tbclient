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
    private int cBW;
    private TbImageView cBX;
    private ImageView cBY;
    private View cBZ;
    private View cCa;
    private TextView cCb;
    private TextView cCc;
    int cCd;
    private View cCe;
    private Context mContext;

    public FrsPicVotePhotoFrame(Context context) {
        super(context);
        this.cBW = 3;
        this.mContext = context;
        init();
    }

    public FrsPicVotePhotoFrame(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cBW = 3;
        this.mContext = context;
        init();
    }

    private void init() {
        LayoutInflater.from(this.mContext).inflate(d.j.frs_pic_vote_photo_frame, (ViewGroup) this, true);
        this.cBX = (TbImageView) findViewById(d.h.frs_pic_vote_photo);
        this.cBY = (ImageView) findViewById(d.h.frs_pic_vote_grade);
        this.cCb = (TextView) findViewById(d.h.frs_pic_vote_detail_name);
        this.cCc = (TextView) findViewById(d.h.frs_pic_vote_detail_num);
        this.cCa = findViewById(d.h.frs_pic_vote_detail_persontage_blue);
        this.cBZ = findViewById(d.h.frs_pic_vote_detail_layout);
        this.cCe = findViewById(d.h.frs_pic_vote_white_triangle);
        this.cBX.setDefaultResource(d.g.transparent_bg);
        this.cBX.setDefaultErrorResource(d.g.img_default_100);
        this.cBX.setSupportNoImage(true);
        this.cBX.setDrawBorder(true);
        this.cBX.setBorderWidth(getResources().getDimensionPixelSize(d.f.ds1));
        this.cBX.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.cCd = k.g(this.mContext, d.f.ds40);
        setBlueHeight(this.cCd);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.cBX.setPageId(bdUniqueId);
    }

    public void aD(int i, int i2) {
        ViewGroup.LayoutParams layoutParams = this.cCe.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i2;
    }

    public void setGrade(Drawable drawable) {
        if (drawable != null && this.cBY != null) {
            this.cBY.setImageDrawable(drawable);
        }
    }

    public void setBlueHeight(int i) {
        this.cCd = i;
        if (this.cBZ != null) {
            this.cBZ.getLayoutParams().height = i;
        }
        if (this.cCb != null) {
            this.cCb.getLayoutParams().height = i;
        }
        if (this.cCc != null) {
            this.cCc.getLayoutParams().height = i;
        }
    }

    public void setGradeViewLeftMargin(int i) {
        if (i >= 0 && (this.cBY.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            ((ViewGroup.MarginLayoutParams) this.cBY.getLayoutParams()).leftMargin = i;
        }
    }

    public void a(int i, String str, Boolean bool, String str2, long j, long j2) {
        this.cBX.c(str, bool.booleanValue() ? 13 : 14, false);
        double d = 0.0d;
        if (j2 > 0) {
            d = (j * 1.0d) / j2;
        }
        if (d > 0.0d && d <= 1.0d) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) (d * k.g(this.mContext, d.f.ds220)), this.cCd);
            layoutParams.gravity = 80;
            this.cCa.setLayoutParams(layoutParams);
        } else {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(0, this.cCd);
            layoutParams2.gravity = 80;
            this.cCa.setLayoutParams(layoutParams2);
        }
        if (str2 == null) {
            str2 = "";
        }
        this.cCb.setText(str2);
        this.cCc.setText(al.u(j));
    }

    public void onChangeSkinType(int i) {
        if (this.cBW != i) {
            this.cBW = i;
            this.cBX.setBorderColor(ai.getColor(d.e.common_color_10043));
            this.cBX.setDefaultBg(ai.getDrawable(d.e.common_color_10220));
            ai.j(this.cCe, d.g.pic_triangle_white_grade);
            ai.k(this.cBZ, d.e.common_color_10175);
            ai.k(this.cCa, d.e.common_color_10259);
            ai.i(this.cCb, d.e.cp_cont_g);
            ai.i(this.cCc, d.e.cp_cont_g);
        }
    }
}
