package com.baidu.tieba.flist;

import android.widget.ImageView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.model.ForumListModel;
import com.google.gson.JsonParseException;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n extends BdAsyncTask {

    /* renamed from: a  reason: collision with root package name */
    boolean f1049a;
    final /* synthetic */ ForumListActivity b;

    private n(ForumListActivity forumListActivity) {
        this.b = forumListActivity;
        this.f1049a = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ n(ForumListActivity forumListActivity, n nVar) {
        this(forumListActivity);
    }

    public void a(boolean z) {
        this.f1049a = z;
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
            requestParams = this.b.x;
            requestParams.recommend_type = 2;
            requestParams2 = this.b.x;
            requestParams2.offset = 0;
            requestParams3 = this.b.x;
            i = this.b.o;
            requestParams3.rn = i;
            ForumListActivity forumListActivity = this.b;
            requestParams4 = this.b.x;
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
        p pVar;
        p pVar2;
        int i5;
        int i6;
        int i7;
        if (forumListModel != null && forumListModel.recommend_list_right != null) {
            System.arraycopy(forumListModel.recommend_list_right.forum_list, 0, this.b.b.forum_list, 0, forumListModel.recommend_list_right.forum_list.length);
            pVar = this.b.B;
            pVar.a(forumListModel.recommend_list_right.forum_list.length);
            pVar2 = this.b.B;
            pVar2.a(this.b.b.forum_list);
            i5 = this.b.o;
            if (i5 == 10) {
                this.b.c.p.setText(this.b.getString(R.string.flist_expand_list));
                ImageView imageView = this.b.c.q;
                i7 = this.b.l;
                imageView.setImageResource(i7);
            } else {
                this.b.c.p.setText(this.b.getString(R.string.flist_collapse_list));
                ImageView imageView2 = this.b.c.q;
                i6 = this.b.m;
                imageView2.setImageResource(i6);
                this.b.z = true;
            }
        } else {
            this.b.a(this.b.getString(R.string.neterror));
            if (!this.f1049a) {
                i = this.b.o;
                if (i == 10) {
                    this.b.c.p.setText(this.b.getString(R.string.flist_expand_list));
                    ImageView imageView3 = this.b.c.q;
                    i3 = this.b.l;
                    imageView3.setImageResource(i3);
                } else {
                    this.b.c.p.setText(this.b.getString(R.string.flist_collapse_list));
                    ImageView imageView4 = this.b.c.q;
                    i2 = this.b.m;
                    imageView4.setImageResource(i2);
                }
            } else {
                this.b.c.p.setText(this.b.getString(R.string.flist_expand_list));
                ImageView imageView5 = this.b.c.q;
                i4 = this.b.l;
                imageView5.setImageResource(i4);
                requestParams = this.b.x;
                requestParams.rn = 10;
                this.b.o = 10;
            }
        }
        this.b.c.o.setEnabled(true);
        this.b.c.c();
    }
}
