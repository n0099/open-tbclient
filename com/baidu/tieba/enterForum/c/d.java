package com.baidu.tieba.enterForum.c;

import android.os.Handler;
import com.baidu.adp.lib.cache.o;
import com.squareup.wire.Wire;
import tbclient.ForumRecommend.DataRes;
import tbclient.ForumRecommend.ForumRecommendResIdl;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements o.a<byte[]> {
    final /* synthetic */ c aRh;
    private final /* synthetic */ com.baidu.tieba.enterForum.b.b aRi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, com.baidu.tieba.enterForum.b.b bVar) {
        this.aRh = cVar;
        this.aRi = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.cache.o.a
    /* renamed from: j */
    public void onItemGet(String str, byte[] bArr) {
        Handler handler;
        if (bArr != null) {
            this.aRi.as(true);
            try {
                ForumRecommendResIdl forumRecommendResIdl = (ForumRecommendResIdl) new Wire(new Class[0]).parseFrom(bArr, ForumRecommendResIdl.class);
                if (forumRecommendResIdl.data != null && (forumRecommendResIdl.data instanceof DataRes)) {
                    this.aRi.a(forumRecommendResIdl.data);
                    this.aRi.bX(true);
                }
            } catch (Exception e) {
                this.aRi.as(false);
            }
            if (this.aRi.isSuccess() && !this.aRi.JD()) {
                this.aRi.JC().JG();
            }
            handler = this.aRh.mUIHandler;
            handler.post(new e(this, this.aRi));
        }
    }
}
