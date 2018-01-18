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
    private int dUH;
    private TbImageView dUI;
    private ImageView dUJ;
    private View dUK;
    private View dUL;
    private TextView dUM;
    private TextView dUN;
    int dUO;
    private View dUP;
    private Context mContext;

    public FrsPicVotePhotoFrame(Context context) {
        super(context);
        this.dUH = 3;
        this.mContext = context;
        init();
    }

    public FrsPicVotePhotoFrame(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dUH = 3;
        this.mContext = context;
        init();
    }

    private void init() {
        LayoutInflater.from(this.mContext).inflate(d.h.frs_pic_vote_photo_frame, (ViewGroup) this, true);
        this.dUI = (TbImageView) findViewById(d.g.frs_pic_vote_photo);
        this.dUJ = (ImageView) findViewById(d.g.frs_pic_vote_grade);
        this.dUM = (TextView) findViewById(d.g.frs_pic_vote_detail_name);
        this.dUN = (TextView) findViewById(d.g.frs_pic_vote_detail_num);
        this.dUL = findViewById(d.g.frs_pic_vote_detail_persontage_blue);
        this.dUK = findViewById(d.g.frs_pic_vote_detail_layout);
        this.dUP = findViewById(d.g.frs_pic_vote_white_triangle);
        this.dUI.setDefaultResource(d.f.transparent_bg);
        this.dUI.setDefaultErrorResource(d.f.img_default_100);
        this.dUI.setSupportNoImage(true);
        this.dUI.setDrawBorder(true);
        this.dUI.setBorderWidth(getResources().getDimensionPixelSize(d.e.ds1));
        this.dUI.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.dUO = l.s(this.mContext, d.e.ds40);
        setBlueHeight(this.dUO);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.dUI.setPageId(bdUniqueId);
    }

    public void bL(int i, int i2) {
        ViewGroup.LayoutParams layoutParams = this.dUP.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i2;
    }

    public void setGrade(Drawable drawable) {
        if (drawable != null && this.dUJ != null) {
            this.dUJ.setImageDrawable(drawable);
        }
    }

    public void setBlueHeight(int i) {
        this.dUO = i;
        if (this.dUK != null) {
            this.dUK.getLayoutParams().height = i;
        }
        if (this.dUM != null) {
            this.dUM.getLayoutParams().height = i;
        }
        if (this.dUN != null) {
            this.dUN.getLayoutParams().height = i;
        }
    }

    public void setGradeViewLeftMargin(int i) {
        if (i >= 0 && (this.dUJ.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            ((ViewGroup.MarginLayoutParams) this.dUJ.getLayoutParams()).leftMargin = i;
        }
    }

    public void a(int i, String str, Boolean bool, String str2, long j, long j2) {
        this.dUI.startLoad(str, bool.booleanValue() ? 13 : 14, false);
        double d = 0.0d;
        if (j2 > 0) {
            d = (j * 1.0d) / j2;
        }
        if (d > 0.0d && d <= 1.0d) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) (d * l.s(this.mContext, d.e.ds220)), this.dUO);
            layoutParams.gravity = 80;
            this.dUL.setLayoutParams(layoutParams);
        } else {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(0, this.dUO);
            layoutParams2.gravity = 80;
            this.dUL.setLayoutParams(layoutParams2);
        }
        if (str2 == null) {
            str2 = "";
        }
        this.dUM.setText(str2);
        this.dUN.setText(am.C(j));
    }

    public void onChangeSkinType(int i) {
        if (this.dUH != i) {
            this.dUH = i;
            this.dUI.setBorderColor(aj.getColor(d.C0107d.common_color_10043));
            this.dUI.setDefaultBg(aj.getDrawable(d.C0107d.common_color_10220));
            aj.s(this.dUP, d.f.pic_triangle_white_grade);
            aj.t(this.dUK, d.C0107d.common_color_10175);
            aj.t(this.dUL, d.C0107d.common_color_10259);
            aj.r(this.dUM, d.C0107d.cp_cont_g);
            aj.r(this.dUN, d.C0107d.cp_cont_g);
        }
    }
}
