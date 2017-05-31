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
    private View aOO;
    private ImageView aOP;
    private ProgressBar aOQ;
    private TextView aOR;
    private View aOS;
    private a aOT;
    private int aOU;
    private int aOV;
    private TextView auE;

    public c(Context context) {
        this(context, w.e.cp_cont_b);
    }

    public c(Context context, int i) {
        this.aOO = LayoutInflater.from(context).inflate(w.j.ballot_item_view, (ViewGroup) null);
        this.aOP = (ImageView) this.aOO.findViewById(w.h.ballot_item_image);
        this.auE = (TextView) this.aOO.findViewById(w.h.ballot_item_title);
        this.aOQ = (ProgressBar) this.aOO.findViewById(w.h.ballot_item_progress);
        this.aOR = (TextView) this.aOO.findViewById(w.h.ballot_item_percents);
        this.aOS = this.aOO.findViewById(w.h.ballot_item_preffix_progress);
        this.aOU = k.g(context, w.f.ds28);
        this.aOV = i;
        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
    }

    public void setProgressBarHeight(int i) {
        this.aOU = i;
        this.aOQ.getLayoutParams().height = this.aOU;
        this.aOS.getLayoutParams().height = this.aOU;
    }

    public void setProgressBarTopMargin(int i) {
        if (this.aOQ.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.aOQ.getLayoutParams()).topMargin = i;
        }
        if (this.aOS.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.aOS.getLayoutParams()).topMargin = i;
        }
    }

    public void setDescTopMargin(int i) {
        if (this.aOR.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.aOR.getLayoutParams()).topMargin = i;
        }
    }

    public void fy(int i) {
        if (i >= 0) {
            if (this.aOT != null) {
                int BU = this.aOT.BU();
                i = ((BU <= 100 ? BU : 100) * i) / 100;
            }
            ViewGroup.LayoutParams layoutParams = this.aOQ.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(i, this.aOU);
            } else {
                layoutParams.width = i;
            }
            this.aOQ.setLayoutParams(layoutParams);
        }
    }

    public int a(a aVar) {
        int intrinsicWidth;
        String string;
        this.aOT = aVar;
        if (aVar == null) {
            return 0;
        }
        if (aVar.BT() <= 0) {
            this.aOP.setImageDrawable(null);
            this.aOP.setVisibility(8);
            intrinsicWidth = 0;
        } else {
            Drawable drawable = aq.getDrawable(aVar.BT());
            this.aOP.setImageDrawable(drawable);
            intrinsicWidth = drawable.getIntrinsicWidth() + this.aOO.getResources().getDimensionPixelSize(w.f.ds24);
            this.aOP.setVisibility(0);
        }
        if (StringUtils.isNull(aVar.BQ())) {
            this.auE.setText((CharSequence) null);
            this.auE.setVisibility(8);
        } else {
            this.auE.setText(UtilHelper.getFixedText(aVar.BQ(), 15, false));
            this.auE.setVisibility(0);
        }
        if (aVar.isSelected()) {
            aq.k(this.aOS, w.e.common_color_10271);
        } else {
            aq.k(this.aOS, w.e.common_color_10272);
        }
        boolean isNull = StringUtils.isNull(aVar.BR());
        boolean isNull2 = StringUtils.isNull(aVar.BS());
        if (isNull && isNull2) {
            this.aOR.setText((CharSequence) null);
            this.aOR.setVisibility(8);
            string = null;
        } else {
            this.aOR.setVisibility(0);
            if (isNull) {
                string = aVar.BS();
                this.aOR.setText(string);
            } else if (isNull2) {
                string = aVar.BR();
                this.aOR.setText(string);
            } else {
                string = TbadkCoreApplication.m9getInst().getString(w.l.vote_number_text, new Object[]{aVar.BR(), aVar.BS()});
                this.aOR.setText(string);
            }
        }
        if (!StringUtils.isNull(string)) {
            intrinsicWidth = (int) (intrinsicWidth + this.aOR.getPaint().measureText(string));
        }
        return this.aOO.getResources().getDimensionPixelSize(w.f.ds24) + this.aOO.getResources().getDimensionPixelSize(w.f.ds10) + 8 + intrinsicWidth;
    }

    public void setProgress(float f) {
        if (f >= 0.0f && this.aOT != null) {
            int i = (int) (100.0f * f);
            if (this.aOT.isSelected()) {
                this.aOQ.setProgress(i);
                this.aOQ.setSecondaryProgress(0);
                return;
            }
            this.aOQ.setProgress(0);
            this.aOQ.setSecondaryProgress(i);
        }
    }

    public View getView() {
        return this.aOO;
    }

    public void onChangeSkinType(int i) {
        if (this.aOT != null && this.aOT.BT() > 0) {
            aq.c(this.aOP, this.aOT.BT(), i);
        }
        aq.c(this.auE, w.e.cp_cont_b, 1);
        aq.c(this.aOR, this.aOV, 1);
        this.aOQ.setProgressDrawable(aq.getDrawable(w.g.vote_progress_drawable));
        if (this.aOT != null) {
            if (this.aOT.isSelected()) {
                aq.k(this.aOS, w.e.common_color_10271);
            } else {
                aq.k(this.aOS, w.e.common_color_10272);
            }
        }
    }
}
