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
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class e extends FrameLayout {
    private TextView aQA;
    private ImageView aQB;
    private a aQC;
    private View.OnClickListener aQD;
    private ProgressBar aQi;
    private com.baidu.tbadk.widget.vote.a aQw;
    private TbImageView aQx;
    private TextView aQy;
    private TextView aQz;
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
        this.aQD = new f(this);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(w.j.vote_selected_pic_item, this);
        this.aQx = (TbImageView) findViewById(w.h.vote_photo_image);
        this.aQi = (ProgressBar) findViewById(w.h.vote_photo_progress);
        this.aQy = (TextView) findViewById(w.h.vote_photo_number);
        this.aQz = (TextView) findViewById(w.h.vote_photo_percent);
        this.aQA = (TextView) findViewById(w.h.vote_photo_name);
        this.aQB = (ImageView) findViewById(w.h.vote_photo_check_image);
        this.aQx.setDrawBorder(true);
        this.aQx.setBorderColor(as.getColor(w.e.common_color_10043));
        this.aQx.setBorderWidth(getResources().getDimensionPixelSize(w.f.ds1));
        setOnClickListener(this.aQD);
        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
    }

    @Override // android.view.View
    public void setSelected(boolean z) {
        this.isSelected = z;
        if (z) {
            as.c(this.aQB, w.g.chx_pic_add_s);
        } else {
            as.c(this.aQB, w.g.chx_pic_add_n);
        }
    }

    public void setOnItemCheckChangeListener(a aVar) {
        this.aQC = aVar;
    }

    public void a(com.baidu.tbadk.widget.vote.a aVar, int i, int i2, boolean z, boolean z2) {
        if (aVar != null) {
            this.isSelected = z;
            this.aQw = aVar;
            this.position = i;
            if (StringUtils.isNull(aVar.Ck())) {
                this.aQA.setVisibility(4);
                this.aQA.setText((CharSequence) null);
            } else {
                this.aQA.setVisibility(0);
                this.aQA.setText(UtilHelper.getFixedText(aVar.Ck(), 10, false));
            }
            if (i2 == 2) {
                setOnClickListener(null);
                b(aVar);
            } else if (i2 == 1 || i2 == 3) {
                setOnClickListener(this.aQD);
                cf(z);
            }
            this.aQx.c(aVar.Cp(), 17, false);
        }
    }

    public void setNameVisibility(int i) {
        this.aQA.setVisibility(i);
    }

    private void cf(boolean z) {
        setProgressGroupVisible(false);
        this.aQB.setVisibility(0);
        if (z) {
            as.c(this.aQB, w.g.chx_pic_add_s);
        } else {
            as.c(this.aQB, w.g.chx_pic_add_n);
        }
    }

    private void b(com.baidu.tbadk.widget.vote.a aVar) {
        setProgressGroupVisible(true);
        this.aQB.setVisibility(8);
        if (aVar != null) {
            if (StringUtils.isNull(aVar.Cl())) {
                this.aQy.setVisibility(8);
                this.aQy.setText((CharSequence) null);
            } else {
                this.aQy.setVisibility(0);
                this.aQy.setText(aVar.Cl());
            }
            if (StringUtils.isNull(aVar.Cm())) {
                this.aQz.setVisibility(8);
                this.aQz.setText((CharSequence) null);
                return;
            }
            this.aQz.setVisibility(0);
            this.aQz.setText(aVar.Cm());
        }
    }

    private void setProgressGroupVisible(boolean z) {
        if (z) {
            this.aQy.setVisibility(0);
            this.aQz.setVisibility(0);
            this.aQi.setVisibility(0);
            return;
        }
        this.aQy.setVisibility(8);
        this.aQz.setVisibility(8);
        this.aQi.setVisibility(8);
    }

    public void setProgress(float f) {
        if (f >= 0.0f && this.aQw != null) {
            int Co = (int) (this.aQw.Co() * f);
            if (this.isSelected) {
                this.aQi.setProgress(Co);
                this.aQi.setSecondaryProgress(0);
                return;
            }
            this.aQi.setProgress(0);
            this.aQi.setSecondaryProgress(Co);
        }
    }

    public void onChangeSkinType(int i) {
        as.b(this.aQA, w.e.cp_cont_b, 1, i);
        as.b(this.aQy, w.e.cp_cont_g, 1, i);
        as.b(this.aQz, w.e.cp_cont_g, 1, i);
        this.aQi.setProgressDrawable(as.u(i, w.g.vote_photo_progress_drawable));
        if (this.isSelected) {
            as.c(this.aQB, w.g.chx_pic_add_s);
        } else {
            as.c(this.aQB, w.g.chx_pic_add_n);
        }
    }
}
