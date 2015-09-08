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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.discover.u;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class a extends RelativeLayout {
    private TbImageView MD;
    private ImageView aLX;
    private TextView amV;

    public a(Context context) {
        this(context, null);
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        LayoutInflater.from(getContext()).inflate(i.g.discover_header_item, (ViewGroup) this, true);
        init();
    }

    private void init() {
        this.MD = (TbImageView) findViewById(i.f.icon);
        this.amV = (TextView) findViewById(i.f.title);
        this.aLX = (ImageView) findViewById(i.f.red_tip);
        this.MD.setDefaultBgResource(0);
    }

    public void as(String str, String str2) {
        if (this.MD != null) {
            this.MD.setDefaultResource(u.gm(str2));
            if (!StringUtils.isNull(str)) {
                this.MD.d(str, 10, false);
            }
        }
    }

    public void setTitle(String str) {
        if (this.amV != null) {
            this.amV.setText(str);
        }
    }

    public void bM(boolean z) {
        if (this.aLX != null) {
            if (z) {
                this.aLX.setVisibility(0);
            } else {
                this.aLX.setVisibility(8);
            }
        }
    }

    public void e(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.h.a.a(tbPageContext, this);
        al.h(this, i.e.addresslist_item_bg);
        this.MD.setIsNight(TbadkApplication.getInst().getSkinType() == 1);
    }
}
