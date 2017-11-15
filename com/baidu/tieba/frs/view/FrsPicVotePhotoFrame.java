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
/* loaded from: classes.dex */
public class FrsPicVotePhotoFrame extends FrameLayout {
    private int cTq;
    private TbImageView cTr;
    private ImageView cTs;
    private View cTt;
    private View cTu;
    private TextView cTv;
    private TextView cTw;
    int cTx;
    private View cTy;
    private Context mContext;

    public FrsPicVotePhotoFrame(Context context) {
        super(context);
        this.cTq = 3;
        this.mContext = context;
        init();
    }

    public FrsPicVotePhotoFrame(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cTq = 3;
        this.mContext = context;
        init();
    }

    private void init() {
        LayoutInflater.from(this.mContext).inflate(d.h.frs_pic_vote_photo_frame, (ViewGroup) this, true);
        this.cTr = (TbImageView) findViewById(d.g.frs_pic_vote_photo);
        this.cTs = (ImageView) findViewById(d.g.frs_pic_vote_grade);
        this.cTv = (TextView) findViewById(d.g.frs_pic_vote_detail_name);
        this.cTw = (TextView) findViewById(d.g.frs_pic_vote_detail_num);
        this.cTu = findViewById(d.g.frs_pic_vote_detail_persontage_blue);
        this.cTt = findViewById(d.g.frs_pic_vote_detail_layout);
        this.cTy = findViewById(d.g.frs_pic_vote_white_triangle);
        this.cTr.setDefaultResource(d.f.transparent_bg);
        this.cTr.setDefaultErrorResource(d.f.img_default_100);
        this.cTr.setSupportNoImage(true);
        this.cTr.setDrawBorder(true);
        this.cTr.setBorderWidth(getResources().getDimensionPixelSize(d.e.ds1));
        this.cTr.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.cTx = l.f(this.mContext, d.e.ds40);
        setBlueHeight(this.cTx);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.cTr.setPageId(bdUniqueId);
    }

    public void aM(int i, int i2) {
        ViewGroup.LayoutParams layoutParams = this.cTy.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i2;
    }

    public void setGrade(Drawable drawable) {
        if (drawable != null && this.cTs != null) {
            this.cTs.setImageDrawable(drawable);
        }
    }

    public void setBlueHeight(int i) {
        this.cTx = i;
        if (this.cTt != null) {
            this.cTt.getLayoutParams().height = i;
        }
        if (this.cTv != null) {
            this.cTv.getLayoutParams().height = i;
        }
        if (this.cTw != null) {
            this.cTw.getLayoutParams().height = i;
        }
    }

    public void setGradeViewLeftMargin(int i) {
        if (i >= 0 && (this.cTs.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            ((ViewGroup.MarginLayoutParams) this.cTs.getLayoutParams()).leftMargin = i;
        }
    }

    public void a(int i, String str, Boolean bool, String str2, long j, long j2) {
        this.cTr.startLoad(str, bool.booleanValue() ? 13 : 14, false);
        double d = 0.0d;
        if (j2 > 0) {
            d = (j * 1.0d) / j2;
        }
        if (d > 0.0d && d <= 1.0d) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) (d * l.f(this.mContext, d.e.ds220)), this.cTx);
            layoutParams.gravity = 80;
            this.cTu.setLayoutParams(layoutParams);
        } else {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(0, this.cTx);
            layoutParams2.gravity = 80;
            this.cTu.setLayoutParams(layoutParams2);
        }
        if (str2 == null) {
            str2 = "";
        }
        this.cTv.setText(str2);
        this.cTw.setText(am.u(j));
    }

    public void onChangeSkinType(int i) {
        if (this.cTq != i) {
            this.cTq = i;
            this.cTr.setBorderColor(aj.getColor(d.C0080d.common_color_10043));
            this.cTr.setDefaultBg(aj.getDrawable(d.C0080d.common_color_10220));
            aj.j(this.cTy, d.f.pic_triangle_white_grade);
            aj.k(this.cTt, d.C0080d.common_color_10175);
            aj.k(this.cTu, d.C0080d.common_color_10259);
            aj.i(this.cTv, d.C0080d.cp_cont_g);
            aj.i(this.cTw, d.C0080d.cp_cont_g);
        }
    }
}
