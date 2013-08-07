package com.baidu.tieba.flist;

import android.view.View;
import android.widget.ImageView;
import com.baidu.tieba.model.ForumListModel;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ForumListActivity f1036a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(ForumListActivity forumListActivity) {
        this.f1036a = forumListActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        e eVar;
        e eVar2;
        e eVar3;
        int i;
        z = this.f1036a.p;
        if (z) {
            eVar = this.f1036a.r;
            int min = Math.min(eVar.getCount(), 10);
            ForumListModel.Forum[] forumArr = new ForumListModel.Forum[min];
            eVar2 = this.f1036a.r;
            System.arraycopy(eVar2.a(), 0, forumArr, 0, min);
            eVar3 = this.f1036a.r;
            eVar3.a(forumArr);
            this.f1036a.p = false;
            this.f1036a.f1034a.m.setText(this.f1036a.getString(R.string.flist_expand_list));
            ImageView imageView = this.f1036a.f1034a.n;
            i = this.f1036a.e;
            imageView.setImageResource(i);
            return;
        }
        new k(this.f1036a, null).execute(new Void[0]);
    }
}
