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
    private ImageView aCH;
    private ProgressBar aCI;
    private TextView aCJ;
    private View aCK;
    private a aCL;
    private TextView alu;
    private View parent;

    public c(Context context) {
        this.parent = LayoutInflater.from(context).inflate(i.g.ballot_item_view, (ViewGroup) null);
        this.aCH = (ImageView) this.parent.findViewById(i.f.ballot_item_image);
        this.alu = (TextView) this.parent.findViewById(i.f.ballot_item_title);
        this.aCI = (ProgressBar) this.parent.findViewById(i.f.ballot_item_progress);
        this.aCJ = (TextView) this.parent.findViewById(i.f.ballot_item_percents);
        this.aCK = this.parent.findViewById(i.f.ballot_item_preffix_progress);
        onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
    }

    public void eL(int i) {
        if (i >= 0) {
            if (this.aCL != null) {
                int Fw = this.aCL.Fw();
                i = ((Fw <= 100 ? Fw : 100) * i) / 100;
            }
            ViewGroup.LayoutParams layoutParams = this.aCI.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(i, TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(i.d.ds28));
            } else {
                layoutParams.width = i;
            }
            this.aCI.setLayoutParams(layoutParams);
        }
    }

    public int a(a aVar) {
        int intrinsicWidth;
        String string;
        this.aCL = aVar;
        if (aVar == null) {
            return 0;
        }
        if (aVar.Fv() <= 0) {
            this.aCH.setImageDrawable(null);
            this.aCH.setVisibility(8);
            intrinsicWidth = 0;
        } else {
            Drawable drawable = an.getDrawable(aVar.Fv());
            this.aCH.setImageDrawable(drawable);
            intrinsicWidth = drawable.getIntrinsicWidth() + this.parent.getResources().getDimensionPixelSize(i.d.ds24);
            this.aCH.setVisibility(0);
        }
        if (StringUtils.isNull(aVar.Fs())) {
            this.alu.setText((CharSequence) null);
            this.alu.setVisibility(8);
        } else {
            this.alu.setText(UtilHelper.getFixedText(aVar.Fs(), 15, false));
            this.alu.setVisibility(0);
        }
        if (aVar.isSelected()) {
            an.j(this.aCK, i.c.vote_progress_selected_color);
        } else {
            an.j(this.aCK, i.c.vote_progress_unselected_color);
        }
        boolean isNull = StringUtils.isNull(aVar.Ft());
        boolean isNull2 = StringUtils.isNull(aVar.Fu());
        if (isNull && isNull2) {
            this.aCJ.setText((CharSequence) null);
            this.aCJ.setVisibility(8);
            string = null;
        } else {
            this.aCJ.setVisibility(0);
            if (isNull) {
                string = aVar.Fu();
                this.aCJ.setText(string);
            } else if (isNull2) {
                string = aVar.Ft();
                this.aCJ.setText(string);
            } else {
                string = TbadkCoreApplication.m411getInst().getString(i.h.vote_number_text, new Object[]{aVar.Ft(), aVar.Fu()});
                this.aCJ.setText(string);
            }
        }
        if (!StringUtils.isNull(string)) {
            intrinsicWidth = (int) (intrinsicWidth + this.aCJ.getPaint().measureText(string));
        }
        return this.parent.getResources().getDimensionPixelSize(i.d.ds24) + this.parent.getResources().getDimensionPixelSize(i.d.ds10) + 8 + intrinsicWidth;
    }

    public void setProgress(float f) {
        if (f >= 0.0f && this.aCL != null) {
            int i = (int) (100.0f * f);
            if (this.aCL.isSelected()) {
                this.aCI.setProgress(i);
                this.aCI.setSecondaryProgress(0);
                return;
            }
            this.aCI.setProgress(0);
            this.aCI.setSecondaryProgress(i);
        }
    }

    public View getView() {
        return this.parent;
    }

    public void onChangeSkinType(int i) {
        if (this.aCL != null && this.aCL.Fv() > 0) {
            an.b(this.aCH, this.aCL.Fv(), i);
        }
        an.b(this.alu, i.c.cp_cont_b, 1);
        an.b(this.aCJ, i.c.cp_cont_c, 1);
        this.aCI.setProgressDrawable(an.x(i, i.e.vote_progress_drawable));
        if (this.aCL != null) {
            if (this.aCL.isSelected()) {
                an.j(this.aCK, i.c.vote_progress_selected_color);
            } else {
                an.j(this.aCK, i.c.vote_progress_unselected_color);
            }
        }
    }
}
