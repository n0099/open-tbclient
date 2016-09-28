package com.baidu.tbadk.widget.vote;

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
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class c {
    private View aJQ;
    private ImageView aJR;
    private ProgressBar aJS;
    private TextView aJT;
    private View aJU;
    private a aJV;
    private int aJW;
    private int aJX;
    private TextView title;

    public c(Context context) {
        this(context, r.d.cp_cont_c);
    }

    public c(Context context, int i) {
        this.aJQ = LayoutInflater.from(context).inflate(r.h.ballot_item_view, (ViewGroup) null);
        this.aJR = (ImageView) this.aJQ.findViewById(r.g.ballot_item_image);
        this.title = (TextView) this.aJQ.findViewById(r.g.ballot_item_title);
        this.aJS = (ProgressBar) this.aJQ.findViewById(r.g.ballot_item_progress);
        this.aJT = (TextView) this.aJQ.findViewById(r.g.ballot_item_percents);
        this.aJU = this.aJQ.findViewById(r.g.ballot_item_preffix_progress);
        this.aJW = k.e(context, r.e.ds28);
        this.aJX = i;
        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
    }

    public void setProgressBarHeight(int i) {
        this.aJW = i;
        this.aJS.getLayoutParams().height = this.aJW;
        this.aJU.getLayoutParams().height = this.aJW;
    }

    public void setProgressBarTopMargin(int i) {
        if (this.aJS.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.aJS.getLayoutParams()).topMargin = i;
        }
        if (this.aJU.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.aJU.getLayoutParams()).topMargin = i;
        }
    }

    public void setDescTopMargin(int i) {
        if (this.aJT.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.aJT.getLayoutParams()).topMargin = i;
        }
    }

    public void fA(int i) {
        if (i >= 0) {
            if (this.aJV != null) {
                int Cn = this.aJV.Cn();
                i = ((Cn <= 100 ? Cn : 100) * i) / 100;
            }
            ViewGroup.LayoutParams layoutParams = this.aJS.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(i, this.aJW);
            } else {
                layoutParams.width = i;
            }
            this.aJS.setLayoutParams(layoutParams);
        }
    }

    public int a(a aVar) {
        int intrinsicWidth;
        String string;
        this.aJV = aVar;
        if (aVar == null) {
            return 0;
        }
        if (aVar.Cm() <= 0) {
            this.aJR.setImageDrawable(null);
            this.aJR.setVisibility(8);
            intrinsicWidth = 0;
        } else {
            Drawable drawable = av.getDrawable(aVar.Cm());
            this.aJR.setImageDrawable(drawable);
            intrinsicWidth = drawable.getIntrinsicWidth() + this.aJQ.getResources().getDimensionPixelSize(r.e.ds24);
            this.aJR.setVisibility(0);
        }
        if (StringUtils.isNull(aVar.Cj())) {
            this.title.setText((CharSequence) null);
            this.title.setVisibility(8);
        } else {
            this.title.setText(UtilHelper.getFixedText(aVar.Cj(), 15, false));
            this.title.setVisibility(0);
        }
        if (aVar.isSelected()) {
            av.l(this.aJU, r.d.common_color_10271);
        } else {
            av.l(this.aJU, r.d.common_color_10272);
        }
        boolean isNull = StringUtils.isNull(aVar.Ck());
        boolean isNull2 = StringUtils.isNull(aVar.Cl());
        if (isNull && isNull2) {
            this.aJT.setText((CharSequence) null);
            this.aJT.setVisibility(8);
            string = null;
        } else {
            this.aJT.setVisibility(0);
            if (isNull) {
                string = aVar.Cl();
                this.aJT.setText(string);
            } else if (isNull2) {
                string = aVar.Ck();
                this.aJT.setText(string);
            } else {
                string = TbadkCoreApplication.m9getInst().getString(r.j.vote_number_text, new Object[]{aVar.Ck(), aVar.Cl()});
                this.aJT.setText(string);
            }
        }
        if (!StringUtils.isNull(string)) {
            intrinsicWidth = (int) (intrinsicWidth + this.aJT.getPaint().measureText(string));
        }
        return this.aJQ.getResources().getDimensionPixelSize(r.e.ds24) + this.aJQ.getResources().getDimensionPixelSize(r.e.ds10) + 8 + intrinsicWidth;
    }

    public void setProgress(float f) {
        if (f >= 0.0f && this.aJV != null) {
            int i = (int) (100.0f * f);
            if (this.aJV.isSelected()) {
                this.aJS.setProgress(i);
                this.aJS.setSecondaryProgress(0);
                return;
            }
            this.aJS.setProgress(0);
            this.aJS.setSecondaryProgress(i);
        }
    }

    public View getView() {
        return this.aJQ;
    }

    public void onChangeSkinType(int i) {
        if (this.aJV != null && this.aJV.Cm() > 0) {
            av.c(this.aJR, this.aJV.Cm(), i);
        }
        av.c(this.title, r.d.cp_cont_b, 1);
        av.c(this.aJT, this.aJX, 1);
        this.aJS.setProgressDrawable(av.getDrawable(r.f.vote_progress_drawable));
        if (this.aJV != null) {
            if (this.aJV.isSelected()) {
                av.l(this.aJU, r.d.common_color_10271);
            } else {
                av.l(this.aJU, r.d.common_color_10272);
            }
        }
    }
}
