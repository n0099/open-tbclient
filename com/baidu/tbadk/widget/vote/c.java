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
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class c {
    private View aHb;
    private ImageView aHc;
    private ProgressBar aHd;
    private TextView aHe;
    private View aHf;
    private a aHg;
    private int aHh;
    private int aHi;
    private TextView title;

    public c(Context context) {
        this(context, u.d.cp_cont_c);
    }

    public c(Context context, int i) {
        this.aHb = LayoutInflater.from(context).inflate(u.h.ballot_item_view, (ViewGroup) null);
        this.aHc = (ImageView) this.aHb.findViewById(u.g.ballot_item_image);
        this.title = (TextView) this.aHb.findViewById(u.g.ballot_item_title);
        this.aHd = (ProgressBar) this.aHb.findViewById(u.g.ballot_item_progress);
        this.aHe = (TextView) this.aHb.findViewById(u.g.ballot_item_percents);
        this.aHf = this.aHb.findViewById(u.g.ballot_item_preffix_progress);
        this.aHh = k.c(context, u.e.ds28);
        this.aHi = i;
        onChangeSkinType(TbadkCoreApplication.m10getInst().getSkinType());
    }

    public void setProgressBarHeight(int i) {
        this.aHh = i;
        this.aHd.getLayoutParams().height = this.aHh;
        this.aHf.getLayoutParams().height = this.aHh;
    }

    public void setProgressBarTopMargin(int i) {
        if (this.aHd.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.aHd.getLayoutParams()).topMargin = i;
        }
        if (this.aHf.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.aHf.getLayoutParams()).topMargin = i;
        }
    }

    public void setDescTopMargin(int i) {
        if (this.aHe.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.aHe.getLayoutParams()).topMargin = i;
        }
    }

    public void fl(int i) {
        if (i >= 0) {
            if (this.aHg != null) {
                int Hz = this.aHg.Hz();
                i = ((Hz <= 100 ? Hz : 100) * i) / 100;
            }
            ViewGroup.LayoutParams layoutParams = this.aHd.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(i, this.aHh);
            } else {
                layoutParams.width = i;
            }
            this.aHd.setLayoutParams(layoutParams);
        }
    }

    public int a(a aVar) {
        int intrinsicWidth;
        String string;
        this.aHg = aVar;
        if (aVar == null) {
            return 0;
        }
        if (aVar.Hy() <= 0) {
            this.aHc.setImageDrawable(null);
            this.aHc.setVisibility(8);
            intrinsicWidth = 0;
        } else {
            Drawable drawable = av.getDrawable(aVar.Hy());
            this.aHc.setImageDrawable(drawable);
            intrinsicWidth = drawable.getIntrinsicWidth() + this.aHb.getResources().getDimensionPixelSize(u.e.ds24);
            this.aHc.setVisibility(0);
        }
        if (StringUtils.isNull(aVar.Hv())) {
            this.title.setText((CharSequence) null);
            this.title.setVisibility(8);
        } else {
            this.title.setText(UtilHelper.getFixedText(aVar.Hv(), 15, false));
            this.title.setVisibility(0);
        }
        if (aVar.isSelected()) {
            av.l(this.aHf, u.d.common_color_10271);
        } else {
            av.l(this.aHf, u.d.common_color_10272);
        }
        boolean isNull = StringUtils.isNull(aVar.Hw());
        boolean isNull2 = StringUtils.isNull(aVar.Hx());
        if (isNull && isNull2) {
            this.aHe.setText((CharSequence) null);
            this.aHe.setVisibility(8);
            string = null;
        } else {
            this.aHe.setVisibility(0);
            if (isNull) {
                string = aVar.Hx();
                this.aHe.setText(string);
            } else if (isNull2) {
                string = aVar.Hw();
                this.aHe.setText(string);
            } else {
                string = TbadkCoreApplication.m10getInst().getString(u.j.vote_number_text, new Object[]{aVar.Hw(), aVar.Hx()});
                this.aHe.setText(string);
            }
        }
        if (!StringUtils.isNull(string)) {
            intrinsicWidth = (int) (intrinsicWidth + this.aHe.getPaint().measureText(string));
        }
        return this.aHb.getResources().getDimensionPixelSize(u.e.ds24) + this.aHb.getResources().getDimensionPixelSize(u.e.ds10) + 8 + intrinsicWidth;
    }

    public void setProgress(float f) {
        if (f >= 0.0f && this.aHg != null) {
            int i = (int) (100.0f * f);
            if (this.aHg.isSelected()) {
                this.aHd.setProgress(i);
                this.aHd.setSecondaryProgress(0);
                return;
            }
            this.aHd.setProgress(0);
            this.aHd.setSecondaryProgress(i);
        }
    }

    public View getView() {
        return this.aHb;
    }

    public void onChangeSkinType(int i) {
        if (this.aHg != null && this.aHg.Hy() > 0) {
            av.c(this.aHc, this.aHg.Hy(), i);
        }
        av.c(this.title, u.d.cp_cont_b, 1);
        av.c(this.aHe, this.aHi, 1);
        this.aHd.setProgressDrawable(av.getDrawable(u.f.vote_progress_drawable));
        if (this.aHg != null) {
            if (this.aHg.isSelected()) {
                av.l(this.aHf, u.d.common_color_10271);
            } else {
                av.l(this.aHf, u.d.common_color_10272);
            }
        }
    }
}
