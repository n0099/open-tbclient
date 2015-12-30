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
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class c {
    private ImageView aFN;
    private ProgressBar aFO;
    private TextView aFP;
    private View aFQ;
    private a aFR;
    private TextView ahk;
    private View parent;

    public c(Context context) {
        this.parent = LayoutInflater.from(context).inflate(n.h.ballot_item_view, (ViewGroup) null);
        this.aFN = (ImageView) this.parent.findViewById(n.g.ballot_item_image);
        this.ahk = (TextView) this.parent.findViewById(n.g.ballot_item_title);
        this.aFO = (ProgressBar) this.parent.findViewById(n.g.ballot_item_progress);
        this.aFP = (TextView) this.parent.findViewById(n.g.ballot_item_percents);
        this.aFQ = this.parent.findViewById(n.g.ballot_item_preffix_progress);
        onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
    }

    public void eS(int i) {
        if (i >= 0) {
            if (this.aFR != null) {
                int Gn = this.aFR.Gn();
                i = ((Gn <= 100 ? Gn : 100) * i) / 100;
            }
            ViewGroup.LayoutParams layoutParams = this.aFO.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(i, TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(n.e.ds28));
            } else {
                layoutParams.width = i;
            }
            this.aFO.setLayoutParams(layoutParams);
        }
    }

    public int a(a aVar) {
        int intrinsicWidth;
        String string;
        this.aFR = aVar;
        if (aVar == null) {
            return 0;
        }
        if (aVar.Gm() <= 0) {
            this.aFN.setImageDrawable(null);
            this.aFN.setVisibility(8);
            intrinsicWidth = 0;
        } else {
            Drawable drawable = as.getDrawable(aVar.Gm());
            this.aFN.setImageDrawable(drawable);
            intrinsicWidth = drawable.getIntrinsicWidth() + this.parent.getResources().getDimensionPixelSize(n.e.ds24);
            this.aFN.setVisibility(0);
        }
        if (StringUtils.isNull(aVar.Gj())) {
            this.ahk.setText((CharSequence) null);
            this.ahk.setVisibility(8);
        } else {
            this.ahk.setText(UtilHelper.getFixedText(aVar.Gj(), 15, false));
            this.ahk.setVisibility(0);
        }
        if (aVar.isSelected()) {
            as.j(this.aFQ, n.d.vote_progress_selected_color);
        } else {
            as.j(this.aFQ, n.d.vote_progress_unselected_color);
        }
        boolean isNull = StringUtils.isNull(aVar.Gk());
        boolean isNull2 = StringUtils.isNull(aVar.Gl());
        if (isNull && isNull2) {
            this.aFP.setText((CharSequence) null);
            this.aFP.setVisibility(8);
            string = null;
        } else {
            this.aFP.setVisibility(0);
            if (isNull) {
                string = aVar.Gl();
                this.aFP.setText(string);
            } else if (isNull2) {
                string = aVar.Gk();
                this.aFP.setText(string);
            } else {
                string = TbadkCoreApplication.m411getInst().getString(n.j.vote_number_text, new Object[]{aVar.Gk(), aVar.Gl()});
                this.aFP.setText(string);
            }
        }
        if (!StringUtils.isNull(string)) {
            intrinsicWidth = (int) (intrinsicWidth + this.aFP.getPaint().measureText(string));
        }
        return this.parent.getResources().getDimensionPixelSize(n.e.ds24) + this.parent.getResources().getDimensionPixelSize(n.e.ds10) + 8 + intrinsicWidth;
    }

    public void setProgress(float f) {
        if (f >= 0.0f && this.aFR != null) {
            int i = (int) (100.0f * f);
            if (this.aFR.isSelected()) {
                this.aFO.setProgress(i);
                this.aFO.setSecondaryProgress(0);
                return;
            }
            this.aFO.setProgress(0);
            this.aFO.setSecondaryProgress(i);
        }
    }

    public View getView() {
        return this.parent;
    }

    public void onChangeSkinType(int i) {
        if (this.aFR != null && this.aFR.Gm() > 0) {
            as.b(this.aFN, this.aFR.Gm(), i);
        }
        as.b(this.ahk, n.d.cp_cont_b, 1);
        as.b(this.aFP, n.d.cp_cont_c, 1);
        this.aFO.setProgressDrawable(as.getDrawable(n.f.vote_progress_drawable));
        if (this.aFR != null) {
            if (this.aFR.isSelected()) {
                as.j(this.aFQ, n.d.vote_progress_selected_color);
            } else {
                as.j(this.aFQ, n.d.vote_progress_unselected_color);
            }
        }
    }
}
