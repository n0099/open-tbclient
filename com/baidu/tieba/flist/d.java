package com.baidu.tieba.flist;

import android.view.View;
import android.widget.ImageView;
import com.baidu.tieba.model.ForumListModel;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    final /* synthetic */ ForumListActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(ForumListActivity forumListActivity) {
        this.a = forumListActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        f fVar;
        f fVar2;
        f fVar3;
        int i;
        z = this.a.q;
        if (z) {
            fVar = this.a.s;
            int min = Math.min(fVar.getCount(), 10);
            ForumListModel.Forum[] forumArr = new ForumListModel.Forum[min];
            fVar2 = this.a.s;
            System.arraycopy(fVar2.a(), 0, forumArr, 0, min);
            fVar3 = this.a.s;
            fVar3.a(forumArr);
            this.a.q = false;
            this.a.a.r.setText(this.a.getString(R.string.flist_expand_list));
            ImageView imageView = this.a.a.s;
            i = this.a.e;
            imageView.setImageResource(i);
            return;
        }
        new k(this.a, null).execute(new Void[0]);
    }
}
