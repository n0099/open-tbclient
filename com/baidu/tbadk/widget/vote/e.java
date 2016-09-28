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
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class e extends FrameLayout {
    private ProgressBar aJS;
    private com.baidu.tbadk.widget.vote.a aKg;
    private TbImageView aKh;
    private TextView aKi;
    private TextView aKj;
    private TextView aKk;
    private ImageView aKl;
    private View aKm;
    private a aKn;
    private View.OnClickListener aKo;
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
        this.aKo = new f(this);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(r.h.vote_selected_pic_item, this);
        this.aKh = (TbImageView) findViewById(r.g.vote_photo_image);
        this.aJS = (ProgressBar) findViewById(r.g.vote_photo_progress);
        this.aKi = (TextView) findViewById(r.g.vote_photo_number);
        this.aKj = (TextView) findViewById(r.g.vote_photo_percent);
        this.aKk = (TextView) findViewById(r.g.vote_photo_name);
        this.aKl = (ImageView) findViewById(r.g.vote_photo_check_image);
        this.aKm = findViewById(r.g.vote_photo_frame);
        this.aKh.setDrawBorder(true);
        this.aKh.setBorderColor(av.getColor(r.d.common_color_10043));
        this.aKh.setBorderWidth(getResources().getDimensionPixelSize(r.e.ds1));
        setOnClickListener(this.aKo);
        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
    }

    @Override // android.view.View
    public void setSelected(boolean z) {
        this.isSelected = z;
        this.aKm.setVisibility(z ? 0 : 8);
        if (z) {
            av.c(this.aKl, r.f.btn_choose_photo_s);
        } else {
            av.c(this.aKl, r.f.btn_choose_photo_n);
        }
    }

    public void setOnItemCheckChangeListener(a aVar) {
        this.aKn = aVar;
    }

    public void a(com.baidu.tbadk.widget.vote.a aVar, int i, int i2, boolean z, boolean z2) {
        if (aVar != null) {
            this.isSelected = z;
            this.aKg = aVar;
            this.position = i;
            if (StringUtils.isNull(aVar.Cj())) {
                this.aKk.setVisibility(4);
                this.aKk.setText((CharSequence) null);
            } else {
                this.aKk.setVisibility(0);
                this.aKk.setText(UtilHelper.getFixedText(aVar.Cj(), 10, false));
            }
            if (i2 == 2) {
                setOnClickListener(null);
                b(aVar);
            } else if (i2 == 1 || i2 == 3) {
                setOnClickListener(this.aKo);
                bY(z);
            }
            this.aKm.setVisibility((z && z2) ? 0 : 8);
            this.aKh.c(aVar.Co(), 17, false);
        }
    }

    public void setNameVisibility(int i) {
        this.aKk.setVisibility(i);
    }

    private void bY(boolean z) {
        setProgressGroupVisible(false);
        this.aKl.setVisibility(0);
        av.c(this.aKl, r.f.btn_choose_photo_n);
    }

    private void b(com.baidu.tbadk.widget.vote.a aVar) {
        setProgressGroupVisible(true);
        this.aKl.setVisibility(8);
        if (aVar != null) {
            if (StringUtils.isNull(aVar.Ck())) {
                this.aKi.setVisibility(8);
                this.aKi.setText((CharSequence) null);
            } else {
                this.aKi.setVisibility(0);
                this.aKi.setText(aVar.Ck());
            }
            if (StringUtils.isNull(aVar.Cl())) {
                this.aKj.setVisibility(8);
                this.aKj.setText((CharSequence) null);
                return;
            }
            this.aKj.setVisibility(0);
            this.aKj.setText(aVar.Cl());
        }
    }

    private void setProgressGroupVisible(boolean z) {
        if (z) {
            this.aKi.setVisibility(0);
            this.aKj.setVisibility(0);
            this.aJS.setVisibility(0);
            return;
        }
        this.aKi.setVisibility(8);
        this.aKj.setVisibility(8);
        this.aJS.setVisibility(8);
    }

    public void setProgress(float f) {
        if (f >= 0.0f && this.aKg != null) {
            int Cn = (int) (this.aKg.Cn() * f);
            if (this.isSelected) {
                this.aJS.setProgress(Cn);
                this.aJS.setSecondaryProgress(0);
                return;
            }
            this.aJS.setProgress(0);
            this.aJS.setSecondaryProgress(Cn);
        }
    }

    public void onChangeSkinType(int i) {
        av.b(this.aKk, r.d.cp_cont_b, 1, i);
        av.b(this.aKi, r.d.cp_cont_g, 1, i);
        av.b(this.aKj, r.d.cp_cont_g, 1, i);
        this.aJS.setProgressDrawable(av.q(i, r.f.vote_photo_progress_drawable));
        if (this.isSelected) {
            av.c(this.aKl, r.f.btn_choose_photo_s);
        } else {
            av.c(this.aKl, r.f.btn_choose_photo_n);
        }
        av.d(this.aKm, r.f.vote_photo_frame, i);
    }
}
