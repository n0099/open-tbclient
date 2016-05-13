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
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class c {
    private View aFI;
    private ImageView aFJ;
    private ProgressBar aFK;
    private TextView aFL;
    private View aFM;
    private a aFN;
    private int aFO;
    private int aFP;
    private TextView title;

    public c(Context context) {
        this(context, t.d.cp_cont_c);
    }

    public c(Context context, int i) {
        this.aFI = LayoutInflater.from(context).inflate(t.h.ballot_item_view, (ViewGroup) null);
        this.aFJ = (ImageView) this.aFI.findViewById(t.g.ballot_item_image);
        this.title = (TextView) this.aFI.findViewById(t.g.ballot_item_title);
        this.aFK = (ProgressBar) this.aFI.findViewById(t.g.ballot_item_progress);
        this.aFL = (TextView) this.aFI.findViewById(t.g.ballot_item_percents);
        this.aFM = this.aFI.findViewById(t.g.ballot_item_preffix_progress);
        this.aFO = k.c(context, t.e.ds28);
        this.aFP = i;
        onChangeSkinType(TbadkCoreApplication.m11getInst().getSkinType());
    }

    public void setProgressBarHeight(int i) {
        this.aFO = i;
        this.aFK.getLayoutParams().height = this.aFO;
        this.aFM.getLayoutParams().height = this.aFO;
    }

    public void setProgressBarTopMargin(int i) {
        if (this.aFK.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.aFK.getLayoutParams()).topMargin = i;
        }
        if (this.aFM.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.aFM.getLayoutParams()).topMargin = i;
        }
    }

    public void setDescTopMargin(int i) {
        if (this.aFL.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.aFL.getLayoutParams()).topMargin = i;
        }
    }

    public void fg(int i) {
        if (i >= 0) {
            if (this.aFN != null) {
                int HA = this.aFN.HA();
                i = ((HA <= 100 ? HA : 100) * i) / 100;
            }
            ViewGroup.LayoutParams layoutParams = this.aFK.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(i, this.aFO);
            } else {
                layoutParams.width = i;
            }
            this.aFK.setLayoutParams(layoutParams);
        }
    }

    public int a(a aVar) {
        int intrinsicWidth;
        String string;
        this.aFN = aVar;
        if (aVar == null) {
            return 0;
        }
        if (aVar.Hz() <= 0) {
            this.aFJ.setImageDrawable(null);
            this.aFJ.setVisibility(8);
            intrinsicWidth = 0;
        } else {
            Drawable drawable = at.getDrawable(aVar.Hz());
            this.aFJ.setImageDrawable(drawable);
            intrinsicWidth = drawable.getIntrinsicWidth() + this.aFI.getResources().getDimensionPixelSize(t.e.ds24);
            this.aFJ.setVisibility(0);
        }
        if (StringUtils.isNull(aVar.Hw())) {
            this.title.setText((CharSequence) null);
            this.title.setVisibility(8);
        } else {
            this.title.setText(UtilHelper.getFixedText(aVar.Hw(), 15, false));
            this.title.setVisibility(0);
        }
        if (aVar.isSelected()) {
            at.l(this.aFM, t.d.vote_progress_selected_color);
        } else {
            at.l(this.aFM, t.d.vote_progress_unselected_color);
        }
        boolean isNull = StringUtils.isNull(aVar.Hx());
        boolean isNull2 = StringUtils.isNull(aVar.Hy());
        if (isNull && isNull2) {
            this.aFL.setText((CharSequence) null);
            this.aFL.setVisibility(8);
            string = null;
        } else {
            this.aFL.setVisibility(0);
            if (isNull) {
                string = aVar.Hy();
                this.aFL.setText(string);
            } else if (isNull2) {
                string = aVar.Hx();
                this.aFL.setText(string);
            } else {
                string = TbadkCoreApplication.m11getInst().getString(t.j.vote_number_text, new Object[]{aVar.Hx(), aVar.Hy()});
                this.aFL.setText(string);
            }
        }
        if (!StringUtils.isNull(string)) {
            intrinsicWidth = (int) (intrinsicWidth + this.aFL.getPaint().measureText(string));
        }
        return this.aFI.getResources().getDimensionPixelSize(t.e.ds24) + this.aFI.getResources().getDimensionPixelSize(t.e.ds10) + 8 + intrinsicWidth;
    }

    public void setProgress(float f) {
        if (f >= 0.0f && this.aFN != null) {
            int i = (int) (100.0f * f);
            if (this.aFN.isSelected()) {
                this.aFK.setProgress(i);
                this.aFK.setSecondaryProgress(0);
                return;
            }
            this.aFK.setProgress(0);
            this.aFK.setSecondaryProgress(i);
        }
    }

    public View getView() {
        return this.aFI;
    }

    public void onChangeSkinType(int i) {
        if (this.aFN != null && this.aFN.Hz() > 0) {
            at.b(this.aFJ, this.aFN.Hz(), i);
        }
        at.c(this.title, t.d.cp_cont_b, 1);
        at.c(this.aFL, this.aFP, 1);
        this.aFK.setProgressDrawable(at.getDrawable(t.f.vote_progress_drawable));
        if (this.aFN != null) {
            if (this.aFN.isSelected()) {
                at.l(this.aFM, t.d.vote_progress_selected_color);
            } else {
                at.l(this.aFM, t.d.vote_progress_unselected_color);
            }
        }
    }
}
