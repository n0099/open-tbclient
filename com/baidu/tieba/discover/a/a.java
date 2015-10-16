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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.discover.u;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class a extends RelativeLayout {
    private TbImageView ME;
    private ImageView aLa;
    private TextView alu;

    public a(Context context) {
        this(context, null);
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        LayoutInflater.from(getContext()).inflate(i.g.discover_header_item, (ViewGroup) this, true);
        init();
    }

    private void init() {
        this.ME = (TbImageView) findViewById(i.f.icon);
        this.alu = (TextView) findViewById(i.f.title);
        this.aLa = (ImageView) findViewById(i.f.red_tip);
        this.ME.setDefaultBgResource(0);
    }

    public void ar(String str, String str2) {
        if (this.ME != null) {
            this.ME.setDefaultResource(u.gp(str2));
            if (!StringUtils.isNull(str)) {
                this.ME.d(str, 10, false);
            }
        }
    }

    public void setTitle(String str) {
        if (this.alu != null) {
            this.alu.setText(str);
        }
    }

    public void bJ(boolean z) {
        if (this.aLa != null) {
            if (z) {
                this.aLa.setVisibility(0);
            } else {
                this.aLa.setVisibility(8);
            }
        }
    }

    public void e(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.h.a.a(tbPageContext, this);
        an.i(this, i.e.addresslist_item_bg);
        this.ME.setIsNight(TbadkApplication.getInst().getSkinType() == 1);
    }
}
