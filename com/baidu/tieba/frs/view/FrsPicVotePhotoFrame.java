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
    private ImageView dcA;
    private View dcB;
    private View dcC;
    private TextView dcD;
    private TextView dcE;
    int dcF;
    private View dcG;
    private int dcy;
    private TbImageView dcz;
    private Context mContext;

    public FrsPicVotePhotoFrame(Context context) {
        super(context);
        this.dcy = 3;
        this.mContext = context;
        init();
    }

    public FrsPicVotePhotoFrame(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dcy = 3;
        this.mContext = context;
        init();
    }

    private void init() {
        LayoutInflater.from(this.mContext).inflate(d.h.frs_pic_vote_photo_frame, (ViewGroup) this, true);
        this.dcz = (TbImageView) findViewById(d.g.frs_pic_vote_photo);
        this.dcA = (ImageView) findViewById(d.g.frs_pic_vote_grade);
        this.dcD = (TextView) findViewById(d.g.frs_pic_vote_detail_name);
        this.dcE = (TextView) findViewById(d.g.frs_pic_vote_detail_num);
        this.dcC = findViewById(d.g.frs_pic_vote_detail_persontage_blue);
        this.dcB = findViewById(d.g.frs_pic_vote_detail_layout);
        this.dcG = findViewById(d.g.frs_pic_vote_white_triangle);
        this.dcz.setDefaultResource(d.f.transparent_bg);
        this.dcz.setDefaultErrorResource(d.f.img_default_100);
        this.dcz.setSupportNoImage(true);
        this.dcz.setDrawBorder(true);
        this.dcz.setBorderWidth(getResources().getDimensionPixelSize(d.e.ds1));
        this.dcz.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.dcF = l.f(this.mContext, d.e.ds40);
        setBlueHeight(this.dcF);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.dcz.setPageId(bdUniqueId);
    }

    public void aM(int i, int i2) {
        ViewGroup.LayoutParams layoutParams = this.dcG.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i2;
    }

    public void setGrade(Drawable drawable) {
        if (drawable != null && this.dcA != null) {
            this.dcA.setImageDrawable(drawable);
        }
    }

    public void setBlueHeight(int i) {
        this.dcF = i;
        if (this.dcB != null) {
            this.dcB.getLayoutParams().height = i;
        }
        if (this.dcD != null) {
            this.dcD.getLayoutParams().height = i;
        }
        if (this.dcE != null) {
            this.dcE.getLayoutParams().height = i;
        }
    }

    public void setGradeViewLeftMargin(int i) {
        if (i >= 0 && (this.dcA.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            ((ViewGroup.MarginLayoutParams) this.dcA.getLayoutParams()).leftMargin = i;
        }
    }

    public void a(int i, String str, Boolean bool, String str2, long j, long j2) {
        this.dcz.startLoad(str, bool.booleanValue() ? 13 : 14, false);
        double d = 0.0d;
        if (j2 > 0) {
            d = (j * 1.0d) / j2;
        }
        if (d > 0.0d && d <= 1.0d) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) (d * l.f(this.mContext, d.e.ds220)), this.dcF);
            layoutParams.gravity = 80;
            this.dcC.setLayoutParams(layoutParams);
        } else {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(0, this.dcF);
            layoutParams2.gravity = 80;
            this.dcC.setLayoutParams(layoutParams2);
        }
        if (str2 == null) {
            str2 = "";
        }
        this.dcD.setText(str2);
        this.dcE.setText(am.u(j));
    }

    public void onChangeSkinType(int i) {
        if (this.dcy != i) {
            this.dcy = i;
            this.dcz.setBorderColor(aj.getColor(d.C0082d.common_color_10043));
            this.dcz.setDefaultBg(aj.getDrawable(d.C0082d.common_color_10220));
            aj.j(this.dcG, d.f.pic_triangle_white_grade);
            aj.k(this.dcB, d.C0082d.common_color_10175);
            aj.k(this.dcC, d.C0082d.common_color_10259);
            aj.i(this.dcD, d.C0082d.cp_cont_g);
            aj.i(this.dcE, d.C0082d.cp_cont_g);
        }
    }
}
