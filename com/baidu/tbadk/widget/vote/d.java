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
    private ProgressBar aSY;
    private com.baidu.tbadk.widget.vote.a aTm;
    private TbImageView aTn;
    private TextView aTo;
    private TextView aTp;
    private TextView aTq;
    private ImageView aTr;
    private a aTs;
    private View.OnClickListener aTt;
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
        this.aTt = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.vote.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.setSelected(!d.this.isSelected);
                if (d.this.aTs != null) {
                    d.this.aTs.b(d.this.aTm, d.this.position, d.this.isSelected);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(d.j.vote_selected_pic_item, this);
        this.aTn = (TbImageView) findViewById(d.h.vote_photo_image);
        this.aSY = (ProgressBar) findViewById(d.h.vote_photo_progress);
        this.aTo = (TextView) findViewById(d.h.vote_photo_number);
        this.aTp = (TextView) findViewById(d.h.vote_photo_percent);
        this.aTq = (TextView) findViewById(d.h.vote_photo_name);
        this.aTr = (ImageView) findViewById(d.h.vote_photo_check_image);
        this.aTn.setDrawBorder(true);
        this.aTn.setBorderColor(aj.getColor(d.e.common_color_10043));
        this.aTn.setBorderWidth(getResources().getDimensionPixelSize(d.f.ds1));
        setOnClickListener(this.aTt);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View
    public void setSelected(boolean z) {
        this.isSelected = z;
        if (z) {
            aj.c(this.aTr, d.g.chx_pic_add_s);
        } else {
            aj.c(this.aTr, d.g.chx_pic_add_n);
        }
    }

    public void setOnItemCheckChangeListener(a aVar) {
        this.aTs = aVar;
    }

    public void a(com.baidu.tbadk.widget.vote.a aVar, int i, int i2, boolean z, boolean z2) {
        if (aVar != null) {
            this.isSelected = z;
            this.aTm = aVar;
            this.position = i;
            if (StringUtils.isNull(aVar.BX())) {
                this.aTq.setVisibility(4);
                this.aTq.setText((CharSequence) null);
            } else {
                this.aTq.setVisibility(0);
                this.aTq.setText(UtilHelper.getFixedText(aVar.BX(), 10, false));
            }
            if (i2 == 2) {
                setOnClickListener(null);
                b(aVar);
            } else if (i2 == 1 || i2 == 3) {
                setOnClickListener(this.aTt);
                ch(z);
            }
            this.aTn.c(aVar.Cc(), 17, false);
        }
    }

    public void setNameVisibility(int i) {
        this.aTq.setVisibility(i);
    }

    private void ch(boolean z) {
        setProgressGroupVisible(false);
        this.aTr.setVisibility(0);
        if (z) {
            aj.c(this.aTr, d.g.chx_pic_add_s);
        } else {
            aj.c(this.aTr, d.g.chx_pic_add_n);
        }
    }

    private void b(com.baidu.tbadk.widget.vote.a aVar) {
        setProgressGroupVisible(true);
        this.aTr.setVisibility(8);
        if (aVar != null) {
            if (StringUtils.isNull(aVar.BY())) {
                this.aTo.setVisibility(8);
                this.aTo.setText((CharSequence) null);
            } else {
                this.aTo.setVisibility(0);
                this.aTo.setText(aVar.BY());
            }
            if (StringUtils.isNull(aVar.BZ())) {
                this.aTp.setVisibility(8);
                this.aTp.setText((CharSequence) null);
                return;
            }
            this.aTp.setVisibility(0);
            this.aTp.setText(aVar.BZ());
        }
    }

    private void setProgressGroupVisible(boolean z) {
        if (z) {
            this.aTo.setVisibility(0);
            this.aTp.setVisibility(0);
            this.aSY.setVisibility(0);
            return;
        }
        this.aTo.setVisibility(8);
        this.aTp.setVisibility(8);
        this.aSY.setVisibility(8);
    }

    public void setProgress(float f) {
        if (f >= 0.0f && this.aTm != null) {
            int Cb = (int) (this.aTm.Cb() * f);
            if (this.isSelected) {
                this.aSY.setProgress(Cb);
                this.aSY.setSecondaryProgress(0);
                return;
            }
            this.aSY.setProgress(0);
            this.aSY.setSecondaryProgress(Cb);
        }
    }

    public void onChangeSkinType(int i) {
        aj.b(this.aTq, d.e.cp_cont_b, 1, i);
        aj.b(this.aTo, d.e.cp_cont_g, 1, i);
        aj.b(this.aTp, d.e.cp_cont_g, 1, i);
        this.aSY.setProgressDrawable(aj.u(i, d.g.vote_photo_progress_drawable));
        if (this.isSelected) {
            aj.c(this.aTr, d.g.chx_pic_add_s);
        } else {
            aj.c(this.aTr, d.g.chx_pic_add_n);
        }
    }
}
