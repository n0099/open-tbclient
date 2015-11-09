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
    final /* synthetic */ c aMy;
    private final /* synthetic */ com.baidu.tieba.enterForum.b.b aMz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, com.baidu.tieba.enterForum.b.b bVar) {
        this.aMy = cVar;
        this.aMz = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.cache.o.a
    /* renamed from: j */
    public void onItemGet(String str, byte[] bArr) {
        Handler handler;
        if (bArr != null) {
            this.aMz.ap(true);
            try {
                ForumRecommendResIdl forumRecommendResIdl = (ForumRecommendResIdl) new Wire(new Class[0]).parseFrom(bArr, ForumRecommendResIdl.class);
                if (forumRecommendResIdl.data != null && (forumRecommendResIdl.data instanceof DataRes)) {
                    this.aMz.a(forumRecommendResIdl.data);
                    this.aMz.bM(true);
                }
            } catch (Exception e) {
                this.aMz.ap(false);
            }
            if (this.aMz.isSuccess() && !this.aMz.Il()) {
                this.aMz.Ik().Io();
            }
            BdLog.d("EnterForumTask,TYPE_DB,data.isEmpty=" + this.aMz.isEmpty());
            handler = this.aMy.mUIHandler;
            handler.post(new e(this, this.aMz));
        }
    }
}
