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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class d extends FrameLayout {
    private com.baidu.tbadk.widget.vote.a bMO;
    private TbImageView bMP;
    private TextView bMQ;
    private TextView bMR;
    private TextView bMS;
    private ImageView bMT;
    private a bMU;
    private View.OnClickListener bMV;
    private boolean isSelected;
    private int position;
    private ProgressBar progressBar;

    /* loaded from: classes.dex */
    public interface a {
        void b(com.baidu.tbadk.widget.vote.a aVar, int i, boolean z);
    }

    @Override // android.view.View
    public boolean isSelected() {
        return this.isSelected;
    }

    public d(Context context) {
        super(context);
        this.isSelected = false;
        this.bMV = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.vote.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.setSelected(!d.this.isSelected);
                if (d.this.bMU != null) {
                    d.this.bMU.b(d.this.bMO, d.this.position, d.this.isSelected);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(d.h.vote_selected_pic_item, this);
        this.bMP = (TbImageView) findViewById(d.g.vote_photo_image);
        this.progressBar = (ProgressBar) findViewById(d.g.vote_photo_progress);
        this.bMQ = (TextView) findViewById(d.g.vote_photo_number);
        this.bMR = (TextView) findViewById(d.g.vote_photo_percent);
        this.bMS = (TextView) findViewById(d.g.vote_photo_name);
        this.bMT = (ImageView) findViewById(d.g.vote_photo_check_image);
        this.bMP.setDrawBorder(true);
        this.bMP.setBorderColor(aj.getColor(d.C0140d.common_color_10043));
        this.bMP.setBorderWidth(getResources().getDimensionPixelSize(d.e.ds1));
        setOnClickListener(this.bMV);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View
    public void setSelected(boolean z) {
        this.isSelected = z;
        if (z) {
            aj.c(this.bMT, d.f.chx_pic_add_s);
        } else {
            aj.c(this.bMT, d.f.chx_pic_add_n);
        }
    }

    public void setOnItemCheckChangeListener(a aVar) {
        this.bMU = aVar;
    }

    public void a(com.baidu.tbadk.widget.vote.a aVar, int i, int i2, boolean z, boolean z2) {
        if (aVar != null) {
            this.isSelected = z;
            this.bMO = aVar;
            this.position = i;
            if (StringUtils.isNull(aVar.KG())) {
                this.bMS.setVisibility(4);
                this.bMS.setText((CharSequence) null);
            } else {
                this.bMS.setVisibility(0);
                this.bMS.setText(UtilHelper.getFixedText(aVar.KG(), 10, false));
            }
            if (i2 == 2) {
                setOnClickListener(null);
                b(aVar);
            } else if (i2 == 1 || i2 == 3) {
                setOnClickListener(this.bMV);
                cO(z);
            }
            this.bMP.startLoad(aVar.KL(), 17, false);
        }
    }

    public void setNameVisibility(int i) {
        this.bMS.setVisibility(i);
    }

    private void cO(boolean z) {
        setProgressGroupVisible(false);
        this.bMT.setVisibility(0);
        if (z) {
            aj.c(this.bMT, d.f.chx_pic_add_s);
        } else {
            aj.c(this.bMT, d.f.chx_pic_add_n);
        }
    }

    private void b(com.baidu.tbadk.widget.vote.a aVar) {
        setProgressGroupVisible(true);
        this.bMT.setVisibility(8);
        if (aVar != null) {
            if (StringUtils.isNull(aVar.KH())) {
                this.bMQ.setVisibility(8);
                this.bMQ.setText((CharSequence) null);
            } else {
                this.bMQ.setVisibility(0);
                this.bMQ.setText(aVar.KH());
            }
            if (StringUtils.isNull(aVar.KI())) {
                this.bMR.setVisibility(8);
                this.bMR.setText((CharSequence) null);
                return;
            }
            this.bMR.setVisibility(0);
            this.bMR.setText(aVar.KI());
        }
    }

    private void setProgressGroupVisible(boolean z) {
        if (z) {
            this.bMQ.setVisibility(0);
            this.bMR.setVisibility(0);
            this.progressBar.setVisibility(0);
            return;
        }
        this.bMQ.setVisibility(8);
        this.bMR.setVisibility(8);
        this.progressBar.setVisibility(8);
    }

    public void setProgress(float f) {
        if (f >= 0.0f && this.bMO != null) {
            int KK = (int) (this.bMO.KK() * f);
            if (this.isSelected) {
                this.progressBar.setProgress(KK);
                this.progressBar.setSecondaryProgress(0);
                return;
            }
            this.progressBar.setProgress(0);
            this.progressBar.setSecondaryProgress(KK);
        }
    }

    public void onChangeSkinType(int i) {
        aj.b(this.bMS, d.C0140d.cp_cont_b, 1, i);
        aj.b(this.bMQ, d.C0140d.cp_cont_g, 1, i);
        aj.b(this.bMR, d.C0140d.cp_cont_g, 1, i);
        this.progressBar.setProgressDrawable(aj.au(i, d.f.vote_photo_progress_drawable));
        if (this.isSelected) {
            aj.c(this.bMT, d.f.chx_pic_add_s);
        } else {
            aj.c(this.bMT, d.f.chx_pic_add_n);
        }
    }
}
