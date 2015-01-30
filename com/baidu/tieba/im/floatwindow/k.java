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
    private HeadImageView aHd;
    private j aYP;
    private TextView aYQ;

    public k() {
        super(com.baidu.adp.lib.g.b.ei().inflate(TbadkCoreApplication.m255getInst(), x.im_float_head_view, null));
        this.aYP = new j();
        this.aHd = (HeadImageView) this.aYW.findViewById(w.im_float_head_view_head);
        this.aYQ = (TextView) this.aYW.findViewById(w.im_float_head_view_text);
        this.aHd.setIsRound(true);
    }

    public void b(int i, int i2, String str, int i3) {
        V(i, i2);
        NJ();
        this.aHd.d(str, 12, false);
        this.aHd.setUrl(str);
        fK(i3);
        this.aHd.requestFocusFromTouch();
    }

    public void E(String str, int i) {
        if (TextUtils.equals(str, this.aHd.getUrl())) {
            fK(i);
        }
    }

    private void fK(int i) {
        int i2;
        if (i <= 0) {
            this.aYQ.setVisibility(8);
            return;
        }
        this.aYQ.setVisibility(0);
        bc.b(this.aYQ, t.cp_cont_i, 1);
        if (i < 10) {
            this.aYQ.setText(String.valueOf(i));
            i2 = v.icon_news_head_prompt_one;
        } else if (i < 100) {
            this.aYQ.setText(String.valueOf(i));
            i2 = v.icon_news_head_prompt_two;
        } else {
            this.aYQ.setText("   ");
            i2 = v.icon_news_head_prompt_more;
        }
        bc.i((View) this.aYQ, i2);
    }

    public j NG() {
        this.aYP.H(this.aYW);
        return this.aYP;
    }

    public void T(int i, int i2) {
        V(i, i2);
    }
}
