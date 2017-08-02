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
    private View aRp;
    private ImageView aRq;
    private ProgressBar aRr;
    private TextView aRs;
    private View aRt;
    private a aRu;
    private int aRv;
    private int aRw;
    private TextView awz;

    public c(Context context) {
        this(context, d.e.cp_cont_b);
    }

    public c(Context context, int i) {
        this.aRp = LayoutInflater.from(context).inflate(d.j.ballot_item_view, (ViewGroup) null);
        this.aRq = (ImageView) this.aRp.findViewById(d.h.ballot_item_image);
        this.awz = (TextView) this.aRp.findViewById(d.h.ballot_item_title);
        this.aRr = (ProgressBar) this.aRp.findViewById(d.h.ballot_item_progress);
        this.aRs = (TextView) this.aRp.findViewById(d.h.ballot_item_percents);
        this.aRt = this.aRp.findViewById(d.h.ballot_item_preffix_progress);
        this.aRv = k.g(context, d.f.ds28);
        this.aRw = i;
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setProgressBarHeight(int i) {
        this.aRv = i;
        this.aRr.getLayoutParams().height = this.aRv;
        this.aRt.getLayoutParams().height = this.aRv;
    }

    public void setProgressBarTopMargin(int i) {
        if (this.aRr.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.aRr.getLayoutParams()).topMargin = i;
        }
        if (this.aRt.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.aRt.getLayoutParams()).topMargin = i;
        }
    }

    public void setDescTopMargin(int i) {
        if (this.aRs.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.aRs.getLayoutParams()).topMargin = i;
        }
    }

    public void fD(int i) {
        if (i >= 0) {
            if (this.aRu != null) {
                int CA = this.aRu.CA();
                i = ((CA <= 100 ? CA : 100) * i) / 100;
            }
            ViewGroup.LayoutParams layoutParams = this.aRr.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(i, this.aRv);
            } else {
                layoutParams.width = i;
            }
            this.aRr.setLayoutParams(layoutParams);
        }
    }

    public int a(a aVar) {
        int intrinsicWidth;
        String string;
        this.aRu = aVar;
        if (aVar == null) {
            return 0;
        }
        if (aVar.Cz() <= 0) {
            this.aRq.setImageDrawable(null);
            this.aRq.setVisibility(8);
            intrinsicWidth = 0;
        } else {
            Drawable drawable = ai.getDrawable(aVar.Cz());
            this.aRq.setImageDrawable(drawable);
            intrinsicWidth = drawable.getIntrinsicWidth() + this.aRp.getResources().getDimensionPixelSize(d.f.ds24);
            this.aRq.setVisibility(0);
        }
        if (StringUtils.isNull(aVar.Cw())) {
            this.awz.setText((CharSequence) null);
            this.awz.setVisibility(8);
        } else {
            this.awz.setText(UtilHelper.getFixedText(aVar.Cw(), 15, false));
            this.awz.setVisibility(0);
        }
        if (aVar.isSelected()) {
            ai.k(this.aRt, d.e.common_color_10271);
        } else {
            ai.k(this.aRt, d.e.common_color_10272);
        }
        boolean isNull = StringUtils.isNull(aVar.Cx());
        boolean isNull2 = StringUtils.isNull(aVar.Cy());
        if (isNull && isNull2) {
            this.aRs.setText((CharSequence) null);
            this.aRs.setVisibility(8);
            string = null;
        } else {
            this.aRs.setVisibility(0);
            if (isNull) {
                string = aVar.Cy();
                this.aRs.setText(string);
            } else if (isNull2) {
                string = aVar.Cx();
                this.aRs.setText(string);
            } else {
                string = TbadkCoreApplication.getInst().getString(d.l.vote_number_text, new Object[]{aVar.Cx(), aVar.Cy()});
                this.aRs.setText(string);
            }
        }
        if (!StringUtils.isNull(string)) {
            intrinsicWidth = (int) (intrinsicWidth + this.aRs.getPaint().measureText(string));
        }
        return this.aRp.getResources().getDimensionPixelSize(d.f.ds24) + this.aRp.getResources().getDimensionPixelSize(d.f.ds10) + 8 + intrinsicWidth;
    }

    public void setProgress(float f) {
        if (f >= 0.0f && this.aRu != null) {
            int i = (int) (100.0f * f);
            if (this.aRu.isSelected()) {
                this.aRr.setProgress(i);
                this.aRr.setSecondaryProgress(0);
                return;
            }
            this.aRr.setProgress(0);
            this.aRr.setSecondaryProgress(i);
        }
    }

    public View getView() {
        return this.aRp;
    }

    public void onChangeSkinType(int i) {
        if (this.aRu != null && this.aRu.Cz() > 0) {
            ai.c(this.aRq, this.aRu.Cz(), i);
        }
        ai.c(this.awz, d.e.cp_cont_b, 1);
        ai.c(this.aRs, this.aRw, 1);
        this.aRr.setProgressDrawable(ai.getDrawable(d.g.vote_progress_drawable));
        if (this.aRu != null) {
            if (this.aRu.isSelected()) {
                ai.k(this.aRt, d.e.common_color_10271);
            } else {
                ai.k(this.aRt, d.e.common_color_10272);
            }
        }
    }
}
