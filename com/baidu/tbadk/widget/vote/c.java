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
    private View aWp;
    private ImageView aWq;
    private ProgressBar aWr;
    private TextView aWs;
    private View aWt;
    private a aWu;
    private int aWv;
    private int aWw;
    private TextView axm;

    public c(Context context) {
        this(context, d.C0095d.cp_cont_b);
    }

    public c(Context context, int i) {
        this.aWp = LayoutInflater.from(context).inflate(d.h.ballot_item_view, (ViewGroup) null);
        this.aWq = (ImageView) this.aWp.findViewById(d.g.ballot_item_image);
        this.axm = (TextView) this.aWp.findViewById(d.g.ballot_item_title);
        this.aWr = (ProgressBar) this.aWp.findViewById(d.g.ballot_item_progress);
        this.aWs = (TextView) this.aWp.findViewById(d.g.ballot_item_percents);
        this.aWt = this.aWp.findViewById(d.g.ballot_item_preffix_progress);
        this.aWv = l.f(context, d.e.ds28);
        this.aWw = i;
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setProgressBarHeight(int i) {
        this.aWv = i;
        this.aWr.getLayoutParams().height = this.aWv;
        this.aWt.getLayoutParams().height = this.aWv;
    }

    public void setProgressBarTopMargin(int i) {
        if (this.aWr.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.aWr.getLayoutParams()).topMargin = i;
        }
        if (this.aWt.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.aWt.getLayoutParams()).topMargin = i;
        }
    }

    public void setDescTopMargin(int i) {
        if (this.aWs.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.aWs.getLayoutParams()).topMargin = i;
        }
    }

    public void gi(int i) {
        if (i >= 0) {
            if (this.aWu != null) {
                int CM = this.aWu.CM();
                i = ((CM <= 100 ? CM : 100) * i) / 100;
            }
            ViewGroup.LayoutParams layoutParams = this.aWr.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(i, this.aWv);
            } else {
                layoutParams.width = i;
            }
            this.aWr.setLayoutParams(layoutParams);
        }
    }

    public int a(a aVar) {
        int intrinsicWidth;
        String string;
        this.aWu = aVar;
        if (aVar == null) {
            return 0;
        }
        if (aVar.CL() <= 0) {
            this.aWq.setImageDrawable(null);
            this.aWq.setVisibility(8);
            intrinsicWidth = 0;
        } else {
            Drawable drawable = aj.getDrawable(aVar.CL());
            this.aWq.setImageDrawable(drawable);
            intrinsicWidth = drawable.getIntrinsicWidth() + this.aWp.getResources().getDimensionPixelSize(d.e.ds24);
            this.aWq.setVisibility(0);
        }
        if (StringUtils.isNull(aVar.CI())) {
            this.axm.setText((CharSequence) null);
            this.axm.setVisibility(8);
        } else {
            this.axm.setText(UtilHelper.getFixedText(aVar.CI(), 15, false));
            this.axm.setVisibility(0);
        }
        if (aVar.isSelected()) {
            aj.k(this.aWt, d.C0095d.common_color_10271);
        } else {
            aj.k(this.aWt, d.C0095d.common_color_10272);
        }
        boolean isNull = StringUtils.isNull(aVar.CJ());
        boolean isNull2 = StringUtils.isNull(aVar.CK());
        if (isNull && isNull2) {
            this.aWs.setText((CharSequence) null);
            this.aWs.setVisibility(8);
            string = null;
        } else {
            this.aWs.setVisibility(0);
            if (isNull) {
                string = aVar.CK();
                this.aWs.setText(string);
            } else if (isNull2) {
                string = aVar.CJ();
                this.aWs.setText(string);
            } else {
                string = TbadkCoreApplication.getInst().getString(d.j.vote_number_text, new Object[]{aVar.CJ(), aVar.CK()});
                this.aWs.setText(string);
            }
        }
        if (!StringUtils.isNull(string)) {
            intrinsicWidth = (int) (intrinsicWidth + this.aWs.getPaint().measureText(string));
        }
        return this.aWp.getResources().getDimensionPixelSize(d.e.ds24) + this.aWp.getResources().getDimensionPixelSize(d.e.ds10) + 8 + intrinsicWidth;
    }

    public void setProgress(float f) {
        if (f >= 0.0f && this.aWu != null) {
            int i = (int) (100.0f * f);
            if (this.aWu.isSelected()) {
                this.aWr.setProgress(i);
                this.aWr.setSecondaryProgress(0);
                return;
            }
            this.aWr.setProgress(0);
            this.aWr.setSecondaryProgress(i);
        }
    }

    public View getView() {
        return this.aWp;
    }

    public void onChangeSkinType(int i) {
        if (this.aWu != null && this.aWu.CL() > 0) {
            aj.b(this.aWq, this.aWu.CL(), i);
        }
        aj.c(this.axm, d.C0095d.cp_cont_b, 1);
        aj.c(this.aWs, this.aWw, 1);
        this.aWr.setProgressDrawable(aj.getDrawable(d.f.vote_progress_drawable));
        if (this.aWu != null) {
            if (this.aWu.isSelected()) {
                aj.k(this.aWt, d.C0095d.common_color_10271);
            } else {
                aj.k(this.aWt, d.C0095d.common_color_10272);
            }
        }
    }
}
