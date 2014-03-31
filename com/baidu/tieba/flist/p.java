package com.baidu.tieba.flist;

import android.widget.ImageView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.gson.JsonParseException;
import com.baidu.tieba.flist.ForumListModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class p extends BdAsyncTask<Void, Void, ForumListModel> {
    boolean a;
    final /* synthetic */ ForumListActivity b;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* bridge */ /* synthetic */ ForumListModel a(Void... voidArr) {
        return a();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void a(ForumListModel forumListModel) {
        int i;
        int i2;
        int i3;
        int i4;
        ForumListModel.RequestParams requestParams;
        r rVar;
        r rVar2;
        int i5;
        int i6;
        int i7;
        ForumListModel forumListModel2 = forumListModel;
        if (forumListModel2 == null || forumListModel2.recommend_list_right == null) {
            this.b.showToast(this.b.getString(com.baidu.tieba.a.k.neterror));
            if (this.a) {
                this.b.c.q.setText(this.b.getString(com.baidu.tieba.a.k.flist_expand_list));
                ImageView imageView = this.b.c.r;
                i4 = this.b.l;
                imageView.setImageResource(i4);
                requestParams = this.b.A;
                requestParams.rn = 200;
                this.b.o = 200;
            } else {
                i = this.b.o;
                if (i == 200) {
                    this.b.c.q.setText(this.b.getString(com.baidu.tieba.a.k.flist_expand_list));
                    ImageView imageView2 = this.b.c.r;
                    i3 = this.b.l;
                    imageView2.setImageResource(i3);
                } else {
                    this.b.c.q.setText(this.b.getString(com.baidu.tieba.a.k.flist_collapse_list));
                    ImageView imageView3 = this.b.c.r;
                    i2 = this.b.m;
                    imageView3.setImageResource(i2);
                }
            }
        } else {
            int min = Math.min(forumListModel2.recommend_list_right.forum_list.length, this.b.b.forum_list.length);
            System.arraycopy(forumListModel2.recommend_list_right.forum_list, 0, this.b.b.forum_list, 0, min);
            rVar = this.b.E;
            rVar.a(min);
            rVar2 = this.b.E;
            rVar2.a(this.b.b.forum_list);
            i5 = this.b.o;
            if (i5 == 200) {
                this.b.c.q.setText(this.b.getString(com.baidu.tieba.a.k.flist_expand_list));
                ImageView imageView4 = this.b.c.r;
                i7 = this.b.l;
                imageView4.setImageResource(i7);
            } else {
                this.b.c.q.setText(this.b.getString(com.baidu.tieba.a.k.flist_collapse_list));
                ImageView imageView5 = this.b.c.r;
                i6 = this.b.m;
                imageView5.setImageResource(i6);
                this.b.C = true;
            }
        }
        this.b.c.p.setEnabled(true);
        this.b.c.a();
    }

    private p(ForumListActivity forumListActivity) {
        this.b = forumListActivity;
        this.a = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ p(ForumListActivity forumListActivity, byte b) {
        this(forumListActivity);
    }

    public final void a(boolean z) {
        this.a = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void c() {
        this.b.c.p.setEnabled(false);
        this.b.c.q.setText(this.b.getString(com.baidu.tieba.a.k.flist_loading));
    }

    private ForumListModel a() {
        ForumListModel.RequestParams requestParams;
        ForumListModel.RequestParams requestParams2;
        ForumListModel.RequestParams requestParams3;
        int i;
        ForumListModel.RequestParams requestParams4;
        try {
            requestParams = this.b.A;
            requestParams.recommend_type = 2;
            requestParams2 = this.b.A;
            requestParams2.offset = 0;
            requestParams3 = this.b.A;
            i = this.b.o;
            requestParams3.rn = i;
            ForumListActivity forumListActivity = this.b;
            requestParams4 = this.b.A;
            return ForumListModel.new_fetch(forumListActivity, requestParams4);
        } catch (JsonParseException e) {
            return null;
        }
    }
}
