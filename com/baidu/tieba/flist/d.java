package com.baidu.tieba.flist;

import android.view.View;
import android.widget.ImageView;
import com.baidu.tieba.model.ForumListModel;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ForumListActivity f815a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(ForumListActivity forumListActivity) {
        this.f815a = forumListActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        f fVar;
        f fVar2;
        int i;
        z = this.f815a.q;
        if (z) {
            ForumListModel.Forum[] forumArr = new ForumListModel.Forum[10];
            fVar = this.f815a.s;
            System.arraycopy(fVar.a(), 0, forumArr, 0, 10);
            fVar2 = this.f815a.s;
            fVar2.a(forumArr);
            this.f815a.q = false;
            this.f815a.f811a.r.setText(this.f815a.getString(R.string.flist_expand_list));
            ImageView imageView = this.f815a.f811a.s;
            i = this.f815a.e;
            imageView.setImageResource(i);
            return;
        }
        new k(this.f815a, null).execute(new Void[0]);
    }
}
