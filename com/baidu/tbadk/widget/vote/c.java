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
    private View aSW;
    private ImageView aSX;
    private ProgressBar aSY;
    private TextView aSZ;
    private View aTa;
    private a aTb;
    private int aTc;
    private int aTd;
    private TextView avY;

    public c(Context context) {
        this(context, d.e.cp_cont_b);
    }

    public c(Context context, int i) {
        this.aSW = LayoutInflater.from(context).inflate(d.j.ballot_item_view, (ViewGroup) null);
        this.aSX = (ImageView) this.aSW.findViewById(d.h.ballot_item_image);
        this.avY = (TextView) this.aSW.findViewById(d.h.ballot_item_title);
        this.aSY = (ProgressBar) this.aSW.findViewById(d.h.ballot_item_progress);
        this.aSZ = (TextView) this.aSW.findViewById(d.h.ballot_item_percents);
        this.aTa = this.aSW.findViewById(d.h.ballot_item_preffix_progress);
        this.aTc = l.f(context, d.f.ds28);
        this.aTd = i;
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setProgressBarHeight(int i) {
        this.aTc = i;
        this.aSY.getLayoutParams().height = this.aTc;
        this.aTa.getLayoutParams().height = this.aTc;
    }

    public void setProgressBarTopMargin(int i) {
        if (this.aSY.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.aSY.getLayoutParams()).topMargin = i;
        }
        if (this.aTa.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.aTa.getLayoutParams()).topMargin = i;
        }
    }

    public void setDescTopMargin(int i) {
        if (this.aSZ.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.aSZ.getLayoutParams()).topMargin = i;
        }
    }

    public void fS(int i) {
        if (i >= 0) {
            if (this.aTb != null) {
                int Cb = this.aTb.Cb();
                i = ((Cb <= 100 ? Cb : 100) * i) / 100;
            }
            ViewGroup.LayoutParams layoutParams = this.aSY.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(i, this.aTc);
            } else {
                layoutParams.width = i;
            }
            this.aSY.setLayoutParams(layoutParams);
        }
    }

    public int a(a aVar) {
        int intrinsicWidth;
        String string;
        this.aTb = aVar;
        if (aVar == null) {
            return 0;
        }
        if (aVar.Ca() <= 0) {
            this.aSX.setImageDrawable(null);
            this.aSX.setVisibility(8);
            intrinsicWidth = 0;
        } else {
            Drawable drawable = aj.getDrawable(aVar.Ca());
            this.aSX.setImageDrawable(drawable);
            intrinsicWidth = drawable.getIntrinsicWidth() + this.aSW.getResources().getDimensionPixelSize(d.f.ds24);
            this.aSX.setVisibility(0);
        }
        if (StringUtils.isNull(aVar.BX())) {
            this.avY.setText((CharSequence) null);
            this.avY.setVisibility(8);
        } else {
            this.avY.setText(UtilHelper.getFixedText(aVar.BX(), 15, false));
            this.avY.setVisibility(0);
        }
        if (aVar.isSelected()) {
            aj.k(this.aTa, d.e.common_color_10271);
        } else {
            aj.k(this.aTa, d.e.common_color_10272);
        }
        boolean isNull = StringUtils.isNull(aVar.BY());
        boolean isNull2 = StringUtils.isNull(aVar.BZ());
        if (isNull && isNull2) {
            this.aSZ.setText((CharSequence) null);
            this.aSZ.setVisibility(8);
            string = null;
        } else {
            this.aSZ.setVisibility(0);
            if (isNull) {
                string = aVar.BZ();
                this.aSZ.setText(string);
            } else if (isNull2) {
                string = aVar.BY();
                this.aSZ.setText(string);
            } else {
                string = TbadkCoreApplication.getInst().getString(d.l.vote_number_text, new Object[]{aVar.BY(), aVar.BZ()});
                this.aSZ.setText(string);
            }
        }
        if (!StringUtils.isNull(string)) {
            intrinsicWidth = (int) (intrinsicWidth + this.aSZ.getPaint().measureText(string));
        }
        return this.aSW.getResources().getDimensionPixelSize(d.f.ds24) + this.aSW.getResources().getDimensionPixelSize(d.f.ds10) + 8 + intrinsicWidth;
    }

    public void setProgress(float f) {
        if (f >= 0.0f && this.aTb != null) {
            int i = (int) (100.0f * f);
            if (this.aTb.isSelected()) {
                this.aSY.setProgress(i);
                this.aSY.setSecondaryProgress(0);
                return;
            }
            this.aSY.setProgress(0);
            this.aSY.setSecondaryProgress(i);
        }
    }

    public View getView() {
        return this.aSW;
    }

    public void onChangeSkinType(int i) {
        if (this.aTb != null && this.aTb.Ca() > 0) {
            aj.b(this.aSX, this.aTb.Ca(), i);
        }
        aj.c(this.avY, d.e.cp_cont_b, 1);
        aj.c(this.aSZ, this.aTd, 1);
        this.aSY.setProgressDrawable(aj.getDrawable(d.g.vote_progress_drawable));
        if (this.aTb != null) {
            if (this.aTb.isSelected()) {
                aj.k(this.aTa, d.e.common_color_10271);
            } else {
                aj.k(this.aTa, d.e.common_color_10272);
            }
        }
    }
}
