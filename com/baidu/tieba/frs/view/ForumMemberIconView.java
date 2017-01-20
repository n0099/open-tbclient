package com.baidu.tieba.frs.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class ForumMemberIconView extends LinearLayout {
    private TextView aPG;
    private TbImageView bAy;
    private View bzz;
    private Context context;
    private String mUrl;

    public ForumMemberIconView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
        aT(context);
    }

    public ForumMemberIconView(Context context) {
        super(context);
        this.context = context;
        aT(context);
    }

    public void setIcon(String str) {
        this.bAy.c(str, 10, false);
    }

    public void setUrl(String str) {
        this.mUrl = str;
    }

    private void aT(Context context) {
        this.bzz = findViewById(r.h.forum_member_icon_layout);
        LayoutInflater.from(context).inflate(r.j.frs_forum_member_view, this);
        this.bAy = (TbImageView) findViewById(r.h.forum_member_image_icon);
        this.aPG = (TextView) findViewById(r.h.forum_member_text);
        this.bAy.setDefaultBgResource(r.g.transparent_bg);
        this.bAy.setAutoChangeStyle(false);
        this.bzz.setOnClickListener(new b(this, (TbPageContext) com.baidu.adp.base.k.C(context)));
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        ap.j(this.bzz, r.g.forum_member_icon_bg);
        ap.i((View) this.aPG, r.e.common_color_10248);
        this.bAy.invalidate();
    }
}
