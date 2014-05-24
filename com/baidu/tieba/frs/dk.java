package com.baidu.tieba.frs;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dk extends HttpMessageListener {
    final /* synthetic */ di a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dk(di diVar, int i) {
        super(i);
        this.a = diVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        cp cpVar;
        dl a;
        int a2;
        cp cpVar2;
        if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1007002) {
            int statusCode = httpResponsedMessage.getStatusCode();
            int error = httpResponsedMessage.getError();
            if (statusCode == 200 && error == 0 && (httpResponsedMessage instanceof ImageForumListResponsedMessage)) {
                cpVar = this.a.k;
                if (cpVar == null) {
                    return;
                }
                a = this.a.a(httpResponsedMessage, statusCode, error);
                a2 = this.a.a(httpResponsedMessage);
                ImageForumListResponsedMessage imageForumListResponsedMessage = (ImageForumListResponsedMessage) httpResponsedMessage;
                this.a.a = imageForumListResponsedMessage.mForum;
                this.a.b = imageForumListResponsedMessage.mThread;
                this.a.c = imageForumListResponsedMessage.mIdList;
                this.a.d = imageForumListResponsedMessage.mHasMore;
                this.a.e = imageForumListResponsedMessage.mTotal;
                this.a.f = imageForumListResponsedMessage.mCurrentCount;
                this.a.g = imageForumListResponsedMessage.mAnti;
                this.a.h = imageForumListResponsedMessage.mOwner;
                cpVar2 = this.a.k;
                cpVar2.a(a2, imageForumListResponsedMessage.mJSONObject, a);
            }
        }
    }
}
