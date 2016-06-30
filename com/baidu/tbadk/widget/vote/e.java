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
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class e extends FrameLayout {
    private com.baidu.tbadk.widget.vote.a aGA;
    private TbImageView aGB;
    private TextView aGC;
    private TextView aGD;
    private TextView aGE;
    private ImageView aGF;
    private View aGG;
    private a aGH;
    private View.OnClickListener aGI;
    private ProgressBar aGm;
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
        this.aGI = new f(this);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(u.h.vote_selected_pic_item, this);
        this.aGB = (TbImageView) findViewById(u.g.vote_photo_image);
        this.aGm = (ProgressBar) findViewById(u.g.vote_photo_progress);
        this.aGC = (TextView) findViewById(u.g.vote_photo_number);
        this.aGD = (TextView) findViewById(u.g.vote_photo_percent);
        this.aGE = (TextView) findViewById(u.g.vote_photo_name);
        this.aGF = (ImageView) findViewById(u.g.vote_photo_check_image);
        this.aGG = findViewById(u.g.vote_photo_frame);
        this.aGB.setDrawBorder(true);
        this.aGB.setBorderColor(av.getColor(u.d.common_color_10043));
        this.aGB.setBorderWidth(getResources().getDimensionPixelSize(u.e.ds1));
        setOnClickListener(this.aGI);
        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
    }

    @Override // android.view.View
    public void setSelected(boolean z) {
        this.isSelected = z;
        this.aGG.setVisibility(z ? 0 : 8);
        if (z) {
            av.c(this.aGF, u.f.btn_choose_photo_s);
        } else {
            av.c(this.aGF, u.f.btn_choose_photo_n);
        }
    }

    public void setOnItemCheckChangeListener(a aVar) {
        this.aGH = aVar;
    }

    public void a(com.baidu.tbadk.widget.vote.a aVar, int i, int i2, boolean z) {
        if (aVar != null) {
            this.isSelected = z;
            this.aGA = aVar;
            this.position = i;
            if (StringUtils.isNull(aVar.Hx())) {
                this.aGE.setVisibility(4);
                this.aGE.setText((CharSequence) null);
            } else {
                this.aGE.setVisibility(0);
                this.aGE.setText(UtilHelper.getFixedText(aVar.Hx(), 10, false));
            }
            if (i2 == 2) {
                setOnClickListener(null);
                b(aVar);
            } else if (i2 == 1 || i2 == 3) {
                setOnClickListener(this.aGI);
                bU(z);
            }
            this.aGG.setVisibility(z ? 0 : 8);
            this.aGB.c(aVar.HC(), 17, false);
        }
    }

    public void setNameVisibility(int i) {
        this.aGE.setVisibility(i);
    }

    private void bU(boolean z) {
        setProgressGroupVisible(false);
        this.aGF.setVisibility(0);
        if (z) {
            av.c(this.aGF, u.f.vote_text_check_box);
        } else {
            av.c(this.aGF, u.f.btn_choose_photo_n);
        }
    }

    private void b(com.baidu.tbadk.widget.vote.a aVar) {
        setProgressGroupVisible(true);
        this.aGF.setVisibility(8);
        if (aVar != null) {
            if (StringUtils.isNull(aVar.Hy())) {
                this.aGC.setVisibility(8);
                this.aGC.setText((CharSequence) null);
            } else {
                this.aGC.setVisibility(0);
                this.aGC.setText(aVar.Hy());
            }
            if (StringUtils.isNull(aVar.Hz())) {
                this.aGD.setVisibility(8);
                this.aGD.setText((CharSequence) null);
                return;
            }
            this.aGD.setVisibility(0);
            this.aGD.setText(aVar.Hz());
        }
    }

    private void setProgressGroupVisible(boolean z) {
        if (z) {
            this.aGC.setVisibility(0);
            this.aGD.setVisibility(0);
            this.aGm.setVisibility(0);
            return;
        }
        this.aGC.setVisibility(8);
        this.aGD.setVisibility(8);
        this.aGm.setVisibility(8);
    }

    public void setProgress(float f) {
        if (f >= 0.0f && this.aGA != null) {
            int HB = (int) (this.aGA.HB() * f);
            if (this.isSelected) {
                this.aGm.setProgress(HB);
                this.aGm.setSecondaryProgress(0);
                return;
            }
            this.aGm.setProgress(0);
            this.aGm.setSecondaryProgress(HB);
        }
    }

    public void onChangeSkinType(int i) {
        av.b(this.aGE, u.d.cp_cont_b, 1, i);
        av.b(this.aGC, u.d.cp_cont_g, 1, i);
        av.b(this.aGD, u.d.cp_cont_g, 1, i);
        this.aGm.setProgressDrawable(av.o(i, u.f.vote_photo_progress_drawable));
        if (this.isSelected) {
            av.c(this.aGF, u.f.btn_choose_photo_s);
        } else {
            av.c(this.aGF, u.f.btn_choose_photo_n);
        }
        av.d(this.aGG, u.f.vote_photo_frame, i);
    }
}
