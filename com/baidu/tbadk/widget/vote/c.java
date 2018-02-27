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
    private View bMm;
    private ImageView bMn;
    private TextView bMo;
    private View bMp;
    private a bMq;
    private int bMr;
    private int bMs;
    private ProgressBar progressBar;
    private TextView title;

    public c(Context context) {
        this(context, d.C0141d.cp_cont_b);
    }

    public c(Context context, int i) {
        this.bMm = LayoutInflater.from(context).inflate(d.h.ballot_item_view, (ViewGroup) null);
        this.bMn = (ImageView) this.bMm.findViewById(d.g.ballot_item_image);
        this.title = (TextView) this.bMm.findViewById(d.g.ballot_item_title);
        this.progressBar = (ProgressBar) this.bMm.findViewById(d.g.ballot_item_progress);
        this.bMo = (TextView) this.bMm.findViewById(d.g.ballot_item_percents);
        this.bMp = this.bMm.findViewById(d.g.ballot_item_preffix_progress);
        this.bMr = l.t(context, d.e.ds28);
        this.bMs = i;
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setProgressBarHeight(int i) {
        this.bMr = i;
        this.progressBar.getLayoutParams().height = this.bMr;
        this.bMp.getLayoutParams().height = this.bMr;
    }

    public void setProgressBarTopMargin(int i) {
        if (this.progressBar.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.progressBar.getLayoutParams()).topMargin = i;
        }
        if (this.bMp.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.bMp.getLayoutParams()).topMargin = i;
        }
    }

    public void setDescTopMargin(int i) {
        if (this.bMo.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.bMo.getLayoutParams()).topMargin = i;
        }
    }

    public void iZ(int i) {
        if (i >= 0) {
            if (this.bMq != null) {
                int KJ = this.bMq.KJ();
                i = ((KJ <= 100 ? KJ : 100) * i) / 100;
            }
            ViewGroup.LayoutParams layoutParams = this.progressBar.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(i, this.bMr);
            } else {
                layoutParams.width = i;
            }
            this.progressBar.setLayoutParams(layoutParams);
        }
    }

    public int a(a aVar) {
        int intrinsicWidth;
        String string;
        this.bMq = aVar;
        if (aVar == null) {
            return 0;
        }
        if (aVar.KI() <= 0) {
            this.bMn.setImageDrawable(null);
            this.bMn.setVisibility(8);
            intrinsicWidth = 0;
        } else {
            Drawable drawable = aj.getDrawable(aVar.KI());
            this.bMn.setImageDrawable(drawable);
            intrinsicWidth = drawable.getIntrinsicWidth() + this.bMm.getResources().getDimensionPixelSize(d.e.ds24);
            this.bMn.setVisibility(0);
        }
        if (StringUtils.isNull(aVar.KF())) {
            this.title.setText((CharSequence) null);
            this.title.setVisibility(8);
        } else {
            this.title.setText(UtilHelper.getFixedText(aVar.KF(), 15, false));
            this.title.setVisibility(0);
        }
        if (aVar.isSelected()) {
            aj.t(this.bMp, d.C0141d.common_color_10271);
        } else {
            aj.t(this.bMp, d.C0141d.common_color_10272);
        }
        boolean isNull = StringUtils.isNull(aVar.KG());
        boolean isNull2 = StringUtils.isNull(aVar.KH());
        if (isNull && isNull2) {
            this.bMo.setText((CharSequence) null);
            this.bMo.setVisibility(8);
            string = null;
        } else {
            this.bMo.setVisibility(0);
            if (isNull) {
                string = aVar.KH();
                this.bMo.setText(string);
            } else if (isNull2) {
                string = aVar.KG();
                this.bMo.setText(string);
            } else {
                string = TbadkCoreApplication.getInst().getString(d.j.vote_number_text, new Object[]{aVar.KG(), aVar.KH()});
                this.bMo.setText(string);
            }
        }
        if (!StringUtils.isNull(string)) {
            intrinsicWidth = (int) (intrinsicWidth + this.bMo.getPaint().measureText(string));
        }
        return this.bMm.getResources().getDimensionPixelSize(d.e.ds24) + this.bMm.getResources().getDimensionPixelSize(d.e.ds10) + 8 + intrinsicWidth;
    }

    public void setProgress(float f) {
        if (f >= 0.0f && this.bMq != null) {
            int i = (int) (100.0f * f);
            if (this.bMq.isSelected()) {
                this.progressBar.setProgress(i);
                this.progressBar.setSecondaryProgress(0);
                return;
            }
            this.progressBar.setProgress(0);
            this.progressBar.setSecondaryProgress(i);
        }
    }

    public View getView() {
        return this.bMm;
    }

    public void onChangeSkinType(int i) {
        if (this.bMq != null && this.bMq.KI() > 0) {
            aj.b(this.bMn, this.bMq.KI(), i);
        }
        aj.e(this.title, d.C0141d.cp_cont_b, 1);
        aj.e(this.bMo, this.bMs, 1);
        this.progressBar.setProgressDrawable(aj.getDrawable(d.f.vote_progress_drawable));
        if (this.bMq != null) {
            if (this.bMq.isSelected()) {
                aj.t(this.bMp, d.C0141d.common_color_10271);
            } else {
                aj.t(this.bMp, d.C0141d.common_color_10272);
            }
        }
    }
}
