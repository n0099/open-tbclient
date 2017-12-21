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
    private int ddJ;
    private TbImageView ddK;
    private ImageView ddL;
    private View ddM;
    private View ddN;
    private TextView ddO;
    private TextView ddP;
    int ddQ;
    private View ddR;
    private Context mContext;

    public FrsPicVotePhotoFrame(Context context) {
        super(context);
        this.ddJ = 3;
        this.mContext = context;
        init();
    }

    public FrsPicVotePhotoFrame(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ddJ = 3;
        this.mContext = context;
        init();
    }

    private void init() {
        LayoutInflater.from(this.mContext).inflate(d.h.frs_pic_vote_photo_frame, (ViewGroup) this, true);
        this.ddK = (TbImageView) findViewById(d.g.frs_pic_vote_photo);
        this.ddL = (ImageView) findViewById(d.g.frs_pic_vote_grade);
        this.ddO = (TextView) findViewById(d.g.frs_pic_vote_detail_name);
        this.ddP = (TextView) findViewById(d.g.frs_pic_vote_detail_num);
        this.ddN = findViewById(d.g.frs_pic_vote_detail_persontage_blue);
        this.ddM = findViewById(d.g.frs_pic_vote_detail_layout);
        this.ddR = findViewById(d.g.frs_pic_vote_white_triangle);
        this.ddK.setDefaultResource(d.f.transparent_bg);
        this.ddK.setDefaultErrorResource(d.f.img_default_100);
        this.ddK.setSupportNoImage(true);
        this.ddK.setDrawBorder(true);
        this.ddK.setBorderWidth(getResources().getDimensionPixelSize(d.e.ds1));
        this.ddK.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.ddQ = l.f(this.mContext, d.e.ds40);
        setBlueHeight(this.ddQ);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.ddK.setPageId(bdUniqueId);
    }

    public void aN(int i, int i2) {
        ViewGroup.LayoutParams layoutParams = this.ddR.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i2;
    }

    public void setGrade(Drawable drawable) {
        if (drawable != null && this.ddL != null) {
            this.ddL.setImageDrawable(drawable);
        }
    }

    public void setBlueHeight(int i) {
        this.ddQ = i;
        if (this.ddM != null) {
            this.ddM.getLayoutParams().height = i;
        }
        if (this.ddO != null) {
            this.ddO.getLayoutParams().height = i;
        }
        if (this.ddP != null) {
            this.ddP.getLayoutParams().height = i;
        }
    }

    public void setGradeViewLeftMargin(int i) {
        if (i >= 0 && (this.ddL.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            ((ViewGroup.MarginLayoutParams) this.ddL.getLayoutParams()).leftMargin = i;
        }
    }

    public void a(int i, String str, Boolean bool, String str2, long j, long j2) {
        this.ddK.startLoad(str, bool.booleanValue() ? 13 : 14, false);
        double d = 0.0d;
        if (j2 > 0) {
            d = (j * 1.0d) / j2;
        }
        if (d > 0.0d && d <= 1.0d) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) (d * l.f(this.mContext, d.e.ds220)), this.ddQ);
            layoutParams.gravity = 80;
            this.ddN.setLayoutParams(layoutParams);
        } else {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(0, this.ddQ);
            layoutParams2.gravity = 80;
            this.ddN.setLayoutParams(layoutParams2);
        }
        if (str2 == null) {
            str2 = "";
        }
        this.ddO.setText(str2);
        this.ddP.setText(am.u(j));
    }

    public void onChangeSkinType(int i) {
        if (this.ddJ != i) {
            this.ddJ = i;
            this.ddK.setBorderColor(aj.getColor(d.C0095d.common_color_10043));
            this.ddK.setDefaultBg(aj.getDrawable(d.C0095d.common_color_10220));
            aj.j(this.ddR, d.f.pic_triangle_white_grade);
            aj.k(this.ddM, d.C0095d.common_color_10175);
            aj.k(this.ddN, d.C0095d.common_color_10259);
            aj.i(this.ddO, d.C0095d.cp_cont_g);
            aj.i(this.ddP, d.C0095d.cp_cont_g);
        }
    }
}
