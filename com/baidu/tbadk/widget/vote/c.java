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
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class c {
    private View aKr;
    private ImageView aKs;
    private ProgressBar aKt;
    private TextView aKu;
    private View aKv;
    private a aKw;
    private int aKx;
    private int aKy;
    private TextView title;

    public c(Context context) {
        this(context, t.d.cp_cont_c);
    }

    public c(Context context, int i) {
        this.aKr = LayoutInflater.from(context).inflate(t.h.ballot_item_view, (ViewGroup) null);
        this.aKs = (ImageView) this.aKr.findViewById(t.g.ballot_item_image);
        this.title = (TextView) this.aKr.findViewById(t.g.ballot_item_title);
        this.aKt = (ProgressBar) this.aKr.findViewById(t.g.ballot_item_progress);
        this.aKu = (TextView) this.aKr.findViewById(t.g.ballot_item_percents);
        this.aKv = this.aKr.findViewById(t.g.ballot_item_preffix_progress);
        this.aKx = k.e(context, t.e.ds28);
        this.aKy = i;
        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
    }

    public void setProgressBarHeight(int i) {
        this.aKx = i;
        this.aKt.getLayoutParams().height = this.aKx;
        this.aKv.getLayoutParams().height = this.aKx;
    }

    public void setProgressBarTopMargin(int i) {
        if (this.aKt.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.aKt.getLayoutParams()).topMargin = i;
        }
        if (this.aKv.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.aKv.getLayoutParams()).topMargin = i;
        }
    }

    public void setDescTopMargin(int i) {
        if (this.aKu.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.aKu.getLayoutParams()).topMargin = i;
        }
    }

    public void fB(int i) {
        if (i >= 0) {
            if (this.aKw != null) {
                int Ck = this.aKw.Ck();
                i = ((Ck <= 100 ? Ck : 100) * i) / 100;
            }
            ViewGroup.LayoutParams layoutParams = this.aKt.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(i, this.aKx);
            } else {
                layoutParams.width = i;
            }
            this.aKt.setLayoutParams(layoutParams);
        }
    }

    public int a(a aVar) {
        int intrinsicWidth;
        String string;
        this.aKw = aVar;
        if (aVar == null) {
            return 0;
        }
        if (aVar.Cj() <= 0) {
            this.aKs.setImageDrawable(null);
            this.aKs.setVisibility(8);
            intrinsicWidth = 0;
        } else {
            Drawable drawable = av.getDrawable(aVar.Cj());
            this.aKs.setImageDrawable(drawable);
            intrinsicWidth = drawable.getIntrinsicWidth() + this.aKr.getResources().getDimensionPixelSize(t.e.ds24);
            this.aKs.setVisibility(0);
        }
        if (StringUtils.isNull(aVar.Cg())) {
            this.title.setText((CharSequence) null);
            this.title.setVisibility(8);
        } else {
            this.title.setText(UtilHelper.getFixedText(aVar.Cg(), 15, false));
            this.title.setVisibility(0);
        }
        if (aVar.isSelected()) {
            av.l(this.aKv, t.d.common_color_10271);
        } else {
            av.l(this.aKv, t.d.common_color_10272);
        }
        boolean isNull = StringUtils.isNull(aVar.Ch());
        boolean isNull2 = StringUtils.isNull(aVar.Ci());
        if (isNull && isNull2) {
            this.aKu.setText((CharSequence) null);
            this.aKu.setVisibility(8);
            string = null;
        } else {
            this.aKu.setVisibility(0);
            if (isNull) {
                string = aVar.Ci();
                this.aKu.setText(string);
            } else if (isNull2) {
                string = aVar.Ch();
                this.aKu.setText(string);
            } else {
                string = TbadkCoreApplication.m9getInst().getString(t.j.vote_number_text, new Object[]{aVar.Ch(), aVar.Ci()});
                this.aKu.setText(string);
            }
        }
        if (!StringUtils.isNull(string)) {
            intrinsicWidth = (int) (intrinsicWidth + this.aKu.getPaint().measureText(string));
        }
        return this.aKr.getResources().getDimensionPixelSize(t.e.ds24) + this.aKr.getResources().getDimensionPixelSize(t.e.ds10) + 8 + intrinsicWidth;
    }

    public void setProgress(float f) {
        if (f >= 0.0f && this.aKw != null) {
            int i = (int) (100.0f * f);
            if (this.aKw.isSelected()) {
                this.aKt.setProgress(i);
                this.aKt.setSecondaryProgress(0);
                return;
            }
            this.aKt.setProgress(0);
            this.aKt.setSecondaryProgress(i);
        }
    }

    public View getView() {
        return this.aKr;
    }

    public void onChangeSkinType(int i) {
        if (this.aKw != null && this.aKw.Cj() > 0) {
            av.c(this.aKs, this.aKw.Cj(), i);
        }
        av.c(this.title, t.d.cp_cont_b, 1);
        av.c(this.aKu, this.aKy, 1);
        this.aKt.setProgressDrawable(av.getDrawable(t.f.vote_progress_drawable));
        if (this.aKw != null) {
            if (this.aKw.isSelected()) {
                av.l(this.aKv, t.d.common_color_10271);
            } else {
                av.l(this.aKv, t.d.common_color_10272);
            }
        }
    }
}
