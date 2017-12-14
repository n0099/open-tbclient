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
    private com.baidu.tbadk.widget.vote.a aWB;
    private TbImageView aWC;
    private TextView aWD;
    private TextView aWE;
    private TextView aWF;
    private ImageView aWG;
    private a aWH;
    private View.OnClickListener aWI;
    private boolean isSelected;
    private int position;
    private ProgressBar progressBar;

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
        this.aWI = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.vote.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.setSelected(!d.this.isSelected);
                if (d.this.aWH != null) {
                    d.this.aWH.b(d.this.aWB, d.this.position, d.this.isSelected);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(d.h.vote_selected_pic_item, this);
        this.aWC = (TbImageView) findViewById(d.g.vote_photo_image);
        this.progressBar = (ProgressBar) findViewById(d.g.vote_photo_progress);
        this.aWD = (TextView) findViewById(d.g.vote_photo_number);
        this.aWE = (TextView) findViewById(d.g.vote_photo_percent);
        this.aWF = (TextView) findViewById(d.g.vote_photo_name);
        this.aWG = (ImageView) findViewById(d.g.vote_photo_check_image);
        this.aWC.setDrawBorder(true);
        this.aWC.setBorderColor(aj.getColor(d.C0096d.common_color_10043));
        this.aWC.setBorderWidth(getResources().getDimensionPixelSize(d.e.ds1));
        setOnClickListener(this.aWI);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View
    public void setSelected(boolean z) {
        this.isSelected = z;
        if (z) {
            aj.c(this.aWG, d.f.chx_pic_add_s);
        } else {
            aj.c(this.aWG, d.f.chx_pic_add_n);
        }
    }

    public void setOnItemCheckChangeListener(a aVar) {
        this.aWH = aVar;
    }

    public void a(com.baidu.tbadk.widget.vote.a aVar, int i, int i2, boolean z, boolean z2) {
        if (aVar != null) {
            this.isSelected = z;
            this.aWB = aVar;
            this.position = i;
            if (StringUtils.isNull(aVar.CI())) {
                this.aWF.setVisibility(4);
                this.aWF.setText((CharSequence) null);
            } else {
                this.aWF.setVisibility(0);
                this.aWF.setText(UtilHelper.getFixedText(aVar.CI(), 10, false));
            }
            if (i2 == 2) {
                setOnClickListener(null);
                b(aVar);
            } else if (i2 == 1 || i2 == 3) {
                setOnClickListener(this.aWI);
                ci(z);
            }
            this.aWC.startLoad(aVar.CN(), 17, false);
        }
    }

    public void setNameVisibility(int i) {
        this.aWF.setVisibility(i);
    }

    private void ci(boolean z) {
        setProgressGroupVisible(false);
        this.aWG.setVisibility(0);
        if (z) {
            aj.c(this.aWG, d.f.chx_pic_add_s);
        } else {
            aj.c(this.aWG, d.f.chx_pic_add_n);
        }
    }

    private void b(com.baidu.tbadk.widget.vote.a aVar) {
        setProgressGroupVisible(true);
        this.aWG.setVisibility(8);
        if (aVar != null) {
            if (StringUtils.isNull(aVar.CJ())) {
                this.aWD.setVisibility(8);
                this.aWD.setText((CharSequence) null);
            } else {
                this.aWD.setVisibility(0);
                this.aWD.setText(aVar.CJ());
            }
            if (StringUtils.isNull(aVar.CK())) {
                this.aWE.setVisibility(8);
                this.aWE.setText((CharSequence) null);
                return;
            }
            this.aWE.setVisibility(0);
            this.aWE.setText(aVar.CK());
        }
    }

    private void setProgressGroupVisible(boolean z) {
        if (z) {
            this.aWD.setVisibility(0);
            this.aWE.setVisibility(0);
            this.progressBar.setVisibility(0);
            return;
        }
        this.aWD.setVisibility(8);
        this.aWE.setVisibility(8);
        this.progressBar.setVisibility(8);
    }

    public void setProgress(float f) {
        if (f >= 0.0f && this.aWB != null) {
            int CM = (int) (this.aWB.CM() * f);
            if (this.isSelected) {
                this.progressBar.setProgress(CM);
                this.progressBar.setSecondaryProgress(0);
                return;
            }
            this.progressBar.setProgress(0);
            this.progressBar.setSecondaryProgress(CM);
        }
    }

    public void onChangeSkinType(int i) {
        aj.b(this.aWF, d.C0096d.cp_cont_b, 1, i);
        aj.b(this.aWD, d.C0096d.cp_cont_g, 1, i);
        aj.b(this.aWE, d.C0096d.cp_cont_g, 1, i);
        this.progressBar.setProgressDrawable(aj.v(i, d.f.vote_photo_progress_drawable));
        if (this.isSelected) {
            aj.c(this.aWG, d.f.chx_pic_add_s);
        } else {
            aj.c(this.aWG, d.f.chx_pic_add_n);
        }
    }
}
