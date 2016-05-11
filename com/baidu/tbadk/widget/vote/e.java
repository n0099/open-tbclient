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
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class e extends FrameLayout {
    private ProgressBar aFK;
    private com.baidu.tbadk.widget.vote.a aFY;
    private TbImageView aFZ;
    private TextView aGa;
    private TextView aGb;
    private TextView aGc;
    private ImageView aGd;
    private View aGe;
    private a aGf;
    private View.OnClickListener aGg;
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
        this.aGg = new f(this);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(t.h.vote_selected_pic_item, this);
        this.aFZ = (TbImageView) findViewById(t.g.vote_photo_image);
        this.aFK = (ProgressBar) findViewById(t.g.vote_photo_progress);
        this.aGa = (TextView) findViewById(t.g.vote_photo_number);
        this.aGb = (TextView) findViewById(t.g.vote_photo_percent);
        this.aGc = (TextView) findViewById(t.g.vote_photo_name);
        this.aGd = (ImageView) findViewById(t.g.vote_photo_check_image);
        this.aGe = findViewById(t.g.vote_photo_frame);
        this.aFZ.setDrawBorder(true);
        this.aFZ.setBorderColor(at.getColor(t.d.black_alpha10));
        this.aFZ.setBorderWidth(getResources().getDimensionPixelSize(t.e.ds1));
        setOnClickListener(this.aGg);
        onChangeSkinType(TbadkCoreApplication.m11getInst().getSkinType());
    }

    @Override // android.view.View
    public void setSelected(boolean z) {
        this.isSelected = z;
        this.aGe.setVisibility(z ? 0 : 8);
        if (z) {
            at.c(this.aGd, t.f.btn_choose_photo_s);
        } else {
            at.c(this.aGd, t.f.btn_choose_photo_n);
        }
    }

    public void setOnItemCheckChangeListener(a aVar) {
        this.aGf = aVar;
    }

    public void a(com.baidu.tbadk.widget.vote.a aVar, int i, int i2, boolean z) {
        if (aVar != null) {
            this.isSelected = z;
            this.aFY = aVar;
            this.position = i;
            if (StringUtils.isNull(aVar.Hu())) {
                this.aGc.setVisibility(4);
                this.aGc.setText((CharSequence) null);
            } else {
                this.aGc.setVisibility(0);
                this.aGc.setText(UtilHelper.getFixedText(aVar.Hu(), 10, false));
            }
            if (i2 == 2) {
                setOnClickListener(null);
                b(aVar);
            } else if (i2 == 1 || i2 == 3) {
                setOnClickListener(this.aGg);
                bV(z);
            }
            this.aGe.setVisibility(z ? 0 : 8);
            this.aFZ.c(aVar.Hz(), 17, false);
        }
    }

    public void setNameVisibility(int i) {
        this.aGc.setVisibility(i);
    }

    private void bV(boolean z) {
        setProgressGroupVisible(false);
        this.aGd.setVisibility(0);
        if (z) {
            at.c(this.aGd, t.f.vote_text_check_box);
        } else {
            at.c(this.aGd, t.f.btn_choose_photo_n);
        }
    }

    private void b(com.baidu.tbadk.widget.vote.a aVar) {
        setProgressGroupVisible(true);
        this.aGd.setVisibility(8);
        if (aVar != null) {
            if (StringUtils.isNull(aVar.Hv())) {
                this.aGa.setVisibility(8);
                this.aGa.setText((CharSequence) null);
            } else {
                this.aGa.setVisibility(0);
                this.aGa.setText(aVar.Hv());
            }
            if (StringUtils.isNull(aVar.Hw())) {
                this.aGb.setVisibility(8);
                this.aGb.setText((CharSequence) null);
                return;
            }
            this.aGb.setVisibility(0);
            this.aGb.setText(aVar.Hw());
        }
    }

    private void setProgressGroupVisible(boolean z) {
        if (z) {
            this.aGa.setVisibility(0);
            this.aGb.setVisibility(0);
            this.aFK.setVisibility(0);
            return;
        }
        this.aGa.setVisibility(8);
        this.aGb.setVisibility(8);
        this.aFK.setVisibility(8);
    }

    public void setProgress(float f) {
        if (f >= 0.0f && this.aFY != null) {
            int Hy = (int) (this.aFY.Hy() * f);
            if (this.isSelected) {
                this.aFK.setProgress(Hy);
                this.aFK.setSecondaryProgress(0);
                return;
            }
            this.aFK.setProgress(0);
            this.aFK.setSecondaryProgress(Hy);
        }
    }

    public void onChangeSkinType(int i) {
        at.b(this.aGc, t.d.cp_cont_b, 1, i);
        at.b(this.aGa, t.d.cp_cont_g, 1, i);
        at.b(this.aGb, t.d.cp_cont_g, 1, i);
        this.aFK.setProgressDrawable(at.o(i, t.f.vote_photo_progress_drawable));
        if (this.isSelected) {
            at.c(this.aGd, t.f.btn_choose_photo_s);
        } else {
            at.c(this.aGd, t.f.btn_choose_photo_n);
        }
        at.d(this.aGe, t.f.vote_photo_frame, i);
    }
}
