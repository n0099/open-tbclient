package com.baidu.tieba.enterForum.c;

import android.os.Handler;
import com.baidu.adp.lib.cache.u;
import com.baidu.adp.lib.util.BdLog;
import com.squareup.wire.Wire;
import tbclient.ForumRecommend.DataRes;
import tbclient.ForumRecommend.ForumRecommendResIdl;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements u<byte[]> {
    final /* synthetic */ c aDn;
    private final /* synthetic */ com.baidu.tieba.enterForum.b.b aDo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, com.baidu.tieba.enterForum.b.b bVar) {
        this.aDn = cVar;
        this.aDo = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.cache.u
    /* renamed from: j */
    public void onItemGet(String str, byte[] bArr) {
        Handler handler;
        if (bArr != null) {
            this.aDo.af(true);
            try {
                ForumRecommendResIdl forumRecommendResIdl = (ForumRecommendResIdl) new Wire(new Class[0]).parseFrom(bArr, ForumRecommendResIdl.class);
                if (forumRecommendResIdl.data != null && (forumRecommendResIdl.data instanceof DataRes)) {
                    this.aDo.a(forumRecommendResIdl.data);
                    this.aDo.bw(true);
                }
            } catch (Exception e) {
                this.aDo.af(false);
            }
            if (this.aDo.isSuccess() && !this.aDo.Gu()) {
                this.aDo.Gt().Gx();
            }
            BdLog.d("EnterForumTask,TYPE_DB,data.isEmpty=" + this.aDo.isEmpty());
            handler = this.aDn.mUIHandler;
            handler.post(new e(this, this.aDo));
        }
    }
}
