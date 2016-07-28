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
    private ProgressBar aHd;
    private com.baidu.tbadk.widget.vote.a aHr;
    private TbImageView aHs;
    private TextView aHt;
    private TextView aHu;
    private TextView aHv;
    private ImageView aHw;
    private View aHx;
    private a aHy;
    private View.OnClickListener aHz;
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
        this.aHz = new f(this);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(u.h.vote_selected_pic_item, this);
        this.aHs = (TbImageView) findViewById(u.g.vote_photo_image);
        this.aHd = (ProgressBar) findViewById(u.g.vote_photo_progress);
        this.aHt = (TextView) findViewById(u.g.vote_photo_number);
        this.aHu = (TextView) findViewById(u.g.vote_photo_percent);
        this.aHv = (TextView) findViewById(u.g.vote_photo_name);
        this.aHw = (ImageView) findViewById(u.g.vote_photo_check_image);
        this.aHx = findViewById(u.g.vote_photo_frame);
        this.aHs.setDrawBorder(true);
        this.aHs.setBorderColor(av.getColor(u.d.common_color_10043));
        this.aHs.setBorderWidth(getResources().getDimensionPixelSize(u.e.ds1));
        setOnClickListener(this.aHz);
        onChangeSkinType(TbadkCoreApplication.m10getInst().getSkinType());
    }

    @Override // android.view.View
    public void setSelected(boolean z) {
        this.isSelected = z;
        this.aHx.setVisibility(z ? 0 : 8);
        if (z) {
            av.c(this.aHw, u.f.btn_choose_photo_s);
        } else {
            av.c(this.aHw, u.f.btn_choose_photo_n);
        }
    }

    public void setOnItemCheckChangeListener(a aVar) {
        this.aHy = aVar;
    }

    public void a(com.baidu.tbadk.widget.vote.a aVar, int i, int i2, boolean z) {
        if (aVar != null) {
            this.isSelected = z;
            this.aHr = aVar;
            this.position = i;
            if (StringUtils.isNull(aVar.Hv())) {
                this.aHv.setVisibility(4);
                this.aHv.setText((CharSequence) null);
            } else {
                this.aHv.setVisibility(0);
                this.aHv.setText(UtilHelper.getFixedText(aVar.Hv(), 10, false));
            }
            if (i2 == 2) {
                setOnClickListener(null);
                b(aVar);
            } else if (i2 == 1 || i2 == 3) {
                setOnClickListener(this.aHz);
                bW(z);
            }
            this.aHx.setVisibility(z ? 0 : 8);
            this.aHs.c(aVar.HA(), 17, false);
        }
    }

    public void setNameVisibility(int i) {
        this.aHv.setVisibility(i);
    }

    private void bW(boolean z) {
        setProgressGroupVisible(false);
        this.aHw.setVisibility(0);
        if (z) {
            av.c(this.aHw, u.f.vote_text_check_box);
        } else {
            av.c(this.aHw, u.f.btn_choose_photo_n);
        }
    }

    private void b(com.baidu.tbadk.widget.vote.a aVar) {
        setProgressGroupVisible(true);
        this.aHw.setVisibility(8);
        if (aVar != null) {
            if (StringUtils.isNull(aVar.Hw())) {
                this.aHt.setVisibility(8);
                this.aHt.setText((CharSequence) null);
            } else {
                this.aHt.setVisibility(0);
                this.aHt.setText(aVar.Hw());
            }
            if (StringUtils.isNull(aVar.Hx())) {
                this.aHu.setVisibility(8);
                this.aHu.setText((CharSequence) null);
                return;
            }
            this.aHu.setVisibility(0);
            this.aHu.setText(aVar.Hx());
        }
    }

    private void setProgressGroupVisible(boolean z) {
        if (z) {
            this.aHt.setVisibility(0);
            this.aHu.setVisibility(0);
            this.aHd.setVisibility(0);
            return;
        }
        this.aHt.setVisibility(8);
        this.aHu.setVisibility(8);
        this.aHd.setVisibility(8);
    }

    public void setProgress(float f) {
        if (f >= 0.0f && this.aHr != null) {
            int Hz = (int) (this.aHr.Hz() * f);
            if (this.isSelected) {
                this.aHd.setProgress(Hz);
                this.aHd.setSecondaryProgress(0);
                return;
            }
            this.aHd.setProgress(0);
            this.aHd.setSecondaryProgress(Hz);
        }
    }

    public void onChangeSkinType(int i) {
        av.b(this.aHv, u.d.cp_cont_b, 1, i);
        av.b(this.aHt, u.d.cp_cont_g, 1, i);
        av.b(this.aHu, u.d.cp_cont_g, 1, i);
        this.aHd.setProgressDrawable(av.o(i, u.f.vote_photo_progress_drawable));
        if (this.isSelected) {
            av.c(this.aHw, u.f.btn_choose_photo_s);
        } else {
            av.c(this.aHw, u.f.btn_choose_photo_n);
        }
        av.d(this.aHx, u.f.vote_photo_frame, i);
    }
}
