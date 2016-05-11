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
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class ForumMemberIconView extends LinearLayout {
    private TextView aIg;
    private View aZr;
    private TbImageView bab;
    private Context context;
    private String mUrl;

    public ForumMemberIconView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
        ar(context);
    }

    public ForumMemberIconView(Context context) {
        super(context);
        this.context = context;
        ar(context);
    }

    public void setIcon(String str) {
        this.bab.c(str, 10, false);
    }

    public void setUrl(String str) {
        this.mUrl = str;
    }

    private void ar(Context context) {
        this.aZr = findViewById(t.g.forum_member_icon_layout);
        LayoutInflater.from(context).inflate(t.h.frs_forum_member_view, this);
        this.bab = (TbImageView) findViewById(t.g.forum_member_image_icon);
        this.aIg = (TextView) findViewById(t.g.forum_member_text);
        this.bab.setDefaultBgResource(t.f.transparent_bg);
        this.bab.setAutoChangeStyle(false);
        this.aZr.setOnClickListener(new b(this, (TbPageContext) com.baidu.adp.base.l.s(context)));
    }

    public void e(TbPageContext<?> tbPageContext, int i) {
        at.k(this.aZr, t.f.forum_member_icon_bg);
        at.j((View) this.aIg, t.d.frs_forum_member_icon_text);
        this.bab.invalidate();
    }
}
