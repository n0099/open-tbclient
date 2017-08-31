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
    private View aSn;
    private ImageView aSo;
    private ProgressBar aSp;
    private TextView aSq;
    private View aSr;
    private a aSs;
    private int aSt;
    private int aSu;
    private TextView axd;

    public c(Context context) {
        this(context, d.e.cp_cont_b);
    }

    public c(Context context, int i) {
        this.aSn = LayoutInflater.from(context).inflate(d.j.ballot_item_view, (ViewGroup) null);
        this.aSo = (ImageView) this.aSn.findViewById(d.h.ballot_item_image);
        this.axd = (TextView) this.aSn.findViewById(d.h.ballot_item_title);
        this.aSp = (ProgressBar) this.aSn.findViewById(d.h.ballot_item_progress);
        this.aSq = (TextView) this.aSn.findViewById(d.h.ballot_item_percents);
        this.aSr = this.aSn.findViewById(d.h.ballot_item_preffix_progress);
        this.aSt = k.g(context, d.f.ds28);
        this.aSu = i;
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setProgressBarHeight(int i) {
        this.aSt = i;
        this.aSp.getLayoutParams().height = this.aSt;
        this.aSr.getLayoutParams().height = this.aSt;
    }

    public void setProgressBarTopMargin(int i) {
        if (this.aSp.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.aSp.getLayoutParams()).topMargin = i;
        }
        if (this.aSr.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.aSr.getLayoutParams()).topMargin = i;
        }
    }

    public void setDescTopMargin(int i) {
        if (this.aSq.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.aSq.getLayoutParams()).topMargin = i;
        }
    }

    public void fG(int i) {
        if (i >= 0) {
            if (this.aSs != null) {
                int CD = this.aSs.CD();
                i = ((CD <= 100 ? CD : 100) * i) / 100;
            }
            ViewGroup.LayoutParams layoutParams = this.aSp.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(i, this.aSt);
            } else {
                layoutParams.width = i;
            }
            this.aSp.setLayoutParams(layoutParams);
        }
    }

    public int a(a aVar) {
        int intrinsicWidth;
        String string;
        this.aSs = aVar;
        if (aVar == null) {
            return 0;
        }
        if (aVar.CC() <= 0) {
            this.aSo.setImageDrawable(null);
            this.aSo.setVisibility(8);
            intrinsicWidth = 0;
        } else {
            Drawable drawable = aj.getDrawable(aVar.CC());
            this.aSo.setImageDrawable(drawable);
            intrinsicWidth = drawable.getIntrinsicWidth() + this.aSn.getResources().getDimensionPixelSize(d.f.ds24);
            this.aSo.setVisibility(0);
        }
        if (StringUtils.isNull(aVar.Cz())) {
            this.axd.setText((CharSequence) null);
            this.axd.setVisibility(8);
        } else {
            this.axd.setText(UtilHelper.getFixedText(aVar.Cz(), 15, false));
            this.axd.setVisibility(0);
        }
        if (aVar.isSelected()) {
            aj.k(this.aSr, d.e.common_color_10271);
        } else {
            aj.k(this.aSr, d.e.common_color_10272);
        }
        boolean isNull = StringUtils.isNull(aVar.CA());
        boolean isNull2 = StringUtils.isNull(aVar.CB());
        if (isNull && isNull2) {
            this.aSq.setText((CharSequence) null);
            this.aSq.setVisibility(8);
            string = null;
        } else {
            this.aSq.setVisibility(0);
            if (isNull) {
                string = aVar.CB();
                this.aSq.setText(string);
            } else if (isNull2) {
                string = aVar.CA();
                this.aSq.setText(string);
            } else {
                string = TbadkCoreApplication.getInst().getString(d.l.vote_number_text, new Object[]{aVar.CA(), aVar.CB()});
                this.aSq.setText(string);
            }
        }
        if (!StringUtils.isNull(string)) {
            intrinsicWidth = (int) (intrinsicWidth + this.aSq.getPaint().measureText(string));
        }
        return this.aSn.getResources().getDimensionPixelSize(d.f.ds24) + this.aSn.getResources().getDimensionPixelSize(d.f.ds10) + 8 + intrinsicWidth;
    }

    public void setProgress(float f) {
        if (f >= 0.0f && this.aSs != null) {
            int i = (int) (100.0f * f);
            if (this.aSs.isSelected()) {
                this.aSp.setProgress(i);
                this.aSp.setSecondaryProgress(0);
                return;
            }
            this.aSp.setProgress(0);
            this.aSp.setSecondaryProgress(i);
        }
    }

    public View getView() {
        return this.aSn;
    }

    public void onChangeSkinType(int i) {
        if (this.aSs != null && this.aSs.CC() > 0) {
            aj.b(this.aSo, this.aSs.CC(), i);
        }
        aj.c(this.axd, d.e.cp_cont_b, 1);
        aj.c(this.aSq, this.aSu, 1);
        this.aSp.setProgressDrawable(aj.getDrawable(d.g.vote_progress_drawable));
        if (this.aSs != null) {
            if (this.aSs.isSelected()) {
                aj.k(this.aSr, d.e.common_color_10271);
            } else {
                aj.k(this.aSr, d.e.common_color_10272);
            }
        }
    }
}
