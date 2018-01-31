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
    private int dVc;
    private TbImageView dVd;
    private ImageView dVe;
    private View dVf;
    private View dVg;
    private TextView dVh;
    private TextView dVi;
    int dVj;
    private View dVk;
    private Context mContext;

    public FrsPicVotePhotoFrame(Context context) {
        super(context);
        this.dVc = 3;
        this.mContext = context;
        init();
    }

    public FrsPicVotePhotoFrame(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dVc = 3;
        this.mContext = context;
        init();
    }

    private void init() {
        LayoutInflater.from(this.mContext).inflate(d.h.frs_pic_vote_photo_frame, (ViewGroup) this, true);
        this.dVd = (TbImageView) findViewById(d.g.frs_pic_vote_photo);
        this.dVe = (ImageView) findViewById(d.g.frs_pic_vote_grade);
        this.dVh = (TextView) findViewById(d.g.frs_pic_vote_detail_name);
        this.dVi = (TextView) findViewById(d.g.frs_pic_vote_detail_num);
        this.dVg = findViewById(d.g.frs_pic_vote_detail_persontage_blue);
        this.dVf = findViewById(d.g.frs_pic_vote_detail_layout);
        this.dVk = findViewById(d.g.frs_pic_vote_white_triangle);
        this.dVd.setDefaultResource(d.f.transparent_bg);
        this.dVd.setDefaultErrorResource(d.f.img_default_100);
        this.dVd.setSupportNoImage(true);
        this.dVd.setDrawBorder(true);
        this.dVd.setBorderWidth(getResources().getDimensionPixelSize(d.e.ds1));
        this.dVd.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.dVj = l.s(this.mContext, d.e.ds40);
        setBlueHeight(this.dVj);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.dVd.setPageId(bdUniqueId);
    }

    public void bL(int i, int i2) {
        ViewGroup.LayoutParams layoutParams = this.dVk.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i2;
    }

    public void setGrade(Drawable drawable) {
        if (drawable != null && this.dVe != null) {
            this.dVe.setImageDrawable(drawable);
        }
    }

    public void setBlueHeight(int i) {
        this.dVj = i;
        if (this.dVf != null) {
            this.dVf.getLayoutParams().height = i;
        }
        if (this.dVh != null) {
            this.dVh.getLayoutParams().height = i;
        }
        if (this.dVi != null) {
            this.dVi.getLayoutParams().height = i;
        }
    }

    public void setGradeViewLeftMargin(int i) {
        if (i >= 0 && (this.dVe.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            ((ViewGroup.MarginLayoutParams) this.dVe.getLayoutParams()).leftMargin = i;
        }
    }

    public void a(int i, String str, Boolean bool, String str2, long j, long j2) {
        this.dVd.startLoad(str, bool.booleanValue() ? 13 : 14, false);
        double d = 0.0d;
        if (j2 > 0) {
            d = (j * 1.0d) / j2;
        }
        if (d > 0.0d && d <= 1.0d) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) (d * l.s(this.mContext, d.e.ds220)), this.dVj);
            layoutParams.gravity = 80;
            this.dVg.setLayoutParams(layoutParams);
        } else {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(0, this.dVj);
            layoutParams2.gravity = 80;
            this.dVg.setLayoutParams(layoutParams2);
        }
        if (str2 == null) {
            str2 = "";
        }
        this.dVh.setText(str2);
        this.dVi.setText(am.C(j));
    }

    public void onChangeSkinType(int i) {
        if (this.dVc != i) {
            this.dVc = i;
            this.dVd.setBorderColor(aj.getColor(d.C0108d.common_color_10043));
            this.dVd.setDefaultBg(aj.getDrawable(d.C0108d.common_color_10220));
            aj.s(this.dVk, d.f.pic_triangle_white_grade);
            aj.t(this.dVf, d.C0108d.common_color_10175);
            aj.t(this.dVg, d.C0108d.common_color_10259);
            aj.r(this.dVh, d.C0108d.cp_cont_g);
            aj.r(this.dVi, d.C0108d.cp_cont_g);
        }
    }
}
