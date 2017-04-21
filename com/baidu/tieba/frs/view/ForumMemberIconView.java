package com.baidu.tieba.frs.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class ForumMemberIconView extends LinearLayout {
    private TextView aVH;
    private View bIP;
    private TbImageView bJO;
    private Context context;
    private String mUrl;

    public ForumMemberIconView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
        bm(context);
    }

    public ForumMemberIconView(Context context) {
        super(context);
        this.context = context;
        bm(context);
    }

    public void setIcon(String str) {
        this.bJO.c(str, 10, false);
    }

    public void setUrl(String str) {
        this.mUrl = str;
    }

    private void bm(Context context) {
        this.bIP = findViewById(w.h.forum_member_icon_layout);
        LayoutInflater.from(context).inflate(w.j.frs_forum_member_view, this);
        this.bJO = (TbImageView) findViewById(w.h.forum_member_image_icon);
        this.aVH = (TextView) findViewById(w.h.forum_member_text);
        this.bJO.setDefaultBgResource(w.g.transparent_bg);
        this.bJO.setAutoChangeStyle(false);
        this.bIP.setOnClickListener(new b(this, (TbPageContext) com.baidu.adp.base.k.Z(context)));
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        aq.j(this.bIP, w.g.forum_member_icon_bg);
        aq.i(this.aVH, w.e.common_color_10248);
        this.bJO.invalidate();
    }
}
