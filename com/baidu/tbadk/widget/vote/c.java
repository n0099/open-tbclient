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
    private View aOP;
    private ImageView aOQ;
    private ProgressBar aOR;
    private TextView aOS;
    private View aOT;
    private a aOU;
    private int aOV;
    private int aOW;
    private TextView auU;

    public c(Context context) {
        this(context, w.e.cp_cont_b);
    }

    public c(Context context, int i) {
        this.aOP = LayoutInflater.from(context).inflate(w.j.ballot_item_view, (ViewGroup) null);
        this.aOQ = (ImageView) this.aOP.findViewById(w.h.ballot_item_image);
        this.auU = (TextView) this.aOP.findViewById(w.h.ballot_item_title);
        this.aOR = (ProgressBar) this.aOP.findViewById(w.h.ballot_item_progress);
        this.aOS = (TextView) this.aOP.findViewById(w.h.ballot_item_percents);
        this.aOT = this.aOP.findViewById(w.h.ballot_item_preffix_progress);
        this.aOV = k.g(context, w.f.ds28);
        this.aOW = i;
        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
    }

    public void setProgressBarHeight(int i) {
        this.aOV = i;
        this.aOR.getLayoutParams().height = this.aOV;
        this.aOT.getLayoutParams().height = this.aOV;
    }

    public void setProgressBarTopMargin(int i) {
        if (this.aOR.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.aOR.getLayoutParams()).topMargin = i;
        }
        if (this.aOT.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.aOT.getLayoutParams()).topMargin = i;
        }
    }

    public void setDescTopMargin(int i) {
        if (this.aOS.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.aOS.getLayoutParams()).topMargin = i;
        }
    }

    public void fx(int i) {
        if (i >= 0) {
            if (this.aOU != null) {
                int Ca = this.aOU.Ca();
                i = ((Ca <= 100 ? Ca : 100) * i) / 100;
            }
            ViewGroup.LayoutParams layoutParams = this.aOR.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(i, this.aOV);
            } else {
                layoutParams.width = i;
            }
            this.aOR.setLayoutParams(layoutParams);
        }
    }

    public int a(a aVar) {
        int intrinsicWidth;
        String string;
        this.aOU = aVar;
        if (aVar == null) {
            return 0;
        }
        if (aVar.BZ() <= 0) {
            this.aOQ.setImageDrawable(null);
            this.aOQ.setVisibility(8);
            intrinsicWidth = 0;
        } else {
            Drawable drawable = aq.getDrawable(aVar.BZ());
            this.aOQ.setImageDrawable(drawable);
            intrinsicWidth = drawable.getIntrinsicWidth() + this.aOP.getResources().getDimensionPixelSize(w.f.ds24);
            this.aOQ.setVisibility(0);
        }
        if (StringUtils.isNull(aVar.BW())) {
            this.auU.setText((CharSequence) null);
            this.auU.setVisibility(8);
        } else {
            this.auU.setText(UtilHelper.getFixedText(aVar.BW(), 15, false));
            this.auU.setVisibility(0);
        }
        if (aVar.isSelected()) {
            aq.k(this.aOT, w.e.common_color_10271);
        } else {
            aq.k(this.aOT, w.e.common_color_10272);
        }
        boolean isNull = StringUtils.isNull(aVar.BX());
        boolean isNull2 = StringUtils.isNull(aVar.BY());
        if (isNull && isNull2) {
            this.aOS.setText((CharSequence) null);
            this.aOS.setVisibility(8);
            string = null;
        } else {
            this.aOS.setVisibility(0);
            if (isNull) {
                string = aVar.BY();
                this.aOS.setText(string);
            } else if (isNull2) {
                string = aVar.BX();
                this.aOS.setText(string);
            } else {
                string = TbadkCoreApplication.m9getInst().getString(w.l.vote_number_text, new Object[]{aVar.BX(), aVar.BY()});
                this.aOS.setText(string);
            }
        }
        if (!StringUtils.isNull(string)) {
            intrinsicWidth = (int) (intrinsicWidth + this.aOS.getPaint().measureText(string));
        }
        return this.aOP.getResources().getDimensionPixelSize(w.f.ds24) + this.aOP.getResources().getDimensionPixelSize(w.f.ds10) + 8 + intrinsicWidth;
    }

    public void setProgress(float f) {
        if (f >= 0.0f && this.aOU != null) {
            int i = (int) (100.0f * f);
            if (this.aOU.isSelected()) {
                this.aOR.setProgress(i);
                this.aOR.setSecondaryProgress(0);
                return;
            }
            this.aOR.setProgress(0);
            this.aOR.setSecondaryProgress(i);
        }
    }

    public View getView() {
        return this.aOP;
    }

    public void onChangeSkinType(int i) {
        if (this.aOU != null && this.aOU.BZ() > 0) {
            aq.c(this.aOQ, this.aOU.BZ(), i);
        }
        aq.c(this.auU, w.e.cp_cont_b, 1);
        aq.c(this.aOS, this.aOW, 1);
        this.aOR.setProgressDrawable(aq.getDrawable(w.g.vote_progress_drawable));
        if (this.aOU != null) {
            if (this.aOU.isSelected()) {
                aq.k(this.aOT, w.e.common_color_10271);
            } else {
                aq.k(this.aOT, w.e.common_color_10272);
            }
        }
    }
}
