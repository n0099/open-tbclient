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
    final /* synthetic */ PersonGroupActivity bln;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(PersonGroupActivity personGroupActivity, int i) {
        super(i);
        this.bln = personGroupActivity;
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
                iArr = PersonGroupActivity.blk;
                com.baidu.tbadk.core.a.j.l(3, iArr[this.bln.blb]);
                imageView = this.bln.ble;
                iArr2 = PersonGroupActivity.bli;
                ba.c(imageView, iArr2[this.bln.blb]);
                PersonGroupActivity personGroupActivity = this.bln;
                Context context = this.bln.getPageContext().getContext();
                iArr3 = PersonGroupActivity.blj;
                personGroupActivity.showToastWithIcon(context.getString(iArr3[this.bln.blb]), u.icon_toast_info);
                return;
            }
            this.bln.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? this.bln.getResources().getString(y.neterror) : httpResponsedMessage.getErrorString());
            return;
        }
        this.bln.showToast(this.bln.getPageContext().getContext().getString(y.neterror));
    }
}
