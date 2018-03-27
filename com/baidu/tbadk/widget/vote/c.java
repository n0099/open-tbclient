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
    private View bMp;
    private ImageView bMq;
    private TextView bMr;
    private View bMs;
    private a bMt;
    private int bMu;
    private int bMv;
    private ProgressBar progressBar;
    private TextView title;

    public c(Context context) {
        this(context, d.C0141d.cp_cont_b);
    }

    public c(Context context, int i) {
        this.bMp = LayoutInflater.from(context).inflate(d.h.ballot_item_view, (ViewGroup) null);
        this.bMq = (ImageView) this.bMp.findViewById(d.g.ballot_item_image);
        this.title = (TextView) this.bMp.findViewById(d.g.ballot_item_title);
        this.progressBar = (ProgressBar) this.bMp.findViewById(d.g.ballot_item_progress);
        this.bMr = (TextView) this.bMp.findViewById(d.g.ballot_item_percents);
        this.bMs = this.bMp.findViewById(d.g.ballot_item_preffix_progress);
        this.bMu = l.t(context, d.e.ds28);
        this.bMv = i;
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setProgressBarHeight(int i) {
        this.bMu = i;
        this.progressBar.getLayoutParams().height = this.bMu;
        this.bMs.getLayoutParams().height = this.bMu;
    }

    public void setProgressBarTopMargin(int i) {
        if (this.progressBar.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.progressBar.getLayoutParams()).topMargin = i;
        }
        if (this.bMs.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.bMs.getLayoutParams()).topMargin = i;
        }
    }

    public void setDescTopMargin(int i) {
        if (this.bMr.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.bMr.getLayoutParams()).topMargin = i;
        }
    }

    public void iZ(int i) {
        if (i >= 0) {
            if (this.bMt != null) {
                int KK = this.bMt.KK();
                i = ((KK <= 100 ? KK : 100) * i) / 100;
            }
            ViewGroup.LayoutParams layoutParams = this.progressBar.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(i, this.bMu);
            } else {
                layoutParams.width = i;
            }
            this.progressBar.setLayoutParams(layoutParams);
        }
    }

    public int a(a aVar) {
        int intrinsicWidth;
        String string;
        this.bMt = aVar;
        if (aVar == null) {
            return 0;
        }
        if (aVar.KJ() <= 0) {
            this.bMq.setImageDrawable(null);
            this.bMq.setVisibility(8);
            intrinsicWidth = 0;
        } else {
            Drawable drawable = aj.getDrawable(aVar.KJ());
            this.bMq.setImageDrawable(drawable);
            intrinsicWidth = drawable.getIntrinsicWidth() + this.bMp.getResources().getDimensionPixelSize(d.e.ds24);
            this.bMq.setVisibility(0);
        }
        if (StringUtils.isNull(aVar.KG())) {
            this.title.setText((CharSequence) null);
            this.title.setVisibility(8);
        } else {
            this.title.setText(UtilHelper.getFixedText(aVar.KG(), 15, false));
            this.title.setVisibility(0);
        }
        if (aVar.isSelected()) {
            aj.t(this.bMs, d.C0141d.common_color_10271);
        } else {
            aj.t(this.bMs, d.C0141d.common_color_10272);
        }
        boolean isNull = StringUtils.isNull(aVar.KH());
        boolean isNull2 = StringUtils.isNull(aVar.KI());
        if (isNull && isNull2) {
            this.bMr.setText((CharSequence) null);
            this.bMr.setVisibility(8);
            string = null;
        } else {
            this.bMr.setVisibility(0);
            if (isNull) {
                string = aVar.KI();
                this.bMr.setText(string);
            } else if (isNull2) {
                string = aVar.KH();
                this.bMr.setText(string);
            } else {
                string = TbadkCoreApplication.getInst().getString(d.j.vote_number_text, new Object[]{aVar.KH(), aVar.KI()});
                this.bMr.setText(string);
            }
        }
        if (!StringUtils.isNull(string)) {
            intrinsicWidth = (int) (intrinsicWidth + this.bMr.getPaint().measureText(string));
        }
        return this.bMp.getResources().getDimensionPixelSize(d.e.ds24) + this.bMp.getResources().getDimensionPixelSize(d.e.ds10) + 8 + intrinsicWidth;
    }

    public void setProgress(float f) {
        if (f >= 0.0f && this.bMt != null) {
            int i = (int) (100.0f * f);
            if (this.bMt.isSelected()) {
                this.progressBar.setProgress(i);
                this.progressBar.setSecondaryProgress(0);
                return;
            }
            this.progressBar.setProgress(0);
            this.progressBar.setSecondaryProgress(i);
        }
    }

    public View getView() {
        return this.bMp;
    }

    public void onChangeSkinType(int i) {
        if (this.bMt != null && this.bMt.KJ() > 0) {
            aj.b(this.bMq, this.bMt.KJ(), i);
        }
        aj.e(this.title, d.C0141d.cp_cont_b, 1);
        aj.e(this.bMr, this.bMv, 1);
        this.progressBar.setProgressDrawable(aj.getDrawable(d.f.vote_progress_drawable));
        if (this.bMt != null) {
            if (this.bMt.isSelected()) {
                aj.t(this.bMs, d.C0141d.common_color_10271);
            } else {
                aj.t(this.bMs, d.C0141d.common_color_10272);
            }
        }
    }
}
