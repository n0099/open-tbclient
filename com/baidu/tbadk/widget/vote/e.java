package com.baidu.tbadk.widget.vote;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class e extends FrameLayout {
    private ProgressBar aJD;
    private com.baidu.tbadk.widget.vote.a aJP;
    private TbImageView aJQ;
    private TextView aJR;
    private TextView aJS;
    private TextView aJT;
    private ImageView aJU;
    private View aJV;
    private a aJW;
    private View.OnClickListener aJX;
    private boolean isSelected;
    private int position;

    /* loaded from: classes.dex */
    public interface a {
        void b(com.baidu.tbadk.widget.vote.a aVar, int i, boolean z);
    }

    @Override // android.view.View
    public boolean isSelected() {
        return this.isSelected;
    }

    public e(Context context) {
        super(context);
        this.isSelected = false;
        this.aJX = new f(this);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(t.h.vote_selected_pic_item, this);
        this.aJQ = (TbImageView) findViewById(t.g.vote_photo_image);
        this.aJD = (ProgressBar) findViewById(t.g.vote_photo_progress);
        this.aJR = (TextView) findViewById(t.g.vote_photo_number);
        this.aJS = (TextView) findViewById(t.g.vote_photo_percent);
        this.aJT = (TextView) findViewById(t.g.vote_photo_name);
        this.aJU = (ImageView) findViewById(t.g.vote_photo_check_image);
        this.aJV = findViewById(t.g.vote_photo_frame);
        this.aJQ.setDrawBorder(true);
        this.aJQ.setBorderColor(at.getColor(t.d.black_alpha10));
        this.aJQ.setBorderWidth(getResources().getDimensionPixelSize(t.e.ds1));
        setOnClickListener(this.aJX);
        onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
    }

    @Override // android.view.View
    public void setSelected(boolean z) {
        this.isSelected = z;
        this.aJV.setVisibility(z ? 0 : 8);
        if (z) {
            at.c(this.aJU, t.f.btn_choose_photo_s);
        } else {
            at.c(this.aJU, t.f.btn_choose_photo_n);
        }
    }

    public void setOnItemCheckChangeListener(a aVar) {
        this.aJW = aVar;
    }

    public void a(com.baidu.tbadk.widget.vote.a aVar, int i, int i2, boolean z) {
        if (aVar != null) {
            this.isSelected = z;
            this.aJP = aVar;
            this.position = i;
            if (StringUtils.isNull(aVar.Je())) {
                this.aJT.setVisibility(4);
                this.aJT.setText((CharSequence) null);
            } else {
                this.aJT.setVisibility(0);
                this.aJT.setText(UtilHelper.getFixedText(aVar.Je(), 10, false));
            }
            if (i2 == 2) {
                setOnClickListener(null);
                b(aVar);
            } else if (i2 == 1 || i2 == 3) {
                setOnClickListener(this.aJX);
                bP(z);
            }
            this.aJV.setVisibility(z ? 0 : 8);
            this.aJQ.c(aVar.Jj(), 17, false);
        }
    }

    public void setNameVisibility(int i) {
        this.aJT.setVisibility(i);
    }

    private void bP(boolean z) {
        setProgressGroupVisible(false);
        this.aJU.setVisibility(0);
        if (z) {
            at.c(this.aJU, t.f.vote_text_check_box);
        } else {
            at.c(this.aJU, t.f.btn_choose_photo_n);
        }
    }

    private void b(com.baidu.tbadk.widget.vote.a aVar) {
        setProgressGroupVisible(true);
        this.aJU.setVisibility(8);
        if (aVar != null) {
            if (StringUtils.isNull(aVar.Jf())) {
                this.aJR.setVisibility(8);
                this.aJR.setText((CharSequence) null);
            } else {
                this.aJR.setVisibility(0);
                this.aJR.setText(aVar.Jf());
            }
            if (StringUtils.isNull(aVar.Jg())) {
                this.aJS.setVisibility(8);
                this.aJS.setText((CharSequence) null);
                return;
            }
            this.aJS.setVisibility(0);
            this.aJS.setText(aVar.Jg());
        }
    }

    private void setProgressGroupVisible(boolean z) {
        if (z) {
            this.aJR.setVisibility(0);
            this.aJS.setVisibility(0);
            this.aJD.setVisibility(0);
            return;
        }
        this.aJR.setVisibility(8);
        this.aJS.setVisibility(8);
        this.aJD.setVisibility(8);
    }

    public void setProgress(float f) {
        if (f >= 0.0f && this.aJP != null) {
            int Ji = (int) (this.aJP.Ji() * f);
            if (this.isSelected) {
                this.aJD.setProgress(Ji);
                this.aJD.setSecondaryProgress(0);
                return;
            }
            this.aJD.setProgress(0);
            this.aJD.setSecondaryProgress(Ji);
        }
    }

    public void onChangeSkinType(int i) {
        at.a(this.aJT, t.d.cp_cont_b, 1, i);
        at.a(this.aJR, t.d.cp_cont_g, 1, i);
        at.a(this.aJS, t.d.cp_cont_g, 1, i);
        this.aJD.setProgressDrawable(at.o(i, t.f.vote_photo_progress_drawable));
        if (this.isSelected) {
            at.c(this.aJU, t.f.btn_choose_photo_s);
        } else {
            at.c(this.aJU, t.f.btn_choose_photo_n);
        }
        at.c(this.aJV, t.f.vote_photo_frame, i);
    }
}
