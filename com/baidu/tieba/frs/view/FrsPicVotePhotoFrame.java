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
/* loaded from: classes2.dex */
public class FrsPicVotePhotoFrame extends FrameLayout {
    private int dPT;
    private TbImageView dPU;
    private ImageView dPV;
    private View dPW;
    private View dPX;
    private TextView dPY;
    private TextView dPZ;
    int dQa;
    private View dQb;
    private Context mContext;

    public FrsPicVotePhotoFrame(Context context) {
        super(context);
        this.dPT = 3;
        this.mContext = context;
        init();
    }

    public FrsPicVotePhotoFrame(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dPT = 3;
        this.mContext = context;
        init();
    }

    private void init() {
        LayoutInflater.from(this.mContext).inflate(d.h.frs_pic_vote_photo_frame, (ViewGroup) this, true);
        this.dPU = (TbImageView) findViewById(d.g.frs_pic_vote_photo);
        this.dPV = (ImageView) findViewById(d.g.frs_pic_vote_grade);
        this.dPY = (TextView) findViewById(d.g.frs_pic_vote_detail_name);
        this.dPZ = (TextView) findViewById(d.g.frs_pic_vote_detail_num);
        this.dPX = findViewById(d.g.frs_pic_vote_detail_persontage_blue);
        this.dPW = findViewById(d.g.frs_pic_vote_detail_layout);
        this.dQb = findViewById(d.g.frs_pic_vote_white_triangle);
        this.dPU.setDefaultResource(d.f.transparent_bg);
        this.dPU.setDefaultErrorResource(d.f.img_default_100);
        this.dPU.setSupportNoImage(true);
        this.dPU.setDrawBorder(true);
        this.dPU.setBorderWidth(getResources().getDimensionPixelSize(d.e.ds1));
        this.dPU.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.dQa = l.s(this.mContext, d.e.ds40);
        setBlueHeight(this.dQa);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.dPU.setPageId(bdUniqueId);
    }

    public void bL(int i, int i2) {
        ViewGroup.LayoutParams layoutParams = this.dQb.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i2;
    }

    public void setGrade(Drawable drawable) {
        if (drawable != null && this.dPV != null) {
            this.dPV.setImageDrawable(drawable);
        }
    }

    public void setBlueHeight(int i) {
        this.dQa = i;
        if (this.dPW != null) {
            this.dPW.getLayoutParams().height = i;
        }
        if (this.dPY != null) {
            this.dPY.getLayoutParams().height = i;
        }
        if (this.dPZ != null) {
            this.dPZ.getLayoutParams().height = i;
        }
    }

    public void setGradeViewLeftMargin(int i) {
        if (i >= 0 && (this.dPV.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            ((ViewGroup.MarginLayoutParams) this.dPV.getLayoutParams()).leftMargin = i;
        }
    }

    public void a(int i, String str, Boolean bool, String str2, long j, long j2) {
        this.dPU.startLoad(str, bool.booleanValue() ? 13 : 14, false);
        double d = 0.0d;
        if (j2 > 0) {
            d = (j * 1.0d) / j2;
        }
        if (d > 0.0d && d <= 1.0d) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) (d * l.s(this.mContext, d.e.ds220)), this.dQa);
            layoutParams.gravity = 80;
            this.dPX.setLayoutParams(layoutParams);
        } else {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(0, this.dQa);
            layoutParams2.gravity = 80;
            this.dPX.setLayoutParams(layoutParams2);
        }
        if (str2 == null) {
            str2 = "";
        }
        this.dPY.setText(str2);
        this.dPZ.setText(am.C(j));
    }

    public void onChangeSkinType(int i) {
        if (this.dPT != i) {
            this.dPT = i;
            this.dPU.setBorderColor(aj.getColor(d.C0108d.common_color_10043));
            this.dPU.setDefaultBg(aj.getDrawable(d.C0108d.common_color_10220));
            aj.s(this.dQb, d.f.pic_triangle_white_grade);
            aj.t(this.dPW, d.C0108d.common_color_10175);
            aj.t(this.dPX, d.C0108d.common_color_10259);
            aj.r(this.dPY, d.C0108d.cp_cont_g);
            aj.r(this.dPZ, d.C0108d.cp_cont_g);
        }
    }
}
