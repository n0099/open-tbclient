package com.baidu.tieba.im.mygroup;

import android.content.Context;
import android.widget.ImageView;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tieba.v;
import com.baidu.tieba.z;
/* loaded from: classes.dex */
class c extends HttpMessageListener {
    final /* synthetic */ PersonGroupActivity bjc;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(PersonGroupActivity personGroupActivity, int i) {
        super(i);
        this.bjc = personGroupActivity;
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
                iArr = PersonGroupActivity.biZ;
                com.baidu.tbadk.core.account.o.n(3, iArr[this.bjc.biQ]);
                imageView = this.bjc.biT;
                iArr2 = PersonGroupActivity.biX;
                ax.c(imageView, iArr2[this.bjc.biQ]);
                PersonGroupActivity personGroupActivity = this.bjc;
                Context context = this.bjc.getPageContext().getContext();
                iArr3 = PersonGroupActivity.biY;
                personGroupActivity.showToastWithIcon(context.getString(iArr3[this.bjc.biQ]), v.icon_toast_info);
                return;
            }
            this.bjc.showToast(httpResponsedMessage.getErrorString());
            return;
        }
        this.bjc.showToast(this.bjc.getPageContext().getContext().getString(z.neterror));
    }
}
