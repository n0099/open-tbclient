package com.baidu.tbadk.widget.vote;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class c {
    private int aOA;
    private int aOB;
    private View aOu;
    private ImageView aOv;
    private ProgressBar aOw;
    private TextView aOx;
    private View aOy;
    private a aOz;
    private TextView auO;

    public c(Context context) {
        this(context, w.e.cp_cont_b);
    }

    public c(Context context, int i) {
        this.aOu = LayoutInflater.from(context).inflate(w.j.ballot_item_view, (ViewGroup) null);
        this.aOv = (ImageView) this.aOu.findViewById(w.h.ballot_item_image);
        this.auO = (TextView) this.aOu.findViewById(w.h.ballot_item_title);
        this.aOw = (ProgressBar) this.aOu.findViewById(w.h.ballot_item_progress);
        this.aOx = (TextView) this.aOu.findViewById(w.h.ballot_item_percents);
        this.aOy = this.aOu.findViewById(w.h.ballot_item_preffix_progress);
        this.aOA = k.g(context, w.f.ds28);
        this.aOB = i;
        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
    }

    public void setProgressBarHeight(int i) {
        this.aOA = i;
        this.aOw.getLayoutParams().height = this.aOA;
        this.aOy.getLayoutParams().height = this.aOA;
    }

    public void setProgressBarTopMargin(int i) {
        if (this.aOw.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.aOw.getLayoutParams()).topMargin = i;
        }
        if (this.aOy.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.aOy.getLayoutParams()).topMargin = i;
        }
    }

    public void setDescTopMargin(int i) {
        if (this.aOx.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.aOx.getLayoutParams()).topMargin = i;
        }
    }

    public void fA(int i) {
        if (i >= 0) {
            if (this.aOz != null) {
                int CV = this.aOz.CV();
                i = ((CV <= 100 ? CV : 100) * i) / 100;
            }
            ViewGroup.LayoutParams layoutParams = this.aOw.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(i, this.aOA);
            } else {
                layoutParams.width = i;
            }
            this.aOw.setLayoutParams(layoutParams);
        }
    }

    public int a(a aVar) {
        int intrinsicWidth;
        String string;
        this.aOz = aVar;
        if (aVar == null) {
            return 0;
        }
        if (aVar.CU() <= 0) {
            this.aOv.setImageDrawable(null);
            this.aOv.setVisibility(8);
            intrinsicWidth = 0;
        } else {
            Drawable drawable = aq.getDrawable(aVar.CU());
            this.aOv.setImageDrawable(drawable);
            intrinsicWidth = drawable.getIntrinsicWidth() + this.aOu.getResources().getDimensionPixelSize(w.f.ds24);
            this.aOv.setVisibility(0);
        }
        if (StringUtils.isNull(aVar.CR())) {
            this.auO.setText((CharSequence) null);
            this.auO.setVisibility(8);
        } else {
            this.auO.setText(UtilHelper.getFixedText(aVar.CR(), 15, false));
            this.auO.setVisibility(0);
        }
        if (aVar.isSelected()) {
            aq.k(this.aOy, w.e.common_color_10271);
        } else {
            aq.k(this.aOy, w.e.common_color_10272);
        }
        boolean isNull = StringUtils.isNull(aVar.CS());
        boolean isNull2 = StringUtils.isNull(aVar.CT());
        if (isNull && isNull2) {
            this.aOx.setText((CharSequence) null);
            this.aOx.setVisibility(8);
            string = null;
        } else {
            this.aOx.setVisibility(0);
            if (isNull) {
                string = aVar.CT();
                this.aOx.setText(string);
            } else if (isNull2) {
                string = aVar.CS();
                this.aOx.setText(string);
            } else {
                string = TbadkCoreApplication.m9getInst().getString(w.l.vote_number_text, new Object[]{aVar.CS(), aVar.CT()});
                this.aOx.setText(string);
            }
        }
        if (!StringUtils.isNull(string)) {
            intrinsicWidth = (int) (intrinsicWidth + this.aOx.getPaint().measureText(string));
        }
        return this.aOu.getResources().getDimensionPixelSize(w.f.ds24) + this.aOu.getResources().getDimensionPixelSize(w.f.ds10) + 8 + intrinsicWidth;
    }

    public void setProgress(float f) {
        if (f >= 0.0f && this.aOz != null) {
            int i = (int) (100.0f * f);
            if (this.aOz.isSelected()) {
                this.aOw.setProgress(i);
                this.aOw.setSecondaryProgress(0);
                return;
            }
            this.aOw.setProgress(0);
            this.aOw.setSecondaryProgress(i);
        }
    }

    public View getView() {
        return this.aOu;
    }

    public void onChangeSkinType(int i) {
        if (this.aOz != null && this.aOz.CU() > 0) {
            aq.c(this.aOv, this.aOz.CU(), i);
        }
        aq.c(this.auO, w.e.cp_cont_b, 1);
        aq.c(this.aOx, this.aOB, 1);
        this.aOw.setProgressDrawable(aq.getDrawable(w.g.vote_progress_drawable));
        if (this.aOz != null) {
            if (this.aOz.isSelected()) {
                aq.k(this.aOy, w.e.common_color_10271);
            } else {
                aq.k(this.aOy, w.e.common_color_10272);
            }
        }
    }
}
