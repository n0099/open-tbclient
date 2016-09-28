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
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class FrsPicVotePhotoFrame extends FrameLayout {
    private int chc;
    private TbImageView chd;
    private ImageView che;
    private View chf;
    private View chg;
    private TextView chh;
    private TextView chi;
    int chj;
    private View chk;
    private Context mContext;

    public FrsPicVotePhotoFrame(Context context) {
        super(context);
        this.chc = 3;
        this.mContext = context;
        init();
    }

    public FrsPicVotePhotoFrame(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.chc = 3;
        this.mContext = context;
        init();
    }

    private void init() {
        LayoutInflater.from(this.mContext).inflate(r.h.frs_pic_vote_photo_frame, (ViewGroup) this, true);
        this.chd = (TbImageView) findViewById(r.g.frs_pic_vote_photo);
        this.che = (ImageView) findViewById(r.g.frs_pic_vote_grade);
        this.chh = (TextView) findViewById(r.g.frs_pic_vote_detail_name);
        this.chi = (TextView) findViewById(r.g.frs_pic_vote_detail_num);
        this.chg = findViewById(r.g.frs_pic_vote_detail_persontage_blue);
        this.chf = findViewById(r.g.frs_pic_vote_detail_layout);
        this.chk = findViewById(r.g.frs_pic_vote_white_triangle);
        this.chd.setDefaultResource(r.f.transparent_bg);
        this.chd.setDefaultErrorResource(r.f.img_default_100);
        this.chd.setSupportNoImage(true);
        this.chd.setDrawBorder(true);
        this.chd.setBorderWidth(getResources().getDimensionPixelSize(r.e.ds1));
        this.chd.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.chj = com.baidu.adp.lib.util.k.e(this.mContext, r.e.ds40);
        setBlueHeight(this.chj);
    }

    public void ao(int i, int i2) {
        ViewGroup.LayoutParams layoutParams = this.chk.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i2;
    }

    public void setGrade(Drawable drawable) {
        if (drawable != null && this.che != null) {
            this.che.setImageDrawable(drawable);
        }
    }

    public void setBlueHeight(int i) {
        this.chj = i;
        if (this.chf != null) {
            this.chf.getLayoutParams().height = i;
        }
        if (this.chh != null) {
            this.chh.getLayoutParams().height = i;
        }
        if (this.chi != null) {
            this.chi.getLayoutParams().height = i;
        }
    }

    public void setGradeViewLeftMargin(int i) {
        if (i >= 0 && (this.che.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            ((ViewGroup.MarginLayoutParams) this.che.getLayoutParams()).leftMargin = i;
        }
    }

    public void a(int i, String str, Boolean bool, String str2, long j, long j2) {
        this.chd.c(str, bool.booleanValue() ? 13 : 14, false);
        double d = 0.0d;
        if (j2 > 0) {
            d = (j * 1.0d) / j2;
        }
        if (d > 0.0d && d <= 1.0d) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) (d * com.baidu.adp.lib.util.k.e(this.mContext, r.e.ds220)), this.chj);
            layoutParams.gravity = 80;
            this.chg.setLayoutParams(layoutParams);
        } else {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(0, this.chj);
            layoutParams2.gravity = 80;
            this.chg.setLayoutParams(layoutParams2);
        }
        if (str2 == null) {
            str2 = "";
        }
        this.chh.setText(str2);
        this.chi.setText(az.w(j));
    }

    public void onChangeSkinType(int i) {
        if (this.chc != i) {
            this.chc = i;
            this.chd.setBorderColor(av.getColor(r.d.common_color_10043));
            this.chd.setDefaultBg(av.getDrawable(r.d.common_color_10220));
            av.k(this.chk, r.f.pic_triangle_white_grade);
            av.l(this.chf, r.d.common_color_10175);
            av.l(this.chg, r.d.common_color_10259);
            av.j((View) this.chh, r.d.cp_cont_g);
            av.j((View) this.chi, r.d.cp_cont_g);
        }
    }
}
