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
    private int aSp;
    private TbImageView dYR;
    private ImageView dYS;
    private View dYT;
    private View dYU;
    private TextView dYV;
    private TextView dYW;
    int dYX;
    private View dYY;
    private Context mContext;

    public FrsPicVotePhotoFrame(Context context) {
        super(context);
        this.aSp = 3;
        this.mContext = context;
        init();
    }

    public FrsPicVotePhotoFrame(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aSp = 3;
        this.mContext = context;
        init();
    }

    private void init() {
        LayoutInflater.from(this.mContext).inflate(d.h.frs_pic_vote_photo_frame, (ViewGroup) this, true);
        this.dYR = (TbImageView) findViewById(d.g.frs_pic_vote_photo);
        this.dYS = (ImageView) findViewById(d.g.frs_pic_vote_grade);
        this.dYV = (TextView) findViewById(d.g.frs_pic_vote_detail_name);
        this.dYW = (TextView) findViewById(d.g.frs_pic_vote_detail_num);
        this.dYU = findViewById(d.g.frs_pic_vote_detail_persontage_blue);
        this.dYT = findViewById(d.g.frs_pic_vote_detail_layout);
        this.dYY = findViewById(d.g.frs_pic_vote_white_triangle);
        this.dYR.setDefaultResource(d.f.transparent_bg);
        this.dYR.setDefaultErrorResource(d.f.img_default_100);
        this.dYR.setSupportNoImage(true);
        this.dYR.setDrawBorder(true);
        this.dYR.setBorderWidth(getResources().getDimensionPixelSize(d.e.ds1));
        this.dYR.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.dYX = l.t(this.mContext, d.e.ds40);
        setBlueHeight(this.dYX);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.dYR.setPageId(bdUniqueId);
    }

    public void bJ(int i, int i2) {
        ViewGroup.LayoutParams layoutParams = this.dYY.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i2;
    }

    public void setGrade(Drawable drawable) {
        if (drawable != null && this.dYS != null) {
            this.dYS.setImageDrawable(drawable);
        }
    }

    public void setBlueHeight(int i) {
        this.dYX = i;
        if (this.dYT != null) {
            this.dYT.getLayoutParams().height = i;
        }
        if (this.dYV != null) {
            this.dYV.getLayoutParams().height = i;
        }
        if (this.dYW != null) {
            this.dYW.getLayoutParams().height = i;
        }
    }

    public void setGradeViewLeftMargin(int i) {
        if (i >= 0 && (this.dYS.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            ((ViewGroup.MarginLayoutParams) this.dYS.getLayoutParams()).leftMargin = i;
        }
    }

    public void a(int i, String str, Boolean bool, String str2, long j, long j2) {
        this.dYR.startLoad(str, bool.booleanValue() ? 13 : 14, false);
        double d = 0.0d;
        if (j2 > 0) {
            d = (j * 1.0d) / j2;
        }
        if (d > 0.0d && d <= 1.0d) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) (d * l.t(this.mContext, d.e.ds220)), this.dYX);
            layoutParams.gravity = 80;
            this.dYU.setLayoutParams(layoutParams);
        } else {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(0, this.dYX);
            layoutParams2.gravity = 80;
            this.dYU.setLayoutParams(layoutParams2);
        }
        if (str2 == null) {
            str2 = "";
        }
        this.dYV.setText(str2);
        this.dYW.setText(am.C(j));
    }

    public void onChangeSkinType(int i) {
        if (this.aSp != i) {
            this.aSp = i;
            this.dYR.setBorderColor(aj.getColor(d.C0140d.common_color_10043));
            this.dYR.setDefaultBg(aj.getDrawable(d.C0140d.common_color_10220));
            aj.s(this.dYY, d.f.pic_triangle_white_grade);
            aj.t(this.dYT, d.C0140d.common_color_10175);
            aj.t(this.dYU, d.C0140d.common_color_10259);
            aj.r(this.dYV, d.C0140d.cp_cont_g);
            aj.r(this.dYW, d.C0140d.cp_cont_g);
        }
    }
}
