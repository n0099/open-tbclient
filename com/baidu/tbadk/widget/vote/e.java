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
    private com.baidu.tbadk.widget.vote.a aOK;
    private TbImageView aOL;
    private TextView aOM;
    private TextView aON;
    private TextView aOO;
    private ImageView aOP;
    private a aOQ;
    private View.OnClickListener aOR;
    private ProgressBar aOw;
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
        this.aOR = new f(this);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(w.j.vote_selected_pic_item, this);
        this.aOL = (TbImageView) findViewById(w.h.vote_photo_image);
        this.aOw = (ProgressBar) findViewById(w.h.vote_photo_progress);
        this.aOM = (TextView) findViewById(w.h.vote_photo_number);
        this.aON = (TextView) findViewById(w.h.vote_photo_percent);
        this.aOO = (TextView) findViewById(w.h.vote_photo_name);
        this.aOP = (ImageView) findViewById(w.h.vote_photo_check_image);
        this.aOL.setDrawBorder(true);
        this.aOL.setBorderColor(aq.getColor(w.e.common_color_10043));
        this.aOL.setBorderWidth(getResources().getDimensionPixelSize(w.f.ds1));
        setOnClickListener(this.aOR);
        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
    }

    @Override // android.view.View
    public void setSelected(boolean z) {
        this.isSelected = z;
        if (z) {
            aq.c(this.aOP, w.g.chx_pic_add_s);
        } else {
            aq.c(this.aOP, w.g.chx_pic_add_n);
        }
    }

    public void setOnItemCheckChangeListener(a aVar) {
        this.aOQ = aVar;
    }

    public void a(com.baidu.tbadk.widget.vote.a aVar, int i, int i2, boolean z, boolean z2) {
        if (aVar != null) {
            this.isSelected = z;
            this.aOK = aVar;
            this.position = i;
            if (StringUtils.isNull(aVar.CR())) {
                this.aOO.setVisibility(4);
                this.aOO.setText((CharSequence) null);
            } else {
                this.aOO.setVisibility(0);
                this.aOO.setText(UtilHelper.getFixedText(aVar.CR(), 10, false));
            }
            if (i2 == 2) {
                setOnClickListener(null);
                b(aVar);
            } else if (i2 == 1 || i2 == 3) {
                setOnClickListener(this.aOR);
                cd(z);
            }
            this.aOL.c(aVar.CW(), 17, false);
        }
    }

    public void setNameVisibility(int i) {
        this.aOO.setVisibility(i);
    }

    private void cd(boolean z) {
        setProgressGroupVisible(false);
        this.aOP.setVisibility(0);
        if (z) {
            aq.c(this.aOP, w.g.chx_pic_add_s);
        } else {
            aq.c(this.aOP, w.g.chx_pic_add_n);
        }
    }

    private void b(com.baidu.tbadk.widget.vote.a aVar) {
        setProgressGroupVisible(true);
        this.aOP.setVisibility(8);
        if (aVar != null) {
            if (StringUtils.isNull(aVar.CS())) {
                this.aOM.setVisibility(8);
                this.aOM.setText((CharSequence) null);
            } else {
                this.aOM.setVisibility(0);
                this.aOM.setText(aVar.CS());
            }
            if (StringUtils.isNull(aVar.CT())) {
                this.aON.setVisibility(8);
                this.aON.setText((CharSequence) null);
                return;
            }
            this.aON.setVisibility(0);
            this.aON.setText(aVar.CT());
        }
    }

    private void setProgressGroupVisible(boolean z) {
        if (z) {
            this.aOM.setVisibility(0);
            this.aON.setVisibility(0);
            this.aOw.setVisibility(0);
            return;
        }
        this.aOM.setVisibility(8);
        this.aON.setVisibility(8);
        this.aOw.setVisibility(8);
    }

    public void setProgress(float f) {
        if (f >= 0.0f && this.aOK != null) {
            int CV = (int) (this.aOK.CV() * f);
            if (this.isSelected) {
                this.aOw.setProgress(CV);
                this.aOw.setSecondaryProgress(0);
                return;
            }
            this.aOw.setProgress(0);
            this.aOw.setSecondaryProgress(CV);
        }
    }

    public void onChangeSkinType(int i) {
        aq.b(this.aOO, w.e.cp_cont_b, 1, i);
        aq.b(this.aOM, w.e.cp_cont_g, 1, i);
        aq.b(this.aON, w.e.cp_cont_g, 1, i);
        this.aOw.setProgressDrawable(aq.x(i, w.g.vote_photo_progress_drawable));
        if (this.isSelected) {
            aq.c(this.aOP, w.g.chx_pic_add_s);
        } else {
            aq.c(this.aOP, w.g.chx_pic_add_n);
        }
    }
}
