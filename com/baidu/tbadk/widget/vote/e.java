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
    private ProgressBar aOR;
    private com.baidu.tbadk.widget.vote.a aPf;
    private TbImageView aPg;
    private TextView aPh;
    private TextView aPi;
    private TextView aPj;
    private ImageView aPk;
    private a aPl;
    private View.OnClickListener aPm;
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
        this.aPm = new f(this);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(w.j.vote_selected_pic_item, this);
        this.aPg = (TbImageView) findViewById(w.h.vote_photo_image);
        this.aOR = (ProgressBar) findViewById(w.h.vote_photo_progress);
        this.aPh = (TextView) findViewById(w.h.vote_photo_number);
        this.aPi = (TextView) findViewById(w.h.vote_photo_percent);
        this.aPj = (TextView) findViewById(w.h.vote_photo_name);
        this.aPk = (ImageView) findViewById(w.h.vote_photo_check_image);
        this.aPg.setDrawBorder(true);
        this.aPg.setBorderColor(aq.getColor(w.e.common_color_10043));
        this.aPg.setBorderWidth(getResources().getDimensionPixelSize(w.f.ds1));
        setOnClickListener(this.aPm);
        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
    }

    @Override // android.view.View
    public void setSelected(boolean z) {
        this.isSelected = z;
        if (z) {
            aq.c(this.aPk, w.g.chx_pic_add_s);
        } else {
            aq.c(this.aPk, w.g.chx_pic_add_n);
        }
    }

    public void setOnItemCheckChangeListener(a aVar) {
        this.aPl = aVar;
    }

    public void a(com.baidu.tbadk.widget.vote.a aVar, int i, int i2, boolean z, boolean z2) {
        if (aVar != null) {
            this.isSelected = z;
            this.aPf = aVar;
            this.position = i;
            if (StringUtils.isNull(aVar.BW())) {
                this.aPj.setVisibility(4);
                this.aPj.setText((CharSequence) null);
            } else {
                this.aPj.setVisibility(0);
                this.aPj.setText(UtilHelper.getFixedText(aVar.BW(), 10, false));
            }
            if (i2 == 2) {
                setOnClickListener(null);
                b(aVar);
            } else if (i2 == 1 || i2 == 3) {
                setOnClickListener(this.aPm);
                cg(z);
            }
            this.aPg.c(aVar.Cb(), 17, false);
        }
    }

    public void setNameVisibility(int i) {
        this.aPj.setVisibility(i);
    }

    private void cg(boolean z) {
        setProgressGroupVisible(false);
        this.aPk.setVisibility(0);
        if (z) {
            aq.c(this.aPk, w.g.chx_pic_add_s);
        } else {
            aq.c(this.aPk, w.g.chx_pic_add_n);
        }
    }

    private void b(com.baidu.tbadk.widget.vote.a aVar) {
        setProgressGroupVisible(true);
        this.aPk.setVisibility(8);
        if (aVar != null) {
            if (StringUtils.isNull(aVar.BX())) {
                this.aPh.setVisibility(8);
                this.aPh.setText((CharSequence) null);
            } else {
                this.aPh.setVisibility(0);
                this.aPh.setText(aVar.BX());
            }
            if (StringUtils.isNull(aVar.BY())) {
                this.aPi.setVisibility(8);
                this.aPi.setText((CharSequence) null);
                return;
            }
            this.aPi.setVisibility(0);
            this.aPi.setText(aVar.BY());
        }
    }

    private void setProgressGroupVisible(boolean z) {
        if (z) {
            this.aPh.setVisibility(0);
            this.aPi.setVisibility(0);
            this.aOR.setVisibility(0);
            return;
        }
        this.aPh.setVisibility(8);
        this.aPi.setVisibility(8);
        this.aOR.setVisibility(8);
    }

    public void setProgress(float f) {
        if (f >= 0.0f && this.aPf != null) {
            int Ca = (int) (this.aPf.Ca() * f);
            if (this.isSelected) {
                this.aOR.setProgress(Ca);
                this.aOR.setSecondaryProgress(0);
                return;
            }
            this.aOR.setProgress(0);
            this.aOR.setSecondaryProgress(Ca);
        }
    }

    public void onChangeSkinType(int i) {
        aq.b(this.aPj, w.e.cp_cont_b, 1, i);
        aq.b(this.aPh, w.e.cp_cont_g, 1, i);
        aq.b(this.aPi, w.e.cp_cont_g, 1, i);
        this.aOR.setProgressDrawable(aq.v(i, w.g.vote_photo_progress_drawable));
        if (this.isSelected) {
            aq.c(this.aPk, w.g.chx_pic_add_s);
        } else {
            aq.c(this.aPk, w.g.chx_pic_add_n);
        }
    }
}
