package com.baidu.tieba.discover.a;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.x;
/* loaded from: classes.dex */
public class a extends RelativeLayout {
    private ImageView avq;
    private TextView title;
    private TbImageView zS;

    public a(Context context) {
        this(context, null);
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        com.baidu.adp.lib.g.b.ek().a(getContext(), x.discover_header_item, this, true);
        init();
    }

    private void init() {
        this.zS = (TbImageView) findViewById(w.icon);
        this.title = (TextView) findViewById(w.title);
        this.avq = (ImageView) findViewById(w.red_tip);
        this.zS.setSupportNoImage(false);
    }

    public void fe(String str) {
        if (this.zS != null) {
            this.zS.d(str, 10, false);
        }
    }

    public void er(int i) {
        if (this.zS != null) {
            this.zS.setImageResource(i);
        }
    }

    public void setTitle(String str) {
        if (this.title != null) {
            this.title.setText(str);
        }
    }

    public void bt(boolean z) {
        if (this.avq != null) {
            if (z) {
                this.avq.setVisibility(0);
            } else {
                this.avq.setVisibility(8);
            }
        }
    }

    public void b(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.g.a.a(tbPageContext, this);
        ax.i(this, v.addresslist_item_bg);
        this.zS.setIsNight(TbadkApplication.getInst().getSkinType() == 1);
    }
}
