package com.baidu.tieba.flist;

import android.os.Handler;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tieba.flist.ForumListModel;
import com.baidu.tieba.model.ax;
import com.baidu.tieba.util.bg;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements w {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ForumListActivity f1254a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(ForumListActivity forumListActivity) {
        this.f1254a = forumListActivity;
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
        bg.e("ForunListActivity", "ForumListDetailCallBack", "callback start");
        if (!z) {
            sVar7 = this.f1254a.D;
            if (sVar7.a() == null) {
                bg.e("ForunListActivity", "ForumListDetailCallBack", "isOk == false");
                this.f1254a.showToast(str);
                this.f1254a.c.d();
                this.f1254a.c.c();
                requestParams5 = this.f1254a.A;
                if (requestParams5.menu_type == 2 && !z2) {
                    this.f1254a.finish();
                }
                this.f1254a.c.z.setVisibility(8);
                return;
            }
        }
        if (forumListModel == null || forumListModel.recommend_list_left == null || forumListModel.recommend_list_right == null || forumListModel.editor_recommend == null || forumListModel.forum_class == null) {
            bg.e("ForunListActivity", "ForumListDetailCallBack", "data null ec:" + i);
            requestParams = this.f1254a.A;
            if (requestParams.menu_type == 2 && !z2) {
                this.f1254a.showToast(this.f1254a.getString(R.string.no_forum_data));
                this.f1254a.finish();
            } else {
                this.f1254a.showToast(str);
                this.f1254a.c.c();
                requestParams2 = this.f1254a.A;
                i2 = this.f1254a.v;
                requestParams2.recommend_type = i2;
                requestParams3 = this.f1254a.A;
                i3 = this.f1254a.w;
                requestParams3.rn = i3;
            }
            this.f1254a.c.z.setVisibility(8);
            return;
        }
        this.f1254a.c.z.setVisibility(8);
        z3 = this.f1254a.u;
        if (z3) {
            this.f1254a.c.l.setText(this.f1254a.getString(R.string.flist_expand_list));
            ImageView imageView = this.f1254a.c.m;
            i5 = this.f1254a.l;
            imageView.setImageResource(i5);
            this.f1254a.c.o.setText(this.f1254a.getString(R.string.flist_expand_list));
            ImageView imageView2 = this.f1254a.c.p;
            i6 = this.f1254a.l;
            imageView2.setImageResource(i6);
            this.f1254a.u = false;
        }
        TextView textView = this.f1254a.c.f;
        requestParams4 = this.f1254a.A;
        textView.setText(requestParams4.menu_name);
        a aVar = this.f1254a.c.w;
        i4 = this.f1254a.t;
        aVar.a(i4);
        int min = Math.min(forumListModel.recommend_list_left.forum_list.length, this.f1254a.f1237a.forum_list.length);
        int min2 = Math.min(forumListModel.recommend_list_right.forum_list.length, this.f1254a.b.forum_list.length);
        System.arraycopy(forumListModel.recommend_list_left.forum_list, 0, this.f1254a.f1237a.forum_list, 0, min);
        System.arraycopy(forumListModel.recommend_list_right.forum_list, 0, this.f1254a.b.forum_list, 0, min2);
        sVar = this.f1254a.D;
        sVar.a(min);
        sVar2 = this.f1254a.D;
        axVar = this.f1254a.q;
        sVar2.a(axVar);
        sVar3 = this.f1254a.D;
        sVar3.a(this.f1254a.f1237a.forum_list);
        this.f1254a.c.g.setSelection(1);
        if (forumListModel.recommend_list_left.has_more == 1) {
            this.f1254a.c.f1270a.setVisibility(0);
        } else {
            this.f1254a.c.f1270a.setVisibility(8);
        }
        this.f1254a.c.i.setText(forumListModel.forum_class[0]);
        sVar4 = this.f1254a.E;
        sVar4.a(min2);
        sVar5 = this.f1254a.E;
        axVar2 = this.f1254a.q;
        sVar5.a(axVar2);
        sVar6 = this.f1254a.E;
        sVar6.a(this.f1254a.b.forum_list);
        this.f1254a.c.h.setSelection(1);
        if (forumListModel.recommend_list_right.has_more == 1) {
            this.f1254a.c.b.setVisibility(0);
        } else {
            this.f1254a.c.b.setVisibility(8);
        }
        this.f1254a.c.j.setText(forumListModel.forum_class[1]);
        this.f1254a.findViewById(R.id.item_root).setVisibility(0);
        this.f1254a.c.c();
        handler = this.f1254a.e;
        runnable = this.f1254a.P;
        handler.removeCallbacks(runnable);
        handler2 = this.f1254a.e;
        runnable2 = this.f1254a.P;
        handler2.post(runnable2);
    }
}
