package com.baidu.tieba.flist;

import android.view.View;
import android.widget.ImageView;
import com.baidu.tieba.model.ForumListModel;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ForumListActivity f814a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(ForumListActivity forumListActivity) {
        this.f814a = forumListActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        f fVar;
        f fVar2;
        int i;
        z = this.f814a.p;
        if (z) {
            ForumListModel.Forum[] forumArr = new ForumListModel.Forum[10];
            fVar = this.f814a.r;
            System.arraycopy(fVar.a(), 0, forumArr, 0, 10);
            fVar2 = this.f814a.r;
            fVar2.a(forumArr);
            this.f814a.p = false;
            this.f814a.f811a.o.setText(this.f814a.getString(R.string.flist_expand_list));
            ImageView imageView = this.f814a.f811a.p;
            i = this.f814a.e;
            imageView.setImageResource(i);
            return;
        }
        new l(this.f814a, null).execute(new Void[0]);
    }
}
