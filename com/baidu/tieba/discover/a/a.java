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
    private TbImageView Mu;
    private ImageView aCa;
    private TextView ahr;

    public a(Context context) {
        this(context, null);
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        com.baidu.adp.lib.g.b.hH().a(getContext(), w.discover_header_item, this, true);
        init();
    }

    private void init() {
        this.Mu = (TbImageView) findViewById(v.icon);
        this.ahr = (TextView) findViewById(v.title);
        this.aCa = (ImageView) findViewById(v.red_tip);
        this.Mu.setDefaultBgResource(0);
    }

    public void am(String str, String str2) {
        if (this.Mu != null) {
            this.Mu.setDefaultResource(p.fm(str2));
            if (!StringUtils.isNull(str)) {
                this.Mu.c(str, 10, false);
            }
        }
    }

    public void setTitle(String str) {
        if (this.ahr != null) {
            this.ahr.setText(str);
        }
    }

    public void bv(boolean z) {
        if (this.aCa != null) {
            if (z) {
                this.aCa.setVisibility(0);
            } else {
                this.aCa.setVisibility(8);
            }
        }
    }

    public void f(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.f.a.a(tbPageContext, this);
        ba.i(this, u.addresslist_item_bg);
        this.Mu.setIsNight(TbadkApplication.getInst().getSkinType() == 1);
    }
}
