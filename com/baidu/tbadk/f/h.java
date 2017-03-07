package com.baidu.tbadk.f;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class h extends a {
    protected TbImageView aDw;
    protected TextView aDx;
    protected TextView aDy;
    protected TextView aDz;

    public h(Context context, View.OnClickListener onClickListener) {
        super(LayoutInflater.from(context).inflate(w.j.net_refresh_view_layout, (ViewGroup) null));
        this.aDw = (TbImageView) this.aDp.findViewById(w.h.net_refresh_image);
        this.aDx = (TextView) this.aDp.findViewById(w.h.net_refresh_desc);
        this.aDy = (TextView) this.aDp.findViewById(w.h.net_refresh_title);
        this.aDz = (TextView) this.aDp.findViewById(w.h.net_refresh_button);
        this.aDz.setOnClickListener(onClickListener);
        this.aDp.setOnClickListener(null);
    }

    public void fN(String str) {
        if (str == null) {
            this.aDx.setVisibility(8);
            return;
        }
        this.aDx.setVisibility(0);
        this.aDx.setText(str);
    }

    public void setTitle(String str) {
        if (str != null) {
            this.aDy.setText(str);
        }
    }

    public void fO(String str) {
        if (str != null) {
            this.aDz.setText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.f.a
    public void Ew() {
        super.Ew();
        tD();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.f.a
    public void Ex() {
        super.Ex();
        this.aDw.setImageResource(0);
    }

    public void eS(int i) {
        ViewGroup.LayoutParams layoutParams = this.aDw.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = i;
            this.aDw.setLayoutParams(marginLayoutParams);
        }
    }

    public void EC() {
        this.aDz.setVisibility(0);
        this.aDy.setVisibility(0);
        aq.c(this.aDx, w.e.cp_cont_d, 1);
    }

    public void ED() {
        this.aDz.setVisibility(8);
        this.aDy.setVisibility(8);
        aq.c(this.aDx, w.e.cp_cont_b, 1);
    }

    public void tD() {
        if (Ev()) {
            int skinType = TbadkCoreApplication.m9getInst().getSkinType();
            aq.c(this.aDw, w.g.net_refresh_emotion);
            aq.b(this.aDx, w.e.cp_cont_d, 1, skinType);
            aq.b(this.aDy, w.e.cp_cont_b, 1, skinType);
            aq.b(this.aDz, w.e.cp_cont_g, 1, skinType);
            aq.d(this.aDz, w.g.btn_appdownload, skinType);
            aq.k(this.aDp, w.e.cp_bg_line_d);
        }
    }

    public View EB() {
        return this.aDp;
    }
}
