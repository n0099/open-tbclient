package com.baidu.tieba.enterForum.c;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.cache.o;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.enterForum.c.c;
import com.squareup.wire.Wire;
import tbclient.ForumRecommend.ForumRecommendResIdl;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends BdAsyncTask<Void, Void, com.baidu.tieba.enterForum.b.b> {
    final /* synthetic */ c bHy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.bHy = cVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: e */
    public com.baidu.tieba.enterForum.b.b doInBackground(Void... voidArr) {
        o<byte[]> M = com.baidu.tbadk.core.b.a.sT().M("tb_forum_recommend", TbadkCoreApplication.getCurrentAccountName());
        com.baidu.tieba.enterForum.b.b bVar = new com.baidu.tieba.enterForum.b.b();
        byte[] bArr = M.get("forumRecommend_cache_key");
        if (bArr != null) {
            bVar.ax(true);
            try {
                ForumRecommendResIdl forumRecommendResIdl = (ForumRecommendResIdl) new Wire(new Class[0]).parseFrom(bArr, ForumRecommendResIdl.class);
                if (forumRecommendResIdl.data != null) {
                    bVar.a(forumRecommendResIdl.data);
                    bVar.dh(true);
                }
            } catch (Exception e) {
                bVar.ax(false);
            }
            if (bVar.isSuccess() && !bVar.Xf()) {
                bVar.Xe().Xk();
            }
        }
        return bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: f */
    public void onPostExecute(com.baidu.tieba.enterForum.b.b bVar) {
        c.b bVar2;
        super.onPostExecute(bVar);
        c.a aVar = new c.a();
        aVar.type = 0;
        if (bVar != null && bVar.isSuccess()) {
            aVar.bHA = true;
            aVar.bHB = bVar;
        } else {
            aVar.bHA = false;
            aVar.bHB = bVar;
        }
        bVar2 = this.bHy.bHs;
        bVar2.a(aVar);
    }
}
