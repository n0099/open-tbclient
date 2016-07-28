package com.baidu.tieba.frs.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.base.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class ForumMemberIconView extends LinearLayout {
    private TextView aMx;
    private View bxB;
    private TbImageView bym;
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
        this.bym.c(str, 10, false);
    }

    public void setUrl(String str) {
        this.mUrl = str;
    }

    private void ar(Context context) {
        this.bxB = findViewById(u.g.forum_member_icon_layout);
        LayoutInflater.from(context).inflate(u.h.frs_forum_member_view, this);
        this.bym = (TbImageView) findViewById(u.g.forum_member_image_icon);
        this.aMx = (TextView) findViewById(u.g.forum_member_text);
        this.bym.setDefaultBgResource(u.f.transparent_bg);
        this.bym.setAutoChangeStyle(false);
        this.bxB.setOnClickListener(new b(this, (TbPageContext) l.s(context)));
    }

    public void e(TbPageContext<?> tbPageContext, int i) {
        av.k(this.bxB, u.f.forum_member_icon_bg);
        av.j((View) this.aMx, u.d.common_color_10248);
        this.bym.invalidate();
    }
}
