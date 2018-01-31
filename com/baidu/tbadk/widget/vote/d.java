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
    private com.baidu.tbadk.widget.vote.a bKK;
    private TbImageView bKL;
    private TextView bKM;
    private TextView bKN;
    private TextView bKO;
    private ImageView bKP;
    private a bKQ;
    private View.OnClickListener bKR;
    private ProgressBar bKw;
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
        this.bKR = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.vote.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.setSelected(!d.this.isSelected);
                if (d.this.bKQ != null) {
                    d.this.bKQ.b(d.this.bKK, d.this.position, d.this.isSelected);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(d.h.vote_selected_pic_item, this);
        this.bKL = (TbImageView) findViewById(d.g.vote_photo_image);
        this.bKw = (ProgressBar) findViewById(d.g.vote_photo_progress);
        this.bKM = (TextView) findViewById(d.g.vote_photo_number);
        this.bKN = (TextView) findViewById(d.g.vote_photo_percent);
        this.bKO = (TextView) findViewById(d.g.vote_photo_name);
        this.bKP = (ImageView) findViewById(d.g.vote_photo_check_image);
        this.bKL.setDrawBorder(true);
        this.bKL.setBorderColor(aj.getColor(d.C0108d.common_color_10043));
        this.bKL.setBorderWidth(getResources().getDimensionPixelSize(d.e.ds1));
        setOnClickListener(this.bKR);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View
    public void setSelected(boolean z) {
        this.isSelected = z;
        if (z) {
            aj.c(this.bKP, d.f.chx_pic_add_s);
        } else {
            aj.c(this.bKP, d.f.chx_pic_add_n);
        }
    }

    public void setOnItemCheckChangeListener(a aVar) {
        this.bKQ = aVar;
    }

    public void a(com.baidu.tbadk.widget.vote.a aVar, int i, int i2, boolean z, boolean z2) {
        if (aVar != null) {
            this.isSelected = z;
            this.bKK = aVar;
            this.position = i;
            if (StringUtils.isNull(aVar.Ka())) {
                this.bKO.setVisibility(4);
                this.bKO.setText((CharSequence) null);
            } else {
                this.bKO.setVisibility(0);
                this.bKO.setText(UtilHelper.getFixedText(aVar.Ka(), 10, false));
            }
            if (i2 == 2) {
                setOnClickListener(null);
                b(aVar);
            } else if (i2 == 1 || i2 == 3) {
                setOnClickListener(this.bKR);
                cK(z);
            }
            this.bKL.startLoad(aVar.Kf(), 17, false);
        }
    }

    public void setNameVisibility(int i) {
        this.bKO.setVisibility(i);
    }

    private void cK(boolean z) {
        setProgressGroupVisible(false);
        this.bKP.setVisibility(0);
        if (z) {
            aj.c(this.bKP, d.f.chx_pic_add_s);
        } else {
            aj.c(this.bKP, d.f.chx_pic_add_n);
        }
    }

    private void b(com.baidu.tbadk.widget.vote.a aVar) {
        setProgressGroupVisible(true);
        this.bKP.setVisibility(8);
        if (aVar != null) {
            if (StringUtils.isNull(aVar.Kb())) {
                this.bKM.setVisibility(8);
                this.bKM.setText((CharSequence) null);
            } else {
                this.bKM.setVisibility(0);
                this.bKM.setText(aVar.Kb());
            }
            if (StringUtils.isNull(aVar.Kc())) {
                this.bKN.setVisibility(8);
                this.bKN.setText((CharSequence) null);
                return;
            }
            this.bKN.setVisibility(0);
            this.bKN.setText(aVar.Kc());
        }
    }

    private void setProgressGroupVisible(boolean z) {
        if (z) {
            this.bKM.setVisibility(0);
            this.bKN.setVisibility(0);
            this.bKw.setVisibility(0);
            return;
        }
        this.bKM.setVisibility(8);
        this.bKN.setVisibility(8);
        this.bKw.setVisibility(8);
    }

    public void setProgress(float f) {
        if (f >= 0.0f && this.bKK != null) {
            int Ke = (int) (this.bKK.Ke() * f);
            if (this.isSelected) {
                this.bKw.setProgress(Ke);
                this.bKw.setSecondaryProgress(0);
                return;
            }
            this.bKw.setProgress(0);
            this.bKw.setSecondaryProgress(Ke);
        }
    }

    public void onChangeSkinType(int i) {
        aj.b(this.bKO, d.C0108d.cp_cont_b, 1, i);
        aj.b(this.bKM, d.C0108d.cp_cont_g, 1, i);
        aj.b(this.bKN, d.C0108d.cp_cont_g, 1, i);
        this.bKw.setProgressDrawable(aj.au(i, d.f.vote_photo_progress_drawable));
        if (this.isSelected) {
            aj.c(this.bKP, d.f.chx_pic_add_s);
        } else {
            aj.c(this.bKP, d.f.chx_pic_add_n);
        }
    }
}
