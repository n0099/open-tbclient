package com.baidu.tieba.discover.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.x;
/* loaded from: classes.dex */
public class a extends RelativeLayout {
    private TextView Xo;
    private ImageView awq;
    private TbImageView zS;

    public a(Context context) {
        this(context, null);
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        com.baidu.adp.lib.g.b.ei().a(getContext(), x.discover_header_item, this, true);
        init();
    }

    private void init() {
        this.zS = (TbImageView) findViewById(w.icon);
        this.Xo = (TextView) findViewById(w.title);
        this.awq = (ImageView) findViewById(w.red_tip);
        this.zS.setSupportNoImage(false);
    }

    public void fj(String str) {
        if (this.zS != null) {
            this.zS.d(str, 10, false);
        }
    }

    public void ex(int i) {
        if (this.zS != null) {
            this.zS.setImageResource(i);
        }
    }

    public void setTitle(String str) {
        if (this.Xo != null) {
            this.Xo.setText(str);
        }
    }

    public void bw(boolean z) {
        if (this.awq != null) {
            if (z) {
                this.awq.setVisibility(0);
            } else {
                this.awq.setVisibility(8);
            }
        }
    }

    public void c(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.g.a.a(tbPageContext, this);
        bc.i(this, v.addresslist_item_bg);
        this.zS.setIsNight(TbadkApplication.getInst().getSkinType() == 1);
    }
}
