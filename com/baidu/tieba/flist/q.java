package com.baidu.tieba.flist;

import android.widget.ImageView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.gson.JsonParseException;
import com.baidu.tieba.flist.ForumListModel;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class q extends BdAsyncTask<Void, Void, ForumListModel> {
    boolean a;
    final /* synthetic */ ForumListActivity b;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ ForumListModel a(Void... voidArr) {
        return d();
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
        if (forumListModel2 == null || forumListModel2.recommend_list_left == null) {
            this.b.showToast(this.b.getString(R.string.neterror));
            if (this.a) {
                this.b.c.m.setText(this.b.getString(R.string.flist_expand_list));
                ImageView imageView = this.b.c.n;
                i4 = this.b.l;
                imageView.setImageResource(i4);
                requestParams = this.b.A;
                requestParams.rn = 200;
                this.b.n = 200;
            } else {
                i = this.b.n;
                if (i == 200) {
                    this.b.c.m.setText(this.b.getString(R.string.flist_expand_list));
                    ImageView imageView2 = this.b.c.n;
                    i3 = this.b.l;
                    imageView2.setImageResource(i3);
                } else {
                    this.b.c.m.setText(this.b.getString(R.string.flist_collapse_list));
                    ImageView imageView3 = this.b.c.n;
                    i2 = this.b.m;
                    imageView3.setImageResource(i2);
                }
            }
        } else {
            int min = Math.min(forumListModel2.recommend_list_left.forum_list.length, this.b.a.forum_list.length);
            System.arraycopy(forumListModel2.recommend_list_left.forum_list, 0, this.b.a.forum_list, 0, min);
            rVar = this.b.D;
            rVar.a(min);
            rVar2 = this.b.D;
            rVar2.a(this.b.a.forum_list);
            i5 = this.b.n;
            if (i5 == 200) {
                this.b.c.m.setText(this.b.getString(R.string.flist_expand_list));
                ImageView imageView4 = this.b.c.n;
                i7 = this.b.l;
                imageView4.setImageResource(i7);
            } else {
                this.b.c.m.setText(this.b.getString(R.string.flist_collapse_list));
                ImageView imageView5 = this.b.c.n;
                i6 = this.b.m;
                imageView5.setImageResource(i6);
                this.b.B = true;
            }
        }
        this.b.c.l.setEnabled(true);
        this.b.c.a();
    }

    private q(ForumListActivity forumListActivity) {
        this.b = forumListActivity;
        this.a = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ q(ForumListActivity forumListActivity, byte b) {
        this(forumListActivity);
    }

    public final void a(boolean z) {
        this.a = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void b() {
        this.b.c.l.setEnabled(false);
        this.b.c.m.setText(this.b.getString(R.string.flist_loading));
    }

    private ForumListModel d() {
        ForumListModel.RequestParams requestParams;
        ForumListModel.RequestParams requestParams2;
        ForumListModel.RequestParams requestParams3;
        int i;
        ForumListModel.RequestParams requestParams4;
        try {
            requestParams = this.b.A;
            requestParams.recommend_type = 1;
            requestParams2 = this.b.A;
            requestParams2.offset = 0;
            requestParams3 = this.b.A;
            i = this.b.n;
            requestParams3.rn = i;
            ForumListActivity forumListActivity = this.b;
            requestParams4 = this.b.A;
            return ForumListModel.new_fetch(forumListActivity, requestParams4);
        } catch (JsonParseException e) {
            return null;
        }
    }
}
