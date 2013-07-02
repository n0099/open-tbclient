package com.baidu.tieba.flist;

import android.view.View;
import android.widget.ImageView;
import com.baidu.tieba.model.ForumListModel;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    final /* synthetic */ ForumListActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(ForumListActivity forumListActivity) {
        this.a = forumListActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        f fVar;
        f fVar2;
        f fVar3;
        int i;
        z = this.a.p;
        if (z) {
            fVar = this.a.r;
            int min = Math.min(fVar.getCount(), 10);
            ForumListModel.Forum[] forumArr = new ForumListModel.Forum[min];
            fVar2 = this.a.r;
            System.arraycopy(fVar2.a(), 0, forumArr, 0, min);
            fVar3 = this.a.r;
            fVar3.a(forumArr);
            this.a.p = false;
            this.a.a.o.setText(this.a.getString(R.string.flist_expand_list));
            ImageView imageView = this.a.a.p;
            i = this.a.e;
            imageView.setImageResource(i);
            return;
        }
        new l(this.a, null).execute(new Void[0]);
    }
}
