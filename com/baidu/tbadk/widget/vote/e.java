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
    private ProgressBar aCI;
    private com.baidu.tbadk.widget.vote.a aCU;
    private TbImageView aCV;
    private TextView aCW;
    private TextView aCX;
    private TextView aCY;
    private ImageView aCZ;
    private View aDa;
    private a aDb;
    private View.OnClickListener aDc;
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
        this.aDc = new f(this);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(i.g.vote_selected_pic_item, this);
        this.aCV = (TbImageView) findViewById(i.f.vote_photo_image);
        this.aCI = (ProgressBar) findViewById(i.f.vote_photo_progress);
        this.aCW = (TextView) findViewById(i.f.vote_photo_number);
        this.aCX = (TextView) findViewById(i.f.vote_photo_percent);
        this.aCY = (TextView) findViewById(i.f.vote_photo_name);
        this.aCZ = (ImageView) findViewById(i.f.vote_photo_check_image);
        this.aDa = findViewById(i.f.vote_photo_frame);
        this.aCV.setDrawBorder(true);
        this.aCV.setBorderColor(an.getColor(i.c.black_alpha10));
        this.aCV.setBorderWidth(getResources().getDimensionPixelSize(i.d.ds1));
        setOnClickListener(this.aDc);
        onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
    }

    @Override // android.view.View
    public void setSelected(boolean z) {
        this.isSelected = z;
        this.aDa.setVisibility(z ? 0 : 8);
        if (z) {
            an.c(this.aCZ, i.e.btn_choose_photo_s);
        } else {
            an.c(this.aCZ, i.e.btn_choose_photo_n);
        }
    }

    public void setOnItemCheckChangeListener(a aVar) {
        this.aDb = aVar;
    }

    public void a(com.baidu.tbadk.widget.vote.a aVar, int i, int i2, boolean z) {
        if (aVar != null) {
            this.isSelected = z;
            this.aCU = aVar;
            this.position = i;
            if (StringUtils.isNull(aVar.Fs())) {
                this.aCY.setVisibility(4);
                this.aCY.setText((CharSequence) null);
            } else {
                this.aCY.setVisibility(0);
                this.aCY.setText(UtilHelper.getFixedText(aVar.Fs(), 10, false));
            }
            if (i2 == 2) {
                setOnClickListener(null);
                b(aVar);
            } else if (i2 == 1 || i2 == 3) {
                setOnClickListener(this.aDc);
                bu(z);
            }
            this.aDa.setVisibility(z ? 0 : 8);
            this.aCV.d(aVar.Fx(), 17, false);
        }
    }

    public void setNameVisibility(int i) {
        this.aCY.setVisibility(i);
    }

    private void bu(boolean z) {
        setProgressGroupVisible(false);
        this.aCZ.setVisibility(0);
        if (z) {
            an.c(this.aCZ, i.e.vote_text_check_box);
        } else {
            an.c(this.aCZ, i.e.btn_choose_photo_n);
        }
    }

    private void b(com.baidu.tbadk.widget.vote.a aVar) {
        setProgressGroupVisible(true);
        this.aCZ.setVisibility(8);
        if (aVar != null) {
            if (StringUtils.isNull(aVar.Ft())) {
                this.aCW.setVisibility(8);
                this.aCW.setText((CharSequence) null);
            } else {
                this.aCW.setVisibility(0);
                this.aCW.setText(aVar.Ft());
            }
            if (StringUtils.isNull(aVar.Fu())) {
                this.aCX.setVisibility(8);
                this.aCX.setText((CharSequence) null);
                return;
            }
            this.aCX.setVisibility(0);
            this.aCX.setText(aVar.Fu());
        }
    }

    private void setProgressGroupVisible(boolean z) {
        if (z) {
            this.aCW.setVisibility(0);
            this.aCX.setVisibility(0);
            this.aCI.setVisibility(0);
            return;
        }
        this.aCW.setVisibility(8);
        this.aCX.setVisibility(8);
        this.aCI.setVisibility(8);
    }

    public void setProgress(float f) {
        if (f >= 0.0f && this.aCU != null) {
            int Fw = (int) (this.aCU.Fw() * f);
            if (this.isSelected) {
                this.aCI.setProgress(Fw);
                this.aCI.setSecondaryProgress(0);
                return;
            }
            this.aCI.setProgress(0);
            this.aCI.setSecondaryProgress(Fw);
        }
    }

    public void onChangeSkinType(int i) {
        an.a(this.aCY, i.c.cp_cont_b, 1, i);
        an.a(this.aCW, i.c.cp_cont_g, 1, i);
        an.a(this.aCX, i.c.cp_cont_g, 1, i);
        this.aCI.setProgressDrawable(an.x(i, i.e.vote_photo_progress_drawable));
        if (this.isSelected) {
            an.c(this.aCZ, i.e.btn_choose_photo_s);
        } else {
            an.c(this.aCZ, i.e.btn_choose_photo_n);
        }
        an.c(this.aDa, i.e.vote_photo_frame, i);
    }
}
