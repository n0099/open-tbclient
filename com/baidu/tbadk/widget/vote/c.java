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
    private View aTa;
    private ImageView aTb;
    private ProgressBar aTc;
    private TextView aTd;
    private View aTe;
    private a aTf;
    private int aTg;
    private int aTh;
    private TextView awv;

    public c(Context context) {
        this(context, d.C0080d.cp_cont_b);
    }

    public c(Context context, int i) {
        this.aTa = LayoutInflater.from(context).inflate(d.h.ballot_item_view, (ViewGroup) null);
        this.aTb = (ImageView) this.aTa.findViewById(d.g.ballot_item_image);
        this.awv = (TextView) this.aTa.findViewById(d.g.ballot_item_title);
        this.aTc = (ProgressBar) this.aTa.findViewById(d.g.ballot_item_progress);
        this.aTd = (TextView) this.aTa.findViewById(d.g.ballot_item_percents);
        this.aTe = this.aTa.findViewById(d.g.ballot_item_preffix_progress);
        this.aTg = l.f(context, d.e.ds28);
        this.aTh = i;
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setProgressBarHeight(int i) {
        this.aTg = i;
        this.aTc.getLayoutParams().height = this.aTg;
        this.aTe.getLayoutParams().height = this.aTg;
    }

    public void setProgressBarTopMargin(int i) {
        if (this.aTc.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.aTc.getLayoutParams()).topMargin = i;
        }
        if (this.aTe.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.aTe.getLayoutParams()).topMargin = i;
        }
    }

    public void setDescTopMargin(int i) {
        if (this.aTd.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.aTd.getLayoutParams()).topMargin = i;
        }
    }

    public void gb(int i) {
        if (i >= 0) {
            if (this.aTf != null) {
                int Cq = this.aTf.Cq();
                i = ((Cq <= 100 ? Cq : 100) * i) / 100;
            }
            ViewGroup.LayoutParams layoutParams = this.aTc.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(i, this.aTg);
            } else {
                layoutParams.width = i;
            }
            this.aTc.setLayoutParams(layoutParams);
        }
    }

    public int a(a aVar) {
        int intrinsicWidth;
        String string;
        this.aTf = aVar;
        if (aVar == null) {
            return 0;
        }
        if (aVar.Cp() <= 0) {
            this.aTb.setImageDrawable(null);
            this.aTb.setVisibility(8);
            intrinsicWidth = 0;
        } else {
            Drawable drawable = aj.getDrawable(aVar.Cp());
            this.aTb.setImageDrawable(drawable);
            intrinsicWidth = drawable.getIntrinsicWidth() + this.aTa.getResources().getDimensionPixelSize(d.e.ds24);
            this.aTb.setVisibility(0);
        }
        if (StringUtils.isNull(aVar.Cm())) {
            this.awv.setText((CharSequence) null);
            this.awv.setVisibility(8);
        } else {
            this.awv.setText(UtilHelper.getFixedText(aVar.Cm(), 15, false));
            this.awv.setVisibility(0);
        }
        if (aVar.isSelected()) {
            aj.k(this.aTe, d.C0080d.common_color_10271);
        } else {
            aj.k(this.aTe, d.C0080d.common_color_10272);
        }
        boolean isNull = StringUtils.isNull(aVar.Cn());
        boolean isNull2 = StringUtils.isNull(aVar.Co());
        if (isNull && isNull2) {
            this.aTd.setText((CharSequence) null);
            this.aTd.setVisibility(8);
            string = null;
        } else {
            this.aTd.setVisibility(0);
            if (isNull) {
                string = aVar.Co();
                this.aTd.setText(string);
            } else if (isNull2) {
                string = aVar.Cn();
                this.aTd.setText(string);
            } else {
                string = TbadkCoreApplication.getInst().getString(d.j.vote_number_text, new Object[]{aVar.Cn(), aVar.Co()});
                this.aTd.setText(string);
            }
        }
        if (!StringUtils.isNull(string)) {
            intrinsicWidth = (int) (intrinsicWidth + this.aTd.getPaint().measureText(string));
        }
        return this.aTa.getResources().getDimensionPixelSize(d.e.ds24) + this.aTa.getResources().getDimensionPixelSize(d.e.ds10) + 8 + intrinsicWidth;
    }

    public void setProgress(float f) {
        if (f >= 0.0f && this.aTf != null) {
            int i = (int) (100.0f * f);
            if (this.aTf.isSelected()) {
                this.aTc.setProgress(i);
                this.aTc.setSecondaryProgress(0);
                return;
            }
            this.aTc.setProgress(0);
            this.aTc.setSecondaryProgress(i);
        }
    }

    public View getView() {
        return this.aTa;
    }

    public void onChangeSkinType(int i) {
        if (this.aTf != null && this.aTf.Cp() > 0) {
            aj.b(this.aTb, this.aTf.Cp(), i);
        }
        aj.c(this.awv, d.C0080d.cp_cont_b, 1);
        aj.c(this.aTd, this.aTh, 1);
        this.aTc.setProgressDrawable(aj.getDrawable(d.f.vote_progress_drawable));
        if (this.aTf != null) {
            if (this.aTf.isSelected()) {
                aj.k(this.aTe, d.C0080d.common_color_10271);
            } else {
                aj.k(this.aTe, d.C0080d.common_color_10272);
            }
        }
    }
}
