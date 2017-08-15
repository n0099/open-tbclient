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
    private View aSC;
    private ImageView aSD;
    private ProgressBar aSE;
    private TextView aSF;
    private View aSG;
    private a aSH;
    private int aSI;
    private int aSJ;
    private TextView axR;

    public c(Context context) {
        this(context, d.e.cp_cont_b);
    }

    public c(Context context, int i) {
        this.aSC = LayoutInflater.from(context).inflate(d.j.ballot_item_view, (ViewGroup) null);
        this.aSD = (ImageView) this.aSC.findViewById(d.h.ballot_item_image);
        this.axR = (TextView) this.aSC.findViewById(d.h.ballot_item_title);
        this.aSE = (ProgressBar) this.aSC.findViewById(d.h.ballot_item_progress);
        this.aSF = (TextView) this.aSC.findViewById(d.h.ballot_item_percents);
        this.aSG = this.aSC.findViewById(d.h.ballot_item_preffix_progress);
        this.aSI = k.g(context, d.f.ds28);
        this.aSJ = i;
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setProgressBarHeight(int i) {
        this.aSI = i;
        this.aSE.getLayoutParams().height = this.aSI;
        this.aSG.getLayoutParams().height = this.aSI;
    }

    public void setProgressBarTopMargin(int i) {
        if (this.aSE.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.aSE.getLayoutParams()).topMargin = i;
        }
        if (this.aSG.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.aSG.getLayoutParams()).topMargin = i;
        }
    }

    public void setDescTopMargin(int i) {
        if (this.aSF.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.aSF.getLayoutParams()).topMargin = i;
        }
    }

    public void fF(int i) {
        if (i >= 0) {
            if (this.aSH != null) {
                int CI = this.aSH.CI();
                i = ((CI <= 100 ? CI : 100) * i) / 100;
            }
            ViewGroup.LayoutParams layoutParams = this.aSE.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(i, this.aSI);
            } else {
                layoutParams.width = i;
            }
            this.aSE.setLayoutParams(layoutParams);
        }
    }

    public int a(a aVar) {
        int intrinsicWidth;
        String string;
        this.aSH = aVar;
        if (aVar == null) {
            return 0;
        }
        if (aVar.CH() <= 0) {
            this.aSD.setImageDrawable(null);
            this.aSD.setVisibility(8);
            intrinsicWidth = 0;
        } else {
            Drawable drawable = ai.getDrawable(aVar.CH());
            this.aSD.setImageDrawable(drawable);
            intrinsicWidth = drawable.getIntrinsicWidth() + this.aSC.getResources().getDimensionPixelSize(d.f.ds24);
            this.aSD.setVisibility(0);
        }
        if (StringUtils.isNull(aVar.CE())) {
            this.axR.setText((CharSequence) null);
            this.axR.setVisibility(8);
        } else {
            this.axR.setText(UtilHelper.getFixedText(aVar.CE(), 15, false));
            this.axR.setVisibility(0);
        }
        if (aVar.isSelected()) {
            ai.k(this.aSG, d.e.common_color_10271);
        } else {
            ai.k(this.aSG, d.e.common_color_10272);
        }
        boolean isNull = StringUtils.isNull(aVar.CF());
        boolean isNull2 = StringUtils.isNull(aVar.CG());
        if (isNull && isNull2) {
            this.aSF.setText((CharSequence) null);
            this.aSF.setVisibility(8);
            string = null;
        } else {
            this.aSF.setVisibility(0);
            if (isNull) {
                string = aVar.CG();
                this.aSF.setText(string);
            } else if (isNull2) {
                string = aVar.CF();
                this.aSF.setText(string);
            } else {
                string = TbadkCoreApplication.getInst().getString(d.l.vote_number_text, new Object[]{aVar.CF(), aVar.CG()});
                this.aSF.setText(string);
            }
        }
        if (!StringUtils.isNull(string)) {
            intrinsicWidth = (int) (intrinsicWidth + this.aSF.getPaint().measureText(string));
        }
        return this.aSC.getResources().getDimensionPixelSize(d.f.ds24) + this.aSC.getResources().getDimensionPixelSize(d.f.ds10) + 8 + intrinsicWidth;
    }

    public void setProgress(float f) {
        if (f >= 0.0f && this.aSH != null) {
            int i = (int) (100.0f * f);
            if (this.aSH.isSelected()) {
                this.aSE.setProgress(i);
                this.aSE.setSecondaryProgress(0);
                return;
            }
            this.aSE.setProgress(0);
            this.aSE.setSecondaryProgress(i);
        }
    }

    public View getView() {
        return this.aSC;
    }

    public void onChangeSkinType(int i) {
        if (this.aSH != null && this.aSH.CH() > 0) {
            ai.c(this.aSD, this.aSH.CH(), i);
        }
        ai.c(this.axR, d.e.cp_cont_b, 1);
        ai.c(this.aSF, this.aSJ, 1);
        this.aSE.setProgressDrawable(ai.getDrawable(d.g.vote_progress_drawable));
        if (this.aSH != null) {
            if (this.aSH.isSelected()) {
                ai.k(this.aSG, d.e.common_color_10271);
            } else {
                ai.k(this.aSG, d.e.common_color_10272);
            }
        }
    }
}
