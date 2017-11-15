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
    private View aTi;
    private ImageView aTj;
    private ProgressBar aTk;
    private TextView aTl;
    private View aTm;
    private a aTn;
    private int aTo;
    private int aTp;
    private TextView awD;

    public c(Context context) {
        this(context, d.C0080d.cp_cont_b);
    }

    public c(Context context, int i) {
        this.aTi = LayoutInflater.from(context).inflate(d.h.ballot_item_view, (ViewGroup) null);
        this.aTj = (ImageView) this.aTi.findViewById(d.g.ballot_item_image);
        this.awD = (TextView) this.aTi.findViewById(d.g.ballot_item_title);
        this.aTk = (ProgressBar) this.aTi.findViewById(d.g.ballot_item_progress);
        this.aTl = (TextView) this.aTi.findViewById(d.g.ballot_item_percents);
        this.aTm = this.aTi.findViewById(d.g.ballot_item_preffix_progress);
        this.aTo = l.f(context, d.e.ds28);
        this.aTp = i;
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setProgressBarHeight(int i) {
        this.aTo = i;
        this.aTk.getLayoutParams().height = this.aTo;
        this.aTm.getLayoutParams().height = this.aTo;
    }

    public void setProgressBarTopMargin(int i) {
        if (this.aTk.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.aTk.getLayoutParams()).topMargin = i;
        }
        if (this.aTm.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.aTm.getLayoutParams()).topMargin = i;
        }
    }

    public void setDescTopMargin(int i) {
        if (this.aTl.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.aTl.getLayoutParams()).topMargin = i;
        }
    }

    public void ga(int i) {
        if (i >= 0) {
            if (this.aTn != null) {
                int CC = this.aTn.CC();
                i = ((CC <= 100 ? CC : 100) * i) / 100;
            }
            ViewGroup.LayoutParams layoutParams = this.aTk.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(i, this.aTo);
            } else {
                layoutParams.width = i;
            }
            this.aTk.setLayoutParams(layoutParams);
        }
    }

    public int a(a aVar) {
        int intrinsicWidth;
        String string;
        this.aTn = aVar;
        if (aVar == null) {
            return 0;
        }
        if (aVar.CB() <= 0) {
            this.aTj.setImageDrawable(null);
            this.aTj.setVisibility(8);
            intrinsicWidth = 0;
        } else {
            Drawable drawable = aj.getDrawable(aVar.CB());
            this.aTj.setImageDrawable(drawable);
            intrinsicWidth = drawable.getIntrinsicWidth() + this.aTi.getResources().getDimensionPixelSize(d.e.ds24);
            this.aTj.setVisibility(0);
        }
        if (StringUtils.isNull(aVar.Cy())) {
            this.awD.setText((CharSequence) null);
            this.awD.setVisibility(8);
        } else {
            this.awD.setText(UtilHelper.getFixedText(aVar.Cy(), 15, false));
            this.awD.setVisibility(0);
        }
        if (aVar.isSelected()) {
            aj.k(this.aTm, d.C0080d.common_color_10271);
        } else {
            aj.k(this.aTm, d.C0080d.common_color_10272);
        }
        boolean isNull = StringUtils.isNull(aVar.Cz());
        boolean isNull2 = StringUtils.isNull(aVar.CA());
        if (isNull && isNull2) {
            this.aTl.setText((CharSequence) null);
            this.aTl.setVisibility(8);
            string = null;
        } else {
            this.aTl.setVisibility(0);
            if (isNull) {
                string = aVar.CA();
                this.aTl.setText(string);
            } else if (isNull2) {
                string = aVar.Cz();
                this.aTl.setText(string);
            } else {
                string = TbadkCoreApplication.getInst().getString(d.j.vote_number_text, new Object[]{aVar.Cz(), aVar.CA()});
                this.aTl.setText(string);
            }
        }
        if (!StringUtils.isNull(string)) {
            intrinsicWidth = (int) (intrinsicWidth + this.aTl.getPaint().measureText(string));
        }
        return this.aTi.getResources().getDimensionPixelSize(d.e.ds24) + this.aTi.getResources().getDimensionPixelSize(d.e.ds10) + 8 + intrinsicWidth;
    }

    public void setProgress(float f) {
        if (f >= 0.0f && this.aTn != null) {
            int i = (int) (100.0f * f);
            if (this.aTn.isSelected()) {
                this.aTk.setProgress(i);
                this.aTk.setSecondaryProgress(0);
                return;
            }
            this.aTk.setProgress(0);
            this.aTk.setSecondaryProgress(i);
        }
    }

    public View getView() {
        return this.aTi;
    }

    public void onChangeSkinType(int i) {
        if (this.aTn != null && this.aTn.CB() > 0) {
            aj.b(this.aTj, this.aTn.CB(), i);
        }
        aj.c(this.awD, d.C0080d.cp_cont_b, 1);
        aj.c(this.aTl, this.aTp, 1);
        this.aTk.setProgressDrawable(aj.getDrawable(d.f.vote_progress_drawable));
        if (this.aTn != null) {
            if (this.aTn.isSelected()) {
                aj.k(this.aTm, d.C0080d.common_color_10271);
            } else {
                aj.k(this.aTm, d.C0080d.common_color_10272);
            }
        }
    }
}
