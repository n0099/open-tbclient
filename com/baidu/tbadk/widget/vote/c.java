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
    private View aSB;
    private ImageView aSC;
    private ProgressBar aSD;
    private TextView aSE;
    private View aSF;
    private a aSG;
    private int aSH;
    private int aSI;
    private TextView axQ;

    public c(Context context) {
        this(context, d.e.cp_cont_b);
    }

    public c(Context context, int i) {
        this.aSB = LayoutInflater.from(context).inflate(d.j.ballot_item_view, (ViewGroup) null);
        this.aSC = (ImageView) this.aSB.findViewById(d.h.ballot_item_image);
        this.axQ = (TextView) this.aSB.findViewById(d.h.ballot_item_title);
        this.aSD = (ProgressBar) this.aSB.findViewById(d.h.ballot_item_progress);
        this.aSE = (TextView) this.aSB.findViewById(d.h.ballot_item_percents);
        this.aSF = this.aSB.findViewById(d.h.ballot_item_preffix_progress);
        this.aSH = k.g(context, d.f.ds28);
        this.aSI = i;
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setProgressBarHeight(int i) {
        this.aSH = i;
        this.aSD.getLayoutParams().height = this.aSH;
        this.aSF.getLayoutParams().height = this.aSH;
    }

    public void setProgressBarTopMargin(int i) {
        if (this.aSD.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.aSD.getLayoutParams()).topMargin = i;
        }
        if (this.aSF.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.aSF.getLayoutParams()).topMargin = i;
        }
    }

    public void setDescTopMargin(int i) {
        if (this.aSE.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.aSE.getLayoutParams()).topMargin = i;
        }
    }

    public void fF(int i) {
        if (i >= 0) {
            if (this.aSG != null) {
                int CI = this.aSG.CI();
                i = ((CI <= 100 ? CI : 100) * i) / 100;
            }
            ViewGroup.LayoutParams layoutParams = this.aSD.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(i, this.aSH);
            } else {
                layoutParams.width = i;
            }
            this.aSD.setLayoutParams(layoutParams);
        }
    }

    public int a(a aVar) {
        int intrinsicWidth;
        String string;
        this.aSG = aVar;
        if (aVar == null) {
            return 0;
        }
        if (aVar.CH() <= 0) {
            this.aSC.setImageDrawable(null);
            this.aSC.setVisibility(8);
            intrinsicWidth = 0;
        } else {
            Drawable drawable = ai.getDrawable(aVar.CH());
            this.aSC.setImageDrawable(drawable);
            intrinsicWidth = drawable.getIntrinsicWidth() + this.aSB.getResources().getDimensionPixelSize(d.f.ds24);
            this.aSC.setVisibility(0);
        }
        if (StringUtils.isNull(aVar.CE())) {
            this.axQ.setText((CharSequence) null);
            this.axQ.setVisibility(8);
        } else {
            this.axQ.setText(UtilHelper.getFixedText(aVar.CE(), 15, false));
            this.axQ.setVisibility(0);
        }
        if (aVar.isSelected()) {
            ai.k(this.aSF, d.e.common_color_10271);
        } else {
            ai.k(this.aSF, d.e.common_color_10272);
        }
        boolean isNull = StringUtils.isNull(aVar.CF());
        boolean isNull2 = StringUtils.isNull(aVar.CG());
        if (isNull && isNull2) {
            this.aSE.setText((CharSequence) null);
            this.aSE.setVisibility(8);
            string = null;
        } else {
            this.aSE.setVisibility(0);
            if (isNull) {
                string = aVar.CG();
                this.aSE.setText(string);
            } else if (isNull2) {
                string = aVar.CF();
                this.aSE.setText(string);
            } else {
                string = TbadkCoreApplication.getInst().getString(d.l.vote_number_text, new Object[]{aVar.CF(), aVar.CG()});
                this.aSE.setText(string);
            }
        }
        if (!StringUtils.isNull(string)) {
            intrinsicWidth = (int) (intrinsicWidth + this.aSE.getPaint().measureText(string));
        }
        return this.aSB.getResources().getDimensionPixelSize(d.f.ds24) + this.aSB.getResources().getDimensionPixelSize(d.f.ds10) + 8 + intrinsicWidth;
    }

    public void setProgress(float f) {
        if (f >= 0.0f && this.aSG != null) {
            int i = (int) (100.0f * f);
            if (this.aSG.isSelected()) {
                this.aSD.setProgress(i);
                this.aSD.setSecondaryProgress(0);
                return;
            }
            this.aSD.setProgress(0);
            this.aSD.setSecondaryProgress(i);
        }
    }

    public View getView() {
        return this.aSB;
    }

    public void onChangeSkinType(int i) {
        if (this.aSG != null && this.aSG.CH() > 0) {
            ai.c(this.aSC, this.aSG.CH(), i);
        }
        ai.c(this.axQ, d.e.cp_cont_b, 1);
        ai.c(this.aSE, this.aSI, 1);
        this.aSD.setProgressDrawable(ai.getDrawable(d.g.vote_progress_drawable));
        if (this.aSG != null) {
            if (this.aSG.isSelected()) {
                ai.k(this.aSF, d.e.common_color_10271);
            } else {
                ai.k(this.aSF, d.e.common_color_10272);
            }
        }
    }
}
