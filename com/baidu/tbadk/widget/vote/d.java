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
    private ProgressBar aSF;
    private com.baidu.tbadk.widget.vote.a aST;
    private TbImageView aSU;
    private TextView aSV;
    private TextView aSW;
    private TextView aSX;
    private ImageView aSY;
    private a aSZ;
    private View.OnClickListener aTa;
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
        this.aTa = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.vote.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.setSelected(!d.this.isSelected);
                if (d.this.aSZ != null) {
                    d.this.aSZ.b(d.this.aST, d.this.position, d.this.isSelected);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(d.j.vote_selected_pic_item, this);
        this.aSU = (TbImageView) findViewById(d.h.vote_photo_image);
        this.aSF = (ProgressBar) findViewById(d.h.vote_photo_progress);
        this.aSV = (TextView) findViewById(d.h.vote_photo_number);
        this.aSW = (TextView) findViewById(d.h.vote_photo_percent);
        this.aSX = (TextView) findViewById(d.h.vote_photo_name);
        this.aSY = (ImageView) findViewById(d.h.vote_photo_check_image);
        this.aSU.setDrawBorder(true);
        this.aSU.setBorderColor(ai.getColor(d.e.common_color_10043));
        this.aSU.setBorderWidth(getResources().getDimensionPixelSize(d.f.ds1));
        setOnClickListener(this.aTa);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View
    public void setSelected(boolean z) {
        this.isSelected = z;
        if (z) {
            ai.c(this.aSY, d.g.chx_pic_add_s);
        } else {
            ai.c(this.aSY, d.g.chx_pic_add_n);
        }
    }

    public void setOnItemCheckChangeListener(a aVar) {
        this.aSZ = aVar;
    }

    public void a(com.baidu.tbadk.widget.vote.a aVar, int i, int i2, boolean z, boolean z2) {
        if (aVar != null) {
            this.isSelected = z;
            this.aST = aVar;
            this.position = i;
            if (StringUtils.isNull(aVar.CE())) {
                this.aSX.setVisibility(4);
                this.aSX.setText((CharSequence) null);
            } else {
                this.aSX.setVisibility(0);
                this.aSX.setText(UtilHelper.getFixedText(aVar.CE(), 10, false));
            }
            if (i2 == 2) {
                setOnClickListener(null);
                b(aVar);
            } else if (i2 == 1 || i2 == 3) {
                setOnClickListener(this.aTa);
                ci(z);
            }
            this.aSU.c(aVar.CJ(), 17, false);
        }
    }

    public void setNameVisibility(int i) {
        this.aSX.setVisibility(i);
    }

    private void ci(boolean z) {
        setProgressGroupVisible(false);
        this.aSY.setVisibility(0);
        if (z) {
            ai.c(this.aSY, d.g.chx_pic_add_s);
        } else {
            ai.c(this.aSY, d.g.chx_pic_add_n);
        }
    }

    private void b(com.baidu.tbadk.widget.vote.a aVar) {
        setProgressGroupVisible(true);
        this.aSY.setVisibility(8);
        if (aVar != null) {
            if (StringUtils.isNull(aVar.CF())) {
                this.aSV.setVisibility(8);
                this.aSV.setText((CharSequence) null);
            } else {
                this.aSV.setVisibility(0);
                this.aSV.setText(aVar.CF());
            }
            if (StringUtils.isNull(aVar.CG())) {
                this.aSW.setVisibility(8);
                this.aSW.setText((CharSequence) null);
                return;
            }
            this.aSW.setVisibility(0);
            this.aSW.setText(aVar.CG());
        }
    }

    private void setProgressGroupVisible(boolean z) {
        if (z) {
            this.aSV.setVisibility(0);
            this.aSW.setVisibility(0);
            this.aSF.setVisibility(0);
            return;
        }
        this.aSV.setVisibility(8);
        this.aSW.setVisibility(8);
        this.aSF.setVisibility(8);
    }

    public void setProgress(float f) {
        if (f >= 0.0f && this.aST != null) {
            int CI = (int) (this.aST.CI() * f);
            if (this.isSelected) {
                this.aSF.setProgress(CI);
                this.aSF.setSecondaryProgress(0);
                return;
            }
            this.aSF.setProgress(0);
            this.aSF.setSecondaryProgress(CI);
        }
    }

    public void onChangeSkinType(int i) {
        ai.b(this.aSX, d.e.cp_cont_b, 1, i);
        ai.b(this.aSV, d.e.cp_cont_g, 1, i);
        ai.b(this.aSW, d.e.cp_cont_g, 1, i);
        this.aSF.setProgressDrawable(ai.v(i, d.g.vote_photo_progress_drawable));
        if (this.isSelected) {
            ai.c(this.aSY, d.g.chx_pic_add_s);
        } else {
            ai.c(this.aSY, d.g.chx_pic_add_n);
        }
    }
}
