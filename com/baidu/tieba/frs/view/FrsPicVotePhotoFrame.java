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
    private int bkI;
    private TbImageView bkJ;
    private View bkK;
    private View bkL;
    private View bkM;
    private TextView bkN;
    private TextView bkO;
    int bkP;
    private View bkQ;
    private Context mContext;

    public FrsPicVotePhotoFrame(Context context) {
        super(context);
        this.bkI = 3;
        this.mContext = context;
        init();
    }

    public FrsPicVotePhotoFrame(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bkI = 3;
        this.mContext = context;
        init();
    }

    private void init() {
        LayoutInflater.from(this.mContext).inflate(n.g.frs_pic_vote_photo_frame, (ViewGroup) this, true);
        this.bkP = com.baidu.adp.lib.util.k.d(this.mContext, n.d.ds40);
        this.bkJ = (TbImageView) findViewById(n.f.frs_pic_vote_photo);
        this.bkK = findViewById(n.f.frs_pic_vote_grade);
        this.bkN = (TextView) findViewById(n.f.frs_pic_vote_detail_name);
        this.bkO = (TextView) findViewById(n.f.frs_pic_vote_detail_num);
        this.bkM = findViewById(n.f.frs_pic_vote_detail_persontage_blue);
        this.bkL = findViewById(n.f.frs_pic_vote_detail_layout);
        this.bkQ = findViewById(n.f.frs_pic_vote_white_triangle);
        this.bkJ.setDefaultResource(n.e.img_default_100);
        this.bkJ.setSupportNoImage(true);
        this.bkJ.setDrawBorder(true);
        this.bkJ.setBorderWidth(getResources().getDimensionPixelSize(n.d.ds1));
        this.bkJ.setScaleType(ImageView.ScaleType.CENTER_CROP);
    }

    public void setGrade(Drawable drawable) {
        if (drawable != null && this.bkK != null) {
            this.bkK.setBackgroundDrawable(drawable);
        }
    }

    public void a(int i, String str, Boolean bool, String str2, long j, long j2) {
        this.bkJ.d(str, bool.booleanValue() ? 13 : 14, false);
        double d = 0.0d;
        if (j2 > 0) {
            d = (j * 1.0d) / j2;
        }
        if (d > 0.0d && d <= 1.0d) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) (d * com.baidu.adp.lib.util.k.d(this.mContext, n.d.ds220)), this.bkP);
            layoutParams.gravity = 80;
            this.bkM.setLayoutParams(layoutParams);
        } else {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(0, this.bkP);
            layoutParams2.gravity = 80;
            this.bkM.setLayoutParams(layoutParams2);
        }
        if (str2 == null) {
            str2 = "";
        }
        this.bkN.setText(str2);
        this.bkO.setText(ax.v(j));
    }

    public void onChangeSkinType(int i) {
        if (this.bkI != i) {
            this.bkI = i;
            this.bkJ.setBorderColor(as.getColor(n.c.black_alpha10));
            this.bkJ.setDefaultBg(as.getDrawable(n.c.pb_default_image_bg));
            as.i(this.bkQ, n.e.pic_triangle_white_grade);
            as.j(this.bkL, n.c.black_alpha70);
            as.j(this.bkM, n.c.cp_link_tip_a_alpha70);
            as.h((View) this.bkN, n.c.cp_cont_g);
            as.h((View) this.bkO, n.c.cp_cont_g);
        }
    }
}
