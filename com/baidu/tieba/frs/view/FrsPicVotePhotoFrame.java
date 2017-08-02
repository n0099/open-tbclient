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
    private int cyE;
    private TbImageView cyF;
    private ImageView cyG;
    private View cyH;
    private View cyI;
    private TextView cyJ;
    private TextView cyK;
    int cyL;
    private View cyM;
    private Context mContext;

    public FrsPicVotePhotoFrame(Context context) {
        super(context);
        this.cyE = 3;
        this.mContext = context;
        init();
    }

    public FrsPicVotePhotoFrame(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cyE = 3;
        this.mContext = context;
        init();
    }

    private void init() {
        LayoutInflater.from(this.mContext).inflate(d.j.frs_pic_vote_photo_frame, (ViewGroup) this, true);
        this.cyF = (TbImageView) findViewById(d.h.frs_pic_vote_photo);
        this.cyG = (ImageView) findViewById(d.h.frs_pic_vote_grade);
        this.cyJ = (TextView) findViewById(d.h.frs_pic_vote_detail_name);
        this.cyK = (TextView) findViewById(d.h.frs_pic_vote_detail_num);
        this.cyI = findViewById(d.h.frs_pic_vote_detail_persontage_blue);
        this.cyH = findViewById(d.h.frs_pic_vote_detail_layout);
        this.cyM = findViewById(d.h.frs_pic_vote_white_triangle);
        this.cyF.setDefaultResource(d.g.transparent_bg);
        this.cyF.setDefaultErrorResource(d.g.img_default_100);
        this.cyF.setSupportNoImage(true);
        this.cyF.setDrawBorder(true);
        this.cyF.setBorderWidth(getResources().getDimensionPixelSize(d.f.ds1));
        this.cyF.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.cyL = k.g(this.mContext, d.f.ds40);
        setBlueHeight(this.cyL);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.cyF.setPageId(bdUniqueId);
    }

    public void au(int i, int i2) {
        ViewGroup.LayoutParams layoutParams = this.cyM.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i2;
    }

    public void setGrade(Drawable drawable) {
        if (drawable != null && this.cyG != null) {
            this.cyG.setImageDrawable(drawable);
        }
    }

    public void setBlueHeight(int i) {
        this.cyL = i;
        if (this.cyH != null) {
            this.cyH.getLayoutParams().height = i;
        }
        if (this.cyJ != null) {
            this.cyJ.getLayoutParams().height = i;
        }
        if (this.cyK != null) {
            this.cyK.getLayoutParams().height = i;
        }
    }

    public void setGradeViewLeftMargin(int i) {
        if (i >= 0 && (this.cyG.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            ((ViewGroup.MarginLayoutParams) this.cyG.getLayoutParams()).leftMargin = i;
        }
    }

    public void a(int i, String str, Boolean bool, String str2, long j, long j2) {
        this.cyF.c(str, bool.booleanValue() ? 13 : 14, false);
        double d = 0.0d;
        if (j2 > 0) {
            d = (j * 1.0d) / j2;
        }
        if (d > 0.0d && d <= 1.0d) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) (d * k.g(this.mContext, d.f.ds220)), this.cyL);
            layoutParams.gravity = 80;
            this.cyI.setLayoutParams(layoutParams);
        } else {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(0, this.cyL);
            layoutParams2.gravity = 80;
            this.cyI.setLayoutParams(layoutParams2);
        }
        if (str2 == null) {
            str2 = "";
        }
        this.cyJ.setText(str2);
        this.cyK.setText(al.u(j));
    }

    public void onChangeSkinType(int i) {
        if (this.cyE != i) {
            this.cyE = i;
            this.cyF.setBorderColor(ai.getColor(d.e.common_color_10043));
            this.cyF.setDefaultBg(ai.getDrawable(d.e.common_color_10220));
            ai.j(this.cyM, d.g.pic_triangle_white_grade);
            ai.k(this.cyH, d.e.common_color_10175);
            ai.k(this.cyI, d.e.common_color_10259);
            ai.i(this.cyJ, d.e.cp_cont_g);
            ai.i(this.cyK, d.e.cp_cont_g);
        }
    }
}
