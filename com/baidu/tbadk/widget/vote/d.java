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
    private TbImageView aTA;
    private TextView aTB;
    private TextView aTC;
    private TextView aTD;
    private ImageView aTE;
    private a aTF;
    private View.OnClickListener aTG;
    private ProgressBar aTl;
    private com.baidu.tbadk.widget.vote.a aTz;
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
        this.aTG = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.vote.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.setSelected(!d.this.isSelected);
                if (d.this.aTF != null) {
                    d.this.aTF.b(d.this.aTz, d.this.position, d.this.isSelected);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(d.j.vote_selected_pic_item, this);
        this.aTA = (TbImageView) findViewById(d.h.vote_photo_image);
        this.aTl = (ProgressBar) findViewById(d.h.vote_photo_progress);
        this.aTB = (TextView) findViewById(d.h.vote_photo_number);
        this.aTC = (TextView) findViewById(d.h.vote_photo_percent);
        this.aTD = (TextView) findViewById(d.h.vote_photo_name);
        this.aTE = (ImageView) findViewById(d.h.vote_photo_check_image);
        this.aTA.setDrawBorder(true);
        this.aTA.setBorderColor(aj.getColor(d.e.common_color_10043));
        this.aTA.setBorderWidth(getResources().getDimensionPixelSize(d.f.ds1));
        setOnClickListener(this.aTG);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View
    public void setSelected(boolean z) {
        this.isSelected = z;
        if (z) {
            aj.c(this.aTE, d.g.chx_pic_add_s);
        } else {
            aj.c(this.aTE, d.g.chx_pic_add_n);
        }
    }

    public void setOnItemCheckChangeListener(a aVar) {
        this.aTF = aVar;
    }

    public void a(com.baidu.tbadk.widget.vote.a aVar, int i, int i2, boolean z, boolean z2) {
        if (aVar != null) {
            this.isSelected = z;
            this.aTz = aVar;
            this.position = i;
            if (StringUtils.isNull(aVar.Cd())) {
                this.aTD.setVisibility(4);
                this.aTD.setText((CharSequence) null);
            } else {
                this.aTD.setVisibility(0);
                this.aTD.setText(UtilHelper.getFixedText(aVar.Cd(), 10, false));
            }
            if (i2 == 2) {
                setOnClickListener(null);
                b(aVar);
            } else if (i2 == 1 || i2 == 3) {
                setOnClickListener(this.aTG);
                ci(z);
            }
            this.aTA.c(aVar.Ci(), 17, false);
        }
    }

    public void setNameVisibility(int i) {
        this.aTD.setVisibility(i);
    }

    private void ci(boolean z) {
        setProgressGroupVisible(false);
        this.aTE.setVisibility(0);
        if (z) {
            aj.c(this.aTE, d.g.chx_pic_add_s);
        } else {
            aj.c(this.aTE, d.g.chx_pic_add_n);
        }
    }

    private void b(com.baidu.tbadk.widget.vote.a aVar) {
        setProgressGroupVisible(true);
        this.aTE.setVisibility(8);
        if (aVar != null) {
            if (StringUtils.isNull(aVar.Ce())) {
                this.aTB.setVisibility(8);
                this.aTB.setText((CharSequence) null);
            } else {
                this.aTB.setVisibility(0);
                this.aTB.setText(aVar.Ce());
            }
            if (StringUtils.isNull(aVar.Cf())) {
                this.aTC.setVisibility(8);
                this.aTC.setText((CharSequence) null);
                return;
            }
            this.aTC.setVisibility(0);
            this.aTC.setText(aVar.Cf());
        }
    }

    private void setProgressGroupVisible(boolean z) {
        if (z) {
            this.aTB.setVisibility(0);
            this.aTC.setVisibility(0);
            this.aTl.setVisibility(0);
            return;
        }
        this.aTB.setVisibility(8);
        this.aTC.setVisibility(8);
        this.aTl.setVisibility(8);
    }

    public void setProgress(float f) {
        if (f >= 0.0f && this.aTz != null) {
            int Ch = (int) (this.aTz.Ch() * f);
            if (this.isSelected) {
                this.aTl.setProgress(Ch);
                this.aTl.setSecondaryProgress(0);
                return;
            }
            this.aTl.setProgress(0);
            this.aTl.setSecondaryProgress(Ch);
        }
    }

    public void onChangeSkinType(int i) {
        aj.b(this.aTD, d.e.cp_cont_b, 1, i);
        aj.b(this.aTB, d.e.cp_cont_g, 1, i);
        aj.b(this.aTC, d.e.cp_cont_g, 1, i);
        this.aTl.setProgressDrawable(aj.u(i, d.g.vote_photo_progress_drawable));
        if (this.isSelected) {
            aj.c(this.aTE, d.g.chx_pic_add_s);
        } else {
            aj.c(this.aTE, d.g.chx_pic_add_n);
        }
    }
}
