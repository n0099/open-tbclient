package com.baidu.tieba.forumdetail;

import android.content.Context;
import android.view.View;
import com.baidu.tieba.flist.ForumListActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements View.OnClickListener {
    final /* synthetic */ boolean a;
    final /* synthetic */ String b;
    final /* synthetic */ String c;
    final /* synthetic */ String d;
    final /* synthetic */ String e;
    final /* synthetic */ com.baidu.tieba.j f;
    final /* synthetic */ ItemInfoView g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(ItemInfoView itemInfoView, boolean z, String str, String str2, String str3, String str4, com.baidu.tieba.j jVar) {
        this.g = itemInfoView;
        this.a = z;
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.e = str4;
        this.f = jVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        if (!this.a) {
            context = this.g.a;
            ForumListActivity.a(context, this.b, this.d, this.c, this.e);
            return;
        }
        ForumListActivity.d = !ForumListActivity.d;
        ForumListActivity.a(this.b, this.c, this.d, this.e);
        this.f.finish();
    }
}
