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
    private ImageView aEn;
    private ProgressBar aEo;
    private TextView aEp;
    private View aEq;
    private a aEr;
    private TextView agd;
    private View parent;

    public c(Context context) {
        this.parent = LayoutInflater.from(context).inflate(n.g.ballot_item_view, (ViewGroup) null);
        this.aEn = (ImageView) this.parent.findViewById(n.f.ballot_item_image);
        this.agd = (TextView) this.parent.findViewById(n.f.ballot_item_title);
        this.aEo = (ProgressBar) this.parent.findViewById(n.f.ballot_item_progress);
        this.aEp = (TextView) this.parent.findViewById(n.f.ballot_item_percents);
        this.aEq = this.parent.findViewById(n.f.ballot_item_preffix_progress);
        onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
    }

    public void eY(int i) {
        if (i >= 0) {
            if (this.aEr != null) {
                int Gy = this.aEr.Gy();
                i = ((Gy <= 100 ? Gy : 100) * i) / 100;
            }
            ViewGroup.LayoutParams layoutParams = this.aEo.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(i, TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(n.d.ds28));
            } else {
                layoutParams.width = i;
            }
            this.aEo.setLayoutParams(layoutParams);
        }
    }

    public int a(a aVar) {
        int intrinsicWidth;
        String string;
        this.aEr = aVar;
        if (aVar == null) {
            return 0;
        }
        if (aVar.Gx() <= 0) {
            this.aEn.setImageDrawable(null);
            this.aEn.setVisibility(8);
            intrinsicWidth = 0;
        } else {
            Drawable drawable = as.getDrawable(aVar.Gx());
            this.aEn.setImageDrawable(drawable);
            intrinsicWidth = drawable.getIntrinsicWidth() + this.parent.getResources().getDimensionPixelSize(n.d.ds24);
            this.aEn.setVisibility(0);
        }
        if (StringUtils.isNull(aVar.Gu())) {
            this.agd.setText((CharSequence) null);
            this.agd.setVisibility(8);
        } else {
            this.agd.setText(UtilHelper.getFixedText(aVar.Gu(), 15, false));
            this.agd.setVisibility(0);
        }
        if (aVar.isSelected()) {
            as.j(this.aEq, n.c.vote_progress_selected_color);
        } else {
            as.j(this.aEq, n.c.vote_progress_unselected_color);
        }
        boolean isNull = StringUtils.isNull(aVar.Gv());
        boolean isNull2 = StringUtils.isNull(aVar.Gw());
        if (isNull && isNull2) {
            this.aEp.setText((CharSequence) null);
            this.aEp.setVisibility(8);
            string = null;
        } else {
            this.aEp.setVisibility(0);
            if (isNull) {
                string = aVar.Gw();
                this.aEp.setText(string);
            } else if (isNull2) {
                string = aVar.Gv();
                this.aEp.setText(string);
            } else {
                string = TbadkCoreApplication.m411getInst().getString(n.i.vote_number_text, new Object[]{aVar.Gv(), aVar.Gw()});
                this.aEp.setText(string);
            }
        }
        if (!StringUtils.isNull(string)) {
            intrinsicWidth = (int) (intrinsicWidth + this.aEp.getPaint().measureText(string));
        }
        return this.parent.getResources().getDimensionPixelSize(n.d.ds24) + this.parent.getResources().getDimensionPixelSize(n.d.ds10) + 8 + intrinsicWidth;
    }

    public void setProgress(float f) {
        if (f >= 0.0f && this.aEr != null) {
            int i = (int) (100.0f * f);
            if (this.aEr.isSelected()) {
                this.aEo.setProgress(i);
                this.aEo.setSecondaryProgress(0);
                return;
            }
            this.aEo.setProgress(0);
            this.aEo.setSecondaryProgress(i);
        }
    }

    public View getView() {
        return this.parent;
    }

    public void onChangeSkinType(int i) {
        if (this.aEr != null && this.aEr.Gx() > 0) {
            as.b(this.aEn, this.aEr.Gx(), i);
        }
        as.b(this.agd, n.c.cp_cont_b, 1);
        as.b(this.aEp, n.c.cp_cont_c, 1);
        this.aEo.setProgressDrawable(as.getDrawable(n.e.vote_progress_drawable));
        if (this.aEr != null) {
            if (this.aEr.isSelected()) {
                as.j(this.aEq, n.c.vote_progress_selected_color);
            } else {
                as.j(this.aEq, n.c.vote_progress_unselected_color);
            }
        }
    }
}
