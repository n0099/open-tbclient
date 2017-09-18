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
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class FrsPicVotePhotoFrame extends FrameLayout {
    private int cJg;
    private TbImageView cJh;
    private ImageView cJi;
    private View cJj;
    private View cJk;
    private TextView cJl;
    private TextView cJm;
    int cJn;
    private View cJo;
    private Context mContext;

    public FrsPicVotePhotoFrame(Context context) {
        super(context);
        this.cJg = 3;
        this.mContext = context;
        init();
    }

    public FrsPicVotePhotoFrame(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cJg = 3;
        this.mContext = context;
        init();
    }

    private void init() {
        LayoutInflater.from(this.mContext).inflate(d.j.frs_pic_vote_photo_frame, (ViewGroup) this, true);
        this.cJh = (TbImageView) findViewById(d.h.frs_pic_vote_photo);
        this.cJi = (ImageView) findViewById(d.h.frs_pic_vote_grade);
        this.cJl = (TextView) findViewById(d.h.frs_pic_vote_detail_name);
        this.cJm = (TextView) findViewById(d.h.frs_pic_vote_detail_num);
        this.cJk = findViewById(d.h.frs_pic_vote_detail_persontage_blue);
        this.cJj = findViewById(d.h.frs_pic_vote_detail_layout);
        this.cJo = findViewById(d.h.frs_pic_vote_white_triangle);
        this.cJh.setDefaultResource(d.g.transparent_bg);
        this.cJh.setDefaultErrorResource(d.g.img_default_100);
        this.cJh.setSupportNoImage(true);
        this.cJh.setDrawBorder(true);
        this.cJh.setBorderWidth(getResources().getDimensionPixelSize(d.f.ds1));
        this.cJh.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.cJn = k.f(this.mContext, d.f.ds40);
        setBlueHeight(this.cJn);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.cJh.setPageId(bdUniqueId);
    }

    public void aG(int i, int i2) {
        ViewGroup.LayoutParams layoutParams = this.cJo.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i2;
    }

    public void setGrade(Drawable drawable) {
        if (drawable != null && this.cJi != null) {
            this.cJi.setImageDrawable(drawable);
        }
    }

    public void setBlueHeight(int i) {
        this.cJn = i;
        if (this.cJj != null) {
            this.cJj.getLayoutParams().height = i;
        }
        if (this.cJl != null) {
            this.cJl.getLayoutParams().height = i;
        }
        if (this.cJm != null) {
            this.cJm.getLayoutParams().height = i;
        }
    }

    public void setGradeViewLeftMargin(int i) {
        if (i >= 0 && (this.cJi.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            ((ViewGroup.MarginLayoutParams) this.cJi.getLayoutParams()).leftMargin = i;
        }
    }

    public void a(int i, String str, Boolean bool, String str2, long j, long j2) {
        this.cJh.c(str, bool.booleanValue() ? 13 : 14, false);
        double d = 0.0d;
        if (j2 > 0) {
            d = (j * 1.0d) / j2;
        }
        if (d > 0.0d && d <= 1.0d) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) (d * k.f(this.mContext, d.f.ds220)), this.cJn);
            layoutParams.gravity = 80;
            this.cJk.setLayoutParams(layoutParams);
        } else {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(0, this.cJn);
            layoutParams2.gravity = 80;
            this.cJk.setLayoutParams(layoutParams2);
        }
        if (str2 == null) {
            str2 = "";
        }
        this.cJl.setText(str2);
        this.cJm.setText(am.u(j));
    }

    public void onChangeSkinType(int i) {
        if (this.cJg != i) {
            this.cJg = i;
            this.cJh.setBorderColor(aj.getColor(d.e.common_color_10043));
            this.cJh.setDefaultBg(aj.getDrawable(d.e.common_color_10220));
            aj.j(this.cJo, d.g.pic_triangle_white_grade);
            aj.k(this.cJj, d.e.common_color_10175);
            aj.k(this.cJk, d.e.common_color_10259);
            aj.i(this.cJl, d.e.cp_cont_g);
            aj.i(this.cJm, d.e.cp_cont_g);
        }
    }
}
