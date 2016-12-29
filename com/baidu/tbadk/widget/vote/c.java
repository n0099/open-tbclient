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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class c {
    private View aKa;
    private ImageView aKb;
    private ProgressBar aKc;
    private TextView aKd;
    private View aKe;
    private a aKf;
    private int aKg;
    private int aKh;
    private TextView apY;

    public c(Context context) {
        this(context, r.d.cp_cont_b);
    }

    public c(Context context, int i) {
        this.aKa = LayoutInflater.from(context).inflate(r.h.ballot_item_view, (ViewGroup) null);
        this.aKb = (ImageView) this.aKa.findViewById(r.g.ballot_item_image);
        this.apY = (TextView) this.aKa.findViewById(r.g.ballot_item_title);
        this.aKc = (ProgressBar) this.aKa.findViewById(r.g.ballot_item_progress);
        this.aKd = (TextView) this.aKa.findViewById(r.g.ballot_item_percents);
        this.aKe = this.aKa.findViewById(r.g.ballot_item_preffix_progress);
        this.aKg = k.e(context, r.e.ds28);
        this.aKh = i;
        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
    }

    public void setProgressBarHeight(int i) {
        this.aKg = i;
        this.aKc.getLayoutParams().height = this.aKg;
        this.aKe.getLayoutParams().height = this.aKg;
    }

    public void setProgressBarTopMargin(int i) {
        if (this.aKc.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.aKc.getLayoutParams()).topMargin = i;
        }
        if (this.aKe.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.aKe.getLayoutParams()).topMargin = i;
        }
    }

    public void setDescTopMargin(int i) {
        if (this.aKd.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.aKd.getLayoutParams()).topMargin = i;
        }
    }

    public void fC(int i) {
        if (i >= 0) {
            if (this.aKf != null) {
                int Ci = this.aKf.Ci();
                i = ((Ci <= 100 ? Ci : 100) * i) / 100;
            }
            ViewGroup.LayoutParams layoutParams = this.aKc.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(i, this.aKg);
            } else {
                layoutParams.width = i;
            }
            this.aKc.setLayoutParams(layoutParams);
        }
    }

    public int a(a aVar) {
        int intrinsicWidth;
        String string;
        this.aKf = aVar;
        if (aVar == null) {
            return 0;
        }
        if (aVar.Ch() <= 0) {
            this.aKb.setImageDrawable(null);
            this.aKb.setVisibility(8);
            intrinsicWidth = 0;
        } else {
            Drawable drawable = ar.getDrawable(aVar.Ch());
            this.aKb.setImageDrawable(drawable);
            intrinsicWidth = drawable.getIntrinsicWidth() + this.aKa.getResources().getDimensionPixelSize(r.e.ds24);
            this.aKb.setVisibility(0);
        }
        if (StringUtils.isNull(aVar.Ce())) {
            this.apY.setText((CharSequence) null);
            this.apY.setVisibility(8);
        } else {
            this.apY.setText(UtilHelper.getFixedText(aVar.Ce(), 15, false));
            this.apY.setVisibility(0);
        }
        if (aVar.isSelected()) {
            ar.l(this.aKe, r.d.common_color_10271);
        } else {
            ar.l(this.aKe, r.d.common_color_10272);
        }
        boolean isNull = StringUtils.isNull(aVar.Cf());
        boolean isNull2 = StringUtils.isNull(aVar.Cg());
        if (isNull && isNull2) {
            this.aKd.setText((CharSequence) null);
            this.aKd.setVisibility(8);
            string = null;
        } else {
            this.aKd.setVisibility(0);
            if (isNull) {
                string = aVar.Cg();
                this.aKd.setText(string);
            } else if (isNull2) {
                string = aVar.Cf();
                this.aKd.setText(string);
            } else {
                string = TbadkCoreApplication.m9getInst().getString(r.j.vote_number_text, new Object[]{aVar.Cf(), aVar.Cg()});
                this.aKd.setText(string);
            }
        }
        if (!StringUtils.isNull(string)) {
            intrinsicWidth = (int) (intrinsicWidth + this.aKd.getPaint().measureText(string));
        }
        return this.aKa.getResources().getDimensionPixelSize(r.e.ds24) + this.aKa.getResources().getDimensionPixelSize(r.e.ds10) + 8 + intrinsicWidth;
    }

    public void setProgress(float f) {
        if (f >= 0.0f && this.aKf != null) {
            int i = (int) (100.0f * f);
            if (this.aKf.isSelected()) {
                this.aKc.setProgress(i);
                this.aKc.setSecondaryProgress(0);
                return;
            }
            this.aKc.setProgress(0);
            this.aKc.setSecondaryProgress(i);
        }
    }

    public View getView() {
        return this.aKa;
    }

    public void onChangeSkinType(int i) {
        if (this.aKf != null && this.aKf.Ch() > 0) {
            ar.c(this.aKb, this.aKf.Ch(), i);
        }
        ar.c(this.apY, r.d.cp_cont_b, 1);
        ar.c(this.aKd, this.aKh, 1);
        this.aKc.setProgressDrawable(ar.getDrawable(r.f.vote_progress_drawable));
        if (this.aKf != null) {
            if (this.aKf.isSelected()) {
                ar.l(this.aKe, r.d.common_color_10271);
            } else {
                ar.l(this.aKe, r.d.common_color_10272);
            }
        }
    }
}
