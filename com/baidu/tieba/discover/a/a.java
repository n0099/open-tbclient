package com.baidu.tieba.discover.a;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.discover.t;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class a extends RelativeLayout {
    private TbImageView MW;
    private ImageView aOv;
    private TextView agd;

    public a(Context context) {
        this(context, null);
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        LayoutInflater.from(getContext()).inflate(n.g.discover_header_item, (ViewGroup) this, true);
        init();
    }

    private void init() {
        this.MW = (TbImageView) findViewById(n.f.icon);
        this.agd = (TextView) findViewById(n.f.title);
        this.aOv = (ImageView) findViewById(n.f.red_tip);
        this.MW.setDefaultBgResource(0);
    }

    public void ar(String str, String str2) {
        if (this.MW != null) {
            this.MW.setDefaultResource(t.gG(str2));
            if (!StringUtils.isNull(str)) {
                this.MW.d(str, 10, false);
            }
        }
    }

    public void setTitle(String str) {
        if (this.agd != null) {
            this.agd.setText(str);
        }
    }

    public void bW(boolean z) {
        if (this.aOv != null) {
            if (z) {
                this.aOv.setVisibility(0);
            } else {
                this.aOv.setVisibility(8);
            }
        }
    }

    public void f(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.i.a.a(tbPageContext, this);
        as.i(this, n.e.addresslist_item_bg);
        this.MW.setIsNight(TbadkApplication.getInst().getSkinType() == 1);
    }
}
