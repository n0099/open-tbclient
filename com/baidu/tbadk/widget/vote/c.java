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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class c {
    private View aIH;
    private ImageView aII;
    private ProgressBar aIJ;
    private TextView aIK;
    private View aIL;
    private a aIM;
    private int aIN;
    private int aIO;
    private TextView apd;

    public c(Context context) {
        this(context, r.e.cp_cont_b);
    }

    public c(Context context, int i) {
        this.aIH = LayoutInflater.from(context).inflate(r.j.ballot_item_view, (ViewGroup) null);
        this.aII = (ImageView) this.aIH.findViewById(r.h.ballot_item_image);
        this.apd = (TextView) this.aIH.findViewById(r.h.ballot_item_title);
        this.aIJ = (ProgressBar) this.aIH.findViewById(r.h.ballot_item_progress);
        this.aIK = (TextView) this.aIH.findViewById(r.h.ballot_item_percents);
        this.aIL = this.aIH.findViewById(r.h.ballot_item_preffix_progress);
        this.aIN = k.e(context, r.f.ds28);
        this.aIO = i;
        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
    }

    public void setProgressBarHeight(int i) {
        this.aIN = i;
        this.aIJ.getLayoutParams().height = this.aIN;
        this.aIL.getLayoutParams().height = this.aIN;
    }

    public void setProgressBarTopMargin(int i) {
        if (this.aIJ.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.aIJ.getLayoutParams()).topMargin = i;
        }
        if (this.aIL.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.aIL.getLayoutParams()).topMargin = i;
        }
    }

    public void setDescTopMargin(int i) {
        if (this.aIK.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.aIK.getLayoutParams()).topMargin = i;
        }
    }

    public void fD(int i) {
        if (i >= 0) {
            if (this.aIM != null) {
                int Ce = this.aIM.Ce();
                i = ((Ce <= 100 ? Ce : 100) * i) / 100;
            }
            ViewGroup.LayoutParams layoutParams = this.aIJ.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(i, this.aIN);
            } else {
                layoutParams.width = i;
            }
            this.aIJ.setLayoutParams(layoutParams);
        }
    }

    public int a(a aVar) {
        int intrinsicWidth;
        String string;
        this.aIM = aVar;
        if (aVar == null) {
            return 0;
        }
        if (aVar.Cd() <= 0) {
            this.aII.setImageDrawable(null);
            this.aII.setVisibility(8);
            intrinsicWidth = 0;
        } else {
            Drawable drawable = ap.getDrawable(aVar.Cd());
            this.aII.setImageDrawable(drawable);
            intrinsicWidth = drawable.getIntrinsicWidth() + this.aIH.getResources().getDimensionPixelSize(r.f.ds24);
            this.aII.setVisibility(0);
        }
        if (StringUtils.isNull(aVar.Ca())) {
            this.apd.setText((CharSequence) null);
            this.apd.setVisibility(8);
        } else {
            this.apd.setText(UtilHelper.getFixedText(aVar.Ca(), 15, false));
            this.apd.setVisibility(0);
        }
        if (aVar.isSelected()) {
            ap.k(this.aIL, r.e.common_color_10271);
        } else {
            ap.k(this.aIL, r.e.common_color_10272);
        }
        boolean isNull = StringUtils.isNull(aVar.Cb());
        boolean isNull2 = StringUtils.isNull(aVar.Cc());
        if (isNull && isNull2) {
            this.aIK.setText((CharSequence) null);
            this.aIK.setVisibility(8);
            string = null;
        } else {
            this.aIK.setVisibility(0);
            if (isNull) {
                string = aVar.Cc();
                this.aIK.setText(string);
            } else if (isNull2) {
                string = aVar.Cb();
                this.aIK.setText(string);
            } else {
                string = TbadkCoreApplication.m9getInst().getString(r.l.vote_number_text, new Object[]{aVar.Cb(), aVar.Cc()});
                this.aIK.setText(string);
            }
        }
        if (!StringUtils.isNull(string)) {
            intrinsicWidth = (int) (intrinsicWidth + this.aIK.getPaint().measureText(string));
        }
        return this.aIH.getResources().getDimensionPixelSize(r.f.ds24) + this.aIH.getResources().getDimensionPixelSize(r.f.ds10) + 8 + intrinsicWidth;
    }

    public void setProgress(float f) {
        if (f >= 0.0f && this.aIM != null) {
            int i = (int) (100.0f * f);
            if (this.aIM.isSelected()) {
                this.aIJ.setProgress(i);
                this.aIJ.setSecondaryProgress(0);
                return;
            }
            this.aIJ.setProgress(0);
            this.aIJ.setSecondaryProgress(i);
        }
    }

    public View getView() {
        return this.aIH;
    }

    public void onChangeSkinType(int i) {
        if (this.aIM != null && this.aIM.Cd() > 0) {
            ap.c(this.aII, this.aIM.Cd(), i);
        }
        ap.c(this.apd, r.e.cp_cont_b, 1);
        ap.c(this.aIK, this.aIO, 1);
        this.aIJ.setProgressDrawable(ap.getDrawable(r.g.vote_progress_drawable));
        if (this.aIM != null) {
            if (this.aIM.isSelected()) {
                ap.k(this.aIL, r.e.common_color_10271);
            } else {
                ap.k(this.aIL, r.e.common_color_10272);
            }
        }
    }
}
