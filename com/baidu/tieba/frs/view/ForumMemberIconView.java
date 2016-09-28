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
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class ForumMemberIconView extends LinearLayout {
    private TextView aSW;
    private View bIR;
    private TbImageView bJP;
    private Context context;
    private String mUrl;

    public ForumMemberIconView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
        aC(context);
    }

    public ForumMemberIconView(Context context) {
        super(context);
        this.context = context;
        aC(context);
    }

    public void setIcon(String str) {
        this.bJP.c(str, 10, false);
    }

    public void setUrl(String str) {
        this.mUrl = str;
    }

    private void aC(Context context) {
        this.bIR = findViewById(r.g.forum_member_icon_layout);
        LayoutInflater.from(context).inflate(r.h.frs_forum_member_view, this);
        this.bJP = (TbImageView) findViewById(r.g.forum_member_image_icon);
        this.aSW = (TextView) findViewById(r.g.forum_member_text);
        this.bJP.setDefaultBgResource(r.f.transparent_bg);
        this.bJP.setAutoChangeStyle(false);
        this.bIR.setOnClickListener(new b(this, (TbPageContext) l.C(context)));
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        av.k(this.bIR, r.f.forum_member_icon_bg);
        av.j((View) this.aSW, r.d.common_color_10248);
        this.bJP.invalidate();
    }
}
