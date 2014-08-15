package com.baidu.tieba.flist;

import android.content.Context;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.gson.GsonBuilder;
import com.baidu.gson.JsonParseException;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.flist.ForumListModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t extends BdAsyncTask<Void, Void, ForumListModel> {
    ForumListModel a;
    final /* synthetic */ r b;

    private t(r rVar) {
        this.b = rVar;
        this.a = new ForumListModel();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ t(r rVar, t tVar) {
        this(rVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onProgressUpdate(Void... voidArr) {
        s sVar;
        boolean z;
        super.onProgressUpdate(voidArr);
        if (this.a != null) {
            sVar = this.b.c;
            int errorCode = this.a.getErrorCode();
            ForumListModel forumListModel = this.a;
            String errorString = this.a.getErrorString();
            z = this.b.f;
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
            z = this.b.e;
            if (z) {
                com.baidu.adp.lib.cache.t<String> b = com.baidu.tbadk.core.a.a.a().b("tb.my_posts");
                if (b != null) {
                    StringBuilder append = new StringBuilder(String.valueOf(TbadkApplication.getCurrentAccount())).append("_");
                    requestParams2 = this.b.b;
                    str = b.a(append.append(requestParams2.menu_name).append("_list").toString());
                } else {
                    str = null;
                }
                if (str != null) {
                    this.a = (ForumListModel) new GsonBuilder().create().fromJson(str, (Class<Object>) ForumListModel.class);
                    if (this.a != null) {
                        publishProgress(new Void[0]);
                    }
                    this.b.f = true;
                }
            }
            this.b.e = false;
            context = this.b.a;
            requestParams = this.b.b;
            return ForumListModel.new_fetch(context, requestParams);
        } catch (JsonParseException e) {
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
            sVar = this.b.c;
            context = this.b.a;
            String string = context.getString(com.baidu.tieba.x.neterror);
            z = this.b.f;
            sVar.a(false, 0, forumListModel, string, z);
            return;
        }
        sVar2 = this.b.c;
        int errorCode = forumListModel.getErrorCode();
        String errorString = forumListModel.getErrorString();
        z2 = this.b.f;
        sVar2.a(true, errorCode, forumListModel, errorString, z2);
    }
}
