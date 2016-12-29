package com.baidu.tieba.frs.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class ForumMemberIconView extends LinearLayout {
    private TextView aUo;
    private View brO;
    private TbImageView bsM;
    private Context context;
    private String mUrl;

    public ForumMemberIconView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
        aN(context);
    }

    public ForumMemberIconView(Context context) {
        super(context);
        this.context = context;
        aN(context);
    }

    public void setIcon(String str) {
        this.bsM.c(str, 10, false);
    }

    public void setUrl(String str) {
        this.mUrl = str;
    }

    private void aN(Context context) {
        this.brO = findViewById(r.g.forum_member_icon_layout);
        LayoutInflater.from(context).inflate(r.h.frs_forum_member_view, this);
        this.bsM = (TbImageView) findViewById(r.g.forum_member_image_icon);
        this.aUo = (TextView) findViewById(r.g.forum_member_text);
        this.bsM.setDefaultBgResource(r.f.transparent_bg);
        this.bsM.setAutoChangeStyle(false);
        this.brO.setOnClickListener(new b(this, (TbPageContext) com.baidu.adp.base.l.C(context)));
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        ar.k(this.brO, r.f.forum_member_icon_bg);
        ar.j((View) this.aUo, r.d.common_color_10248);
        this.bsM.invalidate();
    }
}
