package com.baidu.tieba.im.floatwindow;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.t;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.x;
/* loaded from: classes.dex */
public class k extends l {
    private HeadImageView aFT;
    private j aXt;
    private TextView aXu;

    public k() {
        super(com.baidu.adp.lib.g.b.ek().inflate(TbadkCoreApplication.m255getInst(), x.im_float_head_view, null));
        this.aXt = new j();
        this.aFT = (HeadImageView) this.aXA.findViewById(w.im_float_head_view_head);
        this.aXu = (TextView) this.aXA.findViewById(w.im_float_head_view_text);
        this.aFT.setIsRound(true);
    }

    public void b(int i, int i2, String str, int i3) {
        U(i, i2);
        Nn();
        this.aFT.d(str, 12, false);
        this.aFT.setUrl(str);
        fF(i3);
        this.aFT.requestFocusFromTouch();
    }

    public void E(String str, int i) {
        if (TextUtils.equals(str, this.aFT.getUrl())) {
            fF(i);
        }
    }

    private void fF(int i) {
        int i2;
        if (i <= 0) {
            this.aXu.setVisibility(8);
            return;
        }
        this.aXu.setVisibility(0);
        ax.b(this.aXu, t.cp_cont_i, 1);
        if (i < 10) {
            this.aXu.setText(String.valueOf(i));
            i2 = v.icon_news_head_prompt_one;
        } else if (i < 100) {
            this.aXu.setText(String.valueOf(i));
            i2 = v.icon_news_head_prompt_two;
        } else {
            this.aXu.setText("   ");
            i2 = v.icon_news_head_prompt_more;
        }
        ax.i((View) this.aXu, i2);
    }

    public j Nk() {
        this.aXt.F(this.aXA);
        return this.aXt;
    }

    public void S(int i, int i2) {
        U(i, i2);
    }
}
