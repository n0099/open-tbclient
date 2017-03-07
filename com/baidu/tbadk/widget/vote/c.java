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
    private View aOe;
    private ImageView aOf;
    private ProgressBar aOg;
    private TextView aOh;
    private View aOi;
    private a aOj;
    private int aOk;
    private int aOl;
    private TextView auy;

    public c(Context context) {
        this(context, w.e.cp_cont_b);
    }

    public c(Context context, int i) {
        this.aOe = LayoutInflater.from(context).inflate(w.j.ballot_item_view, (ViewGroup) null);
        this.aOf = (ImageView) this.aOe.findViewById(w.h.ballot_item_image);
        this.auy = (TextView) this.aOe.findViewById(w.h.ballot_item_title);
        this.aOg = (ProgressBar) this.aOe.findViewById(w.h.ballot_item_progress);
        this.aOh = (TextView) this.aOe.findViewById(w.h.ballot_item_percents);
        this.aOi = this.aOe.findViewById(w.h.ballot_item_preffix_progress);
        this.aOk = k.g(context, w.f.ds28);
        this.aOl = i;
        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
    }

    public void setProgressBarHeight(int i) {
        this.aOk = i;
        this.aOg.getLayoutParams().height = this.aOk;
        this.aOi.getLayoutParams().height = this.aOk;
    }

    public void setProgressBarTopMargin(int i) {
        if (this.aOg.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.aOg.getLayoutParams()).topMargin = i;
        }
        if (this.aOi.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.aOi.getLayoutParams()).topMargin = i;
        }
    }

    public void setDescTopMargin(int i) {
        if (this.aOh.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.aOh.getLayoutParams()).topMargin = i;
        }
    }

    public void fx(int i) {
        if (i >= 0) {
            if (this.aOj != null) {
                int Cx = this.aOj.Cx();
                i = ((Cx <= 100 ? Cx : 100) * i) / 100;
            }
            ViewGroup.LayoutParams layoutParams = this.aOg.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(i, this.aOk);
            } else {
                layoutParams.width = i;
            }
            this.aOg.setLayoutParams(layoutParams);
        }
    }

    public int a(a aVar) {
        int intrinsicWidth;
        String string;
        this.aOj = aVar;
        if (aVar == null) {
            return 0;
        }
        if (aVar.Cw() <= 0) {
            this.aOf.setImageDrawable(null);
            this.aOf.setVisibility(8);
            intrinsicWidth = 0;
        } else {
            Drawable drawable = aq.getDrawable(aVar.Cw());
            this.aOf.setImageDrawable(drawable);
            intrinsicWidth = drawable.getIntrinsicWidth() + this.aOe.getResources().getDimensionPixelSize(w.f.ds24);
            this.aOf.setVisibility(0);
        }
        if (StringUtils.isNull(aVar.Ct())) {
            this.auy.setText((CharSequence) null);
            this.auy.setVisibility(8);
        } else {
            this.auy.setText(UtilHelper.getFixedText(aVar.Ct(), 15, false));
            this.auy.setVisibility(0);
        }
        if (aVar.isSelected()) {
            aq.k(this.aOi, w.e.common_color_10271);
        } else {
            aq.k(this.aOi, w.e.common_color_10272);
        }
        boolean isNull = StringUtils.isNull(aVar.Cu());
        boolean isNull2 = StringUtils.isNull(aVar.Cv());
        if (isNull && isNull2) {
            this.aOh.setText((CharSequence) null);
            this.aOh.setVisibility(8);
            string = null;
        } else {
            this.aOh.setVisibility(0);
            if (isNull) {
                string = aVar.Cv();
                this.aOh.setText(string);
            } else if (isNull2) {
                string = aVar.Cu();
                this.aOh.setText(string);
            } else {
                string = TbadkCoreApplication.m9getInst().getString(w.l.vote_number_text, new Object[]{aVar.Cu(), aVar.Cv()});
                this.aOh.setText(string);
            }
        }
        if (!StringUtils.isNull(string)) {
            intrinsicWidth = (int) (intrinsicWidth + this.aOh.getPaint().measureText(string));
        }
        return this.aOe.getResources().getDimensionPixelSize(w.f.ds24) + this.aOe.getResources().getDimensionPixelSize(w.f.ds10) + 8 + intrinsicWidth;
    }

    public void setProgress(float f) {
        if (f >= 0.0f && this.aOj != null) {
            int i = (int) (100.0f * f);
            if (this.aOj.isSelected()) {
                this.aOg.setProgress(i);
                this.aOg.setSecondaryProgress(0);
                return;
            }
            this.aOg.setProgress(0);
            this.aOg.setSecondaryProgress(i);
        }
    }

    public View getView() {
        return this.aOe;
    }

    public void onChangeSkinType(int i) {
        if (this.aOj != null && this.aOj.Cw() > 0) {
            aq.c(this.aOf, this.aOj.Cw(), i);
        }
        aq.c(this.auy, w.e.cp_cont_b, 1);
        aq.c(this.aOh, this.aOl, 1);
        this.aOg.setProgressDrawable(aq.getDrawable(w.g.vote_progress_drawable));
        if (this.aOj != null) {
            if (this.aOj.isSelected()) {
                aq.k(this.aOi, w.e.common_color_10271);
            } else {
                aq.k(this.aOi, w.e.common_color_10272);
            }
        }
    }
}
