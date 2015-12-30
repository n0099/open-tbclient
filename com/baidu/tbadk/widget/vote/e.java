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
    private ProgressBar aFO;
    private com.baidu.tbadk.widget.vote.a aGa;
    private TbImageView aGb;
    private TextView aGc;
    private TextView aGd;
    private TextView aGe;
    private ImageView aGf;
    private View aGg;
    private a aGh;
    private View.OnClickListener aGi;
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
        this.aGi = new f(this);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(n.h.vote_selected_pic_item, this);
        this.aGb = (TbImageView) findViewById(n.g.vote_photo_image);
        this.aFO = (ProgressBar) findViewById(n.g.vote_photo_progress);
        this.aGc = (TextView) findViewById(n.g.vote_photo_number);
        this.aGd = (TextView) findViewById(n.g.vote_photo_percent);
        this.aGe = (TextView) findViewById(n.g.vote_photo_name);
        this.aGf = (ImageView) findViewById(n.g.vote_photo_check_image);
        this.aGg = findViewById(n.g.vote_photo_frame);
        this.aGb.setDrawBorder(true);
        this.aGb.setBorderColor(as.getColor(n.d.black_alpha10));
        this.aGb.setBorderWidth(getResources().getDimensionPixelSize(n.e.ds1));
        setOnClickListener(this.aGi);
        onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
    }

    @Override // android.view.View
    public void setSelected(boolean z) {
        this.isSelected = z;
        this.aGg.setVisibility(z ? 0 : 8);
        if (z) {
            as.c(this.aGf, n.f.btn_choose_photo_s);
        } else {
            as.c(this.aGf, n.f.btn_choose_photo_n);
        }
    }

    public void setOnItemCheckChangeListener(a aVar) {
        this.aGh = aVar;
    }

    public void a(com.baidu.tbadk.widget.vote.a aVar, int i, int i2, boolean z) {
        if (aVar != null) {
            this.isSelected = z;
            this.aGa = aVar;
            this.position = i;
            if (StringUtils.isNull(aVar.Gj())) {
                this.aGe.setVisibility(4);
                this.aGe.setText((CharSequence) null);
            } else {
                this.aGe.setVisibility(0);
                this.aGe.setText(UtilHelper.getFixedText(aVar.Gj(), 10, false));
            }
            if (i2 == 2) {
                setOnClickListener(null);
                b(aVar);
            } else if (i2 == 1 || i2 == 3) {
                setOnClickListener(this.aGi);
                bF(z);
            }
            this.aGg.setVisibility(z ? 0 : 8);
            this.aGb.d(aVar.Go(), 17, false);
        }
    }

    public void setNameVisibility(int i) {
        this.aGe.setVisibility(i);
    }

    private void bF(boolean z) {
        setProgressGroupVisible(false);
        this.aGf.setVisibility(0);
        if (z) {
            as.c(this.aGf, n.f.vote_text_check_box);
        } else {
            as.c(this.aGf, n.f.btn_choose_photo_n);
        }
    }

    private void b(com.baidu.tbadk.widget.vote.a aVar) {
        setProgressGroupVisible(true);
        this.aGf.setVisibility(8);
        if (aVar != null) {
            if (StringUtils.isNull(aVar.Gk())) {
                this.aGc.setVisibility(8);
                this.aGc.setText((CharSequence) null);
            } else {
                this.aGc.setVisibility(0);
                this.aGc.setText(aVar.Gk());
            }
            if (StringUtils.isNull(aVar.Gl())) {
                this.aGd.setVisibility(8);
                this.aGd.setText((CharSequence) null);
                return;
            }
            this.aGd.setVisibility(0);
            this.aGd.setText(aVar.Gl());
        }
    }

    private void setProgressGroupVisible(boolean z) {
        if (z) {
            this.aGc.setVisibility(0);
            this.aGd.setVisibility(0);
            this.aFO.setVisibility(0);
            return;
        }
        this.aGc.setVisibility(8);
        this.aGd.setVisibility(8);
        this.aFO.setVisibility(8);
    }

    public void setProgress(float f) {
        if (f >= 0.0f && this.aGa != null) {
            int Gn = (int) (this.aGa.Gn() * f);
            if (this.isSelected) {
                this.aFO.setProgress(Gn);
                this.aFO.setSecondaryProgress(0);
                return;
            }
            this.aFO.setProgress(0);
            this.aFO.setSecondaryProgress(Gn);
        }
    }

    public void onChangeSkinType(int i) {
        as.a(this.aGe, n.d.cp_cont_b, 1, i);
        as.a(this.aGc, n.d.cp_cont_g, 1, i);
        as.a(this.aGd, n.d.cp_cont_g, 1, i);
        this.aFO.setProgressDrawable(as.w(i, n.f.vote_photo_progress_drawable));
        if (this.isSelected) {
            as.c(this.aGf, n.f.btn_choose_photo_s);
        } else {
            as.c(this.aGf, n.f.btn_choose_photo_n);
        }
        as.c(this.aGg, n.f.vote_photo_frame, i);
    }
}
