package com.baidu.tieba.im.mygroup;

import android.content.Context;
import android.widget.ImageView;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.u;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
class c extends HttpMessageListener {
    final /* synthetic */ PersonGroupActivity blD;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(PersonGroupActivity personGroupActivity, int i) {
        super(i);
        this.blD = personGroupActivity;
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
                iArr = PersonGroupActivity.blA;
                com.baidu.tbadk.core.a.j.l(3, iArr[this.blD.blr]);
                imageView = this.blD.blu;
                iArr2 = PersonGroupActivity.bly;
                ba.c(imageView, iArr2[this.blD.blr]);
                PersonGroupActivity personGroupActivity = this.blD;
                Context context = this.blD.getPageContext().getContext();
                iArr3 = PersonGroupActivity.blz;
                personGroupActivity.showToastWithIcon(context.getString(iArr3[this.blD.blr]), u.icon_toast_info);
                return;
            }
            this.blD.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? this.blD.getResources().getString(y.neterror) : httpResponsedMessage.getErrorString());
            return;
        }
        this.blD.showToast(this.blD.getPageContext().getContext().getString(y.neterror));
    }
}
