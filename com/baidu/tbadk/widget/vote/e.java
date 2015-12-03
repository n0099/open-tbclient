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
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class e extends FrameLayout {
    private com.baidu.tbadk.widget.vote.a aEA;
    private TbImageView aEB;
    private TextView aEC;
    private TextView aED;
    private TextView aEE;
    private ImageView aEF;
    private View aEG;
    private a aEH;
    private View.OnClickListener aEI;
    private ProgressBar aEo;
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
        this.aEI = new f(this);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(n.g.vote_selected_pic_item, this);
        this.aEB = (TbImageView) findViewById(n.f.vote_photo_image);
        this.aEo = (ProgressBar) findViewById(n.f.vote_photo_progress);
        this.aEC = (TextView) findViewById(n.f.vote_photo_number);
        this.aED = (TextView) findViewById(n.f.vote_photo_percent);
        this.aEE = (TextView) findViewById(n.f.vote_photo_name);
        this.aEF = (ImageView) findViewById(n.f.vote_photo_check_image);
        this.aEG = findViewById(n.f.vote_photo_frame);
        this.aEB.setDrawBorder(true);
        this.aEB.setBorderColor(as.getColor(n.c.black_alpha10));
        this.aEB.setBorderWidth(getResources().getDimensionPixelSize(n.d.ds1));
        setOnClickListener(this.aEI);
        onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
    }

    @Override // android.view.View
    public void setSelected(boolean z) {
        this.isSelected = z;
        this.aEG.setVisibility(z ? 0 : 8);
        if (z) {
            as.c(this.aEF, n.e.btn_choose_photo_s);
        } else {
            as.c(this.aEF, n.e.btn_choose_photo_n);
        }
    }

    public void setOnItemCheckChangeListener(a aVar) {
        this.aEH = aVar;
    }

    public void a(com.baidu.tbadk.widget.vote.a aVar, int i, int i2, boolean z) {
        if (aVar != null) {
            this.isSelected = z;
            this.aEA = aVar;
            this.position = i;
            if (StringUtils.isNull(aVar.Gu())) {
                this.aEE.setVisibility(4);
                this.aEE.setText((CharSequence) null);
            } else {
                this.aEE.setVisibility(0);
                this.aEE.setText(UtilHelper.getFixedText(aVar.Gu(), 10, false));
            }
            if (i2 == 2) {
                setOnClickListener(null);
                b(aVar);
            } else if (i2 == 1 || i2 == 3) {
                setOnClickListener(this.aEI);
                bF(z);
            }
            this.aEG.setVisibility(z ? 0 : 8);
            this.aEB.d(aVar.Gz(), 17, false);
        }
    }

    public void setNameVisibility(int i) {
        this.aEE.setVisibility(i);
    }

    private void bF(boolean z) {
        setProgressGroupVisible(false);
        this.aEF.setVisibility(0);
        if (z) {
            as.c(this.aEF, n.e.vote_text_check_box);
        } else {
            as.c(this.aEF, n.e.btn_choose_photo_n);
        }
    }

    private void b(com.baidu.tbadk.widget.vote.a aVar) {
        setProgressGroupVisible(true);
        this.aEF.setVisibility(8);
        if (aVar != null) {
            if (StringUtils.isNull(aVar.Gv())) {
                this.aEC.setVisibility(8);
                this.aEC.setText((CharSequence) null);
            } else {
                this.aEC.setVisibility(0);
                this.aEC.setText(aVar.Gv());
            }
            if (StringUtils.isNull(aVar.Gw())) {
                this.aED.setVisibility(8);
                this.aED.setText((CharSequence) null);
                return;
            }
            this.aED.setVisibility(0);
            this.aED.setText(aVar.Gw());
        }
    }

    private void setProgressGroupVisible(boolean z) {
        if (z) {
            this.aEC.setVisibility(0);
            this.aED.setVisibility(0);
            this.aEo.setVisibility(0);
            return;
        }
        this.aEC.setVisibility(8);
        this.aED.setVisibility(8);
        this.aEo.setVisibility(8);
    }

    public void setProgress(float f) {
        if (f >= 0.0f && this.aEA != null) {
            int Gy = (int) (this.aEA.Gy() * f);
            if (this.isSelected) {
                this.aEo.setProgress(Gy);
                this.aEo.setSecondaryProgress(0);
                return;
            }
            this.aEo.setProgress(0);
            this.aEo.setSecondaryProgress(Gy);
        }
    }

    public void onChangeSkinType(int i) {
        as.a(this.aEE, n.c.cp_cont_b, 1, i);
        as.a(this.aEC, n.c.cp_cont_g, 1, i);
        as.a(this.aED, n.c.cp_cont_g, 1, i);
        this.aEo.setProgressDrawable(as.x(i, n.e.vote_photo_progress_drawable));
        if (this.isSelected) {
            as.c(this.aEF, n.e.btn_choose_photo_s);
        } else {
            as.c(this.aEF, n.e.btn_choose_photo_n);
        }
        as.c(this.aEG, n.e.vote_photo_frame, i);
    }
}
