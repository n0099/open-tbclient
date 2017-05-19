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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class FrsPicVotePhotoFrame extends FrameLayout {
    private int cdh;
    private TbImageView cdi;
    private ImageView cdj;
    private View cdk;
    private View cdl;
    private TextView cdm;
    private TextView cdn;
    int cdo;
    private View cdp;
    private Context mContext;

    public FrsPicVotePhotoFrame(Context context) {
        super(context);
        this.cdh = 3;
        this.mContext = context;
        init();
    }

    public FrsPicVotePhotoFrame(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cdh = 3;
        this.mContext = context;
        init();
    }

    private void init() {
        LayoutInflater.from(this.mContext).inflate(w.j.frs_pic_vote_photo_frame, (ViewGroup) this, true);
        this.cdi = (TbImageView) findViewById(w.h.frs_pic_vote_photo);
        this.cdj = (ImageView) findViewById(w.h.frs_pic_vote_grade);
        this.cdm = (TextView) findViewById(w.h.frs_pic_vote_detail_name);
        this.cdn = (TextView) findViewById(w.h.frs_pic_vote_detail_num);
        this.cdl = findViewById(w.h.frs_pic_vote_detail_persontage_blue);
        this.cdk = findViewById(w.h.frs_pic_vote_detail_layout);
        this.cdp = findViewById(w.h.frs_pic_vote_white_triangle);
        this.cdi.setDefaultResource(w.g.transparent_bg);
        this.cdi.setDefaultErrorResource(w.g.img_default_100);
        this.cdi.setSupportNoImage(true);
        this.cdi.setDrawBorder(true);
        this.cdi.setBorderWidth(getResources().getDimensionPixelSize(w.f.ds1));
        this.cdi.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.cdo = com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds40);
        setBlueHeight(this.cdo);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.cdi.setPageId(bdUniqueId);
    }

    public void ap(int i, int i2) {
        ViewGroup.LayoutParams layoutParams = this.cdp.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i2;
    }

    public void setGrade(Drawable drawable) {
        if (drawable != null && this.cdj != null) {
            this.cdj.setImageDrawable(drawable);
        }
    }

    public void setBlueHeight(int i) {
        this.cdo = i;
        if (this.cdk != null) {
            this.cdk.getLayoutParams().height = i;
        }
        if (this.cdm != null) {
            this.cdm.getLayoutParams().height = i;
        }
        if (this.cdn != null) {
            this.cdn.getLayoutParams().height = i;
        }
    }

    public void setGradeViewLeftMargin(int i) {
        if (i >= 0 && (this.cdj.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            ((ViewGroup.MarginLayoutParams) this.cdj.getLayoutParams()).leftMargin = i;
        }
    }

    public void a(int i, String str, Boolean bool, String str2, long j, long j2) {
        this.cdi.c(str, bool.booleanValue() ? 13 : 14, false);
        double d = 0.0d;
        if (j2 > 0) {
            d = (j * 1.0d) / j2;
        }
        if (d > 0.0d && d <= 1.0d) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) (d * com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds220)), this.cdo);
            layoutParams.gravity = 80;
            this.cdl.setLayoutParams(layoutParams);
        } else {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(0, this.cdo);
            layoutParams2.gravity = 80;
            this.cdl.setLayoutParams(layoutParams2);
        }
        if (str2 == null) {
            str2 = "";
        }
        this.cdm.setText(str2);
        this.cdn.setText(au.t(j));
    }

    public void onChangeSkinType(int i) {
        if (this.cdh != i) {
            this.cdh = i;
            this.cdi.setBorderColor(aq.getColor(w.e.common_color_10043));
            this.cdi.setDefaultBg(aq.getDrawable(w.e.common_color_10220));
            aq.j(this.cdp, w.g.pic_triangle_white_grade);
            aq.k(this.cdk, w.e.common_color_10175);
            aq.k(this.cdl, w.e.common_color_10259);
            aq.i(this.cdm, w.e.cp_cont_g);
            aq.i(this.cdn, w.e.cp_cont_g);
        }
    }
}
