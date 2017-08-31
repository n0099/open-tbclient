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
    private com.baidu.tbadk.widget.vote.a aSD;
    private TbImageView aSE;
    private TextView aSF;
    private TextView aSG;
    private TextView aSH;
    private ImageView aSI;
    private a aSJ;
    private View.OnClickListener aSK;
    private ProgressBar aSp;
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
        this.aSK = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.vote.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.setSelected(!d.this.isSelected);
                if (d.this.aSJ != null) {
                    d.this.aSJ.b(d.this.aSD, d.this.position, d.this.isSelected);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(d.j.vote_selected_pic_item, this);
        this.aSE = (TbImageView) findViewById(d.h.vote_photo_image);
        this.aSp = (ProgressBar) findViewById(d.h.vote_photo_progress);
        this.aSF = (TextView) findViewById(d.h.vote_photo_number);
        this.aSG = (TextView) findViewById(d.h.vote_photo_percent);
        this.aSH = (TextView) findViewById(d.h.vote_photo_name);
        this.aSI = (ImageView) findViewById(d.h.vote_photo_check_image);
        this.aSE.setDrawBorder(true);
        this.aSE.setBorderColor(aj.getColor(d.e.common_color_10043));
        this.aSE.setBorderWidth(getResources().getDimensionPixelSize(d.f.ds1));
        setOnClickListener(this.aSK);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View
    public void setSelected(boolean z) {
        this.isSelected = z;
        if (z) {
            aj.c(this.aSI, d.g.chx_pic_add_s);
        } else {
            aj.c(this.aSI, d.g.chx_pic_add_n);
        }
    }

    public void setOnItemCheckChangeListener(a aVar) {
        this.aSJ = aVar;
    }

    public void a(com.baidu.tbadk.widget.vote.a aVar, int i, int i2, boolean z, boolean z2) {
        if (aVar != null) {
            this.isSelected = z;
            this.aSD = aVar;
            this.position = i;
            if (StringUtils.isNull(aVar.Cz())) {
                this.aSH.setVisibility(4);
                this.aSH.setText((CharSequence) null);
            } else {
                this.aSH.setVisibility(0);
                this.aSH.setText(UtilHelper.getFixedText(aVar.Cz(), 10, false));
            }
            if (i2 == 2) {
                setOnClickListener(null);
                b(aVar);
            } else if (i2 == 1 || i2 == 3) {
                setOnClickListener(this.aSK);
                cj(z);
            }
            this.aSE.c(aVar.CE(), 17, false);
        }
    }

    public void setNameVisibility(int i) {
        this.aSH.setVisibility(i);
    }

    private void cj(boolean z) {
        setProgressGroupVisible(false);
        this.aSI.setVisibility(0);
        if (z) {
            aj.c(this.aSI, d.g.chx_pic_add_s);
        } else {
            aj.c(this.aSI, d.g.chx_pic_add_n);
        }
    }

    private void b(com.baidu.tbadk.widget.vote.a aVar) {
        setProgressGroupVisible(true);
        this.aSI.setVisibility(8);
        if (aVar != null) {
            if (StringUtils.isNull(aVar.CA())) {
                this.aSF.setVisibility(8);
                this.aSF.setText((CharSequence) null);
            } else {
                this.aSF.setVisibility(0);
                this.aSF.setText(aVar.CA());
            }
            if (StringUtils.isNull(aVar.CB())) {
                this.aSG.setVisibility(8);
                this.aSG.setText((CharSequence) null);
                return;
            }
            this.aSG.setVisibility(0);
            this.aSG.setText(aVar.CB());
        }
    }

    private void setProgressGroupVisible(boolean z) {
        if (z) {
            this.aSF.setVisibility(0);
            this.aSG.setVisibility(0);
            this.aSp.setVisibility(0);
            return;
        }
        this.aSF.setVisibility(8);
        this.aSG.setVisibility(8);
        this.aSp.setVisibility(8);
    }

    public void setProgress(float f) {
        if (f >= 0.0f && this.aSD != null) {
            int CD = (int) (this.aSD.CD() * f);
            if (this.isSelected) {
                this.aSp.setProgress(CD);
                this.aSp.setSecondaryProgress(0);
                return;
            }
            this.aSp.setProgress(0);
            this.aSp.setSecondaryProgress(CD);
        }
    }

    public void onChangeSkinType(int i) {
        aj.b(this.aSH, d.e.cp_cont_b, 1, i);
        aj.b(this.aSF, d.e.cp_cont_g, 1, i);
        aj.b(this.aSG, d.e.cp_cont_g, 1, i);
        this.aSp.setProgressDrawable(aj.u(i, d.g.vote_photo_progress_drawable));
        if (this.isSelected) {
            aj.c(this.aSI, d.g.chx_pic_add_s);
        } else {
            aj.c(this.aSI, d.g.chx_pic_add_n);
        }
    }
}
