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
    private int cJK;
    private TbImageView cJL;
    private ImageView cJM;
    private View cJN;
    private View cJO;
    private TextView cJP;
    private TextView cJQ;
    int cJR;
    private View cJS;
    private Context mContext;

    public FrsPicVotePhotoFrame(Context context) {
        super(context);
        this.cJK = 3;
        this.mContext = context;
        init();
    }

    public FrsPicVotePhotoFrame(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cJK = 3;
        this.mContext = context;
        init();
    }

    private void init() {
        LayoutInflater.from(this.mContext).inflate(d.j.frs_pic_vote_photo_frame, (ViewGroup) this, true);
        this.cJL = (TbImageView) findViewById(d.h.frs_pic_vote_photo);
        this.cJM = (ImageView) findViewById(d.h.frs_pic_vote_grade);
        this.cJP = (TextView) findViewById(d.h.frs_pic_vote_detail_name);
        this.cJQ = (TextView) findViewById(d.h.frs_pic_vote_detail_num);
        this.cJO = findViewById(d.h.frs_pic_vote_detail_persontage_blue);
        this.cJN = findViewById(d.h.frs_pic_vote_detail_layout);
        this.cJS = findViewById(d.h.frs_pic_vote_white_triangle);
        this.cJL.setDefaultResource(d.g.transparent_bg);
        this.cJL.setDefaultErrorResource(d.g.img_default_100);
        this.cJL.setSupportNoImage(true);
        this.cJL.setDrawBorder(true);
        this.cJL.setBorderWidth(getResources().getDimensionPixelSize(d.f.ds1));
        this.cJL.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.cJR = l.f(this.mContext, d.f.ds40);
        setBlueHeight(this.cJR);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.cJL.setPageId(bdUniqueId);
    }

    public void aL(int i, int i2) {
        ViewGroup.LayoutParams layoutParams = this.cJS.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i2;
    }

    public void setGrade(Drawable drawable) {
        if (drawable != null && this.cJM != null) {
            this.cJM.setImageDrawable(drawable);
        }
    }

    public void setBlueHeight(int i) {
        this.cJR = i;
        if (this.cJN != null) {
            this.cJN.getLayoutParams().height = i;
        }
        if (this.cJP != null) {
            this.cJP.getLayoutParams().height = i;
        }
        if (this.cJQ != null) {
            this.cJQ.getLayoutParams().height = i;
        }
    }

    public void setGradeViewLeftMargin(int i) {
        if (i >= 0 && (this.cJM.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            ((ViewGroup.MarginLayoutParams) this.cJM.getLayoutParams()).leftMargin = i;
        }
    }

    public void a(int i, String str, Boolean bool, String str2, long j, long j2) {
        this.cJL.c(str, bool.booleanValue() ? 13 : 14, false);
        double d = 0.0d;
        if (j2 > 0) {
            d = (j * 1.0d) / j2;
        }
        if (d > 0.0d && d <= 1.0d) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) (d * l.f(this.mContext, d.f.ds220)), this.cJR);
            layoutParams.gravity = 80;
            this.cJO.setLayoutParams(layoutParams);
        } else {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(0, this.cJR);
            layoutParams2.gravity = 80;
            this.cJO.setLayoutParams(layoutParams2);
        }
        if (str2 == null) {
            str2 = "";
        }
        this.cJP.setText(str2);
        this.cJQ.setText(am.u(j));
    }

    public void onChangeSkinType(int i) {
        if (this.cJK != i) {
            this.cJK = i;
            this.cJL.setBorderColor(aj.getColor(d.e.common_color_10043));
            this.cJL.setDefaultBg(aj.getDrawable(d.e.common_color_10220));
            aj.j(this.cJS, d.g.pic_triangle_white_grade);
            aj.k(this.cJN, d.e.common_color_10175);
            aj.k(this.cJO, d.e.common_color_10259);
            aj.i(this.cJP, d.e.cp_cont_g);
            aj.i(this.cJQ, d.e.cp_cont_g);
        }
    }
}
