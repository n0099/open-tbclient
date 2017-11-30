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
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes.dex */
public class c {
    private View aWj;
    private ImageView aWk;
    private ProgressBar aWl;
    private TextView aWm;
    private View aWn;
    private a aWo;
    private int aWp;
    private int aWq;
    private TextView axe;

    public c(Context context) {
        this(context, d.C0082d.cp_cont_b);
    }

    public c(Context context, int i) {
        this.aWj = LayoutInflater.from(context).inflate(d.h.ballot_item_view, (ViewGroup) null);
        this.aWk = (ImageView) this.aWj.findViewById(d.g.ballot_item_image);
        this.axe = (TextView) this.aWj.findViewById(d.g.ballot_item_title);
        this.aWl = (ProgressBar) this.aWj.findViewById(d.g.ballot_item_progress);
        this.aWm = (TextView) this.aWj.findViewById(d.g.ballot_item_percents);
        this.aWn = this.aWj.findViewById(d.g.ballot_item_preffix_progress);
        this.aWp = l.f(context, d.e.ds28);
        this.aWq = i;
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setProgressBarHeight(int i) {
        this.aWp = i;
        this.aWl.getLayoutParams().height = this.aWp;
        this.aWn.getLayoutParams().height = this.aWp;
    }

    public void setProgressBarTopMargin(int i) {
        if (this.aWl.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.aWl.getLayoutParams()).topMargin = i;
        }
        if (this.aWn.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.aWn.getLayoutParams()).topMargin = i;
        }
    }

    public void setDescTopMargin(int i) {
        if (this.aWm.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.aWm.getLayoutParams()).topMargin = i;
        }
    }

    public void gi(int i) {
        if (i >= 0) {
            if (this.aWo != null) {
                int CL = this.aWo.CL();
                i = ((CL <= 100 ? CL : 100) * i) / 100;
            }
            ViewGroup.LayoutParams layoutParams = this.aWl.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(i, this.aWp);
            } else {
                layoutParams.width = i;
            }
            this.aWl.setLayoutParams(layoutParams);
        }
    }

    public int a(a aVar) {
        int intrinsicWidth;
        String string;
        this.aWo = aVar;
        if (aVar == null) {
            return 0;
        }
        if (aVar.CK() <= 0) {
            this.aWk.setImageDrawable(null);
            this.aWk.setVisibility(8);
            intrinsicWidth = 0;
        } else {
            Drawable drawable = aj.getDrawable(aVar.CK());
            this.aWk.setImageDrawable(drawable);
            intrinsicWidth = drawable.getIntrinsicWidth() + this.aWj.getResources().getDimensionPixelSize(d.e.ds24);
            this.aWk.setVisibility(0);
        }
        if (StringUtils.isNull(aVar.CH())) {
            this.axe.setText((CharSequence) null);
            this.axe.setVisibility(8);
        } else {
            this.axe.setText(UtilHelper.getFixedText(aVar.CH(), 15, false));
            this.axe.setVisibility(0);
        }
        if (aVar.isSelected()) {
            aj.k(this.aWn, d.C0082d.common_color_10271);
        } else {
            aj.k(this.aWn, d.C0082d.common_color_10272);
        }
        boolean isNull = StringUtils.isNull(aVar.CI());
        boolean isNull2 = StringUtils.isNull(aVar.CJ());
        if (isNull && isNull2) {
            this.aWm.setText((CharSequence) null);
            this.aWm.setVisibility(8);
            string = null;
        } else {
            this.aWm.setVisibility(0);
            if (isNull) {
                string = aVar.CJ();
                this.aWm.setText(string);
            } else if (isNull2) {
                string = aVar.CI();
                this.aWm.setText(string);
            } else {
                string = TbadkCoreApplication.getInst().getString(d.j.vote_number_text, new Object[]{aVar.CI(), aVar.CJ()});
                this.aWm.setText(string);
            }
        }
        if (!StringUtils.isNull(string)) {
            intrinsicWidth = (int) (intrinsicWidth + this.aWm.getPaint().measureText(string));
        }
        return this.aWj.getResources().getDimensionPixelSize(d.e.ds24) + this.aWj.getResources().getDimensionPixelSize(d.e.ds10) + 8 + intrinsicWidth;
    }

    public void setProgress(float f) {
        if (f >= 0.0f && this.aWo != null) {
            int i = (int) (100.0f * f);
            if (this.aWo.isSelected()) {
                this.aWl.setProgress(i);
                this.aWl.setSecondaryProgress(0);
                return;
            }
            this.aWl.setProgress(0);
            this.aWl.setSecondaryProgress(i);
        }
    }

    public View getView() {
        return this.aWj;
    }

    public void onChangeSkinType(int i) {
        if (this.aWo != null && this.aWo.CK() > 0) {
            aj.b(this.aWk, this.aWo.CK(), i);
        }
        aj.c(this.axe, d.C0082d.cp_cont_b, 1);
        aj.c(this.aWm, this.aWq, 1);
        this.aWl.setProgressDrawable(aj.getDrawable(d.f.vote_progress_drawable));
        if (this.aWo != null) {
            if (this.aWo.isSelected()) {
                aj.k(this.aWn, d.C0082d.common_color_10271);
            } else {
                aj.k(this.aWn, d.C0082d.common_color_10272);
            }
        }
    }
}
