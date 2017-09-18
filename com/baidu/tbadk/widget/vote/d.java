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
    private com.baidu.tbadk.widget.vote.a aSA;
    private TbImageView aSB;
    private TextView aSC;
    private TextView aSD;
    private TextView aSE;
    private ImageView aSF;
    private a aSG;
    private View.OnClickListener aSH;
    private ProgressBar aSm;
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
        this.aSH = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.vote.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.setSelected(!d.this.isSelected);
                if (d.this.aSG != null) {
                    d.this.aSG.b(d.this.aSA, d.this.position, d.this.isSelected);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(d.j.vote_selected_pic_item, this);
        this.aSB = (TbImageView) findViewById(d.h.vote_photo_image);
        this.aSm = (ProgressBar) findViewById(d.h.vote_photo_progress);
        this.aSC = (TextView) findViewById(d.h.vote_photo_number);
        this.aSD = (TextView) findViewById(d.h.vote_photo_percent);
        this.aSE = (TextView) findViewById(d.h.vote_photo_name);
        this.aSF = (ImageView) findViewById(d.h.vote_photo_check_image);
        this.aSB.setDrawBorder(true);
        this.aSB.setBorderColor(aj.getColor(d.e.common_color_10043));
        this.aSB.setBorderWidth(getResources().getDimensionPixelSize(d.f.ds1));
        setOnClickListener(this.aSH);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View
    public void setSelected(boolean z) {
        this.isSelected = z;
        if (z) {
            aj.c(this.aSF, d.g.chx_pic_add_s);
        } else {
            aj.c(this.aSF, d.g.chx_pic_add_n);
        }
    }

    public void setOnItemCheckChangeListener(a aVar) {
        this.aSG = aVar;
    }

    public void a(com.baidu.tbadk.widget.vote.a aVar, int i, int i2, boolean z, boolean z2) {
        if (aVar != null) {
            this.isSelected = z;
            this.aSA = aVar;
            this.position = i;
            if (StringUtils.isNull(aVar.Cz())) {
                this.aSE.setVisibility(4);
                this.aSE.setText((CharSequence) null);
            } else {
                this.aSE.setVisibility(0);
                this.aSE.setText(UtilHelper.getFixedText(aVar.Cz(), 10, false));
            }
            if (i2 == 2) {
                setOnClickListener(null);
                b(aVar);
            } else if (i2 == 1 || i2 == 3) {
                setOnClickListener(this.aSH);
                cj(z);
            }
            this.aSB.c(aVar.CE(), 17, false);
        }
    }

    public void setNameVisibility(int i) {
        this.aSE.setVisibility(i);
    }

    private void cj(boolean z) {
        setProgressGroupVisible(false);
        this.aSF.setVisibility(0);
        if (z) {
            aj.c(this.aSF, d.g.chx_pic_add_s);
        } else {
            aj.c(this.aSF, d.g.chx_pic_add_n);
        }
    }

    private void b(com.baidu.tbadk.widget.vote.a aVar) {
        setProgressGroupVisible(true);
        this.aSF.setVisibility(8);
        if (aVar != null) {
            if (StringUtils.isNull(aVar.CA())) {
                this.aSC.setVisibility(8);
                this.aSC.setText((CharSequence) null);
            } else {
                this.aSC.setVisibility(0);
                this.aSC.setText(aVar.CA());
            }
            if (StringUtils.isNull(aVar.CB())) {
                this.aSD.setVisibility(8);
                this.aSD.setText((CharSequence) null);
                return;
            }
            this.aSD.setVisibility(0);
            this.aSD.setText(aVar.CB());
        }
    }

    private void setProgressGroupVisible(boolean z) {
        if (z) {
            this.aSC.setVisibility(0);
            this.aSD.setVisibility(0);
            this.aSm.setVisibility(0);
            return;
        }
        this.aSC.setVisibility(8);
        this.aSD.setVisibility(8);
        this.aSm.setVisibility(8);
    }

    public void setProgress(float f) {
        if (f >= 0.0f && this.aSA != null) {
            int CD = (int) (this.aSA.CD() * f);
            if (this.isSelected) {
                this.aSm.setProgress(CD);
                this.aSm.setSecondaryProgress(0);
                return;
            }
            this.aSm.setProgress(0);
            this.aSm.setSecondaryProgress(CD);
        }
    }

    public void onChangeSkinType(int i) {
        aj.b(this.aSE, d.e.cp_cont_b, 1, i);
        aj.b(this.aSC, d.e.cp_cont_g, 1, i);
        aj.b(this.aSD, d.e.cp_cont_g, 1, i);
        this.aSm.setProgressDrawable(aj.u(i, d.g.vote_photo_progress_drawable));
        if (this.isSelected) {
            aj.c(this.aSF, d.g.chx_pic_add_s);
        } else {
            aj.c(this.aSF, d.g.chx_pic_add_n);
        }
    }
}
