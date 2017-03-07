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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class e extends FrameLayout {
    private a aOA;
    private View.OnClickListener aOB;
    private ProgressBar aOg;
    private com.baidu.tbadk.widget.vote.a aOu;
    private TbImageView aOv;
    private TextView aOw;
    private TextView aOx;
    private TextView aOy;
    private ImageView aOz;
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
        this.aOB = new f(this);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(w.j.vote_selected_pic_item, this);
        this.aOv = (TbImageView) findViewById(w.h.vote_photo_image);
        this.aOg = (ProgressBar) findViewById(w.h.vote_photo_progress);
        this.aOw = (TextView) findViewById(w.h.vote_photo_number);
        this.aOx = (TextView) findViewById(w.h.vote_photo_percent);
        this.aOy = (TextView) findViewById(w.h.vote_photo_name);
        this.aOz = (ImageView) findViewById(w.h.vote_photo_check_image);
        this.aOv.setDrawBorder(true);
        this.aOv.setBorderColor(aq.getColor(w.e.common_color_10043));
        this.aOv.setBorderWidth(getResources().getDimensionPixelSize(w.f.ds1));
        setOnClickListener(this.aOB);
        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
    }

    @Override // android.view.View
    public void setSelected(boolean z) {
        this.isSelected = z;
        if (z) {
            aq.c(this.aOz, w.g.chx_pic_add_s);
        } else {
            aq.c(this.aOz, w.g.chx_pic_add_n);
        }
    }

    public void setOnItemCheckChangeListener(a aVar) {
        this.aOA = aVar;
    }

    public void a(com.baidu.tbadk.widget.vote.a aVar, int i, int i2, boolean z, boolean z2) {
        if (aVar != null) {
            this.isSelected = z;
            this.aOu = aVar;
            this.position = i;
            if (StringUtils.isNull(aVar.Ct())) {
                this.aOy.setVisibility(4);
                this.aOy.setText((CharSequence) null);
            } else {
                this.aOy.setVisibility(0);
                this.aOy.setText(UtilHelper.getFixedText(aVar.Ct(), 10, false));
            }
            if (i2 == 2) {
                setOnClickListener(null);
                b(aVar);
            } else if (i2 == 1 || i2 == 3) {
                setOnClickListener(this.aOB);
                cb(z);
            }
            this.aOv.c(aVar.Cy(), 17, false);
        }
    }

    public void setNameVisibility(int i) {
        this.aOy.setVisibility(i);
    }

    private void cb(boolean z) {
        setProgressGroupVisible(false);
        this.aOz.setVisibility(0);
        if (z) {
            aq.c(this.aOz, w.g.chx_pic_add_s);
        } else {
            aq.c(this.aOz, w.g.chx_pic_add_n);
        }
    }

    private void b(com.baidu.tbadk.widget.vote.a aVar) {
        setProgressGroupVisible(true);
        this.aOz.setVisibility(8);
        if (aVar != null) {
            if (StringUtils.isNull(aVar.Cu())) {
                this.aOw.setVisibility(8);
                this.aOw.setText((CharSequence) null);
            } else {
                this.aOw.setVisibility(0);
                this.aOw.setText(aVar.Cu());
            }
            if (StringUtils.isNull(aVar.Cv())) {
                this.aOx.setVisibility(8);
                this.aOx.setText((CharSequence) null);
                return;
            }
            this.aOx.setVisibility(0);
            this.aOx.setText(aVar.Cv());
        }
    }

    private void setProgressGroupVisible(boolean z) {
        if (z) {
            this.aOw.setVisibility(0);
            this.aOx.setVisibility(0);
            this.aOg.setVisibility(0);
            return;
        }
        this.aOw.setVisibility(8);
        this.aOx.setVisibility(8);
        this.aOg.setVisibility(8);
    }

    public void setProgress(float f) {
        if (f >= 0.0f && this.aOu != null) {
            int Cx = (int) (this.aOu.Cx() * f);
            if (this.isSelected) {
                this.aOg.setProgress(Cx);
                this.aOg.setSecondaryProgress(0);
                return;
            }
            this.aOg.setProgress(0);
            this.aOg.setSecondaryProgress(Cx);
        }
    }

    public void onChangeSkinType(int i) {
        aq.b(this.aOy, w.e.cp_cont_b, 1, i);
        aq.b(this.aOw, w.e.cp_cont_g, 1, i);
        aq.b(this.aOx, w.e.cp_cont_g, 1, i);
        this.aOg.setProgressDrawable(aq.x(i, w.g.vote_photo_progress_drawable));
        if (this.isSelected) {
            aq.c(this.aOz, w.g.chx_pic_add_s);
        } else {
            aq.c(this.aOz, w.g.chx_pic_add_n);
        }
    }
}
