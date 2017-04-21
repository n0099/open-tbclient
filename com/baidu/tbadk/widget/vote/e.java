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
    private com.baidu.tbadk.widget.vote.a aOM;
    private TbImageView aON;
    private TextView aOO;
    private TextView aOP;
    private TextView aOQ;
    private ImageView aOR;
    private a aOS;
    private View.OnClickListener aOT;
    private ProgressBar aOy;
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
        this.aOT = new f(this);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(w.j.vote_selected_pic_item, this);
        this.aON = (TbImageView) findViewById(w.h.vote_photo_image);
        this.aOy = (ProgressBar) findViewById(w.h.vote_photo_progress);
        this.aOO = (TextView) findViewById(w.h.vote_photo_number);
        this.aOP = (TextView) findViewById(w.h.vote_photo_percent);
        this.aOQ = (TextView) findViewById(w.h.vote_photo_name);
        this.aOR = (ImageView) findViewById(w.h.vote_photo_check_image);
        this.aON.setDrawBorder(true);
        this.aON.setBorderColor(aq.getColor(w.e.common_color_10043));
        this.aON.setBorderWidth(getResources().getDimensionPixelSize(w.f.ds1));
        setOnClickListener(this.aOT);
        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
    }

    @Override // android.view.View
    public void setSelected(boolean z) {
        this.isSelected = z;
        if (z) {
            aq.c(this.aOR, w.g.chx_pic_add_s);
        } else {
            aq.c(this.aOR, w.g.chx_pic_add_n);
        }
    }

    public void setOnItemCheckChangeListener(a aVar) {
        this.aOS = aVar;
    }

    public void a(com.baidu.tbadk.widget.vote.a aVar, int i, int i2, boolean z, boolean z2) {
        if (aVar != null) {
            this.isSelected = z;
            this.aOM = aVar;
            this.position = i;
            if (StringUtils.isNull(aVar.CR())) {
                this.aOQ.setVisibility(4);
                this.aOQ.setText((CharSequence) null);
            } else {
                this.aOQ.setVisibility(0);
                this.aOQ.setText(UtilHelper.getFixedText(aVar.CR(), 10, false));
            }
            if (i2 == 2) {
                setOnClickListener(null);
                b(aVar);
            } else if (i2 == 1 || i2 == 3) {
                setOnClickListener(this.aOT);
                cd(z);
            }
            this.aON.c(aVar.CW(), 17, false);
        }
    }

    public void setNameVisibility(int i) {
        this.aOQ.setVisibility(i);
    }

    private void cd(boolean z) {
        setProgressGroupVisible(false);
        this.aOR.setVisibility(0);
        if (z) {
            aq.c(this.aOR, w.g.chx_pic_add_s);
        } else {
            aq.c(this.aOR, w.g.chx_pic_add_n);
        }
    }

    private void b(com.baidu.tbadk.widget.vote.a aVar) {
        setProgressGroupVisible(true);
        this.aOR.setVisibility(8);
        if (aVar != null) {
            if (StringUtils.isNull(aVar.CS())) {
                this.aOO.setVisibility(8);
                this.aOO.setText((CharSequence) null);
            } else {
                this.aOO.setVisibility(0);
                this.aOO.setText(aVar.CS());
            }
            if (StringUtils.isNull(aVar.CT())) {
                this.aOP.setVisibility(8);
                this.aOP.setText((CharSequence) null);
                return;
            }
            this.aOP.setVisibility(0);
            this.aOP.setText(aVar.CT());
        }
    }

    private void setProgressGroupVisible(boolean z) {
        if (z) {
            this.aOO.setVisibility(0);
            this.aOP.setVisibility(0);
            this.aOy.setVisibility(0);
            return;
        }
        this.aOO.setVisibility(8);
        this.aOP.setVisibility(8);
        this.aOy.setVisibility(8);
    }

    public void setProgress(float f) {
        if (f >= 0.0f && this.aOM != null) {
            int CV = (int) (this.aOM.CV() * f);
            if (this.isSelected) {
                this.aOy.setProgress(CV);
                this.aOy.setSecondaryProgress(0);
                return;
            }
            this.aOy.setProgress(0);
            this.aOy.setSecondaryProgress(CV);
        }
    }

    public void onChangeSkinType(int i) {
        aq.b(this.aOQ, w.e.cp_cont_b, 1, i);
        aq.b(this.aOO, w.e.cp_cont_g, 1, i);
        aq.b(this.aOP, w.e.cp_cont_g, 1, i);
        this.aOy.setProgressDrawable(aq.x(i, w.g.vote_photo_progress_drawable));
        if (this.isSelected) {
            aq.c(this.aOR, w.g.chx_pic_add_s);
        } else {
            aq.c(this.aOR, w.g.chx_pic_add_n);
        }
    }
}
