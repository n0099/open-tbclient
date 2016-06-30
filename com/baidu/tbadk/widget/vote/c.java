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
    private View aGk;
    private ImageView aGl;
    private ProgressBar aGm;
    private TextView aGn;
    private View aGo;
    private a aGp;
    private int aGq;
    private int aGr;
    private TextView title;

    public c(Context context) {
        this(context, u.d.cp_cont_c);
    }

    public c(Context context, int i) {
        this.aGk = LayoutInflater.from(context).inflate(u.h.ballot_item_view, (ViewGroup) null);
        this.aGl = (ImageView) this.aGk.findViewById(u.g.ballot_item_image);
        this.title = (TextView) this.aGk.findViewById(u.g.ballot_item_title);
        this.aGm = (ProgressBar) this.aGk.findViewById(u.g.ballot_item_progress);
        this.aGn = (TextView) this.aGk.findViewById(u.g.ballot_item_percents);
        this.aGo = this.aGk.findViewById(u.g.ballot_item_preffix_progress);
        this.aGq = k.c(context, u.e.ds28);
        this.aGr = i;
        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
    }

    public void setProgressBarHeight(int i) {
        this.aGq = i;
        this.aGm.getLayoutParams().height = this.aGq;
        this.aGo.getLayoutParams().height = this.aGq;
    }

    public void setProgressBarTopMargin(int i) {
        if (this.aGm.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.aGm.getLayoutParams()).topMargin = i;
        }
        if (this.aGo.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.aGo.getLayoutParams()).topMargin = i;
        }
    }

    public void setDescTopMargin(int i) {
        if (this.aGn.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.aGn.getLayoutParams()).topMargin = i;
        }
    }

    public void fm(int i) {
        if (i >= 0) {
            if (this.aGp != null) {
                int HB = this.aGp.HB();
                i = ((HB <= 100 ? HB : 100) * i) / 100;
            }
            ViewGroup.LayoutParams layoutParams = this.aGm.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(i, this.aGq);
            } else {
                layoutParams.width = i;
            }
            this.aGm.setLayoutParams(layoutParams);
        }
    }

    public int a(a aVar) {
        int intrinsicWidth;
        String string;
        this.aGp = aVar;
        if (aVar == null) {
            return 0;
        }
        if (aVar.HA() <= 0) {
            this.aGl.setImageDrawable(null);
            this.aGl.setVisibility(8);
            intrinsicWidth = 0;
        } else {
            Drawable drawable = av.getDrawable(aVar.HA());
            this.aGl.setImageDrawable(drawable);
            intrinsicWidth = drawable.getIntrinsicWidth() + this.aGk.getResources().getDimensionPixelSize(u.e.ds24);
            this.aGl.setVisibility(0);
        }
        if (StringUtils.isNull(aVar.Hx())) {
            this.title.setText((CharSequence) null);
            this.title.setVisibility(8);
        } else {
            this.title.setText(UtilHelper.getFixedText(aVar.Hx(), 15, false));
            this.title.setVisibility(0);
        }
        if (aVar.isSelected()) {
            av.l(this.aGo, u.d.common_color_10271);
        } else {
            av.l(this.aGo, u.d.common_color_10272);
        }
        boolean isNull = StringUtils.isNull(aVar.Hy());
        boolean isNull2 = StringUtils.isNull(aVar.Hz());
        if (isNull && isNull2) {
            this.aGn.setText((CharSequence) null);
            this.aGn.setVisibility(8);
            string = null;
        } else {
            this.aGn.setVisibility(0);
            if (isNull) {
                string = aVar.Hz();
                this.aGn.setText(string);
            } else if (isNull2) {
                string = aVar.Hy();
                this.aGn.setText(string);
            } else {
                string = TbadkCoreApplication.m9getInst().getString(u.j.vote_number_text, new Object[]{aVar.Hy(), aVar.Hz()});
                this.aGn.setText(string);
            }
        }
        if (!StringUtils.isNull(string)) {
            intrinsicWidth = (int) (intrinsicWidth + this.aGn.getPaint().measureText(string));
        }
        return this.aGk.getResources().getDimensionPixelSize(u.e.ds24) + this.aGk.getResources().getDimensionPixelSize(u.e.ds10) + 8 + intrinsicWidth;
    }

    public void setProgress(float f) {
        if (f >= 0.0f && this.aGp != null) {
            int i = (int) (100.0f * f);
            if (this.aGp.isSelected()) {
                this.aGm.setProgress(i);
                this.aGm.setSecondaryProgress(0);
                return;
            }
            this.aGm.setProgress(0);
            this.aGm.setSecondaryProgress(i);
        }
    }

    public View getView() {
        return this.aGk;
    }

    public void onChangeSkinType(int i) {
        if (this.aGp != null && this.aGp.HA() > 0) {
            av.b(this.aGl, this.aGp.HA(), i);
        }
        av.c(this.title, u.d.cp_cont_b, 1);
        av.c(this.aGn, this.aGr, 1);
        this.aGm.setProgressDrawable(av.getDrawable(u.f.vote_progress_drawable));
        if (this.aGp != null) {
            if (this.aGp.isSelected()) {
                av.l(this.aGo, u.d.common_color_10271);
            } else {
                av.l(this.aGo, u.d.common_color_10272);
            }
        }
    }
}
