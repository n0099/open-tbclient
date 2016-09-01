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
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class ForumMemberIconView extends LinearLayout {
    private TextView aRR;
    private View bIQ;
    private TbImageView bJO;
    private Context context;
    private String mUrl;

    public ForumMemberIconView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
        aE(context);
    }

    public ForumMemberIconView(Context context) {
        super(context);
        this.context = context;
        aE(context);
    }

    public void setIcon(String str) {
        this.bJO.c(str, 10, false);
    }

    public void setUrl(String str) {
        this.mUrl = str;
    }

    private void aE(Context context) {
        this.bIQ = findViewById(t.g.forum_member_icon_layout);
        LayoutInflater.from(context).inflate(t.h.frs_forum_member_view, this);
        this.bJO = (TbImageView) findViewById(t.g.forum_member_image_icon);
        this.aRR = (TextView) findViewById(t.g.forum_member_text);
        this.bJO.setDefaultBgResource(t.f.transparent_bg);
        this.bJO.setAutoChangeStyle(false);
        this.bIQ.setOnClickListener(new b(this, (TbPageContext) l.C(context)));
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        av.k(this.bIQ, t.f.forum_member_icon_bg);
        av.j((View) this.aRR, t.d.common_color_10248);
        this.bJO.invalidate();
    }
}
