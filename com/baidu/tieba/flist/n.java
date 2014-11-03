package com.baidu.tieba.flist;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.lightapp.plugin.videoplayer.coreplayer.Constants;
import com.baidu.tieba.flist.ForumListModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n extends BdAsyncTask<Void, Void, ForumListModel> {
    final /* synthetic */ ForumListActivity avY;
    boolean awa;

    private n(ForumListActivity forumListActivity) {
        this.avY = forumListActivity;
        this.awa = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ n(ForumListActivity forumListActivity, n nVar) {
        this(forumListActivity);
    }

    public void bF(boolean z) {
        this.awa = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        this.avY.avH.awD.setEnabled(false);
        this.avY.avH.awE.setText(this.avY.getString(com.baidu.tieba.y.flist_loading));
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
            requestParams = this.avY.avI;
            requestParams.recommend_type = 2;
            requestParams2 = this.avY.avI;
            requestParams2.offset = 0;
            requestParams3 = this.avY.avI;
            i = this.avY.avy;
            requestParams3.rn = i;
            ForumListActivity forumListActivity = this.avY;
            requestParams4 = this.avY.avI;
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
            int min = Math.min(forumListModel.recommend_list_right.forum_list.length, this.avY.recommend_list_right.forum_list.length);
            System.arraycopy(forumListModel.recommend_list_right.forum_list, 0, this.avY.recommend_list_right.forum_list, 0, min);
            pVar = this.avY.avM;
            pVar.eA(min);
            pVar2 = this.avY.avM;
            pVar2.a(this.avY.recommend_list_right.forum_list);
            i2 = this.avY.avy;
            if (i2 == 200) {
                this.avY.avH.awE.setText(this.avY.getString(com.baidu.tieba.y.flist_expand_list));
                ImageView imageView = this.avY.avH.awF;
                drawable5 = this.avY.avv;
                imageView.setImageDrawable(drawable5);
            } else {
                this.avY.avH.awE.setText(this.avY.getString(com.baidu.tieba.y.flist_collapse_list));
                ImageView imageView2 = this.avY.avH.awF;
                drawable4 = this.avY.avw;
                imageView2.setImageDrawable(drawable4);
                this.avY.avK = true;
            }
        } else {
            this.avY.showToast(this.avY.getString(com.baidu.tieba.y.neterror));
            if (!this.awa) {
                i = this.avY.avy;
                if (i == 200) {
                    this.avY.avH.awE.setText(this.avY.getString(com.baidu.tieba.y.flist_expand_list));
                    ImageView imageView3 = this.avY.avH.awF;
                    drawable2 = this.avY.avv;
                    imageView3.setImageDrawable(drawable2);
                } else {
                    this.avY.avH.awE.setText(this.avY.getString(com.baidu.tieba.y.flist_collapse_list));
                    ImageView imageView4 = this.avY.avH.awF;
                    drawable = this.avY.avw;
                    imageView4.setImageDrawable(drawable);
                }
            } else {
                this.avY.avH.awE.setText(this.avY.getString(com.baidu.tieba.y.flist_expand_list));
                ImageView imageView5 = this.avY.avH.awF;
                drawable3 = this.avY.avv;
                imageView5.setImageDrawable(drawable3);
                requestParams = this.avY.avI;
                requestParams.rn = Constants.MEDIA_INFO;
                this.avY.avy = Constants.MEDIA_INFO;
            }
        }
        this.avY.avH.awD.setEnabled(true);
        this.avY.avH.DW();
    }
}
