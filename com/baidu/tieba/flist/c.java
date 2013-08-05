package com.baidu.tieba.flist;

import android.view.View;
import android.widget.ImageView;
import com.baidu.tieba.model.ForumListModel;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ForumListActivity f1039a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(ForumListActivity forumListActivity) {
        this.f1039a = forumListActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        e eVar;
        e eVar2;
        e eVar3;
        int i;
        z = this.f1039a.q;
        if (z) {
            eVar = this.f1039a.s;
            int min = Math.min(eVar.getCount(), 10);
            ForumListModel.Forum[] forumArr = new ForumListModel.Forum[min];
            eVar2 = this.f1039a.s;
            System.arraycopy(eVar2.a(), 0, forumArr, 0, min);
            eVar3 = this.f1039a.s;
            eVar3.a(forumArr);
            this.f1039a.q = false;
            this.f1039a.f1036a.p.setText(this.f1039a.getString(R.string.flist_expand_list));
            ImageView imageView = this.f1039a.f1036a.q;
            i = this.f1039a.e;
            imageView.setImageResource(i);
            return;
        }
        new j(this.f1039a, null).execute(new Void[0]);
    }
}
