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
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class FrsPicVotePhotoFrame extends FrameLayout {
    private int che;
    private TbImageView chf;
    private ImageView chg;
    private View chh;
    private View chi;
    private TextView chj;
    private TextView chk;
    int chl;
    private View chm;
    private Context mContext;

    public FrsPicVotePhotoFrame(Context context) {
        super(context);
        this.che = 3;
        this.mContext = context;
        init();
    }

    public FrsPicVotePhotoFrame(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.che = 3;
        this.mContext = context;
        init();
    }

    private void init() {
        LayoutInflater.from(this.mContext).inflate(t.h.frs_pic_vote_photo_frame, (ViewGroup) this, true);
        this.chf = (TbImageView) findViewById(t.g.frs_pic_vote_photo);
        this.chg = (ImageView) findViewById(t.g.frs_pic_vote_grade);
        this.chj = (TextView) findViewById(t.g.frs_pic_vote_detail_name);
        this.chk = (TextView) findViewById(t.g.frs_pic_vote_detail_num);
        this.chi = findViewById(t.g.frs_pic_vote_detail_persontage_blue);
        this.chh = findViewById(t.g.frs_pic_vote_detail_layout);
        this.chm = findViewById(t.g.frs_pic_vote_white_triangle);
        this.chf.setDefaultResource(t.f.transparent_bg);
        this.chf.setDefaultErrorResource(t.f.img_default_100);
        this.chf.setSupportNoImage(true);
        this.chf.setDrawBorder(true);
        this.chf.setBorderWidth(getResources().getDimensionPixelSize(t.e.ds1));
        this.chf.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.chl = com.baidu.adp.lib.util.k.e(this.mContext, t.e.ds40);
        setBlueHeight(this.chl);
    }

    public void an(int i, int i2) {
        ViewGroup.LayoutParams layoutParams = this.chm.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i2;
    }

    public void setGrade(Drawable drawable) {
        if (drawable != null && this.chg != null) {
            this.chg.setImageDrawable(drawable);
        }
    }

    public void setBlueHeight(int i) {
        this.chl = i;
        if (this.chh != null) {
            this.chh.getLayoutParams().height = i;
        }
        if (this.chj != null) {
            this.chj.getLayoutParams().height = i;
        }
        if (this.chk != null) {
            this.chk.getLayoutParams().height = i;
        }
    }

    public void setGradeViewLeftMargin(int i) {
        if (i >= 0 && (this.chg.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            ((ViewGroup.MarginLayoutParams) this.chg.getLayoutParams()).leftMargin = i;
        }
    }

    public void a(int i, String str, Boolean bool, String str2, long j, long j2) {
        this.chf.c(str, bool.booleanValue() ? 13 : 14, false);
        double d = 0.0d;
        if (j2 > 0) {
            d = (j * 1.0d) / j2;
        }
        if (d > 0.0d && d <= 1.0d) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) (d * com.baidu.adp.lib.util.k.e(this.mContext, t.e.ds220)), this.chl);
            layoutParams.gravity = 80;
            this.chi.setLayoutParams(layoutParams);
        } else {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(0, this.chl);
            layoutParams2.gravity = 80;
            this.chi.setLayoutParams(layoutParams2);
        }
        if (str2 == null) {
            str2 = "";
        }
        this.chj.setText(str2);
        this.chk.setText(ba.w(j));
    }

    public void onChangeSkinType(int i) {
        if (this.che != i) {
            this.che = i;
            this.chf.setBorderColor(av.getColor(t.d.common_color_10043));
            this.chf.setDefaultBg(av.getDrawable(t.d.common_color_10220));
            av.k(this.chm, t.f.pic_triangle_white_grade);
            av.l(this.chh, t.d.common_color_10175);
            av.l(this.chi, t.d.common_color_10259);
            av.j((View) this.chj, t.d.cp_cont_g);
            av.j((View) this.chk, t.d.cp_cont_g);
        }
    }
}
