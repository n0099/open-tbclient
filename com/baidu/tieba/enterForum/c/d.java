package com.baidu.tieba.enterForum.c;

import android.os.Handler;
import com.baidu.adp.lib.cache.o;
import com.baidu.adp.lib.util.BdLog;
import com.squareup.wire.Wire;
import tbclient.ForumRecommend.DataRes;
import tbclient.ForumRecommend.ForumRecommendResIdl;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements o.a<byte[]> {
    final /* synthetic */ c aNk;
    private final /* synthetic */ com.baidu.tieba.enterForum.b.b aNl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, com.baidu.tieba.enterForum.b.b bVar) {
        this.aNk = cVar;
        this.aNl = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.cache.o.a
    /* renamed from: j */
    public void onItemGet(String str, byte[] bArr) {
        Handler handler;
        if (bArr != null) {
            this.aNl.ap(true);
            try {
                ForumRecommendResIdl forumRecommendResIdl = (ForumRecommendResIdl) new Wire(new Class[0]).parseFrom(bArr, ForumRecommendResIdl.class);
                if (forumRecommendResIdl.data != null && (forumRecommendResIdl.data instanceof DataRes)) {
                    this.aNl.a(forumRecommendResIdl.data);
                    this.aNl.bN(true);
                }
            } catch (Exception e) {
                this.aNl.ap(false);
            }
            if (this.aNl.isSuccess() && !this.aNl.If()) {
                this.aNl.Ie().Ih();
            }
            BdLog.d("EnterForumTask,TYPE_DB,data.isEmpty=" + this.aNl.isEmpty());
            handler = this.aNk.mUIHandler;
            handler.post(new e(this, this.aNl));
        }
    }
}
