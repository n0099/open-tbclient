package com.baidu.tieba.flist;

import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tieba.flist.ForumListModel;
import com.baidu.tieba.model.af;
/* loaded from: classes.dex */
class f implements s {
    final /* synthetic */ ForumListActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(ForumListActivity forumListActivity) {
        this.a = forumListActivity;
    }

    @Override // com.baidu.tieba.flist.s
    public void a(boolean z, int i, ForumListModel forumListModel, String str, boolean z2) {
        ForumListModel.RequestParams requestParams;
        ForumListModel.RequestParams requestParams2;
        int i2;
        ForumListModel.RequestParams requestParams3;
        int i3;
        boolean z3;
        ForumListModel.RequestParams requestParams4;
        int i4;
        p pVar;
        p pVar2;
        af afVar;
        p pVar3;
        p pVar4;
        p pVar5;
        af afVar2;
        p pVar6;
        int i5;
        int i6;
        p pVar7;
        ForumListModel.RequestParams requestParams5;
        if (!z) {
            pVar7 = this.a.A;
            if (pVar7.a() == null) {
                this.a.showToast(str);
                this.a.c.d();
                this.a.c.c();
                requestParams5 = this.a.x;
                if (requestParams5.menu_type == 2 && !z2) {
                    this.a.finish();
                }
                this.a.c.B.setVisibility(8);
                return;
            }
        }
        if (forumListModel == null || forumListModel.recommend_list_left == null || forumListModel.recommend_list_right == null || forumListModel.editor_recommend == null || forumListModel.forum_class == null) {
            requestParams = this.a.x;
            if (requestParams.menu_type == 2 && !z2) {
                this.a.showToast(this.a.getString(com.baidu.tieba.x.no_forum_data));
                this.a.finish();
            } else {
                this.a.showToast(str);
                this.a.c.c();
                requestParams2 = this.a.x;
                i2 = this.a.t;
                requestParams2.recommend_type = i2;
                requestParams3 = this.a.x;
                i3 = this.a.u;
                requestParams3.rn = i3;
            }
            this.a.c.B.setVisibility(8);
            return;
        }
        this.a.c.B.setVisibility(8);
        z3 = this.a.s;
        if (z3) {
            this.a.c.n.setText(this.a.getString(com.baidu.tieba.x.flist_expand_list));
            ImageView imageView = this.a.c.o;
            i5 = this.a.k;
            imageView.setImageResource(i5);
            this.a.c.q.setText(this.a.getString(com.baidu.tieba.x.flist_expand_list));
            ImageView imageView2 = this.a.c.r;
            i6 = this.a.k;
            imageView2.setImageResource(i6);
            this.a.s = false;
        }
        TextView textView = this.a.c.h;
        requestParams4 = this.a.x;
        textView.setText(requestParams4.menu_name);
        a aVar = this.a.c.y;
        i4 = this.a.r;
        aVar.a(i4);
        int min = Math.min(forumListModel.recommend_list_left.forum_list.length, this.a.a.forum_list.length);
        int min2 = Math.min(forumListModel.recommend_list_right.forum_list.length, this.a.b.forum_list.length);
        System.arraycopy(forumListModel.recommend_list_left.forum_list, 0, this.a.a.forum_list, 0, min);
        System.arraycopy(forumListModel.recommend_list_right.forum_list, 0, this.a.b.forum_list, 0, min2);
        pVar = this.a.A;
        pVar.a(min);
        pVar2 = this.a.A;
        afVar = this.a.p;
        pVar2.a(afVar);
        pVar3 = this.a.A;
        pVar3.a(this.a.a.forum_list);
        this.a.c.i.setSelection(1);
        if (forumListModel.recommend_list_left.has_more == 1) {
            this.a.c.b.setVisibility(0);
        } else {
            this.a.c.b.setVisibility(8);
        }
        this.a.c.k.setText(forumListModel.forum_class[0]);
        pVar4 = this.a.B;
        pVar4.a(min2);
        pVar5 = this.a.B;
        afVar2 = this.a.p;
        pVar5.a(afVar2);
        pVar6 = this.a.B;
        pVar6.a(this.a.b.forum_list);
        this.a.c.j.setSelection(1);
        if (forumListModel.recommend_list_right.has_more == 1) {
            this.a.c.c.setVisibility(0);
        } else {
            this.a.c.c.setVisibility(8);
        }
        this.a.c.l.setText(forumListModel.forum_class[1]);
        this.a.findViewById(com.baidu.tieba.u.item_root).setVisibility(0);
        this.a.c.c();
        if (this.a.c.y.getCount() > 0) {
            this.a.c.z.setClickable(true);
            this.a.c.z.setOnClickListener(this.a);
        }
    }
}
