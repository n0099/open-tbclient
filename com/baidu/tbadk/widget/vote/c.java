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
    private View bKe;
    private ImageView bKf;
    private ProgressBar bKg;
    private TextView bKh;
    private View bKi;
    private a bKj;
    private int bKk;
    private int bKl;
    private TextView blr;

    public c(Context context) {
        this(context, d.C0108d.cp_cont_b);
    }

    public c(Context context, int i) {
        this.bKe = LayoutInflater.from(context).inflate(d.h.ballot_item_view, (ViewGroup) null);
        this.bKf = (ImageView) this.bKe.findViewById(d.g.ballot_item_image);
        this.blr = (TextView) this.bKe.findViewById(d.g.ballot_item_title);
        this.bKg = (ProgressBar) this.bKe.findViewById(d.g.ballot_item_progress);
        this.bKh = (TextView) this.bKe.findViewById(d.g.ballot_item_percents);
        this.bKi = this.bKe.findViewById(d.g.ballot_item_preffix_progress);
        this.bKk = l.s(context, d.e.ds28);
        this.bKl = i;
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setProgressBarHeight(int i) {
        this.bKk = i;
        this.bKg.getLayoutParams().height = this.bKk;
        this.bKi.getLayoutParams().height = this.bKk;
    }

    public void setProgressBarTopMargin(int i) {
        if (this.bKg.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.bKg.getLayoutParams()).topMargin = i;
        }
        if (this.bKi.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.bKi.getLayoutParams()).topMargin = i;
        }
    }

    public void setDescTopMargin(int i) {
        if (this.bKh.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.bKh.getLayoutParams()).topMargin = i;
        }
    }

    public void jh(int i) {
        if (i >= 0) {
            if (this.bKj != null) {
                int Kn = this.bKj.Kn();
                i = ((Kn <= 100 ? Kn : 100) * i) / 100;
            }
            ViewGroup.LayoutParams layoutParams = this.bKg.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(i, this.bKk);
            } else {
                layoutParams.width = i;
            }
            this.bKg.setLayoutParams(layoutParams);
        }
    }

    public int a(a aVar) {
        int intrinsicWidth;
        String string;
        this.bKj = aVar;
        if (aVar == null) {
            return 0;
        }
        if (aVar.Km() <= 0) {
            this.bKf.setImageDrawable(null);
            this.bKf.setVisibility(8);
            intrinsicWidth = 0;
        } else {
            Drawable drawable = aj.getDrawable(aVar.Km());
            this.bKf.setImageDrawable(drawable);
            intrinsicWidth = drawable.getIntrinsicWidth() + this.bKe.getResources().getDimensionPixelSize(d.e.ds24);
            this.bKf.setVisibility(0);
        }
        if (StringUtils.isNull(aVar.Kj())) {
            this.blr.setText((CharSequence) null);
            this.blr.setVisibility(8);
        } else {
            this.blr.setText(UtilHelper.getFixedText(aVar.Kj(), 15, false));
            this.blr.setVisibility(0);
        }
        if (aVar.isSelected()) {
            aj.t(this.bKi, d.C0108d.common_color_10271);
        } else {
            aj.t(this.bKi, d.C0108d.common_color_10272);
        }
        boolean isNull = StringUtils.isNull(aVar.Kk());
        boolean isNull2 = StringUtils.isNull(aVar.Kl());
        if (isNull && isNull2) {
            this.bKh.setText((CharSequence) null);
            this.bKh.setVisibility(8);
            string = null;
        } else {
            this.bKh.setVisibility(0);
            if (isNull) {
                string = aVar.Kl();
                this.bKh.setText(string);
            } else if (isNull2) {
                string = aVar.Kk();
                this.bKh.setText(string);
            } else {
                string = TbadkCoreApplication.getInst().getString(d.j.vote_number_text, new Object[]{aVar.Kk(), aVar.Kl()});
                this.bKh.setText(string);
            }
        }
        if (!StringUtils.isNull(string)) {
            intrinsicWidth = (int) (intrinsicWidth + this.bKh.getPaint().measureText(string));
        }
        return this.bKe.getResources().getDimensionPixelSize(d.e.ds24) + this.bKe.getResources().getDimensionPixelSize(d.e.ds10) + 8 + intrinsicWidth;
    }

    public void setProgress(float f) {
        if (f >= 0.0f && this.bKj != null) {
            int i = (int) (100.0f * f);
            if (this.bKj.isSelected()) {
                this.bKg.setProgress(i);
                this.bKg.setSecondaryProgress(0);
                return;
            }
            this.bKg.setProgress(0);
            this.bKg.setSecondaryProgress(i);
        }
    }

    public View getView() {
        return this.bKe;
    }

    public void onChangeSkinType(int i) {
        if (this.bKj != null && this.bKj.Km() > 0) {
            aj.b(this.bKf, this.bKj.Km(), i);
        }
        aj.e(this.blr, d.C0108d.cp_cont_b, 1);
        aj.e(this.bKh, this.bKl, 1);
        this.bKg.setProgressDrawable(aj.getDrawable(d.f.vote_progress_drawable));
        if (this.bKj != null) {
            if (this.bKj.isSelected()) {
                aj.t(this.bKi, d.C0108d.common_color_10271);
            } else {
                aj.t(this.bKi, d.C0108d.common_color_10272);
            }
        }
    }
}
