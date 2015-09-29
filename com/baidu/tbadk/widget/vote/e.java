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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class e extends FrameLayout {
    private com.baidu.tbadk.widget.vote.a aCJ;
    private TbImageView aCK;
    private TextView aCL;
    private TextView aCM;
    private TextView aCN;
    private ImageView aCO;
    private View aCP;
    private a aCQ;
    private View.OnClickListener aCR;
    private ProgressBar aCx;
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
        this.aCR = new f(this);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(i.g.vote_selected_pic_item, this);
        this.aCK = (TbImageView) findViewById(i.f.vote_photo_image);
        this.aCx = (ProgressBar) findViewById(i.f.vote_photo_progress);
        this.aCL = (TextView) findViewById(i.f.vote_photo_number);
        this.aCM = (TextView) findViewById(i.f.vote_photo_percent);
        this.aCN = (TextView) findViewById(i.f.vote_photo_name);
        this.aCO = (ImageView) findViewById(i.f.vote_photo_check_image);
        this.aCP = findViewById(i.f.vote_photo_frame);
        this.aCK.setDrawBorder(true);
        this.aCK.setBorderColor(am.getColor(i.c.black_alpha10));
        this.aCK.setBorderWidth(getResources().getDimensionPixelSize(i.d.ds1));
        setOnClickListener(this.aCR);
        onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
    }

    @Override // android.view.View
    public void setSelected(boolean z) {
        this.isSelected = z;
        this.aCP.setVisibility(z ? 0 : 8);
        if (z) {
            am.c(this.aCO, i.e.btn_choose_photo_s);
        } else {
            am.c(this.aCO, i.e.btn_choose_photo_n);
        }
    }

    public void setOnItemCheckChangeListener(a aVar) {
        this.aCQ = aVar;
    }

    public void a(com.baidu.tbadk.widget.vote.a aVar, int i, int i2, boolean z) {
        if (aVar != null) {
            this.isSelected = z;
            this.aCJ = aVar;
            this.position = i;
            if (StringUtils.isNull(aVar.Fw())) {
                this.aCN.setVisibility(4);
                this.aCN.setText((CharSequence) null);
            } else {
                this.aCN.setVisibility(0);
                this.aCN.setText(UtilHelper.getFixedText(aVar.Fw(), 10, false));
            }
            if (i2 == 2) {
                setOnClickListener(null);
                b(aVar);
            } else if (i2 == 1 || i2 == 3) {
                setOnClickListener(this.aCR);
                bu(z);
            }
            this.aCP.setVisibility(z ? 0 : 8);
            this.aCK.d(aVar.FB(), 17, false);
        }
    }

    public void setNameVisibility(int i) {
        this.aCN.setVisibility(i);
    }

    private void bu(boolean z) {
        setProgressGroupVisible(false);
        this.aCO.setVisibility(0);
        if (z) {
            am.c(this.aCO, i.e.vote_text_check_box);
        } else {
            am.c(this.aCO, i.e.btn_choose_photo_n);
        }
    }

    private void b(com.baidu.tbadk.widget.vote.a aVar) {
        setProgressGroupVisible(true);
        this.aCO.setVisibility(8);
        if (aVar != null) {
            if (StringUtils.isNull(aVar.Fx())) {
                this.aCL.setVisibility(8);
                this.aCL.setText((CharSequence) null);
            } else {
                this.aCL.setVisibility(0);
                this.aCL.setText(aVar.Fx());
            }
            if (StringUtils.isNull(aVar.Fy())) {
                this.aCM.setVisibility(8);
                this.aCM.setText((CharSequence) null);
                return;
            }
            this.aCM.setVisibility(0);
            this.aCM.setText(aVar.Fy());
        }
    }

    private void setProgressGroupVisible(boolean z) {
        if (z) {
            this.aCL.setVisibility(0);
            this.aCM.setVisibility(0);
            this.aCx.setVisibility(0);
            return;
        }
        this.aCL.setVisibility(8);
        this.aCM.setVisibility(8);
        this.aCx.setVisibility(8);
    }

    public void setProgress(float f) {
        if (f >= 0.0f && this.aCJ != null) {
            int FA = (int) (this.aCJ.FA() * f);
            if (this.isSelected) {
                this.aCx.setProgress(FA);
                this.aCx.setSecondaryProgress(0);
                return;
            }
            this.aCx.setProgress(0);
            this.aCx.setSecondaryProgress(FA);
        }
    }

    public void onChangeSkinType(int i) {
        am.a(this.aCN, i.c.cp_cont_b, 1, i);
        am.a(this.aCL, i.c.cp_cont_g, 1, i);
        am.a(this.aCM, i.c.cp_cont_g, 1, i);
        this.aCx.setProgressDrawable(am.x(i, i.e.vote_photo_progress_drawable));
        if (this.isSelected) {
            am.c(this.aCO, i.e.btn_choose_photo_s);
        } else {
            am.c(this.aCO, i.e.btn_choose_photo_n);
        }
        am.c(this.aCP, i.e.vote_photo_frame, i);
    }
}
