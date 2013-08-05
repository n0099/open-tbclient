package com.baidu.tieba.flist;

import android.view.View;
import android.widget.ImageView;
import com.baidu.tieba.model.ForumListModel;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ForumListActivity f1038a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(ForumListActivity forumListActivity) {
        this.f1038a = forumListActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        e eVar;
        e eVar2;
        e eVar3;
        int i;
        z = this.f1038a.p;
        if (z) {
            eVar = this.f1038a.r;
            int min = Math.min(eVar.getCount(), 10);
            ForumListModel.Forum[] forumArr = new ForumListModel.Forum[min];
            eVar2 = this.f1038a.r;
            System.arraycopy(eVar2.a(), 0, forumArr, 0, min);
            eVar3 = this.f1038a.r;
            eVar3.a(forumArr);
            this.f1038a.p = false;
            this.f1038a.f1036a.m.setText(this.f1038a.getString(R.string.flist_expand_list));
            ImageView imageView = this.f1038a.f1036a.n;
            i = this.f1038a.e;
            imageView.setImageResource(i);
            return;
        }
        new k(this.f1038a, null).execute(new Void[0]);
    }
}
