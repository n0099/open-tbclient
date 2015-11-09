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
    private TbImageView MF;
    private ImageView aJU;
    private TextView alz;

    public a(Context context) {
        this(context, null);
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        LayoutInflater.from(getContext()).inflate(i.g.discover_header_item, (ViewGroup) this, true);
        init();
    }

    private void init() {
        this.MF = (TbImageView) findViewById(i.f.icon);
        this.alz = (TextView) findViewById(i.f.title);
        this.aJU = (ImageView) findViewById(i.f.red_tip);
        this.MF.setDefaultBgResource(0);
    }

    public void ao(String str, String str2) {
        if (this.MF != null) {
            this.MF.setDefaultResource(u.gr(str2));
            if (!StringUtils.isNull(str)) {
                this.MF.d(str, 10, false);
            }
        }
    }

    public void setTitle(String str) {
        if (this.alz != null) {
            this.alz.setText(str);
        }
    }

    public void bL(boolean z) {
        if (this.aJU != null) {
            if (z) {
                this.aJU.setVisibility(0);
            } else {
                this.aJU.setVisibility(8);
            }
        }
    }

    public void e(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.h.a.a(tbPageContext, this);
        an.i(this, i.e.addresslist_item_bg);
        this.MF.setIsNight(TbadkApplication.getInst().getSkinType() == 1);
    }
}
