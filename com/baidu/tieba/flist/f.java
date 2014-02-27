package com.baidu.tieba.flist;

import android.os.Handler;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tieba.flist.ForumListModel;
import com.baidu.tieba.model.ar;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
final class f implements u {
    final /* synthetic */ ForumListActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(ForumListActivity forumListActivity) {
        this.a = forumListActivity;
    }

    @Override // com.baidu.tieba.flist.u
    public final void a(boolean z, int i, ForumListModel forumListModel, String str, boolean z2) {
        ForumListModel.RequestParams requestParams;
        ForumListModel.RequestParams requestParams2;
        int i2;
        ForumListModel.RequestParams requestParams3;
        int i3;
        boolean z3;
        ForumListModel.RequestParams requestParams4;
        int i4;
        r rVar;
        r rVar2;
        ar arVar;
        r rVar3;
        r rVar4;
        r rVar5;
        ar arVar2;
        r rVar6;
        Handler handler;
        Runnable runnable;
        Handler handler2;
        Runnable runnable2;
        int i5;
        int i6;
        r rVar7;
        ForumListModel.RequestParams requestParams5;
        com.baidu.adp.lib.util.e.e("ForunListActivity", "ForumListDetailCallBack", "callback start");
        if (!z) {
            rVar7 = this.a.D;
            if (rVar7.a() == null) {
                com.baidu.adp.lib.util.e.e("ForunListActivity", "ForumListDetailCallBack", "isOk == false");
                this.a.showToast(str);
                this.a.c.b();
                this.a.c.a();
                requestParams5 = this.a.A;
                if (requestParams5.menu_type == 2 && !z2) {
                    this.a.finish();
                }
                this.a.c.A.setVisibility(8);
                return;
            }
        }
        if (forumListModel == null || forumListModel.recommend_list_left == null || forumListModel.recommend_list_right == null || forumListModel.editor_recommend == null || forumListModel.forum_class == null) {
            com.baidu.adp.lib.util.e.e("ForunListActivity", "ForumListDetailCallBack", "data null ec:" + i);
            requestParams = this.a.A;
            if (requestParams.menu_type == 2 && !z2) {
                this.a.showToast(this.a.getString(R.string.no_forum_data));
                this.a.finish();
            } else {
                this.a.showToast(str);
                this.a.c.a();
                requestParams2 = this.a.A;
                i2 = this.a.v;
                requestParams2.recommend_type = i2;
                requestParams3 = this.a.A;
                i3 = this.a.w;
                requestParams3.rn = i3;
            }
            this.a.c.A.setVisibility(8);
            return;
        }
        this.a.c.A.setVisibility(8);
        z3 = this.a.u;
        if (z3) {
            this.a.c.m.setText(this.a.getString(R.string.flist_expand_list));
            ImageView imageView = this.a.c.n;
            i5 = this.a.l;
            imageView.setImageResource(i5);
            this.a.c.p.setText(this.a.getString(R.string.flist_expand_list));
            ImageView imageView2 = this.a.c.q;
            i6 = this.a.l;
            imageView2.setImageResource(i6);
            this.a.u = false;
        }
        TextView textView = this.a.c.g;
        requestParams4 = this.a.A;
        textView.setText(requestParams4.menu_name);
        a aVar = this.a.c.x;
        i4 = this.a.t;
        aVar.a(i4);
        int min = Math.min(forumListModel.recommend_list_left.forum_list.length, this.a.a.forum_list.length);
        int min2 = Math.min(forumListModel.recommend_list_right.forum_list.length, this.a.b.forum_list.length);
        System.arraycopy(forumListModel.recommend_list_left.forum_list, 0, this.a.a.forum_list, 0, min);
        System.arraycopy(forumListModel.recommend_list_right.forum_list, 0, this.a.b.forum_list, 0, min2);
        rVar = this.a.D;
        rVar.a(min);
        rVar2 = this.a.D;
        arVar = this.a.q;
        rVar2.a(arVar);
        rVar3 = this.a.D;
        rVar3.a(this.a.a.forum_list);
        this.a.c.h.setSelection(1);
        if (forumListModel.recommend_list_left.has_more == 1) {
            this.a.c.b.setVisibility(0);
        } else {
            this.a.c.b.setVisibility(8);
        }
        this.a.c.j.setText(forumListModel.forum_class[0]);
        rVar4 = this.a.E;
        rVar4.a(min2);
        rVar5 = this.a.E;
        arVar2 = this.a.q;
        rVar5.a(arVar2);
        rVar6 = this.a.E;
        rVar6.a(this.a.b.forum_list);
        this.a.c.i.setSelection(1);
        if (forumListModel.recommend_list_right.has_more == 1) {
            this.a.c.c.setVisibility(0);
        } else {
            this.a.c.c.setVisibility(8);
        }
        this.a.c.k.setText(forumListModel.forum_class[1]);
        this.a.findViewById(R.id.item_root).setVisibility(0);
        this.a.c.a();
        if (this.a.c.x.getCount() > 0) {
            this.a.c.y.setClickable(true);
            this.a.c.y.setOnClickListener(this.a);
        }
        handler = this.a.e;
        runnable = this.a.P;
        handler.removeCallbacks(runnable);
        handler2 = this.a.e;
        runnable2 = this.a.P;
        handler2.post(runnable2);
    }
}
