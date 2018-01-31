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
    private int bKA;
    private int bKB;
    private View bKu;
    private ImageView bKv;
    private ProgressBar bKw;
    private TextView bKx;
    private View bKy;
    private a bKz;
    private TextView blI;

    public c(Context context) {
        this(context, d.C0108d.cp_cont_b);
    }

    public c(Context context, int i) {
        this.bKu = LayoutInflater.from(context).inflate(d.h.ballot_item_view, (ViewGroup) null);
        this.bKv = (ImageView) this.bKu.findViewById(d.g.ballot_item_image);
        this.blI = (TextView) this.bKu.findViewById(d.g.ballot_item_title);
        this.bKw = (ProgressBar) this.bKu.findViewById(d.g.ballot_item_progress);
        this.bKx = (TextView) this.bKu.findViewById(d.g.ballot_item_percents);
        this.bKy = this.bKu.findViewById(d.g.ballot_item_preffix_progress);
        this.bKA = l.s(context, d.e.ds28);
        this.bKB = i;
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setProgressBarHeight(int i) {
        this.bKA = i;
        this.bKw.getLayoutParams().height = this.bKA;
        this.bKy.getLayoutParams().height = this.bKA;
    }

    public void setProgressBarTopMargin(int i) {
        if (this.bKw.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.bKw.getLayoutParams()).topMargin = i;
        }
        if (this.bKy.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.bKy.getLayoutParams()).topMargin = i;
        }
    }

    public void setDescTopMargin(int i) {
        if (this.bKx.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.bKx.getLayoutParams()).topMargin = i;
        }
    }

    public void jd(int i) {
        if (i >= 0) {
            if (this.bKz != null) {
                int Ke = this.bKz.Ke();
                i = ((Ke <= 100 ? Ke : 100) * i) / 100;
            }
            ViewGroup.LayoutParams layoutParams = this.bKw.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(i, this.bKA);
            } else {
                layoutParams.width = i;
            }
            this.bKw.setLayoutParams(layoutParams);
        }
    }

    public int a(a aVar) {
        int intrinsicWidth;
        String string;
        this.bKz = aVar;
        if (aVar == null) {
            return 0;
        }
        if (aVar.Kd() <= 0) {
            this.bKv.setImageDrawable(null);
            this.bKv.setVisibility(8);
            intrinsicWidth = 0;
        } else {
            Drawable drawable = aj.getDrawable(aVar.Kd());
            this.bKv.setImageDrawable(drawable);
            intrinsicWidth = drawable.getIntrinsicWidth() + this.bKu.getResources().getDimensionPixelSize(d.e.ds24);
            this.bKv.setVisibility(0);
        }
        if (StringUtils.isNull(aVar.Ka())) {
            this.blI.setText((CharSequence) null);
            this.blI.setVisibility(8);
        } else {
            this.blI.setText(UtilHelper.getFixedText(aVar.Ka(), 15, false));
            this.blI.setVisibility(0);
        }
        if (aVar.isSelected()) {
            aj.t(this.bKy, d.C0108d.common_color_10271);
        } else {
            aj.t(this.bKy, d.C0108d.common_color_10272);
        }
        boolean isNull = StringUtils.isNull(aVar.Kb());
        boolean isNull2 = StringUtils.isNull(aVar.Kc());
        if (isNull && isNull2) {
            this.bKx.setText((CharSequence) null);
            this.bKx.setVisibility(8);
            string = null;
        } else {
            this.bKx.setVisibility(0);
            if (isNull) {
                string = aVar.Kc();
                this.bKx.setText(string);
            } else if (isNull2) {
                string = aVar.Kb();
                this.bKx.setText(string);
            } else {
                string = TbadkCoreApplication.getInst().getString(d.j.vote_number_text, new Object[]{aVar.Kb(), aVar.Kc()});
                this.bKx.setText(string);
            }
        }
        if (!StringUtils.isNull(string)) {
            intrinsicWidth = (int) (intrinsicWidth + this.bKx.getPaint().measureText(string));
        }
        return this.bKu.getResources().getDimensionPixelSize(d.e.ds24) + this.bKu.getResources().getDimensionPixelSize(d.e.ds10) + 8 + intrinsicWidth;
    }

    public void setProgress(float f) {
        if (f >= 0.0f && this.bKz != null) {
            int i = (int) (100.0f * f);
            if (this.bKz.isSelected()) {
                this.bKw.setProgress(i);
                this.bKw.setSecondaryProgress(0);
                return;
            }
            this.bKw.setProgress(0);
            this.bKw.setSecondaryProgress(i);
        }
    }

    public View getView() {
        return this.bKu;
    }

    public void onChangeSkinType(int i) {
        if (this.bKz != null && this.bKz.Kd() > 0) {
            aj.b(this.bKv, this.bKz.Kd(), i);
        }
        aj.e(this.blI, d.C0108d.cp_cont_b, 1);
        aj.e(this.bKx, this.bKB, 1);
        this.bKw.setProgressDrawable(aj.getDrawable(d.f.vote_progress_drawable));
        if (this.bKz != null) {
            if (this.bKz.isSelected()) {
                aj.t(this.bKy, d.C0108d.common_color_10271);
            } else {
                aj.t(this.bKy, d.C0108d.common_color_10272);
            }
        }
    }
}
