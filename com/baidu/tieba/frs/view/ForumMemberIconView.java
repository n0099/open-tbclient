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
    private TextView aVs;
    private View bGF;
    private TbImageView bHE;
    private Context context;
    private String mUrl;

    public ForumMemberIconView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
        bs(context);
    }

    public ForumMemberIconView(Context context) {
        super(context);
        this.context = context;
        bs(context);
    }

    public void setIcon(String str) {
        this.bHE.c(str, 10, false);
    }

    public void setUrl(String str) {
        this.mUrl = str;
    }

    private void bs(Context context) {
        this.bGF = findViewById(w.h.forum_member_icon_layout);
        LayoutInflater.from(context).inflate(w.j.frs_forum_member_view, this);
        this.bHE = (TbImageView) findViewById(w.h.forum_member_image_icon);
        this.aVs = (TextView) findViewById(w.h.forum_member_text);
        this.bHE.setDefaultBgResource(w.g.transparent_bg);
        this.bHE.setAutoChangeStyle(false);
        this.bGF.setOnClickListener(new b(this, (TbPageContext) com.baidu.adp.base.k.aa(context)));
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        aq.j(this.bGF, w.g.forum_member_icon_bg);
        aq.i((View) this.aVs, w.e.common_color_10248);
        this.bHE.invalidate();
    }
}
