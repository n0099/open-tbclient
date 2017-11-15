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
    protected TbImageView aGK;
    protected TextView aGL;
    protected TextView aGM;
    protected TextView aGN;

    public TextView tk() {
        return this.aGM;
    }

    public TextView EN() {
        return this.aGN;
    }

    public g(Context context, View.OnClickListener onClickListener) {
        super(LayoutInflater.from(context).inflate(d.h.net_refresh_view_layout, (ViewGroup) null));
        this.aGK = (TbImageView) this.aGC.findViewById(d.g.net_refresh_image);
        this.aGL = (TextView) this.aGC.findViewById(d.g.net_refresh_desc);
        this.aGM = (TextView) this.aGC.findViewById(d.g.net_refresh_title);
        this.aGN = (TextView) this.aGC.findViewById(d.g.net_refresh_button);
        this.aGN.setOnClickListener(onClickListener);
        this.aGC.setOnClickListener(null);
    }

    public void gz(String str) {
        if (str == null) {
            this.aGL.setVisibility(8);
            return;
        }
        this.aGL.setVisibility(0);
        this.aGL.setText(str);
    }

    public void setTitle(String str) {
        if (str != null) {
            this.aGM.setText(str);
        }
    }

    public void setButtonText(String str) {
        if (str != null) {
            this.aGN.setText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.k.a
    public void EH() {
        super.EH();
        onChangeSkinType();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.k.a
    public void EI() {
        super.EI();
        this.aGK.setImageResource(0);
    }

    public void fj(int i) {
        ViewGroup.LayoutParams layoutParams = this.aGK.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = i;
            this.aGK.setLayoutParams(marginLayoutParams);
        }
    }

    public void EO() {
        this.aGN.setVisibility(0);
        this.aGM.setVisibility(0);
        aj.c(this.aGL, d.C0080d.cp_cont_d, 1);
    }

    public void EP() {
        this.aGN.setVisibility(8);
        this.aGM.setVisibility(8);
        aj.c(this.aGL, d.C0080d.cp_cont_b, 1);
    }

    public void onChangeSkinType() {
        if (EG()) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            aj.c(this.aGK, d.f.net_refresh_emotion);
            aj.b(this.aGL, d.C0080d.cp_cont_d, 1, skinType);
            aj.b(this.aGM, d.C0080d.cp_cont_b, 1, skinType);
            aj.b(this.aGN, d.C0080d.cp_cont_g, 1, skinType);
            aj.d(this.aGN, d.f.btn_appdownload, skinType);
            aj.k(this.aGC, d.C0080d.cp_bg_line_d);
        }
    }

    public View EM() {
        return this.aGC;
    }
}
