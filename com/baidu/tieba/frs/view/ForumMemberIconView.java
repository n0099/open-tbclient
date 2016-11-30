package com.baidu.tieba.frs.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class ForumMemberIconView extends LinearLayout {
    private TextView aUX;
    private View bLK;
    private TbImageView bMI;
    private Context context;
    private String mUrl;

    public ForumMemberIconView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
        aO(context);
    }

    public ForumMemberIconView(Context context) {
        super(context);
        this.context = context;
        aO(context);
    }

    public void setIcon(String str) {
        this.bMI.c(str, 10, false);
    }

    public void setUrl(String str) {
        this.mUrl = str;
    }

    private void aO(Context context) {
        this.bLK = findViewById(r.g.forum_member_icon_layout);
        LayoutInflater.from(context).inflate(r.h.frs_forum_member_view, this);
        this.bMI = (TbImageView) findViewById(r.g.forum_member_image_icon);
        this.aUX = (TextView) findViewById(r.g.forum_member_text);
        this.bMI.setDefaultBgResource(r.f.transparent_bg);
        this.bMI.setAutoChangeStyle(false);
        this.bLK.setOnClickListener(new b(this, (TbPageContext) com.baidu.adp.base.l.C(context)));
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        at.k(this.bLK, r.f.forum_member_icon_bg);
        at.j((View) this.aUX, r.d.common_color_10248);
        this.bMI.invalidate();
    }
}
