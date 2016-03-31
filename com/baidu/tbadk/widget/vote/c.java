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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class c {
    private View aJB;
    private ImageView aJC;
    private ProgressBar aJD;
    private TextView aJE;
    private View aJF;
    private a aJG;
    private TextView apE;

    public c(Context context) {
        this.aJB = LayoutInflater.from(context).inflate(t.h.ballot_item_view, (ViewGroup) null);
        this.aJC = (ImageView) this.aJB.findViewById(t.g.ballot_item_image);
        this.apE = (TextView) this.aJB.findViewById(t.g.ballot_item_title);
        this.aJD = (ProgressBar) this.aJB.findViewById(t.g.ballot_item_progress);
        this.aJE = (TextView) this.aJB.findViewById(t.g.ballot_item_percents);
        this.aJF = this.aJB.findViewById(t.g.ballot_item_preffix_progress);
        onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
    }

    public void fB(int i) {
        if (i >= 0) {
            if (this.aJG != null) {
                int Ji = this.aJG.Ji();
                i = ((Ji <= 100 ? Ji : 100) * i) / 100;
            }
            ViewGroup.LayoutParams layoutParams = this.aJD.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(i, TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(t.e.ds28));
            } else {
                layoutParams.width = i;
            }
            this.aJD.setLayoutParams(layoutParams);
        }
    }

    public int a(a aVar) {
        int intrinsicWidth;
        String string;
        this.aJG = aVar;
        if (aVar == null) {
            return 0;
        }
        if (aVar.Jh() <= 0) {
            this.aJC.setImageDrawable(null);
            this.aJC.setVisibility(8);
            intrinsicWidth = 0;
        } else {
            Drawable drawable = at.getDrawable(aVar.Jh());
            this.aJC.setImageDrawable(drawable);
            intrinsicWidth = drawable.getIntrinsicWidth() + this.aJB.getResources().getDimensionPixelSize(t.e.ds24);
            this.aJC.setVisibility(0);
        }
        if (StringUtils.isNull(aVar.Je())) {
            this.apE.setText((CharSequence) null);
            this.apE.setVisibility(8);
        } else {
            this.apE.setText(UtilHelper.getFixedText(aVar.Je(), 15, false));
            this.apE.setVisibility(0);
        }
        if (aVar.isSelected()) {
            at.l(this.aJF, t.d.vote_progress_selected_color);
        } else {
            at.l(this.aJF, t.d.vote_progress_unselected_color);
        }
        boolean isNull = StringUtils.isNull(aVar.Jf());
        boolean isNull2 = StringUtils.isNull(aVar.Jg());
        if (isNull && isNull2) {
            this.aJE.setText((CharSequence) null);
            this.aJE.setVisibility(8);
            string = null;
        } else {
            this.aJE.setVisibility(0);
            if (isNull) {
                string = aVar.Jg();
                this.aJE.setText(string);
            } else if (isNull2) {
                string = aVar.Jf();
                this.aJE.setText(string);
            } else {
                string = TbadkCoreApplication.m411getInst().getString(t.j.vote_number_text, new Object[]{aVar.Jf(), aVar.Jg()});
                this.aJE.setText(string);
            }
        }
        if (!StringUtils.isNull(string)) {
            intrinsicWidth = (int) (intrinsicWidth + this.aJE.getPaint().measureText(string));
        }
        return this.aJB.getResources().getDimensionPixelSize(t.e.ds24) + this.aJB.getResources().getDimensionPixelSize(t.e.ds10) + 8 + intrinsicWidth;
    }

    public void setProgress(float f) {
        if (f >= 0.0f && this.aJG != null) {
            int i = (int) (100.0f * f);
            if (this.aJG.isSelected()) {
                this.aJD.setProgress(i);
                this.aJD.setSecondaryProgress(0);
                return;
            }
            this.aJD.setProgress(0);
            this.aJD.setSecondaryProgress(i);
        }
    }

    public View getView() {
        return this.aJB;
    }

    public void onChangeSkinType(int i) {
        if (this.aJG != null && this.aJG.Jh() > 0) {
            at.b(this.aJC, this.aJG.Jh(), i);
        }
        at.b(this.apE, t.d.cp_cont_b, 1);
        at.b(this.aJE, t.d.cp_cont_c, 1);
        this.aJD.setProgressDrawable(at.getDrawable(t.f.vote_progress_drawable));
        if (this.aJG != null) {
            if (this.aJG.isSelected()) {
                at.l(this.aJF, t.d.vote_progress_selected_color);
            } else {
                at.l(this.aJF, t.d.vote_progress_unselected_color);
            }
        }
    }
}
