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
    private com.baidu.tbadk.widget.vote.a bME;
    private TbImageView bMF;
    private TextView bMG;
    private TextView bMH;
    private TextView bMI;
    private ImageView bMJ;
    private a bMK;
    private View.OnClickListener bML;
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
        this.bML = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.vote.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.setSelected(!d.this.isSelected);
                if (d.this.bMK != null) {
                    d.this.bMK.b(d.this.bME, d.this.position, d.this.isSelected);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(d.h.vote_selected_pic_item, this);
        this.bMF = (TbImageView) findViewById(d.g.vote_photo_image);
        this.progressBar = (ProgressBar) findViewById(d.g.vote_photo_progress);
        this.bMG = (TextView) findViewById(d.g.vote_photo_number);
        this.bMH = (TextView) findViewById(d.g.vote_photo_percent);
        this.bMI = (TextView) findViewById(d.g.vote_photo_name);
        this.bMJ = (ImageView) findViewById(d.g.vote_photo_check_image);
        this.bMF.setDrawBorder(true);
        this.bMF.setBorderColor(aj.getColor(d.C0141d.common_color_10043));
        this.bMF.setBorderWidth(getResources().getDimensionPixelSize(d.e.ds1));
        setOnClickListener(this.bML);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View
    public void setSelected(boolean z) {
        this.isSelected = z;
        if (z) {
            aj.c(this.bMJ, d.f.chx_pic_add_s);
        } else {
            aj.c(this.bMJ, d.f.chx_pic_add_n);
        }
    }

    public void setOnItemCheckChangeListener(a aVar) {
        this.bMK = aVar;
    }

    public void a(com.baidu.tbadk.widget.vote.a aVar, int i, int i2, boolean z, boolean z2) {
        if (aVar != null) {
            this.isSelected = z;
            this.bME = aVar;
            this.position = i;
            if (StringUtils.isNull(aVar.KG())) {
                this.bMI.setVisibility(4);
                this.bMI.setText((CharSequence) null);
            } else {
                this.bMI.setVisibility(0);
                this.bMI.setText(UtilHelper.getFixedText(aVar.KG(), 10, false));
            }
            if (i2 == 2) {
                setOnClickListener(null);
                b(aVar);
            } else if (i2 == 1 || i2 == 3) {
                setOnClickListener(this.bML);
                cO(z);
            }
            this.bMF.startLoad(aVar.KL(), 17, false);
        }
    }

    public void setNameVisibility(int i) {
        this.bMI.setVisibility(i);
    }

    private void cO(boolean z) {
        setProgressGroupVisible(false);
        this.bMJ.setVisibility(0);
        if (z) {
            aj.c(this.bMJ, d.f.chx_pic_add_s);
        } else {
            aj.c(this.bMJ, d.f.chx_pic_add_n);
        }
    }

    private void b(com.baidu.tbadk.widget.vote.a aVar) {
        setProgressGroupVisible(true);
        this.bMJ.setVisibility(8);
        if (aVar != null) {
            if (StringUtils.isNull(aVar.KH())) {
                this.bMG.setVisibility(8);
                this.bMG.setText((CharSequence) null);
            } else {
                this.bMG.setVisibility(0);
                this.bMG.setText(aVar.KH());
            }
            if (StringUtils.isNull(aVar.KI())) {
                this.bMH.setVisibility(8);
                this.bMH.setText((CharSequence) null);
                return;
            }
            this.bMH.setVisibility(0);
            this.bMH.setText(aVar.KI());
        }
    }

    private void setProgressGroupVisible(boolean z) {
        if (z) {
            this.bMG.setVisibility(0);
            this.bMH.setVisibility(0);
            this.progressBar.setVisibility(0);
            return;
        }
        this.bMG.setVisibility(8);
        this.bMH.setVisibility(8);
        this.progressBar.setVisibility(8);
    }

    public void setProgress(float f) {
        if (f >= 0.0f && this.bME != null) {
            int KK = (int) (this.bME.KK() * f);
            if (this.isSelected) {
                this.progressBar.setProgress(KK);
                this.progressBar.setSecondaryProgress(0);
                return;
            }
            this.progressBar.setProgress(0);
            this.progressBar.setSecondaryProgress(KK);
        }
    }

    public void onChangeSkinType(int i) {
        aj.b(this.bMI, d.C0141d.cp_cont_b, 1, i);
        aj.b(this.bMG, d.C0141d.cp_cont_g, 1, i);
        aj.b(this.bMH, d.C0141d.cp_cont_g, 1, i);
        this.progressBar.setProgressDrawable(aj.au(i, d.f.vote_photo_progress_drawable));
        if (this.isSelected) {
            aj.c(this.bMJ, d.f.chx_pic_add_s);
        } else {
            aj.c(this.bMJ, d.f.chx_pic_add_n);
        }
    }
}
