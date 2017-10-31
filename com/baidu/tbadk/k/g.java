package com.baidu.tbadk.k;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class g extends a {
    protected TbImageView aGC;
    protected TextView aGD;
    protected TextView aGE;
    protected TextView aGF;

    public TextView tk() {
        return this.aGE;
    }

    public TextView EB() {
        return this.aGF;
    }

    public g(Context context, View.OnClickListener onClickListener) {
        super(LayoutInflater.from(context).inflate(d.h.net_refresh_view_layout, (ViewGroup) null));
        this.aGC = (TbImageView) this.aGu.findViewById(d.g.net_refresh_image);
        this.aGD = (TextView) this.aGu.findViewById(d.g.net_refresh_desc);
        this.aGE = (TextView) this.aGu.findViewById(d.g.net_refresh_title);
        this.aGF = (TextView) this.aGu.findViewById(d.g.net_refresh_button);
        this.aGF.setOnClickListener(onClickListener);
        this.aGu.setOnClickListener(null);
    }

    public void gy(String str) {
        if (str == null) {
            this.aGD.setVisibility(8);
            return;
        }
        this.aGD.setVisibility(0);
        this.aGD.setText(str);
    }

    public void setTitle(String str) {
        if (str != null) {
            this.aGE.setText(str);
        }
    }

    public void setButtonText(String str) {
        if (str != null) {
            this.aGF.setText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.k.a
    public void Ev() {
        super.Ev();
        onChangeSkinType();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.k.a
    public void Ew() {
        super.Ew();
        this.aGC.setImageResource(0);
    }

    public void fk(int i) {
        ViewGroup.LayoutParams layoutParams = this.aGC.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = i;
            this.aGC.setLayoutParams(marginLayoutParams);
        }
    }

    public void EC() {
        this.aGF.setVisibility(0);
        this.aGE.setVisibility(0);
        aj.c(this.aGD, d.C0080d.cp_cont_d, 1);
    }

    public void ED() {
        this.aGF.setVisibility(8);
        this.aGE.setVisibility(8);
        aj.c(this.aGD, d.C0080d.cp_cont_b, 1);
    }

    public void onChangeSkinType() {
        if (Eu()) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            aj.c(this.aGC, d.f.net_refresh_emotion);
            aj.b(this.aGD, d.C0080d.cp_cont_d, 1, skinType);
            aj.b(this.aGE, d.C0080d.cp_cont_b, 1, skinType);
            aj.b(this.aGF, d.C0080d.cp_cont_g, 1, skinType);
            aj.d(this.aGF, d.f.btn_appdownload, skinType);
            aj.k(this.aGu, d.C0080d.cp_bg_line_d);
        }
    }

    public View EA() {
        return this.aGu;
    }
}
