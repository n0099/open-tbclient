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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class c {
    private View aGF;
    private ImageView aGG;
    private ProgressBar aGH;
    private TextView aGI;
    private View aGJ;
    private a aGK;
    private TextView apm;

    public c(Context context) {
        this.aGF = LayoutInflater.from(context).inflate(t.h.ballot_item_view, (ViewGroup) null);
        this.aGG = (ImageView) this.aGF.findViewById(t.g.ballot_item_image);
        this.apm = (TextView) this.aGF.findViewById(t.g.ballot_item_title);
        this.aGH = (ProgressBar) this.aGF.findViewById(t.g.ballot_item_progress);
        this.aGI = (TextView) this.aGF.findViewById(t.g.ballot_item_percents);
        this.aGJ = this.aGF.findViewById(t.g.ballot_item_preffix_progress);
        onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
    }

    public void fo(int i) {
        if (i >= 0) {
            if (this.aGK != null) {
                int HM = this.aGK.HM();
                i = ((HM <= 100 ? HM : 100) * i) / 100;
            }
            ViewGroup.LayoutParams layoutParams = this.aGH.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(i, TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(t.e.ds28));
            } else {
                layoutParams.width = i;
            }
            this.aGH.setLayoutParams(layoutParams);
        }
    }

    public int a(a aVar) {
        int intrinsicWidth;
        String string;
        this.aGK = aVar;
        if (aVar == null) {
            return 0;
        }
        if (aVar.HL() <= 0) {
            this.aGG.setImageDrawable(null);
            this.aGG.setVisibility(8);
            intrinsicWidth = 0;
        } else {
            Drawable drawable = ar.getDrawable(aVar.HL());
            this.aGG.setImageDrawable(drawable);
            intrinsicWidth = drawable.getIntrinsicWidth() + this.aGF.getResources().getDimensionPixelSize(t.e.ds24);
            this.aGG.setVisibility(0);
        }
        if (StringUtils.isNull(aVar.HI())) {
            this.apm.setText((CharSequence) null);
            this.apm.setVisibility(8);
        } else {
            this.apm.setText(UtilHelper.getFixedText(aVar.HI(), 15, false));
            this.apm.setVisibility(0);
        }
        if (aVar.isSelected()) {
            ar.l(this.aGJ, t.d.vote_progress_selected_color);
        } else {
            ar.l(this.aGJ, t.d.vote_progress_unselected_color);
        }
        boolean isNull = StringUtils.isNull(aVar.HJ());
        boolean isNull2 = StringUtils.isNull(aVar.HK());
        if (isNull && isNull2) {
            this.aGI.setText((CharSequence) null);
            this.aGI.setVisibility(8);
            string = null;
        } else {
            this.aGI.setVisibility(0);
            if (isNull) {
                string = aVar.HK();
                this.aGI.setText(string);
            } else if (isNull2) {
                string = aVar.HJ();
                this.aGI.setText(string);
            } else {
                string = TbadkCoreApplication.m411getInst().getString(t.j.vote_number_text, new Object[]{aVar.HJ(), aVar.HK()});
                this.aGI.setText(string);
            }
        }
        if (!StringUtils.isNull(string)) {
            intrinsicWidth = (int) (intrinsicWidth + this.aGI.getPaint().measureText(string));
        }
        return this.aGF.getResources().getDimensionPixelSize(t.e.ds24) + this.aGF.getResources().getDimensionPixelSize(t.e.ds10) + 8 + intrinsicWidth;
    }

    public void setProgress(float f) {
        if (f >= 0.0f && this.aGK != null) {
            int i = (int) (100.0f * f);
            if (this.aGK.isSelected()) {
                this.aGH.setProgress(i);
                this.aGH.setSecondaryProgress(0);
                return;
            }
            this.aGH.setProgress(0);
            this.aGH.setSecondaryProgress(i);
        }
    }

    public View getView() {
        return this.aGF;
    }

    public void onChangeSkinType(int i) {
        if (this.aGK != null && this.aGK.HL() > 0) {
            ar.b(this.aGG, this.aGK.HL(), i);
        }
        ar.b(this.apm, t.d.cp_cont_b, 1);
        ar.b(this.aGI, t.d.cp_cont_c, 1);
        this.aGH.setProgressDrawable(ar.getDrawable(t.f.vote_progress_drawable));
        if (this.aGK != null) {
            if (this.aGK.isSelected()) {
                ar.l(this.aGJ, t.d.vote_progress_selected_color);
            } else {
                ar.l(this.aGJ, t.d.vote_progress_unselected_color);
            }
        }
    }
}
