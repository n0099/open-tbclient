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
    private com.baidu.tbadk.widget.vote.a aWF;
    private TbImageView aWG;
    private TextView aWH;
    private TextView aWI;
    private TextView aWJ;
    private ImageView aWK;
    private a aWL;
    private View.OnClickListener aWM;
    private ProgressBar aWr;
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
        this.aWM = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.vote.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.setSelected(!d.this.isSelected);
                if (d.this.aWL != null) {
                    d.this.aWL.b(d.this.aWF, d.this.position, d.this.isSelected);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(d.h.vote_selected_pic_item, this);
        this.aWG = (TbImageView) findViewById(d.g.vote_photo_image);
        this.aWr = (ProgressBar) findViewById(d.g.vote_photo_progress);
        this.aWH = (TextView) findViewById(d.g.vote_photo_number);
        this.aWI = (TextView) findViewById(d.g.vote_photo_percent);
        this.aWJ = (TextView) findViewById(d.g.vote_photo_name);
        this.aWK = (ImageView) findViewById(d.g.vote_photo_check_image);
        this.aWG.setDrawBorder(true);
        this.aWG.setBorderColor(aj.getColor(d.C0095d.common_color_10043));
        this.aWG.setBorderWidth(getResources().getDimensionPixelSize(d.e.ds1));
        setOnClickListener(this.aWM);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View
    public void setSelected(boolean z) {
        this.isSelected = z;
        if (z) {
            aj.c(this.aWK, d.f.chx_pic_add_s);
        } else {
            aj.c(this.aWK, d.f.chx_pic_add_n);
        }
    }

    public void setOnItemCheckChangeListener(a aVar) {
        this.aWL = aVar;
    }

    public void a(com.baidu.tbadk.widget.vote.a aVar, int i, int i2, boolean z, boolean z2) {
        if (aVar != null) {
            this.isSelected = z;
            this.aWF = aVar;
            this.position = i;
            if (StringUtils.isNull(aVar.CI())) {
                this.aWJ.setVisibility(4);
                this.aWJ.setText((CharSequence) null);
            } else {
                this.aWJ.setVisibility(0);
                this.aWJ.setText(UtilHelper.getFixedText(aVar.CI(), 10, false));
            }
            if (i2 == 2) {
                setOnClickListener(null);
                b(aVar);
            } else if (i2 == 1 || i2 == 3) {
                setOnClickListener(this.aWM);
                ci(z);
            }
            this.aWG.startLoad(aVar.CN(), 17, false);
        }
    }

    public void setNameVisibility(int i) {
        this.aWJ.setVisibility(i);
    }

    private void ci(boolean z) {
        setProgressGroupVisible(false);
        this.aWK.setVisibility(0);
        if (z) {
            aj.c(this.aWK, d.f.chx_pic_add_s);
        } else {
            aj.c(this.aWK, d.f.chx_pic_add_n);
        }
    }

    private void b(com.baidu.tbadk.widget.vote.a aVar) {
        setProgressGroupVisible(true);
        this.aWK.setVisibility(8);
        if (aVar != null) {
            if (StringUtils.isNull(aVar.CJ())) {
                this.aWH.setVisibility(8);
                this.aWH.setText((CharSequence) null);
            } else {
                this.aWH.setVisibility(0);
                this.aWH.setText(aVar.CJ());
            }
            if (StringUtils.isNull(aVar.CK())) {
                this.aWI.setVisibility(8);
                this.aWI.setText((CharSequence) null);
                return;
            }
            this.aWI.setVisibility(0);
            this.aWI.setText(aVar.CK());
        }
    }

    private void setProgressGroupVisible(boolean z) {
        if (z) {
            this.aWH.setVisibility(0);
            this.aWI.setVisibility(0);
            this.aWr.setVisibility(0);
            return;
        }
        this.aWH.setVisibility(8);
        this.aWI.setVisibility(8);
        this.aWr.setVisibility(8);
    }

    public void setProgress(float f) {
        if (f >= 0.0f && this.aWF != null) {
            int CM = (int) (this.aWF.CM() * f);
            if (this.isSelected) {
                this.aWr.setProgress(CM);
                this.aWr.setSecondaryProgress(0);
                return;
            }
            this.aWr.setProgress(0);
            this.aWr.setSecondaryProgress(CM);
        }
    }

    public void onChangeSkinType(int i) {
        aj.b(this.aWJ, d.C0095d.cp_cont_b, 1, i);
        aj.b(this.aWH, d.C0095d.cp_cont_g, 1, i);
        aj.b(this.aWI, d.C0095d.cp_cont_g, 1, i);
        this.aWr.setProgressDrawable(aj.v(i, d.f.vote_photo_progress_drawable));
        if (this.isSelected) {
            aj.c(this.aWK, d.f.chx_pic_add_s);
        } else {
            aj.c(this.aWK, d.f.chx_pic_add_n);
        }
    }
}
