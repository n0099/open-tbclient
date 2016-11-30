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
    final /* synthetic */ c bKz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.bKz = cVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: e */
    public com.baidu.tieba.enterForum.b.b doInBackground(Void... voidArr) {
        o<byte[]> M = com.baidu.tbadk.core.b.a.tm().M("tb_forum_recommend", TbadkCoreApplication.getCurrentAccountName());
        com.baidu.tieba.enterForum.b.b bVar = new com.baidu.tieba.enterForum.b.b();
        byte[] bArr = M.get("forumRecommend_cache_key");
        if (bArr != null) {
            bVar.aA(true);
            try {
                ForumRecommendResIdl forumRecommendResIdl = (ForumRecommendResIdl) new Wire(new Class[0]).parseFrom(bArr, ForumRecommendResIdl.class);
                if (forumRecommendResIdl.data != null) {
                    bVar.a(forumRecommendResIdl.data);
                    bVar.dn(true);
                }
            } catch (Exception e) {
                bVar.aA(false);
            }
            if (bVar.isSuccess() && !bVar.YA()) {
                bVar.Yz().YF();
            }
        }
        return bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: e */
    public void onPostExecute(com.baidu.tieba.enterForum.b.b bVar) {
        c.b bVar2;
        super.onPostExecute(bVar);
        c.a aVar = new c.a();
        aVar.type = 0;
        if (bVar != null && bVar.isSuccess()) {
            aVar.bKB = true;
            aVar.bKC = bVar;
        } else {
            aVar.bKB = false;
            aVar.bKC = bVar;
        }
        bVar2 = this.bKz.bKt;
        bVar2.a(aVar);
    }
}
