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
    final /* synthetic */ EnterForumModel bFw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(EnterForumModel enterForumModel) {
        this.bFw = enterForumModel;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: e */
    public com.baidu.tieba.enterForum.b.b doInBackground(Void... voidArr) {
        o<byte[]> K = com.baidu.tbadk.core.c.a.to().K("tb_forum_recommend", TbadkCoreApplication.getCurrentAccountName());
        com.baidu.tieba.enterForum.b.b bVar = new com.baidu.tieba.enterForum.b.b();
        byte[] bArr = K.get(EnterForumModel.FORUMRECOMMEND_CACHE_KEY);
        if (bArr != null) {
            bVar.aA(true);
            try {
                ForumRecommendResIdl forumRecommendResIdl = (ForumRecommendResIdl) new Wire(new Class[0]).parseFrom(bArr, ForumRecommendResIdl.class);
                if (forumRecommendResIdl.data != null) {
                    bVar.a(forumRecommendResIdl.data);
                    bVar.dc(true);
                }
            } catch (Exception e) {
                bVar.aA(false);
            }
            if (bVar.isSuccess() && !bVar.Ve()) {
                bVar.Vd().Vj();
            }
        }
        return bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: e */
    public void onPostExecute(com.baidu.tieba.enterForum.b.b bVar) {
        EnterForumModel.b bVar2;
        super.onPostExecute(bVar);
        EnterForumModel.a aVar = new EnterForumModel.a();
        aVar.type = 0;
        if (bVar != null && bVar.isSuccess()) {
            aVar.bFy = true;
            aVar.bFz = bVar;
        } else {
            aVar.bFy = false;
            aVar.bFz = bVar;
        }
        bVar2 = this.bFw.bFq;
        bVar2.a(aVar);
    }
}
