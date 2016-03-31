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
    private TextView aLW;
    private View bdJ;
    private TbImageView bem;
    private Context context;
    private String mUrl;

    public ForumMemberIconView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
        aq(context);
    }

    public ForumMemberIconView(Context context) {
        super(context);
        this.context = context;
        aq(context);
    }

    public void setIcon(String str) {
        this.bem.c(str, 10, false);
    }

    public void setUrl(String str) {
        this.mUrl = str;
    }

    private void aq(Context context) {
        this.bdJ = findViewById(t.g.forum_member_icon_layout);
        LayoutInflater.from(context).inflate(t.h.frs_forum_member_view, this);
        this.bem = (TbImageView) findViewById(t.g.forum_member_image_icon);
        this.aLW = (TextView) findViewById(t.g.forum_member_text);
        this.bem.setDefaultBgResource(t.f.transparent_bg);
        this.bem.setAutoChangeStyle(false);
        this.bdJ.setOnClickListener(new a(this, (TbPageContext) com.baidu.adp.base.l.s(context)));
    }

    public void e(TbPageContext<?> tbPageContext, int i) {
        at.k(this.bdJ, t.f.forum_member_icon_bg);
        at.j((View) this.aLW, t.d.frs_forum_member_icon_text);
        this.bem.invalidate();
    }
}
