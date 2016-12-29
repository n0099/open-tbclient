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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class e extends FrameLayout {
    private ProgressBar aKc;
    private com.baidu.tbadk.widget.vote.a aKq;
    private TbImageView aKr;
    private TextView aKs;
    private TextView aKt;
    private TextView aKu;
    private ImageView aKv;
    private a aKw;
    private View.OnClickListener aKx;
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
        this.aKx = new f(this);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(r.h.vote_selected_pic_item, this);
        this.aKr = (TbImageView) findViewById(r.g.vote_photo_image);
        this.aKc = (ProgressBar) findViewById(r.g.vote_photo_progress);
        this.aKs = (TextView) findViewById(r.g.vote_photo_number);
        this.aKt = (TextView) findViewById(r.g.vote_photo_percent);
        this.aKu = (TextView) findViewById(r.g.vote_photo_name);
        this.aKv = (ImageView) findViewById(r.g.vote_photo_check_image);
        this.aKr.setDrawBorder(true);
        this.aKr.setBorderColor(ar.getColor(r.d.common_color_10043));
        this.aKr.setBorderWidth(getResources().getDimensionPixelSize(r.e.ds1));
        setOnClickListener(this.aKx);
        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
    }

    @Override // android.view.View
    public void setSelected(boolean z) {
        this.isSelected = z;
        if (z) {
            ar.c(this.aKv, r.f.chx_pic_add_s);
        } else {
            ar.c(this.aKv, r.f.chx_pic_add_n);
        }
    }

    public void setOnItemCheckChangeListener(a aVar) {
        this.aKw = aVar;
    }

    public void a(com.baidu.tbadk.widget.vote.a aVar, int i, int i2, boolean z, boolean z2) {
        if (aVar != null) {
            this.isSelected = z;
            this.aKq = aVar;
            this.position = i;
            if (StringUtils.isNull(aVar.Ce())) {
                this.aKu.setVisibility(4);
                this.aKu.setText((CharSequence) null);
            } else {
                this.aKu.setVisibility(0);
                this.aKu.setText(UtilHelper.getFixedText(aVar.Ce(), 10, false));
            }
            if (i2 == 2) {
                setOnClickListener(null);
                b(aVar);
            } else if (i2 == 1 || i2 == 3) {
                setOnClickListener(this.aKx);
                cc(z);
            }
            this.aKr.c(aVar.Cj(), 17, false);
        }
    }

    public void setNameVisibility(int i) {
        this.aKu.setVisibility(i);
    }

    private void cc(boolean z) {
        setProgressGroupVisible(false);
        this.aKv.setVisibility(0);
        if (z) {
            ar.c(this.aKv, r.f.chx_pic_add_s);
        } else {
            ar.c(this.aKv, r.f.chx_pic_add_n);
        }
    }

    private void b(com.baidu.tbadk.widget.vote.a aVar) {
        setProgressGroupVisible(true);
        this.aKv.setVisibility(8);
        if (aVar != null) {
            if (StringUtils.isNull(aVar.Cf())) {
                this.aKs.setVisibility(8);
                this.aKs.setText((CharSequence) null);
            } else {
                this.aKs.setVisibility(0);
                this.aKs.setText(aVar.Cf());
            }
            if (StringUtils.isNull(aVar.Cg())) {
                this.aKt.setVisibility(8);
                this.aKt.setText((CharSequence) null);
                return;
            }
            this.aKt.setVisibility(0);
            this.aKt.setText(aVar.Cg());
        }
    }

    private void setProgressGroupVisible(boolean z) {
        if (z) {
            this.aKs.setVisibility(0);
            this.aKt.setVisibility(0);
            this.aKc.setVisibility(0);
            return;
        }
        this.aKs.setVisibility(8);
        this.aKt.setVisibility(8);
        this.aKc.setVisibility(8);
    }

    public void setProgress(float f) {
        if (f >= 0.0f && this.aKq != null) {
            int Ci = (int) (this.aKq.Ci() * f);
            if (this.isSelected) {
                this.aKc.setProgress(Ci);
                this.aKc.setSecondaryProgress(0);
                return;
            }
            this.aKc.setProgress(0);
            this.aKc.setSecondaryProgress(Ci);
        }
    }

    public void onChangeSkinType(int i) {
        ar.b(this.aKu, r.d.cp_cont_b, 1, i);
        ar.b(this.aKs, r.d.cp_cont_g, 1, i);
        ar.b(this.aKt, r.d.cp_cont_g, 1, i);
        this.aKc.setProgressDrawable(ar.q(i, r.f.vote_photo_progress_drawable));
        if (this.isSelected) {
            ar.c(this.aKv, r.f.chx_pic_add_s);
        } else {
            ar.c(this.aKv, r.f.chx_pic_add_n);
        }
    }
}
