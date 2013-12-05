package com.baidu.tieba.flist;

import android.os.Handler;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tieba.flist.ForumListModel;
import com.baidu.tieba.model.ax;
import com.baidu.tieba.util.bd;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements w {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ForumListActivity f1301a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(ForumListActivity forumListActivity) {
        this.f1301a = forumListActivity;
    }

    @Override // com.baidu.tieba.flist.w
    public void a(boolean z, int i, ForumListModel forumListModel, String str, boolean z2) {
        ForumListModel.RequestParams requestParams;
        ForumListModel.RequestParams requestParams2;
        int i2;
        ForumListModel.RequestParams requestParams3;
        int i3;
        boolean z3;
        ForumListModel.RequestParams requestParams4;
        int i4;
        s sVar;
        s sVar2;
        ax axVar;
        s sVar3;
        s sVar4;
        s sVar5;
        ax axVar2;
        s sVar6;
        Handler handler;
        Runnable runnable;
        Handler handler2;
        Runnable runnable2;
        int i5;
        int i6;
        s sVar7;
        ForumListModel.RequestParams requestParams5;
        bd.e("ForunListActivity", "ForumListDetailCallBack", "callback start");
        if (!z) {
            sVar7 = this.f1301a.D;
            if (sVar7.a() == null) {
                bd.e("ForunListActivity", "ForumListDetailCallBack", "isOk == false");
                this.f1301a.showToast(str);
                this.f1301a.c.d();
                this.f1301a.c.c();
                requestParams5 = this.f1301a.A;
                if (requestParams5.menu_type == 2 && !z2) {
                    this.f1301a.finish();
                }
                this.f1301a.c.A.setVisibility(8);
                return;
            }
        }
        if (forumListModel == null || forumListModel.recommend_list_left == null || forumListModel.recommend_list_right == null || forumListModel.editor_recommend == null || forumListModel.forum_class == null) {
            bd.e("ForunListActivity", "ForumListDetailCallBack", "data null ec:" + i);
            requestParams = this.f1301a.A;
            if (requestParams.menu_type == 2 && !z2) {
                this.f1301a.showToast(this.f1301a.getString(R.string.no_forum_data));
                this.f1301a.finish();
            } else {
                this.f1301a.showToast(str);
                this.f1301a.c.c();
                requestParams2 = this.f1301a.A;
                i2 = this.f1301a.v;
                requestParams2.recommend_type = i2;
                requestParams3 = this.f1301a.A;
                i3 = this.f1301a.w;
                requestParams3.rn = i3;
            }
            this.f1301a.c.A.setVisibility(8);
            return;
        }
        this.f1301a.c.A.setVisibility(8);
        z3 = this.f1301a.u;
        if (z3) {
            this.f1301a.c.m.setText(this.f1301a.getString(R.string.flist_expand_list));
            ImageView imageView = this.f1301a.c.n;
            i5 = this.f1301a.l;
            imageView.setImageResource(i5);
            this.f1301a.c.p.setText(this.f1301a.getString(R.string.flist_expand_list));
            ImageView imageView2 = this.f1301a.c.q;
            i6 = this.f1301a.l;
            imageView2.setImageResource(i6);
            this.f1301a.u = false;
        }
        TextView textView = this.f1301a.c.g;
        requestParams4 = this.f1301a.A;
        textView.setText(requestParams4.menu_name);
        a aVar = this.f1301a.c.x;
        i4 = this.f1301a.t;
        aVar.a(i4);
        int min = Math.min(forumListModel.recommend_list_left.forum_list.length, this.f1301a.f1284a.forum_list.length);
        int min2 = Math.min(forumListModel.recommend_list_right.forum_list.length, this.f1301a.b.forum_list.length);
        System.arraycopy(forumListModel.recommend_list_left.forum_list, 0, this.f1301a.f1284a.forum_list, 0, min);
        System.arraycopy(forumListModel.recommend_list_right.forum_list, 0, this.f1301a.b.forum_list, 0, min2);
        sVar = this.f1301a.D;
        sVar.a(min);
        sVar2 = this.f1301a.D;
        axVar = this.f1301a.q;
        sVar2.a(axVar);
        sVar3 = this.f1301a.D;
        sVar3.a(this.f1301a.f1284a.forum_list);
        this.f1301a.c.h.setSelection(1);
        if (forumListModel.recommend_list_left.has_more == 1) {
            this.f1301a.c.b.setVisibility(0);
        } else {
            this.f1301a.c.b.setVisibility(8);
        }
        this.f1301a.c.j.setText(forumListModel.forum_class[0]);
        sVar4 = this.f1301a.E;
        sVar4.a(min2);
        sVar5 = this.f1301a.E;
        axVar2 = this.f1301a.q;
        sVar5.a(axVar2);
        sVar6 = this.f1301a.E;
        sVar6.a(this.f1301a.b.forum_list);
        this.f1301a.c.i.setSelection(1);
        if (forumListModel.recommend_list_right.has_more == 1) {
            this.f1301a.c.c.setVisibility(0);
        } else {
            this.f1301a.c.c.setVisibility(8);
        }
        this.f1301a.c.k.setText(forumListModel.forum_class[1]);
        this.f1301a.findViewById(R.id.item_root).setVisibility(0);
        this.f1301a.c.c();
        if (this.f1301a.c.x.getCount() > 0) {
            this.f1301a.c.y.setClickable(true);
            this.f1301a.c.y.setOnClickListener(this.f1301a);
        }
        handler = this.f1301a.e;
        runnable = this.f1301a.P;
        handler.removeCallbacks(runnable);
        handler2 = this.f1301a.e;
        runnable2 = this.f1301a.P;
        handler2.post(runnable2);
    }
}
