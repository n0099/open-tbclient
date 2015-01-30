package com.baidu.tieba.im.mygroup;

import android.content.Context;
import android.widget.ImageView;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tieba.v;
import com.baidu.tieba.z;
/* loaded from: classes.dex */
class c extends HttpMessageListener {
    final /* synthetic */ PersonGroupActivity bkz;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(PersonGroupActivity personGroupActivity, int i) {
        super(i);
        this.bkz = personGroupActivity;
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
                iArr = PersonGroupActivity.bkw;
                com.baidu.tbadk.core.account.o.n(3, iArr[this.bkz.bkn]);
                imageView = this.bkz.bkq;
                iArr2 = PersonGroupActivity.bku;
                bc.c(imageView, iArr2[this.bkz.bkn]);
                PersonGroupActivity personGroupActivity = this.bkz;
                Context context = this.bkz.getPageContext().getContext();
                iArr3 = PersonGroupActivity.bkv;
                personGroupActivity.showToastWithIcon(context.getString(iArr3[this.bkz.bkn]), v.icon_toast_info);
                return;
            }
            this.bkz.showToast(httpResponsedMessage.getErrorString());
            return;
        }
        this.bkz.showToast(this.bkz.getPageContext().getContext().getString(z.neterror));
    }
}
