package com.baidu.tieba.enterForum.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.cache.o;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.enterForum.model.EnterForumModel;
import com.squareup.wire.Wire;
import tbclient.ForumRecommend.ForumRecommendResIdl;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends BdAsyncTask<Void, Void, com.baidu.tieba.enterForum.b.b> {
    final /* synthetic */ EnterForumModel bNf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(EnterForumModel enterForumModel) {
        this.bNf = enterForumModel;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public com.baidu.tieba.enterForum.b.b doInBackground(Void... voidArr) {
        o<byte[]> L = com.baidu.tbadk.core.c.a.sY().L("tb_forum_recommend", TbadkCoreApplication.getCurrentAccountName());
        com.baidu.tieba.enterForum.b.b bVar = new com.baidu.tieba.enterForum.b.b();
        byte[] bArr = L.get(EnterForumModel.FORUMRECOMMEND_CACHE_KEY);
        if (bArr != null) {
            bVar.ay(true);
            try {
                ForumRecommendResIdl forumRecommendResIdl = (ForumRecommendResIdl) new Wire(new Class[0]).parseFrom(bArr, ForumRecommendResIdl.class);
                if (forumRecommendResIdl.data != null) {
                    bVar.a(forumRecommendResIdl.data);
                    bVar.dH(true);
                }
            } catch (Exception e) {
                bVar.ay(false);
            }
            if (bVar.isSuccess() && !bVar.WY()) {
                bVar.WW().Xd();
            }
        }
        return bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: c */
    public void onPostExecute(com.baidu.tieba.enterForum.b.b bVar) {
        EnterForumModel.b bVar2;
        super.onPostExecute(bVar);
        EnterForumModel.a aVar = new EnterForumModel.a();
        aVar.type = 0;
        if (bVar != null && bVar.isSuccess()) {
            aVar.bNh = true;
            aVar.bNi = bVar;
        } else {
            aVar.bNh = false;
            aVar.bNi = bVar;
        }
        bVar2 = this.bNf.bMZ;
        bVar2.a(aVar);
    }
}
