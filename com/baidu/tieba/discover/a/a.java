package com.baidu.tieba.discover.a;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.discover.u;
import com.baidu.tieba.p;
import com.baidu.tieba.q;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class a extends RelativeLayout {
    private TbImageView Ms;
    private ImageView aEk;
    private TextView aiA;

    public a(Context context) {
        this(context, null);
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        com.baidu.adp.lib.g.b.hr().a(getContext(), r.discover_header_item, this, true);
        init();
    }

    private void init() {
        this.Ms = (TbImageView) findViewById(q.icon);
        this.aiA = (TextView) findViewById(q.title);
        this.aEk = (ImageView) findViewById(q.red_tip);
        this.Ms.setDefaultBgResource(0);
    }

    public void ar(String str, String str2) {
        if (this.Ms != null) {
            this.Ms.setDefaultResource(u.fM(str2));
            if (!StringUtils.isNull(str)) {
                this.Ms.c(str, 10, false);
            }
        }
    }

    public void setTitle(String str) {
        if (this.aiA != null) {
            this.aiA.setText(str);
        }
    }

    public void bF(boolean z) {
        if (this.aEk != null) {
            if (z) {
                this.aEk.setVisibility(0);
            } else {
                this.aEk.setVisibility(8);
            }
        }
    }

    public void d(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.f.a.a(tbPageContext, this);
        ay.i(this, p.addresslist_item_bg);
        this.Ms.setIsNight(TbadkApplication.getInst().getSkinType() == 1);
    }
}
