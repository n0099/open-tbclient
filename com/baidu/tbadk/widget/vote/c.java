package com.baidu.tbadk.widget.vote;

import android.annotation.SuppressLint;
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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes.dex */
public class c {
    private View aSk;
    private ImageView aSl;
    private ProgressBar aSm;
    private TextView aSn;
    private View aSo;
    private a aSp;
    private int aSq;
    private int aSr;
    private TextView axa;

    public c(Context context) {
        this(context, d.e.cp_cont_b);
    }

    public c(Context context, int i) {
        this.aSk = LayoutInflater.from(context).inflate(d.j.ballot_item_view, (ViewGroup) null);
        this.aSl = (ImageView) this.aSk.findViewById(d.h.ballot_item_image);
        this.axa = (TextView) this.aSk.findViewById(d.h.ballot_item_title);
        this.aSm = (ProgressBar) this.aSk.findViewById(d.h.ballot_item_progress);
        this.aSn = (TextView) this.aSk.findViewById(d.h.ballot_item_percents);
        this.aSo = this.aSk.findViewById(d.h.ballot_item_preffix_progress);
        this.aSq = k.f(context, d.f.ds28);
        this.aSr = i;
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setProgressBarHeight(int i) {
        this.aSq = i;
        this.aSm.getLayoutParams().height = this.aSq;
        this.aSo.getLayoutParams().height = this.aSq;
    }

    public void setProgressBarTopMargin(int i) {
        if (this.aSm.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.aSm.getLayoutParams()).topMargin = i;
        }
        if (this.aSo.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.aSo.getLayoutParams()).topMargin = i;
        }
    }

    public void setDescTopMargin(int i) {
        if (this.aSn.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.aSn.getLayoutParams()).topMargin = i;
        }
    }

    public void fG(int i) {
        if (i >= 0) {
            if (this.aSp != null) {
                int CD = this.aSp.CD();
                i = ((CD <= 100 ? CD : 100) * i) / 100;
            }
            ViewGroup.LayoutParams layoutParams = this.aSm.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(i, this.aSq);
            } else {
                layoutParams.width = i;
            }
            this.aSm.setLayoutParams(layoutParams);
        }
    }

    public int a(a aVar) {
        int intrinsicWidth;
        String string;
        this.aSp = aVar;
        if (aVar == null) {
            return 0;
        }
        if (aVar.CC() <= 0) {
            this.aSl.setImageDrawable(null);
            this.aSl.setVisibility(8);
            intrinsicWidth = 0;
        } else {
            Drawable drawable = aj.getDrawable(aVar.CC());
            this.aSl.setImageDrawable(drawable);
            intrinsicWidth = drawable.getIntrinsicWidth() + this.aSk.getResources().getDimensionPixelSize(d.f.ds24);
            this.aSl.setVisibility(0);
        }
        if (StringUtils.isNull(aVar.Cz())) {
            this.axa.setText((CharSequence) null);
            this.axa.setVisibility(8);
        } else {
            this.axa.setText(UtilHelper.getFixedText(aVar.Cz(), 15, false));
            this.axa.setVisibility(0);
        }
        if (aVar.isSelected()) {
            aj.k(this.aSo, d.e.common_color_10271);
        } else {
            aj.k(this.aSo, d.e.common_color_10272);
        }
        boolean isNull = StringUtils.isNull(aVar.CA());
        boolean isNull2 = StringUtils.isNull(aVar.CB());
        if (isNull && isNull2) {
            this.aSn.setText((CharSequence) null);
            this.aSn.setVisibility(8);
            string = null;
        } else {
            this.aSn.setVisibility(0);
            if (isNull) {
                string = aVar.CB();
                this.aSn.setText(string);
            } else if (isNull2) {
                string = aVar.CA();
                this.aSn.setText(string);
            } else {
                string = TbadkCoreApplication.getInst().getString(d.l.vote_number_text, new Object[]{aVar.CA(), aVar.CB()});
                this.aSn.setText(string);
            }
        }
        if (!StringUtils.isNull(string)) {
            intrinsicWidth = (int) (intrinsicWidth + this.aSn.getPaint().measureText(string));
        }
        return this.aSk.getResources().getDimensionPixelSize(d.f.ds24) + this.aSk.getResources().getDimensionPixelSize(d.f.ds10) + 8 + intrinsicWidth;
    }

    public void setProgress(float f) {
        if (f >= 0.0f && this.aSp != null) {
            int i = (int) (100.0f * f);
            if (this.aSp.isSelected()) {
                this.aSm.setProgress(i);
                this.aSm.setSecondaryProgress(0);
                return;
            }
            this.aSm.setProgress(0);
            this.aSm.setSecondaryProgress(i);
        }
    }

    public View getView() {
        return this.aSk;
    }

    public void onChangeSkinType(int i) {
        if (this.aSp != null && this.aSp.CC() > 0) {
            aj.b(this.aSl, this.aSp.CC(), i);
        }
        aj.c(this.axa, d.e.cp_cont_b, 1);
        aj.c(this.aSn, this.aSr, 1);
        this.aSm.setProgressDrawable(aj.getDrawable(d.g.vote_progress_drawable));
        if (this.aSp != null) {
            if (this.aSp.isSelected()) {
                aj.k(this.aSo, d.e.common_color_10271);
            } else {
                aj.k(this.aSo, d.e.common_color_10272);
            }
        }
    }
}
