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
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class e extends FrameLayout {
    private com.baidu.tbadk.widget.vote.a aKH;
    private TbImageView aKI;
    private TextView aKJ;
    private TextView aKK;
    private TextView aKL;
    private ImageView aKM;
    private View aKN;
    private a aKO;
    private View.OnClickListener aKP;
    private ProgressBar aKt;
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
        this.aKP = new f(this);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(t.h.vote_selected_pic_item, this);
        this.aKI = (TbImageView) findViewById(t.g.vote_photo_image);
        this.aKt = (ProgressBar) findViewById(t.g.vote_photo_progress);
        this.aKJ = (TextView) findViewById(t.g.vote_photo_number);
        this.aKK = (TextView) findViewById(t.g.vote_photo_percent);
        this.aKL = (TextView) findViewById(t.g.vote_photo_name);
        this.aKM = (ImageView) findViewById(t.g.vote_photo_check_image);
        this.aKN = findViewById(t.g.vote_photo_frame);
        this.aKI.setDrawBorder(true);
        this.aKI.setBorderColor(av.getColor(t.d.common_color_10043));
        this.aKI.setBorderWidth(getResources().getDimensionPixelSize(t.e.ds1));
        setOnClickListener(this.aKP);
        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
    }

    @Override // android.view.View
    public void setSelected(boolean z) {
        this.isSelected = z;
        this.aKN.setVisibility(z ? 0 : 8);
        if (z) {
            av.c(this.aKM, t.f.btn_choose_photo_s);
        } else {
            av.c(this.aKM, t.f.btn_choose_photo_n);
        }
    }

    public void setOnItemCheckChangeListener(a aVar) {
        this.aKO = aVar;
    }

    public void a(com.baidu.tbadk.widget.vote.a aVar, int i, int i2, boolean z) {
        if (aVar != null) {
            this.isSelected = z;
            this.aKH = aVar;
            this.position = i;
            if (StringUtils.isNull(aVar.Cg())) {
                this.aKL.setVisibility(4);
                this.aKL.setText((CharSequence) null);
            } else {
                this.aKL.setVisibility(0);
                this.aKL.setText(UtilHelper.getFixedText(aVar.Cg(), 10, false));
            }
            if (i2 == 2) {
                setOnClickListener(null);
                b(aVar);
            } else if (i2 == 1 || i2 == 3) {
                setOnClickListener(this.aKP);
                bZ(z);
            }
            this.aKN.setVisibility(z ? 0 : 8);
            this.aKI.c(aVar.Cl(), 17, false);
        }
    }

    public void setNameVisibility(int i) {
        this.aKL.setVisibility(i);
    }

    private void bZ(boolean z) {
        setProgressGroupVisible(false);
        this.aKM.setVisibility(0);
        if (z) {
            av.c(this.aKM, t.f.vote_text_check_box);
        } else {
            av.c(this.aKM, t.f.btn_choose_photo_n);
        }
    }

    private void b(com.baidu.tbadk.widget.vote.a aVar) {
        setProgressGroupVisible(true);
        this.aKM.setVisibility(8);
        if (aVar != null) {
            if (StringUtils.isNull(aVar.Ch())) {
                this.aKJ.setVisibility(8);
                this.aKJ.setText((CharSequence) null);
            } else {
                this.aKJ.setVisibility(0);
                this.aKJ.setText(aVar.Ch());
            }
            if (StringUtils.isNull(aVar.Ci())) {
                this.aKK.setVisibility(8);
                this.aKK.setText((CharSequence) null);
                return;
            }
            this.aKK.setVisibility(0);
            this.aKK.setText(aVar.Ci());
        }
    }

    private void setProgressGroupVisible(boolean z) {
        if (z) {
            this.aKJ.setVisibility(0);
            this.aKK.setVisibility(0);
            this.aKt.setVisibility(0);
            return;
        }
        this.aKJ.setVisibility(8);
        this.aKK.setVisibility(8);
        this.aKt.setVisibility(8);
    }

    public void setProgress(float f) {
        if (f >= 0.0f && this.aKH != null) {
            int Ck = (int) (this.aKH.Ck() * f);
            if (this.isSelected) {
                this.aKt.setProgress(Ck);
                this.aKt.setSecondaryProgress(0);
                return;
            }
            this.aKt.setProgress(0);
            this.aKt.setSecondaryProgress(Ck);
        }
    }

    public void onChangeSkinType(int i) {
        av.b(this.aKL, t.d.cp_cont_b, 1, i);
        av.b(this.aKJ, t.d.cp_cont_g, 1, i);
        av.b(this.aKK, t.d.cp_cont_g, 1, i);
        this.aKt.setProgressDrawable(av.q(i, t.f.vote_photo_progress_drawable));
        if (this.isSelected) {
            av.c(this.aKM, t.f.btn_choose_photo_s);
        } else {
            av.c(this.aKM, t.f.btn_choose_photo_n);
        }
        av.d(this.aKN, t.f.vote_photo_frame, i);
    }
}
