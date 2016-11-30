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
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class c {
    private View aKJ;
    private ImageView aKK;
    private ProgressBar aKL;
    private TextView aKM;
    private View aKN;
    private a aKO;
    private int aKP;
    private int aKQ;
    private TextView title;

    public c(Context context) {
        this(context, r.d.cp_cont_b);
    }

    public c(Context context, int i) {
        this.aKJ = LayoutInflater.from(context).inflate(r.h.ballot_item_view, (ViewGroup) null);
        this.aKK = (ImageView) this.aKJ.findViewById(r.g.ballot_item_image);
        this.title = (TextView) this.aKJ.findViewById(r.g.ballot_item_title);
        this.aKL = (ProgressBar) this.aKJ.findViewById(r.g.ballot_item_progress);
        this.aKM = (TextView) this.aKJ.findViewById(r.g.ballot_item_percents);
        this.aKN = this.aKJ.findViewById(r.g.ballot_item_preffix_progress);
        this.aKP = k.e(context, r.e.ds28);
        this.aKQ = i;
        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
    }

    public void setProgressBarHeight(int i) {
        this.aKP = i;
        this.aKL.getLayoutParams().height = this.aKP;
        this.aKN.getLayoutParams().height = this.aKP;
    }

    public void setProgressBarTopMargin(int i) {
        if (this.aKL.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.aKL.getLayoutParams()).topMargin = i;
        }
        if (this.aKN.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.aKN.getLayoutParams()).topMargin = i;
        }
    }

    public void setDescTopMargin(int i) {
        if (this.aKM.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.aKM.getLayoutParams()).topMargin = i;
        }
    }

    public void fD(int i) {
        if (i >= 0) {
            if (this.aKO != null) {
                int Cv = this.aKO.Cv();
                i = ((Cv <= 100 ? Cv : 100) * i) / 100;
            }
            ViewGroup.LayoutParams layoutParams = this.aKL.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(i, this.aKP);
            } else {
                layoutParams.width = i;
            }
            this.aKL.setLayoutParams(layoutParams);
        }
    }

    public int a(a aVar) {
        int intrinsicWidth;
        String string;
        this.aKO = aVar;
        if (aVar == null) {
            return 0;
        }
        if (aVar.Cu() <= 0) {
            this.aKK.setImageDrawable(null);
            this.aKK.setVisibility(8);
            intrinsicWidth = 0;
        } else {
            Drawable drawable = at.getDrawable(aVar.Cu());
            this.aKK.setImageDrawable(drawable);
            intrinsicWidth = drawable.getIntrinsicWidth() + this.aKJ.getResources().getDimensionPixelSize(r.e.ds24);
            this.aKK.setVisibility(0);
        }
        if (StringUtils.isNull(aVar.Cr())) {
            this.title.setText((CharSequence) null);
            this.title.setVisibility(8);
        } else {
            this.title.setText(UtilHelper.getFixedText(aVar.Cr(), 15, false));
            this.title.setVisibility(0);
        }
        if (aVar.isSelected()) {
            at.l(this.aKN, r.d.common_color_10271);
        } else {
            at.l(this.aKN, r.d.common_color_10272);
        }
        boolean isNull = StringUtils.isNull(aVar.Cs());
        boolean isNull2 = StringUtils.isNull(aVar.Ct());
        if (isNull && isNull2) {
            this.aKM.setText((CharSequence) null);
            this.aKM.setVisibility(8);
            string = null;
        } else {
            this.aKM.setVisibility(0);
            if (isNull) {
                string = aVar.Ct();
                this.aKM.setText(string);
            } else if (isNull2) {
                string = aVar.Cs();
                this.aKM.setText(string);
            } else {
                string = TbadkCoreApplication.m9getInst().getString(r.j.vote_number_text, new Object[]{aVar.Cs(), aVar.Ct()});
                this.aKM.setText(string);
            }
        }
        if (!StringUtils.isNull(string)) {
            intrinsicWidth = (int) (intrinsicWidth + this.aKM.getPaint().measureText(string));
        }
        return this.aKJ.getResources().getDimensionPixelSize(r.e.ds24) + this.aKJ.getResources().getDimensionPixelSize(r.e.ds10) + 8 + intrinsicWidth;
    }

    public void setProgress(float f) {
        if (f >= 0.0f && this.aKO != null) {
            int i = (int) (100.0f * f);
            if (this.aKO.isSelected()) {
                this.aKL.setProgress(i);
                this.aKL.setSecondaryProgress(0);
                return;
            }
            this.aKL.setProgress(0);
            this.aKL.setSecondaryProgress(i);
        }
    }

    public View getView() {
        return this.aKJ;
    }

    public void onChangeSkinType(int i) {
        if (this.aKO != null && this.aKO.Cu() > 0) {
            at.c(this.aKK, this.aKO.Cu(), i);
        }
        at.c(this.title, r.d.cp_cont_b, 1);
        at.c(this.aKM, this.aKQ, 1);
        this.aKL.setProgressDrawable(at.getDrawable(r.f.vote_progress_drawable));
        if (this.aKO != null) {
            if (this.aKO.isSelected()) {
                at.l(this.aKN, r.d.common_color_10271);
            } else {
                at.l(this.aKN, r.d.common_color_10272);
            }
        }
    }
}
