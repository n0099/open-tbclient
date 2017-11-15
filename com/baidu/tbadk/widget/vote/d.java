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
    private TextView aTA;
    private TextView aTB;
    private TextView aTC;
    private ImageView aTD;
    private a aTE;
    private View.OnClickListener aTF;
    private ProgressBar aTk;
    private com.baidu.tbadk.widget.vote.a aTy;
    private TbImageView aTz;
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
        this.aTF = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.vote.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.setSelected(!d.this.isSelected);
                if (d.this.aTE != null) {
                    d.this.aTE.b(d.this.aTy, d.this.position, d.this.isSelected);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(d.h.vote_selected_pic_item, this);
        this.aTz = (TbImageView) findViewById(d.g.vote_photo_image);
        this.aTk = (ProgressBar) findViewById(d.g.vote_photo_progress);
        this.aTA = (TextView) findViewById(d.g.vote_photo_number);
        this.aTB = (TextView) findViewById(d.g.vote_photo_percent);
        this.aTC = (TextView) findViewById(d.g.vote_photo_name);
        this.aTD = (ImageView) findViewById(d.g.vote_photo_check_image);
        this.aTz.setDrawBorder(true);
        this.aTz.setBorderColor(aj.getColor(d.C0080d.common_color_10043));
        this.aTz.setBorderWidth(getResources().getDimensionPixelSize(d.e.ds1));
        setOnClickListener(this.aTF);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View
    public void setSelected(boolean z) {
        this.isSelected = z;
        if (z) {
            aj.c(this.aTD, d.f.chx_pic_add_s);
        } else {
            aj.c(this.aTD, d.f.chx_pic_add_n);
        }
    }

    public void setOnItemCheckChangeListener(a aVar) {
        this.aTE = aVar;
    }

    public void a(com.baidu.tbadk.widget.vote.a aVar, int i, int i2, boolean z, boolean z2) {
        if (aVar != null) {
            this.isSelected = z;
            this.aTy = aVar;
            this.position = i;
            if (StringUtils.isNull(aVar.Cy())) {
                this.aTC.setVisibility(4);
                this.aTC.setText((CharSequence) null);
            } else {
                this.aTC.setVisibility(0);
                this.aTC.setText(UtilHelper.getFixedText(aVar.Cy(), 10, false));
            }
            if (i2 == 2) {
                setOnClickListener(null);
                b(aVar);
            } else if (i2 == 1 || i2 == 3) {
                setOnClickListener(this.aTF);
                ce(z);
            }
            this.aTz.startLoad(aVar.CD(), 17, false);
        }
    }

    public void setNameVisibility(int i) {
        this.aTC.setVisibility(i);
    }

    private void ce(boolean z) {
        setProgressGroupVisible(false);
        this.aTD.setVisibility(0);
        if (z) {
            aj.c(this.aTD, d.f.chx_pic_add_s);
        } else {
            aj.c(this.aTD, d.f.chx_pic_add_n);
        }
    }

    private void b(com.baidu.tbadk.widget.vote.a aVar) {
        setProgressGroupVisible(true);
        this.aTD.setVisibility(8);
        if (aVar != null) {
            if (StringUtils.isNull(aVar.Cz())) {
                this.aTA.setVisibility(8);
                this.aTA.setText((CharSequence) null);
            } else {
                this.aTA.setVisibility(0);
                this.aTA.setText(aVar.Cz());
            }
            if (StringUtils.isNull(aVar.CA())) {
                this.aTB.setVisibility(8);
                this.aTB.setText((CharSequence) null);
                return;
            }
            this.aTB.setVisibility(0);
            this.aTB.setText(aVar.CA());
        }
    }

    private void setProgressGroupVisible(boolean z) {
        if (z) {
            this.aTA.setVisibility(0);
            this.aTB.setVisibility(0);
            this.aTk.setVisibility(0);
            return;
        }
        this.aTA.setVisibility(8);
        this.aTB.setVisibility(8);
        this.aTk.setVisibility(8);
    }

    public void setProgress(float f) {
        if (f >= 0.0f && this.aTy != null) {
            int CC = (int) (this.aTy.CC() * f);
            if (this.isSelected) {
                this.aTk.setProgress(CC);
                this.aTk.setSecondaryProgress(0);
                return;
            }
            this.aTk.setProgress(0);
            this.aTk.setSecondaryProgress(CC);
        }
    }

    public void onChangeSkinType(int i) {
        aj.b(this.aTC, d.C0080d.cp_cont_b, 1, i);
        aj.b(this.aTA, d.C0080d.cp_cont_g, 1, i);
        aj.b(this.aTB, d.C0080d.cp_cont_g, 1, i);
        this.aTk.setProgressDrawable(aj.u(i, d.f.vote_photo_progress_drawable));
        if (this.isSelected) {
            aj.c(this.aTD, d.f.chx_pic_add_s);
        } else {
            aj.c(this.aTD, d.f.chx_pic_add_n);
        }
    }
}
