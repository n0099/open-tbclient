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
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class FrsPicVotePhotoFrame extends FrameLayout {
    private int cmk;
    private TbImageView cml;
    private ImageView cmm;
    private View cmn;
    private View cmo;
    private TextView cmp;
    private TextView cmq;
    int cmr;
    private View cms;
    private Context mContext;

    public FrsPicVotePhotoFrame(Context context) {
        super(context);
        this.cmk = 3;
        this.mContext = context;
        init();
    }

    public FrsPicVotePhotoFrame(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cmk = 3;
        this.mContext = context;
        init();
    }

    private void init() {
        LayoutInflater.from(this.mContext).inflate(r.h.frs_pic_vote_photo_frame, (ViewGroup) this, true);
        this.cml = (TbImageView) findViewById(r.g.frs_pic_vote_photo);
        this.cmm = (ImageView) findViewById(r.g.frs_pic_vote_grade);
        this.cmp = (TextView) findViewById(r.g.frs_pic_vote_detail_name);
        this.cmq = (TextView) findViewById(r.g.frs_pic_vote_detail_num);
        this.cmo = findViewById(r.g.frs_pic_vote_detail_persontage_blue);
        this.cmn = findViewById(r.g.frs_pic_vote_detail_layout);
        this.cms = findViewById(r.g.frs_pic_vote_white_triangle);
        this.cml.setDefaultResource(r.f.transparent_bg);
        this.cml.setDefaultErrorResource(r.f.img_default_100);
        this.cml.setSupportNoImage(true);
        this.cml.setDrawBorder(true);
        this.cml.setBorderWidth(getResources().getDimensionPixelSize(r.e.ds1));
        this.cml.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.cmr = com.baidu.adp.lib.util.k.e(this.mContext, r.e.ds40);
        setBlueHeight(this.cmr);
    }

    public void ap(int i, int i2) {
        ViewGroup.LayoutParams layoutParams = this.cms.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i2;
    }

    public void setGrade(Drawable drawable) {
        if (drawable != null && this.cmm != null) {
            this.cmm.setImageDrawable(drawable);
        }
    }

    public void setBlueHeight(int i) {
        this.cmr = i;
        if (this.cmn != null) {
            this.cmn.getLayoutParams().height = i;
        }
        if (this.cmp != null) {
            this.cmp.getLayoutParams().height = i;
        }
        if (this.cmq != null) {
            this.cmq.getLayoutParams().height = i;
        }
    }

    public void setGradeViewLeftMargin(int i) {
        if (i >= 0 && (this.cmm.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            ((ViewGroup.MarginLayoutParams) this.cmm.getLayoutParams()).leftMargin = i;
        }
    }

    public void a(int i, String str, Boolean bool, String str2, long j, long j2) {
        this.cml.c(str, bool.booleanValue() ? 13 : 14, false);
        double d = 0.0d;
        if (j2 > 0) {
            d = (j * 1.0d) / j2;
        }
        if (d > 0.0d && d <= 1.0d) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) (d * com.baidu.adp.lib.util.k.e(this.mContext, r.e.ds220)), this.cmr);
            layoutParams.gravity = 80;
            this.cmo.setLayoutParams(layoutParams);
        } else {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(0, this.cmr);
            layoutParams2.gravity = 80;
            this.cmo.setLayoutParams(layoutParams2);
        }
        if (str2 == null) {
            str2 = "";
        }
        this.cmp.setText(str2);
        this.cmq.setText(ax.v(j));
    }

    public void onChangeSkinType(int i) {
        if (this.cmk != i) {
            this.cmk = i;
            this.cml.setBorderColor(at.getColor(r.d.common_color_10043));
            this.cml.setDefaultBg(at.getDrawable(r.d.common_color_10220));
            at.k(this.cms, r.f.pic_triangle_white_grade);
            at.l(this.cmn, r.d.common_color_10175);
            at.l(this.cmo, r.d.common_color_10259);
            at.j((View) this.cmp, r.d.cp_cont_g);
            at.j((View) this.cmq, r.d.cp_cont_g);
        }
    }
}
