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
    private com.baidu.tbadk.widget.vote.a aRF;
    private TbImageView aRG;
    private TextView aRH;
    private TextView aRI;
    private TextView aRJ;
    private ImageView aRK;
    private a aRL;
    private View.OnClickListener aRM;
    private ProgressBar aRr;
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
        this.aRM = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.vote.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.setSelected(!d.this.isSelected);
                if (d.this.aRL != null) {
                    d.this.aRL.b(d.this.aRF, d.this.position, d.this.isSelected);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(d.j.vote_selected_pic_item, this);
        this.aRG = (TbImageView) findViewById(d.h.vote_photo_image);
        this.aRr = (ProgressBar) findViewById(d.h.vote_photo_progress);
        this.aRH = (TextView) findViewById(d.h.vote_photo_number);
        this.aRI = (TextView) findViewById(d.h.vote_photo_percent);
        this.aRJ = (TextView) findViewById(d.h.vote_photo_name);
        this.aRK = (ImageView) findViewById(d.h.vote_photo_check_image);
        this.aRG.setDrawBorder(true);
        this.aRG.setBorderColor(ai.getColor(d.e.common_color_10043));
        this.aRG.setBorderWidth(getResources().getDimensionPixelSize(d.f.ds1));
        setOnClickListener(this.aRM);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View
    public void setSelected(boolean z) {
        this.isSelected = z;
        if (z) {
            ai.c(this.aRK, d.g.chx_pic_add_s);
        } else {
            ai.c(this.aRK, d.g.chx_pic_add_n);
        }
    }

    public void setOnItemCheckChangeListener(a aVar) {
        this.aRL = aVar;
    }

    public void a(com.baidu.tbadk.widget.vote.a aVar, int i, int i2, boolean z, boolean z2) {
        if (aVar != null) {
            this.isSelected = z;
            this.aRF = aVar;
            this.position = i;
            if (StringUtils.isNull(aVar.Cw())) {
                this.aRJ.setVisibility(4);
                this.aRJ.setText((CharSequence) null);
            } else {
                this.aRJ.setVisibility(0);
                this.aRJ.setText(UtilHelper.getFixedText(aVar.Cw(), 10, false));
            }
            if (i2 == 2) {
                setOnClickListener(null);
                b(aVar);
            } else if (i2 == 1 || i2 == 3) {
                setOnClickListener(this.aRM);
                ci(z);
            }
            this.aRG.c(aVar.CB(), 17, false);
        }
    }

    public void setNameVisibility(int i) {
        this.aRJ.setVisibility(i);
    }

    private void ci(boolean z) {
        setProgressGroupVisible(false);
        this.aRK.setVisibility(0);
        if (z) {
            ai.c(this.aRK, d.g.chx_pic_add_s);
        } else {
            ai.c(this.aRK, d.g.chx_pic_add_n);
        }
    }

    private void b(com.baidu.tbadk.widget.vote.a aVar) {
        setProgressGroupVisible(true);
        this.aRK.setVisibility(8);
        if (aVar != null) {
            if (StringUtils.isNull(aVar.Cx())) {
                this.aRH.setVisibility(8);
                this.aRH.setText((CharSequence) null);
            } else {
                this.aRH.setVisibility(0);
                this.aRH.setText(aVar.Cx());
            }
            if (StringUtils.isNull(aVar.Cy())) {
                this.aRI.setVisibility(8);
                this.aRI.setText((CharSequence) null);
                return;
            }
            this.aRI.setVisibility(0);
            this.aRI.setText(aVar.Cy());
        }
    }

    private void setProgressGroupVisible(boolean z) {
        if (z) {
            this.aRH.setVisibility(0);
            this.aRI.setVisibility(0);
            this.aRr.setVisibility(0);
            return;
        }
        this.aRH.setVisibility(8);
        this.aRI.setVisibility(8);
        this.aRr.setVisibility(8);
    }

    public void setProgress(float f) {
        if (f >= 0.0f && this.aRF != null) {
            int CA = (int) (this.aRF.CA() * f);
            if (this.isSelected) {
                this.aRr.setProgress(CA);
                this.aRr.setSecondaryProgress(0);
                return;
            }
            this.aRr.setProgress(0);
            this.aRr.setSecondaryProgress(CA);
        }
    }

    public void onChangeSkinType(int i) {
        ai.b(this.aRJ, d.e.cp_cont_b, 1, i);
        ai.b(this.aRH, d.e.cp_cont_g, 1, i);
        ai.b(this.aRI, d.e.cp_cont_g, 1, i);
        this.aRr.setProgressDrawable(ai.u(i, d.g.vote_photo_progress_drawable));
        if (this.isSelected) {
            ai.c(this.aRK, d.g.chx_pic_add_s);
        } else {
            ai.c(this.aRK, d.g.chx_pic_add_n);
        }
    }
}
