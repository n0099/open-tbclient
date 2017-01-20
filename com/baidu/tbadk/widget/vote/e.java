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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class e extends FrameLayout {
    private ProgressBar aIJ;
    private com.baidu.tbadk.widget.vote.a aIX;
    private TbImageView aIY;
    private TextView aIZ;
    private TextView aJa;
    private TextView aJb;
    private ImageView aJc;
    private a aJd;
    private View.OnClickListener aJe;
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

    public e(Context context) {
        super(context);
        this.isSelected = false;
        this.aJe = new f(this);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(r.j.vote_selected_pic_item, this);
        this.aIY = (TbImageView) findViewById(r.h.vote_photo_image);
        this.aIJ = (ProgressBar) findViewById(r.h.vote_photo_progress);
        this.aIZ = (TextView) findViewById(r.h.vote_photo_number);
        this.aJa = (TextView) findViewById(r.h.vote_photo_percent);
        this.aJb = (TextView) findViewById(r.h.vote_photo_name);
        this.aJc = (ImageView) findViewById(r.h.vote_photo_check_image);
        this.aIY.setDrawBorder(true);
        this.aIY.setBorderColor(ap.getColor(r.e.common_color_10043));
        this.aIY.setBorderWidth(getResources().getDimensionPixelSize(r.f.ds1));
        setOnClickListener(this.aJe);
        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
    }

    @Override // android.view.View
    public void setSelected(boolean z) {
        this.isSelected = z;
        if (z) {
            ap.c(this.aJc, r.g.chx_pic_add_s);
        } else {
            ap.c(this.aJc, r.g.chx_pic_add_n);
        }
    }

    public void setOnItemCheckChangeListener(a aVar) {
        this.aJd = aVar;
    }

    public void a(com.baidu.tbadk.widget.vote.a aVar, int i, int i2, boolean z, boolean z2) {
        if (aVar != null) {
            this.isSelected = z;
            this.aIX = aVar;
            this.position = i;
            if (StringUtils.isNull(aVar.Ca())) {
                this.aJb.setVisibility(4);
                this.aJb.setText((CharSequence) null);
            } else {
                this.aJb.setVisibility(0);
                this.aJb.setText(UtilHelper.getFixedText(aVar.Ca(), 10, false));
            }
            if (i2 == 2) {
                setOnClickListener(null);
                b(aVar);
            } else if (i2 == 1 || i2 == 3) {
                setOnClickListener(this.aJe);
                cc(z);
            }
            this.aIY.c(aVar.Cf(), 17, false);
        }
    }

    public void setNameVisibility(int i) {
        this.aJb.setVisibility(i);
    }

    private void cc(boolean z) {
        setProgressGroupVisible(false);
        this.aJc.setVisibility(0);
        if (z) {
            ap.c(this.aJc, r.g.chx_pic_add_s);
        } else {
            ap.c(this.aJc, r.g.chx_pic_add_n);
        }
    }

    private void b(com.baidu.tbadk.widget.vote.a aVar) {
        setProgressGroupVisible(true);
        this.aJc.setVisibility(8);
        if (aVar != null) {
            if (StringUtils.isNull(aVar.Cb())) {
                this.aIZ.setVisibility(8);
                this.aIZ.setText((CharSequence) null);
            } else {
                this.aIZ.setVisibility(0);
                this.aIZ.setText(aVar.Cb());
            }
            if (StringUtils.isNull(aVar.Cc())) {
                this.aJa.setVisibility(8);
                this.aJa.setText((CharSequence) null);
                return;
            }
            this.aJa.setVisibility(0);
            this.aJa.setText(aVar.Cc());
        }
    }

    private void setProgressGroupVisible(boolean z) {
        if (z) {
            this.aIZ.setVisibility(0);
            this.aJa.setVisibility(0);
            this.aIJ.setVisibility(0);
            return;
        }
        this.aIZ.setVisibility(8);
        this.aJa.setVisibility(8);
        this.aIJ.setVisibility(8);
    }

    public void setProgress(float f) {
        if (f >= 0.0f && this.aIX != null) {
            int Ce = (int) (this.aIX.Ce() * f);
            if (this.isSelected) {
                this.aIJ.setProgress(Ce);
                this.aIJ.setSecondaryProgress(0);
                return;
            }
            this.aIJ.setProgress(0);
            this.aIJ.setSecondaryProgress(Ce);
        }
    }

    public void onChangeSkinType(int i) {
        ap.b(this.aJb, r.e.cp_cont_b, 1, i);
        ap.b(this.aIZ, r.e.cp_cont_g, 1, i);
        ap.b(this.aJa, r.e.cp_cont_g, 1, i);
        this.aIJ.setProgressDrawable(ap.r(i, r.g.vote_photo_progress_drawable));
        if (this.isSelected) {
            ap.c(this.aJc, r.g.chx_pic_add_s);
        } else {
            ap.c(this.aJc, r.g.chx_pic_add_n);
        }
    }
}
