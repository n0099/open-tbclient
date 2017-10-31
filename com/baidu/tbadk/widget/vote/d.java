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
    private ProgressBar aTc;
    private com.baidu.tbadk.widget.vote.a aTq;
    private TbImageView aTr;
    private TextView aTs;
    private TextView aTt;
    private TextView aTu;
    private ImageView aTv;
    private a aTw;
    private View.OnClickListener aTx;
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
        this.aTx = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.vote.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.setSelected(!d.this.isSelected);
                if (d.this.aTw != null) {
                    d.this.aTw.b(d.this.aTq, d.this.position, d.this.isSelected);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(d.h.vote_selected_pic_item, this);
        this.aTr = (TbImageView) findViewById(d.g.vote_photo_image);
        this.aTc = (ProgressBar) findViewById(d.g.vote_photo_progress);
        this.aTs = (TextView) findViewById(d.g.vote_photo_number);
        this.aTt = (TextView) findViewById(d.g.vote_photo_percent);
        this.aTu = (TextView) findViewById(d.g.vote_photo_name);
        this.aTv = (ImageView) findViewById(d.g.vote_photo_check_image);
        this.aTr.setDrawBorder(true);
        this.aTr.setBorderColor(aj.getColor(d.C0080d.common_color_10043));
        this.aTr.setBorderWidth(getResources().getDimensionPixelSize(d.e.ds1));
        setOnClickListener(this.aTx);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View
    public void setSelected(boolean z) {
        this.isSelected = z;
        if (z) {
            aj.c(this.aTv, d.f.chx_pic_add_s);
        } else {
            aj.c(this.aTv, d.f.chx_pic_add_n);
        }
    }

    public void setOnItemCheckChangeListener(a aVar) {
        this.aTw = aVar;
    }

    public void a(com.baidu.tbadk.widget.vote.a aVar, int i, int i2, boolean z, boolean z2) {
        if (aVar != null) {
            this.isSelected = z;
            this.aTq = aVar;
            this.position = i;
            if (StringUtils.isNull(aVar.Cm())) {
                this.aTu.setVisibility(4);
                this.aTu.setText((CharSequence) null);
            } else {
                this.aTu.setVisibility(0);
                this.aTu.setText(UtilHelper.getFixedText(aVar.Cm(), 10, false));
            }
            if (i2 == 2) {
                setOnClickListener(null);
                b(aVar);
            } else if (i2 == 1 || i2 == 3) {
                setOnClickListener(this.aTx);
                cd(z);
            }
            this.aTr.startLoad(aVar.Cr(), 17, false);
        }
    }

    public void setNameVisibility(int i) {
        this.aTu.setVisibility(i);
    }

    private void cd(boolean z) {
        setProgressGroupVisible(false);
        this.aTv.setVisibility(0);
        if (z) {
            aj.c(this.aTv, d.f.chx_pic_add_s);
        } else {
            aj.c(this.aTv, d.f.chx_pic_add_n);
        }
    }

    private void b(com.baidu.tbadk.widget.vote.a aVar) {
        setProgressGroupVisible(true);
        this.aTv.setVisibility(8);
        if (aVar != null) {
            if (StringUtils.isNull(aVar.Cn())) {
                this.aTs.setVisibility(8);
                this.aTs.setText((CharSequence) null);
            } else {
                this.aTs.setVisibility(0);
                this.aTs.setText(aVar.Cn());
            }
            if (StringUtils.isNull(aVar.Co())) {
                this.aTt.setVisibility(8);
                this.aTt.setText((CharSequence) null);
                return;
            }
            this.aTt.setVisibility(0);
            this.aTt.setText(aVar.Co());
        }
    }

    private void setProgressGroupVisible(boolean z) {
        if (z) {
            this.aTs.setVisibility(0);
            this.aTt.setVisibility(0);
            this.aTc.setVisibility(0);
            return;
        }
        this.aTs.setVisibility(8);
        this.aTt.setVisibility(8);
        this.aTc.setVisibility(8);
    }

    public void setProgress(float f) {
        if (f >= 0.0f && this.aTq != null) {
            int Cq = (int) (this.aTq.Cq() * f);
            if (this.isSelected) {
                this.aTc.setProgress(Cq);
                this.aTc.setSecondaryProgress(0);
                return;
            }
            this.aTc.setProgress(0);
            this.aTc.setSecondaryProgress(Cq);
        }
    }

    public void onChangeSkinType(int i) {
        aj.b(this.aTu, d.C0080d.cp_cont_b, 1, i);
        aj.b(this.aTs, d.C0080d.cp_cont_g, 1, i);
        aj.b(this.aTt, d.C0080d.cp_cont_g, 1, i);
        this.aTc.setProgressDrawable(aj.u(i, d.f.vote_photo_progress_drawable));
        if (this.isSelected) {
            aj.c(this.aTv, d.f.chx_pic_add_s);
        } else {
            aj.c(this.aTv, d.f.chx_pic_add_n);
        }
    }
}
