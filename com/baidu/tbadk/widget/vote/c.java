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
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class c {
    private a aCA;
    private ImageView aCw;
    private ProgressBar aCx;
    private TextView aCy;
    private View aCz;
    private TextView alt;
    private View parent;

    public c(Context context) {
        this.parent = LayoutInflater.from(context).inflate(i.g.ballot_item_view, (ViewGroup) null);
        this.aCw = (ImageView) this.parent.findViewById(i.f.ballot_item_image);
        this.alt = (TextView) this.parent.findViewById(i.f.ballot_item_title);
        this.aCx = (ProgressBar) this.parent.findViewById(i.f.ballot_item_progress);
        this.aCy = (TextView) this.parent.findViewById(i.f.ballot_item_percents);
        this.aCz = this.parent.findViewById(i.f.ballot_item_preffix_progress);
        onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
    }

    public void eL(int i) {
        if (i >= 0) {
            if (this.aCA != null) {
                int FA = this.aCA.FA();
                i = ((FA <= 100 ? FA : 100) * i) / 100;
            }
            ViewGroup.LayoutParams layoutParams = this.aCx.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(i, TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(i.d.ds28));
            } else {
                layoutParams.width = i;
            }
            this.aCx.setLayoutParams(layoutParams);
        }
    }

    public int a(a aVar) {
        int intrinsicWidth;
        String string;
        this.aCA = aVar;
        if (aVar == null) {
            return 0;
        }
        if (aVar.Fz() <= 0) {
            this.aCw.setImageDrawable(null);
            this.aCw.setVisibility(8);
            intrinsicWidth = 0;
        } else {
            Drawable drawable = am.getDrawable(aVar.Fz());
            this.aCw.setImageDrawable(drawable);
            intrinsicWidth = drawable.getIntrinsicWidth() + this.parent.getResources().getDimensionPixelSize(i.d.ds24);
            this.aCw.setVisibility(0);
        }
        if (StringUtils.isNull(aVar.Fw())) {
            this.alt.setText((CharSequence) null);
            this.alt.setVisibility(8);
        } else {
            this.alt.setText(UtilHelper.getFixedText(aVar.Fw(), 15, false));
            this.alt.setVisibility(0);
        }
        if (aVar.isSelected()) {
            am.j(this.aCz, i.c.vote_progress_selected_color);
        } else {
            am.j(this.aCz, i.c.vote_progress_unselected_color);
        }
        boolean isNull = StringUtils.isNull(aVar.Fx());
        boolean isNull2 = StringUtils.isNull(aVar.Fy());
        if (isNull && isNull2) {
            this.aCy.setText((CharSequence) null);
            this.aCy.setVisibility(8);
            string = null;
        } else {
            this.aCy.setVisibility(0);
            if (isNull) {
                string = aVar.Fy();
                this.aCy.setText(string);
            } else if (isNull2) {
                string = aVar.Fx();
                this.aCy.setText(string);
            } else {
                string = TbadkCoreApplication.m411getInst().getString(i.h.vote_number_text, new Object[]{aVar.Fx(), aVar.Fy()});
                this.aCy.setText(string);
            }
        }
        if (!StringUtils.isNull(string)) {
            intrinsicWidth = (int) (intrinsicWidth + this.aCy.getPaint().measureText(string));
        }
        return this.parent.getResources().getDimensionPixelSize(i.d.ds24) + this.parent.getResources().getDimensionPixelSize(i.d.ds10) + 8 + intrinsicWidth;
    }

    public void setProgress(float f) {
        if (f >= 0.0f && this.aCA != null) {
            int i = (int) (100.0f * f);
            if (this.aCA.isSelected()) {
                this.aCx.setProgress(i);
                this.aCx.setSecondaryProgress(0);
                return;
            }
            this.aCx.setProgress(0);
            this.aCx.setSecondaryProgress(i);
        }
    }

    public View getView() {
        return this.parent;
    }

    public void onChangeSkinType(int i) {
        if (this.aCA != null && this.aCA.Fz() > 0) {
            am.b(this.aCw, this.aCA.Fz(), i);
        }
        am.b(this.alt, i.c.cp_cont_b, 1);
        am.b(this.aCy, i.c.cp_cont_c, 1);
        this.aCx.setProgressDrawable(am.x(i, i.e.vote_progress_drawable));
        if (this.aCA != null) {
            if (this.aCA.isSelected()) {
                am.j(this.aCz, i.c.vote_progress_selected_color);
            } else {
                am.j(this.aCz, i.c.vote_progress_unselected_color);
            }
        }
    }
}
