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
    private TextView Xl;
    private ImageView awn;
    private TbImageView zP;

    public a(Context context) {
        this(context, null);
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        com.baidu.adp.lib.g.b.ei().a(getContext(), x.discover_header_item, this, true);
        init();
    }

    private void init() {
        this.zP = (TbImageView) findViewById(w.icon);
        this.Xl = (TextView) findViewById(w.title);
        this.awn = (ImageView) findViewById(w.red_tip);
        this.zP.setSupportNoImage(false);
    }

    public void fg(String str) {
        if (this.zP != null) {
            this.zP.d(str, 10, false);
        }
    }

    public void ex(int i) {
        if (this.zP != null) {
            this.zP.setImageResource(i);
        }
    }

    public void setTitle(String str) {
        if (this.Xl != null) {
            this.Xl.setText(str);
        }
    }

    public void bw(boolean z) {
        if (this.awn != null) {
            if (z) {
                this.awn.setVisibility(0);
            } else {
                this.awn.setVisibility(8);
            }
        }
    }

    public void c(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.g.a.a(tbPageContext, this);
        bc.i(this, v.addresslist_item_bg);
        this.zP.setIsNight(TbadkApplication.getInst().getSkinType() == 1);
    }
}
