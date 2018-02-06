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
    private ImageView bMA;
    private TextView bMB;
    private View bMC;
    private a bMD;
    private int bME;
    private int bMF;
    private View bMz;
    private ProgressBar progressBar;
    private TextView title;

    public c(Context context) {
        this(context, d.C0140d.cp_cont_b);
    }

    public c(Context context, int i) {
        this.bMz = LayoutInflater.from(context).inflate(d.h.ballot_item_view, (ViewGroup) null);
        this.bMA = (ImageView) this.bMz.findViewById(d.g.ballot_item_image);
        this.title = (TextView) this.bMz.findViewById(d.g.ballot_item_title);
        this.progressBar = (ProgressBar) this.bMz.findViewById(d.g.ballot_item_progress);
        this.bMB = (TextView) this.bMz.findViewById(d.g.ballot_item_percents);
        this.bMC = this.bMz.findViewById(d.g.ballot_item_preffix_progress);
        this.bME = l.t(context, d.e.ds28);
        this.bMF = i;
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setProgressBarHeight(int i) {
        this.bME = i;
        this.progressBar.getLayoutParams().height = this.bME;
        this.bMC.getLayoutParams().height = this.bME;
    }

    public void setProgressBarTopMargin(int i) {
        if (this.progressBar.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.progressBar.getLayoutParams()).topMargin = i;
        }
        if (this.bMC.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.bMC.getLayoutParams()).topMargin = i;
        }
    }

    public void setDescTopMargin(int i) {
        if (this.bMB.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.bMB.getLayoutParams()).topMargin = i;
        }
    }

    public void iZ(int i) {
        if (i >= 0) {
            if (this.bMD != null) {
                int KK = this.bMD.KK();
                i = ((KK <= 100 ? KK : 100) * i) / 100;
            }
            ViewGroup.LayoutParams layoutParams = this.progressBar.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(i, this.bME);
            } else {
                layoutParams.width = i;
            }
            this.progressBar.setLayoutParams(layoutParams);
        }
    }

    public int a(a aVar) {
        int intrinsicWidth;
        String string;
        this.bMD = aVar;
        if (aVar == null) {
            return 0;
        }
        if (aVar.KJ() <= 0) {
            this.bMA.setImageDrawable(null);
            this.bMA.setVisibility(8);
            intrinsicWidth = 0;
        } else {
            Drawable drawable = aj.getDrawable(aVar.KJ());
            this.bMA.setImageDrawable(drawable);
            intrinsicWidth = drawable.getIntrinsicWidth() + this.bMz.getResources().getDimensionPixelSize(d.e.ds24);
            this.bMA.setVisibility(0);
        }
        if (StringUtils.isNull(aVar.KG())) {
            this.title.setText((CharSequence) null);
            this.title.setVisibility(8);
        } else {
            this.title.setText(UtilHelper.getFixedText(aVar.KG(), 15, false));
            this.title.setVisibility(0);
        }
        if (aVar.isSelected()) {
            aj.t(this.bMC, d.C0140d.common_color_10271);
        } else {
            aj.t(this.bMC, d.C0140d.common_color_10272);
        }
        boolean isNull = StringUtils.isNull(aVar.KH());
        boolean isNull2 = StringUtils.isNull(aVar.KI());
        if (isNull && isNull2) {
            this.bMB.setText((CharSequence) null);
            this.bMB.setVisibility(8);
            string = null;
        } else {
            this.bMB.setVisibility(0);
            if (isNull) {
                string = aVar.KI();
                this.bMB.setText(string);
            } else if (isNull2) {
                string = aVar.KH();
                this.bMB.setText(string);
            } else {
                string = TbadkCoreApplication.getInst().getString(d.j.vote_number_text, new Object[]{aVar.KH(), aVar.KI()});
                this.bMB.setText(string);
            }
        }
        if (!StringUtils.isNull(string)) {
            intrinsicWidth = (int) (intrinsicWidth + this.bMB.getPaint().measureText(string));
        }
        return this.bMz.getResources().getDimensionPixelSize(d.e.ds24) + this.bMz.getResources().getDimensionPixelSize(d.e.ds10) + 8 + intrinsicWidth;
    }

    public void setProgress(float f) {
        if (f >= 0.0f && this.bMD != null) {
            int i = (int) (100.0f * f);
            if (this.bMD.isSelected()) {
                this.progressBar.setProgress(i);
                this.progressBar.setSecondaryProgress(0);
                return;
            }
            this.progressBar.setProgress(0);
            this.progressBar.setSecondaryProgress(i);
        }
    }

    public View getView() {
        return this.bMz;
    }

    public void onChangeSkinType(int i) {
        if (this.bMD != null && this.bMD.KJ() > 0) {
            aj.b(this.bMA, this.bMD.KJ(), i);
        }
        aj.e(this.title, d.C0140d.cp_cont_b, 1);
        aj.e(this.bMB, this.bMF, 1);
        this.progressBar.setProgressDrawable(aj.getDrawable(d.f.vote_progress_drawable));
        if (this.bMD != null) {
            if (this.bMD.isSelected()) {
                aj.t(this.bMC, d.C0140d.common_color_10271);
            } else {
                aj.t(this.bMC, d.C0140d.common_color_10272);
            }
        }
    }
}
