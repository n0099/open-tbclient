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
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class d extends FrameLayout {
    private ProgressBar aSD;
    private com.baidu.tbadk.widget.vote.a aSR;
    private TbImageView aSS;
    private TextView aST;
    private TextView aSU;
    private TextView aSV;
    private ImageView aSW;
    private a aSX;
    private View.OnClickListener aSY;
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
        this.aSY = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.vote.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.setSelected(!d.this.isSelected);
                if (d.this.aSX != null) {
                    d.this.aSX.b(d.this.aSR, d.this.position, d.this.isSelected);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(d.j.vote_selected_pic_item, this);
        this.aSS = (TbImageView) findViewById(d.h.vote_photo_image);
        this.aSD = (ProgressBar) findViewById(d.h.vote_photo_progress);
        this.aST = (TextView) findViewById(d.h.vote_photo_number);
        this.aSU = (TextView) findViewById(d.h.vote_photo_percent);
        this.aSV = (TextView) findViewById(d.h.vote_photo_name);
        this.aSW = (ImageView) findViewById(d.h.vote_photo_check_image);
        this.aSS.setDrawBorder(true);
        this.aSS.setBorderColor(ai.getColor(d.e.common_color_10043));
        this.aSS.setBorderWidth(getResources().getDimensionPixelSize(d.f.ds1));
        setOnClickListener(this.aSY);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View
    public void setSelected(boolean z) {
        this.isSelected = z;
        if (z) {
            ai.c(this.aSW, d.g.chx_pic_add_s);
        } else {
            ai.c(this.aSW, d.g.chx_pic_add_n);
        }
    }

    public void setOnItemCheckChangeListener(a aVar) {
        this.aSX = aVar;
    }

    public void a(com.baidu.tbadk.widget.vote.a aVar, int i, int i2, boolean z, boolean z2) {
        if (aVar != null) {
            this.isSelected = z;
            this.aSR = aVar;
            this.position = i;
            if (StringUtils.isNull(aVar.CE())) {
                this.aSV.setVisibility(4);
                this.aSV.setText((CharSequence) null);
            } else {
                this.aSV.setVisibility(0);
                this.aSV.setText(UtilHelper.getFixedText(aVar.CE(), 10, false));
            }
            if (i2 == 2) {
                setOnClickListener(null);
                b(aVar);
            } else if (i2 == 1 || i2 == 3) {
                setOnClickListener(this.aSY);
                ci(z);
            }
            this.aSS.c(aVar.CJ(), 17, false);
        }
    }

    public void setNameVisibility(int i) {
        this.aSV.setVisibility(i);
    }

    private void ci(boolean z) {
        setProgressGroupVisible(false);
        this.aSW.setVisibility(0);
        if (z) {
            ai.c(this.aSW, d.g.chx_pic_add_s);
        } else {
            ai.c(this.aSW, d.g.chx_pic_add_n);
        }
    }

    private void b(com.baidu.tbadk.widget.vote.a aVar) {
        setProgressGroupVisible(true);
        this.aSW.setVisibility(8);
        if (aVar != null) {
            if (StringUtils.isNull(aVar.CF())) {
                this.aST.setVisibility(8);
                this.aST.setText((CharSequence) null);
            } else {
                this.aST.setVisibility(0);
                this.aST.setText(aVar.CF());
            }
            if (StringUtils.isNull(aVar.CG())) {
                this.aSU.setVisibility(8);
                this.aSU.setText((CharSequence) null);
                return;
            }
            this.aSU.setVisibility(0);
            this.aSU.setText(aVar.CG());
        }
    }

    private void setProgressGroupVisible(boolean z) {
        if (z) {
            this.aST.setVisibility(0);
            this.aSU.setVisibility(0);
            this.aSD.setVisibility(0);
            return;
        }
        this.aST.setVisibility(8);
        this.aSU.setVisibility(8);
        this.aSD.setVisibility(8);
    }

    public void setProgress(float f) {
        if (f >= 0.0f && this.aSR != null) {
            int CI = (int) (this.aSR.CI() * f);
            if (this.isSelected) {
                this.aSD.setProgress(CI);
                this.aSD.setSecondaryProgress(0);
                return;
            }
            this.aSD.setProgress(0);
            this.aSD.setSecondaryProgress(CI);
        }
    }

    public void onChangeSkinType(int i) {
        ai.b(this.aSV, d.e.cp_cont_b, 1, i);
        ai.b(this.aST, d.e.cp_cont_g, 1, i);
        ai.b(this.aSU, d.e.cp_cont_g, 1, i);
        this.aSD.setProgressDrawable(ai.v(i, d.g.vote_photo_progress_drawable));
        if (this.isSelected) {
            ai.c(this.aSW, d.g.chx_pic_add_s);
        } else {
            ai.c(this.aSW, d.g.chx_pic_add_n);
        }
    }
}
