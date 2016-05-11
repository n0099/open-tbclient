package com.baidu.tieba.enterForum.c;

import android.os.Handler;
import com.baidu.adp.lib.cache.o;
import com.squareup.wire.Wire;
import tbclient.ForumRecommend.DataRes;
import tbclient.ForumRecommend.ForumRecommendResIdl;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements o.a<byte[]> {
    final /* synthetic */ c aYc;
    private final /* synthetic */ com.baidu.tieba.enterForum.b.b aYd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, com.baidu.tieba.enterForum.b.b bVar) {
        this.aYc = cVar;
        this.aYd = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.cache.o.a
    /* renamed from: i */
    public void g(String str, byte[] bArr) {
        Handler handler;
        if (bArr != null) {
            this.aYd.av(true);
            try {
                ForumRecommendResIdl forumRecommendResIdl = (ForumRecommendResIdl) new Wire(new Class[0]).parseFrom(bArr, ForumRecommendResIdl.class);
                if (forumRecommendResIdl.data != null && (forumRecommendResIdl.data instanceof DataRes)) {
                    this.aYd.a(forumRecommendResIdl.data);
                    this.aYd.cp(true);
                }
            } catch (Exception e) {
                this.aYd.av(false);
            }
            if (this.aYd.isSuccess() && !this.aYd.Mh()) {
                this.aYd.Mg().Ml();
            }
            handler = this.aYc.mUIHandler;
            handler.post(new e(this, this.aYd));
        }
    }
}
