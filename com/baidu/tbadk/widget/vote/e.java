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
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class e extends FrameLayout {
    private ProgressBar aKL;
    private com.baidu.tbadk.widget.vote.a aKZ;
    private TbImageView aLa;
    private TextView aLb;
    private TextView aLc;
    private TextView aLd;
    private ImageView aLe;
    private a aLf;
    private View.OnClickListener aLg;
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
        this.aLg = new f(this);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(r.h.vote_selected_pic_item, this);
        this.aLa = (TbImageView) findViewById(r.g.vote_photo_image);
        this.aKL = (ProgressBar) findViewById(r.g.vote_photo_progress);
        this.aLb = (TextView) findViewById(r.g.vote_photo_number);
        this.aLc = (TextView) findViewById(r.g.vote_photo_percent);
        this.aLd = (TextView) findViewById(r.g.vote_photo_name);
        this.aLe = (ImageView) findViewById(r.g.vote_photo_check_image);
        this.aLa.setDrawBorder(true);
        this.aLa.setBorderColor(at.getColor(r.d.common_color_10043));
        this.aLa.setBorderWidth(getResources().getDimensionPixelSize(r.e.ds1));
        setOnClickListener(this.aLg);
        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
    }

    @Override // android.view.View
    public void setSelected(boolean z) {
        this.isSelected = z;
        if (z) {
            at.c(this.aLe, r.f.chx_pic_add_s);
        } else {
            at.c(this.aLe, r.f.chx_pic_add_n);
        }
    }

    public void setOnItemCheckChangeListener(a aVar) {
        this.aLf = aVar;
    }

    public void a(com.baidu.tbadk.widget.vote.a aVar, int i, int i2, boolean z, boolean z2) {
        if (aVar != null) {
            this.isSelected = z;
            this.aKZ = aVar;
            this.position = i;
            if (StringUtils.isNull(aVar.Cr())) {
                this.aLd.setVisibility(4);
                this.aLd.setText((CharSequence) null);
            } else {
                this.aLd.setVisibility(0);
                this.aLd.setText(UtilHelper.getFixedText(aVar.Cr(), 10, false));
            }
            if (i2 == 2) {
                setOnClickListener(null);
                b(aVar);
            } else if (i2 == 1 || i2 == 3) {
                setOnClickListener(this.aLg);
                cd(z);
            }
            this.aLa.c(aVar.Cw(), 17, false);
        }
    }

    public void setNameVisibility(int i) {
        this.aLd.setVisibility(i);
    }

    private void cd(boolean z) {
        setProgressGroupVisible(false);
        this.aLe.setVisibility(0);
        if (z) {
            at.c(this.aLe, r.f.chx_pic_add_s);
        } else {
            at.c(this.aLe, r.f.chx_pic_add_n);
        }
    }

    private void b(com.baidu.tbadk.widget.vote.a aVar) {
        setProgressGroupVisible(true);
        this.aLe.setVisibility(8);
        if (aVar != null) {
            if (StringUtils.isNull(aVar.Cs())) {
                this.aLb.setVisibility(8);
                this.aLb.setText((CharSequence) null);
            } else {
                this.aLb.setVisibility(0);
                this.aLb.setText(aVar.Cs());
            }
            if (StringUtils.isNull(aVar.Ct())) {
                this.aLc.setVisibility(8);
                this.aLc.setText((CharSequence) null);
                return;
            }
            this.aLc.setVisibility(0);
            this.aLc.setText(aVar.Ct());
        }
    }

    private void setProgressGroupVisible(boolean z) {
        if (z) {
            this.aLb.setVisibility(0);
            this.aLc.setVisibility(0);
            this.aKL.setVisibility(0);
            return;
        }
        this.aLb.setVisibility(8);
        this.aLc.setVisibility(8);
        this.aKL.setVisibility(8);
    }

    public void setProgress(float f) {
        if (f >= 0.0f && this.aKZ != null) {
            int Cv = (int) (this.aKZ.Cv() * f);
            if (this.isSelected) {
                this.aKL.setProgress(Cv);
                this.aKL.setSecondaryProgress(0);
                return;
            }
            this.aKL.setProgress(0);
            this.aKL.setSecondaryProgress(Cv);
        }
    }

    public void onChangeSkinType(int i) {
        at.b(this.aLd, r.d.cp_cont_b, 1, i);
        at.b(this.aLb, r.d.cp_cont_g, 1, i);
        at.b(this.aLc, r.d.cp_cont_g, 1, i);
        this.aKL.setProgressDrawable(at.q(i, r.f.vote_photo_progress_drawable));
        if (this.isSelected) {
            at.c(this.aLe, r.f.chx_pic_add_s);
        } else {
            at.c(this.aLe, r.f.chx_pic_add_n);
        }
    }
}
