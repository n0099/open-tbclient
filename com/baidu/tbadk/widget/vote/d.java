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
    private ProgressBar aSE;
    private com.baidu.tbadk.widget.vote.a aSS;
    private TbImageView aST;
    private TextView aSU;
    private TextView aSV;
    private TextView aSW;
    private ImageView aSX;
    private a aSY;
    private View.OnClickListener aSZ;
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
        this.aSZ = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.vote.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.setSelected(!d.this.isSelected);
                if (d.this.aSY != null) {
                    d.this.aSY.b(d.this.aSS, d.this.position, d.this.isSelected);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(d.j.vote_selected_pic_item, this);
        this.aST = (TbImageView) findViewById(d.h.vote_photo_image);
        this.aSE = (ProgressBar) findViewById(d.h.vote_photo_progress);
        this.aSU = (TextView) findViewById(d.h.vote_photo_number);
        this.aSV = (TextView) findViewById(d.h.vote_photo_percent);
        this.aSW = (TextView) findViewById(d.h.vote_photo_name);
        this.aSX = (ImageView) findViewById(d.h.vote_photo_check_image);
        this.aST.setDrawBorder(true);
        this.aST.setBorderColor(ai.getColor(d.e.common_color_10043));
        this.aST.setBorderWidth(getResources().getDimensionPixelSize(d.f.ds1));
        setOnClickListener(this.aSZ);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View
    public void setSelected(boolean z) {
        this.isSelected = z;
        if (z) {
            ai.c(this.aSX, d.g.chx_pic_add_s);
        } else {
            ai.c(this.aSX, d.g.chx_pic_add_n);
        }
    }

    public void setOnItemCheckChangeListener(a aVar) {
        this.aSY = aVar;
    }

    public void a(com.baidu.tbadk.widget.vote.a aVar, int i, int i2, boolean z, boolean z2) {
        if (aVar != null) {
            this.isSelected = z;
            this.aSS = aVar;
            this.position = i;
            if (StringUtils.isNull(aVar.CE())) {
                this.aSW.setVisibility(4);
                this.aSW.setText((CharSequence) null);
            } else {
                this.aSW.setVisibility(0);
                this.aSW.setText(UtilHelper.getFixedText(aVar.CE(), 10, false));
            }
            if (i2 == 2) {
                setOnClickListener(null);
                b(aVar);
            } else if (i2 == 1 || i2 == 3) {
                setOnClickListener(this.aSZ);
                ci(z);
            }
            this.aST.c(aVar.CJ(), 17, false);
        }
    }

    public void setNameVisibility(int i) {
        this.aSW.setVisibility(i);
    }

    private void ci(boolean z) {
        setProgressGroupVisible(false);
        this.aSX.setVisibility(0);
        if (z) {
            ai.c(this.aSX, d.g.chx_pic_add_s);
        } else {
            ai.c(this.aSX, d.g.chx_pic_add_n);
        }
    }

    private void b(com.baidu.tbadk.widget.vote.a aVar) {
        setProgressGroupVisible(true);
        this.aSX.setVisibility(8);
        if (aVar != null) {
            if (StringUtils.isNull(aVar.CF())) {
                this.aSU.setVisibility(8);
                this.aSU.setText((CharSequence) null);
            } else {
                this.aSU.setVisibility(0);
                this.aSU.setText(aVar.CF());
            }
            if (StringUtils.isNull(aVar.CG())) {
                this.aSV.setVisibility(8);
                this.aSV.setText((CharSequence) null);
                return;
            }
            this.aSV.setVisibility(0);
            this.aSV.setText(aVar.CG());
        }
    }

    private void setProgressGroupVisible(boolean z) {
        if (z) {
            this.aSU.setVisibility(0);
            this.aSV.setVisibility(0);
            this.aSE.setVisibility(0);
            return;
        }
        this.aSU.setVisibility(8);
        this.aSV.setVisibility(8);
        this.aSE.setVisibility(8);
    }

    public void setProgress(float f) {
        if (f >= 0.0f && this.aSS != null) {
            int CI = (int) (this.aSS.CI() * f);
            if (this.isSelected) {
                this.aSE.setProgress(CI);
                this.aSE.setSecondaryProgress(0);
                return;
            }
            this.aSE.setProgress(0);
            this.aSE.setSecondaryProgress(CI);
        }
    }

    public void onChangeSkinType(int i) {
        ai.b(this.aSW, d.e.cp_cont_b, 1, i);
        ai.b(this.aSU, d.e.cp_cont_g, 1, i);
        ai.b(this.aSV, d.e.cp_cont_g, 1, i);
        this.aSE.setProgressDrawable(ai.v(i, d.g.vote_photo_progress_drawable));
        if (this.isSelected) {
            ai.c(this.aSX, d.g.chx_pic_add_s);
        } else {
            ai.c(this.aSX, d.g.chx_pic_add_n);
        }
    }
}
