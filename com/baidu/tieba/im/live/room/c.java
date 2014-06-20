package com.baidu.tieba.im.live.room;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.view.HeadImageView;
/* loaded from: classes.dex */
class c {
    final /* synthetic */ b a;
    private View b;
    private HeadImageView c;
    private TextView d;
    private TextView e;
    private ImageView f;
    private com.baidu.tbadk.editortool.ab g;

    private c(b bVar, Context context) {
        this.a = bVar;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.b = LayoutInflater.from(context).inflate(com.baidu.tieba.w.live_group_like_list_item, (ViewGroup) null);
        this.c = (HeadImageView) this.b.findViewById(com.baidu.tieba.v.zan_list_item_head);
        this.d = (TextView) this.b.findViewById(com.baidu.tieba.v.zan_list_item_name);
        this.e = (TextView) this.b.findViewById(com.baidu.tieba.v.zan_list_item_time);
        this.f = (ImageView) this.b.findViewById(com.baidu.tieba.v.zan_list_item_line_bottom);
        this.f.setVisibility(0);
        this.b.setTag(this);
        this.g = new com.baidu.tbadk.editortool.ab(context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ c(b bVar, Context context, c cVar) {
        this(bVar, context);
    }

    public View a() {
        return this.b;
    }

    public void a(String str, String str2, long j, boolean z) {
        this.d.setText(str);
        this.c.setImageBitmap(null);
        this.e.setText(com.baidu.tbadk.core.util.bg.a(j));
        com.baidu.adp.widget.a.a c = this.g.c(str2);
        if (c != null) {
            c.a(this.c);
        } else if (!z) {
            this.c.setTag(str2);
            this.g.c(str2, new d(this));
        }
    }
}
