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
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class ForumMemberIconView extends LinearLayout {
    private TextView aJa;
    private View aYZ;
    private TbImageView aZC;
    private Context context;
    private String mUrl;

    public ForumMemberIconView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
        at(context);
    }

    public ForumMemberIconView(Context context) {
        super(context);
        this.context = context;
        at(context);
    }

    public void setIcon(String str) {
        this.aZC.d(str, 10, false);
    }

    public void setUrl(String str) {
        this.mUrl = str;
    }

    private void at(Context context) {
        this.aYZ = findViewById(t.g.forum_member_icon_layout);
        LayoutInflater.from(context).inflate(t.h.frs_forum_member_view, this);
        this.aZC = (TbImageView) findViewById(t.g.forum_member_image_icon);
        this.aJa = (TextView) findViewById(t.g.forum_member_text);
        this.aZC.setDefaultBgResource(t.f.transparent_bg);
        this.aZC.setAutoChangeStyle(false);
        this.aYZ.setOnClickListener(new a(this, (TbPageContext) com.baidu.adp.base.l.C(context)));
    }

    public void e(TbPageContext<?> tbPageContext, int i) {
        ar.k(this.aYZ, t.f.forum_member_icon_bg);
        ar.j((View) this.aJa, t.d.frs_forum_member_icon_text);
        this.aZC.invalidate();
    }
}
