package com.baidu.tieba.flist;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.lightapp.plugin.videoplayer.coreplayer.Constants;
import com.baidu.tieba.flist.ForumListModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n extends BdAsyncTask<Void, Void, ForumListModel> {
    final /* synthetic */ ForumListActivity avP;
    boolean avR;

    private n(ForumListActivity forumListActivity) {
        this.avP = forumListActivity;
        this.avR = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ n(ForumListActivity forumListActivity, n nVar) {
        this(forumListActivity);
    }

    public void bF(boolean z) {
        this.avR = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        this.avP.avy.awu.setEnabled(false);
        this.avP.avy.awv.setText(this.avP.getString(com.baidu.tieba.y.flist_loading));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: b */
    public ForumListModel doInBackground(Void... voidArr) {
        ForumListModel.RequestParams requestParams;
        ForumListModel.RequestParams requestParams2;
        ForumListModel.RequestParams requestParams3;
        int i;
        ForumListModel.RequestParams requestParams4;
        try {
            requestParams = this.avP.avz;
            requestParams.recommend_type = 2;
            requestParams2 = this.avP.avz;
            requestParams2.offset = 0;
            requestParams3 = this.avP.avz;
            i = this.avP.avp;
            requestParams3.rn = i;
            ForumListActivity forumListActivity = this.avP;
            requestParams4 = this.avP.avz;
            return ForumListModel.new_fetch(forumListActivity, requestParams4);
        } catch (Exception e) {
            return null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(ForumListModel forumListModel) {
        int i;
        Drawable drawable;
        Drawable drawable2;
        Drawable drawable3;
        ForumListModel.RequestParams requestParams;
        p pVar;
        p pVar2;
        int i2;
        Drawable drawable4;
        Drawable drawable5;
        if (forumListModel != null && forumListModel.recommend_list_right != null) {
            int min = Math.min(forumListModel.recommend_list_right.forum_list.length, this.avP.recommend_list_right.forum_list.length);
            System.arraycopy(forumListModel.recommend_list_right.forum_list, 0, this.avP.recommend_list_right.forum_list, 0, min);
            pVar = this.avP.avD;
            pVar.eA(min);
            pVar2 = this.avP.avD;
            pVar2.a(this.avP.recommend_list_right.forum_list);
            i2 = this.avP.avp;
            if (i2 == 200) {
                this.avP.avy.awv.setText(this.avP.getString(com.baidu.tieba.y.flist_expand_list));
                ImageView imageView = this.avP.avy.aww;
                drawable5 = this.avP.avm;
                imageView.setImageDrawable(drawable5);
            } else {
                this.avP.avy.awv.setText(this.avP.getString(com.baidu.tieba.y.flist_collapse_list));
                ImageView imageView2 = this.avP.avy.aww;
                drawable4 = this.avP.avn;
                imageView2.setImageDrawable(drawable4);
                this.avP.avB = true;
            }
        } else {
            this.avP.showToast(this.avP.getString(com.baidu.tieba.y.neterror));
            if (!this.avR) {
                i = this.avP.avp;
                if (i == 200) {
                    this.avP.avy.awv.setText(this.avP.getString(com.baidu.tieba.y.flist_expand_list));
                    ImageView imageView3 = this.avP.avy.aww;
                    drawable2 = this.avP.avm;
                    imageView3.setImageDrawable(drawable2);
                } else {
                    this.avP.avy.awv.setText(this.avP.getString(com.baidu.tieba.y.flist_collapse_list));
                    ImageView imageView4 = this.avP.avy.aww;
                    drawable = this.avP.avn;
                    imageView4.setImageDrawable(drawable);
                }
            } else {
                this.avP.avy.awv.setText(this.avP.getString(com.baidu.tieba.y.flist_expand_list));
                ImageView imageView5 = this.avP.avy.aww;
                drawable3 = this.avP.avm;
                imageView5.setImageDrawable(drawable3);
                requestParams = this.avP.avz;
                requestParams.rn = Constants.MEDIA_INFO;
                this.avP.avp = Constants.MEDIA_INFO;
            }
        }
        this.avP.avy.awu.setEnabled(true);
        this.avP.avy.DU();
    }
}
