package com.baidu.tieba.frs;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dq extends HttpMessageListener {
    final /* synthetic */ Cdo a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dq(Cdo cdo, int i) {
        super(i);
        this.a = cdo;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        cr crVar;
        dr a;
        int a2;
        cr crVar2;
        if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1001701) {
            int statusCode = httpResponsedMessage.getStatusCode();
            int error = httpResponsedMessage.getError();
            if (statusCode == 200 && error == 0 && (httpResponsedMessage instanceof ImageForumListResponsedMessage)) {
                crVar = this.a.k;
                if (crVar == null) {
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
                crVar2 = this.a.k;
                crVar2.a(a2, imageForumListResponsedMessage.mJSONObject, a);
            }
        }
    }
}
