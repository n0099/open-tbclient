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
    final /* synthetic */ c aDv;
    private final /* synthetic */ com.baidu.tieba.enterForum.b.b aDw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, com.baidu.tieba.enterForum.b.b bVar) {
        this.aDv = cVar;
        this.aDw = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.cache.u
    /* renamed from: j */
    public void onItemGet(String str, byte[] bArr) {
        Handler handler;
        if (bArr != null) {
            this.aDw.af(true);
            try {
                ForumRecommendResIdl forumRecommendResIdl = (ForumRecommendResIdl) new Wire(new Class[0]).parseFrom(bArr, ForumRecommendResIdl.class);
                if (forumRecommendResIdl.data != null && (forumRecommendResIdl.data instanceof DataRes)) {
                    this.aDw.a(forumRecommendResIdl.data);
                    this.aDw.bw(true);
                }
            } catch (Exception e) {
                this.aDw.af(false);
            }
            if (this.aDw.isSuccess() && !this.aDw.GA()) {
                this.aDw.Gz().GD();
            }
            BdLog.d("EnterForumTask,TYPE_DB,data.isEmpty=" + this.aDw.isEmpty());
            handler = this.aDv.mUIHandler;
            handler.post(new e(this, this.aDw));
        }
    }
}
