package com.baidu.tieba.discover.a;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.discover.p;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class a extends RelativeLayout {
    private TbImageView Mw;
    private ImageView aCi;
    private TextView ahz;

    public a(Context context) {
        this(context, null);
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        com.baidu.adp.lib.g.b.hH().a(getContext(), w.discover_header_item, this, true);
        init();
    }

    private void init() {
        this.Mw = (TbImageView) findViewById(v.icon);
        this.ahz = (TextView) findViewById(v.title);
        this.aCi = (ImageView) findViewById(v.red_tip);
        this.Mw.setDefaultBgResource(0);
    }

    public void am(String str, String str2) {
        if (this.Mw != null) {
            this.Mw.setDefaultResource(p.fp(str2));
            if (!StringUtils.isNull(str)) {
                this.Mw.c(str, 10, false);
            }
        }
    }

    public void setTitle(String str) {
        if (this.ahz != null) {
            this.ahz.setText(str);
        }
    }

    public void bv(boolean z) {
        if (this.aCi != null) {
            if (z) {
                this.aCi.setVisibility(0);
            } else {
                this.aCi.setVisibility(8);
            }
        }
    }

    public void f(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.f.a.a(tbPageContext, this);
        ba.i(this, u.addresslist_item_bg);
        this.Mw.setIsNight(TbadkApplication.getInst().getSkinType() == 1);
    }
}
