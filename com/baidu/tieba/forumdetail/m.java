package com.baidu.tieba.forumdetail;

import android.content.Context;
import android.view.View;
import com.baidu.tieba.flist.ForumListActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements View.OnClickListener {
    final /* synthetic */ ItemInfoView a;
    private final /* synthetic */ boolean b;
    private final /* synthetic */ String c;
    private final /* synthetic */ String d;
    private final /* synthetic */ String e;
    private final /* synthetic */ String f;
    private final /* synthetic */ com.baidu.tieba.f g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(ItemInfoView itemInfoView, boolean z, String str, String str2, String str3, String str4, com.baidu.tieba.f fVar) {
        this.a = itemInfoView;
        this.b = z;
        this.c = str;
        this.d = str2;
        this.e = str3;
        this.f = str4;
        this.g = fVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        if (!this.b) {
            context = this.a.a;
            ForumListActivity.a(context, this.c, this.e, this.d, this.f);
            return;
        }
        ForumListActivity.d = !ForumListActivity.d;
        ForumListActivity.a(this.c, this.d, this.e, this.f);
        this.g.finish();
    }
}
