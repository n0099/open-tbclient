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
    private int aSe;
    private TbImageView dYF;
    private ImageView dYG;
    private View dYH;
    private View dYI;
    private TextView dYJ;
    private TextView dYK;
    int dYL;
    private View dYM;
    private Context mContext;

    public FrsPicVotePhotoFrame(Context context) {
        super(context);
        this.aSe = 3;
        this.mContext = context;
        init();
    }

    public FrsPicVotePhotoFrame(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aSe = 3;
        this.mContext = context;
        init();
    }

    private void init() {
        LayoutInflater.from(this.mContext).inflate(d.h.frs_pic_vote_photo_frame, (ViewGroup) this, true);
        this.dYF = (TbImageView) findViewById(d.g.frs_pic_vote_photo);
        this.dYG = (ImageView) findViewById(d.g.frs_pic_vote_grade);
        this.dYJ = (TextView) findViewById(d.g.frs_pic_vote_detail_name);
        this.dYK = (TextView) findViewById(d.g.frs_pic_vote_detail_num);
        this.dYI = findViewById(d.g.frs_pic_vote_detail_persontage_blue);
        this.dYH = findViewById(d.g.frs_pic_vote_detail_layout);
        this.dYM = findViewById(d.g.frs_pic_vote_white_triangle);
        this.dYF.setDefaultResource(d.f.transparent_bg);
        this.dYF.setDefaultErrorResource(d.f.img_default_100);
        this.dYF.setSupportNoImage(true);
        this.dYF.setDrawBorder(true);
        this.dYF.setBorderWidth(getResources().getDimensionPixelSize(d.e.ds1));
        this.dYF.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.dYL = l.t(this.mContext, d.e.ds40);
        setBlueHeight(this.dYL);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.dYF.setPageId(bdUniqueId);
    }

    public void bJ(int i, int i2) {
        ViewGroup.LayoutParams layoutParams = this.dYM.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i2;
    }

    public void setGrade(Drawable drawable) {
        if (drawable != null && this.dYG != null) {
            this.dYG.setImageDrawable(drawable);
        }
    }

    public void setBlueHeight(int i) {
        this.dYL = i;
        if (this.dYH != null) {
            this.dYH.getLayoutParams().height = i;
        }
        if (this.dYJ != null) {
            this.dYJ.getLayoutParams().height = i;
        }
        if (this.dYK != null) {
            this.dYK.getLayoutParams().height = i;
        }
    }

    public void setGradeViewLeftMargin(int i) {
        if (i >= 0 && (this.dYG.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            ((ViewGroup.MarginLayoutParams) this.dYG.getLayoutParams()).leftMargin = i;
        }
    }

    public void a(int i, String str, Boolean bool, String str2, long j, long j2) {
        this.dYF.startLoad(str, bool.booleanValue() ? 13 : 14, false);
        double d = 0.0d;
        if (j2 > 0) {
            d = (j * 1.0d) / j2;
        }
        if (d > 0.0d && d <= 1.0d) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) (d * l.t(this.mContext, d.e.ds220)), this.dYL);
            layoutParams.gravity = 80;
            this.dYI.setLayoutParams(layoutParams);
        } else {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(0, this.dYL);
            layoutParams2.gravity = 80;
            this.dYI.setLayoutParams(layoutParams2);
        }
        if (str2 == null) {
            str2 = "";
        }
        this.dYJ.setText(str2);
        this.dYK.setText(am.C(j));
    }

    public void onChangeSkinType(int i) {
        if (this.aSe != i) {
            this.aSe = i;
            this.dYF.setBorderColor(aj.getColor(d.C0141d.common_color_10043));
            this.dYF.setDefaultBg(aj.getDrawable(d.C0141d.common_color_10220));
            aj.s(this.dYM, d.f.pic_triangle_white_grade);
            aj.t(this.dYH, d.C0141d.common_color_10175);
            aj.t(this.dYI, d.C0141d.common_color_10259);
            aj.r(this.dYJ, d.C0141d.cp_cont_g);
            aj.r(this.dYK, d.C0141d.cp_cont_g);
        }
    }
}
