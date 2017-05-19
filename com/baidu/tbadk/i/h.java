package com.baidu.tbadk.i;

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
    protected TbImageView aDO;
    protected TextView aDP;
    protected TextView aDQ;
    protected TextView aDR;

    public h(Context context, View.OnClickListener onClickListener) {
        super(LayoutInflater.from(context).inflate(w.j.net_refresh_view_layout, (ViewGroup) null));
        this.aDO = (TbImageView) this.aDG.findViewById(w.h.net_refresh_image);
        this.aDP = (TextView) this.aDG.findViewById(w.h.net_refresh_desc);
        this.aDQ = (TextView) this.aDG.findViewById(w.h.net_refresh_title);
        this.aDR = (TextView) this.aDG.findViewById(w.h.net_refresh_button);
        this.aDR.setOnClickListener(onClickListener);
        this.aDG.setOnClickListener(null);
    }

    public void fQ(String str) {
        if (str == null) {
            this.aDP.setVisibility(8);
            return;
        }
        this.aDP.setVisibility(0);
        this.aDP.setText(str);
    }

    public void setTitle(String str) {
        if (str != null) {
            this.aDQ.setText(str);
        }
    }

    public void fR(String str) {
        if (str != null) {
            this.aDR.setText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.i.a
    public void DY() {
        super.DY();
        onChangeSkinType();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.i.a
    public void DZ() {
        super.DZ();
        this.aDO.setImageResource(0);
    }

    public void eR(int i) {
        ViewGroup.LayoutParams layoutParams = this.aDO.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = i;
            this.aDO.setLayoutParams(marginLayoutParams);
        }
    }

    public void Ee() {
        this.aDR.setVisibility(0);
        this.aDQ.setVisibility(0);
        aq.c(this.aDP, w.e.cp_cont_d, 1);
    }

    public void Ef() {
        this.aDR.setVisibility(8);
        this.aDQ.setVisibility(8);
        aq.c(this.aDP, w.e.cp_cont_b, 1);
    }

    public void onChangeSkinType() {
        if (DX()) {
            int skinType = TbadkCoreApplication.m9getInst().getSkinType();
            aq.c(this.aDO, w.g.net_refresh_emotion);
            aq.b(this.aDP, w.e.cp_cont_d, 1, skinType);
            aq.b(this.aDQ, w.e.cp_cont_b, 1, skinType);
            aq.b(this.aDR, w.e.cp_cont_g, 1, skinType);
            aq.d(this.aDR, w.g.btn_appdownload, skinType);
            aq.k(this.aDG, w.e.cp_bg_line_d);
        }
    }

    public View Ed() {
        return this.aDG;
    }
}
