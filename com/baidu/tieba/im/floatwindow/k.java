package com.baidu.tieba.im.floatwindow;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.t;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.x;
/* loaded from: classes.dex */
public class k extends l {
    private HeadImageView aHa;
    private j aYO;
    private TextView aYP;

    public k() {
        super(com.baidu.adp.lib.g.b.ei().inflate(TbadkCoreApplication.m255getInst(), x.im_float_head_view, null));
        this.aYO = new j();
        this.aHa = (HeadImageView) this.aYV.findViewById(w.im_float_head_view_head);
        this.aYP = (TextView) this.aYV.findViewById(w.im_float_head_view_text);
        this.aHa.setIsRound(true);
    }

    public void b(int i, int i2, String str, int i3) {
        W(i, i2);
        NE();
        this.aHa.d(str, 12, false);
        this.aHa.setUrl(str);
        fK(i3);
        this.aHa.requestFocusFromTouch();
    }

    public void E(String str, int i) {
        if (TextUtils.equals(str, this.aHa.getUrl())) {
            fK(i);
        }
    }

    private void fK(int i) {
        int i2;
        if (i <= 0) {
            this.aYP.setVisibility(8);
            return;
        }
        this.aYP.setVisibility(0);
        bc.b(this.aYP, t.cp_cont_i, 1);
        if (i < 10) {
            this.aYP.setText(String.valueOf(i));
            i2 = v.icon_news_head_prompt_one;
        } else if (i < 100) {
            this.aYP.setText(String.valueOf(i));
            i2 = v.icon_news_head_prompt_two;
        } else {
            this.aYP.setText("   ");
            i2 = v.icon_news_head_prompt_more;
        }
        bc.i((View) this.aYP, i2);
    }

    public j NB() {
        this.aYO.H(this.aYV);
        return this.aYO;
    }

    public void U(int i, int i2) {
        W(i, i2);
    }
}
