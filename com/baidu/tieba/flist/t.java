package com.baidu.tieba.flist;

import android.content.Context;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.flist.ForumListModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t extends BdAsyncTask<Void, Void, ForumListModel> {
    ForumListModel awh;
    final /* synthetic */ r awi;

    private t(r rVar) {
        Context context;
        this.awi = rVar;
        context = rVar.mContext;
        this.awh = new ForumListModel(context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ t(r rVar, t tVar) {
        this(rVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: c */
    public void onProgressUpdate(Void... voidArr) {
        s sVar;
        boolean z;
        super.onProgressUpdate(voidArr);
        if (this.awh != null) {
            sVar = this.awi.awf;
            int errorCode = this.awh.getErrorCode();
            ForumListModel forumListModel = this.awh;
            String errorString = this.awh.getErrorString();
            z = this.awi.avd;
            sVar.a(true, errorCode, forumListModel, errorString, z);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: b */
    public ForumListModel doInBackground(Void... voidArr) {
        boolean z;
        Context context;
        ForumListModel.RequestParams requestParams;
        String str;
        ForumListModel.RequestParams requestParams2;
        try {
            z = this.awi.isFirst;
            if (z) {
                com.baidu.adp.lib.cache.t<String> bd = com.baidu.tbadk.core.a.a.kS().bd("tb.my_posts");
                if (bd != null) {
                    StringBuilder append = new StringBuilder(String.valueOf(TbadkApplication.getCurrentAccount())).append("_");
                    requestParams2 = this.awi.avz;
                    str = bd.get(append.append(requestParams2.menu_name).append("_list").toString());
                } else {
                    str = null;
                }
                if (str != null) {
                    this.awh = (ForumListModel) com.baidu.adp.lib.a.b.a.a.i.objectWithJsonStr(str, ForumListModel.class);
                    if (this.awh != null) {
                        publishProgress(new Void[0]);
                    }
                    this.awi.avd = true;
                }
            }
            this.awi.isFirst = false;
            context = this.awi.mContext;
            requestParams = this.awi.avz;
            return ForumListModel.new_fetch(context, requestParams);
        } catch (Exception e) {
            BdLog.detailException(e);
            return null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(ForumListModel forumListModel) {
        s sVar;
        Context context;
        boolean z;
        s sVar2;
        boolean z2;
        if (forumListModel == null || !forumListModel.isOk()) {
            sVar = this.awi.awf;
            context = this.awi.mContext;
            String string = context.getString(com.baidu.tieba.y.neterror);
            z = this.awi.avd;
            sVar.a(false, 0, forumListModel, string, z);
            return;
        }
        sVar2 = this.awi.awf;
        int errorCode = forumListModel.getErrorCode();
        String errorString = forumListModel.getErrorString();
        z2 = this.awi.avd;
        sVar2.a(true, errorCode, forumListModel, errorString, z2);
    }
}
