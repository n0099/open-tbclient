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
    private TbImageView Nm;
    private ImageView aSn;
    private TextView ahk;

    public a(Context context) {
        this(context, null);
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        LayoutInflater.from(getContext()).inflate(n.h.discover_header_item, (ViewGroup) this, true);
        init();
    }

    private void init() {
        this.Nm = (TbImageView) findViewById(n.g.icon);
        this.ahk = (TextView) findViewById(n.g.title);
        this.aSn = (ImageView) findViewById(n.g.red_tip);
        this.Nm.setDefaultBgResource(0);
    }

    public void ap(String str, String str2) {
        if (this.Nm != null) {
            this.Nm.setDefaultResource(t.gQ(str2));
            if (!StringUtils.isNull(str)) {
                this.Nm.d(str, 10, false);
            }
        }
    }

    public void setTitle(String str) {
        if (this.ahk != null) {
            this.ahk.setText(str);
        }
    }

    public void bX(boolean z) {
        if (this.aSn != null) {
            if (z) {
                this.aSn.setVisibility(0);
            } else {
                this.aSn.setVisibility(8);
            }
        }
    }

    public void f(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.i.a.a(tbPageContext, this);
        as.i(this, n.f.addresslist_item_bg);
        this.Nm.setIsNight(TbadkApplication.getInst().getSkinType() == 1);
    }
}
