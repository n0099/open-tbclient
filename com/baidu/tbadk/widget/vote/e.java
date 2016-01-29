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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class e extends FrameLayout {
    private ProgressBar aGH;
    private com.baidu.tbadk.widget.vote.a aGT;
    private TbImageView aGU;
    private TextView aGV;
    private TextView aGW;
    private TextView aGX;
    private ImageView aGY;
    private View aGZ;
    private a aHa;
    private View.OnClickListener aHb;
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
        this.aHb = new f(this);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(t.h.vote_selected_pic_item, this);
        this.aGU = (TbImageView) findViewById(t.g.vote_photo_image);
        this.aGH = (ProgressBar) findViewById(t.g.vote_photo_progress);
        this.aGV = (TextView) findViewById(t.g.vote_photo_number);
        this.aGW = (TextView) findViewById(t.g.vote_photo_percent);
        this.aGX = (TextView) findViewById(t.g.vote_photo_name);
        this.aGY = (ImageView) findViewById(t.g.vote_photo_check_image);
        this.aGZ = findViewById(t.g.vote_photo_frame);
        this.aGU.setDrawBorder(true);
        this.aGU.setBorderColor(ar.getColor(t.d.black_alpha10));
        this.aGU.setBorderWidth(getResources().getDimensionPixelSize(t.e.ds1));
        setOnClickListener(this.aHb);
        onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
    }

    @Override // android.view.View
    public void setSelected(boolean z) {
        this.isSelected = z;
        this.aGZ.setVisibility(z ? 0 : 8);
        if (z) {
            ar.c(this.aGY, t.f.btn_choose_photo_s);
        } else {
            ar.c(this.aGY, t.f.btn_choose_photo_n);
        }
    }

    public void setOnItemCheckChangeListener(a aVar) {
        this.aHa = aVar;
    }

    public void a(com.baidu.tbadk.widget.vote.a aVar, int i, int i2, boolean z) {
        if (aVar != null) {
            this.isSelected = z;
            this.aGT = aVar;
            this.position = i;
            if (StringUtils.isNull(aVar.HI())) {
                this.aGX.setVisibility(4);
                this.aGX.setText((CharSequence) null);
            } else {
                this.aGX.setVisibility(0);
                this.aGX.setText(UtilHelper.getFixedText(aVar.HI(), 10, false));
            }
            if (i2 == 2) {
                setOnClickListener(null);
                b(aVar);
            } else if (i2 == 1 || i2 == 3) {
                setOnClickListener(this.aHb);
                bG(z);
            }
            this.aGZ.setVisibility(z ? 0 : 8);
            this.aGU.d(aVar.HN(), 17, false);
        }
    }

    public void setNameVisibility(int i) {
        this.aGX.setVisibility(i);
    }

    private void bG(boolean z) {
        setProgressGroupVisible(false);
        this.aGY.setVisibility(0);
        if (z) {
            ar.c(this.aGY, t.f.vote_text_check_box);
        } else {
            ar.c(this.aGY, t.f.btn_choose_photo_n);
        }
    }

    private void b(com.baidu.tbadk.widget.vote.a aVar) {
        setProgressGroupVisible(true);
        this.aGY.setVisibility(8);
        if (aVar != null) {
            if (StringUtils.isNull(aVar.HJ())) {
                this.aGV.setVisibility(8);
                this.aGV.setText((CharSequence) null);
            } else {
                this.aGV.setVisibility(0);
                this.aGV.setText(aVar.HJ());
            }
            if (StringUtils.isNull(aVar.HK())) {
                this.aGW.setVisibility(8);
                this.aGW.setText((CharSequence) null);
                return;
            }
            this.aGW.setVisibility(0);
            this.aGW.setText(aVar.HK());
        }
    }

    private void setProgressGroupVisible(boolean z) {
        if (z) {
            this.aGV.setVisibility(0);
            this.aGW.setVisibility(0);
            this.aGH.setVisibility(0);
            return;
        }
        this.aGV.setVisibility(8);
        this.aGW.setVisibility(8);
        this.aGH.setVisibility(8);
    }

    public void setProgress(float f) {
        if (f >= 0.0f && this.aGT != null) {
            int HM = (int) (this.aGT.HM() * f);
            if (this.isSelected) {
                this.aGH.setProgress(HM);
                this.aGH.setSecondaryProgress(0);
                return;
            }
            this.aGH.setProgress(0);
            this.aGH.setSecondaryProgress(HM);
        }
    }

    public void onChangeSkinType(int i) {
        ar.a(this.aGX, t.d.cp_cont_b, 1, i);
        ar.a(this.aGV, t.d.cp_cont_g, 1, i);
        ar.a(this.aGW, t.d.cp_cont_g, 1, i);
        this.aGH.setProgressDrawable(ar.s(i, t.f.vote_photo_progress_drawable));
        if (this.isSelected) {
            ar.c(this.aGY, t.f.btn_choose_photo_s);
        } else {
            ar.c(this.aGY, t.f.btn_choose_photo_n);
        }
        ar.c(this.aGZ, t.f.vote_photo_frame, i);
    }
}
