package com.baidu.tieba.flist;

import android.widget.ImageView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.model.ForumListModel;
import com.google.gson.JsonParseException;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o extends BdAsyncTask<Void, Void, ForumListModel> {

    /* renamed from: a  reason: collision with root package name */
    boolean f1199a;
    final /* synthetic */ ForumListActivity b;

    private o(ForumListActivity forumListActivity) {
        this.b = forumListActivity;
        this.f1199a = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ o(ForumListActivity forumListActivity, g gVar) {
        this(forumListActivity);
    }

    public void a(boolean z) {
        this.f1199a = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        this.b.c.o.setEnabled(false);
        this.b.c.p.setText(this.b.getString(R.string.flist_loading));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public ForumListModel a(Void... voidArr) {
        ForumListModel.RequestParams requestParams;
        ForumListModel.RequestParams requestParams2;
        ForumListModel.RequestParams requestParams3;
        int i;
        ForumListModel.RequestParams requestParams4;
        try {
            requestParams = this.b.z;
            requestParams.recommend_type = 2;
            requestParams2 = this.b.z;
            requestParams2.offset = 0;
            requestParams3 = this.b.z;
            i = this.b.p;
            requestParams3.rn = i;
            ForumListActivity forumListActivity = this.b;
            requestParams4 = this.b.z;
            return ForumListModel.new_fetch(forumListActivity, requestParams4);
        } catch (JsonParseException e) {
            return null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(ForumListModel forumListModel) {
        int i;
        int i2;
        int i3;
        int i4;
        ForumListModel.RequestParams requestParams;
        q qVar;
        q qVar2;
        int i5;
        int i6;
        int i7;
        if (forumListModel != null && forumListModel.recommend_list_right != null) {
            int min = Math.min(forumListModel.recommend_list_right.forum_list.length, this.b.b.forum_list.length);
            System.arraycopy(forumListModel.recommend_list_right.forum_list, 0, this.b.b.forum_list, 0, min);
            qVar = this.b.D;
            qVar.a(min);
            qVar2 = this.b.D;
            qVar2.a(this.b.b.forum_list);
            i5 = this.b.p;
            if (i5 == 10) {
                this.b.c.p.setText(this.b.getString(R.string.flist_expand_list));
                ImageView imageView = this.b.c.q;
                i7 = this.b.m;
                imageView.setImageResource(i7);
            } else {
                this.b.c.p.setText(this.b.getString(R.string.flist_collapse_list));
                ImageView imageView2 = this.b.c.q;
                i6 = this.b.n;
                imageView2.setImageResource(i6);
                this.b.B = true;
            }
        } else {
            this.b.a(this.b.getString(R.string.neterror));
            if (!this.f1199a) {
                i = this.b.p;
                if (i == 10) {
                    this.b.c.p.setText(this.b.getString(R.string.flist_expand_list));
                    ImageView imageView3 = this.b.c.q;
                    i3 = this.b.m;
                    imageView3.setImageResource(i3);
                } else {
                    this.b.c.p.setText(this.b.getString(R.string.flist_collapse_list));
                    ImageView imageView4 = this.b.c.q;
                    i2 = this.b.n;
                    imageView4.setImageResource(i2);
                }
            } else {
                this.b.c.p.setText(this.b.getString(R.string.flist_expand_list));
                ImageView imageView5 = this.b.c.q;
                i4 = this.b.m;
                imageView5.setImageResource(i4);
                requestParams = this.b.z;
                requestParams.rn = 10;
                this.b.p = 10;
            }
        }
        this.b.c.o.setEnabled(true);
        this.b.c.c();
    }
}
