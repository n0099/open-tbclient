package com.baidu.tieba.flist;

import android.os.Handler;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tieba.flist.ForumListModel;
/* loaded from: classes.dex */
class f implements u {
    final /* synthetic */ ForumListActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(ForumListActivity forumListActivity) {
        this.a = forumListActivity;
    }

    @Override // com.baidu.tieba.flist.u
    public void a(boolean z, int i, ForumListModel forumListModel, String str, boolean z2) {
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
        com.baidu.tieba.model.ae aeVar;
        r rVar3;
        r rVar4;
        r rVar5;
        com.baidu.tieba.model.ae aeVar2;
        r rVar6;
        Handler handler;
        Runnable runnable;
        Handler handler2;
        Runnable runnable2;
        int i5;
        int i6;
        r rVar7;
        ForumListModel.RequestParams requestParams5;
        if (!z) {
            rVar7 = this.a.D;
            if (rVar7.a() == null) {
                this.a.showToast(str);
                this.a.c.d();
                this.a.c.c();
                requestParams5 = this.a.A;
                if (requestParams5.menu_type == 2 && !z2) {
                    this.a.finish();
                }
                this.a.c.B.setVisibility(8);
                return;
            }
        }
        if (forumListModel == null || forumListModel.recommend_list_left == null || forumListModel.recommend_list_right == null || forumListModel.editor_recommend == null || forumListModel.forum_class == null) {
            requestParams = this.a.A;
            if (requestParams.menu_type == 2 && !z2) {
                this.a.showToast(this.a.getString(com.baidu.tieba.y.no_forum_data));
                this.a.finish();
            } else {
                this.a.showToast(str);
                this.a.c.c();
                requestParams2 = this.a.A;
                i2 = this.a.v;
                requestParams2.recommend_type = i2;
                requestParams3 = this.a.A;
                i3 = this.a.w;
                requestParams3.rn = i3;
            }
            this.a.c.B.setVisibility(8);
            return;
        }
        this.a.c.B.setVisibility(8);
        z3 = this.a.u;
        if (z3) {
            this.a.c.n.setText(this.a.getString(com.baidu.tieba.y.flist_expand_list));
            ImageView imageView = this.a.c.o;
            i5 = this.a.l;
            imageView.setImageResource(i5);
            this.a.c.q.setText(this.a.getString(com.baidu.tieba.y.flist_expand_list));
            ImageView imageView2 = this.a.c.r;
            i6 = this.a.l;
            imageView2.setImageResource(i6);
            this.a.u = false;
        }
        TextView textView = this.a.c.h;
        requestParams4 = this.a.A;
        textView.setText(requestParams4.menu_name);
        a aVar = this.a.c.y;
        i4 = this.a.t;
        aVar.a(i4);
        int min = Math.min(forumListModel.recommend_list_left.forum_list.length, this.a.a.forum_list.length);
        int min2 = Math.min(forumListModel.recommend_list_right.forum_list.length, this.a.b.forum_list.length);
        System.arraycopy(forumListModel.recommend_list_left.forum_list, 0, this.a.a.forum_list, 0, min);
        System.arraycopy(forumListModel.recommend_list_right.forum_list, 0, this.a.b.forum_list, 0, min2);
        rVar = this.a.D;
        rVar.a(min);
        rVar2 = this.a.D;
        aeVar = this.a.q;
        rVar2.a(aeVar);
        rVar3 = this.a.D;
        rVar3.a(this.a.a.forum_list);
        this.a.c.i.setSelection(1);
        if (forumListModel.recommend_list_left.has_more == 1) {
            this.a.c.b.setVisibility(0);
        } else {
            this.a.c.b.setVisibility(8);
        }
        this.a.c.k.setText(forumListModel.forum_class[0]);
        rVar4 = this.a.E;
        rVar4.a(min2);
        rVar5 = this.a.E;
        aeVar2 = this.a.q;
        rVar5.a(aeVar2);
        rVar6 = this.a.E;
        rVar6.a(this.a.b.forum_list);
        this.a.c.j.setSelection(1);
        if (forumListModel.recommend_list_right.has_more == 1) {
            this.a.c.c.setVisibility(0);
        } else {
            this.a.c.c.setVisibility(8);
        }
        this.a.c.l.setText(forumListModel.forum_class[1]);
        this.a.findViewById(com.baidu.tieba.v.item_root).setVisibility(0);
        this.a.c.c();
        if (this.a.c.y.getCount() > 0) {
            this.a.c.z.setClickable(true);
            this.a.c.z.setOnClickListener(this.a);
        }
        handler = this.a.e;
        runnable = this.a.P;
        handler.removeCallbacks(runnable);
        handler2 = this.a.e;
        runnable2 = this.a.P;
        handler2.post(runnable2);
    }
}
