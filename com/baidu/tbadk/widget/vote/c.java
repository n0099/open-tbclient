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
    private View aOA;
    private a aOB;
    private int aOC;
    private int aOD;
    private View aOw;
    private ImageView aOx;
    private ProgressBar aOy;
    private TextView aOz;
    private TextView auQ;

    public c(Context context) {
        this(context, w.e.cp_cont_b);
    }

    public c(Context context, int i) {
        this.aOw = LayoutInflater.from(context).inflate(w.j.ballot_item_view, (ViewGroup) null);
        this.aOx = (ImageView) this.aOw.findViewById(w.h.ballot_item_image);
        this.auQ = (TextView) this.aOw.findViewById(w.h.ballot_item_title);
        this.aOy = (ProgressBar) this.aOw.findViewById(w.h.ballot_item_progress);
        this.aOz = (TextView) this.aOw.findViewById(w.h.ballot_item_percents);
        this.aOA = this.aOw.findViewById(w.h.ballot_item_preffix_progress);
        this.aOC = k.g(context, w.f.ds28);
        this.aOD = i;
        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
    }

    public void setProgressBarHeight(int i) {
        this.aOC = i;
        this.aOy.getLayoutParams().height = this.aOC;
        this.aOA.getLayoutParams().height = this.aOC;
    }

    public void setProgressBarTopMargin(int i) {
        if (this.aOy.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.aOy.getLayoutParams()).topMargin = i;
        }
        if (this.aOA.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.aOA.getLayoutParams()).topMargin = i;
        }
    }

    public void setDescTopMargin(int i) {
        if (this.aOz.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.aOz.getLayoutParams()).topMargin = i;
        }
    }

    public void fA(int i) {
        if (i >= 0) {
            if (this.aOB != null) {
                int CV = this.aOB.CV();
                i = ((CV <= 100 ? CV : 100) * i) / 100;
            }
            ViewGroup.LayoutParams layoutParams = this.aOy.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(i, this.aOC);
            } else {
                layoutParams.width = i;
            }
            this.aOy.setLayoutParams(layoutParams);
        }
    }

    public int a(a aVar) {
        int intrinsicWidth;
        String string;
        this.aOB = aVar;
        if (aVar == null) {
            return 0;
        }
        if (aVar.CU() <= 0) {
            this.aOx.setImageDrawable(null);
            this.aOx.setVisibility(8);
            intrinsicWidth = 0;
        } else {
            Drawable drawable = aq.getDrawable(aVar.CU());
            this.aOx.setImageDrawable(drawable);
            intrinsicWidth = drawable.getIntrinsicWidth() + this.aOw.getResources().getDimensionPixelSize(w.f.ds24);
            this.aOx.setVisibility(0);
        }
        if (StringUtils.isNull(aVar.CR())) {
            this.auQ.setText((CharSequence) null);
            this.auQ.setVisibility(8);
        } else {
            this.auQ.setText(UtilHelper.getFixedText(aVar.CR(), 15, false));
            this.auQ.setVisibility(0);
        }
        if (aVar.isSelected()) {
            aq.k(this.aOA, w.e.common_color_10271);
        } else {
            aq.k(this.aOA, w.e.common_color_10272);
        }
        boolean isNull = StringUtils.isNull(aVar.CS());
        boolean isNull2 = StringUtils.isNull(aVar.CT());
        if (isNull && isNull2) {
            this.aOz.setText((CharSequence) null);
            this.aOz.setVisibility(8);
            string = null;
        } else {
            this.aOz.setVisibility(0);
            if (isNull) {
                string = aVar.CT();
                this.aOz.setText(string);
            } else if (isNull2) {
                string = aVar.CS();
                this.aOz.setText(string);
            } else {
                string = TbadkCoreApplication.m9getInst().getString(w.l.vote_number_text, new Object[]{aVar.CS(), aVar.CT()});
                this.aOz.setText(string);
            }
        }
        if (!StringUtils.isNull(string)) {
            intrinsicWidth = (int) (intrinsicWidth + this.aOz.getPaint().measureText(string));
        }
        return this.aOw.getResources().getDimensionPixelSize(w.f.ds24) + this.aOw.getResources().getDimensionPixelSize(w.f.ds10) + 8 + intrinsicWidth;
    }

    public void setProgress(float f) {
        if (f >= 0.0f && this.aOB != null) {
            int i = (int) (100.0f * f);
            if (this.aOB.isSelected()) {
                this.aOy.setProgress(i);
                this.aOy.setSecondaryProgress(0);
                return;
            }
            this.aOy.setProgress(0);
            this.aOy.setSecondaryProgress(i);
        }
    }

    public View getView() {
        return this.aOw;
    }

    public void onChangeSkinType(int i) {
        if (this.aOB != null && this.aOB.CU() > 0) {
            aq.c(this.aOx, this.aOB.CU(), i);
        }
        aq.c(this.auQ, w.e.cp_cont_b, 1);
        aq.c(this.aOz, this.aOD, 1);
        this.aOy.setProgressDrawable(aq.getDrawable(w.g.vote_progress_drawable));
        if (this.aOB != null) {
            if (this.aOB.isSelected()) {
                aq.k(this.aOA, w.e.common_color_10271);
            } else {
                aq.k(this.aOA, w.e.common_color_10272);
            }
        }
    }
}
