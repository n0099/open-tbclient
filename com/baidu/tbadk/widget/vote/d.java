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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class d extends FrameLayout {
    private TbImageView aWA;
    private TextView aWB;
    private TextView aWC;
    private TextView aWD;
    private ImageView aWE;
    private a aWF;
    private View.OnClickListener aWG;
    private ProgressBar aWl;
    private com.baidu.tbadk.widget.vote.a aWz;
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

    public d(Context context) {
        super(context);
        this.isSelected = false;
        this.aWG = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.vote.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.setSelected(!d.this.isSelected);
                if (d.this.aWF != null) {
                    d.this.aWF.b(d.this.aWz, d.this.position, d.this.isSelected);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(d.h.vote_selected_pic_item, this);
        this.aWA = (TbImageView) findViewById(d.g.vote_photo_image);
        this.aWl = (ProgressBar) findViewById(d.g.vote_photo_progress);
        this.aWB = (TextView) findViewById(d.g.vote_photo_number);
        this.aWC = (TextView) findViewById(d.g.vote_photo_percent);
        this.aWD = (TextView) findViewById(d.g.vote_photo_name);
        this.aWE = (ImageView) findViewById(d.g.vote_photo_check_image);
        this.aWA.setDrawBorder(true);
        this.aWA.setBorderColor(aj.getColor(d.C0082d.common_color_10043));
        this.aWA.setBorderWidth(getResources().getDimensionPixelSize(d.e.ds1));
        setOnClickListener(this.aWG);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View
    public void setSelected(boolean z) {
        this.isSelected = z;
        if (z) {
            aj.c(this.aWE, d.f.chx_pic_add_s);
        } else {
            aj.c(this.aWE, d.f.chx_pic_add_n);
        }
    }

    public void setOnItemCheckChangeListener(a aVar) {
        this.aWF = aVar;
    }

    public void a(com.baidu.tbadk.widget.vote.a aVar, int i, int i2, boolean z, boolean z2) {
        if (aVar != null) {
            this.isSelected = z;
            this.aWz = aVar;
            this.position = i;
            if (StringUtils.isNull(aVar.CH())) {
                this.aWD.setVisibility(4);
                this.aWD.setText((CharSequence) null);
            } else {
                this.aWD.setVisibility(0);
                this.aWD.setText(UtilHelper.getFixedText(aVar.CH(), 10, false));
            }
            if (i2 == 2) {
                setOnClickListener(null);
                b(aVar);
            } else if (i2 == 1 || i2 == 3) {
                setOnClickListener(this.aWG);
                ch(z);
            }
            this.aWA.startLoad(aVar.CM(), 17, false);
        }
    }

    public void setNameVisibility(int i) {
        this.aWD.setVisibility(i);
    }

    private void ch(boolean z) {
        setProgressGroupVisible(false);
        this.aWE.setVisibility(0);
        if (z) {
            aj.c(this.aWE, d.f.chx_pic_add_s);
        } else {
            aj.c(this.aWE, d.f.chx_pic_add_n);
        }
    }

    private void b(com.baidu.tbadk.widget.vote.a aVar) {
        setProgressGroupVisible(true);
        this.aWE.setVisibility(8);
        if (aVar != null) {
            if (StringUtils.isNull(aVar.CI())) {
                this.aWB.setVisibility(8);
                this.aWB.setText((CharSequence) null);
            } else {
                this.aWB.setVisibility(0);
                this.aWB.setText(aVar.CI());
            }
            if (StringUtils.isNull(aVar.CJ())) {
                this.aWC.setVisibility(8);
                this.aWC.setText((CharSequence) null);
                return;
            }
            this.aWC.setVisibility(0);
            this.aWC.setText(aVar.CJ());
        }
    }

    private void setProgressGroupVisible(boolean z) {
        if (z) {
            this.aWB.setVisibility(0);
            this.aWC.setVisibility(0);
            this.aWl.setVisibility(0);
            return;
        }
        this.aWB.setVisibility(8);
        this.aWC.setVisibility(8);
        this.aWl.setVisibility(8);
    }

    public void setProgress(float f) {
        if (f >= 0.0f && this.aWz != null) {
            int CL = (int) (this.aWz.CL() * f);
            if (this.isSelected) {
                this.aWl.setProgress(CL);
                this.aWl.setSecondaryProgress(0);
                return;
            }
            this.aWl.setProgress(0);
            this.aWl.setSecondaryProgress(CL);
        }
    }

    public void onChangeSkinType(int i) {
        aj.b(this.aWD, d.C0082d.cp_cont_b, 1, i);
        aj.b(this.aWB, d.C0082d.cp_cont_g, 1, i);
        aj.b(this.aWC, d.C0082d.cp_cont_g, 1, i);
        this.aWl.setProgressDrawable(aj.u(i, d.f.vote_photo_progress_drawable));
        if (this.isSelected) {
            aj.c(this.aWE, d.f.chx_pic_add_s);
        } else {
            aj.c(this.aWE, d.f.chx_pic_add_n);
        }
    }
}
