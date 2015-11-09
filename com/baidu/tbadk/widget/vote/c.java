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
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class c {
    private ImageView aBB;
    private ProgressBar aBC;
    private TextView aBD;
    private View aBE;
    private a aBF;
    private TextView alz;
    private View parent;

    public c(Context context) {
        this.parent = LayoutInflater.from(context).inflate(i.g.ballot_item_view, (ViewGroup) null);
        this.aBB = (ImageView) this.parent.findViewById(i.f.ballot_item_image);
        this.alz = (TextView) this.parent.findViewById(i.f.ballot_item_title);
        this.aBC = (ProgressBar) this.parent.findViewById(i.f.ballot_item_progress);
        this.aBD = (TextView) this.parent.findViewById(i.f.ballot_item_percents);
        this.aBE = this.parent.findViewById(i.f.ballot_item_preffix_progress);
        onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
    }

    public void eL(int i) {
        if (i >= 0) {
            if (this.aBF != null) {
                int Ft = this.aBF.Ft();
                i = ((Ft <= 100 ? Ft : 100) * i) / 100;
            }
            ViewGroup.LayoutParams layoutParams = this.aBC.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(i, TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(i.d.ds28));
            } else {
                layoutParams.width = i;
            }
            this.aBC.setLayoutParams(layoutParams);
        }
    }

    public int a(a aVar) {
        int intrinsicWidth;
        String string;
        this.aBF = aVar;
        if (aVar == null) {
            return 0;
        }
        if (aVar.Fs() <= 0) {
            this.aBB.setImageDrawable(null);
            this.aBB.setVisibility(8);
            intrinsicWidth = 0;
        } else {
            Drawable drawable = an.getDrawable(aVar.Fs());
            this.aBB.setImageDrawable(drawable);
            intrinsicWidth = drawable.getIntrinsicWidth() + this.parent.getResources().getDimensionPixelSize(i.d.ds24);
            this.aBB.setVisibility(0);
        }
        if (StringUtils.isNull(aVar.Fp())) {
            this.alz.setText((CharSequence) null);
            this.alz.setVisibility(8);
        } else {
            this.alz.setText(UtilHelper.getFixedText(aVar.Fp(), 15, false));
            this.alz.setVisibility(0);
        }
        if (aVar.isSelected()) {
            an.j(this.aBE, i.c.vote_progress_selected_color);
        } else {
            an.j(this.aBE, i.c.vote_progress_unselected_color);
        }
        boolean isNull = StringUtils.isNull(aVar.Fq());
        boolean isNull2 = StringUtils.isNull(aVar.Fr());
        if (isNull && isNull2) {
            this.aBD.setText((CharSequence) null);
            this.aBD.setVisibility(8);
            string = null;
        } else {
            this.aBD.setVisibility(0);
            if (isNull) {
                string = aVar.Fr();
                this.aBD.setText(string);
            } else if (isNull2) {
                string = aVar.Fq();
                this.aBD.setText(string);
            } else {
                string = TbadkCoreApplication.m411getInst().getString(i.h.vote_number_text, new Object[]{aVar.Fq(), aVar.Fr()});
                this.aBD.setText(string);
            }
        }
        if (!StringUtils.isNull(string)) {
            intrinsicWidth = (int) (intrinsicWidth + this.aBD.getPaint().measureText(string));
        }
        return this.parent.getResources().getDimensionPixelSize(i.d.ds24) + this.parent.getResources().getDimensionPixelSize(i.d.ds10) + 8 + intrinsicWidth;
    }

    public void setProgress(float f) {
        if (f >= 0.0f && this.aBF != null) {
            int i = (int) (100.0f * f);
            if (this.aBF.isSelected()) {
                this.aBC.setProgress(i);
                this.aBC.setSecondaryProgress(0);
                return;
            }
            this.aBC.setProgress(0);
            this.aBC.setSecondaryProgress(i);
        }
    }

    public View getView() {
        return this.parent;
    }

    public void onChangeSkinType(int i) {
        if (this.aBF != null && this.aBF.Fs() > 0) {
            an.b(this.aBB, this.aBF.Fs(), i);
        }
        an.b(this.alz, i.c.cp_cont_b, 1);
        an.b(this.aBD, i.c.cp_cont_c, 1);
        this.aBC.setProgressDrawable(an.x(i, i.e.vote_progress_drawable));
        if (this.aBF != null) {
            if (this.aBF.isSelected()) {
                an.j(this.aBE, i.c.vote_progress_selected_color);
            } else {
                an.j(this.aBE, i.c.vote_progress_unselected_color);
            }
        }
    }
}
