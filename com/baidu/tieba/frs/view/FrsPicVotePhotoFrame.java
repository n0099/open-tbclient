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
    private int aSg;
    private TbImageView dYW;
    private ImageView dYX;
    private View dYY;
    private View dYZ;
    private TextView dZa;
    private TextView dZb;
    int dZc;
    private View dZd;
    private Context mContext;

    public FrsPicVotePhotoFrame(Context context) {
        super(context);
        this.aSg = 3;
        this.mContext = context;
        init();
    }

    public FrsPicVotePhotoFrame(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aSg = 3;
        this.mContext = context;
        init();
    }

    private void init() {
        LayoutInflater.from(this.mContext).inflate(d.h.frs_pic_vote_photo_frame, (ViewGroup) this, true);
        this.dYW = (TbImageView) findViewById(d.g.frs_pic_vote_photo);
        this.dYX = (ImageView) findViewById(d.g.frs_pic_vote_grade);
        this.dZa = (TextView) findViewById(d.g.frs_pic_vote_detail_name);
        this.dZb = (TextView) findViewById(d.g.frs_pic_vote_detail_num);
        this.dYZ = findViewById(d.g.frs_pic_vote_detail_persontage_blue);
        this.dYY = findViewById(d.g.frs_pic_vote_detail_layout);
        this.dZd = findViewById(d.g.frs_pic_vote_white_triangle);
        this.dYW.setDefaultResource(d.f.transparent_bg);
        this.dYW.setDefaultErrorResource(d.f.img_default_100);
        this.dYW.setSupportNoImage(true);
        this.dYW.setDrawBorder(true);
        this.dYW.setBorderWidth(getResources().getDimensionPixelSize(d.e.ds1));
        this.dYW.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.dZc = l.t(this.mContext, d.e.ds40);
        setBlueHeight(this.dZc);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.dYW.setPageId(bdUniqueId);
    }

    public void bJ(int i, int i2) {
        ViewGroup.LayoutParams layoutParams = this.dZd.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i2;
    }

    public void setGrade(Drawable drawable) {
        if (drawable != null && this.dYX != null) {
            this.dYX.setImageDrawable(drawable);
        }
    }

    public void setBlueHeight(int i) {
        this.dZc = i;
        if (this.dYY != null) {
            this.dYY.getLayoutParams().height = i;
        }
        if (this.dZa != null) {
            this.dZa.getLayoutParams().height = i;
        }
        if (this.dZb != null) {
            this.dZb.getLayoutParams().height = i;
        }
    }

    public void setGradeViewLeftMargin(int i) {
        if (i >= 0 && (this.dYX.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            ((ViewGroup.MarginLayoutParams) this.dYX.getLayoutParams()).leftMargin = i;
        }
    }

    public void a(int i, String str, Boolean bool, String str2, long j, long j2) {
        this.dYW.startLoad(str, bool.booleanValue() ? 13 : 14, false);
        double d = 0.0d;
        if (j2 > 0) {
            d = (j * 1.0d) / j2;
        }
        if (d > 0.0d && d <= 1.0d) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) (d * l.t(this.mContext, d.e.ds220)), this.dZc);
            layoutParams.gravity = 80;
            this.dYZ.setLayoutParams(layoutParams);
        } else {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(0, this.dZc);
            layoutParams2.gravity = 80;
            this.dYZ.setLayoutParams(layoutParams2);
        }
        if (str2 == null) {
            str2 = "";
        }
        this.dZa.setText(str2);
        this.dZb.setText(am.C(j));
    }

    public void onChangeSkinType(int i) {
        if (this.aSg != i) {
            this.aSg = i;
            this.dYW.setBorderColor(aj.getColor(d.C0141d.common_color_10043));
            this.dYW.setDefaultBg(aj.getDrawable(d.C0141d.common_color_10220));
            aj.s(this.dZd, d.f.pic_triangle_white_grade);
            aj.t(this.dYY, d.C0141d.common_color_10175);
            aj.t(this.dYZ, d.C0141d.common_color_10259);
            aj.r(this.dZa, d.C0141d.cp_cont_g);
            aj.r(this.dZb, d.C0141d.cp_cont_g);
        }
    }
}
