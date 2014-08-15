package com.baidu.tieba.im.mygroup;

import android.widget.ImageView;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.core.util.ay;
/* loaded from: classes.dex */
class m extends HttpMessageListener {
    final /* synthetic */ PersonGroupActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(PersonGroupActivity personGroupActivity, int i) {
        super(i);
        this.a = personGroupActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        int[] iArr;
        ImageView imageView;
        int[] iArr2;
        int[] iArr3;
        if (httpResponsedMessage.isSuccess()) {
            if (httpResponsedMessage.getError() == 0) {
                iArr = PersonGroupActivity.s;
                com.baidu.tbadk.core.account.o.a(3, iArr[this.a.d]);
                imageView = this.a.m;
                iArr2 = PersonGroupActivity.q;
                ay.c(imageView, iArr2[this.a.d]);
                PersonGroupActivity personGroupActivity = this.a;
                PersonGroupActivity personGroupActivity2 = this.a;
                iArr3 = PersonGroupActivity.r;
                personGroupActivity.a(personGroupActivity2.getString(iArr3[this.a.d]), com.baidu.tieba.t.icon_toast_info);
                return;
            }
            this.a.a(httpResponsedMessage.getErrorString());
        }
    }
}
