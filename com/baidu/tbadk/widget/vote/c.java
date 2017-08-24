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
import com.baidu.tbadk.core.util.ai;
import com.baidu.tieba.d;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes.dex */
public class c {
    private View aSD;
    private ImageView aSE;
    private ProgressBar aSF;
    private TextView aSG;
    private View aSH;
    private a aSI;
    private int aSJ;
    private int aSK;
    private TextView axS;

    public c(Context context) {
        this(context, d.e.cp_cont_b);
    }

    public c(Context context, int i) {
        this.aSD = LayoutInflater.from(context).inflate(d.j.ballot_item_view, (ViewGroup) null);
        this.aSE = (ImageView) this.aSD.findViewById(d.h.ballot_item_image);
        this.axS = (TextView) this.aSD.findViewById(d.h.ballot_item_title);
        this.aSF = (ProgressBar) this.aSD.findViewById(d.h.ballot_item_progress);
        this.aSG = (TextView) this.aSD.findViewById(d.h.ballot_item_percents);
        this.aSH = this.aSD.findViewById(d.h.ballot_item_preffix_progress);
        this.aSJ = k.g(context, d.f.ds28);
        this.aSK = i;
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setProgressBarHeight(int i) {
        this.aSJ = i;
        this.aSF.getLayoutParams().height = this.aSJ;
        this.aSH.getLayoutParams().height = this.aSJ;
    }

    public void setProgressBarTopMargin(int i) {
        if (this.aSF.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.aSF.getLayoutParams()).topMargin = i;
        }
        if (this.aSH.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.aSH.getLayoutParams()).topMargin = i;
        }
    }

    public void setDescTopMargin(int i) {
        if (this.aSG.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.aSG.getLayoutParams()).topMargin = i;
        }
    }

    public void fF(int i) {
        if (i >= 0) {
            if (this.aSI != null) {
                int CI = this.aSI.CI();
                i = ((CI <= 100 ? CI : 100) * i) / 100;
            }
            ViewGroup.LayoutParams layoutParams = this.aSF.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(i, this.aSJ);
            } else {
                layoutParams.width = i;
            }
            this.aSF.setLayoutParams(layoutParams);
        }
    }

    public int a(a aVar) {
        int intrinsicWidth;
        String string;
        this.aSI = aVar;
        if (aVar == null) {
            return 0;
        }
        if (aVar.CH() <= 0) {
            this.aSE.setImageDrawable(null);
            this.aSE.setVisibility(8);
            intrinsicWidth = 0;
        } else {
            Drawable drawable = ai.getDrawable(aVar.CH());
            this.aSE.setImageDrawable(drawable);
            intrinsicWidth = drawable.getIntrinsicWidth() + this.aSD.getResources().getDimensionPixelSize(d.f.ds24);
            this.aSE.setVisibility(0);
        }
        if (StringUtils.isNull(aVar.CE())) {
            this.axS.setText((CharSequence) null);
            this.axS.setVisibility(8);
        } else {
            this.axS.setText(UtilHelper.getFixedText(aVar.CE(), 15, false));
            this.axS.setVisibility(0);
        }
        if (aVar.isSelected()) {
            ai.k(this.aSH, d.e.common_color_10271);
        } else {
            ai.k(this.aSH, d.e.common_color_10272);
        }
        boolean isNull = StringUtils.isNull(aVar.CF());
        boolean isNull2 = StringUtils.isNull(aVar.CG());
        if (isNull && isNull2) {
            this.aSG.setText((CharSequence) null);
            this.aSG.setVisibility(8);
            string = null;
        } else {
            this.aSG.setVisibility(0);
            if (isNull) {
                string = aVar.CG();
                this.aSG.setText(string);
            } else if (isNull2) {
                string = aVar.CF();
                this.aSG.setText(string);
            } else {
                string = TbadkCoreApplication.getInst().getString(d.l.vote_number_text, new Object[]{aVar.CF(), aVar.CG()});
                this.aSG.setText(string);
            }
        }
        if (!StringUtils.isNull(string)) {
            intrinsicWidth = (int) (intrinsicWidth + this.aSG.getPaint().measureText(string));
        }
        return this.aSD.getResources().getDimensionPixelSize(d.f.ds24) + this.aSD.getResources().getDimensionPixelSize(d.f.ds10) + 8 + intrinsicWidth;
    }

    public void setProgress(float f) {
        if (f >= 0.0f && this.aSI != null) {
            int i = (int) (100.0f * f);
            if (this.aSI.isSelected()) {
                this.aSF.setProgress(i);
                this.aSF.setSecondaryProgress(0);
                return;
            }
            this.aSF.setProgress(0);
            this.aSF.setSecondaryProgress(i);
        }
    }

    public View getView() {
        return this.aSD;
    }

    public void onChangeSkinType(int i) {
        if (this.aSI != null && this.aSI.CH() > 0) {
            ai.c(this.aSE, this.aSI.CH(), i);
        }
        ai.c(this.axS, d.e.cp_cont_b, 1);
        ai.c(this.aSG, this.aSK, 1);
        this.aSF.setProgressDrawable(ai.getDrawable(d.g.vote_progress_drawable));
        if (this.aSI != null) {
            if (this.aSI.isSelected()) {
                ai.k(this.aSH, d.e.common_color_10271);
            } else {
                ai.k(this.aSH, d.e.common_color_10272);
            }
        }
    }
}
