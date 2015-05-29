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
    final /* synthetic */ c aFx;
    private final /* synthetic */ com.baidu.tieba.enterForum.b.b aFy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, com.baidu.tieba.enterForum.b.b bVar) {
        this.aFx = cVar;
        this.aFy = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.cache.u
    /* renamed from: j */
    public void onItemGet(String str, byte[] bArr) {
        Handler handler;
        if (bArr != null) {
            this.aFy.al(true);
            try {
                ForumRecommendResIdl forumRecommendResIdl = (ForumRecommendResIdl) new Wire(new Class[0]).parseFrom(bArr, ForumRecommendResIdl.class);
                if (forumRecommendResIdl.data != null && (forumRecommendResIdl.data instanceof DataRes)) {
                    this.aFy.a(forumRecommendResIdl.data);
                    this.aFy.bG(true);
                }
            } catch (Exception e) {
                this.aFy.al(false);
            }
            if (this.aFy.isSuccess() && !this.aFy.HE()) {
                this.aFy.HD().HH();
            }
            BdLog.d("EnterForumTask,TYPE_DB,data.isEmpty=" + this.aFy.isEmpty());
            handler = this.aFx.mUIHandler;
            handler.post(new e(this, this.aFy));
        }
    }
}
