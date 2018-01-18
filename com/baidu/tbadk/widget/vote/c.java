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
    private View bKm;
    private ImageView bKn;
    private ProgressBar bKo;
    private TextView bKp;
    private View bKq;
    private a bKr;
    private int bKs;
    private int bKt;
    private TextView blA;

    public c(Context context) {
        this(context, d.C0107d.cp_cont_b);
    }

    public c(Context context, int i) {
        this.bKm = LayoutInflater.from(context).inflate(d.h.ballot_item_view, (ViewGroup) null);
        this.bKn = (ImageView) this.bKm.findViewById(d.g.ballot_item_image);
        this.blA = (TextView) this.bKm.findViewById(d.g.ballot_item_title);
        this.bKo = (ProgressBar) this.bKm.findViewById(d.g.ballot_item_progress);
        this.bKp = (TextView) this.bKm.findViewById(d.g.ballot_item_percents);
        this.bKq = this.bKm.findViewById(d.g.ballot_item_preffix_progress);
        this.bKs = l.s(context, d.e.ds28);
        this.bKt = i;
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setProgressBarHeight(int i) {
        this.bKs = i;
        this.bKo.getLayoutParams().height = this.bKs;
        this.bKq.getLayoutParams().height = this.bKs;
    }

    public void setProgressBarTopMargin(int i) {
        if (this.bKo.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.bKo.getLayoutParams()).topMargin = i;
        }
        if (this.bKq.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.bKq.getLayoutParams()).topMargin = i;
        }
    }

    public void setDescTopMargin(int i) {
        if (this.bKp.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.bKp.getLayoutParams()).topMargin = i;
        }
    }

    public void jd(int i) {
        if (i >= 0) {
            if (this.bKr != null) {
                int Kc = this.bKr.Kc();
                i = ((Kc <= 100 ? Kc : 100) * i) / 100;
            }
            ViewGroup.LayoutParams layoutParams = this.bKo.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(i, this.bKs);
            } else {
                layoutParams.width = i;
            }
            this.bKo.setLayoutParams(layoutParams);
        }
    }

    public int a(a aVar) {
        int intrinsicWidth;
        String string;
        this.bKr = aVar;
        if (aVar == null) {
            return 0;
        }
        if (aVar.Kb() <= 0) {
            this.bKn.setImageDrawable(null);
            this.bKn.setVisibility(8);
            intrinsicWidth = 0;
        } else {
            Drawable drawable = aj.getDrawable(aVar.Kb());
            this.bKn.setImageDrawable(drawable);
            intrinsicWidth = drawable.getIntrinsicWidth() + this.bKm.getResources().getDimensionPixelSize(d.e.ds24);
            this.bKn.setVisibility(0);
        }
        if (StringUtils.isNull(aVar.JY())) {
            this.blA.setText((CharSequence) null);
            this.blA.setVisibility(8);
        } else {
            this.blA.setText(UtilHelper.getFixedText(aVar.JY(), 15, false));
            this.blA.setVisibility(0);
        }
        if (aVar.isSelected()) {
            aj.t(this.bKq, d.C0107d.common_color_10271);
        } else {
            aj.t(this.bKq, d.C0107d.common_color_10272);
        }
        boolean isNull = StringUtils.isNull(aVar.JZ());
        boolean isNull2 = StringUtils.isNull(aVar.Ka());
        if (isNull && isNull2) {
            this.bKp.setText((CharSequence) null);
            this.bKp.setVisibility(8);
            string = null;
        } else {
            this.bKp.setVisibility(0);
            if (isNull) {
                string = aVar.Ka();
                this.bKp.setText(string);
            } else if (isNull2) {
                string = aVar.JZ();
                this.bKp.setText(string);
            } else {
                string = TbadkCoreApplication.getInst().getString(d.j.vote_number_text, new Object[]{aVar.JZ(), aVar.Ka()});
                this.bKp.setText(string);
            }
        }
        if (!StringUtils.isNull(string)) {
            intrinsicWidth = (int) (intrinsicWidth + this.bKp.getPaint().measureText(string));
        }
        return this.bKm.getResources().getDimensionPixelSize(d.e.ds24) + this.bKm.getResources().getDimensionPixelSize(d.e.ds10) + 8 + intrinsicWidth;
    }

    public void setProgress(float f) {
        if (f >= 0.0f && this.bKr != null) {
            int i = (int) (100.0f * f);
            if (this.bKr.isSelected()) {
                this.bKo.setProgress(i);
                this.bKo.setSecondaryProgress(0);
                return;
            }
            this.bKo.setProgress(0);
            this.bKo.setSecondaryProgress(i);
        }
    }

    public View getView() {
        return this.bKm;
    }

    public void onChangeSkinType(int i) {
        if (this.bKr != null && this.bKr.Kb() > 0) {
            aj.b(this.bKn, this.bKr.Kb(), i);
        }
        aj.e(this.blA, d.C0107d.cp_cont_b, 1);
        aj.e(this.bKp, this.bKt, 1);
        this.bKo.setProgressDrawable(aj.getDrawable(d.f.vote_progress_drawable));
        if (this.bKr != null) {
            if (this.bKr.isSelected()) {
                aj.t(this.bKq, d.C0107d.common_color_10271);
            } else {
                aj.t(this.bKq, d.C0107d.common_color_10272);
            }
        }
    }
}
