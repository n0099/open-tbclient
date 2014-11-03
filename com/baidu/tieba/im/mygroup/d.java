package com.baidu.tieba.im.mygroup;

import android.widget.ImageView;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tieba.u;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
class d extends HttpMessageListener {
    final /* synthetic */ PersonGroupActivity bfQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(PersonGroupActivity personGroupActivity, int i) {
        super(i);
        this.bfQ = personGroupActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        int[] iArr;
        ImageView imageView;
        int[] iArr2;
        int[] iArr3;
        if (httpResponsedMessage.isSuccess()) {
            if (httpResponsedMessage.getError() == 0) {
                iArr = PersonGroupActivity.bfM;
                com.baidu.tbadk.core.account.o.k(3, iArr[this.bfQ.bfD]);
                imageView = this.bfQ.bfG;
                iArr2 = PersonGroupActivity.bfK;
                aw.c(imageView, iArr2[this.bfQ.bfD]);
                PersonGroupActivity personGroupActivity = this.bfQ;
                PersonGroupActivity personGroupActivity2 = this.bfQ;
                iArr3 = PersonGroupActivity.bfL;
                personGroupActivity.showToastWithIcon(personGroupActivity2.getString(iArr3[this.bfQ.bfD]), u.icon_toast_info);
                return;
            }
            this.bfQ.showToast(httpResponsedMessage.getErrorString());
            return;
        }
        this.bfQ.showToast(this.bfQ.getString(y.neterror));
    }
}
