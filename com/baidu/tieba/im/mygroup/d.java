package com.baidu.tieba.im.mygroup;

import android.widget.ImageView;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tieba.u;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
class d extends HttpMessageListener {
    final /* synthetic */ PersonGroupActivity bfC;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(PersonGroupActivity personGroupActivity, int i) {
        super(i);
        this.bfC = personGroupActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: b */
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        int[] iArr;
        ImageView imageView;
        int[] iArr2;
        int[] iArr3;
        if (httpResponsedMessage.isSuccess()) {
            if (httpResponsedMessage.getError() == 0) {
                iArr = PersonGroupActivity.bfy;
                com.baidu.tbadk.core.account.o.k(3, iArr[this.bfC.bfp]);
                imageView = this.bfC.bfs;
                iArr2 = PersonGroupActivity.bfw;
                aw.c(imageView, iArr2[this.bfC.bfp]);
                PersonGroupActivity personGroupActivity = this.bfC;
                PersonGroupActivity personGroupActivity2 = this.bfC;
                iArr3 = PersonGroupActivity.bfx;
                personGroupActivity.showToastWithIcon(personGroupActivity2.getString(iArr3[this.bfC.bfp]), u.icon_toast_info);
                return;
            }
            this.bfC.showToast(httpResponsedMessage.getErrorString());
            return;
        }
        this.bfC.showToast(this.bfC.getString(y.neterror));
    }
}
