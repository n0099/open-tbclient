package com.baidu.tieba.flist;

import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tieba.model.ForumListModel;
import com.baidu.tieba.model.ba;
import com.baidu.tieba.util.be;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements v {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ForumListActivity f1191a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(ForumListActivity forumListActivity) {
        this.f1191a = forumListActivity;
    }

    @Override // com.baidu.tieba.flist.v
    public void a(boolean z, int i, ForumListModel forumListModel, String str, boolean z2) {
        ForumListModel.RequestParams requestParams;
        ForumListModel.RequestParams requestParams2;
        int i2;
        ForumListModel.RequestParams requestParams3;
        int i3;
        boolean z3;
        ForumListModel.RequestParams requestParams4;
        int i4;
        q qVar;
        q qVar2;
        ba baVar;
        q qVar3;
        q qVar4;
        q qVar5;
        ba baVar2;
        q qVar6;
        int i5;
        int i6;
        q qVar7;
        ForumListModel.RequestParams requestParams5;
        be.e("ForunListActivity", "ForumListDetailCallBack", "callback start");
        if (!z) {
            qVar7 = this.f1191a.C;
            if (qVar7.a() == null) {
                be.e("ForunListActivity", "ForumListDetailCallBack", "isOk == false");
                this.f1191a.a(str);
                this.f1191a.c.d();
                this.f1191a.c.c();
                requestParams5 = this.f1191a.z;
                if (requestParams5.menu_type == 2 && !z2) {
                    this.f1191a.finish();
                }
                this.f1191a.c.A.setVisibility(8);
                return;
            }
        }
        if (forumListModel == null || forumListModel.recommend_list_left == null || forumListModel.recommend_list_right == null || forumListModel.editor_recommend == null || forumListModel.forum_class == null) {
            be.e("ForunListActivity", "ForumListDetailCallBack", "data null ec:" + i);
            requestParams = this.f1191a.z;
            if (requestParams.menu_type == 2 && !z2) {
                this.f1191a.a(this.f1191a.getString(R.string.no_forum_data));
                this.f1191a.finish();
            } else {
                this.f1191a.a(str);
                this.f1191a.c.c();
                requestParams2 = this.f1191a.z;
                i2 = this.f1191a.v;
                requestParams2.recommend_type = i2;
                requestParams3 = this.f1191a.z;
                i3 = this.f1191a.w;
                requestParams3.rn = i3;
            }
            this.f1191a.c.A.setVisibility(8);
            return;
        }
        this.f1191a.c.A.setVisibility(8);
        z3 = this.f1191a.u;
        if (z3) {
            this.f1191a.c.m.setText(this.f1191a.getString(R.string.flist_expand_list));
            ImageView imageView = this.f1191a.c.n;
            i5 = this.f1191a.m;
            imageView.setImageResource(i5);
            this.f1191a.c.p.setText(this.f1191a.getString(R.string.flist_expand_list));
            ImageView imageView2 = this.f1191a.c.q;
            i6 = this.f1191a.m;
            imageView2.setImageResource(i6);
            this.f1191a.u = false;
        }
        TextView textView = this.f1191a.c.g;
        requestParams4 = this.f1191a.z;
        textView.setText(requestParams4.menu_name);
        a aVar = this.f1191a.c.x;
        i4 = this.f1191a.t;
        aVar.a(i4);
        int min = Math.min(forumListModel.recommend_list_left.forum_list.length, this.f1191a.f1185a.forum_list.length);
        int min2 = Math.min(forumListModel.recommend_list_right.forum_list.length, this.f1191a.b.forum_list.length);
        System.arraycopy(forumListModel.recommend_list_left.forum_list, 0, this.f1191a.f1185a.forum_list, 0, min);
        System.arraycopy(forumListModel.recommend_list_right.forum_list, 0, this.f1191a.b.forum_list, 0, min2);
        qVar = this.f1191a.C;
        qVar.a(min);
        qVar2 = this.f1191a.C;
        baVar = this.f1191a.r;
        qVar2.a(baVar);
        qVar3 = this.f1191a.C;
        qVar3.a(this.f1191a.f1185a.forum_list);
        this.f1191a.c.h.setSelection(1);
        if (forumListModel.recommend_list_left.has_more == 1) {
            this.f1191a.c.f1206a.setVisibility(0);
        } else {
            this.f1191a.c.f1206a.setVisibility(8);
        }
        this.f1191a.c.j.setText(forumListModel.forum_class[0]);
        qVar4 = this.f1191a.D;
        qVar4.a(min2);
        qVar5 = this.f1191a.D;
        baVar2 = this.f1191a.r;
        qVar5.a(baVar2);
        qVar6 = this.f1191a.D;
        qVar6.a(this.f1191a.b.forum_list);
        this.f1191a.c.i.setSelection(1);
        if (forumListModel.recommend_list_right.has_more == 1) {
            this.f1191a.c.b.setVisibility(0);
        } else {
            this.f1191a.c.b.setVisibility(8);
        }
        this.f1191a.c.k.setText(forumListModel.forum_class[1]);
        this.f1191a.findViewById(R.id.item_root).setVisibility(0);
        this.f1191a.c.c();
    }
}
