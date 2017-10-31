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
    private int cSW;
    private TbImageView cSX;
    private ImageView cSY;
    private View cSZ;
    private View cTa;
    private TextView cTb;
    private TextView cTc;
    int cTd;
    private View cTe;
    private Context mContext;

    public FrsPicVotePhotoFrame(Context context) {
        super(context);
        this.cSW = 3;
        this.mContext = context;
        init();
    }

    public FrsPicVotePhotoFrame(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cSW = 3;
        this.mContext = context;
        init();
    }

    private void init() {
        LayoutInflater.from(this.mContext).inflate(d.h.frs_pic_vote_photo_frame, (ViewGroup) this, true);
        this.cSX = (TbImageView) findViewById(d.g.frs_pic_vote_photo);
        this.cSY = (ImageView) findViewById(d.g.frs_pic_vote_grade);
        this.cTb = (TextView) findViewById(d.g.frs_pic_vote_detail_name);
        this.cTc = (TextView) findViewById(d.g.frs_pic_vote_detail_num);
        this.cTa = findViewById(d.g.frs_pic_vote_detail_persontage_blue);
        this.cSZ = findViewById(d.g.frs_pic_vote_detail_layout);
        this.cTe = findViewById(d.g.frs_pic_vote_white_triangle);
        this.cSX.setDefaultResource(d.f.transparent_bg);
        this.cSX.setDefaultErrorResource(d.f.img_default_100);
        this.cSX.setSupportNoImage(true);
        this.cSX.setDrawBorder(true);
        this.cSX.setBorderWidth(getResources().getDimensionPixelSize(d.e.ds1));
        this.cSX.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.cTd = l.f(this.mContext, d.e.ds40);
        setBlueHeight(this.cTd);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.cSX.setPageId(bdUniqueId);
    }

    public void aM(int i, int i2) {
        ViewGroup.LayoutParams layoutParams = this.cTe.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i2;
    }

    public void setGrade(Drawable drawable) {
        if (drawable != null && this.cSY != null) {
            this.cSY.setImageDrawable(drawable);
        }
    }

    public void setBlueHeight(int i) {
        this.cTd = i;
        if (this.cSZ != null) {
            this.cSZ.getLayoutParams().height = i;
        }
        if (this.cTb != null) {
            this.cTb.getLayoutParams().height = i;
        }
        if (this.cTc != null) {
            this.cTc.getLayoutParams().height = i;
        }
    }

    public void setGradeViewLeftMargin(int i) {
        if (i >= 0 && (this.cSY.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            ((ViewGroup.MarginLayoutParams) this.cSY.getLayoutParams()).leftMargin = i;
        }
    }

    public void a(int i, String str, Boolean bool, String str2, long j, long j2) {
        this.cSX.startLoad(str, bool.booleanValue() ? 13 : 14, false);
        double d = 0.0d;
        if (j2 > 0) {
            d = (j * 1.0d) / j2;
        }
        if (d > 0.0d && d <= 1.0d) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) (d * l.f(this.mContext, d.e.ds220)), this.cTd);
            layoutParams.gravity = 80;
            this.cTa.setLayoutParams(layoutParams);
        } else {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(0, this.cTd);
            layoutParams2.gravity = 80;
            this.cTa.setLayoutParams(layoutParams2);
        }
        if (str2 == null) {
            str2 = "";
        }
        this.cTb.setText(str2);
        this.cTc.setText(am.u(j));
    }

    public void onChangeSkinType(int i) {
        if (this.cSW != i) {
            this.cSW = i;
            this.cSX.setBorderColor(aj.getColor(d.C0080d.common_color_10043));
            this.cSX.setDefaultBg(aj.getDrawable(d.C0080d.common_color_10220));
            aj.j(this.cTe, d.f.pic_triangle_white_grade);
            aj.k(this.cSZ, d.C0080d.common_color_10175);
            aj.k(this.cTa, d.C0080d.common_color_10259);
            aj.i(this.cTb, d.C0080d.cp_cont_g);
            aj.i(this.cTc, d.C0080d.cp_cont_g);
        }
    }
}
