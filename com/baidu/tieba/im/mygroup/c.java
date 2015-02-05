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
    final /* synthetic */ PersonGroupActivity bky;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(PersonGroupActivity personGroupActivity, int i) {
        super(i);
        this.bky = personGroupActivity;
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
                iArr = PersonGroupActivity.bkv;
                com.baidu.tbadk.core.account.o.n(3, iArr[this.bky.bkm]);
                imageView = this.bky.bkp;
                iArr2 = PersonGroupActivity.bkt;
                bc.c(imageView, iArr2[this.bky.bkm]);
                PersonGroupActivity personGroupActivity = this.bky;
                Context context = this.bky.getPageContext().getContext();
                iArr3 = PersonGroupActivity.bku;
                personGroupActivity.showToastWithIcon(context.getString(iArr3[this.bky.bkm]), v.icon_toast_info);
                return;
            }
            this.bky.showToast(httpResponsedMessage.getErrorString());
            return;
        }
        this.bky.showToast(this.bky.getPageContext().getContext().getString(z.neterror));
    }
}
