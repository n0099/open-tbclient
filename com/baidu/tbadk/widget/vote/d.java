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
    private com.baidu.tbadk.widget.vote.a bKC;
    private TbImageView bKD;
    private TextView bKE;
    private TextView bKF;
    private TextView bKG;
    private ImageView bKH;
    private a bKI;
    private View.OnClickListener bKJ;
    private ProgressBar bKo;
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
        this.bKJ = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.vote.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.setSelected(!d.this.isSelected);
                if (d.this.bKI != null) {
                    d.this.bKI.b(d.this.bKC, d.this.position, d.this.isSelected);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(d.h.vote_selected_pic_item, this);
        this.bKD = (TbImageView) findViewById(d.g.vote_photo_image);
        this.bKo = (ProgressBar) findViewById(d.g.vote_photo_progress);
        this.bKE = (TextView) findViewById(d.g.vote_photo_number);
        this.bKF = (TextView) findViewById(d.g.vote_photo_percent);
        this.bKG = (TextView) findViewById(d.g.vote_photo_name);
        this.bKH = (ImageView) findViewById(d.g.vote_photo_check_image);
        this.bKD.setDrawBorder(true);
        this.bKD.setBorderColor(aj.getColor(d.C0107d.common_color_10043));
        this.bKD.setBorderWidth(getResources().getDimensionPixelSize(d.e.ds1));
        setOnClickListener(this.bKJ);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View
    public void setSelected(boolean z) {
        this.isSelected = z;
        if (z) {
            aj.c(this.bKH, d.f.chx_pic_add_s);
        } else {
            aj.c(this.bKH, d.f.chx_pic_add_n);
        }
    }

    public void setOnItemCheckChangeListener(a aVar) {
        this.bKI = aVar;
    }

    public void a(com.baidu.tbadk.widget.vote.a aVar, int i, int i2, boolean z, boolean z2) {
        if (aVar != null) {
            this.isSelected = z;
            this.bKC = aVar;
            this.position = i;
            if (StringUtils.isNull(aVar.JY())) {
                this.bKG.setVisibility(4);
                this.bKG.setText((CharSequence) null);
            } else {
                this.bKG.setVisibility(0);
                this.bKG.setText(UtilHelper.getFixedText(aVar.JY(), 10, false));
            }
            if (i2 == 2) {
                setOnClickListener(null);
                b(aVar);
            } else if (i2 == 1 || i2 == 3) {
                setOnClickListener(this.bKJ);
                cJ(z);
            }
            this.bKD.startLoad(aVar.Kd(), 17, false);
        }
    }

    public void setNameVisibility(int i) {
        this.bKG.setVisibility(i);
    }

    private void cJ(boolean z) {
        setProgressGroupVisible(false);
        this.bKH.setVisibility(0);
        if (z) {
            aj.c(this.bKH, d.f.chx_pic_add_s);
        } else {
            aj.c(this.bKH, d.f.chx_pic_add_n);
        }
    }

    private void b(com.baidu.tbadk.widget.vote.a aVar) {
        setProgressGroupVisible(true);
        this.bKH.setVisibility(8);
        if (aVar != null) {
            if (StringUtils.isNull(aVar.JZ())) {
                this.bKE.setVisibility(8);
                this.bKE.setText((CharSequence) null);
            } else {
                this.bKE.setVisibility(0);
                this.bKE.setText(aVar.JZ());
            }
            if (StringUtils.isNull(aVar.Ka())) {
                this.bKF.setVisibility(8);
                this.bKF.setText((CharSequence) null);
                return;
            }
            this.bKF.setVisibility(0);
            this.bKF.setText(aVar.Ka());
        }
    }

    private void setProgressGroupVisible(boolean z) {
        if (z) {
            this.bKE.setVisibility(0);
            this.bKF.setVisibility(0);
            this.bKo.setVisibility(0);
            return;
        }
        this.bKE.setVisibility(8);
        this.bKF.setVisibility(8);
        this.bKo.setVisibility(8);
    }

    public void setProgress(float f) {
        if (f >= 0.0f && this.bKC != null) {
            int Kc = (int) (this.bKC.Kc() * f);
            if (this.isSelected) {
                this.bKo.setProgress(Kc);
                this.bKo.setSecondaryProgress(0);
                return;
            }
            this.bKo.setProgress(0);
            this.bKo.setSecondaryProgress(Kc);
        }
    }

    public void onChangeSkinType(int i) {
        aj.b(this.bKG, d.C0107d.cp_cont_b, 1, i);
        aj.b(this.bKE, d.C0107d.cp_cont_g, 1, i);
        aj.b(this.bKF, d.C0107d.cp_cont_g, 1, i);
        this.bKo.setProgressDrawable(aj.au(i, d.f.vote_photo_progress_drawable));
        if (this.isSelected) {
            aj.c(this.bKH, d.f.chx_pic_add_s);
        } else {
            aj.c(this.bKH, d.f.chx_pic_add_n);
        }
    }
}
