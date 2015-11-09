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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class e extends FrameLayout {
    private ProgressBar aBC;
    private com.baidu.tbadk.widget.vote.a aBO;
    private TbImageView aBP;
    private TextView aBQ;
    private TextView aBR;
    private TextView aBS;
    private ImageView aBT;
    private View aBU;
    private a aBV;
    private View.OnClickListener aBW;
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
        this.aBW = new f(this);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(i.g.vote_selected_pic_item, this);
        this.aBP = (TbImageView) findViewById(i.f.vote_photo_image);
        this.aBC = (ProgressBar) findViewById(i.f.vote_photo_progress);
        this.aBQ = (TextView) findViewById(i.f.vote_photo_number);
        this.aBR = (TextView) findViewById(i.f.vote_photo_percent);
        this.aBS = (TextView) findViewById(i.f.vote_photo_name);
        this.aBT = (ImageView) findViewById(i.f.vote_photo_check_image);
        this.aBU = findViewById(i.f.vote_photo_frame);
        this.aBP.setDrawBorder(true);
        this.aBP.setBorderColor(an.getColor(i.c.black_alpha10));
        this.aBP.setBorderWidth(getResources().getDimensionPixelSize(i.d.ds1));
        setOnClickListener(this.aBW);
        onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
    }

    @Override // android.view.View
    public void setSelected(boolean z) {
        this.isSelected = z;
        this.aBU.setVisibility(z ? 0 : 8);
        if (z) {
            an.c(this.aBT, i.e.btn_choose_photo_s);
        } else {
            an.c(this.aBT, i.e.btn_choose_photo_n);
        }
    }

    public void setOnItemCheckChangeListener(a aVar) {
        this.aBV = aVar;
    }

    public void a(com.baidu.tbadk.widget.vote.a aVar, int i, int i2, boolean z) {
        if (aVar != null) {
            this.isSelected = z;
            this.aBO = aVar;
            this.position = i;
            if (StringUtils.isNull(aVar.Fp())) {
                this.aBS.setVisibility(4);
                this.aBS.setText((CharSequence) null);
            } else {
                this.aBS.setVisibility(0);
                this.aBS.setText(UtilHelper.getFixedText(aVar.Fp(), 10, false));
            }
            if (i2 == 2) {
                setOnClickListener(null);
                b(aVar);
            } else if (i2 == 1 || i2 == 3) {
                setOnClickListener(this.aBW);
                bw(z);
            }
            this.aBU.setVisibility(z ? 0 : 8);
            this.aBP.d(aVar.Fu(), 17, false);
        }
    }

    public void setNameVisibility(int i) {
        this.aBS.setVisibility(i);
    }

    private void bw(boolean z) {
        setProgressGroupVisible(false);
        this.aBT.setVisibility(0);
        if (z) {
            an.c(this.aBT, i.e.vote_text_check_box);
        } else {
            an.c(this.aBT, i.e.btn_choose_photo_n);
        }
    }

    private void b(com.baidu.tbadk.widget.vote.a aVar) {
        setProgressGroupVisible(true);
        this.aBT.setVisibility(8);
        if (aVar != null) {
            if (StringUtils.isNull(aVar.Fq())) {
                this.aBQ.setVisibility(8);
                this.aBQ.setText((CharSequence) null);
            } else {
                this.aBQ.setVisibility(0);
                this.aBQ.setText(aVar.Fq());
            }
            if (StringUtils.isNull(aVar.Fr())) {
                this.aBR.setVisibility(8);
                this.aBR.setText((CharSequence) null);
                return;
            }
            this.aBR.setVisibility(0);
            this.aBR.setText(aVar.Fr());
        }
    }

    private void setProgressGroupVisible(boolean z) {
        if (z) {
            this.aBQ.setVisibility(0);
            this.aBR.setVisibility(0);
            this.aBC.setVisibility(0);
            return;
        }
        this.aBQ.setVisibility(8);
        this.aBR.setVisibility(8);
        this.aBC.setVisibility(8);
    }

    public void setProgress(float f) {
        if (f >= 0.0f && this.aBO != null) {
            int Ft = (int) (this.aBO.Ft() * f);
            if (this.isSelected) {
                this.aBC.setProgress(Ft);
                this.aBC.setSecondaryProgress(0);
                return;
            }
            this.aBC.setProgress(0);
            this.aBC.setSecondaryProgress(Ft);
        }
    }

    public void onChangeSkinType(int i) {
        an.a(this.aBS, i.c.cp_cont_b, 1, i);
        an.a(this.aBQ, i.c.cp_cont_g, 1, i);
        an.a(this.aBR, i.c.cp_cont_g, 1, i);
        this.aBC.setProgressDrawable(an.x(i, i.e.vote_photo_progress_drawable));
        if (this.isSelected) {
            an.c(this.aBT, i.e.btn_choose_photo_s);
        } else {
            an.c(this.aBT, i.e.btn_choose_photo_n);
        }
        an.c(this.aBU, i.e.vote_photo_frame, i);
    }
}
