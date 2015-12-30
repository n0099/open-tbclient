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
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class FrsPicVotePhotoFrame extends FrameLayout {
    private TbImageView boA;
    private View boB;
    private View boC;
    private View boD;
    private TextView boE;
    private TextView boF;
    int boG;
    private View boH;
    private int boz;
    private Context mContext;

    public FrsPicVotePhotoFrame(Context context) {
        super(context);
        this.boz = 3;
        this.mContext = context;
        init();
    }

    public FrsPicVotePhotoFrame(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.boz = 3;
        this.mContext = context;
        init();
    }

    private void init() {
        LayoutInflater.from(this.mContext).inflate(n.h.frs_pic_vote_photo_frame, (ViewGroup) this, true);
        this.boG = com.baidu.adp.lib.util.k.d(this.mContext, n.e.ds40);
        this.boA = (TbImageView) findViewById(n.g.frs_pic_vote_photo);
        this.boB = findViewById(n.g.frs_pic_vote_grade);
        this.boE = (TextView) findViewById(n.g.frs_pic_vote_detail_name);
        this.boF = (TextView) findViewById(n.g.frs_pic_vote_detail_num);
        this.boD = findViewById(n.g.frs_pic_vote_detail_persontage_blue);
        this.boC = findViewById(n.g.frs_pic_vote_detail_layout);
        this.boH = findViewById(n.g.frs_pic_vote_white_triangle);
        this.boA.setDefaultResource(n.f.img_default_100);
        this.boA.setSupportNoImage(true);
        this.boA.setDrawBorder(true);
        this.boA.setBorderWidth(getResources().getDimensionPixelSize(n.e.ds1));
        this.boA.setScaleType(ImageView.ScaleType.CENTER_CROP);
    }

    public void setGrade(Drawable drawable) {
        if (drawable != null && this.boB != null) {
            this.boB.setBackgroundDrawable(drawable);
        }
    }

    public void a(int i, String str, Boolean bool, String str2, long j, long j2) {
        this.boA.d(str, bool.booleanValue() ? 13 : 14, false);
        double d = 0.0d;
        if (j2 > 0) {
            d = (j * 1.0d) / j2;
        }
        if (d > 0.0d && d <= 1.0d) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) (d * com.baidu.adp.lib.util.k.d(this.mContext, n.e.ds220)), this.boG);
            layoutParams.gravity = 80;
            this.boD.setLayoutParams(layoutParams);
        } else {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(0, this.boG);
            layoutParams2.gravity = 80;
            this.boD.setLayoutParams(layoutParams2);
        }
        if (str2 == null) {
            str2 = "";
        }
        this.boE.setText(str2);
        this.boF.setText(ax.w(j));
    }

    public void onChangeSkinType(int i) {
        if (this.boz != i) {
            this.boz = i;
            this.boA.setBorderColor(as.getColor(n.d.black_alpha10));
            this.boA.setDefaultBg(as.getDrawable(n.d.pb_default_image_bg));
            as.i(this.boH, n.f.pic_triangle_white_grade);
            as.j(this.boC, n.d.black_alpha70);
            as.j(this.boD, n.d.cp_link_tip_a_alpha70);
            as.h((View) this.boE, n.d.cp_cont_g);
            as.h((View) this.boF, n.d.cp_cont_g);
        }
    }
}
