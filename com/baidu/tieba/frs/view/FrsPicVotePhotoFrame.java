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
    private int ddF;
    private TbImageView ddG;
    private ImageView ddH;
    private View ddI;
    private View ddJ;
    private TextView ddK;
    private TextView ddL;
    int ddM;
    private View ddN;
    private Context mContext;

    public FrsPicVotePhotoFrame(Context context) {
        super(context);
        this.ddF = 3;
        this.mContext = context;
        init();
    }

    public FrsPicVotePhotoFrame(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ddF = 3;
        this.mContext = context;
        init();
    }

    private void init() {
        LayoutInflater.from(this.mContext).inflate(d.h.frs_pic_vote_photo_frame, (ViewGroup) this, true);
        this.ddG = (TbImageView) findViewById(d.g.frs_pic_vote_photo);
        this.ddH = (ImageView) findViewById(d.g.frs_pic_vote_grade);
        this.ddK = (TextView) findViewById(d.g.frs_pic_vote_detail_name);
        this.ddL = (TextView) findViewById(d.g.frs_pic_vote_detail_num);
        this.ddJ = findViewById(d.g.frs_pic_vote_detail_persontage_blue);
        this.ddI = findViewById(d.g.frs_pic_vote_detail_layout);
        this.ddN = findViewById(d.g.frs_pic_vote_white_triangle);
        this.ddG.setDefaultResource(d.f.transparent_bg);
        this.ddG.setDefaultErrorResource(d.f.img_default_100);
        this.ddG.setSupportNoImage(true);
        this.ddG.setDrawBorder(true);
        this.ddG.setBorderWidth(getResources().getDimensionPixelSize(d.e.ds1));
        this.ddG.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.ddM = l.f(this.mContext, d.e.ds40);
        setBlueHeight(this.ddM);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.ddG.setPageId(bdUniqueId);
    }

    public void aN(int i, int i2) {
        ViewGroup.LayoutParams layoutParams = this.ddN.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i2;
    }

    public void setGrade(Drawable drawable) {
        if (drawable != null && this.ddH != null) {
            this.ddH.setImageDrawable(drawable);
        }
    }

    public void setBlueHeight(int i) {
        this.ddM = i;
        if (this.ddI != null) {
            this.ddI.getLayoutParams().height = i;
        }
        if (this.ddK != null) {
            this.ddK.getLayoutParams().height = i;
        }
        if (this.ddL != null) {
            this.ddL.getLayoutParams().height = i;
        }
    }

    public void setGradeViewLeftMargin(int i) {
        if (i >= 0 && (this.ddH.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            ((ViewGroup.MarginLayoutParams) this.ddH.getLayoutParams()).leftMargin = i;
        }
    }

    public void a(int i, String str, Boolean bool, String str2, long j, long j2) {
        this.ddG.startLoad(str, bool.booleanValue() ? 13 : 14, false);
        double d = 0.0d;
        if (j2 > 0) {
            d = (j * 1.0d) / j2;
        }
        if (d > 0.0d && d <= 1.0d) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) (d * l.f(this.mContext, d.e.ds220)), this.ddM);
            layoutParams.gravity = 80;
            this.ddJ.setLayoutParams(layoutParams);
        } else {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(0, this.ddM);
            layoutParams2.gravity = 80;
            this.ddJ.setLayoutParams(layoutParams2);
        }
        if (str2 == null) {
            str2 = "";
        }
        this.ddK.setText(str2);
        this.ddL.setText(am.u(j));
    }

    public void onChangeSkinType(int i) {
        if (this.ddF != i) {
            this.ddF = i;
            this.ddG.setBorderColor(aj.getColor(d.C0096d.common_color_10043));
            this.ddG.setDefaultBg(aj.getDrawable(d.C0096d.common_color_10220));
            aj.j(this.ddN, d.f.pic_triangle_white_grade);
            aj.k(this.ddI, d.C0096d.common_color_10175);
            aj.k(this.ddJ, d.C0096d.common_color_10259);
            aj.i(this.ddK, d.C0096d.cp_cont_g);
            aj.i(this.ddL, d.C0096d.cp_cont_g);
        }
    }
}
