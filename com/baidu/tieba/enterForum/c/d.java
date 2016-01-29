package com.baidu.tieba.enterForum.c;

import android.os.Handler;
import com.baidu.adp.lib.cache.o;
import com.squareup.wire.Wire;
import tbclient.ForumRecommend.DataRes;
import tbclient.ForumRecommend.ForumRecommendResIdl;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements o.a<byte[]> {
    final /* synthetic */ c aXk;
    private final /* synthetic */ com.baidu.tieba.enterForum.b.b aXl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, com.baidu.tieba.enterForum.b.b bVar) {
        this.aXk = cVar;
        this.aXl = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.cache.o.a
    /* renamed from: j */
    public void h(String str, byte[] bArr) {
        Handler handler;
        if (bArr != null) {
            this.aXl.aq(true);
            try {
                ForumRecommendResIdl forumRecommendResIdl = (ForumRecommendResIdl) new Wire(new Class[0]).parseFrom(bArr, ForumRecommendResIdl.class);
                if (forumRecommendResIdl.data != null && (forumRecommendResIdl.data instanceof DataRes)) {
                    this.aXl.a(forumRecommendResIdl.data);
                    this.aXl.bW(true);
                }
            } catch (Exception e) {
                this.aXl.aq(false);
            }
            if (this.aXl.isSuccess() && !this.aXl.LK()) {
                this.aXl.LJ().LO();
            }
            handler = this.aXk.mUIHandler;
            handler.post(new e(this, this.aXl));
        }
    }
}
