package com.baidu.tieba.enterForum.c;

import android.os.Handler;
import com.baidu.adp.lib.cache.o;
import com.squareup.wire.Wire;
import tbclient.ForumRecommend.DataRes;
import tbclient.ForumRecommend.ForumRecommendResIdl;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements o.a<byte[]> {
    final /* synthetic */ c aUY;
    private final /* synthetic */ com.baidu.tieba.enterForum.b.b aUZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, com.baidu.tieba.enterForum.b.b bVar) {
        this.aUY = cVar;
        this.aUZ = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.cache.o.a
    /* renamed from: j */
    public void onItemGet(String str, byte[] bArr) {
        Handler handler;
        if (bArr != null) {
            this.aUZ.ap(true);
            try {
                ForumRecommendResIdl forumRecommendResIdl = (ForumRecommendResIdl) new Wire(new Class[0]).parseFrom(bArr, ForumRecommendResIdl.class);
                if (forumRecommendResIdl.data != null && (forumRecommendResIdl.data instanceof DataRes)) {
                    this.aUZ.a(forumRecommendResIdl.data);
                    this.aUZ.bY(true);
                }
            } catch (Exception e) {
                this.aUZ.ap(false);
            }
            if (this.aUZ.isSuccess() && !this.aUZ.JU()) {
                this.aUZ.JT().JX();
            }
            handler = this.aUY.mUIHandler;
            handler.post(new e(this, this.aUZ));
        }
    }
}
