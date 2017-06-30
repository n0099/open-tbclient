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
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class c {
    private View aQg;
    private ImageView aQh;
    private ProgressBar aQi;
    private TextView aQj;
    private View aQk;
    private a aQl;
    private int aQm;
    private int aQn;
    private TextView avH;

    public c(Context context) {
        this(context, w.e.cp_cont_b);
    }

    public c(Context context, int i) {
        this.aQg = LayoutInflater.from(context).inflate(w.j.ballot_item_view, (ViewGroup) null);
        this.aQh = (ImageView) this.aQg.findViewById(w.h.ballot_item_image);
        this.avH = (TextView) this.aQg.findViewById(w.h.ballot_item_title);
        this.aQi = (ProgressBar) this.aQg.findViewById(w.h.ballot_item_progress);
        this.aQj = (TextView) this.aQg.findViewById(w.h.ballot_item_percents);
        this.aQk = this.aQg.findViewById(w.h.ballot_item_preffix_progress);
        this.aQm = k.g(context, w.f.ds28);
        this.aQn = i;
        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
    }

    public void setProgressBarHeight(int i) {
        this.aQm = i;
        this.aQi.getLayoutParams().height = this.aQm;
        this.aQk.getLayoutParams().height = this.aQm;
    }

    public void setProgressBarTopMargin(int i) {
        if (this.aQi.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.aQi.getLayoutParams()).topMargin = i;
        }
        if (this.aQk.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.aQk.getLayoutParams()).topMargin = i;
        }
    }

    public void setDescTopMargin(int i) {
        if (this.aQj.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.aQj.getLayoutParams()).topMargin = i;
        }
    }

    public void fA(int i) {
        if (i >= 0) {
            if (this.aQl != null) {
                int Co = this.aQl.Co();
                i = ((Co <= 100 ? Co : 100) * i) / 100;
            }
            ViewGroup.LayoutParams layoutParams = this.aQi.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(i, this.aQm);
            } else {
                layoutParams.width = i;
            }
            this.aQi.setLayoutParams(layoutParams);
        }
    }

    public int a(a aVar) {
        int intrinsicWidth;
        String string;
        this.aQl = aVar;
        if (aVar == null) {
            return 0;
        }
        if (aVar.Cn() <= 0) {
            this.aQh.setImageDrawable(null);
            this.aQh.setVisibility(8);
            intrinsicWidth = 0;
        } else {
            Drawable drawable = as.getDrawable(aVar.Cn());
            this.aQh.setImageDrawable(drawable);
            intrinsicWidth = drawable.getIntrinsicWidth() + this.aQg.getResources().getDimensionPixelSize(w.f.ds24);
            this.aQh.setVisibility(0);
        }
        if (StringUtils.isNull(aVar.Ck())) {
            this.avH.setText((CharSequence) null);
            this.avH.setVisibility(8);
        } else {
            this.avH.setText(UtilHelper.getFixedText(aVar.Ck(), 15, false));
            this.avH.setVisibility(0);
        }
        if (aVar.isSelected()) {
            as.k(this.aQk, w.e.common_color_10271);
        } else {
            as.k(this.aQk, w.e.common_color_10272);
        }
        boolean isNull = StringUtils.isNull(aVar.Cl());
        boolean isNull2 = StringUtils.isNull(aVar.Cm());
        if (isNull && isNull2) {
            this.aQj.setText((CharSequence) null);
            this.aQj.setVisibility(8);
            string = null;
        } else {
            this.aQj.setVisibility(0);
            if (isNull) {
                string = aVar.Cm();
                this.aQj.setText(string);
            } else if (isNull2) {
                string = aVar.Cl();
                this.aQj.setText(string);
            } else {
                string = TbadkCoreApplication.m9getInst().getString(w.l.vote_number_text, new Object[]{aVar.Cl(), aVar.Cm()});
                this.aQj.setText(string);
            }
        }
        if (!StringUtils.isNull(string)) {
            intrinsicWidth = (int) (intrinsicWidth + this.aQj.getPaint().measureText(string));
        }
        return this.aQg.getResources().getDimensionPixelSize(w.f.ds24) + this.aQg.getResources().getDimensionPixelSize(w.f.ds10) + 8 + intrinsicWidth;
    }

    public void setProgress(float f) {
        if (f >= 0.0f && this.aQl != null) {
            int i = (int) (100.0f * f);
            if (this.aQl.isSelected()) {
                this.aQi.setProgress(i);
                this.aQi.setSecondaryProgress(0);
                return;
            }
            this.aQi.setProgress(0);
            this.aQi.setSecondaryProgress(i);
        }
    }

    public View getView() {
        return this.aQg;
    }

    public void onChangeSkinType(int i) {
        if (this.aQl != null && this.aQl.Cn() > 0) {
            as.c(this.aQh, this.aQl.Cn(), i);
        }
        as.c(this.avH, w.e.cp_cont_b, 1);
        as.c(this.aQj, this.aQn, 1);
        this.aQi.setProgressDrawable(as.getDrawable(w.g.vote_progress_drawable));
        if (this.aQl != null) {
            if (this.aQl.isSelected()) {
                as.k(this.aQk, w.e.common_color_10271);
            } else {
                as.k(this.aQk, w.e.common_color_10272);
            }
        }
    }
}
