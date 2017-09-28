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
    private View aTj;
    private ImageView aTk;
    private ProgressBar aTl;
    private TextView aTm;
    private View aTn;
    private a aTo;
    private int aTp;
    private int aTq;
    private TextView awk;

    public c(Context context) {
        this(context, d.e.cp_cont_b);
    }

    public c(Context context, int i) {
        this.aTj = LayoutInflater.from(context).inflate(d.j.ballot_item_view, (ViewGroup) null);
        this.aTk = (ImageView) this.aTj.findViewById(d.h.ballot_item_image);
        this.awk = (TextView) this.aTj.findViewById(d.h.ballot_item_title);
        this.aTl = (ProgressBar) this.aTj.findViewById(d.h.ballot_item_progress);
        this.aTm = (TextView) this.aTj.findViewById(d.h.ballot_item_percents);
        this.aTn = this.aTj.findViewById(d.h.ballot_item_preffix_progress);
        this.aTp = l.f(context, d.f.ds28);
        this.aTq = i;
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setProgressBarHeight(int i) {
        this.aTp = i;
        this.aTl.getLayoutParams().height = this.aTp;
        this.aTn.getLayoutParams().height = this.aTp;
    }

    public void setProgressBarTopMargin(int i) {
        if (this.aTl.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.aTl.getLayoutParams()).topMargin = i;
        }
        if (this.aTn.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.aTn.getLayoutParams()).topMargin = i;
        }
    }

    public void setDescTopMargin(int i) {
        if (this.aTm.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.aTm.getLayoutParams()).topMargin = i;
        }
    }

    public void fT(int i) {
        if (i >= 0) {
            if (this.aTo != null) {
                int Ch = this.aTo.Ch();
                i = ((Ch <= 100 ? Ch : 100) * i) / 100;
            }
            ViewGroup.LayoutParams layoutParams = this.aTl.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(i, this.aTp);
            } else {
                layoutParams.width = i;
            }
            this.aTl.setLayoutParams(layoutParams);
        }
    }

    public int a(a aVar) {
        int intrinsicWidth;
        String string;
        this.aTo = aVar;
        if (aVar == null) {
            return 0;
        }
        if (aVar.Cg() <= 0) {
            this.aTk.setImageDrawable(null);
            this.aTk.setVisibility(8);
            intrinsicWidth = 0;
        } else {
            Drawable drawable = aj.getDrawable(aVar.Cg());
            this.aTk.setImageDrawable(drawable);
            intrinsicWidth = drawable.getIntrinsicWidth() + this.aTj.getResources().getDimensionPixelSize(d.f.ds24);
            this.aTk.setVisibility(0);
        }
        if (StringUtils.isNull(aVar.Cd())) {
            this.awk.setText((CharSequence) null);
            this.awk.setVisibility(8);
        } else {
            this.awk.setText(UtilHelper.getFixedText(aVar.Cd(), 15, false));
            this.awk.setVisibility(0);
        }
        if (aVar.isSelected()) {
            aj.k(this.aTn, d.e.common_color_10271);
        } else {
            aj.k(this.aTn, d.e.common_color_10272);
        }
        boolean isNull = StringUtils.isNull(aVar.Ce());
        boolean isNull2 = StringUtils.isNull(aVar.Cf());
        if (isNull && isNull2) {
            this.aTm.setText((CharSequence) null);
            this.aTm.setVisibility(8);
            string = null;
        } else {
            this.aTm.setVisibility(0);
            if (isNull) {
                string = aVar.Cf();
                this.aTm.setText(string);
            } else if (isNull2) {
                string = aVar.Ce();
                this.aTm.setText(string);
            } else {
                string = TbadkCoreApplication.getInst().getString(d.l.vote_number_text, new Object[]{aVar.Ce(), aVar.Cf()});
                this.aTm.setText(string);
            }
        }
        if (!StringUtils.isNull(string)) {
            intrinsicWidth = (int) (intrinsicWidth + this.aTm.getPaint().measureText(string));
        }
        return this.aTj.getResources().getDimensionPixelSize(d.f.ds24) + this.aTj.getResources().getDimensionPixelSize(d.f.ds10) + 8 + intrinsicWidth;
    }

    public void setProgress(float f) {
        if (f >= 0.0f && this.aTo != null) {
            int i = (int) (100.0f * f);
            if (this.aTo.isSelected()) {
                this.aTl.setProgress(i);
                this.aTl.setSecondaryProgress(0);
                return;
            }
            this.aTl.setProgress(0);
            this.aTl.setSecondaryProgress(i);
        }
    }

    public View getView() {
        return this.aTj;
    }

    public void onChangeSkinType(int i) {
        if (this.aTo != null && this.aTo.Cg() > 0) {
            aj.b(this.aTk, this.aTo.Cg(), i);
        }
        aj.c(this.awk, d.e.cp_cont_b, 1);
        aj.c(this.aTm, this.aTq, 1);
        this.aTl.setProgressDrawable(aj.getDrawable(d.g.vote_progress_drawable));
        if (this.aTo != null) {
            if (this.aTo.isSelected()) {
                aj.k(this.aTn, d.e.common_color_10271);
            } else {
                aj.k(this.aTn, d.e.common_color_10272);
            }
        }
    }
}
