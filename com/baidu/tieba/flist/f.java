package com.baidu.tieba.flist;

import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tieba.model.ForumListModel;
import com.baidu.tieba.model.aq;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class f implements u {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ForumListActivity f1041a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(ForumListActivity forumListActivity) {
        this.f1041a = forumListActivity;
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
        p pVar;
        p pVar2;
        aq aqVar;
        p pVar3;
        p pVar4;
        p pVar5;
        aq aqVar2;
        p pVar6;
        int i5;
        int i6;
        p pVar7;
        ForumListModel.RequestParams requestParams5;
        com.baidu.tieba.util.aq.e("ForunListActivity", "ForumListDetailCallBack", "callback start");
        if (!z) {
            pVar7 = this.f1041a.A;
            if (pVar7.a() == null) {
                com.baidu.tieba.util.aq.e("ForunListActivity", "ForumListDetailCallBack", "isOk == false");
                this.f1041a.a(str);
                this.f1041a.c.d();
                this.f1041a.c.c();
                requestParams5 = this.f1041a.x;
                if (requestParams5.menu_type == 2 && !z2) {
                    this.f1041a.finish();
                    return;
                }
                return;
            }
        }
        if (forumListModel != null && forumListModel.recommend_list_left != null && forumListModel.recommend_list_right != null && forumListModel.editor_recommend != null && forumListModel.forum_class != null) {
            z3 = this.f1041a.t;
            if (z3) {
                this.f1041a.c.m.setText(this.f1041a.getString(R.string.flist_expand_list));
                ImageView imageView = this.f1041a.c.n;
                i5 = this.f1041a.l;
                imageView.setImageResource(i5);
                this.f1041a.c.p.setText(this.f1041a.getString(R.string.flist_expand_list));
                ImageView imageView2 = this.f1041a.c.q;
                i6 = this.f1041a.l;
                imageView2.setImageResource(i6);
                this.f1041a.t = false;
            }
            TextView textView = this.f1041a.c.g;
            requestParams4 = this.f1041a.x;
            textView.setText(requestParams4.menu_name);
            a aVar = this.f1041a.c.x;
            i4 = this.f1041a.s;
            aVar.a(i4);
            System.arraycopy(forumListModel.recommend_list_left.forum_list, 0, this.f1041a.f1036a.forum_list, 0, forumListModel.recommend_list_left.forum_list.length);
            System.arraycopy(forumListModel.recommend_list_right.forum_list, 0, this.f1041a.b.forum_list, 0, forumListModel.recommend_list_right.forum_list.length);
            pVar = this.f1041a.A;
            pVar.a(forumListModel.recommend_list_left.forum_list.length);
            pVar2 = this.f1041a.A;
            aqVar = this.f1041a.q;
            pVar2.a(aqVar);
            pVar3 = this.f1041a.A;
            pVar3.a(this.f1041a.f1036a.forum_list);
            if (forumListModel.recommend_list_left.has_more == 1) {
                this.f1041a.c.f1057a.setVisibility(0);
            } else {
                this.f1041a.c.f1057a.setVisibility(8);
            }
            this.f1041a.c.j.setText(forumListModel.forum_class[0]);
            pVar4 = this.f1041a.B;
            pVar4.a(forumListModel.recommend_list_right.forum_list.length);
            pVar5 = this.f1041a.B;
            aqVar2 = this.f1041a.q;
            pVar5.a(aqVar2);
            pVar6 = this.f1041a.B;
            pVar6.a(this.f1041a.b.forum_list);
            if (forumListModel.recommend_list_right.has_more == 1) {
                this.f1041a.c.b.setVisibility(0);
            } else {
                this.f1041a.c.b.setVisibility(8);
            }
            this.f1041a.c.k.setText(forumListModel.forum_class[1]);
            this.f1041a.findViewById(R.id.item_root).setVisibility(0);
            this.f1041a.c.c();
            return;
        }
        com.baidu.tieba.util.aq.e("ForunListActivity", "ForumListDetailCallBack", "data null ec:" + i);
        requestParams = this.f1041a.x;
        if (requestParams.menu_type == 2 && !z2) {
            this.f1041a.a(this.f1041a.getString(R.string.no_forum_data));
            this.f1041a.finish();
            return;
        }
        this.f1041a.a(str);
        this.f1041a.c.c();
        requestParams2 = this.f1041a.x;
        i2 = this.f1041a.u;
        requestParams2.recommend_type = i2;
        requestParams3 = this.f1041a.x;
        i3 = this.f1041a.v;
        requestParams3.rn = i3;
    }
}
