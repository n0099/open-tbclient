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
    private ProgressBar aOQ;
    private com.baidu.tbadk.widget.vote.a aPe;
    private TbImageView aPf;
    private TextView aPg;
    private TextView aPh;
    private TextView aPi;
    private ImageView aPj;
    private a aPk;
    private View.OnClickListener aPl;
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
        this.aPl = new f(this);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(w.j.vote_selected_pic_item, this);
        this.aPf = (TbImageView) findViewById(w.h.vote_photo_image);
        this.aOQ = (ProgressBar) findViewById(w.h.vote_photo_progress);
        this.aPg = (TextView) findViewById(w.h.vote_photo_number);
        this.aPh = (TextView) findViewById(w.h.vote_photo_percent);
        this.aPi = (TextView) findViewById(w.h.vote_photo_name);
        this.aPj = (ImageView) findViewById(w.h.vote_photo_check_image);
        this.aPf.setDrawBorder(true);
        this.aPf.setBorderColor(aq.getColor(w.e.common_color_10043));
        this.aPf.setBorderWidth(getResources().getDimensionPixelSize(w.f.ds1));
        setOnClickListener(this.aPl);
        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
    }

    @Override // android.view.View
    public void setSelected(boolean z) {
        this.isSelected = z;
        if (z) {
            aq.c(this.aPj, w.g.chx_pic_add_s);
        } else {
            aq.c(this.aPj, w.g.chx_pic_add_n);
        }
    }

    public void setOnItemCheckChangeListener(a aVar) {
        this.aPk = aVar;
    }

    public void a(com.baidu.tbadk.widget.vote.a aVar, int i, int i2, boolean z, boolean z2) {
        if (aVar != null) {
            this.isSelected = z;
            this.aPe = aVar;
            this.position = i;
            if (StringUtils.isNull(aVar.BQ())) {
                this.aPi.setVisibility(4);
                this.aPi.setText((CharSequence) null);
            } else {
                this.aPi.setVisibility(0);
                this.aPi.setText(UtilHelper.getFixedText(aVar.BQ(), 10, false));
            }
            if (i2 == 2) {
                setOnClickListener(null);
                b(aVar);
            } else if (i2 == 1 || i2 == 3) {
                setOnClickListener(this.aPl);
                cd(z);
            }
            this.aPf.c(aVar.BV(), 17, false);
        }
    }

    public void setNameVisibility(int i) {
        this.aPi.setVisibility(i);
    }

    private void cd(boolean z) {
        setProgressGroupVisible(false);
        this.aPj.setVisibility(0);
        if (z) {
            aq.c(this.aPj, w.g.chx_pic_add_s);
        } else {
            aq.c(this.aPj, w.g.chx_pic_add_n);
        }
    }

    private void b(com.baidu.tbadk.widget.vote.a aVar) {
        setProgressGroupVisible(true);
        this.aPj.setVisibility(8);
        if (aVar != null) {
            if (StringUtils.isNull(aVar.BR())) {
                this.aPg.setVisibility(8);
                this.aPg.setText((CharSequence) null);
            } else {
                this.aPg.setVisibility(0);
                this.aPg.setText(aVar.BR());
            }
            if (StringUtils.isNull(aVar.BS())) {
                this.aPh.setVisibility(8);
                this.aPh.setText((CharSequence) null);
                return;
            }
            this.aPh.setVisibility(0);
            this.aPh.setText(aVar.BS());
        }
    }

    private void setProgressGroupVisible(boolean z) {
        if (z) {
            this.aPg.setVisibility(0);
            this.aPh.setVisibility(0);
            this.aOQ.setVisibility(0);
            return;
        }
        this.aPg.setVisibility(8);
        this.aPh.setVisibility(8);
        this.aOQ.setVisibility(8);
    }

    public void setProgress(float f) {
        if (f >= 0.0f && this.aPe != null) {
            int BU = (int) (this.aPe.BU() * f);
            if (this.isSelected) {
                this.aOQ.setProgress(BU);
                this.aOQ.setSecondaryProgress(0);
                return;
            }
            this.aOQ.setProgress(0);
            this.aOQ.setSecondaryProgress(BU);
        }
    }

    public void onChangeSkinType(int i) {
        aq.b(this.aPi, w.e.cp_cont_b, 1, i);
        aq.b(this.aPg, w.e.cp_cont_g, 1, i);
        aq.b(this.aPh, w.e.cp_cont_g, 1, i);
        this.aOQ.setProgressDrawable(aq.u(i, w.g.vote_photo_progress_drawable));
        if (this.isSelected) {
            aq.c(this.aPj, w.g.chx_pic_add_s);
        } else {
            aq.c(this.aPj, w.g.chx_pic_add_n);
        }
    }
}
