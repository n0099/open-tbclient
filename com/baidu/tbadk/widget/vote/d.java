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
    private com.baidu.tbadk.widget.vote.a bMB;
    private TbImageView bMC;
    private TextView bMD;
    private TextView bME;
    private TextView bMF;
    private ImageView bMG;
    private a bMH;
    private View.OnClickListener bMI;
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
        this.bMI = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.vote.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.setSelected(!d.this.isSelected);
                if (d.this.bMH != null) {
                    d.this.bMH.b(d.this.bMB, d.this.position, d.this.isSelected);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(d.h.vote_selected_pic_item, this);
        this.bMC = (TbImageView) findViewById(d.g.vote_photo_image);
        this.progressBar = (ProgressBar) findViewById(d.g.vote_photo_progress);
        this.bMD = (TextView) findViewById(d.g.vote_photo_number);
        this.bME = (TextView) findViewById(d.g.vote_photo_percent);
        this.bMF = (TextView) findViewById(d.g.vote_photo_name);
        this.bMG = (ImageView) findViewById(d.g.vote_photo_check_image);
        this.bMC.setDrawBorder(true);
        this.bMC.setBorderColor(aj.getColor(d.C0141d.common_color_10043));
        this.bMC.setBorderWidth(getResources().getDimensionPixelSize(d.e.ds1));
        setOnClickListener(this.bMI);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View
    public void setSelected(boolean z) {
        this.isSelected = z;
        if (z) {
            aj.c(this.bMG, d.f.chx_pic_add_s);
        } else {
            aj.c(this.bMG, d.f.chx_pic_add_n);
        }
    }

    public void setOnItemCheckChangeListener(a aVar) {
        this.bMH = aVar;
    }

    public void a(com.baidu.tbadk.widget.vote.a aVar, int i, int i2, boolean z, boolean z2) {
        if (aVar != null) {
            this.isSelected = z;
            this.bMB = aVar;
            this.position = i;
            if (StringUtils.isNull(aVar.KF())) {
                this.bMF.setVisibility(4);
                this.bMF.setText((CharSequence) null);
            } else {
                this.bMF.setVisibility(0);
                this.bMF.setText(UtilHelper.getFixedText(aVar.KF(), 10, false));
            }
            if (i2 == 2) {
                setOnClickListener(null);
                b(aVar);
            } else if (i2 == 1 || i2 == 3) {
                setOnClickListener(this.bMI);
                cO(z);
            }
            this.bMC.startLoad(aVar.KK(), 17, false);
        }
    }

    public void setNameVisibility(int i) {
        this.bMF.setVisibility(i);
    }

    private void cO(boolean z) {
        setProgressGroupVisible(false);
        this.bMG.setVisibility(0);
        if (z) {
            aj.c(this.bMG, d.f.chx_pic_add_s);
        } else {
            aj.c(this.bMG, d.f.chx_pic_add_n);
        }
    }

    private void b(com.baidu.tbadk.widget.vote.a aVar) {
        setProgressGroupVisible(true);
        this.bMG.setVisibility(8);
        if (aVar != null) {
            if (StringUtils.isNull(aVar.KG())) {
                this.bMD.setVisibility(8);
                this.bMD.setText((CharSequence) null);
            } else {
                this.bMD.setVisibility(0);
                this.bMD.setText(aVar.KG());
            }
            if (StringUtils.isNull(aVar.KH())) {
                this.bME.setVisibility(8);
                this.bME.setText((CharSequence) null);
                return;
            }
            this.bME.setVisibility(0);
            this.bME.setText(aVar.KH());
        }
    }

    private void setProgressGroupVisible(boolean z) {
        if (z) {
            this.bMD.setVisibility(0);
            this.bME.setVisibility(0);
            this.progressBar.setVisibility(0);
            return;
        }
        this.bMD.setVisibility(8);
        this.bME.setVisibility(8);
        this.progressBar.setVisibility(8);
    }

    public void setProgress(float f) {
        if (f >= 0.0f && this.bMB != null) {
            int KJ = (int) (this.bMB.KJ() * f);
            if (this.isSelected) {
                this.progressBar.setProgress(KJ);
                this.progressBar.setSecondaryProgress(0);
                return;
            }
            this.progressBar.setProgress(0);
            this.progressBar.setSecondaryProgress(KJ);
        }
    }

    public void onChangeSkinType(int i) {
        aj.b(this.bMF, d.C0141d.cp_cont_b, 1, i);
        aj.b(this.bMD, d.C0141d.cp_cont_g, 1, i);
        aj.b(this.bME, d.C0141d.cp_cont_g, 1, i);
        this.progressBar.setProgressDrawable(aj.au(i, d.f.vote_photo_progress_drawable));
        if (this.isSelected) {
            aj.c(this.bMG, d.f.chx_pic_add_s);
        } else {
            aj.c(this.bMG, d.f.chx_pic_add_n);
        }
    }
}
