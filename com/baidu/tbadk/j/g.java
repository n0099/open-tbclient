package com.baidu.tbadk.j;

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
    protected TbImageView aHt;
    protected TextView aHu;
    protected TextView aHv;
    protected TextView aHw;

    public TextView tk() {
        return this.aHv;
    }

    public TextView EV() {
        return this.aHw;
    }

    public g(Context context, View.OnClickListener onClickListener) {
        super(LayoutInflater.from(context).inflate(d.h.net_refresh_view_layout, (ViewGroup) null));
        this.aHt = (TbImageView) this.aHl.findViewById(d.g.net_refresh_image);
        this.aHu = (TextView) this.aHl.findViewById(d.g.net_refresh_desc);
        this.aHv = (TextView) this.aHl.findViewById(d.g.net_refresh_title);
        this.aHw = (TextView) this.aHl.findViewById(d.g.net_refresh_button);
        this.aHw.setOnClickListener(onClickListener);
        this.aHl.setOnClickListener(null);
    }

    public void gB(String str) {
        if (str == null) {
            this.aHu.setVisibility(8);
            return;
        }
        this.aHu.setVisibility(0);
        this.aHu.setText(str);
    }

    public void setTitle(String str) {
        if (str != null) {
            this.aHv.setText(str);
        }
    }

    public void setButtonText(String str) {
        if (str != null) {
            this.aHw.setText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.j.a
    public void EP() {
        super.EP();
        onChangeSkinType();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.j.a
    public void EQ() {
        super.EQ();
        this.aHt.setImageResource(0);
    }

    public void fi(int i) {
        ViewGroup.LayoutParams layoutParams = this.aHt.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = i;
            this.aHt.setLayoutParams(marginLayoutParams);
        }
    }

    public void EW() {
        this.aHw.setVisibility(0);
        this.aHv.setVisibility(0);
        aj.c(this.aHu, d.C0095d.cp_cont_d, 1);
    }

    public void EX() {
        this.aHw.setVisibility(8);
        this.aHv.setVisibility(8);
        aj.c(this.aHu, d.C0095d.cp_cont_b, 1);
    }

    public void onChangeSkinType() {
        if (EO()) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            aj.c(this.aHt, d.f.net_refresh_emotion);
            aj.b(this.aHu, d.C0095d.cp_cont_d, 1, skinType);
            aj.b(this.aHv, d.C0095d.cp_cont_b, 1, skinType);
            aj.b(this.aHw, d.C0095d.cp_cont_g, 1, skinType);
            aj.d(this.aHw, d.f.btn_appdownload, skinType);
            aj.k(this.aHl, d.C0095d.cp_bg_line_d);
        }
    }

    public View EU() {
        return this.aHl;
    }
}
