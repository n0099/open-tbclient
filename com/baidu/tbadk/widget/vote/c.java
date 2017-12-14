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
    private View aWm;
    private ImageView aWn;
    private TextView aWo;
    private View aWp;
    private a aWq;
    private int aWr;
    private int aWs;
    private TextView axj;
    private ProgressBar progressBar;

    public c(Context context) {
        this(context, d.C0096d.cp_cont_b);
    }

    public c(Context context, int i) {
        this.aWm = LayoutInflater.from(context).inflate(d.h.ballot_item_view, (ViewGroup) null);
        this.aWn = (ImageView) this.aWm.findViewById(d.g.ballot_item_image);
        this.axj = (TextView) this.aWm.findViewById(d.g.ballot_item_title);
        this.progressBar = (ProgressBar) this.aWm.findViewById(d.g.ballot_item_progress);
        this.aWo = (TextView) this.aWm.findViewById(d.g.ballot_item_percents);
        this.aWp = this.aWm.findViewById(d.g.ballot_item_preffix_progress);
        this.aWr = l.f(context, d.e.ds28);
        this.aWs = i;
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setProgressBarHeight(int i) {
        this.aWr = i;
        this.progressBar.getLayoutParams().height = this.aWr;
        this.aWp.getLayoutParams().height = this.aWr;
    }

    public void setProgressBarTopMargin(int i) {
        if (this.progressBar.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.progressBar.getLayoutParams()).topMargin = i;
        }
        if (this.aWp.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.aWp.getLayoutParams()).topMargin = i;
        }
    }

    public void setDescTopMargin(int i) {
        if (this.aWo.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.aWo.getLayoutParams()).topMargin = i;
        }
    }

    public void gi(int i) {
        if (i >= 0) {
            if (this.aWq != null) {
                int CM = this.aWq.CM();
                i = ((CM <= 100 ? CM : 100) * i) / 100;
            }
            ViewGroup.LayoutParams layoutParams = this.progressBar.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(i, this.aWr);
            } else {
                layoutParams.width = i;
            }
            this.progressBar.setLayoutParams(layoutParams);
        }
    }

    public int a(a aVar) {
        int intrinsicWidth;
        String string;
        this.aWq = aVar;
        if (aVar == null) {
            return 0;
        }
        if (aVar.CL() <= 0) {
            this.aWn.setImageDrawable(null);
            this.aWn.setVisibility(8);
            intrinsicWidth = 0;
        } else {
            Drawable drawable = aj.getDrawable(aVar.CL());
            this.aWn.setImageDrawable(drawable);
            intrinsicWidth = drawable.getIntrinsicWidth() + this.aWm.getResources().getDimensionPixelSize(d.e.ds24);
            this.aWn.setVisibility(0);
        }
        if (StringUtils.isNull(aVar.CI())) {
            this.axj.setText((CharSequence) null);
            this.axj.setVisibility(8);
        } else {
            this.axj.setText(UtilHelper.getFixedText(aVar.CI(), 15, false));
            this.axj.setVisibility(0);
        }
        if (aVar.isSelected()) {
            aj.k(this.aWp, d.C0096d.common_color_10271);
        } else {
            aj.k(this.aWp, d.C0096d.common_color_10272);
        }
        boolean isNull = StringUtils.isNull(aVar.CJ());
        boolean isNull2 = StringUtils.isNull(aVar.CK());
        if (isNull && isNull2) {
            this.aWo.setText((CharSequence) null);
            this.aWo.setVisibility(8);
            string = null;
        } else {
            this.aWo.setVisibility(0);
            if (isNull) {
                string = aVar.CK();
                this.aWo.setText(string);
            } else if (isNull2) {
                string = aVar.CJ();
                this.aWo.setText(string);
            } else {
                string = TbadkCoreApplication.getInst().getString(d.j.vote_number_text, new Object[]{aVar.CJ(), aVar.CK()});
                this.aWo.setText(string);
            }
        }
        if (!StringUtils.isNull(string)) {
            intrinsicWidth = (int) (intrinsicWidth + this.aWo.getPaint().measureText(string));
        }
        return this.aWm.getResources().getDimensionPixelSize(d.e.ds24) + this.aWm.getResources().getDimensionPixelSize(d.e.ds10) + 8 + intrinsicWidth;
    }

    public void setProgress(float f) {
        if (f >= 0.0f && this.aWq != null) {
            int i = (int) (100.0f * f);
            if (this.aWq.isSelected()) {
                this.progressBar.setProgress(i);
                this.progressBar.setSecondaryProgress(0);
                return;
            }
            this.progressBar.setProgress(0);
            this.progressBar.setSecondaryProgress(i);
        }
    }

    public View getView() {
        return this.aWm;
    }

    public void onChangeSkinType(int i) {
        if (this.aWq != null && this.aWq.CL() > 0) {
            aj.b(this.aWn, this.aWq.CL(), i);
        }
        aj.c(this.axj, d.C0096d.cp_cont_b, 1);
        aj.c(this.aWo, this.aWs, 1);
        this.progressBar.setProgressDrawable(aj.getDrawable(d.f.vote_progress_drawable));
        if (this.aWq != null) {
            if (this.aWq.isSelected()) {
                aj.k(this.aWp, d.C0096d.common_color_10271);
            } else {
                aj.k(this.aWp, d.C0096d.common_color_10272);
            }
        }
    }
}
