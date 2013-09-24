package com.baidu.tieba.flist;

import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tieba.model.ForumListModel;
import com.baidu.tieba.model.as;
import com.baidu.tieba.util.av;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class f implements u {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ForumListActivity f1058a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(ForumListActivity forumListActivity) {
        this.f1058a = forumListActivity;
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
        as asVar;
        p pVar3;
        p pVar4;
        p pVar5;
        as asVar2;
        p pVar6;
        int i5;
        int i6;
        p pVar7;
        ForumListModel.RequestParams requestParams5;
        av.e("ForunListActivity", "ForumListDetailCallBack", "callback start");
        if (!z) {
            pVar7 = this.f1058a.C;
            if (pVar7.a() == null) {
                av.e("ForunListActivity", "ForumListDetailCallBack", "isOk == false");
                this.f1058a.a(str);
                this.f1058a.c.d();
                this.f1058a.c.c();
                requestParams5 = this.f1058a.z;
                if (requestParams5.menu_type == 2 && !z2) {
                    this.f1058a.finish();
                }
                this.f1058a.c.A.setVisibility(8);
                return;
            }
        }
        if (forumListModel == null || forumListModel.recommend_list_left == null || forumListModel.recommend_list_right == null || forumListModel.editor_recommend == null || forumListModel.forum_class == null) {
            av.e("ForunListActivity", "ForumListDetailCallBack", "data null ec:" + i);
            requestParams = this.f1058a.z;
            if (requestParams.menu_type == 2 && !z2) {
                this.f1058a.a(this.f1058a.getString(R.string.no_forum_data));
                this.f1058a.finish();
            } else {
                this.f1058a.a(str);
                this.f1058a.c.c();
                requestParams2 = this.f1058a.z;
                i2 = this.f1058a.v;
                requestParams2.recommend_type = i2;
                requestParams3 = this.f1058a.z;
                i3 = this.f1058a.w;
                requestParams3.rn = i3;
            }
            this.f1058a.c.A.setVisibility(8);
            return;
        }
        this.f1058a.c.A.setVisibility(8);
        z3 = this.f1058a.u;
        if (z3) {
            this.f1058a.c.m.setText(this.f1058a.getString(R.string.flist_expand_list));
            ImageView imageView = this.f1058a.c.n;
            i5 = this.f1058a.m;
            imageView.setImageResource(i5);
            this.f1058a.c.p.setText(this.f1058a.getString(R.string.flist_expand_list));
            ImageView imageView2 = this.f1058a.c.q;
            i6 = this.f1058a.m;
            imageView2.setImageResource(i6);
            this.f1058a.u = false;
        }
        TextView textView = this.f1058a.c.g;
        requestParams4 = this.f1058a.z;
        textView.setText(requestParams4.menu_name);
        a aVar = this.f1058a.c.x;
        i4 = this.f1058a.t;
        aVar.a(i4);
        int min = Math.min(forumListModel.recommend_list_left.forum_list.length, this.f1058a.f1053a.forum_list.length);
        int min2 = Math.min(forumListModel.recommend_list_right.forum_list.length, this.f1058a.b.forum_list.length);
        System.arraycopy(forumListModel.recommend_list_left.forum_list, 0, this.f1058a.f1053a.forum_list, 0, min);
        System.arraycopy(forumListModel.recommend_list_right.forum_list, 0, this.f1058a.b.forum_list, 0, min2);
        pVar = this.f1058a.C;
        pVar.a(min);
        pVar2 = this.f1058a.C;
        asVar = this.f1058a.r;
        pVar2.a(asVar);
        pVar3 = this.f1058a.C;
        pVar3.a(this.f1058a.f1053a.forum_list);
        this.f1058a.c.h.setSelection(1);
        if (forumListModel.recommend_list_left.has_more == 1) {
            this.f1058a.c.f1074a.setVisibility(0);
        } else {
            this.f1058a.c.f1074a.setVisibility(8);
        }
        this.f1058a.c.j.setText(forumListModel.forum_class[0]);
        pVar4 = this.f1058a.D;
        pVar4.a(min2);
        pVar5 = this.f1058a.D;
        asVar2 = this.f1058a.r;
        pVar5.a(asVar2);
        pVar6 = this.f1058a.D;
        pVar6.a(this.f1058a.b.forum_list);
        this.f1058a.c.i.setSelection(1);
        if (forumListModel.recommend_list_right.has_more == 1) {
            this.f1058a.c.b.setVisibility(0);
        } else {
            this.f1058a.c.b.setVisibility(8);
        }
        this.f1058a.c.k.setText(forumListModel.forum_class[1]);
        this.f1058a.findViewById(R.id.item_root).setVisibility(0);
        this.f1058a.c.c();
    }
}
