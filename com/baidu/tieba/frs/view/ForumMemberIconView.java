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
    private TextView aLD;
    private TbImageView bvY;
    private View bvn;
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
        this.bvY.c(str, 10, false);
    }

    public void setUrl(String str) {
        this.mUrl = str;
    }

    private void ar(Context context) {
        this.bvn = findViewById(u.g.forum_member_icon_layout);
        LayoutInflater.from(context).inflate(u.h.frs_forum_member_view, this);
        this.bvY = (TbImageView) findViewById(u.g.forum_member_image_icon);
        this.aLD = (TextView) findViewById(u.g.forum_member_text);
        this.bvY.setDefaultBgResource(u.f.transparent_bg);
        this.bvY.setAutoChangeStyle(false);
        this.bvn.setOnClickListener(new b(this, (TbPageContext) l.s(context)));
    }

    public void e(TbPageContext<?> tbPageContext, int i) {
        av.k(this.bvn, u.f.forum_member_icon_bg);
        av.j((View) this.aLD, u.d.common_color_10248);
        this.bvY.invalidate();
    }
}
