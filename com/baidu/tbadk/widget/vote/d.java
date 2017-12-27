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
    private a bKA;
    private View.OnClickListener bKB;
    private ProgressBar bKg;
    private com.baidu.tbadk.widget.vote.a bKu;
    private TbImageView bKv;
    private TextView bKw;
    private TextView bKx;
    private TextView bKy;
    private ImageView bKz;
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
        this.bKB = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.vote.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.setSelected(!d.this.isSelected);
                if (d.this.bKA != null) {
                    d.this.bKA.b(d.this.bKu, d.this.position, d.this.isSelected);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(d.h.vote_selected_pic_item, this);
        this.bKv = (TbImageView) findViewById(d.g.vote_photo_image);
        this.bKg = (ProgressBar) findViewById(d.g.vote_photo_progress);
        this.bKw = (TextView) findViewById(d.g.vote_photo_number);
        this.bKx = (TextView) findViewById(d.g.vote_photo_percent);
        this.bKy = (TextView) findViewById(d.g.vote_photo_name);
        this.bKz = (ImageView) findViewById(d.g.vote_photo_check_image);
        this.bKv.setDrawBorder(true);
        this.bKv.setBorderColor(aj.getColor(d.C0108d.common_color_10043));
        this.bKv.setBorderWidth(getResources().getDimensionPixelSize(d.e.ds1));
        setOnClickListener(this.bKB);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View
    public void setSelected(boolean z) {
        this.isSelected = z;
        if (z) {
            aj.c(this.bKz, d.f.chx_pic_add_s);
        } else {
            aj.c(this.bKz, d.f.chx_pic_add_n);
        }
    }

    public void setOnItemCheckChangeListener(a aVar) {
        this.bKA = aVar;
    }

    public void a(com.baidu.tbadk.widget.vote.a aVar, int i, int i2, boolean z, boolean z2) {
        if (aVar != null) {
            this.isSelected = z;
            this.bKu = aVar;
            this.position = i;
            if (StringUtils.isNull(aVar.Kj())) {
                this.bKy.setVisibility(4);
                this.bKy.setText((CharSequence) null);
            } else {
                this.bKy.setVisibility(0);
                this.bKy.setText(UtilHelper.getFixedText(aVar.Kj(), 10, false));
            }
            if (i2 == 2) {
                setOnClickListener(null);
                b(aVar);
            } else if (i2 == 1 || i2 == 3) {
                setOnClickListener(this.bKB);
                cL(z);
            }
            this.bKv.startLoad(aVar.Ko(), 17, false);
        }
    }

    public void setNameVisibility(int i) {
        this.bKy.setVisibility(i);
    }

    private void cL(boolean z) {
        setProgressGroupVisible(false);
        this.bKz.setVisibility(0);
        if (z) {
            aj.c(this.bKz, d.f.chx_pic_add_s);
        } else {
            aj.c(this.bKz, d.f.chx_pic_add_n);
        }
    }

    private void b(com.baidu.tbadk.widget.vote.a aVar) {
        setProgressGroupVisible(true);
        this.bKz.setVisibility(8);
        if (aVar != null) {
            if (StringUtils.isNull(aVar.Kk())) {
                this.bKw.setVisibility(8);
                this.bKw.setText((CharSequence) null);
            } else {
                this.bKw.setVisibility(0);
                this.bKw.setText(aVar.Kk());
            }
            if (StringUtils.isNull(aVar.Kl())) {
                this.bKx.setVisibility(8);
                this.bKx.setText((CharSequence) null);
                return;
            }
            this.bKx.setVisibility(0);
            this.bKx.setText(aVar.Kl());
        }
    }

    private void setProgressGroupVisible(boolean z) {
        if (z) {
            this.bKw.setVisibility(0);
            this.bKx.setVisibility(0);
            this.bKg.setVisibility(0);
            return;
        }
        this.bKw.setVisibility(8);
        this.bKx.setVisibility(8);
        this.bKg.setVisibility(8);
    }

    public void setProgress(float f) {
        if (f >= 0.0f && this.bKu != null) {
            int Kn = (int) (this.bKu.Kn() * f);
            if (this.isSelected) {
                this.bKg.setProgress(Kn);
                this.bKg.setSecondaryProgress(0);
                return;
            }
            this.bKg.setProgress(0);
            this.bKg.setSecondaryProgress(Kn);
        }
    }

    public void onChangeSkinType(int i) {
        aj.b(this.bKy, d.C0108d.cp_cont_b, 1, i);
        aj.b(this.bKw, d.C0108d.cp_cont_g, 1, i);
        aj.b(this.bKx, d.C0108d.cp_cont_g, 1, i);
        this.bKg.setProgressDrawable(aj.au(i, d.f.vote_photo_progress_drawable));
        if (this.isSelected) {
            aj.c(this.bKz, d.f.chx_pic_add_s);
        } else {
            aj.c(this.bKz, d.f.chx_pic_add_n);
        }
    }
}
